/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_751
 *  net.minecraft.class_757
 *  net.minecraft.class_766
 */
package a;

import a.PanicShutdown;
import a.jza;
import a.MenuArtCache;
import a.kam;
import a.MenuSceneRenderer;
import a.WallpaperEntry;
import a.FrameDelta;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_751;
import net.minecraft.class_757;
import net.minecraft.class_766;

public final class PanoramaHook
extends class_766 {
    private static boolean jrs;
    private static boolean jrt;
    private static MenuSceneRenderer jru;
    private static long jrv;
    private static class_766 jrw;
    private static Field jrx;
    private final kam jry = new kam();
    private float jrz;
    private float jsa;
    private long jsb;
    private static /* synthetic */ long jsc;
    private static /* synthetic */ boolean jsd;

    private PanoramaHook(class_751 class_7512) {
        super(class_7512);
    }

    public static void tick(class_310 class_3102) {
        if (jrt) {
            return;
        }
        try {
            if (!jrs) {
                jrs = true;
                PanoramaHook.jse(class_3102.field_1773);
            }
            if (jru != null && FrameDelta.frame() - jrv > 30L) {
                jru.close();
                jru = null;
            }
        }
        catch (Throwable throwable) {
            jrt = true;
            System.out.println("menu backdrop unavailable, vanilla panorama stays: " + throwable);
        }
    }

    private static void jse(class_757 class_7572) throws IllegalAccessException {
        Field field = Reflect.find(class_757.class, "net.minecraft.class_757", "field_60580", "Lnet/minecraft/class_766;");
        Field field2 = Reflect.find(class_757.class, "net.minecraft.class_757", "field_60579", "Lnet/minecraft/class_751;");
        if (field == null || field2 == null || field.get(class_7572) instanceof PanoramaHook) {
            return;
        }
        jrx = field;
        jrw = (class_766)field.get(class_7572);
        field.set(class_7572, (Object)new PanoramaHook((class_751)field2.get(class_7572)));
    }

    public static void uninstall(class_310 class_3102) {
        jrt = true;
        try {
            if (jrx != null && jrw != null && class_3102 != null && class_3102.field_1773 != null && jrx.get(class_3102.field_1773) instanceof PanoramaHook) {
                jrx.set(class_3102.field_1773, jrw);
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

    public void method_3317(class_332 class_3322, int n, int n2, boolean bl) {
        jza jza2;
        if (PanicShutdown.armed()) {
            super.method_3317(class_3322, n, n2, bl);
            return;
        }
        jza jza3 = jza2 = jrt ? null : MenuArtCache.get(WallpaperEntry.selected().key);
        if (jza2 == null) {
            super.method_3317(class_3322, n, n2, bl);
            return;
        }
        try {
            FrameDelta.observe(class_3322);
            jrv = FrameDelta.frame();
            if (jru == null) {
                jru = new MenuSceneRenderer();
            }
            class_310 class_3102 = class_310.method_1551();
            long l = System.nanoTime();
            float f = this.jsb == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.jsb) / 1.0E9f);
            this.jsb = l;
            float f2 = 1.0f - (float)Math.exp(-f * 2.2f);
            double d = Math.max(1, class_3102.method_22683().method_4480());
            double d2 = Math.max(1, class_3102.method_22683().method_4507());
            this.jrz += ((float)(class_3102.field_1729.method_1603() / d) - 0.5f - this.jrz) * f2;
            this.jsa += ((float)(class_3102.field_1729.method_1604() / d2) - 0.5f - this.jsa) * f2;
            WallpaperEntry kbs2 = WallpaperEntry.selected();
            this.jry.time = MenuSceneRenderer.clock();
            this.jry.zoom = 1.05f;
            this.jry.panX = -this.jrz * 0.014f;
            this.jry.panY = -this.jsa * 0.01f;
            this.jry.blur = 0.3f;
            this.jry.dim = 0.14f;
            this.jry.tint = kbs2.tint;
            this.jry.tintAmount = 0.3f;
            this.jry.fall = null;
            this.jry.pool = null;
            if (!jru.draw(class_3322, jza2, this.jry, n, n2, 1.0f, false)) {
                super.method_3317(class_3322, n, n2, bl);
            }
        }
        catch (Throwable throwable) {
            jrt = true;
            System.out.println("menu backdrop failed, back to the panorama: " + throwable);
            super.method_3317(class_3322, n, n2, bl);
        }
    }

    private static /* synthetic */ int aps(int n, int n2) {
        return n + n2 | 0x54EC3177;
    }
}

