/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.ezj;
import a.hlc;
import a.imn;
import a.iov;
import a.irr;
import a.ujt;
import a.uok;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.client.gui.DrawContext;

final class hwr
extends imn {
    private static final float hws = 58.0f;
    private static final float hwt = 6.0f;
    private static final float hwu = 12.0f;
    private static final Map<String, uok> hwv = new HashMap<String, uok>();
    private static final Set<String> hww = new HashSet<String>();
    private final String hwx;
    private final List<vcj> hwy = new ArrayList<vcj>();
    private final List<vcj> hwz = new ArrayList<vcj>();
    private static /* synthetic */ long hxa;
    private static /* synthetic */ long hxb;

    hwr(String string) {
        super(null);
        this.hwx = string;
    }

    private List<CosmeticItem> hxc() {
        List<CosmeticItem> list = Cosmetics.ofSlot(this.hwx);
        while (this.hwy.size() < list.size()) {
            this.hwy.add(new vcj(16.0f));
            this.hwz.add(new vcj(14.0f));
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
    static uok thumb(String string) {
        uok uok3 = hwv.get(string);
        if (uok3 != null) return uok3;
        if (hww.contains(string)) {
            return uok3;
        }
        try (InputStream inputStream = ezj.open(a.c(641356438, "\u52ae\u2b56\ua18f\u3ffd\ub432\u32db\u88c4\u0139\u9f7a\u15d5\u920e\u686e\ue6a4\u7f1f\uf55c\u73f1\uc9e5\u4628\udc86\u5acf\ud337\ua977\u2798") + string + a.b("\u28e0\u510f\udbc2\u45ba", 1931487434));){
            BufferedImage bufferedImage;
            BufferedImage bufferedImage2 = bufferedImage = inputStream == null ? null : ImageIO.read(inputStream);
            if (bufferedImage == null) {
                hww.add(string);
                uok uok4 = null;
                return uok4;
            }
            uok3 = uok.upload(a.b("\ud6d6\uaf6b\u25a4\ubbcb\u3014\ub6b4\u0cfa\u8501\u1b1d\u91f8\u1637\uec5b\u6294\ufb2a\u713b", -636430662) + string, bufferedImage, false, true);
            hwv.put(string, uok3);
            uok uok2 = uok3;
            return uok2;
        }
        catch (Exception exception) {
            hww.add(string);
            return null;
        }
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<CosmeticItem> list = this.hxc();
        float f4 = this.hxe();
        float f5 = iov.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            float f6;
            CosmeticItem cosmeticItem = list.get(i);
            float f7 = this.hxg(i);
            float f8 = this.hxh(i);
            boolean bl = hlc2.canHover() && irr.inside(f, f2, f7, f8, f4, f4 + 12.0f);
            float f9 = this.hwy.get(i).step(bl, f3);
            float f10 = this.hwz.get(i).step(Cosmetics.isWorn(cosmeticItem), f3);
            float f11 = f8 - f9;
            if (bl) {
                hlc2.hint(cosmeticItem.title() + a.b("\u6d51\u14e0\u9ea4B\u8b95", 2105961844) + cosmeticItem.about());
            }
            int n = cosmeticItem.accent | 0xFF000000;
            if (f10 > 0.01f) {
                uut.shadow(drawContext, f7, f11, f4, f4, f5, 8.0f, ujt.withAlpha(n, (int)(90.0f * f10)));
            }
            uut.round(drawContext, f7, f11, f4, f4, f5, ujt.lerp(iov.field, ujt.lerp(iov.field, n, 0.18f), Math.max(f10, f9 * 0.5f)));
            uok uok2 = hwr.thumb(cosmeticItem.id);
            if (uok2 != null) {
                f6 = 2.0f;
                uut.image(drawContext, uok2.view, f7 + f6, f11 + f6, f4 - f6 * 2.0f, f4 - f6 * 2.0f, f5, -1);
            } else {
                vjf.draw(drawContext, vhz.CROWN, f7 + f4 * 0.5f, f11 + f4 * 0.5f, 11.0f, iov.textMuted);
            }
            uut.outline(drawContext, f7, f11, f4, f4, f5, 1.0f, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, f9 * 0.5f), n, f10));
            if (f10 > 0.02f) {
                f6 = f7 + f4 - 6.0f;
                float f12 = f11 + 6.0f;
                float f13 = vcq.outBack(f10);
                uut.pushAlpha(f10);
                drawContext.method_51448().pushMatrix();
                drawContext.method_51448().translate(f6, f12);
                drawContext.method_51448().scale(f13, f13);
                uut.circle(drawContext, 0.0f, 0.0f, 4.0f, n);
                vjf.draw(drawContext, vhz.CHECK, 0.0f, 0.0f, 5.5f, -16052972);
                drawContext.method_51448().popMatrix();
                uut.popAlpha();
            }
            irr.SMALL.drawCentered(drawContext, irr.SMALL.ellipsize(cosmeticItem.title(), f4), f7 + f4 * 0.5f, irr.SMALL.centerTop(f8 + f4 + 6.0f + 1.0f), ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, f9), iov.text, f10));
        }
        if (list.isEmpty()) {
            irr.SMALL.draw(drawContext, wap.s(a.b("\u6c00\u1590\u9f58\u0135\u8ae3\u0c55\ub60f\u3fb9\ua1ae\u2b12\uacd6\u56b0\ud822\u41ca\ucb85\u4d65", -1540789154), a.b("\u7bfe\u026e\u88b9\u16c2\u9905\u1bab\ua184\u2877\ub62b\u3ce6", -1516339221)), this.x, irr.SMALL.centerTop(this.y + 12.0f), iov.textMuted);
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        List<CosmeticItem> list = this.hxc();
        float f3 = this.hxe();
        for (int i = 0; i < list.size(); ++i) {
            if (!irr.inside(f, f2, this.hxg(i), this.hxh(i), f3, f3 + 12.0f)) continue;
            Cosmetics.toggle(list.get(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int adc(int n, int n2) {
        return n - n2 ^ 0x18755471;
    }

    private static /* synthetic */ int add(int n, int n2) {
        return hwr.adc(n, n2) * n2;
    }

    private static /* synthetic */ int ade(int n, int n2) {
        return hwr.adc(n, n2) * n2;
    }
}

