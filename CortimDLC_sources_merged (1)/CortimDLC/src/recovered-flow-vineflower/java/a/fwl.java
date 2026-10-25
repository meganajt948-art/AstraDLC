package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.ScreenshotRecorder;

public final class fwl {
   private static int fwm;
   private static int fwn;
   private static jte fwo;

   private fwl() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.c(997354048, "樨᎓饃ܪ貸ਕ뀛㧼Ɦⴑ\uaad0傰\ude71䟇"))
         && a.c(1768596395, "ꏅ\uda7e傮컇䔊쎳秫\uf001").equals(System.getenv(a.c(-1010832933, "\ue989進\u1ae2蒋༹觥㎺멝␋꺰⥱팑巐쑦举죃犜﵋柳\ue1a9")))) {
         ClientTickEvents.END_CLIENT_TICK.register(fwl::fwr);
      }
   }

   private static void fwr(MinecraftClient var0) {
      fwn++;

      try {
         if (fwo == null) {
            if (var0.getOverlay() == null && var0.currentScreen instanceof AccessibilityOnboardingScreen) {
               var0.options.onboardAccessibility = false;
               var0.setScreen(new TitleScreen());
            }

            if (var0.getOverlay() == null && var0.currentScreen instanceof jte var1 && fwn > 60) {
               fwo = var1;
               fwn = 0;
            }

            return;
         }

         if (fwn % 50 != 0) {
            return;
         }

         switch (fwm++) {
            case 0:
               fws(a.d("탭ꥃ⎝뷭㘰냔\u0adb茠ᵼ韕ၜ\uea64撶ﴔ睞", 1683244346, -1894017618));
               kbm.POSITION.set(a.d("\ue22a鮲ᅢ輁", -1602350262, 1137307944));
               kbm.BUTTONS.set(a.c(1231351652, "\uef26隼ᱢ舁\u09d6"));
               break;
            case 1:
               fwu(var0, a.b("攭Ზ陆\u082f菢՛뼃㛩꣮∐ꗍ徱텤䣝싈䑸︾燬\ueb4d", -1847827112));
               break;
            case 2:
               kbm.POSITION.set(a.b("㵮䓹측偊\udb8c崪", 746929451));
               break;
            case 3:
               fwu(var0, a.d("䌝㪦끶⸟ꗒ⍫餳კ軞Р菽禁\uf754滭\ue4f8扇\ud80e埔쵽䬽식", -111760188, 1694887850));
               break;
            case 4:
               kbm.POSITION.set(a.c(1998370238, "뗩챣䚾\ud8c0匋"));
               break;
            case 5:
               fwu(var0, a.b("詭\uf3d6礆\ue76f沢\uea1b偃\ud9a9䞮쵐䪍냱㸤ꞝⶈꬦᅲ麭Б艜", -2134210017));
               break;
            case 6:
               fws(a.b("\uef0b隥ᱻ舋\u09d6輲㔽볆⊚꠳⾺햊存싧䢻칖", 2029317997));
               kbm.POSITION.set(a.d("\uf54b賓\u0603顠", 2099475610, 956400025));
               break;
            case 7:
               fwu(var0, a.d("覾\uf005竕\ue4bc潱\ue9c8厐\uda7a䑽캖䥚댪㷠ꑀ⹛꣫ክ鵿ߞ", 1993077602, -1007584599));
               break;
            case 8:
               kbm.POSITION.set(a.b("䊪㬽뇥⾎ꑈ⋮", 1546994415));
               fwt(a.c(-96410484, "\ue4f6鵞ជ觾ȧ蒁㻯뜡⥫ꏑ"), true);
               break;
            case 9:
               fwu(var0, a.b("ꃡ\ud95a厊췣䘮삗竏\uf325洢\ue7c9怅驵ᒿ负܄膻㯲됨⺁ꣁ℡", 659267730));
               break;
            case 10:
               fws(a.c(447829818, "坃⻭ꐳ㩃놞㝺赵Ҏ髒ၻ韲淊\ue318窺\uf0f0"));
               kbm.POSITION.set(a.c(-760200350, "䌪㪲끢⸁"));
               fwt(a.d("蘍ﾥ畼\ueb05惜\ue67a尔헚䮐섪", -538040193, -2090357240), true);
               break;
            case 11:
               fwu(var0, a.d("㪬䌗짇垮\udc63嫚\ue082楨\uf76f綃爫2軭ᝒ鴖", 2097088531, -997444906));
               break;
            case 12:
               fwt(a.c(1210179599, "\ue075駝ጄ赽ڤ耂㩬뎢ⷨꝒ"), false);
               var0.reloadResources();
               fwn = 30;
               break;
            case 13:
               fwu(var0, a.d("\uefbd阆᳖芿ॲ迋㖓뱹≾ꢐ⽔픬寸쉇䠑", -115584705, 2013970155));
               break;
            default:
               if (var0.getOverlay() != null) {
                  fwm--;
                  return;
               }

               kbm.reset();
               System.out.println(a.c(1859703475, "틆ꭽ↭뿄㑄늸ࣣ脙Ὕ閹ሾ\ue85e暟Ｉ甮\uf3af䧱옲岁"));
               var0.scheduleStop();
               fwn = Integer.MIN_VALUE;
         }
      } catch (Throwable var3) {
         System.out.println(a.c(1722832086, "咥ⴞ\ua7ce㦧눧㓛躀ݺ餾Ꮪ鑝渽\ue0fc祊\uf34d痚쾒䁋\udafd峚픷") + var3);
         var3.printStackTrace();
         var0.scheduleStop();
         fwn = Integer.MIN_VALUE;
      }
   }

   private static void fws(String var0) throws Exception {
      Method var1 = jte.class.getDeclaredMethod(a.d("열뱜㚅꣼", -13756320, -1431118368), kbs.class);
      var1.setAccessible(true);
      var1.invoke(fwo, kbs.byKey(var0));
   }

   private static void fwt(String var0, Object var1) throws Exception {
      Field var2 = jte.class.getDeclaredField(var0);
      var2.setAccessible(true);
      var2.set(fwo, var1);
   }

   private static void fwu(MinecraftClient var0, String var1) {
      System.out.println(a.b("\uf25a诡ı齘ᓘ鈤⡿ꆅ㿁딥㊢죂䘃\udfb5喲", 195752499) + var1);
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory, a.d("䂚㤡돱\u2d98ꘊ₤", 1867066142, 771714020) + var1 + a.c(757021108, "㦞䁱쪼哄"), var0.getFramebuffer(), 1, var0x -> {}
      );
   }
}
