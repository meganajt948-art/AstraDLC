package dev.dj.cortim;

public final class CortimConfig {
    private static volatile boolean panic = false;
    public static boolean espEnabled = true, tracersEnabled = true, hudEnabled = true, autoSwapEnabled = true;
    public static boolean guiMoveEnabled = true, autoBuyEnabled = false, freecamEnabled = false;
    public static boolean brightnessEnabled = true, atmosphereEnabled = true, smoothnessEnabled = true, saturationEnabled = true;
    public static float gamma = 10.0f, snowDensity = 1.0f, rotationSpeed = 0.35f, saturation = 1.35f;
    public static int snowColor = 0xFFFFFFFF;
    public static boolean permanentSnowBiome = true, snowParticles = true, smoothCamera = true;
    public static boolean lightTheme = false, blurEnabled = true;
    public static String language = "EN";

    // ТУТ УМЕНЬШЕНЫ РАЗМЕРЫ
    public static int panelW = 700;
    public static int panelH = 450;

    private CortimConfig() {}

    public static int accent() { return lightTheme ? 0xFF4A4AD4 : 0xFF8B8BFF; }
    public static boolean isPanic() { return panic; }
    public static void setPanic(boolean v) { panic = v; }
    public static void restoreFromPanic() { panic = false; }
}