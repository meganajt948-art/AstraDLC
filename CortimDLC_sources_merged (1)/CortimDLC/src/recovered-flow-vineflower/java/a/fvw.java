package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;

final class fvw {
   private fvw() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      Screen var2 = var0.currentScreen;
      switch (var1) {
         case 1:
            var0.getNetworkHandler().sendChatCommand(a.c(206856521, "愰ᢜ鉋ల螠ł묇㋧곬♋ꆞ寯픸"));
            break;
         case 60:
            fwc(var0, a.b("娄⎺ꥲ㜂볒㩿耱\u09d1韇ᴬ髧悋\uee42矻", 1038375532));
            break;
         case 62:
            var0.setScreen(new ChatScreen("", false));
            break;
         case 100:
            fwc(var0, a.d("\uabee퉐墘웨䴸쮕燛\uf83b昭\uecd2權酲ᾰ", -1380226419, -1992507128));
            break;
         case 102:
            var0.setScreen(null);
            wap.set(wam.RU);
            fvz(var0);
            break;
         case 150:
            fwc(var0, a.c(1531803911, "祲Ì訄ᑴ龤ᤉꍇ⪧뒱㹊릋䏦쵵咊\uded5堦\ue266涴\uf712"));
            break;
         case 152:
            fwa(var2, 400.0F, 23.0F, 0);

            for (char var6 : a.c(1995684410, "멊쏽䤵흊").toCharArray()) {
               var2.charTyped(new CharInput(var6, 0));
            }
            break;
         case 170:
            fwa(var2, 200.0F, 69.0F, 1);
            break;
         case 200:
            fwc(var0, a.d("嵞ⓠ긨じ뮈㴥蝫\u0e8b邝ᩦ鶧柊\ue959炱\ufae4簎왏䦞팯啩\udc8eꛒ⡺", 849381698, -988031891));
            break;
         case 202:
            for (int var3 = 0; var3 < 3; var3++) {
               var2.keyPressed(new KeyInput(256, 0, 0));
            }
      }

      return var1 >= 215;
   }

   private static void fvz(MinecraftClient var0) throws Exception {
      Field var1 = hlc.class.getDeclaredField(a.d("\udd68\ua4cc⸜끄㮽봐", -1607629551, -1950787573));
      var1.setAccessible(true);
      var1.set(null, a.d("椇ႚ驋е迡ॅ", -473880015, 1275675507));

      for (String var5 : new String[]{a.d("갩햆归섩䫵챜瘠", -1602852161, -219101466), a.d("䏁㩮낺⻁ꔝ⎴駉", -1745119362, -1286417201)}) {
         Field var6 = hlc.class.getDeclaredField(var5);
         var6.setAccessible(true);
         var6.setFloat(null, Float.NaN);
      }

      var0.setScreen(new hlc());
   }

   private static void fwa(Screen var0, float var1, float var2, int var3) throws Exception {
      if (var0 instanceof hlc) {
         float var4 = fwb(var0, a.c(204217489, "᳹敕\uef9d燢層粍웨"));
         float var5 = fwb(var0, a.b("眽ຑ葙ᨦ釿ᝉ괭", 1636071253));
         float var6 = fwb(var0, a.d("䲵㔔뿅↹ꩧ", 1629125131, -118999352));
         var0.mouseClicked(new Click(var4 + var1 * var6, var5 + var2 * var6, new MouseInput(var3, 0)), false);
      }
   }

   private static float fwb(Object var0, String var1) throws Exception {
      Field var2 = var0.getClass().getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.getFloat(var0);
   }

   private static void fwc(MinecraftClient var0, String var1) {
      System.out
         .println(a.d("磀ŧ讽ᗆ鹗ᢲꋰ⬗땏㾪", 1758870791, -1813559874) + var1 + a.c(-462910363, "豆\uf597缤") + var0.getCurrentFps() + a.c(-1650675153, "눋쯼䄹\udf4b"));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(-1692160232, "꽸훃尓쉺䧨콆") + var1 + a.d("䂆㥩뎤ⷜ", 554766139, 1322143639),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
