package a;

import flow.dev.a;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class lng {
   private static final double lnh = 30.0;
   private static final int lni = 10;
   private static final double lnj = 8.0;
   private static final double lnk = 45.0;
   private static final int lnl = 1;
   private static final int lnm = 2;
   private static final double lnn = 1.0;
   private static final double lno = 4.0;
   private static final double lnp = 4.0;
   private static final int lnq = 12;
   private static final double lnr = 150.0;
   private static final double lns = 1.5;
   private static final Object lnt = new Object();
   private final tel lnu = new tel();
   private final Random lnv = new Random();
   private final double[] lnw = new double[2];
   private boolean lnx;
   private double lny = 1.0;
   private double lnz = 45.0;
   private double loa;
   private double lob;
   private double loc;
   private double lod;
   private boolean loe;
   private float lof;
   private float log;
   private float loh;
   private float loi;
   private boolean loj;
   private Entity lok;
   private int lol;
   private int lom;
   private double lon;
   private ClientPlayerEntity loo;
   private float lop;
   private float loq;
   private double lor;
   private double los;

   public void use(tck var1, double var2) {
      this.lny = var2;
      this.lnu.use(var1);
      this.lnu.tune(var2, 1.0, 1.0);
      this.lnu.verticalAware(true);
   }

   public void vertical(double var1) {
      this.lnu.tune(this.lny, 1.0, var1);
   }

   public void height(double var1, double var3) {
      this.lnu.height(var1, var3);
   }

   public void stepCap(double var1) {
      this.lnz = var1;
   }

   public void verticalAware(boolean var1) {
      this.lnu.verticalAware(var1);
   }

   public Entity target() {
      return this.loj ? (this.lok != null ? this.lok : this.lnu.target()) : null;
   }

   public float cameraYaw(ClientPlayerEntity var1) {
      return this.loe ? this.lof : var1.method_36454();
   }

   public double maxTurn() {
      return 30.0 * this.lny;
   }

   public boolean idle() {
      return this.loa == 0.0 && this.lob == 0.0;
   }

   public String debugOffsets() {
      return String.format(
         Locale.ROOT, a.c(-1959140365, "\ue3f2驈ႄ躢Լ莇㧟뀱⸹\ua4ce⍕\ud923執칎䑄슭碣\uf736淍\ueb9b扮ᠷ雜ക謫ƾ롈㘒곬⪻ꄎ忝햓䰻쩰䂗"), this.loa, this.lob, this.lol, this.lom, this.loj
      );
   }

   public double offset() {
      return Math.sqrt(this.loa * this.loa + this.lob * this.lob);
   }

   public void mode(boolean var1, ClientPlayerEntity var2) {
      if (this.lnx != var1) {
         this.end(var2);
         this.forget();
         this.lnx = var1;
      }
   }

   public void forget() {
      this.loa = 0.0;
      this.lob = 0.0;
      this.loc = 0.0;
      this.lod = 0.0;
      this.loj = false;
      this.lok = null;
      this.lol = 0;
      this.lom = 0;
   }

   public void reset() {
      this.forget();
      this.lnu.reset();
      this.loo = null;
   }

   public float serverYaw(ClientPlayerEntity var1) {
      return this.lnx && !this.loe ? (float)(var1.method_36454() + this.loa) : var1.method_36454();
   }

   public float serverPitch(ClientPlayerEntity var1) {
      return this.lnx && !this.loe ? MathHelper.method_15363((float)(var1.method_36455() + this.lob), -90.0F, 90.0F) : var1.method_36455();
   }

   public void begin(ClientPlayerEntity var1) {
      if (var1 != null) {
         if (!this.loe && this.loo == var1) {
            double var2 = var1.method_36454() - this.lop - this.lor;
            double var4 = var1.method_36455() - this.loq - this.los;
            if (this.lnx) {
               if ((this.loj || this.lol > 0) && !this.idle()) {
                  this.loa -= var2;
                  this.lob -= var4;
               }
            } else if (!this.loj && this.lol == 0 && !this.idle() && Math.abs(var2) + Math.abs(var4) > 1.0) {
               this.release();
            }
         }

         this.lor = this.los = 0.0;
         if (!this.loe) {
            this.low(var1);
         }

         if (this.lnx && !this.loe && !this.idle()) {
            this.loy(var1);
            var1.method_36456((float)(this.lof + this.loa));
            var1.method_36457(MathHelper.method_15363((float)(this.log + this.lob), -90.0F, 90.0F));
         }
      }
   }

   public void end(ClientPlayerEntity var1) {
      if (this.loe) {
         this.loe = false;
         if (var1 != null) {
            var1.method_36456(this.lof);
            var1.method_36457(this.log);
            var1.field_5982 = this.lof;
            var1.field_6004 = this.log;
            var1.field_3931 = this.loh;
            var1.field_3914 = this.loi;
            var1.field_3932 = this.loh + (this.lof - this.loh) * 0.5F;
            var1.field_3916 = this.loi + (this.log - this.loi) * 0.5F;
         }
      }
   }

   public void newTick(ClientPlayerEntity var1) {
      this.lon = 0.0;
      this.lor = this.los = 0.0;
      this.loo = var1;
      if (var1 != null) {
         this.lop = var1.method_36454();
         this.loq = var1.method_36455();
      }
   }

   public boolean approach(MinecraftClient var1, ClientPlayerEntity var2, lpp var3, Box var4) {
      float var5 = this.serverYaw(var2);
      float var6 = this.serverPitch(var2);
      if (!this.loj) {
         double var7 = MathHelper.method_15393(var3.yaw() - var5);
         double var9 = var3.pitch() - var6;
         if (var3.tick() > 10 && Math.sqrt(var7 * var7 + var9 * var9) < 8.0 * this.lny * var3.tick()) {
            return false;
         }
      }

      this.loj = true;
      this.lol = 0;
      this.lom = 0;
      Box var14 = var3.box();
      Vec3d var8 = var3.eye();
      Vec3d var15 = var3.aim();
      double var10 = tbp.hitU(
         var8.field_1352,
         var8.field_1350,
         (var14.field_1323 + var14.field_1320) * 0.5,
         (var14.field_1321 + var14.field_1324) * 0.5,
         (var14.field_1320 - var14.field_1323) * 0.5,
         var15.field_1352,
         var15.field_1350
      );
      double var12 = tbp.hitV(var14.field_1322, var14.field_1325 - var14.field_1322, var15.field_1351);
      if (this.lnu.steerAt(var2, var3.target(), var4, var8, var10, var12, 1, var5, var6, this.lnw)) {
         this.lov(var1, var2);
      }

      return true;
   }

   public void track(MinecraftClient var1, ClientPlayerEntity var2, Entity var3, int var4) {
      float var5 = this.serverYaw(var2);
      float var6 = this.serverPitch(var2);
      this.loj = true;
      this.lok = null;
      this.lol = 0;
      this.lom = 0;
      if (this.lnu.steer(var2, var3, var3.method_5829(), var2.method_33571(), var4, var5, var6, this.lnw)) {
         this.lov(var1, var2);
      }
   }

   public void turnBy(MinecraftClient var1, ClientPlayerEntity var2, Entity var3, double var4, double var6) {
      this.loj = true;
      this.lok = var3;
      this.lol = 0;
      this.lom = 0;
      this.loz(var1, var2, var4, var6, true);
   }

   private void lov(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = Math.hypot(this.lnw[0], this.lnw[1]);
      double var5 = var3 > this.lnz ? this.lnz / var3 : 1.0;
      this.loz(var1, var2, this.lnw[0] * var5, this.lnw[1] * var5, true);
   }

   public void hit(int var1) {
      this.lol = Math.max(this.lol, var1);
      this.loj = false;
   }

   public boolean home(MinecraftClient var1, ClientPlayerEntity var2) {
      this.loj = false;
      float var3 = this.serverYaw(var2);
      float var4 = this.serverPitch(var2);
      if (this.lol > 0) {
         this.lol--;
         this.lnu.idle(var3, var4);
         return false;
      } else if (this.idle()) {
         this.lom = 0;
         this.lnu.idle(var3, var4);
         return true;
      } else {
         this.lom++;
         this.low(var2);
         double var5 = MathHelper.method_15350(-this.loa, -150.0, 150.0);
         double var7 = var4 - this.lob;
         boolean var9 = this.lnu.steerTo(var2, lnt, var3 + var5, var7, 2, var3, var4, this.lnw);
         if (this.lom > 12) {
            this.lox(var1, var2, 0.5 + this.lnv.nextDouble() * 0.3, this.maxTurn());
         } else if (var9 && this.offset() < 4.0) {
            this.lox(var1, var2, 0.5 + this.lnv.nextDouble() * 0.3, 4.0);
         } else if (var9) {
            this.lov(var1, var2);
         }

         if (this.offset() <= Math.max(0.3, lpa(var1, var2) * 1.5)) {
            this.forget();
            return true;
         } else {
            return false;
         }
      }
   }

   public void release() {
      this.forget();
      this.lnu.drop();
   }

   private void low(ClientPlayerEntity var1) {
      float var2 = var1.method_36455();
      if (this.lnx) {
         this.lob = MathHelper.method_15363((float)(var2 + this.lob), -90.0F, 90.0F) - var2;
      } else {
         this.lob = var2 - MathHelper.method_15350(var2 - this.lob, -90.0, 90.0);
      }
   }

   public void snap(MinecraftClient var1, ClientPlayerEntity var2, float var3, float var4) {
      if (this.lnx && !this.loe) {
         this.loy(var2);
      }

      double var5 = MathHelper.method_15393(var3 - var2.method_36454());
      double var7 = var4 - var2.method_36455();
      double var9 = Math.sqrt(var5 * var5 + var7 * var7);
      double var11 = Math.max(0.0, this.maxTurn() - this.lon);
      if (!(var9 < 1.0E-4) && !(var11 <= 0.0)) {
         double var13 = Math.min(1.0, var11 / var9);
         this.loz(var1, var2, var5 * var13, var7 * var13, false);
      }
   }

   private void lox(MinecraftClient var1, ClientPlayerEntity var2, double var3, double var5) {
      double var7 = this.offset();
      if (!(var7 <= 0.0)) {
         double var9 = Math.min(var3, var5 / var7);
         this.loz(var1, var2, -this.loa * var9, -this.lob * var9, true);
      }
   }

   private void loy(ClientPlayerEntity var1) {
      this.lof = var1.method_36454();
      this.log = var1.method_36455();
      this.loh = var1.field_3932;
      this.loi = var1.field_3916;
      this.loe = true;
   }

   private void loz(MinecraftClient var1, ClientPlayerEntity var2, double var3, double var5, boolean var7) {
      double var8 = lpb(var1, var2);
      double var10 = var8 * 0.15;
      if (!(var10 <= 0.0)) {
         this.loc += var3 / var10;
         this.lod += var5 / var10;
         long var12 = (long)this.loc;
         long var14 = (long)this.lod;
         this.loc -= var12;
         this.lod -= var14;
         if (var12 != 0L || var14 != 0L) {
            double var16;
            double var18;
            if (this.lnx && !this.loe) {
               double var24;
               for (var24 = this.serverPitch(var2) + var14 * var10; var24 > 90.0 && var14 > 0L; var24 -= var10) {
                  var14--;
               }

               while (var24 < -90.0 && var14 < 0L) {
                  var14++;
                  var24 += var10;
               }

               var16 = (float)(var12 * var8) * 0.15F;
               var18 = (float)(var14 * var8) * 0.15F;
            } else {
               float var20 = var2.method_36454();
               float var21 = var2.method_36455();
               float var22 = var2.field_5982;
               float var23 = var2.field_6004;
               var2.method_5872(var12 * var8, var14 * var8);
               var16 = var2.method_36454() - var20;
               var18 = var2.method_36455() - var21;
               if (!this.lnx) {
                  this.lor += var16;
                  this.los += var18;
               }

               if (var7) {
                  var2.field_5982 = var22;
                  var2.field_6004 = var23;
               }
            }

            this.loa += var16;
            this.lob += var18;
            this.lon = this.lon + Math.sqrt(var16 * var16 + var18 * var18);
            this.lnu.turned(var16, var18);
         }
      }
   }

   private static double lpa(MinecraftClient var0, ClientPlayerEntity var1) {
      return lpb(var0, var1) * 0.15;
   }

   private static double lpb(MinecraftClient var0, ClientPlayerEntity var1) {
      double var2 = (Double)var0.field_1690.method_42495().method_41753() * 0.6F + 0.2F;
      double var4 = var2 * var2 * var2;
      boolean var6 = var0.field_1690.method_31044().method_31034() && var1.method_31550();
      return var6 ? var4 : var4 * 8.0;
   }
}
