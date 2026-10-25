package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.world.LightType;
import net.minecraft.world.attribute.EnvironmentAttributes;

public final class uhs {
   static float uht = -1.0F;
   static long uhu;

   uhs() {
   }

   public static float daylight(MinecraftClient var0) {
      try {
         Float var1 = var0.gameRenderer.getCamera().getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.SKY_LIGHT_FACTOR_VISUAL, 1.0F);
         return var1 == null ? 1.0F : Math.max(0.0F, Math.min(1.0F, var1));
      } catch (RuntimeException var2) {
         return 1.0F;
      }
   }

   public static float boost(MinecraftClient var0) {
      Double var1 = var0.options.getGamma().getValue();
      return var1 == null ? 0.0F : (float)Math.max(0.0, Math.min(1.0, (var1 - 1.0) / 5.0));
   }

   public static float light(MinecraftClient var0) {
      Camera var1 = var0.gameRenderer.getCamera();
      float var2 = 0.5F;
      if (var0.world != null && var1.isReady()) {
         float var3 = var0.world.getLightLevel(LightType.SKY, var1.getBlockPos()) / 15.0F;
         float var4 = var0.world.getLightLevel(LightType.BLOCK, var1.getBlockPos()) / 15.0F;
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
