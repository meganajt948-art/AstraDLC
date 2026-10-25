package a;

import java.util.ArrayList;
import java.util.List;

public final class szk {
   public static final int MAXW = 60;
   public static final int GRACE = 8;
   public static final double FLICK = 20.0;
   private static final int szl = 6;
   private static final int szm = 6;
   private static final int szn = 2;
   public final List<sze> segments = new ArrayList<>();
   public final List<double[]> aimPoints = new ArrayList<>();
   public final szh stats = new szh();
   public final List<float[]> chain = new ArrayList<>();
   public final List<Integer> reactions = new ArrayList<>();
   private double szo;
   private int szp = 3;
   public static final double TRACK_RANGE = 6.0;
   public static final double TRACK_FOV = 75.0;
   private static final double szq = 20.0;
   public static final double REACT_FROM = 15.0;
   private static final int szr = 20;

   public static szk build(List<tmh> var0, boolean var1) {
      return build(var0, var1, 3);
   }

   public static szk build(List<tmh> var0, boolean var1, int var2) {
      szk var3 = new szk();
      var3.szp = Math.max(1, var2);

      for (tmh var5 : var0) {
         var3.taa(var5, var1);
      }

      return var3;
   }

   public static szk track(List<tmh> var0, boolean var1) {
      szk var2 = new szk();

      for (tmh var4 : var0) {
         var2.szu(var4, var1);
      }

      return var2;
   }

   private void szu(tmh var1, boolean var2) {
      this.szo = var1.unit;
      List var3 = var1.ticks;
      int var4 = var3.size();
      if (var4 >= 10) {
         double[] var5 = szw(var3);
         tbm var6 = new tbm();
         int[] var7 = new int[var4];
         int var8 = 0;

         for (int var9 = 0; var9 < var4; var9++) {
            tme var10 = (tme)var3.get(var9);
            if ((var10.flags & 1) == 0) {
               var7[var9] = 0;
               var8 = 0;
            } else {
               if (!szz(var3, var9)) {
                  var8 = 0;
               }

               int var11 = 0;
               double var12 = Double.MAX_VALUE;
               double var14 = Double.MAX_VALUE;

               for (int var16 = 0; var16 < var10.count(); var16++) {
                  float[] var17 = var10.boxes;
                  if (tbp.aim(
                        var10.eyeX,
                        var10.eyeY,
                        var10.eyeZ,
                        var17[var16 * 5],
                        var17[var16 * 5 + 1],
                        var17[var16 * 5 + 2],
                        var17[var16 * 5 + 3],
                        var17[var16 * 5 + 4],
                        0.0,
                        0.5,
                        var6
                     )
                     && !(var6.dist > 6.0)) {
                     double var18 = Math.hypot(tbp.wrap(var6.yaw - var10.yaw), var6.pitch - var10.pitch);
                     if (!(var18 > 75.0)) {
                        if (var10.ids[var16] == var8) {
                           var14 = var18;
                        }

                        if (var18 < var12) {
                           var12 = var18;
                           var11 = var10.ids[var16];
                        }
                     }
                  }
               }

               if (var8 != 0 && var14 <= 75.0 && var14 <= var12 + 20.0) {
                  var11 = var8;
               }

               var7[var9] = var11;
               var8 = var11;
            }
         }

         for (int var20 = 0; var20 < var4; var20++) {
            if (var7[var20] != 0 && (var20 == 0 || var7[var20 - 1] != var7[var20] || !szz(var3, var20))) {
               int var22 = szv(var3, var20, var7[var20]);
               if (var22 >= 0) {
                  this.reactions.add(var22);
               }
            }
         }

         int var21 = 0;

         while (var21 < var4) {
            if (var7[var21] == 0) {
               var21++;
            } else {
               int var23 = var7[var21];
               int var24 = var21;

               while (var24 + 1 < var4 && var7[var24 + 1] == var23 && szz(var3, var24 + 1)) {
                  var24++;
               }

               int var25 = var21;
               int var13 = 0;

               while (var13 < 6 && var25 - var13 - 1 >= 0 && szz(var3, var25 - var13) && ((tme)var3.get(var25 - var13 - 1)).indexOf(var23) >= 0) {
                  var13++;
               }

               if (var13 < 6) {
                  var25 += 6 - var13;
               }

               if (var24 - var25 >= 8) {
                  this.szx(var1, var23, var25, var24, var5, var2);
               }

               var21 = var24 + 1;
            }
         }
      }
   }

   private static int szv(List<tme> var0, int var1, int var2) {
      tbm var3 = new tbm();
      int var4 = 0;

      while (var4 < 20) {
         int var5 = var1 + var4;
         int var6 = var5 + 1;
         if (var6 < var0.size() && szz(var0, var6)) {
            tme var7 = (tme)var0.get(var5);
            int var8 = var7.indexOf(var2);
            float[] var9 = var7.boxes;
            if (var8 >= 0
               && tbp.aim(
                  var7.eyeX,
                  var7.eyeY,
                  var7.eyeZ,
                  var9[var8 * 5],
                  var9[var8 * 5 + 1],
                  var9[var8 * 5 + 2],
                  var9[var8 * 5 + 3],
                  var9[var8 * 5 + 4],
                  0.0,
                  0.5,
                  var3
               )) {
               double var10 = tbp.wrap(var3.yaw - var7.yaw);
               double var12 = var3.pitch - var7.pitch;
               double var14 = Math.hypot(var10, var12);
               if (var4 == 0 && var14 < 15.0) {
                  return -1;
               }

               tme var16 = (tme)var0.get(var6);
               double var17 = ((var16.yaw - var7.yaw) * var10 + (var16.pitch - var7.pitch) * var12) / Math.max(1.0E-6, var14);
               if (var17 > Math.max(1.0, 0.08 * var14)) {
                  return var4;
               }

               var4++;
               continue;
            }

            return -1;
         }

         return -1;
      }

      return -1;
   }

   private static double[] szw(List<tme> var0) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for (tme var4 : var0) {
         if ((var4.flags & 1) != 0 && var4.hitId != 0) {
            var1.add(Math.abs((double)var4.hitU));
            var2.add((double)var4.hitV);
         }
      }

      return var1.size() < 5 ? new double[]{0.0, 0.62} : new double[]{0.0, tnl.quantile(var2, 0.5)};
   }

   private void szx(tmh var1, int var2, int var3, int var4, double[] var5, boolean var6) {
      List var7 = var1.ticks;
      ArrayList var8 = new ArrayList();

      for (int var9 = var3; var9 <= var4; var9++) {
         tme var10 = (tme)var7.get(var9);
         if (var10.hitId == var2) {
            var8.add(new syx(var9, var2, var10.hitU, var10.hitV));
            this.stats.hits++;
         }
      }

      int var27 = var3 - 6;
      int var28 = var4 - var27 + 1;
      double[] var11 = new double[var28];
      double[] var12 = new double[var28];
      int var13 = 0;

      for (int var14 = 0; var14 < var28; var14++) {
         int var15 = var27 + var14;
         if (var8.isEmpty()) {
            var11[var14] = var5[0];
            var12[var14] = var5[1];
         } else {
            while (var13 < var8.size() - 1 && ((syx)var8.get(var13)).syy < var15) {
               var13++;
            }

            syx var16 = (syx)var8.get(var13);
            syx var17 = var13 > 0 ? (syx)var8.get(var13 - 1) : null;
            if (var17 != null && var15 < var16.syy) {
               double var18 = (double)(var15 - var17.syy) / (var16.syy - var17.syy);
               var11[var14] = var17.sza + (var16.sza - var17.sza) * var18;
               var12[var14] = var17.szb + (var16.szb - var17.szb) * var18;
            } else {
               var11[var14] = var16.sza;
               var12[var14] = var16.szb;
            }
         }
      }

      int var29 = var4 - var3;
      tbm var30 = new tbm();
      double[] var31 = new double[var28];
      double[] var32 = new double[var28];
      double[] var33 = new double[var28];
      double[] var19 = new double[var28];
      double[][] var20 = new double[var28][];

      for (int var21 = 0; var21 < var28; var21++) {
         tme var22 = (tme)var7.get(var27 + var21);
         int var23 = var22.indexOf(var2);
         float[] var24 = var22.boxes;
         if (var23 < 0
            || !tbp.aim(
               var22.eyeX,
               var22.eyeY,
               var22.eyeZ,
               var24[var23 * 5],
               var24[var23 * 5 + 1],
               var24[var23 * 5 + 2],
               var24[var23 * 5 + 3],
               var24[var23 * 5 + 4],
               var11[var21],
               var12[var21],
               var30
            )) {
            return;
         }

         var31[var21] = var30.yaw;
         var32[var21] = var30.pitch;
         var33[var21] = tbp.wrap(var30.yaw - var22.yaw);
         var19[var21] = var30.pitch - var22.pitch;
         var20[var21] = new double[]{var30.bw, var30.bh, var30.la, var30.ra, var30.ta, var30.ba, var30.dist};
      }

      double[] var34 = szy(var7, var27, var29, var11, var12, var31, var32, var33, var19, var20);

      for (int var35 = 0; var35 < var8.size(); var35++) {
         int var37 = var35 == 0 ? 0 : Math.min(65535, ((syx)var8.get(var35)).syy - ((syx)var8.get(var35 - 1)).syy);
         this.chain.add(new float[]{(float)((syx)var8.get(var35)).sza, (float)((syx)var8.get(var35)).szb, var37});
      }

      boolean[] var36 = new boolean[var29 + 1];
      if (var6) {
         this.stats.overshoots = this.stats.overshoots + overshoots(var34, var29, var36);
      }

      int[] var38 = new int[var8.size()];

      for (int var39 = 0; var39 < var8.size(); var39++) {
         var38[var39] = ((syx)var8.get(var39)).syy - var3;
      }

      this.tad(var34, var29, var38, var36);
      int var40 = -1;

      for (int var25 = 0; var25 <= var29 + 1; var25++) {
         boolean var26 = var25 <= var29 && !var36[var25];
         if (var26 && var40 < 0) {
            var40 = var25;
         } else if (!var26 && var40 >= 0) {
            this.tac(var34, var40, var25 - 1, var8, var38, 8);
            var40 = -1;
         }
      }
   }

   private static double[] szy(
      List<tme> var0, int var1, int var2, double[] var3, double[] var4, double[] var5, double[] var6, double[] var7, double[] var8, double[][] var9
   ) {
      byte var10 = 32;
      double[] var11 = new double[(var2 + 1) * var10];

      for (int var12 = 0; var12 <= var2; var12++) {
         int var13 = var12 + 6;
         tme var14 = (tme)var0.get(var1 + var13);
         int var15 = var12 * var10;
         var11[var15 + 0] = var7[var13];
         var11[var15 + 1] = var8[var13];
         var11[var15 + 2] = var7[var13 - 2];
         var11[var15 + 3] = var8[var13 - 2];
         var11[var15 + 4] = var7[var13 - 4];
         var11[var15 + 5] = var8[var13 - 4];

         for (int var16 = 0; var16 < 4; var16++) {
            var11[var15 + 6 + var16 * 2] = tbp.wrap(var5[var13 - var16] - var5[var13 - var16 - 1]);
            var11[var15 + 7 + var16 * 2] = var6[var13 - var16] - var6[var13 - var16 - 1];
            tme var17 = (tme)var0.get(var1 + var13 - var16);
            tme var18 = (tme)var0.get(var1 + var13 - var16 - 1);
            var11[var15 + 14 + var16 * 2] = var17.yaw - var18.yaw;
            var11[var15 + 15 + var16 * 2] = var17.pitch - var18.pitch;
         }

         double[] var19 = var9[var13];
         var11[var15 + 22] = var19[0];
         var11[var15 + 23] = var19[1];
         var11[var15 + 24] = var3[var13];
         var11[var15 + 25] = var4[var13];
         var11[var15 + 26] = var19[6];
         var11[var15 + 27] = var14.cooldown;
         var11[var15 + 28] = var19[2];
         var11[var15 + 29] = var19[3];
         var11[var15 + 30] = var19[4];
         var11[var15 + 31] = var19[5];
      }

      return var11;
   }

   private static boolean szz(List<tme> var0, int var1) {
      if (var1 <= 0) {
         return false;
      } else {
         tme var2 = (tme)var0.get(var1);
         tme var3 = (tme)var0.get(var1 - 1);
         if ((var2.flags & 1) != 0 && (var3.flags & 1) != 0 && (var2.flags & 4) == 0) {
            double var4 = var2.eyeX - var3.eyeX;
            double var6 = var2.eyeY - var3.eyeY;
            double var8 = var2.eyeZ - var3.eyeZ;
            return Math.abs(var2.yaw - var3.yaw) <= 180.0 && var4 * var4 + var6 * var6 + var8 * var8 < 16.0;
         } else {
            return false;
         }
      }
   }

   private void taa(tmh var1, boolean var2) {
      this.szo = var1.unit;
      List var3 = var1.ticks;
      int var4 = var3.size();
      if (var4 >= 10) {
         int[] var5 = new int[var4];

         for (int var6 = 0; var6 < var4; var6++) {
            var5[var6] = szz(var3, var6) ? var5[var6 - 1] : var6;
         }

         boolean[] var17 = new boolean[var4];
         int var7 = Integer.MAX_VALUE;

         for (int var8 = var4 - 1; var8 >= 0; var8--) {
            tme var9 = (tme)var3.get(var8);
            boolean var10 = (var9.flags & 1) != 0;
            if (var10 && var9.hitId != 0) {
               var7 = var8;
               this.stats.hits++;
            }

            int var11 = var9.presses - (var9.hitId != 0 ? 1 : 0);
            if (var10 && var11 > 0 && var9.hitId == 0) {
               boolean var12 = var7 != Integer.MAX_VALUE && var7 - var8 <= 8 && var5[var7] <= var8;
               if (!var12) {
                  var17[var8] = true;
                  this.stats.failures++;
               }
            }
         }

         ArrayList var18 = new ArrayList();
         int var19 = -1;
         int var20 = -1;
         syx var21 = null;

         for (int var22 = 0; var22 < var4; var22++) {
            if (var17[var22]) {
               var20 = var22;
            }

            tme var13 = (tme)var3.get(var22);
            if ((var13.flags & 1) != 0 && var13.hitId != 0) {
               syx var14 = new syx(var22, var13.hitId, var13.hitU, var13.hitV);
               int var15 = Math.max(var22 - 60, var5[var22] + 6);
               var15 = Math.max(var15, var20);
               if (var21 != null && var21.syz != var14.syz) {
                  var15 = Math.max(var15, var21.syy);
               }

               for (int var16 = var22; var16 >= Math.max(0, var15 - 6); var16--) {
                  if (((tme)var3.get(var16)).indexOf(var14.syz) < 0) {
                     var15 = Math.max(var15, var16 + 1 + 6);
                     break;
                  }
               }

               boolean var24 = !var18.isEmpty() && ((syx)var18.get(0)).syz == var14.syz && var15 <= ((syx)var18.get(var18.size() - 1)).syy;
               if (!var24) {
                  this.tab(var1, var18, var19, var2);
                  var18 = new ArrayList();
                  var19 = var15;
               }

               if (var22 - var19 >= 1) {
                  var18.add(var14);
               }

               var21 = var14;
            }
         }

         this.tab(var1, var18, var19, var2);
      }
   }

   private void tab(tmh var1, List<syx> var2, int var3, boolean var4) {
      if (!var2.isEmpty() && var3 >= 0) {
         int var5 = ((syx)var2.get(var2.size() - 1)).syy;
         int var6 = var5 - var3;
         if (var6 >= this.szp) {
            List var7 = var1.ticks;
            int var8 = ((syx)var2.get(0)).syz;
            int var9 = var3 - 6;
            int var10 = var5 - var9 + 1;
            double[] var11 = new double[var10];
            double[] var12 = new double[var10];
            int var13 = 0;

            for (int var14 = 0; var14 < var10; var14++) {
               int var15 = var9 + var14;

               while (var13 < var2.size() - 1 && ((syx)var2.get(var13)).syy < var15) {
                  var13++;
               }

               syx var16 = (syx)var2.get(var13);
               syx var17 = var13 > 0 ? (syx)var2.get(var13 - 1) : null;
               if (var17 != null && var15 < var16.syy) {
                  double var18 = (double)(var15 - var17.syy) / (var16.syy - var17.syy);
                  var11[var14] = var17.sza + (var16.sza - var17.sza) * var18;
                  var12[var14] = var17.szb + (var16.szb - var17.szb) * var18;
               } else {
                  var11[var14] = var16.sza;
                  var12[var14] = var16.szb;
               }
            }

            tbm var26 = new tbm();
            double[] var27 = new double[var10];
            double[] var28 = new double[var10];
            double[] var29 = new double[var10];
            double[] var30 = new double[var10];
            double[][] var19 = new double[var10][];

            for (int var20 = 0; var20 < var10; var20++) {
               tme var21 = (tme)var7.get(var9 + var20);
               int var22 = var21.indexOf(var8);
               if (var22 < 0) {
                  return;
               }

               float[] var23 = var21.boxes;
               if (!tbp.aim(
                  var21.eyeX,
                  var21.eyeY,
                  var21.eyeZ,
                  var23[var22 * 5],
                  var23[var22 * 5 + 1],
                  var23[var22 * 5 + 2],
                  var23[var22 * 5 + 3],
                  var23[var22 * 5 + 4],
                  var11[var20],
                  var12[var20],
                  var26
               )) {
                  return;
               }

               var27[var20] = var26.yaw;
               var28[var20] = var26.pitch;
               var29[var20] = tbp.wrap(var26.yaw - var21.yaw);
               var30[var20] = var26.pitch - var21.pitch;
               var19[var20] = new double[]{var26.bw, var26.bh, var26.la, var26.ra, var26.ta, var26.ba, var26.dist};
            }

            double[] var31 = szy(var7, var9, var6, var11, var12, var27, var28, var29, var30, var19);
            boolean[] var32 = new boolean[var6 + 1];
            if (var4) {
               this.stats.overshoots = this.stats.overshoots + overshoots(var31, var6, var32);
            }

            int[] var33 = new int[var2.size()];

            for (int var34 = 0; var34 < var2.size(); var34++) {
               var33[var34] = ((syx)var2.get(var34)).syy - var3;
            }

            this.tad(var31, var6, var33, var32);
            int var35 = -1;

            for (int var24 = 0; var24 <= var6 + 1; var24++) {
               boolean var25 = var24 <= var6 && !var32[var24];
               if (var25 && var35 < 0) {
                  var35 = var24;
               } else if (!var25 && var35 >= 0) {
                  this.tac(var31, var35, var24 - 1, var2, var33, this.szp);
                  var35 = -1;
               }
            }
         }
      }
   }

   private void tac(double[] var1, int var2, int var3, List<syx> var4, int[] var5, int var6) {
      int var7 = var3 - var2;
      if (var7 >= var6) {
         byte var8 = 32;
         double[] var9 = new double[(var7 + 1) * var8];
         System.arraycopy(var1, var2 * var8, var9, 0, var9.length);
         ArrayList var10 = new ArrayList();

         for (int var11 = 0; var11 < var5.length; var11++) {
            int var12 = var5[var11] - var2;
            if (var12 >= 1 && var12 <= var7) {
               var10.add(var12);
               this.aimPoints.add(new double[]{((syx)var4.get(var11)).sza, ((syx)var4.get(var11)).szb});
            }
         }

         int[] var13 = new int[var10.size()];

         for (int var14 = 0; var14 < var13.length; var14++) {
            var13[var14] = (Integer)var10.get(var14);
         }

         this.segments.add(new sze(var7, var9, var13, false, this.szo));
         this.stats.usedHits += var13.length;
         this.stats.steps += var7;
         this.stats.segments++;
      }
   }

   private void tad(double[] var1, int var2, int[] var3, boolean[] var4) {
      byte var5 = 32;
      int var6 = 0;

      for (int var10 : var3) {
         double var11 = 0.0;
         boolean var13 = true;

         for (int var14 = var6; var14 < var10 && var14 <= var2; var14++) {
            var11 = Math.max(var11, Math.hypot(var1[var14 * var5 + 0], var1[var14 * var5 + 1]));
            var13 &= !var4[var14];
         }

         if (var13 && var11 >= 20.0) {
            this.stats.flicks++;
         }

         var6 = var10;
      }

      for (int var15 = 0; var15 < var2; var15++) {
         if (!var4[var15]) {
            int var16 = var15 * var5;
            double var17 = Math.hypot(var1[var16 + 0], var1[var16 + 1]);
            double var18 = Math.hypot(var1[var16 + var5 + 6], var1[var16 + var5 + 7]);
            if (var17 < 2.5 * var1[var16 + 22] + 1.0 && var18 > 0.4) {
               this.stats.tracking++;
            }

            if (Math.abs(var1[var16 + var5 + 15]) > 1.5) {
               this.stats.vertical++;
            }
         }
      }
   }

   static int overshoots(double[] var0, int var1, boolean[] var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      double var8 = 0.0;
      double var10 = 0.0;
      double var12 = 0.0;
      double var14 = 0.0;

      for (int var16 = 0; var16 <= var1; var16++) {
         int var17 = var16 * 32;
         double var18 = var0[var17 + 22];
         double var20 = var0[var17 + 23];
         double var22 = -var0[var17 + 0];
         int var24 = var22 > var0[var17 + 29] + 0.25 * var18 ? 1 : (var22 < var0[var17 + 28] - 0.25 * var18 ? -1 : 0);
         double var25 = -var0[var17 + 1];
         int var27 = var25 > var0[var17 + 31] + 0.15 * var20 ? 1 : (var25 < var0[var17 + 30] - 0.15 * var20 ? -1 : 0);
         if (var16 > 0) {
            var8 += var0[var17 + 14];
            var10 += var0[var17 + 15];
            var12 += var0[var17 + 6];
            var14 += var0[var17 + 7];
         }

         boolean var28 = false;
         if (var24 != 0) {
            if (var4 != 0 && var24 != var4 && var8 * var24 > 0.0 && var8 * var24 > -var12 * var24) {
               tae(var2, var6 - 6, var16 + 2, var1);
               var28 = true;
            }

            var4 = var24;
            var6 = var16;
            var8 = 0.0;
            var12 = 0.0;
         }

         if (var27 != 0) {
            if (var5 != 0 && var27 != var5 && var10 * var27 > 0.0 && var10 * var27 > -var14 * var27) {
               tae(var2, var7 - 6, var16 + 2, var1);
               var28 = true;
            }

            var5 = var27;
            var7 = var16;
            var10 = 0.0;
            var14 = 0.0;
         }

         if (var28) {
            var3++;
         }
      }

      return var3;
   }

   private static void tae(boolean[] var0, int var1, int var2, int var3) {
      for (int var4 = Math.max(0, var1); var4 <= Math.min(var3, var2); var4++) {
         var0[var4] = true;
      }
   }

   static int overshootCount(double[] var0, int var1) {
      return overshoots(var0, var1, new boolean[var1 + 1]);
   }

   public void addMirrors() {
      int var1 = this.segments.size();

      for (int var2 = 0; var2 < var1; var2++) {
         this.segments.add(this.segments.get(var2).mirror());
      }
   }
}
