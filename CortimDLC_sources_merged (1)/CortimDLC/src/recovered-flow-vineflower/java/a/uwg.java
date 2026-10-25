package a;

public record uwg(int first, int count, float r, float g, float b, float a, float scan, float sweep, float flash, float broken) {
   private final int uwh;
   private final int uwi;
   private final float uwj;
   private final float uwk;
   private final float uwl;
   private final float uwm;
   private final float uwn;
   private final float uwo;
   private final float uwp;
   private final float uwq;

   public uwg(int first, int count, float r, float g, float b, float a, float scan, float sweep, float flash, float broken) {
      this.uwh = first;
      this.uwi = count;
      this.uwj = r;
      this.uwk = g;
      this.uwl = b;
      this.uwm = a;
      this.uwn = scan;
      this.uwo = sweep;
      this.uwp = flash;
      this.uwq = broken;
   }

   public int first() {
      return this.uwh;
   }

   public int count() {
      return this.uwi;
   }

   public float r() {
      return this.uwj;
   }

   public float g() {
      return this.uwk;
   }

   public float b() {
      return this.uwl;
   }

   public float a() {
      return this.uwm;
   }

   public float scan() {
      return this.uwn;
   }

   public float sweep() {
      return this.uwo;
   }

   public float flash() {
      return this.uwp;
   }

   public float broken() {
      return this.uwq;
   }
}
