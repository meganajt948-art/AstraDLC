package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class kqh extends kfe implements ivw {
   static final int kqi = 3;
   static final int kqj = -1;
   final vlv kqk = this.add(new vlv(a.d("\uf5e0豥ګ飘", 99149815, 1287918165), a.c(796706570, "읟뻍㐆ꩺ↺ꜜ"), kpx.names()));
   final vlv kql = this.add(new vlv(a.d("ﮆ舌", 2122457743, -546121377), a.d("蝊ﻀ琈\uea68憷", 448561641, -129235214), kpx.names()));
   final vlq kqm = this.add(new vlq(a.c(-378499829, "赐\uf4c5縀\ue060毧\ued1d址\udead")));
   final vlq kqn = this.add(new vlq(a.b("\uf69f輑\u05cf鮾ၠ隝ⲅꕺ㬹", -213584191)));
   final vmu[] kqo = new vmu[3];
   static final int kqp = 10;
   final vyn kqq = new vyn();
   final EnumMap<kpx, ItemStack> kqr = new EnumMap<>(kpx.class);
   boolean kqs;
   int kqt = -1;
   int kqu;

   public kqh() {
      super(
         a.d("ﾡ蘤\u0cf6銜\u1977鿢▧걇", -1349459499, 910761533),
         a.d("嗅ⱝꚎ㣱댯㖑迈ٽ顱ዄ锁潡\ue1e6砖\uf24a璱캺䄪\udbd8嶚푳깦\u20c8묈㵿럣ง聉᪳鳢\u1758\ue9c5揅卑簨\uf6d8䥎썴䖩\udc04", -1380712368, 794646002),
         kfa.COMBAT
      );

      for (int var1 = 0; var1 < 3; var1++) {
         this.kqo[var1] = this.add(new vmu(a.b("辚\uf614糊\ue2bb楥\uef98喂\udc6e䈠좙伇", 214273990) + (var1 + 1), "", 160));
         this.kqo[var1].visibleWhen(() -> false);
      }
   }

   @Override
   public void onConfigLoaded(boolean var1) {
      if (!var1 && this.getKey() != -1 && !this.kqm.isBound()) {
         this.kqm.set(this.getKey());
         this.setKey(-1);
         this.setEnabled(true);
      }
   }

   @Override
   protected void onEnable() {
      this.kqs = false;
   }

   @Override
   protected void onDisable() {
      this.kqs = false;
      this.kqq.release(this.mc);
   }

   @Override
   public boolean keysAtStart() {
      return true;
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var1.player != null) {
         if (var2 == this.kqn.get()) {
            if (var1.currentScreen == null) {
               var1.setScreen(new iwf(this, var2));
            }
         } else {
            if (var2 == this.kqm.get()) {
               this.kqt = -1;
               this.kqs = true;
               this.kqu = 0;
               if (kqx(var1.player) && !oxw.busy() && !kvz.busy()) {
                  this.kqz(var1);
               }
            }
         }
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.kqs) {
         ClientPlayerEntity var2 = var1.player;
         if (++this.kqu > 10) {
            this.kqy(var1);
         } else if (wdq.canClick(var2) && !oxw.busy() && !kvz.busy()) {
            if (kqx(var2)) {
               this.kqz(var1);
            } else {
               this.kqq.hold(var1);
               if (var2.isUsingItem()) {
                  var1.interactionManager.stopUsingItem(var2);
               }
            }
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.kqs && kqx(var1.player) && !oxw.busy() && !kvz.busy()) {
         this.kqz(var1);
      }
   }

   @Override
   public String title() {
      return wap.s(a.d("熈ࠝ苘Ჸ", 910397369, 256966246), a.c(-2043203714, "⭛勹\ud828䙖"));
   }

   @Override
   public boolean editable() {
      return true;
   }

   @Override
   public List<ivx> slots() {
      ArrayList var1 = new ArrayList(3);
      ClientPlayerEntity var2 = this.mc.player;

      for (int var3 = 0; var3 < 3; var3++) {
         kqa var4 = kqa.parse(this.kqo[var3].get());
         if (var4 != null && var2 != null) {
            ItemStack var5 = var2.getOffHandStack();
            boolean var6 = var4.matches(var5);
            int var7 = var6 ? -1 : krc(var2, var4::matches);
            ItemStack var8 = var6 ? var5 : (var7 >= 0 ? var2.getInventory().getStack(var7) : ItemStack.EMPTY);
            ItemStack var9 = var8.isEmpty() ? new ItemStack(var4.item()) : var8;
            String var10 = !var8.isEmpty() ? var8.getName().getString() : (var4.name().isEmpty() ? var9.getName().getString() : var4.name());
            String var11 = var6
               ? wap.s(a.b("샜률㎺귃", -1551187792), a.d("⭔囷\ud844䘶춘䬦", 1607784061, 1379465501))
               : (var8.isEmpty() ? wap.s(a.c(834091486, "㦴䀄쫖咬"), a.b("⌡媘퀼", 800401183)) : "");
            var1.add(new ivx(var9, var10, var11, 0.0F, !var8.isEmpty() && !var6));
         } else {
            var1.add(new ivx(ItemStack.EMPTY, "", "", 0.0F, false));
         }
      }

      return var1;
   }

   @Override
   public void pick(int var1) {
      if (this.isEnabled() && var1 >= 0 && var1 < 3 && kqa.parse(this.kqo[var1].get()) != null) {
         this.kqt = var1;
         this.kqs = true;
         this.kqu = 0;
      }
   }

   @Override
   public void assign(int var1, ItemStack var2) {
      if (var1 >= 0 && var1 < 3) {
         this.kqo[var1].set(var2.isEmpty() ? "" : kqa.of(var2).text());
      }
   }

   static boolean kqx(ClientPlayerEntity var0) {
      return wdq.canClick(var0) && vyn.serverIdle(var0) && !var0.isUsingItem();
   }

   void kqy(MinecraftClient var1) {
      this.kqs = false;
      this.kqq.release(var1);
   }

   void kqz(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      ItemStack var3 = var2.getOffHandStack();
      int var4;
      boolean var5;
      if (this.kqt == -1) {
         kpx var6 = kpx.of(this.kqk);
         kpx var7 = kpx.of(this.kql);
         boolean var8 = var7.matches(var3) || var7.isTotem() && var3.isOf(Items.TOTEM_OF_UNDYING) && !var6.matches(var3);
         kpx var9 = var8 ? var6 : var7;
         var5 = var9.isTotem();
         var4 = !var5 && kra(var3) ? -1 : this.krb(var2, var9, var3);
      } else {
         kqa var10 = kqa.parse(this.kqo[this.kqt].get());
         if (var10 == null || var10.matches(var3)) {
            this.kqy(var1);
            return;
         }

         var5 = var10.item() == Items.TOTEM_OF_UNDYING;
         var4 = !var5 && kra(var3) ? -1 : krc(var2, var10::matches);
         if (var4 < 0 && (var5 || !kra(var3))) {
            izx.alert(
               this.getName(),
               wap.s(a.c(-1263940819, "쭷닧㠯ꘊⶔꬢᄿ颚ۙ豥௳\uf1cb缛\ue6b2泲\uea08偝\udf97䔹썣"), a.c(-99105583, "샃륚㏾ꧭ☨ꒋᫀ錴\u0d64蟒\t輻璢\ued63杅")),
               vhz.INFO,
               false
            );
         }
      }

      if (!var5 && kra(var3)) {
         izx.alert(
            this.getName(),
            wap.s(a.c(982624727, "ꦏ퀊嫘쒲佞짔玜塚搫\ueed7楏錰ᷧ葃ณ袱㊪뵧⟙ꇍ⡮判\udc8c䝌섻"), a.b("♳忶픤䭎삢䘨ﱠ疀\uebd7愫\ue2ecᢜ阾\u0ff9薤̯봂㚱걾⩓ꏓ\ud98b", -1350818268)),
            vhz.INFO,
            false
         );
      } else if (var4 >= 0) {
         for (kpx var14 : kpx.values()) {
            if (var14.matches(var3)) {
               this.kqr.put(var14, var3.copy());
            }
         }

         wdq.swap(var1, var4, 40);
      }

      this.kqy(var1);
   }

   static boolean kra(ItemStack var0) {
      return krd.needsTotem() && var0.isOf(Items.TOTEM_OF_UNDYING);
   }

   int krb(ClientPlayerEntity var1, kpx var2, ItemStack var3) {
      Predicate<ItemStack> var4 = var1x -> !ItemStack.areItemsAndComponentsEqual(var1x, var3);
      ItemStack var5 = this.kqr.getOrDefault(var2, ItemStack.EMPTY);
      if (!var5.isEmpty() && var4.test(var5)) {
         int var6 = krc(var1, var1x -> ItemStack.areItemsAndComponentsEqual(var1x, var5));
         if (var6 >= 0) {
            return var6;
         }
      }

      int var7 = krc(var1, var2x -> var2.matches(var2x) && var4.test(var2x));
      if (var7 < 0 && var2.isTotem()) {
         var7 = krc(var1, var1x -> var1x.isOf(Items.TOTEM_OF_UNDYING) && var4.test(var1x));
      }

      return var7;
   }

   static int krc(ClientPlayerEntity var0, Predicate<ItemStack> var1) {
      PlayerInventory var2 = var0.getInventory();
      int var3 = var2.getSelectedSlot();

      for (int var4 = 9; var4 < 36; var4++) {
         if (var1.test(var2.getStack(var4))) {
            return var4;
         }
      }

      for (int var5 = 0; var5 < 9; var5++) {
         if (var5 != var3 && var1.test(var2.getStack(var5))) {
            return var5;
         }
      }

      return var1.test(var2.getStack(var3)) ? var3 : -1;
   }
}
