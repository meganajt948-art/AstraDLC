/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import a.AimPointPicker;
import a.SmashPredictor;
import a.lpc;
import a.lpp;
import a.TargetPredictor;
import java.util.List;
import java.util.function.ToIntFunction;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public final class PathAimPlanner {
    private static final float lpz = 0.9f;
    private final SmashPredictor lqa = new SmashPredictor();
    private final TargetPredictor lqb = new TargetPredictor();
    private final AimPointPicker lqc = new AimPointPicker();
    private class_1309 lqd;
    private static /* synthetic */ int lqe;
    private static /* synthetic */ int lqf;

    public SmashPredictor path() {
        return this.lqa;
    }

    public void forget() {
        this.lqd = null;
    }

    public lpp plan(class_746 class_7462, class_1937 class_19372, double d, List<class_1309> list, ToIntFunction<class_1309> toIntFunction, lpc lpc2) {
        lpp lpp2;
        this.lqa.threshold(lpc2.minFall(), lpc2.maxFall());
        this.lqa.predict(class_7462, class_19372, d);
        if (!this.lqa.smash(this.lqg())) {
            this.lqd = null;
            return null;
        }
        if (this.lqd != null && list.contains(this.lqd) && (lpp2 = this.lqh(class_7462, class_19372, this.lqd, toIntFunction.applyAsInt(this.lqd), lpc2)) != null) {
            return lpp2;
        }
        lpp2 = null;
        double d2 = Double.MAX_VALUE;
        for (class_1309 class_13092 : list) {
            lpp lpp3;
            if (class_13092 == this.lqd || (lpp3 = this.lqh(class_7462, class_19372, class_13092, toIntFunction.applyAsInt(class_13092), lpc2)) == null) continue;
            double d3 = this.lqb.box(lpp3.tick()).method_49271(lpp3.eye());
            if (lpp2 != null && lpp3.tick() >= lpp2.tick() && (lpp3.tick() != lpp2.tick() || !(d3 < d2))) continue;
            lpp2 = lpp3;
            d2 = d3;
        }
        if (lpp2 != null && lpp2.target() != this.lqd) {
            this.lqd = lpp2.target();
            this.lqc.roll(lpc2.spread());
            lpp2 = this.lqh(class_7462, class_19372, this.lqd, toIntFunction.applyAsInt(this.lqd), lpc2);
        }
        if (lpp2 == null) {
            this.lqd = null;
        }
        return lpp2;
    }

    public class_243 aimNow(class_1937 class_19372, class_746 class_7462, class_1309 class_13092, double d) {
        return this.lqc.resolve(class_19372, (class_1297)class_7462, class_7462.method_33571(), class_13092.method_5829(), d);
    }

    public void hit() {
        this.lqd = null;
    }

    private int lqg() {
        for (int i = 0; i < 40; ++i) {
            if (!this.lqa.smash(i)) continue;
            return i;
        }
        return -1;
    }

    private lpp lqh(class_746 class_7462, class_1937 class_19372, class_1309 class_13092, int n, lpc lpc2) {
        this.lqb.predict((class_1297)class_13092, class_19372);
        lpp lpp2 = null;
        lpp lpp3 = null;
        for (int i = Math.max(0, n); i < 40; ++i) {
            class_238 class_2383;
            class_243 class_2432;
            class_243 class_2433;
            boolean bl;
            if (!this.lqa.smash(i) || !(bl = this.lqa.safe(i)) && (!lpc2.lateSmash() || lpp3 != null) || (class_2433 = this.lqc.resolve(class_19372, (class_1297)class_7462, class_2432 = this.lqa.eye(i), class_2383 = this.lqb.box(i), lpc2.reach())) == null || !PathAimPlanner.lqi(lpc2, class_2432, class_2433, i)) continue;
            if (!bl) {
                lpp3 = new lpp(class_13092, i, false, class_2432, class_2433, class_2383);
                continue;
            }
            boolean bl2 = lpc2.crits() && PathAimPlanner.lqj(class_7462, i) && (i >= 1 || !lpc2.serverSprinting());
            lpp lpp4 = new lpp(class_13092, i, bl2, class_2432, class_2433, class_2383);
            if (bl2 || !lpc2.crits()) {
                return lpp4;
            }
            if (lpp2 != null) continue;
            lpp2 = lpp4;
        }
        return lpp2 != null ? lpp2 : lpp3;
    }

    private static boolean lqi(lpc lpc2, class_243 class_2432, class_243 class_2433, int n) {
        double d;
        double d2 = class_3532.method_15393((float)(AimPointPicker.yaw(class_2432, class_2433) - lpc2.lookYaw()));
        return Math.sqrt(d2 * d2 + (d = (double)(AimPointPicker.pitch(class_2432, class_2433) - lpc2.lookPitch())) * d) <= lpc2.maxTurn() * (double)(n + 1) + 0.5;
    }

    private static boolean lqj(class_746 class_7462, int n) {
        return class_7462.method_7261(0.5f + (float)n) > 0.9f;
    }

    private static /* synthetic */ int ayh(int n, int n2) {
        return n ^ n2 | 0x7528EDA;
    }

    private static /* synthetic */ int ayi(int n, int n2) {
        return n + n2 + -1740593591;
    }

    private static /* synthetic */ int ayj(int n, int n2) {
        return n + n2 ^ 0x40DFB862;
    }
}

