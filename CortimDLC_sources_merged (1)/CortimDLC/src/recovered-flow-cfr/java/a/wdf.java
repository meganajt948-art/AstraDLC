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
import a.wcy;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import java.util.concurrent.LinkedBlockingQueue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public final class wdf {
    private static final String wdg = a.b("\uc517\ubcac\u367c\ua815\u2387\ua55b\u1f3d\u96cf\u088d\u823c\u05fe\uff98", 1140770173);
    private static final String wdh = a.d("\u96a7\uef07\u65d6\ufbaf\u7076\uf6d6\u4cae\uc568\u5b3e\ud180\u5659\uac20\u22fe\ubb58", 959061700, -247560163);
    private static final LinkedBlockingQueue<wcy> wdi = new LinkedBlockingQueue();
    private static Thread wdj;
    private static /* synthetic */ boolean wdk;
    private static /* synthetic */ String wdl;

    private wdf() {
    }

    public static void hold(MinecraftClient minecraftClient, long l) {
        if (l <= 0L || ejp.isActive()) {
            return;
        }
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.method_1562();
        if (clientPlayNetworkHandler == null) {
            return;
        }
        Channel channel = wcn.channel(clientPlayNetworkHandler.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        wcy wcy2 = wdf.wdm(channel.pipeline());
        if (wcy2 == null) {
            return;
        }
        wcy2.until = Math.max(wcy2.until, System.nanoTime() + l);
        wdf.wdn();
        wdi.add(wcy2);
    }

    private static wcy wdm(ChannelPipeline channelPipeline) {
        ChannelHandler channelHandler = channelPipeline.get(a.c(-387363752, "\u4c32\u3589\ubf59\u2130\uaaa2\u2c7e\u9618\u1fea\u81a8\u0b19\u8cdb\u76bd"));
        if (channelHandler instanceof wcy) {
            wcy wcy2 = (wcy)channelHandler;
            return wcy2;
        }
        if (channelPipeline.get(a.d("\ue381\u9a21\u10f0\u8e89\u0550\u83f0\u3988\ub04e\u2e18\ua4a6\u237f\ud906\u57d8\uce7e", -1344428306, -1485159151)) == null) {
            return null;
        }
        wcy wcy3 = new wcy();
        try {
            channelPipeline.addBefore(a.b("\uaf4a\ud6ea\u5c3b\uc242\u499b\ucf3b\u7543\ufc85\u62d3\ue86d\u6fb4\u95cd\u1b13\u82b5", 991473460), a.c(-20789793, "\uc5b5\ubc0e\u36de\ua8b7\u2325\ua5f9\u1f9f\u966d\u082f\u829e\u055c\uff3a"), (ChannelHandler)wcy3);
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
        wdj = new Thread(wdf::wdo, a.c(-1742451277, "\u4de4\u347f\ubeaf\u20c6\uab54\u2df7\u97d7\u1e10\u8044\u0aff\u8d68\u7773\uf987\u602b\uea78\u6c98\ud6c0"));
        wdj.setDaemon(true);
        wdj.start();
    }

    private static void wdo() {
        while (true) {
            try {
                while (true) {
                    wcy wcy2 = wdi.take();
                    wdf.wdp(wcy2.until);
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
        return wdf.dpf(n, n2) + n;
    }

    private static /* synthetic */ int dph(int n, int n2) {
        return n * n2 ^ 0x7A15498A;
    }
}

