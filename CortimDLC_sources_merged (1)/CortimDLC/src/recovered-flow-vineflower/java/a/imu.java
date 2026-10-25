package a;

import net.minecraft.client.gui.DrawContext;

final class imu extends imn {
   static final float imv = 25.0F;
   static final float imw = 17.5F;
   static final float imx = 2.5F;
   final vmc imy;
   final vcj imz;
   final vcj ina = new vcj(16.0F);
   boolean inb;

   imu(vmc var1) {
      super(var1);
      this.imy = var1;
      this.imz = new vcj(18.0F, (float)var1.getFraction());
   }

   @Override
   float height() {
      return 25.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      if (this.inb && !var2.isDragging(this)) {
         this.inb = false;
      }

      float var6 = this.hover.step(this.hovered(var3, var4) && var2.canHover(), var5);
      float var7 = this.ina.step(this.inb, var5);
      float var8 = this.imz.step((float)this.imy.getFraction(), var5);
      float var9 = this.y + 7.5F;
      irr.LABEL.draw(var1, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(var9), ujt.lerp(iov.textDim, iov.text, Math.max(var6, var7)));
      irr.VALUE.drawRight(var1, this.imy.display(), this.x + this.w, irr.VALUE.centerTop(var9), ujt.lerp(iov.textDim, iov.text, Math.max(var7, var6 * 0.6F)));
      float var10 = this.y + 17.5F;
      float var11 = 2.5F + var6 * 0.4F + var7 * 0.4F;
      float var12 = var10 + 1.25F;
      uut.round(var1, this.x, var12 - var11 * 0.5F, this.w, var11, var11 * 0.5F, iov.track);
      float var13 = Math.max(var11, this.w * var8);
      uut.gradientH(var1, this.x, var12 - var11 * 0.5F, var13, var11, var11 * 0.5F, iov.accent(), iov.accent2());
      ukf.inset(var1, this.x, var12 - var11 * 0.5F, this.w, var11, var11 * 0.5F, iov.lightness());
      float var14 = this.x + this.w * var8;
      float var15 = 3.2F + var6 * 0.4F + var7 * 0.6F;
      uut.shadow(
         var1,
         var14 - var15,
         var12 - var15 + 0.8F + var7 * 0.6F,
         var15 * 2.0F,
         var15 * 2.0F,
         var15,
         1.6F + var7 * 1.6F,
         ujt.withAlpha(0, Math.round(110.0F + 40.0F * var7))
      );
      uut.gradientV(var1, var14 - var15, var12 - var15, var15 * 2.0F, var15 * 2.0F, var15, -1, -2302750);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (!this.hovered(var2, var3)) {
         return false;
      } else if (var4 == 1) {
         this.imy.reset();
         return true;
      } else if (var4 == 0) {
         this.inb = true;
         var1.startDrag(this);
         this.mouseDragged(var2, var3);
         return true;
      } else {
         return false;
      }
   }

   @Override
   void mouseDragged(float var1, float var2) {
      this.imy.setFromFraction((var1 - this.x) / this.w);
   }
}
