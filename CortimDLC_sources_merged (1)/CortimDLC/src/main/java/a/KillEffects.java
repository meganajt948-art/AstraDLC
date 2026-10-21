/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2388
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2663
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_4184
 *  net.minecraft.class_638
 *  net.minecraft.class_9779
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package a;

import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.rrj;
import a.rru;
import a.KillShatter;
import a.ColorUtil;
import a.FrameDelta;
import a.GlowSprite;
import a.ScreenProjection;
import a.DrawUtil;
import a.uwg;
import a.ShatterPass;
import a.Easing;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.PacketHooks;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2388;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2663;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import net.minecraft.class_9779;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class KillEffects
extends Module {
    private static KillEffects rry;
    private final ModeSetting rrz = this.add(new ModeSetting("Style", "Angel", "Angel", "Glass"));
    private final BoolSetting rsa = this.add(new BoolSetting("On kill", true));
    private final BoolSetting rsb = this.add(new BoolSetting("On totem pop", true));
    private final BoolSetting rsc = this.add(new BoolSetting("Only my targets", true));
    private final BoolSetting rsd = this.add(new BoolSetting("Mobs", false));
    private final ColorSetting rse = this.add(new ColorSetting("Color", "Ice"));
    private final ColorSetting rsf = this.add(new ColorSetting("Totem color", "Gold"));
    private final NumberSetting rsg = this.add(new NumberSetting("Size", 1.0, 0.6, 1.6, 0.05).percent());
    private final NumberSetting rsh = this.add(new NumberSetting("Duration", 3.0, 1.5, 5.0, 0.1).suffix("s"));
    private final BoolSetting rsi = this.add(new BoolSetting("Wings", true));
    private final BoolSetting rsj = this.add(new BoolSetting("Halo", true));
    private final ModeSetting rsk = this.add(new ModeSetting("Pieces", "Shards", "Shards", "Cubes"));
    private final BoolSetting rsl = this.add(new BoolSetting("Sound", true));
    private final BoolSetting rsm = this.add(new BoolSetting("Particles", true));
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
    private final List<KillShatter> rsy = new ArrayList<KillShatter>();
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

    public KillEffects() {
        super(new String(new char[]{'S', 'o', 'u', 'l', 'E', 'S', 'P'}), "A soul or glass copy on a kill", ModuleCategory.RENDER);
        rry = this;
        PacketHooks.listen(KillEffects::rtw);
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
        return rry == null ? 0 : KillEffects.rry.rsy.size();
    }

    public static void trigger(class_1309 class_13092, boolean bl) {
        if (rry != null && rry.isEnabled()) {
            rsr.add(new rrj(class_13092.method_5628(), class_13092.method_23317(), class_13092.method_23318(), class_13092.method_23321(), class_13092.field_6283, class_13092.method_17682(), class_13092 instanceof class_1657, bl));
        }
    }

    public static void onAttack(class_1297 class_12972) {
        if (rry != null && rry.isEnabled()) {
            rss.put(class_12972.method_5628(), System.currentTimeMillis());
        }
    }

    private static void rtw(class_2596<?> class_25962) {
        class_1309 class_13092;
        class_1297 class_12972;
        byte by;
        block8: {
            block7: {
                KillEffects rrx2 = rry;
                if (rrx2 == null || !rrx2.isEnabled() || !(class_25962 instanceof class_2663)) {
                    return;
                }
                class_2663 class_26632 = (class_2663)class_25962;
                by = class_26632.method_11470();
                if (by != 3 && by != 35) {
                    return;
                }
                class_638 class_6382 = class_310.method_1551().field_1687;
                if (class_6382 == null) {
                    return;
                }
                class_12972 = class_26632.method_11469((class_1937)class_6382);
                if (!(class_12972 instanceof class_1309)) break block7;
                class_13092 = (class_1309)class_12972;
                if (class_12972 != class_310.method_1551().field_1724) break block8;
            }
            return;
        }
        rsr.add(new rrj(class_12972.method_5628(), class_12972.method_23317(), class_12972.method_23318(), class_12972.method_23321(), class_13092.field_6283, class_12972.method_17682(), class_12972 instanceof class_1657, by == 35));
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
        ShatterPass.release();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        rrj rrj2;
        PacketHooks.ensure(class_3102);
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
    public void onWorldRenderLate(class_310 class_3102) {
        Object object;
        if (this.rsx.isEmpty() && this.rsy.isEmpty()) {
            this.rte = 0L;
            return;
        }
        class_638 class_6382 = class_3102.field_1687;
        if (class_6382 == null || class_3102.field_1724 == null) {
            this.rsx.clear();
            this.rsy.clear();
            return;
        }
        long l = System.nanoTime();
        float f = this.rte == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.rte) / 1.0E9f);
        this.rte = l;
        float f2 = class_3102.method_61966().method_60637(false);
        for (rrj rrj2 : this.rsx) {
            class_1309 class_13092;
            object = class_6382.method_8469(rrj2.rrk);
            int n = (rrj2.rrr ? this.rsf : this.rse).color();
            if (object instanceof class_1309) {
                class_1309 class_13093 = (class_1309)object;
                class_13092 = class_13093;
            } else {
                class_13092 = null;
            }
            KillShatter sql2 = KillShatter.create(class_3102, class_13092, rrj2.rrl, rrj2.rrm, rrj2.rrn, rrj2.rro, rrj2.rrp, rrj2.rrq, rrj2.rrr, this.rsk.is("Cubes"), n, f2);
            if (this.rsy.size() >= 4) {
                this.rsy.remove(0);
            }
            this.rsy.add(sql2);
        }
        this.rsx.clear();
        int n = 0;
        for (int i = this.rsy.size() - 1; i >= 0; --i) {
            object = this.rsy.get(i);
            if (!((KillShatter)object).update(f)) {
                this.rsy.remove(i);
                continue;
            }
            this.rtx(class_6382, (KillShatter)object);
            n += ((KillShatter)object).vertices();
        }
        if (this.rsy.isEmpty()) {
            return;
        }
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        object = class_41842.method_71156();
        ByteBuffer byteBuffer = ShatterPass.staging(n);
        this.rsz.clear();
        int n2 = 0;
        for (KillShatter sql3 : this.rsy) {
            int n3 = sql3.write(byteBuffer, ((class_243)object).field_1352, ((class_243)object).field_1351, ((class_243)object).field_1350);
            this.rsz.add(new uwg(n2, n3, sql3.red, sql3.green, sql3.blue, sql3.alpha(), (float)(sql3.y + (double)sql3.scan() - ((class_243)object).field_1351), (float)(sql3.y + (double)sql3.sweep() - ((class_243)object).field_1351), sql3.flash(), sql3.broken()));
            n2 += n3;
        }
        this.rta.rotation((Quaternionfc)class_41842.method_23767().conjugate(this.rtb));
        ShatterPass.draw(this.rta, 0.36f, 0.86f, 0.36f, 1.0f, this.rsz, byteBuffer);
    }

    private void rtx(class_638 class_6382, KillShatter sql2) {
        int n = sql2.takeEvents();
        if (n == 0) {
            return;
        }
        double d = sql2.centerX();
        double d2 = sql2.centerY();
        double d3 = sql2.centerZ();
        if (this.rsl.get()) {
            if ((n & 1) != 0) {
                class_6382.method_8486(d, d2, d3, class_3417.field_26980, class_3419.field_15248, 0.9f, 1.4f, false);
            }
            if ((n & 2) != 0) {
                if (sql2.totem) {
                    class_6382.method_8486(d, d2, d3, class_3417.field_26942, class_3419.field_15248, 0.9f, 1.2f, false);
                } else {
                    class_6382.method_8486(d, d2, d3, class_3417.field_14583, class_3419.field_15248, 0.8f, 0.7f, false);
                }
            }
            if ((n & 4) != 0) {
                if (sql2.totem) {
                    class_6382.method_8486(d, d2, d3, class_3417.field_15081, class_3419.field_15248, 0.35f, 1.6f, false);
                } else {
                    class_6382.method_8486(d, d2, d3, class_3417.field_15081, class_3419.field_15248, 1.0f, 0.92f + this.rtc.nextFloat() * 0.14f, false);
                    class_6382.method_8486(d, d2, d3, class_3417.field_26979, class_3419.field_15248, 0.5f, 1.35f, false);
                }
            }
        }
        if (this.rsm.get() && (n & 4) != 0) {
            int n2;
            class_2388 class_23882 = new class_2388(class_2398.field_11217, class_2246.field_10033.method_9564());
            int n3 = sql2.totem ? 8 : 40;
            for (n2 = 0; n2 < n3; ++n2) {
                if (!sql2.sample(this.rtc, this.rtd)) continue;
                class_6382.method_8406((class_2394)class_23882, this.rtd[0], this.rtd[1], this.rtd[2], this.rtd[3] * 0.3, this.rtd[4] * 0.3, this.rtd[5] * 0.3);
            }
            n2 = sql2.totem ? 5 : 14;
            for (int i = 0; i < n2; ++i) {
                class_6382.method_8406((class_2394)class_2398.field_11207, d + (this.rtc.nextDouble() - 0.5) * 0.6, d2 + (this.rtc.nextDouble() - 0.5) * 1.4, d3 + (this.rtc.nextDouble() - 0.5) * 0.6, (this.rtc.nextDouble() - 0.5) * 0.12, this.rtc.nextDouble() * 0.08, (this.rtc.nextDouble() - 0.5) * 0.12);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        KillEffects rrx2 = rry;
        class_310 class_3102 = class_310.method_1551();
        if (rrx2 == null || !rrx2.isEnabled() || rrx2.rst.isEmpty() || class_3102.field_1687 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rrx2.rsu) {
            return;
        }
        rrx2.rsu = FrameDelta.frame();
        float f = FrameDelta.delta();
        rrx2.rsv += f;
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        float f2 = (float)rrx2.rsh.get();
        DrawUtil.beginFrame();
        try {
            for (int i = rrx2.rst.size() - 1; i >= 0; --i) {
                rru rru2 = rrx2.rst.get(i);
                rru2.age += f;
                if (rru2.age >= f2) {
                    rrx2.rst.remove(i);
                    continue;
                }
                rrx2.rty(class_3322, usn2, rru2, rru2.age / f2);
            }
        }
        finally {
            DrawUtil.additive(false);
        }
    }

    private void rty(class_332 class_3322, ScreenProjection usn2, rru rru2, float f) {
        float f2;
        float f3 = Easing.outCubic(Math.min(1.0f, f / 0.12f));
        float f4 = f3 * (f2 = f < 0.55f ? 1.0f : 1.0f - Easing.inCubic((f - 0.55f) / 0.45f));
        if (f4 <= 0.01f) {
            return;
        }
        float f5 = (rru2.totem ? 1.8f : 3.2f) * Easing.outCubic(f) * rru2.scale;
        float f6 = (float)Math.sin(this.rsv * 2.2f + rru2.seed) * 0.06f;
        double d = rru2.y + (double)f5 + (double)f6 + 0.1;
        ColorSetting vla2 = rru2.totem ? this.rsf : this.rse;
        int n = vla2.color() | 0xFF000000;
        int n2 = vla2.color2() | 0xFF000000;
        float f7 = Easing.outCubic(Math.min(1.0f, f / 0.45f));
        float f8 = (float)Math.toRadians(-rru2.yaw) + f * 0.6f;
        if (this.rsi.get()) {
            this.rub(class_3322, usn2, rru2, d, f8, f7, f4, n, n2);
        }
        this.rtz(class_3322, usn2, rru2, d, f8, f7, f4, n, n2);
        DrawUtil.additive(true);
        this.rue(class_3322, usn2, rru2, d, f4, n, n2, f);
        DrawUtil.additive(false);
        DrawUtil.additive(true);
        if (this.rsj.get()) {
            this.rud(class_3322, usn2, rru2, d + 2.2 * (double)rru2.scale, f4, n, n2);
        }
        this.ruf(class_3322, usn2, rru2, d, f4, n, n2);
        DrawUtil.additive(false);
    }

    private void rtz(class_332 class_3322, ScreenProjection usn2, rru rru2, double d, float f, float f2, float f3, int n, int n2) {
        float f4 = rru2.scale;
        float f5 = -(0.35f + 2.1f * f2);
        this.rua(class_3322, usn2, rru2, d, f, f4, -4.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, -2.0f, 12.0f, 0.0f, -0.15f * f2, f3 * 0.55f, n, n2);
        this.rua(class_3322, usn2, rru2, d, f, f4, 0.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 2.0f, 12.0f, 0.0f, 0.1f * f2, f3 * 0.55f, n, n2);
        this.rua(class_3322, usn2, rru2, d, f, f4, -4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.0f, 12.0f, 0.0f, 0.0f, f3 * 0.75f, n, n2);
        this.rua(class_3322, usn2, rru2, d, f, f4, -4.0f, 24.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, 24.0f, 0.0f, -0.25f * f2, f3 * 0.9f, n, n2);
        this.rua(class_3322, usn2, rru2, d, f, f4, -8.0f, 12.0f, -2.0f, 4.0f, 12.0f, 4.0f, -5.0f, 22.0f, f5, 0.0f, f3 * 0.7f, n, n2);
        this.rua(class_3322, usn2, rru2, d, f, f4, 4.0f, 12.0f, -2.0f, 4.0f, 12.0f, 4.0f, 5.0f, 22.0f, -f5, 0.0f, f3 * 0.7f, n, n2);
    }

    private void rua(class_332 class_3322, ScreenProjection usn2, rru rru2, double d, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int n, int n2) {
        this.rtf.identity().rotateY(f).scale(f2 * 0.0625f).translate(f9, f10, 0.0f).rotateZ(f11).rotateX(f12).translate(-f9, -f10, 0.0f);
        class_243 class_2432 = usn2.camera();
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
        int n3 = ColorUtil.withAlpha(ColorUtil.lerp(n, -1, 0.2f), Math.round(125.0f * f13 * (0.35f + 0.65f * f14)));
        int n4 = ColorUtil.withAlpha(ColorUtil.lerp(n, n2, 0.4f), Math.round(125.0f * f13 * (0.08f + 0.92f * f15)));
        for (int i = 0; i < 6; ++i) {
            int[] nArray = rts[i];
            if (!this.rti[nArray[0]] || !this.rti[nArray[1]] || !this.rti[nArray[2]] || !this.rti[nArray[3]]) continue;
            this.rtg.set(rtt[i][0], rtt[i][1], rtt[i][2]);
            this.rtf.transformDirection(this.rtg);
            double d2 = (this.rtj[nArray[0]][0] + this.rtj[nArray[2]][0]) * 0.5;
            double d3 = (this.rtj[nArray[0]][1] + this.rtj[nArray[2]][1]) * 0.5;
            double d4 = (this.rtj[nArray[0]][2] + this.rtj[nArray[2]][2]) * 0.5;
            if ((double)this.rtg.x * (class_2432.field_1352 - d2) + (double)this.rtg.y * (class_2432.field_1351 - d3) + (double)this.rtg.z * (class_2432.field_1350 - d4) <= 0.0) continue;
            for (int j = 0; j < 4; ++j) {
                this.rto[j] = (nArray[j] & 2) != 0 ? n3 : n4;
            }
            DrawUtil.quad(class_3322, this.rth[nArray[0]][0], this.rth[nArray[0]][1], this.rto[0], this.rth[nArray[1]][0], this.rth[nArray[1]][1], this.rto[1], this.rth[nArray[2]][0], this.rth[nArray[2]][1], this.rto[2], this.rth[nArray[3]][0], this.rth[nArray[3]][1], this.rto[3]);
        }
    }

    private void rub(class_332 class_3322, ScreenProjection usn2, rru rru2, double d, float f, float f2, float f3, int n, int n2) {
        float f4 = rru2.scale;
        float f5 = (float)Math.sin(this.rsv * 3.2f + rru2.seed) * 0.16f;
        double d2 = 0.95 * (double)f4 * (0.35 + 0.65 * (double)f2);
        double d3 = Math.cos(f);
        double d4 = Math.sin(f);
        int n3 = ColorUtil.withAlpha(ColorUtil.lerp(n, -1, 0.3f), Math.round(150.0f * f3));
        int n4 = ColorUtil.withAlpha(ColorUtil.lerp(n2, n, 0.3f), Math.round(26.0f * f3));
        int n5 = ColorUtil.withAlpha(ColorUtil.lerp(n, -1, 0.5f), Math.round(170.0f * f3));
        for (int i = -1; i <= 1; i += 2) {
            int n6;
            double d5 = 0.45 - 0.3 * (double)f2 + (double)f5;
            double d6 = (double)i * Math.cos(d5);
            double d7 = -Math.sin(d5);
            double d8 = (double)i * 0.1 * (double)f4;
            double d9 = 1.32 * (double)f4;
            double d10 = -0.16 * (double)f4;
            if (!KillEffects.ruc(usn2, rru2, d, d8, d9, d10, d3, d4, this.rtk)) continue;
            for (n6 = 0; n6 < rtr.length; ++n6) {
                double d11 = (double)rtr[n6][0] * d2;
                double d12 = (double)rtr[n6][1] * d2;
                this.rtq[n6] = KillEffects.ruc(usn2, rru2, d, d8 + d6 * d11, d9 + d12, d10 + d7 * d11, d3, d4, this.rtp[n6]);
            }
            n6 = 0;
            while (n6 + 1 < rtr.length) {
                if (this.rtq[n6] && this.rtq[n6 + 1]) {
                    float[] fArray = this.rtp[n6];
                    float[] fArray2 = this.rtp[n6 + 1];
                    DrawUtil.quad(class_3322, this.rtk[0], this.rtk[1], n3, fArray[0], fArray[1], n4, fArray2[0], fArray2[1], n4, fArray2[0], fArray2[1], n4);
                }
                ++n6;
            }
            DrawUtil.additive(true);
            n6 = 0;
            while (n6 + 1 < rtr.length) {
                if (this.rtq[n6] && this.rtq[n6 + 1]) {
                    DrawUtil.line(class_3322, this.rtp[n6][0], this.rtp[n6][1], this.rtp[n6 + 1][0], this.rtp[n6 + 1][1], 0.9f, n5);
                }
                ++n6;
            }
            DrawUtil.additive(false);
        }
    }

    private static boolean ruc(ScreenProjection usn2, rru rru2, double d, double d2, double d3, double d4, double d5, double d6, float[] fArray) {
        return usn2.project(rru2.x + d2 * d5 + d4 * d6, d + d3, rru2.z - d2 * d6 + d4 * d5, fArray);
    }

    private void rud(class_332 class_3322, ScreenProjection usn2, rru rru2, double d, float f, int n, int n2) {
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
                DrawUtil.softLine(class_3322, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f3, f3 * 3.0f, ColorUtil.withAlpha(n, Math.round(90.0f * f)));
                DrawUtil.line(class_3322, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f3 * 0.6f, ColorUtil.withAlpha(ColorUtil.lerp(n2, -1, 0.6f), Math.round(230.0f * f)));
            }
            this.rtk[0] = this.rtl[0];
            this.rtk[1] = this.rtl[1];
            bl = bl2;
        }
    }

    private void rue(class_332 class_3322, ScreenProjection usn2, rru rru2, double d, float f, int n, int n2, float f2) {
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
                    DrawUtil.softLine(class_3322, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f4, f4 * 3.5f, ColorUtil.withAlpha(ColorUtil.lerp(n, n2, f6), Math.round(80.0f * f7)));
                    DrawUtil.line(class_3322, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], f4 * 0.5f, ColorUtil.withAlpha(ColorUtil.lerp(n, -1, 0.5f), Math.round(200.0f * f7)));
                }
                this.rtk[0] = this.rtl[0];
                this.rtk[1] = this.rtl[1];
                bl = bl2;
            }
        }
    }

    private void ruf(class_332 class_3322, ScreenProjection usn2, rru rru2, double d, float f, int n, int n2) {
        GpuTextureView gpuTextureView = GlowSprite.view();
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
            DrawUtil.sprite(class_3322, gpuTextureView, this.rtk[0], this.rtk[1], f7 * 3.0f, ColorUtil.withAlpha(n, Math.round(70.0f * f6)));
            DrawUtil.sprite(class_3322, gpuTextureView, this.rtk[0], this.rtk[1], f7, ColorUtil.withAlpha(ColorUtil.lerp(n2, -1, 0.6f), Math.round(220.0f * f6)));
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
        return KillEffects.cbm(n, n2) + n;
    }

    private static /* synthetic */ int cbo(int n, int n2) {
        return KillEffects.cbn(n, n2) ^ 0x38FC9863;
    }
}

