package a;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;

final class emi {
   final RegistryKey<Enchantment> emj;
   final int emk;
   final boolean eml;

   emi(RegistryKey<Enchantment> key, int level, boolean deny) {
      this.emj = key;
      this.emk = level;
      this.eml = deny;
   }

   public RegistryKey<Enchantment> key() {
      return this.emj;
   }

   public int level() {
      return this.emk;
   }

   public boolean deny() {
      return this.eml;
   }
}
