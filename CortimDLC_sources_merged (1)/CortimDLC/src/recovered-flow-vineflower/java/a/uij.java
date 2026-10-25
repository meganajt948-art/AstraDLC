package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import org.jspecify.annotations.Nullable;

public final class uij {
   public static final int MAX_ITERATIONS = 6;
   public static final uij SCENE = new uij("scene");
   public static final uij BACKDROP = new uij("backdrop");
   public static final uij HUD = new uij("hud");
   public static final uij TAGS = new uij("tags");
   final String uik;
   final GpuTexture[] uil = new GpuTexture[6];
   final GpuTextureView[] uim = new GpuTextureView[6];
   @Nullable GpuTexture uin;
   @Nullable GpuTextureView uio;
   int uip = -1;
   int uiq = -1;
   @Nullable GpuTextureView uir;
   long uis = -1L;
   int uit;
   @Nullable Object uiu;
   boolean uiv;
   boolean uiw;
   double uix;
   double uiy;
   double uiz;
   float uja;
   float ujb;
   static uij[] ujc;

   uij(String var1) {
      this.uik = var1;
   }

   public boolean capture(DrawContext var1, int var2, @Nullable GpuTextureView var3) {
      unf.observe(var1);
      var2 = Math.max(0, Math.min(6, var2));
      long var4 = unf.frame();
      Framebuffer var6 = MinecraftClient.getInstance().getFramebuffer();
      GpuTextureView var7 = var3 != null ? var3 : var6.getColorAttachmentView();
      if (this.uis == var4 && this.uit == var2 && this.uiu == var7 && this.uir != null) {
         return true;
      }

      for (uij var11 : ujf()) {
         if (var11 != this && var11.uis == var4 && var11.uit == var2 && var11.uiu == var7 && var11.uir != null) {
            this.uir = var11.uir;
            this.uis = var4;
            this.uit = var2;
            this.uiu = var7;
            this.uiv = true;
            return true;
         }
      }

      if (var3 == null
         && this.uir != null
         && !this.uiv
         && !this.uiw
         && this.uis == var4 - 1L
         && this.uit == var2
         && this.uiu == var7
         && var6.textureWidth == this.uip
         && var6.textureHeight == this.uiq
         && this.ujh()) {
         this.uis = var4;
         this.uiw = true;
         return true;
      }

      this.uiw = false;
      this.uiv = false;
      this.uir = null;
      if (var7 == null || var6.textureWidth < 4 || var6.textureHeight < 4) {
         return false;
      }

      if (uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP) && uvq.ensure(uvq.BLUR_COPY) && uvq.ensure(uvq.GLASS)) {
         try {
            this.ujj(var6.textureWidth, var6.textureHeight);
            CommandEncoder var15 = RenderSystem.getDevice().createCommandEncoder();
            GpuSampler var16 = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            if (var2 == 0) {
               if (this.uio == null) {
                  GpuDevice var17 = RenderSystem.getDevice();
                  byte var19 = 12;
                  this.uin = var17.createTexture(() -> "Flow2 " + this.uik + " copy", var19, TextureFormat.RGBA8, this.uip, this.uiq, 1, 1);
                  this.uio = var17.createTextureView(this.uin);
               }

               uji(var15, uvq.BLUR_COPY, var7, this.uio, var16);
               this.uir = this.uio;
            } else {
               int var18 = var2;

               while (var18 > 1 && this.uip >> var18 < 2) {
                  var18--;
               }

               GpuTextureView var20 = var7;

               for (int var12 = 0; var12 < var18; var12++) {
                  uji(var15, uvq.BLUR_DOWN, var20, this.uim[var12], var16);
                  var20 = this.uim[var12];
               }

               for (int var21 = var18 - 1; var21 > 0; var21--) {
                  uji(var15, uvq.BLUR_UP, this.uim[var21], this.uim[var21 - 1], var16);
               }

               this.uir = this.uim[0];
            }

            this.uis = var4;
            this.uit = var2;
            this.uiu = var7;
            this.ujg();
            return true;
         } catch (Throwable var13) {
            System.out.println("blur (" + this.uik + ") failed: " + var13);
            this.uir = null;
            return false;
         }
      } else {
         return false;
      }
   }

   static uij[] ujf() {
      if (ujc == null) {
         ujc = new uij[]{SCENE, BACKDROP, HUD, TAGS};
      }

      return ujc;
   }

   void ujg() {
      Camera var1 = MinecraftClient.getInstance().gameRenderer.getCamera();
      Vec3d var2 = var1.getCameraPos();
      this.uix = var2.x;
      this.uiy = var2.y;
      this.uiz = var2.z;
      this.uja = var1.getYaw();
      this.ujb = var1.getPitch();
   }

   boolean ujh() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.gameRenderer != null && var1.world != null) {
         Camera var2 = var1.gameRenderer.getCamera();
         Vec3d var3 = var2.getCameraPos();
         return var3.squaredDistanceTo(this.uix, this.uiy, this.uiz) < 1.0E-6
            && Math.abs(var2.getYaw() - this.uja) < 0.01F
            && Math.abs(var2.getPitch() - this.ujb) < 0.01F;
      } else {
         return false;
      }
   }

   public @Nullable GpuTextureView result(DrawContext var1) {
      unf.observe(var1);
      return this.uis == unf.frame() ? this.uir : null;
   }

   static void uji(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3, GpuSampler var4) {
      try (RenderPass var5 = var0.createRenderPass(() -> "Flow2 blur", var3, OptionalInt.empty())) {
         var5.setPipeline(var1);
         var5.bindTexture("InSampler", var2, var4);
         var5.draw(0, 3);
      }
   }

   void ujj(int var1, int var2) {
      if (var1 != this.uip || var2 != this.uiq || this.uim[0] == null) {
         this.ujk();
         GpuDevice var3 = RenderSystem.getDevice();
         byte var4 = 12;

         for (int var5 = 0; var5 < 6; var5++) {
            int var6 = Math.max(1, var1 >> var5 + 1);
            int var7 = Math.max(1, var2 >> var5 + 1);
            int var8 = var5;
            this.uil[var5] = var3.createTexture(() -> "Flow2 " + this.uik + " blur " + var8, var4, TextureFormat.RGBA8, var6, var7, 1, 1);
            this.uim[var5] = var3.createTextureView(this.uil[var5]);
         }

         this.uip = var1;
         this.uiq = var2;
      }
   }

   void ujk() {
      if (this.uio != null) {
         this.uio.close();
         this.uio = null;
      }

      if (this.uin != null) {
         this.uin.close();
         this.uin = null;
      }

      for (int var1 = 0; var1 < 6; var1++) {
         if (this.uim[var1] != null) {
            this.uim[var1].close();
            this.uim[var1] = null;
         }

         if (this.uil[var1] != null) {
            this.uil[var1].close();
            this.uil[var1] = null;
         }
      }

      this.uir = null;
      this.uip = -1;
      this.uiq = -1;
   }
}
