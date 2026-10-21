/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322$class_1323
 *  net.minecraft.class_1799
 *  net.minecraft.class_1844
 *  net.minecraft.class_6880
 *  net.minecraft.class_9285
 *  net.minecraft.class_9334
 */
package a;

import a.pia;
import a.pig;
import java.util.List;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1799;
import net.minecraft.class_1844;
import net.minecraft.class_6880;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public final class ModifierFactory {
    private static final double pin = 0.001;
    private static /* synthetic */ long pio;
    private static /* synthetic */ boolean pip;

    private ModifierFactory() {
    }

    public static pia flat(class_6880<class_1320> class_68802, double d) {
        return new pia(class_68802, d, class_1322.class_1323.field_6328);
    }

    public static pia scaled(class_6880<class_1320> class_68802, double d) {
        return new pia(class_68802, d, class_1322.class_1323.field_6330);
    }

    public static pig effect(class_6880<class_1291> class_68802, int n, int n2) {
        return new pig(class_68802, n, n2);
    }

    static boolean attrs(class_1799 class_17992, List<pia> list) {
        class_9285 class_92852 = (class_9285)class_17992.method_58695(class_9334.field_49636, (Object)class_9285.field_49326);
        for (pia pia2 : list) {
            if (pia2.in(class_92852)) continue;
            return false;
        }
        return true;
    }

    static boolean effects(class_1799 class_17992, List<pig> list) {
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 == null) {
            return false;
        }
        int n = 0;
        for (class_1293 object : class_18442.method_57397()) {
            ++n;
        }
        if (n != list.size()) {
            return false;
        }
        for (pig pig2 : list) {
            if (pig2.in(class_18442)) continue;
            return false;
        }
        return true;
    }

    private static /* synthetic */ int bjl(int n, int n2) {
        return n + n2 + -471542669;
    }

    private static /* synthetic */ int bjm(int n, int n2) {
        return ModifierFactory.bjl(n, n2) ^ 0x73B24F51;
    }
}

