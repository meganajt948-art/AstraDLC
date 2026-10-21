/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4184
 *  net.minecraft.class_9779
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.Theme;
import a.ModuleCategory;
import a.Module;
import a.MobEsp;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.FontFace;
import a.Fonts;
import a.BoolSetting;
import a.ColorSetting;
import a.NumberSetting;
import a.Lang;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4184;
import net.minecraft.class_9779;

public class RangeIndicator
extends Module {
    private static RangeIndicator qyl;
    private final NumberSetting qym = this.add(new NumberSetting("Range", 64.0, 8.0, 256.0, 8.0).suffix("m"));
    private final NumberSetting qyn = this.add(new NumberSetting("Radius", 44.0, 20.0, 140.0, 2.0));
    private final NumberSetting qyo = this.add(new NumberSetting("Size", 1.0, 0.6, 1.8, 0.05).percent());
    private final ColorSetting qyp = this.add(new ColorSetting("Color", "Theme"));
    private final BoolSetting qyq = this.add(new BoolSetting("Friends", true));
    private final ColorSetting qyr = this.add(new ColorSetting("Friend color", "Mint"));
    private final BoolSetting qys = this.add(new BoolSetting("Distance", false));
    private final BoolSetting qyt = this.add(new BoolSetting("Mobs", false));
    private final NumberSetting qyu = this.add(new NumberSetting("Mob range", 64.0, 8.0, 256.0, 8.0).suffix("m"));
    private static final FontFace qyv;
    private final Map<Integer, Spring> qyw = new HashMap<Integer, Spring>();
    private final Set<Integer> qyx = new HashSet<Integer>();
    private long qyy = -1L;
    private static /* synthetic */ long qyz;
    private static /* synthetic */ long qza;

    public RangeIndicator() {
        super(new String(new char[]{'A', 'r', 'r', 'o', 'w', 's'}), "Arrows pointing at players and mobs around you", ModuleCategory.RENDER);
        qyl = this;
        this.qyr.visibleWhen(this.qyq::get);
        this.qyu.visibleWhen(this.qyt::get);
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        RangeIndicator qyk2 = qyl;
        class_310 class_3102 = class_310.method_1551();
        if (qyk2 == null || !qyk2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            if (qyk2 != null) {
                qyk2.qyw.clear();
            }
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == qyk2.qyy) {
            return;
        }
        qyk2.qyy = FrameDelta.frame();
        qyk2.qzb(class_3322, class_3102, class_97792.method_60637(true), FrameDelta.delta());
    }

    private void qzb(class_332 class_3322, class_310 class_3102, float f, float f2) {
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_71156();
        float f3 = class_41842.method_19330();
        float f4 = (float)class_3322.method_51421() * 0.5f;
        float f5 = (float)class_3322.method_51443() * 0.5f;
        double d = this.qym.get();
        float f6 = (float)this.qyo.get();
        Theme.update(f2);
        DrawUtil.beginFrame();
        this.qyx.clear();
        for (class_1657 class_16572 : class_3102.field_1687.method_18456()) {
            boolean bl;
            if (class_16572 == class_3102.field_1724 || class_16572 == class_3102.method_1560() || class_16572.method_7325() || !class_16572.method_5805() || (bl = Friends.isFriend((class_1297)class_16572)) && !this.qyq.get()) continue;
            int n = bl ? this.qyr.color() : this.qyp.color();
            this.qzc(class_3322, (class_1297)class_16572, f, class_2432, f3, f4, f5, d, f6, f2, n);
        }
        MobEsp rhs2 = MobEsp.get();
        if (this.qyt.get() && rhs2 != null) {
            double d2 = this.qyu.get();
            double d3 = (d2 + 4.0) * (d2 + 4.0);
            for (class_1297 class_12972 : class_3102.field_1687.method_18112()) {
                if (class_12972 == class_3102.method_1560() || !(class_12972.method_5707(class_2432) <= d3) || !rhs2.picks(class_12972)) continue;
                this.qzc(class_3322, class_12972, f, class_2432, f3, f4, f5, d2, f6, f2, rhs2.colorOf(class_12972));
            }
        }
        this.qyw.keySet().retainAll(this.qyx);
    }

    private void qzc(class_332 class_3322, class_1297 class_12972, float f, class_243 class_2432, float f2, float f3, float f4, double d, float f5, float f6, int n2) {
        class_243 class_2433 = class_12972.method_30950(f);
        double d2 = class_2433.field_1352 - class_2432.field_1352;
        double d3 = class_2433.field_1350 - class_2432.field_1350;
        double d4 = Math.sqrt(d2 * d2 + d3 * d3 + (class_2433.field_1351 - class_2432.field_1351) * (class_2433.field_1351 - class_2432.field_1351));
        Spring vcj2 = this.qyw.computeIfAbsent(class_12972.method_5628(), n -> new Spring(10.0f));
        this.qyx.add(class_12972.method_5628());
        float f7 = vcj2.step(d4 <= d, f6);
        if (f7 <= 0.01f) {
            return;
        }
        double d5 = Math.toRadians(Math.toDegrees(Math.atan2(d3, d2)) - 90.0 - (double)f2);
        float f8 = (float)Math.max(0.25, 1.0 - d4 / Math.max(1.0, d));
        RangeIndicator.qzd(class_3322, f3, f4, (float)d5, (float)this.qyn.get(), f5, n2 | 0xFF000000, f7 * (0.45f + 0.55f * f8));
        if (this.qys.get()) {
            String string = Math.round(d4) + Lang.unit("m");
            float f9 = (float)this.qyn.get() + 10.0f * f5;
            float f10 = f3 + (float)Math.sin(d5) * f9;
            float f11 = f4 - (float)Math.cos(d5) * f9;
            float f12 = qyv.width(string);
            DrawUtil.pushAlpha(f7);
            qyv.draw(class_3322, string, f10 - f12 * 0.5f + 0.5f, qyv.centerTop(f11) + 0.5f, -1946157056);
            qyv.draw(class_3322, string, f10 - f12 * 0.5f, qyv.centerTop(f11), -419430401);
            DrawUtil.popAlpha();
        }
    }

    private static void qzd(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f2);
        class_3322.method_51448().rotate(f3);
        class_3322.method_51448().translate(0.0f, -f4);
        DrawUtil.pushAlpha(f6);
        float f7 = 5.2f * f5;
        float f8 = 4.2f * f5;
        float f9 = 1.8f * f5;
        DrawUtil.shadow(class_3322, -f7, -f8, f7 * 2.0f, f8 * 2.0f, f8, 3.0f * f5, 0x46000000);
        DrawUtil.line(class_3322, -f7, f8 * 0.5f, 0.0f, -f8 * 0.5f, f9, n);
        DrawUtil.line(class_3322, f7, f8 * 0.5f, 0.0f, -f8 * 0.5f, f9, n);
        DrawUtil.popAlpha();
        class_3322.method_51448().popMatrix();
    }

    static {
        qyv = Fonts.semibold(5.6f);
    }

    private static /* synthetic */ int bwr(int n, int n2) {
        return n * n2 | 0xB0F61228;
    }
}

