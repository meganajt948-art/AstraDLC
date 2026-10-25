/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.SharedConstants
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen
 *  net.minecraft.client.gui.screen.multiplayer.MultiplayerWarningScreen
 *  net.minecraft.client.gui.screen.option.OptionsScreen
 *  net.minecraft.client.gui.screen.world.SelectWorldScreen
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.Text
 *  net.minecraft.util.Util
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.dry;
import a.hyz;
import a.jos;
import a.jrn;
import a.jsi;
import a.jza;
import a.jzh;
import a.kam;
import a.kap;
import a.kbm;
import a.kbp;
import a.kbs;
import a.kce;
import a.unf;
import a.unm;
import a.uok;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdn;
import a.veo;
import a.vhz;
import a.vjf;
import a.vlv;
import a.vmc;
import a.vvi;
import a.wap;
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

public final class jte
extends Screen {
    public static final String TELEGRAM;
    public static final String DISCORD;
    private static final float jtf = 138.0f;
    private static final float jtg = 25.0f;
    private static final float jth = 7.0f;
    private static final float jti = 0.24f;
    private static final float jtj = 228.0f;
    private static final float jtk = 118.0f;
    private static final float jtl = 21.0f;
    private static final float jtm = 6.0f;
    private static final float jtn = 12.0f;
    private static final float jto = 74.0f;
    private static final float jtp = 42.0f;
    private static final float jtq = 254.0f;
    private static final int jtr = 4;
    private static final int jts = 4;
    private final kap jtt = new kap();
    private final kap jtu = new kap();
    private final kam jtv = new kam();
    private final kam jtw = new kam();
    private final kce jtx = new kce(34.0f);
    private final vcj[] jty = new vcj[4];
    private final vcj[] jtz = new vcj[4];
    private final vcj[] jua = new vcj[kbs.values().length];
    private final vcj jub = new vcj(11.0f);
    private final vcj juc = new vcj(10.0f);
    private final vcj[] jud = new vcj[]{new vcj(14.0f), new vcj(14.0f)};
    private final float[] jue = new float[]{-10.0f, -10.0f, -10.0f, -10.0f};
    private final float[] juf = new float[kbs.values().length];
    private kbs jug = kbs.selected();
    private jsi juh;
    private String jui;
    private jsi juj;
    private float juk;
    private float jul;
    private boolean jum;
    private float jun;
    private float juo;
    private boolean jup;
    private boolean juq;
    private boolean jur;
    private int jus;
    private float jut;
    private float juu;
    private float juv;
    private float juw;
    private int jux;
    private float juy;
    private float juz;
    private float jva;
    private long jvb;
    private float jvc;
    private float jvd;
    private float jve;
    private float jvf;
    private float jvg;
    private int jvh;
    private int jvi;
    private final vcj jvj;
    private final vcj jvk;
    private final vcj jvl;
    private final vcj jvm;
    private final vcj[] jvn;
    private final vcj[] jvo;
    private int jvp;
    private float jvq;
    private static final float jvr = 0.95f;
    private static final float jvs = 0.56f;
    private static final float jvt = 24.0f;
    private static final float jvu = 34.0f;
    private static final int jvv = 9;
    private static final float jvw = 19.0f;
    private static final float jvx = 132.0f;
    private static final float jvy = 13.0f;
    private static final float jvz = 20.0f;
    private static final int jwa = 3;
    private static /* synthetic */ int jwb;
    private static /* synthetic */ long jwc;

    public jte() {
        super((Text)Text.literal((String)vvi.get()));
        int n;
        this.juh = new jsi(this.jug.particles, 7L);
        this.juk = -10.0f;
        this.jul = 1.0f;
        this.jun = -1.0f;
        this.juo = -1.0f;
        this.jus = -1;
        this.juv = -10.0f;
        this.jux = -1;
        this.juy = -1.0f;
        this.jvd = 1.0f;
        this.jve = 480.0f;
        this.jvf = 270.0f;
        this.jvg = -1.0f;
        this.jvh = -1;
        this.jvi = -1;
        this.jvj = new vcj(9.0f, kbm.TITLE.get() && !kbs.selected().logo() ? 1.0f : 0.0f);
        this.jvk = new vcj(6.0f, kbs.selected().logo() ? 1.0f : 0.0f);
        this.jvl = new vcj(6.0f, kbs.selected().light ? 1.0f : 0.0f);
        this.jvm = new vcj(6.0f, kbm.PARTICLES.get() ? 1.0f : 0.0f);
        this.jvn = new vcj[9];
        this.jvo = new vcj[9];
        this.jvp = -1;
        this.jvq = -1.0f;
        for (n = 0; n < 4; ++n) {
            this.jty[n] = new vcj(14.0f);
        }
        for (n = 0; n < 4; ++n) {
            this.jtz[n] = new vcj(14.0f);
        }
        for (n = 0; n < 9; ++n) {
            this.jvn[n] = new vcj(14.0f);
            this.jvo[n] = new vcj(14.0f, jte.jxs(n));
        }
        for (n = 0; n < this.jua.length; ++n) {
            this.jua[n] = new vcj(14.0f);
            this.juf[n] = -10.0f;
        }
        jzh.preload(this.jug.key);
    }

    public static jte afterWelcome() {
        jte jte2 = new jte();
        jte2.jum = true;
        return jte2;
    }

    protected void init() {
        if (dry.armed() && this.client != null) {
            this.client.setScreen((Screen)new TitleScreen());
            return;
        }
        if (this.jup) {
            this.jup = false;
            this.juo = kap.clock() - 0.3f;
            this.jux = -1;
            this.jus = -1;
        }
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        uut.beginFrame();
        unf.observe(context);
        long l = System.nanoTime();
        if (this.width < 64 || this.height < 64) {
            this.jvb = 0L;
            return;
        }
        if (this.width != this.jvh || this.height != this.jvi) {
            this.jvh = this.width;
            this.jvi = this.height;
            this.jvg = -1.0f;
        }
        this.jvc = this.jvb == 0L ? 0.016666668f : Math.min(0.1f, (float)(l - this.jvb) / 1.0E9f);
        this.jvb = l;
        float f = kap.clock();
        if (this.jun < 0.0f) {
            this.jun = f;
            this.juo = f;
            this.jvq = f;
        }
        float f2 = f - this.jun;
        float f3 = f - this.jvq;
        this.jvd = kbp.scale(this.width, this.height);
        this.jve = (float)this.width / this.jvd;
        this.jvf = (float)this.height / this.jvd;
        float f4 = (float)mouseX / this.jvd;
        float f5 = (float)mouseY / this.jvd;
        float f6 = 1.0f - (float)Math.exp(-this.jvc * 2.2f);
        if (!kbm.PARALLAX.get()) {
            this.juz -= this.juz * f6;
            this.jva -= this.jva * f6;
        } else if (mouseX >= 0 && mouseY >= 0 && mouseX <= this.width && mouseY <= this.height) {
            this.juz += ((float)mouseX / (float)this.width - 0.5f - this.juz) * f6;
            this.jva += ((float)mouseY / (float)this.height - 0.5f - this.jva) * f6;
        }
        float f7 = this.jwl();
        this.jvg = this.jvg < 0.0f ? f7 : this.jvg + (f7 - this.jvg) * (1.0f - (float)Math.exp(-this.jvc * 9.0f));
        float f8 = this.jvj.step(kbm.TITLE.get() && !this.jug.logo(), this.jvc);
        this.jvk.step(this.jug.logo(), this.jvc);
        this.jvl.step(this.jug.light, this.jvc);
        float f9 = this.jvm.step(kbm.PARTICLES.get(), this.jvc);
        GpuTextureView gpuTextureView = unm.view();
        this.jwe(context, f, f2);
        Matrix3x2fStack matrix3x2fStack = context.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.scale(this.jvd, this.jvd);
        vdn.setRenderScaleStepped(this.jvd);
        try {
            this.jwf(context);
            float f10 = this.jwd();
            if (this.juj != null && f10 > 0.0f) {
                this.juj.draw(context, gpuTextureView, this.jve, this.jvf, f, false, this.juz, this.jva, f10 * f9);
            }
            this.juh.draw(context, gpuTextureView, this.jve, this.jvf, f, false, this.juz, this.jva, vcq.clamp01(f2 / 1.2f) * (1.0f - f10) * f9);
            float f11 = this.jvd * (float)MinecraftClient.getInstance().getWindow().getScaleFactor();
            float f12 = vcq.clamp01((f3 - 0.1f) / 1.25f);
            if (f8 > 0.01f) {
                float f13 = this.jtx.width(f11) * 0.5f + 14.0f;
                float f14 = Math.max(f13, Math.min(this.jve - f13, this.jvg + 69.0f));
                uut.pushAlpha(f8);
                this.jtx.draw(context, gpuTextureView, f14 - this.juz * 5.0f, this.jvf * 0.5f - 75.0f - this.jva * 3.0f - (1.0f - f8) * 8.0f, 1.0f, f11, f, f12, this.juz * 2.0f, this.jva * 2.0f, this.jug.accent);
                uut.popAlpha();
            }
            boolean bl = this.juq && this.jxb(f4, f5);
            for (int i = 0; i < 4; ++i) {
                this.jwm(context, gpuTextureView, i, f4, f5, f, bl);
            }
            if (this.juj != null && f10 > 0.0f) {
                this.juj.draw(context, gpuTextureView, this.jve, this.jvf, f, true, this.juz, this.jva, f10 * f9);
            }
            this.juh.draw(context, gpuTextureView, this.jve, this.jvf, f, true, this.juz, this.jva, vcq.clamp01(f2 / 1.2f) * (1.0f - f10) * f9);
            float f15 = vcq.outCubic(vcq.clamp01((f3 - 0.6f) / 0.7f));
            uut.pushAlpha(f15);
            try {
                for (int i = 0; i < 4; ++i) {
                    this.jwo(context, gpuTextureView, i, f4, f5, f15);
                }
                this.jwp(context);
            }
            finally {
                uut.popAlpha();
            }
            this.jxd(context, f4, f5);
            this.jxk(context, gpuTextureView, f4, f5, f);
        }
        finally {
            uut.additive(false);
            matrix3x2fStack.popMatrix();
            vdn.setRenderScale(1.0f);
        }
        if (this.jux >= 0 && f - this.juv >= 0.24f) {
            int n = this.jux;
            this.jux = -1;
            this.jyd(n);
        }
        if (this.juy >= 0.0f && f >= this.juy) {
            this.juy = -1.0f;
            this.client.scheduleStop();
        }
    }

    private float jwd() {
        if (this.jui == null) {
            return 0.0f;
        }
        float f = 1.0f - vcq.inOutCubic((kap.clock() - this.juk) / this.jul);
        if (f <= 0.0f) {
            this.jui = null;
            this.juj = null;
            this.jtu.close();
            jzh.releaseExcept(this.jug.key);
            return 0.0f;
        }
        return f;
    }

    private void jwe(DrawContext drawContext, float f, float f2) {
        jza jza2;
        float f3;
        jza jza3 = jzh.get(this.jug.key);
        if (jza3 == null && this.jui != null) {
            this.juk = f;
        }
        float f4 = this.jwd();
        uut.rect(drawContext, 0.0f, 0.0f, this.width, this.height, -16118250);
        float f5 = f3 = this.jum ? vcq.inOutCubic(vcq.clamp01((f2 - 0.1f) / 1.3f)) : 1.0f;
        if (jza3 != null) {
            this.jtv.time = f;
            this.jtv.zoom = 1.05f + 0.01f * (1.0f - f3);
            this.jtv.panX = -this.juz * 0.014f * f3;
            this.jtv.panY = -this.jva * 0.01f * f3;
            this.jtv.blur = 1.0f - f3;
            this.jtv.dim = 0.04f + 0.18f * (1.0f - f3) + (float)kbm.DIM.get();
            this.jtv.tint = this.jug.tint;
            this.jtv.tintAmount = 0.3f;
            this.jtv.fall = null;
            this.jtv.pool = null;
            this.jwh(this.jtv, f3);
            this.jtt.draw(drawContext, jza3, this.jtv, this.width, this.height, 1.0f, true);
        }
        if (f4 > 0.0f && (jza2 = jzh.get(this.jui)) != null) {
            this.jtw.time = f;
            this.jtw.panX = this.jtv.panX;
            this.jtw.panY = this.jtv.panY;
            kbs kbs2 = jte.jxn(this.jui);
            this.jtw.blur = 0.0f;
            this.jtw.dim = 0.04f + (float)kbm.DIM.get();
            this.jtw.zoom = 1.05f;
            this.jtw.tint = kbs2.tint;
            this.jtw.tintAmount = 0.3f;
            this.jtw.fall = null;
            this.jtw.pool = null;
            this.jwh(this.jtw, 1.0f);
            this.jtu.draw(drawContext, jza2, this.jtw, this.width, this.height, f4, false);
        }
    }

    private void jwf(DrawContext drawContext) {
        float f = 1.0f - this.jvl.get();
        if (f <= 0.01f) {
            return;
        }
        uut.gradientV(drawContext, 0.0f, 0.0f, this.jve, 120.0f, 0.0f, jte.jyh(329484, 0.42f * f), jte.jyh(329484, 0.0f));
        uut.gradientV(drawContext, 0.0f, this.jvf - 90.0f, this.jve, 90.0f, 0.0f, jte.jyh(329484, 0.0f), jte.jyh(329484, 0.5f * f));
        uut.rect(drawContext, 0.0f, 0.0f, this.jve, this.jvf, jte.jyh(329484, 0.08f * f));
    }

    private float jwg() {
        float f = Math.max(1.0f, this.jve * 0.5f - 34.0f - 69.0f);
        return Math.max(-1.0f, Math.min(1.0f, (this.jwk() + 69.0f - this.jve * 0.5f) / f));
    }

    private void jwh(kam kam2, float f) {
        float f2 = this.jwg();
        float f3 = Math.abs(f2);
        float f4 = this.jwk();
        float f5 = f2 <= 0.0f ? (f4 + 138.0f + this.jve) * 0.5f : f4 * 0.5f;
        float f6 = 0.56f + 0.39f * f3;
        float f7 = 0.435f * f6 * this.jvf;
        float f8 = this.jwi() - 14.0f - f7 * 0.5f;
        float f9 = this.jve * 0.5f + (f5 - this.jve * 0.5f) * f3 - this.juz * 6.0f;
        float f10 = f8 + (this.jvf * 0.5f - f8) * f3 - this.jva * 4.0f;
        kam2.logoF(0.5f + (f9 / this.jve - 0.5f) * f, 0.5f + (f10 / this.jvf - 0.5f) * f, 0.92f + (f6 - 0.92f) * f, this.jve / this.jvf);
    }

    private float jwi() {
        float f = 1.0f - Math.abs(this.jwg());
        return this.jvf * 0.5f - 25.6f - 34.9f * (1.0f - this.jvj.get()) + 56.9f * this.jvk.get() * f;
    }

    private float jwj(int n) {
        return this.jwi() + (float)n * 32.0f;
    }

    private float jwk() {
        return this.jvg < 0.0f ? this.jwl() : this.jvg;
    }

    /*
     * Exception decompiling
     */
    private float jwl() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private void jwm(DrawContext var1_1, GpuTextureView var2_2, int var3_3, float var4_4, float var5_5, float var6_6, boolean var7_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private float jwn(int n) {
        return this.jve - 12.0f - 21.0f - (float)(3 - n) * 27.0f - (n < 2 ? 5.0f : 0.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jwo(DrawContext drawContext, GpuTextureView gpuTextureView, int n, float f, float f2, float f3) {
        float f4;
        float f5 = this.jwn(n);
        float f6 = 12.0f + (1.0f - f3) * -8.0f;
        boolean bl = !this.jur && jte.jyf(f, f2, f5, 12.0f, 21.0f, 21.0f) && (!this.juq || n == 2 || !this.jxb(f, f2));
        float f7 = this.jtz[n].step(bl || n == 2 && this.juq, this.jvc);
        float f8 = vcq.clamp01((kap.clock() - this.jue[n]) / 0.5f);
        float f9 = f8 < 1.0f ? (float)Math.sin(Math.PI * (double)vcq.clamp01(f8 * 2.4f)) * (1.0f - f8 * 0.5f) : 0.0f;
        int n2 = switch (n) {
            case 0 -> 2796526;
            case 1 -> 8227839;
            case 2 -> this.jug.accent;
            default -> 0xFF6B6B;
        };
        float f10 = 10.5f;
        float f11 = f5 + f10;
        float f12 = f6 + f10;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f11, f12);
        float f13 = 1.0f + 0.08f * f7 - 0.14f * f9;
        matrix3x2fStack.scale(f13, f13);
        try {
            float f14;
            if (f8 < 1.0f) {
                f14 = 8.0f * vcq.outCubic(f8);
                uut.circleOutline(drawContext, 0.0f, 0.0f, f10 + f14, 1.0f, jte.jyh(n2, 0.75f * (1.0f - f8)));
            }
            f14 = this.jvl.get();
            int n3 = jte.jyg(0xFFFFFF, 1842982, f14);
            uut.shadow(drawContext, -f10, -f10 + 2.0f, 21.0f, 21.0f, f10, 10.0f, jte.jyh(0, 0.3f - 0.2f * f14));
            if (gpuTextureView != null && f7 > 0.01f) {
                uut.additive(true);
                uut.sprite(drawContext, gpuTextureView, 0.0f, 0.0f, 54.6f, jte.jyh(n2, 0.22f * f7));
                uut.additive(false);
            }
            this.jtt.frosted(drawContext, -f10, -f10, 21.0f, 21.0f, f10, f5, f6, this.jve, this.jvf, jte.jyh(0xFFFFFF, 1.0f));
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(-f10, -f10);
            uut.round(drawContext, 0.0f, 0.0f, 21.0f, 21.0f, f10, jte.jyh(jte.jyg(790552, 0xFFFFFF, f14), 0.36f - 0.1f * f7 + 0.26f * f14));
            uut.round(drawContext, 0.0f, 0.0f, 21.0f, 21.0f, f10, jte.jyh(n2, 0.16f * f7));
            uut.outlineGradientV(drawContext, 0.0f, 0.0f, 21.0f, 21.0f, f10, 0.7f, jte.jyh(jte.jyg(n3, n2, f7), (0.32f + 0.4f * f7) * (1.0f - 0.55f * f14)), jte.jyh(jte.jyg(n3, n2, f7), (0.08f + 0.25f * f7) * (1.0f + 0.5f * f14)));
            matrix3x2fStack.popMatrix();
            vhz vhz2 = switch (n) {
                case 0 -> vhz.TELEGRAM;
                case 1 -> vhz.DISCORD;
                case 2 -> vhz.IMAGE;
                default -> vhz.POWER;
            };
            f4 = n < 2 ? 11.5f : 10.5f;
            vjf.draw(drawContext, vhz2, n == 0 ? -0.6f : 0.0f, 0.0f, f4, jte.jyh(jte.jyg(jte.jyg(15331062, 2764342, f14), jte.jyg(n2, jte.jyg(0xFFFFFF, 0, f14), 0.25f), f7), 1.0f));
        }
        finally {
            matrix3x2fStack.popMatrix();
        }
        if (f7 > 0.01f && (n != 2 || !this.juq)) {
            String string = switch (n) {
                case 0 -> a.c(-1299448908, "\ufbe8\u8268\u08b2\u96ca\u1d1f\u9bbb\u21fb\ua806");
                case 1 -> a.b("\uc709\ube95\u345c\uaa3d\u21e6\ua74a\u1d0f", 283821898);
                case 2 -> wap.s(a.d("\uef50\u96c2\u1c13\u826a\u09b1\u8f15\u355b\ubcb0\u22f4\ua84f", 1450829189, 293014173), a.b("\ufaea\u8341\u0991\u93fd\u1c36\u9a8e\u20d5\ua957", 1542192838));
                default -> wap.s(a.b("\u4174\u38e1\ub22e\u2c42", -1229831903), a.d("\u221c\u5bf4\ud155\u4f5f\uc4f2", 1269071330, -644064279));
            };
            vdn vdn2 = veo.medium(6.4f);
            float f15 = vdn2.width(string) + 12.0f;
            f4 = Math.min(this.jve - 12.0f - f15, f11 - f15 * 0.5f);
            float f16 = 38.0f + (1.0f - f7) * -3.0f;
            uut.pushAlpha(f7);
            uut.round(drawContext, f4, f16, f15, 13.0f, 6.5f, jte.jyh(790552, 0.78f));
            uut.outline(drawContext, f4, f16, f15, 13.0f, 6.5f, 0.6f, jte.jyh(0xFFFFFF, 0.14f));
            vdn2.drawCentered(drawContext, string, f4 + f15 * 0.5f, vdn2.centerTop(f16 + 6.5f), jte.jyh(0xFFFFFF, 0.95f));
            uut.popAlpha();
        }
    }

    private void jwp(DrawContext drawContext) {
        vdn vdn2 = veo.medium(6.2f);
        String string = a.d("\u5984\u2011\uaac5\u34bf\ubf6e\u39ce\u838e\u0a78\u9435\u1ed0", -2045428213, 1438345160) + SharedConstants.getGameVersion().name();
        vdn2.drawRight(drawContext, string, this.jve - 12.0f, vdn2.centerTop(this.jvf - 12.0f), jte.jyh(jte.jyg(0xFFFFFF, 2764342, this.jvl.get()), 0.55f));
    }

    private float jwq() {
        return this.jve - 12.0f - 254.0f;
    }

    private float jwr() {
        return 40.0f;
    }

    private float jws() {
        return Math.min(this.jvf - this.jwr() - 12.0f, 24.0f + this.jww() + 6.0f);
    }

    private float jwt() {
        return this.jwr() + 24.0f;
    }

    private float jwu() {
        return this.jws() - 24.0f - 4.0f;
    }

    private static int jwv(int n, int n2) {
        return (n + n2 - 1) / n2;
    }

    private float jww() {
        return this.jwx() + 13.0f + 171.0f + 4.0f;
    }

    private float jwx() {
        return 13.0f + (float)jte.jwv(kbs.values().length, 3) * 62.0f + 2.0f;
    }

    private float jwy() {
        return Math.max(0.0f, this.jww() - this.jwu());
    }

    private float jwz(int n) {
        return this.jwq() + 8.0f + (float)(n % 3) * 82.0f;
    }

    private float jxa(int n) {
        return this.jwt() + 13.0f + (float)(n / 3) * 62.0f - this.jut;
    }

    private boolean jxb(float f, float f2) {
        return this.jub.get() > 0.5f && jte.jyf(f, f2, this.jwq(), this.jwr(), 254.0f, this.jws());
    }

    private int jxc(float f, float f2) {
        if (!jte.jyf(f, f2, this.jwq(), this.jwt(), 254.0f, this.jwu())) {
            return -1;
        }
        kbs[] kbsArray = kbs.values();
        for (int i = 0; i < kbsArray.length; ++i) {
            if (!jte.jyf(f, f2, this.jwz(i), this.jxa(i), 74.0f, 54.0f)) continue;
            return i;
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jxd(DrawContext drawContext, float f, float f2) {
        float f3 = this.jub.step(this.juq, this.jvc);
        if (f3 <= 0.003f) {
            return;
        }
        float f4 = vcq.outCubic(f3);
        float f5 = this.jwq();
        float f6 = this.jwr();
        float f7 = this.jws();
        float f8 = 11.0f;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        float f9 = this.jwn(2) + 10.5f;
        matrix3x2fStack.translate(f9, f6);
        matrix3x2fStack.scale(0.9f + 0.1f * f4, 0.9f + 0.1f * f4);
        matrix3x2fStack.translate(-f9, -f6 - (1.0f - f4) * 6.0f);
        uut.pushAlpha(f4);
        try {
            uut.shadow(drawContext, f5, f6 + 4.0f, 254.0f, f7, f8, 22.0f, jte.jyh(0, 0.45f));
            this.jtt.frosted(drawContext, f5, f6, 254.0f, f7, f8, this.jve, this.jvf, jte.jyh(0xFFFFFF, 1.0f));
            uut.round(drawContext, f5, f6, 254.0f, f7, f8, jte.jyh(724759, 0.55f));
            uut.outlineGradientV(drawContext, f5, f6, 254.0f, f7, f8, 0.7f, jte.jyh(0xFFFFFF, 0.3f), jte.jyh(0xFFFFFF, 0.07f));
            vdn vdn2 = veo.semibold(7.6f);
            vjf.draw(drawContext, vhz.IMAGE, f5 + 15.0f, f6 + 12.5f, 9.0f, jte.jyh(jte.jya(this.jug), 1.0f));
            vdn2.draw(drawContext, wap.s(a.c(512410759, "\uc4c5\ubd5c\u3784\ua9ee\u226c\ua49f\u1ecf\u973c\u096b\u83d6\u0410\ufe7c\u70b1\ue91b\u6342"), a.d("\ua7a0\ude0b\u54db\uceb7\u417c\uc7c4\u7d9f\uf41d", -1697236676, -1730766160)), f5 + 24.0f, vdn2.centerTop(f6 + 12.5f), jte.jyh(0xFFFFFF, 0.95f));
            this.juu = Math.max(0.0f, Math.min(this.jwy(), this.juu));
            this.jut += (this.juu - this.jut) * (1.0f - (float)Math.exp(-this.jvc * 16.0f));
            float f10 = this.jwt();
            float f11 = this.jwu();
            int n = f3 >= 0.99f ? this.jxc(f, f2) : -1;
            uut.pushScissor(drawContext, f5, f10, 254.0f, f11);
            try {
                vdn vdn3 = veo.medium(6.0f);
                for (int i = 0; i < 2; ++i) {
                    float f12 = f10 + (i == 1 ? this.jwx() : 0.0f) - this.jut;
                    String string = i == 0 ? wap.s(a.b("\u9737\ueeb0\u646e\ufa1f\u71d4\uf774\u4d36\uc4d2\u5a9a\ud02a", 576558954), a.d("\uedba\u9424\u1ef8\u808f", 534105332, 1341007188)) : wap.s(a.b("\ua239\udba0\u5178\ucf12\u4490\uc26d\u783d\uf1cc\u6f97", 1400414845), a.b("\u41fa\u3861\ub2be\u28db\ua710\u21a8\u9bf3\u1271", -568179232));
                    vdn3.drawTracked(drawContext, string.toUpperCase(), f5 + 10.0f, vdn3.centerTop(f12 + 6.5f), jte.jyh(0xFFFFFF, 0.5f), 0.8f);
                    float f13 = vdn3.width(string.toUpperCase(), 0.8f);
                    uut.rect(drawContext, f5 + 16.0f + f13, f12 + 6.5f, 228.0f - f13, 0.5f, jte.jyh(0xFFFFFF, 0.1f));
                }
                kbs[] kbsArray = kbs.values();
                for (int i = 0; i < kbsArray.length; ++i) {
                    float f14 = this.jxa(i);
                    if (f14 + 42.0f + 14.0f < f10 || f14 > f10 + f11) {
                        this.jua[i].set(0.0f);
                        continue;
                    }
                    this.jxe(drawContext, kbsArray[i], i, n == i);
                }
                this.jyb(drawContext, f, f2, f3 >= 0.99f);
            }
            finally {
                uut.popScissor(drawContext);
            }
            float f15 = this.jwy();
            if (f15 > 0.5f) {
                uut.gradientV(drawContext, f5 + 1.0f, f10, 252.0f, 8.0f, 0.0f, jte.jyh(724759, 0.55f * vcq.clamp01(this.jut / 8.0f)), jte.jyh(724759, 0.0f));
                uut.gradientV(drawContext, f5 + 1.0f, f10 + f11 - 8.0f, 252.0f, 8.0f, 0.0f, jte.jyh(724759, 0.0f), jte.jyh(724759, 0.55f * vcq.clamp01((f15 - this.jut) / 8.0f)));
                float f16 = Math.max(14.0f, f11 * f11 / this.jww());
                float f17 = f10 + (f11 - f16) * (this.jut / f15);
                uut.round(drawContext, f5 + 254.0f - 4.5f, f17, 2.0f, f16, 1.0f, jte.jyh(0xFFFFFF, 0.28f));
            }
        }
        finally {
            uut.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jxe(DrawContext drawContext, kbs kbs2, int n, boolean bl) {
        float f = this.jwz(n);
        float f2 = this.jxa(n);
        float f3 = 7.0f;
        float f4 = 74.0f;
        float f5 = 42.0f;
        float f6 = this.jua[n].step(bl, this.jvc);
        boolean bl2 = kbs2 == this.jug;
        float f7 = vcq.clamp01((kap.clock() - this.juf[n]) / 0.45f);
        float f8 = f7 < 1.0f ? (float)Math.sin(Math.PI * (double)vcq.clamp01(f7 * 2.4f)) * (1.0f - f7 * 0.5f) : 0.0f;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f + f4 * 0.5f, f2 + f5 * 0.5f);
        matrix3x2fStack.scale(1.0f - 0.06f * f8, 1.0f - 0.06f * f8);
        matrix3x2fStack.translate(-f - f4 * 0.5f, -f2 - f5 * 0.5f);
        try {
            this.jxf(drawContext, kbs2, f, f2, f4, f5, f3, f6, bl2);
        }
        finally {
            matrix3x2fStack.popMatrix();
        }
    }

    private void jxf(DrawContext drawContext, kbs kbs2, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        uok uok2 = jzh.thumb(kbs2.key);
        if (uok2 != null) {
            float f7 = (float)uok2.width / (float)uok2.height;
            float f8 = f3 / f4;
            float f9 = f7 > f8 ? (1.0f - f8 / f7) * 0.5f : 0.0f;
            float f10 = f7 > f8 ? 0.0f : (1.0f - f7 / f8) * 0.5f;
            float f11 = 0.04f * f6;
            uut.imageRegion(drawContext, uok2.view, f, f2, f3, f4, f5, f9 + f11, f10 + f11, 1.0f - f9 - f11, 1.0f - f10 - f11, jte.jyh(0xFFFFFF, 1.0f), false);
        } else {
            uut.round(drawContext, f, f2, f3, f4, f5, jte.jyh(0xFFFFFF, 0.08f));
        }
        uut.round(drawContext, f, f2, f3, f4, f5, jte.jyh(0, 0.18f * (1.0f - f6)));
        if (kbs2.isVideo()) {
            uut.circle(drawContext, f + 7.0f, f2 + f4 - 7.0f, 4.2f, jte.jyh(0, 0.6f));
            vjf.draw(drawContext, vhz.PLAY, f + 7.3f, f2 + f4 - 7.0f, 5.2f, jte.jyh(0xFFFFFF, 0.95f));
        }
        int n = jte.jya(kbs2);
        int n2 = bl ? n : 0xFFFFFF;
        uut.outline(drawContext, f, f2, f3, f4, f5, bl ? 1.2f : 0.7f, jte.jyh(n2, bl ? 0.95f : 0.18f + 0.4f * f6));
        vdn vdn2 = veo.medium(6.3f);
        String string = kbs2.title();
        if (vdn2.width(string) > f3 - 10.0f) {
            while (string.length() > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!(vdn2.width(stringBuilder.append(string).append(a.b("\u2058", 168689791)).toString()) > f3 - 10.0f)) break;
                string = string.substring(0, string.length() - 1);
            }
            string = string.trim() + a.b("\u05f3", -1386928684);
        }
        vdn2.draw(drawContext, string, f + 2.0f, vdn2.centerTop(f2 + f4 + 7.0f), jte.jyh(bl ? jte.jyg(0xFFFFFF, n, 0.5f) : 0xFFFFFF, bl ? 1.0f : 0.7f + 0.3f * f6));
        uut.circle(drawContext, f + f3 - 4.0f, f2 + f4 + 7.0f, 2.2f, jte.jyh(n, bl ? 1.0f : 0.45f));
    }

    private float jxg() {
        return (this.jve - 228.0f) * 0.5f;
    }

    private float jxh() {
        return (this.jvf - 118.0f) * 0.5f;
    }

    private float jxi(int n) {
        float f = 96.0f;
        return this.jxg() + 14.0f + (float)n * (f + 8.0f);
    }

    private float jxj() {
        return this.jxh() + 118.0f - 34.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jxk(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3) {
        float f4 = this.juc.step(this.jur, this.jvc);
        if (f4 <= 0.003f) {
            return;
        }
        float f5 = vcq.outBack(f4);
        int n = this.jug.accent;
        uut.rect(drawContext, 0.0f, 0.0f, this.jve, this.jvf, jte.jyh(197898, 0.42f * vcq.clamp01(f4)));
        float f6 = this.jxg();
        float f7 = this.jxh();
        float f8 = 14.0f;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f6 + 114.0f, f7 + 59.0f);
        float f9 = 0.9f + 0.1f * Math.min(1.05f, f5);
        matrix3x2fStack.scale(f9, f9);
        matrix3x2fStack.translate(-114.0f - f6, -59.0f - f7 + (1.0f - Math.min(1.0f, f5)) * 8.0f);
        uut.pushAlpha(vcq.clamp01(f4 * 1.4f));
        try {
            uut.shadow(drawContext, f6, f7 + 6.0f, 228.0f, 118.0f, f8, 26.0f, jte.jyh(0, 0.5f));
            this.jtt.frosted(drawContext, f6, f7, 228.0f, 118.0f, f8, this.jve, this.jvf, jte.jyh(0xFFFFFF, 1.0f));
            uut.round(drawContext, f6, f7, 228.0f, 118.0f, f8, jte.jyh(658966, 0.6f));
            uut.outlineGradientV(drawContext, f6, f7, 228.0f, 118.0f, f8, 0.7f, jte.jyh(0xFFFFFF, 0.3f), jte.jyh(0xFFFFFF, 0.07f));
            if (gpuTextureView != null) {
                uut.additive(true);
                uut.sprite(drawContext, gpuTextureView, f6 + 30.0f, f7 + 30.0f, 60.0f, jte.jyh(n, 0.25f));
                uut.additive(false);
            }
            float f10 = (float)Math.sin(f3 * 3.2f) * 1.2f;
            uut.round(drawContext, f6 + 16.0f, f7 + 16.0f, 28.0f, 28.0f, 9.0f, jte.jyh(n, 0.18f));
            uut.outline(drawContext, f6 + 16.0f, f7 + 16.0f, 28.0f, 28.0f, 9.0f, 0.7f, jte.jyh(n, 0.5f));
            vjf.draw(drawContext, vhz.DOWNLOAD, f6 + 30.0f, f7 + 30.0f + f10, 14.0f, jte.jyh(jte.jyg(n, 0xFFFFFF, 0.35f), 1.0f));
            vdn vdn2 = veo.semibold(9.6f);
            vdn2.draw(drawContext, wap.s(a.d("\u7326\u0abc\u8077\u1e1f\u95ca\u1378\ua925\u20d1\ubeca\u342f\ub3e0\u499c\uc70e\u5ed6\ud48d\u526e\ue852\u67ce\ufd7f\u7b25", 771666703, -1186611079), a.d("\u2bcb\u5261\ud8b8\u46be\ucd1e\u4ba6\uf18e\u7808\ue242\u6cef\ueb3e\u1145\u9b86\u025e\u8805\u0ee6", 1775895123, 444476841)), f6 + 54.0f, vdn2.centerTop(f7 + 24.0f), jte.jyh(0xFFFFFF, 0.97f));
            vdn vdn3 = veo.medium(6.6f);
            vdn3.draw(drawContext, a.d("\u8681\uff17\u7587\ueb9c\u606d\ue6d0\u5c8b\ud53f\u4b01\uc192\u4641\ubc3c\u32f1\uab5b\u2112\ua7b7\u1d8b\u927e\u08d3\u8e9f\u077f\u7d25\uf39b\u685d\uee70\u6436\udd12\u5325\uc9f5\u4fa7\uc404\u3ace\ub08b\u2939\uaf7b\u25d5\u9a1e\u106c\u96a0\u0f0e\u8551", -1628306265, 341082694), f6 + 54.0f, vdn3.centerTop(f7 + 36.0f), jte.jyh(jte.jyg(0xFFFFFF, n, 0.5f), 0.85f));
            vdn vdn4 = veo.medium(6.4f);
            vdn4.draw(drawContext, wap.s(a.c(2000432474, "\u2d23\u54ae\ude70\u4044\ucbd2\u4d6e\uf725\u7e80\ue092\u6a2f\uedf3\u178d\u995c\u00ef\u8aab\u0c08\ub610\u39d9\ua377\u253f\uacd0\ud6d2\u5835\uc3f8\u459d\ucf51\u76f8\uf8bb\u6243\ue45a\u6fa0\u916c\u1b79\u8286\u04a5\u8e31\u31e7\ubbc2\u3d45\ua4e8\u2eba\u500e\uda17\u5dad\uc769"), a.c(-946537788, "\ufeff\u8765\u0dc1\u93be\u1c0b\u9ea6\u24fc\uad05\u3352\ub9e2\u3e33\uc441\u4ae3\ud732\u5901\udf80\u65ce\uea10\u70df\uf6fc\u7f0e\u0528\u8ff9\u104f\u9642\u1ce6\ua520\u2b73\ub593\u37df\ubc64\u42b3\uc8f1\u5510\ud34d\u5dc3\ue235\u6841\uee97\u772e\ufd7f\u83f4\u09d0")), f6 + 16.0f, vdn4.centerTop(f7 + 56.0f), jte.jyh(0xFFFFFF, 0.62f));
            vdn4.draw(drawContext, wap.s(a.b("\u14a8\u6d1e\ue7d7\u79bd\uf225\u74c0\uce8f\u4773\ud969\u5395\ud444\u2e3e\ua0fe\u391c\ub309\u35f1\u8fbdd\u9ad6\u1c90\u9535\uef25\u6199\ufa42\u7c79\uf6fa\u4f5e\uc119\u5be9\uddad\u560d\ua8da\u22c1\ubb64\u3d2b\ub797\u0805\u8233\u04e6\u9d5b\u170c\u69b6", 913773803), a.b("\u0d5f\u749a\ufe40\u6033\uefff\u6d5c\ud31d\u5ef3\uc0a3\u4a1d\ucdcb\u37c3\ubd77\u248b\uaeda\u2820\u9278\u1dfa\u8351\u0118\u8cf0\uf6ab\u786d\ue3c9\u65b4\uef62\u56de\ud8f3\u4206\uc454\u4f9d\ub136\u3b0e\ua6ea\u24a1\uae1b\u11bf\u9bcd\u1973", -1957820100)), f6 + 16.0f, vdn4.centerTop(f7 + 66.0f), jte.jyh(0xFFFFFF, 0.62f));
            for (int i = 0; i < 2; ++i) {
                this.jxl(drawContext, i, f, f2, n, f4 >= 0.99f);
            }
        }
        finally {
            uut.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private void jxl(DrawContext drawContext, int n, float f, float f2, int n2, boolean bl) {
        float f3 = 96.0f;
        float f4 = 20.0f;
        float f5 = this.jxi(n);
        float f6 = this.jxj();
        float f7 = this.jud[n].step(bl && jte.jyf(f, f2, f5, f6, f3, f4), this.jvc);
        boolean bl2 = n == 0;
        uut.round(drawContext, f5, f6, f3, f4, f4 * 0.5f, bl2 ? jte.jyh(n2, 0.3f + 0.25f * f7) : jte.jyh(0xFFFFFF, 0.05f + 0.08f * f7));
        uut.outline(drawContext, f5, f6, f3, f4, f4 * 0.5f, 0.7f, jte.jyh(bl2 ? n2 : jte.jyg(0xFFFFFF, n2, f7), bl2 ? 0.6f + 0.35f * f7 : 0.15f + 0.35f * f7));
        vdn vdn2 = veo.semibold(7.0f);
        String string = bl2 ? wap.s(a.b("\u0086\u791c\uf3d7\u6dbf\ue66a\u60d8\uda85\u5371", -1990393654), a.b("\ufb90\u823a\u08e3\u96e5\u1d45\u9b86\u21db", -876347466)) : wap.s(a.b("\uf2a9\u8b37\u01e7\u9f8a\u144b", -612568337), a.b("\ude67\ua7f1\u2d28\ub323\u38ff\ube47\u041a", -1351886217));
        float f8 = vdn2.width(string);
        if (bl2) {
            vjf.draw(drawContext, vhz.DOWNLOAD, f5 + (f3 - f8) * 0.5f - 5.0f, f6 + f4 * 0.5f, 8.0f, jte.jyh(0xFFFFFF, 0.95f));
        }
        vdn2.draw(drawContext, string, f5 + (f3 - f8) * 0.5f + (bl2 ? 3.0f : 0.0f), vdn2.centerTop(f6 + f4 * 0.5f), jte.jyh(0xFFFFFF, 0.95f));
    }

    private void jxm(kbs kbs2) {
        if (kbs2 == this.jug) {
            return;
        }
        this.jtu.close();
        this.jui = this.jug.key;
        this.juj = this.juh;
        this.jum = false;
        this.juk = kap.clock();
        this.jul = 0.9f;
        this.jug = kbs2;
        this.juh = new jsi(kbs2.particles, 7L + (long)kbs2.ordinal());
        kbs.select(kbs2);
        hyz.saveLater();
    }

    private static kbs jxn(String string) {
        kbs kbs2 = kbs.byKey(string);
        return kbs2 != null ? kbs2 : kbs.DEFAULT;
    }

    private static String jxo(int n) {
        return switch (n) {
            case 0 -> wap.s(vvi.get() + a.d("\uaeac\ud749\u5d87\uc3eb\u4824\uce9c", -2056648614, 1420338896), a.b("\u2ef6\u576a\uddbd\u43c7\uc817\u4edf\uf481\u791c", 2013342435) + vvi.get());
            case 1 -> wap.s(a.d("\u52c3\u2b45\ua197\u3fe6\ub42a\u329a\u88d4", -1867779212, -1590582798), a.b("\u7ccd\u055b\u8f8b\u11fb\u9a29\u1c9a", 1969584337));
            case 2 -> wap.s(a.b("\u7908\u009e\u8a40\u1424\u9ffa", -790857378), a.b("\u52b1\u2b63\ua1ca\u3fb8\ub418\u36c5\u888c\u017a\u9f26\u1596\u9244\u6831", -1092200804));
            case 3 -> wap.s(a.c(-122497966, "\ud41b\uad9d\u274f\ub93e\u32f2\ub442\u0e5f\u87ec\u19bd\u9315\u14c1"), a.b("\u07f0\u7e51\uf485\u6aff\ue15f\u67e7\uddce\u5432\uce78\u40d3\uc707\u3d75\ub3a3\u2a13\ua044", 1988690911));
            case 4 -> wap.s(a.b("\u134f\u6ac3\ue00a\u7e60\uf5bd\u7301\uc955\u40ad", -776989931), a.c(652020703, "\u0ff4\u765e\ufcf7\u6285\ue922\u6f9b\ud5c6\u5c3f\uc265\u48d9"));
            case 5 -> wap.s(a.d("\u89fa\uf06e\u7aae\ue4c6\u6f1f\ue9a5", -694349197, -277636149), a.c(-1928329783, "\u01d1\u7847\uf2e6\u6ce0\ue73e\u618e\udbd5\u522c\ucc76\u46ca\uc50c\u3b19\ub5b4\u2c06\ua658"));
            case 6 -> wap.s(a.c(748574822, "\u583f\u21bf\uab7f\u3508\ubec2\u3879\u8225\u0bdd\u9594"), a.b("\u681c\u11ba\u9b18\u056a\u8ec7\u0808\ub256", -530617284));
            case 7 -> wap.s(a.d("\u7f40\u06c0\u8c00\u1262\u99b8\u1f09\ua557\u2cbf", 903154723, -1690668229), a.b("\ufb01\u829f\u083c\u963d\u1de1\u9b50\u2108\ua8f3\u36d7", -1391329513));
            default -> "";
        };
    }

    private static String[] jxp(int n) {
        String[] stringArray;
        if (n == 1) {
            String[] stringArray2 = new String[3];
            stringArray2[0] = wap.s(a.d("\u1277\u6bef\ue13f\u7f5c", -1326154102, -1732350795), a.d("\udc71\ua5da\u2f07\ub171\u3aa4", 1599536237, 340272184));
            stringArray2[1] = wap.s(a.c(-126533446, "\u40ff\u3968\ub3b0\u2ddb\ua61d\u20bb"), a.c(680001806, "\u052d\u7c8f\uf654\u685a\ue38f"));
            stringArray = stringArray2;
            stringArray2[2] = wap.s(a.d("\u62c4\u1b4e\u9193\u0fed\u8426", 1264906015, 435916172), a.c(-540461249, "\u3318\u4ab7\uc01b\u5e1a\ud5cf\u537c"));
        } else {
            String[] stringArray3 = new String[4];
            stringArray3[0] = wap.s(a.b("\u2d37\u54ad\ude73\u4010\ucbc7", -538759819), a.b("\ua425\uddf7\u5753\uc92d\u42fb\uc44f", 435200002));
            stringArray3[1] = wap.s(a.d("\u334b\u4adf\uc01f\u5e77", -1074930333, 1963716200), a.d("\uab14\ud2d6\u5868\uc618\u4db9\ucb76", 440093542, 441508950));
            stringArray3[2] = wap.s(a.b("\uddc3\ua457\u2e8a\ub0f4\u3b3f", 564452746), a.b("\ub8fa\uc158\u4b8c\ud58a\u5e24\ud8e5\u62c8", 1009433820));
            stringArray = stringArray3;
            stringArray3[3] = wap.s(a.b("\u221f\u5b94\ud146\u4f2f\uc4fd\u424b\uf813", 1238508119), a.c(-238451201, "\u81e3\uf876\u72a6\ueca8\u677e\ue1cc"));
        }
        return stringArray;
    }

    private static vmc jxq(int n) {
        return n == 3 ? kbm.BLUR : (n == 4 ? kbm.ROUND : kbm.DIM);
    }

    private static boolean jxr(int n) {
        return switch (n) {
            case 0 -> kbm.TITLE.get();
            case 6 -> kbm.PARTICLES.get();
            default -> kbm.PARALLAX.get();
        };
    }

    private static float jxs(int n) {
        return switch (n) {
            case 1 -> kbm.POSITION.index();
            case 2 -> kbm.BUTTONS.index();
            case 3, 4, 5 -> (float)jte.jxq(n).getFraction();
            case 8 -> 0.0f;
            default -> jte.jxr(n) ? 1.0f : 0.0f;
        };
    }

    private float jxt(int n) {
        return this.jwt() + this.jwx() + 13.0f + (float)n * 19.0f - this.jut;
    }

    private float jxu() {
        return this.jwq() + 254.0f - 10.0f - 132.0f;
    }

    private float jxv() {
        return this.jxu() + 30.0f;
    }

    private float jxw() {
        return 98.0f;
    }

    private int jxx(float f, float f2) {
        if (!jte.jyf(f, f2, this.jwq(), this.jwt(), 254.0f, this.jwu())) {
            return -1;
        }
        for (int i = 0; i < 9; ++i) {
            if (!jte.jyf(f, f2, this.jwq() + 6.0f, this.jxt(i), 242.0f, 19.0f)) continue;
            return i;
        }
        return -1;
    }

    private void jxy(int n, float f) {
        switch (n) {
            case 0: {
                kbm.TITLE.toggle();
                break;
            }
            case 1: 
            case 2: {
                if (f < this.jxu()) {
                    return;
                }
                vlv vlv2 = n == 1 ? kbm.POSITION : kbm.BUTTONS;
                int n2 = vlv2.getModes().size();
                int n3 = Math.max(0, Math.min(n2 - 1, (int)((f - this.jxu()) / (132.0f / (float)n2))));
                vlv2.set(vlv2.getModes().get(n3));
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                if (f < this.jxv() - 6.0f) {
                    return;
                }
                this.jvp = n;
                this.jxz(n, f);
                return;
            }
            case 6: {
                kbm.PARTICLES.toggle();
                break;
            }
            case 7: {
                kbm.PARALLAX.toggle();
                break;
            }
            default: {
                this.jvo[8].set(1.0f);
                kbm.reset();
            }
        }
        hyz.saveLater();
    }

    private void jxz(int n, float f) {
        jte.jxq(n).setFromFraction(vcq.clamp01((f - this.jxv()) / this.jxw()));
    }

    private static int jya(kbs kbs2) {
        return kbs2.light ? 13225945 : kbs2.accent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jyb(DrawContext drawContext, float f, float f2, boolean bl) {
        int n = jte.jya(this.jug);
        vdn vdn2 = veo.medium(6.3f);
        vdn vdn3 = veo.medium(5.7f);
        float f3 = this.jwt();
        float f4 = f3 + this.jwu();
        for (int i = 0; i < 9; ++i) {
            float f5 = this.jxt(i);
            float f6 = this.jvo[i].step(jte.jxs(i), this.jvc);
            if (f5 + 19.0f < f3 || f5 > f4) {
                this.jvn[i].set(0.0f);
                continue;
            }
            boolean bl2 = bl && this.jvp < 0 && jte.jyf(f, f2, this.jwq() + 6.0f, f5, 242.0f, 19.0f);
            float f7 = this.jvn[i].step(bl2 || this.jvp == i, this.jvc);
            float f8 = f5 + 9.5f;
            boolean bl3 = i == 0 && this.jug.logo();
            uut.pushAlpha(bl3 ? 0.4f : 1.0f);
            try {
                this.jyc(drawContext, i, f5, f8, f6, f7, bl2, f, f2, n, vdn2, vdn3);
                continue;
            }
            finally {
                uut.popAlpha();
            }
        }
    }

    private void jyc(DrawContext drawContext, int n, float f, float f2, float f3, float f4, boolean bl, float f5, float f6, int n2, vdn vdn2, vdn vdn3) {
        if (n < 8) {
            uut.round(drawContext, this.jwq() + 6.0f, f + 1.0f, 242.0f, 17.0f, 5.0f, jte.jyh(0xFFFFFF, 0.05f * f4));
        }
        if (n < 8) {
            vdn2.draw(drawContext, jte.jxo(n), this.jwq() + 12.0f, vdn2.centerTop(f2), jte.jyh(0xFFFFFF, 0.78f + 0.2f * f4));
        }
        switch (n) {
            case 1: 
            case 2: {
                String[] stringArray = jte.jxp(n);
                int n3 = stringArray.length;
                float f7 = 132.0f / (float)n3;
                float f8 = this.jxu();
                uut.round(drawContext, f8, f2 - 6.5f, 132.0f, 13.0f, 6.5f, jte.jyh(0xFFFFFF, 0.07f));
                uut.round(drawContext, f8 + f3 * f7 + 1.0f, f2 - 5.5f, f7 - 2.0f, 11.0f, 5.5f, jte.jyh(n2, 0.38f));
                uut.outline(drawContext, f8 + f3 * f7 + 1.0f, f2 - 5.5f, f7 - 2.0f, 11.0f, 5.5f, 0.6f, jte.jyh(n2, 0.7f));
                int n4 = Math.round(f3);
                for (int i = 0; i < n3; ++i) {
                    vdn3.drawCentered(drawContext, stringArray[i], f8 + f7 * ((float)i + 0.5f), vdn3.centerTop(f2), jte.jyh(0xFFFFFF, i == n4 ? 1.0f : 0.62f));
                }
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                vmc vmc2 = jte.jxq(n);
                float f9 = this.jxv();
                float f10 = this.jxw();
                vdn3.drawRight(drawContext, vmc2.display(), f9 - 6.0f, vdn3.centerTop(f2), jte.jyh(0xFFFFFF, 0.7f));
                uut.round(drawContext, f9, f2 - 1.5f, f10, 3.0f, 1.5f, jte.jyh(0xFFFFFF, 0.14f));
                uut.round(drawContext, f9, f2 - 1.5f, Math.max(3.0f, f10 * f3), 3.0f, 1.5f, jte.jyh(n2, 0.9f));
                uut.circle(drawContext, f9 + f10 * f3, f2, 4.0f + 0.8f * f4, jte.jyh(0xFFFFFF, 1.0f));
                uut.circle(drawContext, f9 + f10 * f3, f2, 1.8f, jte.jyh(n2, 1.0f));
                break;
            }
            case 8: {
                float f11 = 234.0f;
                float f12 = this.jwq() + 10.0f;
                boolean bl2 = bl && jte.jyf(f5, f6, f12, f2 - 7.0f, f11, 14.0f);
                uut.round(drawContext, f12, f2 - 6.5f, f11, 13.0f, 6.5f, jte.jyh(jte.jyg(0xFFFFFF, n2, f3), 0.08f + (bl2 ? 0.1f : 0.0f) + 0.3f * f3));
                uut.outline(drawContext, f12, f2 - 6.5f, f11, 13.0f, 6.5f, 0.6f, jte.jyh(0xFFFFFF, bl2 ? 0.38f : 0.18f));
                String string = wap.s(a.b("\u811a\uf89c\u7259\uec3e\u67f8", 2146599245), a.d("\u6228\u1b89\u912b\u0f24\u848c\u0244\ub86d\u3192", 1389522638, -1972696881));
                float f13 = vdn3.width(string) + 11.0f;
                vjf.draw(drawContext, vhz.REFRESH, f12 + (f11 - f13) * 0.5f + 3.5f, f2, 7.0f, jte.jyh(0xFFFFFF, 0.85f));
                vdn3.draw(drawContext, string, f12 + (f11 - f13) * 0.5f + 11.0f, vdn3.centerTop(f2), jte.jyh(0xFFFFFF, 0.9f));
                break;
            }
            default: {
                float f14 = 20.0f;
                float f15 = this.jwq() + 254.0f - 10.0f - f14;
                uut.round(drawContext, f15, f2 - 5.5f, f14, 11.0f, 5.5f, jte.jyh(jte.jyg(3817552, n2, f3), 0.55f + 0.4f * f3));
                uut.circle(drawContext, f15 + 5.5f + 9.0f * f3, f2, 4.0f, jte.jyh(0xFFFFFF, 1.0f));
            }
        }
    }

    public boolean mouseClicked(Click click, boolean doubled) {
        int n;
        if (click.button() != 0) {
            return true;
        }
        float f = (float)click.x() / this.jvd;
        float f2 = (float)click.y() / this.jvd;
        if (this.jux >= 0 || this.juy >= 0.0f) {
            return true;
        }
        if (this.jur) {
            float f3 = 96.0f;
            if (jte.jyf(f, f2, this.jxi(0), this.jxj(), f3, 20.0f)) {
                jte.jye(a.c(-95082218, "\u2933\u509e\uda4d\u4438\ucfec\u4914\uf352\u7aa3\ue4be\u6e0d\ue9d5\u13b2\u9d7e\u04c8\u8e81\u086c\ub265\u3df9\ua746\u2115\ua8a0\ud2b3\u5c02\uc7d8\u41ec\ucb7b\u72cf\ufcdd\u6660\ue037\u6b88\u9551\u1f56\u86eb\u00ba\u8a0b\u35d0\ubfbb\u3973\ua0d8\u2ade\u5471\ude26\u5989\uc343\u4d25\uf4fd\u7e41\uf819\u6395\uedbf\u177d\u9edd\u188d\u8264\u0c33\ub78d\u3141\ubb7e\u22f7\uac1a\ud647\u51ab\udbe6\u452a\ucc84\u76c8\uf039\u7a79\ue582\u6f00\ue92a\u10f2\u9a40\u0403\u8fe9\u09b4"));
                this.jur = false;
            } else if (jte.jyf(f, f2, this.jxi(1), this.jxj(), f3, 20.0f) || !jte.jyf(f, f2, this.jxg(), this.jxh(), 228.0f, 118.0f)) {
                this.jur = false;
            }
            return true;
        }
        if (this.juq) {
            if (this.jxb(f, f2)) {
                int n2 = this.jxc(f, f2);
                if (n2 >= 0) {
                    this.juf[n2] = kap.clock();
                    this.jxm(kbs.values()[n2]);
                } else {
                    int n3 = this.jxx(f, f2);
                    if (n3 >= 0) {
                        this.jxy(n3, f);
                    }
                }
                return true;
            }
            if (!jte.jyf(f, f2, this.jwn(2), 12.0f, 21.0f, 21.0f)) {
                this.juq = false;
            }
        }
        for (n = 0; n < 4; ++n) {
            if (!jte.jyf(f, f2, this.jwn(n), 12.0f, 21.0f, 21.0f)) continue;
            this.jue[n] = kap.clock();
            switch (n) {
                case 0: {
                    jte.jye(TELEGRAM);
                    break;
                }
                case 1: {
                    jte.jye(a.c(-239718413, "\u2f87\u562a\udcf9\u428c\uc958\u4fa0\uf5e6\u7c17\ue203\u68bf\uef76\u1517\u9bcc\u0260\u8825\u0e9e\ub498\u3b49\ua1b2\u27ab\uae0f\ud40c\u5ab4\uc151\u471a\ucde1\u7470\ufa16"));
                    break;
                }
                case 2: {
                    boolean bl = this.juq = !this.juq;
                    if (!this.juq) break;
                    float f4 = this.jxa(this.jug.ordinal()) + this.jut - this.jwt();
                    this.juu = this.jut = Math.max(0.0f, Math.min(this.jwy(), f4 - this.jwu() * 0.35f));
                    break;
                }
                default: {
                    this.juy = kap.clock() + 0.28f;
                }
            }
            return true;
        }
        for (n = 0; n < 4; ++n) {
            if (!jte.jyf(f, f2, this.jwk(), this.jwj(n), 138.0f, 25.0f)) continue;
            this.jus = n;
            this.juv = kap.clock();
            this.juw = f - this.jwk();
            if (n == 2 && !jrn.available()) {
                this.jur = true;
            } else {
                this.jux = n;
            }
            return true;
        }
        return true;
    }

    public boolean mouseDragged(Click click, double offsetX, double offsetY) {
        if (this.jvp >= 0) {
            this.jxz(this.jvp, (float)click.x() / this.jvd);
            return true;
        }
        return super.mouseDragged(click, offsetX, offsetY);
    }

    public boolean mouseReleased(Click click) {
        if (this.jvp >= 0) {
            this.jvp = -1;
            hyz.saveLater();
            return true;
        }
        return super.mouseReleased(click);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.juq && this.jxb((float)mouseX / this.jvd, (float)mouseY / this.jvd)) {
            this.juu = Math.max(0.0f, Math.min(this.jwy(), this.juu - (float)verticalAmount * 28.0f));
        }
        return true;
    }

    private void jyd(int n) {
        MinecraftClient minecraftClient = this.client;
        switch (n) {
            case 0: {
                minecraftClient.setScreen((Screen)new SelectWorldScreen((Screen)this));
                break;
            }
            case 1: {
                minecraftClient.setScreen((Screen)(minecraftClient.options.skipMultiplayerWarning ? new MultiplayerScreen((Screen)this) : new MultiplayerWarningScreen((Screen)this)));
                break;
            }
            case 2: {
                if (jrn.available()) {
                    minecraftClient.setScreen((Screen)new jos(this));
                    break;
                }
                this.jur = true;
                break;
            }
            default: {
                minecraftClient.setScreen((Screen)new OptionsScreen((Screen)this, minecraftClient.options));
            }
        }
    }

    private static void jye(String string) {
        try {
            Util.getOperatingSystem().open(URI.create(string));
        }
        catch (Exception exception) {
            System.out.println(a.c(945862716, "\ub854\uc1e7\u4b3b\ud503\u5e87\ud862\u627e\ueb90\u75da\uff60\u78fd") + string + a.b("\ub9da\uc071", 382122466) + exception);
        }
    }

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

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public boolean shouldPause() {
        return false;
    }

    public void removed() {
        this.jup = true;
        this.juq = false;
        this.jvp = -1;
        this.jub.set(0.0f);
        this.jur = false;
        this.juc.set(0.0f);
        this.jux = -1;
        this.jtt.close();
        this.jtu.close();
        this.jtx.close();
        vdn.setRenderScale(1.0f);
    }

    private static boolean jyf(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f2 >= f4 && f < f3 + f5 && f2 < f4 + f6;
    }

    private static int jyg(int n, int n2, float f) {
        return kce.mix(n, n2, f);
    }

    private static int jyh(int n, float f) {
        return kce.rgba(n, f);
    }

    static {
        DISCORD = a.c(767143374, "\uadba\ud417\u5ec4\uc0b1\u4b65\ucd9d\u77db\ufe2a\u603e\uea82\u6d4b\u972a\u19f1\u805d\u0a18\u8ca3\u36a5\ub974\u238f\ua596\u2c32\u5631\ud889\u436c\uc527\u4fdc\uf64d\u782b");
        TELEGRAM = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 't', '.', 'm', 'e', '/', 'F', 'l', 'o', 'w', 'w', 'C', 'l', 'i', 'e', 'n', 't'});
    }

    private static /* synthetic */ int aqe(int n, int n2) {
        return n - n2 ^ 0x2098534E;
    }
}

