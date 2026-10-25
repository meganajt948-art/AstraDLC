package a;

final class smw {
   private final String smx;
   private final vek smy;
   private final float smz;
   private final long sna;
   private final long snb;
   private final boolean snc;
   private final boolean snd;

   private smw(String text, vek weight, float scale, long start, long end, boolean newRow, boolean dim) {
      this.smx = text;
      this.smy = weight;
      this.smz = scale;
      this.sna = start;
      this.snb = end;
      this.snc = newRow;
      this.snd = dim;
   }

   public String text() {
      return this.smx;
   }

   public vek weight() {
      return this.smy;
   }

   public float scale() {
      return this.smz;
   }

   public long start() {
      return this.sna;
   }

   public long end() {
      return this.snb;
   }

   public boolean newRow() {
      return this.snc;
   }

   public boolean dim() {
      return this.snd;
   }
}
