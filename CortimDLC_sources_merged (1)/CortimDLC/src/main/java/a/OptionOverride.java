/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_310
 *  net.minecraft.class_4667
 *  net.minecraft.class_7172
 */
package a;

import a.Reflect;
import a.wbr;
import com.mojang.serialization.Codec;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import net.minecraft.class_310;
import net.minecraft.class_4667;
import net.minecraft.class_7172;

public final class OptionOverride<T> {
    private static final List<OptionOverride<?>> wbv = new ArrayList();
    private static Field wbw;
    private static Field wbx;
    private static boolean wby;
    private final Function<class_310, class_7172<T>> wbz;
    private class_7172<T> wca;
    private volatile boolean wcb;
    private volatile T wcc;
    private Object wcd;
    private static /* synthetic */ int wce;
    private static /* synthetic */ String wcf;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public OptionOverride(Function<class_310, class_7172<T>> function) {
        this.wbz = function;
        List<OptionOverride<?>> list = wbv;
        synchronized (list) {
            wbv.add(this);
        }
    }

    public boolean override(T t) {
        class_7172<T> class_71722 = this.wcg();
        if (class_71722 == null || !this.wch(class_71722)) {
            return false;
        }
        try {
            Object object = wbw.get(class_71722);
            if (!this.wcb || !Objects.equals(object, this.wcd)) {
                Object object2 = object;
                this.wcc = object2;
            }
            this.wcb = true;
            if (!Objects.equals(object, t)) {
                wbw.set(class_71722, t);
            }
            this.wcd = t;
            return true;
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            OptionOverride.wcj(exception);
            return false;
        }
    }

    public void release() {
        if (!this.wcb) {
            return;
        }
        this.wcb = false;
        class_7172<T> class_71722 = this.wcg();
        if (class_71722 != null && wbw != null) {
            try {
                wbw.set(class_71722, this.wcc);
            }
            catch (ReflectiveOperationException | RuntimeException exception) {
                OptionOverride.wcj(exception);
            }
        }
    }

    public boolean active() {
        return this.wcb;
    }

    public T own() {
        if (this.wcb) {
            return this.wcc;
        }
        class_7172<T> class_71722 = this.wcg();
        return (T)(class_71722 == null ? null : class_71722.method_41753());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void releaseAll() {
        List<OptionOverride<?>> list = wbv;
        synchronized (list) {
            for (OptionOverride<?> wbu2 : wbv) {
                wbu2.release();
            }
        }
    }

    public static boolean suspended(class_310 class_3102) {
        return class_3102.field_1755 instanceof class_4667;
    }

    private class_7172<T> wcg() {
        class_310 class_3102 = class_310.method_1551();
        return class_3102 == null || class_3102.field_1690 == null ? null : this.wbz.apply(class_3102);
    }

    private boolean wch(class_7172<T> class_71722) {
        if (wby) {
            return false;
        }
        if (wbw == null) {
            wbw = Reflect.find(class_7172.class, "net.minecraft.class_7172", "field_37868", "Ljava/lang/Object;");
            wbx = Reflect.find(class_7172.class, "net.minecraft.class_7172", "field_38279", "Lcom/mojang/serialization/Codec;");
            if (wbw == null) {
                wby = true;
                return false;
            }
        }
        if (this.wca != class_71722) {
            this.wca = class_71722;
            this.wci(class_71722);
        }
        return true;
    }

    private void wci(class_7172<T> class_71722) {
        if (wbx == null) {
            return;
        }
        try {
            Codec codec = class_71722.method_42404();
            wbx.set(class_71722, new wbr(this, codec));
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            System.out.println("an option is saved as it is while a module changes it: " + exception);
        }
    }

    private static void wcj(Throwable throwable) {
        if (!wby) {
            wby = true;
            System.out.println("options unavailable: " + throwable);
        }
    }

    private static /* synthetic */ int don(int n, int n2) {
        return n - n2 | 0xA2860A78;
    }
}

