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
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImage.Format;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class vbb {
   public static final int UNIFORM_SIZE = 1328;
   public static final int SEASON_UNIFORM_SIZE = 1408;
   public static final int HEIGHT_SIZE = 128;
   static @Nullable GpuTexture vbc;
   static @Nullable GpuTextureView vbd;
   static @Nullable GpuTexture vbe;
   static @Nullable GpuTextureView vbf;
   static @Nullable GpuTexture vbg;
   static @Nullable GpuTextureView vbh;
   static @Nullable GpuBuffer vbi;
   static @Nullable GpuBuffer vbj;
   static @Nullable GpuTexture vbk;
   static @Nullable GpuTextureView vbl;
   static @Nullable GpuTexture vbm;
   static @Nullable GpuTextureView vbn;
   static int vbo = -1;
   static int vbp = -1;
   static int vbq = -1;
   static int vbr = -1;
   static boolean vbs;
   static boolean vbt;
   static boolean vbu;
   static boolean vbv;
   static boolean vbw;
   static final ArrayDeque<GpuQuery> vbx = new ArrayDeque<>();
   static long vby;
   static int vbz;

   vbb() {
   }

   public static boolean draw(Consumer<Std140Builder> var0) {
      return vcc(uvq.WET, false, 1328, "FlowWet", var0);
   }

   public static boolean drawSeason(Consumer<Std140Builder> var0) {
      return vcc(uvq.SEASON, true, 1408, "FlowSeason", var0);
   }

   public static @Nullable GpuTextureView heightView() {
      return vbh;
   }

   public static GpuTextureView noiseView(GpuDevice var0) {
      if (vbf == null) {
         vci(var0);
      }

      return vbf;
   }

   public static @Nullable GpuTextureView terrainDepthView() {
      return vbl;
   }

   public static @Nullable GpuTextureView entityDepthView() {
      return vbn;
   }

   public static void maskUsed() {
      vbt = false;
      vbu = false;
   }

   public static void wantEntityMask(boolean var0) {
      vbs = var0;
      if (!var0) {
         vbt = false;
         vbu = false;
      }
   }

   public static boolean entityMask() {
      Framebuffer var0 = MinecraftClient.getInstance().getFramebuffer();
      return vbt && vbu && vbn != null && vbq == var0.textureWidth && vbr == var0.textureHeight;
   }

   public static void captureDepth(boolean var0) {
      if (vbs && !vbv) {
         Framebuffer var1 = MinecraftClient.getInstance().getFramebuffer();
         GpuTexture var2 = var1.getDepthAttachment();
         if (var2 != null && var1.textureWidth >= 4 && var1.textureHeight >= 4) {
            try {
               GpuDevice var3 = RenderSystem.getDevice();
               vcf(var3, var1.textureWidth, var1.textureHeight);
               var3.createCommandEncoder().copyTextureToTexture(var2, var0 ? vbm : vbk, 0, 0, 0, 0, 0, var1.textureWidth, var1.textureHeight);
               if (var0) {
                  vbu = vbt;
               } else {
                  vbt = true;
                  vbu = false;
               }
            } catch (Throwable var4) {
               vbs = false;
               vbt = false;
               vbu = false;
               System.out.println("weather entity mask failed: " + var4);
            }
         }
      }
   }

   public static void drawParticles(int var0) {
      if (!vbv && var0 > 0 && vbj != null && uvq.ensure(uvq.SEASON_PARTICLES)) {
         GpuBufferSlice var1 = RenderSystem.getProjectionMatrixBuffer();
         Framebuffer var2 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var3 = var2.getColorAttachmentView();
         GpuTextureView var4 = var2.getDepthAttachmentView();
         if (var1 != null && var3 != null && var4 != null && vbh != null) {
            try {
               CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
               GpuQuery var6 = vbw ? var5.timerQueryBegin() : null;

               try (RenderPass var7 = var5.createRenderPass(() -> "Flow2 season particles", var3, OptionalInt.empty(), var4, OptionalDouble.empty())) {
                  var7.setPipeline(uvq.SEASON_PARTICLES);
                  var7.bindTexture("HeightSampler", vbh, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var7.setUniform("Projection", var1);
                  var7.setUniform("FlowSeason", vbj);
                  var7.draw(0, var0 * 6);
               }

               if (var6 != null) {
                  var5.timerQueryEnd(var6);
                  vbx.add(var6);
               }
            } catch (Throwable var12) {
               vbv = true;
               System.out.println("season particles failed: " + var12);
               var12.printStackTrace();
            }
         }
      }
   }

   public static void gradeSeason() {
      if (!vbv && vbj != null && vbd != null && uvq.ensure(uvq.SEASON_GRADE) && uvq.ensure(uvq.BLUR_COPY)) {
         GpuBufferSlice var0 = RenderSystem.getProjectionMatrixBuffer();
         Framebuffer var1 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var2 = var1.getColorAttachmentView();
         if (var0 != null && var2 != null && var1.textureWidth == vbo && var1.textureHeight == vbp) {
            try {
               CommandEncoder var3 = RenderSystem.getDevice().createCommandEncoder();
               GpuQuery var4 = vbw ? var3.timerQueryBegin() : null;

               try (RenderPass var5 = var3.createRenderPass(() -> "Flow2 season grade copy", vbd, OptionalInt.empty())) {
                  var5.setPipeline(uvq.BLUR_COPY);
                  var5.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var5.draw(0, 3);
               }

               try (RenderPass var13 = var3.createRenderPass(() -> "Flow2 season grade", var2, OptionalInt.empty())) {
                  var13.setPipeline(uvq.SEASON_GRADE);
                  var13.bindTexture("SceneSampler", vbd, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var13.setUniform("Projection", var0);
                  var13.setUniform("FlowSeason", vbj);
                  var13.draw(0, 3);
               }

               if (var4 != null) {
                  var3.timerQueryEnd(var4);
                  vbx.add(var4);
               }
            } catch (Throwable var12) {
               vbv = true;
               System.out.println("season grade failed: " + var12);
               var12.printStackTrace();
            }
         }
      }
   }

   static boolean vcc(RenderPipeline var0, boolean var1, int var2, String var3, Consumer<Std140Builder> var4) {
      if (!vbv && uvq.ensure(var0) && uvq.ensure(uvq.BLUR_COPY)) {
         GpuBufferSlice var5 = RenderSystem.getProjectionMatrixBuffer();
         GpuBufferSlice var6 = RenderSystem.getShaderFog();
         Framebuffer var7 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var8 = var7.getColorAttachmentView();
         GpuTextureView var9 = var7.getDepthAttachmentView();
         if (var5 != null
            && var6 != null
            && var8 != null
            && var9 != null
            && var7.getColorAttachment() != null
            && var7.textureWidth >= 4
            && var7.textureHeight >= 4) {
            try {
               GpuDevice var10 = RenderSystem.getDevice();
               vcg(var10, var7.textureWidth, var7.textureHeight);
               GpuBuffer var11 = var1 ? vbj : vbi;
               CommandEncoder var12 = var10.createCommandEncoder();
               MemoryStack var13 = MemoryStack.stackPush();

               try {
                  Std140Builder var14 = Std140Builder.onStack(var13, var2)
                     .putVec4(var7.textureWidth, var7.textureHeight, 1.0F / var7.textureWidth, 1.0F / var7.textureHeight);
                  var4.accept(var14);
                  var12.writeToBuffer(var11.slice(), var14.get());
               } catch (Throwable var21) {
                  if (var13 != null) {
                     try {
                        var13.close();
                     } catch (Throwable var19) {
                        var21.addSuppressed(var19);
                     }
                  }

                  throw var21;
               }

               if (var13 != null) {
                  var13.close();
               }

               GpuQuery var24 = vbw ? var12.timerQueryBegin() : null;

               try (RenderPass var25 = var12.createRenderPass(() -> "Flow2 weather scene copy", vbd, OptionalInt.empty())) {
                  var25.setPipeline(uvq.BLUR_COPY);
                  var25.bindTexture("InSampler", var8, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var25.draw(0, 3);
               }

               try (RenderPass var26 = var12.createRenderPass(() -> "Flow2 weather", var8, OptionalInt.empty())) {
                  var26.setPipeline(var0);
                  var26.bindTexture("SceneSampler", vbd, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var26.bindTexture("DepthSampler", var9, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var26.bindTexture("NoiseSampler", vbf, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var26.bindTexture("HeightSampler", vbh, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  if (var1) {
                     boolean var15 = entityMask();
                     var26.bindTexture("TerrainDepthSampler", var15 ? vbl : var9, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                     var26.bindTexture("EntityDepthSampler", var15 ? vbn : var9, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  }

                  var26.setUniform("Projection", var5);
                  var26.setUniform("Fog", var6);
                  var26.setUniform(var3, var11);
                  var26.draw(0, 3);
               }

               if (var1) {
                  vbt = false;
                  vbu = false;
               }

               if (var24 != null) {
                  var12.timerQueryEnd(var24);
                  vbx.add(var24);
               }

               vcd();
               return true;
            } catch (Throwable var23) {
               vbv = true;
               System.out.println("weather pass failed: " + var23);
               var23.printStackTrace();
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static void timing(boolean var0) {
      vbw = var0;
      vby = 0L;
      vbz = 0;
   }

   public static double gpuMillis() {
      vcd();
      double var0 = vbz == 0 ? -1.0 : vby / 1000000.0 / vbz;
      vby = 0L;
      vbz = 0;
      return var0;
   }

   static void vcd() {
      while (!vbx.isEmpty()) {
         OptionalLong var0 = vbx.peek().getValue();
         if (var0.isEmpty()) {
            if (vbx.size() < 8) {
               return;
            }

            vbx.poll().close();
         } else {
            vbx.poll().close();
            vby = vby + var0.getAsLong();
            vbz++;
         }
      }
   }

   public static void uploadHeights(int[] var0) {
      if (!vbv) {
         try {
            GpuDevice var1 = RenderSystem.getDevice();
            vch(var1);

            try (NativeImage var2 = new NativeImage(Format.RGBA, 128, 128, false)) {
               for (int var3 = 0; var3 < 128; var3++) {
                  for (int var4 = 0; var4 < 128; var4++) {
                     var2.setColorArgb(var4, var3, var0[var3 * 128 + var4]);
                  }
               }

               var1.createCommandEncoder().writeToTexture(vbg, var2);
            }
         } catch (Throwable var7) {
            vbv = true;
            System.out.println("weather heights failed: " + var7);
         }
      }
   }

   public static void release() {
      if (vbd != null) {
         vbd.close();
         vbd = null;
      }

      if (vbc != null) {
         vbc.close();
         vbc = null;
      }

      vce();
      vbo = -1;
      vbp = -1;
      vbs = false;
      vbt = false;
      vbu = false;
      vbv = false;
   }

   static void vce() {
      if (vbl != null) {
         vbl.close();
         vbk.close();
         vbl = null;
         vbk = null;
      }

      if (vbn != null) {
         vbn.close();
         vbm.close();
         vbn = null;
         vbm = null;
      }

      vbq = -1;
      vbr = -1;
   }

   static void vcf(GpuDevice var0, int var1, int var2) {
      if (vbl == null || var1 != vbq || var2 != vbr) {
         vce();
         byte var3 = 5;
         vbk = var0.createTexture(() -> "Flow2 weather terrain depth", var3, TextureFormat.DEPTH32, var1, var2, 1, 1);
         vbl = var0.createTextureView(vbk);
         vbm = var0.createTexture(() -> "Flow2 weather entity depth", var3, TextureFormat.DEPTH32, var1, var2, 1, 1);
         vbn = var0.createTextureView(vbm);
         vbq = var1;
         vbr = var2;
      }
   }

   static void vcg(GpuDevice var0, int var1, int var2) {
      if (vbi == null) {
         vbi = var0.createBuffer(() -> "Flow2 wet", 136, 1328L);
      }

      if (vbj == null) {
         vbj = var0.createBuffer(() -> "Flow2 season", 136, 1408L);
      }

      if (vbf == null) {
         vci(var0);
      }

      vch(var0);
      if (vbd == null || var1 != vbo || var2 != vbp) {
         if (vbd != null) {
            vbd.close();
            vbc.close();
         }

         byte var3 = 12;
         vbc = var0.createTexture(() -> "Flow2 weather scene", var3, TextureFormat.RGBA8, var1, var2, 1, 1);
         vbd = var0.createTextureView(vbc);
         vbo = var1;
         vbp = var2;
      }
   }

   static void vch(GpuDevice var0) {
      if (vbh == null) {
         byte var1 = 5;
         vbg = var0.createTexture(() -> "Flow2 weather heights", var1, TextureFormat.RGBA8, 128, 128, 1, 1);
         vbh = var0.createTextureView(vbg);
      }
   }

   static void vci(GpuDevice var0) {
      Random var1 = new Random(65532160L);

      try (NativeImage var2 = new NativeImage(Format.RGBA, 256, 256, false)) {
         for (int var3 = 0; var3 < 256; var3++) {
            for (int var4 = 0; var4 < 256; var4++) {
               var2.setColorArgb(var4, var3, var1.nextInt());
            }
         }

         byte var7 = 5;
         vbe = var0.createTexture(() -> "Flow2 weather noise", var7, TextureFormat.RGBA8, 256, 256, 1, 1);
         vbf = var0.createTextureView(vbe);
         var0.createCommandEncoder().writeToTexture(vbe, var2);
      }
   }
}
