package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public final class tzy {
   public static final int MIN_SAMPLES = 2400;
   static final int tzz = 128;
   static final double uaa = 0.002;
   static final double uab = 2.0E-4;
   static final double uac = 1.0E-4;
   static final double uad = 5.0;
   static final double uae = 0.6;
   static final double uaf = 0.4;
   static final double uag = 0.8;
   static final double uah = 0.5;
   static final double uai = 2.0;
   static final int uaj = 30;
   static final int uak = 3;
   static final double ual = 0.2;
   static final int uam = txl.N;
   static final int uan = 15;
   static final double[] uao = new double[]{0.8, 0.6, 0.8, 0.6, 0.3};
   static final double[] uap = new double[]{0.5, 0.65, 0.8, 1.0};
   static final double[] uaq = new double[]{0.0, 0.25, 0.5, 0.75, 1.0};

   tzy() {
   }

   static boolean uat(tzp var0, tzp var1) {
      if ((var0.flags & 1) != 0 && (var1.flags & 1) != 0 && (var1.flags & 4) == 0) {
         if (Math.abs(tvt.wrap(var1.yaw - var0.yaw)) > 90.0) {
            return false;
         }

         double var2 = var1.x - var0.x;
         double var4 = var1.y - var0.y;
         double var6 = var1.z - var0.z;
         return var2 * var2 + var4 * var4 + var6 * var6 < 6.25;
      } else {
         return false;
      }
   }

   public static tzv build(List<tzs> var0, tmw var1, txp var2) {
      tzv var3 = new tzv();
      double[] var4 = new double[uam];
      txi var5 = new txi();
      int var6 = 0;
      double var7 = 0.0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;
      int var13 = 0;
      ArrayList var14 = new ArrayList();
      double var15 = 0.0;
      double var17 = 0.0;
      double var19 = 0.0;
      HashSet var21 = new HashSet();

      for (tzs var23 : var0) {
         int var24 = var23.ticks.size();
         HashMap var25 = new HashMap();
         boolean[] var26 = new boolean[var24];

         for (int var27 = 1; var27 < var24; var27++) {
            var26[var27] = uat(var23.ticks.get(var27 - 1), var23.ticks.get(var27));
         }

         int var57 = -2;
         tzg var28 = null;
         int var29 = 0;
         int var30 = -1;
         byte var31 = 0;
         byte var32 = 0;
         int var33 = 20;
         boolean var34 = false;

         for (int var35 = 0; var35 + 1 < var24; var35++) {
            if (var1 != null && var1.cancel) {
               throw new tmt(a.c(1641659805, "뷸쑋亗탫嬺\udd82"));
            }

            tzp var36 = var23.ticks.get(var35);
            tzp var37 = var23.ticks.get(var35 + 1);
            if (!var26[var35]) {
               var33 = 20;
               var31 = 0;
               var32 = 0;
               var34 = false;
            }

            boolean var38 = (var36.keys & 16) != 0;
            if (var38 && !var34) {
               var33 = 0;
            } else if (var33 < 20) {
               var33++;
            }

            var34 = var38;
            if (var26[var35 + 1] && var36.route >= 0 && (var36.flags & 256) == 0 && (var37.flags & 256) == 0) {
               tvt var39 = var25.computeIfAbsent(var36.route, var1x -> var23.lanes.get(var1x).track());
               if (var39.n >= 2) {
                  if (var36.route != var30) {
                     var29 = var39.closest(var36.x, var36.y, var36.z, 0, 0, var39.n);
                     var30 = var36.route;
                  } else {
                     var29 = var39.closest(var36.x, var36.y, var36.z, var29, 8, 60);
                  }

                  double var40 = var39.project(var36.x, var36.z, var29);
                  double var42 = var39.offset(var36.x, var36.z, var40);
                  if (!(var42 > 3.0)) {
                     double var44 = tvt.wrap(var37.yaw - var36.yaw);
                     double var46 = var37.pitch - var36.pitch;
                     double var48 = Math.hypot(var36.vx, var36.vz);
                     boolean var50 = var36.keys == 0 && var37.keys == 0 && Math.abs(var44) < 0.05 && Math.abs(var46) < 0.05 && var48 < 0.01;
                     var31 = (byte)(var50 ? var31 + 1 : 0);
                     if (var31 <= 30) {
                        boolean var51 = (var36.keys & 15) == 0 && var48 < 0.02;
                        var32 = (byte)(var51 ? var32 + 1 : 0);
                        if (!var51 || (var37.keys & 15) != 0 || var32 <= 3 || !(Math.abs(var44) < 1.5) || !(var39.length() - var40 > 1.2)) {
                           if (var36.snap != var57) {
                              var57 = var36.snap;
                              var28 = var23.snap(var36.snap);
                           }

                           var5.x = var36.x;
                           var5.y = var36.y;
                           var5.z = var36.z;
                           var5.yaw = var36.yaw;
                           var5.pitch = var36.pitch;
                           var5.vx = var36.vx;
                           var5.vy = var36.vy;
                           var5.vz = var36.vz;
                           var5.ground = (var36.flags & 2) != 0;
                           var5.water = (var36.flags & 32) != 0;
                           var5.climb = (var36.flags & 64) != 0;
                           var5.collide = (var36.flags & 128) != 0;
                           var5.sprinting = (var36.flags & 8) != 0;
                           var5.speed = var36.speed > 0.0F ? var36.speed : 0.1;
                           tzp var52 = var35 >= 1 ? var23.ticks.get(var35 - 1) : null;
                           tzp var53 = var35 >= 2 ? var23.ticks.get(var35 - 2) : null;
                           var5.dyaw1 = var26[var35] && var52 != null ? tvt.wrap(var36.yaw - var52.yaw) : 0.0;
                           var5.dpitch1 = var26[var35] && var52 != null ? var36.pitch - var52.pitch : 0.0;
                           var5.dyaw2 = var26[var35] && var35 >= 2 && var26[var35 - 1] ? tvt.wrap(var52.yaw - var53.yaw) : 0.0;
                           var5.dpitch2 = var26[var35] && var35 >= 2 && var26[var35 - 1] ? var52.pitch - var53.pitch : 0.0;
                           var5.sinceJump = var33;
                           txl.features(var5, var39, var29, var28, var4, 0);
                           int var54 = tzs.move(var37.keys);
                           boolean var55 = (var37.keys & 16) != 0;
                           boolean var56 = (var37.flags & 8) != 0;
                           var3.add(var4, var54, var55, var56, var44, var46, var6 * 100000 + var35 / 200);
                           var21.add((long)var6 << 32 | var36.route);
                           var19 += Math.hypot(var37.x - var36.x, var37.z - var36.z);
                           var17 += var42;
                           var15 += var36.pitch;
                           if (var55 && (var36.keys & 16) == 0) {
                              var13++;
                           }

                           if (var54 != 0) {
                              var10++;
                              if (var56) {
                                 var11++;
                              }

                              if (txv.LEFT[var54] != 0) {
                                 var12++;
                              }

                              if (var5.ground && var48 > 0.05) {
                                 var7 += var48;
                                 var9++;
                              }
                           }

                           if (Math.abs(var44) > 0.5) {
                              var14.add(Math.abs(var44));
                           }
                        }
                     }
                  }
               }
            }
         }

         var6++;
      }

      if (var2 != null) {
         var2.seconds = var3.n / 20.0F;
         var2.meters = (float)var19;
         var2.routes = var21.size();
         var2.speed = var9 == 0 ? 0.0F : (float)(var7 / var9 * 20.0);
         var2.sprintShare = var10 == 0 ? 0.0F : (float)var11 / var10;
         var2.strafeShare = var10 == 0 ? 0.0F : (float)var12 / var10;
         var2.jumpsPerMin = var3.n == 0 ? 0.0F : (float)(var13 / (var3.n / 1200.0));
         var2.turnMedian = (float)quantile(var14, 0.5);
         var2.turnP99 = (float)quantile(var14, 0.99);
         var2.pitchMean = var3.n == 0 ? 0.0F : (float)(var15 / var3.n);
         var2.lateralMean = var3.n == 0 ? 0.0F : (float)(var17 / var3.n);
      }

      return var3;
   }

   public static txs run(List<tzs> var0, int var1, int var2, long var3, boolean var5, tmw var6) {
      var6.phase = a.d("\ue471鷅ᜃ襧", 831883060, -1041800411);
      txs var7 = new txs();
      tzv var8 = build(var0, var6, var7.style);
      if (var8.n < 2400) {
         throw new tmt(a.b("또쾢䕣", -2136820107));
      }

      Random var9 = new Random(var3);
      boolean[] var10 = new boolean[var8.n];
      HashMap var11 = new HashMap();

      for (int var12 = 0; var12 < var8.n; var12++) {
         var10[var12] = var11.computeIfAbsent(var8.block[var12], var1x -> var9.nextDouble() < 0.15);
      }

      ArrayList var49 = new ArrayList();
      ArrayList var13 = new ArrayList();

      for (int var14 = 0; var14 < var8.n; var14++) {
         (var10[var14] ? var13 : var49).add(var14);
      }

      if (var13.size() < 200 || var49.size() < 1000) {
         var13 = new ArrayList(var49);
      }

      tbx var50 = new tbx(uam, var1, var1, txv.OUT);
      txv var15 = new txv(var50);
      boolean[] var16 = uay(var8, var49, var15);
      var50.init(var9, uau(var8, var49));

      for (int var17 = 0; var17 < uam; var17++) {
         if (var16[var17]) {
            for (int var18 = 0; var18 < var50.h1; var18++) {
               var50.p[var18 * uam + var17] = 0.0;
            }
         }
      }

      double[] var51 = new double[var50.size()];
      double[] var52 = new double[var50.size()];
      double[] var19 = new double[var50.size()];
      double[] var20 = (double[])var50.p.clone();
      double var21 = Double.POSITIVE_INFINITY;
      int var23 = 0;
      int var24 = 0;
      int[] var25 = var49.stream().mapToInt(Integer::intValue).toArray();
      int var26 = var2 * Math.max(1, (var25.length + 128 - 1) / 128);
      double[] var27 = new double[uam];
      double[] var28 = new double[uam];
      double[] var29 = new double[uam];
      double[] var30 = new double[var50.h1];
      double[] var31 = new double[var50.h2];
      double[] var32 = new double[txv.OUT];
      double[] var33 = new double[txv.OUT];
      double[] var34 = new double[var50.h1];
      double[] var35 = new double[var50.h2];
      double[] var36 = new double[txv.YAW.length];
      ArrayList var37 = new ArrayList();
      var6.epochs = var2;

      for (int var38 = 0; var38 < var2; var38++) {
         if (var6.cancel) {
            throw new tmt(a.c(-979848570, "닣쭐䆌\udff0吡튙"));
         }

         var6.phase = a.c(-540564268, "꒧\udd00埞즨");
         var6.epoch = var38;
         ubb(var25, var9);

         for (short var39 = 0; var39 < var25.length; var39 += 128) {
            Arrays.fill(var51, 0.0);
            int var40 = Math.min(var25.length, var39 + 128);
            double var41 = 0.0;

            for (int var43 = var39; var43 < var40; var43++) {
               int var44 = var25[var43];
               uaz(var8, var44, var27);
               int var45 = var8.move[var44];
               int var46 = var8.yaw[var44];
               if (var5 && var9.nextBoolean()) {
                  txl.mirror(var27, 0, var28, 0);
                  System.arraycopy(var28, 0, var27, 0, uam);
                  var45 = txv.MIRROR[var45];
                  var46 = txv.YAW.length - 1 - var46;
               }

               if (var9.nextDouble() < 0.2) {
                  var27[txl.I_VF] = 0.0;
                  var27[txl.I_VL] = 0.0;
                  var27[txl.I_HS] = 0.0;
                  var27[txl.I_SPRINT] = 0.0;
               }

               var27[txl.I_DYAW1] = var27[txl.I_DYAW1] + var9.nextGaussian() * 0.04;
               var27[txl.I_DYAW2] = var27[txl.I_DYAW2] + var9.nextGaussian() * 0.04;
               var27[txl.I_DPITCH1] = var27[txl.I_DPITCH1] + var9.nextGaussian() * 0.04;
               var27[txl.I_DPITCH2] = var27[txl.I_DPITCH2] + var9.nextGaussian() * 0.04;
               var15.normalize(var27, 0, var29);
               var50.forward(var29, var30, var31, var32);
               var41++;
               uav(var32, var45, var8.jump[var44], var8.sprint[var44], var46, var8.pitch[var44], var33, var36);
               var50.backward(var29, var30, var31, var33, var51, null, var34, var35);
            }

            if (!(var41 <= 0.0)) {
               double var56 = 0.0;

               for (int var58 = 0; var58 < var51.length; var58++) {
                  var51[var58] /= var41;
                  var56 += var51[var58] * var51[var58];
               }

               var56 = Math.sqrt(var56);
               if (var56 > 5.0) {
                  for (int var59 = 0; var59 < var51.length; var59++) {
                     var51[var59] *= 5.0 / var56;
                  }
               }

               var24++;
               double var60 = Math.min(1.0, var24 / 100.0);
               double var47 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)var24 / var26)));
               uba(var50.p, var51, var52, var19, var24, (2.0E-4 + 0.0018 * var47) * var60);
            }
         }

         double var54 = uax(var8, var13, var15, null, var9, uao);
         var37.add((float)var54);
         var6.curve = ubc(var37);
         if (var54 < var21 - 1.0E-4) {
            var21 = var54;
            System.arraycopy(var50.p, 0, var20, 0, var20.length);
            var23 = 0;
         } else if (var38 >= 6) {
            if (++var23 >= 5) {
               break;
            }
         }
      }

      System.arraycopy(var20, 0, var50.p, 0, var20.length);
      var6.phase = a.d("ၺ槀\ue31e絩\uf6b6", 426022683, 3442439);
      double[] var53 = uaw(var8, var13, var15, var3);
      var7.yawTemp = var53[0];
      var7.yawJitter = var53[1];
      var7.pitchTemp = var53[2];
      var7.pitchJitter = var53[3];
      var7.jumpThreshold = var53[4];
      double[] var55 = new double[8];
      uax(var8, var13, var15, var55, new Random(var3 ^ 25214903917L), var53);
      var7.net = var15;
      var7.samples = var8.n;
      var7.valSamples = var13.size();
      var7.keysAcc = var55[0];
      var7.keysBase = var55[1];
      var7.jumpAcc = var55[2];
      var7.sprintAcc = var55[3];
      var7.yawSim = var55[4];
      var7.pitchSim = var55[5];
      var7.yawCeil = var55[6];
      var7.modelJumps = var55[7];
      var7.created = System.currentTimeMillis();
      var6.phase = a.d("쯕뉫㢿ꛉⴄꮮ", 1904144018, 497165607);
      return var7;
   }

   static double[] uau(tzv var0, List<Integer> var1) {
      double[] var2 = new double[txv.OUT];
      double[] var3 = new double[9];
      double[] var4 = new double[txv.YAW.length];
      double[] var5 = new double[txv.PITCH.length];
      double var6 = 0.0;
      double var8 = 0.0;

      for (int var11 : var1) {
         var3[var0.move[var11]]++;
         var4[var0.yaw[var11]]++;
         var5[var0.pitch[var11]]++;
         if (var0.jump[var11]) {
            var6++;
         }

         if (var0.sprint[var11]) {
            var8++;
         }
      }

      double var16 = Math.max(1, var1.size());

      for (int var12 = 0; var12 < 9; var12++) {
         var2[var12] = Math.log((var3[var12] + 1.0) / (var16 + 9.0));
      }

      for (int var17 = 0; var17 < var4.length; var17++) {
         var2[11 + var17] = Math.log((var4[var17] + 1.0) / (var16 + var4.length));
      }

      for (int var18 = 0; var18 < var5.length; var18++) {
         var2[txv.PITCH0 + var18] = Math.log((var5[var18] + 1.0) / (var16 + var5.length));
      }

      double var19 = (var6 + 1.0) / (var16 + 2.0);
      double var14 = (var8 + 1.0) / (var16 + 2.0);
      var2[9] = Math.log(var19 / (1.0 - var19));
      var2[10] = Math.log(var14 / (1.0 - var14));
      return var2;
   }

   static void uav(double[] var0, int var1, boolean var2, boolean var3, int var4, int var5, double[] var6, double[] var7) {
      Arrays.fill(var6, 0.0);
      txv.softmax(var0, 0, 9, 1.0, var7);

      for (int var8 = 0; var8 < 9; var8++) {
         var6[var8] = var7[var8] - (var8 == var1 ? 1.0 : 0.0);
      }

      double var15 = txv.sigmoid(var0[9]);
      var6[9] = 0.6 * (var2 ? 2.0 * (var15 - 1.0) : var15);
      double var10 = txv.sigmoid(var0[10]);
      var6[10] = 0.4 * (var10 - (var3 ? 1.0 : 0.0));
      int var12 = txv.YAW.length;
      txv.softmax(var0, 11, var12, 1.0, var7);

      for (int var13 = 0; var13 < var12; var13++) {
         var6[11 + var13] = 0.8 * (var7[var13] - (var13 == var4 ? 1.0 : 0.0));
      }

      int var16 = txv.PITCH.length;
      txv.softmax(var0, txv.PITCH0, var16, 1.0, var7);

      for (int var14 = 0; var14 < var16; var14++) {
         var6[txv.PITCH0 + var14] = 0.5 * (var7[var14] - (var14 == var5 ? 1.0 : 0.0));
      }
   }

   static double[] uaw(tzv var0, List<Integer> var1, txv var2, long var3) {
      tbx var5 = var2.net;
      int var6 = Math.min(var1.size(), 6000);
      double[][] var7 = new double[var6][];
      double[] var8 = new double[var6];
      boolean[] var9 = new boolean[var6];
      double[] var10 = new double[uam];
      double[] var11 = new double[uam];
      double[] var12 = new double[var5.h1];
      double[] var13 = new double[var5.h2];
      double[] var14 = new double[txv.OUT];
      ArrayList var15 = new ArrayList();
      ArrayList var16 = new ArrayList();
      int var17 = 0;

      for (int var18 = 0; var18 < var6; var18++) {
         int var19 = (Integer)var1.get(var18);
         uaz(var0, var19, var10);
         var2.normalize(var10, 0, var11);
         var5.forward(var11, var12, var13, var14);
         var7[var18] = (double[])var14.clone();
         var8[var18] = txv.sigmoid(var14[9]);
         var9[var18] = var0.jump[var19];
         if (var9[var18]) {
            var17++;
         }

         var15.add((double)Math.abs(var0.dyaw[var19]));
         var16.add((double)Math.abs(var0.dpitch[var19]));
      }

      double[] var39 = (double[])uao.clone();
      double[] var40 = new double[txv.YAW.length];

      for (int var20 = 0; var20 < 2; var20++) {
         float[] var21 = var20 == 0 ? txv.YAW : txv.PITCH;
         int var22 = var20 == 0 ? 11 : txv.PITCH0;
         double var23 = -1.0;

         for (double var28 : uap) {
            for (double var33 : uaq) {
               Random var35 = new Random(var3 ^ var20 * 131L + Math.round(var28 * 100.0) * 7L + Math.round(var33 * 100.0));
               ArrayList var36 = new ArrayList(var6);

               for (int var37 = 0; var37 < var6; var37++) {
                  var36.add(Math.abs(txv.pick(var21, var7[var37], var22, var28, var33, var40, var35)));
               }

               double var48 = 1.0 - ks(var20 == 0 ? var15 : var16, var36);
               if (var48 > var23 + 1.0E-4) {
                  var23 = var48;
                  var39[var20 * 2] = var28;
                  var39[var20 * 2 + 1] = var33;
               }
            }
         }
      }

      if (var17 == 0) {
         var39[4] = 0.5;
         return var39;
      }

      double var41 = -1.0;

      for (double var42 = 0.05; var42 <= 0.8001; var42 += 0.025) {
         int var24 = 0;
         int var43 = 0;
         int var44 = 0;

         for (int var45 = 0; var45 < var6; var45++) {
            boolean var47 = var8[var45] > var42;
            if (var47 && var9[var45]) {
               var24++;
            } else if (var47) {
               var43++;
            } else if (var9[var45]) {
               var44++;
            }
         }

         double var46 = 2.0 * var24 / Math.max(1, 2 * var24 + var43 + var44);
         if (var46 > var41 + 1.0E-6) {
            var41 = var46;
            var39[4] = var42;
         }
      }

      return var39;
   }

   static double uax(tzv var0, List<Integer> var1, txv var2, double[] var3, Random var4, double[] var5) {
      tbx var6 = var2.net;
      double[] var7 = new double[uam];
      double[] var8 = new double[uam];
      double[] var9 = new double[var6.h1];
      double[] var10 = new double[var6.h2];
      double[] var11 = new double[txv.OUT];
      double[] var12 = new double[9];
      double[] var13 = new double[txv.YAW.length];
      double[] var14 = new double[txv.PITCH.length];
      double var15 = 0.0;
      int var17 = 0;
      int[] var18 = new int[9];
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      double var24 = var5[4];
      ArrayList var26 = new ArrayList();
      ArrayList var27 = new ArrayList();
      ArrayList var28 = new ArrayList();
      ArrayList var29 = new ArrayList();

      for (int var31 : var1) {
         uaz(var0, var31, var7);
         var2.normalize(var7, 0, var8);
         var6.forward(var8, var9, var10, var11);
         txv.softmax(var11, 0, 9, 1.0, var12);
         int var32 = var0.move[var31];
         var15 -= Math.log(Math.max(1.0E-9, var12[var32]));
         int var33 = 0;

         for (int var34 = 1; var34 < 9; var34++) {
            if (var12[var34] > var12[var33]) {
               var33 = var34;
            }
         }

         if (var33 == var32) {
            var17++;
         }

         var18[var32]++;
         double var49 = txv.sigmoid(var11[9]);
         var15 -= 0.6 * (var0.jump[var31] ? Math.log(Math.max(1.0E-9, var49)) : Math.log(Math.max(1.0E-9, 1.0 - var49)));
         boolean var36 = var49 > var24;
         if (var36) {
            var23++;
         }

         if (var36 && var0.jump[var31]) {
            var19++;
         } else if (var36) {
            var20++;
         } else if (var0.jump[var31]) {
            var21++;
         }

         double var37 = txv.sigmoid(var11[10]);
         var15 -= 0.4 * (var0.sprint[var31] ? Math.log(Math.max(1.0E-9, var37)) : Math.log(Math.max(1.0E-9, 1.0 - var37)));
         if (var37 > 0.5 == var0.sprint[var31]) {
            var22++;
         }

         txv.softmax(var11, 11, txv.YAW.length, 1.0, var13);
         var15 -= 0.8 * Math.log(Math.max(1.0E-9, var13[var0.yaw[var31]]));
         txv.softmax(var11, txv.PITCH0, txv.PITCH.length, 1.0, var14);
         var15 -= 0.5 * Math.log(Math.max(1.0E-9, var14[var0.pitch[var31]]));
         if (var3 != null) {
            var26.add((double)Math.abs(var0.dyaw[var31]));
            var27.add(Math.abs(txv.pick(txv.YAW, var11, 11, var5[0], var5[1], var13, var4)));
            var28.add((double)Math.abs(var0.dpitch[var31]));
            var29.add(Math.abs(txv.pick(txv.PITCH, var11, txv.PITCH0, var5[2], var5[3], var14, var4)));
         }
      }

      int var43 = Math.max(1, var1.size());
      if (var3 != null) {
         int var44 = 0;

         for (int var35 : var18) {
            var44 = Math.max(var44, var35);
         }

         var3[0] = 100.0 * var17 / var43;
         var3[1] = 100.0 * var44 / var43;
         var3[2] = var19 + var21 == 0 ? 100.0 : 200.0 * var19 / Math.max(1, 2 * var19 + var20 + var21);
         var3[3] = 100.0 * var22 / var43;
         var3[4] = 100.0 * (1.0 - ks(var26, var27));
         var3[5] = 100.0 * (1.0 - ks(var28, var29));
         ArrayList var46 = new ArrayList();
         ArrayList var48 = new ArrayList();

         for (int var51 = 0; var51 < var26.size(); var51++) {
            (var51 % 2 == 0 ? var46 : var48).add((Double)var26.get(var51));
         }

         var3[6] = 100.0 * (1.0 - ks(var46, var48));
         var3[7] = 100.0 * var23 / var43;
      }

      return var15 / var43;
   }

   static double ks(List<Double> var0, List<Double> var1) {
      if (!var0.isEmpty() && !var1.isEmpty()) {
         double[] var2 = var0.stream().mapToDouble(Double::doubleValue).sorted().toArray();
         double[] var3 = var1.stream().mapToDouble(Double::doubleValue).sorted().toArray();
         int var4 = 0;
         int var5 = 0;

         double var6;
         for (var6 = 0.0; var4 < var2.length && var5 < var3.length; var6 = Math.max(var6, Math.abs((double)var4 / var2.length - (double)var5 / var3.length))) {
            double var8 = Math.min(var2[var4], var3[var5]);

            while (var4 < var2.length && var2[var4] <= var8) {
               var4++;
            }

            while (var5 < var3.length && var3[var5] <= var8) {
               var5++;
            }
         }

         return var6;
      } else {
         return 1.0;
      }
   }

   static boolean[] uay(tzv var0, List<Integer> var1, txv var2) {
      double[] var3 = new double[uam];
      double[] var4 = new double[uam];

      for (int var6 : var1) {
         for (int var7 = 0; var7 < uam; var7++) {
            double var8 = var0.x[var6 * uam + var7];
            var3[var7] += var8;
            var4[var7] += var8 * var8;
         }
      }

      int var12 = Math.max(1, var1.size());
      boolean[] var13 = new boolean[uam];

      for (int var14 = 0; var14 < uam; var14++) {
         double var15 = var3[var14] / var12;
         double var10 = var4[var14] / var12 - var15 * var15;
         var13[var14] = var10 < 1.0E-6;
         var2.mu[var14] = var15;
         var2.sd[var14] = var13[var14] ? 1.0 : Math.sqrt(Math.max(var10, 1.0E-4));
      }

      return var13;
   }

   static void uaz(tzv var0, int var1, double[] var2) {
      for (int var3 = 0; var3 < uam; var3++) {
         var2[var3] = var0.x[var1 * uam + var3];
      }
   }

   static void uba(double[] var0, double[] var1, double[] var2, double[] var3, int var4, double var5) {
      double var7 = 0.9;
      double var9 = 0.999;
      double var11 = 1.0 - Math.pow(var7, var4);
      double var13 = 1.0 - Math.pow(var9, var4);

      for (int var15 = 0; var15 < var0.length; var15++) {
         var2[var15] = var7 * var2[var15] + (1.0 - var7) * var1[var15];
         var3[var15] = var9 * var3[var15] + (1.0 - var9) * var1[var15] * var1[var15];
         var0[var15] -= var5 * (var2[var15] / var11 / (Math.sqrt(var3[var15] / var13) + 1.0E-8) + 1.0E-4 * var0[var15]);
      }
   }

   static void ubb(int[] var0, Random var1) {
      for (int var2 = var0.length - 1; var2 > 0; var2--) {
         int var3 = var1.nextInt(var2 + 1);
         int var4 = var0[var2];
         var0[var2] = var0[var3];
         var0[var3] = var4;
      }
   }

   static double quantile(List<Double> var0, double var1) {
      if (var0.isEmpty()) {
         return 0.0;
      }

      double[] var3 = var0.stream().mapToDouble(Double::doubleValue).sorted().toArray();
      int var4 = (int)Math.min(var3.length - 1, Math.max(0L, Math.round(var1 * (var3.length - 1))));
      return var3[var4];
   }

   static float[] ubc(List<Float> var0) {
      float[] var1 = new float[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (Float)var0.get(var2);
      }

      return var1;
   }
}
