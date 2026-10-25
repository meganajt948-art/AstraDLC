package a;

final class hkv {
   private final String hkw;
   private final vhz hkx;
   private final kfa hky;
   private final hks hkz;

   private hkv(String title, vhz icon, kfa category, hks page) {
      this.hkw = title;
      this.hkx = icon;
      this.hky = category;
      this.hkz = page;
   }

   public String title() {
      return this.hkw;
   }

   public vhz icon() {
      return this.hkx;
   }

   public kfa category() {
      return this.hky;
   }

   public hks page() {
      return this.hkz;
   }
}
