package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.OptionalInt;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class upi {
   private static final int upj = 64;
   private static @Nullable uok upk;
   private static @Nullable uok upl;
   private static long upm;
   private static @Nullable GpuBuffer upn;
   private static boolean upo;

   private upi() {
   }

   public static @Nullable GpuTextureView sky(uxt var0, int var1, int var2, float var3) {
      uok var4 = upr(var1, var2);
      return var4 != null && ups(var4, var0, null, var3, 0.0F, false, var0.color1) ? var4.view : null;
   }

   public static @Nullable GpuTextureView photo(uok var0, float var1, float var2, boolean var3, int var4) {
      uok var5 = upr(var0.width, var0.height);
      return var5 != null && ups(var5, null, var0.view, var1, var2, var3, var4) ? var5.view : null;
   }

   public static @Nullable uok still(uxt var0, int var1, int var2, float var3) {
      if (upo) {
         return null;
      }

      uok var4 = uok.target("sky thumb", var1, var2);
      if (ups(var4, var0, null, var3, 0.0F, false, var0.color1)) {
         return var4;
      }

      var4.close();
      return null;
   }

   private static @Nullable uok upr(int var0, int var1) {
      if (!upo && var0 >= 4 && var1 >= 4) {
         long var2 = unf.frame();
         if (upl != null && var2 - upm > 2L) {
            upl.close();
            upl = null;
         }

         if (upk == null || upk.width != var0 || upk.height != var1) {
            if (upk != null) {
               if (upl != null) {
                  upl.close();
               }

               upl = upk;
               upm = var2;
            }

            upk = uok.target("live wallpaper", var0, var1);
         }

         return upk;
      } else {
         return null;
      }
   }

   private static boolean ups(uok var0, @Nullable uxt var1, @Nullable GpuTextureView var2, float var3, float var4, boolean var5, int var6) {
      RenderPipeline var7 = var1 != null ? uvq.WALL_SKY : uvq.WALL_PHOTO;
      if (!uvq.ensure(var7)) {
         return false;
      }

      try {
         GpuDevice var8 = RenderSystem.getDevice();
         if (upn == null) {
            upn = var8.createBuffer(() -> "Flow2 live wallpaper", 136, 64L);
         }

         CommandEncoder var9 = var8.createCommandEncoder();
         int var10 = var1 != null ? var1.color1 : var6;
         int var11 = var1 != null ? var1.color2 : var6;
         MemoryStack var12 = MemoryStack.stackPush();

         try {
            var9.writeToBuffer(
               upn.slice(),
               Std140Builder.onStack(var12, 64)
                  .putVec4(var0.width, var0.height, (float)var0.width / var0.height, 0.0F)
                  .putVec4(var1 != null ? var1.id() : 0.0F, var3, var4, var5 ? 1.0F : 0.0F)
                  .putVec4(uxi.r(var10), uxi.g(var10), uxi.b(var10), 4.0F)
                  .putVec4(uxi.r(var11), uxi.g(var11), uxi.b(var11), var1 != null ? var1.stars : 0.0F)
                  .get()
            );
         } catch (Throwable var17) {
            if (var12 != null) {
               try {
                  var12.close();
               } catch (Throwable var16) {
                  var17.addSuppressed(var16);
               }
            }

            throw var17;
         }

         if (var12 != null) {
            var12.close();
         }

         try (RenderPass var20 = var9.createRenderPass(() -> "Flow2 live wallpaper", var0.view, OptionalInt.empty())) {
            var20.setPipeline(var7);
            if (var2 != null) {
               var20.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
            }

            var20.setUniform("FlowWall", upn);
            var20.draw(0, 3);
         }

         return true;
      } catch (Throwable var19) {
         upo = true;
         System.out.println("live wallpaper failed: " + var19);
         var19.printStackTrace();
         return false;
      }
   }
}
