/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10444
 *  net.minecraft.class_11245
 *  net.minecraft.class_11246
 *  net.minecraft.class_11566
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_811
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fc
 */
package a;

import a.FrameDelta;
import a.uoo;
import a.DrawUtil;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.class_10444;
import net.minecraft.class_11245;
import net.minecraft.class_11246;
import net.minecraft.class_11566;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_811;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;

public final class ItemIconDraw {
    private static final Map<class_1799, uoo> uos = new IdentityHashMap<class_1799, uoo>();
    private static final Map<class_1792, String> uot = new IdentityHashMap<class_1792, String>();
    private static long uou;
    private static /* synthetic */ boolean uov;
    private static /* synthetic */ int uow;

    private ItemIconDraw() {
    }

    public static void draw(class_332 class_3322, class_1799 class_17992, int n, int n2) {
        if (class_17992.method_7960()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        class_11246 class_112462 = DrawUtil.state(class_3322);
        if (class_112462 == null || class_3102.field_1687 == null || DrawUtil.scissor() != null) {
            class_3322.method_51427(class_17992, n, n2);
            return;
        }
        FrameDelta.observe(class_3322);
        long l = FrameDelta.frame();
        long l2 = class_3102.field_1687.method_75260();
        uoo uoo2 = uos.get(class_17992);
        if (uoo2 == null) {
            uoo2 = new uoo();
            uos.put(class_17992, uoo2);
        }
        if (uoo2.tick != l2) {
            uoo2.tick = l2;
            class_3102.method_65386().method_65598((class_10444)uoo2.state, class_17992, class_811.field_4317, (class_1937)class_3102.field_1687, (class_11566)class_3102.field_1724, 0);
        }
        uoo2.frame = l;
        class_112462.method_70920(new class_11245(ItemIconDraw.uox(class_17992.method_7909()), new Matrix3x2f((Matrix3x2fc)class_3322.method_51448()), uoo2.state, n, n2, null));
        if (l - uou > 120L) {
            uou = l;
            Iterator<uoo> iterator = uos.values().iterator();
            while (iterator.hasNext()) {
                if (l - iterator.next().frame <= 120L) continue;
                iterator.remove();
            }
        }
    }

    private static String uox(class_1792 class_17923) {
        return uot.computeIfAbsent(class_17923, class_17922 -> class_17922.method_63680().toString());
    }

    private static /* synthetic */ int czl(int n, int n2) {
        return n - n2 | 0x4D21C108;
    }
}

