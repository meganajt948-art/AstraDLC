package a;

record hip(String label, vhz icon, Runnable action) {
   private final String hiq;
   private final vhz hir;
   private final Runnable his;

   hip(String label, vhz icon, Runnable action) {
      this.hiq = label;
      this.hir = icon;
      this.his = action;
   }

   public String label() {
      return this.hiq;
   }

   public vhz icon() {
      return this.hir;
   }

   public Runnable action() {
      return this.his;
   }
}
