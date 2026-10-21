/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  net.minecraft.class_12206
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_243
 *  net.minecraft.class_2874$class_12326
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  net.minecraft.class_638
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.sfz;
import a.sgk;
import a.WeatherSeasonPass;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import com.mojang.blaze3d.buffers.Std140Builder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_12206;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2874;
import net.minecraft.class_2902;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class WetEffects
extends Module {
    private static final int sgt = 32;
    private static final float sgu = (float)Math.PI / 180;
    private final NumberSetting sgv = this.add(new NumberSetting("\u041c\u043e\u043a\u0440\u043e\u0441\u0442\u044c", 0.7, 0.0, 1.0, 0.01).percent());
    private final NumberSetting sgw = this.add(new NumberSetting("\u041b\u0443\u0436\u0438", 0.5, 0.0, 1.0, 0.01).percent());
    private final NumberSetting sgx = this.add(new NumberSetting("\u041e\u0442\u0440\u0430\u0436\u0435\u043d\u0438\u044f", 1.0, 0.0, 1.0, 0.05).percent());
    private final NumberSetting sgy = this.add(new NumberSetting("\u0417\u0430\u0442\u0435\u043c\u043d\u0435\u043d\u0438\u0435", 0.55, 0.0, 1.0, 0.05).percent());
    private final NumberSetting sgz = this.add(new NumberSetting("\u041a\u0430\u043f\u043b\u0438", 0.0, 0.0, 1.0, 0.05).percent());
    private final BoolSetting sha = this.add(new BoolSetting("\u0421\u043b\u0435\u0434\u044b", true));
    private final NumberSetting shb = this.add(new NumberSetting("\u0412\u0440\u0435\u043c\u044f \u0441\u043b\u0435\u0434\u043e\u0432", 20.0, 5.0, 60.0, 1.0).suffix("\u0441"));
    private final BoolSetting shc = this.add(new BoolSetting("\u0422\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0434 \u043d\u0435\u0431\u043e\u043c", true));
    private final ModeSetting shd = this.add(new ModeSetting("\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435", "\u041d\u0438\u0437\u043a\u043e\u0435", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435"));
    private final ArrayDeque<sfz> she = new ArrayDeque();
    private final Map<UUID, sgk> shf = new HashMap<UUID, sgk>();
    private final int[] shg = new int[16384];
    private final class_2338.class_2339 shh = new class_2338.class_2339();
    private final Matrix4f shi = new Matrix4f();
    private final Matrix4f shj = new Matrix4f();
    private boolean shk;
    private int shl;
    private int shm;
    private int shn;
    private long sho;
    private float shp;
    private static /* synthetic */ int shq;
    private static /* synthetic */ boolean shr;

    public WetEffects() {
        super(new String(new char[]{'W', 'e', 't', 'G', 'r', 'o', 'u', 'n', 'd'}), "Wet ground after rain: puddles with reflections, ripples and footprints", ModuleCategory.RENDER);
        this.shb.visibleWhen(this.sha::get);
    }

    @Override
    protected void onEnable() {
        this.shk = false;
        this.shn = 0;
        this.sho = 0L;
        this.she.clear();
        this.shf.clear();
    }

    @Override
    protected void onDisable() {
        WeatherSeasonPass.release();
        this.she.clear();
        this.shf.clear();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        ++this.shn;
        class_638 class_6382 = class_3102.field_1687;
        if (class_6382 == null || class_3102.field_1724 == null) {
            return;
        }
        long l = System.nanoTime();
        long l2 = (long)(this.shb.get() * 1.0E9);
        while (!this.she.isEmpty() && l - this.she.peekFirst().sgg > l2) {
            this.she.pollFirst();
        }
        if (!this.sha.get()) {
            this.she.clear();
            this.shf.clear();
            return;
        }
        HashMap<UUID, Boolean> hashMap = new HashMap<UUID, Boolean>();
        for (class_1657 class_16572 : class_6382.method_18456()) {
            if (class_16572.method_7325() || class_16572.method_5858((class_1297)class_3102.field_1724) > 2304.0) continue;
            hashMap.put(class_16572.method_5667(), Boolean.TRUE);
            this.shs(class_16572, l, class_16572 == class_3102.field_1724 ? 1.0f : 0.8f);
        }
        this.shf.keySet().removeIf(uUID -> !hashMap.containsKey(uUID));
    }

    private void shs(class_1657 class_16572, long l, float f) {
        sgk sgk2 = this.shf.computeIfAbsent(class_16572.method_5667(), uUID -> new sgk());
        double d = class_16572.method_23317();
        double d2 = class_16572.method_23321();
        boolean bl = class_16572.method_24828();
        if (!sgk2.sgl) {
            sgk2.sgl = true;
            sgk2.sgn = d;
            sgk2.sgo = d2;
            sgk2.sgm = bl;
            return;
        }
        double d3 = d - sgk2.sgn;
        double d4 = d2 - sgk2.sgo;
        double d5 = Math.sqrt(d3 * d3 + d4 * d4);
        if (d5 > 6.0) {
            sgk2.sgn = d;
            sgk2.sgo = d2;
            sgk2.sgm = bl;
            return;
        }
        if (bl && !sgk2.sgm) {
            float f2 = class_16572.method_36454() * ((float)Math.PI / 180);
            float f3 = (float)(-Math.sin(f2));
            float f4 = (float)Math.cos(f2);
            this.sht(d, class_16572.method_23318(), d2, f3, f4, 1.0f, l, f);
            this.sht(d, class_16572.method_23318(), d2, f3, f4, -1.0f, l, f);
            sgk2.sgn = d;
            sgk2.sgo = d2;
        } else if (bl) {
            double d6;
            double d7 = class_16572.method_5715() ? 0.42 : (d6 = class_16572.method_5624() ? 0.85 : 0.62);
            if (d5 >= d6) {
                float f5 = (float)(d3 / d5);
                float f6 = (float)(d4 / d5);
                sgk2.sgp = -sgk2.sgp;
                this.sht(d, class_16572.method_23318(), d2, f5, f6, sgk2.sgp, l, f);
                sgk2.sgn = d;
                sgk2.sgo = d2;
            }
        } else {
            sgk2.sgn = d;
            sgk2.sgo = d2;
        }
        sgk2.sgm = bl;
    }

    private void sht(double d, double d2, double d3, float f, float f2, float f3, long l, float f4) {
        double d4 = (double)(-f2 * f3) * 0.14;
        double d5 = (double)(f * f3) * 0.14;
        this.she.addLast(new sfz(d + d4, d2, d3 + d5, f, f2, f3, l, f4));
        while (this.she.size() > 32) {
            this.she.pollFirst();
        }
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        float f;
        float f2;
        float f3;
        class_638 class_6382 = class_3102.field_1687;
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        if (class_6382 == null || class_3102.field_1724 == null || !class_41842.method_19332() || class_41842.method_19334() != class_5636.field_27888) {
            this.sho = 0L;
            return;
        }
        long l = System.nanoTime();
        float f4 = this.sho == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.sho) / 1.0E9f);
        this.sho = l;
        this.shp = (this.shp + f4) % 3600.0f;
        float f5 = class_3102.method_61966().method_60637(false);
        class_243 class_2432 = class_41842.method_71156();
        int n = (int)Math.floor(class_2432.field_1352);
        int n2 = (int)Math.floor(class_2432.field_1351);
        int n3 = (int)Math.floor(class_2432.field_1350);
        int n4 = 64;
        if (!this.shk || Math.abs(n - (this.shl + n4)) > 24 || Math.abs(n3 - (this.shm + n4)) > 24 || this.shn >= 40) {
            this.shv(class_6382, n - n4, n3 - n4);
        }
        int n5 = switch (this.shd.get()) {
            case "\u041d\u0438\u0437\u043a\u043e\u0435" -> 16;
            case "\u0421\u0440\u0435\u0434\u043d\u0435\u0435" -> 28;
            default -> 40;
        };
        String string = class_41842.method_75756();
        float f6 = class_6382.method_8430(f5);
        float[] fArray = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
        float[] fArray2 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArray3 = new float[]{0.5f, 0.65f, 0.9f};
        if (class_6382.method_8597().comp_5220() == class_2874.class_12326.field_64386) {
            f3 = Math.max(0.0f, 1.0f - 0.85f * f6);
            f2 = ((Float)string.method_75689(class_12206.field_64340, f5)).floatValue() * ((float)Math.PI / 180);
            float f7 = ((Float)string.method_75689(class_12206.field_64341, f5)).floatValue() * ((float)Math.PI / 180);
            f = (float)Math.cos(f2);
            float f8 = (float)Math.cos(f7);
            if (f > -0.05f) {
                float f9 = WetEffects.shw(0.0f, 0.4f, f);
                fArray = new float[]{(float)(-Math.sin(f2)), f, 0.0f, WetEffects.shw(-0.05f, 0.12f, f) * f3};
                fArray2 = new float[]{1.0f, 0.62f + 0.35f * f9, 0.38f + 0.52f * f9};
            } else {
                fArray = new float[]{(float)(-Math.sin(f7)), f8, 0.0f, WetEffects.shw(-0.05f, 0.15f, f8) * f3 * 0.35f};
                fArray2 = new float[]{0.6f, 0.7f, 1.0f};
            }
            int n6 = (Integer)string.method_75689(class_12206.field_63746, f5);
            fArray3 = new float[]{(float)(n6 >> 16 & 0xFF) / 255.0f, (float)(n6 >> 8 & 0xFF) / 255.0f, (float)(n6 & 0xFF) / 255.0f};
        }
        f3 = Math.max((float)this.sgz.get(), f6);
        f2 = Math.min((float)class_3102.field_1690.method_38521() * 16.0f, 200.0f);
        this.shi.rotation((Quaternionfc)class_41842.method_23767());
        this.shj.rotation((Quaternionfc)class_41842.method_23767().conjugate(new Quaternionf()));
        ArrayList<sfz> arrayList = new ArrayList<sfz>(this.she);
        f = (float)this.shb.get();
        float[] fArray4 = fArray;
        float[] fArray5 = fArray2;
        float[] fArray6 = fArray3;
        int n7 = n5;
        boolean bl = this.shc.get();
        boolean bl2 = this.shk;
        int n8 = this.shl - n;
        int n9 = this.shm - n3;
        WeatherSeasonPass.draw(std140Builder -> {
            std140Builder.putMat4f((Matrix4fc)this.shi);
            std140Builder.putMat4f((Matrix4fc)this.shj);
            std140Builder.putVec4((float)Math.floorMod(n, 4096), (float)n2, (float)Math.floorMod(n3, 4096), this.shp);
            std140Builder.putVec4((float)(class_2432.field_1352 - (double)n), (float)(class_2432.field_1351 - (double)n2), (float)(class_2432.field_1350 - (double)n3), f3);
            std140Builder.putVec4((float)this.sgv.get(), (float)this.sgw.get(), (float)this.sgx.get(), (float)this.sgy.get());
            std140Builder.putVec4(fArray4[0], fArray4[1], fArray4[2], fArray4[3]);
            std140Builder.putVec4(fArray5[0], fArray5[1], fArray5[2], 0.0f);
            std140Builder.putVec4(fArray6[0], fArray6[1], fArray6[2], bl ? 1.0f : 0.0f);
            std140Builder.putVec4((float)n8, (float)n9, 128.0f, bl2 ? 1.0f : 0.0f);
            std140Builder.putVec4((float)n7, f2, (float)arrayList.size(), f);
            this.shu((Std140Builder)std140Builder, (List<sfz>)arrayList, class_2432, l);
        });
    }

    private void shu(Std140Builder std140Builder, List<sfz> list, class_243 class_2432, long l) {
        int n;
        sfz sfz22;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (sfz sfz3 : list) {
            f += (float)(sfz3.sga - class_2432.field_1352);
            f2 += (float)(sfz3.sgb - class_2432.field_1351);
            f3 += (float)(sfz3.sgc - class_2432.field_1350);
        }
        int n2 = Math.max(1, list.size());
        f /= (float)n2;
        f2 /= (float)n2;
        f3 /= (float)n2;
        float f4 = 0.0f;
        for (sfz sfz22 : list) {
            float f5 = (float)(sfz22.sga - class_2432.field_1352) - f;
            float f6 = (float)(sfz22.sgb - class_2432.field_1351) - f2;
            float f7 = (float)(sfz22.sgc - class_2432.field_1350) - f3;
            f4 = Math.max(f4, (float)Math.sqrt(f5 * f5 + f6 * f6 + f7 * f7));
        }
        std140Builder.putVec4(f, f2, f3, list.isEmpty() ? 0.0f : f4 + 2.5f);
        for (n = 0; n < 32; ++n) {
            if (n < list.size()) {
                sfz22 = list.get(list.size() - 1 - n);
                std140Builder.putVec4((float)(sfz22.sga - class_2432.field_1352), (float)(sfz22.sgb - class_2432.field_1351), (float)(sfz22.sgc - class_2432.field_1350), (float)(l - sfz22.sgg) / 1.0E9f);
                continue;
            }
            std140Builder.putVec4(0.0f, -1000.0f, 0.0f, 1000.0f);
        }
        for (n = 0; n < 32; ++n) {
            if (n < list.size()) {
                sfz22 = list.get(list.size() - 1 - n);
                std140Builder.putVec4(sfz22.sgd, sfz22.sge, sfz22.sgf, sfz22.sgh);
                continue;
            }
            std140Builder.putVec4(0.0f, 1.0f, 1.0f, 0.0f);
        }
    }

    private void shv(class_638 class_6382, int n, int n2) {
        int n3 = 128;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n4 = class_6382.method_8624(class_2902.class_2903.field_13197, n + j, n2 + i);
                int n5 = Math.max(0, Math.min(65535, n4 + 64));
                boolean bl = !class_6382.method_8316((class_2338)this.shh.method_10103(n + j, n4 - 1, n2 + i)).method_15769();
                this.shg[i * n3 + j] = 0xFF000000 | (n5 & 0xFF) << 16 | (n5 >> 8 & 0xFF) << 8 | (bl ? 255 : 0);
            }
        }
        WeatherSeasonPass.uploadHeights(this.shg);
        this.shl = n;
        this.shm = n2;
        this.shn = 0;
        this.shk = true;
    }

    private static float shw(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / (f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static /* synthetic */ int cdq(int n, int n2) {
        return n - n2 | 0xDB2E6F4F;
    }

    private static /* synthetic */ int cdr(int n, int n2) {
        return n - n2 ^ 0x7311E235;
    }
}

