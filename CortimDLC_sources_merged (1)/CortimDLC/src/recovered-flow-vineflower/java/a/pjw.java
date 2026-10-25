package a;

import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

public final class pjw {
   static final double pjx = 10.0;
   static final double pjy = 0.45;
   static final double pjz = 0.55;
   static final double pka = 0.5;
   static final double pkb = 1.6;
   static final double pkc = 2.4;
   static final double pkd = 8.0;
   static final double pke = 40.0;
   static final double pkf = 1.2;
   static final double pkg = 45.0;
   static final int pkh = 2;
   final Random pki = new Random();
   final tel pkj = new tel();
   final double[] pkk = new double[2];
   lex pkl;
   double pkm = 1.0;
   double pkn = 1.0;
   double pko = 2.0;
   double pkp = 6.5;
   double pkq = 0.65;
   double pkr;
   double pks;
   boolean pkt;
   double pku = 0.15;
   boolean pkv;
   double pkw;
   double pkx;
   Object pky = new Object();
   Object pkz;
   double pla;
   double plb;
   double plc;
   double pld;
   boolean ple;
   double plf;
   double plg;
   double plh;
   int pli;
   int plj = 120;
   boolean plk;
   double pll;
   double plm;
   double pln;
   double plo;
   int plp;
   int plq = 40;

   public pjw neuro(lex var1) {
      this.pkl = var1;
      return this;
   }

   public void personalize(long var1) {
      Random var3 = new Random(var1 ^ 25214903917L ^ 2685821657736338717L);
      this.pkm = 0.85 + var3.nextDouble() * 0.3;
      this.pkn = 0.8 + var3.nextDouble() * 0.4;
      this.pko = 1.5 + var3.nextDouble() * 1.3;
      this.pkp = 4.5 + var3.nextDouble() * 4.0;
      this.pkq = 0.5 + var3.nextDouble() * 0.35;
   }

   public void setMouseStep(double var1) {
      if (var1 > 0.0 && Double.isFinite(var1)) {
         this.pku = var1;
      }
   }

   public void reset(float var1, float var2) {
      this.pkr = var1;
      this.pks = var2;
      this.pkt = true;
      this.pkv = false;
      this.pkw = 0.0;
      this.pkx = 0.0;
      this.pky = new Object();
      this.pkz = null;
      this.pkj.reset();
      this.ple = false;
      this.pla = var1;
      this.plb = var2;
      this.plk = false;
      this.plf = 0.0;
      this.plg = 0.0;
      this.pli = 0;
      this.plp = 0;
   }

   public boolean isPrimed() {
      return this.pkt;
   }

   public void aimTight(float var1, float var2) {
      this.plt(var1, var2, pjt.TIGHT, 0.0);
   }

   public void aim(float var1, float var2) {
      this.plt(var1, var2, pjt.PRECISE, 0.45);
   }

   public void aim(float var1, float var2, double var3) {
      this.plt(var1, var2, pjt.PRECISE, var3 > 0.0 ? var3 : 0.45);
   }

   public void aimRelaxed(float var1, float var2) {
      this.plt(var1, var2, pjt.RELAXED, 0.0);
   }

   void plt(float var1, float var2, pjt var3, double var4) {
      var2 = MathHelper.clamp(var2, -89.0F, 89.0F);
      this.plk = false;
      if (!this.pkt) {
         this.reset(var1, var2);
      } else {
         double var6 = var1;
         double var8 = var2;
         if (var3 == pjt.PRECISE) {
            this.plf *= 0.7;
            this.plg *= 0.7;
            this.pli = 0;
         } else {
            this.plu();
            if (var3 == pjt.TIGHT) {
               this.plf *= 0.6;
            } else {
               var6 += this.plf;
            }

            var8 = MathHelper.clamp(var2 + this.plg + this.plv(), -78.0, 78.0);
         }

         this.plw(var6, var8, var3, var4);
      }
   }

   public void freeze() {
      if (this.pkt) {
         this.pkj.idle((float)this.pkr, (float)this.pks);
         this.pkv = false;
      }
   }

   public void turn(double var1, double var3) {
      if (this.pkt) {
         this.plk = false;
         this.pkw = this.pkw + var1 / this.pku;
         this.pkx = this.pkx + var3 / this.pku;
         long var5 = Math.round(this.pkw);
         long var7 = Math.round(this.pkx);
         this.pkw -= var5;
         this.pkx -= var7;
         double var9 = var5 * this.pku;
         double var11 = MathHelper.clamp(this.pks + var7 * this.pku, -90.0, 90.0);
         this.pkr += var9;
         this.pks = var11;
         this.pla = this.pkr;
         this.plb = this.pks;
         this.plc = this.pkr;
         this.pld = this.pks;
         this.ple = false;
         this.pky = new Object();
         this.pkj.idle((float)this.pkr, (float)this.pks);
         this.pkv = var5 != 0L || var7 != 0L;
      }
   }

   public void hold() {
      if (this.pkt) {
         this.plk = false;
         this.plw(this.pkr, this.pks, pjt.HOLD, 0.0);
      }
   }

   public void idle() {
      if (this.pkt) {
         if (!this.plk) {
            this.plk = true;
            this.pll = this.pkr;
            this.plm = this.pks;
            this.pln = 0.0;
            this.plo = 0.0;
            this.plp = 0;
            this.plq = 20 + this.pki.nextInt(80);
         }

         if (this.plp > 0) {
            if (--this.plp == 0) {
               this.pln = this.pki.nextGaussian() * 3.0;
               this.plo = this.pki.nextGaussian() * 2.0;
            }
         } else if (this.plq > 0) {
            this.plq--;
         } else {
            this.plp = 8 + this.pki.nextInt(34);
            this.plq = 25 + this.pki.nextInt(110);
            this.pln = this.pki.nextGaussian() * 26.0;
            this.plo = this.pki.nextGaussian() * 11.0;
         }

         double var1 = this.pll + this.pln;
         double var3 = MathHelper.clamp(this.plm + this.plo, -70.0, 70.0);
         this.plw(var1, var3, pjt.IDLE, 0.0);
      }
   }

   void plu() {
      this.plf = MathHelper.clamp(this.plf * 0.992 + this.pki.nextGaussian() * 0.12, -3.0, 3.0);
      this.plg = MathHelper.clamp(this.plg * 0.99 + this.pki.nextGaussian() * 0.35, -9.0, 8.0);
      if (this.pli > 0) {
         this.pli--;
      } else if (this.plj > 0) {
         this.plj--;
      } else {
         this.pli = 10 + this.pki.nextInt(26);
         this.plj = 160 + this.pki.nextInt(420);
         this.plh = this.pki.nextGaussian() * 15.0;
      }
   }

   double plv() {
      return this.pli > 0 ? this.plh : 0.0;
   }

   void plw(double var1, double var3, pjt var5, double var6) {
      this.pla = var1;
      this.plb = var3;
      if (this.ple && Math.hypot(MathHelper.wrapDegrees(var1 - this.plc), var3 - this.pld) > 10.0) {
         this.pky = new Object();
      }

      this.ple = true;
      this.plc = var1;
      this.pld = var3;
      if (var5 == pjt.HOLD) {
         this.pkj.idle((float)this.pkr, (float)this.pks);
         this.pkv = false;
      } else {
         double var8 = MathHelper.wrapDegrees(var1 - this.pkr);
         double var10 = var3 - this.pks;
         double var12;
         double var14;
         boolean var16;
         switch (var5) {
            case TIGHT:
               var12 = this.pkq;
               var14 = this.pkp * 2.0;
               var16 = Math.abs(var8) <= this.pkq * 0.5 && Math.abs(var10) <= this.pkp * 0.5;
               break;
            case PRECISE:
               double var17 = Math.max(0.5, var6 / 0.55);
               var12 = var17;
               var14 = var17 * 2.0;
               var16 = Math.hypot(var8, var10) <= var6;
               break;
            case IDLE:
               var12 = 1.6;
               var14 = 4.8;
               var16 = Math.abs(var8) <= 0.8 && Math.abs(var10) <= 1.2;
               break;
            default:
               var12 = this.pko;
               var14 = this.pkp * 2.0;
               var16 = Math.abs(var8) <= this.pko * 0.5 && Math.abs(var10) <= this.pkp * 0.5;
         }

         if (var16) {
            this.pkj.idle((float)this.pkr, (float)this.pks);
            this.pkv = false;
         } else {
            double var38 = var5 == pjt.IDLE ? 0.0 : plx((Math.hypot(var8, var10) - 8.0) / 32.0);
            tck var19 = this.pkl == null ? null : lfa.model(this.pkl);
            this.pkj.use(var19 != null ? var19 : tck.profile1());
            this.pkj.tune((var19 != null ? 1.0 : this.pkm) * (1.0 + 1.2 * var38), var19 != null ? 1.0 : this.pkn, 1.0);
            MinecraftClient var20 = MinecraftClient.getInstance();
            int var21 = this.pky == this.pkz ? 0 : 2;
            this.pkz = this.pky;
            if (!this.pkj.steerTo(var20.player, this.pky, this.pkr + var8, var3, var12, var14, var21, (float)this.pkr, (float)this.pks, this.pkk)) {
               this.pkv = false;
            } else {
               double var22 = this.pkk[0];
               double var24 = this.pkk[1];
               double var26 = Math.hypot(var22, var24);
               if (var26 > 45.0) {
                  var22 *= 45.0 / var26;
                  var24 *= 45.0 / var26;
               }

               this.pkw = this.pkw + var22 / this.pku;
               this.pkx = this.pkx + var24 / this.pku;
               long var28 = Math.round(this.pkw);
               long var30 = Math.round(this.pkx);
               this.pkw -= var28;
               this.pkx -= var30;
               double var32 = var28 * this.pku;
               double var34 = MathHelper.clamp(this.pks + var30 * this.pku, -90.0, 90.0);
               double var36 = var34 - this.pks;
               this.pkr += var32;
               this.pks = var34;
               this.pkj.turned(var32, var36);
               this.pkv = var28 != 0L || var30 != 0L;
            }
         }
      }
   }

   static double plx(double var0) {
      var0 = MathHelper.clamp(var0, 0.0, 1.0);
      return var0 * var0 * (3.0 - 2.0 * var0);
   }

   public float intentYaw() {
      return (float)this.pkr;
   }

   public float intentPitch() {
      return (float)this.pks;
   }

   public float getYaw() {
      return (float)this.pkr;
   }

   public float getPitch() {
      return (float)MathHelper.clamp(this.pks, -90.0, 90.0);
   }

   public boolean isMoving() {
      return this.pkv;
   }

   public double error() {
      return this.pkt ? Math.hypot(MathHelper.wrapDegrees(this.pla - this.pkr), this.plb - this.pks) : 0.0;
   }

   public boolean isOn(double var1) {
      return this.error() <= var1;
   }
}
