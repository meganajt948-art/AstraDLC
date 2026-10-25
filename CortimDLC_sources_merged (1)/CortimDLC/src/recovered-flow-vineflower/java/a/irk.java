package a;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

final class irk {
   final String irl;
   final IntSupplier irm;
   final IntConsumer irn;
   final boolean iro;

   irk(String name, IntSupplier getter, IntConsumer setter, boolean clearable) {
      this.irl = name;
      this.irm = getter;
      this.irn = setter;
      this.iro = clearable;
   }

   int get() {
      return this.irm.getAsInt();
   }

   void set(int var1) {
      this.irn.accept(var1);
   }

   public String name() {
      return this.irl;
   }

   public IntSupplier getter() {
      return this.irm;
   }

   public IntConsumer setter() {
      return this.irn;
   }

   public boolean clearable() {
      return this.iro;
   }
}
