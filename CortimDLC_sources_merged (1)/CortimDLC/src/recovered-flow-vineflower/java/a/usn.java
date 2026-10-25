package a;

import java.lang.reflect.Method;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerLikeState;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

public final class usn {
   private static Method uso;
   private static boolean usp;
   private final Matrix4f usq;
   private final Matrix4f usr;
   private final Matrix4f uss;
   private final Vec3d ust;
   private final float usu;
   private final float usv;
   private static usn usw;
   private static long usx = -1L;
   private static float usy = Float.NaN;
   private final Vector4f usz = new Vector4f();

   private usn(Matrix4f var1, Matrix4f var2, Vec3d var3, float var4, float var5) {
      this.usq = var1;
      this.usr = var2;
      this.uss = new Matrix4f(var1).mul(var2);
      this.ust = var3;
      this.usu = var4;
      this.usv = var5;
   }

   public static usn capture(float var0, float var1, float var2) {
      usn var3 = usw;
      if (var3 != null && usx == unf.frame() && usy == var0 && var3.usu == var1 && var3.usv == var2) {
         return var3;
      }

      var3 = utc(var0, var1, var2);
      usw = var3;
      usx = unf.frame();
      usy = var0;
      return var3;
   }

   public static usn fresh(float var0, float var1, float var2) {
      return utc(var0, var1, var2);
   }

   private static usn utc(float var0, float var1, float var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      GameRenderer var4 = var3.gameRenderer;
      Camera var5 = var4.getCamera();
      Matrix4f var6 = new Matrix4f(var4.getBasicProjectionMatrix(utd(var4, var5, var0)));
      if (var3.options.getBobView().getValue() && var3.getCameraEntity() instanceof AbstractClientPlayerEntity var7) {
         var6.mul(ute(var7, var5.getLastTickProgress()));
      }

      Matrix4f var9 = new Matrix4f().rotation(var5.getRotation().conjugate(new Quaternionf()));
      return new usn(var6, var9, var5.getCameraPos(), var1, var2);
   }

   private static float utd(GameRenderer var0, Camera var1, float var2) {
      if (uso == null && !usp) {
         for (Method var6 : GameRenderer.class.getDeclaredMethods()) {
            Class[] var7 = var6.getParameterTypes();
            if (var6.getReturnType() == float.class && var7.length == 3 && var7[0] == Camera.class && var7[1] == float.class && var7[2] == boolean.class) {
               var6.setAccessible(true);
               uso = var6;
               break;
            }
         }

         usp = uso == null;
      }

      if (uso != null) {
         try {
            return (Float)uso.invoke(var0, var1, var2, true);
         } catch (ReflectiveOperationException | RuntimeException var8) {
            usp = true;
            uso = null;
         }
      }

      return MinecraftClient.getInstance().options.getFov().getValue().floatValue();
   }

   private static Matrix4f ute(AbstractClientPlayerEntity var0, float var1) {
      ClientPlayerLikeState var2 = var0.getState();
      float var3 = var2.getReverseLerpedDistanceMoved(var1);
      float var4 = var2.lerpMovement(var1);
      MatrixStack var5 = new MatrixStack();
      var5.translate(MathHelper.sin(var3 * (float) Math.PI) * var4 * 0.5F, -Math.abs(MathHelper.cos(var3 * (float) Math.PI) * var4), 0.0F);
      var5.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.sin(var3 * (float) Math.PI) * var4 * 3.0F));
      var5.multiply(RotationAxis.POSITIVE_X.rotationDegrees(Math.abs(MathHelper.cos(var3 * (float) Math.PI - 0.2F) * var4) * 5.0F));
      return var5.peek().getPositionMatrix();
   }

   public Vector4f viewSpace(double var1, double var3, double var5) {
      Vector4f var7 = new Vector4f((float)(var1 - this.ust.x), (float)(var3 - this.ust.y), (float)(var5 - this.ust.z), 1.0F);
      return this.usr.transform(var7);
   }

   public float depth(double var1, double var3, double var5) {
      float var7 = (float)(var1 - this.ust.x);
      float var8 = (float)(var3 - this.ust.y);
      float var9 = (float)(var5 - this.ust.z);
      return -(this.usr.m02() * var7 + this.usr.m12() * var8 + this.usr.m22() * var9 + this.usr.m32());
   }

   public boolean project(double var1, double var3, double var5, float[] var7) {
      Vector4f var8 = this.usz.set((float)(var1 - this.ust.x), (float)(var3 - this.ust.y), (float)(var5 - this.ust.z), 1.0F);
      this.uss.transform(var8);
      if (var8.w <= 0.05F) {
         return false;
      }

      var7[0] = (var8.x / var8.w * 0.5F + 0.5F) * this.usu;
      var7[1] = (0.5F - var8.y / var8.w * 0.5F) * this.usv;
      return true;
   }

   public boolean project3(double var1, double var3, double var5, float[] var7) {
      Vector4f var8 = this.usz.set((float)(var1 - this.ust.x), (float)(var3 - this.ust.y), (float)(var5 - this.ust.z), 1.0F);
      this.uss.transform(var8);
      if (var8.w <= 0.05F) {
         return false;
      }

      var7[0] = (var8.x / var8.w * 0.5F + 0.5F) * this.usu;
      var7[1] = (0.5F - var8.y / var8.w * 0.5F) * this.usv;
      var7[2] = 1.0F / var8.w;
      return true;
   }

   public void direction(double var1, double var3, double var5, float[] var7) {
      Vector4f var8 = this.usz.set((float)(var1 - this.ust.x), (float)(var3 - this.ust.y), (float)(var5 - this.ust.z), 1.0F);
      this.uss.transform(var8);
      float var9 = var8.x * this.usu;
      float var10 = -var8.y * this.usv;
      float var11 = (float)Math.hypot(var9, var10);
      if (var11 < 1.0E-4F) {
         var7[0] = 0.0F;
         var7[1] = 1.0F;
      } else {
         var7[0] = var9 / var11;
         var7[1] = var10 / var11;
      }
   }

   public float unitsPerBlock(double var1, double var3, double var5) {
      float var7 = this.depth(var1, var3, var5);
      return var7 <= 0.05F ? 0.0F : 0.5F * this.usv * this.usq.m11() / var7;
   }

   public float width() {
      return this.usu;
   }

   public float height() {
      return this.usv;
   }

   public boolean projectSegment(double var1, double var3, double var5, double var7, double var9, double var11, float var13, float[] var14, float[] var15) {
      float var16 = this.depth(var1, var3, var5);
      float var17 = this.depth(var7, var9, var11);
      if (var16 <= var13 && var17 <= var13) {
         return false;
      }

      if (var16 < var13) {
         double var18 = (var13 - var16) / (var17 - var16);
         var1 += (var7 - var1) * var18;
         var3 += (var9 - var3) * var18;
         var5 += (var11 - var5) * var18;
      } else if (var17 < var13) {
         double var20 = (var13 - var17) / (var16 - var17);
         var7 += (var1 - var7) * var20;
         var9 += (var3 - var9) * var20;
         var11 += (var5 - var11) * var20;
      }

      if (!this.project(var1, var3, var5, var15)) {
         return false;
      }

      var14[0] = var15[0];
      var14[1] = var15[1];
      if (!this.project(var7, var9, var11, var15)) {
         return false;
      }

      var14[2] = var15[0];
      var14[3] = var15[1];
      return true;
   }

   public Vec3d camera() {
      return this.ust;
   }

   public double distance(double var1, double var3, double var5) {
      return Math.sqrt(this.ust.squaredDistanceTo(var1, var3, var5));
   }
}
