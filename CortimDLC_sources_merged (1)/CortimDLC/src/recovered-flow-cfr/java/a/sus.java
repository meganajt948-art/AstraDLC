/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Formatting
 *  net.minecraft.util.Rarity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hlc;
import a.rfl;
import a.sup;
import a.swb;
import a.swh;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vek;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class sus {
    private static final swb sut = new swb(vek.SEMIBOLD, 6.6f);
    private static final swb suu = new swb(vek.MEDIUM, 5.8f);
    private static final int suv = 48;
    private static final float suw = 4.0f;
    private static final float sux = 11.5f;
    private static final float suy = 8.5f;
    private static final List<sup> suz = new ArrayList<sup>();
    private static final List<sup> sva = new ArrayList<sup>();
    private static long svb = Long.MIN_VALUE;
    private static long svc = -1L;
    private static /* synthetic */ long svd;
    private static /* synthetic */ boolean sve;

    private sus() {
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        rfl rfl2 = rfl.get();
        if (rfl2 == null || !rfl2.isEnabled() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            suz.clear();
            svb = Long.MIN_VALUE;
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == svc) {
            return;
        }
        svc = unf.frame();
        long l = minecraftClient.field_1687.method_75260();
        if (l != svb) {
            svb = l;
            sus.svf(minecraftClient, rfl2);
        }
        if (suz.isEmpty()) {
            return;
        }
        float f = renderTickCounter.method_60637(true);
        try {
            usn2 = usn.capture(f, drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        sva.clear();
        for (sup object : suz) {
            if (object.first.method_31481()) continue;
            Vec3d vec3d = object.first.method_30950(f);
            double d = vec3d.field_1351 + (double)object.first.method_17682() + 0.12;
            if (!usn2.project(vec3d.field_1352, d, vec3d.field_1350, object.screen)) continue;
            object.distance = usn2.distance(vec3d.field_1352, d, vec3d.field_1350);
            sva.add(object);
        }
        sva.sort((sup2, sup3) -> Double.compare(sup3.distance, sup2.distance));
        uut.beginFrame();
        float f2 = Math.max(1, minecraftClient.method_22683().method_4495());
        for (sup sup4 : sva) {
            sus.svh(drawContext, rfl2, sup4, f2);
        }
        swh.step = swh.stepFor(1.0f);
    }

    private static void svf(MinecraftClient minecraftClient, rfl rfl2) {
        ItemEntity itemEntity2;
        suz.clear();
        double d = rfl2.range.get();
        Box box = minecraftClient.field_1724.method_5829().method_1009(d, d * 0.6, d);
        List list = minecraftClient.field_1687.method_8390(ItemEntity.class, box, itemEntity -> itemEntity.method_5805() && !itemEntity.method_6983().method_7960());
        Vec3d vec3d = minecraftClient.field_1724.method_33571();
        list.sort(Comparator.comparingDouble(itemEntity -> itemEntity.method_5707(vec3d)));
        boolean bl = rfl2.merge.get();
        Iterator iterator = list.iterator();
        while (iterator.hasNext() && !((itemEntity2 = (ItemEntity)iterator.next()).method_5707(vec3d) > d * d)) {
            sup sup2 = null;
            if (bl) {
                for (sup sup3 : suz) {
                    if (!(sup3.first.method_5858((Entity)itemEntity2) < 1.44) || !ItemStack.method_31577((ItemStack)sup3.stack, (ItemStack)itemEntity2.method_6983())) continue;
                    sup2 = sup3;
                    break;
                }
            }
            if (sup2 != null) {
                sup2.count += itemEntity2.method_6983().method_7947();
                continue;
            }
            if (suz.size() >= 48) continue;
            sup sup4 = new sup(itemEntity2);
            sup4.name = sup4.stack.method_7964().getString();
            sup4.color = sus.svg(sup4.stack, rfl2.rarity.get());
            suz.add(sup4);
        }
    }

    private static int svg(ItemStack itemStack, boolean bl) {
        if (!bl) {
            return -723722;
        }
        Rarity rarity = itemStack.method_7932();
        if (rarity == Rarity.field_8906) {
            return -723722;
        }
        Formatting formatting = rarity.method_58413();
        Integer n = formatting != null ? formatting.method_532() : null;
        return n == null ? -723722 : ujt.lerp(0xFF000000 | n, -1, 0.2f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void svh(DrawContext drawContext, rfl rfl2, sup sup2, float f) {
        float f2 = (float)Math.max(0.35, Math.min(1.0, 7.0 / Math.max(0.1, sup2.distance)));
        float f3 = (float)rfl2.size.get() * (0.35f + 0.65f * f2);
        swh.step = swh.stepFor(f3);
        f3 = swh.stepScale();
        boolean bl = rfl2.icon.get();
        if (sup2.widthStep != swh.step) {
            sup2.widthStep = swh.step;
            sup2.nameW = sut.width(sup2.name);
            sup2.countText = sup2.count > 1 ? a.d("\uf238", 66764453, 1120292068) + sup2.count : null;
            sup2.countW = sup2.countText != null ? suu.width(sup2.countText) : 0.0f;
        }
        String string = sup2.countText;
        float f4 = sup2.nameW;
        float f5 = 4.0f + (bl ? 11.5f : 0.0f) + f4 + (string != null ? 3.0f + sup2.countW : 0.0f) + 4.0f;
        float f6 = -f5 * 0.5f;
        float f7 = -11.5f;
        float f8 = f7 + 5.75f;
        float f9 = (float)Math.max(0.35, Math.min(1.0, 1.25 - sup2.distance / (rfl2.range.get() * 1.1)));
        float f10 = (float)Math.round(sup2.screen[0] * f) / f;
        float f11 = (float)Math.round(sup2.screen[1] * f) / f;
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f10, f11);
        drawContext.method_51448().scale(f3, f3);
        uut.pushAlpha(f9);
        try {
            float f12;
            boolean bl2 = rfl2.background.is(a.d("\u8d70\uf4e0\u7e32\ue048", -564243681, -82715099));
            if (!bl2) {
                uut.round(drawContext, f6, f7, f5, 11.5f, 5.75f, -1710552306);
                uut.outline(drawContext, f6, f7, f5, 11.5f, 5.75f, 0.8f, 0x16FFFFFF);
            }
            int n = ujt.withAlpha(0, bl2 ? 170 : 90);
            float f13 = f6 + 4.0f;
            if (bl) {
                f12 = 0.53125f;
                drawContext.method_51448().pushMatrix();
                drawContext.method_51448().translate(f13 + 4.25f, f8);
                drawContext.method_51448().scale(f12, f12);
                drawContext.method_51427(sup2.stack, -8, -8);
                drawContext.method_51448().popMatrix();
                f13 += 11.5f;
            }
            f12 = sut.centerTop(f8);
            sut.draw(drawContext, sup2.name, f13 + 0.5f, f12 + 0.5f, n);
            f13 = sut.draw(drawContext, sup2.name, f13, f12, sup2.color);
            if (string != null) {
                suu.draw(drawContext, string, f13 + 3.0f, suu.centerTop(f8), -1258291201);
            }
        }
        finally {
            uut.popAlpha();
            drawContext.method_51448().popMatrix();
        }
    }

    private static /* synthetic */ int cgv(int n, int n2) {
        return n ^ n2 | 0x7AF63F8F;
    }

    private static /* synthetic */ int cgw(int n, int n2) {
        return sus.cgv(n, n2) ^ 0x747B0C33;
    }
}

