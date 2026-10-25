package a;

public final class ubj {
   public String from;
   public String name;
   public int id;
   public double x;
   public double y;
   public double z;
   public String world;
   public String dim;
   public int kind;
   public String target;
   public long born;
   public long life;
   public int color;
   public boolean mine;

   public boolean danger() {
      return this.kind == 1;
   }

   public float age(long var1) {
      return (float)(var1 - this.born) / 1000.0F;
   }
}
