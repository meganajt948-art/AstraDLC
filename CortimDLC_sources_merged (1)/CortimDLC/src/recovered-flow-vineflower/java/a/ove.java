package a;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MarkerEntity;
import net.minecraft.world.World;

final class ove extends MarkerEntity {
   ove(ovh var1, World var2) {
      super(EntityType.field_33456, var2);
      this.this$0 = var1;
   }

   public float method_5705(float var1) {
      this.this$0.owj();
      return this.this$0.ovx;
   }

   public float method_5695(float var1) {
      this.this$0.owj();
      return this.this$0.ovy;
   }

   public float method_36454() {
      return this.this$0.ovx;
   }

   public float method_36455() {
      return this.this$0.ovy;
   }
}
