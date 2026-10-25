package a;

import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.registry.entry.RegistryEntry;

public final class pia {
   private final RegistryEntry<EntityAttribute> pib;
   private final double pic;
   private final Operation pid;

   public pia(RegistryEntry<EntityAttribute> attribute, double amount, Operation op) {
      this.pib = attribute;
      this.pic = amount;
      this.pid = op;
   }

   boolean in(AttributeModifiersComponent var1) {
      for (Entry var3 : var1.modifiers()) {
         if (var3.attribute().equals(this.pib) && var3.modifier().operation() == this.pid && Math.abs(var3.modifier().value() - this.pic) < 0.001) {
            return true;
         }
      }

      return false;
   }

   public RegistryEntry<EntityAttribute> attribute() {
      return this.pib;
   }

   public double amount() {
      return this.pic;
   }

   public Operation op() {
      return this.pid;
   }
}
