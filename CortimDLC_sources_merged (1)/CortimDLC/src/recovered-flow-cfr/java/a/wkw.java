/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 */
package a;

import a.dry;
import a.iov;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vcq;
import a.vdn;
import a.veo;
import a.vhz;
import a.vjf;
import a.vxu;
import a.wap;
import a.wkq;
import a.wkt;
import a.wlk;
import flow.dev.a;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public final class wkw {
    private static final vdn wkx = veo.semibold(6.8f);
    private static final vdn wky = veo.medium(5.8f);
    private static final float wkz = 20.0f;
    private static final float wla = 0.41666666f;
    private static final float wlb = 0.125f;
    private static final Map<wkq, wkt> wlc = new IdentityHashMap<wkq, wkt>();
    private static /* synthetic */ long wld;
    private static /* synthetic */ String wle;

    private wkw() {
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (!wlk.ENABLED.get() || minecraftClient.world == null || minecraftClient.player == null || minecraftClient.options.hudHidden || dry.armed()) {
            return;
        }
        List<wkq> list = wlk.drawable();
        if (list.isEmpty()) {
            wlc.clear();
            return;
        }
        unf.observe(drawContext);
        float f = unf.delta();
        iov.update(f * (float)iov.ANIMATION.get());
        float f2 = drawContext.getScaledWindowWidth();
        float f3 = drawContext.getScaledWindowHeight();
        try {
            usn2 = usn.capture(renderTickCounter.getTickProgress(true), f2, f3);
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        float f4 = (float)wlk.SCALE.get();
        float[] fArray = new float[2];
        wlc.keySet().retainAll(list);
        list.sort((wkq2, wkq3) -> Double.compare(usn2.distance(wkq3.cx(), wkq3.cy(), wkq3.cz()), usn2.distance(wkq2.cx(), wkq2.cy(), wkq2.cz())));
        for (wkq wkq4 : list) {
            wkt wkt2 = wlc.computeIfAbsent(wkq4, wkq2 -> new wkt());
            double d = usn2.distance(wkq4.cx(), wkq4.cy(), wkq4.cz());
            boolean bl = usn2.project(wkq4.cx(), wkq4.cy(), wkq4.cz(), fArray);
            boolean bl2 = bl && fArray[0] > -20.0f && fArray[0] < f2 + 20.0f && fArray[1] > -20.0f && fArray[1] < f3 + 20.0f;
            boolean bl3 = d > 2.5;
            float f5 = wkt2.marker.step(bl2 && bl3, f);
            boolean bl4 = bl2 && Math.hypot(fArray[0] - f2 * 0.5f, fArray[1] - (f3 * 0.5f + 20.0f * f4 * 0.3f)) < (double)(18.0f * f4);
            float f6 = wkt2.focus.step(bl4, f);
            if (!(f5 > 0.01f) || !bl) continue;
            wkw.wlf(drawContext, wkq4, fArray[0], fArray[1], d, f5, f6, f4);
        }
    }

    private static void wlf(DrawContext drawContext, wkq wkq2, float f, float f2, double d, float f3, float f4, float f5) {
        float f6 = (float)Math.min(1.0, Math.max(0.3, (d - 1.5) / 4.0));
        float f7 = (float)Math.max(0.78, Math.min(1.06, 1.1 - Math.log10(Math.max(1.0, d)) * 0.1));
        float f8 = vcq.outCubic(f3);
        int n = wlk.colorOf(wkq2);
        uut.pushAlpha(f3 * f6);
        float f9 = f7 * (1.0f + 0.1f * f4);
        float f10 = (1.0f - f8) * -5.0f - f4 * 1.5f;
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(f, f2);
        uut.shadow(drawContext, -3.0f * f9, -1.0f * f9, 6.0f * f9, 2.0f * f9, 1.0f * f9, 2.5f * f9, 0x46000000);
        drawContext.getMatrices().translate(0.0f, f10);
        drawContext.getMatrices().scale(f9, f9);
        wkw.pin(drawContext, 0.0f, -20.0f * f5 * 0.41666666f, 20.0f * f5, n, 0.8f + 0.2f * f4);
        drawContext.getMatrices().popMatrix();
        wkw.wlg(drawContext, wkq2, f, f2 + 4.0f * f9, d, n, f4);
        uut.popAlpha();
    }

    public static void pin(DrawContext drawContext, float f, float f2, float f3, int n, float f4) {
        wkw.pin(drawContext, vhz.WAYPOINT, f, f2, f3, n, f4);
    }

    public static void pin(DrawContext drawContext, vhz vhz2, float f, float f2, float f3, int n, float f4) {
        int n2 = n | 0xFF000000;
        float f5 = f2 - f3 * 0.125f;
        float f6 = f3 * 0.34f;
        uut.shadow(drawContext, f - f6, f5 - f6, f6 * 2.0f, f6 * 2.0f, f6, f3 * 0.6f, ujt.withAlpha(n2, Math.round(125.0f * f4)));
        vjf.draw(drawContext, vhz2, f, f2 + Math.max(0.5f, f3 * 0.04f), f3, 0x55000000);
        vjf.draw(drawContext, vhz2, f, f2, f3, n2);
    }

    /*
     * Exception decompiling
     */
    private static void wlg(DrawContext var0, wkq var1_1, float var2_2, float var3_3, double var4_4, int var6_5, float var7_6) {
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

    public static void bead(DrawContext drawContext, float f, float f2, float f3, int n) {
        int n2 = n | 0xFF000000;
        uut.shadow(drawContext, f - f3, f2 - f3 + f3 * 0.35f, f3 * 2.0f, f3 * 2.0f, f3, Math.max(1.5f, f3 * 0.8f), 0x78000000);
        uut.circle(drawContext, f, f2, f3 + 0.6f, 0x50000000);
        uut.gradientV(drawContext, f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, f3, ujt.lerp(n2, -1, 0.42f), ujt.shade(n2, 0.72f));
        float f4 = f3 * 0.3f;
        uut.circle(drawContext, f - f3 * 0.3f, f2 - f3 * 0.36f, f4, -654311425);
    }

    public static String formatDistance(double d) {
        if (d >= 1000.0) {
            return vxu.fixed(d / 1000.0, 1) + wap.s(a.d("\uc99a", -1337704499, 1902573117), a.d("\ua474\uddc3", 311098345, 396581797));
        }
        return Math.round(d) + wap.unit(a.d("\u5521", -1831169416, 989644597));
    }

    private static /* synthetic */ int drn(int n, int n2) {
        return n ^ n2 ^ 0xAD1A0BB;
    }

    private static /* synthetic */ int dro(int n, int n2) {
        return wkw.drn(n, n2) ^ 0x7E4D724A;
    }

    private static /* synthetic */ int drp(int n, int n2) {
        return wkw.dro(n, n2) ^ 0x8466680F;
    }
}

