/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Hand
 */
package a;

import a.vhs;
import a.vht;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;

public final class vhu {
    private static vht vhv;
    private static vhs vhw;
    private static /* synthetic */ String vhx;
    private static /* synthetic */ String vhy;

    private vhu() {
    }

    public static void register(vht vht2) {
        vhv = vht2;
    }

    public static void register(vhs vhs2) {
        vhw = vhs2;
    }

    static boolean changesHands() {
        return vhv != null && vhv.active() || vhw != null && vhw.active();
    }

    static void viewModel(MatrixStack matrixStack, Arm arm) {
        if (vhv != null && vhv.active()) {
            vhv.apply(matrixStack, arm);
        }
    }

    static boolean swings(AbstractClientPlayerEntity abstractClientPlayerEntity, Hand hand, ItemStack itemStack) {
        return vhw != null && vhw.active() && vhw.handles(abstractClientPlayerEntity, hand, itemStack);
    }

    static void swing(MatrixStack matrixStack, AbstractClientPlayerEntity abstractClientPlayerEntity, Arm arm, Hand hand, float f, ItemStack itemStack, float f2) {
        vhw.apply(matrixStack, abstractClientPlayerEntity, arm, hand, f, itemStack, f2);
    }

    private static /* synthetic */ int dfi(int n, int n2) {
        return n * n2 ^ 0xF350B945;
    }
}

