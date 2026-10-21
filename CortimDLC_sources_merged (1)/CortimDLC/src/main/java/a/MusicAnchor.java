/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1297
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4184
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.jgd;
import a.NowPlaying;
import a.ModuleCategory;
import a.Module;
import a.skx;
import a.LyricsParser;
import a.TrackTitleCleaner;
import a.sng;
import a.LyricsLine;
import a.ColorUtil;
import a.FrameDelta;
import a.GlowSprite;
import a.ScreenProjection;
import a.DrawUtil;
import a.FontFace;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_9779;

public class MusicAnchor
extends Module {
    private static MusicAnchor shy;
    private final ModeSetting shz = this.add(new ModeSetting("Anchor", "World", "World", "Follow view"));
    private final NumberSetting sia = this.add(new NumberSetting("Distance", 5.5, 2.5, 12.0, 0.5).suffix("blocks"));
    private final NumberSetting sib = this.add(new NumberSetting("Size", 1.0, 0.5, 2.0, 0.05).percent());
    private final NumberSetting sic = this.add(new NumberSetting("Spread", 0.6, 0.0, 1.0, 0.05).percent());
    private final BoolSetting sid = this.add(new BoolSetting("Cover color", true));
    private final ColorSetting sie = this.add(new ColorSetting("Color", "Theme"));
    private final NumberSetting sif = this.add(new NumberSetting("Glow", 0.6, 0.0, 1.0, 0.05).percent());
    private final BoolSetting sig = this.add(new BoolSetting("Shadow", true));
    private final BoolSetting sih = this.add(new BoolSetting("Particles", true));
    private final BoolSetting sii = this.add(new BoolSetting("Song title", true));
    private final BoolSetting sij = this.add(new BoolSetting("Through walls", false));
    private final NumberSetting sik = this.add(new NumberSetting("Sync offset", 0.0, -2000.0, 2000.0, 50.0).suffix("ms"));
    private static final float sil = 0.3f;
    private static final long sim = 120L;
    private static final long sin = 1500L;
    private static final float sio = 5.5f;
    private static final float sip = 2.0f;
    private static final float siq = 2.2f;
    private final List<LyricsLine> sir = new ArrayList<LyricsLine>();
    private final Random sis = new Random();
    private final float[] sit = new float[2];
    private String siu;
    private LyricsParser siv;
    private int siw = -1;
    private LyricsLine six;
    private LyricsLine siy;
    private float siz = 1.0f;
    private long sja = -1L;
    private static /* synthetic */ boolean sjb;
    private static /* synthetic */ int sjc;

    public MusicAnchor() {
        super("Lyrics", "The words of the song you are listening to appear in the world in front of you", ModuleCategory.RENDER);
        shy = this;
        this.sie.visibleWhen(() -> !this.sid.get());
    }

    public static boolean wantsMusic() {
        MusicAnchor shx2 = shy;
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

    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        MusicAnchor shx2 = shy;
        class_310 class_3102 = class_310.method_1551();
        if (shx2 == null || !shx2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == shx2.sja) {
            return;
        }
        shx2.sja = FrameDelta.frame();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        FontFace.setRenderScale(1.0f);
        shx2.sje(class_3322, usn2, Math.min(0.1f, FrameDelta.delta()));
    }

    private void sje(class_332 class_3322, ScreenProjection usn2, float f) {
        String string;
        jgd jgd2 = NowPlaying.track();
        String string2 = string = jgd2 == null ? null : jgd2.title() + '\u0001' + jgd2.artist();
        if (!Objects.equals(string, this.siu)) {
            this.siu = string;
            this.siv = null;
            this.siw = -1;
            this.six = null;
            Object object = this.sir.iterator();
            while (object.hasNext()) {
                LyricsLine snp2 = object.next();
                snp2.dissolve();
            }
            this.siy = null;
            if (jgd2 != null && this.sii.get() && !((LyricsLine)(object = LyricsLine.card(jgd2.title(), jgd2.artist(), this.sis))).isEmpty()) {
                this.sji((LyricsLine)object);
                this.sir.add((LyricsLine)object);
                this.siy = object;
            }
        }
        long l = 0L;
        if (jgd2 != null) {
            l = jgd2.position() + (long)this.sik.get() + 120L;
            if (this.siv == null) {
                this.siv = TrackTitleCleaner.get(jgd2.title(), jgd2.artist(), jgd2.duration());
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
        class_243 class_2432 = usn2.camera();
        boolean bl = !this.shz.is("Follow view");
        float f2 = Math.min(1.0f, f * 6.0f);
        for (int i = this.sir.size() - 1; i >= 0; --i) {
            LyricsLine snp3 = this.sir.get(i);
            snp3.update(f, l);
            if (snp3.finished()) {
                this.sir.remove(i);
                continue;
            }
            if (bl) {
                snp3.y += (double)f * 0.03;
            } else {
                class_243 class_2433 = this.sjj(snp3);
                float f3 = Math.min(1.0f, f * 2.2f);
                snp3.x += (class_2433.field_1352 - snp3.x) * (double)f3;
                snp3.y += (class_2433.field_1351 - snp3.y) * (double)f3;
                snp3.z += (class_2433.field_1350 - snp3.z) * (double)f3;
            }
            boolean bl2 = !this.sij.get() && this.sjk(class_2432, snp3);
            snp3.hidden = snp3.hidden + ((bl2 ? 1.0f : 0.0f) - snp3.hidden) * f2;
        }
        if (this.sir.isEmpty()) {
            return;
        }
        this.sjg(class_3322, usn2);
    }

    private void sjf(long l) {
        List<skx> list = this.siv.lines();
        int n = this.siv.indexAt(l);
        if (this.siw >= 0 && n < this.siw && l > list.get(this.siw).start() - 1500L) {
            n = this.siw;
        }
        if (n != this.siw) {
            LyricsLine snp2;
            skx skx2;
            if (this.six != null) {
                this.six.dissolve();
                this.six = null;
            }
            this.siw = n;
            if (n >= 0 && !(skx2 = list.get(n)).blank() && l < skx2.end() && !(snp2 = LyricsLine.line(n, skx2, this.sis)).isEmpty()) {
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
    private void sjg(class_332 class_3322, ScreenProjection usn2) {
        GpuTextureView gpuTextureView = GlowSprite.view();
        int[] nArray = this.sjh();
        sng sng2 = new sng(nArray[0], nArray[1], (float)this.sif.get(), this.sig.get(), this.sih.get(), this.siz);
        this.sir.sort((snp2, snp3) -> Double.compare(usn2.distance(snp3.x, snp3.y, snp3.z), usn2.distance(snp2.x, snp2.y, snp2.z)));
        float f = (float)this.sib.get() * 0.3f;
        float f2 = usn2.height() * 0.16f;
        DrawUtil.beginBatch();
        try {
            for (LyricsLine snp4 : this.sir) {
                float f3;
                if (!usn2.project(snp4.x, snp4.y, snp4.z, this.sit) || (f3 = usn2.unitsPerBlock(snp4.x, snp4.y, snp4.z) * f) < 2.5f) continue;
                snp4.draw(class_3322, this.sit[0], this.sit[1], Math.min(f2, f3), sng2, gpuTextureView);
            }
        }
        finally {
            DrawUtil.additive(false);
            DrawUtil.endBatch();
        }
    }

    private int[] sjh() {
        if (this.sid.get() && NowPlaying.cover() != null) {
            int n = NowPlaying.coverColor() | 0xFF000000;
            return new int[]{n, ColorUtil.lerp(n, -1, 0.45f)};
        }
        return this.sie.vivid(new int[]{-7635722, -10556716});
    }

    private void sji(LyricsLine snp2) {
        class_4184 class_41842 = this.mc.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_71156();
        float f = class_41842.method_19330();
        float f2 = class_3532.method_15363((float)class_41842.method_19329(), (float)-50.0f, (float)50.0f);
        float f3 = (float)this.sic.get();
        float f4 = -3.4028235E38f;
        float f5 = 0.0f;
        float f6 = -8.0f;
        for (int i = 0; i < 10; ++i) {
            float f7 = (this.sis.nextFloat() * 2.0f - 1.0f) * 26.0f * f3;
            float f8 = snp2.card ? -(10.0f + this.sis.nextFloat() * 6.0f * f3) : -(6.0f + this.sis.nextFloat() * 10.0f * f3);
            float f9 = 14.0f;
            for (LyricsLine snp3 : this.sir) {
                double d = snp3.x - class_2432.field_1352;
                double d2 = snp3.y - class_2432.field_1351;
                double d3 = snp3.z - class_2432.field_1350;
                float f10 = (float)(class_3532.method_15349((double)d3, (double)d) * 57.2957763671875) - 90.0f;
                float f11 = (float)(-(class_3532.method_15349((double)d2, (double)Math.sqrt(d * d + d3 * d3)) * 57.2957763671875));
                float f12 = class_3532.method_15393((float)(f + f7 - f10));
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
        class_243 class_2433 = this.sjj(snp2);
        snp2.x = class_2433.field_1352;
        snp2.y = class_2433.field_1351;
        snp2.z = class_2433.field_1350;
    }

    private class_243 sjj(LyricsLine snp2) {
        double d;
        float f;
        class_243 class_2432;
        class_243 class_2433;
        class_4184 class_41842 = this.mc.field_1773.method_19418();
        class_243 class_2434 = class_41842.method_71156();
        class_3965 class_39652 = this.mc.field_1687.method_17742(new class_3959(class_2434, class_2433 = class_2434.method_1019((class_2432 = class_243.method_1030((float)(f = class_3532.method_15363((float)class_41842.method_19329(), (float)-50.0f, (float)50.0f) + snp2.pitchOff), (float)(class_41842.method_19330() + snp2.yawOff))).method_1021(d = (double)snp2.dist)), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)this.mc.field_1724));
        if (class_39652.method_17783() != class_239.class_240.field_1333) {
            d = Math.max(1.6, class_39652.method_17784().method_1022(class_2434) - 0.6);
        }
        return class_2434.method_1019(class_2432.method_1021(d));
    }

    private boolean sjk(class_243 class_2432, LyricsLine snp2) {
        class_243 class_2433 = new class_243(snp2.x, snp2.y, snp2.z);
        double d = class_2433.method_1022(class_2432);
        if (d < 0.5) {
            return false;
        }
        class_3965 class_39652 = this.mc.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_23142, class_3959.class_242.field_1348, (class_1297)this.mc.field_1724));
        return class_39652.method_17783() != class_239.class_240.field_1333 && class_39652.method_17784().method_1022(class_2432) < d - 0.3;
    }

    private static /* synthetic */ int cdu(int n, int n2) {
        return n + n2 | 0xEF997A21;
    }

    private static /* synthetic */ int cdv(int n, int n2) {
        return MusicAnchor.cdu(n, n2) * n2;
    }

    private static /* synthetic */ int cdw(int n, int n2) {
        return MusicAnchor.cdv(n, n2) * n2;
    }
}

