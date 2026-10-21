/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;

public final class EnchantNameUtil {
    private static final String[] pfm;
    private static final String[] pfn;
    private static final String pfo;
    private static final String pfp;
    private static final String pfq;
    private static final String pfr;
    private static final String pfs;
    private static /* synthetic */ long pft;
    private static /* synthetic */ boolean pfu;

    private EnchantNameUtil() {
    }

    public static String roman(int n) {
        return n < 1 || n > pfm.length ? String.valueOf(n) : pfm[n - 1];
    }

    public static String normalize(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("§.", "").toLowerCase().replaceAll("[\\s\\u00A0\\u2007\\u202F]+", "");
    }

    public static String title(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.replaceAll("§.", "").toLowerCase().replaceAll("[\\s\\u00A0\\u2007\\u202F]+", " ").trim();
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            int n = "acekopxy".indexOf(c);
            stringBuilder.append(n < 0 ? c : "асекорху".charAt(n));
        }
        return stringBuilder.toString();
    }

    public static int levelOf(String string, String string2) {
        if (string.isEmpty() || string2.isEmpty()) {
            return 0;
        }
        int n = 0;
        int n2 = string.indexOf(string2);
        while (n2 >= 0) {
            n = Math.max(n, Math.max(1, EnchantNameUtil.pfv(string, n2 + string2.length())));
            n2 = string.indexOf(string2, n2 + string2.length());
        }
        return n;
    }

    private static int pfv(String string, int n) {
        int n2;
        for (n2 = n; n2 < string.length() && ":.-–—·»>|=".indexOf(string.charAt(n2)) >= 0; ++n2) {
        }
        int n3 = n2;
        while (n2 < string.length() && "ivx0123456789".indexOf(string.charAt(n2)) >= 0) {
            ++n2;
        }
        return n2 == n3 ? 0 : EnchantNameUtil.parseLevel(string.substring(n3, n2));
    }

    static int parseLevel(String string) {
        int n;
        String string2 = EnchantNameUtil.normalize(string);
        if (string2.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < pfn.length; ++i) {
            if (!string2.equals(pfn[i])) continue;
            return i + 1;
        }
        String string3 = string2.replaceAll("[^0-9]", "");
        if (!string3.isEmpty() && string3.length() < 3 && (n = Integer.parseInt(string3)) >= 1 && n <= 10) {
            return n;
        }
        for (n = pfn.length - 1; n >= 0; --n) {
            if (!string2.contains(pfn[n])) continue;
            return n + 1;
        }
        return 0;
    }

    static {
        pfo = "ivx0123456789";
        pfp = ":.-–—·»>|=";
        pfq = "[\\s\\u00A0\\u2007\\u202F]+";
        pfr = "acekopxy";
        pfs = "асекорху";
        pfm = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        pfn = new String[]{"i", "ii", "iii", "iv", "v", "vi", "SvgPathParser", "viii", "ix", "x"};
    }

    private static /* synthetic */ int bhv(int n, int n2) {
        return n + n2 | 0x362DAB79;
    }

    private static /* synthetic */ int bhw(int n, int n2) {
        return n * n2 + 810832920;
    }

    private static /* synthetic */ int bhx(int n, int n2) {
        return EnchantNameUtil.bhw(n, n2) ^ 0x7120BFED;
    }
}

