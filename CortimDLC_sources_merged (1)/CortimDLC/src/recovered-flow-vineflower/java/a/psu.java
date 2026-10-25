package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public final class psu {
   private static final float[] psv = new float[4];
   private static final float[] psw = new float[2];
   private static final double psx = 0.05;
   private static final double psy = 0.85;
   private static final double psz = 56.0;
   private static long pta = -1L;

   private psu() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (var2.field_1687 != null
         && var2.field_1724 != null
         && !var2.field_1690.field_1842
         && !dry.armed()
         && !(var2.field_1755 instanceof hlc)
         && pnf.visible()) {
         psf var3 = pnf.route();
         if (var3 != null && var3.track.n >= 2) {
            unf.observe(var0);
            if (unf.frame() != pta) {
               pta = unf.frame();

               usn var4;
               try {
                  var4 = usn.capture(var1.method_60637(true), var0.method_51421(), var0.method_51443());
               } catch (Throwable var36) {
                  return;
               }

               iov.update(unf.delta() * (float)iov.ANIMATION.get());
               boolean var5 = pnf.guiding();
               int var6 = iov.accent();
               int var7 = ujt.lerp(var6, -1, var5 ? 0.25F : 0.1F);
               float var8 = var5 ? 1.0F : 0.6F;
               tvt var9 = var3.track;
               double var10 = var5 ? 0.85 : 0.05;
               int var12 = Math.max(0, Math.min(var9.n - 2, pnf.at()));
               double var13 = var9.s[var12];
               uut.beginFrame();
               uut.beginBatch();

               try {
                  for (int var15 = var12; var15 + 1 < var9.n; var15++) {
                     double var16 = var9.s[var15] - var13;
                     if (var16 > 56.0) {
                        break;
                     }

                     double var18 = var9.x[var15];
                     double var20 = var9.y[var15] + var10;
                     double var22 = var9.z[var15];
                     double var24 = var9.x[var15 + 1];
                     double var26 = var9.y[var15 + 1] + var10;
                     double var28 = var9.z[var15 + 1];
                     if (var4.projectSegment(var18, var20, var22, var24, var26, var28, 0.15F, psv, psw)) {
                        float var30 = (float)Math.min(1.0, Math.min((var16 + 0.2) / 1.2, (56.0 - var16) / 12.0));
                        if (!(var30 <= 0.01F)) {
                           float var31 = var4.unitsPerBlock(var24, var26, var28);
                           float var32 = Math.max(1.0F, Math.min(2.6F, var31 * 0.035F));
                           uut.line(var0, psv[0], psv[1], psv[2], psv[3], var32 * 3.2F, ujt.withAlpha(var6, Math.round(46.0F * var30 * var8)));
                           uut.line(var0, psv[0], psv[1], psv[2], psv[3], var32, ujt.withAlpha(var7, Math.round(225.0F * var30 * var8)));
                           if ((var9.flag[var15 + 1] & 3) != 0 && (var9.flag[var15] & 3) == 0) {
                              ptd(var0, var4, var24, var26, var28, 0.22, ujt.withAlpha(-678620, Math.round(220.0F * var30 * var8)), var32);
                           }
                        }
                     }
                  }

                  int var38 = var9.n - 1;
                  if (var9.s[var38] - var13 <= 56.0
                     && var5
                     && var4.projectSegment(
                        var9.x[var38], var9.y[var38] + 0.05, var9.z[var38], var9.x[var38], var9.y[var38] + var10, var9.z[var38], 0.15F, psv, psw
                     )) {
                     uut.line(var0, psv[0], psv[1], psv[2], psv[3], 1.4F, ujt.withAlpha(var7, 200));
                  }

                  if (var9.s[var38] - var13 <= 56.0) {
                     ptd(var0, var4, var9.x[var38], var9.y[var38] + 0.05, var9.z[var38], 0.42, ujt.withAlpha(var7, Math.round(230.0F * var8)), 1.6F);
                     ptd(var0, var4, var9.x[var38], var9.y[var38] + 0.05, var9.z[var38], 0.16, ujt.withAlpha(var6, Math.round(200.0F * var8)), 1.2F);
                  }
               } finally {
                  uut.endBatch();
               }
            }
         }
      }
   }

   private static void ptd(DrawContext var0, usn var1, double var2, double var4, double var6, double var8, int var10, float var11) {
      byte var12 = 28;
      double var13 = var2 + var8;
      double var15 = var6;

      for (int var17 = 1; var17 <= var12; var17++) {
         double var18 = (Math.PI * 2) * var17 / var12;
         double var20 = var2 + Math.cos(var18) * var8;
         double var22 = var6 + Math.sin(var18) * var8;
         if (var1.projectSegment(var13, var4, var15, var20, var4, var22, 0.1F, psv, psw)) {
            float var24 = var1.unitsPerBlock(var20, var4, var22);
            float var25 = Math.max(1.0F, Math.min(2.4F, var24 * 0.03F)) * var11;
            uut.line(var0, psv[0], psv[1], psv[2], psv[3], var25, var10);
         }

         var13 = var20;
         var15 = var22;
      }
   }
}
