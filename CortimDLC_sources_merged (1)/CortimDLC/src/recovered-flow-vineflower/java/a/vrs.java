package a;

final class vrs {
   final String vrt;
   final float vru;
   final float vrv;
   final float vrw;
   final float vrx;
   final float vry;
   final float vrz;
   final long vsa;

   vrs(String name, float gain, float x, float z, float pitch, float high, float wet, long due) {
      this.vrt = name;
      this.vru = gain;
      this.vrv = x;
      this.vrw = z;
      this.vrx = pitch;
      this.vry = high;
      this.vrz = wet;
      this.vsa = due;
   }

   public String name() {
      return this.vrt;
   }

   public float gain() {
      return this.vru;
   }

   public float x() {
      return this.vrv;
   }

   public float z() {
      return this.vrw;
   }

   public float pitch() {
      return this.vrx;
   }

   public float high() {
      return this.vry;
   }

   public float wet() {
      return this.vrz;
   }

   public long due() {
      return this.vsa;
   }
}
