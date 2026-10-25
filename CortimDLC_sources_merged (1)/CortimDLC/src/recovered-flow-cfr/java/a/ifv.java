/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 */
package a;

import a.iov;
import a.irr;
import a.lfa;
import a.tct;
import a.tcw;
import a.tcz;
import a.tkc;
import a.ttl;
import a.tyd;
import a.ujt;
import a.unf;
import a.uut;
import a.vcj;
import a.vcq;
import a.wap;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public final class ifv {
    private static final float ifw = 15.0f;
    private static final vcj ifx = new vcj(10.0f);
    private static String ify = "";
    private static int ifz;
    private static /* synthetic */ int iga;
    private static /* synthetic */ int igb;

    private ifv() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        float f;
        String string;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.options.hudHidden) {
            return;
        }
        unf.observe(drawContext);
        float f2 = unf.delta();
        String string2 = null;
        int n = 0;
        tcw tcw2 = tcz.mode();
        int n2 = lfa.stopKey();
        String string3 = string = n2 == -1 ? wap.s(a.b("\u08a8\u711e\ufbd6\u65b8\uee3f\u68c7\ud293\u5b2c\uc527\u4f8a\uc854\u3260\ubce4\u2552\uaf00\u29e0\u93a2\u1c75", 1035405513), a.c(878915876, "\u3568\u4cda\uc675\u5805\ud7cd\u556e\ueb2f\u66bf\uf8e3\u7253\uf5f7\u0f8a\u815d")) : irr.keyName(n2) + wap.s(a.d("\u7c8e\u250b\u8fec\u11ce\u9a1e\u1cb4\ua6f8", 1277992433, 1263460696), a.c(807399652, "\uf0c3\ua946\u03a1\u99b1\u1265\u94a8\u2efa"));
        if (tcw2 == tcw.RECORD && tcz.walkRecorder() != null) {
            var9_9 = tcz.walkRecorder();
            String string4 = wap.s(a.c(63877830, "\ub2bd\ucb1a\u41c4\udfb2\u5467\ud2d1\u688b\ue13d\u7f62\uf544\u7200\u8871"), a.d("\u649a\u1d50\u9789\u0980\u822a\u049a\ubad9\u3328\uade0\u27c6\ua015", -933998308, -1116917304)) + Math.round(((tyd)var9_9).meters) + wap.s(a.d("\u45ed\u3c11", 585274708, -1955671909), a.b("\u4901\u34ac", -1280358109)) + a.c(-769527480, "\uf16d\u88dc\u0298\u9c7e\u17a9") + wap.s(a.d("\u972e\uee82\u644b\ufa3b\u71fd\uf75a\u4d5a", -1106961150, 1803389529), a.c(-1397820213, "\uf0fd\u8940\u03e3\u9d9a\u1645\u90f7\u2aa5\ua328\u3d7b\ub3d8")) + ((tyd)var9_9).routes + a.b("\u6275\u1bc4\u9180\u0f66\u84b1", -2128190896) + ifv.igd(((tyd)var9_9).seconds());
            string2 = ((tyd)var9_9).paused ? wap.s(a.b("\ufa55\u83f3\u0926\u9734\u1cb3\u9a13\u2054\ua9a3\u37ea\ubd5a\u3ad7\uc0bc", 793901579), a.c(1567620151, "\ufc6e\u85c8\u0f1d\u910f\u1ec7\u9879\u2259\uabdc\u3584\ubb3f\u3cf6")) + ifv.reasonText(((tyd)var9_9).pauseReason) : a.b("\u4a26\u3380\ub955\u2747\uac90", -1857140111) + string4 + a.c(1713187789, "\u2be8\u5259\ud81d\u46fb\ucd2c") + string;
            n = ((tyd)var9_9).paused ? 1 : 2;
        } else if (tcw2 == tcw.RECORD && tcz.mineRecorder() != null) {
            var9_9 = tcz.mineRecorder();
            String string5 = wap.s(a.b("\ucb46\ub2f3\u3827\ua65d\u2dcf\uab7e\u11ba\u98dc\u0683\u8c71\u0bad\uf1d9\u7f04\ue6bd\u6cf6\uea54", 2016856891), a.b("\uca69\ub3a0\u3906\ua770\u2cd5\uae74\u1427\u9d41\u0389\u8938\u0af1\uf081\u7e55\ue7e6\u6db7\uef5e", -546451919)) + ((ttl)var9_9).blocks + a.c(-1499994896, "\ue4d5\u9d64\u1720\u89c6\u0211") + wap.s(a.c(-732853537, "\u8abe\uf308\u79c8\ue7a6\u6c79\ueac9\u50de"), a.c(-1359502122, "\ua0e2\ud95e\u53f9\ucdfc\u465b\uc096\u7ac1\uf333\u6977")) + ((ttl)var9_9).farmed + a.d("\u1460\u6dd1\ue795\u7973\uf2a4", -1892548186, 292951523) + ifv.igd(((ttl)var9_9).seconds());
            string2 = ((ttl)var9_9).paused ? wap.s(a.c(81517239, "\udae9\ua34f\u299a\ub788\u3c0f\ubaaf\u00e8\u891f\u1756\u9de6\u1a6b\ue000"), a.d("\u3538\u4c9e\uc64b\u5859\ud791\u512f\ueb0f\u628a\ufcd2\u7269\uf5a0", 68495484, 1096883485)) + ifv.reasonText(((ttl)var9_9).pauseReason) : a.b("\ud98a\ua02c\u2af9\ub4eb\u3f3c", 1946737117) + string5 + a.c(649424678, "\u6f03\u16b2\u9cf6\u0210\u89c7") + string;
            n = ((ttl)var9_9).paused ? 1 : 2;
        } else if (tcw2 == tcw.RECORD && tcz.recorder() != null) {
            var9_9 = tcz.recorder();
            String string6 = wap.s(a.d("\u1839\u6189\ueb47\u7531\ufeb5", 1825186910, 1269447690), a.b("\u6b0a\u12cc\u981b\u061a\u8dc6\u0f1c", -1735954609)) + ((tkc)var9_9).hits + a.b("\u1583\u6c32\ue676\u7890\uf347", 321131942) + wap.s(a.c(-2130787664, "\uc2cb\ubb68\u31b7\uafdb\u2410\ua2a8\u18ed\u914f"), a.b("\ub988\uc04d\u4a97\ud4e5\u5f36\ud9f7\u67cf", -1454195250)) + ((tkc)var9_9).samples + a.c(-2085325857, "\u73fa\u0a4b\u800f\u1ee9\u953e") + wap.s(a.d("\u49ff\u3041\uba97\u24fe\uaf38\u299e\u93da\u1a2a\u8431", -42492791, -1800743655), a.d("\u1a2c\u63e1\ue931\u7734\ufc99\u7a5a\uc00a\u4de5", 249803352, 262253634)) + ((tkc)var9_9).failures + a.b("\ua340\udaf1\u50b5\uce53\u4584", -172645531) + ifv.igd(((tkc)var9_9).seconds());
            string2 = ((tkc)var9_9).paused ? wap.s(a.c(-200470623, "\u0fff\u7659\ufc8c\u629e\ue919\u6fb9\ud5fe\u5c09\uc240\u48f0\ucf7d\u3516"), a.d("\u56b9\u2f1f\ua5ca\u3bd8\ub410\u32ae\u888e\u010b\u9f53\u11e8\u9621", 573540466, 117825170)) + ifv.reasonText(((tkc)var9_9).pauseReason) : a.d("\u4623\u3f85\ub550\u2b42\ua095", -372659877, 125628207) + string6 + a.c(1742511268, "\u9c81\ue530\u6f74\uf192\u7a45") + string;
            n = ((tkc)var9_9).paused ? 1 : 2;
        } else if (tcw2 == tcw.TEST) {
            string2 = wap.s(a.d("\u7333\u0a80\u8058\u1e28\u95f6\u132b\ua90c\u20ec\ubea5\u3413", -1928614708, 234020792), a.d("\u5b90\u2216\ua8f1\u3683\ub956\u3bdb\u818a\u0871\u962f\u1c90\u9b40", 459144305, -415652920)) + a.b("\u4940\u30f1\ubab5\u2453\uaf84", 1683376485) + string;
            n = 3;
        } else if (tcz.fightRecorder() != null && !tcz.fightRecorder().paused) {
            string2 = wap.s(a.b("\u61e1\u1847\u9292\u0c80\u8711\u01af\ubbf2\u320c\uac4f\u26f9\ua179\u5b08\ud548\u4c6e\uc63d\u4084\ufaca\u7506\uefb2\u69b0", 990339495), a.d("\u6155\u18f3\u9226\u0c34\u83f2\u054c\ubf19\u32f0\uacaf\u2689\ua1cd\u5bbc\ud108\u48ce\uc299\u4418\ufe5c\u75e6", -1797200319, 40732500)) + tcz.fightRecorder().hits;
            n = 2;
        } else if (tcz.training() && minecraftClient.currentScreen == null) {
            var9_9 = tcz.job();
            string2 = wap.s(a.c(1071492648, "\uae75\ud7e2\u5d22\uc35b\u488b\uce3d\u7469\ufd91\u6389"), a.c(1429970535, "\u9a70\ue3ee\u694f\uf73a\u7c9f\ufa26\u4070\uc98c\u53c6")) + (((tct)var9_9).progress.epoch + 1) + a.b("\u3ab1\u430f\uc9d3", 2036808338) + ((tct)var9_9).progress.epochs;
            n = 3;
        }
        if (string2 != null) {
            ify = string2;
            ifz = n;
        }
        if ((f = vcq.outCubic(ifx.step(string2 != null, f2))) < 0.01f) {
            return;
        }
        iov.beginHud();
        uut.beginFrame();
        try {
            ifv.igc(drawContext, ify, ifz, f);
        }
        finally {
            iov.endHud();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void igc(DrawContext drawContext, String string, int n, float f) {
        float f2 = drawContext.getScaledWindowWidth();
        float f3 = n == 0 ? 0.0f : 9.0f;
        float f4 = 10.0f + f3 + irr.VALUE.width(string) + 10.0f;
        float f5 = (f2 - f4) * 0.5f;
        float f6 = 30.0f - (1.0f - f) * 8.0f;
        float f7 = iov.r(6.0f);
        uut.pushAlpha(f);
        try {
            uut.shadow(drawContext, f5, f6 + 1.5f, f4, 15.0f, f7, 8.0f, ujt.withAlpha(0, 70));
            uut.round(drawContext, f5, f6, f4, 15.0f, f7, iov.hudFill(0.82f));
            uut.outline(drawContext, f5, f6, f4, 15.0f, f7, 1.0f, iov.hudEdge());
            float f8 = f5 + 10.0f;
            float f9 = f6 + 7.5f;
            if (n != 0) {
                int n2 = switch (n) {
                    case 1 -> -678620;
                    case 2 -> -1750963;
                    default -> iov.accent();
                };
                float f10 = n == 2 ? 0.55f + 0.45f * (float)Math.abs(Math.sin((double)System.currentTimeMillis() / 380.0)) : 1.0f;
                uut.circle(drawContext, f8 + 2.5f, f9, 4.2f, ujt.withAlpha(n2, Math.round(60.0f * f10)));
                uut.circle(drawContext, f8 + 2.5f, f9, 2.6f, ujt.withAlpha(n2, Math.round(255.0f * f10)));
                f8 += f3;
            }
            irr.VALUE.draw(drawContext, string, f8, irr.VALUE.centerTop(f9), iov.text);
        }
        finally {
            uut.popAlpha();
        }
    }

    private static String igd(int n) {
        return n / 60 + a.d("\u648c", -1382609034, -1644074047) + String.format(a.b("\u1448\u6dec\ue73d\u791a", 1418990697), n % 60);
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
        return ifv.age(n, n2) + n;
    }
}

