/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1439
 *  net.minecraft.class_1802
 *  net.minecraft.class_243
 *  net.minecraft.class_2616
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_746
 *  net.minecraft.class_8143
 */
package a;

import a.flj;
import a.PacketHooks;
import flow.dev.StringDecryptor;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1439;
import net.minecraft.class_1802;
import net.minecraft.class_243;
import net.minecraft.class_2616;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_746;
import net.minecraft.class_8143;

final class AimPatternTest {
    private static final int fln = 400;
    private static final int flo = 60;
    private static final String[] flp = new String[]{"steady", "steady+run", "flick60", "flick100", "snap", "snap+run", "glance"};
    private static final int[] flq = AimPatternTest.fng();
    private static final int flr = flq.length;
    private static final int fls = 23;
    private static final int flt = 4;
    private static final boolean flu = System.getenv("FLOW2_CRIT_SWEEP") != null;
    private static final int[] flv = new int[]{4, 6, 10, 16, 6};
    private static final int flw = 300;
    private static final int flx = 80;
    private static final ConcurrentLinkedQueue<flj> fly = new ConcurrentLinkedQueue();
    private static volatile flj flz;
    private static volatile int fma;
    private static volatile boolean fmb;
    private static volatile int fmc;
    private static volatile int fmd;
    private static boolean fme;
    private static boolean fmf;
    private static final int[] fmg;
    private static final int[] fmh;
    private static final int[] fmi;
    private static final int[] fmj;
    private static final boolean[] fmk;
    private static final int[] fml;
    private static final int[] fmm;
    private static final int[] fmn;
    private static final int[] fmo;
    private static int fmp;
    private static int fmq;
    private static int fmr;
    private static int fms;
    private static int fmt;
    private static int fmu;
    private static double fmv;
    private static double fmw;
    private static double fmx;
    private static float fmy;
    private static boolean fmz;
    private static int fna;
    private static int fnb;
    private static int fnc;
    private static final Random fnd;
    private static /* synthetic */ boolean fne;
    private static /* synthetic */ int fnf;

    private AimPatternTest() {
    }

    static boolean crit(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (AimPatternTest.fni(class_3102, false)) {
            return fmu == -1;
        }
        int n = (fmu - 60) / 400;
        int n2 = (fmu - 60) % 400;
        int n3 = n < flr ? flq[n] : -1;
        fmc = n3 >= 0 ? n3 : 15;
        AimPatternTest.fnl();
        if (n3 < 0) {
            AimPatternTest.fnn(class_3102);
            int n4 = 0;
            int n5 = 0;
            for (int n6 : flq) {
                System.out.println("crit test phase " + flp[n6] + ": attacks=" + fmg[n6] + " crits=" + fmh[n6] + " (packets: hits=" + fml[n6] + " crits=" + fmm[n6] + ")");
                n4 += fmg[n6];
                n5 += fmh[n6];
            }
            if (flu) {
                for (int i = 5; i <= 10; ++i) {
                    System.out.println("crit sweep jump tick +" + i + ": tries=" + fmn[i] + " crits=" + fmo[i]);
                }
            }
            System.out.println("crit test RESULT attacks=" + n4 + " crits=" + n5 + " non-crits=" + (n4 - n5));
            if (fmq > 0) {
                System.out.println("crit test glance: glances=" + fmq + " hit=" + fmr);
            }
            return true;
        }
        boolean bl = n3 == 1 || n3 == 3 || n3 == 5;
        class_3102.field_1690.field_1903.method_23481(true);
        class_3102.field_1690.field_1894.method_23481(bl);
        float f = switch (n3) {
            case 2 -> 60.0f * class_3532.method_15374((double)((float)n2 * ((float)Math.PI * 2) / 12.0f));
            case 3 -> 100.0f * class_3532.method_15374((double)((float)n2 * ((float)Math.PI * 2) / 8.0f));
            case 4, 5 -> {
                if (n2 % 3 == 0) {
                    fmy = fnd.nextFloat() < 0.5f ? 0.0f : (float)(fnd.nextBoolean() ? 1 : -1) * (40.0f + fnd.nextFloat() * 120.0f);
                }
                yield fmy;
            }
            case 6 -> {
                int var7_11 = n2 % 23;
                if (var7_11 == 0) {
                    if (fmt >= 0 && fmg[6] > fms) {
                        ++fmr;
                    }
                    ++fmq;
                    fmt = fmu;
                    fms = fmg[6];
                }
                if (var7_11 < 4) {
                    yield 0.0f;
                }
                yield 90.0f;
            }
            default -> 0.0f;
        };
        AimPatternTest.fnk(class_7462, f);
        if (flu) {
            AimPatternTest.fnm(class_3102, class_7462);
        }
        return false;
    }

    static boolean mace(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (AimPatternTest.fni(class_3102, true)) {
            return fmu == -1;
        }
        AimPatternTest.fnl();
        AimPatternTest.fnk(class_7462, 0.0f);
        if (fmu < 140) {
            fmc = 0;
            class_3102.field_1690.field_1903.method_23481(false);
        } else if (fmu < 290) {
            fmc = 1;
            class_3102.field_1690.field_1903.method_23481(true);
        } else if (fmu < 300) {
            fmc = 15;
            class_3102.field_1690.field_1903.method_23481(false);
        } else {
            boolean bl;
            int n = (fmu - 300) / 80;
            int n2 = (fmu - 300) % 80;
            if (n >= flv.length) {
                AimPatternTest.fnn(class_3102);
                AimPatternTest.fnh("ground", 0, false, false);
                AimPatternTest.fnh("jumping", 1, false, false);
                for (int i = 0; i < flv.length; ++i) {
                    AimPatternTest.fnh("drop " + flv[i] + (i == flv.length - 1 ? " uncharged" : ""), 2 + i, true, i != flv.length - 1);
                }
                System.out.println("mace test " + (fmp == 0 ? "PASS" : "FAIL (" + fmp + ")"));
                return true;
            }
            fmc = 2 + n;
            boolean bl2 = bl = n == flv.length - 1;
            if (n2 == 0) {
                if (bl) {
                    class_7462.method_31548().method_61496(1);
                }
                AimPatternTest.fnp(class_3102, String.format(Locale.ROOT, "tp @s %.2f %.2f %.2f -90 60", fmv - 1.3, fmw + (double)flv[n], fmx));
            } else if (n2 == 2 && bl) {
                class_7462.method_31548().method_61496(0);
            }
        }
        return false;
    }

    private static int[] fng() {
        String string = System.getenv("FLOW2_CRIT_ONLY");
        if (string == null) {
            int[] nArray = new int[flp.length];
            for (int i = 0; i < nArray.length; ++i) {
                nArray[i] = i;
            }
            return nArray;
        }
        String[] stringArray = string.split(",");
        int[] nArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            nArray[i] = Arrays.asList(flp).indexOf(stringArray[i].trim());
        }
        return nArray;
    }

    private static void fnh(String string, int n, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl ? fmg[n] >= 1 && fmi[n] == fmg[n] && fmj[n] == 0 && (!bl2 || fmk[n]) : (bl3 = fmg[n] == 0);
        if (!bl3) {
            ++fmp;
        }
        System.out.println("mace " + string + (bl3 ? " ok" : " FAIL") + ": attacks=" + fmg[n] + " smash=" + fmi[n] + " crit=" + fmh[n] + " firstCrit=" + fmk[n] + " intoIFrames=" + fmj[n] + " (want " + (bl ? "smash" + (bl2 ? " + crit first" : "") : "none") + ")");
    }

    private static boolean fni(class_310 class_3102, boolean bl) {
        class_746 class_7462 = class_3102.field_1724;
        fmf = bl;
        AimPatternTest.fnj();
        PacketHooks.ensure(class_3102);
        if (++fmu == 1) {
            int n = class_3532.method_15357((double)class_7462.method_23317());
            int n2 = class_3532.method_15357((double)class_7462.method_23318());
            int n3 = class_3532.method_15357((double)class_7462.method_23321());
            fmv = (double)n + 2.8;
            fmw = n2;
            fmx = (double)n3 + 0.5;
            AimPatternTest.fnp(class_3102, "gamemode survival");
            AimPatternTest.fnp(class_3102, "effect give @s resistance 900 4 true");
            AimPatternTest.fnp(class_3102, "effect give @s saturation 900 4 true");
            AimPatternTest.fnp(class_3102, "clear @s");
            AimPatternTest.fnp(class_3102, "kill @e[type=!player]");
            if (bl) {
                AimPatternTest.fnp(class_3102, "item replace entity @s hotbar.0 with minecraft:mace");
                AimPatternTest.fnp(class_3102, "item replace entity @s hotbar.1 with minecraft:diamond_sword");
            } else {
                AimPatternTest.fnp(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                AimPatternTest.fnp(class_3102, String.format(Locale.ROOT, "fill %d %d %d %d %d %d minecraft:stone hollow", n - 3, n2 - 1, n3 - 3, n + 4, n2 + 3, n3 + 3));
            }
            AimPatternTest.fnp(class_3102, String.format(Locale.ROOT, "tp @s %.1f %d %.1f -90 0", (double)n + 0.5, n2, (double)n3 + 0.5));
            AimPatternTest.fnp(class_3102, String.format(Locale.ROOT, "summon minecraft:iron_golem %.2f %d %.2f {NoAI:1b,Silent:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:1024.0}],Health:1024f}", fmv, n2, fmx));
            AimPatternTest.fnp(class_3102, "effect give @e[type=minecraft:iron_golem] resistance infinite 3 true");
            class_7462.method_31548().method_61496(0);
            return true;
        }
        if (fmu == 30) {
            class_1297 class_12972 = null;
            for (class_1297 class_12973 : class_3102.field_1687.method_18112()) {
                if (!(class_12973 instanceof class_1439)) continue;
                class_12972 = class_12973;
            }
            if (class_12972 == null) {
                System.out.println("crit test FAIL no golem");
                fmu = -1;
                return true;
            }
            fma = class_12972.method_5628();
            fmv = class_12972.method_23317();
            fmw = class_12972.method_23318();
            fmx = class_12972.method_23321();
            AimPatternTest.fno();
            return true;
        }
        if (fmu < 60) {
            return true;
        }
        fmb = true;
        return false;
    }

    private static void fnj() {
        if (fme) {
            return;
        }
        fme = true;
        AttackEntityCallback.EVENT.register((class_16572, class_19372, class_12682, class_12972, class_39662) -> {
            int n;
            if (class_19372.method_8608() || !fmb || class_12972.method_5628() != fma) {
                return class_1269.field_5811;
            }
            float f = class_16572.method_7261(0.5f);
            boolean bl = f > 0.9f && class_16572.field_6017 > 0.0 && !class_16572.method_24828() && !class_16572.method_6101() && !class_16572.method_5799() && !class_16572.method_5765() && !class_16572.method_5624();
            boolean bl2 = class_16572.method_6047().method_31574(class_1802.field_49814) && class_16572.field_6017 > 1.5 && !class_16572.method_6128();
            int n2 = fmc;
            if (fmg[n2] == 0) {
                AimPatternTest.fmk[n2] = bl;
            }
            if (class_12972 instanceof class_1309) {
                class_1309 class_13092 = (class_1309)class_12972;
                if (class_13092.field_6008 > 10) {
                    int n3 = n2;
                    fmj[n3] = fmj[n3] + 1;
                }
            }
            int n4 = n2;
            fmg[n4] = fmg[n4] + 1;
            if (bl) {
                int n5 = n2;
                fmh[n5] = fmh[n5] + 1;
            }
            if (bl2) {
                int n6 = n2;
                fmi[n6] = fmi[n6] + 1;
            }
            if ((n = fmd) >= 0) {
                int n7 = n;
                fmn[n7] = fmn[n7] + 1;
                if (bl) {
                    int n8 = n;
                    fmo[n8] = fmo[n8] + 1;
                }
                fmd = -1;
            }
            if (!bl || fmf) {
                System.out.println(String.format(Locale.ROOT, "crit server attack slot=%d y=%.3f fall=%.3f ground=%s sprint=%s charge=%.3f smash=%s -> %s", n2, class_16572.method_23318() - fmw, class_16572.field_6017, class_16572.method_24828(), class_16572.method_5624(), Float.valueOf(f), bl2, bl ? "CRIT" : "no crit"));
            }
            return class_1269.field_5811;
        });
        PacketHooks.listen(class_25962 -> {
            class_2616 class_26162;
            class_8143 class_81432;
            if (class_25962 instanceof class_8143 && (class_81432 = (class_8143)class_25962).comp_1267() == fma) {
                flj flj2;
                flz = flj2 = new flj();
                fly.add(flj2);
            } else if (class_25962 instanceof class_2616 && (class_26162 = (class_2616)class_25962).method_11269() == fma && class_26162.method_11267() == 4 && flz != null) {
                AimPatternTest.flz.crit = true;
            }
        });
    }

    private static void fnk(class_746 class_7462, float f) {
        class_243 class_2432 = class_7462.method_33571();
        double d = fmv - class_2432.field_1352;
        double d2 = fmw + 1.35 - class_2432.field_1351;
        double d3 = fmx - class_2432.field_1350;
        float f2 = (float)(class_3532.method_15349((double)d3, (double)d) * 57.2957763671875) - 90.0f;
        float f3 = (float)(-(class_3532.method_15349((double)d2, (double)Math.sqrt(d * d + d3 * d3)) * 57.2957763671875));
        class_7462.method_36456(f2 + f);
        class_7462.method_36457(f3);
    }

    private static void fnl() {
        flj flj2;
        long l = System.nanoTime();
        while ((flj2 = fly.peek()) != null && l - flj2.at > 60000000L) {
            fly.poll();
            int n = fmc;
            fml[n] = fml[n] + 1;
            if (!flj2.crit) continue;
            int n2 = fmc;
            fmm[n2] = fmm[n2] + 1;
        }
    }

    private static void fnm(class_310 class_3102, class_746 class_7462) {
        boolean bl = class_7462.method_24828();
        if (fmz && !bl && class_7462.method_18798().field_1351 > 0.0) {
            fna = fmu;
            fnc = ++fnb % 2 == 0 ? 5 + fnb / 2 % 6 : -1;
        }
        fmz = bl;
        if (fnc > 0 && fmu - fna == fnc - 1) {
            fmd = fnc;
            class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1886));
        }
    }

    private static void fnn(class_310 class_3102) {
        class_3102.field_1690.field_1903.method_23481(false);
        class_3102.field_1690.field_1894.method_23481(false);
    }

    /*
     * Exception decompiling
     */
    private static void fno() {
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

    private static void fnp(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    static {
        fma = -1;
        fmd = -1;
        fmg = new int[16];
        fmh = new int[16];
        fmi = new int[16];
        fmj = new int[16];
        fmk = new boolean[16];
        fml = new int[16];
        fmm = new int[16];
        fmn = new int[16];
        fmo = new int[16];
        fmt = -1;
        fna = -1;
        fnc = -1;
        fnd = new Random(7L);
    }

    private static /* synthetic */ int px(int n, int n2) {
        return n + n2 + 305971736;
    }

    private static /* synthetic */ int py(int n, int n2) {
        return AimPatternTest.px(n, n2) ^ 0xC43A5461;
    }

    private static /* synthetic */ int pz(int n, int n2) {
        return AimPatternTest.px(n, n2) * n2;
    }
}

