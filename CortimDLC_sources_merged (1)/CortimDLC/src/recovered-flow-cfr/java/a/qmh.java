/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.tbp;
import a.tcz;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class qmh {
    private final Random qmi = new Random();
    private double qmj = 110.0;
    private double qmk;
    private double qml;
    private Object qmm;
    private double qmn;
    private static /* synthetic */ String qmo;
    private static /* synthetic */ boolean qmp;

    public void cap(double d) {
        this.qmj = d;
    }

    public double cap() {
        return this.qmj;
    }

    public void reset() {
        this.qmk = 0.0;
        this.qml = 0.0;
        this.qmm = null;
    }

    public double error(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d) {
        Vec3d vec3d2 = vec3d.method_1020(clientPlayerEntity.method_33571());
        double d = tbp.yawTo(vec3d2.field_1352, vec3d2.field_1350);
        double d2 = tbp.pitchTo(vec3d2.field_1351, Math.sqrt(vec3d2.field_1352 * vec3d2.field_1352 + vec3d2.field_1350 * vec3d2.field_1350));
        return Math.hypot(MathHelper.method_15338((double)(d - (double)clientPlayerEntity.method_36454())), d2 - (double)clientPlayerEntity.method_36455());
    }

    public void aim(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Object object, Vec3d vec3d) {
        double d;
        if (vec3d == null || object == null) {
            this.qmm = null;
            return;
        }
        if (object != this.qmm) {
            this.qmm = object;
            this.qmn = (this.qmi.nextDouble() - 0.5) * 0.3;
        }
        Vec3d vec3d2 = vec3d.method_1020(clientPlayerEntity.method_33571());
        double d2 = Math.sqrt(vec3d2.field_1352 * vec3d2.field_1352 + vec3d2.field_1350 * vec3d2.field_1350);
        double d3 = MathHelper.method_15338((double)(tbp.yawTo(vec3d2.field_1352, vec3d2.field_1350) - (double)clientPlayerEntity.method_36454()));
        double d4 = Math.hypot(d3, d = tbp.pitchTo(vec3d2.field_1351, d2) - (double)clientPlayerEntity.method_36455());
        if (d4 < 0.25) {
            return;
        }
        double d5 = d4 <= 6.0 ? d4 : (d4 <= this.qmj ? d4 * (0.985 + this.qmi.nextDouble() * 0.015) : this.qmj * (0.92 + this.qmi.nextDouble() * 0.08));
        double d6 = d5 / d4;
        double d7 = d3 * d6;
        double d8 = d * d6;
        if (d4 > 8.0) {
            double d9 = this.qmn * (1.0 - Math.min(1.0, d5 / d4));
            d7 += -d * d6 * d9;
            d8 += d3 * d6 * d9;
        }
        this.qmq(minecraftClient, clientPlayerEntity, d7, d8);
    }

    private void qmq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, double d, double d2) {
        double d3 = tcz.unit(minecraftClient);
        if (d3 <= 0.0) {
            return;
        }
        this.qmk += d / d3;
        this.qml += d2 / d3;
        long l = Math.round(this.qmk);
        long l2 = Math.round(this.qml);
        this.qmk -= (double)l;
        this.qml -= (double)l2;
        if (l == 0L && l2 == 0L) {
            return;
        }
        float f = clientPlayerEntity.field_5982;
        float f2 = clientPlayerEntity.field_6004;
        double d4 = d3 / 0.15;
        clientPlayerEntity.method_5872((double)l * d4, (double)l2 * d4);
        clientPlayerEntity.field_5982 = f;
        clientPlayerEntity.field_6004 = f2;
    }

    private static /* synthetic */ int bsz(int n, int n2) {
        return n * n2 ^ 0xA86C8237;
    }

    private static /* synthetic */ int bta(int n, int n2) {
        return qmh.bsz(n, n2) ^ 0x4A796410;
    }
}

