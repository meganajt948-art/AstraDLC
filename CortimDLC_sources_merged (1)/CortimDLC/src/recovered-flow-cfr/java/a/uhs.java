/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  net.minecraft.world.LightType
 *  net.minecraft.world.attribute.EnvironmentAttributes
 */
package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.world.LightType;
import net.minecraft.world.attribute.EnvironmentAttributes;

public final class uhs {
    private static float uht = -1.0f;
    private static long uhu;
    private static /* synthetic */ String uhv;
    private static /* synthetic */ boolean uhw;

    private uhs() {
    }

    public static float daylight(MinecraftClient minecraftClient) {
        try {
            Float f = (Float)minecraftClient.field_1773.method_19418().method_75756().method_75689(EnvironmentAttributes.field_64346, 1.0f);
            return f == null ? 1.0f : Math.max(0.0f, Math.min(1.0f, f.floatValue()));
        }
        catch (RuntimeException runtimeException) {
            return 1.0f;
        }
    }

    public static float boost(MinecraftClient minecraftClient) {
        Double d = (Double)minecraftClient.field_1690.method_42473().method_41753();
        return d == null ? 0.0f : (float)Math.max(0.0, Math.min(1.0, (d - 1.0) / 5.0));
    }

    public static float light(MinecraftClient minecraftClient) {
        float f;
        Camera camera = minecraftClient.field_1773.method_19418();
        float f2 = 0.5f;
        if (minecraftClient.field_1687 != null && camera.method_19332()) {
            float f3 = (float)minecraftClient.field_1687.method_8314(LightType.field_9284, camera.method_19328()) / 15.0f;
            float f4 = (float)minecraftClient.field_1687.method_8314(LightType.field_9282, camera.method_19328()) / 15.0f;
            f = uhs.daylight(minecraftClient);
            f2 = Math.max(f3 * (0.18f + 0.82f * f), f4 * 0.75f);
            f2 = Math.max(f2, 0.08f);
            f2 += (1.0f - f2) * uhs.boost(minecraftClient);
        }
        long l = System.nanoTime();
        f = uhu == 0L ? 1.0f : Math.min(1.0f, (float)(l - uhu) / 1.0E9f);
        uhu = l;
        uht = uht < 0.0f ? f2 : (uht += (f2 - uht) * (1.0f - (float)Math.exp(-f / 0.6f)));
        return uht;
    }

    private static /* synthetic */ int cwx(int n, int n2) {
        return n + n2 | 0x94FD0799;
    }

    private static /* synthetic */ int cwy(int n, int n2) {
        return uhs.cwx(n, n2) ^ 0xFE129B17;
    }
}

