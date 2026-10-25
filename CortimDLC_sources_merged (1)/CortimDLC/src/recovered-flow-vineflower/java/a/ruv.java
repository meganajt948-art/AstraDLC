package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class ruv extends kfe {
   private static ruv ruw;
   public final vlv mode = this.add(new vlv("Mode", "Ghosts", "Ghosts", "Sparkles", "Ring", "Comets", "Lightning"));
   public final vla color = this.add(new vla("Color", "Theme"));
   public final vla hitColor = this.add(new vla("Hit color", "Crimson"));
   public final vmc size = this.add(new vmc("Size", 1.0, 0.6, 1.6, 0.05).percent());
   public final vmc speed = this.add(new vmc("Speed", 1.0, 0.4, 2.0, 0.1).unit("x"));
   public final vmc brightness = this.add(new vmc("Brightness", 0.8, 0.3, 1.0, 0.05).percent());
   public final vkl mobs = this.add(new vkl("Mobs", false));
   private static final long rux = 3500L;
   private static final double ruy = 48.0;
   private static final float ruz = (float) (Math.PI * 2);
   private static LivingEntity rva;
   private static long rvb;
   private static LivingEntity rvc;
   private static final vcj rvd = new vcj(7.0F);
   private static final vcj rve = new vcj(3.2F);
   private static int rvf;
   private static float rvg;
   private static long rvh = -1L;
   private static final float[] rvi = new float[2];
   private static final float[] rvj = new float[2];
   private static final float[] rvk = new float[2];
   private static final float[] rvl = new float[2];
   private static final Random rvm = new Random();
   private static final int rvn = 60;
   private static final float[][] rvo = new float[60][7];
   private static final int rvp = 4;
   private static final int rvq = 11;
   private static final int rvr = 4;
   private static final int rvs = 4;
   private static final double[][] rvt = new double[4][33];
   private static final double[][] rvu = new double[4][12];
   private static float rvv;
   private static long rvw;
   private static int rvx;

   public ruv() {
      super(new String(new char[]{'T', 'a', 'r', 'g', 'e', 't', 'E', 'S', 'P'}), "An effect on your current target", kfa.RENDER);
      ruw = this;
      rwf();
   }

   public static void onAttack(Entity var0) {
      if (var0 instanceof LivingEntity var1) {
         rva = var1;
         rvb = System.currentTimeMillis();
      }
   }

   private boolean rwa(MinecraftClient var1, Entity var2) {
      if (!(
         var2 instanceof LivingEntity var3
            && var2 != var1.player
            && var3.isAlive()
            && !var2.isRemoved()
            && !(var2 instanceof ArmorStandEntity)
            && var1.world.getEntityById(var2.getId()) == var2
            && !var2.isSpectator()
      )) {
         return false;
      } else if (!(var2 instanceof PlayerEntity) && !this.mobs.get()) {
         return false;
      } else {
         return var2 instanceof PlayerEntity && hhf.isFriend(var2) ? false : var1.player.squaredDistanceTo(var2) < 2304.0;
      }
   }

   private LivingEntity rwb(MinecraftClient var1) {
      if (rva != null && System.currentTimeMillis() - rvb < 3500L && this.rwa(var1, rva)) {
         return rva;
      }

      Entity var2 = var1.targetedEntity;
      return var2 != null && this.rwa(var1, var2) ? (LivingEntity)var2 : null;
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      ruv var2 = ruw;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null && var3.world != null && var3.player != null) {
         if (!var2.isEnabled()) {
            rvc = null;
            rvd.set(0.0F);
         } else if (!var3.options.hudHidden && !(var3.currentScreen instanceof hlc)) {
            unf.observe(var0);
            if (unf.frame() != rvh) {
               rvh = unf.frame();
               float var4 = unf.delta();
               LivingEntity var5 = var2.rwb(var3);
               if (var5 != null && var5 != rvc) {
                  rvc = var5;
                  rvd.set(0.0F);
                  rve.set(0.0F);
                  rvf = var5.hurtTime;
                  rvv = 0.0F;
               }

               LivingEntity var6 = rvc;
               if (var6 != null) {
                  float var7 = rvd.step(var5 != null && var2.rwa(var3, var6), var4);
                  if (var7 <= 0.004F) {
                     if (var5 == null) {
                        rvc = null;
                     }
                  } else {
                     boolean var8 = var6.hurtTime > rvf;
                     if (var8) {
                        rve.set(1.0F);
                        rvv = 0.0F;
                     }

                     rvf = var6.hurtTime;
                     rve.step(0.0F, var4);
                     float var9 = (float)var2.speed.get();
                     rvg += var4 * var9;

                     usn var10;
                     try {
                        var10 = usn.capture(var1.getTickProgress(true), var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
                     } catch (Throwable var21) {
                        return;
                     }

                     Vec3d var11 = var6.getLerpedPos(var1.getTickProgress(true));
                     rus var12 = new rus(var2, vcq.outCubic(var7), vcq.outCubic(rve.get()));
                     uut.beginFrame();
                     uut.pushAlpha(var12.vis * (float)var2.brightness.get());
                     long var13 = System.nanoTime();
                     uut.beginBatch();

                     try {
                        switch (var2.mode.get()) {
                           case "Sparkles":
                              rwg(var0, var10, var6, var11, var12, var4 * var9);
                              break;
                           case "Ring":
                              rwh(var0, var10, var6, var11, var12);
                              break;
                           case "Comets":
                              rwk(var0, var10, var6, var11, var12);
                              break;
                           case "Lightning":
                              rwl(var0, var10, var6, var11, var12, var4 * var9);
                              break;
                           default:
                              rwe(var0, var10, var6, var11, var12);
                        }
                     } finally {
                        uut.endBatch();
                        uut.additive(false);
                        uut.popAlpha();
                        rvw = rvw + (System.nanoTime() - var13);
                        rvx++;
                     }
                  }
               }
            }
         }
      }
   }

   public static double cpuMicros() {
      double var0 = rvx == 0 ? 0.0 : rvw / 1000.0 / rvx;
      rvw = 0L;
      rvx = 0;
      return var0;
   }

   private static void rwc(DrawContext var0, GpuTextureView var1, float var2, float var3, float var4, int var5) {
      if (var1 != null) {
         uut.sprite(var0, var1, var2, var3, var4, var5);
      } else {
         float var6 = var4 * 0.18F;
         uut.shadow(var0, var2 - var6, var3 - var6, var6 * 2.0F, var6 * 2.0F, var6, var4 * 0.3F, var5);
      }
   }

   private static float rwd(float var0) {
      return 0.5F - 0.5F * (float)Math.cos(var0);
   }

   private static void rwe(DrawContext var0, usn var1, LivingEntity var2, Vec3d var3, rus var4) {
      GpuTextureView var5 = unm.view();
      float var6 = var2.getHeight();
      double var7 = (var2.getWidth() * 0.55 + 0.35) * var4.size;
      double var9 = var3.y + var6 * 0.5;
      float var11 = var1.depth(var3.x, var9, var3.z);
      float var12 = var1.unitsPerBlock(var3.x, var9, var3.z);
      if (!(var12 <= 0.0F)) {
         uut.additive(true);
         byte var13 = 3;
         byte var14 = 22;

         for (int var15 = 0; var15 < var13; var15++) {
            float var16 = (float) (Math.PI * 2) * var15 / var13;

            for (int var17 = var14 - 1; var17 >= 0; var17--) {
               float var18 = rvg * 2.3F - var17 * 0.055F;
               float var19 = var18 + var16;
               double var20 = var3.x + Math.cos(var19) * var7;
               double var22 = var3.z + Math.sin(var19) * var7;
               double var24 = var9 + Math.sin(var18 * 1.25F + var16 * 1.7F) * var6 * 0.36;
               if (var1.project(var20, var24, var22, rvi)) {
                  float var26 = 1.0F - (float)var17 / var14;
                  boolean var27 = var1.depth(var20, var24, var22) < var11;
                  float var28 = Math.min(40.0F, var12 * 0.3F * var4.size * (0.25F + 0.75F * var26));
                  float var29 = (float)Math.pow(var26, 1.5) * (var27 ? 1.0F : 0.5F);
                  rwc(var0, var5, rvi[0], rvi[1], var28, ujt.withAlpha(var4.at((float)var17 / var14), Math.round(165.0F * var29)));
                  if (var17 == 0) {
                     rwc(var0, var5, rvi[0], rvi[1], var28 * 0.34F, ujt.withAlpha(var4.core(0.55F), Math.round(200.0F * (var27 ? 1.0F : 0.55F))));
                  }
               }
            }
         }

         uut.additive(false);
      }
   }

   private static void rwf() {
      Random var0 = new Random(23057L);

      for (float[] var4 : rvo) {
         var4[0] = var0.nextFloat() * (float) (Math.PI * 2);
         var4[1] = 0.55F + var0.nextFloat() * 0.45F;
         var4[2] = var0.nextFloat();
         var4[3] = 0.08F + var0.nextFloat() * 0.14F;
         var4[4] = var0.nextFloat() * (float) (Math.PI * 2);
         var4[5] = 2.2F + var0.nextFloat() * 3.5F;
         var4[6] = 0.55F + var0.nextFloat() * 0.45F;
      }
   }

   private static void rwg(DrawContext var0, usn var1, LivingEntity var2, Vec3d var3, rus var4, float var5) {
      GpuTextureView var6 = unm.view();
      float var7 = var2.getHeight();
      double var8 = (var2.getWidth() * 0.6 + 0.3) * var4.size;
      float var10 = var1.depth(var3.x, var3.y + var7 * 0.5, var3.z);
      float var11 = var1.unitsPerBlock(var3.x, var3.y + var7 * 0.5, var3.z);
      if (!(var11 <= 0.0F)) {
         float var12 = Math.min(12.0F, Math.max(3.0F, var11 * 0.1F)) * var4.size;
         uut.additive(true);

         for (float[] var16 : rvo) {
            var16[2] += var16[3] * var5 * (1.0F + var4.hit * 2.0F);
            var16[0] += var5 * 0.35F;
            if (var16[2] > 1.0F) {
               var16[2]--;
               var16[0] = rvm.nextFloat() * (float) (Math.PI * 2);
            }

            double var17 = var8 * var16[1];
            double var19 = var3.x + Math.cos(var16[0]) * var17;
            double var21 = var3.z + Math.sin(var16[0]) * var17;
            double var23 = var3.y + (var16[2] * 1.1 - 0.05) * var7;
            if (var1.project(var19, var23, var21, rvi)) {
               float var25 = Math.min(1.0F, Math.min(var16[2] / 0.15F, (1.0F - var16[2]) / 0.2F));
               float var26 = 0.5F + 0.5F * (float)Math.sin(rvg * var16[5] + var16[4]);
               var26 *= var26;
               boolean var27 = var1.depth(var19, var23, var21) < var10;
               float var28 = var25 * (0.25F + 0.75F * var26) * (var27 ? 1.0F : 0.45F);
               if (!(var28 <= 0.02F)) {
                  float var29 = var12 * var16[6];
                  rwc(var0, var6, rvi[0], rvi[1], var29 * 3.6F, ujt.withAlpha(var4.at(var16[6]), Math.round(80.0F * var28)));
                  rwc(var0, var6, rvi[0], rvi[1], var29 * 1.3F, ujt.withAlpha(var4.core(0.75F), Math.round(255.0F * var28)));
               }
            }
         }

         uut.additive(false);
      }
   }

   private static void rwh(DrawContext var0, usn var1, LivingEntity var2, Vec3d var3, rus var4) {
      float var5 = var2.getHeight();
      double var6 = (var2.getWidth() * 0.5 + 0.2) * var4.size;
      float var8 = rvg * 1.6F;
      double var9 = var3.y + 0.05 + rwd(var8) * (var5 - 0.1);
      boolean var11 = Math.sin(var8) > 0.0;
      double var12 = 0.04 * var4.size;
      double var14 = 0.2 * var4.size * Math.min(1.0, Math.abs(Math.sin(var8)) * 1.6 + 0.25);
      rwi(var0, var1, var3.x, var9, var3.z, var6, var11 ? var14 : var12 * 1.4, var11 ? var12 * 1.4 : var14, var4, 1.0F, 44);
      rwj(var0, var1, var3.x, var9, var3.z, var6, 44, var4, 0.9F);
   }

   private static void rwi(
      DrawContext var0, usn var1, double var2, double var4, double var6, double var8, double var10, double var12, rus var14, float var15, int var16
   ) {
      float var17 = var1.depth(var2, var4, var6);
      uut.additive(true);

      for (int var18 = 0; var18 < var16; var18++) {
         double var19 = (float) (Math.PI * 2) * var18 / var16;
         double var21 = (float) (Math.PI * 2) * (var18 + 1) / var16;
         double var23 = Math.cos(var19) * var8;
         double var25 = Math.sin(var19) * var8;
         double var27 = Math.cos(var21) * var8;
         double var29 = Math.sin(var21) * var8;
         double var31 = (var19 + var21) * 0.5;
         boolean var33 = var1.depth(var2 + Math.cos(var31) * var8, var4, var6 + Math.sin(var31) * var8) < var17;
         float var34 = var15 * (var33 ? 1.0F : 0.35F);
         int var35 = var14.at(0.5F + 0.5F * (float)Math.sin(var31 + rvg));
         int var36 = ujt.withAlpha(ujt.lerp(var35, -1, 0.35F), Math.round(120.0F * var34));
         int var37 = ujt.withAlpha(var35, 0);
         if (var1.project(var2 + var23, var4, var6 + var25, rvi) && var1.project(var2 + var27, var4, var6 + var29, rvj)) {
            if (var1.project(var2 + var27, var4 - var10, var6 + var29, rvk) && var1.project(var2 + var23, var4 - var10, var6 + var25, rvl)) {
               uut.quad(var0, rvi[0], rvi[1], var36, rvj[0], rvj[1], var36, rvk[0], rvk[1], var37, rvl[0], rvl[1], var37);
            }

            if (var1.project(var2 + var27, var4 + var12, var6 + var29, rvk) && var1.project(var2 + var23, var4 + var12, var6 + var25, rvl)) {
               uut.quad(var0, rvi[0], rvi[1], var36, rvj[0], rvj[1], var36, rvk[0], rvk[1], var37, rvl[0], rvl[1], var37);
            }
         }
      }

      uut.additive(false);
   }

   private static void rwj(DrawContext var0, usn var1, double var2, double var4, double var6, double var8, int var10, rus var11, float var12) {
      float var13 = var1.depth(var2, var4, var6);
      float var14 = var1.unitsPerBlock(var2, var4, var6);
      float var15 = Math.max(0.7F, Math.min(1.8F, var14 * 0.014F));
      boolean var16 = var1.project(var2 + var8, var4, var6, rvi);

      for (int var17 = 1; var17 <= var10; var17++) {
         double var18 = (float) (Math.PI * 2) * var17 / var10;
         boolean var20 = var1.project(var2 + Math.cos(var18) * var8, var4, var6 + Math.sin(var18) * var8, rvj);
         if (var16 && var20) {
            double var21 = var18 - Math.PI / var10;
            boolean var23 = var1.depth(var2 + Math.cos(var21) * var8, var4, var6 + Math.sin(var21) * var8) < var13;
            uut.line(var0, rvi[0], rvi[1], rvj[0], rvj[1], var15, ujt.withAlpha(var11.core(0.6F), Math.round(235.0F * var12 * (var23 ? 1.0F : 0.3F))));
         }

         rvi[0] = rvj[0];
         rvi[1] = rvj[1];
         var16 = var20;
      }
   }

   private static void rwk(DrawContext var0, usn var1, LivingEntity var2, Vec3d var3, rus var4) {
      float var5 = var2.getHeight();
      double var6 = (var2.getWidth() * 0.5 + 0.28) * var4.size;
      float var8 = var1.depth(var3.x, var3.y + var5 * 0.5, var3.z);
      float var9 = var1.unitsPerBlock(var3.x, var3.y + var5 * 0.5, var3.z);
      if (!(var9 <= 0.0F)) {
         GpuTextureView var10 = unm.view();
         byte var11 = 18;
         double var12 = 0.12 * var4.size;
         uut.additive(true);

         for (int var14 = 0; var14 < 2; var14++) {
            float var15 = var14 * (float) Math.PI;

            for (int var16 = var11 - 1; var16 > 0; var16--) {
               float var17 = rvg * 3.1F - var16 * 0.075F;
               float var18 = rvg * 3.1F - (var16 - 1) * 0.075F;
               double var19 = var17 + var15;
               double var21 = var18 + var15;
               double var23 = var3.y + 0.1 + rwd(var17 * 0.42F + var15) * (var5 - 0.2);
               double var25 = var3.y + 0.1 + rwd(var18 * 0.42F + var15) * (var5 - 0.2);
               double var27 = var3.x + Math.cos(var19) * var6;
               double var29 = var3.z + Math.sin(var19) * var6;
               double var31 = var3.x + Math.cos(var21) * var6;
               double var33 = var3.z + Math.sin(var21) * var6;
               float var35 = 1.0F - (float)var16 / var11;
               float var36 = 1.0F - (float)(var16 - 1) / var11;
               double var37 = var12 * var35;
               double var39 = var12 * var36;
               boolean var41 = var1.depth(var31, var25, var33) < var8;
               float var42 = var41 ? 1.0F : 0.4F;
               int var43 = ujt.withAlpha(var4.core(0.5F * var35), Math.round(230.0F * var35 * var42));
               int var44 = ujt.withAlpha(var4.core(0.5F * var36), Math.round(230.0F * var36 * var42));
               if (var1.project(var27, var23 + var37, var29, rvi)
                  && var1.project(var31, var25 + var39, var33, rvj)
                  && var1.project(var31, var25 - var39, var33, rvk)
                  && var1.project(var27, var23 - var37, var29, rvl)) {
                  uut.quad(var0, rvi[0], rvi[1], var43, rvj[0], rvj[1], var44, rvk[0], rvk[1], var44, rvl[0], rvl[1], var43);
               }
            }

            double var45 = rvg * 3.1F + var15;
            double var46 = var3.x + Math.cos(var45) * var6;
            double var20 = var3.z + Math.sin(var45) * var6;
            double var22 = var3.y + 0.1 + rwd(rvg * 3.1F * 0.42F + var15) * (var5 - 0.2);
            if (var1.project(var46, var22, var20, rvi)) {
               boolean var24 = var1.depth(var46, var22, var20) < var8;
               float var47 = Math.min(44.0F, var9 * 0.45F * var4.size);
               rwc(var0, var10, rvi[0], rvi[1], var47, ujt.withAlpha(var4.at(0.3F), Math.round(120.0F * (var24 ? 1.0F : 0.4F))));
               rwc(var0, var10, rvi[0], rvi[1], var47 * 0.32F, ujt.withAlpha(var4.core(0.8F), Math.round(230.0F * (var24 ? 1.0F : 0.4F))));
            }
         }

         uut.additive(false);
      }
   }

   private static void rwl(DrawContext var0, usn var1, LivingEntity var2, Vec3d var3, rus var4, float var5) {
      float var6 = var2.getHeight();
      float var7 = var1.unitsPerBlock(var3.x, var3.y + var6 * 0.5, var3.z);
      if (!(var7 <= 0.0F)) {
         double var8 = (var2.getWidth() * 0.5 + 0.16) * var4.size;
         double var10 = var3.y + 0.1 + rwd(rvg * 1.3F) * (var6 - 0.2);
         rvv -= var5;
         if (rvv <= 0.0F) {
            rvv = 0.07F;
            rwn(var8, var4.size, var4.hit);
         }

         float var12 = Math.max(0.9F, Math.min(2.4F, var7 * 0.022F));
         float var13 = Math.min(8.0F, var7 * 0.09F);
         float var14 = var1.depth(var3.x, var10, var3.z);
         float var15 = 0.75F + 0.25F * (float)Math.sin(rvg * 40.0F);

         for (int var16 = 0; var16 < 4; var16++) {
            rwm(var0, var1, var3.x, var10, var3.z, rvt[var16], 11, var12, var13, var4.at(var16 / 3.0F), var15 * (0.85F + 0.15F * var4.hit), var14);
         }

         for (int var17 = 0; var17 < 4; var17++) {
            rwm(var0, var1, var3.x, var10, var3.z, rvu[var17], 4, var12 * 0.7F, var13 * 0.7F, var4.c2, var15 * 0.7F, var14);
         }
      }
   }

   private static void rwm(
      DrawContext var0, usn var1, double var2, double var4, double var6, double[] var8, int var9, float var10, float var11, int var12, float var13, float var14
   ) {
      uut.additive(true);
      boolean var15 = var1.project(var2 + var8[0], var4 + var8[1], var6 + var8[2], rvi);

      for (int var16 = 1; var16 < var9; var16++) {
         double var17 = var2 + var8[var16 * 3];
         double var19 = var4 + var8[var16 * 3 + 1];
         double var21 = var6 + var8[var16 * 3 + 2];
         boolean var23 = var1.project(var17, var19, var21, rvj);
         if (var15 && var23) {
            float var24 = var13 * (var1.depth(var17, var19, var21) < var14 ? 1.0F : 0.35F);
            uut.softLine(var0, rvi[0], rvi[1], rvj[0], rvj[1], var11 * 0.5F, var11, ujt.withAlpha(var12, Math.round(95.0F * var24)));
            uut.line(var0, rvi[0], rvi[1], rvj[0], rvj[1], var10, ujt.withAlpha(ujt.lerp(var12, -1, 0.7F), Math.round(245.0F * var24)));
         }

         rvi[0] = rvj[0];
         rvi[1] = rvj[1];
         var15 = var23;
      }

      uut.additive(false);
   }

   private static void rwn(double var0, float var2, float var3) {
      double var4 = (0.07 + 0.05 * var3) * var2;

      for (int var6 = 0; var6 < 4; var6++) {
         double[] var7 = rvt[var6];
         double var8 = (float) (Math.PI * 2) * var6 / 4.0F + rvm.nextDouble() * 1.4;
         double var10 = 1.8 + rvm.nextDouble() * 1.3;

         for (int var12 = 0; var12 < 11; var12++) {
            double var13 = var12 / 10.0;
            double var15 = var8 + var10 * var13;
            double var17 = var0 + (rvm.nextDouble() - 0.4) * var4 * 1.4;
            var7[var12 * 3] = Math.cos(var15) * var17;
            var7[var12 * 3 + 1] = (rvm.nextDouble() - 0.5) * var4 * 2.6;
            var7[var12 * 3 + 2] = Math.sin(var15) * var17;
         }
      }

      for (int var25 = 0; var25 < 4; var25++) {
         double[] var26 = rvt[rvm.nextInt(4)];
         int var27 = 1 + rvm.nextInt(9);
         double var9 = var26[var27 * 3];
         double var11 = var26[var27 * 3 + 1];
         double var28 = var26[var27 * 3 + 2];
         double var29 = rvm.nextBoolean() ? 1.0 : -1.0;
         double var30 = 1.0 + 0.15 * var2;
         double[] var19 = rvu[var25];

         for (int var20 = 0; var20 < 4; var20++) {
            double var21 = var20 / 3.0;
            double var23 = 1.0 + (var30 - 1.0) * var21;
            var19[var20 * 3] = var9 * var23 + (rvm.nextDouble() - 0.5) * var4 * var21;
            var19[var20 * 3 + 1] = var11 + var29 * var21 * (0.18 + rvm.nextDouble() * 0.12) * var2;
            var19[var20 * 3 + 2] = var28 * var23 + (rvm.nextDouble() - 0.5) * var4 * var21;
         }
      }
   }
}
