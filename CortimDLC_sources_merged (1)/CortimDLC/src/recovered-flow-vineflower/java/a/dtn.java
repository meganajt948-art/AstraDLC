package a;

record dtn(long at, Runnable action) {
   private final long dto;
   private final Runnable dtp;

   private dtn(long at, Runnable action) {
      this.dto = at;
      this.dtp = action;
   }

   public long at() {
      return this.dto;
   }

   public Runnable action() {
      return this.dtp;
   }
}
