package a;

public final class uki {
   public float fill;
   public float line;
   public float width;
   public float glow;
   public float spread;
   public float speed;
   boolean on;
   boolean shown;

   public uki set(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.fill = var1;
      this.line = var2;
      this.width = var3;
      this.glow = var4;
      this.spread = var5;
      this.speed = var6;
      return this;
   }

   boolean visible() {
      return this.shown && (this.fill > 0.004F || this.line > 0.004F && this.width > 0.05F || this.glow > 0.004F);
   }
}
