/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.openal.AL10
 *  org.lwjgl.openal.ALC10
 */
package a;

import a.SoundBank;
import a.vne;
import a.vnl;
import flow.dev.StringDecryptor;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_310;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;

public final class Sounds {
    public static final List<String> BUILT_IN;
    private static final float vob = 0.8909f;
    private static final int voc = 8;
    private static final int vod = 787;
    private static final BlockingQueue<vnl> voe;
    private static final vnl vof;
    private static Thread vog;
    private static volatile boolean voh;
    private static final String voi;
    private static long voj;
    private static volatile String vok;
    private static /* synthetic */ boolean vol;
    private static /* synthetic */ String vom;

    private Sounds() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void shutdown() {
        Class<Sounds> clazz = Sounds.class;
        synchronized (Sounds.class) {
            Thread thread = vog;
            voh = true;
            // ** MonitorExit[var1] (shouldn't be in output)
            if (thread == null) {
                return;
            }
            voe.clear();
            voe.offer(vof);
            try {
                thread.join(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            return;
        }
    }

    public static void play(String string, boolean bl, float f) {
        Sounds.von(string, bl, f, 0.0f, 0.0f);
    }

    public static void cue(String string, float f, float f2, float f3) {
        Sounds.von("cue:" + string, true, f, f2, f3);
    }

    public static void menu(String string, boolean bl, float f) {
        Sounds.von(string, bl, f, 0.0f, 0.0f);
    }

    private static void von(String string, boolean bl, float f, float f2, float f3) {
        if (voh || f <= 0.001f || string == null) {
            return;
        }
        Sounds.voo();
        long l = 0L;
        String string2 = "";
        try {
            l = ALC10.alcGetCurrentContext();
            class_310 class_3102 = class_310.method_1551();
            if (class_3102.field_1690 != null) {
                string2 = (String)class_3102.field_1690.method_42477().method_41753();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        voe.offer(new vnl(string, bl, Math.min(2.0f, f), l, string2 == null ? "" : string2, f2, f3));
    }

    private static synchronized void voo() {
        if (vog != null) {
            return;
        }
        vog = new Thread(Sounds::vop, "Flow2 sounds");
        vog.setDaemon(true);
        vog.start();
    }

    private static void vop() {
        vne vne2 = null;
        long l = 0L;
        String string = null;
        while (true) {
            vnl vnl2;
            try {
                vnl2 = voe.poll(2L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedException) {
                break;
            }
            if (vnl2 == vof) break;
            try {
                boolean bl;
                if (vnl2 == null) {
                    if (vne2 == null || vne2.connected()) continue;
                    vne2.close();
                    vne2 = null;
                    continue;
                }
                boolean bl2 = bl = l != 0L && vnl2.gameContext() != 0L && vnl2.gameContext() != l;
                if (!(vne2 == null || !bl && vnl2.device().equals(string) && vne2.connected())) {
                    vne2.close();
                    vne2 = null;
                }
                if (vnl2.gameContext() != 0L) {
                    l = vnl2.gameContext();
                }
                if (vne2 == null) {
                    string = vnl2.device();
                    vne2 = vne.open(string);
                }
                vne2.play(vnl2.sound(), vnl2.on(), vnl2.gain(), vnl2.x(), vnl2.z());
                vok = vnl2.sound() + (vnl2.on() ? " on" : " off") + " playing=" + vne2.playing() + " listener=" + AL10.alGetListenerf((int)4106) + " gain=" + vnl2.gain();
            }
            catch (Throwable throwable) {
                if (vne2 != null) {
                    try {
                        vne2.close();
                    }
                    catch (Throwable throwable2) {
                        // empty catch block
                    }
                    vne2 = null;
                }
                if (throwable instanceof LinkageError || throwable instanceof NullPointerException || throwable instanceof UnsupportedOperationException) {
                    voh = true;
                    System.out.println("client sounds unavailable: " + throwable);
                    break;
                }
                long l2 = System.currentTimeMillis();
                if (l2 - voj <= 30000L) continue;
                voj = l2;
                System.out.println("client sound failed: " + throwable);
            }
        }
        if (vne2 != null) {
            try {
                vne2.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public static String report() {
        return vok;
    }

    static {
        voi = "cue:";
        BUILT_IN = SoundBank.NAMES;
        voe = new ArrayBlockingQueue<vnl>(32);
        vof = new vnl("", true, 0.0f, 0L, "", 0.0f, 0.0f);
        vok = "";
    }

    private static /* synthetic */ int dir(int n, int n2) {
        return n * n2 | 0x81565559;
    }
}

