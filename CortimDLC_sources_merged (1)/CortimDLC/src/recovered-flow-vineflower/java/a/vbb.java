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
   @Nullable
   private static GpuTexture vbc;
   @Nullable
   private static GpuTextureView vbd;
   @Nullable
   private static GpuTexture vbe;
   @Nullable
   private static GpuTextureView vbf;
   @Nullable
   private static GpuTexture vbg;
   @Nullable
   private static GpuTextureView vbh;
   @Nullable
   private static GpuBuffer vbi;
   @Nullable
   private static GpuBuffer vbj;
   @Nullable
   private static GpuTexture vbk;
   @Nullable
   private static GpuTextureView vbl;
   @Nullable
   private static GpuTexture vbm;
   @Nullable
   private static GpuTextureView vbn;
   private static int vbo = -1;
   private static int vbp = -1;
   private static int vbq = -1;
   private static int vbr = -1;
   private static boolean vbs;
   private static boolean vbt;
   private static boolean vbu;
   private static boolean vbv;
   private static boolean vbw;
   private static final ArrayDeque<GpuQuery> vbx = new ArrayDeque<>();
   private static long vby;
   private static int vbz;

   private vbb() {
   }

   public static boolean draw(Consumer<Std140Builder> var0) {
      return vcc(uvq.WET, false, 1328, "FlowWet", var0);
   }

   public static boolean drawSeason(Consumer<Std140Builder> var0) {
      return vcc(uvq.SEASON, true, 1408, "FlowSeason", var0);
   }

   @Nullable
   public static GpuTextureView heightView() {
      return vbh;
   }

   public static GpuTextureView noiseView(GpuDevice var0) {
      if (vbf == null) {
         vci(var0);
      }

      return vbf;
   }

   @Nullable
   public static GpuTextureView terrainDepthView() {
      return vbl;
   }

   @Nullable
   public static GpuTextureView entityDepthView() {
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
      Framebuffer var0 = MinecraftClient.method_1551().method_1522();
      return vbt && vbu && vbn != null && vbq == var0.field_1482 && vbr == var0.field_1481;
   }

   public static void captureDepth(boolean var0) {
      if (vbs && !vbv) {
         Framebuffer var1 = MinecraftClient.method_1551().method_1522();
         GpuTexture var2 = var1.method_30278();
         if (var2 != null && var1.field_1482 >= 4 && var1.field_1481 >= 4) {
            try {
               GpuDevice var3 = RenderSystem.getDevice();
               vcf(var3, var1.field_1482, var1.field_1481);
               var3.createCommandEncoder().copyTextureToTexture(var2, var0 ? vbm : vbk, 0, 0, 0, 0, 0, var1.field_1482, var1.field_1481);
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
         Framebuffer var2 = MinecraftClient.method_1551().method_1522();
         GpuTextureView var3 = var2.method_71639();
         GpuTextureView var4 = var2.method_71640();
         if (var1 != null && var3 != null && var4 != null && vbh != null) {
            try {
               CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
               GpuQuery var6 = vbw ? var5.timerQueryBegin() : null;
               RenderPass var7 = var5.createRenderPass(() -> "Flow2 season particles", var3, OptionalInt.empty(), var4, OptionalDouble.empty());

               try {
                  var7.setPipeline(uvq.SEASON_PARTICLES);
                  var7.bindTexture("HeightSampler", vbh, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var7.setUniform("Projection", var1);
                  var7.setUniform("FlowSeason", vbj);
                  var7.draw(0, var0 * 6);
               } catch (Throwable var11) {
                  if (var7 != null) {
                     try {
                        var7.close();
                     } catch (Throwable var10) {
                        var11.addSuppressed(var10);
                     }
                  }

                  throw var11;
               }

               if (var7 != null) {
                  var7.close();
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
         Framebuffer var1 = MinecraftClient.method_1551().method_1522();
         GpuTextureView var2 = var1.method_71639();
         if (var0 != null && var2 != null && var1.field_1482 == vbo && var1.field_1481 == vbp) {
            try {
               CommandEncoder var3 = RenderSystem.getDevice().createCommandEncoder();
               GpuQuery var4 = vbw ? var3.timerQueryBegin() : null;
               RenderPass var5 = var3.createRenderPass(() -> "Flow2 season grade copy", vbd, OptionalInt.empty());

               try {
                  var5.setPipeline(uvq.BLUR_COPY);
                  var5.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var5.draw(0, 3);
               } catch (Throwable var11) {
                  if (var5 != null) {
                     try {
                        var5.close();
                     } catch (Throwable var9) {
                        var11.addSuppressed(var9);
                     }
                  }

                  throw var11;
               }

               if (var5 != null) {
                  var5.close();
               }

               var5 = var3.createRenderPass(() -> "Flow2 season grade", var2, OptionalInt.empty());

               try {
                  var5.setPipeline(uvq.SEASON_GRADE);
                  var5.bindTexture("SceneSampler", vbd, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var5.setUniform("Projection", var0);
                  var5.setUniform("FlowSeason", vbj);
                  var5.draw(0, 3);
               } catch (Throwable var10) {
                  if (var5 != null) {
                     try {
                        var5.close();
                     } catch (Throwable var8) {
                        var10.addSuppressed(var8);
                     }
                  }

                  throw var10;
               }

               if (var5 != null) {
                  var5.close();
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

   private static boolean vcc(RenderPipeline var0, boolean var1, int var2, String var3, Consumer<Std140Builder> var4) {
      if (!vbv && uvq.ensure(var0) && uvq.ensure(uvq.BLUR_COPY)) {
         GpuBufferSlice var5 = RenderSystem.getProjectionMatrixBuffer();
         GpuBufferSlice var6 = RenderSystem.getShaderFog();
         Framebuffer var7 = MinecraftClient.method_1551().method_1522();
         GpuTextureView var8 = var7.method_71639();
         GpuTextureView var9 = var7.method_71640();
         if (var5 != null && var6 != null && var8 != null && var9 != null && var7.method_30277() != null && var7.field_1482 >= 4 && var7.field_1481 >= 4) {
            try {
               GpuDevice var10 = RenderSystem.getDevice();
               vcg(var10, var7.field_1482, var7.field_1481);
               GpuBuffer var11 = var1 ? vbj : vbi;
               CommandEncoder var12 = var10.createCommandEncoder();
               MemoryStack var13 = MemoryStack.stackPush();

               try {
                  Std140Builder var14 = Std140Builder.onStack(var13, var2)
                     .putVec4(var7.field_1482, var7.field_1481, 1.0F / var7.field_1482, 1.0F / var7.field_1481);
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
               RenderPass var25 = var12.createRenderPass(() -> "Flow2 weather scene copy", vbd, OptionalInt.empty());

               try {
                  var25.setPipeline(uvq.BLUR_COPY);
                  var25.bindTexture("InSampler", var8, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var25.draw(0, 3);
               } catch (Throwable var20) {
                  if (var25 != null) {
                     try {
                        var25.close();
                     } catch (Throwable var18) {
                        var20.addSuppressed(var18);
                     }
                  }

                  throw var20;
               }

               if (var25 != null) {
                  var25.close();
               }

               var25 = var12.createRenderPass(() -> "Flow2 weather", var8, OptionalInt.empty());

               try {
                  var25.setPipeline(var0);
                  var25.bindTexture("SceneSampler", vbd, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                  var25.bindTexture("DepthSampler", var9, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  var25.bindTexture("NoiseSampler", vbf, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                  var25.bindTexture("HeightSampler", vbh, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  if (var1) {
                     boolean var15 = entityMask();
                     var25.bindTexture("TerrainDepthSampler", var15 ? vbl : var9, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                     var25.bindTexture("EntityDepthSampler", var15 ? vbn : var9, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                  }

                  var25.setUniform("Projection", var5);
                  var25.setUniform("Fog", var6);
                  var25.setUniform(var3, var11);
                  var25.draw(0, 3);
               } catch (Throwable var22) {
                  if (var25 != null) {
                     try {
                        var25.close();
                     } catch (Throwable var17) {
                        var22.addSuppressed(var17);
                     }
                  }

                  throw var22;
               }

               if (var25 != null) {
                  var25.close();
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

   private static void vcd() {
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
            NativeImage var2 = new NativeImage(Format.field_4997, 128, 128, false);

            try {
               for (int var3 = 0; var3 < 128; var3++) {
                  for (int var4 = 0; var4 < 128; var4++) {
                     var2.method_61941(var4, var3, var0[var3 * 128 + var4]);
                  }
               }

               var1.createCommandEncoder().writeToTexture(vbg, var2);
            } catch (Throwable var6) {
               try {
                  var2.close();
               } catch (Throwable var5) {
                  var6.addSuppressed(var5);
               }

               throw var6;
            }

            var2.close();
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

   private static void vce() {
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

   private static void vcf(GpuDevice var0, int var1, int var2) {
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

   private static void vcg(GpuDevice var0, int var1, int var2) {
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

   private static void vch(GpuDevice var0) {
      if (vbh == null) {
         byte var1 = 5;
         vbg = var0.createTexture(() -> "Flow2 weather heights", var1, TextureFormat.RGBA8, 128, 128, 1, 1);
         vbh = var0.createTextureView(vbg);
      }
   }

   private static void vci(GpuDevice var0) {
      Random var1 = new Random(65532160L);
      NativeImage var2 = new NativeImage(Format.field_4997, 256, 256, false);

      try {
         for (int var3 = 0; var3 < 256; var3++) {
            for (int var4 = 0; var4 < 256; var4++) {
               var2.method_61941(var4, var3, var1.nextInt());
            }
         }

         byte var7 = 5;
         vbe = var0.createTexture(() -> "Flow2 weather noise", var7, TextureFormat.RGBA8, 256, 256, 1, 1);
         vbf = var0.createTextureView(vbe);
         var0.createCommandEncoder().writeToTexture(vbe, var2);
      } catch (Throwable var6) {
         try {
            var2.close();
         } catch (Throwable var5) {
            var6.addSuppressed(var5);
         }

         throw var6;
      }

      var2.close();
   }
}
