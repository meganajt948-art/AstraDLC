package a;

import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public final class egq {
   static final egq egr = new egq();
   static final Pattern egs = Pattern.compile(a.d("爉\u0ba2脝Ἓ铷ሊꠎ↵뿷㕒닧䢔왥徜헐匼\ue974曮", -1684923850, -795318154));
   static final MinecraftClient egt = MinecraftClient.getInstance();
   static final long egu = 10000000L;
   static final long egv = 2500L;
   static final long egw = 20000L;
   final List<dtv> egx = new CopyOnWriteArrayList<>();
   final Random egy = new Random();
   final Set<dtv> egz = Collections.newSetFromMap(new IdentityHashMap<>());
   int eha = 4;
   boolean ehb;
   int ehc;
   volatile boolean ehd;
   long ehe;
   long ehf;

   egq() {
   }

   public static egq get() {
      return egr;
   }

   public List<dtv> getBots() {
      this.ehj();
      return this.egx;
   }

   public static boolean isValidName(String var0) {
      return var0 != null && egs.matcher(var0).matches();
   }

   public dtv find(String var1) {
      this.ehj();

      for (dtv var3 : this.egx) {
         if (var3.getName().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public dtv add(String var1, String var2) {
      if (isValidName(var1) && var2 != null && !var2.isBlank()) {
         dtv var3 = this.find(var1);
         if (var3 != null) {
            return var3;
         }

         dtv var4 = new dtv(var1, var2.trim());
         this.egx.add(var4);
         ejp.any = true;
         this.ehk();
         this.persist();
         var4.connect();
         return var4;
      } else {
         return null;
      }
   }

   public void remove(dtv var1) {
      if (var1 != null && this.egx.remove(var1)) {
         this.egz.remove(var1);
         var1.release();
         ejp.any = !this.egx.isEmpty();
         this.ehk();
         this.persist();
      }
   }

   static kfx ehi() {
      Flow var0 = Flow.getInstance();
      return var0 == null ? null : var0.getModuleManager();
   }

   void ehj() {
      if (!this.ehd && egt.isOnThread() && egt.runDirectory != null && ehi() != null) {
         this.ehd = true;
         ejz var1 = eke.load();
         if (var1.viewDistance() > 0) {
            this.eha = Math.max(2, Math.min(12, var1.viewDistance()));
         }

         for (ejs var3 : var1.bots()) {
            if (isValidName(var3.name()) && var3.address() != null && !var3.address().isBlank() && this.find(var3.name()) == null) {
               try {
                  dtv var4 = new dtv(var3.name(), var3.address().trim());
                  var4.restore(var3.password(), var3.autoReconnect());
                  this.egx.add(var4);
               } catch (Throwable var6) {
               }
            }
         }

         ejp.any = !this.egx.isEmpty();
         this.ehk();

         try {
            Runtime.getRuntime().addShutdownHook(new Thread(this::persist, a.d("⭇勜\ud80c䙥췷䭔\uf145碹\ue6fd汋", -1693162429, 1247956808)));
         } catch (Throwable var5) {
         }
      }
   }

   public void persist() {
      if (this.ehd) {
         eke.save(this.egx, this.eha);
      }
   }

   public int connectAll() {
      int var1 = 0;

      for (dtv var3 : this.egx) {
         if (var3.getStatus() == dts.OFFLINE || var3.getStatus() == dts.FAILED) {
            var3.connect();
            var1++;
         }
      }

      return var1;
   }

   void ehk() {
      long var1 = System.nanoTime();
      int var3 = this.egx.size();

      for (int var4 = 0; var4 < var3; var4++) {
         this.egx.get(var4).stagger(var1, var4, var3);
      }
   }

   boolean tryStartJoin(dtv var1) {
      long var2 = System.currentTimeMillis();
      if (var2 - this.ehe < 2500L) {
         return false;
      }

      for (dtv var5 : this.egx) {
         if (var5 != var1 && var5.isJoining() && var2 - var5.getStatusTime() < 20000L) {
            return false;
         }
      }

      this.ehe = var2;
      return true;
   }

   List<dtv> ehl() {
      ArrayList var1 = new ArrayList();

      for (dtv var3 : this.egx) {
         if (var3.getStatus() == dts.ONLINE && var3.getPlayer() != null) {
            var1.add(var3);
         }
      }

      Collections.shuffle(var1, this.egy);
      return var1;
   }

   public int broadcast(String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      if (var2.isEmpty()) {
         return 0;
      }

      List<dtv> var3 = this.ehl();
      long var4 = 0L;

      for (dtv var7 : var3) {
         var7.schedule(var4, () -> var7.sendChat(var2));
         var4 += 400L + this.egy.nextInt(900);
      }

      this.ehf = System.currentTimeMillis();
      this.egz.clear();
      this.egz.addAll(var3);
      return var3.size();
   }

   public long getLastBroadcast() {
      return this.ehf;
   }

   public boolean wasBroadcastTarget(dtv var1) {
      return this.egz.contains(var1);
   }

   public int setF0All(boolean var1) {
      List<dtv> var2 = this.ehl();
      long var3 = 0L;
      int var5 = 0;

      for (dtv var7 : var2) {
         if (var7.f0Run() != var1 || var7.f0Want() != var1) {
            var7.schedule(var3, () -> var7.setF0(var1));
            var3 += var1 ? 1500L + this.egy.nextInt(2500) : 150L + this.egy.nextInt(450);
            var5++;
         }
      }

      return var5;
   }

   public int setF1All(boolean var1) {
      List<dtv> var2 = this.ehl();
      long var3 = 0L;
      int var5 = 0;
      int var6 = 0;

      for (dtv var8 : var2) {
         if (var8.f1Run() != var1 || var8.f1Want() != var1) {
            if (var1) {
               var8.f1ref().setLootStart(var6++);
            }

            var8.schedule(var3, () -> var8.setF1(var1));
            var3 += var1 ? 1500L + this.egy.nextInt(2500) : 150L + this.egy.nextInt(450);
            var5++;
         }
      }

      return var5;
   }

   public int setF2All(boolean var1) {
      List<dtv> var2 = this.ehl();
      long var3 = 0L;
      int var5 = 0;

      for (dtv var7 : var2) {
         if (var7.f2Run() != var1 || var7.f2Want() != var1) {
            var7.schedule(var3, () -> var7.setF2(var1));
            var3 += var1 ? 1500L + this.egy.nextInt(2500) : 150L + this.egy.nextInt(450);
            var5++;
         }
      }

      return var5;
   }

   public int setF3All(boolean var1) {
      List<dtv> var2 = this.ehl();
      long var3 = 0L;
      int var5 = 0;

      for (dtv var7 : var2) {
         if ((var7.f3Run() != var1 || var7.f3Want() != var1) && (!var1 || !var7.f3ref().isLocked())) {
            var7.schedule(var3, () -> var7.setF3(var1));
            var3 += var1 ? 1500L + this.egy.nextInt(2500) : 150L + this.egy.nextInt(450);
            var5++;
         }
      }

      return var5;
   }

   public int stopAll() {
      int var1 = 0;
      long var2 = 0L;

      for (dtv var5 : this.egx) {
         if (var5.isActive() || var5.f0Want() || var5.f1Want() || var5.f2Want() || var5.f3Want()) {
            var5.schedule(var2, var5::stopAutomation);
            var2 += 150L + this.egy.nextInt(450);
            var1++;
         }
      }

      return var1;
   }

   public void resetFarmStats() {
      for (dtv var2 : this.egx) {
         var2.f0ref().resetFarmStats();
         var2.f1ref().resetFarmStats();
      }
   }

   public int getViewDistance() {
      return this.eha;
   }

   public void setViewDistance(int var1) {
      int var2 = Math.max(2, Math.min(12, var1));
      if (var2 != this.eha) {
         this.eha = var2;
         this.persist();
      }
   }

   public boolean isSolvingCaptcha() {
      kfx var1 = ehi();
      oqm var2 = var1 == null ? null : var1.get(oqm.class);
      return var2 == null || var2.solvesCaptcha();
   }

   public String suggestAddress() {
      ServerInfo var1 = egt.getCurrentServerEntry();
      if (var1 != null && var1.address != null && !var1.address.isBlank()) {
         return var1.address;
      } else {
         return this.egx.isEmpty() ? "" : this.egx.get(this.egx.size() - 1).getAddress();
      }
   }

   public static void onFrame() {
      egr.ehm();
   }

   void ehm() {
      this.ehj();
      dyh.awaitAll();
      if (!this.ehb && !this.egx.isEmpty() && !ejp.isActive()) {
         this.ehb = true;

         try {
            long var1 = System.nanoTime();
            int var3 = this.egx.size();
            int var4 = this.ehc++ % Math.max(1, var3);

            for (int var5 = 0; var5 < var3 && (var5 <= 0 || System.nanoTime() - var1 <= 10000000L); var5++) {
               try {
                  this.egx.get((var4 + var5) % var3).frame(var1);
               } catch (Throwable var10) {
               }
            }
         } finally {
            this.ehb = false;
         }
      }
   }
}
