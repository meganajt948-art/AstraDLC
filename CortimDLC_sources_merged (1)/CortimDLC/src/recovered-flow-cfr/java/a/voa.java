/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  org.lwjgl.openal.AL10
 *  org.lwjgl.openal.ALC10
 */
package a;

import a.vnb;
import a.vne;
import a.vnl;
import flow.dev.a;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;

public final class voa {
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

    private voa() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void shutdown() {
        Class<voa> clazz = voa.class;
        synchronized (voa.class) {
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
        voa.von(string, bl, f, 0.0f, 0.0f);
    }

    public static void cue(String string, float f, float f2, float f3) {
        voa.von(a.b("\u09db\u707c\ufabf\u6491", 2134706620) + string, true, f, f2, f3);
    }

    public static void menu(String string, boolean bl, float f) {
        voa.von(string, bl, f, 0.0f, 0.0f);
    }

    private static void von(String string, boolean bl, float f, float f2, float f3) {
        if (voh || f <= 0.001f || string == null) {
            return;
        }
        voa.voo();
        long l = 0L;
        String string2 = "";
        try {
            l = ALC10.alcGetCurrentContext();
            MinecraftClient minecraftClient = MinecraftClient.method_1551();
            if (minecraftClient.field_1690 != null) {
                string2 = (String)minecraftClient.field_1690.method_42477().method_41753();
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
        vog = new Thread(voa::vop, a.d("\u033c\u7aa7\uf077\u6e1e\ue58c\u632f\ud92f\u50c2\uce87\u442d\uc3f4\u3992", 1969676732, -1719541046));
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
                vok = vnl2.sound() + (vnl2.on() ? a.c(1974901056, "\u9963\ue09d\u6a4f") : a.c(-470882698, "\ue652\u9fac\u1576\u8b07")) + a.d("\ue99c\u907d\u1ab2\u84ce\u0f01\u89a0\u33f4\uba0c\u2409", -2115848914, -1670620005) + vne2.playing() + a.b("\u648d\u1d70\u97a6\u09cd\u821d\u04bd\ubee5\u371f\ua957\u23a9", 1388995751) + AL10.alGetListenerf((int)4106) + a.c(1301170145, "\u47c7\u3e31\ub4e4\u2a9d\ua14d\u27af") + vnl2.gain();
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
                    System.out.println(a.d("\u2967\u50d9\uda0f\u4472\ucfae\u4905\uf302\u7aa0\ue4e3\u6e48\ue980\u13fb\u9d3b\u04d9\u8edf\u0835\ub275\u3db3\ua717\u214e\ua8bc\ud2e0\u5c50\uc78f\u41f9\ucb77\u72de", 1273839578, -1471408443) + throwable);
                    break;
                }
                long l2 = System.currentTimeMillis();
                if (l2 - voj <= 30000L) continue;
                voj = l2;
                System.out.println(a.c(228425904, "\u80c6\uf978\u73ae\uedd3\u660f\ue0a4\u5aa3\ud301\u4d42\uc7e9\u4021\uba5a\u34c9\uad3e\u276a\ua193\u1bd9\u9401\u0eb3\u88bc\u0151") + throwable);
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
        voi = a.d("\ueb40\u92e7\u1824\u860a", -827944839, 702184286);
        BUILT_IN = vnb.NAMES;
        voe = new ArrayBlockingQueue<vnl>(32);
        vof = new vnl("", true, 0.0f, 0L, "", 0.0f, 0.0f);
        vok = "";
    }

    private static /* synthetic */ int dir(int n, int n2) {
        return n * n2 | 0x81565559;
    }
}

