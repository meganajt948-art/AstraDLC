package a;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import org.jspecify.annotations.Nullable;

public final class sql {
   public static final int APPEAR = 1;
   public static final int CRACK = 2;
   public static final int BURST = 4;
   private static final float sqm = 0.38F;
   private static final float sqn = 0.72F;
   private static final float sqo = 1.3F;
   private static final float sqp = 15.0F;
   public final double x;
   public final double y;
   public final double z;
   public final boolean totem;
   public final float red;
   public final float green;
   public final float blue;
   private final int sqq;
   private final int sqr;
   private final int[] sqs;
   private final int[] sqt;
   private final float[] squ;
   private final float[] sqv;
   private final float[] sqw;
   private final int[] sqx;
   private final float[] sqy;
   private final float[] sqz;
   private final float[] sra;
   private final float[] srb;
   private final float[] src;
   private final float[] srd;
   private final float[] sre;
   private final boolean[] srf;
   private final boolean[] srg;
   private final float srh;
   private final float sri;
   private final float srj;
   private final float srk;
   private final float srl;
   private final float srm;
   private final Random srn;
   private float sro;
   private int srp = 1;
   private boolean srq;
   private boolean srr;
   private float srs;
   private float srt;
   private float sru;
   private float srv;
   private float srw = 1.0F;
   private float srx = 1.0F;
   private float sry;
   private float srz;
   private float ssa;

   private sql(spo var1, double var2, double var4, double var6, double var8, double var10, float var12, boolean var13, int var14, Random var15) {
      this.x = var2;
      this.y = var4;
      this.z = var6;
      this.totem = var13;
      this.red = (var14 >> 16 & 0xFF) / 255.0F;
      this.green = (var14 >> 8 & 0xFF) / 255.0F;
      this.blue = (var14 & 0xFF) / 255.0F;
      this.srm = var12;
      this.srn = var15;
      this.sqq = var1.shards;
      this.sqr = var1.vertices;
      this.sqs = var1.start;
      this.sqt = var1.count;
      this.squ = var1.center;
      this.sqv = var1.pos;
      this.sqw = var1.nrm;
      this.sqx = var1.code;
      this.sqy = new float[this.sqq * 3];
      this.sqz = new float[this.sqq * 3];
      this.sra = new float[this.sqq * 4];
      this.srb = new float[this.sqq * 3];
      this.src = new float[this.sqq];
      this.srd = new float[this.sqq];
      this.sre = new float[this.sqq];
      this.srf = new boolean[this.sqq];
      this.srg = new boolean[this.sqq];
      float var16 = 0.0F;
      float var17 = 0.0F;
      float var18 = 0.0F;
      float var19 = Float.MAX_VALUE;
      float var20 = -Float.MAX_VALUE;

      for (int var21 = 0; var21 < this.sqq; var21++) {
         var16 += this.squ[var21 * 3];
         var17 += this.squ[var21 * 3 + 1];
         var18 += this.squ[var21 * 3 + 2];
      }

      for (int var47 = 0; var47 < this.sqr; var47++) {
         int var22 = this.ssf(var47);
         float var23 = this.squ[var22 * 3 + 1] + this.sqv[var47 * 3 + 1];
         var19 = Math.min(var19, var23);
         var20 = Math.max(var20, var23);
      }

      this.srh = var16 / Math.max(1, this.sqq);
      this.sri = var17 / Math.max(1, this.sqq);
      this.srj = var18 / Math.max(1, this.sqq);
      this.srk = this.sqr > 0 ? var19 : 0.0F;
      this.srl = this.sqr > 0 ? var20 : 1.8F;
      float var48 = (float)(var8 - var2) - this.srh;
      float var50 = (float)(var10 - var6) - this.srj;
      float var52 = (float)Math.sqrt(var48 * var48 + var50 * var50);
      if (var52 < 0.001F) {
         var48 = 0.0F;
         var50 = 1.0F;
      } else {
         var48 /= var52;
         var50 /= var52;
      }

      float var24 = this.srh + var48 * 0.3F;
      float var25 = this.sri + 0.15F;
      float var26 = this.srj + var50 * 0.3F;
      float var27 = -var48;
      float var28 = -var50;
      float var29 = 0.001F;

      for (int var30 = 0; var30 < this.sqq; var30++) {
         float var31 = this.squ[var30 * 3] - var24;
         float var32 = this.squ[var30 * 3 + 1] - var25;
         float var33 = this.squ[var30 * 3 + 2] - var26;
         this.sre[var30] = (float)Math.sqrt(var31 * var31 + var32 * var32 + var33 * var33);
         var29 = Math.max(var29, this.sre[var30]);
      }

      for (int var53 = 0; var53 < this.sqq; var53++) {
         int var54 = var53 * 3;
         float var55 = this.sre[var53] / var29;
         this.sre[var53] = var55;
         this.srd[var53] = var55 * 0.22F + var15.nextFloat() * 0.04F;
         this.sra[var53 * 4 + 3] = 1.0F;
         float var56 = var15.nextFloat() * 2.0F - 1.0F;
         float var34 = var15.nextFloat() * 2.0F - 1.0F;
         float var35 = var15.nextFloat() * 2.0F - 1.0F;
         float var36 = (float)Math.sqrt(var56 * var56 + var34 * var34 + var35 * var35);
         if (var36 < 0.001F) {
            var56 = 0.0F;
            var34 = 1.0F;
            var35 = 0.0F;
            var36 = 1.0F;
         }

         this.srb[var54] = var56 / var36;
         this.srb[var54 + 1] = var34 / var36;
         this.srb[var54 + 2] = var35 / var36;
         float var37 = this.squ[var54] - var24;
         float var38 = this.squ[var54 + 1] - var25;
         float var39 = this.squ[var54 + 2] - var26;
         float var40 = Math.max(0.001F, (float)Math.sqrt(var37 * var37 + var38 * var38 + var39 * var39));
         var37 /= var40;
         var38 /= var40;
         var39 /= var40;
         float var41 = this.squ[var54] - this.srh;
         float var42 = this.squ[var54 + 2] - this.srj;
         float var43 = (float)Math.sqrt(var41 * var41 + var42 * var42);
         if (var43 < 0.001F) {
            double var44 = var15.nextDouble() * Math.PI * 2.0;
            var41 = (float)Math.cos(var44);
            var42 = (float)Math.sin(var44);
         } else {
            var41 /= var43;
            var42 /= var43;
         }

         if (var13) {
            this.srf[var53] = var55 < 0.16F && var15.nextFloat() < 0.85F;
            float var62 = this.ssg(0.4F, 1.1F);
            float var45 = this.ssg(0.1F, 0.4F);
            this.sqz[var54] = var37 * var62 + var27 * var45;
            this.sqz[var54 + 1] = var38 * var62 + this.ssg(0.3F, 1.0F);
            this.sqz[var54 + 2] = var39 * var62 + var28 * var45;
            this.src[var53] = this.ssg(2.0F, 7.0F);
         } else {
            this.srf[var53] = true;
            float var63 = this.ssg(0.6F, 1.8F);
            float var64 = this.ssg(1.1F, 2.6F) * (1.25F - var55);
            float var46 = this.ssg(0.4F, 1.2F);
            this.sqz[var54] = var41 * var63 + var37 * var64 + var27 * var46;
            this.sqz[var54 + 1] = var38 * var64 + this.ssg(1.2F, 3.2F);
            this.sqz[var54 + 2] = var42 * var63 + var39 * var64 + var28 * var46;
            this.src[var53] = this.ssg(5.0F, 15.0F);
         }
      }

      this.update(0.0F);
   }

   public static sql create(
      MinecraftClient var0,
      @Nullable LivingEntity var1,
      double var2,
      double var4,
      double var6,
      float var8,
      float var9,
      boolean var10,
      boolean var11,
      boolean var12,
      int var13,
      float var14
   ) {
      Random var15 = new Random();
      double[] var16 = new double[]{var2, var4, var6};
      List var17 = var1 != null ? ssj.capture(var0, var1, var14, var16) : null;
      if (var17 == null) {
         var16[0] = var2;
         var16[1] = var4;
         var16[2] = var6;
         float var18 = var10 ? 1.0F : Math.max(0.4F, Math.min(1.6F, var9 / 1.8F));
         var17 = ssj.steve(var8, var18);
      }

      spo var21 = spo.build(var17, var12, var15);
      Vec3d var19 = var0.player != null ? var0.player.getEyePos() : new Vec3d(var16[0], var16[1] + 1.6, var16[2] + 3.0);
      float var20 = ssd(var0.world, var16[0], var16[1], var16[2]);
      return new sql(var21, var16[0], var16[1], var16[2], var19.x, var19.z, var20, var11, var13, var15);
   }

   private static float ssd(@Nullable ClientWorld var0, double var1, double var3, double var5) {
      if (var0 == null) {
         return 0.0F;
      }

      Mutable var7 = new Mutable();
      int var8 = MathHelper.floor(var1);
      int var9 = MathHelper.floor(var5);
      int var10 = MathHelper.floor(var3 + 0.5);

      for (int var11 = var10; var11 > var10 - 10; var11--) {
         var7.set(var8, var11, var9);
         VoxelShape var12 = var0.getBlockState(var7).getCollisionShape(var0, var7);
         if (!var12.isEmpty()) {
            double var13 = var11 + var12.getMax(Axis.Y);
            if (var13 <= var3 + 0.6) {
               return (float)(var13 - var3);
            }
         }
      }

      return -10.0F;
   }

   public boolean update(float var1) {
      this.sro += var1;
      float var2 = this.sro;
      this.srs = var2 < 0.38F ? this.srk - 0.05F + var2 / 0.38F * (this.srl - this.srk + 0.15F) : 10000.0F;
      this.sru = var2 < 0.38F ? 0.25F : (float)Math.exp(-(var2 - 0.38F) * 5.0F);
      this.srt = var2 > 0.55F && var2 < 1.1F ? this.srl + 0.15F - (var2 - 0.55F) / 0.55F * (this.srl - this.srk + 0.5F) : -10000.0F;
      this.srv = var2 < 1.3F ? ssi(0.72F, 1.26F, var2) * 1.12F : 2.0F;
      if (!this.srq && var2 >= 0.72F) {
         this.srq = true;
         this.srp |= 2;
      }

      if (!this.srr && var2 >= 1.3F) {
         this.srr = true;
         this.srp |= 4;
      }

      this.srx = 1.025F + (var2 < 0.38F ? 0.05F : 0.05F * (float)Math.exp(-(var2 - 0.38F) * 7.0F));
      this.sry = ssi(0.38F, 1.3F, var2) * 0.09F;
      float var3 = ssi(0.95F, 1.3F, var2) * (this.srr && this.totem ? 0.0F : 0.014F);
      this.srz = (this.srn.nextFloat() - 0.5F) * var3;
      this.ssa = (this.srn.nextFloat() - 0.5F) * var3;
      if (this.totem) {
         float var4 = ssi(1.8F, 2.45F, var2);
         this.srw = 1.0F - var4;
         this.srx *= 1.0F + 0.06F * var4;
         this.sry += var4 * 0.12F;
      }

      for (int var7 = 0; var7 < this.sqq; var7++) {
         if (this.srf[var7] && !(var2 < 1.3F + this.srd[var7])) {
            int var5 = var7 * 3;
            if (!this.srg[var7]) {
               this.srg[var7] = true;
               this.sqy[var5] = this.srh + (this.squ[var5] - this.srh) * this.srx + this.srz;
               this.sqy[var5 + 1] = this.sri + (this.squ[var5 + 1] - this.sri) * this.srx + this.sry;
               this.sqy[var5 + 2] = this.srj + (this.squ[var5 + 2] - this.srj) * this.srx + this.ssa;
            }

            this.sqz[var5 + 1] = this.sqz[var5 + 1] - 15.0F * var1;
            float var6 = (float)Math.pow(0.7, var1);
            this.sqz[var5] = this.sqz[var5] * var6;
            this.sqz[var5 + 1] = this.sqz[var5 + 1] * var6;
            this.sqz[var5 + 2] = this.sqz[var5 + 2] * var6;
            this.sqy[var5] = this.sqy[var5] + this.sqz[var5] * var1;
            this.sqy[var5 + 1] = this.sqy[var5 + 1] + this.sqz[var5 + 1] * var1;
            this.sqy[var5 + 2] = this.sqy[var5 + 2] + this.sqz[var5 + 2] * var1;
            if (this.sqy[var5 + 1] < this.srm + 0.02F) {
               this.sqy[var5 + 1] = this.srm + 0.02F;
               if (this.sqz[var5 + 1] < 0.0F) {
                  this.sqz[var5 + 1] = this.sqz[var5 + 1] * -0.28F;
                  this.sqz[var5] = this.sqz[var5] * 0.5F;
                  this.sqz[var5 + 2] = this.sqz[var5 + 2] * 0.5F;
                  this.src[var7] = this.src[var7] * 0.5F;
               }
            }

            this.sse(var7, this.src[var7] * var1);
         }
      }

      return this.totem ? var2 < 2.5F : var2 < 4.0F;
   }

   private void sse(int var1, float var2) {
      if (var2 != 0.0F) {
         int var3 = var1 * 3;
         int var4 = var1 * 4;
         float var5 = var2 * 0.5F;
         float var6 = (float)Math.sin(var5);
         float var7 = (float)Math.cos(var5);
         float var8 = this.srb[var3] * var6;
         float var9 = this.srb[var3 + 1] * var6;
         float var10 = this.srb[var3 + 2] * var6;
         float var11 = this.sra[var4];
         float var12 = this.sra[var4 + 1];
         float var13 = this.sra[var4 + 2];
         float var14 = this.sra[var4 + 3];
         float var15 = var7 * var11 + var8 * var14 + var9 * var13 - var10 * var12;
         float var16 = var7 * var12 - var8 * var13 + var9 * var14 + var10 * var11;
         float var17 = var7 * var13 + var8 * var12 - var9 * var11 + var10 * var14;
         float var18 = var7 * var14 - var8 * var11 - var9 * var12 - var10 * var13;
         float var19 = (float)Math.sqrt(var15 * var15 + var16 * var16 + var17 * var17 + var18 * var18);
         this.sra[var4] = var15 / var19;
         this.sra[var4 + 1] = var16 / var19;
         this.sra[var4 + 2] = var17 / var19;
         this.sra[var4 + 3] = var18 / var19;
      }
   }

   public int write(ByteBuffer var1, double var2, double var4, double var6) {
      float var8 = (float)(this.x - var2);
      float var9 = (float)(this.y - var4);
      float var10 = (float)(this.z - var6);
      int var11 = 0;

      for (int var12 = 0; var12 < this.sqq; var12++) {
         int var13 = var12 * 3;
         float var17 = this.srx;
         float var18 = 1.0F;
         boolean var19 = this.srg[var12];
         float var14;
         float var15;
         float var16;
         if (var19) {
            float var20 = this.sro - 1.3F - this.srd[var12];
            var18 = this.totem ? 1.0F - ssi(0.5F, 1.1F, var20) : 1.0F - ssi(1.2F, 2.1F, var20);
            if (var18 <= 0.004F) {
               continue;
            }

            var17 = this.srx * (0.3F + 0.7F * var18);
            var14 = this.sqy[var13];
            var15 = this.sqy[var13 + 1];
            var16 = this.sqy[var13 + 2];
         } else {
            var14 = this.srh + (this.squ[var13] - this.srh) * this.srx + this.srz;
            var15 = this.sri + (this.squ[var13 + 1] - this.sri) * this.srx + this.sry;
            var16 = this.srj + (this.squ[var13 + 2] - this.srj) * this.srx + this.ssa;
         }

         float var41 = ssi(this.sre[var12] - 0.1F, this.sre[var12], this.srv);
         float var21 = this.sra[var12 * 4];
         float var22 = this.sra[var12 * 4 + 1];
         float var23 = this.sra[var12 * 4 + 2];
         float var24 = this.sra[var12 * 4 + 3];
         int var25 = this.sqs[var12];
         int var26 = var25 + this.sqt[var12];

         for (int var27 = var25; var27 < var26; var27++) {
            int var28 = var27 * 3;
            float var29 = this.sqv[var28] * var17;
            float var30 = this.sqv[var28 + 1] * var17;
            float var31 = this.sqv[var28 + 2] * var17;
            float var32 = this.sqw[var28];
            float var33 = this.sqw[var28 + 1];
            float var34 = this.sqw[var28 + 2];
            if (var19) {
               float var35 = 2.0F * (var22 * var31 - var23 * var30);
               float var36 = 2.0F * (var23 * var29 - var21 * var31);
               float var37 = 2.0F * (var21 * var30 - var22 * var29);
               float var38 = var29 + var24 * var35 + (var22 * var37 - var23 * var36);
               float var39 = var30 + var24 * var36 + (var23 * var35 - var21 * var37);
               float var40 = var31 + var24 * var37 + (var21 * var36 - var22 * var35);
               var29 = var38;
               var30 = var39;
               var31 = var40;
               var35 = 2.0F * (var22 * var34 - var23 * var33);
               var36 = 2.0F * (var23 * var32 - var21 * var34);
               var37 = 2.0F * (var21 * var33 - var22 * var32);
               var38 = var32 + var24 * var35 + (var22 * var37 - var23 * var36);
               var39 = var33 + var24 * var36 + (var23 * var35 - var21 * var37);
               var40 = var34 + var24 * var37 + (var21 * var36 - var22 * var35);
               var32 = var38;
               var33 = var39;
               var34 = var40;
            }

            var1.putFloat(var8 + var14 + var29);
            var1.putFloat(var9 + var15 + var30);
            var1.putFloat(var10 + var16 + var31);
            var1.putInt(this.sqx[var27]);
            var1.putFloat(var41);
            var1.putFloat(var18);
            var1.put(ssh(var32));
            var1.put(ssh(var33));
            var1.put(ssh(var34));
            var1.put((byte)0);
            var11++;
         }
      }

      return var11;
   }

   public boolean sample(Random var1, double[] var2) {
      for (int var3 = 0; var3 < 6; var3++) {
         int var4 = var1.nextInt(Math.max(1, this.sqq));
         if (var4 < this.sqq && this.srg[var4]) {
            int var5 = var4 * 3;
            var2[0] = this.x + this.sqy[var5];
            var2[1] = this.y + this.sqy[var5 + 1];
            var2[2] = this.z + this.sqy[var5 + 2];
            var2[3] = this.sqz[var5];
            var2[4] = this.sqz[var5 + 1];
            var2[5] = this.sqz[var5 + 2];
            return true;
         }
      }

      return false;
   }

   public int takeEvents() {
      int var1 = this.srp;
      this.srp = 0;
      return var1;
   }

   public int vertices() {
      return this.sqr;
   }

   public double centerX() {
      return this.x + this.srh;
   }

   public double centerY() {
      return this.y + this.sri;
   }

   public double centerZ() {
      return this.z + this.srj;
   }

   public float scan() {
      return this.srs;
   }

   public float sweep() {
      return this.srt;
   }

   public float flash() {
      return this.sru;
   }

   public float broken() {
      return !this.totem && this.srr ? 1.0F : 0.0F;
   }

   public float alpha() {
      return this.srw;
   }

   private int ssf(int var1) {
      int var2 = 0;
      int var3 = this.sqq - 1;

      while (var2 < var3) {
         int var4 = var2 + var3 + 1 >>> 1;
         if (this.sqs[var4] <= var1) {
            var2 = var4;
         } else {
            var3 = var4 - 1;
         }
      }

      return var2;
   }

   private float ssg(float var1, float var2) {
      return var1 + (var2 - var1) * this.srn.nextFloat();
   }

   private static byte ssh(float var0) {
      return (byte)Math.round(Math.max(-1.0F, Math.min(1.0F, var0)) * 127.0F);
   }

   private static float ssi(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }
}
