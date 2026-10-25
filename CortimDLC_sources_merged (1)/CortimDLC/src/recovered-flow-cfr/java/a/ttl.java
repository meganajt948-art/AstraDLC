/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package a;

import a.pzc;
import a.pzp;
import a.pzw;
import a.tbp;
import a.tiq;
import a.tpx;
import a.tra;
import a.trd;
import a.tsh;
import a.tte;
import a.tut;
import a.tuw;
import a.tuz;
import a.tvc;
import a.tvn;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public final class ttl {
    private static final int ttm = 1200;
    private static final long ttn = 180000L;
    private static final int tto = 12;
    private static final int ttp = 40;
    private static final int ttq = 200;
    private static final double ttr = 24.0;
    public final tiq profile;
    private final String tts;
    private final tvc ttt = new tvc();
    private final List<tte> ttu = new ArrayList<tte>();
    private final int[] ttv = new int[2];
    private boolean ttw;
    private boolean ttx = true;
    private int tty;
    private ClientWorld ttz;
    private pzc tua;
    private int tub = -200;
    private tvn tuc;
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

    public ttl(tiq tiq2, float f) {
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

    public void attack(MinecraftClient minecraftClient, BlockPos blockPos, Direction direction) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || minecraftClient.field_1687 == null) {
            return;
        }
        BlockState blockState = minecraftClient.field_1687.method_8320(blockPos);
        byte by = tsh.kind((World)minecraftClient.field_1687, blockPos, blockState);
        if (!tpx.minable(by)) {
            return;
        }
        if (this.tua != null && !this.tua.contains(blockPos)) {
            by = 4;
        }
        this.ttu.add(new tte(blockPos.method_10062(), direction, ttl.tuo(minecraftClient, clientPlayerEntity, blockPos, direction), by));
    }

    public void broken(BlockState blockState) {
        if (!this.paused && tsh.diamond(blockState)) {
            ++this.diamonds;
        }
    }

    private static Vec3d tuo(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos, Direction direction) {
        Optional optional;
        BlockHitResult blockHitResult;
        HitResult hitResult = minecraftClient.field_1765;
        if (hitResult instanceof BlockHitResult) {
            blockHitResult = (BlockHitResult)hitResult;
            if (hitResult.method_17783() == HitResult.Type.field_1332 && blockHitResult.method_17777().equals((Object)blockPos)) {
                return blockHitResult.method_17784();
            }
        }
        if ((optional = new Box(blockPos).method_992((Vec3d)(blockHitResult = clientPlayerEntity.method_33571()), blockHitResult.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(6.0)))).isPresent()) {
            return (Vec3d)optional.get();
        }
        return Vec3d.method_24953((Vec3i)blockPos).method_1031((double)direction.method_10148() * 0.5, (double)direction.method_10164() * 0.5, (double)direction.method_10165() * 0.5);
    }

    public void pause(String string) {
        this.paused = true;
        this.pauseReason = string;
        this.ttx = true;
        this.tuc = null;
        this.ttu.clear();
    }

    public void tick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        ClientWorld clientWorld = minecraftClient.field_1687;
        if (clientPlayerEntity == null || clientWorld == null) {
            this.pause(a.b("\u9b9e\ue22e\u68f9\uf68d", -937255938));
            return;
        }
        if (clientWorld != this.ttz) {
            this.ttz = clientWorld;
            this.tua = null;
            this.tub = -200;
            this.ttx = true;
            this.tuc = null;
        }
        Vec3d vec3d = clientPlayerEntity.method_33571();
        if (!this.ttw) {
            this.ttw = true;
            this.ttt.ox = (int)Math.floor(vec3d.field_1352);
            this.ttt.oy = (int)Math.floor(vec3d.field_1351);
            this.ttt.oz = (int)Math.floor(vec3d.field_1350);
        }
        this.paused = false;
        this.pauseReason = "";
        int n = this.ttt.ticks.size();
        this.tup(minecraftClient, clientPlayerEntity, n);
        GameOptions gameOptions = minecraftClient.field_1690;
        int n2 = (gameOptions.field_1894.method_1434() ? 1 : 0) | (gameOptions.field_1881.method_1434() ? 2 : 0) | (gameOptions.field_1913.method_1434() ? 4 : 0) | (gameOptions.field_1849.method_1434() ? 8 : 0) | (gameOptions.field_1903.method_1434() ? 16 : 0) | (clientPlayerEntity.method_5624() ? 32 : 0) | (gameOptions.field_1832.method_1434() ? 64 : 0);
        tuz tuz2 = new tuz();
        tuz2.flags = 1 | (clientPlayerEntity.method_24828() ? 2 : 0) | (this.ttx ? 4 : 0) | (clientPlayerEntity.method_5624() ? 8 : 0) | (clientPlayerEntity.method_5715() ? 16 : 0) | ((n2 & 0x1F) != 0 ? 32 : 0) | (gameOptions.field_1886.method_1434() ? 64 : 0);
        tuz2.keys = n2;
        if (this.ttx) {
            this.tty = n;
            this.ttx = false;
            this.tuc = null;
        }
        tuz2.yaw = clientPlayerEntity.method_36454();
        tuz2.pitch = clientPlayerEntity.method_36455();
        tuz2.x = (float)(vec3d.field_1352 - (double)this.ttt.ox);
        tuz2.y = (float)(vec3d.field_1351 - (double)this.ttt.oy);
        tuz2.z = (float)(vec3d.field_1350 - (double)this.ttt.oz);
        tuz2.vx = (float)(clientPlayerEntity.method_23317() - clientPlayerEntity.field_6014);
        tuz2.vy = (float)(clientPlayerEntity.method_23318() - clientPlayerEntity.field_6036);
        tuz2.vz = (float)(clientPlayerEntity.method_23321() - clientPlayerEntity.field_5969);
        tuz2.feetY = tsh.standing((World)clientWorld, clientPlayerEntity).method_10264() - this.ttt.oy;
        tvn tvn2 = tsh.snap((World)clientWorld, clientPlayerEntity, clientPlayerEntity.method_24515(), this.tua, null, null);
        trd.diff(this.tuc, tvn2, vec3d.field_1352, vec3d.field_1351, vec3d.field_1350, this.ttv);
        tuz2.farm = (short)Math.min(Short.MAX_VALUE, this.ttv[0]);
        tuz2.dia = (byte)Math.min(127, this.ttv[1]);
        this.farmed += this.ttv[0];
        this.tuc = tvn2;
        tuz2.sx = tvn2.x0 - this.ttt.ox;
        tuz2.sy = tvn2.y0 - this.ttt.oy;
        tuz2.sz = tvn2.z0 - this.ttt.oz;
        tuz2.snap = tvc.pack(tvn2.cells);
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

    private void tup(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, int n) {
        Vec3d vec3d = clientPlayerEntity.method_73189();
        if (this.tua != null) {
            if (this.tua.distanceTo(vec3d) <= 24.0) {
                return;
            }
            this.tua = null;
            this.tuc = null;
        }
        if (n - this.tub < 200) {
            return;
        }
        this.tub = n;
        pzp pzp2 = pzw.read(minecraftClient, 72.0);
        pzc pzc2 = pzc.detect((World)this.ttz, pzp2 != null ? pzp2.pos() : vec3d);
        if (pzc2 != null && pzc2.distanceTo(vec3d) <= 24.0) {
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
        tra tra2 = new tra();
        tra2.ex = tuz2.x;
        tra2.ey = tuz2.y;
        tra2.ez = tuz2.z;
        tra2.yaw = tuz2.yaw;
        tra2.pitch = tuz2.pitch;
        if (n4 - 2 >= this.tty) {
            object = this.ttt.ticks.get(n4 - 2);
            tra2.vyaw = (float)(tbp.wrap(tuz2.yaw - ((tuz)object).yaw) * 0.5);
            tra2.vpitch = (tuz2.pitch - ((tuz)object).pitch) * 0.5f;
        } else if (n4 - 1 >= this.tty) {
            object = this.ttt.ticks.get(n4 - 1);
            tra2.vyaw = (float)tbp.wrap(tuz2.yaw - ((tuz)object).yaw);
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
        double d = ttl.tus(this.ttt.ticks.get(n), tuw2);
        for (int i = n - 1; i >= n2; --i) {
            double d2 = ttl.tus(this.ttt.ticks.get(i), tuw2);
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
        double d4 = tbp.wrap(tbp.yawTo(d, d3) - (double)tuz2.yaw);
        double d5 = tbp.pitchTo(d2, Math.sqrt(d * d + d3 * d3)) - (double)tuz2.pitch;
        return Math.hypot(d4, d5);
    }

    public void save() {
        int n = this.ttt.ticks.size();
        if (n <= this.tud && this.blocks == this.tue && !this.tuk) {
            return;
        }
        this.profile.add(a.b("\uf712\u8ea7\u0473\u9a09\u1195\u9768\u2d35\ua4c7\u3a94\ub02d\u37e6", -185337996), this.blocks - this.tue);
        this.profile.add(a.d("\uffb4\u8601\u0cd5\u92af\u1933\u9fc8\u259a\uac6d\u3238\ub893\u3f5a\uc52d\u4bfb\ud257", 1925126449, 887023334), this.decisions - this.tuf);
        this.profile.add(a.c(846058615, "\ud410\uada5\u2771\ub90b\u3297\ub47c\u0e32\u87c9\u199e\u9337"), this.recorded - this.tug);
        this.profile.add(a.d("\udbad\ua218\u28cc\ub6b6\u3d2a\ubbd1\u018f\u8876\u1625\u9c96\u1b44\ue13f\u6fff", -625798739, 303811168), this.diamonds - this.tuh);
        this.profile.add(a.b("\u19b1\u6004\uead0\u74aa\uff36\u79cf\uc39b\u4a79\ud439\u5e80\ud952", 1519196631), this.farmed - this.tui);
        this.tue = this.blocks;
        this.tuf = this.decisions;
        this.tug = this.recorded;
        this.tuh = this.diamonds;
        this.tui = this.farmed;
        this.tud = n;
        this.profile.save();
        tvc tvc2 = this.ttt.frozen();
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
            this.profile.add(a.c(-810234074, "\ucf5d\ub6fa\u3c3f\ua24e\u2983\uaf34\u1566\u9c8a"), 1L);
        }
        this.tuk = this.recorded > 0;
        this.save();
    }

    private static /* synthetic */ int cqz(int n, int n2) {
        return n ^ n2 | 0xC1210D40;
    }
}

