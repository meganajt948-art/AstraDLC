/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.entity.player.SkinTextures
 *  net.minecraft.util.Identifier
 */
package a;

import a.uut;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.util.Identifier;

public final class uog {
    private static /* synthetic */ boolean uoh;
    private static /* synthetic */ long uoi;

    private uog() {
    }

    public static boolean draw(DrawContext drawContext, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float f2, float f3, float f4, int n) {
        SkinTextures skinTextures;
        try {
            skinTextures = abstractClientPlayerEntity.method_52814();
        }
        catch (Throwable throwable) {
            return false;
        }
        return uog.draw(drawContext, skinTextures, f, f2, f3, f4, n);
    }

    public static boolean draw(DrawContext drawContext, SkinTextures skinTextures, float f, float f2, float f3, float f4, int n) {
        GpuTextureView gpuTextureView = uog.uoj(skinTextures);
        if (gpuTextureView == null) {
            return false;
        }
        uut.imageRegion(drawContext, gpuTextureView, f, f2, f3, f3, f4, 0.125f, 0.125f, 0.25f, 0.25f, n, true);
        float f5 = f3 * 0.06f;
        uut.imageRegion(drawContext, gpuTextureView, f - f5, f2 - f5, f3 + f5 * 2.0f, f3 + f5 * 2.0f, f4 + f5, 0.625f, 0.125f, 0.75f, 0.25f, n, true);
        return true;
    }

    private static GpuTextureView uoj(SkinTextures skinTextures) {
        try {
            Identifier identifier = skinTextures.comp_1626().comp_3627();
            AbstractTexture abstractTexture = MinecraftClient.method_1551().method_1531().method_4619(identifier);
            return abstractTexture != null ? abstractTexture.method_71659() : null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static /* synthetic */ int cyy(int n, int n2) {
        return n - n2 + 364130784;
    }

    private static /* synthetic */ int cyz(int n, int n2) {
        return uog.cyy(n, n2) ^ 0xA7B0B127;
    }
}

