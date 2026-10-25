package a;

import java.util.List;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

public final class pim {
   static final double pin = 0.001;

   pim() {
   }

   public static pia flat(RegistryEntry<EntityAttribute> var0, double var1) {
      return new pia(var0, var1, Operation.ADD_VALUE);
   }

   public static pia scaled(RegistryEntry<EntityAttribute> var0, double var1) {
      return new pia(var0, var1, Operation.ADD_MULTIPLIED_BASE);
   }

   public static pig effect(RegistryEntry<StatusEffect> var0, int var1, int var2) {
      return new pig(var0, var1, var2);
   }

   static boolean attrs(ItemStack var0, List<pia> var1) {
      AttributeModifiersComponent var2 = var0.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);

      for (pia var4 : var1) {
         if (!var4.in(var2)) {
            return false;
         }
      }

      return true;
   }

   static boolean effects(ItemStack var0, List<pig> var1) {
      PotionContentsComponent var2 = var0.get(DataComponentTypes.POTION_CONTENTS);
      if (var2 == null) {
         return false;
      }

      int var3 = 0;

      for (StatusEffectInstance var5 : var2.getEffects()) {
         var3++;
      }

      if (var3 != var1.size()) {
         return false;
      }

      for (pig var7 : var1) {
         if (!var7.in(var2)) {
            return false;
         }
      }

      return true;
   }
}
