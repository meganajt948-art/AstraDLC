/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.player.ItemCooldownManager
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 *  net.minecraft.util.Identifier
 */
package a;

import a.iov;
import a.izb;
import a.izx;
import a.jeq;
import a.uut;
import a.vhz;
import a.vxu;
import a.wap;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public final class izj
extends jeq<izb> {
    private static Method izk;
    private static Method izl;
    private static final float izm = 15.0f;
    private static final float izn = 10.0f;
    private static final float izo = 64.0f;
    private static Field izp;
    private static Field izq;
    private static boolean izr;
    private static /* synthetic */ boolean izs;
    private static /* synthetic */ boolean izt;

    izj() {
        super(a.b("\ue513\u9cae\u167d\u880f\u03d0\u856a\u3f21\ub6c9\u288b", 1568466297), a.b("\u36b8\u4f25\uc5f6\u5b84\ud05b\u56e1\uecaa\u6542\ufb00", -783141134), vhz.CLOCK, true, 2, 2, 6.0f, 6.0f);
    }

    @Override
    List<izb> items(boolean bl) {
        ArrayList<izb> arrayList;
        block4: {
            arrayList = new ArrayList<izb>();
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
            if (clientPlayerEntity != null) {
                try {
                    izj.izv(clientPlayerEntity, minecraftClient.getRenderTickCounter().getTickProgress(true), arrayList);
                }
                catch (Throwable throwable) {
                    if (izr) break block4;
                    izr = true;
                    System.out.println(a.c(-2066021231, "\u04e5\u7d58\uf78b\u69f9\ue226\u649c\uded7\u573f\uc97d\u439f\uc419\u3e73\ub0ab\u290d\ua349\u25b0\u9ffa\u1026\u8a96\u0cc9\u8537\uff39\u7190") + throwable);
                }
            }
        }
        if (arrayList.isEmpty() && bl) {
            arrayList.add(izj.izu(Items.ENDER_PEARL, 0.8f, 0.8f));
            arrayList.add(izj.izu(Items.WIND_CHARGE, 0.3f, 0.6f));
        }
        arrayList.sort(Comparator.comparing(izb2 -> -izb2.izf));
        return arrayList;
    }

    private static izb izu(Item item, float f, float f2) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        return new izb(a.b("\u4d55\u34e6\ube22\u2040\uab88\u2d35\u9774\u1ec8", -1985000147) + Registries.ITEM.getId((Object)item), itemStack, izj.shortName(itemStack, Registries.ITEM.getId((Object)item)), System.nanoTime() + (long)(f * 1.0E9f), f / f2);
    }

    private static void izv(ClientPlayerEntity clientPlayerEntity, float f, List<izb> list) throws Exception {
        int n;
        Object object;
        if (izr) {
            return;
        }
        ItemCooldownManager itemCooldownManager = clientPlayerEntity.getItemCooldownManager();
        if (izp == null) {
            object = ItemCooldownManager.class.getDeclaredFields();
            n = ((Field[])object).length;
            for (int i = 0; i < n; ++i) {
                Object object2 = object[i];
                if (Modifier.isStatic(((Field)object2).getModifiers())) continue;
                if (Map.class.isAssignableFrom(((Field)object2).getType())) {
                    izp = object2;
                    continue;
                }
                if (((Field)object2).getType() != Integer.TYPE) continue;
                izq = object2;
            }
            if (izp == null || izq == null) {
                throw new IllegalStateException(a.c(768385889, "\ua31b\udaa6\u5075\uce07\u45d8\uc362\u7929\uf0c1\u6ed0\ue427\u63fb\u9986\u1758\u8ee1\u04a5\u8207\u3806\ub7d6\u2d7e\uab7b\u22ca\u5892\ud63b\u4df1\ucb84"));
            }
            izp.setAccessible(true);
            izq.setAccessible(true);
        }
        if ((object = (Map)izp.get(itemCooldownManager)).isEmpty()) {
            return;
        }
        n = izq.getInt(itemCooldownManager);
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        long l = System.nanoTime();
        for (Map.Entry entry : object.entrySet()) {
            Object object3 = entry.getKey();
            if (!(object3 instanceof Identifier)) continue;
            Identifier identifier = (Identifier)object3;
            if (entry.getValue() == null) continue;
            if (izk == null) {
                object3 = entry.getValue().getClass().getRecordComponents();
                if (object3 == null || ((K)object3).length < 2) continue;
                izk = ((RecordComponent)object3[0]).getAccessor();
                izl = ((RecordComponent)object3[1]).getAccessor();
                izk.setAccessible(true);
                izl.setAccessible(true);
            }
            int n2 = (Integer)izk.invoke(entry.getValue(), new Object[0]);
            int n3 = (Integer)izl.invoke(entry.getValue(), new Object[0]);
            float f2 = (float)Math.max(1, n3 - n2) / 20.0f;
            float f3 = ((float)n3 - ((float)n + f)) / 20.0f;
            if (f3 <= 0.0f) continue;
            ItemStack itemStack = izj.izw(itemCooldownManager, playerInventory, identifier);
            list.add(new izb(identifier.toString(), itemStack, izj.shortName(itemStack, identifier), l + (long)(f3 * 1.0E9f), f2));
        }
    }

    static String shortName(ItemStack itemStack, Identifier identifier) {
        Item item;
        Item item2 = item = itemStack.isEmpty() ? (Item)Registries.ITEM.get(identifier) : itemStack.getItem();
        if (item == Items.ENCHANTED_GOLDEN_APPLE) {
            return wap.s(a.d("\u6b4e\u12d7\u980f\u063a\u8dac\u0b0c\ub15f\u38b2\ua6e4", 375357988, 871426340), a.b("\u43e8\u3a4e\ub0ed\u2ee6\ua53b", 1677477834));
        }
        if (item == Items.GOLDEN_APPLE) {
            return wap.s(a.b("\u3850\u41c7\ucb05\u5574\udebf\u5807", -1734789103), a.c(118144588, "\uba5b\uc3b4\u4915\ud760"));
        }
        if (item == Items.ENDER_PEARL) {
            return wap.s(a.d("\u56b0\u2f34\ua5e3\u3b81\ub048", -1087293075, 869560200), a.d("\u73b8\u0a2a\u80f0\u1efa\u9529\u13e8", -905268007, -1331575951));
        }
        if (item == Items.CHORUS_FRUIT) {
            return wap.s(a.c(-1927313584, "\u8715\ufe8f\u745b\uea37\u61e7\ue750"), a.b("\u2497\u5d3d\ud790\u49e2\uc237", -969858889));
        }
        if (item == Items.WIND_CHARGE) {
            return wap.s(a.d("\ud760\uaeef\u243b\uba40\u31d3\ub721\u0d79\u8481\u1acd\u9069\u17b8", -1413031756, -192082040), a.c(-1244043857, "\u61b3\u1825\u9286\u0cf8\u8754\u05f1\ubbb0\u3246\uac6e\u26dd\ua17e"));
        }
        if (item == Items.TOTEM_OF_UNDYING) {
            return wap.s(a.b("\u0bac\u7226\uf8ee\u668e\ued51", 1141443581), a.c(515004581, "\u5c82\u252f\uaf80\u3186\uba58"));
        }
        if (item == Items.EXPERIENCE_BOTTLE) {
            return wap.s(a.d("\u69f1\u1048\u9aeb\u04d8\u8f02\u09a8\ub3fb\u3a12\ua444", 1436287464, -483432376), a.d("\ue139\u98d4\u1273\u8c7e\u07a2\u8102\u3b3a\ub6d1\u2c90\ua620\u2187\udbff\u555a", -335633187, 1051476470));
        }
        String string = item == Items.AIR ? identifier.getPath().replace('_', ' ') : item.getName().getString();
        return string.isEmpty() ? identifier.getPath() : string;
    }

    private static ItemStack izw(ItemCooldownManager itemCooldownManager, PlayerInventory playerInventory, Identifier identifier) {
        for (int i = 0; i < playerInventory.size(); ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            if (itemStack.isEmpty() || !identifier.equals((Object)itemCooldownManager.getGroup(itemStack))) continue;
            return new ItemStack((ItemConvertible)itemStack.getItem());
        }
        Item item = (Item)Registries.ITEM.get(identifier);
        return item == Items.AIR ? ItemStack.EMPTY : new ItemStack((ItemConvertible)item);
    }

    static String seconds(float f) {
        return f >= 60.0f ? vxu.clock((int)f) : vxu.fixed(f, 1) + wap.unit(a.c(651202924, "\u911e"));
    }

    @Override
    String key(izb izb2) {
        return izb2.izc;
    }

    @Override
    float rowHeight() {
        return 15.0f;
    }

    @Override
    float rowWidth(izb izb2) {
        return 14.0f + Math.min(64.0f, izx.TEXT.width(izb2.ize)) + 12.0f + izx.VALUE.width(a.d("\ua530\udc81\u564c\uc823\u43b7", -1492954728, -1062538083));
    }

    @Override
    void drawRow(DrawContext drawContext, izb izb2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8 = f2 + 6.0f;
        if (!izb2.izd.isEmpty()) {
            f7 = 0.625f * f5;
            uut.pushScissor(drawContext, f - 1.0f, f8 - 5.0f - 1.0f, 12.0f, 12.0f);
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(f + 5.0f, f8);
            drawContext.getMatrices().scale(f7, f7);
            drawContext.drawItem(izb2.izd, -8, -8);
            drawContext.getMatrices().popMatrix();
            uut.popScissor(drawContext);
        }
        f7 = f + 10.0f + 4.0f;
        String string = izj.seconds(izb2.seconds());
        float f9 = izx.VALUE.width(string);
        izx.TEXT.draw(drawContext, izx.TEXT.ellipsize(izb2.ize, f3 - (f7 - f) - f9 - 8.0f), f7, izx.TEXT.centerTop(f8), iov.text);
        izx.VALUE.drawRight(drawContext, string, f + f3, izx.VALUE.centerTop(f8), iov.textDim);
        izj.bar(drawContext, f7, f2 + f4 - 3.6f, f3 - (f7 - f), izb2.fraction(), iov.accent(), iov.accent2());
    }

    private static /* synthetic */ int ald(int n, int n2) {
        return n - n2 | 0x38F440A5;
    }
}

