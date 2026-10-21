/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.LiquidGlass;
import a.iog;
import a.iom;
import a.WallpaperManager;
import a.ColorUtil;
import a.GlassDraw;
import a.FrameDelta;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.Lang;
import flow.dev.StringDecryptor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public final class Theme {
    static final int WINDOW = 0;
    static final int PANEL = 1;
    static final int CARD = 2;
    static final int CARD_HOVER = 3;
    static final int STROKE = 4;
    static final int FIELD = 5;
    static final int FIELD_HOVER = 6;
    static final int TRACK = 7;
    static final int TEXT = 8;
    static final int TEXT_DIM = 9;
    static final int TEXT_MUTED = 10;
    static final int DIVIDER = 11;
    static final int SHADOW = 12;
    static final int KNOB = 13;
    static final int HOVER = 14;
    static final int SLOTS = 15;
    static final int ACCENT_SLOT = 15;
    static final int ACCENT2_SLOT = 16;
    static final int PAINT_SLOTS = 17;
    private static final String[] iow;
    static final String DARK;
    static final String COLOUR;
    static final String LIGHT;
    static final String GLASS;
    static final String CUSTOM;
    static final String FLOW;
    static final String FLOW_BLACK;
    static final String FLOW_WHITE;
    private static final int[] iox;
    private static final int[] ioy;
    static final iom[] PRESETS;
    public static final ModeSetting PRESET;
    public static final NumberSetting BG_HUE;
    public static final NumberSetting BG_SATURATION;
    public static final NumberSetting BG_BRIGHTNESS;
    public static final NumberSetting OPACITY;
    public static final NumberSetting CONTRAST;
    static final List<Setting> CUSTOM_SLIDERS;
    static final ModeSetting PAINT;
    static final iog[] MENU_PAINTS;
    static final iog[] HUD_PAINTS;
    private static final int[] ioz;
    private static final boolean[] ipa;
    private static final int[] ipb;
    private static final boolean[] ipc;
    private static int ipd;
    private static final String[] ipe;
    private static final int[][] ipf;
    public static final ModeSetting ACCENT;
    public static final BoolSetting GRADIENT;
    public static final NumberSetting HUE;
    public static final NumberSetting SATURATION;
    public static final NumberSetting BRIGHTNESS;
    public static final ModeSetting STYLE;
    public static final NumberSetting SCALE;
    public static final NumberSetting ROUNDNESS;
    public static final NumberSetting ANIMATION;
    public static final NumberSetting BG_BLUR;
    public static final NumberSetting DIM;
    static final List<Setting> INTERFACE;
    static final List<Setting> ALL;
    public static int window;
    public static int panel;
    public static int card;
    public static int cardHover;
    public static int stroke;
    public static int field;
    public static int fieldHover;
    public static int track;
    public static int text;
    public static int textDim;
    public static int textMuted;
    public static int divider;
    public static int shadow;
    public static int knob;
    public static int hover;
    private static final int[] ipg;
    private static float iph;
    private static float ipi;
    private static float ipj;
    private static int ipk;
    private static int ipl;
    private static int ipm;
    private static float ipn;
    private static final float[] ipo;
    private static String ipp;
    private static long ipq;
    private static long ipr;
    private static iom ips;
    private static long ipt;
    private static final int[] ipu;
    private static float ipv;
    private static boolean ipw;
    private static final float ipx = 0.3f;
    private static /* synthetic */ String ipy;
    private static /* synthetic */ boolean ipz;

    private Theme() {
    }

    private static String[] iqa() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (iom iom2 : PRESETS) {
            arrayList.add(iom2.ion);
        }
        arrayList.add("Custom");
        return arrayList.toArray(new String[0]);
    }

    private static int[] iqb(int n, int n2, float f) {
        int n3 = ColorUtil.lerp(n2, -1, 0.8f);
        int n4 = ColorUtil.lerp(-1, n2, 0.08f);
        return new int[]{n, 0x30000000, ColorUtil.withAlpha(ColorUtil.lerp(n, n3, 0.035f * f), 230), ColorUtil.withAlpha(ColorUtil.lerp(n, n3, 0.055f * f), 235), ColorUtil.lerp(n, n3, 0.1f * f), ColorUtil.lerp(n, n3, 0.055f * f), ColorUtil.lerp(n, n3, 0.08f * f), ColorUtil.lerp(n, n3, 0.12f * f), n4, ColorUtil.lerp(n4, n, 0.36f), ColorUtil.lerp(n4, n, 0.6f), ColorUtil.withAlpha(n3, 20), -1610612736, ColorUtil.lerp(n4, n, 0.42f), ColorUtil.withAlpha(n3, 10)};
    }

    private static int[] iqc(int n, int n2, float f) {
        int n3 = ColorUtil.lerp(-15395301, n2, 0.14f);
        int n4 = ColorUtil.lerp(-16777216, n2, 0.2f);
        return new int[]{n, 0x9000000, ColorUtil.withAlpha(ColorUtil.lerp(n, -1, 0.7f), 245), ColorUtil.withAlpha(ColorUtil.lerp(n, -1, 0.85f), 250), ColorUtil.lerp(n, n4, 0.09f * f), ColorUtil.lerp(n, n4, 0.025f * f), ColorUtil.lerp(n, n4, 0.05f * f), ColorUtil.lerp(n, n4, 0.1f * f), n3, ColorUtil.lerp(n3, n, 0.4f), ColorUtil.lerp(n3, n, 0.62f), ColorUtil.withAlpha(n4, 18), 0x38000000, -1, ColorUtil.withAlpha(n4, 8)};
    }

    private static int[] iqd(int n, int n2, float f) {
        int n3 = ColorUtil.lerp(-1, ColorUtil.shade(n2, 0.8f), 0.55f);
        return new int[]{n, 0x14000000, ColorUtil.withAlpha(n2, Math.round(26.0f * f)), ColorUtil.withAlpha(n2, Math.round(36.0f * f)), ColorUtil.withAlpha(n2, Math.round(46.0f * f)), ColorUtil.withAlpha(n2, Math.round(31.0f * f)), ColorUtil.withAlpha(n2, Math.round(43.0f * f)), ColorUtil.withAlpha(n2, Math.round(51.0f * f)), -1, ColorUtil.lerp(-1, n2, 0.25f), n3, ColorUtil.withAlpha(n2, 34), 0x50000000, ColorUtil.lerp(-1, n2, 0.3f), ColorUtil.withAlpha(n2, 20)};
    }

    private static int[] iqe(int n, int n2, float f) {
        int n3 = ColorUtil.lerp(-15724266, n2, 0.14f);
        return new int[]{n, 0xCFFFFFF, ColorUtil.withAlpha(-1, Math.round(112.0f * Math.min(1.4f, f))), ColorUtil.withAlpha(-1, Math.round(140.0f * Math.min(1.4f, f))), ColorUtil.withAlpha(-16777216, Math.round(28.0f * f)), ColorUtil.withAlpha(-1, Math.round(92.0f * Math.min(1.4f, f))), ColorUtil.withAlpha(-1, Math.round(128.0f * Math.min(1.4f, f))), ColorUtil.withAlpha(-16777216, Math.round(38.0f * f)), n3, ColorUtil.lerp(n3, n, 0.3f), ColorUtil.lerp(n3, n, 0.52f), 0x16000000, 0x30000000, -1, 0x10000000};
    }

    private static iom iqf(String string, String string2, int n, int n2, int n3, int n4) {
        return new iom(string, string2, Theme.iqb(n, n2, 1.0f), 1.0f, false, new int[]{n3, n4});
    }

    private static iom iqg(String string, int n, int n2, int n3, int n4, int n5, int n6) {
        int[] nArray = (int[])Theme.iqb(n3, n5, 1.0f).clone();
        nArray[2] = ColorUtil.withAlpha(n2, 230);
        nArray[3] = ColorUtil.withAlpha(n, 235);
        nArray[5] = ColorUtil.lerp(n2, n, 0.35f);
        nArray[6] = ColorUtil.lerp(n2, n, 0.75f);
        nArray[4] = ColorUtil.lerp(n, n5, 0.18f);
        nArray[7] = ColorUtil.lerp(n, n5, 0.14f);
        nArray[12] = ColorUtil.withAlpha(n4, 176);
        return new iom(string, "Colour", nArray, 1.0f, false, new int[]{n5, n6});
    }

    static iom custom() {
        int[] nArray;
        int[] nArray2;
        int n;
        boolean bl;
        long l = Double.doubleToLongBits(BG_HUE.get()) * 31L + Double.doubleToLongBits(BG_SATURATION.get());
        l = l * 31L + Double.doubleToLongBits(BG_BRIGHTNESS.get());
        l = l * 31L + Double.doubleToLongBits(OPACITY.get());
        l = l * 31L + Double.doubleToLongBits(CONTRAST.get());
        l = l * 31L + (long)ipd;
        if (ips != null && l == ipr) {
            return ips;
        }
        ipr = l;
        float f = (float)BG_HUE.get();
        float f2 = (float)BG_SATURATION.get();
        float f3 = (float)BG_BRIGHTNESS.get();
        float f4 = (float)CONTRAST.get();
        float f5 = (float)OPACITY.get();
        int n2 = ColorUtil.hsv(f, f2, f3);
        boolean bl2 = ColorUtil.luminance(n2) > 0.55f;
        boolean bl3 = bl = f5 < 0.9f;
        if (bl2) {
            n = ColorUtil.hsv(f, Math.max(0.45f, f2), 0.55f);
            nArray2 = bl ? Theme.iqe(n2, n, f4) : Theme.iqc(n2, n, f4);
            nArray = new int[]{ColorUtil.hsv(f, Math.max(0.55f, f2), 0.72f), ColorUtil.hsv(f, Math.max(0.4f, f2 * 0.8f), 0.85f)};
        } else {
            int[] nArray3;
            n = ColorUtil.hsv(f, Math.min(1.0f, 0.25f + f2 * 0.6f), 1.0f);
            int[] nArray4 = nArray2 = bl ? Theme.iqd(n2, n, f4) : Theme.iqb(n2, n, f4);
            if (f2 < 0.08f) {
                nArray3 = iox;
            } else {
                int[] nArray5 = new int[2];
                nArray5[0] = ColorUtil.hsv(f, Math.min(1.0f, 0.35f + f2 * 0.5f), 0.95f);
                nArray3 = nArray5;
                nArray5[1] = ColorUtil.hsv(f + 0.06f, Math.min(1.0f, 0.25f + f2 * 0.4f), 1.0f);
            }
            nArray = nArray3;
        }
        nArray2 = (int[])nArray2.clone();
        for (n = 1; n < 15; ++n) {
            if (!ipa[n]) continue;
            nArray2[n] = ioz[n];
        }
        if (ipa[15] || ipa[16]) {
            int n3 = n = ipa[15] ? ioz[15] : nArray[0];
            int n4 = ipa[16] ? ioz[16] : (ipa[15] ? ColorUtil.lerp(n, -1, 0.3f) : nArray[1]);
            nArray = new int[]{n, n4};
        }
        ips = new iom("Custom", "Custom", nArray2, bl ? f5 : 1.0f, bl2, nArray);
        return ips;
    }

    static void customFromCurrent() {
        iom iom2 = Theme.preset();
        int[] nArray = Theme.accentPair(ACCENT.index(), iom2);
        int n = iom2.color(0);
        float[] fArray = Color.RGBtoHSB(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, null);
        int[] nArray2 = (int[])iom2.iop.clone();
        BG_HUE.set(fArray[0]);
        BG_SATURATION.set(fArray[1]);
        BG_BRIGHTNESS.set(fArray[2]);
        OPACITY.set(Math.max(0.3, Math.min(1.0, (double)iom2.tintScale())));
        CONTRAST.reset();
        for (int i = 1; i < 15; ++i) {
            Theme.ioz[i] = nArray2[i];
            Theme.ipa[i] = true;
        }
        Theme.ioz[15] = nArray[0];
        Theme.ioz[16] = nArray[1];
        Theme.ipa[15] = true;
        Theme.ipa[16] = true;
        ++ipd;
        ACCENT.set("Auto");
        PRESET.set("Custom");
    }

    static void resetCustom() {
        if (PAINT.is("HUD")) {
            Arrays.fill(ipc, false);
        } else {
            BG_HUE.reset();
            BG_SATURATION.reset();
            BG_BRIGHTNESS.reset();
            OPACITY.reset();
            CONTRAST.reset();
            Arrays.fill(ipa, false);
        }
        ++ipd;
    }

    static boolean isPainted(iog iog2) {
        if (!iog2.hud() && iog2.slot() == 0) {
            return true;
        }
        return (iog2.hud() ? ipc : ipa)[iog2.slot()];
    }

    static int paintColor(iog iog2) {
        if (iog2.hud() && ipc[iog2.slot()]) {
            return ipb[iog2.slot()];
        }
        if (iog2.hud() && iog2.slot() == 16 && ipc[15]) {
            return ColorUtil.lerp(ipb[15], -1, 0.3f);
        }
        iom iom2 = Theme.custom();
        return switch (iog2.slot()) {
            case 15 -> iom2.accent()[0];
            case 16 -> iom2.accent()[1];
            default -> iom2.color(iog2.slot());
        };
    }

    static void setPaint(iog iog2, int n, float f, float f2, float f3) {
        if (!iog2.hasAlpha()) {
            n |= 0xFF000000;
        }
        if (!iog2.hud() && iog2.slot() == 0) {
            BG_HUE.set(f);
            BG_SATURATION.set(f2);
            BG_BRIGHTNESS.set(f3);
        } else if (iog2.hud()) {
            Theme.ipb[iog2.slot()] = n;
            Theme.ipc[iog2.slot()] = true;
        } else {
            Theme.ioz[iog2.slot()] = n;
            Theme.ipa[iog2.slot()] = true;
        }
        if (iog2.slot() == 15 || iog2.slot() == 16) {
            ACCENT.set("Auto");
        }
        ++ipd;
    }

    static void clearPaint(iog iog2) {
        if (!iog2.hud() && iog2.slot() == 0) {
            BG_HUE.reset();
            BG_SATURATION.reset();
            BG_BRIGHTNESS.reset();
        } else {
            (iog2.hud() ? Theme.ipc : Theme.ipa)[iog2.slot()] = false;
        }
        ++ipd;
    }

    public static void saveColors(Properties properties) {
        for (int i = 0; i < 17; ++i) {
            if (ipa[i]) {
                properties.setProperty("theme.color.menu." + iow[i], Theme.iqh(ioz[i]));
            }
            if (!ipc[i]) continue;
            properties.setProperty("theme.color.hud." + iow[i], Theme.iqh(ipb[i]));
        }
    }

    public static void loadColors(Properties properties) {
        for (int i = 0; i < 17; ++i) {
            Integer n = Theme.iqi(properties.getProperty("theme.color.menu." + iow[i]));
            Theme.ipa[i] = n != null && i != 0;
            Theme.ioz[i] = n != null ? n : 0;
            Integer n2 = Theme.iqi(properties.getProperty("theme.color.hud." + iow[i]));
            Theme.ipc[i] = n2 != null;
            Theme.ipb[i] = n2 != null ? n2 : 0;
        }
        ++ipd;
    }

    private static String iqh(int n) {
        return String.format(Locale.ROOT, "%08X", n);
    }

    private static Integer iqi(String string) {
        if (string == null) {
            return null;
        }
        try {
            return (int)Long.parseLong(string.trim().replace("#", ""), 16);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public static void beginHud() {
        int n;
        if (ipw || ipv <= 0.002f) {
            return;
        }
        ipw = true;
        for (n = 0; n < 17; ++n) {
            Theme.ipu[n] = Theme.iqk(n);
            if (!ipc[n]) continue;
            Theme.iql(n, ColorUtil.lerp(ipu[n], ipb[n], ipv));
        }
        if (!ipc[16] && ipc[15]) {
            n = GRADIENT.get() ? ColorUtil.lerp(ipb[15], -1, 0.3f) : ipb[15];
            Theme.iql(16, ColorUtil.lerp(ipu[16], n, ipv));
        }
    }

    public static void endHud() {
        if (!ipw) {
            return;
        }
        ipw = false;
        for (int i = 0; i < 17; ++i) {
            Theme.iql(i, ipu[i]);
        }
    }

    private static boolean iqj() {
        for (boolean bl : ipc) {
            if (!bl) continue;
            return true;
        }
        return false;
    }

    private static int iqk(int n) {
        return switch (n) {
            case 15 -> ipk;
            case 16 -> ipl;
            default -> ipg[n];
        };
    }

    private static void iql(int n, int n2) {
        switch (n) {
            case 15: {
                ipk = n2;
                break;
            }
            case 16: {
                ipl = n2;
                break;
            }
            default: {
                Theme.ipg[n] = n2;
            }
        }
        Theme.iqn();
    }

    static iom preset() {
        if (PRESET.is("Custom")) {
            return Theme.custom();
        }
        int n = PRESET.index();
        return PRESETS[Math.max(0, Math.min(PRESETS.length - 1, n))];
    }

    public static void update(float f) {
        if (FrameDelta.frame() == ipq) {
            return;
        }
        ipq = FrameDelta.frame();
        GlassDraw.enabled = STYLE.is("Depth");
        Theme.iqm();
        float f2 = 1.0f - (float)Math.exp(-9.0f * f);
        iom iom2 = Theme.preset();
        for (int i = 0; i < 15; ++i) {
            Theme.ipg[i] = ColorUtil.lerp(ipg[i], iom2.iop[i], f2);
        }
        iph += (iom2.ioq - iph) * f2;
        ipi += ((iom2.ior ? 1.0f : 0.0f) - ipi) * f2;
        float f3 = WallpaperManager.luminance();
        ipj += ((f3 >= 0.0f ? f3 : 0.4f) - ipj) * f2;
        int[] nArray = Theme.accentPair(ACCENT.index(), iom2);
        ipk = ColorUtil.lerp(ipk, nArray[0], f2);
        ipl = ColorUtil.lerp(ipl, GRADIENT.get() ? nArray[1] : nArray[0], f2);
        ipm = ColorUtil.lerp(ipm, iom2.accent()[0], f2);
        ipn = Color.RGBtoHSB(ipm >> 16 & 0xFF, ipm >> 8 & 0xFF, ipm & 0xFF, ipo)[1];
        ipv += ((PRESET.is("Custom") && Theme.iqj() ? 1.0f : 0.0f) - ipv) * f2;
        if (!iom2.ior) {
            ipp = iom2.ion;
        }
        Theme.iqn();
    }

    private static void iqm() {
        Theme.custom();
        if (ipt != Long.MIN_VALUE && ipt != ipr && !PRESET.is("Custom")) {
            PRESET.set("Custom");
        }
        ipt = ipr;
    }

    private static void iqn() {
        window = ipg[0];
        panel = ipg[1];
        card = ipg[2];
        cardHover = ipg[3];
        stroke = ipg[4];
        field = ipg[5];
        fieldHover = ipg[6];
        track = ipg[7];
        text = ipg[8];
        textDim = ipg[9];
        textMuted = ipg[10];
        divider = ipg[11];
        shadow = ipg[12];
        knob = ipg[13];
        hover = ipg[14];
    }

    /*
     * Exception decompiling
     */
    static int[] accentPair(int var0, iom var1_1) {
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

    static int[] customAccent() {
        float f = (float)HUE.get();
        float f2 = (float)SATURATION.get();
        float f3 = (float)BRIGHTNESS.get();
        return new int[]{ColorUtil.hsv(f, f2, f3), ColorUtil.hsv(f + 0.09f, Math.min(1.0f, f2 * 1.05f), f3)};
    }

    static void resetLook() {
        PRESET.reset();
        ACCENT.reset();
        GRADIENT.reset();
        STYLE.reset();
        ROUNDNESS.reset();
    }

    static void choose(String string) {
        PRESET.set(string);
        ACCENT.set("Auto");
        String string2 = Theme.wallpaperOf(string);
        if (string2 != null) {
            WallpaperManager.select(string2);
        }
    }

    /*
     * Exception decompiling
     */
    static String wallpaperOf(String var0) {
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

    static void toggleLight() {
        iom iom2 = Theme.preset();
        if (iom2.ion.equals("Flow Black") || iom2.ion.equals("Flow White")) {
            Theme.choose(iom2.ior ? "Flow Black" : "Flow White");
            return;
        }
        Theme.choose(iom2.ior ? ipp : (iom2.isGlass() ? "Mist" : "Frost"));
    }

    public static void cycle(int n) {
        if (n < 0) {
            PRESET.cyclePrev();
        } else {
            PRESET.cycle();
        }
        ACCENT.set("Auto");
    }

    public static String presetName() {
        return PRESET.get();
    }

    public static String shownName(String string) {
        return "Custom".equals(string) ? Lang.s("Custom", "Своя") : Lang.value(string);
    }

    public static boolean isLight() {
        return ipi > 0.5f;
    }

    public static float lightness() {
        return ipi;
    }

    public static float tintScale() {
        return iph;
    }

    public static float windowTint() {
        return Math.max(Math.min(1.0f, (float)LiquidGlass.TINT.get() * iph), Theme.iqo());
    }

    static float photoDarken() {
        return Math.max(Math.max((float)WallpaperManager.DARKEN.get(), 0.3f), Theme.iqo());
    }

    static int photoTone() {
        return ColorUtil.lerp(-1, ipm, (0.5f - 0.32f * ipi) * Math.min(1.0f, ipn * 1.4f));
    }

    public static int logoTint() {
        return ColorUtil.lerp(-1, ipk, 0.55f);
    }

    public static int tone() {
        return ipm;
    }

    public static int hudFill(float f) {
        float f2 = 1.0f - Math.max(0.0f, Math.min(1.0f, f));
        float f3 = ipc[0] ? 1.0f - ipv : 1.0f;
        int n = ipi > 0.5f ? ColorUtil.lerp(ipm, -1, 0.55f) : ColorUtil.shade(ipm, 0.5f);
        int n2 = ColorUtil.lerp(window, n, Math.min(0.75f, (0.25f + f2) * 0.85f) * ipn * f3);
        return ColorUtil.withAlpha(n2, Math.round(255.0f * Math.max(0.0f, Math.min(1.0f, f))));
    }

    public static int hudEdge() {
        int n = ColorUtil.lerp(stroke, ipm, 0.35f + 0.4f * ipn);
        return ColorUtil.withAlpha(n, Math.round(40.0f + 70.0f * ipn));
    }

    private static float iqo() {
        float f;
        float f2 = ColorUtil.luminance(window);
        if (ipi > 0.5f) {
            float f3 = 0.7f;
            f = f2 - ipj > 0.05f ? (f3 - ipj) / (f2 - ipj) : 0.0f;
        } else {
            float f4 = 0.34f;
            f = ipj - f2 > 0.05f ? (ipj - f4) / (ipj - f2) : 0.0f;
        }
        return Math.max(0.0f, Math.min(0.92f, f));
    }

    public static int accent() {
        return ipk;
    }

    public static int accent2() {
        return ipl;
    }

    public static int accent(int n) {
        return ColorUtil.withAlpha(ipk, n);
    }

    public static int onAccent() {
        return ColorUtil.luminance(ipk) > 0.62f ? -15592938 : -1;
    }

    public static float r(float f) {
        return f * (float)ROUNDNESS.get();
    }

    static {
        DARK = "Dark";
        COLOUR = "Colour";
        LIGHT = "Light";
        GLASS = "Light & glass";
        CUSTOM = "Custom";
        FLOW = "Flow";
        FLOW_BLACK = "Flow Black";
        FLOW_WHITE = "Flow White";
        iow = new String[]{"window", "panel", "card", "card-hover", "stroke", "field", "field-hover", "track", "text", "text-dim", "text-muted", "divider", "shadow", "knob", "hover", "accent", "accent2"};
        iox = new int[]{-1776408, -4934468};
        ioy = new int[]{-14474457, -10592666};
        PRESETS = new iom[]{new iom("Flow Black", "Flow", new int[]{-16448249, 0x26000000, -804582642, -636349930, 0x16FFFFFF, 0x14FFFFFF, 0x22FFFFFF, 0x30FFFFFF, -657672, -4736318, -8683639, 0x12FFFFFF, -1879048192, -1644308, 0xCFFFFFF}, 0.62f, false, iox), new iom("Flow White", "Flow", new int[]{-920847, 0x1EFFFFFF, -754974721, -520093697, 0x14000000, -2130706433, -1459617793, 0x24000000, -15658474, -12763063, -9670534, 0x12000000, 0x30000000, -1, 0xC000000}, 0.62f, true, ioy), new iom("Graphite", "Dark", new int[]{-15724526, 0x7FFFFFF, -15395561, -15132388, -14474457, -15132388, -14737629, -14145491, -1184273, -6579293, -10592666, 0xEFFFFFF, -1946157056, -7434601, 0x8FFFFFF}, 1.1f, false, iox), new iom("Obsidian", "Dark", new int[]{-16645629, 0xAFFFFFF, -267777524, -233959919, -15198180, -15658732, -15329766, -14869214, -1, -6184534, -10855837, 0x10FFFFFF, -1073741824, -7631979, 0xAFFFFFF}, 1.1f, false, iox), new iom("Midnight", "Dark", new int[]{-15987694, 0x33000000, -435023335, -350939875, -14803416, -15263969, -14935003, -14408658, -921098, -6513493, -10526868, 0x12FFFFFF, -1610612736, -7697768, 0xAFFFFFF}, 1.0f, false, new int[]{-7701008, -5660683}), Theme.iqf("Tokyo Night", "Dark", -15592676, -8740105, -8740105, -4482313), Theme.iqf("Rose Pine", "Dark", -15132892, -1327942, -1327942, -3889177), new iom("Frost", "Light & glass", new int[]{-723464, 0x9000000, -167772161, -83886081, -1907478, -1052428, -1578514, -2301978, -15395301, -10723474, -6644311, 0x12000000, 0x38000000, -1, 0x8000000}, 1.0f, true, ioy), new iom("Mist", "Light & glass", new int[]{-526084, 0xCFFFFFF, 0x70FFFFFF, -1929379841, 0x1C000000, 0x5CFFFFFF, -2130706433, 0x26000000, -15724266, -12828850, -9670784, 0x16000000, 0x30000000, -1, 0x10000000}, 0.55f, true, ioy), new iom("Crystal", "Light & glass", new int[]{-15856106, 0x14000000, 0x14FFFFFF, 0x1CFFFFFF, 0x22FFFFFF, 0x16FFFFFF, 0x22FFFFFF, 0x2AFFFFFF, -1, -2302746, -5197632, 0x1CFFFFFF, 0x60000000, -3618606, 0x10FFFFFF}, 0.5f, false, iox), Theme.iqg("Neon Blue", -15591116, -15986650, -16250340, -16579570, -13474576, -14795616), Theme.iqg("Crimson", -13364714, -14283760, -15071221, -15858939, -2347716, -7595741), Theme.iqg("Emerald", -15848164, -16113644, -16378355, -16578042, -14762401, -15566793), Theme.iqg("Sunset", -13165042, -14019574, -14807545, -15792381, -686296, -5286631), Theme.iqg("Violet", -14282700, -15070426, -15595750, -16186611, -5949461, -9887589), Theme.iqg("Arctic", -14931918, -15590364, -15986151, -16381683, -9192991, -12485211), Theme.iqg("Cyberpunk", -14152664, -14940130, -15596268, -16186870, -53816, -4973428), Theme.iqg("Ocean", -16114131, -16313310, -16511464, -16644340, -15425336, -15965049), Theme.iqg("Ice", -15457488, -15853276, -16183272, -16513012, -6234881, -10182456), Theme.iqg("Aurora", -16115421, -16313830, -16446446, -16644599, -14099296, -15100306), Theme.iqg("Aquamarine", -15981789, -16246760, -16445424, -16644088, -13765156, -15092576), Theme.iqg("Royal", -14479571, -15201762, -15727084, -16252150, -3628801, -7573816), new iom("White", "Light & glass", Theme.iqc(-1117962, -6129939, 1.0f), 1.0f, true, new int[]{-6129939, -7576872}), new iom("Glass", "Light & glass", Theme.iqd(-15987178, -8996097, 1.0f), 0.5f, false, new int[]{-8996097, -5731073})};
        PRESET = new ModeSetting("Theme", "Flow Black", Theme.iqa());
        BG_HUE = new NumberSetting("Background hue", 0.68, 0.0, 1.0, 0.0);
        BG_SATURATION = new NumberSetting("Background saturation", 0.35, 0.0, 1.0, 0.0);
        BG_BRIGHTNESS = new NumberSetting("Background brightness", 0.12, 0.0, 1.0, 0.0);
        OPACITY = new NumberSetting("Opacity", 1.0, 0.3, 1.0, 0.05).percent();
        CONTRAST = new NumberSetting("Contrast", 1.0, 0.5, 2.0, 0.05).percent();
        CUSTOM_SLIDERS = List.of(OPACITY, CONTRAST);
        PAINT = new ModeSetting("Colours of", "Menu", "Menu", "HUD");
        MENU_PAINTS = new iog[]{new iog("Window", 0, false), new iog("Sidebar", 1, false), new iog("Cards", 2, false), new iog("Cards on hover", 3, false), new iog("Borders", 4, false), new iog("Fields and buttons", 5, false), new iog("Fields on hover", 6, false), new iog("Switch track", 7, false), new iog("Switch knob", 13, false), new iog("Text", 8, false), new iog("Secondary text", 9, false), new iog("Muted text", 10, false), new iog("Dividers", 11, false), new iog("Hover", 14, false), new iog("Shadow", 12, false), new iog("Accent", 15, false), new iog("Accent 2", 16, false)};
        HUD_PAINTS = new iog[]{new iog("Background", 0, true), new iog("Text", 8, true), new iog("Secondary text", 9, true), new iog("Muted text", 10, true), new iog("Accent", 15, true), new iog("Accent 2", 16, true), new iog("Bars", 7, true), new iog("Fields", 5, true), new iog("Borders", 4, true), new iog("Dividers", 11, true), new iog("Switch knob", 13, true), new iog("Hover", 14, true)};
        ioz = new int[17];
        ipa = new boolean[17];
        ipb = new int[17];
        ipc = new boolean[17];
        ipe = new String[]{"Auto", "Mono", "Violet", "Ocean", "Sky", "Mint", "Lime", "Gold", "Sunset", "Crimson", "Rose", "Custom"};
        ipf = new int[][]{null, iox, {-7701008, -5660683}, {-11760144, -8803596}, {-13912621, -9974301}, {-13649535, -10695780}, {-7487681, -5516691}, {-2049990, -1389716}, {-1465797, -1000856}, {-1748149, -1147787}, {-1550470, -1146727}};
        ACCENT = new ModeSetting("Accent", "Mono", ipe);
        GRADIENT = new BoolSetting("Gradient", false);
        HUE = new NumberSetting("Hue", 0.72, 0.0, 1.0, 0.0);
        SATURATION = new NumberSetting("Saturation", 0.62, 0.0, 1.0, 0.0);
        BRIGHTNESS = new NumberSetting("Brightness", 0.97, 0.0, 1.0, 0.0);
        STYLE = new ModeSetting("Style", "Flat", "Flat", "Depth");
        SCALE = new NumberSetting("Scale", 1.0, 0.7, 1.3, 0.05).percent();
        ROUNDNESS = new NumberSetting("Roundness", 1.6, 0.0, 1.6, 0.05).percent();
        ANIMATION = new NumberSetting("Animations", 1.0, 0.5, 2.0, 0.1).unit("x");
        BG_BLUR = new NumberSetting("Blur world", 2.0, 0.0, 6.0, 1.0);
        DIM = new NumberSetting("Dim world", 0.35, 0.0, 0.9, 0.05).percent();
        INTERFACE = List.of(STYLE, SCALE, ROUNDNESS, ANIMATION, BG_BLUR, DIM);
        ALL = List.of(PRESET, ACCENT, GRADIENT, HUE, SATURATION, BRIGHTNESS, BG_HUE, BG_SATURATION, BG_BRIGHTNESS, OPACITY, CONTRAST, STYLE, SCALE, ROUNDNESS, ANIMATION, BG_BLUR, DIM);
        ipg = (int[])Theme.PRESETS[0].iop.clone();
        iph = 1.0f;
        ipj = 0.4f;
        ipk = iox[0];
        ipl = iox[0];
        ipm = iox[0];
        ipo = new float[3];
        ipp = "Graphite";
        ipq = -1L;
        ipr = Long.MIN_VALUE;
        ipt = Long.MIN_VALUE;
        Theme.iqn();
        ipu = new int[17];
    }

    private static /* synthetic */ int aiq(int n, int n2) {
        return n * n2 + 1257064521;
    }
}

