package a;

import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.registry.entry.RegistryEntry;

public record pia(RegistryEntry<EntityAttribute> attribute, double amount, Operation op) {
   private final RegistryEntry<EntityAttribute> pib;
   private final double pic;
   private final Operation pid;

   public pia(RegistryEntry<EntityAttribute> attribute, double amount, Operation op) {
      this.pib = attribute;
      this.pic = amount;
      this.pid = op;
   }

   boolean in(AttributeModifiersComponent var1) {
      for (Entry var3 : var1.comp_2393()) {
         if (var3.comp_2395().equals(this.pib) && var3.comp_2396().comp_2450() == this.pid && Math.abs(var3.comp_2396().comp_2449() - this.pic) < 0.001) {
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
