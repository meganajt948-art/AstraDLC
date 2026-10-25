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
   private static final swb sut = new swb(vek.SEMIBOLD, 6.6F);
   private static final swb suu = new swb(vek.MEDIUM, 5.8F);
   private static final int suv = 48;
   private static final float suw = 4.0F;
   private static final float sux = 11.5F;
   private static final float suy = 8.5F;
   private static final List<sup> suz = new ArrayList<>();
   private static final List<sup> sva = new ArrayList<>();
   private static long svb = Long.MIN_VALUE;
   private static long svc = -1L;

   private sus() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.method_1551();
      rfl var3 = rfl.get();
      if (var3 != null
         && var3.isEnabled()
         && var2.field_1687 != null
         && var2.field_1724 != null
         && !var2.field_1690.field_1842
         && !(var2.field_1755 instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != svc) {
            svc = unf.frame();
            long var4 = var2.field_1687.method_75260();
            if (var4 != svb) {
               svb = var4;
               svf(var2, var3);
            }

            if (!suz.isEmpty()) {
               float var6 = var1.method_60637(true);

               usn var7;
               try {
                  var7 = usn.capture(var6, var0.method_51421(), var0.method_51443());
               } catch (Throwable var13) {
                  return;
               }

               sva.clear();

               for (sup var9 : suz) {
                  if (!var9.first.method_31481()) {
                     Vec3d var10 = var9.first.method_30950(var6);
                     double var11 = var10.field_1351 + var9.first.method_17682() + 0.12;
                     if (var7.project(var10.field_1352, var11, var10.field_1350, var9.screen)) {
                        var9.distance = var7.distance(var10.field_1352, var11, var10.field_1350);
                        sva.add(var9);
                     }
                  }
               }

               sva.sort((var0x, var1x) -> Double.compare(var1x.distance, var0x.distance));
               uut.beginFrame();
               float var14 = Math.max(1, var2.method_22683().method_4495());

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

   private static void svf(MinecraftClient var0, rfl var1) {
      suz.clear();
      double var2 = var1.range.get();
      Box var4 = var0.field_1724.method_5829().method_1009(var2, var2 * 0.6, var2);
      List var5 = var0.field_1687.method_8390(ItemEntity.class, var4, var0x -> var0x.method_5805() && !var0x.method_6983().method_7960());
      Vec3d var6 = var0.field_1724.method_33571();
      var5.sort(Comparator.comparingDouble(var1x -> var1x.method_5707(var6)));
      boolean var7 = var1.merge.get();

      for (ItemEntity var9 : var5) {
         if (var9.method_5707(var6) > var2 * var2) {
            break;
         }

         sup var10 = null;
         if (var7) {
            for (sup var12 : suz) {
               if (var12.first.method_5858(var9) < 1.44 && ItemStack.method_31577(var12.stack, var9.method_6983())) {
                  var10 = var12;
                  break;
               }
            }
         }

         if (var10 != null) {
            var10.count = var10.count + var9.method_6983().method_7947();
         } else if (suz.size() < 48) {
            sup var13 = new sup(var9);
            var13.name = var13.stack.method_7964().getString();
            var13.color = svg(var13.stack, var1.rarity.get());
            suz.add(var13);
         }
      }
   }

   private static int svg(ItemStack var0, boolean var1) {
      if (!var1) {
         return -723722;
      } else {
         Rarity var2 = var0.method_7932();
         if (var2 == Rarity.field_8906) {
            return -723722;
         } else {
            Formatting var3 = var2.method_58413();
            Integer var4 = var3 != null ? var3.method_532() : null;
            return var4 == null ? -723722 : ujt.lerp(0xFF000000 | var4, -1, 0.2F);
         }
      }
   }

   private static void svh(DrawContext var0, rfl var1, sup var2, float var3) {
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
      var0.method_51448().pushMatrix();
      var0.method_51448().translate(var14, var15);
      var0.method_51448().scale(var5, var5);
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
            var0.method_51448().pushMatrix();
            var0.method_51448().translate(var18 + 4.25F, var12);
            var0.method_51448().scale(var19, var19);
            var0.method_51427(var2.stack, -8, -8);
            var0.method_51448().popMatrix();
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
         var0.method_51448().popMatrix();
      }
   }
}
