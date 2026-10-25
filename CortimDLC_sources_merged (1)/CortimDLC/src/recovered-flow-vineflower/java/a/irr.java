package a;

import flow.dev.a;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.InputUtil.Type;
import org.lwjgl.glfw.GLFW;

public final class irr {
   static final vdn LOGO = veo.bold(12.5F);
   static final vdn TAB = veo.medium(7.5F);
   static final vdn SECTION = veo.semibold(5.5F);
   static final vdn TITLE = veo.semibold(12.0F);
   static final vdn SUBTITLE = veo.regular(6.5F);
   static final vdn CARD_TITLE = veo.semibold(7.5F);
   static final vdn LABEL = veo.regular(7.0F);
   static final vdn VALUE = veo.medium(6.5F);
   static final vdn SMALL = veo.medium(5.5F);
   static final vdn NAME = veo.medium(7.0F);
   static final vdn AVATAR = veo.bold(7.5F);
   static final float ICON = 9.5F;
   static final float ICON_SMALL = 7.0F;
   public static final float SWITCH_W = 17.0F;
   public static final float SWITCH_H = 9.5F;

   private irr() {
   }

   static boolean inside(double var0, double var2, float var4, float var5, float var6, float var7) {
      return var0 >= var4 && var0 < var4 + var6 && var2 >= var5 && var2 < var5 + var7;
   }

   public static void drawSwitch(DrawContext var0, float var1, float var2, float var3, float var4) {
      float var5 = 4.75F;
      float var6 = iov.lightness();
      uut.round(var0, var1, var2, 17.0F, 9.5F, var5, ujt.lerp(iov.track, iov.fieldHover, var4 * 0.6F));
      if (var3 > 0.01F) {
         uut.pushAlpha(var3);
         uut.gradientH(var0, var1, var2, 17.0F, 9.5F, var5, iov.accent(), iov.accent2());
         uut.popAlpha();
      }

      ukf.inset(var0, var1, var2, 17.0F, 9.5F, var5, var6);
      float var7 = var5 - 1.5F;
      float var8 = var1 + var5 + 7.5F * var3;
      float var9 = var2 + var5;
      float var10 = var7 * 0.9F * (1.0F - Math.abs(2.0F * var3 - 1.0F));
      float var11 = var7 * 2.0F + var10;
      uut.shadow(var0, var8 - var11 * 0.5F, var9 - var7 + 0.7F, var11, var7 * 2.0F, var7, 1.4F, 1711276032);
      int var12 = ujt.lerp(iov.knob, -1, var3);
      uut.gradientV(var0, var8 - var11 * 0.5F, var9 - var7, var11, var7 * 2.0F, var7, ujt.lerp(var12, -1, 0.35F), ujt.shade(var12, 0.86F));
   }

   static void primaryButton(DrawContext var0, String var1, vhz var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = iov.r(5.0F);
      float var10 = 1.0F - 0.05F * var8;
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var3 + var5 * 0.5F, var4 + var6 * 0.5F + 0.6F * var8 - 0.4F * var7);
      var0.getMatrices().scale(var10, var10);
      var0.getMatrices().translate(-var5 * 0.5F, -var6 * 0.5F);
      ukf.shadow(var0, 0.0F, 0.0F, var5, var6, var9, 0.4F + 0.6F * var7 - 0.4F * var8, iov.lightness());
      uut.gradientH(var0, 0.0F, 0.0F, var5, var6, var9, ujt.lerp(iov.accent(), -1, 0.1F * var7), ujt.lerp(iov.accent2(), -1, 0.1F * var7));
      ukf.sheen(var0, 0.0F, 0.0F, var5, var6, var9, 1.8F);
      uut.outlineGradientV(var0, 0.0F, 0.0F, var5, var6, var9, 1.0F, 1090519039, 268435456);
      iru(var0, var1, var2, var5, var6, iov.onAccent());
      var0.getMatrices().popMatrix();
   }

   static void secondaryButton(DrawContext var0, String var1, vhz var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = iov.r(5.0F);
      float var10 = 1.0F - 0.05F * var8;
      float var11 = iov.lightness();
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var3 + var5 * 0.5F, var4 + var6 * 0.5F + 0.6F * var8 - 0.4F * var7);
      var0.getMatrices().scale(var10, var10);
      var0.getMatrices().translate(-var5 * 0.5F, -var6 * 0.5F);
      ukf.shadow(var0, 0.0F, 0.0F, var5, var6, var9, 0.2F + 0.6F * var7 - 0.2F * var8, var11);
      uut.round(var0, 0.0F, 0.0F, var5, var6, var9, ujt.lerp(iov.field, iov.fieldHover, var7));
      ukf.rim(var0, 0.0F, 0.0F, var5, var6, var9, var11, 0.7F + 0.5F * var7);
      iru(var0, var1, var2, var5, var6, ujt.lerp(iov.textDim, iov.text, var7));
      var0.getMatrices().popMatrix();
   }

   private static void iru(DrawContext var0, String var1, vhz var2, float var3, float var4, int var5) {
      float var6 = var2 != null ? 7.0F + (var1.isEmpty() ? 0.0F : 4.0F) : 0.0F;
      float var7 = VALUE.width(var1) + var6;
      float var8 = (var3 - var7) * 0.5F;
      if (var2 != null) {
         vjf.draw(var0, var2, var8 + 3.5F, var4 * 0.5F, 7.0F, var5);
      }

      VALUE.draw(var0, var1, var8 + var6, VALUE.centerTop(var4 * 0.5F), var5);
   }

   static void iconButton(DrawContext var0, vhz var1, float var2, float var3, float var4, float var5, boolean var6, float var7) {
      if (!(var7 <= 0.01F)) {
         uut.pushAlpha(var7);
         int var8 = var6 ? -1750963 : iov.accent();
         if (var5 > 0.01F || var6) {
            uut.round(
               var0,
               var2,
               var3,
               var4,
               var4,
               iov.r(4.0F),
               var6 ? ujt.withAlpha(-1750963, (int)(60.0F + 90.0F * var5)) : ujt.withAlpha(var8, (int)(40.0F * var5))
            );
         }

         int var9 = var6 ? -1 : ujt.lerp(iov.textDim, var8, var5);
         vjf.draw(var0, var1, var2 + var4 * 0.5F, var3 + var4 * 0.5F, 7.5F, var9);
         uut.popAlpha();
      }
   }

   static float drawChip(DrawContext var0, String var1, float var2, float var3, int var4, int var5, float var6) {
      float var7 = Math.max(16.0F, SMALL.width(var1) + 9.0F);
      float var8 = 11.0F;
      float var9 = var2 - var7;
      float var10 = iov.r(3.5F);
      uut.round(var0, var9, var3 - var8 * 0.5F, var7, var8, var10, ujt.lerp(iov.field, iov.fieldHover, var6));
      uut.outline(var0, var9, var3 - var8 * 0.5F, var7, var8, var10, 1.0F, var5);
      ukf.rim(var0, var9, var3 - var8 * 0.5F, var7, var8, var10, iov.lightness(), 0.5F);
      SMALL.drawCentered(var0, var1, var9 + var7 * 0.5F, SMALL.centerTop(var3), var4);
      return var9;
   }

   public static String keyName(int var0) {
      if (var0 == -1) {
         return wap.s(a.b("ᠪ憺\ueb68甒", 1969428576), a.b("\ue596鰏ᚫ", 566026632));
      }

      int var1 = vzz.mods(var0);
      if (var1 != 0) {
         StringBuilder var6 = new StringBuilder();
         if ((var1 & 2) != 0) {
            var6.append(a.d("\ud987ꀡ⫴뒛㼠릚ς", -1515651032, -1524901397));
         }

         if ((var1 & 1) != 0) {
            var6.append(a.b("ⲟ唵\udfe7䆙쩜䲙\uf6c1缻", -1006818108));
         }

         if ((var1 & 4) != 0) {
            var6.append(a.b("ঙ瀥\ufaee擫\uef37榍", 472386014));
         }

         return var6.append(keyName(vzz.baseKey(var0))).toString();
      } else if (vzz.isMouse(var0)) {
         int var5 = vzz.mouseButton(var0);

         return switch (var5) {
            case 0 -> wap.s(a.b("ꞣ\ude13哏", 806201324), a.d("嗡ⱑꚄ", -1056962709, -240494958));
            case 1 -> wap.s(a.c(-602901494, "瑛\u0df5蜩"), a.c(1633381882, "槦ၒ骇"));
            case 2 -> wap.s(a.c(29176179, "ㄽ䢌쉐"), a.c(1059229501, "謟\uf295础"));
            default -> wap.s(a.b("\udd50꓃⸊끽㮼뵈", -1973035749), a.c(-280990112, "橹\u139f饏ܺ袁")) + (var5 + 1);
         };
      } else {
         switch (var0) {
            case 32:
               return wap.s(a.d("鹕\ue7c7洅\uf376碧", 1309349884, -1637185025), a.c(156611631, "뀶짘䍵\udd0b囘큧"));
            case 257:
               return a.b("겖플必솥䩥", -1316246314);
            case 258:
               return a.c(2131715984, "柇ṃ钓");
            case 260:
               return a.d("鷍\ue45b溕", 990680040, -791933329);
            case 261:
               return a.b("\ue479鷩ᜳ", -1963072450);
            case 262:
               return wap.s(a.b("繦߬贱ፏ预", -325616079), a.d("킂ꤞ⎲붳㙦냛", 1583723691, 341925949));
            case 263:
               return wap.s(a.b("䗗㱏뚟⣼", 881280415), a.b("㸍䞕쵈匾\ud8e5", 773863962));
            case 264:
               return wap.s(a.c(383679204, "窤̾觵ឝ"), a.c(2001079959, "ઁ猟柳枷"));
            case 265:
               return wap.s(a.c(1279384849, "\udd46ꓒ"), a.c(800052892, "튋\uab1a⇎뿊㐘"));
            case 266:
               return a.d("範ɂ袣ᛷ", 1376238149, -1000422955);
            case 267:
               return a.b("硼Ǻ謊ᕑ", 752646184);
            case 268:
               return a.b("鬱\ue2a7桶\uf60f", 1125161853);
            case 269:
               return a.d("⮒刈\ud8d1", 1150987827, 1729791463);
            case 280:
               return a.b("⓴嵧\ud7a5䧗", -1700846413);
            case 340:
               return a.c(-760836543, "踋\uf7a5絍\ue33d棥\uee46");
            case 341:
               return a.d("ቑ毯\ue10b罼\uf4b5", -1331387698, 778088662);
            case 342:
               return a.c(-1129728427, "똝쾡䕟\udb36");
            case 344:
               return a.b("迏\uf67f粗\ue2e7椿\uef9c", 1732546459);
            case 345:
               return a.b("\ue0bf餟ᏻ趌م", -1264000792);
            case 346:
               return a.c(-113249067, "\uf483贡ߟ馶");
            default:
               if (var0 >= 290 && var0 <= 314) {
                  return a.c(-1135448250, "漁") + (var0 - 290 + 1);
               } else if (var0 >= 320 && var0 <= 329) {
                  return a.c(-1094911395, "塚莚॑") + (var0 - 320);
               } else if ((var0 < 65 || var0 > 90) && (var0 < 48 || var0 > 57)) {
                  String var2 = GLFW.glfwGetKeyName(var0, 0);
                  if (var2 != null && !var2.isEmpty()) {
                     return var2.toUpperCase();
                  } else {
                     try {
                        return Type.KEYSYM.createFromCode(var0).getLocalizedText().getString();
                     } catch (RuntimeException var4) {
                        return a.d("궫", 1570214490, 826490835) + var0;
                     }
                  }
               } else {
                  return String.valueOf((char)var0);
               }
         }
      }
   }
}
