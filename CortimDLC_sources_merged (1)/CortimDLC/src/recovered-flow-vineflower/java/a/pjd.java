package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class pjd {
   public static final int LIMIT = 3;
   public static final Object MAIN = new Object();
   static final long pje = 60000L;
   static final long pjf = 10000L;
   static final Map<Object, piv> pjg = new IdentityHashMap<>();
   static final List<pja> pjh = new ArrayList<>();

   pjd() {
   }

   public static String key(String var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.replaceAll(a.c(-821074676, "救᳥陘࠴菷Ԣ"), "");
      return var1.isEmpty() ? var0.trim().toLowerCase(Locale.ROOT) : var1;
   }

   public static synchronized boolean enter(Object var0, String var1) {
      long var2 = System.currentTimeMillis();
      pjm(var2);
      String var4 = key(var1);
      if (var0 != null && !var4.isEmpty()) {
         piv var5 = pjg.get(var0);
         if (var5 != null && var5.piw.equals(var4)) {
            pjg.put(var0, new piv(var4, var2));
            pjl(var0);
            return true;
         }

         pja var6 = pjk(var0);
         if (var6 == null || !var6.anarchy.equals(var4)) {
            pjl(var0);
            var6 = new pja(var0, var4, var2);
            pjh.add(var6);
         }

         var6.seen = var2;
         if (count(var4, var0) >= 3) {
            return false;
         }

         for (pja var8 : pjh) {
            if (var8.anarchy.equals(var4)) {
               if (var8.owner != var0) {
                  return false;
               }
               break;
            }
         }

         pjl(var0);
         pjg.put(var0, new piv(var4, var2));
         return true;
      } else {
         return true;
      }
   }

   public static synchronized boolean hasRoom(String var0, Object var1) {
      pjm(System.currentTimeMillis());
      String var2 = key(var0);
      piv var3 = pjg.get(var1);
      if (!var2.isEmpty() && (var3 == null || !var3.piw.equals(var2))) {
         if (count(var2, var1) >= 3) {
            return false;
         }

         for (pja var5 : pjh) {
            if (var5.anarchy.equals(var2)) {
               return var5.owner == var1;
            }
         }

         return true;
      } else {
         return true;
      }
   }

   public static synchronized int position(Object var0) {
      pja var1 = pjk(var0);
      if (var1 == null) {
         return 0;
      }

      int var2 = 0;

      for (pja var4 : pjh) {
         if (var4.anarchy.equals(var1.anarchy)) {
            var2++;
            if (var4 == var1) {
               return var2;
            }
         }
      }

      return 0;
   }

   public static synchronized int count(String var0, Object var1) {
      String var2 = key(var0);
      int var3 = 0;

      for (Entry var5 : pjg.entrySet()) {
         if (var5.getKey() != var1 && ((piv)var5.getValue()).piw.equals(var2)) {
            var3++;
         }
      }

      return var3;
   }

   public static synchronized void at(Object var0, String var1) {
      String var2 = key(var1);
      if (var0 != null && !var2.isEmpty()) {
         pjl(var0);
         pjg.put(var0, new piv(var2, System.currentTimeMillis()));
      }
   }

   public static synchronized String where(Object var0) {
      piv var1 = pjg.get(var0);
      return var1 == null ? "" : var1.piw;
   }

   public static synchronized void keep(Object var0) {
      piv var1 = pjg.get(var0);
      if (var1 != null) {
         pjg.put(var0, new piv(var1.piw, System.currentTimeMillis()));
      }
   }

   public static synchronized void cancel(Object var0) {
      pjl(var0);
   }

   public static synchronized void leave(Object var0) {
      pjl(var0);
      pjg.remove(var0);
   }

   static pja pjk(Object var0) {
      for (pja var2 : pjh) {
         if (var2.owner == var0) {
            return var2;
         }
      }

      return null;
   }

   static void pjl(Object var0) {
      pjh.removeIf(var1 -> var1.owner == var0);
   }

   static void pjm(long var0) {
      pjg.values().removeIf(var2x -> var0 - var2x.pix > 60000L);
      Iterator var2 = pjh.iterator();

      while (var2.hasNext()) {
         if (var0 - ((pja)var2.next()).seen > 10000L) {
            var2.remove();
         }
      }
   }
}
