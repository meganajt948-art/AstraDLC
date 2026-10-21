/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1826
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_332
 *  net.minecraft.class_7923
 */
package a;

import a.ClickGuiScreen;
import a.TextField;
import a.iay;
import a.Popup;
import a.Theme;
import a.UiKit;
import a.ppn;
import a.TalismanTable;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.vlg;
import a.ListSetting;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_1299;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1826;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_332;
import net.minecraft.class_7923;

final class ItemPickerPopup
extends Popup {
    static final float W = 430.0f;
    static final float H = 318.0f;
    private static final float ibg = 12.0f;
    private static final float ibh = 30.0f;
    private static final float ibi = 22.0f;
    private static final float ibj = 22.0f;
    private static final float ibk = 20.0f;
    private static final float ibl = 3.0f;
    private static final float ibm = 16.0f;
    private static final Map<vlg, List<iay>> ibn = new EnumMap<vlg, List<iay>>(vlg.class);
    final ListSetting setting;
    final TextField search = new TextField("Search", Icon.SEARCH, 32, TextField.ANY);
    private final float ibo;
    private final float ibp;
    private final Spring ibq = new Spring(16.0f);
    private final Spring ibr = new Spring(18.0f);
    private final Spring[] ibs = new Spring[]{new Spring(16.0f), new Spring(16.0f), new Spring(16.0f), new Spring(16.0f), new Spring(16.0f)};
    private final Spring ibt = new Spring(16.0f);
    private float ibu;
    private boolean ibv;
    private boolean ibw;
    private List<iay> ibx = List.of();
    private String iby;
    private String ibz;
    private int ica = -1;
    private final Spring icb = new Spring(20.0f);
    private static /* synthetic */ String icc;
    private static /* synthetic */ int icd;

    ItemPickerPopup(ListSetting vlj2, float f, float f2) {
        this.setting = vlj2;
        this.ibo = (f - 430.0f) * 0.5f;
        this.ibp = (f2 - 318.0f) * 0.5f;
        this.search.onChange = string -> this.icg();
        this.icg();
    }

    private static List<iay> ice(vlg vlg3) {
        if (vlg3 == vlg.LOOT) {
            ArrayList<iay> arrayList = new ArrayList<iay>();
            for (ppn ppn2 : TalismanTable.entries()) {
                arrayList.add(new iay(ppn2.id, ppn2.icon(), ppn2.shownName(), ppn2.name + " " + ppn2.nameEn + " " + ppn2.id.replace('_', ' ')));
            }
            return arrayList;
        }
        return ibn.computeIfAbsent(vlg3, vlg2 -> {
            ArrayList<iay> arrayList = new ArrayList<iay>();
            if (vlg2 == vlg.MOBS) {
                for (class_1299 class_12992 : class_7923.field_41177) {
                    class_1826 class_18262 = class_1826.method_8019((class_1299)class_12992);
                    if (class_18262 == null) continue;
                    arrayList.add(ItemPickerPopup.icf(class_7923.field_41177.method_10221((Object)class_12992).toString(), new class_1799((class_1935)class_18262), class_12992.method_5897().getString()));
                }
                arrayList.sort((iay2, iay3) -> iay2.ibb.compareToIgnoreCase(iay3.ibb));
            } else if (vlg2 == vlg.BLOCKS) {
                for (class_2248 class_22482 : class_7923.field_41175) {
                    if (class_22482 == class_2246.field_10124 || class_22482 == class_2246.field_10543 || class_22482 == class_2246.field_10243) continue;
                    class_1792 class_17922 = class_22482.method_8389();
                    if (class_22482 == class_2246.field_10382) {
                        class_17922 = class_1802.field_8705;
                    } else if (class_22482 == class_2246.field_10164) {
                        class_17922 = class_1802.field_8187;
                    } else if (class_22482 == class_2246.field_10316 || class_22482 == class_2246.field_10027) {
                        class_17922 = class_1802.field_8449;
                    }
                    if (class_17922 == class_1802.field_8162) continue;
                    String string = class_7923.field_41175.method_10221((Object)class_22482).toString();
                    arrayList.add(ItemPickerPopup.icf(string, new class_1799((class_1935)class_17922), class_22482.method_9518().getString()));
                }
            } else {
                for (class_1792 class_17923 : class_7923.field_41178) {
                    if (class_17923 == class_1802.field_8162) continue;
                    class_1799 class_17992 = new class_1799((class_1935)class_17923);
                    arrayList.add(ItemPickerPopup.icf(class_7923.field_41178.method_10221((Object)class_17923).toString(), class_17992, class_17992.method_7964().getString()));
                }
            }
            return arrayList;
        });
    }

    private static iay icf(String string, class_1799 class_17992, String string2) {
        String string3 = string.startsWith("minecraft:") ? string.substring(10) : string;
        return new iay(string, class_17992, string2, string2 + " " + string3 + " " + string3.replace('_', ' '));
    }

    static class_1799 iconOf(vlg vlg2, String string) {
        for (iay iay2 : ItemPickerPopup.ice(vlg2)) {
            if (!iay2.iaz.equals(string)) continue;
            return iay2.iba;
        }
        return class_1799.field_8037;
    }

    private void icg() {
        ArrayList<iay> arrayList = new ArrayList<iay>();
        String string = this.search.text;
        for (iay iay2 : ItemPickerPopup.ice(this.setting.kind())) {
            if (this.ibv && !this.setting.contains(iay2.iaz) || !Lang.matches(iay2.ibc, string)) continue;
            arrayList.add(iay2);
        }
        this.ibx = arrayList;
        this.ibu = Math.min(this.ibu, this.icr());
    }

    private float ich() {
        return this.ibo + 12.0f;
    }

    private float ici() {
        return this.ibp + 30.0f + 22.0f + 8.0f;
    }

    private float icj() {
        return 406.0f;
    }

    private float ick() {
        return 318.0f - (this.ici() - this.ibp) - 16.0f - 6.0f;
    }

    private boolean icl() {
        return this.setting.kind() == vlg.LOOT || this.setting.kind() == vlg.MOBS;
    }

    private int icm() {
        return this.icl() ? 2 : Math.max(1, (int)((this.icj() + 3.0f) / 25.0f));
    }

    private float icn() {
        return this.icl() ? (this.icj() - 3.0f) * 0.5f : 22.0f;
    }

    private float ico() {
        return this.icl() ? 20.0f : 22.0f;
    }

    private float icp() {
        int n = this.icm();
        if (this.icl()) {
            return this.icn() + 3.0f;
        }
        return n <= 1 ? 25.0f : (this.icj() - 22.0f) / (float)(n - 1);
    }

    private float icq() {
        int n = (this.ibx.size() + this.icm() - 1) / this.icm();
        return (float)n * (this.ico() + 3.0f);
    }

    private float icr() {
        return Math.max(0.0f, this.icq() - this.ick());
    }

    boolean contains(float f, float f2) {
        return UiKit.inside(f, f2, this.ibo, this.ibp, 430.0f, 318.0f);
    }

    @Override
    TextField field() {
        return this.search;
    }

    @Override
    boolean gone() {
        return this.ibw && this.ibq.get() <= 0.01f;
    }

    @Override
    boolean closing() {
        return this.ibw;
    }

    @Override
    void close() {
        this.ibw = true;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = Easing.outCubic(this.ibq.step(this.ibw ? 0.0f : 1.0f, f3));
        if (f7 <= 0.01f) {
            return;
        }
        boolean bl = !this.ibw;
        float f8 = Theme.r(10.0f);
        float f9 = Theme.lightness();
        DrawUtil.round(class_3322, 0.0f, 0.0f, f4, f5, Theme.r(12.0f), ColorUtil.withAlpha(0, Math.round(110.0f * f7)));
        DrawUtil.pushAlpha(f7);
        class_3322.method_51448().pushMatrix();
        float f10 = 0.96f + 0.04f * f7;
        class_3322.method_51448().translate(this.ibo + 215.0f, this.ibp + 159.0f + (1.0f - f7) * 6.0f);
        class_3322.method_51448().scale(f10, f10);
        class_3322.method_51448().translate(-(this.ibo + 215.0f), -(this.ibp + 159.0f));
        DrawUtil.shadow(class_3322, this.ibo, this.ibp + 4.0f, 430.0f, 318.0f, f8, 18.0f, Theme.shadow);
        DrawUtil.round(class_3322, this.ibo, this.ibp, 430.0f, 318.0f, f8, ColorUtil.withAlpha(Theme.window, 252));
        DrawUtil.round(class_3322, this.ibo, this.ibp, 430.0f, 318.0f, f8, Theme.card);
        GlassDraw.sheen(class_3322, this.ibo, this.ibp, 430.0f, 50.0f, f8, 0.8f * (1.0f - 0.7f * f9));
        DrawUtil.outline(class_3322, this.ibo, this.ibp, 430.0f, 318.0f, f8, 1.0f, Theme.stroke);
        GlassDraw.rim(class_3322, this.ibo, this.ibp, 430.0f, 318.0f, f8, f9, 1.0f);
        IconRenderer.draw(class_3322, this.setting.kind() == vlg.BLOCKS ? Icon.LAYERS : Icon.MISC, this.ibo + 12.0f + 5.0f, this.ibp + 15.0f + 1.0f, 10.0f, Theme.accent());
        String string = Lang.t(this.setting.getName());
        UiKit.CARD_TITLE.draw(class_3322, string, this.ibo + 12.0f + 16.0f, UiKit.CARD_TITLE.centerTop(this.ibp + 15.0f + 1.0f), Theme.text);
        String string2 = this.setting.size() + Lang.s(" picked", " выбрано");
        UiKit.drawChip(class_3322, string2, this.ibo + 12.0f + 16.0f + UiKit.CARD_TITLE.width(string) + 8.0f + Math.max(16.0f, UiKit.SMALL.width(string2) + 9.0f), this.ibp + 15.0f + 1.0f, Theme.textDim, Theme.stroke, 0.0f);
        float f11 = 16.0f;
        float f12 = this.ibo + 430.0f - 12.0f - f11;
        float f13 = this.ibp + (30.0f - f11) * 0.5f + 1.0f;
        float f14 = this.ibt.step(bl && UiKit.inside(f, f2, f12, f13, f11, f11), f3);
        UiKit.iconButton(class_3322, Icon.CLOSE, f12, f13, f11, f14, false, 1.0f);
        float f15 = this.ibp + 30.0f + 2.0f;
        this.search.x = this.ibo + 12.0f;
        this.search.y = f15 + 3.0f;
        this.search.w = 170.0f;
        this.search.h = 16.0f;
        this.search.render(class_3322, hlc2, f, f2, f3);
        float f16 = this.search.x + this.search.w + 8.0f;
        String[] stringArray = new String[]{Lang.s("All", "Все"), Lang.s("Selected", "Выбранные")};
        float f17 = 128.0f;
        float f18 = 16.0f;
        float f19 = f15 + (22.0f - f18) * 0.5f;
        DrawUtil.round(class_3322, f16, f19, f17, f18, Theme.r(5.0f), Theme.field);
        float f20 = f17 * 0.5f;
        float f21 = this.ibv ? f20 : 0.0f;
        DrawUtil.round(class_3322, f16 + f21 + 1.5f, f19 + 1.5f, f20 - 3.0f, f18 - 3.0f, Theme.r(4.0f), Theme.accent(60));
        for (int i = 0; i < 2; ++i) {
            boolean bl2 = i == 1 == this.ibv;
            f6 = this.ibs[i].step(bl && UiKit.inside(f, f2, f16 + (float)i * f20, f19, f20, f18), f3);
            UiKit.VALUE.drawCentered(class_3322, stringArray[i], f16 + (float)i * f20 + f20 * 0.5f, UiKit.VALUE.centerTop(f19 + f18 * 0.5f), bl2 ? Theme.text : ColorUtil.lerp(Theme.textMuted, Theme.textDim, f6));
        }
        float f22 = (this.ibo + 430.0f - 12.0f - (f16 + f17 + 8.0f) - 6.0f) * 0.5f;
        float f23 = f16 + f17 + 8.0f;
        f6 = f23 + f22 + 6.0f;
        UiKit.secondaryButton(class_3322, Lang.s("Clear", "Очистить"), Icon.TRASH, f23, f19, f22, f18, this.ibs[2].step(bl && UiKit.inside(f, f2, f23, f19, f22, f18), f3), 0.0f);
        UiKit.secondaryButton(class_3322, Lang.s("Reset", "Сброс"), Icon.RESET, f6, f19, f22, f18, this.ibs[3].step(bl && UiKit.inside(f, f2, f6, f19, f22, f18), f3), 0.0f);
        this.ics(class_3322, f, f2, f3, bl);
        float f24 = this.ibp + 318.0f - 8.0f - 5.0f;
        DrawUtil.rect(class_3322, this.ibo + 12.0f, this.ibp + 318.0f - 16.0f - 8.0f, 406.0f, 1.0f, Theme.divider);
        if (this.iby != null) {
            UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(this.iby, 236.5f), this.ibo + 12.0f, UiKit.LABEL.centerTop(f24), Theme.text);
            UiKit.SMALL.draw(class_3322, this.ibz, this.ibo + 430.0f - 12.0f - UiKit.SMALL.width(this.ibz), UiKit.SMALL.centerTop(f24), Theme.textMuted);
        } else {
            String string3 = this.ibx.isEmpty() ? Lang.s("Nothing found", "Ничего не найдено") : Lang.s("Click to add or remove  ·  ", "Клик — добавить или убрать  ·  ") + this.ibx.size() + Lang.s(" shown", " показано");
            UiKit.SMALL.draw(class_3322, string3, this.ibo + 12.0f, UiKit.SMALL.centerTop(f24), Theme.textMuted);
        }
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    private void ics(class_332 class_3322, float f, float f2, float f3, boolean bl) {
        float f4 = this.ich();
        float f5 = this.ici();
        float f6 = this.icj();
        float f7 = this.ick();
        float f8 = this.ibr.step(Math.max(0.0f, Math.min(this.ibu, this.icr())), f3);
        int n = this.icm();
        float f9 = this.icp();
        this.iby = null;
        this.ibz = null;
        int n2 = -1;
        DrawUtil.pushScissor(class_3322, f4 - 2.0f, f5 - 2.0f, f6 + 4.0f, f7 + 4.0f);
        float f10 = this.icn();
        float f11 = this.ico();
        boolean bl2 = this.icl();
        int n3 = Math.max(0, (int)(f8 / (f11 + 3.0f)));
        int n4 = (int)((f8 + f7) / (f11 + 3.0f)) + 1;
        float f12 = Theme.r(5.0f);
        for (int i = n3; i <= n4; ++i) {
            int n5;
            for (int j = 0; j < n && (n5 = i * n + j) < this.ibx.size(); ++j) {
                float f13;
                float f14;
                iay iay2 = this.ibx.get(n5);
                float f15 = f4 + (float)j * f9;
                float f16 = f5 + (float)i * (f11 + 3.0f) - f8;
                boolean bl3 = bl && UiKit.inside(f, f2, f15, f16, f10, f11) && UiKit.inside(f, f2, f4, f5, f6, f7);
                boolean bl4 = this.setting.contains(iay2.iaz);
                float f17 = 0.0f;
                if (bl3) {
                    n2 = n5;
                    this.iby = iay2.ibb;
                    this.ibz = iay2.iaz;
                    f17 = bl2 ? 0.0f : this.icb.get();
                }
                int n6 = bl4 ? ColorUtil.lerp(Theme.field, Theme.accent(), 0.28f) : Theme.field;
                DrawUtil.round(class_3322, f15, f16 - f17, f10, f11, f12, bl3 ? ColorUtil.lerp(n6, Theme.fieldHover, 0.6f) : n6);
                if (bl4) {
                    DrawUtil.outline(class_3322, f15, f16 - f17, f10, f11, f12, 1.0f, Theme.accent(200));
                }
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f15 + (bl2 ? 2.0f : 3.0f), f16 + (f11 - 16.0f) * 0.5f - f17);
                class_3322.method_51427(iay2.iba, 0, 0);
                class_3322.method_51448().popMatrix();
                if (bl2) {
                    f14 = f15 + 21.0f;
                    f13 = f10 - 21.0f - (bl4 ? 14.0f : 4.0f);
                    UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(iay2.ibb, f13), f14, UiKit.LABEL.centerTop(f16 + f11 * 0.5f), bl4 ? Theme.text : Theme.textDim);
                }
                if (!bl4) continue;
                f14 = bl2 ? f15 + f10 - 7.0f : f15 + 22.0f - 3.5f;
                f13 = bl2 ? f16 + f11 * 0.5f : f16 + 3.5f - f17;
                DrawUtil.circle(class_3322, f14, f13, 3.0f, Theme.accent());
                IconRenderer.draw(class_3322, Icon.CHECK, f14, f13, 4.5f, Theme.onAccent());
            }
        }
        DrawUtil.popScissor(class_3322);
        if (n2 != this.ica) {
            this.ica = n2;
            this.icb.set(0.0f);
        }
        this.icb.step(n2 >= 0 ? 1.5f : 0.0f, f3);
        float f18 = this.icr();
        if (f18 > 0.0f) {
            float f19 = Math.max(18.0f, f7 * f7 / this.icq());
            float f20 = f5 + (f7 - f19) * (f8 / f18);
            DrawUtil.round(class_3322, f4 + f6 + 4.0f, f20, 2.5f, f19, 1.25f, ColorUtil.withAlpha(Theme.textMuted, 110));
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (this.ibw) {
            return true;
        }
        if (!this.contains(f, f2)) {
            this.close();
            return true;
        }
        float f3 = 16.0f;
        if (n == 0 && UiKit.inside(f, f2, this.ibo + 430.0f - 12.0f - f3, this.ibp + (30.0f - f3) * 0.5f + 1.0f, f3, f3)) {
            this.close();
            return true;
        }
        if (this.search.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        hlc2.focus(null);
        float f4 = this.ibp + 30.0f + 2.0f;
        float f5 = this.search.x + this.search.w + 8.0f;
        float f6 = 128.0f;
        float f7 = f4 + 3.0f;
        if (n == 0 && UiKit.inside(f, f2, f5, f7, f6, 16.0f)) {
            this.ibv = f >= f5 + f6 * 0.5f;
            this.ibu = 0.0f;
            this.icg();
            return true;
        }
        float f8 = (this.ibo + 430.0f - 12.0f - (f5 + f6 + 8.0f) - 6.0f) * 0.5f;
        float f9 = f5 + f6 + 8.0f;
        if (n == 0 && UiKit.inside(f, f2, f9, f7, f8, 16.0f)) {
            this.setting.clear();
            this.icg();
            hlc2.toast(Lang.s("List cleared", "Список очищен"), Icon.TRASH, false);
            return true;
        }
        if (n == 0 && UiKit.inside(f, f2, f9 + f8 + 6.0f, f7, f8, 16.0f)) {
            this.setting.reset();
            this.icg();
            hlc2.toast(Lang.s("Back to the default list", "Вернули список по умолчанию"), Icon.RESET, false);
            return true;
        }
        if (n == 0 && UiKit.inside(f, f2, this.ich(), this.ici(), this.icj(), this.ick()) && this.ica >= 0 && this.ica < this.ibx.size()) {
            iay iay2 = this.ibx.get(this.ica);
            this.setting.toggle(iay2.iaz);
            if (this.ibv && !this.setting.contains(iay2.iaz)) {
                this.icg();
            }
            return true;
        }
        return true;
    }

    @Override
    void scrolled(double d) {
        this.ibu = Math.max(0.0f, Math.min(this.icr(), this.ibu - (float)d * (this.ico() + 3.0f) * 2.0f));
    }

    @Override
    boolean keyPressed(ClickGuiScreen hlc2, int n, int n2) {
        boolean bl;
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
        boolean bl2 = bl = (n2 & 2) != 0;
        if (bl && n == 70) {
            hlc2.focus(this.search);
        }
        return true;
    }

    static String idPath(String string) {
        return string.toLowerCase(Locale.ROOT).startsWith("minecraft:") ? string.substring(10) : string;
    }

    private static /* synthetic */ int afc(int n, int n2) {
        return (n ^ n2) + -724482325;
    }

    private static /* synthetic */ int afd(int n, int n2) {
        return ItemPickerPopup.afc(n, n2) * n2;
    }

    private static /* synthetic */ int afe(int n, int n2) {
        return ItemPickerPopup.afc(n, n2) + n;
    }
}

