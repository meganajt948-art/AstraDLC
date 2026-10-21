/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1269$class_9860
 *  net.minecraft.class_1269$class_9861
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_746
 */
package a;

import a.pth;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_746;

public final class SilentRotation {
    private static final Field pts = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1752", "I");
    private static pth ptt = new pth();
    private static /* synthetic */ long ptu;
    private static /* synthetic */ int ptv;

    private SilentRotation() {
    }

    public static pth swap(pth pth2) {
        pth pth3 = ptt;
        ptt = pth2 == null ? new pth() : pth2;
        return pth3;
    }

    public static void aimAt(class_2338 class_23382, float f, float f2) {
        pth pth2 = ptt;
        pth2.pti = class_23382;
        pth2.ptj = f;
        pth2.ptk = f2;
        pth2.ptm = false;
        pth2.ptl = 2;
    }

    public static void miss() {
        pth pth2 = ptt;
        pth2.pti = null;
        pth2.ptm = true;
        pth2.ptl = 2;
    }

    public static void clear() {
        pth pth2 = ptt;
        pth2.pti = null;
        pth2.ptm = false;
        pth2.ptl = 0;
        pth2.ptn.clear();
    }

    public static void later(Runnable runnable) {
        pth pth2 = ptt;
        class_310 class_3102 = class_310.method_1551();
        if (runnable == null || pth2.ptn.size() >= 4) {
            return;
        }
        pth2.ptn.add(runnable);
        pth2.pto = class_3102.field_1724 != null ? class_3102.field_1724.field_6012 : 0;
    }

    public static boolean isOrdered() {
        pth pth2 = ptt;
        return pth2.ptl > 0 && (pth2.pti != null || pth2.ptm);
    }

    public static void apply(class_310 class_3102) {
        pth pth2 = ptt;
        try {
            SilentRotation.ptx(pth2, class_3102);
        }
        finally {
            SilentRotation.ptw(pth2, class_3102);
        }
    }

    public static void applyOwn(class_310 class_3102) {
        pth pth2 = ptt;
        try {
            SilentRotation.pty(pth2, class_3102);
        }
        finally {
            SilentRotation.ptw(pth2, class_3102);
        }
    }

    private static void ptw(pth pth2, class_310 class_3102) {
        Runnable runnable;
        if (pth2.ptn.isEmpty()) {
            return;
        }
        if (class_3102 == null || class_3102.field_1724 == null || class_3102.field_1687 == null || class_3102.field_1724.field_6012 - pth2.pto > 3 || class_3102.field_1724.field_6012 < pth2.pto) {
            pth2.ptn.clear();
            return;
        }
        while ((runnable = pth2.ptn.poll()) != null) {
            try {
                runnable.run();
            }
            catch (Exception exception) {}
        }
    }

    private static void ptx(pth pth2, class_310 class_3102) {
        if (pth2.ptl <= 0 || pth2.pti == null && !pth2.ptm) {
            return;
        }
        --pth2.ptl;
        if (class_3102 == null || class_3102.field_1724 == null || class_3102.field_1687 == null) {
            return;
        }
        class_243 class_2432 = class_3102.field_1724.method_33571();
        class_243 class_2433 = class_243.method_1030((float)pth2.ptk, (float)pth2.ptj);
        double d = class_3102.field_1724.method_55754();
        class_243 class_2434 = class_2432.method_1031(class_2433.field_1352 * d, class_2433.field_1351 * d, class_2433.field_1350 * d);
        if (pth2.ptm) {
            class_3102.field_1765 = class_3965.method_17778((class_243)class_2434, (class_2350)class_2350.field_11036, (class_2338)class_2338.method_49638((class_2374)class_2434));
            return;
        }
        class_3965 class_39652 = class_3102.field_1687.method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_3102.field_1724));
        class_3102.field_1765 = class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)pth2.pti) ? class_39652 : class_3965.method_17778((class_243)class_2434, (class_2350)class_2350.field_11036, (class_2338)class_2338.method_49638((class_2374)class_2434));
    }

    private static void pty(pth pth2, class_310 class_3102) {
        if (pth2.ptl <= 0 || pth2.pti == null && !pth2.ptm) {
            return;
        }
        --pth2.ptl;
        if (class_3102 == null || class_3102.field_1724 == null || class_3102.field_1687 == null || class_3102.field_1690 == null || class_3102.field_1761 == null) {
            return;
        }
        if (pth2.ptm) {
            SilentRotation.ptz(class_3102);
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_243.method_1030((float)class_7462.method_36455(), (float)class_7462.method_36454());
        double d = class_7462.method_55754();
        class_243 class_2434 = class_2432.method_1031(class_2433.field_1352 * d, class_2433.field_1351 * d, class_2433.field_1350 * d);
        class_3965 class_39652 = class_3102.field_1687.method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        if (class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)pth2.pti)) {
            return;
        }
        class_3102.field_1690.field_1886.method_23481(false);
        class_3102.field_1690.field_1904.method_23481(false);
        while (class_3102.field_1690.field_1886.method_1436()) {
        }
        while (class_3102.field_1690.field_1904.method_1436()) {
        }
    }

    private static void ptz(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        while (class_3102.field_1690.field_1904.method_1436()) {
        }
        if (!class_3102.field_1690.field_1904.method_1434() || class_7462.method_6115()) {
            return;
        }
        int n = Reflect.getInt(pts, class_3102, 0);
        if (n <= 0 && !class_3102.field_1761.method_2923() && !class_7462.method_3144()) {
            class_1268 class_12682;
            class_1799 class_17992;
            class_1268[] class_1268Array = class_1268.values();
            int n2 = class_1268Array.length;
            for (int i = 0; i < n2 && (class_17992 = class_7462.method_5998(class_12682 = class_1268Array[i])).method_45435(class_3102.field_1687.method_45162()); ++i) {
                class_1269 class_12692;
                if (class_17992.method_7960() || !((class_12692 = class_3102.field_1761.method_2919((class_1657)class_7462, class_12682)) instanceof class_1269.class_9860)) continue;
                class_1269.class_9860 class_98602 = (class_1269.class_9860)class_12692;
                if (class_98602.comp_2909() != class_1269.class_9861.field_52427) break;
                class_7462.method_6104(class_12682);
                break;
            }
            n = 4;
        }
        Reflect.setInt(pts, class_3102, Math.max(n, 2));
    }

    private static /* synthetic */ int boo(int n, int n2) {
        return n + n2 ^ 0x2116848F;
    }

    private static /* synthetic */ int bop(int n, int n2) {
        return SilentRotation.boo(n, n2) * n2;
    }
}

