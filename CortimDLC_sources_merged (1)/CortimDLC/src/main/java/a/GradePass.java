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
 *  net.minecraft.class_12137
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.VertexFormats;
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
import net.minecraft.class_12137;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class GradePass {
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

    private GradePass() {
    }

    public static void apply(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (uob || !VertexFormats.ensure(VertexFormats.GRADE) || !VertexFormats.ensure(VertexFormats.BLUR_COPY) || f6 > 0.0f && (!VertexFormats.ensure(VertexFormats.BLUR_DOWN) || !VertexFormats.ensure(VertexFormats.BLUR_UP))) {
            return;
        }
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        if (gpuTextureView == null || class_2762.field_1482 < 8 || class_2762.field_1481 < 8) {
            return;
        }
        try {
            ByteBuffer byteBuffer;
            GradePass.uof(class_2762.field_1482, class_2762.field_1481);
            GpuDevice gpuDevice = RenderSystem.getDevice();
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            class_12137 class_121372 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                byteBuffer = Std140Builder.onStack((MemoryStack)memoryStack, (int)48).putVec4(f, f2, f3, f4).putVec4(f5, f6, 1.0f / (float)class_2762.field_1482, 1.0f / (float)class_2762.field_1481).putVec4(f7, 0.62f, 0.0f, 0.0f).get();
                commandEncoder.writeToBuffer(uny.slice(), byteBuffer);
            }
            memoryStack = gpuTextureView;
            if (f6 > 0.0f) {
                int n;
                byteBuffer = gpuTextureView;
                for (n = 0; n < 3; ++n) {
                    GradePass.uoe(commandEncoder, VertexFormats.BLUR_DOWN, (GpuTextureView)byteBuffer, unx[n], class_121372);
                    byteBuffer = unx[n];
                }
                for (n = 2; n > 0; --n) {
                    GradePass.uoe(commandEncoder, VertexFormats.BLUR_UP, unx[n], unx[n - 1], class_121372);
                }
                memoryStack = unx[0];
            }
            byteBuffer = commandEncoder.createRenderPass(() -> "Flow2 grade", unv, OptionalInt.empty());
            try {
                byteBuffer.setPipeline(VertexFormats.GRADE);
                byteBuffer.bindTexture("InSampler", gpuTextureView, class_121372);
                byteBuffer.bindTexture("BloomSampler", (GpuTextureView)memoryStack, class_121372);
                byteBuffer.setUniform("FlowGrade", uny);
                byteBuffer.draw(0, 3);
            }
            finally {
                if (byteBuffer != null) {
                    byteBuffer.close();
                }
            }
            GradePass.uoe(commandEncoder, VertexFormats.BLUR_COPY, unv, gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
        }
        catch (Throwable throwable) {
            uob = true;
            System.out.println("grading failed: " + throwable);
        }
    }

    private static void uoe(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, class_12137 class_121372) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 grade glow", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, class_121372);
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
            GradePass.unx[i] = null;
            GradePass.unw[i] = null;
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
        GradePass.release();
        int n3 = 12;
        unu = gpuDevice.createTexture(() -> "Flow2 graded", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        unv = gpuDevice.createTextureView(unu);
        for (int i = 0; i < 3; ++i) {
            int n4 = Math.max(1, n >> i + 2);
            int n5 = Math.max(1, n2 >> i + 2);
            int n6 = i;
            GradePass.unw[i] = gpuDevice.createTexture(() -> "Flow2 grade glow " + n6, n3, TextureFormat.RGBA8, n4, n5, 1, 1);
            GradePass.unx[i] = gpuDevice.createTextureView(unw[i]);
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

