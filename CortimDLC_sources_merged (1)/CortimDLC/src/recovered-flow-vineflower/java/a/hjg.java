package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class hjg {
   private static final float hjh = 10.0F;
   private static final float hji = 27.0F;
   private static final vdn hjj = veo.bold(5.5F);
   private static final String hjk = a.c(2065082239, "Ꜫ\ude84呎");
   private static final int hjl = -14003;
   private static final int hjm = -1013204;
   private static final int hjn = -14018301;
   private static final boolean hjo = !Boolean.getBoolean(a.b("셍룶㈦걏⟝ꅰ᭾銙\u0ccf虴Ƶﯕ甔\ueca2", 1706410277));
   final kfe module;
   final String title;
   private final String hjp;
   final List<imn> rows = new ArrayList<>();
   private vkl hjq;
   private final irk hjr;
   private final vcj hjs = new vcj(14.0F);
   private final vcj hjt;
   private final vcj hju = new vcj(13.0F, 1.0F);
   private final vcj hjv = new vcj(16.0F);
   private final vcj hjw = new vcj(14.0F);
   private final vcj hjx = new vcj(7.0F);
   private boolean hjy;
   private float hjz;
   private float hka;
   float x;
   float y;
   float w;
   int column;
   int home = -1;
   boolean wide;

   hjg(kfe var1) {
      this.module = var1;
      this.title = var1.getDisplayName();
      this.hjp = null;
      this.hjt = new vcj(12.0F, var1.isEnabled() ? 1.0F : 0.0F);
      this.hjr = var1.isLocked() ? null : new irk(var1.getDisplayName(), var1::getKey, var1::setKey, true);
      this.settings(var1.getSettings());
      this.hjy = !this.rows.isEmpty();
      this.hju.set(this.hjy ? 0.0F : 1.0F);
   }

   String shownTitle() {
      return this.module != null ? this.title : wap.t(this.title);
   }

   String description() {
      String var1 = wap.t(this.module != null ? this.module.getDescription() : (this.hjp != null ? this.hjp : ""));
      if (this.hkg()) {
         return wap.s(a.c(546961610, "\uf88c脆\u0bdf閯ṯ颌⊒\uab6f㔸뾎㡇숧䳻핅弙\ud9e5掬\uec36皋"), a.c(732046637, "ℂ墤툇䠝쏄䄕זּ狆\uec96晛\ue181ᾕ酌")) + var1;
      } else {
         return this.hkf() ? wap.s(a.b("\ueb1b銵\u187f虾෦譖ㄇ룣⛫걔", 129493831), a.c(793341252, "楶მ騍Ћ辪ट띒㪷ꓧ⸢궞垙\ud951䃹쫔䰫")) + var1 : var1;
      }
   }

   String searchDescription() {
      return wap.both(this.module != null ? this.module.getDescription() : this.hjp);
   }

   float headBottom() {
      return this.y + 27.0F;
   }

   hjg(String var1, String var2) {
      this.module = null;
      this.title = var1;
      this.hjp = var2;
      this.hjt = new vcj(12.0F, 0.0F);
      this.hjr = null;
      this.hjy = hjo;
      this.hju.set(this.hjy ? 0.0F : 1.0F);
   }

   hjg settings(List<? extends vmo> var1) {
      for (vmo var3 : var1) {
         imn var4 = imn.of(var3);
         if (var4 != null) {
            this.rows.add(var4);
         }
      }

      return this;
   }

   hjg row(imn var1) {
      this.rows.add(var1);
      return this;
   }

   hjg unfolded() {
      this.hjy = false;
      this.hju.set(1.0F);
      return this;
   }

   hjg toggle(vkl var1) {
      this.hjq = var1;
      this.hjt.set(var1.get() ? 1.0F : 0.0F);
      return this;
   }

   imn rowFor(vmo var1) {
      for (imn var3 : this.rows) {
         if (var3.setting == var1) {
            return var3;
         }
      }

      return null;
   }

   boolean isCollapsed() {
      return this.hjy && !this.rows.isEmpty();
   }

   void setCollapsed(boolean var1) {
      this.hjy = var1 && !this.rows.isEmpty();
   }

   private boolean hkd() {
      return this.module != null ? this.module.isEnabled() : this.hjq != null && this.hjq.get();
   }

   private boolean hke() {
      return this.module != null && !this.module.isLocked() || this.hjq != null;
   }

   private boolean hkf() {
      return this.module != null && this.module.isVip();
   }

   private boolean hkg() {
      return this.module != null && this.module.isMaintenance();
   }

   private boolean hkh() {
      return this.module != null && this.module.isLocked();
   }

   private float hki() {
      if (this.rows.isEmpty()) {
         return 0.0F;
      } else {
         float var1 = 5.0F;

         for (imn var3 : this.rows) {
            var1 += var3.currentHeight();
         }

         return var1 + 6.0F;
      }
   }

   private float hkj() {
      if (this.rows.isEmpty()) {
         return 0.0F;
      } else {
         float var1 = 11.0F;

         for (imn var3 : this.rows) {
            var1 += var3.targetHeight();
         }

         return var1;
      }
   }

   float targetHeight() {
      return 27.0F + (this.hjy ? 0.0F : this.hkj());
   }

   float height() {
      return 27.0F + this.hki() * this.hju.get();
   }

   boolean headerHovered(float var1, float var2) {
      return irr.inside(var1, var2, this.x, this.y, this.w, 27.0F);
   }

   boolean hovered(float var1, float var2) {
      return irr.inside(var1, var2, this.x, this.y, this.w, this.height());
   }

   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      boolean var6 = var2.canHover();
      float var7 = this.hjs.step(var6 && this.hovered(var3, var4), var5);
      float var8 = this.hjt.step(this.hkd(), var5);
      this.hju.step(this.hjy ? 0.0F : 1.0F, var5);
      float var9 = this.hjw.step(this.hjr != null && var2.binding() == this.hjr, var5);

      for (imn var11 : this.rows) {
         var11.animate(var5);
      }

      float var26 = this.height();
      float var27 = iov.r(7.0F);
      float var12 = iov.lightness();
      var1.method_51448().pushMatrix();
      ukf.shadow(var1, this.x, this.y, this.w, var26, var27, 0.3F, var12);
      int var13 = ujt.lerp(iov.card, iov.cardHover, var7);
      boolean var14 = hyv.surface(var1, this.x, this.y, this.w, var26, var27, hyv.tint(iov.window, Math.min(0.95F, iov.windowTint())), var13, 7.0F, hyv.CARDS);
      if (var14) {
         uut.round(var1, this.x, this.y, this.w, var26, var27, ujt.mulAlpha(var13, ujt.alpha(var13) > 128 ? 0.35F : 1.0F));
      }

      ukf.sheen(var1, this.x, this.y, this.w, Math.min(var26, 60.0F), var27, 1.0F - 0.7F * var12);
      uut.outline(var1, this.x, this.y, this.w, var26, var27, 1.0F, ujt.lerp(iov.stroke, ujt.lerp(iov.stroke, iov.textMuted, 0.25F), var7));
      ukf.rim(var1, this.x, this.y, this.w, var26, var27, var12, 0.8F);
      float var15 = this.y + 13.5F;
      float var16 = this.x + this.w - 10.0F;
      float var17 = this.hkk(var5);
      if (this.hkh()) {
         float var18 = this.headerHovered(var3, var4) ? var7 : 0.0F;
         vjf.draw(
            var1,
            vhz.LOCK,
            var16 - 5.0F + var17,
            var15,
            7.5F,
            ujt.lerp(iov.textMuted, this.hkg() ? -1013204 : iov.accent(), Math.max(var18 * 0.7F, this.hjx.get()))
         );
         var16 -= 16.0F;
      } else if (this.hke()) {
         irr.drawSwitch(var1, var16 - 17.0F, var15 - 4.75F, var8, var7 * (this.headerHovered(var3, var4) ? 1.0F : 0.0F));
         var16 -= 23.0F;
      } else if (!this.rows.isEmpty()) {
         float var28 = this.hju.get();
         var1.method_51448().pushMatrix();
         var1.method_51448().translate(var16 - 4.0F, var15);
         var1.method_51448().rotate((float) (-Math.PI / 2) * (1.0F - var28));
         vjf.draw(var1, vhz.CHEVRON_DOWN, 0.0F, 0.0F, 7.0F, ujt.lerp(iov.textMuted, iov.textDim, Math.max(var7, var28 * 0.5F)));
         var1.method_51448().popMatrix();
         var16 -= 14.0F;
      }

      if (this.hjr != null) {
         var16 = this.hko(var1, var2, var16, var15, var3, var4, var5, var7, var9);
      }

      int var29 = this.hke() ? ujt.lerp(iov.textDim, iov.text, Math.max(var8, var7 * 0.6F)) : iov.text;
      float var19 = this.x + 10.0F;
      if (this.hkh()) {
         String var20 = this.hkg() ? hkl() : a.d("쭀닮㠤", 1536986414, 1042695739);
         float var21 = hkm(var20);
         String var22 = irr.CARD_TITLE.ellipsize(this.shownTitle(), var16 - var19 - 4.0F - var21 - 5.0F);
         irr.CARD_TITLE.draw(var1, var22, var19, irr.CARD_TITLE.centerTop(var15), ujt.lerp(iov.textDim, iov.text, var7 * 0.4F));
         float var23 = var19 + irr.CARD_TITLE.width(var22) + 5.0F + var17;
         if (this.hkg()) {
            this.hkn(var1, var23, var15, var7, vhz.WRENCH, var20, -14003, -1013204, -14018301, -1013204);
         } else {
            this.hkn(var1, var23, var15, var7, vhz.CROWN, var20, iov.accent(), iov.accent2(), iov.onAccent(), iov.accent());
         }
      } else {
         irr.CARD_TITLE.draw(var1, irr.CARD_TITLE.ellipsize(this.shownTitle(), var16 - var19 - 4.0F), var19, irr.CARD_TITLE.centerTop(var15), var29);
      }

      float var30 = var26 - 27.0F;
      if (var30 > 0.5F) {
         float var31 = this.hju.get();
         uut.pushAlpha(Math.min(1.0F, var31 * 1.4F));
         uut.rect(var1, this.x + 10.0F, this.y + 27.0F - 0.5F, this.w - 20.0F, 1.0F, iov.divider);
         uut.pushScissor(var1, this.x, this.y + 27.0F, this.w, var30);
         float var32 = this.y + 27.0F + 5.0F;

         for (imn var24 : this.rows) {
            float var25 = var24.currentHeight();
            var24.x = this.x + 10.0F;
            var24.y = var32;
            var24.w = this.w - 20.0F;
            if (var25 > 0.3F) {
               uut.pushScissor(var1, this.x, var32, this.w, var25);
               uut.pushAlpha(var24.opacity());
               var24.render(var1, var2, var24.interactive() ? var3 : -1000.0F, var24.interactive() ? var4 : -1000.0F, var5);
               uut.popAlpha();
               uut.popScissor(var1);
            }

            var32 += var25;
         }

         uut.popScissor(var1);
         uut.popAlpha();
      }

      var1.method_51448().popMatrix();
   }

   private float hkk(float var1) {
      float var2 = this.hjx.step(0.0F, var1);
      return var2 < 0.01F ? 0.0F : (float)Math.sin((1.0F - var2) * Math.PI * 6.0) * 2.2F * var2;
   }

   private static String hkl() {
      return wap.s(a.c(-1818683432, "ឞ渃\ue4d8窮\uf163矃춛䑥\uda35傉흜"), a.b("㔱䲗옴尮ퟷ唦\uef05曵\uf8a5牨\uf5b2", -1266339560));
   }

   private static float hkm(String var0) {
      return 8.5F + hjj.width(var0) + 9.0F;
   }

   private void hkn(DrawContext var1, float var2, float var3, float var4, vhz var5, String var6, int var7, int var8, int var9, int var10) {
      float var11 = hkm(var6);
      float var12 = 11.0F;
      float var13 = var3 - var12 * 0.5F;
      float var14 = iov.r(3.5F);
      float var15 = 0.5F + 0.5F * (float)Math.sin(System.nanoTime() / 4.5E8);
      uut.shadow(var1, var2, var13, var11, var12, var14, 3.5F, ujt.withAlpha(var10, (int)(40.0F + 50.0F * var15 + 40.0F * var4)));
      uut.gradientH(var1, var2, var13, var11, var12, var14, var7, var8);
      ukf.sheen(var1, var2, var13, var11, var12, var14, 1.6F);
      float var16 = (float)(System.nanoTime() / 1000000L % 2600L) / 2600.0F;
      if (var16 < 0.55F) {
         float var17 = var16 / 0.55F;
         float var18 = 7.0F;
         float var19 = var2 - var18 + (var11 + var18) * var17;
         int var20 = ujt.withAlpha(-1, (int)(95.0 * Math.sin(Math.PI * var17)));
         uut.pushScissor(var1, var2, var13, var11, var12);
         uut.gradientH(var1, var19, var13, var18 * 0.5F, var12, 0.0F, 16777215, var20);
         uut.gradientH(var1, var19 + var18 * 0.5F, var13, var18 * 0.5F, var12, 0.0F, var20, 16777215);
         uut.popScissor(var1);
      }

      uut.outlineGradientV(var1, var2, var13, var11, var12, var14, 1.0F, 1358954495, 335544320);
      float var21 = 6.0F;
      vjf.draw(var1, var5, var2 + 4.5F + var21 * 0.5F, var3 - 0.2F, var21, var9);
      hjj.draw(var1, var6, var2 + 4.5F + var21 + 2.5F, hjj.centerTop(var3), var9);
   }

   private float hko(DrawContext var1, hlc var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      int var10 = this.hjr.get();
      boolean var11 = var10 != -1;
      String var12 = var9 > 0.5F
         ? a.b("㉔䯥섶", -112905607)
         : (var11 ? irr.keyName(var10) : wap.s(a.d("䉘㯂넖⽭", 535131505, 1825191791), a.d("誈\uf310秆\ue7be", 833284317, -320641472)));
      float var13 = Math.max(var11 ? 1.0F : var8, var9);
      this.hka = Math.max(16.0F, irr.SMALL.width(var12) + 9.0F);
      this.hjz = var3 - this.hka;
      float var14 = this.hjv.step(var2.canHover() && irr.inside(var5, var6, this.hjz, var4 - 5.5F, this.hka, 11.0F), var7);
      if (var13 <= 0.01F) {
         return var3;
      } else {
         uut.pushAlpha(var13);
         float var15 = var9 > 0.01F ? 0.55F + 0.45F * (float)Math.sin(System.nanoTime() / 1.6E8) : 0.0F;
         int var16 = !var11 && !(var9 > 0.01F) ? iov.textMuted : ujt.lerp(iov.textDim, iov.accent(), var9);
         irr.drawChip(var1, var12, var3, var4, ujt.lerp(var16, iov.text, var14), ujt.lerp(iov.stroke, iov.accent((int)(120.0F + 110.0F * var15)), var9), var14);
         uut.popAlpha();
         return this.hjz - 4.0F;
      }
   }

   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (!this.hovered(var2, var3)) {
         return false;
      } else if (this.headerHovered(var2, var3)) {
         boolean var7 = this.hjr != null && irr.inside(var2, var3, this.hjz, this.y + 13.5F - 5.5F, this.hka, 11.0F);
         if (this.hjr == null || var4 != 2 && (var4 != 0 || !var7)) {
            if (var4 == 1 && !this.rows.isEmpty()) {
               this.hjy = !this.hjy;
            } else if (var4 == 0 && this.hkg()) {
               this.hjx.set(1.0F);
               var1.toast(
                  wap.s(
                     a.b("ᝣ滩\ue430穀\uf180督쵽䒀\udad7偡\ud7a8ⷈꌔ㪪냶㘊豃ϛ饤ί隃\uecd0扫隣翝\uf510䲣싳", 1823938346),
                     a.b("퀸ꦫ⍲뵴㛛뀝ย菎ᶜ錽ႌ\uea8a搭立玪\uf13b䬄쓔幨\ud845净⯤ꄾ㫣룽㉗诠\u05cf齆ᴉ銨汾\ue644翈立猫", -2099719168)
                  ),
                  vhz.WRENCH,
                  true
               );
            } else if (var4 == 0 && this.hkf()) {
               this.hjx.set(1.0F);
               var1.toast(
                  wap.s(
                     a.d("靱\ueef7搳琢熘\uf724䵴쒋嫝퀩垭귂⌈몥ゾ똹౩莡ᥢ齼ᚊ泙\ue27f", -731826511, -1156537962),
                     a.d("\udc12ꖉ⼥녗㪁뱌؝迯ᖮ魽᳒\ue6a6栆\uf1c1箖凉䝗쳧嘢크如", -1912363691, -1310098106)
                  ),
                  vhz.CROWN,
                  true
               );
            } else if (var4 == 0 && this.module != null) {
               this.module.toggle();
            } else if (var4 == 0 && this.hjq != null) {
               this.hjq.toggle();
            } else if (var4 == 0 && !this.rows.isEmpty()) {
               this.hjy = !this.hjy;
            }
         } else {
            var1.startBinding(this.hjr);
         }

         return true;
      } else {
         if (this.hju.get() > 0.9F) {
            for (imn var6 : this.rows) {
               if (var6.interactive() && var6.mouseClicked(var1, var2, var3, var4)) {
                  return true;
               }
            }
         }

         return true;
      }
   }
}
