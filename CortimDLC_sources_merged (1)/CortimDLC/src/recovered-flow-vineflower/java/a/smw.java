package a;

final class smw {
   final String smx;
   final vek smy;
   final float smz;
   final long sna;
   final long snb;
   final boolean snc;
   final boolean snd;

   smw(String text, vek weight, float scale, long start, long end, boolean newRow, boolean dim) {
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
