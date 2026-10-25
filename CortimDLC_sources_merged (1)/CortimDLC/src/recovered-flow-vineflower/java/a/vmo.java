package a;

import java.util.function.BooleanSupplier;

public abstract class vmo {
   private final String vmp;
   private BooleanSupplier vmq;
   private BooleanSupplier vmr;

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
