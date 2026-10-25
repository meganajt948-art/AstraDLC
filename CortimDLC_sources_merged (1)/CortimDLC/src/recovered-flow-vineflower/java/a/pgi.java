package a;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public final class pgi {
   public static final int SETTLE = 0;
   public static final int ACT = 1;
   public static final int PAGE = 2;
   public static final int CONFIRM = 3;
   public static final int SEARCH = 4;
   public static final int IDLE = 5;
   public static final int BUY = 6;
   private static final int pgj = 7;
   private static final long[] pgk = new long[]{380L, 500L, 460L, 580L, 1500L, 2300L, 1280L};
   private static final long[] pgl = new long[]{270L, 330L, 300L, 390L, 950L, 1200L, 900L};
   private static final long[] pgm = new long[]{1800L, 2300L, 1900L, 2500L, 6000L, 8500L, 9000L};
   private static final double[] pgn = new double[]{0.3, 0.3, 0.3, 0.3, 0.4, 0.45, 0.55};
   private static final double[] pgo = new double[]{0.09, 0.09, 0.09, 0.09, 0.1, 0.12, 0.18};
   private static final double pgp = 0.5;
   private static final double pgq = 1.5;
   private static final double pgr = 0.12;
   private static final int pgs = 12;
   private static final double pgt = 0.82;
   private static final double pgu = 1.35;
   private static final double pgv = 0.08;
   private static final double pgw = 0.012;
   private static final int pgx = 25;
   private static final int pgy = 90;
   private final long[] pgz = new long[7];
   private double pha;
   private double phb;
   private int phc;

   public pgi() {
      this.reset();
   }

   public void reset() {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      this.pha = var1.nextDouble(0.82, 1.35);
      this.phb = var1.nextDouble(0.82, 1.35);
      this.phc = var1.nextInt(25, 90);
      Arrays.fill(this.pgz, 0L);
   }

   public long draw(int var1) {
      return this.draw(var1, 1.0);
   }

   public long draw(int var1, double var2) {
      long var4 = this.phf(var1);
      return var2 <= 1.0 ? var4 : Math.round(var4 * var2);
   }

   private long phf(int var1) {
      this.phi();
      ThreadLocalRandom var2 = ThreadLocalRandom.current();
      double var3 = pgk[var1];
      long var5 = pgl[var1];
      long var7 = pgm[var1];
      long var9 = Math.round(var3 * this.pha * phg(var1, var2));

      for (int var11 = 0; var11 < 12 && (var9 < var5 || var9 > var7); var11++) {
         var9 = Math.round(var3 * this.pha * phg(var1, var2));
      }

      var9 = this.phh(var1, Math.max(var5, Math.min(var7, var9)), var5, var7);
      this.pgz[var1] = var9;
      return var9;
   }

   private static double phg(int var0, ThreadLocalRandom var1) {
      return var1.nextDouble() < pgo[var0] ? 1.5 * Math.exp(0.5 * Math.abs(var1.nextGaussian())) : Math.exp(pgn[var0] * var1.nextGaussian());
   }

   private long phh(int var1, long var2, long var4, long var6) {
      long var8 = this.pgz[var1];
      if (var8 <= 0L) {
         return var2;
      } else {
         long var10 = Math.max(1L, Math.round(var8 * 0.12));
         if (Math.abs(var2 - var8) >= var10) {
            return var2;
         } else {
            long var12 = var8 + var10;
            long var14 = var8 - var10;
            boolean var16 = var12 <= var6;
            boolean var17 = var14 >= var4;
            if (var2 >= var8) {
               return var16 ? var12 : (var17 ? var14 : var2);
            } else {
               return var17 ? var14 : (var16 ? var12 : var2);
            }
         }
      }
   }

   private void phi() {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      if (--this.phc <= 0) {
         this.phb = var1.nextDouble(0.82, 1.35);
         this.phc = var1.nextInt(25, 90);
      }

      this.pha = this.pha + ((this.phb - this.pha) * 0.08 + var1.nextGaussian() * 0.012);
      this.pha = Math.max(0.82, Math.min(1.35, this.pha));
   }
}
