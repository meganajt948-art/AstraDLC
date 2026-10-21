/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.ClickGuiScreen;
import a.hrk;
import a.TextField;
import a.Popup;
import a.Theme;
import a.UiKit;
import a.AutoCollector;
import a.CustomItemInfo;
import a.CollectorState;
import a.EnchantNameUtil;
import a.phj;
import a.ItemRule;
import a.pig;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1291;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;

public final class CollectorListPopup
extends Popup {
    private static final float hru = 470.0f;
    private static final float hrv = 336.0f;
    private static final float hrw = 12.0f;
    private static final float hrx = 30.0f;
    private static final float hry = 22.0f;
    private static final float hrz = 16.0f;
    private static final float hsa = 26.0f;
    private static final float hsb = 4.0f;
    private static final float hsc = 266.0f;
    private static final float hsd = 14.0f;
    final TextField search = new TextField("Search", Icon.SEARCH, 32, TextField.ANY);
    private final float hse;
    private final float hsf;
    private final Spring hsg = new Spring(16.0f);
    private final Spring hsh = new Spring(18.0f);
    private final List<hrk> hsi = new ArrayList<hrk>();
    private final List<CustomItemInfo> hsj = new ArrayList<CustomItemInfo>();
    private float hsk;
    private boolean hsl;
    private CustomItemInfo hsm;
    private String hsn;
    private static /* synthetic */ long hso;
    private static /* synthetic */ boolean hsp;

    private CollectorListPopup(float f, float f2) {
        this.hse = (f - 470.0f) * 0.5f;
        this.hsf = (f2 - 336.0f) * 0.5f;
        this.search.onChange = string -> this.hsq();
        CustomItemInfo pdr2 = AutoCollector.collecting();
        this.hsm = pdr2 != null ? pdr2 : CollectorState.items().get(0);
        this.hsq();
    }

    public static void open() {
        class_437 class_4372 = class_310.method_1551().field_1755;
        if (class_4372 instanceof ClickGuiScreen) {
            ClickGuiScreen hlc2 = (ClickGuiScreen)class_4372;
            hlc2.openOverlay(new CollectorListPopup(540.0f, 409.0f));
        }
    }

    private void hsq() {
        this.hsj.clear();
        String string = this.search.text.toLowerCase(Locale.ROOT).trim();
        for (CustomItemInfo pdr2 : CollectorState.items()) {
            if (!string.isEmpty() && !pdr2.searchText().contains(string) && !Lang.matches(pdr2.searchText(), this.search.text)) continue;
            this.hsj.add(pdr2);
        }
        this.hsk = Math.min(this.hsk, this.hsy());
    }

    private void hsr() {
        CollectorState.changed();
    }

    @Override
    TextField field() {
        return this.search;
    }

    @Override
    boolean gone() {
        return this.hsl && this.hsg.get() <= 0.01f;
    }

    @Override
    boolean closing() {
        return this.hsl;
    }

    @Override
    void close() {
        this.hsl = true;
    }

    private float hss() {
        return this.hse + 12.0f;
    }

    private float hst() {
        return this.hsf + 30.0f + 22.0f + 8.0f;
    }

    private float hsu() {
        return 336.0f - (this.hst() - this.hsf) - 16.0f - 8.0f;
    }

    private int hsv() {
        return Math.max(1, 9);
    }

    private float hsw() {
        int n = this.hsv();
        return n <= 1 ? 30.0f : 240.0f / (float)(n - 1);
    }

    private float hsx() {
        int n = (this.hsj.size() + this.hsv() - 1) / this.hsv();
        return (float)n * 30.0f - 4.0f;
    }

    private float hsy() {
        return Math.max(0.0f, this.hsx() - this.hsu());
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3, float f4, float f5) {
        boolean bl;
        float f6 = Easing.outCubic(this.hsg.step(this.hsl ? 0.0f : 1.0f, f3));
        if (f6 <= 0.01f) {
            return;
        }
        boolean bl2 = bl = !this.hsl;
        if (!bl) {
            f = -10000.0f;
            f2 = -10000.0f;
        }
        this.hsi.clear();
        this.hsn = null;
        float f7 = Theme.r(10.0f);
        float f8 = Theme.lightness();
        DrawUtil.round(class_3322, 0.0f, 0.0f, f4, f5, Theme.r(12.0f), ColorUtil.withAlpha(0, Math.round(110.0f * f6)));
        DrawUtil.pushAlpha(f6);
        class_3322.method_51448().pushMatrix();
        float f9 = 0.96f + 0.04f * f6;
        class_3322.method_51448().translate(this.hse + 235.0f, this.hsf + 168.0f + (1.0f - f6) * 6.0f);
        class_3322.method_51448().scale(f9, f9);
        class_3322.method_51448().translate(-(this.hse + 235.0f), -(this.hsf + 168.0f));
        DrawUtil.shadow(class_3322, this.hse, this.hsf + 4.0f, 470.0f, 336.0f, f7, 18.0f, Theme.shadow);
        DrawUtil.round(class_3322, this.hse, this.hsf, 470.0f, 336.0f, f7, ColorUtil.withAlpha(Theme.window, 252));
        DrawUtil.round(class_3322, this.hse, this.hsf, 470.0f, 336.0f, f7, Theme.card);
        GlassDraw.sheen(class_3322, this.hse, this.hsf, 470.0f, 50.0f, f7, 0.8f * (1.0f - 0.7f * f8));
        DrawUtil.outline(class_3322, this.hse, this.hsf, 470.0f, 336.0f, f7, 1.0f, Theme.stroke);
        GlassDraw.rim(class_3322, this.hse, this.hsf, 470.0f, 336.0f, f7, f8, 1.0f);
        this.hsz(class_3322, f, f2);
        this.hta(class_3322, hlc2, f, f2, f3);
        this.htc(class_3322, f, f2, f3);
        this.htd(class_3322, f, f2);
        this.hti(class_3322);
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    private void hsz(class_332 class_3322, float f, float f2) {
        boolean bl;
        float f3;
        float f4;
        float f5;
        float f6 = this.hsf + 15.0f + 1.0f;
        IconRenderer.draw(class_3322, Icon.LAYERS, this.hse + 12.0f + 5.0f, f6, 10.0f, Theme.accent());
        String string = Lang.s("AutoCollector list", "Список AutoCollector");
        UiKit.CARD_TITLE.draw(class_3322, string, this.hse + 12.0f + 16.0f, UiKit.CARD_TITLE.centerTop(f6), Theme.text);
        String string2 = CollectorState.activeCount() + " / " + CollectorState.items().size() + Lang.s(" on", " вкл");
        float f7 = this.hse + 12.0f + 16.0f + UiKit.CARD_TITLE.width(string) + 8.0f + Math.max(16.0f, UiKit.SMALL.width(string2) + 9.0f);
        UiKit.drawChip(class_3322, string2, f7, f6, Theme.textDim, Theme.stroke, 0.0f);
        CustomItemInfo pdr2 = AutoCollector.collecting();
        if (pdr2 != null) {
            String string3 = Lang.s("Collecting: ", "Собираем: ") + pdr2.name();
            UiKit.SMALL.draw(class_3322, string3, f7 + 8.0f, UiKit.SMALL.centerTop(f6), Theme.accent());
        }
        UiKit.iconButton(class_3322, Icon.CLOSE, f5, f4, f3, (bl = UiKit.inside(f, f2, f5 = this.hse + 470.0f - 12.0f - (f3 = 16.0f), f4 = this.hsf + (30.0f - f3) * 0.5f + 1.0f, f3, f3)) ? 1.0f : 0.0f, false, 1.0f);
        this.hsi.add(new hrk(f5, f4, f3, f3, this::close, null));
    }

    private void hta(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4 = this.hsf + 30.0f + 2.0f;
        this.search.x = this.hse + 12.0f;
        this.search.y = f4 + 3.0f;
        this.search.w = 150.0f;
        this.search.h = 16.0f;
        this.search.render(class_3322, hlc2, f, f2, f3);
        float f5 = 16.0f;
        float f6 = this.search.y;
        String[] stringArray = new String[]{Lang.s("All on", "Включить все"), Lang.s("All off", "Выключить все"), Lang.s("Reset", "Сброс")};
        Icon[] vhzArray = new Icon[]{Icon.CHECK, Icon.CLOSE, Icon.RESET};
        Runnable[] runnableArray = new Runnable[]{() -> this.htb(true), () -> this.htb(false), () -> {
            CollectorState.resetAll();
            hlc2.toast(Lang.s("Back to the default list", "Вернули список по умолчанию"), Icon.RESET, false);
        }};
        float f7 = this.search.x + this.search.w + 8.0f;
        float f8 = (this.hse + 470.0f - 12.0f - f7 - 12.0f) / 3.0f;
        for (int i = 0; i < 3; ++i) {
            float f9 = f7 + (float)i * (f8 + 6.0f);
            boolean bl = UiKit.inside(f, f2, f9, f6, f8, f5);
            UiKit.secondaryButton(class_3322, stringArray[i], vhzArray[i], f9, f6, f8, f5, bl ? 1.0f : 0.0f, 0.0f);
            this.hsi.add(new hrk(f9, f6, f8, f5, runnableArray[i], null));
        }
    }

    private void htb(boolean bl) {
        for (CustomItemInfo pdr2 : this.hsj) {
            pdr2.setActive(bl);
        }
        this.hsr();
    }

    private void htc(class_332 class_3322, float f, float f2, float f3) {
        float f4;
        float f5 = this.hss();
        float f6 = this.hst();
        float f7 = this.hsu();
        float f8 = this.hsh.step(Math.max(0.0f, Math.min(this.hsk, this.hsy())), f3);
        int n = this.hsv();
        float f9 = this.hsw();
        CustomItemInfo pdr2 = AutoCollector.collecting();
        float f10 = Theme.r(5.0f);
        DrawUtil.pushScissor(class_3322, f5 - 2.0f, f6 - 2.0f, 270.0f, f7 + 4.0f);
        for (int i = 0; i < this.hsj.size(); ++i) {
            Object object;
            CustomItemInfo pdr3 = this.hsj.get(i);
            f4 = f5 + (float)(i % n) * f9;
            float f11 = f6 + (float)(i / n) * 30.0f - f8;
            if (f11 + 26.0f < f6 - 2.0f || f11 > f6 + f7 + 2.0f) continue;
            boolean bl = UiKit.inside(f, f2, f4, f11, 26.0f, 26.0f) && UiKit.inside(f, f2, f5, f6, 266.0f, f7);
            boolean bl2 = pdr3.active();
            int n2 = bl2 ? ColorUtil.lerp(Theme.field, Theme.accent(), 0.22f) : Theme.field;
            DrawUtil.round(class_3322, f4, f11, 26.0f, 26.0f, f10, bl ? ColorUtil.lerp(n2, Theme.fieldHover, 0.6f) : n2);
            if (pdr3 == this.hsm) {
                DrawUtil.outline(class_3322, f4, f11, 26.0f, 26.0f, f10, 1.2f, Theme.accent(230));
            } else if (bl2) {
                DrawUtil.outline(class_3322, f4, f11, 26.0f, 26.0f, f10, 1.0f, Theme.accent(90));
            }
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f4 + 5.0f, f11 + 5.0f);
            class_3322.method_51427(pdr3.icon(), 0, 0);
            class_3322.method_51448().popMatrix();
            if (!bl2) {
                DrawUtil.round(class_3322, f4, f11, 26.0f, 26.0f, f10, ColorUtil.withAlpha(Theme.window, 150));
            }
            if (pdr3.count() > 1) {
                object = String.valueOf(pdr3.count());
                UiKit.SMALL.drawRight(class_3322, (String)object, f4 + 26.0f - 2.0f, f11 + 26.0f - 7.5f, bl2 ? Theme.text : Theme.textMuted);
            }
            if (pdr3 == pdr2) {
                DrawUtil.circle(class_3322, f4 + 26.0f - 4.0f, f11 + 4.0f, 2.5f, Theme.accent());
            }
            if (bl) {
                this.hsn = pdr3.name() + (bl2 ? "" : Lang.s("  ·  off", "  ·  выключен"));
            }
            object = pdr3;
            this.hsi.add(new hrk(f4, f11, 26.0f, 26.0f, () -> this.lambda$grid$4((CustomItemInfo)object), () -> this.lambda$grid$5((CustomItemInfo)object)));
        }
        DrawUtil.popScissor(class_3322);
        float f12 = this.hsy();
        if (f12 > 0.0f) {
            float f13 = Math.max(18.0f, f7 * f7 / this.hsx());
            f4 = f6 + (f7 - f13) * (f8 / f12);
            DrawUtil.round(class_3322, f5 + 266.0f + 4.0f, f4, 2.5f, f13, 1.25f, ColorUtil.withAlpha(Theme.textMuted, 110));
        }
    }

    private void htd(class_332 class_3322, float f, float f2) {
        List<ItemRule> list;
        float f3 = this.hss() + 266.0f + 14.0f;
        float f4 = this.hst();
        float f5 = this.hse + 470.0f - 12.0f - f3;
        float f6 = this.hsu();
        DrawUtil.round(class_3322, f3, f4, f5, f6, Theme.r(7.0f), Theme.field);
        CustomItemInfo pdr2 = this.hsm;
        if (pdr2 == null) {
            return;
        }
        float f7 = f3 + 8.0f;
        float f8 = f4 + 8.0f;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f7, f8);
        class_3322.method_51427(pdr2.icon(), 0, 0);
        class_3322.method_51448().popMatrix();
        float f9 = f7 + 22.0f;
        UiKit.NAME.draw(class_3322, UiKit.NAME.ellipsize(pdr2.name(), f5 - 34.0f), f9, UiKit.NAME.centerTop(f8 + 4.0f), Theme.text);
        String string = pdr2.hasQuery() ? Lang.s("search: ", "поиск: ") + pdr2.query() : (pdr2.deepScan() ? Lang.s("cheapest of the first pages", "дешевейший с первых страниц") : Lang.s("cheapest lot", "самый дешёвый лот"));
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, f5 - 34.0f), f9, UiKit.SMALL.centerTop(f8 + 12.5f), Theme.textMuted);
        float f10 = f4 + 30.0f;
        float f11 = f3 + 8.0f;
        float f12 = f5 - 16.0f;
        DrawUtil.rect(class_3322, f11, f10 - 3.0f, f12, 1.0f, Theme.divider);
        boolean bl = UiKit.inside(f, f2, f11, f10, f12, 14.0f);
        UiKit.LABEL.draw(class_3322, Lang.s("Buy", "Покупать"), f11, UiKit.LABEL.centerTop(f10 + 7.0f), bl ? Theme.text : Theme.textDim);
        UiKit.drawSwitch(class_3322, f11 + f12 - 17.0f, f10 + 2.25f, pdr2.active() ? 1.0f : 0.0f, bl ? 1.0f : 0.0f);
        this.hsi.add(new hrk(f11, f10, f12, 14.0f, () -> {
            pdr2.setActive(!pdr2.active());
            this.hsr();
        }, null));
        f10 += 17.0f;
        if (pdr2.stackable()) {
            UiKit.LABEL.draw(class_3322, Lang.s("Keep", "Держать"), f11, UiKit.LABEL.centerTop(f10 + 7.0f), Theme.textDim);
            this.hth(class_3322, f, f2, f11 + f12, f10, String.valueOf(pdr2.count()), () -> {
                pdr2.setCount(pdr2.count() - CollectorListPopup.hte(pdr2));
                this.hsr();
            }, () -> {
                pdr2.setCount(pdr2.count() + CollectorListPopup.hte(pdr2));
                this.hsr();
            });
            f10 += 17.0f;
        }
        if (!(list = pdr2.shownRules()).isEmpty()) {
            f10 = this.htg(class_3322, Lang.s("Conditions", "Условия"), f11, f10, f12);
            for (ItemRule object : list) {
                int n;
                boolean bl4 = object.state() == phj.ON;
                boolean bl2 = UiKit.inside(f, f2, f11, f10, f12 - (object.hasLevel() ? 44.0f : 0.0f), 14.0f);
                float f13 = 3.0f;
                DrawUtil.circle(class_3322, f11 + f13, f10 + 7.0f, f13, bl4 ? Theme.accent() : ColorUtil.withAlpha(Theme.textMuted, 120));
                String string2 = object.label();
                if (object.hasLevel()) {
                    n = string2.lastIndexOf(32);
                    String string3 = string2 = n > 0 ? string2.substring(0, n) : string2;
                }
                n = bl4 ? (bl2 ? Theme.text : Theme.textDim) : Theme.textMuted;
                UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(string2, f12 - 56.0f), f11 + 10.0f, UiKit.LABEL.centerTop(f10 + 7.0f), n);
                this.hsi.add(new hrk(f11, f10, f12 - (object.hasLevel() ? 44.0f : 0.0f), 14.0f, () -> {
                    object.setState(object.state() == phj.ON ? phj.OFF : phj.ON);
                    this.hsr();
                }, null));
                if (object.hasLevel() && bl4) {
                    String string4 = object.isEnchant() ? String.valueOf(object.level()) : EnchantNameUtil.roman(object.level());
                    this.hth(class_3322, f, f2, f11 + f12, f10, string4, () -> {
                        object.setLevel(object.level() - 1);
                        this.hsr();
                    }, () -> {
                        object.setLevel(object.level() + 1);
                        this.hsr();
                    });
                }
                f10 += 14.0f;
            }
            f10 += 3.0f;
        }
        if (pdr2.hasEffects()) {
            f10 = this.htg(class_3322, Lang.s("Effects (all of them, exactly)", "Эффекты (все, ровно такие)"), f11, f10, f12);
            for (pig pig2 : pdr2.effects()) {
                String string5 = ((class_1291)pig2.effect().comp_349()).method_5560().getString() + " " + EnchantNameUtil.roman(pig2.level());
                String string6 = pig2.duration() > 0 ? CollectorListPopup.htf(pig2.duration()) : "";
                UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(string5, f12 - 30.0f), f11 + 2.0f, UiKit.LABEL.centerTop(f10 + 7.0f), Theme.textDim);
                UiKit.SMALL.drawRight(class_3322, string6, f11 + f12, UiKit.SMALL.centerTop(f10 + 7.0f), Theme.textMuted);
                f10 += 13.0f;
            }
        }
        if (pdr2.hasAttrs()) {
            f10 = this.htg(class_3322, Lang.s("Found by", "Опознаётся"), f11, f10, f12);
            UiKit.SMALL.draw(class_3322, Lang.s("its attribute modifiers", "по набору характеристик"), f11 + 2.0f, UiKit.SMALL.centerTop(f10 + 7.0f), Theme.textDim);
        }
        if (pdr2.changed()) {
            float f14 = 15.0f;
            float f15 = f4 + f6 - f14 - 7.0f;
            boolean bl3 = UiKit.inside(f, f2, f11, f15, f12, f14);
            UiKit.secondaryButton(class_3322, Lang.s("Reset item", "Сбросить предмет"), Icon.RESET, f11, f15, f12, f14, bl3 ? 1.0f : 0.0f, 0.0f);
            this.hsi.add(new hrk(f11, f15, f12, f14, () -> {
                pdr2.reset();
                this.hsr();
            }, null));
        }
    }

    private static int hte(CustomItemInfo pdr2) {
        long l = class_310.method_1551().method_22683().method_4490();
        boolean bl = GLFW.glfwGetKey((long)l, (int)340) == 1 || GLFW.glfwGetKey((long)l, (int)344) == 1;
        return bl && pdr2.maxCount() > 16 ? 8 : 1;
    }

    private static String htf(int n) {
        int n2 = n / 20;
        return n2 / 60 + ":" + String.format(Locale.ROOT, "%02d", n2 % 60);
    }

    private float htg(class_332 class_3322, String string, float f, float f2, float f3) {
        UiKit.SECTION.draw(class_3322, string.toUpperCase(Locale.ROOT), f, UiKit.SECTION.centerTop(f2 + 6.0f), Theme.textMuted);
        return f2 + 12.0f;
    }

    private void hth(class_332 class_3322, float f, float f2, float f3, float f4, String string, Runnable runnable, Runnable runnable2) {
        float f5 = 12.0f;
        float f6 = 18.0f;
        float f7 = f3 - f5;
        float f8 = f7 - f6;
        float f9 = f8 - f5;
        float f10 = f4 + (14.0f - f5) * 0.5f;
        boolean bl = UiKit.inside(f, f2, f9, f10, f5, f5);
        boolean bl2 = UiKit.inside(f, f2, f7, f10, f5, f5);
        DrawUtil.round(class_3322, f9, f10, f5, f5, Theme.r(3.0f), bl ? Theme.fieldHover : Theme.card);
        DrawUtil.round(class_3322, f7, f10, f5, f5, Theme.r(3.0f), bl2 ? Theme.fieldHover : Theme.card);
        UiKit.VALUE.drawCentered(class_3322, "-", f9 + f5 * 0.5f, UiKit.VALUE.centerTop(f10 + f5 * 0.5f), bl ? Theme.text : Theme.textDim);
        IconRenderer.draw(class_3322, Icon.PLUS, f7 + f5 * 0.5f, f10 + f5 * 0.5f, 6.0f, bl2 ? Theme.text : Theme.textDim);
        UiKit.VALUE.drawCentered(class_3322, string, f8 + f6 * 0.5f, UiKit.VALUE.centerTop(f10 + f5 * 0.5f), Theme.text);
        this.hsi.add(new hrk(f9, f10, f5, f5, runnable, null));
        this.hsi.add(new hrk(f7, f10, f5, f5, runnable2, null));
    }

    private void hti(class_332 class_3322) {
        float f = this.hsf + 336.0f - 8.0f - 5.0f;
        DrawUtil.rect(class_3322, this.hse + 12.0f, this.hsf + 336.0f - 16.0f - 8.0f, 446.0f, 1.0f, Theme.divider);
        String string = this.hsn != null ? this.hsn : Lang.s("Click — details  ·  right click — on / off  ·  Shift + / − steps by 8", "Клик — настройки  ·  ПКМ — вкл / выкл  ·  Shift + / − шаг 8");
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, 446.0f), this.hse + 12.0f, UiKit.SMALL.centerTop(f), this.hsn != null ? Theme.text : Theme.textMuted);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (this.hsl) {
            return true;
        }
        if (!UiKit.inside(f, f2, this.hse, this.hsf, 470.0f, 336.0f)) {
            this.close();
            return true;
        }
        if (this.search.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        hlc2.focus(null);
        for (int i = this.hsi.size() - 1; i >= 0; --i) {
            Runnable runnable;
            hrk hrk2 = this.hsi.get(i);
            if (!UiKit.inside(f, f2, hrk2.x(), hrk2.y(), hrk2.w(), hrk2.h())) continue;
            Runnable runnable2 = n == 1 ? hrk2.right() : (runnable = n == 0 ? hrk2.left() : null);
            if (runnable == null) continue;
            runnable.run();
            return true;
        }
        return true;
    }

    @Override
    void scrolled(double d) {
        this.hsk = Math.max(0.0f, Math.min(this.hsy(), this.hsk - (float)d * 30.0f * 2.0f));
    }

    @Override
    boolean keyPressed(ClickGuiScreen hlc2, int n, int n2) {
        if (n == 256) {
            if (hlc2.focusedField() == this.search && !this.search.text.isEmpty()) {
                this.search.setText("");
            } else {
                this.close();
            }
            return true;
        }
        if (hlc2.focusedField() == this.search) {
            this.search.keyPressed(hlc2, n, n2);
            return true;
        }
        if ((n2 & 2) != 0 && n == 70) {
            hlc2.focus(this.search);
        }
        return true;
    }

    private /* synthetic */ void lambda$grid$5(CustomItemInfo pdr2) {
        pdr2.setActive(!pdr2.active());
        this.hsm = pdr2;
        this.hsr();
    }

    private /* synthetic */ void lambda$grid$4(CustomItemInfo pdr2) {
        this.hsm = pdr2;
    }

    private static /* synthetic */ int acd(int n, int n2) {
        return n * n2 | 0xAD235F0B;
    }

    private static /* synthetic */ int ace(int n, int n2) {
        return n * n2 ^ 0x34ECD24C;
    }

    private static /* synthetic */ int acf(int n, int n2) {
        return CollectorListPopup.ace(n, n2) + n;
    }
}

