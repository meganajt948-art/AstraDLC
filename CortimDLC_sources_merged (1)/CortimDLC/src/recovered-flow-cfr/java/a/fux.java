/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.embedded.EmbeddedChannel
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.NetworkSide
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.state.NetworkState
 */
package a;

import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.state.NetworkState;

final class fux
extends ClientConnection {
    private final EmbeddedChannel fuy = new EmbeddedChannel();
    private static /* synthetic */ boolean fuz;
    private static /* synthetic */ int fva;

    fux() {
        super(NetworkSide.field_11941);
        try {
            for (Field field : ClientConnection.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != Channel.class) continue;
                field.setAccessible(true);
                field.set((Object)this, this.fuy);
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new IllegalStateException(reflectiveOperationException);
        }
    }

    void drain() {
        this.fuy.releaseOutbound();
    }

    public <T extends PacketListener> void method_56330(NetworkState<T> networkState, T t) {
    }

    public void method_56329(NetworkState<?> networkState) {
    }

    public void method_10768() {
    }

    public void method_10757() {
    }

    private static /* synthetic */ int rd(int n, int n2) {
        return (n ^ n2) + -1134532348;
    }

    private static /* synthetic */ int re(int n, int n2) {
        return fux.rd(n, n2) + n;
    }

    private static /* synthetic */ int rf(int n, int n2) {
        return n + n2 | 0x4DCDF2BA;
    }
}

