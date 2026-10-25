package a;

public record vyd(float health, float absorption, float max, boolean unknown) {
   private final float vye;
   private final float vyf;
   private final float vyg;
   private final boolean vyh;

   public vyd(float health, float absorption, float max, boolean unknown) {
      this.vye = health;
      this.vyf = absorption;
      this.vyg = max;
      this.vyh = unknown;
   }

   public float total() {
      return this.vye + this.vyf;
   }

   public float fraction() {
      return this.vyh ? 1.0F : Math.max(0.0F, Math.min(1.0F, this.vye / this.vyg));
   }

   public float health() {
      return this.vye;
   }

   public float absorption() {
      return this.vyf;
   }

   public float max() {
      return this.vyg;
   }

   public boolean unknown() {
      return this.vyh;
   }
}
