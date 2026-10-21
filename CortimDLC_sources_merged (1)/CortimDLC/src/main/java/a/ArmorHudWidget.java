/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_746
 */
package a;

import a.Theme;
import a.Hud;
import a.HudWidget;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.BoolSetting;
import a.ModeSetting;
import a.Setting;
import flow.dev.StringDecryptor;
import java.util.List;
import net.minecraft.class_1304;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_746;

public final class ArmorHudWidget
extends HudWidget {
    public static final ModeSetting LAYOUT = new ModeSetting("Layout", "Row", "Row", "Column");
    public static final ModeSetting DURABILITY = new ModeSetting("Durability", "Percent", "Percent", "Bar", "Both");
    public static final BoolSetting HANDS = new BoolSetting("Hands", false);
    public static final List<Setting> OPTIONS = List.of(LAYOUT, DURABILITY, HANDS);
    private static final float ixv = 5.0f;
    private static final float ixw = 12.0f;
    private static final float ixx = 21.0f;
    private static final float ixy = 1.5f;
    private static final float ixz = 16.0f;
    private static final int iya = -12595334;
    private static final int iyb = -865972;
    private static final int iyc = -1092784;
    private static final class_1304[] iyd = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166, class_1304.field_6173, class_1304.field_6171};
    private final class_1799[] iye = new class_1799[iyd.length];
    private final int[] iyf = new int[iyd.length];
    private final Spring[] iyg = new Spring[iyd.length];
    private final Spring iyh = new Spring(13.0f, 60.0f);
    private final Spring iyi = new Spring(13.0f, 30.0f);
    private int iyj;
    private boolean iyk;
    private boolean iyl;
    private static class_1799[] iym;
    private static /* synthetic */ boolean iyn;
    private static /* synthetic */ long iyo;

    ArmorHudWidget() {
        super("armor", "Armor", true, 1, 2, 152.0f, 3.0f);
        for (int i = 0; i < iyd.length; ++i) {
            this.iye[i] = class_1799.field_8037;
            this.iyg[i] = new Spring(5.0f);
        }
    }

    @Override
    public List<Setting> settings() {
        return OPTIONS;
    }

    @Override
    void update(float f, boolean bl) {
        int n;
        this.iyj = HANDS.get() ? 6 : 4;
        class_746 class_7462 = class_310.method_1551().field_1724;
        boolean bl2 = false;
        if (class_7462 != null) {
            for (n = 0; n < 4; ++n) {
                bl2 |= !class_7462.method_6118(iyd[n]).method_7960();
            }
        }
        this.iyl = !bl2 && bl;
        for (n = 0; n < iyd.length; ++n) {
            int n2;
            class_1799 class_17992 = n >= this.iyj ? class_1799.field_8037 : (this.iyl ? ArmorHudWidget.iyp(n) : (class_7462 != null ? class_7462.method_6118(iyd[n]) : class_1799.field_8037));
            int n3 = n2 = class_17992.method_7963() ? class_17992.method_7919() : 0;
            if (!this.iyl && class_17992.method_7909() == this.iye[n].method_7909() && n2 > this.iyf[n]) {
                this.iyg[n].set(1.0f);
            }
            this.iye[n] = class_17992;
            this.iyf[n] = n2;
            this.iyg[n].step(0.0f, f);
        }
        this.iyk = bl2 || this.iyl;
        this.iyh.step(ArmorHudWidget.iyq() ? 27.0f + Hud.VALUE.width("100%") : 10.0f + (float)this.iyj * 21.0f + (float)(this.iyj - 1) * 1.5f, f);
        this.iyi.step(ArmorHudWidget.iyq() ? 10.0f + (float)this.iyj * 16.0f - 2.0f : 22.0f + (ArmorHudWidget.iyr() ? (ArmorHudWidget.iys() ? 10.5f : 8.5f) : 4.0f), f);
    }

    private static class_1799 iyp(int n) {
        if (iym == null) {
            class_1792[] class_1792Array = new class_1792[]{class_1802.field_22027, class_1802.field_22028, class_1802.field_8348, class_1802.field_8285, class_1802.field_22022, class_1802.field_8288};
            float[] fArray = new float[]{0.06f, 0.31f, 0.64f, 0.9f, 0.15f, 0.0f};
            iym = new class_1799[class_1792Array.length];
            for (int i = 0; i < class_1792Array.length; ++i) {
                class_1799 class_17992 = new class_1799((class_1935)class_1792Array[i]);
                if (class_17992.method_7963()) {
                    class_17992.method_7974(Math.round((float)class_17992.method_7936() * fArray[i]));
                }
                ArmorHudWidget.iym[i] = class_17992;
            }
        }
        return iym[n];
    }

    private static boolean iyq() {
        return LAYOUT.is("Column");
    }

    private static boolean iyr() {
        return !DURABILITY.is("Bar");
    }

    private static boolean iys() {
        return !DURABILITY.is("Percent");
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
    void draw(class_332 class_3322, float f, boolean bl) {
        float f2 = this.width();
        float f3 = this.height();
        Hud.panel(class_3322, f2, f3, Theme.r(7.0f));
        DrawUtil.pushScissor(class_3322, 0.0f, 0.0f, f2, f3);
        for (int i = 0; i < this.iyj; ++i) {
            if (ArmorHudWidget.iyq()) {
                this.iyu(class_3322, i, 5.0f, 5.0f + (float)i * 16.0f, f2 - 10.0f);
                continue;
            }
            this.iyt(class_3322, i, 5.0f + (float)i * 22.5f, 5.0f);
        }
        DrawUtil.popScissor(class_3322);
    }

    private void iyt(class_332 class_3322, int n, float f, float f2) {
        class_1799 class_17992 = this.iye[n];
        float f3 = f + 10.5f;
        if (n == 4) {
            DrawUtil.rect(class_3322, f - 0.75f - 0.5f, f2 + 2.0f, 1.0f, this.height() - 10.0f - 4.0f, ColorUtil.mulAlpha(Theme.textMuted, 0.3f));
        }
        if (class_17992.method_7960()) {
            DrawUtil.circle(class_3322, f3, f2 + 6.0f, 1.3f, ColorUtil.mulAlpha(Theme.textMuted, 0.4f));
            return;
        }
        ArmorHudWidget.iyv(class_3322, class_17992, f3, f2 + 6.0f);
        float f4 = ArmorHudWidget.iyw(class_17992);
        if (ArmorHudWidget.iyr()) {
            String string = ArmorHudWidget.iyx(class_17992, f4);
            Hud.SMALL.drawCentered(class_3322, string, f3, Hud.SMALL.centerTop(f2 + 12.0f + 4.4f), this.iyy(n, f4));
        }
        if (ArmorHudWidget.iys() && f4 >= 0.0f) {
            float f5 = 14.0f;
            float f6 = f2 + 12.0f + (ArmorHudWidget.iyr() ? 8.6f : 2.2f);
            ArmorHudWidget.iyz(class_3322, f3 - f5 * 0.5f, f6, f5, f4);
        }
    }

    private void iyu(class_332 class_3322, int n, float f, float f2, float f3) {
        class_1799 class_17992 = this.iye[n];
        float f4 = f2 + 6.0f + 0.5f;
        if (class_17992.method_7960()) {
            DrawUtil.circle(class_3322, f + 6.0f, f4, 1.3f, ColorUtil.mulAlpha(Theme.textMuted, 0.4f));
            return;
        }
        ArmorHudWidget.iyv(class_3322, class_17992, f + 6.0f, f4);
        float f5 = ArmorHudWidget.iyw(class_17992);
        if (ArmorHudWidget.iyr()) {
            Hud.VALUE.drawRight(class_3322, ArmorHudWidget.iyx(class_17992, f5), f + f3, Hud.VALUE.centerTop(f4), this.iyy(n, f5));
        }
        if (ArmorHudWidget.iys() && f5 >= 0.0f) {
            float f6 = f + 12.0f + 4.0f;
            float f7 = ArmorHudWidget.iyr() ? f3 - (f6 - f) - Hud.VALUE.width("100%") - 4.0f : f3 - (f6 - f);
            ArmorHudWidget.iyz(class_3322, f6, f4 - 0.65f, f7, f5);
        }
    }

    private static void iyv(class_332 class_3322, class_1799 class_17992, float f, float f2) {
        float f3 = 0.75f * Math.min(1.0f, DrawUtil.alpha() * 2.5f);
        if (f3 > 0.02f) {
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f, f2);
            class_3322.method_51448().scale(f3, f3);
            class_3322.method_51427(class_17992, -8, -8);
            class_3322.method_51448().popMatrix();
        }
    }

    private static float iyw(class_1799 class_17992) {
        if (!class_17992.method_7963() || class_17992.method_7936() <= 0) {
            return -1.0f;
        }
        return Math.max(0.0f, 1.0f - (float)class_17992.method_7919() / (float)class_17992.method_7936());
    }

    private static String iyx(class_1799 class_17992, float f) {
        if (f < 0.0f) {
            return class_17992.method_7947() > 1 ? "x" + class_17992.method_7947() : "";
        }
        return Math.round(f * 100.0f) + "%";
    }

    private int iyy(int n, float f) {
        int n2 = Theme.text;
        if (f >= 0.0f && f < 0.5f) {
            int n3 = n2 = f < 0.2f ? -1092784 : ColorUtil.lerp(Theme.text, -865972, (0.5f - f) / 0.3f);
        }
        if (f >= 0.0f && f < 0.12f) {
            float f2 = 0.5f + 0.5f * (float)Math.cos((double)System.nanoTime() / 1.0E9 * Math.PI * 3.0);
            n2 = ColorUtil.lerp(-1092784, -1, 0.35f * f2);
        }
        return ColorUtil.lerp(n2, -1, this.iyg[n].get());
    }

    private static void iyz(class_332 class_3322, float f, float f2, float f3, float f4) {
        float f5 = 1.3f;
        DrawUtil.round(class_3322, f, f2, f3, f5, f5 * 0.5f, Theme.track);
        DrawUtil.round(class_3322, f, f2, Math.max(f5, f3 * f4), f5, f5 * 0.5f, ArmorHudWidget.iza(f4));
    }

    private static int iza(float f) {
        return f > 0.5f ? ColorUtil.lerp(-865972, -12595334, (f - 0.5f) * 2.0f) : ColorUtil.lerp(-1092784, -865972, f * 2.0f);
    }

    private static /* synthetic */ int akx(int n, int n2) {
        return n - n2 + -1699123458;
    }
}

