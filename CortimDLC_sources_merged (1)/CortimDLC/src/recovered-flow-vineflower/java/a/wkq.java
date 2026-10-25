package a;

public final class wkq {
   public String name;
   public double x;
   public double y;
   public double z;
   public int color;
   public boolean ownColor;
   public String world;
   public String dimension;
   public boolean visible = true;
   public long created;

   public wkq() {
   }

   public wkq(String var1, double var2, double var4, double var6, int var8, String var9, String var10) {
      this.name = var1;
      this.x = var2;
      this.y = var4;
      this.z = var6;
      this.color = var8;
      this.world = var9;
      this.dimension = var10;
      this.created = System.currentTimeMillis();
   }

   public double cx() {
      return Math.floor(this.x) + 0.5;
   }

   public double cy() {
      return Math.floor(this.y) + 0.5;
   }

   public double cz() {
      return Math.floor(this.z) + 0.5;
   }
}
