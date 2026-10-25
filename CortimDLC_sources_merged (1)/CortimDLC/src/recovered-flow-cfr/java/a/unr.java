/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.GpuSampler
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.nio.ByteBuffer;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GpuSampler;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class unr {
    private static final int uns = 3;
    private static final int unt = 48;
    private static @Nullable GpuTexture unu;
    private static @Nullable GpuTextureView unv;
    private static final GpuTexture[] unw;
    private static final GpuTextureView[] unx;
    private static @Nullable GpuBuffer uny;
    private static int unz;
    private static int uoa;
    private static boolean uob;
    private static /* synthetic */ String uoc;
    private static /* synthetic */ int uod;

    private unr() {
    }

    public static void apply(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (uob || !uvq.ensure(uvq.GRADE) || !uvq.ensure(uvq.BLUR_COPY) || f6 > 0.0f && (!uvq.ensure(uvq.BLUR_DOWN) || !uvq.ensure(uvq.BLUR_UP))) {
            return;
        }
        Framebuffer framebuffer = MinecraftClient.getInstance().getFramebuffer();
        GpuTextureView gpuTextureView = framebuffer.getColorAttachmentView();
        if (gpuTextureView == null || framebuffer.textureWidth < 8 || framebuffer.textureHeight < 8) {
            return;
        }
        try {
            ByteBuffer byteBuffer;
            unr.uof(framebuffer.textureWidth, framebuffer.textureHeight);
            GpuDevice gpuDevice = RenderSystem.getDevice();
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            GpuSampler gpuSampler = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                byteBuffer = Std140Builder.onStack((MemoryStack)memoryStack, (int)48).putVec4(f, f2, f3, f4).putVec4(f5, f6, 1.0f / (float)framebuffer.textureWidth, 1.0f / (float)framebuffer.textureHeight).putVec4(f7, 0.62f, 0.0f, 0.0f).get();
                commandEncoder.writeToBuffer(uny.slice(), byteBuffer);
            }
            memoryStack = gpuTextureView;
            if (f6 > 0.0f) {
                int n;
                byteBuffer = gpuTextureView;
                for (n = 0; n < 3; ++n) {
                    unr.uoe(commandEncoder, uvq.BLUR_DOWN, (GpuTextureView)byteBuffer, unx[n], gpuSampler);
                    byteBuffer = unx[n];
                }
                for (n = 2; n > 0; --n) {
                    unr.uoe(commandEncoder, uvq.BLUR_UP, unx[n], unx[n - 1], gpuSampler);
                }
                memoryStack = unx[0];
            }
            byteBuffer = commandEncoder.createRenderPass(() -> "Flow2 grade", unv, OptionalInt.empty());
            try {
                byteBuffer.setPipeline(uvq.GRADE);
                byteBuffer.bindTexture("InSampler", gpuTextureView, gpuSampler);
                byteBuffer.bindTexture("BloomSampler", (GpuTextureView)memoryStack, gpuSampler);
                byteBuffer.setUniform("FlowGrade", uny);
                byteBuffer.draw(0, 3);
            }
            finally {
                if (byteBuffer != null) {
                    byteBuffer.close();
                }
            }
            unr.uoe(commandEncoder, uvq.BLUR_COPY, unv, gpuTextureView, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
        }
        catch (Throwable throwable) {
            uob = true;
            System.out.println("grading failed: " + throwable);
        }
    }

    private static void uoe(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, GpuSampler gpuSampler) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 grade glow", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, gpuSampler);
            renderPass.draw(0, 3);
        }
    }

    public static void release() {
        if (unv != null) {
            unv.close();
            unu.close();
            unv = null;
            unu = null;
        }
        for (int i = 0; i < 3; ++i) {
            if (unx[i] == null) continue;
            unx[i].close();
            unw[i].close();
            unr.unx[i] = null;
            unr.unw[i] = null;
        }
        unz = -1;
        uoa = -1;
        uob = false;
    }

    private static void uof(int n, int n2) {
        GpuDevice gpuDevice = RenderSystem.getDevice();
        if (uny == null) {
            uny = gpuDevice.createBuffer(() -> "Flow2 grade", 136, 48L);
        }
        if (unv != null && n == unz && n2 == uoa) {
            return;
        }
        unr.release();
        int n3 = 12;
        unu = gpuDevice.createTexture(() -> "Flow2 graded", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        unv = gpuDevice.createTextureView(unu);
        for (int i = 0; i < 3; ++i) {
            int n4 = Math.max(1, n >> i + 2);
            int n5 = Math.max(1, n2 >> i + 2);
            int n6 = i;
            unr.unw[i] = gpuDevice.createTexture(() -> "Flow2 grade glow " + n6, n3, TextureFormat.RGBA8, n4, n5, 1, 1);
            unr.unx[i] = gpuDevice.createTextureView(unw[i]);
        }
        unz = n;
        uoa = n2;
    }

    static {
        unw = new GpuTexture[3];
        unx = new GpuTextureView[3];
        unz = -1;
        uoa = -1;
    }

    private static /* synthetic */ int cyu(int n, int n2) {
        return n ^ n2 ^ 0x1DBFA4A9;
    }

    private static /* synthetic */ int cyv(int n, int n2) {
        return n ^ n2 | 0x441B8310;
    }
}

