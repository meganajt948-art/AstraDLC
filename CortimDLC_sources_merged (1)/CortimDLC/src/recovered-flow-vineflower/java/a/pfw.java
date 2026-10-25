package a;

public final class pfw {
   final int pfx;
   final int pfy;

   public pfw(int page, int price) {
      this.pfx = page;
      this.pfy = price;
   }

   public int page() {
      return this.pfx;
   }

   public int price() {
      return this.pfy;
   }
}
