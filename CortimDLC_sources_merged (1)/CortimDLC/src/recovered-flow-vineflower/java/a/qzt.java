package a;

final class qzt {
   private final long qzu;
   private final int qzv;
   private final float qzw;
   private final float qzx;
   private final float qzy;
   private final float qzz;
   private final float raa;
   private final float rab;

   private qzt(long pos, int color, float x0, float y0, float z0, float x1, float y1, float z1) {
      this.qzu = pos;
      this.qzv = color;
      this.qzw = x0;
      this.qzx = y0;
      this.qzy = z0;
      this.qzz = x1;
      this.raa = y1;
      this.rab = z1;
   }

   boolean fullCube() {
      return this.qzw == 0.0F && this.qzx == 0.0F && this.qzy == 0.0F && this.qzz == 1.0F && this.raa == 1.0F && this.rab == 1.0F;
   }

   public long pos() {
      return this.qzu;
   }

   public int color() {
      return this.qzv;
   }

   public float x0() {
      return this.qzw;
   }

   public float y0() {
      return this.qzx;
   }

   public float z0() {
      return this.qzy;
   }

   public float x1() {
      return this.qzz;
   }

   public float y1() {
      return this.raa;
   }

   public float z1() {
      return this.rab;
   }
}
