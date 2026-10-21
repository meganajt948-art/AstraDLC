/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 *  net.minecraft.class_8685
 */
package a;

import a.Theme;
import a.Hud;
import a.HudWidget;
import a.jjj;
import a.NameProtect;
import a.ColorUtil;
import a.GlassDraw;
import a.PlayerHeadDraw;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.BoolSetting;
import a.Setting;
import a.FormatUtil;
import a.vyd;
import a.BelowNameHook;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_8685;

public final class TargetHudWidget
extends HudWidget {
    public static final BoolSetting PLAYERS_ONLY = new BoolSetting("Players only", true);
    public static final BoolSetting ITEMS = new BoolSetting("Armor and hands", true);
    public static final List<Setting> OPTIONS = List.of(PLAYERS_ONLY, ITEMS);
    private static final float jjy = 168.0f;
    private static final float jjz = 46.0f;
    private static final float jka = 40.0f;
    private static final float jkb = 8.0f;
    private static final float jkc = 30.0f;
    private static final float jkd = 15.0f;
    private static final float jke = 2.4f;
    private static final float jkf = 10.5f;
    private static final long jkg = 6000L;
    private static final long jkh = 900L;
    private static final double jki = 10.0;
    private static final int jkj = -12595334;
    private static final int jkk = -865972;
    private static final int jkl = -1092784;
    private static final int jkm = -670639;
    private static final class_1304[] jkn = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
    private static class_1309 jko;
    private static long jkp;
    private class_1309 jkq;
    private long jkr;
    private jjj jks;
    private boolean jkt;
    private int jku;
    private final Spring jkv = new Spring(9.0f, 1.0f);
    private final Spring jkw = new Spring(4.5f, 1.0f);
    private final Spring jkx = new Spring(9.0f);
    private final Spring jky = new Spring(6.0f);
    private final Spring jkz = new Spring(10.0f);
    private final Spring jla = new Spring(9.0f);
    private long jlb;
    private static /* synthetic */ long jlc;
    private static /* synthetic */ int jld;

    TargetHudWidget() {
        super("target", "Target", true, 1, 1, 0.0f, 44.0f);
    }

    @Override
    public List<Setting> settings() {
        return OPTIONS;
    }

    public static void onAttack(class_1297 class_12972) {
        if (class_12972 instanceof class_1309) {
            class_1309 class_13092;
            jko = class_13092 = (class_1309)class_12972;
            jkp = System.currentTimeMillis();
        }
    }

    @Override
    void update(float f, boolean bl) {
        float f2;
        class_1309 class_13092;
        class_310 class_3102 = class_310.method_1551();
        long l = System.currentTimeMillis();
        class_1309 class_13093 = class_13092 = this.enabled.get() ? TargetHudWidget.jle(class_3102, l) : null;
        if (class_13092 != null) {
            this.jkr = l;
            if (class_13092 != this.jkq) {
                if (this.jkq != null) {
                    this.jla.set(1.0f);
                }
                this.jkq = class_13092;
                this.jku = class_13092.field_6235;
                vyd vyd2 = BelowNameHook.of(class_13092);
                f2 = vyd2.fraction();
                this.jkv.set(f2);
                this.jkw.set(f2);
                this.jkx.set(vyd2.unknown() ? 0.0f : Math.min(1.0f, vyd2.absorption() / vyd2.max()));
                this.jkz.set(f2 < 0.3f ? 1.0f : 0.0f);
            }
        } else if (!(this.jkq == null || l - this.jkr <= 900L && TargetHudWidget.jlf(class_3102, this.jkq))) {
            this.jkq = null;
        }
        this.jkt = false;
        if (this.jkq != null) {
            this.jks = TargetHudWidget.jlg(this.jkq, class_3102);
        } else if (bl && class_3102.field_1724 != null) {
            this.jks = TargetHudWidget.jlh(class_3102.field_1724);
            this.jkt = true;
        }
        if (this.jks == null) {
            return;
        }
        float f3 = this.jks.jjp ? 1.0f : Math.min(1.0f, this.jks.jjm / Math.max(1.0f, this.jks.jjn));
        if (f3 < (f2 = this.jkv.get()) - 0.001f && this.jkw.get() <= f2 + 0.001f) {
            this.jlb = l + 350L;
            this.jkw.set(Math.max(this.jkw.get(), f2));
        }
        this.jkv.step(f3, f);
        if (f3 > this.jkw.get() || l > this.jlb) {
            this.jkw.step(Math.max(f3, this.jkv.get()), f);
        }
        this.jkx.step(this.jks.jjp ? 0.0f : Math.min(1.0f, this.jks.jjo / Math.max(1.0f, this.jks.jjn)), f);
        this.jkz.step(f3 < 0.3f ? 1.0f : 0.0f, f);
        if (this.jkq != null && this.jkq.field_6235 > this.jku) {
            this.jky.set(1.0f);
        }
        this.jku = this.jkq != null ? this.jkq.field_6235 : 0;
        this.jky.step(0.0f, f);
        this.jla.step(0.0f, f);
    }

    private static class_1309 jle(class_310 class_3102, long l) {
        class_1309 class_13092;
        if (jko != null && l - jkp < 6000L && TargetHudWidget.jlf(class_3102, jko)) {
            return jko;
        }
        class_1297 class_12972 = class_3102.field_1692;
        if (class_12972 instanceof class_1309 && !((class_13092 = (class_1309)class_12972) instanceof class_1531) && TargetHudWidget.jlf(class_3102, class_13092)) {
            return class_13092;
        }
        class_13092 = class_3102.field_1724;
        if (class_13092 == null || class_3102.field_1687 == null) {
            return null;
        }
        class_12972 = class_13092.method_33571();
        class_243 class_2432 = class_13092.method_5828(1.0f);
        class_1657 class_16572 = null;
        double d = Math.cos(Math.toRadians(5.0));
        for (class_1657 class_16573 : class_3102.field_1687.method_18456()) {
            double d2;
            class_243 class_2433;
            double d3;
            if (class_16573 == class_13092 || !TargetHudWidget.jlf(class_3102, (class_1309)class_16573) || (d3 = (class_2433 = class_16573.method_5829().method_1005().method_1020((class_243)class_12972)).method_1033()) > 10.0 || d3 < 0.01 || !((d2 = class_2433.method_1021(1.0 / d3).method_1026(class_2432)) > d) || !class_13092.method_6057((class_1297)class_16573)) continue;
            d = d2;
            class_16572 = class_16573;
        }
        return class_16572;
    }

    private static boolean jlf(class_310 class_3102, class_1309 class_13092) {
        if (class_3102.field_1687 == null || class_3102.field_1724 == null || class_13092 == class_3102.field_1724 || !class_13092.method_5805() || class_13092.method_31481() || class_3102.field_1687.method_8469(class_13092.method_5628()) != class_13092) {
            return false;
        }
        if (PLAYERS_ONLY.get() && !(class_13092 instanceof class_1657)) {
            return false;
        }
        return class_3102.field_1724.method_5858((class_1297)class_13092) < 576.0;
    }

    private static jjj jlg(class_1309 class_13092, class_310 class_3102) {
        class_8685 class_86852;
        Object object;
        if (class_13092 instanceof class_742) {
            object = (class_742)class_13092;
            class_86852 = object.method_52814();
        } else {
            class_86852 = null;
        }
        class_8685 class_86853 = class_86852;
        object = BelowNameHook.of(class_13092);
        class_1799[] class_1799Array = new class_1799[4];
        for (int i = 0; i < 4; ++i) {
            class_1799Array[i] = class_13092.method_6118(jkn[i]);
        }
        float f = class_3102.field_1724 != null ? (float)Math.sqrt(class_3102.field_1724.method_5858((class_1297)class_13092)) : 0.0f;
        return new jjj(NameProtect.protect(class_13092.method_5477().getString()), class_86853, ((vyd)object).health(), ((vyd)object).max(), ((vyd)object).absorption(), ((vyd)object).unknown(), class_1799Array, class_13092.method_6047(), class_13092.method_6079(), f, class_13092.field_6235);
    }

    private static jjj jlh(class_746 class_7462) {
        class_1799[] class_1799Array = new class_1799[]{TargetHudWidget.jli(class_1802.field_22027, 0.08f), TargetHudWidget.jli(class_1802.field_22028, 0.35f), TargetHudWidget.jli(class_1802.field_8348, 0.62f), TargetHudWidget.jli(class_1802.field_8285, 0.86f)};
        return new jjj(NameProtect.protect(class_7462.method_5477().getString()), class_7462.method_52814(), 13.5f, 20.0f, 4.0f, false, class_1799Array, TargetHudWidget.jli(class_1802.field_22022, 0.2f), new class_1799((class_1935)class_1802.field_8288), 3.4f, 0);
    }

    private static class_1799 jli(class_1792 class_17922, float f) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        if (class_17992.method_7963()) {
            class_17992.method_7974(Math.round((float)class_17992.method_7936() * f));
        }
        return class_17992;
    }

    @Override
    boolean hasContent(boolean bl) {
        return this.jkq != null || bl && this.jks != null;
    }

    @Override
    boolean canGhost() {
        return true;
    }

    @Override
    boolean isSample() {
        return this.jkt;
    }

    @Override
    float width() {
        return 168.0f;
    }

    @Override
    float height() {
        return ITEMS.get() ? 46.0f : 40.0f;
    }

    @Override
    void draw(class_332 class_3322, float f, boolean bl) {
        jjj jjj2 = this.jks;
        if (jjj2 == null) {
            return;
        }
        float f2 = 168.0f;
        float f3 = this.height();
        float f4 = Theme.r(9.0f);
        Hud.panel(class_3322, f2, f3, f4);
        float f5 = Easing.outCubic(this.jla.get());
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(0.0f, f3 * 0.5f);
        class_3322.method_51448().scale(1.0f, 1.0f - 0.18f * f5);
        class_3322.method_51448().translate(0.0f, -f3 * 0.5f);
        DrawUtil.pushAlpha(1.0f - 0.85f * f5);
        this.jlj(class_3322, jjj2, 8.0f, (f3 - 30.0f) * 0.5f);
        this.jlk(class_3322, jjj2, 46.0f, f3);
        this.jln(class_3322, jjj2, f2 - 8.0f - 15.0f, f3 * 0.5f);
        DrawUtil.popAlpha();
        class_3322.method_51448().popMatrix();
    }

    private void jlj(class_332 class_3322, jjj jjj2, float f, float f2) {
        boolean bl;
        float f3 = Math.min(15.0f, Theme.r(7.0f));
        float f4 = Easing.outCubic(this.jky.get());
        float f5 = 1.0f - 0.07f * f4;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f + 15.0f, f2 + 15.0f);
        class_3322.method_51448().scale(f5, f5);
        float f6 = -15.0f;
        GlassDraw.shadow(class_3322, f6, f6, 30.0f, 30.0f, f3, 0.8f, Theme.lightness());
        int n = ColorUtil.lerp(-1, -34182, f4);
        boolean bl2 = bl = jjj2.jjl != null && PlayerHeadDraw.draw(class_3322, jjj2.jjl, f6, f6, 30.0f, f3, n);
        if (!bl) {
            DrawUtil.round(class_3322, f6, f6, 30.0f, 30.0f, f3, Theme.field);
            String string = jjj2.jjk.isEmpty() ? "?" : jjj2.jjk.substring(0, 1).toUpperCase(Locale.ROOT);
            Hud.RING.drawCentered(class_3322, string, 0.0f, Hud.RING.centerTop(0.0f), Theme.textDim);
        }
        DrawUtil.outlineGradientV(class_3322, f6, f6, 30.0f, 30.0f, f3, 1.0f, 0x38FFFFFF, 0xAFFFFFF);
        class_3322.method_51448().popMatrix();
    }

    private void jlk(class_332 class_3322, jjj jjj2, float f, float f2) {
        float f3 = 123.0f;
        boolean bl = ITEMS.get();
        float f4 = bl ? 12.5f : f2 * 0.5f - 4.0f;
        String string = Lang.unit("m");
        String string2 = jjj2.jjt < 10.0f ? FormatUtil.fixed(jjj2.jjt, 1) + string : Math.round(jjj2.jjt) + string;
        float f5 = Hud.SMALL.width(string2);
        String string3 = Hud.TITLE.ellipsize(jjj2.jjk, f3 - f - f5 - 5.0f);
        float f6 = Hud.TITLE.draw(class_3322, string3, f, Hud.TITLE.centerTop(f4), Theme.text);
        Hud.SMALL.draw(class_3322, string2, f6 + 4.0f, Hud.SMALL.centerTop(f4 + 0.4f), Theme.textMuted);
        if (!bl) {
            String string4;
            String string5 = jjj2.jjp ? Lang.s("Invisible", "Невидимка") : (string4 = jjj2.jjo > 0.05f ? Lang.s("Absorbing", "Поглощение") : "");
            if (!string4.isEmpty()) {
                Hud.SUB.draw(class_3322, string4, f, Hud.SUB.centerTop(f4 + 9.0f), Theme.textMuted);
            }
            return;
        }
        float f7 = 22.5f;
        float f8 = f;
        for (class_1799 class_17992 : jjj2.jjq) {
            this.jll(class_3322, class_17992, f8, f7);
            f8 += 12.0f;
        }
        DrawUtil.rect(class_3322, (f8 += 2.0f) - 0.5f, f7 + 2.0f, 1.0f, 7.5f, ColorUtil.mulAlpha(Theme.textMuted, 0.3f));
        this.jll(class_3322, jjj2.jjr, f8 += 3.5f, f7);
        this.jll(class_3322, jjj2.jjs, f8 += 12.0f, f7);
    }

    private void jll(class_332 class_3322, class_1799 class_17992, float f, float f2) {
        if (class_17992 == null || class_17992.method_7960()) {
            DrawUtil.round(class_3322, f + 5.25f - 1.2f, f2 + 5.25f - 1.2f, 2.4f, 2.4f, 1.2f, ColorUtil.mulAlpha(Theme.textMuted, 0.35f));
            return;
        }
        float f3 = DrawUtil.alpha();
        float f4 = 0.65625f * Math.min(1.0f, f3 * 2.5f);
        if (f4 > 0.02f) {
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f + 5.25f, f2 + 5.25f);
            class_3322.method_51448().scale(f4, f4);
            class_3322.method_51427(class_17992, -8, -8);
            class_3322.method_51448().popMatrix();
        }
        if (class_17992.method_7963() && class_17992.method_7936() > 0) {
            float f5 = 1.0f - (float)class_17992.method_7919() / (float)class_17992.method_7936();
            float f6 = 8.5f;
            float f7 = f2 + 10.5f + 2.2f;
            DrawUtil.round(class_3322, f + 1.0f, f7, f6, 1.3f, 0.65f, Theme.track);
            DrawUtil.round(class_3322, f + 1.0f, f7, Math.max(1.3f, f6 * f5), 1.3f, 0.65f, TargetHudWidget.jlm(f5));
        }
    }

    private static int jlm(float f) {
        return f > 0.5f ? ColorUtil.lerp(-865972, -12595334, (f - 0.5f) * 2.0f) : ColorUtil.lerp(-1092784, -865972, f * 2.0f);
    }

    private void jln(class_332 class_3322, jjj jjj2, float f, float f2) {
        float f3;
        DrawUtil.arc(class_3322, f, f2, 15.0f, 2.4f, 0.0f, 1.0f, ColorUtil.mulAlpha(Theme.text, 0.12f));
        if (jjj2.jjp) {
            float f4 = (float)((double)System.nanoTime() / 1.0E9 * 0.6 % 1.0);
            DrawUtil.arc(class_3322, f, f2, 15.0f, 2.4f, f4, 0.22f, ColorUtil.mulAlpha(Theme.textMuted, 0.9f));
            Hud.RING.drawCentered(class_3322, "?", f, Hud.RING.centerTop(f2), Theme.text);
            return;
        }
        float f5 = this.jkv.get();
        float f6 = this.jkw.get();
        if (f6 > f5 + 0.002f) {
            DrawUtil.arc(class_3322, f, f2, 15.0f, 2.4f, 0.0f, f6, ColorUtil.withAlpha(-1092784, 150));
        }
        int n = ColorUtil.lerp(Theme.accent(), -1092784, this.jkz.get());
        DrawUtil.arc(class_3322, f, f2, 15.0f, 2.4f, 0.0f, f5, n);
        float f7 = this.jkx.get();
        if (f7 > 0.003f) {
            DrawUtil.arc(class_3322, f, f2, 17.6f, 1.1f, 0.0f, f7, -670639);
        }
        String string = (f3 = jjj2.jjm + jjj2.jjo) >= 100.0f || Math.abs(f3 - (float)Math.round(f3)) < 0.05f ? String.valueOf(Math.round(f3)) : FormatUtil.fixed(f3, 1);
        Hud.RING.drawCentered(class_3322, string, f, Hud.RING.centerTop(f2 - 1.8f), jjj2.jjo > 0.05f ? -670639 : Theme.text);
        Hud.TINY.drawCentered(class_3322, Lang.s("hp", "хп"), f, Hud.TINY.centerTop(f2 + 5.2f), Theme.textMuted);
    }

    private static /* synthetic */ int aoj(int n, int n2) {
        return n * n2 + 156495881;
    }

    private static /* synthetic */ int aok(int n, int n2) {
        return TargetHudWidget.aoj(n, n2) ^ 0x7147DFF6;
    }
}

