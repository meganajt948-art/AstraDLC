/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.TextField;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.Lang;
import a.Waypoint;
import a.WaypointRenderer;
import a.Waypoints;
import flow.dev.StringDecryptor;
import java.util.Locale;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class WaypointForm
extends Widget {
    private static final float iuj = 17.0f;
    private static final float iuk = 11.0f;
    final TextField name = new TextField("Name (optional)", Icon.PIN, 24, TextField.ANY);
    final TextField fx = new TextField("", null, 10, TextField.NUMBER);
    final TextField fy = new TextField("", null, 10, TextField.NUMBER);
    final TextField fz = new TextField("", null, 10, TextField.NUMBER);
    private int iul;
    private boolean ium;
    private Waypoint iun;
    private ClickGuiScreen iuo;
    private final Spring[] iup = new Spring[Waypoints.COLORS.length];
    private final Spring[] iuq = new Spring[Waypoints.COLORS.length];
    private final Spring iur = new Spring(16.0f);
    private final Spring ius = new Spring(9.0f);
    private final Spring iut = new Spring(16.0f);
    private final Spring iuu = new Spring(9.0f);
    private final Spring iuv = new Spring(16.0f);
    private final Spring iuw = new Spring(12.0f);
    private static /* synthetic */ long iux;
    private static /* synthetic */ boolean iuy;

    WaypointForm() {
        super(null);
        Runnable runnable;
        this.fx.prefix = "X";
        this.fy.prefix = "Y";
        this.fz.prefix = "Z";
        this.name.next = this.fx;
        this.fx.next = this.fy;
        this.fy.next = this.fz;
        this.fz.next = this.name;
        this.name.onSubmit = runnable = this::ivg;
        this.fx.onSubmit = runnable;
        this.fy.onSubmit = runnable;
        this.fz.onSubmit = runnable;
        for (int i = 0; i < this.iup.length; ++i) {
            this.iup[i] = new Spring(16.0f);
            this.iuq[i] = new Spring(14.0f, i == 0 ? 1.0f : 0.0f);
        }
    }

    @Override
    float height() {
        return 91.0f;
    }

    private float iuz(int n) {
        return switch (n) {
            case 0 -> this.y + 4.0f;
            case 1 -> this.y + 4.0f + 17.0f + 6.0f;
            case 2 -> this.y + 4.0f + 46.0f + 2.0f;
            default -> this.y + 4.0f + 46.0f + 2.0f + 11.0f + 8.0f;
        };
    }

    private float iva(int n) {
        int n2 = Waypoints.COLORS.length;
        float f = (this.w - 11.0f * (float)n2) / (float)(n2 - 1);
        return this.x + (float)n * (11.0f + f);
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        this.iuo = hlc2;
        if (this.iun != null && !Waypoints.inWorld().contains(this.iun)) {
            this.ivc();
        }
        float f10 = this.iuw.step(this.iun != null, f3);
        this.name.x = this.x;
        this.name.y = this.iuz(0);
        this.name.w = this.w;
        this.name.h = 17.0f;
        this.name.render(class_3322, hlc2, f, f2, f3);
        float f11 = (this.w - 10.0f) / 3.0f;
        TextField[] iahArray = new TextField[]{this.fx, this.fy, this.fz};
        for (int i = 0; i < 3; ++i) {
            TextField iah2 = iahArray[i];
            iah2.x = this.x + (float)i * (f11 + 5.0f);
            iah2.y = this.iuz(1);
            iah2.w = f11;
            iah2.h = 17.0f;
            iah2.render(class_3322, hlc2, f, f2, f3);
        }
        float f12 = this.iuz(2);
        boolean bl = !Waypoints.COLOR.is("Theme") || this.ium || this.iun != null && this.iun.ownColor;
        DrawUtil.pushAlpha(bl ? 1.0f : 0.65f);
        for (int i = 0; i < Waypoints.COLORS.length; ++i) {
            f9 = this.iva(i);
            f8 = this.iup[i].step(hlc2.canHover() && UiKit.inside(f, f2, f9 - 2.0f, f12 - 2.0f, 15.0f, 15.0f), f3);
            f7 = this.iuq[i].step(i == this.iul, f3);
            int n = Waypoints.COLORS[i];
            f6 = f9 + 5.5f;
            f5 = f12 + 5.5f;
            if (f7 > 0.01f) {
                DrawUtil.circleOutline(class_3322, f6, f5, 7.5f, 1.2f, ColorUtil.mulAlpha(Theme.text, f7));
            }
            f4 = 3.5f * (0.9f + 0.1f * f8 + 0.08f * Easing.outBack(f7));
            WaypointRenderer.bead(class_3322, f6, f5 - 0.5f * f8, f4, n);
            if (!(f8 > 0.5f) || bl) continue;
            hlc2.hint(Lang.s("Pick a colour for this pin (else it takes the theme accent)", "Выберите цвет для этой метки (иначе она берёт акцент темы)"));
        }
        DrawUtil.popAlpha();
        float f13 = this.iuz(3);
        f9 = 58.0f;
        f8 = 58.0f * f10;
        f7 = this.w - f9 - 6.0f - (f8 > 0.5f ? f8 + 6.0f * f10 : 0.0f);
        float f14 = this.iur.step(hlc2.canHover() && UiKit.inside(f, f2, this.x, f13, f9, 17.0f), f3);
        UiKit.secondaryButton(class_3322, Lang.s("Here", "Здесь"), Icon.LOCATE, this.x, f13, f9, 17.0f, f14, this.ius.step(0.0f, f3));
        if (f14 > 0.5f) {
            hlc2.hint(Lang.s("Fill in the block you are standing on", "Подставить блок, на котором вы стоите"));
        }
        f6 = this.x + f9 + 6.0f;
        f5 = this.iut.step(hlc2.canHover() && UiKit.inside(f, f2, f6, f13, f7, 17.0f), f3);
        UiKit.primaryButton(class_3322, this.iun != null ? Lang.s("Update", "Обновить") : Lang.s("Add waypoint", "Добавить метку"), this.iun != null ? Icon.SAVE : Icon.PLUS, f6, f13, f7, 17.0f, f5, this.iuu.step(0.0f, f3));
        if (f8 > 0.5f) {
            f4 = f6 + f7 + 6.0f;
            float f15 = this.iuv.step(hlc2.canHover() && UiKit.inside(f, f2, f4, f13, f8, 17.0f), f3);
            DrawUtil.pushAlpha(f10);
            UiKit.secondaryButton(class_3322, f10 > 0.8f ? Lang.s("Cancel", "Отмена") : "", Icon.CLOSE, f4, f13, f8, 17.0f, f15, 0.0f);
            DrawUtil.popAlpha();
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        float f3;
        this.iuo = hlc2;
        TextField[] iahArray = new TextField[]{this.name, this.fx, this.fy, this.fz};
        int n2 = iahArray.length;
        for (int i = 0; i < n2; ++i) {
            TextField iah2 = iahArray[i];
            if (!iah2.mouseClicked(hlc2, f, f2, n)) continue;
            return true;
        }
        if (n != 0) {
            return false;
        }
        float f4 = this.iuz(2);
        for (n2 = 0; n2 < Waypoints.COLORS.length; ++n2) {
            if (!UiKit.inside(f, f2, this.iva(n2) - 2.0f, f4 - 2.0f, 15.0f, 15.0f)) continue;
            this.iul = n2;
            this.ium = true;
            if (this.iun != null) {
                this.iun.color = Waypoints.COLORS[n2];
                this.iun.ownColor = true;
                Waypoints.changed();
            }
            return true;
        }
        float f5 = this.iuz(3);
        if (UiKit.inside(f, f2, this.x, f5, f3 = 58.0f, 17.0f)) {
            this.ius.set(1.0f);
            this.ivb();
            return true;
        }
        float f6 = this.x + f3 + 6.0f;
        float f7 = this.iun != null ? 58.0f : 0.0f;
        float f8 = this.w - f3 - 6.0f - (f7 > 0.0f ? f7 + 6.0f : 0.0f);
        if (UiKit.inside(f, f2, f6, f5, f8, 17.0f)) {
            this.iuu.set(1.0f);
            this.ivg();
            return true;
        }
        if (this.iun != null && UiKit.inside(f, f2, f6 + f8 + 6.0f, f5, f7, 17.0f)) {
            this.ivc();
            return true;
        }
        return false;
    }

    private void ivb() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null) {
            return;
        }
        this.fx.setText(String.valueOf(class_3102.field_1724.method_31477()));
        this.fy.setText(String.valueOf(class_3102.field_1724.method_31478()));
        this.fz.setText(String.valueOf(class_3102.field_1724.method_31479()));
    }

    void edit(Waypoint wkq2) {
        this.iun = wkq2;
        this.ium = false;
        this.name.setText(wkq2.name);
        this.fx.setText(WaypointForm.ive(wkq2.x));
        this.fy.setText(WaypointForm.ive(wkq2.y));
        this.fz.setText(WaypointForm.ive(wkq2.z));
        this.iul = 0;
        for (int i = 0; i < Waypoints.COLORS.length; ++i) {
            if ((Waypoints.COLORS[i] & 0xFFFFFF) != (wkq2.color & 0xFFFFFF)) continue;
            this.iul = i;
        }
        if (this.iuo != null) {
            this.iuo.focus(this.name);
        }
    }

    private void ivc() {
        this.iun = null;
        this.ivd();
    }

    private void ivd() {
        this.ium = false;
        this.name.setText("");
        this.fx.setText("");
        this.fy.setText("");
        this.fz.setText("");
    }

    private static String ive(double d) {
        return d == Math.floor(d) ? String.valueOf((long)d) : String.format(Locale.ROOT, "%.1f", d);
    }

    private static Double ivf(TextField iah2) {
        try {
            return iah2.text.isBlank() ? null : Double.valueOf(Double.parseDouble(iah2.text.trim()));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private void ivg() {
        String string;
        Double d = WaypointForm.ivf(this.fx);
        Double d2 = WaypointForm.ivf(this.fy);
        Double d3 = WaypointForm.ivf(this.fz);
        if (d == null || d2 == null || d3 == null) {
            for (TextField iah2 : new TextField[]{this.fx, this.fy, this.fz}) {
                if (WaypointForm.ivf(iah2) != null) continue;
                iah2.error();
            }
            if (this.iuo != null) {
                this.iuo.toast(Lang.s("Enter X, Y and Z, or press Here", "Введите X, Y и Z или нажмите «Здесь»"), Icon.LOCATE, true);
            }
            return;
        }
        String string2 = string = this.name.text.isBlank() ? Lang.s("Waypoint ", "Метка ") + (Waypoints.inWorld().size() + 1) : this.name.text.trim();
        if (this.iun != null) {
            this.iun.name = string;
            this.iun.x = d;
            this.iun.y = d2;
            this.iun.z = d3;
            this.iun.color = Waypoints.COLORS[this.iul];
            this.iun.ownColor |= this.ium;
            Waypoints.changed();
            this.iun = null;
            if (this.iuo != null) {
                this.iuo.toast(Lang.s("Updated “" + string + "”", "Обновлена «" + string + "»"), Icon.SAVE, false);
            }
        } else {
            Waypoint wkq2 = Waypoints.add(string, d, d2, d3, Waypoints.COLORS[this.iul]);
            if (this.ium) {
                wkq2.ownColor = true;
                Waypoints.changed();
            }
            this.iul = (this.iul + 1) % Waypoints.COLORS.length;
            if (this.iuo != null) {
                this.iuo.toast(Lang.s("Added “" + string + "”", "Добавлена «" + string + "»"), Icon.PIN, false);
            }
        }
        this.ivd();
        if (this.iuo != null) {
            this.iuo.focus(null);
        }
    }

    private static /* synthetic */ int akb(int n, int n2) {
        return n + n2 + 1962299242;
    }

    private static /* synthetic */ int akc(int n, int n2) {
        return WaypointForm.akb(n, n2) + n;
    }

    private static /* synthetic */ int akd(int n, int n2) {
        return WaypointForm.akb(n, n2) ^ 0x109E4C7A;
    }
}

