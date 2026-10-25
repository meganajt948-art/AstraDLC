/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.vkl;
import flow.dev.a;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class lfy {
    private static final EquipmentSlot[] lfz = new EquipmentSlot[]{EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166};
    public final vkl naked = new vkl(a.b("\u9f16\ue688\u6c51\uf22e\u79f8", -2021679267), true);
    public final vkl invisible = new vkl(a.d("\udb77\ua2e1\u282a\ub644\u3d89\ubb22\u017a\u8885\u16d3", 2016256898, 1796503733), true);
    public final vkl armored = new vkl(a.c(-1998809439, "\u96e7\uef65\u65a9\ufbda\u7010\uf6b6\u4ce4"), true);
    private static /* synthetic */ long lga;
    private static /* synthetic */ boolean lgb;

    public boolean allows(Entity entity) {
        if (!this.invisible.get() && lfy.invisible(entity)) {
            return false;
        }
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)entity;
            return lfy.armor((LivingEntity)playerEntity) ? this.armored.get() : this.naked.get();
        }
        return true;
    }

    public static boolean invisible(Entity entity) {
        LivingEntity livingEntity;
        return entity.method_5767() || entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).method_6059(StatusEffects.field_5905);
    }

    public static boolean armor(LivingEntity livingEntity) {
        for (EquipmentSlot equipmentSlot : lfz) {
            ItemStack itemStack = livingEntity.method_6118(equipmentSlot);
            if (itemStack.method_7960() || itemStack.method_31574(Items.field_8833)) continue;
            return true;
        }
        return false;
    }

    private static /* synthetic */ int awo(int n, int n2) {
        return n + n2 ^ 0x140B2C7A;
    }
}

