package a;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.util.math.Vec3d;

public final class stp {
   private static final float stq = 343.0F;
   private final Random str = new Random();
   private final float[] sts = new float[320];
   private final float[] stt = new float[320];
   private final ArrayDeque<stf> stu = new ArrayDeque<>();
   private final ArrayDeque<sti> stv = new ArrayDeque<>();
   private int stw;
   private double stx = 4.0;
   private boolean sty;
   private boolean stz;
   private double sua;
   private double sub;
   private float[] suc = new float[0];
   private float[] sud = new float[0];
   private double sue;
   private double suf;
   private double sug;
   private float suh;
   private double sui = -1.0;

   public void freeze(double var1) {
      this.sui = var1;
   }

   public void reset() {
      this.sty = false;
      this.stw = 0;
      this.stu.clear();
      this.stv.clear();
      this.stx = 3.0 + this.str.nextDouble() * 4.0;
   }

   public void strike(Vec3d var1, float var2, double var3, float var5, boolean var6) {
      this.sul(var1, var2, var3, var5, var6, this.str.nextDouble() * Math.PI * 2.0);
   }

   public void strike(Vec3d var1, float var2, double var3, float var5, boolean var6, double var7) {
      this.sul(var1, var2, var3, var5, var6, var7);
   }

   public void update(double var1, float var3, Vec3d var4, float var5, double var6) {
      if (this.sty) {
         this.sua = this.sui >= 0.0 ? this.sui : this.sua + var1;
         if (this.sua > this.sub) {
            this.sty = false;
            this.stw = 0;
         }
      }

      Iterator var8 = this.stu.iterator();

      while (var8.hasNext()) {
         stf var9 = (stf)var8.next();
         var9.left -= var1;
         if (var9.left <= 0.0) {
            this.stv.add(var9.thunder);
            var8.remove();
         }
      }

      if (!(var3 <= 0.001)) {
         this.stx -= var1;
         if (this.stx <= 0.0 && !this.sty) {
            double var11 = 55.0 - 50.0 * var3;
            this.stx = Math.max(1.5, -Math.log(1.0 - this.str.nextDouble()) * var11);
            float var10 = (float)(220.0 * Math.pow(14.0, this.str.nextDouble()));
            this.sul(var4, var5, var6, var10, this.str.nextDouble() < 0.4, this.str.nextDouble() * Math.PI * 2.0);
         }
      }
   }

   private void sul(Vec3d var1, float var2, double var3, float var5, boolean var6, double var7) {
      this.suh = var5;
      this.sue = var1.x + Math.cos(var7) * var5;
      this.sug = var1.z + Math.sin(var7) * var5;
      this.suf = var1.y + var2 + 30.0 + this.str.nextDouble() * 80.0;
      this.stz = var6;
      int var9 = var6 ? 1 + this.str.nextInt(4) : 3 + this.str.nextInt(5);
      this.suc = new float[var9];
      this.sud = new float[var9];
      float var10 = 0.0F;

      for (int var11 = 0; var11 < var9; var11++) {
         this.suc[var11] = var10;
         this.sud[var11] = var11 == 0 ? 1.0F : 0.45F + 0.5F * this.str.nextFloat();
         var10 += var6 ? 0.04F + 0.1F * this.str.nextFloat() : 0.03F + 0.14F * this.str.nextFloat();
      }

      this.sua = 0.0;
      this.sub = var10 + (var6 ? 0.7 : 0.45);
      this.sty = true;
      this.stw = 0;
      if (var6) {
         this.sum(var3);
      }

      if (this.stu.size() < 6) {
         this.stu.add(new stf(var5 / 343.0F, new sti(this.sue, this.sug, var5, var6)));
      }
   }

   public sti nextThunder() {
      return this.stv.poll();
   }

   public float brightness() {
      if (!this.sty) {
         return 0.0F;
      }

      float var1 = 0.0F;

      for (int var2 = 0; var2 < this.suc.length; var2++) {
         float var3 = (float)this.sua - this.suc[var2];
         if (!(var3 < 0.0F)) {
            float var4 = Math.min(1.0F, var3 / 0.008F);
            var1 += this.sud[var2] * var4 * (float)Math.exp(-var3 / (this.stz ? 0.05F : 0.07F));
         }
      }

      float var5 = (float)this.sua;
      return var1 + (this.stz ? 0.16F : 0.08F) * (float)Math.exp(-var5 / 0.28F) * Math.min(1.0F, var5 / 0.02F);
   }

   public float boltBrightness() {
      if (this.sty && this.stz) {
         float var1 = 0.0F;

         for (int var2 = 0; var2 < this.suc.length; var2++) {
            float var3 = (float)this.sua - this.suc[var2];
            if (!(var3 < 0.0F)) {
               var1 = Math.max(var1, this.sud[var2] * Math.min(1.0F, var3 / 0.006F) * (float)Math.exp(-var3 / 0.09F));
            }
         }

         float var4 = (float)this.sua - this.suc[this.suc.length - 1];
         if (var4 > 0.0F) {
            var1 = Math.max(var1, 0.18F * (float)Math.exp(-var4 / 0.2F));
         }

         return var1;
      } else {
         return 0.0F;
      }
   }

   public boolean active() {
      return this.sty;
   }

   public boolean isBolt() {
      return this.stz;
   }

   public float distance() {
      return this.suh;
   }

   public double x() {
      return this.sue;
   }

   public double y() {
      return this.suf;
   }

   public double z() {
      return this.sug;
   }

   public int segments() {
      return this.sty && this.stz ? this.stw : 0;
   }

   public float[] segA() {
      return this.sts;
   }

   public float[] segB() {
      return this.stt;
   }

   private void sum(double var1) {
      double var3 = (this.str.nextDouble() - 0.5) * 120.0;
      double var5 = (this.str.nextDouble() - 0.5) * 120.0;
      double var7 = var1 - this.suf;
      float[] var9 = this.sun(0.0, 0.0, 0.0, var3, var7, var5, 40, 0.11);
      this.stw = 0;
      this.suo(var9, 1.6F, 1.0F, 0.12F);
      int var10 = 3 + this.str.nextInt(4);
      int var11 = var9.length / 3;

      for (int var12 = 0; var12 < var10 && this.stw < 76; var12++) {
         int var13 = 2 + this.str.nextInt(Math.max(1, (int)(var11 * 0.65)));
         double var14 = var9[var13 * 3];
         double var16 = var9[var13 * 3 + 1];
         double var18 = var9[var13 * 3 + 2];
         double var20 = -var7 * (0.12 + 0.28 * this.str.nextDouble());
         double var22 = this.str.nextDouble() * Math.PI * 2.0;
         double var24 = var14 + Math.cos(var22) * var20 * 0.7;
         double var26 = var18 + Math.sin(var22) * var20 * 0.7;
         double var28 = var16 - var20 * (0.55 + 0.4 * this.str.nextDouble());
         float[] var30 = this.sun(var14, var16, var18, var24, var28, var26, 6 + this.str.nextInt(7), 0.16);
         this.suo(var30, 0.75F, 0.4F + 0.25F * this.str.nextFloat(), 0.75F);
      }
   }

   private float[] sun(double var1, double var3, double var5, double var7, double var9, double var11, int var13, double var14) {
      float[] var16 = new float[(var13 + 1) * 3];
      double var17 = var7 - var1;
      double var19 = var9 - var3;
      double var21 = var11 - var5;
      double var23 = Math.sqrt(var17 * var17 + var19 * var19 + var21 * var21) / var13;
      double var25 = 0.0;
      double var27 = 0.0;
      double var29 = 0.0;

      for (int var31 = 0; var31 <= var13; var31++) {
         double var32 = (double)var31 / var13;
         if (var31 > 0 && var31 < var13) {
            var25 = var25 * 0.9 + (this.str.nextDouble() - 0.5) * var23 * var14 * 9.0;
            var29 = var29 * 0.9 + (this.str.nextDouble() - 0.5) * var23 * var14 * 9.0;
            var27 = var27 * 0.8 + (this.str.nextDouble() - 0.5) * var23 * var14 * 2.0;
         } else {
            var25 = 0.0;
            var27 = 0.0;
            var29 = 0.0;
         }

         double var34 = Math.min(1.0, (1.0 - var32) * 6.0);
         var16[var31 * 3] = (float)(var1 + var17 * var32 + var25 * var34);
         var16[var31 * 3 + 1] = (float)(var3 + var19 * var32 + var27 * var34);
         var16[var31 * 3 + 2] = (float)(var5 + var21 * var32 + var29 * var34);
      }

      return var16;
   }

   private void suo(float[] var1, float var2, float var3, float var4) {
      int var5 = var1.length / 3;

      for (int var6 = 0; var6 < var5 - 1 && this.stw < 80; var6++) {
         int var7 = this.stw * 4;
         float var8 = 1.0F - var4 * var6 / Math.max(1, var5 - 1);
         this.sts[var7] = var1[var6 * 3];
         this.sts[var7 + 1] = var1[var6 * 3 + 1];
         this.sts[var7 + 2] = var1[var6 * 3 + 2];
         this.sts[var7 + 3] = var2 * (0.35F + 0.65F * var8);
         this.stt[var7] = var1[(var6 + 1) * 3];
         this.stt[var7 + 1] = var1[(var6 + 1) * 3 + 1];
         this.stt[var7 + 2] = var1[(var6 + 1) * 3 + 2];
         this.stt[var7 + 3] = var3 * var8;
         this.stw++;
      }
   }
}
