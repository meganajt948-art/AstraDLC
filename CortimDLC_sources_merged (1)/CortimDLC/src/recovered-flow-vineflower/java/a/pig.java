package a;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

public final class pig {
   final RegistryEntry<StatusEffect> pih;
   final int pii;
   final int pij;

   public pig(RegistryEntry<StatusEffect> effect, int level, int duration) {
      this.pih = effect;
      this.pii = level;
      this.pij = duration;
   }

   boolean in(PotionContentsComponent var1) {
      for (StatusEffectInstance var3 : var1.getEffects()) {
         if (var3.getEffectType().equals(this.pih) && var3.getAmplifier() + 1 == this.pii && var3.getDuration() >= this.pij) {
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
