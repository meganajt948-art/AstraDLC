/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package a;

import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class TargetPredictor {
    private static final int lql = 5;
    private static final double lqm = 0.08;
    private final class_238[] lqn = new class_238[40];
    private static /* synthetic */ long lqo;
    private static /* synthetic */ String lqp;

    public void predict(class_1297 class_12972, class_1937 class_19372) {
        class_238 class_2383 = class_12972.method_5829();
        double d = class_12972.method_23317() - class_12972.field_6014;
        double d2 = class_12972.method_23318() - class_12972.field_6036;
        double d3 = class_12972.method_23321() - class_12972.field_5969;
        boolean bl = class_12972.method_24828();
        d2 = bl ? 0.0 : (d2 - 0.08) * 0.98;
        for (int i = 0; i < this.lqn.length; ++i) {
            double d4;
            this.lqn[i] = class_2383;
            double d5 = i < 5 ? d : 0.0;
            double d6 = i < 5 ? d3 : 0.0;
            double d7 = d4 = bl ? 0.0 : d2;
            if (d5 == 0.0 && d4 == 0.0 && d6 == 0.0) continue;
            class_243 class_2432 = class_1297.method_20736((class_1297)class_12972, (class_243)new class_243(d5, d4, d6), (class_238)class_2383, (class_1937)class_19372, List.of());
            if (!bl) {
                if (class_2432.field_1351 != d4 && d4 < 0.0) {
                    bl = true;
                    d2 = 0.0;
                } else {
                    d2 = (d2 - 0.08) * 0.98;
                }
            }
            class_2383 = class_2383.method_997(class_2432);
        }
    }

    public class_238 box(int n) {
        return this.lqn[class_3532.method_15340((int)n, (int)0, (int)(this.lqn.length - 1))];
    }

    private static /* synthetic */ int aym(int n, int n2) {
        return n ^ n2 ^ 0xD6D5FB29;
    }

    private static /* synthetic */ int ayn(int n, int n2) {
        return TargetPredictor.aym(n, n2) ^ 0xDCFB0E1A;
    }
}

