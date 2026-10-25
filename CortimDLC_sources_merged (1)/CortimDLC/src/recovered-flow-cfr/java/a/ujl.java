/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.CloudRenderer
 */
package a;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.CloudRenderer;

public final class ujl {
    private static final Set<Object> ujm = new HashSet<Object>();
    private static Field ujn;
    private static boolean ujo;
    private static Object ujp;
    private static /* synthetic */ long ujq;
    private static /* synthetic */ int ujr;

    private ujl() {
    }

    public static void hide(Object object, boolean bl) {
        if (bl) {
            ujm.add(object);
        } else {
            ujm.remove(object);
        }
        ujl.ujs(!ujm.isEmpty());
    }

    private static void ujs(boolean bl) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (ujo || minecraftClient.field_1769 == null) {
            return;
        }
        try {
            CloudRenderer cloudRenderer = minecraftClient.field_1769.method_62196();
            if (ujn == null) {
                for (Field field : CloudRenderer.class.getDeclaredFields()) {
                    if (!field.getType().isRecord() || field.getType().getEnclosingClass() != CloudRenderer.class) continue;
                    field.setAccessible(true);
                    ujn = field;
                    break;
                }
                if (ujn == null) {
                    throw new IllegalStateException("cloud cells field not found");
                }
            }
            Object object = ujn.get(cloudRenderer);
            if (bl) {
                if (object != null) {
                    ujp = object;
                    ujn.set(cloudRenderer, null);
                }
            } else if (ujp != null) {
                if (object == null) {
                    ujn.set(cloudRenderer, ujp);
                }
                ujp = null;
            }
        }
        catch (Throwable throwable) {
            ujo = true;
            System.out.println("can't hide clouds: " + throwable);
        }
    }

    private static /* synthetic */ int cxj(int n, int n2) {
        return n + n2 + 1437894466;
    }

    private static /* synthetic */ int cxk(int n, int n2) {
        return ujl.cxj(n, n2) * n2;
    }

    private static /* synthetic */ int cxl(int n, int n2) {
        return n + n2 ^ 0xC72A9146;
    }
}

