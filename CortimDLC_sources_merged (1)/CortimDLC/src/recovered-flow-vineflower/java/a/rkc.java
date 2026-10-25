package a;

import java.util.function.BooleanSupplier;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.render.fog.FogModifier;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

final class rkc extends FogModifier {
   final FogModifier rkd;
   final BooleanSupplier rke;

   rkc(FogModifier var1, BooleanSupplier var2) {
      this.rkd = var1;
      this.rke = var2;
   }

   @Override
   public void applyStartEndModifier(FogData data, Camera var2, ClientWorld var3, float var4, RenderTickCounter var5) {
      if (this.rke.getAsBoolean()) {
         data.environmentalStart = var4 * 4.0F;
         data.environmentalEnd = var4 * 8.0F;
      } else {
         this.rkd.applyStartEndModifier(data, var2, var3, var4, var5);
      }
   }

   @Override
   public boolean isColorSource() {
      return this.rkd.isColorSource();
   }

   @Override
   public int getFogColor(ClientWorld world, Camera camera, int viewDistance, float skyDarkness) {
      return this.rkd.getFogColor(world, camera, viewDistance, skyDarkness);
   }

   @Override
   public boolean isDarknessModifier() {
      return !this.rke.getAsBoolean() && this.rkd.isDarknessModifier();
   }

   @Override
   public float applyDarknessModifier(LivingEntity cameraEntity, float darkness, float tickProgress) {
      return this.rke.getAsBoolean() ? darkness : this.rkd.applyDarknessModifier(cameraEntity, darkness, tickProgress);
   }

   @Override
   public boolean shouldApply(CameraSubmersionType submersionType, Entity cameraEntity) {
      return this.rkd.shouldApply(submersionType, cameraEntity);
   }
}
