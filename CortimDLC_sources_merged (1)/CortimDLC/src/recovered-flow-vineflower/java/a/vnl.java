package a;

final class vnl {
   final String vnm;
   final boolean vnn;
   final float vno;
   final long vnp;
   final String vnq;
   final float vnr;
   final float vns;

   vnl(String sound, boolean on, float gain, long gameContext, String device, float x, float z) {
      this.vnm = sound;
      this.vnn = on;
      this.vno = gain;
      this.vnp = gameContext;
      this.vnq = device;
      this.vnr = x;
      this.vns = z;
   }

   public String sound() {
      return this.vnm;
   }

   public boolean on() {
      return this.vnn;
   }

   public float gain() {
      return this.vno;
   }

   public long gameContext() {
      return this.vnp;
   }

   public String device() {
      return this.vnq;
   }

   public float x() {
      return this.vnr;
   }

   public float z() {
      return this.vns;
   }
}
