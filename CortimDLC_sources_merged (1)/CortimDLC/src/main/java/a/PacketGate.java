/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.class_10185
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package a;

import a.vwh;
import a.IdleTracker;
import a.PacketHooks;
import a.ForwardKeyHold;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import net.minecraft.class_10185;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public final class PacketGate {
    private static final String vwz = "flow2_gate";
    private static final String vxa = "packet_handler";
    private static final int vxb = 4;
    private static volatile boolean vxc;
    private static volatile boolean vxd;
    private static volatile vwh vxe;
    private static volatile boolean vxf;
    private static volatile int vxg;
    private static class_746 vxh;
    private static /* synthetic */ long vxi;
    private static /* synthetic */ int vxj;

    private PacketGate() {
    }

    public static boolean waiting() {
        return vxd;
    }

    public static void setActive(boolean bl) {
        if (vxc == bl) {
            return;
        }
        vxc = bl;
        if (!bl) {
            PacketGate.poke(true);
        }
    }

    public static void ensure(class_310 class_3102) {
        class_634 class_6342 = class_3102.method_1562();
        class_746 class_7462 = class_3102.field_1724;
        if (class_6342 == null || class_7462 == null) {
            return;
        }
        Channel channel = PacketHooks.channel(class_6342.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        ChannelPipeline channelPipeline = channel.pipeline();
        vwh vwh2 = vxe;
        if (channelPipeline.get("flow2_gate") != null) {
            if (vwh2 != null && class_7462 != vxh) {
                vxh = class_7462;
                class_10185 class_101852 = IdleTracker.lastSent(class_7462);
                boolean bl = ForwardKeyHold.serverSprinting(class_7462);
                channel.eventLoop().execute(() -> vwh2.reset(class_101852, bl));
            }
            return;
        }
        if (channelPipeline.get("packet_handler") == null) {
            return;
        }
        vwh vwh3 = new vwh(channel, IdleTracker.lastSent(class_7462), ForwardKeyHold.serverSprinting(class_7462));
        try {
            channelPipeline.addBefore("packet_handler", "flow2_gate", (ChannelHandler)vwh3);
            vxe = vwh3;
            vxh = class_7462;
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    public static void sneakOk(boolean bl) {
        if (bl) {
            ++vxg;
            vxf = true;
            return;
        }
        if (!vxf) {
            return;
        }
        int n = vxg;
        vwh vwh2 = vxe;
        if (vwh2 != null && vwh2.channel.isOpen()) {
            vwh2.channel.eventLoop().execute(() -> {
                if (vxg == n) {
                    vxf = false;
                }
            });
        } else {
            vxf = false;
        }
    }

    public static void poke(boolean bl) {
        vwh vwh2 = vxe;
        if (vwh2 != null && vwh2.channel.isOpen()) {
            vwh2.channel.eventLoop().execute(() -> vwh2.release(bl));
        }
    }

    private static boolean vxk(class_10185 class_101852) {
        return class_101852.comp_3159() || class_101852.comp_3160() || class_101852.comp_3161() || class_101852.comp_3162() || class_101852.comp_3163();
    }

    private static /* synthetic */ int dlq(int n, int n2) {
        return n + n2 | 0xF670DD0E;
    }
}

