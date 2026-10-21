/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.class_2535
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package a;

import a.jim;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import net.minecraft.class_2535;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public final class TpsMeter {
    private static final String jiq = "flow2_tps";
    private static final int jir = 6;
    private static final long[] jis = new long[6];
    private static final long[] jit = new long[6];
    private static int jiu;
    private static int jiv;
    private static Field jiw;
    private static boolean jix;
    private static class_2535 jiy;
    private static double jiz;
    private static double jja;
    private static float jjb;
    private static boolean jjc;
    private static /* synthetic */ long jjd;
    private static /* synthetic */ String jje;

    private TpsMeter() {
    }

    public static void tick(class_310 class_3102) {
        class_746 class_7462;
        class_2535 class_25352;
        class_634 class_6342 = class_3102.method_1562();
        class_2535 class_25353 = class_25352 = class_6342 != null ? class_6342.method_48296() : null;
        if (class_25352 != jiy) {
            TpsMeter.jjf();
            class_2535 class_25354 = jiy = class_25352 != null && TpsMeter.jjh(class_25352) ? class_25352 : null;
        }
        if ((class_7462 = class_3102.field_1724) == null) {
            jiz = Double.NaN;
            jjb = 0.0f;
            return;
        }
        if (!Double.isNaN(jiz)) {
            double d;
            double d2 = class_7462.method_23317() - jiz;
            float f = (float)Math.sqrt(d2 * d2 + (d = class_7462.method_23321() - jja) * d) * 20.0f;
            if (f > 400.0f) {
                f = jjb;
            }
            if ((jjb += (f - jjb) * 0.45f) < 0.005f) {
                jjb = 0.0f;
            }
        }
        jiz = class_7462.method_23317();
        jja = class_7462.method_23321();
    }

    public static float bps() {
        return jjb;
    }

    public static synchronized float tps() {
        if (jiu < 2) {
            return -1.0f;
        }
        int n = (jiv - 1 + 6) % 6;
        int n2 = (jiv - jiu + 6) % 6;
        double d = (double)(jit[n] - jit[n2]) / 1.0E9;
        long l = jis[n] - jis[n2];
        if (d <= 0.05 || l <= 0L) {
            return -1.0f;
        }
        float f = (float)Math.min(20.0, (double)l / d);
        double d2 = (double)(System.nanoTime() - jit[n]) / 1.0E9;
        if (d2 > 1.5) {
            f = (float)Math.min((double)f, 20.0 / d2);
        }
        return f;
    }

    private static synchronized void jjf() {
        jiu = 0;
        jiv = 0;
    }

    private static synchronized void jjg(long l) {
        long l2 = System.nanoTime();
        if (jiu > 0 && l <= jis[(jiv - 1 + 6) % 6]) {
            jiu = 0;
        }
        TpsMeter.jis[TpsMeter.jiv] = l;
        TpsMeter.jit[TpsMeter.jiv] = l2;
        jiv = (jiv + 1) % 6;
        jiu = Math.min(6, jiu + 1);
    }

    private static boolean jjh(class_2535 class_25352) {
        Channel channel = TpsMeter.jji(class_25352);
        if (channel == null) {
            return false;
        }
        try {
            ChannelPipeline channelPipeline = channel.pipeline();
            if (channelPipeline.get("flow2_tps") != null) {
                return true;
            }
            ChannelHandlerContext channelHandlerContext = channelPipeline.context((ChannelHandler)class_25352);
            if (channelHandlerContext == null) {
                return false;
            }
            channelPipeline.addBefore(channelHandlerContext.name(), "flow2_tps", (ChannelHandler)new jim());
            return true;
        }
        catch (Throwable throwable) {
            if (!jjc) {
                jjc = true;
                System.out.println("can't watch the server's time updates (no TPS): " + throwable);
            }
            return false;
        }
    }

    private static Channel jji(class_2535 class_25352) {
        if (jiw == null && !jix) {
            for (Field field : class_2535.class.getDeclaredFields()) {
                if (!Channel.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                jiw = field;
                break;
            }
            boolean bl = jix = jiw == null;
        }
        if (jiw == null) {
            return null;
        }
        try {
            return (Channel)jiw.get(class_25352);
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    static {
        jiz = Double.NaN;
    }

    private static /* synthetic */ int aoa(int n, int n2) {
        return n + n2 ^ 0x6FF01C7;
    }

    private static /* synthetic */ int aob(int n, int n2) {
        return TpsMeter.aoa(n, n2) ^ 0xEDC5339D;
    }

    private static /* synthetic */ int aoc(int n, int n2) {
        return TpsMeter.aob(n, n2) + n;
    }
}

