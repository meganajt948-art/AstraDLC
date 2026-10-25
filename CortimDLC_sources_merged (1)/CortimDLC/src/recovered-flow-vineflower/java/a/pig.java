package a;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

public record pig(RegistryEntry<StatusEffect> effect, int level, int duration) {
   private final RegistryEntry<StatusEffect> pih;
   private final int pii;
   private final int pij;

   public pig(RegistryEntry<StatusEffect> effect, int level, int duration) {
      this.pih = effect;
      this.pii = level;
      this.pij = duration;
   }

   boolean in(PotionContentsComponent var1) {
      for (StatusEffectInstance var3 : var1.method_57397()) {
         if (var3.method_5579().equals(this.pih) && var3.method_5578() + 1 == this.pii && var3.method_5584() >= this.pij) {
            return true;
         }
      }

      return false;
   }

   public RegistryEntry<StatusEffect> effect() {
      return this.pih;
   }

   public int level() {
      return this.pii;
   }

   public int duration() {
      return this.pij;
   }
}
