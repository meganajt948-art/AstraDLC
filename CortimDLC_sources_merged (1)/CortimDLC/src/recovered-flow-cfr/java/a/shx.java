/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package a;

import a.hlc;
import a.jgd;
import a.jgn;
import a.kfa;
import a.kfe;
import a.skx;
import a.sle;
import a.sls;
import a.sng;
import a.snp;
import a.ujt;
import a.unf;
import a.unm;
import a.usn;
import a.uut;
import a.vdn;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public class shx
extends kfe {
    private static shx shy;
    private final vlv shz = this.add(new vlv("Anchor", "World", "World", "Follow view"));
    private final vmc sia = this.add(new vmc("Distance", 5.5, 2.5, 12.0, 0.5).suffix("blocks"));
    private final vmc sib = this.add(new vmc("Size", 1.0, 0.5, 2.0, 0.05).percent());
    private final vmc sic = this.add(new vmc("Spread", 0.6, 0.0, 1.0, 0.05).percent());
    private final vkl sid = this.add(new vkl("Cover color", true));
    private final vla sie = this.add(new vla("Color", "Theme"));
    private final vmc sif = this.add(new vmc("Glow", 0.6, 0.0, 1.0, 0.05).percent());
    private final vkl sig = this.add(new vkl("Shadow", true));
    private final vkl sih = this.add(new vkl("Particles", true));
    private final vkl sii = this.add(new vkl("Song title", true));
    private final vkl sij = this.add(new vkl("Through walls", false));
    private final vmc sik = this.add(new vmc("Sync offset", 0.0, -2000.0, 2000.0, 50.0).suffix("ms"));
    private static final float sil = 0.3f;
    private static final long sim = 120L;
    private static final long sin = 1500L;
    private static final float sio = 5.5f;
    private static final float sip = 2.0f;
    private static final float siq = 2.2f;
    private final List<snp> sir = new ArrayList<snp>();
    private final Random sis = new Random();
    private final float[] sit = new float[2];
    private String siu;
    private sle siv;
    private int siw = -1;
    private snp six;
    private snp siy;
    private float siz = 1.0f;
    private long sja = -1L;
    private static /* synthetic */ boolean sjb;
    private static /* synthetic */ int sjc;

    public shx() {
        super("Lyrics", "The words of the song you are listening to appear in the world in front of you", kfa.RENDER);
        shy = this;
        this.sie.visibleWhen(() -> !this.sid.get());
    }

    public static boolean wantsMusic() {
        shx shx2 = shy;
        return shx2 != null && shx2.isEnabled();
    }

    @Override
    protected void onEnable() {
        this.sjd();
    }

    @Override
    protected void onDisable() {
        this.sjd();
    }

    private void sjd() {
        this.sir.clear();
        this.siu = null;
        this.siv = null;
        this.siw = -1;
        this.six = null;
        this.siy = null;
        this.siz = 1.0f;
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        shx shx2 = shy;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (shx2 == null || !shx2.isEnabled() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == shx2.sja) {
            return;
        }
        shx2.sja = unf.frame();
        try {
            usn2 = usn.capture(renderTickCounter.method_60637(true), drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        vdn.setRenderScale(1.0f);
        shx2.sje(drawContext, usn2, Math.min(0.1f, unf.delta()));
    }

    private void sje(DrawContext drawContext, usn usn2, float f) {
        String string;
        jgd jgd2 = jgn.track();
        String string2 = string = jgd2 == null ? null : jgd2.title() + '\u0001' + jgd2.artist();
        if (!Objects.equals(string, this.siu)) {
            this.siu = string;
            this.siv = null;
            this.siw = -1;
            this.six = null;
            Object object = this.sir.iterator();
            while (object.hasNext()) {
                snp snp2 = object.next();
                snp2.dissolve();
            }
            this.siy = null;
            if (jgd2 != null && this.sii.get() && !((snp)(object = snp.card(jgd2.title(), jgd2.artist(), this.sis))).isEmpty()) {
                this.sji((snp)object);
                this.sir.add((snp)object);
                this.siy = object;
            }
        }
        long l = 0L;
        if (jgd2 != null) {
            l = jgd2.position() + (long)this.sik.get() + 120L;
            if (this.siv == null) {
                this.siv = sls.get(jgd2.title(), jgd2.artist(), jgd2.duration());
            }
            if (this.siv != null && !this.siv.isEmpty()) {
                this.sjf(l);
            }
        }
        if (this.siy != null && (this.siy.age > 5.5f || !this.sii.get())) {
            this.siy.dissolve();
            this.siy = null;
        }
        this.siz += ((jgd2 == null || jgd2.playing() ? 1.0f : 0.45f) - this.siz) * Math.min(1.0f, f * 4.0f);
        Vec3d vec3d = usn2.camera();
        boolean bl = !this.shz.is("Follow view");
        float f2 = Math.min(1.0f, f * 6.0f);
        for (int i = this.sir.size() - 1; i >= 0; --i) {
            snp snp3 = this.sir.get(i);
            snp3.update(f, l);
            if (snp3.finished()) {
                this.sir.remove(i);
                continue;
            }
            if (bl) {
                snp3.y += (double)f * 0.03;
            } else {
                Vec3d vec3d2 = this.sjj(snp3);
                float f3 = Math.min(1.0f, f * 2.2f);
                snp3.x += (vec3d2.field_1352 - snp3.x) * (double)f3;
                snp3.y += (vec3d2.field_1351 - snp3.y) * (double)f3;
                snp3.z += (vec3d2.field_1350 - snp3.z) * (double)f3;
            }
            boolean bl2 = !this.sij.get() && this.sjk(vec3d, snp3);
            snp3.hidden = snp3.hidden + ((bl2 ? 1.0f : 0.0f) - snp3.hidden) * f2;
        }
        if (this.sir.isEmpty()) {
            return;
        }
        this.sjg(drawContext, usn2);
    }

    private void sjf(long l) {
        List<skx> list = this.siv.lines();
        int n = this.siv.indexAt(l);
        if (this.siw >= 0 && n < this.siw && l > list.get(this.siw).start() - 1500L) {
            n = this.siw;
        }
        if (n != this.siw) {
            snp snp2;
            skx skx2;
            if (this.six != null) {
                this.six.dissolve();
                this.six = null;
            }
            this.siw = n;
            if (n >= 0 && !(skx2 = list.get(n)).blank() && l < skx2.end() && !(snp2 = snp.line(n, skx2, this.sis)).isEmpty()) {
                if (this.siy != null && this.siy.age >= 2.0f) {
                    this.siy.dissolve();
                    this.siy = null;
                }
                this.sji(snp2);
                this.sir.add(snp2);
                this.six = snp2;
            }
        }
        if (this.six != null && l > this.six.holdUntil) {
            this.six.dissolve();
            this.six = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sjg(DrawContext drawContext, usn usn2) {
        GpuTextureView gpuTextureView = unm.view();
        int[] nArray = this.sjh();
        sng sng2 = new sng(nArray[0], nArray[1], (float)this.sif.get(), this.sig.get(), this.sih.get(), this.siz);
        this.sir.sort((snp2, snp3) -> Double.compare(usn2.distance(snp3.x, snp3.y, snp3.z), usn2.distance(snp2.x, snp2.y, snp2.z)));
        float f = (float)this.sib.get() * 0.3f;
        float f2 = usn2.height() * 0.16f;
        uut.beginBatch();
        try {
            for (snp snp4 : this.sir) {
                float f3;
                if (!usn2.project(snp4.x, snp4.y, snp4.z, this.sit) || (f3 = usn2.unitsPerBlock(snp4.x, snp4.y, snp4.z) * f) < 2.5f) continue;
                snp4.draw(drawContext, this.sit[0], this.sit[1], Math.min(f2, f3), sng2, gpuTextureView);
            }
        }
        finally {
            uut.additive(false);
            uut.endBatch();
        }
    }

    private int[] sjh() {
        if (this.sid.get() && jgn.cover() != null) {
            int n = jgn.coverColor() | 0xFF000000;
            return new int[]{n, ujt.lerp(n, -1, 0.45f)};
        }
        return this.sie.vivid(new int[]{-7635722, -10556716});
    }

    private void sji(snp snp2) {
        Camera camera = this.mc.field_1773.method_19418();
        Vec3d vec3d = camera.method_71156();
        float f = camera.method_19330();
        float f2 = MathHelper.method_15363((float)camera.method_19329(), (float)-50.0f, (float)50.0f);
        float f3 = (float)this.sic.get();
        float f4 = -3.4028235E38f;
        float f5 = 0.0f;
        float f6 = -8.0f;
        for (int i = 0; i < 10; ++i) {
            float f7 = (this.sis.nextFloat() * 2.0f - 1.0f) * 26.0f * f3;
            float f8 = snp2.card ? -(10.0f + this.sis.nextFloat() * 6.0f * f3) : -(6.0f + this.sis.nextFloat() * 10.0f * f3);
            float f9 = 14.0f;
            for (snp snp3 : this.sir) {
                double d = snp3.x - vec3d.field_1352;
                double d2 = snp3.y - vec3d.field_1351;
                double d3 = snp3.z - vec3d.field_1350;
                float f10 = (float)(MathHelper.method_15349((double)d3, (double)d) * 57.2957763671875) - 90.0f;
                float f11 = (float)(-(MathHelper.method_15349((double)d2, (double)Math.sqrt(d * d + d3 * d3)) * 57.2957763671875));
                float f12 = MathHelper.method_15393((float)(f + f7 - f10));
                float f13 = f2 + f8 - f11;
                f9 = Math.min(f9, (float)Math.hypot(f12 * 0.3f, f13));
            }
            float f14 = f9 - 0.06f * Math.abs(f7) - 0.08f * Math.abs(f8 + 8.0f) + this.sis.nextFloat() * 0.5f;
            if (!(f14 > f4)) continue;
            f4 = f14;
            f5 = f7;
            f6 = f8;
        }
        snp2.yawOff = f5;
        snp2.pitchOff = f6;
        snp2.dist = (float)this.sia.get() * (0.9f + this.sis.nextFloat() * 0.2f);
        Vec3d vec3d2 = this.sjj(snp2);
        snp2.x = vec3d2.field_1352;
        snp2.y = vec3d2.field_1351;
        snp2.z = vec3d2.field_1350;
    }

    private Vec3d sjj(snp snp2) {
        double d;
        float f;
        Vec3d vec3d;
        Vec3d vec3d2;
        Camera camera = this.mc.field_1773.method_19418();
        Vec3d vec3d3 = camera.method_71156();
        BlockHitResult blockHitResult = this.mc.field_1687.method_17742(new RaycastContext(vec3d3, vec3d2 = vec3d3.method_1019((vec3d = Vec3d.method_1030((float)(f = MathHelper.method_15363((float)camera.method_19329(), (float)-50.0f, (float)50.0f) + snp2.pitchOff), (float)(camera.method_19330() + snp2.yawOff))).method_1021(d = (double)snp2.dist)), RaycastContext.ShapeType.field_17558, RaycastContext.FluidHandling.field_1348, (Entity)this.mc.field_1724));
        if (blockHitResult.method_17783() != HitResult.Type.field_1333) {
            d = Math.max(1.6, blockHitResult.method_17784().method_1022(vec3d3) - 0.6);
        }
        return vec3d3.method_1019(vec3d.method_1021(d));
    }

    private boolean sjk(Vec3d vec3d, snp snp2) {
        Vec3d vec3d2 = new Vec3d(snp2.x, snp2.y, snp2.z);
        double d = vec3d2.method_1022(vec3d);
        if (d < 0.5) {
            return false;
        }
        BlockHitResult blockHitResult = this.mc.field_1687.method_17742(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.field_23142, RaycastContext.FluidHandling.field_1348, (Entity)this.mc.field_1724));
        return blockHitResult.method_17783() != HitResult.Type.field_1333 && blockHitResult.method_17784().method_1022(vec3d) < d - 0.3;
    }

    private static /* synthetic */ int cdu(int n, int n2) {
        return n + n2 | 0xEF997A21;
    }

    private static /* synthetic */ int cdv(int n, int n2) {
        return shx.cdu(n, n2) * n2;
    }

    private static /* synthetic */ int cdw(int n, int n2) {
        return shx.cdv(n, n2) * n2;
    }
}

