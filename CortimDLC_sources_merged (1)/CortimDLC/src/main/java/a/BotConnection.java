/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2598
 *  net.minecraft.class_2661
 *  net.minecraft.class_2896
 *  net.minecraft.class_2987
 *  net.minecraft.class_9812
 */
package a;

import a.Bot;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2598;
import net.minecraft.class_2661;
import net.minecraft.class_2896;
import net.minecraft.class_2987;
import net.minecraft.class_9812;

final class BotConnection
extends class_2535 {
    private final Bot edc;
    private final ConcurrentLinkedQueue<class_2596<?>> edd = new ConcurrentLinkedQueue();
    private volatile Channel ede;
    private static /* synthetic */ int edf;
    private static /* synthetic */ String edg;

    BotConnection(Bot dtv2) {
        super(class_2598.field_11942);
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

    public void method_60924(class_9812 class_98122) {
        Channel channel = this.ede;
        if (channel != null && !channel.eventLoop().inEventLoop()) {
            channel.eventLoop().execute(() -> this.edh(class_98122));
            return;
        }
        super.method_60924(class_98122);
    }

    private void edh(class_9812 class_98122) {
        super.method_60924(class_98122);
    }

    protected void method_10770(ChannelHandlerContext channelHandlerContext, class_2596<?> class_25962) {
        class_2547 class_25472 = this.method_10744();
        if (class_25472 == null || class_25472 instanceof class_2896) {
            super.method_10770(channelHandlerContext, class_25962);
            return;
        }
        if (class_25962 instanceof class_2661) {
            class_2661 class_26612 = (class_2661)class_25962;
            this.method_10747(class_26612.comp_2325());
            return;
        }
        if (this.method_10758()) {
            this.edd.add(class_25962);
            this.edc.onPacketReceived();
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        this.method_10747((class_2561)class_2561.method_43471((String)"disconnect.endOfStream"));
    }

    void drain(long l) {
        class_2596<?> class_25962;
        long l2 = System.nanoTime();
        while ((class_25962 = this.edd.poll()) != null) {
            class_2547 class_25472 = this.method_10744();
            if (class_25472 == null || !this.method_10758()) {
                this.edd.clear();
                return;
            }
            if (class_25472.method_52413(class_25962)) {
                this.edc.beforePacket(class_25962);
                try {
                    BotConnection.edi(class_25962, class_25472);
                }
                catch (class_2987 class_29872) {
                }
                catch (RejectedExecutionException rejectedExecutionException) {
                    this.method_10747((class_2561)class_2561.method_43471((String)"multiplayer.disconnect.server_shutdown"));
                    return;
                }
                catch (ClassCastException classCastException) {
                    this.method_10747((class_2561)class_2561.method_43471((String)"multiplayer.disconnect.invalid_packet"));
                    return;
                }
                catch (Throwable throwable) {
                    this.edc.onPacketError(class_25962, throwable);
                }
            }
            if (System.nanoTime() - l2 <= l) continue;
            return;
        }
    }

    int pending() {
        return this.edd.size();
    }

    private static <T extends class_2547> void edi(class_2596<T> class_25962, class_2547 class_25472) {
        class_25962.method_65081(class_25472);
    }

    private static /* synthetic */ int cz(int n, int n2) {
        return (n ^ n2) + 1986463061;
    }

    private static /* synthetic */ int da(int n, int n2) {
        return n * n2 | 0xEA900921;
    }
}

