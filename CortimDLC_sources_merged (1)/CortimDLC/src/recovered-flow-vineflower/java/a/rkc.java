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
   private final FogModifier rkd;
   private final BooleanSupplier rke;

   rkc(FogModifier var1, BooleanSupplier var2) {
      this.rkd = var1;
      this.rke = var2;
   }

   public void method_42591(FogData var1, Camera var2, ClientWorld var3, float var4, RenderTickCounter var5) {
      if (this.rke.getAsBoolean()) {
         var1.field_60582 = var4 * 4.0F;
         var1.field_60584 = var4 * 8.0F;
      } else {
         this.rkd.method_42591(var1, var2, var3, var4, var5);
      }
   }

   public boolean method_71655() {
      return this.rkd.method_71655();
   }

   public int method_71654(ClientWorld var1, Camera var2, int var3, float var4) {
      return this.rkd.method_71654(var1, var2, var3, var4);
   }

   public boolean method_71656() {
      return !this.rke.getAsBoolean() && this.rkd.method_71656();
   }

   public float method_42592(LivingEntity var1, float var2, float var3) {
      return this.rke.getAsBoolean() ? var2 : this.rkd.method_42592(var1, var2, var3);
   }

   public boolean method_42593(CameraSubmersionType var1, Entity var2) {
      return this.rkd.method_42593(var1, var2);
   }
}
