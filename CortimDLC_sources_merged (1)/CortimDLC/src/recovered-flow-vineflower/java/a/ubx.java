package a;

record ubx(String from, String c, long at) {
   private final String uby;
   private final String ubz;
   private final long uca;

   private ubx(String from, String c, long at) {
      this.uby = from;
      this.ubz = c;
      this.uca = at;
   }

   public String from() {
      return this.uby;
   }

   public String c() {
      return this.ubz;
   }

   public long at() {
      return this.uca;
   }
}
