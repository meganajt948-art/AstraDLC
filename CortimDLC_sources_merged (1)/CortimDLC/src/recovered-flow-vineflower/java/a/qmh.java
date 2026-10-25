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
      Vec3d var3 = var2.method_1020(var1.method_33571());
      double var4 = tbp.yawTo(var3.field_1352, var3.field_1350);
      double var6 = tbp.pitchTo(var3.field_1351, Math.sqrt(var3.field_1352 * var3.field_1352 + var3.field_1350 * var3.field_1350));
      return Math.hypot(MathHelper.method_15338(var4 - var1.method_36454()), var6 - var1.method_36455());
   }

   public void aim(MinecraftClient var1, ClientPlayerEntity var2, Object var3, Vec3d var4) {
      if (var4 != null && var3 != null) {
         if (var3 != this.qmm) {
            this.qmm = var3;
            this.qmn = (this.qmi.nextDouble() - 0.5) * 0.3;
         }

         Vec3d var5 = var4.method_1020(var2.method_33571());
         double var6 = Math.sqrt(var5.field_1352 * var5.field_1352 + var5.field_1350 * var5.field_1350);
         double var8 = MathHelper.method_15338(tbp.yawTo(var5.field_1352, var5.field_1350) - var2.method_36454());
         double var10 = tbp.pitchTo(var5.field_1351, var6) - var2.method_36455();
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
            float var13 = var2.field_5982;
            float var14 = var2.field_6004;
            double var15 = var7 / 0.15;
            var2.method_5872(var9 * var15, var11 * var15);
            var2.field_5982 = var13;
            var2.field_6004 = var14;
         }
      }
   }
}
