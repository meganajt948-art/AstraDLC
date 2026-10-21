/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3481
 *  net.minecraft.class_3486
 */
package a;

import a.WalkSnap;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3481;
import net.minecraft.class_3486;

public final class WalkHazards {
    private static /* synthetic */ int txg;
    private static /* synthetic */ long txh;

    private WalkHazards() {
    }

    public static boolean hazard(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10164) || class_26802.method_27852(class_2246.field_10036) || class_26802.method_27852(class_2246.field_22089) || class_26802.method_27852(class_2246.field_10092) || class_26802.method_27852(class_2246.field_17350) || class_26802.method_27852(class_2246.field_23860) || class_26802.method_27852(class_2246.field_10029) || class_26802.method_27852(class_2246.field_16999) || class_26802.method_27852(class_2246.field_10606) || class_26802.method_27852(class_2246.field_27879) || class_26802.method_27852(class_2246.field_28048) || class_26802.method_26227().method_15767(class_3486.field_15518);
    }

    public static int code(class_1922 class_19222, class_2338 class_23382, class_2680 class_26802, Map<class_2680, Integer> map) {
        Integer n;
        boolean bl;
        if (class_26802.method_26215()) {
            return 0;
        }
        boolean bl2 = bl = !class_26802.method_31709();
        if (bl && (n = map.get(class_26802)) != null) {
            return n;
        }
        int n2 = 0;
        class_265 class_2652 = class_26802.method_26220(class_19222, class_23382);
        if (!class_2652.method_1110()) {
            double d = class_2652.method_1105(class_2350.class_2351.field_11052);
            n2 = d > 1.0001 ? 9 : Math.max(1, Math.min(8, (int)Math.round(d * 8.0)));
            class_238 class_2383 = class_2652.method_1107();
            if (class_2383.method_17939() < 0.7 || class_2383.method_17941() < 0.7) {
                n2 |= 0x80;
            }
        }
        if (class_26802.method_26227().method_15767(class_3486.field_15517)) {
            n2 |= 0x10;
        }
        if (WalkHazards.hazard(class_26802)) {
            n2 |= 0x20;
        }
        if (class_26802.method_26164(class_3481.field_22414)) {
            n2 |= 0x40;
        }
        if (bl) {
            map.put(class_26802, n2);
        }
        return n2;
    }

    public static WalkSnap snap(class_1922 class_19222, int n, int n2, int n3) {
        byte[] byArray = new byte[1183];
        int n4 = n - 6;
        int n5 = n2 - 3;
        int n6 = n3 - 6;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        IdentityHashMap<class_2680, Integer> identityHashMap = new IdentityHashMap<class_2680, Integer>();
        for (int i = 0; i < 13; ++i) {
            for (int j = 0; j < 7; ++j) {
                for (int k = 0; k < 13; ++k) {
                    class_23392.method_10103(n4 + i, n5 + j, n6 + k);
                    byArray[WalkSnap.index((int)i, (int)j, (int)k)] = (byte)WalkHazards.code(class_19222, (class_2338)class_23392, class_19222.method_8320((class_2338)class_23392), identityHashMap);
                }
            }
        }
        return new WalkSnap(n4, n5, n6, byArray);
    }

    private static /* synthetic */ int csn(int n, int n2) {
        return n ^ n2 ^ 0xDADE5568;
    }

    private static /* synthetic */ int cso(int n, int n2) {
        return WalkHazards.csn(n, n2) ^ 0xA6F5CC4;
    }
}

