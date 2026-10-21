/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  net.minecraft.class_5498
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 *  net.minecraft.class_759
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.ove;
import a.NumberSetting;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_5498;
import net.minecraft.class_744;
import net.minecraft.class_746;
import net.minecraft.class_759;

public class FreeCam
extends Module {
    private static FreeCam ovi;
    private final NumberSetting ovj = this.add(new NumberSetting("Speed", 10.0, 1.0, 50.0, 1.0).suffix("b/s"));
    private final NumberSetting ovk = this.add(new NumberSetting("Smooth", 0.5, 0.0, 1.0, 0.05).percent());
    private static Field ovl;
    private static Field ovm;
    private static Field ovn;
    private static Field[] ovo;
    private static boolean ovp;
    private ove ovq;
    private class_744 ovr;
    private class_5498 ovs;
    private boolean ovt = true;
    private boolean ovu;
    private float ovv;
    private float ovw;
    private float ovx;
    private float ovy;
    private double ovz;
    private double owa;
    private double owb;
    private long owc;
    private long owd;
    private long owe = -1L;
    private static /* synthetic */ boolean owf;
    private static /* synthetic */ long owg;

    public FreeCam() {
        super("FreeCam", "Fly the camera, your player stays", ModuleCategory.PLAYER);
        ovi = this;
    }

    public static boolean active() {
        return ovi != null && ovi.isEnabled() && FreeCam.ovi.ovq != null;
    }

    @Override
    protected void onEnable() {
        class_310 class_3102 = class_310.method_1551();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1687 == null) {
            this.setEnabled(false);
            return;
        }
        FreeCam.owm();
        this.ovv = class_7462.method_36454();
        this.ovw = class_7462.method_36455();
        this.ovx = this.ovv;
        this.ovy = this.ovw;
        this.owb = 0.0;
        this.owa = 0.0;
        this.ovz = 0.0;
        this.owc = 0L;
        class_243 class_2432 = class_7462.method_5836(1.0f);
        this.ovq = new ove(this, (class_1937)class_3102.field_1687);
        this.ovq.method_5814(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        this.ovq.field_6014 = class_2432.field_1352;
        this.ovq.field_6036 = class_2432.field_1351;
        this.ovq.field_5969 = class_2432.field_1350;
        this.ovr = class_7462.field_3913;
        class_7462.field_3913 = new class_744();
        class_7462.method_5728(false);
        this.ovs = class_3102.field_1690.method_31044();
        class_3102.field_1690.method_31043(class_5498.field_26664);
        this.ovt = class_3102.field_1730;
        class_3102.field_1730 = false;
        class_3102.method_1504((class_1297)this.ovq);
        FreeCam.own(class_3102, 0.0f);
    }

    @Override
    protected void onDisable() {
        class_310 class_3102 = class_310.method_1551();
        class_746 class_7462 = class_3102.field_1724;
        this.owh(class_7462);
        if (this.ovq != null && class_7462 != null) {
            class_3102.method_1504((class_1297)class_7462);
            if (this.ovr != null) {
                class_7462.field_3913 = this.ovr;
            }
            class_7462.method_36456(this.ovv);
            class_7462.method_36457(this.ovw);
            class_7462.field_5982 = this.ovv;
            class_7462.field_6004 = this.ovw;
            FreeCam.own(class_3102, class_7462.method_5751());
        }
        if (this.ovq != null) {
            class_3102.field_1730 = this.ovt;
        }
        if (this.ovs != null) {
            class_3102.field_1690.method_31043(this.ovs);
        }
        this.ovq = null;
        this.ovr = null;
        this.ovs = null;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (this.ovq == null) {
            return;
        }
        this.owh(class_3102.field_1724);
        if (this.ovq.method_73183() != class_3102.field_1687 || class_3102.method_1560() != this.ovq) {
            this.setEnabled(false);
            return;
        }
        FreeCam.owi(class_3102, (class_1297)class_3102.field_1724);
        for (class_304 class_3042 : new class_304[]{class_3102.field_1690.field_1886, class_3102.field_1690.field_1904, class_3102.field_1690.field_1871, class_3102.field_1690.field_1869, class_3102.field_1690.field_1831}) {
            while (class_3042.method_1436()) {
            }
            class_3042.method_23481(false);
        }
        if (class_3102.field_1724.field_3913 != null && class_3102.field_1724.field_3913.getClass() != class_744.class) {
            this.ovr = class_3102.field_1724.field_3913;
            class_3102.field_1724.field_3913 = new class_744();
        }
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        ++this.owd;
        this.owl(class_3102);
        class_746 class_7462 = class_3102.field_1724;
        if (this.ovq != null && class_7462 != null && !class_7462.field_5960) {
            class_7462.field_5960 = true;
            this.ovu = true;
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (this.ovq != null && class_3102.method_1560() == class_3102.field_1724) {
            FreeCam.owi(class_3102, (class_1297)this.ovq);
        }
        this.owl(class_3102);
    }

    private void owh(class_746 class_7462) {
        if (this.ovu && class_7462 != null) {
            class_7462.field_5960 = false;
        }
        this.ovu = false;
    }

    private static void owi(class_310 class_3102, class_1297 class_12972) {
        if (class_12972 == null) {
            return;
        }
        try {
            if (ovn != null) {
                ovn.set(class_3102, class_12972);
                return;
            }
        }
        catch (IllegalAccessException | RuntimeException exception) {
            // empty catch block
        }
        class_3102.method_1504(class_12972);
    }

    private void owj() {
        if (this.owe == this.owd) {
            return;
        }
        this.owe = this.owd;
        class_310 class_3102 = class_310.method_1551();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || this.ovq == null) {
            return;
        }
        this.ovx += class_7462.method_36454() - this.ovv;
        this.ovy = class_3532.method_15363((float)(this.ovy + class_7462.method_36455() - this.ovw), (float)-90.0f, (float)90.0f);
        class_7462.method_36456(this.ovv);
        class_7462.method_36457(this.ovw);
        class_7462.field_5982 = this.ovv;
        class_7462.field_6004 = this.ovw;
        long l = System.nanoTime();
        double d = this.owc == 0L ? 0.0 : Math.min(0.1, (double)(l - this.owc) / 1.0E9);
        this.owc = l;
        double d2 = FreeCam.owk(class_3102.field_1690.field_1894, class_3102.field_1690.field_1881);
        double d3 = FreeCam.owk(class_3102.field_1690.field_1913, class_3102.field_1690.field_1849);
        double d4 = FreeCam.owk(class_3102.field_1690.field_1903, class_3102.field_1690.field_1832);
        double d5 = this.ovj.get() * (class_3102.field_1690.field_1867.method_1434() ? 2.5 : 1.0);
        double d6 = Math.toRadians(this.ovx);
        double d7 = Math.sin(d6);
        double d8 = Math.cos(d6);
        double d9 = Math.sqrt(d2 * d2 + d3 * d3);
        double d10 = 0.0;
        double d11 = 0.0;
        if (d9 > 0.0) {
            d10 = (-d7 * (d2 /= d9) + d8 * (d3 /= d9)) * d5;
            d11 = (d8 * d2 + d7 * d3) * d5;
        }
        double d12 = d4 * d5;
        double d13 = this.ovk.get() <= 0.01 ? 1.0 : 1.0 - Math.exp(-d * (4.0 + 26.0 * (1.0 - this.ovk.get())));
        this.ovz += (d10 - this.ovz) * d13;
        this.owa += (d12 - this.owa) * d13;
        this.owb += (d11 - this.owb) * d13;
        double d14 = this.ovq.method_23317() + this.ovz * d;
        double d15 = this.ovq.method_23318() + this.owa * d;
        double d16 = this.ovq.method_23321() + this.owb * d;
        this.ovq.method_5814(d14, d15, d16);
        this.ovq.field_6014 = d14;
        this.ovq.field_6036 = d15;
        this.ovq.field_5969 = d16;
    }

    private static double owk(class_304 class_3042, class_304 class_3043) {
        return (class_3042.method_1434() ? 1 : 0) - (class_3043.method_1434() ? 1 : 0);
    }

    private void owl(class_310 class_3102) {
        if (this.ovq == null || ovo == null) {
            return;
        }
        class_759 class_7592 = class_3102.method_1561().method_43336();
        for (Field field : ovo) {
            Reflect.setFloat(field, class_7592, 0.0f);
        }
    }

    private static void owm() {
        if (ovp) {
            return;
        }
        ovp = true;
        ovl = Reflect.find(class_4184.class, "net.minecraft.class_4184", "field_18721", "F");
        ovm = Reflect.find(class_4184.class, "net.minecraft.class_4184", "field_18722", "F");
        ovn = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1719", "Lnet/minecraft/class_1297;");
        Field[] fieldArray = new Field[]{Reflect.find(class_759.class, "net.minecraft.class_759", "field_4043", "F"), Reflect.find(class_759.class, "net.minecraft.class_759", "field_4053", "F"), Reflect.find(class_759.class, "net.minecraft.class_759", "field_4052", "F"), Reflect.find(class_759.class, "net.minecraft.class_759", "field_4051", "F")};
        ovo = fieldArray[0] != null && fieldArray[1] != null && fieldArray[2] != null && fieldArray[3] != null ? fieldArray : null;
    }

    private static void own(class_310 class_3102, float f) {
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        Reflect.setFloat(ovl, class_41842, f);
        Reflect.setFloat(ovm, class_41842, f);
    }

    private static /* synthetic */ int bfj(int n, int n2) {
        return n - n2 + 143632168;
    }
}

