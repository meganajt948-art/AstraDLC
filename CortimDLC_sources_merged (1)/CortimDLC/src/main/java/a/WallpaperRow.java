/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.isn;
import a.WallpaperManager;
import a.ColorUtil;
import a.GpuTexture;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_332;

final class WallpaperRow
extends Widget {
    private static final float irw = 54.0f;
    private static final float irx = 6.0f;
    private static final float iry = 10.0f;
    private final List<Spring> irz = new ArrayList<Spring>();
    private final List<Spring> isa = new ArrayList<Spring>();
    private static /* synthetic */ int isb;
    private static /* synthetic */ int isc;

    WallpaperRow() {
        super(null);
    }

    private List<isn> isd() {
        List<isn> list = WallpaperManager.entries();
        while (this.irz.size() < list.size()) {
            this.irz.add(new Spring(16.0f));
            this.isa.add(new Spring(14.0f));
        }
        return list;
    }

    private int ise() {
        float f = this.w > 0.0f ? this.w : 376.0f;
        return Math.max(3, (int)((f + 6.0f) / 60.0f));
    }

    private float isf() {
        int n = this.ise();
        return (this.w - 6.0f * (float)(n - 1)) / (float)n;
    }

    private float isg() {
        return this.isf() * 9.0f / 16.0f;
    }

    private int ish() {
        return (this.isd().size() + this.ise() - 1) / this.ise();
    }

    @Override
    float height() {
        float f = this.w > 0.0f ? this.isf() : 54.0f;
        float f2 = f * 9.0f / 16.0f + 10.0f;
        return 3.0f + (float)this.ish() * f2 + (float)(this.ish() - 1) * 6.0f;
    }

    private float isi(int n) {
        return this.x + (float)(n % this.ise()) * (this.isf() + 6.0f);
    }

    private float isj(int n) {
        return this.y + 3.0f + (float)(n / this.ise()) * (this.isg() + 10.0f + 6.0f);
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<isn> list = this.isd();
        float f4 = this.isf();
        float f5 = this.isg();
        float f6 = Theme.r(5.0f);
        for (int i = 0; i < list.size(); ++i) {
            isn isn2 = list.get(i);
            float f7 = this.isi(i);
            float f8 = this.isj(i);
            boolean bl = hlc2.canHover() && UiKit.inside(f, f2, f7, f8, f4, f5 + 10.0f);
            float f9 = this.irz.get(i).step(bl, f3);
            float f10 = this.isa.get(i).step(isn2.key.equals(WallpaperManager.selected()), f3);
            float f11 = f8 - f9;
            if (bl) {
                hlc2.hint(isn2.isWorld() ? Lang.s("No wallpaper — the game world behind the menu", "Без обоев — за меню виден мир игры") : WallpaperManager.label(isn2) + (isn2.isLive() ? Lang.s("  ·  animated sky", "  ·  живое небо") : (isn2.isVideo() ? Lang.s("  ·  video", "  ·  видео") : (isn2.isUser() ? Lang.s("  ·  your image", "  ·  ваша картинка") : Lang.s("  ·  built-in", "  ·  встроенная")))));
            }
            if (f10 > 0.01f) {
                DrawUtil.shadow(class_3322, f7, f11, f4, f5, f6, 7.0f, Theme.accent((int)(70.0f * f10)));
            }
            if (isn2.isWorld()) {
                DrawUtil.gradient(class_3322, f7, f11, f4, f5, f6, -12882264, -8408864, -9728178, -13280722);
                IconRenderer.draw(class_3322, Icon.GLOBE, f7 + f4 * 0.5f, f11 + f5 * 0.5f, 11.0f, -419430401);
            } else {
                GpuTexture uok2 = WallpaperManager.thumbnail(isn2);
                if (uok2 != null) {
                    DrawUtil.image(class_3322, uok2.view, f7, f11, f4, f5, f6, -1);
                } else {
                    DrawUtil.round(class_3322, f7, f11, f4, f5, f6, Theme.field);
                    IconRenderer.draw(class_3322, Icon.IMAGE, f7 + f4 * 0.5f, f11 + f5 * 0.5f, 10.0f, isn2.failed ? -1750963 : Theme.textMuted);
                }
            }
            if (isn2.isLive() || isn2.isVideo()) {
                DrawUtil.circle(class_3322, f7 + 6.0f, f11 + f5 - 6.0f, 3.6f, -1728053248);
                IconRenderer.draw(class_3322, Icon.PLAY, f7 + 6.2f, f11 + f5 - 6.0f, 4.6f, -218103809);
            }
            DrawUtil.outline(class_3322, f7, f11, f4, f5, f6, 1.0f, ColorUtil.lerp(ColorUtil.lerp(Theme.stroke, Theme.textMuted, f9 * 0.5f), Theme.accent(), f10));
            if (f10 > 0.02f) {
                float f12 = f7 + f4 - 5.5f;
                float f13 = f11 + 5.5f;
                float f14 = Easing.outBack(f10);
                DrawUtil.pushAlpha(f10);
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f12, f13);
                class_3322.method_51448().scale(f14, f14);
                DrawUtil.circle(class_3322, 0.0f, 0.0f, 3.8f, Theme.accent());
                IconRenderer.draw(class_3322, Icon.CHECK, 0.0f, 0.0f, 5.5f, Theme.onAccent());
                class_3322.method_51448().popMatrix();
                DrawUtil.popAlpha();
            }
            UiKit.SMALL.drawCentered(class_3322, UiKit.SMALL.ellipsize(WallpaperManager.label(isn2), f4), f7 + f4 * 0.5f, UiKit.SMALL.centerTop(f8 + f5 + 5.0f + 1.0f), ColorUtil.lerp(ColorUtil.lerp(Theme.textMuted, Theme.textDim, f9), Theme.text, f10));
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        List<isn> list = this.isd();
        float f3 = this.isf();
        float f4 = this.isg();
        for (int i = 0; i < list.size(); ++i) {
            if (!UiKit.inside(f, f2, this.isi(i), this.isj(i), f3, f4 + 10.0f)) continue;
            WallpaperManager.select(list.get((int)i).key);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int ajf(int n, int n2) {
        return n * n2 + 894134942;
    }

    private static /* synthetic */ int ajg(int n, int n2) {
        return WallpaperRow.ajf(n, n2) * n2;
    }

    private static /* synthetic */ int ajh(int n, int n2) {
        return n + n2 + 448513735;
    }
}

