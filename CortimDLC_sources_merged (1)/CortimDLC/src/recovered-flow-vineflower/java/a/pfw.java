package a;

public record pfw(int page, int price) {
   private final int pfx;
   private final int pfy;

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
