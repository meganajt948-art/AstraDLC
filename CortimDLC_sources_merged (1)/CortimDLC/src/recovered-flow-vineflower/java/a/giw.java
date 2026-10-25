package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.EndMain;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

final class giw {
   private static final String[] gix = new String[]{
      a.d("踑\uf7a9絺\ue340棖\uee6e吾\udddd䏛쥶", -1341627912, 1678897036),
      a.b("譬\uf2c6砍\ue66a涮\ueb09儓\ud8fe", -1184855280),
      a.b("\u0a37玐凌朼\uecbf樒", -1053226416),
      a.c(272759642, "ﬦ芌ࡇ阠ᷤ魃⅙ꢷ"),
      a.b("策˱蠴ᙝ鷞᭰", -1798800591),
      a.d("릦쀌䫇풠彤\ud9c3揙\uea36", -320253671, -1087641405),
      a.c(-849754467, "웺뽝㖘꯱\u2072ꛝ"),
      a.c(1157937565, "맹쁁䪒풨张\ud98a揗\uea29瑪ﺂ祎"),
      a.b("둄췮䜥\ud942劆퐡渻\ue781秙\uf37a璮躆H駽", 181515326)
   };
   private static final int giy = 10;
   private static Field giz;
   private static Field gja;
   private static boolean gjb;
   private static volatile int gjc;
   private static double gjd = 1000.0;
   private static long gje;
   private static float gjf;

   private giw() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.d("鍳\ueae0怩﹞疟\uf30a䥫삚廟푴厠", -337836748, -192178687));
      if (var1 == 1) {
         var0.options.pauseOnLostFocus = false;
         giz = vxr.find(
            Mouse.class, a.d("꒕\udd2f埭짆䉒쓧纳\uf749椐\ue3b0摰鸆Ⴣ褨̶藈㾊끉⫺겇├彏퇿", -900973984, 632790668), a.b("ㅲ䣌숓屫ힴ儾\ueb03拴ﲤ瘞", 1053176094), a.c(2052076535, "㎬")
         );
         gja = vxr.find(
            MinecraftClient.class, a.c(1581135735, "㜎亴쑶婝퇉坼\ued28擒懲瀫\uf7ebඝ荘᪳邭ᙓ갑⏒륡㼜뚇쳔䉦"), a.d("직끿㪠ꓘ⼇ꦍᎰ驆Ж身", 1381446249, -1430848572), a.c(-873861807, "\ued0a")
         );
         if (!gjb) {
            gjb = true;
            WorldRenderEvents.END_MAIN.register((EndMain)var0x -> gji());
         }

         gjk(var0, a.b("고핗很쇱䨮첝盅Ｕ愯\uebcd氘陮ᢽ脓ୟ趹㟻", 1881648278));
         gjk(var0, a.d("멟쏳䤤흝峏\uda2d恨\ue988瞃ﵼ窮胟ฉ", -2083396961, -512665415));
         gjk(var0, a.b("겋픹忪솘䩉쳯盨～意\ueba1污陕ᣢ腠ୠ跃㞛로⋵꒾ⵎ圊\ud9b6䉪쐓亇\uf77d礫\ue3d4斊\uee3eშ骺͚蕌\u0fef뀿㩎번╭꼴퇂宁", -168514363));
         gjk(var0, a.c(-597724418, "犩ଗ臁ᾰ鐫ዄ꣄℮뽧㖈눈䡥욣彌핌厦\ue9ff晰ﲋ竌\uf365襧߈鰈ᨩ邰⤕꜉㷺뮬〔컃䒝\udd7f嬫톈渑\ue429拤ﭗ焈\u0fe2薭ȫ飐ᚦ꽮◞ꎚ"));
         gjk(var0, a.c(-1418868613, "져놆㭐ꔡ⺺ꡕቕ鮿\u05f6輙\u0894\uf2bb簿\ue595濐\ue97f卸\udcbf䙒쁉䦪㎥뵞⚙ꂫ⩾鏊ᶐ蝡ġ誁瑗︊枵\ue1bd欄퓈"));
         gjk(
            var0,
            a.b(
               "캵뜂㷉ꎸ⡭껝ᓀ鵼̧覑้\uf43e竸\ue35a椎\uefed嗬\uda7d䃛욈佰㔪뮕 ꘠Ⲿ锒᭘膺\u07b5豘狗\uf8d5愷\ue73f涻퉍堒\udec9䜋쵟돽㧠븮Ⓝꪷ፭駗ᾂ萝\u0a65\uf0e7礞Ｓ旵\uebb3倍훆岯앹䯟ㆅ뙻㰬ꋔ⭒鄕០鶫ȁ装ີ\uf734綎\ue38e桠",
               2131938954
            )
         );
         return false;
      } else {
         gjj(var0);
         if (var1 < 40) {
            return false;
         }

         byte var3 = 26;
         int var4 = (var1 - 40) / var3;
         int var5 = (var1 - 40) % var3;
         if (var4 >= gix.length) {
            gjc = 0;
            var2.setEnabled(false);
            return true;
         }

         String var6 = gix[var4];
         if (var5 == 0) {
            var2.setEnabled(!var6.startsWith(a.c(-2039700502, "ꎆ\uda3e僭")));
            var0.player.setYaw(0.0F);
            var0.player.setPitch(0.0F);
         } else if (var5 == 4) {
            gjf = var0.player.getYaw();
            gje = 0L;
            int var7 = Integer.parseInt(var6.substring(var6.lastIndexOf(45) + 1));
            boolean var8 = var6.contains(a.b("喿Ⱅꛈ㢶덽", -1586539064)) || var6.startsWith(a.c(1340571852, "肩癩珋\ueda2"));
            gjc = var8 ? var7 : -var7;
         } else if (var5 == 14) {
            gjc = 0;
         } else if (var5 == 22) {
            double var12 = var0.options.getMouseSensitivity().getValue() * 0.6 + 0.2;
            double var9 = gje * var12 * var12 * var12 * 8.0 * 0.15;
            float var11 = var0.player.getYaw() - gjf;
            System.out
               .printf(
                  a.b("퍋\uaaf8‱빆㖇댵ॲ肐ể鑺Ꮼ\ue998朙ﻡ璨\uf20d䡃잕崺\udb60劖⢃\ua635㷯뮍ㄉ裼۩鰟ᩌ醴潩\ue570粖響灼쾮䗟쌁嫱킫깑␟ꏻ㥪띟ຍ萾Ⱥ駧ំ\ued04撦\ue2ea砟\uf601䶻쭡䄏\ud88b噿ⱥ", 1689572120),
                  var6,
                  var11,
                  var9,
                  Math.abs(var11) / Math.abs(var9)
               );
         }

         return false;
      }
   }

   private static void gji() {
      int var0 = gjc;
      if (var0 != 0) {
         MinecraftClient var1 = MinecraftClient.getInstance();
         long var2 = var1.getWindow().getHandle();
         GLFWCursorPosCallback var4 = GLFW.glfwSetCursorPosCallback(var2, null);
         GLFW.glfwSetCursorPosCallback(var2, var4);
         gjd += var0;
         gje = gje + Math.abs(var0);
         var4.invoke(var2, gjd, 500.0);
      }
   }

   private static void gjj(MinecraftClient var0) throws Exception {
      if (giz != null && var0.currentScreen == null) {
         giz.setBoolean(var0.mouse, true);
      }

      if (gja != null) {
         gja.setBoolean(var0, true);
      }
   }

   private static void gjk(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
