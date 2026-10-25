/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.iov;
import a.izx;
import a.jeq;
import a.jfn;
import a.ney;
import a.nfl;
import a.qwj;
import a.ujt;
import a.uut;
import a.vhz;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

public final class jfw
extends jeq<jfn> {
    private static final float jfx = 12.0f;
    private static final int jfy = -4932924;
    private static final int jfz = -4160260;
    private static final int jga = -278748;
    private static /* synthetic */ int jgb;
    private static /* synthetic */ boolean jgc;

    jfw() {
        super(a.c(-1080403275, "\u5add\u2368\ua9bc\u37c6\ubc07"), a.b("\u4ff6\u3663\ubcb7\u22cd\ua90c", -1290252354), vhz.CLOCK, true, 2, 1, 6.0f, 0.0f);
    }

    @Override
    List<jfn> items(boolean bl) {
        ArrayList<jfn> arrayList = new ArrayList<jfn>();
        String string = nfl.hudStatus();
        if (string == null) {
            if (bl) {
                long l = System.currentTimeMillis();
                arrayList.add(new jfn(a.c(-1486869909, "\u2a1e\u53a8\ud96e\u470a\uccdc\u4a6b"), wap.s(a.d("\ud710\uae97\u244c\uba20\u31ea\ub75c\u0d06\u84b0\u1aa9\u9011\u17df\uedfc\u6346\ufac3\u709d\uf670\u4c3e\uc3e5\u5915\udfd3\u56b3\u2cf2\ua24b\u3991\ubfe6", -616192624, -584813874), a.d("\u6b0d\u129e\u983a\u0228\u8dc3\u0b56\ub179\u38f4\ua6d4\u2c17\uabb0\u51ba\udf67\u46a9\uc895\u4ef3\uf42b\u7bea\ue153\u6709\ueef6", 384601243, -2132417643)), 0, null, 0L, false));
                arrayList.add(new jfn(a.b("\uec98\u9528\u1ff3", -1853494102), null, 108, qwj.MYTHIC, l + 19000L, true));
                arrayList.add(new jfn(a.c(-1543425592, "\u31fa\u484b\uc29b"), null, 112, qwj.LEGENDARY, l + 95000L, false));
                arrayList.add(new jfn(a.c(956041969, "\u0ac3\u7373\uf9a9"), null, 109, qwj.COMMON, l + 141000L, false));
            }
            return arrayList;
        }
        arrayList.add(new jfn(a.d("\u69d5\u1063\u9aa5\u04c1\u8f17\u09a0", 1598294290, 1359700146), string, 0, null, 0L, false));
        for (ney ney2 : nfl.hudRows()) {
            arrayList.add(new jfn(String.valueOf(ney2.id()), null, ney2.id(), ney2.tier(), ney2.refreshAt(), ney2.focus()));
        }
        return arrayList;
    }

    @Override
    String key(jfn jfn2) {
        return jfn2.jfo;
    }

    @Override
    float rowHeight() {
        return 12.0f;
    }

    @Override
    long refreshNanos() {
        return 250000000L;
    }

    @Override
    float rowWidth(jfn jfn2) {
        if (jfn2.jfp != null) {
            return 8.0f + izx.TEXT.width(jfn2.jfp);
        }
        return 8.0f + izx.TEXT.width(a.d("\u5d21\u2490\uae43", 2038937710, 526640508)) + 8.0f + izx.TEXT.width(wap.value(jfn2.jfr.title())) + 14.0f + izx.VALUE.width(a.c(-1802246097, "\ue81a\u91ab\u1b72\u8509\u0ede"));
    }

    @Override
    void drawRow(DrawContext drawContext, jfn jfn2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 + f4 * 0.5f;
        if (jfn2.jfp != null) {
            uut.circle(drawContext, f + 1.8f, f7, 1.7f, iov.accent());
            izx.TEXT.draw(drawContext, izx.TEXT.ellipsize(jfn2.jfp, f3 - 8.0f), f + 7.0f, izx.TEXT.centerTop(f7), iov.text);
            return;
        }
        if (jfn2.jft) {
            uut.shadow(drawContext, f - 0.2f, f7 - 2.0f, 4.0f, 4.0f, 2.0f, 3.0f, iov.accent(90));
            uut.circle(drawContext, f + 1.8f, f7, 1.7f, iov.accent());
        }
        String string = String.valueOf(jfn2.jfq);
        float f8 = f + 7.0f;
        izx.TEXT.draw(drawContext, string, f8, izx.TEXT.centerTop(f7), jfn2.jft ? iov.text : iov.textDim);
        f8 += izx.TEXT.width(a.b("\udffb\ua64a\u2c99", 2063917000)) + 8.0f;
        int n = switch (jfn2.jfr) {
            case qwj.LEGENDARY -> -278748;
            case qwj.MYTHIC -> -4160260;
            default -> -4932924;
        };
        izx.TEXT.draw(drawContext, wap.value(jfn2.jfr.title()), f8, izx.TEXT.centerTop(f7), n);
        long l = jfn2.jfs - System.currentTimeMillis();
        String string2 = l > 0L ? nfl.clock(l) : wap.s(a.c(318425386, "\uc947\ub0f7\u3a3c"), a.c(-346669913, "\u38e0\u4125\ucbfa\u55f5\ude55\u5895"));
        int n2 = jfw.expiring(jfn2.jft ? iov.text : ujt.lerp(iov.textDim, iov.text, 0.4f), (float)l / 1000.0f);
        izx.VALUE.draw(drawContext, string2, f + f3 - izx.VALUE.width(string2), izx.VALUE.centerTop(f7), n2);
    }

    private static /* synthetic */ int anb(int n, int n2) {
        return n * n2 + 1479854141;
    }

    private static /* synthetic */ int anc(int n, int n2) {
        return jfw.anb(n, n2) ^ 0x8CE21767;
    }

    private static /* synthetic */ int and(int n, int n2) {
        return jfw.anc(n, n2) + n;
    }
}

