/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.CraftingScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import a.qbf;
import a.qbi;
import a.qbl;
import a.qsw;
import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

final class qbo {
    static final int XP_DIAMOND_BLOCKS = 15;
    private final ArrayDeque<qbf> qbp = new ArrayDeque();
    private final List<String> qbq = new ArrayList<String>();
    private int qbr;
    private int qbs;
    private int qbt = -1;
    private int qbu;
    private boolean qbv;
    private int qbw = -1;
    private int qbx;
    private int qby;
    private static /* synthetic */ int qbz;
    private static /* synthetic */ long qca;

    qbo() {
    }

    void plan(boolean bl, int n) {
        this.qbp.clear();
        this.qbq.clear();
        this.qbr = 0;
        this.qbs = 0;
        this.qbt = -1;
        this.qbu = 0;
        this.qbv = false;
        this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
        this.qcb();
        if (bl) {
            this.qbp.add(new qbf(qbi.PLAN_XP, null, null, 0));
        }
        this.qbp.add(new qbf(qbi.KEEP, Items.DIAMOND, Items.DIAMOND_BLOCK, 16));
        this.qbp.add(new qbf(qbi.KEEP, Items.GOLD_INGOT, Items.GOLD_BLOCK, n));
        this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
    }

    private void qcb() {
        this.qbp.add(new qbf(qbi.COMPRESS, Items.GOLD_NUGGET, Items.GOLD_INGOT, 0));
        this.qbp.add(new qbf(qbi.COMPRESS, Items.GOLD_INGOT, Items.GOLD_BLOCK, 0));
        this.qbp.add(new qbf(qbi.COMPRESS, Items.DIAMOND, Items.DIAMOND_BLOCK, 0));
    }

    List<String> notes() {
        return this.qbq;
    }

    boolean xpFailed() {
        return this.qbv;
    }

    boolean tick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler) {
        if (this.qbr > 0) {
            --this.qbr;
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            qbf qbf2 = this.qbp.peek();
            if (qbf2 == null) {
                return true;
            }
            if (!craftingScreenHandler.getCursorStack().isEmpty() && qbf2.kind != qbi.CLEAR) {
                qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, -1);
                return false;
            }
            qbl qbl2 = this.qcc(minecraftClient, clientPlayerEntity, craftingScreenHandler, qbf2);
            if (qbl2 != qbl.WAIT && qsw.trace != null) {
                qsw.log(a.c(1515772726, "\udb53\ua2f3\u2833\ub645\u3d80\ubb65") + (Object)((Object)qbf2.kind) + (qbf2.item == null ? "" : a.b("\u9d1c", 2110823741) + qbf2.item) + a.c(635152340, "\ua7f5") + (Object)((Object)qbl2) + a.d("\u3515\u4ce3\uc625\u584f\ud395\u557d", -1113159271, -2125218646) + qbo.qck(craftingScreenHandler) + a.c(1518769935, "\u972a\ueed4\u641d\ufa6d\u71f3") + craftingScreenHandler.getOutputSlot().getStack());
            }
            if (qbl2 == qbl.DONE || qbl2 == qbl.FAIL) {
                if (this.qbp.peek() == qbf2) {
                    this.qbp.poll();
                }
                if (qbl2 == qbl.FAIL) {
                    this.qbp.addFirst(new qbf(qbi.CLEAR, null, null, 0));
                }
                this.qbs = 0;
                this.qbt = -1;
                this.qbu = 0;
                continue;
            }
            if (qbl2 != qbl.WAIT) continue;
            return false;
        }
        return false;
    }

    private qbl qcc(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, qbf qbf2) {
        List list = craftingScreenHandler.getInputSlots();
        return switch (qbf2.kind.ordinal()) {
            default -> throw new MatchException(null, null);
            case 6 -> this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
            case 0 -> this.qcd(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, qbf2);
            case 1 -> this.qce(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, qbf2);
            case 2 -> this.qcf(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, qbf2);
            case 3 -> this.qcg(minecraftClient, clientPlayerEntity, craftingScreenHandler, list);
            case 4 -> this.qch(clientPlayerEntity, craftingScreenHandler);
            case 5 -> {
                int var6_6 = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item);
                if (var6_6 >= qbf2.amount || qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.result) == 0) {
                    yield qbl.DONE;
                }
                this.qbp.poll();
                this.qbp.addFirst(new qbf(qbi.UNPACK, qbf2.result, qbf2.item, Math.min(qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.result), (qbf2.amount - var6_6 + 8) / 9)));
                yield qbl.ACT;
            }
        };
    }

    private qbl qcd(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, List<Slot> list, qbf qbf2) {
        if (qbo.qcl(list, qbf2.item, null)) {
            return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, qbf2.item);
        }
        int n = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item);
        int n2 = Integer.MAX_VALUE;
        int n3 = 0;
        for (Slot slot2 : list) {
            n2 = Math.min(n2, slot2.getStack().getCount());
            n3 += slot2.getStack().getCount();
        }
        if (n >= 9 && n2 < 64) {
            Slot slot = qbo.qcs((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item);
            if (slot.getStack().getCount() < 9) {
                Slot slot2;
                slot2 = qbo.qct((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item, slot);
                qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id, 0, SlotActionType.PICKUP);
                qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.PICKUP);
                qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id);
                return qbl.ACT;
            }
            int n4 = slot.id;
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, n4, 0, SlotActionType.PICKUP);
            qbo.qcr(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, list);
            qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, n4);
            return qbl.ACT;
        }
        if (n2 >= 1) {
            return this.qci(minecraftClient, clientPlayerEntity, craftingScreenHandler, qbf2.result);
        }
        if (n3 > 0) {
            return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
        }
        return qbl.DONE;
    }

    private qbl qce(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, List<Slot> list, qbf qbf2) {
        Slot slot = list.get(4);
        if (qbo.qcl(list, qbf2.item, slot)) {
            return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
        }
        if (!qbf2.started) {
            qbf2.started = true;
            int n = slot.getStack().getCount();
            if (n < qbf2.amount && qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item) > 0) {
                Slot slot2 = qbo.qcs((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item);
                int n2 = qbf2.amount - n;
                qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id, 0, SlotActionType.PICKUP);
                if (craftingScreenHandler.getCursorStack().getCount() <= n2) {
                    qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.PICKUP);
                } else {
                    for (int i = 0; i < n2; ++i) {
                        qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 1, SlotActionType.PICKUP);
                    }
                }
                qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id);
                return qbl.ACT;
            }
        }
        if (slot.hasStack()) {
            return this.qci(minecraftClient, clientPlayerEntity, craftingScreenHandler, qbf2.result);
        }
        return qbl.DONE;
    }

    private qbl qcf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, List<Slot> list, qbf qbf2) {
        Slot slot = list.get(4);
        if (qbo.qcl(list, qbf2.item, slot)) {
            return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
        }
        if (!slot.hasStack()) {
            int n = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.result);
            if (qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item) == 0 || qbf2.amount > 0 && n >= qbf2.amount) {
                return qbl.DONE;
            }
            int n2 = qbf2.amount > 0 ? (qbf2.amount - n + 8) / 9 : 64;
            Slot slot2 = qbo.qcs((ScreenHandler)craftingScreenHandler, clientPlayerEntity, qbf2.item);
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id, 0, SlotActionType.PICKUP);
            if (craftingScreenHandler.getCursorStack().getCount() <= n2 || n2 > 12) {
                qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.PICKUP);
            } else {
                for (int i = 0; i < n2; ++i) {
                    qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 1, SlotActionType.PICKUP);
                }
            }
            qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id);
            return qbl.ACT;
        }
        return this.qci(minecraftClient, clientPlayerEntity, craftingScreenHandler, qbf2.result);
    }

    private qbl qcg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, List<Slot> list) {
        Object object3;
        if (this.qbv) {
            return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
        }
        Slot slot = list.get(4);
        List<Slot> list2 = List.of(list.get(1), list.get(3), list.get(5), list.get(7));
        for (int n : new int[]{0, 2, 6, 8}) {
            if (!list.get(n).hasStack()) continue;
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, list.get((int)n).id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
        }
        if (slot.hasStack() && !slot.getStack().isOf(Items.DIAMOND)) {
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
        }
        Object object2 = list2.iterator();
        while (object2.hasNext()) {
            Slot slot2 = (Slot)object2.next();
            if (!slot2.hasStack() || slot2.getStack().isOf(Items.GOLD_NUGGET)) continue;
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot2.id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
        }
        int n = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.DIAMOND);
        int n2 = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.GOLD_NUGGET);
        int n3 = 0;
        for (Object object3 : list2) {
            if (object3.hasStack()) continue;
            ++n3;
        }
        if (!slot.hasStack() && n == 0 || n3 > 0 && n2 < Math.max(4, n3)) {
            return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
        }
        if (slot.getStack().getCount() < 64 && n > 0) {
            Slot slot3 = qbo.qcs((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.DIAMOND);
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot3.id, 0, SlotActionType.PICKUP);
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.PICKUP);
            qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot3.id);
            return qbl.ACT;
        }
        int n4 = Integer.MAX_VALUE;
        for (Slot slot4 : list2) {
            n4 = Math.min(n4, slot4.getStack().getCount());
        }
        if (n4 < 64 && n2 >= 4) {
            object3 = qbo.qcs((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.GOLD_NUGGET);
            if (object3.getStack().getCount() < 4) {
                Slot slot4;
                slot4 = qbo.qct((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.GOLD_NUGGET, object3);
                qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot4.id, 0, SlotActionType.PICKUP);
                qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, object3.id, 0, SlotActionType.PICKUP);
                qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot4.id);
                return qbl.ACT;
            }
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, object3.id, 0, SlotActionType.PICKUP);
            qbo.qcr(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, list2);
            qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, object3.id);
            return qbl.ACT;
        }
        if (slot.hasStack() && n4 >= 1) {
            object3 = this.qci(minecraftClient, clientPlayerEntity, craftingScreenHandler, null);
            if (object3 == qbl.FAIL && this.qbs < 0) {
                this.qbv = true;
                this.qbq.add(a.b("\u9ed9\ue71c\u6dba\uf3b9\u7869\ufead\u409e\ucd72\u5325\udd81\u5e46\ua433\u2aef\ub745\u390c\ubf87\u05b8\u8a1d\u10a8\u929b\u1f72\u6522\uebe5\u703d\uf630\u78f1\uc14a\u4b03\ud1ff\u57a9\udc16\u22c0\uac98\u3562\ub33a\u399f\u865c\u084c\u8eee\u1753\u9d0e\ue381\u69ac\uee17\u74ce\ufab5\u477f", 546020023));
            }
            return object3;
        }
        return this.qcj(minecraftClient, clientPlayerEntity, craftingScreenHandler, list, null);
    }

    private qbl qch(ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler) {
        int n = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.DIAMOND_BLOCK);
        int n2 = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.DIAMOND);
        int n3 = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.GOLD_BLOCK);
        int n4 = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.GOLD_INGOT);
        int n5 = qbo.count((ScreenHandler)craftingScreenHandler, clientPlayerEntity, Items.GOLD_NUGGET);
        int n6 = Math.min(15, n - 2);
        if (n6 <= 0) {
            this.qbq.add(a.b("\u7b10\u02ad\u8875\u1601\u99c8\u1b69\ua131\u28c7\ub694\u3c22\ubbf8\u4185\ucb40\u56ec\udcb2\u5e53\ue002\u6fd2\uf515\u734d", 1067745080));
            return qbl.DONE;
        }
        int n7 = n4 * 9 + n5;
        int n8 = 4 * (n6 * 9 + n2);
        int n9 = Math.max(0, Math.min(n3 - 2, (n8 - n7 + 80) / 81));
        if (n7 + n9 * 81 < 4) {
            this.qbq.add(a.d("\u91ff\ue842\u629a\ufcee\u7327\uf181\u4bdb\uc22f\u5c75\ud6b8\u5119\uaf78\u25b2\ubc0e\u324d\ub0a2\u0aec\u8549\u1ff3", 2107579766, -204502874));
            return qbl.DONE;
        }
        ArrayList<qbf> arrayList = new ArrayList<qbf>();
        arrayList.add(new qbf(qbi.UNPACK, Items.DIAMOND_BLOCK, Items.DIAMOND, n6));
        if (n9 > 0) {
            arrayList.add(new qbf(qbi.UNPACK, Items.GOLD_BLOCK, Items.GOLD_INGOT, n9));
        }
        arrayList.add(new qbf(qbi.SPLIT, Items.GOLD_INGOT, Items.GOLD_NUGGET, n8));
        arrayList.add(new qbf(qbi.XP, null, null, 0));
        arrayList.add(new qbf(qbi.CLEAR, null, null, 0));
        arrayList.add(new qbf(qbi.COMPRESS, Items.GOLD_NUGGET, Items.GOLD_INGOT, 0));
        arrayList.add(new qbf(qbi.COMPRESS, Items.GOLD_INGOT, Items.GOLD_BLOCK, 0));
        arrayList.add(new qbf(qbi.COMPRESS, Items.DIAMOND, Items.DIAMOND_BLOCK, 0));
        this.qbp.poll();
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            this.qbp.addFirst((qbf)arrayList.get(i));
        }
        return qbl.DONE;
    }

    private qbl qci(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, Item item) {
        boolean bl;
        Slot slot = craftingScreenHandler.getOutputSlot();
        ItemStack itemStack = slot.getStack();
        boolean bl2 = item != null ? !itemStack.isOf(item) : (bl = itemStack.isOf(Items.GOLD_NUGGET) || itemStack.isOf(Items.GOLD_INGOT) || itemStack.isOf(Items.GOLD_BLOCK) || itemStack.isOf(Items.DIAMOND) || itemStack.isOf(Items.DIAMOND_BLOCK));
        if (!slot.hasStack() || bl) {
            if (++this.qbs > qbo.qcp(minecraftClient, clientPlayerEntity)) {
                this.qbs = -1;
                if (item != null) {
                    this.qbq.add(a.b("\u219e\u5828\ud28e\u4cfe\uc72a\u41e9\ufbb0\u765b\uec19\u66a0\ue566\u1b03\u95d0\u0c6a\u8222", 1126507939) + item.getName().getString());
                }
                return qbl.FAIL;
            }
            return qbl.WAIT;
        }
        this.qbs = 0;
        int n = qbo.qcm(craftingScreenHandler.getInputSlots());
        if (n == this.qbt) {
            if (++this.qbu >= 3) {
                this.qbq.add(a.c(-1890441319, "\u2384\u5a3d\ud099\u4a8a\uc541\u43f9\uf9de\u702c\uee01\u60a0\ue361\u1d02\u97cd\u0e79\u8425\u02d3\ub894\u373a\uadfb\u2bda\ua258\udc1c\u56bb\ucd65\u4b6e\uc5d0\u7879\uf652\u6cd5\ueaf0\u6145\u9fe6"));
                return qbl.FAIL;
            }
        } else {
            this.qbu = 0;
        }
        this.qbt = n;
        qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
        this.qbr = qbo.qco(minecraftClient, clientPlayerEntity);
        return qbl.ACT;
    }

    private qbl qcj(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, CraftingScreenHandler craftingScreenHandler, List<Slot> list, Item item) {
        if (!craftingScreenHandler.getCursorStack().isEmpty()) {
            qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, -1);
            return qbl.ACT;
        }
        for (Slot slot : list) {
            if (!slot.hasStack() || item != null && slot.getStack().isOf(item)) continue;
            int n = slot.getStack().getCount();
            if (slot.id == this.qbw && n == this.qbx) {
                if (++this.qby > 4) {
                    this.qbq.add(a.c(1035572653, "\u91a0\ue819\u62bd\uf8ae\u7765\uf1dd\u4bfa\uc208\u5c25\ud284\u5145\uaf26\u25e9\ubc5d\u3601\ub0f7\u0ab0\u851e\u1fdf\u99fe\u107c\u6e34\ue08b\u7f3d\uf935\u7395\uca25\u447a\udae1\u58ae\ud362\u2db0\ua78d\u3e77\ub82f\u32ef\u8d35\u0328\u81e9\u1c4a\u9207\uecf1\u66d7\ue167\u7bb3\uf5b0\u4c69\uc6d7"));
                    return qbl.DONE;
                }
            } else {
                this.qby = 0;
            }
            this.qbw = slot.id;
            this.qbx = n;
            qbo.qcq(minecraftClient, clientPlayerEntity, (ScreenHandler)craftingScreenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
        }
        return qbl.DONE;
    }

    private static String qck(CraftingScreenHandler craftingScreenHandler) {
        StringBuilder stringBuilder = new StringBuilder(a.c(344476069, "\u49ff"));
        for (Slot slot : craftingScreenHandler.getInputSlots()) {
            stringBuilder.append(slot.getStack().getCount()).append(' ');
        }
        return stringBuilder.append(']').toString();
    }

    private static boolean qcl(List<Slot> list, Item item, Slot slot) {
        for (Slot slot2 : list) {
            if (!slot2.hasStack() || slot2.getStack().isOf(item) && (slot == null || slot2 == slot)) continue;
            return true;
        }
        return false;
    }

    private static int qcm(List<Slot> list) {
        int n = 17;
        for (Slot slot : list) {
            n = n * 31 + slot.getStack().getCount();
        }
        return n;
    }

    private static int qcn(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (minecraftClient.getNetworkHandler() == null) {
            return 100;
        }
        PlayerListEntry playerListEntry = minecraftClient.getNetworkHandler().getPlayerListEntry(clientPlayerEntity.getUuid());
        return playerListEntry == null ? 100 : Math.max(0, playerListEntry.getLatency());
    }

    private static int qco(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return Math.min(14, 3 + qbo.qcn(minecraftClient, clientPlayerEntity) / 50);
    }

    private static int qcp(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return Math.min(100, 30 + qbo.qcn(minecraftClient, clientPlayerEntity) / 20);
    }

    private static void qcq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, ScreenHandler screenHandler, int n, int n2, SlotActionType slotActionType) {
        minecraftClient.interactionManager.clickSlot(screenHandler.syncId, n, n2, slotActionType, (PlayerEntity)clientPlayerEntity);
    }

    private static void qcr(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, ScreenHandler screenHandler, List<Slot> list) {
        qbo.qcq(minecraftClient, clientPlayerEntity, screenHandler, -999, ScreenHandler.packQuickCraftData((int)0, (int)0), SlotActionType.QUICK_CRAFT);
        for (Slot slot : list) {
            qbo.qcq(minecraftClient, clientPlayerEntity, screenHandler, slot.id, ScreenHandler.packQuickCraftData((int)1, (int)0), SlotActionType.QUICK_CRAFT);
        }
        qbo.qcq(minecraftClient, clientPlayerEntity, screenHandler, -999, ScreenHandler.packQuickCraftData((int)2, (int)0), SlotActionType.QUICK_CRAFT);
    }

    static void putBack(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, ScreenHandler screenHandler, int n) {
        for (int i = 0; i < 4 && !screenHandler.getCursorStack().isEmpty(); ++i) {
            Slot slot;
            Iterator iterator;
            ItemStack itemStack = screenHandler.getCursorStack();
            int n2 = -1;
            if (n >= 0 && n < screenHandler.slots.size() && ((iterator = ((Slot)screenHandler.slots.get(n)).getStack()).isEmpty() || ItemStack.areItemsAndComponentsEqual((ItemStack)iterator, (ItemStack)itemStack) && iterator.getCount() < iterator.getMaxCount())) {
                n2 = n;
            }
            if (n2 < 0) {
                iterator = screenHandler.slots.iterator();
                while (iterator.hasNext()) {
                    slot = (Slot)iterator.next();
                    if (slot.inventory != clientPlayerEntity.getInventory() || !slot.hasStack() || !ItemStack.areItemsAndComponentsEqual((ItemStack)slot.getStack(), (ItemStack)itemStack) || slot.getStack().getCount() >= slot.getStack().getMaxCount()) continue;
                    n2 = slot.id;
                    break;
                }
            }
            if (n2 < 0) {
                iterator = screenHandler.slots.iterator();
                while (iterator.hasNext()) {
                    slot = (Slot)iterator.next();
                    if (slot.inventory != clientPlayerEntity.getInventory() || slot.hasStack() || slot.getIndex() >= 36) continue;
                    n2 = slot.id;
                    break;
                }
            }
            qbo.qcq(minecraftClient, clientPlayerEntity, screenHandler, n2 < 0 ? -999 : n2, 0, SlotActionType.PICKUP);
            n = -1;
        }
    }

    static int count(ScreenHandler screenHandler, ClientPlayerEntity clientPlayerEntity, Item item) {
        int n = 0;
        for (Slot slot : screenHandler.slots) {
            if (slot.inventory != clientPlayerEntity.getInventory() || !slot.getStack().isOf(item)) continue;
            n += slot.getStack().getCount();
        }
        return n;
    }

    private static Slot qcs(ScreenHandler screenHandler, ClientPlayerEntity clientPlayerEntity, Item item) {
        Slot slot = null;
        for (Slot slot2 : screenHandler.slots) {
            if (slot2.inventory != clientPlayerEntity.getInventory() || !slot2.getStack().isOf(item) || slot != null && slot2.getStack().getCount() <= slot.getStack().getCount()) continue;
            slot = slot2;
        }
        return slot;
    }

    private static Slot qct(ScreenHandler screenHandler, ClientPlayerEntity clientPlayerEntity, Item item, Slot slot) {
        Slot slot2 = null;
        for (Slot slot3 : screenHandler.slots) {
            if (slot3 == slot || slot3.inventory != clientPlayerEntity.getInventory() || !slot3.getStack().isOf(item) || slot2 != null && slot3.getStack().getCount() >= slot2.getStack().getCount()) continue;
            slot2 = slot3;
        }
        return slot2;
    }

    private static /* synthetic */ int brf(int n, int n2) {
        return n - n2 | 0xCC2A05B8;
    }
}

