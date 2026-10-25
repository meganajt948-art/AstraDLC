package a;

public final class vkq {
   private final String vkr;
   private final vhz vks;
   private final Runnable vkt;

   public vkq(String label, vhz icon, Runnable action) {
      this.vkr = label;
      this.vks = icon;
      this.vkt = action;
   }

   public String label() {
      return this.vkr;
   }

   public vhz icon() {
      return this.vks;
   }

   public Runnable action() {
      return this.vkt;
   }
}
