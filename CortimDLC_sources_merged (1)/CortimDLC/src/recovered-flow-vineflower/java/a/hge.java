package a;

import flow.Flow;
import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

final class hge {
   private static final int hgf = 20;
   private static final int hgg = 5;
   private static int hgh;
   private static boolean hgi;

   private hge() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      ClientPlayerEntity var2 = var0.field_1724;
      if (var1 == 1) {
         hgp(var0, a.d("캩뜞㷁ꎸ⡧껔ᒌ鵼ͦ覄๑\uf427竴\ue35a椖\ueff0喲", -481329984, -1142836705));
         hgp(var0, a.d("\udd3c꒐⹇뀾㮬뵎܋軫რ驇ᶒ\ue7e3椴", -912220701, 732512422));
         hgp(var0, a.b("锣\uec91時\uf830珡\uf547佀웶墧툉嗉꿽⅊룈㋈둴฿臩᭑鴆ᓠ溢\ue016篕\ufde4睽컙䂞\uda73尸힌⥈ꌈ㫴벡㙕覓ϡ蔰Ბ雟\ue82f扬\ue589罘\uf12e䣭", -70085271));
      }

      if (var1 == 20) {
         hgl(var0, 20);
         Flow.getInstance().getModuleManager().getByName(a.c(1020377856, "뭉싌䠞홴嶁\udb1c慍\ue8ba")).setEnabled(true);
      }

      if (var1 == 30) {
         hgm(var0);
      }

      if (var1 > 30 && var1 < 110) {
         hgn(var2, a.d("箋Ƚ裶ᚔ鵈ᯣꆫ⡇똓", 1654984789, -86479938), var1);
      }

      if (var1 == 110) {
         PlayerInventory var3 = var2.method_31548();
         hgo(hgi, a.b("↴堂틉䲫읷䇜ﮔ牸\uec2c曞\ue117ᬲ闹\u0c45虓ï몬㕿꿊⧞ꁧ\uda3d咝콟䤷쎴穄\uf417滬\ue8b5捃鷛ន蹸࠰苎㵍뜠ㇾꠊ∝峥횹儂", -1615584783));
         hgo(
            var3.method_5438(20).method_31574(Items.field_49814),
            a.b("\uf6cc轺ֱ鯓ဏ隤ⳬꔀ㭔놦㙯챊䊁\udb3d儫힗淔\ue207碲ﺦ眕\u0d49菷ᠬ鸚ᒘ굿⍩릖㾈둹䪫샦够\udf07嗢\uea2e怐\ue6d1罢\uf52d诔Ǜ虶Წ鋊⬎ꇠ➵", -625936748)
               + var3.method_5438(20)
               + a.d("\udc75", 504865572, 563642233)
         );
         hgo(
            var3.method_5438(0).method_31574(Items.field_49098),
            a.d("ᩈ揾\ue935睗ﲋ稠쁨䦄ퟐ崢\udaeb\u20c9긁㞳뷻㭞脁ເ鐺ቱ鮛\ue183潣\uf4e6狍\uf800䆾쾪唊퍅壱ꘪⰡ떓㏋륳ڷ賓ਂ鏬ᦩ", 2069072120, 228102896) + var3.method_5438(0)
         );
         hgi = false;
         hgl(var0, 5);
      }

      if (var1 == 125) {
         hgm(var0);
      }

      if (var1 > 125 && var1 < 205) {
         hgn(var2, a.d("\ue7c3鹵ᒽ諚Ď螬", 863981644, 1016510433), var1);
      }

      if (var1 == 205) {
         PlayerInventory var4 = var2.method_31548();
         hgo(hgi, a.c(1226082837, "詔\uf3e2礪\ue74d沙\uea3b倠\ud9cb䟀쵭䪳낇㸝Ꞡⷱꬆᄌ麓Ы艩\u0b8d燋Ｊ撸\ue2c5栘톣德씉䍟죶㘼밼▙ꏖ⥪雸᳁騛Υ觰"));
         hgo(
            var4.method_67532() == 0,
            a.d("缀ڶ豾ሙ駍Ὧꕴⲟ는㠹뿧䗓쭗勹\ud8a9幃\ue458母\uf173眯ﻒ蓊ਪ醯ន鵎⓿ꪦ〔똇㶷썤䤣킙嚞\udc34掬\ue9cd演\uf6bf", -1707324956, 1523201700) + var4.method_67532()
         );
         hgo(var4.method_5438(5).method_31574(Items.field_49814), a.c(-2145105708, "䢪ㄜ믔△깧⣅鋞ᬵ蔾ྒྷ衍特ﳣ敞\uef0f槸폲屮웟䂗쥳댣"));
         Flow.getInstance().getModuleManager().getByName(a.d("ꏴ\uda71傣컉䔼쎡称\uf007", -593157387, -482311864)).setEnabled(false);
         System.out
            .println(
               a.c(-1110937726, "濺ᙕ鲁˺襩ྕ뗊㰹ꉠ⢔꼓啳\udbb2䈄젃")
                  + (
                     hgh == 0
                        ? a.d("䨼㎜륝✬", -348607848, 1845813488)
                        : a.d("腍\uf8fb爠\uec54柯\ue156", -2047406575, 1185124124) + hgh + a.d("\ueb0c", 1692605108, 1544810896)
                  )
            );
         return true;
      } else {
         return false;
      }
   }

   private static void hgl(MinecraftClient var0, int var1) {
      var0.method_1576().execute(() -> {
         ServerPlayerEntity var2 = var0.method_1576().method_3760().method_14566(var0.field_1724.method_5477().getString());
         var2.method_31548().method_5448();
         var2.method_31548().method_5447(0, new ItemStack(Items.field_49098, 16));
         var2.method_31548().method_5447(1, new ItemStack(Items.field_8802));
         var2.method_31548().method_5447(var1, new ItemStack(Items.field_49814));
      });
      var0.field_1724.method_31548().method_61496(0);
   }

   private static void hgm(MinecraftClient var0) {
      var0.field_1724.method_36457(89.0F);
      var0.field_1724.field_6004 = 89.0F;
      var0.field_1761.method_2919(var0.field_1724, Hand.field_5808);
      var0.field_1724.method_6104(Hand.field_5808);
      System.out
         .println(
            a.b("쬦늉㡝꘦ⶵꭉᄖ飥ڼ豈\u0bcf\uf1af置\ue6d8泅\uea2e倵\udff8䕑쌝䫲ズ빋▖ꎪ⥷郄ẖ葩ȳ覘睐ﵑ", 900713328)
               + var0.field_1724.method_7357().method_7904(new ItemStack(Items.field_49098))
         );
   }

   private static void hgn(ClientPlayerEntity var0, String var1, int var2) {
      boolean var3 = var0.method_6047().method_31574(Items.field_49814);
      hgi = hgi | (var3 && !var0.method_24828());
      if (var2 % 5 == 0) {
         System.out
            .println(
               a.c(-575122148, "啤ⳋꘟ㡤돷㔋轔ڧ飾ሊ閍濭\ue12c碚\uf29d")
                  + var1
                  + a.b("ઔ獱匿", 465308343)
                  + var2
                  + a.b("曉Ἷ闹க聘۲벫㔃", 1157261025)
                  + var0.method_24828()
                  + a.b("搑᷹靮", -2058394574)
                  + String.format(Locale.ROOT, a.b("鯱\ue24b梄\uf6a1", 328506320), var0.method_23318())
                  + a.d("\udd06꓿⸡끙㮆뵮", 329127786, -1195718070)
                  + var0.method_31548().method_67532()
                  + a.c(-1910086354, "攈ᳱ阫ࡕ莈ՠ")
                  + var0.method_6047().method_7909()
            );
      }
   }

   private static void hgo(boolean var0, String var1) {
      if (!var0) {
         hgh++;
         System.out.println(a.b("\udd99ꐶ⻢낙㬊뷶ީ蹚ဃ髷ᵰ\ue710槑\uf067穠ﳒ䚖쥊叿햦尚☍ꢹ㍠딚㿂虰ࡿ銒", 1924652531) + var1);
      }
   }

   private static void hgp(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }
}
