package a;

import flow.dev.a;
import java.util.function.IntPredicate;
import net.minecraft.client.gui.DrawContext;

final class hxv extends imn {
   private static final float hxw = 17.0F;
   private static final float hxx = 52.0F;
   private static final IntPredicate hxy = var0 -> var0 > 32 && var0 != 127 && var0 != 167;
   final iah name = new iah(a.c(1291375195, "툀ꮍ⅓뼺㓱뉗ࡖ臩Ᾱ锄ዟ"), vhz.USER_PLUS, 20, hxy);
   private final vcj hxz = new vcj(16.0F);
   private final vcj hya = new vcj(9.0F);
   private hlc hyb;

   hxv() {
      super(null);
      this.name.onSubmit = this::hyf;
   }

   @Override
   float height() {
      return 24.0F;
   }

   private float hye() {
      return this.x + this.w - 52.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.hyb = var2;
      float var6 = this.y + 4.0F;
      this.name.x = this.x;
      this.name.y = var6;
      this.name.w = this.w - 52.0F - 6.0F;
      this.name.h = 17.0F;
      this.name.render(var1, var2, var3, var4, var5);
      float var7 = this.hxz.step(var2.canHover() && irr.inside(var3, var4, this.hye(), var6, 52.0F, 17.0F), var5);
      irr.primaryButton(
         var1,
         wap.s(a.d("鱥\ue5f1漢", 363118095, 358883880), a.b("壸Ⅳꮿ㗏븚㢡芈୷", -1100325660)),
         vhz.PLUS,
         this.hye(),
         var6,
         52.0F,
         17.0F,
         var7,
         this.hya.step(0.0F, var5)
      );
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      this.hyb = var1;
      if (this.name.mouseClicked(var1, var2, var3, var4)) {
         return true;
      } else if (var4 == 0 && irr.inside(var2, var3, this.hye(), this.y + 4.0F, 52.0F, 17.0F)) {
         this.hya.set(1.0F);
         this.hyf();
         return true;
      } else {
         return false;
      }
   }

   private void hyf() {
      String var1 = hhf.clean(this.name.text);
      if (var1 == null) {
         this.name.error();
         if (this.hyb != null) {
            this.hyb
               .toast(
                  wap.s(a.c(73502098, "跔\uf448纒\ue0f6此\ued94垆\ude27䁤쫘䴓띾㦾ꁝ⩀겾\u16fd餤"), a.d("麞\ue70f淛\uf3ab硰ﺻ䒟쥻匹\ud98d幜ꀷ⫸덂㥢뿭֦詽", -735275264, 1972243870)),
                  vhz.USER_PLUS,
                  true
               );
         }
      } else if (!hhf.add(var1)) {
         this.name.error();
         if (this.hyb != null) {
            this.hyb
               .toast(
                  wap.s(var1 + a.b("\uf0cc褴Ͻ鷟ᙉ郵⪸ꍞ㴅랱み쩗䓁\udd31圤퇁殕\ue448绰\uf8ab", 1724641528), var1 + a.c(792985682, "|綮\uf708楺\ue6b8搛\uda5a垿즔䌦쒁㺋끟⧤")),
                  vhz.FRIENDS,
                  true
               );
         }
      } else {
         this.name.setText("");
         if (this.hyb != null) {
            this.hyb.toast(wap.s(a.b("肦爐珡\ued91晇\ue0b2", 933920993), a.b("\ue42b鶰ᝬ褜ˉ葱㸬럕\u2d97", -295903178)) + var1, vhz.FRIENDS, false);
            this.hyb.focus(null);
         }
      }
   }
}
