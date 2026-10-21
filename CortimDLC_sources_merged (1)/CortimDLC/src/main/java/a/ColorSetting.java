/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Theme;
import a.ModeSetting;
import flow.dev.StringDecryptor;

public class ColorSetting
extends ModeSetting {
    public static final String THEME = "Theme";
    private static final String[] vlb = new String[]{"Theme", "Aurora", "Sakura", "Ice", "Violet", "Sunset", "Mint", "Crimson", "Gold", "Snow"};
    private static final int[][] vlc = new int[][]{null, {-10556716, -5796870}, {-28744, -14630}, {-8599297, -1837825}, {-7635722, -3688193}, {-26035, -41334}, {-12723049, -4852266}, {-45730, -25948}, {-538296, -5208}, {-723720, -4209712}};
    private static /* synthetic */ int vld;
    private static /* synthetic */ long vle;

    public ColorSetting(String string, String string2) {
        super(string, string2, vlb);
    }

    public static int[] pair(int n) {
        int[] nArray;
        int n2 = Math.max(0, Math.min(vlc.length - 1, n));
        if (vlc[n2] == null) {
            int[] nArray2 = new int[2];
            nArray2[0] = Theme.accent();
            nArray = nArray2;
            nArray2[1] = Theme.accent2();
        } else {
            nArray = vlc[n2];
        }
        return nArray;
    }

    public int color() {
        return ColorSetting.pair(this.index())[0];
    }

    public int[] vivid(int[] nArray) {
        if (this.index() == 0) {
            int n = Theme.accent();
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            int n5 = Math.max(n2, Math.max(n3, n4));
            int n6 = Math.min(n2, Math.min(n3, n4));
            if (n5 == 0 || (float)(n5 - n6) / (float)n5 < 0.18f) {
                return nArray;
            }
        }
        return new int[]{this.color() | 0xFF000000, this.color2() | 0xFF000000};
    }

    public int color2() {
        int[] nArray = ColorSetting.pair(this.index());
        return this.index() == 0 && nArray[0] == nArray[1] ? ColorSetting.vlf(nArray[0]) : nArray[1];
    }

    private static int vlf(int n) {
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        return n & 0xFF000000 | n2 + (255 - n2) / 2 << 16 | n3 + (255 - n3) / 2 << 8 | n4 + (255 - n4) / 2;
    }

    private static /* synthetic */ int dgx(int n, int n2) {
        return n ^ n2 | 0xC2F7A5C2;
    }

    private static /* synthetic */ int dgy(int n, int n2) {
        return n * n2 ^ 0xB7140AF7;
    }

    private static /* synthetic */ int dgz(int n, int n2) {
        return ColorSetting.dgx(n, n2) ^ 0xB938E1D4;
    }
}

