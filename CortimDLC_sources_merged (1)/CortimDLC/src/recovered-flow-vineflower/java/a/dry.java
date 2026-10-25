package a;

import flow.Flow;
import flow.bot.BotScreen;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;

public final class dry {
   static volatile boolean drz;
   static volatile long dsa;

   dry() {
   }

   public static boolean armed() {
      return drz;
   }

   public static long since() {
      return dsa;
   }

   public static synchronized void trigger() {
      if (!drz) {
         dsd(ConfigManager::autoSaveLater);
         dsd(hyz::saveLater);
         drz = true;
         dsa = System.currentTimeMillis();
         MinecraftClient var0 = MinecraftClient.getInstance();
         dsd(() -> {
            kfx var0x = Flow.getInstance().getModuleManager();
            if (var0x != null) {
               for (kfe var2 : var0x.getModules()) {
                  dsd(() -> var2.setEnabledSilently(false));
               }
            }
         });
         dsd(() -> izx.ENABLED.set(false));
         dsd(Cosmetics::clearAll);
         dsd(ucg::leave);
         dsd(tcz::stop);
         dsd(() -> vwy.setActive(false));
         dsd(wbu::releaseAll);
         dsd(() -> wek.shutdown(var0));
         dsd(jgn::shutdown);
         dsd(voa::shutdown);
         dsd(vss::shutdown);
         if (var0 != null) {
            var0.execute(() -> {
               dsd(() -> jrr.uninstall(var0));
               dsd(() -> ett.uninstall(var0));
               dsd(ukl::restoreVanilla);
               dsd(whl::stopAll);
               dsd(() -> {
                  if (ours(var0.currentScreen)) {
                     var0.setScreen(var0.world == null ? new TitleScreen() : null);
                  }
               });
            });
         }
      }
   }

   public static boolean ours(Screen var0) {
      return var0 instanceof hlc
         || var0 instanceof jte
         || var0 instanceof jbs
         || var0 instanceof BotScreen
         || var0 instanceof jos
         || var0 instanceof iwf
         || var0 instanceof kct
         || var0 instanceof ida;
   }

   public static void shut(MinecraftClient var0, Screen var1) {
      var0.send(() -> {
         if (var0.currentScreen == var1) {
            var0.setScreen(var0.world == null ? new TitleScreen() : null);
         }
      });
   }

   static void dsd(Runnable var0) {
      try {
         var0.run();
      } catch (Throwable var2) {
      }
   }
}
