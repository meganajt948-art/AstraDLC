package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
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
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.lwjgl.system.MemoryStack;

public class qze extends kfe {
   private static qze qzf;
   private final vmc qzg = this.add(new vmc("Ratio", 1.33, 0.5, 3.0, 0.01).format(var0 -> vxu.fixed(var0, 2) + " : 1"));
   private static final RenderPipeline qzh = RenderPipeline.builder()
      .withLocation(Identifier.of("flow2", "pipeline/stretch"))
      .withVertexShader(Identifier.of("flow2", "core/blur"))
      .withFragmentShader(Identifier.of("flow2", "core/stretch"))
      .withSampler("InSampler")
      .withUniform("FlowStretch", UniformType.UNIFORM_BUFFER)
      .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
      .withDepthWrite(false)
      .withCull(false)
      .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
      .build();
   private GpuTexture qzi;
   private GpuTextureView qzj;
   private GpuBuffer qzk;
   private int qzl = -1;
   private int qzm = -1;
   private boolean qzn;

   public qze() {
      super("AspectRatio", "Stretched resolution: change the screen's width with a slider", kfa.RENDER);
      qzf = this;
   }

   @Override
   protected void onDisable() {
      this.qzs();
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      qze var2 = qzf;
      if (var2 != null && var2.isEnabled() && !var2.qzn && !dry.armed()) {
         var2.qzq();
      }
   }

   private void qzq() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      Framebuffer var2 = var1.getFramebuffer();
      if (var1.world != null && var2 != null && var2.getColorAttachment() != null && var2.textureWidth >= 4 && var2.textureHeight >= 4) {
         float var3 = (float)var2.textureWidth / var2.textureHeight;
         float var4 = (float)this.qzg.get();
         if (!(Math.abs(var4 - var3) < 0.005F) && uvq.ensure(qzh)) {
            float var5 = Math.min(1.0F, var4 / var3);
            float var6 = Math.min(1.0F, var3 / var4);

            try {
               GpuDevice var7 = RenderSystem.getDevice();
               this.qzr(var7, var2.textureWidth, var2.textureHeight);
               CommandEncoder var8 = var7.createCommandEncoder();
               var8.copyTextureToTexture(var2.getColorAttachment(), this.qzi, 0, 0, 0, 0, 0, var2.textureWidth, var2.textureHeight);
               MemoryStack var9 = MemoryStack.stackPush();

               try {
                  var8.writeToBuffer(this.qzk.slice(), Std140Builder.onStack(var9, 16).putVec4((1.0F - var5) * 0.5F, (1.0F - var6) * 0.5F, var5, var6).get());
               } catch (Throwable var15) {
                  if (var9 != null) {
                     try {
                        var9.close();
                     } catch (Throwable var13) {
                        var15.addSuppressed(var13);
                     }
                  }

                  throw var15;
               }

               if (var9 != null) {
                  var9.close();
               }

               try (RenderPass var17 = var8.createRenderPass(() -> "Flow2 aspect ratio", var2.getColorAttachmentView(), OptionalInt.empty())) {
                  var17.setPipeline(qzh);
                  var17.bindTexture("InSampler", this.qzj, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                  var17.setUniform("FlowStretch", this.qzk);
                  var17.draw(0, 3);
               }
            } catch (Throwable var16) {
               this.qzn = true;
               System.out.println("[Flow2] aspect ratio unavailable: " + var16);
            }
         }
      }
   }

   private void qzr(GpuDevice var1, int var2, int var3) {
      if (this.qzk == null) {
         this.qzk = var1.createBuffer(() -> "Flow2 aspect ratio", 136, 16L);
      }

      if (this.qzj == null || var2 != this.qzl || var3 != this.qzm) {
         this.qzs();
         byte var4 = 5;
         this.qzi = var1.createTexture(() -> "Flow2 aspect ratio", var4, TextureFormat.RGBA8, var2, var3, 1, 1);
         this.qzj = var1.createTextureView(this.qzi);
         this.qzl = var2;
         this.qzm = var3;
      }
   }

   private void qzs() {
      if (this.qzj != null) {
         this.qzj.close();
         this.qzj = null;
      }

      if (this.qzi != null) {
         this.qzi.close();
         this.qzi = null;
      }

      this.qzl = -1;
      this.qzm = -1;
   }
}
