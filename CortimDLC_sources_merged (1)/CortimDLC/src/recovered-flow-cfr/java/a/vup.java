/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.lang.ref.SoftReference;
import java.util.Arrays;

public final class vup {
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

    private vup() {
    }

    public static String e() {
        String string = vup.vvg(vuq);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'E', 'n', 'd'});
        vuq = new SoftReference<String>(string);
        return string;
    }

    public static String w() {
        String string = vup.vvg(vur);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'W', 'a', 'r', 'd', 'e', 'n'});
        vur = new SoftReference<String>(string);
        return string;
    }

    public static String m() {
        String string = vup.vvg(vus);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'M', 'i', 'n', 'e'});
        vus = new SoftReference<String>(string);
        return string;
    }

    public static String s() {
        String string = vup.vvg(vut);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'S', 'w', 'a', 'p'});
        vut = new SoftReference<String>(string);
        return string;
    }

    public static String t() {
        String string = vup.vvg(vuu);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'T', 'o', 't', 'e', 'm'});
        vuu = new SoftReference<String>(string);
        return string;
    }

    public static String l() {
        String string = vup.vvg(vuv);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'T', 'o', 'o', 'l'});
        vuv = new SoftReference<String>(string);
        return string;
    }

    public static String c() {
        String string = vup.vvg(vuw);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'M', 'a', 'c', 'e'});
        vuw = new SoftReference<String>(string);
        return string;
    }

    public static String o() {
        String string = vup.vvg(vux);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'C', 'o', 'l', 'l', 'e', 'c', 't', 'o', 'r'});
        vux = new SoftReference<String>(string);
        return string;
    }

    public static String a() {
        String string = vup.vvg(vuy);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'A', 'c', 'c', 'e', 'p', 't'});
        vuy = new SoftReference<String>(string);
        return string;
    }

    public static String k() {
        String string = vup.vvg(vuz);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'K', 'i', 'l', 'l', 'A', 'u', 'r', 'a'});
        vuz = new SoftReference<String>(string);
        return string;
    }

    public static String i() {
        String string = vup.vvg(vva);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't'});
        vva = new SoftReference<String>(string);
        return string;
    }

    public static String g() {
        String string = vup.vvg(vvb);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'T', 'r', 'i', 'g', 'g', 'e', 'r', 'B', 'o', 't'});
        vvb = new SoftReference<String>(string);
        return string;
    }

    public static String n() {
        String string = vup.vvg(vvc);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'N', 'e', 'u', 'r', 'o', 'A', 'i', 'm'});
        vvc = new SoftReference<String>(string);
        return string;
    }

    public static String p() {
        String string = vup.vvg(vvd);
        if (string != null) {
            return string;
        }
        string = vup.vvh(new char[]{'A', 'u', 't', 'o', 'S', 'p', 'r', 'i', 'n', 't'});
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

