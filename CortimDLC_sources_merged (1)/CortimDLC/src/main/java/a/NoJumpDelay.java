/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_310
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1309;
import net.minecraft.class_310;

public class NoJumpDelay
extends Module {
    private static final Field lxq = Reflect.find(class_1309.class, "net.minecraft.class_1309", "field_6228", "I");
    private static NoJumpDelay lxr;
    private static /* synthetic */ int lxs;
    private static /* synthetic */ String lxt;

    public NoJumpDelay() {
        super("NoJumpDelay", "Jump again the instant you land", ModuleCategory.MOVEMENT);
        lxr = this;
    }

    public static boolean active() {
        return lxr != null && lxr.isEnabled();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (Reflect.getInt(lxq, class_3102.field_1724, 0) > 0) {
            Reflect.setInt(lxq, class_3102.field_1724, 0);
        }
    }

    private static /* synthetic */ int bah(int n, int n2) {
        return n + n2 ^ 0x3EF6B226;
    }

    private static /* synthetic */ int bai(int n, int n2) {
        return NoJumpDelay.bah(n, n2) ^ 0xEDEAEEB7;
    }
}

