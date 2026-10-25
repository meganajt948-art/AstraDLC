package a;

import flow.dev.a;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class lfy {
   private static final EquipmentSlot[] lfz = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   public final vkl naked = new vkl(a.b("鼖\ue688汑\uf22e秸", -2021679267), true);
   public final vkl invisible = new vkl(a.d("\udb77ꋡ⠪뙄㶉묢ź袅ᛓ", 2016256898, 1796503733), true);
   public final vkl armored = new vkl(a.c(-1998809439, "雧\uef65斩ﯚ瀐\uf6b6䳤"), true);

   public boolean allows(Entity var1) {
      if (!this.invisible.get() && invisible(var1)) {
         return false;
      } else if (var1 instanceof PlayerEntity var2) {
         return armor(var2) ? this.armored.get() : this.naked.get();
      } else {
         return true;
      }
   }

   public static boolean invisible(Entity var0) {
      return var0.isInvisible() || var0 instanceof LivingEntity var1 && var1.hasStatusEffect(StatusEffects.INVISIBILITY);
   }

   public static boolean armor(LivingEntity var0) {
      for (EquipmentSlot var4 : lfz) {
         ItemStack var5 = var0.getEquippedStack(var4);
         if (!var5.isEmpty() && !var5.isOf(Items.ELYTRA)) {
            return true;
         }
      }

      return false;
   }
}
