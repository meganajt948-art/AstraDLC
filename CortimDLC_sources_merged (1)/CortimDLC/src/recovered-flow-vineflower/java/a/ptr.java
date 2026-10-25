package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult.Success;
import net.minecraft.util.ActionResult.SwingSource;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class ptr {
   private static final Field pts = vxr.find(
      MinecraftClient.class,
      a.d("襇\uf0fd稿\ue414澀\ue935卡\uda9b䓂칢䦢돔㴑ꓺ⻤ꠚቘ鶛ܨ腕࣎犝ﰯ", -1390575708, 2014508698),
      a.c(-1826627949, "\udeffꝁ\u2d9e돦㠹뺳Ҏ赹ጤ馒"),
      a.b("栃", 841246795)
   );
   private static pth ptt = new pth();

   private ptr() {
   }

   public static pth swap(pth var0) {
      pth var1 = ptt;
      ptt = var0 == null ? new pth() : var0;
      return var1;
   }

   public static void aimAt(BlockPos var0, float var1, float var2) {
      pth var3 = ptt;
      var3.pti = var0;
      var3.ptj = var1;
      var3.ptk = var2;
      var3.ptm = false;
      var3.ptl = 2;
   }

   public static void miss() {
      pth var0 = ptt;
      var0.pti = null;
      var0.ptm = true;
      var0.ptl = 2;
   }

   public static void clear() {
      pth var0 = ptt;
      var0.pti = null;
      var0.ptm = false;
      var0.ptl = 0;
      var0.ptn.clear();
   }

   public static void later(Runnable var0) {
      pth var1 = ptt;
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (var0 != null && var1.ptn.size() < 4) {
         var1.ptn.add(var0);
         var1.pto = var2.field_1724 != null ? var2.field_1724.field_6012 : 0;
      }
   }

   public static boolean isOrdered() {
      pth var0 = ptt;
      return var0.ptl > 0 && (var0.pti != null || var0.ptm);
   }

   public static void apply(MinecraftClient var0) {
      pth var1 = ptt;

      try {
         ptx(var1, var0);
      } finally {
         ptw(var1, var0);
      }
   }

   public static void applyOwn(MinecraftClient var0) {
      pth var1 = ptt;

      try {
         pty(var1, var0);
      } finally {
         ptw(var1, var0);
      }
   }

   private static void ptw(pth var0, MinecraftClient var1) {
      if (!var0.ptn.isEmpty()) {
         if (var1 != null
            && var1.field_1724 != null
            && var1.field_1687 != null
            && var1.field_1724.field_6012 - var0.pto <= 3
            && var1.field_1724.field_6012 >= var0.pto) {
            Runnable var2;
            while ((var2 = var0.ptn.poll()) != null) {
               try {
                  var2.run();
               } catch (Exception var4) {
               }
            }
         } else {
            var0.ptn.clear();
         }
      }
   }

   private static void ptx(pth var0, MinecraftClient var1) {
      if (var0.ptl > 0 && (var0.pti != null || var0.ptm)) {
         var0.ptl--;
         if (var1 != null && var1.field_1724 != null && var1.field_1687 != null) {
            Vec3d var2 = var1.field_1724.method_33571();
            Vec3d var3 = Vec3d.method_1030(var0.ptk, var0.ptj);
            double var4 = var1.field_1724.method_55754();
            Vec3d var6 = var2.method_1031(var3.field_1352 * var4, var3.field_1351 * var4, var3.field_1350 * var4);
            if (var0.ptm) {
               var1.field_1765 = BlockHitResult.method_17778(var6, Direction.field_11036, BlockPos.method_49638(var6));
            } else {
               BlockHitResult var7 = var1.field_1687
                  .method_17742(new RaycastContext(var2, var6, ShapeType.field_17559, FluidHandling.field_1348, var1.field_1724));
               var1.field_1765 = var7.method_17783() == Type.field_1332 && var7.method_17777().equals(var0.pti)
                  ? var7
                  : BlockHitResult.method_17778(var6, Direction.field_11036, BlockPos.method_49638(var6));
            }
         }
      }
   }

   private static void pty(pth var0, MinecraftClient var1) {
      if (var0.ptl > 0 && (var0.pti != null || var0.ptm)) {
         var0.ptl--;
         if (var1 != null && var1.field_1724 != null && var1.field_1687 != null && var1.field_1690 != null && var1.field_1761 != null) {
            if (var0.ptm) {
               ptz(var1);
            } else {
               ClientPlayerEntity var2 = var1.field_1724;
               Vec3d var3 = var2.method_33571();
               Vec3d var4 = Vec3d.method_1030(var2.method_36455(), var2.method_36454());
               double var5 = var2.method_55754();
               Vec3d var7 = var3.method_1031(var4.field_1352 * var5, var4.field_1351 * var5, var4.field_1350 * var5);
               BlockHitResult var8 = var1.field_1687.method_17742(new RaycastContext(var3, var7, ShapeType.field_17559, FluidHandling.field_1348, var2));
               if (var8.method_17783() != Type.field_1332 || !var8.method_17777().equals(var0.pti)) {
                  var1.field_1690.field_1886.method_23481(false);
                  var1.field_1690.field_1904.method_23481(false);

                  while (var1.field_1690.field_1886.method_1436()) {
                  }

                  while (var1.field_1690.field_1904.method_1436()) {
                  }
               }
            }
         }
      }
   }

   private static void ptz(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.field_1724;

      while (var0.field_1690.field_1904.method_1436()) {
      }

      if (var0.field_1690.field_1904.method_1434() && !var1.method_6115()) {
         int var2 = vxr.getInt(pts, var0, 0);
         if (var2 <= 0 && !var0.field_1761.method_2923() && !var1.method_3144()) {
            for (Hand var6 : Hand.values()) {
               ItemStack var7 = var1.method_5998(var6);
               if (!var7.method_45435(var0.field_1687.method_45162())) {
                  break;
               }

               if (!var7.method_7960() && var0.field_1761.method_2919(var1, var6) instanceof Success var9) {
                  if (var9.comp_2909() == SwingSource.field_52427) {
                     var1.method_6104(var6);
                  }
                  break;
               }
            }

            var2 = 4;
         }

         vxr.setInt(pts, var0, Math.max(var2, 2));
      }
   }
}
