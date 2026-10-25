/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.nio.ByteBuffer;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class ujw {
    private static @Nullable GpuTexture ujx;
    private static @Nullable GpuTextureView ujy;
    private static @Nullable GpuBuffer ujz;
    private static int uka;
    private static int ukb;
    private static /* synthetic */ int ukc;
    private static /* synthetic */ boolean ukd;

    private ujw() {
    }

    public static @Nullable GpuTextureView worldWith(GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n) {
        if (!uvq.ensure(uvq.COMPOSITE)) {
            return null;
        }
        try {
            Framebuffer framebuffer = MinecraftClient.method_1551().method_1522();
            GpuTextureView gpuTextureView2 = framebuffer.method_71639();
            if (gpuTextureView2 == null || framebuffer.field_1482 < 4 || framebuffer.field_1481 < 4) {
                return null;
            }
            ujw.uke(framebuffer.field_1482, framebuffer.field_1481);
            GpuDevice gpuDevice = RenderSystem.getDevice();
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            float f6 = framebuffer.field_1482;
            float f7 = framebuffer.field_1481;
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                ByteBuffer byteBuffer = Std140Builder.onStack((MemoryStack)memoryStack, (int)32).putVec4(f / f6, 1.0f - f4 / f7, f3 / f6, 1.0f - f2 / f7).putVec4(f5, (float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f).get();
                commandEncoder.writeToBuffer(ujz.slice(), byteBuffer);
            }
            memoryStack = commandEncoder.createRenderPass(() -> "Flow2 composite", ujy, OptionalInt.empty());
            try {
                memoryStack.setPipeline(uvq.COMPOSITE);
                memoryStack.bindTexture("InSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                memoryStack.bindTexture("WallSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                memoryStack.setUniform("FlowComposite", ujz);
                memoryStack.draw(0, 3);
            }
            finally {
                if (memoryStack != null) {
                    memoryStack.close();
                }
            }
            return ujy;
        }
        catch (Throwable throwable) {
            System.out.println("composite failed: " + throwable);
            return null;
        }
    }

    private static void uke(int n, int n2) {
        GpuDevice gpuDevice = RenderSystem.getDevice();
        if (ujz == null) {
            ujz = gpuDevice.createBuffer(() -> "Flow2 composite", 136, 32L);
        }
        if (ujy != null && n == uka && n2 == ukb) {
            return;
        }
        if (ujy != null) {
            ujy.close();
            ujx.close();
        }
        int n3 = 12;
        ujx = gpuDevice.createTexture(() -> "Flow2 composite", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        ujy = gpuDevice.createTextureView(ujx);
        uka = n;
        ukb = n2;
    }

    static {
        uka = -1;
        ukb = -1;
    }

    private static /* synthetic */ int cxt(int n, int n2) {
        return n + n2 ^ 0x76E8D741;
    }

    private static /* synthetic */ int cxu(int n, int n2) {
        return ujw.cxt(n, n2) ^ 0x81857F3C;
    }

    private static /* synthetic */ int cxv(int n, int n2) {
        return n * n2 + 550845903;
    }
}

