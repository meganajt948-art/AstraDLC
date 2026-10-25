package a;

final class vnv {
   private final int vnw;
   private final float vnx;

   private vnv(int buffer, float pitch) {
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
