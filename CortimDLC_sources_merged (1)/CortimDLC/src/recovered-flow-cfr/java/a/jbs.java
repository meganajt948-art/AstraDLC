/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.Window
 *  net.minecraft.text.Text
 */
package a;

import a.hlc;
import a.hyz;
import a.iov;
import a.izx;
import a.jbj;
import a.jcs;
import a.ujt;
import a.ukf;
import a.unf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdc;
import a.vhz;
import a.vjf;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.Window;
import net.minecraft.text.Text;

public final class jbs
extends Screen {
    private static final float jbt = 22.0f;
    private static final float jbu = 14.0f;
    private final vdc jbv = new vdc(0.25f, 0.0f);
    private final Map<jcs, vcj> jbw = new IdentityHashMap<jcs, vcj>();
    private final Map<String, vcj> jbx = new HashMap<String, vcj>();
    private final List<jbj> jby = new ArrayList<jbj>();
    private float jbz;
    private float jca;
    private float jcb;
    private jcs jcc;
    private jcs jcd;
    private float jce;
    private float jcf;
    private float jcg = Float.NaN;
    private float jch = Float.NaN;
    private long jci = -1L;
    private float jcj = 0.016666668f;
    private static /* synthetic */ String jck;
    private static /* synthetic */ int jcl;

    public jbs() {
        super((Text)Text.literal((String)a.c(-1011260187, "\u64a7\u1d0b\u97c9\u09dc\u824e\u04fe\ubea0\u374c\ua908\u23a4")));
    }

    private void jcm(DrawContext drawContext) {
        unf.observe(drawContext);
        if (unf.frame() != this.jci) {
            this.jci = unf.frame();
            this.jcj = unf.delta() * (float)iov.ANIMATION.get();
            this.jbv.update(this.jcj);
        }
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        float f;
        uut.beginFrame();
        this.jcm(context);
        float f2 = vcq.outCubic(this.jbv.linear());
        uut.rect(context, 0.0f, 0.0f, this.width, this.height, ujt.withAlpha(0, Math.round(80.0f * f2)));
        float f3 = this.client != null ? (float)Math.max(1, this.client.getWindow().getScaleFactor()) : 2.0f;
        float f4 = 1.0f / f3;
        int n = ujt.withAlpha(0xFFFFFF, Math.round(9.0f * f2));
        for (f = (float)this.width * 0.5f % 24.0f; f < (float)this.width; f += 24.0f) {
            uut.rect(context, f, 0.0f, f4, this.height, n);
        }
        for (f = (float)this.height * 0.5f % 24.0f; f < (float)this.height; f += 24.0f) {
            uut.rect(context, 0.0f, f, this.width, f4, n);
        }
        int n2 = iov.accent(Math.round(40.0f * f2));
        uut.rect(context, (float)this.width * 0.5f, 0.0f, f4, this.height, n2);
        uut.rect(context, 0.0f, (float)this.height * 0.5f, this.width, f4, n2);
        izx.renderEditor(context);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        this.jcm(context);
        float f = vcq.outCubic(this.jbv.linear());
        uut.pushAlpha(f);
        try {
            this.jcn(context, mouseX, mouseY);
            this.jco(context);
            this.jcp(context, mouseX, mouseY);
        }
        finally {
            uut.popAlpha();
        }
    }

    private void jcn(DrawContext drawContext, float f, float f2) {
        jcs jcs3 = this.jcc != null ? this.jcc : (izx.resizing() != null ? izx.resizing() : this.jcr(f, f2));
        Iterator<jcs> iterator = izx.ELEMENTS.iterator();
        while (iterator.hasNext()) {
            jcs jcs4;
            float f3 = this.jbw.computeIfAbsent(jcs4, jcs2 -> new vcj(16.0f)).step((jcs4 = iterator.next()) == jcs3, this.jcj);
            if (jcs4.w <= 0.0f) continue;
            float f4 = iov.r(8.0f);
            uut.outline(drawContext, jcs4.x - 2.5f, jcs4.y - 2.5f, jcs4.w + 5.0f, jcs4.h + 5.0f, f4, 1.0f, iov.accent(Math.round(100.0f + 130.0f * f3)));
            if (!(f3 > 0.01f)) continue;
            uut.round(drawContext, jcs4.x - 2.5f, jcs4.y - 2.5f, jcs4.w + 5.0f, jcs4.h + 5.0f, f4, iov.accent(Math.round(18.0f * f3)));
            String string = wap.t(jcs4.name) + a.c(1722438881, "\u54c4\u2d75\ua731\u39d7\ub200") + (jcs4 == izx.resizing() || jcs4.size != 1.0f ? Math.round(jcs4.size * 100.0f) + a.b("\u16f5", -1433004335) : jbs.jcq(jcs4));
            float f5 = izx.SMALL.width(string) + 10.0f;
            float f6 = Math.max(2.0f, Math.min((float)this.width - f5 - 2.0f, jcs4.x + (jcs4.w - f5) * 0.5f));
            boolean bl = jcs4.y < 16.0f;
            float f7 = bl ? jcs4.y + jcs4.h + 5.0f : jcs4.y - 16.0f;
            uut.pushAlpha(f3);
            uut.round(drawContext, f6, f7, f5, 11.0f, Math.min(5.5f, iov.r(5.5f)), iov.accent());
            izx.SMALL.drawCentered(drawContext, string, f6 + f5 * 0.5f, izx.SMALL.centerTop(f7 + 5.5f), iov.onAccent());
            uut.popAlpha();
        }
    }

    private void jco(DrawContext drawContext) {
        if (this.jcc == null) {
            return;
        }
        float f = this.client != null ? (float)Math.max(1, this.client.getWindow().getScaleFactor()) : 2.0f;
        int n = iov.accent(200);
        if (!Float.isNaN(this.jcg)) {
            uut.rect(drawContext, this.jcg - 0.5f / f, 0.0f, 1.0f / f * 1.5f, this.height, n);
        }
        if (!Float.isNaN(this.jch)) {
            uut.rect(drawContext, 0.0f, this.jch - 0.5f / f, this.width, 1.0f / f * 1.5f, n);
        }
    }

    private void jcp(DrawContext drawContext, float f, float f2) {
        float f3;
        this.jby.clear();
        float f4 = 9.0f;
        String string2 = wap.s(a.c(-1683618636, "\u04f6\u7d5a\uf798\u698d\ue21f\u64af\udef1\u571d\uc959\u43f5"), a.c(1352254078, "\uc652\ubff6\u3524\uab51\u208c\ua645\u1c6a\u95e5\u0fda\u8503\u02cd\uf8ad"));
        float f5 = 13.0f + izx.HEAD.width(string2);
        f4 += f5 + 10.0f;
        for (jcs jcs2 : izx.ELEMENTS) {
            f3 = izx.TEXT.width(wap.t(jcs2.name)) + 17.0f;
            this.jby.add(new jbj(jcs2.name, null, jcs2.enabled::toggle, jcs2, f4, f3));
            f4 += f3 + 4.0f;
        }
        float f6 = izx.TEXT.width(wap.t(a.b("\u2aae\u5328\ud9ed\u478a\ucc4c", 1273506553))) + 22.0f;
        this.jby.add(new jbj(a.c(298688786, "\ua145\ud8c3\u5206\ucc61\u47a7"), vhz.RESET, izx::resetLayout, null, f4 += 6.0f, f6));
        float f7 = izx.TEXT.width(wap.t(a.d("\u2d05\u549f\ude4d\u4037", -1082537933, 2147345782))) + 22.0f;
        this.jby.add(new jbj(a.d("\u88f6\uf16c\u7bbe\ue5c4", -1409287148, 777614498), vhz.CHECK, this::close, null, f4 += f6 + 4.0f, f7));
        this.jcb = f4 += f7 + 9.0f;
        this.jbz = Math.round(((float)this.width - this.jcb) * 0.5f);
        f3 = (1.0f - vcq.outCubic(this.jbv.linear())) * 12.0f;
        this.jca = (float)this.height - 22.0f - 12.0f + f3;
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(this.jbz, this.jca);
        izx.panel(drawContext, this.jcb, 22.0f, Math.min(11.0f, iov.r(9.0f)));
        float f8 = 11.0f;
        vjf.draw(drawContext, vhz.MOVE, 13.5f, f8, 8.5f, iov.accent());
        izx.HEAD.draw(drawContext, string2, 22.0f, izx.HEAD.centerTop(f8), iov.text);
        uut.rect(drawContext, 9.0f + f5 + 4.0f, f8 - 5.0f, 1.0f, 10.0f, ujt.mulAlpha(iov.textMuted, 0.4f));
        float f9 = f - this.jbz;
        float f10 = f2 - this.jca;
        for (jbj jbj2 : this.jby) {
            int n;
            float f11 = this.jbx.computeIfAbsent(jbj2.jbk, string -> new vcj(16.0f)).step(f9 >= jbj2.jbo && f9 < jbj2.jbo + jbj2.jbp && Math.abs(f10 - f8) < 7.0f, this.jcj);
            float f12 = Math.min(7.0f, iov.r(5.0f));
            float f13 = f8 - 7.0f;
            boolean bl = jbj2.jbk.equals(a.d("\ue89e\u9104\u1bd6\u85ac", 2448600, 49853446));
            if (bl) {
                uut.round(drawContext, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, ujt.lerp(iov.accent(), -1, 0.1f * f11));
                ukf.sheen(drawContext, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, 1.6f);
            } else {
                uut.round(drawContext, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, ujt.lerp(iov.field, iov.fieldHover, f11));
                ukf.rim(drawContext, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, iov.lightness(), 0.6f + 0.4f * f11);
            }
            int n2 = n = bl ? iov.onAccent() : ujt.lerp(iov.textDim, iov.text, f11);
            if (jbj2.jbn != null) {
                boolean bl2 = jbj2.jbn.enabled.get();
                uut.circle(drawContext, jbj2.jbo + 7.0f, f8, 2.0f, bl2 ? iov.accent() : ujt.mulAlpha(iov.textMuted, 0.6f));
                izx.TEXT.draw(drawContext, wap.t(jbj2.jbk), jbj2.jbo + 12.0f, izx.TEXT.centerTop(f8), bl2 ? iov.text : ujt.mulAlpha(n, 0.7f));
                continue;
            }
            vjf.draw(drawContext, jbj2.jbl, jbj2.jbo + 9.0f, f8, 7.0f, n);
            izx.TEXT.draw(drawContext, wap.t(jbj2.jbk), jbj2.jbo + 15.0f, izx.TEXT.centerTop(f8), n);
        }
        drawContext.getMatrices().popMatrix();
        String string3 = wap.s(a.c(1787483494, "\ud543\uacc4\u2604\ub873\u33e3\ub506\u0f4e\u86f0\u18e2\u9251\u159b\ueff9\u616b\uf8da\u721e\uf478\u4e37\uc194\u5b1c\udd43\u54bb\u2ef6\ua011\u3b84\ubded\u372f\u8e9a\u0096\u9a7b\u1c79\u97d0\u6912\ue342\u7af6\ufca5\u7683\uc9c3\u43b2\uc500\u5c9c\ud6db\ua864\u222d\ua5d2\u3f04\ub13a\u08ba\u8216\u0456\u9f96\u11e5\ueb2d\u629d\ue4c5\u7e71\uf020\u4b08\ucd4e\u473d\ude88\u5014\u2a5f\uadbb\u27e4\ub922\u30d6\u8ac6\u0c38\u866a\u19d1\u930a\u152a\uecef\u661a\uf848\u73ba\uf5ea\u4f4f\uc685\u58ec\ud277\u5426\u2f02\ua144\u3b33\ub283\u3403\u8e52\u01b0\u9bf9\u1d4e\u94cc\u6ef5\ue03f\u7b9d\ufdcf\u7702"), a.b("\uaaf5\ud356\u59fc\uc7fc\u4c51\uca97\u74d1\udd14\u637f\uedda\u6a0f\u9074\u1ea8\u871a\u0d3b\u8bc4\u35e7\uba36\u2012\ua6d4\u2f23\u514d\udffb\u442c\uc66f\u6c8a\uf50d\u7f3c\ue5bb\u63ed\ue855\u168d\u9cb7\u0126\u8775\u0d53\ub213\u3862\ubed0\u274c\uad0b\ud3ae\u79c9\ude4c\u408a\uceff\u772e\uf988\u7bd8\ue076\u6e7d\u94a6\u1d6c\u9b45\u01bb\u8fe8\u304f\ub69e\u3c7a\ua53c\u2b8b\u55ee\ud23b\u5866\uc6ae\u4f1b\uf54b\u73bd\ufdf3\u6658\uec8a\u6af8\u9325\u1d8e\ua3e9\u082c\u8a64\u30d4\ubd19\u270b\uadbb\u2be8\u505e\udef3\u44f3\ucd2f\u4b99\uf1be\u7a2f\ue07e\u665a\uef1c\u156b\u9fbb\u046b\u8238\u0882\ub6fd\u3f2f\ua59c\u27d3\u8c16\ud271\u5ca1\uc50b\u437c\uc9a5\u761f", 1322299067));
        izx.SMALL.drawCentered(drawContext, string3, (float)this.width * 0.5f, izx.SMALL.centerTop(this.jca - 7.0f), ujt.withAlpha(0xFFFFFF, 150));
    }

    private static String jcq(jcs jcs2) {
        String string;
        String string2 = jcs2.ay == 0 ? wap.s(a.c(-905561989, "\u380c\u41a6\ucb6a"), a.c(-1371962335, "\u8066\uf9a4\u7370\ued74\u66a6\ue011")) : (string = jcs2.ay == 1 ? wap.s(a.c(1623658217, "\u0e82\u7737\ufde9\u6398\ue847\u6eff"), a.c(-1254590040, "\u7d9e\u042e\u8ae3\u10f4\u9b50\u1de9\ua7c5\u2e36\ub06a")) : wap.s(a.b("\u7bd3\u026f\u88a7\u16d6\u9d1a\u1ba9", 273185719), a.b("\ubd9f\uc452\u4e84\ud0fa\u5b59", -1327842853)));
        String string3 = jcs2.ax == 0 ? wap.s(a.c(-1572612028, "\ud82c\ua194\u2b44\ub527"), a.c(-1557588188, "\u1360\u6aab\ue076\u7e00\uf5d5")) : (jcs2.ax == 1 ? wap.s(a.b("\u1b0d\u62ba\ue862\u7609\ufdd8\u7b7e", -1856955544), a.c(-830881389, "\uc5a5\ubc15\u32d8\ua8cf\u236b\ua5d2\u1ffe\u960d\u0851")) : wap.s(a.b("\u0eaf\u7705\ufdd8\u63a6\ue86d", 1476660952), a.d("\u1099\u6956\ue3fa\u7dfb\uf62e\u709d", 836564687, -1814175215)));
        return jcs2.ax == 1 && jcs2.ay == 1 ? wap.s(a.c(-118446005, "\ua82e\ud199\u5b41\uc52a\u4efb\uc85d"), a.d("\uf953\u80e3\u0e2e\u9439\u1f9d\u9924\u2308\uaafb\u34a7", -681228886, -2125154097)) : string + a.d("\udd27", 324896593, 847862359) + string3;
    }

    private jcs jcr(double d, double d2) {
        for (int i = izx.ELEMENTS.size() - 1; i >= 0; --i) {
            jcs jcs2 = izx.ELEMENTS.get(i);
            if (!(jcs2.w > 0.0f) || !(d >= (double)(jcs2.x - 2.0f)) || !(d < (double)(jcs2.x + jcs2.w + 2.0f)) || !(d2 >= (double)(jcs2.y - 2.0f)) || !(d2 < (double)(jcs2.y + jcs2.h + 2.0f))) continue;
            return jcs2;
        }
        return null;
    }

    public boolean mouseClicked(Click click, boolean doubled) {
        double d = click.x();
        double d2 = click.y();
        if (click.button() == 1) {
            jcs jcs2 = this.jcr(d, d2);
            if (jcs2 != null) {
                this.jcd = jcs2;
                izx.startResize(jcs2, (float)d, (float)d2);
            }
            return true;
        }
        if (click.button() != 0) {
            return true;
        }
        if (d >= (double)this.jbz && d < (double)(this.jbz + this.jcb) && d2 >= (double)this.jca && d2 < (double)(this.jca + 22.0f)) {
            for (jbj jbj2 : this.jby) {
                if (!(d - (double)this.jbz >= (double)jbj2.jbo) || !(d - (double)this.jbz < (double)(jbj2.jbo + jbj2.jbp))) continue;
                jbj2.jbm.run();
                return true;
            }
            return true;
        }
        jcs jcs3 = this.jcr(d, d2);
        if (jcs3 != null) {
            this.jcd = jcs3;
            if (doubled) {
                jcs3.resetPosition();
                return true;
            }
            this.jcc = jcs3;
            this.jce = (float)d - jcs3.x;
            this.jcf = (float)d2 - jcs3.y;
            jcs3.push.set(0.0f);
        }
        return true;
    }

    public boolean mouseDragged(Click click, double offsetX, double offsetY) {
        boolean bl;
        boolean bl2 = bl = this.client != null && (InputUtil.isKeyPressed((Window)this.client.getWindow(), (int)342) || InputUtil.isKeyPressed((Window)this.client.getWindow(), (int)346));
        if (izx.resizing() != null) {
            izx.resize((float)click.x(), (float)click.y(), bl);
            return true;
        }
        if (this.jcc == null) {
            return true;
        }
        float[] fArray = izx.drag(this.jcc, (float)click.x() - this.jce, (float)click.y() - this.jcf, this.width, this.height, bl);
        this.jcg = fArray[0];
        this.jch = fArray[1];
        return true;
    }

    public boolean mouseReleased(Click click) {
        izx.endResize();
        this.jcc = null;
        this.jcg = Float.NaN;
        this.jch = Float.NaN;
        return true;
    }

    public boolean keyPressed(KeyInput input) {
        int n = input.key();
        if (n == 256) {
            this.close();
            return true;
        }
        if (this.jcd != null && this.jcd.w > 0.0f) {
            float f;
            float f2;
            float f3;
            float f4 = f3 = (input.modifiers() & 1) != 0 ? 5.0f : 1.0f;
            float f5 = n == 263 ? -f3 : (f2 = n == 262 ? f3 : 0.0f);
            float f6 = n == 265 ? -f3 : (f = n == 264 ? f3 : 0.0f);
            if (f2 != 0.0f || f != 0.0f) {
                this.jcd.moveTo(Math.max(0.0f, Math.min((float)this.width - this.jcd.w, this.jcd.x + f2)), Math.max(0.0f, Math.min((float)this.height - this.jcd.h, this.jcd.y + f)), this.width, this.height);
                return true;
            }
        }
        return true;
    }

    public void close() {
        if (this.client != null) {
            this.client.setScreen((Screen)new hlc());
        }
    }

    public void removed() {
        hyz.saveLater();
    }

    public boolean shouldPause() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    private static /* synthetic */ int aln(int n, int n2) {
        return n * n2 ^ 0xD3419C56;
    }
}

