package a;

import flow.dev.a;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.block.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.World;

public final class enq {
   private static final int enr = 128;
   private static final int ens = 16;
   private static final int ent = 4;
   public static final double SHUFFLED_SEAMS = 2.0;

   private enq() {
   }

   public static BufferedImage capture(ItemFrameEntity var0) {
      World var1 = var0.method_73183();
      Direction var2 = var0.method_5735();
      if (var2.method_10166() != Axis.field_11052 && var0.method_6940().method_7909() instanceof FilledMapItem) {
         boolean var3 = var2.method_10166() == Axis.field_11051;
         boolean var4 = var2 == Direction.field_11043 || var2 == Direction.field_11034;
         int var5 = eob(var0.method_59940(), var3);
         List var6 = var1.method_8390(
            ItemFrameEntity.class,
            var0.method_5829().method_1014(16.0),
            var3x -> var3x.method_5735() == var2 && eob(var3x.method_59940(), var3) == var5 && var3x.method_6940().method_7909() instanceof FilledMapItem
         );
         List var7 = eoa(var6, var0);
         if (var7.isEmpty()) {
            return null;
         } else {
            int var8 = Integer.MAX_VALUE;
            int var9 = Integer.MIN_VALUE;
            int var10 = Integer.MAX_VALUE;
            int var11 = Integer.MIN_VALUE;
            HashSet var12 = new HashSet();

            for (ItemFrameEntity var14 : var7) {
               BlockPos var15 = var14.method_59940();
               if (!var12.add(var15)) {
                  return null;
               }

               int var16 = var3 ? var15.method_10263() : var15.method_10260();
               var8 = Math.min(var8, var16);
               var9 = Math.max(var9, var16);
               var10 = Math.min(var10, var15.method_10264());
               var11 = Math.max(var11, var15.method_10264());
            }

            int var30 = var9 - var8 + 1;
            int var31 = var11 - var10 + 1;
            if (var30 <= 16 && var31 <= 16 && var7.size() >= 2 && var7.size() * 2 >= var30 * var31) {
               BufferedImage var32 = new BufferedImage(var30 * 128, var31 * 128, 2);
               Graphics2D var33 = var32.createGraphics();

               try {
                  for (ItemFrameEntity var18 : var7) {
                     MapState var19 = FilledMapItem.method_8001(var18.method_6940(), var1);
                     if (var19 == null || var19.field_122 == null || var19.field_122.length != 16384) {
                        return null;
                     }

                     BufferedImage var20 = new BufferedImage(128, 128, 2);
                     boolean var21 = false;

                     for (int var22 = 0; var22 < var19.field_122.length; var22++) {
                        int var23 = var19.field_122[var22] & 255;
                        var21 |= var23 >= 4;
                        var20.setRGB(var22 % 128, var22 / 128, var23 < 4 ? 0 : MapColor.method_38480(var23));
                     }

                     if (!var21) {
                        return null;
                     }

                     BlockPos var35 = var18.method_59940();
                     int var37 = var3 ? var35.method_10263() : var35.method_10260();
                     int var24 = (var4 ? var9 - var37 : var37 - var8) * 128;
                     int var25 = (var11 - var35.method_10264()) * 128;
                     AffineTransform var26 = AffineTransform.getTranslateInstance(var24, var25);
                     var26.rotate((var18.method_6934() & 3) * Math.PI / 2.0, 64.0, 64.0);
                     var33.drawImage(var20, var26, null);
                  }

                  return var32;
               } finally {
                  var33.dispose();
               }
            } else {
               return null;
            }
         }
      } else {
         return null;
      }
   }

   public static BufferedImage captureNearest(World var0, Entity var1) {
      for (List var3 : findWalls(var0, var1, 24.0)) {
         BufferedImage var4 = capture(var3.stream().min(Comparator.comparingDouble(var1x -> var1x.method_5858(var1))).orElseThrow());
         if (var4 != null && !isShuffled(var4)) {
            return var4;
         }
      }

      return null;
   }

   public static List<List<ItemFrameEntity>> findWalls(World var0, Entity var1, double var2) {
      Vec3d var4 = var1.method_33571();
      List var5 = var0.method_8390(
         ItemFrameEntity.class,
         var1.method_5829().method_1014(var2),
         var1x -> var1x.method_5735().method_10166() != Axis.field_11052 && var1x.method_6940().method_7909() instanceof FilledMapItem && enx(var1x, var4)
      );
      Vec3d var6 = var1.method_5828(1.0F);
      List var7 = enz(var5);
      var7.removeIf(var0x -> var0x.size() < 2);
      var7.sort(Comparator.<List>comparingInt(var0x -> var0x.size() >= 4 ? 0 : 1).thenComparingDouble(var2x -> eny((List<ItemFrameEntity>)var2x, var4, var6)));
      return var7;
   }

   public static double seamRatio(int[] var0, int var1, int var2) {
      double var3 = 0.0;
      double var5 = 0.0;
      long var7 = 0L;
      long var9 = 0L;

      for (int var11 = 0; var11 < var2; var11++) {
         for (int var12 = 0; var12 < var1; var12++) {
            int var13 = var0[var11 * var1 + var12];
            if (var13 >>> 24 != 0) {
               if (var12 + 1 < var1 && var0[var11 * var1 + var12 + 1] >>> 24 != 0) {
                  double var14 = enw(var13, var0[var11 * var1 + var12 + 1]);
                  if ((var12 + 1) % 128 == 0) {
                     var3 += var14;
                     var7++;
                  } else {
                     var5 += var14;
                     var9++;
                  }
               }

               if (var11 + 1 < var2 && var0[(var11 + 1) * var1 + var12] >>> 24 != 0) {
                  double var16 = enw(var13, var0[(var11 + 1) * var1 + var12]);
                  if ((var11 + 1) % 128 == 0) {
                     var3 += var16;
                     var7++;
                  } else {
                     var5 += var16;
                     var9++;
                  }
               }
            }
         }
      }

      return var7 != 0L && var9 != 0L && !(var5 <= 0.0) ? var3 / var7 / (var5 / var9) : 0.0;
   }

   public static boolean isShuffled(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      return seamRatio(var0.getRGB(0, 0, var1, var2, null, 0, var1), var1, var2) > 2.0;
   }

   private static double enw(int var0, int var1) {
      return (Math.abs((var0 >> 16 & 0xFF) - (var1 >> 16 & 0xFF)) + Math.abs((var0 >> 8 & 0xFF) - (var1 >> 8 & 0xFF)) + Math.abs((var0 & 0xFF) - (var1 & 0xFF)))
         / 3.0;
   }

   private static boolean enx(ItemFrameEntity var0, Vec3d var1) {
      Direction var2 = var0.method_5735();
      Vec3d var3 = var1.method_1020(var0.method_73189());
      return var3.field_1352 * var2.method_10148() + var3.field_1350 * var2.method_10165() > 0.25;
   }

   private static double eny(List<ItemFrameEntity> var0, Vec3d var1, Vec3d var2) {
      double var3 = Double.MAX_VALUE;
      Vec3d var5 = Vec3d.field_1353;

      for (ItemFrameEntity var7 : var0) {
         var3 = Math.min(var3, var7.method_73189().method_1022(var1));
         var5 = var5.method_1019(var7.method_73189());
      }

      Vec3d var8 = var5.method_1021(1.0 / var0.size()).method_1020(var1).method_1029();
      return var3 * (1.5 - 0.5 * var8.method_1026(var2));
   }

   private static List<List<ItemFrameEntity>> enz(List<ItemFrameEntity> var0) {
      HashMap var1 = new HashMap();

      for (ItemFrameEntity var3 : var0) {
         boolean var4 = var3.method_5735().method_10166() == Axis.field_11051;
         long var5 = (long)var3.method_5735().ordinal() << 32 | eob(var3.method_59940(), var4) & 4294967295L;
         var1.computeIfAbsent(var5, var0x -> new ArrayList<>()).add(var3);
      }

      ArrayList var7 = new ArrayList();

      for (List var9 : var1.values()) {
         ArrayList var10 = new ArrayList(var9);

         while (!var10.isEmpty()) {
            List var6 = eoa(var10, (ItemFrameEntity)var10.get(0));
            var10.removeAll(var6);
            var7.add(var6);
         }
      }

      return var7;
   }

   private static List<ItemFrameEntity> eoa(List<ItemFrameEntity> var0, ItemFrameEntity var1) {
      boolean var2 = var1.method_5735().method_10166() == Axis.field_11051;
      ArrayList var3 = new ArrayList();
      HashSet var4 = new HashSet();
      ArrayDeque var5 = new ArrayDeque();
      var5.add(var1);
      var4.add(var1);

      while (!var5.isEmpty()) {
         ItemFrameEntity var6 = (ItemFrameEntity)var5.poll();
         var3.add(var6);
         BlockPos var7 = var6.method_59940();
         int var8 = var2 ? var7.method_10263() : var7.method_10260();

         for (ItemFrameEntity var10 : var0) {
            if (!var4.contains(var10)) {
               BlockPos var11 = var10.method_59940();
               int var12 = Math.abs((var2 ? var11.method_10263() : var11.method_10260()) - var8);
               if (var12 <= 1 && Math.abs(var11.method_10264() - var7.method_10264()) <= 1) {
                  var4.add(var10);
                  var5.add(var10);
               }
            }
         }
      }

      return var3;
   }

   public static byte[] encodePng(BufferedImage var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      if (!ImageIO.write(var0, a.b("स炗祉", -963507893), var1)) {
         throw new IOException(a.c(1744907341, "Ⰺ喥\udf7f䅩쫻䱁\uf61f翢\ue1b6欆\uecc2ᛡ顣ǉ讕൳뜫㣲ꉄ␘귬ힳ変"));
      } else {
         return var1.toByteArray();
      }
   }

   private static int eob(BlockPos var0, boolean var1) {
      return var1 ? var0.method_10260() : var0.method_10263();
   }
}
