package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class tnl {
   static final int MAX_K = 24;
   private static final int tnm = 64;
   private static final int tnn = 24000;
   private static final double tno = 10.0;
   private static final double tnp = 0.8;
   private static final double tnq = 1.5;
   private static final double tnr = 0.003;
   private static final double tns = 1.0E-4;
   private static final double tnt = 1.0E-5;
   private static final double tnu = 2.0;
   private static final int tnv = 30;
   static final int TRACK_EPISODE = 40;
   private static final int[] tnw = new int[]{2, 4};
   private static final int[] tnx = new int[]{2, 4};
   static volatile List<tmn> lastEpisodes = List.of();
   private static final int tny = 8000;
   private static final int tnz = 600;
   private static final float[] toa = new float[]{0.35F, 0.7F, 1.0F, 1.5F, 2.2F};
   private static final float[] tob = new float[]{0.6F, 0.8F, 1.0F, 1.25F, 1.5F, 1.8F, 2.2F, 2.7F, 3.2F};

   private tnl() {
   }

   public static tck run(List<tmh> var0, tmk var1, tmw var2) {
      var2.phase = a.b("烄॰莶᷒", 324563108);
      szk var3 = var1.track ? szk.track(var0, var1.dropOvershoot) : szk.build(var0, var1.dropOvershoot, var1.minWindow);
      if (var1.track ? var3.stats.steps >= 1500 : var3.stats.usedHits >= 25 && var3.stats.steps >= 250) {
         Random var4 = new Random(var1.seed);
         ArrayList var5 = new ArrayList<>(var3.segments);
         List var6 = var1.track ? windows(var5) : toe(var5);
         Collections.shuffle(var6, var4);
         ArrayList var7 = new ArrayList();
         IdentityHashMap var8 = new IdentityHashMap();
         int var9 = var6.size() >= 40 ? Math.max(6, var6.size() * 15 / 100) : 0;

         for (int var10 = 0; var10 < var9; var10++) {
            tmn var11 = (tmn)var6.get(var10);
            var7.add(var11);
            boolean[] var12 = var8.computeIfAbsent(var11.tmo, var0x -> new boolean[var0x.m + 1]);

            for (int var13 = var11.tmp; var13 < var11.tmq; var13++) {
               var12[var13] = true;
            }
         }

         Object var30 = var7.isEmpty() ? var6 : var7;
         lastEpisodes = (List<tmn>)var30;
         ArrayList var31 = new ArrayList(var5);
         if (var1.mirror) {
            for (sze var34 : var5) {
               sze var14 = var34.mirror();
               var31.add(var14);
               boolean[] var15 = (boolean[])var8.get(var34);
               if (var15 != null) {
                  var8.put(var14, var15);
               }
            }
         }

         tck var33 = new tck();
         var33.mirror = var1.mirror;
         tok(var31, var33);
         tol(var5, var33);
         var33.lag = lag(var5);
         int var35 = Math.max(1, var1.threads);
         ExecutorService var36 = Executors.newFixedThreadPool(var35, var0x -> {
            Thread var1x = new Thread(var0x, a.d("\ueaa1錺᧪螃\u0c11課ク륕✚궬⩢큜廜익䴻쯓熒﹔", -582182895, -80317724));
            var1x.setDaemon(true);
            var1x.setPriority(1);
            return var1x;
         });
         int var37 = Math.max(1, var1.members);
         var2.members = var37;
         int var16 = Math.max(4, var1.epochs);
         var2.epochs = var16;
         ArrayList var17 = new ArrayList();
         ArrayList var18 = new ArrayList();
         int var19 = 0;

         try {
            for (int var20 = 0; var20 < var37; var20++) {
               var2.member = var20;
               tbx var21 = new tbx(32, var1.hidden, var1.hidden, 4);
               var21.init(new Random(var1.seed * 31L + var20 * 7919L), new double[]{0.35, 0.35, 0.0, 0.0});
               var33.nets = new tbx[]{var21};
               var19 = Math.max(
                  var19,
                  tof(
                     var21,
                     var33,
                     var31,
                     var8,
                     (List<tmn>)var30,
                     var16,
                     var35,
                     var36,
                     new Random(var1.seed + var20 * 104729L),
                     var2,
                     var18,
                     var20 == 0,
                     var1.overshootWeight
                  )
               );
               var17.add(var21);
            }
         } catch (InterruptedException var27) {
            Thread.currentThread().interrupt();
            throw new tmt(a.d("鷦\ue455溉\uf0f5笤ﶜ", -1054527445, -221663832));
         } catch (ExecutionException var28) {
            throw new RuntimeException(var28.getCause());
         } finally {
            var36.shutdownNow();
         }

         var33.nets = var17.toArray(new tbx[0]);
         var2.phase = a.b("ꈥ\udb9b兏켹䓴쉞", -2110217659);
         var33.epochs = var19;
         var33.hits = var3.stats.usedHits;
         var33.steps = var3.stats.steps;
         var33.flicks = var3.stats.flicks;
         var33.tracking = var3.stats.tracking;
         var33.created = System.currentTimeMillis();
         double var38 = 0.0;

         for (tmh var23 : var0) {
            var38 += var23.unit;
         }

         var33.unit = var0.isEmpty() ? 0.0F : (float)(var38 / var0.size());
         too(var3, var33, var4);
         calibrate(var5, var33);
         top(var5, var33, var4);
         ArrayList var39 = new ArrayList(var6.subList(Math.min(var9, var6.size()), var6.size()));
         if (var1.track) {
            var33.kind = 1;
            ownHand(var3, var5, var33, var4);
            var2.phase = a.d("ⵛ哫\ude23䁙", 157518392, 500606739);
            tuneTexture(var33, (List<tmn>)(var39.size() > 400 ? var39.subList(0, 400) : var39), var1.seed, var2);
         } else {
            tune(var33, (List<tmn>)(var39.size() > 240 ? var39.subList(0, 240) : var39), var1.seed);
         }

         tbs.score(var33, (List<tmn>)var30, new Random(var1.seed ^ 25214903917L));
         if (var1.dropOvershoot) {
            var33.overshootUser = (double)var3.stats.overshoots / Math.max(1, var3.stats.overshoots + var3.stats.usedHits);
         }

         scoreAxes(var33, (List<tmn>)var30, var39, var1.seed);
         if (var1.track) {
            var33.similarity = var33.axisScore(0) * 0.5 + var33.axisScore(1) * 0.5;
         }

         return var33;
      } else {
         throw new tmt(a.c(112623011, "緆Ѵ躵"));
      }
   }

   static void scoreAxes(tck var0, List<tmn> var1, List<tmn> var2, long var3) {
      if (!var1.isEmpty()) {
         syn var5 = syq.user(var1);
         syk var6 = new syk();
         byte var7 = 3;

         for (int var8 = 0; var8 < var7; var8++) {
            syk var9 = syq.compare(var5, syq.model(var0, var1, new Random(var3 + 31L * var8), auraTuning()));
            var6.add(var9, 1.0 / var7);
         }

         syk var12 = var2.isEmpty() ? null : syq.compare(var5, syq.user(var2.subList(0, Math.min(var2.size(), var1.size()))));
         double var13 = Double.NaN;
         int[] var11 = Arrays.stream(var0.reactions).filter(var0x -> var0x > 0).sorted().toArray();
         if (var11.length > 0) {
            var13 = var11[var11.length / 2];
         }

         var0.axes = syq.pack(var6, var12, var13);
      }
   }

   static void ownHand(szk var0, List<sze> var1, tck var2, Random var3) {
      ArrayList var4 = new ArrayList();

      for (float[] var6 : var0.chain) {
         if (var6[2] == 0.0F || var4.isEmpty()) {
            var4.add(new ArrayList());
         }

         ((List)var4.get(var4.size() - 1)).add(var6);
      }

      Collections.shuffle(var4, var3);
      ArrayList var12 = new ArrayList();

      for (List var7 : var4) {
         if (var12.size() + var7.size() > 8000) {
            break;
         }

         var12.addAll(var7);
      }

      var2.chainU = new float[var12.size()];
      var2.chainV = new float[var12.size()];
      var2.chainGap = new int[var12.size()];

      for (int var14 = 0; var14 < var12.size(); var14++) {
         var2.chainU[var14] = ((float[])var12.get(var14))[0];
         var2.chainV[var14] = ((float[])var12.get(var14))[1];
         var2.chainGap[var14] = (int)((float[])var12.get(var14))[2];
      }

      ArrayList var15 = new ArrayList<>(var0.reactions);
      Collections.shuffle(var15, var3);
      int var16 = Math.min(600, var15.size());
      var2.reactions = new int[var16];

      for (int var8 = 0; var8 < var16; var8++) {
         var2.reactions[var8] = Math.min(255, (Integer)var15.get(var8));
      }

      ArrayList var17 = new ArrayList();

      for (sze var10 : var1) {
         for (int var11 = 1; var11 <= var10.m; var11++) {
            var17.add(Math.hypot(var10.get(var11, 14), var10.get(var11, 15)));
         }
      }

      var2.turnCap = var17.size() < 200 ? 0.0F : (float)Math.max(20.0, quantile(var17, 0.999));
   }

   static List<tmn> windows(List<sze> var0) {
      ArrayList var1 = new ArrayList();

      for (sze var3 : var0) {
         for (byte var4 = 0; var4 + 40 <= var3.m; var4 += 40) {
            var1.add(new tmn(var3, var4, var4 + 40));
         }
      }

      return var1;
   }

   private static List<tmn> toe(List<sze> var0) {
      ArrayList var1 = new ArrayList();

      for (sze var3 : var0) {
         int var4 = 0;

         for (int var8 : var3.hits) {
            int var9 = Math.max(var4, var8 - 30);
            if (var8 - var9 >= 3) {
               var1.add(new tmn(var3, var9, var8));
            }

            var4 = var8;
         }
      }

      return var1;
   }

   private static int tof(
      tbx var0,
      tck var1,
      List<sze> var2,
      Map<sze, boolean[]> var3,
      List<tmn> var4,
      int var5,
      int var6,
      ExecutorService var7,
      Random var8,
      tmw var9,
      List<Float> var10,
      boolean var11,
      double var12
   ) throws InterruptedException, ExecutionException {
      tni[] var14 = new tni[var6];

      for (int var15 = 0; var15 < var6; var15++) {
         var14[var15] = new tni(var0);
         var14[var15].lambda = var12;
      }

      double[] var48 = new double[var0.size()];
      double[] var16 = new double[var0.size()];
      double[] var17 = (double[])var0.p.clone();
      double var18 = Double.POSITIVE_INFINITY;
      int var20 = 0;
      int var21 = 0;
      int var22 = Math.max(1, Math.min(24000, toh(var2)) / 64);
      int var23 = var5 * var22;
      int var24 = 0;

      for (int var25 = 0; var25 < var5; var25++) {
         if (var9.cancel) {
            throw new tmt(a.c(-523752987, "⦀倳\udaef䒓콂䧺"));
         }

         int var26 = horizon(var25, var5);
         var9.phase = a.d("ィ䤔쏔嶭홽", 2104034361, -1462553365);
         var9.epoch = var25;
         var9.horizon = var26;
         List var27 = toi(var2, var3, var26);
         Collections.shuffle(var27, var8);
         int var28 = Math.min(var27.size(), var22 * 64);
         double var29 = 0.0;
         int var31 = 0;

         for (byte var32 = 0; var32 < var28; var32 += 64) {
            if (var9.cancel) {
               throw new tmt(a.c(-987985884, "衁\uf1f2笮\ue552溃\ue83b"));
            }

            int var33 = Math.min(var28, var32 + 64);
            List var34 = var27.subList(var32, var33);
            ArrayList var35 = new ArrayList();

            for (int var36 = 0; var36 < var6; var36++) {
               tni var37 = var14[var36];
               int var38 = var36 * var34.size() / var6;
               int var39 = (var36 + 1) * var34.size() / var6;
               long var40 = var8.nextLong();
               var35.add(() -> {
                  Arrays.fill(var37.grad, 0.0);
                  var37.loss = 0.0;
                  var37.steps = 0;
                  Random var9x = new Random(var40);

                  for (int var10x = var38; var10x < var39; var10x++) {
                     tnc var11x = (tnc)var34.get(var10x);
                     rollout(var0, var1, var11x.tnd, var11x.tne, Math.min(var26, var11x.tnf), var37, var9x);
                  }

                  return null;
               });
            }

            for (Future var53 : var7.invokeAll(var35)) {
               var53.get();
            }

            int var52 = 0;
            double var54 = 0.0;
            double[] var55 = var14[0].grad;

            for (int var56 = 0; var56 < var6; var56++) {
               var52 += var14[var56].steps;
               var54 += var14[var56].loss;
               if (var56 > 0) {
                  double[] var41 = var14[var56].grad;

                  for (int var42 = 0; var42 < var55.length; var42++) {
                     var55[var42] += var41[var42];
                  }
               }
            }

            if (var52 == 0) {
               break;
            }

            double var57 = 0.0;

            for (int var59 = 0; var59 < var55.length; var59++) {
               var55[var59] /= var52;
               var57 += var55[var59] * var55[var59];
            }

            var57 = Math.sqrt(var57);
            if (var57 > 2.0) {
               double var60 = 2.0 / var57;

               for (int var44 = 0; var44 < var55.length; var44++) {
                  var55[var44] *= var60;
               }
            }

            var21++;
            double var61 = Math.min(1.0, var21 / 200.0);
            double var62 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)var21 / var23)));
            double var46 = (1.0E-4 + 0.0029000000000000002 * var62) * var61;
            toj(var0.p, var55, var48, var16, var21, var46);
            var29 += var54;
            var31 += var52;
         }

         var9.trainLoss = var31 > 0 ? var29 / var31 : Double.NaN;
         var9.phase = a.d("諟\uf365离\ue7cc氓", -1486786258, 150272919);
         double var49 = validate(var1, var4, var12);
         var9.valLoss = var49;
         if (var11) {
            var10.add((float)var49);
            var9.curve = tog(var10);
         }

         var24 = var25 + 1;
         boolean var50 = var26 >= 24;
         if (!(var49 < var18 - 1.0E-4) && (var50 || !(var49 < var18))) {
            if (var50) {
               if (++var20 >= Math.max(8, var5 / 3)) {
                  break;
               }
            }
         } else {
            var18 = var49;
            System.arraycopy(var0.p, 0, var17, 0, var17.length);
            var20 = 0;
         }
      }

      System.arraycopy(var17, 0, var0.p, 0, var17.length);
      return var24;
   }

   private static float[] tog(List<Float> var0) {
      float[] var1 = new float[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (Float)var0.get(var2);
      }

      return var1;
   }

   static int horizon(int var0, int var1) {
      double var2 = (double)var0 / var1;
      if (var2 < 0.1) {
         return 1;
      } else if (var2 < 0.22) {
         return 4;
      } else if (var2 < 0.36) {
         return 8;
      } else {
         return var2 < 0.55 ? 16 : 24;
      }
   }

   private static int toh(List<sze> var0) {
      int var1 = 0;

      for (sze var3 : var0) {
         var1 += var3.m;
      }

      return var1;
   }

   private static List<tnc> toi(List<sze> var0, Map<sze, boolean[]> var1, int var2) {
      ArrayList var3 = new ArrayList();
      byte var4 = 32;

      for (sze var6 : var0) {
         boolean[] var7 = (boolean[])var1.get(var6);
         int var8 = 0;

         for (int var9 = var6.m - 1; var9 >= 0; var9--) {
            if (var7 != null && var7[var9]) {
               var8 = 0;
            } else {
               tnc var10 = new tnc(var6, var9, Math.min(var2, ++var8));
               double var11 = Math.hypot(var6.st[var9 * var4 + 0], var6.st[var9 * var4 + 1]);
               double var13 = Math.hypot(var6.st[(var9 + 1) * var4 + 14], var6.st[(var9 + 1) * var4 + 15]);
               int var15 = 1 + Math.min(3, (int)(var11 / 10.0 + var13 / 6.0));

               for (int var16 = 0; var16 < var15; var16++) {
                  var3.add(var10);
               }
            }
         }
      }

      return var3;
   }

   private static void toj(double[] var0, double[] var1, double[] var2, double[] var3, int var4, double var5) {
      double var7 = 0.9;
      double var9 = 0.999;
      double var11 = 1.0 - Math.pow(var7, var4);
      double var13 = 1.0 - Math.pow(var9, var4);

      for (int var15 = 0; var15 < var0.length; var15++) {
         var2[var15] = var7 * var2[var15] + (1.0 - var7) * var1[var15];
         var3[var15] = var9 * var3[var15] + (1.0 - var9) * var1[var15] * var1[var15];
         double var16 = var2[var15] / var11;
         double var18 = var3[var15] / var13;
         var0[var15] -= var5 * (var16 / (Math.sqrt(var18) + 1.0E-8) + 1.0E-5 * var0[var15]);
      }
   }

   static double huber(double var0) {
      double var2 = Math.abs(var0);
      return var2 < 1.0 ? 0.5 * var0 * var0 : var2 - 0.5;
   }

   static double clip(double var0) {
      return var0 > 1.0 ? 1.0 : (var0 < -1.0 ? -1.0 : var0);
   }

   static double sigmaD(double var0, double var2, double var4, double var6) {
      return 0.2 + 0.15 * Math.hypot(var0, var2) + 0.03 * Math.hypot(var4, var6);
   }

   static double sigmaE(double var0, double var2) {
      return 0.25 + 0.1 * Math.hypot(var0, var2);
   }

   static double tolerance(double[] var0, double var1, double var3) {
      return 0.35 * (var0[22] * Math.abs(var1) + 0.5 * var0[23] * Math.abs(var3)) + 0.05;
   }

   static double rollout(tbx var0, tck var1, sze var2, int var3, int var4, tni var5, Random var6) {
      double[] var7 = var2.st;
      byte var8 = 32;
      double var9 = 2.0;
      double var11 = var6 == null ? 0.0 : 0.04 + 0.03 * Math.hypot(var7[var3 * var8 + 0], var7[var3 * var8 + 1]);
      var5.ex[0] = var7[var3 * var8 + 0] + (var6 == null ? 0.0 : var6.nextGaussian() * var11);
      var5.ey[0] = var7[var3 * var8 + 1] + (var6 == null ? 0.0 : var6.nextGaussian() * var11 * 0.5);
      double var13 = 0.0;

      for (int var15 = 0; var15 < var4; var15++) {
         int var16 = var3 + var15;
         int var17 = var16 * var8;
         int var18 = (var16 + 1) * var8;
         double[] var19 = var5.s[var15];
         System.arraycopy(var7, var17, var19, 0, var8);
         var19[0] = var5.ex[var15];
         var19[1] = var5.ey[var15];

         for (int var20 = 0; var20 < tnw.length; var20++) {
            int var21 = var15 - tnw[var20];
            if (var21 >= 1) {
               var19[tnx[var20]] = var5.ex[var21];
               var19[tnx[var20] + 1] = var5.ey[var21];
            }
         }

         for (int var71 = 0; var71 < 4; var71++) {
            int var76 = var15 - var71;
            if (var76 >= 1) {
               var19[14 + var71 * 2] = var5.dx[var76];
               var19[15 + var71 * 2] = var5.dy[var76];
            }
         }

         tbf.features(var19, var1.mu, var1.sd, var5.x[var15]);
         var0.forward(var5.x[var15], var5.a1[var15], var5.a2[var15], var5.y[var15]);
         double[] var72 = var5.y[var15];
         double var77 = var5.ex[var15] * var72[0] + var9 * var72[2];
         double var23 = var5.ey[var15] * var72[1] + var9 * var72[3];
         var5.dx[var15 + 1] = var77;
         var5.dy[var15 + 1] = var23;
         double var25 = var7[var18 + 6];
         double var27 = var7[var18 + 7];
         var5.ex[var15 + 1] = var5.ex[var15] + var25 - var77;
         var5.ey[var15 + 1] = var5.ey[var15] + var27 - var23;
         double var29 = var7[var18 + 14];
         double var31 = var7[var18 + 15];
         double var33 = var7[var18 + 0];
         double var35 = var7[var18 + 1];
         double var37 = sigmaD(var29, var31, var7[var17 + 0], var7[var17 + 1]);
         double var39 = (var77 - var29) / var37;
         double var41 = (var23 - var31) / var37;
         var13 += huber(var39) + huber(var41);
         var5.lDx[var15 + 1] = clip(var39) / var37;
         var5.lDy[var15 + 1] = clip(var41) / var37;
         double var43 = sigmaE(var33, var35);
         double var45 = (var5.ex[var15 + 1] - var33) / var43;
         double var47 = (var5.ey[var15 + 1] - var35) / var43;
         var13 += 0.8 * (huber(var45) + huber(var47));
         var5.lEx[var15 + 1] = 0.8 * clip(var45) / var43;
         var5.lEy[var15 + 1] = 0.8 * clip(var47) / var43;
         double var49 = var5.ex[var15] + var25;
         double var51 = var5.ey[var15] + var27;
         double var53 = Math.hypot(var49, var51);
         if (var53 > 1.0E-6) {
            double var55 = var49 / var53;
            double var57 = var51 / var53;
            double var59 = -(var5.ex[var15 + 1] * var55 + var5.ey[var15 + 1] * var57) - tolerance(var19, var55, var57);
            if (var59 > 0.0) {
               var13 += var5.lambda * (var59 / var43) * (var59 / var43);
               double var61 = var5.lambda * 2.0 * var59 / (var43 * var43);
               var5.lEx[var15 + 1] = var5.lEx[var15 + 1] - var61 * var55;
               var5.lEy[var15 + 1] = var5.lEy[var15 + 1] - var61 * var57;
            }
         }
      }

      if (var4 >= 4) {
         int var64 = 0;
         double var67 = 0.0;
         double var69 = 0.0;

         for (int var73 = 1; var73 <= var4; var73++) {
            double var78 = Math.hypot(var5.dx[var73], var5.dy[var73]);
            if (var78 > var67) {
               var67 = var78;
               var64 = var73;
            }

            int var80 = (var3 + var73) * var8;
            var69 = Math.max(var69, Math.hypot(var7[var80 + 14], var7[var80 + 15]));
         }

         if (var69 > 2.0 && var64 > 0 && var67 > 1.0E-6) {
            double var74 = 0.3 + 0.12 * var69;
            double var22 = (var67 - var69) / var74;
            var13 += 1.5 * huber(var22) * var4 / 8.0;
            double var24 = 1.5 * clip(var22) / var74 * var4 / 8.0 / var67;
            var5.lDx[var64] = var5.lDx[var64] + var24 * var5.dx[var64];
            var5.lDy[var64] = var5.lDy[var64] + var24 * var5.dy[var64];
         }
      }

      for (int var65 = 0; var65 <= var4; var65++) {
         var5.gEx[var65] = 0.0;
         var5.gEy[var65] = 0.0;
         var5.gDx[var65] = 0.0;
         var5.gDy[var65] = 0.0;
      }

      for (int var66 = var4 - 1; var66 >= 0; var66--) {
         double var68 = var5.gEx[var66 + 1] + var5.lEx[var66 + 1];
         double var70 = var5.gEy[var66 + 1] + var5.lEy[var66 + 1];
         double var75 = var5.gDx[var66 + 1] + var5.lDx[var66 + 1] - var68;
         double var79 = var5.gDy[var66 + 1] + var5.lDy[var66 + 1] - var70;
         double[] var81 = var5.y[var66];
         var5.gy[0] = var75 * var5.ex[var66];
         var5.gy[1] = var79 * var5.ey[var66];
         var5.gy[2] = var75 * var9;
         var5.gy[3] = var79 * var9;
         var5.gEx[var66] = var5.gEx[var66] + (var68 + var75 * var81[0]);
         var5.gEy[var66] = var5.gEy[var66] + (var70 + var79 * var81[1]);
         var0.backward(var5.x[var66], var5.a1[var66], var5.a2[var66], var5.gy, var5.grad, var5.gx, var5.t1, var5.t2);
         tbf.backward(var5.s[var66], var1.sd, var5.gx, var5.gs);
         var5.gEx[var66] = var5.gEx[var66] + var5.gs[0];
         var5.gEy[var66] = var5.gEy[var66] + var5.gs[1];

         for (int var82 = 0; var82 < tnw.length; var82++) {
            int var26 = var66 - tnw[var82];
            if (var26 >= 1) {
               var5.gEx[var26] = var5.gEx[var26] + var5.gs[tnx[var82]];
               var5.gEy[var26] = var5.gEy[var26] + var5.gs[tnx[var82] + 1];
            }
         }

         for (int var83 = 0; var83 < 4; var83++) {
            int var84 = var66 - var83;
            if (var84 >= 1) {
               var5.gDx[var84] = var5.gDx[var84] + var5.gs[14 + var83 * 2];
               var5.gDy[var84] = var5.gDy[var84] + var5.gs[15 + var83 * 2];
            }
         }
      }

      var5.loss += var13;
      var5.steps += var4;
      return var13;
   }

   static double validate(tck var0, List<tmn> var1, double var2) {
      tch var4 = new tch();
      double[] var5 = new double[32];
      double[] var6 = new double[2];
      double var7 = 0.0;
      int var9 = 0;
      byte var10 = 32;

      for (tmn var12 : var1) {
         double[] var13 = var12.tmo.st;
         int var14 = var12.tmq - var12.tmp;
         tmz var15 = new tmz(var14);
         var15.ex[0] = var13[var12.tmp * var10 + 0];
         var15.ey[0] = var13[var12.tmp * var10 + 1];

         for (int var16 = 0; var16 < var14; var16++) {
            int var17 = var12.tmp + var16;
            int var18 = var17 * var10;
            int var19 = (var17 + 1) * var10;
            var15.state(var12.tmo, var12.tmp, var16, var5);

            for (int var20 = 0; var20 < 4; var20++) {
               int var21 = var16 - var20;
               if (var21 >= 1) {
                  var5[14 + var20 * 2] = var15.dx[var21];
                  var5[15 + var20 * 2] = var15.dy[var21];
               }
            }

            var0.predict(var5, var6, var4);
            double var53 = var13[var19 + 6];
            double var22 = var13[var19 + 7];
            double var24 = var15.ex[var16] + var53 - var6[0];
            double var26 = var15.ey[var16] + var22 - var6[1];
            var15.dx[var16 + 1] = var6[0];
            var15.dy[var16 + 1] = var6[1];
            var15.ex[var16 + 1] = var24;
            var15.ey[var16 + 1] = var26;
            double var28 = var13[var19 + 14];
            double var30 = var13[var19 + 15];
            double var32 = var13[var19 + 0];
            double var34 = var13[var19 + 1];
            double var36 = sigmaD(var28, var30, var13[var18 + 0], var13[var18 + 1]);
            double var38 = sigmaE(var32, var34);
            var7 += huber((var6[0] - var28) / var36) + huber((var6[1] - var30) / var36);
            var7 += 0.8 * (huber((var24 - var32) / var38) + huber((var26 - var34) / var38));
            double var40 = var15.ex[var16] + var53;
            double var42 = var15.ey[var16] + var22;
            double var44 = Math.hypot(var40, var42);
            if (var44 > 1.0E-6) {
               double var46 = var40 / var44;
               double var48 = var42 / var44;
               double var50 = -(var24 * var46 + var26 * var48) - tolerance(var5, var46, var48);
               if (var50 > 0.0) {
                  var7 += var2 * (var50 / var38) * (var50 / var38);
               }
            }

            var9++;
         }
      }

      return var9 > 0 ? var7 / var9 : Double.NaN;
   }

   private static void tok(List<sze> var0, tck var1) {
      byte var2 = 32;
      double[] var3 = new double[var2];
      double[] var4 = new double[var2];
      double[] var5 = new double[32];
      double[] var6 = new double[var2];
      long var7 = 0L;

      for (sze var10 : var0) {
         for (int var11 = 0; var11 < var10.m; var11++) {
            System.arraycopy(var10.st, var11 * 32, var5, 0, 32);
            tbf.raw(var5, var6);

            for (int var12 = 0; var12 < var2; var12++) {
               var3[var12] += var6[var12];
               var4[var12] += var6[var12] * var6[var12];
            }

            var7++;
         }
      }

      for (int var14 = 0; var14 < var2; var14++) {
         double var15 = var7 > 0L ? var3[var14] / var7 : 0.0;
         double var16 = var7 > 0L ? var4[var14] / var7 - var15 * var15 : 1.0;
         var1.mu[var14] = var15;
         var1.sd[var14] = Math.max(0.05, Math.sqrt(Math.max(0.0, var16)));
      }
   }

   private static void tol(List<sze> var0, tck var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < tck.BINS; var4++) {
         var2.add(new ArrayList());
         var3.add(new ArrayList());
      }

      for (sze var5 : var0) {
         for (int var6 = 0; var6 < var5.m; var6++) {
            double var7 = Math.hypot(var5.get(var6, 0), var5.get(var6, 1));
            int var9 = tck.bin(var7);
            double var10 = var5.get(var6 + 1, 14);
            double var12 = var5.get(var6 + 1, 15);
            double var14 = Math.hypot(var5.get(var6 + 1, 6), var5.get(var6 + 1, 7));
            ((List)var2.get(var9)).add(Math.max(0.0, Math.hypot(var10, var12) - var14));
            ((List)var3.get(var9)).add(Math.hypot(var10 - var5.get(var6, 14), var12 - var5.get(var6, 15)));
         }
      }

      double[] var18 = new double[tck.BINS];
      double[] var19 = new double[tck.BINS];

      for (int var20 = 0; var20 < tck.BINS; var20++) {
         boolean var23 = ((List)var2.get(var20)).size() >= 20;
         var18[var20] = var23 ? quantile((List<Double>)var2.get(var20), 0.995) : Double.NaN;
         var19[var20] = var23 ? quantile((List<Double>)var3.get(var20), 0.995) : Double.NaN;
      }

      for (int var21 = tck.BINS - 2; var21 >= 0; var21--) {
         if (Double.isNaN(var18[var21])) {
            var18[var21] = var18[var21 + 1];
            var19[var21] = var19[var21 + 1];
         }
      }

      double var22 = 0.4;
      double var8 = 0.6;

      for (int var24 = 0; var24 < tck.BINS; var24++) {
         double var11 = tck.EDGES[Math.min(var24, tck.EDGES.length - 1)];
         double var13 = Double.isNaN(var18[var24]) ? Math.max(var22, var11 * 0.6) : var18[var24];
         double var15 = Double.isNaN(var19[var24]) ? Math.max(var8, var13 * 0.8) : var19[var24];
         var22 = Math.max(var22, var13);
         var8 = Math.max(var8, var15);
         var1.speedCap[var24] = var22;
         var1.accelCap[var24] = var8;
      }
   }

   static void calibrate(List<sze> var0, tck var1) {
      tch var2 = new tch();
      double[] var3 = new double[32];
      double[] var4 = new double[2];
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();

      for (sze var8 : var0) {
         for (int var9 = 0; var9 < var8.m; var9++) {
            System.arraycopy(var8.st, var9 * 32, var3, 0, 32);
            var1.base(var3, var4, var2);
            var5.add(Math.hypot(var4[0], var4[1]));
            var6.add(Math.hypot(var8.get(var9 + 1, 14), var8.get(var9 + 1, 15)));
         }
      }

      if (var5.size() >= 200) {
         double[] var15 = new double[]{0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.85, 0.9, 0.93, 0.95, 0.97, 0.98, 0.99, 0.995};
         float[] var16 = new float[var15.length];
         float[] var17 = new float[var15.length];
         double var10 = 0.0;
         double var12 = 0.0;

         for (int var14 = 0; var14 < var15.length; var14++) {
            var10 = Math.max(var10 + 0.001, quantile(var5, var15[var14]));
            var12 = Math.max(var12, quantile(var6, var15[var14]));
            var16[var14] = (float)var10;
            var17[var14] = (float)Math.max(var12, var10 * 0.6);
         }

         var17[0] = var16[0];
         var1.qIn = var16;
         var1.qOut = var17;
      }
   }

   public static taf auraTuning() {
      return new taf();
   }

   static void tuneTexture(tck var0, List<tmn> var1, long var2, tmw var4) {
      if (var1.size() >= 20 && var0.resX.length != 0) {
         syn var5 = syq.user(var1);
         taf var6 = auraTuning();
         var0.texCap = 1.0F;
         var0.texX = 1.25F;
         var0.texY = 1.25F;
         double var7 = ton(var0, var1, var5, var6, var2);

         for (int var9 = 0; var9 < 2; var9++) {
            for (int var10 = 0; var10 < 3; var10++) {
               float[] var11 = var10 == 0 ? toa : tob;
               float var12 = var10 == 0 ? var0.texCap : (var10 == 1 ? var0.texX : var0.texY);
               float var13 = var12;

               for (float var17 : var11) {
                  if (var4.cancel) {
                     throw new tmt(a.d("貯\uf51c翀\ue1bc橭\uecd5", -1406059793, -698894811));
                  }

                  if (var17 != var12) {
                     tom(var0, var10, var17);
                     double var18 = ton(var0, var1, var5, var6, var2);
                     if (var18 > var7 + 0.05) {
                        var7 = var18;
                        var13 = var17;
                     }
                  }
               }

               tom(var0, var10, var13);
            }
         }
      }
   }

   private static void tom(tck var0, int var1, float var2) {
      switch (var1) {
         case 0:
            var0.texCap = var2;
            break;
         case 1:
            var0.texX = var2;
            break;
         default:
            var0.texY = var2;
      }
   }

   private static double ton(tck var0, List<tmn> var1, syn var2, taf var3, long var4) {
      syk var6 = syq.compare(var2, syq.model(var0, var1, new Random(var4), var3));
      return 0.6 * Math.min(var6.simX, var6.simY) + 0.4 * var6.total();
   }

   static void tune(tck var0, List<tmn> var1, long var2) {
      if (var0.qIn.length >= 8 && var1.size() >= 20) {
         var0.boostFrom = var0.qIn[4];
         var0.boostTo = var0.qIn[9];
         float var4 = 1.0F;
         double var5 = Double.NEGATIVE_INFINITY;
         double var7 = -1.0;

         for (float var9 = 1.0F; var9 <= 1.401F; var9 += 0.08F) {
            var0.boost = var9;
            double var10 = 0.0;
            double var12 = 0.0;

            for (int var14 = 0; var14 < 3; var14++) {
               tbs.score(var0, var1, new Random(var2 + var14 * 977L));
               var10 += var0.similarity;
               var12 += var0.overshootModel;
            }

            if (var7 < 0.0) {
               var7 = var12;
            }

            if (!(var12 > var7 + 1.0E-9) && var10 > var5 + 0.3) {
               var5 = var10;
               var4 = var9;
            }
         }

         var0.boost = var4;
      }
   }

   static int lag(List<sze> var0) {
      byte var1 = 8;
      double[] var2 = new double[var1 + 1];
      double[] var3 = new double[var1 + 1];
      double[] var4 = new double[var1 + 1];
      byte var5 = 32;

      for (sze var7 : var0) {
         for (int var8 = var1; var8 <= var7.m; var8++) {
            int var9 = var8 * var5;
            double var10 = Math.hypot(var7.st[var9 + 0], var7.st[var9 + 1]);
            if (!(var10 > 3.0 * var7.st[var9 + 22] + 2.0)) {
               double var12 = var7.st[var9 + 14];

               for (int var14 = 0; var14 <= var1; var14++) {
                  double var15 = var7.st[(var8 - var14) * var5 + 6];
                  var2[var14] += var15 * var12;
                  var3[var14] += var15 * var15;
                  var4[var14] += var12 * var12;
               }
            }
         }
      }

      int var17 = 3;
      double var18 = 0.05;

      for (int var19 = 0; var19 <= var1; var19++) {
         if (!(var3[var19] <= 0.0) && !(var4[var19] <= 0.0)) {
            double var20 = var2[var19] / Math.sqrt(var3[var19] * var4[var19]);
            if (var20 > var18) {
               var18 = var20;
               var17 = var19;
            }
         }
      }

      return var17;
   }

   static double quantile(List<Double> var0, double var1) {
      if (var0.isEmpty()) {
         return Double.NaN;
      } else {
         double[] var3 = new double[var0.size()];

         for (int var4 = 0; var4 < var3.length; var4++) {
            var3[var4] = (Double)var0.get(var4);
         }

         Arrays.sort(var3);
         return var3[Math.min(var3.length - 1, (int)Math.floor(var1 * (var3.length - 1)))];
      }
   }

   private static void too(szk var0, tck var1, Random var2) {
      ArrayList var3 = new ArrayList<>(var0.aimPoints);
      Collections.shuffle(var3, var2);
      int var4 = Math.min(var3.size(), 4000);
      var1.aimU = new float[var4];
      var1.aimV = new float[var4];

      for (int var5 = 0; var5 < var4; var5++) {
         var1.aimU[var5] = (float)((double[])var3.get(var5))[0];
         var1.aimV[var5] = (float)((double[])var3.get(var5))[1];
      }
   }

   private static void top(List<sze> var0, tck var1, Random var2) {
      ArrayList var3 = new ArrayList(var0);
      Collections.shuffle(var3, var2);
      tch var4 = new tch();
      double[] var5 = new double[32];
      double[] var6 = new double[2];
      ArrayList var7 = new ArrayList();
      char var8 = '鱀';

      for (sze var10 : var3) {
         if (var7.size() >= var8) {
            break;
         }

         for (int var11 = 0; var11 < var10.m && var7.size() < var8; var11++) {
            System.arraycopy(var10.st, var11 * 32, var5, 0, 32);
            var1.predict(var5, var6, var4);
            double var12 = var10.get(var11 + 1, 14) - var6[0];
            double var14 = var10.get(var11 + 1, 15) - var6[1];
            int var16 = tck.bin(Math.hypot(var5[0], var5[1]));
            var7.add(new float[]{(float)var12, (float)var14, var16, var11 < var10.m - 1 ? 1.0F : 0.0F});
         }

         if (!var7.isEmpty()) {
            ((float[])var7.get(var7.size() - 1))[3] = 0.0F;
         }
      }

      int var17 = var7.size();
      var1.resX = new float[var17];
      var1.resY = new float[var17];
      var1.resBin = new byte[var17];
      var1.resLink = new boolean[var17];

      for (int var18 = 0; var18 < var17; var18++) {
         float[] var19 = (float[])var7.get(var18);
         var1.resX[var18] = var19[0];
         var1.resY[var18] = var19[1];
         var1.resBin[var18] = (byte)var19[2];
         var1.resLink[var18] = var19[3] > 0.5F;
      }
   }
}
