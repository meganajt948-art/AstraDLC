package dev.dj.cortim.module;

import dev.dj.cortim.Cortim;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public class TriggerBot extends Module {

    private final ModeSetting crits = add(new ModeSetting("Криты",
            "Умные: бьёт в падении, чтобы удар был критическим", 0, "Умные", "Выкл"));

    private final ModeSetting aim = add(new ModeSetting("Наведение",
            "Прицел: бьёт только на что смотришь. Авто: ближайшего в узком конусе перед прицелом",
            0, "Прицел", "Авто").asSegmented());

    private final BoolSetting withAim = add(new BoolSetting("С AimAssist",
            "Если AimAssist ведёт цель, бить её, когда прицел рядом с хитбоксом", true));

    private final BoolSetting sprintReset = add(new BoolSetting("Сброс спринта",
            "Сбрасывает спринт перед ударом", false));

    private final BoolSetting mace = add(new BoolSetting("Удар булавой",
            "Разрешает бить булавой", true));

    private final BoolSetting swordOnly = add(new BoolSetting("Только мечом",
            "Включено: бьёт только мечом. Выключено: бьёт чем угодно, даже рукой", true));

    private final IntSetting reaction = add(new IntSetting("Реакция",
            "Через сколько мс после появления цели бить", 60, 0, 500) {
        @Override public String display() { return get() + " мс"; }
    });

    private final IntSetting delayTicks = add(new IntSetting("Задержка",
            "Доп. задержка после готовности атаки", 0, 0, 10) {
        @Override public String display() { return get() + " тиков"; }
    });

    private final FloatSetting range = add(new FloatSetting("Дистанция",
            "Максимальная дальность удара", 3.0f, 1.0f, 3.0f, 0.1f) {
        @Override public String display() { return String.format("%.2f", get()); }
    });

    private final BoolSetting players = add(new BoolSetting("Игроки", "Бить игроков", true));
    private final BoolSetting mobs = add(new BoolSetting("Мобы", "Бить мобов", false));
    private final BoolSetting hitFriends = add(new BoolSetting("Друзья", "Бить друзей", false));
    private final BoolSetting throughFriends = add(new BoolSetting("Сквозь друзей",
            "Бить тех, кто стоит за другом (режим «Прицел»)", true));

    private static final float READY = 0.95f;
    private static final double AUTO_CONE = 25.0;
    private static final double AIM_MARGIN = 0.15;  // запас вокруг хитбокса для цели аима
    private static final long GRACE_MS = 250L;
    private static final int MAX_CRIT_WAIT = 6;

    private int lastTargetId = -1;
    private long targetSince = 0L;
    private long lastSeen = 0L;
    private int readyTicks = 0;
    private int critWait = 0;
    private long jitter = 0L;

    private double prevY = Double.NaN;
    private boolean falling = false;

    public TriggerBot() { super("TriggerBot", Category.COMBAT); }

    @Override
    public void onTick() {
        if (!isEnabled()) { hardReset(); return; }

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || client.world == null || client.interactionManager == null) return;

        double y = player.getY();
        falling = !Double.isNaN(prevY) && y < prevY - 1.0E-4;
        prevY = y;

        if (client.currentScreen != null) { hardReset(); return; }
        if (player.isUsingItem() || player.isDead()) { hardReset(); return; }
        if (!weaponAllowed(player.getMainHandStack())) { hardReset(); return; }

        long now = System.currentTimeMillis();

        Entity target = aim.get() == 1 ? findAuto(client, player) : findByCrosshair(client, player);
        if (target == null && withAim.get()) target = findFromAimAssist(client, player);

        if (target == null) {
            if (now - lastSeen > GRACE_MS) hardReset();
            return;
        }

        boolean fresh = lastTargetId == -1 || now - lastSeen > GRACE_MS;
        if (fresh) {
            targetSince = now;
            readyTicks = 0;
            critWait = 0;
            jitter = (long) (Math.random() * 40.0);
        }
        lastTargetId = target.getId();
        lastSeen = now;

        if (now - targetSince < reaction.get() + jitter) return;

        if (player.getAttackCooldownProgress(0.0F) < READY) { readyTicks = 0; return; }
        readyTicks++;
        if (readyTicks - 1 < delayTicks.get()) return;

        if (crits.get() == 0 && !critReady(player)) {
            if (++critWait <= MAX_CRIT_WAIT) return;
        }

        attack(client, player, target);
        readyTicks = 0;
        critWait = 0;
    }

    private void hardReset() {
        lastTargetId = -1;
        targetSince = 0L;
        lastSeen = 0L;
        readyTicks = 0;
        critWait = 0;
    }

    private boolean weaponAllowed(ItemStack stack) {
        if (stack.isOf(Items.MACE)) return mace.get();
        if (swordOnly.get()) return stack.isIn(ItemTags.SWORDS);
        return true;
    }

    private boolean isFriend(Entity e) {
        return e instanceof PlayerEntity && NoFriendDamage.isProtected(e);
    }

    private boolean allowed(Entity e) {
        if (!(e instanceof LivingEntity) || e instanceof ArmorStandEntity || !e.isAlive()) return false;
        if (e instanceof PlayerEntity) {
            return isFriend(e) ? hitFriends.get() : players.get();
        }
        return mobs.get();
    }

    /** Цель аима: бьём, если луч прицела проходит рядом с хитбоксом (с небольшим запасом). */
    private Entity findFromAimAssist(MinecraftClient client, ClientPlayerEntity player) {
        AimAssist assist = Cortim.getAimAssist();
        if (assist == null) return null;

        LivingEntity t = assist.getTarget();
        if (t == null || !allowed(t) || t.isSpectator()) return null;

        double r = range.get();
        Vec3d start = player.getEyePos();
        Vec3d end = start.add(player.getRotationVec(1.0f).multiply(r));

        var hit = t.getBoundingBox().expand(AIM_MARGIN).raycast(start, end);
        if (hit.isEmpty()) return null;

        // дальность до самой цели
        if (start.squaredDistanceTo(hit.get()) > r * r) return null;

        // стена между нами
        HitResult block = client.world.raycast(new RaycastContext(start, hit.get(),
                RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));
        if (block.getType() != HitResult.Type.MISS) return null;

        return t;
    }

    private Entity findAuto(MinecraftClient client, ClientPlayerEntity player) {
        Vec3d eye = player.getEyePos();
        Vec3d look = player.getRotationVec(1.0f);
        double r = range.get();
        double cosLimit = Math.cos(Math.toRadians(AUTO_CONE));

        Entity best = null;
        double bestD = r * r;

        for (Entity e : client.world.getEntities()) {
            if (e == player || e.isSpectator() || !allowed(e)) continue;

            Box box = e.getBoundingBox();
            Vec3d closest = new Vec3d(
                    MathHelper.clamp(eye.x, box.minX, box.maxX),
                    MathHelper.clamp(eye.y, box.minY, box.maxY),
                    MathHelper.clamp(eye.z, box.minZ, box.maxZ));
            double d = eye.squaredDistanceTo(closest);
            if (d > bestD) continue;

            Vec3d toCenter = box.getCenter().subtract(eye).normalize();
            if (toCenter.dotProduct(look) < cosLimit) continue;

            HitResult block = client.world.raycast(new RaycastContext(eye, closest,
                    RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));
            if (block.getType() != HitResult.Type.MISS) continue;

            bestD = d;
            best = e;
        }
        return best;
    }

    private Entity findByCrosshair(MinecraftClient client, ClientPlayerEntity player) {
        double r = range.get();
        Vec3d start = player.getEyePos();
        Vec3d look = player.getRotationVec(1.0f);
        Vec3d end = start.add(look.multiply(r));
        Box box = player.getBoundingBox().stretch(look.multiply(r)).expand(1.0, 1.0, 1.0);

        boolean skipFriends = throughFriends.get() && !hitFriends.get();

        EntityHitResult hit = ProjectileUtil.raycast(player, start, end, box,
                e -> !e.isSpectator() && e.canHit() && e != player
                        && !(skipFriends && isFriend(e)),
                r * r);
        if (hit == null) return null;

        HitResult block = client.world.raycast(new RaycastContext(start, end,
                RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));
        if (block.getType() != HitResult.Type.MISS) {
            double blockDist = start.squaredDistanceTo(block.getPos());
            if (start.squaredDistanceTo(hit.getPos()) >= blockDist) return null;
        }

        Entity target = hit.getEntity();
        return allowed(target) ? target : null;
    }

    private boolean critReady(ClientPlayerEntity p) {
        if (p.isOnGround()) return true;
        if (p.isClimbing() || p.isTouchingWater() || p.hasVehicle()
                || p.hasStatusEffect(StatusEffects.BLINDNESS)) return true;
        return falling;
    }

    private void attack(MinecraftClient client, ClientPlayerEntity player, Entity target) {
        var net = client.getNetworkHandler();
        if (net == null) return;

        boolean reset = sprintReset.get() && player.isSprinting();

        if (reset) {
            net.sendPacket(new ClientCommandC2SPacket(player, ClientCommandC2SPacket.Mode.STOP_SPRINTING));
            player.setSprinting(false);
        }

        client.interactionManager.attackEntity(player, target);
        player.swingHand(Hand.MAIN_HAND);

        if (reset && client.options.forwardKey.isPressed()) {
            player.setSprinting(true);
            net.sendPacket(new ClientCommandC2SPacket(player, ClientCommandC2SPacket.Mode.START_SPRINTING));
        }
    }
}