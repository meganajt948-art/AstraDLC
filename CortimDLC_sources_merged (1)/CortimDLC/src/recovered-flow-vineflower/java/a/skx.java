package a;

public final class skx {
   private final long sky;
   private final long skz;
   private final String sla;
   private final long[] slb;

   public skx(long start, long end, String text, long[] words) {
      this.sky = start;
      this.skz = end;
      this.sla = text;
      this.slb = words;
   }

   public boolean blank() {
      return this.sla.isEmpty();
   }

   public long start() {
      return this.sky;
   }

   public long end() {
      return this.skz;
   }

   public String text() {
      return this.sla;
   }

   public long[] words() {
      return this.slb;
   }
}
