package a;

public class rfl extends kfe {
   static rfl rfm;
   public final vmc range = this.add(new vmc("Range", 32.0, 8.0, 96.0, 4.0).suffix("m"));
   public final vmc size = this.add(new vmc("Size", 1.0, 0.6, 1.6, 0.05).percent());
   public final vlv background = this.add(new vlv("Background", "Solid", "Solid", "None"));
   public final vkl icon = this.add(new vkl("Icon", true));
   public final vkl merge = this.add(new vkl("Merge", true));
   public final vkl rarity = this.add(new vkl("Rarity colour", true));

   public rfl() {
      super(new String(new char[]{'I', 't', 'e', 'm', 'E', 'S', 'P'}), "Tags over dropped items", kfa.RENDER);
      rfm = this;
   }

   public static rfl get() {
      return rfm;
   }
}
