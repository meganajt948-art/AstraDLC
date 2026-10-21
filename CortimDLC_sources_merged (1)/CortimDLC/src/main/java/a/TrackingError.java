/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import a.AngleUtil;
import a.RecorderHooks;
import java.util.Random;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public final class TrackingError {
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

    public double error(class_746 class_7462, class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(class_7462.method_33571());
        double d = AngleUtil.yawTo(class_2433.field_1352, class_2433.field_1350);
        double d2 = AngleUtil.pitchTo(class_2433.field_1351, Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350));
        return Math.hypot(class_3532.method_15338((double)(d - (double)class_7462.method_36454())), d2 - (double)class_7462.method_36455());
    }

    public void aim(class_310 class_3102, class_746 class_7462, Object object, class_243 class_2432) {
        double d;
        if (class_2432 == null || object == null) {
            this.qmm = null;
            return;
        }
        if (object != this.qmm) {
            this.qmm = object;
            this.qmn = (this.qmi.nextDouble() - 0.5) * 0.3;
        }
        class_243 class_2433 = class_2432.method_1020(class_7462.method_33571());
        double d2 = Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350);
        double d3 = class_3532.method_15338((double)(AngleUtil.yawTo(class_2433.field_1352, class_2433.field_1350) - (double)class_7462.method_36454()));
        double d4 = Math.hypot(d3, d = AngleUtil.pitchTo(class_2433.field_1351, d2) - (double)class_7462.method_36455());
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
        this.qmq(class_3102, class_7462, d7, d8);
    }

    private void qmq(class_310 class_3102, class_746 class_7462, double d, double d2) {
        double d3 = RecorderHooks.unit(class_3102);
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
        float f = class_7462.field_5982;
        float f2 = class_7462.field_6004;
        double d4 = d3 / 0.15;
        class_7462.method_5872((double)l * d4, (double)l2 * d4);
        class_7462.field_5982 = f;
        class_7462.field_6004 = f2;
    }

    private static /* synthetic */ int bsz(int n, int n2) {
        return n * n2 ^ 0xA86C8237;
    }

    private static /* synthetic */ int bta(int n, int n2) {
        return TrackingError.bsz(n, n2) ^ 0x4A796410;
    }
}

