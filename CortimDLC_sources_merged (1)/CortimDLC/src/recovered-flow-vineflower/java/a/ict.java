package a;

import flow.dev.a;
import net.minecraft.client.gui.DrawContext;

final class ict extends imn {
   static final float icu = 20.0F;
   final String icv;
   final irk icw;
   final vcj icx = new vcj(14.0F);

   ict(String var1, irk var2) {
      this(null, var1, var2);
   }

   ict(vmo var1, String var2, irk var3) {
      super(var1);
      this.icv = var2;
      this.icw = var3;
   }

   @Override
   float height() {
      return 20.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float var6 = this.hover.step(this.hovered(var3, var4) && var2.canHover(), var5);
      float var7 = this.icx.step(var2.binding() == this.icw, var5);
      float var8 = this.y + 10.0F;
      irr.LABEL.draw(var1, wap.t(this.icv), this.x, irr.LABEL.centerTop(var8), ujt.lerp(iov.textDim, iov.text, Math.max(var6, var7)));
      String var9 = var7 > 0.5F ? a.b("뾹예䳛", 1344651156) : irr.keyName(this.icw.get());
      float var10 = var7 > 0.01F ? 0.55F + 0.45F * (float)Math.sin(System.nanoTime() / 1.6E8) : 0.0F;
      irr.drawChip(
         var1,
         var9,
         this.x + this.w,
         var8,
         ujt.lerp(iov.text, iov.accent(), var7),
         ujt.lerp(iov.stroke, iov.accent((int)(120.0F + 110.0F * var10)), var7),
         var6
      );
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (this.hovered(var2, var3) && var4 == 0) {
         var1.startBinding(this.icw);
         return true;
      } else {
         return false;
      }
   }
}
