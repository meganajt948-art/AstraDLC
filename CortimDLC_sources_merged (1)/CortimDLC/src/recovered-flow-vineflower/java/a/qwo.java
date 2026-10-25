package a;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

public final class qwo {
   private static final int qwp = -11541505;
   private static final int qwq = -1;
   private static final int qwr = 600;
   private static final int[][] qws = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
   private static final int[][] qwt = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
   private static final int[][] qwu = new int[][]{
      {0, 1, 0, 2},
      {2, 3, 1, 2},
      {4, 5, 0, 3},
      {6, 7, 1, 3},
      {0, 2, 2, 4},
      {1, 3, 2, 5},
      {4, 6, 3, 4},
      {5, 7, 3, 5},
      {0, 4, 0, 4},
      {1, 5, 0, 5},
      {2, 6, 1, 4},
      {3, 7, 1, 5}
   };
   private static volatile long[] qwv = new long[0];
   private static volatile LongOpenHashSet qww = new LongOpenHashSet();
   private static volatile long qwx = Long.MIN_VALUE;
   private static long qwy = -1L;
   private static final double[][] qwz = new double[8][3];
   private static final float[][] qxa = new float[8][2];
   private static final boolean[] qxb = new boolean[8];
   private static final boolean[] qxc = new boolean[6];
   private static final float[] qxd = new float[4];
   private static final float[] qxe = new float[2];

   private qwo() {
   }

   public static boolean isDiamond(BlockState var0) {
      return var0.method_27852(Blocks.field_10442) || var0.method_27852(Blocks.field_29029);
   }

   public static void scan(World var0, pzc var1, Vec3d var2) {
      if (var0 != null && var1 != null && var1.maxX >= var1.minX) {
         LongArrayList var3 = new LongArrayList();
         Mutable var4 = new Mutable();

         for (int var5 = var1.minY; var5 <= var1.maxY; var5++) {
            for (int var6 = var1.minX; var6 <= var1.maxX; var6++) {
               for (int var7 = var1.minZ; var7 <= var1.maxZ; var7++) {
                  if (isDiamond(var0.method_8320(var4.method_10103(var6, var5, var7)))) {
                     var3.add(var4.method_10063());
                  }
               }
            }
         }

         if (var3.size() > 600) {
            var3.sort((var1x, var3x) -> Double.compare(qxh(var1x, var2), qxh(var3x, var2)));
            var3.size(600);
         }

         qwv = var3.toLongArray();
         qww = new LongOpenHashSet(var3);
      } else {
         clear();
      }
   }

   private static double qxh(long var0, Vec3d var2) {
      double var3 = BlockPos.method_10061(var0) + 0.5 - var2.field_1352;
      double var5 = BlockPos.method_10071(var0) + 0.5 - var2.field_1351;
      double var7 = BlockPos.method_10083(var0) + 0.5 - var2.field_1350;
      return var3 * var3 + var5 * var5 + var7 * var7;
   }

   public static void focus(BlockPos var0) {
      qwx = var0 == null ? Long.MIN_VALUE : var0.method_10063();
   }

   public static void clear() {
      if (qwv.length > 0) {
         qwv = new long[0];
         qww = new LongOpenHashSet();
      }

      qwx = Long.MIN_VALUE;
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      long[] var2 = qwv;
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var2.length != 0 && var3.field_1687 != null && var3.field_1724 != null && !var3.field_1690.field_1842 && !(var3.field_1755 instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != qwy) {
            qwy = unf.frame();

            usn var4;
            try {
               var4 = usn.capture(var1.method_60637(true), var0.method_51421(), var0.method_51443());
            } catch (Throwable var30) {
               return;
            }

            uut.beginFrame();
            LongOpenHashSet var5 = qww;
            long var6 = qwx;
            Vec3d var8 = var4.camera();
            float var9 = var4.width();
            float var10 = var4.height();
            uut.beginBatch();

            try {
               for (long var14 : var2) {
                  double var16 = BlockPos.method_10061(var14);
                  double var18 = BlockPos.method_10071(var14);
                  double var20 = BlockPos.method_10083(var14);
                  if (!(var4.depth(var16 + 0.5, var18 + 0.5, var20 + 0.5) < -1.0F)) {
                     if (var4.depth(var16 + 0.5, var18 + 0.5, var20 + 0.5) > 2.0F && var4.project(var16 + 0.5, var18 + 0.5, var20 + 0.5, qxe)) {
                        float var22 = var4.unitsPerBlock(var16 + 0.5, var18 + 0.5, var20 + 0.5) * 0.9F;
                        if (qxe[0] < -var22 || qxe[1] < -var22 || qxe[0] > var9 + var22 || qxe[1] > var10 + var22) {
                           continue;
                        }
                     }

                     boolean var32 = var14 == var6;
                     int var23 = 0;
                     if (!var32) {
                        for (int var24 = 0; var24 < 6; var24++) {
                           long var25 = BlockPos.method_10096(var14, qwt[var24][0], qwt[var24][1], qwt[var24][2]);
                           if (var25 != var6 && var5.contains(var25)) {
                              var23 |= 1 << var24;
                           }
                        }
                     }

                     cube(var0, var4, var8, var16, var18, var20, var32 ? -1 : -11541505, var23, var32 ? 1.6F : 1.0F, var32 ? 0.28F : 0.16F);
                  }
               }
            } finally {
               uut.endBatch();
            }
         }
      }
   }

   public static void cube(DrawContext var0, usn var1, Vec3d var2, double var3, double var5, double var7, int var9, int var10, float var11, float var12) {
      double var13 = 0.004;
      double var15 = var3 - var13;
      double var17 = var5 - var13;
      double var19 = var7 - var13;
      double var21 = var3 + 1.0 + var13;
      double var23 = var5 + 1.0 + var13;
      double var25 = var7 + 1.0 + var13;

      for (int var27 = 0; var27 < 8; var27++) {
         qwz[var27][0] = (var27 & 1) == 0 ? var15 : var21;
         qwz[var27][1] = (var27 & 2) == 0 ? var17 : var23;
         qwz[var27][2] = (var27 & 4) == 0 ? var19 : var25;
         qxb[var27] = var1.depth(qwz[var27][0], qwz[var27][1], qwz[var27][2]) > 0.05F && var1.project(qwz[var27][0], qwz[var27][1], qwz[var27][2], qxa[var27]);
      }

      qxc[0] = var2.field_1351 < var17;
      qxc[1] = var2.field_1351 > var23;
      qxc[2] = var2.field_1350 < var19;
      qxc[3] = var2.field_1350 > var25;
      qxc[4] = var2.field_1352 < var15;
      qxc[5] = var2.field_1352 > var21;
      int var35 = ujt.withAlpha(var9, Math.round(255.0F * var12));

      for (int var28 = 0; var28 < 6; var28++) {
         int[] var29 = qws[var28];
         if (qxc[var28] && (var10 & 1 << var28) == 0 && qxb[var29[0]] && qxb[var29[1]] && qxb[var29[2]] && qxb[var29[3]]) {
            uut.quad(
               var0,
               qxa[var29[0]][0],
               qxa[var29[0]][1],
               var35,
               qxa[var29[1]][0],
               qxa[var29[1]][1],
               var35,
               qxa[var29[2]][0],
               qxa[var29[2]][1],
               var35,
               qxa[var29[3]][0],
               qxa[var29[3]][1],
               var35
            );
         }
      }

      int var36 = ujt.withAlpha(var9, 235);

      for (int[] var32 : qwu) {
         if ((var10 & (1 << var32[2] | 1 << var32[3])) == 0 && (qxc[var32[2]] || qxc[var32[3]])) {
            double[] var33 = qwz[var32[0]];
            double[] var34 = qwz[var32[1]];
            if (var1.projectSegment(var33[0], var33[1], var33[2], var34[0], var34[1], var34[2], 0.05F, qxd, qxe)) {
               uut.line(var0, qxd[0], qxd[1], qxd[2], qxd[3], var11, var36);
            }
         }
      }
   }
}
