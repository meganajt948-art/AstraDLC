/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1799
 *  net.minecraft.class_1814
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.Nametags;
import a.sup;
import a.swb;
import a.HealthBars;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.vek;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1814;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class NametagRenderer {
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

    private NametagRenderer() {
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        class_310 class_3102 = class_310.method_1551();
        Nametags rfl2 = Nametags.get();
        if (rfl2 == null || !rfl2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            suz.clear();
            svb = Long.MIN_VALUE;
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == svc) {
            return;
        }
        svc = FrameDelta.frame();
        long l = class_3102.field_1687.method_75260();
        if (l != svb) {
            svb = l;
            NametagRenderer.svf(class_3102, rfl2);
        }
        if (suz.isEmpty()) {
            return;
        }
        float f = class_97792.method_60637(true);
        try {
            usn2 = ScreenProjection.capture(f, class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        sva.clear();
        for (sup object : suz) {
            if (object.first.method_31481()) continue;
            class_243 class_2432 = object.first.method_30950(f);
            double d = class_2432.field_1351 + (double)object.first.method_17682() + 0.12;
            if (!usn2.project(class_2432.field_1352, d, class_2432.field_1350, object.screen)) continue;
            object.distance = usn2.distance(class_2432.field_1352, d, class_2432.field_1350);
            sva.add(object);
        }
        sva.sort((sup2, sup3) -> Double.compare(sup3.distance, sup2.distance));
        DrawUtil.beginFrame();
        float f2 = Math.max(1, class_3102.method_22683().method_4495());
        for (sup sup4 : sva) {
            NametagRenderer.svh(class_3322, rfl2, sup4, f2);
        }
        HealthBars.step = HealthBars.stepFor(1.0f);
    }

    private static void svf(class_310 class_3102, Nametags rfl2) {
        class_1542 class_15423;
        suz.clear();
        double d = rfl2.range.get();
        class_238 class_2383 = class_3102.field_1724.method_5829().method_1009(d, d * 0.6, d);
        List list = class_3102.field_1687.method_8390(class_1542.class, class_2383, class_15422 -> class_15422.method_5805() && !class_15422.method_6983().method_7960());
        class_243 class_2432 = class_3102.field_1724.method_33571();
        list.sort(Comparator.comparingDouble(class_15422 -> class_15422.method_5707(class_2432)));
        boolean bl = rfl2.merge.get();
        Iterator iterator = list.iterator();
        while (iterator.hasNext() && !((class_15423 = (class_1542)iterator.next()).method_5707(class_2432) > d * d)) {
            sup sup2 = null;
            if (bl) {
                for (sup sup3 : suz) {
                    if (!(sup3.first.method_5858((class_1297)class_15423) < 1.44) || !class_1799.method_31577((class_1799)sup3.stack, (class_1799)class_15423.method_6983())) continue;
                    sup2 = sup3;
                    break;
                }
            }
            if (sup2 != null) {
                sup2.count += class_15423.method_6983().method_7947();
                continue;
            }
            if (suz.size() >= 48) continue;
            sup sup4 = new sup(class_15423);
            sup4.name = sup4.stack.method_7964().getString();
            sup4.color = NametagRenderer.svg(sup4.stack, rfl2.rarity.get());
            suz.add(sup4);
        }
    }

    private static int svg(class_1799 class_17992, boolean bl) {
        if (!bl) {
            return -723722;
        }
        class_1814 class_18142 = class_17992.method_7932();
        if (class_18142 == class_1814.field_8906) {
            return -723722;
        }
        class_124 class_1242 = class_18142.method_58413();
        Integer n = class_1242 != null ? class_1242.method_532() : null;
        return n == null ? -723722 : ColorUtil.lerp(0xFF000000 | n, -1, 0.2f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void svh(class_332 class_3322, Nametags rfl2, sup sup2, float f) {
        float f2 = (float)Math.max(0.35, Math.min(1.0, 7.0 / Math.max(0.1, sup2.distance)));
        float f3 = (float)rfl2.size.get() * (0.35f + 0.65f * f2);
        HealthBars.step = HealthBars.stepFor(f3);
        f3 = HealthBars.stepScale();
        boolean bl = rfl2.icon.get();
        if (sup2.widthStep != HealthBars.step) {
            sup2.widthStep = HealthBars.step;
            sup2.nameW = sut.width(sup2.name);
            sup2.countText = sup2.count > 1 ? "x" + sup2.count : null;
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
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f10, f11);
        class_3322.method_51448().scale(f3, f3);
        DrawUtil.pushAlpha(f9);
        try {
            float f12;
            boolean bl2 = rfl2.background.is("None");
            if (!bl2) {
                DrawUtil.round(class_3322, f6, f7, f5, 11.5f, 5.75f, -1710552306);
                DrawUtil.outline(class_3322, f6, f7, f5, 11.5f, 5.75f, 0.8f, 0x16FFFFFF);
            }
            int n = ColorUtil.withAlpha(0, bl2 ? 170 : 90);
            float f13 = f6 + 4.0f;
            if (bl) {
                f12 = 0.53125f;
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f13 + 4.25f, f8);
                class_3322.method_51448().scale(f12, f12);
                class_3322.method_51427(sup2.stack, -8, -8);
                class_3322.method_51448().popMatrix();
                f13 += 11.5f;
            }
            f12 = sut.centerTop(f8);
            sut.draw(class_3322, sup2.name, f13 + 0.5f, f12 + 0.5f, n);
            f13 = sut.draw(class_3322, sup2.name, f13, f12, sup2.color);
            if (string != null) {
                suu.draw(class_3322, string, f13 + 3.0f, suu.centerTop(f8), -1258291201);
            }
        }
        finally {
            DrawUtil.popAlpha();
            class_3322.method_51448().popMatrix();
        }
    }

    private static /* synthetic */ int cgv(int n, int n2) {
        return n ^ n2 | 0x7AF63F8F;
    }

    private static /* synthetic */ int cgw(int n, int n2) {
        return NametagRenderer.cgv(n, n2) ^ 0x747B0C33;
    }
}

