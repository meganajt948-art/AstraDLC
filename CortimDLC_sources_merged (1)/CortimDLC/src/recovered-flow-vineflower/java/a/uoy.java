package a;

public final class uoy {
   final float uoz;
   final float upa;
   final float upb;
   final float upc;
   final float upd;
   final float upe;

   public uoy(float refraction, float bezel, float dispersion, float highlight, float saturation, float lightAngle) {
      this.uoz = refraction;
      this.upa = bezel;
      this.upb = dispersion;
      this.upc = highlight;
      this.upd = saturation;
      this.upe = lightAngle;
   }

   public uoy withBezel(float var1) {
      return new uoy(this.uoz, var1, this.upb, this.upc, this.upd, this.upe);
   }

   int packShape(float var1) {
      int var2 = Math.floorMod(Math.round(this.upe / 360.0F * 64.0F), 64);
      int var3 = Math.round(Math.max(0.5F, Math.min(this.upa, var1)) * 2.0F);
      return uph(this.uoz, 63) | uph(this.upb, 63) << 6 | var2 << 12 | Math.max(1, Math.min(63, var3)) << 18;
   }

   int packLight(float var1) {
      return uph(var1, 255) | uph(this.upc, 255) << 8 | uph(this.upd * 0.5F, 255) << 16;
   }

   static int uph(float var0, int var1) {
      return Math.round(Math.max(0.0F, Math.min(1.0F, var0)) * var1);
   }

   public float refraction() {
      return this.uoz;
   }

   public float bezel() {
      return this.upa;
   }

   public float dispersion() {
      return this.upb;
   }

   public float highlight() {
      return this.upc;
   }

   public float saturation() {
      return this.upd;
   }

   public float lightAngle() {
      return this.upe;
   }
}
