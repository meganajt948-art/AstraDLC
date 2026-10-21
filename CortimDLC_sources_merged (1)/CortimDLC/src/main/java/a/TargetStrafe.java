/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.AutoMace;
import a.FreeCam;
import a.tcw;
import a.RecorderHooks;
import a.BoolSetting;
import a.NumberSetting;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class TargetStrafe
extends Module {
    private final NumberSetting lcl = this.add(new NumberSetting("К цели", 1.5, 1.0, 3.0, 0.05).suffix("x"));
    private final NumberSetting lcm = this.add(new NumberSetting("От цели", 0.5, 0.0, 1.0, 0.05).suffix("x"));
    private final NumberSetting lcn = this.add(new NumberSetting("Порог", 50.0, 5.0, 200.0, 1.0));
    private final NumberSetting lco = this.add(new NumberSetting("Дистанция", 3.5, 2.0, 6.0, 0.1).suffix("m"));
    private final NumberSetting lcp = this.add(new NumberSetting("FOV", 360.0, 10.0, 360.0, 5.0).unit("°"));
    private final BoolSetting lcq = this.add(new BoolSetting("Игроки", true));
    private final BoolSetting lcr = this.add(new BoolSetting("Мобы", true));
    private final BoolSetting lcs = this.add(new BoolSetting("Сквозь стены", true));
    private static Field lct;
    private static Field lcu;
    private class_1309 lcv;
    private long lcw;
    private GLFWCursorPosCallback lcx;
    private GLFWCursorPosCallback lcy;
    private double lcz;
    private double lda;
    private double ldb = Double.NaN;
    private double ldc;
    private double ldd;
    private static /* synthetic */ String lde;
    private static /* synthetic */ int ldf;

    public TargetStrafe() {
        super("MouseAssist", "Speeds the mouse up towards the target and slows it down away from it", ModuleCategory.COMBAT);
    }

    @Override
    protected void onDisable() {
        this.ldm();
        this.lcv = null;
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        if (this.lcy == null && class_3102.method_22683() != null) {
            this.ldl(class_3102.method_22683().method_4490());
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1687 == null) {
            this.lcv = null;
            return;
        }
        double d = this.lco.get();
        if (this.lcv == null || !this.ldh(class_7462, this.lcv) || !TargetStrafe.ldi(class_7462, (class_1297)this.lcv, d) || TargetStrafe.ldj(class_7462, (class_1297)this.lcv) > this.lcp.get() * 0.5) {
            this.lcv = this.ldg(class_3102, class_7462, d);
        }
    }

    private class_1309 ldg(class_310 class_3102, class_746 class_7462, double d) {
        class_1309 class_13092 = null;
        double d2 = Double.MAX_VALUE;
        double d3 = this.lcp.get() * 0.5;
        for (class_1297 class_12972 : class_3102.field_1687.method_8335((class_1297)class_7462, class_7462.method_5829().method_1014(d))) {
            double d4;
            class_1309 class_13093;
            if (!(class_12972 instanceof class_1309) || !this.ldh(class_7462, class_13093 = (class_1309)class_12972) || !TargetStrafe.ldi(class_7462, (class_1297)class_13093, d) || !((d4 = TargetStrafe.ldj(class_7462, (class_1297)class_13093)) <= d3) || !(d4 < d2)) continue;
            d2 = d4;
            class_13092 = class_13093;
        }
        return class_13092;
    }

    private boolean ldh(class_746 class_7462, class_1309 class_13092) {
        if (class_13092 == class_7462 || class_13092.method_31481() || !class_13092.method_5805() || class_13092.method_29504() || class_13092 instanceof class_1531) {
            return false;
        }
        if (class_13092 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_13092;
            if (!this.lcq.get() || class_16572.method_7325() || Friends.protects((class_1297)class_16572)) {
                return false;
            }
        } else if (!this.lcr.get()) {
            return false;
        }
        return this.lcs.get() || class_7462.method_6057((class_1297)class_13092);
    }

    private static boolean ldi(class_746 class_7462, class_1297 class_12972, double d) {
        return class_7462.method_5858(class_12972) <= d * d;
    }

    private static double ldj(class_746 class_7462, class_1297 class_12972) {
        return Math.abs(TargetStrafe.ldk(class_7462, class_12972.method_5829().method_1005()));
    }

    private static double ldk(class_746 class_7462, class_243 class_2432) {
        class_243 class_2433 = class_7462.method_33571();
        double d = Math.toDegrees(Math.atan2(-(class_2432.field_1352 - class_2433.field_1352), class_2432.field_1350 - class_2433.field_1350));
        return class_3532.method_15338((double)(d - (double)class_7462.method_36454()));
    }

    private void ldl(long l) {
        if (lct == null) {
            lct = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1789", "D");
            lcu = Reflect.find(class_312.class, "net.minecraft.class_312", "field_47842", "D");
        }
        this.lcw = l;
        this.lcz = 0.0;
        this.lda = 0.0;
        this.ldb = Double.NaN;
        this.ldc = 0.0;
        this.ldd = 0.0;
        this.lcy = GLFWCursorPosCallback.create(this::ldn);
        this.lcx = GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)this.lcy);
    }

    private void ldm() {
        if (this.lcy == null) {
            return;
        }
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)this.lcw, (GLFWCursorPosCallbackI)this.lcx);
        if (gLFWCursorPosCallback != null && gLFWCursorPosCallback.address() == this.lcy.address()) {
            this.lcy.free();
        } else {
            GLFW.glfwSetCursorPosCallback((long)this.lcw, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        }
        this.lcy = null;
        this.lcx = null;
    }

    private void ldn(long l, double d, double d2) {
        if (this.lcx != null) {
            this.lcx.invoke(l, d, d2);
        }
        if (lct != null && lcu != null) {
            class_310.method_1551().execute(this::ldo);
        }
    }

    private void ldo() {
        if (this.lcy == null) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        try {
            double d = lct.getDouble(class_3102.field_1729);
            double d2 = lcu.getDouble(class_3102.field_1729);
            if (d2 != this.ldb) {
                this.ldc = d2 - this.ldb < 0.25 ? this.ldd : 0.0;
                this.ldd = 0.0;
                this.ldb = d2;
                this.lcz = d;
            } else {
                this.lcz += d - this.lda;
            }
            this.lda = this.lcz + this.ldp(class_3102, this.lcz);
            lct.setDouble(class_3102.field_1729, this.lda);
        }
        catch (IllegalAccessException illegalAccessException) {
            lct = null;
        }
    }

    private double ldp(class_310 class_3102, double d) {
        double d2;
        class_746 class_7462 = class_3102.field_1724;
        if (d == 0.0 || !this.isEnabled() || class_7462 == null || this.lcv == null || !this.lcv.method_5805() || !class_3102.field_1729.method_1613() || class_3102.field_1755 != null || class_3102.field_1690.field_1914 || FreeCam.active() || AutoMace.busy() || RecorderHooks.mode() == tcw.RECORD) {
            this.ldd = 0.0;
            return 0.0;
        }
        double d3 = d * TargetStrafe.ldq(class_3102, class_7462);
        if (((Boolean)class_3102.field_1690.method_72706().method_41753()).booleanValue()) {
            d3 = -d3;
        }
        double d4 = d3 * (d2 = TargetStrafe.ldk(class_7462, this.lcv.method_5829().method_1005())) > 0.0 ? this.lcl.get() : this.lcm.get();
        double d5 = class_3532.method_15350((double)(1.0 - Math.abs(d3) / this.lcn.get()), (double)0.0, (double)1.0);
        d4 = class_3532.method_16436((double)d5, (double)1.0, (double)d4);
        double d6 = d * (d4 - 1.0) + this.ldc;
        double d7 = Math.rint(d6);
        this.ldd = d6 - d7;
        return d7;
    }

    private static double ldq(class_310 class_3102, class_746 class_7462) {
        double d = (Double)class_3102.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = class_3102.field_1690.method_31044().method_31034() && class_7462.method_31550();
        return bl ? d2 : d2 * 8.0;
    }

    private static /* synthetic */ int avt(int n, int n2) {
        return n ^ n2 ^ 0xC943A990;
    }
}

