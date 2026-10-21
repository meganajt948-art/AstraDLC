/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_757
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWScrollCallback
 *  org.lwjgl.glfw.GLFWScrollCallbackI
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Reflect;
import a.KeyUtil;
import a.OptionOverride;
import java.lang.reflect.Field;
import net.minecraft.class_310;
import net.minecraft.class_757;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;

public class Zoom
extends Module {
    private static Zoom sjm;
    private final KeySetting sjn = this.add(new KeySetting("Key", 67));
    private final ModeSetting sjo = this.add(new ModeSetting("Press", "Hold", "Hold", "Toggle"));
    private final NumberSetting sjp = this.add(new NumberSetting(new String(new char[]{'Z', 'o', 'o', 'm'}), 4.0, 1.5, 15.0, 0.5).unit("x"));
    private final NumberSetting sjq = this.add(new NumberSetting("Speed", 1.0, 0.3, 3.0, 0.1).unit("x"));
    private final BoolSetting sjr = this.add(new BoolSetting("Scroll", true));
    private final BoolSetting sjs = this.add(new BoolSetting("Slow mouse", true));
    private final BoolSetting sjt = this.add(new BoolSetting("Cinematic", false));
    private static final OptionOverride<Double> sju;
    private static Field sjv;
    private static Field sjw;
    private static boolean sjx;
    private boolean sjy;
    private double sjz;
    private double ska = 1.0;
    private long skb;
    private boolean skc;
    private boolean skd;
    private boolean ske;
    private static GLFWScrollCallback skf;
    private static GLFWScrollCallbackI skg;
    private static long skh;
    private boolean ski;
    private static /* synthetic */ long skj;
    private static /* synthetic */ long skk;

    public Zoom() {
        super(new String(new char[]{'Z', 'o', 'o', 'm'}), "Smooth zoom on a key", ModuleCategory.RENDER);
        sjm = this;
        this.sjz = this.sjp.get();
    }

    public static boolean zooming() {
        return sjm != null && sjm.isEnabled() && Zoom.sjm.ska > 1.01;
    }

    @Override
    protected void onDisable() {
        this.sjy = false;
        this.ska = 1.0;
        this.skn(class_310.method_1551());
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (n == this.sjn.get() && this.sjo.is("Toggle")) {
            this.sjy = !this.sjy;
            this.sjz = this.sjp.get();
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        this.skm(class_3102);
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        long l = System.nanoTime();
        double d = this.skb == 0L ? 0.0 : Math.min(0.1, (double)(l - this.skb) / 1.0E9);
        this.skb = l;
        boolean bl = this.skl(class_3102);
        if (bl && !this.ski) {
            this.sjz = this.sjp.get();
            Zoom.skp(class_3102);
        }
        this.ski = bl;
        double d2 = bl ? this.sjz : 1.0;
        double d3 = 1.0 - Math.exp(-d * 13.0 * this.sjq.get());
        this.ska = Math.exp(Math.log(this.ska) + (Math.log(d2) - Math.log(this.ska)) * d3);
        if (Math.abs(this.ska - d2) < 0.002) {
            this.ska = d2;
        }
        this.skm(class_3102);
    }

    private boolean skl(class_310 class_3102) {
        if (class_3102.field_1755 != null || class_3102.field_1724 == null) {
            return this.sjo.is("Toggle") && this.sjy;
        }
        return this.sjo.is("Toggle") ? this.sjy : KeyUtil.isDown(class_3102, this.sjn.get());
    }

    private void skm(class_310 class_3102) {
        if (class_3102.field_1724 == null || class_3102.field_1773 == null) {
            return;
        }
        if (this.ska <= 1.001) {
            this.skn(class_3102);
            return;
        }
        if (!Zoom.sko()) {
            return;
        }
        this.skc = true;
        float f = class_3102.field_1724.method_3118(class_3102.field_1690.method_31044().method_31034(), ((Double)class_3102.field_1690.method_42454().method_41753()).floatValue());
        float f2 = (float)((double)f / this.ska);
        try {
            sjv.setFloat(class_3102.field_1773, f2);
            sjw.setFloat(class_3102.field_1773, f2);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            sjx = true;
        }
        if (this.sjs.get() && !OptionOverride.suspended(class_3102)) {
            Double d = sju.own();
            if (d != null) {
                double d2 = d * 0.6 + 0.2;
                double d3 = d2 * Math.cbrt(1.0 / this.ska);
                sju.override(Math.max(0.0, (d3 - 0.2) / 0.6));
            }
        } else {
            sju.release();
        }
        if (this.sjt.get() && !this.ske) {
            this.skd = class_3102.field_1690.field_1914;
            class_3102.field_1690.field_1914 = true;
            this.ske = true;
        }
    }

    private void skn(class_310 class_3102) {
        if (this.skc && class_3102.field_1724 != null && class_3102.field_1773 != null && Zoom.sko()) {
            float f = class_3102.field_1724.method_3118(class_3102.field_1690.method_31044().method_31034(), ((Double)class_3102.field_1690.method_42454().method_41753()).floatValue());
            try {
                sjv.setFloat(class_3102.field_1773, f);
                sjw.setFloat(class_3102.field_1773, f);
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        this.skc = false;
        sju.release();
        if (this.ske) {
            class_3102.field_1690.field_1914 = this.skd;
            this.ske = false;
        }
    }

    private static boolean sko() {
        if (sjv == null && !sjx) {
            sjv = Reflect.find(class_757.class, "net.minecraft.class_757", "field_4019", "F");
            sjw = Reflect.find(class_757.class, "net.minecraft.class_757", "field_3999", "F");
            sjx = sjv == null || sjw == null;
        }
        return !sjx;
    }

    private static void skp(class_310 class_3102) {
        if (class_3102.method_22683() == null) {
            return;
        }
        long l = class_3102.method_22683().method_4490();
        if (skh == l && skf != null) {
            return;
        }
        try {
            if (skf == null) {
                skf = GLFWScrollCallback.create(Zoom::skq);
            }
            GLFWScrollCallback gLFWScrollCallback = GLFW.glfwSetScrollCallback((long)l, (GLFWScrollCallbackI)skf);
            skg = gLFWScrollCallback;
            skh = l;
        }
        catch (Throwable throwable) {
            System.out.println(new String(new char[]{'[', 'F', 'l', 'o', 'w', '2', ']', ' ', 'w', 'h', 'e', 'e', 'l', ' ', 'h', 'o', 'o', 'k', ':', ' '}) + throwable);
            skh = l;
        }
    }

    private static void skq(long l, double d, double d2) {
        Zoom sjl2 = sjm;
        class_310 class_3102 = class_310.method_1551();
        if (sjl2 != null && sjl2.isEnabled() && sjl2.sjr.get() && class_3102.field_1755 == null && sjl2.ski && d2 != 0.0) {
            sjl2.sjz = Math.max(1.5, Math.min(40.0, sjl2.sjz * Math.pow(1.18, d2)));
            return;
        }
        if (skg != null) {
            skg.invoke(l, d, d2);
        }
    }

    static {
        sju = new OptionOverride(class_3102 -> class_3102.field_1690.method_42495());
    }

    private static /* synthetic */ int cdz(int n, int n2) {
        return n * n2 + -2117645784;
    }
}

