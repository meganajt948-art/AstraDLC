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
 *  com.mojang.blaze3d.systems.GpuQuery
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
 */
package a;

import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.GpuQuery;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.ArrayDeque;
import java.util.OptionalInt;
import java.util.OptionalLong;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class urc {
    private static final int urd = 176;
    private static @Nullable GpuTexture ure;
    private static @Nullable GpuTextureView urf;
    private static @Nullable GpuBuffer urg;
    private static int urh;
    private static int uri;
    private static boolean urj;
    private static boolean urk;
    private static final ArrayDeque<GpuQuery> url;
    private static long urm;
    private static int urn;
    private static /* synthetic */ int uro;
    private static /* synthetic */ String urp;

    private urc() {
    }

    public static boolean draw(Matrix4f matrix4f, Matrix4f matrix4f2, float f, float f2, float f3, float f4, int n, float f5) {
        if (urj || !uvq.ensure(uvq.MOTION) || !uvq.ensure(uvq.MOTION_FINE)) {
            return false;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        Framebuffer framebuffer = MinecraftClient.method_1551().method_1522();
        GpuTextureView gpuTextureView = framebuffer.method_71639();
        GpuTextureView gpuTextureView2 = framebuffer.method_71640();
        if (gpuBufferSlice == null || gpuTextureView == null || gpuTextureView2 == null || framebuffer.field_1482 < 4 || framebuffer.field_1481 < 4) {
            return false;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            urc.urs(gpuDevice, framebuffer.field_1482, framebuffer.field_1481);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                commandEncoder.writeToBuffer(urg.slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)176).putVec4((float)framebuffer.field_1482, (float)framebuffer.field_1481, 1.0f / (float)framebuffer.field_1482, 1.0f / (float)framebuffer.field_1481).putMat4f((Matrix4fc)matrix4f).putMat4f((Matrix4fc)matrix4f2).putVec4(f, f2, f3, 0.0f).putVec4(f4 * (float)framebuffer.field_1482, (float)n, f5, 0.0f).get());
            }
            memoryStack = urk ? commandEncoder.timerQueryBegin() : null;
            urc.urq(commandEncoder, uvq.MOTION, gpuTextureView, urf, gpuTextureView2, gpuBufferSlice);
            urc.urq(commandEncoder, uvq.MOTION_FINE, urf, gpuTextureView, gpuTextureView2, gpuBufferSlice);
            if (memoryStack != null) {
                commandEncoder.timerQueryEnd((GpuQuery)memoryStack);
                url.add((GpuQuery)memoryStack);
            }
            urc.urr();
            return true;
        }
        catch (Throwable throwable) {
            urj = true;
            System.out.println("motion blur failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    private static void urq(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, GpuTextureView gpuTextureView3, GpuBufferSlice gpuBufferSlice) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 motion blur", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            renderPass.bindTexture("DepthSampler", gpuTextureView3, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
            renderPass.setUniform("Projection", gpuBufferSlice);
            renderPass.setUniform("FlowMotion", urg);
            renderPass.draw(0, 3);
        }
    }

    public static void timing(boolean bl) {
        urk = bl;
        urm = 0L;
        urn = 0;
    }

    public static double gpuMillis() {
        urc.urr();
        double d = urn == 0 ? -1.0 : (double)urm / 1000000.0 / (double)urn;
        urm = 0L;
        urn = 0;
        return d;
    }

    private static void urr() {
        while (!url.isEmpty()) {
            OptionalLong optionalLong = url.peek().getValue();
            if (optionalLong.isEmpty()) {
                if (url.size() < 8) {
                    return;
                }
                url.poll().close();
                continue;
            }
            url.poll().close();
            urm += optionalLong.getAsLong();
            ++urn;
        }
    }

    public static void release() {
        if (urf != null) {
            urf.close();
            urf = null;
        }
        if (ure != null) {
            ure.close();
            ure = null;
        }
        urh = -1;
        uri = -1;
        urj = false;
    }

    private static void urs(GpuDevice gpuDevice, int n, int n2) {
        if (urg == null) {
            urg = gpuDevice.createBuffer(() -> "Flow2 motion blur", 136, 176L);
        }
        if (urf != null && n == urh && n2 == uri) {
            return;
        }
        urc.release();
        int n3 = 12;
        ure = gpuDevice.createTexture(() -> "Flow2 motion blur", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        urf = gpuDevice.createTextureView(ure);
        urh = n;
        uri = n2;
    }

    static {
        urh = -1;
        uri = -1;
        url = new ArrayDeque();
    }

    private static /* synthetic */ int dab(int n, int n2) {
        return n + n2 | 0x412F9CB;
    }
}

