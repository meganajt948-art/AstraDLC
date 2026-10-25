package a;

final class ige {
   private final float igf;
   private final float igg;
   private final float igh;
   private final float igi;
   private final Runnable igj;
   private final Runnable igk;

   private ige(float x, float y, float w, float h, Runnable left, Runnable right) {
      this.igf = x;
      this.igg = y;
      this.igh = w;
      this.igi = h;
      this.igj = left;
      this.igk = right;
   }

   public float x() {
      return this.igf;
   }

   public float y() {
      return this.igg;
   }

   public float w() {
      return this.igh;
   }

   public float h() {
      return this.igi;
   }

   public Runnable left() {
      return this.igj;
   }

   public Runnable right() {
      return this.igk;
   }
}
