package flow.splash;

import a.jte;
import a.jza;
import a.jzh;
import a.kam;
import a.kap;
import a.kbp;
import a.kbs;
import a.kce;
import a.kct;
import a.unf;
import a.unm;
import a.uok;
import a.upt;
import a.uut;
import a.vcq;
import a.vdn;
import a.veo;
import a.vvi;
import a.wap;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.resource.ResourceReload;
import org.joml.Matrix3x2fStack;

public final class FlowSplash extends SplashOverlay {
   private static final float EM = 36.0F;
   private static final float INTRO_IN = 0.3F;
   private static final float MARK_OUT = 0.45F;
   private static final float WELCOME_AT = 0.3F;
   private static final float LETTERS_AT = 0.55F;
   private static final float LETTER_STEP = 0.06F;
   private static final float LETTER_TIME = 0.8F;
   private static final float WELCOME_HOLD = 3.2F;
   private static final float INTRO_OUT = 1.1F;
   private static final float RELOAD_IN = 0.35F;
   private static final float RELOAD_MIN = 1.1F;
   private static final float RELOAD_OUT = 0.55F;
   private static final float DONE_TIME = 0.45F;
   private static final float LOGO_SIZE = 0.62F;
   private static final float LOGO_Y = 0.42F;
   private static Wordmark mark;
   private static final List<Wordmark> RETIRED = new ArrayList<>();
   private static final List<Long> RETIRED_AT = new ArrayList<>();
   private static kap scene;
   private final MinecraftClient mc;
   private final ResourceReload reload;
   private final Consumer<Optional<Throwable>> handler;
   private final boolean reloading;
   private final float minShow;
   private final kam look = new kam();
   private boolean injected;
   private final boolean fadeIn;
   private final long bornNanos = System.nanoTime();
   private long lastNanos;
   private float anim;
   private float progress;
   private float completedAt = -1.0F;
   private float doneAt = -1.0F;
   private float welcomeAt = -1.0F;
   private float outroAt = -1.0F;
   private float parX;
   private float parY;
   private float vh = 270.0F;
   private boolean broken;
   private boolean finished;
   private Intro intro;
   private boolean introFailed;
   private boolean handedOver;
   private boolean returning;

   FlowSplash(MinecraftClient mc, ResourceReload reload, Consumer<Optional<Throwable>> handler, boolean reloading, boolean injected) {
      super(mc, reload, handler, reloading);
      this.mc = mc;
      this.reload = reload;
      this.handler = handler;
      this.reloading = reloading;
      this.injected = injected;
      this.fadeIn = injected;
      this.returning = wap.chosen();
      float hold = 0.0F;

      try {
         hold = Float.parseFloat(System.getProperty("flow2.splash.hold", "0"));
      } catch (NumberFormatException var8) {
      }

      this.minShow = hold;
      jzh.preload(kbs.selected().key);
      if (injected) {
         Intro.preload();
      }
   }

   void markInjected() {
      if (!this.injected) {
         this.injected = true;
         this.welcomeAt = -1.0F;
         this.outroAt = -1.0F;
         Intro.preload();
      }
   }

   public void method_74217() {
      if (!(this.completedAt >= 0.0F) && this.reload.method_18787()) {
         if (!this.reloading || !(this.anim < 0.6F)) {
            try {
               this.reload.method_18849();
               this.handler.accept(Optional.empty());
            } catch (Throwable var2) {
               this.handler.accept(Optional.of(var2));
            }

            this.completedAt = this.anim;
            this.returning = wap.chosen();
            if (this.mc.field_1755 != null) {
               this.mc.field_1755.method_25423(this.mc.method_22683().method_4486(), this.mc.method_22683().method_4502());
            }
         }
      }
   }

   public void method_25394(DrawContext ctx, int mouseX, int mouseY, float delta) {
      ClientLoad.frame();
      long now = System.nanoTime();
      float dt = this.lastNanos == 0L ? 0.0F : Math.min(0.033333335F, (float)(now - this.lastNanos) / 1.0E9F);
      this.lastNanos = now;
      this.anim += dt;
      float age = this.anim;
      float target = this.completedAt >= 0.0F ? 1.0F : Math.max(this.progress, this.reload.method_18229());
      this.progress = this.progress + (target - this.progress) * (1.0F - (float)Math.exp(-dt * 6.0F));
      if (this.completedAt >= 0.0F && this.doneAt < 0.0F && age >= 0.35F) {
         this.doneAt = age;
      }

      if (!this.injected || this.introFailed || !this.introFrame(ctx, mouseX, mouseY, delta, dt, now)) {
         if (this.injected && !this.returning) {
            if (this.doneAt >= 0.0F && this.welcomeAt < 0.0F && age >= this.doneAt + 0.45F + 0.1F) {
               this.welcomeAt = age;
            }

            if (this.welcomeAt >= 0.0F && this.outroAt < 0.0F && age >= Math.max(this.minShow, this.welcomeAt + 3.2F)) {
               this.outroAt = age;
            }
         } else {
            float min = Math.max(this.minShow, 1.1F);
            if (this.doneAt >= 0.0F && this.outroAt < 0.0F && age >= Math.max(min, this.doneAt + 0.45F + 0.15F)) {
               this.outroAt = age;
            }
         }

         float outTime = this.injected && !this.returning ? 1.1F : 0.55F;
         float out = this.outroAt >= 0.0F ? vcq.clamp01((age - this.outroAt) / outTime) : 0.0F;
         float alpha;
         if (this.injected && !this.returning) {
            float real = (float)(now - this.bornNanos) / 1.0E9F;
            alpha = this.fadeIn ? vcq.inOutCubic(vcq.clamp01(real / 0.3F)) : 1.0F;
         } else {
            float in = this.reloading ? vcq.inOutCubic(age / 0.35F) : 1.0F;
            alpha = in * (1.0F - vcq.inOutCubic(out));
         }

         if (alpha < 0.999F && this.mc.field_1755 != null) {
            Screen var10000 = this.mc.field_1755;
            DrawContext var10001 = ctx;
            int var10002 = mouseX;
            int var10003 = mouseY;
            float var10004 = delta;

            try {
               var10000.method_47413(var10001, var10002, var10003, var10004);
            } catch (Throwable var15) {
            }

            this.mc.field_1705.method_72738();
         }

         ctx.method_71048();
         if (!this.broken) {
            try {
               this.scene(ctx, mouseX, mouseY, age, dt, alpha, out);
            } catch (Throwable var14) {
               this.broken = true;
               System.out.println("splash render failed, plain fallback: " + var14);
               var14.printStackTrace();
            }
         }

         if (this.broken) {
            this.plain(ctx, alpha);
         }

         if (out >= 1.0F && !this.finished) {
            this.finished = true;
            if (this.injected && !this.returning) {
               Screen back = this.mc.field_1687 != null ? this.mc.field_1755 : null;
               this.mc.method_1507(new kct(back));
            }

            this.mc.method_18502(null);
         }
      }
   }

   private boolean introFrame(DrawContext ctx, int mouseX, int mouseY, float delta, float dt, long now) {
      if (this.intro == null) {
         this.intro = Intro.create();
         if (this.intro == null) {
            if (Intro.unavailable()) {
               this.introFailed = true;
               return false;
            }

            if (this.mc.field_1755 != null) {
               Screen var14 = this.mc.field_1755;
               DrawContext var15 = ctx;
               int var16 = mouseX;
               int var17 = mouseY;
               float var18 = delta;

               try {
                  var14.method_47413(var15, var16, var17, var18);
               } catch (Throwable var12) {
               }
            }

            return true;
         }
      }

      this.intro.loading(this.completedAt >= 0.0F ? 1.0F : this.progress);
      this.intro.step(dt, this.completedAt >= 0.0F);
      if (this.intro.dissolving() && !this.handedOver) {
         this.handedOver = true;
         this.handOver();
      }

      float fade = this.fadeIn ? vcq.inOutCubic(vcq.clamp01((float)(now - this.bornNanos) / 1.0E9F / 0.3F)) : 1.0F;
      if (fade * this.intro.layer() < 0.999F && this.mc.field_1755 != null) {
         Screen var10000 = this.mc.field_1755;
         DrawContext var10001 = ctx;
         int var10002 = mouseX;
         int var10003 = mouseY;
         float var10004 = delta;

         try {
            var10000.method_47413(var10001, var10002, var10003, var10004);
         } catch (Throwable var13) {
         }

         this.mc.field_1705.method_72738();
      }

      ctx.method_71048();
      uut.beginFrame();
      unf.observe(ctx);
      collect();
      int width = ctx.method_51421();
      int height = ctx.method_51443();
      if (!this.intro.render(ctx, width, height, fade)) {
         this.intro.close();
         this.intro = null;
         this.introFailed = true;
         if (this.handedOver && !this.finished) {
            this.finished = true;
            this.mc.method_18502(null);
            return true;
         } else {
            return false;
         }
      } else {
         float wait = this.intro.waiting();
         if (wait > 0.01F) {
            this.introCaption(ctx, width, height, wait);
         }

         if (this.intro.finished() && !this.finished) {
            this.finished = true;
            this.intro.close();
            this.mc.method_18502(null);
         }

         return true;
      }
   }

   private void handOver() {
      this.returning = wap.chosen();
      if (!this.returning) {
         Screen back = this.mc.field_1687 != null ? this.mc.field_1755 : null;
         this.mc.method_1507(new kct(back));
      } else if (this.mc.field_1755 instanceof TitleScreen && Splash.MENU) {
         this.mc.method_1507(new jte());
      }
   }

   private void introCaption(DrawContext ctx, int width, int height, float alpha) {
      String stage = ClientLoad.stage();
      if (!stage.isEmpty()) {
         float s = kbp.scale(width, height);
         float y = (float)(this.intro.captionY() / Math.max(1.0, (double)this.mc.method_22683().method_4495())) / s;
         Matrix3x2fStack m = ctx.method_51448();
         m.pushMatrix();
         m.scale(s, s);
         vdn.setRenderScaleStepped(s);

         try {
            vdn font = veo.medium(5.2F);
            float tracking = 1.7F;
            String head = stage.toUpperCase(Locale.ROOT);
            String tail = Math.round(vcq.clamp01(this.progress) * 100.0F) + "%";
            String sep = "   ·   ";
            float known = this.intro.known();
            float hw = font.width(head, tracking);
            float tw = font.width(sep + tail, tracking) * known;
            float x = width / s * 0.5F - (hw + tw) * 0.5F;
            float top = font.centerTop(y);
            font.drawTracked(ctx, head, x, top, rgba(16777215, 0.42F * alpha), tracking);
            if (known > 0.01F) {
               font.drawTracked(ctx, sep + tail, x + hw, top, rgba(16777215, 0.42F * alpha * known), tracking);
            }
         } finally {
            m.popMatrix();
            vdn.setRenderScale(1.0F);
         }
      }
   }

   private void scene(DrawContext ctx, int mouseX, int mouseY, float age, float dt, float alpha, float out) {
      uut.beginFrame();
      unf.observe(ctx);
      collect();
      int width = ctx.method_51421();
      int height = ctx.method_51443();
      if (width > 0 && height > 0 && !(alpha <= 0.002F)) {
         float s = kbp.scale(width, height);
         float vw = width / s;
         this.vh = height / s;
         float k = 1.0F - (float)Math.exp(-dt * 2.5F);
         if (mouseX >= 0 && mouseY >= 0 && mouseX <= width && mouseY <= height) {
            this.parX = this.parX + ((float)mouseX / width - 0.5F - this.parX) * k;
            this.parY = this.parY + ((float)mouseY / height - 0.5F - this.parY) * k;
         }

         float ppu = s * Math.max(1.0F, (float)this.mc.method_22683().method_4495());
         GpuTextureView glow = unm.view();
         if (scene == null) {
            scene = new kap();
         }

         uut.pushAlpha(alpha);
         Matrix3x2fStack m = ctx.method_51448();

         try {
            this.background(ctx, width, height, age, out);
            m.pushMatrix();
            m.scale(s, s);
            vdn.setRenderScaleStepped(s);

            try {
               if (this.injected && !this.returning) {
                  this.intro(ctx, glow, vw, age, ppu, out);
               } else {
                  this.reloadMark(ctx, glow, vw, age, 0.0F);
               }
            } finally {
               m.popMatrix();
               vdn.setRenderScale(1.0F);
            }
         } finally {
            uut.popAlpha();
            uut.additive(false);
         }
      }
   }

   private void background(DrawContext ctx, int width, int height, float age, float out) {
      uut.rect(ctx, 0.0F, 0.0F, width, height, -16250094);
      kbs season = kbs.selected();
      jza art = jzh.get(season.key);
      if (art != null) {
         float w = this.injected && !this.returning && this.welcomeAt >= 0.0F ? vcq.inOutCubic(vcq.clamp01((age - this.welcomeAt) / 1.6F)) : 0.0F;
         float o = this.injected && !this.returning ? vcq.inOutCubic(out) : 0.0F;
         this.look.time = kap.clock();
         this.look.zoom = 1.06F;
         this.look.panX = -this.parX * 0.01F * (1.0F - o);
         this.look.panY = -this.parY * 0.008F * (1.0F - o);
         this.look.blur = lerp(lerp(0.6F, 0.3F, w), 1.0F, o);
         this.look.dim = lerp(lerp(0.32F, 0.24F, w), 0.22F, o);
         if (art.logo()) {
            float rise = this.injected && !this.returning && this.welcomeAt >= 0.0F ? vcq.inOutCubic(vcq.clamp01((age - this.welcomeAt) / 0.8F)) : 0.0F;
            float size = lerp(lerp(0.62F, 0.5F, rise), 0.92F, o);
            float fy = lerp(lerp(0.42F, 0.33F, rise), 0.5F, o);
            float aspect = (float)width / height;
            this.look.logoF(0.5F - this.parX * 0.008F * (1.0F - o), fy - this.parY * 0.006F * (1.0F - o), size, aspect);
            this.look.blur = o;
            this.look.dim = lerp(0.0F, 0.22F, o);
         }

         this.look.tint = season.tint;
         this.look.tintAmount = 0.3F;
         this.look.fall = null;
         this.look.pool = null;
         scene.draw(ctx, art, this.look, width, height, 1.0F, false);
      }
   }

   private void intro(DrawContext ctx, GpuTextureView glow, float vw, float age, float ppu, float out) {
      float leave = this.welcomeAt >= 0.0F ? vcq.clamp01((age - this.welcomeAt) / 0.45F) : 0.0F;
      if (leave < 1.0F) {
         this.reloadMark(ctx, glow, vw, age, leave);
      }

      if (!(this.welcomeAt < 0.0F)) {
         float t = age - this.welcomeAt;
         kbs season = kbs.selected();
         int accent = season.accent;
         int face = season.light ? 1842982 : 16777215;
         float o = vcq.inOutCubic(out);
         float settle = vcq.outCubic(vcq.clamp01(t / 1.1F));
         float base = season.logo() ? 0.555F : 0.44F;
         float cy = this.vh * base - this.parY * 3.0F - o * 10.0F - (1.0F - settle) * 12.0F;
         float cx = vw * 0.5F - this.parX * 4.0F;
         uut.pushAlpha(1.0F - vcq.clamp01(out * 1.4F));

         try {
            uut.shadow(ctx, cx - 134.0F, cy - 32.0F, 268.0F, 72.0F, 32.0F, 54.0F, rgba(season.light ? 16777215 : 132363, 0.34F * vcq.clamp01(t / 0.6F)));
            welcome(ctx, cx, cy - 27.0F, t, accent, face);
            Wordmark wm = wordmark(ppu);
            Matrix3x2fStack m = ctx.method_51448();
            m.pushMatrix();
            m.translate(cx, cy);
            float sc = (1.0F + 0.05F * o) * (1.0F + 0.03F * (1.0F - settle));
            m.scale(sc, sc);

            try {
               this.letters(ctx, wm, glow, t, accent, face);
            } finally {
               m.popMatrix();
            }
         } finally {
            uut.popAlpha();
         }
      }
   }

   private static void welcome(DrawContext ctx, float cx, float y, float age, int accent, int face) {
      float p = vcq.clamp01((age - 0.3F) / 0.8F);
      if (!(p <= 0.0F)) {
         float e = vcq.outCubic(p);
         vdn f = veo.medium(8.6F);
         String text = wap.chosen() && !wap.ru() ? "WELCOME TO" : "ДОБРО ПОЖАЛОВАТЬ В";
         float tracking = 2.4F + 5.0F * (1.0F - e);
         float w = f.width(text, tracking);
         int ink = face == 16777215 ? 15135487 : face;
         f.drawTracked(ctx, text, cx - w * 0.5F, f.centerTop(y + (1.0F - e) * 10.0F), rgba(ink, 0.9F * e), tracking);
         float len = 26.0F * vcq.outCubic(vcq.clamp01((age - 0.3F - 0.25F) / 0.9F));
         if (len > 0.5F) {
            float gap = 8.0F;
            int c = kce.mix(accent, face, 0.35F);
            uut.gradientH(ctx, cx - w * 0.5F - gap - len, y - 0.35F, len, 0.7F, 0.35F, rgba(c, 0.0F), rgba(c, 0.8F * e));
            uut.gradientH(ctx, cx + w * 0.5F + gap, y - 0.35F, len, 0.7F, 0.35F, rgba(c, 0.8F * e), rgba(c, 0.0F));
         }
      }
   }

   private void letters(DrawContext ctx, Wordmark wm, GpuTextureView glow, float age, int accent, int face) {
      float ox = -wm.width * 0.5F;
      float base = wm.cap * 0.5F;
      float settled = 0.55F + wm.glyphs.length * 0.06F + 0.8F;

      for (int pass = 0; pass < 5; pass++) {
         if (pass == 1 || pass == 4) {
            uut.additive(true);
         }

         for (int i = 0; i < wm.glyphs.length; i++) {
            Wordmark.Glyph g = wm.glyphs[i];
            float p = vcq.clamp01((age - 0.55F - i * 0.06F) / 0.8F);
            if (!(p <= 0.0F)) {
               float a = smooth(0.0F, 0.4F, p);
               float sharp = smooth(0.2F, 0.85F, p);
               float sx = 0.0F;
               float sy = 0.0F;
               uok tex;
               int tint;
               switch (pass) {
                  case 0:
                     tex = g.soft();
                     tint = rgba(66314, 0.55F * a);
                     sx = 0.5F;
                     sy = 1.8F;
                     break;
                  case 1:
                     tex = g.soft();
                     tint = rgba(accent, (0.22F + 0.07F * (float)Math.sin(age * 1.7F + i * 0.45F)) * a);
                     break;
                  case 2:
                     tex = g.soft();
                     tint = rgba(face, 0.95F * a * (1.0F - sharp));
                     break;
                  case 3:
                     tex = g.sharp();
                     tint = rgba(face, a * sharp);
                     break;
                  default:
                     tex = g.sharp();
                     tint = rgba(16777215, shimmer(wm, g, age, settled) * sharp);
               }

               if (tint >>> 24 != 0) {
                  Matrix3x2fStack m = ctx.method_51448();
                  m.pushMatrix();
                  float dy = -(1.0F - vcq.outBack(p)) * 36.0F * 0.6F;
                  m.translate(ox + g.cx(), base + g.cy() + dy);
                  m.rotate((1.0F - vcq.outCubic(p)) * (i % 2 == 0 ? -0.22F : 0.17F));
                  float sc = 1.0F + 0.22F * (1.0F - vcq.outCubic(p));
                  m.scale(sc, sc);
                  uut.image(ctx, tex.view, g.x() - g.cx() + sx, g.y() - g.cy() + sy, g.w(), g.h(), 0.0F, tint);
                  if (pass == 3 && i == wm.dotGlyph) {
                     dot(ctx, wm, g, glow, age, p, accent);
                  }

                  m.popMatrix();
               }
            }
         }

         uut.additive(false);
      }
   }

   private static void dot(DrawContext ctx, Wordmark wm, Wordmark.Glyph g, GpuTextureView glow, float age, float p, int accent) {
      float pop = vcq.outBack(vcq.clamp01((p - 0.45F) / 0.55F));
      if (!(pop <= 0.001F)) {
         float x = wm.dotX - g.cx();
         float y = wm.dotY - g.cy();
         float r = wm.dotR * 0.62F * pop;
         if (glow != null) {
            uut.additive(true);
            float twinkle = 0.6F + 0.2F * (float)Math.sin(age * 2.3F);
            uut.sprite(ctx, glow, x, y, r * 8.0F, rgba(accent, twinkle));
            uut.additive(false);
         }

         uut.circle(ctx, x, y, r, rgba(16777215, 1.0F));
      }
   }

   private static float shimmer(Wordmark wm, Wordmark.Glyph g, float age, float settled) {
      float since = age - settled;
      if (since <= 0.0F) {
         return 0.0F;
      } else {
         float sweep = since % 3.8F / 1.3F;
         if (sweep > 1.0F) {
            return 0.0F;
         } else {
            float d = (g.cx() / wm.width - (-0.25F + 1.5F * sweep)) / 0.11F;
            return 0.6F * (float)Math.exp(-d * d);
         }
      }
   }

   private void reloadMark(DrawContext ctx, GpuTextureView glow, float vw, float age, float leave) {
      int accent = kbs.selected().accent;
      float p = vcq.outBack(vcq.clamp01(age / 0.55F));
      float breathe = 1.0F + 0.025F * (float)Math.sin(age * 2.2F);
      float gone = vcq.inCubic(leave);
      float size = 74.0F * (0.85F + 0.15F * p) * breathe * (1.0F + 0.12F * vcq.outCubic(leave));
      float cx = vw * 0.5F - this.parX * 3.0F;
      float cy = this.vh * 0.44F - this.parY * 2.0F;
      uut.pushAlpha(1.0F - gone);

      try {
         if (!kbs.selected().logo() || jzh.get(kbs.selected().key) == null) {
            if (glow != null) {
               uut.additive(true);
               uut.sprite(ctx, glow, cx, cy, size * 3.2F, rgba(accent, 0.28F));
               uut.sprite(ctx, glow, cx, cy, size * 1.6F, rgba(16777215, 0.18F));
               uut.additive(false);
            }

            uut.shadow(ctx, cx - size * 0.38F, cy - size * 0.45F + 4.0F, size * 0.76F, size * 0.9F, size * 0.2F, 26.0F, rgba(0, 0.45F));
            upt.draw(ctx, cx - size * 0.5F, cy - size * 0.5F, size, rgba(16777215, vcq.clamp01(age / 0.3F)));
            this.bar(ctx, glow, vw * 0.5F, cy + 37.0F * (0.85F + 0.15F * p) + 26.0F, age, accent);
            return;
         }

         this.bar(ctx, glow, vw * 0.5F, this.vh * 0.55485F + 22.0F, age, accent);
      } finally {
         uut.popAlpha();
      }
   }

   private void bar(DrawContext ctx, GpuTextureView glow, float cx, float y, float age, int accent) {
      float p = vcq.clamp01((age - 0.1F) / 0.5F);
      if (!(p <= 0.0F)) {
         float e = vcq.outCubic(p);
         float done = this.doneAt >= 0.0F ? vcq.clamp01((age - this.doneAt) / 0.45F) : 0.0F;
         float w = 150.0F * (0.8F + 0.2F * e);
         float h = 3.0F;
         float x = cx - w * 0.5F;
         float by = y + (1.0F - e) * 5.0F;
         float r = h * 0.5F;
         float fill = Math.max(h, w * vcq.clamp01(this.progress));
         float flare = done > 0.0F ? (float)Math.sin(Math.PI * done) : 0.0F;
         int light = kce.mix(accent, 16777215, 0.55F);
         uut.pushAlpha(e);

         try {
            uut.shadow(ctx, x, by + 1.0F, w, h, r, 8.0F, rgba(0, 0.35F));
            uut.round(ctx, x, by, w, h, r, rgba(329484, 0.5F));
            uut.round(ctx, x, by, w, h, r, rgba(16777215, 0.1F));
            if (glow != null) {
               uut.additive(true);
               uut.image(ctx, glow, x - 6.0F, by - 7.0F, fill + 12.0F, h + 14.0F, 0.0F, rgba(accent, 0.16F + 0.2F * flare));
               uut.sprite(ctx, glow, x + fill - 1.0F, by + r, 26.0F + 18.0F * flare, rgba(light, 0.5F + 0.3F * flare));
               uut.additive(false);
            }

            uut.gradientH(ctx, x, by, fill, h, r, rgba(accent, 0.9F), rgba(light, 1.0F));
            float sweep = (float)(System.nanoTime() - this.bornNanos) / 1.0E9F % 1.7F / 1.7F;
            float band = 26.0F;
            float sx = x - band + (fill + band) * vcq.inOutCubic(sweep);
            float s0 = Math.max(x, sx);
            float s1 = Math.min(x + fill, sx + band);
            if (s1 - s0 > 0.5F) {
               uut.additive(true);
               float mid = sx + band * 0.5F;
               if (mid > s0) {
                  uut.gradientH(ctx, s0, by, Math.min(mid, s1) - s0, h, 0.0F, rgba(16777215, 0.0F), rgba(16777215, 0.45F));
               }

               if (s1 > mid) {
                  uut.gradientH(ctx, Math.max(mid, s0), by, s1 - Math.max(mid, s0), h, 0.0F, rgba(16777215, 0.45F), rgba(16777215, 0.0F));
               }

               uut.additive(false);
            }

            if (flare > 0.0F) {
               uut.round(ctx, x, by, fill, h, r, rgba(16777215, 0.45F * flare));
            }

            uut.circle(ctx, x + fill - r, by + r, r * 1.05F, rgba(16777215, 0.95F));
         } finally {
            uut.popAlpha();
         }

         if (this.reload instanceof ClientLoad) {
            int ink = kbs.selected().light && kbs.selected().logo() ? 1842982 : 16777215;
            this.caption(ctx, cx, by + h + 13.0F, age, e * (1.0F - done), ink);
         }
      }
   }

   private void caption(DrawContext ctx, float cx, float y, float age, float alpha, int ink) {
      if (!(alpha <= 0.01F)) {
         boolean ru = !wap.chosen() || wap.ru();
         vdn title = veo.semibold(8.4F);
         vdn sub = veo.regular(6.2F);
         vdn small = veo.medium(5.4F);
         int dots = (int)((System.nanoTime() - this.bornNanos) / 380000000L % 4L);
         String head = ru ? "Загружаем FlowClient" : "Loading FlowClient";
         float hw = title.width(head);
         float dw = title.width("...");
         float hx = cx - (hw + dw) * 0.5F;
         float rise = (1.0F - vcq.outCubic(vcq.clamp01((age - 0.2F) / 0.6F))) * 6.0F;
         float end = title.draw(ctx, head, hx, title.centerTop(y + rise), rgba(ink, 0.95F * alpha));
         if (dots > 0) {
            title.draw(ctx, ".".repeat(dots), end, title.centerTop(y + rise), rgba(ink, 0.95F * alpha));
         }

         String wait = ru ? "Пожалуйста, подождите" : "Please wait";
         sub.drawCentered(ctx, wait, cx, sub.centerTop(y + 11.0F + rise), rgba(ink, 0.6F * alpha));
         String stage = ClientLoad.stage();
         if (!stage.isEmpty()) {
            String line = stage + "  ·  " + Math.round(ClientLoad.fraction() * 100.0F) + "%";
            small.drawCentered(ctx, line, cx, small.centerTop(y + 21.0F + rise), rgba(ink, 0.38F * alpha));
         }
      }
   }

   private void plain(DrawContext ctx, float alpha) {
      int a = Math.round(alpha * 255.0F);
      if (a >= 4) {
         int width = ctx.method_51421();
         int height = ctx.method_51443();
         ctx.method_25294(0, 0, width, height, a << 24 | 660002);
         ctx.method_25300(this.mc.field_1772, vvi.get(), width / 2, height / 2 - 10, a << 24 | 16777215);
         int bar = 120;
         ctx.method_25294(width / 2 - bar / 2, height / 2 + 6, width / 2 + bar / 2, height / 2 + 8, a / 5 << 24 | 16777215);
         ctx.method_25294(
            width / 2 - bar / 2, height / 2 + 6, width / 2 - bar / 2 + Math.round(bar * vcq.clamp01(this.progress)), height / 2 + 8, a << 24 | 9423871
         );
      }
   }

   private static Wordmark wordmark(float ppu) {
      int px = Math.max(12, Math.round(36.0F * ppu));
      if (mark != null && mark.px == px) {
         return mark;
      } else {
         if (mark != null) {
            RETIRED.add(mark);
            RETIRED_AT.add(unf.frame());
         }

         mark = Wordmark.build(36.0F, ppu);
         return mark;
      }
   }

   private static void collect() {
      Intro.collect();
      long now = unf.frame();

      for (int i = RETIRED.size() - 1; i >= 0; i--) {
         if (now - RETIRED_AT.get(i) > 2L) {
            RETIRED.remove(i).close();
            RETIRED_AT.remove(i);
         }
      }
   }

   static void release() {
      if (mark != null) {
         RETIRED.add(mark);
         RETIRED_AT.add(unf.frame());
         mark = null;
      }

      if (scene != null) {
         scene.close();
         scene = null;
      }
   }

   static void collectReleased() {
      collect();
   }

   private static float lerp(float a, float b, float t) {
      return a + (b - a) * t;
   }

   private static float smooth(float e0, float e1, float x) {
      float t = vcq.clamp01((x - e0) / (e1 - e0));
      return t * t * (3.0F - 2.0F * t);
   }

   private static int rgba(int rgb, float a) {
      int al = Math.max(0, Math.min(255, Math.round(a * 255.0F)));
      return al << 24 | rgb & 16777215;
   }
}
