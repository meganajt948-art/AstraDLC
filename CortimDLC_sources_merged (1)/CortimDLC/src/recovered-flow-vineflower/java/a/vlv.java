package a;

import java.util.Arrays;
import java.util.List;

public class vlv extends vmo {
   private final String vlw;
   private List<String> vlx;
   private int vly;
   private int vlz;

   public vlv(String var1, String var2, String... var3) {
      super(var1);
      this.vlw = var2;
      this.vlx = Arrays.asList(var3);
      int var4 = this.vlx.indexOf(var2);
      this.vlz = var4 < 0 ? 0 : var4;
      this.vly = this.vlz;
   }

   public void setModes(List<String> var1) {
      if (!var1.isEmpty() && !var1.equals(this.vlx)) {
         String var2 = this.get();
         this.vlx = List.copyOf(var1);
         this.vly = Math.max(0, this.vlx.indexOf(this.vlw));
         this.vlz = this.vly;
         this.set(var2);
      }
   }

   public int index() {
      return this.vlz;
   }

   public void reset() {
      this.vlz = this.vly;
   }

   public String get() {
      return this.vlx.get(this.vlz);
   }

   public boolean is(String var1) {
      return this.get().equalsIgnoreCase(var1);
   }

   public List<String> getModes() {
      return this.vlx;
   }

   public void set(String var1) {
      for (int var2 = 0; var2 < this.vlx.size(); var2++) {
         if (this.vlx.get(var2).equalsIgnoreCase(var1)) {
            this.vlz = var2;
            return;
         }
      }
   }

   public void cycle() {
      this.vlz = (this.vlz + 1) % this.vlx.size();
   }

   public void cyclePrev() {
      this.vlz = (this.vlz - 1 + this.vlx.size()) % this.vlx.size();
   }
}
