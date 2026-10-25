package a;

final class eoz {
   final float[][] epa;
   final float[][] epb;
   final float[] epc;
   final int epd;
   final int epe;
   final int epf;
   final boolean epg;

   eoz(float[][] w, float[][] r, float[] b, int hidden, int input, int dirs, boolean reverse) {
      this.epa = w;
      this.epb = r;
      this.epc = b;
      this.epd = hidden;
      this.epe = input;
      this.epf = dirs;
      this.epg = reverse;
   }

   public float[][] w() {
      return this.epa;
   }

   public float[][] r() {
      return this.epb;
   }

   public float[] b() {
      return this.epc;
   }

   public int hidden() {
      return this.epd;
   }

   public int input() {
      return this.epe;
   }

   public int dirs() {
      return this.epf;
   }

   public boolean reverse() {
      return this.epg;
   }
}
