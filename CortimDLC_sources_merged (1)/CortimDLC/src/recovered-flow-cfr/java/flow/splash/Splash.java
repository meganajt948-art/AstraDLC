/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Overlay
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.SplashOverlay
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.resource.ResourceReload
 */
package flow.splash;

import a.jrr;
import a.jte;
import a.jzh;
import a.kap;
import a.kbs;
import a.kce;
import a.vxr;
import a.whl;
import flow.splash.ClientLoad;
import flow.splash.FlowSplash;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.resource.ResourceReload;

public final class Splash {
    private static final boolean ENABLED = !"false".equalsIgnoreCase(System.getProperty("flow2.splash"));
    public static final boolean MENU = !"false".equalsIgnoreCase(System.getProperty("flow2.menu"));
    private static volatile boolean pending;
    private static boolean requested;
    private static boolean lookedUp;
    private static Field reloadField;
    private static Field handlerField;
    private static Field reloadingField;
    private static Field completeField;
    private static int idle;
    private static int artWait;
    private static boolean failed;

    private Splash() {
    }

    public static synchronized void requestAfterInject() {
        if (!requested) {
            requested = true;
            pending = true;
        }
    }

    public static boolean pending() {
        return pending;
    }

    public static void preview(MinecraftClient mc, final float seconds, boolean injected) {
        final long start = System.nanoTime();
        final CompletableFuture done = new CompletableFuture();
        ResourceReload fake = new ResourceReload(){

            public CompletableFuture<?> whenComplete() {
                if (!done.isDone() && this.getProgress() >= 1.0f) {
                    done.complete(null);
                }
                return done;
            }

            public float getProgress() {
                return Math.min(1.0f, (float)(System.nanoTime() - start) / 1.0E9f / seconds);
            }
        };
        mc.setOverlay((Overlay)new FlowSplash(mc, fake, result -> {}, true, injected));
    }

    public static void tick(MinecraftClient mc) {
        if (!ENABLED || failed) {
            ClientLoad.frame();
            return;
        }
        try {
            boolean artReady;
            Overlay overlay = mc.getOverlay();
            boolean bl = artReady = !pending || jzh.decoded(kbs.selected().key) || ++artWait > 40;
            if (pending && artReady) {
                artWait = 0;
                if (overlay == null) {
                    pending = false;
                    mc.reloadResources();
                    Splash.adopt(mc, true);
                } else if (overlay instanceof FlowSplash) {
                    FlowSplash splash = (FlowSplash)overlay;
                    pending = false;
                    splash.markInjected();
                } else if (overlay instanceof SplashOverlay) {
                    pending = false;
                    Splash.adopt(mc, true);
                }
            } else if (overlay instanceof SplashOverlay && !(overlay instanceof FlowSplash)) {
                Splash.adopt(mc, false);
            }
            if (mc.getOverlay() instanceof FlowSplash) {
                idle = 0;
            } else {
                ClientLoad.frame();
                if (idle < 100 && ++idle == 4) {
                    FlowSplash.release();
                }
            }
            FlowSplash.collectReleased();
            kap.collect();
            whl.tick();
            kce.collectClosed();
            if (MENU) {
                jrr.tick(mc);
            }
            if (mc.getOverlay() == null && mc.currentScreen instanceof TitleScreen && MENU && !pending) {
                mc.setScreen((Screen)new jte());
            }
        }
        catch (Throwable t) {
            failed = true;
            System.out.println("splash disabled: " + t);
        }
    }

    private static void adopt(MinecraftClient mc, boolean injected) throws IllegalAccessException {
        boolean reloading;
        SplashOverlay vanilla;
        Overlay overlay = mc.getOverlay();
        if (!(overlay instanceof SplashOverlay) || (vanilla = (SplashOverlay)overlay) instanceof FlowSplash) {
            return;
        }
        Splash.lookup();
        if (reloadField == null || handlerField == null) {
            return;
        }
        if (completeField != null && completeField.getLong(vanilla) != -1L) {
            return;
        }
        ResourceReload reload = (ResourceReload)reloadField.get(vanilla);
        Consumer handler = (Consumer)handlerField.get(vanilla);
        boolean bl = reloading = reloadingField == null || reloadingField.getBoolean(vanilla);
        if (reload == null || handler == null) {
            return;
        }
        mc.setOverlay((Overlay)new FlowSplash(mc, reload, handler, reloading, injected));
    }

    private static void lookup() {
        if (lookedUp) {
            return;
        }
        lookedUp = true;
        for (Field f : SplashOverlay.class.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            Class<?> type = f.getType();
            if (type == ResourceReload.class) {
                reloadField = f;
            } else if (type == Consumer.class) {
                handlerField = f;
            } else {
                if (type != Boolean.TYPE) continue;
                reloadingField = f;
            }
            f.setAccessible(true);
        }
        completeField = vxr.find(SplashOverlay.class, "net.minecraft.class_425", "field_17771", "J");
    }
}

