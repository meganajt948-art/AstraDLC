/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.lang.ref.SoftReference;
import java.util.Arrays;

public final class StringVault {
    private static SoftReference<String> vuq;
    private static SoftReference<String> vur;
    private static SoftReference<String> vus;
    private static SoftReference<String> vut;
    private static SoftReference<String> vuu;
    private static SoftReference<String> vuv;
    private static SoftReference<String> vuw;
    private static SoftReference<String> vux;
    private static SoftReference<String> vuy;
    private static SoftReference<String> vuz;
    private static SoftReference<String> vva;
    private static SoftReference<String> vvb;
    private static SoftReference<String> vvc;
    private static SoftReference<String> vvd;
    private static /* synthetic */ String vve;
    private static /* synthetic */ long vvf;

    private StringVault() {
    }

    public static String e() {
        String string = StringVault.vvg(vuq);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'E', 'n', 'd'});
        vuq = new SoftReference<String>(string);
        return string;
    }

    public static String w() {
        String string = StringVault.vvg(vur);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'W', 'a', 'r', 'd', 'e', 'n'});
        vur = new SoftReference<String>(string);
        return string;
    }

    public static String m() {
        String string = StringVault.vvg(vus);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'M', 'i', 'n', 'e'});
        vus = new SoftReference<String>(string);
        return string;
    }

    public static String s() {
        String string = StringVault.vvg(vut);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'S', 'w', 'a', 'p'});
        vut = new SoftReference<String>(string);
        return string;
    }

    public static String t() {
        String string = StringVault.vvg(vuu);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'T', 'o', 't', 'e', 'm'});
        vuu = new SoftReference<String>(string);
        return string;
    }

    public static String l() {
        String string = StringVault.vvg(vuv);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'T', 'o', 'o', 'l'});
        vuv = new SoftReference<String>(string);
        return string;
    }

    public static String c() {
        String string = StringVault.vvg(vuw);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'M', 'a', 'c', 'e'});
        vuw = new SoftReference<String>(string);
        return string;
    }

    public static String o() {
        String string = StringVault.vvg(vux);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'C', 'o', 'l', 'l', 'e', 'c', 't', 'o', 'r'});
        vux = new SoftReference<String>(string);
        return string;
    }

    public static String a() {
        String string = StringVault.vvg(vuy);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'A', 'c', 'c', 'e', 'p', 't'});
        vuy = new SoftReference<String>(string);
        return string;
    }

    public static String k() {
        String string = StringVault.vvg(vuz);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'K', 'i', 'l', 'l', 'A', 'u', 'r', 'a'});
        vuz = new SoftReference<String>(string);
        return string;
    }

    public static String i() {
        String string = StringVault.vvg(vva);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't'});
        vva = new SoftReference<String>(string);
        return string;
    }

    public static String g() {
        String string = StringVault.vvg(vvb);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'T', 'r', 'i', 'g', 'g', 'e', 'r', 'B', 'o', 't'});
        vvb = new SoftReference<String>(string);
        return string;
    }

    public static String n() {
        String string = StringVault.vvg(vvc);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'N', 'e', 'u', 'r', 'o', 'A', 'i', 'm'});
        vvc = new SoftReference<String>(string);
        return string;
    }

    public static String p() {
        String string = StringVault.vvg(vvd);
        if (string != null) {
            return string;
        }
        string = StringVault.vvh(new char[]{'A', 'u', 't', 'o', 'S', 'p', 'r', 'i', 'n', 't'});
        vvd = new SoftReference<String>(string);
        return string;
    }

    private static String vvg(SoftReference<String> softReference) {
        return softReference == null ? null : softReference.get();
    }

    private static String vvh(char[] cArray) {
        StringBuilder stringBuilder = new StringBuilder(cArray.length * 2 - 1);
        for (int i = 0; i < cArray.length; ++i) {
            if (i > 0) {
                stringBuilder.append('\u200c');
            }
            stringBuilder.append(cArray[i]);
        }
        Arrays.fill(cArray, '\u0000');
        return stringBuilder.toString();
    }

    private static /* synthetic */ int dkx(int n, int n2) {
        return n - n2 + -283832378;
    }
}

