package a;

import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class qmh {
   private final Random qmi = new Random();
   private double qmj = 110.0;
   private double qmk;
   private double qml;
   private Object qmm;
   private double qmn;

   public void cap(double var1) {
      this.qmj = var1;
   }

   public double cap() {
      return this.qmj;
   }

   public void reset() {
      this.qmk = 0.0;
      this.qml = 0.0;
      this.qmm = null;
   }

   public double error(ClientPlayerEntity var1, Vec3d var2) {
      Vec3d var3 = var2.subtract(var1.getEyePos());
      double var4 = tbp.yawTo(var3.x, var3.z);
      double var6 = tbp.pitchTo(var3.y, Math.sqrt(var3.x * var3.x + var3.z * var3.z));
      return Math.hypot(MathHelper.wrapDegrees(var4 - var1.getYaw()), var6 - var1.getPitch());
   }

   public void aim(MinecraftClient var1, ClientPlayerEntity var2, Object var3, Vec3d var4) {
      if (var4 != null && var3 != null) {
         if (var3 != this.qmm) {
            this.qmm = var3;
            this.qmn = (this.qmi.nextDouble() - 0.5) * 0.3;
         }

         Vec3d var5 = var4.subtract(var2.getEyePos());
         double var6 = Math.sqrt(var5.x * var5.x + var5.z * var5.z);
         double var8 = MathHelper.wrapDegrees(tbp.yawTo(var5.x, var5.z) - var2.getYaw());
         double var10 = tbp.pitchTo(var5.y, var6) - var2.getPitch();
         double var12 = Math.hypot(var8, var10);
         if (!(var12 < 0.25)) {
            double var14;
            if (var12 <= 6.0) {
               var14 = var12;
            } else if (var12 <= this.qmj) {
               var14 = var12 * (0.985 + this.qmi.nextDouble() * 0.015);
            } else {
               var14 = this.qmj * (0.92 + this.qmi.nextDouble() * 0.08);
            }

            double var16 = var14 / var12;
            double var18 = var8 * var16;
            double var20 = var10 * var16;
            if (var12 > 8.0) {
               double var22 = this.qmn * (1.0 - Math.min(1.0, var14 / var12));
               var18 += -var10 * var16 * var22;
               var20 += var8 * var16 * var22;
            }

            this.qmq(var1, var2, var18, var20);
         }
      } else {
         this.qmm = null;
      }
   }

   private void qmq(MinecraftClient var1, ClientPlayerEntity var2, double var3, double var5) {
      double var7 = tcz.unit(var1);
      if (!(var7 <= 0.0)) {
         this.qmk += var3 / var7;
         this.qml += var5 / var7;
         long var9 = Math.round(this.qmk);
         long var11 = Math.round(this.qml);
         this.qmk -= var9;
         this.qml -= var11;
         if (var9 != 0L || var11 != 0L) {
            float var13 = var2.lastYaw;
            float var14 = var2.lastPitch;
            double var15 = var7 / 0.15;
            var2.changeLookDirection(var9 * var15, var11 * var15);
            var2.lastYaw = var13;
            var2.lastPitch = var14;
         }
      }
   }
}
