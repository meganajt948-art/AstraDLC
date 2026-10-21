/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package a;

import a.LiquidGlass;
import a.Theme;
import a.UiKit;
import a.ivw;
import a.ivx;
import a.ColorUtil;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class WheelScreen
extends class_437 {
    private static final float iwg = (float)Math.PI * 2;
    private static final float iwh = 30.0f;
    private static final float iwi = 12.0f;
    private static final float iwj = 19.0f;
    private static final float iwk = 9.0f;
    private static final long iwl = 240000000L;
    private final ivw iwm;
    private final int iwn;
    private final long iwo = System.nanoTime();
    private final Spring iwp = new Spring(20.0f);
    private final Spring iwq = new Spring(18.0f);
    private final List<Spring> iwr = new ArrayList<Spring>();
    private List<ivx> iws = List.of();
    private int iwt = -1;
    private int iwu = -1;
    private int iwv;
    private boolean iww;
    private boolean iwx = true;
    private boolean iwy;
    private long iwz = -1L;
    private float ixa = 0.016666668f;
    private static final int ixb = 37;
    private static /* synthetic */ long ixc;
    private static /* synthetic */ String ixd;

    public WheelScreen(ivw ivw2, int n) {
        super((class_2561)class_2561.method_43470((String)"Wheel"));
        this.iwm = ivw2;
        this.iwn = n;
        this.iww = n == -1;
    }

    private void ixe(class_332 class_3322) {
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == this.iwz) {
            return;
        }
        this.iwz = FrameDelta.frame();
        this.ixa = FrameDelta.delta() * (float)Theme.ANIMATION.get();
        Theme.update(this.ixa);
        this.iwp.step(true, this.ixa);
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
        DrawUtil.beginFrame();
        this.ixe(class_3322);
        LiquidGlass.skip();
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, ColorUtil.withAlpha(0, Math.round(64.0f * Easing.outCubic(this.iwp.get()))));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        this.ixe(class_3322);
        this.iws = this.iwm.slots();
        int n3 = this.iws.size();
        if (n3 == 0) {
            this.ixl();
            return;
        }
        while (this.iwr.size() < n3) {
            this.iwr.add(new Spring(18.0f));
        }
        float f2 = Easing.outCubic(this.iwp.get());
        float f3 = (float)this.field_22789 * 0.5f;
        float f4 = (float)this.field_22790 * 0.5f;
        float f5 = this.iwq.step(this.iwu >= 0, this.ixa);
        this.iwt = this.iwu >= 0 || this.iwy ? -1 : WheelScreen.ixg((float)n - f3, (float)n2 - f4, n3);
        this.ixi();
        DrawUtil.pushAlpha(f2 * (1.0f - 0.6f * f5));
        try {
            this.ixh(class_3322, f3, f4, n3, 0.9f + 0.1f * f2);
        }
        finally {
            DrawUtil.popAlpha();
        }
        if (f5 > 0.01f) {
            DrawUtil.pushAlpha(f5);
            try {
                this.ixr(class_3322, n, n2, f5);
            }
            finally {
                DrawUtil.popAlpha();
            }
        }
    }

    private static float ixf(int n) {
        return Math.max(50.0f, (float)n * 42.0f / ((float)Math.PI * 2));
    }

    private static int ixg(float f, float f2, int n) {
        if (f * f + f2 * f2 < 144.0f) {
            return -1;
        }
        float f3 = (float)(Math.atan2(f, -f2) / 6.2831854820251465);
        if (f3 < 0.0f) {
            f3 += 1.0f;
        }
        return (int)Math.floor(f3 * (float)n + 0.5f) % n;
    }

    private void ixh(class_332 class_3322, float f, float f2, int n, float f3) {
        float f4;
        float f5 = WheelScreen.ixf(n) * f3;
        float f6 = 30.0f * f3;
        float f7 = f5 + f6 * 0.5f;
        float f8 = f6 * 0.5f / f5 / ((float)Math.PI * 2);
        float f9 = Math.max(0.004f, 1.0f / (float)n - 2.0f * f8 - 0.012f);
        int n2 = ColorUtil.withAlpha(Theme.window, 236);
        int n3 = ColorUtil.withAlpha(ColorUtil.lerp(Theme.window, Theme.accent(), 0.32f), 246);
        for (int i = 0; i < n; ++i) {
            boolean bl;
            ivx ivx2 = this.iws.get(i);
            float f10 = this.iwr.get(i).step(i == this.iwt, this.ixa);
            float f11 = (float)i / (float)n - f9 * 0.5f;
            f4 = 3.0f * f10;
            DrawUtil.arc(class_3322, f, f2, f7 + f4 + 0.8f, f6 + f4 + 1.6f, f11, f9, ColorUtil.lerp(ColorUtil.withAlpha(0xFFFFFF, 26), Theme.accent(210), f10));
            DrawUtil.arc(class_3322, f, f2, f7 + f4, f6 + f4, f11, f9, ColorUtil.lerp(n2, n3, f10));
            float f12 = (float)i / (float)n * ((float)Math.PI * 2);
            float f13 = f5 + f4 * 0.5f;
            float f14 = f + (float)Math.sin(f12) * f13;
            float f15 = f2 - (float)Math.cos(f12) * f13;
            boolean bl2 = bl = ivx2.note() != null && !ivx2.note().isEmpty();
            if (ivx2.icon().method_7960()) {
                IconRenderer.draw(class_3322, Icon.PLUS, f14, f15, 9.0f * f3, ColorUtil.lerp(Theme.textMuted, Theme.accent(), f10));
                continue;
            }
            if (this.iwq.get() > 0.01f) continue;
            float f16 = (ivx2.usable() ? 1.15f + 0.15f * f10 : 0.8f) * f3 * DrawUtil.alpha();
            float f17 = bl ? 3.0f : 0.0f;
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f14, f15 - f17);
            class_3322.method_51448().scale(f16, f16);
            class_3322.method_51427(ivx2.icon(), -8, -8);
            class_3322.method_51448().popMatrix();
            if (ivx2.cooldown() > 0.001f) {
                DrawUtil.arc(class_3322, f14, f15 - f17, 11.0f * f3, 1.5f, 0.0f, Math.min(1.0f, ivx2.cooldown()), Theme.accent(), Theme.accent2(), Theme.accent2(), Theme.accent());
            }
            if (!bl) continue;
            UiKit.SMALL.drawCentered(class_3322, ivx2.note(), f14, UiKit.SMALL.centerTop(f15 + 10.5f * f3), ivx2.usable() ? ColorUtil.lerp(Theme.textDim, Theme.text, f10) : -1096636);
        }
        float f18 = Math.min(22.0f, f5 - f6 * 0.5f - 6.0f);
        DrawUtil.circle(class_3322, f, f2, f18, ColorUtil.withAlpha(Theme.window, 236));
        DrawUtil.circleOutline(class_3322, f, f2, f18, 1.0f, ColorUtil.withAlpha(0xFFFFFF, 26));
        if (this.iwt >= 0) {
            float f19 = Math.min(0.2f, 0.8f / (float)n);
            DrawUtil.arc(class_3322, f, f2, f18 + 2.4f, 1.6f, (float)this.iwt / (float)n - f19 * 0.5f, f19, Theme.accent());
        }
        UiKit.SMALL.drawCentered(class_3322, UiKit.SMALL.ellipsize(this.iwm.title(), f18 * 2.0f - 6.0f), f, UiKit.SMALL.centerTop(f2), this.iwt >= 0 ? Theme.text : Theme.textDim);
        float f20 = f2 + f7 + 16.0f;
        if (this.iwt >= 0 && !this.iws.get(this.iwt).icon().method_7960()) {
            ivx ivx3 = this.iws.get(this.iwt);
            String string = UiKit.NAME.ellipsize(ivx3.title(), 170.0f);
            f4 = UiKit.NAME.width(string) + 18.0f;
            DrawUtil.round(class_3322, f - f4 * 0.5f, f20 - 8.0f, f4, 16.0f, 8.0f, ColorUtil.withAlpha(Theme.window, 236));
            DrawUtil.outline(class_3322, f - f4 * 0.5f, f20 - 8.0f, f4, 16.0f, 8.0f, 1.0f, Theme.accent(150));
            UiKit.NAME.drawCentered(class_3322, string, f, UiKit.NAME.centerTop(f20), ivx3.usable() ? Theme.text : Theme.textDim);
        } else {
            String string = this.iwt >= 0 ? Lang.s("Click: choose an item", "Клик: выбрать предмет") : (this.iwm.editable() ? Lang.s("Right click a segment: change its item", "ПКМ по ячейке: сменить предмет") : (this.iww ? Lang.s("Click an item", "Кликните по предмету") : Lang.s("Let go over an item", "Отпустите кнопку над предметом")));
            UiKit.SMALL.drawCentered(class_3322, string, f, UiKit.SMALL.centerTop(f20), ColorUtil.withAlpha(0xFFFFFF, 170));
        }
    }

    private void ixi() {
        boolean bl;
        if (this.iwy || this.iwu >= 0 || this.field_22787 == null) {
            return;
        }
        boolean bl2 = bl = this.iwn != -1 && KeyUtil.isDown(this.field_22787, this.iwn);
        if (this.iww) {
            if (bl && !this.iwx) {
                this.ixl();
            }
        } else if (!bl) {
            if (this.iwt >= 0) {
                this.ixj(this.iwt);
            } else if (System.nanoTime() - this.iwo < 240000000L) {
                this.iww = true;
            } else {
                this.ixl();
            }
        }
        this.iwx = bl;
    }

    private void ixj(int n) {
        if (this.iwy || n < 0 || n >= this.iws.size()) {
            return;
        }
        if (this.iwm.editable() && this.iws.get(n).icon().method_7960()) {
            this.ixk(n);
            return;
        }
        this.iwm.pick(n);
        this.ixl();
    }

    private void ixk(int n) {
        this.iwu = n;
        this.iwv = n;
        this.iww = true;
        this.iwx = true;
    }

    private void ixl() {
        if (this.iwy) {
            return;
        }
        this.iwy = true;
        if (this.field_22787 != null) {
            this.field_22787.method_63588(() -> {
                if (this.field_22787.field_1755 == this) {
                    this.field_22787.method_1507(null);
                }
            });
        }
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        int n;
        if (this.iwy) {
            return true;
        }
        if (this.iwu >= 0) {
            this.ixt((float)class_119092.comp_4798(), (float)class_119092.comp_4799(), class_119092.method_74245());
            return true;
        }
        int n2 = n = this.iws.isEmpty() ? -1 : WheelScreen.ixg((float)class_119092.comp_4798() - (float)this.field_22789 * 0.5f, (float)class_119092.comp_4799() - (float)this.field_22790 * 0.5f, this.iws.size());
        if (n < 0) {
            return true;
        }
        if (class_119092.method_74245() == 1 && this.iwm.editable()) {
            this.ixk(n);
        } else if (!(class_119092.method_74245() != 0 || KeyUtil.isMouse(this.iwn) && KeyUtil.mouseButton(this.iwn) == 0)) {
            this.ixj(n);
        }
        return true;
    }

    public boolean method_25404(class_11908 class_119082) {
        int n = class_119082.comp_4795();
        if (n == 256) {
            if (this.iwu >= 0) {
                this.iwu = -1;
            } else {
                this.ixl();
            }
        } else if (this.iwu < 0 && n >= 49 && n <= 57 && n != KeyUtil.baseKey(this.iwn)) {
            this.ixj(n - 49);
        }
        return true;
    }

    private static int ixm(int n) {
        return n < 27 ? 9 + n : (n < 36 ? n - 27 : 40);
    }

    private float ixn() {
        return 189.0f;
    }

    private float ixo() {
        return 130.0f;
    }

    private float ixp(int n) {
        return (float)this.field_22789 * 0.5f - this.ixn() * 0.5f + 9.0f + (float)(n < 36 ? n % 9 : 0) * 19.0f;
    }

    private float ixq(int n) {
        float f = (float)this.field_22790 * 0.5f - this.ixo() * 0.5f + 17.0f;
        return n < 27 ? f + (float)(n / 9) * 19.0f : (n < 36 ? f + 57.0f + 4.0f : f + 76.0f + 9.0f);
    }

    private void ixr(class_332 class_3322, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6 = this.ixn();
        float f7 = this.ixo();
        float f8 = (float)this.field_22789 * 0.5f - f6 * 0.5f;
        float f9 = (float)this.field_22790 * 0.5f - f7 * 0.5f + (1.0f - f3) * 5.0f;
        float f10 = Theme.r(8.0f);
        DrawUtil.shadow(class_3322, f8, f9 + 3.0f, f6, f7, f10, 14.0f, Theme.shadow);
        DrawUtil.round(class_3322, f8, f9, f6, f7, f10, ColorUtil.withAlpha(Theme.window, 255));
        DrawUtil.outline(class_3322, f8, f9, f6, f7, f10, 1.0f, Theme.stroke);
        UiKit.VALUE.draw(class_3322, Lang.s("Segment ", "Ячейка ") + (this.iwv + 1) + Lang.s(": pick an item", ": выберите предмет"), f8 + 9.0f, UiKit.VALUE.centerTop(f9 + 9.5f), Theme.text);
        class_1661 class_16612 = this.field_22787 != null && this.field_22787.field_1724 != null ? this.field_22787.field_1724.method_31548() : null;
        float f11 = Theme.r(3.5f);
        for (int i = 0; i < 37; ++i) {
            f5 = this.ixp(i);
            f4 = this.ixq(i) + (1.0f - f3) * 5.0f;
            class_1799 class_17992 = class_16612 == null ? class_1799.field_8037 : class_16612.method_5438(WheelScreen.ixm(i));
            boolean bl = !class_17992.method_7960() && UiKit.inside(f, f2, f5, f4, 17.5f, 17.5f);
            DrawUtil.round(class_3322, f5, f4, 17.5f, 17.5f, f11, bl ? Theme.fieldHover : Theme.field);
            if (bl) {
                DrawUtil.outline(class_3322, f5, f4, 17.5f, 17.5f, f11, 1.0f, Theme.accent());
            }
            if (class_17992.method_7960() || !(f3 > 0.5f)) continue;
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f5 + 8.75f, f4 + 8.75f);
            class_3322.method_51427(class_17992, -8, -8);
            class_3322.method_51448().popMatrix();
        }
        float f12 = this.ixq(36) + (1.0f - f3) * 5.0f + 8.75f;
        UiKit.SMALL.draw(class_3322, Lang.s("offhand", "вторая рука"), this.ixp(36) + 19.0f + 3.0f, UiKit.SMALL.centerTop(f12), Theme.textMuted);
        f5 = this.ixs();
        f4 = f8 + f6 - 9.0f - f5;
        boolean bl = UiKit.inside(f, f2, f4, f12 - 7.0f, f5, 14.0f);
        DrawUtil.round(class_3322, f4, f12 - 7.0f, f5, 14.0f, Theme.r(4.0f), bl ? Theme.fieldHover : Theme.field);
        UiKit.VALUE.drawCentered(class_3322, Lang.s("Clear", "Очистить"), f4 + f5 * 0.5f, UiKit.VALUE.centerTop(f12), bl ? Theme.text : Theme.textDim);
    }

    private float ixs() {
        return UiKit.VALUE.width(Lang.s("Clear", "Очистить")) + 14.0f;
    }

    private void ixt(float f, float f2, int n) {
        float f3 = this.ixn();
        float f4 = this.ixo();
        float f5 = (float)this.field_22789 * 0.5f - f3 * 0.5f;
        float f6 = (float)this.field_22790 * 0.5f - f4 * 0.5f;
        if (n != 0 || !UiKit.inside(f, f2, f5, f6, f3, f4)) {
            this.iwu = -1;
            return;
        }
        float f7 = this.ixq(36) + 8.75f;
        float f8 = this.ixs();
        if (UiKit.inside(f, f2, f5 + f3 - 9.0f - f8, f7 - 7.0f, f8, 14.0f)) {
            this.iwm.assign(this.iwu, class_1799.field_8037);
            this.iwu = -1;
            return;
        }
        if (this.field_22787 == null || this.field_22787.field_1724 == null) {
            return;
        }
        class_1661 class_16612 = this.field_22787.field_1724.method_31548();
        for (int i = 0; i < 37; ++i) {
            class_1799 class_17992 = class_16612.method_5438(WheelScreen.ixm(i));
            if (class_17992.method_7960() || !UiKit.inside(f, f2, this.ixp(i), this.ixq(i), 17.5f, 17.5f)) continue;
            this.iwm.assign(this.iwu, class_17992);
            this.iwu = -1;
            return;
        }
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25422() {
        return false;
    }

    private static /* synthetic */ int aku(int n, int n2) {
        return n - n2 + 1167315235;
    }
}

