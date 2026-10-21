/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 */
package a;

import flow.dev.StringDecryptor;
import net.fabricmc.loader.api.FabricLoader;

public final class IasCompat {
    public static final String DOWNLOAD = "https://modrinth.com/mod/in-game-account-switcher/versions?g=1.21.11&l=fabric";
    private static Boolean jro;
    private static /* synthetic */ long jrp;
    private static /* synthetic */ int jrq;

    private IasCompat() {
    }

    public static boolean available() {
        if (jro == null) {
            boolean bl;
            try {
                bl = FabricLoader.getInstance().isModLoaded("ias");
                if (bl) {
                    Class.forName("ru.vidtu.ias.config.IASStorage", false, IasCompat.class.getClassLoader());
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
        return IasCompat.apo(n, n2) * n2;
    }
}

