package a;

public final class vct {
   static final float vcu = 0.004166667F;
   final float vcv;
   final float vcw;
   float vcx;
   float vcy;
   boolean vcz;

   public vct(float var1, float var2) {
      this.vcv = var1;
      this.vcw = 2.0F * var2 * (float)Math.sqrt(var1);
   }

   public float step(float var1, float var2) {
      if (!this.vcz) {
         this.set(var1);
         return this.vcx;
      }

      float var3 = var2;

      while (var3 > 0.0F) {
         float var4 = Math.min(var3, 0.004166667F);
         this.vcy = this.vcy + (this.vcv * (var1 - this.vcx) - this.vcw * this.vcy) * var4;
         this.vcx = this.vcx + this.vcy * var4;
         var3 -= var4;
      }

      if (Math.abs(var1 - this.vcx) < 0.005F && Math.abs(this.vcy) < 0.05F) {
         this.vcx = var1;
         this.vcy = 0.0F;
      }

      return this.vcx;
   }

   public float get() {
      return this.vcx;
   }

   public void set(float var1) {
      this.vcx = var1;
      this.vcy = 0.0F;
      this.vcz = true;
   }
}
