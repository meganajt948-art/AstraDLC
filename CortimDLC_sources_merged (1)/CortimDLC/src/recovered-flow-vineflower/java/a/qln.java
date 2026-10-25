package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongPredicate;
import it.unimi.dsi.fastutil.longs.Long2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Locale;
import net.minecraft.util.math.BlockPos;

public final class qln {
   public static final int FACE = 0;
   public static final int LOOK = 1;
   public static final int NONE = 2;
   private static final double qlo = 6.0;
   private static final int qlp = 20;
   private final double[] qlq = new double[3];
   private boolean qlr = true;
   private double qls = 4.0;
   private int qlt;
   private qlk qlu;

   public void wide(boolean var1) {
      this.qlr = var1;
      if (!var1) {
         this.qlu = null;
      }
   }

   public boolean wide() {
      return this.qlr;
   }

   public double p(int var1) {
      if (!this.qlr) {
         return var1 == 2 ? 1.0 : 0.0;
      } else {
         double var2 = Math.pow(3.0, this.qlq[0]);
         double var4 = Math.pow(3.0, this.qlq[1]);
         double var6 = Math.pow(3.0, this.qlq[2]);
         double var8 = var1 == 0 ? var2 : (var1 == 1 ? var4 : var6);
         return var8 / (var2 + var4 + var6);
      }
   }

   public int lag() {
      return (int)Math.ceil(this.qls);
   }

   public int votes() {
      return this.qlt;
   }

   public static double[] lookAxes(float var0, float var1) {
      double[] var2 = new double[3];
      double var3 = Math.abs(var1);
      double var5 = var3 >= 55.0 ? 1.0 : (var3 <= 40.0 ? 0.0 : (var3 - 40.0) / 15.0);
      double var7 = Math.toRadians(var0);
      double var9 = Math.abs(-Math.sin(var7));
      double var11 = Math.abs(Math.cos(var7));
      double var13 = Math.toDegrees(Math.atan2(var11, var9));
      double var15 = var13 <= 40.0 ? 1.0 : (var13 >= 50.0 ? 0.0 : (50.0 - var13) / 10.0);
      var2[0] = (1.0 - var5) * var15;
      var2[1] = var5;
      var2[2] = (1.0 - var5) * (1.0 - var15);
      return var2;
   }

   public double expect(long var1, long var3, int var5, double[] var6) {
      if (var1 == var3) {
         return 1.0;
      } else {
         int var7 = BlockPos.method_10061(var1) - BlockPos.method_10061(var3);
         int var8 = BlockPos.method_10071(var1) - BlockPos.method_10071(var3);
         int var9 = BlockPos.method_10083(var1) - BlockPos.method_10083(var3);
         if (Math.abs(var7) <= 1 && Math.abs(var8) <= 1 && Math.abs(var9) <= 1) {
            if (!this.qlr) {
               return 0.0;
            } else {
               double var10 = 0.0;
               if (qlx(var7, var8, var9, var5) == 0) {
                  var10 += this.p(0);
               }

               double var12 = this.p(1);

               for (int var14 = 0; var14 < 3; var14++) {
                  if (var6[var14] > 0.0 && qlx(var7, var8, var9, var14) == 0) {
                     var10 += var12 * var6[var14];
                  }
               }

               return var10;
            }
         } else {
            return 0.0;
         }
      }
   }

   private static int qlx(int var0, int var1, int var2, int var3) {
      return var3 == 0 ? var0 : (var3 == 1 ? var1 : var2);
   }

   public boolean probing() {
      return this.qlu != null;
   }

   public void open(long var1, int var3, int var4, double[] var5, LongPredicate var6, LongOpenHashSet var7) {
      if (this.qlr) {
         qlk var8 = new qlk(var1, var3, var4, var5);
         int var9 = BlockPos.method_10061(var1);
         int var10 = BlockPos.method_10071(var1);
         int var11 = BlockPos.method_10083(var1);

         for (int var12 = -1; var12 <= 1; var12++) {
            for (int var13 = -1; var13 <= 1; var13++) {
               for (int var14 = -1; var14 <= 1; var14++) {
                  if (var12 != 0 || var13 != 0 || var14 != 0) {
                     int var15 = 0;
                     if (qlx(var12, var13, var14, var4) == 0) {
                        var15 |= 1;
                     }

                     for (int var16 = 0; var16 < 3; var16++) {
                        if (var5[var16] > 0.0 && qlx(var12, var13, var14, var16) == 0) {
                           var15 |= 2 << var16;
                        }
                     }

                     if (var15 != 0) {
                        long var18 = BlockPos.method_10064(var9 + var12, var10 + var13, var11 + var14);
                        if (!var7.contains(var18) && var6.test(var18)) {
                           var8.blocks.put(var18, var15);
                        }
                     }
                  }
               }
            }
         }

         if (!var8.blocks.isEmpty()) {
            this.qlu = var8;
         }
      }
   }

   public void exclude(LongOpenHashSet var1) {
      if (this.qlu != null) {
         ObjectIterator var2 = this.qlu.blocks.long2IntEntrySet().fastIterator();

         while (var2.hasNext()) {
            if (var1.contains(((Entry)var2.next()).getLongKey())) {
               var2.remove();
            }
         }

         if (this.qlu.blocks.isEmpty()) {
            this.qlu = null;
         }
      }
   }

   public void tick(int var1, LongPredicate var2) {
      qlk var3 = this.qlu;
      if (var3 != null) {
         int var4 = 0;
         LongOpenHashSet var5 = new LongOpenHashSet();
         ObjectIterator var6 = var3.blocks.long2IntEntrySet().iterator();

         while (var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            if (var2.test(var7.getLongKey())) {
               var5.add(var7.getLongKey());
               var4++;
            }
         }

         int var10 = var1 - var3.tick;
         if (var4 != 0 || var10 > 20) {
            this.qlu = null;
            if (var4 > 0) {
               this.qls = this.qls * 0.7 + Math.max(1, var10) * 0.3;
            }

            boolean var11 = qly(var3, 1, var5);
            boolean var8 = false;

            for (int var9 = 0; var9 < 3; var9++) {
               if (var3.look[var9] > 0.0 && qly(var3, 2 << var9, var5)) {
                  var8 = true;
               }
            }

            boolean var12 = var5.isEmpty();
            if (var11 != var8 || var8 != var12) {
               this.qlz(0, var11);
               this.qlz(1, var8);
               this.qlz(2, var12);
               this.qlt++;
            }
         }
      }
   }

   private static boolean qly(qlk var0, int var1, LongOpenHashSet var2) {
      ObjectIterator var3 = var0.blocks.long2IntEntrySet().iterator();

      while (var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         boolean var5 = (var4.getIntValue() & var1) != 0;
         if (var5 != var2.contains(var4.getLongKey())) {
            return false;
         }
      }

      return true;
   }

   private void qlz(int var1, boolean var2) {
      this.qlq[var1] = Math.max(-6.0, Math.min(6.0, this.qlq[var1] + (var2 ? 1.0 : -1.0)));
   }

   public String describe() {
      return String.format(
         Locale.ROOT,
         a.b("침랒㴊ꍨ⣹깏ᐞ鷩ϳ襇ຟ\uf4f2穱\ue386榙\uef6b唤\udaf1䀉왝価㗬묋ₜꚭⱽ闏ᮕ脧ݳ賋爆\uf81d憪\ue7f1浍틛壮\ude6b䟃춇덧㤢뻌␗ꨪᏴ饃Ὃ蒟૧\uf029秉ￗ", -1875849619),
         this.p(0),
         this.p(1),
         this.p(2),
         this.qlt,
         this.qls
      );
   }
}
