package a;

final class emo {
   private final String emp;
   private final int emq;
   private final boolean emr;

   private emo(String text, int level, boolean deny) {
      this.emp = text;
      this.emq = level;
      this.emr = deny;
   }

   public String text() {
      return this.emp;
   }

   public int level() {
      return this.emq;
   }

   public boolean deny() {
      return this.emr;
   }
}
