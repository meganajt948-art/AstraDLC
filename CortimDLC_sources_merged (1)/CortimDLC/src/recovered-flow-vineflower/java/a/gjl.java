package a;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LONG;
import com.sun.jna.platform.win32.WinDef.WORD;
import com.sun.jna.platform.win32.WinUser.INPUT;
import flow.Flow;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWNativeWin32;

final class gjl {
   private static final String[] gjm = new String[]{
      a.d("䄸㢀뉓Ⱪꟿⅇ鬗ዴ", 1926793555, 71616524),
      a.b("誚\uf32a禺\ue78a汔\ueae6傧\ud90a䜉춣䩨뀏㻋Ꝭ\u2d72", -743601414),
      a.d("悡ᤑ鎁ද虣Ü몀㍭굮➖ꁓ娴퓻䴚", 312056445, -515441987),
      a.b("ᣴ慌\ueb9f疥︭碇싚䬤핧", -1859774318),
      a.c(1103682452, "\udbf7ꉇ⣗뛧㴹뮋Ǌ衢ᙶ鳀ᬁ\ue177")
   };
   private static final int gjn = 6;
   private static float gjo;

   private gjl() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.b("瘖྅蕌ᬻ郺ᙯ갎◿뮺ㄑ뛅", -1841007024));
      if (var1 == 1) {
         var0.field_1690.field_1837 = false;
         gju(var0, a.b("렠솗䭈픱廮\ud85d戅\uebf5痯－磘芮౽闓ᾟ饹⌻", 503560278));
         gju(var0, a.b("눑쮽䅪\udf13咁퉣栦\ue1c6翍\uf532狠袑ه", -441011608));
         gju(var0, a.c(2118270715, "㺵䜇췔厦\ud877廑\ue4d6浠\uf331禟﹟ѫ諜፞饞´ꖥ⩢냋㚀뽰씴䮈큔嘭\udcb9敃\ueb15燪\uf7b4簀苖ࢄ酤ᝲ鷑∁ꡰ⺶띓㴊䏼즿"));
         gju(var0, a.c(-2102130111, "ਖ玨量朏\uec94橻큻妑쟘䴷쪷ペ븜⟳귳⬙酀ỏ萴ɳ诚\uf1d8罷\ue4b7抖\ue80f冪\udfb6䕅쌓䢫뙼㰢ꗀ⎔ꤷᚮ鲖ᩛ菨ষ睝ﴒ窔\ue06f渙ퟑ嵡\udb25"));
         gju(var0, a.b("銸\ueb06懐ﾡ琺\uf2d5䣕섿彶햙刔\ua83b⚿뼕㕐돿৸蘿᳒髉ጪ椥\ue7de簙飼烾쥊䜐\udde1审퀁⻗ꒊ㴵묽ㆄ蹈", 997102331));
         gju(
            var0,
            a.b("쿏뙸㲳ꋂ⤗꾧ᖺ鰆ɝ裫༳\uf544箂\ue220桴\uee97咖\udb07䆡쟲上㑐뫯ⅻꝚⷄ鑨ᨢ胀ۏ财玭羚恍\ue645況팷奨\udfb3䙱찥늇㢚뽔▹ꯍሗ颭Ỹ蕧ଟ\uf19d硤﹉撏\ueac9具ힼ巕쐃䪥ヿ뜁㵖ꎮ⨨遯ᚚ鳑ͻ覿࿏\uf64e糴\ue2f4椚", -1216753680)
         );
         return false;
      } else {
         if (!var0.method_1569()) {
            gjr(var0);
         }

         if (var0.field_1755 == null && !var0.field_1729.method_1613()) {
            var0.field_1729.method_1612();
         }

         if (var1 < 40) {
            return false;
         } else {
            byte var3 = 30;
            int var4 = (var1 - 40) / var3;
            int var5 = (var1 - 40) % var3;
            if (var4 >= gjm.length) {
               var2.setEnabled(false);
               return true;
            } else {
               if (var5 == 0) {
                  var2.setEnabled(gjm[var4].startsWith(a.d("ꔄ\udcb4", 502728803, 140422410)));
                  var0.field_1724.method_36456(0.0F);
                  var0.field_1724.method_36457(0.0F);
               } else if (var5 == 10) {
                  gjo = var0.field_1724.method_36454();
               } else if (var5 > 10 && var5 <= 16) {
                  int var9 = gjm[var4].contains(a.b("Ṟ柴\ued29獗\uf89c", -118022615)) ? 1 : -1;
                  int var7 = gjm[var4].contains(a.c(857404759, "\uf535貃ق頴")) ? 60 : 8;

                  for (int var8 = 0; var8 < 4; var8++) {
                     gjt(var9 * var7 / 4);
                  }
               } else if (var5 == 28) {
                  float var6 = var0.field_1724.method_36454() - gjo;
                  System.out
                     .printf(
                        a.c(29663991, "ꊯ\udb1c凕쾢䑣싅碁\uf174漦\ue5db戍頪ᚴ輟Ԙ菨㦠뙭ⳕꪅ⌶奢ퟚ䰖쨼䂫樂県\uedf9毣\ue05cị钍൰謵Ƃ빃㐳늹⬐ꄙ\udfbb喤툖䣍운罩\uf5d9珏\ue806昣鲤ᕘ"),
                        gjm[var4],
                        var6,
                        var0.method_1569(),
                        var0.field_1729.method_1613()
                     );
               }

               return false;
            }
         }
      }
   }

   private static void gjr(MinecraftClient var0) {
      HWND var1 = new HWND(new Pointer(GLFWNativeWin32.glfwGetWin32Window(var0.method_22683().method_4490())));
      gjs(18, 0);
      gjs(18, 2);
      User32.INSTANCE.ShowWindow(var1, 9);
      User32.INSTANCE.SetForegroundWindow(var1);
      GLFW.glfwFocusWindow(var0.method_22683().method_4490());
   }

   private static void gjs(int var0, int var1) {
      INPUT var2 = new INPUT();
      var2.type = new DWORD(1L);
      var2.input.setType(a.d("\udb25ꊖ", -723584777, 1964778427));
      var2.input.ki.wVk = new WORD(var0);
      var2.input.ki.dwFlags = new DWORD(var1);
      User32.INSTANCE.SendInput(new DWORD(1L), (INPUT[])var2.toArray(1), var2.size());
   }

   private static void gjt(int var0) {
      INPUT var1 = new INPUT();
      var1.type = new DWORD(0L);
      var1.input.setType(a.b("\uf013覦", -1770983300));
      var1.input.mi.dx = new LONG(var0);
      var1.input.mi.dy = new LONG(0L);
      var1.input.mi.dwFlags = new DWORD(1L);
      var1.input.mi.time = new DWORD(0L);
      var1.input.mi.dwExtraInfo = new ULONG_PTR(0L);
      User32.INSTANCE.SendInput(new DWORD(1L), (INPUT[])var1.toArray(1), var1.size());
   }

   private static void gju(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }
}
