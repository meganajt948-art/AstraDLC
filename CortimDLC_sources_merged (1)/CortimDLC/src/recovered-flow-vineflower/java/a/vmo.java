package a;

import java.util.function.BooleanSupplier;

public abstract class vmo {
   final String vmp;
   BooleanSupplier vmq;
   BooleanSupplier vmr;

   protected vmo(String var1) {
      this.vmp = var1;
   }

   public String getName() {
      return this.vmp;
   }

   public void activeWhen(BooleanSupplier var1) {
      this.vmq = var1;
   }

   public BooleanSupplier activeCondition() {
      return this.vmq;
   }

   public void visibleWhen(BooleanSupplier var1) {
      this.vmr = var1;
   }

   public BooleanSupplier visibleCondition() {
      return this.vmr;
   }
}
