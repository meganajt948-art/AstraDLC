/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.Generic3x3ContainerScreen
 *  net.minecraft.client.gui.screen.ingame.GenericContainerScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.HopperScreen
 *  net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.Generic3x3ContainerScreen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HopperScreen;
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public final class vxl {
    private static Field vxm;
    private static boolean vxn;
    private static /* synthetic */ String vxo;
    private static /* synthetic */ int vxp;

    private vxl() {
    }

    public static boolean isStorage(Screen screen) {
        return screen instanceof GenericContainerScreen || screen instanceof ShulkerBoxScreen || screen instanceof HopperScreen || screen instanceof Generic3x3ContainerScreen;
    }

    public static Slot hovered(HandledScreen<?> handledScreen) {
        if (!vxn) {
            vxn = true;
            vxm = vxr.find(HandledScreen.class, a.c(-625653279, "\u4998\u3022\ubae0\u24cb\uaf5f\u29ea\u93be\u1a44\u841d\u0ebd\u897d\u730b\ufdce\u6425\uee3b\u68c5\ud287\u5d44\uc7f7\u418a\uc816\ub245\u3cf5"), a.c(-774200306, "\ua462\udddc\u5703\uc97b\u42a4\uc42e\u7e10\uf7e4\u69b4\ue30a"), a.c(1664134501, "\uad33\ud4a0\u5e78\uc018\u4b94\ucd67\u7730\ufec6\u6092\uea25\u6de7\u9785\u1955\u80f6\u0afe\u8c43\u3603\ub9df\u237e\ua52f\u2cf4\u56cb\ud87e\u43ab\uc5d2\u4f0d"));
        }
        if (vxm == null) {
            return null;
        }
        try {
            return (Slot)vxm.get(handledScreen);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return null;
        }
    }

    public static List<Slot> own(ScreenHandler screenHandler, PlayerInventory playerInventory) {
        ArrayList<Slot> arrayList = new ArrayList<Slot>();
        for (Slot slot : screenHandler.field_7761) {
            if (slot.field_7871 == playerInventory) continue;
            arrayList.add(slot);
        }
        return arrayList;
    }

    public static Slot room(ScreenHandler screenHandler, PlayerInventory playerInventory, ItemStack itemStack, boolean bl) {
        for (Slot slot : screenHandler.field_7761) {
            ItemStack itemStack2;
            if (slot.field_7871 != playerInventory || !vxl.vxq(slot, bl) || !slot.method_7681() || !ItemStack.method_31577((ItemStack)itemStack, (ItemStack)(itemStack2 = slot.method_7677())) || itemStack2.method_7947() >= itemStack2.method_7914()) continue;
            return slot;
        }
        for (Slot slot : screenHandler.field_7761) {
            if (slot.field_7871 != playerInventory || !vxl.vxq(slot, bl) || slot.method_7681()) continue;
            return slot;
        }
        return null;
    }

    private static boolean vxq(Slot slot, boolean bl) {
        int n = slot.method_34266();
        return n >= 9 && n < 36 || bl && n >= 0 && n < 9;
    }

    public static boolean hasRoom(ScreenHandler screenHandler, PlayerInventory playerInventory, ItemStack itemStack) {
        return vxl.room(screenHandler, playerInventory, itemStack, true) != null;
    }

    public static void click(MinecraftClient minecraftClient, ScreenHandler screenHandler, int n, int n2, SlotActionType slotActionType) {
        minecraftClient.field_1761.method_2906(screenHandler.field_7763, n, n2, slotActionType, (PlayerEntity)minecraftClient.field_1724);
    }

    private static /* synthetic */ int dlt(int n, int n2) {
        return n - n2 ^ 0xDD9635D0;
    }
}

