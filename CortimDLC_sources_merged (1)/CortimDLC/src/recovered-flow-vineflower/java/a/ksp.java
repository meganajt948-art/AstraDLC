package a;

import java.util.List;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

final class ksp {
   static final int HORIZON = 20;
   static final double SMASH_FALL = 1.52;
   private static final int ksq = 2;
   private static final int ksr = 22;
   private final boolean[] kss = new boolean[22];
   private final boolean[] kst = new boolean[22];
   private final double[] ksu = new double[22];
   private final double[] ksv = new double[22];
   private final double[] ksw = new double[22];
   private final double[] ksx = new double[22];

   void predict(ClientPlayerEntity var1, World var2, boolean var3, int var4, boolean var5, double var6) {
      Box var8 = var1.method_5829();
      boolean var9 = var1.method_24828();
      double var10 = var6;
      double var12 = var1.method_18798().field_1351;
      double var14 = var1.method_23317() - var1.field_6014;
      double var16 = var1.method_23321() - var1.field_5969;
      if (var9 && var1.method_5715()) {
         var14 = 0.0;
         var16 = 0.0;
      }

      double var18 = var1.method_56989();
      float var20 = jumpVelocity(var1, var2);
      int var21 = var5 ? 0 : var4;
      double var22 = 0.0;
      double var24 = 0.0;
      double var26 = 0.0;

      for (int var28 = 0; var28 < 22; var28++) {
         this.kss[var28] = var10 > 0.0 && !var9;
         this.kst[var28] = var9;
         this.ksu[var28] = var9 ? 0.0 : var10;
         this.ksv[var28] = var22;
         this.ksw[var28] = var24;
         this.ksx[var28] = var26;
         if (var21 > 0) {
            var21--;
         }

         if (Math.abs(var12) < 0.003) {
            var12 = 0.0;
         }

         if (var3) {
            if (var9 && var21 == 0 && var20 > 1.0E-5F) {
               var12 = Math.max((double)var20, var12);
               var21 = var5 ? 0 : 10;
            }
         } else {
            var21 = 0;
         }

         Vec3d var29 = Entity.method_20736(var1, new Vec3d(var14, var12, var16), var8, var2, List.of());
         boolean var30 = var29.field_1351 != var12;
         var9 = var30 && var12 < 0.0;
         if (var29.field_1352 != var14) {
            var14 = 0.0;
         }

         if (var29.field_1350 != var16) {
            var16 = 0.0;
         }

         if (var29.field_1351 > 0.0) {
            var10 = 0.0;
         } else if (var29.field_1351 < 0.0) {
            var10 -= var29.field_1351;
         }

         if (var9) {
            var10 = 0.0;
         }

         var8 = var8.method_997(var29);
         var22 += var29.field_1352;
         var24 += var29.field_1351;
         var26 += var29.field_1350;
         if (var30) {
            var12 = 0.0;
         }

         var12 = (var12 - var18) * 0.98;
      }
   }

   boolean critAt(int var1) {
      return !this.rawCritAt(var1) ? false : !this.kta(var1) || this.ktb(var1);
   }

   private boolean kta(int var1) {
      for (int var2 = 1; var2 <= 2; var2++) {
         if (this.kst[var1 + var2]) {
            return true;
         }
      }

      return false;
   }

   private boolean ktb(int var1) {
      int var2 = var1;

      while (var2 > 0 && !this.kst[var2 - 1]) {
         var2--;
      }

      for (int var3 = var2; var3 < 20; var3++) {
         if (this.kst[var3]) {
            return true;
         }

         if (this.kss[var3] && !this.kta(var3)) {
            return false;
         }
      }

      return false;
   }

   boolean rawCritAt(int var1) {
      return var1 >= 0 && var1 < 20 && this.kss[var1];
   }

   double fallAt(int var1) {
      return var1 >= 0 && var1 < 20 ? this.ksu[var1] : 0.0;
   }

   boolean smashAt(int var1) {
      return var1 >= 0 && var1 < 20 && !this.kst[var1] && this.ksu[var1] > 1.52;
   }

   Vec3d offsetAt(int var1) {
      int var2 = Math.max(0, Math.min(19, var1));
      return new Vec3d(this.ksv[var2], this.ksw[var2], this.ksx[var2]);
   }

   static double headroom(ClientPlayerEntity var0, World var1, double var2) {
      return Entity.method_20736(var0, new Vec3d(0.0, var2, 0.0), var0.method_5829(), var1, List.of()).field_1351;
   }

   static float jumpVelocity(ClientPlayerEntity var0, World var1) {
      float var2 = var1.method_8320(var0.method_24515()).method_26204().method_23350();
      float var3 = var1.method_8320(var0.method_23314()).method_26204().method_23350();
      float var4 = var2 == 1.0F ? var3 : var2;
      return (float)var0.method_45325(EntityAttributes.field_23728) * var4 + var0.method_37416();
   }
}
