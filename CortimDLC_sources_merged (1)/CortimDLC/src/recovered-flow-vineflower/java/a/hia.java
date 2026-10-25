package a;

import flow.dev.a;
import flow.util.LoaderInfo;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class hia {
   static final String[] IDS = new String[]{a.b("텓꣧∦", -1478962912), a.d("퀺ꦉ⍏", 656665642, 156974192), a.b("ﺔ蜧\u0df5鎁ᡘ黵", -1792213249)};
   static final String OWN = a.b("Ꞣ\ude0b品", 1653516238);
   static final String[] SLOTS = new String[]{
      a.c(2033973355, "\uf818膬୭"), a.b("戳ᮀ酆", 1019241043), a.d("ͬ竟\uf00d湹\ue5a0挍", 1311606500, -592214557), a.b("䕚㳳똹", 1249723702)
   };
   private static final int hib = 8;
   private static final Map<String, BufferedImage> hic = new HashMap<>();
   private static final Set<String> hid = new HashSet<>();
   private static final Map<String, uok> hie = new LinkedHashMap<>();
   private static final Map<uok, Long> hif = new LinkedHashMap<>();
   private static String hig = IDS[0];
   private static String hih = "";
   private static int hii;
   private static boolean hij;

   private hia() {
   }

   static String selected() {
      return hig;
   }

   static void select(String var0) {
      for (String var4 : SLOTS) {
         if (var4.equals(var0)) {
            hig = var4;
         }
      }
   }

   static String seenOwn() {
      return hih;
   }

   static void seenOwn(String var0) {
      hih = var0 == null ? "" : var0;
      hij = true;
   }

   static boolean ownReady() {
      return evi.image() != null;
   }

   static String label(String var0) {
      return switch (var0) {
         case a.c(-1378603983, "ⱂ嗶\udf37") -> wap.s(a.b("⒣崷ퟶ", -625924880), a.d("︗螄ൖ鍙\u18f7鹄", 483765601, 1950504812));
         case a.d("개햯彩", -1205532875, -1891783863) -> wap.s(a.b("刅\u2b96ꅘ㼩듯㉕", -1836428728), a.c(-1133846021, "\ue5e4鱱ᛞ裕̀"));
         case a.c(-2057893101, "\u0b7f狖\uf81c") -> ownReady()
            ? wap.s(a.b("Ԋ粍\uf644栲\ue3e4", -679148202), a.d("ᣧ慅\ueb9a疚", -617669034, 303039124))
            : wap.s(
               a.b("粊ԍ迄ᆲ騷\u1cc9Ꚃ⽪녡㯊뱭䘏좿兌\udb12巸\ue7e3䦀\uf281璠ﵵ蜹ঃ鉝ᐧ黿✉裪㎯떟㸛생䪇퍣唣", 1560902896),
               a.d("䚮㼌뗓⯓ꑱ⋚飽ᄟ輪Ƈ虛籖\uf6e3仠\ue501柏\udddf剰좹五읠뵆㞙跺⨷ꓖᵇ錔\u0991農ѱ\ufada炟", 1443369616, -1814015938)
            );
         default -> wap.s(a.c(-1891817786, "⚍弞헌䮸쁡䛌"), a.b("鯖\ue248梟\uf6ec絀ﯲ䇓젥噰", -547250239));
      };
   }

   private static void him() {
      evi.boot();
      int var0 = evi.version();
      if (var0 != hii) {
         hii = var0;
         hic.remove(a.b("弮⚇걍", 454909762));
         hid.remove(a.c(151168700, "ꛐ\udf79喳"));
         Iterator var1 = hie.entrySet().iterator();

         while (var1.hasNext()) {
            Entry var2 = (Entry)var1.next();
            if (((String)var2.getKey()).startsWith(a.b("깈ퟡ崫썴", 310095395))) {
               hif.put((uok)var2.getValue(), unf.frame());
               var1.remove();
            }
         }

         String var3 = evi.etag();
         if (hij && ownReady() && !var3.equals(hih)) {
            hih = var3;
            hig = a.c(-350656687, "朽Ẕ鑞");
            hyz.saveLater();
         }
      }

      if (hij && a.c(748646734, "焢ࢋ艁").equals(hig) && evi.known() && !ownReady()) {
         hig = IDS[0];
         hyz.saveLater();
      }
   }

   static String windowsUser() {
      String var0 = System.getProperty(a.b("챑뗦㼣ꅅ⫎갿ᙣ龞ǉ", -2081960915));
      return var0 != null && !var0.isBlank() ? var0 : a.d("㈯䮴셤弍퓸副\ue82a懌", -990311757, 450050258);
   }

   public static String account() {
      String var0 = LoaderInfo.login();
      return var0.isEmpty() ? windowsUser() : var0;
   }

   public static boolean drawSelected(DrawContext var0, float var1, float var2, float var3) {
      return draw(var0, hig, var1, var2, var3);
   }

   static boolean draw(DrawContext var0, String var1, float var2, float var3, float var4) {
      return draw(var0, var1, var2, var3, var4, var4);
   }

   static boolean draw(DrawContext var0, String var1, float var2, float var3, float var4, float var5) {
      him();
      uok var6 = hin(var1, var5);
      if (var6 == null) {
         return false;
      } else {
         uut.image(var0, var6.view, var2, var3, var4, var4, var4 * 0.5F, -1);
         return true;
      }
   }

   private static uok hin(String var0, float var1) {
      if (hid.contains(var0)) {
         return null;
      } else {
         MinecraftClient var2 = MinecraftClient.method_1551();
         float var3 = var2.method_22683() != null ? Math.max(1, var2.method_22683().method_4495()) : 2.0F;
         int var4 = Math.max(8, Math.min(256, Math.round(var1 * var3 * vdn.renderScale())));
         String var5 = var0 + a.d("徨", 462345909, 848529756) + var4;
         uok var6 = hie.get(var5);
         if (var6 != null) {
            return var6;
         } else {
            try {
               BufferedImage var7 = hic.get(var0);
               if (var7 == null && a.b("\uf04f触̬", 1233317923).equals(var0)) {
                  var7 = evi.image();
                  if (var7 == null) {
                     return null;
                  }

                  hic.put(var0, var7);
               }

               if (var7 == null) {
                  try (InputStream var8 = ezj.open(a.b("냪줒䏋\uddb9噶킟檂\ue364紬\uf788灎訬Ӻ鴗", -1090211637) + var0 + a.b("峝┲꿿ㆇ", -1934861065))) {
                     if (var8 == null) {
                        throw new IllegalStateException(
                           a.b("\uf889脼௵閄ṉ飿⊥ꬓ㕃뾻㡢숐䳟픶弫\ud9cd掕\uec51盷\uf0b5祃͎", 112457970) + var0 + a.d("銺\ueb55憘￠", 542382319, 2103544447)
                        );
                     }

                     var7 = ImageIO.read(var8);
                  }

                  hic.put(var0, var7);
               }

               var6 = uok.upload(a.c(-1649601498, "ᑀ淦\ue722祆\uf284琦츧") + var5, hio(var7, var4), false);
            } catch (Throwable var13) {
               hid.add(var0);
               System.out.println(a.d("嚕⼳ꗷ㮓끑㛳賲", -1512563420, 1249725399) + var0 + a.c(-1662569589, "㎥䩁삉廷픷厑\ue9ca怾\ufe6c瓞\uf303ॻ蟳Ṙ") + var13);
               return null;
            }

            hie.put(var5, var6);

            while (hie.size() > 8) {
               Iterator var15 = hie.entrySet().iterator();
               uok var17 = (uok)((Entry)var15.next()).getValue();
               var15.remove();
               hif.put(var17, unf.frame());
            }

            long var16 = unf.frame();
            hif.entrySet().removeIf(var2x -> {
               if (var16 - var2x.getValue() > 3L) {
                  var2x.getKey().close();
                  return true;
               } else {
                  return false;
               }
            });
            return var6;
         }
      }
   }

   private static BufferedImage hio(BufferedImage var0, int var1) {
      int var2 = Math.min(var0.getWidth(), var0.getHeight());
      BufferedImage var3 = new BufferedImage(var2, var2, 1);
      Graphics2D var4 = var3.createGraphics();
      var4.drawImage(var0, -(var0.getWidth() - var2) / 2, -(var0.getHeight() - var2) / 2, null);
      var4.dispose();

      while (var3.getWidth() / 2 >= var1) {
         int var5 = var3.getWidth() / 2;
         BufferedImage var6 = new BufferedImage(var5, var5, 1);
         Graphics2D var7 = var6.createGraphics();
         var7.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         var7.drawImage(var3, 0, 0, var5, var5, null);
         var7.dispose();
         var3 = var6;
      }

      if (var3.getWidth() == var1) {
         return var3;
      } else {
         BufferedImage var8 = new BufferedImage(var1, var1, 1);
         Graphics2D var9 = var8.createGraphics();
         Image var10 = var3.getScaledInstance(var1, var1, 16);
         var9.drawImage(var10, 0, 0, null);
         var9.dispose();
         return var8;
      }
   }
}
