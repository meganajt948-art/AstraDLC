/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1044
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_742
 *  net.minecraft.class_8685
 */
package a;

import a.DrawUtil;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_742;
import net.minecraft.class_8685;

public final class PlayerHeadDraw {
    private static /* synthetic */ boolean uoh;
    private static /* synthetic */ long uoi;

    private PlayerHeadDraw() {
    }

    public static boolean draw(class_332 class_3322, class_742 class_7422, float f, float f2, float f3, float f4, int n) {
        class_8685 class_86852;
        try {
            class_86852 = class_7422.method_52814();
        }
        catch (Throwable throwable) {
            return false;
        }
        return PlayerHeadDraw.draw(class_3322, class_86852, f, f2, f3, f4, n);
    }

    public static boolean draw(class_332 class_3322, class_8685 class_86852, float f, float f2, float f3, float f4, int n) {
        GpuTextureView gpuTextureView = PlayerHeadDraw.uoj(class_86852);
        if (gpuTextureView == null) {
            return false;
        }
        DrawUtil.imageRegion(class_3322, gpuTextureView, f, f2, f3, f3, f4, 0.125f, 0.125f, 0.25f, 0.25f, n, true);
        float f5 = f3 * 0.06f;
        DrawUtil.imageRegion(class_3322, gpuTextureView, f - f5, f2 - f5, f3 + f5 * 2.0f, f3 + f5 * 2.0f, f4 + f5, 0.625f, 0.125f, 0.75f, 0.25f, n, true);
        return true;
    }

    private static GpuTextureView uoj(class_8685 class_86852) {
        try {
            class_2960 class_29602 = class_86852.comp_1626().comp_3627();
            class_1044 class_10443 = class_310.method_1551().method_1531().method_4619(class_29602);
            return class_10443 != null ? class_10443.method_71659() : null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static /* synthetic */ int cyy(int n, int n2) {
        return n - n2 + 364130784;
    }

    private static /* synthetic */ int cyz(int n, int n2) {
        return PlayerHeadDraw.cyy(n, n2) ^ 0xA7B0B127;
    }
}

