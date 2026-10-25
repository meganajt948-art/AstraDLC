package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

final class gjv {
   private static final int gjw = 2;
   private static final int gjx = 3;
   private static final int gjy = 6;
   private static final String[] gjz = new String[]{
      a.c(1520553703, "캁뜹㷪ꏐ⡘껲ᒯ鵑̒"),
      a.d("䛎㽶떥⮟ꀉ⚱鳡ᔂ", 1329892924, 451135637),
      a.c(-1599955696, "鵱\ue4c1湑\uf07f箳ﴌ䝐캽傾\uda46嶃\ua7e4⤫냊"),
      a.d("螃︳璣\uea93慍\ue7ff嶾퐓䨐삺䝱봖㏒ꩵ\u206b", -581809798, 900910745),
      a.d("\uf27f诏ş齯ᒱ鈃⡂ꇪ㿾땈㊉죿", 1040958980, 928723992)
   };
   private static Field gka;
   private static Field gkb;
   private static double gkc = 1000.0;
   private static float gkd;

   private gjv() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.d("\u2fda噉\udc80䋷줶侣\uf5c2簳\ue276棝\uef09", -2116994137, -1714678725));
      if (var1 == 1) {
         var0.field_1690.field_1837 = false;
         gka = vxr.find(
            Mouse.class, a.c(19577844, "뮍숷䣵훞嵊\udbff憫\ue851瘈ﲨ筨脞\u0fdb阰ᰮ髐ₒ꽑㗢뎟㨄䁗컧"), a.c(551400012, "눠쮞䅁\udf39哦퉬桑\ue1a6翶\uf54c"), a.c(-1513700863, "쉚")
         );
         gkb = vxr.find(
            MinecraftClient.class,
            a.d("泥聙છ钰ἤ馑⏅\uaa3f㑦뻆㤆썰䶵푞幀\ud8be拼\ued3f瞌\uf1f1硪ȹ貋", 645316589, 1590838903),
            a.d("뭷싉䠖홮嶱\udb3b愆\ue8f0皠ﰝ", -322625474, 1886100261),
            a.d("䱏", -496466650, -995636942)
         );
         gki(var0, a.d("\u0530粇\uf658校\ue3fe敍\udf15囥죿䈝었㾾녭⣃ꊏ⑩鸫", -1529193324, 255744466));
         gki(var0, a.c(-331242999, "ꉰ\udbdc儋콲䓠숂硇\uf1a7澬\ue553抁飰ᘦ"));
         gki(var0, a.b("Ǡ硒\uf281泳\ue722憄\udb83刵챤䛊섊㬾떉Ⰻꘋ₨髰ᔷ辞\u09d5耥視瓝\uef01楸\ue3ec娖푀亿죡䍕붃㟑긱⠧ꊄᵔ霥ᇣ蠆ɟ粩\uf6ea", 2047279534));
         gki(var0, a.b("\u0ff2癌ﲚ拫\ue970澟햟屵숼䣓콓㔾미∗ꠗ\u2efd钤ᬫ臐ޗ踾\uf43c窓\ue153杲\uedeb呎\uda52䂡웷䵏뎘㧆ꀤ♰곓ፊ饲᾿蘌\u0c53犹\uf8f6罰\ue58b毽툵墅\udec1", 523177893));
         gki(var0, a.c(15113950, "麝\ue723淵\uf384砟ﻰ䓰촚卓\ud9bc帱ꐞ⪚댰㥵뿚ם訚ჷ雬Ἇ攀\uebfb瀼\uf60e糛앯䬵퇄垄\udc24⋲ꢯㄐ뜘㶡艭"));
         gki(
            var0,
            a.d(
               "䟟㹨뒣⫒ꄇ➷鶪ᐖ詍û蜣絔\uf392樰\ue064暇\udc86北즱俢옚뱀㋿ꥫ⽊ꗔᱸ鈲࣐軟Բ﮽熿\ue85d湕\ue4d1嬧텸垣칡䐵㪗낊㝄궩⏝騇Ⴝ雨൷茏禍\uf074癙\uec9f拙\ud967徬헅䰓습룯㼑땆⮾ꈸ\u187f麊ᓁ譫Ư蟟繞\uf4e4櫤\ue10a",
               1729955821,
               679493645
            )
         );
         System.out.println(a.d("⊂嬱퇸侏쑎䊺\uf8ba煝\uef09斥\ue225", -61365662, -1919778682) + var0.field_1690.method_42495().method_41753());
         return false;
      } else {
         gkh(var0);
         if (var1 < 40) {
            return false;
         } else {
            byte var3 = 26;
            int var4 = (var1 - 40) / var3;
            int var5 = (var1 - 40) % var3;
            if (var4 >= gjz.length) {
               var2.setEnabled(false);
               return true;
            } else {
               if (var5 == 0) {
                  var2.setEnabled(var4 >= 2);
                  var0.field_1724.method_36456(0.0F);
                  var0.field_1724.method_36457(0.0F);
                  var0.field_1724.field_5982 = 0.0F;
               } else if (var5 == 10) {
                  gkd = var0.field_1724.method_36454();
               } else if (var5 > 10 && var5 <= 16) {
                  int var14 = gjz[var4].contains(a.b("쓄뵮㞳꧍∆", 1861534899)) ? 1 : -1;
                  int var15 = gjz[var4].contains(a.d("\uf85b臭ବ镚", -696234716, 1012708637)) ? 8 : 1;
                  GLFWCursorPosCallback var8 = gkg(var0);
                  long var16 = var0.method_22683().method_4490();

                  for (int var17 = 0; var17 < 3 * var15; var17++) {
                     gkc += var14 * 2;
                     var8.invoke(var16, gkc, 500.0);
                  }
               } else if (var5 == 24) {
                  int var6 = gjz[var4].contains(a.c(1976430957, "\uf10f袹ɸ鰎")) ? 8 : 1;
                  double var7 = 36 * var6;
                  double var9 = (Double)var0.field_1690.method_42495().method_41753() * 0.6 + 0.2;
                  double var11 = var7 * var9 * var9 * var9 * 8.0 * 0.15;
                  float var13 = var0.field_1724.method_36454() - gkd;
                  System.out
                     .printf(
                        a.b("\udbb8ꈋ⣂뚵㵴뮀ǖ衱ᙧ鳌ᭋ\ue13b濫\uf646簞\ufaee䃥켱喉폅婧⁰꺇㕗댪㦰耏จ铨\u12b6餂柖\ued99瑥\uf277磃윟䵳쯵刂\ud819ꛩⲸꭂ㆙뾺ٺ賞ઌ酛ὧ\ue5b3氏\uea43烥ﻷ䔃", -1974084628),
                        gjz[var4],
                        var13,
                        var11,
                        Math.abs(var13) / var11
                     );
               }

               return false;
            }
         }
      }
   }

   private static GLFWCursorPosCallback gkg(MinecraftClient var0) {
      long var1 = var0.method_22683().method_4490();
      GLFWCursorPosCallback var3 = GLFW.glfwSetCursorPosCallback(var1, null);
      GLFW.glfwSetCursorPosCallback(var1, var3);
      return var3;
   }

   private static void gkh(MinecraftClient var0) throws Exception {
      if (gka != null && var0.field_1755 == null) {
         gka.setBoolean(var0.field_1729, true);
      }

      if (gkb != null) {
         gkb.setBoolean(var0, true);
      }
   }

   private static void gki(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }
}
