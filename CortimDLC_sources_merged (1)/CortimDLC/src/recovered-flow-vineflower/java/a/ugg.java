package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public final class ugg {
   static final vdn ugh = veo.semibold(6.6F);
   static final vdn ugi = veo.medium(5.6F);
   static final float ugj = 22.0F;
   static final float ugk = 15.0F;
   static final float ugl = 15.0F;
   static final float ugm = 0.41666666F;
   static final float ugn = 0.125F;
   static final float ugo = 0.41666666F;
   static final float ugp = 24.0F;
   static final Map<ubj, ugd> ugq = new IdentityHashMap<>();

   ugg() {
   }

   public static Vec3d anchor(ubj var0, float var1) {
      if (var0.target != null) {
         PlayerEntity var2 = hhf.inWorld(var0.target);
         if (var2 != null) {
            Vec3d var3 = var2.getLerpedPos(var1);
            return new Vec3d(var3.x, var3.y + var2.getHeight() + 0.3, var3.z);
         } else {
            return new Vec3d(var0.x, var0.y + 2.1, var0.z);
         }
      } else {
         return new Vec3d(var0.x, var0.y, var0.z);
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      List<ubj> var3 = ucg.marks();
      if (!var3.isEmpty() && var2.world != null && var2.player != null && !var2.options.hudHidden) {
         ArrayList<ubj> var4 = new ArrayList<>();

         for (ubj var6 : var3) {
            if (ucg.visible(var6)) {
               var4.add(var6);
            }
         }

         ugq.keySet().retainAll(var4);
         if (!var4.isEmpty()) {
            unf.observe(var0);
            float var47 = unf.delta();
            iov.update(var47 * (float)iov.ANIMATION.get());
            float var48 = var0.getScaledWindowWidth();
            float var7 = var0.getScaledWindowHeight();
            float var8 = var1.getTickProgress(true);

            usn var9;
            try {
               var9 = usn.capture(var8, var48, var7);
            } catch (Throwable var46) {
               return;
            }

            uut.beginFrame();
            long var10 = System.currentTimeMillis();
            float[] var12 = new float[2];
            float[] var13 = new float[2];
            ArrayList<Vec3d> var14 = new ArrayList<>();

            for (ubj var16 : var4) {
               var14.add(anchor(var16, var8));
            }

            Integer[] var49 = new Integer[var4.size()];

            for (int var50 = 0; var50 < var49.length; var50++) {
               var49[var50] = var50;
            }

            Arrays.sort(
               var49,
               (var2x, var3x) -> Double.compare(
                  var9.distance(((Vec3d)var14.get(var3x)).x, ((Vec3d)var14.get(var3x)).y, ((Vec3d)var14.get(var3x)).z),
                  var9.distance(((Vec3d)var14.get(var2x)).x, ((Vec3d)var14.get(var2x)).y, ((Vec3d)var14.get(var2x)).z)
               )
            );
            Integer[] var51 = var49;
            int var17 = var51.length;

            for (int var18 = 0; var18 < var17; var18++) {
               int var19 = var51[var18];
               ubj var20 = var4.get(var19);
               Vec3d var21 = var14.get(var19);
               ugd var22 = ugq.computeIfAbsent(var20, var0x -> new ugd());
               float var23 = var20.age(var10);
               float var24 = (float)(var20.life - (var10 - var20.born)) / 1000.0F;
               float var25 = Math.min(1.0F, var23 / 0.15F) * Math.min(1.0F, Math.max(0.0F, var24 / 1.2F));
               if (!(var25 <= 0.01F)) {
                  double var26 = var9.distance(var21.x, var21.y, var21.z);
                  boolean var28 = var9.project(var21.x, var21.y, var21.z, var12);
                  float var29 = 28.0F;
                  boolean var30 = var28 && var12[0] > var29 && var12[0] < var48 - var29 && var12[1] > var29 + 22.0F && var12[1] < var7 - var29;
                  var9.direction(var21.x, var21.y, var21.z, var13);
                  float var31 = 32.0F;
                  float var32 = var7 - 24.0F - 40.0F;
                  float var33 = (var31 + var32) * 0.5F;
                  float var34 = var48 * 0.5F - 24.0F;
                  float var35 = (var32 - var31) * 0.5F;
                  float var36 = Math.min(var34 / Math.max(1.0E-4F, Math.abs(var13[0])), var35 / Math.max(1.0E-4F, Math.abs(var13[1])));
                  float var37 = var48 * 0.5F + var13[0] * var36;
                  float var38 = var33 + var13[1] * var36;
                  if (!var22.placed) {
                     var22.inside.set(var30 ? 1.0F : 0.0F);
                     var22.placed = true;
                  }

                  float var39 = vcq.outCubic(var22.inside.step(var30, var47));
                  float var40 = !var30 && !var28 ? var37 : ugt(var37, var12[0], var39);
                  float var41 = !var30 && !var28 ? var38 : ugt(var38, var12[1], var39);
                  float var42 = var20.target != null ? 7.5F : 13.200001F;
                  boolean var43 = var39 > 0.5F && Math.hypot(var12[0] - var48 * 0.5F, var12[1] - var42 - var7 * 0.5F) < 13.0;
                  float var44 = var22.focus.step(var43, var47);
                  float var45 = var20.target != null ? 1.0F : (float)Math.min(1.0, Math.max(0.3, (var26 - 1.5) / 4.0));
                  uut.pushAlpha(var25);
                  if (var39 > 0.02F) {
                     uut.pushAlpha(var39 * var45);
                     if (var20.target != null) {
                        ugw(var0, var20, var40, var41, var26, var23, var44);
                     } else {
                        ugv(var0, var20, var40, var41, var26, var23, var44);
                     }

                     uut.popAlpha();
                  }

                  if (var39 < 0.98F) {
                     uut.pushAlpha(1.0F - var39);
                     uha(var0, var20, var37, var38, var13[0], var13[1], var26, var23);
                     uut.popAlpha();
                  }

                  uut.popAlpha();
               }
            }
         }
      } else {
         ugq.clear();
      }
   }

   static float ugt(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   static float ugu(double var0) {
      return (float)Math.max(0.78, Math.min(1.06, 1.1 - Math.log10(Math.max(1.0, var0)) * 0.1));
   }

   static void ugv(DrawContext var0, ubj var1, float var2, float var3, double var4, float var6, float var7) {
      int var8 = var1.color | 0xFF000000;
      float var9 = ugu(var4);
      float var10 = vcq.outCubic(Math.min(1.0F, var6 / 0.35F));
      float var11 = var9 * uhb(var6) * (1.0F + 0.1F * var7);
      float var12 = (1.0F - var10) * -6.0F - var7 * 1.5F;
      vhz var13 = var1.danger() ? vhz.MARK_ALERT : vhz.MARK;
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var2, var3);
      ugx(var0, var8, var1.danger(), var6, var9);
      uut.shadow(var0, -3.0F * var9, -1.0F * var9, 6.0F * var9, 2.0F * var9, 1.0F * var9, 2.5F * var9, 1174405120);
      var0.getMatrices().translate(0.0F, var12);
      var0.getMatrices().scale(var11, var11);
      if (var1.danger()) {
         ugy(var0, var8, 0.0F, -11.916666F, 6.6000004F, var6);
      }

      wkw.pin(var0, var13, 0.0F, -9.166666F, 22.0F, var8, 0.85F + 0.15F * var7);
      var0.getMatrices().popMatrix();
      ugz(var0, var1, var2, var3 + var12 - 18.333332F * var11 - 2.0F, var4, var7);
   }

   static void ugw(DrawContext var0, ubj var1, float var2, float var3, double var4, float var6, float var7) {
      int var8 = var1.color | 0xFF000000;
      float var9 = vcq.outCubic(Math.min(1.0F, var6 / 0.4F));
      float var10 = ugu(var4) * (1.0F + 0.1F * var7);
      float var11 = 15.0F * (1.0F + 0.8F * (1.0F - var9));
      float var12 = var3 - 7.5F * var10 - 1.5F;
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var2, var12);
      var0.getMatrices().scale(var10, var10);
      if (var1.danger()) {
         ugy(var0, var8, 0.0F, 0.0F, 7.5F, var6);
      }

      float var13 = var11 * 0.5F;
      uut.shadow(var0, -var13, -var13, var13 * 2.0F, var13 * 2.0F, var13, var11 * 0.55F, ujt.withAlpha(var8, Math.round(110.0F + 40.0F * var7)));
      var0.getMatrices().rotate((1.0F - var9) * (float) Math.PI * 0.5F);
      vjf.draw(var0, vhz.MARK_TARGET, 0.0F, Math.max(0.5F, var11 * 0.04F), var11, 1426063360);
      vjf.draw(var0, vhz.MARK_TARGET, 0.0F, 0.0F, var11, var8);
      var0.getMatrices().popMatrix();
      ugz(var0, var1, var2, var12 - 7.5F * var10 - 2.5F, var4, var7);
   }

   static void ugx(DrawContext var0, int var1, boolean var2, float var3, float var4) {
      float var5 = var2 ? 1.0F : 1.2F;

      for (int var6 = 0; var6 < 2; var6++) {
         float var7 = var3 - var6 * var5 * 0.5F;
         if (!(var7 < 0.0F) && (var2 || !(var7 >= var5))) {
            float var8 = var7 % var5 / var5;
            float var9 = (2.0F + 13.0F * vcq.outCubic(var8)) * var4;
            int var10 = Math.round(190.0F * (1.0F - var8) * (1.0F - var8));
            if (var10 >= 3) {
               var0.getMatrices().pushMatrix();
               var0.getMatrices().scale(1.0F, 0.36F);
               uut.circleOutline(var0, 0.0F, 0.0F, var9, 2.4F, ujt.withAlpha(var1, var10));
               var0.getMatrices().popMatrix();
            }
         }
      }
   }

   static void ugy(DrawContext var0, int var1, float var2, float var3, float var4, float var5) {
      float var6 = 0.9F;

      for (int var7 = 0; var7 < 2; var7++) {
         float var8 = var5 - var7 * var6 * 0.5F;
         if (!(var8 < 0.0F)) {
            float var9 = var8 % var6 / var6;
            float var10 = var4 * (1.0F + 0.9F * vcq.outCubic(var9));
            int var11 = Math.round(150.0F * (1.0F - var9) * (1.0F - var9));
            if (var11 > 2) {
               uut.circleOutline(var0, var2, var3, var10, 1.1F, ujt.withAlpha(var1, var11));
            }
         }
      }
   }

   static void ugz(DrawContext var0, ubj var1, float var2, float var3, double var4, float var6) {
      String var7 = var1.mine ? wap.s(a.c(-377681730, "ࣤ煣ﮪ"), a.d("媌⍤", 1981290816, -824358948)) : lsx.protect(var1.name);
      String var8 = lsx.protect(var1.target);
      String var9 = wkw.formatDistance(var4);
      float var10 = ugh.width(var7);
      float var11 = var8 != null ? 10.0F : 0.0F;
      float var12 = var8 != null ? ugh.width(var8) : 0.0F;
      float var13 = ugi.width(var9);
      float var14 = var10 + var11 + var12 + 4.5F + var13;
      float var15 = var3 - 3.5F;
      uut.shadow(var0, var2 - var14 * 0.5F - 2.0F, var15 - 4.0F, var14 + 4.0F, 8.0F, 4.0F, 7.0F, ujt.withAlpha(-16777216, Math.round(64.0F + 16.0F * var6)));
      float var16 = var2 - var14 * 0.5F;
      int var17 = var1.color | 0xFF000000;
      var16 = ugh.draw(var0, var7, var16, ugh.centerTop(var15), ujt.lerp(var17, -1, 0.35F));
      if (var8 != null) {
         vjf.draw(var0, vhz.CHEVRON_RIGHT, var16 + var11 * 0.5F, var15, 6.5F, ujt.withAlpha(-1, 170));
         var16 = ugh.draw(var0, var8, var16 + var11, ugh.centerTop(var15), -592136);
      }

      ugi.draw(var0, var9, var16 + 4.5F, ugi.centerTop(var15), ujt.withAlpha(-1, Math.round(150.0F + 50.0F * var6)));
   }

   static void uha(DrawContext var0, ubj var1, float var2, float var3, float var4, float var5, double var6, float var8) {
      int var9 = var1.color | 0xFF000000;
      float var10 = uhb(var8);
      float var11 = 6.2999997F * var10;
      if (var1.danger()) {
         ugy(var0, var9, var2, var3, var11 * 1.1F, var8);
      }

      float var12 = (float)Math.atan2(var5, var4) + (float) (Math.PI / 2);
      float var13 = 0.8F + 0.8F * (float)Math.sin(var8 * 5.0);
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var2 + var4 * (var11 + 4.5F + var13), var3 + var5 * (var11 + 4.5F + var13));
      var0.getMatrices().rotate(var12);
      vjf.draw(var0, vhz.NAV, 0.0F, 0.6F, 7.5F * var10, 1426063360);
      vjf.draw(var0, vhz.NAV, 0.0F, 0.0F, 7.5F * var10, var9);
      var0.getMatrices().popMatrix();
      var0.getMatrices().pushMatrix();
      var0.getMatrices().translate(var2, var3);
      var0.getMatrices().scale(var10, var10);
      if (var1.target != null) {
         float var14 = 7.5F;
         uut.shadow(var0, -var14, -var14, var14 * 2.0F, var14 * 2.0F, var14, 8.25F, ujt.withAlpha(var9, 110));
         vjf.draw(var0, vhz.MARK_TARGET, 0.0F, 0.6F, 15.0F, 1426063360);
         vjf.draw(var0, vhz.MARK_TARGET, 0.0F, 0.0F, 15.0F, var9);
      } else {
         wkw.pin(var0, var1.danger() ? vhz.MARK_ALERT : vhz.MARK, 0.0F, 1.875F, 15.0F, var9, 1.0F);
      }

      var0.getMatrices().popMatrix();
      String var18 = wkw.formatDistance(var6);
      float var15 = ugi.width(var18);
      float var16 = var3 - var5 * (var11 + 7.0F);
      float var17 = var2 - var4 * (var11 + 4.0F + var15 * 0.5F * Math.abs(var4));
      uut.shadow(var0, var17 - var15 * 0.5F - 1.5F, var16 - 3.5F, var15 + 3.0F, 7.0F, 3.5F, 5.0F, 1342177280);
      ugi.drawCentered(var0, var18, var17, ugi.centerTop(var16), -419430401);
   }

   static float uhb(float var0) {
      if (var0 >= 0.45F) {
         return 1.0F;
      }

      float var1 = var0 / 0.45F;
      return 0.5F + 0.5F * vcq.outBack(var1);
   }
}
