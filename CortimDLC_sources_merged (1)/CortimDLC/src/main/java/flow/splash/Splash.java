/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_4011
 *  net.minecraft.class_4071
 *  net.minecraft.class_425
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 */
package flow.splash;

import a.PanoramaHook;
import a.MenuScreen;
import a.MenuArtCache;
import a.MenuSceneRenderer;
import a.WallpaperEntry;
import a.WordmarkAnimator;
import a.Reflect;
import a.whl;
import flow.splash.ClientLoad;
import flow.splash.FlowSplash;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.class_310;
import net.minecraft.class_4011;
import net.minecraft.class_4071;
import net.minecraft.class_425;
import net.minecraft.class_437;
import net.minecraft.class_442;

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

    public static void preview(class_310 mc, final float seconds, boolean injected) {
        final long start = System.nanoTime();
        final CompletableFuture done = new CompletableFuture();
        class_4011 fake = new class_4011(){

            public CompletableFuture<?> method_18364() {
                if (!done.isDone() && this.method_18229() >= 1.0f) {
                    done.complete(null);
                }
                return done;
            }

            public float method_18229() {
                return Math.min(1.0f, (float)(System.nanoTime() - start) / 1.0E9f / seconds);
            }
        };
        mc.method_18502((class_4071)new FlowSplash(mc, fake, result -> {}, true, injected));
    }

    public static void tick(class_310 mc) {
        if (!ENABLED || failed) {
            ClientLoad.frame();
            return;
        }
        try {
            boolean artReady;
            class_4071 overlay = mc.method_18506();
            boolean bl = artReady = !pending || MenuArtCache.decoded(WallpaperEntry.selected().key) || ++artWait > 40;
            if (pending && artReady) {
                artWait = 0;
                if (overlay == null) {
                    pending = false;
                    mc.method_1521();
                    Splash.adopt(mc, true);
                } else if (overlay instanceof FlowSplash) {
                    FlowSplash splash = (FlowSplash)overlay;
                    pending = false;
                    splash.markInjected();
                } else if (overlay instanceof class_425) {
                    pending = false;
                    Splash.adopt(mc, true);
                }
            } else if (overlay instanceof class_425 && !(overlay instanceof FlowSplash)) {
                Splash.adopt(mc, false);
            }
            if (mc.method_18506() instanceof FlowSplash) {
                idle = 0;
            } else {
                ClientLoad.frame();
                if (idle < 100 && ++idle == 4) {
                    FlowSplash.release();
                }
            }
            FlowSplash.collectReleased();
            MenuSceneRenderer.collect();
            whl.tick();
            WordmarkAnimator.collectClosed();
            if (MENU) {
                PanoramaHook.tick(mc);
            }
            if (mc.method_18506() == null && mc.field_1755 instanceof class_442 && MENU && !pending) {
                mc.method_1507((class_437)new MenuScreen());
            }
        }
        catch (Throwable t) {
            failed = true;
            System.out.println("splash disabled: " + t);
        }
    }

    private static void adopt(class_310 mc, boolean injected) throws IllegalAccessException {
        boolean reloading;
        class_425 vanilla;
        class_4071 class_40712 = mc.method_18506();
        if (!(class_40712 instanceof class_425) || (vanilla = (class_425)class_40712) instanceof FlowSplash) {
            return;
        }
        Splash.lookup();
        if (reloadField == null || handlerField == null) {
            return;
        }
        if (completeField != null && completeField.getLong(vanilla) != -1L) {
            return;
        }
        class_4011 reload = (class_4011)reloadField.get(vanilla);
        Consumer handler = (Consumer)handlerField.get(vanilla);
        boolean bl = reloading = reloadingField == null || reloadingField.getBoolean(vanilla);
        if (reload == null || handler == null) {
            return;
        }
        mc.method_18502((class_4071)new FlowSplash(mc, reload, handler, reloading, injected));
    }

    private static void lookup() {
        if (lookedUp) {
            return;
        }
        lookedUp = true;
        for (Field f : class_425.class.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            Class<?> type = f.getType();
            if (type == class_4011.class) {
                reloadField = f;
            } else if (type == Consumer.class) {
                handlerField = f;
            } else {
                if (type != Boolean.TYPE) continue;
                reloadingField = f;
            }
            f.setAccessible(true);
        }
        completeField = Reflect.find(class_425.class, "net.minecraft.class_425", "field_17771", "J");
    }
}

