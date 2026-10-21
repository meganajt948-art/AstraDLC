/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  net.minecraft.class_12206
 *  net.minecraft.class_1944
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2874$class_12326
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.DaylightUtil;
import a.CloudHider;
import a.FogPass;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import com.mojang.blaze3d.buffers.Std140Builder;
import java.util.Arrays;
import net.minecraft.class_12206;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2874;
import net.minecraft.class_2902;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class SnowRender
extends Module {
    private static final int rxw = 7;
    private static final float rxx = 3.0f;
    private static final float rxy = (float)Math.PI / 180;
    private final ColorSetting rxz = this.add(new ColorSetting("\u0426\u0432\u0435\u0442", "Snow"));
    private final NumberSetting rya = this.add(new NumberSetting("\u041f\u043b\u043e\u0442\u043d\u043e\u0441\u0442\u044c", 0.45, 0.0, 1.0, 0.01).percent());
    private final NumberSetting ryb = this.add(new NumberSetting("\u041f\u0440\u043e\u0437\u0440\u0430\u0447\u043d\u043e\u0441\u0442\u044c", 0.1, 0.0, 0.95, 0.01).percent());
    private final NumberSetting ryc = this.add(new NumberSetting("\u041a\u043b\u0443\u0431\u044b", 0.7, 0.0, 1.0, 0.05).percent());
    private final NumberSetting ryd = this.add(new NumberSetting("\u042f\u0440\u043a\u043e\u0441\u0442\u044c", 1.0, 0.3, 2.0, 0.05).percent());
    private final NumberSetting rye = this.add(new NumberSetting("\u0421\u043f\u0430\u0434 \u043f\u043e \u0432\u044b\u0441\u043e\u0442\u0435", 0.15, 0.0, 1.0, 0.05).percent());
    private final NumberSetting ryf = this.add(new NumberSetting("\u0420\u0430\u0437\u043c\u0435\u0440", 1.0, 0.4, 2.5, 0.05).percent());
    private final NumberSetting ryg = this.add(new NumberSetting("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c", 1.0, 0.0, 3.0, 0.1).unit("x"));
    private final NumberSetting ryh = this.add(new NumberSetting("\u0417\u0430\u0432\u0438\u0445\u0440\u0435\u043d\u0438\u044f", 1.0, 0.0, 2.0, 0.05).percent());
    private final NumberSetting ryi = this.add(new NumberSetting("\u0421\u0432\u0435\u0442 \u0441\u043e\u043b\u043d\u0446\u0430", 1.0, 0.0, 2.0, 0.05).percent());
    private final BoolSetting ryj = this.add(new BoolSetting("\u0421\u043a\u0440\u044b\u0442\u044c \u043e\u0431\u043b\u0430\u043a\u0430", true));
    private final ModeSetting ryk = this.add(new ModeSetting("\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u041d\u0438\u0437\u043a\u043e\u0435", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435", "\u0423\u043b\u044c\u0442\u0440\u0430"));
    private final BoolSetting ryl = this.add(new BoolSetting("\u0420\u0430\u0441\u0441\u0442\u0443\u043f\u0430\u0435\u0442\u0441\u044f", true));
    private final double[] rym = new double[7];
    private final double[] ryn = new double[7];
    private final double[] ryo = new double[7];
    private final float[] ryp = new float[7];
    private final float[] ryq = new float[7];
    private final float[] ryr = new float[7];
    private final long[] rys = new long[7];
    private final Matrix4f ryt = new Matrix4f();
    private final Matrix4f ryu = new Matrix4f();
    private final Quaternionf ryv = new Quaternionf();
    private class_243 ryw;
    private long ryx;
    private float ryy;
    private double ryz;
    private double rza;
    private double rzb;
    private double rzc = Double.NaN;
    private float rzd = -1.0f;
    private float rze;
    private class_243 rzf;
    private class_243 rzg;
    private double rzh;
    private double rzi;
    private double rzj;
    private static /* synthetic */ String rzk;
    private static /* synthetic */ int rzl;

    public SnowRender() {
        super(new String(new char[]{'V', 'o', 'l', 'u', 'm', 'e', 't', 'r', 'i', 'c', 'F', 'o', 'g'}), "Volumetric fog that curls around you", ModuleCategory.RENDER);
    }

    @Override
    protected void onEnable() {
        this.rzm();
    }

    @Override
    protected void onDisable() {
        this.rzn(false);
        FogPass.release();
        this.rzm();
    }

    private void rzm() {
        this.ryx = 0L;
        this.ryw = null;
        this.rzc = Double.NaN;
        this.rzd = -1.0f;
        this.rzf = null;
        this.rzg = null;
        this.rzh = 0.0;
        this.rzi = 0.0;
        this.rzj = 0.0;
        Arrays.fill(this.rys, 0L);
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        boolean bl;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int n;
        int n2;
        int n3;
        float f7;
        class_746 class_7462 = class_3102.field_1724;
        class_638 class_6382 = class_3102.field_1687;
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        this.rzn(this.ryj.get());
        if (class_7462 == null || class_6382 == null || !class_41842.method_19332() || class_41842.method_19334() != class_5636.field_27888) {
            this.ryx = 0L;
            this.ryw = null;
            return;
        }
        long l = System.nanoTime();
        float f8 = this.ryx == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.ryx) / 1.0E9f);
        this.ryx = l;
        float f9 = class_3102.method_61966().method_60637(false);
        float f10 = (float)this.ryg.get();
        this.ryy += f8 * f10;
        this.ryz += (double)(f8 * f10) * 0.55;
        this.rza += (double)(f8 * f10) * 0.16;
        this.rzb += (double)(f8 * f10) * 0.32;
        class_243 class_2432 = class_7462.method_30950(f9);
        int n4 = class_6382.method_8624(class_2902.class_2903.field_13197, (int)Math.floor(class_2432.field_1352), (int)Math.floor(class_2432.field_1350));
        double d = Math.min((double)n4, class_2432.field_1351) - 1.0;
        this.rzc = Double.isNaN(this.rzc) || Math.abs(d - this.rzc) > 48.0 ? d : (this.rzc += (d - this.rzc) * (1.0 - Math.exp((double)(-f8) / 1.4)));
        class_2338 class_23382 = class_41842.method_19328();
        float f11 = (float)class_6382.method_8314(class_1944.field_9284, class_23382) / 15.0f;
        float f12 = (float)class_6382.method_8314(class_1944.field_9282, class_23382) / 15.0f;
        if (this.rzd < 0.0f) {
            this.rzd = f11;
            this.rze = f12;
        } else {
            f7 = 1.0f - (float)Math.exp(-f8 / 0.8f);
            this.rzd += (f11 - this.rzd) * f7;
            this.rze += (f12 - this.rze) * f7;
        }
        this.rzo(class_2432.method_1031(0.0, 0.9, 0.0), f8, l);
        float f13 = switch (this.ryk.get()) {
            case "\u041d\u0438\u0437\u043a\u043e\u0435" -> {
                f7 = 0.35f;
                n3 = 18;
                n2 = 3;
                n = 1;
                yield 48.0f;
            }
            case "\u0421\u0440\u0435\u0434\u043d\u0435\u0435" -> {
                f7 = 0.5f;
                n3 = 24;
                n2 = 4;
                n = 2;
                yield 64.0f;
            }
            case "\u0423\u043b\u044c\u0442\u0440\u0430" -> {
                f7 = 0.75f;
                n3 = 48;
                n2 = 5;
                n = 3;
                yield 110.0f;
            }
            default -> {
                f7 = 0.5f;
                n3 = 32;
                n2 = 5;
                n = 2;
                yield 80.0f;
            }
        };
        String string = class_41842.method_75756();
        int n5 = class_6382.method_8597().comp_5220() == class_2874.class_12326.field_64386 ? 1 : 0;
        float[] fArray = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        float[] fArray2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        if (n5 != 0) {
            f6 = class_6382.method_8430(f9);
            f5 = class_6382.method_8478(f9);
            f4 = Math.max(0.0f, 1.0f - 0.7f * f6 - 0.2f * f5);
            f3 = ((Float)string.method_75689(class_12206.field_64340, f9)).floatValue() * ((float)Math.PI / 180);
            f2 = ((Float)string.method_75689(class_12206.field_64341, f9)).floatValue() * ((float)Math.PI / 180);
            f = (float)Math.cos(f3);
            float f14 = (float)Math.cos(f2);
            float f15 = SnowRender.rzr(-0.06f, 0.18f, f) * f4 * 0.4f;
            float f16 = SnowRender.rzr(-0.06f, 0.2f, f14) * f4 * 0.16f;
            float f17 = (float)this.ryi.get();
            if (f15 >= f16) {
                float f18 = SnowRender.rzr(0.0f, 0.45f, f);
                fArray = new float[]{(float)(-Math.sin(f3)), f, 0.0f, f15 * f17, 1.0f, 0.58f + 0.37f * f18, 0.32f + 0.54f * f18};
            } else {
                fArray = new float[]{(float)(-Math.sin(f2)), f14, 0.0f, f16 * f17, 0.52f, 0.62f, 0.95f};
            }
            int n6 = (Integer)string.method_75689(class_12206.field_63746, f9);
            fArray2 = new float[]{(float)(n6 >> 16 & 0xFF) / 255.0f, (float)(n6 >> 8 & 0xFF) / 255.0f, (float)(n6 & 0xFF) / 255.0f, 0.3f};
        }
        f6 = DaylightUtil.boost(class_3102);
        f5 = Math.max(0.18f + 0.82f * this.rzd, f6);
        f4 = this.rze * 0.25f * (1.0f - 0.75f * this.rzd);
        f3 = n5 != 0 ? (0.13f + 0.55f * f6) * (1.0f - 0.8f * DaylightUtil.daylight(class_3102)) : 0.12f + 0.5f * f6;
        f2 = (float)(0.005 * Math.pow(80.0, this.rya.get()));
        f = Math.max(128.0f, Math.min(1536.0f, (float)class_3102.field_1690.method_38521() * 24.0f));
        int n7 = this.rxz.color();
        int n8 = this.rxz.color2();
        class_243 class_2433 = class_41842.method_71156();
        boolean bl2 = bl = this.ryw != null && this.ryw.method_1025(class_2433) < 64.0;
        if (this.ryw == null) {
            this.ryv.set((Quaternionfc)class_41842.method_23767());
            this.ryw = class_2433;
        }
        this.ryt.rotation((Quaternionfc)class_41842.method_23767());
        this.ryu.rotation((Quaternionfc)this.ryv.conjugate(new Quaternionf()));
        float f19 = (float)(class_2433.field_1352 - this.ryw.field_1352);
        float f20 = (float)(class_2433.field_1351 - this.ryw.field_1351);
        float f21 = (float)(class_2433.field_1350 - this.ryw.field_1350);
        this.ryv.set((Quaternionfc)class_41842.method_23767());
        this.ryw = class_2433;
        float[] fArray3 = fArray;
        float[] fArray4 = fArray2;
        int n9 = n3;
        int n10 = n2;
        int n11 = n;
        float f22 = f13;
        float f23 = f3;
        FogPass.draw(f7, bl, std140Builder -> {
            std140Builder.putMat4f((Matrix4fc)this.ryt);
            std140Builder.putMat4f((Matrix4fc)this.ryu);
            std140Builder.putVec4(f19, f20, f21, f23);
            std140Builder.putVec4((float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350, f);
            std140Builder.putVec4(fArray3[0], fArray3[1], fArray3[2], fArray3[3]);
            std140Builder.putVec4(fArray3[4], fArray3[5], fArray3[6], 0.0f);
            std140Builder.putVec4(fArray4[0], fArray4[1], fArray4[2], fArray4[3]);
            std140Builder.putVec4(f4, f4 * 0.72f, f4 * 0.45f, f5);
            std140Builder.putVec4(SnowRender.rzs(n7), SnowRender.rzt(n7), SnowRender.rzu(n7), (float)this.ryd.get());
            std140Builder.putVec4(SnowRender.rzs(n8), SnowRender.rzt(n8), SnowRender.rzu(n8), (float)(1.0 - this.ryb.get()));
            std140Builder.putVec4(f2, (float)this.rzc, (float)(this.rye.get() * 0.05), (float)(1.0 / (7.0 * this.ryf.get())));
            std140Builder.putVec4((float)this.ryz, (float)this.rza, (float)this.rzb, this.ryy);
            std140Builder.putVec4((float)this.ryh.get(), 1.3f, 0.9f, (float)this.ryc.get());
            std140Builder.putVec4(f22, (float)n9, (float)n10, (float)n11);
            this.rzp((Std140Builder)std140Builder, l);
        });
    }

    private void rzn(boolean bl) {
        CloudHider.hide(this, bl);
    }

    private void rzo(class_243 class_2432, float f, long l) {
        if (this.rzf != null && f > 0.0f) {
            double d = (class_2432.field_1352 - this.rzf.field_1352) / (double)f;
            double d2 = (class_2432.field_1351 - this.rzf.field_1351) / (double)f;
            double d3 = (class_2432.field_1350 - this.rzf.field_1350) / (double)f;
            if (this.rzf.method_1025(class_2432) > 36.0) {
                Arrays.fill(this.rys, 0L);
                this.rzg = null;
                d = 0.0;
                d2 = 0.0;
                d3 = 0.0;
            }
            double d4 = 1.0 - Math.exp((double)(-f) * 8.0);
            this.rzh += (d - this.rzh) * d4;
            this.rzi += (d2 - this.rzi) * d4;
            this.rzj += (d3 - this.rzj) * d4;
        }
        this.rzf = class_2432;
        if (this.rzg == null || this.rzg.method_1025(class_2432) > 0.64) {
            for (int i = 6; i > 0; --i) {
                this.rym[i] = this.rym[i - 1];
                this.ryn[i] = this.ryn[i - 1];
                this.ryo[i] = this.ryo[i - 1];
                this.ryp[i] = this.ryp[i - 1];
                this.ryq[i] = this.ryq[i - 1];
                this.ryr[i] = this.ryr[i - 1];
                this.rys[i] = this.rys[i - 1];
            }
            this.rym[0] = class_2432.field_1352;
            this.ryn[0] = class_2432.field_1351;
            this.ryo[0] = class_2432.field_1350;
            this.ryp[0] = (float)this.rzh;
            this.ryq[0] = (float)this.rzi;
            this.ryr[0] = (float)this.rzj;
            this.rys[0] = l;
            this.rzg = class_2432;
        }
    }

    private void rzp(Std140Builder std140Builder, long l) {
        float f;
        float f2;
        float f3;
        float[][] fArray = new float[8][4];
        float[][] fArray2 = new float[8][4];
        if (this.ryl.get() && this.rzf != null) {
            fArray[0] = new float[]{(float)this.rzf.field_1352, (float)this.rzf.field_1351, (float)this.rzf.field_1350, 1.0f};
            fArray2[0] = SnowRender.rzq((float)this.rzh, (float)this.rzi, (float)this.rzj, 1.25f);
            for (int i = 0; i < 7; ++i) {
                if (this.rys[i] == 0L) continue;
                float f4 = (float)(l - this.rys[i]) / 1.0E9f;
                f3 = (float)Math.sqrt(this.ryp[i] * this.ryp[i] + this.ryq[i] * this.ryq[i] + this.ryr[i] * this.ryr[i]);
                f2 = 1.0f - f4 / 3.0f;
                if (f2 <= 0.0f || f3 < 0.5f) continue;
                f = f2 * f2 * Math.min(1.0f, f3 / 3.0f);
                fArray[i + 1] = new float[]{(float)this.rym[i], (float)this.ryn[i], (float)this.ryo[i], f};
                fArray2[i + 1] = SnowRender.rzq(this.ryp[i], this.ryq[i], this.ryr[i], 1.25f + f4 * 0.9f);
            }
        }
        float f5 = 0.0f;
        if (fArray[0][3] > 0.0f) {
            for (int i = 0; i < 8; ++i) {
                if (fArray[i][3] <= 0.0f) continue;
                f3 = fArray[i][0] - fArray[0][0];
                f2 = fArray[i][1] - fArray[0][1];
                f = fArray[i][2] - fArray[0][2];
                f5 = Math.max(f5, (float)Math.sqrt(f3 * f3 + f2 * f2 + f * f) + fArray2[i][3] * 4.8f);
            }
        }
        std140Builder.putVec4(fArray[0][0], fArray[0][1], fArray[0][2], f5);
        for (float[] fArray3 : fArray) {
            std140Builder.putVec4(fArray3[0], fArray3[1], fArray3[2], fArray3[3]);
        }
        for (float[] fArray4 : fArray2) {
            std140Builder.putVec4(fArray4[0], fArray4[1], fArray4[2], fArray4[3]);
        }
    }

    private static float[] rzq(float f, float f2, float f3, float f4) {
        float f5 = (float)Math.sqrt(f * f + f2 * f2 + f3 * f3) / 5.0f;
        float f6 = f5 > 1.6f ? 1.6f / f5 : 1.0f;
        return new float[]{f / 5.0f * f6, f2 / 5.0f * f6, f3 / 5.0f * f6, f4};
    }

    private static float rzr(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / (f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float rzs(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    private static float rzt(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    private static float rzu(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static /* synthetic */ int cck(int n, int n2) {
        return n * n2 | 0x9F7F5684;
    }

    private static /* synthetic */ int ccl(int n, int n2) {
        return SnowRender.cck(n, n2) * n2;
    }
}

