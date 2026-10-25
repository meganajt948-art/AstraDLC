/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.iov;
import a.izx;
import a.jcs;
import a.ujt;
import a.uut;
import a.vcj;
import a.vkl;
import a.vlv;
import a.vmo;
import flow.dev.a;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class ixu
extends jcs {
    public static final vlv LAYOUT = new vlv(a.b("\u1383\u6a1f\ue0d4\u7eb3\uf57e\u73ce", -1985014839), a.d("\u9379\ueaf5\u603e", 1991046311, -148215921), a.c(-1104902861, "\u8562\ufcee\u7625"), a.c(1910023134, "\ua39b\uda06\u50d6\ucebe\u4571\uc3c3"));
    public static final vlv DURABILITY = new vlv(a.b("\u4dd9\u3459\ube8d\u20ef\uab3b\u2d81\u97d7\u1e23\u8061\u0add", 96161175), a.b("\u89fa\uf07e\u7aba\ue4da\u6f0b\ue9b1\u53f8", -1136031315), a.d("\uf1af\u882b\u02ef\u9c8f\u175e\u91e4\u2bad", -148116399, 1340677545), a.b("\ufb56\u82c4\u0804", 1578760983), a.c(1111048219, "\u405d\u39c1\ub309\u2d64"));
    public static final vkl HANDS = new vkl(a.c(1656836280, "\u50f5\u296d\ua3b1\u3dca\ub60a"), false);
    public static final List<vmo> OPTIONS = List.of(LAYOUT, DURABILITY, HANDS);
    private static final float ixv = 5.0f;
    private static final float ixw = 12.0f;
    private static final float ixx = 21.0f;
    private static final float ixy = 1.5f;
    private static final float ixz = 16.0f;
    private static final int iya = -12595334;
    private static final int iyb = -865972;
    private static final int iyc = -1092784;
    private static final EquipmentSlot[] iyd = new EquipmentSlot[]{EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166, EquipmentSlot.field_6173, EquipmentSlot.field_6171};
    private final ItemStack[] iye = new ItemStack[iyd.length];
    private final int[] iyf = new int[iyd.length];
    private final vcj[] iyg = new vcj[iyd.length];
    private final vcj iyh = new vcj(13.0f, 60.0f);
    private final vcj iyi = new vcj(13.0f, 30.0f);
    private int iyj;
    private boolean iyk;
    private boolean iyl;
    private static ItemStack[] iym;
    private static /* synthetic */ boolean iyn;
    private static /* synthetic */ long iyo;

    ixu() {
        super(a.c(1506693919, "\u537b\u2ad9\ua015\u3e66\ub5ac"), a.c(-1430329951, "\ue5e5\u9c67\u16ab\u88d8\u0312"), true, 1, 2, 152.0f, 3.0f);
        for (int i = 0; i < iyd.length; ++i) {
            this.iye[i] = ItemStack.field_8037;
            this.iyg[i] = new vcj(5.0f);
        }
    }

    @Override
    public List<vmo> settings() {
        return OPTIONS;
    }

    @Override
    void update(float f, boolean bl) {
        int n;
        this.iyj = HANDS.get() ? 6 : 4;
        ClientPlayerEntity clientPlayerEntity = MinecraftClient.method_1551().field_1724;
        boolean bl2 = false;
        if (clientPlayerEntity != null) {
            for (n = 0; n < 4; ++n) {
                bl2 |= !clientPlayerEntity.method_6118(iyd[n]).method_7960();
            }
        }
        this.iyl = !bl2 && bl;
        for (n = 0; n < iyd.length; ++n) {
            int n2;
            ItemStack itemStack = n >= this.iyj ? ItemStack.field_8037 : (this.iyl ? ixu.iyp(n) : (clientPlayerEntity != null ? clientPlayerEntity.method_6118(iyd[n]) : ItemStack.field_8037));
            int n3 = n2 = itemStack.method_7963() ? itemStack.method_7919() : 0;
            if (!this.iyl && itemStack.method_7909() == this.iye[n].method_7909() && n2 > this.iyf[n]) {
                this.iyg[n].set(1.0f);
            }
            this.iye[n] = itemStack;
            this.iyf[n] = n2;
            this.iyg[n].step(0.0f, f);
        }
        this.iyk = bl2 || this.iyl;
        this.iyh.step(ixu.iyq() ? 27.0f + izx.VALUE.width(a.b("\ueb85\u9235\u18e6\u8682", -91362384)) : 10.0f + (float)this.iyj * 21.0f + (float)(this.iyj - 1) * 1.5f, f);
        this.iyi.step(ixu.iyq() ? 10.0f + (float)this.iyj * 16.0f - 2.0f : 22.0f + (ixu.iyr() ? (ixu.iys() ? 10.5f : 8.5f) : 4.0f), f);
    }

    private static ItemStack iyp(int n) {
        if (iym == null) {
            Item[] itemArray = new Item[]{Items.field_22027, Items.field_22028, Items.field_8348, Items.field_8285, Items.field_22022, Items.field_8288};
            float[] fArray = new float[]{0.06f, 0.31f, 0.64f, 0.9f, 0.15f, 0.0f};
            iym = new ItemStack[itemArray.length];
            for (int i = 0; i < itemArray.length; ++i) {
                ItemStack itemStack = new ItemStack((ItemConvertible)itemArray[i]);
                if (itemStack.method_7963()) {
                    itemStack.method_7974(Math.round((float)itemStack.method_7936() * fArray[i]));
                }
                ixu.iym[i] = itemStack;
            }
        }
        return iym[n];
    }

    private static boolean iyq() {
        return LAYOUT.is(a.d("\uee9b\u9706\u1dd6\u83be\u0871\u8ec3", 1881489591, 1098100329));
    }

    private static boolean iyr() {
        return !DURABILITY.is(a.c(1506710165, "\u92d4\ueb46\u6186"));
    }

    private static boolean iys() {
        return !DURABILITY.is(a.c(-1587663214, "\u2ec5\u5741\udd85\u43e5\uc834\u4e8e\uf4c7"));
    }

    @Override
    boolean hasContent(boolean bl) {
        return this.iyk;
    }

    @Override
    boolean canGhost() {
        return true;
    }

    @Override
    boolean isSample() {
        return this.iyl;
    }

    @Override
    float width() {
        return this.iyh.get();
    }

    @Override
    float height() {
        return this.iyi.get();
    }

    @Override
    void draw(DrawContext drawContext, float f, boolean bl) {
        float f2 = this.width();
        float f3 = this.height();
        izx.panel(drawContext, f2, f3, iov.r(7.0f));
        uut.pushScissor(drawContext, 0.0f, 0.0f, f2, f3);
        for (int i = 0; i < this.iyj; ++i) {
            if (ixu.iyq()) {
                this.iyu(drawContext, i, 5.0f, 5.0f + (float)i * 16.0f, f2 - 10.0f);
                continue;
            }
            this.iyt(drawContext, i, 5.0f + (float)i * 22.5f, 5.0f);
        }
        uut.popScissor(drawContext);
    }

    private void iyt(DrawContext drawContext, int n, float f, float f2) {
        ItemStack itemStack = this.iye[n];
        float f3 = f + 10.5f;
        if (n == 4) {
            uut.rect(drawContext, f - 0.75f - 0.5f, f2 + 2.0f, 1.0f, this.height() - 10.0f - 4.0f, ujt.mulAlpha(iov.textMuted, 0.3f));
        }
        if (itemStack.method_7960()) {
            uut.circle(drawContext, f3, f2 + 6.0f, 1.3f, ujt.mulAlpha(iov.textMuted, 0.4f));
            return;
        }
        ixu.iyv(drawContext, itemStack, f3, f2 + 6.0f);
        float f4 = ixu.iyw(itemStack);
        if (ixu.iyr()) {
            String string = ixu.iyx(itemStack, f4);
            izx.SMALL.drawCentered(drawContext, string, f3, izx.SMALL.centerTop(f2 + 12.0f + 4.4f), this.iyy(n, f4));
        }
        if (ixu.iys() && f4 >= 0.0f) {
            float f5 = 14.0f;
            float f6 = f2 + 12.0f + (ixu.iyr() ? 8.6f : 2.2f);
            ixu.iyz(drawContext, f3 - f5 * 0.5f, f6, f5, f4);
        }
    }

    private void iyu(DrawContext drawContext, int n, float f, float f2, float f3) {
        ItemStack itemStack = this.iye[n];
        float f4 = f2 + 6.0f + 0.5f;
        if (itemStack.method_7960()) {
            uut.circle(drawContext, f + 6.0f, f4, 1.3f, ujt.mulAlpha(iov.textMuted, 0.4f));
            return;
        }
        ixu.iyv(drawContext, itemStack, f + 6.0f, f4);
        float f5 = ixu.iyw(itemStack);
        if (ixu.iyr()) {
            izx.VALUE.drawRight(drawContext, ixu.iyx(itemStack, f5), f + f3, izx.VALUE.centerTop(f4), this.iyy(n, f5));
        }
        if (ixu.iys() && f5 >= 0.0f) {
            float f6 = f + 12.0f + 4.0f;
            float f7 = ixu.iyr() ? f3 - (f6 - f) - izx.VALUE.width(a.c(428345310, "\u07eb\u7e5b\uf488\u6aec")) - 4.0f : f3 - (f6 - f);
            ixu.iyz(drawContext, f6, f4 - 0.65f, f7, f5);
        }
    }

    private static void iyv(DrawContext drawContext, ItemStack itemStack, float f, float f2) {
        float f3 = 0.75f * Math.min(1.0f, uut.alpha() * 2.5f);
        if (f3 > 0.02f) {
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate(f, f2);
            drawContext.method_51448().scale(f3, f3);
            drawContext.method_51427(itemStack, -8, -8);
            drawContext.method_51448().popMatrix();
        }
    }

    private static float iyw(ItemStack itemStack) {
        if (!itemStack.method_7963() || itemStack.method_7936() <= 0) {
            return -1.0f;
        }
        return Math.max(0.0f, 1.0f - (float)itemStack.method_7919() / (float)itemStack.method_7936());
    }

    private static String iyx(ItemStack itemStack, float f) {
        if (f < 0.0f) {
            return itemStack.method_7947() > 1 ? a.b("\u93fc", 2119340933) + itemStack.method_7947() : "";
        }
        return Math.round(f * 100.0f) + a.d("\ud3ef", 471154364, 1698557303);
    }

    private int iyy(int n, float f) {
        int n2 = iov.text;
        if (f >= 0.0f && f < 0.5f) {
            int n3 = n2 = f < 0.2f ? -1092784 : ujt.lerp(iov.text, -865972, (0.5f - f) / 0.3f);
        }
        if (f >= 0.0f && f < 0.12f) {
            float f2 = 0.5f + 0.5f * (float)Math.cos((double)System.nanoTime() / 1.0E9 * Math.PI * 3.0);
            n2 = ujt.lerp(-1092784, -1, 0.35f * f2);
        }
        return ujt.lerp(n2, -1, this.iyg[n].get());
    }

    private static void iyz(DrawContext drawContext, float f, float f2, float f3, float f4) {
        float f5 = 1.3f;
        uut.round(drawContext, f, f2, f3, f5, f5 * 0.5f, iov.track);
        uut.round(drawContext, f, f2, Math.max(f5, f3 * f4), f5, f5 * 0.5f, ixu.iza(f4));
    }

    private static int iza(float f) {
        return f > 0.5f ? ujt.lerp(-865972, -12595334, (f - 0.5f) * 2.0f) : ujt.lerp(-1092784, -865972, f * 2.0f);
    }

    private static /* synthetic */ int akx(int n, int n2) {
        return n - n2 + -1699123458;
    }
}

