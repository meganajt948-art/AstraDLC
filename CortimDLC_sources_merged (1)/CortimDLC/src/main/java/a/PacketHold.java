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
import a.wcy;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import java.util.concurrent.LinkedBlockingQueue;
import net.minecraft.class_310;
import net.minecraft.class_634;

public final class PacketHold {
    private static final String wdg = "flow2_jitter";
    private static final String wdh = "packet_handler";
    private static final LinkedBlockingQueue<wcy> wdi = new LinkedBlockingQueue();
    private static Thread wdj;
    private static /* synthetic */ boolean wdk;
    private static /* synthetic */ String wdl;

    private PacketHold() {
    }

    public static void hold(class_310 class_3102, long l) {
        if (l <= 0L || BotRuntime.isActive()) {
            return;
        }
        class_634 class_6342 = class_3102.method_1562();
        if (class_6342 == null) {
            return;
        }
        Channel channel = PacketHooks.channel(class_6342.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        wcy wcy2 = PacketHold.wdm(channel.pipeline());
        if (wcy2 == null) {
            return;
        }
        wcy2.until = Math.max(wcy2.until, System.nanoTime() + l);
        PacketHold.wdn();
        wdi.add(wcy2);
    }

    private static wcy wdm(ChannelPipeline channelPipeline) {
        ChannelHandler channelHandler = channelPipeline.get("flow2_jitter");
        if (channelHandler instanceof wcy) {
            wcy wcy2 = (wcy)channelHandler;
            return wcy2;
        }
        if (channelPipeline.get("packet_handler") == null) {
            return null;
        }
        wcy wcy3 = new wcy();
        try {
            channelPipeline.addBefore("packet_handler", "flow2_jitter", (ChannelHandler)wcy3);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        return wcy3;
    }

    private static synchronized void wdn() {
        if (wdj != null) {
            return;
        }
        wdj = new Thread(PacketHold::wdo, "Flow2 Send Jitter");
        wdj.setDaemon(true);
        wdj.start();
    }

    private static void wdo() {
        while (true) {
            try {
                while (true) {
                    wcy wcy2 = wdi.take();
                    PacketHold.wdp(wcy2.until);
                    wcy2.wake();
                }
            }
            catch (InterruptedException interruptedException) {
                return;
            }
            catch (RuntimeException runtimeException) {
                continue;
            }
            break;
        }
    }

    private static void wdp(long l) throws InterruptedException {
        long l2;
        while ((l2 = l - System.nanoTime()) > 0L) {
            long l3 = l2 / 1000000L - 1L;
            if (l3 > 0L) {
                Thread.sleep(l3 % 10L == 0L ? l3 - 1L : l3);
                continue;
            }
            Thread.onSpinWait();
        }
    }

    private static /* synthetic */ int dpf(int n, int n2) {
        return n * n2 | 0xBC6D963E;
    }

    private static /* synthetic */ int dpg(int n, int n2) {
        return PacketHold.dpf(n, n2) + n;
    }

    private static /* synthetic */ int dph(int n, int n2) {
        return n * n2 ^ 0x7A15498A;
    }
}

