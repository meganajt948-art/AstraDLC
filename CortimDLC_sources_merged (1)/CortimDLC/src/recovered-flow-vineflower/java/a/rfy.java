package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;

public class rfy extends kfe {
   private static rfy rfz;
   private final vlv rga = this.add(new vlv("Theme", "Ring", "Ring", "Lightning", "Winter", "Lava", "Cosmos", "Aurora", "Ocean", "Neon", "Sakura"));
   private final vla rgb = this.add(new vla("Color", "Theme"));
   private final vmc rgc = this.add(new vmc("Size", 1.2, 0.5, 3.0, 0.05).suffix("blocks"));
   private final vmc rgd = this.add(new vmc("Duration", 1.2, 0.4, 3.0, 0.1).suffix("s"));
   private final vmc rge = this.add(new vmc("Brightness", 0.9, 0.3, 1.0, 0.05).percent());
   private final vkl rgf = this.add(new vkl("Particles", true));
   private static final int rgg = 8;
   private static final float rgh = (float) (Math.PI * 2);
   private final List<rfv> rgi = new ArrayList<>();
   private final Random rgj = new Random();
   private boolean rgk = true;
   private double rgl;
   private long rgm = -1L;
   private float rgn;
   private final float[] rgo = new float[20];
   private final float[][] rgp = new float[49][3];
   private final boolean[] rgq = new boolean[49];
   private final float[] rgr = new float[3];
   private final float[] rgs = new float[3];

   public rfy() {
      super(new String(new char[]{'J', 'u', 'm', 'p', 'C', 'i', 'r', 'c', 'l', 'e', 's'}), "A circle where you jump", kfa.RENDER);
      rfz = this;
      this.rgb.visibleWhen(() -> this.rga.is("Ring") || this.rga.is("Lightning") || this.rga.is("Cosmos") || this.rga.is("Neon"));
   }

   @Override
   protected void onEnable() {
      this.rgi.clear();
      this.rgk = this.mc.player == null || this.mc.player.isOnGround();
   }

   @Override
   protected void onDisable() {
      this.rgi.clear();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      boolean var3 = var2.isOnGround();
      if (var3) {
         this.rgl = var2.getY();
      }

      if (this.rgk && !var3 && var2.getVelocity().y > 0.06 && !var2.hasVehicle() && !var2.isSpectator() && !var2.isTouchingWater() && !var2.isClimbing()) {
         this.rgv(var2.getX(), this.rgl, var2.getZ());
      }

      this.rgk = var3;
   }

   private void rgv(double var1, double var3, double var5) {
      if (this.rgi.size() >= 8) {
         this.rgi.remove(0);
      }

      rfv var7 = new rfv();
      var7.x = var1;
      var7.y = var3 + 0.02;
      var7.z = var5;
      var7.seed = this.rgj.nextFloat() * 100.0F;
      var7.bolts = this.rgw();
      byte var8 = 18;
      var7.parts = new float[var8 * 5];

      for (int var9 = 0; var9 < var8; var9++) {
         var7.parts[var9 * 5] = this.rgj.nextFloat() * (float) (Math.PI * 2);
         var7.parts[var9 * 5 + 1] = 0.55F + this.rgj.nextFloat() * 0.5F;
         var7.parts[var9 * 5 + 2] = 0.5F + this.rgj.nextFloat();
         var7.parts[var9 * 5 + 3] = this.rgj.nextFloat() * (float) (Math.PI * 2);
         var7.parts[var9 * 5 + 4] = 0.6F + this.rgj.nextFloat() * 0.6F;
      }

      this.rgi.add(var7);
   }

   private float[][] rgw() {
      ArrayList var1 = new ArrayList();
      int var2 = 9 + this.rgj.nextInt(4);
      float var3 = this.rgj.nextFloat() * (float) (Math.PI * 2);

      for (int var4 = 0; var4 < var2; var4++) {
         float var5 = var3 + var4 * (float) (Math.PI * 2) / var2 + (this.rgj.nextFloat() - 0.5F) * 0.4F;
         float var6 = 0.18F + this.rgj.nextFloat() * 0.1F;
         float var7 = 0.62F + this.rgj.nextFloat() * 0.35F;
         var1.add(this.rgx(var5, var6, var7, 7));
         if (this.rgj.nextFloat() < 0.7F) {
            float var8 = var6 + (var7 - var6) * (0.35F + this.rgj.nextFloat() * 0.3F);
            float var9 = this.rgj.nextBoolean() ? 1.0F : -1.0F;
            float[] var10 = this.rgx(var5, var8, var8 + 0.25F + this.rgj.nextFloat() * 0.2F, 4);

            for (int var11 = 0; var11 < var10.length / 2; var11++) {
               float var12 = (float)var11 / (var10.length / 2 - 1);
               float var13 = var9 * var12 * 0.35F;
               float var14 = var10[var11 * 2];
               float var15 = var10[var11 * 2 + 1];
               var10[var11 * 2] = (float)(var14 * Math.cos(var13) - var15 * Math.sin(var13));
               var10[var11 * 2 + 1] = (float)(var14 * Math.sin(var13) + var15 * Math.cos(var13));
            }

            var1.add(var10);
         }
      }

      return var1.toArray(new float[0][]);
   }

   private float[] rgx(float var1, float var2, float var3, int var4) {
      float[] var5 = new float[var4 * 2];
      float var6 = 0.0F;

      for (int var7 = 0; var7 < var4; var7++) {
         float var8 = (float)var7 / (var4 - 1);
         float var9 = var2 + (var3 - var2) * var8;
         if (var7 > 0 && var7 < var4 - 1) {
            var6 = var6 * 0.5F + (this.rgj.nextFloat() - 0.5F) * 0.35F;
         }

         float var10 = var1 + var6 / Math.max(0.2F, var9);
         var5[var7 * 2] = (float)Math.cos(var10) * var9;
         var5[var7 * 2 + 1] = (float)Math.sin(var10) * var9;
      }

      return var5;
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rfy var2 = rfz;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null
         && var2.isEnabled()
         && !var2.rgi.isEmpty()
         && var3.world != null
         && var3.player != null
         && !var3.options.hudHidden
         && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.rgm) {
            var2.rgm = unf.frame();
            float var4 = unf.delta();
            var2.rgn += var4;

            usn var5;
            try {
               var5 = usn.capture(var1.getTickProgress(true), var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
            } catch (Throwable var12) {
               return;
            }

            float var6 = (float)var2.rgd.get();
            uut.beginFrame();
            uut.pushAlpha((float)var2.rge.get());

            try {
               for (int var7 = var2.rgi.size() - 1; var7 >= 0; var7--) {
                  rfv var8 = var2.rgi.get(var7);
                  var8.age += var4;
                  if (var8.age >= var6) {
                     var2.rgi.remove(var7);
                  } else if (!(var5.distance(var8.x, var8.y, var8.z) > 64.0)) {
                     var2.rha(var0, var5, var8, var8.age / var6);
                  }
               }
            } finally {
               uut.additive(false);
               uut.popAlpha();
            }
         }
      }
   }

   private int rgy(String var1) {
      return switch (var1) {
         case "Winter" -> 1;
         case "Lava" -> 2;
         case "Cosmos" -> 0;
         case "Aurora" -> 3;
         case "Ocean" -> 4;
         case "Neon" -> 5;
         case "Sakura" -> 6;
         default -> 7;
      };
   }

   private int[] rgz(String var1) {
      return switch (var1) {
         case "Winter" -> new int[]{-4199937, -1};
         case "Lava" -> new int[]{-34278, -11654};
         case "Aurora" -> new int[]{-11665488, -5796865};
         case "Ocean" -> new int[]{-11544321, -2556929};
         case "Sakura" -> new int[]{-24890, -7186};
         case "Cosmos" -> this.rgb.vivid(new int[]{-7709441, -13383425});
         case "Neon" -> this.rgb.vivid(new int[]{-49717, -12722945});
         case "Lightning" -> this.rgb.vivid(new int[]{-7359233, -1779457});
         default -> new int[]{this.rgb.color() | 0xFF000000, this.rgb.color2() | 0xFF000000};
      };
   }

   private void rha(DrawContext var1, usn var2, rfv var3, float var4) {
      String var5 = this.rga.get();
      int[] var6 = this.rgz(var5);
      float var7 = Math.min(1.0F, var3.age / 0.08F);
      float var8 = var4 < 0.5F ? 1.0F : 1.0F - vcq.inOutCubic((var4 - 0.5F) / 0.5F);
      float var9 = var7 * var8;
      float var10 = vcq.outCubic(Math.min(1.0F, var4 / 0.55F));
      float var11 = (float)this.rgc.get() * (0.3F + 0.7F * var10);
      if (var5.equals("Lightning")) {
         this.rhd(var1, var2, var3, var11, var9, var4, var6);
      } else {
         this.rhb(var1, var2, var3, var11 / 0.8F, this.rgy(var5), var6, var9, var4);
      }

      if (this.rgf.get()) {
         this.rhe(var1, var2, var3, var5, var11, var9, var4, var6);
      }
   }

   private void rhb(DrawContext var1, usn var2, rfv var3, float var4, int var5, int[] var6, float var7, float var8) {
      int var9 = ujt.withAlpha(var6[0], Math.round(255.0F * var7));
      byte var10 = 6;
      boolean var11 = true;

      for (int var12 = 0; var12 <= var10; var12++) {
         for (int var13 = 0; var13 <= var10; var13++) {
            int var14 = var12 * (var10 + 1) + var13;
            double var15 = var3.x - var4 + 2.0 * var4 * var13 / var10;
            double var17 = var3.z - var4 + 2.0 * var4 * var12 / var10;
            this.rgq[var14] = var2.depth(var15, var3.y, var17) > 0.08F && var2.project3(var15, var3.y, var17, this.rgp[var14]);
            var11 &= this.rgq[var14];
         }
      }

      if (var11) {
         this.rhc(0, this.rgp[0], 0.0F, 0.0F);
         this.rhc(1, this.rgp[var10], 1.0F, 0.0F);
         this.rhc(2, this.rgp[var10 * (var10 + 1) + var10], 1.0F, 1.0F);
         this.rhc(3, this.rgp[var10 * (var10 + 1)], 0.0F, 1.0F);
         uut.pattern(var1, this.rgo, var5, 2, var9, var6[1], var8, this.rgn + var3.seed);
      } else {
         for (int var22 = 0; var22 < var10; var22++) {
            for (int var23 = 0; var23 < var10; var23++) {
               int var24 = var22 * (var10 + 1) + var23;
               int var25 = var24 + 1;
               int var16 = var24 + var10 + 1;
               int var26 = var16 + 1;
               if (this.rgq[var24] && this.rgq[var25] && this.rgq[var16] && this.rgq[var26]) {
                  float var18 = (float)var23 / var10;
                  float var19 = (float)(var23 + 1) / var10;
                  float var20 = (float)var22 / var10;
                  float var21 = (float)(var22 + 1) / var10;
                  this.rhc(0, this.rgp[var24], var18, var20);
                  this.rhc(1, this.rgp[var25], var19, var20);
                  this.rhc(2, this.rgp[var26], var19, var21);
                  this.rhc(3, this.rgp[var16], var18, var21);
                  uut.pattern(var1, this.rgo, var5, 2, var9, var6[1], var8, this.rgn + var3.seed);
               }
            }
         }
      }
   }

   private void rhc(int var1, float[] var2, float var3, float var4) {
      int var5 = var1 * 5;
      this.rgo[var5] = var2[0];
      this.rgo[var5 + 1] = var2[1];
      this.rgo[var5 + 2] = var3;
      this.rgo[var5 + 3] = var4;
      this.rgo[var5 + 4] = var2[2];
   }

   private void rhd(DrawContext var1, usn var2, rfv var3, float var4, float var5, float var6, int[] var7) {
      float var8 = var2.unitsPerBlock(var3.x, var3.y, var3.z);
      if (!(var8 <= 0.0F)) {
         float var9 = Math.min(1.0F, var6 / 0.25F);
         float var10 = 0.8F + 0.2F * (float)Math.sin(this.rgn * 38.0F + var3.seed);
         float var11 = Math.max(0.8F, Math.min(2.2F, var8 * 0.02F));
         float var12 = Math.min(7.0F, var8 * 0.07F);
         uut.additive(true);

         for (float[] var16 : var3.bolts) {
            int var17 = var16.length / 2;
            int var18 = Math.max(2, Math.round(var17 * var9));
            boolean var19 = var2.project(var3.x + var16[0] * var4, var3.y, var3.z + var16[1] * var4, this.rgr);

            for (int var20 = 1; var20 < var18; var20++) {
               boolean var21 = var2.project(var3.x + var16[var20 * 2] * var4, var3.y, var3.z + var16[var20 * 2 + 1] * var4, this.rgs);
               if (var19 && var21) {
                  float var22 = var5 * var10 * (1.0F - 0.4F * var20 / var17);
                  uut.softLine(
                     var1, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], var12 * 0.5F, var12, ujt.withAlpha(var7[0], Math.round(110.0F * var22))
                  );
                  uut.line(
                     var1, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], var11, ujt.withAlpha(ujt.lerp(var7[0], -1, 0.7F), Math.round(240.0F * var22))
                  );
               }

               this.rgr[0] = this.rgs[0];
               this.rgr[1] = this.rgs[1];
               var19 = var21;
            }
         }

         byte var23 = 40;
         boolean var24 = var2.project(var3.x + var4, var3.y, var3.z, this.rgr);

         for (int var25 = 1; var25 <= var23; var25++) {
            double var26 = (float) (Math.PI * 2) * var25 / var23;
            boolean var27 = var2.project(var3.x + Math.cos(var26) * var4, var3.y, var3.z + Math.sin(var26) * var4, this.rgs);
            if (var24 && var27) {
               uut.softLine(
                  var1, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], var12 * 0.4F, var12 * 0.8F, ujt.withAlpha(var7[0], Math.round(70.0F * var5))
               );
               uut.line(
                  var1, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], var11 * 0.8F, ujt.withAlpha(ujt.lerp(var7[0], -1, 0.5F), Math.round(200.0F * var5))
               );
            }

            this.rgr[0] = this.rgs[0];
            this.rgr[1] = this.rgs[1];
            var24 = var27;
         }

         uut.additive(false);
      }
   }

   private void rhe(DrawContext var1, usn var2, rfv var3, String var4, float var5, float var6, float var7, int[] var8) {
      GpuTextureView var9 = unm.view();
      float var10 = var2.unitsPerBlock(var3.x, var3.y, var3.z);
      if (var9 != null && !(var10 <= 0.0F)) {
         uut.additive(true);
         float[] var11 = var3.parts;
         int var12 = var11.length / 5;

         for (int var13 = 0; var13 < var12; var13++) {
            float var14 = var11[var13 * 5];
            float var15 = var11[var13 * 5 + 1] * var5;
            float var16 = var11[var13 * 5 + 2];
            float var17 = var11[var13 * 5 + 3];
            float var18 = var11[var13 * 5 + 4];
            double var19 = var3.x + Math.cos(var14) * var15;
            double var21 = var3.z + Math.sin(var14) * var15;
            double var23 = var3.y;
            float var25 = 1.0F;
            switch (var4) {
               case "Lava":
                  var23 += var3.age * 0.9 * var16;
                  var19 += Math.sin(var3.age * 3.0F + var17) * 0.05;
                  var25 = 1.0F - var7;
                  break;
               case "Winter":
                  var23 += 0.05 + var3.age * 0.25 * var16;
                  var25 = 0.5F + 0.5F * (float)Math.sin(this.rgn * 9.0F * var16 + var17);
                  break;
               case "Sakura":
                  var23 += var3.age * 0.5 * var16;
                  var19 += Math.sin(var3.age * 2.5F + var17) * 0.15;
                  var21 += Math.cos(var3.age * 2.1F + var17) * 0.15;
                  break;
               case "Ocean":
                  double var37 = 1.6 * var16;
                  double var30 = var37 * var3.age - 4.5 * var3.age * var3.age;
                  if (var30 < 0.0) {
                     continue;
                  }

                  var23 += var30;
                  double var32 = 0.5 * var3.age * var16;
                  var19 += Math.cos(var14) * var32;
                  var21 += Math.sin(var14) * var32;
                  break;
               case "Cosmos":
                  var23 += 0.1 + var17 / (float) (Math.PI * 2) * 0.6;
                  var25 = Math.max(0.0F, (float)Math.sin(this.rgn * 4.0F * var16 + var17));
                  break;
               default:
                  double var28 = 0.7 * var3.age * var16;
                  var19 += Math.cos(var14) * var28;
                  var21 += Math.sin(var14) * var28;
                  var23 += 0.8 * var16 * var3.age - 2.0 * var3.age * var3.age;
                  var25 = 1.0F - var7;
            }

            if (var2.project(var19, var23, var21, this.rgr)) {
               float var35 = Math.min(14.0F, Math.max(2.0F, var10 * 0.09F * var18));
               float var36 = var6 * var25;
               if (!(var36 <= 0.02F)) {
                  int var38 = var13 % 3 == 0 ? var8[1] : var8[0];
                  uut.sprite(var1, var9, this.rgr[0], this.rgr[1], var35 * 3.0F, ujt.withAlpha(var38, Math.round(90.0F * var36)));
                  uut.sprite(var1, var9, this.rgr[0], this.rgr[1], var35, ujt.withAlpha(ujt.lerp(var38, -1, 0.6F), Math.round(230.0F * var36)));
               }
            }
         }

         uut.additive(false);
      }
   }
}
