/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.BundlePacket
 *  net.minecraft.network.packet.Packet
 */
package a;

import a.ejp;
import a.wck;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.BundlePacket;
import net.minecraft.network.packet.Packet;

public final class wcn {
    private static final String wco = a.d("\u3c86\u453d\ucfed\u5184\uda16\u5cca\ue6b4\u6f52\uf109\u7bbd\ufc6f\u0609", 437783686, -1226887062);
    private static final String wcp = a.d("\u2999\u5039\udae8\u4491\ucf48\u49e8\uf390\u7a56\ue400\u6ebe\ue967\u131e\u9dc0\u0466", -652043958, 908439725);
    private static final List<Consumer<Packet<?>>> wcq = new CopyOnWriteArrayList();
    private static final List<UnaryOperator<Packet<?>>> wcr = new CopyOnWriteArrayList();
    private static Field wcs;
    private static boolean wct;
    private static /* synthetic */ boolean wcu;
    private static /* synthetic */ boolean wcv;

    private wcn() {
    }

    public static void listen(Consumer<Packet<?>> consumer) {
        wcq.add(consumer);
    }

    public static void rewrite(UnaryOperator<Packet<?>> unaryOperator) {
        wcr.add(unaryOperator);
    }

    public static void ensure(MinecraftClient minecraftClient) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.getNetworkHandler();
        if (clientPlayNetworkHandler == null || wct || ejp.isActive()) {
            return;
        }
        Channel channel = wcn.channel(clientPlayNetworkHandler.getConnection());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        ChannelPipeline channelPipeline = channel.pipeline();
        if (channelPipeline.get(a.c(2101498861, "\u5387\u2a3c\ua0ec\u3e85\ub517\u33cb\u89b5S\u9e08\u14bc\u936e\u6908")) != null || channelPipeline.get(a.d("\u579d\u2e3d\ua4ec\u3a95\ub14c\u37ec\u8d94\u0452\u9a04\u10ba\u9763\u6d1a\ue3c4\u7a62", -2063449462, 55645545)) == null) {
            return;
        }
        try {
            channelPipeline.addBefore(a.c(475920570, "\uf8c4\u8164\u0bb5\u95cc\u1e15\u98b5\u22cd\uab0b\u355d\ubfe3\u383a\uc243\u4c9d\ud53b"), a.b("\u338d\u4a36\uc0e6\u5e8f\ud51d\u53c1\ue9bf\u6059\ufe02\u74b6\uf364\u0902", -960744473), (ChannelHandler)new wck());
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    static Channel channel(ClientConnection clientConnection) {
        try {
            if (wcs == null) {
                for (Field field : ClientConnection.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Channel.class.isAssignableFrom(field.getType())) continue;
                    field.setAccessible(true);
                    wcs = field;
                    break;
                }
                if (wcs == null) {
                    throw new IllegalStateException(a.b("\ue403\u9db3\u172f\u891d\u02c1\u8479\u3e25\ub7d4\u2980\ua338\u24a7\ude90\u5048\uc9f5\u43af\uc556", 520610941));
                }
            }
            return (Channel)wcs.get(clientConnection);
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            wct = true;
            System.out.println(a.d("\ud93a\ua09a\u2a4b\ub432\u3feb\ub94b\u034c\u8af5\u14ad\u9e1c\u19cb\ue3f1\u6d73\uf4d9\u7e85\uf863\u423b\ucde2\u5754\ud108\u58fc\u22a3\uac19\u3797\ub1f2", -2125612801, 506683820) + exception);
            return null;
        }
    }

    private static void wcw(Packet<?> packet) {
        if (packet instanceof BundlePacket) {
            BundlePacket bundlePacket = (BundlePacket)packet;
            for (Packet packet2 : bundlePacket.getPackets()) {
                wcn.wcw(packet2);
            }
            return;
        }
        for (Consumer<Packet<?>> consumer : wcq) {
            try {
                consumer.accept(packet);
            }
            catch (Throwable throwable) {}
        }
    }

    private static Packet<?> wcx(Packet<?> packet) {
        for (UnaryOperator<Packet<?>> unaryOperator : wcr) {
            try {
                Packet packet2 = (Packet)unaryOperator.apply(packet);
                if (packet2 == null) continue;
                packet = packet2;
            }
            catch (Throwable throwable) {}
        }
        return packet;
    }

    private static /* synthetic */ int dov(int n, int n2) {
        return n * n2 + -969162945;
    }

    private static /* synthetic */ int dow(int n, int n2) {
        return n * n2 + 523982686;
    }

    private static /* synthetic */ int dox(int n, int n2) {
        return wcn.dov(n, n2) * n2;
    }
}

