package a;

final class iog {
   final String ioh;
   final int ioi;
   final boolean ioj;

   iog(String name, int slot, boolean hud) {
      this.ioh = name;
      this.ioi = slot;
      this.ioj = hud;
   }

   boolean hasAlpha() {
      return this.ioi != 0 && this.ioi != 15 && this.ioi != 16;
   }

   public String name() {
      return this.ioh;
   }

   public int slot() {
      return this.ioi;
   }

   public boolean hud() {
      return this.ioj;
   }
}
