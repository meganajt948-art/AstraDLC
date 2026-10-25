package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

final class fjf extends GenericContainerScreenHandler {
   final String fjg;
   final List<List<fjo>> fjh;
   final SimpleInventory fji;
   int fjj;

   fjf(int var1, PlayerInventory var2, String var3, List<List<fjo>> var4) {
      this(var1, var2, var3, var4, new SimpleInventory(54));
   }

   fjf(int var1, PlayerInventory var2, String var3, List<List<fjo>> var4, SimpleInventory var5) {
      super(ScreenHandlerType.GENERIC_9X6, var1, var2, var5, 6);
      this.fjg = var3;
      this.fjh = var4;
      this.fji = var5;
      this.fjm();
   }

   void fjm() {
      this.fji.clear();
      if (!this.fjh.isEmpty()) {
         List var1 = this.fjh.get(this.fjj);

         for (int var2 = 0; var2 < var1.size(); var2++) {
            this.fji.setStack(var2 * 3 + this.fjj, fjv.fki((fjo)var1.get(var2)));
         }

         this.fji.setStack(45, fjv.fkj(Items.ARROW, a.d("鏫\ueaca悅ﹿ熗\uf779䵟쒯媏큁埥궞⌰뫾㓂뙒ఞ菍ᤎ齒ᚠ沏\ue24a", -1732219910, 777517217)));
         this.fji
            .setStack(
               49,
               fjv.fkj(
                  Items.PAPER,
                  a.d("㴛䑫쫿哭\udf38姹\ue3a7橓\uf472纵ﵶ", -862183026, -1517937607) + (this.fjj + 1) + a.d("\u09c6灸瘝", 1044836107, -810031378) + this.fjh.size()
               )
            );
         this.fji.setStack(53, fjv.fkj(Items.ARROW, a.c(607215252, "帥✄꧁㞪뱳㫃胧छ靃ᶋ騧搹\uee8f眽ﵬ篭솯乻풶劑\udf76ꖼ")));
      }
   }

   @Override
   public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
      fjv.fjz++;
      if (slotIndex == 53 && this.fjj + 1 < this.fjh.size()) {
         this.fjj++;
         this.fjm();
      } else if (slotIndex == 45 && this.fjj > 0) {
         this.fjj--;
         this.fjm();
      } else if (slotIndex >= 0 && slotIndex < 45 && !this.fjh.isEmpty()) {
         int var5 = (slotIndex - this.fjj) / 3;
         List var6 = this.fjh.get(this.fjj);
         if ((slotIndex - this.fjj) % 3 == 0 && var5 >= 0 && var5 < var6.size()) {
            this.fjn((ServerPlayerEntity)player, (fjo)var6.get(var5));
            return;
         }
      }

      this.sendContentUpdates();
      this.syncState();
   }

   void fjn(ServerPlayerEntity var1, fjo var2) {
      SimpleInventory var3 = new SimpleInventory(27);
      var3.setStack(13, fjv.fki(var2));
      var3.setStack(11, fjv.fkj(Items.LIME_STAINED_GLASS_PANE, a.d("죁놶㭟ꅯ⻛갬ᙸ鿳Ƣ輂", 2046862314, -97686650)));
      var3.setStack(15, fjv.fkj(Items.RED_STAINED_GLASS_PANE, a.b("㱒䔧쿌嗸\ude73墼\ue2e6欟\uf54d箑", 544619775)));
      var1.openHandledScreen(
         new SimpleNamedScreenHandlerFactory((var4, var5, var6) -> new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X3, var4, var5, var3, 3) {
            @Override
            public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
               fjv.fjz++;
               if (slotIndex == 11) {
                  for (List var6x : fjf.this.fjh) {
                     if (var6x.contains(var2)) {
                        int var7 = fjf.this.fjh.indexOf(var6x);
                        ArrayList var8 = new ArrayList(var6x);
                        var8.remove(var2);
                        fjf.this.fjh.set(var7, var8);
                     }
                  }

                  fjv.fjy.add(Registries.ITEM.getId(var2.item()).getPath() + a.b("㰱䗘", -832685037) + var2.count() + a.c(432510120, "钊\ued5b") + var2.price());
                  var1.getInventory().insertStack(new ItemStack(var2.item(), var2.count()));
                  var1.sendMessage(Text.literal(a.b("ꖮ\udcd9剹챑䏭섿筮\uf2e1沴\ue678懞鮬ᅥ賎ۤ聩㨡뗳⽃괊⃢嫌퐊俚즭䍵缾", 1431872786)));
                  fjv.fkh(var1, fjf.this.fjg, fjf.this.fjh);
               } else if (slotIndex == 15) {
                  var1.closeHandledScreen();
               } else {
                  this.sendContentUpdates();
                  this.syncState();
               }
            }

            @Override
            public ItemStack quickMove(PlayerEntity player, int slot) {
               return ItemStack.EMPTY;
            }
         }, Text.literal(a.d("\ufaeb荻ঢ鞥ᰂ骴ₒꤕ㝈뷸㨣쁗亍팩嵥\udb95懞\uee76璹\uf2ed笘", 2113702081, 469595680)))
      );
   }

   @Override
   public ItemStack quickMove(PlayerEntity player, int slot) {
      return ItemStack.EMPTY;
   }
}
