/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.hyv;
import a.imn;
import a.iov;
import a.irk;
import a.irr;
import a.kfe;
import a.ujt;
import a.ukf;
import a.uut;
import a.vcj;
import a.vdn;
import a.veo;
import a.vhz;
import a.vjf;
import a.vkl;
import a.vmo;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class hjg {
    private static final float hjh = 10.0f;
    private static final float hji = 27.0f;
    private static final vdn hjj;
    private static final String hjk;
    private static final int hjl = -14003;
    private static final int hjm = -1013204;
    private static final int hjn = -14018301;
    private static final boolean hjo;
    final kfe module;
    final String title;
    private final String hjp;
    final List<imn> rows = new ArrayList<imn>();
    private vkl hjq;
    private final irk hjr;
    private final vcj hjs = new vcj(14.0f);
    private final vcj hjt;
    private final vcj hju = new vcj(13.0f, 1.0f);
    private final vcj hjv = new vcj(16.0f);
    private final vcj hjw = new vcj(14.0f);
    private final vcj hjx = new vcj(7.0f);
    private boolean hjy;
    private float hjz;
    private float hka;
    float x;
    float y;
    float w;
    int column;
    int home = -1;
    boolean wide;
    private static /* synthetic */ long hkb;
    private static /* synthetic */ int hkc;

    hjg(kfe kfe2) {
        this.module = kfe2;
        this.title = kfe2.getDisplayName();
        this.hjp = null;
        this.hjt = new vcj(12.0f, kfe2.isEnabled() ? 1.0f : 0.0f);
        this.hjr = kfe2.isLocked() ? null : new irk(kfe2.getDisplayName(), kfe2::getKey, kfe2::setKey, true);
        this.settings(kfe2.getSettings());
        this.hjy = !this.rows.isEmpty();
        this.hju.set(this.hjy ? 0.0f : 1.0f);
    }

    String shownTitle() {
        return this.module != null ? this.title : wap.t(this.title);
    }

    String description() {
        String string = wap.t(this.module != null ? this.module.getDescription() : (this.hjp != null ? this.hjp : ""));
        if (this.hkg()) {
            return wap.s(a.c(546961610, "\uf88c\u8106\u0bdf\u95af\u1e6f\u988c\u2292\uab6f\u3538\ubf8e\u3847\uc227\u4cfb\ud545\u5f19\ud9e5\u63ac\uec36\u768b"), a.c(732046637, "\u2102\u58a4\ud207\u481d\uc3c4\u4115\ufb36\u72c6\uec96\u665b\ue181\u1f95\u914c")) + string;
        }
        return this.hkf() ? wap.s(a.b("\ueb1b\u92b5\u187f\u867e\u0de6\u8b56\u3107\ub8e3\u26eb\uac54", 129493831), a.c(793341252, "\u6976\u10db\u9a0d\u040b\u8faa\u091f\ub752\u3ab7\ua4e7\u2e22\uad9e\u5799\ud951\u40f9\ucad4\u4c2b")) + string : string;
    }

    String searchDescription() {
        return wap.both(this.module != null ? this.module.getDescription() : this.hjp);
    }

    float headBottom() {
        return this.y + 27.0f;
    }

    hjg(String string, String string2) {
        this.module = null;
        this.title = string;
        this.hjp = string2;
        this.hjt = new vcj(12.0f, 0.0f);
        this.hjr = null;
        this.hjy = hjo;
        this.hju.set(this.hjy ? 0.0f : 1.0f);
    }

    hjg settings(List<? extends vmo> list) {
        for (vmo vmo2 : list) {
            imn imn2 = imn.of(vmo2);
            if (imn2 == null) continue;
            this.rows.add(imn2);
        }
        return this;
    }

    hjg row(imn imn2) {
        this.rows.add(imn2);
        return this;
    }

    hjg unfolded() {
        this.hjy = false;
        this.hju.set(1.0f);
        return this;
    }

    hjg toggle(vkl vkl2) {
        this.hjq = vkl2;
        this.hjt.set(vkl2.get() ? 1.0f : 0.0f);
        return this;
    }

    imn rowFor(vmo vmo2) {
        for (imn imn2 : this.rows) {
            if (imn2.setting != vmo2) continue;
            return imn2;
        }
        return null;
    }

    boolean isCollapsed() {
        return this.hjy && !this.rows.isEmpty();
    }

    void setCollapsed(boolean bl) {
        this.hjy = bl && !this.rows.isEmpty();
    }

    private boolean hkd() {
        return this.module != null ? this.module.isEnabled() : this.hjq != null && this.hjq.get();
    }

    private boolean hke() {
        return this.module != null && !this.module.isLocked() || this.hjq != null;
    }

    private boolean hkf() {
        return this.module != null && this.module.isVip();
    }

    private boolean hkg() {
        return this.module != null && this.module.isMaintenance();
    }

    private boolean hkh() {
        return this.module != null && this.module.isLocked();
    }

    private float hki() {
        if (this.rows.isEmpty()) {
            return 0.0f;
        }
        float f = 5.0f;
        for (imn imn2 : this.rows) {
            f += imn2.currentHeight();
        }
        return f + 6.0f;
    }

    private float hkj() {
        if (this.rows.isEmpty()) {
            return 0.0f;
        }
        float f = 11.0f;
        for (imn imn2 : this.rows) {
            f += imn2.targetHeight();
        }
        return f;
    }

    float targetHeight() {
        return 27.0f + (this.hjy ? 0.0f : this.hkj());
    }

    float height() {
        return 27.0f + this.hki() * this.hju.get();
    }

    boolean headerHovered(float f, float f2) {
        return irr.inside(f, f2, this.x, this.y, this.w, 27.0f);
    }

    boolean hovered(float f, float f2) {
        return irr.inside(f, f2, this.x, this.y, this.w, this.height());
    }

    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4;
        boolean bl = hlc2.canHover();
        float f5 = this.hjs.step(bl && this.hovered(f, f2), f3);
        float f6 = this.hjt.step(this.hkd(), f3);
        this.hju.step(this.hjy ? 0.0f : 1.0f, f3);
        float f7 = this.hjw.step(this.hjr != null && hlc2.binding() == this.hjr, f3);
        for (imn imn2 : this.rows) {
            imn2.animate(f3);
        }
        float f8 = this.height();
        float f9 = iov.r(7.0f);
        float f10 = iov.lightness();
        drawContext.method_51448().pushMatrix();
        ukf.shadow(drawContext, this.x, this.y, this.w, f8, f9, 0.3f, f10);
        int n = ujt.lerp(iov.card, iov.cardHover, f5);
        boolean bl2 = hyv.surface(drawContext, this.x, this.y, this.w, f8, f9, hyv.tint(iov.window, Math.min(0.95f, iov.windowTint())), n, 7.0f, hyv.CARDS);
        if (bl2) {
            uut.round(drawContext, this.x, this.y, this.w, f8, f9, ujt.mulAlpha(n, ujt.alpha(n) > 128 ? 0.35f : 1.0f));
        }
        ukf.sheen(drawContext, this.x, this.y, this.w, Math.min(f8, 60.0f), f9, 1.0f - 0.7f * f10);
        uut.outline(drawContext, this.x, this.y, this.w, f8, f9, 1.0f, ujt.lerp(iov.stroke, ujt.lerp(iov.stroke, iov.textMuted, 0.25f), f5));
        ukf.rim(drawContext, this.x, this.y, this.w, f8, f9, f10, 0.8f);
        float f11 = this.y + 13.5f;
        float f12 = this.x + this.w - 10.0f;
        float f13 = this.hkk(f3);
        if (this.hkh()) {
            var18_20 = this.headerHovered(f, f2) ? f5 : 0.0f;
            vjf.draw(drawContext, vhz.LOCK, f12 - 5.0f + f13, f11, 7.5f, ujt.lerp(iov.textMuted, this.hkg() ? -1013204 : iov.accent(), Math.max(var18_20 * 0.7f, this.hjx.get())));
            f12 -= 16.0f;
        } else if (this.hke()) {
            irr.drawSwitch(drawContext, f12 - 17.0f, f11 - 4.75f, f6, f5 * (this.headerHovered(f, f2) ? 1.0f : 0.0f));
            f12 -= 23.0f;
        } else if (!this.rows.isEmpty()) {
            var18_20 = this.hju.get();
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate(f12 - 4.0f, f11);
            drawContext.method_51448().rotate(-1.5707964f * (1.0f - var18_20));
            vjf.draw(drawContext, vhz.CHEVRON_DOWN, 0.0f, 0.0f, 7.0f, ujt.lerp(iov.textMuted, iov.textDim, Math.max(f5, var18_20 * 0.5f)));
            drawContext.method_51448().popMatrix();
            f12 -= 14.0f;
        }
        if (this.hjr != null) {
            f12 = this.hko(drawContext, hlc2, f12, f11, f, f2, f3, f5, f7);
        }
        int n2 = this.hke() ? ujt.lerp(iov.textDim, iov.text, Math.max(f6, f5 * 0.6f)) : iov.text;
        float f14 = this.x + 10.0f;
        if (this.hkh()) {
            String string = this.hkg() ? hjg.hkl() : a.d("\ucb40\ub2ee\u3824", 1536986414, 1042695739);
            f4 = hjg.hkm(string);
            String string2 = irr.CARD_TITLE.ellipsize(this.shownTitle(), f12 - f14 - 4.0f - f4 - 5.0f);
            irr.CARD_TITLE.draw(drawContext, string2, f14, irr.CARD_TITLE.centerTop(f11), ujt.lerp(iov.textDim, iov.text, f5 * 0.4f));
            float f15 = f14 + irr.CARD_TITLE.width(string2) + 5.0f + f13;
            if (this.hkg()) {
                this.hkn(drawContext, f15, f11, f5, vhz.WRENCH, string, -14003, -1013204, -14018301, -1013204);
            } else {
                this.hkn(drawContext, f15, f11, f5, vhz.CROWN, string, iov.accent(), iov.accent2(), iov.onAccent(), iov.accent());
            }
        } else {
            irr.CARD_TITLE.draw(drawContext, irr.CARD_TITLE.ellipsize(this.shownTitle(), f12 - f14 - 4.0f), f14, irr.CARD_TITLE.centerTop(f11), n2);
        }
        float f16 = f8 - 27.0f;
        if (f16 > 0.5f) {
            f4 = this.hju.get();
            uut.pushAlpha(Math.min(1.0f, f4 * 1.4f));
            uut.rect(drawContext, this.x + 10.0f, this.y + 27.0f - 0.5f, this.w - 20.0f, 1.0f, iov.divider);
            uut.pushScissor(drawContext, this.x, this.y + 27.0f, this.w, f16);
            float f17 = this.y + 27.0f + 5.0f;
            for (imn imn3 : this.rows) {
                float f18 = imn3.currentHeight();
                imn3.x = this.x + 10.0f;
                imn3.y = f17;
                imn3.w = this.w - 20.0f;
                if (f18 > 0.3f) {
                    uut.pushScissor(drawContext, this.x, f17, this.w, f18);
                    uut.pushAlpha(imn3.opacity());
                    imn3.render(drawContext, hlc2, imn3.interactive() ? f : -1000.0f, imn3.interactive() ? f2 : -1000.0f, f3);
                    uut.popAlpha();
                    uut.popScissor(drawContext);
                }
                f17 += f18;
            }
            uut.popScissor(drawContext);
            uut.popAlpha();
        }
        drawContext.method_51448().popMatrix();
    }

    private float hkk(float f) {
        float f2 = this.hjx.step(0.0f, f);
        return f2 < 0.01f ? 0.0f : (float)Math.sin((double)(1.0f - f2) * Math.PI * 6.0) * 2.2f * f2;
    }

    private static String hkl() {
        return wap.s(a.c(-1818683432, "\u179e\u6e03\ue4d8\u7aae\uf163\u77c3\ucd9b\u4465\uda35\u5089\ud75c"), a.b("\u3531\u4c97\uc634\u5c2e\ud7f7\u5526\uef05\u66f5\uf8a5\u7268\uf5b2", -1266339560));
    }

    private static float hkm(String string) {
        return 8.5f + hjj.width(string) + 9.0f;
    }

    private void hkn(DrawContext drawContext, float f, float f2, float f3, vhz vhz2, String string, int n, int n2, int n3, int n4) {
        float f4;
        float f5 = hjg.hkm(string);
        float f6 = 11.0f;
        float f7 = f2 - f6 * 0.5f;
        float f8 = iov.r(3.5f);
        float f9 = 0.5f + 0.5f * (float)Math.sin((double)System.nanoTime() / 4.5E8);
        uut.shadow(drawContext, f, f7, f5, f6, f8, 3.5f, ujt.withAlpha(n4, (int)(40.0f + 50.0f * f9 + 40.0f * f3)));
        uut.gradientH(drawContext, f, f7, f5, f6, f8, n, n2);
        ukf.sheen(drawContext, f, f7, f5, f6, f8, 1.6f);
        float f10 = (float)(System.nanoTime() / 1000000L % 2600L) / 2600.0f;
        if (f10 < 0.55f) {
            f4 = f10 / 0.55f;
            float f11 = 7.0f;
            float f12 = f - f11 + (f5 + f11) * f4;
            int n5 = ujt.withAlpha(-1, (int)(95.0 * Math.sin(Math.PI * (double)f4)));
            uut.pushScissor(drawContext, f, f7, f5, f6);
            uut.gradientH(drawContext, f12, f7, f11 * 0.5f, f6, 0.0f, 0xFFFFFF, n5);
            uut.gradientH(drawContext, f12 + f11 * 0.5f, f7, f11 * 0.5f, f6, 0.0f, n5, 0xFFFFFF);
            uut.popScissor(drawContext);
        }
        uut.outlineGradientV(drawContext, f, f7, f5, f6, f8, 1.0f, 0x50FFFFFF, 0x14000000);
        f4 = 6.0f;
        vjf.draw(drawContext, vhz2, f + 4.5f + f4 * 0.5f, f2 - 0.2f, f4, n3);
        hjj.draw(drawContext, string, f + 4.5f + f4 + 2.5f, hjj.centerTop(f2), n3);
    }

    private float hko(DrawContext drawContext, hlc hlc2, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        boolean bl;
        int n = this.hjr.get();
        boolean bl2 = bl = n != -1;
        String string = f7 > 0.5f ? a.b("\u3254\u4be5\uc136", -112905607) : (bl ? irr.keyName(n) : wap.s(a.d("\u4258\u3bc2\ub116\u2f6d", 535131505, 1825191791), a.d("\u8a88\uf310\u79c6\ue7be", 833284317, -320641472)));
        float f8 = Math.max(bl ? 1.0f : f6, f7);
        this.hka = Math.max(16.0f, irr.SMALL.width(string) + 9.0f);
        this.hjz = f - this.hka;
        float f9 = this.hjv.step(hlc2.canHover() && irr.inside(f3, f4, this.hjz, f2 - 5.5f, this.hka, 11.0f), f5);
        if (f8 <= 0.01f) {
            return f;
        }
        uut.pushAlpha(f8);
        float f10 = f7 > 0.01f ? 0.55f + 0.45f * (float)Math.sin((double)System.nanoTime() / 1.6E8) : 0.0f;
        int n2 = bl || f7 > 0.01f ? ujt.lerp(iov.textDim, iov.accent(), f7) : iov.textMuted;
        irr.drawChip(drawContext, string, f, f2, ujt.lerp(n2, iov.text, f9), ujt.lerp(iov.stroke, iov.accent((int)(120.0f + 110.0f * f10)), f7), f9);
        uut.popAlpha();
        return this.hjz - 4.0f;
    }

    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (this.headerHovered(f, f2)) {
            boolean bl;
            boolean bl2 = bl = this.hjr != null && irr.inside(f, f2, this.hjz, this.y + 13.5f - 5.5f, this.hka, 11.0f);
            if (this.hjr != null && (n == 2 || n == 0 && bl)) {
                hlc2.startBinding(this.hjr);
            } else if (n == 1 && !this.rows.isEmpty()) {
                this.hjy = !this.hjy;
            } else if (n == 0 && this.hkg()) {
                this.hjx.set(1.0f);
                hlc2.toast(wap.s(a.b("\u1763\u6ee9\ue430\u7a40\uf180\u7763\ucd7d\u4480\udad7\u5061\ud7a8\u2dc8\ua314\u3aaa\ub0f6\u360a\u8c43\u03db\u9964\u1f77\u9683\uecd0\u626b\uf9f1\u7fdd\uf510\u4ca3\uc2f3", 1823938346), a.b("\ud038\ua9ab\u2372\ubd74\u36db\ub01d\u0e22\u83ce\u1d9c\u933d\u108c\uea8a\u642d\uf9f7\u73aa\uf13b\u4b04\uc4d4\u5e68\ud845\u51c0\u2be4\ua13e\u3ae3\ub8fd\u3257\u8be0\u05cf\u9f46\u1d09\u92a8\u6c7e\ue644\u7fc8\uf9f7\u732b", -2099719168)), vhz.WRENCH, true);
            } else if (n == 0 && this.hkf()) {
                this.hjx.set(1.0f);
                hlc2.toast(wap.s(a.d("\u9771\ueef7\u6433\ufa4a\u7198\uf724\u4d74\uc48b\u5add\ud029\u57ad\uadc2\u2308\ubaa5\u30be\ub639\u0c69\u83a1\u1962\u9f7c\u168a\u6cd9\ue27f", -731826511, -1156537962), a.d("\udc12\ua589\u2f25\ub157\u3a81\ubc4c\u061d\u8fef\u15ae\u9b7d\u1cd2\ue6a6\u6806\uf1c1\u7b96\uf979\u4757\ucce7\u5622\ud06c\u5982", -1912363691, -1310098106)), vhz.CROWN, true);
            } else if (n == 0 && this.module != null) {
                this.module.toggle();
            } else if (n == 0 && this.hjq != null) {
                this.hjq.toggle();
            } else if (n == 0 && !this.rows.isEmpty()) {
                this.hjy = !this.hjy;
            }
            return true;
        }
        if (this.hju.get() > 0.9f) {
            for (imn imn2 : this.rows) {
                if (!imn2.interactive() || !imn2.mouseClicked(hlc2, f, f2, n)) continue;
                return true;
            }
        }
        return true;
    }

    static {
        hjk = a.c(2065082239, "\ua72a\ude84\u544e");
        hjj = veo.bold(5.5f);
        hjo = !Boolean.getBoolean(a.b("\uc14d\ub8f6\u3226\uac4f\u27dd\ua170\u1b7e\u9299\u0ccf\u8674\u01b5\ufbd5\u7514\ueca2", 1706410277));
    }

    private static /* synthetic */ int abe(int n, int n2) {
        return n * n2 ^ 0x3141C5E1;
    }
}

