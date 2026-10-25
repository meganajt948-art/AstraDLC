package a;

public final class vcj {
   private static final float vck = 1.7F;
   private final float vcl;
   private float vcm;
   private float vcn;

   public vcj(float var1, float var2) {
      this.vcl = var1;
      this.vcm = var2;
   }

   public vcj(float var1) {
      this(var1, 0.0F);
   }

   public float step(float var1, float var2) {
      if (var2 <= 0.0F) {
         return this.vcm;
      } else {
         var2 = Math.min(var2, 0.1F);
         float var3 = this.vcl * 1.7F;
         float var4 = var3 * var2;
         float var5 = 1.0F / (1.0F + var4 + 0.48F * var4 * var4 + 0.235F * var4 * var4 * var4);
         float var6 = this.vcm - var1;
         float var7 = (this.vcn + var3 * var6) * var2;
         this.vcn = (this.vcn - var3 * var7) * var5;
         float var8 = var1 + (var6 + var7) * var5;
         if (var1 - this.vcm > 0.0F == var8 > var1) {
            var8 = var1;
            this.vcn = 0.0F;
         }

         this.vcm = var8;
         if (Math.abs(var1 - this.vcm) < 5.0E-4F && Math.abs(this.vcn) < 0.01F) {
            this.vcm = var1;
            this.vcn = 0.0F;
         }

         return this.vcm;
      }
   }

   public float step(boolean var1, float var2) {
      return this.step(var1 ? 1.0F : 0.0F, var2);
   }

   public float get() {
      return this.vcm;
   }

   public void set(float var1) {
      this.vcm = var1;
      this.vcn = 0.0F;
   }
}
