/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 */
package a;

import a.CameraOffset;
import a.ClickGuiScreen;
import a.GuiConfig;
import a.LanguageScreen;
import a.WheelScreen;
import a.Hud;
import a.HudEditorScreen;
import a.NowPlaying;
import a.AccountsScreen;
import a.PanoramaHook;
import a.MenuScreen;
import a.WelcomeScreen;
import a.Module;
import a.ModuleManager;
import a.RecorderHooks;
import a.PartyClient;
import a.FxPipeline;
import a.Sounds;
import a.WeatherSounds;
import a.PacketGate;
import a.OptionOverride;
import a.WindowKeyHook;
import a.whl;
import flow.Flow;
import flow.bot.BotScreen;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_442;

public final class PanicShutdown {
    private static volatile boolean drz;
    private static volatile long dsa;
    private static /* synthetic */ int dsb;
    private static /* synthetic */ int dsc;

    private PanicShutdown() {
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
        PanicShutdown.dsd(ConfigManager::autoSaveLater);
        PanicShutdown.dsd(GuiConfig::saveLater);
        drz = true;
        dsa = System.currentTimeMillis();
        class_310 class_3102 = class_310.method_1551();
        PanicShutdown.dsd(() -> {
            ModuleManager kfx2 = Flow.getInstance().getModuleManager();
            if (kfx2 != null) {
                for (Module kfe2 : kfx2.getModules()) {
                    PanicShutdown.dsd(() -> kfe2.setEnabledSilently(false));
                }
            }
        });
        PanicShutdown.dsd(() -> Hud.ENABLED.set(false));
        PanicShutdown.dsd(Cosmetics::clearAll);
        PanicShutdown.dsd(PartyClient::leave);
        PanicShutdown.dsd(RecorderHooks::stop);
        PanicShutdown.dsd(() -> PacketGate.setActive(false));
        PanicShutdown.dsd(OptionOverride::releaseAll);
        PanicShutdown.dsd(() -> WindowKeyHook.shutdown(class_3102));
        PanicShutdown.dsd(NowPlaying::shutdown);
        PanicShutdown.dsd(Sounds::shutdown);
        PanicShutdown.dsd(WeatherSounds::shutdown);
        if (class_3102 == null) {
            return;
        }
        class_3102.execute(() -> {
            PanicShutdown.dsd(() -> PanoramaHook.uninstall(class_3102));
            PanicShutdown.dsd(() -> CameraOffset.uninstall(class_3102));
            PanicShutdown.dsd(FxPipeline::restoreVanilla);
            PanicShutdown.dsd(whl::stopAll);
            PanicShutdown.dsd(() -> {
                if (PanicShutdown.ours(class_3102.field_1755)) {
                    class_3102.method_1507((class_437)(class_3102.field_1687 == null ? new class_442() : null));
                }
            });
        });
    }

    public static boolean ours(class_437 class_4372) {
        return class_4372 instanceof ClickGuiScreen || class_4372 instanceof MenuScreen || class_4372 instanceof HudEditorScreen || class_4372 instanceof BotScreen || class_4372 instanceof AccountsScreen || class_4372 instanceof WheelScreen || class_4372 instanceof WelcomeScreen || class_4372 instanceof LanguageScreen;
    }

    public static void shut(class_310 class_3102, class_437 class_4372) {
        class_3102.method_63588(() -> {
            if (class_3102.field_1755 == class_4372) {
                class_3102.method_1507((class_437)(class_3102.field_1687 == null ? new class_442() : null));
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

