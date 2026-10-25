package a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

final class prw {
   final World world;
   final Entity viewer;
   final prz lim;
   final List<Double> xs = new ArrayList<>();
   final List<Double> ys = new ArrayList<>();
   final List<Double> zs = new ArrayList<>();
   final List<Byte> fs = new ArrayList<>();

   prw(World var1, Entity var2, prz var3) {
      this.world = var1;
      this.viewer = var2;
      this.lim = var3;
   }

   void add(double var1, double var3, double var5, byte var7) {
      int var8 = this.xs.size();
      if (var8 > 0 && Math.hypot(this.xs.get(var8 - 1) - var1, this.zs.get(var8 - 1) - var5) < 0.05 && Math.abs(this.ys.get(var8 - 1) - var3) < 0.3) {
         this.fs.set(var8 - 1, (byte)(this.fs.get(var8 - 1) | var7));
      } else {
         this.xs.add(var1);
         this.ys.add(var3);
         this.zs.add(var5);
         this.fs.add(var7);
      }
   }

   boolean clear(double[] var1, double[] var2, double var3) {
      double var5 = var2[0] - var1[0];
      double var7 = var2[2] - var1[2];
      double var9 = Math.hypot(var5, var7);
      int var11 = Math.max(1, (int)Math.ceil(var9 / 0.3));
      double var12 = var1[1];
      int var14 = 1;

      while (var14 <= var11) {
         double var15 = (double)var14 / var11;
         double var17 = var1[0] + var5 * var15;
         double var19 = var1[2] + var7 * var15;
         double var21 = pua.standAt(this.world, var17, var12, var19, 0.6);
         if (!Double.isNaN(var21) && !(Math.abs(var21 - var12) > 0.601)) {
            if (pua.bodyFits(this.world, this.viewer, var17, var19, var21, var3) && !pua.hazard(this.world, var17, var21, var19)) {
               if (pua.blocked(BlockPos.method_49637(var17, var21 + 0.01, var19), this.lim.danger, this.lim.radius, this.lim.avoid)) {
                  return false;
               }

               var12 = var21;
               var14++;
               continue;
            }

            return false;
         }

         return false;
      }

      return Math.abs(var12 - var2[1]) <= 0.601;
   }

   boolean fits(double var1, double var3, double var5) {
      return pua.bodyFits(this.world, this.viewer, var1, var5, var3, 0.32)
         && !pua.hazard(this.world, var1, var3, var5)
         && !pua.blocked(BlockPos.method_49637(var1, var3 + 0.01, var5), this.lim.danger, this.lim.radius, this.lim.avoid);
   }
}
