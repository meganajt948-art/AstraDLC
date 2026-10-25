/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eul;
import flow.dev.a;
import java.io.IOException;
import java.io.InputStream;

public final class ezj {
    private static final String[] ezk = new String[]{a.b("\ue42b\u9dd3\u170a\u8978\u02b7\u845e\u3e54\ub7ba\u29e8\ua358\u2481\udeb0", 1740563464), a.d("\uf010\u89e8\u0331\u9d43\u168c\u9065\u2a7a\ua387\u3dc4\ub76b\u30b0\ucad0\u441a\udda1\u57e2\ud14f", 1123916396, 1545693763), a.c(438051307, "\u21d5\u582d\ud2f4\u4c86\uc749\u41a0\ufbab\u724c\uec1e\u66af\ue160\u1b00\u95c6\u0c62\u8626\u00d6\ubac5"), a.b("\u93fd\uea05\u60dc\ufeae\u7561\uf388\u4999\uc060\u5e34\ud49e\u5317", 1158190041), a.c(-1986876740, "\uaa9d\ud365\u59bc\uc7ce\u4c01\ucae8\u70f5\uf913\u675b\uedff\u6a39\u905b\u1e8d\u8760"), a.b("\ud0a7\ua95f\u2386\ubdf4\u363b\ub0d2\u0acd\u833e\u1d70\u97c5\u1001\uea7b\u64a5\ufd5a", -335097722), a.b("\u2bf5\u520d\ud8d4\u46a6\ucd69\u4b80\uf18f\u7862\ue627\u6c8d\ueb54\u1132\u9fb9\u0650\u8c11\u0ae4\ub0be\u3f73\ua5cd\u238b\uaa21", -1761727537)};
    private static /* synthetic */ String ezl;
    private static /* synthetic */ long ezm;

    private ezj() {
    }

    private static boolean ezn(String string) {
        return string != null && string.length() <= 512 && !string.contains(a.d("\uc998\ub029", -750130496, 161293172)) && !string.contains(a.c(393230726, "\u39db")) && !string.contains(a.c(1088129160, "\u88a5\uf114"));
    }

    public static InputStream open(String string) throws IOException {
        for (String string2 : ezk) {
            if (!string.startsWith(string2)) continue;
            return eul.open(string);
        }
        if (!ezj.ezn(string)) {
            throw new IOException(a.b("\u32f9\u4b4b\uc19d\u5fa8\ud42d\u528b\ue8ce\u6123\uff66\u75d0\uf212\u0865\u86f7\u1f16\u9554\u13b0\ua9e3", -1830604150));
        }
        InputStream inputStream = ezj.class.getResourceAsStream(string);
        if (inputStream == null) {
            throw new IOException(a.b("\udfcd\ua678\u2cb1\ub2c0\u390d\ubfbb\u05e1\u8c57", 1461444520) + string);
        }
        return inputStream;
    }

    public static byte[] bytes(String string) throws IOException {
        for (String string2 : ezk) {
            if (!string.startsWith(string2)) continue;
            return eul.bytes(string);
        }
        if (!ezj.ezn(string)) {
            throw new IOException(a.c(-1081457980, "\u42b7\u3b05\ub1d3\u2fe6\ua463\u22c5\u9880\u116d\u8f28\u059e\u825c\u782b\uf6b9\u6f58\ue51a\u63fe\ud9ad"));
        }
        try (InputStream inputStream = ezj.class.getResourceAsStream(string);){
            if (inputStream == null) {
                throw new IOException(a.d("\uc14b\ub8fe\u3237\uac46\u278b\ua13d\u1b67\u92d1", -177354787, -869857549) + string);
            }
            byte[] byArray = inputStream.readAllBytes();
            return byArray;
        }
    }

    private static /* synthetic */ int mq(int n, int n2) {
        return n * n2 ^ 0xECD7612D;
    }

    private static /* synthetic */ int mr(int n, int n2) {
        return ezj.mq(n, n2) + n;
    }

    private static /* synthetic */ int ms(int n, int n2) {
        return ezj.mr(n, n2) ^ 0xA29B4332;
    }
}

