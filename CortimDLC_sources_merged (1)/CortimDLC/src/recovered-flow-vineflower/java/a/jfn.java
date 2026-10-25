package a;

final class jfn {
   private final String jfo;
   private final String jfp;
   private final int jfq;
   private final qwj jfr;
   private final long jfs;
   private final boolean jft;

   jfn(String key, String status, int id, qwj tier, long refreshAt, boolean focus) {
      this.jfo = key;
      this.jfp = status;
      this.jfq = id;
      this.jfr = tier;
      this.jfs = refreshAt;
      this.jft = focus;
   }

   public String key() {
      return this.jfo;
   }

   public String status() {
      return this.jfp;
   }

   public int id() {
      return this.jfq;
   }

   public qwj tier() {
      return this.jfr;
   }

   public long refreshAt() {
      return this.jfs;
   }

   public boolean focus() {
      return this.jft;
   }
}
