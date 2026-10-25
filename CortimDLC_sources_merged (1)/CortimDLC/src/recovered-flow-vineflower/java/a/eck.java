package a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public final class eck {
   private static final int ecl = 200;
   private final ArrayDeque<ech> ecm = new ArrayDeque<>();
   private int ecn;

   void server(Text var1, boolean var2) {
      this.ecq(new ech(var1, var2 ? ece.CHAT : ece.SERVER));
   }

   void own(String var1) {
      this.ecq(new ech(Text.method_43470(var1).method_27692(Formatting.field_1068), ece.OWN));
   }

   void system(String var1) {
      this.ecq(new ech(Text.method_43470(var1).method_27692(Formatting.field_1080), ece.SYSTEM));
   }

   private void ecq(ech var1) {
      this.ecm.addLast(var1);

      while (this.ecm.size() > 200) {
         this.ecm.removeFirst();
      }

      this.ecn++;
   }

   public List<ech> lines() {
      return new ArrayList<>(this.ecm);
   }

   ech firstServerAfter(long var1, long var3) {
      ech var5 = null;
      Iterator var6 = this.ecm.descendingIterator();

      while (var6.hasNext()) {
         ech var7 = (ech)var6.next();
         if (var7.time < var1) {
            break;
         }

         if (var7.kind == ece.SERVER && var7.time <= var1 + var3 && !var7.text.getString().isBlank()) {
            var5 = var7;
         }
      }

      return var5;
   }

   public int revision() {
      return this.ecn;
   }

   public int size() {
      return this.ecm.size();
   }
}
