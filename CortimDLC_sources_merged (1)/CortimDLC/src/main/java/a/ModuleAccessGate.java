/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.LiquidGlass;
import a.Widget;
import a.Theme;
import a.irk;
import a.UiKit;
import a.Module;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.IconRenderer;
import a.BoolSetting;
import a.Setting;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_332;

final class ModuleAccessGate {
    private static final float hjh = 10.0f;
    private static final float hji = 27.0f;
    private static final FontFace hjj;
    private static final String hjk;
    private static final int hjl = -14003;
    private static final int hjm = -1013204;
    private static final int hjn = -14018301;
    private static final boolean hjo;
    final Module module;
    final String title;
    private final String hjp;
    final List<Widget> rows = new ArrayList<Widget>();
    private BoolSetting hjq;
    private final irk hjr;
    private final Spring hjs = new Spring(14.0f);
    private final Spring hjt;
    private final Spring hju = new Spring(13.0f, 1.0f);
    private final Spring hjv = new Spring(16.0f);
    private final Spring hjw = new Spring(14.0f);
    private final Spring hjx = new Spring(7.0f);
    private boolean hjy;
    private float hjz;
    private float hka;
    float x;
    float y;
    float w;
    int column;
    int home = -1;
    boolean wide;
    private static /* synthetic */ long hkb;
    private static /* synthetic */ int hkc;

    ModuleAccessGate(Module kfe2) {
        this.module = kfe2;
        this.title = kfe2.getDisplayName();
        this.hjp = null;
        this.hjt = new Spring(12.0f, kfe2.isEnabled() ? 1.0f : 0.0f);
        this.hjr = kfe2.isLocked() ? null : new irk(kfe2.getDisplayName(), kfe2::getKey, kfe2::setKey, true);
        this.settings(kfe2.getSettings());
        this.hjy = !this.rows.isEmpty();
        this.hju.set(this.hjy ? 0.0f : 1.0f);
    }

    String shownTitle() {
        return this.module != null ? this.title : Lang.t(this.title);
    }

    String description() {
        String string = Lang.t(this.module != null ? this.module.getDescription() : (this.hjp != null ? this.hjp : ""));
        if (this.hkg()) {
            return Lang.s("Under maintenance. ", "Тех. работы. ") + string;
        }
        return this.hkf() ? Lang.s("VIP only. ", "Только для VIP. ") + string : string;
    }

    String searchDescription() {
        return Lang.both(this.module != null ? this.module.getDescription() : this.hjp);
    }

    float headBottom() {
        return this.y + 27.0f;
    }

    ModuleAccessGate(String string, String string2) {
        this.module = null;
        this.title = string;
        this.hjp = string2;
        this.hjt = new Spring(12.0f, 0.0f);
        this.hjr = null;
        this.hjy = hjo;
        this.hju.set(this.hjy ? 0.0f : 1.0f);
    }

    ModuleAccessGate settings(List<? extends Setting> list) {
        for (Setting vmo2 : list) {
            Widget imn2 = Widget.of(vmo2);
            if (imn2 == null) continue;
            this.rows.add(imn2);
        }
        return this;
    }

    ModuleAccessGate row(Widget imn2) {
        this.rows.add(imn2);
        return this;
    }

    ModuleAccessGate unfolded() {
        this.hjy = false;
        this.hju.set(1.0f);
        return this;
    }

    ModuleAccessGate toggle(BoolSetting vkl2) {
        this.hjq = vkl2;
        this.hjt.set(vkl2.get() ? 1.0f : 0.0f);
        return this;
    }

    Widget rowFor(Setting vmo2) {
        for (Widget imn2 : this.rows) {
            if (imn2.setting != vmo2) continue;
            return imn2;
        }
        return null;
    }

    boolean isCollapsed() {
        return this.hjy && !this.rows.isEmpty();
    }

    void setCollapsed(boolean bl) {
        this.hjy = bl && !this.rows.isEmpty();
    }

    private boolean hkd() {
        return this.module != null ? this.module.isEnabled() : this.hjq != null && this.hjq.get();
    }

    private boolean hke() {
        return this.module != null && !this.module.isLocked() || this.hjq != null;
    }

    private boolean hkf() {
        return this.module != null && this.module.isVip();
    }

    private boolean hkg() {
        return this.module != null && this.module.isMaintenance();
    }

    private boolean hkh() {
        return this.module != null && this.module.isLocked();
    }

    private float hki() {
        if (this.rows.isEmpty()) {
            return 0.0f;
        }
        float f = 5.0f;
        for (Widget imn2 : this.rows) {
            f += imn2.currentHeight();
        }
        return f + 6.0f;
    }

    private float hkj() {
        if (this.rows.isEmpty()) {
            return 0.0f;
        }
        float f = 11.0f;
        for (Widget imn2 : this.rows) {
            f += imn2.targetHeight();
        }
        return f;
    }

    float targetHeight() {
        return 27.0f + (this.hjy ? 0.0f : this.hkj());
    }

    float height() {
        return 27.0f + this.hki() * this.hju.get();
    }

    boolean headerHovered(float f, float f2) {
        return UiKit.inside(f, f2, this.x, this.y, this.w, 27.0f);
    }

    boolean hovered(float f, float f2) {
        return UiKit.inside(f, f2, this.x, this.y, this.w, this.height());
    }

    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4;
        boolean bl = hlc2.canHover();
        float f5 = this.hjs.step(bl && this.hovered(f, f2), f3);
        float f6 = this.hjt.step(this.hkd(), f3);
        this.hju.step(this.hjy ? 0.0f : 1.0f, f3);
        float f7 = this.hjw.step(this.hjr != null && hlc2.binding() == this.hjr, f3);
        for (Widget imn2 : this.rows) {
            imn2.animate(f3);
        }
        float f8 = this.height();
        float f9 = Theme.r(7.0f);
        float f10 = Theme.lightness();
        class_3322.method_51448().pushMatrix();
        GlassDraw.shadow(class_3322, this.x, this.y, this.w, f8, f9, 0.3f, f10);
        int n = ColorUtil.lerp(Theme.card, Theme.cardHover, f5);
        boolean bl2 = LiquidGlass.surface(class_3322, this.x, this.y, this.w, f8, f9, LiquidGlass.tint(Theme.window, Math.min(0.95f, Theme.windowTint())), n, 7.0f, LiquidGlass.CARDS);
        if (bl2) {
            DrawUtil.round(class_3322, this.x, this.y, this.w, f8, f9, ColorUtil.mulAlpha(n, ColorUtil.alpha(n) > 128 ? 0.35f : 1.0f));
        }
        GlassDraw.sheen(class_3322, this.x, this.y, this.w, Math.min(f8, 60.0f), f9, 1.0f - 0.7f * f10);
        DrawUtil.outline(class_3322, this.x, this.y, this.w, f8, f9, 1.0f, ColorUtil.lerp(Theme.stroke, ColorUtil.lerp(Theme.stroke, Theme.textMuted, 0.25f), f5));
        GlassDraw.rim(class_3322, this.x, this.y, this.w, f8, f9, f10, 0.8f);
        float f11 = this.y + 13.5f;
        float f12 = this.x + this.w - 10.0f;
        float f13 = this.hkk(f3);
        if (this.hkh()) {
            var18_20 = this.headerHovered(f, f2) ? f5 : 0.0f;
            IconRenderer.draw(class_3322, Icon.LOCK, f12 - 5.0f + f13, f11, 7.5f, ColorUtil.lerp(Theme.textMuted, this.hkg() ? -1013204 : Theme.accent(), Math.max(var18_20 * 0.7f, this.hjx.get())));
            f12 -= 16.0f;
        } else if (this.hke()) {
            UiKit.drawSwitch(class_3322, f12 - 17.0f, f11 - 4.75f, f6, f5 * (this.headerHovered(f, f2) ? 1.0f : 0.0f));
            f12 -= 23.0f;
        } else if (!this.rows.isEmpty()) {
            var18_20 = this.hju.get();
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f12 - 4.0f, f11);
            class_3322.method_51448().rotate(-1.5707964f * (1.0f - var18_20));
            IconRenderer.draw(class_3322, Icon.CHEVRON_DOWN, 0.0f, 0.0f, 7.0f, ColorUtil.lerp(Theme.textMuted, Theme.textDim, Math.max(f5, var18_20 * 0.5f)));
            class_3322.method_51448().popMatrix();
            f12 -= 14.0f;
        }
        if (this.hjr != null) {
            f12 = this.hko(class_3322, hlc2, f12, f11, f, f2, f3, f5, f7);
        }
        int n2 = this.hke() ? ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f6, f5 * 0.6f)) : Theme.text;
        float f14 = this.x + 10.0f;
        if (this.hkh()) {
            String string = this.hkg() ? ModuleAccessGate.hkl() : "VIP";
            f4 = ModuleAccessGate.hkm(string);
            String string2 = UiKit.CARD_TITLE.ellipsize(this.shownTitle(), f12 - f14 - 4.0f - f4 - 5.0f);
            UiKit.CARD_TITLE.draw(class_3322, string2, f14, UiKit.CARD_TITLE.centerTop(f11), ColorUtil.lerp(Theme.textDim, Theme.text, f5 * 0.4f));
            float f15 = f14 + UiKit.CARD_TITLE.width(string2) + 5.0f + f13;
            if (this.hkg()) {
                this.hkn(class_3322, f15, f11, f5, Icon.WRENCH, string, -14003, -1013204, -14018301, -1013204);
            } else {
                this.hkn(class_3322, f15, f11, f5, Icon.CROWN, string, Theme.accent(), Theme.accent2(), Theme.onAccent(), Theme.accent());
            }
        } else {
            UiKit.CARD_TITLE.draw(class_3322, UiKit.CARD_TITLE.ellipsize(this.shownTitle(), f12 - f14 - 4.0f), f14, UiKit.CARD_TITLE.centerTop(f11), n2);
        }
        float f16 = f8 - 27.0f;
        if (f16 > 0.5f) {
            f4 = this.hju.get();
            DrawUtil.pushAlpha(Math.min(1.0f, f4 * 1.4f));
            DrawUtil.rect(class_3322, this.x + 10.0f, this.y + 27.0f - 0.5f, this.w - 20.0f, 1.0f, Theme.divider);
            DrawUtil.pushScissor(class_3322, this.x, this.y + 27.0f, this.w, f16);
            float f17 = this.y + 27.0f + 5.0f;
            for (Widget imn3 : this.rows) {
                float f18 = imn3.currentHeight();
                imn3.x = this.x + 10.0f;
                imn3.y = f17;
                imn3.w = this.w - 20.0f;
                if (f18 > 0.3f) {
                    DrawUtil.pushScissor(class_3322, this.x, f17, this.w, f18);
                    DrawUtil.pushAlpha(imn3.opacity());
                    imn3.render(class_3322, hlc2, imn3.interactive() ? f : -1000.0f, imn3.interactive() ? f2 : -1000.0f, f3);
                    DrawUtil.popAlpha();
                    DrawUtil.popScissor(class_3322);
                }
                f17 += f18;
            }
            DrawUtil.popScissor(class_3322);
            DrawUtil.popAlpha();
        }
        class_3322.method_51448().popMatrix();
    }

    private float hkk(float f) {
        float f2 = this.hjx.step(0.0f, f);
        return f2 < 0.01f ? 0.0f : (float)Math.sin((double)(1.0f - f2) * Math.PI * 6.0) * 2.2f * f2;
    }

    private static String hkl() {
        return Lang.s("Maintenance", "Тех. работы");
    }

    private static float hkm(String string) {
        return 8.5f + hjj.width(string) + 9.0f;
    }

    private void hkn(class_332 class_3322, float f, float f2, float f3, Icon vhz2, String string, int n, int n2, int n3, int n4) {
        float f4;
        float f5 = ModuleAccessGate.hkm(string);
        float f6 = 11.0f;
        float f7 = f2 - f6 * 0.5f;
        float f8 = Theme.r(3.5f);
        float f9 = 0.5f + 0.5f * (float)Math.sin((double)System.nanoTime() / 4.5E8);
        DrawUtil.shadow(class_3322, f, f7, f5, f6, f8, 3.5f, ColorUtil.withAlpha(n4, (int)(40.0f + 50.0f * f9 + 40.0f * f3)));
        DrawUtil.gradientH(class_3322, f, f7, f5, f6, f8, n, n2);
        GlassDraw.sheen(class_3322, f, f7, f5, f6, f8, 1.6f);
        float f10 = (float)(System.nanoTime() / 1000000L % 2600L) / 2600.0f;
        if (f10 < 0.55f) {
            f4 = f10 / 0.55f;
            float f11 = 7.0f;
            float f12 = f - f11 + (f5 + f11) * f4;
            int n5 = ColorUtil.withAlpha(-1, (int)(95.0 * Math.sin(Math.PI * (double)f4)));
            DrawUtil.pushScissor(class_3322, f, f7, f5, f6);
            DrawUtil.gradientH(class_3322, f12, f7, f11 * 0.5f, f6, 0.0f, 0xFFFFFF, n5);
            DrawUtil.gradientH(class_3322, f12 + f11 * 0.5f, f7, f11 * 0.5f, f6, 0.0f, n5, 0xFFFFFF);
            DrawUtil.popScissor(class_3322);
        }
        DrawUtil.outlineGradientV(class_3322, f, f7, f5, f6, f8, 1.0f, 0x50FFFFFF, 0x14000000);
        f4 = 6.0f;
        IconRenderer.draw(class_3322, vhz2, f + 4.5f + f4 * 0.5f, f2 - 0.2f, f4, n3);
        hjj.draw(class_3322, string, f + 4.5f + f4 + 2.5f, hjj.centerTop(f2), n3);
    }

    private float hko(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        boolean bl;
        int n = this.hjr.get();
        boolean bl2 = bl = n != -1;
        String string = f7 > 0.5f ? "..." : (bl ? UiKit.keyName(n) : Lang.s("Bind", "Бинд"));
        float f8 = Math.max(bl ? 1.0f : f6, f7);
        this.hka = Math.max(16.0f, UiKit.SMALL.width(string) + 9.0f);
        this.hjz = f - this.hka;
        float f9 = this.hjv.step(hlc2.canHover() && UiKit.inside(f3, f4, this.hjz, f2 - 5.5f, this.hka, 11.0f), f5);
        if (f8 <= 0.01f) {
            return f;
        }
        DrawUtil.pushAlpha(f8);
        float f10 = f7 > 0.01f ? 0.55f + 0.45f * (float)Math.sin((double)System.nanoTime() / 1.6E8) : 0.0f;
        int n2 = bl || f7 > 0.01f ? ColorUtil.lerp(Theme.textDim, Theme.accent(), f7) : Theme.textMuted;
        UiKit.drawChip(class_3322, string, f, f2, ColorUtil.lerp(n2, Theme.text, f9), ColorUtil.lerp(Theme.stroke, Theme.accent((int)(120.0f + 110.0f * f10)), f7), f9);
        DrawUtil.popAlpha();
        return this.hjz - 4.0f;
    }

    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (this.headerHovered(f, f2)) {
            boolean bl;
            boolean bl2 = bl = this.hjr != null && UiKit.inside(f, f2, this.hjz, this.y + 13.5f - 5.5f, this.hka, 11.0f);
            if (this.hjr != null && (n == 2 || n == 0 && bl)) {
                hlc2.startBinding(this.hjr);
            } else if (n == 1 && !this.rows.isEmpty()) {
                this.hjy = !this.hjy;
            } else if (n == 0 && this.hkg()) {
                this.hjx.set(1.0f);
                hlc2.toast(Lang.s("Under maintenance, back soon", "Модуль на тех. работах, скоро вернём"), Icon.WRENCH, true);
            } else if (n == 0 && this.hkf()) {
                this.hjx.set(1.0f);
                hlc2.toast(Lang.s("Available with VIP only", "Доступно только с VIP"), Icon.CROWN, true);
            } else if (n == 0 && this.module != null) {
                this.module.toggle();
            } else if (n == 0 && this.hjq != null) {
                this.hjq.toggle();
            } else if (n == 0 && !this.rows.isEmpty()) {
                this.hjy = !this.hjy;
            }
            return true;
        }
        if (this.hju.get() > 0.9f) {
            for (Widget imn2 : this.rows) {
                if (!imn2.interactive() || !imn2.mouseClicked(hlc2, f, f2, n)) continue;
                return true;
            }
        }
        return true;
    }

    static {
        hjk = "VIP";
        hjj = Fonts.bold(5.5f);
        hjo = !Boolean.getBoolean("flow2.selftest");
    }

    private static /* synthetic */ int abe(int n, int n2) {
        return n * n2 ^ 0x3141C5E1;
    }
}

