/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.imn;
import a.iog;
import a.iov;
import a.irr;
import a.ujt;
import a.uut;
import a.vcj;
import a.wap;
import flow.dev.a;
import java.awt.Color;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

final class htj
extends imn {
    private static final float htk = 16.0f;
    private static final float htl = 56.0f;
    private static final float htm = 80.0f;
    private static final float htn = 9.0f;
    private static final float hto = 6.0f;
    private static final float htp = 4.3f;
    private static final int htq = Math.max(iov.MENU_PAINTS.length, iov.HUD_PAINTS.length);
    private final vcj[] htr = new vcj[htq];
    private final vcj[] hts = new vcj[htq];
    private final vcj htt = new vcj(16.0f);
    private String htu = "";
    private int htv = -1;
    private float htw;
    private float htx;
    private float hty;
    private float htz = 1.0f;
    private int hua;
    private float hub;
    private static /* synthetic */ long huc;
    private static /* synthetic */ boolean hud;

    htj() {
        super(null);
        for (int i = 0; i < htq; ++i) {
            this.htr[i] = new vcj(16.0f);
            this.hts[i] = new vcj(13.0f);
        }
    }

    private static iog[] hue() {
        return iov.PAINT.is(a.c(-581939200, "\u504b\u29e7\ua325")) ? iov.HUD_PAINTS : iov.MENU_PAINTS;
    }

    @Override
    float height() {
        float f = 4.0f;
        iog[] iogArray = htj.hue();
        for (int i = 0; i < iogArray.length; ++i) {
            f += 16.0f + 80.0f * this.hts[i].get();
        }
        return f;
    }

    private float huf(int n) {
        float f = this.y + 2.0f;
        for (int i = 0; i < n; ++i) {
            f += 16.0f + 80.0f * this.hts[i].get();
        }
        return f;
    }

    private float hug(iog iog2) {
        return this.w - 15.0f * (iog2.hasAlpha() ? 2.0f : 1.0f);
    }

    private void huh() {
        if (!iov.PAINT.get().equals(this.htu)) {
            this.htu = iov.PAINT.get();
            this.htv = -1;
            this.hua = 0;
            for (vcj vcj2 : this.hts) {
                vcj2.set(0.0f);
            }
        }
    }

    private void hui(iog iog2, boolean bl) {
        int n = iov.paintColor(iog2);
        if (!bl && this.huj(iog2) == (iog2.hasAlpha() ? n : n | 0xFF000000)) {
            return;
        }
        if (!iog2.hud() && iog2.slot() == 0) {
            this.htw = (float)iov.BG_HUE.get();
            this.htx = (float)iov.BG_SATURATION.get();
            this.hty = (float)iov.BG_BRIGHTNESS.get();
            this.htz = 1.0f;
            return;
        }
        float[] fArray = Color.RGBtoHSB(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, null);
        if (fArray[1] > 0.001f && fArray[2] > 0.001f) {
            this.htw = fArray[0];
        }
        this.htx = fArray[1];
        this.hty = fArray[2];
        this.htz = iog2.hasAlpha() ? (float)ujt.alpha(n) / 255.0f : 1.0f;
    }

    private int huj(iog iog2) {
        return ujt.withAlpha(ujt.hsv(this.htw, this.htx, this.hty), iog2.hasAlpha() ? Math.round(this.htz * 255.0f) : 255);
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        this.huh();
        if (this.hua != 0 && !hlc2.isDragging(this)) {
            this.hua = 0;
        }
        iog[] iogArray = htj.hue();
        float f4 = this.y + 2.0f;
        for (int i = 0; i < iogArray.length; ++i) {
            iog iog2 = iogArray[i];
            float f5 = this.hts[i].step(i == this.htv, f3);
            boolean bl = hlc2.canHover() && irr.inside(f, f2, this.x - 3.0f, f4, this.w + 6.0f, 16.0f);
            float f6 = this.htr[i].step(bl, f3);
            this.huk(drawContext, iog2, f4, f6, f5);
            if (bl) {
                hlc2.hint(wap.t(iog2.name()) + wap.s(a.c(-1463685174, "\uefcc\u967d\u1c39\u82df\u0908\u8ffa\u35a6\ubc52\u2207\ua8be\u2f3c\ud557\u5bd0\uc278\u4821\uced8\u74dc\ufb0d\u6129\ue7ef\u6e18\u141b\u9ab3\u016c\u871c\u0dd1\ub436\u3a24\ua0dc\u2688\uad31\u53e8\ud9f6\u401d\uc62f\u4caa\uf37c\u7916"), a.c(-1440306620, "\uaa44\ud3f5\u59b1\uc757\u4c80\uce2b\u7479\ufd8b\u63d6\ued67\u6aae\u94cd\u1a63\u83a8\u098a\u8f0b\u3536\ubae9\u2436\ua267\u2b07\u51c1\udf72\u409c\uc6e6\u4c31\uf1a4\u7fef\ue108\u675b\uec98\u1235")));
            }
            f4 += 16.0f;
            if (!(f5 > 0.01f)) continue;
            float f7 = 80.0f * f5;
            if (i == this.htv) {
                uut.pushScissor(drawContext, this.x - 3.0f, f4, this.w + 6.0f, f7);
                uut.pushAlpha(Math.min(1.0f, f5 * 1.4f));
                if (this.hua == 0) {
                    this.hui(iog2, false);
                }
                this.hub = f4 + 4.0f;
                this.hun(drawContext, hlc2, iog2, f4 + 4.0f, f, f2, f3);
                uut.popAlpha();
                uut.popScissor(drawContext);
            }
            f4 += f7;
        }
    }

    private void huk(DrawContext drawContext, iog iog2, float f, float f2, float f3) {
        float f4 = f + 8.0f;
        float f5 = iov.r(4.0f);
        float f6 = Math.max(f2, f3 * 0.6f);
        if (f6 > 0.01f) {
            uut.round(drawContext, this.x - 3.0f, f + 0.5f, this.w + 6.0f, 15.0f, f5, ujt.withAlpha(iov.hover, Math.round((float)ujt.alpha(iov.hover) * 2.0f * f6)));
        }
        int n = iov.paintColor(iog2);
        htj.hul(drawContext, this.x + 4.3f + 1.0f, f4, 4.3f, n);
        irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(wap.t(iog2.name()), this.w * 0.62f), this.x + 8.6f + 7.0f, irr.LABEL.centerTop(f4), ujt.lerp(iov.textDim, iov.text, Math.max(f2, f3)));
        boolean bl = iov.isPainted(iog2);
        String string = bl ? htj.hum(n, iog2.hasAlpha()) : wap.value(a.d("\uc410\ubd95\u3747\ua92d", 482210418, -483510745));
        irr.SMALL.drawRight(drawContext, string, this.x + this.w, irr.SMALL.centerTop(f4), bl ? ujt.lerp(iov.textMuted, iov.textDim, 0.6f + 0.4f * f2) : iov.textMuted);
    }

    private static void hul(DrawContext drawContext, float f, float f2, float f3, int n) {
        if (ujt.alpha(n) < 250) {
            uut.round(drawContext, f - f3, f2 - f3, f3, f3 * 2.0f, f3, 0.0f, 0.0f, f3, -4934468);
            uut.round(drawContext, f, f2 - f3, f3, f3 * 2.0f, 0.0f, f3, f3, 0.0f, -13750732);
        }
        uut.circle(drawContext, f, f2, f3, n);
        uut.circleOutline(drawContext, f, f2, f3, 0.8f, ujt.withAlpha(iov.textMuted, 110));
    }

    private static String hum(int n, boolean bl) {
        String string = String.format(Locale.ROOT, a.b("\ubf31\uc686\u4c40\ud237\u598e", -788087017), n & 0xFFFFFF);
        int n2 = ujt.alpha(n);
        return bl && n2 < 255 ? string + a.c(-192320031, "\u6dc3\u1472") + Math.round((float)n2 / 2.55f) + a.b("\u8741", -1245083803) : string;
    }

    private void hun(DrawContext drawContext, hlc hlc2, iog iog2, float f, float f2, float f3, float f4) {
        int n;
        float f5 = this.htw;
        float f6 = this.htx;
        float f7 = this.hty;
        float f8 = this.htz;
        float f9 = this.hug(iog2);
        float f10 = iov.r(4.0f);
        int n2 = ujt.hsv(f5, 1.0f, 1.0f);
        uut.gradient(drawContext, this.x, f, f9, 56.0f, f10, -1, n2, -16777216, -16777216);
        uut.outline(drawContext, this.x, f, f9, 56.0f, f10, 1.0f, iov.stroke);
        float f11 = this.x + f6 * f9;
        float f12 = f + (1.0f - f7) * 56.0f;
        int n3 = ujt.hsv(f5, f6, f7);
        uut.shadow(drawContext, f11 - 3.5f, f12 - 3.5f, 7.0f, 7.0f, 3.5f, 2.0f, 0x60000000);
        uut.circle(drawContext, f11, f12, 3.5f, -1);
        uut.circle(drawContext, f11, f12, 2.3f, n3);
        float f13 = this.x + f9 + 6.0f;
        float f14 = 9.333333f;
        float f15 = 4.5f;
        uut.gradientV(drawContext, f13, f, 9.0f, f14 + f15, f15, ujt.hsv(0.0f, 1.0f, 1.0f), ujt.hsv((f14 + f15) / 56.0f, 1.0f, 1.0f));
        uut.gradientV(drawContext, f13, f + 56.0f - f14 - f15, 9.0f, f14 + f15, f15, ujt.hsv((56.0f - f14 - f15) / 56.0f, 1.0f, 1.0f), ujt.hsv(1.0f, 1.0f, 1.0f));
        for (int i = 1; i < 5; ++i) {
            uut.gradientV(drawContext, f13, f + f14 * (float)i, 9.0f, f14, 0.0f, ujt.hsv((float)i / 6.0f, 1.0f, 1.0f), ujt.hsv((float)(i + 1) / 6.0f, 1.0f, 1.0f));
        }
        htj.huo(drawContext, f13, f + f5 * 56.0f);
        if (iog2.hasAlpha()) {
            float f16 = f13 + 9.0f + 6.0f;
            uut.pushScissor(drawContext, f16, f, 9.0f, 56.0f);
            float f17 = 4.5f;
            n = 0;
            while ((float)n * f17 < 56.0f) {
                for (int i = 0; i < 2; ++i) {
                    uut.rect(drawContext, f16 + (float)i * f17, f + (float)n * f17, f17, Math.min(f17, 56.0f - (float)n * f17), (n + i) % 2 == 0 ? -1644822 : -6645086);
                }
                ++n;
            }
            uut.popScissor(drawContext);
            uut.gradientV(drawContext, f16, f, 9.0f, 56.0f, 0.0f, n3, ujt.withAlpha(n3, 0));
            uut.outline(drawContext, f16, f, 9.0f, 56.0f, Math.min(f15, iov.r(3.0f)), 1.0f, iov.stroke);
            htj.huo(drawContext, f16, f + (1.0f - f8) * 56.0f);
        }
        float f18 = f + 56.0f + 10.0f;
        int n4 = ujt.withAlpha(n3, iog2.hasAlpha() ? Math.round(f8 * 255.0f) : 255);
        htj.hul(drawContext, this.x + 4.0f, f18, 3.5f, n4);
        irr.VALUE.draw(drawContext, htj.hum(n4, iog2.hasAlpha()), this.x + 11.0f, irr.VALUE.centerTop(f18), iov.textDim);
        int n5 = n = !iog2.hud() && iog2.slot() == 0 ? 1 : 0;
        if (n != 0 || iov.isPainted(iog2)) {
            String string = n != 0 ? wap.s(a.d("\u75a5\u0c35\u86e5\u1893\u9350\u15f8\uafb3", -1402659237, 1108634557), a.d("\u7d97\u0407\u8aca\u10d8\u9b70\u1dc3\ua795\u2e18\ub030\u3a8c\ubd5a\u475d", 2025431381, 1998182609)) : wap.value(a.b("\uea85\u9300\u19d2\u87b8", -2113606976));
            float f19 = Math.max(16.0f, irr.SMALL.width(string) + 9.0f);
            float f20 = this.htt.step(hlc2.canHover() && irr.inside(f2, f3, this.x + this.w - f19, f18 - 5.5f, f19, 11.0f), f4);
            irr.drawChip(drawContext, string, this.x + this.w, f18, ujt.lerp(iov.textDim, iov.text, f20), ujt.lerp(iov.stroke, iov.accent(150), f20), f20);
        }
    }

    private static void huo(DrawContext drawContext, float f, float f2) {
        uut.shadow(drawContext, f - 1.5f, f2 - 2.0f, 12.0f, 4.0f, 2.0f, 2.0f, 0x60000000);
        uut.outline(drawContext, f - 1.5f, f2 - 2.0f, 12.0f, 4.0f, 2.0f, 1.3f, -1);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        iog[] iogArray = htj.hue();
        for (int i = 0; i < iogArray.length; ++i) {
            iog iog2 = iogArray[i];
            float f3 = this.huf(i);
            if (irr.inside(f, f2, this.x - 3.0f, f3, this.w + 6.0f, 16.0f)) {
                if (n == 1) {
                    iov.clearPaint(iog2);
                    if (i == this.htv) {
                        this.hui(iog2, true);
                    }
                    return true;
                }
                if (n != 0) {
                    return false;
                }
                int n2 = this.htv = this.htv == i ? -1 : i;
                if (this.htv == i) {
                    this.hui(iog2, true);
                }
                return true;
            }
            if (i != this.htv || !(this.hts[i].get() > 0.9f) || n != 0 || !this.hup(hlc2, iog2, f3 + 16.0f + 4.0f, f, f2)) continue;
            return true;
        }
        return false;
    }

    private boolean hup(hlc hlc2, iog iog2, float f, float f2, float f3) {
        float f4 = this.hug(iog2);
        float f5 = this.x + f4 + 6.0f;
        this.hub = f;
        if (irr.inside(f2, f3, this.x - 2.0f, f - 2.0f, f4 + 4.0f, 60.0f)) {
            this.hua = 1;
        } else if (irr.inside(f2, f3, f5 - 3.0f, f - 3.0f, 15.0f, 62.0f)) {
            this.hua = 2;
        } else if (iog2.hasAlpha() && irr.inside(f2, f3, f5 + 9.0f + 6.0f - 3.0f, f - 3.0f, 15.0f, 62.0f)) {
            this.hua = 3;
        } else {
            float f6 = f + 56.0f + 10.0f;
            boolean bl = !iog2.hud() && iog2.slot() == 0;
            String string = bl ? wap.s(a.b("\u4c61\u35f1\ubf21\u2157\uaa94\u2c3c\u9677", 395856930), a.c(-1832929640, "\ub28b\ucb1b\u45d6\udfc4\u546c\ud2df\u6889\ue104\u7f2c\uf590\u7246\u8841")) : wap.value(a.b("\u0ae6\u7363\uf9b1\u67db", -1071904093));
            float f7 = Math.max(16.0f, irr.SMALL.width(string) + 9.0f);
            if ((bl || iov.isPainted(iog2)) && irr.inside(f2, f3, this.x + this.w - f7, f6 - 5.5f, f7, 11.0f)) {
                iov.clearPaint(iog2);
                this.hui(iog2, true);
                return true;
            }
            return false;
        }
        hlc2.startDrag(this);
        this.mouseDragged(f2, f3);
        return true;
    }

    @Override
    void mouseDragged(float f, float f2) {
        iog[] iogArray = htj.hue();
        if (this.htv < 0 || this.htv >= iogArray.length || this.hua == 0) {
            return;
        }
        iog iog2 = iogArray[this.htv];
        float f3 = htj.huq((f2 - this.hub) / 56.0f);
        switch (this.hua) {
            case 1: {
                this.htx = htj.huq((f - this.x) / this.hug(iog2));
                this.hty = 1.0f - f3;
                break;
            }
            case 2: {
                this.htw = Math.min(0.999f, f3);
                break;
            }
            default: {
                this.htz = 1.0f - f3;
            }
        }
        if (this.hua != 3 && iog2.hasAlpha() && !iov.isPainted(iog2) && this.htz < 0.35f) {
            this.htz = 1.0f;
        }
        iov.setPaint(iog2, this.huj(iog2), this.htw, this.htx, this.hty);
    }

    private static float huq(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private static /* synthetic */ int aci(int n, int n2) {
        return n * n2 ^ 0x2EB7BC00;
    }

    private static /* synthetic */ int acj(int n, int n2) {
        return n + n2 ^ 0xF8706BF1;
    }

    private static /* synthetic */ int ack(int n, int n2) {
        return n * n2 + 1347130580;
    }
}

