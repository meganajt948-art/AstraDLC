/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 */
package a;

import a.Bot;
import a.ClientContextSwitcher;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;

public final class BotRemoteInput {
    private static final class_310 efg = class_310.method_1551();
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

    void apply(Bot dtv2) {
        if (BotRemoteInput.efg.field_1724 == null) {
            return;
        }
        class_315 class_3152 = BotRemoteInput.efg.field_1690;
        if (this.efi) {
            this.efi = false;
            if (!dtv2.isActive()) {
                for (class_304 class_3042 : new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903, class_3152.field_1832, class_3152.field_1867, class_3152.field_1886, class_3152.field_1904}) {
                    class_3042.method_23481(false);
                }
            }
        }
        if (!this.efh) {
            return;
        }
        boolean bl = !dtv2.isActive();
        BotRemoteInput.efy(class_3152.field_1894, this.efj, bl);
        BotRemoteInput.efy(class_3152.field_1881, this.efk, bl);
        BotRemoteInput.efy(class_3152.field_1913, this.efl, bl);
        BotRemoteInput.efy(class_3152.field_1849, this.efm, bl);
        BotRemoteInput.efy(class_3152.field_1903, this.efn, bl);
        BotRemoteInput.efy(class_3152.field_1832, this.efo, bl);
        BotRemoteInput.efy(class_3152.field_1867, this.efp, bl);
        BotRemoteInput.efy(class_3152.field_1886, this.efq, bl);
        BotRemoteInput.efy(class_3152.field_1904, this.efr, bl);
        while (this.efs > 0) {
            ClientContextSwitcher.click(class_3152.field_1886);
            --this.efs;
        }
        while (this.eft > 0) {
            ClientContextSwitcher.click(class_3152.field_1904);
            --this.eft;
        }
        if (this.efu != 0.0 || this.efv != 0.0) {
            double d = dtv2.mouseMultiplier();
            double d2 = (Boolean)class_3152.method_42438().method_41753() != false ? -1.0 : 1.0;
            BotRemoteInput.efg.field_1724.method_5872(this.efu * d, this.efv * d * d2);
            this.efu = 0.0;
            this.efv = 0.0;
        }
    }

    private static void efy(class_304 class_3042, boolean bl, boolean bl2) {
        if (bl) {
            class_3042.method_23481(true);
        } else if (bl2) {
            class_3042.method_23481(false);
        }
    }

    boolean isHeld(class_304 class_3042) {
        if (!this.efh || class_3042 == null || BotRemoteInput.efg.field_1690 == null) {
            return false;
        }
        class_315 class_3152 = BotRemoteInput.efg.field_1690;
        if (class_3042 == class_3152.field_1894) {
            return this.efj;
        }
        if (class_3042 == class_3152.field_1881) {
            return this.efk;
        }
        if (class_3042 == class_3152.field_1913) {
            return this.efl;
        }
        if (class_3042 == class_3152.field_1849) {
            return this.efm;
        }
        if (class_3042 == class_3152.field_1903) {
            return this.efn;
        }
        if (class_3042 == class_3152.field_1832) {
            return this.efo;
        }
        if (class_3042 == class_3152.field_1867) {
            return this.efp;
        }
        if (class_3042 == class_3152.field_1886) {
            return this.efq;
        }
        return class_3042 == class_3152.field_1904 && this.efr;
    }

    private static /* synthetic */ int di(int n, int n2) {
        return n + n2 | 0xF0638363;
    }

    private static /* synthetic */ int dj(int n, int n2) {
        return n * n2 | 0x1BF7F210;
    }
}

