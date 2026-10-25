package a;

public class vmu extends vmo {
   private final String vmv;
   private final int vmw;
   private String vmx;
   private String vmy;

   public vmu(String var1, String var2, int var3) {
      super(var1);
      this.vmv = var2;
      this.vmw = var3;
      this.vmx = var2;
   }

   public String get() {
      return this.vmx;
   }

   public void set(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      this.vmx = var1.length() > this.vmw ? var1.substring(0, this.vmw) : var1;
   }

   public int maxLength() {
      return this.vmw;
   }

   public String defaultValue() {
      return this.vmv;
   }

   public vmu example(String var1) {
      this.vmy = var1;
      return this;
   }

   public String example() {
      return this.vmy;
   }

   public void reset() {
      this.vmx = this.vmv;
   }
}
