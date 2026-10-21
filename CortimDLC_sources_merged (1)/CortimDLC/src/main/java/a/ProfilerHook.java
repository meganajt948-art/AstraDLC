/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_3695
 *  net.minecraft.class_5962
 */
package a;

import a.BotManager;
import a.BotRuntime;
import a.AutoWarden;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_310;
import net.minecraft.class_3695;
import net.minecraft.class_5962;

public final class ProfilerHook
implements class_5962 {
    private static final Field elm = Reflect.find(class_310.class, "net.minecraft.class_310", "field_29569", "Lnet/minecraft/class_5962;");
    private final class_5962 eln;
    private static /* synthetic */ int elo;
    private static /* synthetic */ int elp;

    private ProfilerHook(class_5962 class_59622) {
        this.eln = class_59622;
    }

    public static void ensure(class_310 class_3102) {
        if (elm == null || class_3102 == null) {
            return;
        }
        try {
            Object object = elm.get(class_3102);
            if (object instanceof ProfilerHook || !(object instanceof class_5962)) {
                return;
            }
            class_5962 class_59622 = (class_5962)object;
            elm.set(class_3102, new ProfilerHook(class_59622));
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            // empty catch block
        }
    }

    public void method_34770() {
        this.eln.method_34770();
    }

    public void method_41320() {
        this.eln.method_41320();
    }

    public void method_34771() {
        this.eln.method_34771();
    }

    public boolean method_34773() {
        return this.eln.method_34773();
    }

    public class_3695 method_34774() {
        return this.eln.method_34774();
    }

    public void method_34772() {
        this.eln.method_34772();
        if (BotRuntime.isActive()) {
            return;
        }
        try {
            AutoWarden.onFrame();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            BotManager.onFrame();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int he(int n, int n2) {
        return n + n2 | 0xB2EC016D;
    }

    private static /* synthetic */ int hf(int n, int n2) {
        return n + n2 ^ 0xBC6E05D;
    }
}

