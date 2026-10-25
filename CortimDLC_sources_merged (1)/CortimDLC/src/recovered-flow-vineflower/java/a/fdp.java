package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;
import org.lwjgl.glfw.GLFW;

final class fdp {
   private static final String fdq = System.getenv()
      .getOrDefault(a.c(231149979, "ᇏ桴\ue2a4糍\uf77f熣쯮䈋\udc53囱턼⭂ꖗ㰻뙡ゟ諕ԍ"), a.d("\ue2f7魲ᆦ迄Ц芦㣣넕", 146637828, -1505270086));

   private fdp() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      if (var1 == 1) {
         GLFW.glfwSetWindowSize(var0.getWindow().getHandle(), 1600, 900);
      }

      if (var1 == 20) {
         tiq var2 = tiq.open(fdq);
         System.out
            .println(
               a.d("衹\uf1dc笈\ue56a滼\ue81e削\udbba䗴콈䢝늣㰠ꖀ⿅ꤳጨ鲩ؘ联প珴﵂暚\ue0a0", -1612905752, 2048756457)
                  + fdq
                  + a.d("녗주", -52326856, 1386692439)
                  + (
                     var2 == null
                        ? a.b("奈肹ੰ鐁ῌ饺⌠", -1512048282)
                        : var2.purpose() + a.b("똻쾆䔔\udb71傡혃民\ue5ad篰\uf14a皘賠ɻ", -1603684838) + (var2.auraModel() != null)
                  )
            );
         ldr.activate(var2);
         var0.setScreen(new hlc());
      }

      if (var1 == 32) {
         ign.open();
      }

      if (var1 == 65) {
         System.out.println(a.c(2095983040, "⦦倁\udadb䒠켱䧔\uf396穱\ue429滌\ue95eጻ鷫щ蹖ࣹ늱㵡ꟃ↟ꡮ"));
         ScreenshotRecorder.saveScreenshot(
            var0.runDirectory, a.c(111842120, "錻\uea80恐︹疫\uf305䤚샿座퐅厚ꦵ❥뻕㒗뉫ࠢ螲ᵟ鬐ዮ"), var0.getFramebuffer(), 1, var0x -> System.out.println("" + var0x.getString())
         );
      }

      if (var1 == 75) {
         var0.setScreen(null);
         return true;
      } else {
         return false;
      }
   }
}
