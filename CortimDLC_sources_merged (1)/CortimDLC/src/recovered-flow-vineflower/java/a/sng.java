package a;

public final class sng {
   final int snh;
   final int sni;
   final float snj;
   final boolean snk;
   final boolean snl;
   final float snm;

   public sng(int tone, int tone2, float glow, boolean shadow, boolean particles, float alpha) {
      this.snh = tone;
      this.sni = tone2;
      this.snj = glow;
      this.snk = shadow;
      this.snl = particles;
      this.snm = alpha;
   }

   public int tone() {
      return this.snh;
   }

   public int tone2() {
      return this.sni;
   }

   public float glow() {
      return this.snj;
   }

   public boolean shadow() {
      return this.snk;
   }

   public boolean particles() {
      return this.snl;
   }

   public float alpha() {
      return this.snm;
   }
}
