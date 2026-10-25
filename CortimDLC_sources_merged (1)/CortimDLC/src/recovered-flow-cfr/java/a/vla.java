/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iov;
import a.vlv;
import flow.dev.a;

public class vla
extends vlv {
    public static final String THEME = a.c(1358628362, "\u065b\u7fd6\uf508\u6b71\ue0ae");
    private static final String[] vlb = new String[]{a.c(-22177671, "\u9828\ue1a5\u6b7b\uf502\u7edd"), a.b("\u80d1\uf954\u7380\uedec\u6626\ue084", 949649558), a.b("\u8ca9\uf52a\u7ff3\ue19c\u6a4c\uecee", 620465404), a.d("\ua3f7\uda6c\u50b9", -755050020, -929858975), a.c(-1182953181, "\u9173\ue8fd\u6228\ufc5a\u7784\uf124"), a.b("\u4ec9\u375e\ubd96\u23fa\ua83b\u2e9b", -1894953316), a.c(912669246, "\u3a77\u43e2\uc936\u575d"), a.c(47580972, "\u0768\u7ee8\uf420\u6a55\ue19c\u6731\udd63"), a.b("\uc76c\ubef5\u3425\uaa5c", 907331375), a.c(699486684, "\u518b\u2807\ua2d5\u3cbc")};
    private static final int[][] vlc = new int[][]{null, {-10556716, -5796870}, {-28744, -14630}, {-8599297, -1837825}, {-7635722, -3688193}, {-26035, -41334}, {-12723049, -4852266}, {-45730, -25948}, {-538296, -5208}, {-723720, -4209712}};
    private static /* synthetic */ int vld;
    private static /* synthetic */ long vle;

    public vla(String string, String string2) {
        super(string, string2, vlb);
    }

    public static int[] pair(int n) {
        int[] nArray;
        int n2 = Math.max(0, Math.min(vlc.length - 1, n));
        if (vlc[n2] == null) {
            int[] nArray2 = new int[2];
            nArray2[0] = iov.accent();
            nArray = nArray2;
            nArray2[1] = iov.accent2();
        } else {
            nArray = vlc[n2];
        }
        return nArray;
    }

    public int color() {
        return vla.pair(this.index())[0];
    }

    public int[] vivid(int[] nArray) {
        if (this.index() == 0) {
            int n = iov.accent();
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
        int[] nArray = vla.pair(this.index());
        return this.index() == 0 && nArray[0] == nArray[1] ? vla.vlf(nArray[0]) : nArray[1];
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
        return vla.dgx(n, n2) ^ 0xB938E1D4;
    }
}

