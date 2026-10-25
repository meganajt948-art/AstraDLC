package a;

record nes(pzc area, int diamonds, boolean look) {
   private final pzc net;
   private final int neu;
   private final boolean nev;

   private nes(pzc area, int diamonds, boolean look) {
      this.net = area;
      this.neu = diamonds;
      this.nev = look;
   }

   public pzc area() {
      return this.net;
   }

   public int diamonds() {
      return this.neu;
   }

   public boolean look() {
      return this.nev;
   }
}
