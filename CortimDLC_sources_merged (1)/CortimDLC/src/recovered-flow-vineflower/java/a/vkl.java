package a;

public class vkl extends vmo {
   private final boolean vkm;
   private boolean vkn;

   public vkl(String var1, boolean var2) {
      super(var1);
      this.vkm = var2;
      this.vkn = var2;
   }

   public boolean get() {
      return this.vkn;
   }

   public void set(boolean var1) {
      this.vkn = var1;
   }

   public void toggle() {
      this.vkn = !this.vkn;
   }

   public void reset() {
      this.vkn = this.vkm;
   }
}
