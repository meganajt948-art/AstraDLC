package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

public class mjr extends kfe {
   private static final EquipmentSlot[] mjs = new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.HEAD, EquipmentSlot.FEET};
   private static final int mjt = 6;
   private final vmc mju = this.add(new vmc(a.b("㮗䈂죇嚧\udd20寓\ue187桿\uf623粊\ufb0eĻ追ᙋ鰋\u1af9ꂽ⽩뗟㎓멩", -1943454767), 2.0, 1.0, 100.0, 1.0));
   private final vkl mjv = this.add(new vkl(a.c(318390738, "䆘㠝닓ⲠꜺ⇉鮍ቧ谲ڋ腑笶"), true));
   private final vkl mjw = this.add(new vkl(a.d("䅞㣁눒ⱶ\ua7f1℅魟ኻ賩ٞ膞", -121238918, -430027932), true));
   private final vyn mjx = new vyn();
   private boolean mjy;
   private boolean mjz;
   private int mka;
   private int mkb;

   public mjr() {
      super(
         a.c(-84008016, "⏸婽킯仅씼䎾鱗瀁\uee43"),
         a.c(
            962174746,
            "鼜\ue688汚\uf22c禨ｖ䔄첻努\ud810忒ꖿ⭥닃㢋빧й训ᅑ霝Ẹ播\uea13燊\uf7b9絪쓘䪃퀰嘠\udd80⍎꤃ヨ뚼㱟菉ভ輪ᛔ鲊\ue276栣\uefdb甀ﬢ䋵졒丌헞対ꅮ⢘꺋㑨먮ƕ蝎ി铩ᩗ恁\ue7e2涪\uf369竞삋䘿찮厖\ud958彻ꛥⰕ눔㧲뾰Ԑ賋ኡ项ḩ旞\ueb40然\uf8ec"
         ),
         kfa.PLAYER
      );
   }

   @Override
   protected void onDisable() {
      if (this.mjy) {
         this.mjx.release(this.mc);
         this.mjy = false;
      }

      this.mjz = false;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.mjz && !this.mjy && var1.player != null) {
         this.mjx.hold(var1);
         this.mjy = true;
         this.mka = 0;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null) {
         if (this.mkb > 0) {
            this.mkb--;
         }

         boolean var3 = this.mkb == 0 && this.mkf(var1, var2) && this.mkh(var2);
         if (!var3) {
            this.mjz = false;
            this.mke();
         } else if (!vyn.serverIdle(var2) && !mkg(var1, var2)) {
            this.mjz = true;
            if (this.mjy && ++this.mka > 6) {
               this.mke();
               this.mjz = false;
               this.mkb = 10;
            }
         } else {
            this.mki(var1, var2);
            this.mjz = false;
            this.mke();
            this.mkb = 2;
         }
      }
   }

   private void mke() {
      if (this.mjy) {
         this.mjx.release(this.mc);
         this.mjy = false;
      }
   }

   private boolean mkf(MinecraftClient var1, ClientPlayerEntity var2) {
      if (!var2.isAlive() || var2.isSpectator() || !wdq.canClick(var2)) {
         return false;
      } else {
         return var1.currentScreen != null && !mkg(var1, var2) ? false : !oxw.busy() && !kvz.busy() && !var2.isUsingItem();
      }
   }

   private static boolean mkg(MinecraftClient var0, ClientPlayerEntity var1) {
      return var0.currentScreen instanceof HandledScreen var2 && var2.getScreenHandler() == var1.playerScreenHandler;
   }

   private boolean mkh(ClientPlayerEntity var1) {
      for (EquipmentSlot var5 : mjs) {
         if (this.mkj(var1, var5) != null) {
            return true;
         }
      }

      return false;
   }

   private void mki(MinecraftClient var1, ClientPlayerEntity var2) {
      for (EquipmentSlot var6 : mjs) {
         vuc var7 = this.mkj(var2, var6);
         if (var7 != null && !vui.equip(var1, var6, var7)) {
            return;
         }
      }
   }

   private vuc mkj(ClientPlayerEntity var1, EquipmentSlot var2) {
      ItemStack var3 = var1.getEquippedStack(var2);
      if (var2 == EquipmentSlot.CHEST && this.mjw.get() && var3.isOf(Items.ELYTRA)) {
         return null;
      }

      int var4 = this.mju.getInt();
      boolean var5 = var3.isEmpty();
      boolean var6 = !var5 && var3.isDamageable() && vui.left(var3) <= var4;
      if (!var5 && !var6) {
         return null;
      }

      int var7 = var5 ? 0 : vui.left(var3);
      PlayerInventory var8 = var1.getInventory();
      vuc var9 = vui.best(var8, this.mjv.get(), var4x -> {
         if (vui.wornIn(var4x) == var2 && mkk(var4x) != 0) {
            int var5x = vui.left(var4x);
            return var5x > var4 && (var5 || var5x > var7) ? mkk(var4x) * 100000 + Math.min(99999, var5x) : 0;
         } else {
            return 0;
         }
      });
      return var9 != null && vui.roomFor(var8, var9, var3) ? var9 : null;
   }

   private static int mkk(ItemStack var0) {
      String var1 = Registries.ITEM.getId(var0.getItem()).getPath();
      if (var1.startsWith(a.c(1739830118, "댂쪸䁺\ude17嗍퍫椣\ue0cf纁\uf40a"))) {
         return 2;
      } else {
         return var1.startsWith(a.c(-1583474427, "ᥩ惕\uea0e瑳ﾦ礖썏䪅")) ? 1 : 0;
      }
   }
}
