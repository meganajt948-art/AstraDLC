/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  net.minecraft.class_1799
 *  net.minecraft.class_4587
 *  net.minecraft.class_742
 */
package a;

import a.vhs;
import a.vht;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_742;

public final class HandHooks {
    private static vht vhv;
    private static vhs vhw;
    private static /* synthetic */ String vhx;
    private static /* synthetic */ String vhy;

    private HandHooks() {
    }

    public static void register(vht vht2) {
        vhv = vht2;
    }

    public static void register(vhs vhs2) {
        vhw = vhs2;
    }

    static boolean changesHands() {
        return vhv != null && vhv.active() || vhw != null && vhw.active();
    }

    static void viewModel(class_4587 class_45872, class_1306 class_13062) {
        if (vhv != null && vhv.active()) {
            vhv.apply(class_45872, class_13062);
        }
    }

    static boolean swings(class_742 class_7422, class_1268 class_12682, class_1799 class_17992) {
        return vhw != null && vhw.active() && vhw.handles(class_7422, class_12682, class_17992);
    }

    static void swing(class_4587 class_45872, class_742 class_7422, class_1306 class_13062, class_1268 class_12682, float f, class_1799 class_17992, float f2) {
        vhw.apply(class_45872, class_7422, class_13062, class_12682, f, class_17992, f2);
    }

    private static /* synthetic */ int dfi(int n, int n2) {
        return n * n2 ^ 0xF350B945;
    }
}

