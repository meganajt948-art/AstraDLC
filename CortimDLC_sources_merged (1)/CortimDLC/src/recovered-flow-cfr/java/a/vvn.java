/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.BeesComponent
 *  net.minecraft.component.type.BundleContentsComponent
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

import a.wdq;
import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BeesComponent;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.apache.commons.lang3.math.Fraction;

public final class vvn {
    private static final Fraction vvo = Fraction.getFraction((int)1, (int)16);
    private int vvp = -1;
    private int vvq;
    private int vvr;
    private int vvs = -1;
    private ItemStack vvt = ItemStack.field_8037;
    private boolean vvu;
    private static /* synthetic */ long vvv;
    private static /* synthetic */ String vvw;

    public boolean active() {
        return this.vvu;
    }

    public boolean cursorHeld(ClientPlayerEntity clientPlayerEntity) {
        return this.vvu && !clientPlayerEntity.field_7498.method_34255().method_7960();
    }

    public static BundleContentsComponent contents(ItemStack itemStack) {
        return itemStack.method_7909() instanceof BundleItem ? (BundleContentsComponent)itemStack.method_58694(DataComponentTypes.field_49650) : null;
    }

    public static int[] locate(PlayerInventory playerInventory, Predicate<ItemStack> predicate) {
        for (int i = 0; i < 36; ++i) {
            BundleContentsComponent bundleContentsComponent = vvn.contents(playerInventory.method_5438(i));
            if (bundleContentsComponent == null) continue;
            for (int j = 0; j < bundleContentsComponent.method_57426(); ++j) {
                if (!predicate.test(bundleContentsComponent.method_57422(j))) continue;
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static ItemStack peek(PlayerInventory playerInventory, Predicate<ItemStack> predicate) {
        int[] nArray = vvn.locate(playerInventory, predicate);
        return nArray == null ? ItemStack.field_8037 : vvn.contents(playerInventory.method_5438(nArray[0])).method_57422(nArray[1]);
    }

    public static int count(PlayerInventory playerInventory, Predicate<ItemStack> predicate) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            BundleContentsComponent bundleContentsComponent = vvn.contents(playerInventory.method_5438(i));
            if (bundleContentsComponent == null) continue;
            for (ItemStack itemStack : bundleContentsComponent.method_57421()) {
                if (!predicate.test(itemStack)) continue;
                n += itemStack.method_7947();
            }
        }
        return n;
    }

    public boolean take(MinecraftClient minecraftClient, Predicate<ItemStack> predicate, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (clientPlayerEntity.field_7512 != clientPlayerEntity.field_7498 || !clientPlayerEntity.field_7498.method_34255().method_7960()) {
            return false;
        }
        int[] nArray = vvn.locate(playerInventory, predicate);
        if (nArray == null) {
            return false;
        }
        int n2 = nArray[0];
        ItemStack itemStack = vvn.contents(playerInventory.method_5438(n2)).method_57422(nArray[1]);
        Fraction fraction = vvn.vwb(playerInventory.method_5438(n2)).add(vvn.vwc(itemStack));
        ItemStack itemStack2 = playerInventory.method_5438(n);
        int n3 = -1;
        int n4 = -1;
        if (itemStack2.method_7960()) {
            n3 = n;
        } else {
            n3 = vvn.vwe(playerInventory, -1);
            if (n3 < 0 && vvn.vvy(itemStack2) && (n4 = vvn.vvz(playerInventory, itemStack2, n, n2, fraction)) >= 0) {
                n3 = n;
            }
            for (int i = 0; i < 2 && n3 < 0; ++i) {
                for (int j = i == 0 ? 0 : 9; j < (i == 0 ? 9 : 36) && n3 < 0; ++j) {
                    ItemStack itemStack3 = playerInventory.method_5438(j);
                    if (j == n || j == n2 || !vvn.vvy(itemStack3) || (n4 = vvn.vvz(playerInventory, itemStack3, j, n2, fraction)) < 0) continue;
                    n3 = j;
                }
            }
            if (n3 < 0 && vvn.contents(itemStack2) == null) {
                n3 = n;
            }
        }
        if (n3 < 0) {
            return false;
        }
        this.vvp = n2;
        this.vvq = n3;
        this.vvr = n;
        this.vvs = n4;
        this.vvt = ItemStack.field_8037;
        this.vvu = true;
        vvn.vwf(minecraftClient, n2, nArray[1]);
        vvn.vwg(minecraftClient, n2, 1);
        vvn.vwg(minecraftClient, n3, 0);
        if (n4 >= 0) {
            this.vvt = clientPlayerEntity.field_7498.method_34255().method_7972();
            vvn.vwg(minecraftClient, n4, 0);
        }
        if (n3 != n && clientPlayerEntity.field_7498.method_34255().method_7960()) {
            wdq.click(minecraftClient, n3, n);
        }
        return true;
    }

    public void giveBack(MinecraftClient minecraftClient) {
        int n;
        if (!this.vvu) {
            return;
        }
        this.vvu = false;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || clientPlayerEntity.field_7512 != clientPlayerEntity.field_7498) {
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (this.vvq != this.vvr && vvn.vvx(clientPlayerEntity).method_7960()) {
            wdq.click(minecraftClient, this.vvq, this.vvr);
        }
        if (this.vvs >= 0 && vvn.vvx(clientPlayerEntity).method_7960()) {
            int n2;
            BundleContentsComponent bundleContentsComponent = vvn.contents(playerInventory.method_5438(this.vvs));
            int n3 = n2 = bundleContentsComponent == null ? -1 : vvn.vwa(bundleContentsComponent, this.vvt);
            if (n2 >= 0) {
                vvn.vwf(minecraftClient, this.vvs, n2);
                vvn.vwg(minecraftClient, this.vvs, 1);
            }
        }
        if (!vvn.vvx(clientPlayerEntity).method_7960() || !playerInventory.method_5438(this.vvq).method_7960()) {
            vvn.vwg(minecraftClient, this.vvq, 0);
        }
        if (!vvn.vvx(clientPlayerEntity).method_7960() && vvn.contents(playerInventory.method_5438(this.vvp)) != null) {
            vvn.vwg(minecraftClient, this.vvp, 0);
        }
        if (!vvn.vvx(clientPlayerEntity).method_7960() && (n = vvn.vwe(playerInventory, -1)) >= 0) {
            vvn.vwg(minecraftClient, n, 0);
        }
        this.vvs = -1;
        this.vvt = ItemStack.field_8037;
    }

    private static ItemStack vvx(ClientPlayerEntity clientPlayerEntity) {
        return clientPlayerEntity.field_7498.method_34255();
    }

    private static boolean vvy(ItemStack itemStack) {
        return BundleContentsComponent.method_61667((ItemStack)itemStack) && vvn.contents(itemStack) == null;
    }

    private static int vvz(PlayerInventory playerInventory, ItemStack itemStack, int n, int n2, Fraction fraction) {
        Fraction fraction2 = vvn.vwc(itemStack);
        int n3 = -1;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack2;
            BundleContentsComponent bundleContentsComponent;
            if (i == n || (bundleContentsComponent = vvn.contents(itemStack2 = playerInventory.method_5438(i))) == null || (i == n2 ? fraction : vvn.vwb(itemStack2)).compareTo(fraction2) < 0) continue;
            if (vvn.vwa(bundleContentsComponent, itemStack) < 0) {
                return i;
            }
            if (n3 >= 0) continue;
            n3 = i;
        }
        return n3;
    }

    private static int vwa(BundleContentsComponent bundleContentsComponent, ItemStack itemStack) {
        for (int i = 0; i < bundleContentsComponent.method_57426(); ++i) {
            if (!ItemStack.method_31577((ItemStack)bundleContentsComponent.method_57422(i), (ItemStack)itemStack)) continue;
            return i;
        }
        return -1;
    }

    private static Fraction vwb(ItemStack itemStack) {
        return Fraction.ONE.subtract(vvn.contents(itemStack).method_57428());
    }

    private static Fraction vwc(ItemStack itemStack) {
        return vvn.vwd(itemStack).multiplyBy(Fraction.getFraction((int)itemStack.method_7947(), (int)1));
    }

    private static Fraction vwd(ItemStack itemStack) {
        BundleContentsComponent bundleContentsComponent = (BundleContentsComponent)itemStack.method_58694(DataComponentTypes.field_49650);
        if (bundleContentsComponent != null) {
            return vvo.add(bundleContentsComponent.method_57428());
        }
        if (!((BeesComponent)itemStack.method_58695(DataComponentTypes.field_49624, (Object)BeesComponent.field_56300)).comp_3585().isEmpty()) {
            return Fraction.ONE;
        }
        return Fraction.getFraction((int)1, (int)itemStack.method_7914());
    }

    private static int vwe(PlayerInventory playerInventory, int n) {
        for (int i = 0; i < 36; ++i) {
            if (i == n || !playerInventory.method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    private static void vwf(MinecraftClient minecraftClient, int n, int n2) {
        ItemStack itemStack = minecraftClient.field_1724.method_31548().method_5438(n);
        BundleContentsComponent bundleContentsComponent = vvn.contents(itemStack);
        int n3 = bundleContentsComponent.method_61668();
        if (n3 == n2 || n2 == 0 && (n3 < 0 || n3 >= bundleContentsComponent.method_57426())) {
            return;
        }
        BundleItem.method_61637((ItemStack)itemStack, (int)n2);
        minecraftClient.method_1562().method_52787((Packet)new BundleItemSelectedC2SPacket(wdq.slotId(n), n2));
    }

    private static void vwg(MinecraftClient minecraftClient, int n, int n2) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        minecraftClient.field_1761.method_2906(clientPlayerEntity.field_7498.field_7763, wdq.slotId(n), n2, SlotActionType.field_7790, (PlayerEntity)clientPlayerEntity);
    }

    private static /* synthetic */ int dlf(int n, int n2) {
        return n ^ n2 ^ 0x9C95321B;
    }

    private static /* synthetic */ int dlg(int n, int n2) {
        return vvn.dlf(n, n2) + n;
    }

    private static /* synthetic */ int dlh(int n, int n2) {
        return vvn.dlf(n, n2) + n;
    }
}

