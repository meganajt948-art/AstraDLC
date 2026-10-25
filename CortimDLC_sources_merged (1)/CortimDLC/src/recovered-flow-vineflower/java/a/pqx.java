package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class pqx {
   private static final int pqy = 6000;
   private static final int pqz = 100;
   public static final double STEP_HEIGHT = 0.6;
   public static final double JUMP_HEIGHT = 1.2;
   private static final double pra = 8.0;
   private static final int[][] prb = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
   private static final int[][] prc = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
   private static final Direction[] prd = new Direction[]{Direction.field_11043, Direction.field_11035, Direction.field_11034, Direction.field_11039};

   private pqx() {
   }

   public static List<BlockPos> findPath(BlockPos var0, BlockPos var1, List<BlockPos> var2, double var3, boolean var5) {
      return findPath(var0, var1, var2, var3, var5, Collections.emptySet());
   }

   public static List<BlockPos> findPath(BlockPos var0, BlockPos var1, List<BlockPos> var2, double var3, boolean var5, Set<BlockPos> var6) {
      MinecraftClient var7 = MinecraftClient.method_1551();
      return var7.field_1687 == null ? null : findPath(var7.field_1687, var7.field_1724, var0, var1, var2, var3, var5, var6);
   }

   public static List<BlockPos> findPath(
      BlockView var0, Entity var1, BlockPos var2, BlockPos var3, List<BlockPos> var4, double var5, boolean var7, Set<BlockPos> var8
   ) {
      return findPath(var0, var1, var2, var3, var4, var5, var7, var8, null);
   }

   public static List<BlockPos> findPath(
      BlockView var0, Entity var1, BlockPos var2, BlockPos var3, List<BlockPos> var4, double var5, boolean var7, Set<BlockPos> var8, pqq var9
   ) {
      HashMap var10 = var7 ? new HashMap() : null;
      PriorityQueue var11 = new PriorityQueue<>(Comparator.comparingDouble(pqj::fCost));
      HashMap var12 = new HashMap();
      HashSet var13 = new HashSet();
      pqj var14 = new pqj(var2);
      var14.pqm = 0.0;
      var14.pqn = prn(var2, var3);
      var11.add(var14);
      var12.put(var2, 0.0);
      pqj var15 = var14;
      double var16 = var14.pqn;
      ArrayList var18 = new ArrayList(8);
      int var19 = 0;

      while (!var11.isEmpty() && var19++ < 6000) {
         pqj var20 = (pqj)var11.poll();
         if (var13.add(var20.pqk)) {
            if (var20.pqn < var16) {
               var16 = var20.pqn;
               var15 = var20;
            }

            if (prn(var20.pqk, var3) <= 2.0 && prm(var0, var1, var20.pqk, var3)) {
               return pro(var20);
            }

            double var21 = getStandY(var0, var20.pqk);
            List var23 = neighbors(var0, var20.pqk, var4, var5, var8, var18);

            for (int var24 = 0; var24 < var23.size(); var24++) {
               BlockPos var25 = (BlockPos)var23.get(var24);
               if (!var13.contains(var25)) {
                  double var26 = prn(var20.pqk, var25);
                  if (var9 != null) {
                     var26 *= var9.at(var25.method_10263(), var25.method_10260());
                  }

                  double var28 = getStandY(var0, var25) - var21;
                  if ((Boolean)var18.get(var24)) {
                     var26 += 0.5;
                  }

                  if (var28 < -1.5) {
                     var26 += 0.2;
                  }

                  if (var10 != null && var28 < -3.2) {
                     var26 += (-var28 - 3.2) * 1.5;
                  }

                  if (var10 != null) {
                     var26 += prh(var0, var25, var10) * (var9 == null ? 1.0 : var9.wall);
                  }

                  if (isClimbable(var0, var25) || isClimbable(var0, var25.method_10084())) {
                     var26 += 8.0;
                  }

                  double var30 = var20.pqm + var26;
                  Double var32 = (Double)var12.get(var25);
                  if (var32 == null || !(var30 >= var32 - 1.0E-6)) {
                     var12.put(var25, var30);
                     pqj var33 = new pqj(var25);
                     var33.pqm = var30;
                     var33.pqn = prn(var25, var3);
                     var33.pql = var20;
                     var11.add(var33);
                  }
               }
            }
         }
      }

      return var15.pql != null ? pro(var15) : null;
   }

   public static double getStandY(BlockView var0, BlockPos var1) {
      BlockPos var2 = var1.method_10074();
      VoxelShape var3 = var0.method_8320(var2).method_26220(var0, var2);
      return var3.method_1110() ? var1.method_10264() : var2.method_10264() + var3.method_1105(Axis.field_11052);
   }

   static List<BlockPos> neighbors(BlockView var0, BlockPos var1, List<BlockPos> var2, double var3, Set<BlockPos> var5, List<Boolean> var6) {
      ArrayList var7 = new ArrayList(8);
      var6.clear();
      double var8 = getStandY(var0, var1);

      for (int[] var13 : prb) {
         int var14 = var13[0];
         int var15 = var13[1];
         boolean var16 = var14 != 0 && var15 != 0;
         if (!var16
            || prl(var0, var1.method_10069(var14, 0, 0))
               && prl(var0, var1.method_10069(0, 0, var15))
               && prl(var0, var1.method_10069(var14, 1, 0))
               && prl(var0, var1.method_10069(0, 1, var15))) {
            BlockPos var17 = var1.method_10069(var14, 0, var15);
            if (prj(var0, var17, var2, var3)) {
               if (!var5.contains(var17)) {
                  var7.add(var17);
                  var6.add(false);
               }
            } else {
               BlockPos var18 = var17.method_10084();
               if (prj(var0, var18, var2, var3)) {
                  if (!var5.contains(var18)) {
                     double var26 = getStandY(var0, var18);
                     double var21 = var26 - var8;
                     boolean var23 = var21 <= 0.6 || !var16 && prg(var0, var17, var14, var15, var8);
                     boolean var24 = !var23 && var21 <= 1.2 && !pri(var0, var17);
                     if (var23 || var24) {
                        boolean var25 = var24 || var26 + 1.8 > var1.method_10264() + 2.0 + 1.0E-4;
                        if (!var25
                           || prl(var0, var1.method_10086(2))
                              && (!var16 || prl(var0, var1.method_10069(var14, 2, 0)) && prl(var0, var1.method_10069(0, 2, var15)))) {
                           var7.add(var18);
                           var6.add(var24);
                        }
                     }
                  }
               } else if (prl(var0, var17.method_10084())) {
                  for (int var19 = 1; var19 <= 100; var19++) {
                     BlockPos var20 = var17.method_10087(var19);
                     if (!prl(var0, var20.method_10084()) || isClimbable(var0, var20.method_10084())) {
                        break;
                     }

                     if (prj(var0, var20, var2, var3)) {
                        if (!var5.contains(var20)) {
                           var7.add(var20);
                           var6.add(false);
                        }
                        break;
                     }
                  }
               }
            }
         }
      }

      return var7;
   }

   private static boolean prg(BlockView var0, BlockPos var1, int var2, int var3, double var4) {
      VoxelShape var6 = var0.method_8320(var1).method_26220(var0, var1);
      if (var6.method_1110()) {
         return false;
      } else {
         double var7 = var6.method_1105(Axis.field_11052);
         double var9 = var2 < 0 ? 0.5 : 0.0;
         double var11 = var2 > 0 ? 0.5 : 1.0;
         double var13 = var3 < 0 ? 0.5 : 0.0;
         double var15 = var3 > 0 ? 0.5 : 1.0;
         double var17 = 0.0;

         for (Box var20 : var6.method_1090()) {
            if (var20.field_1320 > var9 + 1.0E-4 && var20.field_1323 < var11 - 1.0E-4 && var20.field_1324 > var13 + 1.0E-4 && var20.field_1321 < var15 - 1.0E-4
               )
             {
               var17 = Math.max(var17, var20.field_1325);
            }
         }

         return var17 >= var7 - 1.0E-4 ? false : var1.method_10264() + var17 - var4 <= 0.6001 && var7 - var17 <= 0.6001;
      }
   }

   private static double prh(BlockView var0, BlockPos var1, Map<BlockPos, Double> var2) {
      Double var3 = (Double)var2.get(var1);
      if (var3 != null) {
         return var3;
      } else {
         double var4 = 0.0;

         for (Direction var9 : prd) {
            BlockPos var10 = var1.method_10093(var9);
            if (!prl(var0, var10) || !prl(var0, var10.method_10084())) {
               var4 += 0.32;
            }
         }

         for (int[] var14 : prc) {
            if (!prl(var0, var1.method_10069(var14[0], 0, var14[1])) || !prl(var0, var1.method_10069(var14[0], 1, var14[1]))) {
               var4 += 0.14;
            }
         }

         var2.put(var1.method_10062(), var4);
         return var4;
      }
   }

   private static boolean pri(BlockView var0, BlockPos var1) {
      BlockState var2 = var0.method_8320(var1);
      VoxelShape var3 = var2.method_26220(var0, var1);
      return var3.method_1110() ? false : var3.method_1105(Axis.field_11052) > 1.0;
   }

   private static boolean prj(BlockView var0, BlockPos var1, List<BlockPos> var2, double var3) {
      if (!var2.isEmpty() && var3 > 0.0) {
         double var5 = var3 * var3;

         for (BlockPos var8 : var2) {
            if (var1.method_10262(var8) <= var5) {
               return false;
            }
         }
      }

      if (prl(var0, var1) && prl(var0, var1.method_10084())) {
         BlockPos var13 = var1.method_10074();
         BlockState var6 = var0.method_8320(var13);
         if (prl(var0, var13) && !var6.method_27852(Blocks.field_10382)) {
            return false;
         } else if (pri(var0, var13)) {
            return false;
         } else if (prk(var6)) {
            return false;
         } else {
            BlockState var14 = var0.method_8320(var1);
            if (!var14.method_27852(Blocks.field_10164) && !var14.method_27852(Blocks.field_10036)) {
               for (Direction var11 : prd) {
                  BlockPos var12 = var1.method_10093(var11);
                  if (prk(var0.method_8320(var12)) || prk(var0.method_8320(var12.method_10074()))) {
                     return false;
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static boolean prk(BlockState var0) {
      return var0.method_27852(Blocks.field_10164)
         || var0.method_27852(Blocks.field_10036)
         || var0.method_27852(Blocks.field_17350)
         || var0.method_27852(Blocks.field_10092);
   }

   private static boolean prl(BlockView var0, BlockPos var1) {
      BlockState var2 = var0.method_8320(var1);
      return var2.method_26220(var0, var1).method_1110() && !var2.method_27852(Blocks.field_10164);
   }

   public static boolean isClimbable(BlockView var0, BlockPos var1) {
      return var0.method_8320(var1).method_26164(BlockTags.field_22414);
   }

   private static boolean prm(BlockView var0, Entity var1, BlockPos var2, BlockPos var3) {
      if (prn(var2, var3) > 4.0) {
         return false;
      } else {
         Vec3d var4 = new Vec3d(var2.method_10263() + 0.5, getStandY(var0, var2) + 1.62, var2.method_10260() + 0.5);
         Vec3d var5 = Vec3d.method_24953(var3);
         BlockHitResult var6 = var0.method_17742(
            new RaycastContext(
               var4, var5, ShapeType.field_17558, FluidHandling.field_1348, var1 == null ? ShapeContext.method_16194() : ShapeContext.method_16195(var1)
            )
         );
         return var6.method_17783() == Type.field_1333 || var6.method_17777().equals(var3);
      }
   }

   private static double prn(BlockPos var0, BlockPos var1) {
      double var2 = var0.method_10263() - var1.method_10263();
      double var4 = var0.method_10264() - var1.method_10264();
      double var6 = var0.method_10260() - var1.method_10260();
      return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   private static List<BlockPos> pro(pqj var0) {
      ArrayList var1 = new ArrayList();

      for (pqj var2 = var0; var2 != null && var2.pql != null; var2 = var2.pql) {
         var1.add(var2.pqk);
      }

      Collections.reverse(var1);
      return var1;
   }
}
