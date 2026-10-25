/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 */
package a;

import a.dtv;
import a.edj;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public final class eff {
    private static final MinecraftClient efg = MinecraftClient.getInstance();
    private boolean efh;
    private boolean efi;
    private boolean efj;
    private boolean efk;
    private boolean efl;
    private boolean efm;
    private boolean efn;
    private boolean efo;
    private boolean efp;
    private boolean efq;
    private boolean efr;
    private int efs;
    private int eft;
    private double efu;
    private double efv;
    private static /* synthetic */ long efw;
    private static /* synthetic */ int efx;

    public boolean isActive() {
        return this.efh;
    }

    public void setActive(boolean bl) {
        if (!bl && this.efh) {
            this.release();
            this.efi = true;
        }
        this.efh = bl;
    }

    public void setMovement(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.efj = bl;
        this.efk = bl2;
        this.efl = bl3;
        this.efm = bl4;
        this.efn = bl5;
        this.efo = bl6;
        this.efp = bl7;
    }

    public void setMouse(boolean bl, boolean bl2) {
        if (bl && !this.efq) {
            ++this.efs;
        }
        if (bl2 && !this.efr) {
            ++this.eft;
        }
        this.efq = bl;
        this.efr = bl2;
    }

    public void addLook(double d, double d2) {
        this.efu += d;
        this.efv += d2;
    }

    void release() {
        this.efj = false;
        this.efk = false;
        this.efl = false;
        this.efm = false;
        this.efn = false;
        this.efo = false;
        this.efp = false;
        this.efq = false;
        this.efr = false;
        this.efs = 0;
        this.eft = 0;
        this.efu = 0.0;
        this.efv = 0.0;
    }

    void apply(dtv dtv2) {
        if (eff.efg.player == null) {
            return;
        }
        GameOptions gameOptions = eff.efg.options;
        if (this.efi) {
            this.efi = false;
            if (!dtv2.isActive()) {
                for (KeyBinding keyBinding : new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey, gameOptions.sneakKey, gameOptions.sprintKey, gameOptions.attackKey, gameOptions.useKey}) {
                    keyBinding.setPressed(false);
                }
            }
        }
        if (!this.efh) {
            return;
        }
        boolean bl = !dtv2.isActive();
        eff.efy(gameOptions.forwardKey, this.efj, bl);
        eff.efy(gameOptions.backKey, this.efk, bl);
        eff.efy(gameOptions.leftKey, this.efl, bl);
        eff.efy(gameOptions.rightKey, this.efm, bl);
        eff.efy(gameOptions.jumpKey, this.efn, bl);
        eff.efy(gameOptions.sneakKey, this.efo, bl);
        eff.efy(gameOptions.sprintKey, this.efp, bl);
        eff.efy(gameOptions.attackKey, this.efq, bl);
        eff.efy(gameOptions.useKey, this.efr, bl);
        while (this.efs > 0) {
            edj.click(gameOptions.attackKey);
            --this.efs;
        }
        while (this.eft > 0) {
            edj.click(gameOptions.useKey);
            --this.eft;
        }
        if (this.efu != 0.0 || this.efv != 0.0) {
            double d = dtv2.mouseMultiplier();
            double d2 = (Boolean)gameOptions.getInvertMouseY().getValue() != false ? -1.0 : 1.0;
            eff.efg.player.changeLookDirection(this.efu * d, this.efv * d * d2);
            this.efu = 0.0;
            this.efv = 0.0;
        }
    }

    private static void efy(KeyBinding keyBinding, boolean bl, boolean bl2) {
        if (bl) {
            keyBinding.setPressed(true);
        } else if (bl2) {
            keyBinding.setPressed(false);
        }
    }

    boolean isHeld(KeyBinding keyBinding) {
        if (!this.efh || keyBinding == null || eff.efg.options == null) {
            return false;
        }
        GameOptions gameOptions = eff.efg.options;
        if (keyBinding == gameOptions.forwardKey) {
            return this.efj;
        }
        if (keyBinding == gameOptions.backKey) {
            return this.efk;
        }
        if (keyBinding == gameOptions.leftKey) {
            return this.efl;
        }
        if (keyBinding == gameOptions.rightKey) {
            return this.efm;
        }
        if (keyBinding == gameOptions.jumpKey) {
            return this.efn;
        }
        if (keyBinding == gameOptions.sneakKey) {
            return this.efo;
        }
        if (keyBinding == gameOptions.sprintKey) {
            return this.efp;
        }
        if (keyBinding == gameOptions.attackKey) {
            return this.efq;
        }
        return keyBinding == gameOptions.useKey && this.efr;
    }

    private static /* synthetic */ int di(int n, int n2) {
        return n + n2 | 0xF0638363;
    }

    private static /* synthetic */ int dj(int n, int n2) {
        return n * n2 | 0x1BF7F210;
    }
}

