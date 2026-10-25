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
   static final Field pts = vxr.find(
      MinecraftClient.class,
      a.d("襇\uf0fd稿\ue414澀\ue935卡\uda9b䓂칢䦢돔㴑ꓺ⻤ꠚቘ鶛ܨ腕࣎犝ﰯ", -1390575708, 2014508698),
      a.c(-1826627949, "\udeffꝁ\u2d9e돦㠹뺳Ҏ赹ጤ馒"),
      a.b("栃", 841246795)
   );
   static pth ptt = new pth();

   ptr() {
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
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var0 != null && var1.ptn.size() < 4) {
         var1.ptn.add(var0);
         var1.pto = var2.player != null ? var2.player.age : 0;
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

   static void ptw(pth var0, MinecraftClient var1) {
      if (!var0.ptn.isEmpty()) {
         if (var1 != null && var1.player != null && var1.world != null && var1.player.age - var0.pto <= 3 && var1.player.age >= var0.pto) {
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

   static void ptx(pth var0, MinecraftClient var1) {
      if (var0.ptl > 0 && (var0.pti != null || var0.ptm)) {
         var0.ptl--;
         if (var1 != null && var1.player != null && var1.world != null) {
            Vec3d var2 = var1.player.getEyePos();
            Vec3d var3 = Vec3d.fromPolar(var0.ptk, var0.ptj);
            double var4 = var1.player.getBlockInteractionRange();
            Vec3d var6 = var2.add(var3.x * var4, var3.y * var4, var3.z * var4);
            if (var0.ptm) {
               var1.crosshairTarget = BlockHitResult.createMissed(var6, Direction.UP, BlockPos.ofFloored(var6));
            } else {
               BlockHitResult var7 = var1.world.raycast(new RaycastContext(var2, var6, ShapeType.OUTLINE, FluidHandling.NONE, var1.player));
               var1.crosshairTarget = var7.getType() == Type.BLOCK && var7.getBlockPos().equals(var0.pti)
                  ? var7
                  : BlockHitResult.createMissed(var6, Direction.UP, BlockPos.ofFloored(var6));
            }
         }
      }
   }

   static void pty(pth var0, MinecraftClient var1) {
      if (var0.ptl > 0 && (var0.pti != null || var0.ptm)) {
         var0.ptl--;
         if (var1 != null && var1.player != null && var1.world != null && var1.options != null && var1.interactionManager != null) {
            if (var0.ptm) {
               ptz(var1);
            } else {
               ClientPlayerEntity var2 = var1.player;
               Vec3d var3 = var2.getEyePos();
               Vec3d var4 = Vec3d.fromPolar(var2.getPitch(), var2.getYaw());
               double var5 = var2.getBlockInteractionRange();
               Vec3d var7 = var3.add(var4.x * var5, var4.y * var5, var4.z * var5);
               BlockHitResult var8 = var1.world.raycast(new RaycastContext(var3, var7, ShapeType.OUTLINE, FluidHandling.NONE, var2));
               if (var8.getType() != Type.BLOCK || !var8.getBlockPos().equals(var0.pti)) {
                  var1.options.attackKey.setPressed(false);
                  var1.options.useKey.setPressed(false);

                  while (var1.options.attackKey.wasPressed()) {
                  }

                  while (var1.options.useKey.wasPressed()) {
                  }
               }
            }
         }
      }
   }

   static void ptz(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;

      while (var0.options.useKey.wasPressed()) {
      }

      if (var0.options.useKey.isPressed() && !var1.isUsingItem()) {
         int var2 = vxr.getInt(pts, var0, 0);
         if (var2 <= 0 && !var0.interactionManager.isBreakingBlock() && !var1.isRiding()) {
            for (Hand var6 : Hand.values()) {
               ItemStack var7 = var1.getStackInHand(var6);
               if (!var7.isItemEnabled(var0.world.getEnabledFeatures())) {
                  break;
               }

               if (!var7.isEmpty() && var0.interactionManager.interactItem(var1, var6) instanceof Success var9) {
                  if (var9.swingSource() == SwingSource.CLIENT) {
                     var1.swingHand(var6);
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
