package a;

record viw(vjb sheet, long frame) {
   private final vjb vix;
   private final long viy;

   private viw(vjb sheet, long frame) {
      this.vix = sheet;
      this.viy = frame;
   }

   public vjb sheet() {
      return this.vix;
   }

   public long frame() {
      return this.viy;
   }
}
