package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.splash.Wordmark;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

public final class kce {
   private static final int kcf = 14;
   private final float kcg;
   private Wordmark kch;
   private final List<Wordmark> kci = new ArrayList<>();
   private final List<Long> kcj = new ArrayList<>();
   private static final List<Wordmark> kck = new ArrayList<>();
   private static final List<Long> kcl = new ArrayList<>();

   public kce(float var1) {
      this.kcg = var1;
   }

   public float width(float var1) {
      return this.kcr(var1).width;
   }

   public void draw(
      DrawContext var1, GpuTextureView var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11
   ) {
      this.kcs();
      Wordmark var12 = this.kcr(var6 * var5);
      Matrix3x2fStack var13 = var1.method_51448();
      var13.pushMatrix();
      var13.translate(var3, var4);
      var13.scale(var5, var5);

      try {
         float var14 = -var12.width * 0.5F;
         float var15 = var12.cap * 0.5F;
         float var16 = -var9 * 0.33F;
         float var17 = 0.42F - var10 * 0.12F;
         float var18 = this.kcg / 34.0F;
         if (var2 != null) {
            uut.additive(true);
            float var19 = vcq.clamp01(var8 * 1.4F - 0.3F);
            float var20 = 0.85F + 0.15F * (float)Math.sin(var7 * 1.3F);
            uut.image(var1, var2, -var12.width * 0.8F, -var12.cap * 2.2F, var12.width * 1.6F, var12.cap * 4.4F, 0.0F, rgba(var11, 0.2F * var19 * var20));
            uut.additive(false);
         }

         int var33 = mix(var11, 659226, 0.62F);
         int var34 = mix(var11, 329484, 0.86F);

         for (int var21 = 0; var21 < 4; var21++) {
            for (int var22 = 0; var22 < var12.glyphs.length; var22++) {
               Wordmark.Glyph var23 = var12.glyphs[var22];
               float var24 = kco(var22, var12.glyphs.length, var8);
               if (!(var24 <= 0.0F)) {
                  float var25 = vcq.clamp01(var24 * 2.2F);
                  var13.pushMatrix();
                  kcp(var13, var23, var22, var24, var14, var15, var7);
                  float var26 = var23.x() - var23.cx();
                  float var27 = var23.y() - var23.cy();
                  switch (var21) {
                     case 0:
                        uut.image(
                           var1,
                           var23.soft().view,
                           var26 + var16 * 14.0F * var18 * 1.6F,
                           var27 + var17 * 14.0F * var18 * 1.9F,
                           var23.w(),
                           var23.h(),
                           0.0F,
                           rgba(0, 0.55F * var25)
                        );
                        break;
                     case 1:
                        for (int var36 = 14; var36 >= 1; var36--) {
                           int var29 = mix(var33, var34, var36 / 14.0F);
                           uut.image(
                              var1,
                              var23.sharp().view,
                              var26 + var16 * var36 * var18,
                              var27 + var17 * var36 * var18,
                              var23.w(),
                              var23.h(),
                              0.0F,
                              rgba(var29, var25)
                           );
                        }
                        break;
                     case 2:
                        int var35 = var23.second() ? mix(16777215, var11, 0.5F) : 16777215;
                        uut.image(var1, var23.sharp().view, var26, var27, var23.w(), var23.h(), 0.0F, rgba(var35, var25));
                        break;
                     default:
                        float var28 = kcq(var23.cx() / var12.width, var7);
                        if (var28 > 0.01F) {
                           uut.additive(true);
                           uut.image(var1, var23.sharp().view, var26, var27, var23.w(), var23.h(), 0.0F, rgba(16777215, var28 * var25));
                           uut.additive(false);
                        }
                  }

                  var13.popMatrix();
               }
            }
         }
      } finally {
         uut.additive(false);
         var13.popMatrix();
      }
   }

   private static float kco(int var0, int var1, float var2) {
      float var3 = 0.55F;
      float var4 = (float)var0 / Math.max(1, var1 - 1) * (1.0F - var3);
      return vcq.clamp01((var2 - var4) / var3);
   }

   private static void kcp(Matrix3x2fStack var0, Wordmark.Glyph var1, int var2, float var3, float var4, float var5, float var6) {
      float var7 = -(1.0F - vcq.outBack(var3)) * 26.0F;
      float var8 = (1.0F - vcq.outCubic(var3)) * (var2 % 2 == 0 ? -0.35F : 0.28F);
      float var9 = 1.0F + 0.35F * (1.0F - vcq.outCubic(var3));
      float var10 = (float)Math.sin(var6 * 1.6F + var2 * 0.55F) * 0.9F * vcq.clamp01(var3 * 3.0F - 2.0F);
      var0.translate(var4 + var1.cx(), var5 + var1.cy() + var7 + var10);
      var0.rotate(var8);
      var0.scale(var9, var9);
   }

   private static float kcq(float var0, float var1) {
      float var2 = var1 % 5.5F / 1.6F;
      if (var2 > 1.0F) {
         return 0.0F;
      } else {
         float var3 = (var0 - (-0.2F + 1.4F * var2)) / 0.09F;
         return 0.55F * (float)Math.exp(-var3 * var3);
      }
   }

   private Wordmark kcr(float var1) {
      int var2 = Math.max(12, Math.round(this.kcg * var1));
      if (this.kch != null && this.kch.px == var2) {
         return this.kch;
      } else {
         if (this.kch != null) {
            this.kci.add(this.kch);
            this.kcj.add(unf.frame());
         }

         this.kch = Wordmark.build(this.kcg, var1, true);
         return this.kch;
      }
   }

   private void kcs() {
      long var1 = unf.frame();

      for (int var3 = this.kci.size() - 1; var3 >= 0; var3--) {
         if (var1 - this.kcj.get(var3) > 3L) {
            this.kci.remove(var3).close();
            this.kcj.remove(var3);
         }
      }
   }

   public void close() {
      if (this.kch != null) {
         this.kci.add(this.kch);
         this.kcj.add(unf.frame());
         this.kch = null;
      }

      kck.addAll(this.kci);
      kcl.addAll(this.kcj);
      this.kci.clear();
      this.kcj.clear();
   }

   public static void collectClosed() {
      long var0 = unf.frame();

      for (int var2 = kck.size() - 1; var2 >= 0; var2--) {
         if (var0 - kcl.get(var2) > 3L) {
            kck.remove(var2).close();
            kcl.remove(var2);
         }
      }
   }

   public static int mix(int var0, int var1, float var2) {
      int var3 = Math.round((var0 >> 16 & 0xFF) + ((var1 >> 16 & 0xFF) - (var0 >> 16 & 0xFF)) * var2);
      int var4 = Math.round((var0 >> 8 & 0xFF) + ((var1 >> 8 & 0xFF) - (var0 >> 8 & 0xFF)) * var2);
      int var5 = Math.round((var0 & 0xFF) + ((var1 & 0xFF) - (var0 & 0xFF)) * var2);
      return var3 << 16 | var4 << 8 | var5;
   }

   static int rgba(int var0, float var1) {
      int var2 = Math.max(0, Math.min(255, Math.round(var1 * 255.0F)));
      return var2 << 24 | var0 & 16777215;
   }
}
