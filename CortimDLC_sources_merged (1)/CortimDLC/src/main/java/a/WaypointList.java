/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.WaypointForm;
import a.ivh;
import a.ColorUtil;
import a.DrawUtil;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import a.Waypoint;
import a.WaypointRenderer;
import a.Waypoints;
import flow.dev.StringDecryptor;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class WaypointList
extends Widget {
    private static final float ivl = 30.0f;
    private static final float ivm = 3.0f;
    private static final float ivn = 18.0f;
    private final WaypointForm ivo;
    private final Map<Waypoint, ivh> ivp = new IdentityHashMap<Waypoint, ivh>();
    private Waypoint ivq;
    private long ivr;
    private static /* synthetic */ int ivs;
    private static /* synthetic */ long ivt;

    WaypointList(WaypointForm iui2) {
        super(null);
        this.ivo = iui2;
    }

    @Override
    float height() {
        int n = Waypoints.inWorld().size();
        return n == 0 ? 58.0f : 2.0f + (float)n * 33.0f;
    }

    private float ivu(int n) {
        return this.y + 2.0f + (float)n * 33.0f;
    }

    private float ivv(int n) {
        return this.x + this.w - 6.0f - (float)(3 - n) * 21.0f + 3.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<Waypoint> list = Waypoints.inWorld();
        this.ivp.keySet().retainAll(list);
        if (list.isEmpty()) {
            float f4 = this.x + this.w * 0.5f;
            DrawUtil.circle(class_3322, f4, this.y + 17.0f, 12.0f, Theme.hover);
            IconRenderer.draw(class_3322, Icon.PIN, f4, this.y + 17.0f, 11.0f, Theme.textMuted);
            UiKit.LABEL.drawCentered(class_3322, Lang.s("No waypoints yet", "Меток пока нет"), f4, UiKit.LABEL.centerTop(this.y + 38.0f), Theme.textDim);
            UiKit.SMALL.drawCentered(class_3322, Lang.s("Add one with the form on the left", "Добавьте через форму слева"), f4, UiKit.SMALL.centerTop(this.y + 49.0f), Theme.textMuted);
            return;
        }
        if (this.ivq != null && System.currentTimeMillis() > this.ivr) {
            this.ivq = null;
        }
        class_310 class_3102 = class_310.method_1551();
        String string = Waypoints.dimensionId();
        float f5 = Theme.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            Waypoint wkq3;
            boolean bl;
            Waypoint wkq4 = list.get(i);
            ivh ivh2 = this.ivp.computeIfAbsent(wkq4, wkq2 -> new ivh());
            float f6 = this.ivu(i);
            float f7 = Easing.outCubic(ivh2.appear.step(1.0f, f3));
            boolean bl2 = hlc2.canHover() && UiKit.inside(f, f2, this.x, f6, this.w, 30.0f);
            float f8 = ivh2.hover.step(bl2, f3);
            float f9 = ivh2.shown.step(wkq4.visible, f3);
            int n = Waypoints.colorOf(wkq4);
            DrawUtil.pushAlpha(f7 * (0.5f + 0.5f * f9));
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate((1.0f - f7) * 18.0f, 0.0f);
            DrawUtil.round(class_3322, this.x, f6, this.w, 30.0f, f5, ColorUtil.withAlpha(Theme.hover, (int)((float)ColorUtil.alpha(Theme.hover) * (0.6f + 1.4f * f8))));
            float f10 = f6 + 15.0f;
            WaypointRenderer.pin(class_3322, this.x + 12.0f, f10 - 0.8f * f8, 15.0f, n, 0.5f + 0.5f * f8);
            float f11 = this.x + 24.0f;
            float f12 = this.ivv(0) - f11 - 6.0f;
            UiKit.CARD_TITLE.draw(class_3322, UiKit.CARD_TITLE.ellipsize(wkq4.name, f12), f11, UiKit.CARD_TITLE.centerTop(f10 - 4.5f), Theme.text);
            String string2 = (int)Math.floor(wkq4.x) + "  " + (int)Math.floor(wkq4.y) + "  " + (int)Math.floor(wkq4.z);
            boolean bl3 = bl = string != null && string.equals(wkq4.dimension);
            if (!bl) {
                string2 = string2 + "  ·  " + Waypoints.dimensionName(wkq4.dimension);
            }
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string2, f12), f11, UiKit.SMALL.centerTop(f10 + 5.5f), Theme.textMuted);
            Waypoint wkq5 = wkq3 = bl ? wkq4 : Waypoints.here(wkq4);
            if (f8 < 0.99f && wkq3 != null && class_3102.field_1724 != null) {
                double d = Math.sqrt(class_3102.field_1724.method_5649(wkq3.cx(), wkq3.cy(), wkq3.cz()));
                DrawUtil.pushAlpha(1.0f - f8);
                UiKit.drawChip(class_3322, WaypointRenderer.formatDistance(d), this.x + this.w - 6.0f + f8 * 6.0f, f10, ColorUtil.lerp(n, Theme.text, 0.5f), ColorUtil.withAlpha(n, 90), 0.0f);
                DrawUtil.popAlpha();
            }
            Icon[] vhzArray = new Icon[]{wkq4.visible ? Icon.RENDER : Icon.EYE_OFF, Icon.PENCIL, Icon.TRASH};
            String[] stringArray = new String[]{wkq4.visible ? Lang.s("Hide from the world", "Скрыть в мире") : Lang.s("Show in the world", "Показать в мире"), Lang.s("Edit in the form", "Изменить в форме"), Lang.s("Delete (click again to confirm)", "Удалить (нажмите ещё раз для подтверждения)")};
            for (int j = 0; j < 3; ++j) {
                float f13 = this.ivv(j) + (1.0f - f8) * 6.0f;
                float f14 = f10 - 9.0f;
                boolean bl4 = hlc2.canHover() && UiKit.inside(f, f2, f13, f14, 18.0f, 18.0f);
                float f15 = ivh2.buttons[j].step(bl4, f3);
                boolean bl5 = j == 2 && wkq4 == this.ivq;
                UiKit.iconButton(class_3322, vhzArray[j], f13, f14, 18.0f, f15, bl5, bl5 ? 1.0f : f8);
                if (!bl4 || !(f8 > 0.5f)) continue;
                hlc2.hint(bl5 ? Lang.s("Click again to delete “" + wkq4.name + "”", "Нажмите ещё раз, чтобы удалить «" + wkq4.name + "»") : stringArray[j]);
            }
            class_3322.method_51448().popMatrix();
            DrawUtil.popAlpha();
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        List<Waypoint> list = Waypoints.inWorld();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.ivu(i);
            if (!UiKit.inside(f, f2, this.x, f3, this.w, 30.0f)) continue;
            Waypoint wkq2 = list.get(i);
            float f4 = f3 + 15.0f;
            for (int j = 0; j < 3; ++j) {
                if (n != 0 || !UiKit.inside(f, f2, this.ivv(j), f4 - 9.0f, 18.0f, 18.0f)) continue;
                switch (j) {
                    case 0: {
                        wkq2.visible = !wkq2.visible;
                        Waypoints.changed();
                        break;
                    }
                    case 1: {
                        this.ivo.edit(wkq2);
                        break;
                    }
                    default: {
                        if (wkq2 != this.ivq) {
                            this.ivq = wkq2;
                            this.ivr = System.currentTimeMillis() + 2500L;
                            break;
                        }
                        this.ivq = null;
                        Waypoints.remove(wkq2);
                        hlc2.toast(Lang.s("Deleted “" + wkq2.name + "”", "Удалена «" + wkq2.name + "»"), Icon.TRASH, false);
                    }
                }
                return true;
            }
            if (n == 0) {
                this.ivo.edit(wkq2);
            }
            return true;
        }
        return false;
    }

    private static /* synthetic */ int akj(int n, int n2) {
        return n + n2 ^ 0x450BF302;
    }

    private static /* synthetic */ int akk(int n, int n2) {
        return WaypointList.akj(n, n2) + n;
    }
}

