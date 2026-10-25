package a;

import java.util.List;
import net.minecraft.util.math.Vec3d;

record pzk(Vec3d pos, List<String> lines) {
   private final Vec3d pzl;
   private final List<String> pzm;

   private pzk(Vec3d pos, List<String> lines) {
      this.pzl = pos;
      this.pzm = lines;
   }

   public Vec3d pos() {
      return this.pzl;
   }

   public List<String> lines() {
      return this.pzm;
   }
}
