package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Locale;
import java.util.Random;

/**
 * Плавное наведение. Цель выбирается в тике (20 Гц), поворот считается каждый кадр (MouseMixin).
 */
public class AimAssist extends Module {

    private final IntSetting speed = add(new IntSetting("Скорость",
            "Общая скорость наведения", 70, 10, 180) {
        @Override public String display() { return get() + "%"; }
    });

    private final IntSetting smooth = add(new IntSetting("Плавность",
            "Чем больше, тем мягче разгон и торможение", 6, 1, 10));

    private final IntSetting fov = add(new IntSetting("Угол обзора",
            "Конус вокруг прицела, в котором ищется цель", 70, 10, 360) {
        @Override public String display() { return get() + "°"; }
    });

    private final FloatSetting range = add(new FloatSetting("Дистанция",
            "Максимальная дальность", 4.0f, 1.0f, 8.0f, 0.1f) {
        @Override public String display() { return String.format(Locale.ROOT, "%.1f м", get()); }
    });

    private final IntSetting vertical = add(new IntSetting("По вертикали",
            "Сила наведения по вертикали", 60, 0, 100) {
        @Override public String display() { return get() + "%"; }
    });

    private final ModeSetting items = add(new ModeSetting("Предметы",
            "С какими предметами работает", 0, "Оружие", "Мечи", "Топоры", "Любое"));

    private final BoolSetting gcdFix = add(new BoolSetting("GCD",
            "Квантование под чувствительность мыши", true));
    private final BoolSetting clickOnly = add(new BoolSetting("Только с кликом",
            "Работает только пока зажата атака", false));
    private final BoolSetting players = add(new BoolSetting("Игроки", "Наводиться на игроков", true));
    private final BoolSetting mobs = add(new BoolSetting("Мобы", "Наводиться на мобов", false));
    private final BoolSetting throughWalls = add(new BoolSetting("Сквозь стены",
            "Не проверять видимость цели", false));

    private final Random rng = new Random();

    private LivingEntity target = null;
    private boolean active = false;

    private long lastFrameNs = 0L;
    private double velYaw = 0, velPitch = 0;   // град/сек
    private double engageT = 0;                // плавный вход после захвата
    private double accYaw = 0, accPitch = 0;   // накопитель для GCD

    // дрейф точки прицеливания внутри хитбокса
    private double offX = 0, offY = 0, offZ = 0;
    private double goalX = 0, goalY = 0, goalZ = 0;
    private int retargetIn = 0;

    public AimAssist() { super("AimAssist", Category.COMBAT); }

    // ---------------- ТИК: выбор цели ----------------
    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || client.world == null) { active = false; target = null; return; }

        if (!isEnabled() || client.currentScreen != null || player.isDead()
                || !itemOk(player.getMainHandStack())
                || (clickOnly.get() && !client.options.attackKey.isPressed())) {
            active = false;
            target = null;
            return;
        }

        LivingEntity picked = pickTarget(client, player);
        if (picked != target) {
            engageT = 0;
            retargetIn = 0;
        }
        target = picked;
        active = target != null;

        if (active) updateDrift(target);
    }

    // ---------------- КАДР: поворот (из MouseMixin) ----------------
    public void onFrame() {
        long now = System.nanoTime();
        double dt = lastFrameNs == 0L ? 0.016 : (now - lastFrameNs) / 1.0E9;
        lastFrameNs = now;
        dt = MathHelper.clamp(dt, 0.0005, 0.1);

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || client.world == null) return;

        if (!isEnabled() || !active || target == null || !target.isAlive()
                || client.currentScreen != null
                || (clickOnly.get() && !client.options.attackKey.isPressed())) {
            velYaw = 0;
            velPitch = 0;
            accYaw = 0;
            accPitch = 0;
            return;
        }

        float yaw = player.getYaw();
        float pitch = player.getPitch();

        Vec3d aim = aimPoint(target);
        Vec3d to = aim.subtract(player.getEyePos());

        double yawT = MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(to.z, to.x)) - 90.0);
        double pitchT = -Math.toDegrees(Math.atan2(to.y, Math.hypot(to.x, to.z)));

        double errYaw = MathHelper.wrapDegrees(yawT - yaw);
        double errPitch = pitchT - pitch;

        // уже на цели: плавно гасим скорость
        if (Math.hypot(errYaw, errPitch) < 0.6) {
            double k = Math.exp(-dt * 20.0);
            velYaw *= k;
            velPitch *= k;
            return;
        }

        // плавный вход за 0.25 сек (smoothstep)
        engageT = Math.min(0.25, engageT + dt);
        double r = engageT / 0.25;
        double ramp = r * r * (3 - 2 * r);

        double base = speed.get() / 100.0;
        double rate = 5.0 * base * ramp;     // 1/сек
        double maxV = 220.0 * base;          // град/сек

        double wantYaw = MathHelper.clamp(errYaw * rate, -maxV, maxV);
        double wantPitch = MathHelper.clamp(errPitch * rate * (vertical.get() / 100.0), -maxV, maxV);

        // сглаживание самой скорости
        double tau = 0.02 + smooth.get() * 0.015;
        double a = 1.0 - Math.exp(-dt / tau);
        velYaw += (wantYaw - velYaw) * a;
        velPitch += (wantPitch - velPitch) * a;

        double stepYaw = velYaw * dt;
        double stepPitch = velPitch * dt;

        // не перескакиваем цель
        if (stepYaw * errYaw > 0 && Math.abs(stepYaw) > Math.abs(errYaw)) stepYaw = errYaw;
        if (stepPitch * errPitch > 0 && Math.abs(stepPitch) > Math.abs(errPitch)) stepPitch = errPitch;

        double ay = stepYaw, ap = stepPitch;
        if (gcdFix.get()) {
            double gcd = gcd(client);
            accYaw += stepYaw;
            accPitch += stepPitch;
            ay = Math.round(accYaw / gcd) * gcd;
            ap = Math.round(accPitch / gcd) * gcd;
            accYaw -= ay;
            accPitch -= ap;
        }

        if (ay != 0.0 || ap != 0.0) {
            player.setYaw((float) (yaw + ay));
            player.setPitch(MathHelper.clamp((float) (pitch + ap), -90f, 90f));
        }
    }

    /** Текущая цель аима (null, если аим не ведёт никого). Нужна TriggerBot. */
    public LivingEntity getTarget() {
        return (isEnabled() && active) ? target : null;
    }

    // ---------------------------------------------------------------

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        if (!v) {
            active = false;
            target = null;
            velYaw = 0;
            velPitch = 0;
            engageT = 0;
            accYaw = 0;
            accPitch = 0;
        }
    }

    private double gcd(MinecraftClient client) {
        double sens = client.options.getMouseSensitivity().getValue();
        double f = sens * 0.6 + 0.2;
        return Math.max(f * f * f * 8.0 * 0.15, 1.0E-4);
    }

    private boolean itemOk(ItemStack s) {
        return switch (items.get()) {
            case 0 -> s.isIn(ItemTags.SWORDS) || s.isIn(ItemTags.AXES) || s.isOf(Items.MACE);
            case 1 -> s.isIn(ItemTags.SWORDS);
            case 2 -> s.isIn(ItemTags.AXES);
            default -> true;
        };
    }

    private boolean valid(ClientPlayerEntity player, Entity e) {
        if (!(e instanceof LivingEntity le) || e == player) return false;
        if (!le.isAlive() || le.isSpectator() || e instanceof ArmorStandEntity) return false;

        if (e instanceof PlayerEntity) {
            if (!players.get()) return false;
            if (NoFriendDamage.isProtected(e)) return false;
        } else if (!mobs.get()) {
            return false;
        }

        if (player.getEyePos().distanceTo(e.getBoundingBox().getCenter()) > range.get()) return false;
        return throughWalls.get() || player.canSee(e);
    }

    private double angleTo(ClientPlayerEntity player, Vec3d point) {
        Vec3d to = point.subtract(player.getEyePos());
        double yawT = MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(to.z, to.x)) - 90.0);
        double pitchT = -Math.toDegrees(Math.atan2(to.y, Math.hypot(to.x, to.z)));
        double dy = MathHelper.wrapDegrees(yawT - player.getYaw());
        double dp = pitchT - player.getPitch();
        return Math.hypot(dy, dp);
    }

    /** Ближайшая к прицелу цель в конусе. Текущую держим, пока она подходит. */
    private LivingEntity pickTarget(MinecraftClient client, ClientPlayerEntity player) {
        double half = fov.get() / 2.0;

        if (target != null && valid(player, target)
                && angleTo(player, target.getBoundingBox().getCenter()) <= half * 1.15) {
            return target;
        }

        LivingEntity best = null;
        double bestAng = Double.MAX_VALUE;

        for (Entity e : client.world.getEntities()) {
            if (!valid(player, e)) continue;
            LivingEntity le = (LivingEntity) e;
            double ang = angleTo(player, le.getBoundingBox().getCenter());
            if (ang > half) continue;
            if (ang < bestAng) {
                bestAng = ang;
                best = le;
            }
        }
        return best;
    }

    private void updateDrift(LivingEntity e) {
        double w = e.getWidth();
        double h = e.getHeight();

        if (--retargetIn <= 0) {
            goalX = (rng.nextDouble() - 0.5) * w * 0.5;
            goalZ = (rng.nextDouble() - 0.5) * w * 0.5;
            goalY = (rng.nextDouble() - 0.5) * h * 0.25;
            retargetIn = 12 + rng.nextInt(20);
        }
        offX += (goalX - offX) * 0.10;
        offY += (goalY - offY) * 0.10;
        offZ += (goalZ - offZ) * 0.10;
    }

    private Vec3d aimPoint(LivingEntity e) {
        return new Vec3d(e.getX() + offX, e.getY() + e.getHeight() * 0.65 + offY, e.getZ() + offZ);
    }
}