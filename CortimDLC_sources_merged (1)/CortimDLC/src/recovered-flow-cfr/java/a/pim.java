/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.AttributeModifiersComponent
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.entity.attribute.EntityAttribute
 *  net.minecraft.entity.attribute.EntityAttributeModifier$Operation
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.entry.RegistryEntry
 */
package a;

import a.pia;
import a.pig;
import java.util.List;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

public final class pim {
    private static final double pin = 0.001;
    private static /* synthetic */ long pio;
    private static /* synthetic */ boolean pip;

    private pim() {
    }

    public static pia flat(RegistryEntry<EntityAttribute> registryEntry, double d) {
        return new pia(registryEntry, d, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    public static pia scaled(RegistryEntry<EntityAttribute> registryEntry, double d) {
        return new pia(registryEntry, d, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }

    public static pig effect(RegistryEntry<StatusEffect> registryEntry, int n, int n2) {
        return new pig(registryEntry, n, n2);
    }

    static boolean attrs(ItemStack itemStack, List<pia> list) {
        AttributeModifiersComponent attributeModifiersComponent = (AttributeModifiersComponent)itemStack.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, (Object)AttributeModifiersComponent.DEFAULT);
        for (pia pia2 : list) {
            if (pia2.in(attributeModifiersComponent)) continue;
            return false;
        }
        return true;
    }

    static boolean effects(ItemStack itemStack, List<pig> list) {
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.get(DataComponentTypes.POTION_CONTENTS);
        if (potionContentsComponent == null) {
            return false;
        }
        int n = 0;
        for (StatusEffectInstance object : potionContentsComponent.getEffects()) {
            ++n;
        }
        if (n != list.size()) {
            return false;
        }
        for (pig pig2 : list) {
            if (pig2.in(potionContentsComponent)) continue;
            return false;
        }
        return true;
    }

    private static /* synthetic */ int bjl(int n, int n2) {
        return n + n2 + -471542669;
    }

    private static /* synthetic */ int bjm(int n, int n2) {
        return pim.bjl(n, n2) ^ 0x73B24F51;
    }
}

