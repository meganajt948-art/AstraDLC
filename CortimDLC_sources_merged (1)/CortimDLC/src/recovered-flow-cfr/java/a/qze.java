/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.UniformType
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.util.Identifier
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.dry;
import a.kfa;
import a.kfe;
import a.uvq;
import a.vmc;
import a.vxu;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.lwjgl.system.MemoryStack;

public class qze
extends kfe {
    private static qze qzf;
    private final vmc qzg = this.add(new vmc("Ratio", 1.33, 0.5, 3.0, 0.01).format(d -> vxu.fixed(d, 2) + " : 1"));
    private static final RenderPipeline qzh;
    private GpuTexture qzi;
    private GpuTextureView qzj;
    private GpuBuffer qzk;
    private int qzl = -1;
    private int qzm = -1;
    private boolean qzn;
    private static /* synthetic */ long qzo;
    private static /* synthetic */ String qzp;

    public qze() {
        super("AspectRatio", "Stretched resolution: change the screen's width with a slider", kfa.RENDER);
        qzf = this;
    }

    @Override
    protected void onDisable() {
        this.qzs();
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        qze qze2 = qzf;
        if (qze2 != null && qze2.isEnabled() && !qze2.qzn && !dry.armed()) {
            qze2.qzq();
        }
    }

    private void qzq() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Framebuffer framebuffer = minecraftClient.getFramebuffer();
        if (minecraftClient.world == null || framebuffer == null || framebuffer.getColorAttachment() == null || framebuffer.textureWidth < 4 || framebuffer.textureHeight < 4) {
            return;
        }
        float f = (float)framebuffer.textureWidth / (float)framebuffer.textureHeight;
        float f2 = (float)this.qzg.get();
        if (Math.abs(f2 - f) < 0.005f || !uvq.ensure(qzh)) {
            return;
        }
        float f3 = Math.min(1.0f, f2 / f);
        float f4 = Math.min(1.0f, f / f2);
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            this.qzr(gpuDevice, framebuffer.textureWidth, framebuffer.textureHeight);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            commandEncoder.copyTextureToTexture(framebuffer.getColorAttachment(), this.qzi, 0, 0, 0, 0, 0, framebuffer.textureWidth, framebuffer.textureHeight);
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                commandEncoder.writeToBuffer(this.qzk.slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)16).putVec4((1.0f - f3) * 0.5f, (1.0f - f4) * 0.5f, f3, f4).get());
            }
            memoryStack = commandEncoder.createRenderPass(() -> "Flow2 aspect ratio", framebuffer.getColorAttachmentView(), OptionalInt.empty());
            try {
                memoryStack.setPipeline(qzh);
                memoryStack.bindTexture("InSampler", this.qzj, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                memoryStack.setUniform("FlowStretch", this.qzk);
                memoryStack.draw(0, 3);
            }
            finally {
                if (memoryStack != null) {
                    memoryStack.close();
                }
            }
        }
        catch (Throwable throwable) {
            this.qzn = true;
            System.out.println("[Flow2] aspect ratio unavailable: " + throwable);
        }
    }

    private void qzr(GpuDevice gpuDevice, int n, int n2) {
        if (this.qzk == null) {
            this.qzk = gpuDevice.createBuffer(() -> "Flow2 aspect ratio", 136, 16L);
        }
        if (this.qzj != null && n == this.qzl && n2 == this.qzm) {
            return;
        }
        this.qzs();
        int n3 = 5;
        this.qzi = gpuDevice.createTexture(() -> "Flow2 aspect ratio", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        this.qzj = gpuDevice.createTextureView(this.qzi);
        this.qzl = n;
        this.qzm = n2;
    }

    private void qzs() {
        if (this.qzj != null) {
            this.qzj.close();
            this.qzj = null;
        }
        if (this.qzi != null) {
            this.qzi.close();
            this.qzi = null;
        }
        this.qzl = -1;
        this.qzm = -1;
    }

    static {
        qzh = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(Identifier.of((String)"flow2", (String)"pipeline/stretch")).withVertexShader(Identifier.of((String)"flow2", (String)"core/blur")).withFragmentShader(Identifier.of((String)"flow2", (String)"core/stretch")).withSampler("InSampler").withUniform("FlowStretch", UniformType.UNIFORM_BUFFER).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.EMPTY, VertexFormat.DrawMode.TRIANGLES).build();
    }

    private static /* synthetic */ int bwu(int n, int n2) {
        return n * n2 + -982455206;
    }

    private static /* synthetic */ int bwv(int n, int n2) {
        return n - n2 ^ 0x5B4AA5FC;
    }
}

