/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1011
 *  net.minecraft.class_1043
 *  net.minecraft.class_310
 *  net.minecraft.class_4608
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.BoolSetting;
import a.ColorSetting;
import a.NumberSetting;
import java.lang.reflect.Field;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_310;
import net.minecraft.class_4608;

public class HitColor
extends Module {
    private static final int rfb = -1291911168;
    private final ColorSetting rfc = this.add(new ColorSetting("Color", "Sakura"));
    private final NumberSetting rfd = this.add(new NumberSetting("Strength", 0.45, 0.1, 0.85, 0.05).percent());
    private final BoolSetting rfe = this.add(new BoolSetting("Shimmer", true));
    private static Field rff;
    private static boolean rfg;
    private int rfh;
    private static /* synthetic */ String rfi;
    private static /* synthetic */ long rfj;

    public HitColor() {
        super(new String(new char[]{'H', 'i', 't', 'C', 'o', 'l', 'o', 'r'}), "Your colour instead of the red hit flash", ModuleCategory.RENDER);
    }

    @Override
    protected void onDisable() {
        if (this.rfh != 0 && HitColor.rfk(-1291911168)) {
            this.rfh = 0;
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        int n;
        int n2;
        int n3 = this.rfc.color();
        if (this.rfe.get()) {
            float f = (float)(0.5 + 0.5 * Math.sin((double)System.nanoTime() / 1.0E9 * 1.6));
            n3 = ColorUtil.lerp(n3, this.rfc.color2(), f * 0.8f);
        }
        if ((n2 = ColorUtil.withAlpha(n3, n = Math.round(255.0f * (1.0f - (float)this.rfd.get())))) != this.rfh && HitColor.rfk(n2)) {
            this.rfh = n2;
        }
    }

    private static boolean rfk(int n) {
        if (rfg) {
            return false;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1773 == null) {
            return false;
        }
        try {
            class_1011 class_10112;
            int n2;
            class_1043 class_10432;
            class_4608 class_46082 = class_3102.field_1773.method_22975();
            if (rff == null) {
                class_10432 = class_4608.class.getDeclaredFields();
                int n3 = ((Field[])class_10432).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    class_1043 class_10433 = class_10432[n2];
                    if (class_10433.getType() != class_1043.class) continue;
                    class_10433.setAccessible(true);
                    rff = class_10433;
                    break;
                }
                if (rff == null) {
                    throw new IllegalStateException("overlay texture field not found");
                }
            }
            if ((class_10112 = (class_10432 = (class_1043)rff.get(class_46082)).method_4525()) == null) {
                return false;
            }
            for (n2 = 0; n2 < 8; ++n2) {
                for (int i = 0; i < 16; ++i) {
                    class_10112.method_61941(i, n2, n);
                }
            }
            class_10432.method_4524();
            return true;
        }
        catch (Throwable throwable) {
            rfg = true;
            System.out.println("hit colour unavailable: " + throwable);
            return false;
        }
    }

    private static /* synthetic */ int bxx(int n, int n2) {
        return n + n2 | 0x8EBBA6B8;
    }
}

