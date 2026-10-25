/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket
 *  net.minecraft.particle.BlockStateParticleEffect
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package a;

import a.hlc;
import a.kfa;
import a.kfe;
import a.rrj;
import a.rru;
import a.sql;
import a.ujt;
import a.unf;
import a.unm;
import a.usn;
import a.uut;
import a.uwg;
import a.uwt;
import a.vcq;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import a.wcn;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class rrx
extends kfe {
    private static rrx rry;
    private final vlv rrz = this.add(new vlv("Style", "Angel", "Angel", "Glass"));
    private final vkl rsa = this.add(new vkl("On kill", true));
    private final vkl rsb = this.add(new vkl("On totem pop", true));
    private final vkl rsc = this.add(new vkl("Only my targets", true));
    private final vkl rsd = this.add(new vkl("Mobs", false));
    private final vla rse = this.add(new vla("Color", "Ice"));
    private final vla rsf = this.add(new vla("Totem color", "Gold"));
    private final vmc rsg = this.add(new vmc("Size", 1.0, 0.6, 1.6, 0.05).percent());
    private final vmc rsh = this.add(new vmc("Duration", 3.0, 1.5, 5.0, 0.1).suffix("s"));
    private final vkl rsi = this.add(new vkl("Wings", true));
    private final vkl rsj = this.add(new vkl("Halo", true));
    private final vlv rsk = this.add(new vlv("Pieces", "Shards", "Shards", "Cubes"));
    private final vkl rsl = this.add(new vkl("Sound", true));
    private final vkl rsm = this.add(new vkl("Particles", true));
    private static final long rsn = 12000L;
    private static final int rso = 6;
    private static final float rsp = (float)Math.PI * 2;
    private static final float rsq = 0.0625f;
    private static final Queue<rrj> rsr;
    private static final Map<Integer, Long> rss;
    private final List<rru> rst = new ArrayList<rru>();
    private long rsu = -1L;
    private float rsv;
    private static final int rsw = 4;
    private final List<rrj> rsx = new ArrayList<rrj>();
    private final List<sql> rsy = new ArrayList<sql>();
    private final List<uwg> rsz = new ArrayList<uwg>();
    private final Matrix4f rta = new Matrix4f();
    private final Quaternionf rtb = new Quaternionf();
    private final Random rtc = new Random();
    private final double[] rtd = new double[6];
    private long rte;
    private final Matrix4f rtf = new Matrix4f();
    private final Vector3f rtg = new Vector3f();
    private final float[][] rth = new float[8][2];
    private final boolean[] rti = new boolean[8];
    private final double[][] rtj = new double[8][3];
    private final float[] rtk = new float[2];
    private final float[] rtl = new float[2];
    private final float[] rtm = new float[2];
    private final float[] rtn = new float[2];
    private final int[] rto = new int[4];
    private final float[][] rtp = new float[rtr.length][2];
    private final boolean[] rtq = new boolean[rtr.length];
    private static final float[][] rtr;
    private static final int[][] rts;
    private static final float[][] rtt;
    private static /* synthetic */ long rtu;
    private static /* synthetic */ long rtv;

    public rrx() {
        super(new String(new char[]{'S', 'o', 'u', 'l', 'E', 'S', 'P'}), "A soul or glass copy on a kill", kfa.RENDER);
        rry = this;
        wcn.listen(rrx::rtw);
        this.rsf.visibleWhen(this.rsb::get);
        this.rsg.visibleWhen(() -> this.rrz.is("Angel"));
        this.rsh.visibleWhen(() -> this.rrz.is("Angel"));
        this.rsi.visibleWhen(() -> this.rrz.is("Angel"));
        this.rsj.visibleWhen(() -> this.rrz.is("Angel"));
        this.rsk.visibleWhen(() -> this.rrz.is("Glass"));
        this.rsl.visibleWhen(() -> this.rrz.is("Glass"));
        this.rsm.visibleWhen(() -> this.rrz.is("Glass"));
    }

    public static int activeGlass() {
        return rry == null ? 0 : rrx.rry.rsy.size();
    }

    public static void trigger(LivingEntity livingEntity, boolean bl) {
        if (rry != null && rry.isEnabled()) {
            rsr.add(new rrj(livingEntity.getId(), livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.bodyYaw, livingEntity.getHeight(), livingEntity instanceof PlayerEntity, bl));
        }
    }

    public static void onAttack(Entity entity) {
        if (rry != null && rry.isEnabled()) {
            rss.put(entity.getId(), System.currentTimeMillis());
        }
    }

    private static void rtw(Packet<?> packet) {
        LivingEntity livingEntity;
        Entity entity;
        byte by;
        block8: {
            block7: {
                rrx rrx2 = rry;
                if (rrx2 == null || !rrx2.isEnabled() || !(packet instanceof EntityStatusS2CPacket)) {
                    return;
                }
                EntityStatusS2CPacket entityStatusS2CPacket = (EntityStatusS2CPacket)packet;
                by = entityStatusS2CPacket.getStatus();
                if (by != 3 && by != 35) {
                    return;
                }
                ClientWorld clientWorld = MinecraftClient.getInstance().world;
                if (clientWorld == null) {
                    return;
                }
                entity = entityStatusS2CPacket.getEntity((World)clientWorld);
                if (!(entity instanceof LivingEntity)) break block7;
                livingEntity = (LivingEntity)entity;
                if (entity != MinecraftClient.getInstance().player) break block8;
            }
            return;
        }
        rsr.add(new rrj(entity.getId(), entity.getX(), entity.getY(), entity.getZ(), livingEntity.bodyYaw, entity.getHeight(), entity instanceof PlayerEntity, by == 35));
        if (rsr.size() > 32) {
            rsr.poll();
        }
    }

    @Override
    protected void onDisable() {
        this.rst.clear();
        rsr.clear();
        rss.clear();
        this.rsx.clear();
        this.rsy.clear();
        this.rte = 0L;
        uwt.release();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        rrj rrj2;
        wcn.ensure(minecraftClient);
        long l = System.currentTimeMillis();
        rss.values().removeIf(l2 -> l - l2 > 12000L);
        while ((rrj2 = rsr.poll()) != null) {
            if (!rrj2.rrr ? !this.rsa.get() : !this.rsb.get()) continue;
            if (!rrj2.rrq && !this.rsd.get() || this.rsc.get() && !rss.containsKey(rrj2.rrk)) continue;
            if (this.rrz.is("Glass")) {
                if (this.rsx.size() >= 8) continue;
                this.rsx.add(rrj2);
                continue;
            }
            if (this.rst.size() >= 6) {
                this.rst.remove(0);
            }
            rru rru2 = new rru();
            rru2.x = rrj2.rrl;
            rru2.y = rrj2.rrm;
            rru2.z = rrj2.rrn;
            rru2.yaw = rrj2.rro;
            rru2.scale = (float)this.rsg.get() * Math.max(0.5f, Math.min(1.4f, rrj2.rrp / 1.8f));
            rru2.totem = rrj2.rrr;
            rru2.seed = (float)(Math.random() * 100.0);
            this.rst.add(rru2);
        }
    }

    @Override
    public void onWorldRenderLate(MinecraftClient minecraftClient) {
        Object object;
        if (this.rsx.isEmpty() && this.rsy.isEmpty()) {
            this.rte = 0L;
            return;
        }
        ClientWorld clientWorld = minecraftClient.world;
        if (clientWorld == null || minecraftClient.player == null) {
            this.rsx.clear();
            this.rsy.clear();
            return;
        }
        long l = System.nanoTime();
        float f = this.rte == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.rte) / 1.0E9f);
        this.rte = l;
        float f2 = minecraftClient.getRenderTickCounter().getTickProgress(false);
        for (rrj rrj2 : this.rsx) {
            LivingEntity livingEntity;
            object = clientWorld.getEntityById(rrj2.rrk);
            int n = (rrj2.rrr ? this.rsf : this.rse).color();
            if (object instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity)object;
                livingEntity = livingEntity2;
            } else {
                livingEntity = null;
            }
            sql sql2 = sql.create(minecraftClient, livingEntity, rrj2.rrl, rrj2.rrm, rrj2.rrn, rrj2.rro, rrj2.rrp, rrj2.rrq, rrj2.rrr, this.rsk.is("Cubes"), n, f2);
            if (this.rsy.size() >= 4) {
                this.rsy.remove(0);
            }
            this.rsy.add(sql2);
        }
        this.rsx.clear();
        int n = 0;
        for (int i = this.rsy.size() - 1; i >= 0; --i) {
            object = this.rsy.get(i);
            if (!((sql)object).update(f)) {
                this.rsy.remove(i);
                continue;
            }
            this.rtx(clientWorld, (sql)object);
            n += ((sql)object).vertices();
        }
        if (this.rsy.isEmpty()) {
            return;
        }
        Camera camera = minecraftClient.gameRenderer.getCamera();
        object = camera.getCameraPos();
        ByteBuffer byteBuffer = uwt.staging(n);
        this.rsz.clear();
        int n2 = 0;
        for (sql sql3 : this.rsy) {
            int n3 = sql3.write(byteBuffer, ((Vec3d)object).x, ((Vec3d)object).y, ((Vec3d)object).z);
            this.rsz.add(new uwg(n2, n3, sql3.red, sql3.green, sql3.blue, sql3.alpha(), (float)(sql3.y + (double)sql3.scan() - ((Vec3d)object).y), (float)(sql3.y + (double)sql3.sweep() - ((Vec3d)object).y), sql3.flash(), sql3.broken()));
            n2 += n3;
        }
        this.rta.rotation((Quaternionfc)camera.getRotation().conjugate(this.rtb));
        uwt.draw(this.rta, 0.36f, 0.86f, 0.36f, 1.0f, this.rsz, byteBuffer);
    }

    private void rtx(ClientWorld clientWorld, sql sql2) {
        int n = sql2.takeEvents();
        if (n == 0) {
            return;
        }
        double d = sql2.centerX();
        double d2 = sql2.centerY();
        double d3 = sql2.centerZ();
        if (this.rsl.get()) {
            if ((n & 1) != 0) {
                clientWorld.playSoundClient(d, d2, d3, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 0.9f, 1.4f, false);
            }
            if ((n & 2) != 0) {
                if (sql2.totem) {
                    clientWorld.playSoundClient(d, d2, d3, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 0.9f, 1.2f, false);
                } else {
                    clientWorld.playSoundClient(d, d2, d3, SoundEvents.BLOCK_GLASS_HIT, SoundCategory.PLAYERS, 0.8f, 0.7f, false);
                }
            }
            if ((n & 4) != 0) {
                if (sql2.totem) {
                    clientWorld.playSoundClient(d, d2, d3, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 0.35f, 1.6f, false);
                } else {
                    clientWorld.playSoundClient(d, d2, d3, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0f, 0.92f + this.rtc.nextFloat() * 0.14f, false);
                    clientWorld.playSoundClient(d, d2, d3, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.PLAYERS, 0.5f, 1.35f, false);
                }
            }
        }
        if (this.rsm.get() && (n & 4) != 0) {
            int n2;
            BlockStateParticleEffect blockStateParticleEffect = new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.GLASS.getDefaultState());
            int n3 = sql2.totem ? 8 : 40;
            for (n2 = 0; n2 < n3; ++n2) {
                if (!sql2.sample(this.rtc, this.rtd)) continue;
                clientWorld.addParticleClient((ParticleEffect)blockStateParticleEffect, this.rtd[0], this.rtd[1], this.rtd[2], this.rtd[3] * 0.3, this.rtd[4] * 0.3, this.rtd[5] * 0.3);
            }
            n2 = sql2.totem ? 5 : 14;
            for (int i = 0; i < n2; ++i) {
                clientWorld.addParticleClient((ParticleEffect)ParticleTypes.END_ROD, d + (this.rtc.nextDouble() - 0.5) * 0.6, d2 + (this.rtc.nextDouble() - 0.5) * 1.4, d3 + (this.rtc.nextDouble() - 0.5) * 0.6, (this.rtc.nextDouble() - 0.5) * 0.12, this.rtc.nextDouble() * 0.08, (this.rtc.nextDouble() - 0.5) * 0.12);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        rrx rrx2 = rry;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (rrx2 == null || !rrx2.isEnabled() || rrx2.rst.isEmpty() || minecraftClient.world == null || minecraftClient.options.hudHidden || minecraftClient.currentScreen instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rrx2.rsu) {
            return;
        }
        rrx2.rsu = unf.frame();
        float f = unf.delta();
        rrx2.rsv += f;
        try {
            usn2 = usn.capture(renderTickCounter.getTickProgress(true), drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
        }
        catch (Throwable throwable) {
            return;
        }
        float f2 = (float)rrx2.rsh.get();
        uut.beginFrame();
        try {
            for (int i = rrx2.rst.size() - 1; i >= 0; --i) {
                rru rru2 = rrx2.rst.get(i);
                rru2.age += f;
                if (rru2.age >= f2) {
                    rrx2.rst.remove(i);
                    continue;
                }
                rrx2.rty(drawContext, usn2, rru2, rru2.age / f2);
            }
        }
        finally {
            uut.additive(false);
        }
    }

    private void rty(DrawContext drawContext, usn usn2, rru rru2, float f) {
        float f2;
        float f3 = vcq.outCubic(Math.min(1.0f, f / 0.12f));
        float f4 = f3 * (f2 = f < 0.55f ? 1.0f : 1.0f - vcq.inCubic((f - 0.55f) / 0.45f));
        if (f4 <= 0.01f) {
            return;
        }
        float f5 = (rru2.totem ? 1.8f : 3.2f) * vcq.outCubic(f) * rru2.scale;
        float f6 = (float)Math.sin(this.rsv * 2.2f + rru2.seed) * 0.06f;
        double d = rru2.y + (double)f5 + (double)f6 + 0.1;
        vla vla2 = rru2.totem ? this.rsf : this.rse;
        int n = vla2.color() | 0xFF000000;
        int n2 = vla2.color2() | 0xFF000000;
        float f7 = vcq.outCubic(Math.min(1.0f, f / 0.45f));
        float f8 = (float)Math.toRadians(-rru2.yaw) + f * 0.6f;
        if (this.rsi.get()) {
            this.rub(drawContext, usn2, rru2, d, f8, f7, f4, n, n2);
        }
        this.rtz(drawContext, usn2, rru2, d, f8, f7, f4, n, n2);
        uut.additive(true);
        this.rue(drawContext, usn2, rru2, d, f4, n, n2, f);
        uut.additive(false);
        uut.additive(true);
        if (this.rsj.get()) {
            this.rud(drawContext, usn2, rru2, d + 2.2 * (double)rru2.scale, f4, n, n2);
        }
        this.ruf(drawContext, usn2, rru2, d, f4, n, n2);
        uut.additive(false);
    }

    private void rtz(DrawContext drawContext, usn usn2, rru rru2, double d, float f, float f2, float f3, int n, int n2) {
        float f4 = rru2.scale;
        float f5 = -(0.35f + 2.1f * f2);
        this.rua(drawContext, usn2, rru2, d, f, f4, -4.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, -2.0f, 12.0f, 0.0f, -0.15f * f2, f3 * 0.55f, n, n2);
        this.rua(drawContext, usn2, rru2, d, f, f4, 0.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 2.0f, 12.0f, 0.0f, 0.1f * f2, f3 * 0.55f, n, n2);
        this.rua(drawContext, usn2, rru2, d, f, f4, -4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.0f, 12.0f, 0.0f, 0.0f, f3 * 0.75f, n, n2);
        this.rua(drawContext, usn2, rru2, d, f, f4, -4.0f, 24.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, 24.0f, 0.0f, -0.25f * f2, f3 * 0.9f, n, n2);
        this.rua(drawContext, usn2, rru2, d, f, f4, -8.0f, 12.0f, -2.0f, 4.0f, 12.0f, 4.0f, -5.0f, 22.0f, f5, 0.0f, f3 * 0.7f, n, n2);
        this.rua(drawContext, usn2, rru2, d, f, f4, 4.0f, 12.0f, -2.0f, 4.0f, 12.0f, 4.0f, 5.0f, 22.0f, -f5, 0.0f, f3 * 0.7f, n, n2);
    }

    private void rua(DrawContext drawContext, usn usn2, rru rru2, double d, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int n, int n2) {
        this.rtf.identity().rotateY(f).scale(f2 * 0.0625f).translate(f9, f10, 0.0f).rotateZ(f11).rotateX(f12).translate(-f9, -f10, 0.0f);
        Vec3d vec3d = usn2.camera();
        for (int i = 0; i < 8; ++i) {
            this.rtg.set((i & 1) == 0 ? f3 : f3 + f6, (i & 2) == 0 ? f4 : f4 + f7, (i & 4) == 0 ? f5 : f5 + f8);
            this.rtf.transformPosition(this.rtg);
            this.rtj[i][0] = rru2.x + (double)this.rtg.x;
            this.rtj[i][1] = d + (double)this.rtg.y;
            this.rtj[i][2] = rru2.z + (double)this.rtg.z;
            this.rti[i] = usn2.depth(this.rtj[i][0], this.rtj[i][1], this.rtj[i][2]) > 0.05f && usn2.project(this.rtj[i][0], this.rtj[i][1], this.rtj[i][2], this.rth[i]);
        }
        float f14 = Math.min(1.0f, (f4 + f7) / 32.0f);
        float f15 = Math.min(1.0f, f4 / 32.0f);
        int n3 = ujt.withAlpha(ujt.lerp(n, -1, 0.2f), Math.round(125.0f * f13 * (0.35f + 0.65f * f14)));
        int n4 = ujt.withAlpha(ujt.lerp(n, n2, 0.4f), Math.round(125.0f * f13 * (0.08f + 0.92f * f15)));
        for (int i = 0; i < 6; ++i) {
            int[] nArray = rts[i];
            if (!this.rti[nArray[0]] || !this.rti[nArray[1]] || !this.rti[nArray[2]] || !this.rti[nArray[3]]) continue;
            this.rtg.set(rtt[i][0], rtt[i][1], rtt[i][2]);
            this.rtf.transformDirection(this.rtg);
            double d2 = (this.rtj[nArray[0]][0] + this.rtj[nArray[2]][0]) * 0.5;
            double d3 = (this.rtj[nArray[0]][1] + this.rtj[nArray[2]][1]) * 0.5;
            double d4 = (this.rtj[nArray[0]][2] + this.rtj[nArray[2]][2]) * 0.5;
            if ((double)this.rtg.x * (vec3d.x - d2) + (double)this.rtg.y * (vec3d.y - d3) + (double)this.rtg.z * (vec3d.z - d4) <= 0.0) continue;
            for (int j = 0; j < 4; ++j) {
                this.rto[j] = (nArray[j] & 2) != 0 ? n3 : n4;
            }
            uut.quad(drawContext, this.rth[nArray[0]][0], this.rth[nArray[0]][1], this.rto[0], this.rth[nArray[1]][0], this.rth[nArray[1]][1], this.rto[1], this.rth[nArray[2]][0], this.rth[nArray[2]][1], this.rto[2], this.rth[nArray[3]][0], this.rth[nArray[3]][1], this.rto[3]);
        }
    }

    private void rub(DrawContext drawContext, usn usn2, rru rru2, double d, float f, float f2, float f3, int n, int n2) {
        float f4 = rru2.scale;
        float f5 = (float)Math.sin(this.rsv * 3.2f + rru2.seed) * 0.16f;
        double d2 = 0.95 * (double)f4 * (0.35 + 0.65 * (double)f2);
        double d3 = Math.cos(f);
        double d4 = Math.sin(f);
        int n3 = ujt.withAlpha(ujt.lerp(n, -1, 0.3f), Math.round(150.0f * f3));
        int n4 = ujt.withAlpha(ujt.lerp(n2, n, 0.3f), Math.round(26.0f * f3));
        int n5 = ujt.withAlpha(ujt.lerp(n, -1, 0.5f), Math.round(170.0f * f3));
        for (int i = -1; i <= 1; i += 2) {
            int n6;
            double d5 = 0.45 - 0.3 * (double)f2 + (double)f5;
            double d6 = (double)i * Math.cos(d5);
            double d7 = -Math.sin(d5);
            double d8 = (double)i * 0.1 * (double)f4;
            double d9 = 1.32 * (double)f4;
            double d10 = -0.16 * (double)f4;
            if (!rrx.ruc(usn2, rru2, d, d8, d9, d10, d3, d4, this.rtk)) continue;
            for (n6 = 0; n6 < rtr.length; ++n6) {
                double d11 = (double)rtr[n6][0] * d2;
                double d12 = (double)rtr[n6][1] * d2;
                this.rtq[n6] = rrx.ruc(usn2, rru2, d, d8 + d6 * d11, d9 + d12, d10 + d7 * d11, d3, d4, this.rtp[n6]);
            }
            n6 = 0;
            while (n6 + 1 < rtr.length) {
                if (this.rtq[n6] && this.rtq[n6 + 1]) {
                    float[] fArray = this.rtp[n6];
                    float[] fArray2 = this.rtp[n6 + 1];
                    uut.quad(drawContext, this.rtk[0], this.rtk[1], n3, fArray[0], fArray[1], n4, fArray2[0], fArray2[1], n4, fArray2[0], fArray2[1], n4);
                }
                ++n6;
            }
            uut.additive(true);
            n6 = 0;
            while (n6 + 1 < rtr.length) {
                if (this.rtq[n6] && this.rtq[n6 + 1]) {
                    uut.line(drawContext, this.rtp[n6][0], this.rtp[n6][1], this.rtp[n6 + 1][0], this.rtp[n6 + 1][1], 0.9f, n5);
                }
                ++n6;
            }
            uut.additive(false);
        }
    }

    private static boolean ruc(usn usn2, rru rru2, double d, double d2, double d3, double d4, double d5, double d6, float[] fArray) {
        return usn2.project(rru2.x + d2 * d5 + d4 * d6, d + d3, rru2.z - d2 * d6 + d4 * d5, fArray);
    }

    private void rud(DrawContext drawContext, usn usn2, rru rru2, double d, float f, int n, int n2) {
        float f2 = usn2.unitsPerBlock(rru2.x, d, rru2.z);
        if (f2 <= 0.0f) {
            return;
        }
        double d2 = 0.3 * (double)rru2.scale;
        float f3 = Math.max(0.8f, Math.min(2.4f, f2 * 0.025f));
        int n3 = 28;
        boolean bl = usn2.project(rru2.x + d2, d, rru2.z, this.rtk);
        for (int i = 1; i <= n3; ++i) {
            double d3 = (float)Math.PI * 2 * (float)i / (float)n3;
            boolean bl2 = usn2.project(rru2.x + Math.cos(d3) * d2, d + Math.sin(d3 * 2.0 + (double)this.rsv) * 0.01, rru2.z + Math.sin(d3) * d2, this.rtl);
            if (bl && bl2) {
                uut.softLine(drawContext, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f3, f3 * 3.0f, ujt.withAlpha(n, Math.round(90.0f * f)));
                uut.line(drawContext, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f3 * 0.6f, ujt.withAlpha(ujt.lerp(n2, -1, 0.6f), Math.round(230.0f * f)));
            }
            this.rtk[0] = this.rtl[0];
            this.rtk[1] = this.rtl[1];
            bl = bl2;
        }
    }

    private void rue(DrawContext drawContext, usn usn2, rru rru2, double d, float f, int n, int n2, float f2) {
        float f3 = usn2.unitsPerBlock(rru2.x, d + 1.0, rru2.z);
        if (f3 <= 0.0f) {
            return;
        }
        float f4 = Math.max(0.7f, Math.min(2.0f, f3 * 0.02f));
        int n3 = 30;
        for (int i = 0; i < 2; ++i) {
            float f5 = (float)i * (float)Math.PI;
            boolean bl = false;
            for (int j = 0; j <= n3; ++j) {
                float f6 = (float)j / (float)n3;
                double d2 = -0.2 + (double)f6 * 2.4 * (double)rru2.scale;
                double d3 = (0.25 + Math.sin((double)f6 * Math.PI) * 0.55) * (double)rru2.scale;
                double d4 = (double)(f6 * ((float)Math.PI * 2)) * 1.6 + (double)(this.rsv * 2.4f) + (double)f5;
                boolean bl2 = usn2.project(rru2.x + Math.cos(d4) * d3, d + d2, rru2.z + Math.sin(d4) * d3, this.rtl);
                if (bl && bl2) {
                    float f7 = f * (float)Math.sin((double)f6 * Math.PI) * Math.min(1.0f, f2 * 4.0f);
                    uut.softLine(drawContext, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f4, f4 * 3.5f, ujt.withAlpha(ujt.lerp(n, n2, f6), Math.round(80.0f * f7)));
                    uut.line(drawContext, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f4 * 0.5f, ujt.withAlpha(ujt.lerp(n, -1, 0.5f), Math.round(200.0f * f7)));
                }
                this.rtk[0] = this.rtl[0];
                this.rtk[1] = this.rtl[1];
                bl = bl2;
            }
        }
    }

    private void ruf(DrawContext drawContext, usn usn2, rru rru2, double d, float f, int n, int n2) {
        GpuTextureView gpuTextureView = unm.view();
        float f2 = usn2.unitsPerBlock(rru2.x, d + 1.0, rru2.z);
        if (gpuTextureView == null || f2 <= 0.0f) {
            return;
        }
        int n3 = 14;
        for (int i = 0; i < n3; ++i) {
            float f3 = (float)Math.abs(Math.sin((double)i * 12.9898 + (double)rru2.seed) * 43758.5453) % 1.0f;
            float f4 = (float)i * 2.399f + rru2.seed;
            float f5 = (f3 + rru2.age * (0.25f + 0.2f * f3)) % 1.0f;
            double d2 = (0.35 + 0.4 * (double)f3) * (double)rru2.scale;
            double d3 = d - 0.3 + (double)f5 * 2.8 * (double)rru2.scale;
            if (!usn2.project(rru2.x + Math.cos(f4 + f5 * 2.0f) * d2, d3, rru2.z + Math.sin(f4 + f5 * 2.0f) * d2, this.rtk)) continue;
            float f6 = f * (float)Math.sin((double)f5 * Math.PI);
            float f7 = Math.min(10.0f, Math.max(2.0f, f2 * 0.07f));
            uut.sprite(drawContext, gpuTextureView, this.rtk[0], this.rtk[1], f7 * 3.0f, ujt.withAlpha(n, Math.round(70.0f * f6)));
            uut.sprite(drawContext, gpuTextureView, this.rtk[0], this.rtk[1], f7, ujt.withAlpha(ujt.lerp(n2, -1, 0.6f), Math.round(220.0f * f6)));
        }
    }

    static {
        rsr = new ConcurrentLinkedQueue<rrj>();
        rss = new HashMap<Integer, Long>();
        rtr = new float[][]{{0.1f, 0.28f}, {0.28f, 0.55f}, {0.5f, 0.78f}, {0.74f, 0.92f}, {0.98f, 0.96f}, {1.16f, 0.86f}, {1.1f, 0.66f}, {1.2f, 0.52f}, {1.06f, 0.4f}, {1.12f, 0.24f}, {0.94f, 0.16f}, {0.96f, -0.02f}, {0.78f, -0.02f}, {0.76f, -0.22f}, {0.58f, -0.16f}, {0.52f, -0.36f}, {0.36f, -0.22f}, {0.26f, -0.4f}, {0.12f, -0.14f}};
        rts = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
        rtt = new float[][]{{0.0f, -1.0f, 0.0f}, {0.0f, 1.0f, 0.0f}, {0.0f, 0.0f, -1.0f}, {0.0f, 0.0f, 1.0f}, {-1.0f, 0.0f, 0.0f}, {1.0f, 0.0f, 0.0f}};
    }

    private static /* synthetic */ int cbm(int n, int n2) {
        return n ^ n2 | 0xD9692193;
    }

    private static /* synthetic */ int cbn(int n, int n2) {
        return rrx.cbm(n, n2) + n;
    }

    private static /* synthetic */ int cbo(int n, int n2) {
        return rrx.cbn(n, n2) ^ 0x38FC9863;
    }
}

