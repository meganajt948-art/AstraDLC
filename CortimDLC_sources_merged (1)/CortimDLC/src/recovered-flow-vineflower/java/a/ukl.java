package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
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
   private static final int ukm = 5;
   private static final int ukn = 128;
   private static final int uko = 4144;
   private static final int ukp = 5;
   private static final RenderPipeline ukq = une("fx_mask", null, "OutlineSampler");
   private static final RenderPipeline ukr = une("fx_down", null, "InSampler");
   private static final RenderPipeline uks = une("fx_up", null, "InSampler");
   private static final RenderPipeline ukt = une("fx_composite", BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA, "OutlineSampler", "GlowSampler");
   private static final RenderPipeline uku = une("fx_fade", BlendFunction.TRANSLUCENT, "OutlineSampler", "OutlineDepthSampler", "DepthSampler", "BackSampler");
   private static final uki[] ukv = new uki[5];
   private static final EntityRenderState[] ukw = new EntityRenderState[128];
   private static final int[] ukx = new int[128];
   private static final int[] uky = new int[128];
   private static final int[] ukz = new int[128];
   private static final float[] ula = new float[128];
   private static final List<EntityRenderState> ulb = new ArrayList<>();
   private static int ulc;
   private static int uld;
   private static boolean ule;
   @Nullable
   private static CameraRenderState ulf;
   private static boolean ulg;
   private static boolean ulh;
   private static final float[] uli = new float[4];
   private static final float[] ulj = new float[4];
   private static boolean ulk = true;
   private static boolean ull = true;
   private static final float[] ulm = new float[2];
   public static boolean noScissor;
   public static int devMode;
   private static final Identifier uln = Identifier.method_60656("entity_outline");
   @Nullable
   private static Map<Object, Object> ulo;
   @Nullable
   private static Object ulp;
   private static boolean ulq;
   private static boolean ulr;
   private static final GpuBuffer[] uls = new GpuBuffer[5];
   private static final GpuTexture[] ult = new GpuTexture[5];
   private static final GpuTextureView[] ulu = new GpuTextureView[5];
   private static final GpuTexture[] ulv = new GpuTexture[4];
   private static final GpuTextureView[] ulw = new GpuTextureView[4];
   @Nullable
   private static GpuTexture ulx;
   @Nullable
   private static GpuTextureView uly;
   private static int ulz = -1;
   private static int uma = -1;
   private static Field[] umb;
   private static boolean umc;
   private static boolean umd;
   private static Field ume;
   private static Field umf;

   private ukl() {
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

   private static int umi(EntityRenderState var0) {
      for (int var1 = 0; var1 < ulc; var1++) {
         if (ukw[var1] == var0) {
            return var1;
         }
      }

      if (ulc >= 128) {
         return -1;
      } else {
         int var2 = ulc++;
         ukw[var2] = var0;
         ukx[var2] = 2;
         uky[var2] = -1;
         ukz[var2] = -1;
         ula[var2] = 1.0F;
         return var2;
      }
   }

   public static void afterExtraction(WorldRenderState var0) {
      uld = 0;
      ulb.clear();
      ulf = null;
      MinecraftClient var1 = MinecraftClient.method_1551();
      boolean var2 = !ulh && var1.field_1769 != null && umz(var1.field_1769) != null;
      if (ulc != 0 && var2) {
         umm(devMode == 0);
         ule = false;

         for (EntityRenderState var4 : var0.field_61735) {
            if (var4.field_61821 != 0 && umo(var4) < 0) {
               ule = true;
               break;
            }
         }

         boolean var10 = ulg && unb(true);

         for (int var11 = 0; var11 < ulc; var11++) {
            EntityRenderState var5 = ukw[var11];
            var5.field_61821 = ump(var11);
            if (var10 && ula[var11] < 0.995F && var0.field_61735.remove(var5)) {
               ulb.add(var5);
            } else {
               ula[var11] = 1.0F;
            }
         }

         usn var12 = null;

         try {
            Framebuffer var13 = var1.method_1522();
            var12 = usn.fresh(var1.method_61966().method_60637(true), var13.field_1482, var13.field_1481);
         } catch (Throwable var9) {
         }

         ulk = noScissor || ule || var12 == null || !umk(var12, Arrays.asList(ukw).subList(0, ulc), uli);
         ull = noScissor || var12 == null || !umk(var12, ulb, ulj);
         if (!var10) {
            unb(false);
         }

         var0.field_61736 = true;
         ulf = var0.field_63082;

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

   private static void umj() {
      for (int var0 = 0; var0 < ulc; var0++) {
         ukw[var0] = null;
      }

      ulc = 0;

      for (uki var3 : ukv) {
         var3.on = false;
      }

      ukv[3].on = true;
   }

   private static boolean umk(usn var0, List<EntityRenderState> var1, float[] var2) {
      float var3 = Float.MAX_VALUE;
      float var4 = Float.MAX_VALUE;
      float var5 = -Float.MAX_VALUE;
      float var6 = -Float.MAX_VALUE;

      for (EntityRenderState var8 : var1) {
         double var9 = var8.field_53329 * 0.5 + 0.6;

         for (int var11 = 0; var11 < 8; var11++) {
            double var12 = (var11 & 1) == 0 ? var8.field_53325 - var9 : var8.field_53325 + var9;
            double var14 = (var11 & 2) == 0 ? var8.field_53326 - 0.2 : var8.field_53326 + var8.field_53330 + 0.4;
            double var16 = (var11 & 4) == 0 ? var8.field_53327 - var9 : var8.field_53327 + var9;
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

   private static void uml(RenderPass var0, float[] var1, float var2, float var3, int var4, int var5) {
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

   private static void umm(boolean var0) {
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

   @Nullable
   private static Map<Object, Object> umn() throws IllegalAccessException {
      ShaderLoader var0 = MinecraftClient.method_1551().method_62887();

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

   private static int umo(EntityRenderState var0) {
      for (int var1 = 0; var1 < ulc; var1++) {
         if (ukw[var1] == var0) {
            return var1;
         }
      }

      return -1;
   }

   private static int ump(int var0) {
      return -16318464 | var0 << 8 | 179;
   }

   public static boolean invisible(EntityRenderState var0) {
      return var0 instanceof LivingEntityRenderState var1 && var1.field_53461;
   }

   public static void afterEntities() {
      if (!ulb.isEmpty() && ulf != null && !ulh) {
         MinecraftClient var0 = MinecraftClient.method_1551();
         ArrayList var1 = new ArrayList<>(ulb);
         ulb.clear();

         try {
            Framebuffer var2 = var0.method_1522();
            Framebuffer var3 = umz(var0.field_1769);
            RenderDispatcher var4 = una(var0.field_1769);
            if (var3 == null
               || var4 == null
               || !uvq.ensure(uku)
               || !uvq.ensure(uvq.BLUR_COPY)
               || var2.method_71639() == null
               || var2.method_71640() == null
               || var3.method_71639() == null
               || var3.method_71640() == null) {
               umq(var0, var1, var4);
               return;
            }

            var0.method_22940().method_23000().method_22993();
            GpuDevice var5 = RenderSystem.getDevice();
            umx(var5, var2.field_1482, var2.field_1481);
            CommandEncoder var6 = var5.createCommandEncoder();
            RenderPass var7 = var6.createRenderPass(() -> "Flow2 fx back", uly, OptionalInt.empty());

            try {
               if (!ull) {
                  uml(var7, ulj, 4.0F, 1.0F, var2.field_1482, var2.field_1481);
               }

               var7.setPipeline(uvq.BLUR_COPY);
               var7.bindTexture("InSampler", var2.method_71639(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
               var7.draw(0, 3);
            } catch (Throwable var13) {
               if (var7 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var11) {
                     var13.addSuppressed(var11);
                  }
               }

               throw var13;
            }

            if (var7 != null) {
               var7.close();
            }

            umq(var0, var1, var4);
            umt(var6, 0, var2.field_1482, var2.field_1481, 0.0F);
            var7 = var6.createRenderPass(() -> "Flow2 fx fade", var2.method_71639(), OptionalInt.empty());

            try {
               if (!ull) {
                  uml(var7, ulj, 4.0F, 1.0F, var2.field_1482, var2.field_1481);
               }

               var7.setPipeline(uku);
               var7.bindTexture("OutlineSampler", var3.method_71639(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
               var7.bindTexture("OutlineDepthSampler", var3.method_71640(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
               var7.bindTexture("DepthSampler", var2.method_71640(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
               var7.bindTexture("BackSampler", uly, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
               var7.setUniform("FlowFx", uls[0]);
               var7.draw(0, 3);
            } catch (Throwable var12) {
               if (var7 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var10) {
                     var12.addSuppressed(var10);
                  }
               }

               throw var12;
            }

            if (var7 != null) {
               var7.close();
            }
         } catch (Throwable var14) {
            ulh = true;
            System.out.println("entity fx fade failed, turned off: " + var14);
         }
      }
   }

   private static void umq(MinecraftClient var0, List<EntityRenderState> var1, @Nullable RenderDispatcher var2) {
      if (var2 != null) {
         CameraRenderState var3 = ulf;
         MatrixStack var4 = new MatrixStack();

         for (EntityRenderState var6 : var1) {
            var0.method_1561()
               .method_72976(
                  var6,
                  var3,
                  var6.field_53325 - var3.field_63078.field_1352,
                  var6.field_53326 - var3.field_63078.field_1351,
                  var6.field_53327 - var3.field_63078.field_1350,
                  var4,
                  var2.method_73003()
               );
         }

         var2.method_73002();
         var0.method_22940().method_23000().method_22993();
         var0.method_22940().method_23003().method_23285();
      }
   }

   public static void endMain() {
      if (uld != 0 && !ulh) {
         MinecraftClient var0 = MinecraftClient.method_1551();
         Framebuffer var1 = var0.method_1522();
         Framebuffer var2 = var0.field_1769 == null ? null : umz(var0.field_1769);
         if (var2 != null && var2.method_30277() != null && var1.method_71639() != null) {
            try {
               GpuDevice var3 = RenderSystem.getDevice();
               CommandEncoder var4 = var3.createCommandEncoder();
               if (devMode != 1 && uvq.ensure(ukq) && uvq.ensure(ukr) && uvq.ensure(uks) && uvq.ensure(ukt)) {
                  umx(var3, var1.field_1482, var1.field_1481);
                  float var5 = (float)(System.nanoTime() / 1000000L % 3600000L) / 1000.0F;

                  for (int var6 = 0; var6 < 5; var6++) {
                     uki var7 = ukv[var6];
                     if (var7.visible() && (var6 != 3 || ule)) {
                        umt(var4, var6, var1.field_1482, var1.field_1481, var5);
                        umr(var4, var6, var7, var2.method_71639(), var1.method_71639(), var1.field_1482, var1.field_1481);
                     }
                  }
               }

               var4.clearColorTexture(var2.method_30277(), 0);
            } catch (Throwable var11) {
               ulh = true;
               System.out.println("entity fx failed, turned off: " + var11);
            } finally {
               uld = 0;
            }
         }
      }
   }

   private static void umr(CommandEncoder var0, int var1, uki var2, GpuTextureView var3, GpuTextureView var4, int var5, int var6) {
      int var7 = Math.max(2, Math.min(4, 2 + Math.round(var2.spread * 2.0F)));
      float var8 = (4 << var7) + Math.min(var2.width * Math.max(1.0F, var6 / 1080.0F), 6.0F) + 4.0F;
      if (!ulk) {
         var0.clearColorTexture(ult[0], 0);
      }

      RenderPass var9 = var0.createRenderPass(() -> "Flow2 fx mask", ulu[0], OptionalInt.empty());

      try {
         if (!ulk) {
            uml(var9, uli, var8, 0.5F, Math.max(1, var5 / 2), Math.max(1, var6 / 2));
         }

         var9.setPipeline(ukq);
         var9.bindTexture("OutlineSampler", var3, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
         var9.setUniform("FlowFx", uls[var1]);
         var9.draw(0, 3);
      } catch (Throwable var16) {
         if (var9 != null) {
            try {
               var9.close();
            } catch (Throwable var14) {
               var16.addSuppressed(var14);
            }
         }

         throw var16;
      }

      if (var9 != null) {
         var9.close();
      }

      for (int var17 = 1; var17 <= var7; var17++) {
         ums(var0, ukr, ulu[var17 - 1], ulu[var17]);
      }

      GpuTextureView var18 = ulu[var7];

      for (int var10 = var7 - 1; var10 >= 0; var10--) {
         ums(var0, uks, var18, ulw[var10]);
         var18 = ulw[var10];
      }

      RenderPass var19 = var0.createRenderPass(() -> "Flow2 fx composite", var4, OptionalInt.empty());

      try {
         if (!ulk) {
            uml(var19, uli, var8, 1.0F, var5, var6);
         }

         var19.setPipeline(ukt);
         var19.bindTexture("OutlineSampler", var3, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
         var19.bindTexture("GlowSampler", var18, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
         var19.setUniform("FlowFx", uls[var1]);
         var19.draw(0, 3);
      } catch (Throwable var15) {
         if (var19 != null) {
            try {
               var19.close();
            } catch (Throwable var13) {
               var15.addSuppressed(var13);
            }
         }

         throw var15;
      }

      if (var19 != null) {
         var19.close();
      }
   }

   private static void ums(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, GpuTextureView var3) {
      RenderPass var4 = var0.createRenderPass(() -> "Flow2 fx glow", var3, OptionalInt.empty());

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

   private static void umt(CommandEncoder var0, int var1, int var2, int var3, float var4) {
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

   private static float umu(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   private static float umv(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   private static float umw(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private static void umx(GpuDevice var0, int var1, int var2) {
      for (int var3 = 0; var3 < 5; var3++) {
         if (uls[var3] == null) {
            uls[var3] = var0.createBuffer(() -> "Flow2 fx " + var3, 136, 4144L);
         }
      }

      if (uly == null || var1 != ulz || var2 != uma) {
         umy();
         byte var7 = 12;
         ulx = var0.createTexture(() -> "Flow2 fx back", var7, TextureFormat.RGBA8, var1, var2, 1, 1);
         uly = var0.createTextureView(ulx);

         for (int var4 = 0; var4 < 5; var4++) {
            int var5 = 2 << var4;
            int var6 = var4;
            ult[var4] = var0.createTexture(() -> "Flow2 fx down " + var6, var7, TextureFormat.RGBA8, Math.max(1, var1 / var5), Math.max(1, var2 / var5), 1, 1);
            ulu[var4] = var0.createTextureView(ult[var4]);
            if (var4 < 4) {
               ulv[var4] = var0.createTexture(() -> "Flow2 fx up " + var6, var7, TextureFormat.RGBA8, Math.max(1, var1 / var5), Math.max(1, var2 / var5), 1, 1);
               ulw[var4] = var0.createTextureView(ulv[var4]);
            }
         }

         ulz = var1;
         uma = var2;
      }
   }

   private static void umy() {
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

   @Nullable
   private static Framebuffer umz(WorldRenderer var0) {
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

   @Nullable
   private static RenderDispatcher una(WorldRenderer var0) throws IllegalAccessException {
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

   private static boolean unb(boolean var0) {
      if (!umd && var0 != umc) {
         try {
            if (umb == null) {
               umb = unc();
            }

            for (RenderPipeline var4 : new RenderPipeline[]{RenderPipelines.field_56842, RenderPipelines.field_56843}) {
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

   private static Field[] unc() throws ReflectiveOperationException {
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

   private static RenderPipeline und(boolean var0) {
      return RenderPipeline.builder(new Snippet[0])
         .withLocation(uvq.id("pipeline/probe_" + var0))
         .withVertexShader(uvq.id("core/blur"))
         .withFragmentShader(uvq.id("core/blur_copy"))
         .withDepthWrite(var0)
         .withVertexFormat(VertexFormats.field_60033, DrawMode.field_27379)
         .build();
   }

   private static RenderPipeline une(String var0, @Nullable BlendFunction var1, String... var2) {
      Builder var3 = RenderPipeline.builder(new Snippet[0])
         .withLocation(uvq.id("pipeline/" + var0))
         .withVertexShader(uvq.id("core/blur"))
         .withFragmentShader(uvq.id("core/" + var0))
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(VertexFormats.field_60033, DrawMode.field_27379);

      for (String var7 : var2) {
         var3.withSampler(var7);
      }

      if (!var0.equals("fx_down") && !var0.equals("fx_up")) {
         var3.withUniform("FlowFx", UniformType.field_60031);
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
