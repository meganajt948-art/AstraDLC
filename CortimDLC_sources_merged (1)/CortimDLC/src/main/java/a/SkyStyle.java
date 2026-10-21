/*
 * Decompiled with CFR 0.152.
 */
package a;

public enum SkyStyle {
    AURORA("Aurora", -7709441, -2513153, 1.0f, 0.34f),
    NEBULA("Nebula", -10914817, -42561, 1.0f, 0.16f),
    GALAXY("Galaxy", -9200897, -1654785, 1.0f, 0.08f),
    SUNSET("Sunset", -29632, -45696, 0.6f, 0.36f),
    CLOUDS("Clouds", -10904833, -1, 0.0f, 0.62f);

    public final String title;
    public final int color1;
    public final int color2;
    public final float stars;
    public final float luminance;
    private static final long uxu;
    private static /* synthetic */ long uxv;
    private static /* synthetic */ long uxw;

    private SkyStyle(String string2, int n2, int n3, float f, float f2) {
        this.title = string2;
        this.color1 = n2;
        this.color2 = n3;
        this.stars = f;
        this.luminance = f2;
    }

    public int id() {
        return this.ordinal() + 1;
    }

    public static SkyStyle of(String string) {
        for (SkyStyle uxt2 : SkyStyle.values()) {
            if (!uxt2.title.equalsIgnoreCase(string)) continue;
            return uxt2;
        }
        return AURORA;
    }

    public static String[] titles() {
        SkyStyle[] uxtArray = SkyStyle.values();
        String[] stringArray = new String[uxtArray.length];
        for (int i = 0; i < uxtArray.length; ++i) {
            stringArray[i] = uxtArray[i].title;
        }
        return stringArray;
    }

    public static float time() {
        return (float)(System.nanoTime() - uxu) / 1.0E9f;
    }

    static {
        uxu = System.nanoTime();
    }

    private static /* synthetic */ int dby(int n, int n2) {
        return n - n2 | 0xF3DC9C53;
    }
}

