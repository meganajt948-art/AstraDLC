/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2680
 *  net.minecraft.class_746
 */
package a;

import a.Box3;
import a.OreTargetMap;
import a.BlockKind;
import a.MineSnap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongPredicate;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_746;

public final class MineSnapshots {
    private static final Map<class_2680, Byte> tsi = new ConcurrentHashMap<class_2680, Byte>();
    private static /* synthetic */ int tsj;
    private static /* synthetic */ String tsk;

    private MineSnapshots() {
    }

    public static boolean diamond(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10442) || class_26802.method_27852(class_2246.field_29029);
    }

    public static class_2338 standing(class_1937 class_19372, class_746 class_7462) {
        class_2338 class_23382 = class_7462.method_24515();
        if (class_7462.method_23318() - (double)class_23382.method_10264() >= 0.49 && !class_19372.method_8320(class_23382).method_26220((class_1922)class_19372, class_23382).method_1110()) {
            return class_23382.method_10084();
        }
        return class_23382;
    }

    public static byte kind(class_1937 class_19372, class_2338 class_23382, class_2680 class_26802) {
        boolean bl;
        if (class_26802.method_26215()) {
            return 0;
        }
        Byte by = tsi.get(class_26802);
        if (by != null) {
            return by;
        }
        boolean bl2 = bl = !class_26802.method_26227().method_15769();
        int n = class_26802.method_26218((class_1922)class_19372, class_23382).method_1110() ? (bl ? 5 : 0) : (bl || class_26802.method_26214((class_1922)class_19372, class_23382) < 0.0f || class_26802.method_26220((class_1922)class_19372, class_23382).method_1110() ? 4 : (MineSnapshots.diamond(class_26802) ? 2 : (OreTargetMap.value(class_26802) > 0.0f ? 3 : (class_26802.method_26234((class_1922)class_19372, class_23382) ? 1 : 6))));
        tsi.put(class_26802, (byte)n);
        return (byte)n;
    }

    public static byte code(class_1937 class_19372, class_746 class_7462, class_2338 class_23382, class_2680 class_26802, Box3 pzc2, Map<class_2680, Boolean> map) {
        byte by = MineSnapshots.kind(class_19372, class_23382, class_26802);
        if (!BlockKind.minable(by)) {
            return by;
        }
        if (pzc2 != null && !pzc2.contains(class_23382)) {
            return 4;
        }
        Boolean bl = map.get(class_26802);
        if (bl == null) {
            bl = class_26802.method_26165((class_1657)class_7462, (class_1922)class_19372, class_23382) < 1.0f;
            map.put(class_26802, bl);
        }
        return bl != false ? (byte)(by | 8) : by;
    }

    public static MineSnap snap(class_1937 class_19372, class_746 class_7462, class_2338 class_23382, Box3 pzc2, LongPredicate longPredicate, LongPredicate longPredicate2) {
        byte[] byArray = new byte[2475];
        int n = class_23382.method_10263() - 7;
        int n2 = class_23382.method_10264() - 3;
        int n3 = class_23382.method_10260() - 7;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        IdentityHashMap<class_2680, Boolean> identityHashMap = new IdentityHashMap<class_2680, Boolean>();
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 11; ++j) {
                for (int k = 0; k < 15; ++k) {
                    int n4;
                    class_23392.method_10103(n + i, n2 + j, n3 + k);
                    long l = class_23392.method_10063();
                    if (longPredicate2 != null && longPredicate2.test(l)) {
                        n4 = 0;
                    } else {
                        n4 = MineSnapshots.code(class_19372, class_7462, (class_2338)class_23392, class_19372.method_8320((class_2338)class_23392), pzc2, identityHashMap);
                        if (longPredicate != null && BlockKind.minable((byte)n4) && longPredicate.test(l)) {
                            n4 = 4;
                        }
                    }
                    byArray[MineSnap.index((int)i, (int)j, (int)k)] = n4;
                }
            }
        }
        return new MineSnap(n, n2, n3, byArray);
    }

    private static /* synthetic */ int cqa(int n, int n2) {
        return n + n2 + 1251813785;
    }

    private static /* synthetic */ int cqb(int n, int n2) {
        return MineSnapshots.cqa(n, n2) + n;
    }

    private static /* synthetic */ int cqc(int n, int n2) {
        return n * n2 | 0xB6119E66;
    }
}

