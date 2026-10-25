package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public final class jbs extends Screen {
   private static final float jbt = 22.0F;
   private static final float jbu = 14.0F;
   private final vdc jbv = new vdc(0.25F, 0.0F);
   private final Map<jcs, vcj> jbw = new IdentityHashMap<>();
   private final Map<String, vcj> jbx = new HashMap<>();
   private final List<jbj> jby = new ArrayList<>();
   private float jbz;
   private float jca;
   private float jcb;
   private jcs jcc;
   private jcs jcd;
   private float jce;
   private float jcf;
   private float jcg = Float.NaN;
   private float jch = Float.NaN;
   private long jci = -1L;
   private float jcj = 0.016666668F;

   public jbs() {
      super(Text.method_43470(a.c(-1011260187, "撧ᴋ韉ড়艎Ӿ뺠㝌꤈⎤")));
   }

   private void jcm(DrawContext var1) {
      unf.observe(var1);
      if (unf.frame() != this.jci) {
         this.jci = unf.frame();
         this.jcj = unf.delta() * (float)iov.ANIMATION.get();
         this.jbv.update(this.jcj);
      }
   }

   public void method_25420(DrawContext var1, int var2, int var3, float var4) {
      uut.beginFrame();
      this.jcm(var1);
      float var5 = vcq.outCubic(this.jbv.linear());
      uut.rect(var1, 0.0F, 0.0F, this.field_22789, this.field_22790, ujt.withAlpha(0, Math.round(80.0F * var5)));
      float var6 = this.field_22787 != null ? Math.max(1, this.field_22787.method_22683().method_4495()) : 2.0F;
      float var7 = 1.0F / var6;
      int var8 = ujt.withAlpha(16777215, Math.round(9.0F * var5));

      for (float var9 = this.field_22789 * 0.5F % 24.0F; var9 < this.field_22789; var9 += 24.0F) {
         uut.rect(var1, var9, 0.0F, var7, this.field_22790, var8);
      }

      for (float var10 = this.field_22790 * 0.5F % 24.0F; var10 < this.field_22790; var10 += 24.0F) {
         uut.rect(var1, 0.0F, var10, this.field_22789, var7, var8);
      }

      int var11 = iov.accent(Math.round(40.0F * var5));
      uut.rect(var1, this.field_22789 * 0.5F, 0.0F, var7, this.field_22790, var11);
      uut.rect(var1, 0.0F, this.field_22790 * 0.5F, this.field_22789, var7, var11);
      izx.renderEditor(var1);
   }

   public void method_25394(DrawContext var1, int var2, int var3, float var4) {
      this.jcm(var1);
      float var5 = vcq.outCubic(this.jbv.linear());
      uut.pushAlpha(var5);

      try {
         this.jcn(var1, var2, var3);
         this.jco(var1);
         this.jcp(var1, var2, var3);
      } finally {
         uut.popAlpha();
      }
   }

   private void jcn(DrawContext var1, float var2, float var3) {
      jcs var4 = this.jcc != null ? this.jcc : (izx.resizing() != null ? izx.resizing() : this.jcr(var2, var3));

      for (jcs var6 : izx.ELEMENTS) {
         float var7 = this.jbw.computeIfAbsent(var6, var0 -> new vcj(16.0F)).step(var6 == var4, this.jcj);
         if (!(var6.w <= 0.0F)) {
            float var8 = iov.r(8.0F);
            uut.outline(var1, var6.x - 2.5F, var6.y - 2.5F, var6.w + 5.0F, var6.h + 5.0F, var8, 1.0F, iov.accent(Math.round(100.0F + 130.0F * var7)));
            if (var7 > 0.01F) {
               uut.round(var1, var6.x - 2.5F, var6.y - 2.5F, var6.w + 5.0F, var6.h + 5.0F, var8, iov.accent(Math.round(18.0F * var7)));
               String var9 = wap.t(var6.name)
                  + a.c(1722438881, "哄\u2d75ꜱ㧗눀")
                  + (var6 != izx.resizing() && var6.size == 1.0F ? jcq(var6) : Math.round(var6.size * 100.0F) + a.b("ᛵ", -1433004335));
               float var10 = izx.SMALL.width(var9) + 10.0F;
               float var11 = Math.max(2.0F, Math.min(this.field_22789 - var10 - 2.0F, var6.x + (var6.w - var10) * 0.5F));
               boolean var12 = var6.y < 16.0F;
               float var13 = var12 ? var6.y + var6.h + 5.0F : var6.y - 16.0F;
               uut.pushAlpha(var7);
               uut.round(var1, var11, var13, var10, 11.0F, Math.min(5.5F, iov.r(5.5F)), iov.accent());
               izx.SMALL.drawCentered(var1, var9, var11 + var10 * 0.5F, izx.SMALL.centerTop(var13 + 5.5F), iov.onAccent());
               uut.popAlpha();
            }
         }
      }
   }

   private void jco(DrawContext var1) {
      if (this.jcc != null) {
         float var2 = this.field_22787 != null ? Math.max(1, this.field_22787.method_22683().method_4495()) : 2.0F;
         int var3 = iov.accent(200);
         if (!Float.isNaN(this.jcg)) {
            uut.rect(var1, this.jcg - 0.5F / var2, 0.0F, 1.0F / var2 * 1.5F, this.field_22790, var3);
         }

         if (!Float.isNaN(this.jch)) {
            uut.rect(var1, 0.0F, this.jch - 0.5F / var2, this.field_22789, 1.0F / var2 * 1.5F, var3);
         }
      }
   }

   private void jcp(DrawContext var1, float var2, float var3) {
      this.jby.clear();
      float var4 = 9.0F;
      String var5 = wap.s(a.c(-1683618636, "Ӷ絚\uf798榍\ue21f撯\udef1圝쥙䏵"), a.c(1352254078, "왒뿶㔤ꭑ₌ꙅᱪ闥࿚蔃ˍ\uf8ad"));
      float var6 = 13.0F + izx.HEAD.width(var5);
      var4 += var6 + 10.0F;

      for (jcs var8 : izx.ELEMENTS) {
         float var9 = izx.TEXT.width(wap.t(var8.name)) + 17.0F;
         this.jby.add(new jbj(var8.name, null, var8.enabled::toggle, var8, var4, var9));
         var4 += var9 + 4.0F;
      }

      var4 += 6.0F;
      float var25 = izx.TEXT.width(wap.t(a.b("⪮匨\ud9ed䞊챌", 1273506553))) + 22.0F;
      this.jby.add(new jbj(a.c(298688786, "ꅅ\ud8c3分챡䞧"), vhz.RESET, izx::resetLayout, null, var4, var25));
      var4 += var25 + 4.0F;
      float var26 = izx.TEXT.width(wap.t(a.d("ⴅ咟\ude4d䀷", -1082537933, 2147345782))) + 22.0F;
      this.jby.add(new jbj(a.d("裶\uf16c箾\ue5c4", -1409287148, 777614498), vhz.CHECK, this::method_25419, null, var4, var26));
      var4 += var26 + 9.0F;
      this.jcb = var4;
      this.jbz = Math.round((this.field_22789 - this.jcb) * 0.5F);
      float var27 = (1.0F - vcq.outCubic(this.jbv.linear())) * 12.0F;
      this.jca = this.field_22790 - 22.0F - 12.0F + var27;
      var1.method_51448().pushMatrix();
      var1.method_51448().translate(this.jbz, this.jca);
      izx.panel(var1, this.jcb, 22.0F, Math.min(11.0F, iov.r(9.0F)));
      float var10 = 11.0F;
      vjf.draw(var1, vhz.MOVE, 13.5F, var10, 8.5F, iov.accent());
      izx.HEAD.draw(var1, var5, 22.0F, izx.HEAD.centerTop(var10), iov.text);
      uut.rect(var1, 9.0F + var6 + 4.0F, var10 - 5.0F, 1.0F, 10.0F, ujt.mulAlpha(iov.textMuted, 0.4F));
      float var11 = var2 - this.jbz;
      float var12 = var3 - this.jca;

      for (jbj var14 : this.jby) {
         float var15 = this.jbx
            .computeIfAbsent(var14.jbk, var0 -> new vcj(16.0F))
            .step(var11 >= var14.jbo && var11 < var14.jbo + var14.jbp && Math.abs(var12 - var10) < 7.0F, this.jcj);
         float var16 = Math.min(7.0F, iov.r(5.0F));
         float var17 = var10 - 7.0F;
         boolean var18 = var14.jbk.equals(a.d("\ue89e鄄ᯖ薬", 2448600, 49853446));
         if (var18) {
            uut.round(var1, var14.jbo, var17, var14.jbp, 14.0F, var16, ujt.lerp(iov.accent(), -1, 0.1F * var15));
            ukf.sheen(var1, var14.jbo, var17, var14.jbp, 14.0F, var16, 1.6F);
         } else {
            uut.round(var1, var14.jbo, var17, var14.jbp, 14.0F, var16, ujt.lerp(iov.field, iov.fieldHover, var15));
            ukf.rim(var1, var14.jbo, var17, var14.jbp, 14.0F, var16, iov.lightness(), 0.6F + 0.4F * var15);
         }

         int var19 = var18 ? iov.onAccent() : ujt.lerp(iov.textDim, iov.text, var15);
         if (var14.jbn != null) {
            boolean var20 = var14.jbn.enabled.get();
            uut.circle(var1, var14.jbo + 7.0F, var10, 2.0F, var20 ? iov.accent() : ujt.mulAlpha(iov.textMuted, 0.6F));
            izx.TEXT.draw(var1, wap.t(var14.jbk), var14.jbo + 12.0F, izx.TEXT.centerTop(var10), var20 ? iov.text : ujt.mulAlpha(var19, 0.7F));
         } else {
            vjf.draw(var1, var14.jbl, var14.jbo + 9.0F, var10, 7.0F, var19);
            izx.TEXT.draw(var1, wap.t(var14.jbk), var14.jbo + 15.0F, izx.TEXT.centerTop(var10), var19);
         }
      }

      var1.method_51448().popMatrix();
      String var28 = wap.s(
         a.c(
            1787483494,
            "핃계☄롳㏣딆ཎ蛰ᣢ鉑ᖛ\ueff9慫\uf8da爞\uf478丷솔嬜\udd43咻\u2ef6ꀑ㮄뷭㜯躚\u0096驻ᱹ韐椒\ue342競ﲥ皃짃䎲씀岜훛ꡤ∭ꗒ㼄넺ࢺ舖і龖ᇥ\ueb2d抝\ue4c5繱\uf020䬈쵎䜽\ude88倔⩟궻⟤뤢ブ諆స虪᧑錊ᔪ\uecef昚\uf848玺\uf5ea住욅壬퉷否⼂ꅄ㬳늃㐃蹒ư鯹ᵎ铌滵\ue03f箝﷏眂"
         ),
         a.b(
            "ꫵ퍖姼쟼䱑쪗瓑\udd14捿\uedda樏遴Ẩ蜚഻评㗧먶‒ꛔ⼣免\udffb䐬왯沊\uf50d缼\ue5bb揭\ue855ᚍ鲷Ħ蝵\u0d53눓㡢뻐❌괋펮秉\ude4c䂊컿眮麗篘\ue076湽钦ᵬ魅ƻ迨く뚞㱺ꔼ⮋嗮툻塦욮伛\uf54b玽ﷳ晘\uec8a櫸錥ᶎꏩࠬ詤ピ봙✋궻⯨偞\udef3䓳촯䮙\uf1be稯\ue07e晚\uef1cᕫ龻ѫ舸ࢂ뛽㼯ꖜ⟓谖퉱岡씋䍼즥瘟",
            1322299067
         )
      );
      izx.SMALL.drawCentered(var1, var28, this.field_22789 * 0.5F, izx.SMALL.centerTop(this.jca - 7.0F), ujt.withAlpha(16777215, 150));
   }

   private static String jcq(jcs var0) {
      String var1 = var0.ay == 0
         ? wap.s(a.c(-905561989, "㠌䆦쭪"), a.c(-1371962335, "聦捻獰\ued74暦\ue011"))
         : (
            var0.ay == 1
               ? wap.s(a.c(1623658217, "ຂ眷\ufde9掘\ue847滿"), a.c(-1254590040, "綞Ю諣ჴ魐ᷩꟅ⸶끪"))
               : wap.s(a.b("篓ɯ袧ᛖ鴚ᮩ", 273185719), a.b("붟쑒亄탺孙", -1327842853))
         );
      String var2 = var0.ax == 0
         ? wap.s(a.c(-1572612028, "\ud82cꆔ⭄딧"), a.c(-1557588188, "፠檫\ue076縀\uf5d5"))
         : (
            var0.ax == 1
               ? wap.s(a.b("ᬍ抺\ue862瘉\ufdd8签", -1856955544), a.c(-830881389, "얥박㋘꣏⍫ꗒ῾阍ࡑ"))
               : wap.s(a.b("ຯ眅\ufdd8掦\ue86d", 1476660952), a.d("႙楖\ue3fa緻\uf62e炝", 836564687, -1814175215))
         );
      return var0.ax == 1 && var0.ay == 1
         ? wap.s(a.c(-118446005, "\ua82e톙孁씪任졝"), a.d("肋胣ฮ鐹ᾝ餤⌈\uaafb㒧", -681228886, -2125154097))
         : var1 + a.d("\udd27", 324896593, 847862359) + var2;
   }

   private jcs jcr(double var1, double var3) {
      for (int var5 = izx.ELEMENTS.size() - 1; var5 >= 0; var5--) {
         jcs var6 = izx.ELEMENTS.get(var5);
         if (var6.w > 0.0F && var1 >= var6.x - 2.0F && var1 < var6.x + var6.w + 2.0F && var3 >= var6.y - 2.0F && var3 < var6.y + var6.h + 2.0F) {
            return var6;
         }
      }

      return null;
   }

   public boolean method_25402(Click var1, boolean var2) {
      double var3 = var1.comp_4798();
      double var5 = var1.comp_4799();
      if (var1.method_74245() == 1) {
         jcs var10 = this.jcr(var3, var5);
         if (var10 != null) {
            this.jcd = var10;
            izx.startResize(var10, (float)var3, (float)var5);
         }

         return true;
      } else if (var1.method_74245() != 0) {
         return true;
      } else if (var3 >= this.jbz && var3 < this.jbz + this.jcb && var5 >= this.jca && var5 < this.jca + 22.0F) {
         for (jbj var8 : this.jby) {
            if (var3 - this.jbz >= var8.jbo && var3 - this.jbz < var8.jbo + var8.jbp) {
               var8.jbm.run();
               return true;
            }
         }

         return true;
      } else {
         jcs var7 = this.jcr(var3, var5);
         if (var7 != null) {
            this.jcd = var7;
            if (var2) {
               var7.resetPosition();
               return true;
            }

            this.jcc = var7;
            this.jce = (float)var3 - var7.x;
            this.jcf = (float)var5 - var7.y;
            var7.push.set(0.0F);
         }

         return true;
      }
   }

   public boolean method_25403(Click var1, double var2, double var4) {
      boolean var6 = this.field_22787 != null
         && (InputUtil.method_15987(this.field_22787.method_22683(), 342) || InputUtil.method_15987(this.field_22787.method_22683(), 346));
      if (izx.resizing() != null) {
         izx.resize((float)var1.comp_4798(), (float)var1.comp_4799(), var6);
         return true;
      } else if (this.jcc == null) {
         return true;
      } else {
         float[] var7 = izx.drag(this.jcc, (float)var1.comp_4798() - this.jce, (float)var1.comp_4799() - this.jcf, this.field_22789, this.field_22790, var6);
         this.jcg = var7[0];
         this.jch = var7[1];
         return true;
      }
   }

   public boolean method_25406(Click var1) {
      izx.endResize();
      this.jcc = null;
      this.jcg = Float.NaN;
      this.jch = Float.NaN;
      return true;
   }

   public boolean method_25404(KeyInput var1) {
      int var2 = var1.comp_4795();
      if (var2 == 256) {
         this.method_25419();
         return true;
      } else {
         if (this.jcd != null && this.jcd.w > 0.0F) {
            float var3 = (var1.comp_4797() & 1) != 0 ? 5.0F : 1.0F;
            float var4 = var2 == 263 ? -var3 : (var2 == 262 ? var3 : 0.0F);
            float var5 = var2 == 265 ? -var3 : (var2 == 264 ? var3 : 0.0F);
            if (var4 != 0.0F || var5 != 0.0F) {
               this.jcd
                  .moveTo(
                     Math.max(0.0F, Math.min(this.field_22789 - this.jcd.w, this.jcd.x + var4)),
                     Math.max(0.0F, Math.min(this.field_22790 - this.jcd.h, this.jcd.y + var5)),
                     this.field_22789,
                     this.field_22790
                  );
               return true;
            }
         }

         return true;
      }
   }

   public void method_25419() {
      if (this.field_22787 != null) {
         this.field_22787.method_1507(new hlc());
      }
   }

   public void method_25432() {
      hyz.saveLater();
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return false;
   }
}
