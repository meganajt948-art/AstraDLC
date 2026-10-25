/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  net.minecraft.client.texture.NativeImage
 */
package a;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import flow.dev.a;
import net.minecraft.client.texture.NativeImage;

public final class elb
implements AutoCloseable {
    public final int width;
    public final int height;
    private final NativeImage elc;
    private final GpuTexture eld;
    private final GpuTextureView ele;
    private static /* synthetic */ String elf;
    private static /* synthetic */ boolean elg;

    elb(String string, int n, int n2) {
        this.width = n;
        this.height = n2;
        GpuDevice gpuDevice = RenderSystem.getDevice();
        this.eld = gpuDevice.createTexture(() -> a.b("\ufa96\u830d\u09dd\u97b4\u1c26\u9a85\u2094\ua968\u372c\ubdc9", 7469786) + string, 5, TextureFormat.RGBA8, n, n2, 1, 1);
        this.ele = gpuDevice.createTextureView(this.eld);
        this.elc = new NativeImage(n, n2, false);
    }

    void set(int n, int n2, int n3) {
        this.elc.method_61941(n, n2, n3);
    }

    void upload() {
        RenderSystem.getDevice().createCommandEncoder().writeToTexture(this.eld, this.elc);
    }

    public GpuTextureView view() {
        return this.ele;
    }

    @Override
    public void close() {
        this.elc.close();
        this.ele.close();
        this.eld.close();
    }

    private static /* synthetic */ int gv(int n, int n2) {
        return n - n2 ^ 0xF6C790DF;
    }

    private static /* synthetic */ int gw(int n, int n2) {
        return elb.gv(n, n2) ^ 0x2164DFA9;
    }
}

