/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 */
package a;

import flow.dev.a;
import net.fabricmc.loader.api.FabricLoader;

public final class jrn {
    public static final String DOWNLOAD = a.d("\ud691\uaf3c\u25ef\ubb9a\u304e\ub6b6\u0cf0\u8501\u1b1c\u91af\u1677\uec10\u62dc\ufb6a\u7123\uf7ce\u4dc7\uc25b\u58e4\udeb7\u5702\u2d11\ua3a0\u387a\ube4e\u34d9\u8d6d\u037f\u99c2\u1f95\u942a\u6af3\ue0f4\u7949\uff18\u75a9\uca72\u4019\uc6d1\u5f7a\ud57c\uabd3\u2184\ua62b\u3ce1\ub287\u0b5f\u81e3\u07bb\u9c37\u121d\ue8df\u617f\ue72f\u7dc6\uf391\u482f\ucee3\u44dc\udd55\u53b8\u29e5\uae09\u2444\uba88\u3326\u896a\u0f9b\u85db\u1a20\u90a2\u1688\uef50\u65e2\ufba1\u704b\uf616", -1517792795, 982288209);
    private static Boolean jro;
    private static /* synthetic */ long jrp;
    private static /* synthetic */ int jrq;

    private jrn() {
    }

    public static boolean available() {
        if (jro == null) {
            boolean bl;
            try {
                bl = FabricLoader.getInstance().isModLoaded(a.c(2009649252, "\ud00e\ua9b7\u2376"));
                if (bl) {
                    Class.forName(a.b("\u74a3\u0d15\u879d\u19b4\u927c\u14c0\uae83\u2773\ub977\u3381\ub45a\u4e39\uc0b3\u594f\ud310\u55e0\uefa7\u6079\ufac4\u7cdc\uf54c\u8f15\u01b4\u9a65\u1c3d\u96f7\u2f59\ua11b\u3bea\ubdb9", -451119921), false, jrn.class.getClassLoader());
                }
            }
            catch (Throwable throwable) {
                bl = false;
            }
            jro = bl;
        }
        return jro;
    }

    private static /* synthetic */ int apo(int n, int n2) {
        return n + n2 + 375636298;
    }

    private static /* synthetic */ int app(int n, int n2) {
        return jrn.apo(n, n2) * n2;
    }
}

