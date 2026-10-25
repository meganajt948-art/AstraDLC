/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.ShulkerBoxBlock
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import a.qof;
import a.qpq;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.SlotActionType;

public final class qpw {
    public static final int SLOTS = 36;
    public static final int OFFHAND = 40;
    public static final int OUTSIDE = -999;
    public static final int DEBRIS_SLOT = 32;
    public static final int KEEP_DIAMONDS = 16;
    public static final int KEEP_GOLD = 14;
    public static final Item[] MARKERS;
    private static final Item[] qpx;
    private static final int[] qpy;
    private static /* synthetic */ String qpz;
    private static /* synthetic */ int qqa;

    private qpw() {
    }

    public static int count(PlayerInventory playerInventory, Item item) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            if (!itemStack.isOf(item)) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    public static int countAll(PlayerEntity playerEntity, Item item) {
        ItemStack itemStack = playerEntity.getOffHandStack();
        return qpw.count(playerEntity.getInventory(), item) + (itemStack.isOf(item) ? itemStack.getCount() : 0);
    }

    public static int food(PlayerEntity playerEntity) {
        return qpw.countAll(playerEntity, Items.GOLDEN_CARROT);
    }

    public static int find(PlayerInventory playerInventory, Item item) {
        int n = -1;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            if (!itemStack.isOf(item) || n >= 0 && itemStack.getCount() <= playerInventory.getStack(n).getCount()) continue;
            n = i;
        }
        return n;
    }

    public static int emptySlot(PlayerInventory playerInventory) {
        for (int i = 35; i >= 0; --i) {
            if (!playerInventory.getStack(i).isEmpty()) continue;
            return i;
        }
        return -1;
    }

    public static int durability(ItemStack itemStack) {
        return itemStack.isEmpty() || !itemStack.isDamageable() ? -1 : itemStack.getMaxDamage() - itemStack.getDamage();
    }

    public static int pickaxe(PlayerInventory playerInventory) {
        if (playerInventory.getStack(0).isIn(ItemTags.PICKAXES)) {
            return 0;
        }
        int n = qof.bestPickaxe(playerInventory);
        if (n >= 0) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.getStack(i).isIn(ItemTags.PICKAXES)) continue;
            return i;
        }
        return -1;
    }

    public static int pickaxeDurability(ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack = clientPlayerEntity.getMainHandStack();
        if (itemStack.isIn(ItemTags.PICKAXES) && itemStack.isDamageable()) {
            return qpw.durability(itemStack);
        }
        int n = qpw.pickaxe(clientPlayerEntity.getInventory());
        if (n >= 0) {
            return qpw.durability(clientPlayerEntity.getInventory().getStack(n));
        }
        ItemStack itemStack2 = clientPlayerEntity.getOffHandStack();
        return itemStack2.isIn(ItemTags.PICKAXES) ? qpw.durability(itemStack2) : -1;
    }

    public static boolean isFood(ItemStack itemStack) {
        if (itemStack.isEmpty() || itemStack.get(DataComponentTypes.FOOD) == null) {
            return false;
        }
        return !itemStack.isOf(Items.ROTTEN_FLESH) && !itemStack.isOf(Items.SPIDER_EYE) && !itemStack.isOf(Items.POISONOUS_POTATO) && !itemStack.isOf(Items.PUFFERFISH) && !itemStack.isOf(Items.CHORUS_FRUIT) && !itemStack.isOf(Items.SUSPICIOUS_STEW) && !itemStack.isOf(Items.ENCHANTED_GOLDEN_APPLE);
    }

    public static boolean isLayoutItem(Item item) {
        if (item == Items.DIAMOND || item == Items.GOLD_INGOT || item == Items.ANCIENT_DEBRIS) {
            return true;
        }
        for (Item item2 : MARKERS) {
            if (item2 != item) continue;
            return true;
        }
        return false;
    }

    public static boolean isMarker(Item item) {
        for (Item item2 : MARKERS) {
            if (item2 != item) continue;
            return true;
        }
        return false;
    }

    public static boolean keeps(ItemStack itemStack) {
        BlockItem blockItem;
        if (itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.isIn(ItemTags.PICKAXES) || itemStack.isDamageable() || qpw.isFood(itemStack) || itemStack.isOf(Items.ENCHANTED_GOLDEN_APPLE)) {
            return true;
        }
        if (itemStack.isOf(Items.TOTEM_OF_UNDYING) || itemStack.isOf(Items.EXPERIENCE_BOTTLE) || itemStack.isOf(Items.NETHERITE_INGOT) || itemStack.isOf(Items.NETHERITE_SCRAP) || itemStack.isOf(Items.DIAMOND_BLOCK) || itemStack.isOf(Items.GOLD_BLOCK) || itemStack.isOf(Items.ENDER_PEARL) || itemStack.isOf(Items.ELYTRA) || itemStack.isOf(Items.EMERALD) || itemStack.isOf(Items.EMERALD_BLOCK) || itemStack.isOf(Items.NETHERITE_BLOCK)) {
            return true;
        }
        Item item = itemStack.getItem();
        return item instanceof BlockItem && (blockItem = (BlockItem)item).getBlock() instanceof ShulkerBoxBlock;
    }

    public static boolean throwable(ItemStack itemStack) {
        return !itemStack.isEmpty() && !qpw.keeps(itemStack) && !qpw.isLayoutItem(itemStack.getItem());
    }

    public static boolean ready(PlayerInventory playerInventory) {
        int n = 14 + (qpw.count(playerInventory, Items.ANCIENT_DEBRIS) == 0 ? 1 : 0);
        return qpw.count(playerInventory, Items.DIAMOND) >= 16 && qpw.count(playerInventory, Items.GOLD_INGOT) >= n;
    }

    public static int keepGold(PlayerInventory playerInventory) {
        return 14 + (qpw.count(playerInventory, Items.ANCIENT_DEBRIS) == 0 ? 1 : 0);
    }

    public static Item[] targets(PlayerInventory playerInventory, ItemStack itemStack) {
        int n;
        int n2;
        Item[] itemArray = (Item[])qpx.clone();
        if (qpw.count(playerInventory, Items.ANCIENT_DEBRIS) == 0) {
            itemArray[32] = Items.GOLD_INGOT;
        }
        for (n2 = 0; n2 < MARKERS.length; ++n2) {
            if (qpw.count(playerInventory, MARKERS[n2]) != 0) continue;
            itemArray[9 + n2] = null;
        }
        n2 = qpw.pickaxe(playerInventory);
        boolean bl = itemStack.isEmpty() || itemStack.isOf(Items.GOLDEN_CARROT);
        int n3 = 0;
        for (n = 0; n < 36; ++n) {
            ItemStack itemStack2 = playerInventory.getStack(n);
            if (itemStack2.isEmpty() || n == n2 || qpw.isLayoutItem(itemStack2.getItem()) || !qpw.keeps(itemStack2)) continue;
            if (bl && itemStack2.isOf(Items.GOLDEN_CARROT)) {
                bl = false;
                continue;
            }
            ++n3;
        }
        for (n = 1; n < 36; ++n) {
            if (itemArray[n] != null) continue;
            --n3;
        }
        for (n = qpy.length - 1; n >= 0 && n3 > 0; --n) {
            if (itemArray[qpy[n]] == null) continue;
            itemArray[qpw.qpy[n]] = null;
            --n3;
        }
        return itemArray;
    }

    public static int misplaced(PlayerInventory playerInventory, Item[] itemArray) {
        int n = 0;
        for (int i = 1; i < 36; ++i) {
            if (itemArray[i] == null || playerInventory.getStack(i).isOf(itemArray[i])) continue;
            ++n;
        }
        return n;
    }

    public static qpq next(PlayerInventory playerInventory, ItemStack itemStack, ItemStack itemStack2, Item[] itemArray, boolean[] blArray) {
        return qpw.next(playerInventory, itemStack, itemStack2, itemArray, blArray, false);
    }

    public static qpq next(PlayerInventory playerInventory, ItemStack itemStack, ItemStack itemStack2, Item[] itemArray, boolean[] blArray, boolean bl) {
        int n;
        if (!itemStack.isEmpty()) {
            if (itemStack.isOf(Items.GOLDEN_CARROT) && (itemStack2.isEmpty() || ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack2, (ItemStack)itemStack) && itemStack2.getCount() < itemStack2.getMaxCount())) {
                return new qpq(40, 0, SlotActionType.PICKUP);
            }
            return qpw.qqb(playerInventory, itemStack, itemArray, blArray, bl);
        }
        int n2 = qpw.pickaxe(playerInventory);
        if (n2 > 0 && !playerInventory.getStack(0).isIn(ItemTags.PICKAXES)) {
            return new qpq(n2, 0, SlotActionType.SWAP);
        }
        for (int n3 : qpy) {
            ItemStack itemStack3;
            Item item = itemArray[n3];
            if (item == null || blArray[n3] || (itemStack3 = playerInventory.getStack(n3)).isOf(item)) continue;
            if (!itemStack3.isEmpty()) {
                return new qpq(n3, 0, SlotActionType.PICKUP);
            }
            int n4 = qpw.qqc(playerInventory, itemArray, item);
            if (n4 < 0) {
                blArray[n3] = true;
                continue;
            }
            return new qpq(n4, 0, SlotActionType.PICKUP);
        }
        if (!itemStack2.isOf(Items.GOLDEN_CARROT) && itemStack2.isEmpty() && (n = qpw.find(playerInventory, Items.GOLDEN_CARROT)) >= 0) {
            return new qpq(n, 40, SlotActionType.SWAP);
        }
        return null;
    }

    private static qpq qqb(PlayerInventory playerInventory, ItemStack itemStack, Item[] itemArray, boolean[] blArray, boolean bl) {
        int n;
        Item item = itemStack.getItem();
        int[] nArray = qpy;
        int n2 = nArray.length;
        for (n = 0; n < n2; ++n) {
            int n3 = nArray[n];
            if (itemArray[n3] != item || blArray[n3] || !playerInventory.getStack(n3).isEmpty()) continue;
            return new qpq(n3, itemStack.getCount() > 1 ? 1 : 0, SlotActionType.PICKUP);
        }
        int n4 = -1;
        for (n2 = 0; n2 < 36; ++n2) {
            ItemStack itemStack2 = playerInventory.getStack(n2);
            if (itemStack2.isEmpty() || !ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack2, (ItemStack)itemStack) || itemStack2.getCount() >= itemStack2.getMaxCount() || n4 >= 0 && (itemArray[n2] != item || itemArray[n4] == item)) continue;
            n4 = n2;
        }
        if (n4 >= 0) {
            return new qpq(n4, 0, SlotActionType.PICKUP);
        }
        for (n2 = 35; n2 >= 1; --n2) {
            if (itemArray[n2] != null || !playerInventory.getStack(n2).isEmpty()) continue;
            return new qpq(n2, 0, SlotActionType.PICKUP);
        }
        if (!(bl || qpw.keeps(itemStack) || qpw.isLayoutItem(item))) {
            return new qpq(-999, 0, SlotActionType.PICKUP);
        }
        for (n2 = qpy.length - 1; n2 >= 0; --n2) {
            n = qpy[n2];
            if (!playerInventory.getStack(n).isEmpty()) continue;
            blArray[n] = true;
            return new qpq(n, 0, SlotActionType.PICKUP);
        }
        return bl ? null : new qpq(-999, 0, SlotActionType.PICKUP);
    }

    private static int qqc(PlayerInventory playerInventory, Item[] itemArray, Item item) {
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < 36; ++i) {
            int n3;
            boolean bl;
            ItemStack itemStack = playerInventory.getStack(i);
            if (!itemStack.isOf(item)) continue;
            boolean bl2 = bl = itemArray[i] == item;
            if (bl && itemStack.getCount() < 2 || (n3 = (bl ? 0 : 1000) + itemStack.getCount()) <= n2) continue;
            n2 = n3;
            n = i;
        }
        return n;
    }

    static {
        int n;
        MARKERS = new Item[]{Items.REDSTONE, Items.LAPIS_LAZULI, Items.IRON_INGOT, Items.COAL};
        qpx = new Item[36];
        for (n = 1; n <= 8; ++n) {
            qpw.qpx[n] = Items.DIAMOND;
        }
        for (n = 0; n < MARKERS.length; ++n) {
            qpw.qpx[9 + n] = MARKERS[n];
        }
        for (n = 13; n <= 26; ++n) {
            qpw.qpx[n] = Items.GOLD_INGOT;
        }
        for (n = 27; n <= 35; ++n) {
            qpw.qpx[n] = Items.DIAMOND;
        }
        qpw.qpx[32] = Items.ANCIENT_DEBRIS;
        int[] nArray = new int[35];
        int n2 = 0;
        int n3 = 9;
        while (n3 <= 12) {
            nArray[n2++] = n3++;
        }
        nArray[n2++] = 32;
        n3 = 13;
        while (n3 <= 26) {
            nArray[n2++] = n3++;
        }
        for (n3 = 27; n3 <= 35; ++n3) {
            if (n3 == 32) continue;
            nArray[n2++] = n3;
        }
        n3 = 1;
        while (n3 <= 8) {
            nArray[n2++] = n3++;
        }
        qpy = nArray;
    }

    private static /* synthetic */ int bub(int n, int n2) {
        return (n ^ n2) + 1868812387;
    }

    private static /* synthetic */ int buc(int n, int n2) {
        return qpw.bub(n, n2) * n2;
    }

    private static /* synthetic */ int bud(int n, int n2) {
        return n - n2 | 0xE8385A1A;
    }
}

