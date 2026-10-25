package a;

import java.util.function.Supplier;
import net.minecraft.client.gui.DrawContext;

final class iab extends imn {
   static final float iac = 18.0F;
   final String iad;
   final Supplier<String> iae;

   iab(String var1, Supplier<String> var2) {
      super(null);
      this.iad = var1;
      this.iae = var2;
   }

   @Override
   float height() {
      return 18.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float var6 = this.y + 9.0F;
      String var7 = wap.t(this.iad);
      irr.LABEL.draw(var1, var7, this.x, irr.LABEL.centerTop(var6), iov.textDim);
      String var8 = irr.SMALL.ellipsize(this.iae.get(), this.w - irr.LABEL.width(var7) - 20.0F);
      irr.drawChip(var1, var8, this.x + this.w, var6, iov.text, iov.stroke, 0.0F);
   }
}
