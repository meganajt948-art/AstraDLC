package a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Style;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

final class svp {
   private static final int svq = -1;
   private static final float svr = 7.0F;

   private svp() {
   }

   static List<svi> of(Text var0, swb var1) {
      ArrayList var2 = new ArrayList();
      var0.visit((var2x, var3) -> {
         svu(var2, var2x, var3, var1);
         return Optional.empty();
      }, Style.EMPTY);
      return var2;
   }

   private static void svu(List<svi> var0, Style var1, String var2, swb var3) {
      int var4 = var1.getColor() != null ? 0xFF000000 | var1.getColor().getRgb() : -1;
      boolean var5 = var1.getFont() != null && !StyleSpriteSource.DEFAULT.equals(var1.getFont());
      int var6 = var4;
      boolean var7 = var1.isBold();
      boolean var8 = var1.isObfuscated();
      StringBuilder var9 = new StringBuilder();
      StringBuilder var10 = new StringBuilder();
      int var11 = 0;

      while (var11 < var2.length()) {
         int var12 = var2.codePointAt(var11);
         var11 += Character.charCount(var12);
         if (var12 == 167 && var11 < var2.length()) {
            svv(var0, var9, var10, var1, var6, var7);
            Formatting var14 = Formatting.byCode(var2.charAt(var11++));
            if (var14 != null) {
               if (var14 == Formatting.RESET) {
                  var6 = var4;
                  var7 = var1.isBold();
                  var8 = var1.isObfuscated();
               } else if (var14.isColor() && var14.getColorValue() != null) {
                  var6 = 0xFF000000 | var14.getColorValue();
                  var7 = false;
                  var8 = false;
               } else if (var14 == Formatting.BOLD) {
                  var7 = true;
               } else if (var14 == Formatting.OBFUSCATED) {
                  var8 = true;
               }
            }
         } else {
            boolean var13 = var5 || var8 || svw(var12) || !var3.font().canDisplay(var12);
            if (var13) {
               if (!var9.isEmpty()) {
                  svv(var0, var9, null, var1, var6, var7);
               }

               var10.appendCodePoint(var12);
            } else {
               if (!var10.isEmpty()) {
                  svv(var0, null, var10, var1, var6, var7);
               }

               var9.appendCodePoint(var12);
            }
         }
      }

      svv(var0, var9, var10, var1, var6, var7);
   }

   private static void svv(List<svi> var0, StringBuilder var1, StringBuilder var2, Style var3, int var4, boolean var5) {
      if (var1 != null && !var1.isEmpty()) {
         var0.add(new svi(var1.toString(), var4, var5, null));
         var1.setLength(0);
      }

      if (var2 != null && !var2.isEmpty()) {
         Style var6 = var3.withColor(TextColor.fromRgb(var4 & 16777215)).withBold(var5);
         var0.add(new svi(var2.toString(), var4, var5, Text.literal(var2.toString()).setStyle(var6)));
         var2.setLength(0);
      }
   }

   private static boolean svw(int var0) {
      return Character.getType(var0) == 18;
   }

   private static float svx(swb var0) {
      return var0.capHeight() * 1.2F / 7.0F;
   }

   static float width(List<svi> var0, swb var1, swb var2) {
      TextRenderer var3 = MinecraftClient.getInstance().textRenderer;
      float var4 = 0.0F;

      for (svi var6 : var0) {
         var4 += var6.svm != null ? var3.getWidth(var6.svm) * svx(var1) : (var6.svl ? var2 : var1).width(var6.svj);
      }

      return var4;
   }

   static float draw(DrawContext var0, List<svi> var1, float var2, float var3, swb var4, swb var5, int var6) {
      TextRenderer var7 = MinecraftClient.getInstance().textRenderer;
      float var8 = var3 + var4.capHeight() * 0.5F;

      for (svi var10 : var1) {
         if (var10.svm != null) {
            float var11 = svx(var4);
            var0.getMatrices().pushMatrix();
            var0.getMatrices().translate(var2, var8 - 7.0F * var11);
            var0.getMatrices().scale(var11, var11);
            var0.drawText(var7, var10.svm, 0, 0, uut.fade(-1), false);
            var0.getMatrices().popMatrix();
            var2 += var7.getWidth(var10.svm) * var11;
         } else {
            swb var13 = var10.svl ? var5 : var4;
            float var12 = var13.centerTop(var3);
            if (var6 >>> 24 != 0) {
               var13.draw(var0, var10.svj, var2 + 0.55F, var12 + 0.55F, var6);
            }

            var2 = var13.draw(var0, var10.svj, var2, var12, var10.svk);
         }
      }

      return var2;
   }
}
