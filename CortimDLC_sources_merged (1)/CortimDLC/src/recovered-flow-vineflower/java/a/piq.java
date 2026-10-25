package a;

public final class piq {
   private long pir = System.currentTimeMillis();
   private long pis;

   public void arm(long var1) {
      this.pir = System.currentTimeMillis();
      this.pis = Math.max(0L, var1);
   }

   public void restart() {
      this.pir = System.currentTimeMillis();
   }

   public boolean ready() {
      return System.currentTimeMillis() - this.pir >= this.pis;
   }

   public boolean elapsed(long var1) {
      return System.currentTimeMillis() - this.pir >= var1;
   }
}
