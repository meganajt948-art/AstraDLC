package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.GpuQuery;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayDeque;
import java.util.OptionalInt;
import java.util.OptionalLong;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.joml.Matrix4f;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class uxi {
   static final int uxj = 128;
   static @Nullable GpuBuffer uxk;
   static boolean uxl;
   static boolean uxm;
   static final ArrayDeque<GpuQuery> uxn = new ArrayDeque<>();
   static long uxo;
   static int uxp;

   uxi() {
   }

   public static boolean draw(Matrix4f var0, uxt var1, float var2, float var3, float var4, int var5, int var6, int var7, float var8) {
      if (!uxl && uvq.ensure(uvq.SKY)) {
         GpuBufferSlice var9 = RenderSystem.getProjectionMatrixBuffer();
         GpuBufferSlice var10 = RenderSystem.getShaderFog();
         Framebuffer var11 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var12 = var11.getColorAttachmentView();
         GpuTextureView var13 = var11.getDepthAttachmentView();
         if (var9 != null && var10 != null && var12 != null && var13 != null && var11.textureWidth >= 4 && var11.textureHeight >= 4) {
            try {
               GpuDevice var14 = RenderSystem.getDevice();
               if (uxk == null) {
                  uxk = var14.createBuffer(() -> "Flow2 sky", 136, 128L);
               }

               CommandEncoder var15 = var14.createCommandEncoder();
               MemoryStack var16 = MemoryStack.stackPush();

               try {
                  var15.writeToBuffer(
                     uxk.slice(),
                     Std140Builder.onStack(var16, 128)
                        .putVec4(var11.textureWidth, var11.textureHeight, 1.0F / var11.textureWidth, 1.0F / var11.textureHeight)
                        .putMat4f(var0)
                        .putVec4(var1.id(), var2, var3, var4)
                        .putVec4(r(var5), g(var5), b(var5), var7)
                        .putVec4(r(var6), g(var6), b(var6), var8)
                        .get()
                  );
               } catch (Throwable var23) {
                  if (var16 != null) {
                     try {
                        var16.close();
                     } catch (Throwable var21) {
                        var23.addSuppressed(var21);
                     }
                  }

                  throw var23;
               }

               if (var16 != null) {
                  var16.close();
               }

               GpuQuery var25 = uxm ? var15.timerQueryBegin() : null;

               try (RenderPass var17 = var15.createRenderPass(() -> "Flow2 sky", var12, OptionalInt.empty())) {
                  var17.setPipeline(uvq.SKY);
                  var17.bindTexture("DepthSampler", var13, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var17.setUniform("Projection", var9);
                  var17.setUniform("Fog", var10);
                  var17.setUniform("FlowSky", uxk);
                  var17.draw(0, 3);
               }

               if (var25 != null) {
                  var15.timerQueryEnd(var25);
                  uxn.add(var25);
               }

               uxs();
               return true;
            } catch (Throwable var24) {
               uxl = true;
               System.out.println("shader sky failed: " + var24);
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

   public static void timing(boolean var0) {
      uxm = var0;
      uxo = 0L;
      uxp = 0;
   }

   public static double gpuMillis() {
      uxs();
      double var0 = uxp == 0 ? -1.0 : uxo / 1000000.0 / uxp;
      uxo = 0L;
      uxp = 0;
      return var0;
   }

   static void uxs() {
      while (!uxn.isEmpty()) {
         OptionalLong var0 = uxn.peek().getValue();
         if (var0.isEmpty()) {
            if (uxn.size() < 8) {
               return;
            }

            uxn.poll().close();
         } else {
            uxn.poll().close();
            uxo = uxo + var0.getAsLong();
            uxp++;
         }
      }
   }

   public static void release() {
      uxl = false;
   }

   static float r(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   static float g(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   static float b(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }
}
