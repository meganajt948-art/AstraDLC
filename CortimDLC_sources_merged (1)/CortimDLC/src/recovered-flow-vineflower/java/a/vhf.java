package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.nio.ByteBuffer;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexFormats;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class vhf {
   private static final int vhg = 96;
   public static final RenderPipeline MASK = RenderPipeline.builder(new Snippet[0])
      .withLocation(uvq.id("pipeline/hand_mask"))
      .withVertexShader(uvq.id("core/blur"))
      .withFragmentShader(uvq.id("core/hand_mask"))
      .withSampler("DepthSampler")
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.field_60033, DrawMode.field_27379)
      .build();
   public static final RenderPipeline FX = RenderPipeline.builder(new Snippet[0])
      .withLocation(uvq.id("pipeline/hand_fx"))
      .withVertexShader(uvq.id("core/blur"))
      .withFragmentShader(uvq.id("core/hand_fx"))
      .withSampler("DepthSampler")
      .withSampler("GlowSampler")
      .withUniform("FlowHands", UniformType.field_60031)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.field_60033, DrawMode.field_27379)
      .build();
   private static vhe vhh;
   private static final GpuTexture[] vhi = new GpuTexture[7];
   private static final GpuTextureView[] vhj = new GpuTextureView[7];
   @Nullable
   private static GpuBuffer vhk;
   private static int vhl = -1;
   private static int vhm = -1;
   private static boolean vhn;

   private vhf() {
   }

   public static void register(vhe var0) {
      vhh = var0;
   }

   static void afterHands(ClientPlayerEntity var0, float var1) {
      vhe var2 = vhh;
      if (var2 != null && var2.active() && !vhn) {
         if (uvq.ensure(MASK) && uvq.ensure(FX) && uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP)) {
            Framebuffer var3 = MinecraftClient.method_1551().method_1522();
            GpuTextureView var4 = var3.method_71639();
            GpuTextureView var5 = var3.method_71640();
            if (var4 != null && var5 != null && var3.field_1482 >= 16 && var3.field_1481 >= 16) {
               try {
                  GpuDevice var6 = RenderSystem.getDevice();
                  vhr(var6, var3.field_1482, var3.field_1481);
                  CommandEncoder var7 = var6.createCommandEncoder();
                  int[] var8 = var2.colors(var0);
                  MemoryStack var9 = MemoryStack.stackPush();

                  try {
                     ByteBuffer var10 = Std140Builder.onStack(var9, 96)
                        .putVec4(var3.field_1482, var3.field_1481, 1.0F / var3.field_1482, 1.0F / var3.field_1481)
                        .putVec4(var2.time(), 0.0F, var2.fill(), var2.glow())
                        .putVec4((var8[0] >> 16 & 0xFF) / 255.0F, (var8[0] >> 8 & 0xFF) / 255.0F, (var8[0] & 0xFF) / 255.0F, 1.0F)
                        .putVec4((var8[1] >> 16 & 0xFF) / 255.0F, (var8[1] >> 8 & 0xFF) / 255.0F, (var8[1] & 0xFF) / 255.0F, 1.0F)
                        .putVec4(var2.rim(), 0.0F, 0.0F, 0.0F)
                        .putVec4(0.0F, 0.0F, 0.0F, 0.0F)
                        .get();
                     var7.writeToBuffer(vhk.slice(), var10);
                  } catch (Throwable var18) {
                     if (var9 != null) {
                        try {
                           var9.close();
                        } catch (Throwable var15) {
                           var18.addSuppressed(var15);
                        }
                     }

                     throw var18;
                  }

                  if (var9 != null) {
                     var9.close();
                  }

                  RenderPass var20 = var7.createRenderPass(() -> "Flow2 hand mask", vhj[0], OptionalInt.empty());

                  try {
                     var20.setPipeline(MASK);
                     var20.bindTexture("DepthSampler", var5, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                     var20.draw(0, 3);
                  } catch (Throwable var17) {
                     if (var20 != null) {
                        try {
                           var20.close();
                        } catch (Throwable var14) {
                           var17.addSuppressed(var14);
                        }
                     }

                     throw var17;
                  }

                  if (var20 != null) {
                     var20.close();
                  }

                  GpuTextureView var21 = vhj[0];
                  if (var2.glow() > 0.001F) {
                     vhq(var7, uvq.BLUR_DOWN, vhj[0], vhj[1]);
                     vhq(var7, uvq.BLUR_DOWN, vhj[1], vhj[2]);
                     vhq(var7, uvq.BLUR_DOWN, vhj[2], vhj[3]);
                     vhq(var7, uvq.BLUR_UP, vhj[3], vhj[4]);
                     vhq(var7, uvq.BLUR_UP, vhj[4], vhj[5]);
                     vhq(var7, uvq.BLUR_UP, vhj[5], vhj[6]);
                     var21 = vhj[6];
                  }

                  RenderPass var22 = var7.createRenderPass(() -> "Flow2 hand shader", var4, OptionalInt.empty());

                  try {
                     var22.setPipeline(FX);
                     var22.bindTexture("DepthSampler", var5, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                     var22.bindTexture("GlowSampler", var21, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                     var22.setUniform("FlowHands", vhk);
                     var22.draw(0, 3);
                  } catch (Throwable var16) {
                     if (var22 != null) {
                        try {
                           var22.close();
                        } catch (Throwable var13) {
                           var16.addSuppressed(var13);
                        }
                     }

                     throw var16;
                  }

                  if (var22 != null) {
                     var22.close();
                  }
               } catch (Throwable var19) {
                  vhn = true;
                  System.out.println("hand shader failed, turned off: " + var19);
               }
            }
         }
      }
   }

   private static void vhq(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3) {
      RenderPass var4 = var0.createRenderPass(() -> "Flow2 hand glow", var3, OptionalInt.empty());

      try {
         var4.setPipeline(var1);
         var4.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
         var4.draw(0, 3);
      } catch (Throwable var8) {
         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var7) {
               var8.addSuppressed(var7);
            }
         }

         throw var8;
      }

      if (var4 != null) {
         var4.close();
      }
   }

   private static void vhr(GpuDevice var0, int var1, int var2) {
      if (vhk == null) {
         vhk = var0.createBuffer(() -> "Flow2 hands", 136, 96L);
      }

      if (vhj[0] == null || var1 != vhl || var2 != vhm) {
         for (int var3 = 0; var3 < vhi.length; var3++) {
            if (vhj[var3] != null) {
               vhj[var3].close();
               vhi[var3].close();
            }
         }

         int[] var9 = new int[]{2, 4, 8, 16, 8, 4, 2};
         byte var4 = 12;

         for (int var5 = 0; var5 < vhi.length; var5++) {
            int var6 = Math.max(1, var1 / var9[var5]);
            int var7 = Math.max(1, var2 / var9[var5]);
            int var8 = var5;
            vhi[var5] = var0.createTexture(() -> "Flow2 hands " + var8, var4, TextureFormat.RGBA8, var6, var7, 1, 1);
            vhj[var5] = var0.createTextureView(vhi[var5]);
         }

         vhl = var1;
         vhm = var2;
      }
   }
}
