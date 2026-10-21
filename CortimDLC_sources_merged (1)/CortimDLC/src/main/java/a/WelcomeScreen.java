/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.GuiConfig;
import a.LanguageScreen;
import a.MenuScreen;
import a.jza;
import a.MenuArtCache;
import a.kam;
import a.MenuSceneRenderer;
import a.MenuScale;
import a.WallpaperEntry;
import a.WordmarkAnimator;
import a.FrameDelta;
import a.GlowSprite;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.wam;
import a.Lang;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.joml.Matrix3x2fStack;

public final class WelcomeScreen
extends class_437 {
    private static final float kcu = 116.0f;
    private static final float kcv = 92.0f;
    private static final float kcw = 14.0f;
    private static final wam[] kcx = new wam[]{wam.RU, wam.EN};
    private final class_437 kcy;
    private final MenuSceneRenderer kcz = new MenuSceneRenderer();
    private final kam kda = new kam();
    private final WallpaperEntry kdb = WallpaperEntry.selected();
    private final Spring[] kdc = new Spring[]{new Spring(13.0f), new Spring(13.0f)};
    private int kdd;
    private float kde = -1.0f;
    private float kdf = -1.0f;
    private int kdg = -1;
    private boolean kdh;
    private long kdi;
    private float kdj;
    private float kdk = 1.0f;
    private float kdl = 480.0f;
    private float kdm = 270.0f;
    private static /* synthetic */ boolean kdn;
    private static /* synthetic */ long kdo;

    public WelcomeScreen(class_437 class_4372) {
        super((class_2561)class_2561.method_43470((String)"Welcome"));
        this.kcy = class_4372;
        this.kdd = Lang.chosen() && !Lang.ru() ? 1 : 0;
        MenuArtCache.preload(this.kdb.key);
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
        this.kdj = this.kdi == 0L ? 0.016666668f : Math.min(0.1f, (float)(l - this.kdi) / 1.0E9f);
        this.kdi = l;
        float f2 = MenuSceneRenderer.clock();
        if (this.kde < 0.0f) {
            this.kde = f2;
        }
        float f3 = f2 - this.kde;
        float f4 = this.kdf >= 0.0f ? Easing.clamp01((f2 - this.kdf) / 0.42f) : 0.0f;
        this.kdk = MenuScale.scale(this.field_22789, this.field_22790);
        this.kdl = (float)this.field_22789 / this.kdk;
        this.kdm = (float)this.field_22790 / this.kdk;
        float f5 = (float)n / this.kdk;
        float f6 = (float)n2 / this.kdk;
        GpuTextureView gpuTextureView = GlowSprite.view();
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, -16315888);
        jza jza2 = MenuArtCache.get(this.kdb.key);
        if (jza2 != null) {
            this.kda.time = f2;
            this.kda.blur = 1.0f;
            this.kda.dim = 0.22f;
            this.kda.zoom = 1.06f;
            this.kda.tint = this.kdb.tint;
            this.kda.tintAmount = 0.3f;
            this.kcz.draw(class_3322, jza2, this.kda, this.field_22789, this.field_22790, 1.0f, true);
        }
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.scale(this.kdk, this.kdk);
        FontFace.setRenderScaleStepped(this.kdk);
        DrawUtil.pushAlpha(1.0f - Easing.inCubic(f4));
        try {
            float f7 = Easing.outCubic(Easing.clamp01((f3 - 0.05f) / 0.6f));
            DrawUtil.pushAlpha(f7);
            float f8 = this.kdm * 0.5f - 46.0f - 38.0f + (1.0f - f7) * 6.0f;
            FontFace vdn2 = Fonts.semibold(12.0f);
            vdn2.drawCentered(class_3322, "Choose your language", this.kdl * 0.5f, vdn2.centerTop(f8), WelcomeScreen.kdu(0xFFFFFF, 0.97f));
            FontFace vdn3 = Fonts.medium(7.6f);
            vdn3.drawCentered(class_3322, "Выберите язык", this.kdl * 0.5f, vdn3.centerTop(f8 + 15.0f), WelcomeScreen.kdu(14149365, 0.72f));
            DrawUtil.popAlpha();
            for (int i = 0; i < kcx.length; ++i) {
                this.kdr(class_3322, gpuTextureView, i, f5, f6, f3, f4);
            }
            FontFace vdn4 = Fonts.medium(6.2f);
            DrawUtil.pushAlpha(Easing.clamp01((f3 - 0.7f) / 0.6f));
            vdn4.drawCentered(class_3322, "Сменить потом: кнопка с глобусом в чит-меню  ·  Change it later: the globe button in the cheat menu", this.kdl * 0.5f, vdn4.centerTop(this.kdm * 0.5f + 46.0f + 24.0f), WelcomeScreen.kdu(0xFFFFFF, 0.45f));
            DrawUtil.popAlpha();
        }
        finally {
            DrawUtil.popAlpha();
            DrawUtil.additive(false);
            matrix3x2fStack.popMatrix();
            FontFace.setRenderScale(1.0f);
        }
        if (f4 >= 1.0f && !this.kdh) {
            this.kdh = true;
            class_310 class_3102 = this.field_22787;
            MenuScreen jte2 = class_3102.field_1687 == null ? MenuScreen.afterWelcome() : this.kcy;
            class_3102.method_63588(() -> class_3102.method_1507(jte2));
        }
    }

    private float kdp(int n) {
        return this.kdl * 0.5f - 116.0f - 7.0f + (float)n * 130.0f;
    }

    private float kdq() {
        return this.kdm * 0.5f - 46.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void kdr(class_332 class_3322, GpuTextureView gpuTextureView, int n, float f, float f2, float f3, float f4) {
        boolean bl;
        float f5 = Easing.clamp01((f3 - 0.2f - (float)n * 0.1f) / 0.6f);
        if (f5 <= 0.0f) {
            return;
        }
        float f6 = Easing.outBack(f5);
        float f7 = this.kdp(n);
        float f8 = this.kdq();
        boolean bl2 = bl = this.kdf < 0.0f && f5 >= 1.0f && WelcomeScreen.kdt(f, f2, f7, f8, 116.0f, 92.0f);
        if (bl) {
            this.kdd = n;
        }
        boolean bl3 = bl || this.kdd == n && !WelcomeScreen.kdt(f, f2, this.kdp(1 - n), f8, 116.0f, 92.0f) || this.kdg == n;
        float f9 = this.kdc[n].step(bl3, this.kdj);
        float f10 = this.kdg == n ? Easing.clamp01(f4 * 2.0f) : 0.0f;
        float f11 = f8 + (1.0f - f6) * 18.0f - 3.0f * f9;
        float f12 = (0.92f + 0.08f * f6) * (1.0f + 0.03f * f10) * (this.kdg >= 0 && this.kdg != n ? 1.0f - 0.05f * f4 : 1.0f);
        float f13 = 13.0f;
        int n2 = this.kdb.accent;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f7 + 58.0f, f11 + 46.0f);
        matrix3x2fStack.scale(f12, f12);
        matrix3x2fStack.translate(-58.0f, -46.0f);
        DrawUtil.pushAlpha(Easing.clamp01(f5 * 1.5f));
        try {
            DrawUtil.shadow(class_3322, 0.0f, 5.0f, 116.0f, 92.0f, f13, 22.0f, WelcomeScreen.kdu(0, 0.35f + 0.1f * f9));
            if (gpuTextureView != null && f9 > 0.01f) {
                DrawUtil.additive(true);
                DrawUtil.image(class_3322, gpuTextureView, -34.800003f, -27.6f, 185.6f, 147.2f, 0.0f, WelcomeScreen.kdu(n2, 0.16f * f9));
                DrawUtil.additive(false);
            }
            this.kcz.frosted(class_3322, 0.0f, 0.0f, 116.0f, 92.0f, f13, f7, f11, this.kdl, this.kdm, WelcomeScreen.kdu(0xFFFFFF, 1.0f));
            DrawUtil.round(class_3322, 0.0f, 0.0f, 116.0f, 92.0f, f13, WelcomeScreen.kdu(658966, 0.3f - 0.08f * f9));
            DrawUtil.round(class_3322, 0.0f, 0.0f, 116.0f, 92.0f, f13, WelcomeScreen.kdu(0xFFFFFF, 0.04f + 0.07f * f9));
            DrawUtil.gradient(class_3322, 0.0f, 0.0f, 116.0f, 41.399998f, f13, f13, 0.0f, 0.0f, WelcomeScreen.kdu(0xFFFFFF, 0.09f), WelcomeScreen.kdu(0xFFFFFF, 0.09f), WelcomeScreen.kdu(0xFFFFFF, 0.0f), WelcomeScreen.kdu(0xFFFFFF, 0.0f));
            DrawUtil.outlineGradientV(class_3322, 0.0f, 0.0f, 116.0f, 92.0f, f13, 0.8f, WelcomeScreen.kdu(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n2, f9), 0.34f + 0.45f * f9), WelcomeScreen.kdu(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n2, f9), 0.08f + 0.3f * f9));
            wam wam2 = kcx[n];
            boolean bl4 = wam2 == wam.RU;
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(43.0f, 16.0f);
            matrix3x2fStack.scale(1.5f, 1.5f);
            LanguageScreen.flag(class_3322, wam2, 0.0f, 0.0f);
            matrix3x2fStack.popMatrix();
            FontFace vdn2 = Fonts.semibold(10.5f);
            vdn2.drawCentered(class_3322, bl4 ? "Русский" : "English", 58.0f, vdn2.centerTop(62.0f), WelcomeScreen.kdu(0xFFFFFF, 0.97f));
            FontFace vdn3 = Fonts.medium(6.6f);
            vdn3.drawCentered(class_3322, bl4 ? "RU" : "EN", 58.0f, vdn3.centerTop(75.0f), WelcomeScreen.kdu(WordmarkAnimator.AutoTpAccept(13161698, n2, f9), 0.7f + 0.3f * f9));
        }
        finally {
            DrawUtil.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private void kds(int n) {
        if (this.kdf >= 0.0f) {
            return;
        }
        this.kdg = n;
        Lang.set(kcx[n]);
        GuiConfig.saveLater();
        this.kdf = MenuSceneRenderer.clock();
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        if (class_119092.method_74245() != 0) {
            return true;
        }
        float f = (float)class_119092.comp_4798() / this.kdk;
        float f2 = (float)class_119092.comp_4799() / this.kdk;
        for (int i = 0; i < kcx.length; ++i) {
            if (!WelcomeScreen.kdt(f, f2, this.kdp(i), this.kdq(), 116.0f, 92.0f)) continue;
            this.kds(i);
        }
        return true;
    }

    public boolean method_25404(class_11908 class_119082) {
        switch (class_119082.comp_4795()) {
            case 263: {
                this.kdd = 0;
                break;
            }
            case 258: 
            case 262: {
                this.kdd = this.kdd == 0 ? 1 : 0;
                break;
            }
            case 32: 
            case 257: 
            case 335: {
                this.kds(this.kdd);
                break;
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
        this.kcz.close();
        FontFace.setRenderScale(1.0f);
    }

    private static boolean kdt(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f2 >= f4 && f < f3 + f5 && f2 < f4 + f6;
    }

    private static int kdu(int n, float f) {
        return WordmarkAnimator.rgba(n, f);
    }

    private static /* synthetic */ int asb(int n, int n2) {
        return (n ^ n2) + 1883086885;
    }
}

