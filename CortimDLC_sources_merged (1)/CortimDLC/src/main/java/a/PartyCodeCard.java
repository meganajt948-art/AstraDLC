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
import a.ucd;
import a.PartyClient;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class PartyCodeCard
extends Widget {
    private static final FontFace ikf = Fonts.bold(12.0f);
    private static final float ikg = 26.0f;
    private static final float ikh = 18.0f;
    private final Spring iki = new Spring(16.0f);
    private final Spring ikj = new Spring(16.0f);
    private final Spring ikk = new Spring(16.0f);
    private final Spring ikl = new Spring(6.0f);
    private int ikm = PartyClient.noticeSeq();
    private long ikn;
    private static /* synthetic */ boolean iko;
    private static /* synthetic */ boolean ikp;

    PartyCodeCard() {
        super(null);
    }

    @Override
    float height() {
        return 45.0f;
    }

    private float ikq() {
        return this.x + this.w - 6.0f - 36.0f - 3.0f;
    }

    private float ikr() {
        return this.x + this.w - 6.0f - 18.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        int n;
        if (PartyClient.noticeSeq() != this.ikm) {
            this.ikm = PartyClient.noticeSeq();
            if (PartyClient.notice() != null) {
                hlc2.toast(PartyClient.notice(), PartyClient.noticeError() ? Icon.INFO : Icon.FRIENDS, PartyClient.noticeError());
            }
        }
        float f4 = this.y + 4.0f;
        float f5 = Theme.r(6.0f);
        boolean bl = hlc2.canHover() && UiKit.inside(f, f2, this.x, f4, this.ikq() - this.x - 4.0f, 26.0f);
        float f6 = this.ikk.step(bl, f3);
        DrawUtil.round(class_3322, this.x, f4, this.w, 26.0f, f5, ColorUtil.lerp(Theme.field, Theme.fieldHover, f6));
        GlassDraw.rim(class_3322, this.x, f4, this.w, 26.0f, f5, Theme.lightness(), 0.6f);
        float f7 = f4 + 13.0f;
        String string = PartyClient.prettyCode();
        float f8 = this.ikl.step(0.0f, f3);
        UiKit.SMALL.draw(class_3322, Lang.s("YOUR CODE", "ВАШ КОД"), this.x + 9.0f, UiKit.SMALL.centerTop(f7 - 6.0f), Theme.textMuted);
        if (string != null) {
            ikf.drawTracked(class_3322, string, this.x + 9.0f, ikf.centerTop(f7 + 4.0f), ColorUtil.lerp(Theme.text, Theme.accent() | 0xFF000000, Math.max(f8, f6 * 0.4f)), 1.2f);
        } else {
            ikf.drawTracked(class_3322, "———-———", this.x + 9.0f, ikf.centerTop(f7 + 4.0f), Theme.textMuted, 1.2f);
        }
        if (f8 > 0.02f) {
            DrawUtil.pushAlpha(f8);
            UiKit.SMALL.draw(class_3322, Lang.s("Copied", "Скопировано"), this.x + 9.0f + ikf.width(string != null ? string : "") + 14.0f, UiKit.SMALL.centerTop(f7 + 4.0f), Theme.accent() | 0xFF000000);
            DrawUtil.popAlpha();
        }
        boolean bl2 = string != null;
        boolean bl3 = hlc2.canHover() && UiKit.inside(f, f2, this.ikq(), f7 - 9.0f, 18.0f, 18.0f);
        boolean bl4 = hlc2.canHover() && UiKit.inside(f, f2, this.ikr(), f7 - 9.0f, 18.0f, 18.0f);
        boolean bl5 = System.currentTimeMillis() < this.ikn;
        UiKit.iconButton(class_3322, Icon.COPY, this.ikq(), f7 - 9.0f, 18.0f, this.iki.step(bl3, f3), false, bl2 ? 1.0f : 0.35f);
        UiKit.iconButton(class_3322, Icon.REFRESH, this.ikr(), f7 - 9.0f, 18.0f, this.ikj.step(bl4, f3), bl5, bl2 ? 1.0f : 0.35f);
        float f9 = f4 + 26.0f + 8.0f;
        if (hlc2.canHover() && UiKit.inside(f, f2, this.x, f9 - 5.0f, this.w, 10.0f) && PartyClient.fingerprint() != null) {
            hlc2.hint(Lang.s("Your key fingerprint. Friends see it next to your name: compare it to rule out tampering", "Отпечаток вашего ключа. Друзья видят его у вашего ника: сверьте, чтобы исключить подмену"));
        }
        if (bl3 || bl) {
            hlc2.hint(Lang.s("Copy the code and send it to a friend", "Скопировать код и отправить другу"));
        } else if (bl4) {
            hlc2.hint(bl5 ? Lang.s("Click again: the old code stops working", "Ещё раз: старый код перестанет работать") : Lang.s("New code (the old one stops working)", "Новый код (старый перестанет работать)"));
        }
        float f10 = f4 + 26.0f + 8.0f;
        String string2 = switch (PartyClient.status()) {
            case ucd.ONLINE -> {
                n = -11870592;
                yield (PartyClient.inParty() ? (PartyClient.secured() ? Lang.s("Encrypted  ·  party of ", "Зашифровано  ·  в пати ") + PartyClient.members().size() : Lang.s("Waiting for the party key", "Ждём ключ пати")) : Lang.s("Connected  ·  no party yet", "Подключено  ·  пати пока нет")) + Lang.s("  ·  key ", "  ·  ключ ") + PartyClient.fingerprint();
            }
            case ucd.CONNECTING -> {
                n = -340971;
                yield Lang.s("Connecting…", "Подключение…");
            }
            case ucd.RETRY -> {
                n = -429290;
                yield Lang.s("No connection, retrying", "Нет связи, повтор") + (PartyClient.lastError() != null ? "  ·  " + PartyClient.lastError() : "");
            }
            case ucd.REPLACED -> {
                n = -429290;
                yield Lang.s("Connected from another game", "Подключено из другой игры");
            }
            case ucd.NO_SERVER -> {
                n = Theme.textMuted;
                yield Lang.s("Set the party server below", "Укажите сервер пати ниже");
            }
            default -> {
                n = Theme.textMuted;
                yield Lang.s("Party is off", "Пати выключено");
            }
        };
        DrawUtil.circle(class_3322, this.x + 3.0f, f10, 1.8f, n);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string2, this.w - 12.0f), this.x + 8.0f, UiKit.SMALL.centerTop(f10), Theme.textDim);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float f3 = this.y + 4.0f + 13.0f;
        String string = PartyClient.prettyCode();
        if (UiKit.inside(f, f2, this.ikr(), f3 - 9.0f, 18.0f, 18.0f)) {
            if (string == null) {
                return true;
            }
            if (System.currentTimeMillis() < this.ikn) {
                this.ikn = 0L;
                PartyClient.newCode();
            } else {
                this.ikn = System.currentTimeMillis() + 2500L;
            }
            return true;
        }
        if (UiKit.inside(f, f2, this.x, this.y + 4.0f, this.ikr() - this.x - 2.0f, 26.0f)) {
            if (string == null) {
                hlc2.toast(Lang.s("No code yet: not connected", "Кода пока нет: нет связи"), Icon.INFO, true);
                return true;
            }
            class_310.method_1551().field_1774.method_1455(string);
            this.ikl.set(1.0f);
            hlc2.toast(Lang.s("Code copied: ", "Код скопирован: ") + string, Icon.COPY, false);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int agw(int n, int n2) {
        return n ^ n2 ^ 0xB6EA6526;
    }
}

