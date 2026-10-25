/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.DisconnectionInfo
 *  net.minecraft.network.NetworkSide
 *  net.minecraft.network.OffThreadException
 *  net.minecraft.network.listener.ClientLoginPacketListener
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.common.DisconnectS2CPacket
 *  net.minecraft.text.Text
 */
package a;

import a.dtv;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.OffThreadException;
import net.minecraft.network.listener.ClientLoginPacketListener;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.common.DisconnectS2CPacket;
import net.minecraft.text.Text;

final class edb
extends ClientConnection {
    private final dtv edc;
    private final ConcurrentLinkedQueue<Packet<?>> edd = new ConcurrentLinkedQueue();
    private volatile Channel ede;
    private static /* synthetic */ int edf;
    private static /* synthetic */ String edg;

    edb(dtv dtv2) {
        super(NetworkSide.CLIENTBOUND);
        this.edc = dtv2;
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ede = channelHandlerContext.channel();
        super.channelActive(channelHandlerContext);
    }

    void runInLoop(Runnable runnable) {
        Channel channel = this.ede;
        if (channel == null || channel.eventLoop().inEventLoop()) {
            runnable.run();
            return;
        }
        channel.eventLoop().execute(runnable);
    }

    public void disconnect(DisconnectionInfo disconnectionInfo) {
        Channel channel = this.ede;
        if (channel != null && !channel.eventLoop().inEventLoop()) {
            channel.eventLoop().execute(() -> this.edh(disconnectionInfo));
            return;
        }
        super.disconnect(disconnectionInfo);
    }

    private void edh(DisconnectionInfo disconnectionInfo) {
        super.disconnect(disconnectionInfo);
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet<?> packet) {
        PacketListener packetListener = this.getPacketListener();
        if (packetListener == null || packetListener instanceof ClientLoginPacketListener) {
            super.channelRead0(channelHandlerContext, packet);
            return;
        }
        if (packet instanceof DisconnectS2CPacket) {
            DisconnectS2CPacket disconnectS2CPacket = (DisconnectS2CPacket)packet;
            this.disconnect(disconnectS2CPacket.reason());
            return;
        }
        if (this.isOpen()) {
            this.edd.add(packet);
            this.edc.onPacketReceived();
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        this.disconnect((Text)Text.translatable((String)a.c(1077229057, "\u3673\u4fcf\uc506\u5b67\ud0bc\u560c\uec5f\u65a5\ufbfc\u715a\uf6d3\u0ce9\u8235\u1b8e\u91f6\u172e\uad54\u22a2\ub817\u3e51\ub7a2\ucdff")));
    }

    void drain(long l) {
        Packet<?> packet;
        long l2 = System.nanoTime();
        while ((packet = this.edd.poll()) != null) {
            PacketListener packetListener = this.getPacketListener();
            if (packetListener == null || !this.isOpen()) {
                this.edd.clear();
                return;
            }
            if (packetListener.accepts(packet)) {
                this.edc.beforePacket(packet);
                try {
                    edb.edi(packet, packetListener);
                }
                catch (OffThreadException offThreadException) {
                }
                catch (RejectedExecutionException rejectedExecutionException) {
                    this.disconnect((Text)Text.translatable((String)a.d("\u4e1b\u37b2\ubd78\u2311\ua8db\u2e73\u943c\u1dc0\u8387\u092a\u8eee\u74c3\ufa5e\u63e2\ue9ab\u6f4a\ud509\u5ad9\uc06a\u4630\ucfc1\ub587\u3b6e\ua0e2\u268b\uac4d\u15fa\u9bb8\u0158\u8724\u0cbb\uf271\u7823\ue1d3\u6790\ued2a\u52e5\ud88d", 553167652, 2043929972)));
                    return;
                }
                catch (ClassCastException classCastException) {
                    this.disconnect((Text)Text.translatable((String)a.b("\ud024\ua98d\u2347\ubd2e\u36e4\ub04c\u0a03\u83ff\u1db8\u9715\u10d1\ueafc\u6461\ufddd\u7794\uf175\u4b36\uc4e6\u5e55\ud80f\u51fe\u2bb8\ua551\u3ec7\ub8bf\u3276\u8bd2\u058e\u9f7c\u1920\u92a8\u6c56\ue608\u7ffb\uf9a0\u731f\uccd9", 662032492)));
                    return;
                }
                catch (Throwable throwable) {
                    this.edc.onPacketError(packet, throwable);
                }
            }
            if (System.nanoTime() - l2 <= l) continue;
            return;
        }
    }

    int pending() {
        return this.edd.size();
    }

    private static <T extends PacketListener> void edi(Packet<T> packet, PacketListener packetListener) {
        packet.apply(packetListener);
    }

    private static /* synthetic */ int cz(int n, int n2) {
        return (n ^ n2) + 1986463061;
    }

    private static /* synthetic */ int da(int n, int n2) {
        return n * n2 | 0xEA900921;
    }
}

