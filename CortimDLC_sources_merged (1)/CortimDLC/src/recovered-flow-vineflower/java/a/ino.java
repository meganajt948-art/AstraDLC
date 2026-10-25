package a;

import net.minecraft.client.gui.DrawContext;

final class ino extends imn {
   private static final float inp = 20.0F;
   private final vkl inq;
   private final vcj inr;

   ino(vkl var1) {
      super(var1);
      this.inq = var1;
      this.inr = new vcj(14.0F, var1.get() ? 1.0F : 0.0F);
   }

   @Override
   float height() {
      return 20.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float var6 = this.hover.step(this.hovered(var3, var4) && var2.canHover(), var5);
      float var7 = this.inr.step(this.inq.get(), var5);
      float var8 = this.y + 10.0F;
      irr.LABEL.draw(var1, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(var8), ujt.lerp(iov.textDim, iov.text, Math.max(var7 * 0.75F, var6)));
      irr.drawSwitch(var1, this.x + this.w - 17.0F, var8 - 4.75F, var7, var6);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 == 0 && this.hovered(var2, var3)) {
         this.inq.toggle();
         return true;
      } else {
         return false;
      }
   }
}
