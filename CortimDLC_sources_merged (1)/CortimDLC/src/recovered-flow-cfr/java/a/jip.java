/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.network.ClientConnection
 */
package a;

import a.jim;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.ClientConnection;

public final class jip {
    private static final String jiq = a.c(-1106909821, "\ue5ec\u9c57\u1687\u88ee\u037c\u85a0\u3fd8\ub62d\u2871");
    private static final int jir = 6;
    private static final long[] jis = new long[6];
    private static final long[] jit = new long[6];
    private static int jiu;
    private static int jiv;
    private static Field jiw;
    private static boolean jix;
    private static ClientConnection jiy;
    private static double jiz;
    private static double jja;
    private static float jjb;
    private static boolean jjc;
    private static /* synthetic */ long jjd;
    private static /* synthetic */ String jje;

    private jip() {
    }

    public static void tick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity;
        ClientConnection clientConnection;
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.method_1562();
        ClientConnection clientConnection2 = clientConnection = clientPlayNetworkHandler != null ? clientPlayNetworkHandler.method_48296() : null;
        if (clientConnection != jiy) {
            jip.jjf();
            ClientConnection clientConnection3 = jiy = clientConnection != null && jip.jjh(clientConnection) ? clientConnection : null;
        }
        if ((clientPlayerEntity = minecraftClient.field_1724) == null) {
            jiz = Double.NaN;
            jjb = 0.0f;
            return;
        }
        if (!Double.isNaN(jiz)) {
            double d;
            double d2 = clientPlayerEntity.method_23317() - jiz;
            float f = (float)Math.sqrt(d2 * d2 + (d = clientPlayerEntity.method_23321() - jja) * d) * 20.0f;
            if (f > 400.0f) {
                f = jjb;
            }
            if ((jjb += (f - jjb) * 0.45f) < 0.005f) {
                jjb = 0.0f;
            }
        }
        jiz = clientPlayerEntity.method_23317();
        jja = clientPlayerEntity.method_23321();
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
        jip.jis[jip.jiv] = l;
        jip.jit[jip.jiv] = l2;
        jiv = (jiv + 1) % 6;
        jiu = Math.min(6, jiu + 1);
    }

    private static boolean jjh(ClientConnection clientConnection) {
        Channel channel = jip.jji(clientConnection);
        if (channel == null) {
            return false;
        }
        try {
            ChannelPipeline channelPipeline = channel.pipeline();
            if (channelPipeline.get(a.b("\uf71c\u8ea7\u0477\u9a1e\u118c\u9750\u2d28\ua4dd\u3a81", 1759836019)) != null) {
                return true;
            }
            ChannelHandlerContext channelHandlerContext = channelPipeline.context((ChannelHandler)clientConnection);
            if (channelHandlerContext == null) {
                return false;
            }
            channelPipeline.addBefore(channelHandlerContext.name(), a.c(59097505, "\uc1ce\ub875\u32a5\uaccc\u275e\ua182\u1bfa\u920f\u0c53"), (ChannelHandler)new jim());
            return true;
        }
        catch (Throwable throwable) {
            if (!jjc) {
                jjc = true;
                System.out.println(a.c(-1881087198, "\ue371\u9ac2\u101e\u8e26\u05a2\u8347\u3943\ub0a4\u2eee\ua448\u2390\ud9a9\u572a\uce87\u44d9\uc26d\u7871\uf7b6\u6d12\ueb47\u62a3\u18e5\u9603\u0d86\u8baa\u012f\ub881\u36d4\uac2b\u2a3f\ua1d9\u5f0d\ud556\u4ca2\ucae4\u4044\uff85\u75a7\uf37c\u6a8b\ue0d5\u9e6b\u144c\u93f9\u092d\u8726\u3ee6\ub44d") + throwable);
            }
            return false;
        }
    }

    private static Channel jji(ClientConnection clientConnection) {
        if (jiw == null && !jix) {
            for (Field field : ClientConnection.class.getDeclaredFields()) {
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
            return (Channel)jiw.get(clientConnection);
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
        return jip.aoa(n, n2) ^ 0xEDC5339D;
    }

    private static /* synthetic */ int aoc(int n, int n2) {
        return jip.aob(n, n2) + n;
    }
}

