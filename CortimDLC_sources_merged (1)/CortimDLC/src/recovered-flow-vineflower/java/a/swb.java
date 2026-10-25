package a;

import net.minecraft.client.gui.DrawContext;

final class swb {
   final vek swc;
   final float swd;
   final vdn[] swe = new vdn[swh.sxj.length];

   swb(vek var1, float var2) {
      this.swc = var1;
      this.swd = var2;
   }

   vdn font() {
      vdn var1 = this.swe[swh.step];
      if (var1 == null) {
         var1 = veo.get(this.swc, this.swd * swh.sxj[swh.step]);
         this.swe[swh.step] = var1;
      }

      return var1;
   }

   float width(String var1) {
      return this.font().width(var1) / swh.sxj[swh.step];
   }

   float capHeight() {
      return this.font().capHeight() / swh.sxj[swh.step];
   }

   float centerTop(float var1) {
      float var2 = swh.sxj[swh.step];
      return this.font().centerTop(var1 * var2) / var2;
   }

   float draw(DrawContext var1, String var2, float var3, float var4, int var5) {
      float var6 = swh.sxj[swh.step];
      var1.getMatrices().pushMatrix();
      var1.getMatrices().scale(1.0F / var6, 1.0F / var6);
      float var7 = this.font().draw(var1, var2, var3 * var6, var4 * var6, var5);
      var1.getMatrices().popMatrix();
      return var7 / var6;
   }
}
