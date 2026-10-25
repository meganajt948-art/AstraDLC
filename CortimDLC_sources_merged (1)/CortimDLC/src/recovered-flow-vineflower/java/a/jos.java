package a;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.ProfileResult;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.text.Text;
import org.joml.Matrix3x2fStack;

public final class jos extends Screen {
   static final float jot = 268.0F;
   static final float jou = 218.0F;
   static final float jov = 46.0F;
   static final float jow = 28.0F;
   static final float jox = 4.0F;
   static final float joy = 50.0F;
   static final Pattern joz = Pattern.compile(a.c(-1434253870, "֛簰\uf68f梉\ue365斘\udf9c嘧졥䋀앵㼆뇷⠎ꉂ⒮黦ᅼ"));
   static final Map<UUID, SkinTextures> jpa = new HashMap<>();
   static final Map<UUID, CompletableFuture<?>> jpb = new HashMap<>();
   final Screen jpc;
   final kap jpd = new kap();
   final kam jpe = new kam();
   final kbs jpf = kbs.selected();
   final jsi jpg = new jsi(this.jpf.particles, 11L);
   List<jyi> jph = new ArrayList<>();
   final Map<Object, jop> jpi = new IdentityHashMap<>();
   final List<jop> jpj = new ArrayList<>();
   final vcj jpk = new vcj(14.0F);
   final vcj jpl = new vcj(14.0F);
   final vcj jpm = new vcj(14.0F);
   final vcj jpn = new vcj(14.0F);
   final vcj jpo = new vcj(12.0F);
   final vcj jpp = new vcj(9.0F);
   String jpq = "";
   boolean jpr = true;
   float jps = -10.0F;
   float jpt = -10.0F;
   float jpu = -10.0F;
   String jpv = "";
   int jpw = 16777215;
   float jpx = -10.0F;
   Object jpy;
   Object jpz;
   float jqa;
   float jqb;
   float jqc;
   float jqd = -1.0F;
   float jqe = -1.0F;
   boolean jqf;
   float jqg;
   float jqh;
   long jqi;
   float jqj;
   float jqk = 1.0F;
   float jql = 480.0F;
   float jqm = 270.0F;
   static final String[] jqn = new String[]{
      a.b("\u0fdc癉ﲄ拺\ue93f", 432738186),
      a.d("꥓탖娘쑵侥", 347678702, -1017934082),
      a.d("\ud9b6ꀾ⫶뒈㽌", 1361288621, 1436304466),
      a.b("鷞\ue456溔\uf0f8符", 1989123467),
      a.c(-153179634, "\uaa5b폑夋읿䲣쨊"),
      a.d("謟\uf285硜", -1481703037, -2129229103),
      a.b("솾렾㋦겝❍ꇩ᮷", -433274374),
      a.b("繞߇贛፭颭", -1189970402),
      a.c(-1662357419, "瀀ঋ荝ᴥ雹ၒ"),
      a.c(702897712, "幻⟭괰㍎뢅"),
      a.b("咧ⴱꟹ㦕뉝", -1633004303),
      a.c(-529637742, "廂❀궚㏱렵㺕"),
      a.c(1505472620, "뀪즷䍸\udd17囂"),
      a.d("귉푞庆샰", 877046946, 336855338),
      a.b("吙ⶉꝃ㤥", -438807469),
      a.b("펵ꨪ\u20f4뺞㕖", 643945458)
   };
   static final String[] jqo = new String[]{
      a.d("ূ灚爵", 193236430, -936082359),
      a.b("蕒ﳛ瘋\ue870", -710966015),
      a.c(566737386, "릨쀳䫣풊"),
      a.c(1180307742, "ᅒ棊\ue20f籢"),
      a.d("끅짏䌑\udd71", 1190090854, -1772165019),
      a.b("\uffc1虋ಕ鋥ᤥ", 678690710),
      a.c(488504720, "\ufdd1葖ພ郠ᬥ"),
      a.c(-1406449188, "䦔【뫔⒳"),
      a.d("渠ើ鵪̇裗", -1214066111, 1803336739),
      a.d("봙쒞乚퀸", 624567667, 2075564089),
      a.d("藼ﱾ皵", -229404908, 62327481),
      a.b("铏\ued4d枉匿爷", -1248226152),
      a.d("嚳⼮ꗿ㮆끀", -1352831396, -2090190679),
      a.b("퍻ꫨ†빍", -1762667726)
   };

   public jos(Screen var1) {
      super(Text.literal(a.b("㴰䒬칧偂\udbd8嵥\ue739滇\uf09e稭\ufde9", -1369686662)));
      this.jpc = var1;
      jzh.preload(this.jpf.key);
      this.jqr(kap.clock(), true);
      if (jyw.disabled()) {
         this.jrf(
            wap.s(
               a.b("桷ᇎ鬏ԍ躓࠸눸㮚ꗁ⽮ꢠ勆\udc1a䖦쿴䥁\uf341粙\ue62a怽\ue9c2鏒ᵼ蚪\u0086訄㎡뷡✖ꅚ⫮퐶幭쟆", -798595044),
               a.c(-1709767792, "φ穿\uf0be溼\ue179枱\udd93呣쩉䃱읐㴩럣⹚ꀓ⋰鲪\u137d觃\u0b8c虦ﰺ狸\ue92a潗\ue5f8屌툞䣣컇䄘")
            ),
            16747146
         );
      }
   }

   void jqr(float var1, boolean var2) {
      this.jph = jyw.accounts();
      IdentityHashMap<Object, jop> var3 = new IdentityHashMap<>(this.jpi);
      this.jpi.clear();
      int var4 = 0;

      for (jyi var6 : this.jph) {
         jop var7 = (jop)var3.remove(var6.handle());
         if (var7 == null) {
            var7 = new jop(var6, var2 ? var1 + 0.18F + Math.min(var4, 8) * 0.045F : var1);
         }

         this.jpi.put(var6.handle(), var7);
         var4++;
      }

      for (jop var9 : var3.values()) {
         var9.goneAt = var1;
         this.jpj.add(var9);
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
      this.jqj = this.jqi == 0L ? 0.016666668F : Math.min(0.1F, (float)(var5 - this.jqi) / 1.0E9F);
      this.jqi = var5;
      float var7 = kap.clock();
      if (this.jqd < 0.0F) {
         this.jqd = var7;
      }

      float var8 = var7 - this.jqd;
      float var9 = this.jqe >= 0.0F ? vcq.clamp01((var7 - this.jqe) / 0.22F) : 0.0F;
      this.jqk = kbp.scale(this.width, this.height);
      this.jql = this.width / this.jqk;
      this.jqm = this.height / this.jqk;
      float var10 = mouseX / this.jqk;
      float var11 = mouseY / this.jqk;
      float var12 = 1.0F - (float)Math.exp(-this.jqj * 2.2F);
      if (mouseX >= 0 && mouseY >= 0 && mouseX <= this.width && mouseY <= this.height) {
         this.jqg = this.jqg + ((float)mouseX / this.width - 0.5F - this.jqg) * var12;
         this.jqh = this.jqh + ((float)mouseY / this.height - 0.5F - this.jqh) * var12;
      }

      GpuTextureView var13 = unm.view();
      uut.rect(context, 0.0F, 0.0F, this.width, this.height, -16118250);
      jza var14 = jzh.get(this.jpf.key);
      if (var14 != null) {
         float var15 = vcq.outCubic(vcq.clamp01(var8 / 0.5F)) * (1.0F - vcq.inOutCubic(var9));
         this.jpe.time = var7;
         this.jpe.zoom = 1.05F + 0.01F * var15;
         this.jpe.panX = -this.jqg * 0.014F;
         this.jpe.panY = -this.jqh * 0.01F;
         this.jpe.blur = 0.55F * var15;
         this.jpe.dim = 0.04F + 0.12F * var15;
         this.jpe.tint = this.jpf.tint;
         this.jpe.tintAmount = 0.3F;
         this.jpe.fall = null;
         this.jpe.pool = null;
         this.jpd.draw(context, var14, this.jpe, this.width, this.height, 1.0F, true);
      }

      Matrix3x2fStack var30 = context.getMatrices();
      var30.pushMatrix();
      var30.scale(this.jqk, this.jqk);
      vdn.setRenderScaleStepped(this.jqk);

      try {
         this.jpg.draw(context, var13, this.jql, this.jqm, var7, false, this.jqg, this.jqh, 1.0F);
         float var16 = vcq.clamp01(var8 / 0.42F);
         float var17 = vcq.outBack(var16) * (1.0F - var9) + 0.0F;
         float var18 = vcq.clamp01(var16 * 1.6F) * (1.0F - vcq.inCubic(var9));
         float var19 = this.jqs();
         float var20 = this.jqt();
         var30.pushMatrix();
         var30.translate(var19 + 134.0F, var20 + 109.0F);
         float var21 = 0.94F + 0.06F * Math.min(1.0F, var17) - 0.03F * var9;
         var30.scale(var21, var21);
         var30.translate(-134.0F, -109.0F + (1.0F - Math.min(1.0F, var17)) * 10.0F);
         uut.pushAlpha(var18);

         try {
            this.jqu(context, var13, var10 - var19, var11 - var20, var7, var19, var20);
         } finally {
            uut.popAlpha();
            var30.popMatrix();
         }
      } finally {
         uut.additive(false);
         var30.popMatrix();
         vdn.setRenderScale(1.0F);
      }

      if (var9 >= 1.0F && !this.jqf) {
         this.jqf = true;
         this.client.send(() -> this.client.setScreen(this.jpc));
      }
   }

   float jqs() {
      return (this.jql - 268.0F) * 0.5F;
   }

   float jqt() {
      return (this.jqm - 218.0F) * 0.5F + 4.0F;
   }

   void jqu(DrawContext var1, GpuTextureView var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = 14.0F;
      int var9 = this.jpf.accent;
      uut.shadow(var1, 0.0F, 6.0F, 268.0F, 218.0F, var8, 28.0F, jrm(0, 0.45F));
      this.jpd.frosted(var1, 0.0F, 0.0F, 268.0F, 218.0F, var8, var6, var7, this.jql, this.jqm, jrm(16777215, 1.0F));
      uut.round(var1, 0.0F, 0.0F, 268.0F, 218.0F, var8, jrm(658966, 0.52F));
      uut.gradient(
         var1, 0.0F, 0.0F, 268.0F, 60.0F, var8, var8, 0.0F, 0.0F, jrm(16777215, 0.06F), jrm(16777215, 0.06F), jrm(16777215, 0.0F), jrm(16777215, 0.0F)
      );
      uut.outlineGradientV(var1, 0.0F, 0.0F, 268.0F, 218.0F, var8, 0.7F, jrm(16777215, 0.28F), jrm(16777215, 0.06F));
      this.jqv(var1, var3, var4, var9);
      this.jqz(var1, var3, var4, var5, var9);
      this.jrc(var1, var2, var3, var4, var5, var9);
   }

   void jqv(DrawContext var1, float var2, float var3, int var4) {
      uut.round(var1, 14.0F, 13.0F, 22.0F, 22.0F, 7.0F, jrm(var4, 0.16F));
      uut.outline(var1, 14.0F, 13.0F, 22.0F, 22.0F, 7.0F, 0.6F, jrm(var4, 0.45F));
      vjf.draw(var1, vhz.ACCOUNTS, 25.0F, 24.0F, 12.0F, jrm(kce.mix(var4, 16777215, 0.3F), 1.0F));
      vdn var5 = veo.semibold(10.4F);
      var5.draw(
         var1,
         wap.s(a.d("ݵ绩\uf422樇\ue19d朠\udd7c咂쫛䁨재", -13408373, 1128620212), a.d("ボ䥆쏢嶝툨傅\ueadf挦ﵱ矁\uf010\u0a62蓀", -1804484324, -151063075)),
         44.0F,
         var5.centerTop(19.0F),
         jrm(16777215, 0.97F)
      );
      vdn var6 = veo.medium(6.4F);
      String var7 = this.client.getSession().getUsername();
      String var8 = wap.s(a.c(896021282, "㍹䫴쀪幃햄匲\ue968惞ﻀ瑣\uf3e3"), a.c(-194294653, "䢪ㄏ믐◟깿⢿隗ὼ"));
      float var9 = var6.width(var8);
      var6.draw(var1, var8, 44.0F, var6.centerTop(31.5F), jrm(16777215, 0.5F));
      uut.circle(var1, 44.0F + var9 + 3.0F, 31.5F, 2.0F, jrm(7268256, 0.95F));
      var6.draw(var1, var7, 44.0F + var9 + 8.0F, var6.centerTop(31.5F), jrm(16777215, 0.88F));
      float var10 = 246.0F;
      float var11 = 22.0F;
      float var12 = this.jpk.step(jrl(var2, var3, var10, var11) < 9.0F, this.jqj);
      uut.circle(var1, var10, var11, 8.5F, jrm(16777215, 0.05F + 0.1F * var12));
      vjf.draw(var1, vhz.CLOSE, var10, var11, 8.0F + var12, jrm(16777215, 0.6F + 0.4F * var12));
      vdn var13 = veo.medium(6.4F);
      String var14 = a.d("䬾㊫롲☒귘\u2b75鄺ᣂ蚏", 336940446, -1186396444);
      float var15 = var13.width(var14) + 22.0F;
      float var16 = var10 - 14.0F - var15;
      float var17 = var11 - 8.0F;
      float var18 = this.jpl.step(jrk(var2, var3, var16, var17, var15, 16.0F), this.jqj);
      uut.round(var1, var16, var17, var15, 16.0F, 8.0F, jrm(16777215, 0.05F + 0.08F * var18));
      uut.outline(var1, var16, var17, var15, 16.0F, 8.0F, 0.6F, jrm(kce.mix(16777215, var4, var18), 0.16F + 0.4F * var18));
      jqw(var1, var16 + 9.0F, var17 + 8.0F, 6.0F, var18);
      var13.draw(var1, var14, var16 + 15.0F, var13.centerTop(var17 + 8.0F), jrm(16777215, 0.75F + 0.25F * var18));
      uut.rect(var1, 12.0F, 45.5F, 244.0F, 0.6F, jrm(16777215, 0.08F));
   }

   static void jqw(DrawContext var0, float var1, float var2, float var3, float var4) {
      float var5 = var3 * 0.1F;
      float var6 = (var3 - var5) * 0.5F;
      float var7 = var1 - var3 * 0.5F;
      float var8 = var2 - var3 * 0.5F;
      float var9 = 0.75F + 0.25F * var4;
      uut.rect(var0, var7, var8, var6, var6, jrm(15880226, var9));
      uut.rect(var0, var7 + var6 + var5, var8, var6, var6, jrm(8370688, var9));
      uut.rect(var0, var7, var8 + var6 + var5, var6, var6, jrm(42223, var9));
      uut.rect(var0, var7 + var6 + var5, var8 + var6 + var5, var6, var6, jrm(16759040, var9));
   }

   float jqx() {
      return 52.0F;
   }

   float jqy() {
      return 116.0F;
   }

   void jqz(DrawContext var1, float var2, float var3, float var4, int var5) {
      float var6 = this.jqx();
      float var7 = this.jqy();
      float var8 = Math.max(0.0F, this.jph.size() * 32.0F - 4.0F - var7);
      this.jqc = Math.max(0.0F, Math.min(var8, this.jqc));
      this.jqb = this.jqb + (this.jqc - this.jqb) * (1.0F - (float)Math.exp(-this.jqj * 14.0F));
      boolean var9 = jrk(var2, var3, 10.0F, var6, 248.0F, var7);
      uut.pushScissor(var1, 6.0F, var6, 256.0F, var7);

      try {
         if (this.jph.isEmpty() && this.jpj.isEmpty()) {
            this.jra(var1, var6, var7, var5);
         }

         for (int var10 = this.jpj.size() - 1; var10 >= 0; var10--) {
            jop var11 = this.jpj.get(var10);
            if (var4 - var11.goneAt > 0.3F) {
               this.jpj.remove(var10);
            }
         }

         float var17 = var6 - this.jqb;

         for (jyi var12 : this.jph) {
            jop var13 = this.jpi.get(var12.handle());
            if (var13 != null) {
               if (var17 + 28.0F > var6 - 2.0F && var17 < var6 + var7 + 2.0F) {
                  this.jrb(var1, var13, 10.0F, var17, var2, var3, var9, var4, var5);
               }

               var17 += 32.0F;
            }
         }
      } finally {
         uut.popScissor(var1);
      }

      if (this.jqb > 0.5F) {
         uut.gradientV(var1, 8.0F, var6, 252.0F, 8.0F, 0.0F, jrm(658966, 0.35F), jrm(658966, 0.0F));
      }

      if (this.jqb < var8 - 0.5F) {
         uut.gradientV(var1, 8.0F, var6 + var7 - 8.0F, 252.0F, 8.0F, 0.0F, jrm(658966, 0.0F), jrm(658966, 0.35F));
      }
   }

   void jra(DrawContext var1, float var2, float var3, int var4) {
      float var5 = var2 + var3 * 0.5F;
      vjf.draw(var1, vhz.USER_PLUS, 134.0F, var5 - 12.0F, 18.0F, jrm(var4, 0.8F));
      vdn var6 = veo.semibold(8.0F);
      var6.drawCentered(
         var1,
         wap.s(a.b("ᘜ澌\ue510笠\uf0f5癄찛䗰\udbb4償훋⳩ꉧ㯊놈", -529787299), a.b("鋂\ueb59憊\ufff1瑕\uf29a䢶섻彨퇋切꡷⚤뼟ㅜ뎰৷虑", 1760532160)),
         134.0F,
         var6.centerTop(var5 + 6.0F),
         jrm(16777215, 0.9F)
      );
      vdn var7 = veo.medium(6.2F);
      var7.drawCentered(
         var1,
         wap.s(
            a.b("ㅚ䣆순屸ퟪ儚\ueb08抷ﳧ癚\uf181வ蔠Ზ雌ှꩩ◯뼝㥃낾쪫䑈\udf9b姳팴檇\ue485縗\uf86d珄贄ݜ", -236637905),
            a.d("ఞ疂ｖ慗\ueaf0氻혟寻솹䬍쳜㊷롽⇉ꮔⵦ錼ᣵ虞В跨\uf7bf礆\ue2d3擖\uee70取\udde2䜾셵䫗됑", -476670125, -1616273537)
         ),
         134.0F,
         var7.centerTop(var5 + 17.0F),
         jrm(16777215, 0.5F)
      );
   }

   void jrb(DrawContext var1, jop var2, float var3, float var4, float var5, float var6, boolean var7, float var8, int var9) {
      float var10 = 248.0F;
      float var11 = vcq.outCubic(vcq.clamp01((var8 - var2.bornAt) / 0.4F));
      if (!(var11 <= 0.0F)) {
         jyi var12 = var2.alt;
         boolean var13 = var12.name().equals(this.client.getSession().getUsername());
         boolean var14 = this.jpy == var12.handle();
         boolean var15 = var7 && this.jqe < 0.0F && jrk(var5, var6, var3, var4, var10, 28.0F);
         float var16 = var2.hover.step(var15 || var14, this.jqj);
         float var17 = var3 + var10 - 26.0F;
         float var18 = var17 - 52.0F;
         boolean var19 = var15 && jrk(var5, var6, var17, var4 + 5.0F, 20.0F, 18.0F);
         boolean var20 = var15 && !var19 && jrk(var5, var6, var18, var4 + 5.0F, 48.0F, 18.0F);
         float var21 = var2.binHover.step(var19, this.jqj);
         float var22 = var2.loginHover.step(var20, this.jqj);
         boolean var23 = this.jpz == var12.handle() && var8 - this.jqa < 2.5F;
         float var24 = vcq.clamp01((var8 - var2.pressAt) / 0.45F);
         Matrix3x2fStack var25 = var1.getMatrices();
         var25.pushMatrix();
         var25.translate((1.0F - var11) * 14.0F, 0.0F);
         uut.pushAlpha(var11);

         try {
            int var26 = var13 ? kce.mix(658966, var9, 0.12F) : 658966;
            uut.round(var1, var3, var4, var10, 28.0F, 9.0F, jrm(var26, 0.32F + 0.14F * var16));
            uut.round(var1, var3, var4, var10, 28.0F, 9.0F, jrm(16777215, 0.03F + 0.04F * var16));
            if (var24 < 1.0F) {
               float var27 = var10 * vcq.outCubic(var24);
               float var28 = Math.max(var3, var3 + var2.px - var27);
               float var29 = Math.min(var3 + var10, var3 + var2.px + var27);
               uut.round(var1, var28, var4, var29 - var28, 28.0F, 9.0F, jrm(var9, 0.18F * (1.0F - var24)));
            }

            uut.outline(var1, var3, var4, var10, 28.0F, 9.0F, 0.6F, jrm(var13 ? var9 : 16777215, var13 ? 0.45F + 0.2F * var16 : 0.06F + 0.14F * var16));
            uog.draw(var1, jre(var12), var3 + 6.0F, var4 + 5.0F, 18.0F, 4.5F, jrm(16777215, 1.0F));
            vdn var38 = veo.semibold(7.8F);
            var38.draw(var1, var12.name(), var3 + 31.0F, var38.centerTop(var4 + 10.5F), jrm(16777215, 0.96F));
            vdn var39 = veo.medium(5.8F);
            String var40 = var12.microsoft()
               ? wap.s(a.b("骞\ue30a槓\uf7a4籸䀹䂑쥡坺\udd5c娘ꀄ\u2ef7띌㴎믢Ʊ蹼ᓆ銅", 1303288518), a.d("种_諲ᓰ鼯ᦔꏈ⩎끾㩘봜䜀짳偈\uda0a峦\ue6b5楸\uf3c2疁", -1198349042, 559864012))
               : wap.s(a.c(306389843, "⌛媃큐丫엹䍏珞"), a.c(2011335486, "輦\uf6b0簛\ue21a榿\uef76唯"));
            float var30 = var39.width(var40);
            var39.draw(
               var1,
               var40,
               var3 + 31.0F,
               var39.centerTop(var4 + 19.5F),
               jrm(var12.microsoft() ? kce.mix(16777215, var9, 0.5F) : 16777215, var12.microsoft() ? 0.75F : 0.45F)
            );
            if (var13) {
               vdn var31 = veo.semibold(5.4F);
               String var32 = wap.s(a.b("ꘊ\udfbc唁쬗䃆왻簠", 327001668), a.b("䓓㥐랻⧁ꈥ⒡", -522829625));
               float var33 = var31.width(var32) + 8.0F;
               float var34 = var3 + 31.0F + Math.max(var38.width(var12.name()) + 6.0F, 0.0F);
               uut.round(var1, var34, var4 + 6.5F, var33, 8.0F, 4.0F, jrm(var9, 0.22F));
               var31.draw(var1, var32, var34 + 4.0F, var31.centerTop(var4 + 10.5F), jrm(kce.mix(var9, 16777215, 0.4F), 1.0F));
            }

            float var41 = !var14 && !var23 ? var16 : 1.0F;
            if (var41 > 0.01F) {
               uut.pushAlpha(var41);
               if (var14) {
                  kcb.draw(var1, null, var18 + 24.0F, var4 + 14.0F, 5.0F, 1.4F, var8, 0.0F, var9);
               } else {
                  uut.round(var1, var18, var4 + 5.0F, 48.0F, 18.0F, 9.0F, jrm(var9, 0.22F + 0.3F * var22));
                  uut.outline(var1, var18, var4 + 5.0F, 48.0F, 18.0F, 9.0F, 0.6F, jrm(var9, 0.5F + 0.4F * var22));
                  vjf.draw(var1, vhz.LOGIN, var18 + 11.0F, var4 + 14.0F, 7.5F, jrm(16777215, 0.9F));
                  vdn var42 = veo.semibold(6.4F);
                  var42.draw(
                     var1,
                     wap.s(a.c(-59138225, "鼛\ue690汍\uf235禬ｔ䔀"), a.d("情ᥘ鎌ආ蘫", -1788170782, -1794586320)),
                     var18 + 18.0F,
                     var42.centerTop(var4 + 14.0F),
                     jrm(16777215, 0.95F)
                  );
               }

               int var43 = 16739179;
               uut.round(var1, var17, var4 + 5.0F, 20.0F, 18.0F, 9.0F, jrm(var43, (var23 ? 0.35F : 0.06F) + 0.2F * var21));
               vjf.draw(
                  var1,
                  var23 ? vhz.CHECK : vhz.TRASH,
                  var17 + 10.0F,
                  var4 + 14.0F,
                  8.0F,
                  jrm(kce.mix(16777215, var43, Math.max(var21, var23 ? 1.0F : 0.0F)), 0.7F + 0.3F * var21)
               );
               uut.popAlpha();
            }

            if (var23) {
               vdn var44 = veo.medium(5.6F);
               var44.drawRight(
                  var1,
                  wap.s(a.c(1388565725, "품괎⟕릦㉨듊ໃ"), a.b("ꇽ\ud85b劌쳶䜢쇩箴\uf636", -1770871338)),
                  var18 - 4.0F,
                  var44.centerTop(var4 + 14.0F),
                  jrm(16747146, 0.95F)
               );
            }
         } finally {
            uut.popAlpha();
            var25.popMatrix();
         }
      }
   }

   void jrc(DrawContext var1, GpuTextureView var2, float var3, float var4, float var5, int var6) {
      float var7 = 184.0F;
      float var8 = 12.0F;
      float var9 = 22.0F;
      float var10 = 244.0F - 2.0F * (var9 + 6.0F);
      float var11 = this.jpp.step(var5 - this.jpx < 4.5F && !this.jpv.isEmpty(), this.jqj);
      if (var11 > 0.01F) {
         vdn var12 = veo.medium(6.2F);
         uut.pushAlpha(var11);
         float var13 = var7 - 9.0F + (1.0F - var11) * 3.0F;
         uut.circle(var1, var8 + 3.0F, var13, 1.8F, jrm(this.jpw, 0.95F));
         var12.draw(var1, var12.ellipsize(this.jpv, 228.0F), var8 + 9.0F, var12.centerTop(var13), jrm(kce.mix(16777215, this.jpw, 0.35F), 0.92F));
         uut.popAlpha();
      }

      float var20 = var5 - this.jps < 0.4F ? (float)Math.sin((var5 - this.jps) * 50.0F) * 3.0F * (1.0F - (var5 - this.jps) / 0.4F) : 0.0F;
      float var21 = this.jpo.step(this.jpr, this.jqj);
      float var14 = var7;
      boolean var15 = joz.matcher(this.jpq).matches();
      uut.round(var1, var8 + var20, var14, var10, var9, var9 * 0.5F, jrm(329741, 0.4F + 0.12F * var21));
      uut.outline(var1, var8 + var20, var14, var10, var9, var9 * 0.5F, 0.7F, jrm(kce.mix(16777215, var6, var21), 0.12F + 0.4F * var21));
      vjf.draw(var1, vhz.PLAYER, var8 + var20 + 12.0F, var14 + var9 * 0.5F, 8.5F, jrm(16777215, 0.45F + 0.3F * var21));
      vdn var16 = veo.medium(7.2F);
      float var17 = var8 + var20 + 22.0F;
      if (this.jpq.isEmpty()) {
         var16.draw(
            var1,
            wap.s(a.d("믠쉺䢻횝崅\udbbd懮\ue815癏ﳹ笡脕ྌ防ᱭ骔", -1371542404, 1293768642), a.d("ᡎ懚\ueb0b煠ﺣ砝숺侤헦彔\ud88b⋶갬㖐믝㤼荹ನ阑ဳ馺\ue394浕", 1758637937, 177713973)),
            var17,
            var16.centerTop(var14 + var9 * 0.5F),
            jrm(16777215, 0.32F)
         );
      } else {
         var16.draw(var1, this.jpq, var17, var16.centerTop(var14 + var9 * 0.5F), jrm(16777215, var15 ? 0.95F : 0.8F));
      }

      if (this.jpr && (int)(var5 * 2.0F) % 2 == 0) {
         float var18 = var17 + (this.jpq.isEmpty() ? 0.0F : var16.width(this.jpq) + 0.8F);
         uut.rect(var1, var18, var14 + 6.0F, 0.8F, var9 - 12.0F, jrm(var6, 0.95F));
      }

      if (!this.jpq.isEmpty()) {
         vdn var22 = veo.medium(5.6F);
         var22.drawRight(
            var1,
            this.jpq.length() + a.c(1695022765, "ﺁ蜮\u0dfa"),
            var8 + var20 + var10 - 10.0F,
            var22.centerTop(var14 + var9 * 0.5F),
            jrm(var15 ? 16777215 : 16747146, var15 ? 0.35F : 0.8F)
         );
      }

      float var23 = var8 + var10 + 6.0F;
      this.jrd(var1, var23, var14, var9, vhz.DICE, this.jpn.step(jrk(var3, var4, var23, var14, var9, var9), this.jqj), this.jpu, var5, 16777215, var6, false);
      float var19 = var23 + var9 + 6.0F;
      this.jrd(var1, var19, var14, var9, vhz.PLUS, this.jpm.step(jrk(var3, var4, var19, var14, var9, var9), this.jqj), this.jpt, var5, var6, var6, var15);
   }

   void jrd(DrawContext var1, float var2, float var3, float var4, vhz var5, float var6, float var7, float var8, int var9, int var10, boolean var11) {
      float var12 = vcq.clamp01((var8 - var7) / 0.4F);
      float var13 = var12 < 1.0F ? (float)Math.sin(Math.PI * vcq.clamp01(var12 * 2.4F)) : 0.0F;
      Matrix3x2fStack var14 = var1.getMatrices();
      var14.pushMatrix();
      var14.translate(var2 + var4 * 0.5F, var3 + var4 * 0.5F);
      float var15 = 1.0F + 0.06F * var6 - 0.1F * var13;
      var14.scale(var15, var15);
      float var16 = var4 * 0.5F;
      uut.round(var1, -var16, -var16, var4, var4, var16, jrm(var11 ? var10 : 16777215, (var11 ? 0.3F : 0.06F) + 0.14F * var6));
      uut.outline(var1, -var16, -var16, var4, var4, var16, 0.7F, jrm(kce.mix(16777215, var10, var6), 0.14F + 0.4F * var6));
      if (var12 < 1.0F) {
         uut.outline(
            var1,
            -var16 - 6.0F * var12,
            -var16 - 6.0F * var12,
            var4 + 12.0F * var12,
            var4 + 12.0F * var12,
            var16 + 6.0F * var12,
            0.8F,
            jrm(var10, 0.6F * (1.0F - var12))
         );
      }

      vjf.draw(var1, var5, 0.0F, 0.0F, 10.0F, jrm(kce.mix(var9, 16777215, 0.3F + 0.7F * var6), 0.85F + 0.15F * var6));
      var14.popMatrix();
   }

   static SkinTextures jre(jyi var0) {
      UUID var1 = var0.skin() != null ? var0.skin() : var0.uuid();
      SkinTextures var2 = jpa.get(var1);
      if (var2 != null) {
         return var2;
      }

      SkinTextures var3 = DefaultSkinHelper.getSkinTextures(var1);
      if (var0.microsoft() && !jpb.containsKey(var1)) {
         MinecraftClient var4 = MinecraftClient.getInstance();
         jpb.put(
            var1,
            CompletableFuture.<GameProfile>supplyAsync(() -> {
                  ProfileResult var2x = var4.getApiServices().sessionService().fetchProfile(var1, false);
                  return var2x != null ? var2x.profile() : null;
               })
               .thenCompose(var1x -> var1x == null ? CompletableFuture.completedFuture(Optional.empty()) : var4.getSkinProvider().fetchSkinTextures(var1x))
               .thenAcceptAsync(var1x -> var1x.ifPresent(var1xx -> jpa.put(var1, var1xx)), var4)
               .exceptionally(var0x -> null)
         );
      }

      return var3;
   }

   void jrf(String var1, int var2) {
      this.jpv = var1;
      this.jpw = var2;
      this.jpx = kap.clock();
   }

   void jrg() {
      this.jpt = kap.clock();
      String var1 = this.jpq.trim();
      if (!joz.matcher(var1).matches()) {
         this.jps = kap.clock();
         this.jrf(
            wap.s(
               a.c(-1785022126, "뤰샠䩽퐃忘\ud961捷\ueacf璊﹨禨菇ഌ钺ỿ顂∄귄㝷넷㣗䊇챫垶톍孑\ue2ec河\uf659瀏ﯯձ輣 邬"),
               a.d("ॻ烯慨恏\ueb82洠흭庀샘䩿짍㏅봖⒩껶⠂鉈ᶕ茸ե袉\uf2d3簒\ue7b9懃\ueb17勚\udcfd䈖쑋䮞딱㼂꛷₯깵ᖺ鯓ᵿ", -1431350642, 1595301839)
            ),
            16747146
         );
      } else if (!jyw.addOffline(var1)) {
         this.jps = kap.clock();
         this.jrf(
            wap.s(
               a.b("ꁨ\ud9e5匿쵛䛘쀧穻\uf386淑\ue725悿體ᑐ趠߾脑㭉뒜⸪ꡦ⇈寖핤任죐䈝ﮣ疷\uef0c楘\ue2f1ᰧ", -755392484),
               a.d("细ݥ趼Ꮙ頙᪱꓿ⴋ덖㷽빍䑉쪝圹\ud97f忺\ue5b6橩\uf4b6盵\ufb10蔠௭逻ᘽ鲗┫", 1882658531, -894407652)
            ),
            16762475
         );
      } else {
         this.jpq = "";
         this.jqr(kap.clock(), false);
         float var2 = Math.max(0.0F, this.jph.size() * 32.0F - 4.0F - this.jqy());
         this.jqc = var2;
         this.jrf(wap.s(a.c(69171204, "硃Ǘ謄ᕴ麢ᡗ"), a.b("惧\u197c鎠ැ蘅½뫠㌙\ua95b", 749823226)) + var1, 7268256);
      }
   }

   void jrh() {
      this.jpu = kap.clock();
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      String var2 = jqn[var1.nextInt(jqn.length)] + jqo[var1.nextInt(jqo.length)];
      if (var1.nextBoolean()) {
         var2 = var2 + var1.nextInt(10, 999);
      }

      this.jpq = var2.length() > 16 ? var2.substring(0, 16) : var2;
      this.jpr = true;
   }

   void jri(jop var1) {
      if (this.jpy == null) {
         if (jyw.disabled()) {
            this.jrf(
               wap.s(
                  a.b("ҵ紌\uf7cd槏\ue251擺\udefa坘줃䎬쑢㸄냘⥤ꌶ▃龃ၛ諨\u0cff蔀０熾\uea68汄\ue6c6彣턣䯔춘䘬룴㊯ꬄ", 1690240222),
                  a.c(129404169, "赟\uf4e6縧\ue025濠\ue928匊\udafa䓐침䧉뎰㥺ꃃ⺊걩ሳ鷤ݚ蔕ࣿ犣ﱡ枳\ue1ce歡틕岇왺䁞쾁")
               ),
               16747146
            );
         } else {
            this.jpy = var1.alt.handle();
            this.jrf(
               wap.s(a.c(2050613755, "\ue1a6頭ደ貈ݘ臮㮴눂Ⱄꚢℿ\udb0f嗊차"), a.d("鏚\uea3c悔ﻯ然\uf79d", 946269895, 1277458697))
                  + var1.alt.name()
                  + a.d("臽\uf84c犟", -223333102, -1585007422),
               this.jpf.accent
            );
            jyw.login(var1.alt, new jyv() {
               @Override
               public void stage(String var1) {
                  if (jos.this.jpy != null) {
                     jos.this.jrf(var1, jos.this.jpf.accent);
                  }
               }

               @Override
               public void done(String var1) {
                  jos.this.jpy = null;
                  jos.this.jrf(wap.s(a.d("⚨弯헦䯂쁔䛶ﲲ甆", -805242001, 993648022), a.b("咶ⵞꏦ㦅뉞㒙躹\u074b鴌Ꭷ鑾清\ue4c8", -483176279)) + var1, 7268256);
               }

               @Override
               public void failed(String var1) {
                  jos.this.jpy = null;
                  jos.this.jrf(var1, 16747146);
               }
            });
         }
      }
   }

   @Override
   public void close() {
      if (this.jqe < 0.0F) {
         this.jqe = kap.clock();
      }
   }

   @Override
   public boolean mouseClicked(Click click, boolean doubled) {
      if (this.jqe >= 0.0F) {
         return true;
      }

      float var3 = (float)click.x() / this.jqk - this.jqs();
      float var4 = (float)click.y() / this.jqk - this.jqt();
      if (click.button() != 0) {
         return true;
      }

      float var5 = kap.clock();
      if (!jrk(var3, var4, 0.0F, 0.0F, 268.0F, 218.0F)) {
         this.close();
         return true;
      }

      if (jrl(var3, var4, 246.0F, 22.0F) < 9.0F) {
         this.close();
         return true;
      }

      vdn var6 = veo.medium(6.4F);
      float var7 = var6.width(a.d("⌀媕큌丬엦䍋滑烼\ueeb1", 171419603, -2096659305)) + 22.0F;
      if (jrk(var3, var4, 232.0F - var7, 14.0F, var7, 16.0F)) {
         jyw.openOriginal(this);
         return true;
      }

      float var8 = 184.0F;
      float var9 = 22.0F;
      float var10 = 244.0F - 2.0F * (var9 + 6.0F);
      this.jpr = jrk(var3, var4, 12.0F, var8, var10, var9) || this.jpr && !jrk(var3, var4, 10.0F, this.jqx(), 248.0F, this.jqy());
      if (jrk(var3, var4, 12.0F + var10 + 6.0F, var8, var9, var9)) {
         this.jrh();
         return true;
      }

      if (jrk(var3, var4, 12.0F + var10 + 12.0F + var9, var8, var9, var9)) {
         this.jrg();
         return true;
      }

      if (jrk(var3, var4, 10.0F, this.jqx(), 248.0F, this.jqy())) {
         float var11 = this.jqx() - this.jqb;

         for (jyi var13 : this.jph) {
            jop var14 = this.jpi.get(var13.handle());
            if (var14 != null && jrk(var3, var4, 10.0F, var11, 248.0F, 28.0F)) {
               float var15 = 232.0F;
               if (jrk(var3, var4, var15, var11 + 5.0F, 20.0F, 18.0F)) {
                  if (this.jpz == var13.handle() && var5 - this.jqa < 2.5F) {
                     this.jpz = null;
                     jyw.remove(var13);
                     this.jqr(var5, false);
                     this.jrf(wap.s(a.c(-1247646000, "溊ᜌ鷗Τ衪່뒚㴯"), a.c(25662220, "霨\uee8e摙﨣熞\uf743䤍")) + var13.name(), 16762475);
                  } else {
                     this.jpz = var13.handle();
                     this.jqa = var5;
                  }
               } else {
                  var14.pressAt = var5;
                  var14.px = var3 - 10.0F;
                  this.jri(var14);
               }

               return true;
            }

            var11 += 32.0F;
         }
      }

      return true;
   }

   @Override
   public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
      this.jqc -= (float)verticalAmount * 32.0F;
      return true;
   }

   @Override
   public boolean charTyped(CharInput input) {
      if (this.jpr && !(this.jqe >= 0.0F)) {
         String var2 = input.asString();
         StringBuilder var3 = new StringBuilder(this.jpq);

         for (char var7 : var2.toCharArray()) {
            if (var3.length() < 16 && (Character.isLetterOrDigit(var7) || var7 == '_') && var7 < 128) {
               var3.append(var7);
            }
         }

         this.jpq = var3.toString();
         return true;
      } else {
         return true;
      }
   }

   @Override
   public boolean keyPressed(KeyInput input) {
      int var2 = input.key();
      if (var2 == 256) {
         this.close();
         return true;
      }

      if (!this.jpr) {
         return true;
      }

      boolean var3 = (input.modifiers() & 10) != 0;
      switch (var2) {
         case 86:
            if (var3) {
               this.jrj();
            }
            break;
         case 257:
         case 335:
            this.jrg();
            break;
         case 259:
            if (var3) {
               this.jpq = "";
            } else if (!this.jpq.isEmpty()) {
               this.jpq = this.jpq.substring(0, this.jpq.length() - 1);
            }
      }

      return true;
   }

   void jrj() {
      String var1 = this.client.keyboard.getClipboard();
      StringBuilder var2 = new StringBuilder(this.jpq);

      for (char var6 : var1.toCharArray()) {
         if (var2.length() < 16 && (Character.isLetterOrDigit(var6) || var6 == '_') && var6 < 128) {
            var2.append(var6);
         }
      }

      this.jpq = var2.toString();
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
      this.jpd.close();
      vdn.setRenderScale(1.0F);
   }

   static boolean jrk(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var1 >= var3 && var0 < var2 + var4 && var1 < var3 + var5;
   }

   static float jrl(float var0, float var1, float var2, float var3) {
      float var4 = var0 - var2;
      float var5 = var1 - var3;
      return (float)Math.sqrt(var4 * var4 + var5 * var5);
   }

   static int jrm(int var0, float var1) {
      return kce.rgba(var0, var1);
   }
}
