package flow.splash;

import a.unf;
import a.uok;
import a.uut;
import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
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
   private static final float START = 0.5F;
   private static final float GLINT = 0.85F;
   private static final float SWEEP = 1.05F;
   private static final float END = 2.15F;
   private static final float[][] PAL = new float[][]{{1.0F, 0.365F, 0.561F}, {0.82F, 0.298F, 1.0F}, {0.486F, 0.42F, 1.0F}};
   private static final float[] WHITE = new float[]{1.0F, 0.894F, 0.965F};
   private static final RenderPipeline EMIT = screen("intro_emit", "GlyphSampler", "SMapSampler");
   private static final RenderPipeline COMPOSITE = screen("intro_composite", "GlyphSampler", "SMapSampler", "EmitSampler", "MidSampler", "WideSampler");
   private static final RenderPipeline FX = RenderPipeline.builder(new Snippet[0])
      .withLocation(uvq.id("pipeline/intro_fx"))
      .withVertexShader(uvq.id("core/intro_fx"))
      .withFragmentShader(uvq.id("core/intro_fx"))
      .withUniform("FlowIntro", UniformType.field_60031)
      .withBlend(BlendFunction.ADDITIVE)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.field_1575, DrawMode.field_27379)
      .build();
   private static CompletableFuture<Signature> loading;
   private static final List<AutoCloseable> RETIRED = new ArrayList<>();
   private static final List<Long> RETIRED_AT = new ArrayList<>();
   private final Signature sig;
   private final float write;
   private final SplittableRandom random = new SplittableRandom(11L);
   private final float[] tip = new float[4];
   private final float[] flow = new float[2];
   private float time;
   private float doneAt = -1.0F;
   private float outAt = -1.0F;
   private float prevHead = -1.0F;
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
      this.write = clamp(sig.length / (sig.size * 13.0F), 1.8F, 2.8F);
   }

   static void preload() {
      if (loading == null) {
         loading = CompletableFuture.supplyAsync(() -> {
            try {
               return Signature.load();
            } catch (Throwable var1) {
               throw new IllegalStateException(var1);
            }
         });
      }
   }

   static Intro create() {
      preload();
      return loading.isDone() && !loading.isCompletedExceptionally() ? new Intro(loading.join()) : null;
   }

   static boolean unavailable() {
      return loading != null && loading.isCompletedExceptionally();
   }

   private float writeEnd() {
      return 0.5F + this.write;
   }

   private float earliest() {
      return this.writeEnd() + 0.85F + 0.35F;
   }

   void loading(float p) {
      this.loadTarget = Math.max(this.loadTarget, clamp(p, 0.0F, 1.0F));
   }

   float known() {
      return this.loadKnown;
   }

   private float fillX() {
      return lerp(this.sig.streamMin, this.sig.streamMax, this.loadShown);
   }

   private float pulseX() {
      float reach = this.loadKnown > 0.5F ? this.fillX() + this.sig.size * 0.25F : this.sig.streamMax + this.sig.size * 0.4F;
      return lerp(this.sig.streamMin - this.sig.size * 0.4F, reach, this.pulse);
   }

   void step(float dt, boolean loaded) {
      this.time += dt;
      this.loadShown = this.loadShown + (this.loadTarget - this.loadShown) * (1.0F - (float)Math.exp(-dt * 4.0F));
      this.loadKnown = this.loadKnown + ((this.loadTarget > 0.015F ? 1.0F : 0.0F) - this.loadKnown) * (1.0F - (float)Math.exp(-dt * 5.0F));
      this.pulse = (this.pulse + dt / (this.loadKnown > 0.5F ? 1.3F : 1.9F)) % 1.0F;
      if (loaded && this.doneAt < 0.0F) {
         this.doneAt = this.time;
      }

      if (this.outAt < 0.0F && this.doneAt >= 0.0F && this.time >= Math.max(this.earliest(), this.doneAt + 0.25F)) {
         this.outAt = this.time;
      }

      this.simulate(dt);
   }

   boolean dissolving() {
      return this.outAt >= 0.0F;
   }

   boolean finished() {
      return this.outAt >= 0.0F && this.time >= this.outAt + 2.15F;
   }

   float layer() {
      return this.outAt < 0.0F ? 1.0F : 1.0F - smooth(this.outAt + 0.45F, this.outAt + 1.5F, this.time);
   }

   float waiting() {
      float show = smooth(this.earliest() + 0.2F, this.earliest() + 0.8F, this.time);
      return this.doneAt >= 0.0F ? show * (1.0F - smooth(this.doneAt, this.doneAt + 0.3F, this.time)) : show;
   }

   private float head(float t) {
      if (t < 0.5F) {
         return -1.0F;
      } else {
         float k = clamp((t - 0.5F) / this.write, 0.0F, 1.0F);
         float e = k < 0.5F ? 2.0F * k * k : 1.0F - (-2.0F * k + 2.0F) * (-2.0F * k + 2.0F) / 2.0F;
         return this.sig.length * (0.45F * k + 0.55F * e);
      }
   }

   private float progress(float t) {
      return clamp((t - 0.5F) / this.write, 0.0F, 1.0F);
   }

   private float shineHead(float t) {
      float k = (t - this.writeEnd() - 0.05F) / 0.85F;
      return k > 0.0F && k < 1.0F ? lerp(-this.sig.size * 0.4F, this.sig.length + this.sig.size * 1.6F, sine(k)) : Float.NaN;
   }

   private float shineStrength(float t) {
      return 0.8F;
   }

   private float front(float t) {
      return lerp(this.sig.x0 - this.sig.size * 0.95F, this.sig.x1 + this.sig.size * 0.6F, sine((t - this.outAt) / 1.05F));
   }

   private void simulate(float dt) {
      float head = this.head(this.time);
      float unit = this.sig.size / 250.0F;
      if (head > this.prevHead) {
         for (int d = 0; d < this.sig.dropS.length; d++) {
            if (this.sig.dropS[d] > this.prevHead && this.sig.dropS[d] <= head) {
               this.splash(d, d == 0 ? 16 : 6);
            }
         }

         if (this.prevHead >= 0.0F) {
            float hi = Math.min(head, this.sig.length);
            this.emitAcc = this.emitAcc + Math.max(0.0F, hi - this.prevHead) * 0.05F / unit;

            while (this.emitAcc >= 1.0F) {
               this.emitAcc--;
               if (this.sig.tip(lerp(this.prevHead, hi, (float)this.random.nextDouble()), this.tip)) {
                  this.spark(1.0F);
               }
            }
         }

         this.prevHead = head;
      }

      float g0 = this.shineHead(this.time);
      if (!Float.isNaN(g0)) {
         this.shineAcc += dt * 80.0F;

         while (this.shineAcc >= 1.0F) {
            this.shineAcc--;
            if (this.sig.tip(g0 - this.sig.size * 0.8F * (0.3F + 0.7F * (float)this.random.nextDouble()), this.tip)) {
               this.spark(0.6F);
            }
         }
      }

      float hold = this.waiting();
      if (hold > 0.3F && this.sig.streamPath != null) {
         this.loadAcc = this.loadAcc + dt * (this.loadKnown > 0.5F ? 16.0F : 7.0F) * hold;

         while (this.loadAcc >= 1.0F) {
            this.loadAcc--;
            if (this.sig.streamPoint(this.loadKnown > 0.5F ? this.fillX() : this.pulseX(), this.tip)) {
               this.bubble();
            }
         }
      }

      if (this.outAt >= 0.0F) {
         float f = this.front(this.time);

         while (this.dust < this.sig.sampleK.length && this.sig.sampleK[this.dust] < f) {
            this.dust(this.dust++);
         }
      }

      for (int i = this.count - 1; i >= 0; i--) {
         this.age[i] = this.age[i] + dt;
         if (this.age[i] >= this.life[i]) {
            this.remove(i);
         } else {
            float gx = this.tx[i];
            float gy = this.ty[i];
            if (this.fs[i] != 0.0F) {
               this.flow(this.px[i], this.py[i], this.time, this.sig.size);
               gx += this.flow[0] * this.fs[i];
               gy += this.flow[1] * this.fs[i];
            }

            float q = Math.min(1.0F, dt * this.drag[i]);
            this.vx[i] = this.vx[i] + (gx - this.vx[i]) * q;
            this.vy[i] = this.vy[i] + (gy - this.vy[i]) * q;
            this.px[i] = this.px[i] + this.vx[i] * dt;
            this.py[i] = this.py[i] + this.vy[i] * dt;
         }
      }

      for (int ix = this.ripples - 1; ix >= 0; ix--) {
         if (this.time > this.rt[ix] + this.rdur[ix]) {
            int last = --this.ripples;
            this.rx[ix] = this.rx[last];
            this.ry[ix] = this.ry[last];
            this.rt[ix] = this.rt[last];
            this.rdur[ix] = this.rdur[last];
            this.r0[ix] = this.r0[last];
            this.r1[ix] = this.r1[last];
            this.ru[ix] = this.ru[last];
            this.ra[ix] = this.ra[last];
         }
      }
   }

   private void flow(float x, float y, float t, float s) {
      float fx0 = x / s * 1.3F;
      float fy0 = y / s * 1.3F + t * 0.4F;
      float h = 0.04F;
      this.flow[0] = (Signature.noise(fx0, fy0 + h) - Signature.noise(fx0, fy0 - h)) / (2.0F * h);
      this.flow[1] = -(Signature.noise(fx0 + h, fy0) - Signature.noise(fx0 - h, fy0)) / (2.0F * h);
   }

   private float rnd() {
      return (float)this.random.nextDouble();
   }

   private int pick(float u) {
      float[] c = palette(u);
      return pack(c);
   }

   private static int pack(float[] c) {
      return Math.round(c[0] * 255.0F) << 16 | Math.round(c[1] * 255.0F) << 8 | Math.round(c[2] * 255.0F);
   }

   private boolean add(float x, float y, float vx0, float vy0, float life0, float size0, float fs0, float tx0, float ty0, float drag0, float a, int rgb) {
      if (this.count >= 4096) {
         return false;
      } else {
         int i = this.count++;
         this.px[i] = x;
         this.py[i] = y;
         this.vx[i] = vx0;
         this.vy[i] = vy0;
         this.age[i] = 0.0F;
         this.life[i] = life0;
         this.size[i] = size0;
         this.fs[i] = fs0;
         this.tx[i] = tx0;
         this.ty[i] = ty0;
         this.drag[i] = drag0;
         this.a0[i] = a;
         this.tw[i] = 6.0F + this.rnd() * 10.0F;
         this.ph[i] = this.rnd() * 6.3F;
         this.color[i] = rgb;
         return true;
      }
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
      float k = s / 250.0F;
      float sp = (20.0F + this.rnd() * 60.0F) * k;
      float side = (this.rnd() - 0.5F) * 80.0F * k;
      int rgb = this.rnd() < 0.25F ? pack(WHITE) : this.pick(this.sig.u(this.tip[0]) + (this.rnd() - 0.5F) * 0.15F);
      this.add(
         this.tip[0] + (this.rnd() - 0.5F) * 3.0F * k,
         this.tip[1] + (this.rnd() - 0.5F) * 3.0F * k,
         this.tip[2] * sp - this.tip[3] * side,
         this.tip[3] * sp + this.tip[2] * side - 25.0F * k,
         (0.5F + this.rnd() * 0.7F) * f + 0.2F,
         (0.8F + this.rnd() * 1.3F) * k,
         s * 0.22F,
         0.0F,
         -s * 0.14F,
         2.2F,
         0.9F,
         rgb
      );
   }

   private void splash(int d, int n) {
      float s = this.sig.size;
      float k = s / 250.0F;
      float u = this.sig.u(this.sig.dropX[d]);
      this.ripple(this.sig.dropX[d], this.sig.dropY[d], this.time, 1.15F, this.sig.dropR[d], s * 0.42F, u, 1.0F);
      this.ripple(this.sig.dropX[d], this.sig.dropY[d], this.time + 0.16F, 1.0F, this.sig.dropR[d], s * 0.28F, u, 0.55F);

      for (int i = 0; i < n; i++) {
         float th = (float)((-Math.PI / 2) + (this.rnd() - 0.5F) * 2.2F);
         float sp = (70.0F + this.rnd() * 110.0F) * k;
         int rgb = this.rnd() < 0.4F ? pack(WHITE) : this.pick(u);
         this.add(
            this.sig.dropX[d],
            this.sig.dropY[d],
            (float)Math.cos(th) * sp,
            (float)Math.sin(th) * sp,
            0.45F + this.rnd() * 0.5F,
            (0.9F + this.rnd() * 1.1F) * k,
            0.0F,
            0.0F,
            s * 0.9F,
            1.1F,
            0.95F,
            rgb
         );
      }
   }

   private void ripple(float x, float y, float t0, float dur, float from, float to, float u, float a) {
      if (this.ripples < 6) {
         int i = this.ripples++;
         this.rx[i] = x;
         this.ry[i] = y;
         this.rt[i] = t0;
         this.rdur[i] = dur;
         this.r0[i] = from;
         this.r1[i] = to;
         this.ru[i] = u;
         this.ra[i] = a;
      }
   }

   private void bubble() {
      float s = this.sig.size;
      float k = s / 250.0F;
      int rgb = this.rnd() < 0.3F ? pack(WHITE) : this.pick(this.sig.u(this.tip[0]) + (this.rnd() - 0.5F) * 0.1F);
      this.add(
         this.tip[0] + (this.rnd() - 0.5F) * 6.0F * k,
         this.tip[1] + (this.rnd() - 0.5F) * 3.0F * k,
         (this.rnd() - 0.5F) * 20.0F * k,
         (-20.0F - this.rnd() * 35.0F) * k,
         0.6F + this.rnd() * 0.7F,
         (0.6F + this.rnd() * 0.8F) * k,
         s * 0.12F,
         0.0F,
         -s * 0.12F,
         1.8F,
         0.8F,
         rgb
      );
   }

   private void dust(int i) {
      float s = this.sig.size;
      float k = s / 250.0F;
      float x = this.sig.sampleX[i];
      float y = this.sig.sampleY[i];
      int rgb = this.rnd() < 0.22F ? pack(WHITE) : this.pick(this.sig.u(x) + (this.rnd() - 0.5F) * 0.1F);
      this.add(
         x,
         y,
         (this.rnd() - 0.5F) * 30.0F * k,
         (-10.0F - this.rnd() * 30.0F) * k,
         0.7F + this.rnd() * 0.75F,
         (0.7F + this.rnd() * 1.2F) * k,
         s * 0.5F,
         s * 0.42F,
         -s * 0.2F,
         1.6F,
         0.75F,
         rgb
      );
   }

   float captionY() {
      return this.rectY + (this.sig.base + this.sig.size * 0.62F) * this.fit;
   }

   boolean render(DrawContext ctx, int guiW, int guiH, float alpha) {
      if (this.failed || this.closed) {
         return false;
      } else if (uvq.ensure(EMIT) && uvq.ensure(COMPOSITE) && uvq.ensure(FX) && uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP)) {
         try {
            unf.observe(ctx);
            MinecraftClient mc = MinecraftClient.method_1551();
            int w = Math.max(8, mc.method_22683().method_4489());
            int h = Math.max(8, mc.method_22683().method_4506());
            GpuDevice device = RenderSystem.getDevice();
            this.targets(device, w, h);
            GpuTextureView glyph = this.sig.view();
            this.fit = Math.min(w * 0.72F / this.sig.width, h * 0.5F / this.sig.height) * (1.0F + 0.035F * sine(Math.min(this.time, 6.0F) / 6.0F));
            this.rectX = (w - this.sig.width * this.fit) * 0.5F;
            this.rectY = (h - this.sig.height * this.fit) * 0.5F - h * 0.035F;
            CommandEncoder encoder = device.createCommandEncoder();
            this.writeUniforms(encoder, w, h);
            GpuSampler linear = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
            GpuSampler nearest = RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST);
            RenderPass pass = encoder.createRenderPass(() -> "Flow2 intro emit", this.emit.view, OptionalInt.empty());

            try {
               pass.setPipeline(EMIT);
               pass.bindTexture("GlyphSampler", glyph, linear);
               pass.bindTexture("SMapSampler", glyph, nearest);
               pass.setUniform("FlowIntro", this.uniforms);
               pass.draw(0, 3);
            } catch (Throwable var22) {
               if (pass != null) {
                  try {
                     pass.close();
                  } catch (Throwable var20) {
                     var22.addSuppressed(var20);
                  }
               }

               throw var22;
            }

            if (pass != null) {
               pass.close();
            }

            GpuTextureView in = this.emit.view;

            for (uok t : this.down) {
               blit(encoder, uvq.BLUR_DOWN, in, t.view, linear);
               in = t.view;
            }

            for (int i = this.up.length - 1; i >= 0; i--) {
               blit(encoder, uvq.BLUR_UP, in, this.up[i].view, linear);
               in = this.up[i].view;
            }

            RenderPass passx = encoder.createRenderPass(() -> "Flow2 intro", this.scene.view, OptionalInt.empty());

            try {
               passx.setPipeline(COMPOSITE);
               passx.bindTexture("GlyphSampler", glyph, linear);
               passx.bindTexture("SMapSampler", glyph, nearest);
               passx.bindTexture("EmitSampler", this.emit.view, linear);
               passx.bindTexture("MidSampler", this.down[0].view, linear);
               passx.bindTexture("WideSampler", this.up[0].view, linear);
               passx.setUniform("FlowIntro", this.uniforms);
               passx.draw(0, 3);
            } catch (Throwable var21) {
               if (passx != null) {
                  try {
                     passx.close();
                  } catch (Throwable var19) {
                     var21.addSuppressed(var19);
                  }
               }

               throw var21;
            }

            if (passx != null) {
               passx.close();
            }

            int verts = this.particles(device, encoder);
            RenderPass passxx = encoder.createRenderPass(() -> "Flow2 intro fx", this.fx.view, OptionalInt.of(0));

            try {
               if (verts > 0) {
                  passxx.setPipeline(FX);
                  passxx.setUniform("FlowIntro", this.uniforms);
                  passxx.setVertexBuffer(0, this.vertices);
                  passxx.draw(0, verts);
               }
            } catch (Throwable var23) {
               if (passxx != null) {
                  try {
                     passxx.close();
                  } catch (Throwable var18) {
                     var23.addSuppressed(var18);
                  }
               }

               throw var23;
            }

            if (passxx != null) {
               passxx.close();
            }

            float layer = this.layer() * alpha;
            if (layer > 0.002F) {
               uut.image(ctx, this.scene.view, 0.0F, 0.0F, guiW, guiH, 0.0F, white(layer));
            }

            if (verts > 0 && alpha > 0.002F) {
               uut.additive(true);
               uut.image(ctx, this.fx.view, 0.0F, 0.0F, guiW, guiH, 0.0F, white(alpha));
               uut.additive(false);
            }

            return true;
         } catch (Throwable var24) {
            this.failed = true;
            System.out.println("intro failed: " + var24);
            return false;
         }
      } else {
         this.failed = true;
         return false;
      }
   }

   private void writeUniforms(CommandEncoder encoder, int w, int h) {
      float s = this.sig.size;
      float unit = s * this.fit;
      float head = this.head(this.time);
      float k = this.progress(this.time);
      boolean writing = head >= 0.0F && k < 1.0F;
      float penHead = head < 0.0F ? -1.0F : (writing ? head : this.sig.length + s * 1.1F);
      float g0 = this.outAt < 0.0F ? this.shineHead(this.time) : Float.NaN;
      boolean dis = this.outAt >= 0.0F;
      float glowK = 1.0F + 0.07F * (float)Math.sin(this.time * 2.1F);
      float bg = smooth(0.0F, 0.9F, this.time) * (dis ? 1.0F - smooth(this.outAt + 0.6F, this.outAt + 1.6F, this.time) : 1.0F);
      float pres = dis ? 1.0F - sine((this.time - this.outAt) / 1.05F) : (head < 0.0F ? 0.0F : 0.35F + 0.65F * k);
      float tipX = 0.0F;
      float tipY = 0.0F;
      float tipA = 0.0F;
      float tipU = 0.0F;
      if (writing) {
         boolean on = this.sig.tip(head, this.tip);
         tipX = this.rectX + this.tip[0] * this.fit;
         tipY = this.rectY + this.tip[1] * this.fit;
         tipA = (on ? 1.0F : 0.55F) * (1.0F - smooth(0.95F, 1.0F, k));
         tipU = this.sig.u(this.tip[0]);
      }

      float dropX = 0.0F;
      float dropY = 0.0F;
      float dropA = 0.0F;
      float dropP = 0.0F;
      if (this.sig.dropS.length > 0 && this.time < 0.56F) {
         float p = clamp((this.time - 0.08F) / 0.42000002F, 0.0F, 1.0F);
         if (p > 0.0F) {
            dropX = this.rectX + this.sig.dropX[0] * this.fit;
            dropY = this.rectY + (this.sig.dropY[0] - s * 1.15F * (1.0F - p * p)) * this.fit;
            dropA = smooth(0.0F, 0.3F, p) * (this.time < 0.5F ? 1.0F : 1.0F - clamp((this.time - 0.5F) / 0.06F, 0.0F, 1.0F));
            dropP = p;
         }
      }

      float line = Math.max(1.0F, unit * 0.006F);
      MemoryStack stack = MemoryStack.stackPush();

      try {
         Std140Builder b = Std140Builder.onStack(stack, 400)
            .putVec4(w, h, 1.0F / w, 1.0F / h)
            .putVec4(this.rectX, this.rectY, this.sig.width * this.fit, this.sig.height * this.fit)
            .putVec4(s, this.sig.length, this.sig.scale, this.sig.width)
            .putVec4(this.sig.x0, this.sig.x1, this.sig.base, this.sig.height)
            .putVec4(this.time, glowK, bg, pres)
            .putVec4(penHead, s * 0.55F, s * 1.8F, writing ? 1.0F : 0.0F)
            .putVec4(Float.isNaN(g0) ? 0.0F : g0, s * 1.6F, Float.isNaN(g0) ? 0.0F : this.shineStrength(this.time), 0.0F)
            .putVec4(dis ? this.front(this.time) : 0.0F, s * 0.22F, s * 0.32F, dis ? 1.0F : 0.0F)
            .putVec4(tipX, tipY, tipA, tipU)
            .putVec4(dropX, dropY, dropA, dropP)
            .putVec4(w * 0.5F, this.rectY + (this.sig.base + s * 0.4F) * this.fit, this.sig.width * this.fit, 0.1F * glowK * pres)
            .putVec4(this.fillX(), this.waiting(), this.pulseX(), this.loadKnown > 0.5F ? 2.0F : 1.0F)
            .putVec4(this.sig.streamS, this.sig.streamMin, this.sig.streamMax, 0.0F);

         for (int i = 0; i < 6; i++) {
            float q = i < this.ripples ? (this.time - this.rt[i]) / this.rdur[i] : -1.0F;
            if (!(q <= 0.0F) && !(q >= 1.0F)) {
               float e = 1.0F - (1.0F - q) * (1.0F - q) * (1.0F - q);
               b.putVec4(
                  this.rectX + this.rx[i] * this.fit,
                  this.rectY + this.ry[i] * this.fit,
                  (this.r0[i] + this.r1[i] * e) * this.fit,
                  (float)Math.pow(1.0F - q, 1.7F) * this.ra[i]
               );
            } else {
               b.putVec4(0.0F, 0.0F, 0.0F, 0.0F);
            }
         }

         for (int ix = 0; ix < 6; ix++) {
            float[] c = palette(ix < this.ripples ? this.ru[ix] : 0.0F);
            b.putVec4(c[0], c[1], c[2], line);
         }

         encoder.writeToBuffer(this.uniforms.slice(), b.get());
      } catch (Throwable var30) {
         if (stack != null) {
            try {
               stack.close();
            } catch (Throwable var29) {
               var30.addSuppressed(var29);
            }
         }

         throw var30;
      }

      if (stack != null) {
         stack.close();
      }
   }

   private int particles(GpuDevice device, CommandEncoder encoder) {
      float pf = this.outAt >= 0.0F ? 1.0F - smooth(this.outAt + 2.15F - 0.45F, this.outAt + 2.15F, this.time) : 1.0F;
      int need = this.count * 6 * 24;
      if (need == 0) {
         return 0;
      } else {
         if (this.staging == null || this.staging.capacity() < need) {
            if (this.staging != null) {
               MemoryUtil.memFree(this.staging);
            }

            this.staging = MemoryUtil.memAlloc(Math.max(need, 65536));
         }

         this.staging.clear();
         int verts = 0;

         for (int i = 0; i < this.count; i++) {
            float q = this.age[i] / this.life[i];
            float a = this.a0[i]
               * smooth(0.0F, 0.1F, q)
               * (1.0F - smooth(0.4F, 1.0F, q))
               * (0.75F + 0.25F * (float)Math.sin(this.age[i] * this.tw[i] + this.ph[i]))
               * pf;
            if (!(a <= 0.004F)) {
               float r = this.size[i] * this.fit * 5.5F;
               float cx = this.rectX + this.px[i] * this.fit;
               float cy = this.rectY + this.py[i] * this.fit;
               byte cr = (byte)(this.color[i] >> 16 & 0xFF);
               byte cg = (byte)(this.color[i] >> 8 & 0xFF);
               byte cb = (byte)(this.color[i] & 0xFF);
               byte ca = (byte)Math.round(clamp(a, 0.0F, 1.0F) * 255.0F);
               this.vertex(cx - r, cy - r, -1.0F, -1.0F, cr, cg, cb, ca);
               this.vertex(cx + r, cy - r, 1.0F, -1.0F, cr, cg, cb, ca);
               this.vertex(cx + r, cy + r, 1.0F, 1.0F, cr, cg, cb, ca);
               this.vertex(cx - r, cy - r, -1.0F, -1.0F, cr, cg, cb, ca);
               this.vertex(cx + r, cy + r, 1.0F, 1.0F, cr, cg, cb, ca);
               this.vertex(cx - r, cy + r, -1.0F, 1.0F, cr, cg, cb, ca);
               verts += 6;
            }
         }

         if (verts == 0) {
            return 0;
         } else {
            int bytes = verts * 24;
            if (this.vertices == null || this.capacity < bytes) {
               if (this.vertices != null) {
                  this.vertices.close();
               }

               this.capacity = Math.max((long)bytes, Math.max(262144L, this.capacity * 2L));
               this.vertices = device.createBuffer(() -> "Flow2 intro particles", 40, this.capacity);
            }

            this.staging.flip();
            encoder.writeToBuffer(this.vertices.slice(0L, bytes), this.staging);
            return verts;
         }
      }
   }

   private void vertex(float x, float y, float u, float v, byte r, byte g, byte b, byte a) {
      this.staging.putFloat(x).putFloat(y).putFloat(0.0F).putFloat(u).putFloat(v).put(r).put(g).put(b).put(a);
   }

   private void targets(GpuDevice device, int w, int h) {
      if (this.uniforms == null) {
         this.uniforms = device.createBuffer(() -> "Flow2 intro", 136, 400L);
      }

      if (this.scene == null || w != this.targetW || h != this.targetH) {
         this.retireTargets();
         this.scene = uok.target("intro", w, h);
         this.fx = uok.target("intro fx", w, h);
         this.emit = uok.target("intro emit", Math.max(4, w / 2), Math.max(4, h / 2));

         for (int i = 0; i < this.down.length; i++) {
            this.down[i] = uok.target("intro bloom " + i, Math.max(2, w >> i + 2), Math.max(2, h >> i + 2));
         }

         for (int i = 0; i < this.up.length; i++) {
            this.up[i] = uok.target("intro glow " + i, Math.max(2, w >> i + 2), Math.max(2, h >> i + 2));
         }

         this.targetW = w;
         this.targetH = h;
      }
   }

   private static void blit(CommandEncoder encoder, RenderPipeline pipeline, GpuTextureView in, GpuTextureView out, GpuSampler sampler) {
      RenderPass pass = encoder.createRenderPass(() -> "Flow2 intro bloom", out, OptionalInt.empty());

      try {
         pass.setPipeline(pipeline);
         pass.bindTexture("InSampler", in, sampler);
         pass.draw(0, 3);
      } catch (Throwable var9) {
         if (pass != null) {
            try {
               pass.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }
         }

         throw var9;
      }

      if (pass != null) {
         pass.close();
      }
   }

   private void retireTargets() {
      retire(this.scene);
      retire(this.fx);
      retire(this.emit);

      for (int i = 0; i < this.down.length; i++) {
         retire(this.down[i]);
         this.down[i] = null;
      }

      for (int i = 0; i < this.up.length; i++) {
         retire(this.up[i]);
         this.up[i] = null;
      }

      this.scene = this.fx = this.emit = null;
   }

   void close() {
      if (!this.closed) {
         this.closed = true;
         this.retireTargets();
         retire(this.uniforms);
         retire(this.vertices);
         retire(this.sig::close);
         this.uniforms = null;
         this.vertices = null;
         if (this.staging != null) {
            MemoryUtil.memFree(this.staging);
            this.staging = null;
         }

         loading = null;
      }
   }

   private static void retire(AutoCloseable c) {
      if (c != null) {
         RETIRED.add(c);
         RETIRED_AT.add(unf.frame());
      }
   }

   static void collect() {
      long now = unf.frame();

      for (int i = RETIRED.size() - 1; i >= 0; i--) {
         if (now - RETIRED_AT.get(i) > 3L) {
            try {
               RETIRED.remove(i).close();
            } catch (Exception var4) {
            }

            RETIRED_AT.remove(i);
         }
      }
   }

   private static RenderPipeline screen(String name, String... samplers) {
      Builder builder = RenderPipeline.builder(new Snippet[0])
         .withLocation(uvq.id("pipeline/" + name))
         .withVertexShader(uvq.id("core/blur"))
         .withFragmentShader(uvq.id("core/" + name))
         .withUniform("FlowIntro", UniformType.field_60031)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.field_60033, DrawMode.field_27379);

      for (String s : samplers) {
         builder.withSampler(s);
      }

      return builder.build();
   }

   private static float[] palette(float u) {
      float v = clamp(u, 0.0F, 1.0F) * 2.0F;
      int i = Math.min(1, (int)v);
      float f = v - i;
      return new float[]{lerp(PAL[i][0], PAL[i + 1][0], f), lerp(PAL[i][1], PAL[i + 1][1], f), lerp(PAL[i][2], PAL[i + 1][2], f)};
   }

   private static int white(float a) {
      int al = Math.max(0, Math.min(255, Math.round(a * 255.0F)));
      return al << 24 | 16777215;
   }

   private static float clamp(float v, float a, float b) {
      return v < a ? a : Math.min(v, b);
   }

   private static float lerp(float a, float b, float t) {
      return a + (b - a) * t;
   }

   private static float sine(float k) {
      return 0.5F - 0.5F * (float)Math.cos(Math.PI * clamp(k, 0.0F, 1.0F));
   }

   private static float smooth(float a, float b, float v) {
      float t = clamp((v - a) / (b - a), 0.0F, 1.0F);
      return t * t * (3.0F - 2.0F * t);
   }
}
