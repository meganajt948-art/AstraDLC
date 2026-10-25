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
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
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

public final class vaf {
   public static final int UNIFORM_SIZE = 624;
   private static final int vag = 256;
   @Nullable
   private static GpuTexture vah;
   @Nullable
   private static GpuTextureView vai;
   private static final GpuTexture[] vaj = new GpuTexture[3];
   private static final GpuTextureView[] vak = new GpuTextureView[3];
   @Nullable
   private static GpuBuffer val;
   private static int vam = -1;
   private static int van = -1;
   private static int vao = 1;
   private static boolean vap;
   private static int vaq;
   private static boolean var;
   private static boolean vas;
   private static final ArrayDeque<GpuQuery> vat = new ArrayDeque<>();
   private static long vau;
   private static int vav;

   private vaf() {
   }

   public static boolean draw(float var0, boolean var1, Consumer<Std140Builder> var2) {
      if (!var && uvq.ensure(uvq.FOG_MARCH) && uvq.ensure(uvq.FOG_RESOLVE) && uvq.ensure(uvq.FOG_COMPOSITE)) {
         GpuBufferSlice var3 = RenderSystem.getProjectionMatrixBuffer();
         GpuBufferSlice var4 = RenderSystem.getShaderFog();
         Framebuffer var5 = MinecraftClient.method_1551().method_1522();
         GpuTextureView var6 = var5.method_71639();
         GpuTextureView var7 = var5.method_71640();
         if (var3 != null && var4 != null && var6 != null && var7 != null && var5.field_1482 >= 4 && var5.field_1481 >= 4) {
            try {
               int var8 = Math.max(1, Math.round(var5.field_1482 * var0));
               int var9 = Math.max(1, Math.round(var5.field_1481 * var0));
               vaz(var8, var9);
               GpuDevice var10 = RenderSystem.getDevice();
               CommandEncoder var11 = var10.createCommandEncoder();
               vaq = vaq + 1 & 1023;
               boolean var12 = vap && var1;
               MemoryStack var13 = MemoryStack.stackPush();

               try {
                  Std140Builder var14 = Std140Builder.onStack(var13, 624)
                     .putVec4(var8, var9, var5.field_1482, var5.field_1481)
                     .putVec4(vaq, var12 ? 1.0F : 0.0F, 0.0F, 0.0F);
                  var2.accept(var14);
                  ByteBuffer var15 = var14.get();
                  var11.writeToBuffer(val.slice(), var15);
               } catch (Throwable var27) {
                  if (var13 != null) {
                     try {
                        var13.close();
                     } catch (Throwable var23) {
                        var27.addSuppressed(var23);
                     }
                  }

                  throw var27;
               }

               if (var13 != null) {
                  var13.close();
               }

               GpuTextureView var29 = vak[0];
               GpuTextureView var30 = vak[vao];
               GpuTextureView var31 = vak[3 - vao];
               GpuQuery var16 = vas ? var11.timerQueryBegin() : null;
               RenderPass var17 = var11.createRenderPass(() -> "Flow2 fog march", var29, OptionalInt.empty());

               try {
                  var17.setPipeline(uvq.FOG_MARCH);
                  var17.bindTexture("DepthSampler", var7, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var17.bindTexture("NoiseSampler", vai, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                  var17.setUniform("Projection", var3);
                  var17.setUniform("Fog", var4);
                  var17.setUniform("FlowFog", val);
                  var17.draw(0, 3);
               } catch (Throwable var26) {
                  if (var17 != null) {
                     try {
                        var17.close();
                     } catch (Throwable var22) {
                        var26.addSuppressed(var22);
                     }
                  }

                  throw var26;
               }

               if (var17 != null) {
                  var17.close();
               }

               var17 = var11.createRenderPass(() -> "Flow2 fog resolve", var31, OptionalInt.empty());

               try {
                  var17.setPipeline(uvq.FOG_RESOLVE);
                  var17.bindTexture("RawSampler", var29, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var17.bindTexture("HistorySampler", var30, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                  var17.bindTexture("DepthSampler", var7, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var17.setUniform("Projection", var3);
                  var17.setUniform("FlowFog", val);
                  var17.draw(0, 3);
               } catch (Throwable var25) {
                  if (var17 != null) {
                     try {
                        var17.close();
                     } catch (Throwable var21) {
                        var25.addSuppressed(var21);
                     }
                  }

                  throw var25;
               }

               if (var17 != null) {
                  var17.close();
               }

               var17 = var11.createRenderPass(() -> "Flow2 fog composite", var6, OptionalInt.empty());

               try {
                  var17.setPipeline(uvq.FOG_COMPOSITE);
                  var17.bindTexture("FogSampler", var31, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var17.bindTexture("DepthSampler", var7, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var17.setUniform("Projection", var3);
                  var17.setUniform("FlowFog", val);
                  var17.draw(0, 3);
               } catch (Throwable var24) {
                  if (var17 != null) {
                     try {
                        var17.close();
                     } catch (Throwable var20) {
                        var24.addSuppressed(var20);
                     }
                  }

                  throw var24;
               }

               if (var17 != null) {
                  var17.close();
               }

               if (var16 != null) {
                  var11.timerQueryEnd(var16);
                  vat.add(var16);
               }

               vao = 3 - vao;
               vap = true;
               vay();
               return true;
            } catch (Throwable var28) {
               var = true;
               System.out.println("volumetric fog failed: " + var28);
               var28.printStackTrace();
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
      vas = var0;
      vau = 0L;
      vav = 0;
   }

   public static double gpuMillis() {
      vay();
      double var0 = vav == 0 ? -1.0 : vau / 1000000.0 / vav;
      vau = 0L;
      vav = 0;
      return var0;
   }

   private static void vay() {
      while (!vat.isEmpty()) {
         OptionalLong var0 = vat.peek().getValue();
         if (var0.isEmpty()) {
            if (vat.size() < 8) {
               return;
            }

            vat.poll().close();
         } else {
            vat.poll().close();
            vau = vau + var0.getAsLong();
            vav++;
         }
      }
   }

   public static void release() {
      for (int var0 = 0; var0 < vak.length; var0++) {
         if (vak[var0] != null) {
            vak[var0].close();
            vak[var0] = null;
         }

         if (vaj[var0] != null) {
            vaj[var0].close();
            vaj[var0] = null;
         }
      }

      vam = -1;
      van = -1;
      vap = false;
      var = false;
   }

   private static void vaz(int var0, int var1) {
      GpuDevice var2 = RenderSystem.getDevice();
      if (val == null) {
         val = var2.createBuffer(() -> "Flow2 fog", 136, 624L);
      }

      if (vai == null) {
         vba(var2);
      }

      if (vak[0] == null || var0 != vam || var1 != van) {
         release();
         byte var3 = 12;

         for (int var4 = 0; var4 < vaj.length; var4++) {
            int var5 = var4;
            vaj[var4] = var2.createTexture(() -> "Flow2 fog " + var5, var3, TextureFormat.RGBA8, var0, var1, 1, 1);
            vak[var4] = var2.createTextureView(vaj[var4]);
         }

         vam = var0;
         van = var1;
      }
   }

   private static void vba(GpuDevice var0) {
      Random var1 = new Random(99540742L);
      int[] var2 = new int[65536];
      int[] var3 = new int[65536];

      for (int var4 = 0; var4 < var2.length; var4++) {
         var2[var4] = var1.nextInt(256);
         var3[var4] = var1.nextInt(256);
      }

      NativeImage var11 = new NativeImage(Format.field_4997, 256, 256, false);

      try {
         for (int var5 = 0; var5 < 256; var5++) {
            for (int var6 = 0; var6 < 256; var6++) {
               int var7 = (var5 + 17 & 0xFF) * 256 + (var6 + 37 & 0xFF);
               int var8 = var5 * 256 + var6;
               var11.method_61941(var6, var5, var3[var8] << 24 | var2[var7] << 16 | var2[var8] << 8 | var3[var7]);
            }
         }

         byte var12 = 5;
         vah = var0.createTexture(() -> "Flow2 fog noise", var12, TextureFormat.RGBA8, 256, 256, 1, 1);
         vai = var0.createTextureView(vah);
         var0.createCommandEncoder().writeToTexture(vah, var11);
      } catch (Throwable var10) {
         try {
            var11.close();
         } catch (Throwable var9) {
            var10.addSuppressed(var9);
         }

         throw var10;
      }

      var11.close();
   }
}
