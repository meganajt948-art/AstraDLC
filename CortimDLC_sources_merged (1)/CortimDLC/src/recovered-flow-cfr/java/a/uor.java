/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.render.state.GuiRenderState
 *  net.minecraft.client.gui.render.state.ItemGuiElementRenderState
 *  net.minecraft.client.render.item.ItemRenderState
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemDisplayContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.HeldItemContext
 *  net.minecraft.world.World
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fc
 */
package a;

import a.unf;
import a.uoo;
import a.uut;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.ItemGuiElementRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HeldItemContext;
import net.minecraft.world.World;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;

public final class uor {
    private static final Map<ItemStack, uoo> uos = new IdentityHashMap<ItemStack, uoo>();
    private static final Map<Item, String> uot = new IdentityHashMap<Item, String>();
    private static long uou;
    private static /* synthetic */ boolean uov;
    private static /* synthetic */ int uow;

    private uor() {
    }

    public static void draw(DrawContext drawContext, ItemStack itemStack, int n, int n2) {
        if (itemStack.method_7960()) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        GuiRenderState guiRenderState = uut.state(drawContext);
        if (guiRenderState == null || minecraftClient.field_1687 == null || uut.scissor() != null) {
            drawContext.method_51427(itemStack, n, n2);
            return;
        }
        unf.observe(drawContext);
        long l = unf.frame();
        long l2 = minecraftClient.field_1687.method_75260();
        uoo uoo2 = uos.get(itemStack);
        if (uoo2 == null) {
            uoo2 = new uoo();
            uos.put(itemStack, uoo2);
        }
        if (uoo2.tick != l2) {
            uoo2.tick = l2;
            minecraftClient.method_65386().method_65598((ItemRenderState)uoo2.state, itemStack, ItemDisplayContext.field_4317, (World)minecraftClient.field_1687, (HeldItemContext)minecraftClient.field_1724, 0);
        }
        uoo2.frame = l;
        guiRenderState.method_70920(new ItemGuiElementRenderState(uor.uox(itemStack.method_7909()), new Matrix3x2f((Matrix3x2fc)drawContext.method_51448()), uoo2.state, n, n2, null));
        if (l - uou > 120L) {
            uou = l;
            Iterator<uoo> iterator = uos.values().iterator();
            while (iterator.hasNext()) {
                if (l - iterator.next().frame <= 120L) continue;
                iterator.remove();
            }
        }
    }

    private static String uox(Item item2) {
        return uot.computeIfAbsent(item2, item -> item.method_63680().toString());
    }

    private static /* synthetic */ int czl(int n, int n2) {
        return n - n2 | 0x4D21C108;
    }
}

