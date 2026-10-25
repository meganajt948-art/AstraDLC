package a;

import flow.dev.a;
import java.awt.Color;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

final class htj extends imn {
   static final float htk = 16.0F;
   static final float htl = 56.0F;
   static final float htm = 80.0F;
   static final float htn = 9.0F;
   static final float hto = 6.0F;
   static final float htp = 4.3F;
   static final int htq = Math.max(iov.MENU_PAINTS.length, iov.HUD_PAINTS.length);
   final vcj[] htr = new vcj[htq];
   final vcj[] hts = new vcj[htq];
   final vcj htt = new vcj(16.0F);
   String htu = "";
   int htv = -1;
   float htw;
   float htx;
   float hty;
   float htz = 1.0F;
   int hua;
   float hub;

   htj() {
      super(null);

      for (int var1 = 0; var1 < htq; var1++) {
         this.htr[var1] = new vcj(16.0F);
         this.hts[var1] = new vcj(13.0F);
      }
   }

   static iog[] hue() {
      return iov.PAINT.is(a.c(-581939200, "偋⧧ꌥ")) ? iov.HUD_PAINTS : iov.MENU_PAINTS;
   }

   @Override
   float height() {
      float var1 = 4.0F;
      iog[] var2 = hue();

      for (int var3 = 0; var3 < var2.length; var3++) {
         var1 += 16.0F + 80.0F * this.hts[var3].get();
      }

      return var1;
   }

   float huf(int var1) {
      float var2 = this.y + 2.0F;

      for (int var3 = 0; var3 < var1; var3++) {
         var2 += 16.0F + 80.0F * this.hts[var3].get();
      }

      return var2;
   }

   float hug(iog var1) {
      return this.w - 15.0F * (var1.hasAlpha() ? 2.0F : 1.0F);
   }

   void huh() {
      if (!iov.PAINT.get().equals(this.htu)) {
         this.htu = iov.PAINT.get();
         this.htv = -1;
         this.hua = 0;

         for (vcj var4 : this.hts) {
            var4.set(0.0F);
         }
      }
   }

   void hui(iog var1, boolean var2) {
      int var3 = iov.paintColor(var1);
      if (var2 || this.huj(var1) != (var1.hasAlpha() ? var3 : var3 | 0xFF000000)) {
         if (!var1.hud() && var1.slot() == 0) {
            this.htw = (float)iov.BG_HUE.get();
            this.htx = (float)iov.BG_SATURATION.get();
            this.hty = (float)iov.BG_BRIGHTNESS.get();
            this.htz = 1.0F;
         } else {
            float[] var4 = Color.RGBtoHSB(var3 >> 16 & 0xFF, var3 >> 8 & 0xFF, var3 & 0xFF, null);
            if (var4[1] > 0.001F && var4[2] > 0.001F) {
               this.htw = var4[0];
            }

            this.htx = var4[1];
            this.hty = var4[2];
            this.htz = var1.hasAlpha() ? ujt.alpha(var3) / 255.0F : 1.0F;
         }
      }
   }

   int huj(iog var1) {
      return ujt.withAlpha(ujt.hsv(this.htw, this.htx, this.hty), var1.hasAlpha() ? Math.round(this.htz * 255.0F) : 255);
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.huh();
      if (this.hua != 0 && !var2.isDragging(this)) {
         this.hua = 0;
      }

      iog[] var6 = hue();
      float var7 = this.y + 2.0F;

      for (int var8 = 0; var8 < var6.length; var8++) {
         iog var9 = var6[var8];
         float var10 = this.hts[var8].step(var8 == this.htv, var5);
         boolean var11 = var2.canHover() && irr.inside(var3, var4, this.x - 3.0F, var7, this.w + 6.0F, 16.0F);
         float var12 = this.htr[var8].step(var11, var5);
         this.huk(var1, var9, var7, var12, var10);
         if (var11) {
            var2.hint(
               wap.t(var9.name())
                  + wap.s(
                     a.c(-1463685174, "\uefcc陽\u1c39苟ई迺㖦뱒∇ꢾ⼼핗寐쉸䠡컘瓜\ufb0d愩\ue7ef渘ᐛ骳Ŭ蜜ෑ됶㨤ꃜ⚈괱叨\ud9f6䀝옯䲪\uf37c礖"),
                     a.c(-1440306620, "ꩄ폵妱읗䲀츫瑹ﶋ揖\ued67檮铍ᩣ莨ঊ輋㔶뫩\u2436ꉧ⬇凁\udf72䂜웦䰱\uf1a4翯\ue108杛\uec98ስ")
                  )
            );
         }

         var7 += 16.0F;
         if (var10 > 0.01F) {
            float var13 = 80.0F * var10;
            if (var8 == this.htv) {
               uut.pushScissor(var1, this.x - 3.0F, var7, this.w + 6.0F, var13);
               uut.pushAlpha(Math.min(1.0F, var10 * 1.4F));
               if (this.hua == 0) {
                  this.hui(var9, false);
               }

               this.hub = var7 + 4.0F;
               this.hun(var1, var2, var9, var7 + 4.0F, var3, var4, var5);
               uut.popAlpha();
               uut.popScissor(var1);
            }

            var7 += var13;
         }
      }
   }

   void huk(DrawContext var1, iog var2, float var3, float var4, float var5) {
      float var6 = var3 + 8.0F;
      float var7 = iov.r(4.0F);
      float var8 = Math.max(var4, var5 * 0.6F);
      if (var8 > 0.01F) {
         uut.round(var1, this.x - 3.0F, var3 + 0.5F, this.w + 6.0F, 15.0F, var7, ujt.withAlpha(iov.hover, Math.round(ujt.alpha(iov.hover) * 2.0F * var8)));
      }

      int var9 = iov.paintColor(var2);
      hul(var1, this.x + 4.3F + 1.0F, var6, 4.3F, var9);
      irr.LABEL
         .draw(
            var1,
            irr.LABEL.ellipsize(wap.t(var2.name()), this.w * 0.62F),
            this.x + 8.6F + 7.0F,
            irr.LABEL.centerTop(var6),
            ujt.lerp(iov.textDim, iov.text, Math.max(var4, var5))
         );
      boolean var10 = iov.isPainted(var2);
      String var11 = var10 ? hum(var9, var2.hasAlpha()) : wap.value(a.d("쐐붕㝇꤭", 482210418, -483510745));
      irr.SMALL
         .drawRight(var1, var11, this.x + this.w, irr.SMALL.centerTop(var6), var10 ? ujt.lerp(iov.textMuted, iov.textDim, 0.6F + 0.4F * var4) : iov.textMuted);
   }

   static void hul(DrawContext var0, float var1, float var2, float var3, int var4) {
      if (ujt.alpha(var4) < 250) {
         uut.round(var0, var1 - var3, var2 - var3, var3, var3 * 2.0F, var3, 0.0F, 0.0F, var3, -4934468);
         uut.round(var0, var1, var2 - var3, var3, var3 * 2.0F, 0.0F, var3, var3, 0.0F, -13750732);
      }

      uut.circle(var0, var1, var2, var3, var4);
      uut.circleOutline(var0, var1, var2, var3, 0.8F, ujt.withAlpha(iov.textMuted, 110));
   }

   static String hum(int var0, boolean var1) {
      String var2 = String.format(Locale.ROOT, a.b("뼱욆䱀툷妎", -788087017), var0 & 16777215);
      int var3 = ujt.alpha(var0);
      return var1 && var3 < 255 ? var2 + a.c(-192320031, "淃ᑲ") + Math.round(var3 / 2.55F) + a.b("蝁", -1245083803) : var2;
   }

   void hun(DrawContext var1, hlc var2, iog var3, float var4, float var5, float var6, float var7) {
      float var8 = this.htw;
      float var9 = this.htx;
      float var10 = this.hty;
      float var11 = this.htz;
      float var12 = this.hug(var3);
      float var13 = iov.r(4.0F);
      int var14 = ujt.hsv(var8, 1.0F, 1.0F);
      uut.gradient(var1, this.x, var4, var12, 56.0F, var13, -1, var14, -16777216, -16777216);
      uut.outline(var1, this.x, var4, var12, 56.0F, var13, 1.0F, iov.stroke);
      float var15 = this.x + var9 * var12;
      float var16 = var4 + (1.0F - var10) * 56.0F;
      int var17 = ujt.hsv(var8, var9, var10);
      uut.shadow(var1, var15 - 3.5F, var16 - 3.5F, 7.0F, 7.0F, 3.5F, 2.0F, 1610612736);
      uut.circle(var1, var15, var16, 3.5F, -1);
      uut.circle(var1, var15, var16, 2.3F, var17);
      float var18 = this.x + var12 + 6.0F;
      float var19 = 9.333333F;
      float var20 = 4.5F;
      uut.gradientV(var1, var18, var4, 9.0F, var19 + var20, var20, ujt.hsv(0.0F, 1.0F, 1.0F), ujt.hsv((var19 + var20) / 56.0F, 1.0F, 1.0F));
      uut.gradientV(
         var1, var18, var4 + 56.0F - var19 - var20, 9.0F, var19 + var20, var20, ujt.hsv((56.0F - var19 - var20) / 56.0F, 1.0F, 1.0F), ujt.hsv(1.0F, 1.0F, 1.0F)
      );

      for (int var21 = 1; var21 < 5; var21++) {
         uut.gradientV(var1, var18, var4 + var19 * var21, 9.0F, var19, 0.0F, ujt.hsv(var21 / 6.0F, 1.0F, 1.0F), ujt.hsv((var21 + 1) / 6.0F, 1.0F, 1.0F));
      }

      huo(var1, var18, var4 + var8 * 56.0F);
      if (var3.hasAlpha()) {
         float var27 = var18 + 9.0F + 6.0F;
         uut.pushScissor(var1, var27, var4, 9.0F, 56.0F);
         float var22 = 4.5F;

         for (int var23 = 0; var23 * var22 < 56.0F; var23++) {
            for (int var24 = 0; var24 < 2; var24++) {
               uut.rect(
                  var1,
                  var27 + var24 * var22,
                  var4 + var23 * var22,
                  var22,
                  Math.min(var22, 56.0F - var23 * var22),
                  (var23 + var24) % 2 == 0 ? -1644822 : -6645086
               );
            }
         }

         uut.popScissor(var1);
         uut.gradientV(var1, var27, var4, 9.0F, 56.0F, 0.0F, var17, ujt.withAlpha(var17, 0));
         uut.outline(var1, var27, var4, 9.0F, 56.0F, Math.min(var20, iov.r(3.0F)), 1.0F, iov.stroke);
         huo(var1, var27, var4 + (1.0F - var11) * 56.0F);
      }

      float var28 = var4 + 56.0F + 10.0F;
      int var29 = ujt.withAlpha(var17, var3.hasAlpha() ? Math.round(var11 * 255.0F) : 255);
      hul(var1, this.x + 4.0F, var28, 3.5F, var29);
      irr.VALUE.draw(var1, hum(var29, var3.hasAlpha()), this.x + 11.0F, irr.VALUE.centerTop(var28), iov.textDim);
      boolean var30 = !var3.hud() && var3.slot() == 0;
      if (var30 || iov.isPainted(var3)) {
         String var31 = var30
            ? wap.s(a.d("疥వ蛥ᢓ鍐ᗸ꾳", -1402659237, 1108634557), a.d("綗Ї諊ი魰᷃ꞕ⸘뀰㪌뵚䝝", 2025431381, 1998182609))
            : wap.value(a.b("\uea85錀᧒螸", -2113606976));
         float var25 = Math.max(16.0F, irr.SMALL.width(var31) + 9.0F);
         float var26 = this.htt.step(var2.canHover() && irr.inside(var5, var6, this.x + this.w - var25, var28 - 5.5F, var25, 11.0F), var7);
         irr.drawChip(var1, var31, this.x + this.w, var28, ujt.lerp(iov.textDim, iov.text, var26), ujt.lerp(iov.stroke, iov.accent(150), var26), var26);
      }
   }

   static void huo(DrawContext var0, float var1, float var2) {
      uut.shadow(var0, var1 - 1.5F, var2 - 2.0F, 12.0F, 4.0F, 2.0F, 2.0F, 1610612736);
      uut.outline(var0, var1 - 1.5F, var2 - 2.0F, 12.0F, 4.0F, 2.0F, 1.3F, -1);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      iog[] var5 = hue();

      for (int var6 = 0; var6 < var5.length; var6++) {
         iog var7 = var5[var6];
         float var8 = this.huf(var6);
         if (irr.inside(var2, var3, this.x - 3.0F, var8, this.w + 6.0F, 16.0F)) {
            if (var4 == 1) {
               iov.clearPaint(var7);
               if (var6 == this.htv) {
                  this.hui(var7, true);
               }

               return true;
            }

            if (var4 != 0) {
               return false;
            }

            this.htv = this.htv == var6 ? -1 : var6;
            if (this.htv == var6) {
               this.hui(var7, true);
            }

            return true;
         }

         if (var6 == this.htv && this.hts[var6].get() > 0.9F && var4 == 0 && this.hup(var1, var7, var8 + 16.0F + 4.0F, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   boolean hup(hlc var1, iog var2, float var3, float var4, float var5) {
      float var6 = this.hug(var2);
      float var7 = this.x + var6 + 6.0F;
      this.hub = var3;
      if (irr.inside(var4, var5, this.x - 2.0F, var3 - 2.0F, var6 + 4.0F, 60.0F)) {
         this.hua = 1;
      } else if (irr.inside(var4, var5, var7 - 3.0F, var3 - 3.0F, 15.0F, 62.0F)) {
         this.hua = 2;
      } else {
         if (!var2.hasAlpha() || !irr.inside(var4, var5, var7 + 9.0F + 6.0F - 3.0F, var3 - 3.0F, 15.0F, 62.0F)) {
            float var8 = var3 + 56.0F + 10.0F;
            boolean var9 = !var2.hud() && var2.slot() == 0;
            String var10 = var9 ? wap.s(a.b("䱡㗱뼡⅗ꪔⰼ陷", 395856930), a.c(-1832929640, "늋쬛䗖\udfc4呬틟梉\ue104缬\uf590牆衁")) : wap.value(a.b("૦獣鈴柛", -1071904093));
            float var11 = Math.max(16.0F, irr.SMALL.width(var10) + 9.0F);
            if ((var9 || iov.isPainted(var2)) && irr.inside(var4, var5, this.x + this.w - var11, var8 - 5.5F, var11, 11.0F)) {
               iov.clearPaint(var2);
               this.hui(var2, true);
               return true;
            }

            return false;
         }

         this.hua = 3;
      }

      var1.startDrag(this);
      this.mouseDragged(var4, var5);
      return true;
   }

   @Override
   void mouseDragged(float var1, float var2) {
      iog[] var3 = hue();
      if (this.htv >= 0 && this.htv < var3.length && this.hua != 0) {
         iog var4 = var3[this.htv];
         float var5 = huq((var2 - this.hub) / 56.0F);
         switch (this.hua) {
            case 1:
               this.htx = huq((var1 - this.x) / this.hug(var4));
               this.hty = 1.0F - var5;
               break;
            case 2:
               this.htw = Math.min(0.999F, var5);
               break;
            default:
               this.htz = 1.0F - var5;
         }

         if (this.hua != 3 && var4.hasAlpha() && !iov.isPainted(var4) && this.htz < 0.35F) {
            this.htz = 1.0F;
         }

         iov.setPaint(var4, this.huj(var4), this.htw, this.htx, this.hty);
      }
   }

   static float huq(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }
}
