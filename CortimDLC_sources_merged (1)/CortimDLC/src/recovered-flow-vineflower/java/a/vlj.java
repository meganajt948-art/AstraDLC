package a;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class vlj extends vmo {
   final vlg vlk;
   final List<String> vll;
   final Set<String> vlm = new LinkedHashSet<>();
   int vln;

   public vlj(String var1, vlg var2, String... var3) {
      super(var1);
      this.vlk = var2;
      this.vll = List.of(var3);
      this.vlm.addAll(this.vll);
   }

   public vlg kind() {
      return this.vlk;
   }

   public int version() {
      return this.vln;
   }

   public Set<String> ids() {
      return Collections.unmodifiableSet(this.vlm);
   }

   public boolean contains(String var1) {
      return this.vlm.contains(var1);
   }

   public int size() {
      return this.vlm.size();
   }

   public boolean toggle(String var1) {
      boolean var2 = !this.vlm.remove(var1);
      if (var2) {
         this.vlm.add(var1);
      }

      this.vln++;
      return var2;
   }

   public void set(Collection<String> var1) {
      this.vlm.clear();

      for (String var3 : var1) {
         if (var3 != null && !var3.isBlank()) {
            this.vlm.add(var3.trim());
         }
      }

      this.vln++;
   }

   public void clear() {
      this.vlm.clear();
      this.vln++;
   }

   public void reset() {
      this.vlm.clear();
      this.vlm.addAll(this.vll);
      this.vln++;
   }
}
