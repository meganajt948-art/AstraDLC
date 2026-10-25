package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public final class syq {
   public static final int SPEED = 0;
   public static final int ACCEL = 1;
   public static final int JERK = 2;
   public static final int ERROR = 3;
   public static final int SMOOTH = 4;
   public static final int OVERSHOOT = 5;
   public static final int PARTS = 6;
   public static final double STEP_CAP = 30.0;
   public static final int SIM_X = 0;
   public static final int SIM_Y = 1;
   public static final int CEIL_X = 2;
   public static final int CEIL_Y = 3;
   public static final int PARTS_X = 4;
   public static final int PARTS_Y = 10;
   public static final int OVER_USER_X = 16;
   public static final int OVER_MODEL_X = 17;
   public static final int OVER_USER_Y = 18;
   public static final int OVER_MODEL_Y = 19;
   public static final int REACTION = 20;
   public static final int PACKED = 21;

   static float[] pack(syk var0, syk var1, double var2) {
      float[] var4 = new float[21];
      var4[16] = (float)var0.overA[0];
      var4[17] = (float)var0.overB[0];
      var4[18] = (float)var0.overA[1];
      var4[19] = (float)var0.overB[1];
      var4[20] = (float)var2;
      var4[0] = (float)var0.simX;
      var4[1] = (float)var0.simY;
      var4[2] = var1 == null ? Float.NaN : (float)var1.simX;
      var4[3] = var1 == null ? Float.NaN : (float)var1.simY;

      for (int var5 = 0; var5 < 6; var5++) {
         var4[4 + var5] = (float)(var0.x[var5] * 100.0);
         var4[10 + var5] = (float)(var0.y[var5] * 100.0);
      }

      return var4;
   }

   private syq() {
   }

   static syn user(List<tmn> var0) {
      syn var1 = new syn();
      var1.episodes = var0;
      byte var2 = 32;

      for (tmn var4 : var0) {
         double[] var5 = var4.seg().st;
         int var6 = var4.to() - var4.from();
         double[] var7 = new double[var6];
         double[] var8 = new double[var6];
         double[] var9 = new double[var6];
         double[] var10 = new double[var6];

         for (int var11 = 0; var11 < var6; var11++) {
            int var12 = (var4.from() + var11 + 1) * var2;
            var7[var11] = var5[var12 + 14];
            var8[var11] = var5[var12 + 15];
            var9[var11] = var5[var12 + 0];
            var10[var11] = var5[var12 + 1];
         }

         var1.dx.add(var7);
         var1.dy.add(var8);
         var1.ex.add(var9);
         var1.ey.add(var10);
      }

      return var1;
   }

   static syn model(tck var0, List<tmn> var1, Random var2, taf var3) {
      syn var4 = new syn();
      var4.episodes = var1;
      double var5 = var0.turnCap > 0.0F ? var0.turnCap : 30.0;
      tai var7 = new tai(var0, var2);
      byte var8 = 32;
      double[] var9 = new double[var8];
      double[] var10 = new double[2];

      for (tmn var12 : var1) {
         double[] var13 = var12.seg().st;
         int var14 = var12.from();
         int var15 = var12.to() - var14;
         double var16 = var12.seg().unit > 0.0 ? var12.seg().unit : (var0.unit > 0.0F ? var0.unit : 0.0);
         var7.reset();

         for (int var18 = 3; var18 >= 0; var18--) {
            var7.history(var13[var14 * var8 + 14 + var18 * 2], var13[var14 * var8 + 15 + var18 * 2]);
         }

         var7.prime(var13[var14 * var8 + 14], var13[var14 * var8 + 15]);
         tmz var39 = new tmz(var15);
         var39.ex[0] = var13[var14 * var8 + 0];
         var39.ey[0] = var13[var14 * var8 + 1];
         double var19 = 0.0;
         double var21 = 0.0;
         double[] var23 = new double[var15];
         double[] var24 = new double[var15];
         double[] var25 = new double[var15];
         double[] var26 = new double[var15];

         for (int var27 = 0; var27 < var15; var27++) {
            int var28 = var14 + var27;
            var39.state(var12.seg(), var14, var27, var9);
            var7.step(var9, var3, var10);
            double var29 = var10[0];
            double var31 = var10[1];
            double var33 = Math.hypot(var29, var31);
            if (var33 > var5) {
               var29 *= var5 / var33;
               var31 *= var5 / var33;
            }

            if (var16 > 0.0) {
               var19 += var29 / var16;
               var21 += var31 / var16;
               long var35 = (long)var19;
               long var37 = (long)var21;
               var19 -= var35;
               var21 -= var37;
               var29 = var35 * var16;
               var31 = var37 * var16;
            }

            var7.history(var29, var31);
            int var42 = (var28 + 1) * var8;
            var39.ex[var27 + 1] = var39.ex[var27] + var13[var42 + 6] - var29;
            var39.ey[var27 + 1] = var39.ey[var27] + var13[var42 + 7] - var31;
            var23[var27] = var29;
            var24[var27] = var31;
            var25[var27] = var39.ex[var27 + 1];
            var26[var27] = var39.ey[var27 + 1];
         }

         var4.dx.add(var23);
         var4.dy.add(var24);
         var4.ex.add(var25);
         var4.ey.add(var26);
      }

      return var4;
   }

   static syk compare(syn var0, syn var1) {
      syk var2 = new syk();
      syt(var0.dx, var0.ex, var1.dx, var1.ex, var2.x);
      syt(var0.dy, var0.ey, var1.dy, var1.ey, var2.y);

      for (int var3 = 0; var3 < 2; var3++) {
         syh var4 = overshoots(var0, var0.episodes, var3 == 1);
         syh var5 = overshoots(var1, var1.episodes, var3 == 1);
         (var3 == 0 ? var2.x : var2.y)[5] = overshootMatch(var4, var5);
         var2.overA[var3] = var4.rate();
         var2.overB[var3] = var5.rate();
      }

      var2.simX = syu(var2.x) * 100.0;
      var2.simY = syu(var2.y) * 100.0;
      return var2;
   }

   private static void syt(List<double[]> var0, List<double[]> var1, List<double[]> var2, List<double[]> var3, double[] var4) {
      var4[0] = 1.0 - ks(diff(var0, 0), diff(var2, 0));
      var4[1] = 1.0 - ks(diff(var0, 1), diff(var2, 1));
      var4[2] = 1.0 - ks(diff(var0, 2), diff(var2, 2));
      var4[3] = 1.0 - ks(diff(var1, 0), diff(var3, 0));
      var4[4] = 1.0 - Math.min(1.0, Math.abs(autocorr(var0) - autocorr(var2)));
   }

   private static double syu(double[] var0) {
      double var1 = 0.0;

      for (double var6 : var0) {
         var1 += var6;
      }

      return var1 / var0.length;
   }

   static syh overshoots(syn var0, List<tmn> var1, boolean var2) {
      syh var3 = new syh();
      byte var4 = 32;
      int var5 = var2 ? 30 : 28;
      int var6 = var2 ? 31 : 29;
      int var7 = var2 ? 23 : 22;
      int var8 = var2 ? 7 : 6;
      double var9 = var2 ? 0.15 : 0.25;

      for (int var11 = 0; var11 < var1.size(); var11++) {
         tmn var12 = (tmn)var1.get(var11);
         double[] var13 = var12.seg().st;
         double[] var14 = var2 ? var0.dy.get(var11) : var0.dx.get(var11);
         double[] var15 = var2 ? var0.ey.get(var11) : var0.ex.get(var11);
         int var16 = 0;
         double var17 = 0.0;
         double var19 = 0.0;
         int var21 = 0;
         double var22 = 0.0;

         for (int var24 = 0; var24 < var14.length; var24++) {
            int var25 = (var12.from() + var24 + 1) * var4;
            double var26 = -var15[var24];
            double var28 = var9 * var13[var25 + var7];
            double var30 = var26 - var13[var25 + var6];
            double var32 = var13[var25 + var5] - var26;
            int var34 = var30 > var28 ? 1 : (var32 > var28 ? -1 : 0);
            var17 += var14[var24];
            var19 += var13[var25 + var8];
            if (var21 != 0) {
               if (var34 == var21) {
                  var22 = Math.max(var22, var21 > 0 ? var30 : var32);
               } else {
                  var3.depth.add(var22);
                  var21 = 0;
               }
            }

            if (var34 != 0) {
               if (var16 != 0 && var34 != var16 && var17 * var34 > 0.0 && var17 * var34 > -var19 * var34) {
                  var3.events++;
                  var21 = var34;
                  var22 = var34 > 0 ? var30 : var32;
               }

               var16 = var34;
               var17 = 0.0;
               var19 = 0.0;
            }

            var3.ticks++;
         }

         if (var21 != 0) {
            var3.depth.add(var22);
         }
      }

      return var3;
   }

   static double overshootMatch(syh var0, syh var1) {
      double var2 = var0.rate();
      double var4 = var1.rate();
      if (var2 + var4 < 1.0E-9) {
         return 1.0;
      } else {
         double var6 = 1.0 - Math.abs(var2 - var4) / Math.max(1.0, Math.max(var2, var4));
         return var0.depth.size() >= 20 && var1.depth.size() >= 20 ? 0.5 * var6 + 0.5 * (1.0 - ks(syv(var0.depth), syv(var1.depth))) : var6;
      }
   }

   private static double[] syv(List<Double> var0) {
      double[] var1 = new double[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (Double)var0.get(var2);
      }

      return var1;
   }

   public static double[] overshootRates(List<tmh> var0) {
      if (var0.isEmpty()) {
         return new double[]{Double.NaN, Double.NaN};
      } else {
         List var1 = tnl.windows(szk.track(var0, false).segments);
         syn var2 = user(var1);
         return new double[]{overshoots(var2, var1, false).rate(), overshoots(var2, var1, true).rate()};
      }
   }

   public static double instantShare(List<tmh> var0) {
      List var1 = szk.track(var0, false).reactions;
      return var1.isEmpty() ? Double.NaN : (double)var1.stream().filter(var0x -> var0x == 0).count() / var1.size();
   }

   public static double medianReaction(List<tmh> var0) {
      ArrayList var1 = new ArrayList<>(szk.track(var0, false).reactions);
      var1.removeIf(var0x -> var0x == 0);
      if (var1.isEmpty()) {
         return Double.NaN;
      } else {
         var1.sort(Integer::compare);
         return ((Integer)var1.get(var1.size() / 2)).intValue();
      }
   }

   public static List<String> report(List<double[]> var0, List<double[]> var1, List<tmh> var2) {
      ArrayList var3 = new ArrayList();
      int var4 = 0;

      for (double[] var6 : var0) {
         var4 += var6.length;
      }

      var3.add(
         String.format(
            Locale.ROOT,
            a.d("괱풔幀쀢䮮촅睓ﻣ惸\uea1b淏鞥\u196f肁\u0ade谪㘤릱⍖ꔚ⳧嚾\ud815䎗어伹\uf68f碈\ue22c搡\uefceᄚ鬃", -377087728, -1282296735),
            var0.size(),
            var4,
            syw(a.c(1715259284, "쟍"), var0),
            syw(a.d("궳", 436902196, -1673972513), var1)
         )
      );
      if (!var2.isEmpty() && var4 != 0) {
         syn var16 = user(tnl.windows(szk.track(var2, false).segments));
         var3.add(
            String.format(
               Locale.ROOT,
               a.b("ⱘ嗿\udf36䄈쫅䱴\uf622羒\ue189歬\ueca2ᛙ順Ư讯ം뜑㣅ꈠ␢궉힄夲습", -35247047),
               var16.ticks(),
               syw(a.d("Ľ", 1722480478, -2045905350), var16.dx),
               syw(a.d("摩", -1433825593, -955979018), var16.dy)
            )
         );
         String[] var17 = new String[]{a.b("萾ﶎ睔\ue93d拿", -62880673), a.b("鏜\uea6f悼ﻋ甕", 122524600), a.d("逷\ue989捍ﴥ", -834603568, -367696503)};

         for (int var7 = 0; var7 < 2; var7++) {
            List var8 = var7 == 0 ? var0 : var1;
            List var9 = var7 == 0 ? var16.dx : var16.dy;
            StringBuilder var10 = new StringBuilder(var7 == 0 ? a.d("煼ࣗ舀ᱵ鞧ᄛ꭛⊱볳㙏뇅䯌앹", 2121955335, -1141438203) : a.c(-818314366, "菼練炀\ueef5攧\ue39b姛퀱乳쓏䍅륍㟹"));
            double var11 = 0.0;

            for (int var13 = 0; var13 < 3; var13++) {
               double var14 = 100.0 * (1.0 - ks(diff(var8, var13), diff(var9, var13)));
               var11 += var14;
               var10.append(String.format(Locale.ROOT, a.c(-1940587211, "ﴝ蒩ฬ逎ᯜ鵦✫꺌"), var17[var13], var14));
            }

            double var19 = 100.0 * (1.0 - Math.min(1.0, Math.abs(autocorr(var8) - autocorr(var9))));
            var11 += var19;
            var10.append(String.format(Locale.ROOT, a.c(-1268091095, "眝\u0eff萲ᩁ醖\u173c굳Ⓤ몐〪럧䷀썑嫭킭噂\uec08插量罸"), var19, var11 / 4.0));
            var3.add(var10.toString());
         }

         return var3;
      } else {
         return var3;
      }
   }

   public static double[] onTarget(List<tmh> var0) {
      if (var0.isEmpty()) {
         return new double[]{0.0, 0.0};
      } else {
         byte var1 = 32;
         int var2 = 0;
         int var3 = 0;

         for (sze var5 : szk.track(var0, false).segments) {
            for (int var6 = 1; var6 <= var5.m; var6++) {
               int var7 = var6 * var1;
               double var8 = -var5.st[var7 + 0];
               double var10 = -var5.st[var7 + 1];
               var2++;
               if (var8 >= var5.st[var7 + 28] && var8 <= var5.st[var7 + 29] && var10 >= var5.st[var7 + 30] && var10 <= var5.st[var7 + 31]) {
                  var3++;
               }
            }
         }

         return new double[]{var2 == 0 ? 0.0 : (double)var3 / var2, var2};
      }
   }

   private static String syw(String var0, List<double[]> var1) {
      double[] var2 = diff(var1, 0);
      double[] var3 = diff(var1, 1);
      if (var2.length == 0) {
         return var0 + a.b("復☕", -1287299189);
      } else {
         Arrays.sort(var2);
         Arrays.sort(var3);
         int var4 = 0;

         for (double var8 : var2) {
            if (var8 < 0.001) {
               var4++;
            }
         }

         return String.format(
            Locale.ROOT,
            a.c(-1877163923, "쀏맨㍨굅⚊ꀣᨬ鎐\u0dc7蝷à杖瑈\uede5柢\ue155孊퓒乨젩䇛㮁딮⺫ꢒ∓鯩ᖸ轖ं芺籷\uf66c濗\ue988捣\udcab囍퀃䧽쎧뵝㜐냷⩣ꐒ᷈靵ᅦ說ӛ︊瞢\uf1af欑\ue548延\ud863刕쯏䕤㽡룔㋕걓◫龨ᥜ錀ಭ蘪"),
            var0,
            var2[var2.length / 2],
            var2[(int)(var2.length * 0.9)],
            var2[(int)(var2.length * 0.99)],
            100.0 * var4 / var2.length,
            var3.length == 0 ? 0.0 : var3[var3.length / 2],
            var3.length == 0 ? 0.0 : var3[(int)(var3.length * 0.9)]
         );
      }
   }

   static double[] diff(List<double[]> var0, int var1) {
      int var2 = 0;

      for (double[] var4 : var0) {
         var2 += Math.max(0, var4.length - var1);
      }

      double[] var10 = new double[var2];
      int var11 = 0;

      for (double[] var6 : var0) {
         for (int var7 = var1; var7 < var6.length; var7++) {
            double var8 = switch (var1) {
               case 0 -> var6[var7];
               case 1 -> var6[var7] - var6[var7 - 1];
               default -> var6[var7] - 2.0 * var6[var7 - 1] + var6[var7 - 2];
            };
            var10[var11++] = Math.abs(var8);
         }
      }

      return var10;
   }

   static double autocorr(List<double[]> var0) {
      double var1 = 0.0;
      double var3 = 0.0;

      for (double[] var6 : var0) {
         double var7 = 0.0;

         for (double var12 : var6) {
            var7 += var12;
         }

         var7 /= Math.max(1, var6.length);

         for (int var15 = 0; var15 < var6.length; var15++) {
            double var16 = var6[var15] - var7;
            var3 += var16 * var16;
            if (var15 > 0) {
               var1 += var16 * (var6[var15 - 1] - var7);
            }
         }
      }

      return var3 > 0.0 ? var1 / var3 : 0.0;
   }

   static double ks(double[] var0, double[] var1) {
      if (var0.length != 0 && var1.length != 0) {
         var0 = (double[])var0.clone();
         var1 = (double[])var1.clone();
         Arrays.sort(var0);
         Arrays.sort(var1);
         int var2 = 0;
         int var3 = 0;

         double var4;
         for (var4 = 0.0; var2 < var0.length && var3 < var1.length; var4 = Math.max(var4, Math.abs((double)var2 / var0.length - (double)var3 / var1.length))) {
            double var6 = Math.min(var0[var2], var1[var3]);

            while (var2 < var0.length && var0[var2] <= var6 + 0.001) {
               var2++;
            }

            while (var3 < var1.length && var1[var3] <= var6 + 0.001) {
               var3++;
            }
         }

         return var4;
      } else {
         return 1.0;
      }
   }
}
