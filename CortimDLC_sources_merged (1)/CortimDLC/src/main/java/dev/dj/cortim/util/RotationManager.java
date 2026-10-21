package dev.dj.cortim.util;

public final class RotationManager {
    private static float yaw, pitch;
    private static long lastSetMs;

    /** Пока true: движение игрока считается относительно тихого угла (коррекция движения). */
    public static boolean moveFix = false;

    private RotationManager() {}

    public static void set(float y, float p) {
        yaw = y; pitch = p; lastSetMs = System.currentTimeMillis();
    }

    public static boolean isActive() {
        return System.currentTimeMillis() - lastSetMs < 250;
    }

    public static void reset() { lastSetMs = 0; moveFix = false; }

    public static float yaw() { return yaw; }
    public static float pitch() { return pitch; }
}