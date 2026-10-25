package a;

final class est {
   private final byte esu;
   private final float[] esv;
   private final float esw;

   private est(byte digit, float[] feat, float norm) {
      this.esu = digit;
      this.esv = feat;
      this.esw = norm;
   }

   public byte digit() {
      return this.esu;
   }

   public float[] feat() {
      return this.esv;
   }

   public float norm() {
      return this.esw;
   }
}
