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
   private static final int kre = 20;
   private static final int krf = 8;
   private static final int krg = 1;
   private static final int krh = 10;
   private static final float kri = 0.5F;
   private static krd krj;
   private final vmc krk = this.add(
      new vmc(a.d("\ueb64鋴ᡙ虖ඌ輮ㅪ뢘⛍갂⮯퇒彻웉", -638367651, 775726888), 6.0, 1.0, 20.0, 0.5).suffix(a.d("ꂸ\ud911", -845376223, 901526995))
   );
   private final vkl krl = this.add(new vkl(a.d("絃Ӟ踄ၰ鯕ᴔꜾ⺶낛㨤릛䟵쥝備\udacb尲\ue674槒", 301850475, 1457169960), true));
   private final vkl krm = this.add(new vkl(a.d("ગ猺理柢\uec42櫸킠嵁윀䶾쨗な뻇✀괭⿉釤ṉ蒆ʠ譞\uf178", 690779290, 194017850), true));
   private final vkl krn = this.add(new vkl(a.b("Ł磘\uf61e汽\ue7a6攉\udb48勋쳡䙙쇹㿧딥ⲕꚹ", 751502675), false));
   private final vkl kro = this.add(new vkl(a.b("륐샾䨬푞徂\udd26捪\uea91璻ﹿ禥菝൶钻Ỡ頔≖", 1464188258), true));
   private final vyn krp = new vyn();
   private final float[] krq = new float[20];
   private ClientPlayerEntity krr;
   private boolean krs;
   private ItemStack krt = ItemStack.field_8037;
   private int kru = -1;
   private boolean krv;
   private int krw;
   private int krx = 1;

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
      ClientPlayerEntity var2 = var1.field_1724;
      if (var2 != this.krr) {
         this.ksb(var2);
      }

      this.ksc(var2);
      if (this.krx < 1) {
         this.krx++;
      }

      if (!var2.method_5805() || var2.method_7325() || var2.method_68878()) {
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
            if (var2.method_6115()) {
               var1.field_1761.method_2897(var2);
            }

            this.krv = true;
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.krv) {
         ClientPlayerEntity var2 = var1.field_1724;
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

   private boolean ksa() {
      return !this.krs && (oxw.busy() || kvz.busy());
   }

   private void ksb(ClientPlayerEntity var1) {
      boolean var2 = this.krr != null && this.krr.method_5805();
      this.krr = var1;
      Arrays.fill(this.krq, ksd(var1));
      if (!var2) {
         this.krs = false;
         this.ksl();
      }

      this.ksk();
      this.krx = 1;
   }

   private void ksc(ClientPlayerEntity var1) {
      System.arraycopy(this.krq, 0, this.krq, 1, 19);
      this.krq[0] = ksd(var1);
   }

   private static float ksd(ClientPlayerEntity var0) {
      float var1 = var0.method_6059(StatusEffects.field_5898) ? var0.method_6067() : 0.0F;
      return var0.method_6032() + var1;
   }

   private Boolean kse(ClientPlayerEntity var1) {
      if (var1.method_7357().method_7904(Items.field_8288.method_7854())) {
         return Boolean.FALSE;
      } else {
         if (this.kro.get() && ksf(var1) && var1.method_6030().method_7935(var1) > 5) {
            int var2 = var1.method_6014();
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
   }

   private static boolean ksf(ClientPlayerEntity var0) {
      ItemStack var1 = var0.method_6030();
      return var0.method_6115() && !var1.method_7960() && var1.method_58694(DataComponentTypes.field_50075) != null;
   }

   private int ksg(ClientPlayerEntity var1) {
      return this.krs ? this.ksh(var1) : this.ksi(var1);
   }

   private int ksh(ClientPlayerEntity var1) {
      ItemStack var2 = var1.method_6079();
      boolean var3 = this.krm.get();
      boolean var4 = var2.method_31574(Items.field_8288);
      if (!var4 || var3 && var2.method_7958()) {
         int var5 = var3 ? kso(var1, var0 -> var0.method_31574(Items.field_8288) && !var0.method_7958()) : -1;
         if (var5 < 0 && !var4) {
            var5 = kso(var1, var0 -> var0.method_31574(Items.field_8288));
         }

         return var5;
      } else {
         return -1;
      }
   }

   private int ksi(ClientPlayerEntity var1) {
      if (this.krt.method_7960()) {
         return -1;
      } else {
         ItemStack var2 = var1.method_6079();
         if (this.krl.get() && (var2.method_7960() || var2.method_31574(Items.field_8288))) {
            PlayerInventory var3 = var1.method_31548();
            if (this.kru >= 0 && ItemStack.method_31577(var3.method_5438(this.kru), this.krt)) {
               return this.kru;
            } else {
               int var4 = kso(var1, var1x -> ItemStack.method_31577(var1x, this.krt));
               if (var4 < 0) {
                  var4 = kso(var1, var1x -> var1x.method_31574(this.krt.method_7909()));
               }

               if (var4 < 0) {
                  this.ksl();
               }

               return var4;
            }
         } else {
            this.ksl();
            return -1;
         }
      }
   }

   private void ksj(MinecraftClient var1, ClientPlayerEntity var2, int var3) {
      ItemStack var4 = var2.method_6079();
      if (!this.krs) {
         this.ksl();
      } else if (this.krl.get() && this.krt.method_7960() && !var4.method_7960() && !var4.method_31574(Items.field_8288)) {
         this.krt = var4.method_7972();
         this.kru = var3;
      }

      ScreenHandler var5 = var2.field_7512;
      int var6 = wdq.slotId(var5, var2.method_31548(), var3);
      if (var6 >= 0) {
         var1.field_1761.method_2906(var5.field_7763, var6, 40, SlotActionType.field_7791, var2);
         if (var5 == var2.field_7498) {
            wdq.close(var1);
         }
      }

      this.krx = 0;
      this.ksk();
   }

   private void ksk() {
      if (this.krv || this.krp.isHeld()) {
         this.krp.release(this.mc);
      }

      this.krv = false;
      this.krw = 0;
   }

   private void ksl() {
      this.krt = ItemStack.field_8037;
      this.kru = -1;
   }

   private static boolean ksm(MinecraftClient var0, ClientPlayerEntity var1) {
      ScreenHandler var2 = var1.field_7512;
      return var2 != null && var2.method_34255().method_7960()
         ? var2 == var1.field_7498 || var0.field_1755 instanceof HandledScreen var3 && var3.method_17577() == var2
         : false;
   }

   private static boolean ksn(ClientPlayerEntity var0) {
      return vyn.serverIdle(var0) && !var0.method_6115();
   }

   private static int kso(ClientPlayerEntity var0, Predicate<ItemStack> var1) {
      PlayerInventory var2 = var0.method_31548();
      int var3 = var2.method_67532();

      for (int var4 = 9; var4 < 36; var4++) {
         if (var1.test(var2.method_5438(var4))) {
            return var4;
         }
      }

      for (int var5 = 0; var5 < 9; var5++) {
         if (var5 != var3 && var1.test(var2.method_5438(var5))) {
            return var5;
         }
      }

      return var1.test(var2.method_5438(var3)) ? var3 : -1;
   }
}
