package a;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

final class spg {
   private final Matrix4f sph;
   private final Matrix3f spi;
   private final float spj;
   private final float spk;
   private final float spl;

   spg(Matrix4f matrix, Matrix3f normals, float hx, float hy, float hz) {
      this.sph = matrix;
      this.spi = normals;
      this.spj = hx;
      this.spk = hy;
      this.spl = hz;
   }

   public Matrix4f matrix() {
      return this.sph;
   }

   public Matrix3f normals() {
      return this.spi;
   }

   public float hx() {
      return this.spj;
   }

   public float hy() {
      return this.spk;
   }

   public float hz() {
      return this.spl;
   }
}
