package a;

final class est {
   final byte esu;
   final float[] esv;
   final float esw;

   est(byte digit, float[] feat, float norm) {
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
