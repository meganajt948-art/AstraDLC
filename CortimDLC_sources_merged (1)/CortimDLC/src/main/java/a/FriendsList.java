/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_8685
 */
package a;

import a.hhc;
import a.Friends;
import a.ClickGuiScreen;
import a.hyg;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.GlassDraw;
import a.PlayerHeadDraw;
import a.DrawUtil;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_8685;

final class FriendsList
extends Widget {
    private static final float hyk = 26.0f;
    private static final float hyl = 3.0f;
    private static final float hym = 16.0f;
    private static final float hyn = 18.0f;
    static final int HERE = -11870592;
    private final Map<String, hyg> hyo = new HashMap<String, hyg>();
    private String hyp;
    private long hyq;
    private static /* synthetic */ int hyr;
    private static /* synthetic */ String hys;

    FriendsList() {
        super(null);
    }

    @Override
    float height() {
        int n = Friends.all().size();
        return n == 0 ? 58.0f : 2.0f + (float)n * 29.0f;
    }

    private float hyt(int n) {
        return this.y + 2.0f + (float)n * 29.0f;
    }

    private float hyu() {
        return this.x + this.w - 6.0f - 18.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<hhc> list = Friends.all();
        if (list.isEmpty()) {
            this.hyo.clear();
            float f4 = this.x + this.w * 0.5f;
            DrawUtil.circle(class_3322, f4, this.y + 17.0f, 12.0f, Theme.hover);
            IconRenderer.draw(class_3322, Icon.FRIENDS, f4, this.y + 17.0f, 11.0f, Theme.textMuted);
            UiKit.LABEL.drawCentered(class_3322, Lang.s("No friends yet", "Друзей пока нет"), f4, UiKit.LABEL.centerTop(this.y + 38.0f), Theme.textDim);
            UiKit.SMALL.drawCentered(class_3322, Lang.s("Middle click a player, or add a name", "СКМ по игроку или добавьте ник"), f4, UiKit.SMALL.centerTop(this.y + 49.0f), Theme.textMuted);
            return;
        }
        if (this.hyp != null && System.currentTimeMillis() > this.hyq) {
            this.hyp = null;
        }
        class_310 class_3102 = class_310.method_1551();
        float f5 = Theme.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            int n;
            String string2;
            hhc hhc2 = list.get(i);
            String string3 = hhc2.name.toLowerCase(Locale.ROOT);
            hyg hyg2 = this.hyo.computeIfAbsent(string3, string -> new hyg());
            float f6 = this.hyt(i);
            float f7 = Easing.outCubic(hyg2.appear.step(1.0f, f3));
            boolean bl = hlc2.canHover() && UiKit.inside(f, f2, this.x, f6, this.w, 26.0f);
            float f8 = hyg2.hover.step(bl, f3);
            DrawUtil.pushAlpha(f7);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate((1.0f - f7) * 18.0f, 0.0f);
            DrawUtil.round(class_3322, this.x, f6, this.w, 26.0f, f5, ColorUtil.withAlpha(Theme.hover, (int)((float)ColorUtil.alpha(Theme.hover) * (0.6f + 1.4f * f8))));
            float f9 = f6 + 13.0f;
            class_1657 class_16572 = Friends.inWorld(hhc2.name);
            boolean bl2 = class_16572 != null || Friends.listEntry(hhc2.name) != null;
            FriendsList.face(class_3322, hhc2.name, Friends.skinOf(hhc2.name), this.x + 5.0f, f9 - 8.0f, bl2);
            float f10 = this.x + 5.0f + 16.0f + 7.0f;
            float f11 = this.hyu() - f10 - 4.0f;
            UiKit.CARD_TITLE.draw(class_3322, UiKit.CARD_TITLE.ellipsize(hhc2.name, f11), f10, UiKit.CARD_TITLE.centerTop(f9 - 4.0f), Theme.text);
            if (class_16572 != null && class_3102.field_1724 != null) {
                double d = Math.sqrt(class_3102.field_1724.method_5858((class_1297)class_16572));
                string2 = class_16572 == class_3102.field_1724 ? Lang.s("You", "Вы") : Lang.s("Here  ·  ", "Рядом  ·  ") + Math.round(d) + Lang.unit("m");
                n = -11870592;
            } else if (bl2) {
                string2 = Lang.s("Online", "В сети");
                n = ColorUtil.lerp(-11870592, Theme.textDim, 0.4f);
            } else {
                string2 = Lang.s("Not here", "Не здесь");
                n = Theme.textMuted;
            }
            DrawUtil.circle(class_3322, f10 + 1.6f, f9 + 5.0f, 1.6f, n);
            UiKit.SMALL.draw(class_3322, string2, f10 + 5.5f, UiKit.SMALL.centerTop(f9 + 5.0f), n);
            boolean bl3 = string3.equals(this.hyp);
            float f12 = this.hyu() + (1.0f - f8) * 6.0f;
            boolean bl4 = hlc2.canHover() && UiKit.inside(f, f2, f12, f9 - 9.0f, 18.0f, 18.0f);
            float f13 = hyg2.button.step(bl4, f3);
            UiKit.iconButton(class_3322, Icon.TRASH, f12, f9 - 9.0f, 18.0f, f13, bl3, bl3 ? 1.0f : f8);
            if (bl4 && f8 > 0.5f) {
                hlc2.hint(bl3 ? Lang.s("Click again to remove ", "Нажмите ещё раз, чтобы удалить ") + hhc2.name : Lang.s("Remove from friends", "Удалить из друзей"));
            }
            class_3322.method_51448().popMatrix();
            DrawUtil.popAlpha();
        }
    }

    static void face(class_332 class_3322, String string, class_8685 class_86852, float f, float f2, boolean bl) {
        boolean bl2;
        float f3 = Math.min(8.0f, Theme.r(4.5f));
        GlassDraw.shadow(class_3322, f, f2, 16.0f, 16.0f, f3, 0.5f, Theme.lightness());
        boolean bl3 = class_86852 != null && PlayerHeadDraw.draw(class_3322, class_86852, f, f2, 16.0f, f3, bl ? -1 : -6645086) ? true : (bl2 = false);
        if (!bl2) {
            DrawUtil.round(class_3322, f, f2, 16.0f, 16.0f, f3, Theme.field);
            UiKit.AVATAR.drawCentered(class_3322, string.substring(0, 1).toUpperCase(Locale.ROOT), f + 8.0f, UiKit.AVATAR.centerTop(f2 + 8.0f), Theme.textDim);
        }
        DrawUtil.outlineGradientV(class_3322, f, f2, 16.0f, 16.0f, f3, 1.0f, 0x34FFFFFF, 0x8FFFFFF);
        if (bl) {
            float f4 = 5.0f;
            DrawUtil.circle(class_3322, f + 16.0f - 1.0f, f2 + 16.0f - 1.0f, f4 * 0.5f + 1.0f, Theme.card | 0xFF000000);
            DrawUtil.circle(class_3322, f + 16.0f - 1.0f, f2 + 16.0f - 1.0f, f4 * 0.5f, -11870592);
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        List<hhc> list = Friends.all();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.hyt(i);
            if (!UiKit.inside(f, f2, this.x, f3, this.w, 26.0f)) continue;
            hhc hhc2 = list.get(i);
            String string = hhc2.name.toLowerCase(Locale.ROOT);
            float f4 = f3 + 13.0f;
            if (n == 0 && UiKit.inside(f, f2, this.hyu(), f4 - 9.0f, 18.0f, 18.0f)) {
                if (!string.equals(this.hyp)) {
                    this.hyp = string;
                    this.hyq = System.currentTimeMillis() + 2500L;
                } else {
                    this.hyp = null;
                    String string2 = hhc2.name;
                    Friends.remove(string2);
                    hlc2.toast(Lang.s("Removed ", "Удалён ") + string2, Icon.TRASH, false);
                }
            }
            return true;
        }
        return false;
    }

    private static /* synthetic */ int adt(int n, int n2) {
        return n - n2 ^ 0xD08A4710;
    }

    private static /* synthetic */ int adu(int n, int n2) {
        return FriendsList.adt(n, n2) ^ 0xE5B8F4A2;
    }
}

