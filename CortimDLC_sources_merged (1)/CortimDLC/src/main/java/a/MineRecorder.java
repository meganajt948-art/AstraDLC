/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.Box3;
import a.pzp;
import a.TimerTextParser;
import a.AngleUtil;
import a.StudioProfiles;
import a.BlockKind;
import a.PlayerState;
import a.MineScoring;
import a.MineSnapshots;
import a.tte;
import a.tut;
import a.tuw;
import a.tuz;
import a.MineRecordingReader;
import a.MineSnap;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import net.minecraft.class_746;

public final class MineRecorder {
    private static final int ttm = 1200;
    private static final long ttn = 180000L;
    private static final int tto = 12;
    private static final int ttp = 40;
    private static final int ttq = 200;
    private static final double ttr = 24.0;
    public final StudioProfiles profile;
    private final String tts;
    private final MineRecordingReader ttt = new MineRecordingReader();
    private final List<tte> ttu = new ArrayList<tte>();
    private final int[] ttv = new int[2];
    private boolean ttw;
    private boolean ttx = true;
    private int tty;
    private class_638 ttz;
    private Box3 tua;
    private int tub = -200;
    private MineSnap tuc;
    private int tud;
    private int tue;
    private int tuf;
    private int tug;
    private int tuh;
    private int tui;
    private boolean tuj;
    private boolean tuk;
    private long tul = System.currentTimeMillis();
    public int blocks;
    public int decisions;
    public int diamonds;
    public int farmed;
    public int recorded;
    public boolean paused = true;
    public String pauseReason = "";
    private static /* synthetic */ String tum;
    private static /* synthetic */ boolean tun;

    public MineRecorder(StudioProfiles tiq2, float f) {
        this.profile = tiq2;
        this.tts = tiq2.newTapeName();
        this.ttt.created = System.currentTimeMillis();
        this.ttt.unit = f;
    }

    public boolean mineFound() {
        return this.tua != null;
    }

    public int seconds() {
        return this.recorded / 20;
    }

    public int[] unsaved() {
        return new int[]{this.blocks - this.tue, this.decisions - this.tuf, this.recorded - this.tug, this.diamonds - this.tuh, this.farmed - this.tui};
    }

    public void attack(class_310 class_3102, class_2338 class_23382, class_2350 class_23502) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1687 == null) {
            return;
        }
        class_2680 class_26802 = class_3102.field_1687.method_8320(class_23382);
        byte by = MineSnapshots.kind((class_1937)class_3102.field_1687, class_23382, class_26802);
        if (!BlockKind.minable(by)) {
            return;
        }
        if (this.tua != null && !this.tua.contains(class_23382)) {
            by = 4;
        }
        this.ttu.add(new tte(class_23382.method_10062(), class_23502, MineRecorder.tuo(class_3102, class_7462, class_23382, class_23502), by));
    }

    public void broken(class_2680 class_26802) {
        if (!this.paused && MineSnapshots.diamond(class_26802)) {
            ++this.diamonds;
        }
    }

    private static class_243 tuo(class_310 class_3102, class_746 class_7462, class_2338 class_23382, class_2350 class_23502) {
        Optional optional;
        class_3965 class_39652;
        class_239 class_2392 = class_3102.field_1765;
        if (class_2392 instanceof class_3965) {
            class_39652 = (class_3965)class_2392;
            if (class_2392.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382)) {
                return class_39652.method_17784();
            }
        }
        if ((optional = new class_238(class_23382).method_992((class_243)(class_39652 = class_7462.method_33571()), class_39652.method_1019(class_7462.method_5828(1.0f).method_1021(6.0)))).isPresent()) {
            return (class_243)optional.get();
        }
        return class_243.method_24953((class_2382)class_23382).method_1031((double)class_23502.method_10148() * 0.5, (double)class_23502.method_10164() * 0.5, (double)class_23502.method_10165() * 0.5);
    }

    public void pause(String string) {
        this.paused = true;
        this.pauseReason = string;
        this.ttx = true;
        this.tuc = null;
        this.ttu.clear();
    }

    public void tick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        class_638 class_6382 = class_3102.field_1687;
        if (class_7462 == null || class_6382 == null) {
            this.pause("dead");
            return;
        }
        if (class_6382 != this.ttz) {
            this.ttz = class_6382;
            this.tua = null;
            this.tub = -200;
            this.ttx = true;
            this.tuc = null;
        }
        class_243 class_2432 = class_7462.method_33571();
        if (!this.ttw) {
            this.ttw = true;
            this.ttt.ox = (int)Math.floor(class_2432.field_1352);
            this.ttt.oy = (int)Math.floor(class_2432.field_1351);
            this.ttt.oz = (int)Math.floor(class_2432.field_1350);
        }
        this.paused = false;
        this.pauseReason = "";
        int n = this.ttt.ticks.size();
        this.tup(class_3102, class_7462, n);
        class_315 class_3152 = class_3102.field_1690;
        int n2 = (class_3152.field_1894.method_1434() ? 1 : 0) | (class_3152.field_1881.method_1434() ? 2 : 0) | (class_3152.field_1913.method_1434() ? 4 : 0) | (class_3152.field_1849.method_1434() ? 8 : 0) | (class_3152.field_1903.method_1434() ? 16 : 0) | (class_7462.method_5624() ? 32 : 0) | (class_3152.field_1832.method_1434() ? 64 : 0);
        tuz tuz2 = new tuz();
        tuz2.flags = 1 | (class_7462.method_24828() ? 2 : 0) | (this.ttx ? 4 : 0) | (class_7462.method_5624() ? 8 : 0) | (class_7462.method_5715() ? 16 : 0) | ((n2 & 0x1F) != 0 ? 32 : 0) | (class_3152.field_1886.method_1434() ? 64 : 0);
        tuz2.keys = n2;
        if (this.ttx) {
            this.tty = n;
            this.ttx = false;
            this.tuc = null;
        }
        tuz2.yaw = class_7462.method_36454();
        tuz2.pitch = class_7462.method_36455();
        tuz2.x = (float)(class_2432.field_1352 - (double)this.ttt.ox);
        tuz2.y = (float)(class_2432.field_1351 - (double)this.ttt.oy);
        tuz2.z = (float)(class_2432.field_1350 - (double)this.ttt.oz);
        tuz2.vx = (float)(class_7462.method_23317() - class_7462.field_6014);
        tuz2.vy = (float)(class_7462.method_23318() - class_7462.field_6036);
        tuz2.vz = (float)(class_7462.method_23321() - class_7462.field_5969);
        tuz2.feetY = MineSnapshots.standing((class_1937)class_6382, class_7462).method_10264() - this.ttt.oy;
        MineSnap tvn2 = MineSnapshots.snap((class_1937)class_6382, class_7462, class_7462.method_24515(), this.tua, null, null);
        MineScoring.diff(this.tuc, tvn2, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, this.ttv);
        tuz2.farm = (short)Math.min(Short.MAX_VALUE, this.ttv[0]);
        tuz2.dia = (byte)Math.min(127, this.ttv[1]);
        this.farmed += this.ttv[0];
        this.tuc = tvn2;
        tuz2.sx = tvn2.x0 - this.ttt.ox;
        tuz2.sy = tvn2.y0 - this.ttt.oy;
        tuz2.sz = tvn2.z0 - this.ttt.oz;
        tuz2.snap = MineRecordingReader.pack(tvn2.cells);
        this.ttt.ticks.add(tuz2);
        for (tte tte2 : this.ttu) {
            this.tuq(tte2, n);
        }
        this.ttu.clear();
        ++this.recorded;
        if (n + 1 - this.tud >= 1200) {
            this.save();
        }
    }

    private void tup(class_310 class_3102, class_746 class_7462, int n) {
        class_243 class_2432 = class_7462.method_73189();
        if (this.tua != null) {
            if (this.tua.distanceTo(class_2432) <= 24.0) {
                return;
            }
            this.tua = null;
            this.tuc = null;
        }
        if (n - this.tub < 200) {
            return;
        }
        this.tub = n;
        pzp pzp2 = TimerTextParser.read(class_3102, 72.0);
        Box3 pzc2 = Box3.detect((class_1937)this.ttz, pzp2 != null ? pzp2.pos() : class_2432);
        if (pzc2 != null && pzc2.distanceTo(class_2432) <= 24.0) {
            this.tua = pzc2;
            this.tuc = null;
        }
    }

    private void tuq(tte tte2, int n) {
        Object object;
        tuw tuw2 = new tuw();
        tuw2.tick = n;
        tuw2.x = tte2.pos().method_10263() - this.ttt.ox;
        tuw2.y = tte2.pos().method_10264() - this.ttt.oy;
        tuw2.z = tte2.pos().method_10260() - this.ttt.oz;
        tuw2.face = (byte)tte2.side().ordinal();
        tuw2.px = (float)(tte2.point().field_1352 - (double)this.ttt.ox);
        tuw2.py = (float)(tte2.point().field_1351 - (double)this.ttt.oy);
        tuw2.pz = (float)(tte2.point().field_1350 - (double)this.ttt.oz);
        tuw2.cell = tte2.cell();
        int n2 = this.ttt.hits.size();
        tuw tuw3 = n2 > 0 ? this.ttt.hits.get(n2 - 1) : null;
        this.ttt.hits.add(tuw2);
        ++this.blocks;
        int n3 = Math.max(this.tty, n - 12);
        if (tuw3 != null && tuw3.tick >= this.tty) {
            n3 = Math.max(n3, tuw3.tick);
        }
        if (n3 >= n) {
            return;
        }
        int n4 = this.tur(tuw2, n, n3);
        tuz tuz2 = this.ttt.ticks.get(n4);
        if (tuz2.snap == null) {
            return;
        }
        PlayerState tra2 = new PlayerState();
        tra2.ex = tuz2.x;
        tra2.ey = tuz2.y;
        tra2.ez = tuz2.z;
        tra2.yaw = tuz2.yaw;
        tra2.pitch = tuz2.pitch;
        if (n4 - 2 >= this.tty) {
            object = this.ttt.ticks.get(n4 - 2);
            tra2.vyaw = (float)(AngleUtil.wrap(tuz2.yaw - ((tuz)object).yaw) * 0.5);
            tra2.vpitch = (tuz2.pitch - ((tuz)object).pitch) * 0.5f;
        } else if (n4 - 1 >= this.tty) {
            object = this.ttt.ticks.get(n4 - 1);
            tra2.vyaw = (float)AngleUtil.wrap(tuz2.yaw - ((tuz)object).yaw);
            tra2.vpitch = tuz2.pitch - ((tuz)object).pitch;
        }
        tra2.vx = tuz2.vx;
        tra2.vz = tuz2.vz;
        tra2.ground = (tuz2.flags & 2) != 0;
        tra2.feetY = tuz2.feetY;
        if (tuw3 != null && n - tuw3.tick <= 40 && tuw3.tick <= n4 && tuw3.tick >= this.tty) {
            tra2.hasPrev = true;
            tra2.px = tuw3.x;
            tra2.py = tuw3.y;
            tra2.pz = tuw3.z;
        }
        object = new tut();
        ((tut)object).tick = n4;
        ((tut)object).hit = n2;
        ((tut)object).ctx = tra2;
        this.ttt.decisions.add((tut)object);
        ++this.decisions;
    }

    private int tur(tuw tuw2, int n, int n2) {
        double d = MineRecorder.tus(this.ttt.ticks.get(n), tuw2);
        for (int i = n - 1; i >= n2; --i) {
            double d2 = MineRecorder.tus(this.ttt.ticks.get(i), tuw2);
            if (d2 <= d + 0.3) {
                return i;
            }
            d = d2;
        }
        return n2;
    }

    private static double tus(tuz tuz2, tuw tuw2) {
        double d = tuw2.px - tuz2.x;
        double d2 = tuw2.py - tuz2.y;
        double d3 = tuw2.pz - tuz2.z;
        double d4 = AngleUtil.wrap(AngleUtil.yawTo(d, d3) - (double)tuz2.yaw);
        double d5 = AngleUtil.pitchTo(d2, Math.sqrt(d * d + d3 * d3)) - (double)tuz2.pitch;
        return Math.hypot(d4, d5);
    }

    public void save() {
        int n = this.ttt.ticks.size();
        if (n <= this.tud && this.blocks == this.tue && !this.tuk) {
            return;
        }
        this.profile.add("mine.blocks", this.blocks - this.tue);
        this.profile.add("mine.decisions", this.decisions - this.tuf);
        this.profile.add("mine.ticks", this.recorded - this.tug);
        this.profile.add("mine.diamonds", this.diamonds - this.tuh);
        this.profile.add("mine.farmed", this.farmed - this.tui);
        this.tue = this.blocks;
        this.tuf = this.decisions;
        this.tug = this.recorded;
        this.tuh = this.diamonds;
        this.tui = this.farmed;
        this.tud = n;
        this.profile.save();
        MineRecordingReader tvc2 = this.ttt.frozen();
        this.profile.putMineTape(this.tts, tvc2);
        long l = System.currentTimeMillis();
        if (this.tuk || l - this.tul > 180000L) {
            this.tuk = false;
            this.tul = l;
            this.profile.uploadMineTape(this.tts, tvc2);
        }
    }

    public void finish() {
        if (this.recorded > 0 && !this.tuj) {
            this.tuj = true;
            this.profile.add("sessions", 1L);
        }
        this.tuk = this.recorded > 0;
        this.save();
    }

    private static /* synthetic */ int cqz(int n, int n2) {
        return n ^ n2 | 0xC1210D40;
    }
}

