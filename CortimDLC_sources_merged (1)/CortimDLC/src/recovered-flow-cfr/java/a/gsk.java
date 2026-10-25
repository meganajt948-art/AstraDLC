/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
 */
package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;

public final class gsk {
    public static final boolean ON = Boolean.getBoolean(a.b("\ufd3e\u8485\u0e55\u903c\u1bae\u9d03\u270e\uaefd\u30bf\uba07", -4784814));
    public static boolean variant;
    private static final Map<String, long[]> gsl;
    private static long gsm;
    private static /* synthetic */ String gsn;
    private static /* synthetic */ String gso;

    private gsk() {
    }

    public static void add(String string2, long l) {
        long[] lArray = gsl.computeIfAbsent(string2, string -> new long[1]);
        lArray[0] = lArray[0] + l;
    }

    public static void frame() {
        ++gsm;
    }

    public static HudElement wrap(String string, HudElement hudElement) {
        if (!ON) {
            return hudElement;
        }
        return (drawContext, renderTickCounter) -> {
            long l = System.nanoTime();
            hudElement.render(drawContext, renderTickCounter);
            gsk.add(a.c(-1578954354, "\u11e2\u684e\ue28c\u7cb9") + string, System.nanoTime() - l);
        };
    }

    public static void reset() {
        gsl.clear();
        gsm = 0L;
    }

    public static void report(String string) {
        if (!ON) {
            return;
        }
        ArrayList<Map.Entry<String, long[]>> arrayList = new ArrayList<Map.Entry<String, long[]>>(gsl.entrySet());
        arrayList.sort((entry, entry2) -> Long.compare(((long[])entry2.getValue())[0], ((long[])entry.getValue())[0]));
        long l = Math.max(1L, gsm);
        double d = 0.0;
        StringBuilder stringBuilder = new StringBuilder(a.b("\u9218\uebab\u6165\uff1d\u748c", -1508208019) + string + a.b("\ud116\ua8af", 1367396660) + gsm + a.d("\u5f9c\u266b\uacac\u32ce\ub915\u3fac\u85e9\u0c47\u9214\u18f0\u9f25\u6508\ueb96\u7233\uf873\u7e8e\uc4c9\u4b54\ud1f4", 1109548860, 809959571));
        for (Map.Entry entry3 : arrayList) {
            double d2 = (double)((long[])entry3.getValue())[0] / 1000.0 / (double)l;
            d += d2;
            if (!(d2 >= 1.0)) continue;
            stringBuilder.append(String.format(Locale.ROOT, a.d("\u0930\u70ca\ufa57\u6426\ueff1\u6940\ud316\u5afa\uc4b3\u4e1d\uc999\u33ae\ubd79\u24cd\uaec8", 644798038, 55500620), d2, entry3.getKey()));
        }
        stringBuilder.append(String.format(Locale.ROOT, a.c(1241336930, "\u4c55\u35af\ubf32\u2143\uaa94\u2c25\u9673\u1f9f\u81d6\u0b78\u8cfc\u76cb\uf81c\u61f9\uebb1\u6d5b\ud701\u58dd"), d));
        System.out.println(stringBuilder);
    }

    static {
        gsl = new LinkedHashMap<String, long[]>();
    }

    private static /* synthetic */ int wq(int n, int n2) {
        return n * n2 ^ 0x7D5836EC;
    }

    private static /* synthetic */ int wr(int n, int n2) {
        return n - n2 + 964356530;
    }
}

