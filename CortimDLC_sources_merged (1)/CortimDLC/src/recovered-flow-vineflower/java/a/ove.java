package a;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MarkerEntity;
import net.minecraft.world.World;

final class ove extends MarkerEntity {
   private final ovh this$0;
   ove(ovh var1, World var2) {
      super(EntityType.MARKER, var2);
      this.this$0 = var1;
   }

   @Override
   public float getYaw(float tickProgress) {
      this.this$0.owj();
      return this.this$0.ovx;
   }

   @Override
   public float getPitch(float tickProgress) {
      this.this$0.owj();
      return this.this$0.ovy;
   }

   @Override
   public float getYaw() {
      return this.this$0.ovx;
   }

   @Override
   public float getPitch() {
      return this.this$0.ovy;
   }
}
