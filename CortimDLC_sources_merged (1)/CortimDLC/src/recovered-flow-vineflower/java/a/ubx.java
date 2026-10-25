package a;

final class ubx {
   final String uby;
   final String ubz;
   final long uca;

   ubx(String from, String c, long at) {
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
