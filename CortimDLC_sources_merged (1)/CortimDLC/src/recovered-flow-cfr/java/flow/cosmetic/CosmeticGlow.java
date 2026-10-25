/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Builder
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
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.util.Identifier
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.lwjgl.system.MemoryStack
 *  org.lwjgl.system.MemoryUtil
 */
package flow.cosmetic;

import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
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
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.CosmeticMesh;
import flow.cosmetic.Cosmetics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

final class CosmeticGlow {
    static final int VERTEX = 24;
    private static final int LEVELS = 5;
    private static final int UNIFORM_SIZE = 80;
    private static final RenderPipeline MASK = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cos_glow")).withVertexShader(uvq.id("core/cos_glow")).withFragmentShader(uvq.id("core/cos_glow")).withSampler("Sampler0").withUniform("Projection", UniformType.UNIFORM_BUFFER).withUniform("FlowGlow", UniformType.UNIFORM_BUFFER).withBlend(BlendFunction.ADDITIVE).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withDepthBias(-1.0f, -4.0f).withCull(false).withVertexFormat(VertexFormats.POSITION_TEXTURE_COLOR, VertexFormat.DrawMode.TRIANGLES).build();
    private static final RenderPipeline DOWN = CosmeticGlow.screen("fx_down", null, false, "InSampler");
    private static final RenderPipeline UP = CosmeticGlow.screen("cos_up", null, false, "InSampler", "BaseSampler");
    private static final RenderPipeline COMPOSITE = CosmeticGlow.screen("cos_bloom", BlendFunction.ADDITIVE, true, "InSampler");
    private static final List<Batch> BATCHES = new ArrayList<Batch>();
    private static ByteBuffer staging;
    private static int vertices;
    private static GpuBuffer buffer;
    private static long capacity;
    private static GpuBuffer uniforms;
    private static GpuTexture mask;
    private static GpuTextureView maskView;
    private static final GpuTexture[] DOWN_TEX;
    private static final GpuTextureView[] DOWN_VIEW;
    private static final GpuTexture[] UP_TEX;
    private static final GpuTextureView[] UP_VIEW;
    private static int width;
    private static int height;
    private static boolean failed;

    private CosmeticGlow() {
    }

    private static RenderPipeline screen(String fragment, BlendFunction blend, boolean uniform, String ... samplers) {
        RenderPipeline.Builder b = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/cos_" + fragment)).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/" + fragment)).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.EMPTY, VertexFormat.DrawMode.TRIANGLES);
        for (String s : samplers) {
            b.withSampler(s);
        }
        if (uniform) {
            b.withUniform("FlowGlow", UniformType.UNIFORM_BUFFER);
        }
        if (blend != null) {
            b.withBlend(blend);
        }
        return b.build();
    }

    static boolean active() {
        return !failed && Cosmetics.GLOW.get() > 0.01;
    }

    static void begin() {
        BATCHES.clear();
        vertices = 0;
        if (staging != null) {
            staging.clear();
        }
    }

    static ByteBuffer reserve(int count) {
        int need = (vertices + count) * 24;
        if (staging == null) {
            staging = MemoryUtil.memAlloc((int)Math.max(need, 262144));
        } else if (staging.capacity() < need) {
            ByteBuffer grown = MemoryUtil.memRealloc((ByteBuffer)staging, (int)Math.max(need, staging.capacity() * 2));
            grown.position(vertices * 24);
            staging = grown;
        }
        staging.limit(staging.capacity());
        staging.position(vertices * 24);
        return staging;
    }

    static void commit(Identifier texture, int count) {
        Batch last;
        if (count <= 0 || texture == null) {
            return;
        }
        Batch batch = last = BATCHES.isEmpty() ? null : BATCHES.get(BATCHES.size() - 1);
        if (last != null && last.texture.equals((Object)texture) && last.first + last.count == vertices) {
            BATCHES.set(BATCHES.size() - 1, new Batch(texture, last.first, last.count + count));
        } else {
            BATCHES.add(new Batch(texture, vertices, count));
        }
        vertices += count;
    }

    static void add(CosmeticItem item, Matrix4f[] bones, Matrix4f pose, int argb, int frame, int part, boolean blink) {
        if (item.emissive == null) {
            return;
        }
        ByteBuffer out = CosmeticGlow.reserve(CosmeticMesh.glowVertices(item));
        CosmeticGlow.commit(item.emissive, CosmeticMesh.glow(item, bones, pose, out, argb, frame, part, blink));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void flush() {
        if (failed || vertices == 0 || BATCHES.isEmpty()) {
            CosmeticGlow.begin();
            return;
        }
        MinecraftClient mc = MinecraftClient.getInstance();
        try {
            int i;
            if (!(uvq.ensure(MASK) && uvq.ensure(DOWN) && uvq.ensure(UP) && uvq.ensure(COMPOSITE))) {
                return;
            }
            GpuBufferSlice projection = RenderSystem.getProjectionMatrixBuffer();
            Framebuffer fb = mc.getFramebuffer();
            GpuTextureView color = fb.getColorAttachmentView();
            GpuTextureView depth = fb.getDepthAttachmentView();
            if (projection == null || color == null || depth == null || fb.textureWidth < 8 || fb.textureHeight < 8) {
                return;
            }
            int bytes = vertices * 24;
            ByteBuffer data = staging.duplicate();
            data.position(0).limit(bytes);
            GpuDevice device = RenderSystem.getDevice();
            CosmeticGlow.ensure(device, fb.textureWidth, fb.textureHeight, bytes);
            CommandEncoder encoder = device.createCommandEncoder();
            encoder.writeToBuffer(buffer.slice(0L, (long)bytes), data);
            Camera camera = mc.gameRenderer.getCamera();
            Matrix4f view = new Matrix4f().rotation((Quaternionfc)camera.getRotation().conjugate(new Quaternionf()));
            float strength = (float)Cosmetics.GLOW.get();
            try (MemoryStack stack = MemoryStack.stackPush();){
                encoder.writeToBuffer(uniforms.slice(), Std140Builder.onStack((MemoryStack)stack, (int)80).putMat4f((Matrix4fc)view).putVec4(strength, (float)fb.textureWidth, (float)fb.textureHeight, 0.0f).get());
            }
            try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 cosmetic glow", maskView, OptionalInt.of(0), depth, OptionalDouble.empty());){
                pass.setPipeline(MASK);
                pass.setUniform("Projection", projection);
                pass.setUniform("FlowGlow", uniforms);
                pass.setVertexBuffer(0, buffer);
                for (Batch b : BATCHES) {
                    GpuTextureView tex = CosmeticGlow.texture(mc, b.texture);
                    if (tex == null) continue;
                    pass.bindTexture("Sampler0", tex, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                    pass.draw(b.first, b.count);
                }
            }
            GpuTextureView last = maskView;
            for (i = 0; i < 5; ++i) {
                CosmeticGlow.blur(encoder, DOWN, last, null, DOWN_VIEW[i]);
                last = DOWN_VIEW[i];
            }
            for (i = 3; i >= 0; --i) {
                CosmeticGlow.blur(encoder, UP, last, DOWN_VIEW[i], UP_VIEW[i]);
                last = UP_VIEW[i];
            }
            try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 cosmetic bloom", color, OptionalInt.empty());){
                pass.setPipeline(COMPOSITE);
                pass.bindTexture("InSampler", last, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                pass.setUniform("FlowGlow", uniforms);
                pass.draw(0, 3);
            }
        }
        catch (Throwable t) {
            failed = true;
            System.out.println("cosmetic glow failed, turned off: " + t);
        }
        finally {
            CosmeticGlow.begin();
        }
    }

    private static GpuTextureView texture(MinecraftClient mc, Identifier id) {
        AbstractTexture t = mc.getTextureManager().getTexture(id);
        return t == null ? null : t.getGlTextureView();
    }

    private static void blur(CommandEncoder encoder, RenderPipeline pipeline, GpuTextureView in, GpuTextureView base, GpuTextureView out) {
        try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 cosmetic bloom blur", out, OptionalInt.empty());){
            pass.setPipeline(pipeline);
            pass.bindTexture("InSampler", in, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
            if (base != null) {
                pass.bindTexture("BaseSampler", base, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
            }
            pass.draw(0, 3);
        }
    }

    private static void ensure(GpuDevice device, int w, int h, int bytes) {
        if (uniforms == null) {
            uniforms = device.createBuffer(() -> "Flow2 cosmetic glow", 136, 80L);
        }
        if (buffer == null || capacity < (long)bytes) {
            if (buffer != null) {
                buffer.close();
            }
            capacity = Math.max((long)bytes, Math.max(262144L, capacity * 2L));
            buffer = device.createBuffer(() -> "Flow2 cosmetic glow vertices", 40, capacity);
        }
        if (maskView != null && w == width && h == height) {
            return;
        }
        CosmeticGlow.release();
        int usage = 12;
        mask = device.createTexture(() -> "Flow2 cosmetic glow mask", usage, TextureFormat.RGBA8, w, h, 1, 1);
        maskView = device.createTextureView(mask);
        for (int i = 0; i < 5; ++i) {
            int div = 2 << i;
            int level = i;
            CosmeticGlow.DOWN_TEX[i] = device.createTexture(() -> "Flow2 cosmetic glow down " + level, usage, TextureFormat.RGBA8, Math.max(1, w / div), Math.max(1, h / div), 1, 1);
            CosmeticGlow.DOWN_VIEW[i] = device.createTextureView(DOWN_TEX[i]);
            if (i >= 4) continue;
            CosmeticGlow.UP_TEX[i] = device.createTexture(() -> "Flow2 cosmetic glow up " + level, usage, TextureFormat.RGBA8, Math.max(1, w / div), Math.max(1, h / div), 1, 1);
            CosmeticGlow.UP_VIEW[i] = device.createTextureView(UP_TEX[i]);
        }
        width = w;
        height = h;
    }

    private static void release() {
        if (maskView != null) {
            maskView.close();
            mask.close();
            maskView = null;
            mask = null;
        }
        for (int i = 0; i < 5; ++i) {
            if (DOWN_VIEW[i] != null) {
                DOWN_VIEW[i].close();
                DOWN_TEX[i].close();
                CosmeticGlow.DOWN_VIEW[i] = null;
                CosmeticGlow.DOWN_TEX[i] = null;
            }
            if (i >= 4 || UP_VIEW[i] == null) continue;
            UP_VIEW[i].close();
            UP_TEX[i].close();
            CosmeticGlow.UP_VIEW[i] = null;
            CosmeticGlow.UP_TEX[i] = null;
        }
        width = -1;
        height = -1;
    }

    static {
        DOWN_TEX = new GpuTexture[5];
        DOWN_VIEW = new GpuTextureView[5];
        UP_TEX = new GpuTexture[4];
        UP_VIEW = new GpuTextureView[4];
        width = -1;
        height = -1;
    }

    private record Batch(Identifier texture, int first, int count) {
    }
}

