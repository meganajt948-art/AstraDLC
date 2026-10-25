/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
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
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 *  org.lwjgl.system.MemoryUtil
 */
package a;

import a.uvq;
import a.uwg;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
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
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

public final class uwt {
    public static final int VERTEX_SIZE = 28;
    public static final int MAX_BATCHES = 8;
    private static final int uwu = 128;
    private static final GpuBuffer[] uwv = new GpuBuffer[8];
    private static @Nullable GpuBuffer uww;
    private static long uwx;
    private static @Nullable ByteBuffer uwy;
    private static @Nullable GpuTexture uwz;
    private static @Nullable GpuTextureView uxa;
    private static int uxb;
    private static int uxc;
    private static boolean uxd;
    private static /* synthetic */ boolean uxe;
    private static /* synthetic */ boolean uxf;

    private uwt() {
    }

    public static ByteBuffer staging(int n) {
        int n2 = Math.max(1, n) * 28;
        if (uwy == null) {
            uwy = MemoryUtil.memAlloc((int)Math.max(n2, 65536));
        } else if (uwy.capacity() < n2) {
            uwy = MemoryUtil.memRealloc((ByteBuffer)uwy, (int)Math.max(n2, uwy.capacity() * 2));
        }
        uwy.clear();
        return uwy;
    }

    public static boolean draw(Matrix4f matrix4f, float f, float f2, float f3, float f4, List<uwg> list, ByteBuffer byteBuffer) {
        if (uxd || list.isEmpty() || !uvq.ensure(uvq.SHATTER_BACK) || !uvq.ensure(uvq.SHATTER_FRONT) || !uvq.ensure(uvq.BLUR_COPY)) {
            return false;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        Framebuffer framebuffer = MinecraftClient.method_1551().method_1522();
        GpuTextureView gpuTextureView = framebuffer.method_71639();
        GpuTextureView gpuTextureView2 = framebuffer.method_71640();
        if (gpuBufferSlice == null || gpuTextureView == null || gpuTextureView2 == null || framebuffer.field_1482 < 4 || framebuffer.field_1481 < 4) {
            return false;
        }
        int n = byteBuffer.position();
        if (n <= 0) {
            return false;
        }
        byteBuffer.flip();
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            uwt.uxh(gpuDevice, framebuffer.field_1482, framebuffer.field_1481, n);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            commandEncoder.writeToBuffer(uww.slice(0L, (long)n), byteBuffer);
            int n2 = Math.min(list.size(), 8);
            float f5 = framebuffer.field_1482;
            float f6 = framebuffer.field_1481;
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                for (int i = 0; i < n2; ++i) {
                    uwg uwg2 = list.get(i);
                    commandEncoder.writeToBuffer(uwv[i].slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)128).putMat4f((Matrix4fc)matrix4f).putVec4(f5, f6, 1.0f / f5, 1.0f / f6).putVec4(uwg2.r(), uwg2.g(), uwg2.b(), uwg2.a()).putVec4(f, f2, f3, f4).putVec4(uwg2.scan(), uwg2.sweep(), uwg2.flash(), uwg2.broken()).get());
                }
            }
            memoryStack = commandEncoder.createRenderPass(() -> "Flow2 shatter scene copy", uxa, OptionalInt.empty());
            try {
                memoryStack.setPipeline(uvq.BLUR_COPY);
                memoryStack.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                memoryStack.draw(0, 3);
            }
            finally {
                if (memoryStack != null) {
                    memoryStack.close();
                }
            }
            uwt.uxg(commandEncoder, uvq.SHATTER_BACK, gpuTextureView, gpuTextureView2, gpuBufferSlice, list, n2);
            uwt.uxg(commandEncoder, uvq.SHATTER_FRONT, gpuTextureView, gpuTextureView2, gpuBufferSlice, list, n2);
            return true;
        }
        catch (Throwable throwable) {
            uxd = true;
            System.out.println("shatter pass failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    private static void uxg(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, GpuBufferSlice gpuBufferSlice, List<uwg> list, int n) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 shatter", gpuTextureView, OptionalInt.empty(), gpuTextureView2, OptionalDouble.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("SceneSampler", uxa, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            renderPass.setUniform("Projection", gpuBufferSlice);
            renderPass.setVertexBuffer(0, uww);
            for (int i = 0; i < n; ++i) {
                uwg uwg2 = list.get(i);
                if (uwg2.count() <= 0) continue;
                renderPass.setUniform("FlowShatter", uwv[i]);
                renderPass.draw(uwg2.first(), uwg2.count());
            }
        }
    }

    private static void uxh(GpuDevice gpuDevice, int n, int n2, int n3) {
        int n4;
        for (n4 = 0; n4 < 8; ++n4) {
            if (uwv[n4] != null) continue;
            int n5 = n4;
            uwt.uwv[n4] = gpuDevice.createBuffer(() -> "Flow2 shatter " + n5, 136, 128L);
        }
        if (uww == null || uwx < (long)n3) {
            if (uww != null) {
                uww.close();
            }
            uwx = Math.max((long)n3, Math.max(262144L, uwx * 2L));
            uww = gpuDevice.createBuffer(() -> "Flow2 shatter vertices", 40, uwx);
        }
        if (uxa != null && n == uxb && n2 == uxc) {
            return;
        }
        if (uxa != null) {
            uxa.close();
            uwz.close();
        }
        n4 = 12;
        uwz = gpuDevice.createTexture(() -> "Flow2 shatter scene", n4, TextureFormat.RGBA8, n, n2, 1, 1);
        uxa = gpuDevice.createTextureView(uwz);
        uxb = n;
        uxc = n2;
    }

    public static void release() {
        if (uxa != null) {
            uxa.close();
            uwz.close();
            uxa = null;
            uwz = null;
        }
        if (uww != null) {
            uww.close();
            uww = null;
            uwx = 0L;
        }
        for (int i = 0; i < 8; ++i) {
            if (uwv[i] == null) continue;
            uwv[i].close();
            uwt.uwv[i] = null;
        }
        if (uwy != null) {
            MemoryUtil.memFree((Buffer)uwy);
            uwy = null;
        }
        uxb = -1;
        uxc = -1;
        uxd = false;
    }

    static {
        uxb = -1;
        uxc = -1;
    }

    private static /* synthetic */ int dbp(int n, int n2) {
        return (n ^ n2) + -56893448;
    }

    private static /* synthetic */ int dbq(int n, int n2) {
        return n + n2 + -302872514;
    }
}

