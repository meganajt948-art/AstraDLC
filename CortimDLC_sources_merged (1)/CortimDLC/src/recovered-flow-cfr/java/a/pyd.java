/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.prz;
import a.psc;
import a.psf;
import a.pud;
import a.pvb;
import a.pve;
import a.tvt;
import a.tvw;
import a.tvz;
import a.txs;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class pyd {
    private static final int pye = 14;
    private static final int pyf = 5;
    private static final int pyg = 4;
    public final pve stride = new pve();
    private final Random pyh = new Random();
    private tvz pyi;
    private psf pyj;
    private Vec3d pyk;
    private int pyl;
    private psf pym;
    private int pyn;
    private boolean pyo;
    private double pyp;
    private double pyq;
    private double pyr = Double.NaN;
    private boolean pys;
    private int pyt;
    private double pyu;
    private int pyv;
    private int pyw;
    private int pyx;
    private long pyy = -1L;
    private boolean pyz;
    private static /* synthetic */ boolean pza;
    private static /* synthetic */ boolean pzb;

    public void personalize(long l) {
        this.stride.personalize(l);
    }

    public psc style() {
        return this.stride.routeStyle();
    }

    public void reset() {
        this.stride.reset();
        this.pyj = null;
        this.pyk = null;
        this.pyo = false;
        this.pys = false;
        this.pyt = 0;
        this.pyv = 0;
        this.pyy = -1L;
        if (this.pyi != null) {
            this.pyi.reset();
        }
    }

    public void beginTick() {
        this.pym = null;
        this.pys = false;
        this.pyo = false;
        this.pyr = Double.NaN;
    }

    public boolean drove() {
        return this.pys;
    }

    public boolean neural() {
        return this.pys && this.pyz;
    }

    public psf shown() {
        return this.pym;
    }

    public int shownAt() {
        return this.pyn;
    }

    public double moveYaw(double d) {
        return Double.isNaN(this.pyr) ? d : this.pyr;
    }

    public boolean takeTurn(double[] dArray) {
        if (!this.pyo) {
            return false;
        }
        this.pyo = false;
        dArray[0] = this.pyp;
        dArray[1] = this.pyq;
        return true;
    }

    public tvz brain() {
        return this.pyi;
    }

    public double remaining(psf psf2) {
        if (psf2 == null) {
            return 0.0;
        }
        return this.stride.route() == psf2 ? psf2.track.length() - this.stride.progress() : psf2.track.length();
    }

    public psf plan(World world, PlayerEntity playerEntity, List<BlockPos> list, BlockPos blockPos, prz prz2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            return psf.of(world, (Entity)playerEntity, playerEntity.getEntityPos(), list, blockPos, this.style(), prz2, this.pyh);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public int walkTo(MinecraftClient minecraftClient, PlayerEntity playerEntity, World world, Vec3d vec3d, float f, float f2, Vec3d vec3d2, boolean bl, boolean bl2, txs txs2) {
        ++this.pyl;
        if (this.pyj == null || this.pyk == null || this.pyk.squaredDistanceTo(vec3d) > 0.36 || this.pyl > 60) {
            this.pyj = psf.direct(world, (Entity)playerEntity, playerEntity.getEntityPos(), vec3d);
            this.pyk = vec3d;
            this.pyl = 0;
        }
        if (this.pyj == null) {
            return 1;
        }
        int n = this.follow(minecraftClient, playerEntity, world, this.pyj, f, f2, vec3d2, bl, bl2, txs2);
        if (n == 2) {
            this.pyj = null;
        }
        return n;
    }

    public int follow(MinecraftClient minecraftClient, PlayerEntity playerEntity, World world, psf psf2, float f, float f2, Vec3d vec3d, boolean bl, boolean bl2, txs txs2) {
        Object object;
        boolean bl3;
        int n = this.stride.track(playerEntity, psf2);
        this.pym = psf2;
        this.pyn = this.stride.at();
        if (psf2.id != this.pyy) {
            this.pyy = psf2.id;
            this.pyu = this.stride.progress();
            this.pyv = 0;
            this.pyw = 0;
            this.pyx = 0;
        }
        if (n != 0 || bl2) {
            return n;
        }
        this.pys = true;
        boolean bl4 = bl3 = playerEntity.getHungerManager().getFoodLevel() > 6 && !playerEntity.isUsingItem();
        if (txs2 != null && this.pyt <= 0) {
            if (this.pyi == null || this.pyi.model != txs2) {
                this.pyi = new tvz(txs2);
            }
            object = this.pyi.decide(world, playerEntity, psf2.track, this.stride.at(), f, f2, bl3);
            double d = this.stride.progress();
            double d2 = Math.hypot(playerEntity.getX() - playerEntity.lastX, playerEntity.getZ() - playerEntity.lastZ);
            if (d > this.pyu + 0.3) {
                this.pyu = d;
                this.pyv = 0;
            } else if (++this.pyv > 14) {
                this.pyv = 0;
                this.pyt = 40;
            }
            int n2 = this.pyw = d2 < 0.02 ? this.pyw + 1 : 0;
            if (this.pyw >= 5 && psf2.track.length() - d > 1.0) {
                this.pyw = 0;
                this.pyt = 30;
            }
            boolean bl5 = Math.abs(tvt.wrap(this.stride.aheadYaw(playerEntity, 1.6) - ((double)f + ((tvw)object).dyaw))) > 110.0;
            int n3 = this.pyx = bl5 && !((tvw)object).forward ? this.pyx + 1 : 0;
            if (this.pyx >= 4) {
                this.pyx = 0;
                this.pyt = 25;
            }
            if (this.pyt <= 0 && this.stride.safe(playerEntity, world, ((tvw)object).forward, ((tvw)object).back, ((tvw)object).left, ((tvw)object).right, ((tvw)object).sprint, ((tvw)object).jump, (double)f + ((tvw)object).dyaw)) {
                float f3;
                float f4 = ((tvw)object).forward ? 1.0f : (f3 = ((tvw)object).back ? -1.0f : 0.0f);
                float f5 = ((tvw)object).left ? 1.0f : (((tvw)object).right ? -1.0f : 0.0f);
                this.pyr = f3 == 0.0f && f5 == 0.0f ? (double)f : Math.toDegrees(pud.inputDirection((float)((double)f + ((tvw)object).dyaw), f3, f5));
                boolean bl6 = ((tvw)object).jump || (f3 != 0.0f || f5 != 0.0f) && this.stride.mustJump(playerEntity, this.pyr);
                pyd.apply(minecraftClient, ((tvw)object).forward, ((tvw)object).back, ((tvw)object).left, ((tvw)object).right, bl6, ((tvw)object).sprint);
                this.pyi.jumped(bl6);
                this.pyp = ((tvw)object).dyaw;
                this.pyq = ((tvw)object).dpitch;
                this.pyo = true;
                this.pyz = true;
                return 0;
            }
            if (this.pyt <= 0) {
                this.pyt = 12;
            }
        }
        if (this.pyt > 0) {
            --this.pyt;
        }
        object = this.stride.drive(playerEntity, world, f, f2, vec3d, bl, bl3);
        if (!this.stride.safe(playerEntity, world, ((pvb)object).forward, ((pvb)object).back, ((pvb)object).left, ((pvb)object).right, ((pvb)object).sprint, ((pvb)object).jump, (double)f + ((pvb)object).dyaw)) {
            object = this.stride.cautious(playerEntity, world, f);
        }
        pyd.apply(minecraftClient, ((pvb)object).forward, ((pvb)object).back, ((pvb)object).left, ((pvb)object).right, ((pvb)object).jump, ((pvb)object).sprint);
        if (this.pyi != null) {
            this.pyi.jumped(((pvb)object).jump);
        }
        this.pyp = ((pvb)object).dyaw;
        this.pyq = ((pvb)object).dpitch;
        this.pyo = true;
        this.pyz = false;
        this.pyr = ((pvb)object).moveYaw;
        return 0;
    }

    public static void apply(MinecraftClient minecraftClient, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        GameOptions gameOptions = minecraftClient.options;
        if (gameOptions == null) {
            return;
        }
        gameOptions.forwardKey.setPressed(bl);
        gameOptions.backKey.setPressed(bl2);
        gameOptions.leftKey.setPressed(bl3);
        gameOptions.rightKey.setPressed(bl4);
        gameOptions.jumpKey.setPressed(bl5);
        pyd.setSprint(gameOptions, bl6);
    }

    public static void setSprint(GameOptions gameOptions, boolean bl) {
        KeyBinding keyBinding = gameOptions.sprintKey;
        if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            if (bl != keyBinding.isPressed()) {
                keyBinding.setPressed(true);
            }
        } else {
            keyBinding.setPressed(bl);
        }
    }

    private static /* synthetic */ int bpt(int n, int n2) {
        return n ^ n2 | 0xB1DE3110;
    }

    private static /* synthetic */ int bpu(int n, int n2) {
        return n + n2 + 918883952;
    }

    private static /* synthetic */ int bpv(int n, int n2) {
        return pyd.bpt(n, n2) ^ 0x77BFC079;
    }
}

