package a;

import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class lmn {
   public static final int HORIZON = 40;
   public static final double SMASH_FALL = 1.52;
   private static final int lmo = 2;
   private static final int lmp = 43;
   private final double[] lmq = new double[43];
   private final double[] lmr = new double[43];
   private final double[] lms = new double[43];
   private final double[] lmt = new double[43];
   private final boolean[] lmu = new boolean[43];
   private int lmv = 43;
   private double lmw = 1.52;
   private double lmx = Double.MAX_VALUE;

   public void threshold(double var1) {
      this.threshold(var1, Double.MAX_VALUE);
   }

   public void threshold(double var1, double var3) {
      this.lmw = Math.max(1.52, var1);
      this.lmx = Math.max(this.lmw + 0.25, var3);
   }

   public double threshold() {
      return this.lmw;
   }

   public void predict(ClientPlayerEntity var1, World var2, double var3) {
      Box var5 = var1.method_5829();
      boolean var6 = var1.method_24828();
      double var7 = var3;
      Vec3d var9 = var1.method_18798();
      double var10 = var9.field_1352;
      double var12 = var9.field_1351;
      double var14 = var9.field_1350;
      double var16 = var1.method_23320() - var1.method_23318();
      double var18 = var1.method_56989();
      double var20 = 0.0;
      double var22 = 0.0;
      double var24 = var1.field_6212;
      double var26 = var1.field_6250;
      double var28 = var24 * var24 + var26 * var26;
      if (var28 > 1.0E-7) {
         if (var28 > 1.0) {
            double var30 = Math.sqrt(var28);
            var24 /= var30;
            var26 /= var30;
         }

         double var41 = var1.method_5624() ? 0.026 : 0.02;
         float var32 = var1.method_36454() * (float) (Math.PI / 180.0);
         double var33 = MathHelper.method_15374(var32);
         double var35 = MathHelper.method_15362(var32);
         var20 = (var24 * var35 - var26 * var33) * var41;
         var22 = (var26 * var35 + var24 * var33) * var41;
      }

      double var42 = var1.method_23317();
      double var43 = var1.method_23318();
      double var34 = var1.method_23321();
      this.lmv = 43;

      for (int var36 = 0; var36 < 43; var36++) {
         this.lmq[var36] = var42;
         this.lmr[var36] = var43 + var16;
         this.lms[var36] = var34;
         this.lmu[var36] = var6;
         this.lmt[var36] = var6 ? 0.0 : var7;
         if (var6) {
            if (this.lmv == 43) {
               this.lmv = var36;
            }
         } else {
            if (Math.abs(var10) < 0.003) {
               var10 = 0.0;
            }

            if (Math.abs(var12) < 0.003) {
               var12 = 0.0;
            }

            if (Math.abs(var14) < 0.003) {
               var14 = 0.0;
            }

            var10 += var20;
            var14 += var22;
            Vec3d var37 = Entity.method_20736(var1, new Vec3d(var10, var12, var14), var5, var2, List.of());
            boolean var38 = var37.field_1351 != var12;
            var6 = var38 && var12 < 0.0;
            if (var37.field_1352 != var10) {
               var10 = 0.0;
            }

            if (var37.field_1350 != var14) {
               var14 = 0.0;
            }

            if (var37.field_1351 > 0.0) {
               var7 = 0.0;
            } else if (var37.field_1351 < 0.0) {
               var7 -= var37.field_1351;
            }

            if (var6) {
               var7 = 0.0;
            }

            var5 = var5.method_997(var37);
            var42 += var37.field_1352;
            var43 += var37.field_1351;
            var34 += var37.field_1350;
            if (var38) {
               var12 = 0.0;
            }

            var12 = (var12 - var18) * 0.98;
            var10 *= 0.91;
            var14 *= 0.91;
         }
      }
   }

   public boolean smash(int var1) {
      return var1 >= 0 && var1 < 40 && !this.lmu[var1] && this.lmt[var1] > this.lmw && this.lmt[var1] <= this.lmx;
   }

   public boolean safe(int var1) {
      if (!this.smash(var1)) {
         return false;
      } else {
         for (int var2 = 1; var2 <= 2; var2++) {
            if (this.lmu[var1 + var2]) {
               return false;
            }
         }

         return true;
      }
   }

   public Vec3d eye(int var1) {
      int var2 = MathHelper.method_15340(var1, 0, 42);
      return new Vec3d(this.lmq[var2], this.lmr[var2], this.lms[var2]);
   }

   public double fall(int var1) {
      return this.lmt[MathHelper.method_15340(var1, 0, 42)];
   }

   public int landing() {
      return this.lmv;
   }

   public Box sweep(ClientPlayerEntity var1) {
      Vec3d var2 = this.eye(39).method_1020(this.eye(0));
      return var1.method_5829().method_18804(var2);
   }

   public static boolean environment(ClientPlayerEntity var0, World var1) {
      return !var0.method_6101()
         && !var0.method_5799()
         && !var0.method_5771()
         && !var0.method_5765()
         && !var0.method_6128()
         && !var0.method_31549().field_7479
         && !var0.field_27857
         && !var0.method_6059(StatusEffects.field_5902)
         && !var0.method_6059(StatusEffects.field_5906)
         && var1.method_29546(var0.method_5829().method_1011(1.0E-7)).noneMatch(lmn::lna);
   }

   private static boolean lna(BlockState var0) {
      return var0.method_27852(Blocks.field_10343) || var0.method_27852(Blocks.field_16999) || var0.method_27852(Blocks.field_27879);
   }
}
