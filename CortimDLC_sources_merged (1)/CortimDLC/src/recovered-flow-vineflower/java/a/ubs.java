package a;

final class ubs {
   final String ubt;
   final String ubu;

   ubs(String from, String box) {
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
