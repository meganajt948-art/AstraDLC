package a;

final class vnv {
   final int vnw;
   final float vnx;

   vnv(int buffer, float pitch) {
      this.vnw = buffer;
      this.vnx = pitch;
   }

   public int buffer() {
      return this.vnw;
   }

   public float pitch() {
      return this.vnx;
   }
}
