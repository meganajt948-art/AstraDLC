package a;

import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

final class ilz extends imn {
   private static final float ima = 67.0F;
   private static final float imb = 50.0F;
   private static final float imc = 9.0F;
   private static final float imd = 7.0F;
   private final vmc ime;
   private final vmc imf;
   private final vmc img;
   private int imh;

   ilz() {
      this(iov.HUE, iov.SATURATION, iov.BRIGHTNESS);
   }

   ilz(vmc var1, vmc var2, vmc var3) {
      super(null);
      this.ime = var1;
      this.imf = var2;
      this.img = var3;
   }

   @Override
   float height() {
      return 67.0F;
   }

   private float imk() {
      return this.y + 3.0F;
   }

   private float iml() {
      return this.w - 9.0F - 7.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      if (this.imh != 0 && !var2.isDragging(this)) {
         this.imh = 0;
      }

      float var6 = (float)this.ime.get();
      float var7 = (float)this.imf.get();
      float var8 = (float)this.img.get();
      float var9 = this.imk();
      float var10 = this.iml();
      float var11 = iov.r(4.0F);
      int var12 = ujt.hsv(var6, 1.0F, 1.0F);
      uut.gradient(var1, this.x, var9, var10, 50.0F, var11, -1, var12, -16777216, -16777216);
      uut.outline(var1, this.x, var9, var10, 50.0F, var11, 1.0F, iov.stroke);
      float var13 = this.x + var7 * var10;
      float var14 = var9 + (1.0F - var8) * 50.0F;
      uut.shadow(var1, var13 - 3.5F, var14 - 3.5F, 7.0F, 7.0F, 3.5F, 2.0F, 1610612736);
      uut.circle(var1, var13, var14, 3.5F, -1);
      uut.circle(var1, var13, var14, 2.3F, ujt.hsv(var6, var7, var8));
      float var15 = this.x + var10 + 7.0F;
      float var16 = 8.333333F;
      float var17 = 4.5F;
      uut.gradientV(var1, var15, var9, 9.0F, var16 + var17, var17, ujt.hsv(0.0F, 1.0F, 1.0F), ujt.hsv((var16 + var17) / 50.0F, 1.0F, 1.0F));
      uut.gradientV(
         var1, var15, var9 + 50.0F - var16 - var17, 9.0F, var16 + var17, var17, ujt.hsv((50.0F - var16 - var17) / 50.0F, 1.0F, 1.0F), ujt.hsv(1.0F, 1.0F, 1.0F)
      );

      for (int var18 = 1; var18 < 5; var18++) {
         uut.gradientV(var1, var15, var9 + var16 * var18, 9.0F, var16, 0.0F, ujt.hsv(var18 / 6.0F, 1.0F, 1.0F), ujt.hsv((var18 + 1) / 6.0F, 1.0F, 1.0F));
      }

      float var22 = var9 + var6 * 50.0F;
      uut.shadow(var1, var15 - 1.5F, var22 - 2.0F, 12.0F, 4.0F, 2.0F, 2.0F, 1610612736);
      uut.outline(var1, var15 - 1.5F, var22 - 2.0F, 12.0F, 4.0F, 2.0F, 1.3F, -1);
      int var19 = ujt.hsv(var6, var7, var8);
      String var20 = String.format(Locale.ROOT, a.d("釹\ue84e抈ﳿ睆", -385770431, 593956254), var19 & 16777215);
      float var21 = var9 + 50.0F + 9.0F;
      uut.circle(var1, this.x + 4.0F, var21, 3.5F, var19);
      irr.VALUE.draw(var1, var20, this.x + 11.0F, irr.VALUE.centerTop(var21), iov.textDim);
      irr.SMALL
         .drawRight(
            var1,
            Math.round(var6 * 360.0F)
               + a.d("笫Ȋ裙", -260310854, 1868530466)
               + Math.round(var7 * 100.0F)
               + a.d("횚꼮◽", -378538918, 523510502)
               + Math.round(var8 * 100.0F)
               + a.b("ᮿ", -1469506661),
            this.x + this.w,
            irr.SMALL.centerTop(var21),
            iov.textMuted
         );
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return false;
      } else {
         float var5 = this.imk();
         if (irr.inside(var2, var3, this.x - 2.0F, var5 - 2.0F, this.iml() + 4.0F, 54.0F)) {
            this.imh = 1;
         } else {
            if (!irr.inside(var2, var3, this.x + this.iml() + 7.0F - 3.0F, var5 - 3.0F, 15.0F, 56.0F)) {
               return false;
            }

            this.imh = 2;
         }

         var1.startDrag(this);
         this.mouseDragged(var2, var3);
         return true;
      }
   }

   @Override
   void mouseDragged(float var1, float var2) {
      float var3 = this.imk();
      if (this.imh == 1) {
         this.imf.set(imm((var1 - this.x) / this.iml()));
         this.img.set(1.0F - imm((var2 - var3) / 50.0F));
      } else if (this.imh == 2) {
         this.ime.set(Math.min(0.999F, imm((var2 - var3) / 50.0F)));
      }
   }

   private static float imm(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }
}
