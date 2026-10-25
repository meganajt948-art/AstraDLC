package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public class nuo extends kfe {
   private static final int nup = -1;
   private static final int nuq = -2;
   private static final int nur = -3;
   private static final int nus = 20;
   private static final int nut = 20;
   private static final int nuu = 10;
   private static final float nuv = 0.01F;
   private static final float nuw = 0.3F;
   private final vkl nux = this.add(new vkl(a.c(-590709628, "碐Ď迊ᖣ鹱ᣏꊛ⭢땂㾁렢䉜"), true));
   private final vkl nuy = this.add(new vkl(a.c(-1150386401, "笇ʚ血ᘴ鶑᭐ꅺ⣲뛟㱠"), true));
   private final vmc nuz = this.add(
      new vmc(a.c(1100149864, "\uf06e觸̯鵟\u16fd逺⩥ꎞ㧑띲キ쫕䐇\uddc4埧텤歙"), 4.0, 0.0, 20.0, 1.0).suffix(a.c(-844885942, "ျ榗\ue34e紷\uf6f8"))
   );
   private final vkl nva = this.add(new vkl(a.c(-957963011, "ꃼ\ud969叏췋䙮샔绫\uf305津\ue7ea恀驋ᒟ赑܁臾"), true));
   private static nuo nvb;
   private final vyn nvc = new vyn();
   private ClientPlayerEntity nvd;
   private int nve = -1;
   private int nvf = -1;
   private int nvg = -1;
   private ItemStack nvh = ItemStack.EMPTY;
   private boolean nvi;
   private int nvj;
   private int nvk = -1;
   private boolean nvl;
   private boolean nvm;
   private int nvn;
   private int nvo;

   public nuo() {
      super(
         a.c(1240864642, "់湎\ue49c競\uf11a瞐췃䐱"),
         a.d("\u31e8䡬습峊휋凩\uebee戃ﱑ皥\uf134ୂ薃ᰵ防႗\uaac3┒뾢㦿뀟쩑䓣\udf37奁폕樿\ue478纕\uf891獯趺߲鸈", 1944634096, -1230441618),
         kfa.PLAYER
      );
      this.nuz.activeWhen(this.nuy::get);
      nvb = this;
   }

   public static boolean busy() {
      return nvb != null && nvb.isEnabled() && nvb.nve >= 0;
   }

   @Override
   protected void onEnable() {
      this.nvd = null;
      this.nwd();
      this.nvo = 0;
   }

   @Override
   protected void onDisable() {
      this.nwc();
      ClientPlayerEntity var1 = this.mc.player;
      if (var1 != null && var1 == this.nvd && this.nvg >= 0 && wdq.canClick(var1) && this.nwe(var1)) {
         this.nvx(var1.getInventory());
      }

      this.nwd();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != this.nvd) {
         this.nvd = var2;
         this.nwd();
      }

      if (this.nvo > 0) {
         this.nvo--;
      }

      if (lqq.busy()) {
         this.nwc();
      } else {
         PlayerInventory var3 = var2.getInventory();
         if (this.nvf >= 0 && var3.getSelectedSlot() != this.nvf) {
            this.nvi = true;
         }

         BlockState var4 = this.nvs(var2);
         this.nvj = var4 != null ? 0 : Math.min(this.nvj + 1, 1000);
         if (var2.isAlive() && !var2.isSpectator()) {
            int var5 = this.nvr(var2, var4);
            if (var5 == -1) {
               this.nwc();
            } else if (var5 == -3) {
               this.nwd();
            } else if (var5 < 9 && var5 >= 0) {
               this.nwc();
               this.nvy(var3, var5);
            } else if (var5 != -2 || this.nvg >= 0 && this.nvz(var3)) {
               if (this.nvo > 0 || !wdq.canClick(var2) || oxw.busy() || kvz.busy() || krd.busy()) {
                  this.nwc();
               } else if (this.nwe(var2)) {
                  this.nwc();
                  this.nvw(var2, var5);
               } else if (nwf(var2)) {
                  this.nwc();
               } else if (++this.nvn > 20) {
                  this.nwc();
                  this.nvo = 20;
               } else {
                  this.nwa(var2);
                  this.nvk = var5;
               }
            } else {
               this.nvx(var3);
            }
         } else {
            this.nwd();
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.nvk != -1) {
         ClientPlayerEntity var2 = var1.player;
         if (wdq.canClick(var2) && this.nwe(var2) && !oxw.busy() && !kvz.busy()) {
            int var3 = this.nvk;
            this.nvw(var2, var3);
            this.nwc();
         } else {
            this.nwb();
         }
      }
   }

   private int nvr(ClientPlayerEntity var1, BlockState var2) {
      if (var2 != null) {
         if (this.nvi) {
            return -1;
         }

         boolean var5 = this.nux.get() && (this.nwe(var1) || !nwf(var1));
         return this.nvt(var1, var2, var5);
      } else if (this.nve >= 0 && !var1.isUsingItem()) {
         HitResult var3 = this.mc.crosshairTarget;
         boolean var4 = var3 != null && var3.getType() == Type.ENTITY;
         if (!var4 && this.nvj <= this.nuz.getInt()) {
            return -1;
         } else {
            return this.nuy.get() ? -2 : -3;
         }
      } else {
         return -1;
      }
   }

   private BlockState nvs(ClientPlayerEntity var1) {
      if (this.mc.currentScreen == null
         && this.mc.world != null
         && !var1.isCreative()
         && !var1.isSpectator()
         && !var1.isUsingItem()
         && this.mc.options.attackKey.isPressed()) {
         this.mc.gameRenderer.updateCrosshairTarget(1.0F);
         if (this.mc.crosshairTarget instanceof BlockHitResult var2 && var2.getType() == Type.BLOCK) {
            BlockPos var5 = var2.getBlockPos();
            BlockState var4 = this.mc.world.getBlockState(var5);
            return !var4.isAir() && !(var4.getHardness(this.mc.world, var5) <= 0.0F) ? var4 : null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private int nvt(ClientPlayerEntity var1, BlockState var2, boolean var3) {
      PlayerInventory var4 = var1.getInventory();
      int var5 = var4.getSelectedSlot();
      float var6 = this.nvu(var4.getStack(var5), var2);
      int var7 = -1;

      for (int var8 = 0; var8 < 9; var8++) {
         if (var8 != var5) {
            float var9 = this.nvu(var4.getStack(var8), var2);
            if (var9 > var6 + 0.01F) {
               var6 = var9;
               var7 = var8;
            }
         }
      }

      if (var3) {
         for (int var10 = 9; var10 < 36; var10++) {
            float var11 = this.nvu(var4.getStack(var10), var2);
            if (var11 > var6 + 0.01F && var11 > 1.0F) {
               var6 = var11;
               var7 = var10;
            }
         }
      }

      return var7;
   }

   private float nvu(ItemStack var1, BlockState var2) {
      if (this.nva.get() && var1.isDamageable() && var1.getMaxDamage() - var1.getDamage() <= 10) {
         return -1.0F;
      }

      float var3 = var1.getMiningSpeedMultiplier(var2);
      if (var3 > 1.0F) {
         int var4 = nvv(var1);
         if (var4 > 0) {
            var3 += var4 * var4 + 1;
         }
      }

      return var2.isToolRequired() && !var1.isSuitableFor(var2) ? var3 * 0.3F : var3;
   }

   private static int nvv(ItemStack var0) {
      for (Entry var2 : var0.getEnchantments().getEnchantmentEntries()) {
         if (((RegistryEntry)var2.getKey()).matchesKey(Enchantments.EFFICIENCY)) {
            return var2.getIntValue();
         }
      }

      return 0;
   }

   private void nvw(ClientPlayerEntity var1, int var2) {
      PlayerInventory var3 = var1.getInventory();
      if (var2 == -2) {
         this.nvx(var3);
      } else {
         if (this.nve < 0) {
            this.nve = var3.getSelectedSlot();
         }

         if (this.nvg >= 0 && this.nvz(var3)) {
            wdq.click(this.mc, this.nvg, this.nve);
            if (var2 == this.nvg) {
               this.nvg = -1;
               this.nvh = ItemStack.EMPTY;
               wdq.close(this.mc);
               this.nvy(var3, this.nve);
               return;
            }
         }

         this.nvh = var3.getStack(this.nve).copy();
         wdq.click(this.mc, var2, this.nve);
         this.nvg = var2;
         wdq.close(this.mc);
         this.nvy(var3, this.nve);
      }
   }

   private void nvx(PlayerInventory var1) {
      if (this.nvg >= 0 && this.nvz(var1)) {
         wdq.swap(this.mc, this.nvg, this.nve);
      }

      if (!this.nvi && this.nve >= 0 && var1.getSelectedSlot() == this.nvf && this.nvf != this.nve) {
         var1.setSelectedSlot(this.nve);
      }

      this.nwd();
   }

   private void nvy(PlayerInventory var1, int var2) {
      if (this.nve < 0) {
         this.nve = var1.getSelectedSlot();
      }

      if (var1.getSelectedSlot() != var2) {
         var1.setSelectedSlot(var2);
      }

      this.nvf = var2;
   }

   private boolean nvz(PlayerInventory var1) {
      return ItemStack.areItemsAndComponentsEqual(var1.getStack(this.nvg), this.nvh);
   }

   private void nwa(ClientPlayerEntity var1) {
      this.nvc.hold(this.mc);
      KeyBinding var2 = this.mc.options.attackKey;

      while (var2.wasPressed()) {
         this.nvm = true;
      }

      var2.setPressed(false);
      this.nvl = true;
      if (var1.isUsingItem()) {
         this.mc.interactionManager.stopUsingItem(var1);
      }
   }

   private void nwb() {
      if (this.nvl) {
         this.nvl = false;
         if (this.mc.options != null && this.mc.getWindow() != null) {
            KeyBinding var1 = this.mc.options.attackKey;
            var1.setPressed(vzz.isPhysicallyDown(this.mc, var1));
            if (this.nvm) {
               Key var2 = KeyBindingHelper.getBoundKeyOf(var1);
               if (!var2.equals(InputUtil.UNKNOWN_KEY)) {
                  KeyBinding.onKeyPressed(var2);
               }
            }
         }
      }

      this.nvm = false;
   }

   private void nwc() {
      if (this.nvc.isHeld()) {
         this.nvc.release(this.mc);
      }

      this.nwb();
      this.nvk = -1;
      this.nvn = 0;
   }

   private void nwd() {
      this.nwc();
      this.nve = -1;
      this.nvf = -1;
      this.nvg = -1;
      this.nvh = ItemStack.EMPTY;
      this.nvi = false;
   }

   private boolean nwe(ClientPlayerEntity var1) {
      return vyn.serverIdle(var1) && !var1.isUsingItem() && (this.mc.interactionManager == null || !this.mc.interactionManager.isBreakingBlock());
   }

   private static boolean nwf(ClientPlayerEntity var0) {
      boolean var1 = var0.isSneaking() || vyn.lastSent(var0).sneak();
      if (var1 && var0.isOnGround()) {
         Box var2 = var0.getBoundingBox();
         Vec3d var3 = var0.getVelocity();
         double var4 = var0.getStepHeight();
         Box var6 = new Box(
            var2.minX + var3.x + 1.0E-7,
            var2.minY - var4 - 1.0E-7,
            var2.minZ + var3.z + 1.0E-7,
            var2.maxX + var3.x - 1.0E-7,
            var2.minY,
            var2.maxZ + var3.z - 1.0E-7
         );
         return var0.getEntityWorld().isSpaceEmpty(var0, var6);
      } else {
         return false;
      }
   }
}
