/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.class_2535
 *  net.minecraft.class_2596
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_8038
 */
package a;

import a.BotRuntime;
import a.wck;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import net.minecraft.class_2535;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_8038;

public final class PacketHooks {
    private static final String wco = "flow2_reader";
    private static final String wcp = "packet_handler";
    private static final List<Consumer<class_2596<?>>> wcq = new CopyOnWriteArrayList();
    private static final List<UnaryOperator<class_2596<?>>> wcr = new CopyOnWriteArrayList();
    private static Field wcs;
    private static boolean wct;
    private static /* synthetic */ boolean wcu;
    private static /* synthetic */ boolean wcv;

    private PacketHooks() {
    }

    public static void listen(Consumer<class_2596<?>> consumer) {
        wcq.add(consumer);
    }

    public static void rewrite(UnaryOperator<class_2596<?>> unaryOperator) {
        wcr.add(unaryOperator);
    }

    public static void ensure(class_310 class_3102) {
        class_634 class_6342 = class_3102.method_1562();
        if (class_6342 == null || wct || BotRuntime.isActive()) {
            return;
        }
        Channel channel = PacketHooks.channel(class_6342.method_48296());
        if (channel == null || !channel.isOpen()) {
            return;
        }
        ChannelPipeline channelPipeline = channel.pipeline();
        if (channelPipeline.get("flow2_reader") != null || channelPipeline.get("packet_handler") == null) {
            return;
        }
        try {
            channelPipeline.addBefore("packet_handler", "flow2_reader", (ChannelHandler)new wck());
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    static Channel channel(class_2535 class_25352) {
        try {
            if (wcs == null) {
                for (Field field : class_2535.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Channel.class.isAssignableFrom(field.getType())) continue;
                    field.setAccessible(true);
                    wcs = field;
                    break;
                }
                if (wcs == null) {
                    throw new IllegalStateException("no channel field");
                }
            }
            return (Channel)wcs.get(class_25352);
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            wct = true;
            System.out.println("packet hook unavailable: " + exception);
            return null;
        }
    }

    private static void wcw(class_2596<?> class_25962) {
        if (class_25962 instanceof class_8038) {
            class_8038 class_80382 = (class_8038)class_25962;
            for (class_2596 class_25963 : class_80382.method_48324()) {
                PacketHooks.wcw(class_25963);
            }
            return;
        }
        for (Consumer<class_2596<?>> consumer : wcq) {
            try {
                consumer.accept(class_25962);
            }
            catch (Throwable throwable) {}
        }
    }

    private static class_2596<?> wcx(class_2596<?> class_25962) {
        for (UnaryOperator<class_2596<?>> unaryOperator : wcr) {
            try {
                class_2596 class_25963 = (class_2596)unaryOperator.apply(class_25962);
                if (class_25963 == null) continue;
                class_25962 = class_25963;
            }
            catch (Throwable throwable) {}
        }
        return class_25962;
    }

    private static /* synthetic */ int dov(int n, int n2) {
        return n * n2 + -969162945;
    }

    private static /* synthetic */ int dow(int n, int n2) {
        return n * n2 + 523982686;
    }

    private static /* synthetic */ int dox(int n, int n2) {
        return PacketHooks.dov(n, n2) * n2;
    }
}

