package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class tvf {
   public static final int MIN_EVENTS = 80;
   public static final int MIN_LEGS = 2000;
   private static final int tvg = 24;
   private static final int tvh = 600;
   private static final int tvi = 14000;
   private static final int tvj = 1500;

   private tvf() {
   }

   public static double beta(int var0) {
      return var0 <= 0 ? 0.0 : (var0 >= 20 ? 1.0 : 0.5);
   }

   public static ttb run(List<tvc> var0, tmk var1, int var2, int var3, int var4, tmw var5) {
      var5.phase = a.d("汈ᗼ鼺Ş", -1716628273, 721500391);
      List var6 = tsr.prepare(var0, beta(var4), var5);
      tsl var7 = tsr.events(var6, var5);
      if (var7.list.size() < 80) {
         throw new tmt(a.c(-1911003022, "栗ᆥ魤"));
      } else {
         trp var8 = tsr.legs(var6, var5);
         List var9 = tsr.rotation(var0);
         tqj var10 = tqm.train(var7.list, 24, var2, var1.seed, var5);
         trm var11 = var8.n >= 2000 ? trs.train(var8, var3, var1.seed ^ 2654435769L, var5) : null;
         var1.track = false;
         var1.minWindow = 1;
         tck var12 = tnl.run(var9, var1, var5);
         List var13 = tsr.reactions(var0);
         tvq var14 = tsr.style(var6, var13);
         ArrayList var15 = new ArrayList(var13);
         Collections.shuffle(var15, new Random(var1.seed ^ 2685821657736338717L));
         int var16 = Math.min(600, var15.size());
         var12.reactions = new int[var16];

         for (int var17 = 0; var17 < var16; var17++) {
            var12.reactions[var17] = Math.min(255, (Integer)var15.get(var17));
         }

         var12.turnCap = var14.turnCap;
         tvm(var12);
         ttb var18 = new ttb();
         var18.hand = var12;
         var18.brain = var10.net;
         var18.style = var14;
         var18.top1 = var10.top1;
         var18.top3 = var10.top3;
         var18.base1 = var10.base1;
         var18.nll = var10.nll;
         var18.events = var7.list.size();
         var18.valEvents = var10.valEvents;
         if (var11 != null) {
            var18.legs = var11.legs;
            var18.legsAcc = var11.accuracy;
            var18.legsBase = var11.baseline;
            var18.legsJump = var11.jumpAcc;
            var18.legsSprint = var11.sprintAcc;
            var18.legsSamples = var11.samples;
         }

         var18.boost = var4;
         var18.created = System.currentTimeMillis();
         var5.phase = a.d("ၚ槤\ue330絆\uf68b瀡", -8848156, -2060718882);
         return var18;
      }
   }

   private static void tvm(tck var0) {
      int var1 = var0.resX.length;
      if (var1 > 14000) {
         var0.resX = Arrays.copyOf(var0.resX, 14000);
         var0.resY = Arrays.copyOf(var0.resY, 14000);
         var0.resBin = Arrays.copyOf(var0.resBin, 14000);
         var0.resLink = Arrays.copyOf(var0.resLink, 14000);
         var0.resLink[13999] = false;
      }

      if (var0.aimU.length > 1500) {
         var0.aimU = Arrays.copyOf(var0.aimU, 1500);
         var0.aimV = Arrays.copyOf(var0.aimV, 1500);
      }
   }
}
