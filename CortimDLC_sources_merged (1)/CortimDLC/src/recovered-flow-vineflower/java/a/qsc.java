package a;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.util.math.BlockPos;

public final class qsc {
   private static final double qsd = 4.0;
   private static final double qse = 1.5;
   private final List<qrz> qsf = new ArrayList<>();
   private final LongOpenHashSet qsg = new LongOpenHashSet();
   private LongOpenHashSet qsh;

   public void clear() {
      this.qsf.clear();
      this.qsg.clear();
      this.qsh = null;
   }

   public boolean isEmpty() {
      return this.qsf.isEmpty();
   }

   public int size() {
      return this.qsf.size();
   }

   public BlockPos headCenter() {
      if (this.qsf.isEmpty()) {
         return null;
      }

      qrz var1 = this.qsf.get(0);
      return BlockPos.ofFloored(var1.x, var1.y, var1.z);
   }

   public LongOpenHashSet head() {
      if (this.qsf.isEmpty()) {
         return null;
      }

      if (this.qsh == null) {
         this.qsh = new LongOpenHashSet(this.qsf.get(0).ores);
      }

      return this.qsh;
   }

   public void dropHead() {
      if (!this.qsf.isEmpty()) {
         this.qsf.remove(0);
         this.qsh = null;
      }
   }

   public void update(LongArrayList var1, double var2, double var4, double var6) {
      LongOpenHashSet var8 = new LongOpenHashSet(var1);
      this.qsg.clear();

      for (int var9 = this.qsf.size() - 1; var9 >= 0; var9--) {
         qrz var10 = this.qsf.get(var9);
         int var11 = var10.ores.size();
         var10.ores.removeIf(var1x -> !var8.contains(var1x));
         if (var10.ores.isEmpty()) {
            this.qsf.remove(var9);
            if (var9 == 0) {
               this.qsh = null;
            }
         } else {
            if (var10.ores.size() != var11) {
               var10.center();
               if (var9 == 0) {
                  this.qsh = null;
               }
            }

            this.qsg.addAll(var10.ores);
         }
      }

      LongArrayList var13 = new LongArrayList();

      for (int var14 = 0; var14 < var1.size(); var14++) {
         long var16 = var1.getLong(var14);
         if (!this.qsg.contains(var16)) {
            var13.add(var16);
         }
      }

      if (!var13.isEmpty()) {
         List var15 = qsl(var13);

         for (qrz var12 : var15) {
            this.qsg.addAll(var12.ores);
         }

         if (this.qsf.isEmpty()) {
            this.qsf.addAll(qsm(var15, var2, var4, var6));
            qsn(this.qsf, 0, var2, var4, var6, 40);
            this.qsh = null;
         } else {
            for (qrz var20 : var15) {
               this.qsk(var20, var2, var4, var6);
            }

            qrz var19 = this.qsf.get(0);
            qsn(this.qsf, 1, var19.x, var19.y, var19.z, 8);
         }
      }
   }

   private void qsk(qrz var1, double var2, double var4, double var6) {
      int var8 = this.qsf.size();
      int var9 = var8;
      double var10 = Double.MAX_VALUE;
      boolean var12 = qso(var2, var4, var6, var1.x, var1.y, var1.z) <= 4.0;

      for (int var13 = var12 ? 0 : 1; var13 <= var8; var13++) {
         double var14 = var13 == 0 ? var2 : this.qsf.get(var13 - 1).x;
         double var16 = var13 == 0 ? var4 : this.qsf.get(var13 - 1).y;
         double var18 = var13 == 0 ? var6 : this.qsf.get(var13 - 1).z;
         double var20 = qso(var14, var16, var18, var1.x, var1.y, var1.z);
         if (var13 < var8) {
            qrz var22 = this.qsf.get(var13);
            var20 += qso(var1.x, var1.y, var1.z, var22.x, var22.y, var22.z) - qso(var14, var16, var18, var22.x, var22.y, var22.z);
         }

         if (var20 < var10) {
            var10 = var20;
            var9 = var13;
         }
      }

      this.qsf.add(var9, var1);
      if (var9 == 0) {
         this.qsh = null;
      }
   }

   private static List<qrz> qsl(LongArrayList var0) {
      ArrayList var1 = new ArrayList();
      LongArrayList var2 = new LongArrayList(var0);

      while (!var2.isEmpty()) {
         long var3 = var2.removeLong(var2.size() - 1);
         qrz var5 = new qrz();
         var5.ores.add(var3);
         int var6 = BlockPos.unpackLongX(var3);
         int var7 = BlockPos.unpackLongY(var3);
         int var8 = BlockPos.unpackLongZ(var3);

         for (int var9 = 0; var9 < var5.ores.size(); var9++) {
            long var10 = var5.ores.getLong(var9);
            int var12 = BlockPos.unpackLongX(var10);
            int var13 = BlockPos.unpackLongY(var10);
            int var14 = BlockPos.unpackLongZ(var10);

            for (int var15 = var2.size() - 1; var15 >= 0; var15--) {
               long var16 = var2.getLong(var15);
               int var18 = BlockPos.unpackLongX(var16);
               int var19 = BlockPos.unpackLongY(var16);
               int var20 = BlockPos.unpackLongZ(var16);
               if (Math.abs(var18 - var12) <= 2
                  && Math.abs(var19 - var13) <= 2
                  && Math.abs(var20 - var14) <= 2
                  && Math.abs(var18 - var6) <= 3
                  && Math.abs(var19 - var7) <= 3
                  && Math.abs(var20 - var8) <= 3) {
                  var5.ores.add(var16);
                  var2.removeLong(var15);
               }
            }
         }

         var5.center();
         var1.add(var5);
      }

      return var1;
   }

   private static List<qrz> qsm(List<qrz> var0, double var1, double var3, double var5) {
      ArrayList var7 = new ArrayList(var0);
      ArrayList var8 = new ArrayList(var0.size());
      double var9 = var1;
      double var11 = var3;
      double var13 = var5;

      while (!var7.isEmpty()) {
         int var15 = 0;
         double var16 = Double.MAX_VALUE;

         for (int var18 = 0; var18 < var7.size(); var18++) {
            qrz var19 = (qrz)var7.get(var18);
            double var20 = qso(var9, var11, var13, var19.x, var19.y, var19.z);
            if (var20 < var16) {
               var16 = var20;
               var15 = var18;
            }
         }

         qrz var22 = (qrz)var7.remove(var15);
         var8.add(var22);
         var9 = var22.x;
         var11 = var22.y;
         var13 = var22.z;
      }

      return var8;
   }

   private static void qsn(List<qrz> var0, int var1, double var2, double var4, double var6, int var8) {
      int var9 = var0.size();
      boolean var10 = true;

      for (int var11 = 0; var10 && var11 < var8; var11++) {
         var10 = false;

         for (int var12 = var1; var12 < var9 - 1; var12++) {
            double var13 = var12 == var1 ? var2 : ((qrz)var0.get(var12 - 1)).x;
            double var15 = var12 == var1 ? var4 : ((qrz)var0.get(var12 - 1)).y;
            double var17 = var12 == var1 ? var6 : ((qrz)var0.get(var12 - 1)).z;

            for (int var19 = var12 + 1; var19 < var9; var19++) {
               qrz var20 = (qrz)var0.get(var12);
               qrz var21 = (qrz)var0.get(var19);
               qrz var22 = var19 + 1 < var9 ? (qrz)var0.get(var19 + 1) : null;
               double var23 = qso(var13, var15, var17, var20.x, var20.y, var20.z)
                  + (var22 == null ? 0.0 : qso(var21.x, var21.y, var21.z, var22.x, var22.y, var22.z));
               double var25 = qso(var13, var15, var17, var21.x, var21.y, var21.z)
                  + (var22 == null ? 0.0 : qso(var20.x, var20.y, var20.z, var22.x, var22.y, var22.z));
               if (var25 < var23 - 1.0E-6) {
                  Collections.reverse(var0.subList(var12, var19 + 1));
                  var10 = true;
               }
            }
         }
      }
   }

   private static double qso(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var0 - var6;
      double var14 = (var2 - var8) * 1.5;
      double var16 = var4 - var10;
      return Math.sqrt(var12 * var12 + var14 * var14 + var16 * var16);
   }
}
