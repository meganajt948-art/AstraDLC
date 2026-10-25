/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.block.ShulkerBoxBlock
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.ContainerComponent
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.util.DyeColor
 *  net.minecraft.util.collection.DefaultedList
 */
package a;

import a.iov;
import a.kfa;
import a.kfe;
import a.ujt;
import a.uut;
import a.vdn;
import a.veo;
import a.vkl;
import a.vmc;
import a.vxl;
import flow.dev.a;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.DyeColor;
import net.minecraft.util.collection.DefaultedList;

public class pbe
extends kfe {
    private static pbe pbf;
    private final vmc pbg = this.add(new vmc(a.b("\u5522\u2ca9\ua669\u3807", -1053993611), 1.0, 0.6, 1.6, 0.05).unit(a.b("\uf0cd", -1699745612)));
    private final vkl pbh = this.add(new vkl(a.b("\u8b51\uf2cd\u7809\ue620\u6db4\ueb09\u5159\ud8ab\u46e9", 998804250), true));
    private final vkl pbi = this.add(new vkl(a.b("\ua681\udf1c\u55cd\ucba1\u4067\uc6d4\u7c90", -648567099), false));
    private static final vdn pbj;
    private static final vdn pbk;
    private static final float pbl = 18.0f;
    private static final float pbm = 5.0f;
    private static final float pbn = 13.0f;
    private final DefaultedList<ItemStack> pbo = DefaultedList.method_10213((int)27, (Object)ItemStack.field_8037);
    private static /* synthetic */ int pbp;
    private static /* synthetic */ int pbq;

    public pbe() {
        super(a.c(-1436817267, "\ue8d0\u915a\u1b94\u85fc\u0e2c\u8893\u32d7\ubb04\u2579\uafdf\u281f\ud271\u5caa\uc509"), a.d("\u7178\u08ff\u822c\u1c18\u9786\u1130\uab7e\u2295\ubcc7\u3677\ub1e1\u4bd1\uc547\u5ca5\ud6ed\u5001\uea57\u6581\uff3c\u797a\uf0df\u8ac1\u0473\u9fec\u19db\u930d\u2aa7\ua4e5\u3e05", -2057239957, 1035236189), kfa.PLAYER);
        pbf = this;
    }

    public static void attach(Screen screen2) {
        if (!(screen2 instanceof HandledScreen)) {
            return;
        }
        HandledScreen handledScreen = (HandledScreen)screen2;
        ScreenEvents.afterRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> {
            pbe pbe2 = pbf;
            if (pbe2 != null && pbe2.isEnabled()) {
                pbe2.pbr(handledScreen, drawContext, n, n2);
            }
        });
    }

    private void pbr(HandledScreen<?> handledScreen, DrawContext drawContext, int n, int n2) {
        int n3;
        DyeColor dyeColor;
        int n4;
        int n5;
        BlockItem blockItem;
        if (!handledScreen.method_17577().method_34255().method_7960()) {
            return;
        }
        Slot slot = vxl.hovered(handledScreen);
        if (slot == null || !slot.method_7681()) {
            return;
        }
        ItemStack itemStack = slot.method_7677();
        Item item = itemStack.method_7909();
        if (!(item instanceof BlockItem) || !((item = (blockItem = (BlockItem)item).method_7711()) instanceof ShulkerBoxBlock)) {
            return;
        }
        ShulkerBoxBlock shulkerBoxBlock = (ShulkerBoxBlock)item;
        item = (ContainerComponent)itemStack.method_58694(DataComponentTypes.field_49622);
        for (n5 = 0; n5 < this.pbo.size(); ++n5) {
            this.pbo.set(n5, (Object)ItemStack.field_8037);
        }
        if (item != null) {
            item.method_57492(this.pbo);
        }
        n5 = 0;
        int n6 = 0;
        for (n4 = 0; n4 < 27; ++n4) {
            if (((ItemStack)this.pbo.get(n4)).method_7960()) continue;
            ++n5;
            n6 = n4 / 9;
        }
        n4 = this.pbi.get() ? Math.max(1, n6 + 1) : 3;
        float f = 172.0f;
        float f2 = 18.0f + (float)n4 * 18.0f + 5.0f;
        float f3 = (float)this.pbg.get();
        int n7 = drawContext.method_51421();
        int n8 = drawContext.method_51443();
        float f4 = Math.max(2.0f, Math.min((float)n7 - f * f3 - 2.0f, (float)n + 10.0f));
        float f5 = (float)n2 - 18.0f - f2 * f3;
        if (f5 < 2.0f) {
            f5 = Math.min((float)n8 - f2 * f3 - 2.0f, (float)n2 + 22.0f);
        }
        int n9 = (dyeColor = shulkerBoxBlock.method_10528()) != null ? 0xFF000000 | dyeColor.method_7787() : -6522701;
        int n10 = this.pbh.get() ? ujt.lerp(-15592938, n9, 0.22f) : iov.window | 0xFF000000;
        int n11 = this.pbh.get() ? ujt.lerp(n9, -1, 0.25f) : iov.stroke;
        int n12 = ujt.withAlpha(ujt.lerp(n10, -1, 0.07f), 235);
        float f6 = 6.0f;
        uut.beginFrame();
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f4, f5);
        drawContext.method_51448().scale(f3, f3);
        uut.shadow(drawContext, 0.0f, 2.0f, f, f2, f6, 10.0f, 0x70000000);
        uut.round(drawContext, 0.0f, 0.0f, f, f2, f6, ujt.withAlpha(n10, 245));
        uut.outline(drawContext, 0.0f, 0.0f, f, f2, f6, 1.0f, ujt.withAlpha(n11, 150));
        String string = itemStack.method_7964().getString();
        String string2 = n5 + a.b("\uc229\ubb85\u3153", -1330724347);
        pbj.draw(drawContext, pbj.ellipsize(string, f - 10.0f - pbk.width(string2) - 8.0f), 6.0f, pbj.centerTop(8.5f), -855307);
        pbk.draw(drawContext, string2, f - 5.0f - pbk.width(string2), pbk.centerTop(8.5f), ujt.withAlpha(n11, 220));
        for (int i = 0; i < n4; ++i) {
            for (n3 = 0; n3 < 9; ++n3) {
                uut.round(drawContext, 5.0f + (float)n3 * 18.0f + 0.5f, 18.0f + (float)i * 18.0f + 0.5f, 17.0f, 17.0f, 3.0f, n12);
            }
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        for (n3 = 0; n3 < n4 * 9; ++n3) {
            ItemStack itemStack2 = (ItemStack)this.pbo.get(n3);
            if (itemStack2.method_7960()) continue;
            int n13 = Math.round(5.0f + (float)(n3 % 9) * 18.0f + 1.0f);
            int n14 = Math.round(18.0f + (float)(n3 / 9) * 18.0f + 1.0f);
            drawContext.method_51427(itemStack2, n13, n14);
            drawContext.method_51431(minecraftClient.field_1772, itemStack2, n13, n14);
        }
        drawContext.method_51448().popMatrix();
    }

    static {
        pbj = veo.semibold(6.5f);
        pbk = veo.medium(5.5f);
    }

    private static /* synthetic */ int bgm(int n, int n2) {
        return n * n2 + -960197898;
    }
}

