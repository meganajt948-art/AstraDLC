package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class qqs {
   private static final long qqt = 30000L;
   private final Map<Integer, qqm> qqu = new HashMap<>();
   private final Map<Integer, Long> qqv = new HashMap<>();
   private List<Integer> qqw = List.of();
   private int qqx;
   private double qqy = 6000.0;
   private double qqz = 10000.0;

   public void list(List<Integer> var1) {
      if (!var1.equals(this.qqw)) {
         this.qqw = List.copyOf(var1);
         this.qqx = 0;
      }
   }

   public void clear() {
      this.qqu.clear();
      this.qqv.clear();
      this.qqx = 0;
   }

   public long hopMs() {
      return (long)this.qqy;
   }

   public long warpMs() {
      return (long)this.qqz;
   }

   public long goMs() {
      return (long)(this.qqy + this.qqz);
   }

   public void hopTook(long var1) {
      this.qqy = this.qqy * 0.6 + Math.max(1500.0, Math.min(40000.0, var1)) * 0.4;
   }

   public void warpTook(long var1) {
      this.qqz = this.qqz * 0.6 + Math.max(1000.0, Math.min(30000.0, var1)) * 0.4;
   }

   public void block(int var1, long var2) {
      this.qqv.put(var1, var2);
   }

   public qqm entry(int var1) {
      return this.qqu.get(var1);
   }

   public List<qqm> entries() {
      return new ArrayList<>(this.qqu.values());
   }

   public qqm seen(int var1, qwj var2, int var3, long var4) {
      qqm var6 = this.qqu.computeIfAbsent(var1, qqm::new);
      long var7 = var4 + var3 * 1000L + 500L;
      if (var6.tier != null && var6.refreshAt <= var4 + 3000L && var7 > var6.refreshAt + 10000L) {
         var6.lastTier = var6.tier;
         var6.lastRefreshAt = Math.min(var6.refreshAt, var4);
      }

      boolean var9 = var6.tier != null && var6.refreshAt > var4 && Math.abs(var6.refreshAt - var7) < 4000L;
      var6.refreshAt = var9 ? (var6.refreshAt * 3L + var7) / 4L : var7;
      var6.tier = var2;
      var6.seenAt = var4;
      return var6;
   }

   public void forget(int var1) {
      this.qqu.remove(var1);
   }

   public void mined(int var1) {
      qqm var2 = this.qqu.get(var1);
      if (var2 != null) {
         var2.minedAt = var2.lastRefreshAt;
      }
   }

   public qwj fresh(int var1, long var2, qqd var4) {
      qqm var5 = this.qqu.get(var1);
      if (var5 != null && var5.lastTier != null && var4.tiers.contains(var5.lastTier)) {
         return var5.minedAt != var5.lastRefreshAt && var2 - var5.lastRefreshAt <= 30000L && var5.lastRefreshAt <= var2 + 3000L ? var5.lastTier : null;
      } else {
         return null;
      }
   }

   public void scanned(int var1) {
      int var2 = this.qqw.indexOf(var1);
      if (var2 >= 0) {
         this.qqx = (var2 + 1) % Math.max(1, this.qqw.size());
      }
   }

   public qqg decide(long var1, int var3, long var4, qqd var6) {
      qqm var7 = null;

      for (qqm var9 : this.qqu.values()) {
         if (this.qrd(var9, var1, var3, var4, var6) && qrg(var9, var7)) {
            var7 = var9;
         }
      }

      int var14 = this.qrc(var1, var3);
      if (var7 == null) {
         return var14 >= 0 ? new qqg(qqp.SCAN, var14, null) : new qqg(qqp.IDLE, -1, null);
      }

      long var15 = var7.refreshAt - var1;
      if (var15 <= var6.waitMs + this.qre(var7, var3, var4)) {
         return new qqg(qqp.GO, var7.id, var7);
      }

      qqm var11 = null;

      for (qqm var13 : this.qqu.values()) {
         if (var13 != var7
            && this.qrd(var13, var1, var3, var4, var6)
            && (var14 < 0 || var13.refreshAt - var1 <= var6.waitMs + this.qre(var13, var3, var4))
            && var13.refreshAt + var6.minMineMs + this.goMs() + var6.leadMs <= var7.refreshAt
            && qrg(var13, var11)) {
            var11 = var13;
         }
      }

      if (var11 != null) {
         return new qqg(qqp.GO, var11.id, var11);
      } else {
         return var14 >= 0 && var1 + this.hopMs() + this.goMs() + var6.leadMs <= var7.refreshAt
            ? new qqg(qqp.SCAN, var14, null)
            : new qqg(qqp.GO, var7.id, var7);
      }
   }

   public long leaveAt(long var1, int var3, qwj var4, long var5, qqd var7) {
      long var8 = Long.MAX_VALUE;

      for (qqm var11 : this.qqu.values()) {
         if (var11.id != var3 && var11.tier != null && var7.tiers.contains(var11.tier) && !this.qrf(var11.id, var1) && var11.refreshAt - this.goMs() > var1) {
            boolean var12 = var4 == null || var11.tier.rank() > var4.rank() || var11.tier.rank() >= var4.rank() && var5 >= var7.minMineMs;
            if (var12) {
               var8 = Math.min(var8, var11.refreshAt - var7.leadMs - this.goMs());
            }
         }
      }

      return var8;
   }

   private int qrc(long var1, int var3) {
      int var4 = this.qqw.size();

      for (int var5 = 0; var5 < var4; var5++) {
         int var6 = this.qqw.get((this.qqx + var5) % var4);
         if (var6 != var3 && !this.qrf(var6, var1)) {
            qqm var7 = this.qqu.get(var6);
            if (var7 == null || var7.tier == null || var7.refreshAt <= var1) {
               return var6;
            }
         }
      }

      return -1;
   }

   private boolean qrd(qqm var1, long var2, int var4, long var5, qqd var7) {
      if (var1.tier == null || !var7.tiers.contains(var1.tier)) {
         return false;
      } else {
         return var1.id != var4 && this.qrf(var1.id, var2) ? false : var1.refreshAt - this.qre(var1, var4, var5) > var2;
      }
   }

   private long qre(qqm var1, int var2, long var3) {
      return var1.id == var2 ? var3 : this.goMs();
   }

   private boolean qrf(int var1, long var2) {
      Long var4 = this.qqv.get(var1);
      return var4 != null && var4 > var2;
   }

   private static boolean qrg(qqm var0, qqm var1) {
      if (var1 == null) {
         return true;
      } else {
         return var0.tier.rank() != var1.tier.rank() ? var0.tier.rank() > var1.tier.rank() : var0.refreshAt < var1.refreshAt;
      }
   }

   public static List<Integer> parseList(String var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == null) {
         return var1;
      }

      for (String var5 : var0.replaceAll(a.b("똝쾃䔉\udb09储\uf627䱳\ue5cb箕\uf10b皁", 154056266), a.c(-1576389634, "㏒")).split(a.b("氍ᗋ鼏ę諡౾뙛", 66481233))) {
         String var6 = var5.trim();
         if (!var6.isEmpty()) {
            try {
               int var7 = var6.indexOf(45, 1);
               if (var7 > 0) {
                  int var12 = Integer.parseInt(var6.substring(0, var7).trim());
                  int var9 = Integer.parseInt(var6.substring(var7 + 1).trim());

                  for (int var10 = Math.min(var12, var9); var10 <= Math.max(var12, var9) && var1.size() < 400; var10++) {
                     if (!var1.contains(var10)) {
                        var1.add(var10);
                     }
                  }
               } else {
                  int var8 = Integer.parseInt(var6);
                  if (!var1.contains(var8)) {
                     var1.add(var8);
                  }
               }
            } catch (NumberFormatException var11) {
            }
         }
      }

      return var1;
   }
}
