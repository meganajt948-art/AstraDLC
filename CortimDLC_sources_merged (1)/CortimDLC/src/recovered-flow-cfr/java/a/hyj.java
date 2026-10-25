/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.SkinTextures
 */
package a;

import a.hhc;
import a.hhf;
import a.hlc;
import a.hyg;
import a.imn;
import a.iov;
import a.irr;
import a.ujt;
import a.ukf;
import a.uog;
import a.uut;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.dev.a;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SkinTextures;

final class hyj
extends imn {
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

    hyj() {
        super(null);
    }

    @Override
    float height() {
        int n = hhf.all().size();
        return n == 0 ? 58.0f : 2.0f + (float)n * 29.0f;
    }

    private float hyt(int n) {
        return this.y + 2.0f + (float)n * 29.0f;
    }

    private float hyu() {
        return this.x + this.w - 6.0f - 18.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<hhc> list = hhf.all();
        if (list.isEmpty()) {
            this.hyo.clear();
            float f4 = this.x + this.w * 0.5f;
            uut.circle(drawContext, f4, this.y + 17.0f, 12.0f, iov.hover);
            vjf.draw(drawContext, vhz.FRIENDS, f4, this.y + 17.0f, 11.0f, iov.textMuted);
            irr.LABEL.drawCentered(drawContext, wap.s(a.c(1328258349, "\u9d6d\ue4fd\u6e61\uf056\u7b95\ufd3f\u4760\uce9a\u50cf\uda69\u5de9\ua7c1\u290a\ub0aa"), a.b("\ud578\uac9d\u264d\ub848\u339d\ub520\u0b6a\u8684\u18da\u926f\u15b6\uebd7\u611d\uf8a4\u7280", -59256477)), f4, irr.LABEL.centerTop(this.y + 38.0f), iov.textDim);
            irr.SMALL.drawCentered(drawContext, wap.s(a.d("\u0162\u78f7\uf229\u6c58\ue787\u613f\udb29\u529b\ucccb\u467f\uc1a6\u3bdf\ub543\u2cb3\ua6a1\u2000\u9a53\u158f\u8f24\u0969\u8089\ufa86\u7439\uefa7\u69c5\ue346\u5ab4\ud4e0\u4e17\uc802\u43f0\ubd60\u3761\uae9f\u28c0\ua279", 1790305760, 1216275691), a.c(-2121429595, "\u899a\uf010\u7ac5\ue088\u6f40\ue9f0\u57bd\uda54\u4400\ucec2\u496f\ub31a\u3db4\ua066\u2e2d\ua8df\u1293\u995a\u07fd\u81a6\u085e\u720e\ufcbf\u6710\ue161\u6bc7\ud661\u5c2d\uc6df\u408c")), f4, irr.SMALL.centerTop(this.y + 49.0f), iov.textMuted);
            return;
        }
        if (this.hyp != null && System.currentTimeMillis() > this.hyq) {
            this.hyp = null;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        float f5 = iov.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            int n;
            String string2;
            hhc hhc2 = list.get(i);
            String string3 = hhc2.name.toLowerCase(Locale.ROOT);
            hyg hyg2 = this.hyo.computeIfAbsent(string3, string -> new hyg());
            float f6 = this.hyt(i);
            float f7 = vcq.outCubic(hyg2.appear.step(1.0f, f3));
            boolean bl = hlc2.canHover() && irr.inside(f, f2, this.x, f6, this.w, 26.0f);
            float f8 = hyg2.hover.step(bl, f3);
            uut.pushAlpha(f7);
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate((1.0f - f7) * 18.0f, 0.0f);
            uut.round(drawContext, this.x, f6, this.w, 26.0f, f5, ujt.withAlpha(iov.hover, (int)((float)ujt.alpha(iov.hover) * (0.6f + 1.4f * f8))));
            float f9 = f6 + 13.0f;
            PlayerEntity playerEntity = hhf.inWorld(hhc2.name);
            boolean bl2 = playerEntity != null || hhf.listEntry(hhc2.name) != null;
            hyj.face(drawContext, hhc2.name, hhf.skinOf(hhc2.name), this.x + 5.0f, f9 - 8.0f, bl2);
            float f10 = this.x + 5.0f + 16.0f + 7.0f;
            float f11 = this.hyu() - f10 - 4.0f;
            irr.CARD_TITLE.draw(drawContext, irr.CARD_TITLE.ellipsize(hhc2.name, f11), f10, irr.CARD_TITLE.centerTop(f9 - 4.0f), iov.text);
            if (playerEntity != null && minecraftClient.field_1724 != null) {
                double d = Math.sqrt(minecraftClient.field_1724.method_5858((Entity)playerEntity));
                string2 = playerEntity == minecraftClient.field_1724 ? wap.s(a.b("\uef67\u96e0\u1c29", 189722429), a.d("\u8d82\uf46a", 1976972903, 737656821)) : wap.s(a.c(1935009727, "\ue7fe\u9e62\u14a6\u8ac0\u0152\u87e3\u3d27\ub441\u2a1e"), a.d("\uf2b1\u8b6f\u01c7\u9fbc\u1469\u96c4\u2c97\ua5f1\u3b39\ub188", -89447506, -1989290699)) + Math.round(d) + wap.unit(a.d("\u110a", 784601002, -1815666996));
                n = -11870592;
            } else if (bl2) {
                string2 = wap.s(a.b("\ufd5a\u84ca\u0e1b\u906f\u1bbf\u9d05", 1460010259), a.d("\u025b\u7fd8\uf16a\u6f6f\ue4cf\u6204", 1713360781, 2099300802));
                n = ujt.lerp(-11870592, iov.textDim, 0.4f);
            } else {
                string2 = wap.s(a.b("\ue851\u91c1\u1b09\u852c\u0eb3\u880f\u324b\ubbad", 1814882327), a.d("\ub888\uc111\u4fd7\ud5b1\u5e65\ud8d5\u62f2\ueb0e", -1388248135, 1804844836));
                n = iov.textMuted;
            }
            uut.circle(drawContext, f10 + 1.6f, f9 + 5.0f, 1.6f, n);
            irr.SMALL.draw(drawContext, string2, f10 + 5.5f, irr.SMALL.centerTop(f9 + 5.0f), n);
            boolean bl3 = string3.equals(this.hyp);
            float f12 = this.hyu() + (1.0f - f8) * 6.0f;
            boolean bl4 = hlc2.canHover() && irr.inside(f, f2, f12, f9 - 9.0f, 18.0f, 18.0f);
            float f13 = hyg2.button.step(bl4, f3);
            irr.iconButton(drawContext, vhz.TRASH, f12, f9 - 9.0f, 18.0f, f13, bl3, bl3 ? 1.0f : f8);
            if (bl4 && f8 > 0.5f) {
                hlc2.hint(bl3 ? wap.s(a.b("\ucd17\ub489\u3e5f\ua024\u2bfb\uad01\u1713\u9ee4\u00bd\u8a04\u0dd0\uf7ef\u796c\ue0c6\u6ada\uec79\u5621\ud9f8\u4349\uc501\u4ce5\u36f1", -1223570110), a.d("\u8352\uface\u701b\uee60\u65b3\ue378\u595c\ud4b8\u4ef2\uc43f\u43f4\ubdf4\u3743\uae82\u24d6\ua63c\u1c7f\u97c9\u0d7f\u8b52\u02aa\u7881\uf259\u6deb\uebe3\u6136\ud88e\u56dc\ucc51\u4a0e\uc5d1", 906817708, -1380812804)) + hhc2.name : wap.s(a.b("\u7de1\u0467\u8ebc\u10cf\u9b01\u1da3\ua7b5\u2e02\ub049\u3ae5\ubd34\u4708\uc999\u503c\uda74\u5c89\ue6cd\u6916\uf3b2", 527072672), a.c(-796968597, "\u3d59\u44ff\uce28\u5052\udb86\u5d4d\ue710\u6a8d\uf0ca\u7a74\uf9b0\u07d5\u8976\u10c4\u9ae3\u1c10\ua653")));
            }
            drawContext.method_51448().popMatrix();
            uut.popAlpha();
        }
    }

    static void face(DrawContext drawContext, String string, SkinTextures skinTextures, float f, float f2, boolean bl) {
        boolean bl2;
        float f3 = Math.min(8.0f, iov.r(4.5f));
        ukf.shadow(drawContext, f, f2, 16.0f, 16.0f, f3, 0.5f, iov.lightness());
        boolean bl3 = skinTextures != null && uog.draw(drawContext, skinTextures, f, f2, 16.0f, f3, bl ? -1 : -6645086) ? true : (bl2 = false);
        if (!bl2) {
            uut.round(drawContext, f, f2, 16.0f, 16.0f, f3, iov.field);
            irr.AVATAR.drawCentered(drawContext, string.substring(0, 1).toUpperCase(Locale.ROOT), f + 8.0f, irr.AVATAR.centerTop(f2 + 8.0f), iov.textDim);
        }
        uut.outlineGradientV(drawContext, f, f2, 16.0f, 16.0f, f3, 1.0f, 0x34FFFFFF, 0x8FFFFFF);
        if (bl) {
            float f4 = 5.0f;
            uut.circle(drawContext, f + 16.0f - 1.0f, f2 + 16.0f - 1.0f, f4 * 0.5f + 1.0f, iov.card | 0xFF000000);
            uut.circle(drawContext, f + 16.0f - 1.0f, f2 + 16.0f - 1.0f, f4 * 0.5f, -11870592);
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        List<hhc> list = hhf.all();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.hyt(i);
            if (!irr.inside(f, f2, this.x, f3, this.w, 26.0f)) continue;
            hhc hhc2 = list.get(i);
            String string = hhc2.name.toLowerCase(Locale.ROOT);
            float f4 = f3 + 13.0f;
            if (n == 0 && irr.inside(f, f2, this.hyu(), f4 - 9.0f, 18.0f, 18.0f)) {
                if (!string.equals(this.hyp)) {
                    this.hyp = string;
                    this.hyq = System.currentTimeMillis() + 2500L;
                } else {
                    this.hyp = null;
                    String string2 = hhc2.name;
                    hhf.remove(string2);
                    hlc2.toast(wap.s(a.b("\uf1d9\u885f\u0284\u9cf7\u1739\u919b\u2bc9\ua27c", 657781123), a.b("\u745c\u0dfa\u872d\u1957\u92ea\u1437\uaa79", 1427206264)) + string2, vhz.TRASH, false);
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
        return hyj.adt(n, n2) ^ 0xE5B8F4A2;
    }
}

