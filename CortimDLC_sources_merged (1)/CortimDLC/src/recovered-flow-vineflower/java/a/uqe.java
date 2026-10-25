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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class uqe {
   private static final int uqf = 60;
   private static final int uqg = 10;
   private static final int uqh = 128;
   private static final float uqi = 10.0F;
   private static final int uqj = 4;
   private static final ExecutorService uqk = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Flow2 logo frames");
      var1.setDaemon(true);
      var1.setPriority(1);
      return var1;
   });
   private static final BufferedImage[] uql = new BufferedImage[2];
   private static final uok[] uqm = new uok[2];
   private static final Map<Integer, uok> uqn = new LinkedHashMap<>();
   private static final Map<Integer, CompletableFuture<BufferedImage>> uqo = new LinkedHashMap<>();
   private static final Map<uok, Long> uqp = new LinkedHashMap<>();
   private static boolean uqq;
   private static final long uqr = System.nanoTime();

   private uqe() {
   }

   public static boolean draw(DrawContext var0, float var1, float var2, float var3, boolean var4, int var5) {
      if (uqq) {
         return false;
      } else {
         uqy();
         int var6 = var4 ? 1 : 0;
         MinecraftClient var7 = MinecraftClient.method_1551();
         float var8 = var7.method_22683() != null ? Math.max(1, var7.method_22683().method_4495()) : 2.0F;
         int var9 = Math.max(8, Math.min(128, Math.round(var3 * var8 * vdn.renderScale())));
         uok var10 = uqx(var6, var9);
         int var11 = var9;
         if (var10 == null) {
            var10 = uqw(var6);
            var11 = 128;
         }

         if (var10 == null) {
            return false;
         } else {
            float var12 = (float)(System.nanoTime() - uqr) / 1.0E9F * 10.0F;
            int var13 = (int)var12 % 60;
            float var14 = var12 - (int)var12;
            uqu(var0, var10, var11, var13, var1, var2, var3, var5);
            if (var14 > 0.02F) {
               uqu(var0, var10, var11, (var13 + 1) % 60, var1, var2, var3, ujt.mulAlpha(var5, var14));
            }

            return true;
         }
      }
   }

   private static void uqu(DrawContext var0, uok var1, int var2, int var3, float var4, float var5, float var6, int var7) {
      int var8 = var3 % 10;
      int var9 = var3 / 10;
      float var10 = (var8 * var2 + 0.5F) / var1.width;
      float var11 = (var9 * var2 + 0.5F) / var1.height;
      float var12 = ((var8 + 1) * var2 - 0.5F) / var1.width;
      float var13 = ((var9 + 1) * var2 - 0.5F) / var1.height;
      uut.imageRegion(var0, var1.view, var4, var5, var6, var6, 0.0F, var10, var11, var12, var13, var7, false);
   }

   private static BufferedImage uqv(int var0) {
      if (uql[var0] == null) {
         String var1 = var0 == 1 ? "/flow/logo_anim_ink.png" : "/flow/logo_anim_silver.png";

         try (InputStream var2 = uqe.class.getResourceAsStream(var1)) {
            if (var2 == null) {
               throw new IllegalStateException("missing " + var1);
            }

            uql[var0] = ImageIO.read(var2);
         } catch (Exception var7) {
            uqq = true;
            System.out.println("animated logo unavailable: " + var7);
            return null;
         }
      }

      return uql[var0];
   }

   private static uok uqw(int var0) {
      if (uqm[var0] == null) {
         BufferedImage var1 = uqv(var0);
         if (var1 == null) {
            return null;
         }

         uqm[var0] = uok.upload("logo frames " + var0, var1, false, true);
      }

      return uqm[var0];
   }

   private static uok uqx(int var0, int var1) {
      int var2 = var0 * 1000 + var1;
      uok var3 = uqn.get(var2);
      if (var3 != null) {
         return var3;
      } else {
         CompletableFuture var4 = uqo.get(var2);
         if (var4 == null) {
            BufferedImage var9 = uqv(var0);
            if (var9 == null) {
               return null;
            } else {
               uqo.put(var2, CompletableFuture.supplyAsync(() -> urb(var9, var1), uqk));
               return null;
            }
         } else if (!var4.isDone()) {
            return null;
         } else {
            uqo.remove(var2);
            BufferedImage var5 = (BufferedImage)var4.getNow(null);
            if (var5 == null) {
               return null;
            } else {
               var3 = uok.upload("logo frames " + var2, var5, false, true);
               uqn.put(var2, var3);

               while (uqn.size() > 4) {
                  Iterator var6 = uqn.entrySet().iterator();
                  uok var7 = (uok)((Entry)var6.next()).getValue();
                  var6.remove();
                  uqp.put(var7, unf.frame());
               }

               return var3;
            }
         }
      }
   }

   private static void uqy() {
      long var0 = unf.frame();
      uqp.entrySet().removeIf(var2 -> {
         if (var0 - var2.getValue() > 3L) {
            var2.getKey().close();
            return true;
         } else {
            return false;
         }
      });
   }

   private static void uqz(BufferedImage var0, float var1) {
      int var2 = var0.getWidth();
      int var3 = var0.getHeight();
      int[] var4 = var0.getRGB(0, 0, var2, var3, null, 0, var2);
      int[] var5 = (int[])var4.clone();

      for (int var6 = 1; var6 < var3 - 1; var6++) {
         for (int var7 = 1; var7 < var2 - 1; var7++) {
            int var8 = var4[var6 * var2 + var7];
            if (var8 >>> 24 >= 160) {
               int var9 = 0;
               int var10 = 0;
               int var11 = 0;
               int var12 = 0;

               for (int var13 = -1; var13 <= 1; var13++) {
                  for (int var14 = -1; var14 <= 1; var14++) {
                     int var15 = var4[(var6 + var13) * var2 + var7 + var14];
                     if (var15 >>> 24 >= 160) {
                        var9 += var15 >> 16 & 0xFF;
                        var10 += var15 >> 8 & 0xFF;
                        var11 += var15 & 0xFF;
                        var12++;
                     }
                  }
               }

               int var16 = var8 >> 16 & 0xFF;
               int var18 = var8 >> 8 & 0xFF;
               int var20 = var8 & 0xFF;
               var16 = ura(Math.round(var16 + var1 * (var16 - (float)var9 / var12)));
               var18 = ura(Math.round(var18 + var1 * (var18 - (float)var10 / var12)));
               var20 = ura(Math.round(var20 + var1 * (var20 - (float)var11 / var12)));
               var5[var6 * var2 + var7] = var8 & 0xFF000000 | var16 << 16 | var18 << 8 | var20;
            }
         }
      }

      var0.setRGB(0, 0, var2, var3, var5, 0, var2);
   }

   private static int ura(int var0) {
      return Math.max(0, Math.min(255, var0));
   }

   private static BufferedImage urb(BufferedImage var0, int var1) {
      try {
         byte var2 = 6;
         BufferedImage var3 = new BufferedImage(10 * var1, var2 * var1, 2);

         for (int var4 = 0; var4 < 60; var4++) {
            int var5 = var4 % 10;
            int var6 = var4 / 10;
            BufferedImage var7 = new BufferedImage(128, 128, 3);
            Graphics2D var8 = var7.createGraphics();
            var8.drawImage(var0.getSubimage(var5 * 128, var6 * 128, 128, 128), 0, 0, null);
            var8.dispose();
            BufferedImage var9 = var7;

            while (var9.getWidth() / 2 >= var1) {
               int var10 = var9.getWidth() / 2;
               BufferedImage var11 = new BufferedImage(var10, var10, 3);
               Graphics2D var12 = var11.createGraphics();
               var12.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
               var12.drawImage(var9, 0, 0, var10, var10, null);
               var12.dispose();
               var9 = var11;
            }

            Graphics2D var14 = var3.createGraphics();
            if (var9.getWidth() != var1) {
               Image var15 = var9.getScaledInstance(var1, var1, 16);
               var14.drawImage(var15, var5 * var1, var6 * var1, null);
            } else {
               var14.drawImage(var9, var5 * var1, var6 * var1, null);
            }

            var14.dispose();
         }

         if (var1 < 80) {
            uqz(var3, var1 < 48 ? 0.55F : 0.3F);
         }

         upt.bleed(var3);
         return var3;
      } catch (Throwable var13) {
         System.out.println("logo frames at " + var1 + " px failed: " + var13);
         return null;
      }
   }
}
