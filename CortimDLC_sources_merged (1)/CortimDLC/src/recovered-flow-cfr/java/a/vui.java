/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.component.type.EquippableComponent
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.BundleItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket
 *  net.minecraft.screen.slot.SlotActionType
 *  org.apache.commons.lang3.math.Fraction
 */
package a;

import a.vuc;
import a.vvn;
import a.wdq;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.apache.commons.lang3.math.Fraction;

public final class vui {
    private static /* synthetic */ int vuj;
    private static /* synthetic */ String vuk;

    private vui() {
    }

    public static int slotId(EquipmentSlot equipmentSlot) {
        return switch (equipmentSlot) {
            case EquipmentSlot.field_6169 -> 5;
            case EquipmentSlot.field_6174 -> 6;
            case EquipmentSlot.field_6172 -> 7;
            default -> 8;
        };
    }

    public static EquipmentSlot wornIn(ItemStack itemStack) {
        if (itemStack.method_7960()) {
            return null;
        }
        EquippableComponent equippableComponent = (EquippableComponent)itemStack.method_58694(DataComponentTypes.field_54196);
        if (equippableComponent == null) {
            return null;
        }
        EquipmentSlot equipmentSlot = equippableComponent.comp_3174();
        return equipmentSlot == EquipmentSlot.field_6169 || equipmentSlot == EquipmentSlot.field_6174 || equipmentSlot == EquipmentSlot.field_6172 || equipmentSlot == EquipmentSlot.field_6166 ? equipmentSlot : null;
    }

    public static int left(ItemStack itemStack) {
        return itemStack.method_7963() ? itemStack.method_7936() - itemStack.method_7919() : Integer.MAX_VALUE;
    }

    public static vuc best(PlayerInventory playerInventory, boolean bl, ToIntFunction<ItemStack> toIntFunction) {
        vuc vuc2 = null;
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            BundleContentsComponent bundleContentsComponent;
            ItemStack itemStack = playerInventory.method_5438(i);
            int n2 = toIntFunction.applyAsInt(itemStack);
            if (n2 > n) {
                vuc2 = new vuc(i, -1, itemStack);
                n = n2;
            }
            if (!bl || (bundleContentsComponent = vvn.contents(itemStack)) == null) continue;
            for (int j = 0; j < bundleContentsComponent.method_57426(); ++j) {
                ItemStack itemStack2 = bundleContentsComponent.method_57422(j);
                int n3 = toIntFunction.applyAsInt(itemStack2);
                if (n3 <= n) continue;
                vuc2 = new vuc(i, j, itemStack2);
                n = n3;
            }
        }
        return vuc2;
    }

    public static boolean roomFor(PlayerInventory playerInventory, vuc vuc2, ItemStack itemStack) {
        Fraction fraction;
        if (itemStack.method_7960() || !vuc2.inBundle()) {
            return true;
        }
        ItemStack itemStack2 = playerInventory.method_5438(vuc2.index());
        BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack2);
        if (bundleContentsComponent != null && (fraction = Fraction.ONE.subtract(bundleContentsComponent.method_57428()).add(Fraction.getFraction((int)vuc2.stack().method_7947(), (int)vuc2.stack().method_7914()))).compareTo(Fraction.getFraction((int)itemStack.method_7947(), (int)itemStack.method_7914())) >= 0) {
            return true;
        }
        return vui.vum(playerInventory) >= 0;
    }

    public static boolean equip(MinecraftClient minecraftClient, EquipmentSlot equipmentSlot, vuc vuc2) {
        int n;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (!wdq.canClick(clientPlayerEntity)) {
            return false;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        int n2 = vui.slotId(equipmentSlot);
        if (vuc2.inBundle()) {
            ItemStack itemStack = playerInventory.method_5438(vuc2.index());
            BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack);
            if (bundleContentsComponent == null || vuc2.entry() >= bundleContentsComponent.method_57426()) {
                return false;
            }
            vui.vun(minecraftClient, vuc2.index(), vuc2.entry());
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 1);
        } else {
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 0);
        }
        if (vui.vul(clientPlayerEntity).method_7960()) {
            return false;
        }
        vui.vuo(minecraftClient, n2, 0);
        if (!vui.vul(clientPlayerEntity).method_7960()) {
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 0);
        }
        if (!vui.vul(clientPlayerEntity).method_7960() && (n = vui.vum(playerInventory)) >= 0) {
            vui.vuo(minecraftClient, wdq.slotId(n), 0);
        }
        if (!vui.vul(clientPlayerEntity).method_7960()) {
            vui.vuo(minecraftClient, n2, 0);
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 0);
        }
        wdq.close(minecraftClient);
        return ItemStack.method_7984((ItemStack)clientPlayerEntity.method_6118(equipmentSlot), (ItemStack)vuc2.stack());
    }

    public static boolean takeOff(MinecraftClient minecraftClient, EquipmentSlot equipmentSlot) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        int n = vui.vum(clientPlayerEntity.method_31548());
        if (n < 0 || !wdq.canClick(clientPlayerEntity) || clientPlayerEntity.method_6118(equipmentSlot).method_7960()) {
            return false;
        }
        vui.vuo(minecraftClient, vui.slotId(equipmentSlot), 0);
        vui.vuo(minecraftClient, wdq.slotId(n), 0);
        wdq.close(minecraftClient);
        return true;
    }

    public static boolean matches(ItemStack itemStack, Predicate<ItemStack> predicate) {
        return !itemStack.method_7960() && predicate.test(itemStack);
    }

    private static ItemStack vul(ClientPlayerEntity clientPlayerEntity) {
        return clientPlayerEntity.field_7498.method_34255();
    }

    private static int vum(PlayerInventory playerInventory) {
        int n;
        for (n = 9; n < 36; ++n) {
            if (!playerInventory.method_5438(n).method_7960()) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (!playerInventory.method_5438(n).method_7960()) continue;
            return n;
        }
        return -1;
    }

    private static void vun(MinecraftClient minecraftClient, int n, int n2) {
        int n3;
        ItemStack itemStack = minecraftClient.field_1724.method_31548().method_5438(n);
        BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack);
        int n4 = n3 = bundleContentsComponent == null ? -1 : bundleContentsComponent.method_61668();
        if (bundleContentsComponent == null || n3 == n2 || n2 == 0 && (n3 < 0 || n3 >= bundleContentsComponent.method_57426())) {
            return;
        }
        BundleItem.method_61637((ItemStack)itemStack, (int)n2);
        minecraftClient.method_1562().method_52787((Packet)new BundleItemSelectedC2SPacket(wdq.slotId(n), n2));
    }

    private static void vuo(MinecraftClient minecraftClient, int n, int n2) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        minecraftClient.field_1761.method_2906(clientPlayerEntity.field_7498.field_7763, n, n2, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
    }

    private static /* synthetic */ int dkt(int n, int n2) {
        return n * n2 ^ 0xDDFD7A6;
    }

    private static /* synthetic */ int dku(int n, int n2) {
        return n ^ n2 | 0xA2766197;
    }
}

