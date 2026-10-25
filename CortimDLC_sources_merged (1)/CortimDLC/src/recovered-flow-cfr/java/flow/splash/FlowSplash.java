/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.SplashOverlay
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.resource.ResourceReload
 *  org.joml.Matrix3x2fStack
 */
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
import flow.splash.ClientLoad;
import flow.splash.Intro;
import flow.splash.Splash;
import flow.splash.Wordmark;
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

public final class FlowSplash
extends SplashOverlay {
    private static final float EM = 36.0f;
    private static final float INTRO_IN = 0.3f;
    private static final float MARK_OUT = 0.45f;
    private static final float WELCOME_AT = 0.3f;
    private static final float LETTERS_AT = 0.55f;
    private static final float LETTER_STEP = 0.06f;
    private static final float LETTER_TIME = 0.8f;
    private static final float WELCOME_HOLD = 3.2f;
    private static final float INTRO_OUT = 1.1f;
    private static final float RELOAD_IN = 0.35f;
    private static final float RELOAD_MIN = 1.1f;
    private static final float RELOAD_OUT = 0.55f;
    private static final float DONE_TIME = 0.45f;
    private static final float LOGO_SIZE = 0.62f;
    private static final float LOGO_Y = 0.42f;
    private static Wordmark mark;
    private static final List<Wordmark> RETIRED;
    private static final List<Long> RETIRED_AT;
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
    private float completedAt = -1.0f;
    private float doneAt = -1.0f;
    private float welcomeAt = -1.0f;
    private float outroAt = -1.0f;
    private float parX;
    private float parY;
    private float vh = 270.0f;
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
        float hold = 0.0f;
        try {
            hold = Float.parseFloat(System.getProperty("flow2.splash.hold", "0"));
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
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
            this.welcomeAt = -1.0f;
            this.outroAt = -1.0f;
            Intro.preload();
        }
    }

    public void method_74217() {
        if (this.completedAt >= 0.0f || !this.reload.method_18787()) {
            return;
        }
        if (this.reloading && this.anim < 0.6f) {
            return;
        }
        try {
            this.reload.method_18849();
            this.handler.accept(Optional.empty());
        }
        catch (Throwable t) {
            this.handler.accept(Optional.of(t));
        }
        this.completedAt = this.anim;
        this.returning = wap.chosen();
        if (this.mc.field_1755 != null) {
            this.mc.field_1755.method_25423(this.mc.method_22683().method_4486(), this.mc.method_22683().method_4502());
        }
    }

    public void method_25394(DrawContext ctx, int mouseX, int mouseY, float delta) {
        float alpha;
        float out;
        ClientLoad.frame();
        long now = System.nanoTime();
        float dt = this.lastNanos == 0L ? 0.0f : Math.min(0.033333335f, (float)(now - this.lastNanos) / 1.0E9f);
        this.lastNanos = now;
        this.anim += dt;
        float age = this.anim;
        float target = this.completedAt >= 0.0f ? 1.0f : Math.max(this.progress, this.reload.method_18229());
        this.progress += (target - this.progress) * (1.0f - (float)Math.exp(-dt * 6.0f));
        if (this.completedAt >= 0.0f && this.doneAt < 0.0f && age >= 0.35f) {
            this.doneAt = age;
        }
        if (this.injected && !this.introFailed && this.introFrame(ctx, mouseX, mouseY, delta, dt, now)) {
            return;
        }
        if (this.injected && !this.returning) {
            if (this.doneAt >= 0.0f && this.welcomeAt < 0.0f && age >= this.doneAt + 0.45f + 0.1f) {
                this.welcomeAt = age;
            }
            if (this.welcomeAt >= 0.0f && this.outroAt < 0.0f && age >= Math.max(this.minShow, this.welcomeAt + 3.2f)) {
                this.outroAt = age;
            }
        } else {
            float min = Math.max(this.minShow, 1.1f);
            if (this.doneAt >= 0.0f && this.outroAt < 0.0f && age >= Math.max(min, this.doneAt + 0.45f + 0.15f)) {
                this.outroAt = age;
            }
        }
        float outTime = this.injected && !this.returning ? 1.1f : 0.55f;
        float f = out = this.outroAt >= 0.0f ? vcq.clamp01((age - this.outroAt) / outTime) : 0.0f;
        if (this.injected && !this.returning) {
            float real = (float)(now - this.bornNanos) / 1.0E9f;
            alpha = this.fadeIn ? vcq.inOutCubic(vcq.clamp01(real / 0.3f)) : 1.0f;
        } else {
            float in = this.reloading ? vcq.inOutCubic(age / 0.35f) : 1.0f;
            alpha = in * (1.0f - vcq.inOutCubic(out));
        }
        if (alpha < 0.999f && this.mc.field_1755 != null) {
            try {
                this.mc.field_1755.method_47413(ctx, mouseX, mouseY, delta);
            }
            catch (Throwable throwable) {}
            this.mc.field_1705.method_72738();
        }
        ctx.method_71048();
        if (!this.broken) {
            try {
                this.scene(ctx, mouseX, mouseY, age, dt, alpha, out);
            }
            catch (Throwable t) {
                this.broken = true;
                System.out.println("splash render failed, plain fallback: " + t);
                t.printStackTrace();
            }
        }
        if (this.broken) {
            this.plain(ctx, alpha);
        }
        if (out >= 1.0f && !this.finished) {
            this.finished = true;
            if (this.injected && !this.returning) {
                Screen back = this.mc.field_1687 != null ? this.mc.field_1755 : null;
                this.mc.method_1507((Screen)new kct(back));
            }
            this.mc.method_18502(null);
        }
    }

    private boolean introFrame(DrawContext ctx, int mouseX, int mouseY, float delta, float dt, long now) {
        float fade;
        if (this.intro == null) {
            this.intro = Intro.create();
            if (this.intro == null) {
                if (Intro.unavailable()) {
                    this.introFailed = true;
                    return false;
                }
                if (this.mc.field_1755 != null) {
                    try {
                        this.mc.field_1755.method_47413(ctx, mouseX, mouseY, delta);
                    }
                    catch (Throwable throwable) {}
                }
                return true;
            }
        }
        this.intro.loading(this.completedAt >= 0.0f ? 1.0f : this.progress);
        this.intro.step(dt, this.completedAt >= 0.0f);
        if (this.intro.dissolving() && !this.handedOver) {
            this.handedOver = true;
            this.handOver();
        }
        float f = fade = this.fadeIn ? vcq.inOutCubic(vcq.clamp01((float)(now - this.bornNanos) / 1.0E9f / 0.3f)) : 1.0f;
        if (fade * this.intro.layer() < 0.999f && this.mc.field_1755 != null) {
            try {
                this.mc.field_1755.method_47413(ctx, mouseX, mouseY, delta);
            }
            catch (Throwable throwable) {}
            this.mc.field_1705.method_72738();
        }
        ctx.method_71048();
        uut.beginFrame();
        unf.observe(ctx);
        FlowSplash.collect();
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
            }
            return false;
        }
        float wait = this.intro.waiting();
        if (wait > 0.01f) {
            this.introCaption(ctx, width, height, wait);
        }
        if (this.intro.finished() && !this.finished) {
            this.finished = true;
            this.intro.close();
            this.mc.method_18502(null);
        }
        return true;
    }

    private void handOver() {
        this.returning = wap.chosen();
        if (!this.returning) {
            Screen back = this.mc.field_1687 != null ? this.mc.field_1755 : null;
            this.mc.method_1507((Screen)new kct(back));
        } else if (this.mc.field_1755 instanceof TitleScreen && Splash.MENU) {
            this.mc.method_1507((Screen)new jte());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void introCaption(DrawContext ctx, int width, int height, float alpha) {
        String stage = ClientLoad.stage();
        if (stage.isEmpty()) {
            return;
        }
        float s = kbp.scale(width, height);
        float y = (float)((double)this.intro.captionY() / Math.max(1.0, (double)this.mc.method_22683().method_4495())) / s;
        Matrix3x2fStack m = ctx.method_51448();
        m.pushMatrix();
        m.scale(s, s);
        vdn.setRenderScaleStepped(s);
        try {
            vdn font = veo.medium(5.2f);
            float tracking = 1.7f;
            String head = stage.toUpperCase(Locale.ROOT);
            String tail = Math.round(vcq.clamp01(this.progress) * 100.0f) + "%";
            String sep = "   \u00b7   ";
            float known = this.intro.known();
            float hw = font.width(head, tracking);
            float tw = font.width(sep + tail, tracking) * known;
            float x = (float)width / s * 0.5f - (hw + tw) * 0.5f;
            float top = font.centerTop(y);
            font.drawTracked(ctx, head, x, top, FlowSplash.rgba(0xFFFFFF, 0.42f * alpha), tracking);
            if (known > 0.01f) {
                font.drawTracked(ctx, sep + tail, x + hw, top, FlowSplash.rgba(0xFFFFFF, 0.42f * alpha * known), tracking);
            }
        }
        finally {
            m.popMatrix();
            vdn.setRenderScale(1.0f);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void scene(DrawContext ctx, int mouseX, int mouseY, float age, float dt, float alpha, float out) {
        uut.beginFrame();
        unf.observe(ctx);
        FlowSplash.collect();
        int width = ctx.method_51421();
        int height = ctx.method_51443();
        if (width <= 0 || height <= 0 || alpha <= 0.002f) {
            return;
        }
        float s = kbp.scale(width, height);
        float vw = (float)width / s;
        this.vh = (float)height / s;
        float k = 1.0f - (float)Math.exp(-dt * 2.5f);
        if (mouseX >= 0 && mouseY >= 0 && mouseX <= width && mouseY <= height) {
            this.parX += ((float)mouseX / (float)width - 0.5f - this.parX) * k;
            this.parY += ((float)mouseY / (float)height - 0.5f - this.parY) * k;
        }
        float ppu2 = s * Math.max(1.0f, (float)this.mc.method_22683().method_4495());
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
                    this.intro(ctx, glow, vw, age, ppu2, out);
                } else {
                    this.reloadMark(ctx, glow, vw, age, 0.0f);
                }
            }
            finally {
                m.popMatrix();
                vdn.setRenderScale(1.0f);
            }
        }
        finally {
            uut.popAlpha();
            uut.additive(false);
        }
    }

    private void background(DrawContext ctx, int width, int height, float age, float out) {
        uut.rect(ctx, 0.0f, 0.0f, width, height, -16250094);
        kbs season = kbs.selected();
        jza art = jzh.get(season.key);
        if (art == null) {
            return;
        }
        float w = this.injected && !this.returning && this.welcomeAt >= 0.0f ? vcq.inOutCubic(vcq.clamp01((age - this.welcomeAt) / 1.6f)) : 0.0f;
        float o = this.injected && !this.returning ? vcq.inOutCubic(out) : 0.0f;
        this.look.time = kap.clock();
        this.look.zoom = 1.06f;
        this.look.panX = -this.parX * 0.01f * (1.0f - o);
        this.look.panY = -this.parY * 0.008f * (1.0f - o);
        this.look.blur = FlowSplash.lerp(FlowSplash.lerp(0.6f, 0.3f, w), 1.0f, o);
        this.look.dim = FlowSplash.lerp(FlowSplash.lerp(0.32f, 0.24f, w), 0.22f, o);
        if (art.logo()) {
            float rise = this.injected && !this.returning && this.welcomeAt >= 0.0f ? vcq.inOutCubic(vcq.clamp01((age - this.welcomeAt) / 0.8f)) : 0.0f;
            float size = FlowSplash.lerp(FlowSplash.lerp(0.62f, 0.5f, rise), 0.92f, o);
            float fy = FlowSplash.lerp(FlowSplash.lerp(0.42f, 0.33f, rise), 0.5f, o);
            float aspect = (float)width / (float)height;
            this.look.logoF(0.5f - this.parX * 0.008f * (1.0f - o), fy - this.parY * 0.006f * (1.0f - o), size, aspect);
            this.look.blur = o;
            this.look.dim = FlowSplash.lerp(0.0f, 0.22f, o);
        }
        this.look.tint = season.tint;
        this.look.tintAmount = 0.3f;
        this.look.fall = null;
        this.look.pool = null;
        scene.draw(ctx, art, this.look, width, height, 1.0f, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void intro(DrawContext ctx, GpuTextureView glow, float vw, float age, float ppu2, float out) {
        float leave;
        float f = leave = this.welcomeAt >= 0.0f ? vcq.clamp01((age - this.welcomeAt) / 0.45f) : 0.0f;
        if (leave < 1.0f) {
            this.reloadMark(ctx, glow, vw, age, leave);
        }
        if (this.welcomeAt < 0.0f) {
            return;
        }
        float t = age - this.welcomeAt;
        kbs season = kbs.selected();
        int accent = season.accent;
        int face = season.light ? 1842982 : 0xFFFFFF;
        float o = vcq.inOutCubic(out);
        float settle = vcq.outCubic(vcq.clamp01(t / 1.1f));
        float base = season.logo() ? 0.555f : 0.44f;
        float cy = this.vh * base - this.parY * 3.0f - o * 10.0f - (1.0f - settle) * 12.0f;
        float cx = vw * 0.5f - this.parX * 4.0f;
        uut.pushAlpha(1.0f - vcq.clamp01(out * 1.4f));
        try {
            uut.shadow(ctx, cx - 134.0f, cy - 32.0f, 268.0f, 72.0f, 32.0f, 54.0f, FlowSplash.rgba(season.light ? 0xFFFFFF : 132363, 0.34f * vcq.clamp01(t / 0.6f)));
            FlowSplash.welcome(ctx, cx, cy - 27.0f, t, accent, face);
            Wordmark wm = FlowSplash.wordmark(ppu2);
            Matrix3x2fStack m = ctx.method_51448();
            m.pushMatrix();
            m.translate(cx, cy);
            float sc = (1.0f + 0.05f * o) * (1.0f + 0.03f * (1.0f - settle));
            m.scale(sc, sc);
            try {
                this.letters(ctx, wm, glow, t, accent, face);
            }
            finally {
                m.popMatrix();
            }
        }
        finally {
            uut.popAlpha();
        }
    }

    private static void welcome(DrawContext ctx, float cx, float y, float age, int accent, int face) {
        float p = vcq.clamp01((age - 0.3f) / 0.8f);
        if (p <= 0.0f) {
            return;
        }
        float e = vcq.outCubic(p);
        vdn f = veo.medium(8.6f);
        String text = !wap.chosen() || wap.ru() ? "\u0414\u041e\u0411\u0420\u041e \u041f\u041e\u0416\u0410\u041b\u041e\u0412\u0410\u0422\u042c \u0412" : "WELCOME TO";
        float tracking = 2.4f + 5.0f * (1.0f - e);
        float w = f.width(text, tracking);
        int ink = face == 0xFFFFFF ? 15135487 : face;
        f.drawTracked(ctx, text, cx - w * 0.5f, f.centerTop(y + (1.0f - e) * 10.0f), FlowSplash.rgba(ink, 0.9f * e), tracking);
        float len = 26.0f * vcq.outCubic(vcq.clamp01((age - 0.3f - 0.25f) / 0.9f));
        if (len > 0.5f) {
            float gap = 8.0f;
            int c = kce.mix(accent, face, 0.35f);
            uut.gradientH(ctx, cx - w * 0.5f - gap - len, y - 0.35f, len, 0.7f, 0.35f, FlowSplash.rgba(c, 0.0f), FlowSplash.rgba(c, 0.8f * e));
            uut.gradientH(ctx, cx + w * 0.5f + gap, y - 0.35f, len, 0.7f, 0.35f, FlowSplash.rgba(c, 0.8f * e), FlowSplash.rgba(c, 0.0f));
        }
    }

    private void letters(DrawContext ctx, Wordmark wm, GpuTextureView glow, float age, int accent, int face) {
        float ox = -wm.width * 0.5f;
        float base = wm.cap * 0.5f;
        float settled = 0.55f + (float)wm.glyphs.length * 0.06f + 0.8f;
        for (int pass = 0; pass < 5; ++pass) {
            if (pass == 1 || pass == 4) {
                uut.additive(true);
            }
            for (int i = 0; i < wm.glyphs.length; ++i) {
                int tint;
                uok tex;
                Wordmark.Glyph g = wm.glyphs[i];
                float p = vcq.clamp01((age - 0.55f - (float)i * 0.06f) / 0.8f);
                if (p <= 0.0f) continue;
                float a2 = FlowSplash.smooth(0.0f, 0.4f, p);
                float sharp = FlowSplash.smooth(0.2f, 0.85f, p);
                float sx = 0.0f;
                float sy = 0.0f;
                switch (pass) {
                    case 0: {
                        tex = g.soft();
                        tint = FlowSplash.rgba(66314, 0.55f * a2);
                        sx = 0.5f;
                        sy = 1.8f;
                        break;
                    }
                    case 1: {
                        tex = g.soft();
                        tint = FlowSplash.rgba(accent, (0.22f + 0.07f * (float)Math.sin(age * 1.7f + (float)i * 0.45f)) * a2);
                        break;
                    }
                    case 2: {
                        tex = g.soft();
                        tint = FlowSplash.rgba(face, 0.95f * a2 * (1.0f - sharp));
                        break;
                    }
                    case 3: {
                        tex = g.sharp();
                        tint = FlowSplash.rgba(face, a2 * sharp);
                        break;
                    }
                    default: {
                        tex = g.sharp();
                        tint = FlowSplash.rgba(0xFFFFFF, FlowSplash.shimmer(wm, g, age, settled) * sharp);
                    }
                }
                if (tint >>> 24 == 0) continue;
                Matrix3x2fStack m = ctx.method_51448();
                m.pushMatrix();
                float dy = -(1.0f - vcq.outBack(p)) * 36.0f * 0.6f;
                m.translate(ox + g.cx(), base + g.cy() + dy);
                m.rotate((1.0f - vcq.outCubic(p)) * (i % 2 == 0 ? -0.22f : 0.17f));
                float sc = 1.0f + 0.22f * (1.0f - vcq.outCubic(p));
                m.scale(sc, sc);
                uut.image(ctx, tex.view, g.x() - g.cx() + sx, g.y() - g.cy() + sy, g.w(), g.h(), 0.0f, tint);
                if (pass == 3 && i == wm.dotGlyph) {
                    FlowSplash.dot(ctx, wm, g, glow, age, p, accent);
                }
                m.popMatrix();
            }
            uut.additive(false);
        }
    }

    private static void dot(DrawContext ctx, Wordmark wm, Wordmark.Glyph g, GpuTextureView glow, float age, float p, int accent) {
        float pop = vcq.outBack(vcq.clamp01((p - 0.45f) / 0.55f));
        if (pop <= 0.001f) {
            return;
        }
        float x = wm.dotX - g.cx();
        float y = wm.dotY - g.cy();
        float r = wm.dotR * 0.62f * pop;
        if (glow != null) {
            uut.additive(true);
            float twinkle = 0.6f + 0.2f * (float)Math.sin(age * 2.3f);
            uut.sprite(ctx, glow, x, y, r * 8.0f, FlowSplash.rgba(accent, twinkle));
            uut.additive(false);
        }
        uut.circle(ctx, x, y, r, FlowSplash.rgba(0xFFFFFF, 1.0f));
    }

    private static float shimmer(Wordmark wm, Wordmark.Glyph g, float age, float settled) {
        float since = age - settled;
        if (since <= 0.0f) {
            return 0.0f;
        }
        float sweep = since % 3.8f / 1.3f;
        if (sweep > 1.0f) {
            return 0.0f;
        }
        float d = (g.cx() / wm.width - (-0.25f + 1.5f * sweep)) / 0.11f;
        return 0.6f * (float)Math.exp(-d * d);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void reloadMark(DrawContext ctx, GpuTextureView glow, float vw, float age, float leave) {
        int accent = kbs.selected().accent;
        float p = vcq.outBack(vcq.clamp01(age / 0.55f));
        float breathe = 1.0f + 0.025f * (float)Math.sin(age * 2.2f);
        float gone = vcq.inCubic(leave);
        float size = 74.0f * (0.85f + 0.15f * p) * breathe * (1.0f + 0.12f * vcq.outCubic(leave));
        float cx = vw * 0.5f - this.parX * 3.0f;
        float cy = this.vh * 0.44f - this.parY * 2.0f;
        uut.pushAlpha(1.0f - gone);
        try {
            if (kbs.selected().logo() && jzh.get(kbs.selected().key) != null) {
                this.bar(ctx, glow, vw * 0.5f, this.vh * 0.55485f + 22.0f, age, accent);
                return;
            }
            if (glow != null) {
                uut.additive(true);
                uut.sprite(ctx, glow, cx, cy, size * 3.2f, FlowSplash.rgba(accent, 0.28f));
                uut.sprite(ctx, glow, cx, cy, size * 1.6f, FlowSplash.rgba(0xFFFFFF, 0.18f));
                uut.additive(false);
            }
            uut.shadow(ctx, cx - size * 0.38f, cy - size * 0.45f + 4.0f, size * 0.76f, size * 0.9f, size * 0.2f, 26.0f, FlowSplash.rgba(0, 0.45f));
            upt.draw(ctx, cx - size * 0.5f, cy - size * 0.5f, size, FlowSplash.rgba(0xFFFFFF, vcq.clamp01(age / 0.3f)));
            this.bar(ctx, glow, vw * 0.5f, cy + 37.0f * (0.85f + 0.15f * p) + 26.0f, age, accent);
        }
        finally {
            uut.popAlpha();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void bar(DrawContext ctx, GpuTextureView glow, float cx, float y, float age, int accent) {
        float p = vcq.clamp01((age - 0.1f) / 0.5f);
        if (p <= 0.0f) {
            return;
        }
        float e = vcq.outCubic(p);
        float done = this.doneAt >= 0.0f ? vcq.clamp01((age - this.doneAt) / 0.45f) : 0.0f;
        float w = 150.0f * (0.8f + 0.2f * e);
        float h = 3.0f;
        float x = cx - w * 0.5f;
        float by = y + (1.0f - e) * 5.0f;
        float r = h * 0.5f;
        float fill = Math.max(h, w * vcq.clamp01(this.progress));
        float flare = done > 0.0f ? (float)Math.sin(Math.PI * (double)done) : 0.0f;
        int light = kce.mix(accent, 0xFFFFFF, 0.55f);
        uut.pushAlpha(e);
        try {
            uut.shadow(ctx, x, by + 1.0f, w, h, r, 8.0f, FlowSplash.rgba(0, 0.35f));
            uut.round(ctx, x, by, w, h, r, FlowSplash.rgba(329484, 0.5f));
            uut.round(ctx, x, by, w, h, r, FlowSplash.rgba(0xFFFFFF, 0.1f));
            if (glow != null) {
                uut.additive(true);
                uut.image(ctx, glow, x - 6.0f, by - 7.0f, fill + 12.0f, h + 14.0f, 0.0f, FlowSplash.rgba(accent, 0.16f + 0.2f * flare));
                uut.sprite(ctx, glow, x + fill - 1.0f, by + r, 26.0f + 18.0f * flare, FlowSplash.rgba(light, 0.5f + 0.3f * flare));
                uut.additive(false);
            }
            uut.gradientH(ctx, x, by, fill, h, r, FlowSplash.rgba(accent, 0.9f), FlowSplash.rgba(light, 1.0f));
            float sweep = (float)(System.nanoTime() - this.bornNanos) / 1.0E9f % 1.7f / 1.7f;
            float band = 26.0f;
            float sx = x - band + (fill + band) * vcq.inOutCubic(sweep);
            float s0 = Math.max(x, sx);
            float s1 = Math.min(x + fill, sx + band);
            if (s1 - s0 > 0.5f) {
                uut.additive(true);
                float mid = sx + band * 0.5f;
                if (mid > s0) {
                    uut.gradientH(ctx, s0, by, Math.min(mid, s1) - s0, h, 0.0f, FlowSplash.rgba(0xFFFFFF, 0.0f), FlowSplash.rgba(0xFFFFFF, 0.45f));
                }
                if (s1 > mid) {
                    uut.gradientH(ctx, Math.max(mid, s0), by, s1 - Math.max(mid, s0), h, 0.0f, FlowSplash.rgba(0xFFFFFF, 0.45f), FlowSplash.rgba(0xFFFFFF, 0.0f));
                }
                uut.additive(false);
            }
            if (flare > 0.0f) {
                uut.round(ctx, x, by, fill, h, r, FlowSplash.rgba(0xFFFFFF, 0.45f * flare));
            }
            uut.circle(ctx, x + fill - r, by + r, r * 1.05f, FlowSplash.rgba(0xFFFFFF, 0.95f));
        }
        finally {
            uut.popAlpha();
        }
        if (this.reload instanceof ClientLoad) {
            int ink = kbs.selected().light && kbs.selected().logo() ? 1842982 : 0xFFFFFF;
            this.caption(ctx, cx, by + h + 13.0f, age, e * (1.0f - done), ink);
        }
    }

    private void caption(DrawContext ctx, float cx, float y, float age, float alpha, int ink) {
        if (alpha <= 0.01f) {
            return;
        }
        boolean ru = !wap.chosen() || wap.ru();
        vdn title = veo.semibold(8.4f);
        vdn sub = veo.regular(6.2f);
        vdn small = veo.medium(5.4f);
        int dots = (int)((System.nanoTime() - this.bornNanos) / 380000000L % 4L);
        String head = ru ? "\u0417\u0430\u0433\u0440\u0443\u0436\u0430\u0435\u043c FlowClient" : "Loading FlowClient";
        float hw = title.width(head);
        float dw = title.width("...");
        float hx = cx - (hw + dw) * 0.5f;
        float rise = (1.0f - vcq.outCubic(vcq.clamp01((age - 0.2f) / 0.6f))) * 6.0f;
        float end = title.draw(ctx, head, hx, title.centerTop(y + rise), FlowSplash.rgba(ink, 0.95f * alpha));
        if (dots > 0) {
            title.draw(ctx, ".".repeat(dots), end, title.centerTop(y + rise), FlowSplash.rgba(ink, 0.95f * alpha));
        }
        String wait = ru ? "\u041f\u043e\u0436\u0430\u043b\u0443\u0439\u0441\u0442\u0430, \u043f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435" : "Please wait";
        sub.drawCentered(ctx, wait, cx, sub.centerTop(y + 11.0f + rise), FlowSplash.rgba(ink, 0.6f * alpha));
        String stage = ClientLoad.stage();
        if (!stage.isEmpty()) {
            String line = stage + "  \u00b7  " + Math.round(ClientLoad.fraction() * 100.0f) + "%";
            small.drawCentered(ctx, line, cx, small.centerTop(y + 21.0f + rise), FlowSplash.rgba(ink, 0.38f * alpha));
        }
    }

    private void plain(DrawContext ctx, float alpha) {
        int a2 = Math.round(alpha * 255.0f);
        if (a2 < 4) {
            return;
        }
        int width = ctx.method_51421();
        int height = ctx.method_51443();
        ctx.method_25294(0, 0, width, height, a2 << 24 | 0xA1222);
        ctx.method_25300(this.mc.field_1772, vvi.get(), width / 2, height / 2 - 10, a2 << 24 | 0xFFFFFF);
        int bar = 120;
        ctx.method_25294(width / 2 - bar / 2, height / 2 + 6, width / 2 + bar / 2, height / 2 + 8, a2 / 5 << 24 | 0xFFFFFF);
        ctx.method_25294(width / 2 - bar / 2, height / 2 + 6, width / 2 - bar / 2 + Math.round((float)bar * vcq.clamp01(this.progress)), height / 2 + 8, a2 << 24 | 0x8FCBFF);
    }

    private static Wordmark wordmark(float ppu2) {
        int px = Math.max(12, Math.round(36.0f * ppu2));
        if (mark != null && FlowSplash.mark.px == px) {
            return mark;
        }
        if (mark != null) {
            RETIRED.add(mark);
            RETIRED_AT.add(unf.frame());
        }
        mark = Wordmark.build(36.0f, ppu2);
        return mark;
    }

    private static void collect() {
        Intro.collect();
        long now = unf.frame();
        for (int i = RETIRED.size() - 1; i >= 0; --i) {
            if (now - RETIRED_AT.get(i) <= 2L) continue;
            RETIRED.remove(i).close();
            RETIRED_AT.remove(i);
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
        FlowSplash.collect();
    }

    private static float lerp(float a2, float b, float t) {
        return a2 + (b - a2) * t;
    }

    private static float smooth(float e0, float e1, float x) {
        float t = vcq.clamp01((x - e0) / (e1 - e0));
        return t * t * (3.0f - 2.0f * t);
    }

    private static int rgba(int rgb, float a2) {
        int al = Math.max(0, Math.min(255, Math.round(a2 * 255.0f)));
        return al << 24 | rgb & 0xFFFFFF;
    }

    static {
        RETIRED = new ArrayList<Wordmark>();
        RETIRED_AT = new ArrayList<Long>();
    }
}

