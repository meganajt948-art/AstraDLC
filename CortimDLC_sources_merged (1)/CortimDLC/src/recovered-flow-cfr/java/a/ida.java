/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.Text
 */
package a;

import a.hyv;
import a.hyz;
import a.iov;
import a.irr;
import a.ujt;
import a.ukf;
import a.unf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdc;
import a.vdn;
import a.vhz;
import a.vjf;
import a.wam;
import a.wap;
import flow.dev.a;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public final class ida
extends Screen {
    private static final float idb = 240.0f;
    private static final float idc = 150.0f;
    private static final float idd = 16.0f;
    private static final float ide = 52.0f;
    private static final float idf = 64.0f;
    private static final float idg = 10.0f;
    private static final wam[] idh = new wam[]{wam.RU, wam.EN};
    private final Screen idi;
    private final vdc idj = new vdc(0.32f, 0.0f);
    private final vcj[] idk = new vcj[]{new vcj(16.0f), new vcj(16.0f)};
    private final vcj[] idl = new vcj[]{new vcj(12.0f), new vcj(12.0f)};
    private int idm;
    private boolean idn;
    private boolean ido;
    private long idp = -1L;
    private float idq = 0.016666668f;
    private float idr = 1.0f;
    private float ids;
    private float idt;
    private static /* synthetic */ boolean idu;
    private static /* synthetic */ long idv;

    public ida(Screen screen) {
        super((Text)Text.literal((String)a.b("\u3ae8\u4374\uc9a8\u57d0\udc15\u5ab0\ue0e5\u6916", -1252902228)));
        this.idi = screen;
        this.idm = wap.ru() || !wap.chosen() ? 0 : 1;
        for (int i = 0; i < idh.length; ++i) {
            this.idl[i].set(wap.chosen() && wap.get() == idh[i] ? 1.0f : 0.0f);
        }
    }

    private void idw(DrawContext drawContext) {
        unf.observe(drawContext);
        if (unf.frame() == this.idp) {
            return;
        }
        this.idp = unf.frame();
        this.idq = unf.delta() * (float)iov.ANIMATION.get();
        iov.update(this.idq);
        this.idj.update(this.idq);
        if (this.idn && this.idj.finished() && !this.ido && this.client != null) {
            this.ido = true;
            this.client.send(() -> this.client.setScreen(this.idi));
        }
    }

    private float idx() {
        float f = this.idj.linear();
        return this.idn ? vcq.outCubic(f) : vcq.outQuint(f);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        uut.beginFrame();
        this.idw(context);
        float f = this.idx();
        if (this.client != null && this.client.world != null) {
            hyv.capture(context, Math.max(1, iov.BG_BLUR.getInt()), f, null);
            uut.rect(context, 0.0f, 0.0f, this.width, this.height, ujt.withAlpha(0, Math.round(140.0f * f)));
        } else {
            hyv.skip();
            this.renderPanoramaBackground(context, deltaTicks);
            context.applyBlur();
            uut.rect(context, 0.0f, 0.0f, this.width, this.height, ujt.withAlpha(0, Math.round(120.0f * f)));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        this.idw(context);
        float f = this.idx();
        float f2 = Math.min(((float)this.width - 16.0f) / 240.0f, ((float)this.height - 16.0f) / 150.0f);
        float f3 = Math.max(0.4f, Math.min((float)iov.SCALE.get() * 1.1f, f2));
        this.idr = f3 * (0.96f + 0.04f * f);
        this.ids = (float)this.width * 0.5f - 120.0f * this.idr;
        this.idt = (float)this.height * 0.5f - 75.0f * this.idr + (1.0f - f) * 8.0f;
        float f4 = ((float)mouseX - this.ids) / this.idr;
        float f5 = ((float)mouseY - this.idt) / this.idr;
        vdn.setRenderScale(f3);
        context.getMatrices().pushMatrix();
        context.getMatrices().translate(this.ids, this.idt);
        context.getMatrices().scale(this.idr, this.idr);
        uut.pushAlpha(f);
        try {
            this.iea(context, f4, f5);
        }
        finally {
            uut.popAlpha();
            context.getMatrices().popMatrix();
            vdn.setRenderScale(1.0f);
        }
    }

    private float idy() {
        return 99.0f;
    }

    private float idz(int n) {
        return 16.0f + (float)n * (this.idy() + 10.0f);
    }

    private void iea(DrawContext drawContext, float f, float f2) {
        float f3 = iov.r(12.0f);
        float f4 = iov.lightness();
        uut.shadow(drawContext, 0.0f, 4.0f, 240.0f, 150.0f, f3, 18.0f, iov.shadow);
        uut.round(drawContext, 0.0f, 0.0f, 240.0f, 150.0f, f3, ujt.withAlpha(iov.window, 255));
        ukf.sheen(drawContext, 0.0f, 0.0f, 240.0f, 60.0f, f3, 0.8f * (1.0f - 0.7f * f4));
        uut.outline(drawContext, 0.0f, 0.0f, 240.0f, 150.0f, f3, 1.0f, iov.stroke);
        ukf.rim(drawContext, 0.0f, 0.0f, 240.0f, 150.0f, f3, f4, 1.1f);
        uut.circle(drawContext, 25.0f, 24.0f, 10.0f, iov.accent(40));
        vjf.draw(drawContext, vhz.GLOBE, 25.0f, 24.0f, 11.0f, iov.accent());
        String string = wap.chosen() ? wap.s(a.b("\ucbde\ub242\u389e\ua6e6\u2d23\uab86\u11d3\u9820", 393661338), a.d("\ub1d5\uc87c\u42d3\udcd3", 1297834209, -128330465)) : a.c(1582281012, "\ub50a\ucca3\u460c\ud80c\u57c1\ud170\u6bb4\ue2d2\u7c8d\uf650\u71ae\u8bd0\u050e\u9cad\u16ea\u901d\u2a50");
        irr.TITLE.draw(drawContext, string, 41.0f, irr.TITLE.centerTop(20.0f), iov.text);
        String string2 = wap.chosen() ? wap.s(a.b("\uba8b\uc311\u49c5\ud7b4\u5c7f\udad8\u60ce\ue96b\u7728\ufd94\u7a02\u8030\u0ee8\u975c\u1d03\u9bf9\u21ac\uae29\u34d6\ub28a\u3b72\u412a\ucf8b\u544e\ud237\u58e4", -761873710), a.b("\uef61\u9689\u1c20\u8255\u09f7\u8f3e\u3517\ubc91\u26db\ua805\u2fae\ud5a3\u5b05\uc6ae\u48e7\uce17\u745b\ufb87\u613c\ue712\u6e97", 245951334)) : a.d("\ufa83\u836b\u09c2\u97b7\u1c15\u9adc\u20f5\ua973\u3339\ubde7\u3a4c\uc041\u4ee7\ud34c\u591f\udf79\u65a1\uea70\u70a0\uf6da\u7f2a\u057b\u8bd4\u1013\u9629\u1ca1\ua504\u2b4f\ub1bf\u37bc\ubc43\u429f\uc8df\u5127\ud766\u5dc3\ue212\u6861", 611543645, -1054173974);
        irr.SUBTITLE.draw(drawContext, irr.SUBTITLE.ellipsize(string2, 183.0f), 41.0f, irr.SUBTITLE.centerTop(32.0f), iov.textMuted);
        for (int i = 0; i < idh.length; ++i) {
            this.ieb(drawContext, i, f, f2);
        }
        String string3 = wap.chosen() || wap.ru() ? wap.s(a.d("\uffc6\u8641\u0c88\u92ac\u1938\u9f8b\u25d7\uac68\u3274\ub8ce\u3f14\uc56a\u4bb4\ud207\u5811\udea9\u64fb\ueb7e\u718c\uf7d2\u7e32\u043a\u8add\u1111\u976a\u1db3\ua45f\u2a14\ub0b7\u36fa\ubd44\u43d0\uc9d8\u5022\ud672\u5cce\ue31e\u692a\uefbb\u761d\ufc43\u82b2\u08fa\u8f4a\u15d3\u9beb\u223f\ua8c0\u2edb\ub516\u3b68\uc1fc\u4806\uce5f\u54a7\udaed", 421599620, 730326563), a.b("\uf7a8\u8e04\u04de\u9aa7\u1175\u97be\u2de3\ua07e\u3a3d\ub08e\u3755\ucd2f\u43fb\ude54\u5015\ud2f6\u6ca2\ue306\u79ca\uff94\u7664\u082c\u8283\u1950\u9f2d\u15f5\uac4e\u2260\ubcef\u3aa4\ub50d\u4bdb\uc197\u5867\ude31\u548a\uef4d\u615d\ue3ef\u7e4d\uf41a\u8aee\u00b2\u8771\u1da4\u93aa\u2a7b\ua4d6\u268b\ub948\u3327\uc9ff\u4040\uc662", 1254093759)) : a.c(1038001636, "\ua1e2\ud84e\u5294\ucced\u473f\uc1f4\u7ba9\uf634\u6c77\ue6c4\u611f\u9b65\u15b1\u881e\u0657\u80a1\u3aed\ub53d\u2f8b\ua9de\u202e\u5e66\ud4b4\u4b04\uc968\u43b1\ufa07\u7459\ueedc\u688f\ue343\u1d90\u93c3\u0e20\u8c61\u02cc\ubd12\u376b\ub1cb");
        irr.SMALL.drawCentered(drawContext, irr.SMALL.ellipsize(string3, 208.0f), 120.0f, irr.SMALL.centerTop(135.0f), ujt.mulAlpha(iov.textMuted, 0.9f));
    }

    private void ieb(DrawContext drawContext, int n, float f, float f2) {
        boolean bl;
        float f3 = this.idz(n);
        float f4 = this.idy();
        boolean bl2 = bl = !this.idn && irr.inside(f, f2, f3, 52.0f, f4, 64.0f);
        if (bl) {
            this.idm = n;
        }
        float f5 = this.idk[n].step(bl || this.idm == n && !this.iec(f, f2), this.idq);
        boolean bl3 = wap.chosen() && wap.get() == idh[n];
        float f6 = this.idl[n].step(bl3, this.idq);
        float f7 = 52.0f - 1.5f * f5;
        float f8 = iov.r(8.0f);
        float f9 = iov.lightness();
        ukf.shadow(drawContext, f3, f7, f4, 64.0f, f8, 0.3f + 0.7f * f5, f9);
        uut.round(drawContext, f3, f7, f4, 64.0f, f8, ujt.lerp(iov.card | 0xFF000000, iov.cardHover | 0xFF000000, f5));
        uut.outline(drawContext, f3, f7, f4, 64.0f, f8, 1.0f, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, 0.35f * f5), iov.accent(), Math.max(f6, 0.6f * f5)));
        ukf.rim(drawContext, f3, f7, f4, 64.0f, f8, f9, 0.8f);
        ida.flag(drawContext, idh[n], f3 + 11.0f, f7 + 11.0f);
        boolean bl4 = idh[n] == wam.RU;
        irr.LOGO.draw(drawContext, bl4 ? a.d("\u5f0e\u26b8", -1058973484, 1871185802) : a.d("\u2ff5\u564f", -1884537318, -1922952792), f3 + 11.0f, irr.LOGO.centerTop(f7 + 38.0f), ujt.lerp(iov.textDim, iov.text, Math.max(f5, f6)));
        irr.LABEL.draw(drawContext, bl4 ? a.c(-1249791253, "\ub6cc\ucf1e\u45cf\udbbe\u5012\ud6a1\u6cf3") : a.b("\u80dc\uf946\u739c\uede6\u6634\ue09f\u5ad7", 1732673694), f3 + 11.0f, irr.LABEL.centerTop(f7 + 52.0f), iov.textMuted);
        if (f6 > 0.01f) {
            float f10 = f3 + f4 - 12.0f;
            float f11 = f7 + 12.0f;
            float f12 = vcq.outBack(f6);
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(f10, f11);
            drawContext.getMatrices().scale(f12, f12);
            uut.circle(drawContext, 0.0f, 0.0f, 5.5f, iov.accent());
            vjf.draw(drawContext, vhz.CHECK, 0.0f, 0.0f, 7.0f, iov.onAccent());
            drawContext.getMatrices().popMatrix();
        } else if (f5 > 0.01f) {
            uut.pushAlpha(f5);
            vjf.draw(drawContext, vhz.CHEVRON_RIGHT, f3 + f4 - 12.0f, f7 + 32.0f, 8.0f, iov.accent());
            uut.popAlpha();
        }
    }

    private boolean iec(float f, float f2) {
        for (int i = 0; i < idh.length; ++i) {
            if (!irr.inside(f, f2, this.idz(i), 52.0f, this.idy(), 64.0f)) continue;
            return true;
        }
        return false;
    }

    public static void flag(DrawContext drawContext, wam wam2, float f, float f2) {
        float f3 = 20.0f;
        float f4 = 13.0f;
        float f5 = 2.5f;
        if (wam2 == wam.RU) {
            uut.round(drawContext, f, f2, f3, f4, f5, -2807010);
            uut.round(drawContext, f, f2, f3, f4 * 2.0f / 3.0f, f5, f5, 0.0f, 0.0f, -16762458);
            uut.round(drawContext, f, f2, f3, f4 / 3.0f, f5, f5, 0.0f, 0.0f, -1);
            uut.rect(drawContext, f, f2 + f4 / 3.0f - 0.5f, f3, 1.0f, -16762458);
        } else {
            uut.round(drawContext, f, f2, f3, f4, f5, -14729329);
            uut.line(drawContext, f + 1.0f, f2 + 1.0f, f + f3 - 1.0f, f2 + f4 - 1.0f, 2.2f, -1);
            uut.line(drawContext, f + f3 - 1.0f, f2 + 1.0f, f + 1.0f, f2 + f4 - 1.0f, 2.2f, -1);
            uut.line(drawContext, f + 1.0f, f2 + 1.0f, f + f3 - 1.0f, f2 + f4 - 1.0f, 0.9f, -3665874);
            uut.line(drawContext, f + f3 - 1.0f, f2 + 1.0f, f + 1.0f, f2 + f4 - 1.0f, 0.9f, -3665874);
            uut.rect(drawContext, f + f3 * 0.5f - 2.0f, f2, 4.0f, f4, -1);
            uut.rect(drawContext, f, f2 + f4 * 0.5f - 2.0f, f3, 4.0f, -1);
            uut.rect(drawContext, f + f3 * 0.5f - 1.1f, f2, 2.2f, f4, -3665874);
            uut.rect(drawContext, f, f2 + f4 * 0.5f - 1.1f, f3, 2.2f, -3665874);
        }
        uut.outline(drawContext, f, f2, f3, f4, f5, 0.8f, 0x30000000);
    }

    private void ied(int n) {
        if (this.idn) {
            return;
        }
        wap.set(idh[n]);
        hyz.saveLater();
        this.close();
    }

    public boolean mouseClicked(Click click, boolean doubled) {
        if (this.idn || click.button() != 0) {
            return true;
        }
        float f = (float)((click.x() - (double)this.ids) / (double)this.idr);
        float f2 = (float)((click.y() - (double)this.idt) / (double)this.idr);
        for (int i = 0; i < idh.length; ++i) {
            if (!irr.inside(f, f2, this.idz(i), 52.0f, this.idy(), 64.0f)) continue;
            this.ied(i);
            return true;
        }
        return true;
    }

    public boolean keyPressed(KeyInput input) {
        int n = input.key();
        if (this.idn) {
            return true;
        }
        switch (n) {
            case 263: 
            case 265: {
                this.idm = 0;
                break;
            }
            case 258: 
            case 262: 
            case 264: {
                this.idm = this.idm == 0 ? 1 : 0;
                break;
            }
            case 32: 
            case 257: 
            case 335: {
                this.ied(this.idm);
                break;
            }
            case 256: {
                this.close();
                break;
            }
        }
        return true;
    }

    public void close() {
        if (!this.idn) {
            this.idn = true;
            this.idj.backward();
        }
    }

    public void removed() {
        vdn.setRenderScale(1.0f);
    }

    public boolean shouldPause() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    private static /* synthetic */ int afm(int n, int n2) {
        return n + n2 ^ 0x62769FFE;
    }

    private static /* synthetic */ int afn(int n, int n2) {
        return ida.afm(n, n2) ^ 0x8C525F8;
    }
}

