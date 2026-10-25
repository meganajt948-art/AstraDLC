package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class sle {
   public static final sle NONE = new sle(List.of());
   private static final Pattern slf = Pattern.compile("\\[(\\d{1,3}):(\\d{1,2})(?:[.:](\\d{1,3}))?]");
   private static final Pattern slg = Pattern.compile("<(\\d{1,3}):(\\d{1,2})(?:[.:](\\d{1,3}))?>");
   private static final Pattern slh = Pattern.compile("\\[offset:\\s*([+-]?\\d+)\\s*]", 2);
   private static final long sli = 7000L;
   private final List<skx> slj;

   private sle(List<skx> var1) {
      this.slj = var1;
   }

   public List<skx> lines() {
      return this.slj;
   }

   public boolean isEmpty() {
      return this.slj.isEmpty();
   }

   public int indexAt(long var1) {
      int var3 = 0;
      int var4 = this.slj.size() - 1;
      int var5 = -1;

      while (var3 <= var4) {
         int var6 = var3 + var4 >>> 1;
         if (this.slj.get(var6).start() <= var1) {
            var5 = var6;
            var3 = var6 + 1;
         } else {
            var4 = var6 - 1;
         }
      }

      return var5;
   }

   public static sle parse(String var0) {
      if (var0 != null && !var0.isBlank()) {
         long var1 = 0L;
         Matcher var3 = slh.matcher(var0);
         if (var3.find()) {
            try {
               var1 = Long.parseLong(var3.group(1));
            } catch (NumberFormatException var20) {
            }
         }

         ArrayList var4 = new ArrayList();

         record Raw(long start, String text, long[] words) {
            private final long sks;
            private final String skt;
            private final long[] sku;

            Raw(long start, String text, long[] words) {
               this.sks = start;
               this.skt = text;
               this.sku = words;
            }

            public long start() {
               return this.sks;
            }

            public String text() {
               return this.skt;
            }

            public long[] words() {
               return this.sku;
            }
         }

         for (String var8 : var0.split("\r?\n")) {
            Matcher var9 = slf.matcher(var8);
            ArrayList var10 = new ArrayList();

            int var11;
            for (var11 = 0; var9.find() && var9.start() == var11; var11 = var9.end()) {
               var10.add(sln(var9) - var1);
            }

            if (!var10.isEmpty()) {
               String var12 = var8.substring(var11);
               ArrayList var13 = new ArrayList();
               Matcher var14 = slg.matcher(var12);

               while (var14.find()) {
                  var13.add(sln(var14) - var1);
               }

               String var15 = slo(slg.matcher(var12).replaceAll(" "));
               long[] var16 = null;
               if (!var13.isEmpty() && !var15.isEmpty()) {
                  int var17 = var15.split(" ").length;
                  if (var13.size() >= var17) {
                     var16 = new long[var17];

                     for (int var18 = 0; var18 < var17; var18++) {
                        var16[var18] = (Long)var13.get(var18);
                     }
                  }
               }

               for (long var29 : var10) {
                  var4.add(new Raw(Math.max(0L, var29), var15, var16 == null ? null : slm(var16, var29 - (Long)var10.get(0))));
               }
            }
         }

         if (var4.isEmpty()) {
            return NONE;
         } else {
            var4.sort((var0x, var1x) -> Long.compare(var0x.sks, var1x.sks));
            ArrayList var21 = new ArrayList(var4.size());

            for (int var22 = 0; var22 < var4.size(); var22++) {
               Raw var24 = (Raw)var4.get(var22);
               long var26 = var22 + 1 < var4.size() ? ((Raw)var4.get(var22 + 1)).sks : var24.sks + 7000L;
               var21.add(new skx(var24.sks, Math.max(var24.sks + 1L, var26), var24.skt, var24.sku));
            }

            boolean var23 = false;

            for (skx var27 : var21) {
               var23 |= !var27.blank();
            }

            return var23 ? new sle(List.copyOf(var21)) : NONE;
         }
      } else {
         return NONE;
      }
   }

   private static long[] slm(long[] var0, long var1) {
      if (var1 == 0L) {
         return var0;
      } else {
         long[] var3 = Arrays.copyOf(var0, var0.length);

         for (int var4 = 0; var4 < var3.length; var4++) {
            var3[var4] += var1;
         }

         return var3;
      }
   }

   private static long sln(Matcher var0) {
      long var1 = Long.parseLong(var0.group(1));
      long var3 = Long.parseLong(var0.group(2));
      String var5 = var0.group(3);
      long var6 = 0L;
      if (var5 != null) {
         var6 = Long.parseLong(var5);

         var6 = switch (var5.length()) {
            case 1 -> var6 * 100L;
            case 2 -> var6 * 10L;
            default -> var6;
         };
      }

      return var1 * 60000L + var3 * 1000L + var6;
   }

   private static String slo(String var0) {
      String var1 = var0.replace(' ', ' ').replaceAll("\\s+", " ").trim();
      int var2 = 0;

      while (var2 < var1.length()) {
         int var3 = var1.codePointAt(var2);
         if (Character.isLetterOrDigit(var3)) {
            return var1;
         }

         var2 += Character.charCount(var3);
      }

      return "";
   }
}
