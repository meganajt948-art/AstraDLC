package a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;

public final class vjf {
   private static final float vjg = 1.8F;
   private static final float vjh = 1.15F;
   private static final int vji = 1;
   private static final int vjj = 12;
   private static final Map<Long, vjb> vjk = new LinkedHashMap<>(16, 0.75F, true);
   private static final List<viw> vjl = new ArrayList<>();
   private static boolean vjm;

   private vjf() {
   }

   public static void draw(DrawContext var0, vhz var1, float var2, float var3, float var4, int var5) {
      int var6 = uut.fade(var5);
      if (var6 >>> 24 != 0 && !(var4 <= 0.0F) && !vjm) {
         unf.observe(var0);
         vjr();
         float var7 = vjp();
         vjb var8 = vjq(var4, var7);
         if (var8 != null) {
            float var9 = var8.px / var7;
            float var10 = 1.0F / var7;
            float var11 = Math.round((var2 - var9 * 0.5F) * var7) / var7 - var10;
            float var12 = Math.round((var3 - var9 * 0.5F) * var7) / var7 - var10;
            float var13 = var11 + var9 + var10 * 2.0F;
            float var14 = var12 + var9 + var10 * 2.0F;
            int var15 = var1.ordinal();
            float[] var16 = var8.uv(var15);
            Matrix3x2f var17 = new Matrix3x2f(var0.getMatrices());
            ScreenRect var18 = uut.scissor();
            ScreenRect var19 = uut.bounds(var17, var11, var12, var13, var14, var18);
            if (var19 != null) {
               TextureSetup var20 = TextureSetup.of(var8.view, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
               float[] var21 = new float[]{var11, var12, var13, var14, var16[0], var16[1], var16[2], var16[3]};
               uut.submit(var0, new vfw(var20, var17, var21, new int[]{var6}, 1, var18, var19));
            }
         }
      }
   }

   private static float vjp() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      int var1 = var0.getWindow() != null ? var0.getWindow().getScaleFactor() : 2;
      return Math.max(1, var1) * vdn.renderScale();
   }

   private static vjb vjq(float var0, float var1) {
      int var2 = Math.max(6, Math.round(var0 * var1));
      vjb var3 = vjk.get((long)var2);
      if (var3 != null) {
         return var3;
      }

      if (!RenderSystem.isOnRenderThread()) {
         return null;
      }

      try {
         var3 = vjb.build(var2);
      } catch (Throwable var5) {
         vjm = true;
         System.out.println("icons unavailable: " + var5);
         return null;
      }

      vjk.put((long)var2, var3);

      while (vjk.size() > 12) {
         Long var4 = vjk.keySet().iterator().next();
         vjl.add(new viw(vjk.remove(var4), unf.frame()));
      }

      return var3;
   }

   private static void vjr() {
      if (!vjl.isEmpty()) {
         long var0 = unf.frame();
         vjl.removeIf(var2 -> {
            if (var0 - var2.viy > 2L) {
               var2.vix.close();
               return true;
            } else {
               return false;
            }
         });
      }
   }
}
