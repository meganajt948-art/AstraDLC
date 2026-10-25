/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 */
package a;

import a.ett;
import a.hlc;
import a.hyz;
import a.ida;
import a.iwf;
import a.izx;
import a.jbs;
import a.jgn;
import a.jos;
import a.jrr;
import a.jte;
import a.kct;
import a.kfe;
import a.kfx;
import a.tcz;
import a.ucg;
import a.ukl;
import a.voa;
import a.vss;
import a.vwy;
import a.wbu;
import a.wek;
import a.whl;
import flow.Flow;
import flow.bot.BotScreen;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;

public final class dry {
    private static volatile boolean drz;
    private static volatile long dsa;
    private static /* synthetic */ int dsb;
    private static /* synthetic */ int dsc;

    private dry() {
    }

    public static boolean armed() {
        return drz;
    }

    public static long since() {
        return dsa;
    }

    public static synchronized void trigger() {
        if (drz) {
            return;
        }
        dry.dsd(ConfigManager::autoSaveLater);
        dry.dsd(hyz::saveLater);
        drz = true;
        dsa = System.currentTimeMillis();
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        dry.dsd(() -> {
            kfx kfx2 = Flow.getInstance().getModuleManager();
            if (kfx2 != null) {
                for (kfe kfe2 : kfx2.getModules()) {
                    dry.dsd(() -> kfe2.setEnabledSilently(false));
                }
            }
        });
        dry.dsd(() -> izx.ENABLED.set(false));
        dry.dsd(Cosmetics::clearAll);
        dry.dsd(ucg::leave);
        dry.dsd(tcz::stop);
        dry.dsd(() -> vwy.setActive(false));
        dry.dsd(wbu::releaseAll);
        dry.dsd(() -> wek.shutdown(minecraftClient));
        dry.dsd(jgn::shutdown);
        dry.dsd(voa::shutdown);
        dry.dsd(vss::shutdown);
        if (minecraftClient == null) {
            return;
        }
        minecraftClient.execute(() -> {
            dry.dsd(() -> jrr.uninstall(minecraftClient));
            dry.dsd(() -> ett.uninstall(minecraftClient));
            dry.dsd(ukl::restoreVanilla);
            dry.dsd(whl::stopAll);
            dry.dsd(() -> {
                if (dry.ours(minecraftClient.field_1755)) {
                    minecraftClient.method_1507((Screen)(minecraftClient.field_1687 == null ? new TitleScreen() : null));
                }
            });
        });
    }

    public static boolean ours(Screen screen) {
        return screen instanceof hlc || screen instanceof jte || screen instanceof jbs || screen instanceof BotScreen || screen instanceof jos || screen instanceof iwf || screen instanceof kct || screen instanceof ida;
    }

    public static void shut(MinecraftClient minecraftClient, Screen screen) {
        minecraftClient.method_63588(() -> {
            if (minecraftClient.field_1755 == screen) {
                minecraftClient.method_1507((Screen)(minecraftClient.field_1687 == null ? new TitleScreen() : null));
            }
        });
    }

    private static void dsd(Runnable runnable) {
        try {
            runnable.run();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int g(int n, int n2) {
        return n * n2 ^ 0x8FB11766;
    }
}

