package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
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
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class ujw {
   @Nullable
   private static GpuTexture ujx;
   @Nullable
   private static GpuTextureView ujy;
   @Nullable
   private static GpuBuffer ujz;
   private static int uka = -1;
   private static int ukb = -1;

   private ujw() {
   }

   @Nullable
   public static GpuTextureView worldWith(GpuTextureView var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      if (!uvq.ensure(uvq.COMPOSITE)) {
         return null;
      } else {
         try {
            Framebuffer var7 = MinecraftClient.method_1551().method_1522();
            GpuTextureView var8 = var7.method_71639();
            if (var8 != null && var7.field_1482 >= 4 && var7.field_1481 >= 4) {
               uke(var7.field_1482, var7.field_1481);
               GpuDevice var9 = RenderSystem.getDevice();
               CommandEncoder var10 = var9.createCommandEncoder();
               float var11 = var7.field_1482;
               float var12 = var7.field_1481;
               MemoryStack var13 = MemoryStack.stackPush();

               try {
                  ByteBuffer var14 = Std140Builder.onStack(var13, 32)
                     .putVec4(var1 / var11, 1.0F - var4 / var12, var3 / var11, 1.0F - var2 / var12)
                     .putVec4(var5, (var6 >> 16 & 0xFF) / 255.0F, (var6 >> 8 & 0xFF) / 255.0F, (var6 & 0xFF) / 255.0F)
                     .get();
                  var10.writeToBuffer(ujz.slice(), var14);
               } catch (Throwable var19) {
                  if (var13 != null) {
                     try {
                        var13.close();
                     } catch (Throwable var17) {
                        var19.addSuppressed(var17);
                     }
                  }

                  throw var19;
               }

               if (var13 != null) {
                  var13.close();
               }

               RenderPass var21 = var10.createRenderPass(() -> "Flow2 composite", ujy, OptionalInt.empty());

               try {
                  var21.setPipeline(uvq.COMPOSITE);
                  var21.bindTexture("InSampler", var8, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                  var21.bindTexture("WallSampler", var0, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                  var21.setUniform("FlowComposite", ujz);
                  var21.draw(0, 3);
               } catch (Throwable var18) {
                  if (var21 != null) {
                     try {
                        var21.close();
                     } catch (Throwable var16) {
                        var18.addSuppressed(var16);
                     }
                  }

                  throw var18;
               }

               if (var21 != null) {
                  var21.close();
               }

               return ujy;
            } else {
               return null;
            }
         } catch (Throwable var20) {
            System.out.println("composite failed: " + var20);
            return null;
         }
      }
   }

   private static void uke(int var0, int var1) {
      GpuDevice var2 = RenderSystem.getDevice();
      if (ujz == null) {
         ujz = var2.createBuffer(() -> "Flow2 composite", 136, 32L);
      }

      if (ujy == null || var0 != uka || var1 != ukb) {
         if (ujy != null) {
            ujy.close();
            ujx.close();
         }

         byte var3 = 12;
         ujx = var2.createTexture(() -> "Flow2 composite", var3, TextureFormat.RGBA8, var0, var1, 1, 1);
         ujy = var2.createTextureView(ujx);
         uka = var0;
         ukb = var1;
      }
   }
}
