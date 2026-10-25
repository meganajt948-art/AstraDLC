/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.UniformType
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.VertexFormats
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.uvq;
import a.vhe;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexFormats;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class vhf {
    private static final int vhg = 96;
    public static final RenderPipeline MASK = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/hand_mask")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/hand_mask")).withSampler("DepthSampler").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    public static final RenderPipeline FX = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/hand_fx")).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/hand_fx")).withSampler("DepthSampler").withSampler("GlowSampler").withUniform("FlowHands", UniformType.field_60031).withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.field_60033, VertexFormat.DrawMode.field_27379).build();
    private static vhe vhh;
    private static final GpuTexture[] vhi;
    private static final GpuTextureView[] vhj;
    private static @Nullable GpuBuffer vhk;
    private static int vhl;
    private static int vhm;
    private static boolean vhn;
    private static /* synthetic */ long vho;
    private static /* synthetic */ String vhp;

    private vhf() {
    }

    public static void register(vhe vhe2) {
        vhh = vhe2;
    }

    static void afterHands(ClientPlayerEntity clientPlayerEntity, float f) {
        vhe vhe2 = vhh;
        if (vhe2 == null || !vhe2.active() || vhn) {
            return;
        }
        if (!(uvq.ensure(MASK) && uvq.ensure(FX) && uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP))) {
            return;
        }
        Framebuffer framebuffer = MinecraftClient.method_1551().method_1522();
        GpuTextureView gpuTextureView = framebuffer.method_71639();
        GpuTextureView gpuTextureView2 = framebuffer.method_71640();
        if (gpuTextureView == null || gpuTextureView2 == null || framebuffer.field_1482 < 16 || framebuffer.field_1481 < 16) {
            return;
        }
        try {
            ByteBuffer byteBuffer;
            GpuDevice gpuDevice = RenderSystem.getDevice();
            vhf.vhr(gpuDevice, framebuffer.field_1482, framebuffer.field_1481);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            int[] nArray = vhe2.colors(clientPlayerEntity);
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                byteBuffer = Std140Builder.onStack((MemoryStack)memoryStack, (int)96).putVec4((float)framebuffer.field_1482, (float)framebuffer.field_1481, 1.0f / (float)framebuffer.field_1482, 1.0f / (float)framebuffer.field_1481).putVec4(vhe2.time(), 0.0f, vhe2.fill(), vhe2.glow()).putVec4((float)(nArray[0] >> 16 & 0xFF) / 255.0f, (float)(nArray[0] >> 8 & 0xFF) / 255.0f, (float)(nArray[0] & 0xFF) / 255.0f, 1.0f).putVec4((float)(nArray[1] >> 16 & 0xFF) / 255.0f, (float)(nArray[1] >> 8 & 0xFF) / 255.0f, (float)(nArray[1] & 0xFF) / 255.0f, 1.0f).putVec4(vhe2.rim(), 0.0f, 0.0f, 0.0f).putVec4(0.0f, 0.0f, 0.0f, 0.0f).get();
                commandEncoder.writeToBuffer(vhk.slice(), byteBuffer);
            }
            memoryStack = commandEncoder.createRenderPass(() -> "Flow2 hand mask", vhj[0], OptionalInt.empty());
            try {
                memoryStack.setPipeline(MASK);
                memoryStack.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                memoryStack.draw(0, 3);
            }
            finally {
                if (memoryStack != null) {
                    memoryStack.close();
                }
            }
            memoryStack = vhj[0];
            if (vhe2.glow() > 0.001f) {
                vhf.vhq(commandEncoder, uvq.BLUR_DOWN, vhj[0], vhj[1]);
                vhf.vhq(commandEncoder, uvq.BLUR_DOWN, vhj[1], vhj[2]);
                vhf.vhq(commandEncoder, uvq.BLUR_DOWN, vhj[2], vhj[3]);
                vhf.vhq(commandEncoder, uvq.BLUR_UP, vhj[3], vhj[4]);
                vhf.vhq(commandEncoder, uvq.BLUR_UP, vhj[4], vhj[5]);
                vhf.vhq(commandEncoder, uvq.BLUR_UP, vhj[5], vhj[6]);
                memoryStack = vhj[6];
            }
            byteBuffer = commandEncoder.createRenderPass(() -> "Flow2 hand shader", gpuTextureView, OptionalInt.empty());
            try {
                byteBuffer.setPipeline(FX);
                byteBuffer.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                byteBuffer.bindTexture("GlowSampler", (GpuTextureView)memoryStack, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                byteBuffer.setUniform("FlowHands", vhk);
                byteBuffer.draw(0, 3);
            }
            finally {
                if (byteBuffer != null) {
                    byteBuffer.close();
                }
            }
        }
        catch (Throwable throwable) {
            vhn = true;
            System.out.println("hand shader failed, turned off: " + throwable);
        }
    }

    private static void vhq(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 hand glow", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            renderPass.draw(0, 3);
        }
    }

    private static void vhr(GpuDevice gpuDevice, int n, int n2) {
        if (vhk == null) {
            vhk = gpuDevice.createBuffer(() -> "Flow2 hands", 136, 96L);
        }
        if (vhj[0] != null && n == vhl && n2 == vhm) {
            return;
        }
        for (int i = 0; i < vhi.length; ++i) {
            if (vhj[i] == null) continue;
            vhj[i].close();
            vhi[i].close();
        }
        int[] nArray = new int[]{2, 4, 8, 16, 8, 4, 2};
        int n3 = 12;
        for (int i = 0; i < vhi.length; ++i) {
            int n4 = Math.max(1, n / nArray[i]);
            int n5 = Math.max(1, n2 / nArray[i]);
            int n6 = i;
            vhf.vhi[i] = gpuDevice.createTexture(() -> "Flow2 hands " + n6, n3, TextureFormat.RGBA8, n4, n5, 1, 1);
            vhf.vhj[i] = gpuDevice.createTextureView(vhi[i]);
        }
        vhl = n;
        vhm = n2;
    }

    static {
        vhi = new GpuTexture[7];
        vhj = new GpuTextureView[7];
        vhl = -1;
        vhm = -1;
    }

    private static /* synthetic */ int dez(int n, int n2) {
        return n - n2 ^ 0x74AAEAAF;
    }

    private static /* synthetic */ int dfa(int n, int n2) {
        return vhf.dez(n, n2) ^ 0x6E4F7B0B;
    }

    private static /* synthetic */ int dfb(int n, int n2) {
        return vhf.dfa(n, n2) + n;
    }
}

