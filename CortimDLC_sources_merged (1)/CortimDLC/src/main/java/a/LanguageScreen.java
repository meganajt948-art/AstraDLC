/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package a;

import a.LiquidGlass;
import a.GuiConfig;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.GlassDraw;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Tween;
import a.FontFace;
import a.Icon;
import a.IconRenderer;
import a.wam;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class LanguageScreen
extends class_437 {
    private static final float idb = 240.0f;
    private static final float idc = 150.0f;
    private static final float idd = 16.0f;
    private static final float ide = 52.0f;
    private static final float idf = 64.0f;
    private static final float idg = 10.0f;
    private static final wam[] idh = new wam[]{wam.RU, wam.EN};
    private final class_437 idi;
    private final Tween idj = new Tween(0.32f, 0.0f);
    private final Spring[] idk = new Spring[]{new Spring(16.0f), new Spring(16.0f)};
    private final Spring[] idl = new Spring[]{new Spring(12.0f), new Spring(12.0f)};
    private int idm;
    private boolean idn;
    private boolean ido;
    private long idp = -1L;
    private float idq = 0.016666668f;
    private float idr = 1.0f;
    private float ids;
    private float idt;
    private static /* synthetic */ boolean idu;
    private static /* synthetic */ long idv;

    public LanguageScreen(class_437 class_4372) {
        super((class_2561)class_2561.method_43470((String)"Language"));
        this.idi = class_4372;
        this.idm = Lang.ru() || !Lang.chosen() ? 0 : 1;
        for (int i = 0; i < idh.length; ++i) {
            this.idl[i].set(Lang.chosen() && Lang.get() == idh[i] ? 1.0f : 0.0f);
        }
    }

    private void idw(class_332 class_3322) {
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == this.idp) {
            return;
        }
        this.idp = FrameDelta.frame();
        this.idq = FrameDelta.delta() * (float)Theme.ANIMATION.get();
        Theme.update(this.idq);
        this.idj.update(this.idq);
        if (this.idn && this.idj.finished() && !this.ido && this.field_22787 != null) {
            this.ido = true;
            this.field_22787.method_63588(() -> this.field_22787.method_1507(this.idi));
        }
    }

    private float idx() {
        float f = this.idj.linear();
        return this.idn ? Easing.outCubic(f) : Easing.outQuint(f);
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
        DrawUtil.beginFrame();
        this.idw(class_3322);
        float f2 = this.idx();
        if (this.field_22787 != null && this.field_22787.field_1687 != null) {
            LiquidGlass.capture(class_3322, Math.max(1, Theme.BG_BLUR.getInt()), f2, null);
            DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, ColorUtil.withAlpha(0, Math.round(140.0f * f2)));
        } else {
            LiquidGlass.skip();
            this.method_57728(class_3322, f);
            class_3322.method_71278();
            DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, ColorUtil.withAlpha(0, Math.round(120.0f * f2)));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        this.idw(class_3322);
        float f2 = this.idx();
        float f3 = Math.min(((float)this.field_22789 - 16.0f) / 240.0f, ((float)this.field_22790 - 16.0f) / 150.0f);
        float f4 = Math.max(0.4f, Math.min((float)Theme.SCALE.get() * 1.1f, f3));
        this.idr = f4 * (0.96f + 0.04f * f2);
        this.ids = (float)this.field_22789 * 0.5f - 120.0f * this.idr;
        this.idt = (float)this.field_22790 * 0.5f - 75.0f * this.idr + (1.0f - f2) * 8.0f;
        float f5 = ((float)n - this.ids) / this.idr;
        float f6 = ((float)n2 - this.idt) / this.idr;
        FontFace.setRenderScale(f4);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(this.ids, this.idt);
        class_3322.method_51448().scale(this.idr, this.idr);
        DrawUtil.pushAlpha(f2);
        try {
            this.iea(class_3322, f5, f6);
        }
        finally {
            DrawUtil.popAlpha();
            class_3322.method_51448().popMatrix();
            FontFace.setRenderScale(1.0f);
        }
    }

    private float idy() {
        return 99.0f;
    }

    private float idz(int n) {
        return 16.0f + (float)n * (this.idy() + 10.0f);
    }

    private void iea(class_332 class_3322, float f, float f2) {
        float f3 = Theme.r(12.0f);
        float f4 = Theme.lightness();
        DrawUtil.shadow(class_3322, 0.0f, 4.0f, 240.0f, 150.0f, f3, 18.0f, Theme.shadow);
        DrawUtil.round(class_3322, 0.0f, 0.0f, 240.0f, 150.0f, f3, ColorUtil.withAlpha(Theme.window, 255));
        GlassDraw.sheen(class_3322, 0.0f, 0.0f, 240.0f, 60.0f, f3, 0.8f * (1.0f - 0.7f * f4));
        DrawUtil.outline(class_3322, 0.0f, 0.0f, 240.0f, 150.0f, f3, 1.0f, Theme.stroke);
        GlassDraw.rim(class_3322, 0.0f, 0.0f, 240.0f, 150.0f, f3, f4, 1.1f);
        DrawUtil.circle(class_3322, 25.0f, 24.0f, 10.0f, Theme.accent(40));
        IconRenderer.draw(class_3322, Icon.GLOBE, 25.0f, 24.0f, 11.0f, Theme.accent());
        String string = Lang.chosen() ? Lang.s("Language", "Язык") : "Язык  ·  Language";
        UiKit.TITLE.draw(class_3322, string, 41.0f, UiKit.TITLE.centerTop(20.0f), Theme.text);
        String string2 = Lang.chosen() ? Lang.s("Choose the client language", "Выберите язык клиента") : "Выберите язык  ·  Choose your language";
        UiKit.SUBTITLE.draw(class_3322, UiKit.SUBTITLE.ellipsize(string2, 183.0f), 41.0f, UiKit.SUBTITLE.centerTop(32.0f), Theme.textMuted);
        for (int i = 0; i < idh.length; ++i) {
            this.ieb(class_3322, i, f, f2);
        }
        String string3 = Lang.chosen() || Lang.ru() ? Lang.s("You can change it any time: the globe button in the menu", "Сменить можно в любой момент: кнопка с глобусом в меню") : "Сменить можно кнопкой с глобусом в меню";
        UiKit.SMALL.drawCentered(class_3322, UiKit.SMALL.ellipsize(string3, 208.0f), 120.0f, UiKit.SMALL.centerTop(135.0f), ColorUtil.mulAlpha(Theme.textMuted, 0.9f));
    }

    private void ieb(class_332 class_3322, int n, float f, float f2) {
        boolean bl;
        float f3 = this.idz(n);
        float f4 = this.idy();
        boolean bl2 = bl = !this.idn && UiKit.inside(f, f2, f3, 52.0f, f4, 64.0f);
        if (bl) {
            this.idm = n;
        }
        float f5 = this.idk[n].step(bl || this.idm == n && !this.iec(f, f2), this.idq);
        boolean bl3 = Lang.chosen() && Lang.get() == idh[n];
        float f6 = this.idl[n].step(bl3, this.idq);
        float f7 = 52.0f - 1.5f * f5;
        float f8 = Theme.r(8.0f);
        float f9 = Theme.lightness();
        GlassDraw.shadow(class_3322, f3, f7, f4, 64.0f, f8, 0.3f + 0.7f * f5, f9);
        DrawUtil.round(class_3322, f3, f7, f4, 64.0f, f8, ColorUtil.lerp(Theme.card | 0xFF000000, Theme.cardHover | 0xFF000000, f5));
        DrawUtil.outline(class_3322, f3, f7, f4, 64.0f, f8, 1.0f, ColorUtil.lerp(ColorUtil.lerp(Theme.stroke, Theme.textMuted, 0.35f * f5), Theme.accent(), Math.max(f6, 0.6f * f5)));
        GlassDraw.rim(class_3322, f3, f7, f4, 64.0f, f8, f9, 0.8f);
        LanguageScreen.flag(class_3322, idh[n], f3 + 11.0f, f7 + 11.0f);
        boolean bl4 = idh[n] == wam.RU;
        UiKit.LOGO.draw(class_3322, bl4 ? "RU" : "EN", f3 + 11.0f, UiKit.LOGO.centerTop(f7 + 38.0f), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f5, f6)));
        UiKit.LABEL.draw(class_3322, bl4 ? "Русский" : "English", f3 + 11.0f, UiKit.LABEL.centerTop(f7 + 52.0f), Theme.textMuted);
        if (f6 > 0.01f) {
            float f10 = f3 + f4 - 12.0f;
            float f11 = f7 + 12.0f;
            float f12 = Easing.outBack(f6);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f10, f11);
            class_3322.method_51448().scale(f12, f12);
            DrawUtil.circle(class_3322, 0.0f, 0.0f, 5.5f, Theme.accent());
            IconRenderer.draw(class_3322, Icon.CHECK, 0.0f, 0.0f, 7.0f, Theme.onAccent());
            class_3322.method_51448().popMatrix();
        } else if (f5 > 0.01f) {
            DrawUtil.pushAlpha(f5);
            IconRenderer.draw(class_3322, Icon.CHEVRON_RIGHT, f3 + f4 - 12.0f, f7 + 32.0f, 8.0f, Theme.accent());
            DrawUtil.popAlpha();
        }
    }

    private boolean iec(float f, float f2) {
        for (int i = 0; i < idh.length; ++i) {
            if (!UiKit.inside(f, f2, this.idz(i), 52.0f, this.idy(), 64.0f)) continue;
            return true;
        }
        return false;
    }

    public static void flag(class_332 class_3322, wam wam2, float f, float f2) {
        float f3 = 20.0f;
        float f4 = 13.0f;
        float f5 = 2.5f;
        if (wam2 == wam.RU) {
            DrawUtil.round(class_3322, f, f2, f3, f4, f5, -2807010);
            DrawUtil.round(class_3322, f, f2, f3, f4 * 2.0f / 3.0f, f5, f5, 0.0f, 0.0f, -16762458);
            DrawUtil.round(class_3322, f, f2, f3, f4 / 3.0f, f5, f5, 0.0f, 0.0f, -1);
            DrawUtil.rect(class_3322, f, f2 + f4 / 3.0f - 0.5f, f3, 1.0f, -16762458);
        } else {
            DrawUtil.round(class_3322, f, f2, f3, f4, f5, -14729329);
            DrawUtil.line(class_3322, f + 1.0f, f2 + 1.0f, f + f3 - 1.0f, f2 + f4 - 1.0f, 2.2f, -1);
            DrawUtil.line(class_3322, f + f3 - 1.0f, f2 + 1.0f, f + 1.0f, f2 + f4 - 1.0f, 2.2f, -1);
            DrawUtil.line(class_3322, f + 1.0f, f2 + 1.0f, f + f3 - 1.0f, f2 + f4 - 1.0f, 0.9f, -3665874);
            DrawUtil.line(class_3322, f + f3 - 1.0f, f2 + 1.0f, f + 1.0f, f2 + f4 - 1.0f, 0.9f, -3665874);
            DrawUtil.rect(class_3322, f + f3 * 0.5f - 2.0f, f2, 4.0f, f4, -1);
            DrawUtil.rect(class_3322, f, f2 + f4 * 0.5f - 2.0f, f3, 4.0f, -1);
            DrawUtil.rect(class_3322, f + f3 * 0.5f - 1.1f, f2, 2.2f, f4, -3665874);
            DrawUtil.rect(class_3322, f, f2 + f4 * 0.5f - 1.1f, f3, 2.2f, -3665874);
        }
        DrawUtil.outline(class_3322, f, f2, f3, f4, f5, 0.8f, 0x30000000);
    }

    private void ied(int n) {
        if (this.idn) {
            return;
        }
        Lang.set(idh[n]);
        GuiConfig.saveLater();
        this.method_25419();
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        if (this.idn || class_119092.method_74245() != 0) {
            return true;
        }
        float f = (float)((class_119092.comp_4798() - (double)this.ids) / (double)this.idr);
        float f2 = (float)((class_119092.comp_4799() - (double)this.idt) / (double)this.idr);
        for (int i = 0; i < idh.length; ++i) {
            if (!UiKit.inside(f, f2, this.idz(i), 52.0f, this.idy(), 64.0f)) continue;
            this.ied(i);
            return true;
        }
        return true;
    }

    public boolean method_25404(class_11908 class_119082) {
        int n = class_119082.comp_4795();
        if (this.idn) {
            return true;
        }
        switch (n) {
            case 263: 
            case 265: {
                this.idm = 0;
                break;
            }
            case 258: 
            case 262: 
            case 264: {
                this.idm = this.idm == 0 ? 1 : 0;
                break;
            }
            case 32: 
            case 257: 
            case 335: {
                this.ied(this.idm);
                break;
            }
            case 256: {
                this.method_25419();
                break;
            }
        }
        return true;
    }

    public void method_25419() {
        if (!this.idn) {
            this.idn = true;
            this.idj.backward();
        }
    }

    public void method_25432() {
        FontFace.setRenderScale(1.0f);
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25422() {
        return false;
    }

    private static /* synthetic */ int afm(int n, int n2) {
        return n + n2 ^ 0x62769FFE;
    }

    private static /* synthetic */ int afn(int n, int n2) {
        return LanguageScreen.afm(n, n2) ^ 0x8C525F8;
    }
}

