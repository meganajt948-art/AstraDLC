package a;

import flow.dev.a;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.util.InputUtil.Type;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;

public final class vzh {
   private static final int vzi = 20;
   private final Item vzj;
   private final vyn vzk;
   private vze vzl;
   private int vzm;
   private boolean vzn;
   private int vzo;
   private int vzp;
   private int vzq = -1;

   public vzh(Item var1) {
      this(var1, false);
   }

   public vzh(Item var1, boolean var2) {
      this.vzj = var1;
      this.vzk = new vyn(var2);
   }

   public boolean busy() {
      return this.vzl != null;
   }

   public void press(MinecraftClient var1, int var2, String var3, String var4) {
      if (this.vzl == null && !oxw.busy()) {
         if (vzz.mods(var2) != 0) {
            this.vzv(var1, vzz.baseKey(var2));
         }

         this.vzt(var1, var3, var4);
      }
   }

   private void vzt(MinecraftClient var1, String var2, String var3) {
      ClientPlayerEntity var4 = var1.player;
      if (var4 != null && var4.isAlive() && !var4.isSpectator() && var4.currentScreenHandler == var4.playerScreenHandler) {
         int var5 = this.vzy(var4);
         if (var5 < 0) {
            izx.alert(var2, var3, vhz.INFO, false);
         } else {
            PlayerInventory var6 = var4.getInventory();
            if (var4.getItemCooldownManager().isCoolingDown(var6.getStack(var5))) {
               izx.alert(var2, wap.s(a.d("㪲䌯짼垎\udc51嫫\ue0a0楈", -1287075951, 137035112), a.d("䜦㻎둥⨛ꇈ✊鴧", -1689195453, -1376211080)), vhz.CLOCK, false);
            } else if (KeyBindingHelper.getBoundKeyOf(var1.options.useKey).equals(InputUtil.UNKNOWN_KEY)) {
               izx.alert(
                  var2,
                  wap.s(a.d("쾋똁㳜ꊢ⥩꾌ᖜ鱢ȸ袃མ\uf562篼\ue257栙\ueea1咽\udb38䇉잕乸㐲몋", 557595628, 1464661026), a.b("樛ᎂ鵄ܨ賲\u0a44뀝㧡Ꟊⴊ\uaad1傭\uda6a䟤춲䭅", 1910402582)),
                  vhz.KEYBOARD,
                  false
               );
            } else {
               this.vzm = var5;
               this.vzn = var5 < 9;
               this.vzo = var6.getSelectedSlot();
               this.vzp = 0;
               if (this.vzn) {
                  this.vzl = vze.USE;
               } else if (this.vzx(var4)) {
                  wdq.swap(var1, this.vzm, this.vzo);
                  this.vzl = vze.USE;
               } else {
                  this.vzl = vze.PREPARE;
               }
            }
         }
      }
   }

   public void startTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null) {
         this.vzq = var2.getInventory().getSelectedSlot();
         if (this.vzl != null) {
            if (var2.isAlive() && var2.currentScreenHandler == var2.playerScreenHandler) {
               if (var1.currentScreen != null && this.vzl != vze.SWAP_BACK) {
                  if (this.vzl != vze.USE || this.vzn) {
                     this.reset(var1);
                     return;
                  }

                  this.vzl = vze.SWAP_BACK;
               }

               switch (this.vzl) {
                  case USE:
                     this.vzu(var1, var2);
                     break;
                  case RESTORE:
                     this.reset(var1);
                     break;
                  default:
                     this.vzw(var1, var2);
               }
            } else {
               this.reset(var1);
            }
         }
      }
   }

   public void endTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (this.vzl != null && var2 != null) {
         if (this.vzl == vze.PREPARE) {
            PlayerInventory var3 = var2.getInventory();
            if (!var3.getStack(this.vzm).isOf(this.vzj)) {
               this.reset(var1);
            } else if (this.vzx(var2)) {
               this.vzo = var3.getSelectedSlot();
               wdq.swap(var1, this.vzm, this.vzo);
               this.vzl = vze.USE;
            } else if (++this.vzp > 20) {
               this.reset(var1);
            }
         } else if (this.vzl == vze.SWAP_BACK) {
            if (wdq.canClick(var2) && this.vzk.idle(var2)) {
               wdq.swap(var1, this.vzm, this.vzo);
               this.reset(var1);
            } else if (++this.vzp > 20) {
               this.reset(var1);
            }
         }
      }
   }

   private void vzu(MinecraftClient var1, ClientPlayerEntity var2) {
      PlayerInventory var3 = var2.getInventory();
      if (!this.vzn) {
         this.vzw(var1, var2);
      } else if (var3.getSelectedSlot() != this.vzm) {
         var3.setSelectedSlot(this.vzm);
      }

      if (!var2.getMainHandStack().isOf(this.vzj)) {
         this.reset(var1);
      } else {
         if (var2.isUsingItem()) {
            var1.interactionManager.stopUsingItem(var2);
         }

         KeyBinding.onKeyPressed(KeyBindingHelper.getBoundKeyOf(var1.options.useKey));
         this.vzp = 0;
         this.vzl = this.vzn ? vze.RESTORE : vze.SWAP_BACK;
      }
   }

   public void reset(MinecraftClient var1) {
      this.vzk.release(var1);
      ClientPlayerEntity var2 = var1.player;
      if (this.vzl != null && this.vzn && var2 != null) {
         PlayerInventory var3 = var2.getInventory();
         if (var3.getSelectedSlot() == this.vzm && this.vzm != this.vzo) {
            var3.setSelectedSlot(this.vzo);
         }
      }

      this.vzl = null;
   }

   private void vzv(MinecraftClient var1, int var2) {
      PlayerInventory var3 = var1.player.getInventory();
      int var4 = var3.getSelectedSlot();
      if (this.vzq >= 0 && var4 != this.vzq && var4 < var1.options.hotbarKeys.length) {
         Key var5 = KeyBindingHelper.getBoundKeyOf(var1.options.hotbarKeys[var4]);
         if (var5.getCategory() == Type.KEYSYM && var5.getCode() == var2) {
            var3.setSelectedSlot(this.vzq);
         }
      }
   }

   private void vzw(MinecraftClient var1, ClientPlayerEntity var2) {
      this.vzk.hold(var1);
      if (var2.isUsingItem()) {
         var1.interactionManager.stopUsingItem(var2);
      }
   }

   private boolean vzx(ClientPlayerEntity var1) {
      return wdq.canClick(var1) && this.vzk.idle(var1) && !var1.isUsingItem();
   }

   private int vzy(ClientPlayerEntity var1) {
      PlayerInventory var2 = var1.getInventory();
      int var3 = var2.getSelectedSlot();
      if (var2.getStack(var3).isOf(this.vzj)) {
         return var3;
      }

      for (int var4 = 0; var4 < 36; var4++) {
         if (var2.getStack(var4).isOf(this.vzj)) {
            return var4;
         }
      }

      return -1;
   }
}
