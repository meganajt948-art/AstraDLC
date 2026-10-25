package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.world.LightType;
import net.minecraft.world.attribute.EnvironmentAttributes;

public final class uhs {
   private static float uht = -1.0F;
   private static long uhu;

   private uhs() {
   }

   public static float daylight(MinecraftClient var0) {
      try {
         Float var1 = (Float)var0.field_1773.method_19418().method_75756().method_75689(EnvironmentAttributes.field_64346, 1.0F);
         return var1 == null ? 1.0F : Math.max(0.0F, Math.min(1.0F, var1));
      } catch (RuntimeException var2) {
         return 1.0F;
      }
   }

   public static float boost(MinecraftClient var0) {
      Double var1 = (Double)var0.field_1690.method_42473().method_41753();
      return var1 == null ? 0.0F : (float)Math.max(0.0, Math.min(1.0, (var1 - 1.0) / 5.0));
   }

   public static float light(MinecraftClient var0) {
      Camera var1 = var0.field_1773.method_19418();
      float var2 = 0.5F;
      if (var0.field_1687 != null && var1.method_19332()) {
         float var3 = var0.field_1687.method_8314(LightType.field_9284, var1.method_19328()) / 15.0F;
         float var4 = var0.field_1687.method_8314(LightType.field_9282, var1.method_19328()) / 15.0F;
         float var5 = daylight(var0);
         var2 = Math.max(var3 * (0.18F + 0.82F * var5), var4 * 0.75F);
         var2 = Math.max(var2, 0.08F);
         var2 += (1.0F - var2) * boost(var0);
      }

      long var8 = System.nanoTime();
      float var9 = uhu == 0L ? 1.0F : Math.min(1.0F, (float)(var8 - uhu) / 1.0E9F);
      uhu = var8;
      if (uht < 0.0F) {
         uht = var2;
      } else {
         uht = uht + (var2 - uht) * (1.0F - (float)Math.exp(-var9 / 0.6F));
      }

      return uht;
   }
}
