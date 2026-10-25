/*
 * Decompiled with CFR 0.152.
 */
package flow.dev;

public final class a {
    private static final int MIX;

    private a() {
    }

    public static String b(String string, int n) {
        int n2 = string.length();
        int n3 = MIX;
        char[] cArray = new char[n2];
        for (int i = 0; i < n2; ++i) {
            int n4 = n ^ i * n3 ^ n2;
            cArray[i] = (char)(string.charAt(i) ^ n4);
        }
        return new String(cArray);
    }

    public static String c(int n, String string) {
        int n2 = string.length();
        int n3 = MIX;
        char[] cArray = new char[n2];
        for (int i = 0; i < n2; ++i) {
            int n4 = n ^ i * n3 ^ n2;
            cArray[i] = (char)(string.charAt(i) ^ n4);
        }
        return new String(cArray);
    }

    public static String d(String string, int n, int n2) {
        int n3 = n ^ n2;
        int n4 = string.length();
        int n5 = MIX;
        char[] cArray = new char[n4];
        for (int i = 0; i < n4; ++i) {
            int n6 = n3 ^ i * n5 ^ n4;
            cArray[i] = (char)(string.charAt(i) ^ n6);
        }
        return new String(cArray);
    }

    static {
        int n = 40503;
        int n2 = 31153;
        MIX = n << 16 | n2;
    }
}

