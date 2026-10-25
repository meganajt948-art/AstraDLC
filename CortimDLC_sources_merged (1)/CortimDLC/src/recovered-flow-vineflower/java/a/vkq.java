package a;

public final class vkq {
   final String vkr;
   final vhz vks;
   final Runnable vkt;

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
