package a;

import net.minecraft.util.math.Vec3d;

public final class pzp {
   private final qwj pzq;
   private final String pzr;
   private final int pzs;
   private final Vec3d pzt;

   public pzp(qwj tier, String tierWord, int seconds, Vec3d pos) {
      this.pzq = tier;
      this.pzr = tierWord;
      this.pzs = seconds;
      this.pzt = pos;
   }

   public qwj tier() {
      return this.pzq;
   }

   public String tierWord() {
      return this.pzr;
   }

   public int seconds() {
      return this.pzs;
   }

   public Vec3d pos() {
      return this.pzt;
   }
}
