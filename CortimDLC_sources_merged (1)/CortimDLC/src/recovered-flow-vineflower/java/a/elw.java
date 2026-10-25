package a;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.registry.entry.RegistryEntry;

final class elw {
   final RegistryEntry<EntityAttribute> elx;
   final double ely;
   final Operation elz;

   elw(RegistryEntry<EntityAttribute> attribute, double amount, Operation operation) {
      this.elx = attribute;
      this.ely = amount;
      this.elz = operation;
   }

   public RegistryEntry<EntityAttribute> attribute() {
      return this.elx;
   }

   public double amount() {
      return this.ely;
   }

   public Operation operation() {
      return this.elz;
   }
}
