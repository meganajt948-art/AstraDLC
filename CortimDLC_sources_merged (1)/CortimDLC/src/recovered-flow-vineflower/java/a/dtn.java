package a;

final class dtn {
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
