package a;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.util.Arrays;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.attribute.EnvironmentAttributeInterpolator;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.dimension.DimensionType.Skybox;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class rxv extends kfe {
   static final int rxw = 7;
   static final float rxx = 3.0F;
   static final float rxy = (float) (Math.PI / 180.0);
   final vla rxz = this.add(new vla("Цвет", "Snow"));
   final vmc rya = this.add(new vmc("Плотность", 0.45, 0.0, 1.0, 0.01).percent());
   final vmc ryb = this.add(new vmc("Прозрачность", 0.1, 0.0, 0.95, 0.01).percent());
   final vmc ryc = this.add(new vmc("Клубы", 0.7, 0.0, 1.0, 0.05).percent());
   final vmc ryd = this.add(new vmc("Яркость", 1.0, 0.3, 2.0, 0.05).percent());
   final vmc rye = this.add(new vmc("Спад по высоте", 0.15, 0.0, 1.0, 0.05).percent());
   final vmc ryf = this.add(new vmc("Размер", 1.0, 0.4, 2.5, 0.05).percent());
   final vmc ryg = this.add(new vmc("Скорость", 1.0, 0.0, 3.0, 0.1).unit("x"));
   final vmc ryh = this.add(new vmc("Завихрения", 1.0, 0.0, 2.0, 0.05).percent());
   final vmc ryi = this.add(new vmc("Свет солнца", 1.0, 0.0, 2.0, 0.05).percent());
   final vkl ryj = this.add(new vkl("Скрыть облака", true));
   final vlv ryk = this.add(new vlv("Качество", "Среднее", "Низкое", "Среднее", "Высокое", "Ультра"));
   final vkl ryl = this.add(new vkl("Расступается", true));
   final double[] rym = new double[7];
   final double[] ryn = new double[7];
   final double[] ryo = new double[7];
   final float[] ryp = new float[7];
   final float[] ryq = new float[7];
   final float[] ryr = new float[7];
   final long[] rys = new long[7];
   final Matrix4f ryt = new Matrix4f();
   final Matrix4f ryu = new Matrix4f();
   final Quaternionf ryv = new Quaternionf();
   Vec3d ryw;
   long ryx;
   float ryy;
   double ryz;
   double rza;
   double rzb;
   double rzc = Double.NaN;
   float rzd = -1.0F;
   float rze;
   Vec3d rzf;
   Vec3d rzg;
   double rzh;
   double rzi;
   double rzj;

   public rxv() {
      super(new String(new char[]{'V', 'o', 'l', 'u', 'm', 'e', 't', 'r', 'i', 'c', 'F', 'o', 'g'}), "Volumetric fog that curls around you", kfa.RENDER);
   }

   @Override
   protected void onEnable() {
      this.rzm();
   }

   @Override
   protected void onDisable() {
      this.rzn(false);
      vaf.release();
      this.rzm();
   }

   void rzm() {
      this.ryx = 0L;
      this.ryw = null;
      this.rzc = Double.NaN;
      this.rzd = -1.0F;
      this.rzf = null;
      this.rzg = null;
      this.rzh = 0.0;
      this.rzi = 0.0;
      this.rzj = 0.0;
      Arrays.fill(this.rys, 0L);
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      ClientWorld var3 = var1.world;
      Camera var4 = var1.gameRenderer.getCamera();
      this.rzn(this.ryj.get());
      if (var2 != null && var3 != null && var4.isReady() && var4.getSubmersionType() == CameraSubmersionType.NONE) {
         long var5 = System.nanoTime();
         float var7 = this.ryx == 0L ? 0.0F : Math.min(0.1F, (float)(var5 - this.ryx) / 1.0E9F);
         this.ryx = var5;
         float var8 = var1.getRenderTickCounter().getTickProgress(false);
         float var9 = (float)this.ryg.get();
         this.ryy += var7 * var9;
         this.ryz += var7 * var9 * 0.55;
         this.rza += var7 * var9 * 0.16;
         this.rzb += var7 * var9 * 0.32;
         Vec3d var10 = var2.getLerpedPos(var8);
         int var11 = var3.getTopY(Type.MOTION_BLOCKING, (int)Math.floor(var10.x), (int)Math.floor(var10.z));
         double var12 = Math.min(var11, var10.y) - 1.0;
         if (!Double.isNaN(this.rzc) && !(Math.abs(var12 - this.rzc) > 48.0)) {
            this.rzc = this.rzc + (var12 - this.rzc) * (1.0 - Math.exp(-var7 / 1.4));
         } else {
            this.rzc = var12;
         }

         BlockPos var14 = var4.getBlockPos();
         float var15 = var3.getLightLevel(LightType.SKY, var14) / 15.0F;
         float var16 = var3.getLightLevel(LightType.BLOCK, var14) / 15.0F;
         if (this.rzd < 0.0F) {
            this.rzd = var15;
            this.rze = var16;
         } else {
            float var17 = 1.0F - (float)Math.exp(-var7 / 0.8F);
            this.rzd = this.rzd + (var15 - this.rzd) * var17;
            this.rze = this.rze + (var16 - this.rze) * var17;
         }

         this.rzo(var10.add(0.0, 0.9, 0.0), var7, var5);
         byte var18;
         byte var19;
         byte var20;
         float var21;
         float var46;
         switch (this.ryk.get()) {
            case "Низкое":
               var46 = 0.35F;
               var18 = 18;
               var19 = 3;
               var20 = 1;
               var21 = 48.0F;
               break;
            case "Среднее":
               var46 = 0.5F;
               var18 = 24;
               var19 = 4;
               var20 = 2;
               var21 = 64.0F;
               break;
            case "Ультра":
               var46 = 0.75F;
               var18 = 48;
               var19 = 5;
               var20 = 3;
               var21 = 110.0F;
               break;
            default:
               var46 = 0.5F;
               var18 = 32;
               var19 = 5;
               var20 = 2;
               var21 = 80.0F;
         }

         EnvironmentAttributeInterpolator var47 = var4.getEnvironmentAttributeInterpolator();
         boolean var48 = var3.getDimension().skybox() == Skybox.OVERWORLD;
         float[] var24 = new float[]{0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F};
         float[] var25 = new float[]{0.0F, 0.0F, 0.0F, 0.0F};
         if (var48) {
            float var26 = var3.getRainGradient(var8);
            float var27 = var3.getThunderGradient(var8);
            float var28 = Math.max(0.0F, 1.0F - 0.7F * var26 - 0.2F * var27);
            float var29 = var47.get(EnvironmentAttributes.SUN_ANGLE_VISUAL, var8) * (float) (Math.PI / 180.0);
            float var30 = var47.get(EnvironmentAttributes.MOON_ANGLE_VISUAL, var8) * (float) (Math.PI / 180.0);
            float var31 = (float)Math.cos(var29);
            float var32 = (float)Math.cos(var30);
            float var33 = rzr(-0.06F, 0.18F, var31) * var28 * 0.4F;
            float var34 = rzr(-0.06F, 0.2F, var32) * var28 * 0.16F;
            float var35 = (float)this.ryi.get();
            if (var33 >= var34) {
               float var36 = rzr(0.0F, 0.45F, var31);
               var24 = new float[]{(float)(-Math.sin(var29)), var31, 0.0F, var33 * var35, 1.0F, 0.58F + 0.37F * var36, 0.32F + 0.54F * var36};
            } else {
               var24 = new float[]{(float)(-Math.sin(var30)), var32, 0.0F, var34 * var35, 0.52F, 0.62F, 0.95F};
            }

            int var59 = var47.get(EnvironmentAttributes.SKY_COLOR_VISUAL, var8);
            var25 = new float[]{(var59 >> 16 & 0xFF) / 255.0F, (var59 >> 8 & 0xFF) / 255.0F, (var59 & 0xFF) / 255.0F, 0.3F};
         }

         float var49 = uhs.boost(var1);
         float var50 = Math.max(0.18F + 0.82F * this.rzd, var49);
         float var51 = this.rze * 0.25F * (1.0F - 0.75F * this.rzd);
         float var52 = var48 ? (0.13F + 0.55F * var49) * (1.0F - 0.8F * uhs.daylight(var1)) : 0.12F + 0.5F * var49;
         float var53 = (float)(0.005 * Math.pow(80.0, this.rya.get()));
         float var54 = Math.max(128.0F, Math.min(1536.0F, var1.options.getClampedViewDistance() * 24.0F));
         int var55 = this.rxz.color();
         int var56 = this.rxz.color2();
         Vec3d var57 = var4.getCameraPos();
         boolean var58 = this.ryw != null && this.ryw.squaredDistanceTo(var57) < 64.0;
         if (this.ryw == null) {
            this.ryv.set(var4.getRotation());
            this.ryw = var57;
         }

         this.ryt.rotation(var4.getRotation());
         this.ryu.rotation(this.ryv.conjugate(new Quaternionf()));
         float var60 = (float)(var57.x - this.ryw.x);
         float var37 = (float)(var57.y - this.ryw.y);
         float var38 = (float)(var57.z - this.ryw.z);
         this.ryv.set(var4.getRotation());
         this.ryw = var57;
         float[] var39 = var24;
         float[] var40 = var25;
         byte var41 = var18;
         byte var42 = var19;
         byte var43 = var20;
         float var44 = var21;
         float var45 = var52;
         vaf.draw(var46, var58, var20x -> {
            var20x.putMat4f(this.ryt);
            var20x.putMat4f(this.ryu);
            var20x.putVec4(var60, var37, var38, var45);
            var20x.putVec4((float)var57.x, (float)var57.y, (float)var57.z, var54);
            var20x.putVec4(var39[0], var39[1], var39[2], var39[3]);
            var20x.putVec4(var39[4], var39[5], var39[6], 0.0F);
            var20x.putVec4(var40[0], var40[1], var40[2], var40[3]);
            var20x.putVec4(var51, var51 * 0.72F, var51 * 0.45F, var50);
            var20x.putVec4(rzs(var55), rzt(var55), rzu(var55), (float)this.ryd.get());
            var20x.putVec4(rzs(var56), rzt(var56), rzu(var56), (float)(1.0 - this.ryb.get()));
            var20x.putVec4(var53, (float)this.rzc, (float)(this.rye.get() * 0.05), (float)(1.0 / (7.0 * this.ryf.get())));
            var20x.putVec4((float)this.ryz, (float)this.rza, (float)this.rzb, this.ryy);
            var20x.putVec4((float)this.ryh.get(), 1.3F, 0.9F, (float)this.ryc.get());
            var20x.putVec4(var44, var41, var42, var43);
            this.rzp(var20x, var5);
         });
      } else {
         this.ryx = 0L;
         this.ryw = null;
      }
   }

   void rzn(boolean var1) {
      ujl.hide(this, var1);
   }

   void rzo(Vec3d var1, float var2, long var3) {
      if (this.rzf != null && var2 > 0.0F) {
         double var5 = (var1.x - this.rzf.x) / var2;
         double var7 = (var1.y - this.rzf.y) / var2;
         double var9 = (var1.z - this.rzf.z) / var2;
         if (this.rzf.squaredDistanceTo(var1) > 36.0) {
            Arrays.fill(this.rys, 0L);
            this.rzg = null;
            var5 = 0.0;
            var7 = 0.0;
            var9 = 0.0;
         }

         double var11 = 1.0 - Math.exp(-var2 * 8.0);
         this.rzh = this.rzh + (var5 - this.rzh) * var11;
         this.rzi = this.rzi + (var7 - this.rzi) * var11;
         this.rzj = this.rzj + (var9 - this.rzj) * var11;
      }

      this.rzf = var1;
      if (this.rzg == null || this.rzg.squaredDistanceTo(var1) > 0.64) {
         for (int var13 = 6; var13 > 0; var13--) {
            this.rym[var13] = this.rym[var13 - 1];
            this.ryn[var13] = this.ryn[var13 - 1];
            this.ryo[var13] = this.ryo[var13 - 1];
            this.ryp[var13] = this.ryp[var13 - 1];
            this.ryq[var13] = this.ryq[var13 - 1];
            this.ryr[var13] = this.ryr[var13 - 1];
            this.rys[var13] = this.rys[var13 - 1];
         }

         this.rym[0] = var1.x;
         this.ryn[0] = var1.y;
         this.ryo[0] = var1.z;
         this.ryp[0] = (float)this.rzh;
         this.ryq[0] = (float)this.rzi;
         this.ryr[0] = (float)this.rzj;
         this.rys[0] = var3;
         this.rzg = var1;
      }
   }

   void rzp(Std140Builder var1, long var2) {
      float[][] var4 = new float[8][4];
      float[][] var5 = new float[8][4];
      if (this.ryl.get() && this.rzf != null) {
         var4[0] = new float[]{(float)this.rzf.x, (float)this.rzf.y, (float)this.rzf.z, 1.0F};
         var5[0] = rzq((float)this.rzh, (float)this.rzi, (float)this.rzj, 1.25F);

         for (int var6 = 0; var6 < 7; var6++) {
            if (this.rys[var6] != 0L) {
               float var7 = (float)(var2 - this.rys[var6]) / 1.0E9F;
               float var8 = (float)Math.sqrt(this.ryp[var6] * this.ryp[var6] + this.ryq[var6] * this.ryq[var6] + this.ryr[var6] * this.ryr[var6]);
               float var9 = 1.0F - var7 / 3.0F;
               if (!(var9 <= 0.0F) && !(var8 < 0.5F)) {
                  float var10 = var9 * var9 * Math.min(1.0F, var8 / 3.0F);
                  var4[var6 + 1] = new float[]{(float)this.rym[var6], (float)this.ryn[var6], (float)this.ryo[var6], var10};
                  var5[var6 + 1] = rzq(this.ryp[var6], this.ryq[var6], this.ryr[var6], 1.25F + var7 * 0.9F);
               }
            }
         }
      }

      float var11 = 0.0F;
      if (var4[0][3] > 0.0F) {
         for (int var12 = 0; var12 < 8; var12++) {
            if (!(var4[var12][3] <= 0.0F)) {
               float var15 = var4[var12][0] - var4[0][0];
               float var18 = var4[var12][1] - var4[0][1];
               float var21 = var4[var12][2] - var4[0][2];
               var11 = Math.max(var11, (float)Math.sqrt(var15 * var15 + var18 * var18 + var21 * var21) + var5[var12][3] * 4.8F);
            }
         }
      }

      var1.putVec4(var4[0][0], var4[0][1], var4[0][2], var11);

      for (float[] var22 : var4) {
         var1.putVec4(var22[0], var22[1], var22[2], var22[3]);
      }

      for (float[] var23 : var5) {
         var1.putVec4(var23[0], var23[1], var23[2], var23[3]);
      }
   }

   static float[] rzq(float var0, float var1, float var2, float var3) {
      float var4 = (float)Math.sqrt(var0 * var0 + var1 * var1 + var2 * var2) / 5.0F;
      float var5 = var4 > 1.6F ? 1.6F / var4 : 1.0F;
      return new float[]{var0 / 5.0F * var5, var1 / 5.0F * var5, var2 / 5.0F * var5, var3};
   }

   static float rzr(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   static float rzs(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   static float rzt(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   static float rzu(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }
}
