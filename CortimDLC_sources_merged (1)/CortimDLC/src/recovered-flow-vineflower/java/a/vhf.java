package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
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
   public static final RenderPipeline MASK = RenderPipeline.builder()
      .withLocation(uvq.id("pipeline/hand_mask"))
      .withVertexShader(uvq.id("core/blur"))
      .withFragmentShader(uvq.id("core/hand_mask"))
      .withSampler("DepthSampler")
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   public static final RenderPipeline FX = RenderPipeline.builder()
      .withLocation(uvq.id("pipeline/hand_fx"))
      .withVertexShader(uvq.id("core/blur"))
      .withFragmentShader(uvq.id("core/hand_fx"))
      .withSampler("DepthSampler")
      .withSampler("GlowSampler")
      .withUniform("FlowHands", UniformType.UNIFORM_BUFFER)
      .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   private static vhe vhh;
   private static final GpuTexture[] vhi = new GpuTexture[7];
   private static final GpuTextureView[] vhj = new GpuTextureView[7];
   private static @Nullable GpuBuffer vhk;
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
            Framebuffer var3 = MinecraftClient.getInstance().getFramebuffer();
            GpuTextureView var4 = var3.getColorAttachmentView();
            GpuTextureView var5 = var3.getDepthAttachmentView();
            if (var4 != null && var5 != null && var3.textureWidth >= 16 && var3.textureHeight >= 16) {
               try {
                  GpuDevice var6 = RenderSystem.getDevice();
                  vhr(var6, var3.textureWidth, var3.textureHeight);
                  CommandEncoder var7 = var6.createCommandEncoder();
                  int[] var8 = var2.colors(var0);
                  MemoryStack var9 = MemoryStack.stackPush();

                  try {
                     ByteBuffer var10 = Std140Builder.onStack(var9, 96)
                        .putVec4(var3.textureWidth, var3.textureHeight, 1.0F / var3.textureWidth, 1.0F / var3.textureHeight)
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

                  try (RenderPass var20 = var7.createRenderPass(() -> "Flow2 hand mask", vhj[0], OptionalInt.empty())) {
                     var20.setPipeline(MASK);
                     var20.bindTexture("DepthSampler", var5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                     var20.draw(0, 3);
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

                  try (RenderPass var22 = var7.createRenderPass(() -> "Flow2 hand shader", var4, OptionalInt.empty())) {
                     var22.setPipeline(FX);
                     var22.bindTexture("DepthSampler", var5, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
                     var22.bindTexture("GlowSampler", var21, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                     var22.setUniform("FlowHands", vhk);
                     var22.draw(0, 3);
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
      try (RenderPass var4 = var0.createRenderPass(() -> "Flow2 hand glow", var3, OptionalInt.empty())) {
         var4.setPipeline(var1);
         var4.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
         var4.draw(0, 3);
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
