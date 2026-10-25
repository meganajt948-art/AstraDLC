package flow.splash;

import a.ewk;
import a.eyx;
import a.hzl;
import a.vdn;
import a.wap;
import com.mojang.blaze3d.systems.RenderSystem;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BooleanSupplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.resource.ResourceReload;

public final class ClientLoad implements ResourceReload {
   private static final long FRAME_BUDGET_NS = 7000000L;
   private static final long STEP_MAX_MS = 6000L;
   private static final long WARM_MAX_MS = 25000L;
   public static final ClientLoad INSTANCE = new ClientLoad();
   private static volatile ClientLoad.Phase phase = ClientLoad.Phase.DOWNLOAD;
   private static final CompletableFuture<Void> DONE = new CompletableFuture<>();
   private static final Deque<BooleanSupplier> STEPS = new ArrayDeque<>();
   private static int stepsTotal;
   private static int stepsDone;
   private static long stepSince;
   private static long warmSince;
   private static volatile boolean started;
   private static volatile boolean shown;
   private static volatile boolean fallback;
   private static volatile String stage = "";

   private ClientLoad() {
   }

   public static synchronized void start(Runnable boot, boolean overlay) {
      if (!started) {
         started = true;
         Thread worker = new Thread(() -> run(boot, overlay), "Flow2 loading");
         worker.setDaemon(true);
         worker.start();
      }
   }

   private static void run(Runnable boot, boolean overlay) {
      stage = wap.chosen() && !wap.ru() ? "Downloading files" : "Скачиваем файлы";
      Thread files = new Thread(eyx::run, "Flow2 prefetch");
      files.setDaemon(true);
      files.start();

      while (files.isAlive()) {
         MinecraftClient mc = MinecraftClient.getInstance();
         if (overlay && mc != null && mc.getWindow() != null && !shown && !fallback) {
            mc.execute(() -> show(mc));
         }

         try {
            files.join(100L);
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            break;
         }
      }

      try {
         ewk.ensureLoaded();
      } catch (Throwable var8) {
      }

      try {
         Cosmetics.items();
      } catch (Throwable t) {
         System.out.println("[Flow2] cosmetics list not ready: " + t);
      }

      MinecraftClient mc = MinecraftClient.getInstance();

      for (int i = 0; mc == null && i < 1200; i++) {
         try {
            Thread.sleep(100L);
         } catch (InterruptedException e) {
            return;
         }

         mc = MinecraftClient.getInstance();
      }

      if (mc != null) {
         phase = ClientLoad.Phase.BOOT;
         stage = wap.chosen() && !wap.ru() ? "Starting the client" : "Запускаем клиент";
         MinecraftClient client = mc;
         client.execute(() -> {
            try {
               if (overlay) {
                  show(client);
               }

               boot.run();
            } catch (Throwable t) {
               System.out.println("[Flow2] boot failed: " + t);
               t.printStackTrace();
            } finally {
               if (overlay && !shown) {
                  fallback = true;
                  Splash.requestAfterInject();
               }

               warmUp();
            }
         });
      }
   }

   private static void show(MinecraftClient mc) {
      if (!shown && !fallback && phase != ClientLoad.Phase.DONE) {
         Overlay current = mc.getOverlay();
         if (current == null) {
            shown = true;
            mc.setOverlay(new FlowSplash(mc, INSTANCE, ClientLoad::ignore, true, true));
         }
      }
   }

   private static void ignore(Optional<Throwable> result) {
   }

   private static void warmUp() {
      List<BooleanSupplier> steps = new ArrayList<>();

      try {
         hzl.steps(steps);
      } catch (Throwable t) {
         System.out.println("[Flow2] menu warm-up skipped: " + t);
      }

      try {
         for (CosmeticItem it : Cosmetics.items()) {
            steps.add(() -> {
               Cosmetics.warm(it);
               return true;
            });
         }
      } catch (Throwable t) {
         System.out.println("[Flow2] cosmetics warm-up skipped: " + t);
      }

      STEPS.addAll(steps);
      stepsTotal = STEPS.size();
      stepsDone = 0;
      warmSince = System.currentTimeMillis();
      stepSince = warmSince;
      stage = !wap.ru() && wap.chosen() ? "Preparing cosmetics and menus" : "Готовим косметику и меню";
      phase = ClientLoad.Phase.WARM;
      if (STEPS.isEmpty()) {
         finish();
      }
   }

   public static void frame() {
      if (phase == ClientLoad.Phase.WARM && RenderSystem.isOnRenderThread()) {
         long start = System.nanoTime();
         long now = System.currentTimeMillis();
         if (now - warmSince > 25000L) {
            System.out.println("[Flow2] warm-up cut short, " + STEPS.size() + " left for first use");
            STEPS.clear();
         }

         while (!STEPS.isEmpty() && System.nanoTime() - start < 7000000L) {
            BooleanSupplier step = STEPS.peekFirst();

            boolean finished;
            try {
               finished = step.getAsBoolean();
            } catch (Throwable t) {
               finished = true;
            } finally {
               vdn.setRenderScale(1.0F);
            }

            if (!finished && System.currentTimeMillis() - stepSince <= 6000L) {
               STEPS.pollFirst();
               STEPS.addLast(step);
               if (STEPS.size() == 1) {
                  break;
               }
            } else {
               STEPS.pollFirst();
               stepsDone++;
               stepSince = System.currentTimeMillis();
            }
         }

         if (STEPS.isEmpty()) {
            finish();
         }
      }
   }

   private static void finish() {
      if (phase != ClientLoad.Phase.DONE) {
         phase = ClientLoad.Phase.DONE;
         stage = "";
         System.out
            .println("[Flow2] client ready, " + stepsDone + "/" + stepsTotal + " things warmed up in " + (System.currentTimeMillis() - warmSince) + " ms");
         DONE.complete(null);
      }
   }

   public static boolean done() {
      return phase == ClientLoad.Phase.DONE;
   }

   public static String stage() {
      return stage;
   }

   public static float fraction() {
      return switch (phase) {
         case DOWNLOAD -> 0.7F * eyx.fraction();
         case BOOT -> 0.74F;
         case WARM -> 0.76F + 0.24F * (stepsTotal <= 0 ? 1.0F : (float)stepsDone / stepsTotal);
         case DONE -> 1.0F;
      };
   }

   @Override
   public CompletableFuture<?> whenComplete() {
      return DONE;
   }

   @Override
   public float getProgress() {
      return fraction();
   }

   private enum Phase {
      DOWNLOAD,
      BOOT,
      WARM,
      DONE;
   }
}
