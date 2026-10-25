/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.entity.effect.StatusEffect
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.hlc;
import a.hrk;
import a.iah;
import a.ijy;
import a.iov;
import a.irr;
import a.mkl;
import a.pdr;
import a.pej;
import a.pfl;
import a.phj;
import a.phm;
import a.pig;
import a.ujt;
import a.ukf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.effect.StatusEffect;
import org.lwjgl.glfw.GLFW;

public final class hrt
extends ijy {
    private static final float hru = 470.0f;
    private static final float hrv = 336.0f;
    private static final float hrw = 12.0f;
    private static final float hrx = 30.0f;
    private static final float hry = 22.0f;
    private static final float hrz = 16.0f;
    private static final float hsa = 26.0f;
    private static final float hsb = 4.0f;
    private static final float hsc = 266.0f;
    private static final float hsd = 14.0f;
    final iah search = new iah(a.d("\ufe4b\u87cc\u0d1b\u9379\u18bf\u9e05", 1574397152, -1990026498), vhz.SEARCH, 32, iah.ANY);
    private final float hse;
    private final float hsf;
    private final vcj hsg = new vcj(16.0f);
    private final vcj hsh = new vcj(18.0f);
    private final List<hrk> hsi = new ArrayList<hrk>();
    private final List<pdr> hsj = new ArrayList<pdr>();
    private float hsk;
    private boolean hsl;
    private pdr hsm;
    private String hsn;
    private static /* synthetic */ long hso;
    private static /* synthetic */ boolean hsp;

    private hrt(float f, float f2) {
        this.hse = (f - 470.0f) * 0.5f;
        this.hsf = (f2 - 336.0f) * 0.5f;
        this.search.onChange = string -> this.hsq();
        pdr pdr2 = mkl.collecting();
        this.hsm = pdr2 != null ? pdr2 : pej.items().get(0);
        this.hsq();
    }

    public static void open() {
        Screen screen = MinecraftClient.method_1551().field_1755;
        if (screen instanceof hlc) {
            hlc hlc2 = (hlc)screen;
            hlc2.openOverlay(new hrt(540.0f, 409.0f));
        }
    }

    private void hsq() {
        this.hsj.clear();
        String string = this.search.text.toLowerCase(Locale.ROOT).trim();
        for (pdr pdr2 : pej.items()) {
            if (!string.isEmpty() && !pdr2.searchText().contains(string) && !wap.matches(pdr2.searchText(), this.search.text)) continue;
            this.hsj.add(pdr2);
        }
        this.hsk = Math.min(this.hsk, this.hsy());
    }

    private void hsr() {
        pej.changed();
    }

    @Override
    iah field() {
        return this.search;
    }

    @Override
    boolean gone() {
        return this.hsl && this.hsg.get() <= 0.01f;
    }

    @Override
    boolean closing() {
        return this.hsl;
    }

    @Override
    void close() {
        this.hsl = true;
    }

    private float hss() {
        return this.hse + 12.0f;
    }

    private float hst() {
        return this.hsf + 30.0f + 22.0f + 8.0f;
    }

    private float hsu() {
        return 336.0f - (this.hst() - this.hsf) - 16.0f - 8.0f;
    }

    private int hsv() {
        return Math.max(1, 9);
    }

    private float hsw() {
        int n = this.hsv();
        return n <= 1 ? 30.0f : 240.0f / (float)(n - 1);
    }

    private float hsx() {
        int n = (this.hsj.size() + this.hsv() - 1) / this.hsv();
        return (float)n * 30.0f - 4.0f;
    }

    private float hsy() {
        return Math.max(0.0f, this.hsx() - this.hsu());
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3, float f4, float f5) {
        boolean bl;
        float f6 = vcq.outCubic(this.hsg.step(this.hsl ? 0.0f : 1.0f, f3));
        if (f6 <= 0.01f) {
            return;
        }
        boolean bl2 = bl = !this.hsl;
        if (!bl) {
            f = -10000.0f;
            f2 = -10000.0f;
        }
        this.hsi.clear();
        this.hsn = null;
        float f7 = iov.r(10.0f);
        float f8 = iov.lightness();
        uut.round(drawContext, 0.0f, 0.0f, f4, f5, iov.r(12.0f), ujt.withAlpha(0, Math.round(110.0f * f6)));
        uut.pushAlpha(f6);
        drawContext.method_51448().pushMatrix();
        float f9 = 0.96f + 0.04f * f6;
        drawContext.method_51448().translate(this.hse + 235.0f, this.hsf + 168.0f + (1.0f - f6) * 6.0f);
        drawContext.method_51448().scale(f9, f9);
        drawContext.method_51448().translate(-(this.hse + 235.0f), -(this.hsf + 168.0f));
        uut.shadow(drawContext, this.hse, this.hsf + 4.0f, 470.0f, 336.0f, f7, 18.0f, iov.shadow);
        uut.round(drawContext, this.hse, this.hsf, 470.0f, 336.0f, f7, ujt.withAlpha(iov.window, 252));
        uut.round(drawContext, this.hse, this.hsf, 470.0f, 336.0f, f7, iov.card);
        ukf.sheen(drawContext, this.hse, this.hsf, 470.0f, 50.0f, f7, 0.8f * (1.0f - 0.7f * f8));
        uut.outline(drawContext, this.hse, this.hsf, 470.0f, 336.0f, f7, 1.0f, iov.stroke);
        ukf.rim(drawContext, this.hse, this.hsf, 470.0f, 336.0f, f7, f8, 1.0f);
        this.hsz(drawContext, f, f2);
        this.hta(drawContext, hlc2, f, f2, f3);
        this.htc(drawContext, f, f2, f3);
        this.htd(drawContext, f, f2);
        this.hti(drawContext);
        drawContext.method_51448().popMatrix();
        uut.popAlpha();
    }

    private void hsz(DrawContext drawContext, float f, float f2) {
        boolean bl;
        float f3;
        float f4;
        float f5;
        float f6 = this.hsf + 15.0f + 1.0f;
        vjf.draw(drawContext, vhz.LAYERS, this.hse + 12.0f + 5.0f, f6, 10.0f, iov.accent());
        String string = wap.s(a.b("\u41f9\u387c\ub2ae\u2cc4\ua73f\u21a2\u9bf2\u1203\u8c55\u06e2\u8126\u7b4c\uf586\u6c65\ue67a\u608e\udadb\u550d", -1134083670), a.b("\u5aa9\u2306\ua9d2\u37da\ubc72\u3ac7\u848e\u0d1e\u9375\u19c5\u9e0d\u6450\ueaab\u7319\uf94a\u7fb2\uc5fb\u4a3d\ud095\u56d9", 1088708252));
        irr.CARD_TITLE.draw(drawContext, string, this.hse + 12.0f + 16.0f, irr.CARD_TITLE.centerTop(f6), iov.text);
        String string2 = pej.activeCount() + a.d("\u6091\u192f\u93f3", 1288312977, 1741125667) + pej.items().size() + wap.s(a.d("\uc918\ub0e6\u3a34", -1637953483, -319678194), a.b("\uca00\ub7a3\u3d78\ua308", 593480228));
        float f7 = this.hse + 12.0f + 16.0f + irr.CARD_TITLE.width(string) + 8.0f + Math.max(16.0f, irr.SMALL.width(string2) + 9.0f);
        irr.drawChip(drawContext, string2, f7, f6, iov.textDim, iov.stroke, 0.0f);
        pdr pdr2 = mkl.collecting();
        if (pdr2 != null) {
            String string3 = wap.s(a.c(490863395, "\ufb6c\u82f1\u0821\u9650\u1d8e\u9b39\u217d\ua891\u36c9\ubc71\u3bff\uc194"), a.b("\u1d52\u64fc\uee20\u7058\ufbf7\u7d36\uc760\u4e98\ud4c1\u5e6a", -2088691335)) + pdr2.name();
            irr.SMALL.draw(drawContext, string3, f7 + 8.0f, irr.SMALL.centerTop(f6), iov.accent());
        }
        irr.iconButton(drawContext, vhz.CLOSE, f5, f4, f3, (bl = irr.inside(f, f2, f5 = this.hse + 470.0f - 12.0f - (f3 = 16.0f), f4 = this.hsf + (30.0f - f3) * 0.5f + 1.0f, f3, f3)) ? 1.0f : 0.0f, false, 1.0f);
        this.hsi.add(new hrk(f5, f4, f3, f3, this::close, null));
    }

    private void hta(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4 = this.hsf + 30.0f + 2.0f;
        this.search.x = this.hse + 12.0f;
        this.search.y = f4 + 3.0f;
        this.search.w = 150.0f;
        this.search.h = 16.0f;
        this.search.render(drawContext, hlc2, f, f2, f3);
        float f5 = 16.0f;
        float f6 = this.search.y;
        String[] stringArray = new String[]{wap.s(a.d("\uc1d7\ub84b\u3298\uaca5\u273d\ua18d", -586852737, 2065864687), a.c(743499507, "\ue2ed\u9b74\u11a6\u8fa2\u047c\u82b2\u389b\ub164\u2b57\ua5f4\u2254\ud851")), wap.s(a.b("\u84a1\ufd3d\u77ee\ue9d3\u624b\ue4f3\u5ea0", 183469287), a.b("\u3f02\u46ea\ucc48\u5238\ud99a\u5f22\ue50e\u6c85\uf2d4\u7c09\uffc8\u05ca\u8b69", 1301625629)), wap.s(a.c(-1949949019, "\u23f2\u5a74\ud0b1\u4ed6\uc510"), a.d("\uf118\u88b9\u021b\u9c14\u17bc", -936444091, 2007108217))};
        vhz[] vhzArray = new vhz[]{vhz.CHECK, vhz.CLOSE, vhz.RESET};
        Runnable[] runnableArray = new Runnable[]{() -> this.htb(true), () -> this.htb(false), () -> {
            pej.resetAll();
            hlc2.toast(wap.s(a.b("\u6a01\u1393\u9942\u073b\u8ca7\u0a42\ub00a\u39b4\ua7bf\u2d12\uaacc\u50f8\ude6b\u47db\ucd8b\u4b7d\uf126\u7eee\ue445\u6240\uebfb\u91af\u1f06\u84d0", -2010813861), a.c(1167128754, "\ufcbb\u852d\u0f8b\u9187\u1a2e\u9ce7\u26b7\uab5e\u3160\ubbaf\u3c7b\uc673\u48db\ud16e\u5f27\uddc9\u6787\uec48\u7298\uf4b6\u7d43\u0717\u89d8\u127e\u940c\u1ed8\ua71d")), vhz.RESET, false);
        }};
        float f7 = this.search.x + this.search.w + 8.0f;
        float f8 = (this.hse + 470.0f - 12.0f - f7 - 12.0f) / 3.0f;
        for (int i = 0; i < 3; ++i) {
            float f9 = f7 + (float)i * (f8 + 6.0f);
            boolean bl = irr.inside(f, f2, f9, f6, f8, f5);
            irr.secondaryButton(drawContext, stringArray[i], vhzArray[i], f9, f6, f8, f5, bl ? 1.0f : 0.0f, 0.0f);
            this.hsi.add(new hrk(f9, f6, f8, f5, runnableArray[i], null));
        }
    }

    private void htb(boolean bl) {
        for (pdr pdr2 : this.hsj) {
            pdr2.setActive(bl);
        }
        this.hsr();
    }

    private void htc(DrawContext drawContext, float f, float f2, float f3) {
        float f4;
        float f5 = this.hss();
        float f6 = this.hst();
        float f7 = this.hsu();
        float f8 = this.hsh.step(Math.max(0.0f, Math.min(this.hsk, this.hsy())), f3);
        int n = this.hsv();
        float f9 = this.hsw();
        pdr pdr2 = mkl.collecting();
        float f10 = iov.r(5.0f);
        uut.pushScissor(drawContext, f5 - 2.0f, f6 - 2.0f, 270.0f, f7 + 4.0f);
        for (int i = 0; i < this.hsj.size(); ++i) {
            Object object;
            pdr pdr3 = this.hsj.get(i);
            f4 = f5 + (float)(i % n) * f9;
            float f11 = f6 + (float)(i / n) * 30.0f - f8;
            if (f11 + 26.0f < f6 - 2.0f || f11 > f6 + f7 + 2.0f) continue;
            boolean bl = irr.inside(f, f2, f4, f11, 26.0f, 26.0f) && irr.inside(f, f2, f5, f6, 266.0f, f7);
            boolean bl2 = pdr3.active();
            int n2 = bl2 ? ujt.lerp(iov.field, iov.accent(), 0.22f) : iov.field;
            uut.round(drawContext, f4, f11, 26.0f, 26.0f, f10, bl ? ujt.lerp(n2, iov.fieldHover, 0.6f) : n2);
            if (pdr3 == this.hsm) {
                uut.outline(drawContext, f4, f11, 26.0f, 26.0f, f10, 1.2f, iov.accent(230));
            } else if (bl2) {
                uut.outline(drawContext, f4, f11, 26.0f, 26.0f, f10, 1.0f, iov.accent(90));
            }
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate(f4 + 5.0f, f11 + 5.0f);
            drawContext.method_51427(pdr3.icon(), 0, 0);
            drawContext.method_51448().popMatrix();
            if (!bl2) {
                uut.round(drawContext, f4, f11, 26.0f, 26.0f, f10, ujt.withAlpha(iov.window, 150));
            }
            if (pdr3.count() > 1) {
                object = String.valueOf(pdr3.count());
                irr.SMALL.drawRight(drawContext, (String)object, f4 + 26.0f - 2.0f, f11 + 26.0f - 7.5f, bl2 ? iov.text : iov.textMuted);
            }
            if (pdr3 == pdr2) {
                uut.circle(drawContext, f4 + 26.0f - 4.0f, f11 + 4.0f, 2.5f, iov.accent());
            }
            if (bl) {
                this.hsn = pdr3.name() + (bl2 ? "" : wap.s(a.d("\ue315\u9aa4\u10e0\u8e06\u05d1\u832f\u3975\ub084", 769328025, 282255524), a.d("\u73c7\u0a76\u8032\u1ed4\u9503\u17a0\uad8a\u240a\uba54\u3090\ub74a\u4d49\uc396", 113131924, 1294283390)));
            }
            object = pdr3;
            this.hsi.add(new hrk(f4, f11, 26.0f, 26.0f, () -> this.lambda$grid$4((pdr)object), () -> this.lambda$grid$5((pdr)object)));
        }
        uut.popScissor(drawContext);
        float f12 = this.hsy();
        if (f12 > 0.0f) {
            float f13 = Math.max(18.0f, f7 * f7 / this.hsx());
            f4 = f6 + (f7 - f13) * (f8 / f12);
            uut.round(drawContext, f5 + 266.0f + 4.0f, f4, 2.5f, f13, 1.25f, ujt.withAlpha(iov.textMuted, 110));
        }
    }

    private void htd(DrawContext drawContext, float f, float f2) {
        List<phm> list;
        float f3 = this.hss() + 266.0f + 14.0f;
        float f4 = this.hst();
        float f5 = this.hse + 470.0f - 12.0f - f3;
        float f6 = this.hsu();
        uut.round(drawContext, f3, f4, f5, f6, iov.r(7.0f), iov.field);
        pdr pdr2 = this.hsm;
        if (pdr2 == null) {
            return;
        }
        float f7 = f3 + 8.0f;
        float f8 = f4 + 8.0f;
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f7, f8);
        drawContext.method_51427(pdr2.icon(), 0, 0);
        drawContext.method_51448().popMatrix();
        float f9 = f7 + 22.0f;
        irr.NAME.draw(drawContext, irr.NAME.ellipsize(pdr2.name(), f5 - 34.0f), f9, irr.NAME.centerTop(f8 + 4.0f), iov.text);
        String string = pdr2.hasQuery() ? wap.s(a.c(1489735870, "\u90c5\ue962\u63b5\ufdd7\u7611\uf0ab\u4aaa\uc341"), a.c(672438366, "\u9c66\ue5d6\u6f03\uf10b\u7aa7\uf816\u425f")) + pdr2.query() : (pdr2.deepScan() ? wap.s(a.d("\u5547\u2cfd\ua623\u3856\ub390\u3534\u8f71\u0687\u988c\u1272\u95a8\u6f9f\ue11c\u78b1\uf2ef\u745b\uce52\u418c\udb24\u5d74\ud484\uae81\u2062\ubba2\u3ddb\ub708\u0ead", 2030775095, -1811907064), a.b("\u5023\u2993\ua33d\u3d31\ub6e1\u3057\u8a08\u0388\u9da7\u1717\u94dd\u6acd\ue07b\u7dd5\uf78c\u7108\ucb35\u449d\ude20\u5c14\ud182\uabd0\u2561\ubec0\u38b2\ub266\u0bab", -1150200820)) : wap.s(a.d("\ua2aa\udb10\u51ce\ucfbb\u447d\uc2d9\u789c\uf16a\u6f61\ue59c\u624c\u9826", -1504627500, -1719233007), a.b("\uec33\u95f3\u1f2c\u812a\u0a8f\u8827\u3660\ubf90\u21b2\uab1a\u2caa\ud6a2\u5807\uc5af\u4be7\ucd13\u7720", -982390685)));
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, f5 - 34.0f), f9, irr.SMALL.centerTop(f8 + 12.5f), iov.textMuted);
        float f10 = f4 + 30.0f;
        float f11 = f3 + 8.0f;
        float f12 = f5 - 16.0f;
        uut.rect(drawContext, f11, f10 - 3.0f, f12, 1.0f, iov.divider);
        boolean bl = irr.inside(f, f2, f11, f10, f12, 14.0f);
        irr.LABEL.draw(drawContext, wap.s(a.d("\u1dd9\u645f\uee80", 1229833796, 1776344028), a.d("\ud41e\uad8e\u2759\ub951\u32fa\ub444\u0e65\u879a", 475041440, 2100977321)), f11, irr.LABEL.centerTop(f10 + 7.0f), bl ? iov.text : iov.textDim);
        irr.drawSwitch(drawContext, f11 + f12 - 17.0f, f10 + 2.25f, pdr2.active() ? 1.0f : 0.0f, bl ? 1.0f : 0.0f);
        this.hsi.add(new hrk(f11, f10, f12, 14.0f, () -> {
            pdr2.setActive(!pdr2.active());
            this.hsr();
        }, null));
        f10 += 17.0f;
        if (pdr2.stackable()) {
            irr.LABEL.draw(drawContext, wap.s(a.c(2010725865, "\u3da6\u4439\uceea\u508e"), a.c(-110722323, "\u86fe\uff6e\u75c8\uebcf\u601e\ue6dd\u5c80")), f11, irr.LABEL.centerTop(f10 + 7.0f), iov.textDim);
            this.hth(drawContext, f, f2, f11 + f12, f10, String.valueOf(pdr2.count()), () -> {
                pdr2.setCount(pdr2.count() - hrt.hte(pdr2));
                this.hsr();
            }, () -> {
                pdr2.setCount(pdr2.count() + hrt.hte(pdr2));
                this.hsr();
            });
            f10 += 17.0f;
        }
        if (!(list = pdr2.shownRules()).isEmpty()) {
            f10 = this.htg(drawContext, wap.s(a.d("\u136f\u6af2\ue020\u7e5b\uf581\u732d\uc963\u4094\udeca\u5466", -405987232, 15741766), a.d("\u5b74\u22a7\ua80e\u367a\ubda1\u3b1a\u813e", -1962051645, 1551313043)), f11, f10, f12);
            for (phm object : list) {
                int n;
                boolean bl4 = object.state() == phj.ON;
                boolean bl2 = irr.inside(f, f2, f11, f10, f12 - (object.hasLevel() ? 44.0f : 0.0f), 14.0f);
                float f13 = 3.0f;
                uut.circle(drawContext, f11 + f13, f10 + 7.0f, f13, bl4 ? iov.accent() : ujt.withAlpha(iov.textMuted, 120));
                String string2 = object.label();
                if (object.hasLevel()) {
                    n = string2.lastIndexOf(32);
                    String string3 = string2 = n > 0 ? string2.substring(0, n) : string2;
                }
                n = bl4 ? (bl2 ? iov.text : iov.textDim) : iov.textMuted;
                irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(string2, f12 - 56.0f), f11 + 10.0f, irr.LABEL.centerTop(f10 + 7.0f), n);
                this.hsi.add(new hrk(f11, f10, f12 - (object.hasLevel() ? 44.0f : 0.0f), 14.0f, () -> {
                    object.setState(object.state() == phj.ON ? phj.OFF : phj.ON);
                    this.hsr();
                }, null));
                if (object.hasLevel() && bl4) {
                    String string4 = object.isEnchant() ? String.valueOf(object.level()) : pfl.roman(object.level());
                    this.hth(drawContext, f, f2, f11 + f12, f10, string4, () -> {
                        object.setLevel(object.level() - 1);
                        this.hsr();
                    }, () -> {
                        object.setLevel(object.level() + 1);
                        this.hsr();
                    });
                }
                f10 += 14.0f;
            }
            f10 += 3.0f;
        }
        if (pdr2.hasEffects()) {
            f10 = this.htg(drawContext, wap.s(a.b("\ud483\uad11\u27c2\ub9b0\u3261\ub4c7\u0e93\u8731\u1966\u939e\u1440\uee31\u60aa\uf954\u730e\uf5b9\u4fa2\uc06f\u5ad1\udc88\u553e\u2f63\ua195\u3a59\ubc3f\u36ec\u8f48\u0101\u9be3\u1de2", 99734744), a.b("\u2fc6\u561e\udccd\u42cd\uc915\u4fdc\uf586\u781c\ue64b\u68e0\uef40\u1545\u9f8b\u0636\u8805\u0e8a\ub4c9\u3b17\ua1a7\u23e8\uae7d\ud45e\u5ae7\uc134\u4746\uc98b", 946023409)), f11, f10, f12);
            for (pig pig2 : pdr2.effects()) {
                String string5 = ((StatusEffect)pig2.effect().comp_349()).method_5560().getString() + a.b("\u9ef2", -82207021) + pfl.roman(pig2.level());
                String string6 = pig2.duration() > 0 ? hrt.htf(pig2.duration()) : "";
                irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(string5, f12 - 30.0f), f11 + 2.0f, irr.LABEL.centerTop(f10 + 7.0f), iov.textDim);
                irr.SMALL.drawRight(drawContext, string6, f11 + f12, irr.SMALL.centerTop(f10 + 7.0f), iov.textMuted);
                f10 += 13.0f;
            }
        }
        if (pdr2.hasAttrs()) {
            f10 = this.htg(drawContext, wap.s(a.c(1448036758, "\u49d8\u3040\uba89\u24e3\uaf3e\u29cb\u93da\u1a30"), a.d("\ue6a4\u9f34\u15e6\u8b9eC\u86ff\u3ccd\ub52f\u2b73\ua1cc", -477069972, -464150564)), f11, f10, f12);
            irr.SMALL.draw(drawContext, wap.s(a.c(590188363, "\u8f35\uf699\u7c4d\ue26f\u69f9\uef5d\u550e\udcf9\u42bd\uc807\u4fc3\ub5b3\u3b75\ua281\u289f\uae6c\u1428\u9bf4\u0148\u8716\u0eed\u74ab\ufa19"), a.c(-169664450, "\u2416\u5da6\ud36b\u4907\uc2dd\u446d\ufe31\u77be\ue9e2\u6730\ue486\u1e82\u9025\u09e4\u83bd\u0534\ubf0c\u30a8\uaa63\u2c4b\ua5bf\udf94\u5125")), f11 + 2.0f, irr.SMALL.centerTop(f10 + 7.0f), iov.textDim);
        }
        if (pdr2.changed()) {
            float f14 = 15.0f;
            float f15 = f4 + f6 - f14 - 7.0f;
            boolean bl3 = irr.inside(f, f2, f11, f15, f12, f14);
            irr.secondaryButton(drawContext, wap.s(a.d("\ue8d0\u9156\u1b93\u85f4\u0e32\u88d7\u32cd\ubb21\u256f\uafd6", 1612784797, -307770347), a.d("\u2d83\u5422\ude80\u408f\ucb27\u4def\uf7c6\u7e39\ue40a\u6aa4\ued08\u170c\u99dac\u8a39\u0cbf", 267562617, -1650489397)), vhz.RESET, f11, f15, f12, f14, bl3 ? 1.0f : 0.0f, 0.0f);
            this.hsi.add(new hrk(f11, f15, f12, f14, () -> {
                pdr2.reset();
                this.hsr();
            }, null));
        }
    }

    private static int hte(pdr pdr2) {
        long l = MinecraftClient.method_1551().method_22683().method_4490();
        boolean bl = GLFW.glfwGetKey((long)l, (int)340) == 1 || GLFW.glfwGetKey((long)l, (int)344) == 1;
        return bl && pdr2.maxCount() > 16 ? 8 : 1;
    }

    private static String htf(int n) {
        int n2 = n / 20;
        return n2 / 60 + a.c(-421161944, "\u9413") + String.format(Locale.ROOT, a.b("\u2dab\u540f\udede\u40f9", 1565732234), n2 % 60);
    }

    private float htg(DrawContext drawContext, String string, float f, float f2, float f3) {
        irr.SECTION.draw(drawContext, string.toUpperCase(Locale.ROOT), f, irr.SECTION.centerTop(f2 + 6.0f), iov.textMuted);
        return f2 + 12.0f;
    }

    private void hth(DrawContext drawContext, float f, float f2, float f3, float f4, String string, Runnable runnable, Runnable runnable2) {
        float f5 = 12.0f;
        float f6 = 18.0f;
        float f7 = f3 - f5;
        float f8 = f7 - f6;
        float f9 = f8 - f5;
        float f10 = f4 + (14.0f - f5) * 0.5f;
        boolean bl = irr.inside(f, f2, f9, f10, f5, f5);
        boolean bl2 = irr.inside(f, f2, f7, f10, f5, f5);
        uut.round(drawContext, f9, f10, f5, f5, iov.r(3.0f), bl ? iov.fieldHover : iov.card);
        uut.round(drawContext, f7, f10, f5, f5, iov.r(3.0f), bl2 ? iov.fieldHover : iov.card);
        irr.VALUE.drawCentered(drawContext, a.d("\ud019", -407300061, -39204842), f9 + f5 * 0.5f, irr.VALUE.centerTop(f10 + f5 * 0.5f), bl ? iov.text : iov.textDim);
        vjf.draw(drawContext, vhz.PLUS, f7 + f5 * 0.5f, f10 + f5 * 0.5f, 6.0f, bl2 ? iov.text : iov.textDim);
        irr.VALUE.drawCentered(drawContext, string, f8 + f6 * 0.5f, irr.VALUE.centerTop(f10 + f5 * 0.5f), iov.text);
        this.hsi.add(new hrk(f9, f10, f5, f5, runnable, null));
        this.hsi.add(new hrk(f7, f10, f5, f5, runnable2, null));
    }

    private void hti(DrawContext drawContext) {
        float f = this.hsf + 336.0f - 8.0f - 5.0f;
        uut.rect(drawContext, this.hse + 12.0f, this.hsf + 336.0f - 16.0f - 8.0f, 446.0f, 1.0f, iov.divider);
        String string = this.hsn != null ? this.hsn : wap.s(a.c(-1334442806, "\u04cc\u7d52\uf784\u69ff\ue220\u64da\ufebd\u5778\uc963\u43d3\uc411\u3e75\ub0aa\u291e\ua352\u25f0\u9fbf\u10f9\u8add\u0c8c\u8529\uff63\u71de\uea00\u6c63\ue6e6\u5f16\ud148\u4bba\ucde1\u465a\ub8c0\u12bb\uab7e\u2d62\ua7d2\u184b\u9235\u14e9\u8d17\u0741\u79b0\uf3a5\u7414\uee54\u60b2\ud961\u53a3\ud5d7\u4e07\uc07b\u3ab8\ub35b\u3501\uaff9\u21a7\u9a17\u3ef4\u96b5\u0f37\u8187\ufbc7\u7c21\uf673\u68ef\ue11c\u5b54\uddfc\u57b3"), a.d("\uc409\ubd99\u3749\ua93a\u26f7\u8072\u1a15\u97f9\u09ab\u836b\u04bb\ufec8\u7061\ue9d7\u6387\ue574\u5b23\ud4f2\u4ed6\uc810\u41e7\u3f89\ub13f\u2ae8\ua8ab\u024e\u9bc9\u118a\u8b75\u0d25\u828d\u7c53\uf613\u6bf0\uedda\u671a\ud8cc\u56a6\ud075\u4953\uc39b\ubd6a\u374a\ub0c0\u2a16\ua468\u1da9\u974c\u1108\u8ad2\u04ae\ufe70\u55f5\uf196\u6f0d\ue124\u5a98\ud85a\u5231", -1606027465, -85510369));
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, 446.0f), this.hse + 12.0f, irr.SMALL.centerTop(f), this.hsn != null ? iov.text : iov.textMuted);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (this.hsl) {
            return true;
        }
        if (!irr.inside(f, f2, this.hse, this.hsf, 470.0f, 336.0f)) {
            this.close();
            return true;
        }
        if (this.search.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        hlc2.focus(null);
        for (int i = this.hsi.size() - 1; i >= 0; --i) {
            Runnable runnable;
            hrk hrk2 = this.hsi.get(i);
            if (!irr.inside(f, f2, hrk2.x(), hrk2.y(), hrk2.w(), hrk2.h())) continue;
            Runnable runnable2 = n == 1 ? hrk2.right() : (runnable = n == 0 ? hrk2.left() : null);
            if (runnable == null) continue;
            runnable.run();
            return true;
        }
        return true;
    }

    @Override
    void scrolled(double d) {
        this.hsk = Math.max(0.0f, Math.min(this.hsy(), this.hsk - (float)d * 30.0f * 2.0f));
    }

    @Override
    boolean keyPressed(hlc hlc2, int n, int n2) {
        if (n == 256) {
            if (hlc2.focusedField() == this.search && !this.search.text.isEmpty()) {
                this.search.setText("");
            } else {
                this.close();
            }
            return true;
        }
        if (hlc2.focusedField() == this.search) {
            this.search.keyPressed(hlc2, n, n2);
            return true;
        }
        if ((n2 & 2) != 0 && n == 70) {
            hlc2.focus(this.search);
        }
        return true;
    }

    private /* synthetic */ void lambda$grid$5(pdr pdr2) {
        pdr2.setActive(!pdr2.active());
        this.hsm = pdr2;
        this.hsr();
    }

    private /* synthetic */ void lambda$grid$4(pdr pdr2) {
        this.hsm = pdr2;
    }

    private static /* synthetic */ int acd(int n, int n2) {
        return n * n2 | 0xAD235F0B;
    }

    private static /* synthetic */ int ace(int n, int n2) {
        return n * n2 ^ 0x34ECD24C;
    }

    private static /* synthetic */ int acf(int n, int n2) {
        return hrt.ace(n, n2) + n;
    }
}

