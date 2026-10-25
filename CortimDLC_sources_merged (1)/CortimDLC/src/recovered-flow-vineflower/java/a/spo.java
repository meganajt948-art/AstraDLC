package a;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.joml.Vector3f;

final class spo {
   private static final float spp = 0.0625F;
   int shards;
   int vertices;
   int[] start = new int[256];
   int[] count = new int[256];
   float[] center = new float[768];
   float[] pos = new float[24576];
   float[] nrm = new float[24576];
   int[] code = new int[8192];
   private final Random spq;
   private final float[] spr = new float[3];
   private final Vector3f sps = new Vector3f();
   private spg spt;
   private int spu;

   private spo(Random var1) {
      this.spq = var1;
   }

   static spo build(List<spg> var0, boolean var1, Random var2) {
      spo var3 = new spo(var2);
      if (var1) {
         double var4 = 0.0;

         for (spg var7 : var0) {
            var4 += 8.0 * var7.hx() * var7.hy() * var7.hz();
         }

         float var10 = sqk((float)Math.cbrt(var4 / 260.0), 0.1125F, 0.375F);

         for (spg var8 : var0) {
            var3.sqb(var8, var10);
         }
      } else {
         double var9 = 0.0;

         for (spg var14 : var0) {
            var9 += 8.0 * (var14.hx() * var14.hy() + var14.hy() * var14.hz() + var14.hx() * var14.hz());
         }

         float var12 = sqk((float)Math.sqrt(2.0 * var9 / 620.0), 0.1375F, 0.375F);

         for (spg var16 : var0) {
            var3.spy(var16, var12, 0.046875F);
         }
      }

      return var3;
   }

   private void spx(spg var1) {
      this.spt = var1;
      this.spr[0] = var1.hx();
      this.spr[1] = var1.hy();
      this.spr[2] = var1.hz();
   }

   private void spy(spg var1, float var2, float var3) {
      this.spx(var1);

      for (int var4 = 0; var4 < 3; var4++) {
         for (byte var5 = 1; var5 >= -1; var5 -= 2) {
            int var6 = (var4 + 1) % 3;
            int var7 = (var4 + 2) % 3;
            int var8 = Math.max(1, Math.round(2.0F * this.spr[var6] / var2));
            int var9 = Math.max(1, Math.round(2.0F * this.spr[var7] / var2));
            float[][][] var10 = new float[var8 + 1][var9 + 1][];

            for (int var11 = 0; var11 <= var8; var11++) {
               for (int var12 = 0; var12 <= var9; var12++) {
                  float var13 = -this.spr[var6] + 2.0F * this.spr[var6] * var11 / var8;
                  float var14 = -this.spr[var7] + 2.0F * this.spr[var7] * var12 / var9;
                  if (var11 > 0 && var11 < var8) {
                     var13 += (this.spq.nextFloat() - 0.5F) * 1.5F * this.spr[var6] / var8;
                  }

                  if (var12 > 0 && var12 < var9) {
                     var14 += (this.spq.nextFloat() - 0.5F) * 1.5F * this.spr[var7] / var9;
                  }

                  float[] var15 = new float[3];
                  var15[var4] = var5 * this.spr[var4];
                  var15[var6] = var13;
                  var15[var7] = var14;
                  var10[var11][var12] = var15;
               }
            }

            float[] var18 = new float[3];
            var18[var4] = var5;

            for (int var19 = 0; var19 < var8; var19++) {
               for (int var20 = 0; var20 < var9; var20++) {
                  float[] var21 = var10[var19][var20];
                  float[] var22 = var10[var19 + 1][var20];
                  float[] var16 = var10[var19 + 1][var20 + 1];
                  float[] var17 = var10[var19][var20 + 1];
                  if (this.spq.nextBoolean()) {
                     this.spz(var21, var22, var16, var18, var3);
                     this.spz(var21, var16, var17, var18, var3);
                  } else {
                     this.spz(var21, var22, var17, var18, var3);
                     this.spz(var22, var16, var17, var18, var3);
                  }
               }
            }
         }
      }
   }

   private void spz(float[] var1, float[] var2, float[] var3, float[] var4, float var5) {
      float[] var6 = sqf(var1, var4, var5);
      float[] var7 = sqf(var2, var4, var5);
      float[] var8 = sqf(var3, var4, var5);
      float var9 = (var1[0] + var2[0] + var3[0]) / 3.0F;
      float var10 = (var1[1] + var2[1] + var3[1]) / 3.0F;
      float var11 = (var1[2] + var2[2] + var3[2]) / 3.0F;
      this.sqg();
      this.sqi(var1, var2, var3, var4[0], var4[1], var4[2], this.sqe(var2, var3), this.sqe(var3, var1), this.sqe(var1, var2), 0);
      this.sqi(var6, var8, var7, -var4[0], -var4[1], -var4[2], 2, 2, 2, 1);
      this.sqa(var1, var2, var6, var7, var4, var9, var10, var11);
      this.sqa(var2, var3, var7, var8, var4, var9, var10, var11);
      this.sqa(var3, var1, var8, var6, var4, var9, var10, var11);
      this.sqh();
   }

   private void sqa(float[] var1, float[] var2, float[] var3, float[] var4, float[] var5, float var6, float var7, float var8) {
      float var9 = var2[0] - var1[0];
      float var10 = var2[1] - var1[1];
      float var11 = var2[2] - var1[2];
      float var12 = var10 * var5[2] - var11 * var5[1];
      float var13 = var11 * var5[0] - var9 * var5[2];
      float var14 = var9 * var5[1] - var10 * var5[0];
      if (var12 * (var1[0] - var6) + var13 * (var1[1] - var7) + var14 * (var1[2] - var8) < 0.0F) {
         var12 = -var12;
         var13 = -var13;
         var14 = -var14;
      }

      float var15 = (float)Math.sqrt(var12 * var12 + var13 * var13 + var14 * var14);
      if (!(var15 < 1.0E-7F)) {
         var12 /= var15;
         var13 /= var15;
         var14 /= var15;
         this.sqi(var1, var2, var4, var12, var13, var14, 0, 2, 0, 1);
         this.sqi(var1, var4, var3, var12, var13, var14, 0, 0, 2, 1);
      }
   }

   private void sqb(spg var1, float var2) {
      this.spx(var1);
      int[] var3 = new int[3];

      for (int var4 = 0; var4 < 3; var4++) {
         var3[var4] = Math.max(1, Math.round(2.0F * this.spr[var4] / var2));
      }

      int[] var23 = new int[3];
      float[] var5 = new float[3];
      float[] var6 = new float[3];

      for (int var7 = 0; var7 < var3[0]; var7++) {
         for (int var8 = 0; var8 < var3[1]; var8++) {
            for (int var9 = 0; var9 < var3[2]; var9++) {
               var23[0] = var7;
               var23[1] = var8;
               var23[2] = var9;

               for (int var10 = 0; var10 < 3; var10++) {
                  var5[var10] = -this.spr[var10] + 2.0F * this.spr[var10] * var23[var10] / var3[var10];
                  var6[var10] = -this.spr[var10] + 2.0F * this.spr[var10] * (var23[var10] + 1) / var3[var10];
               }

               this.sqg();

               for (int var24 = 0; var24 < 3; var24++) {
                  for (byte var11 = 1; var11 >= -1; var11 -= 2) {
                     int var12 = (var24 + 1) % 3;
                     int var13 = (var24 + 2) % 3;
                     boolean var14 = var11 > 0 ? var23[var24] == var3[var24] - 1 : var23[var24] == 0;
                     float[] var15 = sqc(var24, var11, var12, var13, var5, var6, false, false);
                     float[] var16 = sqc(var24, var11, var12, var13, var5, var6, true, false);
                     float[] var17 = sqc(var24, var11, var12, var13, var5, var6, true, true);
                     float[] var18 = sqc(var24, var11, var12, var13, var5, var6, false, true);
                     float var19 = var24 == 0 ? var11 : 0.0F;
                     float var20 = var24 == 1 ? var11 : 0.0F;
                     float var21 = var24 == 2 ? var11 : 0.0F;
                     int var22 = var14 ? 0 : 1;
                     this.sqi(var15, var16, var17, var19, var20, var21, this.sqd(var14, var16, var17), 2, this.sqd(var14, var15, var16), var22);
                     this.sqi(var15, var17, var18, var19, var20, var21, this.sqd(var14, var17, var18), this.sqd(var14, var18, var15), 2, var22);
                  }
               }

               this.sqh();
            }
         }
      }
   }

   private static float[] sqc(int var0, int var1, int var2, int var3, float[] var4, float[] var5, boolean var6, boolean var7) {
      float[] var8 = new float[3];
      var8[var0] = var1 > 0 ? var5[var0] : var4[var0];
      var8[var2] = var6 ? var5[var2] : var4[var2];
      var8[var3] = var7 ? var5[var3] : var4[var3];
      return var8;
   }

   private int sqd(boolean var1, float[] var2, float[] var3) {
      return var1 ? this.sqe(var2, var3) : 0;
   }

   private int sqe(float[] var1, float[] var2) {
      int var3 = 0;

      for (int var4 = 0; var4 < 3; var4++) {
         if (Math.abs(Math.abs(var1[var4]) - this.spr[var4]) < 1.0E-5F
            && Math.abs(Math.abs(var2[var4]) - this.spr[var4]) < 1.0E-5F
            && var1[var4] > 0.0F == var2[var4] > 0.0F) {
            var3++;
         }
      }

      return var3 >= 2 ? 1 : 0;
   }

   private static float[] sqf(float[] var0, float[] var1, float var2) {
      return new float[]{var0[0] - var1[0] * var2, var0[1] - var1[1] * var2, var0[2] - var1[2] * var2};
   }

   private void sqg() {
      if (this.shards + 1 > this.start.length) {
         int var1 = this.start.length * 2;
         this.start = Arrays.copyOf(this.start, var1);
         this.count = Arrays.copyOf(this.count, var1);
         this.center = Arrays.copyOf(this.center, var1 * 3);
      }

      this.spu = this.vertices;
   }

   private void sqh() {
      int var1 = this.vertices - this.spu;
      if (var1 > 0) {
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;

         for (int var5 = this.spu; var5 < this.vertices; var5++) {
            var2 += this.pos[var5 * 3];
            var3 += this.pos[var5 * 3 + 1];
            var4 += this.pos[var5 * 3 + 2];
         }

         var2 /= var1;
         var3 /= var1;
         var4 /= var1;

         for (int var9 = this.spu; var9 < this.vertices; var9++) {
            this.pos[var9 * 3] = this.pos[var9 * 3] - var2;
            this.pos[var9 * 3 + 1] = this.pos[var9 * 3 + 1] - var3;
            this.pos[var9 * 3 + 2] = this.pos[var9 * 3 + 2] - var4;
         }

         this.start[this.shards] = this.spu;
         this.count[this.shards] = var1;
         this.center[this.shards * 3] = var2;
         this.center[this.shards * 3 + 1] = var3;
         this.center[this.shards * 3 + 2] = var4;
         this.shards++;
      }
   }

   private void sqi(float[] var1, float[] var2, float[] var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10) {
      if (this.vertices + 3 > this.code.length) {
         int var11 = this.code.length * 2;
         this.code = Arrays.copyOf(this.code, var11);
         this.pos = Arrays.copyOf(this.pos, var11 * 3);
         this.nrm = Arrays.copyOf(this.nrm, var11 * 3);
      }

      this.sps.set(var4, var5, var6);
      this.spt.normals().transform(this.sps);
      this.sps.normalize();
      float var15 = this.sps.x;
      float var12 = this.sps.y;
      float var13 = this.sps.z;
      int var14 = var7 + var8 * 3 + var9 * 9 + var10 * 27 << 24;
      this.sqj(var1, var15, var12, var13, 0xFF | var14);
      this.sqj(var2, var15, var12, var13, 0xFF00 | var14);
      this.sqj(var3, var15, var12, var13, 0xFF0000 | var14);
   }

   private void sqj(float[] var1, float var2, float var3, float var4, int var5) {
      this.sps.set(var1[0], var1[1], var1[2]);
      this.spt.matrix().transformPosition(this.sps);
      int var6 = this.vertices * 3;
      this.pos[var6] = this.sps.x;
      this.pos[var6 + 1] = this.sps.y;
      this.pos[var6 + 2] = this.sps.z;
      this.nrm[var6] = var2;
      this.nrm[var6 + 1] = var3;
      this.nrm[var6 + 2] = var4;
      this.code[this.vertices] = var5;
      this.vertices++;
   }

   private static float sqk(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }
}
