/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_310;

public class HealthBar
extends Module {
    private static HealthBar rjz;
    public final ModeSetting background = this.add(new ModeSetting("Background", "Solid", "Glass", "Liquid", "Solid", "None"));
    public final NumberSetting blur = this.add(new NumberSetting("Blur", 2.0, 0.0, 6.0, 1.0));
    public final NumberSetting opacity = this.add(new NumberSetting("Opacity", 0.45, 0.0, 1.0, 0.05).percent());
    public final ModeSetting tint = this.add(new ModeSetting("Tint", "Theme", "Theme", "Dark", "Accent"));
    public final NumberSetting rounding = this.add(new NumberSetting("Rounding", 0.55, 0.0, 1.0, 0.05).percent());
    public final NumberSetting size = this.add(new NumberSetting("Size", 1.0, 0.5, 2.0, 0.05).percent());
    public final NumberSetting shrink = this.add(new NumberSetting("Shrink", 0.7, 0.0, 1.0, 0.05).percent());
    public final ModeSetting health = this.add(new ModeSetting("Health", "Text", "Text", "Bar", "Both", "Off"));
    public final ModeSetting items = this.add(new ModeSetting("Items", "Inline", "Inline", "Above", "Off"));
    public final BoolSetting distance = this.add(new BoolSetting("Distance", false));
    public final BoolSetting ping = this.add(new BoolSetting("Ping", false));
    public final BoolSetting friends = this.add(new BoolSetting("Friends", true));
    public final BoolSetting self = this.add(new BoolSetting("Self", false));
    public final NumberSetting range = this.add(new NumberSetting("Range", 128.0, 16.0, 512.0, 8.0).suffix("m"));
    public final BoolSetting mobs = this.add(new BoolSetting("Mobs", false));
    public final NumberSetting mobRange = this.add(new NumberSetting("Mob range", 48.0, 8.0, 256.0, 8.0).suffix("m"));
    private static /* synthetic */ boolean rka;
    private static /* synthetic */ boolean rkb;

    public HealthBar() {
        super(new String(new char[]{'N', 'a', 'm', 'e', 't', 'a', 'g', 's'}), "Tags above players and mobs: name, health, armour", ModuleCategory.RENDER);
        rjz = this;
        this.mobRange.visibleWhen(this.mobs::get);
        this.blur.activeWhen(this::glass);
        this.opacity.activeWhen(() -> !this.background.is("None"));
        this.tint.activeWhen(() -> !this.background.is("None"));
    }

    public static HealthBar get() {
        return rjz;
    }

    public boolean glass() {
        return this.background.is("Glass") || this.background.is("Liquid");
    }

    public boolean showsHealthText() {
        return this.health.is("Text") || this.health.is("Both");
    }

    public boolean showsHealthBar() {
        return this.health.is("Bar") || this.health.is("Both");
    }

    public boolean shows(class_310 class_3102, class_1657 class_16572) {
        if (!this.isEnabled() || class_3102.field_1724 == null || class_16572.method_7325() || !class_16572.method_5805() || class_16572.method_31481()) {
            return false;
        }
        if (class_16572 == class_3102.field_1724 && (!this.self.get() || class_3102.field_1690.method_31044().method_31034())) {
            return false;
        }
        if (class_16572 == class_3102.method_1560() && class_16572 != class_3102.field_1724) {
            return false;
        }
        double d = this.range.get();
        return class_3102.field_1773.method_19418().method_71156().method_1025(class_16572.method_73189()) <= d * d;
    }

    public boolean showsMob(class_310 class_3102, class_1309 class_13092) {
        if (!this.isEnabled() || !this.mobs.get() || class_3102.field_1724 == null || !class_13092.method_5805() || class_13092.method_31481() || class_13092 == class_3102.method_1560()) {
            return false;
        }
        double d = this.mobRange.get();
        return class_3102.field_1773.method_19418().method_71156().method_1025(class_13092.method_73189()) <= d * d;
    }

    private static /* synthetic */ int bzf(int n, int n2) {
        return n * n2 + 1397167129;
    }
}

