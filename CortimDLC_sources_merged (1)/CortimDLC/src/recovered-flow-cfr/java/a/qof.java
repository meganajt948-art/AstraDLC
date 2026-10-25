/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.Registries
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.screen.PlayerScreenHandler
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.text.Text
 */
package a;

import a.qoc;
import a.qpq;
import a.qpw;
import a.qsw;
import a.vyn;
import a.wdq;
import flow.dev.a;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public final class qof {
    private static final int qog = 420;
    private final vyn qoh = new vyn();
    private final Random qoi = new Random();
    private final ArrayDeque<int[]> qoj = new ArrayDeque();
    private final IntArrayList qok = new IntArrayList();
    private qoc qol = qoc.NONE;
    private int qom;
    private int qon;
    private boolean qoo;
    private int qop;
    private int qoq;
    private int qor;
    private Item[] qos;
    private boolean[] qot;
    private int qou;
    private boolean qov;
    private boolean qow;
    private int qox = -1;
    private int qoy = -1;
    private int qoz = -1;
    private int qpa = -1;
    private Item qpb;
    public boolean noThrow;
    private static /* synthetic */ String qpc;
    private static /* synthetic */ int qpd;

    public boolean busy() {
        return this.qol != qoc.NONE;
    }

    public qoc job() {
        return this.qol;
    }

    public int thrown() {
        return this.qop;
    }

    public boolean laidOut() {
        return this.qow;
    }

    public static int bestPickaxe(PlayerInventory playerInventory) {
        BlockState blockState = Blocks.field_10340.method_9564();
        int n = -1;
        double d = 0.0;
        for (int i = 0; i < 36; ++i) {
            String string;
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_7960() || !itemStack.method_31573(ItemTags.field_42614) || itemStack.method_7963() && itemStack.method_7936() - itemStack.method_7919() <= 5) continue;
            double d2 = itemStack.method_7924(blockState);
            int n2 = qof.qpo(itemStack);
            if (n2 > 0) {
                d2 += (double)(n2 * n2 + 1);
            }
            if ((string = qof.qpp(itemStack)).contains(a.b("\u8ec6\uf705\u7dae\ue3a8\u6807\ueebc\u54e6", 1289784048))) {
                d2 += 1000.0;
            }
            if (string.contains(a.d("\ud406\uadbb\u276b\ub914\u32c6\ub40d", 172131137, 390157181))) {
                d2 += 500.0;
            }
            if (i == playerInventory.method_67532()) {
                d2 += 0.5;
            } else if (i < 9) {
                d2 += 0.25;
            }
            if (!(d2 > d)) continue;
            d = d2;
            n = i;
        }
        return n;
    }

    public static boolean holdsPickaxe(ClientPlayerEntity clientPlayerEntity) {
        return clientPlayerEntity.method_6047().method_31573(ItemTags.field_42614);
    }

    public static boolean hasJunk(PlayerInventory playerInventory, Set<String> set) {
        for (int i = 0; i < 36; ++i) {
            if (!qof.qpe(playerInventory.method_5438(i), set)) continue;
            return true;
        }
        return false;
    }

    public static int empty(PlayerInventory playerInventory) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.method_5438(i).method_7960()) continue;
            ++n;
        }
        return n;
    }

    public static boolean isJunkStack(ItemStack itemStack, Set<String> set) {
        return qof.qpe(itemStack, set);
    }

    private static boolean qpe(ItemStack itemStack, Set<String> set) {
        return !itemStack.method_7960() && set.contains(Registries.field_41178.method_10221((Object)itemStack.method_7909()).toString());
    }

    public boolean equip(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        int n = qof.bestPickaxe(playerInventory);
        if (n < 0) {
            return false;
        }
        if (n < 9) {
            if (playerInventory.method_67532() != n) {
                playerInventory.method_61496(n);
            }
            return true;
        }
        if (this.qol == qoc.NONE) {
            this.qol = qoc.EQUIP;
            this.qom = 0;
        }
        return true;
    }

    public void dropJunk(int n) {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.JUNK);
            this.qoq = n;
            this.qon = 1;
        }
    }

    public void swaps(int ... nArray) {
        if (this.qol != qoc.NONE || nArray.length < 2) {
            return;
        }
        this.qoj.clear();
        int n = 0;
        while (n + 1 < nArray.length) {
            this.qoj.add(new int[]{nArray[n], nArray[n + 1]});
            n += 2;
        }
        this.qpf(qoc.SWAPS);
    }

    public void throwOne(int n) {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.THROW);
            this.qor = n;
        }
    }

    public void layout() {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.LAYOUT);
            this.qos = null;
            this.qov = false;
            this.qow = false;
        }
    }

    public void compact() {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.COMPACT);
        }
    }

    public void freeHand() {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.HAND);
            this.qox = -1;
        }
    }

    public void unstow(ClientPlayerEntity clientPlayerEntity) {
        if (this.qpa < 0 || this.qol != qoc.NONE) {
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        int n = this.qoz;
        int n2 = this.qpa;
        this.qpa = -1;
        if (playerInventory.method_5438(n).method_7960() && playerInventory.method_5438(n2).method_31574(this.qpb)) {
            this.swaps(n2, n);
        }
    }

    private void qpf(qoc qoc2) {
        this.qol = qoc2;
        this.qom = 0;
        this.qon = 0;
        this.qoo = false;
        this.qou = 0;
    }

    public void startTick(MinecraftClient minecraftClient) {
        if (this.qol != qoc.NONE) {
            this.qoh.hold(minecraftClient);
        }
    }

    public void endTick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Set<String> set) {
        boolean bl;
        boolean bl2;
        if (this.qol == qoc.NONE) {
            return;
        }
        boolean bl3 = bl2 = clientPlayerEntity.method_5805() && !clientPlayerEntity.method_7325() && clientPlayerEntity.field_7512 == clientPlayerEntity.field_7498;
        if (!bl2 || this.qol != qoc.LAYOUT && this.qol != qoc.COMPACT && this.qol != qoc.HAND && !wdq.canClick(clientPlayerEntity)) {
            qsw.log(a.d("\ufc65\u85d3\u0f18\u913f", -1859296817, -1221812793) + (Object)((Object)this.qol) + a.c(1060193063, "\u4315\u3ae7\ub036\u2e48\ua5d6\u2334\u9933\u1081\u8ed1\u0465\u83bc\u79c5\uf743\u6ee8\ue4f4\u621d\ud84b\u57c9") + bl2 + a.b("\ub7c8\uce31\u44eb\uda95\u5148\ud7f1\u6dab\ue44d\u7a5d", -452937759) + clientPlayerEntity.field_7512 + a.c(915444762, "\u9432\uedc0\u6705\uf973\u72a5\uf408\u4e46\uc7f8") + clientPlayerEntity.field_7498.method_34255() + a.c(-962717369, "\u196f\u608d\uea4e\u742e\uffee\u795f\uc307\u4aa5") + minecraftClient.field_1755);
            this.qpn(minecraftClient);
            return;
        }
        boolean bl4 = bl = vyn.serverIdle(clientPlayerEntity) && vyn.still(clientPlayerEntity) && !clientPlayerEntity.method_6115() && (minecraftClient.field_1761 == null || !minecraftClient.field_1761.method_2923());
        if (!bl) {
            if (++this.qom > 24) {
                this.qpn(minecraftClient);
            }
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        switch (this.qol.ordinal()) {
            case 1: {
                int n = qof.bestPickaxe(playerInventory);
                if (n >= 9) {
                    wdq.swap(minecraftClient, n, playerInventory.method_67532());
                }
                this.qpn(minecraftClient);
                break;
            }
            case 3: {
                int[] nArray = this.qoj.poll();
                if (nArray == null) {
                    this.qpm(minecraftClient);
                    return;
                }
                wdq.click(minecraftClient, nArray[0], nArray[1]);
                this.qoo = true;
                if (!this.qoj.isEmpty()) break;
                this.qpm(minecraftClient);
                break;
            }
            case 4: {
                if (!this.noThrow && !playerInventory.method_5438(this.qor).method_7960()) {
                    minecraftClient.field_1761.method_2906(clientPlayerEntity.field_7498.field_7763, wdq.slotId(this.qor), 0, SlotActionType.field_7795, (PlayerEntity)clientPlayerEntity);
                    this.qoo = true;
                    ++this.qop;
                }
                this.qpm(minecraftClient);
                break;
            }
            case 5: {
                this.qpl(minecraftClient, clientPlayerEntity, playerInventory, set);
                break;
            }
            case 6: {
                this.qpk(minecraftClient, clientPlayerEntity, playerInventory);
                break;
            }
            case 2: {
                this.qpg(minecraftClient, clientPlayerEntity, playerInventory, set);
                break;
            }
            case 7: {
                this.qph(minecraftClient, clientPlayerEntity, playerInventory, set);
                break;
            }
            default: {
                this.qpn(minecraftClient);
            }
        }
    }

    private void qpg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, PlayerInventory playerInventory, Set<String> set) {
        if (this.noThrow) {
            this.qpm(minecraftClient);
            return;
        }
        if (this.qon > 0) {
            --this.qon;
            return;
        }
        int n = playerInventory.method_67532();
        for (int i = 35; i >= 0 && this.qoq > 0; --i) {
            if (i == n || !qof.qpe(playerInventory.method_5438(i), set)) continue;
            --this.qoq;
            minecraftClient.field_1761.method_2906(clientPlayerEntity.field_7498.field_7763, wdq.slotId(i), 1, SlotActionType.field_7795, (PlayerEntity)clientPlayerEntity);
            this.qoo = true;
            ++this.qop;
            this.qon = this.qoi.nextInt(5) == 0 ? 1 : 0;
            return;
        }
        this.qpm(minecraftClient);
    }

    private void qph(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, PlayerInventory playerInventory, Set<String> set) {
        int n;
        int n2;
        PlayerScreenHandler playerScreenHandler = clientPlayerEntity.field_7498;
        if (this.qon > 0) {
            --this.qon;
            return;
        }
        if (this.qox >= 0) {
            minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(this.qox), 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
            if (!playerScreenHandler.method_34255().method_7960()) {
                minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(this.qoy), 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
            }
            this.qox = -1;
            this.qon = 1;
            return;
        }
        if (!playerScreenHandler.method_34255().method_7960()) {
            this.qpm(minecraftClient);
            return;
        }
        for (n2 = 0; n2 < 9; ++n2) {
            if (!playerInventory.method_5438(n2).method_7960()) continue;
            this.qpm(minecraftClient);
            return;
        }
        if (++this.qou > 6) {
            this.qpm(minecraftClient);
            return;
        }
        n2 = qof.qpi(playerInventory);
        for (n = 9; n < 36; ++n) {
            if (!playerInventory.method_5438(n).method_7960()) continue;
            this.qoz = n2;
            this.qpa = n;
            this.qpb = playerInventory.method_5438(n2).method_7909();
            wdq.click(minecraftClient, n, n2);
            this.qoo = true;
            this.qpm(minecraftClient);
            return;
        }
        for (n = 35; n >= 0 && !this.noThrow; --n) {
            if (!qof.qpe(playerInventory.method_5438(n), set)) continue;
            minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(n), 1, SlotActionType.field_7795, (PlayerEntity)clientPlayerEntity);
            this.qoo = true;
            ++this.qop;
            this.qon = 1;
            return;
        }
        int[] nArray = qof.qpj(playerInventory, n2);
        if (nArray == null) {
            this.qpm(minecraftClient);
            return;
        }
        this.qoy = nArray[0];
        minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(nArray[0]), 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
        this.qoo = true;
        this.qox = nArray[1];
        this.qon = 1;
    }

    private static int qpi(PlayerInventory playerInventory) {
        int n = playerInventory.method_67532();
        if (!playerInventory.method_5438(n).method_31573(ItemTags.field_42614)) {
            return n;
        }
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_31573(ItemTags.field_42614) || n2 >= 0 && itemStack.method_7947() >= playerInventory.method_5438(n2).method_7947()) continue;
            n2 = i;
        }
        return n2 >= 0 ? n2 : n;
    }

    private static int[] qpj(PlayerInventory playerInventory, int n) {
        int[] nArray = null;
        int n2 = Integer.MAX_VALUE;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_7960() || itemStack.method_7914() <= 1 || itemStack.method_31573(ItemTags.field_42614)) continue;
            for (int j = 0; j < 36; ++j) {
                int n3;
                ItemStack itemStack2 = playerInventory.method_5438(j);
                if (j == i || itemStack2.method_7960() || itemStack.method_7947() + itemStack2.method_7947() > itemStack2.method_7914() || !ItemStack.method_31577((ItemStack)itemStack, (ItemStack)itemStack2) || (n3 = (i == n ? 0 : (i < 9 ? 200 : 100)) + itemStack.method_7947()) >= n2) continue;
                n2 = n3;
                nArray = new int[]{i, j};
            }
        }
        return nArray;
    }

    private void qpk(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, PlayerInventory playerInventory) {
        int n;
        PlayerScreenHandler playerScreenHandler = clientPlayerEntity.field_7498;
        int n2 = -1;
        int n3 = -1;
        if (playerScreenHandler.method_34255().method_7960() && ++this.qou < 120) {
            for (n = 0; n < 36 && n2 < 0; ++n) {
                ItemStack itemStack = playerInventory.method_5438(n);
                if (itemStack.method_7960() || itemStack.method_7947() >= itemStack.method_7914()) continue;
                for (int i = 0; i < 36; ++i) {
                    ItemStack itemStack2 = playerInventory.method_5438(i);
                    if (i == n || itemStack2.method_7960() || itemStack2.method_7947() >= itemStack2.method_7914() || !ItemStack.method_31577((ItemStack)itemStack, (ItemStack)itemStack2) || n3 >= 0 && itemStack2.method_7947() <= playerInventory.method_5438(n3).method_7947()) continue;
                    n3 = i;
                }
                if (n3 < 0) continue;
                n2 = itemStack.method_7947() <= playerInventory.method_5438(n3).method_7947() ? n : n3;
                n3 = n2 == n ? n3 : n;
            }
        }
        if (n2 < 0) {
            if (!playerScreenHandler.method_34255().method_7960()) {
                n = qpw.emptySlot(playerInventory);
                minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, n >= 0 ? wdq.slotId(n) : -999, 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
            }
            this.qpm(minecraftClient);
            return;
        }
        minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(n2), 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
        minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(n3), 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
        if (!playerScreenHandler.method_34255().method_7960()) {
            minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(n2), 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
        }
        this.qoo = true;
    }

    private void qpl(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, PlayerInventory playerInventory, Set<String> set) {
        PlayerScreenHandler playerScreenHandler = clientPlayerEntity.field_7498;
        if (!this.qov) {
            this.qov = true;
            this.qok.clear();
            for (int i = 0; i < 36 && !this.noThrow; ++i) {
                ItemStack itemStack = playerInventory.method_5438(i);
                if (!qpw.throwable(itemStack) && !qof.qpe(itemStack, set)) continue;
                this.qok.add(i);
            }
            for (Item item : this.noThrow ? new Item[]{} : qpw.MARKERS) {
                int n = qpw.find(playerInventory, item);
                for (int i = 0; i < 36; ++i) {
                    if (i == n || !playerInventory.method_5438(i).method_31574(item)) continue;
                    this.qok.add(i);
                }
            }
        }
        if (!this.qok.isEmpty() && playerScreenHandler.method_34255().method_7960()) {
            int n = this.qok.removeInt(this.qok.size() - 1);
            if (!playerInventory.method_5438(n).method_7960()) {
                minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, wdq.slotId(n), 1, SlotActionType.field_7795, (PlayerEntity)clientPlayerEntity);
                this.qoo = true;
                ++this.qop;
            }
            return;
        }
        if (this.qos == null) {
            this.qos = qpw.targets(playerInventory, clientPlayerEntity.method_6079());
            this.qot = new boolean[36];
        }
        for (int i = 0; i < 2; ++i) {
            qpq qpq2 = qpw.next(playerInventory, playerScreenHandler.method_34255(), clientPlayerEntity.method_6079(), this.qos, this.qot, this.noThrow);
            int n = 0;
            if (qpq2 != null && this.noThrow && qpq2.slot() == -999) {
                qpq2 = null;
                n = 1;
            }
            if (qpq2 == null || ++this.qou > 420) {
                int n2;
                boolean bl = this.qow = qpq2 == null && n == 0;
                if (!(playerScreenHandler.method_34255().method_7960() || (n2 = qpw.emptySlot(playerInventory)) < 0 && this.noThrow)) {
                    minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, n2 >= 0 ? wdq.slotId(n2) : -999, 0, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
                }
                this.qpm(minecraftClient);
                return;
            }
            int n3 = qpq2.slot() == -999 ? -999 : (qpq2.slot() == 40 ? 45 : wdq.slotId(qpq2.slot()));
            minecraftClient.field_1761.method_2906(playerScreenHandler.field_7763, n3, qpq2.button(), qpq2.type(), (PlayerEntity)clientPlayerEntity);
            this.qoo = true;
            if (qpq2.type() == SlotActionType.field_7790) continue;
            return;
        }
    }

    private void qpm(MinecraftClient minecraftClient) {
        if (this.qoo) {
            wdq.close(minecraftClient);
        }
        this.qpn(minecraftClient);
    }

    public void cancel(MinecraftClient minecraftClient) {
        if (this.qoo && minecraftClient.field_1724 != null) {
            wdq.close(minecraftClient);
        }
        this.qpn(minecraftClient);
    }

    private void qpn(MinecraftClient minecraftClient) {
        if (this.qol != qoc.NONE) {
            qsw.log(a.d("\u99db\ue06d\u6aa6\uf481", -1205381147, -1964061101) + (Object)((Object)this.qol) + a.d("\u1ac5\u633b\ue9f1\u7793\ufc53\u7abc\uc0e3\u4945\ud70c\u5db5\uda7b\u201b\uaecd\u3738", 2095411800, 244345011) + this.qom + (this.qoo ? a.c(-1773078270, "\uf927\u809a\u0a0a\u9474\u1fa6\u991d\u2346\uaab9\u34e7") : a.d("\ue22b\u9b96\u110b\u8f7b\u04e3\u8211\u384d\ub1b9\u2fec\ua555", 783832303, -1532905758)));
        }
        this.qol = qoc.NONE;
        this.qoo = false;
        this.qom = 0;
        this.qoj.clear();
        this.qok.clear();
        if (this.qoh.isHeld()) {
            this.qoh.release(minecraftClient);
        }
    }

    private static int qpo(ItemStack itemStack) {
        for (Object2IntMap.Entry entry : itemStack.method_58657().method_57539()) {
            if (!((RegistryEntry)entry.getKey()).method_40225(Enchantments.field_9131)) continue;
            return entry.getIntValue();
        }
        return 0;
    }

    private static String qpp(ItemStack itemStack) {
        StringBuilder stringBuilder = new StringBuilder();
        LoreComponent loreComponent = (LoreComponent)itemStack.method_58694(DataComponentTypes.field_49632);
        if (loreComponent != null) {
            for (Text text : loreComponent.comp_2400()) {
                stringBuilder.append(text.getString()).append('\n');
            }
        }
        stringBuilder.append(itemStack.method_7964().getString());
        return stringBuilder.toString().toLowerCase(Locale.ROOT);
    }

    private static /* synthetic */ int btt(int n, int n2) {
        return n * n2 + 1285789881;
    }

    private static /* synthetic */ int btu(int n, int n2) {
        return qof.btt(n, n2) * n2;
    }
}

