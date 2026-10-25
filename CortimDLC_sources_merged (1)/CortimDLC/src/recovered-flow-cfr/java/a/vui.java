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
            case EquipmentSlot.HEAD -> 5;
            case EquipmentSlot.CHEST -> 6;
            case EquipmentSlot.LEGS -> 7;
            default -> 8;
        };
    }

    public static EquipmentSlot wornIn(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return null;
        }
        EquippableComponent equippableComponent = (EquippableComponent)itemStack.get(DataComponentTypes.EQUIPPABLE);
        if (equippableComponent == null) {
            return null;
        }
        EquipmentSlot equipmentSlot = equippableComponent.slot();
        return equipmentSlot == EquipmentSlot.HEAD || equipmentSlot == EquipmentSlot.CHEST || equipmentSlot == EquipmentSlot.LEGS || equipmentSlot == EquipmentSlot.FEET ? equipmentSlot : null;
    }

    public static int left(ItemStack itemStack) {
        return itemStack.isDamageable() ? itemStack.getMaxDamage() - itemStack.getDamage() : Integer.MAX_VALUE;
    }

    public static vuc best(PlayerInventory playerInventory, boolean bl, ToIntFunction<ItemStack> toIntFunction) {
        vuc vuc2 = null;
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            BundleContentsComponent bundleContentsComponent;
            ItemStack itemStack = playerInventory.getStack(i);
            int n2 = toIntFunction.applyAsInt(itemStack);
            if (n2 > n) {
                vuc2 = new vuc(i, -1, itemStack);
                n = n2;
            }
            if (!bl || (bundleContentsComponent = vvn.contents(itemStack)) == null) continue;
            for (int j = 0; j < bundleContentsComponent.size(); ++j) {
                ItemStack itemStack2 = bundleContentsComponent.get(j);
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
        if (itemStack.isEmpty() || !vuc2.inBundle()) {
            return true;
        }
        ItemStack itemStack2 = playerInventory.getStack(vuc2.index());
        BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack2);
        if (bundleContentsComponent != null && (fraction = Fraction.ONE.subtract(bundleContentsComponent.getOccupancy()).add(Fraction.getFraction((int)vuc2.stack().getCount(), (int)vuc2.stack().getMaxCount()))).compareTo(Fraction.getFraction((int)itemStack.getCount(), (int)itemStack.getMaxCount())) >= 0) {
            return true;
        }
        return vui.vum(playerInventory) >= 0;
    }

    public static boolean equip(MinecraftClient minecraftClient, EquipmentSlot equipmentSlot, vuc vuc2) {
        int n;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!wdq.canClick(clientPlayerEntity)) {
            return false;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        int n2 = vui.slotId(equipmentSlot);
        if (vuc2.inBundle()) {
            ItemStack itemStack = playerInventory.getStack(vuc2.index());
            BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack);
            if (bundleContentsComponent == null || vuc2.entry() >= bundleContentsComponent.size()) {
                return false;
            }
            vui.vun(minecraftClient, vuc2.index(), vuc2.entry());
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 1);
        } else {
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 0);
        }
        if (vui.vul(clientPlayerEntity).isEmpty()) {
            return false;
        }
        vui.vuo(minecraftClient, n2, 0);
        if (!vui.vul(clientPlayerEntity).isEmpty()) {
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 0);
        }
        if (!vui.vul(clientPlayerEntity).isEmpty() && (n = vui.vum(playerInventory)) >= 0) {
            vui.vuo(minecraftClient, wdq.slotId(n), 0);
        }
        if (!vui.vul(clientPlayerEntity).isEmpty()) {
            vui.vuo(minecraftClient, n2, 0);
            vui.vuo(minecraftClient, wdq.slotId(vuc2.index()), 0);
        }
        wdq.close(minecraftClient);
        return ItemStack.areItemsEqual((ItemStack)clientPlayerEntity.getEquippedStack(equipmentSlot), (ItemStack)vuc2.stack());
    }

    public static boolean takeOff(MinecraftClient minecraftClient, EquipmentSlot equipmentSlot) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        int n = vui.vum(clientPlayerEntity.getInventory());
        if (n < 0 || !wdq.canClick(clientPlayerEntity) || clientPlayerEntity.getEquippedStack(equipmentSlot).isEmpty()) {
            return false;
        }
        vui.vuo(minecraftClient, vui.slotId(equipmentSlot), 0);
        vui.vuo(minecraftClient, wdq.slotId(n), 0);
        wdq.close(minecraftClient);
        return true;
    }

    public static boolean matches(ItemStack itemStack, Predicate<ItemStack> predicate) {
        return !itemStack.isEmpty() && predicate.test(itemStack);
    }

    private static ItemStack vul(ClientPlayerEntity clientPlayerEntity) {
        return clientPlayerEntity.playerScreenHandler.getCursorStack();
    }

    private static int vum(PlayerInventory playerInventory) {
        int n;
        for (n = 9; n < 36; ++n) {
            if (!playerInventory.getStack(n).isEmpty()) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (!playerInventory.getStack(n).isEmpty()) continue;
            return n;
        }
        return -1;
    }

    private static void vun(MinecraftClient minecraftClient, int n, int n2) {
        int n3;
        ItemStack itemStack = minecraftClient.player.getInventory().getStack(n);
        BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack);
        int n4 = n3 = bundleContentsComponent == null ? -1 : bundleContentsComponent.getSelectedStackIndex();
        if (bundleContentsComponent == null || n3 == n2 || n2 == 0 && (n3 < 0 || n3 >= bundleContentsComponent.size())) {
            return;
        }
        BundleItem.setSelectedStackIndex((ItemStack)itemStack, (int)n2);
        minecraftClient.getNetworkHandler().sendPacket((Packet)new BundleItemSelectedC2SPacket(wdq.slotId(n), n2));
    }

    private static void vuo(MinecraftClient minecraftClient, int n, int n2) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        minecraftClient.interactionManager.clickSlot(clientPlayerEntity.playerScreenHandler.syncId, n, n2, SlotActionType.PICKUP, (PlayerEntity)clientPlayerEntity);
    }

    private static /* synthetic */ int dkt(int n, int n2) {
        return n * n2 ^ 0xDDFD7A6;
    }

    private static /* synthetic */ int dku(int n, int n2) {
        return n ^ n2 | 0xA2766197;
    }
}

