/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  net.minecraft.class_1011
 */
package a;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.awt.image.BufferedImage;
import net.minecraft.class_1011;

public final class GpuTexture
implements AutoCloseable {
    public final int width;
    public final int height;
    public final GpuTextureView view;
    private final GpuTexture uol;
    private static /* synthetic */ long uom;
    private static /* synthetic */ boolean uon;

    private GpuTexture(int n, int n2, GpuTexture gpuTexture, GpuTextureView gpuTextureView) {
        this.width = n;
        this.height = n2;
        this.uol = gpuTexture;
        this.view = gpuTextureView;
    }

    public static GpuTexture upload(String string, BufferedImage bufferedImage, boolean bl) {
        return GpuTexture.upload(string, bufferedImage, bl, false);
    }

    public static GpuTexture upload(String string, BufferedImage bufferedImage, boolean bl, boolean bl2) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n, n2, null, 0, n);
        int n3 = bl2 ? 0 : -16777216;
        GpuDevice gpuDevice = RenderSystem.getDevice();
        GpuTexture gpuTexture = gpuDevice.createTexture(() -> "Flow2 " + string, 5, TextureFormat.RGBA8, n, n2, 1, 1);
        try (class_1011 class_10112 = new class_1011(n, n2, false);){
            for (int i = 0; i < n2; ++i) {
                int n4 = (bl ? n2 - 1 - i : i) * n;
                for (int j = 0; j < n; ++j) {
                    class_10112.method_61941(j, i, nArray[n4 + j] | n3);
                }
            }
            gpuDevice.createCommandEncoder().writeToTexture(gpuTexture, class_10112);
        }
        return new GpuTexture(n, n2, gpuTexture, gpuDevice.createTextureView(gpuTexture));
    }

    public static GpuTexture target(String string, int n, int n2) {
        GpuDevice gpuDevice = RenderSystem.getDevice();
        GpuTexture gpuTexture = gpuDevice.createTexture(() -> "Flow2 " + string, 12, TextureFormat.RGBA8, n, n2, 1, 1);
        return new GpuTexture(n, n2, gpuTexture, gpuDevice.createTextureView(gpuTexture));
    }

    public GpuTexture gpuTexture() {
        return this.uol;
    }

    @Override
    public void close() {
        this.view.close();
        this.uol.close();
    }

    private static /* synthetic */ int czc(int n, int n2) {
        return n * n2 ^ 0x88017FDF;
    }

    private static /* synthetic */ int czd(int n, int n2) {
        return n + n2 | 0xE652EC9;
    }

    private static /* synthetic */ int cze(int n, int n2) {
        return GpuTexture.czc(n, n2) + n;
    }
}

