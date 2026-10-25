package a;

import java.util.Random;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class pve {
   public static final int WALK = 0;
   public static final int DONE = 1;
   public static final int OFF = 2;
   private static final float[][] pvf = new float[][]{
      {1.0F, 0.0F}, {1.0F, 1.0F}, {1.0F, -1.0F}, {0.0F, 1.0F}, {0.0F, -1.0F}, {-1.0F, 0.0F}, {-1.0F, 1.0F}, {-1.0F, -1.0F}
   };
   private static final double[] pvg = new double[]{0.0, 6.0, 6.0, 22.0, 22.0, 40.0, 44.0, 44.0};
   private final Random pvh = new Random();
   private double pvi = 1.0;
   private double pvj = 0.13;
   private double pvk = 0.5;
   private double pvl = 30.0;
   private double pvm = 14.0;
   private double pvn = 0.4;
   private boolean pvo = true;
   private psc pvp = new psc();
   private psf pvq;
   private int pvr;
   private double pvs;
   private int pvt;
   private int pvu;
   private long pvv;
   private double pvw;
   private double pvx;
   private double pvy;
   private double pvz;
   private int pwa = -1;
   private int pwb;
   private int pwc;
   private int pwd = 240;
   private double pwe;
   private int pwf;
   private int pwg = 40;
   private int pwh;
   private int pwi = 1;
   private int pwj;
   private boolean pwk = true;
   private final pvb pwl = new pvb();
   private final double[] pwm = new double[3];
   private final double[] pwn = new double[1];

   public void personalize(long var1) {
      Random var3 = new Random(var1 ^ 4354685564936845355L);
      this.pvi = 0.85 + var3.nextDouble() * 0.35;
      this.pvj = 0.1 + var3.nextDouble() * 0.07;
      this.pvk = 0.44 + var3.nextDouble() * 0.16;
      this.pvl = 24.0 + var3.nextDouble() * 16.0;
      this.pvm = 8.0 + var3.nextDouble() * 14.0;
      this.pvn = var3.nextDouble() < 0.3 ? 0.0 : 0.2 + var3.nextDouble() * 0.7;
      this.pvo = var3.nextDouble() < 0.6;
      this.pvp = psc.of(var1);
   }

   public psc routeStyle() {
      return this.pvp;
   }

   public void reset() {
      this.pvq = null;
      this.pvr = 0;
      this.pvs = 0.0;
      this.pvt = 0;
      this.pvw = 0.0;
      this.pvx = 0.0;
      this.pwa = -1;
      this.pwf = 0;
      this.pwh = 0;
      this.pwj = 0;
      this.pwb = 0;
   }

   public psf route() {
      return this.pvq;
   }

   public int at() {
      return this.pvr;
   }

   public double progress() {
      return this.pvs;
   }

   public int track(PlayerEntity var1, psf var2) {
      tvt var3 = var2.track;
      double var4 = var1.method_23317();
      double var6 = var1.method_23318();
      double var8 = var1.method_23321();
      if (var2 != this.pvq) {
         this.pvq = var2;
         this.pvr = var3.closest(var4, var6, var8, 0, 0, var3.n);
         this.pvt = 0;
      } else {
         this.pvr = var3.closest(var4, var6, var8, this.pvr, 6, 56);
      }

      this.pvs = var3.project(var4, var8, this.pvr);
      double var10 = var3.offset(var4, var8, this.pvs);
      double var12 = var6 - var3.y[this.pvr];
      boolean var14 = var1.method_24828() || var1.method_5799();
      if (!var14 || !(var10 > 2.2) && !(var12 < -1.9) && !(var12 > 2.6)) {
         if (var10 < 1.6 && var12 > -1.6) {
            this.pvt = 0;
         }
      } else {
         this.pvt++;
      }

      if (this.pvt > 3) {
         return 2;
      } else {
         double var15 = var3.length() - this.pvs;
         double var17 = Math.hypot(var4 - var1.field_6014, var8 - var1.field_5969);
         this.pvu = var17 < 0.02 ? this.pvu + 1 : 0;
         return !var14 || !(Math.abs(var12) < 1.2) || !(var15 < 0.32) && (!(var15 < 1.3) || this.pvu < 3) ? 0 : 1;
      }
   }

   public pvb drive(PlayerEntity var1, World var2, float var3, float var4, Vec3d var5, boolean var6, boolean var7) {
      long var8 = System.currentTimeMillis();
      if (var8 - this.pvv > 160L) {
         this.pvw = 0.0;
         this.pvx = 0.0;
         this.pwa = -1;
         this.pwf = 0;
         this.pwj = 0;
      }

      this.pvv = var8;
      tvt var10 = this.pvq.track;
      double var11 = var1.method_23317();
      double var13 = var1.method_23318();
      double var15 = var1.method_23321();
      double var17 = var11 - var1.field_6014;
      double var19 = var15 - var1.field_5969;
      double var21 = Math.hypot(var17, var19);
      boolean var23 = var1.method_24828();
      boolean var24 = var1.method_5799();
      double var25 = var10.length() - this.pvs;
      double var27 = pww(1.05 + 5.0 * var21, 1.25, 2.7) * this.pvi;
      var10.at(this.pvs + var27, this.pwm);

      for (int var29 = 0; var29 < 3 && var27 > 0.7 && !pws(var2, var1, var11, var13, var15, this.pwm); var29++) {
         var27 *= 0.6;
         var10.at(this.pvs + var27, this.pwm);
      }

      double var82 = this.pwm[0] - var11;
      double var31 = this.pwm[2] - var15;
      double var33 = Math.hypot(var82, var31) > 0.15 ? tvt.yawOf(var82, var31) : var10.heading(this.pvs);
      double var35 = this.pvs + var27 + 1.3 + 3.0 * var21;
      var10.at(var35, this.pwm);
      double var37 = this.pwm[0] - var11;
      double var39 = this.pwm[2] - var15;
      double var41 = Math.hypot(var37, var39) > 0.3 ? tvt.yawOf(var37, var39) : var33;
      double var43 = var33 + pwv(tvt.wrap(var41 - var33) * 0.45, 24.0);
      Vec3d var45 = var1.method_33571();
      double var46;
      if (var5 != null) {
         double var48 = var5.field_1352 - var45.field_1352;
         double var50 = var5.field_1351 - var45.field_1351;
         double var52 = var5.field_1350 - var45.field_1350;
         var43 = tvt.yawOf(var48, var52);
         var46 = -Math.toDegrees(Math.atan2(var50, Math.max(0.2, Math.hypot(var48, var52))));
         this.pwb = 0;
      } else {
         var10.at(this.pvs + 3.2 + 5.5 * var21, this.pwm);
         double var85 = Math.max(1.5, Math.hypot(this.pwm[0] - var11, this.pwm[2] - var15));
         double var87 = Math.toDegrees(Math.atan2(var45.field_1351 - this.pwm[1], var85));
         var46 = pww(0.55 * this.pvm + 0.45 * var87, -12.0, 50.0);
         this.pwq(var10, var25, var6);
         if (this.pwb > 0) {
            int var89 = this.pwc - this.pwb;
            double var53 = Math.min(1.0, Math.min(var89 / 4.0, this.pwb / 4.0));
            var43 += this.pwe * var53;
            this.pwb--;
         }
      }

      this.pvy = this.pvy * 0.965 + this.pvh.nextGaussian() * 0.42;
      this.pvz = this.pvz * 0.985 + this.pvh.nextGaussian() * 0.18;
      var43 += this.pvy;
      var46 += this.pvz;
      double var86 = tvt.wrap(var43 - var3);
      double var88 = pwv(this.pvj * var86 - this.pvk * this.pvw, 4.0 + 0.3 * Math.abs(var86));
      this.pvw = pwv(this.pvw + var88, this.pvl);
      double var90 = this.pvw + this.pvh.nextGaussian() * (0.03 * Math.abs(this.pvw) + 0.02);
      double var54 = var46 - var4;
      double var56 = pwv(0.08 * var54 - 0.5 * this.pvx, 2.5);
      this.pvx = pwv(this.pvx + var56, 9.0);
      double var58 = this.pvx;
      double var60 = var3 + var90;
      pvb var62 = this.pwl;
      var62.forward = false;
      var62.back = false;
      var62.left = false;
      var62.right = false;
      var62.jump = false;
      var62.sprint = false;
      var62.dyaw = var90;
      var62.dpitch = var58;
      var62.moveYaw = var33;
      double var63 = 1.25 * var21 + 0.1;
      double var65 = Math.abs(tvt.wrap(var33 - var60));
      boolean var67 = !var6 && var65 > 120.0 && var5 == null;
      if (!(var25 < var63) && !var67) {
         int var68 = 0;
         double var69 = Double.MAX_VALUE;

         for (int var71 = 0; var71 < pvf.length; var71++) {
            double var72 = pwu(var71, var60, var33) + (var6 ? pvg[var71] * 0.5 : pvg[var71]);
            if (var72 < var69) {
               var69 = var72;
               var68 = var71;
            }
         }

         if (this.pwa >= 0 && pwu(this.pwa, var60, var33) + pvg[this.pwa] <= var69 + 12.0) {
            var68 = this.pwa;
         }

         double var91 = var10.next(this.pvs, 2.5, (byte)2, var13, this.pwn);
         double var73 = var91 >= 0.0 ? this.pwn[0] : 0.0;
         boolean var75 = var1.field_5976;
         this.pwh = var75 && var23 ? this.pwh + 1 : 0;
         if (this.pwh >= 3 && pvf[var68][0] > 0.0F) {
            int var76 = pwt(var2, var1, var33);
            if (var76 != 0) {
               this.pwi = var76;
            } else if (this.pwh % 14 == 0) {
               this.pwi = -this.pwi;
            }

            var68 = this.pwi > 0 ? 1 : 2;
         }

         this.pwa = var68;
         float var92 = pvf[var68][0];
         float var77 = pvf[var68][1];
         var62.forward = var92 > 0.0F;
         var62.back = var92 < 0.0F;
         var62.left = var77 > 0.0F;
         var62.right = var77 < 0.0F;
         boolean var78 = var1.method_5624();
         var62.sprint = var7 && var62.forward && !var24 && (var6 || var25 > 1.4 + 5.0 * var21) && var73 <= 2.0;
         boolean var79 = false;
         if (var24) {
            var10.at(this.pvs + 1.0, this.pwm);
            var79 = this.pwm[1] >= var13 - 0.2 || var75;
         } else if (var23) {
            double var80 = var10.next(this.pvs, 2.2, (byte)1, var13, this.pwn);
            if (var80 >= 0.0 && var80 < 0.95 + (var78 ? 0.3 : 0.15)) {
               var79 = true;
            } else if (var75 && this.pwh >= 1 && pxd.jumpHelps(var1, (float)var33, var78, 3)) {
               var79 = true;
            } else if (this.pwr(var1, var10, var25, var6, var7 && var78, var91, var33)) {
               var79 = true;
            }
         } else if (this.pwf > 0 && this.pvo) {
            var79 = true;
         }

         if (var79 && var23) {
            this.pwj = 1 + this.pvh.nextInt(3);
         }

         if (this.pwj > 0) {
            this.pwj--;
            var79 = true;
         }

         if (var91 >= 0.0 && var91 < 1.2 && var10.next(this.pvs, 1.6, (byte)1, var13, this.pwn) < 0.0 && !var24) {
            var79 = false;
            this.pwj = 0;
         }

         if (var23 && !this.pwk && this.pwf > 0) {
            this.pwf--;
         }

         this.pwk = var23;
         var62.jump = var79;
         return var62;
      } else {
         this.pwa = -1;
         this.pwk = var23;
         return var62;
      }
   }

   public double aheadYaw(PlayerEntity var1, double var2) {
      if (this.pvq == null) {
         return var1.method_36454();
      } else {
         this.pvq.track.at(this.pvs + var2, this.pwm);
         double var4 = this.pwm[0] - var1.method_23317();
         double var6 = this.pwm[2] - var1.method_23321();
         return Math.hypot(var4, var6) < 0.1 ? this.pvq.track.heading(this.pvs) : tvt.yawOf(var4, var6);
      }
   }

   public boolean mustJump(PlayerEntity var1, double var2) {
      if (this.pvq != null && var1.method_24828() && !var1.method_5799()) {
         boolean var4 = var1.method_5624();
         double var5 = this.pvq.track.next(this.pvs, 2.2, (byte)1, var1.method_23318(), this.pwn);
         return var5 >= 0.0 && var5 < 0.95 + (var4 ? 0.3 : 0.15) ? true : var1.field_5976 && pxd.jumpHelps(var1, (float)var2, var4, 3);
      } else {
         return false;
      }
   }

   public boolean safe(PlayerEntity var1, World var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, double var9) {
      return this.safe(var1, var2, var3, var4, var5, var6, var7, var8, var9, 6);
   }

   public boolean safe(
      PlayerEntity var1, World var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, double var9, int var11
   ) {
      if (this.pvq != null && (var3 || var4 || var5 || var6)) {
         float var12 = var3 ? 1.0F : (var4 ? -1.0F : 0.0F);
         float var13 = var5 ? 1.0F : (var6 ? -1.0F : 0.0F);
         double var14 = Math.toDegrees(pud.inputDirection((float)var9, var12, var13));
         pxa var16 = pxd.run(var1, (float)var14, var7 && var3, var8 && var1.method_24828(), var11);
         double var17 = var16.endX;
         double var19 = var16.endZ;
         tvt var21 = this.pvq.track;
         int var22 = var21.closest(var17, var16.endY, var19, this.pvr, 4, 40);
         double var23 = var21.project(var17, var19, var22);
         if (var21.offset(var17, var19, var23) > 2.4) {
            return false;
         } else {
            double var25 = Math.min(var21.y[var22], var21.y[Math.max(0, var22 - 2)]);
            return var16.minY < var25 - 0.9 && var16.minY < var1.method_23318() - 0.9 ? false : !pua.hazard(var2, var17, var16.endY, var19);
         }
      } else {
         return true;
      }
   }

   private void pwq(tvt var1, double var2, boolean var4) {
      if (this.pwb <= 0) {
         if (this.pwd > 0) {
            this.pwd--;
         } else {
            this.pwd = 260 + this.pvh.nextInt(900);
            if (!var4 && !(var2 < 10.0) && !(var1.bend(this.pvs, 6.0) > 20.0) && this.pwf <= 0 && !(this.pvh.nextDouble() < 0.4)) {
               this.pwc = 10 + this.pvh.nextInt(18);
               this.pwb = this.pwc;
               this.pwe = (this.pvh.nextBoolean() ? 1.0 : -1.0) * (16.0 + this.pvh.nextDouble() * 34.0);
            }
         }
      }
   }

   private boolean pwr(PlayerEntity var1, tvt var2, double var3, boolean var5, boolean var6, double var7, double var9) {
      double var11 = var5 ? Math.max(0.75, this.pvn) : this.pvn;
      if (var6 && !(var11 <= 0.0) && var1.method_7344().method_7586() >= 14) {
         boolean var13 = var3 > 6.0
            && var2.flatAhead(this.pvs, 6.0, var1.method_23318()) >= 5.5
            && var2.bend(this.pvs, 6.0) < 14.0
            && (var7 < 0.0 || var7 > 5.0);
         if (!var13) {
            this.pwf = 0;
            return false;
         } else {
            if (this.pwf <= 0) {
               if (this.pwg > 0) {
                  this.pwg--;
                  return false;
               }

               this.pwg = 15 + this.pvh.nextInt(40);
               if (this.pvh.nextDouble() > var11) {
                  return false;
               }

               this.pwf = 2 + this.pvh.nextInt(var5 ? 10 : 6);
            }

            pxa var14 = pxd.run(var1, (float)var9, true, true, 12);
            if (var14.firstBlockTick >= 0) {
               this.pwf = 0;
               return false;
            } else {
               return true;
            }
         }
      } else {
         this.pwf = 0;
         return false;
      }
   }

   private static boolean pws(World var0, PlayerEntity var1, double var2, double var4, double var6, double[] var8) {
      double var9 = var8[0] - var2;
      double var11 = var8[2] - var6;
      double var13 = Math.hypot(var9, var11);
      int var15 = Math.max(1, (int)Math.ceil(var13 / 0.3));
      double var16 = var4;

      for (int var18 = 1; var18 <= var15; var18++) {
         double var19 = (double)var18 / var15;
         double var21 = var2 + var9 * var19;
         double var23 = var6 + var11 * var19;
         double var25 = pua.standAt(var0, var21, Math.max(var16, var4 + (var8[1] - var4) * var19), var23, 1.25);
         if (Double.isNaN(var25) || pua.hazard(var0, var21, var25, var23)) {
            return false;
         }

         var16 = var25;
      }

      return true;
   }

   public pvb cautious(PlayerEntity var1, World var2, float var3) {
      tvt var4 = this.pvq.track;
      var4.at(this.pvs + 0.7, this.pwm);
      double var5 = tvt.yawOf(this.pwm[0] - var1.method_23317(), this.pwm[2] - var1.method_23321());
      pvb var7 = this.pwl;
      var7.forward = false;
      var7.back = false;
      var7.left = false;
      var7.right = false;
      var7.jump = false;
      var7.sprint = false;
      var7.moveYaw = var5;
      int var8 = 0;
      double var9 = Double.MAX_VALUE;

      for (int var11 = 0; var11 < 5; var11++) {
         double var12 = pwu(var11, var3 + var7.dyaw, var5);
         if (var12 < var9) {
            var9 = var12;
            var8 = var11;
         }
      }

      boolean var14 = pvf[var8][0] > 0.0F;
      boolean var15 = pvf[var8][1] > 0.0F;
      boolean var13 = pvf[var8][1] < 0.0F;
      if (this.safe(var1, var2, var14, false, var15, var13, false, false, var3 + var7.dyaw, 3)) {
         var7.forward = var14;
         var7.left = var15;
         var7.right = var13;
      }

      this.pwa = -1;
      return var7;
   }

   private static int pwt(World var0, PlayerEntity var1, double var2) {
      double var4 = Math.toRadians(var2);
      double var6 = -Math.sin(var4);
      double var8 = Math.cos(var4);
      double var10 = -var8;
      double var14 = var1.method_23317() + var6 * 0.5;
      double var16 = var1.method_23321() + var8 * 0.5;
      double var18 = var1.method_23318();
      boolean var20 = pua.bodyFits(var0, var1, var14 + var10 * 0.5, var16 + var6 * 0.5, var18, 0.3)
         && !Double.isNaN(pua.standAt(var0, var14 + var10 * 0.5, var18, var16 + var6 * 0.5, 1.0));
      boolean var21 = pua.bodyFits(var0, var1, var14 - var10 * 0.5, var16 - var6 * 0.5, var18, 0.3)
         && !Double.isNaN(pua.standAt(var0, var14 - var10 * 0.5, var18, var16 - var6 * 0.5, 1.0));
      if (var20 == var21) {
         return 0;
      } else {
         return var20 ? -1 : 1;
      }
   }

   private static double pwu(int var0, double var1, double var3) {
      double var5 = Math.toDegrees(pud.inputDirection((float)var1, pvf[var0][0], pvf[var0][1]));
      return Math.abs(tvt.wrap(var5 - var3));
   }

   private static double pwv(double var0, double var2) {
      return var0 > var2 ? var2 : (var0 < -var2 ? -var2 : var0);
   }

   private static double pww(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }
}
