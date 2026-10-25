/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hyv;
import a.iog;
import a.iom;
import a.isv;
import a.ujt;
import a.ukf;
import a.unf;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import a.wap;
import flow.dev.a;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public final class iov {
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
    public static final vlv PRESET;
    public static final vmc BG_HUE;
    public static final vmc BG_SATURATION;
    public static final vmc BG_BRIGHTNESS;
    public static final vmc OPACITY;
    public static final vmc CONTRAST;
    static final List<vmo> CUSTOM_SLIDERS;
    static final vlv PAINT;
    static final iog[] MENU_PAINTS;
    static final iog[] HUD_PAINTS;
    private static final int[] ioz;
    private static final boolean[] ipa;
    private static final int[] ipb;
    private static final boolean[] ipc;
    private static int ipd;
    private static final String[] ipe;
    private static final int[][] ipf;
    public static final vlv ACCENT;
    public static final vkl GRADIENT;
    public static final vmc HUE;
    public static final vmc SATURATION;
    public static final vmc BRIGHTNESS;
    public static final vlv STYLE;
    public static final vmc SCALE;
    public static final vmc ROUNDNESS;
    public static final vmc ANIMATION;
    public static final vmc BG_BLUR;
    public static final vmc DIM;
    static final List<vmo> INTERFACE;
    static final List<vmo> ALL;
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

    private iov() {
    }

    private static String[] iqa() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (iom iom2 : PRESETS) {
            arrayList.add(iom2.ion);
        }
        arrayList.add(a.b("\u21ae\u5829\ud2fc\u4c8a\uc746\u41f5", 2089165291));
        return arrayList.toArray(new String[0]);
    }

    private static int[] iqb(int n, int n2, float f) {
        int n3 = ujt.lerp(n2, -1, 0.8f);
        int n4 = ujt.lerp(-1, n2, 0.08f);
        return new int[]{n, 0x30000000, ujt.withAlpha(ujt.lerp(n, n3, 0.035f * f), 230), ujt.withAlpha(ujt.lerp(n, n3, 0.055f * f), 235), ujt.lerp(n, n3, 0.1f * f), ujt.lerp(n, n3, 0.055f * f), ujt.lerp(n, n3, 0.08f * f), ujt.lerp(n, n3, 0.12f * f), n4, ujt.lerp(n4, n, 0.36f), ujt.lerp(n4, n, 0.6f), ujt.withAlpha(n3, 20), -1610612736, ujt.lerp(n4, n, 0.42f), ujt.withAlpha(n3, 10)};
    }

    private static int[] iqc(int n, int n2, float f) {
        int n3 = ujt.lerp(-15395301, n2, 0.14f);
        int n4 = ujt.lerp(-16777216, n2, 0.2f);
        return new int[]{n, 0x9000000, ujt.withAlpha(ujt.lerp(n, -1, 0.7f), 245), ujt.withAlpha(ujt.lerp(n, -1, 0.85f), 250), ujt.lerp(n, n4, 0.09f * f), ujt.lerp(n, n4, 0.025f * f), ujt.lerp(n, n4, 0.05f * f), ujt.lerp(n, n4, 0.1f * f), n3, ujt.lerp(n3, n, 0.4f), ujt.lerp(n3, n, 0.62f), ujt.withAlpha(n4, 18), 0x38000000, -1, ujt.withAlpha(n4, 8)};
    }

    private static int[] iqd(int n, int n2, float f) {
        int n3 = ujt.lerp(-1, ujt.shade(n2, 0.8f), 0.55f);
        return new int[]{n, 0x14000000, ujt.withAlpha(n2, Math.round(26.0f * f)), ujt.withAlpha(n2, Math.round(36.0f * f)), ujt.withAlpha(n2, Math.round(46.0f * f)), ujt.withAlpha(n2, Math.round(31.0f * f)), ujt.withAlpha(n2, Math.round(43.0f * f)), ujt.withAlpha(n2, Math.round(51.0f * f)), -1, ujt.lerp(-1, n2, 0.25f), n3, ujt.withAlpha(n2, 34), 0x50000000, ujt.lerp(-1, n2, 0.3f), ujt.withAlpha(n2, 20)};
    }

    private static int[] iqe(int n, int n2, float f) {
        int n3 = ujt.lerp(-15724266, n2, 0.14f);
        return new int[]{n, 0xCFFFFFF, ujt.withAlpha(-1, Math.round(112.0f * Math.min(1.4f, f))), ujt.withAlpha(-1, Math.round(140.0f * Math.min(1.4f, f))), ujt.withAlpha(-16777216, Math.round(28.0f * f)), ujt.withAlpha(-1, Math.round(92.0f * Math.min(1.4f, f))), ujt.withAlpha(-1, Math.round(128.0f * Math.min(1.4f, f))), ujt.withAlpha(-16777216, Math.round(38.0f * f)), n3, ujt.lerp(n3, n, 0.3f), ujt.lerp(n3, n, 0.52f), 0x16000000, 0x30000000, -1, 0x10000000};
    }

    private static iom iqf(String string, String string2, int n, int n2, int n3, int n4) {
        return new iom(string, string2, iov.iqb(n, n2, 1.0f), 1.0f, false, new int[]{n3, n4});
    }

    private static iom iqg(String string, int n, int n2, int n3, int n4, int n5, int n6) {
        int[] nArray = (int[])iov.iqb(n3, n5, 1.0f).clone();
        nArray[2] = ujt.withAlpha(n2, 230);
        nArray[3] = ujt.withAlpha(n, 235);
        nArray[5] = ujt.lerp(n2, n, 0.35f);
        nArray[6] = ujt.lerp(n2, n, 0.75f);
        nArray[4] = ujt.lerp(n, n5, 0.18f);
        nArray[7] = ujt.lerp(n, n5, 0.14f);
        nArray[12] = ujt.withAlpha(n4, 176);
        return new iom(string, a.d("\u9120\ue8bd\u626d\ufc1f\u77d2\uf164", -1735860766, -131052409), nArray, 1.0f, false, new int[]{n5, n6});
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
        int n2 = ujt.hsv(f, f2, f3);
        boolean bl2 = ujt.luminance(n2) > 0.55f;
        boolean bl3 = bl = f5 < 0.9f;
        if (bl2) {
            n = ujt.hsv(f, Math.max(0.45f, f2), 0.55f);
            nArray2 = bl ? iov.iqe(n2, n, f4) : iov.iqc(n2, n, f4);
            nArray = new int[]{ujt.hsv(f, Math.max(0.55f, f2), 0.72f), ujt.hsv(f, Math.max(0.4f, f2 * 0.8f), 0.85f)};
        } else {
            int[] nArray3;
            n = ujt.hsv(f, Math.min(1.0f, 0.25f + f2 * 0.6f), 1.0f);
            int[] nArray4 = nArray2 = bl ? iov.iqd(n2, n, f4) : iov.iqb(n2, n, f4);
            if (f2 < 0.08f) {
                nArray3 = iox;
            } else {
                int[] nArray5 = new int[2];
                nArray5[0] = ujt.hsv(f, Math.min(1.0f, 0.35f + f2 * 0.5f), 0.95f);
                nArray3 = nArray5;
                nArray5[1] = ujt.hsv(f + 0.06f, Math.min(1.0f, 0.25f + f2 * 0.4f), 1.0f);
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
            int n4 = ipa[16] ? ioz[16] : (ipa[15] ? ujt.lerp(n, -1, 0.3f) : nArray[1]);
            nArray = new int[]{n, n4};
        }
        ips = new iom(a.c(-281498519, "\uac2c\ud5ab\u5f7e\uc108\u4ac4\ucc77"), a.b("\uf7e3\u8e64\u04b1\u9ac7\u110b\u97b8", 102496166), nArray2, bl ? f5 : 1.0f, bl2, nArray);
        return ips;
    }

    static void customFromCurrent() {
        iom iom2 = iov.preset();
        int[] nArray = iov.accentPair(ACCENT.index(), iom2);
        int n = iom2.color(0);
        float[] fArray = Color.RGBtoHSB(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, null);
        int[] nArray2 = (int[])iom2.iop.clone();
        BG_HUE.set(fArray[0]);
        BG_SATURATION.set(fArray[1]);
        BG_BRIGHTNESS.set(fArray[2]);
        OPACITY.set(Math.max(0.3, Math.min(1.0, (double)iom2.tintScale())));
        CONTRAST.reset();
        for (int i = 1; i < 15; ++i) {
            iov.ioz[i] = nArray2[i];
            iov.ipa[i] = true;
        }
        iov.ioz[15] = nArray[0];
        iov.ioz[16] = nArray[1];
        iov.ipa[15] = true;
        iov.ipa[16] = true;
        ++ipd;
        ACCENT.set(a.b("\u02ff\u7b7a\uf1a8\u6fc2", -2017983814));
        PRESET.set(a.d("\u9430\uedb7\u6762\uf914\u72d8\uf46b", -714454059, -1008803936));
    }

    static void resetCustom() {
        if (PAINT.is(a.c(-821768515, "\ucef6\ub75a\u3d98"))) {
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
            return ujt.lerp(ipb[15], -1, 0.3f);
        }
        iom iom2 = iov.custom();
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
            iov.ipb[iog2.slot()] = n;
            iov.ipc[iog2.slot()] = true;
        } else {
            iov.ioz[iog2.slot()] = n;
            iov.ipa[iog2.slot()] = true;
        }
        if (iog2.slot() == 15 || iog2.slot() == 16) {
            ACCENT.set(a.b("\u1963\u60e6\uea34\u745e", 1526143270));
        }
        ++ipd;
    }

    static void clearPaint(iog iog2) {
        if (!iog2.hud() && iog2.slot() == 0) {
            BG_HUE.reset();
            BG_SATURATION.reset();
            BG_BRIGHTNESS.reset();
        } else {
            (iog2.hud() ? iov.ipc : iov.ipa)[iog2.slot()] = false;
        }
        ++ipd;
    }

    public static void saveColors(Properties properties) {
        for (int i = 0; i < 17; ++i) {
            if (ipa[i]) {
                properties.setProperty(a.b("\u3078\u49d5\uc30b\u5d72\ud6ad\u5057\uea49\u63b4\ufde8\u775a\uf094\u0ab9\u842d\u1d94\u97cc\u1126\uab32", 355676189) + iow[i], iov.iqh(ioz[i]));
            }
            if (!ipc[i]) continue;
            properties.setProperty(a.c(2073085090, "\uc4c6\ubd6b\u37b5\ua9cc\u2213\ua4e9\u1ef7\u970a\u0956\u83e4\u042a\ufe07\u7096\ue93a\u6378\ue5c3") + iow[i], iov.iqh(ipb[i]));
        }
    }

    public static void loadColors(Properties properties) {
        for (int i = 0; i < 17; ++i) {
            Integer n = iov.iqi(properties.getProperty(a.d("\u8b87\uf22a\u78f4\ue68d\u6d52\ueba8\u51b6\ud84b\u4617\ucca5\u4b6b\ub146\u3fd2\ua66b\u2c33\uaad9\u10cd", -1578154029, -1860449231) + iow[i]));
            iov.ipa[i] = n != null && i != 0;
            iov.ioz[i] = n != null ? n : 0;
            Integer n2 = iov.iqi(properties.getProperty(a.b("\u5dba\u2417\uaec9\u30b0\ubb6f\u3d95\u878b\u0e76\u902a\u1a98\u9d56\u677b\ue9ea\u7046\ufa04\u7cbf", 1033788894) + iow[i]));
            iov.ipc[i] = n2 != null;
            iov.ipb[i] = n2 != null ? n2 : 0;
        }
        ++ipd;
    }

    private static String iqh(int n) {
        return String.format(Locale.ROOT, a.b("\u750f\u0cab\u8670\u1861", 1641641262), n);
    }

    private static Integer iqi(String string) {
        if (string == null) {
            return null;
        }
        try {
            return (int)Long.parseLong(string.trim().replace(a.b("\uba9b", -1746879815), ""), 16);
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
            iov.ipu[n] = iov.iqk(n);
            if (!ipc[n]) continue;
            iov.iql(n, ujt.lerp(ipu[n], ipb[n], ipv));
        }
        if (!ipc[16] && ipc[15]) {
            n = GRADIENT.get() ? ujt.lerp(ipb[15], -1, 0.3f) : ipb[15];
            iov.iql(16, ujt.lerp(ipu[16], n, ipv));
        }
    }

    public static void endHud() {
        if (!ipw) {
            return;
        }
        ipw = false;
        for (int i = 0; i < 17; ++i) {
            iov.iql(i, ipu[i]);
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
                iov.ipg[n] = n2;
            }
        }
        iov.iqn();
    }

    static iom preset() {
        if (PRESET.is(a.b("\u958a\uec0d\u66d8\uf8ae\u7362\uf5d1", 2012452303))) {
            return iov.custom();
        }
        int n = PRESET.index();
        return PRESETS[Math.max(0, Math.min(PRESETS.length - 1, n))];
    }

    public static void update(float f) {
        if (unf.frame() == ipq) {
            return;
        }
        ipq = unf.frame();
        ukf.enabled = STYLE.is(a.c(-1999928815, "\u8250\ufbc0\u7106\uef73\u64b8"));
        iov.iqm();
        float f2 = 1.0f - (float)Math.exp(-9.0f * f);
        iom iom2 = iov.preset();
        for (int i = 0; i < 15; ++i) {
            iov.ipg[i] = ujt.lerp(ipg[i], iom2.iop[i], f2);
        }
        iph += (iom2.ioq - iph) * f2;
        ipi += ((iom2.ior ? 1.0f : 0.0f) - ipi) * f2;
        float f3 = isv.luminance();
        ipj += ((f3 >= 0.0f ? f3 : 0.4f) - ipj) * f2;
        int[] nArray = iov.accentPair(ACCENT.index(), iom2);
        ipk = ujt.lerp(ipk, nArray[0], f2);
        ipl = ujt.lerp(ipl, GRADIENT.get() ? nArray[1] : nArray[0], f2);
        ipm = ujt.lerp(ipm, iom2.accent()[0], f2);
        ipn = Color.RGBtoHSB(ipm >> 16 & 0xFF, ipm >> 8 & 0xFF, ipm & 0xFF, ipo)[1];
        ipv += ((PRESET.is(a.d("\ue5f5\u9c72\u16a7\u88d1\u031d\u85ae", 1694597783, -143562969)) && iov.iqj() ? 1.0f : 0.0f) - ipv) * f2;
        if (!iom2.ior) {
            ipp = iom2.ion;
        }
        iov.iqn();
    }

    private static void iqm() {
        iov.custom();
        if (ipt != Long.MIN_VALUE && ipt != ipr && !PRESET.is(a.c(-188472272, "\u2475\u5df2\ud727\u4951\uc29d\u442e"))) {
            PRESET.set(a.c(1462290806, "\uc933\ub0b4\u3a61\ua417\u2fdb\ua968"));
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
        return new int[]{ujt.hsv(f, f2, f3), ujt.hsv(f + 0.09f, Math.min(1.0f, f2 * 1.05f), f3)};
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
        ACCENT.set(a.c(-1378833440, "\uaba5\ud220\u58f2\uc698"));
        String string2 = iov.wallpaperOf(string);
        if (string2 != null) {
            isv.select(string2);
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
        iom iom2 = iov.preset();
        if (iom2.ion.equals(a.b("\ue9c8\u9053\u1a83\u84ea\u0f6a\u89b9\u33c4\uba38\u2465\uaedc", -774968956)) || iom2.ion.equals(a.d("\ud285\uab1e\u21ce\ubfa7\u3427\ub2e1\u088d\u817d\u1f3f\u959f", 2019520762, -306863565))) {
            iov.choose(iom2.ior ? a.c(447449442, "\u892e\uf0b5\u7a65\ue40c\u6f8c\ue95f\u5322\udade\u4483\uce3a") : a.d("\u36e7\u4f7c\uc5ac\u5bc5\ud045\u5683\uecef\u651f\ufb5d\u71fd", -689530979, 365535542));
            return;
        }
        iov.choose(iom2.ior ? ipp : (iom2.isGlass() ? a.c(-686725162, "\u679f\u1e0a\u94c3\u0ab5") : a.c(-1403878507, "\u83d6\ufa53\u709d\ueef0\u6520")));
    }

    public static void cycle(int n) {
        if (n < 0) {
            PRESET.cyclePrev();
        } else {
            PRESET.cycle();
        }
        ACCENT.set(a.b("\u8342\ufac7\u7015\uee7f", -1971944697));
    }

    public static String presetName() {
        return PRESET.get();
    }

    public static String shownName(String string) {
        return a.d("\u206b\u59ec\ud339\u4d4f\uc683\u4030", 161933876, 487901722).equals(string) ? wap.s(a.c(927387966, "\ud17b\ua8fc\u2229\ubc5f\u3793\ub120"), a.b("\u6d8e\u142c\u9ef3\u00f3", -1110546005)) : wap.value(string);
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
        return Math.max(Math.min(1.0f, (float)hyv.TINT.get() * iph), iov.iqo());
    }

    static float photoDarken() {
        return Math.max(Math.max((float)isv.DARKEN.get(), 0.3f), iov.iqo());
    }

    static int photoTone() {
        return ujt.lerp(-1, ipm, (0.5f - 0.32f * ipi) * Math.min(1.0f, ipn * 1.4f));
    }

    public static int logoTint() {
        return ujt.lerp(-1, ipk, 0.55f);
    }

    public static int tone() {
        return ipm;
    }

    public static int hudFill(float f) {
        float f2 = 1.0f - Math.max(0.0f, Math.min(1.0f, f));
        float f3 = ipc[0] ? 1.0f - ipv : 1.0f;
        int n = ipi > 0.5f ? ujt.lerp(ipm, -1, 0.55f) : ujt.shade(ipm, 0.5f);
        int n2 = ujt.lerp(window, n, Math.min(0.75f, (0.25f + f2) * 0.85f) * ipn * f3);
        return ujt.withAlpha(n2, Math.round(255.0f * Math.max(0.0f, Math.min(1.0f, f))));
    }

    public static int hudEdge() {
        int n = ujt.lerp(stroke, ipm, 0.35f + 0.4f * ipn);
        return ujt.withAlpha(n, Math.round(40.0f + 70.0f * ipn));
    }

    private static float iqo() {
        float f;
        float f2 = ujt.luminance(window);
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
        return ujt.withAlpha(ipk, n);
    }

    public static int onAccent() {
        return ujt.luminance(ipk) > 0.62f ? -15592938 : -1;
    }

    public static float r(float f) {
        return f * (float)ROUNDNESS.get();
    }

    static {
        DARK = a.d("\u31c2\u4856\uc296\u5cfe", 1623371612, 1834393310);
        COLOUR = a.c(1400270455, "\u6e32\u17af\u9d7f\u030d\u88c0\u0e76");
        LIGHT = a.b("\u6730\u1ea4\u9479\u0a07\u81cc", 1226467193);
        GLASS = a.c(1076846111, "\u5e5e\u27ca\uad17\u3369\ub8a2\u3e47\u8412\u0de5\u93fd\u1947\u9e99\u64fa\uea2d");
        CUSTOM = a.c(615268176, "\u3f15\u4692\ucc47\u5231\ud9fd\u5f4e");
        FLOW = a.b("\ud47b\uade0\u2730\ub959", 510252089);
        FLOW_BLACK = a.b("\u9fb2\ue629\u6cf9\uf290\u7910\uffc3\u45be\ucc42\u521f\ud8a6", -1893294082);
        FLOW_WHITE = a.d("\u84de\ufd45\u7795\ue9fc\u627c\ue4ba\u5ed6\ud726\u4964\uc3c4", -1165763834, 894590868);
        iow = new String[]{a.c(1586193622, "\u64a7\u1d08\u97dc\u09a7\u827b\u04d2"), a.b("\u7a33\u0393\u894f\u1735\u9ceb", 1455782470), a.b("\u9b5c\ue2ef\u682f\uf648", -469918917), a.c(1903438107, "\u2972\u50c1\uda01\u4466\ucff8\u490c\uf358\u7ab0\ue4fc\u6e5a"), a.c(1267828288, "\u8635\uff83\u7556\ueb3a\u60e9\ue656"), a.d("\u82ec\ufb52\u718d\ueff5\u642a", 1330956161, 1650017550), a.c(-433458680, "\uf265\u8bdb\u0104\u9f7c\u14a3\u925b\u284d\ua1bb\u3ffd\ub55f\u329b"), a.c(-1143464188, "\u1f75\u66c2\uec02\u7271\uf9ae"), a.d("\u5a36\u2396\ua958\u3725", -1193356650, 227444944), a.d("\ua2c7\udb67\u51a9\ucfd4\u445a\uc2a2\u78fc\uf109", -716808222, 1480457561), a.c(436000554, "\ud754\uaef4\u243a\uba47\u31c9\ub738\u0d73\u8483\u1acd\u907d"), a.c(-385729018, "\u3e65\u47d9\ucd15\u537b\ud8a1\u5e11\ue455"), a.b("\u36d5\u4f7f\uc5a5\u5bd1\ud00d\u56a4", 364656288), a.c(813139734, "\u8779\ufecd\u741f\uea63"), a.c(732347432, "\ubc45\uc5f3\u4f39\ud15b\u5a9b"), a.d("\ud5ff\uac4c\u269f\ub8e8\u3334\ub59f", 1834840564, 1491969132), a.c(-177064732, "\u3482\u4d31\uc7e2\u5995\ud249\u54e2\ueef7")};
        iox = new int[]{-1776408, -4934468};
        ioy = new int[]{-14474457, -10592666};
        PRESETS = new iom[]{new iom(a.d("\u9447\ueddc\u670c\uf965\u72e5\uf436\u4e4b\uc7b7\u59ea\ud353", -922979740, 1865803375), a.c(586076975, "\ud36d\uaaf6\u2026\ube4f"), new int[]{-16448249, 0x26000000, -804582642, -636349930, 0x16FFFFFF, 0x14FFFFFF, 0x22FFFFFF, 0x30FFFFFF, -657672, -4736318, -8683639, 0x12FFFFFF, -1879048192, -1644308, 0xCFFFFFF}, 0.62f, false, iox), new iom(a.c(-855667923, "\u8b61\uf2fa\u782a\ue643\u6dc3\ueb05\u5169\ud899\u46db\ucc7b"), a.c(1996418554, "\uedb8\u9423\u1ef3\u809a"), new int[]{-920847, 0x1EFFFFFF, -754974721, -520093697, 0x14000000, -2130706433, -1459617793, 0x24000000, -15658474, -12763063, -9670534, 0x12000000, 0x30000000, -1, 0xC000000}, 0.62f, true, ioy), new iom(a.b("\u46ac\u3f28\ub5e8\u2b88\ua047\u26f7\u9cb9\u1559", 129386211), a.d("\u21cf\u585b\ud29b\u4cf3", -833387112, 344826903), new int[]{-15724526, 0x7FFFFFF, -15395561, -15132388, -14474457, -15132388, -14737629, -14145491, -1184273, -6579293, -10592666, 0xEFFFFFF, -1946157056, -7434601, 0x8FFFFFF}, 1.1f, false, iox), new iom(a.d("\u9e9f\ue703\u6dc1\uf3aa\u7870\ufecc\u4497\ucd69", -1860062689, 1551576263), a.c(510600156, "\u239c\u5a08\ud0c8\u4ea0"), new int[]{-16645629, 0xAFFFFFF, -267777524, -233959919, -15198180, -15658732, -15329766, -14869214, -1, -6184534, -10855837, 0x10FFFFFF, -1073741824, -7631979, 0xAFFFFFF}, 1.1f, false, iox), new iom(a.c(-1986076015, "\ue2d4\u9b41\u119f\u8fe4\u0434\u828b\u38d7\ub13a"), a.d("\uc3f9\uba6d\u30ad\uaec5", -1067886495, 1101831128), new int[]{-15987694, 0x33000000, -435023335, -350939875, -14803416, -15263969, -14935003, -14408658, -921098, -6513493, -10526868, 0x12FFFFFF, -1610612736, -7697768, 0xAFFFFFF}, 1.0f, false, new int[]{-7701008, -5660683}), iov.iqf(a.c(183951654, "\ue179\u98f3\u1224\u8c47\u0786\u8178\u3b45\ub293\u2cc2\ua67c\u21b3"), a.b("\u8e91\uf705\u7dc5\ue3ad", -1765044527), -15592676, -8740105, -8740105, -4482313), iov.iqf(a.c(-223700849, "\u98d4\ue158\u6b97\uf5f0\u7e62\uf8a3\u42c9\ucb3f\u556b"), a.c(1787803638, "\ub7b6\uce22\u44e2\uda8a"), -15132892, -1327942, -1327942, -3889177), new iom(a.c(408607464, "\udaab\ua32e\u29e0\ub78d\u3c5d"), a.b("\ucabd\ub329\u39f4\ua78a\u2c41\uaaa4\u10f1\u9906\u071e\u8da4\u0a7a\uf019\u7ece", -212743428), new int[]{-723464, 0x9000000, -167772161, -83886081, -1907478, -1052428, -1578514, -2301978, -15395301, -10723474, -6644311, 0x12000000, 0x38000000, -1, 0x8000000}, 1.0f, true, ioy), new iom(a.b("\u21f3\u5866\ud2af\u4cd9", 443818426), a.c(-1787783870, "\u9503\uec97\u664a\uf834\u73ff\uf51a\u4f4f\uc6b8\u58a0\ud21a\u55c4\uafa7\u2170"), new int[]{-526084, 0xCFFFFFF, 0x70FFFFFF, -1929379841, 0x1C000000, 0x5CFFFFFF, -2130706433, 0x26000000, -15724266, -12828850, -9670784, 0x16000000, 0x30000000, -1, 0x10000000}, 0.55f, true, ioy), new iom(a.b("\uf503\u8c83\u065b\u9820\u13f0\u9554\u2f0a", -1449396921), a.d("\uf6d8\u8f4c\u0591\u9bef\u1024\u96c1\u2c94\ua563\u3b7b\ub1c1\u361f\ucc7c\u42ab", -378422393, 1085099294), new int[]{-15856106, 0x14000000, 0x14FFFFFF, 0x1CFFFFFF, 0x22FFFFFF, 0x16FFFFFF, 0x22FFFFFF, 0x2AFFFFFF, -1, -2302746, -5197632, 0x1CFFFFFF, 0x60000000, -3618606, 0x10FFFFFF}, 0.5f, false, iox), iov.iqg(a.c(-1345956348, "\u5643\u2fd9\ua500\u3b70\ub0e9\u363a\u8c47\u05af\u9be0"), -15591116, -15986650, -16250340, -16579570, -13474576, -14795616), iov.iqg(a.c(-1209568808, "\u719c\u081c\u82d4\u1ca1\u9768\u11c5\uab97"), -13364714, -14283760, -15071221, -15858939, -2347716, -7595741), iov.iqg(a.b("\u6887\u111e\u9bc5\u05a3\u8e67\u08db\ub280", 697002181), -15848164, -16113644, -16378355, -16578042, -14762401, -15566793), iov.iqg(a.d("\u79edz\u8ab2\u14de\u9f1f\u19bf", -2035227739, -1362978275), -13165042, -14019574, -14807545, -15792381, -686296, -5286631), iov.iqg(a.c(1738884292, "\u4494\u3d1a\ub7cf\u29bd\ua263\u24c3"), -14282700, -15070426, -15595750, -16186611, -5949461, -9887589), iov.iqg(a.b("\uea04\u9386\u1944\u8722\u0ce8\u8a53", -1549931965), -14931918, -15590364, -15986151, -16381683, -9192991, -12485211), iov.iqg(a.c(-1724868928, "\u968a\uef01\u65c9\ufbbf\u707f\uf6cc\u4c9a\uc570\u5b2a"), -14152664, -14940130, -15596268, -16186870, -53816, -4973428), iov.iqg(a.d("\u34a6\u4d3b\uc7ee\u599b\ud243", 207710330, 1525832854), -16114131, -16313310, -16511464, -16644340, -15425336, -15965049), iov.iqg(a.b("\u3ae5\u437e\uc9ab", 1102199471), -15457488, -15853276, -16183272, -16513012, -6234881, -10182456), iov.iqg(a.b("\ue4ad\u9d28\u17fc\u8990\u025a\u84f8", 170386666), -16115421, -16313830, -16446446, -16644599, -14099296, -15100306), iov.iqg(a.c(-1065535113, "\u393c\u40bd\uca6a\u540f\udfd4\u5969\ue329\u6ac3\uf49b\u7e21"), -15981789, -16246760, -16445424, -16644088, -13765156, -15092576), iov.iqg(a.b("\u84c7\ufd4b\u778e\ue9e7\u623d", -96762736), -14479571, -15201762, -15727084, -16252150, -3628801, -7573816), new iom(a.b("\u0c79\u75f7\uff25\u6149\uea8f", -856028117), a.d("\u4dcf\u345b\ube86\u20f8\uab33\u2dd6\u9783\u1e74\u806c\u0ad6\u8d08\u776b\uf9bc", 1700595789, -796310077), iov.iqc(-1117962, -6129939, 1.0f), 1.0f, true, new int[]{-6129939, -7576872}), new iom(a.b("\u4bfa\u3260\ub8be\u26dd\uad0a", 1619938232), a.b("\uf1a0\u8834\u02e9\u9c97\u175c\u91b9\u2bec\ua21b\u3c03\ub6b9\u3167\ucb04\u45d3", -1883311647), iov.iqd(-15987178, -8996097, 1.0f), 0.5f, false, new int[]{-8996097, -5731073})};
        PRESET = new vlv(a.d("\ubd43\uc4ce\u4e10\ud069\u5bb6", 693468151, -2114664731), a.d("\u832f\ufab4\u7064\uee0d\u658d\ue35e\u5923\ud0df\u4e82\uc43b", 1952914574, 1186242541), iov.iqa());
        BG_HUE = new vmc(a.b("\ua326\udab4\u5065\uce1c\u45c7\uc363\u792d\uf0c6\u6e82\ue439\u63ae\u9997\u175d\u8efc", 1793368938), 0.68, 0.0, 1.0, 0.0);
        BG_SATURATION = new vmc(a.b("\u88fe\uf16c\u7bbd\ue5c4\u6e1f\ue8bb\u52f5\udb1e\u455a\ucfe1\u4876\ub254\u3c91\ua535\u2f67\ua991\u13cd\u9c09\u06a7\u80f0\u0906", -1756067671), 0.35, 0.0, 1.0, 0.0);
        BG_BRIGHTNESS = new vmc(a.d("\ubef9\uc76b\u4dba\ud3c3\u5818\udebc\u64f2\ued19\u735d\uf9e6\u7e71\u8442\u0a85\u932f\u1972\u9f8c\u25df\uaa14\u30ac\ub6eb\u3f1c", 1427502884, -893302390), 0.12, 0.0, 1.0, 0.0);
        OPACITY = new vmc(a.c(446664459, "\u8f43\uf6cd\u7c0f\ue27c\u69a1\uef0d\u5553"), 1.0, 0.3, 1.0, 0.05).percent();
        CONTRAST = new vmc(a.b("\u1a9d\u6300\ue9d2\u77b9\ufc68\u7aca\uc08b\u497d", -1131013418), 1.0, 0.5, 2.0, 0.05).percent();
        CUSTOM_SLIDERS = List.of(OPACITY, CONTRAST);
        PAINT = new vlv(a.d("\u2f09\u5694\udc44\u4236\uc9fb\u4f4d\uf51f\u7cbd\ue2ad\u6815", 498093721, -1074372135), a.c(-1478646150, "\ua633\udfaa\u5572\ucb18"), a.c(-296986799, "\u5718\u2e81\ua459\u3a33"), a.c(740276647, "\ub9ec\uc040\u4a82"));
        MENU_PAINTS = new iog[]{new iog(a.d("\u9508\uec87\u6653\uf828\u73f4\uf55d", -1168281943, 154401776), 0, false), new iog(a.c(762062777, "\u27ed\u5e66\ud4b8\u4ac8\uc118\u47aa\ufdea"), 1, false), new iog(a.c(-131957250, "\u7db8\u042b\u8eeb\u108c\u9b4c"), 2, false), new iog(a.b("\u9d96\ue405\u6ec5\uf0a2\u7b62\ufd80\u479c\uce6c\u507d\uda84\u5d50\ua738\u29fc\ub05a", 499686875), 3, false), new iog(a.c(-48327816, "\u933d\ueaa1\u606f\ufe08\u75de\uf378\u492a"), 4, false), new iog(a.c(433596570, "\u28ce\u5150\udb8f\u45f7\uce28\u488e\uf28e\u7b3e\ue56e\u6fd5\ue842\u1271\u9cb1\u0501\u8f52\u09b8\ub3f6\u3c3a"), 5, false), new iog(a.b("\u73ac\u0a32\u80ed\u1e95\u954a\u13ec\ua9ec\u2052\ube0c\u34f3\ub368\u491e\uc7d0\u5e72\ud436", -662342683), 6, false), new iog(a.d("\u6412\u1d87\u974a\u0926\u82e6\u045c\ube47\u37e2\ua9bb\u2319\ua4c8\u5eb1", -2084230741, -528527898), 7, false), new iog(a.d("\uba58\uc3cd\u4900\ud76c\u5cac\uda16\u600d\ue9b7\u77ed\ufd5d\u7a83", -1942645257, 10301431), 13, false), new iog(a.b("\ue6d6\u9f56\u1598\u8be5", -1183455610), 8, false), new iog(a.c(-167150479, "\u7c2c\u05ab\u8f7e\u1103\u9ad5\u1c6e\ua638\u2fda\ub18e\u3b66\ubce1\u4681\uc84b\u51f6"), 9, false), new iog(a.b("\u1bdb\u6252\ue880\u76e0\ufd36\u7bc3\uc1c4\u4824\ud666\u5cdb", -805561444), 10, false), new iog(a.d("\uf07e\u89e2\u032e\u9d40\u169a\u902a\u2a6e\ua39e", -726958386, -1622962436), 11, false), new iog(a.d("\u1649\u6fdf\ue515\u7b77\uf0b7", -957922265, 186536483), 14, false), new iog(a.b("\u9105\ue88f\u6255\ufc21\u77fd\uf154", 1317310800), 12, false), new iog(a.b("\u5715\u2e86\ua455\u3a22\ub1fe\u3755", -982165678), 15, false), new iog(a.b("\u7b32\u02a1\u8872\u1605\u9dd9\u1b72\ua175\u2896", 1865120635), 16, false)};
        HUD_PAINTS = new iog[]{new iog(a.c(1628590424, "\u5110\u2882\ua253\u3c2a\ub7f1\u3155\u8b1b\u02f0\u9cb4\u160f"), 0, true), new iog(a.b("\u51b1\u2831\ua2ff\u3c82", 1129337313), 8, true), new iog(a.c(-2026637838, "\uf5af\u8c28\u06fd\u9880\u1356\u95ed\u2fbb\ua659\u380d\ub2e5\u3562\ucf02\u41c8\ud875"), 9, true), new iog(a.b("\u17e6\u6e6f\ue4bd\u7add\uf10b\u77fe\ucdf9\u4419\uda5b\u50e6", -961669215), 10, true), new iog(a.c(2021475904, "\u4607\u3f94\ub547\u2b30\ua0ec\u2647"), 15, true), new iog(a.d("\u11b4\u6827\ue2f4\u7c83\uf75f\u71f4\ucbf3\u4210", 936947592, 2074066549), 16, true), new iog(a.c(-1986277632, "\ucf46\ub6d4\u3c14\ua264"), 7, true), new iog(a.c(317840178, "\udb72\ua2ec\u2833\ub64b\u3d94\ubb32"), 5, true), new iog(a.b("\u8037\uf9ab\u7365\ued02\u66d4\ue072\u5a20", 183140466), 4, true), new iog(a.d("\u5f41\u26dd\uac11\u327f\ub9a5\u3f15\u8551\u0ca1", -1633704466, 167049955), 11, true), new iog(a.c(2094112589, "\u9f15\ue680\u6c4d\uf221\u79e1\uff5b\u4540\uccfa\u52a0\ud810\u5fce"), 13, true), new iog(a.b("\u10f6\u6960\ue3aa\u7dc8\uf608", -127332165), 14, true)};
        ioz = new int[17];
        ipa = new boolean[17];
        ipb = new int[17];
        ipc = new boolean[17];
        ipe = new String[]{a.d("\u0e2a\u77af\ufd7d\u6317", 1039991029, 1588989594), a.b("\uf7bb\u8e28\u04fa\u9a8a", -1552877582), a.d("\u44b3\u3d3d\ub7e8\u299a\ua244\u24e4", -732865084, -188737241), a.c(-23102843, "\u7acf\u0352\u8987\u17f2\u9c2a"), a.d("\ua6ed\udf64\u55a5", -1432843266, 81538371), a.c(-1212930454, "\u2623\u5fb6\ud562\u4b09"), a.b("\u7d87\u0413\u8ec4\u10bd", 385973711), a.c(-410468161, "\uc0fc\ub965\u33b5\uadcc"), a.b("\uadcf\ud458\u5e90\uc0fc\u4b3d\ucd9d", -910053990), a.d("\ufaa7\u8327\u09ef\u979a\u1c53\u9afe\u20ac", -1748167874, 2038229469), a.b("\ub888\uc104\u4bcb\ud5ac", 1780398302), a.b("\u3f16\u4691\ucc44\u5232\ud9fe\u5f4d", -1677377709)};
        ipf = new int[][]{null, iox, {-7701008, -5660683}, {-11760144, -8803596}, {-13912621, -9974301}, {-13649535, -10695780}, {-7487681, -5516691}, {-2049990, -1389716}, {-1465797, -1000856}, {-1748149, -1147787}, {-1550470, -1146727}};
        ACCENT = new vlv(a.c(1433614625, "\u3966\u40f5\uca26\u5451\udf8d\u5926"), a.c(-1148007169, "\uccb6\ub525\u3ff7\ua187"), ipe);
        GRADIENT = new vkl(a.d("\ua397\uda13\u50d3\ucea7\u457d\uc3c0\u7998\uf073", 1358855626, -1392058862), false);
        HUE = new vmc(a.b("\ud853\ua1df\u2b1c", -1573136360), 0.72, 0.0, 1.0, 0.0);
        SATURATION = new vmc(a.b("\u7ce0\u0563\u8fa5\u11d5\u9a05\u1ca7\ua6e1\u2f0d\ub154\u3be4", 2098822329), 0.62, 0.0, 1.0, 0.0);
        BRIGHTNESS = new vmc(a.c(465193488, "\u4a58\u33d9\ub911\u276e\uacb6\u2a1b\u9052\u19a8\u87e1\u0d50"), 0.97, 0.0, 1.0, 0.0);
        STYLE = new vlv(a.c(1997231017, "\u53ff\u2a69\ua0b7\u3ed3\ub50d"), a.b("\u77d2\u0e49\u8497\u1af3", 108689296), a.c(-1761136439, "\u308b\u4910\uc3ce\u5daa"), a.c(-417488624, "\ua151\ud8c1\u5207\ucc72\u47b9"));
        SCALE = new vmc(a.c(1273679411, "\uce65\ub7e4\u3d35\ua349\u2897"), 1.0, 0.7, 1.3, 0.05).percent();
        ROUNDNESS = new vmc(a.b("\ua995\ud019\u5ad0\uc4ba\u4f67\uc9dc\u7384\ufa63\u643c", 684435918), 1.6, 0.0, 1.6, 0.05).percent();
        ANIMATION = new vmc(a.d("\u3e64\u47fa\ucd2e\u535b\ud880\u5e24\ue46a\u6d9d\uf3c3\u796f", -2128193107, -215586942), 1.0, 0.5, 2.0, 0.1).unit(a.d("\ua897", 1707733783, -63415303));
        BG_BLUR = new vmc(a.c(672422233, "\u5911\u208e\uaa44\u3432\ubfb7\u3951\u831a\u0af6\u94b7\u1e0e"), 2.0, 0.0, 6.0, 1.0);
        DIM = new vmc(a.c(-337767633, "\u1362\u6afe\ue029\u7e15\uf595\u733c\uc972\u409d\udeca"), 0.35, 0.0, 0.9, 0.05).percent();
        INTERFACE = List.of(STYLE, SCALE, ROUNDNESS, ANIMATION, BG_BLUR, DIM);
        ALL = List.of(PRESET, ACCENT, GRADIENT, HUE, SATURATION, BRIGHTNESS, BG_HUE, BG_SATURATION, BG_BRIGHTNESS, OPACITY, CONTRAST, STYLE, SCALE, ROUNDNESS, ANIMATION, BG_BLUR, DIM);
        ipg = (int[])iov.PRESETS[0].iop.clone();
        iph = 1.0f;
        ipj = 0.4f;
        ipk = iox[0];
        ipl = iox[0];
        ipm = iox[0];
        ipo = new float[3];
        ipp = a.b("\u4ce0\u3564\ubfa4\u21c4\uaa0b\u2cbb\u96f5\u1f15", -235058001);
        ipq = -1L;
        ipr = Long.MIN_VALUE;
        ipt = Long.MIN_VALUE;
        iov.iqn();
        ipu = new int[17];
    }

    private static /* synthetic */ int aiq(int n, int n2) {
        return n * n2 + 1257064521;
    }
}

