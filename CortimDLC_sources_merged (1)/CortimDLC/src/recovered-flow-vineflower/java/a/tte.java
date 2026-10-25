package a;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

final class tte {
   private final BlockPos ttf;
   private final Direction ttg;
   private final Vec3d tth;
   private final byte tti;

   private tte(BlockPos pos, Direction side, Vec3d point, byte cell) {
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
