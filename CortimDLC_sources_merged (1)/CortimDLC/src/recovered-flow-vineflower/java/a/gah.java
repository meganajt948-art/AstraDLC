package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.ScreenshotRecorder;

public final class gah {
   private static int gai;
   private static int gaj;
   private static jte gak;

   private gah() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.b("짧끜㪌ꓥ⽷\ua9daᏔ騳ѥ軞ट\uf37f綾\ue408", -984495729))
         && a.d("줬낞㩍ꐸ", -1825222353, 629708907).equals(System.getenv(a.c(-1880875410, "Ḽ枇\ued57猾\uf88c繐쐏䷨펾夅\udec4⒤ꩥ㏓릋㽶蔩૾遆ᘜ")))) {
         ClientTickEvents.END_CLIENT_TICK.register(gah::gan);
      }
   }

   private static void gan(MinecraftClient var0) {
      gaj++;

      try {
         if (gak == null) {
            if (var0.method_18506() == null && var0.field_1755 instanceof AccessibilityOnboardingScreen) {
               var0.field_1690.field_41785 = false;
               var0.method_1507(new TitleScreen());
            }

            if (var0.method_18506() == null && var0.field_1755 instanceof jte var1 && gaj > 60) {
               gak = var1;
               gaj = 0;
            }

            return;
         }

         if (gaj % 40 != 0) {
            return;
         }

         switch (gai++) {
            case 0:
               gao(a.d("\ue05c駴ጭ赔ڍ耫㩅뎋ⷁꝻ", 2099296420, -1495705470), true);
               gao(a.c(961953710, "㿑䙰첲勞\ud90a徻\ue5d0气\uf258磼ＭՍ"), 10000.0F);
               break;
            case 1:
               gap(var0, a.d("牏\u0bfd脮Ὓ铊ቦ꠨ↄ뿂㕹늢䣝옝", -515919221, 589349029));
               break;
            case 2:
               gao(a.c(-723980407, "\ueff3陛ᲂ苻ढ辄㗪밤≮꣔"), false);
               kbm.POSITION.set(a.c(-577870408, "旰ᱨ隸ࣛ"));
               kbm.BUTTONS.set(a.d("犐ଛ臉ᾠ鑲ዄꢜ", 327430107, 900553987));
               kbm.TITLE.set(false);
               kbm.BLUR.set(0.0);
               break;
            case 3:
               gap(var0, a.c(746787578, "ኍ欿\ue1ec羙\uf408犥죪䅚\udf0c喾퉿⡗ꛂ㽩딻㏒覘َ鳶\u1aef鍛\ue90b枣ﱯ稍\uf0c4䥾"));
               break;
            case 4:
               kbm.POSITION.set(a.d("攭Ყ険ࠄ菏", 1511596505, 1296647331));
               kbm.BUTTONS.set(a.b("⭆勒\ud812䙺", -1879889146));
               kbm.TITLE.set(true);
               kbm.ROUND.set(0.3);
               kbm.DIM.set(0.3);
               break;
            case 5:
               gap(var0, a.b("튑ꬣ⇰뾅㐔늺ࣶ腘Ἔ閣ቿ\ue812暜､甲\uf3d0䦆", 774951660));
               break;
            case 6:
               kbm.POSITION.set(a.c(-1438094032, "浵ᓢ鸺Q讗റ"));
               kbm.BUTTONS.set(a.b("ᐺ涮\ue773礍\uf2c6", -1657990029));
               kbm.ROUND.set(1.0);
               kbm.DIM.set(0.0);
               kbm.BLUR.set(0.5);
               gao(a.d("㒋䴣쟺妃퉚哼\uee92杜烙玬", 692601086, 1144681487), true);
               break;
            case 7:
               gap(var0, a.d("䢥ㄗ믄▱긠⢏鋂᭲蔨ྗ衋爦ﲨ敄\uef0e槵펲屭웉", 532829353, -810935181));
               break;
            default:
               kbm.reset();
               gao(a.b("崲⒚깃〺믣㵅蜫\u0ee5邯ᨕ", 1847549256), false);
               System.out.println(a.b("≆寴턧佒쓎䈫\uf869熎\uefd6攳\ue290ᣰ阵྄", 1414668836));
               var0.method_1592();
               gaj = Integer.MIN_VALUE;
         }
      } catch (Throwable var3) {
         System.out.println(a.d("陗\uefe5收ףּ烟\uf63a䱸얟寇턢嚗곡∾뮊ㆯ띄", 1581932315, 1981729072) + var3);
         var3.printStackTrace();
         var0.method_1592();
         gaj = Integer.MIN_VALUE;
      }
   }

   private static void gao(String var0, Object var1) throws Exception {
      Field var2 = jte.class.getDeclaredField(var0);
      var2.setAccessible(true);
      var2.set(gak, var1);
   }

   private static void gap(MinecraftClient var0, String var1) {
      System.out.println(a.d("귪푘庋샾䭢춇矅︢恺\uea9f", -1702102730, -1614588742) + var1);
      ScreenshotRecorder.method_22690(
         var0.field_1697, a.b("\ueebd霆ᷖ莿࠭躃", 1098837725) + var1 + a.d("멉쎦䥫휓", 1308586951, -234239580), var0.method_1522(), 1, var0x -> {}
      );
   }
}
