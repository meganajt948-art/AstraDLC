/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.hlc;
import a.kfa;
import a.kfe;
import a.rus;
import a.ujt;
import a.unf;
import a.unm;
import a.usn;
import a.uut;
import a.vcj;
import a.vcq;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class ruv
extends kfe {
    private static ruv ruw;
    public final vlv mode = this.add(new vlv("Mode", "Ghosts", "Ghosts", "Sparkles", "Ring", "Comets", "Lightning"));
    public final vla color = this.add(new vla("Color", "Theme"));
    public final vla hitColor = this.add(new vla("Hit color", "Crimson"));
    public final vmc size = this.add(new vmc("Size", 1.0, 0.6, 1.6, 0.05).percent());
    public final vmc speed = this.add(new vmc("Speed", 1.0, 0.4, 2.0, 0.1).unit("x"));
    public final vmc brightness = this.add(new vmc("Brightness", 0.8, 0.3, 1.0, 0.05).percent());
    public final vkl mobs = this.add(new vkl("Mobs", false));
    private static final long rux = 3500L;
    private static final double ruy = 48.0;
    private static final float ruz = (float)Math.PI * 2;
    private static LivingEntity rva;
    private static long rvb;
    private static LivingEntity rvc;
    private static final vcj rvd;
    private static final vcj rve;
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

    public ruv() {
        super(new String(new char[]{'T', 'a', 'r', 'g', 'e', 't', 'E', 'S', 'P'}), "An effect on your current target", kfa.RENDER);
        ruw = this;
        ruv.rwf();
    }

    public static void onAttack(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity;
            rva = livingEntity = (LivingEntity)entity;
            rvb = System.currentTimeMillis();
        }
    }

    private boolean rwa(MinecraftClient minecraftClient, Entity entity) {
        block6: {
            block5: {
                if (!(entity instanceof LivingEntity)) break block5;
                LivingEntity livingEntity = (LivingEntity)entity;
                if (entity != minecraftClient.player && livingEntity.isAlive() && !entity.isRemoved() && !(entity instanceof ArmorStandEntity) && minecraftClient.world.getEntityById(entity.getId()) == entity && !entity.isSpectator()) break block6;
            }
            return false;
        }
        if (!(entity instanceof PlayerEntity) && !this.mobs.get()) {
            return false;
        }
        if (entity instanceof PlayerEntity && hhf.isFriend(entity)) {
            return false;
        }
        return minecraftClient.player.squaredDistanceTo(entity) < 2304.0;
    }

    private LivingEntity rwb(MinecraftClient minecraftClient) {
        if (rva != null && System.currentTimeMillis() - rvb < 3500L && this.rwa(minecraftClient, (Entity)rva)) {
            return rva;
        }
        Entity entity = minecraftClient.targetedEntity;
        return entity != null && this.rwa(minecraftClient, entity) ? (LivingEntity)entity : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        boolean bl;
        LivingEntity livingEntity;
        ruv ruv2 = ruw;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (ruv2 == null || minecraftClient.world == null || minecraftClient.player == null) {
            return;
        }
        if (!ruv2.isEnabled()) {
            rvc = null;
            rvd.set(0.0f);
            return;
        }
        if (minecraftClient.options.hudHidden || minecraftClient.currentScreen instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rvh) {
            return;
        }
        rvh = unf.frame();
        float f = unf.delta();
        LivingEntity livingEntity2 = ruv2.rwb(minecraftClient);
        if (livingEntity2 != null && livingEntity2 != rvc) {
            rvc = livingEntity2;
            rvd.set(0.0f);
            rve.set(0.0f);
            rvf = livingEntity2.hurtTime;
            rvv = 0.0f;
        }
        if ((livingEntity = rvc) == null) {
            return;
        }
        float f2 = rvd.step(livingEntity2 != null && ruv2.rwa(minecraftClient, (Entity)livingEntity), f);
        if (f2 <= 0.004f) {
            if (livingEntity2 != null) return;
            rvc = null;
            return;
        }
        boolean bl2 = bl = livingEntity.hurtTime > rvf;
        if (bl) {
            rve.set(1.0f);
            rvv = 0.0f;
        }
        rvf = livingEntity.hurtTime;
        rve.step(0.0f, f);
        float f3 = (float)ruv2.speed.get();
        rvg += f * f3;
        try {
            usn2 = usn.capture(renderTickCounter.getTickProgress(true), drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
        }
        catch (Throwable throwable) {
            return;
        }
        Vec3d vec3d = livingEntity.getLerpedPos(renderTickCounter.getTickProgress(true));
        rus rus2 = new rus(ruv2, vcq.outCubic(f2), vcq.outCubic(rve.get()));
        uut.beginFrame();
        uut.pushAlpha(rus2.vis * (float)ruv2.brightness.get());
        long l = System.nanoTime();
        uut.beginBatch();
        try {
            switch (ruv2.mode.get()) {
                case "Sparkles": {
                    ruv.rwg(drawContext, usn2, livingEntity, vec3d, rus2, f * f3);
                    return;
                }
                case "Ring": {
                    ruv.rwh(drawContext, usn2, livingEntity, vec3d, rus2);
                    return;
                }
                case "Comets": {
                    ruv.rwk(drawContext, usn2, livingEntity, vec3d, rus2);
                    return;
                }
                case "Lightning": {
                    ruv.rwl(drawContext, usn2, livingEntity, vec3d, rus2, f * f3);
                    return;
                }
                default: {
                    ruv.rwe(drawContext, usn2, livingEntity, vec3d, rus2);
                    return;
                }
            }
        }
        finally {
            uut.endBatch();
            uut.additive(false);
            uut.popAlpha();
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

    private static void rwc(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, int n) {
        if (gpuTextureView != null) {
            uut.sprite(drawContext, gpuTextureView, f, f2, f3, n);
        } else {
            float f4 = f3 * 0.18f;
            uut.shadow(drawContext, f - f4, f2 - f4, f4 * 2.0f, f4 * 2.0f, f4, f3 * 0.3f, n);
        }
    }

    private static float rwd(float f) {
        return 0.5f - 0.5f * (float)Math.cos(f);
    }

    private static void rwe(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, rus rus2) {
        GpuTextureView gpuTextureView = unm.view();
        float f = livingEntity.getHeight();
        double d = ((double)livingEntity.getWidth() * 0.55 + 0.35) * (double)rus2.size;
        double d2 = vec3d.y + (double)f * 0.5;
        float f2 = usn2.depth(vec3d.x, d2, vec3d.z);
        float f3 = usn2.unitsPerBlock(vec3d.x, d2, vec3d.z);
        if (f3 <= 0.0f) {
            return;
        }
        uut.additive(true);
        int n = 3;
        int n2 = 22;
        for (int i = 0; i < n; ++i) {
            float f4 = (float)Math.PI * 2 * (float)i / (float)n;
            for (int j = n2 - 1; j >= 0; --j) {
                float f5 = rvg * 2.3f - (float)j * 0.055f;
                float f6 = f5 + f4;
                double d3 = vec3d.x + Math.cos(f6) * d;
                double d4 = vec3d.z + Math.sin(f6) * d;
                double d5 = d2 + Math.sin(f5 * 1.25f + f4 * 1.7f) * (double)f * 0.36;
                if (!usn2.project(d3, d5, d4, rvi)) continue;
                float f7 = 1.0f - (float)j / (float)n2;
                boolean bl = usn2.depth(d3, d5, d4) < f2;
                float f8 = Math.min(40.0f, f3 * 0.3f * rus2.size * (0.25f + 0.75f * f7));
                float f9 = (float)Math.pow(f7, 1.5) * (bl ? 1.0f : 0.5f);
                ruv.rwc(drawContext, gpuTextureView, rvi[0], rvi[1], f8, ujt.withAlpha(rus2.at((float)j / (float)n2), Math.round(165.0f * f9)));
                if (j != 0) continue;
                ruv.rwc(drawContext, gpuTextureView, rvi[0], rvi[1], f8 * 0.34f, ujt.withAlpha(rus2.core(0.55f), Math.round(200.0f * (bl ? 1.0f : 0.55f))));
            }
        }
        uut.additive(false);
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

    private static void rwg(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, rus rus2, float f) {
        GpuTextureView gpuTextureView = unm.view();
        float f2 = livingEntity.getHeight();
        double d = ((double)livingEntity.getWidth() * 0.6 + 0.3) * (double)rus2.size;
        float f3 = usn2.depth(vec3d.x, vec3d.y + (double)f2 * 0.5, vec3d.z);
        float f4 = usn2.unitsPerBlock(vec3d.x, vec3d.y + (double)f2 * 0.5, vec3d.z);
        if (f4 <= 0.0f) {
            return;
        }
        float f5 = Math.min(12.0f, Math.max(3.0f, f4 * 0.1f)) * rus2.size;
        uut.additive(true);
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
            double d5 = vec3d.x + Math.cos(fArray[0]) * d4;
            if (!usn2.project(d5, d3 = vec3d.y + ((double)fArray[2] * 1.1 - 0.05) * (double)f2, d2 = vec3d.z + Math.sin(fArray[0]) * d4, rvi)) continue;
            float f7 = Math.min(1.0f, Math.min(fArray[2] / 0.15f, (1.0f - fArray[2]) / 0.2f));
            float f8 = 0.5f + 0.5f * (float)Math.sin(rvg * fArray[5] + fArray[4]);
            boolean bl = usn2.depth(d5, d3, d2) < f3;
            if ((f6 = f7 * (0.25f + 0.75f * (f8 *= f8)) * (bl ? 1.0f : 0.45f)) <= 0.02f) continue;
            float f9 = f5 * fArray[6];
            ruv.rwc(drawContext, gpuTextureView, rvi[0], rvi[1], f9 * 3.6f, ujt.withAlpha(rus2.at(fArray[6]), Math.round(80.0f * f6)));
            ruv.rwc(drawContext, gpuTextureView, rvi[0], rvi[1], f9 * 1.3f, ujt.withAlpha(rus2.core(0.75f), Math.round(255.0f * f6)));
        }
        uut.additive(false);
    }

    private static void rwh(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, rus rus2) {
        float f = livingEntity.getHeight();
        double d = ((double)livingEntity.getWidth() * 0.5 + 0.2) * (double)rus2.size;
        float f2 = rvg * 1.6f;
        double d2 = vec3d.y + 0.05 + (double)ruv.rwd(f2) * ((double)f - 0.1);
        boolean bl = Math.sin(f2) > 0.0;
        double d3 = 0.04 * (double)rus2.size;
        double d4 = 0.2 * (double)rus2.size * Math.min(1.0, Math.abs(Math.sin(f2)) * 1.6 + 0.25);
        ruv.rwi(drawContext, usn2, vec3d.x, d2, vec3d.z, d, bl ? d4 : d3 * 1.4, bl ? d3 * 1.4 : d4, rus2, 1.0f, 44);
        ruv.rwj(drawContext, usn2, vec3d.x, d2, vec3d.z, d, 44, rus2, 0.9f);
    }

    private static void rwi(DrawContext drawContext, usn usn2, double d, double d2, double d3, double d4, double d5, double d6, rus rus2, float f, int n) {
        float f2 = usn2.depth(d, d2, d3);
        uut.additive(true);
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
            int n3 = ujt.withAlpha(ujt.lerp(n2, -1, 0.35f), Math.round(120.0f * f3));
            int n4 = ujt.withAlpha(n2, 0);
            if (!usn2.project(d + d9, d2, d3 + d10, rvi) || !usn2.project(d + d11, d2, d3 + d12, rvj)) continue;
            if (usn2.project(d + d11, d2 - d5, d3 + d12, rvk) && usn2.project(d + d9, d2 - d5, d3 + d10, rvl)) {
                uut.quad(drawContext, rvi[0], rvi[1], n3, rvj[0], rvj[1], n3, rvk[0], rvk[1], n4, rvl[0], rvl[1], n4);
            }
            if (!usn2.project(d + d11, d2 + d6, d3 + d12, rvk) || !usn2.project(d + d9, d2 + d6, d3 + d10, rvl)) continue;
            uut.quad(drawContext, rvi[0], rvi[1], n3, rvj[0], rvj[1], n3, rvk[0], rvk[1], n4, rvl[0], rvl[1], n4);
        }
        uut.additive(false);
    }

    private static void rwj(DrawContext drawContext, usn usn2, double d, double d2, double d3, double d4, int n, rus rus2, float f) {
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
                uut.line(drawContext, rvi[0], rvi[1], rvj[0], rvj[1], f4, ujt.withAlpha(rus2.core(0.6f), Math.round(235.0f * f * (bl3 ? 1.0f : 0.3f))));
            }
            ruv.rvi[0] = rvj[0];
            ruv.rvi[1] = rvj[1];
            bl = bl2;
        }
    }

    private static void rwk(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, rus rus2) {
        float f = livingEntity.getHeight();
        double d = ((double)livingEntity.getWidth() * 0.5 + 0.28) * (double)rus2.size;
        float f2 = usn2.depth(vec3d.x, vec3d.y + (double)f * 0.5, vec3d.z);
        float f3 = usn2.unitsPerBlock(vec3d.x, vec3d.y + (double)f * 0.5, vec3d.z);
        if (f3 <= 0.0f) {
            return;
        }
        GpuTextureView gpuTextureView = unm.view();
        int n = 18;
        double d2 = 0.12 * (double)rus2.size;
        uut.additive(true);
        for (int i = 0; i < 2; ++i) {
            float f4 = (float)i * (float)Math.PI;
            for (int j = n - 1; j > 0; --j) {
                float f5 = rvg * 3.1f - (float)j * 0.075f;
                float f6 = rvg * 3.1f - (float)(j - 1) * 0.075f;
                double d3 = f5 + f4;
                double d4 = f6 + f4;
                double d5 = vec3d.y + 0.1 + (double)ruv.rwd(f5 * 0.42f + f4) * ((double)f - 0.2);
                double d6 = vec3d.y + 0.1 + (double)ruv.rwd(f6 * 0.42f + f4) * ((double)f - 0.2);
                double d7 = vec3d.x + Math.cos(d3) * d;
                double d8 = vec3d.z + Math.sin(d3) * d;
                double d9 = vec3d.x + Math.cos(d4) * d;
                double d10 = vec3d.z + Math.sin(d4) * d;
                float f7 = 1.0f - (float)j / (float)n;
                float f8 = 1.0f - (float)(j - 1) / (float)n;
                double d11 = d2 * (double)f7;
                double d12 = d2 * (double)f8;
                boolean bl = usn2.depth(d9, d6, d10) < f2;
                float f9 = bl ? 1.0f : 0.4f;
                int n2 = ujt.withAlpha(rus2.core(0.5f * f7), Math.round(230.0f * f7 * f9));
                int n3 = ujt.withAlpha(rus2.core(0.5f * f8), Math.round(230.0f * f8 * f9));
                if (!usn2.project(d7, d5 + d11, d8, rvi) || !usn2.project(d9, d6 + d12, d10, rvj) || !usn2.project(d9, d6 - d12, d10, rvk) || !usn2.project(d7, d5 - d11, d8, rvl)) continue;
                uut.quad(drawContext, rvi[0], rvi[1], n2, rvj[0], rvj[1], n3, rvk[0], rvk[1], n3, rvl[0], rvl[1], n2);
            }
            double d13 = rvg * 3.1f + f4;
            double d14 = vec3d.x + Math.cos(d13) * d;
            double d15 = vec3d.z + Math.sin(d13) * d;
            double d16 = vec3d.y + 0.1 + (double)ruv.rwd(rvg * 3.1f * 0.42f + f4) * ((double)f - 0.2);
            if (!usn2.project(d14, d16, d15, rvi)) continue;
            boolean bl = usn2.depth(d14, d16, d15) < f2;
            float f10 = Math.min(44.0f, f3 * 0.45f * rus2.size);
            ruv.rwc(drawContext, gpuTextureView, rvi[0], rvi[1], f10, ujt.withAlpha(rus2.at(0.3f), Math.round(120.0f * (bl ? 1.0f : 0.4f))));
            ruv.rwc(drawContext, gpuTextureView, rvi[0], rvi[1], f10 * 0.32f, ujt.withAlpha(rus2.core(0.8f), Math.round(230.0f * (bl ? 1.0f : 0.4f))));
        }
        uut.additive(false);
    }

    private static void rwl(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, rus rus2, float f) {
        int n;
        float f2 = livingEntity.getHeight();
        float f3 = usn2.unitsPerBlock(vec3d.x, vec3d.y + (double)f2 * 0.5, vec3d.z);
        if (f3 <= 0.0f) {
            return;
        }
        double d = ((double)livingEntity.getWidth() * 0.5 + 0.16) * (double)rus2.size;
        double d2 = vec3d.y + 0.1 + (double)ruv.rwd(rvg * 1.3f) * ((double)f2 - 0.2);
        if ((rvv -= f) <= 0.0f) {
            rvv = 0.07f;
            ruv.rwn(d, rus2.size, rus2.hit);
        }
        float f4 = Math.max(0.9f, Math.min(2.4f, f3 * 0.022f));
        float f5 = Math.min(8.0f, f3 * 0.09f);
        float f6 = usn2.depth(vec3d.x, d2, vec3d.z);
        float f7 = 0.75f + 0.25f * (float)Math.sin(rvg * 40.0f);
        for (n = 0; n < 4; ++n) {
            ruv.rwm(drawContext, usn2, vec3d.x, d2, vec3d.z, rvt[n], 11, f4, f5, rus2.at((float)n / 3.0f), f7 * (0.85f + 0.15f * rus2.hit), f6);
        }
        for (n = 0; n < 4; ++n) {
            ruv.rwm(drawContext, usn2, vec3d.x, d2, vec3d.z, rvu[n], 4, f4 * 0.7f, f5 * 0.7f, rus2.c2, f7 * 0.7f, f6);
        }
    }

    private static void rwm(DrawContext drawContext, usn usn2, double d, double d2, double d3, double[] dArray, int n, float f, float f2, int n2, float f3, float f4) {
        uut.additive(true);
        boolean bl = usn2.project(d + dArray[0], d2 + dArray[1], d3 + dArray[2], rvi);
        for (int i = 1; i < n; ++i) {
            double d4 = d + dArray[i * 3];
            double d5 = d2 + dArray[i * 3 + 1];
            double d6 = d3 + dArray[i * 3 + 2];
            boolean bl2 = usn2.project(d4, d5, d6, rvj);
            if (bl && bl2) {
                float f5 = f3 * (usn2.depth(d4, d5, d6) < f4 ? 1.0f : 0.35f);
                uut.softLine(drawContext, rvi[0], rvi[1], rvj[0], rvj[1], f2 * 0.5f, f2, ujt.withAlpha(n2, Math.round(95.0f * f5)));
                uut.line(drawContext, rvi[0], rvi[1], rvj[0], rvj[1], f, ujt.withAlpha(ujt.lerp(n2, -1, 0.7f), Math.round(245.0f * f5)));
            }
            ruv.rvi[0] = rvj[0];
            ruv.rvi[1] = rvj[1];
            bl = bl2;
        }
        uut.additive(false);
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
        rvd = new vcj(7.0f);
        rve = new vcj(3.2f);
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
        return ruv.cbx(n, n2) * n2;
    }

    private static /* synthetic */ int cbz(int n, int n2) {
        return ruv.cby(n, n2) ^ 0x5E0F40AC;
    }
}

