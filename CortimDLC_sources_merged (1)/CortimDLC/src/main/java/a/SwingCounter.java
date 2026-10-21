/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 */
package a;

import a.BotRuntime;
import a.PacketHooks;
import a.web;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import net.minecraft.class_310;
import net.minecraft.class_634;

public final class SwingCounter {
    private static final String wef = "flow2_swing";
    private static final String weg = "packet_handler";
    private static volatile int weh;
    private static /* synthetic */ int wei;
    private static /* synthetic */ long wej;

    private SwingCounter() {
    }

    public static int count() {
        return weh;
    }

    public static void ensure(class_310 class_3102) {
        class_634 class_6342 = class_3102.method_1562();
        if (class_6342 == null || BotRuntime.isActive()) {
            return;
        }
        Channel channel = PacketHooks.channel(class_6342.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        ChannelPipeline channelPipeline = channel.pipeline();
        if (channelPipeline.get("flow2_swing") != null || channelPipeline.get("packet_handler") == null) {
            return;
        }
        try {
            channelPipeline.addBefore("packet_handler", "flow2_swing", (ChannelHandler)new web());
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    private static /* synthetic */ int dpu(int n, int n2) {
        return n ^ n2 ^ 0x4DCB2547;
    }

    private static /* synthetic */ int dpv(int n, int n2) {
        return SwingCounter.dpu(n, n2) * n2;
    }

    private static /* synthetic */ int dpw(int n, int n2) {
        return n - n2 | 0x5030FAEC;
    }
}

