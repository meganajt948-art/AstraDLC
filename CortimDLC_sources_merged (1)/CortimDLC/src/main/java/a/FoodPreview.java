/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10799
 *  net.minecraft.class_1268
 *  net.minecraft.class_1309
 *  net.minecraft.class_1702
 *  net.minecraft.class_1799
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4174
 *  net.minecraft.class_746
 *  net.minecraft.class_9334
 *  net.minecraft.class_9779
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.DrawUtil;
import a.FontFace;
import a.Fonts;
import a.BoolSetting;
import java.util.Locale;
import net.minecraft.class_10799;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1702;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4174;
import net.minecraft.class_746;
import net.minecraft.class_9334;
import net.minecraft.class_9779;

public class FoodPreview
extends Module {
    private static FoodPreview rpk;
    private final BoolSetting rpl = this.add(new BoolSetting("Food preview", true));
    private final BoolSetting rpm = this.add(new BoolSetting("Number", false));
    private static final class_2960 rpn;
    private static final class_2960 rpo;
    private static final int rpp = -670639;
    private static final FontFace rpq;
    private static /* synthetic */ String rpr;
    private static /* synthetic */ String rps;

    public FoodPreview() {
        super(new String(new char[]{'S', 'a', 't', 'u', 'r', 'a', 't', 'i', 'o', 'n'}), "Shows saturation on the hunger bar", ModuleCategory.RENDER);
        rpk = this;
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        float f;
        float f2;
        Object object;
        FoodPreview rpj2 = rpk;
        class_310 class_3102 = class_310.method_1551();
        class_746 class_7462 = class_3102.field_1724;
        if (rpj2 == null || !rpj2.isEnabled() || class_7462 == null || class_3102.field_1761 == null || !class_3102.field_1761.method_2908() || class_7462.method_5854() instanceof class_1309) {
            return;
        }
        class_1702 class_17022 = class_7462.method_7344();
        int n = class_17022.method_7586();
        float f3 = class_17022.method_7589();
        int n2 = class_3322.method_51421() / 2 + 91;
        int n3 = class_3322.method_51443() - 39;
        class_4174 class_41742 = null;
        if (rpj2.rpl.get()) {
            for (class_1268 class_12682 : class_1268.values()) {
                class_1799 class_17992 = class_7462.method_5998(class_12682);
                object = (class_4174)class_17992.method_58694(class_9334.field_50075);
                if (object == null) continue;
                class_41742 = object;
                break;
            }
        }
        float f4 = 0.35f + 0.3f * (float)Math.sin((double)System.currentTimeMillis() / 180.0);
        if (class_41742 != null && n < 20) {
            int n4 = Math.min(20, n + class_41742.comp_2491());
            int n5 = ColorUtil.withAlpha(-1, Math.round(255.0f * f4));
            for (int i = 0; i < 10; ++i) {
                int n6;
                int n7;
                int n8 = i * 2 + 1;
                int n9 = n8 < n ? 2 : (n7 = n8 == n ? 1 : 0);
                int n10 = n8 < n4 ? 2 : (n6 = n8 == n4 ? 1 : 0);
                if (n6 <= n7) continue;
                class_3322.method_52707(class_10799.field_56883, n6 == 2 ? rpn : rpo, n2 - i * 8 - 9, n3, 9, 9, n5);
            }
        }
        DrawUtil.beginFrame();
        float f5 = 80.0f;
        float f6 = 1.3f;
        float f7 = (float)n3 - f6 - 0.6f;
        DrawUtil.round(class_3322, (float)n2 - f5 - 0.5f, f7, f5, f6, f6 * 0.5f, 0x55000000);
        float f8 = f5 * Math.max(0.0f, Math.min(20.0f, f3)) / 20.0f;
        if (class_41742 != null && (f2 = f5 * Math.max(0.0f, f = Math.min(Math.min(20.0f, (float)(n + class_41742.comp_2491())), f3 + class_41742.comp_2492())) / 20.0f) > f8) {
            DrawUtil.round(class_3322, (float)n2 - f2 - 0.5f, f7, f2, f6, f6 * 0.5f, ColorUtil.withAlpha(-670639, Math.round(255.0f * f4)));
        }
        if (f8 > 0.2f) {
            DrawUtil.round(class_3322, (float)n2 - f8 - 0.5f, f7, f8, f6, f6 * 0.5f, -670639);
        }
        if (rpj2.rpm.get()) {
            object = String.format(Locale.ROOT, "%.1f", Float.valueOf(f3));
            rpq.draw(class_3322, (String)object, (float)n2 + 3.0f, rpq.centerTop((float)n3 + 4.5f) + 0.5f, -1879048192);
            rpq.draw(class_3322, (String)object, (float)n2 + 2.5f, rpq.centerTop((float)n3 + 4.5f), -670639);
        }
    }

    static {
        rpn = class_2960.method_60656((String)"hud/food_full");
        rpo = class_2960.method_60656((String)"hud/food_half");
        rpq = Fonts.semibold(5.8f);
    }

    private static /* synthetic */ int cap(int n, int n2) {
        return n ^ n2 | 0xBD5FD127;
    }
}

