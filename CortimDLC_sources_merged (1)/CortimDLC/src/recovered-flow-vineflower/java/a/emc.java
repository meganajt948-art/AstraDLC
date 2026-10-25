package a;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;

public final class emc {
   private final RegistryEntry<StatusEffect> emd;
   private final int eme;
   private final int emf;

   public emc(RegistryEntry<StatusEffect> effect, int level, int duration) {
      this.emd = effect;
      this.eme = level;
      this.emf = duration;
   }

   public RegistryEntry<StatusEffect> effect() {
      return this.emd;
   }

   public int level() {
      return this.eme;
   }

   public int duration() {
      return this.emf;
   }
}
