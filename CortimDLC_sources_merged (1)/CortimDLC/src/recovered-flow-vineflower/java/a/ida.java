package a;

import flow.dev.a;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public final class ida extends Screen {
   private static final float idb = 240.0F;
   private static final float idc = 150.0F;
   private static final float idd = 16.0F;
   private static final float ide = 52.0F;
   private static final float idf = 64.0F;
   private static final float idg = 10.0F;
   private static final wam[] idh = new wam[]{wam.RU, wam.EN};
   private final Screen idi;
   private final vdc idj = new vdc(0.32F, 0.0F);
   private final vcj[] idk = new vcj[]{new vcj(16.0F), new vcj(16.0F)};
   private final vcj[] idl = new vcj[]{new vcj(12.0F), new vcj(12.0F)};
   private int idm;
   private boolean idn;
   private boolean ido;
   private long idp = -1L;
   private float idq = 0.016666668F;
   private float idr = 1.0F;
   private float ids;
   private float idt;

   public ida(Screen var1) {
      super(Text.literal(a.b("㫨䍴즨埐\udc15媰\ue0e5椖", -1252902228)));
      this.idi = var1;
      this.idm = !wap.ru() && wap.chosen() ? 1 : 0;

      for (int var2 = 0; var2 < idh.length; var2++) {
         this.idl[var2].set(wap.chosen() && wap.get() == idh[var2] ? 1.0F : 0.0F);
      }
   }

   private void idw(DrawContext var1) {
      unf.observe(var1);
      if (unf.frame() != this.idp) {
         this.idp = unf.frame();
         this.idq = unf.delta() * (float)iov.ANIMATION.get();
         iov.update(this.idq);
         this.idj.update(this.idq);
         if (this.idn && this.idj.finished() && !this.ido && this.client != null) {
            this.ido = true;
            this.client.send(() -> this.client.setScreen(this.idi));
         }
      }
   }

   private float idx() {
      float var1 = this.idj.linear();
      return this.idn ? vcq.outCubic(var1) : vcq.outQuint(var1);
   }

   @Override
   public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      uut.beginFrame();
      this.idw(context);
      float var5 = this.idx();
      if (this.client != null && this.client.world != null) {
         hyv.capture(context, Math.max(1, iov.BG_BLUR.getInt()), var5, null);
         uut.rect(context, 0.0F, 0.0F, this.width, this.height, ujt.withAlpha(0, Math.round(140.0F * var5)));
      } else {
         hyv.skip();
         this.renderPanoramaBackground(context, deltaTicks);
         context.applyBlur();
         uut.rect(context, 0.0F, 0.0F, this.width, this.height, ujt.withAlpha(0, Math.round(120.0F * var5)));
      }
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      this.idw(context);
      float var5 = this.idx();
      float var6 = Math.min((this.width - 16.0F) / 240.0F, (this.height - 16.0F) / 150.0F);
      float var7 = Math.max(0.4F, Math.min((float)iov.SCALE.get() * 1.1F, var6));
      this.idr = var7 * (0.96F + 0.04F * var5);
      this.ids = this.width * 0.5F - 120.0F * this.idr;
      this.idt = this.height * 0.5F - 75.0F * this.idr + (1.0F - var5) * 8.0F;
      float var8 = (mouseX - this.ids) / this.idr;
      float var9 = (mouseY - this.idt) / this.idr;
      vdn.setRenderScale(var7);
      context.getMatrices().pushMatrix();
      context.getMatrices().translate(this.ids, this.idt);
      context.getMatrices().scale(this.idr, this.idr);
      uut.pushAlpha(var5);

      try {
         this.iea(context, var8, var9);
      } finally {
         uut.popAlpha();
         context.getMatrices().popMatrix();
         vdn.setRenderScale(1.0F);
      }
   }

   private float idy() {
      return 99.0F;
   }

   private float idz(int var1) {
      return 16.0F + var1 * (this.idy() + 10.0F);
   }

   private void iea(DrawContext var1, float var2, float var3) {
      float var4 = iov.r(12.0F);
      float var5 = iov.lightness();
      uut.shadow(var1, 0.0F, 4.0F, 240.0F, 150.0F, var4, 18.0F, iov.shadow);
      uut.round(var1, 0.0F, 0.0F, 240.0F, 150.0F, var4, ujt.withAlpha(iov.window, 255));
      ukf.sheen(var1, 0.0F, 0.0F, 240.0F, 60.0F, var4, 0.8F * (1.0F - 0.7F * var5));
      uut.outline(var1, 0.0F, 0.0F, 240.0F, 150.0F, var4, 1.0F, iov.stroke);
      ukf.rim(var1, 0.0F, 0.0F, 240.0F, 150.0F, var4, var5, 1.1F);
      uut.circle(var1, 25.0F, 24.0F, 10.0F, iov.accent(40));
      vjf.draw(var1, vhz.GLOBE, 25.0F, 24.0F, 11.0F, iov.accent());
      String var6 = wap.chosen()
         ? wap.s(a.b("쯞뉂㢞ꛦⴣꮆᇓ頠", 393661338), a.d("뇕졼䋓\udcd3", 1297834209, -128330465))
         : a.c(1582281012, "딊첣䘌\ud80c埁텰殴\ue2d2粍\uf650熮诐Ԏ鲭ᛪ逝⩐");
      irr.TITLE.draw(var1, var6, 41.0F, irr.TITLE.centerTop(20.0F), iov.text);
      String var7 = wap.chosen()
         ? wap.s(a.b("몋쌑䧅ힴ屿\udad8惎\ue96b眨ﶔ稂耰\u0ee8靜ᴃ鯹↬긩㓖늊㭲䄪쾋呎툷壤", -761873710), a.b("\uef61隉ᰠ艕৷輾㔗벑⛛ꠅ⾮햣嬅욮䣧츗瑛ﮇ愼\ue712溗", 245951334))
         : a.d("廙荫ূ鞷ᰕ髜\u20f5ꥳ㌹뷧㩌쁁仧퍌够\udf79斡\uea70炠\uf6da缪ջ诔ဓ阩Სꔄ⭏놿㞼뱃䊟죟儧흦巃\ue212桡", 611543645, -1054173974);
      irr.SUBTITLE.draw(var1, irr.SUBTITLE.ellipsize(var7, 183.0F), 41.0F, irr.SUBTITLE.centerTop(32.0F), iov.textMuted);

      for (int var8 = 0; var8 < idh.length; var8++) {
         this.ieb(var1, var8, var2, var3);
      }

      String var9 = !wap.chosen() && !wap.ru()
         ? a.c(1038001636, "ꇢ\ud84e劔쳭䜿쇴箩\uf634汷\ue6c4感魥ᖱ蠞ٗ股㫭딽⾋꧞\u202e幦풴䬄쥨䎱輻瑙\ueedc梏\ue343ᶐ鏃ภ象ˌ봒㝫뇋")
         : wap.s(
            a.d("ￆ虁ಈ銬ᤸ龋◗걨㉴룎㼔앪䮴툇堑\udea9擻\ueb7e熌\uf7d2縲к諝ᄑ靪ᶳꑟ⨔낷㛺뵄䏐짘倢홲峎\ue31e椪\uefbb瘝ﱃ芲ࣺ轊ᗓ鯫∿ꣀ⻛딖㭨쇼䠆칟咧\udaed", 421599620, 730326563),
            a.b("\uf7a8踄Ӟ骧ᅵ鞾ⷣꁾ㨽낎㝕촯䏻\ude54倕틶沢\ue306秊ﾔ癤ࠬ芃ᥐ鼭ᗵ걎≠볯㪤딍䯛솗塧\ude31咊\uef4d慝\ue3ef繍\uf41a諮²蝱ᶤ鎪⩻ꓖ⚋륈㌧짿䁀왢", 1254093759)
         );
      irr.SMALL.drawCentered(var1, irr.SMALL.ellipsize(var9, 208.0F), 120.0F, irr.SMALL.centerTop(135.0F), ujt.mulAlpha(iov.textMuted, 0.9F));
   }

   private void ieb(DrawContext var1, int var2, float var3, float var4) {
      float var5 = this.idz(var2);
      float var6 = this.idy();
      boolean var7 = !this.idn && irr.inside(var3, var4, var5, 52.0F, var6, 64.0F);
      if (var7) {
         this.idm = var2;
      }

      float var8 = this.idk[var2].step(var7 || this.idm == var2 && !this.iec(var3, var4), this.idq);
      boolean var9 = wap.chosen() && wap.get() == idh[var2];
      float var10 = this.idl[var2].step(var9, this.idq);
      float var11 = 52.0F - 1.5F * var8;
      float var12 = iov.r(8.0F);
      float var13 = iov.lightness();
      ukf.shadow(var1, var5, var11, var6, 64.0F, var12, 0.3F + 0.7F * var8, var13);
      uut.round(var1, var5, var11, var6, 64.0F, var12, ujt.lerp(iov.card | 0xFF000000, iov.cardHover | 0xFF000000, var8));
      uut.outline(
         var1, var5, var11, var6, 64.0F, var12, 1.0F, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, 0.35F * var8), iov.accent(), Math.max(var10, 0.6F * var8))
      );
      ukf.rim(var1, var5, var11, var6, 64.0F, var12, var13, 0.8F);
      flag(var1, idh[var2], var5 + 11.0F, var11 + 11.0F);
      boolean var14 = idh[var2] == wam.RU;
      irr.LOGO
         .draw(
            var1,
            var14 ? a.d("弎⚸", -1058973484, 1871185802) : a.d("⿵噏", -1884537318, -1922952792),
            var5 + 11.0F,
            irr.LOGO.centerTop(var11 + 38.0F),
            ujt.lerp(iov.textDim, iov.text, Math.max(var8, var10))
         );
      irr.LABEL
         .draw(
            var1,
            var14 ? a.c(-1249791253, "뛌켞䗏\udbbe倒횡泳") : a.b("胜牢玜\uede6昴\ue09f嫗", 1732673694),
            var5 + 11.0F,
            irr.LABEL.centerTop(var11 + 52.0F),
            iov.textMuted
         );
      if (var10 > 0.01F) {
         float var15 = var5 + var6 - 12.0F;
         float var16 = var11 + 12.0F;
         float var17 = vcq.outBack(var10);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(var15, var16);
         var1.getMatrices().scale(var17, var17);
         uut.circle(var1, 0.0F, 0.0F, 5.5F, iov.accent());
         vjf.draw(var1, vhz.CHECK, 0.0F, 0.0F, 7.0F, iov.onAccent());
         var1.getMatrices().popMatrix();
      } else if (var8 > 0.01F) {
         uut.pushAlpha(var8);
         vjf.draw(var1, vhz.CHEVRON_RIGHT, var5 + var6 - 12.0F, var11 + 32.0F, 8.0F, iov.accent());
         uut.popAlpha();
      }
   }

   private boolean iec(float var1, float var2) {
      for (int var3 = 0; var3 < idh.length; var3++) {
         if (irr.inside(var1, var2, this.idz(var3), 52.0F, this.idy(), 64.0F)) {
            return true;
         }
      }

      return false;
   }

   public static void flag(DrawContext var0, wam var1, float var2, float var3) {
      float var4 = 20.0F;
      float var5 = 13.0F;
      float var6 = 2.5F;
      if (var1 == wam.RU) {
         uut.round(var0, var2, var3, var4, var5, var6, -2807010);
         uut.round(var0, var2, var3, var4, var5 * 2.0F / 3.0F, var6, var6, 0.0F, 0.0F, -16762458);
         uut.round(var0, var2, var3, var4, var5 / 3.0F, var6, var6, 0.0F, 0.0F, -1);
         uut.rect(var0, var2, var3 + var5 / 3.0F - 0.5F, var4, 1.0F, -16762458);
      } else {
         uut.round(var0, var2, var3, var4, var5, var6, -14729329);
         uut.line(var0, var2 + 1.0F, var3 + 1.0F, var2 + var4 - 1.0F, var3 + var5 - 1.0F, 2.2F, -1);
         uut.line(var0, var2 + var4 - 1.0F, var3 + 1.0F, var2 + 1.0F, var3 + var5 - 1.0F, 2.2F, -1);
         uut.line(var0, var2 + 1.0F, var3 + 1.0F, var2 + var4 - 1.0F, var3 + var5 - 1.0F, 0.9F, -3665874);
         uut.line(var0, var2 + var4 - 1.0F, var3 + 1.0F, var2 + 1.0F, var3 + var5 - 1.0F, 0.9F, -3665874);
         uut.rect(var0, var2 + var4 * 0.5F - 2.0F, var3, 4.0F, var5, -1);
         uut.rect(var0, var2, var3 + var5 * 0.5F - 2.0F, var4, 4.0F, -1);
         uut.rect(var0, var2 + var4 * 0.5F - 1.1F, var3, 2.2F, var5, -3665874);
         uut.rect(var0, var2, var3 + var5 * 0.5F - 1.1F, var4, 2.2F, -3665874);
      }

      uut.outline(var0, var2, var3, var4, var5, var6, 0.8F, 805306368);
   }

   private void ied(int var1) {
      if (!this.idn) {
         wap.set(idh[var1]);
         hyz.saveLater();
         this.close();
      }
   }

   @Override
   public boolean mouseClicked(Click click, boolean doubled) {
      if (!this.idn && click.button() == 0) {
         float var3 = (float)((click.x() - this.ids) / this.idr);
         float var4 = (float)((click.y() - this.idt) / this.idr);

         for (int var5 = 0; var5 < idh.length; var5++) {
            if (irr.inside(var3, var4, this.idz(var5), 52.0F, this.idy(), 64.0F)) {
               this.ied(var5);
               return true;
            }
         }

         return true;
      } else {
         return true;
      }
   }

   @Override
   public boolean keyPressed(KeyInput input) {
      int var2 = input.key();
      if (this.idn) {
         return true;
      }

      switch (var2) {
         case 32:
         case 257:
         case 335:
            this.ied(this.idm);
            break;
         case 256:
            this.close();
            break;
         case 258:
         case 262:
         case 264:
            this.idm = this.idm == 0 ? 1 : 0;
            break;
         case 263:
         case 265:
            this.idm = 0;
      }

      return true;
   }

   @Override
   public void close() {
      if (!this.idn) {
         this.idn = true;
         this.idj.backward();
      }
   }

   @Override
   public void removed() {
      vdn.setRenderScale(1.0F);
   }

   @Override
   public boolean shouldPause() {
      return false;
   }

   @Override
   public boolean shouldCloseOnEsc() {
      return false;
   }
}
