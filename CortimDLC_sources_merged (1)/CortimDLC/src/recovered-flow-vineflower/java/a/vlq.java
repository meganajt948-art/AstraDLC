package a;

public class vlq extends vmo {
   final int vlr;
   int vls;

   public vlq(String var1) {
      this(var1, -1);
   }

   public vlq(String var1, int var2) {
      super(var1);
      this.vlr = var2;
      this.vls = var2;
   }

   public int get() {
      return this.vls;
   }

   public void set(int var1) {
      this.vls = var1;
   }

   public boolean isBound() {
      return this.vls != -1;
   }

   public void reset() {
      this.vls = this.vlr;
   }
}
