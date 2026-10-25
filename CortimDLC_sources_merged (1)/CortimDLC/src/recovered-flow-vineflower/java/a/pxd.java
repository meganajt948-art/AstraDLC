package a;

import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.floats.FloatArraySet;
import it.unimi.dsi.fastutil.floats.FloatArrays;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.CollisionView;

public final class pxd {
   private static final double pxe = 0.98F;
   private static final double pxf = 0.98F;
   private final CollisionView pxg;
   private final Entity pxh;
   private final float pxi;
   private final double pxj;
   private final double pxk;
   private final double pxl;
   private final double pxm;
   private final boolean pxn;
   private Box pxo;
   private double pxp;
   private double pxq;
   private double pxr;
   private boolean pxs;
   private double pxt;
   private double pxu;

   private pxd(CollisionView var1, Entity var2, pwx var3, boolean var4) {
      this.pxg = var1;
      this.pxh = var2;
      this.pxn = var4;
      this.pxi = var3.stepHeight;
      this.pxj = var4 ? var3.movementSpeed * 1.3 : var3.movementSpeed;
      this.pxk = var4 ? 0.025999999 : 0.02;
      this.pxl = var3.jumpVelocity;
      this.pxm = var3.gravity;
      this.pxo = var3.box;
      this.pxp = var3.vx;
      this.pxq = var3.vy;
      this.pxr = var3.vz;
      this.pxs = var3.onGround;
   }

   public static pxa run(PlayerEntity var0, float var1, boolean var2, boolean var3, int var4) {
      return run(var0.method_73183(), var0, pwx.of(var0), var1, var2, var3, var4);
   }

   public static pxa run(CollisionView var0, Entity var1, pwx var2, float var3, boolean var4, boolean var5, int var6) {
      pxd var7 = new pxd(var0, var1, var2, var4);
      double var8 = Math.toRadians(var3);
      double var10 = -Math.sin(var8);
      double var12 = Math.cos(var8);
      double var14 = var7.pxx();
      double var16 = var7.pxy();
      pxa var18 = new pxa();
      var18.startY = var7.pxo.field_1322;
      var18.maxY = var7.pxo.field_1322;
      var18.minY = var7.pxo.field_1322;

      for (int var19 = 0; var19 < var6; var19++) {
         var7.pxz(var10, var12, var5 && var19 == 0);
         if (var18.firstBlockTick < 0 && var7.pxt > 0.02 && var7.pxu < var7.pxt * 0.5) {
            var18.firstBlockTick = var19;
         }

         var18.maxY = Math.max(var18.maxY, var7.pxo.field_1322);
         var18.minY = Math.min(var18.minY, var7.pxo.field_1322);
      }

      var18.endX = var7.pxx();
      var18.endZ = var7.pxy();
      var18.progress = (var7.pxx() - var14) * var10 + (var7.pxy() - var16) * var12;
      var18.endY = var7.pxo.field_1322;
      var18.endOnGround = var7.pxs;
      return var18;
   }

   public static boolean jumpHelps(PlayerEntity var0, float var1, boolean var2, int var3) {
      return jumpHelps(var0.method_73183(), var0, pwx.of(var0), var1, var2, var3);
   }

   public static boolean jumpHelps(CollisionView var0, Entity var1, pwx var2, float var3, boolean var4, int var5) {
      pxa var6 = run(var0, var1, var2, var3, var4, false, 12);
      if (!var6.blockedWithin(var5)) {
         return false;
      } else {
         pxa var7 = run(var0, var1, var2, var3, var4, true, 12);
         return var7.progress > var6.progress + 0.5;
      }
   }

   public static boolean reaches(PlayerEntity var0, Vec3d var1, boolean var2, int var3) {
      return reaches(var0.method_73183(), var0, pwx.of(var0), var1, var2, var3);
   }

   public static boolean reaches(CollisionView var0, Entity var1, pwx var2, Vec3d var3, boolean var4, int var5) {
      pxd var6 = new pxd(var0, var1, var2, var4);
      boolean var7 = false;
      double var8 = Double.MAX_VALUE;
      int var10 = 0;

      for (int var11 = 0; var11 < var5; var11++) {
         double var12 = var3.field_1352 - var6.pxx();
         double var14 = var3.field_1350 - var6.pxy();
         double var16 = Math.hypot(var12, var14);
         if (var16 < 0.45 && var6.pxs && Math.abs(var6.pxo.field_1322 - var3.field_1351) < 0.6) {
            return true;
         }

         if (var16 < var8 - 0.05) {
            var8 = var16;
            var10 = 0;
         } else if (++var10 > 8) {
            return false;
         }

         double var18 = var16 < 1.0E-4 ? 0.0 : var12 / var16;
         double var20 = var16 < 1.0E-4 ? 0.0 : var14 / var16;
         var6.pxz(var18, var20, var7);
         var7 = var6.pxs && var6.pxt > 0.02 && var6.pxu < var6.pxt * 0.5;
      }

      return false;
   }

   private double pxx() {
      return (this.pxo.field_1323 + this.pxo.field_1320) * 0.5;
   }

   private double pxy() {
      return (this.pxo.field_1321 + this.pxo.field_1324) * 0.5;
   }

   private void pxz(double var1, double var3, boolean var5) {
      if (Math.abs(this.pxp) < 0.003) {
         this.pxp = 0.0;
      }

      if (Math.abs(this.pxq) < 0.003) {
         this.pxq = 0.0;
      }

      if (Math.abs(this.pxr) < 0.003) {
         this.pxr = 0.0;
      }

      if (var5 && this.pxs) {
         this.pxq = Math.max(this.pxl, this.pxq);
         if (this.pxn) {
            this.pxp += var1 * 0.2;
            this.pxr += var3 * 0.2;
         }
      }

      float var6 = 1.0F;
      if (this.pxs) {
         BlockPos var7 = BlockPos.method_49637(this.pxx(), this.pxo.field_1322 - 0.500001, this.pxy());
         var6 = this.pxg.method_8320(var7).method_26204().method_9499();
      }

      double var15 = this.pxs ? this.pxj * (0.21600002 / (var6 * var6 * var6)) : this.pxk;
      this.pxp += var1 * 0.98F * var15;
      this.pxr += var3 * 0.98F * var15;
      Vec3d var9 = new Vec3d(this.pxp, this.pxq, this.pxr);
      Vec3d var10 = this.pya(var9);
      this.pxo = this.pxo.method_997(var10);
      boolean var11 = Math.abs(var10.field_1352 - var9.field_1352) > 1.0E-7;
      boolean var12 = Math.abs(var10.field_1350 - var9.field_1350) > 1.0E-7;
      boolean var13 = Math.abs(var10.field_1351 - var9.field_1351) > 1.0E-7;
      this.pxs = var13 && var9.field_1351 < 0.0;
      this.pxt = var9.field_1352 * var1 + var9.field_1350 * var3;
      this.pxu = var10.field_1352 * var1 + var10.field_1350 * var3;
      if (var11) {
         this.pxp = 0.0;
      }

      if (var12) {
         this.pxr = 0.0;
      }

      if (var13) {
         this.pxq = 0.0;
      }

      float var14 = var6 * 0.91F;
      this.pxq = (this.pxq - this.pxm) * 0.98F;
      this.pxp *= var14;
      this.pxr *= var14;
   }

   private Vec3d pya(Vec3d var1) {
      if (var1.method_1027() == 0.0) {
         return var1;
      } else {
         Vec3d var2 = pyc(var1, this.pxo, this.pyb(this.pxo.method_18804(var1)));
         boolean var3 = var1.field_1352 != var2.field_1352;
         boolean var4 = var1.field_1350 != var2.field_1350;
         boolean var5 = var1.field_1351 != var2.field_1351 && var1.field_1351 < 0.0;
         if (!(this.pxi <= 0.0F) && (var5 || this.pxs) && (var3 || var4)) {
            Box var6 = var5 ? this.pxo.method_989(0.0, var2.field_1351, 0.0) : this.pxo;
            Box var7 = var6.method_1012(var1.field_1352, this.pxi, var1.field_1350);
            if (!var5) {
               var7 = var7.method_1012(0.0, -1.0E-5, 0.0);
            }

            List var8 = this.pyb(var7);
            FloatArraySet var9 = new FloatArraySet(4);
            float var10 = (float)var2.field_1351;

            for (VoxelShape var12 : var8) {
               DoubleList var13 = var12.method_1109(Axis.field_11052);

               for (int var14 = 0; var14 < var13.size(); var14++) {
                  float var15 = (float)(var13.getDouble(var14) - var6.field_1322);
                  if (!(var15 < 0.0F) && var15 != var10) {
                     if (var15 > this.pxi) {
                        break;
                     }

                     var9.add(var15);
                  }
               }
            }

            float[] var17 = var9.toFloatArray();
            FloatArrays.unstableSort(var17);

            for (float var21 : var17) {
               Vec3d var16 = pyc(new Vec3d(var1.field_1352, var21, var1.field_1350), var6, var8);
               if (var16.method_37268() > var2.method_37268()) {
                  return var16.method_1031(0.0, var6.field_1322 - this.pxo.field_1322, 0.0);
               }
            }

            return var2;
         } else {
            return var2;
         }
      }
   }

   private List<VoxelShape> pyb(Box var1) {
      ArrayList var2 = new ArrayList();

      for (VoxelShape var4 : this.pxg.method_20812(this.pxh, var1)) {
         if (!var4.method_1110()) {
            var2.add(var4);
         }
      }

      return var2;
   }

   private static Vec3d pyc(Vec3d var0, Box var1, List<VoxelShape> var2) {
      if (var2.isEmpty()) {
         return var0;
      } else {
         double var3 = var0.field_1352;
         double var5 = var0.field_1351;
         double var7 = var0.field_1350;
         if (var5 != 0.0) {
            var5 = VoxelShapes.method_1085(Axis.field_11052, var1, var2, var5);
            if (var5 != 0.0) {
               var1 = var1.method_989(0.0, var5, 0.0);
            }
         }

         boolean var9 = Math.abs(var3) < Math.abs(var7);
         if (var9 && var7 != 0.0) {
            var7 = VoxelShapes.method_1085(Axis.field_11051, var1, var2, var7);
            if (var7 != 0.0) {
               var1 = var1.method_989(0.0, 0.0, var7);
            }
         }

         if (var3 != 0.0) {
            var3 = VoxelShapes.method_1085(Axis.field_11048, var1, var2, var3);
            if (!var9 && var3 != 0.0) {
               var1 = var1.method_989(var3, 0.0, 0.0);
            }
         }

         if (!var9 && var7 != 0.0) {
            var7 = VoxelShapes.method_1085(Axis.field_11051, var1, var2, var7);
         }

         return new Vec3d(var3, var5, var7);
      }
   }
}
