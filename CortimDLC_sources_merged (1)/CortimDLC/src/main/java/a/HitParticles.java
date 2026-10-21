/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.rus;
import a.ColorUtil;
import a.FrameDelta;
import a.GlowSprite;
import a.ScreenProjection;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public class HitParticles
extends Module {
    private static HitParticles ruw;
    public final ModeSetting mode = this.add(new ModeSetting("Mode", "Ghosts", "Ghosts", "Sparkles", "Ring", "Comets", "Lightning"));
    public final ColorSetting color = this.add(new ColorSetting("Color", "Theme"));
    public final ColorSetting hitColor = this.add(new ColorSetting("Hit color", "Crimson"));
    public final NumberSetting size = this.add(new NumberSetting("Size", 1.0, 0.6, 1.6, 0.05).percent());
    public final NumberSetting speed = this.add(new NumberSetting("Speed", 1.0, 0.4, 2.0, 0.1).unit("x"));
    public final NumberSetting brightness = this.add(new NumberSetting("Brightness", 0.8, 0.3, 1.0, 0.05).percent());
    public final BoolSetting mobs = this.add(new BoolSetting("Mobs", false));
    private static final long rux = 3500L;
    private static final double ruy = 48.0;
    private static final float ruz = (float)Math.PI * 2;
    private static class_1309 rva;
    private static long rvb;
    private static class_1309 rvc;
    private static final Spring rvd;
    private static final Spring rve;
    private static int rvf;
    private static float rvg;
    private static long rvh;
    private static final float[] rvi;
    private static final float[] rvj;
    private static final float[] rvk;
    private static final float[] rvl;
    private static final Random rvm;
    private static final int rvn = 60;
    private static final float[][] rvo;
    private static final int rvp = 4;
    private static final int rvq = 11;
    private static final int rvr = 4;
    private static final int rvs = 4;
    private static final double[][] rvt;
    private static final double[][] rvu;
    private static float rvv;
    private static long rvw;
    private static int rvx;
    private static /* synthetic */ int rvy;
    private static /* synthetic */ long rvz;

    public HitParticles() {
        super(new String(new char[]{'T', 'a', 'r', 'g', 'e', 't', 'E', 'S', 'P'}), "An effect on your current target", ModuleCategory.RENDER);
        ruw = this;
        HitParticles.rwf();
    }

    public static void onAttack(class_1297 class_12972) {
        if (class_12972 instanceof class_1309) {
            class_1309 class_13092;
            rva = class_13092 = (class_1309)class_12972;
            rvb = System.currentTimeMillis();
        }
    }

    private boolean rwa(class_310 class_3102, class_1297 class_12972) {
        block6: {
            block5: {
                if (!(class_12972 instanceof class_1309)) break block5;
                class_1309 class_13092 = (class_1309)class_12972;
                if (class_12972 != class_3102.field_1724 && class_13092.method_5805() && !class_12972.method_31481() && !(class_12972 instanceof class_1531) && class_3102.field_1687.method_8469(class_12972.method_5628()) == class_12972 && !class_12972.method_7325()) break block6;
            }
            return false;
        }
        if (!(class_12972 instanceof class_1657) && !this.mobs.get()) {
            return false;
        }
        if (class_12972 instanceof class_1657 && Friends.isFriend(class_12972)) {
            return false;
        }
        return class_3102.field_1724.method_5858(class_12972) < 2304.0;
    }

    private class_1309 rwb(class_310 class_3102) {
        if (rva != null && System.currentTimeMillis() - rvb < 3500L && this.rwa(class_3102, (class_1297)rva)) {
            return rva;
        }
        class_1297 class_12972 = class_3102.field_1692;
        return class_12972 != null && this.rwa(class_3102, class_12972) ? (class_1309)class_12972 : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        boolean bl;
        class_1309 class_13092;
        HitParticles ruv2 = ruw;
        class_310 class_3102 = class_310.method_1551();
        if (ruv2 == null || class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return;
        }
        if (!ruv2.isEnabled()) {
            rvc = null;
            rvd.set(0.0f);
            return;
        }
        if (class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rvh) {
            return;
        }
        rvh = FrameDelta.frame();
        float f = FrameDelta.delta();
        class_1309 class_13093 = ruv2.rwb(class_3102);
        if (class_13093 != null && class_13093 != rvc) {
            rvc = class_13093;
            rvd.set(0.0f);
            rve.set(0.0f);
            rvf = class_13093.field_6235;
            rvv = 0.0f;
        }
        if ((class_13092 = rvc) == null) {
            return;
        }
        float f2 = rvd.step(class_13093 != null && ruv2.rwa(class_3102, (class_1297)class_13092), f);
        if (f2 <= 0.004f) {
            if (class_13093 != null) return;
            rvc = null;
            return;
        }
        boolean bl2 = bl = class_13092.field_6235 > rvf;
        if (bl) {
            rve.set(1.0f);
            rvv = 0.0f;
        }
        rvf = class_13092.field_6235;
        rve.step(0.0f, f);
        float f3 = (float)ruv2.speed.get();
        rvg += f * f3;
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        class_243 class_2432 = class_13092.method_30950(class_97792.method_60637(true));
        rus rus2 = new rus(ruv2, Easing.outCubic(f2), Easing.outCubic(rve.get()));
        DrawUtil.beginFrame();
        DrawUtil.pushAlpha(rus2.vis * (float)ruv2.brightness.get());
        long l = System.nanoTime();
        DrawUtil.beginBatch();
        try {
            switch (ruv2.mode.get()) {
                case "Sparkles": {
                    HitParticles.rwg(class_3322, usn2, class_13092, class_2432, rus2, f * f3);
                    return;
                }
                case "Ring": {
                    HitParticles.rwh(class_3322, usn2, class_13092, class_2432, rus2);
                    return;
                }
                case "Comets": {
                    HitParticles.rwk(class_3322, usn2, class_13092, class_2432, rus2);
                    return;
                }
                case "Lightning": {
                    HitParticles.rwl(class_3322, usn2, class_13092, class_2432, rus2, f * f3);
                    return;
                }
                default: {
                    HitParticles.rwe(class_3322, usn2, class_13092, class_2432, rus2);
                    return;
                }
            }
        }
        finally {
            DrawUtil.endBatch();
            DrawUtil.additive(false);
            DrawUtil.popAlpha();
            rvw += System.nanoTime() - l;
            ++rvx;
        }
    }

    public static double cpuMicros() {
        double d = rvx == 0 ? 0.0 : (double)rvw / 1000.0 / (double)rvx;
        rvw = 0L;
        rvx = 0;
        return d;
    }

    private static void rwc(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, int n) {
        if (gpuTextureView != null) {
            DrawUtil.sprite(class_3322, gpuTextureView, f, f2, f3, n);
        } else {
            float f4 = f3 * 0.18f;
            DrawUtil.shadow(class_3322, f - f4, f2 - f4, f4 * 2.0f, f4 * 2.0f, f4, f3 * 0.3f, n);
        }
    }

    private static float rwd(float f) {
        return 0.5f - 0.5f * (float)Math.cos(f);
    }

    private static void rwe(class_332 class_3322, ScreenProjection usn2, class_1309 class_13092, class_243 class_2432, rus rus2) {
        GpuTextureView gpuTextureView = GlowSprite.view();
        float f = class_13092.method_17682();
        double d = ((double)class_13092.method_17681() * 0.55 + 0.35) * (double)rus2.size;
        double d2 = class_2432.field_1351 + (double)f * 0.5;
        float f2 = usn2.depth(class_2432.field_1352, d2, class_2432.field_1350);
        float f3 = usn2.unitsPerBlock(class_2432.field_1352, d2, class_2432.field_1350);
        if (f3 <= 0.0f) {
            return;
        }
        DrawUtil.additive(true);
        int n = 3;
        int n2 = 22;
        for (int i = 0; i < n; ++i) {
            float f4 = (float)Math.PI * 2 * (float)i / (float)n;
            for (int j = n2 - 1; j >= 0; --j) {
                float f5 = rvg * 2.3f - (float)j * 0.055f;
                float f6 = f5 + f4;
                double d3 = class_2432.field_1352 + Math.cos(f6) * d;
                double d4 = class_2432.field_1350 + Math.sin(f6) * d;
                double d5 = d2 + Math.sin(f5 * 1.25f + f4 * 1.7f) * (double)f * 0.36;
                if (!usn2.project(d3, d5, d4, rvi)) continue;
                float f7 = 1.0f - (float)j / (float)n2;
                boolean bl = usn2.depth(d3, d5, d4) < f2;
                float f8 = Math.min(40.0f, f3 * 0.3f * rus2.size * (0.25f + 0.75f * f7));
                float f9 = (float)Math.pow(f7, 1.5) * (bl ? 1.0f : 0.5f);
                HitParticles.rwc(class_3322, gpuTextureView, rvi[0], rvi[1], f8, ColorUtil.withAlpha(rus2.at((float)j / (float)n2), Math.round(165.0f * f9)));
                if (j != 0) continue;
                HitParticles.rwc(class_3322, gpuTextureView, rvi[0], rvi[1], f8 * 0.34f, ColorUtil.withAlpha(rus2.core(0.55f), Math.round(200.0f * (bl ? 1.0f : 0.55f))));
            }
        }
        DrawUtil.additive(false);
    }

    private static void rwf() {
        Random random = new Random(23057L);
        for (float[] fArray : rvo) {
            fArray[0] = random.nextFloat() * ((float)Math.PI * 2);
            fArray[1] = 0.55f + random.nextFloat() * 0.45f;
            fArray[2] = random.nextFloat();
            fArray[3] = 0.08f + random.nextFloat() * 0.14f;
            fArray[4] = random.nextFloat() * ((float)Math.PI * 2);
            fArray[5] = 2.2f + random.nextFloat() * 3.5f;
            fArray[6] = 0.55f + random.nextFloat() * 0.45f;
        }
    }

    private static void rwg(class_332 class_3322, ScreenProjection usn2, class_1309 class_13092, class_243 class_2432, rus rus2, float f) {
        GpuTextureView gpuTextureView = GlowSprite.view();
        float f2 = class_13092.method_17682();
        double d = ((double)class_13092.method_17681() * 0.6 + 0.3) * (double)rus2.size;
        float f3 = usn2.depth(class_2432.field_1352, class_2432.field_1351 + (double)f2 * 0.5, class_2432.field_1350);
        float f4 = usn2.unitsPerBlock(class_2432.field_1352, class_2432.field_1351 + (double)f2 * 0.5, class_2432.field_1350);
        if (f4 <= 0.0f) {
            return;
        }
        float f5 = Math.min(12.0f, Math.max(3.0f, f4 * 0.1f)) * rus2.size;
        DrawUtil.additive(true);
        for (float[] fArray : rvo) {
            float f6;
            double d2;
            double d3;
            fArray[2] = fArray[2] + fArray[3] * f * (1.0f + rus2.hit * 2.0f);
            fArray[0] = fArray[0] + f * 0.35f;
            if (fArray[2] > 1.0f) {
                fArray[2] = fArray[2] - 1.0f;
                fArray[0] = rvm.nextFloat() * ((float)Math.PI * 2);
            }
            double d4 = d * (double)fArray[1];
            double d5 = class_2432.field_1352 + Math.cos(fArray[0]) * d4;
            if (!usn2.project(d5, d3 = class_2432.field_1351 + ((double)fArray[2] * 1.1 - 0.05) * (double)f2, d2 = class_2432.field_1350 + Math.sin(fArray[0]) * d4, rvi)) continue;
            float f7 = Math.min(1.0f, Math.min(fArray[2] / 0.15f, (1.0f - fArray[2]) / 0.2f));
            float f8 = 0.5f + 0.5f * (float)Math.sin(rvg * fArray[5] + fArray[4]);
            boolean bl = usn2.depth(d5, d3, d2) < f3;
            if ((f6 = f7 * (0.25f + 0.75f * (f8 *= f8)) * (bl ? 1.0f : 0.45f)) <= 0.02f) continue;
            float f9 = f5 * fArray[6];
            HitParticles.rwc(class_3322, gpuTextureView, rvi[0], rvi[1], f9 * 3.6f, ColorUtil.withAlpha(rus2.at(fArray[6]), Math.round(80.0f * f6)));
            HitParticles.rwc(class_3322, gpuTextureView, rvi[0], rvi[1], f9 * 1.3f, ColorUtil.withAlpha(rus2.core(0.75f), Math.round(255.0f * f6)));
        }
        DrawUtil.additive(false);
    }

    private static void rwh(class_332 class_3322, ScreenProjection usn2, class_1309 class_13092, class_243 class_2432, rus rus2) {
        float f = class_13092.method_17682();
        double d = ((double)class_13092.method_17681() * 0.5 + 0.2) * (double)rus2.size;
        float f2 = rvg * 1.6f;
        double d2 = class_2432.field_1351 + 0.05 + (double)HitParticles.rwd(f2) * ((double)f - 0.1);
        boolean bl = Math.sin(f2) > 0.0;
        double d3 = 0.04 * (double)rus2.size;
        double d4 = 0.2 * (double)rus2.size * Math.min(1.0, Math.abs(Math.sin(f2)) * 1.6 + 0.25);
        HitParticles.rwi(class_3322, usn2, class_2432.field_1352, d2, class_2432.field_1350, d, bl ? d4 : d3 * 1.4, bl ? d3 * 1.4 : d4, rus2, 1.0f, 44);
        HitParticles.rwj(class_3322, usn2, class_2432.field_1352, d2, class_2432.field_1350, d, 44, rus2, 0.9f);
    }

    private static void rwi(class_332 class_3322, ScreenProjection usn2, double d, double d2, double d3, double d4, double d5, double d6, rus rus2, float f, int n) {
        float f2 = usn2.depth(d, d2, d3);
        DrawUtil.additive(true);
        for (int i = 0; i < n; ++i) {
            double d7 = (float)Math.PI * 2 * (float)i / (float)n;
            double d8 = (float)Math.PI * 2 * (float)(i + 1) / (float)n;
            double d9 = Math.cos(d7) * d4;
            double d10 = Math.sin(d7) * d4;
            double d11 = Math.cos(d8) * d4;
            double d12 = Math.sin(d8) * d4;
            double d13 = (d7 + d8) * 0.5;
            boolean bl = usn2.depth(d + Math.cos(d13) * d4, d2, d3 + Math.sin(d13) * d4) < f2;
            float f3 = f * (bl ? 1.0f : 0.35f);
            int n2 = rus2.at(0.5f + 0.5f * (float)Math.sin(d13 + (double)rvg));
            int n3 = ColorUtil.withAlpha(ColorUtil.lerp(n2, -1, 0.35f), Math.round(120.0f * f3));
            int n4 = ColorUtil.withAlpha(n2, 0);
            if (!usn2.project(d + d9, d2, d3 + d10, rvi) || !usn2.project(d + d11, d2, d3 + d12, rvj)) continue;
            if (usn2.project(d + d11, d2 - d5, d3 + d12, rvk) && usn2.project(d + d9, d2 - d5, d3 + d10, rvl)) {
                DrawUtil.quad(class_3322, rvi[0], rvi[1], n3, rvj[0], rvj[1], n3, rvk[0], rvk[1], n4, rvl[0], rvl[1], n4);
            }
            if (!usn2.project(d + d11, d2 + d6, d3 + d12, rvk) || !usn2.project(d + d9, d2 + d6, d3 + d10, rvl)) continue;
            DrawUtil.quad(class_3322, rvi[0], rvi[1], n3, rvj[0], rvj[1], n3, rvk[0], rvk[1], n4, rvl[0], rvl[1], n4);
        }
        DrawUtil.additive(false);
    }

    private static void rwj(class_332 class_3322, ScreenProjection usn2, double d, double d2, double d3, double d4, int n, rus rus2, float f) {
        float f2 = usn2.depth(d, d2, d3);
        float f3 = usn2.unitsPerBlock(d, d2, d3);
        float f4 = Math.max(0.7f, Math.min(1.8f, f3 * 0.014f));
        boolean bl = usn2.project(d + d4, d2, d3, rvi);
        for (int i = 1; i <= n; ++i) {
            double d5 = (float)Math.PI * 2 * (float)i / (float)n;
            boolean bl2 = usn2.project(d + Math.cos(d5) * d4, d2, d3 + Math.sin(d5) * d4, rvj);
            if (bl && bl2) {
                double d6 = d5 - Math.PI / (double)n;
                boolean bl3 = usn2.depth(d + Math.cos(d6) * d4, d2, d3 + Math.sin(d6) * d4) < f2;
                DrawUtil.line(class_3322, rvi[0], rvi[1], rvj[0], rvj[1], f4, ColorUtil.withAlpha(rus2.core(0.6f), Math.round(235.0f * f * (bl3 ? 1.0f : 0.3f))));
            }
            HitParticles.rvi[0] = rvj[0];
            HitParticles.rvi[1] = rvj[1];
            bl = bl2;
        }
    }

    private static void rwk(class_332 class_3322, ScreenProjection usn2, class_1309 class_13092, class_243 class_2432, rus rus2) {
        float f = class_13092.method_17682();
        double d = ((double)class_13092.method_17681() * 0.5 + 0.28) * (double)rus2.size;
        float f2 = usn2.depth(class_2432.field_1352, class_2432.field_1351 + (double)f * 0.5, class_2432.field_1350);
        float f3 = usn2.unitsPerBlock(class_2432.field_1352, class_2432.field_1351 + (double)f * 0.5, class_2432.field_1350);
        if (f3 <= 0.0f) {
            return;
        }
        GpuTextureView gpuTextureView = GlowSprite.view();
        int n = 18;
        double d2 = 0.12 * (double)rus2.size;
        DrawUtil.additive(true);
        for (int i = 0; i < 2; ++i) {
            float f4 = (float)i * (float)Math.PI;
            for (int j = n - 1; j > 0; --j) {
                float f5 = rvg * 3.1f - (float)j * 0.075f;
                float f6 = rvg * 3.1f - (float)(j - 1) * 0.075f;
                double d3 = f5 + f4;
                double d4 = f6 + f4;
                double d5 = class_2432.field_1351 + 0.1 + (double)HitParticles.rwd(f5 * 0.42f + f4) * ((double)f - 0.2);
                double d6 = class_2432.field_1351 + 0.1 + (double)HitParticles.rwd(f6 * 0.42f + f4) * ((double)f - 0.2);
                double d7 = class_2432.field_1352 + Math.cos(d3) * d;
                double d8 = class_2432.field_1350 + Math.sin(d3) * d;
                double d9 = class_2432.field_1352 + Math.cos(d4) * d;
                double d10 = class_2432.field_1350 + Math.sin(d4) * d;
                float f7 = 1.0f - (float)j / (float)n;
                float f8 = 1.0f - (float)(j - 1) / (float)n;
                double d11 = d2 * (double)f7;
                double d12 = d2 * (double)f8;
                boolean bl = usn2.depth(d9, d6, d10) < f2;
                float f9 = bl ? 1.0f : 0.4f;
                int n2 = ColorUtil.withAlpha(rus2.core(0.5f * f7), Math.round(230.0f * f7 * f9));
                int n3 = ColorUtil.withAlpha(rus2.core(0.5f * f8), Math.round(230.0f * f8 * f9));
                if (!usn2.project(d7, d5 + d11, d8, rvi) || !usn2.project(d9, d6 + d12, d10, rvj) || !usn2.project(d9, d6 - d12, d10, rvk) || !usn2.project(d7, d5 - d11, d8, rvl)) continue;
                DrawUtil.quad(class_3322, rvi[0], rvi[1], n2, rvj[0], rvj[1], n3, rvk[0], rvk[1], n3, rvl[0], rvl[1], n2);
            }
            double d13 = rvg * 3.1f + f4;
            double d14 = class_2432.field_1352 + Math.cos(d13) * d;
            double d15 = class_2432.field_1350 + Math.sin(d13) * d;
            double d16 = class_2432.field_1351 + 0.1 + (double)HitParticles.rwd(rvg * 3.1f * 0.42f + f4) * ((double)f - 0.2);
            if (!usn2.project(d14, d16, d15, rvi)) continue;
            boolean bl = usn2.depth(d14, d16, d15) < f2;
            float f10 = Math.min(44.0f, f3 * 0.45f * rus2.size);
            HitParticles.rwc(class_3322, gpuTextureView, rvi[0], rvi[1], f10, ColorUtil.withAlpha(rus2.at(0.3f), Math.round(120.0f * (bl ? 1.0f : 0.4f))));
            HitParticles.rwc(class_3322, gpuTextureView, rvi[0], rvi[1], f10 * 0.32f, ColorUtil.withAlpha(rus2.core(0.8f), Math.round(230.0f * (bl ? 1.0f : 0.4f))));
        }
        DrawUtil.additive(false);
    }

    private static void rwl(class_332 class_3322, ScreenProjection usn2, class_1309 class_13092, class_243 class_2432, rus rus2, float f) {
        int n;
        float f2 = class_13092.method_17682();
        float f3 = usn2.unitsPerBlock(class_2432.field_1352, class_2432.field_1351 + (double)f2 * 0.5, class_2432.field_1350);
        if (f3 <= 0.0f) {
            return;
        }
        double d = ((double)class_13092.method_17681() * 0.5 + 0.16) * (double)rus2.size;
        double d2 = class_2432.field_1351 + 0.1 + (double)HitParticles.rwd(rvg * 1.3f) * ((double)f2 - 0.2);
        if ((rvv -= f) <= 0.0f) {
            rvv = 0.07f;
            HitParticles.rwn(d, rus2.size, rus2.hit);
        }
        float f4 = Math.max(0.9f, Math.min(2.4f, f3 * 0.022f));
        float f5 = Math.min(8.0f, f3 * 0.09f);
        float f6 = usn2.depth(class_2432.field_1352, d2, class_2432.field_1350);
        float f7 = 0.75f + 0.25f * (float)Math.sin(rvg * 40.0f);
        for (n = 0; n < 4; ++n) {
            HitParticles.rwm(class_3322, usn2, class_2432.field_1352, d2, class_2432.field_1350, rvt[n], 11, f4, f5, rus2.at((float)n / 3.0f), f7 * (0.85f + 0.15f * rus2.hit), f6);
        }
        for (n = 0; n < 4; ++n) {
            HitParticles.rwm(class_3322, usn2, class_2432.field_1352, d2, class_2432.field_1350, rvu[n], 4, f4 * 0.7f, f5 * 0.7f, rus2.c2, f7 * 0.7f, f6);
        }
    }

    private static void rwm(class_332 class_3322, ScreenProjection usn2, double d, double d2, double d3, double[] dArray, int n, float f, float f2, int n2, float f3, float f4) {
        DrawUtil.additive(true);
        boolean bl = usn2.project(d + dArray[0], d2 + dArray[1], d3 + dArray[2], rvi);
        for (int i = 1; i < n; ++i) {
            double d4 = d + dArray[i * 3];
            double d5 = d2 + dArray[i * 3 + 1];
            double d6 = d3 + dArray[i * 3 + 2];
            boolean bl2 = usn2.project(d4, d5, d6, rvj);
            if (bl && bl2) {
                float f5 = f3 * (usn2.depth(d4, d5, d6) < f4 ? 1.0f : 0.35f);
                DrawUtil.softLine(class_3322, rvi[0], rvi[1], rvj[0], rvj[1], f2 * 0.5f, f2, ColorUtil.withAlpha(n2, Math.round(95.0f * f5)));
                DrawUtil.line(class_3322, rvi[0], rvi[1], rvj[0], rvj[1], f, ColorUtil.withAlpha(ColorUtil.lerp(n2, -1, 0.7f), Math.round(245.0f * f5)));
            }
            HitParticles.rvi[0] = rvj[0];
            HitParticles.rvi[1] = rvj[1];
            bl = bl2;
        }
        DrawUtil.additive(false);
    }

    private static void rwn(double d, float f, float f2) {
        double d2;
        double d3;
        double d4;
        double[] dArray;
        int n;
        double d5 = (0.07 + 0.05 * (double)f2) * (double)f;
        for (n = 0; n < 4; ++n) {
            dArray = rvt[n];
            double d6 = (double)((float)Math.PI * 2 * (float)n / 4.0f) + rvm.nextDouble() * 1.4;
            double d7 = 1.8 + rvm.nextDouble() * 1.3;
            for (int i = 0; i < 11; ++i) {
                d4 = (double)i / 10.0;
                d3 = d6 + d7 * d4;
                d2 = d + (rvm.nextDouble() - 0.4) * d5 * 1.4;
                dArray[i * 3] = Math.cos(d3) * d2;
                dArray[i * 3 + 1] = (rvm.nextDouble() - 0.5) * d5 * 2.6;
                dArray[i * 3 + 2] = Math.sin(d3) * d2;
            }
        }
        for (n = 0; n < 4; ++n) {
            dArray = rvt[rvm.nextInt(4)];
            int n2 = 1 + rvm.nextInt(9);
            double d8 = dArray[n2 * 3];
            double d9 = dArray[n2 * 3 + 1];
            d4 = dArray[n2 * 3 + 2];
            d3 = rvm.nextBoolean() ? 1.0 : -1.0;
            d2 = 1.0 + 0.15 * (double)f;
            double[] dArray2 = rvu[n];
            for (int i = 0; i < 4; ++i) {
                double d10 = (double)i / 3.0;
                double d11 = 1.0 + (d2 - 1.0) * d10;
                dArray2[i * 3] = d8 * d11 + (rvm.nextDouble() - 0.5) * d5 * d10;
                dArray2[i * 3 + 1] = d9 + d3 * d10 * (0.18 + rvm.nextDouble() * 0.12) * (double)f;
                dArray2[i * 3 + 2] = d4 * d11 + (rvm.nextDouble() - 0.5) * d5 * d10;
            }
        }
    }

    static {
        rvd = new Spring(7.0f);
        rve = new Spring(3.2f);
        rvh = -1L;
        rvi = new float[2];
        rvj = new float[2];
        rvk = new float[2];
        rvl = new float[2];
        rvm = new Random();
        rvo = new float[60][7];
        rvt = new double[4][33];
        rvu = new double[4][12];
    }

    private static /* synthetic */ int cbx(int n, int n2) {
        return n + n2 + -351939190;
    }

    private static /* synthetic */ int cby(int n, int n2) {
        return HitParticles.cbx(n, n2) * n2;
    }

    private static /* synthetic */ int cbz(int n, int n2) {
        return HitParticles.cby(n, n2) ^ 0x5E0F40AC;
    }
}

