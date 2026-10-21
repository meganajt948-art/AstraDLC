/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_3675
 *  net.minecraft.class_437
 */
package a;

import a.ClickGuiScreen;
import a.GuiConfig;
import a.Theme;
import a.Hud;
import a.jbj;
import a.HudWidget;
import a.ColorUtil;
import a.GlassDraw;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Tween;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1041;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_437;

public final class HudEditorScreen
extends class_437 {
    private static final float jbt = 22.0f;
    private static final float jbu = 14.0f;
    private final Tween jbv = new Tween(0.25f, 0.0f);
    private final Map<HudWidget, Spring> jbw = new IdentityHashMap<HudWidget, Spring>();
    private final Map<String, Spring> jbx = new HashMap<String, Spring>();
    private final List<jbj> jby = new ArrayList<jbj>();
    private float jbz;
    private float jca;
    private float jcb;
    private HudWidget jcc;
    private HudWidget jcd;
    private float jce;
    private float jcf;
    private float jcg = Float.NaN;
    private float jch = Float.NaN;
    private long jci = -1L;
    private float jcj = 0.016666668f;
    private static /* synthetic */ String jck;
    private static /* synthetic */ int jcl;

    public HudEditorScreen() {
        super((class_2561)class_2561.method_43470((String)"HUD editor"));
    }

    private void jcm(class_332 class_3322) {
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() != this.jci) {
            this.jci = FrameDelta.frame();
            this.jcj = FrameDelta.delta() * (float)Theme.ANIMATION.get();
            this.jbv.update(this.jcj);
        }
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
        float f2;
        DrawUtil.beginFrame();
        this.jcm(class_3322);
        float f3 = Easing.outCubic(this.jbv.linear());
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, ColorUtil.withAlpha(0, Math.round(80.0f * f3)));
        float f4 = this.field_22787 != null ? (float)Math.max(1, this.field_22787.method_22683().method_4495()) : 2.0f;
        float f5 = 1.0f / f4;
        int n3 = ColorUtil.withAlpha(0xFFFFFF, Math.round(9.0f * f3));
        for (f2 = (float)this.field_22789 * 0.5f % 24.0f; f2 < (float)this.field_22789; f2 += 24.0f) {
            DrawUtil.rect(class_3322, f2, 0.0f, f5, this.field_22790, n3);
        }
        for (f2 = (float)this.field_22790 * 0.5f % 24.0f; f2 < (float)this.field_22790; f2 += 24.0f) {
            DrawUtil.rect(class_3322, 0.0f, f2, this.field_22789, f5, n3);
        }
        int n4 = Theme.accent(Math.round(40.0f * f3));
        DrawUtil.rect(class_3322, (float)this.field_22789 * 0.5f, 0.0f, f5, this.field_22790, n4);
        DrawUtil.rect(class_3322, 0.0f, (float)this.field_22790 * 0.5f, this.field_22789, f5, n4);
        Hud.renderEditor(class_3322);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        this.jcm(class_3322);
        float f2 = Easing.outCubic(this.jbv.linear());
        DrawUtil.pushAlpha(f2);
        try {
            this.jcn(class_3322, n, n2);
            this.jco(class_3322);
            this.jcp(class_3322, n, n2);
        }
        finally {
            DrawUtil.popAlpha();
        }
    }

    private void jcn(class_332 class_3322, float f, float f2) {
        HudWidget jcs3 = this.jcc != null ? this.jcc : (Hud.resizing() != null ? Hud.resizing() : this.jcr(f, f2));
        Iterator<HudWidget> iterator = Hud.ELEMENTS.iterator();
        while (iterator.hasNext()) {
            HudWidget jcs4;
            float f3 = this.jbw.computeIfAbsent(jcs4, jcs2 -> new Spring(16.0f)).step((jcs4 = iterator.next()) == jcs3, this.jcj);
            if (jcs4.w <= 0.0f) continue;
            float f4 = Theme.r(8.0f);
            DrawUtil.outline(class_3322, jcs4.x - 2.5f, jcs4.y - 2.5f, jcs4.w + 5.0f, jcs4.h + 5.0f, f4, 1.0f, Theme.accent(Math.round(100.0f + 130.0f * f3)));
            if (!(f3 > 0.01f)) continue;
            DrawUtil.round(class_3322, jcs4.x - 2.5f, jcs4.y - 2.5f, jcs4.w + 5.0f, jcs4.h + 5.0f, f4, Theme.accent(Math.round(18.0f * f3)));
            String string = Lang.t(jcs4.name) + "  ·  " + (jcs4 == Hud.resizing() || jcs4.size != 1.0f ? Math.round(jcs4.size * 100.0f) + "%" : HudEditorScreen.jcq(jcs4));
            float f5 = Hud.SMALL.width(string) + 10.0f;
            float f6 = Math.max(2.0f, Math.min((float)this.field_22789 - f5 - 2.0f, jcs4.x + (jcs4.w - f5) * 0.5f));
            boolean bl = jcs4.y < 16.0f;
            float f7 = bl ? jcs4.y + jcs4.h + 5.0f : jcs4.y - 16.0f;
            DrawUtil.pushAlpha(f3);
            DrawUtil.round(class_3322, f6, f7, f5, 11.0f, Math.min(5.5f, Theme.r(5.5f)), Theme.accent());
            Hud.SMALL.drawCentered(class_3322, string, f6 + f5 * 0.5f, Hud.SMALL.centerTop(f7 + 5.5f), Theme.onAccent());
            DrawUtil.popAlpha();
        }
    }

    private void jco(class_332 class_3322) {
        if (this.jcc == null) {
            return;
        }
        float f = this.field_22787 != null ? (float)Math.max(1, this.field_22787.method_22683().method_4495()) : 2.0f;
        int n = Theme.accent(200);
        if (!Float.isNaN(this.jcg)) {
            DrawUtil.rect(class_3322, this.jcg - 0.5f / f, 0.0f, 1.0f / f * 1.5f, this.field_22790, n);
        }
        if (!Float.isNaN(this.jch)) {
            DrawUtil.rect(class_3322, 0.0f, this.jch - 0.5f / f, this.field_22789, 1.0f / f * 1.5f, n);
        }
    }

    private void jcp(class_332 class_3322, float f, float f2) {
        float f3;
        this.jby.clear();
        float f4 = 9.0f;
        String string2 = Lang.s("HUD editor", "Редактор HUD");
        float f5 = 13.0f + Hud.HEAD.width(string2);
        f4 += f5 + 10.0f;
        for (HudWidget jcs2 : Hud.ELEMENTS) {
            f3 = Hud.TEXT.width(Lang.t(jcs2.name)) + 17.0f;
            this.jby.add(new jbj(jcs2.name, null, jcs2.enabled::toggle, jcs2, f4, f3));
            f4 += f3 + 4.0f;
        }
        float f6 = Hud.TEXT.width(Lang.t("Reset")) + 22.0f;
        this.jby.add(new jbj("Reset", Icon.RESET, Hud::resetLayout, null, f4 += 6.0f, f6));
        float f7 = Hud.TEXT.width(Lang.t("Done")) + 22.0f;
        this.jby.add(new jbj("Done", Icon.CHECK, this::method_25419, null, f4 += f6 + 4.0f, f7));
        this.jcb = f4 += f7 + 9.0f;
        this.jbz = Math.round(((float)this.field_22789 - this.jcb) * 0.5f);
        f3 = (1.0f - Easing.outCubic(this.jbv.linear())) * 12.0f;
        this.jca = (float)this.field_22790 - 22.0f - 12.0f + f3;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(this.jbz, this.jca);
        Hud.panel(class_3322, this.jcb, 22.0f, Math.min(11.0f, Theme.r(9.0f)));
        float f8 = 11.0f;
        IconRenderer.draw(class_3322, Icon.MOVE, 13.5f, f8, 8.5f, Theme.accent());
        Hud.HEAD.draw(class_3322, string2, 22.0f, Hud.HEAD.centerTop(f8), Theme.text);
        DrawUtil.rect(class_3322, 9.0f + f5 + 4.0f, f8 - 5.0f, 1.0f, 10.0f, ColorUtil.mulAlpha(Theme.textMuted, 0.4f));
        float f9 = f - this.jbz;
        float f10 = f2 - this.jca;
        for (jbj jbj2 : this.jby) {
            int n;
            float f11 = this.jbx.computeIfAbsent(jbj2.jbk, string -> new Spring(16.0f)).step(f9 >= jbj2.jbo && f9 < jbj2.jbo + jbj2.jbp && Math.abs(f10 - f8) < 7.0f, this.jcj);
            float f12 = Math.min(7.0f, Theme.r(5.0f));
            float f13 = f8 - 7.0f;
            boolean bl = jbj2.jbk.equals("Done");
            if (bl) {
                DrawUtil.round(class_3322, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, ColorUtil.lerp(Theme.accent(), -1, 0.1f * f11));
                GlassDraw.sheen(class_3322, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, 1.6f);
            } else {
                DrawUtil.round(class_3322, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, ColorUtil.lerp(Theme.field, Theme.fieldHover, f11));
                GlassDraw.rim(class_3322, jbj2.jbo, f13, jbj2.jbp, 14.0f, f12, Theme.lightness(), 0.6f + 0.4f * f11);
            }
            int n2 = n = bl ? Theme.onAccent() : ColorUtil.lerp(Theme.textDim, Theme.text, f11);
            if (jbj2.jbn != null) {
                boolean bl2 = jbj2.jbn.enabled.get();
                DrawUtil.circle(class_3322, jbj2.jbo + 7.0f, f8, 2.0f, bl2 ? Theme.accent() : ColorUtil.mulAlpha(Theme.textMuted, 0.6f));
                Hud.TEXT.draw(class_3322, Lang.t(jbj2.jbk), jbj2.jbo + 12.0f, Hud.TEXT.centerTop(f8), bl2 ? Theme.text : ColorUtil.mulAlpha(n, 0.7f));
                continue;
            }
            IconRenderer.draw(class_3322, jbj2.jbl, jbj2.jbo + 9.0f, f8, 7.0f, n);
            Hud.TEXT.draw(class_3322, Lang.t(jbj2.jbk), jbj2.jbo + 15.0f, Hud.TEXT.centerTop(f8), n);
        }
        class_3322.method_51448().popMatrix();
        String string3 = Lang.s("Drag to move  ·  Right drag: size  ·  Alt: no snapping  ·  Double click: default  ·  Arrows nudge", "Тащите — двигать  ·  ПКМ — размер  ·  Alt — без привязки  ·  Двойной клик — по умолчанию  ·  Стрелки — сдвиг");
        Hud.SMALL.drawCentered(class_3322, string3, (float)this.field_22789 * 0.5f, Hud.SMALL.centerTop(this.jca - 7.0f), ColorUtil.withAlpha(0xFFFFFF, 150));
    }

    private static String jcq(HudWidget jcs2) {
        String string;
        String string2 = jcs2.ay == 0 ? Lang.s("top", "сверху") : (string = jcs2.ay == 1 ? Lang.s("middle", "по центру") : Lang.s("bottom", "снизу"));
        String string3 = jcs2.ax == 0 ? Lang.s("left", "слева") : (jcs2.ax == 1 ? Lang.s("centre", "по центру") : Lang.s("right", "справа"));
        return jcs2.ax == 1 && jcs2.ay == 1 ? Lang.s("centre", "по центру") : string + " " + string3;
    }

    private HudWidget jcr(double d, double d2) {
        for (int i = Hud.ELEMENTS.size() - 1; i >= 0; --i) {
            HudWidget jcs2 = Hud.ELEMENTS.get(i);
            if (!(jcs2.w > 0.0f) || !(d >= (double)(jcs2.x - 2.0f)) || !(d < (double)(jcs2.x + jcs2.w + 2.0f)) || !(d2 >= (double)(jcs2.y - 2.0f)) || !(d2 < (double)(jcs2.y + jcs2.h + 2.0f))) continue;
            return jcs2;
        }
        return null;
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        double d = class_119092.comp_4798();
        double d2 = class_119092.comp_4799();
        if (class_119092.method_74245() == 1) {
            HudWidget jcs2 = this.jcr(d, d2);
            if (jcs2 != null) {
                this.jcd = jcs2;
                Hud.startResize(jcs2, (float)d, (float)d2);
            }
            return true;
        }
        if (class_119092.method_74245() != 0) {
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
        HudWidget jcs3 = this.jcr(d, d2);
        if (jcs3 != null) {
            this.jcd = jcs3;
            if (bl) {
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

    public boolean method_25403(class_11909 class_119092, double d, double d2) {
        boolean bl;
        boolean bl2 = bl = this.field_22787 != null && (class_3675.method_15987((class_1041)this.field_22787.method_22683(), (int)342) || class_3675.method_15987((class_1041)this.field_22787.method_22683(), (int)346));
        if (Hud.resizing() != null) {
            Hud.resize((float)class_119092.comp_4798(), (float)class_119092.comp_4799(), bl);
            return true;
        }
        if (this.jcc == null) {
            return true;
        }
        float[] fArray = Hud.drag(this.jcc, (float)class_119092.comp_4798() - this.jce, (float)class_119092.comp_4799() - this.jcf, this.field_22789, this.field_22790, bl);
        this.jcg = fArray[0];
        this.jch = fArray[1];
        return true;
    }

    public boolean method_25406(class_11909 class_119092) {
        Hud.endResize();
        this.jcc = null;
        this.jcg = Float.NaN;
        this.jch = Float.NaN;
        return true;
    }

    public boolean method_25404(class_11908 class_119082) {
        int n = class_119082.comp_4795();
        if (n == 256) {
            this.method_25419();
            return true;
        }
        if (this.jcd != null && this.jcd.w > 0.0f) {
            float f;
            float f2;
            float f3;
            float f4 = f3 = (class_119082.comp_4797() & 1) != 0 ? 5.0f : 1.0f;
            float f5 = n == 263 ? -f3 : (f2 = n == 262 ? f3 : 0.0f);
            float f6 = n == 265 ? -f3 : (f = n == 264 ? f3 : 0.0f);
            if (f2 != 0.0f || f != 0.0f) {
                this.jcd.moveTo(Math.max(0.0f, Math.min((float)this.field_22789 - this.jcd.w, this.jcd.x + f2)), Math.max(0.0f, Math.min((float)this.field_22790 - this.jcd.h, this.jcd.y + f)), this.field_22789, this.field_22790);
                return true;
            }
        }
        return true;
    }

    public void method_25419() {
        if (this.field_22787 != null) {
            this.field_22787.method_1507((class_437)new ClickGuiScreen());
        }
    }

    public void method_25432() {
        GuiConfig.saveLater();
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25422() {
        return false;
    }

    private static /* synthetic */ int aln(int n, int n2) {
        return n * n2 ^ 0xD3419C56;
    }
}

