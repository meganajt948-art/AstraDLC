
package dev.dj.cortim.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public final class HumanInput {

    private final Random rnd = new Random();

    private float yaw;
    private float pitch;
    private float targetYaw;
    private float targetPitch;
    private boolean ready;

    public float speed = 0.45f;

    public boolean wantForward;
    public boolean wantSprint;
    public boolean wantSneak;
    public boolean wantUse;
    public boolean noGlance;
    public int wantStrafe;

    private int forceJump;
    private int steerSide = 1;
    private double drift;
    private double driftGoal;
    private int driftIn;

    public void start(ClientPlayerEntity player) {
        yaw = player.getYaw();
        pitch = player.getPitch();
        targetYaw = yaw;
        targetPitch = pitch;
        ready = true;
    }

    public void intentReset() {
        wantForward = false;
        wantSprint = false;
        wantSneak = false;
        wantUse = false;
        noGlance = false;
        wantStrafe = 0;
    }

    public void setLook(float yawDeg, float pitchDeg) {
        targetYaw = yawDeg;
        targetPitch = MathHelper.clamp(pitchDeg, -90.0f, 90.0f);
    }

    public void lookAtPoint(Vec3d eye, Vec3d point) {
        Vec3d direction = point.subtract(eye);

        targetYaw = (float) (
                Math.toDegrees(Math.atan2(direction.z, direction.x)) - 90.0
        );

        targetPitch = MathHelper.clamp(
                (float) -Math.toDegrees(
                        Math.atan2(
                                direction.y,
                                Math.hypot(direction.x, direction.z)
                        )
                ),
                -80.0f,
                80.0f
        );
    }

    public boolean isAimed(float tolerance) {
        return Math.abs(MathHelper.wrapDegrees(targetYaw - yaw)) < tolerance
                && Math.abs(targetPitch - pitch) < tolerance;
    }

    public void tickLook(ClientPlayerEntity player) {
        if (!ready) {
            start(player);
        }

        double k = MathHelper.clamp(speed, 0.1f, 1.0f);

        double yawError = MathHelper.wrapDegrees(targetYaw - yaw);
        double pitchError = targetPitch - pitch;

        double maxStep = 5.8 * k;

        double yawStep = MathHelper.clamp(
                yawError * 0.20 * k + rnd.nextGaussian() * 0.025,
                -maxStep,
                maxStep
        );

        double pitchStep = MathHelper.clamp(
                pitchError * 0.16 * k + rnd.nextGaussian() * 0.02,
                -maxStep * 0.7,
                maxStep * 0.7
        );

        yaw += (float) yawStep;
        pitch = MathHelper.clamp(
                pitch + (float) pitchStep,
                -90.0f,
                90.0f
        );

        RotationManager.set(yaw, pitch);
        RotationManager.moveFix = true;
    }

    private boolean clear(
            ClientPlayerEntity player,
            float directionYaw,
            double distance
    ) {
        MinecraftClient mc = MinecraftClient.getInstance();

        if (mc.world == null) {
            return true;
        }

        double radians = Math.toRadians(directionYaw);
        double dx = -Math.sin(radians) * distance;
        double dz = Math.cos(radians) * distance;

        Box box = player.getBoundingBox()
                .offset(dx, 0.0, dz)
                .expand(0.12, 0.0, 0.12);

        box = new Box(
                box.minX,
                box.minY + 0.6,
                box.minZ,
                box.maxX,
                box.maxY,
                box.maxZ
        );

        return mc.world.isSpaceEmpty(player, box);
    }

    private float steer(ClientPlayerEntity player, float wantedYaw) {
        if (clear(player, wantedYaw, 1.0)
                && clear(player, wantedYaw, 0.45)) {
            return wantedYaw;
        }

        float preferredSide = steerSide >= 0 ? 1.0f : -1.0f;

        for (float offset : new float[]{8.0f, 16.0f, 28.0f, 45.0f}) {
            for (int side = 0; side < 2; side++) {
                float direction = offset
                        * (side == 0 ? preferredSide : -preferredSide);

                float candidate = wantedYaw + direction;

                if (clear(player, candidate, 1.0)
                        && clear(player, candidate, 0.45)) {
                    steerSide = direction > 0 ? 1 : -1;
                    return candidate;
                }
            }
        }

        return wantedYaw;
    }

    public void walkTo(
            ClientPlayerEntity player,
            Vec3d target,
            boolean sprint
    ) {
        double dx = target.x - player.getX();
        double dz = target.z - player.getZ();
        double distance = Math.hypot(dx, dz);

        float baseYaw = (float) (
                Math.toDegrees(Math.atan2(dz, dx)) - 90.0
        );

        if (--driftIn <= 0) {
            double limit = Math.min(8.0, distance * 1.5);
            driftGoal = (rnd.nextDouble() - 0.5) * 2.0 * limit;
            driftIn = 20 + rnd.nextInt(50);
        }

        drift += (driftGoal - drift) * 0.06;

        float wantedYaw = baseYaw + (float) drift;

        if (!clear(player, wantedYaw, 1.0)
                || !clear(player, wantedYaw, 0.45)) {
            wantedYaw = clear(player, baseYaw, 1.0)
                    && clear(player, baseYaw, 0.45)
                    ? baseYaw
                    : steer(player, baseYaw);

            drift *= 0.5;
        }

        targetYaw = wantedYaw;
        targetPitch = 6.0f;

        float error = Math.abs(
                MathHelper.wrapDegrees(targetYaw - yaw)
        );

        wantForward = error < 55.0f;
        wantSprint = sprint && distance > 4.0 && error < 15.0f;
    }

    public void forceJump(int ticks) {
        forceJump = Math.max(forceJump, ticks);
    }

    public void tickKeys(ClientPlayerEntity player, boolean allowMove) {
        MinecraftClient mc = MinecraftClient.getInstance();

        if (mc == null || mc.options == null) {
            return;
        }

        GameOptions options = mc.options;

        boolean forward = allowMove && wantForward;
        boolean sprint = forward && wantSprint && !wantSneak;

        // Одно место управления спринтом: не перезаписываем его
        // отдельными таймерами и случайными переключениями.
        options.forwardKey.setPressed(forward);
        options.sprintKey.setPressed(sprint);

        boolean jump = false;

        if (allowMove && forceJump > 0) {
            forceJump--;
            jump = true;
        }

        if (allowMove
                && wantForward
                && player.horizontalCollision
                && player.isOnGround()) {
            jump = true;
        }

        options.jumpKey.setPressed(jump);

        options.leftKey.setPressed(
                allowMove && wantStrafe < 0
        );

        options.rightKey.setPressed(
                allowMove && wantStrafe > 0
        );

        options.sneakKey.setPressed(
                allowMove && wantSneak
        );

        options.useKey.setPressed(
                allowMove && wantUse
        );
    }

    public void release() {
        MinecraftClient mc = MinecraftClient.getInstance();

        if (mc != null && mc.options != null) {
            GameOptions options = mc.options;

            options.forwardKey.setPressed(false);
            options.leftKey.setPressed(false);
            options.rightKey.setPressed(false);
            options.jumpKey.setPressed(false);
            options.sprintKey.setPressed(false);
            options.sneakKey.setPressed(false);
            options.useKey.setPressed(false);
        }

        intentReset();
        forceJump = 0;
        ready = false;

        RotationManager.reset();
    }
}
