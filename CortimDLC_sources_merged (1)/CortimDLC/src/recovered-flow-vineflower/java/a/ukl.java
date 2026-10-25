package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.command.RenderDispatcher;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class ukl {
   public static final int ESP = 0;
   public static final int FRIENDS = 1;
   public static final int PLAIN = 2;
   public static final int VANILLA = 3;
   public static final int MOBS = 4;
   static final int ukm = 5;
   static final int ukn = 128;
   static final int uko = 4144;
   static final int ukp = 5;
   static final RenderPipeline ukq = une("fx_mask", null, "OutlineSampler");
   static final RenderPipeline ukr = une("fx_down", null, "InSampler");
   static final RenderPipeline uks = une("fx_up", null, "InSampler");
   static final RenderPipeline ukt = une("fx_composite", BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA, "OutlineSampler", "GlowSampler");
   static final RenderPipeline uku = une("fx_fade", BlendFunction.TRANSLUCENT, "OutlineSampler", "OutlineDepthSampler", "DepthSampler", "BackSampler");
   static final uki[] ukv = new uki[5];
   static final EntityRenderState[] ukw = new EntityRenderState[128];
   static final int[] ukx = new int[128];
   static final int[] uky = new int[128];
   static final int[] ukz = new int[128];
   static final float[] ula = new float[128];
   static final List<EntityRenderState> ulb = new ArrayList<>();
   static int ulc;
   static int uld;
   static boolean ule;
   static @Nullable CameraRenderState ulf;
   static boolean ulg;
   static boolean ulh;
   static final float[] uli = new float[4];
   static final float[] ulj = new float[4];
   static boolean ulk = true;
   static boolean ull = true;
   static final float[] ulm = new float[2];
   public static boolean noScissor;
   public static int devMode;
   static final Identifier uln = Identifier.ofVanilla("entity_outline");
   static @Nullable Map<Object, Object> ulo;
   static @Nullable Object ulp;
   static boolean ulq;
   static boolean ulr;
   static final GpuBuffer[] uls = new GpuBuffer[5];
   static final GpuTexture[] ult = new GpuTexture[5];
   static final GpuTextureView[] ulu = new GpuTextureView[5];
   static final GpuTexture[] ulv = new GpuTexture[4];
   static final GpuTextureView[] ulw = new GpuTextureView[4];
   static @Nullable GpuTexture ulx;
   static @Nullable GpuTextureView uly;
   static int ulz = -1;
   static int uma = -1;
   static Field[] umb;
   static boolean umc;
   static boolean umd;
   static Field ume;
   static Field umf;

   ukl() {
   }

   public static boolean canFade() {
      return ulg && !umd && !ulh;
   }

   public static void fadeHookReady() {
      ulg = true;
   }

   public static uki style(int var0) {
      uki var1 = ukv[var0];
      var1.on = true;
      return var1;
   }

   public static void paint(EntityRenderState var0, int var1, int var2, int var3) {
      int var4 = umi(var0);
      if (var4 >= 0) {
         ukx[var4] = var1;
         uky[var4] = var2;
         ukz[var4] = var3;
      }
   }

   public static void fade(EntityRenderState var0, float var1) {
      int var2 = umi(var0);
      if (var2 >= 0) {
         ula[var2] = Math.min(ula[var2], Math.max(0.0F, Math.min(1.0F, var1)));
      }
   }

   static int umi(EntityRenderState var0) {
      for (int var1 = 0; var1 < ulc; var1++) {
         if (ukw[var1] == var0) {
            return var1;
         }
      }

      if (ulc >= 128) {
         return -1;
      }

      int var2 = ulc++;
      ukw[var2] = var0;
      ukx[var2] = 2;
      uky[var2] = -1;
      ukz[var2] = -1;
      ula[var2] = 1.0F;
      return var2;
   }

   public static void afterExtraction(WorldRenderState var0) {
      uld = 0;
      ulb.clear();
      ulf = null;
      MinecraftClient var1 = MinecraftClient.getInstance();
      boolean var2 = !ulh && var1.worldRenderer != null && umz(var1.worldRenderer) != null;
      if (ulc != 0 && var2) {
         umm(devMode == 0);
         ule = false;

         for (EntityRenderState var4 : var0.entityRenderStates) {
            if (var4.outlineColor != 0 && umo(var4) < 0) {
               ule = true;
               break;
            }
         }

         boolean var10 = ulg && unb(true);

         for (int var11 = 0; var11 < ulc; var11++) {
            EntityRenderState var5 = ukw[var11];
            var5.outlineColor = ump(var11);
            if (var10 && ula[var11] < 0.995F && var0.entityRenderStates.remove(var5)) {
               ulb.add(var5);
            } else {
               ula[var11] = 1.0F;
            }
         }

         usn var12 = null;

         try {
            Framebuffer var13 = var1.getFramebuffer();
            var12 = usn.fresh(var1.getRenderTickCounter().getTickProgress(true), var13.textureWidth, var13.textureHeight);
         } catch (Throwable var9) {
         }

         ulk = noScissor || ule || var12 == null || !umk(var12, Arrays.asList(ukw).subList(0, ulc), uli);
         ull = noScissor || var12 == null || !umk(var12, ulb, ulj);
         if (!var10) {
            unb(false);
         }

         var0.hasOutline = true;
         ulf = var0.cameraRenderState;

         for (uki var8 : ukv) {
            var8.shown = var8.on;
         }

         uld = ulc;
         umj();
      } else {
         umj();
         unb(false);
         umm(false);
      }
   }

   static void umj() {
      for (int var0 = 0; var0 < ulc; var0++) {
         ukw[var0] = null;
      }

      ulc = 0;

      for (uki var3 : ukv) {
         var3.on = false;
      }

      ukv[3].on = true;
   }

   static boolean umk(usn var0, List<EntityRenderState> var1, float[] var2) {
      float var3 = Float.MAX_VALUE;
      float var4 = Float.MAX_VALUE;
      float var5 = -Float.MAX_VALUE;
      float var6 = -Float.MAX_VALUE;

      for (EntityRenderState var8 : var1) {
         double var9 = var8.width * 0.5 + 0.6;

         for (int var11 = 0; var11 < 8; var11++) {
            double var12 = (var11 & 1) == 0 ? var8.x - var9 : var8.x + var9;
            double var14 = (var11 & 2) == 0 ? var8.y - 0.2 : var8.y + var8.height + 0.4;
            double var16 = (var11 & 4) == 0 ? var8.z - var9 : var8.z + var9;
            if (var0.depth(var12, var14, var16) <= 0.05F || !var0.project(var12, var14, var16, ulm)) {
               return false;
            }

            var3 = Math.min(var3, ulm[0]);
            var4 = Math.min(var4, ulm[1]);
            var5 = Math.max(var5, ulm[0]);
            var6 = Math.max(var6, ulm[1]);
         }
      }

      var2[0] = var3;
      var2[1] = var4;
      var2[2] = var5;
      var2[3] = var6;
      return true;
   }

   static void uml(RenderPass var0, float[] var1, float var2, float var3, int var4, int var5) {
      int var6 = Math.max(0, (int)Math.floor((var1[0] - var2) * var3));
      int var7 = Math.min(var4, (int)Math.ceil((var1[2] + var2) * var3));
      int var8 = (int)Math.floor((var1[1] - var2) * var3);
      int var9 = (int)Math.ceil((var1[3] + var2) * var3);
      int var10 = Math.max(0, var5 - var9);
      int var11 = Math.min(var5, var5 - var8);
      var0.enableScissor(var6, var10, Math.max(0, var7 - var6), Math.max(0, var11 - var10));
   }

   public static void restoreVanilla() {
      umm(false);
      unb(false);
   }

   static void umm(boolean var0) {
      if (!ulr && var0 != ulq) {
         try {
            if (var0) {
               Map var1 = umn();
               if (var1 == null) {
                  ulr = true;
                  return;
               }

               ulp = var1.get(uln);
               var1.put(uln, Optional.empty());
               ulo = var1;
            } else if (ulo != null) {
               if (ulo.get(uln) instanceof Optional var4 && var4.isEmpty()) {
                  if (ulp != null) {
                     ulo.put(uln, ulp);
                  } else {
                     ulo.remove(uln);
                  }
               }

               ulo = null;
               ulp = null;
            }

            ulq = var0;
         } catch (Throwable var3) {
            ulr = true;
            System.out.println("vanilla outline pass can't be skipped: " + var3);
         }
      }
   }

   static @Nullable Map<Object, Object> umn() throws IllegalAccessException {
      ShaderLoader var0 = MinecraftClient.getInstance().getShaderLoader();

      for (Field var4 : var0.getClass().getDeclaredFields()) {
         if (!Modifier.isStatic(var4.getModifiers()) && var4.getType().getDeclaringClass() == ShaderLoader.class) {
            var4.setAccessible(true);
            Object var5 = var4.get(var0);
            if (var5 != null) {
               for (Field var9 : var5.getClass().getDeclaredFields()) {
                  if (!Modifier.isStatic(var9.getModifiers()) && Map.class.isAssignableFrom(var9.getType())) {
                     var9.setAccessible(true);
                     return (Map<Object, Object>)var9.get(var5);
                  }
               }
            }
         }
      }

      return null;
   }

   static int umo(EntityRenderState var0) {
      for (int var1 = 0; var1 < ulc; var1++) {
         if (ukw[var1] == var0) {
            return var1;
         }
      }

      return -1;
   }

   static int ump(int var0) {
      return -16318464 | var0 << 8 | 179;
   }

   public static boolean invisible(EntityRenderState var0) {
      return var0 instanceof LivingEntityRenderState var1 && var1.invisibleToPlayer;
   }

   public static void afterEntities() {
      if (!ulb.isEmpty() && ulf != null && !ulh) {
         MinecraftClient var0 = MinecraftClient.getInstance();
         ArrayList var1 = new ArrayList<>(ulb);
         ulb.clear();

         try {
            Framebuffer var2 = var0.getFramebuffer();
            Framebuffer var3 = umz(var0.worldRenderer);
            RenderDispatcher var4 = una(var0.worldRenderer);
            if (var3 == null
               || var4 == null
               || !uvq.ensure(uku)
               || !uvq.ensure(uvq.BLUR_COPY)
               || var2.getColorAttachmentView() == null
               || var2.getDepthAttachmentView() == null
               || var3.getColorAttachmentView() == null
               || var3.getDepthAttachmentView() == null) {
               umq(var0, var1, var4);
               return;
            }

            var0.getBufferBuilders().getEntityVertexConsumers().draw();
            GpuDevice var5 = RenderSystem.getDevice();
            umx(var5, var2.textureWidth, var2.textureHeight);
            CommandEncoder var6 = var5.createCommandEncoder();

            try (RenderPass var7 = var6.createRenderPass(() -> "Flow2 fx back", uly, OptionalInt.empty())) {
               if (!ull) {
                  uml(var7, ulj, 4.0F, 1.0F, var2.textureWidth, var2.textureHeight);
               }

               var7.setPipeline(uvq.BLUR_COPY);
               var7.bindTexture("InSampler", var2.getColorAttachmentView(), RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
               var7.draw(0, 3);
            }

            umq(var0, var1, var4);
            umt(var6, 0, var2.textureWidth, var2.textureHeight, 0.0F);

            try (RenderPass var15 = var6.createRenderPass(() -> "Flow2 fx fade", var2.getColorAttachmentView(), OptionalInt.empty())) {
               if (!ull) {
                  uml(var15, ulj, 4.0F, 1.0F, var2.textureWidth, var2.textureHeight);
               }

               var15.setPipeline(uku);
               var15.bindTexture("OutlineSampler", var3.getColorAttachmentView(), RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
               var15.bindTexture("OutlineDepthSampler", var3.getDepthAttachmentView(), RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
               var15.bindTexture("DepthSampler", var2.getDepthAttachmentView(), RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
               var15.bindTexture("BackSampler", uly, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
               var15.setUniform("FlowFx", uls[0]);
               var15.draw(0, 3);
            }
         } catch (Throwable var14) {
            ulh = true;
            System.out.println("entity fx fade failed, turned off: " + var14);
         }
      }
   }

   static void umq(MinecraftClient var0, List<EntityRenderState> var1, @Nullable RenderDispatcher var2) {
      if (var2 != null) {
         CameraRenderState var3 = ulf;
         MatrixStack var4 = new MatrixStack();

         for (EntityRenderState var6 : var1) {
            var0.getEntityRenderDispatcher().render(var6, var3, var6.x - var3.pos.x, var6.y - var3.pos.y, var6.z - var3.pos.z, var4, var2.getQueue());
         }

         var2.render();
         var0.getBufferBuilders().getEntityVertexConsumers().draw();
         var0.getBufferBuilders().getOutlineVertexConsumers().draw();
      }
   }

   public static void endMain() {
      if (uld != 0 && !ulh) {
         MinecraftClient var0 = MinecraftClient.getInstance();
         Framebuffer var1 = var0.getFramebuffer();
         Framebuffer var2 = var0.worldRenderer == null ? null : umz(var0.worldRenderer);
         if (var2 != null && var2.getColorAttachment() != null && var1.getColorAttachmentView() != null) {
            try {
               GpuDevice var3 = RenderSystem.getDevice();
               CommandEncoder var4 = var3.createCommandEncoder();
               if (devMode != 1 && uvq.ensure(ukq) && uvq.ensure(ukr) && uvq.ensure(uks) && uvq.ensure(ukt)) {
                  umx(var3, var1.textureWidth, var1.textureHeight);
                  float var5 = (float)(System.nanoTime() / 1000000L % 3600000L) / 1000.0F;

                  for (int var6 = 0; var6 < 5; var6++) {
                     uki var7 = ukv[var6];
                     if (var7.visible() && (var6 != 3 || ule)) {
                        umt(var4, var6, var1.textureWidth, var1.textureHeight, var5);
                        umr(var4, var6, var7, var2.getColorAttachmentView(), var1.getColorAttachmentView(), var1.textureWidth, var1.textureHeight);
                     }
                  }
               }

               var4.clearColorTexture(var2.getColorAttachment(), 0);
            } catch (Throwable var11) {
               ulh = true;
               System.out.println("entity fx failed, turned off: " + var11);
            } finally {
               uld = 0;
            }
         }
      }
   }

   static void umr(CommandEncoder var0, int var1, uki var2, GpuTextureView var3, GpuTextureView var4, int var5, int var6) {
      int var7 = Math.max(2, Math.min(4, 2 + Math.round(var2.spread * 2.0F)));
      float var8 = (4 << var7) + Math.min(var2.width * Math.max(1.0F, var6 / 1080.0F), 6.0F) + 4.0F;
      if (!ulk) {
         var0.clearColorTexture(ult[0], 0);
      }

      try (RenderPass var9 = var0.createRenderPass(() -> "Flow2 fx mask", ulu[0], OptionalInt.empty())) {
         if (!ulk) {
            uml(var9, uli, var8, 0.5F, Math.max(1, var5 / 2), Math.max(1, var6 / 2));
         }

         var9.setPipeline(ukq);
         var9.bindTexture("OutlineSampler", var3, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
         var9.setUniform("FlowFx", uls[var1]);
         var9.draw(0, 3);
      }

      for (int var17 = 1; var17 <= var7; var17++) {
         ums(var0, ukr, ulu[var17 - 1], ulu[var17]);
      }

      GpuTextureView var18 = ulu[var7];

      for (int var10 = var7 - 1; var10 >= 0; var10--) {
         ums(var0, uks, var18, ulw[var10]);
         var18 = ulw[var10];
      }

      try (RenderPass var19 = var0.createRenderPass(() -> "Flow2 fx composite", var4, OptionalInt.empty())) {
         if (!ulk) {
            uml(var19, uli, var8, 1.0F, var5, var6);
         }

         var19.setPipeline(ukt);
         var19.bindTexture("OutlineSampler", var3, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
         var19.bindTexture("GlowSampler", var18, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
         var19.setUniform("FlowFx", uls[var1]);
         var19.draw(0, 3);
      }
   }

   static void ums(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3) {
      try (RenderPass var4 = var0.createRenderPass(() -> "Flow2 fx glow", var3, OptionalInt.empty())) {
         var4.setPipeline(var1);
         var4.bindTexture("InSampler", var2, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
         var4.draw(0, 3);
      }
   }

   static void umt(CommandEncoder var0, int var1, int var2, int var3, float var4) {
      uki var5 = ukv[var1];
      MemoryStack var6 = MemoryStack.stackPush();

      try {
         Std140Builder var7 = Std140Builder.onStack(var6, 4144)
            .putVec4(var2, var3, 1.0F / var2, 1.0F / var3)
            .putVec4(var5.fill, var5.line, var5.width * Math.max(1.0F, var3 / 1080.0F), var5.glow)
            .putVec4(var5.spread, var4 * var5.speed, var1, 3.0F);

         for (int var8 = 0; var8 < 128; var8++) {
            int var9 = var8 < uld ? uky[var8] : 0;
            int var10 = var8 < uld ? ukz[var8] : 0;
            var7.putVec4(umu(var9), umv(var9), umw(var9), var8 < uld ? ula[var8] : 1.0F);
            var7.putVec4(umu(var10), umv(var10), umw(var10), var8 < uld ? ukx[var8] : 2.0F);
         }

         ByteBuffer var13 = var7.get();
         var0.writeToBuffer(uls[var1].slice(), var13);
      } catch (Throwable var12) {
         if (var6 != null) {
            try {
               var6.close();
            } catch (Throwable var11) {
               var12.addSuppressed(var11);
            }
         }

         throw var12;
      }

      if (var6 != null) {
         var6.close();
      }
   }

   static float umu(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   static float umv(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   static float umw(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   static void umx(GpuDevice var0, int var1, int var2) {
      for (int var3 = 0; var3 < 5; var3++) {
         if (uls[var3] == null) {
            int var4 = var3;
            uls[var3] = var0.createBuffer(() -> "Flow2 fx " + var4, 136, 4144L);
         }
      }

      if (uly == null || var1 != ulz || var2 != uma) {
         umy();
         byte var7 = 12;
         ulx = var0.createTexture(() -> "Flow2 fx back", var7, TextureFormat.RGBA8, var1, var2, 1, 1);
         uly = var0.createTextureView(ulx);

         for (int var8 = 0; var8 < 5; var8++) {
            int var5 = 2 << var8;
            int var6 = var8;
            ult[var8] = var0.createTexture(() -> "Flow2 fx down " + var6, var7, TextureFormat.RGBA8, Math.max(1, var1 / var5), Math.max(1, var2 / var5), 1, 1);
            ulu[var8] = var0.createTextureView(ult[var8]);
            if (var8 < 4) {
               ulv[var8] = var0.createTexture(() -> "Flow2 fx up " + var6, var7, TextureFormat.RGBA8, Math.max(1, var1 / var5), Math.max(1, var2 / var5), 1, 1);
               ulw[var8] = var0.createTextureView(ulv[var8]);
            }
         }

         ulz = var1;
         uma = var2;
      }
   }

   static void umy() {
      if (uly != null) {
         uly.close();
         ulx.close();
         uly = null;
         ulx = null;
      }

      for (int var0 = 0; var0 < 5; var0++) {
         if (ulu[var0] != null) {
            ulu[var0].close();
            ult[var0].close();
            ulu[var0] = null;
            ult[var0] = null;
         }

         if (var0 < 4 && ulw[var0] != null) {
            ulw[var0].close();
            ulv[var0].close();
            ulw[var0] = null;
            ulv[var0] = null;
         }
      }

      ulz = -1;
      uma = -1;
   }

   static @Nullable Framebuffer umz(WorldRenderer var0) {
      try {
         if (umf == null) {
            for (Field var4 : WorldRenderer.class.getDeclaredFields()) {
               if (!Modifier.isStatic(var4.getModifiers()) && var4.getType() == Framebuffer.class) {
                  var4.setAccessible(true);
                  umf = var4;
                  break;
               }
            }

            if (umf == null) {
               ulh = true;
               return null;
            }
         }

         return (Framebuffer)umf.get(var0);
      } catch (Throwable var5) {
         ulh = true;
         return null;
      }
   }

   static @Nullable RenderDispatcher una(WorldRenderer var0) throws IllegalAccessException {
      if (ume == null) {
         for (Field var4 : WorldRenderer.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var4.getModifiers()) && var4.getType() == RenderDispatcher.class) {
               var4.setAccessible(true);
               ume = var4;
               break;
            }
         }

         if (ume == null) {
            return null;
         }
      }

      return (RenderDispatcher)ume.get(var0);
   }

   static boolean unb(boolean var0) {
      if (!umd && var0 != umc) {
         try {
            if (umb == null) {
               umb = unc();
            }

            for (RenderPipeline var4 : new RenderPipeline[]{RenderPipelines.OUTLINE_CULL, RenderPipelines.OUTLINE_NO_CULL}) {
               umb[0].set(var4, var0 ? DepthTestFunction.LEQUAL_DEPTH_TEST : DepthTestFunction.NO_DEPTH_TEST);
               umb[1].setBoolean(var4, var0);
            }

            umc = var0;
            return var0;
         } catch (Throwable var5) {
            umd = true;
            System.out.println("outline depth unavailable, transparency off: " + var5);
            return false;
         }
      } else {
         return !umd && umc;
      }
   }

   static Field[] unc() throws ReflectiveOperationException {
      RenderPipeline var0 = und(false);
      RenderPipeline var1 = und(true);
      Field var2 = null;
      Field var3 = null;

      for (Field var7 : RenderPipeline.class.getDeclaredFields()) {
         if (!Modifier.isStatic(var7.getModifiers())) {
            var7.setAccessible(true);
            if (var7.getType() == DepthTestFunction.class) {
               var2 = var7;
            } else if (var7.getType() == boolean.class && var7.getBoolean(var0) != var7.getBoolean(var1)) {
               var3 = var7;
            }
         }
      }

      if (var2 != null && var3 != null) {
         return new Field[]{var2, var3};
      } else {
         throw new IllegalStateException("render pipeline layout");
      }
   }

   static RenderPipeline und(boolean var0) {
      return RenderPipeline.builder()
         .withLocation(uvq.id("pipeline/probe_" + var0))
         .withVertexShader(uvq.id("core/blur"))
         .withFragmentShader(uvq.id("core/blur_copy"))
         .withDepthWrite(var0)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES)
         .build();
   }

   static RenderPipeline une(String var0, @Nullable BlendFunction var1, String... var2) {
      Builder var3 = RenderPipeline.builder()
         .withLocation(uvq.id("pipeline/" + var0))
         .withVertexShader(uvq.id("core/blur"))
         .withFragmentShader(uvq.id("core/" + var0))
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.EMPTY, DrawMode.TRIANGLES);

      for (String var7 : var2) {
         var3.withSampler(var7);
      }

      if (!var0.equals("fx_down") && !var0.equals("fx_up")) {
         var3.withUniform("FlowFx", UniformType.UNIFORM_BUFFER);
      }

      if (var1 != null) {
         var3.withBlend(var1);
      }

      return var3.build();
   }

   static {
      for (int var0 = 0; var0 < 5; var0++) {
         ukv[var0] = new uki();
      }

      ukv[3].set(0.0F, 1.0F, 1.5F, 0.0F, 0.3F, 0.0F);
   }
}
