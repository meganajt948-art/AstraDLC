/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.PanicShutdown;
import a.Theme;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.IconRenderer;
import a.FormatUtil;
import a.Lang;
import a.Waypoint;
import a.wkt;
import a.Waypoints;
import flow.dev.StringDecryptor;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class WaypointRenderer {
    private static final FontFace wkx = Fonts.semibold(6.8f);
    private static final FontFace wky = Fonts.medium(5.8f);
    private static final float wkz = 20.0f;
    private static final float wla = 0.41666666f;
    private static final float wlb = 0.125f;
    private static final Map<Waypoint, wkt> wlc = new IdentityHashMap<Waypoint, wkt>();
    private static /* synthetic */ long wld;
    private static /* synthetic */ String wle;

    private WaypointRenderer() {
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        class_310 class_3102 = class_310.method_1551();
        if (!Waypoints.ENABLED.get() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || PanicShutdown.armed()) {
            return;
        }
        List<Waypoint> list = Waypoints.drawable();
        if (list.isEmpty()) {
            wlc.clear();
            return;
        }
        FrameDelta.observe(class_3322);
        float f = FrameDelta.delta();
        Theme.update(f * (float)Theme.ANIMATION.get());
        float f2 = class_3322.method_51421();
        float f3 = class_3322.method_51443();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), f2, f3);
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        float f4 = (float)Waypoints.SCALE.get();
        float[] fArray = new float[2];
        wlc.keySet().retainAll(list);
        list.sort((wkq2, wkq3) -> Double.compare(usn2.distance(wkq3.cx(), wkq3.cy(), wkq3.cz()), usn2.distance(wkq2.cx(), wkq2.cy(), wkq2.cz())));
        for (Waypoint wkq4 : list) {
            wkt wkt2 = wlc.computeIfAbsent(wkq4, wkq2 -> new wkt());
            double d = usn2.distance(wkq4.cx(), wkq4.cy(), wkq4.cz());
            boolean bl = usn2.project(wkq4.cx(), wkq4.cy(), wkq4.cz(), fArray);
            boolean bl2 = bl && fArray[0] > -20.0f && fArray[0] < f2 + 20.0f && fArray[1] > -20.0f && fArray[1] < f3 + 20.0f;
            boolean bl3 = d > 2.5;
            float f5 = wkt2.marker.step(bl2 && bl3, f);
            boolean bl4 = bl2 && Math.hypot(fArray[0] - f2 * 0.5f, fArray[1] - (f3 * 0.5f + 20.0f * f4 * 0.3f)) < (double)(18.0f * f4);
            float f6 = wkt2.focus.step(bl4, f);
            if (!(f5 > 0.01f) || !bl) continue;
            WaypointRenderer.wlf(class_3322, wkq4, fArray[0], fArray[1], d, f5, f6, f4);
        }
    }

    private static void wlf(class_332 class_3322, Waypoint wkq2, float f, float f2, double d, float f3, float f4, float f5) {
        float f6 = (float)Math.min(1.0, Math.max(0.3, (d - 1.5) / 4.0));
        float f7 = (float)Math.max(0.78, Math.min(1.06, 1.1 - Math.log10(Math.max(1.0, d)) * 0.1));
        float f8 = Easing.outCubic(f3);
        int n = Waypoints.colorOf(wkq2);
        DrawUtil.pushAlpha(f3 * f6);
        float f9 = f7 * (1.0f + 0.1f * f4);
        float f10 = (1.0f - f8) * -5.0f - f4 * 1.5f;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f2);
        DrawUtil.shadow(class_3322, -3.0f * f9, -1.0f * f9, 6.0f * f9, 2.0f * f9, 1.0f * f9, 2.5f * f9, 0x46000000);
        class_3322.method_51448().translate(0.0f, f10);
        class_3322.method_51448().scale(f9, f9);
        WaypointRenderer.pin(class_3322, 0.0f, -20.0f * f5 * 0.41666666f, 20.0f * f5, n, 0.8f + 0.2f * f4);
        class_3322.method_51448().popMatrix();
        WaypointRenderer.wlg(class_3322, wkq2, f, f2 + 4.0f * f9, d, n, f4);
        DrawUtil.popAlpha();
    }

    public static void pin(class_332 class_3322, float f, float f2, float f3, int n, float f4) {
        WaypointRenderer.pin(class_3322, Icon.WAYPOINT, f, f2, f3, n, f4);
    }

    public static void pin(class_332 class_3322, Icon vhz2, float f, float f2, float f3, int n, float f4) {
        int n2 = n | 0xFF000000;
        float f5 = f2 - f3 * 0.125f;
        float f6 = f3 * 0.34f;
        DrawUtil.shadow(class_3322, f - f6, f5 - f6, f6 * 2.0f, f6 * 2.0f, f6, f3 * 0.6f, ColorUtil.withAlpha(n2, Math.round(125.0f * f4)));
        IconRenderer.draw(class_3322, vhz2, f, f2 + Math.max(0.5f, f3 * 0.04f), f3, 0x55000000);
        IconRenderer.draw(class_3322, vhz2, f, f2, f3, n2);
    }

    /*
     * Exception decompiling
     */
    private static void wlg(class_332 var0, Waypoint var1_1, float var2_2, float var3_3, double var4_4, int var6_5, float var7_6) {
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

    public static void bead(class_332 class_3322, float f, float f2, float f3, int n) {
        int n2 = n | 0xFF000000;
        DrawUtil.shadow(class_3322, f - f3, f2 - f3 + f3 * 0.35f, f3 * 2.0f, f3 * 2.0f, f3, Math.max(1.5f, f3 * 0.8f), 0x78000000);
        DrawUtil.circle(class_3322, f, f2, f3 + 0.6f, 0x50000000);
        DrawUtil.gradientV(class_3322, f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, f3, ColorUtil.lerp(n2, -1, 0.42f), ColorUtil.shade(n2, 0.72f));
        float f4 = f3 * 0.3f;
        DrawUtil.circle(class_3322, f - f3 * 0.3f, f2 - f3 * 0.36f, f4, -654311425);
    }

    public static String formatDistance(double d) {
        if (d >= 1000.0) {
            return FormatUtil.fixed(d / 1000.0, 1) + Lang.s("k", "км");
        }
        return Math.round(d) + Lang.unit("m");
    }

    private static /* synthetic */ int drn(int n, int n2) {
        return n ^ n2 ^ 0xAD1A0BB;
    }

    private static /* synthetic */ int dro(int n, int n2) {
        return WaypointRenderer.drn(n, n2) ^ 0x7E4D724A;
    }

    private static /* synthetic */ int drp(int n, int n2) {
        return WaypointRenderer.dro(n, n2) ^ 0x8466680F;
    }
}

