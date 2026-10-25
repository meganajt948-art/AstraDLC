package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.net.URI;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerWarningScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.joml.Matrix3x2fStack;

public final class jte extends Screen {
   public static final String TELEGRAM = new String(
      new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 't', '.', 'm', 'e', '/', 'F', 'l', 'o', 'w', 'w', 'C', 'l', 'i', 'e', 'n', 't'}
   );
   public static final String DISCORD = a.c(767143374, "궺퐗廄삱䭥춝矛︪怾\uea82测霪᧱聝ਘ貣㚥르⎏ꖖⰲ嘱\ud889䍬씧俜\uf64d砫");
   static final float jtf = 138.0F;
   static final float jtg = 25.0F;
   static final float jth = 7.0F;
   static final float jti = 0.24F;
   static final float jtj = 228.0F;
   static final float jtk = 118.0F;
   static final float jtl = 21.0F;
   static final float jtm = 6.0F;
   static final float jtn = 12.0F;
   static final float jto = 74.0F;
   static final float jtp = 42.0F;
   static final float jtq = 254.0F;
   static final int jtr = 4;
   static final int jts = 4;
   final kap jtt = new kap();
   final kap jtu = new kap();
   final kam jtv = new kam();
   final kam jtw = new kam();
   final kce jtx = new kce(34.0F);
   final vcj[] jty = new vcj[4];
   final vcj[] jtz = new vcj[4];
   final vcj[] jua = new vcj[kbs.values().length];
   final vcj jub = new vcj(11.0F);
   final vcj juc = new vcj(10.0F);
   final vcj[] jud = new vcj[]{new vcj(14.0F), new vcj(14.0F)};
   final float[] jue = new float[]{-10.0F, -10.0F, -10.0F, -10.0F};
   final float[] juf = new float[kbs.values().length];
   kbs jug = kbs.selected();
   jsi juh = new jsi(this.jug.particles, 7L);
   String jui;
   jsi juj;
   float juk = -10.0F;
   float jul = 1.0F;
   boolean jum;
   float jun = -1.0F;
   float juo = -1.0F;
   boolean jup;
   boolean juq;
   boolean jur;
   int jus = -1;
   float jut;
   float juu;
   float juv = -10.0F;
   float juw;
   int jux = -1;
   float juy = -1.0F;
   float juz;
   float jva;
   long jvb;
   float jvc;
   float jvd = 1.0F;
   float jve = 480.0F;
   float jvf = 270.0F;
   float jvg = -1.0F;
   int jvh = -1;
   int jvi = -1;
   final vcj jvj = new vcj(9.0F, kbm.TITLE.get() && !kbs.selected().logo() ? 1.0F : 0.0F);
   final vcj jvk = new vcj(6.0F, kbs.selected().logo() ? 1.0F : 0.0F);
   final vcj jvl = new vcj(6.0F, kbs.selected().light ? 1.0F : 0.0F);
   final vcj jvm = new vcj(6.0F, kbm.PARTICLES.get() ? 1.0F : 0.0F);
   final vcj[] jvn = new vcj[9];
   final vcj[] jvo = new vcj[9];
   int jvp = -1;
   float jvq = -1.0F;
   static final float jvr = 0.95F;
   static final float jvs = 0.56F;
   static final float jvt = 24.0F;
   static final float jvu = 34.0F;
   static final int jvv = 9;
   static final float jvw = 19.0F;
   static final float jvx = 132.0F;
   static final float jvy = 13.0F;
   static final float jvz = 20.0F;
   static final int jwa = 3;

   public jte() {
      super(Text.literal(vvi.get()));

      for (int var1 = 0; var1 < 4; var1++) {
         this.jty[var1] = new vcj(14.0F);
      }

      for (int var2 = 0; var2 < 4; var2++) {
         this.jtz[var2] = new vcj(14.0F);
      }

      for (int var3 = 0; var3 < 9; var3++) {
         this.jvn[var3] = new vcj(14.0F);
         this.jvo[var3] = new vcj(14.0F, jxs(var3));
      }

      for (int var4 = 0; var4 < this.jua.length; var4++) {
         this.jua[var4] = new vcj(14.0F);
         this.juf[var4] = -10.0F;
      }

      jzh.preload(this.jug.key);
   }

   public static jte afterWelcome() {
      jte var0 = new jte();
      var0.jum = true;
      return var0;
   }

   @Override
   protected void init() {
      if (dry.armed() && this.client != null) {
         this.client.setScreen(new TitleScreen());
      } else {
         if (this.jup) {
            this.jup = false;
            this.juo = kap.clock() - 0.3F;
            this.jux = -1;
            this.jus = -1;
         }
      }
   }

   @Override
   public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      uut.beginFrame();
      unf.observe(context);
      long var5 = System.nanoTime();
      if (this.width >= 64 && this.height >= 64) {
         if (this.width != this.jvh || this.height != this.jvi) {
            this.jvh = this.width;
            this.jvi = this.height;
            this.jvg = -1.0F;
         }

         this.jvc = this.jvb == 0L ? 0.016666668F : Math.min(0.1F, (float)(var5 - this.jvb) / 1.0E9F);
         this.jvb = var5;
         float var7 = kap.clock();
         if (this.jun < 0.0F) {
            this.jun = var7;
            this.juo = var7;
            this.jvq = var7;
         }

         float var8 = var7 - this.jun;
         float var9 = var7 - this.jvq;
         this.jvd = kbp.scale(this.width, this.height);
         this.jve = this.width / this.jvd;
         this.jvf = this.height / this.jvd;
         float var10 = mouseX / this.jvd;
         float var11 = mouseY / this.jvd;
         float var12 = 1.0F - (float)Math.exp(-this.jvc * 2.2F);
         if (!kbm.PARALLAX.get()) {
            this.juz = this.juz - this.juz * var12;
            this.jva = this.jva - this.jva * var12;
         } else if (mouseX >= 0 && mouseY >= 0 && mouseX <= this.width && mouseY <= this.height) {
            this.juz = this.juz + ((float)mouseX / this.width - 0.5F - this.juz) * var12;
            this.jva = this.jva + ((float)mouseY / this.height - 0.5F - this.jva) * var12;
         }

         float var13 = this.jwl();
         this.jvg = this.jvg < 0.0F ? var13 : this.jvg + (var13 - this.jvg) * (1.0F - (float)Math.exp(-this.jvc * 9.0F));
         float var14 = this.jvj.step(kbm.TITLE.get() && !this.jug.logo(), this.jvc);
         this.jvk.step(this.jug.logo(), this.jvc);
         this.jvl.step(this.jug.light, this.jvc);
         float var15 = this.jvm.step(kbm.PARTICLES.get(), this.jvc);
         GpuTextureView var16 = unm.view();
         this.jwe(context, var7, var8);
         Matrix3x2fStack var17 = context.getMatrices();
         var17.pushMatrix();
         var17.scale(this.jvd, this.jvd);
         vdn.setRenderScaleStepped(this.jvd);

         try {
            this.jwf(context);
            float var18 = this.jwd();
            if (this.juj != null && var18 > 0.0F) {
               this.juj.draw(context, var16, this.jve, this.jvf, var7, false, this.juz, this.jva, var18 * var15);
            }

            this.juh.draw(context, var16, this.jve, this.jvf, var7, false, this.juz, this.jva, vcq.clamp01(var8 / 1.2F) * (1.0F - var18) * var15);
            float var19 = this.jvd * MinecraftClient.getInstance().getWindow().getScaleFactor();
            float var20 = vcq.clamp01((var9 - 0.1F) / 1.25F);
            if (var14 > 0.01F) {
               float var21 = this.jtx.width(var19) * 0.5F + 14.0F;
               float var22 = Math.max(var21, Math.min(this.jve - var21, this.jvg + 69.0F));
               uut.pushAlpha(var14);
               this.jtx
                  .draw(
                     context,
                     var16,
                     var22 - this.juz * 5.0F,
                     this.jvf * 0.5F - 75.0F - this.jva * 3.0F - (1.0F - var14) * 8.0F,
                     1.0F,
                     var19,
                     var7,
                     var20,
                     this.juz * 2.0F,
                     this.jva * 2.0F,
                     this.jug.accent
                  );
               uut.popAlpha();
            }

            boolean var33 = this.juq && this.jxb(var10, var11);

            for (int var34 = 0; var34 < 4; var34++) {
               this.jwm(context, var16, var34, var10, var11, var7, var33);
            }

            if (this.juj != null && var18 > 0.0F) {
               this.juj.draw(context, var16, this.jve, this.jvf, var7, true, this.juz, this.jva, var18 * var15);
            }

            this.juh.draw(context, var16, this.jve, this.jvf, var7, true, this.juz, this.jva, vcq.clamp01(var8 / 1.2F) * (1.0F - var18) * var15);
            float var35 = vcq.outCubic(vcq.clamp01((var9 - 0.6F) / 0.7F));
            uut.pushAlpha(var35);

            try {
               for (int var23 = 0; var23 < 4; var23++) {
                  this.jwo(context, var16, var23, var10, var11, var35);
               }

               this.jwp(context);
            } finally {
               uut.popAlpha();
            }

            this.jxd(context, var10, var11);
            this.jxk(context, var16, var10, var11, var7);
         } finally {
            uut.additive(false);
            var17.popMatrix();
            vdn.setRenderScale(1.0F);
         }

         if (this.jux >= 0 && var7 - this.juv >= 0.24F) {
            int var32 = this.jux;
            this.jux = -1;
            this.jyd(var32);
         }

         if (this.juy >= 0.0F && var7 >= this.juy) {
            this.juy = -1.0F;
            this.client.scheduleStop();
         }
      } else {
         this.jvb = 0L;
      }
   }

   float jwd() {
      if (this.jui == null) {
         return 0.0F;
      } else {
         float var1 = 1.0F - vcq.inOutCubic((kap.clock() - this.juk) / this.jul);
         if (var1 <= 0.0F) {
            this.jui = null;
            this.juj = null;
            this.jtu.close();
            jzh.releaseExcept(this.jug.key);
            return 0.0F;
         } else {
            return var1;
         }
      }
   }

   void jwe(DrawContext var1, float var2, float var3) {
      jza var4 = jzh.get(this.jug.key);
      if (var4 == null && this.jui != null) {
         this.juk = var2;
      }

      float var5 = this.jwd();
      uut.rect(var1, 0.0F, 0.0F, this.width, this.height, -16118250);
      float var6 = this.jum ? vcq.inOutCubic(vcq.clamp01((var3 - 0.1F) / 1.3F)) : 1.0F;
      if (var4 != null) {
         this.jtv.time = var2;
         this.jtv.zoom = 1.05F + 0.01F * (1.0F - var6);
         this.jtv.panX = -this.juz * 0.014F * var6;
         this.jtv.panY = -this.jva * 0.01F * var6;
         this.jtv.blur = 1.0F - var6;
         this.jtv.dim = 0.04F + 0.18F * (1.0F - var6) + (float)kbm.DIM.get();
         this.jtv.tint = this.jug.tint;
         this.jtv.tintAmount = 0.3F;
         this.jtv.fall = null;
         this.jtv.pool = null;
         this.jwh(this.jtv, var6);
         this.jtt.draw(var1, var4, this.jtv, this.width, this.height, 1.0F, true);
      }

      if (var5 > 0.0F) {
         jza var7 = jzh.get(this.jui);
         if (var7 != null) {
            this.jtw.time = var2;
            this.jtw.panX = this.jtv.panX;
            this.jtw.panY = this.jtv.panY;
            kbs var8 = jxn(this.jui);
            this.jtw.blur = 0.0F;
            this.jtw.dim = 0.04F + (float)kbm.DIM.get();
            this.jtw.zoom = 1.05F;
            this.jtw.tint = var8.tint;
            this.jtw.tintAmount = 0.3F;
            this.jtw.fall = null;
            this.jtw.pool = null;
            this.jwh(this.jtw, 1.0F);
            this.jtu.draw(var1, var7, this.jtw, this.width, this.height, var5, false);
         }
      }
   }

   void jwf(DrawContext var1) {
      float var2 = 1.0F - this.jvl.get();
      if (!(var2 <= 0.01F)) {
         uut.gradientV(var1, 0.0F, 0.0F, this.jve, 120.0F, 0.0F, jyh(329484, 0.42F * var2), jyh(329484, 0.0F));
         uut.gradientV(var1, 0.0F, this.jvf - 90.0F, this.jve, 90.0F, 0.0F, jyh(329484, 0.0F), jyh(329484, 0.5F * var2));
         uut.rect(var1, 0.0F, 0.0F, this.jve, this.jvf, jyh(329484, 0.08F * var2));
      }
   }

   float jwg() {
      float var1 = Math.max(1.0F, this.jve * 0.5F - 34.0F - 69.0F);
      return Math.max(-1.0F, Math.min(1.0F, (this.jwk() + 69.0F - this.jve * 0.5F) / var1));
   }

   void jwh(kam var1, float var2) {
      float var3 = this.jwg();
      float var4 = Math.abs(var3);
      float var5 = this.jwk();
      float var6 = var3 <= 0.0F ? (var5 + 138.0F + this.jve) * 0.5F : var5 * 0.5F;
      float var7 = 0.56F + 0.39F * var4;
      float var8 = 0.435F * var7 * this.jvf;
      float var9 = this.jwi() - 14.0F - var8 * 0.5F;
      float var10 = this.jve * 0.5F + (var6 - this.jve * 0.5F) * var4 - this.juz * 6.0F;
      float var11 = var9 + (this.jvf * 0.5F - var9) * var4 - this.jva * 4.0F;
      var1.logoF(0.5F + (var10 / this.jve - 0.5F) * var2, 0.5F + (var11 / this.jvf - 0.5F) * var2, 0.92F + (var7 - 0.92F) * var2, this.jve / this.jvf);
   }

   float jwi() {
      float var1 = 1.0F - Math.abs(this.jwg());
      return this.jvf * 0.5F - 25.6F - 34.9F * (1.0F - this.jvj.get()) + 56.9F * this.jvk.get() * var1;
   }

   float jwj(int var1) {
      return this.jwi() + var1 * 32.0F;
   }

   float jwk() {
      return this.jvg < 0.0F ? this.jwl() : this.jvg;
   }

   float jwl() {
            if (java.util.Objects.equals(kbm.POSITION.get(), a.c(51235075, "쥋냓㨃ꑠ"))) {
         return 34.0F;
      }
      else if (java.util.Objects.equals(kbm.POSITION.get(), a.b("\ue4dc鵖ឋ觵Ⱦ", -655104885))) {
         return this.jve - 34.0F - 138.0F;
      }
      else {
         return (this.jve - 138.0F) * 0.5F;
      }
   }

   void jwm(DrawContext var1, GpuTextureView var2, int var3, float var4, float var5, float var6, boolean var7) {
      float var8 = vcq.clamp01((var6 - this.juo - 0.45F - var3 * 0.1F) / 0.6F);
      if (!(var8 <= 0.0F)) {
         float var9 = vcq.outBack(var8);
         float var10 = this.jwk();
         float var11 = this.jux >= 0 ? vcq.outCubic(vcq.clamp01((var6 - this.juv) / 0.24F)) : 0.0F;
         boolean var12 = this.jux == var3;
         float var13 = this.jwj(var3) + (1.0F - var9) * 16.0F + (var12 ? 0.0F : var11 * (var3 < this.jux ? -5.0F : 5.0F));
         boolean var14 = !var7 && !this.jur && this.jux < 0 && var8 >= 1.0F && jyf(var4, var5, var10, this.jwj(var3), 138.0F, 25.0F);
         float var15 = this.jty[var3].step(var14 || var12, this.jvc);
         float var16 = this.jus == var3 ? vcq.clamp01((var6 - this.juv) / 0.5F) : 1.0F;
         float var17 = var16 < 1.0F ? (float)(Math.sin(Math.PI * vcq.clamp01(var16 * 2.4F)) * (1.0F - var16 * 0.6F)) : 0.0F;
         float var18 = (0.9F + 0.1F * var9) * (1.0F + 0.025F * var15 - 0.06F * var17) * (var12 ? 1.0F : 1.0F - 0.04F * var11);
         float var19 = Math.max(1.5F, 12.5F * (float)kbm.ROUND.get());
         int var20 = this.jug.accent;
         String var21 = kbm.BUTTONS.get();
         boolean var22 = var21.equals(a.c(-1949826894, "ú祱\uf3a3淊\ue618悮\udaf6"));
         float var23 = (float)kbm.BLUR.get();
         float var24 = var21.equals(a.b("ﶅ萑໑邹", -2113274427)) ? 0.0F : this.jvl.get();
         int var25 = jyg(16777215, 1842982, var24);
         Matrix3x2fStack var26 = var1.getMatrices();
         var26.pushMatrix();
         var26.translate(var10 + 69.0F, var13 + 12.5F);
         var26.scale(var18, var18);
         var26.translate(-69.0F, -12.5F);
         uut.pushAlpha(vcq.clamp01(var8 * 1.6F) * (var12 ? 1.0F : 1.0F - 0.55F * var11));

         try {
            if (var16 < 1.0F) {
               float var27 = 9.0F * vcq.outCubic(var16);
               uut.outline(var1, -var27, -var27, 138.0F + 2.0F * var27, 25.0F + 2.0F * var27, var19 + var27, 1.0F, jyh(var20, 0.7F * (1.0F - var16)));
            }

            uut.shadow(var1, 0.0F, 3.0F, 138.0F, 25.0F, var19, 14.0F, jyh(0, ((var22 ? 0.1F : 0.28F) + 0.1F * var15) * (1.0F - 0.65F * var24)));
            if (var2 != null && var15 > 0.01F) {
               uut.additive(true);
               uut.image(var1, var2, -20.7F, -30.000002F, 179.4F, 85.0F, 0.0F, jyh(var20, 0.13F * var15));
               uut.additive(false);
            }

            if (var23 > 0.01F) {
               this.jtt.frosted(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, var10, var13, this.jve, this.jvf, jyh(16777215, var23));
            }

                        if (java.util.Objects.equals(var21, a.b("㺷䜣췣压", 1555906295))) {
               uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(658708, 0.8F - 0.12F * var15));
                                 uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(var20, 0.04F + 0.12F * var15));
            }
            else if (java.util.Objects.equals(var21, a.b("睨\u0efc萡\u1a5f醔", -1849133279))) {
               uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(16777215, 0.2F + 0.5F * var24 + 0.08F * var15));
                                 uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(var20, 0.06F + 0.12F * var15));
            }
            else if (java.util.Objects.equals(var21, a.d("훼꽷▥믌〞뚨\u0cf0", -209606814, -478514730))) {
               uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(jyg(790552, 16777215, var24), 0.1F + 0.12F * var15));
            }
            else {
               uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(jyg(790552, 16777215, var24), 0.34F - 0.12F * var15 + (0.24F + 0.2F * var15) * var24));
                                 uut.round(var1, 0.0F, 0.0F, 138.0F, 25.0F, var19, jyh(jyg(16777215, var20, 0.4F), 0.05F + 0.1F * var15));
                                 uut.gradient(
                                    var1,
                                    0.0F,
                                    0.0F,
                                    138.0F,
                                    12.5F,
                                    var19,
                                    var19,
                                    0.0F,
                                    0.0F,
                                    jyh(16777215, 0.09F),
                                    jyh(16777215, 0.09F),
                                    jyh(16777215, 0.0F),
                                    jyh(16777215, 0.0F)
                                 );
            }

            if (var16 < 1.0F) {
               float var35 = 138.0F * vcq.outCubic(var16);
               float var37 = Math.max(0.0F, this.juw - var35);
               float var29 = Math.min(138.0F, this.juw + var35);
               uut.round(var1, var37, 0.0F, var29 - var37, 25.0F, var19, jyh(jyg(16777215, var20, 0.5F), 0.3F * (1.0F - var16)));
            }

            uut.outlineGradientV(
               var1,
               0.0F,
               0.0F,
               138.0F,
               25.0F,
               var19,
               var22 ? 1.0F : 0.7F,
               jyh(jyg(var25, var20, var15), ((var22 ? 0.62F : 0.34F) + 0.35F * var15) * (1.0F - 0.55F * var24)),
               jyh(jyg(var25, var20, var15), ((var22 ? 0.42F : 0.08F) + 0.3F * var15) * (1.0F + 0.4F * var24))
            );

            vhz var36 = switch (var3) {
               case 0 -> vhz.PLAYER;
               case 1 -> vhz.FRIENDS;
               case 2 -> vhz.ACCOUNTS;
               default -> vhz.SETTINGS;
            };

            String var38 = switch (var3) {
               case 0 -> wap.s(a.c(518566841, "돦쩭䂹\udec1唝펥槣\ue00e繜\uf4f5猺襜"), a.b("ᑏ淔\ue70b祿\uf2ab瑣칊䞶\ud996坈풃\u2ef9ꁝ㦜", -1282404257));
               case 1 -> wap.s(a.d("摞ᷗ霝ॴ芾Ж빙㞥ꧢ⍏ꒋ", 44600145, -652480695), a.d("螭︈璬\ueaaa慺\ue7c9工큻䨼삆䜦봧", -1912415222, -1087217782));
               case 2 -> wap.s(a.c(-1828125110, "\u0600羜\uf557歲\ue0e8晕\udc09嗷쮮䄝웙"), a.c(1429706336, "鉽\uebe7慃＼炉\uf224䡾솇忐할励ꣃ♡"));
               default -> wap.s(a.d("年耉ો钺ὰ駆⎜꩹", -1976864895, -1582131628), a.b("\ue543鳟ᙽ蠏Ϛ蔕㽁뚳⣮", -1612062377));
            };
            int var39 = jyg(jyg(15922682, 16777215, var15), 1447965, var24);
            vjf.draw(var1, var36, 16.0F + 2.0F * var15, 12.5F, 10.5F, jyh(jyg(jyg(14541806, 3817290, var24), var20, var15), 0.9F + 0.1F * var15));
            vdn var30 = veo.semibold(8.4F);
            var30.drawCentered(var1, var38, 69.0F + 3.0F * var15, var30.centerTop(12.5F), jyh(var39, 1.0F));
            if (var15 > 0.01F) {
               uut.pushAlpha(var15);
               vjf.draw(var1, vhz.CHEVRON_RIGHT, 122.0F - 4.0F * (1.0F - var15), 12.5F, 8.0F, jyh(var20, 1.0F));
               uut.popAlpha();
            }
         } finally {
            uut.popAlpha();
            var26.popMatrix();
         }
      }
   }

   float jwn(int var1) {
      return this.jve - 12.0F - 21.0F - (3 - var1) * 27.0F - (var1 < 2 ? 5.0F : 0.0F);
   }

   void jwo(DrawContext var1, GpuTextureView var2, int var3, float var4, float var5, float var6) {
      float var7 = this.jwn(var3);
      float var8 = 12.0F + (1.0F - var6) * -8.0F;
      boolean var9 = !this.jur && jyf(var4, var5, var7, 12.0F, 21.0F, 21.0F) && (!this.juq || var3 == 2 || !this.jxb(var4, var5));
      float var10 = this.jtz[var3].step(var9 || var3 == 2 && this.juq, this.jvc);
      float var11 = vcq.clamp01((kap.clock() - this.jue[var3]) / 0.5F);
      float var12 = var11 < 1.0F ? (float)Math.sin(Math.PI * vcq.clamp01(var11 * 2.4F)) * (1.0F - var11 * 0.5F) : 0.0F;

      int var13 = switch (var3) {
         case 0 -> 2796526;
         case 1 -> 8227839;
         case 2 -> this.jug.accent;
         default -> 16739179;
      };
      float var14 = 10.5F;
      float var15 = var7 + var14;
      float var16 = var8 + var14;
      Matrix3x2fStack var17 = var1.getMatrices();
      var17.pushMatrix();
      var17.translate(var15, var16);
      float var18 = 1.0F + 0.08F * var10 - 0.14F * var12;
      var17.scale(var18, var18);

      try {
         if (var11 < 1.0F) {
            float var19 = 8.0F * vcq.outCubic(var11);
            uut.circleOutline(var1, 0.0F, 0.0F, var14 + var19, 1.0F, jyh(var13, 0.75F * (1.0F - var11)));
         }

         float var26 = this.jvl.get();
         int var20 = jyg(16777215, 1842982, var26);
         uut.shadow(var1, -var14, -var14 + 2.0F, 21.0F, 21.0F, var14, 10.0F, jyh(0, 0.3F - 0.2F * var26));
         if (var2 != null && var10 > 0.01F) {
            uut.additive(true);
            uut.sprite(var1, var2, 0.0F, 0.0F, 54.6F, jyh(var13, 0.22F * var10));
            uut.additive(false);
         }

         this.jtt.frosted(var1, -var14, -var14, 21.0F, 21.0F, var14, var7, var8, this.jve, this.jvf, jyh(16777215, 1.0F));
         var17.pushMatrix();
         var17.translate(-var14, -var14);
         uut.round(var1, 0.0F, 0.0F, 21.0F, 21.0F, var14, jyh(jyg(790552, 16777215, var26), 0.36F - 0.1F * var10 + 0.26F * var26));
         uut.round(var1, 0.0F, 0.0F, 21.0F, 21.0F, var14, jyh(var13, 0.16F * var10));
         uut.outlineGradientV(
            var1,
            0.0F,
            0.0F,
            21.0F,
            21.0F,
            var14,
            0.7F,
            jyh(jyg(var20, var13, var10), (0.32F + 0.4F * var10) * (1.0F - 0.55F * var26)),
            jyh(jyg(var20, var13, var10), (0.08F + 0.25F * var10) * (1.0F + 0.5F * var26))
         );
         var17.popMatrix();

         vhz var21 = switch (var3) {
            case 0 -> vhz.TELEGRAM;
            case 1 -> vhz.DISCORD;
            case 2 -> vhz.IMAGE;
            default -> vhz.POWER;
         };
         float var22 = var3 < 2 ? 11.5F : 10.5F;
         vjf.draw(
            var1,
            var21,
            var3 == 0 ? -0.6F : 0.0F,
            0.0F,
            var22,
            jyh(jyg(jyg(15331062, 2764342, var26), jyg(var13, jyg(16777215, 0, var26), 0.25F), var10), 1.0F)
         );
      } finally {
         var17.popMatrix();
      }

      if (var10 > 0.01F && (var3 != 2 || !this.juq)) {
         String var27 = switch (var3) {
            case 0 -> a.c(-1299448908, "ﯨ艨ࢲ雊ᴟ鮻⇻꠆");
            case 1 -> a.b("윉뺕㑜\uaa3d⇦Ꝋᴏ", 283821898);
            case 2 -> wap.s(a.d("\uef50雂ᰓ艪\u09b1輕㕛벰⋴ꡏ", 1450829189, 293014173), a.b("\ufaea荁\u0991鏽ᰶ骎⃕\ua957", 1542192838));
            default -> wap.s(a.b("䅴㣡눮ⱂ", -1229831903), a.d("∜寴텕佟쓲", 1269071330, -644064279));
         };
         vdn var28 = veo.medium(6.4F);
         float var29 = var28.width(var27) + 12.0F;
         float var30 = Math.min(this.jve - 12.0F - var29, var15 - var29 * 0.5F);
         float var23 = 38.0F + (1.0F - var10) * -3.0F;
         uut.pushAlpha(var10);
         uut.round(var1, var30, var23, var29, 13.0F, 6.5F, jyh(790552, 0.78F));
         uut.outline(var1, var30, var23, var29, 13.0F, 6.5F, 0.6F, jyh(16777215, 0.14F));
         var28.drawCentered(var1, var27, var30 + var29 * 0.5F, var28.centerTop(var23 + 6.5F), jyh(16777215, 0.95F));
         uut.popAlpha();
      }
   }

   void jwp(DrawContext var1) {
      vdn var2 = veo.medium(6.2F);
      String var3 = a.d("妄‑\uaac5㒿뽮㧎莎\u0a78鐵Ố", -2045428213, 1438345160) + SharedConstants.getGameVersion().name();
      var2.drawRight(var1, var3, this.jve - 12.0F, var2.centerTop(this.jvf - 12.0F), jyh(jyg(16777215, 2764342, this.jvl.get()), 0.55F));
   }

   float jwq() {
      return this.jve - 12.0F - 254.0F;
   }

   float jwr() {
      return 40.0F;
   }

   float jws() {
      return Math.min(this.jvf - this.jwr() - 12.0F, 24.0F + this.jww() + 6.0F);
   }

   float jwt() {
      return this.jwr() + 24.0F;
   }

   float jwu() {
      return this.jws() - 24.0F - 4.0F;
   }

   static int jwv(int var0, int var1) {
      return (var0 + var1 - 1) / var1;
   }

   float jww() {
      return this.jwx() + 13.0F + 171.0F + 4.0F;
   }

   float jwx() {
      return 13.0F + jwv(kbs.values().length, 3) * 62.0F + 2.0F;
   }

   float jwy() {
      return Math.max(0.0F, this.jww() - this.jwu());
   }

   float jwz(int var1) {
      return this.jwq() + 8.0F + var1 % 3 * 82.0F;
   }

   float jxa(int var1) {
      return this.jwt() + 13.0F + var1 / 3 * 62.0F - this.jut;
   }

   boolean jxb(float var1, float var2) {
      return this.jub.get() > 0.5F && jyf(var1, var2, this.jwq(), this.jwr(), 254.0F, this.jws());
   }

   int jxc(float var1, float var2) {
      if (!jyf(var1, var2, this.jwq(), this.jwt(), 254.0F, this.jwu())) {
         return -1;
      }

      kbs[] var3 = kbs.values();

      for (int var4 = 0; var4 < var3.length; var4++) {
         if (jyf(var1, var2, this.jwz(var4), this.jxa(var4), 74.0F, 54.0F)) {
            return var4;
         }
      }

      return -1;
   }

   void jxd(DrawContext var1, float var2, float var3) {
      float var4 = this.jub.step(this.juq, this.jvc);
      if (!(var4 <= 0.003F)) {
         float var5 = vcq.outCubic(var4);
         float var6 = this.jwq();
         float var7 = this.jwr();
         float var8 = this.jws();
         float var9 = 11.0F;
         Matrix3x2fStack var10 = var1.getMatrices();
         var10.pushMatrix();
         float var11 = this.jwn(2) + 10.5F;
         var10.translate(var11, var7);
         var10.scale(0.9F + 0.1F * var5, 0.9F + 0.1F * var5);
         var10.translate(-var11, -var7 - (1.0F - var5) * 6.0F);
         uut.pushAlpha(var5);

         try {
            uut.shadow(var1, var6, var7 + 4.0F, 254.0F, var8, var9, 22.0F, jyh(0, 0.45F));
            this.jtt.frosted(var1, var6, var7, 254.0F, var8, var9, this.jve, this.jvf, jyh(16777215, 1.0F));
            uut.round(var1, var6, var7, 254.0F, var8, var9, jyh(724759, 0.55F));
            uut.outlineGradientV(var1, var6, var7, 254.0F, var8, var9, 0.7F, jyh(16777215, 0.3F), jyh(16777215, 0.07F));
            vdn var12 = veo.semibold(7.6F);
            vjf.draw(var1, vhz.IMAGE, var6 + 15.0F, var7 + 12.5F, 9.0F, jyh(jya(this.jug), 1.0F));
            var12.draw(
               var1,
               wap.s(a.c(512410759, "쓅뵜㞄ꧮ≬꒟ỏ霼५菖Аﹼ炱\ue91b捂"), a.d("Ꞡ\ude0b哛캷䅼쟄綟\uf41d", -1697236676, -1730766160)),
               var6 + 24.0F,
               var12.centerTop(var7 + 12.5F),
               jyh(16777215, 0.95F)
            );
            this.juu = Math.max(0.0F, Math.min(this.jwy(), this.juu));
            this.jut = this.jut + (this.juu - this.jut) * (1.0F - (float)Math.exp(-this.jvc * 16.0F));
            float var13 = this.jwt();
            float var14 = this.jwu();
            int var15 = var4 >= 0.99F ? this.jxc(var2, var3) : -1;
            uut.pushScissor(var1, var6, var13, 254.0F, var14);

            try {
               vdn var16 = veo.medium(6.0F);

               for (int var17 = 0; var17 < 2; var17++) {
                  float var18 = var13 + (var17 == 1 ? this.jwx() : 0.0F) - this.jut;
                  String var19 = var17 == 0
                     ? wap.s(a.b("霷\ueeb0摮﨟燔\uf774䴶쓒媚퀪", 576558954), a.d("\uedba鐤Ỹ肏", 534105332, 1341007188))
                     : wap.s(a.b("ꈹ\udba0典켒䒐쉭砽\uf1cc澗", 1400414845), a.b("䇺㡡늾⣛꜐↨鯳ቱ", -568179232));
                  var16.drawTracked(var1, var19.toUpperCase(), var6 + 10.0F, var16.centerTop(var18 + 6.5F), jyh(16777215, 0.5F), 0.8F);
                  float var20 = var16.width(var19.toUpperCase(), 0.8F);
                  uut.rect(var1, var6 + 16.0F + var20, var18 + 6.5F, 228.0F - var20, 0.5F, jyh(16777215, 0.1F));
               }

               kbs[] var30 = kbs.values();

               for (int var32 = 0; var32 < var30.length; var32++) {
                  float var34 = this.jxa(var32);
                  if (!(var34 + 42.0F + 14.0F < var13) && !(var34 > var13 + var14)) {
                     this.jxe(var1, var30[var32], var32, var15 == var32);
                  } else {
                     this.jua[var32].set(0.0F);
                  }
               }

               this.jyb(var1, var2, var3, var4 >= 0.99F);
            } finally {
               uut.popScissor(var1);
            }

            float var29 = this.jwy();
            if (var29 > 0.5F) {
               uut.gradientV(var1, var6 + 1.0F, var13, 252.0F, 8.0F, 0.0F, jyh(724759, 0.55F * vcq.clamp01(this.jut / 8.0F)), jyh(724759, 0.0F));
               uut.gradientV(
                  var1, var6 + 1.0F, var13 + var14 - 8.0F, 252.0F, 8.0F, 0.0F, jyh(724759, 0.0F), jyh(724759, 0.55F * vcq.clamp01((var29 - this.jut) / 8.0F))
               );
               float var31 = Math.max(14.0F, var14 * var14 / this.jww());
               float var33 = var13 + (var14 - var31) * (this.jut / var29);
               uut.round(var1, var6 + 254.0F - 4.5F, var33, 2.0F, var31, 1.0F, jyh(16777215, 0.28F));
            }
         } finally {
            uut.popAlpha();
            var10.popMatrix();
         }
      }
   }

   void jxe(DrawContext var1, kbs var2, int var3, boolean var4) {
      float var5 = this.jwz(var3);
      float var6 = this.jxa(var3);
      float var7 = 7.0F;
      float var8 = 74.0F;
      float var9 = 42.0F;
      float var10 = this.jua[var3].step(var4, this.jvc);
      boolean var11 = var2 == this.jug;
      float var12 = vcq.clamp01((kap.clock() - this.juf[var3]) / 0.45F);
      float var13 = var12 < 1.0F ? (float)Math.sin(Math.PI * vcq.clamp01(var12 * 2.4F)) * (1.0F - var12 * 0.5F) : 0.0F;
      Matrix3x2fStack var14 = var1.getMatrices();
      var14.pushMatrix();
      var14.translate(var5 + var8 * 0.5F, var6 + var9 * 0.5F);
      var14.scale(1.0F - 0.06F * var13, 1.0F - 0.06F * var13);
      var14.translate(-var5 - var8 * 0.5F, -var6 - var9 * 0.5F);

      try {
         this.jxf(var1, var2, var5, var6, var8, var9, var7, var10, var11);
      } finally {
         var14.popMatrix();
      }
   }

   void jxf(DrawContext var1, kbs var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9) {
      uok var10 = jzh.thumb(var2.key);
      if (var10 != null) {
         float var11 = (float)var10.width / var10.height;
         float var12 = var5 / var6;
         float var13 = var11 > var12 ? (1.0F - var12 / var11) * 0.5F : 0.0F;
         float var14 = var11 > var12 ? 0.0F : (1.0F - var11 / var12) * 0.5F;
         float var15 = 0.04F * var8;
         uut.imageRegion(
            var1,
            var10.view,
            var3,
            var4,
            var5,
            var6,
            var7,
            var13 + var15,
            var14 + var15,
            1.0F - var13 - var15,
            1.0F - var14 - var15,
            jyh(16777215, 1.0F),
            false
         );
      } else {
         uut.round(var1, var3, var4, var5, var6, var7, jyh(16777215, 0.08F));
      }

      uut.round(var1, var3, var4, var5, var6, var7, jyh(0, 0.18F * (1.0F - var8)));
      if (var2.isVideo()) {
         uut.circle(var1, var3 + 7.0F, var4 + var6 - 7.0F, 4.2F, jyh(0, 0.6F));
         vjf.draw(var1, vhz.PLAY, var3 + 7.3F, var4 + var6 - 7.0F, 5.2F, jyh(16777215, 0.95F));
      }

      int var16 = jya(var2);
      int var17 = var9 ? var16 : 16777215;
      uut.outline(var1, var3, var4, var5, var6, var7, var9 ? 1.2F : 0.7F, jyh(var17, var9 ? 0.95F : 0.18F + 0.4F * var8));
      vdn var18 = veo.medium(6.3F);
      String var19 = var2.title();
      if (var18.width(var19) > var5 - 10.0F) {
         while (var19.length() > 1 && var18.width(var19 + a.b("⁘", 168689791)) > var5 - 10.0F) {
            var19 = var19.substring(0, var19.length() - 1);
         }

         var19 = var19.trim() + a.b("׳", -1386928684);
      }

      var18.draw(
         var1, var19, var3 + 2.0F, var18.centerTop(var4 + var6 + 7.0F), jyh(var9 ? jyg(16777215, var16, 0.5F) : 16777215, var9 ? 1.0F : 0.7F + 0.3F * var8)
      );
      uut.circle(var1, var3 + var5 - 4.0F, var4 + var6 + 7.0F, 2.2F, jyh(var16, var9 ? 1.0F : 0.45F));
   }

   float jxg() {
      return (this.jve - 228.0F) * 0.5F;
   }

   float jxh() {
      return (this.jvf - 118.0F) * 0.5F;
   }

   float jxi(int var1) {
      float var2 = 96.0F;
      return this.jxg() + 14.0F + var1 * (var2 + 8.0F);
   }

   float jxj() {
      return this.jxh() + 118.0F - 34.0F;
   }

   void jxk(DrawContext var1, GpuTextureView var2, float var3, float var4, float var5) {
      float var6 = this.juc.step(this.jur, this.jvc);
      if (!(var6 <= 0.003F)) {
         float var7 = vcq.outBack(var6);
         int var8 = this.jug.accent;
         uut.rect(var1, 0.0F, 0.0F, this.jve, this.jvf, jyh(197898, 0.42F * vcq.clamp01(var6)));
         float var9 = this.jxg();
         float var10 = this.jxh();
         float var11 = 14.0F;
         Matrix3x2fStack var12 = var1.getMatrices();
         var12.pushMatrix();
         var12.translate(var9 + 114.0F, var10 + 59.0F);
         float var13 = 0.9F + 0.1F * Math.min(1.05F, var7);
         var12.scale(var13, var13);
         var12.translate(-114.0F - var9, -59.0F - var10 + (1.0F - Math.min(1.0F, var7)) * 8.0F);
         uut.pushAlpha(vcq.clamp01(var6 * 1.4F));

         try {
            uut.shadow(var1, var9, var10 + 6.0F, 228.0F, 118.0F, var11, 26.0F, jyh(0, 0.5F));
            this.jtt.frosted(var1, var9, var10, 228.0F, 118.0F, var11, this.jve, this.jvf, jyh(16777215, 1.0F));
            uut.round(var1, var9, var10, 228.0F, 118.0F, var11, jyh(658966, 0.6F));
            uut.outlineGradientV(var1, var9, var10, 228.0F, 118.0F, var11, 0.7F, jyh(16777215, 0.3F), jyh(16777215, 0.07F));
            if (var2 != null) {
               uut.additive(true);
               uut.sprite(var1, var2, var9 + 30.0F, var10 + 30.0F, 60.0F, jyh(var8, 0.25F));
               uut.additive(false);
            }

            float var14 = (float)Math.sin(var5 * 3.2F) * 1.2F;
            uut.round(var1, var9 + 16.0F, var10 + 16.0F, 28.0F, 28.0F, 9.0F, jyh(var8, 0.18F));
            uut.outline(var1, var9 + 16.0F, var10 + 16.0F, 28.0F, 28.0F, 9.0F, 0.7F, jyh(var8, 0.5F));
            vjf.draw(var1, vhz.DOWNLOAD, var9 + 30.0F, var10 + 30.0F + var14, 14.0F, jyh(jyg(var8, 16777215, 0.35F), 1.0F));
            vdn var15 = veo.semibold(9.6F);
            var15.draw(
               var1,
               wap.s(a.d("猦઼職ḟ闊፸ꤥ⃑뻊㐯돠䦜윎廖풍剮\ue852柎ﵿ笥", 771666703, -1186611079), a.d("⯋剡\ud8b8䚾촞䮦\uf18e砈\ue242泯\ueb3eᅅ鮆ɞ蠅\u0ee6", 1775895123, 444476841)),
               var9 + 54.0F,
               var15.centerTop(var10 + 24.0F),
               jyh(16777215, 0.97F)
            );
            vdn var16 = veo.medium(6.6F);
            var16.draw(
               var1,
               a.d("蚁７疇\ueb9c恭\ue6d0岋픿䬁솒䙁밼㋱꭛ℒꞷᶋ鉾࣓躟ݿ紥\uf39b桝\uee70搶\udd12匥짵侧쐄㫎낋⤹꽻◕騞ၬ隠༎蕑", -1628306265, 341082694),
               var9 + 54.0F,
               var16.centerTop(var10 + 36.0F),
               jyh(jyg(16777215, var8, 0.5F), 0.85F)
            );
            vdn var17 = veo.medium(6.4F);
            var17.draw(
               var1,
               wap.s(
                  a.c(2000432474, "ⴣ咮\ude70䁄쯒䵮\uf725纀\ue092樯\uedf3ឍ饜ï誫ఈ또㧙ꍷ┿곐훒堵쏸䖝콑相\uf8bb扃\ue45a澠酬᭹芆ҥ踱\u31e7믂㵅ꓨ⺺倎\uda17嶭읩"),
                  a.c(-946537788, "\ufeff蝥ශ鎾ᰋ麦⓼괅㍒맢㸳쑁䫣휲夁\udf80旎\uea10烟\uf6fc缎Ԩ迹၏陂᳦ꔠ⭳떓㟟뱤䊳죱唐퍍巃\ue235桁\uee97眮ﵿ菴\u09d0")
               ),
               var9 + 16.0F,
               var17.centerTop(var10 + 56.0F),
               jyh(16777215, 0.62F)
            );
            var17.draw(
               var1,
               wap.s(
                  a.b("ᒨ洞\ue7d7禽\uf225瓀캏䝳\ud969厕푄⸾ꃾ㤜댉㗱辽d髖Ა锵\uef25憙既籹\uf6fa佞섙審\uddad嘍\ua8da⋁뭤㴫랗ࠅ舳Ӧ鵛ᜌ榶", 913773803),
                  a.b("ൟ璚﹀怳\uefff浜팝廳삣䨝췋㟃뵷⒋껚⠠鉸᷺荑Ę賰\uf6ab硭\ue3c9斴\uef62回\ud8f3䈆쑔依넶㬎ꛪ⒡긛ᆿ鯍ᥳ", -1957820100)
               ),
               var9 + 16.0F,
               var17.centerTop(var10 + 66.0F),
               jyh(16777215, 0.62F)
            );

            for (int var18 = 0; var18 < 2; var18++) {
               this.jxl(var1, var18, var3, var4, var8, var6 >= 0.99F);
            }
         } finally {
            uut.popAlpha();
            var12.popMatrix();
         }
      }
   }

   void jxl(DrawContext var1, int var2, float var3, float var4, int var5, boolean var6) {
      float var7 = 96.0F;
      float var8 = 20.0F;
      float var9 = this.jxi(var2);
      float var10 = this.jxj();
      float var11 = this.jud[var2].step(var6 && jyf(var3, var4, var9, var10, var7, var8), this.jvc);
      boolean var12 = var2 == 0;
      uut.round(var1, var9, var10, var7, var8, var8 * 0.5F, var12 ? jyh(var5, 0.3F + 0.25F * var11) : jyh(16777215, 0.05F + 0.08F * var11));
      uut.outline(
         var1, var9, var10, var7, var8, var8 * 0.5F, 0.7F, jyh(var12 ? var5 : jyg(16777215, var5, var11), var12 ? 0.6F + 0.35F * var11 : 0.15F + 0.35F * var11)
      );
      vdn var13 = veo.semibold(7.0F);
      String var14 = var12
         ? wap.s(a.b("\u0086礜\uf3d7涿\ue66a惘\uda85危", -1990393654), a.b("ﮐ舺ࣣ雥ᵅ鮆⇛", -876347466))
         : wap.s(a.b("\uf2a9謷ǧ龊ᑋ", -612568337), a.b("\ude67\ua7f1\u2d28댣㣿빇К", -1351886217));
      float var15 = var13.width(var14);
      if (var12) {
         vjf.draw(var1, vhz.DOWNLOAD, var9 + (var7 - var15) * 0.5F - 5.0F, var10 + var8 * 0.5F, 8.0F, jyh(16777215, 0.95F));
      }

      var13.draw(var1, var14, var9 + (var7 - var15) * 0.5F + (var12 ? 3.0F : 0.0F), var13.centerTop(var10 + var8 * 0.5F), jyh(16777215, 0.95F));
   }

   void jxm(kbs var1) {
      if (var1 != this.jug) {
         this.jtu.close();
         this.jui = this.jug.key;
         this.juj = this.juh;
         this.jum = false;
         this.juk = kap.clock();
         this.jul = 0.9F;
         this.jug = var1;
         this.juh = new jsi(var1.particles, 7L + var1.ordinal());
         kbs.select(var1);
         hyz.saveLater();
      }
   }

   static kbs jxn(String var0) {
      kbs var1 = kbs.byKey(var0);
      return var1 != null ? var1 : kbs.DEFAULT;
   }

   static String jxo(int var0) {
      return switch (var0) {
         case 0 -> wap.s(vvi.get() + a.d("꺬흉嶇쏫䠤캜", -2056648614, 1420338896), a.b("\u2ef6坪\uddbd䏇젗仟\uf481礜", 2013342435) + vvi.get());
         case 1 -> wap.s(a.d("勃⭅ꆗ㿦됪㊚裔", -1867779212, -1590582798), a.b("糍՛辋ᇻ騩Ლ", 1969584337));
         case 2 -> wap.s(a.b("礈\u009e詀ᐤ鿺", -790857378), a.b("励⭣ꇊ㾸되㛅袌ź鼦ᖖ鉄栱", -1092200804));
         case 3 -> wap.s(a.c(-122497966, "퐛궝❏뤾㋲둂\u0e5f蟬ᦽ錕ᓁ"), a.b("߰繑\uf485櫿\ue15f柧\uddce吲칸䃓윇㵵뎣⨓ꁄ", 1988690911));
         case 4 -> wap.s(a.b("ፏ櫃\ue00a繠\uf5bd猁쥕䂭", -776989931), a.c(652020703, "\u0ff4癞ﳷ抅\ue922澛헆尿쉥䣙"));
         case 5 -> wap.s(a.d("觺\uf06e窮\ue4c6漟\ue9a5", -694349197, -277636149), a.c(-1928329783, "Ǒ硇\uf2e6泠\ue73e憎\udbd5刬챶䛊씌㬙떴ⰆꙘ"));
         case 6 -> wap.s(a.c(748574822, "堿↿ꭿ㔈뻂㡹舥\u0bdd閔"), a.b("栜ᆺ鬘ժ軇ࠈ뉖", -530617284));
         case 7 -> wap.s(a.d("罀ۀ谀ቢ馸Ἁꕗⲿ", 903154723, -1690668229), a.b("ﬁ芟࠼阽ᷡ魐℈ꣳ㛗", -1391329513));
         default -> "";
      };
   }

   static String[] jxp(int var0) {
      return var0 == 1
         ? new String[]{
            wap.s(a.d("ቷ毯\ue13f罜", -1326154102, -1732350795), a.d("\udc71ꗚ⼇녱㪤", 1599536237, 340272184)),
            wap.s(a.c(-126533446, "䃿㥨뎰ⷛꘝ₻"), a.c(680001806, "ԭ粏\uf654桚\ue38f")),
            wap.s(a.d("拄\u1b4e醓\u0fed萦", 1264906015, 435916172), a.c(-540461249, "㌘䪷쀛帚헏卼"))
         }
         : new String[]{
            wap.s(a.b("ⴷ咭\ude73䀐쯇", -538759819), a.b("ꐥ\uddf7坓줭䋻쑏", 435200002)),
            wap.s(a.d("㍋䫟쀟幷", -1074930333, 1963716200), a.d("ꬔ틖塨옘䶹쭶", 440093542, 441508950)),
            wap.s(a.b("\uddc3ꑗ⺊냴㬿", 564452746), a.b("룺션䮌햊帤\ud8e5拈", 1009433820)),
            wap.s(a.b("∟宔텆伯쓽䉋\uf813", 1238508119), a.c(-238451201, "臣\uf876犦\ueca8松\ue1cc"))
         };
   }

   static vmc jxq(int var0) {
      return var0 == 3 ? kbm.BLUR : (var0 == 4 ? kbm.ROUND : kbm.DIM);
   }

   static boolean jxr(int var0) {
      return switch (var0) {
         case 0 -> kbm.TITLE.get();
         case 6 -> kbm.PARTICLES.get();
         default -> kbm.PARALLAX.get();
      };
   }

   static float jxs(int var0) {
      return switch (var0) {
         case 1 -> kbm.POSITION.index();
         case 2 -> kbm.BUTTONS.index();
         case 3, 4, 5 -> (float)jxq(var0).getFraction();
         default -> jxr(var0) ? 1.0F : 0.0F;
         case 8 -> 0.0F;
      };
   }

   float jxt(int var1) {
      return this.jwt() + this.jwx() + 13.0F + var1 * 19.0F - this.jut;
   }

   float jxu() {
      return this.jwq() + 254.0F - 10.0F - 132.0F;
   }

   float jxv() {
      return this.jxu() + 30.0F;
   }

   float jxw() {
      return 98.0F;
   }

   int jxx(float var1, float var2) {
      if (!jyf(var1, var2, this.jwq(), this.jwt(), 254.0F, this.jwu())) {
         return -1;
      }

      for (int var3 = 0; var3 < 9; var3++) {
         if (jyf(var1, var2, this.jwq() + 6.0F, this.jxt(var3), 242.0F, 19.0F)) {
            return var3;
         }
      }

      return -1;
   }

   void jxy(int var1, float var2) {
      switch (var1) {
         case 0:
            kbm.TITLE.toggle();
            break;
         case 1:
         case 2:
            if (var2 < this.jxu()) {
               return;
            }

            vlv var3 = var1 == 1 ? kbm.POSITION : kbm.BUTTONS;
            int var4 = var3.getModes().size();
            int var5 = Math.max(0, Math.min(var4 - 1, (int)((var2 - this.jxu()) / (132.0F / var4))));
            var3.set(var3.getModes().get(var5));
            break;
         case 3:
         case 4:
         case 5:
            if (var2 < this.jxv() - 6.0F) {
               return;
            }

            this.jvp = var1;
            this.jxz(var1, var2);
            return;
         case 6:
            kbm.PARTICLES.toggle();
            break;
         case 7:
            kbm.PARALLAX.toggle();
            break;
         default:
            this.jvo[8].set(1.0F);
            kbm.reset();
      }

      hyz.saveLater();
   }

   void jxz(int var1, float var2) {
      jxq(var1).setFromFraction(vcq.clamp01((var2 - this.jxv()) / this.jxw()));
   }

   static int jya(kbs var0) {
      return var0.light ? 13225945 : var0.accent;
   }

   void jyb(DrawContext var1, float var2, float var3, boolean var4) {
      int var5 = jya(this.jug);
      vdn var6 = veo.medium(6.3F);
      vdn var7 = veo.medium(5.7F);
      float var8 = this.jwt();
      float var9 = var8 + this.jwu();

      for (int var10 = 0; var10 < 9; var10++) {
         float var11 = this.jxt(var10);
         float var12 = this.jvo[var10].step(jxs(var10), this.jvc);
         if (!(var11 + 19.0F < var8) && !(var11 > var9)) {
            boolean var13 = var4 && this.jvp < 0 && jyf(var2, var3, this.jwq() + 6.0F, var11, 242.0F, 19.0F);
            float var14 = this.jvn[var10].step(var13 || this.jvp == var10, this.jvc);
            float var15 = var11 + 9.5F;
            boolean var16 = var10 == 0 && this.jug.logo();
            uut.pushAlpha(var16 ? 0.4F : 1.0F);

            try {
               this.jyc(var1, var10, var11, var15, var12, var14, var13, var2, var3, var5, var6, var7);
            } finally {
               uut.popAlpha();
            }
         } else {
            this.jvn[var10].set(0.0F);
         }
      }
   }

   void jyc(
      DrawContext var1, int var2, float var3, float var4, float var5, float var6, boolean var7, float var8, float var9, int var10, vdn var11, vdn var12
   ) {
      if (var2 < 8) {
         uut.round(var1, this.jwq() + 6.0F, var3 + 1.0F, 242.0F, 17.0F, 5.0F, jyh(16777215, 0.05F * var6));
      }

      if (var2 < 8) {
         var11.draw(var1, jxo(var2), this.jwq() + 12.0F, var11.centerTop(var4), jyh(16777215, 0.78F + 0.2F * var6));
      }

      switch (var2) {
         case 1:
         case 2:
            String[] var21 = jxp(var2);
            int var24 = var21.length;
            float var26 = 132.0F / var24;
            float var27 = this.jxu();
            uut.round(var1, var27, var4 - 6.5F, 132.0F, 13.0F, 6.5F, jyh(16777215, 0.07F));
            uut.round(var1, var27 + var5 * var26 + 1.0F, var4 - 5.5F, var26 - 2.0F, 11.0F, 5.5F, jyh(var10, 0.38F));
            uut.outline(var1, var27 + var5 * var26 + 1.0F, var4 - 5.5F, var26 - 2.0F, 11.0F, 5.5F, 0.6F, jyh(var10, 0.7F));
            int var28 = Math.round(var5);

            for (int var18 = 0; var18 < var24; var18++) {
               var12.drawCentered(var1, var21[var18], var27 + var26 * (var18 + 0.5F), var12.centerTop(var4), jyh(16777215, var18 == var28 ? 1.0F : 0.62F));
            }
            break;
         case 3:
         case 4:
         case 5:
            vmc var20 = jxq(var2);
            float var23 = this.jxv();
            float var25 = this.jxw();
            var12.drawRight(var1, var20.display(), var23 - 6.0F, var12.centerTop(var4), jyh(16777215, 0.7F));
            uut.round(var1, var23, var4 - 1.5F, var25, 3.0F, 1.5F, jyh(16777215, 0.14F));
            uut.round(var1, var23, var4 - 1.5F, Math.max(3.0F, var25 * var5), 3.0F, 1.5F, jyh(var10, 0.9F));
            uut.circle(var1, var23 + var25 * var5, var4, 4.0F + 0.8F * var6, jyh(16777215, 1.0F));
            uut.circle(var1, var23 + var25 * var5, var4, 1.8F, jyh(var10, 1.0F));
            break;
         case 6:
         case 7:
         default:
            float var19 = 20.0F;
            float var22 = this.jwq() + 254.0F - 10.0F - var19;
            uut.round(var1, var22, var4 - 5.5F, var19, 11.0F, 5.5F, jyh(jyg(3817552, var10, var5), 0.55F + 0.4F * var5));
            uut.circle(var1, var22 + 5.5F + 9.0F * var5, var4, 4.0F, jyh(16777215, 1.0F));
            break;
         case 8:
            float var13 = 234.0F;
            float var14 = this.jwq() + 10.0F;
            boolean var15 = var7 && jyf(var8, var9, var14, var4 - 7.0F, var13, 14.0F);
            uut.round(var1, var14, var4 - 6.5F, var13, 13.0F, 6.5F, jyh(jyg(16777215, var10, var5), 0.08F + (var15 ? 0.1F : 0.0F) + 0.3F * var5));
            uut.outline(var1, var14, var4 - 6.5F, var13, 13.0F, 6.5F, 0.6F, jyh(16777215, var15 ? 0.38F : 0.18F));
            String var16 = wap.s(a.b("脚\uf89c牙\uec3e柸", 2146599245), a.d("戨ᮉ鄫༤蒌Ʉ롭㆒", 1389522638, -1972696881));
            float var17 = var12.width(var16) + 11.0F;
            vjf.draw(var1, vhz.REFRESH, var14 + (var13 - var17) * 0.5F + 3.5F, var4, 7.0F, jyh(16777215, 0.85F));
            var12.draw(var1, var16, var14 + (var13 - var17) * 0.5F + 11.0F, var12.centerTop(var4), jyh(16777215, 0.9F));
      }
   }

   @Override
   public boolean mouseClicked(Click click, boolean doubled) {
      if (click.button() != 0) {
         return true;
      }

      float var3 = (float)click.x() / this.jvd;
      float var4 = (float)click.y() / this.jvd;
      if (this.jux < 0 && !(this.juy >= 0.0F)) {
         if (this.jur) {
            float var9 = 96.0F;
            if (jyf(var3, var4, this.jxi(0), this.jxj(), var9, 20.0F)) {
               jye(
                  a.c(
                     -95082218,
                     "⤳傞\uda4d䐸쿬䤔\uf352窣\ue4be渍\ue9d5Ꮂ鵾ӈ躁\u086c뉥㷹Ꝇℕꢠ튳専쟘䇬쭻狏ﳝ晠\ue037殈镑ὖ蛫º訋㗐뾻㥳ꃘ⫞呱\ude26妉썃䴥\uf4fd繁\uf819掕\uedbf\u177d黝ᢍ艤ళ랍ㅁ뭾⋷갚홇冫\udbe6䔪첄盈\uf039穹\ue582漀\ue92aჲ驀Ѓ迩\u09b4"
                  )
               );
               this.jur = false;
            } else if (jyf(var3, var4, this.jxi(1), this.jxj(), var9, 20.0F) || !jyf(var3, var4, this.jxg(), this.jxh(), 228.0F, 118.0F)) {
               this.jur = false;
            }

            return true;
         } else {
            if (this.juq) {
               if (this.jxb(var3, var4)) {
                  int var8 = this.jxc(var3, var4);
                  if (var8 >= 0) {
                     this.juf[var8] = kap.clock();
                     this.jxm(kbs.values()[var8]);
                  } else {
                     int var10 = this.jxx(var3, var4);
                     if (var10 >= 0) {
                        this.jxy(var10, var3);
                     }
                  }

                  return true;
               }

               if (!jyf(var3, var4, this.jwn(2), 12.0F, 21.0F, 21.0F)) {
                  this.juq = false;
               }
            }

            for (int var5 = 0; var5 < 4; var5++) {
               if (jyf(var3, var4, this.jwn(var5), 12.0F, 21.0F, 21.0F)) {
                  this.jue[var5] = kap.clock();
                  switch (var5) {
                     case 0:
                        jye(TELEGRAM);
                        break;
                     case 1:
                        jye(a.c(-239718413, "⾇嘪\udcf9䊌쥘侠\uf5e6簗\ue203梿\uef76ᔗ鯌ɠ蠥ພ뒘㭉ꆲ➫긏퐌媴셑䜚췡瑰猪"));
                        break;
                     case 2:
                        this.juq = !this.juq;
                        if (this.juq) {
                           float var6 = this.jxa(this.jug.ordinal()) + this.jut - this.jwt();
                           this.juu = this.jut = Math.max(0.0F, Math.min(this.jwy(), var6 - this.jwu() * 0.35F));
                        }
                        break;
                     default:
                        this.juy = kap.clock() + 0.28F;
                  }

                  return true;
               }
            }

            for (int var7 = 0; var7 < 4; var7++) {
               if (jyf(var3, var4, this.jwk(), this.jwj(var7), 138.0F, 25.0F)) {
                  this.jus = var7;
                  this.juv = kap.clock();
                  this.juw = var3 - this.jwk();
                  if (var7 == 2 && !jrn.available()) {
                     this.jur = true;
                  } else {
                     this.jux = var7;
                  }

                  return true;
               }
            }

            return true;
         }
      } else {
         return true;
      }
   }

   @Override
   public boolean mouseDragged(Click click, double offsetX, double offsetY) {
      if (this.jvp >= 0) {
         this.jxz(this.jvp, (float)click.x() / this.jvd);
         return true;
      } else {
         return super.mouseDragged(click, offsetX, offsetY);
      }
   }

   @Override
   public boolean mouseReleased(Click click) {
      if (this.jvp >= 0) {
         this.jvp = -1;
         hyz.saveLater();
         return true;
      } else {
         return super.mouseReleased(click);
      }
   }

   @Override
   public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
      if (this.juq && this.jxb((float)mouseX / this.jvd, (float)mouseY / this.jvd)) {
         this.juu = Math.max(0.0F, Math.min(this.jwy(), this.juu - (float)verticalAmount * 28.0F));
      }

      return true;
   }

   void jyd(int var1) {
      MinecraftClient var2 = this.client;
      switch (var1) {
         case 0:
            var2.setScreen(new SelectWorldScreen(this));
            break;
         case 1:
            var2.setScreen(var2.options.skipMultiplayerWarning ? new MultiplayerScreen(this) : new MultiplayerWarningScreen(this));
            break;
         case 2:
            if (jrn.available()) {
               var2.setScreen(new jos(this));
            } else {
               this.jur = true;
            }
            break;
         default:
            var2.setScreen(new OptionsScreen(this, var2.options));
      }
   }

   static void jye(String var0) {
      try {
         Util.getOperatingSystem().open(URI.create(var0));
      } catch (Exception var2) {
         System.out.println(a.c(945862716, "롔쇧䬻픃庇\ud862找\ueb90痚｠磽") + var0 + a.b("맚쁱", 382122466) + var2);
      }
   }

   @Override
   public boolean keyPressed(KeyInput input) {
      if (input.key() == 256) {
         if (this.jur) {
            this.jur = false;
         } else if (this.juq) {
            this.juq = false;
         }
      }

      return true;
   }

   @Override
   public boolean shouldCloseOnEsc() {
      return false;
   }

   @Override
   public boolean shouldPause() {
      return false;
   }

   @Override
   public void removed() {
      this.jup = true;
      this.juq = false;
      this.jvp = -1;
      this.jub.set(0.0F);
      this.jur = false;
      this.juc.set(0.0F);
      this.jux = -1;
      this.jtt.close();
      this.jtu.close();
      this.jtx.close();
      vdn.setRenderScale(1.0F);
   }

   static boolean jyf(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var1 >= var3 && var0 < var2 + var4 && var1 < var3 + var5;
   }

   static int jyg(int var0, int var1, float var2) {
      return kce.mix(var0, var1, var2);
   }

   static int jyh(int var0, float var1) {
      return kce.rgba(var0, var1);
   }
}
