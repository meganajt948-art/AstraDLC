package a;

import flow.dev.a;
import java.util.function.IntPredicate;
import net.minecraft.client.gui.DrawContext;

final class iks extends imn {
   static final float ikt = 17.0F;
   static final float iku = 64.0F;
   static final IntPredicate ikv = var0 -> Character.isLetterOrDigit(var0) || var0 == 45 || var0 == 32;
   final iah field = new iah(a.c(-1845535435, "嵾⓻긳ぎ뮒㴩蜹ຜ邐ᩢ鶽柇\ue911"), vhz.USER_PLUS, 9, ikv);
   final vcj ikw = new vcj(16.0F);
   final vcj ikx = new vcj(9.0F);
   hlc iky;

   iks() {
      super(null);
      this.field.onSubmit = this::ilc;
   }

   @Override
   float height() {
      return 24.0F;
   }

   float ilb() {
      return this.x + this.w - 64.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.iky = var2;
      float var6 = this.y + 4.0F;
      this.field.x = this.x;
      this.field.y = var6;
      this.field.w = this.w - 64.0F - 6.0F;
      this.field.h = 17.0F;
      this.field.render(var1, var2, var3, var4, var5);
      float var7 = this.ikw.step(var2.canHover() && irr.inside(var3, var4, this.ilb(), var6, 64.0F, 17.0F), var5);
      irr.primaryButton(
         var1,
         wap.s(a.d("짝끋㪀ꓮ⼤ꦄ", 508246472, 2108026970), a.c(269984942, "ꂻ\ud955叾춄䙛샡竃\uf34b浮\ue7d1")),
         vhz.PLUS,
         this.ilb(),
         var6,
         64.0F,
         17.0F,
         var7,
         this.ikx.step(0.0F, var5)
      );
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      this.iky = var1;
      if (this.field.mouseClicked(var1, var2, var3, var4)) {
         return true;
      } else if (var4 == 0 && irr.inside(var2, var3, this.ilb(), this.y + 4.0F, 64.0F, 17.0F)) {
         this.ikx.set(1.0F);
         this.ilc();
         return true;
      } else {
         return false;
      }
   }

   void ilc() {
      if (ucg.normalize(this.field.text) == null) {
         this.field.error();
         if (this.iky != null) {
            this.iky
               .toast(
                  wap.s(a.b("ℾ墣퉻䰋쟊䄨\ufb37狅\uec9a是\ue1b7ᮊ镘೫蚶\u0002먬㗾꽌⥳ꂛ\udacb呿", 247996778), a.b("贫\uf4be繧\ue402毇\ued0f圤\udedd䃶쨼䷣럨㵝ꃶ⪯걔ሁ鶱܁腑ࣈ犆ﰴ柢", 841517353)),
                  vhz.USER_PLUS,
                  true
               );
         }
      } else {
         ucg.invite(this.field.text);
         this.field.setText("");
         if (this.iky != null) {
            this.iky.focus(null);
         }
      }
   }
}
