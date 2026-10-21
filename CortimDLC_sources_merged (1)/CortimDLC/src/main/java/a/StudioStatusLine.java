/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.Theme;
import a.UiKit;
import a.AutoMine;
import a.tct;
import a.tcw;
import a.RecorderHooks;
import a.AimRecorder;
import a.MineRecorder;
import a.WardenRecorder;
import a.ColorUtil;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class StudioStatusLine {
    private static final float ifw = 15.0f;
    private static final Spring ifx = new Spring(10.0f);
    private static String ify = "";
    private static int ifz;
    private static /* synthetic */ int iga;
    private static /* synthetic */ int igb;

    private StudioStatusLine() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        float f;
        String string;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1690.field_1842) {
            return;
        }
        FrameDelta.observe(class_3322);
        float f2 = FrameDelta.delta();
        String string2 = null;
        int n = 0;
        tcw tcw2 = RecorderHooks.mode();
        int n2 = AutoMine.stopKey();
        String string3 = string = n2 == -1 ? Lang.s("stop in the studio", "стоп в студии") : UiKit.keyName(n2) + Lang.s(" — stop", " — стоп");
        if (tcw2 == tcw.RECORD && RecorderHooks.walkRecorder() != null) {
            var9_9 = RecorderHooks.walkRecorder();
            String string4 = Lang.s("walking  ·  ", "ходьба  ·  ") + Math.round(((WardenRecorder)var9_9).meters) + Lang.s(" m", " м") + "  ·  " + Lang.s("routes ", "маршрутов ") + ((WardenRecorder)var9_9).routes + "  ·  " + StudioStatusLine.igd(((WardenRecorder)var9_9).seconds());
            string2 = ((WardenRecorder)var9_9).paused ? Lang.s("REC paused: ", "REC пауза: ") + StudioStatusLine.reasonText(((WardenRecorder)var9_9).pauseReason) : "REC  " + string4 + "  ·  " + string;
            n = ((WardenRecorder)var9_9).paused ? 1 : 2;
        } else if (tcw2 == tcw.RECORD && RecorderHooks.mineRecorder() != null) {
            var9_9 = RecorderHooks.mineRecorder();
            String string5 = Lang.s("mine  ·  clicks ", "шахта  ·  клики ") + ((MineRecorder)var9_9).blocks + "  ·  " + Lang.s("farmed ", "нафармил ") + ((MineRecorder)var9_9).farmed + "  ·  " + StudioStatusLine.igd(((MineRecorder)var9_9).seconds());
            string2 = ((MineRecorder)var9_9).paused ? Lang.s("REC paused: ", "REC пауза: ") + StudioStatusLine.reasonText(((MineRecorder)var9_9).pauseReason) : "REC  " + string5 + "  ·  " + string;
            n = ((MineRecorder)var9_9).paused ? 1 : 2;
        } else if (tcw2 == tcw.RECORD && RecorderHooks.recorder() != null) {
            var9_9 = RecorderHooks.recorder();
            String string6 = Lang.s("hits ", "удары ") + ((AimRecorder)var9_9).hits + "  ·  " + Lang.s("samples ", "семплы ") + ((AimRecorder)var9_9).samples + "  ·  " + Lang.s("filtered ", "отсеяно ") + ((AimRecorder)var9_9).failures + "  ·  " + StudioStatusLine.igd(((AimRecorder)var9_9).seconds());
            string2 = ((AimRecorder)var9_9).paused ? Lang.s("REC paused: ", "REC пауза: ") + StudioStatusLine.reasonText(((AimRecorder)var9_9).pauseReason) : "REC  " + string6 + "  ·  " + string;
            n = ((AimRecorder)var9_9).paused ? 1 : 2;
        } else if (tcw2 == tcw.TEST) {
            string2 = Lang.s("MODEL TEST", "ТЕСТ МОДЕЛИ") + "  ·  " + string;
            n = 3;
        } else if (RecorderHooks.fightRecorder() != null && !RecorderHooks.fightRecorder().paused) {
            string2 = Lang.s("REC fights  ·  hits ", "REC бои  ·  удары ") + RecorderHooks.fightRecorder().hits;
            n = 2;
        } else if (RecorderHooks.training() && class_3102.field_1755 == null) {
            var9_9 = RecorderHooks.job();
            string2 = Lang.s("Training ", "Обучение ") + (((tct)var9_9).progress.epoch + 1) + " / " + ((tct)var9_9).progress.epochs;
            n = 3;
        }
        if (string2 != null) {
            ify = string2;
            ifz = n;
        }
        if ((f = Easing.outCubic(ifx.step(string2 != null, f2))) < 0.01f) {
            return;
        }
        Theme.beginHud();
        DrawUtil.beginFrame();
        try {
            StudioStatusLine.igc(class_3322, ify, ifz, f);
        }
        finally {
            Theme.endHud();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void igc(class_332 class_3322, String string, int n, float f) {
        float f2 = class_3322.method_51421();
        float f3 = n == 0 ? 0.0f : 9.0f;
        float f4 = 10.0f + f3 + UiKit.VALUE.width(string) + 10.0f;
        float f5 = (f2 - f4) * 0.5f;
        float f6 = 30.0f - (1.0f - f) * 8.0f;
        float f7 = Theme.r(6.0f);
        DrawUtil.pushAlpha(f);
        try {
            DrawUtil.shadow(class_3322, f5, f6 + 1.5f, f4, 15.0f, f7, 8.0f, ColorUtil.withAlpha(0, 70));
            DrawUtil.round(class_3322, f5, f6, f4, 15.0f, f7, Theme.hudFill(0.82f));
            DrawUtil.outline(class_3322, f5, f6, f4, 15.0f, f7, 1.0f, Theme.hudEdge());
            float f8 = f5 + 10.0f;
            float f9 = f6 + 7.5f;
            if (n != 0) {
                int n2 = switch (n) {
                    case 1 -> -678620;
                    case 2 -> -1750963;
                    default -> Theme.accent();
                };
                float f10 = n == 2 ? 0.55f + 0.45f * (float)Math.abs(Math.sin((double)System.currentTimeMillis() / 380.0)) : 1.0f;
                DrawUtil.circle(class_3322, f8 + 2.5f, f9, 4.2f, ColorUtil.withAlpha(n2, Math.round(60.0f * f10)));
                DrawUtil.circle(class_3322, f8 + 2.5f, f9, 2.6f, ColorUtil.withAlpha(n2, Math.round(255.0f * f10)));
                f8 += f3;
            }
            UiKit.VALUE.draw(class_3322, string, f8, UiKit.VALUE.centerTop(f9), Theme.text);
        }
        finally {
            DrawUtil.popAlpha();
        }
    }

    private static String igd(int n) {
        return n / 60 + ":" + String.format("%02d", n % 60);
    }

    /*
     * Exception decompiling
     */
    static String reasonText(String var0) {
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

    private static /* synthetic */ int age(int n, int n2) {
        return n ^ n2 ^ 0x5F5C4A15;
    }

    private static /* synthetic */ int agf(int n, int n2) {
        return StudioStatusLine.age(n, n2) + n;
    }
}

