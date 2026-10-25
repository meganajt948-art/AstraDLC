package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import org.joml.Matrix3x2fStack;

public final class kct extends Screen {
   private static final float kcu = 116.0F;
   private static final float kcv = 92.0F;
   private static final float kcw = 14.0F;
   private static final wam[] kcx = new wam[]{wam.RU, wam.EN};
   private final Screen kcy;
   private final kap kcz = new kap();
   private final kam kda = new kam();
   private final kbs kdb = kbs.selected();
   private final vcj[] kdc = new vcj[]{new vcj(13.0F), new vcj(13.0F)};
   private int kdd;
   private float kde = -1.0F;
   private float kdf = -1.0F;
   private int kdg = -1;
   private boolean kdh;
   private long kdi;
   private float kdj;
   private float kdk = 1.0F;
   private float kdl = 480.0F;
   private float kdm = 270.0F;

   public kct(Screen var1) {
      super(Text.method_43470(a.d("긆힅嵟쌡䣺칉琒", 1951642780, -2068833590)));
      this.kcy = var1;
      this.kdd = wap.chosen() && !wap.ru() ? 1 : 0;
      jzh.preload(this.kdb.key);
   }

   public void method_25420(DrawContext var1, int var2, int var3, float var4) {
   }

   public void method_25394(DrawContext var1, int var2, int var3, float var4) {
      uut.beginFrame();
      unf.observe(var1);
      long var5 = System.nanoTime();
      this.kdj = this.kdi == 0L ? 0.016666668F : Math.min(0.1F, (float)(var5 - this.kdi) / 1.0E9F);
      this.kdi = var5;
      float var7 = kap.clock();
      if (this.kde < 0.0F) {
         this.kde = var7;
      }

      float var8 = var7 - this.kde;
      float var9 = this.kdf >= 0.0F ? vcq.clamp01((var7 - this.kdf) / 0.42F) : 0.0F;
      this.kdk = kbp.scale(this.field_22789, this.field_22790);
      this.kdl = this.field_22789 / this.kdk;
      this.kdm = this.field_22790 / this.kdk;
      float var10 = var2 / this.kdk;
      float var11 = var3 / this.kdk;
      GpuTextureView var12 = unm.view();
      uut.rect(var1, 0.0F, 0.0F, this.field_22789, this.field_22790, -16315888);
      jza var13 = jzh.get(this.kdb.key);
      if (var13 != null) {
         this.kda.time = var7;
         this.kda.blur = 1.0F;
         this.kda.dim = 0.22F;
         this.kda.zoom = 1.06F;
         this.kda.tint = this.kdb.tint;
         this.kda.tintAmount = 0.3F;
         this.kcz.draw(var1, var13, this.kda, this.field_22789, this.field_22790, 1.0F, true);
      }

      Matrix3x2fStack var14 = var1.method_51448();
      var14.pushMatrix();
      var14.scale(this.kdk, this.kdk);
      vdn.setRenderScaleStepped(this.kdk);
      uut.pushAlpha(1.0F - vcq.inCubic(var9));

      try {
         float var15 = vcq.outCubic(vcq.clamp01((var8 - 0.05F) / 0.6F));
         uut.pushAlpha(var15);
         float var16 = this.kdm * 0.5F - 46.0F - 38.0F + (1.0F - var15) * 6.0F;
         vdn var17 = veo.semibold(12.0F);
         var17.drawCentered(var1, a.c(662017462, "闡\uec7b暯\uf8de猕\uf5b2侤옌塅틮唺꼙ↂ렾㉢뒚\u0ec7脂᮷鷤"), this.kdl * 0.5F, var17.centerTop(var16), kdu(16777215, 0.97F));
         vdn var18 = veo.medium(7.6F);
         var18.drawCentered(var1, a.c(237958896, "\uf2ef謇Ʈ鿛ᑹ銰⢙ꄟ㭕떋㈠젭䚋"), this.kdl * 0.5F, var18.centerTop(var16 + 15.0F), kdu(14149365, 0.72F));
         uut.popAlpha();

         for (int var19 = 0; var19 < kcx.length; var19++) {
            this.kdr(var1, var12, var19, var10, var11, var8, var9);
         }

         vdn var25 = veo.medium(6.2F);
         uut.pushAlpha(vcq.clamp01((var8 - 0.7F) / 0.6F));
         var25.drawCentered(
            var1,
            a.c(
               738804110,
               "䗌㱠뚺⣃ꌑ◚龇ሚ衚˪蕅罈\uf19d氪\ue663撈\udec0儒쮠䷴쐉멈゚꼪ⵆꞟḩ遷\u0af2財ݭ料短\uea0e桏\ue699失팺円찦䙰㢉늩ㅶꮡ╇鰃ᚲ邞\u0b64蔞翀\uf67e瀭\uea9b撃\udf21妤펛䩇쓥뺥㥁던ⶍꑨḧ飛ዉ贿ߧ膕硇\uf2f1泧\ue754愔\udba4剷찝䛓샌묶㗠꿙♜ꃳ\u1aaf锕༇覿c塚瓔\uef33椯\ue3e8嶒푚"
            ),
            this.kdl * 0.5F,
            var25.centerTop(this.kdm * 0.5F + 46.0F + 24.0F),
            kdu(16777215, 0.45F)
         );
         uut.popAlpha();
      } finally {
         uut.popAlpha();
         uut.additive(false);
         var14.popMatrix();
         vdn.setRenderScale(1.0F);
      }

      if (var9 >= 1.0F && !this.kdh) {
         this.kdh = true;
         MinecraftClient var23 = this.field_22787;
         Object var24 = var23.field_1687 == null ? jte.afterWelcome() : this.kcy;
         var23.method_63588(() -> var23.method_1507(var24));
      }
   }

   private float kdp(int var1) {
      return this.kdl * 0.5F - 116.0F - 7.0F + var1 * 130.0F;
   }

   private float kdq() {
      return this.kdm * 0.5F - 46.0F;
   }

   private void kdr(DrawContext var1, GpuTextureView var2, int var3, float var4, float var5, float var6, float var7) {
      float var8 = vcq.clamp01((var6 - 0.2F - var3 * 0.1F) / 0.6F);
      if (!(var8 <= 0.0F)) {
         float var9 = vcq.outBack(var8);
         float var10 = this.kdp(var3);
         float var11 = this.kdq();
         boolean var12 = this.kdf < 0.0F && var8 >= 1.0F && kdt(var4, var5, var10, var11, 116.0F, 92.0F);
         if (var12) {
            this.kdd = var3;
         }

         boolean var13 = var12 || this.kdd == var3 && !kdt(var4, var5, this.kdp(1 - var3), var11, 116.0F, 92.0F) || this.kdg == var3;
         float var14 = this.kdc[var3].step(var13, this.kdj);
         float var15 = this.kdg == var3 ? vcq.clamp01(var7 * 2.0F) : 0.0F;
         float var16 = var11 + (1.0F - var9) * 18.0F - 3.0F * var14;
         float var17 = (0.92F + 0.08F * var9) * (1.0F + 0.03F * var15) * (this.kdg >= 0 && this.kdg != var3 ? 1.0F - 0.05F * var7 : 1.0F);
         float var18 = 13.0F;
         int var19 = this.kdb.accent;
         Matrix3x2fStack var20 = var1.method_51448();
         var20.pushMatrix();
         var20.translate(var10 + 58.0F, var16 + 46.0F);
         var20.scale(var17, var17);
         var20.translate(-58.0F, -46.0F);
         uut.pushAlpha(vcq.clamp01(var8 * 1.5F));

         try {
            uut.shadow(var1, 0.0F, 5.0F, 116.0F, 92.0F, var18, 22.0F, kdu(0, 0.35F + 0.1F * var14));
            if (var2 != null && var14 > 0.01F) {
               uut.additive(true);
               uut.image(var1, var2, -34.800003F, -27.6F, 185.6F, 147.2F, 0.0F, kdu(var19, 0.16F * var14));
               uut.additive(false);
            }

            this.kcz.frosted(var1, 0.0F, 0.0F, 116.0F, 92.0F, var18, var10, var16, this.kdl, this.kdm, kdu(16777215, 1.0F));
            uut.round(var1, 0.0F, 0.0F, 116.0F, 92.0F, var18, kdu(658966, 0.3F - 0.08F * var14));
            uut.round(var1, 0.0F, 0.0F, 116.0F, 92.0F, var18, kdu(16777215, 0.04F + 0.07F * var14));
            uut.gradient(
               var1,
               0.0F,
               0.0F,
               116.0F,
               41.399998F,
               var18,
               var18,
               0.0F,
               0.0F,
               kdu(16777215, 0.09F),
               kdu(16777215, 0.09F),
               kdu(16777215, 0.0F),
               kdu(16777215, 0.0F)
            );
            uut.outlineGradientV(
               var1,
               0.0F,
               0.0F,
               116.0F,
               92.0F,
               var18,
               0.8F,
               kdu(kce.mix(16777215, var19, var14), 0.34F + 0.45F * var14),
               kdu(kce.mix(16777215, var19, var14), 0.08F + 0.3F * var14)
            );
            wam var21 = kcx[var3];
            boolean var22 = var21 == wam.RU;
            var20.pushMatrix();
            var20.translate(43.0F, 16.0F);
            var20.scale(1.5F, 1.5F);
            ida.flag(var1, var21, 0.0F, 0.0F);
            var20.popMatrix();
            vdn var23 = veo.semibold(10.5F);
            var23.drawCentered(
               var1, var22 ? a.b("栳ᇡ鬰Ձ軭࡞눌", 488401940) : a.b("\ueabc錦᧼螆\u0c54諿シ", -1369773314), 58.0F, var23.centerTop(62.0F), kdu(16777215, 0.97F)
            );
            vdn var24 = veo.medium(6.6F);
            var24.drawCentered(
               var1,
               var22 ? a.b("ቩ毟", -1375989191) : a.c(-568805827, "뙺쿀"),
               58.0F,
               var24.centerTop(75.0F),
               kdu(kce.mix(13161698, var19, var14), 0.7F + 0.3F * var14)
            );
         } finally {
            uut.popAlpha();
            var20.popMatrix();
         }
      }
   }

   private void kds(int var1) {
      if (!(this.kdf >= 0.0F)) {
         this.kdg = var1;
         wap.set(kcx[var1]);
         hyz.saveLater();
         this.kdf = kap.clock();
      }
   }

   public boolean method_25402(Click var1, boolean var2) {
      if (var1.method_74245() != 0) {
         return true;
      } else {
         float var3 = (float)var1.comp_4798() / this.kdk;
         float var4 = (float)var1.comp_4799() / this.kdk;

         for (int var5 = 0; var5 < kcx.length; var5++) {
            if (kdt(var3, var4, this.kdp(var5), this.kdq(), 116.0F, 92.0F)) {
               this.kds(var5);
            }
         }

         return true;
      }
   }

   public boolean method_25404(KeyInput var1) {
      switch (var1.comp_4795()) {
         case 32:
         case 257:
         case 335:
            this.kds(this.kdd);
            break;
         case 258:
         case 262:
            this.kdd = this.kdd == 0 ? 1 : 0;
            break;
         case 263:
            this.kdd = 0;
      }

      return true;
   }

   public boolean method_25422() {
      return false;
   }

   public boolean method_25421() {
      return false;
   }

   public void method_25432() {
      this.kcz.close();
      vdn.setRenderScale(1.0F);
   }

   private static boolean kdt(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var1 >= var3 && var0 < var2 + var4 && var1 < var3 + var5;
   }

   private static int kdu(int var0, float var1) {
      return kce.rgba(var0, var1);
   }
}
