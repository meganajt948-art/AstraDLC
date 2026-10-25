package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

final class gkj {
   final String name;
   int episodes;
   int acquired;
   double entrySum;
   int overshoots;
   int trackTicks;
   int onTicks;
   final List<Double> speeds = new ArrayList<>();
   double jerk;
   int jerkN;
   double lastDx;
   double lastDy;
   double lastAx;
   double lastAy;
   int since;
   boolean entered;
   int side;
   int offGrid;
   int gridTicks;
   double maxStep;

   gkj(String var1) {
      this.name = var1;
   }

   void episode() {
      this.episodes++;
      this.since = 0;
      this.entered = false;
      this.side = 0;
   }

   void sample(double var1, double var3, boolean var5, double var6, double var8, double var10, double var12, double var14) {
      this.since++;
      if (!this.entered && var5) {
         this.entered = true;
         this.acquired++;
         this.entrySum = this.entrySum + this.since;
      }

      int var16 = var6 > var10 + 0.5 * var12 ? 1 : (var6 < var8 - 0.5 * var12 ? -1 : 0);
      if (var16 != 0) {
         if (this.side != 0 && var16 != this.side && var1 * var16 > 0.0 && Math.abs(var1) > Math.abs(var14)) {
            this.overshoots++;
         }

         this.side = var16;
      }

      if (this.entered) {
         this.trackTicks++;
         if (var5) {
            this.onTicks++;
         }
      }

      double var17 = Math.hypot(var1, var3);
      this.speeds.add(var17);
      this.maxStep = Math.max(this.maxStep, var17);
      double var19 = var1 - this.lastDx;
      double var21 = var3 - this.lastDy;
      this.jerk = this.jerk + Math.hypot(var19 - this.lastAx, var21 - this.lastAy);
      this.jerkN++;
      this.lastAx = var19;
      this.lastAy = var21;
      this.lastDx = var1;
      this.lastDy = var3;
   }

   String report() {
      double[] var1 = this.speeds.stream().mapToDouble(Double::doubleValue).sorted().toArray();
      return var1.length == 0
         ? this.name + a.c(564595006, "ई炣慨摎\uefd6椴퍵媈쓊乧즽㏚")
         : String.format(
            Locale.ROOT,
            a.b(
               "勷⬐ꆊ㿡둷㋄袅Ű鼳ᖙ鉝栭\ue6be缊\uf518玢짧䙷\udc80媔퍨ꤣ➖뱌㩪낾आ蝋ᷨ鯿ဘ\uee91擒ﵬ符\uf184乄쐴䋼\udb4a儕\u2fffꖫ≉뢛㚫輰֍莍ᡝ陭泥\ue547挅泥瞰찞䪛샭夷힟궙⨩ꁸ㺾뜃ഃ诱Ƴ鸂ᓐ鋥歪\ue19e翈\uf429牻죁䄎\udf2b喢펣ꡙ⚁볦㔲뎊ে虬ᱻ骘ጀ\ue977枿ﰉ穓\uf080亥윰巌\udb97偿\u2e74꓀㴔뭹ㇾ踅ў若ᢹ鄟濉\ue5d3戥\uf87f盕콑䕨쎵塅혝곮⫴ꌉ㧍랥౹該Æ饔ᝮ\uedb3橃",
               -1920773548
            ),
            this.name,
            this.acquired,
            this.episodes,
            this.entrySum / Math.max(1, this.acquired),
            this.overshoots,
            100.0 * this.onTicks / Math.max(1, this.trackTicks),
            var1[var1.length / 2],
            var1[(int)(var1.length * 0.9)],
            var1[Math.min(var1.length - 1, (int)(var1.length * 0.99))],
            this.maxStep,
            this.jerk / Math.max(1, this.jerkN),
            this.offGrid,
            this.gridTicks
         );
   }
}
