/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.math.MathHelper
 */
package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

public final class prp {
    private static final double prq = (double)0.15f;
    private static /* synthetic */ String prr;
    private static /* synthetic */ boolean prs;

    private prp() {
    }

    public static double multiplier() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.options == null) {
            return 0.0;
        }
        double d = (Double)minecraftClient.options.getMouseSensitivity().getValue() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        return minecraftClient.player != null && minecraftClient.options.getPerspective().isFirstPerson() && minecraftClient.player.isUsingSpyglass() ? d2 : d2 * 8.0;
    }

    public static double step() {
        return prp.step(prp.multiplier());
    }

    public static double step(double d) {
        return d * (double)0.15f;
    }

    public static float quantize(double d, double d2) {
        if (!Double.isFinite(d) || d2 <= 0.0) {
            return 0.0f;
        }
        long l = Math.round(d / (d2 * (double)0.15f));
        return (float)((double)l * d2) * 0.15f;
    }

    public static float[] apply(float f, float f2, float f3, float f4) {
        double d = prp.multiplier();
        if (!(!(d <= 0.0) && Float.isFinite(f3) && Float.isFinite(f4) && Float.isFinite(f) && Float.isFinite(f2))) {
            return new float[]{f3, f4};
        }
        double d2 = (double)f3 - (double)f;
        double d3 = Math.floor((d2 + 180.0) / 360.0) * 360.0;
        float f5 = (float)((double)f + d3) + prp.quantize(d2 - d3, d);
        float f6 = MathHelper.clamp((float)(f2 + prp.quantize((double)f4 - (double)f2, d)), (float)-90.0f, (float)90.0f);
        return new float[]{Float.isFinite(f5) ? f5 : f3, Float.isFinite(f6) ? f6 : f4};
    }

    private static /* synthetic */ int bne(int n, int n2) {
        return n - n2 ^ 0x31912646;
    }

    private static /* synthetic */ int bnf(int n, int n2) {
        return prp.bne(n, n2) + n;
    }
}

