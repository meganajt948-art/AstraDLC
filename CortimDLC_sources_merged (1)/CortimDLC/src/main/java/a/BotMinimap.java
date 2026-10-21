/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_22
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2680
 *  net.minecraft.class_2818
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_310
 *  net.minecraft.class_3620
 *  net.minecraft.class_3620$class_6594
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_9209
 */
package a;

import a.Bot;
import a.BotTexture;
import flow.dev.StringDecryptor;
import java.util.Arrays;
import net.minecraft.class_1922;
import net.minecraft.class_22;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2902;
import net.minecraft.class_310;
import net.minecraft.class_3620;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_9209;

public final class BotMinimap {
    public static final int SIZE = 96;
    private static final int eiq = 12;
    private static final class_310 eir = class_310.method_1551();
    private final Bot eis;
    private final int[] eit = new int[9216];
    private final class_2338.class_2339 eiu = new class_2338.class_2339();
    private BotTexture eiv;
    private boolean eiw;
    private int eix;
    private int eiy;
    private int eiz;
    private int eja;
    private int ejb;
    private boolean ejc;
    private long ejd;
    private class_9209 eje;
    private long ejf;
    private BotTexture ejg;
    private boolean ejh;
    private static /* synthetic */ int eji;
    private static /* synthetic */ long ejj;

    BotMinimap(Bot dtv2) {
        this.eis = dtv2;
    }

    public void demand() {
        this.ejd = System.currentTimeMillis() + 1000L;
    }

    void reset() {
        this.eix = 0;
        this.ejc = false;
        Arrays.fill(this.eit, 0);
        this.eiw = true;
        this.eje = null;
    }

    void onChunk(class_2818 class_28182) {
    }

    void onMap(class_9209 class_92092) {
        this.eje = class_92092;
        this.ejf = System.currentTimeMillis();
        this.ejh = true;
    }

    void tick() {
        if (System.currentTimeMillis() > this.ejd) {
            return;
        }
        class_746 class_7462 = BotMinimap.eir.field_1724;
        class_638 class_6382 = BotMinimap.eir.field_1687;
        if (class_7462 == null || class_6382 == null) {
            return;
        }
        if (this.eix == 0) {
            this.eiy = class_7462.method_31477();
            this.eiz = class_7462.method_31479();
        }
        int n = class_7462.method_31478();
        int n2 = class_6382.method_31607();
        int n3 = Math.min(96, this.eix + 12);
        for (int i = this.eix; i < n3; ++i) {
            int n4 = this.eiz + i - 48;
            for (int j = 0; j < 96; ++j) {
                int n5 = this.eiy + j - 48;
                this.eit[i * 96 + j] = this.ejk(class_6382, n5, n4, n, n2);
            }
        }
        this.eix = n3;
        if (this.eix >= 96) {
            this.eix = 0;
            this.eja = this.eiy;
            this.ejb = this.eiz;
            this.ejc = true;
            this.eiw = true;
        }
    }

    private int ejk(class_638 class_6382, int n, int n2, int n3, int n4) {
        class_2818 class_28182 = class_6382.method_2935().method_12126(n >> 4, n2 >> 4, false);
        if (class_28182 == null) {
            return 0;
        }
        int n5 = class_28182.method_12005(class_2902.class_2903.field_13202, n & 0xF, n2 & 0xF);
        int n6 = Math.min(n5, n3 + 6);
        int n7 = Math.max(n4, n6 - 40);
        for (int i = n6; i >= n7; --i) {
            class_3620 class_36202;
            this.eiu.method_10103(n, i, n2);
            class_2680 class_26802 = class_28182.method_8320((class_2338)this.eiu);
            if (class_26802.method_26215() || (class_36202 = class_26802.method_26205((class_1922)class_6382, (class_2338)this.eiu)) == class_3620.field_16008) continue;
            int n8 = i - n3;
            class_3620.class_6594 class_65942 = n8 > 1 ? class_3620.class_6594.field_34761 : (n8 >= -2 ? class_3620.class_6594.field_34760 : (n8 >= -8 ? class_3620.class_6594.field_34759 : class_3620.class_6594.field_34762));
            return class_36202.method_15820(class_65942);
        }
        return 0;
    }

    public BotTexture texture() {
        if (!this.ejc) {
            return null;
        }
        if (this.eiv == null) {
            this.eiv = new BotTexture("radar", 96, 96);
            this.eiw = true;
        }
        if (this.eiw) {
            for (int i = 0; i < 96; ++i) {
                for (int j = 0; j < 96; ++j) {
                    this.eiv.set(j, i, this.eit[i * 96 + j]);
                }
            }
            this.eiv.upload();
            this.eiw = false;
        }
        return this.eiv;
    }

    public int getCenterX() {
        return this.eja;
    }

    public int getCenterZ() {
        return this.ejb;
    }

    public BotTexture mapTexture() {
        class_638 class_6382 = this.eis.getWorld();
        if (this.eje == null || class_6382 == null || System.currentTimeMillis() - this.ejf > 120000L) {
            return null;
        }
        class_22 class_222 = class_6382.method_17891(this.eje);
        if (class_222 == null) {
            return null;
        }
        if (this.ejg == null) {
            this.ejg = new BotTexture("map", 128, 128);
            this.ejh = true;
        }
        if (this.ejh) {
            for (int i = 0; i < 16384; ++i) {
                this.ejg.set(i % 128, i / 128, class_3620.method_38480((int)class_222.field_122[i]));
            }
            this.ejg.upload();
            this.ejh = false;
        }
        return this.ejg;
    }

    void close() {
        if (this.eiv != null) {
            this.eiv.close();
            this.eiv = null;
        }
        if (this.ejg != null) {
            this.ejg.close();
            this.ejg = null;
        }
    }

    private static /* synthetic */ int ew(int n, int n2) {
        return n * n2 | 0xFB567D0C;
    }

    private static /* synthetic */ int ex(int n, int n2) {
        return BotMinimap.ew(n, n2) ^ 0xFA789844;
    }

    private static /* synthetic */ int ey(int n, int n2) {
        return n * n2 | 0x1CCA2758;
    }
}

