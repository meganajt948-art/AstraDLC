/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 */
package a;

import net.minecraft.client.network.ClientPlayerEntity;

public final class lnb {
    private double lnc;
    private double lnd = Double.NaN;
    private static /* synthetic */ String lne;
    private static /* synthetic */ int lnf;

    public void reset() {
        this.lnc = 0.0;
        this.lnd = Double.NaN;
    }

    public void update(ClientPlayerEntity clientPlayerEntity) {
        double d = clientPlayerEntity.getY();
        double d2 = Double.isNaN(this.lnd) ? 0.0 : d - this.lnd;
        this.lnd = d;
        if (d2 > 0.0 || d2 < -4.0) {
            this.lnc = 0.0;
        } else if (d2 < 0.0 && !clientPlayerEntity.isTouchingWater()) {
            this.lnc -= d2;
        }
        this.lnc = Math.min(this.lnc, clientPlayerEntity.fallDistance);
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

