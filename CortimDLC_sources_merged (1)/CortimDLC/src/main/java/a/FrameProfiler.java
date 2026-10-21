/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
 */
package a;

import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;

public final class FrameProfiler {
    public static final boolean ON = Boolean.getBoolean("flow2.prof");
    public static boolean variant;
    private static final Map<String, long[]> gsl;
    private static long gsm;
    private static /* synthetic */ String gsn;
    private static /* synthetic */ String gso;

    private FrameProfiler() {
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
        return (class_3322, class_97792) -> {
            long l = System.nanoTime();
            hudElement.render(class_3322, class_97792);
            FrameProfiler.add("hud " + string, System.nanoTime() - l);
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
        StringBuilder stringBuilder = new StringBuilder("prof " + string + " (" + gsm + " frames, us/frame):");
        for (Map.Entry entry3 : arrayList) {
            double d2 = (double)((long[])entry3.getValue())[0] / 1000.0 / (double)l;
            d += d2;
            if (!(d2 >= 1.0)) continue;
            stringBuilder.append(String.format(Locale.ROOT, "%n    %8.1f  %s", d2, entry3.getKey()));
        }
        stringBuilder.append(String.format(Locale.ROOT, "%n    %8.1f  total", d));
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

