/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.CubeMapRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.RotatingCubeMapRenderer
 *  net.minecraft.client.render.GameRenderer
 */
package a;

import a.dry;
import a.jza;
import a.jzh;
import a.kam;
import a.kap;
import a.kbs;
import a.unf;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.render.GameRenderer;

public final class jrr
extends RotatingCubeMapRenderer {
    private static boolean jrs;
    private static boolean jrt;
    private static kap jru;
    private static long jrv;
    private static RotatingCubeMapRenderer jrw;
    private static Field jrx;
    private final kam jry = new kam();
    private float jrz;
    private float jsa;
    private long jsb;
    private static /* synthetic */ long jsc;
    private static /* synthetic */ boolean jsd;

    private jrr(CubeMapRenderer cubeMapRenderer) {
        super(cubeMapRenderer);
    }

    public static void tick(MinecraftClient minecraftClient) {
        if (jrt) {
            return;
        }
        try {
            if (!jrs) {
                jrs = true;
                jrr.jse(minecraftClient.gameRenderer);
            }
            if (jru != null && unf.frame() - jrv > 30L) {
                jru.close();
                jru = null;
            }
        }
        catch (Throwable throwable) {
            jrt = true;
            System.out.println(a.c(1885684234, "\u4254\u3bed\ub135\u2f5f\ua4dd\u222e\u987e\u118d\u8fda\u0564\u82a1\u78cd\uf605\u6fe4\ue5e2\u6308\ud948\u568e\ucc2a\u4a73\uc381\ub9dd\u376d\uacb2\u2ac4\ua05c\u19e3\u97e4\u0d04\u8b5a\u00ee\ufe3a\u7475\ued89\u6b9b\ue17a\u5ebc\ud4c2\u5210\ucbbc\u41f0\u3f0d\ub552\u32a2\ua826\u2650\u9f96\u153f\u937a\u08e2\u868b") + throwable);
        }
    }

    private static void jse(GameRenderer gameRenderer) throws IllegalAccessException {
        Field field = vxr.find(GameRenderer.class, a.d("\ua6be\udf04\u55c6\ucbed\u4079\uc6cc\u7c98\uf562\u6b3b\ue19b\u665b\u9c2d\u12e8\u8b03\u011d\u87e3\u3da1\ub262\u28d1\uaeac\u2733\u5d60\ud3d1", -73438213, -786313924), a.d("\uc2ec\ubb52\u318d\uaff5\u242a\ua2a0\u189a\u916d\u0f37\u858b\u0250", 2098788631, -875873386), a.d("\u8a97\uf304\u79dc\ue7bc\u6c30\ueac3\u5094\ud962\u4736\ucd81\u4a43\ub021\u3ef1\ua752\u2d5a\uabe7\u11a7\u9e7b\u04da\u828b\u0b50\u7169\uffdb\u640a\ue278", 1219864353, 275656163));
        Field field2 = vxr.find(GameRenderer.class, a.d("\ud5b8\uac02\u26c0\ub8eb\u337f\ub5ca\u0f9e\u8664\u183d\u929d\u155d\uef2b\u61ee\uf805\u721b\uf4e5\u4ea7\uc164\u5bd7\uddaa\u5435\u2e66\ua0d7", -901702366, -269760285), a.d("\u0524\u7c9a\uf645\u683d\ue3e2\u6568\udf52\u56a5\uc8ff\u424c\uc591", -1696417882, 1115468527), a.d("\u13b7\u6a24\ue0fc\u7e9c\uf510\u73e3\uc9b4\u4042\ude16\u54a1\ud363\u2901\ua7d1\u3e72\ub47a\u32c7\u8887\u075b\u9dfa\u1bab\u9270\ue849\u66f8\ufd2d\u7b58", -1674335628, -586565226));
        if (field == null || field2 == null || field.get(gameRenderer) instanceof jrr) {
            return;
        }
        jrx = field;
        jrw = (RotatingCubeMapRenderer)field.get(gameRenderer);
        field.set(gameRenderer, (Object)new jrr((CubeMapRenderer)field2.get(gameRenderer)));
    }

    public static void uninstall(MinecraftClient minecraftClient) {
        jrt = true;
        try {
            if (jrx != null && jrw != null && minecraftClient != null && minecraftClient.gameRenderer != null && jrx.get(minecraftClient.gameRenderer) instanceof jrr) {
                jrx.set(minecraftClient.gameRenderer, jrw);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (jru != null) {
            try {
                jru.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            jru = null;
        }
    }

    public void render(DrawContext context, int width, int height, boolean rotate) {
        jza jza2;
        if (dry.armed()) {
            super.render(context, width, height, rotate);
            return;
        }
        jza jza3 = jza2 = jrt ? null : jzh.get(kbs.selected().key);
        if (jza2 == null) {
            super.render(context, width, height, rotate);
            return;
        }
        try {
            unf.observe(context);
            jrv = unf.frame();
            if (jru == null) {
                jru = new kap();
            }
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            long l = System.nanoTime();
            float f = this.jsb == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.jsb) / 1.0E9f);
            this.jsb = l;
            float f2 = 1.0f - (float)Math.exp(-f * 2.2f);
            double d = Math.max(1, minecraftClient.getWindow().getWidth());
            double d2 = Math.max(1, minecraftClient.getWindow().getHeight());
            this.jrz += ((float)(minecraftClient.mouse.getX() / d) - 0.5f - this.jrz) * f2;
            this.jsa += ((float)(minecraftClient.mouse.getY() / d2) - 0.5f - this.jsa) * f2;
            kbs kbs2 = kbs.selected();
            this.jry.time = kap.clock();
            this.jry.zoom = 1.05f;
            this.jry.panX = -this.jrz * 0.014f;
            this.jry.panY = -this.jsa * 0.01f;
            this.jry.blur = 0.3f;
            this.jry.dim = 0.14f;
            this.jry.tint = kbs2.tint;
            this.jry.tintAmount = 0.3f;
            this.jry.fall = null;
            this.jry.pool = null;
            if (!jru.draw(context, jza2, this.jry, width, height, 1.0f, false)) {
                super.render(context, width, height, rotate);
            }
        }
        catch (Throwable throwable) {
            jrt = true;
            System.out.println(a.b("\u761f\u0fa6\u857e\u1b14\u9096\u1665\uac35\u25c6\ubb91\u312f\ub6ea\u4c86\uc24e\u5baf\ud1ba\u574c\ued0b\u62df\uf865\u7e35\uf78a\u8dd7\u0326\u98f4\u1e89\u9450\u2da8\ua3ad\u3941\ubf5f\u34b8\uca75\u4037\ud983\u5f80\ud520\u6af8\ue088\u6646\uffe4\u75b7\u0b4a\u8142\u06e9", 29193822) + throwable);
            super.render(context, width, height, rotate);
        }
    }

    private static /* synthetic */ int aps(int n, int n2) {
        return n + n2 | 0x54EC3177;
    }
}

