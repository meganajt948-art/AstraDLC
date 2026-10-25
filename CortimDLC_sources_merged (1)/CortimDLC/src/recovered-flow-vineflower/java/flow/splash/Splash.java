package flow.splash;

import a.jrr;
import a.jte;
import a.jzh;
import a.kap;
import a.kbs;
import a.kce;
import a.vxr;
import a.whl;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
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

   public static void preview(MinecraftClient mc, float seconds, boolean injected) {
      final long start = System.nanoTime();
      final CompletableFuture<Void> done = new CompletableFuture<>();
      ResourceReload fake = new ResourceReload() {
         public CompletableFuture<?> method_18364() {
            if (!done.isDone() && this.method_18229() >= 1.0F) {
               done.complete(null);
            }

            return done;
         }

         public float method_18229() {
            return Math.min(1.0F, (float)(System.nanoTime() - start) / 1.0E9F / seconds);
         }
      };
      mc.method_18502(new FlowSplash(mc, fake, result -> {}, true, injected));
   }

   public static void tick(MinecraftClient mc) {
      if (ENABLED && !failed) {
         try {
            Overlay overlay = mc.method_18506();
            boolean artReady = !pending || jzh.decoded(kbs.selected().key) || ++artWait > 40;
            if (pending && artReady) {
               artWait = 0;
               if (overlay == null) {
                  pending = false;
                  mc.method_1521();
                  adopt(mc, true);
               } else if (overlay instanceof FlowSplash splash) {
                  pending = false;
                  splash.markInjected();
               } else if (overlay instanceof SplashOverlay) {
                  pending = false;
                  adopt(mc, true);
               }
            } else if (overlay instanceof SplashOverlay && !(overlay instanceof FlowSplash)) {
               adopt(mc, false);
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
            kap.collect();
            whl.tick();
            kce.collectClosed();
            if (MENU) {
               jrr.tick(mc);
            }

            if (mc.method_18506() == null && mc.field_1755 instanceof TitleScreen && MENU && !pending) {
               mc.method_1507(new jte());
            }
         } catch (Throwable var4) {
            failed = true;
            System.out.println("splash disabled: " + var4);
         }
      } else {
         ClientLoad.frame();
      }
   }

   private static void adopt(MinecraftClient mc, boolean injected) throws IllegalAccessException {
      if (mc.method_18506() instanceof SplashOverlay vanilla && !(vanilla instanceof FlowSplash)) {
         lookup();
         if (reloadField != null && handlerField != null) {
            if (completeField == null || completeField.getLong(vanilla) == -1L) {
               ResourceReload reload = (ResourceReload)reloadField.get(vanilla);
               Consumer<Optional<Throwable>> handler = (Consumer<Optional<Throwable>>)handlerField.get(vanilla);
               boolean reloading = reloadingField == null || reloadingField.getBoolean(vanilla);
               if (reload != null && handler != null) {
                  mc.method_18502(new FlowSplash(mc, reload, handler, reloading, injected));
               }
            }
         }
      }
   }

   private static void lookup() {
      if (!lookedUp) {
         lookedUp = true;

         for (Field f : SplashOverlay.class.getDeclaredFields()) {
            if (!Modifier.isStatic(f.getModifiers())) {
               Class<?> type = f.getType();
               if (type == ResourceReload.class) {
                  reloadField = f;
               } else if (type == Consumer.class) {
                  handlerField = f;
               } else {
                  if (type != boolean.class) {
                     continue;
                  }

                  reloadingField = f;
               }

               f.setAccessible(true);
            }
         }

         completeField = vxr.find(SplashOverlay.class, "net.minecraft.class_425", "field_17771", "J");
      }
   }
}
