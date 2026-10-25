package a;

import flow.dev.a;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public final class wkw {
   static final vdn wkx = veo.semibold(6.8F);
   static final vdn wky = veo.medium(5.8F);
   static final float wkz = 20.0F;
   static final float wla = 0.41666666F;
   static final float wlb = 0.125F;
   static final Map<wkq, wkt> wlc = new IdentityHashMap<>();

   wkw() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (wlk.ENABLED.get() && var2.world != null && var2.player != null && !var2.options.hudHidden && !dry.armed()) {
         List var3 = wlk.drawable();
         if (var3.isEmpty()) {
            wlc.clear();
         } else {
            unf.observe(var0);
            float var4 = unf.delta();
            iov.update(var4 * (float)iov.ANIMATION.get());
            float var5 = var0.getScaledWindowWidth();
            float var6 = var0.getScaledWindowHeight();

            usn var7;
            try {
               var7 = usn.capture(var1.getTickProgress(true), var5, var6);
            } catch (Throwable var21) {
               return;
            }

            uut.beginFrame();
            float var8 = (float)wlk.SCALE.get();
            float[] var9 = new float[2];
            wlc.keySet().retainAll(var3);
            var3.sort((var1x, var2x) -> Double.compare(var7.distance(var2x.cx(), var2x.cy(), var2x.cz()), var7.distance(var1x.cx(), var1x.cy(), var1x.cz())));

            for (wkq var11 : var3) {
               wkt var12 = wlc.computeIfAbsent(var11, var0x -> new wkt());
               double var13 = var7.distance(var11.cx(), var11.cy(), var11.cz());
               boolean var15 = var7.project(var11.cx(), var11.cy(), var11.cz(), var9);
               boolean var16 = var15 && var9[0] > -20.0F && var9[0] < var5 + 20.0F && var9[1] > -20.0F && var9[1] < var6 + 20.0F;
               boolean var17 = var13 > 2.5;
               float var18 = var12.marker.step(var16 && var17, var4);
               boolean var19 = var16 && Math.hypot(var9[0] - var5 * 0.5F, var9[1] - (var6 * 0.5F + 20.0F * var8 * 0.3F)) < 18.0F * var8;
               float var20 = var12.focus.step(var19, var4);
               if (var18 > 0.01F && var15) {
                  wlf(var0, var11, var9[0], var9[1], var13, var18, var20, var8);
               }
            }
         }
      }
   }

   static void wlf(DrawContext var0, wkq var1, float var2, float var3, double var4, float var6, float var7, float var8) {
      float var9 = (float)Math.min(1.0, Math.max(0.3, (var4 - 1.5) / 4.0));
      float var10 = (float)Math.max(0.78, Math.min(1.06, 1.1 - Math.log10(Math.max(1.0, var4)) * 0.1));
      float var11 = vcq.outCubic(var6);
      int var12 = wlk.colorOf(var1);
      uut.pushAlpha(var6 * var9);
      float var13 = var10 * (1.0F + 0.1F * var7);
      float var14 = (1.0F - var11) * -5.0F - var7 * 1.5F;
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var2, var3);
      uut.shadow(var0, -3.0F * var13, -1.0F * var13, 6.0F * var13, 2.0F * var13, 1.0F * var13, 2.5F * var13, 1174405120);
      var0.getMatrices().translate(0.0F, var14);
      var0.getMatrices().scale(var13, var13);
      pin(var0, 0.0F, -20.0F * var8 * 0.41666666F, 20.0F * var8, var12, 0.8F + 0.2F * var7);
      var0.getMatrices().popMatrix();
      wlg(var0, var1, var2, var3 + 4.0F * var13, var4, var12, var7);
      uut.popAlpha();
   }

   public static void pin(DrawContext var0, float var1, float var2, float var3, int var4, float var5) {
      pin(var0, vhz.WAYPOINT, var1, var2, var3, var4, var5);
   }

   public static void pin(DrawContext var0, vhz var1, float var2, float var3, float var4, int var5, float var6) {
      int var7 = var5 | 0xFF000000;
      float var8 = var3 - var4 * 0.125F;
      float var9 = var4 * 0.34F;
      uut.shadow(var0, var2 - var9, var8 - var9, var9 * 2.0F, var9 * 2.0F, var9, var4 * 0.6F, ujt.withAlpha(var7, Math.round(125.0F * var6)));
      vjf.draw(var0, var1, var2, var3 + Math.max(0.5F, var4 * 0.04F), var4, 1426063360);
      vjf.draw(var0, var1, var2, var3, var4, var7);
   }

   static void wlg(DrawContext var0, wkq var1, float var2, float var3, double var4, int var6, float var7) {
      String var8 = wlk.COORDS.get();

      float var9;
      if (var8.equals(a.b("옿뾣㕫ꬌ\u20c3ꙸ", 171820664))) {
         var9 = 1.0F;
      }
      else if (var8.equals(a.d("ശ璦︻怋\uebd4浡", 1201546216, 195964567))) {
         var9 = vcq.outCubic(var7);
      }
      else {
         var9 = 0.0F;
      }
      String var29 = var1.name;
      String var30 = wlk.DISTANCE.get() ? formatDistance(var4) : null;
      float var12 = wkx.width(var29);
      float var13 = var30 != null ? wky.width(var30) + 4.5F : 0.0F;
      float var14 = var12 + var13;
      String[] var15 = new String[]{a.c(-317636526, "䀋"), a.d("\u0c50", -2067591857, -1272315577), a.c(1104049565, "痆")};
      String[] var16 = new String[]{String.valueOf((int)Math.floor(var1.x)), String.valueOf((int)Math.floor(var1.y)), String.valueOf((int)Math.floor(var1.z))};
      float var17 = 2.0F;
      float var18 = 5.5F;
      float var19 = 0.0F;

      for (int var20 = 0; var20 < 3; var20++) {
         var19 += wky.width(var15[var20]) + var17 + wky.width(var16[var20]) + (var20 < 2 ? var18 : 0.0F);
      }

      float var31 = Math.max(var14, var19 * var9);
      float var21 = 9.0F + 8.0F * var9;
      uut.shadow(
         var0,
         var2 - var31 * 0.5F - 2.0F,
         var3 + 1.0F,
         var31 + 4.0F,
         var21 - 1.0F,
         (var21 - 1.0F) * 0.5F,
         7.0F,
         ujt.withAlpha(-16777216, Math.round(64.0F + 16.0F * var7))
      );
      float var22 = var3 + 4.5F;
      float var23 = var2 - var14 * 0.5F;
      wkx.draw(var0, var29, var23, wkx.centerTop(var22), -592136);
      if (var30 != null) {
         wky.draw(var0, var30, var23 + var12 + 4.5F, wky.centerTop(var22), ujt.withAlpha(-1, Math.round(150.0F + 50.0F * var7)));
      }

      if (var9 > 0.02F) {
         uut.pushAlpha(var9);
         float var24 = var3 + 12.5F;
         float var25 = var2 - var19 * 0.5F;
         int var26 = ujt.lerp(var6, -1, 0.3F);
         int var27 = ujt.withAlpha(-1, Math.round(185.0F + 50.0F * var7));

         for (int var28 = 0; var28 < 3; var28++) {
            var25 = wky.draw(var0, var15[var28], var25, wky.centerTop(var24), var26) + var17;
            var25 = wky.draw(var0, var16[var28], var25, wky.centerTop(var24), var27) + var18;
         }

         uut.popAlpha();
      }
   }

   public static void bead(DrawContext var0, float var1, float var2, float var3, int var4) {
      int var5 = var4 | 0xFF000000;
      uut.shadow(var0, var1 - var3, var2 - var3 + var3 * 0.35F, var3 * 2.0F, var3 * 2.0F, var3, Math.max(1.5F, var3 * 0.8F), 2013265920);
      uut.circle(var0, var1, var2, var3 + 0.6F, 1342177280);
      uut.gradientV(var0, var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F, var3, ujt.lerp(var5, -1, 0.42F), ujt.shade(var5, 0.72F));
      float var6 = var3 * 0.3F;
      uut.circle(var0, var1 - var3 * 0.3F, var2 - var3 * 0.36F, var6, -654311425);
   }

   public static String formatDistance(double var0) {
      return var0 >= 1000.0
         ? vxu.fixed(var0 / 1000.0, 1) + wap.s(a.d("즚", -1337704499, 1902573117), a.d("ꑴ\uddc3", 311098345, 396581797))
         : Math.round(var0) + wap.unit(a.d("唡", -1831169416, 989644597));
   }
}
