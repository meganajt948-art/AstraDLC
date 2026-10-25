package a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class hxi {
   private static final float hxj = 15.0F;
   private static final float hxk = 3.0F;
   final vlv mode;
   private final float hxl;
   private final float hxm;
   private final float hxn;
   private final boolean hxo;
   private final vcj hxp = new vcj(18.0F);
   private final List<vcj> hxq = new ArrayList<>();
   private boolean hxr;

   hxi(vlv var1, float var2, float var3, float var4, float var5, float var6) {
      this.mode = var1;
      this.hxl = var2;
      this.hxm = var4;
      float var7 = this.hxu();
      this.hxo = var3 + var7 > var6 && var5 - 3.0F - var7 > 0.0F;
      this.hxn = this.hxo ? var5 - 3.0F - var7 : var3;

      for (int var8 = 0; var8 < var1.getModes().size(); var8++) {
         this.hxq.add(new vcj(18.0F));
      }
   }

   private float hxu() {
      return this.mode.getModes().size() * 15.0F + 6.0F;
   }

   void close() {
      this.hxr = true;
   }

   boolean closing() {
      return this.hxr;
   }

   boolean gone() {
      return this.hxr && this.hxp.get() <= 0.01F;
   }

   void render(DrawContext var1, float var2, float var3, float var4) {
      float var5 = vcq.outCubic(this.hxp.step(this.hxr ? 0.0F : 1.0F, var4));
      if (!(var5 <= 0.01F)) {
         float var6 = this.hxu();
         float var7 = var6 * (0.35F + 0.65F * var5);
         float var8 = this.hxo ? this.hxn + var6 - var7 : this.hxn;
         float var9 = iov.r(6.0F);
         uut.pushAlpha(var5);
         uut.shadow(var1, this.hxl, var8 + 2.0F, this.hxm, var7, var9, 12.0F, iov.shadow);
         int var10 = ujt.withAlpha(iov.cardHover, 250);
         hyv.surface(var1, this.hxl, var8, this.hxm, var7, var9, hyv.tint(iov.window, Math.min(1.0F, iov.windowTint() + 0.08F)), var10, 6.0F, hyv.POPUPS);
         uut.outline(var1, this.hxl, var8, this.hxm, var7, var9, 1.0F, iov.stroke);
         uut.pushScissor(var1, this.hxl, var8, this.hxm, var7);
         List var11 = this.mode.getModes();

         while (this.hxq.size() < var11.size()) {
            this.hxq.add(new vcj(18.0F));
         }

         for (int var12 = 0; var12 < var11.size(); var12++) {
            float var13 = this.hxn + 3.0F + var12 * 15.0F;
            boolean var14 = this.mode.get().equals(var11.get(var12));
            float var15 = this.hxq.get(var12).step(!this.hxr && irr.inside(var2, var3, this.hxl, var13, this.hxm, 15.0F), var4);
            if (var15 > 0.01F) {
               uut.round(
                  var1,
                  this.hxl + 3.0F,
                  var13 + 1.0F,
                  this.hxm - 6.0F,
                  13.0F,
                  iov.r(3.5F),
                  ujt.withAlpha(iov.hover, Math.round(ujt.alpha(iov.hover) * 2.0F * var15))
               );
            }

            int var16 = var14 ? iov.accent() : ujt.lerp(iov.textDim, iov.text, var15);
            irr.VALUE
               .draw(
                  var1, irr.VALUE.ellipsize(wap.value((String)var11.get(var12)), this.hxm - 24.0F), this.hxl + 8.0F, irr.VALUE.centerTop(var13 + 7.5F), var16
               );
            if (var14) {
               vjf.draw(var1, vhz.CHECK, this.hxl + this.hxm - 9.0F, var13 + 7.5F, 7.0F, iov.accent());
            }
         }

         uut.popScissor(var1);
         uut.popAlpha();
      }
   }

   boolean mouseClicked(float var1, float var2) {
      if (!this.hxr && irr.inside(var1, var2, this.hxl, this.hxn, this.hxm, this.hxu())) {
         int var3 = (int)((var2 - this.hxn - 3.0F) / 15.0F);
         List var4 = this.mode.getModes();
         if (var3 >= 0 && var3 < var4.size()) {
            this.mode.set((String)var4.get(var3));
         }

         this.close();
         return true;
      } else {
         return false;
      }
   }
}
