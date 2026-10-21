/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class FormatUtil {
    private static final long[] vxv = new long[]{1L, 10L, 100L, 1000L, 10000L};
    private static /* synthetic */ boolean vxw;
    private static /* synthetic */ int vxx;

    private FormatUtil() {
    }

    public static String fixed(double d, int n) {
        int n2 = Math.max(0, Math.min(4, n));
        long l = Math.round(Math.abs(d) * (double)vxv[n2]);
        StringBuilder stringBuilder = new StringBuilder(12);
        if (d < 0.0 && l != 0L) {
            stringBuilder.append('-');
        }
        stringBuilder.append(l / vxv[n2]);
        if (n2 > 0) {
            stringBuilder.append('.');
            String string = Long.toString(l % vxv[n2]);
            for (int i = string.length(); i < n2; ++i) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static String clock(long l) {
        long l2 = Math.max(0L, l);
        StringBuilder stringBuilder = new StringBuilder(8);
        if (l2 >= 3600L) {
            stringBuilder.append(l2 / 3600L).append(':');
            FormatUtil.vxy(stringBuilder, l2 / 60L % 60L);
        } else {
            stringBuilder.append(l2 / 60L);
        }
        stringBuilder.append(':');
        FormatUtil.vxy(stringBuilder, l2 % 60L);
        return stringBuilder.toString();
    }

    public static String hoursMinutes(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(5);
        FormatUtil.vxy(stringBuilder, n);
        stringBuilder.append(':');
        FormatUtil.vxy(stringBuilder, n2);
        return stringBuilder.toString();
    }

    private static void vxy(StringBuilder stringBuilder, long l) {
        if (l < 10L) {
            stringBuilder.append('0');
        }
        stringBuilder.append(l);
    }

    private static /* synthetic */ int dmb(int n, int n2) {
        return n * n2 ^ 0x6FFE20F4;
    }

    private static /* synthetic */ int dmc(int n, int n2) {
        return FormatUtil.dmb(n, n2) + n;
    }
}

