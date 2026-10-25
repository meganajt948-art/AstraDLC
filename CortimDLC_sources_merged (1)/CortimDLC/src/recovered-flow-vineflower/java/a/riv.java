package a;

import java.util.Arrays;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class riv extends kfe {
   private static final float riw = 0.045F;
   private static final float rix = 0.16F;
   private static final long riy = 250000000L;
   private final vmc riz = this.add(new vmc("Сила", 0.5, 0.05, 1.0, 0.05).percent());
   private final vmc rja = this.add(new vmc("Плавность", 0.5, 0.0, 1.0, 0.05).percent());
   private final vmc rjb = this.add(new vmc("От движения", 0.5, 0.0, 1.0, 0.05).percent());
   private final vlv rjc = this.add(new vlv("Качество", "Высокое", "Низкое", "Среднее", "Высокое", "Ультра"));
   private static float rjd;
   private final Quaternionf rje = new Quaternionf();
   private final Quaternionf rjf = new Quaternionf();
   private final Quaternionf rjg = new Quaternionf();
   private final Matrix4f rjh = new Matrix4f();
   private final Matrix4f rji = new Matrix4f();
   private final float[] rjj = new float[3];
   private final float[] rjk = new float[3];
   private final float[] rjl = new float[3];
   private final float[] rjm = new float[3];
   private Vec3d rjn;
   private ClientWorld rjo;
   private long rjp;
   private float rjq;
   private float rjr;
   private float rjs;

   public riv() {
      super(new String(new char[]{'M', 'o', 't', 'i', 'o', 'n', 'B', 'l', 'u', 'r'}), "Smooth motion blur, hand and HUD stay sharp", kfa.RENDER);
   }

   public static float turnSpeed() {
      return rjd;
   }

   @Override
   protected void onEnable() {
      this.rjv();
   }

   @Override
   protected void onDisable() {
      urc.release();
      this.rjv();
   }

   private void rjv() {
      this.rjn = null;
      this.rjo = null;
      this.rjp = 0L;
      this.rjq = 0.0F;
      this.rjr = 0.0F;
      this.rjs = 0.0F;
      Arrays.fill(this.rjj, 0.0F);
      Arrays.fill(this.rjk, 0.0F);
      Arrays.fill(this.rjl, 0.0F);
      Arrays.fill(this.rjm, 0.0F);
      rjd = 0.0F;
   }

   @Override
   public void onWorldRenderLate(MinecraftClient var1) {
      Camera var2 = var1.field_1773.method_19418();
      if (var1.field_1687 != null && var2.method_19332()) {
         long var3 = System.nanoTime();
         Quaternionf var5 = var2.method_23767();
         Vec3d var6 = var2.method_71156();
         if (this.rjn != null && this.rjo == var1.field_1687 && var3 - this.rjp <= 250000000L) {
            float var7 = (float)(var3 - this.rjp) / 1.0E9F;
            if (!(var7 < 1.0E-4F)) {
               this.rjp = var3;
               float var8 = this.rjs + (this.rjq > 0.0F ? this.rjq : var7);
               boolean var9 = this.rjs < 0.1F && this.rjr > 0.0F && var7 > this.rjr * 2.5F + 0.004F;
               this.rjr = this.rjr == 0.0F ? var7 : this.rjr + (Math.min(var7, this.rjr * 3.0F) - this.rjr) * 0.05F;
               this.rjq = var7;
               if (var9) {
                  this.rjs = var8;
               } else {
                  this.rjs = 0.0F;
                  this.rjw(var5, var6, var8);
               }

               float var10 = 0.045F * (float)this.riz.get();
               float var11 = this.rjk[0] * var10;
               float var12 = this.rjk[1] * var10;
               float var13 = this.rjk[2] * var10;
               float var14 = (float)Math.sqrt(var11 * var11 + var12 * var12 + var13 * var13);
               rjd = (float)Math.toDegrees(var14 / var10);
               float var15 = var10 * (float)this.rjb.get();
               float var16 = this.rjm[0] * var15;
               float var17 = this.rjm[1] * var15;
               float var18 = this.rjm[2] * var15;
               if (!(var14 < 2.5E-4F) || !(var16 * var16 + var17 * var17 + var18 * var18 < 2.5E-7F)) {
                  if (var14 > 1.0E-7F) {
                     this.rjg.rotationAxis(-var14, var11, var12, var13).mul(var5);
                  } else {
                     this.rjg.set(var5);
                  }

                  this.rjh.rotation(var5);
                  this.rji.rotation(this.rjg.conjugate());
                  String var21 = this.rjc.get();
                  byte var19;
                  float var20;
                  switch (var21) {
                     case "Низкое":
                        var19 = 6;
                        var20 = 0.75F;
                        break;
                     case "Среднее":
                        var19 = 9;
                        var20 = 0.9F;
                        break;
                     case "Ультра":
                        var19 = 16;
                        var20 = 1.3F;
                        break;
                     default:
                        var19 = 12;
                        var20 = 1.1F;
                  }

                  urc.draw(this.rjh, this.rji, var16, var17, var18, 0.16F, var19, var20);
               }
            }
         } else {
            this.rjv();
            this.rje.set(var5);
            this.rjn = var6;
            this.rjo = var1.field_1687;
            this.rjp = var3;
         }
      } else {
         this.rjv();
      }
   }

   private void rjw(Quaternionf var1, Vec3d var2, float var3) {
      this.rje.conjugate(this.rjf);
      var1.mul(this.rjf, this.rjf);
      if (this.rjf.w < 0.0F) {
         this.rjf.set(-this.rjf.x, -this.rjf.y, -this.rjf.z, -this.rjf.w);
      }

      float var4 = (float)Math.sqrt(this.rjf.x * this.rjf.x + this.rjf.y * this.rjf.y + this.rjf.z * this.rjf.z);
      float var5 = 2.0F * (float)Math.atan2(var4, this.rjf.w);
      float var6 = (var4 > 1.0E-7F ? var5 / var4 : 2.0F) / var3;
      double var7 = var2.method_1022(this.rjn);
      float var9 = 1.0F - (float)Math.exp(-2.0F * var3 / (0.015F + 0.05F * (float)this.rja.get()));
      if (var5 < 2.2F) {
         rjx(this.rjj, this.rjk, this.rjf.x * var6, this.rjf.y * var6, this.rjf.z * var6, var9);
      }

      if (var7 / var3 > 80.0) {
         Arrays.fill(this.rjl, 0.0F);
         Arrays.fill(this.rjm, 0.0F);
      } else {
         rjx(
            this.rjl,
            this.rjm,
            (float)(var2.field_1352 - this.rjn.field_1352) / var3,
            (float)(var2.field_1351 - this.rjn.field_1351) / var3,
            (float)(var2.field_1350 - this.rjn.field_1350) / var3,
            var9
         );
      }

      this.rje.set(var1);
      this.rjn = var2;
   }

   private static void rjx(float[] var0, float[] var1, float var2, float var3, float var4, float var5) {
      var0[0] += (var2 - var0[0]) * var5;
      var0[1] += (var3 - var0[1]) * var5;
      var0[2] += (var4 - var0[2]) * var5;
      var1[0] += (var0[0] - var1[0]) * var5;
      var1[1] += (var0[1] - var1[1]) * var5;
      var1[2] += (var0[2] - var1[2]) * var5;
   }
}
