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
   private static final double pin = 0.001;

   private pim() {
   }

   public static pia flat(RegistryEntry<EntityAttribute> var0, double var1) {
      return new pia(var0, var1, Operation.field_6328);
   }

   public static pia scaled(RegistryEntry<EntityAttribute> var0, double var1) {
      return new pia(var0, var1, Operation.field_6330);
   }

   public static pig effect(RegistryEntry<StatusEffect> var0, int var1, int var2) {
      return new pig(var0, var1, var2);
   }

   static boolean attrs(ItemStack var0, List<pia> var1) {
      AttributeModifiersComponent var2 = (AttributeModifiersComponent)var0.method_58695(DataComponentTypes.field_49636, AttributeModifiersComponent.field_49326);

      for (pia var4 : var1) {
         if (!var4.in(var2)) {
            return false;
         }
      }

      return true;
   }

   static boolean effects(ItemStack var0, List<pig> var1) {
      PotionContentsComponent var2 = (PotionContentsComponent)var0.method_58694(DataComponentTypes.field_49651);
      if (var2 == null) {
         return false;
      } else {
         int var3 = 0;

         for (StatusEffectInstance var5 : var2.method_57397()) {
            var3++;
         }

         if (var3 != var1.size()) {
            return false;
         } else {
            for (pig var7 : var1) {
               if (!var7.in(var2)) {
                  return false;
               }
            }

            return true;
         }
      }
   }
}
