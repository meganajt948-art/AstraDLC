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
   private ItemStack nvh = ItemStack.field_8037;
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
      ClientPlayerEntity var1 = this.mc.field_1724;
      if (var1 != null && var1 == this.nvd && this.nvg >= 0 && wdq.canClick(var1) && this.nwe(var1)) {
         this.nvx(var1.method_31548());
      }

      this.nwd();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
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
         PlayerInventory var3 = var2.method_31548();
         if (this.nvf >= 0 && var3.method_67532() != this.nvf) {
            this.nvi = true;
         }

         BlockState var4 = this.nvs(var2);
         this.nvj = var4 != null ? 0 : Math.min(this.nvj + 1, 1000);
         if (var2.method_5805() && !var2.method_7325()) {
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
         ClientPlayerEntity var2 = var1.field_1724;
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
         } else {
            boolean var5 = this.nux.get() && (this.nwe(var1) || !nwf(var1));
            return this.nvt(var1, var2, var5);
         }
      } else if (this.nve >= 0 && !var1.method_6115()) {
         HitResult var3 = this.mc.field_1765;
         boolean var4 = var3 != null && var3.method_17783() == Type.field_1331;
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
      if (this.mc.field_1755 == null
         && this.mc.field_1687 != null
         && !var1.method_68878()
         && !var1.method_7325()
         && !var1.method_6115()
         && this.mc.field_1690.field_1886.method_1434()) {
         this.mc.field_1773.method_3190(1.0F);
         if (this.mc.field_1765 instanceof BlockHitResult var2 && var2.method_17783() == Type.field_1332) {
            BlockPos var5 = var2.method_17777();
            BlockState var4 = this.mc.field_1687.method_8320(var5);
            return !var4.method_26215() && !(var4.method_26214(this.mc.field_1687, var5) <= 0.0F) ? var4 : null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private int nvt(ClientPlayerEntity var1, BlockState var2, boolean var3) {
      PlayerInventory var4 = var1.method_31548();
      int var5 = var4.method_67532();
      float var6 = this.nvu(var4.method_5438(var5), var2);
      int var7 = -1;

      for (int var8 = 0; var8 < 9; var8++) {
         if (var8 != var5) {
            float var9 = this.nvu(var4.method_5438(var8), var2);
            if (var9 > var6 + 0.01F) {
               var6 = var9;
               var7 = var8;
            }
         }
      }

      if (var3) {
         for (int var10 = 9; var10 < 36; var10++) {
            float var11 = this.nvu(var4.method_5438(var10), var2);
            if (var11 > var6 + 0.01F && var11 > 1.0F) {
               var6 = var11;
               var7 = var10;
            }
         }
      }

      return var7;
   }

   private float nvu(ItemStack var1, BlockState var2) {
      if (this.nva.get() && var1.method_7963() && var1.method_7936() - var1.method_7919() <= 10) {
         return -1.0F;
      } else {
         float var3 = var1.method_7924(var2);
         if (var3 > 1.0F) {
            int var4 = nvv(var1);
            if (var4 > 0) {
               var3 += var4 * var4 + 1;
            }
         }

         return var2.method_29291() && !var1.method_7951(var2) ? var3 * 0.3F : var3;
      }
   }

   private static int nvv(ItemStack var0) {
      for (Entry var2 : var0.method_58657().method_57539()) {
         if (((RegistryEntry)var2.getKey()).method_40225(Enchantments.field_9131)) {
            return var2.getIntValue();
         }
      }

      return 0;
   }

   private void nvw(ClientPlayerEntity var1, int var2) {
      PlayerInventory var3 = var1.method_31548();
      if (var2 == -2) {
         this.nvx(var3);
      } else {
         if (this.nve < 0) {
            this.nve = var3.method_67532();
         }

         if (this.nvg >= 0 && this.nvz(var3)) {
            wdq.click(this.mc, this.nvg, this.nve);
            if (var2 == this.nvg) {
               this.nvg = -1;
               this.nvh = ItemStack.field_8037;
               wdq.close(this.mc);
               this.nvy(var3, this.nve);
               return;
            }
         }

         this.nvh = var3.method_5438(this.nve).method_7972();
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

      if (!this.nvi && this.nve >= 0 && var1.method_67532() == this.nvf && this.nvf != this.nve) {
         var1.method_61496(this.nve);
      }

      this.nwd();
   }

   private void nvy(PlayerInventory var1, int var2) {
      if (this.nve < 0) {
         this.nve = var1.method_67532();
      }

      if (var1.method_67532() != var2) {
         var1.method_61496(var2);
      }

      this.nvf = var2;
   }

   private boolean nvz(PlayerInventory var1) {
      return ItemStack.method_31577(var1.method_5438(this.nvg), this.nvh);
   }

   private void nwa(ClientPlayerEntity var1) {
      this.nvc.hold(this.mc);
      KeyBinding var2 = this.mc.field_1690.field_1886;

      while (var2.method_1436()) {
         this.nvm = true;
      }

      var2.method_23481(false);
      this.nvl = true;
      if (var1.method_6115()) {
         this.mc.field_1761.method_2897(var1);
      }
   }

   private void nwb() {
      if (this.nvl) {
         this.nvl = false;
         if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
            KeyBinding var1 = this.mc.field_1690.field_1886;
            var1.method_23481(vzz.isPhysicallyDown(this.mc, var1));
            if (this.nvm) {
               Key var2 = KeyBindingHelper.getBoundKeyOf(var1);
               if (!var2.equals(InputUtil.field_16237)) {
                  KeyBinding.method_1420(var2);
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
      this.nvh = ItemStack.field_8037;
      this.nvi = false;
   }

   private boolean nwe(ClientPlayerEntity var1) {
      return vyn.serverIdle(var1) && !var1.method_6115() && (this.mc.field_1761 == null || !this.mc.field_1761.method_2923());
   }

   private static boolean nwf(ClientPlayerEntity var0) {
      boolean var1 = var0.method_5715() || vyn.lastSent(var0).comp_3164();
      if (var1 && var0.method_24828()) {
         Box var2 = var0.method_5829();
         Vec3d var3 = var0.method_18798();
         double var4 = var0.method_49476();
         Box var6 = new Box(
            var2.field_1323 + var3.field_1352 + 1.0E-7,
            var2.field_1322 - var4 - 1.0E-7,
            var2.field_1321 + var3.field_1350 + 1.0E-7,
            var2.field_1320 + var3.field_1352 - 1.0E-7,
            var2.field_1322,
            var2.field_1324 + var3.field_1350 - 1.0E-7
         );
         return var0.method_73183().method_8587(var0, var6);
      } else {
         return false;
      }
   }
}
