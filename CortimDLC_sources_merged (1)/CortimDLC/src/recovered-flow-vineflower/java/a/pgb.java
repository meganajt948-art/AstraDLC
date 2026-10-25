package a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class pgb {
   public static final int PAGES = 16;
   public static final int SLOTS = 4;
   private static final double pgc = 0.03;
   private final List<pfw> pgd = new ArrayList<>(4);
   private final Set<Integer> pge = new HashSet<>();
   private boolean pgf;

   public boolean markPage(int var1) {
      return this.pge.add(var1);
   }

   public boolean enough() {
      return this.pgd.size() >= 4;
   }

   public void offer(int var1, int var2) {
      if (!this.pgf && var2 > 0) {
         int var3 = 0;

         while (var3 < this.pgd.size() && this.pgd.get(var3).price() <= var2) {
            var3++;
         }

         if (var3 < 4) {
            this.pgd.add(var3, new pfw(var1, var2));

            while (this.pgd.size() > 4) {
               this.pgd.remove(this.pgd.size() - 1);
            }
         }
      }
   }

   public boolean choose(int var1) {
      if (this.pgd.isEmpty()) {
         return false;
      }

      long var2 = this.pgd.get(0).price() + Math.max(1L, Math.round(this.pgd.get(0).price() * 0.03));
      pfw var4 = this.pgd.get(0);

      for (pfw var6 : this.pgd) {
         if (var6.price() > var2) {
            break;
         }

         if (Math.abs(var6.page() - var1) < Math.abs(var4.page() - var1)) {
            var4 = var6;
         }
      }

      this.pgd.remove(var4);
      this.pgd.add(0, var4);
      this.pgf = true;
      return true;
   }

   public pfw target() {
      return this.pgf && !this.pgd.isEmpty() ? this.pgd.get(0) : null;
   }

   public pfw dropTarget() {
      if (!this.pgd.isEmpty()) {
         this.pgd.remove(0);
      }

      return this.target();
   }

   public void release() {
      this.pgd.clear();
      this.pge.clear();
      this.pgf = false;
   }
}
