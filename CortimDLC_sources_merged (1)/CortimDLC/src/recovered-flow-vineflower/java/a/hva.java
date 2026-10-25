package a;

import flow.config.ConfigShare;
import flow.dev.a;
import java.io.IOException;
import java.util.function.IntPredicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class hva extends imn {
   static final float hvb = 24.0F;
   static final float hvc = 17.0F;
   static final float hvd = 78.0F;
   static final IntPredicate hve = var0 -> Character.isLetterOrDigit(var0) || var0 == 45 || var0 == 32;
   final iah field = new iah(a.b("\uf7bb踥ӱ骊ᄙ韩ⷻꑉ㨚낪㝱촏䏖\uda20倱훛泍\ue35f秠ﾺ癌", -84936728), vhz.SEARCH, 20, hve);
   final vcj hvf = new vcj(16.0F);
   final vcj hvg = new vcj(9.0F);
   hlc hvh;
   boolean hvi;

   hva() {
      super(null);
      this.field.onSubmit = this::hvm;
   }

   @Override
   float height() {
      return 24.0F;
   }

   float hvl() {
      return this.x + this.w - 78.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.hvh = var2;
      float var6 = this.y + 3.5F;
      this.field.x = this.x;
      this.field.y = var6;
      this.field.w = this.w - 78.0F - 6.0F;
      this.field.h = 17.0F;
      this.field.render(var1, var2, var3, var4, var5);
      boolean var7 = var2.canHover() && irr.inside(var3, var4, this.hvl(), var6, 78.0F, 17.0F);
      float var8 = this.hvf.step(var7, var5);
      irr.secondaryButton(
         var1,
         this.hvi
            ? wap.s(a.c(-523296598, "⃮奼펯䷚옏䂹\ufae3卓"), a.b("ꌥ\udac5偪츒懟", -1408260296))
            : wap.s(a.b("皍༓藇ᮼ", 1945335503), a.b("\u0b4a狖\uf80c昆\uedab", -1950609582)),
         vhz.DOWNLOAD,
         this.hvl(),
         var6,
         78.0F,
         17.0F,
         this.hvi ? 1.0F : var8,
         this.hvg.step(0.0F, var5)
      );
      if (var7 || var2.canHover() && this.field.contains(var3, var4)) {
         var2.hint(
            wap.s(
               a.d("\uf7aa踪ӫ骝ᅛ鞯ⶽꐍ㨔낱㝹촄䏘\uda63偳훖泊\ue358秧ﾽ癋\u0c45苬ᥩ鼊ᗖ걩∣뢆㺔딫䯻솼塂\ude1f哩\ueb6d愇\ue7d3繺\uf421誃\u0085蜱ᶶ鎎⩚ꂥ⚳뵴㌝짋䀮옳峅튎椶", 1460751860, 1230879287),
               a.c(-1918236400, "ഴ瓖︆怅\uebd0洟흂廄쒎䨥췲㞉뵊⃯\uaac8ⰺ阅᧗蝮ĥ資\uf690砮\ue7e1斄\uef51囡\ud8c9䉂쐘䮸녶㬸ꊸ⒖긭ᆀ鯲ᴯ胱ຼ瑟羽維\ue702椎탔幹\udc57䟸즌㌤뫨㲶")
            )
         );
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      this.hvh = var1;
      if (this.field.mouseClicked(var1, var2, var3, var4)) {
         return true;
      } else {
         float var5 = this.y + 3.5F;
         if (var4 == 0 && irr.inside(var2, var3, this.hvl(), var5, 78.0F, 17.0F)) {
            this.hvg.set(1.0F);
            this.hvm();
            return true;
         } else {
            return false;
         }
      }
   }

   void hvm() {
      if (!this.hvi) {
         if (ConfigShare.normalize(this.field.text) == null) {
            this.field.error();
            if (this.hvh != null) {
               this.hvh.toast(ConfigShare.describe(new IOException(a.c(264856768, "撠ᴘ韖স艣Ӈ"))), vhz.SEARCH, true);
            }
         } else {
            this.hvi = true;
            hlc var1 = this.hvh;
            ConfigShare.fetch(this.field.text)
               .whenCompleteAsync(
                  (var2, var3) -> {
                     this.hvi = false;
                     if (var3 != null) {
                        this.field.error();
                        if (var1 != null) {
                           var1.toast(ConfigShare.describe(var3), vhz.INFO, true);
                        }
                     } else {
                        this.field.setText("");
                        if (var1 != null) {
                           var1.focus(null);
                           var1.toast(
                              var2.existed()
                                 ? wap.s(
                                    a.c(-420528099, "䁒㧕댜ⴸꚮ‒驟Ꮉ跢ݖ肘窰\uf42f涗\ue7d3愱\udb3b咣츍䠒쇿鮒") + var2.name() + a.c(-1946215197, "㳿"),
                                    a.d("恇᧣錳ॗ蚕P먀㏿꧌✞꒮嫍퐘䷘쏰䔛\uffdf", -362043109, 1555484014) + var2.name() + a.b("먌", 1473821366)
                                 )
                                 : wap.s(
                                    a.b("ﯨ艼ࢯ雟ᴉ鯼Ɠ", 1966930862) + var2.name() + a.c(679319738, "뢦"),
                                    a.d("쪕댎㧒Ꞣⱷ\uaacf႒饫̩褓", -500554656, 357034731) + var2.name() + a.b("䜰", 1397901194)
                                 ),
                              vhz.DOWNLOAD,
                              false
                           );
                        }
                     }
                  },
                  MinecraftClient.getInstance()
               );
         }
      }
   }
}
