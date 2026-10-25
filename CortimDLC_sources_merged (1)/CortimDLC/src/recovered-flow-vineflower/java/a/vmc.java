package a;

import flow.dev.a;
import java.util.function.DoubleFunction;

public class vmc extends vmo {
   private double vmd;
   private final double vme;
   private final double vmf;
   private final double vmg;
   private final double vmh;
   private String vmi = "";
   private boolean vmj;
   private boolean vmk;
   private DoubleFunction<String> vml;

   public vmc(String var1, double var2, double var4, double var6, double var8) {
      super(var1);
      this.vmf = var4;
      this.vmg = var6;
      this.vmh = var8;
      this.set(var2);
      this.vme = this.vmd;
   }

   public double get() {
      return this.vmd;
   }

   public int getInt() {
      return (int)Math.round(this.vmd);
   }

   public double getMin() {
      return this.vmf;
   }

   public double getMax() {
      return this.vmg;
   }

   public double getStep() {
      return this.vmh;
   }

   public void set(double var1) {
      if (var1 < this.vmf) {
         var1 = this.vmf;
      }

      if (var1 > this.vmg) {
         var1 = this.vmg;
      }

      if (this.vmh > 0.0) {
         var1 = this.vmf + Math.round((var1 - this.vmf) / this.vmh) * this.vmh;
      }

      this.vmd = var1;
   }

   public vmc suffix(String var1) {
      this.vmi = var1;
      return this;
   }

   public vmc unit(String var1) {
      this.vmi = var1;
      this.vmj = true;
      return this;
   }

   public double getDefault() {
      return this.vme;
   }

   public void reset() {
      this.set(this.vme);
   }

   public vmc percent() {
      this.vmk = true;
      return this;
   }

   public vmc format(DoubleFunction<String> var1) {
      this.vml = var1;
      return this;
   }

   public String display() {
      if (this.vml != null) {
         return this.vml.apply(this.vmd);
      }

      if (this.vmk) {
         return Math.round(this.vmd * 100.0) + a.b("\uf4e2", -1588857658);
      }

      String var1;
      if (this.vmh >= 1.0) {
         var1 = String.valueOf(this.getInt());
      } else {
         int var2 = this.vmh >= 0.099999999 ? 1 : 2;
         var1 = vxu.fixed(this.vmd, var2);
      }

      return this.vmi.isEmpty() ? var1 : var1 + (this.vmj ? "" : a.c(1908555782, "䀧")) + wap.unit(this.vmi);
   }

   public double getFraction() {
      return this.vmg <= this.vmf ? 0.0 : (this.vmd - this.vmf) / (this.vmg - this.vmf);
   }

   public void setFromFraction(double var1) {
      var1 = Math.max(0.0, Math.min(1.0, var1));
      this.set(this.vmf + (this.vmg - this.vmf) * var1);
   }
}
