package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class tsr {
   public static final int COVER = 40;
   public static final int MAX_TARGETS = 24;
   public static final int HORIZON = 40;
   public static final double REACT_FROM = 15.0;
   private static final int tss = 20;
   private static final double tst = 20.0;
   private static final double tsu = 0.25;
   private static final double tsv = 4.0;

   private tsr() {
   }

   public static List<tso> prepare(List<tvc> var0, double var1, tmw var3) {
      ArrayList var4 = new ArrayList();
      int[] var5 = new int[2];
      double var6 = 0.0;
      double var8 = 0.0;
      long var10 = 0L;

      for (tvc var13 : var0) {
         tso var14 = new tso(var13);
         int var15 = var13.ticks.size();

         for (int var16 = 0; var16 < var15; var16++) {
            if (var3 != null && var3.cancel) {
               throw new tmt(a.c(-1741957638, "햟갬⛰뢌㍝뗥"));
            }

            tuz var17 = var13.ticks.get(var16);
            if ((var17.flags & 1) != 0 && var17.snap != null) {
               trd.reach(var13.snap(var16), var17.x, var17.y, var17.z, var5);
               var14.reach[var16] = var5[0];
               var14.reachDia[var16] = var5[1];
            }
         }

         int var26 = var15 - 1;
         double var28 = 0.0;
         int var19 = 0;

         for (int var20 = var15 - 1; var20 >= 0; var20--) {
            tuz var21 = var13.ticks.get(var20);
            if ((var21.flags & 1) == 0) {
               var26 = var20 - 1;
               var28 = 0.0;
               var19 = 0;
            } else {
               var28 += trd.value(var21.farm, var21.dia);
               var19++;
               int var22 = var20 + 40;
               if (var22 <= var26 && var19 > 40) {
                  tuz var23 = var13.ticks.get(var22);
                  var28 -= trd.value(var23.farm, var23.dia);
                  var19--;
               }

               var14.rate[var20] = var28 / var19;
               var6 += var14.rate[var20];
               var8 += var14.rate[var20] * var14.rate[var20];
               var10++;
               if ((var21.flags & 4) != 0) {
                  var26 = var20 - 1;
                  var28 = 0.0;
                  var19 = 0;
               }
            }
         }

         var4.add(var14);
      }

      double var24 = var10 == 0L ? 0.0 : var6 / var10;
      double var25 = var10 == 0L ? 1.0 : Math.sqrt(Math.max(1.0E-9, var8 / var10 - var24 * var24));

      for (tso var29 : var4) {
         for (int var18 = 0; var18 < var29.rate.length; var18++) {
            double var30 = (var29.rate[var18] - var24) / var25;
            var29.weight[var18] = var1 <= 0.0 ? 1.0 : Math.max(0.25, Math.min(4.0, Math.exp(var1 * var30)));
         }
      }

      return var4;
   }

   public static tsl events(List<tso> var0, tmw var1) {
      tsl var2 = new tsl();

      for (tso var4 : var0) {
         tvc var5 = var4.tape;

         for (tut var7 : var5.decisions) {
            if (var1 != null && var1.cancel) {
               throw new tmt(a.d("\uf6db轨ִ鯈မ隡", 1804537483, 599914549));
            }

            var2.decisions++;
            tuw var8 = var5.hits.get(var7.hit);
            if (var8.y < var7.ctx.feetY) {
               var2.below++;
            } else {
               tvn var9 = var7.tick >= 0 && var7.tick < var5.ticks.size() ? var5.snap(var7.tick) : null;
               if (var9 == null) {
                  var2.unmatched++;
               } else {
                  tpn var10 = tpn.of(var9, var7.ctx);
                  int var11 = var10.indexOf(var8.x, var8.y, var8.z);
                  if (var11 < 0) {
                     var2.unmatched++;
                  } else if (var10.n < 2) {
                     var2.single++;
                  } else {
                     tqg var12 = new tqg(var10.n, Arrays.copyOf(var10.f, var10.n * 32), var11, var10.nearest(), var5, var7.tick);
                     var12.weight = var4.weight[var7.tick];
                     var2.list.add(var12);
                  }
               }
            }
         }
      }

      return var2;
   }

   public static trp legs(List<tso> var0, tmw var1) {
      trp var2 = new trp();
      double[] var3 = new double[71];
      trg var4 = new trg();
      int var5 = 0;

      for (tso var7 : var0) {
         tvc var8 = var7.tape;
         List var9 = var8.hits;
         int var10 = 0;

         for (int var11 = 0; var11 < var8.ticks.size(); var11++) {
            if (var1 != null && var1.cancel) {
               throw new tmt(a.b("⾷嘄\udcd8䊤쥵俍", -975818798));
            }

            tuz var12 = var8.ticks.get(var11);

            while (var10 < var9.size() && ((tuw)var9.get(var10)).tick <= var11) {
               var10++;
            }

            if ((var12.flags & 1) != 0 && var12.snap != null) {
               boolean var13 = var10 < var9.size() && ((tuw)var9.get(var10)).tick - var11 <= 40;
               if (var7.reach[var11] != 0 || var13) {
                  var4.px = var12.x;
                  var4.pz = var12.z;
                  var4.eyeY = var12.y;
                  var4.py = var12.y - 1.62;
                  var4.yaw = var12.yaw;
                  var4.pitch = var12.pitch;
                  var4.vx = var12.vx;
                  var4.vy = var12.vy;
                  var4.vz = var12.vz;
                  var4.ground = (var12.flags & 2) != 0;
                  var4.feetY = var12.feetY;
                  var4.hasTarget = var13;
                  if (var13) {
                     tuw var14 = (tuw)var9.get(var10);
                     var4.tx = var14.x;
                     var4.ty = var14.y;
                     var4.tz = var14.z;
                  }

                  trj.features(var8.snap(var11), var4, var3, 0);
                  var2.add(var3, trj.move(var12.keys), (var12.keys & 16) != 0, (var12.keys & 32) != 0, var7.weight[var11], var5 * 100000 + var11 / 200);
               }
            }
         }

         var5++;
      }

      return var2;
   }

   public static List<tmh> rotation(List<tvc> var0) {
      ArrayList var1 = new ArrayList();

      for (tvc var3 : var0) {
         int var4 = var3.ticks.size();
         if (var4 >= 20) {
            tmh var5 = new tmh();
            var5.created = var3.created;
            var5.unit = var3.unit;
            var5.source = 2;
            List var6 = var3.hits;
            int[] var7 = new int[var4];
            Arrays.fill(var7, -1);

            for (int var8 = 0; var8 < var6.size(); var8++) {
               int var9 = ((tuw)var6.get(var8)).tick;
               if (var9 >= 0 && var9 < var4 && var7[var9] < 0) {
                  var7[var9] = var8;
               }
            }

            int var16 = 0;

            for (int var17 = 0; var17 < var4; var17++) {
               tuz var10 = var3.ticks.get(var17);
               tme var11 = new tme();
               boolean var12 = (var10.flags & 1) != 0;
               var11.flags = (var12 ? 1 : 0) | ((var10.flags & 2) != 0 ? 2 : 0) | ((var10.flags & 4) != 0 ? 4 : 0);
               var11.yaw = var10.yaw;
               var11.pitch = var10.pitch;
               var11.eyeX = var10.x;
               var11.eyeY = var10.y;
               var11.eyeZ = var10.z;
               var11.cooldown = 1.0F;

               while (var16 < var6.size() && ((tuw)var6.get(var16)).tick < var17 - 1) {
                  var16++;
               }

               int var13 = 0;

               for (int var14 = var16; var14 < var6.size() && var13 < 24 && ((tuw)var6.get(var14)).tick <= var17 + 40; var14++) {
                  var13++;
               }

               var11.ids = new int[var13];
               var11.boxes = new float[var13 * 5];

               for (int var18 = 0; var18 < var13; var18++) {
                  tuw var15 = (tuw)var6.get(var16 + var18);
                  var11.ids[var18] = var16 + var18 + 1;
                  var11.boxes[var18 * 5] = var15.x + 0.5F;
                  var11.boxes[var18 * 5 + 1] = var15.y;
                  var11.boxes[var18 * 5 + 2] = var15.z + 0.5F;
                  var11.boxes[var18 * 5 + 3] = 0.5F;
                  var11.boxes[var18 * 5 + 4] = 1.0F;
               }

               int var19 = var7[var17];
               if (var19 >= 0 && var12) {
                  tuw var20 = (tuw)var6.get(var19);
                  var11.hitId = var19 + 1;
                  var11.hitU = (float)tbp.hitU(var10.x, var10.z, var20.x + 0.5, var20.z + 0.5, 0.5, var20.px, var20.pz);
                  var11.hitV = (float)tbp.hitV(var20.y, 1.0, var20.py);
                  var11.presses = 1;
               }

               var5.ticks.add(var11);
            }

            var1.add(var5);
         }
      }

      return var1;
   }

   private static boolean tsy(tvc var0, int var1) {
      if (var1 > 0 && var1 < var0.ticks.size()) {
         tuz var2 = var0.ticks.get(var1);
         tuz var3 = var0.ticks.get(var1 - 1);
         if ((var2.flags & 1) != 0 && (var3.flags & 1) != 0 && (var2.flags & 4) == 0) {
            double var4 = var2.x - var3.x;
            double var6 = var2.y - var3.y;
            double var8 = var2.z - var3.z;
            return Math.abs(var2.yaw - var3.yaw) <= 180.0 && var4 * var4 + var6 * var6 + var8 * var8 < 16.0;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static List<Integer> reactions(List<tvc> var0) {
      ArrayList var1 = new ArrayList();

      for (tvc var3 : var0) {
         for (int var4 = 1; var4 < var3.hits.size(); var4++) {
            tuw var5 = var3.hits.get(var4 - 1);
            tuw var6 = var3.hits.get(var4);
            if (var6.tick - var5.tick <= 40 && var6.tick > var5.tick) {
               int var7 = tta(var3, var5.tick, var6);
               if (var7 >= 0) {
                  var1.add(var7);
               }
            }
         }
      }

      return var1;
   }

   private static double tsz(tuz var0, tuw var1) {
      double var2 = var1.px - var0.x;
      double var4 = var1.py - var0.y;
      double var6 = var1.pz - var0.z;
      return Math.hypot(tbp.wrap(tbp.yawTo(var2, var6) - var0.yaw), tbp.pitchTo(var4, Math.sqrt(var2 * var2 + var6 * var6)) - var0.pitch);
   }

   private static int tta(tvc var0, int var1, tuw var2) {
      for (int var3 = 0; var3 < 20; var3++) {
         int var4 = var1 + var3;
         int var5 = var4 + 1;
         if (var5 > var2.tick || !tsy(var0, var5)) {
            return -1;
         }

         tuz var6 = var0.ticks.get(var4);
         double var7 = var2.px - var6.x;
         double var9 = var2.py - var6.y;
         double var11 = var2.pz - var6.z;
         double var13 = tbp.wrap(tbp.yawTo(var7, var11) - var6.yaw);
         double var15 = tbp.pitchTo(var9, Math.sqrt(var7 * var7 + var11 * var11)) - var6.pitch;
         double var17 = Math.hypot(var13, var15);
         if (var3 == 0 && var17 < 15.0) {
            return -1;
         }

         tuz var19 = var0.ticks.get(var5);
         double var20 = ((var19.yaw - var6.yaw) * var13 + (var19.pitch - var6.pitch) * var15) / Math.max(1.0E-6, var17);
         if (var20 > Math.max(1.0, 0.08 * var17)) {
            return var3;
         }
      }

      return -1;
   }

   public static tvq style(List<tso> var0, List<Integer> var1) {
      tvq var2 = new tvq();
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      long var9 = 0L;
      int var11 = 0;
      double var12 = 0.0;
      long var14 = 0L;
      ArrayList var16 = new ArrayList();
      ArrayList var17 = new ArrayList();
      ArrayList var18 = new ArrayList();

      for (tso var20 : var0) {
         tvc var21 = var20.tape;

         for (int var22 = 0; var22 < var21.ticks.size(); var22++) {
            tuz var23 = var21.ticks.get(var22);
            if ((var23.flags & 1) != 0) {
               var3++;
               var9 += var23.farm;
               if (var20.reach[var22] >= 8) {
                  var11++;
                  var12 += trd.value(var23.farm, var23.dia);
                  var14 += var23.dia;
               }

               if (Math.hypot(var23.vx, var23.vz) > 0.08) {
                  var4++;
                  if ((var23.flags & 8) != 0) {
                     var5++;
                  }
               }

               if (tsy(var21, var22)) {
                  tuz var24 = var21.ticks.get(var22 - 1);
                  double var25 = Math.hypot(tbp.wrap(var23.yaw - var24.yaw), var23.pitch - var24.pitch);
                  var16.add(var25);
                  if (var25 > 3.0) {
                     var17.add(var25);
                  }
               }
            }
         }

         for (int var31 = 0; var31 < var21.hits.size(); var31++) {
            tuw var33 = var21.hits.get(var31);
            if (var33.tick >= 0 && var33.tick < var21.ticks.size()) {
               var6++;
               tuz var35 = var21.ticks.get(var33.tick);
               if (Math.hypot(var35.vx, var35.vz) > 0.06) {
                  var7++;
               }

               if (tpx.target(var33.cell)) {
                  var8++;
               }

               int var36 = var31 > 0 ? Math.max(var21.hits.get(var31 - 1).tick, var33.tick - 40) : var33.tick - 40;

               for (int var26 = Math.max(1, var36); var26 < var33.tick; var26++) {
                  if (tsy(var21, var26 + 1) && !(tsz(var21.ticks.get(var26), var33) < 20.0)) {
                     tuz var27 = var21.ticks.get(var26);
                     tuz var28 = var21.ticks.get(var26 + 1);
                     var18.add(Math.hypot(tbp.wrap(var28.yaw - var27.yaw), var28.pitch - var27.pitch));
                  }
               }
            }
         }
      }

      double var29 = var3 / 1200.0;
      var2.sprintShare = var4 == 0 ? 0.0F : (float)var5 / var4;
      var2.walkBreakShare = var6 == 0 ? 0.0F : (float)var7 / var6;
      var2.turnCap = var16.size() < 200 ? 0.0F : (float)Math.max(20.0, quantile(var16, 0.999));
      var2.turnRate = var18.size() >= 50
         ? (float)Math.max(6.0, quantile(var18, 0.5))
         : (var17.size() >= 50 ? (float)Math.max(6.0, quantile(var17, 0.75)) : 18.0F);
      var2.blocksPerMin = var29 <= 0.0 ? 0.0F : (float)(var6 / var29);
      var2.oresPerMin = var29 <= 0.0 ? 0.0F : (float)(var8 / var29);
      var2.farmPerMin = var29 <= 0.0 ? 0.0F : (float)(var9 / var29);
      var2.activeRate = var11 == 0 ? 0.0F : (float)(var12 / var11 * 1200.0);
      var2.activeDia = var11 == 0 ? 0.0F : (float)((double)var14 / var11 * 1200.0);
      var2.workShare = var3 == 0 ? 0.0F : (float)var11 / var3;
      var2.seconds = var3 / 20.0F;
      var2.hits = var6;
      ArrayList var30 = new ArrayList();

      for (int var34 : var1) {
         if (var34 > 0) {
            var30.add((double)var34);
         }
      }

      var2.reactionMs = var30.isEmpty() ? 0 : (int)Math.round(quantile(var30, 0.5) * 50.0);
      return var2;
   }

   static double quantile(List<Double> var0, double var1) {
      if (var0.isEmpty()) {
         return 0.0;
      }

      ArrayList var3 = new ArrayList(var0);
      Collections.sort(var3);
      int var4 = (int)Math.min(var3.size() - 1, Math.max(0L, Math.round(var1 * (var3.size() - 1))));
      return (Double)var3.get(var4);
   }
}
