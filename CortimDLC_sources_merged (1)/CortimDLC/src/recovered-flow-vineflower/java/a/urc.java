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
import java.util.OptionalInt;
import java.util.OptionalLong;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.joml.Matrix4f;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class urc {
   private static final int urd = 176;
   @Nullable
   private static GpuTexture ure;
   @Nullable
   private static GpuTextureView urf;
   @Nullable
   private static GpuBuffer urg;
   private static int urh = -1;
   private static int uri = -1;
   private static boolean urj;
   private static boolean urk;
   private static final ArrayDeque<GpuQuery> url = new ArrayDeque<>();
   private static long urm;
   private static int urn;

   private urc() {
   }

   public static boolean draw(Matrix4f var0, Matrix4f var1, float var2, float var3, float var4, float var5, int var6, float var7) {
      if (!urj && uvq.ensure(uvq.MOTION) && uvq.ensure(uvq.MOTION_FINE)) {
         GpuBufferSlice var8 = RenderSystem.getProjectionMatrixBuffer();
         Framebuffer var9 = MinecraftClient.method_1551().method_1522();
         GpuTextureView var10 = var9.method_71639();
         GpuTextureView var11 = var9.method_71640();
         if (var8 != null && var10 != null && var11 != null && var9.field_1482 >= 4 && var9.field_1481 >= 4) {
            try {
               GpuDevice var12 = RenderSystem.getDevice();
               urs(var12, var9.field_1482, var9.field_1481);
               CommandEncoder var13 = var12.createCommandEncoder();
               MemoryStack var14 = MemoryStack.stackPush();

               try {
                  var13.writeToBuffer(
                     urg.slice(),
                     Std140Builder.onStack(var14, 176)
                        .putVec4(var9.field_1482, var9.field_1481, 1.0F / var9.field_1482, 1.0F / var9.field_1481)
                        .putMat4f(var0)
                        .putMat4f(var1)
                        .putVec4(var2, var3, var4, 0.0F)
                        .putVec4(var5 * var9.field_1482, var6, var7, 0.0F)
                        .get()
                  );
               } catch (Throwable var18) {
                  if (var14 != null) {
                     try {
                        var14.close();
                     } catch (Throwable var17) {
                        var18.addSuppressed(var17);
                     }
                  }

                  throw var18;
               }

               if (var14 != null) {
                  var14.close();
               }

               GpuQuery var20 = urk ? var13.timerQueryBegin() : null;
               urq(var13, uvq.MOTION, var10, urf, var11, var8);
               urq(var13, uvq.MOTION_FINE, urf, var10, var11, var8);
               if (var20 != null) {
                  var13.timerQueryEnd(var20);
                  url.add(var20);
               }

               urr();
               return true;
            } catch (Throwable var19) {
               urj = true;
               System.out.println("motion blur failed: " + var19);
               var19.printStackTrace();
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void urq(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3, GpuTextureView var4, GpuBufferSlice var5) {
      RenderPass var6 = var0.createRenderPass(() -> "Flow2 motion blur", var3, OptionalInt.empty());

      try {
         var6.setPipeline(var1);
         var6.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
         var6.bindTexture("DepthSampler", var4, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
         var6.setUniform("Projection", var5);
         var6.setUniform("FlowMotion", urg);
         var6.draw(0, 3);
      } catch (Throwable var10) {
         if (var6 != null) {
            try {
               var6.close();
            } catch (Throwable var9) {
               var10.addSuppressed(var9);
            }
         }

         throw var10;
      }

      if (var6 != null) {
         var6.close();
      }
   }

   public static void timing(boolean var0) {
      urk = var0;
      urm = 0L;
      urn = 0;
   }

   public static double gpuMillis() {
      urr();
      double var0 = urn == 0 ? -1.0 : urm / 1000000.0 / urn;
      urm = 0L;
      urn = 0;
      return var0;
   }

   private static void urr() {
      while (!url.isEmpty()) {
         OptionalLong var0 = url.peek().getValue();
         if (var0.isEmpty()) {
            if (url.size() < 8) {
               return;
            }

            url.poll().close();
         } else {
            url.poll().close();
            urm = urm + var0.getAsLong();
            urn++;
         }
      }
   }

   public static void release() {
      if (urf != null) {
         urf.close();
         urf = null;
      }

      if (ure != null) {
         ure.close();
         ure = null;
      }

      urh = -1;
      uri = -1;
      urj = false;
   }

   private static void urs(GpuDevice var0, int var1, int var2) {
      if (urg == null) {
         urg = var0.createBuffer(() -> "Flow2 motion blur", 136, 176L);
      }

      if (urf == null || var1 != urh || var2 != uri) {
         release();
         byte var3 = 12;
         ure = var0.createTexture(() -> "Flow2 motion blur", var3, TextureFormat.RGBA8, var1, var2, 1, 1);
         urf = var0.createTextureView(ure);
         urh = var1;
         uri = var2;
      }
   }
}
