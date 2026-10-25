package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
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
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GpuSampler;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class unr {
   private static final int uns = 3;
   private static final int unt = 48;
   @Nullable
   private static GpuTexture unu;
   @Nullable
   private static GpuTextureView unv;
   private static final GpuTexture[] unw = new GpuTexture[3];
   private static final GpuTextureView[] unx = new GpuTextureView[3];
   @Nullable
   private static GpuBuffer uny;
   private static int unz = -1;
   private static int uoa = -1;
   private static boolean uob;

   private unr() {
   }

   public static void apply(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      if (!uob && uvq.ensure(uvq.GRADE) && uvq.ensure(uvq.BLUR_COPY) && (!(var5 > 0.0F) || uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP))) {
         Framebuffer var7 = MinecraftClient.method_1551().method_1522();
         GpuTextureView var8 = var7.method_71639();
         if (var8 != null && var7.field_1482 >= 8 && var7.field_1481 >= 8) {
            try {
               uof(var7.field_1482, var7.field_1481);
               GpuDevice var9 = RenderSystem.getDevice();
               CommandEncoder var10 = var9.createCommandEncoder();
               GpuSampler var11 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
               MemoryStack var12 = MemoryStack.stackPush();

               try {
                  ByteBuffer var13 = Std140Builder.onStack(var12, 48)
                     .putVec4(var0, var1, var2, var3)
                     .putVec4(var4, var5, 1.0F / var7.field_1482, 1.0F / var7.field_1481)
                     .putVec4(var6, 0.62F, 0.0F, 0.0F)
                     .get();
                  var10.writeToBuffer(uny.slice(), var13);
               } catch (Throwable var19) {
                  if (var12 != null) {
                     try {
                        var12.close();
                     } catch (Throwable var17) {
                        var19.addSuppressed(var17);
                     }
                  }

                  throw var19;
               }

               if (var12 != null) {
                  var12.close();
               }

               GpuTextureView var21 = var8;
               if (var5 > 0.0F) {
                  GpuTextureView var22 = var8;

                  for (int var14 = 0; var14 < 3; var14++) {
                     uoe(var10, uvq.BLUR_DOWN, var22, unx[var14], var11);
                     var22 = unx[var14];
                  }

                  for (int var24 = 2; var24 > 0; var24--) {
                     uoe(var10, uvq.BLUR_UP, unx[var24], unx[var24 - 1], var11);
                  }

                  var21 = unx[0];
               }

               RenderPass var23 = var10.createRenderPass(() -> "Flow2 grade", unv, OptionalInt.empty());

               try {
                  var23.setPipeline(uvq.GRADE);
                  var23.bindTexture("InSampler", var8, var11);
                  var23.bindTexture("BloomSampler", var21, var11);
                  var23.setUniform("FlowGrade", uny);
                  var23.draw(0, 3);
               } catch (Throwable var18) {
                  if (var23 != null) {
                     try {
                        var23.close();
                     } catch (Throwable var16) {
                        var18.addSuppressed(var16);
                     }
                  }

                  throw var18;
               }

               if (var23 != null) {
                  var23.close();
               }

               uoe(var10, uvq.BLUR_COPY, unv, var8, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
            } catch (Throwable var20) {
               uob = true;
               System.out.println("grading failed: " + var20);
            }
         }
      }
   }

   private static void uoe(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3, GpuSampler var4) {
      RenderPass var5 = var0.createRenderPass(() -> "Flow2 grade glow", var3, OptionalInt.empty());

      try {
         var5.setPipeline(var1);
         var5.bindTexture("InSampler", var2, var4);
         var5.draw(0, 3);
      } catch (Throwable var9) {
         if (var5 != null) {
            try {
               var5.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }
         }

         throw var9;
      }

      if (var5 != null) {
         var5.close();
      }
   }

   public static void release() {
      if (unv != null) {
         unv.close();
         unu.close();
         unv = null;
         unu = null;
      }

      for (int var0 = 0; var0 < 3; var0++) {
         if (unx[var0] != null) {
            unx[var0].close();
            unw[var0].close();
            unx[var0] = null;
            unw[var0] = null;
         }
      }

      unz = -1;
      uoa = -1;
      uob = false;
   }

   private static void uof(int var0, int var1) {
      GpuDevice var2 = RenderSystem.getDevice();
      if (uny == null) {
         uny = var2.createBuffer(() -> "Flow2 grade", 136, 48L);
      }

      if (unv == null || var0 != unz || var1 != uoa) {
         release();
         byte var3 = 12;
         unu = var2.createTexture(() -> "Flow2 graded", var3, TextureFormat.RGBA8, var0, var1, 1, 1);
         unv = var2.createTextureView(unu);

         for (int var4 = 0; var4 < 3; var4++) {
            int var5 = Math.max(1, var0 >> var4 + 2);
            int var6 = Math.max(1, var1 >> var4 + 2);
            int var7 = var4;
            unw[var4] = var2.createTexture(() -> "Flow2 grade glow " + var7, var3, TextureFormat.RGBA8, var5, var6, 1, 1);
            unx[var4] = var2.createTextureView(unw[var4]);
         }

         unz = var0;
         uoa = var1;
      }
   }
}
