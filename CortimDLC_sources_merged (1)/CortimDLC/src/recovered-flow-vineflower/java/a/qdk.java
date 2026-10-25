package a;

import java.util.Arrays;
import java.util.function.IntPredicate;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

final class qdk {
   final int x0;
   final int z0;
   final int w;
   final int d;
   final int y;
   final boolean[] open;
   final int start;

   qdk(qdz var1, World var2, ClientPlayerEntity var3, int var4) {
      this.y = var4;
      this.x0 = var1.qfg.minX - 4;
      this.z0 = var1.qfg.minZ - 4;
      this.w = var1.qfg.maxX - var1.qfg.minX + 9;
      this.d = var1.qfg.maxZ - var1.qfg.minZ + 9;
      this.open = new boolean[this.w * this.d];
      Mutable var5 = new Mutable();

      for (int var6 = 0; var6 < this.w; var6++) {
         for (int var7 = 0; var7 < this.d; var7++) {
            int var8 = this.x0 + var6;
            int var9 = this.z0 + var7;
            this.open[var6 * this.d + var7] = qdz.qjs(var2, var5.set(var8, var4, var9))
               && qdz.qjs(var2, var5.set(var8, var4 + 1, var9))
               && !qdz.qjs(var2, var5.set(var8, var4 - 1, var9));
         }
      }

      BlockPos var10 = qdz.standing(var2, var3);
      int var11 = var10.getX() - this.x0;
      int var12 = var10.getZ() - this.z0;
      this.start = var11 >= 0 && var12 >= 0 && var11 < this.w && var12 < this.d ? var11 * this.d + var12 : -1;
      if (this.start >= 0) {
         this.open[this.start] = true;
      }
   }

   int index(int var1, int var2) {
      int var3 = var1 - this.x0;
      int var4 = var2 - this.z0;
      return var3 >= 0 && var4 >= 0 && var3 < this.w && var4 < this.d ? var3 * this.d + var4 : -1;
   }

   int cellX(int var1) {
      return this.x0 + var1 / this.d;
   }

   int cellZ(int var1) {
      return this.z0 + var1 % this.d;
   }

   int[] path(IntPredicate var1) {
      if (this.start < 0) {
         return null;
      }

      int[] var2 = new int[this.w * this.d];
      Arrays.fill(var2, -2);
      int[] var3 = new int[this.w * this.d];
      int var4 = 0;
      int var5 = 0;
      var3[var5++] = this.start;
      var2[this.start] = -1;
      int var6 = -1;

      while (var4 < var5) {
         int var7 = var3[var4++];
         if (var1.test(var7)) {
            var6 = var7;
            break;
         }

         int var8 = var7 / this.d;
         int var9 = var7 % this.d;

         for (int[] var13 : qdz.qhw) {
            int var14 = var8 + var13[0];
            int var15 = var9 + var13[1];
            if (var14 >= 0 && var15 >= 0 && var14 < this.w && var15 < this.d) {
               int var16 = var14 * this.d + var15;
               if (var2[var16] == -2
                  && this.open[var16]
                  && (var13[0] == 0 || var13[1] == 0 || this.open[var14 * this.d + var9] && this.open[var8 * this.d + var15])) {
                  var2[var16] = var7;
                  var3[var5++] = var16;
               }
            }
         }
      }

      if (var6 < 0) {
         return null;
      }

      int var18 = 0;

      for (int var19 = var6; var19 != -1; var19 = var2[var19]) {
         var18++;
      }

      int[] var20 = new int[var18];
      int var21 = var6;

      for (int var22 = var18 - 1; var21 != -1; var22--) {
         var20[var22] = var21;
         var21 = var2[var21];
      }

      return var20;
   }

   Vec3d waypoint(ClientPlayerEntity var1, int[] var2) {
      int var3 = Math.min(1, var2.length - 1);

      for (int var4 = Math.min(4, var2.length - 1); var4 > var3; var4--) {
         if (this.qdn(var1.getX(), var1.getZ(), this.cellX(var2[var4]) + 0.5, this.cellZ(var2[var4]) + 0.5)) {
            var3 = var4;
            break;
         }
      }

      return new Vec3d(this.cellX(var2[var3]) + 0.5, this.y, this.cellZ(var2[var3]) + 0.5);
   }

   boolean qdn(double var1, double var3, double var5, double var7) {
      double var9 = Math.hypot(var5 - var1, var7 - var3);
      int var11 = Math.max(1, (int)Math.ceil(var9 / 0.25));

      for (int var12 = 1; var12 <= var11; var12++) {
         double var13 = (double)var12 / var11;
         double var15 = var1 + (var5 - var1) * var13;
         double var17 = var3 + (var7 - var3) * var13;

         for (double var19 = -0.3; var19 <= 0.3; var19 += 0.6) {
            for (double var21 = -0.3; var21 <= 0.3; var21 += 0.6) {
               int var23 = this.index(MathHelper.floor(var15 + var19), MathHelper.floor(var17 + var21));
               if (var23 < 0 || !this.open[var23]) {
                  return false;
               }
            }
         }
      }

      return true;
   }
}
