/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_476
 *  net.minecraft.class_480
 *  net.minecraft.class_488
 *  net.minecraft.class_495
 */
package a;

import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_476;
import net.minecraft.class_480;
import net.minecraft.class_488;
import net.minecraft.class_495;

public final class SlotUtil {
    private static Field vxm;
    private static boolean vxn;
    private static /* synthetic */ String vxo;
    private static /* synthetic */ int vxp;

    private SlotUtil() {
    }

    public static boolean isStorage(class_437 class_4372) {
        return class_4372 instanceof class_476 || class_4372 instanceof class_495 || class_4372 instanceof class_488 || class_4372 instanceof class_480;
    }

    public static class_1735 hovered(class_465<?> class_4652) {
        if (!vxn) {
            vxn = true;
            vxm = Reflect.find(class_465.class, "net.minecraft.class_465", "field_2787", "Lnet/minecraft/class_1735;");
        }
        if (vxm == null) {
            return null;
        }
        try {
            return (class_1735)vxm.get(class_4652);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return null;
        }
    }

    public static List<class_1735> own(class_1703 class_17032, class_1661 class_16612) {
        ArrayList<class_1735> arrayList = new ArrayList<class_1735>();
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (class_17352.field_7871 == class_16612) continue;
            arrayList.add(class_17352);
        }
        return arrayList;
    }

    public static class_1735 room(class_1703 class_17032, class_1661 class_16612, class_1799 class_17992, boolean bl) {
        for (class_1735 class_17352 : class_17032.field_7761) {
            class_1799 class_17993;
            if (class_17352.field_7871 != class_16612 || !SlotUtil.vxq(class_17352, bl) || !class_17352.method_7681() || !class_1799.method_31577((class_1799)class_17992, (class_1799)(class_17993 = class_17352.method_7677())) || class_17993.method_7947() >= class_17993.method_7914()) continue;
            return class_17352;
        }
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (class_17352.field_7871 != class_16612 || !SlotUtil.vxq(class_17352, bl) || class_17352.method_7681()) continue;
            return class_17352;
        }
        return null;
    }

    private static boolean vxq(class_1735 class_17352, boolean bl) {
        int n = class_17352.method_34266();
        return n >= 9 && n < 36 || bl && n >= 0 && n < 9;
    }

    public static boolean hasRoom(class_1703 class_17032, class_1661 class_16612, class_1799 class_17992) {
        return SlotUtil.room(class_17032, class_16612, class_17992, true) != null;
    }

    public static void click(class_310 class_3102, class_1703 class_17032, int n, int n2, class_1713 class_17132) {
        class_3102.field_1761.method_2906(class_17032.field_7763, n, n2, class_17132, (class_1657)class_3102.field_1724);
    }

    private static /* synthetic */ int dlt(int n, int n2) {
        return n - n2 ^ 0xDD9635D0;
    }
}

