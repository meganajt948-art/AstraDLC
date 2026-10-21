/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_746
 */
package a;

import net.minecraft.class_746;

public final class LandingTracker {
    private double lnc;
    private double lnd = Double.NaN;
    private static /* synthetic */ String lne;
    private static /* synthetic */ int lnf;

    public void reset() {
        this.lnc = 0.0;
        this.lnd = Double.NaN;
    }

    public void update(class_746 class_7462) {
        double d = class_7462.method_23318();
        double d2 = Double.isNaN(this.lnd) ? 0.0 : d - this.lnd;
        this.lnd = d;
        if (d2 > 0.0 || d2 < -4.0) {
            this.lnc = 0.0;
        } else if (d2 < 0.0 && !class_7462.method_5799()) {
            this.lnc -= d2;
        }
        this.lnc = Math.min(this.lnc, class_7462.field_6017);
    }

    public void landed() {
        this.lnc = 0.0;
    }

    public double get() {
        return this.lnc;
    }

    private static /* synthetic */ int axt(int n, int n2) {
        return n - n2 + 16186318;
    }
}

