/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_155
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_429
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_4749
 *  net.minecraft.class_500
 *  net.minecraft.class_526
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.PanicShutdown;
import a.GuiConfig;
import a.AccountsScreen;
import a.IasCompat;
import a.MenuSnowRenderer;
import a.jza;
import a.MenuArtCache;
import a.kam;
import a.MenuSceneRenderer;
import a.TitleLayoutSetting;
import a.MenuScale;
import a.WallpaperEntry;
import a.WordmarkAnimator;
import a.FrameDelta;
import a.GlowSprite;
import a.GpuTexture;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.IconRenderer;
import a.ModeSetting;
import a.NumberSetting;
import a.EncodedString;
import a.Lang;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.net.URI;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_155;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_429;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_4749;
import net.minecraft.class_500;
import net.minecraft.class_526;
import org.joml.Matrix3x2fStack;

public final class MenuScreen
extends class_437 {
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
    private final MenuSceneRenderer jtt = new MenuSceneRenderer();
    private final MenuSceneRenderer jtu = new MenuSceneRenderer();
    private final kam jtv = new kam();
    private final kam jtw = new kam();
    private final WordmarkAnimator jtx = new WordmarkAnimator(34.0f);
    private final Spring[] jty = new Spring[4];
    private final Spring[] jtz = new Spring[4];
    private final Spring[] jua = new Spring[WallpaperEntry.values().length];
    private final Spring jub = new Spring(11.0f);
    private final Spring juc = new Spring(10.0f);
    private final Spring[] jud = new Spring[]{new Spring(14.0f), new Spring(14.0f)};
    private final float[] jue = new float[]{-10.0f, -10.0f, -10.0f, -10.0f};
    private final float[] juf = new float[WallpaperEntry.values().length];
    private WallpaperEntry jug = WallpaperEntry.selected();
    private MenuSnowRenderer juh;
    private String jui;
    private MenuSnowRenderer juj;
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
    private final Spring jvj;
    private final Spring jvk;
    private final Spring jvl;
    private final Spring jvm;
    private final Spring[] jvn;
    private final Spring[] jvo;
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

    public MenuScreen() {
        super((class_2561)class_2561.method_43470((String)EncodedString.get()));
        int n;
        this.juh = new MenuSnowRenderer(this.jug.particles, 7L);
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
        this.jvj = new Spring(9.0f, TitleLayoutSetting.TITLE.get() && !WallpaperEntry.selected().logo() ? 1.0f : 0.0f);
        this.jvk = new Spring(6.0f, WallpaperEntry.selected().logo() ? 1.0f : 0.0f);
        this.jvl = new Spring(6.0f, WallpaperEntry.selected().light ? 1.0f : 0.0f);
        this.jvm = new Spring(6.0f, TitleLayoutSetting.PARTICLES.get() ? 1.0f : 0.0f);
        this.jvn = new Spring[9];
        this.jvo = new Spring[9];
        this.jvp = -1;
        this.jvq = -1.0f;
        for (n = 0; n < 4; ++n) {
            this.jty[n] = new Spring(14.0f);
        }
        for (n = 0; n < 4; ++n) {
            this.jtz[n] = new Spring(14.0f);
        }
        for (n = 0; n < 9; ++n) {
            this.jvn[n] = new Spring(14.0f);
            this.jvo[n] = new Spring(14.0f, MenuScreen.jxs(n));
        }
        for (n = 0; n < this.jua.length; ++n) {
            this.jua[n] = new Spring(14.0f);
            this.juf[n] = -10.0f;
        }
        MenuArtCache.preload(this.jug.key);
    }

    public static MenuScreen afterWelcome() {
        MenuScreen jte2 = new MenuScreen();
        jte2.jum = true;
        return jte2;
    }

    protected void method_25426() {
        if (PanicShutdown.armed() && this.field_22787 != null) {
            this.field_22787.method_1507((class_437)new class_442());
            return;
        }
        if (this.jup) {
            this.jup = false;
            this.juo = MenuSceneRenderer.clock() - 0.3f;
            this.jux = -1;
            this.jus = -1;
        }
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        DrawUtil.beginFrame();
        FrameDelta.observe(class_3322);
        long l = System.nanoTime();
        if (this.field_22789 < 64 || this.field_22790 < 64) {
            this.jvb = 0L;
            return;
        }
        if (this.field_22789 != this.jvh || this.field_22790 != this.jvi) {
            this.jvh = this.field_22789;
            this.jvi = this.field_22790;
            this.jvg = -1.0f;
        }
        this.jvc = this.jvb == 0L ? 0.016666668f : Math.min(0.1f, (float)(l - this.jvb) / 1.0E9f);
        this.jvb = l;
        float f2 = MenuSceneRenderer.clock();
        if (this.jun < 0.0f) {
            this.jun = f2;
            this.juo = f2;
            this.jvq = f2;
        }
        float f3 = f2 - this.jun;
        float f4 = f2 - this.jvq;
        this.jvd = MenuScale.scale(this.field_22789, this.field_22790);
        this.jve = (float)this.field_22789 / this.jvd;
        this.jvf = (float)this.field_22790 / this.jvd;
        float f5 = (float)n / this.jvd;
        float f6 = (float)n2 / this.jvd;
        float f7 = 1.0f - (float)Math.exp(-this.jvc * 2.2f);
        if (!TitleLayoutSetting.PARALLAX.get()) {
            this.juz -= this.juz * f7;
            this.jva -= this.jva * f7;
        } else if (n >= 0 && n2 >= 0 && n <= this.field_22789 && n2 <= this.field_22790) {
            this.juz += ((float)n / (float)this.field_22789 - 0.5f - this.juz) * f7;
            this.jva += ((float)n2 / (float)this.field_22790 - 0.5f - this.jva) * f7;
        }
        float f8 = this.jwl();
        this.jvg = this.jvg < 0.0f ? f8 : this.jvg + (f8 - this.jvg) * (1.0f - (float)Math.exp(-this.jvc * 9.0f));
        float f9 = this.jvj.step(TitleLayoutSetting.TITLE.get() && !this.jug.logo(), this.jvc);
        this.jvk.step(this.jug.logo(), this.jvc);
        this.jvl.step(this.jug.light, this.jvc);
        float f10 = this.jvm.step(TitleLayoutSetting.PARTICLES.get(), this.jvc);
        GpuTextureView gpuTextureView = GlowSprite.view();
        this.jwe(class_3322, f2, f3);
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.scale(this.jvd, this.jvd);
        FontFace.setRenderScaleStepped(this.jvd);
        try {
            this.jwf(class_3322);
            float f11 = this.jwd();
            if (this.juj != null && f11 > 0.0f) {
                this.juj.draw(class_3322, gpuTextureView, this.jve, this.jvf, f2, false, this.juz, this.jva, f11 * f10);
            }
            this.juh.draw(class_3322, gpuTextureView, this.jve, this.jvf, f2, false, this.juz, this.jva, Easing.clamp01(f3 / 1.2f) * (1.0f - f11) * f10);
            float f12 = this.jvd * (float)class_310.method_1551().method_22683().method_4495();
            float f13 = Easing.clamp01((f4 - 0.1f) / 1.25f);
            if (f9 > 0.01f) {
                float f14 = this.jtx.width(f12) * 0.5f + 14.0f;
                float f15 = Math.max(f14, Math.min(this.jve - f14, this.jvg + 69.0f));
                DrawUtil.pushAlpha(f9);
                this.jtx.draw(class_3322, gpuTextureView, f15 - this.juz * 5.0f, this.jvf * 0.5f - 75.0f - this.jva * 3.0f - (1.0f - f9) * 8.0f, 1.0f, f12, f2, f13, this.juz * 2.0f, this.jva * 2.0f, this.jug.accent);
                DrawUtil.popAlpha();
            }
            boolean bl = this.juq && this.jxb(f5, f6);
            for (int i = 0; i < 4; ++i) {
                this.jwm(class_3322, gpuTextureView, i, f5, f6, f2, bl);
            }
            if (this.juj != null && f11 > 0.0f) {
                this.juj.draw(class_3322, gpuTextureView, this.jve, this.jvf, f2, true, this.juz, this.jva, f11 * f10);
            }
            this.juh.draw(class_3322, gpuTextureView, this.jve, this.jvf, f2, true, this.juz, this.jva, Easing.clamp01(f3 / 1.2f) * (1.0f - f11) * f10);
            float f16 = Easing.outCubic(Easing.clamp01((f4 - 0.6f) / 0.7f));
            DrawUtil.pushAlpha(f16);
            try {
                for (int i = 0; i < 4; ++i) {
                    this.jwo(class_3322, gpuTextureView, i, f5, f6, f16);
                }
                this.jwp(class_3322);
            }
            finally {
                DrawUtil.popAlpha();
            }
            this.jxd(class_3322, f5, f6);
            this.jxk(class_3322, gpuTextureView, f5, f6, f2);
        }
        finally {
            DrawUtil.additive(false);
            matrix3x2fStack.popMatrix();
            FontFace.setRenderScale(1.0f);
        }
        if (this.jux >= 0 && f2 - this.juv >= 0.24f) {
            int n3 = this.jux;
            this.jux = -1;
            this.jyd(n3);
        }
        if (this.juy >= 0.0f && f2 >= this.juy) {
            this.juy = -1.0f;
            this.field_22787.method_1592();
        }
    }

    private float jwd() {
        if (this.jui == null) {
            return 0.0f;
        }
        float f = 1.0f - Easing.inOutCubic((MenuSceneRenderer.clock() - this.juk) / this.jul);
        if (f <= 0.0f) {
            this.jui = null;
            this.juj = null;
            this.jtu.close();
            MenuArtCache.releaseExcept(this.jug.key);
            return 0.0f;
        }
        return f;
    }

    private void jwe(class_332 class_3322, float f, float f2) {
        jza jza2;
        float f3;
        jza jza3 = MenuArtCache.get(this.jug.key);
        if (jza3 == null && this.jui != null) {
            this.juk = f;
        }
        float f4 = this.jwd();
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, -16118250);
        float f5 = f3 = this.jum ? Easing.inOutCubic(Easing.clamp01((f2 - 0.1f) / 1.3f)) : 1.0f;
        if (jza3 != null) {
            this.jtv.time = f;
            this.jtv.zoom = 1.05f + 0.01f * (1.0f - f3);
            this.jtv.panX = -this.juz * 0.014f * f3;
            this.jtv.panY = -this.jva * 0.01f * f3;
            this.jtv.blur = 1.0f - f3;
            this.jtv.dim = 0.04f + 0.18f * (1.0f - f3) + (float)TitleLayoutSetting.DIM.get();
            this.jtv.tint = this.jug.tint;
            this.jtv.tintAmount = 0.3f;
            this.jtv.fall = null;
            this.jtv.pool = null;
            this.jwh(this.jtv, f3);
            this.jtt.draw(class_3322, jza3, this.jtv, this.field_22789, this.field_22790, 1.0f, true);
        }
        if (f4 > 0.0f && (jza2 = MenuArtCache.get(this.jui)) != null) {
            this.jtw.time = f;
            this.jtw.panX = this.jtv.panX;
            this.jtw.panY = this.jtv.panY;
            WallpaperEntry kbs2 = MenuScreen.jxn(this.jui);
            this.jtw.blur = 0.0f;
            this.jtw.dim = 0.04f + (float)TitleLayoutSetting.DIM.get();
            this.jtw.zoom = 1.05f;
            this.jtw.tint = kbs2.tint;
            this.jtw.tintAmount = 0.3f;
            this.jtw.fall = null;
            this.jtw.pool = null;
            this.jwh(this.jtw, 1.0f);
            this.jtu.draw(class_3322, jza2, this.jtw, this.field_22789, this.field_22790, f4, false);
        }
    }

    private void jwf(class_332 class_3322) {
        float f = 1.0f - this.jvl.get();
        if (f <= 0.01f) {
            return;
        }
        DrawUtil.gradientV(class_3322, 0.0f, 0.0f, this.jve, 120.0f, 0.0f, MenuScreen.jyh(329484, 0.42f * f), MenuScreen.jyh(329484, 0.0f));
        DrawUtil.gradientV(class_3322, 0.0f, this.jvf - 90.0f, this.jve, 90.0f, 0.0f, MenuScreen.jyh(329484, 0.0f), MenuScreen.jyh(329484, 0.5f * f));
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.jve, this.jvf, MenuScreen.jyh(329484, 0.08f * f));
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
    private void jwm(class_332 var1_1, GpuTextureView var2_2, int var3_3, float var4_4, float var5_5, float var6_6, boolean var7_7) {
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
    private void jwo(class_332 class_3322, GpuTextureView gpuTextureView, int n, float f, float f2, float f3) {
        float f4;
        float f5 = this.jwn(n);
        float f6 = 12.0f + (1.0f - f3) * -8.0f;
        boolean bl = !this.jur && MenuScreen.jyf(f, f2, f5, 12.0f, 21.0f, 21.0f) && (!this.juq || n == 2 || !this.jxb(f, f2));
        float f7 = this.jtz[n].step(bl || n == 2 && this.juq, this.jvc);
        float f8 = Easing.clamp01((MenuSceneRenderer.clock() - this.jue[n]) / 0.5f);
        float f9 = f8 < 1.0f ? (float)Math.sin(Math.PI * (double)Easing.clamp01(f8 * 2.4f)) * (1.0f - f8 * 0.5f) : 0.0f;
        int n2 = switch (n) {
            case 0 -> 2796526;
            case 1 -> 8227839;
            case 2 -> this.jug.accent;
            default -> 0xFF6B6B;
        };
        float f10 = 10.5f;
        float f11 = f5 + f10;
        float f12 = f6 + f10;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f11, f12);
        float f13 = 1.0f + 0.08f * f7 - 0.14f * f9;
        matrix3x2fStack.scale(f13, f13);
        try {
            float f14;
            if (f8 < 1.0f) {
                f14 = 8.0f * Easing.outCubic(f8);
                DrawUtil.circleOutline(class_3322, 0.0f, 0.0f, f10 + f14, 1.0f, MenuScreen.jyh(n2, 0.75f * (1.0f - f8)));
            }
            f14 = this.jvl.get();
            int n3 = MenuScreen.jyg(0xFFFFFF, 1842982, f14);
            DrawUtil.shadow(class_3322, -f10, -f10 + 2.0f, 21.0f, 21.0f, f10, 10.0f, MenuScreen.jyh(0, 0.3f - 0.2f * f14));
            if (gpuTextureView != null && f7 > 0.01f) {
                DrawUtil.additive(true);
                DrawUtil.sprite(class_3322, gpuTextureView, 0.0f, 0.0f, 54.6f, MenuScreen.jyh(n2, 0.22f * f7));
                DrawUtil.additive(false);
            }
            this.jtt.frosted(class_3322, -f10, -f10, 21.0f, 21.0f, f10, f5, f6, this.jve, this.jvf, MenuScreen.jyh(0xFFFFFF, 1.0f));
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(-f10, -f10);
            DrawUtil.round(class_3322, 0.0f, 0.0f, 21.0f, 21.0f, f10, MenuScreen.jyh(MenuScreen.jyg(790552, 0xFFFFFF, f14), 0.36f - 0.1f * f7 + 0.26f * f14));
            DrawUtil.round(class_3322, 0.0f, 0.0f, 21.0f, 21.0f, f10, MenuScreen.jyh(n2, 0.16f * f7));
            DrawUtil.outlineGradientV(class_3322, 0.0f, 0.0f, 21.0f, 21.0f, f10, 0.7f, MenuScreen.jyh(MenuScreen.jyg(n3, n2, f7), (0.32f + 0.4f * f7) * (1.0f - 0.55f * f14)), MenuScreen.jyh(MenuScreen.jyg(n3, n2, f7), (0.08f + 0.25f * f7) * (1.0f + 0.5f * f14)));
            matrix3x2fStack.popMatrix();
            Icon vhz2 = switch (n) {
                case 0 -> Icon.TELEGRAM;
                case 1 -> Icon.DISCORD;
                case 2 -> Icon.IMAGE;
                default -> Icon.POWER;
            };
            f4 = n < 2 ? 11.5f : 10.5f;
            IconRenderer.draw(class_3322, vhz2, n == 0 ? -0.6f : 0.0f, 0.0f, f4, MenuScreen.jyh(MenuScreen.jyg(MenuScreen.jyg(15331062, 2764342, f14), MenuScreen.jyg(n2, MenuScreen.jyg(0xFFFFFF, 0, f14), 0.25f), f7), 1.0f));
        }
        finally {
            matrix3x2fStack.popMatrix();
        }
        if (f7 > 0.01f && (n != 2 || !this.juq)) {
            String string = switch (n) {
                case 0 -> "Telegram";
                case 1 -> "Discord";
                case 2 -> Lang.s("Background", "Фон меню");
                default -> Lang.s("Quit", "Выйти");
            };
            FontFace vdn2 = Fonts.medium(6.4f);
            float f15 = vdn2.width(string) + 12.0f;
            f4 = Math.min(this.jve - 12.0f - f15, f11 - f15 * 0.5f);
            float f16 = 38.0f + (1.0f - f7) * -3.0f;
            DrawUtil.pushAlpha(f7);
            DrawUtil.round(class_3322, f4, f16, f15, 13.0f, 6.5f, MenuScreen.jyh(790552, 0.78f));
            DrawUtil.outline(class_3322, f4, f16, f15, 13.0f, 6.5f, 0.6f, MenuScreen.jyh(0xFFFFFF, 0.14f));
            vdn2.drawCentered(class_3322, string, f4 + f15 * 0.5f, vdn2.centerTop(f16 + 6.5f), MenuScreen.jyh(0xFFFFFF, 0.95f));
            DrawUtil.popAlpha();
        }
    }

    private void jwp(class_332 class_3322) {
        FontFace vdn2 = Fonts.medium(6.2f);
        String string = "Minecraft " + class_155.method_16673().comp_4025();
        vdn2.drawRight(class_3322, string, this.jve - 12.0f, vdn2.centerTop(this.jvf - 12.0f), MenuScreen.jyh(MenuScreen.jyg(0xFFFFFF, 2764342, this.jvl.get()), 0.55f));
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
        return 13.0f + (float)MenuScreen.jwv(WallpaperEntry.values().length, 3) * 62.0f + 2.0f;
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
        return this.jub.get() > 0.5f && MenuScreen.jyf(f, f2, this.jwq(), this.jwr(), 254.0f, this.jws());
    }

    private int jxc(float f, float f2) {
        if (!MenuScreen.jyf(f, f2, this.jwq(), this.jwt(), 254.0f, this.jwu())) {
            return -1;
        }
        WallpaperEntry[] kbsArray = WallpaperEntry.values();
        for (int i = 0; i < kbsArray.length; ++i) {
            if (!MenuScreen.jyf(f, f2, this.jwz(i), this.jxa(i), 74.0f, 54.0f)) continue;
            return i;
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jxd(class_332 class_3322, float f, float f2) {
        float f3 = this.jub.step(this.juq, this.jvc);
        if (f3 <= 0.003f) {
            return;
        }
        float f4 = Easing.outCubic(f3);
        float f5 = this.jwq();
        float f6 = this.jwr();
        float f7 = this.jws();
        float f8 = 11.0f;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        float f9 = this.jwn(2) + 10.5f;
        matrix3x2fStack.translate(f9, f6);
        matrix3x2fStack.scale(0.9f + 0.1f * f4, 0.9f + 0.1f * f4);
        matrix3x2fStack.translate(-f9, -f6 - (1.0f - f4) * 6.0f);
        DrawUtil.pushAlpha(f4);
        try {
            DrawUtil.shadow(class_3322, f5, f6 + 4.0f, 254.0f, f7, f8, 22.0f, MenuScreen.jyh(0, 0.45f));
            this.jtt.frosted(class_3322, f5, f6, 254.0f, f7, f8, this.jve, this.jvf, MenuScreen.jyh(0xFFFFFF, 1.0f));
            DrawUtil.round(class_3322, f5, f6, 254.0f, f7, f8, MenuScreen.jyh(724759, 0.55f));
            DrawUtil.outlineGradientV(class_3322, f5, f6, 254.0f, f7, f8, 0.7f, MenuScreen.jyh(0xFFFFFF, 0.3f), MenuScreen.jyh(0xFFFFFF, 0.07f));
            FontFace vdn2 = Fonts.semibold(7.6f);
            IconRenderer.draw(class_3322, Icon.IMAGE, f5 + 15.0f, f6 + 12.5f, 9.0f, MenuScreen.jyh(MenuScreen.jya(this.jug), 1.0f));
            vdn2.draw(class_3322, Lang.s("Menu background", "Фон меню"), f5 + 24.0f, vdn2.centerTop(f6 + 12.5f), MenuScreen.jyh(0xFFFFFF, 0.95f));
            this.juu = Math.max(0.0f, Math.min(this.jwy(), this.juu));
            this.jut += (this.juu - this.jut) * (1.0f - (float)Math.exp(-this.jvc * 16.0f));
            float f10 = this.jwt();
            float f11 = this.jwu();
            int n = f3 >= 0.99f ? this.jxc(f, f2) : -1;
            DrawUtil.pushScissor(class_3322, f5, f10, 254.0f, f11);
            try {
                FontFace vdn3 = Fonts.medium(6.0f);
                for (int i = 0; i < 2; ++i) {
                    float f12 = f10 + (i == 1 ? this.jwx() : 0.0f) - this.jut;
                    String string = i == 0 ? Lang.s("Wallpapers", "Обои") : Lang.s("Menu look", "Вид меню");
                    vdn3.drawTracked(class_3322, string.toUpperCase(), f5 + 10.0f, vdn3.centerTop(f12 + 6.5f), MenuScreen.jyh(0xFFFFFF, 0.5f), 0.8f);
                    float f13 = vdn3.width(string.toUpperCase(), 0.8f);
                    DrawUtil.rect(class_3322, f5 + 16.0f + f13, f12 + 6.5f, 228.0f - f13, 0.5f, MenuScreen.jyh(0xFFFFFF, 0.1f));
                }
                WallpaperEntry[] kbsArray = WallpaperEntry.values();
                for (int i = 0; i < kbsArray.length; ++i) {
                    float f14 = this.jxa(i);
                    if (f14 + 42.0f + 14.0f < f10 || f14 > f10 + f11) {
                        this.jua[i].set(0.0f);
                        continue;
                    }
                    this.jxe(class_3322, kbsArray[i], i, n == i);
                }
                this.jyb(class_3322, f, f2, f3 >= 0.99f);
            }
            finally {
                DrawUtil.popScissor(class_3322);
            }
            float f15 = this.jwy();
            if (f15 > 0.5f) {
                DrawUtil.gradientV(class_3322, f5 + 1.0f, f10, 252.0f, 8.0f, 0.0f, MenuScreen.jyh(724759, 0.55f * Easing.clamp01(this.jut / 8.0f)), MenuScreen.jyh(724759, 0.0f));
                DrawUtil.gradientV(class_3322, f5 + 1.0f, f10 + f11 - 8.0f, 252.0f, 8.0f, 0.0f, MenuScreen.jyh(724759, 0.0f), MenuScreen.jyh(724759, 0.55f * Easing.clamp01((f15 - this.jut) / 8.0f)));
                float f16 = Math.max(14.0f, f11 * f11 / this.jww());
                float f17 = f10 + (f11 - f16) * (this.jut / f15);
                DrawUtil.round(class_3322, f5 + 254.0f - 4.5f, f17, 2.0f, f16, 1.0f, MenuScreen.jyh(0xFFFFFF, 0.28f));
            }
        }
        finally {
            DrawUtil.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jxe(class_332 class_3322, WallpaperEntry kbs2, int n, boolean bl) {
        float f = this.jwz(n);
        float f2 = this.jxa(n);
        float f3 = 7.0f;
        float f4 = 74.0f;
        float f5 = 42.0f;
        float f6 = this.jua[n].step(bl, this.jvc);
        boolean bl2 = kbs2 == this.jug;
        float f7 = Easing.clamp01((MenuSceneRenderer.clock() - this.juf[n]) / 0.45f);
        float f8 = f7 < 1.0f ? (float)Math.sin(Math.PI * (double)Easing.clamp01(f7 * 2.4f)) * (1.0f - f7 * 0.5f) : 0.0f;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f + f4 * 0.5f, f2 + f5 * 0.5f);
        matrix3x2fStack.scale(1.0f - 0.06f * f8, 1.0f - 0.06f * f8);
        matrix3x2fStack.translate(-f - f4 * 0.5f, -f2 - f5 * 0.5f);
        try {
            this.jxf(class_3322, kbs2, f, f2, f4, f5, f3, f6, bl2);
        }
        finally {
            matrix3x2fStack.popMatrix();
        }
    }

    private void jxf(class_332 class_3322, WallpaperEntry kbs2, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        GpuTexture uok2 = MenuArtCache.thumb(kbs2.key);
        if (uok2 != null) {
            float f7 = (float)uok2.width / (float)uok2.height;
            float f8 = f3 / f4;
            float f9 = f7 > f8 ? (1.0f - f8 / f7) * 0.5f : 0.0f;
            float f10 = f7 > f8 ? 0.0f : (1.0f - f7 / f8) * 0.5f;
            float f11 = 0.04f * f6;
            DrawUtil.imageRegion(class_3322, uok2.view, f, f2, f3, f4, f5, f9 + f11, f10 + f11, 1.0f - f9 - f11, 1.0f - f10 - f11, MenuScreen.jyh(0xFFFFFF, 1.0f), false);
        } else {
            DrawUtil.round(class_3322, f, f2, f3, f4, f5, MenuScreen.jyh(0xFFFFFF, 0.08f));
        }
        DrawUtil.round(class_3322, f, f2, f3, f4, f5, MenuScreen.jyh(0, 0.18f * (1.0f - f6)));
        if (kbs2.isVideo()) {
            DrawUtil.circle(class_3322, f + 7.0f, f2 + f4 - 7.0f, 4.2f, MenuScreen.jyh(0, 0.6f));
            IconRenderer.draw(class_3322, Icon.PLAY, f + 7.3f, f2 + f4 - 7.0f, 5.2f, MenuScreen.jyh(0xFFFFFF, 0.95f));
        }
        int n = MenuScreen.jya(kbs2);
        int n2 = bl ? n : 0xFFFFFF;
        DrawUtil.outline(class_3322, f, f2, f3, f4, f5, bl ? 1.2f : 0.7f, MenuScreen.jyh(n2, bl ? 0.95f : 0.18f + 0.4f * f6));
        FontFace vdn2 = Fonts.medium(6.3f);
        String string = kbs2.title();
        if (vdn2.width(string) > f3 - 10.0f) {
            while (string.length() > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!(vdn2.width(stringBuilder.append(string).append("…").toString()) > f3 - 10.0f)) break;
                string = string.substring(0, string.length() - 1);
            }
            string = string.trim() + "…";
        }
        vdn2.draw(class_3322, string, f + 2.0f, vdn2.centerTop(f2 + f4 + 7.0f), MenuScreen.jyh(bl ? MenuScreen.jyg(0xFFFFFF, n, 0.5f) : 0xFFFFFF, bl ? 1.0f : 0.7f + 0.3f * f6));
        DrawUtil.circle(class_3322, f + f3 - 4.0f, f2 + f4 + 7.0f, 2.2f, MenuScreen.jyh(n, bl ? 1.0f : 0.45f));
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
    private void jxk(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3) {
        float f4 = this.juc.step(this.jur, this.jvc);
        if (f4 <= 0.003f) {
            return;
        }
        float f5 = Easing.outBack(f4);
        int n = this.jug.accent;
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.jve, this.jvf, MenuScreen.jyh(197898, 0.42f * Easing.clamp01(f4)));
        float f6 = this.jxg();
        float f7 = this.jxh();
        float f8 = 14.0f;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f6 + 114.0f, f7 + 59.0f);
        float f9 = 0.9f + 0.1f * Math.min(1.05f, f5);
        matrix3x2fStack.scale(f9, f9);
        matrix3x2fStack.translate(-114.0f - f6, -59.0f - f7 + (1.0f - Math.min(1.0f, f5)) * 8.0f);
        DrawUtil.pushAlpha(Easing.clamp01(f4 * 1.4f));
        try {
            DrawUtil.shadow(class_3322, f6, f7 + 6.0f, 228.0f, 118.0f, f8, 26.0f, MenuScreen.jyh(0, 0.5f));
            this.jtt.frosted(class_3322, f6, f7, 228.0f, 118.0f, f8, this.jve, this.jvf, MenuScreen.jyh(0xFFFFFF, 1.0f));
            DrawUtil.round(class_3322, f6, f7, 228.0f, 118.0f, f8, MenuScreen.jyh(658966, 0.6f));
            DrawUtil.outlineGradientV(class_3322, f6, f7, 228.0f, 118.0f, f8, 0.7f, MenuScreen.jyh(0xFFFFFF, 0.3f), MenuScreen.jyh(0xFFFFFF, 0.07f));
            if (gpuTextureView != null) {
                DrawUtil.additive(true);
                DrawUtil.sprite(class_3322, gpuTextureView, f6 + 30.0f, f7 + 30.0f, 60.0f, MenuScreen.jyh(n, 0.25f));
                DrawUtil.additive(false);
            }
            float f10 = (float)Math.sin(f3 * 3.2f) * 1.2f;
            DrawUtil.round(class_3322, f6 + 16.0f, f7 + 16.0f, 28.0f, 28.0f, 9.0f, MenuScreen.jyh(n, 0.18f));
            DrawUtil.outline(class_3322, f6 + 16.0f, f7 + 16.0f, 28.0f, 28.0f, 9.0f, 0.7f, MenuScreen.jyh(n, 0.5f));
            IconRenderer.draw(class_3322, Icon.DOWNLOAD, f6 + 30.0f, f7 + 30.0f + f10, 14.0f, MenuScreen.jyh(MenuScreen.jyg(n, 0xFFFFFF, 0.35f), 1.0f));
            FontFace vdn2 = Fonts.semibold(9.6f);
            vdn2.draw(class_3322, Lang.s("Download the IAS mod", "Скачайте мод IAS"), f6 + 54.0f, vdn2.centerTop(f7 + 24.0f), MenuScreen.jyh(0xFFFFFF, 0.97f));
            FontFace vdn3 = Fonts.medium(6.6f);
            vdn3.draw(class_3322, "In-Game Account Switcher · Fabric 1.21.11", f6 + 54.0f, vdn3.centerTop(f7 + 36.0f), MenuScreen.jyh(MenuScreen.jyg(0xFFFFFF, n, 0.5f), 0.85f));
            FontFace vdn4 = Fonts.medium(6.4f);
            vdn4.draw(class_3322, Lang.s("The alt manager works through it. Put the jar", "Альт менеджер работает через него. Положите"), f6 + 16.0f, vdn4.centerTop(f7 + 56.0f), MenuScreen.jyh(0xFFFFFF, 0.62f));
            vdn4.draw(class_3322, Lang.s("into the mods folder and restart the game.", "файл в папку mods и перезапустите игру."), f6 + 16.0f, vdn4.centerTop(f7 + 66.0f), MenuScreen.jyh(0xFFFFFF, 0.62f));
            for (int i = 0; i < 2; ++i) {
                this.jxl(class_3322, i, f, f2, n, f4 >= 0.99f);
            }
        }
        finally {
            DrawUtil.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private void jxl(class_332 class_3322, int n, float f, float f2, int n2, boolean bl) {
        float f3 = 96.0f;
        float f4 = 20.0f;
        float f5 = this.jxi(n);
        float f6 = this.jxj();
        float f7 = this.jud[n].step(bl && MenuScreen.jyf(f, f2, f5, f6, f3, f4), this.jvc);
        boolean bl2 = n == 0;
        DrawUtil.round(class_3322, f5, f6, f3, f4, f4 * 0.5f, bl2 ? MenuScreen.jyh(n2, 0.3f + 0.25f * f7) : MenuScreen.jyh(0xFFFFFF, 0.05f + 0.08f * f7));
        DrawUtil.outline(class_3322, f5, f6, f3, f4, f4 * 0.5f, 0.7f, MenuScreen.jyh(bl2 ? n2 : MenuScreen.jyg(0xFFFFFF, n2, f7), bl2 ? 0.6f + 0.35f * f7 : 0.15f + 0.35f * f7));
        FontFace vdn2 = Fonts.semibold(7.0f);
        String string = bl2 ? Lang.s("Download", "Скачать") : Lang.s("Close", "Закрыть");
        float f8 = vdn2.width(string);
        if (bl2) {
            IconRenderer.draw(class_3322, Icon.DOWNLOAD, f5 + (f3 - f8) * 0.5f - 5.0f, f6 + f4 * 0.5f, 8.0f, MenuScreen.jyh(0xFFFFFF, 0.95f));
        }
        vdn2.draw(class_3322, string, f5 + (f3 - f8) * 0.5f + (bl2 ? 3.0f : 0.0f), vdn2.centerTop(f6 + f4 * 0.5f), MenuScreen.jyh(0xFFFFFF, 0.95f));
    }

    private void jxm(WallpaperEntry kbs2) {
        if (kbs2 == this.jug) {
            return;
        }
        this.jtu.close();
        this.jui = this.jug.key;
        this.juj = this.juh;
        this.jum = false;
        this.juk = MenuSceneRenderer.clock();
        this.jul = 0.9f;
        this.jug = kbs2;
        this.juh = new MenuSnowRenderer(kbs2.particles, 7L + (long)kbs2.ordinal());
        WallpaperEntry.select(kbs2);
        GuiConfig.saveLater();
    }

    private static WallpaperEntry jxn(String string) {
        WallpaperEntry kbs2 = WallpaperEntry.byKey(string);
        return kbs2 != null ? kbs2 : WallpaperEntry.DEFAULT;
    }

    private static String jxo(int n) {
        return switch (n) {
            case 0 -> Lang.s(EncodedString.get() + " title", "Надпись " + EncodedString.get());
            case 1 -> Lang.s("Buttons", "Кнопки");
            case 2 -> Lang.s("Style", "Стиль кнопок");
            case 3 -> Lang.s("Button blur", "Размытие кнопок");
            case 4 -> Lang.s("Rounding", "Скругление");
            case 5 -> Lang.s("Darken", "Затемнение фона");
            case 6 -> Lang.s("Particles", "Частицы");
            case 7 -> Lang.s("Parallax", "Параллакс");
            default -> "";
        };
    }

    private static String[] jxp(int n) {
        String[] stringArray;
        if (n == 1) {
            String[] stringArray2 = new String[3];
            stringArray2[0] = Lang.s("Left", "Слева");
            stringArray2[1] = Lang.s("Center", "Центр");
            stringArray = stringArray2;
            stringArray2[2] = Lang.s("Right", "Справа");
        } else {
            String[] stringArray3 = new String[4];
            stringArray3[0] = Lang.s("Glass", "Стекло");
            stringArray3[1] = Lang.s("Dark", "Тёмные");
            stringArray3[2] = Lang.s("Light", "Светлые");
            stringArray = stringArray3;
            stringArray3[3] = Lang.s("Outline", "Контур");
        }
        return stringArray;
    }

    private static NumberSetting jxq(int n) {
        return n == 3 ? TitleLayoutSetting.BLUR : (n == 4 ? TitleLayoutSetting.ROUND : TitleLayoutSetting.DIM);
    }

    private static boolean jxr(int n) {
        return switch (n) {
            case 0 -> TitleLayoutSetting.TITLE.get();
            case 6 -> TitleLayoutSetting.PARTICLES.get();
            default -> TitleLayoutSetting.PARALLAX.get();
        };
    }

    private static float jxs(int n) {
        return switch (n) {
            case 1 -> TitleLayoutSetting.POSITION.index();
            case 2 -> TitleLayoutSetting.BUTTONS.index();
            case 3, 4, 5 -> (float)MenuScreen.jxq(n).getFraction();
            case 8 -> 0.0f;
            default -> MenuScreen.jxr(n) ? 1.0f : 0.0f;
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
        if (!MenuScreen.jyf(f, f2, this.jwq(), this.jwt(), 254.0f, this.jwu())) {
            return -1;
        }
        for (int i = 0; i < 9; ++i) {
            if (!MenuScreen.jyf(f, f2, this.jwq() + 6.0f, this.jxt(i), 242.0f, 19.0f)) continue;
            return i;
        }
        return -1;
    }

    private void jxy(int n, float f) {
        switch (n) {
            case 0: {
                TitleLayoutSetting.TITLE.toggle();
                break;
            }
            case 1: 
            case 2: {
                if (f < this.jxu()) {
                    return;
                }
                ModeSetting vlv2 = n == 1 ? TitleLayoutSetting.POSITION : TitleLayoutSetting.BUTTONS;
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
                TitleLayoutSetting.PARTICLES.toggle();
                break;
            }
            case 7: {
                TitleLayoutSetting.PARALLAX.toggle();
                break;
            }
            default: {
                this.jvo[8].set(1.0f);
                TitleLayoutSetting.reset();
            }
        }
        GuiConfig.saveLater();
    }

    private void jxz(int n, float f) {
        MenuScreen.jxq(n).setFromFraction(Easing.clamp01((f - this.jxv()) / this.jxw()));
    }

    private static int jya(WallpaperEntry kbs2) {
        return kbs2.light ? 13225945 : kbs2.accent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jyb(class_332 class_3322, float f, float f2, boolean bl) {
        int n = MenuScreen.jya(this.jug);
        FontFace vdn2 = Fonts.medium(6.3f);
        FontFace vdn3 = Fonts.medium(5.7f);
        float f3 = this.jwt();
        float f4 = f3 + this.jwu();
        for (int i = 0; i < 9; ++i) {
            float f5 = this.jxt(i);
            float f6 = this.jvo[i].step(MenuScreen.jxs(i), this.jvc);
            if (f5 + 19.0f < f3 || f5 > f4) {
                this.jvn[i].set(0.0f);
                continue;
            }
            boolean bl2 = bl && this.jvp < 0 && MenuScreen.jyf(f, f2, this.jwq() + 6.0f, f5, 242.0f, 19.0f);
            float f7 = this.jvn[i].step(bl2 || this.jvp == i, this.jvc);
            float f8 = f5 + 9.5f;
            boolean bl3 = i == 0 && this.jug.logo();
            DrawUtil.pushAlpha(bl3 ? 0.4f : 1.0f);
            try {
                this.jyc(class_3322, i, f5, f8, f6, f7, bl2, f, f2, n, vdn2, vdn3);
                continue;
            }
            finally {
                DrawUtil.popAlpha();
            }
        }
    }

    private void jyc(class_332 class_3322, int n, float f, float f2, float f3, float f4, boolean bl, float f5, float f6, int n2, FontFace vdn2, FontFace vdn3) {
        if (n < 8) {
            DrawUtil.round(class_3322, this.jwq() + 6.0f, f + 1.0f, 242.0f, 17.0f, 5.0f, MenuScreen.jyh(0xFFFFFF, 0.05f * f4));
        }
        if (n < 8) {
            vdn2.draw(class_3322, MenuScreen.jxo(n), this.jwq() + 12.0f, vdn2.centerTop(f2), MenuScreen.jyh(0xFFFFFF, 0.78f + 0.2f * f4));
        }
        switch (n) {
            case 1: 
            case 2: {
                String[] stringArray = MenuScreen.jxp(n);
                int n3 = stringArray.length;
                float f7 = 132.0f / (float)n3;
                float f8 = this.jxu();
                DrawUtil.round(class_3322, f8, f2 - 6.5f, 132.0f, 13.0f, 6.5f, MenuScreen.jyh(0xFFFFFF, 0.07f));
                DrawUtil.round(class_3322, f8 + f3 * f7 + 1.0f, f2 - 5.5f, f7 - 2.0f, 11.0f, 5.5f, MenuScreen.jyh(n2, 0.38f));
                DrawUtil.outline(class_3322, f8 + f3 * f7 + 1.0f, f2 - 5.5f, f7 - 2.0f, 11.0f, 5.5f, 0.6f, MenuScreen.jyh(n2, 0.7f));
                int n4 = Math.round(f3);
                for (int i = 0; i < n3; ++i) {
                    vdn3.drawCentered(class_3322, stringArray[i], f8 + f7 * ((float)i + 0.5f), vdn3.centerTop(f2), MenuScreen.jyh(0xFFFFFF, i == n4 ? 1.0f : 0.62f));
                }
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                NumberSetting vmc2 = MenuScreen.jxq(n);
                float f9 = this.jxv();
                float f10 = this.jxw();
                vdn3.drawRight(class_3322, vmc2.display(), f9 - 6.0f, vdn3.centerTop(f2), MenuScreen.jyh(0xFFFFFF, 0.7f));
                DrawUtil.round(class_3322, f9, f2 - 1.5f, f10, 3.0f, 1.5f, MenuScreen.jyh(0xFFFFFF, 0.14f));
                DrawUtil.round(class_3322, f9, f2 - 1.5f, Math.max(3.0f, f10 * f3), 3.0f, 1.5f, MenuScreen.jyh(n2, 0.9f));
                DrawUtil.circle(class_3322, f9 + f10 * f3, f2, 4.0f + 0.8f * f4, MenuScreen.jyh(0xFFFFFF, 1.0f));
                DrawUtil.circle(class_3322, f9 + f10 * f3, f2, 1.8f, MenuScreen.jyh(n2, 1.0f));
                break;
            }
            case 8: {
                float f11 = 234.0f;
                float f12 = this.jwq() + 10.0f;
                boolean bl2 = bl && MenuScreen.jyf(f5, f6, f12, f2 - 7.0f, f11, 14.0f);
                DrawUtil.round(class_3322, f12, f2 - 6.5f, f11, 13.0f, 6.5f, MenuScreen.jyh(MenuScreen.jyg(0xFFFFFF, n2, f3), 0.08f + (bl2 ? 0.1f : 0.0f) + 0.3f * f3));
                DrawUtil.outline(class_3322, f12, f2 - 6.5f, f11, 13.0f, 6.5f, 0.6f, MenuScreen.jyh(0xFFFFFF, bl2 ? 0.38f : 0.18f));
                String string = Lang.s("Reset", "Сбросить");
                float f13 = vdn3.width(string) + 11.0f;
                IconRenderer.draw(class_3322, Icon.REFRESH, f12 + (f11 - f13) * 0.5f + 3.5f, f2, 7.0f, MenuScreen.jyh(0xFFFFFF, 0.85f));
                vdn3.draw(class_3322, string, f12 + (f11 - f13) * 0.5f + 11.0f, vdn3.centerTop(f2), MenuScreen.jyh(0xFFFFFF, 0.9f));
                break;
            }
            default: {
                float f14 = 20.0f;
                float f15 = this.jwq() + 254.0f - 10.0f - f14;
                DrawUtil.round(class_3322, f15, f2 - 5.5f, f14, 11.0f, 5.5f, MenuScreen.jyh(MenuScreen.jyg(3817552, n2, f3), 0.55f + 0.4f * f3));
                DrawUtil.circle(class_3322, f15 + 5.5f + 9.0f * f3, f2, 4.0f, MenuScreen.jyh(0xFFFFFF, 1.0f));
            }
        }
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        int n;
        if (class_119092.method_74245() != 0) {
            return true;
        }
        float f = (float)class_119092.comp_4798() / this.jvd;
        float f2 = (float)class_119092.comp_4799() / this.jvd;
        if (this.jux >= 0 || this.juy >= 0.0f) {
            return true;
        }
        if (this.jur) {
            float f3 = 96.0f;
            if (MenuScreen.jyf(f, f2, this.jxi(0), this.jxj(), f3, 20.0f)) {
                MenuScreen.jye("https://modrinth.com/mod/in-game-account-switcher/versions?g=1.21.11&l=fabric");
                this.jur = false;
            } else if (MenuScreen.jyf(f, f2, this.jxi(1), this.jxj(), f3, 20.0f) || !MenuScreen.jyf(f, f2, this.jxg(), this.jxh(), 228.0f, 118.0f)) {
                this.jur = false;
            }
            return true;
        }
        if (this.juq) {
            if (this.jxb(f, f2)) {
                int n2 = this.jxc(f, f2);
                if (n2 >= 0) {
                    this.juf[n2] = MenuSceneRenderer.clock();
                    this.jxm(WallpaperEntry.values()[n2]);
                } else {
                    int n3 = this.jxx(f, f2);
                    if (n3 >= 0) {
                        this.jxy(n3, f);
                    }
                }
                return true;
            }
            if (!MenuScreen.jyf(f, f2, this.jwn(2), 12.0f, 21.0f, 21.0f)) {
                this.juq = false;
            }
        }
        for (n = 0; n < 4; ++n) {
            if (!MenuScreen.jyf(f, f2, this.jwn(n), 12.0f, 21.0f, 21.0f)) continue;
            this.jue[n] = MenuSceneRenderer.clock();
            switch (n) {
                case 0: {
                    MenuScreen.jye(TELEGRAM);
                    break;
                }
                case 1: {
                    MenuScreen.jye("https://discord.gg/g4fmYmGeR");
                    break;
                }
                case 2: {
                    boolean bl2 = this.juq = !this.juq;
                    if (!this.juq) break;
                    float f4 = this.jxa(this.jug.ordinal()) + this.jut - this.jwt();
                    this.juu = this.jut = Math.max(0.0f, Math.min(this.jwy(), f4 - this.jwu() * 0.35f));
                    break;
                }
                default: {
                    this.juy = MenuSceneRenderer.clock() + 0.28f;
                }
            }
            return true;
        }
        for (n = 0; n < 4; ++n) {
            if (!MenuScreen.jyf(f, f2, this.jwk(), this.jwj(n), 138.0f, 25.0f)) continue;
            this.jus = n;
            this.juv = MenuSceneRenderer.clock();
            this.juw = f - this.jwk();
            if (n == 2 && !IasCompat.available()) {
                this.jur = true;
            } else {
                this.jux = n;
            }
            return true;
        }
        return true;
    }

    public boolean method_25403(class_11909 class_119092, double d, double d2) {
        if (this.jvp >= 0) {
            this.jxz(this.jvp, (float)class_119092.comp_4798() / this.jvd);
            return true;
        }
        return super.method_25403(class_119092, d, d2);
    }

    public boolean method_25406(class_11909 class_119092) {
        if (this.jvp >= 0) {
            this.jvp = -1;
            GuiConfig.saveLater();
            return true;
        }
        return super.method_25406(class_119092);
    }

    public boolean method_25401(double d, double d2, double d3, double d4) {
        if (this.juq && this.jxb((float)d / this.jvd, (float)d2 / this.jvd)) {
            this.juu = Math.max(0.0f, Math.min(this.jwy(), this.juu - (float)d4 * 28.0f));
        }
        return true;
    }

    private void jyd(int n) {
        class_310 class_3102 = this.field_22787;
        switch (n) {
            case 0: {
                class_3102.method_1507((class_437)new class_526((class_437)this));
                break;
            }
            case 1: {
                class_3102.method_1507((class_437)(class_3102.field_1690.field_21840 ? new class_500((class_437)this) : new class_4749((class_437)this)));
                break;
            }
            case 2: {
                if (IasCompat.available()) {
                    class_3102.method_1507((class_437)new AccountsScreen(this));
                    break;
                }
                this.jur = true;
                break;
            }
            default: {
                class_3102.method_1507((class_437)new class_429((class_437)this, class_3102.field_1690));
            }
        }
    }

    private static void jye(String string) {
        try {
            class_156.method_668().method_673(URI.create(string));
        }
        catch (Exception exception) {
            System.out.println("can't open " + string + ": " + exception);
        }
    }

    public boolean method_25404(class_11908 class_119082) {
        if (class_119082.comp_4795() == 256) {
            if (this.jur) {
                this.jur = false;
            } else if (this.juq) {
                this.juq = false;
            }
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
        FontFace.setRenderScale(1.0f);
    }

    private static boolean jyf(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f2 >= f4 && f < f3 + f5 && f2 < f4 + f6;
    }

    private static int jyg(int n, int n2, float f) {
        return WordmarkAnimator.AutoTpAccept(n, n2, f);
    }

    private static int jyh(int n, float f) {
        return WordmarkAnimator.rgba(n, f);
    }

    static {
        DISCORD = "https://discord.gg/g4fmYmGeR";
        TELEGRAM = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 't', '.', 'm', 'e', '/', 'F', 'l', 'o', 'w', 'w', 'C', 'l', 'i', 'e', 'n', 't'});
    }

    private static /* synthetic */ int aqe(int n, int n2) {
        return n - n2 ^ 0x2098534E;
    }
}

