/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockRenderType
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.PlantBlock
 *  net.minecraft.block.SugarCaneBlock
 *  net.minecraft.block.enums.CameraSubmersionType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.particle.ParticleManager
 *  net.minecraft.client.particle.ParticleRenderer
 *  net.minecraft.client.particle.RainSplashParticle
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.LightType
 *  net.minecraft.world.attribute.EnvironmentAttributeInterpolator
 *  net.minecraft.world.attribute.EnvironmentAttributes
 *  net.minecraft.world.dimension.DimensionType$Skybox
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package a;

import a.kfa;
import a.kfe;
import a.saw;
import a.sbh;
import a.sss;
import a.sti;
import a.stp;
import a.uhs;
import a.ujl;
import a.uxx;
import a.uze;
import a.vbb;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vss;
import com.mojang.blaze3d.buffers.Std140Builder;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.ParticleRenderer;
import net.minecraft.client.particle.RainSplashParticle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.LightType;
import net.minecraft.world.attribute.EnvironmentAttributeInterpolator;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.dimension.DimensionType;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class sbp
extends kfe {
    private static final int sbq = 32;
    private static final float sbr = (float)Math.PI / 180;
    private final vlv sbs = this.add(new vlv("Season", "Winter", "Winter", "Spring", "Summer", "Autumn", "Rain"));
    private final vmc sbt = this.add(new vmc("Rainfall", 0.7, 0.0, 1.0, 0.05).percent());
    private final vmc sbu = this.add(new vmc("Lightning", 0.5, 0.0, 1.0, 0.05).percent());
    private final vmc sbv = this.add(new vmc("Gloom", 0.6, 0.0, 1.0, 0.05).percent());
    private final vmc sbw = this.add(new vmc("Sounds", 0.8, 0.0, 1.0, 0.05).percent());
    private final vkl sbx = this.add(new vkl("Lens drops", true));
    private final vmc sby = this.add(new vmc("Particles", 0.6, 0.0, 1.0, 0.05).percent());
    private final vmc sbz = this.add(new vmc("Ground cover", 0.7, 0.0, 1.0, 0.05).percent());
    private final vmc sca = this.add(new vmc("Clouds", 0.9, 0.0, 1.0, 0.05).percent());
    private final vmc scb = this.add(new vmc("Speed", 1.0, 0.3, 2.0, 0.1).unit("x"));
    private final vkl scc = this.add(new vkl("Colour grade", true));
    private final vmc scd = this.add(new vmc("Cold", 0.7, 0.0, 1.0, 0.05).percent());
    private final vmc sce = this.add(new vmc("Cumulus", 0.5, 0.0, 1.0, 0.05).percent());
    private final vmc scf = this.add(new vmc("Sun rays", 0.7, 0.0, 1.0, 0.05).percent());
    private final vmc scg = this.add(new vmc("Light shafts", 0.6, 0.0, 1.0, 0.05).percent());
    private final vkl sch = this.add(new vkl("Cloud shadows", true));
    private final vmc sci = this.add(new vmc("Wetness", 0.7, 0.0, 1.0, 0.01).percent());
    private final vmc scj = this.add(new vmc("Puddles", 0.5, 0.0, 1.0, 0.01).percent());
    private final vmc sck = this.add(new vmc("Reflections", 1.0, 0.0, 1.0, 0.05).percent());
    private final vmc scl = this.add(new vmc("Darken", 0.55, 0.0, 1.0, 0.05).percent());
    private final vkl scm = this.add(new vkl("Footprints", true));
    private final vmc scn = this.add(new vmc("Footprint time", 20.0, 5.0, 60.0, 1.0).suffix("s"));
    private final vlv sco = this.add(new vlv("Quality", "Medium", "Low", "Medium", "High"));
    private final vkl scp = this.add(new vkl("Only under the sky", true));
    private final ArrayDeque<saw> scq = new ArrayDeque();
    private final Map<UUID, sbh> scr = new HashMap<UUID, sbh>();
    private final Set<UUID> scs = new HashSet<UUID>();
    private final List<saw> sct = new ArrayList<saw>();
    private final int[] scu = new int[16384];
    private final BlockPos.Mutable scv = new BlockPos.Mutable();
    private final Matrix4f scw = new Matrix4f();
    private final Matrix4f scx = new Matrix4f();
    private final Matrix4f scy = new Matrix4f();
    private final Quaternionf scz = new Quaternionf();
    private final Quaternionf sda = new Quaternionf();
    private Vec3d sdb;
    private boolean sdc;
    private double sdd;
    private double sde;
    private double sdf;
    private boolean sdg;
    private boolean sdh;
    private int sdi;
    private int sdj;
    private int sdk;
    private int sdl;
    private long sdm;
    private float sdn;
    private float sdo = -1.0f;
    private float sdp;
    private float sdq = 192.33f;
    private float sdr;
    private boolean sds;
    private double sdt;
    private double sdu;
    private double sdv;
    private double sdw;
    private double sdx;
    private double sdy;
    private double sdz;
    private double sea;
    private double seb;
    private static sbp sec;
    private final stp sed = new stp();
    private final sss see = new sss();
    private final int[] sef = new int[16384];
    private boolean seg;
    private boolean seh;
    private int sei;
    private boolean sej;
    private boolean sek;
    private double sel;
    private double sem;
    private double sen;
    private double seo;
    private double sep;
    private float seq = -1.0f;
    private float ser = -1.0f;
    private final float[] ses = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    private double set;
    private double seu;
    private boolean sev;
    private final List<Field> sew = new ArrayList<Field>();
    private boolean sex;
    private final float[] sey = new float[320];
    private final float[] sez = new float[320];
    private final Vector3f sfa = new Vector3f();
    private static /* synthetic */ String sfb;
    private static /* synthetic */ boolean sfc;

    public sbp() {
        super(new String(new char[]{'W', 'e', 'a', 't', 'h', 'e', 'r'}), "Seasons and weather effects", kfa.RENDER);
        sec = this;
        for (vmc vmo2 : List.of(this.sby, this.scb)) {
            vmo2.visibleWhen(() -> !this.sfd());
        }
        this.sbz.visibleWhen(() -> !this.sfd() && !this.sbs.is("Summer"));
        this.sca.visibleWhen(() -> this.sbs.is("Winter") || this.sfd());
        this.scd.visibleWhen(() -> this.sbs.is("Winter") && this.scc.get());
        for (vmo vmo2 : List.of(this.sce, this.scf, this.scg, this.sch)) {
            vmo2.visibleWhen(() -> this.sbs.is("Summer"));
        }
        for (vmo vmo3 : List.of(this.sbt, this.sbu, this.sbv, this.sbw, this.sbx, this.sci, this.scj, this.sck, this.scl)) {
            vmo3.visibleWhen(this::sfd);
        }
        this.scm.visibleWhen(this::sfe);
        this.sco.visibleWhen(() -> this.sfd() || this.sbs.is("Summer"));
        this.scn.visibleWhen(() -> this.sfe() && this.scm.get());
    }

    private boolean sfd() {
        return this.sbs.is("Rain");
    }

    private boolean sfe() {
        return this.sfd() || this.sbs.is("Winter");
    }

    @Override
    protected void onEnable() {
        this.sdg = false;
        this.sdl = 0;
        this.sdm = 0L;
        this.sdo = -1.0f;
        this.sdb = null;
        this.scq.clear();
        this.scr.clear();
        this.sed.reset();
        this.see.clear();
        this.seq = -1.0f;
        this.ser = -1.0f;
    }

    @Override
    protected void onDisable() {
        ujl.hide(this, false);
        vbb.release();
        uze.release();
        uxx.release();
        this.sdc = false;
        this.seg = false;
        this.seh = false;
        this.sek = false;
        this.sdb = null;
        this.scq.clear();
        this.scr.clear();
        this.see.clear();
        this.sed.reset();
        this.sev = false;
    }

    public static void hud(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        sbp sbp2 = sec;
        if (sbp2 != null && sbp2.isEnabled() && sbp2.seh && sbp2.sek) {
            uxx.drops();
        }
    }

    private void sff(MinecraftClient minecraftClient) {
        minecraftClient.method_1483().method_4875(SoundEvents.field_14946.comp_3319(), SoundCategory.field_15252);
        minecraftClient.method_1483().method_4875(SoundEvents.field_15020.comp_3319(), SoundCategory.field_15252);
        if (this.sex) {
            return;
        }
        try {
            if (this.sew.isEmpty()) {
                for (Field object : ParticleManager.class.getDeclaredFields()) {
                    if (!Map.class.isAssignableFrom(object.getType())) continue;
                    object.setAccessible(true);
                    this.sew.add(object);
                }
            }
            for (Field field : this.sew) {
                Object object2 = field.get(minecraftClient.field_1713);
                if (!(object2 instanceof Map)) continue;
                Map map = (Map)object2;
                for (Object v : map.values()) {
                    if (!(v instanceof ParticleRenderer)) continue;
                    ParticleRenderer particleRenderer = (ParticleRenderer)v;
                    particleRenderer.method_74290().removeIf(particle -> particle.getClass() == RainSplashParticle.class);
                }
            }
        }
        catch (Throwable throwable) {
            this.sex = true;
            System.out.println("can't hide vanilla rain splashes: " + throwable);
        }
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        sbp sbp2 = sec;
        if (sbp2 == null || !sbp2.isEnabled() || !sbp2.sev || worldRenderState == null) {
            return;
        }
        worldRenderState.field_63085.field_63101.clear();
        worldRenderState.field_63085.field_63102.clear();
        worldRenderState.field_63085.field_63103 = 0.0f;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ++this.sdl;
        ClientWorld clientWorld = minecraftClient.field_1687;
        if (clientWorld == null || minecraftClient.field_1724 == null) {
            return;
        }
        if (this.sev && clientWorld.method_8430(1.0f) > 0.0f) {
            this.sff(minecraftClient);
        }
        long l = System.nanoTime();
        long l2 = (long)(this.scn.get() * 1.0E9);
        while (!this.scq.isEmpty() && l - this.scq.peekFirst().sbd > l2) {
            this.scq.pollFirst();
        }
        if (!this.sfe() || !this.scm.get()) {
            this.scq.clear();
            this.scr.clear();
            return;
        }
        this.scs.clear();
        for (PlayerEntity playerEntity : clientWorld.method_18456()) {
            if (playerEntity.method_7325() || playerEntity.method_5858((Entity)minecraftClient.field_1724) > 2304.0) continue;
            this.scs.add(playerEntity.method_5667());
            this.sfg(playerEntity, l, playerEntity == minecraftClient.field_1724 ? 1.0f : 0.8f);
        }
        this.scr.keySet().removeIf(uUID -> !this.scs.contains(uUID));
    }

    private void sfg(PlayerEntity playerEntity, long l, float f) {
        sbh sbh2 = this.scr.computeIfAbsent(playerEntity.method_5667(), uUID -> new sbh());
        double d = playerEntity.method_23317();
        double d2 = playerEntity.method_23321();
        boolean bl = playerEntity.method_24828();
        if (!sbh2.sbi) {
            sbh2.sbi = true;
            sbh2.sbk = d;
            sbh2.sbl = d2;
            sbh2.sbj = bl;
            return;
        }
        double d3 = d - sbh2.sbk;
        double d4 = d2 - sbh2.sbl;
        double d5 = Math.sqrt(d3 * d3 + d4 * d4);
        if (d5 > 6.0) {
            sbh2.sbk = d;
            sbh2.sbl = d2;
            sbh2.sbj = bl;
            return;
        }
        if (bl && !sbh2.sbj) {
            float f2 = playerEntity.method_36454() * ((float)Math.PI / 180);
            float f3 = (float)(-Math.sin(f2));
            float f4 = (float)Math.cos(f2);
            this.sfh(d, playerEntity.method_23318(), d2, f3, f4, 1.0f, l, f);
            this.sfh(d, playerEntity.method_23318(), d2, f3, f4, -1.0f, l, f);
            sbh2.sbk = d;
            sbh2.sbl = d2;
        } else if (bl) {
            double d6;
            double d7 = playerEntity.method_5715() ? 0.42 : (d6 = playerEntity.method_5624() ? 0.85 : 0.62);
            if (d5 >= d6) {
                float f5 = (float)(d3 / d5);
                float f6 = (float)(d4 / d5);
                sbh2.sbm = -sbh2.sbm;
                this.sfh(d, playerEntity.method_23318(), d2, f5, f6, sbh2.sbm, l, f);
                sbh2.sbk = d;
                sbh2.sbl = d2;
            }
        } else {
            sbh2.sbk = d;
            sbh2.sbl = d2;
        }
        sbh2.sbj = bl;
    }

    private void sfh(double d, double d2, double d3, float f, float f2, float f3, long l, float f4) {
        double d4 = (double)(-f2 * f3) * 0.14;
        double d5 = (double)(f * f3) * 0.14;
        this.scq.addLast(new saw(d + d4, d2, d3 + d5, f, f2, f3, l, f4));
        while (this.scq.size() > 32) {
            this.scq.pollFirst();
        }
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Object object;
        float f6;
        this.seh = false;
        this.sek = false;
        this.sei = 0;
        this.sej = false;
        ClientWorld clientWorld = minecraftClient.field_1687;
        Camera camera = minecraftClient.field_1773.method_19418();
        this.sds = clientWorld != null && clientWorld.method_8597().comp_5220() == DimensionType.Skybox.field_64386;
        this.sev = false;
        vbb.wantEntityMask(!this.sfd() || this.sds);
        boolean bl = this.sds && this.sbs.is("Summer");
        ujl.hide(this, this.sds && (this.sbs.is("Winter") && this.sca.get() > 0.01 || bl && this.sce.get() > 0.01 || this.sfd()));
        if (!bl && this.sdc) {
            uze.release();
            this.sdc = false;
            this.sdb = null;
        }
        if (!this.sfd() && this.seg) {
            uxx.release();
            this.seg = false;
            this.see.clear();
            this.sed.reset();
        }
        if (clientWorld == null || minecraftClient.field_1724 == null || !camera.method_19332() || camera.method_19334() != CameraSubmersionType.field_27888) {
            this.sdm = 0L;
            this.sdb = null;
            return;
        }
        long l = System.nanoTime();
        float f7 = this.sdm == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.sdm) / 1.0E9f);
        this.sdm = l;
        this.sdn = (this.sdn + f7) % 3600.0f;
        this.sdp = f7;
        this.sdt += (double)f7;
        float f8 = minecraftClient.method_61966().method_60637(false);
        Vec3d vec3d = camera.method_71156();
        int n = (int)Math.floor(vec3d.field_1352);
        int n2 = (int)Math.floor(vec3d.field_1351);
        int n3 = (int)Math.floor(vec3d.field_1350);
        int n4 = 64;
        if (!this.sdg || Math.abs(n - (this.sdj + n4)) > 24 || Math.abs(n3 - (this.sdk + n4)) > 24 || this.sdl >= 40) {
            this.sfs(clientWorld, n - n4, n3 - n4);
        }
        this.scw.rotation((Quaternionfc)camera.method_23767());
        EnvironmentAttributeInterpolator environmentAttributeInterpolator = camera.method_75756();
        this.sdr = f6 = clientWorld.method_8430(f8);
        if (this.sds) {
            object = (Float)environmentAttributeInterpolator.method_75689(EnvironmentAttributes.field_63748, f8);
            this.sdq = object == null || ((Float)object).isNaN() ? 192.33f : ((Float)object).floatValue();
        }
        object = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
        float[] fArray = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArray2 = new float[]{0.5f, 0.65f, 0.9f};
        if (this.sds) {
            f5 = Math.max(0.0f, 1.0f - 0.85f * f6);
            f4 = ((Float)environmentAttributeInterpolator.method_75689(EnvironmentAttributes.field_64340, f8)).floatValue() * ((float)Math.PI / 180);
            f3 = ((Float)environmentAttributeInterpolator.method_75689(EnvironmentAttributes.field_64341, f8)).floatValue() * ((float)Math.PI / 180);
            f2 = (float)Math.cos(f4);
            f = (float)Math.cos(f3);
            if (f2 > -0.05f) {
                float f9 = sbp.sfy(0.0f, 0.4f, f2);
                object = new float[]{(float)(-Math.sin(f4)), f2, 0.0f, sbp.sfy(-0.05f, 0.12f, f2) * f5};
                fArray = new float[]{1.0f, 0.62f + 0.35f * f9, 0.38f + 0.52f * f9};
            } else {
                object = new float[]{(float)(-Math.sin(f3)), f, 0.0f, sbp.sfy(-0.05f, 0.15f, f) * f5 * 0.35f};
                fArray = new float[]{0.6f, 0.7f, 1.0f};
            }
            int n5 = (Integer)environmentAttributeInterpolator.method_75689(EnvironmentAttributes.field_63746, f8);
            fArray2 = new float[]{(float)(n5 >> 16 & 0xFF) / 255.0f, (float)(n5 >> 8 & 0xFF) / 255.0f, (float)(n5 & 0xFF) / 255.0f};
        }
        f5 = this.sds ? uhs.daylight(minecraftClient) : 0.6f;
        f4 = uhs.boost(minecraftClient);
        f3 = uhs.light(minecraftClient);
        f2 = (float)clientWorld.method_8314(LightType.field_9284, camera.method_19328()) / 15.0f;
        this.sdo = this.sdo < 0.0f ? f2 : this.sdo + (f2 - this.sdo) * Math.min(1.0f, f7 * 2.0f);
        f = Math.min((float)minecraftClient.field_1690.method_38521() * 16.0f, 200.0f);
        if (this.sfd()) {
            this.sfk(minecraftClient, clientWorld, camera, vec3d, n, n2, n3, l, f7, (float[])object, fArray, f4, f5, f);
        } else {
            this.sfj(minecraftClient, vec3d, n, n2, n3, l, (float[])object, fArray, fArray2, f3, f5, f4, f);
        }
        if (bl) {
            this.sfi(camera, vec3d, n, n2, n3, f7, (float[])object, fArray, fArray2, f5, f4, f6);
        }
    }

    private void sfi(Camera camera, Vec3d vec3d, int n, int n2, int n3, float f, float[] fArray, float[] fArray2, float[] fArray3, float f2, float f3, float f4) {
        float f5;
        int n4;
        int n5;
        int n6;
        int n7;
        float f6;
        float f7;
        boolean bl;
        this.sdc = true;
        float f8 = (float)this.scb.get();
        double d = 0.88;
        double d2 = 0.47;
        double d3 = 3.2 * (double)f8 * (double)f;
        this.sdd = (this.sdd + d * d3) % 65536.0;
        this.sde = (this.sde + d2 * d3) % 65536.0;
        this.sdf = (this.sdf + 0.012 * (double)f8 * (double)f) % 64.0;
        boolean bl2 = bl = this.sdb != null && this.sdb.method_1025(vec3d) < 64.0;
        if (this.sdb == null) {
            this.sda.set((Quaternionfc)camera.method_23767());
            this.sdb = vec3d;
        }
        this.scy.rotation((Quaternionfc)this.sda.conjugate(new Quaternionf()));
        float f9 = (float)(vec3d.field_1352 - this.sdb.field_1352);
        float f10 = (float)(vec3d.field_1351 - this.sdb.field_1351);
        float f11 = (float)(vec3d.field_1350 - this.sdb.field_1350);
        this.sda.set((Quaternionfc)camera.method_23767());
        this.sdb = vec3d;
        float f12 = switch (this.sco.get()) {
            case "Low" -> {
                f7 = 0.34f;
                f6 = 0.03f;
                n7 = 40;
                n6 = 4;
                n5 = 10;
                n4 = 24;
                f5 = 96.0f;
                yield 1200.0f;
            }
            case "High" -> {
                f7 = 0.5f;
                f6 = 0.015f;
                n7 = 80;
                n6 = 6;
                n5 = 20;
                n4 = 48;
                f5 = 160.0f;
                yield 3000.0f;
            }
            default -> {
                f7 = 0.42f;
                f6 = 0.022f;
                n7 = 48;
                n6 = 5;
                n5 = 12;
                n4 = 28;
                f5 = 128.0f;
                yield 2000.0f;
            }
        };
        float f13 = this.sdq;
        float f14 = (float)this.sce.get() * 0.85f;
        float f15 = sbp.sfw(vec3d.field_1352 - this.sdd, 8192.0);
        float f16 = sbp.sfw(vec3d.field_1350 - this.sde, 8192.0);
        float f17 = (float)(d * d3);
        float f18 = (float)(d2 * d3);
        boolean bl3 = fArray2[2] > fArray2[0];
        float f19 = (float)this.scg.get();
        float f20 = (float)this.scf.get();
        float f21 = this.sch.get() ? 0.38f : 0.0f;
        boolean bl4 = this.sdg;
        int n8 = this.sdj - n;
        int n9 = this.sdk - n3;
        float[] fArray4 = fArray;
        float[] fArray5 = fArray2;
        float[] fArray6 = fArray3;
        float f22 = f4;
        uze.draw(f7, f6, bl, (float)this.sdf, f2, std140Builder -> {
            std140Builder.putMat4f((Matrix4fc)this.scw);
            std140Builder.putMat4f((Matrix4fc)this.scy);
            std140Builder.putVec4(f9, f10, f11, 0.0f);
            std140Builder.putVec4(f15, (float)vec3d.field_1351, f16, f22);
            std140Builder.putVec4(fArray4[0], fArray4[1], fArray4[2], fArray4[3]);
            std140Builder.putVec4(fArray5[0], fArray5[1], fArray5[2], bl3 ? 1.0f : 0.0f);
            std140Builder.putVec4(fArray6[0], fArray6[1], fArray6[2], f3);
            std140Builder.putVec4(f13, f13 + 150.0f, f14, 1.5f + 0.5f * f22);
            std140Builder.putVec4(f17, f18, (float)d, (float)d2);
            std140Builder.putVec4(f19 * (1.0f - 0.6f * f22), f5, 0.0016f, f20 * (1.0f - 0.7f * f22));
            std140Builder.putVec4(f21, 7000.0f, f12, 0.0f);
            std140Builder.putVec4((float)n8, (float)n9, 128.0f, bl4 ? 1.0f : 0.0f);
            std140Builder.putVec4((float)(vec3d.field_1352 - (double)n), (float)(vec3d.field_1351 - (double)n2), (float)(vec3d.field_1350 - (double)n3), (float)n2);
            std140Builder.putVec4((float)n7, (float)n6, (float)n5, (float)n4);
        });
    }

    private void sfj(MinecraftClient minecraftClient, Vec3d vec3d, int n, int n2, int n3, long l, float[] fArray, float[] fArray2, float[] fArray3, float f, float f2, float f3, float f4) {
        float f5;
        boolean bl;
        int[] nArray;
        float f6;
        int n4 = this.sbs.index();
        float f7 = 1.0f - sbp.sfy(0.25f, 0.6f, f2);
        float f8 = switch (n4) {
            case 1 -> {
                f6 = 0.55f + 0.25f * (float)Math.sin(this.sdt * 0.35);
                yield 0.3f;
            }
            case 2 -> {
                f6 = 0.08f;
                yield 0.05f;
            }
            case 3 -> {
                f6 = 0.35f + 0.2f * (float)Math.sin(this.sdt * 0.27);
                yield 0.18f;
            }
            default -> {
                float var19_18 = 1.0f + 0.45f * (float)Math.sin(this.sdt * 0.23) + 0.25f * (float)Math.sin(this.sdt * 0.61 + 1.3);
                f6 = 0.34f * var19_18;
                yield 0.14f * var19_18;
            }
        };
        boolean bl2 = this.sdg;
        int n5 = this.sdj - n;
        int n6 = this.sdk - n3;
        float f9 = (float)this.sby.get();
        float f10 = (float)this.sbz.get();
        float f11 = (float)this.scb.get();
        boolean bl3 = this.scc.get();
        boolean bl4 = this.scp.get();
        float f12 = f6 * f11;
        float f13 = f8 * f11;
        this.sdu = (this.sdu + (double)(f12 * this.sdp)) % 65536.0;
        this.sdv = (this.sdv + (double)(f13 * this.sdp)) % 65536.0;
        double d = Math.max(1.0E-4, Math.hypot(f6, f8));
        double d2 = (double)f6 / d;
        double d3 = (double)f8 / d;
        double d4 = 2.2 * (0.5 + 0.5 * (double)f11) * (double)this.sdp;
        this.sdw += d2 * d4;
        this.sdx += d3 * d4;
        this.sdy += (d2 * 0.94 - d3 * 0.34) * d4 * 2.4;
        this.sdz += (d3 * 0.94 + d2 * 0.34) * d4 * 2.4;
        float f14 = n4 == 0 && this.sds ? (float)this.sca.get() : 0.0f;
        float f15 = n4 == 0 && bl3 ? (float)this.scd.get() : 0.0f;
        float f16 = Math.max(this.sdq - (float)vec3d.field_1351, 40.0f);
        float f17 = !this.sds ? -1.0f : (0.0012f + 0.0068f * f9) * (0.55f + 0.45f * f14) * (1.0f + 0.5f * this.sdr);
        float f18 = sbp.sfw((vec3d.field_1352 - this.sdw) / 80.0, 256.0);
        float f19 = sbp.sfw((vec3d.field_1350 - this.sdx) / 80.0, 256.0);
        float f20 = sbp.sfw((vec3d.field_1352 - this.sdw) / 640.0, 256.0);
        float f21 = sbp.sfw((vec3d.field_1350 - this.sdx) / 640.0, 256.0);
        float f22 = sbp.sfw((vec3d.field_1352 - this.sdy) / 28.0, 256.0);
        float f23 = sbp.sfw((vec3d.field_1350 - this.sdz) / 28.0, 256.0);
        this.sea = (this.sea + 0.55 * (double)f11 * (double)this.sdp) % 256.0;
        this.seb = (this.seb + 0.9 * (double)f11 * (double)this.sdp) % 256.0;
        float f24 = (float)this.sea;
        float f25 = (float)this.seb;
        float f26 = sbp.sfw(this.sdt * 0.035, Math.PI * 2);
        float f27 = sbp.sfw(this.sdt * 0.052, Math.PI * 2);
        switch (n4) {
            case 0: {
                int[] nArray2 = new int[2];
                nArray2[0] = 28000;
                nArray = nArray2;
                nArray2[1] = 30000;
                break;
            }
            case 1: {
                int[] nArray3 = new int[2];
                nArray3[0] = 1600;
                nArray = nArray3;
                nArray3[1] = 2600;
                break;
            }
            case 2: {
                int[] nArray4 = new int[2];
                nArray4[0] = 700;
                nArray = nArray4;
                nArray4[1] = 1100;
                break;
            }
            default: {
                int[] nArray5 = new int[2];
                nArray5[0] = 1300;
                nArray = nArray5;
                nArray5[1] = 2100;
            }
        }
        int[] nArray6 = nArray;
        int n7 = Math.round((float)nArray6[0] * f9);
        int n8 = Math.round((float)nArray6[1] * f9);
        this.scx.rotation((Quaternionfc)minecraftClient.field_1773.method_19418().method_23767().conjugate(this.scz));
        this.sct.clear();
        if (n4 == 0) {
            this.sct.addAll(this.scq);
        }
        this.sdi = (bl = vbb.drawSeason(arg_0 -> this.lambda$drawSeason$11(n, n2, n3, vec3d, n4, f9, f10, bl3, f11, f, f2, f7, fArray, fArray2, f3, n5, n6, bl2, f5 = (float)this.scn.get(), f4, fArray3, bl4, n7, n8, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f12, f13, f26, f27, l, arg_0))) ? n7 + n8 : 0;
        this.sdh = bl && f15 > 0.0f;
    }

    @Override
    public void onWorldRenderLate(MinecraftClient minecraftClient) {
        if (this.sdi > 0) {
            vbb.drawParticles(this.sdi);
            this.sdi = 0;
        }
        if (this.sei > 0 && this.seh) {
            uxx.rain(this.sei);
            this.sei = 0;
        }
    }

    @Override
    public void onWorldRenderFinal(MinecraftClient minecraftClient) {
        if (this.sdh) {
            vbb.gradeSeason();
            this.sdh = false;
        }
        if (this.sej && this.seh) {
            uxx.grade();
            this.sej = false;
        }
    }

    private void sfk(MinecraftClient minecraftClient, ClientWorld clientWorld, Camera camera, Vec3d vec3d, int n, int n2, int n3, long l, float f, float[] fArray, float[] fArray2, float f2, float f3, float f4) {
        sti sti2;
        float f5;
        if (!this.sds) {
            return;
        }
        this.seg = true;
        float f6 = (float)this.sbt.get();
        float f7 = (float)this.sca.get();
        float f8 = (float)this.sbv.get();
        int n4 = this.sco.index();
        float f9 = this.seq = this.seq < 0.0f ? f3 : this.seq + (f3 - this.seq) * Math.min(1.0f, f * 0.7f);
        float f10 = 1.0f - sbp.sfy(0.2f, 0.7f, f9);
        float f11 = this.sfq(vec3d);
        this.ser = this.ser < 0.0f ? f11 : this.ser + (f11 - this.ser) * Math.min(1.0f, f * 4.0f);
        double d = 0.55 + 0.35 * Math.sin(this.sdt * 0.011);
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        double d4 = (4.0 + 5.0 * (double)f7) * (double)f;
        this.sel = (this.sel + d2 * d4) % 491520.0;
        this.sem = (this.sem + d3 * d4) % 491520.0;
        this.sen = (this.sen + d2 * d4 * 2.4) % 1000000.0;
        this.seo = (this.seo + d3 * d4 * 2.4) % 1000000.0;
        float f12 = Math.max(80.0f, Math.min(600.0f, this.sdq - (float)vec3d.field_1351 + 60.0f));
        float f13 = sbp.sfw((vec3d.field_1352 - this.sel) / 240.0, 2048.0);
        float f14 = sbp.sfw((vec3d.field_1350 - this.sem) / 240.0, 2048.0);
        float f15 = sbp.sfw((vec3d.field_1352 - this.sen) * 0.0042307692307692315, 256.0);
        float f16 = sbp.sfw((vec3d.field_1350 - this.seo) * 0.0042307692307692315, 256.0);
        float f17 = 1.0f + 0.35f * (float)Math.sin(this.sdt * 0.31) + 0.2f * (float)Math.sin(this.sdt * 0.83 + 1.1);
        float f18 = (1.0f + 1.4f * f17) * (0.4f + 0.6f * f6);
        float f19 = (float)d2 * f18;
        float f20 = (float)d3 * f18;
        float f21 = 8.5f;
        float f22 = minecraftClient.method_1493() ? 0.0f : f;
        this.sep = (this.sep + (double)(f21 * f22)) % 54912.0;
        this.set = (this.set + (double)(f19 * f22)) % 6864.0;
        this.seu = (this.seu + (double)(f20 * f22)) % 6864.0;
        float f23 = sbp.sfw(this.set, 6864.0);
        float f24 = sbp.sfw(this.seu, 6864.0);
        float f25 = sbp.sfw(vec3d.field_1352, 6864.0);
        float f26 = sbp.sfw(vec3d.field_1350, 6864.0);
        this.sed.update(f22, (float)this.sbu.get() * (0.35f + 0.65f * f7), vec3d, f12, Math.min((double)clientWorld.method_8615(), vec3d.field_1351 - 40.0));
        boolean bl = (Boolean)minecraftClient.field_1690.method_41784().method_41753();
        float f27 = this.sed.brightness() * (bl ? 0.15f : 1.0f);
        float f28 = Math.max(1.0f, this.sed.distance());
        float f29 = f27 * sbp.sfx(1.25f - f28 / 2600.0f, 0.25f, 1.0f) * 0.5f * (0.1f + 0.9f * this.ser);
        float f30 = this.sed.boltBrightness() * (bl ? 0.4f : 1.6f);
        float f31 = f27 * sbp.sfx(1.3f - f28 / 2000.0f, 0.15f, 1.0f) * (0.2f + 0.8f * f10) * 0.7f;
        float f32 = minecraftClient.field_1773.method_32796();
        float f33 = this.sfm(vec3d);
        float f34 = Math.min(1.0f, f32 * 0.8f / Math.max(1.0f, f33));
        if (!bl && f27 > 0.5f && f28 < 1500.0f) {
            clientWorld.method_8509(1);
        }
        float f35 = minecraftClient.field_1690.method_71978(SoundCategory.field_15250) * minecraftClient.field_1690.method_71978(SoundCategory.field_15252);
        float f36 = f5 = minecraftClient.method_1493() ? 0.0f : (float)this.sbw.get() * f35;
        while ((sti2 = this.sed.nextThunder()) != null) {
            this.sfo(camera, vec3d, sti2, f5);
        }
        float f37 = this.ser + (1.0f - this.ser) * 0.7f * Math.max(this.sdo, 0.0f);
        float f38 = sbp.sfy(0.35f, 1.0f, f6);
        vss.listener(camera.method_19330());
        vss.rain(f5 * f37 * f38 * 0.9f, f5 * f37 * Math.min(1.0f, f6 * 2.2f) * (1.0f - 0.55f * f38) * 1.5f, 1.0f - this.ser, this.sfp(vec3d));
        float f39 = sbp.sfx((-camera.method_19329() + 15.0f) / 55.0f, 0.0f, 1.0f);
        this.see.update(f22, this.sbx.get() ? f6 * this.ser * f39 * 2.6f : 0.0f, 1.0f - this.ser);
        float f40 = n4 == 0 ? 0.45f : (n4 == 1 ? 0.75f : 1.0f);
        int n5 = Math.round(10000.0f * f6 * f40);
        int n6 = Math.round(8000.0f * f6 * f40);
        int n7 = Math.round(1400.0f * f6 * f40);
        int n8 = n4 == 0 ? 16 : (n4 == 1 ? 28 : 40);
        boolean bl2 = fArray2[2] > fArray2[0];
        float f41 = bl2 ? 0.12f : 0.38f;
        float f42 = sbp.sfy(-0.05f, 0.12f, fArray[1]) * f41 * (1.0f - 0.5f * f7);
        float f43 = sbp.sfy(-0.12f, 0.05f, fArray[1]) * (1.0f - sbp.sfy(0.25f, 0.5f, fArray[1])) * (1.1f - 0.4f * f7) * (bl2 ? 0.15f : 1.0f);
        float f44 = (0.0018f + 0.0045f * f6) * (0.7f + 0.6f * f8);
        float f45 = 1.0f - f9;
        float f46 = (0.07f + 0.36f * f2) * (0.4f + 0.6f * f45);
        float f47 = (0.09f + 0.42f * f2) * (0.4f + 0.6f * f45);
        float f48 = (0.15f + 0.5f * f2) * (0.4f + 0.6f * f45);
        boolean bl3 = vbb.entityMask();
        boolean bl4 = this.scc.get();
        float f49 = bl4 ? 0.55f + 0.45f * f8 : 0.0f;
        boolean bl5 = this.sbx.get() && this.see.any();
        this.scx.rotation((Quaternionfc)camera.method_23767().conjugate(this.scz));
        this.sct.clear();
        this.sct.addAll(this.scq);
        float f50 = (float)this.scn.get();
        boolean bl6 = this.scp.get();
        boolean bl7 = this.sdg;
        int n9 = this.sdj - n;
        int n10 = this.sdk - n3;
        float f51 = (float)(this.sed.x() - vec3d.field_1352);
        float f52 = (float)(this.sed.y() - vec3d.field_1351);
        float f53 = (float)(this.sed.z() - vec3d.field_1350);
        int n11 = this.sed.segments();
        float[] fArray3 = this.sed.segA();
        float[] fArray4 = this.sed.segB();
        float[] fArray5 = this.sfl(fArray3, n11, f51, f52, f53);
        float[] fArray6 = this.sfl(fArray4, n11, f51, f52, f53);
        float f54 = bl3 ? 1.0f : 0.0f;
        float f55 = 30.0f * (float)minecraftClient.method_1522().field_1481 / 1080.0f;
        float f56 = this.ser;
        float f57 = this.sdn;
        boolean bl8 = uxx.upload(std140Builder -> {
            int n12;
            std140Builder.putMat4f((Matrix4fc)this.scw);
            std140Builder.putMat4f((Matrix4fc)this.scx);
            std140Builder.putVec4((float)Math.floorMod(n, 4096), (float)n2, (float)Math.floorMod(n3, 4096), f57);
            std140Builder.putVec4((float)(vec3d.field_1352 - (double)n), (float)(vec3d.field_1351 - (double)n2), (float)(vec3d.field_1350 - (double)n3), f6);
            std140Builder.putVec4(fArray[0], fArray[1], fArray[2], f42);
            std140Builder.putVec4(fArray2[0], fArray2[1], fArray2[2], f43);
            std140Builder.putVec4(f9, f2, f56, f54);
            std140Builder.putVec4(f12, f7, f8, f44);
            std140Builder.putVec4(f13, f14, f15, f16);
            std140Builder.putVec4((float)this.sep, f21, f19, f20);
            std140Builder.putVec4(f51, f52, f53, f27);
            std140Builder.putVec4(f29, f30, f31, f34);
            std140Builder.putVec4((float)n9, (float)n10, 128.0f, bl7 ? 1.0f : 0.0f);
            std140Builder.putVec4((float)this.sci.get(), (float)this.scj.get(), (float)this.sck.get(), (float)this.scl.get());
            std140Builder.putVec4((float)n5, (float)n6, (float)n7, (float)n4);
            std140Builder.putVec4(bl4 ? 1.0f : 0.0f, f49, bl5 ? 16.0f : 0.0f, bl4 ? 0.18f + 0.14f * f8 : 0.0f);
            std140Builder.putVec4((float)this.sct.size(), f50, f4, bl6 ? 1.0f : 0.0f);
            std140Builder.putVec4(f46, f47, f48, (float)n8);
            std140Builder.putVec4(f23, f25, f24, f26);
            std140Builder.putVec4((float)n11, f55, 0.0f, 0.0f);
            this.sfr((Std140Builder)std140Builder, this.sct, vec3d, l);
            for (n12 = 0; n12 < 80; ++n12) {
                if (n12 < n11) {
                    std140Builder.putVec4(fArray5[n12 * 4], fArray5[n12 * 4 + 1], fArray5[n12 * 4 + 2], fArray3[n12 * 4 + 3]);
                    continue;
                }
                std140Builder.putVec4(0.0f, 0.0f, 0.0f, 0.0f);
            }
            for (n12 = 0; n12 < 80; ++n12) {
                if (n12 < n11) {
                    std140Builder.putVec4(fArray6[n12 * 4], fArray6[n12 * 4 + 1], fArray6[n12 * 4 + 2], fArray4[n12 * 4 + 3]);
                    continue;
                }
                std140Builder.putVec4(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.see.write((Std140Builder)std140Builder);
        });
        if (!bl8) {
            return;
        }
        this.seh = true;
        this.sev = true;
        uxx.sky(n11);
        uxx.wet(bl3);
        this.sei = n5 + n6 + n7;
        this.sej = bl4 || f29 > 0.005f;
        this.sek = bl5;
    }

    public void testStrike(float f, boolean bl, double d, double d2) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        Vec3d vec3d = minecraftClient.field_1773.method_19418().method_71156();
        float f2 = Math.max(80.0f, Math.min(600.0f, this.sdq - (float)vec3d.field_1351 + 60.0f));
        this.sed.strike(vec3d, f2, Math.min((double)minecraftClient.field_1687.method_8615(), vec3d.field_1351 - 40.0), f, bl, d);
        this.sed.freeze(d2);
    }

    private float[] sfl(float[] fArray, int n, float f, float f2, float f3) {
        float[] fArray2 = fArray == this.sed.segA() ? this.sey : this.sez;
        for (int i = 0; i < n; ++i) {
            this.sfa.set(f + fArray[i * 4], f2 + fArray[i * 4 + 1], f3 + fArray[i * 4 + 2]);
            this.scx.transformDirection(this.sfa);
            fArray2[i * 4] = this.sfa.x;
            fArray2[i * 4 + 1] = this.sfa.y;
            fArray2[i * 4 + 2] = this.sfa.z;
        }
        return fArray2;
    }

    private float sfm(Vec3d vec3d) {
        float f = Math.max(1.0f, this.sed.distance());
        int n = this.sed.segments();
        if (n == 0) {
            return f;
        }
        float[] fArray = this.sed.segA();
        float[] fArray2 = this.sed.segB();
        double d = this.sed.x() - vec3d.field_1352;
        double d2 = this.sed.y() - vec3d.field_1351;
        double d3 = this.sed.z() - vec3d.field_1350;
        for (int i = 0; i < n; ++i) {
            f = Math.max(f, (float)Math.sqrt(sbp.sfn(d + (double)fArray[i * 4]) + sbp.sfn(d2 + (double)fArray[i * 4 + 1]) + sbp.sfn(d3 + (double)fArray[i * 4 + 2])));
            f = Math.max(f, (float)Math.sqrt(sbp.sfn(d + (double)fArray2[i * 4]) + sbp.sfn(d2 + (double)fArray2[i * 4 + 1]) + sbp.sfn(d3 + (double)fArray2[i * 4 + 2])));
        }
        return f;
    }

    private static double sfn(double d) {
        return d * d;
    }

    private void sfo(Camera camera, Vec3d vec3d, sti sti2, float f) {
        vss.listener(camera.method_19330());
        vss.thunder(sti2.distance(), sti2.bolt(), (float)(sti2.x() - vec3d.field_1352), (float)(sti2.z() - vec3d.field_1350), f);
    }

    private float[] sfp(Vec3d vec3d) {
        float[] fArray = this.ses;
        if (!this.sdg) {
            Arrays.fill(fArray, 1.0f);
            return fArray;
        }
        int n = 128;
        double d = vec3d.field_1351 + 0.6;
        double d2 = vec3d.field_1351 + 2.0;
        for (int i = 0; i < 4; ++i) {
            double d3 = i == 0 || i == 3 ? 0.7071 : -0.7071;
            double d4 = i < 2 ? 0.7071 : -0.7071;
            float f = 0.0f;
            float f2 = 0.0f;
            for (int j = -1; j <= 1; ++j) {
                double d5 = (double)j * 0.45;
                double d6 = d3 * Math.cos(d5) - d4 * Math.sin(d5);
                double d7 = d3 * Math.sin(d5) + d4 * Math.cos(d5);
                float f3 = 1.0f;
                for (int k = 1; k <= 8; ++k) {
                    float f4 = 1.0f / (1.0f + 0.2f * (float)k);
                    f2 += f4;
                    int n2 = (int)Math.floor(vec3d.field_1352 + d6 * (double)k) - this.sdj;
                    int n3 = (int)Math.floor(vec3d.field_1350 + d7 * (double)k) - this.sdk;
                    if (n2 < 0 || n3 < 0 || n2 >= n || n3 >= n) {
                        f += f3 * f4;
                        continue;
                    }
                    int n4 = this.sef[n3 * n + n2];
                    if ((double)n4 <= d) {
                        f += f3 * f4;
                        continue;
                    }
                    if (!((double)n4 > d2)) continue;
                    f3 *= 0.45f;
                }
            }
            fArray[i] = f2 <= 0.0f ? 1.0f : f / f2;
        }
        return fArray;
    }

    private float sfq(Vec3d vec3d) {
        if (!this.sdg) {
            return 1.0f;
        }
        int n = 128;
        int n2 = (int)Math.floor(vec3d.field_1352) - this.sdj;
        int n3 = (int)Math.floor(vec3d.field_1350) - this.sdk;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = -4; i <= 4; ++i) {
            for (int j = -4; j <= 4; ++j) {
                int n4 = n2 + j;
                int n5 = n3 + i;
                if (n4 < 0 || n5 < 0 || n4 >= n || n5 >= n) continue;
                float f3 = j == 0 && i == 0 ? 6.0f : 1.0f / (1.0f + 0.35f * (float)(j * j + i * i));
                f2 += f3;
                if (!((double)this.sef[n5 * n + n4] <= vec3d.field_1351 + 0.6)) continue;
                f += f3;
            }
        }
        return f2 <= 0.0f ? 1.0f : f / f2;
    }

    private void sfr(Std140Builder std140Builder, List<saw> list, Vec3d vec3d, long l) {
        int n;
        saw saw22;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (saw saw3 : list) {
            f += (float)(saw3.sax - vec3d.field_1352);
            f2 += (float)(saw3.say - vec3d.field_1351);
            f3 += (float)(saw3.saz - vec3d.field_1350);
        }
        int n2 = Math.max(1, list.size());
        f /= (float)n2;
        f2 /= (float)n2;
        f3 /= (float)n2;
        float f4 = 0.0f;
        for (saw saw22 : list) {
            float f5 = (float)(saw22.sax - vec3d.field_1352) - f;
            float f6 = (float)(saw22.say - vec3d.field_1351) - f2;
            float f7 = (float)(saw22.saz - vec3d.field_1350) - f3;
            f4 = Math.max(f4, (float)Math.sqrt(f5 * f5 + f6 * f6 + f7 * f7));
        }
        std140Builder.putVec4(f, f2, f3, list.isEmpty() ? 0.0f : f4 + 2.5f);
        for (n = 0; n < 32; ++n) {
            if (n < list.size()) {
                saw22 = list.get(list.size() - 1 - n);
                std140Builder.putVec4((float)(saw22.sax - vec3d.field_1352), (float)(saw22.say - vec3d.field_1351), (float)(saw22.saz - vec3d.field_1350), (float)(l - saw22.sbd) / 1.0E9f);
                continue;
            }
            std140Builder.putVec4(0.0f, -1000.0f, 0.0f, 1000.0f);
        }
        for (n = 0; n < 32; ++n) {
            if (n < list.size()) {
                saw22 = list.get(list.size() - 1 - n);
                std140Builder.putVec4(saw22.sba, saw22.sbb, saw22.sbc, saw22.sbe);
                continue;
            }
            std140Builder.putVec4(0.0f, 1.0f, 1.0f, 0.0f);
        }
    }

    private void sfs(ClientWorld clientWorld, int n, int n2) {
        int n3 = 128;
        int n4 = clientWorld.method_31607();
        boolean bl = false;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n5;
                int n6;
                int n7 = clientWorld.method_8624(Heightmap.Type.field_13197, n + j, n2 + i);
                if (n7 <= n4 && !bl) {
                    bl = !clientWorld.method_2935().method_12123(n + j >> 4, n2 + i >> 4);
                }
                BlockState blockState = clientWorld.method_8320((BlockPos)this.scv.method_10103(n + j, n7 - 1, n2 + i));
                for (n6 = 0; n6 < 96 && n7 > n4 && !sbp.sft(blockState); ++n6) {
                    blockState = clientWorld.method_8320((BlockPos)this.scv.method_10103(n + j, --n7 - 1, n2 + i));
                }
                int n8 = n6 = !blockState.method_26227().method_15769() ? 1 : 0;
                if (n6 == 0 && sbp.sfu(clientWorld, blockState, (BlockPos)this.scv)) {
                    --n7;
                }
                int n9 = Math.max(0, Math.min(65535, n7 + 64));
                boolean bl2 = blockState.method_26164(BlockTags.field_15503);
                int n10 = clientWorld.method_8314(LightType.field_9282, (BlockPos)this.scv.method_10103(n + j, n7, n2 + i)) * 17;
                for (n5 = 0; n5 < 15 && sbp.sfv(clientWorld.method_8320((BlockPos)this.scv.method_10103(n + j, n7 + n5, n2 + i))); ++n5) {
                }
                this.scu[i * n3 + j] = n10 << 24 | (n9 & 0xFF) << 16 | (n9 >> 8 & 0xFF) << 8 | (n6 != 0 ? 128 : 0) | (bl2 ? 64 : 0) | n5;
                this.sef[i * n3 + j] = n7;
            }
        }
        vbb.uploadHeights(this.scu);
        this.sdj = n;
        this.sdk = n2;
        this.sdl = bl ? 32 : 0;
        this.sdg = true;
    }

    private static boolean sft(BlockState blockState) {
        if (!blockState.method_26227().method_15769()) {
            return true;
        }
        return blockState.method_51366() && blockState.method_26217() != BlockRenderType.field_11455;
    }

    private static boolean sfu(ClientWorld clientWorld, BlockState blockState, BlockPos blockPos) {
        if (blockState.method_26164(BlockTags.field_15503)) {
            return false;
        }
        try {
            VoxelShape voxelShape = blockState.method_26220((BlockView)clientWorld, blockPos);
            return !voxelShape.method_1110() && voxelShape.method_1105(Direction.Axis.field_11052) <= 0.55;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static boolean sfv(BlockState blockState) {
        Block block = blockState.method_26204();
        return block instanceof PlantBlock || block instanceof SugarCaneBlock;
    }

    private static float sfw(double d, double d2) {
        double d3 = d % d2;
        return (float)(d3 < 0.0 ? d3 + d2 : d3);
    }

    private static float sfx(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static float sfy(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / (f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private /* synthetic */ void lambda$drawSeason$11(int n, int n2, int n3, Vec3d vec3d, int n4, float f, float f2, boolean bl, float f3, float f4, float f5, float f6, float[] fArray, float[] fArray2, float f7, int n5, int n6, boolean bl2, float f8, float f9, float[] fArray3, boolean bl3, int n7, int n8, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, long l, Std140Builder std140Builder) {
        std140Builder.putMat4f((Matrix4fc)this.scw);
        std140Builder.putMat4f((Matrix4fc)this.scx);
        std140Builder.putVec4((float)Math.floorMod(n, 4096), (float)n2, (float)Math.floorMod(n3, 4096), this.sdn);
        std140Builder.putVec4((float)(vec3d.field_1352 - (double)n), (float)(vec3d.field_1351 - (double)n2), (float)(vec3d.field_1350 - (double)n3), (float)n4);
        std140Builder.putVec4(f, f2, bl ? 1.0f : 0.0f, f3);
        std140Builder.putVec4(f4, f5, f6, this.sdo);
        std140Builder.putVec4(fArray[0], fArray[1], fArray[2], fArray[3]);
        std140Builder.putVec4(fArray2[0], fArray2[1], fArray2[2], f7);
        std140Builder.putVec4((float)n5, (float)n6, 128.0f, bl2 ? 1.0f : 0.0f);
        std140Builder.putVec4((float)this.sdu, f8, (float)this.sdv, f9);
        std140Builder.putVec4(fArray3[0], fArray3[1], fArray3[2], bl3 ? 1.0f : 0.0f);
        std140Builder.putVec4((float)n7, (float)n8, vbb.entityMask() ? 1.0f : 0.0f, 0.0f);
        std140Builder.putVec4(f10, f11, f12, f13);
        std140Builder.putVec4(f14, f15, f16, f17);
        std140Builder.putVec4(f18, f19, f20, f21);
        std140Builder.putVec4(f22, f23, f24, f25);
        this.sfr(std140Builder, this.sct, vec3d, l);
    }

    private static /* synthetic */ int cdc(int n, int n2) {
        return n ^ n2 ^ 0xAC5F3E51;
    }

    private static /* synthetic */ int cdd(int n, int n2) {
        return (n ^ n2) + 1340556751;
    }
}

