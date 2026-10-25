package a;

final class vev {
   final float vew;
   final float vex;
   final float vey;
   final float vez;
   final float vfa;
   final float vfb;
   final float vfc;
   final float vfd;
   final float vfe;

   vev(float u0, float v0, float u1, float v1, float ox, float oy, float w, float h, float advance) {
      this.vew = u0;
      this.vex = v0;
      this.vey = u1;
      this.vez = v1;
      this.vfa = ox;
      this.vfb = oy;
      this.vfc = w;
      this.vfd = h;
      this.vfe = advance;
   }

   public float u0() {
      return this.vew;
   }

   public float v0() {
      return this.vex;
   }

   public float u1() {
      return this.vey;
   }

   public float v1() {
      return this.vez;
   }

   public float ox() {
      return this.vfa;
   }

   public float oy() {
      return this.vfb;
   }

   public float w() {
      return this.vfc;
   }

   public float h() {
      return this.vfd;
   }

   public float advance() {
      return this.vfe;
   }
}
