/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;

public final class pfl {
    private static final String[] pfm;
    private static final String[] pfn;
    private static final String pfo;
    private static final String pfp;
    private static final String pfq;
    private static final String pfr;
    private static final String pfs;
    private static /* synthetic */ long pft;
    private static /* synthetic */ boolean pfu;

    private pfl() {
    }

    public static String roman(int n) {
        return n < 1 || n > pfm.length ? String.valueOf(n) : pfm[n - 1];
    }

    public static String normalize(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll(a.b("\u3d8b\u44b3", 947666222), "").toLowerCase().replaceAll(a.c(858554202, "\u7f16\u06a0\u8c5c\u1202\u99fc\u1f08\ua55b\u2cdb\ub2f5\u3828\ubfd2\u45e4\ucb31\u5280\ud8d4\u5e4e\ue428\u6bbe\uf10f\u775c\ufedf\u8495\u0a50"), "");
    }

    public static String title(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.replaceAll(a.d("\u59f7\u20cf", 1304323519, -2736915), "").toLowerCase().replaceAll(a.b("\u693c\u108a\u9a76\u0428\u8fd6\u0922\ub371\u3af1\ua4df\u2e02\ua9f8\u53ce\udd1b\u44aa\ucefe\u4864\uf202\u7d94\ue725\u6176\ue8f5\u92bf\u1c7a", -506500752), a.d("\ued7b", -457283411, 1292862967)).trim();
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            int n = a.d("\u8ab6\uf305\u79d0\ue7af\u6c7c\uead2\u5089\ud979", -1709089634, 514119233).indexOf(c);
            stringBuilder.append(n < 0 ? c : a.b("\u9637\ueff7\u6550\ufb2e\u70fd\uf632\u4c64\uc593", 2110165519).charAt(n));
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
            n = Math.max(n, Math.max(1, pfl.pfv(string, n2 + string2.length())));
            n2 = string.indexOf(string2, n2 + string2.length());
        }
        return n;
    }

    private static int pfv(String string, int n) {
        int n2;
        for (n2 = n; n2 < string.length() && a.d("\ub15b\uc8fe\u422e\ufc61\u77b1\ud1a3\u6bfc\ue288\u7c95\uf665", -708714892, -1032163553).indexOf(string.charAt(n2)) >= 0; ++n2) {
        }
        int n3 = n2;
        while (n2 < string.length() && a.d("\ud1d8\ua876\u22ab\ubc92\u3744\ub1f6\u0ba4\u8252\u1c0c\u96be\u116c\ueb12\u65c4", -793375252, -1095771056).indexOf(string.charAt(n2)) >= 0) {
            ++n2;
        }
        return n2 == n3 ? 0 : pfl.parseLevel(string.substring(n3, n2));
    }

    static int parseLevel(String string) {
        int n;
        String string2 = pfl.normalize(string);
        if (string2.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < pfn.length; ++i) {
            if (!string2.equals(pfn[i])) continue;
            return i + 1;
        }
        String string3 = string2.replaceAll(a.d("\u8e2b\uf79f\u7d22\ue34e\u688d\uee58", -1779658696, -1460003250), "");
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
        pfo = a.c(780907790, "\ub56a\uccc4\u4619\ud820\u53f6\ud544\u6f16\ue6e0\u78be\uf20c\u75de\u8fa0\u0176");
        pfp = a.b("\ud8b3\ua116\u2bc6\u9589\u1e59\ub84b\u0214\u8b60\u157d\u9f8d", 1179506819);
        pfq = a.b("\ude31\ua787\u2d7b\ub325\u38db\ube2f\u047c\u8dfc\u13d2\u990f\u1ef5\ue4c3\u6a16\uf3a7\u79f3\uff69\u450f\uca99\u5028\ud67b\u5ff8\u25b2\uab77", -1477583235);
        pfr = a.c(-1319903035, "\ue0ac\u991f\u13ca\u8db5\u0666\u80c8\u3a93\ub363");
        pfs = a.c(1137342698, "\u7cd2\u0512\u8fb5\u11cb\u9a18\u1cd7\ua681\u2f76");
        pfm = new String[]{a.c(-74709434, "\u060e"), a.c(-1925491375, "\u551a\u2cab"), a.b("\ub999\uc028\u4afb", 2111355347), a.c(-554631820, "\ufd3f\u8491"), a.b("\u0e70", -1469837785), a.b("\u452f\u3c81", 851330427), a.c(632004626, "\ua047\ud9e9\u533a"), a.c(-1118815858, "\u39dc\u4072\ucaa1\u54d0"), a.c(-1741263234, "\u6e35\u1795"), a.c(-2047216373, "\uf552")};
        pfn = new String[]{a.b("\ude12", 318234234), a.b("\u16d1\u6f60", 1023022778), a.b("\u6cfc\u154d\u9f9e", -707367786), a.b("\uc42e\ubd80", 1629930565), a.b("\u9f07", 1423679344), a.d("\uf092\u893c", -86503537, -481689751), a.d("\ue06e\u99c0\u1313", -664668912, 936645899), a.c(-643852177, "\u981d\ue1b3\u6b60\uf511"), a.b("\uf75e\u8efe", 2015164213), a.b("\u06a5", 1873741532)};
    }

    private static /* synthetic */ int bhv(int n, int n2) {
        return n + n2 | 0x362DAB79;
    }

    private static /* synthetic */ int bhw(int n, int n2) {
        return n * n2 + 810832920;
    }

    private static /* synthetic */ int bhx(int n, int n2) {
        return pfl.bhw(n, n2) ^ 0x7120BFED;
    }
}

