package a;

public final class tmk {
   public int epochs = 40;
   public int hidden = 48;
   public int members = 2;
   public boolean mirror = true;
   public boolean dropOvershoot = true;
   public boolean track;
   public double overshootWeight = 10.0;
   public int threads = 2;
   public long seed = System.nanoTime();
   public int minWindow = 3;
}
