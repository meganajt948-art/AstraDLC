package a;

final class wjq {
   final int wjr;
   final int wjs;
   final String wjt;

   wjq(int start, int end, String value) {
      this.wjr = start;
      this.wjs = end;
      this.wjt = value;
   }

   public int start() {
      return this.wjr;
   }

   public int end() {
      return this.wjs;
   }

   public String value() {
      return this.wjt;
   }
}
