package a;

import java.util.function.BooleanSupplier;
import net.minecraft.client.gui.DrawContext;

abstract class imn {
   final vmo setting;
   final vcj hover = new vcj(16.0F);
   private final vcj imo = new vcj(14.0F, 1.0F);
   private final vcj imp = new vcj(12.0F, 1.0F);
   private BooleanSupplier imq = () -> true;
   private BooleanSupplier imr = () -> true;
   float x;
   float y;
   float w;

   imn(vmo var1) {
      this.setting = var1;
   }

   static imn of(vmo var0) {
      Object var1;
      if (var0 instanceof vkl var3) {
         var1 = new ino(var3);
      } else if (var0 instanceof vmc var4) {
         var1 = new imu(var4);
      } else if (var0 instanceof vla var5) {
         var1 = new ine(var5);
      } else if (var0 instanceof vlv var6) {
         var1 = new ier(var6);
      } else if (var0 instanceof vlq var7) {
         var1 = new ict(var7, var7.getName(), new irk(var7.getName(), var7::get, var7::set, true));
      } else if (var0 instanceof vmu var8) {
         var1 = new inu(var8);
      } else if (var0 instanceof vkw var9) {
         var1 = new hiv(var9);
      } else {
         if (!(var0 instanceof vlj var2)) {
            return null;
         }

         var1 = new iee(var2);
      }

      if (var0.activeCondition() != null) {
         ((imn)var1).activeWhen(var0.activeCondition());
      }

      if (var0.visibleCondition() != null) {
         ((imn)var1).visibleWhen(var0.visibleCondition());
      }

      return (imn)var1;
   }

   imn visibleWhen(BooleanSupplier var1) {
      this.imq = var1;
      this.imo.set(var1.getAsBoolean() ? 1.0F : 0.0F);
      return this;
   }

   imn activeWhen(BooleanSupplier var1) {
      this.imr = var1;
      this.imp.set(var1.getAsBoolean() ? 1.0F : 0.0F);
      return this;
   }

   abstract float height();

   final float currentHeight() {
      return this.height() * this.imo.get();
   }

   final float targetHeight() {
      return this.imq.getAsBoolean() ? this.height() : 0.0F;
   }

   final void animate(float var1) {
      this.imo.step(this.imq.getAsBoolean(), var1);
      this.imp.step(this.imr.getAsBoolean(), var1);
   }

   final float opacity() {
      return Math.min(1.0F, this.imo.get() * 1.3F) * (0.38F + 0.62F * this.imp.get());
   }

   final boolean interactive() {
      return this.imo.get() > 0.6F && this.imq.getAsBoolean();
   }

   abstract void render(DrawContext var1, hlc var2, float var3, float var4, float var5);

   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      return false;
   }

   void mouseDragged(float var1, float var2) {
   }

   boolean hovered(float var1, float var2) {
      return irr.inside(var1, var2, this.x, this.y, this.w, this.height());
   }
}
