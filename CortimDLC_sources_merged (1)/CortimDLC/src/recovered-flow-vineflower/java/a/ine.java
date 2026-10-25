package a;

import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class ine extends imn {
   static final float inf = 30.0F;
   static final float ing = 10.0F;
   final vla inh;
   final vcj[] ini;
   final vcj[] inj;

   ine(vla var1) {
      super(var1);
      this.inh = var1;
      int var2 = var1.getModes().size();
      this.ini = new vcj[var2];
      this.inj = new vcj[var2];

      for (int var3 = 0; var3 < var2; var3++) {
         this.ini[var3] = new vcj(16.0F);
         this.inj[var3] = new vcj(14.0F, var3 == var1.index() ? 1.0F : 0.0F);
      }
   }

   @Override
   float height() {
      return 30.0F;
   }

   float inm(int var1, int var2) {
      float var3 = (this.w - 10.0F * var2) / (var2 - 1);
      return this.x + 5.0F + var1 * (10.0F + var3);
   }

   float inn() {
      return this.y + 30.0F - 5.0F - 4.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = this.inh.getModes();
      int var7 = var6.size();
      float var8 = this.inn();
      int var9 = -1;

      for (int var10 = 0; var10 < var7; var10++) {
         float var11 = this.inm(var10, var7);
         boolean var12 = var2.canHover() && irr.inside(var3, var4, var11 - 5.0F - 2.0F, var8 - 5.0F - 2.0F, 14.0F, 14.0F);
         if (var12) {
            var9 = var10;
         }

         float var13 = this.ini[var10].step(var12, var5);
         float var14 = this.inj[var10].step(var10 == this.inh.index(), var5);
         float var15 = 5.0F + var13 * 0.7F - var14 * 1.1F;
         int[] var16 = vla.pair(var10);
         if (var14 > 0.01F) {
            uut.circleOutline(var1, var11, var8, 6.7F, 1.1F, ujt.mulAlpha(iov.text, var14 * 0.9F));
         }

         if (var10 == 0) {
            uut.circle(var1, var11, var8, var15, ujt.withAlpha(iov.window, 255));
            uut.circleOutline(var1, var11, var8, var15, 0.8F, iov.stroke);
            float var17 = var15 * 0.55F;
            uut.gradient(var1, var11 - var17, var8 - var17, var17 * 2.0F, var17 * 2.0F, var17, var16[0], var16[1], var16[1], var16[0]);
         } else {
            uut.gradient(var1, var11 - var15, var8 - var15, var15 * 2.0F, var15 * 2.0F, var15, var16[0], var16[1], var16[1], var16[0]);
         }
      }

      irr.LABEL.draw(var1, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(this.y + 7.0F), var9 >= 0 ? iov.text : iov.textDim);
      String var18 = wap.value(var9 >= 0 ? (String)var6.get(var9) : this.inh.get());
      irr.SMALL.drawRight(var1, var18, this.x + this.w, irr.SMALL.centerTop(this.y + 7.0F), var9 >= 0 ? iov.textDim : iov.textMuted);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (!this.hovered(var2, var3)) {
         return false;
      }

      if (var4 == 1) {
         this.inh.cyclePrev();
         return true;
      }

      if (var4 != 0) {
         return false;
      }

      List var5 = this.inh.getModes();
      int var6 = var5.size();
      float var7 = this.inn();

      for (int var8 = 0; var8 < var6; var8++) {
         float var9 = this.inm(var8, var6);
         if (irr.inside(var2, var3, var9 - 5.0F - 2.0F, var7 - 5.0F - 2.0F, 14.0F, 14.0F)) {
            this.inh.set((String)var5.get(var8));
            return true;
         }
      }

      return false;
   }
}
