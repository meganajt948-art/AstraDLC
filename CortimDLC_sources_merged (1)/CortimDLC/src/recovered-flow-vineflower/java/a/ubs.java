package a;

final class ubs {
   private final String ubt;
   private final String ubu;

   private ubs(String from, String box) {
      this.ubt = from;
      this.ubu = box;
   }

   public String from() {
      return this.ubt;
   }

   public String box() {
      return this.ubu;
   }
}
