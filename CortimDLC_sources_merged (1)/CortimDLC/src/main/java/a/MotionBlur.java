/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_638
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.MotionBlurPass;
import a.ModeSetting;
import a.NumberSetting;
import java.util.Arrays;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class MotionBlur
extends Module {
    private static final float riw = 0.045f;
    private static final float rix = 0.16f;
    private static final long riy = 250000000L;
    private final NumberSetting riz = this.add(new NumberSetting("\u0421\u0438\u043b\u0430", 0.5, 0.05, 1.0, 0.05).percent());
    private final NumberSetting rja = this.add(new NumberSetting("\u041f\u043b\u0430\u0432\u043d\u043e\u0441\u0442\u044c", 0.5, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rjb = this.add(new NumberSetting("\u041e\u0442 \u0434\u0432\u0438\u0436\u0435\u043d\u0438\u044f", 0.5, 0.0, 1.0, 0.05).percent());
    private final ModeSetting rjc = this.add(new ModeSetting("\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435", "\u041d\u0438\u0437\u043a\u043e\u0435", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435", "\u0423\u043b\u044c\u0442\u0440\u0430"));
    private static float rjd;
    private final Quaternionf rje = new Quaternionf();
    private final Quaternionf rjf = new Quaternionf();
    private final Quaternionf rjg = new Quaternionf();
    private final Matrix4f rjh = new Matrix4f();
    private final Matrix4f rji = new Matrix4f();
    private final float[] rjj = new float[3];
    private final float[] rjk = new float[3];
    private final float[] rjl = new float[3];
    private final float[] rjm = new float[3];
    private class_243 rjn;
    private class_638 rjo;
    private long rjp;
    private float rjq;
    private float rjr;
    private float rjs;
    private static /* synthetic */ int rjt;
    private static /* synthetic */ boolean rju;

    public MotionBlur() {
        super(new String(new char[]{'M', 'o', 't', 'i', 'o', 'n', 'B', 'l', 'u', 'r'}), "Smooth motion blur, hand and HUD stay sharp", ModuleCategory.RENDER);
    }

    public static float turnSpeed() {
        return rjd;
    }

    @Override
    protected void onEnable() {
        this.rjv();
    }

    @Override
    protected void onDisable() {
        MotionBlurPass.release();
        this.rjv();
    }

    private void rjv() {
        this.rjn = null;
        this.rjo = null;
        this.rjp = 0L;
        this.rjq = 0.0f;
        this.rjr = 0.0f;
        this.rjs = 0.0f;
        Arrays.fill(this.rjj, 0.0f);
        Arrays.fill(this.rjk, 0.0f);
        Arrays.fill(this.rjl, 0.0f);
        Arrays.fill(this.rjm, 0.0f);
        rjd = 0.0f;
    }

    @Override
    public void onWorldRenderLate(class_310 class_3102) {
        int n;
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        if (class_3102.field_1687 == null || !class_41842.method_19332()) {
            this.rjv();
            return;
        }
        long l = System.nanoTime();
        Quaternionf quaternionf = class_41842.method_23767();
        class_243 class_2432 = class_41842.method_71156();
        if (this.rjn == null || this.rjo != class_3102.field_1687 || l - this.rjp > 250000000L) {
            this.rjv();
            this.rje.set((Quaternionfc)quaternionf);
            this.rjn = class_2432;
            this.rjo = class_3102.field_1687;
            this.rjp = l;
            return;
        }
        float f = (float)(l - this.rjp) / 1.0E9f;
        if (f < 1.0E-4f) {
            return;
        }
        this.rjp = l;
        float f2 = this.rjs + (this.rjq > 0.0f ? this.rjq : f);
        boolean bl = this.rjs < 0.1f && this.rjr > 0.0f && f > this.rjr * 2.5f + 0.004f;
        this.rjr = this.rjr == 0.0f ? f : this.rjr + (Math.min(f, this.rjr * 3.0f) - this.rjr) * 0.05f;
        this.rjq = f;
        if (bl) {
            this.rjs = f2;
        } else {
            this.rjs = 0.0f;
            this.rjw(quaternionf, class_2432, f2);
        }
        float f3 = 0.045f * (float)this.riz.get();
        float f4 = this.rjk[0] * f3;
        float f5 = this.rjk[1] * f3;
        float f6 = this.rjk[2] * f3;
        float f7 = (float)Math.sqrt(f4 * f4 + f5 * f5 + f6 * f6);
        rjd = (float)Math.toDegrees(f7 / f3);
        float f8 = f3 * (float)this.rjb.get();
        float f9 = this.rjm[0] * f8;
        float f10 = this.rjm[1] * f8;
        float f11 = this.rjm[2] * f8;
        if (f7 < 2.5E-4f && f9 * f9 + f10 * f10 + f11 * f11 < 2.5E-7f) {
            return;
        }
        if (f7 > 1.0E-7f) {
            this.rjg.rotationAxis(-f7, f4, f5, f6).mul((Quaternionfc)quaternionf);
        } else {
            this.rjg.set((Quaternionfc)quaternionf);
        }
        this.rjh.rotation((Quaternionfc)quaternionf);
        this.rji.rotation((Quaternionfc)this.rjg.conjugate());
        MotionBlurPass.draw(this.rjh, this.rji, f9, f10, f11, 0.16f, n, switch (this.rjc.get()) {
            case "\u041d\u0438\u0437\u043a\u043e\u0435" -> {
                n = 6;
                yield 0.75f;
            }
            case "\u0421\u0440\u0435\u0434\u043d\u0435\u0435" -> {
                n = 9;
                yield 0.9f;
            }
            case "\u0423\u043b\u044c\u0442\u0440\u0430" -> {
                n = 16;
                yield 1.3f;
            }
            default -> {
                n = 12;
                yield 1.1f;
            }
        });
    }

    private void rjw(Quaternionf quaternionf, class_243 class_2432, float f) {
        this.rje.conjugate(this.rjf);
        quaternionf.mul((Quaternionfc)this.rjf, this.rjf);
        if (this.rjf.w < 0.0f) {
            this.rjf.set(-this.rjf.x, -this.rjf.y, -this.rjf.z, -this.rjf.w);
        }
        float f2 = (float)Math.sqrt(this.rjf.x * this.rjf.x + this.rjf.y * this.rjf.y + this.rjf.z * this.rjf.z);
        float f3 = 2.0f * (float)Math.atan2(f2, this.rjf.w);
        float f4 = (f2 > 1.0E-7f ? f3 / f2 : 2.0f) / f;
        double d = class_2432.method_1022(this.rjn);
        float f5 = 1.0f - (float)Math.exp(-2.0f * f / (0.015f + 0.05f * (float)this.rja.get()));
        if (f3 < 2.2f) {
            MotionBlur.rjx(this.rjj, this.rjk, this.rjf.x * f4, this.rjf.y * f4, this.rjf.z * f4, f5);
        }
        if (d / (double)f > 80.0) {
            Arrays.fill(this.rjl, 0.0f);
            Arrays.fill(this.rjm, 0.0f);
        } else {
            MotionBlur.rjx(this.rjl, this.rjm, (float)(class_2432.field_1352 - this.rjn.field_1352) / f, (float)(class_2432.field_1351 - this.rjn.field_1351) / f, (float)(class_2432.field_1350 - this.rjn.field_1350) / f, f5);
        }
        this.rje.set((Quaternionfc)quaternionf);
        this.rjn = class_2432;
    }

    private static void rjx(float[] fArray, float[] fArray2, float f, float f2, float f3, float f4) {
        fArray[0] = fArray[0] + (f - fArray[0]) * f4;
        fArray[1] = fArray[1] + (f2 - fArray[1]) * f4;
        fArray[2] = fArray[2] + (f3 - fArray[2]) * f4;
        fArray2[0] = fArray2[0] + (fArray[0] - fArray2[0]) * f4;
        fArray2[1] = fArray2[1] + (fArray[1] - fArray2[1]) * f4;
        fArray2[2] = fArray2[2] + (fArray[2] - fArray2[2]) * f4;
    }

    private static /* synthetic */ int bza(int n, int n2) {
        return n * n2 ^ 0x6F97E935;
    }

    private static /* synthetic */ int bzb(int n, int n2) {
        return MotionBlur.bza(n, n2) * n2;
    }

    private static /* synthetic */ int bzc(int n, int n2) {
        return n - n2 ^ 0x6353E7B;
    }
}

