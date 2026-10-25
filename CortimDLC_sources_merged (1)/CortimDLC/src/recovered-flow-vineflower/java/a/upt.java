package a;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class upt {
   static final int upu = 3;
   static final Map<Integer, uok> upv = new LinkedHashMap<>();
   static BufferedImage upw;
   static boolean upx;
   static final Map<uok, Long> upy = new LinkedHashMap<>();

   upt() {
   }

   public static boolean draw(DrawContext var0, float var1, float var2, float var3, int var4) {
      uok var5 = uqb(var3);
      if (var5 == null) {
         return false;
      }

      uut.image(var0, var5.view, var1, var2, var3, var3, 0.0F, var4);
      return true;
   }

   static uok uqb(float var0) {
      if (upx) {
         return null;
      }

      MinecraftClient var1 = MinecraftClient.getInstance();
      float var2 = var1.getWindow() != null ? Math.max(1, var1.getWindow().getScaleFactor()) : 2.0F;
      int var3 = Math.max(8, Math.min(512, Math.round(var0 * var2 * vdn.renderScale())));
      uok var4 = upv.get(var3);
      if (var4 != null) {
         return var4;
      }

      try {
         if (upw == null) {
            try (InputStream var5 = upt.class.getResourceAsStream("/flow/logo.png")) {
               if (var5 == null) {
                  throw new IllegalStateException("missing /flow/logo.png");
               }

               upw = ImageIO.read(var5);
            }
         }

         var4 = uok.upload("logo " + var3, uqd(upw, var3), false, true);
      } catch (Throwable var10) {
         upx = true;
         System.out.println("logo unavailable: " + var10);
         return null;
      }

      upv.put(var3, var4);

      while (upv.size() > 3) {
         Iterator var12 = upv.entrySet().iterator();
         uok var6 = (uok)((Entry)var12.next()).getValue();
         var12.remove();
         upy.put(var6, unf.frame());
      }

      uqc();
      return var4;
   }

   static void uqc() {
      long var0 = unf.frame();
      upy.entrySet().removeIf(var2 -> {
         if (var0 - var2.getValue() > 3L) {
            var2.getKey().close();
            return true;
         } else {
            return false;
         }
      });
   }

   static BufferedImage uqd(BufferedImage var0, int var1) {
      BufferedImage var2 = new BufferedImage(var0.getWidth(), var0.getHeight(), 3);
      Graphics2D var3 = var2.createGraphics();
      var3.drawImage(var0, 0, 0, null);
      var3.dispose();

      while (var2.getWidth() / 2 >= var1) {
         int var4 = var2.getWidth() / 2;
         BufferedImage var5 = new BufferedImage(var4, var4, 3);
         Graphics2D var6 = var5.createGraphics();
         var6.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         var6.drawImage(var2, 0, 0, var4, var4, null);
         var6.dispose();
         var2 = var5;
      }

      BufferedImage var7 = new BufferedImage(var1, var1, 2);
      Graphics2D var8 = var7.createGraphics();
      if (var2.getWidth() != var1) {
         Image var9 = var2.getScaledInstance(var1, var1, 16);
         var8.drawImage(var9, 0, 0, null);
      } else {
         var8.drawImage(var2, 0, 0, null);
      }

      var8.dispose();
      bleed(var7);
      return var7;
   }

   static void bleed(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int[] var3 = var0.getRGB(0, 0, var1, var2, null, 0, var1);

      for (int var4 = 0; var4 < 2; var4++) {
         int[] var5 = (int[])var3.clone();

         for (int var6 = 0; var6 < var2; var6++) {
            for (int var7 = 0; var7 < var1; var7++) {
               int var8 = var6 * var1 + var7;
               if (var3[var8] >>> 24 == 0) {
                  int var9 = 0;
                  int var10 = 0;
                  int var11 = 0;
                  int var12 = 0;

                  for (int var13 = -1; var13 <= 1; var13++) {
                     for (int var14 = -1; var14 <= 1; var14++) {
                        int var15 = var7 + var14;
                        int var16 = var6 + var13;
                        if (var15 >= 0 && var16 >= 0 && var15 < var1 && var16 < var2) {
                           int var17 = var3[var16 * var1 + var15];
                           if (var17 >>> 24 != 0 || (var17 & 16777215) != 0) {
                              var9 += var17 >> 16 & 0xFF;
                              var10 += var17 >> 8 & 0xFF;
                              var11 += var17 & 0xFF;
                              var12++;
                           }
                        }
                     }
                  }

                  if (var12 > 0) {
                     var5[var8] = var9 / var12 << 16 | var10 / var12 << 8 | var11 / var12;
                  }
               }
            }
         }

         var3 = var5;
      }

      var0.setRGB(0, 0, var1, var2, var3, 0, var1);
   }
}
