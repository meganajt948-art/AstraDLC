package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;

final class fwd {
   private static String fwe;
   private static String fwf;

   private fwd() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      switch (var1) {
         case 1:
            var0.method_1562().method_45730(a.c(-1837125820, "꼽횑屆숿䦭콏甊ﳪ拡\ue846澓闢ᬵ"));
            fwe = iov.PRESET.get();
            fwf = isv.selected();
            fwi(a.d("뻅읞䶎폧塧\udeb4擉\ued35獨六", 1537582006, -447734465), a.d("\uf155裻ȥ鱕ឈ酬⭣ꊘ㳄뙭\u31e4쯜䔎\udcac囦", -605365332, 390146688));
            fwj(var0, a.c(177141704, "\uf78d踐Ӂ骿ᅫ韏"));
            break;
         case 70:
            fwk(var0, a.d("䭦㋝렍♤궨⬚酉ᢼ蚥\u0c5b讆燺Ｏ暖\uec83樼큿徬씐䍂쪠", -1225834257, 78121978));
            break;
         case 72:
            fwj(var0, a.b("宆∀꣘㚣뵵㯓", -122987566));
            break;
         case 110:
            fwk(var0, a.b("\ue641鿺ᔪ譃\u008f蘽㱮떛⮂ꅼ⚡\udcdd刈쮱䆤윊絒\uf288栱\uee61极", -950344142));
            break;
         case 112:
            fwj(var0, a.d("㈋䮆션弡퓾", -204718692, 873664454));
            break;
         case 150:
            fwk(var0, a.b("\ue566鳝ᘍ衤Ψ蔚㽉뚼⢥ꉛ▆\udffa儯좖䊃쐫繸\uf1a4欟\ued46", 433251604));
            break;
         case 152:
            fwi(a.d("훬꽷▧믎ぎ뚈\u0ce4蔔᭖釶", 124097605, 1559118565), a.b("\uecca镤Ὰ臊ਗ賳㛼뼇⅛꯲ⱻ홋墙섦䭺춗", -1980044116));
            fwj(var0, a.b("뤟삂䩓퐭忹\ud95d", 1097578842));
            break;
         case 210:
            fwk(var0, a.d("ᙏ濴\ue524筍\uf081瘳챠䖕\udb8c內횫ⳛꈑ㮱놪㜕赖ʅ頹ṫ鞉", -1073400419, 1628971937));
            break;
         case 212:
            fwi(a.b("\uf575賮ؾ顗Ꮧ锄⽹ꚅ㣘뉡", -142019271), a.d("\udca7ꔉ\u2fd7놧㩺벞ڑ轪ᄶ鮟ᰖ\ue62e棼\uf15e笔", -1845516047, -576752593));
            var0.method_1507(null);
            break;
         case 250:
            fwk(var0, a.d("ⶪ向\udec1䂨쭤䷖\uf785繰\ue069檝\ued53ᜳ馭S討ೲ뚿㥦", 1822696234, -1019736332));
            break;
         case 252:
            fwi(a.d("宖∍\ua8dd㚴봴㯲膞\u086e阬\u1c8c", 815031173, 493697119), a.d("忒♼겢㋒뤏㿫藤ట鉃ᣪ齣敓\ueb81爾\uf862纏", -1173383069, -1547778089));
            break;
         case 290:
            fwk(var0, a.d("돉쩲䂢\udecb唇펵槦\ue013縊\uf4fe猰襐ߎ鸥ᑩ銙⣋꜋", -1085501129, -178511222));
            break;
         case 292:
            iov.PRESET.set(fwe);
            isv.select(fwf);
      }

      return var1 >= 300;
   }

   private static void fwi(String var0, String var1) {
      iov.PRESET.set(var0);
      iov.ACCENT.set(a.c(218628386, "ŧ磢\uf230汚"));
      isv.select(var1);
   }

   private static void fwj(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.c(-1569552764, "蛶ｒ疂\uebda怣\ue68e"));
      var2.setAccessible(true);
      var2.set(null, var1);

      for (String var6 : new String[]{a.c(-257517948, "雴\uef5b斏ﯴ瀨\uf681䳽"), a.b("蛔ｻ疯\uebd4怈\ue6a1峜", -1750694236)}) {
         Field var7 = hlc.class.getDeclaredField(var6);
         var7.setAccessible(true);
         var7.setFloat(null, Float.NaN);
      }

      Field var8 = hlc.class.getDeclaredField(a.b("怟ᦾ鍼ഐ蛄u먹", -1194762165));
      var8.setAccessible(true);
      ((Map)var8.get(null)).clear();
      var0.method_1507(new hlc());
   }

   private static void fwk(MinecraftClient var0, String var1) {
      System.out
         .println(
            a.b("蝌ﻫ琱\uea4a懛\ue73e嵼풛䫃쀦", -369326283) + var1 + a.b("\u1adc挍\ue9be", 944577279) + var0.method_47599() + a.d("뚶콁䖄\udbf6", 507106358, 565535396)
         );
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.d("ᘿ澄\ue554笽\uf0af瘁", 817397468, -991270781) + var1 + a.d("蜿ﻐ琝\uea65", 1964396508, 1584449737),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
