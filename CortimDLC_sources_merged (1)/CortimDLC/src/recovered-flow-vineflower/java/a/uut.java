package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.jspecify.annotations.Nullable;

public final class uut {
   static final ScreenRect uuu = new ScreenRect(0, 0, 0, 0);
   static final Deque<ScreenRect> uuv = new ArrayDeque<>();
   static final Deque<Float> uuw = new ArrayDeque<>();
   static float uux = 1.0F;
   static boolean uuy;
   static Field uuz;
   static boolean uva;
   static @Nullable DrawContext uvb;
   static @Nullable GuiRenderState uvc;
   static final List<uhx> uvd = new ArrayList<>();
   static int uve;
   static @Nullable GuiRenderState uvf;
   public static final int COSMOS = 0;
   public static final int WINTER = 1;
   public static final int LAVA = 2;
   public static final int AURORA = 3;
   public static final int OCEAN = 4;
   public static final int NEON = 5;
   public static final int SAKURA = 6;
   public static final int PLAIN = 7;
   public static final int FACE = 1;
   public static final int DISC = 2;

   uut() {
   }

   public static void beginBatch() {
      uve++;
   }

   public static void endBatch() {
      if (uve > 0 && --uve == 0) {
         uvj();
      }
   }

   static void uvi(GuiRenderState var0, SimpleGuiElementRenderState var1) {
      if (uve == 0) {
         var0.addSimpleElement(var1);
      } else {
         if (uvf != var0) {
            uvj();
            uvf = var0;
         }

         int var2 = 0;

         for (int var3 = uvd.size(); var2 < var3; var2++) {
            uhx var4 = uvd.get(var2);
            if (var4.accepts(var1)) {
               var4.add(var1);
               return;
            }
         }

         uvd.add(new uhx(var1));
      }
   }

   static void uvj() {
      GuiRenderState var0 = uvf;
      if (var0 != null) {
         for (uhx var2 : uvd) {
            if (!var2.isEmpty()) {
               var0.addSimpleElement(var2);
            }
         }
      }

      uvd.clear();
      uvf = null;
   }

   public static void pushAlpha(float var0) {
      uuw.push(uux);
      uux = uux * MathHelper.clamp(var0, 0.0F, 1.0F);
   }

   public static void popAlpha() {
      uux = uuw.isEmpty() ? 1.0F : uuw.pop();
   }

   public static float alpha() {
      return uux;
   }

   public static int fade(int var0) {
      if (uux >= 0.999F) {
         return var0;
      }

      int var1 = Math.round((var0 >>> 24 & 0xFF) * uux);
      return var1 << 24 | var0 & 16777215;
   }

   public static void pushScissor(DrawContext var0, float var1, float var2, float var3, float var4) {
      int var5 = MathHelper.floor(var1);
      int var6 = MathHelper.floor(var2);
      int var7 = MathHelper.ceil(var1 + var3);
      int var8 = MathHelper.ceil(var2 + var4);
      ScreenRect var9 = new ScreenRect(var5, var6, Math.max(0, var7 - var5), Math.max(0, var8 - var6)).transformEachVertex(var0.getMatrices());
      ScreenRect var10 = uuv.peek();
      ScreenRect var11 = var10 == null ? var9 : var10.intersection(var9);
      uuv.push(var11 == null ? uuu : var11);
      var0.enableScissor(var5, var6, var7, var8);
   }

   public static void popScissor(DrawContext var0) {
      if (!uuv.isEmpty()) {
         uuv.pop();
         var0.disableScissor();
      }
   }

   public static @Nullable ScreenRect scissor() {
      return uuv.peek();
   }

   public static void beginFrame() {
      if (uve > 0) {
         uve = 0;
         uvj();
      }

      uuv.clear();
      uuw.clear();
      uux = 1.0F;
      uuy = false;
   }

   public static void additive(boolean var0) {
      uuy = var0;
   }

   public static void sprite(DrawContext var0, GpuTextureView var1, float var2, float var3, float var4, int var5) {
      image(var0, var1, var2 - var4 * 0.5F, var3 - var4 * 0.5F, var4, var4, 0.0F, var5);
   }

   public static void rect(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, 0.0F, 0.0F, 0.0F, 0.0F, var5, var5, var5, var5, 0.0F, 0.0F);
   }

   public static void round(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var5, var5, var5, var6, var6, var6, var6, 0.0F, 0.0F);
   }

   public static void round(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var6, var7, var8, var9, var9, var9, var9, 0.0F, 0.0F);
   }

   public static void gradient(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var5, var5, var5, var6, var7, var8, var9, 0.0F, 0.0F);
   }

   public static void gradient(
      DrawContext var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      int var11,
      int var12
   ) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, 0.0F, 0.0F);
   }

   public static void gradientH(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      gradient(var0, var1, var2, var3, var4, var5, var6, var7, var7, var6);
   }

   public static void gradientV(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      gradient(var0, var1, var2, var3, var4, var5, var6, var6, var7, var7);
   }

   public static void outline(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var5, var5, var5, var7, var7, var7, var7, 0.0F, Math.max(0.05F, var6));
   }

   public static void outlineGradientH(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var5, var5, var5, var7, var8, var8, var7, 0.0F, Math.max(0.05F, var6));
   }

   public static void outlineGradientV(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8) {
      uvl(var0, uvq.RECT, TextureSetup.empty(), var1, var2, var3, var4, var5, var5, var5, var5, var7, var7, var8, var8, 0.0F, Math.max(0.05F, var6));
   }

   public static boolean arc(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10) {
      if (!(var6 <= 5.0E-4F) && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         int var11 = fade(var7);
         int var12 = fade(var8);
         int var13 = fade(var9);
         int var14 = fade(var10);
         if ((var11 | var12 | var13 | var14) >>> 24 == 0) {
            return true;
         }

         if (!uvq.ensure(uvq.ARC)) {
            return false;
         }

         float var15 = var5 - (float)Math.floor(var5);
         int var16 = Math.round(var15 * 65535.0F) & 65535;
         int var17 = Math.round(Math.min(1.0F, var6) * 65535.0F) & 65535;
         return uvo(
            var0,
            uvq.ARC,
            TextureSetup.empty(),
            var1 - var3,
            var2 - var3,
            var3 * 2.0F,
            var3 * 2.0F,
            var16,
            var17,
            var11,
            var12,
            var13,
            var14,
            0.0F,
            utx.pad(0.0F),
            var4
         );
      } else {
         return true;
      }
   }

   public static boolean arc(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      return arc(var0, var1, var2, var3, var4, var5, var6, var7, var7, var7, var7);
   }

   public static void shadow(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      uvl(
         var0,
         uvq.RECT,
         TextureSetup.empty(),
         var1,
         var2,
         var3,
         var4,
         var5 + var6 * 0.5F,
         var5 + var6 * 0.5F,
         var5 + var6 * 0.5F,
         var5 + var6 * 0.5F,
         var7,
         var7,
         var7,
         var7,
         Math.max(0.5F, var6),
         0.0F
      );
   }

   public static void line(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      uvk(var0, var1, var2, var3, var4, var5, 0.0F, var6);
   }

   public static void softLine(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      uvk(var0, var1, var2, var3, var4, var5, Math.max(0.5F, var6), var7);
   }

   static void uvk(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      float var8 = var3 - var1;
      float var9 = var4 - var2;
      float var10 = (float)Math.sqrt(var8 * var8 + var9 * var9);
      float var11 = var5 * 0.5F;
      int var12 = fade(var7);
      if (var12 >>> 24 != 0) {
         RenderPipeline var13 = uuy ? uvq.RECT_ADD : uvq.RECT;
         if (uvq.ensure(var13)) {
            Matrix3x2f var14 = new Matrix3x2f(var0.getMatrices()).translate(var1, var2);
            if (var10 > 0.001F) {
               var14.rotate((float)Math.atan2(var9, var8));
            }

            float var15 = var6 > 0.0F ? Math.max(0.5F, var6) : 0.0F;
            float var16 = var11 + var15 * 0.5F;
            uvn(
               var0,
               var14,
               var13,
               TextureSetup.empty(),
               -var11,
               -var11,
               var10 + var5,
               var5,
               var16,
               var16,
               var16,
               var16,
               var12,
               var12,
               var12,
               var12,
               var15,
               utx.pad(var15),
               0.0F
            );
         } else {
            var0.getMatrices().pushMatrix();
            var0.getMatrices().translate(var1, var2);
            if (var10 > 0.001F) {
               var0.getMatrices().rotate((float)Math.atan2(var9, var8));
            }

            if (var6 > 0.0F) {
               shadow(var0, -var11, -var11, var10 + var5, var5, var11, var6, var7);
            } else {
               round(var0, -var11, -var11, var10 + var5, var5, var11, var7);
            }

            var0.getMatrices().popMatrix();
         }
      }
   }

   public static void circle(DrawContext var0, float var1, float var2, float var3, int var4) {
      round(var0, var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F, var3, var4);
   }

   public static void circleOutline(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {
      outline(var0, var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F, var3, var4, var5);
   }

   public static boolean glass(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, float var7) {
      return glass(var0, uij.SCENE.result(var0), var1, var2, var3, var4, var5, var6, var7);
   }

   public static boolean glass(
      DrawContext var0, @Nullable GpuTextureView var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8
   ) {
      if (var1 == null) {
         return false;
      }

      float var9 = MathHelper.clamp(var8 * uux, 0.0F, 1.0F);
      if (var9 <= 0.002F || var4 <= 0.0F || var5 <= 0.0F) {
         return true;
      }

      if (!uvq.ensure(uvq.GLASS)) {
         return false;
      }

      TextureSetup var10 = TextureSetup.of(var1, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
      return uvm(var0, uvq.GLASS, var10, var2, var3, var4, var5, var6, var6, var6, var6, var7, var7, var7, var7, 0.0F, utx.pad(0.0F), var9);
   }

   public static boolean liquid(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, float var7, uoy var8) {
      return liquid(var0, uij.SCENE.result(var0), var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static boolean liquid(
      DrawContext var0, @Nullable GpuTextureView var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8, uoy var9
   ) {
      if (var1 == null) {
         return false;
      }

      float var10 = MathHelper.clamp(var8 * uux, 0.0F, 1.0F);
      if (var10 <= 0.004F || var4 <= 0.0F || var5 <= 0.0F) {
         return true;
      }

      if (!uvq.ensure(uvq.LIQUID)) {
         return glass(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      }

      TextureSetup var11 = TextureSetup.of(var1, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
      float var12 = Math.min(var4, var5) * 0.5F;
      return uvm(
         var0,
         uvq.LIQUID,
         var11,
         var2,
         var3,
         var4,
         var5,
         var6,
         var6,
         var6,
         var6,
         var7,
         var7,
         var7,
         var7,
         var9.packShape(var12),
         utx.pad(0.0F),
         var9.packLight(var10)
      );
   }

   public static void image(DrawContext var0, GpuTextureView var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      int var8 = fade(var7);
      RenderPipeline var9 = uuy ? uvq.IMAGE_ADD : uvq.IMAGE;
      if (var8 >>> 24 != 0 && !(var4 <= 0.0F) && !(var5 <= 0.0F) && uvq.ensure(var9)) {
         TextureSetup var10 = TextureSetup.of(var1, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
         uvm(var0, var9, var10, var2, var3, var4, var5, var6, var6, var6, var6, var8, var8, var8, var8, 0.0F, utx.pad(0.0F), 0.0F);
      }
   }

   public static void imageRegion(
      DrawContext var0,
      GpuTextureView var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      boolean var12
   ) {
      int var13 = fade(var11);
      if (var13 >>> 24 != 0 && !(var4 <= 0.0F) && !(var5 <= 0.0F) && uvq.ensure(uvq.IMAGE)) {
         int var14 = Math.max(0, Math.min(4095, Math.round(var7 * 4095.0F)));
         int var15 = Math.max(0, Math.min(4095, Math.round(var8 * 4095.0F)));
         int var16 = Math.max(1, Math.min(4095, Math.round((var9 - var7) * 4095.0F)));
         int var17 = Math.max(1, Math.min(4095, Math.round((var10 - var8) * 4095.0F)));
         TextureSetup var18 = TextureSetup.of(var1, RenderSystem.getSamplerCache().get(var12 ? FilterMode.NEAREST : FilterMode.LINEAR));
         uvm(
            var0,
            uvq.IMAGE,
            var18,
            var2,
            var3,
            var4,
            var5,
            var6,
            var6,
            var6,
            var6,
            var13,
            var13,
            var13,
            var13,
            var14 << 12 | var15,
            utx.pad(0.0F),
            var16 << 12 | var17
         );
      }
   }

   public static void quad(
      DrawContext var0,
      float var1,
      float var2,
      int var3,
      float var4,
      float var5,
      int var6,
      float var7,
      float var8,
      int var9,
      float var10,
      float var11,
      int var12
   ) {
      int var13 = fade(var3);
      int var14 = fade(var6);
      int var15 = fade(var9);
      int var16 = fade(var12);
      if ((var13 | var14 | var15 | var16) >>> 24 != 0) {
         RenderPipeline var17 = uuy ? uvq.QUAD_ADD : uvq.QUAD;
         GuiRenderState var18 = state(var0);
         if (var18 != null && uvq.ensure(var17)) {
            Matrix3x2fStack var19 = var0.getMatrices();
            float var20 = var19.m00() * var1 + var19.m10() * var2 + var19.m20();
            float var21 = var19.m01() * var1 + var19.m11() * var2 + var19.m21();
            float var22 = var19.m00() * var4 + var19.m10() * var5 + var19.m20();
            float var23 = var19.m01() * var4 + var19.m11() * var5 + var19.m21();
            float var24 = var19.m00() * var7 + var19.m10() * var8 + var19.m20();
            float var25 = var19.m01() * var7 + var19.m11() * var8 + var19.m21();
            float var26 = var19.m00() * var10 + var19.m10() * var11 + var19.m20();
            float var27 = var19.m01() * var10 + var19.m11() * var11 + var19.m21();
            int var28 = MathHelper.floor(Math.min(Math.min(var20, var22), Math.min(var24, var26)));
            int var29 = MathHelper.floor(Math.min(Math.min(var21, var23), Math.min(var25, var27)));
            int var30 = MathHelper.ceil(Math.max(Math.max(var20, var22), Math.max(var24, var26)));
            int var31 = MathHelper.ceil(Math.max(Math.max(var21, var23), Math.max(var25, var27)));
            if (var30 > var28 && var31 > var29) {
               ScreenRect var32 = uuv.peek();
               ScreenRect var33 = new ScreenRect(var28, var29, var30 - var28, var31 - var29);
               if (var32 != null) {
                  var33 = var32.intersection(var33);
                  if (var33 == null) {
                     return;
                  }
               }

               uvi(var18, new utf(var17, var20, var21, var22, var23, var24, var25, var26, var27, var13, var14, var15, var16, var32, var33));
            }
         }
      }
   }

   public static void pattern(DrawContext var0, float[] var1, int var2, int var3, int var4, int var5, float var6, float var7) {
      int var8 = fade(var4);
      if (var8 >>> 24 != 0) {
         RenderPipeline var9 = uuy ? uvq.PATTERN_ADD : uvq.PATTERN;
         GuiRenderState var10 = state(var0);
         if (var10 != null && uvq.ensure(var9)) {
            Matrix3x2fStack var11 = var0.getMatrices();
            float[] var12 = new float[20];
            float var13 = Float.MAX_VALUE;
            float var14 = Float.MAX_VALUE;
            float var15 = -Float.MAX_VALUE;
            float var16 = -Float.MAX_VALUE;

            for (int var17 = 0; var17 < 4; var17++) {
               int var18 = var17 * 5;
               float var19 = var1[var18];
               float var20 = var1[var18 + 1];
               float var21 = var11.m00() * var19 + var11.m10() * var20 + var11.m20();
               float var22 = var11.m01() * var19 + var11.m11() * var20 + var11.m21();
               var12[var18] = var21;
               var12[var18 + 1] = var22;
               var12[var18 + 2] = var1[var18 + 2];
               var12[var18 + 3] = var1[var18 + 3];
               var12[var18 + 4] = var1[var18 + 4];
               var13 = Math.min(var13, var21);
               var14 = Math.min(var14, var22);
               var15 = Math.max(var15, var21);
               var16 = Math.max(var16, var22);
            }

            int var24 = MathHelper.floor(var13);
            int var25 = MathHelper.floor(var14);
            int var26 = MathHelper.ceil(var15);
            int var27 = MathHelper.ceil(var16);
            if (var26 > var24 && var27 > var25) {
               ScreenRect var28 = uuv.peek();
               ScreenRect var29 = new ScreenRect(var24, var25, var26 - var24, var27 - var25);
               if (var28 != null) {
                  var29 = var28.intersection(var29);
                  if (var29 == null) {
                     return;
                  }
               }

               float var23 = var7 % 3600.0F;
               uvi(var10, new urt(var9, var12, var8, var5, var2, var3, var6, var23, var28, var29));
            }
         }
      }
   }

   static boolean uvl(
      DrawContext var0,
      RenderPipeline var1,
      TextureSetup var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      int var14,
      float var15,
      float var16
   ) {
      if (!(var5 <= 0.0F) && !(var6 <= 0.0F)) {
         int var17 = fade(var11);
         int var18 = fade(var12);
         int var19 = fade(var13);
         int var20 = fade(var14);
         if ((var17 | var18 | var19 | var20) >>> 24 == 0) {
            return true;
         }

         if (uuy && var1 == uvq.RECT) {
            if (!uvq.ensure(uvq.RECT_ADD)) {
               return false;
            }

            var1 = uvq.RECT_ADD;
         }

         if (!uvq.ensure(var1)) {
            if (var1 == uvq.RECT && var15 == 0.0F) {
               uvp(var0, var3, var4, var5, var6, var17, var20, var16);
            }

            return false;
         } else {
            return uvm(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var17, var18, var19, var20, var15, utx.pad(var15), var16);
         }
      } else {
         return true;
      }
   }

   static boolean uvm(
      DrawContext var0,
      RenderPipeline var1,
      TextureSetup var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      int var14,
      float var15,
      float var16,
      float var17
   ) {
      return uvn(var0, null, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
   }

   static boolean uvn(
      DrawContext var0,
      @Nullable Matrix3x2f var1,
      RenderPipeline var2,
      TextureSetup var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12,
      int var13,
      int var14,
      int var15,
      float var16,
      float var17,
      float var18
   ) {
      GuiRenderState var19 = state(var0);
      if (var19 == null) {
         return false;
      }

      if (var1 == null) {
         var1 = new Matrix3x2f(var0.getMatrices());
      }

      ScreenRect var20 = uuv.peek();
      ScreenRect var21 = bounds(var1, var4 - var17, var5 - var17, var4 + var6 + var17, var5 + var7 + var17, var20);
      if (var21 == null) {
         return true;
      }

      float var22 = Math.min(var6, var7) * 0.5F;
      uvi(
         var19,
         new utx(
            var2,
            var3,
            var1,
            var4,
            var5,
            var6,
            var7,
            var12,
            var13,
            var14,
            var15,
            utx.packRadii(Math.min(var8, var22), Math.min(var9, var22)),
            utx.packRadii(Math.min(var10, var22), Math.min(var11, var22)),
            var16,
            var17,
            var18,
            var20,
            var21
         )
      );
      return true;
   }

   static boolean uvo(
      DrawContext var0,
      RenderPipeline var1,
      TextureSetup var2,
      float var3,
      float var4,
      float var5,
      float var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      float var13,
      float var14,
      float var15
   ) {
      GuiRenderState var16 = state(var0);
      if (var16 == null) {
         return false;
      }

      Matrix3x2f var17 = new Matrix3x2f(var0.getMatrices());
      ScreenRect var18 = uuv.peek();
      ScreenRect var19 = bounds(var17, var3 - var14, var4 - var14, var3 + var5 + var14, var4 + var6 + var14, var18);
      if (var19 == null) {
         return true;
      }

      uvi(var16, new utx(var1, var2, var17, var3, var4, var5, var6, var9, var10, var11, var12, var7, var8, var13, var14, var15, var18, var19));
      return true;
   }

   public static void submit(DrawContext var0, SimpleGuiElementRenderState var1) {
      GuiRenderState var2 = state(var0);
      if (var2 != null) {
         uvi(var2, var1);
      }
   }

   public static @Nullable ScreenRect bounds(Matrix3x2f var0, float var1, float var2, float var3, float var4, @Nullable ScreenRect var5) {
      int var6 = MathHelper.floor(var1);
      int var7 = MathHelper.floor(var2);
      int var8 = MathHelper.ceil(var3) - var6;
      int var9 = MathHelper.ceil(var4) - var7;
      if (var8 > 0 && var9 > 0) {
         ScreenRect var10 = new ScreenRect(var6, var7, var8, var9).transformEachVertex(var0);
         return var5 != null ? var5.intersection(var10) : var10;
      } else {
         return null;
      }
   }

   static void uvp(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6, float var7) {
      int var8 = Math.round(var1);
      int var9 = Math.round(var2);
      int var10 = Math.round(var1 + var3);
      int var11 = Math.round(var2 + var4);
      if (var7 > 0.0F) {
         var0.drawStrokedRectangle(var8, var9, var10 - var8, var11 - var9, var5);
      } else if (var5 == var6) {
         var0.fill(var8, var9, var10, var11, var5);
      } else {
         var0.fillGradient(var8, var9, var10, var11, var5, var6);
      }
   }

   static @Nullable GuiRenderState state(DrawContext var0) {
      if (uuz == null && !uva) {
         for (Field var4 : DrawContext.class.getDeclaredFields()) {
            if (var4.getType() == GuiRenderState.class) {
               var4.setAccessible(true);
               uuz = var4;
               break;
            }
         }

         if (uuz == null) {
            uva = true;
            System.out.println("DrawContext render state field not found");
         }
      }

      if (uuz == null) {
         return null;
      }

      if (var0 == uvb) {
         return uvc;
      }

      try {
         GuiRenderState var6 = (GuiRenderState)uuz.get(var0);
         uvb = var0;
         uvc = var6;
         return var6;
      } catch (IllegalAccessException var5) {
         return null;
      }
   }
}
