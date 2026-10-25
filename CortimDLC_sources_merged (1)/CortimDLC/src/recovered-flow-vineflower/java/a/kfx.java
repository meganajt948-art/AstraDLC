package a;

import it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;

public class kfx {
   final List<kfe> kfy = new ArrayList<>();
   final Int2BooleanOpenHashMap kfz = new Int2BooleanOpenHashMap();
   final IntLinkedOpenHashSet kga = new IntLinkedOpenHashSet();
   final IntLinkedOpenHashSet kgb = new IntLinkedOpenHashSet();
   final IntOpenHashSet kgc = new IntOpenHashSet();
   static boolean kgd;
   final rds kge = new rds();

   public kfx() {
      this.kgh(this.kge);
      this.kgh(new lwx());
      this.kgh(new lgc());
      this.kgh(new kmy());
      this.kgh(new kgj());
      this.kgh(new lfa());
      this.kgh(new kqh());
      this.kgh(new krd());
      this.kgh(new lfu());
      this.kgh(new lxp());
      this.kgh(new lwh());
      this.kgh(new lwq());
      this.kgh(new rkh());
      this.kgh(new rjy());
      this.kgh(new rfl());
      this.kgh(new ruv());
      this.kgh(new rnk());
      this.kgh(new qyk());
      this.kgh(new rby());
      this.kgh(new rae());
      this.kgh(new rky());
      this.kgh(new rhs());
      this.kgh(new rwo());
      this.kgh(new rqv());
      this.kgh(new rfy());
      this.kgh(new shx());
      this.kgh(new rrx());
      this.kgh(new rxa());
      this.kgh(new rug());
      this.kgh(new rpt());
      this.kgh(new rfa());
      this.kgh(new reo());
      this.kgh(new rdd());
      this.kgh(new rqf());
      this.kgh(new sbp());
      this.kgh(new rxv());
      this.kgh(new riv());
      this.kgh(new rmk());
      this.kgh(new rfp());
      this.kgh(new qxi());
      this.kgh(new sjl());
      this.kgh(new qze());
      this.kgh(new pbz());
      this.kgh(new ovh());
      this.kgh(new nuo());
      this.kgh(new nfl());
      this.kgh(new lvp());
      this.kgh(new lqq());
      this.kgh(new our());
      this.kgh(new mjr());
      this.kgh(new ouc());
      this.kgh(new owo());
      this.kgh(new pbe());
      this.kgh(new osq());
      this.kgh(new oqv());
      this.kgh(new otn());
      this.kgh(new mix());
      this.kgh(new mkl());
      this.kgh(new nmg());
      this.kgh(new mgl());
      this.kgh(new mpq());
      nxa var1 = new nxa();
      var1.registerAsMain();
      this.kgh(var1);
      this.kgh(new rzy());
      this.kgh(new oqm());
      this.kgh(new kvz());
      this.kgh(new lsg());
      this.kgh(new lre());
      this.kgh(new lsx());
      this.kgh(new lub());
      this.kgh(new oxw());
   }

   void kgh(kfe var1) {
      this.kfy.add(var1);
   }

   public List<kfe> getModules() {
      return this.kfy;
   }

   public List<kfe> getByCategory(kfa var1) {
      ArrayList var2 = new ArrayList();

      for (kfe var4 : this.kfy) {
         if (var4.getCategory() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public <T extends kfe> T get(Class<T> var1) {
      for (kfe var3 : this.kfy) {
         if (var1.isInstance(var3)) {
            return (T)var1.cast(var3);
         }
      }

      return null;
   }

   public kfe getByName(String var1) {
      for (kfe var3 : this.kfy) {
         if (var3.getName().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public void onStartTick(MinecraftClient var1) {
      for (kfe var3 : this.kfy) {
         if (var3.isEnabled() || var3.ticksWhenOff()) {
            var3.onStartTick(var1);
         }
      }
   }

   public void onEndTick(MinecraftClient var1) {
      for (kfe var3 : this.kfy) {
         if ((var3.isEnabled() || var3.ticksWhenOff()) && var3 != this.kge) {
            var3.onEndTick(var1);
         }
      }

      if (this.kge.isEnabled()) {
         this.kge.onEndTick(var1);
      }
   }

   public void onWorldRender(MinecraftClient var1) {
      for (kfe var3 : this.kfy) {
         if (var3.isEnabled()) {
            var3.onWorldRender(var1);
         }
      }

      for (kfe var6 : this.kfy) {
         if (var6.isEnabled()) {
            var6.onWorldRenderLate(var1);
         }
      }

      for (kfe var7 : this.kfy) {
         if (var7.isEnabled()) {
            var7.onWorldRenderFinal(var1);
         }
      }
   }

   public void pollKeys(MinecraftClient var1) {
      if (var1.getWindow() != null) {
         IntLinkedOpenHashSet var2 = this.kgb;
         var2.clear();

         for (kfe var4 : this.kfy) {
            var2.add(var4.getKey());
            if (var4.isEnabled()) {
               for (vmo var6 : var4.getSettings()) {
                  if (var6 instanceof vlq var7) {
                     var2.add(var7.get());
                  }
               }
            }
         }

         for (hzq var10 : hzv.ALL) {
            var2.add(var10.key());
         }

         var2.remove(-1);
         IntListIterator var9 = var2.iterator();

         while (var9.hasNext()) {
            int var11 = var9.nextInt();
            boolean var12 = vzz.isDown(var1, var11);
            boolean var13 = this.kfz.put(var11, var12);
            if (var12 && !var13) {
               this.kga.add(var11);
            }
         }
      }
   }

   public void onKeys(MinecraftClient var1) {
      this.pollKeys(var1);
      IntListIterator var2 = this.kga.iterator();

      while (var2.hasNext()) {
         int var3 = var2.nextInt();

         for (kfe var5 : this.kfy) {
            if (var5.getKey() == var3) {
               var5.toggle();
            }
         }

         boolean var7 = this.kgc.contains(var3);

         for (kfe var6 : this.kfy) {
            if (var6.isEnabled() && kgi(var6, var3) && (!var7 || !var6.keysAtStart())) {
               var6.onKey(var1, var3);
            }
         }

         hzv.run(var3);
      }

      this.kga.clear();
      this.kgc.clear();
   }

   public void onStartKeys(MinecraftClient var1) {
      this.pollKeys(var1);
      if (!this.kga.isEmpty()) {
         kgd = true;

         try {
            IntListIterator var2 = this.kga.iterator();

            while (var2.hasNext()) {
               int var3 = var2.nextInt();
               if (!this.kgc.contains(var3)) {
                  for (kfe var5 : this.kfy) {
                     if (var5.keysAtStart() && var5.isEnabled() && kgi(var5, var3)) {
                        this.kgc.add(var3);
                        var5.onKey(var1, var3);
                     }
                  }
               }
            }
         } finally {
            kgd = false;
         }
      }
   }

   public static boolean startPhase() {
      return kgd;
   }

   static boolean kgi(kfe var0, int var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3 instanceof vlq var4 && var4.get() == var1) {
            return true;
         }
      }

      return false;
   }

   public void dropKeys() {
      this.kga.clear();
      this.kgc.clear();
   }

   static {
      wap.get();
   }
}
