/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.class_1735
 *  net.minecraft.class_1747
 *  net.minecraft.class_1767
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 *  net.minecraft.class_2480
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_9288
 *  net.minecraft.class_9334
 */
package a;

import a.Theme;
import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.DrawUtil;
import a.FontFace;
import a.Fonts;
import a.BoolSetting;
import a.NumberSetting;
import a.SlotUtil;
import flow.dev.StringDecryptor;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_1735;
import net.minecraft.class_1747;
import net.minecraft.class_1767;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_2480;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_9288;
import net.minecraft.class_9334;

public class ShulkerPreview
extends Module {
    private static ShulkerPreview pbf;
    private final NumberSetting pbg = this.add(new NumberSetting("Size", 1.0, 0.6, 1.6, 0.05).unit("x"));
    private final BoolSetting pbh = this.add(new BoolSetting("Box color", true));
    private final BoolSetting pbi = this.add(new BoolSetting("Compact", false));
    private static final FontFace pbj;
    private static final FontFace pbk;
    private static final float pbl = 18.0f;
    private static final float pbm = 5.0f;
    private static final float pbn = 13.0f;
    private final class_2371<class_1799> pbo = class_2371.method_10213((int)27, (Object)class_1799.field_8037);
    private static /* synthetic */ int pbp;
    private static /* synthetic */ int pbq;

    public ShulkerPreview() {
        super("ShulkerPreview", "See inside a shulker on hover", ModuleCategory.PLAYER);
        pbf = this;
    }

    public static void attach(class_437 class_4373) {
        if (!(class_4373 instanceof class_465)) {
            return;
        }
        class_465 class_4652 = (class_465)class_4373;
        ScreenEvents.afterRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> {
            ShulkerPreview pbe2 = pbf;
            if (pbe2 != null && pbe2.isEnabled()) {
                pbe2.pbr(class_4652, class_3322, n, n2);
            }
        });
    }

    private void pbr(class_465<?> class_4652, class_332 class_3322, int n, int n2) {
        int n3;
        class_1767 class_17672;
        int n4;
        int n5;
        class_1747 class_17472;
        if (!class_4652.method_17577().method_34255().method_7960()) {
            return;
        }
        class_1735 class_17352 = SlotUtil.hovered(class_4652);
        if (class_17352 == null || !class_17352.method_7681()) {
            return;
        }
        class_1799 class_17992 = class_17352.method_7677();
        class_1792 class_17922 = class_17992.method_7909();
        if (!(class_17922 instanceof class_1747) || !((class_17922 = (class_17472 = (class_1747)class_17922).method_7711()) instanceof class_2480)) {
            return;
        }
        class_2480 class_24802 = (class_2480)class_17922;
        class_17922 = (class_9288)class_17992.method_58694(class_9334.field_49622);
        for (n5 = 0; n5 < this.pbo.size(); ++n5) {
            this.pbo.set(n5, (Object)class_1799.field_8037);
        }
        if (class_17922 != null) {
            class_17922.method_57492(this.pbo);
        }
        n5 = 0;
        int n6 = 0;
        for (n4 = 0; n4 < 27; ++n4) {
            if (((class_1799)this.pbo.get(n4)).method_7960()) continue;
            ++n5;
            n6 = n4 / 9;
        }
        n4 = this.pbi.get() ? Math.max(1, n6 + 1) : 3;
        float f = 172.0f;
        float f2 = 18.0f + (float)n4 * 18.0f + 5.0f;
        float f3 = (float)this.pbg.get();
        int n7 = class_3322.method_51421();
        int n8 = class_3322.method_51443();
        float f4 = Math.max(2.0f, Math.min((float)n7 - f * f3 - 2.0f, (float)n + 10.0f));
        float f5 = (float)n2 - 18.0f - f2 * f3;
        if (f5 < 2.0f) {
            f5 = Math.min((float)n8 - f2 * f3 - 2.0f, (float)n2 + 22.0f);
        }
        int n9 = (class_17672 = class_24802.method_10528()) != null ? 0xFF000000 | class_17672.method_7787() : -6522701;
        int n10 = this.pbh.get() ? ColorUtil.lerp(-15592938, n9, 0.22f) : Theme.window | 0xFF000000;
        int n11 = this.pbh.get() ? ColorUtil.lerp(n9, -1, 0.25f) : Theme.stroke;
        int n12 = ColorUtil.withAlpha(ColorUtil.lerp(n10, -1, 0.07f), 235);
        float f6 = 6.0f;
        DrawUtil.beginFrame();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f4, f5);
        class_3322.method_51448().scale(f3, f3);
        DrawUtil.shadow(class_3322, 0.0f, 2.0f, f, f2, f6, 10.0f, 0x70000000);
        DrawUtil.round(class_3322, 0.0f, 0.0f, f, f2, f6, ColorUtil.withAlpha(n10, 245));
        DrawUtil.outline(class_3322, 0.0f, 0.0f, f, f2, f6, 1.0f, ColorUtil.withAlpha(n11, 150));
        String string = class_17992.method_7964().getString();
        String string2 = n5 + "/27";
        pbj.draw(class_3322, pbj.ellipsize(string, f - 10.0f - pbk.width(string2) - 8.0f), 6.0f, pbj.centerTop(8.5f), -855307);
        pbk.draw(class_3322, string2, f - 5.0f - pbk.width(string2), pbk.centerTop(8.5f), ColorUtil.withAlpha(n11, 220));
        for (int i = 0; i < n4; ++i) {
            for (n3 = 0; n3 < 9; ++n3) {
                DrawUtil.round(class_3322, 5.0f + (float)n3 * 18.0f + 0.5f, 18.0f + (float)i * 18.0f + 0.5f, 17.0f, 17.0f, 3.0f, n12);
            }
        }
        class_310 class_3102 = class_310.method_1551();
        for (n3 = 0; n3 < n4 * 9; ++n3) {
            class_1799 class_17993 = (class_1799)this.pbo.get(n3);
            if (class_17993.method_7960()) continue;
            int n13 = Math.round(5.0f + (float)(n3 % 9) * 18.0f + 1.0f);
            int n14 = Math.round(18.0f + (float)(n3 / 9) * 18.0f + 1.0f);
            class_3322.method_51427(class_17993, n13, n14);
            class_3322.method_51431(class_3102.field_1772, class_17993, n13, n14);
        }
        class_3322.method_51448().popMatrix();
    }

    static {
        pbj = Fonts.semibold(6.5f);
        pbk = Fonts.medium(5.5f);
    }

    private static /* synthetic */ int bgm(int n, int n2) {
        return n * n2 + -960197898;
    }
}

