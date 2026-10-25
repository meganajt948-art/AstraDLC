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
            ItemStack itemStack = playerInventory.method_5438(i);
            if (!itemStack.method_31574(item)) continue;
            n += itemStack.method_7947();
        }
        return n;
    }

    public static int countAll(PlayerEntity playerEntity, Item item) {
        ItemStack itemStack = playerEntity.method_6079();
        return qpw.count(playerEntity.method_31548(), item) + (itemStack.method_31574(item) ? itemStack.method_7947() : 0);
    }

    public static int food(PlayerEntity playerEntity) {
        return qpw.countAll(playerEntity, Items.field_8071);
    }

    public static int find(PlayerInventory playerInventory, Item item) {
        int n = -1;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (!itemStack.method_31574(item) || n >= 0 && itemStack.method_7947() <= playerInventory.method_5438(n).method_7947()) continue;
            n = i;
        }
        return n;
    }

    public static int emptySlot(PlayerInventory playerInventory) {
        for (int i = 35; i >= 0; --i) {
            if (!playerInventory.method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    public static int durability(ItemStack itemStack) {
        return itemStack.method_7960() || !itemStack.method_7963() ? -1 : itemStack.method_7936() - itemStack.method_7919();
    }

    public static int pickaxe(PlayerInventory playerInventory) {
        if (playerInventory.method_5438(0).method_31573(ItemTags.field_42614)) {
            return 0;
        }
        int n = qof.bestPickaxe(playerInventory);
        if (n >= 0) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.method_5438(i).method_31573(ItemTags.field_42614)) continue;
            return i;
        }
        return -1;
    }

    public static int pickaxeDurability(ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack = clientPlayerEntity.method_6047();
        if (itemStack.method_31573(ItemTags.field_42614) && itemStack.method_7963()) {
            return qpw.durability(itemStack);
        }
        int n = qpw.pickaxe(clientPlayerEntity.method_31548());
        if (n >= 0) {
            return qpw.durability(clientPlayerEntity.method_31548().method_5438(n));
        }
        ItemStack itemStack2 = clientPlayerEntity.method_6079();
        return itemStack2.method_31573(ItemTags.field_42614) ? qpw.durability(itemStack2) : -1;
    }

    public static boolean isFood(ItemStack itemStack) {
        if (itemStack.method_7960() || itemStack.method_58694(DataComponentTypes.field_50075) == null) {
            return false;
        }
        return !itemStack.method_31574(Items.field_8511) && !itemStack.method_31574(Items.field_8680) && !itemStack.method_31574(Items.field_8635) && !itemStack.method_31574(Items.field_8323) && !itemStack.method_31574(Items.field_8233) && !itemStack.method_31574(Items.field_8766) && !itemStack.method_31574(Items.field_8367);
    }

    public static boolean isLayoutItem(Item item) {
        if (item == Items.field_8477 || item == Items.field_8695 || item == Items.field_22019) {
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
        if (itemStack.method_7960()) {
            return false;
        }
        if (itemStack.method_31573(ItemTags.field_42614) || itemStack.method_7963() || qpw.isFood(itemStack) || itemStack.method_31574(Items.field_8367)) {
            return true;
        }
        if (itemStack.method_31574(Items.field_8288) || itemStack.method_31574(Items.field_8287) || itemStack.method_31574(Items.field_22020) || itemStack.method_31574(Items.field_22021) || itemStack.method_31574(Items.field_8603) || itemStack.method_31574(Items.field_8494) || itemStack.method_31574(Items.field_8634) || itemStack.method_31574(Items.field_8833) || itemStack.method_31574(Items.field_8687) || itemStack.method_31574(Items.field_8733) || itemStack.method_31574(Items.field_22018)) {
            return true;
        }
        Item item = itemStack.method_7909();
        return item instanceof BlockItem && (blockItem = (BlockItem)item).method_7711() instanceof ShulkerBoxBlock;
    }

    public static boolean throwable(ItemStack itemStack) {
        return !itemStack.method_7960() && !qpw.keeps(itemStack) && !qpw.isLayoutItem(itemStack.method_7909());
    }

    public static boolean ready(PlayerInventory playerInventory) {
        int n = 14 + (qpw.count(playerInventory, Items.field_22019) == 0 ? 1 : 0);
        return qpw.count(playerInventory, Items.field_8477) >= 16 && qpw.count(playerInventory, Items.field_8695) >= n;
    }

    public static int keepGold(PlayerInventory playerInventory) {
        return 14 + (qpw.count(playerInventory, Items.field_22019) == 0 ? 1 : 0);
    }

    public static Item[] targets(PlayerInventory playerInventory, ItemStack itemStack) {
        int n;
        int n2;
        Item[] itemArray = (Item[])qpx.clone();
        if (qpw.count(playerInventory, Items.field_22019) == 0) {
            itemArray[32] = Items.field_8695;
        }
        for (n2 = 0; n2 < MARKERS.length; ++n2) {
            if (qpw.count(playerInventory, MARKERS[n2]) != 0) continue;
            itemArray[9 + n2] = null;
        }
        n2 = qpw.pickaxe(playerInventory);
        boolean bl = itemStack.method_7960() || itemStack.method_31574(Items.field_8071);
        int n3 = 0;
        for (n = 0; n < 36; ++n) {
            ItemStack itemStack2 = playerInventory.method_5438(n);
            if (itemStack2.method_7960() || n == n2 || qpw.isLayoutItem(itemStack2.method_7909()) || !qpw.keeps(itemStack2)) continue;
            if (bl && itemStack2.method_31574(Items.field_8071)) {
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
            if (itemArray[i] == null || playerInventory.method_5438(i).method_31574(itemArray[i])) continue;
            ++n;
        }
        return n;
    }

    public static qpq next(PlayerInventory playerInventory, ItemStack itemStack, ItemStack itemStack2, Item[] itemArray, boolean[] blArray) {
        return qpw.next(playerInventory, itemStack, itemStack2, itemArray, blArray, false);
    }

    public static qpq next(PlayerInventory playerInventory, ItemStack itemStack, ItemStack itemStack2, Item[] itemArray, boolean[] blArray, boolean bl) {
        int n;
        if (!itemStack.method_7960()) {
            if (itemStack.method_31574(Items.field_8071) && (itemStack2.method_7960() || ItemStack.method_31577((ItemStack)itemStack2, (ItemStack)itemStack) && itemStack2.method_7947() < itemStack2.method_7914())) {
                return new qpq(40, 0, SlotActionType.field_7790);
            }
            return qpw.qqb(playerInventory, itemStack, itemArray, blArray, bl);
        }
        int n2 = qpw.pickaxe(playerInventory);
        if (n2 > 0 && !playerInventory.method_5438(0).method_31573(ItemTags.field_42614)) {
            return new qpq(n2, 0, SlotActionType.field_7791);
        }
        for (int n3 : qpy) {
            ItemStack itemStack3;
            Item item = itemArray[n3];
            if (item == null || blArray[n3] || (itemStack3 = playerInventory.method_5438(n3)).method_31574(item)) continue;
            if (!itemStack3.method_7960()) {
                return new qpq(n3, 0, SlotActionType.field_7790);
            }
            int n4 = qpw.qqc(playerInventory, itemArray, item);
            if (n4 < 0) {
                blArray[n3] = true;
                continue;
            }
            return new qpq(n4, 0, SlotActionType.field_7790);
        }
        if (!itemStack2.method_31574(Items.field_8071) && itemStack2.method_7960() && (n = qpw.find(playerInventory, Items.field_8071)) >= 0) {
            return new qpq(n, 40, SlotActionType.field_7791);
        }
        return null;
    }

    private static qpq qqb(PlayerInventory playerInventory, ItemStack itemStack, Item[] itemArray, boolean[] blArray, boolean bl) {
        int n;
        Item item = itemStack.method_7909();
        int[] nArray = qpy;
        int n2 = nArray.length;
        for (n = 0; n < n2; ++n) {
            int n3 = nArray[n];
            if (itemArray[n3] != item || blArray[n3] || !playerInventory.method_5438(n3).method_7960()) continue;
            return new qpq(n3, itemStack.method_7947() > 1 ? 1 : 0, SlotActionType.field_7790);
        }
        int n4 = -1;
        for (n2 = 0; n2 < 36; ++n2) {
            ItemStack itemStack2 = playerInventory.method_5438(n2);
            if (itemStack2.method_7960() || !ItemStack.method_31577((ItemStack)itemStack2, (ItemStack)itemStack) || itemStack2.method_7947() >= itemStack2.method_7914() || n4 >= 0 && (itemArray[n2] != item || itemArray[n4] == item)) continue;
            n4 = n2;
        }
        if (n4 >= 0) {
            return new qpq(n4, 0, SlotActionType.field_7790);
        }
        for (n2 = 35; n2 >= 1; --n2) {
            if (itemArray[n2] != null || !playerInventory.method_5438(n2).method_7960()) continue;
            return new qpq(n2, 0, SlotActionType.field_7790);
        }
        if (!(bl || qpw.keeps(itemStack) || qpw.isLayoutItem(item))) {
            return new qpq(-999, 0, SlotActionType.field_7790);
        }
        for (n2 = qpy.length - 1; n2 >= 0; --n2) {
            n = qpy[n2];
            if (!playerInventory.method_5438(n).method_7960()) continue;
            blArray[n] = true;
            return new qpq(n, 0, SlotActionType.field_7790);
        }
        return bl ? null : new qpq(-999, 0, SlotActionType.field_7790);
    }

    private static int qqc(PlayerInventory playerInventory, Item[] itemArray, Item item) {
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < 36; ++i) {
            int n3;
            boolean bl;
            ItemStack itemStack = playerInventory.method_5438(i);
            if (!itemStack.method_31574(item)) continue;
            boolean bl2 = bl = itemArray[i] == item;
            if (bl && itemStack.method_7947() < 2 || (n3 = (bl ? 0 : 1000) + itemStack.method_7947()) <= n2) continue;
            n2 = n3;
            n = i;
        }
        return n;
    }

    static {
        int n;
        MARKERS = new Item[]{Items.field_8725, Items.field_8759, Items.field_8620, Items.field_8713};
        qpx = new Item[36];
        for (n = 1; n <= 8; ++n) {
            qpw.qpx[n] = Items.field_8477;
        }
        for (n = 0; n < MARKERS.length; ++n) {
            qpw.qpx[9 + n] = MARKERS[n];
        }
        for (n = 13; n <= 26; ++n) {
            qpw.qpx[n] = Items.field_8695;
        }
        for (n = 27; n <= 35; ++n) {
            qpw.qpx[n] = Items.field_8477;
        }
        qpw.qpx[32] = Items.field_22019;
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

