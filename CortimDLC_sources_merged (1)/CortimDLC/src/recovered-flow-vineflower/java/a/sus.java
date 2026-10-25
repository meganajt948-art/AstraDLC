package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class sus {
   static final swb sut = new swb(vek.SEMIBOLD, 6.6F);
   static final swb suu = new swb(vek.MEDIUM, 5.8F);
   static final int suv = 48;
   static final float suw = 4.0F;
   static final float sux = 11.5F;
   static final float suy = 8.5F;
   static final List<sup> suz = new ArrayList<>();
   static final List<sup> sva = new ArrayList<>();
   static long svb = Long.MIN_VALUE;
   static long svc = -1L;

   sus() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      rfl var3 = rfl.get();
      if (var3 != null && var3.isEnabled() && var2.world != null && var2.player != null && !var2.options.hudHidden && !(var2.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != svc) {
            svc = unf.frame();
            long var4 = var2.world.getTime();
            if (var4 != svb) {
               svb = var4;
               svf(var2, var3);
            }

            if (!suz.isEmpty()) {
               float var6 = var1.getTickProgress(true);

               usn var7;
               try {
                  var7 = usn.capture(var6, var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
               } catch (Throwable var13) {
                  return;
               }

               sva.clear();

               for (sup var9 : suz) {
                  if (!var9.first.isRemoved()) {
                     Vec3d var10 = var9.first.getLerpedPos(var6);
                     double var11 = var10.y + var9.first.getHeight() + 0.12;
                     if (var7.project(var10.x, var11, var10.z, var9.screen)) {
                        var9.distance = var7.distance(var10.x, var11, var10.z);
                        sva.add(var9);
                     }
                  }
               }

               sva.sort((var0x, var1x) -> Double.compare(var1x.distance, var0x.distance));
               uut.beginFrame();
               float var14 = Math.max(1, var2.getWindow().getScaleFactor());

               for (sup var16 : sva) {
                  svh(var0, var3, var16, var14);
               }

               swh.step = swh.stepFor(1.0F);
            }
         }
      } else {
         suz.clear();
         svb = Long.MIN_VALUE;
      }
   }

   static void svf(MinecraftClient var0, rfl var1) {
      suz.clear();
      double var2 = var1.range.get();
      Box var4 = var0.player.getBoundingBox().expand(var2, var2 * 0.6, var2);
      List<ItemEntity> var5 = var0.world.getEntitiesByClass(ItemEntity.class, var4, var0x -> var0x.isAlive() && !var0x.getStack().isEmpty());
      Vec3d var6 = var0.player.getEyePos();
      var5.sort(Comparator.comparingDouble(var1x -> var1x.squaredDistanceTo(var6)));
      boolean var7 = var1.merge.get();

      for (ItemEntity var9 : var5) {
         if (var9.squaredDistanceTo(var6) > var2 * var2) {
            break;
         }

         sup var10 = null;
         if (var7) {
            for (sup var12 : suz) {
               if (var12.first.squaredDistanceTo(var9) < 1.44 && ItemStack.areItemsAndComponentsEqual(var12.stack, var9.getStack())) {
                  var10 = var12;
                  break;
               }
            }
         }

         if (var10 != null) {
            var10.count = var10.count + var9.getStack().getCount();
         } else if (suz.size() < 48) {
            sup var13 = new sup(var9);
            var13.name = var13.stack.getName().getString();
            var13.color = svg(var13.stack, var1.rarity.get());
            suz.add(var13);
         }
      }
   }

   static int svg(ItemStack var0, boolean var1) {
      if (!var1) {
         return -723722;
      }

      Rarity var2 = var0.getRarity();
      if (var2 == Rarity.COMMON) {
         return -723722;
      }

      Formatting var3 = var2.getFormatting();
      Integer var4 = var3 != null ? var3.getColorValue() : null;
      return var4 == null ? -723722 : ujt.lerp(0xFF000000 | var4, -1, 0.2F);
   }

   static void svh(DrawContext var0, rfl var1, sup var2, float var3) {
      float var4 = (float)Math.max(0.35, Math.min(1.0, 7.0 / Math.max(0.1, var2.distance)));
      float var5 = (float)var1.size.get() * (0.35F + 0.65F * var4);
      swh.step = swh.stepFor(var5);
      var5 = swh.stepScale();
      boolean var6 = var1.icon.get();
      if (var2.widthStep != swh.step) {
         var2.widthStep = swh.step;
         var2.nameW = sut.width(var2.name);
         var2.countText = var2.count > 1 ? a.d("\uf238", 66764453, 1120292068) + var2.count : null;
         var2.countW = var2.countText != null ? suu.width(var2.countText) : 0.0F;
      }

      String var7 = var2.countText;
      float var8 = var2.nameW;
      float var9 = 4.0F + (var6 ? 11.5F : 0.0F) + var8 + (var7 != null ? 3.0F + var2.countW : 0.0F) + 4.0F;
      float var10 = -var9 * 0.5F;
      float var11 = -11.5F;
      float var12 = var11 + 5.75F;
      float var13 = (float)Math.max(0.35, Math.min(1.0, 1.25 - var2.distance / (var1.range.get() * 1.1)));
      float var14 = Math.round(var2.screen[0] * var3) / var3;
      float var15 = Math.round(var2.screen[1] * var3) / var3;
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var14, var15);
      var0.getMatrices().scale(var5, var5);
      uut.pushAlpha(var13);

      try {
         boolean var16 = var1.background.is(a.d("走\uf4e0縲\ue048", -564243681, -82715099));
         if (!var16) {
            uut.round(var0, var10, var11, var9, 11.5F, 5.75F, -1710552306);
            uut.outline(var0, var10, var11, var9, 11.5F, 5.75F, 0.8F, 385875967);
         }

         int var17 = ujt.withAlpha(0, var16 ? 170 : 90);
         float var18 = var10 + 4.0F;
         if (var6) {
            float var19 = 0.53125F;
            var0.getMatrices().pushMatrix();
            var0.getMatrices().translate(var18 + 4.25F, var12);
            var0.getMatrices().scale(var19, var19);
            var0.drawItem(var2.stack, -8, -8);
            var0.getMatrices().popMatrix();
            var18 += 11.5F;
         }

         float var25 = sut.centerTop(var12);
         sut.draw(var0, var2.name, var18 + 0.5F, var25 + 0.5F, var17);
         var18 = sut.draw(var0, var2.name, var18, var25, var2.color);
         if (var7 != null) {
            suu.draw(var0, var7, var18 + 3.0F, suu.centerTop(var12), -1258291201);
         }
      } finally {
         uut.popAlpha();
         var0.getMatrices().popMatrix();
      }
   }
}
