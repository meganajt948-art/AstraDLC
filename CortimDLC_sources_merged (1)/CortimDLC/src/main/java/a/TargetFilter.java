/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 */
package a;

import a.BoolSetting;
import flow.dev.StringDecryptor;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;

public final class TargetFilter {
    private static final class_1304[] lfz = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
    public final BoolSetting naked = new BoolSetting("Naked", true);
    public final BoolSetting invisible = new BoolSetting("Invisible", true);
    public final BoolSetting armored = new BoolSetting("Armored", true);
    private static /* synthetic */ long lga;
    private static /* synthetic */ boolean lgb;

    public boolean allows(class_1297 class_12972) {
        if (!this.invisible.get() && TargetFilter.invisible(class_12972)) {
            return false;
        }
        if (class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            return TargetFilter.armor((class_1309)class_16572) ? this.armored.get() : this.naked.get();
        }
        return true;
    }

    public static boolean invisible(class_1297 class_12972) {
        class_1309 class_13092;
        return class_12972.method_5767() || class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_6059(class_1294.field_5905);
    }

    public static boolean armor(class_1309 class_13092) {
        for (class_1304 class_13042 : lfz) {
            class_1799 class_17992 = class_13092.method_6118(class_13042);
            if (class_17992.method_7960() || class_17992.method_31574(class_1802.field_8833)) continue;
            return true;
        }
        return false;
    }

    private static /* synthetic */ int awo(int n, int n2) {
        return n + n2 ^ 0x140B2C7A;
    }
}

