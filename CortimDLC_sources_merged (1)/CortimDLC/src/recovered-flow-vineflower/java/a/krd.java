package a;

import flow.dev.a;
import java.util.Arrays;
import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;

public class krd extends kfe {
   static final int kre = 20;
   static final int krf = 8;
   static final int krg = 1;
   static final int krh = 10;
   static final float kri = 0.5F;
   static krd krj;
   final vmc krk = this.add(
      new vmc(a.d("\ueb64鋴ᡙ虖ඌ輮ㅪ뢘⛍갂⮯퇒彻웉", -638367651, 775726888), 6.0, 1.0, 20.0, 0.5).suffix(a.d("ꂸ\ud911", -845376223, 901526995))
   );
   final vkl krl = this.add(new vkl(a.d("絃Ӟ踄ၰ鯕ᴔꜾ⺶낛㨤릛䟵쥝備\udacb尲\ue674槒", 301850475, 1457169960), true));
   final vkl krm = this.add(new vkl(a.d("ગ猺理柢\uec42櫸킠嵁윀䶾쨗な뻇✀괭⿉釤ṉ蒆ʠ譞\uf178", 690779290, 194017850), true));
   final vkl krn = this.add(new vkl(a.b("Ł磘\uf61e汽\ue7a6攉\udb48勋쳡䙙쇹㿧딥ⲕꚹ", 751502675), false));
   final vkl kro = this.add(new vkl(a.b("륐샾䨬푞徂\udd26捪\uea91璻ﹿ禥菝൶钻Ỡ頔≖", 1464188258), true));
   final vyn krp = new vyn();
   final float[] krq = new float[20];
   ClientPlayerEntity krr;
   boolean krs;
   ItemStack krt = ItemStack.EMPTY;
   int kru = -1;
   boolean krv;
   int krw;
   int krx = 1;

   public krd() {
      super(a.b("䗱㱴뚦⣌ꌠ▪鿢ᘂ衕", -827374151), a.d("䋝㭂놑⿵ꐡ⋃飑ᅡ轪׀興硨\uf6b7潋\ue551控\ud9a6嘣첌䫐썢를㟆갗⩦ꂾᤂ静", 522260502, 1779389084), kfa.COMBAT);
      krj = this;
   }

   public static boolean busy() {
      return krj != null && krj.krv;
   }

   public static boolean needsTotem() {
      return krj != null && krj.isEnabled() && krj.krs;
   }

   @Override
   protected void onEnable() {
      this.krr = null;
      this.krs = false;
      this.ksl();
      this.krv = false;
      this.krw = 0;
      this.krx = 1;
   }

   @Override
   protected void onDisable() {
      this.ksk();
      this.krs = false;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != this.krr) {
         this.ksb(var2);
      }

      this.ksc(var2);
      if (this.krx < 1) {
         this.krx++;
      }

      if (!var2.isAlive() || var2.isSpectator() || var2.isCreative()) {
         this.ksk();
      } else if (this.krn.get() && ksf(var2)) {
         this.ksk();
      } else {
         Boolean var3 = this.kse(var2);
         if (var3 != null) {
            this.krs = var3;
         }

         int var4 = this.ksg(var2);
         if (var4 < 0 || this.krx < 1 || !ksm(var1, var2) || this.ksa()) {
            this.ksk();
         } else if (ksn(var2)) {
            this.ksj(var1, var2, var4);
         } else if (++this.krw > 8) {
            this.ksk();
            this.krx = -10;
         } else {
            this.krp.hold(var1);
            if (var2.isUsingItem()) {
               var1.interactionManager.stopUsingItem(var2);
            }

            this.krv = true;
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.krv) {
         ClientPlayerEntity var2 = var1.player;
         int var3 = this.ksg(var2);
         if (var3 >= 0 && ksm(var1, var2)) {
            if (ksn(var2) && !this.ksa()) {
               this.ksj(var1, var2, var3);
            }
         } else {
            this.ksk();
         }
      }
   }

   boolean ksa() {
      return !this.krs && (oxw.busy() || kvz.busy());
   }

   void ksb(ClientPlayerEntity var1) {
      boolean var2 = this.krr != null && this.krr.isAlive();
      this.krr = var1;
      Arrays.fill(this.krq, ksd(var1));
      if (!var2) {
         this.krs = false;
         this.ksl();
      }

      this.ksk();
      this.krx = 1;
   }

   void ksc(ClientPlayerEntity var1) {
      System.arraycopy(this.krq, 0, this.krq, 1, 19);
      this.krq[0] = ksd(var1);
   }

   static float ksd(ClientPlayerEntity var0) {
      float var1 = var0.hasStatusEffect(StatusEffects.ABSORPTION) ? var0.getAbsorptionAmount() : 0.0F;
      return var0.getHealth() + var1;
   }

   Boolean kse(ClientPlayerEntity var1) {
      if (var1.getItemCooldownManager().isCoolingDown(Items.TOTEM_OF_UNDYING.getDefaultStack())) {
         return Boolean.FALSE;
      }

      if (this.kro.get() && ksf(var1) && var1.getActiveItem().getMaxUseTime(var1) > 5) {
         int var2 = var1.getItemUseTimeLeft();
         if (var2 < 10) {
            return null;
         }

         float var3 = this.krq[19] - this.krq[0];
         if (var2 < 30 && var3 / 20.0F * var2 < this.krq[0]) {
            return null;
         }
      }

      float var4 = (float)this.krk.get();
      if (this.krq[0] <= var4) {
         return Boolean.TRUE;
      } else {
         return this.krq[0] >= var4 + 0.5F ? Boolean.FALSE : null;
      }
   }

   static boolean ksf(ClientPlayerEntity var0) {
      ItemStack var1 = var0.getActiveItem();
      return var0.isUsingItem() && !var1.isEmpty() && var1.get(DataComponentTypes.FOOD) != null;
   }

   int ksg(ClientPlayerEntity var1) {
      return this.krs ? this.ksh(var1) : this.ksi(var1);
   }

   int ksh(ClientPlayerEntity var1) {
      ItemStack var2 = var1.getOffHandStack();
      boolean var3 = this.krm.get();
      boolean var4 = var2.isOf(Items.TOTEM_OF_UNDYING);
      if (!var4 || var3 && var2.hasGlint()) {
         int var5 = var3 ? kso(var1, var0 -> var0.isOf(Items.TOTEM_OF_UNDYING) && !var0.hasGlint()) : -1;
         if (var5 < 0 && !var4) {
            var5 = kso(var1, var0 -> var0.isOf(Items.TOTEM_OF_UNDYING));
         }

         return var5;
      } else {
         return -1;
      }
   }

   int ksi(ClientPlayerEntity var1) {
      if (this.krt.isEmpty()) {
         return -1;
      }

      ItemStack var2 = var1.getOffHandStack();
      if (this.krl.get() && (var2.isEmpty() || var2.isOf(Items.TOTEM_OF_UNDYING))) {
         PlayerInventory var3 = var1.getInventory();
         if (this.kru >= 0 && ItemStack.areItemsAndComponentsEqual(var3.getStack(this.kru), this.krt)) {
            return this.kru;
         }

         int var4 = kso(var1, var1x -> ItemStack.areItemsAndComponentsEqual(var1x, this.krt));
         if (var4 < 0) {
            var4 = kso(var1, var1x -> var1x.isOf(this.krt.getItem()));
         }

         if (var4 < 0) {
            this.ksl();
         }

         return var4;
      } else {
         this.ksl();
         return -1;
      }
   }

   void ksj(MinecraftClient var1, ClientPlayerEntity var2, int var3) {
      ItemStack var4 = var2.getOffHandStack();
      if (!this.krs) {
         this.ksl();
      } else if (this.krl.get() && this.krt.isEmpty() && !var4.isEmpty() && !var4.isOf(Items.TOTEM_OF_UNDYING)) {
         this.krt = var4.copy();
         this.kru = var3;
      }

      ScreenHandler var5 = var2.currentScreenHandler;
      int var6 = wdq.slotId(var5, var2.getInventory(), var3);
      if (var6 >= 0) {
         var1.interactionManager.clickSlot(var5.syncId, var6, 40, SlotActionType.SWAP, var2);
         if (var5 == var2.playerScreenHandler) {
            wdq.close(var1);
         }
      }

      this.krx = 0;
      this.ksk();
   }

   void ksk() {
      if (this.krv || this.krp.isHeld()) {
         this.krp.release(this.mc);
      }

      this.krv = false;
      this.krw = 0;
   }

   void ksl() {
      this.krt = ItemStack.EMPTY;
      this.kru = -1;
   }

   static boolean ksm(MinecraftClient var0, ClientPlayerEntity var1) {
      ScreenHandler var2 = var1.currentScreenHandler;
      return var2 != null && var2.getCursorStack().isEmpty()
         ? var2 == var1.playerScreenHandler || var0.currentScreen instanceof HandledScreen var3 && var3.getScreenHandler() == var2
         : false;
   }

   static boolean ksn(ClientPlayerEntity var0) {
      return vyn.serverIdle(var0) && !var0.isUsingItem();
   }

   static int kso(ClientPlayerEntity var0, Predicate<ItemStack> var1) {
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
