package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.splash.Snow;
import java.util.Random;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

public final class jsi {
   private static final int[] jsj = new int[]{16762844, 16756940, 16768489, 16227517};
   private static final int[] jsk = new int[]{15234090, 14241823, 15901498, 13058076, 15319114};
   private final jsf jsl;
   private final Snow jsm;
   private final int jsn;
   private final float[] jso;
   private final float[] jsp;
   private final float[] jsq;
   private final float[] jsr;
   private final float[] jss;
   private final float[] jst;
   private final float[] jsu;
   private final float[] jsv;
   private final float[] jsw;
   private final int[] jsx;

   public jsi(jsf var1, long var2) {
      this.jsl = var1;
      this.jsm = var1 == jsf.SNOW ? new Snow(var2) : null;

      this.jsn = switch (var1) {
         case SNOW -> 0;
         case PETALS -> 70;
         case MOTES -> 90;
         case LEAVES -> 34;
         case FIREFLIES -> 46;
         case SILVER, INK -> 64;
      };
      this.jso = new float[this.jsn];
      this.jsp = new float[this.jsn];
      this.jsq = new float[this.jsn];
      this.jsr = new float[this.jsn];
      this.jss = new float[this.jsn];
      this.jst = new float[this.jsn];
      this.jsu = new float[this.jsn];
      this.jsv = new float[this.jsn];
      this.jsw = new float[this.jsn];
      this.jsx = new int[this.jsn];
      Random var4 = new Random(var2);

      for (int var5 = 0; var5 < this.jsn; var5++) {
         this.jso[var5] = var4.nextFloat();
         this.jsp[var5] = var4.nextFloat();
         this.jsu[var5] = var4.nextFloat() * 6.2832F;
         this.jst[var5] = 0.3F + var4.nextFloat() * 0.8F;
         this.jsv[var5] = (var4.nextBoolean() ? 1.0F : -1.0F) * (0.6F + var4.nextFloat() * 1.6F);
         this.jsw[var5] = 0.3F + var4.nextFloat() * (var5 % 9 == 0 ? 1.3F : 0.7F);
         switch (var1) {
            case PETALS:
               this.jsr[var5] = (1.6F + var4.nextFloat() * 1.4F) * this.jsw[var5];
               this.jsq[var5] = (9.0F + var4.nextFloat() * 9.0F) * this.jsw[var5];
               this.jss[var5] = 6.0F + var4.nextFloat() * 10.0F;
               this.jsx[var5] = jsj[var4.nextInt(jsj.length)];
               break;
            case MOTES:
               this.jsr[var5] = (0.5F + var4.nextFloat() * 0.9F) * this.jsw[var5];
               this.jsq[var5] = -(1.5F + var4.nextFloat() * 4.0F) * this.jsw[var5];
               this.jss[var5] = 4.0F + var4.nextFloat() * 8.0F;
               this.jsx[var5] = var4.nextInt(3) == 0 ? 16777215 : 16769704;
               break;
            case LEAVES:
               this.jsr[var5] = (2.6F + var4.nextFloat() * 2.0F) * this.jsw[var5];
               this.jsq[var5] = (11.0F + var4.nextFloat() * 10.0F) * this.jsw[var5];
               this.jss[var5] = 9.0F + var4.nextFloat() * 14.0F;
               this.jsx[var5] = jsk[var4.nextInt(jsk.length)];
               break;
            case FIREFLIES:
            default:
               this.jsr[var5] = (0.7F + var4.nextFloat() * 0.9F) * this.jsw[var5];
               this.jsq[var5] = -(1.0F + var4.nextFloat() * 3.0F) * this.jsw[var5];
               this.jss[var5] = 6.0F + var4.nextFloat() * 12.0F;
               this.jsx[var5] = var4.nextInt(4) == 0 ? 16773296 : 12120319;
               break;
            case SILVER:
            case INK:
               this.jsr[var5] = (0.45F + var4.nextFloat() * 0.8F) * this.jsw[var5];
               this.jsq[var5] = -(1.0F + var4.nextFloat() * 3.0F) * this.jsw[var5];
               this.jss[var5] = 4.0F + var4.nextFloat() * 8.0F;
               this.jsx[var5] = var1 == jsf.SILVER ? (var4.nextInt(3) == 0 ? 16777215 : 14476012) : 1974310;
         }
      }
   }

   public void draw(DrawContext var1, GpuTextureView var2, float var3, float var4, float var5, boolean var6, float var7, float var8, float var9) {
      if (!(var9 <= 0.003F)) {
         uut.pushAlpha(var9);

         try {
            if (this.jsm == null) {
               float var10 = 6.0F * (float)Math.sin(var5 * 0.27F) + 3.0F * (float)Math.sin(var5 * 0.71F + 1.1F);
               uut.beginBatch();

               try {
                  for (int var11 = 0; var11 < this.jsn; var11++) {
                     if (this.jsw[var11] > 1.05F == var6) {
                        this.jta(var1, var2, var11, var3, var4, var5, var10, var7, var8);
                     }
                  }

                  return;
               } finally {
                  uut.endBatch();
               }
            }

            this.jsm.draw(var1, var2, var3, var4, var5, var6, var7, var8);
         } finally {
            uut.popAlpha();
         }
      }
   }

   private void jta(DrawContext var1, GpuTextureView var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = 16.0F;
      float var11 = var5 + var10 * 2.0F;
      float var12 = var4 + var10 * 2.0F;
      float var13 = this.jsp[var3] * var11 + var6 * this.jsq[var3];
      float var14 = (var13 % var11 + var11) % var11 - var10;
      float var15 = this.jsw[var3] * (var6 * (this.jsl == jsf.LEAVES ? 9.0F : 5.0F) + var7)
         + this.jss[var3] * (float)Math.sin(var6 * this.jst[var3] + this.jsu[var3]);
      float var16 = ((this.jso[var3] * var12 + var15) % var12 + var12) % var12 - var10;
      var16 -= var8 * this.jsw[var3] * 10.0F;
      var14 -= var9 * this.jsw[var3] * 6.0F;
      float var17 = Math.min(1.0F, 0.35F + this.jsw[var3] * 0.55F);
      switch (this.jsl) {
         case PETALS:
            this.jtb(var1, var16, var14, this.jsr[var3], this.jsr[var3] * 0.62F, var6, var3, jtd(this.jsx[var3], 0.85F * var17), true);
            break;
         case MOTES:
         case SILVER:
            float var24 = 0.55F + 0.45F * (float)Math.sin(var6 * (1.1F + this.jst[var3]) + this.jsu[var3] * 3.0F);
            if (var2 != null) {
               uut.additive(true);
               uut.sprite(var1, var2, var16, var14, this.jsr[var3] * 7.0F, jtd(this.jsx[var3], 0.35F * var24 * var17));
               uut.additive(false);
            }

            uut.circle(var1, var16, var14, this.jsr[var3] * 0.5F, jtd(this.jsx[var3], 0.8F * var24 * var17));
            break;
         case LEAVES:
            this.jtb(var1, var16, var14, this.jsr[var3], this.jsr[var3] * 0.55F, var6, var3, jtd(this.jsx[var3], 0.95F * var17), false);
            break;
         case FIREFLIES:
         default:
            float var22 = Math.max(0.0F, (float)Math.sin(var6 * (0.6F + this.jst[var3] * 0.7F) + this.jsu[var3] * 5.0F));
            var22 *= var22;
            float var19 = var16 + 6.0F * (float)Math.sin(var6 * 0.43F + this.jsu[var3] * 2.0F);
            if (var2 != null) {
               uut.additive(true);
               uut.sprite(var1, var2, var19, var14, this.jsr[var3] * 11.0F, jtd(this.jsx[var3], 0.45F * var22 * var17));
               uut.additive(false);
            }

            uut.circle(var1, var19, var14, this.jsr[var3] * 0.45F, jtd(16777215, (0.25F + 0.7F * var22) * var17));
            break;
         case INK:
            float var18 = 0.55F + 0.45F * (float)Math.sin(var6 * (1.1F + this.jst[var3]) + this.jsu[var3] * 3.0F);
            uut.circle(var1, var16, var14, this.jsr[var3] * 0.5F, jtd(this.jsx[var3], 0.5F * var18 * var17));
      }
   }

   private void jtb(DrawContext var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, boolean var9) {
      Matrix3x2fStack var10 = var1.method_51448();
      var10.pushMatrix();
      var10.translate(var2, var3);
      var10.rotate(this.jsu[var7] + var6 * this.jsv[var7] * 0.6F);
      float var11 = (float)Math.cos(var6 * this.jsv[var7] * 1.3F + this.jsu[var7]);
      float var12 = Math.max(0.12F, Math.abs(var11));
      var10.scale(var12, 1.0F);
      int var13 = var11 < 0.0F ? jtc(var8, 0.82F) : var8;
      if (var9) {
         uut.round(var1, -var4 * 0.5F, -var5 * 0.5F, var4, var5, var5 * 0.5F, var13);
      } else {
         var10.rotate(0.785F);
         float var14 = var4 * 0.62F;
         uut.round(var1, -var14 * 0.5F, -var14 * 0.5F, var14, var14, 0.0F, var14 * 0.5F, 0.0F, var14 * 0.5F, var13);
         uut.line(var1, -var14 * 0.42F, -var14 * 0.42F, var14 * 0.42F, var14 * 0.42F, Math.max(0.25F, var14 * 0.07F), jtc(var13, 0.7F));
      }

      var10.popMatrix();
   }

   private static int jtc(int var0, float var1) {
      int var2 = Math.round((var0 >> 16 & 0xFF) * var1);
      int var3 = Math.round((var0 >> 8 & 0xFF) * var1);
      int var4 = Math.round((var0 & 0xFF) * var1);
      return var0 & 0xFF000000 | var2 << 16 | var3 << 8 | var4;
   }

   private static int jtd(int var0, float var1) {
      int var2 = Math.max(0, Math.min(255, Math.round(var1 * 255.0F)));
      return var2 << 24 | var0 & 16777215;
   }
}
