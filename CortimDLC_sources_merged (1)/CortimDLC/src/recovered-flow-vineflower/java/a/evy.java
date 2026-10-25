package a;

public record evy(String data, int enabled, int modules, long updated) {
   private final String evz;
   private final int ewa;
   private final int ewb;
   private final long ewc;

   public evy(String data, int enabled, int modules, long updated) {
      this.evz = data;
      this.ewa = enabled;
      this.ewb = modules;
      this.ewc = updated;
   }

   public String data() {
      return this.evz;
   }

   public int enabled() {
      return this.ewa;
   }

   public int modules() {
      return this.ewb;
   }

   public long updated() {
      return this.ewc;
   }
}
