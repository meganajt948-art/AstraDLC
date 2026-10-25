package a;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import net.minecraft.client.texture.NativeImage;

final class vfk {
   static final String TEXT_CHARSET = vfv();
   static final int vfl = 1;
   static final int vfm = 1;
   static final float vfn = 0.86F;
   final float pixelsPerUnit;
   final float ascent;
   final float descent;
   final float capHeight;
   final GpuTextureView view;
   final GpuTexture vfo;
   final Int2ObjectOpenHashMap<vev> vfp;
   final Font vfq;

   vfk(float var1, float var2, float var3, float var4, GpuTexture var5, GpuTextureView var6, Int2ObjectOpenHashMap<vev> var7, Font var8) {
      this.pixelsPerUnit = var1;
      this.ascent = var2;
      this.descent = var3;
      this.capHeight = var4;
      this.vfo = var5;
      this.view = var6;
      this.vfp = var7;
      this.vfq = var8;
   }

   vev glyph(int var1) {
      vev var2 = (vev)this.vfp.get(var1);
      if (var2 == null && var1 != 63) {
         var2 = (vev)this.vfp.get(63);
      }

      return var2;
   }

   boolean has(int var1) {
      return this.vfp.containsKey(var1);
   }

   boolean canDisplay(int var1) {
      return this.vfq.canDisplay(var1);
   }

   void close() {
      this.view.close();
      this.vfo.close();
   }

   static vfk build(String var0, Font var1, float var2, float var3, String var4, boolean var5) {
      Font var6 = var1.deriveFont(var2 * var3);
      FontRenderContext var7 = new FontRenderContext(null, true, true);
      ArrayList var8 = new ArrayList();
      BitSet var9 = new BitSet();
      int var10 = 0;

      while (var10 < var4.length()) {
         int var11 = var4.codePointAt(var10);
         var10 += Character.charCount(var11);
         if (var11 >= 65536 || !var9.get(var11)) {
            if (var11 < 65536) {
               var9.set(var11);
            }

            if (var6.canDisplay(var11) || var11 == 32) {
               GlyphVector var12 = var6.createGlyphVector(var7, new String(Character.toChars(var11)));
               Rectangle var13 = var12.getPixelBounds(var7, 0.0F, 0.0F);
               float var14 = (float)var12.getGlyphPosition(var12.getNumGlyphs()).getX();
               var8.add(new vfh(var11, var12, var13, var14));
            }
         }
      }

      short var31 = 256;

      while (true) {
         int var32 = vft(var8, var31);
         if (var32 <= var31 || var31 >= 4096) {
            var32 = Math.max(16, vfu(var32));
            BufferedImage var34 = new BufferedImage(var31, var32, 2);
            Graphics2D var35 = var34.createGraphics();
            var35.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            var35.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            var35.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            var35.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            var35.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            var35.setColor(Color.WHITE);
            Int2ObjectOpenHashMap var36 = new Int2ObjectOpenHashMap();
            float var15 = 1.0F / var3;

            for (vfh var17 : var8) {
               if (var17.bounds.width > 0 && var17.bounds.height > 0) {
                  var35.drawGlyphVector(var17.vector, var17.x + 1 - var17.bounds.x, var17.y + 1 - var17.bounds.y);
                  int var18 = var17.bounds.width + 2;
                  int var19 = var17.bounds.height + 2;
                  var36.put(
                     var17.cp,
                     new vev(
                        (float)var17.x / var31,
                        (float)var17.y / var32,
                        (float)(var17.x + var18) / var31,
                        (float)(var17.y + var19) / var32,
                        (var17.bounds.x - 1) * var15,
                        (var17.bounds.y - 1) * var15,
                        var18 * var15,
                        var19 * var15,
                        var17.advance * var15
                     )
                  );
               } else {
                  var36.put(var17.cp, new vev(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var17.advance * var15));
               }
            }

            var35.dispose();
            LineMetrics var37 = var6.getLineMetrics("Hgy", var7);
            float var38 = var37.getAscent() * var15;
            float var39 = var37.getDescent() * var15;
            float var40;
            if (var5) {
               var40 = var2 * 0.9F;
               var38 = var2;
               var39 = 0.0F;
            } else {
               Rectangle var20 = var6.createGlyphVector(var7, "H").getPixelBounds(var7, 0.0F, 0.0F);
               var40 = var20.height > 0 ? var20.height * var15 : var38 * 0.72F;
            }

            int[] var41 = ((DataBufferInt)var34.getRaster().getDataBuffer()).getData();
            int[] var21 = new int[256];

            for (int var22 = 0; var22 < 256; var22++) {
               var21[var22] = Math.round((float)Math.pow(var22 / 255.0F, 0.86F) * 255.0F);
            }

            GpuDevice var42 = RenderSystem.getDevice();
            GpuTexture var23 = var42.createTexture(() -> "Flow2 font " + var0, 5, TextureFormat.RGBA8, var31, var32, 1, 1);

            try (NativeImage var24 = new NativeImage(var31, var32, false)) {
               for (int var25 = 0; var25 < var32; var25++) {
                  int var26 = var25 * var31;

                  for (int var27 = 0; var27 < var31; var27++) {
                     int var28 = var21[var41[var26 + var27] >>> 24 & 0xFF];
                     var24.setColorArgb(var27, var25, var28 << 24 | 16777215);
                  }
               }

               RenderSystem.getDevice().createCommandEncoder().writeToTexture(var23, var24);
            }

            GpuTextureView var43 = var42.createTextureView(var23);
            return new vfk(var3, var38, var39, var40, var23, var43, var36, var6);
         }

         var31 *= 2;
      }
   }

   static int vft(List<vfh> var0, int var1) {
      int var2 = 1;
      int var3 = 1;
      int var4 = 0;

      for (vfh var6 : var0) {
         if (var6.bounds.width > 0 && var6.bounds.height > 0) {
            int var7 = var6.bounds.width + 2;
            int var8 = var6.bounds.height + 2;
            if (var2 + var7 + 1 > var1) {
               var2 = 1;
               var3 += var4 + 1;
               var4 = 0;
            }

            var6.x = var2;
            var6.y = var3;
            var2 += var7 + 1;
            var4 = Math.max(var4, var8);
         }
      }

      return var3 + var4 + 1;
   }

   static int vfu(int var0) {
      byte var1 = 1;

      while (var1 < var0) {
         var1 <<= 1;
      }

      return var1;
   }

   static String vfv() {
      StringBuilder var0 = new StringBuilder();

      for (int var1 = 32; var1 < 127; var1++) {
         var0.append((char)var1);
      }

      for (int var2 = 1040; var2 <= 1103; var2++) {
         var0.append((char)var2);
      }

      var0.append("Ёё…•·–—«»°±×←→↑↓№");
      return var0.toString();
   }
}
