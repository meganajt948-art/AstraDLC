package a;

final class vrs {
   private final String vrt;
   private final float vru;
   private final float vrv;
   private final float vrw;
   private final float vrx;
   private final float vry;
   private final float vrz;
   private final long vsa;

   private vrs(String name, float gain, float x, float z, float pitch, float high, float wet, long due) {
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
