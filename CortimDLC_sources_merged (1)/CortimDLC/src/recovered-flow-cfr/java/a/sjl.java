/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.GameRenderer
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWScrollCallback
 *  org.lwjgl.glfw.GLFWScrollCallbackI
 */
package a;

import a.kfa;
import a.kfe;
import a.vkl;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vxr;
import a.vzz;
import a.wbu;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;

public class sjl
extends kfe {
    private static sjl sjm;
    private final vlq sjn = this.add(new vlq("Key", 67));
    private final vlv sjo = this.add(new vlv("Press", "Hold", "Hold", "Toggle"));
    private final vmc sjp = this.add(new vmc(new String(new char[]{'Z', 'o', 'o', 'm'}), 4.0, 1.5, 15.0, 0.5).unit("x"));
    private final vmc sjq = this.add(new vmc("Speed", 1.0, 0.3, 3.0, 0.1).unit("x"));
    private final vkl sjr = this.add(new vkl("Scroll", true));
    private final vkl sjs = this.add(new vkl("Slow mouse", true));
    private final vkl sjt = this.add(new vkl("Cinematic", false));
    private static final wbu<Double> sju;
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

    public sjl() {
        super(new String(new char[]{'Z', 'o', 'o', 'm'}), "Smooth zoom on a key", kfa.RENDER);
        sjm = this;
        this.sjz = this.sjp.get();
    }

    public static boolean zooming() {
        return sjm != null && sjm.isEnabled() && sjl.sjm.ska > 1.01;
    }

    @Override
    protected void onDisable() {
        this.sjy = false;
        this.ska = 1.0;
        this.skn(MinecraftClient.method_1551());
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (n == this.sjn.get() && this.sjo.is("Toggle")) {
            this.sjy = !this.sjy;
            this.sjz = this.sjp.get();
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        this.skm(minecraftClient);
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        long l = System.nanoTime();
        double d = this.skb == 0L ? 0.0 : Math.min(0.1, (double)(l - this.skb) / 1.0E9);
        this.skb = l;
        boolean bl = this.skl(minecraftClient);
        if (bl && !this.ski) {
            this.sjz = this.sjp.get();
            sjl.skp(minecraftClient);
        }
        this.ski = bl;
        double d2 = bl ? this.sjz : 1.0;
        double d3 = 1.0 - Math.exp(-d * 13.0 * this.sjq.get());
        this.ska = Math.exp(Math.log(this.ska) + (Math.log(d2) - Math.log(this.ska)) * d3);
        if (Math.abs(this.ska - d2) < 0.002) {
            this.ska = d2;
        }
        this.skm(minecraftClient);
    }

    private boolean skl(MinecraftClient minecraftClient) {
        if (minecraftClient.field_1755 != null || minecraftClient.field_1724 == null) {
            return this.sjo.is("Toggle") && this.sjy;
        }
        return this.sjo.is("Toggle") ? this.sjy : vzz.isDown(minecraftClient, this.sjn.get());
    }

    private void skm(MinecraftClient minecraftClient) {
        if (minecraftClient.field_1724 == null || minecraftClient.field_1773 == null) {
            return;
        }
        if (this.ska <= 1.001) {
            this.skn(minecraftClient);
            return;
        }
        if (!sjl.sko()) {
            return;
        }
        this.skc = true;
        float f = minecraftClient.field_1724.method_3118(minecraftClient.field_1690.method_31044().method_31034(), ((Double)minecraftClient.field_1690.method_42454().method_41753()).floatValue());
        float f2 = (float)((double)f / this.ska);
        try {
            sjv.setFloat(minecraftClient.field_1773, f2);
            sjw.setFloat(minecraftClient.field_1773, f2);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            sjx = true;
        }
        if (this.sjs.get() && !wbu.suspended(minecraftClient)) {
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
            this.skd = minecraftClient.field_1690.field_1914;
            minecraftClient.field_1690.field_1914 = true;
            this.ske = true;
        }
    }

    private void skn(MinecraftClient minecraftClient) {
        if (this.skc && minecraftClient.field_1724 != null && minecraftClient.field_1773 != null && sjl.sko()) {
            float f = minecraftClient.field_1724.method_3118(minecraftClient.field_1690.method_31044().method_31034(), ((Double)minecraftClient.field_1690.method_42454().method_41753()).floatValue());
            try {
                sjv.setFloat(minecraftClient.field_1773, f);
                sjw.setFloat(minecraftClient.field_1773, f);
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        this.skc = false;
        sju.release();
        if (this.ske) {
            minecraftClient.field_1690.field_1914 = this.skd;
            this.ske = false;
        }
    }

    private static boolean sko() {
        if (sjv == null && !sjx) {
            sjv = vxr.find(GameRenderer.class, "net.minecraft.class_757", "field_4019", "F");
            sjw = vxr.find(GameRenderer.class, "net.minecraft.class_757", "field_3999", "F");
            sjx = sjv == null || sjw == null;
        }
        return !sjx;
    }

    private static void skp(MinecraftClient minecraftClient) {
        if (minecraftClient.method_22683() == null) {
            return;
        }
        long l = minecraftClient.method_22683().method_4490();
        if (skh == l && skf != null) {
            return;
        }
        try {
            if (skf == null) {
                skf = GLFWScrollCallback.create(sjl::skq);
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
        sjl sjl2 = sjm;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (sjl2 != null && sjl2.isEnabled() && sjl2.sjr.get() && minecraftClient.field_1755 == null && sjl2.ski && d2 != 0.0) {
            sjl2.sjz = Math.max(1.5, Math.min(40.0, sjl2.sjz * Math.pow(1.18, d2)));
            return;
        }
        if (skg != null) {
            skg.invoke(l, d, d2);
        }
    }

    static {
        sju = new wbu(minecraftClient -> minecraftClient.field_1690.method_42495());
    }

    private static /* synthetic */ int cdz(int n, int n2) {
        return n * n2 + -2117645784;
    }
}

