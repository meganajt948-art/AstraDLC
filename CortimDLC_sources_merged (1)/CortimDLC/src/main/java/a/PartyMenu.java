/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
import java.util.List;
import java.util.Random;

final class PartyMenu {
    static final int RATE = 44100;
    static final List<String> CUES = List.of("Ping", "Danger", "Lock", "Unping", "Invite", "Join");
    private static /* synthetic */ int vqv;
    private static /* synthetic */ int vqw;

    private PartyMenu() {
    }

    /*
     * Exception decompiling
     */
    static float[] cue(String var0) {
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

    private static float[] vqx() {
        float[] fArray = PartyMenu.vrh(0.7);
        PartyMenu.vrn(fArray, 0.0, 5400.0, 2.2, 0.22, 2.0E-4, 0.0018, 61L);
        PartyMenu.vrj(fArray, 0.0, 2349.32, 0.12, 4.0E-4, 0.012, 0.0);
        PartyMenu.vre(fArray, 0.004, 1174.66, 0.62, 0.11);
        PartyMenu.vre(fArray, 0.062, 1760.0, 0.95, 0.2);
        PartyMenu.vrj(fArray, 0.062, 3520.0, 0.05, 0.002, 0.08, 0.6);
        return PartyMenu.vrr(PartyMenu.vrp(fArray, 0.2, 0.7), 0.5);
    }

    private static float[] vqy() {
        float[] fArray = PartyMenu.vrh(0.8);
        double[] dArray = new double[]{1396.91, 1046.5, 1396.91};
        for (int i = 0; i < dArray.length; ++i) {
            double d = (double)i * 0.092;
            PartyMenu.vrk(fArray, d, dArray[i], 2.0, 1.3, 0.75, 0.0015, 0.052 + 0.02 * (double)i);
            PartyMenu.vrj(fArray, d, dArray[i] * 0.5, 0.18, 0.002, 0.04, 0.0);
            PartyMenu.vrn(fArray, d, 4200.0, 2.0, 0.12, 2.0E-4, 0.0015, 71 + i);
        }
        PartyMenu.vrl(fArray, 0.0, 210.0, 95.0, 0.035, 0.42, 0.0015, 0.06, 0.0);
        return PartyMenu.vrr(PartyMenu.vrp(fArray, 0.16, 0.55), 0.55);
    }

    private static float[] vqz() {
        float[] fArray = PartyMenu.vrh(0.6);
        PartyMenu.vrl(fArray, 0.0, 640.0, 1900.0, 0.018, 0.5, 0.0012, 0.045, 0.12);
        PartyMenu.vrg(fArray, 0.058, 4300.0, 6600.0, 0.55, 0.0012, 81L);
        PartyMenu.vre(fArray, 0.058, 1567.98, 0.75, 0.15);
        PartyMenu.vrj(fArray, 0.058, 3135.96, 0.08, 0.001, 0.05, 0.3);
        return PartyMenu.vrr(PartyMenu.vrp(fArray, 0.15, 0.5), 0.5);
    }

    private static float[] vra() {
        float[] fArray = PartyMenu.vrh(0.3);
        PartyMenu.vrl(fArray, 0.0, 1320.0, 640.0, 0.028, 0.7, 0.0015, 0.045, 0.08);
        PartyMenu.vrn(fArray, 0.0, 3000.0, 2.0, 0.12, 2.0E-4, 0.002, 91L);
        return PartyMenu.vrr(PartyMenu.vrp(fArray, 0.1, 0.3), 0.42);
    }

    private static float[] vrb() {
        float[] fArray = PartyMenu.vrh(1.0);
        double[] dArray = new double[]{1046.5, 1318.51, 1567.98};
        for (int i = 0; i < dArray.length; ++i) {
            double d = (double)i * 0.085;
            PartyMenu.vre(fArray, d, dArray[i], 0.7 + 0.1 * (double)i, 0.24);
            PartyMenu.vrd(fArray, d, dArray[i] * 0.5, 0.3, 0.1);
        }
        return PartyMenu.vrr(PartyMenu.vrp(fArray, 0.22, 0.8), 0.5);
    }

    private static float[] vrc() {
        float[] fArray = PartyMenu.vrh(0.8);
        PartyMenu.vre(fArray, 0.0, 1046.5, 0.7, 0.16);
        PartyMenu.vre(fArray, 0.075, 1567.98, 0.9, 0.24);
        PartyMenu.vrm(fArray, 0.0, 0.12, 2600.0, 4400.0, 2.0, 0.04, 0.03, 97L);
        return PartyMenu.vrr(PartyMenu.vrp(fArray, 0.2, 0.7), 0.48);
    }

    private static void vrd(float[] fArray, double d, double d2, double d3, double d4) {
        PartyMenu.vrj(fArray, d, d2, d3, 0.0015, d4, 0.0);
        PartyMenu.vrj(fArray, d, d2 * 3.93, d3 * 0.22, 0.001, 0.028, 0.6);
        PartyMenu.vrj(fArray, d, d2 * 9.2, d3 * 0.05, 6.0E-4, 0.008, 1.2);
        PartyMenu.vrn(fArray, d, d2 * 2.0, 1.5, d3 * 0.4, 6.0E-4, 0.002, (long)d2);
    }

    private static void vre(float[] fArray, double d, double d2, double d3, double d4) {
        PartyMenu.vrj(fArray, d, d2, d3 * 0.8, 0.006, d4, 0.0);
        PartyMenu.vrj(fArray, d, d2 * 1.0017, d3 * 0.2, 0.006, d4 * 1.2, 1.1);
        PartyMenu.vrj(fArray, d, d2 * 2.0, d3 * 0.14, 0.004, d4 * 0.35, 0.4);
        PartyMenu.vrj(fArray, d, d2 * 3.0, d3 * 0.04, 0.003, d4 * 0.15, 2.2);
    }

    private static void vrf(float[] fArray, double d, double d2, double d3, long l) {
        PartyMenu.vrn(fArray, d, d2, 6.0, d3, 3.0E-4, 0.018, l);
        PartyMenu.vrj(fArray, d, d2, d3 * 0.35, 5.0E-4, 0.03, 0.0);
        PartyMenu.vrj(fArray, d, d2 * 2.76, d3 * 0.08, 4.0E-4, 0.01, 0.7);
        PartyMenu.vrj(fArray, d, d2 * 0.5, d3 * 0.1, 0.001, 0.02, 0.3);
    }

    private static void vrg(float[] fArray, double d, double d2, double d3, double d4, double d5, long l) {
        PartyMenu.vrn(fArray, d, d2, 4.0, d4, 1.0E-4, d5, l);
        PartyMenu.vrn(fArray, d, d3, 5.0, d4 * 0.6, 1.0E-4, d5 * 0.7, l + 1L);
        PartyMenu.vrj(fArray, d, d2, d4 * 0.25, 2.0E-4, d5 * 1.5, 0.0);
    }

    private static float[] vrh(double d) {
        return new float[(int)Math.ceil(d * 44100.0)];
    }

    private static double vri(double d, double d2) {
        return d2 <= 0.0 || d >= d2 ? 1.0 : 0.5 - 0.5 * Math.cos(Math.PI * d / d2);
    }

    private static void vrj(float[] fArray, double d, double d2, double d3, double d4, double d5, double d6) {
        if (d2 >= 19845.0) {
            return;
        }
        int n = (int)(d * 44100.0);
        int n2 = Math.min(fArray.length, n + (int)((d4 + d5 * 9.0) * 44100.0));
        double d7 = Math.PI * 2 * d2 / 44100.0;
        for (int i = n; i < n2; ++i) {
            double d8 = (double)(i - n) / 44100.0;
            int n3 = i;
            fArray[n3] = fArray[n3] + (float)(d3 * PartyMenu.vri(d8, d4) * Math.exp(-d8 / d5) * Math.sin(d7 * (double)(i - n) + d6));
        }
    }

    private static void vrk(float[] fArray, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        int n = (int)(d * 44100.0);
        int n2 = Math.min(fArray.length, n + (int)((d6 + d7 * 9.0) * 44100.0));
        double d8 = Math.PI * 2 * d2 / 44100.0;
        double d9 = d8 * d3;
        for (int i = n; i < n2; ++i) {
            double d10 = (double)(i - n) / 44100.0;
            double d11 = PartyMenu.vri(d10, d6) * Math.exp(-d10 / d7);
            double d12 = d4 * Math.exp(-d10 / (d7 * 0.35)) * Math.sin(d9 * (double)(i - n));
            int n3 = i;
            fArray[n3] = fArray[n3] + (float)(d5 * d11 * Math.sin(d8 * (double)(i - n) + d12));
        }
    }

    private static void vrl(float[] fArray, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        int n = (int)(d * 44100.0);
        int n2 = Math.min(fArray.length, n + (int)((d6 + d7 * 9.0) * 44100.0));
        double d9 = 0.0;
        int n3 = n;
        while (n3 < n2) {
            double d10 = (double)(n3 - n) / 44100.0;
            double d11 = d3 + (d2 - d3) * Math.exp(-d10 / d4);
            double d12 = PartyMenu.vri(d10, d6) * Math.exp(-d10 / d7);
            int n4 = n3++;
            fArray[n4] = fArray[n4] + (float)(d5 * d12 * (Math.sin(d9 += Math.PI * 2 * d11 / 44100.0) + d8 * Math.sin(2.0 * d9)));
        }
    }

    private static void vrm(float[] fArray, double d, double d2, double d3, double d4, double d5, double d6, double d7, long l) {
        Random random = new Random(l);
        int n = (int)(d * 44100.0);
        int n2 = Math.min(fArray.length - n, (int)((d2 + d7) * 44100.0));
        double d8 = 0.0;
        double d9 = 0.0;
        double d10 = 0.0;
        double d11 = 0.0;
        for (int i = 0; i < n2; ++i) {
            double d12 = (double)i / 44100.0;
            double d13 = Math.min(1.0, d12 / d2);
            double d14 = d3 * Math.pow(d4 / d3, d13);
            double d15 = Math.PI * 2 * d14 / 44100.0;
            double d16 = Math.sin(d15) / (2.0 * d5);
            double d17 = 1.0 + d16;
            double d18 = d16 / d17;
            double d19 = -2.0 * Math.cos(d15) / d17;
            double d20 = (1.0 - d16) / d17;
            double d21 = Math.sin(Math.PI * Math.min(1.0, d12 / (d2 + d7)));
            double d22 = (random.nextDouble() * 2.0 - 1.0) * d21 * d21;
            double d23 = d18 * d22 - d18 * d9 - d19 * d10 - d20 * d11;
            d9 = d8;
            d8 = d22;
            d11 = d10;
            d10 = d23;
            int n3 = n + i;
            fArray[n3] = fArray[n3] + (float)(d6 * d23);
        }
    }

    private static void vrn(float[] fArray, double d, double d2, double d3, double d4, double d5, double d6, long l) {
        if (d2 >= 19845.0) {
            return;
        }
        Random random = new Random(l);
        double d7 = Math.PI * 2 * d2 / 44100.0;
        double d8 = Math.sin(d7) / (2.0 * d3);
        double d9 = 1.0 + d8;
        double d10 = d8 / d9;
        double d11 = -2.0 * Math.cos(d7) / d9;
        double d12 = (1.0 - d8) / d9;
        double d13 = 0.0;
        double d14 = 0.0;
        double d15 = 0.0;
        double d16 = 0.0;
        int n = (int)(d * 44100.0);
        int n2 = Math.min(fArray.length, n + (int)((d5 + d6 * 8.0) * 44100.0) + 176);
        int n3 = n;
        while (n3 < n2) {
            double d17 = (double)(n3 - n) / 44100.0;
            double d18 = (random.nextDouble() * 2.0 - 1.0) * PartyMenu.vri(d17, d5) * Math.exp(-d17 / d6);
            double d19 = d10 * d18 - d10 * d14 - d11 * d15 - d12 * d16;
            d14 = d13;
            d13 = d18;
            d16 = d15;
            d15 = d19;
            int n4 = n3++;
            fArray[n4] = fArray[n4] + (float)(d4 * d19);
        }
    }

    private static void vro(float[] fArray, double d) {
        double d2 = Math.PI * 2 * d / 44100.0;
        double d3 = Math.sin(d2) / 1.4142;
        double d4 = Math.cos(d2);
        double d5 = 1.0 + d3;
        double d6 = (1.0 - d4) / 2.0 / d5;
        double d7 = (1.0 - d4) / d5;
        double d8 = -2.0 * d4 / d5;
        double d9 = (1.0 - d3) / d5;
        double d10 = 0.0;
        double d11 = 0.0;
        double d12 = 0.0;
        double d13 = 0.0;
        for (int i = 0; i < fArray.length; ++i) {
            double d14 = fArray[i];
            double d15 = d6 * d14 + d7 * d10 + d6 * d11 - d8 * d12 - d9 * d13;
            d11 = d10;
            d10 = d14;
            d13 = d12;
            d12 = d15;
            fArray[i] = (float)d15;
        }
    }

    private static float[] vrp(float[] fArray, double d, double d2) {
        double d3;
        int n;
        double[] dArray;
        PartyMenu.vrq(fArray, 0.06);
        float[] fArray2 = new float[fArray.length + (int)(d2 * 0.8 * 44100.0)];
        double[] dArray2 = new double[fArray2.length];
        for (double d4 : dArray = new double[]{29.7, 37.1, 41.1, 43.7}) {
            n = (int)(d4 * 44100.0 / 1000.0);
            double d5 = Math.pow(10.0, -3.0 * (double)n / (d2 * 44100.0));
            float[] fArray3 = new float[n];
            d3 = 0.0;
            int n2 = 0;
            int n3 = 0;
            while (n2 < fArray2.length) {
                double d6 = n2 < fArray.length ? (double)fArray[n2] : 0.0;
                double d7 = fArray3[n3];
                d3 = d7 * 0.65 + d3 * 0.35;
                fArray3[n3] = (float)(d6 + d3 * d5);
                int n4 = n2++;
                dArray2[n4] = dArray2[n4] + d7 * 0.25;
                n3 = (n3 + 1) % n;
            }
        }
        for (double d4 : new double[]{5.0, 1.7}) {
            n = (int)(d4 * 44100.0 / 1000.0);
            double[] dArray3 = new double[n];
            int n5 = 0;
            for (int i = 0; i < fArray2.length; ++i) {
                d3 = dArray3[n5];
                double d8 = dArray2[i] + 0.7 * d3;
                dArray2[i] = d3 - 0.7 * d8;
                dArray3[n5] = d8;
                n5 = (n5 + 1) % n;
            }
        }
        for (int i = 0; i < fArray2.length; ++i) {
            fArray2[i] = (float)((i < fArray.length ? (double)fArray[i] : 0.0) + d * dArray2[i]);
        }
        PartyMenu.vrq(fArray2, 0.03);
        return fArray2;
    }

    private static void vrq(float[] fArray, double d) {
        int n = Math.min(fArray.length, (int)(d * 44100.0));
        for (int i = 0; i < n; ++i) {
            int n2 = fArray.length - 1 - i;
            fArray[n2] = fArray[n2] * (float)((double)i / (double)n);
        }
    }

    private static float[] vrr(float[] fArray, double d) {
        float f = 0.0f;
        for (float f2 : fArray) {
            f = Math.max(f, Math.abs(f2));
        }
        if (f > 0.0f) {
            float f3 = (float)(d / (double)f);
            int n = 0;
            while (n < fArray.length) {
                int n2 = n++;
                fArray[n2] = fArray[n2] * f3;
            }
        }
        return fArray;
    }

    private static /* synthetic */ int djp(int n, int n2) {
        return n * n2 ^ 0xE6E35FE7;
    }

    private static /* synthetic */ int djq(int n, int n2) {
        return PartyMenu.djp(n, n2) * n2;
    }
}

