/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package a;

import a.hwr;
import a.iov;
import a.irr;
import a.isn;
import a.isv;
import a.izx;
import a.jzh;
import a.kbs;
import a.vdn;
import a.veo;
import a.whl;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.util.List;
import java.util.function.BooleanSupplier;
import net.minecraft.client.MinecraftClient;

public final class hzl {
    private static /* synthetic */ boolean hzm;
    private static /* synthetic */ long hzn;

    private hzl() {
    }

    public static void steps(List<BooleanSupplier> list) {
        float f;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        hzl.hzp(irr.class);
        hzl.hzp(izx.class);
        float f2 = 1.0f;
        if (minecraftClient.getWindow() != null) {
            f = minecraftClient.getWindow().getScaledWidth();
            float f3 = minecraftClient.getWindow().getScaledHeight();
            float f4 = Math.min((f - 16.0f) / 540.0f, (f3 - 16.0f) / 409.0f);
            f2 = Math.max(0.3f, Math.min((float)iov.SCALE.get(), f4));
        }
        f = f2;
        for (vdn vdn2 : veo.all()) {
            list.add(() -> hzl.hzo(vdn2, 1.0f));
            if (!(Math.abs(f - 1.0f) > 0.01f)) continue;
            list.add(() -> hzl.hzo(vdn2, f));
        }
        String string = kbs.selected().key;
        list.add(() -> jzh.warm(string));
        list.add(() -> {
            whl.warm(string, isv.selected());
            return true;
        });
        for (kbs kbs2 : kbs.values()) {
            list.add(() -> jzh.warmThumb(kbs2.key));
        }
        for (isn isn2 : isv.entries()) {
            list.add(() -> isn2.isWorld() || isn2.failed || isv.thumbnail(isn2) != null);
        }
        for (CosmeticItem cosmeticItem : Cosmetics.items()) {
            list.add(() -> {
                hwr.thumb(cosmeticItem.id);
                return true;
            });
        }
    }

    private static boolean hzo(vdn vdn2, float f) {
        vdn.setRenderScale(f);
        try {
            vdn2.width(a.b("\u54aa\u2d3b\ua7a9\u3dd7\ub660\u34be\u8efd", 1876645100));
        }
        finally {
            vdn.setRenderScale(1.0f);
        }
        return true;
    }

    private static void hzp(Class<?> clazz) {
        try {
            Class.forName(clazz.getName(), true, clazz.getClassLoader());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int aef(int n, int n2) {
        return n - n2 ^ 0x3123A5F4;
    }

    private static /* synthetic */ int aeg(int n, int n2) {
        return n + n2 + 422155920;
    }
}

