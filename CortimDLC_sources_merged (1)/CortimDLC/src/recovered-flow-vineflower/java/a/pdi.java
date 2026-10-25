package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.Locale;

public final class pdi {
   public static final int SEARCH = 0;
   public static final int SELL = 1;
   private static final long pdj = 60000L;
   private static final long pdk = 600000L;
   private static final ArrayDeque<Long>[] pdl = new ArrayDeque[]{new ArrayDeque(), new ArrayDeque()};
   private static int pdm;
   private static long pdn;

   private pdi() {
   }

   public static void observe(String var0) {
      if (var0 != null) {
         String var1 = var0.trim().toLowerCase(Locale.ROOT);
         if (var1.startsWith(a.d("鈒\uebaa愱３瓒\uf26a䠹", -1870505834, 989907682)) || var1.startsWith(a.d("亭㜈뷍⎫ꡡ⻖钄ᴻ茷ঐ蹊琻", -1852168949, -2142475317))) {
            note(1);
         } else if (var1.equals(a.c(-1404359048, "⸛垣"))
            || var1.startsWith(a.d("听ⶔ꜏", 1814205899, 385008005))
            || var1.equals(a.c(-960735480, "坮⻋ꐎ㩨놢㜕赇"))
            || var1.startsWith(a.b("㶸䐝컘傾\udb74巃\ue791渮", 411450833))) {
            note(0);
         }
      }
   }

   public static synchronized void note(int var0) {
      long var1 = System.currentTimeMillis();
      pdl[var0].addLast(var1);
      pdq(var0, var1);
   }

   public static synchronized int limit(int var0) {
      return pdm > 0 && System.currentTimeMillis() - pdn < 600000L ? Math.max(3, var0 / 2) : Math.max(1, var0);
   }

   public static synchronized long nextFree(int var0, int var1, long var2) {
      pdq(var0, var2);
      int var4 = limit(var1);
      ArrayDeque var5 = pdl[var0];
      if (var5.size() < var4) {
         return var2;
      } else {
         int var6 = var5.size() - var4;
         long var7 = var2;

         for (long var10 : var5) {
            if (var6-- <= 0) {
               var7 = var10 + 60000L;
               break;
            }
         }

         return Math.max(var2, var7);
      }
   }

   public static synchronized int warn() {
      long var0 = System.currentTimeMillis();
      if (var0 - pdn > 600000L) {
         pdm = 0;
      }

      pdm++;
      pdn = var0;
      return pdm;
   }

   private static void pdq(int var0, long var1) {
      ArrayDeque var3 = pdl[var0];

      while (!var3.isEmpty() && var1 - var3.peekFirst() > 60000L) {
         var3.pollFirst();
      }
   }
}
