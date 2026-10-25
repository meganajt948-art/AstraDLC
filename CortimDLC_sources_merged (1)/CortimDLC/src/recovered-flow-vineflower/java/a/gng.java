package a;

record gng(int tick, boolean crit) {
   private final int gnh;
   private final boolean gni;

   private gng(int tick, boolean crit) {
      this.gnh = tick;
      this.gni = crit;
   }

   public int tick() {
      return this.gnh;
   }

   public boolean crit() {
      return this.gni;
   }
}
