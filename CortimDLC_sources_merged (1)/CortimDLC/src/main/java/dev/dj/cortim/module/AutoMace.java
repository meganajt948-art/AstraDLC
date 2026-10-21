package dev.dj.cortim.module;

import dev.dj.cortim.util.RotationManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class AutoMace extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public final ModeSetting rotation = add(new ModeSetting("Ротация",
            "Клиентская двигает камеру, тихая только пакеты", 0, "Клиентская", "Тихая").asSegmented());
    public final FloatSetting speed = add(new FloatSetting("Скорость",
            "Скорость поворота", 100f, 1f, 100f, 1f));
    public final FloatSetting spread = add(new FloatSetting("Разброс",
            "Случайное дрожание наводки", 60f, 0f, 100f, 1f));
    public final FloatSetting distance = add(new FloatSetting("Дистанция",
            "Радиус атаки", 3.0f, 1.0f, 6.0f, 0.05f));
    public final FloatSetting hitHeight = add(new FloatSetting("Высота удара",
            "Минимальная высота падения для удара", 1.5f, 1.5f, 10.0f, 0.1f));
    public final BoolSetting crits = add(new BoolSetting("Криты", "Бить только в условиях крита", true));

    // Видна только при клиентской ротации
    public final BoolSetting returnLook = add(new BoolSetting("Возврат взгляда",
            "Вернуть камеру после удара", true) {
        @Override public boolean isVisible() { return rotation.get() == 0; }
    });

    public final BoolSetting swapToMace = add(new BoolSetting("Свап на булаву", "Переключаться на булаву", true));
    public final BoolSetting returnSlot = add(new BoolSetting("Вернуть слот", "Вернуть прошлый слот после удара", true));
    public final BoolSetting afterCharge = add(new BoolSetting("Булава после заряда", "Бить при заряженном кулдауне", true));
    public final BoolSetting players = add(new BoolSetting("Игроки", "Атаковать игроков", true));
    public final BoolSetting mobs = add(new BoolSetting("Мобы", "Атаковать мобов", false));

    private final Random rnd = new Random();
    private float origYaw, origPitch;
    private boolean hasOrig;

    public AutoMace() {
        super("AutoMace", Category.COMBAT);
    }

    private boolean isSilent() { return rotation.get() == 1; }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        if (!v) {
            RotationManager.reset();
            hasOrig = false;
        }
    }

    @Override
    public void onTick() {
        if (!isEnabled()) return;
        ClientPlayerEntity p = mc.player;
        if (p == null || mc.world == null || mc.interactionManager == null) return;

        LivingEntity target = findTarget(p);
        int maceSlot = findMaceSlot(p);
        boolean holdingMace = p.getMainHandStack().isOf(Items.MACE);
        boolean hasMace = swapToMace.get() ? maceSlot != -1 : holdingMace;

        if (target == null || !hasMace) { release(p); return; }

        boolean silent = isSilent();

        // 1. Ротация
        if (!silent && !hasOrig) {
            origYaw = p.getYaw(); origPitch = p.getPitch(); hasOrig = true;
        }
        float[] need = calcRotation(p, target);
        boolean useServer = silent && RotationManager.isActive();
        float curYaw = useServer ? RotationManager.yaw() : p.getYaw();
        float curPitch = useServer ? RotationManager.pitch() : p.getPitch();
        float[] next = smooth(curYaw, curPitch, need[0], need[1], true);
        next[1] = MathHelper.clamp(next[1], -90f, 90f);

        if (silent) {
            RotationManager.set(next[0], next[1]);
        } else {
            p.setYaw(next[0]);
            p.setPitch(next[1]);
        }

        // 2. Условия удара
        if (p.fallDistance < hitHeight.get()) return;
        if (crits.get() && !canCrit(p)) return;
        if (afterCharge.get() && p.getAttackCooldownProgress(0.5f) < 1.0f) return;
        if (!rotationOnTarget(next[0], next[1], p, target)) return;

        // 3. Свап слота
        int prevSlot = p.getInventory().getSelectedSlot();
        boolean swapped = false;
        if (!holdingMace) {
            p.getInventory().setSelectedSlot(maceSlot);
            swapped = true;
        }

        // 4. Сервер должен увидеть угол до удара
        p.networkHandler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(
                next[0], next[1], p.isOnGround(), p.horizontalCollision));

        mc.interactionManager.attackEntity(p, target);
        p.swingHand(Hand.MAIN_HAND);

        // 5. Возврат слота
        if (swapped && returnSlot.get()) {
            p.getInventory().setSelectedSlot(prevSlot);
        }
    }

    /** Цели нет или нет булавы. */
    private void release(ClientPlayerEntity p) {
        if (isSilent()) {
            RotationManager.reset();
            hasOrig = false;
            return;
        }
        if (hasOrig && returnLook.get()) {
            float[] r = smooth(p.getYaw(), p.getPitch(), origYaw, origPitch, false);
            p.setYaw(r[0]);
            p.setPitch(r[1]);
            if (Math.abs(MathHelper.wrapDegrees(origYaw - r[0])) < 1f
                    && Math.abs(origPitch - r[1]) < 1f) {
                hasOrig = false;
            }
            return;
        }
        hasOrig = false;
    }

    private float[] smooth(float cy, float cp, float ty, float tp, boolean noise) {
        float maxStep = 180f * speed.get() / 100f;
        float jitter = spread.get() / 100f * 1.5f;
        float dy = MathHelper.wrapDegrees(ty - cy);
        float dp = tp - cp;
        float stepY = MathHelper.clamp(dy, -maxStep, maxStep);
        float stepP = MathHelper.clamp(dp, -maxStep, maxStep);
        if (noise) {
            stepY += (rnd.nextFloat() - 0.5f) * 2f * jitter;
            stepP += (rnd.nextFloat() - 0.5f) * 2f * jitter;
        }
        return new float[]{cy + stepY, cp + stepP};
    }

    private float[] calcRotation(ClientPlayerEntity p, LivingEntity t) {
        Vec3d eye = p.getEyePos();
        Vec3d aim = t.getBoundingBox().getCenter();
        double dx = aim.x - eye.x, dy = aim.y - eye.y, dz = aim.z - eye.z;
        double h = Math.sqrt(dx * dx + dz * dz);
        float yaw = (float) Math.toDegrees(Math.atan2(dz, dx)) - 90f;
        float pitch = (float) -Math.toDegrees(Math.atan2(dy, h));
        return new float[]{yaw, pitch};
    }

    private boolean rotationOnTarget(float yaw, float pitch, ClientPlayerEntity p, LivingEntity t) {
        Vec3d eye = p.getEyePos();
        Vec3d look = Vec3d.fromPolar(pitch, yaw).multiply(distance.get());
        return t.getBoundingBox().expand(0.1).raycast(eye, eye.add(look)).isPresent();
    }

    private boolean canCrit(ClientPlayerEntity p) {
        return !p.isOnGround() && !p.isClimbing() && !p.isTouchingWater()
                && !p.hasStatusEffect(StatusEffects.BLINDNESS) && !p.hasVehicle();
    }

    private int findMaceSlot(ClientPlayerEntity p) {
        for (int i = 0; i < 9; i++) {
            if (p.getInventory().getStack(i).isOf(Items.MACE)) return i;
        }
        return -1;
    }

    private LivingEntity findTarget(ClientPlayerEntity p) {
        LivingEntity best = null;
        double bestD = distance.get();
        for (Entity e : mc.world.getEntities()) {
            if (!(e instanceof LivingEntity le) || le == p || !le.isAlive()) continue;
            if (le instanceof ArmorStandEntity) continue;
            boolean isPlayer = le instanceof PlayerEntity;
            if (isPlayer && ((PlayerEntity) le).isSpectator()) continue;
            if (isPlayer ? !players.get() : !mobs.get()) continue;
            double d = p.distanceTo(le);
            if (d <= bestD) { bestD = d; best = le; }
        }
        return best;
    }
}