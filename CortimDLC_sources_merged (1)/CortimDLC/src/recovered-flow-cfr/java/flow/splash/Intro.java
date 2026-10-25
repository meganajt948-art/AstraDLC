/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
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
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.GpuSampler
 *  net.minecraft.client.gl.UniformType
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.VertexFormats
 *  org.lwjgl.system.MemoryStack
 *  org.lwjgl.system.MemoryUtil
 */
package flow.splash;

import a.unf;
import a.uok;
import a.uut;
import a.uvq;
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
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import flow.splash.Signature;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.SplittableRandom;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexFormats;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

final class Intro {
    private static final int UNIFORM_SIZE = 400;
    private static final int VERTEX = 24;
    private static final int MAX_PARTS = 4096;
    private static final int MAX_RIPPLES = 6;
    private static final float START = 0.5f;
    private static final float GLINT = 0.85f;
    private static final float SWEEP = 1.05f;
    private static final float END = 2.15f;
    private static final float[][] PAL = new float[][]{{1.0f, 0.365f, 0.561f}, {0.82f, 0.298f, 1.0f}, {0.486f, 0.42f, 1.0f}};
    private static final float[] WHITE = new float[]{1.0f, 0.894f, 0.965f};
    private static final RenderPipeline EMIT = Intro.screen("intro_emit", "GlyphSampler", "SMapSampler");
    private static final RenderPipeline COMPOSITE = Intro.screen("intro_composite", "GlyphSampler", "SMapSampler", "EmitSampler", "MidSampler", "WideSampler");
    private static final RenderPipeline FX = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/intro_fx")).withVertexShader(uvq.id("core/intro_fx")).withFragmentShader(uvq.id("core/intro_fx")).withUniform("FlowIntro", UniformType.UNIFORM_BUFFER).withBlend(BlendFunction.ADDITIVE).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.POSITION_TEXTURE_COLOR, VertexFormat.DrawMode.TRIANGLES).build();
    private static CompletableFuture<Signature> loading;
    private static final List<AutoCloseable> RETIRED;
    private static final List<Long> RETIRED_AT;
    private final Signature sig;
    private final float write;
    private final SplittableRandom random = new SplittableRandom(11L);
    private final float[] tip = new float[4];
    private final float[] flow = new float[2];
    private float time;
    private float doneAt = -1.0f;
    private float outAt = -1.0f;
    private float prevHead = -1.0f;
    private float emitAcc;
    private float shineAcc;
    private float loadAcc;
    private float loadTarget;
    private float loadShown;
    private float loadKnown;
    private float pulse;
    private int dust;
    private int count;
    private final float[] px = new float[4096];
    private final float[] py = new float[4096];
    private final float[] vx = new float[4096];
    private final float[] vy = new float[4096];
    private final float[] age = new float[4096];
    private final float[] life = new float[4096];
    private final float[] size = new float[4096];
    private final float[] fs = new float[4096];
    private final float[] tx = new float[4096];
    private final float[] ty = new float[4096];
    private final float[] drag = new float[4096];
    private final float[] a0 = new float[4096];
    private final float[] tw = new float[4096];
    private final float[] ph = new float[4096];
    private final int[] color = new int[4096];
    private int ripples;
    private final float[] rx = new float[6];
    private final float[] ry = new float[6];
    private final float[] rt = new float[6];
    private final float[] rdur = new float[6];
    private final float[] r0 = new float[6];
    private final float[] r1 = new float[6];
    private final float[] ru = new float[6];
    private final float[] ra = new float[6];
    private uok scene;
    private uok fx;
    private uok emit;
    private final uok[] down = new uok[4];
    private final uok[] up = new uok[3];
    private int targetW = -1;
    private int targetH = -1;
    private GpuBuffer uniforms;
    private GpuBuffer vertices;
    private long capacity;
    private ByteBuffer staging;
    private boolean failed;
    private boolean closed;
    private float fit;
    private float rectX;
    private float rectY;

    private Intro(Signature sig) {
        this.sig = sig;
        this.write = Intro.clamp(sig.length / (sig.size * 13.0f), 1.8f, 2.8f);
    }

    static void preload() {
        if (loading == null) {
            loading = CompletableFuture.supplyAsync(() -> {
                try {
                    return Signature.load();
                }
                catch (Throwable t) {
                    throw new IllegalStateException(t);
                }
            });
        }
    }

    static Intro create() {
        Intro.preload();
        if (!loading.isDone() || loading.isCompletedExceptionally()) {
            return null;
        }
        return new Intro(loading.join());
    }

    static boolean unavailable() {
        return loading != null && loading.isCompletedExceptionally();
    }

    private float writeEnd() {
        return 0.5f + this.write;
    }

    private float earliest() {
        return this.writeEnd() + 0.85f + 0.35f;
    }

    void loading(float p) {
        this.loadTarget = Math.max(this.loadTarget, Intro.clamp(p, 0.0f, 1.0f));
    }

    float known() {
        return this.loadKnown;
    }

    private float fillX() {
        return Intro.lerp(this.sig.streamMin, this.sig.streamMax, this.loadShown);
    }

    private float pulseX() {
        float reach = this.loadKnown > 0.5f ? this.fillX() + this.sig.size * 0.25f : this.sig.streamMax + this.sig.size * 0.4f;
        return Intro.lerp(this.sig.streamMin - this.sig.size * 0.4f, reach, this.pulse);
    }

    void step(float dt, boolean loaded) {
        this.time += dt;
        this.loadShown += (this.loadTarget - this.loadShown) * (1.0f - (float)Math.exp(-dt * 4.0f));
        this.loadKnown += ((this.loadTarget > 0.015f ? 1.0f : 0.0f) - this.loadKnown) * (1.0f - (float)Math.exp(-dt * 5.0f));
        this.pulse = (this.pulse + dt / (this.loadKnown > 0.5f ? 1.3f : 1.9f)) % 1.0f;
        if (loaded && this.doneAt < 0.0f) {
            this.doneAt = this.time;
        }
        if (this.outAt < 0.0f && this.doneAt >= 0.0f && this.time >= Math.max(this.earliest(), this.doneAt + 0.25f)) {
            this.outAt = this.time;
        }
        this.simulate(dt);
    }

    boolean dissolving() {
        return this.outAt >= 0.0f;
    }

    boolean finished() {
        return this.outAt >= 0.0f && this.time >= this.outAt + 2.15f;
    }

    float layer() {
        return this.outAt < 0.0f ? 1.0f : 1.0f - Intro.smooth(this.outAt + 0.45f, this.outAt + 1.5f, this.time);
    }

    float waiting() {
        float show = Intro.smooth(this.earliest() + 0.2f, this.earliest() + 0.8f, this.time);
        return this.doneAt >= 0.0f ? show * (1.0f - Intro.smooth(this.doneAt, this.doneAt + 0.3f, this.time)) : show;
    }

    private float head(float t) {
        if (t < 0.5f) {
            return -1.0f;
        }
        float k = Intro.clamp((t - 0.5f) / this.write, 0.0f, 1.0f);
        float e = k < 0.5f ? 2.0f * k * k : 1.0f - (-2.0f * k + 2.0f) * (-2.0f * k + 2.0f) / 2.0f;
        return this.sig.length * (0.45f * k + 0.55f * e);
    }

    private float progress(float t) {
        return Intro.clamp((t - 0.5f) / this.write, 0.0f, 1.0f);
    }

    private float shineHead(float t) {
        float k = (t - this.writeEnd() - 0.05f) / 0.85f;
        if (k > 0.0f && k < 1.0f) {
            return Intro.lerp(-this.sig.size * 0.4f, this.sig.length + this.sig.size * 1.6f, Intro.sine(k));
        }
        return Float.NaN;
    }

    private float shineStrength(float t) {
        return 0.8f;
    }

    private float front(float t) {
        return Intro.lerp(this.sig.x0 - this.sig.size * 0.95f, this.sig.x1 + this.sig.size * 0.6f, Intro.sine((t - this.outAt) / 1.05f));
    }

    private void simulate(float dt) {
        int i;
        float hold;
        float g0;
        float head = this.head(this.time);
        float unit = this.sig.size / 250.0f;
        if (head > this.prevHead) {
            for (int d = 0; d < this.sig.dropS.length; ++d) {
                if (!(this.sig.dropS[d] > this.prevHead) || !(this.sig.dropS[d] <= head)) continue;
                this.splash(d, d == 0 ? 16 : 6);
            }
            if (this.prevHead >= 0.0f) {
                float hi = Math.min(head, this.sig.length);
                this.emitAcc += Math.max(0.0f, hi - this.prevHead) * 0.05f / unit;
                while (this.emitAcc >= 1.0f) {
                    this.emitAcc -= 1.0f;
                    if (!this.sig.tip(Intro.lerp(this.prevHead, hi, (float)this.random.nextDouble()), this.tip)) continue;
                    this.spark(1.0f);
                }
            }
            this.prevHead = head;
        }
        if (!Float.isNaN(g0 = this.shineHead(this.time))) {
            this.shineAcc += dt * 80.0f;
            while (this.shineAcc >= 1.0f) {
                this.shineAcc -= 1.0f;
                if (!this.sig.tip(g0 - this.sig.size * 0.8f * (0.3f + 0.7f * (float)this.random.nextDouble()), this.tip)) continue;
                this.spark(0.6f);
            }
        }
        if ((hold = this.waiting()) > 0.3f && this.sig.streamPath != null) {
            this.loadAcc += dt * (this.loadKnown > 0.5f ? 16.0f : 7.0f) * hold;
            while (this.loadAcc >= 1.0f) {
                this.loadAcc -= 1.0f;
                if (!this.sig.streamPoint(this.loadKnown > 0.5f ? this.fillX() : this.pulseX(), this.tip)) continue;
                this.bubble();
            }
        }
        if (this.outAt >= 0.0f) {
            float f = this.front(this.time);
            while (this.dust < this.sig.sampleK.length && this.sig.sampleK[this.dust] < f) {
                this.dust(this.dust++);
            }
        }
        for (i = this.count - 1; i >= 0; --i) {
            int n = i;
            this.age[n] = this.age[n] + dt;
            if (this.age[i] >= this.life[i]) {
                this.remove(i);
                continue;
            }
            float gx = this.tx[i];
            float gy = this.ty[i];
            if (this.fs[i] != 0.0f) {
                this.flow(this.px[i], this.py[i], this.time, this.sig.size);
                gx += this.flow[0] * this.fs[i];
                gy += this.flow[1] * this.fs[i];
            }
            float q = Math.min(1.0f, dt * this.drag[i]);
            int n2 = i;
            this.vx[n2] = this.vx[n2] + (gx - this.vx[i]) * q;
            int n3 = i;
            this.vy[n3] = this.vy[n3] + (gy - this.vy[i]) * q;
            int n4 = i;
            this.px[n4] = this.px[n4] + this.vx[i] * dt;
            int n5 = i;
            this.py[n5] = this.py[n5] + this.vy[i] * dt;
        }
        for (i = this.ripples - 1; i >= 0; --i) {
            if (!(this.time > this.rt[i] + this.rdur[i])) continue;
            int last = --this.ripples;
            this.rx[i] = this.rx[last];
            this.ry[i] = this.ry[last];
            this.rt[i] = this.rt[last];
            this.rdur[i] = this.rdur[last];
            this.r0[i] = this.r0[last];
            this.r1[i] = this.r1[last];
            this.ru[i] = this.ru[last];
            this.ra[i] = this.ra[last];
        }
    }

    private void flow(float x, float y, float t, float s) {
        float fx0 = x / s * 1.3f;
        float fy0 = y / s * 1.3f + t * 0.4f;
        float h = 0.04f;
        this.flow[0] = (Signature.noise(fx0, fy0 + h) - Signature.noise(fx0, fy0 - h)) / (2.0f * h);
        this.flow[1] = -(Signature.noise(fx0 + h, fy0) - Signature.noise(fx0 - h, fy0)) / (2.0f * h);
    }

    private float rnd() {
        return (float)this.random.nextDouble();
    }

    private int pick(float u) {
        float[] c = Intro.palette(u);
        return Intro.pack(c);
    }

    private static int pack(float[] c) {
        return Math.round(c[0] * 255.0f) << 16 | Math.round(c[1] * 255.0f) << 8 | Math.round(c[2] * 255.0f);
    }

    private boolean add(float x, float y, float vx0, float vy0, float life0, float size0, float fs0, float tx0, float ty0, float drag0, float a2, int rgb) {
        if (this.count >= 4096) {
            return false;
        }
        int i = this.count++;
        this.px[i] = x;
        this.py[i] = y;
        this.vx[i] = vx0;
        this.vy[i] = vy0;
        this.age[i] = 0.0f;
        this.life[i] = life0;
        this.size[i] = size0;
        this.fs[i] = fs0;
        this.tx[i] = tx0;
        this.ty[i] = ty0;
        this.drag[i] = drag0;
        this.a0[i] = a2;
        this.tw[i] = 6.0f + this.rnd() * 10.0f;
        this.ph[i] = this.rnd() * 6.3f;
        this.color[i] = rgb;
        return true;
    }

    private void remove(int i) {
        int last = --this.count;
        this.px[i] = this.px[last];
        this.py[i] = this.py[last];
        this.vx[i] = this.vx[last];
        this.vy[i] = this.vy[last];
        this.age[i] = this.age[last];
        this.life[i] = this.life[last];
        this.size[i] = this.size[last];
        this.fs[i] = this.fs[last];
        this.tx[i] = this.tx[last];
        this.ty[i] = this.ty[last];
        this.drag[i] = this.drag[last];
        this.a0[i] = this.a0[last];
        this.tw[i] = this.tw[last];
        this.ph[i] = this.ph[last];
        this.color[i] = this.color[last];
    }

    private void spark(float f) {
        float s = this.sig.size;
        float k = s / 250.0f;
        float sp = (20.0f + this.rnd() * 60.0f) * k;
        float side = (this.rnd() - 0.5f) * 80.0f * k;
        int rgb = this.rnd() < 0.25f ? Intro.pack(WHITE) : this.pick(this.sig.u(this.tip[0]) + (this.rnd() - 0.5f) * 0.15f);
        this.add(this.tip[0] + (this.rnd() - 0.5f) * 3.0f * k, this.tip[1] + (this.rnd() - 0.5f) * 3.0f * k, this.tip[2] * sp - this.tip[3] * side, this.tip[3] * sp + this.tip[2] * side - 25.0f * k, (0.5f + this.rnd() * 0.7f) * f + 0.2f, (0.8f + this.rnd() * 1.3f) * k, s * 0.22f, 0.0f, -s * 0.14f, 2.2f, 0.9f, rgb);
    }

    private void splash(int d, int n) {
        float s = this.sig.size;
        float k = s / 250.0f;
        float u = this.sig.u(this.sig.dropX[d]);
        this.ripple(this.sig.dropX[d], this.sig.dropY[d], this.time, 1.15f, this.sig.dropR[d], s * 0.42f, u, 1.0f);
        this.ripple(this.sig.dropX[d], this.sig.dropY[d], this.time + 0.16f, 1.0f, this.sig.dropR[d], s * 0.28f, u, 0.55f);
        for (int i = 0; i < n; ++i) {
            float th = (float)(-1.5707963267948966 + (double)((this.rnd() - 0.5f) * 2.2f));
            float sp = (70.0f + this.rnd() * 110.0f) * k;
            int rgb = this.rnd() < 0.4f ? Intro.pack(WHITE) : this.pick(u);
            this.add(this.sig.dropX[d], this.sig.dropY[d], (float)Math.cos(th) * sp, (float)Math.sin(th) * sp, 0.45f + this.rnd() * 0.5f, (0.9f + this.rnd() * 1.1f) * k, 0.0f, 0.0f, s * 0.9f, 1.1f, 0.95f, rgb);
        }
    }

    private void ripple(float x, float y, float t0, float dur, float from, float to, float u, float a2) {
        if (this.ripples >= 6) {
            return;
        }
        int i = this.ripples++;
        this.rx[i] = x;
        this.ry[i] = y;
        this.rt[i] = t0;
        this.rdur[i] = dur;
        this.r0[i] = from;
        this.r1[i] = to;
        this.ru[i] = u;
        this.ra[i] = a2;
    }

    private void bubble() {
        float s = this.sig.size;
        float k = s / 250.0f;
        int rgb = this.rnd() < 0.3f ? Intro.pack(WHITE) : this.pick(this.sig.u(this.tip[0]) + (this.rnd() - 0.5f) * 0.1f);
        this.add(this.tip[0] + (this.rnd() - 0.5f) * 6.0f * k, this.tip[1] + (this.rnd() - 0.5f) * 3.0f * k, (this.rnd() - 0.5f) * 20.0f * k, (-20.0f - this.rnd() * 35.0f) * k, 0.6f + this.rnd() * 0.7f, (0.6f + this.rnd() * 0.8f) * k, s * 0.12f, 0.0f, -s * 0.12f, 1.8f, 0.8f, rgb);
    }

    private void dust(int i) {
        float s = this.sig.size;
        float k = s / 250.0f;
        float x = this.sig.sampleX[i];
        float y = this.sig.sampleY[i];
        int rgb = this.rnd() < 0.22f ? Intro.pack(WHITE) : this.pick(this.sig.u(x) + (this.rnd() - 0.5f) * 0.1f);
        this.add(x, y, (this.rnd() - 0.5f) * 30.0f * k, (-10.0f - this.rnd() * 30.0f) * k, 0.7f + this.rnd() * 0.75f, (0.7f + this.rnd() * 1.2f) * k, s * 0.5f, s * 0.42f, -s * 0.2f, 1.6f, 0.75f, rgb);
    }

    float captionY() {
        return this.rectY + (this.sig.base + this.sig.size * 0.62f) * this.fit;
    }

    boolean render(DrawContext ctx, int guiW, int guiH, float alpha) {
        if (this.failed || this.closed) {
            return false;
        }
        if (!(uvq.ensure(EMIT) && uvq.ensure(COMPOSITE) && uvq.ensure(FX) && uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP))) {
            this.failed = true;
            return false;
        }
        try {
            unf.observe(ctx);
            MinecraftClient mc = MinecraftClient.getInstance();
            int w = Math.max(8, mc.getWindow().getFramebufferWidth());
            int h = Math.max(8, mc.getWindow().getFramebufferHeight());
            GpuDevice device = RenderSystem.getDevice();
            this.targets(device, w, h);
            GpuTextureView glyph = this.sig.view();
            this.fit = Math.min((float)w * 0.72f / (float)this.sig.width, (float)h * 0.5f / (float)this.sig.height) * (1.0f + 0.035f * Intro.sine(Math.min(this.time, 6.0f) / 6.0f));
            this.rectX = ((float)w - (float)this.sig.width * this.fit) * 0.5f;
            this.rectY = ((float)h - (float)this.sig.height * this.fit) * 0.5f - (float)h * 0.035f;
            CommandEncoder encoder = device.createCommandEncoder();
            this.writeUniforms(encoder, w, h);
            GpuSampler linear = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            GpuSampler nearest = RenderSystem.getSamplerCache().get(FilterMode.NEAREST);
            try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 intro emit", this.emit.view, OptionalInt.empty());){
                pass.setPipeline(EMIT);
                pass.bindTexture("GlyphSampler", glyph, linear);
                pass.bindTexture("SMapSampler", glyph, nearest);
                pass.setUniform("FlowIntro", this.uniforms);
                pass.draw(0, 3);
            }
            GpuTextureView in = this.emit.view;
            for (uok t : this.down) {
                Intro.blit(encoder, uvq.BLUR_DOWN, in, t.view, linear);
                in = t.view;
            }
            for (int i = this.up.length - 1; i >= 0; --i) {
                Intro.blit(encoder, uvq.BLUR_UP, in, this.up[i].view, linear);
                in = this.up[i].view;
            }
            try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 intro", this.scene.view, OptionalInt.empty());){
                pass.setPipeline(COMPOSITE);
                pass.bindTexture("GlyphSampler", glyph, linear);
                pass.bindTexture("SMapSampler", glyph, nearest);
                pass.bindTexture("EmitSampler", this.emit.view, linear);
                pass.bindTexture("MidSampler", this.down[0].view, linear);
                pass.bindTexture("WideSampler", this.up[0].view, linear);
                pass.setUniform("FlowIntro", this.uniforms);
                pass.draw(0, 3);
            }
            int verts = this.particles(device, encoder);
            try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 intro fx", this.fx.view, OptionalInt.of(0));){
                if (verts > 0) {
                    pass.setPipeline(FX);
                    pass.setUniform("FlowIntro", this.uniforms);
                    pass.setVertexBuffer(0, this.vertices);
                    pass.draw(0, verts);
                }
            }
            float layer = this.layer() * alpha;
            if (layer > 0.002f) {
                uut.image(ctx, this.scene.view, 0.0f, 0.0f, guiW, guiH, 0.0f, Intro.white(layer));
            }
            if (verts > 0 && alpha > 0.002f) {
                uut.additive(true);
                uut.image(ctx, this.fx.view, 0.0f, 0.0f, guiW, guiH, 0.0f, Intro.white(alpha));
                uut.additive(false);
            }
            return true;
        }
        catch (Throwable t) {
            this.failed = true;
            System.out.println("intro failed: " + t);
            return false;
        }
    }

    private void writeUniforms(CommandEncoder encoder, int w, int h) {
        float p;
        boolean writing;
        float s = this.sig.size;
        float unit = s * this.fit;
        float head = this.head(this.time);
        float k = this.progress(this.time);
        boolean bl = writing = head >= 0.0f && k < 1.0f;
        float penHead = head < 0.0f ? -1.0f : (writing ? head : this.sig.length + s * 1.1f);
        float g0 = this.outAt < 0.0f ? this.shineHead(this.time) : Float.NaN;
        boolean dis = this.outAt >= 0.0f;
        float glowK = 1.0f + 0.07f * (float)Math.sin(this.time * 2.1f);
        float bg = Intro.smooth(0.0f, 0.9f, this.time) * (dis ? 1.0f - Intro.smooth(this.outAt + 0.6f, this.outAt + 1.6f, this.time) : 1.0f);
        float pres = dis ? 1.0f - Intro.sine((this.time - this.outAt) / 1.05f) : (head < 0.0f ? 0.0f : 0.35f + 0.65f * k);
        float tipX = 0.0f;
        float tipY = 0.0f;
        float tipA = 0.0f;
        float tipU = 0.0f;
        if (writing) {
            boolean on = this.sig.tip(head, this.tip);
            tipX = this.rectX + this.tip[0] * this.fit;
            tipY = this.rectY + this.tip[1] * this.fit;
            tipA = (on ? 1.0f : 0.55f) * (1.0f - Intro.smooth(0.95f, 1.0f, k));
            tipU = this.sig.u(this.tip[0]);
        }
        float dropX = 0.0f;
        float dropY = 0.0f;
        float dropA = 0.0f;
        float dropP = 0.0f;
        if (this.sig.dropS.length > 0 && this.time < 0.56f && (p = Intro.clamp((this.time - 0.08f) / 0.42000002f, 0.0f, 1.0f)) > 0.0f) {
            dropX = this.rectX + this.sig.dropX[0] * this.fit;
            dropY = this.rectY + (this.sig.dropY[0] - s * 1.15f * (1.0f - p * p)) * this.fit;
            dropA = Intro.smooth(0.0f, 0.3f, p) * (this.time < 0.5f ? 1.0f : 1.0f - Intro.clamp((this.time - 0.5f) / 0.06f, 0.0f, 1.0f));
            dropP = p;
        }
        float line = Math.max(1.0f, unit * 0.006f);
        try (MemoryStack stack = MemoryStack.stackPush();){
            int i;
            Std140Builder b = Std140Builder.onStack((MemoryStack)stack, (int)400).putVec4((float)w, (float)h, 1.0f / (float)w, 1.0f / (float)h).putVec4(this.rectX, this.rectY, (float)this.sig.width * this.fit, (float)this.sig.height * this.fit).putVec4(s, this.sig.length, this.sig.scale, (float)this.sig.width).putVec4(this.sig.x0, this.sig.x1, this.sig.base, (float)this.sig.height).putVec4(this.time, glowK, bg, pres).putVec4(penHead, s * 0.55f, s * 1.8f, writing ? 1.0f : 0.0f).putVec4(Float.isNaN(g0) ? 0.0f : g0, s * 1.6f, Float.isNaN(g0) ? 0.0f : this.shineStrength(this.time), 0.0f).putVec4(dis ? this.front(this.time) : 0.0f, s * 0.22f, s * 0.32f, dis ? 1.0f : 0.0f).putVec4(tipX, tipY, tipA, tipU).putVec4(dropX, dropY, dropA, dropP).putVec4((float)w * 0.5f, this.rectY + (this.sig.base + s * 0.4f) * this.fit, (float)this.sig.width * this.fit, 0.1f * glowK * pres).putVec4(this.fillX(), this.waiting(), this.pulseX(), this.loadKnown > 0.5f ? 2.0f : 1.0f).putVec4(this.sig.streamS, this.sig.streamMin, this.sig.streamMax, 0.0f);
            for (i = 0; i < 6; ++i) {
                float q;
                float f = q = i < this.ripples ? (this.time - this.rt[i]) / this.rdur[i] : -1.0f;
                if (q <= 0.0f || q >= 1.0f) {
                    b.putVec4(0.0f, 0.0f, 0.0f, 0.0f);
                    continue;
                }
                float e = 1.0f - (1.0f - q) * (1.0f - q) * (1.0f - q);
                b.putVec4(this.rectX + this.rx[i] * this.fit, this.rectY + this.ry[i] * this.fit, (this.r0[i] + this.r1[i] * e) * this.fit, (float)Math.pow(1.0f - q, 1.7f) * this.ra[i]);
            }
            for (i = 0; i < 6; ++i) {
                float[] c = Intro.palette(i < this.ripples ? this.ru[i] : 0.0f);
                b.putVec4(c[0], c[1], c[2], line);
            }
            encoder.writeToBuffer(this.uniforms.slice(), b.get());
        }
    }

    private int particles(GpuDevice device, CommandEncoder encoder) {
        float pf = this.outAt >= 0.0f ? 1.0f - Intro.smooth(this.outAt + 2.15f - 0.45f, this.outAt + 2.15f, this.time) : 1.0f;
        int need = this.count * 6 * 24;
        if (need == 0) {
            return 0;
        }
        if (this.staging == null || this.staging.capacity() < need) {
            if (this.staging != null) {
                MemoryUtil.memFree((Buffer)this.staging);
            }
            this.staging = MemoryUtil.memAlloc((int)Math.max(need, 65536));
        }
        this.staging.clear();
        int verts = 0;
        for (int i = 0; i < this.count; ++i) {
            float q = this.age[i] / this.life[i];
            float a2 = this.a0[i] * Intro.smooth(0.0f, 0.1f, q) * (1.0f - Intro.smooth(0.4f, 1.0f, q)) * (0.75f + 0.25f * (float)Math.sin(this.age[i] * this.tw[i] + this.ph[i])) * pf;
            if (a2 <= 0.004f) continue;
            float r = this.size[i] * this.fit * 5.5f;
            float cx = this.rectX + this.px[i] * this.fit;
            float cy = this.rectY + this.py[i] * this.fit;
            byte cr = (byte)(this.color[i] >> 16 & 0xFF);
            byte cg = (byte)(this.color[i] >> 8 & 0xFF);
            byte cb = (byte)(this.color[i] & 0xFF);
            byte ca = (byte)Math.round(Intro.clamp(a2, 0.0f, 1.0f) * 255.0f);
            this.vertex(cx - r, cy - r, -1.0f, -1.0f, cr, cg, cb, ca);
            this.vertex(cx + r, cy - r, 1.0f, -1.0f, cr, cg, cb, ca);
            this.vertex(cx + r, cy + r, 1.0f, 1.0f, cr, cg, cb, ca);
            this.vertex(cx - r, cy - r, -1.0f, -1.0f, cr, cg, cb, ca);
            this.vertex(cx + r, cy + r, 1.0f, 1.0f, cr, cg, cb, ca);
            this.vertex(cx - r, cy + r, -1.0f, 1.0f, cr, cg, cb, ca);
            verts += 6;
        }
        if (verts == 0) {
            return 0;
        }
        int bytes = verts * 24;
        if (this.vertices == null || this.capacity < (long)bytes) {
            if (this.vertices != null) {
                this.vertices.close();
            }
            this.capacity = Math.max((long)bytes, Math.max(262144L, this.capacity * 2L));
            this.vertices = device.createBuffer(() -> "Flow2 intro particles", 40, this.capacity);
        }
        this.staging.flip();
        encoder.writeToBuffer(this.vertices.slice(0L, (long)bytes), this.staging);
        return verts;
    }

    private void vertex(float x, float y, float u, float v, byte r, byte g, byte b, byte a2) {
        this.staging.putFloat(x).putFloat(y).putFloat(0.0f).putFloat(u).putFloat(v).put(r).put(g).put(b).put(a2);
    }

    private void targets(GpuDevice device, int w, int h) {
        int i;
        if (this.uniforms == null) {
            this.uniforms = device.createBuffer(() -> "Flow2 intro", 136, 400L);
        }
        if (this.scene != null && w == this.targetW && h == this.targetH) {
            return;
        }
        this.retireTargets();
        this.scene = uok.target("intro", w, h);
        this.fx = uok.target("intro fx", w, h);
        this.emit = uok.target("intro emit", Math.max(4, w / 2), Math.max(4, h / 2));
        for (i = 0; i < this.down.length; ++i) {
            this.down[i] = uok.target("intro bloom " + i, Math.max(2, w >> i + 2), Math.max(2, h >> i + 2));
        }
        for (i = 0; i < this.up.length; ++i) {
            this.up[i] = uok.target("intro glow " + i, Math.max(2, w >> i + 2), Math.max(2, h >> i + 2));
        }
        this.targetW = w;
        this.targetH = h;
    }

    private static void blit(CommandEncoder encoder, RenderPipeline pipeline, GpuTextureView in, GpuTextureView out, GpuSampler sampler) {
        try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 intro bloom", out, OptionalInt.empty());){
            pass.setPipeline(pipeline);
            pass.bindTexture("InSampler", in, sampler);
            pass.draw(0, 3);
        }
    }

    private void retireTargets() {
        int i;
        Intro.retire(this.scene);
        Intro.retire(this.fx);
        Intro.retire(this.emit);
        for (i = 0; i < this.down.length; ++i) {
            Intro.retire(this.down[i]);
            this.down[i] = null;
        }
        for (i = 0; i < this.up.length; ++i) {
            Intro.retire(this.up[i]);
            this.up[i] = null;
        }
        this.emit = null;
        this.fx = null;
        this.scene = null;
    }

    void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.retireTargets();
        Intro.retire((AutoCloseable)this.uniforms);
        Intro.retire((AutoCloseable)this.vertices);
        Intro.retire(this.sig::close);
        this.uniforms = null;
        this.vertices = null;
        if (this.staging != null) {
            MemoryUtil.memFree((Buffer)this.staging);
            this.staging = null;
        }
        loading = null;
    }

    private static void retire(AutoCloseable c) {
        if (c != null) {
            RETIRED.add(c);
            RETIRED_AT.add(unf.frame());
        }
    }

    static void collect() {
        long now = unf.frame();
        for (int i = RETIRED.size() - 1; i >= 0; --i) {
            if (now - RETIRED_AT.get(i) <= 3L) continue;
            try {
                RETIRED.remove(i).close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            RETIRED_AT.remove(i);
        }
    }

    private static RenderPipeline screen(String name, String ... samplers) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(uvq.id("pipeline/" + name)).withVertexShader(uvq.id("core/blur")).withFragmentShader(uvq.id("core/" + name)).withUniform("FlowIntro", UniformType.UNIFORM_BUFFER).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(VertexFormats.EMPTY, VertexFormat.DrawMode.TRIANGLES);
        for (String s : samplers) {
            builder.withSampler(s);
        }
        return builder.build();
    }

    private static float[] palette(float u) {
        float v = Intro.clamp(u, 0.0f, 1.0f) * 2.0f;
        int i = Math.min(1, (int)v);
        float f = v - (float)i;
        return new float[]{Intro.lerp(PAL[i][0], PAL[i + 1][0], f), Intro.lerp(PAL[i][1], PAL[i + 1][1], f), Intro.lerp(PAL[i][2], PAL[i + 1][2], f)};
    }

    private static int white(float a2) {
        int al = Math.max(0, Math.min(255, Math.round(a2 * 255.0f)));
        return al << 24 | 0xFFFFFF;
    }

    private static float clamp(float v, float a2, float b) {
        return v < a2 ? a2 : Math.min(v, b);
    }

    private static float lerp(float a2, float b, float t) {
        return a2 + (b - a2) * t;
    }

    private static float sine(float k) {
        return 0.5f - 0.5f * (float)Math.cos(Math.PI * (double)Intro.clamp(k, 0.0f, 1.0f));
    }

    private static float smooth(float a2, float b, float v) {
        float t = Intro.clamp((v - a2) / (b - a2), 0.0f, 1.0f);
        return t * t * (3.0f - 2.0f * t);
    }

    static {
        RETIRED = new ArrayList<AutoCloseable>();
        RETIRED_AT = new ArrayList<Long>();
    }
}

