/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.system.MemoryUtil
 */
package a;

import a.vrs;
import a.vsd;
import a.vsj;
import flow.dev.StringDecryptor;
import java.nio.Buffer;
import java.nio.ShortBuffer;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import net.minecraft.class_310;
import org.lwjgl.system.MemoryUtil;

public final class WeatherSounds {
    private static final String vst = "/flow/sounds/weather/";
    private static final String vsu = "#mono";
    private static final String[] vsv = new String[]{"thunder_near_1", "thunder_near_2", "thunder_near_3", "thunder_near_4"};
    private static final String[] vsw = new String[]{"thunder_mid_1", "thunder_mid_2", "thunder_near_4"};
    private static final String[] vsx = new String[]{"thunder_far_1", "thunder_far_2", "thunder_far_3", "thunder_mid_2"};
    private static final String[] vsy = new String[]{"thunder_far_1", "thunder_far_2", "thunder_mid_2", "thunder_mid_1"};
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

    private WeatherSounds() {
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
            class_310 class_3102 = class_310.method_1551();
            if (class_3102.field_1690 != null) {
                String string = (String)class_3102.field_1690.method_42477().method_41753();
                vtm = string == null ? "" : string;
                vtn = Boolean.TRUE.equals(class_3102.field_1690.method_42444().method_41753());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (f > 0.001f || f2 > 0.001f) {
            WeatherSounds.vtv();
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
        float f8 = WeatherSounds.vtu(300.0f, 3000.0f, f);
        float f9 = 0.35f + 0.45f * f8;
        long l = System.nanoTime();
        WeatherSounds.vtv();
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
        Class<WeatherSounds> clazz = WeatherSounds.class;
        synchronized (WeatherSounds.class) {
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
        vtr = new Thread(WeatherSounds::vtw, "Flow2 weather sounds");
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
                    System.out.println("weather sounds unavailable: " + throwable);
                    break;
                }
                System.out.println("weather sound failed: " + throwable);
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
        Class<WeatherSounds> clazz = WeatherSounds.class;
        synchronized (WeatherSounds.class) {
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
        vtq = "idle";
    }

    private static /* synthetic */ int dkg(int n, int n2) {
        return n - n2 + 1873484496;
    }
}

