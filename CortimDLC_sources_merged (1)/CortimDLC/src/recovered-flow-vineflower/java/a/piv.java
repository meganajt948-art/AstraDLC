package a;

record piv(String anarchy, long seen) {
   private final String piw;
   private final long pix;

   private piv(String anarchy, long seen) {
      this.piw = anarchy;
      this.pix = seen;
   }

   public String anarchy() {
      return this.piw;
   }

   public long seen() {
      return this.pix;
   }
}
