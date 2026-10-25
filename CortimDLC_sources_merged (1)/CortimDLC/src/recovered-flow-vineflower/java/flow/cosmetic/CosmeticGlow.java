package flow.cosmetic;

import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
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
import org.joml.Quaternionf;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

final class CosmeticGlow {
   static final int VERTEX = 24;
   private static final int LEVELS = 5;
   private static final int UNIFORM_SIZE = 80;
   private static final RenderPipeline MASK = RenderPipeline.builder()
      .withLocation(uvq.id("pipeline/cos_glow"))
      .withVertexShader(uvq.id("core/cos_glow"))
      .withFragmentShader(uvq.id("core/cos_glow"))
      .withSampler("Sampler0")
      .withUniform("Projection", UniformType.UNIFORM_BUFFER)
      .withUniform("FlowGlow", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.ADDITIVE)
      .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
      .withDepthWrite(false)
      .withDepthBias(-1.0F, -4.0F)
      .withCull(false)
      .withVertexFormat(VertexFormats.POSITION_TEXTURE_COLOR, DrawMode.TRIANGLES)
      .build();
   private static final RenderPipeline DOWN = screen("fx_down", null, false, "InSampler");
   private static final RenderPipeline UP = screen("cos_up", null, false, "InSampler", "BaseSampler");
   private static final RenderPipeline COMPOSITE = screen("cos_bloom", BlendFunction.ADDITIVE, true, "InSampler");
   private static final List<CosmeticGlow.Batch> BATCHES = new ArrayList<>();
   private static ByteBuffer staging;
   private static int vertices;
   private static GpuBuffer buffer;
   private static long capacity;
   private static GpuBuffer uniforms;
   private static GpuTexture mask;
   private static GpuTextureView maskView;
   private static final GpuTexture[] DOWN_TEX = new GpuTexture[5];
   private static final GpuTextureView[] DOWN_VIEW = new GpuTextureView[5];
   private static final GpuTexture[] UP_TEX = new GpuTexture[4];
   private static final GpuTextureView[] UP_VIEW = new GpuTextureView[4];
   private static int width = -1;
   private static int height = -1;
   private static boolean failed;

   private CosmeticGlow() {
   }

   private static RenderPipeline screen(String fragment, BlendFunction blend, boolean uniform, String... samplers) {
      Builder b = RenderPipeline.builder()
         .withLocation(uvq.id("pipeline/cos_" + fragment))
         .withVertexShader(uvq.id("core/blur"))
         .withFragmentShader(uvq.id("core/" + fragment))
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES);

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
         staging = MemoryUtil.memAlloc(Math.max(need, 262144));
      } else if (staging.capacity() < need) {
         ByteBuffer grown = MemoryUtil.memRealloc(staging, Math.max(need, staging.capacity() * 2));
         grown.position(vertices * 24);
         staging = grown;
      }

      staging.limit(staging.capacity());
      staging.position(vertices * 24);
      return staging;
   }

   static void commit(Identifier texture, int count) {
      if (count > 0 && texture != null) {
         CosmeticGlow.Batch last = BATCHES.isEmpty() ? null : BATCHES.get(BATCHES.size() - 1);
         if (last != null && last.texture.equals(texture) && last.first + last.count == vertices) {
            BATCHES.set(BATCHES.size() - 1, new CosmeticGlow.Batch(texture, last.first, last.count + count));
         } else {
            BATCHES.add(new CosmeticGlow.Batch(texture, vertices, count));
         }

         vertices += count;
      }
   }

   static void add(CosmeticItem item, Matrix4f[] bones, Matrix4f pose, int argb, int frame, int part, boolean blink) {
      if (item.emissive != null) {
         ByteBuffer out = reserve(CosmeticMesh.glowVertices(item));
         commit(item.emissive, CosmeticMesh.glow(item, bones, pose, out, argb, frame, part, blink));
      }
   }

   static void flush() {
      if (!failed && vertices != 0 && !BATCHES.isEmpty()) {
         MinecraftClient mc = MinecraftClient.getInstance();

         try {
            if (!uvq.ensure(MASK) || !uvq.ensure(DOWN) || !uvq.ensure(UP) || !uvq.ensure(COMPOSITE)) {
               return;
            }

            GpuBufferSlice projection = RenderSystem.getProjectionMatrixBuffer();
            Framebuffer fb = mc.getFramebuffer();
            GpuTextureView color = fb.getColorAttachmentView();
            GpuTextureView depth = fb.getDepthAttachmentView();
            if (projection != null && color != null && depth != null && fb.textureWidth >= 8 && fb.textureHeight >= 8) {
               int bytes = vertices * 24;
               ByteBuffer data = staging.duplicate();
               data.position(0).limit(bytes);
               GpuDevice device = RenderSystem.getDevice();
               ensure(device, fb.textureWidth, fb.textureHeight, bytes);
               CommandEncoder encoder = device.createCommandEncoder();
               encoder.writeToBuffer(buffer.slice(0L, bytes), data);
               Camera camera = mc.gameRenderer.getCamera();
               Matrix4f view = new Matrix4f().rotation(camera.getRotation().conjugate(new Quaternionf()));
               float strength = (float)Cosmetics.GLOW.get();
               MemoryStack stack = MemoryStack.stackPush();

               try {
                  encoder.writeToBuffer(
                     uniforms.slice(), Std140Builder.onStack(stack, 80).putMat4f(view).putVec4(strength, fb.textureWidth, fb.textureHeight, 0.0F).get()
                  );
               } catch (Throwable var30) {
                  if (stack != null) {
                     try {
                        stack.close();
                     } catch (Throwable var27) {
                        var30.addSuppressed(var27);
                     }
                  }

                  throw var30;
               }

               if (stack != null) {
                  stack.close();
               }

               try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 cosmetic glow", maskView, OptionalInt.of(0), depth, OptionalDouble.empty())) {
                  pass.setPipeline(MASK);
                  pass.setUniform("Projection", projection);
                  pass.setUniform("FlowGlow", uniforms);
                  pass.setVertexBuffer(0, buffer);

                  for (CosmeticGlow.Batch b : BATCHES) {
                     GpuTextureView tex = texture(mc, b.texture);
                     if (tex != null) {
                        pass.bindTexture("Sampler0", tex, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                        pass.draw(b.first, b.count);
                     }
                  }
               }

               GpuTextureView last = maskView;

               for (int i = 0; i < 5; i++) {
                  blur(encoder, DOWN, last, null, DOWN_VIEW[i]);
                  last = DOWN_VIEW[i];
               }

               for (int i = 3; i >= 0; i--) {
                  blur(encoder, UP, last, DOWN_VIEW[i], UP_VIEW[i]);
                  last = UP_VIEW[i];
               }

               try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 cosmetic bloom", color, OptionalInt.empty())) {
                  pass.setPipeline(COMPOSITE);
                  pass.bindTexture("InSampler", last, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  pass.setUniform("FlowGlow", uniforms);
                  pass.draw(0, 3);
                  return;
               }
            }
         } catch (Throwable t) {
            failed = true;
            System.out.println("cosmetic glow failed, turned off: " + t);
            return;
         } finally {
            begin();
         }
      } else {
         begin();
      }
   }

   private static GpuTextureView texture(MinecraftClient mc, Identifier id) {
      AbstractTexture t = mc.getTextureManager().getTexture(id);
      return t == null ? null : t.getGlTextureView();
   }

   private static void blur(CommandEncoder encoder, RenderPipeline pipeline, GpuTextureView in, GpuTextureView base, GpuTextureView out) {
      try (RenderPass pass = encoder.createRenderPass(() -> "Flow2 cosmetic bloom blur", out, OptionalInt.empty())) {
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

      if (buffer == null || capacity < bytes) {
         if (buffer != null) {
            buffer.close();
         }

         capacity = Math.max(bytes, Math.max(262144L, capacity * 2L));
         buffer = device.createBuffer(() -> "Flow2 cosmetic glow vertices", 40, capacity);
      }

      if (maskView == null || w != width || h != height) {
         release();
         int usage = 12;
         mask = device.createTexture(() -> "Flow2 cosmetic glow mask", usage, TextureFormat.RGBA8, w, h, 1, 1);
         maskView = device.createTextureView(mask);

         for (int i = 0; i < 5; i++) {
            int div = 2 << i;
            int level = i;
            DOWN_TEX[i] = device.createTexture(
               () -> "Flow2 cosmetic glow down " + level, usage, TextureFormat.RGBA8, Math.max(1, w / div), Math.max(1, h / div), 1, 1
            );
            DOWN_VIEW[i] = device.createTextureView(DOWN_TEX[i]);
            if (i < 4) {
               UP_TEX[i] = device.createTexture(
                  () -> "Flow2 cosmetic glow up " + level, usage, TextureFormat.RGBA8, Math.max(1, w / div), Math.max(1, h / div), 1, 1
               );
               UP_VIEW[i] = device.createTextureView(UP_TEX[i]);
            }
         }

         width = w;
         height = h;
      }
   }

   private static void release() {
      if (maskView != null) {
         maskView.close();
         mask.close();
         maskView = null;
         mask = null;
      }

      for (int i = 0; i < 5; i++) {
         if (DOWN_VIEW[i] != null) {
            DOWN_VIEW[i].close();
            DOWN_TEX[i].close();
            DOWN_VIEW[i] = null;
            DOWN_TEX[i] = null;
         }

         if (i < 4 && UP_VIEW[i] != null) {
            UP_VIEW[i].close();
            UP_TEX[i].close();
            UP_VIEW[i] = null;
            UP_TEX[i] = null;
         }
      }

      width = -1;
      height = -1;
   }

   private record Batch(Identifier texture, int first, int count) {
   }
}
