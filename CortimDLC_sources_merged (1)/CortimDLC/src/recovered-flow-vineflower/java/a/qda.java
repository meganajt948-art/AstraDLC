package a;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

final class qda {
   private final BlockPos qdb;
   private final Vec3d qdc;
   private final int qdd;
   private final double[] qde;
   private final double qdf;
   private final float qdg;
   private final float qdh;

   private qda(BlockPos pos, Vec3d point, int axis, double[] look, double turn, float yaw, float pitch) {
      this.qdb = pos;
      this.qdc = point;
      this.qdd = axis;
      this.qde = look;
      this.qdf = turn;
      this.qdg = yaw;
      this.qdh = pitch;
   }

   public BlockPos pos() {
      return this.qdb;
   }

   public Vec3d point() {
      return this.qdc;
   }

   public int axis() {
      return this.qdd;
   }

   public double[] look() {
      return this.qde;
   }

   public double turn() {
      return this.qdf;
   }

   public float yaw() {
      return this.qdg;
   }

   public float pitch() {
      return this.qdh;
   }
}
