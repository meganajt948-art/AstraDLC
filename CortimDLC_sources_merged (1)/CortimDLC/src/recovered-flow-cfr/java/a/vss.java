/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  org.lwjgl.system.MemoryUtil
 */
package a;

import a.vrs;
import a.vsd;
import a.vsj;
import flow.dev.a;
import java.nio.Buffer;
import java.nio.ShortBuffer;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.system.MemoryUtil;

public final class vss {
    private static final String vst = a.d("\u6dfb\u1403\u9eda\u00a8\u8b67\u0d8e\ub781\u3e6c\ua029\u2a83\uad5a\u573c\ud9b7\u405e\uca1f\u4cea\uf6b0\u797d\ue3c3\u6585\uec2f", -1688326928, 1339048241);
    private static final String vsu = a.b("\u54e3\u2d1c\ua7cd\u39bd\ub26b", -1327475515);
    private static final String[] vsv = new String[]{a.b("\u20f8\u5955\ud39b\u4df1\uc62c\u409c\ufad8\u7304\ued6a\u67d0\ue007\u1a65\u949f\u0d40", 1995776130), a.d("\u1b17\u62ba\ue874\u761e\ufdc3\u7b73\uc137\u48eb\ud685\u5c3f\udbe8\u218a\uaf70\u36ac", 1099057152, -632597651), a.d("\ue56f\u9cc2\u160c\u8866\u03bb\u850b\u3f4f\ub693\u28fd\ua247\u2590\udff2\u5108\uc8d5", -1586868824, 68200637), a.b("\uc7ec\ube41\u348f\uaae5\u2138\ua788\u1dcc\u9410\u0a7e\u80c4\u0713\ufd71\u738b\uea51", -999897194)};
    private static final String[] vsw = new String[]{a.c(-955375416, "\u20b1\u591c\ud3d2\u4db8\uc665\u40d5\ufa91\u734d\ued20\u6795\ue04b\u1a01\u94b8"), a.b("\u7406\u0dab\u8765\u190f\u92d2\u1462\uae26\u27fa\ub997\u3322\ub4fc\u4eb6\uc00c", 1986950271), a.c(1505689712, "\n\u79a7\uf369\u6d03\ue6de\u606e\uda2a\u53f6\ucd98\u4722\uc0f5\u3a97\ub46d\u2db7")};
    private static final String[] vsx = new String[]{a.d("\u9a7a\ue3d7\u6919\uf773\u7cae\ufa1e\u405a\uc986\u57e0\udd56\u5a96\ua0ca\u2e73", 378718543, 431706956), a.c(1272690235, "\ub642\ucfef\u4521\udb4b\u5096\ud626\u6c62\ue5be\u7bd8\uf16e\u76ae\u8cf2\u0248"), a.c(290758556, "\u9fe5\ue648\u6c86\uf2ec\u7931\uff81\u45c5\ucc19\u527f\ud8c9\u5f09\ua555\u2bee"), a.d("\u4af9\u3354\ub99a\u27f0\uac2d\u2a9d\u90d9\u1905\u8768\u0ddd\u8a03\u7049\ufef3", -2110018199, 723511273)};
    private static final String[] vsy = new String[]{a.c(751298123, "\ue632\u9f9f\u1551\u8b3b\u00e6\u8656\u3c12\ub5ce\u2ba8\ua11e\u26de\udc82\u523b"), a.b("\u895b\uf0f6\u7a38\ue452\u6f8f\ue93f\u537b\udaa7\u44c1\uce77\u49b7\ub3eb\u3d51", 1010403618), a.b("\uc0b0\ub91d\u33d3\uadb9\u2664\ua0d4\u1a90\u934c\u0d21\u8794J\ufa00\u74ba", -1289568055), a.d("\u4ec7\u376a\ubda4\u23ce\ua813\u2ea3\u94e7\u1d3b\u8356\u09e3\u8e3d\u7477\uface", -1230602999, -1891355721)};
    private static final float[][] vsz = new float[][]{{0.7071f, 0.7071f}, {-0.7071f, 0.7071f}, {-0.7071f, -0.7071f}, {0.7071f, -0.7071f}};
    private static final int vta = 4;
    private static final int vtb = 6;
    private static final int vtc = 787;
    private static final BlockingQueue<vrs> vtd = new ArrayBlockingQueue<vrs>(16);
    private static final Random vte = new Random();
    private static volatile float vtf;
    private static volatile float vtg;
    private static volatile float vth;
    private static volatile float[] vti;
    private static volatile float vtj;
    private static volatile float vtk;
    private static volatile long vtl;
    private static volatile String vtm;
    private static volatile boolean vtn;
    private static volatile boolean vto;
    private static volatile boolean vtp;
    private static volatile String vtq;
    private static Thread vtr;
    private static /* synthetic */ String vts;
    private static /* synthetic */ boolean vtt;

    private vss() {
    }

    public static void listener(float f) {
        double d = Math.toRadians(f);
        vtj = (float)(-Math.sin(d));
        vtk = (float)Math.cos(d);
    }

    public static void rain(float f, float f2, float f3, float[] fArray) {
        if (vtp) {
            return;
        }
        vtf = f;
        vtg = f2;
        vth = f3;
        if (fArray != null && fArray.length >= 4) {
            vti = (float[])fArray.clone();
        }
        vtl = System.nanoTime();
        try {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            if (minecraftClient.options != null) {
                String string = (String)minecraftClient.options.getSoundDevice().getValue();
                vtm = string == null ? "" : string;
                vtn = Boolean.TRUE.equals(minecraftClient.options.getDirectionalAudio().getValue());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (f > 0.001f || f2 > 0.001f) {
            vss.vtv();
        }
    }

    public static void thunder(float f, boolean bl, float f2, float f3, float f4) {
        String[] stringArray;
        if (vtp || f4 <= 0.001f) {
            return;
        }
        String[] stringArray2 = f < 650.0f ? vsv : (stringArray = f < 1400.0f ? vsw : vsx);
        if (!bl && stringArray == vsv) {
            stringArray = vsw;
        }
        String string = stringArray[vte.nextInt(stringArray.length)];
        float f5 = f4 * Math.max(0.28f, Math.min(1.0f, 1.25f - f / 3600.0f));
        float f6 = 0.92f + 0.12f * vte.nextFloat() - Math.min(0.08f, f / 40000.0f);
        float f7 = Math.max(0.12f, Math.min(1.0f, 1.15f - f / 2600.0f));
        float f8 = vss.vtu(300.0f, 3000.0f, f);
        float f9 = 0.35f + 0.45f * f8;
        long l = System.nanoTime();
        vss.vtv();
        vtd.offer(new vrs(string, f5 * (1.0f - 0.25f * f8), f2, f3, f6, f7, f9, l));
        if (f < 2200.0f) {
            double d = (vte.nextBoolean() ? 1.0 : -1.0) * (0.35 + 0.45 * vte.nextDouble());
            double d2 = Math.atan2(f3, f2) + d;
            String string2 = vsy[vte.nextInt(vsy.length)];
            long l2 = (long)((0.3 + 0.25 * (double)f8 + 0.6 * vte.nextDouble()) * 1.0E9);
            vtd.offer(new vrs(string2, f5 * (bl ? 0.55f : 0.42f), (float)Math.cos(d2), (float)Math.sin(d2), f6 * (0.8f + 0.06f * vte.nextFloat()), f7 * 0.4f, Math.min(1.0f, f9 + 0.25f), l + l2));
        }
    }

    public static String report() {
        return vtq;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void shutdown() {
        Class<vss> clazz = vss.class;
        synchronized (vss.class) {
            Thread thread = vtr;
            vto = true;
            vtp = true;
            // ** MonitorExit[var1] (shouldn't be in output)
            if (thread == null) {
                return;
            }
            try {
                thread.join(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            return;
        }
    }

    private static float vtu(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / (f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static synchronized void vtv() {
        if (vtr != null || vto) {
            return;
        }
        vtr = new Thread(vss::vtw, a.d("\u6c99\u1502\u9fd2\u01bb\u8a29\u0c8a\ub68e\u3f6d\ua136\u2b92\uac5d\u5621\ud8e1\u4102\ucb02\u4def\uf7ba\u7870\ue2c9\u648f", -526817547, -57996738));
        vtr.setDaemon(true);
        vtr.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void vtw() {
        long l;
        vsj vsj2 = null;
        String string = null;
        boolean bl = false;
        long l2 = l = System.nanoTime();
        while (!vto) {
            try {
                Thread.sleep(20L);
            }
            catch (InterruptedException interruptedException) {
                break;
            }
            long l3 = System.nanoTime();
            float f = Math.min(0.2f, (float)(l3 - l) / 1.0E9f);
            l = l3;
            boolean bl2 = l3 - vtl > 400000000L;
            float f2 = bl2 ? 0.0f : vtf;
            float f3 = bl2 ? 0.0f : vtg;
            try {
                vrs vrs2;
                if (!(vsj2 == null || vsj2.connected() && vtm.equals(string) && vtn == bl)) {
                    vsj2.close();
                    vsj2 = null;
                }
                if (vsj2 == null) {
                    if (f2 <= 0.001f && f3 <= 0.001f && vtd.isEmpty()) continue;
                    string = vtm;
                    bl = vtn;
                    vsj2 = vsj.open(string, bl);
                }
                vsj2.update(f, f2, f3, bl2 ? 0.0f : vth, vti, vtj, vtk);
                while ((vrs2 = (vrs)vtd.poll()) != null) {
                    vsj2.pending.add(vrs2);
                }
                vsj2.fire(l3);
                vtq = vsj2.describe();
                if (f2 > 0.001f || f3 > 0.001f || vsj2.busy()) {
                    l2 = l3;
                    continue;
                }
                if (l3 - l2 <= 20000000000L) continue;
                vsj2.close();
                vsj2 = null;
            }
            catch (Throwable throwable) {
                if (vsj2 != null) {
                    try {
                        vsj2.close();
                    }
                    catch (Throwable throwable2) {
                        // empty catch block
                    }
                    vsj2 = null;
                }
                if (throwable instanceof LinkageError || throwable instanceof NullPointerException || throwable instanceof UnsupportedOperationException) {
                    vtp = true;
                    System.out.println(a.b("\u30cc\u496f\uc3b8\u5ddc\ud617\u50ab\ueaef\u634c\ufd40\u77ed\uf024\u0a4e\u8493\u1d35\u9735\u1191\uabc5\u241b\ubebf\u38f9\ub106\ucb52\u45ec\ude3e\u584f\ud297\u6b7b\ue530", 1746808999) + throwable);
                    break;
                }
                System.out.println(a.c(2063479278, "\u318f\u482c\uc2fb\u5c9f\ud754\u51e8\uebac\u620f\ufc03\u76ae\uf167\u0b0d\u85d0\u1c25\u9630\u10c6\uaa81\u2555\ubfef\u39bf\ub016\uca5d") + throwable);
                try {
                    Thread.sleep(3000L);
                }
                catch (InterruptedException interruptedException) {
                    break;
                }
            }
        }
        if (vsj2 != null) {
            try {
                vsj2.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        Class<vss> clazz = vss.class;
        synchronized (vss.class) {
            vtr = null;
            // ** MonitorExit[var7_8] (shouldn't be in output)
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private static vsd vtx(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 7 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    private static vsd vty(vsd vsd2) {
        if (vsd2.channels() == 1) {
            return vsd2;
        }
        ShortBuffer shortBuffer = vsd2.data();
        int n = shortBuffer.remaining() / 2;
        ShortBuffer shortBuffer2 = MemoryUtil.memAllocShort((int)n);
        for (int i = 0; i < n; ++i) {
            shortBuffer2.put(i, (short)((shortBuffer.get(i * 2) + shortBuffer.get(i * 2 + 1)) / 2));
        }
        MemoryUtil.memFree((Buffer)shortBuffer);
        return new vsd(shortBuffer2, 1, vsd2.rate());
    }

    static {
        vti = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        vtk = 1.0f;
        vtm = "";
        vtq = a.d("\u78c3\u017f\u8ba4\u15dc", 1830770114, 1844194668);
    }

    private static /* synthetic */ int dkg(int n, int n2) {
        return n - n2 + 1873484496;
    }
}

