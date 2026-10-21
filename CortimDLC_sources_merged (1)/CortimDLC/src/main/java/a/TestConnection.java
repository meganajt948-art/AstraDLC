/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.embedded.EmbeddedChannel
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2598
 *  net.minecraft.class_9127
 */
package a;

import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2598;
import net.minecraft.class_9127;

final class TestConnection
extends class_2535 {
    private final EmbeddedChannel fuy = new EmbeddedChannel();
    private static /* synthetic */ boolean fuz;
    private static /* synthetic */ int fva;

    TestConnection() {
        super(class_2598.field_11941);
        try {
            for (Field field : class_2535.class.getDeclaredFields()) {
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

    public <T extends class_2547> void method_56330(class_9127<T> class_91272, T t) {
    }

    public void method_56329(class_9127<?> class_91272) {
    }

    public void method_10768() {
    }

    public void method_10757() {
    }

    private static /* synthetic */ int rd(int n, int n2) {
        return (n ^ n2) + -1134532348;
    }

    private static /* synthetic */ int re(int n, int n2) {
        return TestConnection.rd(n, n2) + n;
    }

    private static /* synthetic */ int rf(int n, int n2) {
        return n + n2 | 0x4DCDF2BA;
    }
}

