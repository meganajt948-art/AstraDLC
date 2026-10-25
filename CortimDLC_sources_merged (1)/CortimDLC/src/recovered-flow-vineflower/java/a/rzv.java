package a;

import net.minecraft.util.math.Vec3d;

public class rzv {
   public Vec3d pos;
   public long expirationTime;
   public String dimension;
   public boolean notifiedTen;
   public boolean notifiedReady;
   public boolean isReady;
   long lastSeen;
   public long lastNumericUpdate;
   long zeroSince;
   public boolean untimed;

   rzv(Vec3d var1, long var2, String var4, long var5) {
      this.pos = var1;
      this.expirationTime = var2;
      this.dimension = var4;
      this.lastSeen = var5;
      this.lastNumericUpdate = 0L;
   }

   public boolean countdownShown(long var1) {
      return this.lastNumericUpdate > 0L && var1 - this.lastNumericUpdate < 150L;
   }

   public long zeroShownMs(long var1) {
      return this.zeroSince != 0L && this.countdownShown(var1) ? var1 - this.zeroSince : 0L;
   }
}
