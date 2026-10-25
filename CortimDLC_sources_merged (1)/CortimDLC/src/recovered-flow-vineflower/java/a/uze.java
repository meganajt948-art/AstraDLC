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
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.ArrayDeque;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class uze {
   public static final int UNIFORM_SIZE = 368;
   private static final int uzf = 528;
   private static @Nullable GpuTexture uzg;
   private static @Nullable GpuTextureView uzh;
   private static @Nullable GpuTexture uzi;
   private static @Nullable GpuTextureView uzj;
   private static boolean uzk;
   private static final GpuTexture[] uzl = new GpuTexture[4];
   private static final GpuTextureView[] uzm = new GpuTextureView[4];
   private static int uzn = -1;
   private static int uzo = -1;
   private static @Nullable GpuBuffer uzp;
   private static int uzq = -1;
   private static int uzr = -1;
   private static int uzs = 2;
   private static boolean uzt;
   private static int uzu;
   private static boolean uzv;
   private static boolean uzw;
   private static final ArrayDeque<GpuQuery> uzx = new ArrayDeque<>();
   private static long uzy;
   private static int uzz;

   private uze() {
   }

   public static boolean draw(float var0, float var1, boolean var2, float var3, float var4, Consumer<Std140Builder> var5) {
      if (!uzv
         && uvq.ensure(uvq.CLOUD_NOISE)
         && uvq.ensure(uvq.CLOUD_W)
         && uvq.ensure(uvq.CLOUD_MARCH)
         && uvq.ensure(uvq.CLOUD_RESOLVE)
         && uvq.ensure(uvq.CLOUD_RAYS)
         && uvq.ensure(uvq.CLOUD_COMPOSITE)) {
         GpuBufferSlice var6 = RenderSystem.getProjectionMatrixBuffer();
         GpuBufferSlice var7 = RenderSystem.getShaderFog();
         Framebuffer var8 = MinecraftClient.getInstance().getFramebuffer();
         GpuTextureView var9 = var8.getColorAttachmentView();
         GpuTextureView var10 = var8.getDepthAttachmentView();
         GpuTextureView var11 = vbb.heightView();
         if (var6 != null && var7 != null && var9 != null && var10 != null && var11 != null && var8.textureWidth >= 4 && var8.textureHeight >= 4) {
            try {
               int var12 = Math.max(1, Math.round(var8.textureWidth * var0));
               int var13 = Math.max(1, Math.round(var8.textureHeight * var0));
               GpuDevice var14 = RenderSystem.getDevice();
               vae(var14, var12, var13, var8.textureWidth, var8.textureHeight);
               CommandEncoder var15 = var14.createCommandEncoder();
               if (!uzk) {
                  try (RenderPass var16 = var15.createRenderPass(() -> "Flow2 cloud noise", uzh, OptionalInt.empty())) {
                     var16.setPipeline(uvq.CLOUD_NOISE);
                     var16.draw(0, 3);
                  }

                  try (RenderPass var40 = var15.createRenderPass(() -> "Flow2 cloud weather", uzj, OptionalInt.empty())) {
                     var40.setPipeline(uvq.CLOUD_W);
                     var40.draw(0, 3);
                  }

                  uzk = true;
               }

               uzu = uzu + 1 & 1023;
               boolean var41 = uzt && var2;
               MemoryStack var17 = MemoryStack.stackPush();

               try {
                  Std140Builder var18 = Std140Builder.onStack(var17, 368)
                     .putVec4(var12, var13, var8.textureWidth, var8.textureHeight)
                     .putVec4(uzu, var41 ? 1.0F : 0.0F, var3, var4);
                  var5.accept(var18);
                  var18.putVec4(vad(uzu & 15, 2), vad(uzu & 15, 3), var1, 0.0F);
                  var15.writeToBuffer(uzp.slice(), var18.get());
               } catch (Throwable var36) {
                  if (var17 != null) {
                     try {
                        var17.close();
                     } catch (Throwable var29) {
                        var36.addSuppressed(var29);
                     }
                  }

                  throw var36;
               }

               if (var17 != null) {
                  var17.close();
               }

               GpuTextureView var42 = uzm[0];
               GpuTextureView var43 = uzm[1];
               GpuTextureView var19 = uzm[uzs];
               GpuTextureView var20 = uzm[5 - uzs];
               GpuQuery var21 = uzw ? var15.timerQueryBegin() : null;

               try (RenderPass var22 = var15.createRenderPass(() -> "Flow2 cloud march", var42, OptionalInt.empty())) {
                  var22.setPipeline(uvq.CLOUD_MARCH);
                  var22.bindTexture("DepthSampler", var10, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var22.bindTexture("CloudNoise", uzh, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var22.bindTexture("CloudW", uzj, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var22.bindTexture("HeightSampler", var11, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var22.setUniform("Projection", var6);
                  var22.setUniform("Fog", var7);
                  var22.setUniform("FlowCloud", uzp);
                  var22.draw(0, 3);
               }

               try (RenderPass var44 = var15.createRenderPass(() -> "Flow2 cloud resolve", var20, OptionalInt.empty())) {
                  var44.setPipeline(uvq.CLOUD_RESOLVE);
                  var44.bindTexture("RawSampler", var42, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var44.bindTexture("HistorySampler", var19, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var44.bindTexture("DepthSampler", var10, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var44.setUniform("Projection", var6);
                  var44.setUniform("FlowCloud", uzp);
                  var44.draw(0, 3);
               }

               try (RenderPass var45 = var15.createRenderPass(() -> "Flow2 sun rays", var43, OptionalInt.empty())) {
                  var45.setPipeline(uvq.CLOUD_RAYS);
                  var45.bindTexture("CloudSampler", var20, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var45.bindTexture("DepthSampler", var10, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var45.setUniform("Projection", var6);
                  var45.setUniform("FlowCloud", uzp);
                  var45.draw(0, 3);
               }

               try (RenderPass var46 = var15.createRenderPass(() -> "Flow2 cloud composite", var9, OptionalInt.empty())) {
                  var46.setPipeline(uvq.CLOUD_COMPOSITE);
                  var46.bindTexture("CloudSampler", var20, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var46.bindTexture("RaysSampler", var43, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var46.bindTexture("DepthSampler", var10, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var46.bindTexture("CloudNoise", uzh, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var46.bindTexture("CloudW", uzj, RenderSystem.getSamplerCache().getRepeated(FilterMode.LINEAR));
                  var46.bindTexture("HeightSampler", var11, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                  var46.setUniform("Projection", var6);
                  var46.setUniform("FlowCloud", uzp);
                  var46.draw(0, 3);
               }

               if (var21 != null) {
                  var15.timerQueryEnd(var21);
                  uzx.add(var21);
               }

               uzs = 5 - uzs;
               uzt = true;
               vac();
               return true;
            } catch (Throwable var39) {
               uzv = true;
               System.out.println("summer sky failed: " + var39);
               var39.printStackTrace();
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
      uzw = var0;
      uzy = 0L;
      uzz = 0;
   }

   public static double gpuMillis() {
      vac();
      double var0 = uzz == 0 ? -1.0 : uzy / 1000000.0 / uzz;
      uzy = 0L;
      uzz = 0;
      return var0;
   }

   private static void vac() {
      while (!uzx.isEmpty()) {
         OptionalLong var0 = uzx.peek().getValue();
         if (var0.isEmpty()) {
            if (uzx.size() < 8) {
               return;
            }

            uzx.poll().close();
         } else {
            uzx.poll().close();
            uzy = uzy + var0.getAsLong();
            uzz++;
         }
      }
   }

   public static void release() {
      for (int var0 = 0; var0 < uzm.length; var0++) {
         if (uzm[var0] != null) {
            uzm[var0].close();
            uzm[var0] = null;
         }

         if (uzl[var0] != null) {
            uzl[var0].close();
            uzl[var0] = null;
         }
      }

      uzq = -1;
      uzr = -1;
      uzn = -1;
      uzo = -1;
      uzt = false;
      uzv = false;
   }

   private static float vad(int var0, int var1) {
      float var2 = 1.0F;
      float var3 = 0.0F;
      int var4 = var0 + 1;

      while (var4 > 0) {
         var2 /= var1;
         var3 += var2 * (var4 % var1);
         var4 /= var1;
      }

      return var3;
   }

   private static void vae(GpuDevice var0, int var1, int var2, int var3, int var4) {
      if (uzp == null) {
         uzp = var0.createBuffer(() -> "Flow2 summer sky", 136, 368L);
      }

      if (uzh == null) {
         byte var5 = 12;
         uzg = var0.createTexture(() -> "Flow2 cloud noise", var5, TextureFormat.RGBA8, 528, 528, 1, 1);
         uzh = var0.createTextureView(uzg);
         uzi = var0.createTexture(() -> "Flow2 cloud weather", var5, TextureFormat.RGBA8, 256, 256, 1, 1);
         uzj = var0.createTextureView(uzi);
         uzk = false;
      }

      if (uzm[0] == null || var1 != uzq || var2 != uzr || var3 != uzn || var4 != uzo) {
         release();
         byte var10 = 12;

         for (int var6 = 0; var6 < uzl.length; var6++) {
            int var7 = var6;
            int var8 = var6 < 2 ? var1 : var3;
            int var9 = var6 < 2 ? var2 : var4;
            uzl[var6] = var0.createTexture(() -> "Flow2 summer sky " + var7, var10, TextureFormat.RGBA8, var8, var9, 1, 1);
            uzm[var6] = var0.createTextureView(uzl[var6]);
         }

         uzq = var1;
         uzr = var2;
         uzn = var3;
         uzo = var4;
      }
   }
}
