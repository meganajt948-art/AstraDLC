package a;

final class dtn {
   final long dto;
   final Runnable dtp;

   dtn(long at, Runnable action) {
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
