/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 */
package a;

import a.ejp;
import a.wcn;
import a.web;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public final class wee {
    private static final String wef = a.b("\u9aa6\ue31d\u69cd\uf7a4\u7c36\ufaea\u4095\uc960\u5721\udd97\u5a4d", 1440979659);
    private static final String weg = a.c(-909658882, "\ub480\ucd20\u47f1\ud988\u5251\ud4f1\u6e89\ue74f\u7919\uf3a7\u747e\u8e07\u00d9\u997f");
    private static volatile int weh;
    private static /* synthetic */ int wei;
    private static /* synthetic */ long wej;

    private wee() {
    }

    public static int count() {
        return weh;
    }

    public static void ensure(MinecraftClient minecraftClient) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.method_1562();
        if (clientPlayNetworkHandler == null || ejp.isActive()) {
            return;
        }
        Channel channel = wcn.channel(clientPlayNetworkHandler.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        ChannelPipeline channelPipeline = channel.pipeline();
        if (channelPipeline.get(a.d("\uef1b\u96a0\u1c70\u8219\u098b\u8f57\u3528\ubcdd\u229c\ua82a\u2ff0", -1147047637, -1657364899)) != null || channelPipeline.get(a.b("\ub2cb\ucb6b\u41ba\udfc3\u541a\ud2ba\u68c2\ue104\u7f52\uf5ec\u7235\u884c\u0692\u9f34", -993611083)) == null) {
            return;
        }
        try {
            channelPipeline.addBefore(a.b("\u06c4\u7f64\uf5b5\u6bcc\ue015\u66b5\udccd\u550b\ucb5d\u41e3\uc63a\u3c43\ub29d\u2b3b", 1545275066), a.d("\uad4f\ud4f4\u5e24\uc04d\u4bdf\ucd03\u777c\ufe89\u60c8\uea7e\u6da4", 260390391, -1697410859), (ChannelHandler)new web());
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    private static /* synthetic */ int dpu(int n, int n2) {
        return n ^ n2 ^ 0x4DCB2547;
    }

    private static /* synthetic */ int dpv(int n, int n2) {
        return wee.dpu(n, n2) * n2;
    }

    private static /* synthetic */ int dpw(int n, int n2) {
        return n - n2 | 0x5030FAEC;
    }
}

