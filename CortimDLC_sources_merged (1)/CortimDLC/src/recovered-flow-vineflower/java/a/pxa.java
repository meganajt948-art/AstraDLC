package a;

public final class pxa {
   public double progress;
   public double startY;
   public double endY;
   public double maxY;
   public double minY;
   public double endX;
   public double endZ;
   public boolean endOnGround;
   public int firstBlockTick = -1;

   public boolean blockedWithin(int var1) {
      return this.firstBlockTick >= 0 && this.firstBlockTick <= var1;
   }
}
