/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
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
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.uvq;
import a.vbb;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
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
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class uze {
    public static final int UNIFORM_SIZE = 368;
    private static final int uzf = 528;
    private static @Nullable GpuTexture uzg;
    private static @Nullable GpuTextureView uzh;
    private static @Nullable GpuTexture uzi;
    private static @Nullable GpuTextureView uzj;
    private static boolean uzk;
    private static final GpuTexture[] uzl;
    private static final GpuTextureView[] uzm;
    private static int uzn;
    private static int uzo;
    private static @Nullable GpuBuffer uzp;
    private static int uzq;
    private static int uzr;
    private static int uzs;
    private static boolean uzt;
    private static int uzu;
    private static boolean uzv;
    private static boolean uzw;
    private static final ArrayDeque<GpuQuery> uzx;
    private static long uzy;
    private static int uzz;
    private static /* synthetic */ String vaa;
    private static /* synthetic */ boolean vab;

    private uze() {
    }

    public static boolean draw(float f, float f2, boolean bl, float f3, float f4, Consumer<Std140Builder> consumer) {
        if (!(!uzv && uvq.ensure(uvq.CLOUD_NOISE) && uvq.ensure(uvq.CLOUD_W) && uvq.ensure(uvq.CLOUD_MARCH) && uvq.ensure(uvq.CLOUD_RESOLVE) && uvq.ensure(uvq.CLOUD_RAYS) && uvq.ensure(uvq.CLOUD_COMPOSITE))) {
            return false;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        GpuBufferSlice gpuBufferSlice2 = RenderSystem.getShaderFog();
        Framebuffer framebuffer = MinecraftClient.getInstance().getFramebuffer();
        GpuTextureView gpuTextureView = framebuffer.getColorAttachmentView();
        GpuTextureView gpuTextureView2 = framebuffer.getDepthAttachmentView();
        GpuTextureView gpuTextureView3 = vbb.heightView();
        if (gpuBufferSlice == null || gpuBufferSlice2 == null || gpuTextureView == null || gpuTextureView2 == null || gpuTextureView3 == null || framebuffer.textureWidth < 4 || framebuffer.textureHeight < 4) {
            return false;
        }
        try {
            Std140Builder std140Builder;
            int n = Math.max(1, Math.round((float)framebuffer.textureWidth * f));
            int n2 = Math.max(1, Math.round((float)framebuffer.textureHeight * f));
            GpuDevice gpuDevice = RenderSystem.getDevice();
            uze.vae(gpuDevice, n, n2, framebuffer.textureWidth, framebuffer.textureHeight);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            if (!uzk) {
                try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 cloud noise", uzh, OptionalInt.empty());){
                    renderPass.setPipeline(uvq.CLOUD_NOISE);
                    renderPass.draw(0, 3);
                }
                renderPass = commandEncoder.createRenderPass(() -> "Flow2 cloud weather", uzj, OptionalInt.empty());
                try {
                    renderPass.setPipeline(uvq.CLOUD_W);
                    renderPass.draw(0, 3);
                }
                finally {
                    if (renderPass != null) {
                        renderPass.close();
                    }
                }
                uzk = true;
            }
            uzu = uzu + 1 & 0x3FF;
            boolean bl2 = uzt && bl;
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                std140Builder = Std140Builder.onStack((MemoryStack)memoryStack, (int)368).putVec4((float)n, (float)n2, (float)framebuffer.textureWidth, (float)framebuffer.textureHeight).putVec4((float)uzu, bl2 ? 1.0f : 0.0f, f3, f4);
                consumer.accept(std140Builder);
                std140Builder.putVec4(uze.vad(uzu & 0xF, 2), uze.vad(uzu & 0xF, 3), f2, 0.0f);
                commandEncoder.writeToBuffer(uzp.slice(), std140Builder.get());
            }
            memoryStack = uzm[0];
            std140Builder = uzm[1];
            GpuTextureView gpuTextureView4 = uzm[uzs];
            GpuTextureView gpuTextureView5 = uzm[5 - uzs];
            GpuQuery gpuQuery = uzw ? commandEncoder.timerQueryBegin() : null;
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 cloud march", (GpuTextureView)memoryStack, OptionalInt.empty());){
                renderPass.setPipeline(uvq.CLOUD_MARCH);
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.bindTexture("CloudNoise", uzh, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                renderPass.bindTexture("CloudW", uzj, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                renderPass.bindTexture("HeightSampler", gpuTextureView3, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("Fog", gpuBufferSlice2);
                renderPass.setUniform("FlowCloud", uzp);
                renderPass.draw(0, 3);
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 cloud resolve", gpuTextureView5, OptionalInt.empty());
            try {
                renderPass.setPipeline(uvq.CLOUD_RESOLVE);
                renderPass.bindTexture("RawSampler", (GpuTextureView)memoryStack, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.bindTexture("HistorySampler", gpuTextureView4, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowCloud", uzp);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 sun rays", (GpuTextureView)std140Builder, OptionalInt.empty());
            try {
                renderPass.setPipeline(uvq.CLOUD_RAYS);
                renderPass.bindTexture("CloudSampler", gpuTextureView5, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowCloud", uzp);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 cloud composite", gpuTextureView, OptionalInt.empty());
            try {
                renderPass.setPipeline(uvq.CLOUD_COMPOSITE);
                renderPass.bindTexture("CloudSampler", gpuTextureView5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.bindTexture("RaysSampler", (GpuTextureView)std140Builder, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.bindTexture("CloudNoise", uzh, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                renderPass.bindTexture("CloudW", uzj, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                renderPass.bindTexture("HeightSampler", gpuTextureView3, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowCloud", uzp);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            if (gpuQuery != null) {
                commandEncoder.timerQueryEnd(gpuQuery);
                uzx.add(gpuQuery);
            }
            uzs = 5 - uzs;
            uzt = true;
            uze.vac();
            return true;
        }
        catch (Throwable throwable) {
            uzv = true;
            System.out.println("summer sky failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    public static void timing(boolean bl) {
        uzw = bl;
        uzy = 0L;
        uzz = 0;
    }

    public static double gpuMillis() {
        uze.vac();
        double d = uzz == 0 ? -1.0 : (double)uzy / 1000000.0 / (double)uzz;
        uzy = 0L;
        uzz = 0;
        return d;
    }

    private static void vac() {
        while (!uzx.isEmpty()) {
            OptionalLong optionalLong = uzx.peek().getValue();
            if (optionalLong.isEmpty()) {
                if (uzx.size() < 8) {
                    return;
                }
                uzx.poll().close();
                continue;
            }
            uzx.poll().close();
            uzy += optionalLong.getAsLong();
            ++uzz;
        }
    }

    public static void release() {
        for (int i = 0; i < uzm.length; ++i) {
            if (uzm[i] != null) {
                uzm[i].close();
                uze.uzm[i] = null;
            }
            if (uzl[i] == null) continue;
            uzl[i].close();
            uze.uzl[i] = null;
        }
        uzq = -1;
        uzr = -1;
        uzn = -1;
        uzo = -1;
        uzt = false;
        uzv = false;
    }

    private static float vad(int n, int n2) {
        float f = 1.0f;
        float f2 = 0.0f;
        for (int i = n + 1; i > 0; i /= n2) {
            f2 += (f /= (float)n2) * (float)(i % n2);
        }
        return f2;
    }

    private static void vae(GpuDevice gpuDevice, int n, int n2, int n3, int n4) {
        int n5;
        if (uzp == null) {
            uzp = gpuDevice.createBuffer(() -> "Flow2 summer sky", 136, 368L);
        }
        if (uzh == null) {
            n5 = 12;
            uzg = gpuDevice.createTexture(() -> "Flow2 cloud noise", n5, TextureFormat.RGBA8, 528, 528, 1, 1);
            uzh = gpuDevice.createTextureView(uzg);
            uzi = gpuDevice.createTexture(() -> "Flow2 cloud weather", n5, TextureFormat.RGBA8, 256, 256, 1, 1);
            uzj = gpuDevice.createTextureView(uzi);
            uzk = false;
        }
        if (uzm[0] != null && n == uzq && n2 == uzr && n3 == uzn && n4 == uzo) {
            return;
        }
        uze.release();
        n5 = 12;
        for (int i = 0; i < uzl.length; ++i) {
            int n6 = i;
            int n7 = i < 2 ? n : n3;
            int n8 = i < 2 ? n2 : n4;
            uze.uzl[i] = gpuDevice.createTexture(() -> "Flow2 summer sky " + n6, n5, TextureFormat.RGBA8, n7, n8, 1, 1);
            uze.uzm[i] = gpuDevice.createTextureView(uzl[i]);
        }
        uzq = n;
        uzr = n2;
        uzn = n3;
        uzo = n4;
    }

    static {
        uzl = new GpuTexture[4];
        uzm = new GpuTextureView[4];
        uzn = -1;
        uzo = -1;
        uzq = -1;
        uzr = -1;
        uzs = 2;
        uzx = new ArrayDeque();
    }

    private static /* synthetic */ int dce(int n, int n2) {
        return n - n2 ^ 0x89F52CB;
    }

    private static /* synthetic */ int dcf(int n, int n2) {
        return n * n2 ^ 0x819309F0;
    }

    private static /* synthetic */ int dcg(int n, int n2) {
        return uze.dce(n, n2) + n;
    }
}

