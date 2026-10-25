package a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;

public final class vdn {
   private static float vdo = 1.0F;
   private static final int vdp = 10;
   private final String vdq;
   private final Supplier<Font> vdr;
   private final float vds;
   private final String vdt;
   private final boolean vdu;
   private final Map<Integer, vfk> vdv = new LinkedHashMap<>(8, 0.75F, true);
   private final StringBuilder vdw = new StringBuilder();
   private final List<vdi> vdx = new ArrayList<>();
   private boolean vdy;

   vdn(String var1, Supplier<Font> var2, float var3, String var4, boolean var5) {
      this.vdq = var1;
      this.vdr = var2;
      this.vds = var3;
      this.vdt = var4;
      this.vdu = var5;
   }

   public static void setRenderScale(float var0) {
      vdo = Math.max(0.25F, var0);
   }

   public static void setRenderScaleStepped(float var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      int var2 = var1.getWindow() != null ? Math.max(1, var1.getWindow().getScaleFactor()) : 2;
      float var3 = Math.max(0.5F, Math.round(var0 * var2 * 2.0F) / 2.0F);
      setRenderScale(var3 / var2);
   }

   public static float renderScale() {
      return vdo;
   }

   public float size() {
      return this.vds;
   }

   public float ascent() {
      vfk var1 = this.ved();
      return var1 != null ? var1.ascent : 7.0F;
   }

   public float descent() {
      vfk var1 = this.ved();
      return var1 != null ? var1.descent : 2.0F;
   }

   public float height() {
      vfk var1 = this.ved();
      return var1 != null ? var1.ascent + var1.descent : 9.0F;
   }

   public float capHeight() {
      vfk var1 = this.ved();
      return var1 != null ? var1.capHeight : 7.0F;
   }

   public float centerTop(float var1) {
      vfk var2 = this.ved();
      return var2 == null ? var1 - 4.0F : var1 + var2.capHeight * 0.5F - var2.ascent;
   }

   public float width(String var1) {
      return this.width(var1, 0.0F);
   }

   public boolean canDisplay(int var1) {
      vfk var2 = this.ved();
      return var2 != null && (var2.has(var1) || var2.canDisplay(var1));
   }

   public float width(String var1, float var2) {
      if (var1 != null && !var1.isEmpty()) {
         vfk var3 = RenderSystem.isOnRenderThread() ? this.vec(var1) : this.ved();
         if (var3 == null) {
            return vej().getWidth(var1);
         }

         float var4 = 0.0F;
         int var5 = 0;
         int var6 = 0;

         while (var6 < var1.length()) {
            int var7 = var1.codePointAt(var6);
            var6 += Character.charCount(var7);
            vev var8 = var3.glyph(var7);
            if (var8 != null) {
               var4 += var8.advance();
               var5++;
            }
         }

         return var4 + var2 * Math.max(0, var5 - 1);
      } else {
         return 0.0F;
      }
   }

   public String ellipsize(String var1, float var2) {
      if (this.width(var1) <= var2) {
         return var1;
      }

      String var3 = "…";
      float var4 = var2 - this.width(var3);
      StringBuilder var5 = new StringBuilder();
      float var6 = 0.0F;
      int var7 = 0;

      while (var7 < var1.length()) {
         int var8 = var1.codePointAt(var7);
         String var9 = new String(Character.toChars(var8));
         float var10 = this.width(var9);
         if (var6 + var10 > var4) {
            break;
         }

         var5.append(var9);
         var6 += var10;
         var7 += Character.charCount(var8);
      }

      return var5.toString().stripTrailing() + var3;
   }

   public float draw(DrawContext var1, String var2, float var3, float var4, int var5) {
      return this.draw(var1, var2, var3, var4, var5, var5, 0.0F);
   }

   public float drawCentered(DrawContext var1, String var2, float var3, float var4, int var5) {
      return this.draw(var1, var2, var3 - this.width(var2) * 0.5F, var4, var5);
   }

   public float drawRight(DrawContext var1, String var2, float var3, float var4, int var5) {
      return this.draw(var1, var2, var3 - this.width(var2), var4, var5);
   }

   public float drawGradient(DrawContext var1, String var2, float var3, float var4, int var5, int var6) {
      return this.draw(var1, var2, var3, var4, var5, var6, 0.0F);
   }

   public float drawTracked(DrawContext var1, String var2, float var3, float var4, int var5, float var6) {
      return this.draw(var1, var2, var3, var4, var5, var5, var6);
   }

   public void drawGlyphCentered(DrawContext var1, String var2, float var3, float var4, int var5) {
      vfk var6 = this.vec(var2);
      vev var7 = var6 != null ? var6.glyph(var2.codePointAt(0)) : null;
      if (var7 != null && !(var7.w() <= 0.0F)) {
         float var8 = var3 - var7.ox() - var7.w() * 0.5F;
         float var9 = var4 - var7.oy() - var7.h() * 0.5F;
         this.draw(var1, var2, var8, var9 - var6.ascent, var5);
      } else {
         this.drawCentered(var1, var2, var3, this.centerTop(var4), var5);
      }
   }

   public float draw(DrawContext var1, String var2, float var3, float var4, int var5, int var6, float var7) {
      if (var2 != null && !var2.isEmpty()) {
         unf.observe(var1);
         this.veh();
         vfk var8 = this.vec(var2);
         if (var8 == null) {
            return this.vei(var1, var2, var3, var4, var5);
         }

         int var9 = uut.fade(var5);
         int var10 = uut.fade(var6);
         float var11 = this.width(var2, var7);
         if ((var9 | var10) >>> 24 == 0) {
            return var3 + var11;
         }

         float var12 = var8.pixelsPerUnit;
         float var13 = veb(var4 + var8.ascent, var12);
         int var14 = var2.codePointCount(0, var2.length());
         float[] var15 = new float[var14 * 8];
         int[] var16 = new int[var14];
         int var17 = 0;
         float var18 = var3;
         float var19 = Float.MAX_VALUE;
         float var20 = Float.MAX_VALUE;
         float var21 = -Float.MAX_VALUE;
         float var22 = -Float.MAX_VALUE;
         boolean var23 = var9 != var10 && var11 > 0.0F;
         int var24 = 0;

         while (var24 < var2.length()) {
            int var25 = var2.codePointAt(var24);
            var24 += Character.charCount(var25);
            vev var26 = var8.glyph(var25);
            if (var26 != null) {
               if (var26.w() > 0.0F) {
                  float var27 = veb(var18 + var26.ox(), var12);
                  float var28 = var13 + var26.oy();
                  int var29 = var17 * 8;
                  var15[var29] = var27;
                  var15[var29 + 1] = var28;
                  var15[var29 + 2] = var27 + var26.w();
                  var15[var29 + 3] = var28 + var26.h();
                  var15[var29 + 4] = var26.u0();
                  var15[var29 + 5] = var26.v0();
                  var15[var29 + 6] = var26.u1();
                  var15[var29 + 7] = var26.v1();
                  var16[var17] = var23 ? ujt.lerp(var9, var10, (var18 + var26.advance() * 0.5F - var3) / var11) : var9;
                  var19 = Math.min(var19, var27);
                  var20 = Math.min(var20, var28);
                  var21 = Math.max(var21, var27 + var26.w());
                  var22 = Math.max(var22, var28 + var26.h());
                  var17++;
               }

               var18 += var26.advance() + var7;
            }
         }

         if (var17 == 0) {
            return var3 + var11;
         }

         Matrix3x2f var30 = new Matrix3x2f(var1.getMatrices());
         ScreenRect var31 = uut.scissor();
         ScreenRect var32 = uut.bounds(var30, var19, var20, var21, var22, var31);
         if (var32 != null) {
            TextureSetup var33 = TextureSetup.of(var8.view, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
            uut.submit(var1, new vfw(var33, var30, var15, var16, var17, var31, var32));
         }

         return var3 + var11;
      } else {
         return var3;
      }
   }

   private static float veb(float var0, float var1) {
      return Math.round(var0 * var1) / var1;
   }

   private vfk vec(String var1) {
      vfk var2 = this.ved();
      if (var2 == null) {
         return null;
      }

      boolean var3 = false;
      int var4 = 0;

      while (var4 < var1.length()) {
         int var5 = var1.codePointAt(var4);
         var4 += Character.charCount(var5);
         if (!var2.has(var5) && var2.canDisplay(var5) && this.vdw.indexOf(new String(Character.toChars(var5))) < 0) {
            this.vdw.appendCodePoint(var5);
            var3 = true;
         }
      }

      if (var3) {
         this.veg(this.vdv.remove(vee(var2.pixelsPerUnit)));
         var2 = this.ved();
      }

      return var2;
   }

   private vfk ved() {
      if (this.vdy) {
         return null;
      }

      float var1 = vef();
      int var2 = vee(var1);
      vfk var3 = this.vdv.get(var2);
      if (var3 != null) {
         return var3;
      }

      if (!RenderSystem.isOnRenderThread()) {
         return null;
      }

      try {
         Font var4 = this.vdr.get();
         if (var4 == null) {
            throw new IllegalStateException("font face unavailable");
         }

         var3 = vfk.build(this.vdq, var4, this.vds, var1, this.vdt + this.vdw, this.vdu);
      } catch (Throwable var5) {
         this.vdy = true;
         System.out.println("font " + this.vdq + " unavailable, using vanilla text: " + var5);
         return null;
      }

      this.vdv.put(var2, var3);

      while (this.vdv.size() > 10) {
         Iterator var7 = this.vdv.entrySet().iterator();
         this.veg((vfk)((Entry)var7.next()).getValue());
         var7.remove();
      }

      return var3;
   }

   private static int vee(float var0) {
      return Math.round(var0 * 100.0F);
   }

   private static float vef() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      int var1 = var0.getWindow() != null ? var0.getWindow().getScaleFactor() : 2;
      return Math.max(1, var1) * vdo;
   }

   private void veg(vfk var1) {
      if (var1 != null) {
         this.vdx.add(new vdi(var1, unf.frame()));
      }
   }

   private void veh() {
      if (!this.vdx.isEmpty()) {
         long var1 = unf.frame();
         this.vdx.removeIf(var2 -> {
            if (var1 - var2.vdk > 2L) {
               var2.vdj.close();
               return true;
            } else {
               return false;
            }
         });
      }
   }

   private float vei(DrawContext var1, String var2, float var3, float var4, int var5) {
      TextRenderer var6 = vej();
      var1.drawText(var6, var2, Math.round(var3), Math.round(var4 + (this.height() - 8.0F) * 0.5F), uut.fade(var5), false);
      return var3 + var6.getWidth(var2);
   }

   private static TextRenderer vej() {
      return MinecraftClient.getInstance().textRenderer;
   }
}
