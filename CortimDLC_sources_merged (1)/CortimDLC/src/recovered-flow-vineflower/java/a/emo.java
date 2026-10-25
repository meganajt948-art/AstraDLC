package a;

final class emo {
   final String emp;
   final int emq;
   final boolean emr;

   emo(String text, int level, boolean deny) {
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
