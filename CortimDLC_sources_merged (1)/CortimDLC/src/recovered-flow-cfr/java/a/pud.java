/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.util.math.MathHelper
 */
package a;

import a.prp;
import a.vzz;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.util.math.MathHelper;

public final class pud {
    public static final pud INSTANCE = new pud();
    private static final int pue = 5;
    private static final float puf = 40.0f;
    private boolean pug;
    private float puh;
    private float pui;
    private boolean puj;
    private boolean puk;
    private int pul;
    private int pum = 5;
    private float pun;
    private float puo;
    private Object pup;
    private boolean puq;
    private float pur;
    private float pus;
    private float put;
    private float puu;
    private boolean puv;
    private float puw;
    private float pux;
    private static /* synthetic */ int puy;
    private static /* synthetic */ String puz;

    private pud() {
    }

    public void set(Object object, float f, float f2) {
        this.pup = object;
        this.pug = true;
        this.puh = f;
        this.pui = MathHelper.method_15363((float)f2, (float)-90.0f, (float)90.0f);
        this.puj = true;
        this.puk = false;
    }

    public boolean ownedBy(Object object) {
        return this.pup == object && (this.puj || this.puk);
    }

    public boolean engaged() {
        return this.puj || this.puk;
    }

    public void release(ClientPlayerEntity clientPlayerEntity) {
        if (!this.pug || !this.puj && !this.puk) {
            this.reset();
            return;
        }
        if (this.puk) {
            return;
        }
        this.pun = this.puh;
        this.puo = this.pui;
        this.pul = 0;
        this.puk = true;
        this.puj = false;
        float f = clientPlayerEntity == null ? 0.0f : (float)Math.hypot(Math.abs(MathHelper.method_15393((float)(this.pun - clientPlayerEntity.method_36454()))), Math.abs(this.puo - clientPlayerEntity.method_36455()));
        this.pum = MathHelper.method_15340((int)Math.round(1.875f * f / 40.0f), (int)5, (int)14);
    }

    public void reset() {
        this.pug = false;
        this.puj = false;
        this.puk = false;
        this.pul = 0;
        this.pup = null;
    }

    public float cameraYaw(ClientPlayerEntity clientPlayerEntity) {
        return this.puq ? this.pur : clientPlayerEntity.method_36454();
    }

    public float cameraPitch(ClientPlayerEntity clientPlayerEntity) {
        return this.puq ? this.pus : clientPlayerEntity.method_36455();
    }

    public void begin(MinecraftClient minecraftClient) {
        float f;
        float f2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || this.puq) {
            return;
        }
        float f3 = clientPlayerEntity.method_36454();
        float f4 = clientPlayerEntity.method_36455();
        if (this.puk) {
            ++this.pul;
            if (this.pul >= this.pum) {
                this.reset();
                return;
            }
            float f5 = (float)this.pul / (float)this.pum;
            float f6 = f5 * f5 * f5 * (6.0f * f5 * f5 - 15.0f * f5 + 10.0f);
            f2 = this.pun + MathHelper.method_15393((float)(f3 - this.pun)) * f6;
            f = MathHelper.method_16439((float)f6, (float)this.puo, (float)f4);
        } else if (this.puj && this.pug) {
            f2 = this.puh;
            f = this.pui;
        } else {
            return;
        }
        float[] fArray = prp.apply(f3, f4, f2, f);
        this.pur = f3;
        this.pus = f4;
        this.put = clientPlayerEntity.field_3932;
        this.puu = clientPlayerEntity.field_3916;
        this.puq = true;
        clientPlayerEntity.method_36456(fArray[0]);
        clientPlayerEntity.method_36457(fArray[1]);
    }

    public void end(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        this.pva(minecraftClient);
        if (!this.puq) {
            return;
        }
        this.puq = false;
        if (clientPlayerEntity == null) {
            return;
        }
        clientPlayerEntity.method_36456(this.pur);
        clientPlayerEntity.method_36457(this.pus);
        clientPlayerEntity.field_5982 = this.pur;
        clientPlayerEntity.field_6004 = this.pus;
        clientPlayerEntity.field_3931 = this.put;
        clientPlayerEntity.field_3914 = this.puu;
        clientPlayerEntity.field_3932 = this.put + (this.pur - this.put) * 0.5f;
        clientPlayerEntity.field_3916 = this.puu + (this.pus - this.puu) * 0.5f;
    }

    public void remapHumanKeys(MinecraftClient minecraftClient, float f, float f2) {
        double d;
        float f3;
        GameOptions gameOptions = minecraftClient.field_1690;
        float f4 = (vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1894) ? 1.0f : 0.0f) - (vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1881) ? 1.0f : 0.0f);
        float f5 = (vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1913) ? 1.0f : 0.0f) - (vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1849) ? 1.0f : 0.0f);
        if (f4 == 0.0f && f5 == 0.0f) {
            this.puw = 0.0f;
            this.pux = 0.0f;
            return;
        }
        if (Math.abs(MathHelper.method_15393((float)(f2 - f))) <= 12.0f) {
            this.puw = 0.0f;
            this.pux = 0.0f;
            return;
        }
        double d2 = MathHelper.method_15338((double)Math.toDegrees(pud.inputDirection(f, f4, f5)));
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = Float.MAX_VALUE;
        for (float f9 = -1.0f; f9 <= 1.0f; f9 += 1.0f) {
            for (float f10 = -1.0f; f10 <= 1.0f; f10 += 1.0f) {
                double d3;
                float f11;
                if (f9 == 0.0f && f10 == 0.0f || !((f11 = Math.abs(MathHelper.method_15393((float)((float)(d2 - (d3 = MathHelper.method_15338((double)Math.toDegrees(pud.inputDirection(f2, f9, f10))))))))) < f8)) continue;
                f8 = f11;
                f6 = f9;
                f7 = f10;
            }
        }
        if ((this.puw != 0.0f || this.pux != 0.0f) && (f3 = Math.abs(MathHelper.method_15393((float)((float)(d2 - (d = MathHelper.method_15338((double)Math.toDegrees(pud.inputDirection(f2, this.puw, this.pux))))))))) <= f8 + 18.0f) {
            f6 = this.puw;
            f7 = this.pux;
        }
        this.puw = f6;
        this.pux = f7;
        gameOptions.field_1894.method_23481(f6 > 0.0f);
        gameOptions.field_1881.method_23481(f6 < 0.0f);
        gameOptions.field_1913.method_23481(f7 > 0.0f);
        gameOptions.field_1849.method_23481(f7 < 0.0f);
        this.puv = true;
    }

    private void pva(MinecraftClient minecraftClient) {
        if (!this.puv || minecraftClient.field_1690 == null) {
            return;
        }
        this.puv = false;
        GameOptions gameOptions = minecraftClient.field_1690;
        gameOptions.field_1894.method_23481(vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1894));
        gameOptions.field_1881.method_23481(vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1881));
        gameOptions.field_1913.method_23481(vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1913));
        gameOptions.field_1849.method_23481(vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1849));
    }

    public static double inputDirection(float f, float f2, float f3) {
        float f4;
        float f5;
        float f6 = f5 = f2 < 0.0f ? f + 180.0f : f;
        float f7 = f2 < 0.0f ? -0.5f : (f4 = f2 > 0.0f ? 0.5f : 1.0f);
        float f8 = f3 > 0.0f ? -90.0f * f4 : (f3 < 0.0f ? 90.0f * f4 : 0.0f);
        return Math.toRadians(f5 + f8);
    }

    private static /* synthetic */ int bov(int n, int n2) {
        return n ^ n2 | 0x458B7D40;
    }

    private static /* synthetic */ int bow(int n, int n2) {
        return pud.bov(n, n2) + n;
    }

    private static /* synthetic */ int box(int n, int n2) {
        return pud.bow(n, n2) * n2;
    }
}

