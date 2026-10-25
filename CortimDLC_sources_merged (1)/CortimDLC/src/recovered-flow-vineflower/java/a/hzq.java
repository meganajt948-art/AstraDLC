package a;

public final class hzq {
   public final String id;
   public final String name;
   private final Runnable hzr;
   private final int hzs;
   int key;
   final irk bind;

   hzq(String var1, String var2, Runnable var3) {
      this(var1, var2, -1, var3);
   }

   hzq(String var1, String var2, int var3, Runnable var4) {
      this.id = var1;
      this.name = var2;
      this.hzr = var4;
      this.hzs = var3;
      this.key = var3;
      this.bind = new irk(var2, () -> this.key, var1x -> this.key = var1x, true);
   }

   public int key() {
      return this.key;
   }

   public void reset() {
      this.key = this.hzs;
   }
}
