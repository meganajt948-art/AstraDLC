package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class osq extends kfe {
   static osq osr;
   final vlq oss = this.add(new vlq(a.d("矰\u0e6f蒠", -808112537, 232151519), 82));
   final vlv ost = this.add(
      new vlv(a.b("놛젗䋒\udca2坢", -1335053871), a.b("궣퐿廥삁", -1850429965), a.c(917678284, "ꢜ턀寚얾"), a.c(1141941567, "ꕵ\udceb嘴졍"), a.c(-1297863666, "ⱈ嗕\udf1c䅶쪻"))
   );
   final vkl osu = this.add(new vkl(a.b("폳ꩪ₮뻊㔟돫৫耝ṗ铤ጿ\ue956", 296539058), true));
   final vmc osv = this.add(new vmc(a.b("渦឴鵲̃裕", 1703177840), 3.0, 1.0, 8.0, 1.0).suffix(a.c(-1379208413, "\uf309諣-鹖ᖉ")));
   final vkl osw = this.add(new vkl(a.c(-973303991, "輁\uf691籙\ue235槭\uef43"), true));
   static final int osx = 600;
   boolean osy;
   boolean osz;
   int ota = -1;
   int otb;

   public osq() {
      super(a.d("\u0019禃\uf35d洺\ue6ea恼\uda13叿춦䜆샂", -620719173, -1006398486), a.b("䓿㵲랼⧋ꈛ⓹黾ᜓ襁ε萩繇\uf085椿\ue322斐\udfd4倈쪭䳻았뽆ㇴꩫⱕꛅἽ酢உ", -139311951), kfa.PLAYER);
      osr = this;
   }

   public static boolean busy() {
      return osr != null && osr.osz;
   }

   @Override
   protected void onDisable() {
      this.osz = false;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      boolean var2 = var1.currentScreen instanceof HandledScreen && vxl.isStorage(var1.currentScreen);
      boolean var3 = var2 && this.oss.isBound() && vzz.isDown(var1, this.oss.get());
      if (var3 && !this.osy && !this.osz && !oqv.busy()) {
         this.ote(var1);
      }

      this.osy = var3;
      if (this.osz) {
         if (var1.currentScreen instanceof HandledScreen var4 && var4.getScreenHandler().syncId == this.ota) {
            ScreenHandler var9 = var4.getScreenHandler();
            List var6 = vxl.own(var9, var1.player.getInventory());

            for (int var7 = 0; var7 < this.osv.getInt() && this.osz; var7++) {
               if (this.otb > 600) {
                  this.otf(
                     wap.s(a.d("픉겄♊렽㏷땁༛蚭ᢡ鈗ᗟ\uefb1慦\uf8c2犐", -1688094631, 1760455948), a.d("噠⿎ꕣ㬐낽㙴豙֤鯳ᅈ銋泤\ue24c篾\uf1df眣쵯䊲\ud808幗\ud7a8귴", -2093576034, 800047817)),
                     false
                  );
                  return;
               }

               if (!var9.getCursorStack().isEmpty()) {
                  Slot var8 = oth(var6);
                  if (var8 == null) {
                     this.otf(
                        wap.s(
                           a.b("떧찳䛡\ud8c4升헪澴\ue600砖\uf2ba畸輁ƛ顥ሷ针⺓ꅞ㯠뷴㑀万삳季\udd00埌\uee2d怸醙粍\uf727", -240863768),
                           a.b("䀻㦘덏ⵋꛤ 騋\u17ef趯ݡ胇窷\uf468淐\ue7f4敧\udb49價칐䡸소믜㔐꺿⢰", -1293335551)
                        ),
                        false
                     );
                     return;
                  }

                  this.otg(var1, var9, var8);
               } else if ((!this.osu.get() || !this.oti(var1, var9, var6)) && !this.otj(var1, var9, var6)) {
                  this.otf(
                     wap.s(a.d("浻ᓶ鸸O讉ഹ", -385113214, -18100564), a.c(-773539703, "벚앷侧톩娀\udcb3暚\uef13焲ﮏ籞蘢ࣶ"))
                        + a.d("㫪䏌즈", 555218415, -246034650)
                        + this.otb
                        + wap.s(a.b("呛ⶩꝵ㤁닜㑥踮", -373140356), a.d("菋﹠璲\ueac0愕\ue7a0巿", 1421585566, 223686514)),
                     true
                  );
               }
            }
         } else {
            this.osz = false;
         }
      }
   }

   void ote(MinecraftClient var1) {
      HandledScreen var2 = (HandledScreen)var1.currentScreen;
      if (!var2.getScreenHandler().getCursorStack().isEmpty()) {
         if (this.osw.get()) {
            izx.alert(
               this.getName(),
               wap.s(
                  a.d("착떽㽯ꅊ⫉걤ᘺ龎Ƙ謴\u0cf6\uf68f砕\ue1eb殹\ued06圝\ud8d0䉮쑺䷎㞉뤽⋭\ua48e⹂鞣ᦶ荊ԃ躩瀶憎揁\ue589漹탩", 2049591230, -731345950),
                  a.d("쬳늞㡀Ꙇⷦꭜᄄ鳥ۙ谚்\uf1c9罦\ue6ad沉\uee6d倽\udf93䕕쌅䫺ア빦⇕ꏋ\u2d7b郒Ỻ萎ɞ覒眽ﴂ", -619097225, -385115068)
               ),
               vhz.INFO,
               false
            );
         }
      } else {
         this.osz = true;
         this.ota = var2.getScreenHandler().syncId;
         this.otb = 0;
      }
   }

   void otf(String var1, boolean var2) {
      this.osz = false;
      if (this.osw.get()) {
         izx.alert(this.getName(), var1, var2 ? vhz.CHECK : vhz.INFO, var2);
      }
   }

   void otg(MinecraftClient var1, ScreenHandler var2, Slot var3) {
      vxl.click(var1, var2, var3.id, 0, SlotActionType.PICKUP);
      this.otb++;
   }

   static Slot oth(List<Slot> var0) {
      for (Slot var2 : var0) {
         if (!var2.hasStack()) {
            return var2;
         }
      }

      return null;
   }

   boolean oti(MinecraftClient var1, ScreenHandler var2, List<Slot> var3) {
      for (int var4 = 0; var4 < var3.size(); var4++) {
         ItemStack var5 = ((Slot)var3.get(var4)).getStack();
         if (!var5.isEmpty() && var5.getCount() < var5.getMaxCount()) {
            for (int var6 = var3.size() - 1; var6 > var4; var6--) {
               ItemStack var7 = ((Slot)var3.get(var6)).getStack();
               if (!var7.isEmpty() && var7.getCount() < var7.getMaxCount() && ItemStack.areItemsAndComponentsEqual(var5, var7)) {
                  this.otg(var1, var2, (Slot)var3.get(var6));
                  this.otg(var1, var2, (Slot)var3.get(var4));
                  if (!var2.getCursorStack().isEmpty()) {
                     this.otg(var1, var2, (Slot)var3.get(var6));
                  }

                  return true;
               }
            }
         }
      }

      return false;
   }

   boolean otj(MinecraftClient var1, ScreenHandler var2, List<Slot> var3) {
      ArrayList var4 = new ArrayList();

      for (Slot var6 : var3) {
         if (var6.hasStack()) {
            var4.add(var6.getStack());
         }
      }

      var4.sort(this.otl());

      for (int var9 = 0; var9 < var3.size(); var9++) {
         ItemStack var10 = var9 < var4.size() ? (ItemStack)var4.get(var9) : ItemStack.EMPTY;
         ItemStack var7 = ((Slot)var3.get(var9)).getStack();
         if (!otk(var7, var10)) {
            if (var10.isEmpty()) {
               return false;
            }

            for (int var8 = var9 + 1; var8 < var3.size(); var8++) {
               if (otk(((Slot)var3.get(var8)).getStack(), var10)) {
                  this.otg(var1, var2, (Slot)var3.get(var8));
                  this.otg(var1, var2, (Slot)var3.get(var9));
                  if (!var2.getCursorStack().isEmpty()) {
                     this.otg(var1, var2, (Slot)var3.get(var8));
                  }

                  return true;
               }
            }

            return false;
         }
      }

      return false;
   }

   static boolean otk(ItemStack var0, ItemStack var1) {
      return !var0.isEmpty() && !var1.isEmpty()
         ? var0.getCount() == var1.getCount() && ItemStack.areItemsAndComponentsEqual(var0, var1)
         : var0.isEmpty() == var1.isEmpty();
   }

   Comparator<ItemStack> otl() {
      Comparator var1 = Comparator.comparing(var0 -> var0.getName().getString().toLowerCase(Locale.ROOT));
      Comparator var2 = Comparator.comparingInt(ItemStack::getCount).reversed();
      Comparator var3 = Comparator.comparingInt(var0 -> Registries.ITEM.getRawId(var0.getItem()));

            if (java.util.Objects.equals(this.ost.get(), a.b("듈쵖䞉\ud9f0", 3257474))) {
         return var1.thenComparing(var3).thenComparing(var2);
      }
      else if (java.util.Objects.equals(this.ost.get(), a.d("췫둶㺿ꃕ⬘", 1243335245, 327813088))) {
         return var2.thenComparing(var1);
      }
      else {
         return Comparator.comparingInt(osq::otm).thenComparing(var3).thenComparing(var1).thenComparing(var2);
      }
   }

   static int otm(ItemStack var0) {
      Item var1 = var0.getItem();
      String var2 = Registries.ITEM.getId(var1).getPath();
      if (var2.endsWith(a.b("ⁱ姬팻䵒욘䀿", 1796415528))
         || var2.endsWith(a.c(1408812133, "쐾붱㝻ꤗ"))
         || var1 == Items.MACE
         || var1 == Items.TRIDENT
         || var1 == Items.BOW
         || var1 == Items.CROSSBOW
         || var2.endsWith(a.b("兪⣷ꈧ㱃랐ㄲ", -700109))) {
         return 0;
      }

      if (!var2.endsWith(a.b("⻚坄\udd8e䏵젪云\uf4db紷", 1058877069))
         && !var2.endsWith(a.c(1211581585, "䓉㵔랜⧪ꈤ⒆黜"))
         && !var2.endsWith(a.d("\ue3a0騦ჲ躉", 1359669934, 59050325))
         && var1 != Items.SHEARS
         && var1 != Items.FISHING_ROD
         && var1 != Items.FLINT_AND_STEEL
         && var1 != Items.BRUSH) {
         EquippableComponent var3 = var0.get(DataComponentTypes.EQUIPPABLE);
         if ((var3 == null || var3.slot() == EquipmentSlot.MAINHAND || var3.slot() == EquipmentSlot.OFFHAND)
            && var1 != Items.SHIELD
            && var1 != Items.TOTEM_OF_UNDYING) {
            if (var0.contains(DataComponentTypes.FOOD)) {
               return 3;
            } else if (var0.contains(DataComponentTypes.POTION_CONTENTS)) {
               return 4;
            } else {
               return var1 instanceof BlockItem ? 5 : 6;
            }
         } else {
            return 2;
         }
      } else {
         return 1;
      }
   }
}
