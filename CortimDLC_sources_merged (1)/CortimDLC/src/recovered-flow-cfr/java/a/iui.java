/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.iah;
import a.imn;
import a.iov;
import a.irr;
import a.ujt;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.wap;
import a.wkq;
import a.wkw;
import a.wlk;
import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class iui
extends imn {
    private static final float iuj = 17.0f;
    private static final float iuk = 11.0f;
    final iah name = new iah(a.b("\u1483\u6d1d\ue7c2\u79bb\uf229\u7490\uce84\u476a\ud931\u539d\ud448\u2e38\ua0e0\u395c\ub34a", -219343678), vhz.PIN, 24, iah.ANY);
    final iah fx = new iah("", null, 10, iah.NUMBER);
    final iah fy = new iah("", null, 10, iah.NUMBER);
    final iah fz = new iah("", null, 10, iah.NUMBER);
    private int iul;
    private boolean ium;
    private wkq iun;
    private hlc iuo;
    private final vcj[] iup = new vcj[wlk.COLORS.length];
    private final vcj[] iuq = new vcj[wlk.COLORS.length];
    private final vcj iur = new vcj(16.0f);
    private final vcj ius = new vcj(9.0f);
    private final vcj iut = new vcj(16.0f);
    private final vcj iuu = new vcj(9.0f);
    private final vcj iuv = new vcj(16.0f);
    private final vcj iuw = new vcj(12.0f);
    private static /* synthetic */ long iux;
    private static /* synthetic */ boolean iuy;

    iui() {
        super(null);
        Runnable runnable;
        this.fx.prefix = a.c(-684341383, "\uc720");
        this.fy.prefix = a.b("\u39e9", -340182607);
        this.fz.prefix = a.b("\u21fe", -1536941659);
        this.name.next = this.fx;
        this.fx.next = this.fy;
        this.fy.next = this.fz;
        this.fz.next = this.name;
        this.name.onSubmit = runnable = this::ivg;
        this.fx.onSubmit = runnable;
        this.fy.onSubmit = runnable;
        this.fz.onSubmit = runnable;
        for (int i = 0; i < this.iup.length; ++i) {
            this.iup[i] = new vcj(16.0f);
            this.iuq[i] = new vcj(14.0f, i == 0 ? 1.0f : 0.0f);
        }
    }

    @Override
    float height() {
        return 91.0f;
    }

    private float iuz(int n) {
        return switch (n) {
            case 0 -> this.y + 4.0f;
            case 1 -> this.y + 4.0f + 17.0f + 6.0f;
            case 2 -> this.y + 4.0f + 46.0f + 2.0f;
            default -> this.y + 4.0f + 46.0f + 2.0f + 11.0f + 8.0f;
        };
    }

    private float iva(int n) {
        int n2 = wlk.COLORS.length;
        float f = (this.w - 11.0f * (float)n2) / (float)(n2 - 1);
        return this.x + (float)n * (11.0f + f);
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        this.iuo = hlc2;
        if (this.iun != null && !wlk.inWorld().contains(this.iun)) {
            this.ivc();
        }
        float f10 = this.iuw.step(this.iun != null, f3);
        this.name.x = this.x;
        this.name.y = this.iuz(0);
        this.name.w = this.w;
        this.name.h = 17.0f;
        this.name.render(drawContext, hlc2, f, f2, f3);
        float f11 = (this.w - 10.0f) / 3.0f;
        iah[] iahArray = new iah[]{this.fx, this.fy, this.fz};
        for (int i = 0; i < 3; ++i) {
            iah iah2 = iahArray[i];
            iah2.x = this.x + (float)i * (f11 + 5.0f);
            iah2.y = this.iuz(1);
            iah2.w = f11;
            iah2.h = 17.0f;
            iah2.render(drawContext, hlc2, f, f2, f3);
        }
        float f12 = this.iuz(2);
        boolean bl = !wlk.COLOR.is(a.c(-1898549601, "\u6ece\u1743\u9d9d\u03e4\u883b")) || this.ium || this.iun != null && this.iun.ownColor;
        uut.pushAlpha(bl ? 1.0f : 0.65f);
        for (int i = 0; i < wlk.COLORS.length; ++i) {
            f9 = this.iva(i);
            f8 = this.iup[i].step(hlc2.canHover() && irr.inside(f, f2, f9 - 2.0f, f12 - 2.0f, 15.0f, 15.0f), f3);
            f7 = this.iuq[i].step(i == this.iul, f3);
            int n = wlk.COLORS[i];
            f6 = f9 + 5.5f;
            f5 = f12 + 5.5f;
            if (f7 > 0.01f) {
                uut.circleOutline(drawContext, f6, f5, 7.5f, 1.2f, ujt.mulAlpha(iov.text, f7));
            }
            f4 = 3.5f * (0.9f + 0.1f * f8 + 0.08f * vcq.outBack(f7));
            wkw.bead(drawContext, f6, f5 - 0.5f * f8, f4, n);
            if (!(f8 > 0.5f) || bl) continue;
            hlc2.hint(wap.s(a.c(-331442271, "\u97ca\uee42\u649b\ufae2\u717e\uf78e\u4d9c\uc42e\u5a7d\ud0cf\u571f\uad74\u23a4\uba47\u3052\ub6aa\u0cf8\u837b\u199c\u9fd1\u1627\u6c6c\ue28c\u790d\uff6b\u75bd\ucc40\u4219\ud8a3\u5efb\ud557\u2b90\ua19a\u3822\ube6c\u3489\u8b0a\u016e\u87b7\u1e08\u9441\ueae3\u60e4\ue749\u7d93\uf3a7\u4a20\uc08d\u46cf\udd16\u536d\ua9f9\u200f\ua65c\u3caf\ub2f8\u094c\u8f87\u05a9"), a.d("\u7b14\u02fc\u8855\u1620\u9d82\u1b4b\ua162\u28e4\ub2ae\u3c79\ubbde\u41a8\ucf08\u52db\udc9c\u5a62\ue059\u6be7\uf539\u7367\ufaec\u80ba\u0a10\u95dd\u13ab\u990d\u20c6\uae95\u307a\ub623\u3980\uc754\u4d16\ud490\u52b1\udc15\u67dc\uedae\u6b70\uf6d1\u789f\u066a\u8c4c\u0bec\u9128\u1b3b\ua6f8\u2c43\uaa70\u31d2\ubfa9\u4507\uc8d2\u4ae1\ud065\u5e3d\ue5f5\u6746", -1889198289, -1373741037)));
        }
        uut.popAlpha();
        float f13 = this.iuz(3);
        f9 = 58.0f;
        f8 = 58.0f * f10;
        f7 = this.w - f9 - 6.0f - (f8 > 0.5f ? f8 + 6.0f * f10 : 0.0f);
        float f14 = this.iur.step(hlc2.canHover() && irr.inside(f, f2, this.x, f13, f9, 17.0f), f3);
        irr.secondaryButton(drawContext, wap.s(a.d("\uc5e8\ubc74\u36b0\ua8d6", 1061097762, 2053231750), a.d("\u710a\u0898\u824a\u1c4f\u9795", 1015722123, 617661843)), vhz.LOCATE, this.x, f13, f9, 17.0f, f14, this.ius.step(0.0f, f3));
        if (f14 > 0.5f) {
            hlc2.hint(wap.s(a.c(417614327, "\u4994\u300a\ubadc\u24ad\uaf36\u29ce\u939a\u1a25\u842e\u0e83\u895d\u7369\ufdfc\u6443\uee13\u68ee\ud2a9\u5d33\uc7d9\u419e\uc873\ub277\u3c85\ua747\u212f\uabbb\u125b\u9c0d\u06ef\u80b1\u0b08\uf5d4\u7f9c\ue664\u6070\uea8e\u5558"), a.d("\ub646\ucfd6\u450f\udb0b\u50df\ud61c\u6c4d\ue5b6\u7b93\uf12c\u7293\u8cf3\u022e\u9b9a\u11cd\u932a\u2969\ua2a5\u381b\uba5a\u37b7\u4de2\uc32d\u5880\ude81\u542e\ued9f\u67d2\uf937\u7f1f\uf0c7\u0a77\u803b\u19b6\u9fe3\u1528\uaa88", 1271810357, -1402537143)));
        }
        f6 = this.x + f9 + 6.0f;
        f5 = this.iut.step(hlc2.canHover() && irr.inside(f, f2, f6, f13, f7, 17.0f), f3);
        irr.primaryButton(drawContext, this.iun != null ? wap.s(a.c(-1640862377, "\u6d04\u1490\u9e57#\u8be1\u0d41"), a.b("\u0133\u78ad\uf272\u6c00\ue7db\u6160\udb49\u52b6", -1303378651)) : wap.s(a.d("\u5aac\u2338\ua9eb\u37de\ubc5e\u3af9\u80b2\u094a\u970a\u1dbd\u9a69\u6002", -1069881591, 36355560), a.b("\u8b84\uf21f\u78c3\ue6b3\u6d66\uebdd\u51f4\ud80b\u4238\ucc95\u4b4f\ub149\u3fe6\ua62e", -1933340770)), this.iun != null ? vhz.SAVE : vhz.PLUS, f6, f13, f7, 17.0f, f5, this.iuu.step(0.0f, f3));
        if (f8 > 0.5f) {
            f4 = f6 + f7 + 6.0f;
            float f15 = this.iuv.step(hlc2.canHover() && irr.inside(f, f2, f4, f13, f8, 17.0f), f3);
            uut.pushAlpha(f10);
            irr.secondaryButton(drawContext, f10 > 0.8f ? wap.s(a.c(-1257979527, "\uc13c\ub8af\u3273\uac0f\u27de\ua166"), a.b("\u13b3\u6a5e\ue0f3\u7e8b\uf554\u73e8", -209905749)) : "", vhz.CLOSE, f4, f13, f8, 17.0f, f15, 0.0f);
            uut.popAlpha();
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        float f3;
        this.iuo = hlc2;
        iah[] iahArray = new iah[]{this.name, this.fx, this.fy, this.fz};
        int n2 = iahArray.length;
        for (int i = 0; i < n2; ++i) {
            iah iah2 = iahArray[i];
            if (!iah2.mouseClicked(hlc2, f, f2, n)) continue;
            return true;
        }
        if (n != 0) {
            return false;
        }
        float f4 = this.iuz(2);
        for (n2 = 0; n2 < wlk.COLORS.length; ++n2) {
            if (!irr.inside(f, f2, this.iva(n2) - 2.0f, f4 - 2.0f, 15.0f, 15.0f)) continue;
            this.iul = n2;
            this.ium = true;
            if (this.iun != null) {
                this.iun.color = wlk.COLORS[n2];
                this.iun.ownColor = true;
                wlk.changed();
            }
            return true;
        }
        float f5 = this.iuz(3);
        if (irr.inside(f, f2, this.x, f5, f3 = 58.0f, 17.0f)) {
            this.ius.set(1.0f);
            this.ivb();
            return true;
        }
        float f6 = this.x + f3 + 6.0f;
        float f7 = this.iun != null ? 58.0f : 0.0f;
        float f8 = this.w - f3 - 6.0f - (f7 > 0.0f ? f7 + 6.0f : 0.0f);
        if (irr.inside(f, f2, f6, f5, f8, 17.0f)) {
            this.iuu.set(1.0f);
            this.ivg();
            return true;
        }
        if (this.iun != null && irr.inside(f, f2, f6 + f8 + 6.0f, f5, f7, 17.0f)) {
            this.ivc();
            return true;
        }
        return false;
    }

    private void ivb() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null) {
            return;
        }
        this.fx.setText(String.valueOf(minecraftClient.player.getBlockX()));
        this.fy.setText(String.valueOf(minecraftClient.player.getBlockY()));
        this.fz.setText(String.valueOf(minecraftClient.player.getBlockZ()));
    }

    void edit(wkq wkq2) {
        this.iun = wkq2;
        this.ium = false;
        this.name.setText(wkq2.name);
        this.fx.setText(iui.ive(wkq2.x));
        this.fy.setText(iui.ive(wkq2.y));
        this.fz.setText(iui.ive(wkq2.z));
        this.iul = 0;
        for (int i = 0; i < wlk.COLORS.length; ++i) {
            if ((wlk.COLORS[i] & 0xFFFFFF) != (wkq2.color & 0xFFFFFF)) continue;
            this.iul = i;
        }
        if (this.iuo != null) {
            this.iuo.focus(this.name);
        }
    }

    private void ivc() {
        this.iun = null;
        this.ivd();
    }

    private void ivd() {
        this.ium = false;
        this.name.setText("");
        this.fx.setText("");
        this.fy.setText("");
        this.fz.setText("");
    }

    private static String ive(double d) {
        return d == Math.floor(d) ? String.valueOf((long)d) : String.format(Locale.ROOT, a.b("\ud59c\uac26\u26ea\ub8cc", -1164192323), d);
    }

    private static Double ivf(iah iah2) {
        try {
            return iah2.text.isBlank() ? null : Double.valueOf(Double.parseDouble(iah2.text.trim()));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private void ivg() {
        String string;
        Double d = iui.ivf(this.fx);
        Double d2 = iui.ivf(this.fy);
        Double d3 = iui.ivf(this.fz);
        if (d == null || d2 == null || d3 == null) {
            for (iah iah2 : new iah[]{this.fx, this.fy, this.fz}) {
                if (iui.ivf(iah2) != null) continue;
                iah2.error();
            }
            if (this.iuo != null) {
                this.iuo.toast(wap.s(a.d("\u39d1\u404b\uca82\u54e2\udf22\u59c1\ue3ea\u6a6f\uf43c\u7ef4\uf95e\u036e\u8db6\u140d\u9e1a\u1891\ua2a8\u2d75\ub789\u31c5\ub860\uc261\u4cd0\ud716\u517f\udbae\u624e\uec77\u76ad\uf0eb\u7b4f", -540216753, 1248578500), a.d("\u246b\u5dfa\ud72e\u495e\uc285\u444e\ufe6a\u738e\ueda9\u676c\ue0b3\u1abb\u9415\u09bc\u87f7\u017c\ubb49\u3080\uaa30\u2c62\ua18d\udfc1\u517f\ucaa8\u4cdd\uc608\u7fc1\uf1e7\u6f05\ue9df\u66d0\u9822\u126c\u8be9\u0db7\u83f1", -123964942, -814853713)), vhz.LOCATE, true);
            }
            return;
        }
        String string2 = string = this.name.text.isBlank() ? wap.s(a.c(2130249442, "\u06bc\u7f3b\uf5f0\u6b88\ue040\u66f7\udca3\u5548\ucb43"), a.c(516299036, "\u1d06\u649e\uee3a\u7033\ufbee\u794f")) + (wlk.inWorld().size() + 1) : this.name.text.trim();
        if (this.iun != null) {
            this.iun.name = string;
            this.iun.x = d;
            this.iun.y = d2;
            this.iun.z = d3;
            this.iun.color = wlk.COLORS[this.iul];
            this.iun.ownColor |= this.ium;
            wlk.changed();
            this.iun = null;
            if (this.iuo != null) {
                this.iuo.toast(wap.s(a.b("\u6bac\u1238\u98ff\u068b\u8d49\u0be9\ub1bb\u380e\u866d", 161442800) + string + a.b("\u1254", 193016392), a.c(310255122, "\u1a07\u6399\ue946\u7734\ufcef\u7a57\uc00a\u49f3\ud7a1\u5900\ude58") + string + a.c(1117824997, "\ua75f")), vhz.SAVE, false);
            }
        } else {
            wkq wkq2 = wlk.add(string, d, d2, d3, wlk.COLORS[this.iul]);
            if (this.ium) {
                wkq2.ownColor = true;
                wlk.changed();
            }
            this.iul = (this.iul + 1) % wlk.COLORS.length;
            if (this.iuo != null) {
                this.iuo.toast(wap.s(a.b("\udad4\ua340\u2993\ub7e3\u3c35\ubac0\u20af", 774494866) + string + a.b("\u5cf5", -1137541911), a.b("\uf521\u8cba\u0666\u9816\u13c3\u957b\u2f26\ua6df\u388d\ub62c\u3174", 87224638) + string + a.c(421855600, "\u01ca")), vhz.PIN, false);
            }
        }
        this.ivd();
        if (this.iuo != null) {
            this.iuo.focus(null);
        }
    }

    private static /* synthetic */ int akb(int n, int n2) {
        return n + n2 + 1962299242;
    }

    private static /* synthetic */ int akc(int n, int n2) {
        return iui.akb(n, n2) + n;
    }

    private static /* synthetic */ int akd(int n, int n2) {
        return iui.akb(n, n2) ^ 0x109E4C7A;
    }
}

