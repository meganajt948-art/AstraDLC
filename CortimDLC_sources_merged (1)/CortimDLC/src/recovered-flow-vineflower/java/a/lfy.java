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
   private static final EquipmentSlot[] lfz = new EquipmentSlot[]{
      EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166
   };
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
      return var0.method_5767() || var0 instanceof LivingEntity var1 && var1.method_6059(StatusEffects.field_5905);
   }

   public static boolean armor(LivingEntity var0) {
      for (EquipmentSlot var4 : lfz) {
         ItemStack var5 = var0.method_6118(var4);
         if (!var5.method_7960() && !var5.method_31574(Items.field_8833)) {
            return true;
         }
      }

      return false;
   }
}
