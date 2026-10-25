package a;

public final class vdc {
   private final float vdd;
   private float vde;
   private boolean vdf = true;

   public vdc(float var1, float var2) {
      this.vdd = Math.max(0.001F, var1);
      this.vde = var2;
   }

   public void update(float var1) {
      this.vde = this.vde + (this.vdf ? var1 : -var1) / this.vdd;
      this.vde = vcq.clamp01(this.vde);
   }

   public void forward() {
      this.vdf = true;
   }

   public void backward() {
      this.vdf = false;
   }

   public void restart() {
      this.vde = 0.0F;
      this.vdf = true;
   }

   public boolean isForward() {
      return this.vdf;
   }

   public boolean finished() {
      return this.vdf ? this.vde >= 1.0F : this.vde <= 0.0F;
   }

   public float linear() {
      return this.vde;
   }
}
