package a;

import java.util.List;

public class vkw extends vmo {
   final List<vkq> vkx;

   public vkw(String var1, vkq... var2) {
      super(var1);
      this.vkx = List.of(var2);
   }

   public List<vkq> buttons() {
      return this.vkx;
   }
}
