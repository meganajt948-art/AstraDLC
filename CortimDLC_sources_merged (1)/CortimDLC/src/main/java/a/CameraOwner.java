/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import a.MouseQuantizer;
import a.KeyUtil;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public final class CameraOwner {
    public static final CameraOwner INSTANCE = new CameraOwner();
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

    private CameraOwner() {
    }

    public void set(Object object, float f, float f2) {
        this.pup = object;
        this.pug = true;
        this.puh = f;
        this.pui = class_3532.method_15363((float)f2, (float)-90.0f, (float)90.0f);
        this.puj = true;
        this.puk = false;
    }

    public boolean ownedBy(Object object) {
        return this.pup == object && (this.puj || this.puk);
    }

    public boolean engaged() {
        return this.puj || this.puk;
    }

    public void release(class_746 class_7462) {
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
        float f = class_7462 == null ? 0.0f : (float)Math.hypot(Math.abs(class_3532.method_15393((float)(this.pun - class_7462.method_36454()))), Math.abs(this.puo - class_7462.method_36455()));
        this.pum = class_3532.method_15340((int)Math.round(1.875f * f / 40.0f), (int)5, (int)14);
    }

    public void reset() {
        this.pug = false;
        this.puj = false;
        this.puk = false;
        this.pul = 0;
        this.pup = null;
    }

    public float cameraYaw(class_746 class_7462) {
        return this.puq ? this.pur : class_7462.method_36454();
    }

    public float cameraPitch(class_746 class_7462) {
        return this.puq ? this.pus : class_7462.method_36455();
    }

    public void begin(class_310 class_3102) {
        float f;
        float f2;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || this.puq) {
            return;
        }
        float f3 = class_7462.method_36454();
        float f4 = class_7462.method_36455();
        if (this.puk) {
            ++this.pul;
            if (this.pul >= this.pum) {
                this.reset();
                return;
            }
            float f5 = (float)this.pul / (float)this.pum;
            float f6 = f5 * f5 * f5 * (6.0f * f5 * f5 - 15.0f * f5 + 10.0f);
            f2 = this.pun + class_3532.method_15393((float)(f3 - this.pun)) * f6;
            f = class_3532.method_16439((float)f6, (float)this.puo, (float)f4);
        } else if (this.puj && this.pug) {
            f2 = this.puh;
            f = this.pui;
        } else {
            return;
        }
        float[] fArray = MouseQuantizer.apply(f3, f4, f2, f);
        this.pur = f3;
        this.pus = f4;
        this.put = class_7462.field_3932;
        this.puu = class_7462.field_3916;
        this.puq = true;
        class_7462.method_36456(fArray[0]);
        class_7462.method_36457(fArray[1]);
    }

    public void end(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        this.pva(class_3102);
        if (!this.puq) {
            return;
        }
        this.puq = false;
        if (class_7462 == null) {
            return;
        }
        class_7462.method_36456(this.pur);
        class_7462.method_36457(this.pus);
        class_7462.field_5982 = this.pur;
        class_7462.field_6004 = this.pus;
        class_7462.field_3931 = this.put;
        class_7462.field_3914 = this.puu;
        class_7462.field_3932 = this.put + (this.pur - this.put) * 0.5f;
        class_7462.field_3916 = this.puu + (this.pus - this.puu) * 0.5f;
    }

    public void remapHumanKeys(class_310 class_3102, float f, float f2) {
        double d;
        float f3;
        class_315 class_3152 = class_3102.field_1690;
        float f4 = (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1894) ? 1.0f : 0.0f) - (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1881) ? 1.0f : 0.0f);
        float f5 = (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1913) ? 1.0f : 0.0f) - (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1849) ? 1.0f : 0.0f);
        if (f4 == 0.0f && f5 == 0.0f) {
            this.puw = 0.0f;
            this.pux = 0.0f;
            return;
        }
        if (Math.abs(class_3532.method_15393((float)(f2 - f))) <= 12.0f) {
            this.puw = 0.0f;
            this.pux = 0.0f;
            return;
        }
        double d2 = class_3532.method_15338((double)Math.toDegrees(CameraOwner.inputDirection(f, f4, f5)));
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = Float.MAX_VALUE;
        for (float f9 = -1.0f; f9 <= 1.0f; f9 += 1.0f) {
            for (float f10 = -1.0f; f10 <= 1.0f; f10 += 1.0f) {
                double d3;
                float f11;
                if (f9 == 0.0f && f10 == 0.0f || !((f11 = Math.abs(class_3532.method_15393((float)((float)(d2 - (d3 = class_3532.method_15338((double)Math.toDegrees(CameraOwner.inputDirection(f2, f9, f10))))))))) < f8)) continue;
                f8 = f11;
                f6 = f9;
                f7 = f10;
            }
        }
        if ((this.puw != 0.0f || this.pux != 0.0f) && (f3 = Math.abs(class_3532.method_15393((float)((float)(d2 - (d = class_3532.method_15338((double)Math.toDegrees(CameraOwner.inputDirection(f2, this.puw, this.pux))))))))) <= f8 + 18.0f) {
            f6 = this.puw;
            f7 = this.pux;
        }
        this.puw = f6;
        this.pux = f7;
        class_3152.field_1894.method_23481(f6 > 0.0f);
        class_3152.field_1881.method_23481(f6 < 0.0f);
        class_3152.field_1913.method_23481(f7 > 0.0f);
        class_3152.field_1849.method_23481(f7 < 0.0f);
        this.puv = true;
    }

    private void pva(class_310 class_3102) {
        if (!this.puv || class_3102.field_1690 == null) {
            return;
        }
        this.puv = false;
        class_315 class_3152 = class_3102.field_1690;
        class_3152.field_1894.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1894));
        class_3152.field_1881.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1881));
        class_3152.field_1913.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1913));
        class_3152.field_1849.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1849));
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
        return CameraOwner.bov(n, n2) + n;
    }

    private static /* synthetic */ int box(int n, int n2) {
        return CameraOwner.bow(n, n2) * n2;
    }
}

