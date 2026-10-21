/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11749
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_22
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2874
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_5321
 *  net.minecraft.class_6012
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_638$class_5271
 *  net.minecraft.class_6880
 *  net.minecraft.class_761
 *  net.minecraft.class_9209
 *  net.minecraft.class_9283
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.Bot;
import java.util.List;
import java.util.Map;
import net.minecraft.class_11749;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_22;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2874;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_5321;
import net.minecraft.class_6012;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import net.minecraft.class_761;
import net.minecraft.class_9209;
import net.minecraft.class_9283;
import org.jspecify.annotations.Nullable;

final class BotWorld
extends class_638 {
    private final Bot eli;
    private static /* synthetic */ String elj;
    private static /* synthetic */ long elk;

    BotWorld(class_634 class_6342, class_638.class_5271 class_52712, class_5321<class_1937> class_53212, class_6880<class_2874> class_68802, int n, int n2, class_761 class_7612, boolean bl, long l, int n3, Bot dtv2) {
        super(class_6342, class_52712, class_53212, class_68802, n, n2, class_7612, bl, l, n3);
        this.eli = dtv2;
    }

    Bot bot() {
        return this.eli;
    }

    Map<class_9209, class_22> maps() {
        return this.method_35754();
    }

    void copyMaps(Map<class_9209, class_22> map) {
        this.method_35753(map);
    }

    public void method_8413(class_2338 class_23382, class_2680 class_26802, class_2680 class_26803, int n) {
    }

    public void method_16109(class_2338 class_23382, class_2680 class_26802, class_2680 class_26803) {
    }

    public void method_18113(int n, int n2, int n3) {
    }

    public void method_62146(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void method_8517(int n, class_2338 class_23382, int n2) {
    }

    public void method_62895(long l) {
    }

    public void method_8474(int n, class_2338 class_23382, int n2) {
    }

    public void method_8444(@Nullable class_1297 class_12972, int n, class_2338 class_23382, int n2) {
    }

    public void method_8406(class_2394 class_23942, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_8466(class_2394 class_23942, boolean bl, boolean bl2, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_8494(class_2394 class_23942, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_17452(class_2394 class_23942, boolean bl, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_8547(double d, double d2, double d3, double d4, double d5, double d6, List<class_9283> list) {
    }

    public void method_31595(class_2338 class_23382, class_2680 class_26802) {
    }

    public void method_74254(class_2338 class_23382, class_2350 class_23502) {
    }

    public void method_73228(class_243 class_2432, float f, int n, class_6012<class_11749> class_60122) {
    }

    public void method_8465(@Nullable class_1297 class_12972, double d, double d2, double d3, class_6880<class_3414> class_68802, class_3419 class_34192, float f, float f2, long l) {
    }

    public void method_8449(@Nullable class_1297 class_12972, class_1297 class_12973, class_6880<class_3414> class_68802, class_3419 class_34192, float f, float f2, long l) {
    }

    public void method_55116(class_1297 class_12972, class_3414 class_34142, class_3419 class_34192, float f, float f2) {
    }

    public void method_67392(class_3414 class_34142, class_3419 class_34192, float f, float f2) {
    }

    public void method_8486(double d, double d2, double d3, class_3414 class_34142, class_3419 class_34192, float f, float f2, boolean bl) {
    }

    private static /* synthetic */ int gz(int n, int n2) {
        return n + n2 | 0x448EAA22;
    }

    private static /* synthetic */ int ha(int n, int n2) {
        return BotWorld.gz(n, n2) * n2;
    }

    private static /* synthetic */ int hb(int n, int n2) {
        return n + n2 ^ 0x4F6AABF2;
    }
}

