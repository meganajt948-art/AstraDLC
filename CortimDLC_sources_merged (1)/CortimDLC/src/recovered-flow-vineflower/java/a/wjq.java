package a;

record wjq(int start, int end, String value) {
   private final int wjr;
   private final int wjs;
   private final String wjt;

   private wjq(int start, int end, String value) {
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
