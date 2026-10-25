/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.imn;
import a.iom;
import a.iov;
import a.irr;
import a.isn;
import a.isv;
import a.ujt;
import a.uok;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

final class iqp
extends imn {
    private static final float iqq = 54.0f;
    private static final float iqr = 6.0f;
    private static final float iqs = 27.0f;
    private static final float iqt = 10.0f;
    private static final float iqu = 13.0f;
    private static final String[] iqv = new String[]{a.b("\u420e\u3b95\ub145\u2f2c", -1947778484), a.d("\u96f6\uef62\u65a2\ufbca", -2137659388, -1690468686), a.d("\u9c16\ue58b\u6f5b\uf129\u7ae4\ufc52", -737654130, -1916217635), a.b("\ufc00\u8594\u0f49\u9137\u1afc", 1556610121), a.c(-728604230, "\u61fb\u186f\u92b2\u0ccc\u8707\u01e2\ubbb7\u3240\uac58\u26e2\ua13c\u5b5f\ud588"), a.d("\u8d56\uf4d1\u7e04\ue072\u6bbe\ued0d", 744460765, 1977556174)};
    private final int[] iqw;
    private final vcj[] iqx;
    private final vcj[] iqy;
    private static /* synthetic */ String iqz;
    private static /* synthetic */ long ira;

    iqp() {
        super(iov.PRESET);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (String string : iqv) {
            if (string.equals(a.b("\udfe6\ua661\u2cb4\ub2c2\u390e\ubfbd", -572334173))) {
                arrayList.add(-1);
                continue;
            }
            for (int i = 0; i < iov.PRESETS.length; ++i) {
                if (!iov.PRESETS[i].group().equals(string)) continue;
                arrayList.add(i);
            }
        }
        this.iqw = arrayList.stream().mapToInt(Integer::intValue).toArray();
        this.iqx = new vcj[this.iqw.length];
        this.iqy = new vcj[this.iqw.length];
        for (int i = 0; i < this.iqw.length; ++i) {
            this.iqx[i] = new vcj(16.0f);
            this.iqy[i] = new vcj(14.0f, this.irc(i).equals(iov.PRESET.get()) ? 1.0f : 0.0f);
        }
    }

    private iom irb(int n) {
        return this.iqw[n] < 0 ? iov.custom() : iov.PRESETS[this.iqw[n]];
    }

    private String irc(int n) {
        return this.iqw[n] < 0 ? a.b("\u7425\u0da2\u8777\u1901\u92cd\u147e", -86936480) : iov.PRESETS[this.iqw[n]].name();
    }

    private String ird(int n) {
        return this.iqw[n] < 0 ? a.d("\u2803\u5184\udb51\u4527\uceeb\u4858", -42394172, -972999294) : iov.PRESETS[this.iqw[n]].group();
    }

    /*
     * Exception decompiling
     */
    private static String ire(String var0) {
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

    private int irf() {
        float f = this.w > 0.0f ? this.w : 376.0f;
        return Math.max(3, (int)((f + 6.0f) / 60.0f));
    }

    private float irg() {
        int n = this.irf();
        return (this.w - 6.0f * (float)(n - 1)) / (float)n;
    }

    private float irh(float[] fArray, float[] fArray2) {
        int n = this.irf();
        float f = this.w > 0.0f ? this.irg() : 54.0f;
        float f2 = 1.0f;
        String string = null;
        int n2 = 0;
        for (int i = 0; i < this.iqw.length; ++i) {
            if (!this.ird(i).equals(string)) {
                if (string != null) {
                    f2 += 45.0f;
                }
                string = this.ird(i);
                f2 += 13.0f;
                n2 = 0;
            } else if (n2 == n) {
                f2 += 43.0f;
                n2 = 0;
            }
            if (fArray != null) {
                fArray[i] = (float)n2 * (f + 6.0f);
                fArray2[i] = f2;
            }
            ++n2;
        }
        return f2 + 27.0f + 10.0f;
    }

    @Override
    float height() {
        return this.irh(null, null);
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float[] fArray = new float[this.iqw.length];
        float[] fArray2 = new float[this.iqw.length];
        this.irh(fArray, fArray2);
        float f4 = this.irg();
        String string = null;
        for (int i = 0; i < this.iqw.length; ++i) {
            String string2;
            uok uok2;
            iom iom2 = this.irb(i);
            boolean bl = this.iqw[i] < 0;
            float f5 = this.x + fArray[i];
            float f6 = this.y + fArray2[i];
            if (!this.ird(i).equals(string)) {
                string = this.ird(i);
                irr.SMALL.draw(drawContext, iqp.ire(string).toUpperCase(Locale.ROOT), this.x, irr.SMALL.centerTop(f6 - 6.5f), iov.textMuted);
            }
            float f7 = this.iqx[i].step(hlc2.canHover() && irr.inside(f, f2, f5, f6, f4, 37.0f), f3);
            float f8 = this.iqy[i].step(this.irc(i).equals(iov.PRESET.get()), f3);
            float f9 = f6 - f7;
            float f10 = iov.r(5.0f);
            int[] nArray = iom2.accent();
            if (f8 > 0.01f) {
                uut.shadow(drawContext, f5, f9, f4, 27.0f, f10, 7.0f, iov.accent((int)(70.0f * f8)));
            }
            uok uok3 = uok2 = (string2 = iov.wallpaperOf(iom2.name())) != null ? iqp.iri(string2) : null;
            if (uok2 != null) {
                uut.image(drawContext, uok2.view, f5, f9, f4, 27.0f, f10, -1);
                uut.round(drawContext, f5, f9, f4, 27.0f, f10, ujt.withAlpha(iom2.color(0), 70));
            } else if (iom2.isGlass()) {
                uok uok4 = iqp.irj();
                if (uok4 != null) {
                    uut.image(drawContext, uok4.view, f5, f9, f4, 27.0f, f10, -1);
                } else {
                    uut.gradient(drawContext, f5, f9, f4, 27.0f, f10, -10842642, -4160260, -757066, -13058568);
                }
                uut.round(drawContext, f5, f9, f4, 27.0f, f10, ujt.withAlpha(iom2.color(0), Math.round(204.0f * iom2.tintScale())));
            } else {
                uut.round(drawContext, f5, f9, f4, 27.0f, f10, ujt.withAlpha(iom2.color(0), 255));
            }
            float f11 = f4 * 0.3f;
            uut.round(drawContext, f5, f9, f11, 27.0f, f10, 0.0f, 0.0f, f10, iom2.color(1));
            uut.round(drawContext, f5 + 3.0f, f9 + 5.0f, f11 - 6.0f, 4.0f, 1.5f, ujt.withAlpha(nArray[0], 200));
            uut.round(drawContext, f5 + 3.0f, f9 + 11.0f, f11 - 8.0f, 2.5f, 1.2f, ujt.withAlpha(iom2.color(10), 160));
            uut.round(drawContext, f5 + 3.0f, f9 + 16.0f, f11 - 9.0f, 2.5f, 1.2f, ujt.withAlpha(iom2.color(10), 160));
            float f12 = f5 + f11 + 3.0f;
            float f13 = (f4 - f11 - 9.0f) * 0.5f;
            int n = ujt.withAlpha(iom2.color(2), Math.max(60, ujt.alpha(iom2.color(2))));
            uut.round(drawContext, f12, f9 + 5.0f, f13, 17.0f, 2.0f, n);
            uut.round(drawContext, f12 + f13 + 3.0f, f9 + 5.0f, f13, 10.200001f, 2.0f, n);
            uut.round(drawContext, f12 + 2.5f, f9 + 8.0f, f13 - 5.0f, 2.0f, 1.0f, ujt.withAlpha(iom2.color(8), 150));
            uut.gradientH(drawContext, f12 + f13 - 7.0f, f9 + 12.0f, 5.0f, 3.0f, 1.5f, nArray[0], nArray[1]);
            uut.outline(drawContext, f5, f9, f4, 27.0f, f10, 1.0f, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, f7 * 0.5f), iov.accent(), f8));
            if (bl) {
                vjf.draw(drawContext, vhz.PENCIL, f5 + f4 - 6.0f, f9 + 27.0f - 6.0f, 6.5f, iom2.light() ? -1340071896 : -788529153);
            } else if (iom2.isGlass()) {
                vjf.draw(drawContext, vhz.GLASS, f5 + f4 - 6.0f, f9 + 27.0f - 6.0f, 6.5f, iom2.light() ? -1340071896 : -788529153);
            }
            if (f7 > 0.5f) {
                hlc2.hint(bl ? wap.s(a.d("\u2eaa\u572d\uddf8\u438e\uc842\u4ef1\uf4ef\u7d1e\ue3d6\u69f0\uee23\u140b\u9aca\u0361\u8935\u0f96\ub59a\u3a47\ua0f7\u26a5\uaf48\ud51e\u5bac\uc022\u4651\uccc5\u7577\ufb2b\u61c1\ue7c4\u6c23\u92ee\u18ac\u8155\u074b\u8db3\u3263\ub85c\u3eec\ua76b\u2d32\u53c4\ud98c\u5e3f\uc4a5\u4a80\uf34f\u79f3\uffb4\u646d", -247795965, 1082507736), a.b("\u9b56\ue2f4\u682b\uf62b\u7993\uff22\u45e6\ucc80\u52df\udc7c\u5bad\ua1a4\u2f03\ub2aa\u3c9f\uba1aR\u8ff4\u1535\u9778\u1e83\u60ce\uee74\u75ad\uf3a0\u7970\uc0cf\u4e9d\ud464\u565a\ud9fb\u2338\ua9fc\u3487\ub2c7\u387a\u87dc\u09c2\u8b73\u12b5\u98e3\ue61e\u68c6", 1866243932)) : (string2 != null ? iov.shownName(iom2.name()) + wap.s(a.d("\u3dc9\u4478\uce3c\u50da\udb0d\u5deb\ue7a6\u6e4a\uf009\u7af0\ufd77\u071a\u89c0\u1034\u9a26\u1cd8\ua690\u2945\ub3fa\u35be\ubc58\uc608\u48ff\ud348\u551d\udfcf\u6664\ue862\u72d9\uf48b\u7f30\u81e9\u0be9\u925a\u140e\u9eb2\u2164\uab12\u2dcb\ub43e\u3e35\u40d8\uca86\u4d72\ud7f2\u599d\ue049\u6af2\uecb6\u777f", 1520162173, 1903290534), a.c(-202789497, "\uad83\ud432\u5e76\uc090\u4b47\uc997\u77a5\ufa42\u6413\ueea8\u6902\u9304\u19cf\u8465\u0e33\u88cf\u328d\ubd20\u27e9\ua1bf\u2849\u521a\ud8b5\u4302\uc557\u4f85\uf62e\u7828\ue6c8\u609e\uef3d\u15f2\u9fb9\u064f\u801f\u0aac")) : iov.shownName(iom2.name()) + (iom2.isGlass() ? wap.s(a.c(-727182446, "\u139f\u6a2e\ue06a\u7e8c\uf55b\u73ad\uc9f5\u4009\ude44\u54f5\ud375\u2950\ua79b\u3e27\ub47c\u3285\u8895\u075e\u9db9\u1bf4\u920e\ue81a\u66fe\ufd39\u7b4b\uf19a\u4835\uc675\u5c93\udad7\u5173\uaff0\u25ec\ubc06\u3a52\ub0fb\u0f28\u850a\u038d\u9a20\u1065\u6e89\ue4c0\u6363\uf9bb"), a.c(-1793822763, "\u6fd2\u1663\u9c27\u02c1\u8916\u0bc6\ub196\u3810\ua640\u2cf0\uab57\u5154\udf83\u463f\ucc13\u4e8d\uf0a0\u7f06\ue5bc\u63e1\uee1c\u9457\u1efa\u8524\u0354\u8983\u3428\ube66\u24ee\ua2c1\u290d\ud7af\u5de7\uc464\u4248\uc8f3\u7726\ufd29\u7bf6")) : "")));
            }
            if (f8 > 0.02f) {
                float f14 = f5 + f4 - 5.5f;
                float f15 = f9 + 5.5f;
                float f16 = vcq.outBack(f8);
                uut.pushAlpha(f8);
                drawContext.getMatrices().pushMatrix();
                drawContext.getMatrices().translate(f14, f15);
                drawContext.getMatrices().scale(f16, f16);
                uut.circle(drawContext, 0.0f, 0.0f, 3.8f, iov.accent());
                vjf.draw(drawContext, vhz.CHECK, 0.0f, 0.0f, 5.5f, iov.onAccent());
                drawContext.getMatrices().popMatrix();
                uut.popAlpha();
            }
            irr.SMALL.drawCentered(drawContext, irr.SMALL.ellipsize(iov.shownName(this.irc(i)), f4), f5 + f4 * 0.5f, irr.SMALL.centerTop(f6 + 27.0f + 5.0f + 1.0f), ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, f7), iov.text, f8));
        }
    }

    private static uok iri(String string) {
        isn isn2 = isv.find(string);
        return isn2 == null ? null : isv.thumbnail(isn2);
    }

    private static uok irj() {
        isn isn2 = isv.find(isv.selected());
        return isn2 == null || isn2.isWorld() ? null : isv.thumbnail(isn2);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float[] fArray = new float[this.iqw.length];
        float[] fArray2 = new float[this.iqw.length];
        this.irh(fArray, fArray2);
        float f3 = this.irg();
        for (int i = 0; i < this.iqw.length; ++i) {
            if (!irr.inside(f, f2, this.x + fArray[i], this.y + fArray2[i], f3, 37.0f)) continue;
            iov.choose(this.irc(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int ait(int n, int n2) {
        return n ^ n2 ^ 0xAF26D433;
    }
}

