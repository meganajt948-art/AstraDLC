/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.util.PlayerInput
 */
package a;

import a.vwh;
import a.vyn;
import a.wcn;
import a.wdt;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.PlayerInput;

public final class vwy {
    private static final String vwz = a.d("\ube1b\uc7a0\u4d70\ud319\u588b\ude57\u643c\uedcb\u7381\uf921", 651172504, 963945711);
    private static final String vxa = a.b("\u143d\u6d9d\ue74c\u7935\uf2ec\u744c\uce34\u47f2\ud9a4\u531a\ud4c3\u2eba\ua064\u39c2", -85715901);
    private static final int vxb = 4;
    private static volatile boolean vxc;
    private static volatile boolean vxd;
    private static volatile vwh vxe;
    private static volatile boolean vxf;
    private static volatile int vxg;
    private static ClientPlayerEntity vxh;
    private static /* synthetic */ long vxi;
    private static /* synthetic */ int vxj;

    private vwy() {
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
            vwy.poke(true);
        }
    }

    public static void ensure(MinecraftClient minecraftClient) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.method_1562();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayNetworkHandler == null || clientPlayerEntity == null) {
            return;
        }
        Channel channel = wcn.channel(clientPlayNetworkHandler.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        ChannelPipeline channelPipeline = channel.pipeline();
        vwh vwh2 = vxe;
        if (channelPipeline.get(a.d("\uf560\u8cdb\u060b\u9862\u13f0\u952c\u2f47\ua6b0\u38fa\ub25a", 123738631, 755494667)) != null) {
            if (vwh2 != null && clientPlayerEntity != vxh) {
                vxh = clientPlayerEntity;
                PlayerInput playerInput = vyn.lastSent(clientPlayerEntity);
                boolean bl = wdt.serverSprinting(clientPlayerEntity);
                channel.eventLoop().execute(() -> vwh2.reset(playerInput, bl));
            }
            return;
        }
        if (channelPipeline.get(a.c(1048825518, "\uced0\ub770\u3da1\ua3d8\u2801\uaea1\u14d9\u9d1f\u0349\u89f7\u0e2e\uf457\u7a89\ue32f")) == null) {
            return;
        }
        vwh vwh3 = new vwh(channel, vyn.lastSent(clientPlayerEntity), wdt.serverSprinting(clientPlayerEntity));
        try {
            channelPipeline.addBefore(a.c(738774851, "\ucf3d\ub69d\u3c4c\ua235\u29ec\uaf4c\u1534\u9cf2\u02a4\u881a\u0fc3\uf5ba\u7b64\ue2c2"), a.b("\u2c7f\u55c4\udf14\u417d\ucaef\u4c33\uf658\u7faf\ue1e5\u6b45", 2044079123), (ChannelHandler)vwh3);
            vxe = vwh3;
            vxh = clientPlayerEntity;
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

    private static boolean vxk(PlayerInput playerInput) {
        return playerInput.comp_3159() || playerInput.comp_3160() || playerInput.comp_3161() || playerInput.comp_3162() || playerInput.comp_3163();
    }

    private static /* synthetic */ int dlq(int n, int n2) {
        return n + n2 | 0xF670DD0E;
    }
}

