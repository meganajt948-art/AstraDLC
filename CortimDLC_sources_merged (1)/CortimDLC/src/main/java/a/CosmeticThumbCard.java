/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.AssetPaths;
import a.ClickGuiScreen;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.GpuTexture;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.StringDecryptor;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.class_332;

final class CosmeticThumbCard
extends Widget {
    private static final float hws = 58.0f;
    private static final float hwt = 6.0f;
    private static final float hwu = 12.0f;
    private static final Map<String, GpuTexture> hwv = new HashMap<String, GpuTexture>();
    private static final Set<String> hww = new HashSet<String>();
    private final String hwx;
    private final List<Spring> hwy = new ArrayList<Spring>();
    private final List<Spring> hwz = new ArrayList<Spring>();
    private static /* synthetic */ long hxa;
    private static /* synthetic */ long hxb;

    CosmeticThumbCard(String string) {
        super(null);
        this.hwx = string;
    }

    private List<CosmeticItem> hxc() {
        List<CosmeticItem> list = Cosmetics.ofSlot(this.hwx);
        while (this.hwy.size() < list.size()) {
            this.hwy.add(new Spring(16.0f));
            this.hwz.add(new Spring(14.0f));
        }
        return list;
    }

    private int hxd() {
        float f = this.w > 0.0f ? this.w : 376.0f;
        return Math.max(3, (int)((f + 6.0f) / 64.0f));
    }

    private float hxe() {
        int n = this.hxd();
        return (this.w - 6.0f * (float)(n - 1)) / (float)n;
    }

    private int hxf() {
        return Math.max(1, (this.hxc().size() + this.hxd() - 1) / this.hxd());
    }

    @Override
    float height() {
        float f = this.w > 0.0f ? this.hxe() : 58.0f;
        return 3.0f + (float)this.hxf() * (f + 12.0f) + (float)(this.hxf() - 1) * 6.0f;
    }

    private float hxg(int n) {
        return this.x + (float)(n % this.hxd()) * (this.hxe() + 6.0f);
    }

    private float hxh(int n) {
        return this.y + 3.0f + (float)(n / this.hxd()) * (this.hxe() + 12.0f + 6.0f);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static GpuTexture thumb(String string) {
        GpuTexture uok3 = hwv.get(string);
        if (uok3 != null) return uok3;
        if (hww.contains(string)) {
            return uok3;
        }
        try (InputStream inputStream = AssetPaths.open("/flow/cosmetics/thumbs/" + string + ".png");){
            BufferedImage bufferedImage;
            BufferedImage bufferedImage2 = bufferedImage = inputStream == null ? null : ImageIO.read(inputStream);
            if (bufferedImage == null) {
                hww.add(string);
                GpuTexture uok4 = null;
                return uok4;
            }
            uok3 = GpuTexture.upload("cosmetic thumb " + string, bufferedImage, false, true);
            hwv.put(string, uok3);
            GpuTexture uok2 = uok3;
            return uok2;
        }
        catch (Exception exception) {
            hww.add(string);
            return null;
        }
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<CosmeticItem> list = this.hxc();
        float f4 = this.hxe();
        float f5 = Theme.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            float f6;
            CosmeticItem cosmeticItem = list.get(i);
            float f7 = this.hxg(i);
            float f8 = this.hxh(i);
            boolean bl = hlc2.canHover() && UiKit.inside(f, f2, f7, f8, f4, f4 + 12.0f);
            float f9 = this.hwy.get(i).step(bl, f3);
            float f10 = this.hwz.get(i).step(Cosmetics.isWorn(cosmeticItem), f3);
            float f11 = f8 - f9;
            if (bl) {
                hlc2.hint(cosmeticItem.title() + "  ·  " + cosmeticItem.about());
            }
            int n = cosmeticItem.accent | 0xFF000000;
            if (f10 > 0.01f) {
                DrawUtil.shadow(class_3322, f7, f11, f4, f4, f5, 8.0f, ColorUtil.withAlpha(n, (int)(90.0f * f10)));
            }
            DrawUtil.round(class_3322, f7, f11, f4, f4, f5, ColorUtil.lerp(Theme.field, ColorUtil.lerp(Theme.field, n, 0.18f), Math.max(f10, f9 * 0.5f)));
            GpuTexture uok2 = CosmeticThumbCard.thumb(cosmeticItem.id);
            if (uok2 != null) {
                f6 = 2.0f;
                DrawUtil.image(class_3322, uok2.view, f7 + f6, f11 + f6, f4 - f6 * 2.0f, f4 - f6 * 2.0f, f5, -1);
            } else {
                IconRenderer.draw(class_3322, Icon.CROWN, f7 + f4 * 0.5f, f11 + f4 * 0.5f, 11.0f, Theme.textMuted);
            }
            DrawUtil.outline(class_3322, f7, f11, f4, f4, f5, 1.0f, ColorUtil.lerp(ColorUtil.lerp(Theme.stroke, Theme.textMuted, f9 * 0.5f), n, f10));
            if (f10 > 0.02f) {
                f6 = f7 + f4 - 6.0f;
                float f12 = f11 + 6.0f;
                float f13 = Easing.outBack(f10);
                DrawUtil.pushAlpha(f10);
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f6, f12);
                class_3322.method_51448().scale(f13, f13);
                DrawUtil.circle(class_3322, 0.0f, 0.0f, 4.0f, n);
                IconRenderer.draw(class_3322, Icon.CHECK, 0.0f, 0.0f, 5.5f, -16052972);
                class_3322.method_51448().popMatrix();
                DrawUtil.popAlpha();
            }
            UiKit.SMALL.drawCentered(class_3322, UiKit.SMALL.ellipsize(cosmeticItem.title(), f4), f7 + f4 * 0.5f, UiKit.SMALL.centerTop(f8 + f4 + 6.0f + 1.0f), ColorUtil.lerp(ColorUtil.lerp(Theme.textMuted, Theme.textDim, f9), Theme.text, f10));
        }
        if (list.isEmpty()) {
            UiKit.SMALL.draw(class_3322, Lang.s("Nothing here yet", "Пока пусто"), this.x, UiKit.SMALL.centerTop(this.y + 12.0f), Theme.textMuted);
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        List<CosmeticItem> list = this.hxc();
        float f3 = this.hxe();
        for (int i = 0; i < list.size(); ++i) {
            if (!UiKit.inside(f, f2, this.hxg(i), this.hxh(i), f3, f3 + 12.0f)) continue;
            Cosmetics.toggle(list.get(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int adc(int n, int n2) {
        return n - n2 ^ 0x18755471;
    }

    private static /* synthetic */ int add(int n, int n2) {
        return CosmeticThumbCard.adc(n, n2) * n2;
    }

    private static /* synthetic */ int ade(int n, int n2) {
        return CosmeticThumbCard.adc(n, n2) * n2;
    }
}

