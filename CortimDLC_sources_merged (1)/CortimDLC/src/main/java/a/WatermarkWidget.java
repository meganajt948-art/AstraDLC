/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_640
 *  net.minecraft.class_746
 */
package a;

import a.UserProfile;
import a.ClickGuiScreen;
import a.Theme;
import a.Hud;
import a.HudWidget;
import a.TimedWidget;
import a.jgd;
import a.NowPlaying;
import a.TpsMeter;
import a.jlo;
import a.jlr;
import a.jlu;
import a.Module;
import a.ColorUtil;
import a.GpuTexture;
import a.LogoRenderer;
import a.AnimatedLogo;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.SmoothValue;
import a.Tween;
import a.FontFace;
import a.Icon;
import a.IconRenderer;
import a.BoolSetting;
import a.ModeSetting;
import a.Setting;
import a.FormatUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_640;
import net.minecraft.class_746;

public final class WatermarkWidget
extends HudWidget {
    public static final BoolSetting FPS;
    public static final BoolSetting PING;
    public static final BoolSetting TPS;
    public static final BoolSetting BPS;
    public static final BoolSetting COORDS;
    public static final BoolSetting TIME;
    public static final BoolSetting ACCOUNT;
    public static final BoolSetting ALERTS;
    public static final List<Setting> ISLAND;
    public static final BoolSetting MUSIC;
    public static final ModeSetting VIEW;
    public static final BoolSetting EXPAND;
    public static final BoolSetting COVER;
    public static final List<Setting> MUSIC_SETTINGS;
    private static final float jly = 17.0f;
    private static final float jlz = 7.0f;
    private static final float jma = 11.0f;
    private static final float jmb = 11.0f;
    private static final float jmc = 200.0f;
    private static final float jmd = 44.0f;
    private static final float jme = 30.0f;
    private static final float jmf = 12.0f;
    private static final long jmg = 1700L;
    private static final long jmh = 4500L;
    private static final long jmi = 15000L;
    private static final long jmj = 200L;
    private static final long jmk = 2500L;
    private static final String jml;
    private final SmoothValue jmm = new SmoothValue(190.0f, 0.8f);
    private final SmoothValue jmn = new SmoothValue(190.0f, 0.8f);
    private final Tween jmo = new Tween(0.38f, 1.0f);
    private jlr jmp = jlr.BASE;
    private jlr jmq = jlr.BASE;
    private final List<jlu> jmr = new ArrayList<jlu>();
    private final jlu[] jms = new jlu[]{new jlu(), new jlu(), new jlu(), new jlu(), new jlu(), new jlu()};
    private long jmt;
    private String jmu = "";
    private static final int jmv = 6;
    private static final float jmw = 12.0f;
    private static final float jmx = 11.0f;
    private static final float jmy = 4.0f;
    private final List<jlo> jmz = new ArrayList<jlo>();
    private jgd jna;
    private long jnb;
    private GpuTexture jnc;
    private final Spring jnd = new Spring(7.0f, 1.0f);
    private final Spring[] jne = new Spring[]{new Spring(14.0f), new Spring(14.0f), new Spring(14.0f), new Spring(14.0f)};
    private final Spring[] jnf = new Spring[]{new Spring(16.0f), new Spring(16.0f), new Spring(16.0f)};
    private final Spring[] jng = new Spring[]{new Spring(9.0f), new Spring(9.0f), new Spring(9.0f)};
    private final float[] jnh = new float[3];
    private float jni = -100.0f;
    private static final float jnj = 9.0f;
    private String jnk;
    private String jnl = "";
    private String jnm = "";
    private String jnn = "";
    private static final float jno = 2.3f;
    private static /* synthetic */ String jnp;
    private static /* synthetic */ String jnq;

    WatermarkWidget() {
        super("watermark", "Watermark", true, 1, 0, 0.0f, 6.0f);
    }

    @Override
    public List<Setting> settings() {
        ArrayList<Setting> arrayList = new ArrayList<Setting>(ISLAND);
        arrayList.add(MUSIC);
        arrayList.addAll(MUSIC_SETTINGS);
        return arrayList;
    }

    void toggled(Module kfe2) {
        this.alert(kfe2.getDisplayName(), kfe2.isAction() ? Lang.s("Activated", "Активирован") : Lang.s(kfe2.isEnabled() ? "On" : "Off", kfe2.isEnabled() ? "Включён" : "Выключен"), ClickGuiScreen.iconFor(kfe2.getCategory()), kfe2.isEnabled());
    }

    void alert(String string, String string2, Icon vhz2, boolean bl) {
        if (!ALERTS.get()) {
            return;
        }
        long l = System.currentTimeMillis();
        jlo jlo2 = null;
        for (jlo jlo3 : this.jmz) {
            if (!jlo3.name.equals(string) || l - jlo3.at >= 1700L) continue;
            jlo2 = jlo3;
            break;
        }
        if (jlo2 == null) {
            jlo2 = new jlo();
            jlo2.name = string;
            jlo2.flip.set(bl ? 0.0f : 1.0f);
            jlo2.shown.set(this.jnr(l) ? 0.0f : 1.0f);
            this.jmz.add(jlo2);
            if (this.jmz.size() > 6) {
                this.jmz.remove(0);
            }
        }
        jlo2.on = bl;
        jlo2.state = string2;
        jlo2.icon = vhz2;
        jlo2.at = l;
    }

    private boolean jnr(long l) {
        for (jlo jlo2 : this.jmz) {
            if (l - jlo2.at >= 1700L) continue;
            return true;
        }
        return false;
    }

    @Override
    void update(float f, boolean bl) {
        GpuTexture uok2;
        float f2;
        boolean bl2;
        long l = System.currentTimeMillis();
        jgd jgd2 = this.jna = MUSIC.get() ? NowPlaying.track() : null;
        if (this.jna == null && bl && MUSIC.get()) {
            this.jna = new jgd("Preview", "Midnight City", "M83", true, 0L, 243000L, l - l % 243000L);
        }
        if (this.jna != null && !this.jna.playing()) {
            if (this.jnb == 0L) {
                this.jnb = l;
            }
        } else {
            this.jnb = 0L;
        }
        boolean bl3 = this.jna != null && (this.jna.playing() || l - this.jnb < 15000L);
        boolean bl4 = this.jna != null && (Hud.pointer() || bl3 && (VIEW.is("Full") || EXPAND.get() && l - NowPlaying.changedAt() < 4500L && !"Preview".equals(this.jna.app())));
        boolean bl5 = bl2 = ALERTS.get() && this.jnr(l);
        jlr jlr2 = bl2 ? jlr.ALERT : (bl4 ? jlr.MUSIC : jlr.BASE);
        if (jlr2 != this.jmp) {
            this.jmq = this.jmp;
            this.jmp = jlr2;
            this.jmo.restart();
        }
        this.jmo.update(f);
        this.jns(l);
        this.joe(l, bl2, f);
        float f3 = 17.0f;
        switch (this.jmp.ordinal()) {
            case 1: {
                f2 = this.jog(l);
                f3 = this.joh();
                break;
            }
            case 2: {
                f2 = 200.0f;
                f3 = 44.0f;
                break;
            }
            default: {
                f2 = this.jnw(null, 0.0f, 0.0f, bl3);
            }
        }
        this.jmm.step(f2, f);
        this.jmn.step(f3, f);
        boolean bl6 = this.jna != null && this.jna.playing();
        double d = (double)System.nanoTime() / 1.0E9;
        for (int i = 0; i < this.jne.length; ++i) {
            float f4 = (float)(0.5 + 0.25 * Math.sin(d * (7.1 + (double)i * 2.3) + (double)i * 1.7) + 0.25 * Math.sin(d * (11.3 - (double)i * 1.9) + (double)i * 0.6));
            this.jne[i].step(bl6 ? 0.25f + 0.75f * f4 : 0.18f, f);
        }
        GpuTexture uok3 = uok2 = COVER.get() ? NowPlaying.cover() : null;
        if (uok2 != this.jnc) {
            this.jnc = uok2;
            if (uok2 != null) {
                this.jnd.set(0.0f);
            }
        }
        this.jnd.step(1.0f, f);
        for (int i = 0; i < 3; ++i) {
            this.jng[i].step(0.0f, f);
        }
    }

    private void jns(long l) {
        class_746 class_7462;
        boolean bl;
        String string = (FPS.get() ? "f" : "") + (PING.get() ? "p" : "") + (TPS.get() ? "t" : "") + (BPS.get() ? "b" : "") + (COORDS.get() ? "c" : "") + (TIME.get() ? "h" : "");
        boolean bl2 = bl = !string.equals(this.jmu);
        if (!bl && l - this.jmt < 200L) {
            return;
        }
        this.jmt = l;
        this.jmu = string;
        class_310 class_3102 = class_310.method_1551();
        this.jmr.clear();
        int n = 0;
        if (FPS.get()) {
            class_7462 = this.jms[n++];
            WatermarkWidget.jnt((jlu)class_7462, "", String.valueOf(class_3102.method_47599()), "fps", 0, 0);
            this.jmr.add((jlu)class_7462);
        }
        if (PING.get()) {
            int n2 = WatermarkWidget.joc(class_3102);
            jlu object2 = this.jms[n++];
            WatermarkWidget.jnt(object2, "", String.valueOf(n2), Lang.unit("ms"), 0, n2 < 80 ? -12595334 : (n2 < 160 ? -865972 : -1092784));
            this.jmr.add(object2);
        }
        if (TPS.get()) {
            float f = TpsMeter.tps();
            jlu jlu2 = this.jms[n++];
            int n2 = f < 0.0f || f >= 18.0f ? 0 : (f >= 12.0f ? -865972 : -1092784);
            WatermarkWidget.jnt(jlu2, "", f < 0.0f ? "–" : WatermarkWidget.jnu(f), "tps", n2, 0);
            this.jmr.add(jlu2);
        }
        if (BPS.get()) {
            class_7462 = this.jms[n++];
            WatermarkWidget.jnt((jlu)class_7462, "", WatermarkWidget.jnu(TpsMeter.bps()), Lang.s("bps", "бл/с"), 0, 0);
            this.jmr.add((jlu)class_7462);
        }
        if (COORDS.get()) {
            class_7462 = class_3102.field_1724;
            String string2 = class_7462 == null ? "0 0 0" : class_7462.method_31477() + " " + class_7462.method_31478() + " " + class_7462.method_31479();
            jlu jlu3 = this.jms[n++];
            WatermarkWidget.jnt(jlu3, "XYZ", string2, "", 0, 0);
            this.jmr.add(jlu3);
        }
        if (TIME.get()) {
            class_7462 = LocalTime.now();
            jlu jlu4 = this.jms[n];
            WatermarkWidget.jnt(jlu4, "", FormatUtil.hoursMinutes(class_7462.getHour(), class_7462.getMinute()), "", 0, 0);
            this.jmr.add(jlu4);
        }
        for (jlu jlu5 : this.jmr) {
            float f = jlu5.natural();
            if (!bl && !(f >= jlu5.wide) && l - jlu5.wideAt <= 2500L) continue;
            jlu5.wide = f;
            jlu5.wideAt = l;
        }
    }

    private static void jnt(jlu jlu2, String string, String string2, String string3, int n, int n2) {
        jlu2.label = string;
        jlu2.value = string2;
        jlu2.unit = string3;
        jlu2.color = n;
        jlu2.dot = n2;
    }

    private static String jnu(float f) {
        return f >= 100.0f ? String.valueOf(Math.round(f)) : FormatUtil.fixed(f, 1);
    }

    @Override
    boolean hasContent(boolean bl) {
        return true;
    }

    @Override
    float width() {
        return Math.max(17.0f, this.jmm.get());
    }

    @Override
    float height() {
        return Math.max(8.0f, this.jmn.get());
    }

    @Override
    void draw(class_332 class_3322, float f, boolean bl) {
        float f2;
        float f3 = this.width();
        float f4 = this.height();
        float f5 = Math.min(f4 * 0.5f, Theme.r(11.0f));
        Hud.panel(class_3322, f3, f4, f5);
        DrawUtil.pushScissor(class_3322, 0.0f, 0.0f, f3, f4);
        float f6 = this.jmo.linear();
        if (this.jmq != this.jmp && f6 < 1.0f && (f2 = 1.0f - Easing.outCubic(Math.min(1.0f, f6 / 0.45f))) > 0.01f) {
            this.jnv(class_3322, this.jmq, f3, f4, f2, f);
        }
        float f7 = f2 = this.jmq == this.jmp ? 1.0f : Easing.outCubic(Math.max(0.0f, (f6 - 0.25f) / 0.75f));
        if (f2 > 0.01f) {
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(0.0f, (1.0f - f2) * 3.0f);
            this.jnv(class_3322, this.jmp, f3, f4, f2, f);
            class_3322.method_51448().popMatrix();
        }
        DrawUtil.popScissor(class_3322);
    }

    private void jnv(class_332 class_3322, jlr jlr2, float f, float f2, float f3, float f4) {
        DrawUtil.pushAlpha(f3);
        switch (jlr2.ordinal()) {
            case 1: {
                this.joi(class_3322, f, f2);
                break;
            }
            case 2: {
                this.joj(class_3322, f, f2, f4);
                break;
            }
            default: {
                boolean bl = this.jna != null && (this.jna.playing() || System.currentTimeMillis() - this.jnb < 15000L);
                float f5 = this.jnw(null, 0.0f, 0.0f, bl);
                this.jnw(class_3322, (f - f5) * 0.5f, f2 * 0.5f, bl);
            }
        }
        DrawUtil.popAlpha();
    }

    private float jnw(class_332 class_3322, float f, float f2, boolean bl) {
        float f3 = f + 7.0f - 1.0f;
        f3 = WatermarkWidget.joa(class_3322, Hud.BRAND, "AstraDLC", f3, f2, Theme.text);
        for (jlu jlu2 : this.jmr) {
            f3 = WatermarkWidget.job(class_3322, f3, f2);
            float f4 = f3 + jlu2.wide;
            if (class_3322 != null) {
                float f5 = f3;
                if (!jlu2.label.isEmpty()) {
                    f5 = Hud.SMALL.draw(class_3322, jlu2.label, f5, Hud.SMALL.centerTop(f2), Theme.textMuted) + 3.0f;
                }
                if (jlu2.dot != 0) {
                    DrawUtil.circle(class_3322, f5 + 1.6f, f2, 1.6f, jlu2.dot);
                    f5 += 6.2f;
                }
                f5 = Hud.VALUE.draw(class_3322, jlu2.value, f5, Hud.VALUE.centerTop(f2), jlu2.color == 0 ? Theme.text : jlu2.color);
                if (!jlu2.unit.isEmpty()) {
                    Hud.SMALL.draw(class_3322, jlu2.unit, f5 + 2.0f, Hud.SMALL.centerTop(f2), Theme.textMuted);
                }
            }
            f3 = f4;
        }
        if (bl && this.jna != null) {
            f3 = WatermarkWidget.job(class_3322, f3, f2);
            GpuTexture uok2 = this.jnc;
            if (uok2 != null) {
                if (class_3322 != null) {
                    DrawUtil.image(class_3322, uok2.view, f3, f2 - 5.5f, 11.0f, 11.0f, Math.min(5.5f, Theme.r(3.0f)), -1);
                }
                f3 += 16.0f;
            }
            if (this.jna.playing()) {
                f3 = this.jod(class_3322, f3, f2, 3, 7.0f) + 5.0f;
            } else {
                if (class_3322 != null) {
                    IconRenderer.draw(class_3322, Icon.PAUSE, f3 + 3.5f, f2, 7.0f, Theme.textDim);
                }
                f3 += 11.0f;
            }
            f3 = WatermarkWidget.joa(class_3322, Hud.TEXT, this.jnz(this.jna), f3, f2, Theme.text);
        }
        return f3 + 7.0f - f;
    }

    private float jnx(class_332 class_3322, float f, float f2) {
        String string = this.jny();
        float f3 = 13.0f + Hud.VALUE.width(string);
        if (class_3322 == null) {
            return f + f3;
        }
        float f4 = f2 - 4.5f;
        if (!UserProfile.drawSelected(class_3322, f, f4, 9.0f)) {
            DrawUtil.circle(class_3322, f + 4.5f, f2, 4.5f, Theme.accent());
            Hud.TINY.drawCentered(class_3322, string.substring(0, 1).toUpperCase(Locale.ROOT), f + 4.5f, Hud.TINY.centerTop(f2), Theme.onAccent());
        }
        Hud.VALUE.draw(class_3322, string, f + 9.0f + 4.0f, Hud.VALUE.centerTop(f2), Theme.text);
        return f + f3;
    }

    private String jny() {
        String string = UserProfile.account();
        if (!string.equals(this.jnk)) {
            this.jnk = string;
            this.jnl = Hud.VALUE.ellipsize(string.isEmpty() ? "AstraDLC" : string, 70.0f);
        }
        return this.jnl;
    }

    private String jnz(jgd jgd2) {
        String string;
        String string2 = string = jgd2.artist().isEmpty() ? jgd2.title() : jgd2.title() + " · " + jgd2.artist();
        if (!string.equals(this.jnm)) {
            this.jnm = string;
            this.jnn = Hud.TEXT.ellipsize(string, 110.0f);
        }
        return this.jnn;
    }

    private static float joa(class_332 class_3322, FontFace vdn2, String string, float f, float f2, int n) {
        if (class_3322 != null) {
            return vdn2.draw(class_3322, string, f, vdn2.centerTop(f2), n);
        }
        return f + vdn2.width(string);
    }

    private static float job(class_332 class_3322, float f, float f2) {
        float f3 = 5.5f;
        if (class_3322 != null) {
            DrawUtil.circle(class_3322, f + f3, f2, 0.85f, ColorUtil.mulAlpha(Theme.textMuted, 0.6f));
        }
        return f + 11.0f;
    }

    private static int joc(class_310 class_3102) {
        if (class_3102.method_1562() == null || class_3102.field_1724 == null) {
            return 0;
        }
        class_640 class_6402 = class_3102.method_1562().method_2871(class_3102.field_1724.method_5667());
        return class_6402 != null ? Math.max(0, class_6402.method_2959()) : 0;
    }

    private float jod(class_332 class_3322, float f, float f2, int n, float f3) {
        float f4 = 1.5f;
        float f5 = 1.2f;
        if (class_3322 != null) {
            for (int i = 0; i < n; ++i) {
                float f6 = Math.max(f4, f3 * this.jne[i].get());
                DrawUtil.round(class_3322, f + (float)i * (f4 + f5), f2 - f6 * 0.5f, f4, f6, f4 * 0.5f, Theme.accent());
            }
        }
        return f + (float)n * f4 + (float)(n - 1) * f5;
    }

    private void joe(long l, boolean bl, float f) {
        for (int i = this.jmz.size() - 1; i >= 0; --i) {
            boolean bl2;
            jlo jlo2 = this.jmz.get(i);
            boolean bl3 = l - jlo2.at < 1700L;
            jlo2.shown.step(bl3 || !bl ? 1.0f : 0.0f, f);
            if (l - jlo2.at > 140L) {
                jlo2.flip.step(jlo2.on ? 1.0f : 0.0f, f);
            }
            boolean bl4 = bl ? jlo2.shown.get() <= 0.01f : (bl2 = this.jmp != jlr.ALERT && this.jmo.linear() >= 1.0f);
            if (bl3 || !bl2) continue;
            this.jmz.remove(i);
        }
    }

    private static float jof(jlo jlo2) {
        return 21.1f + Hud.HEAD.width(jlo2.name) + 5.0f + Hud.VALUE.width(jlo2.state) + 11.0f;
    }

    private float jog(long l) {
        float f = 17.0f;
        for (jlo jlo2 : this.jmz) {
            float f2 = WatermarkWidget.jof(jlo2);
            f = Math.max(f, l - jlo2.at < 1700L ? f2 : f2 * jlo2.shown.get());
        }
        return f;
    }

    private float joh() {
        float f = 0.0f;
        for (jlo jlo2 : this.jmz) {
            f += jlo2.shown.get();
        }
        return Math.max(17.0f, 8.0f + f * 12.0f);
    }

    private void joi(class_332 class_3322, float f, float f2) {
        float f3;
        long l = System.currentTimeMillis();
        float f4 = this.jog(l);
        float f5 = (f - f4) * 0.5f + 11.0f;
        float f6 = (f2 - this.joh()) * 0.5f + 4.0f;
        float f7 = Easing.clamp01(1.0f - Math.max(0.0f, f4 - f) / 6.0f);
        float f8 = Hud.HEAD.capHeight() * 0.5f + 1.5f;
        int n = Theme.accent();
        long l2 = 0L;
        for (jlo jlo2 : this.jmz) {
            float f9;
            float f10;
            l2 = Math.max(l2, jlo2.at);
            f3 = jlo2.shown.get();
            float f11 = f6 + 12.0f * f3 * 0.5f;
            f6 += 12.0f * f3;
            if (f3 <= 0.01f || (f10 = f7 * Easing.clamp01(1.0f - Math.max(0.0f, f9 = Math.max(2.5f - (f11 - f8), f11 + f8 - (f2 - 2.5f))) / 3.0f)) <= 0.01f) continue;
            float f12 = Easing.outCubic(f3);
            DrawUtil.pushAlpha(Math.min(1.0f, f3 * 1.4f) * f10);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(0.0f, (1.0f - f12) * 3.0f);
            float f13 = Easing.clamp01(jlo2.flip.get());
            float f14 = Easing.outBack(Easing.clamp01((float)(l - jlo2.at) / 320.0f));
            float f15 = f5 + 2.3f;
            if (f13 > 0.01f) {
                DrawUtil.circle(class_3322, f15, f11, 2.3f * (1.6f + 0.5f * f14), ColorUtil.withAlpha(n, Math.round(46.0f * f13)));
            }
            DrawUtil.circle(class_3322, f15, f11, 2.3f * Math.max(0.2f, f14), ColorUtil.lerp(Theme.textMuted, n, f13));
            float f16 = f5 + 4.6f + 5.5f;
            f16 = Hud.HEAD.draw(class_3322, jlo2.name, f16, Hud.HEAD.centerTop(f11), Theme.text) + 5.0f;
            Hud.VALUE.draw(class_3322, jlo2.state, f16, Hud.VALUE.centerTop(f11), ColorUtil.lerp(Theme.textMuted, n, f13));
            class_3322.method_51448().popMatrix();
            DrawUtil.popAlpha();
        }
        float f17 = 1.0f - Easing.clamp01((float)(l - l2) / 1700.0f);
        if (l2 > 0L && f17 > 0.0f) {
            float f18 = Math.min(f2 * 0.5f, Theme.r(11.0f));
            f3 = (f - f18 * 2.0f) * f17;
            DrawUtil.round(class_3322, (f - f3) * 0.5f, f2 - 1.6f, f3, 0.8f, 0.4f, ColorUtil.withAlpha(n, 110));
        }
    }

    private void joj(class_332 class_3322, float f, float f2, float f3) {
        float f4;
        float f5;
        jgd jgd2 = this.jna;
        if (jgd2 == null) {
            return;
        }
        float f6 = (f - 200.0f) * 0.5f;
        float f7 = (f2 - 44.0f) * 0.5f;
        float f8 = f6 + 7.0f;
        float f9 = f7 + 7.0f;
        float f10 = Math.min(15.0f, Theme.r(6.0f));
        GpuTexture uok2 = this.jnc;
        float f11 = 0.9f + 0.1f * Easing.outCubic(this.jnd.get());
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f8 + 15.0f, f9 + 15.0f);
        class_3322.method_51448().scale(f11, f11);
        DrawUtil.shadow(class_3322, -15.0f, -13.5f, 30.0f, 30.0f, f10, 5.0f, 0x70000000);
        if (uok2 != null) {
            DrawUtil.image(class_3322, uok2.view, -15.0f, -15.0f, 30.0f, 30.0f, f10, -1);
        } else {
            DrawUtil.round(class_3322, -15.0f, -15.0f, 30.0f, 30.0f, f10, Theme.field);
            IconRenderer.draw(class_3322, Icon.MUSIC, 0.0f, 0.0f, 13.0f, Theme.textDim);
        }
        DrawUtil.outlineGradientV(class_3322, -15.0f, -15.0f, 30.0f, 30.0f, f10, 1.0f, 0x30FFFFFF, 0x8FFFFFF);
        class_3322.method_51448().popMatrix();
        float f12 = f8 + 30.0f + 8.0f;
        float f13 = f6 + 200.0f - 8.0f;
        boolean bl = Hud.pointer();
        float f14 = bl ? 40.0f : 17.0f;
        float f15 = f13 - f14 - 6.0f;
        WatermarkWidget.jok(class_3322, Hud.TITLE, jgd2.title(), f12, f7 + 12.0f, f15 - f12, Theme.text);
        String string = jgd2.artist().isEmpty() ? jgd2.source() : jgd2.artist() + "  ·  " + jgd2.source();
        Hud.SUB.draw(class_3322, Hud.SUB.ellipsize(string, f15 - f12), f12, Hud.SUB.centerTop(f7 + 22.0f), Theme.textDim);
        float f16 = f7 + 34.0f;
        float f17 = jgd2.progress();
        String string2 = WatermarkWidget.jol(jgd2.position());
        String string3 = jgd2.duration() > 0L ? WatermarkWidget.jol(jgd2.duration()) : "";
        float f18 = Hud.SMALL.width(string2);
        Hud.SMALL.draw(class_3322, string2, f12, Hud.SMALL.centerTop(f16), Theme.textMuted);
        if (!string3.isEmpty()) {
            Hud.SMALL.drawRight(class_3322, string3, f13, Hud.SMALL.centerTop(f16), Theme.textMuted);
            f5 = f12 + f18 + 5.0f;
            float f19 = f13 - Hud.SMALL.width(string3) - 5.0f - f5;
            TimedWidget.bar(class_3322, f5, f16 - 0.75f, f19, f17, Theme.accent(), Theme.accent2());
            if (f17 >= 0.0f) {
                f4 = f5 + f19 * f17;
                DrawUtil.shadow(class_3322, f4 - 2.0f, f16 - 1.6f, 4.0f, 4.0f, 2.0f, 1.5f, Integer.MIN_VALUE);
                DrawUtil.circle(class_3322, f4, f16, 2.0f, -1);
            }
        }
        if (bl) {
            f5 = f7 + 17.0f;
            this.jni = f5 - 6.0f;
            Icon[] vhzArray = new Icon[]{Icon.PREV, jgd2.playing() ? Icon.PAUSE : Icon.PLAY, Icon.NEXT};
            f4 = Hud.localMouseX(this);
            float f20 = Hud.localMouseY(this);
            for (int i = 0; i < 3; ++i) {
                boolean bl2;
                float f21;
                this.jnh[i] = f21 = f13 - 12.0f * (float)(3 - i) - 2.0f * (float)(2 - i);
                float f22 = this.jnf[i].step(f4 >= f21 && f4 < f21 + 12.0f && f20 >= this.jni && f20 < this.jni + 12.0f, f3);
                float f23 = 1.0f - 0.12f * this.jng[i].get();
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f21 + 6.0f, f5);
                class_3322.method_51448().scale(f23, f23);
                boolean bl3 = bl2 = i == 1;
                if (bl2) {
                    DrawUtil.shadow(class_3322, -6.0f, -5.2f, 12.0f, 12.0f, 6.0f, 2.0f, 0x70000000);
                    DrawUtil.circle(class_3322, 0.0f, 0.0f, 6.0f, ColorUtil.lerp(Theme.accent(), -1, 0.12f * f22));
                } else if (f22 > 0.01f) {
                    DrawUtil.circle(class_3322, 0.0f, 0.0f, 6.0f, ColorUtil.withAlpha(Theme.hover, Math.min(255, Math.round((float)ColorUtil.alpha(Theme.hover) * 3.0f * f22))));
                }
                IconRenderer.draw(class_3322, vhzArray[i], bl2 && !jgd2.playing() ? 0.6f : 0.0f, 0.0f, bl2 ? 6.5f : 7.0f, bl2 ? Theme.onAccent() : ColorUtil.lerp(Theme.textDim, Theme.text, f22));
                class_3322.method_51448().popMatrix();
            }
        } else {
            this.jni = -100.0f;
            this.jod(class_3322, f13 - 6.0f - 3.6000001f, f7 + 17.0f, 4, 12.0f);
        }
    }

    private static void jok(class_332 class_3322, FontFace vdn2, String string, float f, float f2, float f3, int n) {
        float f4 = vdn2.width(string);
        float f5 = vdn2.centerTop(f2);
        if (f4 <= f3) {
            vdn2.draw(class_3322, string, f, f5, n);
            return;
        }
        float f6 = 24.0f;
        float f7 = 18.0f;
        float f8 = 1.6f;
        float f9 = (f4 + f6) / f7 + f8;
        float f10 = (float)((double)System.nanoTime() / 1.0E9 % (double)f9);
        float f11 = Math.max(0.0f, f10 - f8) * f7;
        DrawUtil.pushScissor(class_3322, f, f5 - 2.0f, f3, vdn2.height() + 4.0f);
        vdn2.draw(class_3322, string, f - f11, f5, n);
        vdn2.draw(class_3322, string, f - f11 + f4 + f6, f5, n);
        DrawUtil.popScissor(class_3322);
    }

    private static String jol(long l) {
        return FormatUtil.clock(Math.max(0L, l / 1000L));
    }

    @Override
    boolean mouseClicked(float f, float f2, int n) {
        if (n != 0 || this.jmp != jlr.MUSIC || this.jni < -50.0f || f2 < this.jni || f2 >= this.jni + 12.0f) {
            return false;
        }
        String[] stringArray = new String[]{"prev", "toggle", "next"};
        for (int i = 0; i < 3; ++i) {
            if (!(f >= this.jnh[i]) || !(f < this.jnh[i] + 12.0f)) continue;
            this.jng[i].set(1.0f);
            NowPlaying.command(stringArray[i]);
            return true;
        }
        return false;
    }

    static {
        jml = "Preview";
        FPS = new BoolSetting("FPS", true);
        PING = new BoolSetting("Ping", true);
        TPS = new BoolSetting("TPS", true);
        BPS = new BoolSetting("BPS", true);
        COORDS = new BoolSetting("Coordinates", true);
        TIME = new BoolSetting("Time", false);
        ACCOUNT = new BoolSetting("Account", true);
        ALERTS = new BoolSetting("Toggle alerts", true);
        ISLAND = List.of(ACCOUNT, FPS, PING, TPS, BPS, COORDS, TIME, ALERTS);
        MUSIC = new BoolSetting("Music", true);
        VIEW = new ModeSetting("View", "Compact", "Compact", "Full");
        EXPAND = new BoolSetting("Expand on new track", true);
        COVER = new BoolSetting("Cover", true);
        MUSIC_SETTINGS = List.of(VIEW, EXPAND, COVER);
    }

    private static /* synthetic */ int aox(int n, int n2) {
        return n + n2 | 0xFC77DC4B;
    }

    private static /* synthetic */ int aoy(int n, int n2) {
        return WatermarkWidget.aox(n, n2) * n2;
    }

    private static /* synthetic */ int aoz(int n, int n2) {
        return WatermarkWidget.aoy(n, n2) + n;
    }
}

