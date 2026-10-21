/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1656
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.AncientFarmer;
import a.FreeCam;
import flow.dev.StringDecryptor;
import net.minecraft.class_1656;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public class DragonFly
extends Module {
    public static final double MAX_STEP = 9.5;
    public static final double SPEED = 40.0;
    public static final double VERTICAL = 25.0;
    private class_1656 lwr;
    private float lws;
    private static /* synthetic */ long lwt;
    private static /* synthetic */ boolean lwu;

    public DragonFly() {
        super("DragonFly", "Faster /fly flight: 40 b/s without inertia, 25 b/s up and down on jump and sneak", ModuleCategory.MOVEMENT);
    }

    @Override
    protected void onDisable() {
        this.lwv();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        class_243 class_2432;
        double d;
        double d2;
        this.lwv();
        class_746 class_7462 = class_3102.field_1724;
        class_1656 class_16562 = class_7462.method_31549();
        if (!class_16562.field_7479 || class_7462.method_7325() || class_7462.method_5765() || class_7462.field_6235 > 0 || FreeCam.active() || AncientFarmer.busy()) {
            return;
        }
        class_315 class_3152 = class_3102.field_1690;
        double d3 = DragonFly.lww(class_3152.field_1894.method_1434(), class_3152.field_1881.method_1434());
        double d4 = DragonFly.lww(class_3152.field_1913.method_1434(), class_3152.field_1849.method_1434());
        double d5 = DragonFly.lww(class_3152.field_1903.method_1434(), class_3152.field_1832.method_1434());
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = Math.hypot(d3, d4);
        if (d8 > 0.0) {
            d2 = 2.0 / d8;
            double d9 = Math.toRadians(class_7462.method_36454());
            double d10 = Math.sin(d9);
            double d11 = Math.cos(d9);
            d6 = (d4 * d11 - d3 * d10) * d2;
            d7 = (d3 * d11 + d4 * d10) * d2;
        }
        class_7462.method_18799((d = (class_2432 = new class_243(d6, d2 = d5 * 25.0 / 20.0, d7)).method_1033()) > 9.5 ? class_2432.method_1021(9.5 / d) : class_2432);
        this.lwr = class_16562;
        this.lws = class_16562.method_7252();
        class_16562.method_7248(0.0f);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        this.lwv();
    }

    private void lwv() {
        if (this.lwr != null) {
            this.lwr.method_7248(this.lws);
            this.lwr = null;
        }
    }

    private static double lww(boolean bl, boolean bl2) {
        return (bl ? 1 : 0) - (bl2 ? 1 : 0);
    }

    private static /* synthetic */ int azz(int n, int n2) {
        return n * n2 | 0x242A62DC;
    }

    private static /* synthetic */ int baa(int n, int n2) {
        return DragonFly.azz(n, n2) + n;
    }
}

