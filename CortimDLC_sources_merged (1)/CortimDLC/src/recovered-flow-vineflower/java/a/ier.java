package a;

import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class ier extends imn {
   static final float ies = 21.0F;
   static final float iet = 14.0F;
   static final float ieu = 11.0F;
   final vlv iev;
   final vcj iew = new vcj(16.0F);
   final vcj iex = new vcj(18.0F, -1.0F);
   final vcj iey = new vcj(18.0F, -1.0F);
   boolean iez;
   float ifa;
   float ifb;
   float ifc;

   ier(vlv var1) {
      super(var1);
      this.iev = var1;
   }

   @Override
   float height() {
      return 21.0F;
   }

   float iff(String var1) {
      return irr.VALUE.width(wap.value(var1)) + 11.0F;
   }

   void ifg() {
      List<String> var1 = this.iev.getModes();
      float var2 = 3.0F;

      for (String var4 : var1) {
         var2 += this.iff(var4);
      }

      float var7 = this.w - irr.LABEL.width(wap.t(this.setting.getName())) - 10.0F;
      this.iez = var1.size() <= 3 && var2 <= var7;
      if (this.iez) {
         this.ifc = var2;
      } else {
         float var8 = 0.0F;

         for (String var6 : var1) {
            var8 = Math.max(var8, irr.VALUE.width(wap.value(var6)));
         }

         this.ifc = Math.min(this.w * 0.6F, Math.max(60.0F, var8 + 24.0F));
      }

      this.ifa = this.x + this.w - this.ifc;
      this.ifb = this.y + 3.5F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.ifg();
      boolean var6 = irr.inside(var3, var4, this.ifa, this.ifb, this.ifc, 14.0F) && var2.canHover();
      float var7 = this.hover.step(var6, var5);
      float var8 = this.iew.step(var2.isDropdownFor(this.iev), var5);
      irr.LABEL.draw(var1, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(this.y + 10.5F), ujt.lerp(iov.textDim, iov.text, Math.max(var7, var8)));
      float var9 = iov.r(4.0F);
      uut.round(var1, this.ifa, this.ifb, this.ifc, 14.0F, var9, ujt.lerp(iov.field, iov.fieldHover, var7));
      uut.outline(var1, this.ifa, this.ifb, this.ifc, 14.0F, var9, 1.0F, ujt.lerp(iov.stroke, iov.accent(150), var8));
      ukf.inset(var1, this.ifa, this.ifb, this.ifc, 14.0F, var9, iov.lightness());
      if (this.iez) {
         this.ifh(var1, var3, var4, var5);
      } else {
         this.ifi(var1, var7, var8);
      }
   }

   void ifh(DrawContext var1, float var2, float var3, float var4) {
      List<String> var5 = this.iev.getModes();
      float var6 = this.ifa + 1.5F;
      float var7 = var6;
      float var8 = this.iff((String)var5.get(0));

      for (String var10 : var5) {
         float var11 = this.iff(var10);
         if (var10.equals(this.iev.get())) {
            var7 = var6;
            var8 = var11;
         }

         var6 += var11;
      }

      if (this.iex.get() < 0.0F) {
         this.iex.set(var7 - this.ifa);
         this.iey.set(var8);
      }

      float var23 = this.ifa + this.iex.step(var7 - this.ifa, var4);
      float var24 = this.iey.step(var8, var4);
      float var25 = iov.r(3.2F);
      float var12 = iov.lightness();
      float var13 = this.ifb + 1.5F;
      float var14 = 11.0F;
      uut.shadow(var1, var23, var13 + 0.6F, var24, var14, var25, 1.4F, ujt.withAlpha(0, Math.round(110.0F - 70.0F * var12)));
      uut.round(var1, var23, var13, var24, var14, var25, ujt.lerp(iov.cardHover, -1, 0.1F + 0.9F * var12));
      ukf.sheen(var1, var23, var13, var24, var14, var25, 1.4F * (1.0F - 0.7F * var12));
      ukf.rim(var1, var23, var13, var24, var14, var25, var12, 1.1F);
      var6 = this.ifa + 1.5F;
      float var15 = this.ifb + 7.0F;

      for (String var17 : var5) {
         float var18 = this.iff(var17);
         float var19 = Math.max(0.0F, Math.min(var23 + var24, var6 + var18) - Math.max(var23, var6)) / var18;
         boolean var20 = irr.inside(var2, var3, var6, this.ifb, var18, 14.0F);
         int var21 = var20 ? iov.textDim : iov.textMuted;
         irr.VALUE.drawCentered(var1, wap.value(var17), var6 + var18 * 0.5F, irr.VALUE.centerTop(var15), ujt.lerp(var21, iov.text, var19));
         var6 += var18;
      }
   }

   void ifi(DrawContext var1, float var2, float var3) {
      String var4 = irr.VALUE.ellipsize(wap.value(this.iev.get()), this.ifc - 22.0F);
      float var5 = this.ifb + 7.0F;
      irr.VALUE.draw(var1, var4, this.ifa + 7.0F, irr.VALUE.centerTop(var5), ujt.lerp(iov.textDim, iov.text, 0.6F + var2 * 0.4F));
      float var6 = this.ifa + this.ifc - 8.5F;
      int var7 = ujt.lerp(iov.textMuted, iov.accent(), Math.max(var3, var2 * 0.5F));
      var1.getMatrices().pushMatrix();
      var1.getMatrices().translate(var6, var5);
      var1.getMatrices().rotate((float) Math.PI * var3);
      vjf.draw(var1, vhz.CHEVRON_DOWN, 0.0F, 0.0F, 7.0F, var7);
      var1.getMatrices().popMatrix();
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (!this.hovered(var2, var3)) {
         return false;
      }

      if (var4 == 1) {
         this.iev.cyclePrev();
         return true;
      }

      if (var4 != 0) {
         return false;
      }

      if (this.iez) {
         float var5 = this.ifa + 1.5F;

         for (String var7 : this.iev.getModes()) {
            float var8 = this.iff(var7);
            if (var2 >= var5 && var2 < var5 + var8) {
               this.iev.set(var7);
               return true;
            }

            var5 += var8;
         }

         this.iev.cycle();
      } else {
         var1.openDropdown(this.iev, this.ifa, this.ifb + 14.0F + 3.0F, this.ifc, this.ifb);
      }

      return true;
   }
}
