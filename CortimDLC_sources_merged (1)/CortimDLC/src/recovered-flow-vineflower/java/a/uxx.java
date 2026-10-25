package a;

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
import java.util.Arrays;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class uxx {
   public static final int UNIFORM_SIZE = 4288;
   public static final int BOLT_SEGMENTS = 80;
   public static final int DROPS = 16;
   private static final int uxy = 512;
   private static final int uxz = 128;
   private static @Nullable GpuBuffer uya;
   private static @Nullable GpuTexture uyb;
   private static @Nullable GpuTextureView uyc;
   private static @Nullable GpuTexture uyd;
   private static @Nullable GpuTextureView uye;
   private static @Nullable GpuTexture uyf;
   private static @Nullable GpuTextureView uyg;
   private static @Nullable GpuTexture uyh;
   private static @Nullable GpuTextureView uyi;
   private static int uyj = -1;
   private static int uyk = -1;
   private static boolean uyl;
   private static boolean uym;
   private static boolean uyn;
   private static final String[] uyo = new String[]{"sky", "wet", "rain", "grade", "drops"};
   private static final ArrayDeque<GpuQuery> uyp = new ArrayDeque<>();
   private static final ArrayDeque<Integer> uyq = new ArrayDeque<>();
   private static final long[] uyr = new long[uyo.length];
   private static long uys;
   private static int uyt;

   private uxx() {
   }

   public static boolean upload(Consumer<Std140Builder> var0) {
      uyl = false;
      if (uym) {
         return false;
      }

      Framebuffer var1 = MinecraftClient.getInstance().getFramebuffer();
      if (var1.getColorAttachmentView() != null && var1.textureWidth >= 4 && var1.textureHeight >= 4) {
         try {
            GpuDevice var2 = RenderSystem.getDevice();
            uzc(var2, var1.textureWidth, var1.textureHeight);
            MemoryStack var3 = MemoryStack.stackPush();

            try {
               Std140Builder var4 = Std140Builder.onStack(var3, 4288)
                  .putVec4(var1.textureWidth, var1.textureHeight, 1.0F / var1.textureWidth, 1.0F / var1.textureHeight);
               var0.accept(var4);
               var2.createCommandEncoder().writeToBuffer(uya.slice(), var4.get());
            } catch (Throwable var7) {
               if (var3 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var6) {
                     var7.addSuppressed(var6);
                  }
               }

               throw var7;
            }

            if (var3 != null) {
               var3.close();
            }

            uyl = true;
            if (uyn) {
               uyt++;
            }

            return true;
         } catch (Throwable var8) {
            uza("upload", var8);
            return false;
         }
      } else {
         return false;
      }
   }

   public static void sky(int var0) {
      if (uyl && uvq.ensure(uvq.STORM_PROBE) && uvq.ensure(uvq.STORM_PROBE_BLUR) && uvq.ensure(uvq.STORM_SKY) && uvq.ensure(uvq.STORM_SKY_COMPOSITE)) {
         GpuBufferSlice var1 = RenderSystem.getProjectionMatrixBuffer();
         Framebuffer var2 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var3 = var2.getColorAttachmentView();
         GpuTextureView var4 = var2.getDepthAttachmentView();
         if (var1 != null && var3 != null && var4 != null && uyi != null && var2.textureWidth == uyj && var2.textureHeight == uyk) {
            try {
               GpuDevice var5 = RenderSystem.getDevice();
               GpuTextureView var6 = vbb.noiseView(var5);
               CommandEncoder var7 = var5.createCommandEncoder();
               GpuQuery var8 = uyy(var7);

               try (RenderPass var9 = var7.createRenderPass(() -> "Flow2 storm probe", uye, OptionalInt.empty())) {
                  var9.setPipeline(uvq.STORM_PROBE);
                  var9.bindTexture("NoiseSampler", var6, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var9.setUniform("FlowStorm", uya);
                  var9.draw(0, 3);
               }

               try (RenderPass var23 = var7.createRenderPass(() -> "Flow2 storm probe blur", uyg, OptionalInt.empty())) {
                  var23.setPipeline(uvq.STORM_PROBE_BLUR);
                  var23.bindTexture("ProbeSampler", uye, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var23.setUniform("FlowStorm", uya);
                  var23.draw(0, 3);
               }

               try (RenderPass var24 = var7.createRenderPass(() -> "Flow2 storm sky", uyi, OptionalInt.empty())) {
                  var24.setPipeline(uvq.STORM_SKY);
                  var24.bindTexture("DepthSampler", var4, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var24.bindTexture("NoiseSampler", var6, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var24.setUniform("Projection", var1);
                  var24.setUniform("FlowStorm", uya);
                  var24.draw(0, 3);
               }

               try (RenderPass var25 = var7.createRenderPass(() -> "Flow2 storm sky composite", var3, OptionalInt.empty())) {
                  var25.setPipeline(uvq.STORM_SKY_COMPOSITE);
                  var25.bindTexture("DepthSampler", var4, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var25.bindTexture("HalfSampler", uyi, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var25.setUniform("Projection", var1);
                  var25.setUniform("FlowStorm", uya);
                  var25.draw(0, 3);
               }

               if (var0 > 0 && uvq.ensure(uvq.STORM_BOLT)) {
                  try (RenderPass var26 = var7.createRenderPass(() -> "Flow2 storm bolt", var3, OptionalInt.empty())) {
                     var26.setPipeline(uvq.STORM_BOLT);
                     var26.bindTexture("DepthSampler", var4, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                     var26.setUniform("Projection", var1);
                     var26.setUniform("FlowStorm", uya);
                     var26.draw(0, 6);
                  }
               }

               uyz(var7, var8, 0);
            } catch (Throwable var22) {
               uza("sky", var22);
            }
         }
      }
   }

   public static void wet(boolean var0) {
      if (uyl && uvq.ensure(uvq.STORM_WET) && uvq.ensure(uvq.BLUR_COPY)) {
         GpuBufferSlice var1 = RenderSystem.getProjectionMatrixBuffer();
         GpuBufferSlice var2 = RenderSystem.getShaderFog();
         Framebuffer var3 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var4 = var3.getColorAttachmentView();
         GpuTextureView var5 = var3.getDepthAttachmentView();
         GpuTextureView var6 = vbb.heightView();
         if (var1 != null && var2 != null && var4 != null && var5 != null && var6 != null && var3.textureWidth == uyj && var3.textureHeight == uyk) {
            try {
               GpuDevice var7 = RenderSystem.getDevice();
               CommandEncoder var8 = var7.createCommandEncoder();
               GpuQuery var9 = uyy(var8);
               uyx(var8, var4);
               GpuTextureView var10 = var0 ? vbb.terrainDepthView() : null;
               GpuTextureView var11 = var0 ? vbb.entityDepthView() : null;

               try (RenderPass var12 = var8.createRenderPass(() -> "Flow2 storm wet", var4, OptionalInt.empty())) {
                  var12.setPipeline(uvq.STORM_WET);
                  var12.bindTexture("SceneSampler", uyc, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var12.bindTexture("DepthSampler", var5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var12.bindTexture("NoiseSampler", vbb.noiseView(var7), RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var12.bindTexture("HeightSampler", var6, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var12.bindTexture("ProbeSampler", uye, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var12.bindTexture("ProbeBlurSampler", uyg, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var12.bindTexture("TerrainDepthSampler", var10 != null ? var10 : var5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var12.bindTexture("EntityDepthSampler", var11 != null ? var11 : var5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var12.setUniform("Projection", var1);
                  var12.setUniform("Fog", var2);
                  var12.setUniform("FlowStorm", uya);
                  var12.draw(0, 3);
               }

               vbb.maskUsed();
               uyz(var8, var9, 1);
            } catch (Throwable var17) {
               uza("wet", var17);
            }
         }
      }
   }

   public static void rain(int var0) {
      if (uyl && var0 > 0 && uvq.ensure(uvq.RAIN)) {
         GpuBufferSlice var1 = RenderSystem.getProjectionMatrixBuffer();
         Framebuffer var2 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var3 = var2.getColorAttachmentView();
         GpuTextureView var4 = var2.getDepthAttachmentView();
         GpuTextureView var5 = vbb.heightView();
         if (var1 != null && var3 != null && var4 != null && var5 != null) {
            try {
               CommandEncoder var6 = RenderSystem.getDevice().createCommandEncoder();
               GpuQuery var7 = uyy(var6);

               try (RenderPass var8 = var6.createRenderPass(() -> "Flow2 rain", var3, OptionalInt.empty(), var4, OptionalDouble.empty())) {
                  var8.setPipeline(uvq.RAIN);
                  var8.bindTexture("HeightSampler", var5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var8.setUniform("Projection", var1);
                  var8.setUniform("FlowStorm", uya);
                  var8.draw(0, var0 * 6);
               }

               uyz(var6, var7, 2);
            } catch (Throwable var13) {
               uza("rain", var13);
            }
         }
      }
   }

   public static void grade() {
      uyw(uvq.STORM_GRADE, "grade", 3);
   }

   public static void drops() {
      uyw(uvq.STORM_DROPS, "drops", 4);
   }

   private static void uyw(RenderPipeline var0, String var1, int var2) {
      if (uyl && uvq.ensure(var0) && uvq.ensure(uvq.BLUR_COPY)) {
         Framebuffer var3 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var4 = var3.getColorAttachmentView();
         if (var4 != null && var3.textureWidth == uyj && var3.textureHeight == uyk) {
            try {
               CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
               GpuQuery var6 = uyy(var5);
               uyx(var5, var4);

               try (RenderPass var7 = var5.createRenderPass(() -> "Flow2 storm " + var1, var4, OptionalInt.empty())) {
                  var7.setPipeline(var0);
                  var7.bindTexture("SceneSampler", uyc, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var7.setUniform("FlowStorm", uya);
                  var7.draw(0, 3);
               }

               uyz(var5, var6, var2);
            } catch (Throwable var12) {
               uza(var1, var12);
            }
         }
      }
   }

   private static void uyx(CommandEncoder var0, GpuTextureView var1) {
      try (RenderPass var2 = var0.createRenderPass(() -> "Flow2 storm scene copy", uyc, OptionalInt.empty())) {
         var2.setPipeline(uvq.BLUR_COPY);
         var2.bindTexture("InSampler", var1, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
         var2.draw(0, 3);
      }
   }

   private static @Nullable GpuQuery uyy(CommandEncoder var0) {
      return uyn ? var0.timerQueryBegin() : null;
   }

   private static void uyz(CommandEncoder var0, @Nullable GpuQuery var1, int var2) {
      if (var1 != null) {
         var0.timerQueryEnd(var1);
         uyp.add(var1);
         uyq.add(var2);
      }

      uzb();
   }

   private static void uza(String var0, Throwable var1) {
      uym = true;
      uyl = false;
      System.out.println("storm " + var0 + " failed: " + var1);
      var1.printStackTrace();
   }

   public static void timing(boolean var0) {
      uyn = var0;
      uys = 0L;
      uyt = 0;
      Arrays.fill(uyr, 0L);
   }

   public static String gpuReport() {
      uzb();
      StringBuilder var0 = new StringBuilder();
      int var1 = Math.max(1, uyt);
      var0.append(String.format(Locale.ROOT, "%.2f ms/frame", uys / 1000000.0 / var1));

      for (int var2 = 0; var2 < uyo.length; var2++) {
         var0.append(String.format(Locale.ROOT, " %s %.2f", uyo[var2], uyr[var2] / 1000000.0 / var1));
      }

      uys = 0L;
      uyt = 0;
      Arrays.fill(uyr, 0L);
      return var0.toString();
   }

   public static double gpuMillis() {
      uzb();
      double var0 = uyt == 0 ? -1.0 : uys / 1000000.0 / uyt;
      uys = 0L;
      uyt = 0;
      Arrays.fill(uyr, 0L);
      return var0;
   }

   private static void uzb() {
      while (!uyp.isEmpty()) {
         OptionalLong var0 = uyp.peek().getValue();
         if (var0.isEmpty()) {
            if (uyp.size() < 32) {
               return;
            }

            uyp.poll().close();
            uyq.poll();
         } else {
            uyp.poll().close();
            int var1 = uyq.poll();
            uys = uys + var0.getAsLong();
            uyr[var1] = uyr[var1] + var0.getAsLong();
         }
      }
   }

   public static void release() {
      if (uyc != null) {
         uyc.close();
         uyb.close();
         uyc = null;
         uyb = null;
      }

      if (uye != null) {
         uye.close();
         uyd.close();
         uye = null;
         uyd = null;
      }

      if (uyg != null) {
         uyg.close();
         uyf.close();
         uyg = null;
         uyf = null;
      }

      uzd();
      uyj = -1;
      uyk = -1;
      uyl = false;
      uym = false;
   }

   private static void uzc(GpuDevice var0, int var1, int var2) {
      if (uya == null) {
         uya = var0.createBuffer(() -> "Flow2 storm", 136, 4288L);
      }

      byte var3 = 12;
      if (uye == null) {
         uyd = var0.createTexture(() -> "Flow2 storm probe", var3, TextureFormat.RGBA8, 512, 128, 1, 1);
         uye = var0.createTextureView(uyd);
         uyf = var0.createTexture(() -> "Flow2 storm probe blur", var3, TextureFormat.RGBA8, 128, 32, 1, 1);
         uyg = var0.createTextureView(uyf);
      }

      if (uyc == null || var1 != uyj || var2 != uyk) {
         if (uyc != null) {
            uyc.close();
            uyb.close();
         }

         uzd();
         uyb = var0.createTexture(() -> "Flow2 storm scene", var3, TextureFormat.RGBA8, var1, var2, 1, 1);
         uyc = var0.createTextureView(uyb);
         uyh = var0.createTexture(() -> "Flow2 storm sky half", var3, TextureFormat.RGBA8, (var1 + 1) / 2, (var2 + 1) / 2, 1, 1);
         uyi = var0.createTextureView(uyh);
         uyj = var1;
         uyk = var2;
      }
   }

   private static void uzd() {
      if (uyi != null) {
         uyi.close();
         uyh.close();
         uyi = null;
         uyh = null;
      }
   }
}
