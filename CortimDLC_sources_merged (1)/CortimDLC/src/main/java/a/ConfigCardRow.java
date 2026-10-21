/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.ConfigSaveRow;
import a.hvn;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.DrawUtil;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.config.ConfigManager;
import flow.config.ConfigShare;
import flow.dev.StringDecryptor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class ConfigCardRow
extends Widget {
    private static final float hvr = 30.0f;
    private static final float hvs = 3.0f;
    private static final float hvt = 18.0f;
    private static final Icon[] hvu = new Icon[]{Icon.DOWNLOAD, Icon.SAVE, Icon.PENCIL, Icon.SHARE, Icon.TRASH};
    private static final int hvv = 3;
    private static final int hvw = 4;
    private static final SimpleDateFormat hvx = new SimpleDateFormat("d MMM, HH:mm", Locale.ROOT);
    private static final SimpleDateFormat hvy = new SimpleDateFormat("d MMM, HH:mm", Locale.forLanguageTag("ru"));
    private final ConfigSaveRow hvz;
    private List<ConfigManager.Info> hwa = new ArrayList<ConfigManager.Info>();
    private Map<String, String> hwb = new HashMap<String, String>();
    private String hwc;
    private int hwd = -1;
    private long hwe;
    private final Map<String, hvn> hwf = new HashMap<String, hvn>();
    private String hwg;
    private long hwh;
    private static /* synthetic */ long hwi;
    private static /* synthetic */ int hwj;

    private static String hwk(int n, String string) {
        return switch (n) {
            case 0 -> Lang.s("Load this config", "Загрузить этот конфиг");
            case 1 -> Lang.s("Overwrite with the current settings", "Перезаписать текущими настройками");
            case 2 -> Lang.s("Rename to the name in the field above", "Переименовать в имя из поля выше");
            case 3 -> {
                if (string != null) {
                    yield Lang.s("Code " + string + ": copy it and send it to a friend", "Код " + string + ": скопировать и отправить другу");
                }
                yield Lang.s("Share: get a code for a friend", "Поделиться: получить код для друга");
            }
            default -> Lang.s("Delete (click again to confirm)", "Удалить (нажмите ещё раз для подтверждения)");
        };
    }

    ConfigCardRow(ConfigSaveRow hur2) {
        super(null);
        this.hvz = hur2;
    }

    private List<ConfigManager.Info> hwl() {
        long l = System.currentTimeMillis();
        if (this.hwd != ConfigManager.version() || l - this.hwe > 1500L) {
            this.hwd = ConfigManager.version();
            this.hwe = l;
            this.hwa = ConfigManager.list();
            this.hwb = ConfigShare.codes();
        }
        return this.hwa;
    }

    @Override
    float height() {
        int n = this.hwl().size();
        return n == 0 ? 58.0f : 2.0f + (float)n * 33.0f;
    }

    private float hwm(int n) {
        return this.y + 2.0f + (float)n * 33.0f;
    }

    private float hwn(int n) {
        return this.x + this.w - 8.0f - (float)(hvu.length - n) * 22.0f + 4.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<ConfigManager.Info> list = this.hwl();
        if (list.isEmpty()) {
            this.hwo(class_3322);
            return;
        }
        if (this.hwg != null && System.currentTimeMillis() > this.hwh) {
            this.hwg = null;
        }
        String string2 = ConfigManager.active();
        float f4 = Theme.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            ConfigManager.Info info = list.get(i);
            hvn hvn2 = this.hwf.computeIfAbsent(info.name(), string -> new hvn());
            float f5 = this.hwm(i);
            float f6 = Easing.outCubic(hvn2.appear.step(1.0f, f3));
            boolean bl = hlc2.canHover() && UiKit.inside(f, f2, this.x, f5, this.w, 30.0f);
            float f7 = hvn2.hover.step(bl, f3);
            boolean bl2 = info.name().equals(string2);
            DrawUtil.pushAlpha(f6);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate((1.0f - f6) * 18.0f, 0.0f);
            int n = bl2 ? Theme.accent(26) : ColorUtil.withAlpha(Theme.hover, (int)((float)ColorUtil.alpha(Theme.hover) * (0.6f + 1.4f * f7)));
            DrawUtil.round(class_3322, this.x, f5, this.w, 30.0f, f4, n);
            if (bl2 || f7 > 0.01f) {
                DrawUtil.outline(class_3322, this.x, f5, this.w, 30.0f, f4, 1.0f, bl2 ? Theme.accent(110) : ColorUtil.withAlpha(Theme.stroke, (int)((float)ColorUtil.alpha(Theme.stroke) * f7)));
            }
            float f8 = this.x + 15.0f;
            float f9 = f5 + 15.0f;
            if (bl2) {
                DrawUtil.shadow(class_3322, f8 - 9.0f, f9 - 9.0f, 18.0f, 18.0f, 9.0f, 5.0f, Theme.accent(80));
                DrawUtil.gradient(class_3322, f8 - 9.0f, f9 - 9.0f, 18.0f, 18.0f, 9.0f, Theme.accent(), Theme.accent2(), Theme.accent2(), Theme.accent());
            } else {
                DrawUtil.circle(class_3322, f8, f9, 9.0f, Theme.field);
            }
            IconRenderer.draw(class_3322, Icon.LAYERS, f8, f9, 8.0f, bl2 ? Theme.onAccent() : ColorUtil.lerp(Theme.textMuted, Theme.textDim, f7));
            float f10 = this.x + 31.0f;
            float f11 = this.hwn(0) - f10 - 8.0f;
            String string3 = UiKit.CARD_TITLE.ellipsize(info.name(), f11 - (bl2 ? 36.0f : 0.0f));
            float f12 = UiKit.CARD_TITLE.draw(class_3322, string3, f10, UiKit.CARD_TITLE.centerTop(f9 - 4.5f), Theme.text);
            if (bl2) {
                DrawUtil.round(class_3322, f12 + 5.0f, f9 - 9.0f, 30.0f, 9.0f, 4.5f, Theme.accent(45));
                UiKit.SMALL.drawCentered(class_3322, Lang.s("Active", "Активен"), f12 + 20.0f, UiKit.SMALL.centerTop(f9 - 4.5f), Theme.accent());
            }
            String string4 = this.hwb.get(info.name());
            String string5 = (Lang.ru() ? hvy : hvx).format(new Date(info.modified())) + "  ·  " + info.enabled() + Lang.s(" of ", " из ") + info.modules() + Lang.s(" on", " вкл") + (string4 != null ? Lang.s("  ·  code ", "  ·  код ") + string4 : "");
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string5, f11), f10, UiKit.SMALL.centerTop(f9 + 5.5f), Theme.textMuted);
            float f13 = 0.45f + 0.55f * f7;
            for (int j = 0; j < hvu.length; ++j) {
                float f14 = this.hwn(j);
                float f15 = f9 - 9.0f;
                boolean bl3 = hlc2.canHover() && UiKit.inside(f, f2, f14, f15, 18.0f, 18.0f);
                float f16 = hvn2.buttons[j].step(bl3, f3);
                boolean bl4 = j == 4 && info.name().equals(this.hwg);
                boolean bl5 = j == 3 && info.name().equals(this.hwc);
                UiKit.iconButton(class_3322, hvu[j], f14, f15, 18.0f, bl5 ? 1.0f : f16, bl4, bl4 || bl5 ? 1.0f : f13);
                if (!bl3) continue;
                hlc2.hint(bl4 ? Lang.s("Click again to delete “" + info.name() + "”", "Нажмите ещё раз, чтобы удалить «" + info.name() + "»") : ConfigCardRow.hwk(j, string4));
            }
            class_3322.method_51448().popMatrix();
            DrawUtil.popAlpha();
        }
    }

    private void hwo(class_332 class_3322) {
        float f = this.x + this.w * 0.5f;
        DrawUtil.circle(class_3322, f, this.y + 17.0f, 12.0f, Theme.hover);
        IconRenderer.draw(class_3322, Icon.LAYERS, f, this.y + 17.0f, 11.0f, Theme.textMuted);
        UiKit.LABEL.drawCentered(class_3322, Lang.s("No configs yet", "Конфигов пока нет"), f, UiKit.LABEL.centerTop(this.y + 38.0f), Theme.textDim);
        UiKit.SMALL.drawCentered(class_3322, Lang.s("Type a name above and press Save", "Введите имя выше и нажмите «Сохранить»"), f, UiKit.SMALL.centerTop(this.y + 49.0f), Theme.textMuted);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        List<ConfigManager.Info> list = this.hwl();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.hwm(i);
            if (!UiKit.inside(f, f2, this.x, f3, this.w, 30.0f)) continue;
            String string = list.get(i).name();
            float f4 = f3 + 15.0f;
            for (int j = 0; j < hvu.length; ++j) {
                if (n != 0 || !UiKit.inside(f, f2, this.hwn(j), f4 - 9.0f, 18.0f, 18.0f)) continue;
                this.hwp(hlc2, j, string);
                return true;
            }
            this.hvz.name.setText(string);
            return true;
        }
        return false;
    }

    private void hwp(ClickGuiScreen hlc2, int n, String string) {
        try {
            switch (n) {
                case 0: {
                    ConfigManager.load(string);
                    hlc2.toast(Lang.s("Loaded “" + string + "”", "Загружен «" + string + "»"), Icon.DOWNLOAD, false);
                    break;
                }
                case 1: {
                    ConfigManager.save(string);
                    hlc2.toast(Lang.s("Saved “" + string + "”", "Сохранено «" + string + "»"), Icon.SAVE, false);
                    break;
                }
                case 2: {
                    String string2 = ConfigManager.sanitize(this.hvz.name.text);
                    if (string2 == null || string2.equals(string)) {
                        this.hvz.name.error();
                        hlc2.focus(this.hvz.name);
                        hlc2.toast(Lang.s("Type the new name in the field above, then press the pencil", "Введите новое имя в поле выше и нажмите карандаш"), Icon.PENCIL, true);
                        return;
                    }
                    ConfigManager.rename(string, string2);
                    this.hwf.put(string2, this.hwf.remove(string));
                    hlc2.toast(Lang.s("Renamed to “" + string2 + "”", "Переименован в «" + string2 + "»"), Icon.PENCIL, false);
                    break;
                }
                case 3: {
                    this.hwq(hlc2, string);
                    break;
                }
                case 4: {
                    if (!string.equals(this.hwg)) {
                        this.hwg = string;
                        this.hwh = System.currentTimeMillis() + 2500L;
                        return;
                    }
                    this.hwg = null;
                    ConfigManager.delete(string);
                    this.hwf.remove(string);
                    hlc2.toast(Lang.s("Deleted “" + string + "”", "Удалён «" + string + "»"), Icon.TRASH, false);
                    break;
                }
            }
        }
        catch (IOException | RuntimeException exception) {
            hlc2.toast(Lang.s("Failed: ", "Ошибка: ") + exception.getMessage(), Icon.INFO, true);
        }
        this.hwd = -1;
    }

    private void hwq(ClickGuiScreen hlc2, String string2) {
        if (this.hwc != null) {
            return;
        }
        this.hwc = string2;
        ConfigShare.share(string2).whenCompleteAsync((string, throwable) -> {
            this.hwc = null;
            this.hwd = -1;
            if (throwable != null) {
                hlc2.toast(ConfigShare.describe(throwable), Icon.INFO, true);
                return;
            }
            class_310.method_1551().field_1774.method_1455(string);
            hlc2.toast(Lang.s("Code copied: " + string, "Код скопирован: " + string), Icon.SHARE, false);
        }, (Executor)class_310.method_1551());
    }

    private static /* synthetic */ int acz(int n, int n2) {
        return (n ^ n2) + 656459855;
    }
}

