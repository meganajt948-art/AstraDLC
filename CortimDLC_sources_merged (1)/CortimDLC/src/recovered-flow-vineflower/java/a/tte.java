package a;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

final class tte {
   final BlockPos ttf;
   final Direction ttg;
   final Vec3d tth;
   final byte tti;

   tte(BlockPos pos, Direction side, Vec3d point, byte cell) {
      this.ttf = pos;
      this.ttg = side;
      this.tth = point;
      this.tti = cell;
   }

   public BlockPos pos() {
      return this.ttf;
   }

   public Direction side() {
      return this.ttg;
   }

   public Vec3d point() {
      return this.tth;
   }

   public byte cell() {
      return this.tti;
   }
}
