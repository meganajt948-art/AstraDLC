package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.joml.Matrix4f;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

public final class uwt {
   public static final int VERTEX_SIZE = 28;
   public static final int MAX_BATCHES = 8;
   private static final int uwu = 128;
   private static final GpuBuffer[] uwv = new GpuBuffer[8];
   private static @Nullable GpuBuffer uww;
   private static long uwx;
   private static @Nullable ByteBuffer uwy;
   private static @Nullable GpuTexture uwz;
   private static @Nullable GpuTextureView uxa;
   private static int uxb = -1;
   private static int uxc = -1;
   private static boolean uxd;

   private uwt() {
   }

   public static ByteBuffer staging(int var0) {
      int var1 = Math.max(1, var0) * 28;
      if (uwy == null) {
         uwy = MemoryUtil.memAlloc(Math.max(var1, 65536));
      } else if (uwy.capacity() < var1) {
         uwy = MemoryUtil.memRealloc(uwy, Math.max(var1, uwy.capacity() * 2));
      }

      uwy.clear();
      return uwy;
   }

   public static boolean draw(Matrix4f var0, float var1, float var2, float var3, float var4, List<uwg> var5, ByteBuffer var6) {
      if (!uxd && !var5.isEmpty() && uvq.ensure(uvq.SHATTER_BACK) && uvq.ensure(uvq.SHATTER_FRONT) && uvq.ensure(uvq.BLUR_COPY)) {
         GpuBufferSlice var7 = RenderSystem.getProjectionMatrixBuffer();
         Framebuffer var8 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var9 = var8.getColorAttachmentView();
         GpuTextureView var10 = var8.getDepthAttachmentView();
         if (var7 != null && var9 != null && var10 != null && var8.textureWidth >= 4 && var8.textureHeight >= 4) {
            int var11 = var6.position();
            if (var11 <= 0) {
               return false;
            }

            var6.flip();

            try {
               GpuDevice var12 = RenderSystem.getDevice();
               uxh(var12, var8.textureWidth, var8.textureHeight, var11);
               CommandEncoder var13 = var12.createCommandEncoder();
               var13.writeToBuffer(uww.slice(0L, var11), var6);
               int var14 = Math.min(var5.size(), 8);
               float var15 = var8.textureWidth;
               float var16 = var8.textureHeight;
               MemoryStack var17 = MemoryStack.stackPush();

               try {
                  for (int var18 = 0; var18 < var14; var18++) {
                     uwg var19 = (uwg)var5.get(var18);
                     var13.writeToBuffer(
                        uwv[var18].slice(),
                        Std140Builder.onStack(var17, 128)
                           .putMat4f(var0)
                           .putVec4(var15, var16, 1.0F / var15, 1.0F / var16)
                           .putVec4(var19.r(), var19.g(), var19.b(), var19.a())
                           .putVec4(var1, var2, var3, var4)
                           .putVec4(var19.scan(), var19.sweep(), var19.flash(), var19.broken())
                           .get()
                     );
                  }
               } catch (Throwable var23) {
                  if (var17 != null) {
                     try {
                        var17.close();
                     } catch (Throwable var21) {
                        var23.addSuppressed(var21);
                     }
                  }

                  throw var23;
               }

               if (var17 != null) {
                  var17.close();
               }

               try (RenderPass var25 = var13.createRenderPass(() -> "Flow2 shatter scene copy", uxa, OptionalInt.empty())) {
                  var25.setPipeline(uvq.BLUR_COPY);
                  var25.bindTexture("InSampler", var9, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var25.draw(0, 3);
               }

               uxg(var13, uvq.SHATTER_BACK, var9, var10, var7, var5, var14);
               uxg(var13, uvq.SHATTER_FRONT, var9, var10, var7, var5, var14);
               return true;
            } catch (Throwable var24) {
               uxd = true;
               System.out.println("shatter pass failed: " + var24);
               var24.printStackTrace();
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void uxg(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3, GpuBufferSlice var4, List<uwg> var5, int var6) {
      try (RenderPass var7 = var0.createRenderPass(() -> "Flow2 shatter", var2, OptionalInt.empty(), var3, OptionalDouble.empty())) {
         var7.setPipeline(var1);
         var7.bindTexture("SceneSampler", uxa, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
         var7.setUniform("Projection", var4);
         var7.setVertexBuffer(0, uww);

         for (int var8 = 0; var8 < var6; var8++) {
            uwg var9 = (uwg)var5.get(var8);
            if (var9.count() > 0) {
               var7.setUniform("FlowShatter", uwv[var8]);
               var7.draw(var9.first(), var9.count());
            }
         }
      }
   }

   private static void uxh(GpuDevice var0, int var1, int var2, int var3) {
      for (int var4 = 0; var4 < 8; var4++) {
         if (uwv[var4] == null) {
            int var5 = var4;
            uwv[var4] = var0.createBuffer(() -> "Flow2 shatter " + var5, 136, 128L);
         }
      }

      if (uww == null || uwx < var3) {
         if (uww != null) {
            uww.close();
         }

         uwx = Math.max(var3, Math.max(262144L, uwx * 2L));
         uww = var0.createBuffer(() -> "Flow2 shatter vertices", 40, uwx);
      }

      if (uxa == null || var1 != uxb || var2 != uxc) {
         if (uxa != null) {
            uxa.close();
            uwz.close();
         }

         byte var6 = 12;
         uwz = var0.createTexture(() -> "Flow2 shatter scene", var6, TextureFormat.RGBA8, var1, var2, 1, 1);
         uxa = var0.createTextureView(uwz);
         uxb = var1;
         uxc = var2;
      }
   }

   public static void release() {
      if (uxa != null) {
         uxa.close();
         uwz.close();
         uxa = null;
         uwz = null;
      }

      if (uww != null) {
         uww.close();
         uww = null;
         uwx = 0L;
      }

      for (int var0 = 0; var0 < 8; var0++) {
         if (uwv[var0] != null) {
            uwv[var0].close();
            uwv[var0] = null;
         }
      }

      if (uwy != null) {
         MemoryUtil.memFree(uwy);
         uwy = null;
      }

      uxb = -1;
      uxc = -1;
      uxd = false;
   }
}
