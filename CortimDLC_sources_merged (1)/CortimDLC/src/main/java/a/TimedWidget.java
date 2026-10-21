/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.Theme;
import a.Hud;
import a.HudWidget;
import a.jen;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_332;

abstract class TimedWidget<T>
extends HudWidget {
    static final float HEAD = 16.0f;
    static final float PAD = 7.0f;
    private static final float jer = 84.0f;
    private final Icon jes;
    private List<jen<T>> jet = new ArrayList<jen<T>>();
    private List<jen<T>> jeu = new ArrayList<jen<T>>();
    private final Map<String, jen<T>> jev = new HashMap<String, jen<T>>();
    private final Spring jew = new Spring(13.0f, 84.0f);
    private final Spring jex = new Spring(8.0f);
    private int jey;
    private boolean jez;
    private boolean jfa;
    private float jfb = 16.0f;
    private float jfc = 84.0f;
    private long jfd;
    private boolean jfe;
    private boolean jff;
    private static /* synthetic */ boolean jfg;
    private static /* synthetic */ String jfh;

    TimedWidget(String string, String string2, Icon vhz2, boolean bl, int n, int n2, float f, float f2) {
        super(string, string2, bl, n, n2, f, f2);
        this.jes = vhz2;
    }

    abstract List<T> items(boolean var1);

    abstract String key(T var1);

    abstract float rowHeight();

    abstract float rowWidth(T var1);

    abstract void drawRow(class_332 var1, T var2, float var3, float var4, float var5, float var6, float var7, float var8);

    long refreshNanos() {
        return 50000000L;
    }

    @Override
    void update(float f, boolean bl) {
        long l = System.nanoTime();
        boolean bl2 = this.enabled.get();
        if (l - this.jfd >= this.refreshNanos() || bl != this.jfe || bl2 != this.jff) {
            this.jfd = l;
            this.jfe = bl;
            this.jff = bl2;
            this.jfi(bl2, bl);
        }
        float f2 = 0.0f;
        for (jen<T> jen3 : this.jet) {
            float f3 = jen3.appear.step(jen3.alive, f);
            f2 += this.rowHeight() * Easing.outCubic(f3);
        }
        if (this.jet.removeIf(jen2 -> !jen2.alive && jen2.appear.get() <= 0.01f)) {
            this.jfc = this.jfj();
        }
        this.jex.step(0.0f, f);
        this.jew.step(this.jfc, f);
        this.jfb = 16.0f + (f2 > 0.05f ? f2 + 5.0f : 0.0f);
    }

    /*
     * WARNING - void declaration
     */
    private void jfi(boolean bl, boolean bl2) {
        void var5_8;
        List<Object> list = bl ? this.items(false) : List.of();
        this.jfa = false;
        if (list.isEmpty() && bl2 && bl) {
            list = this.items(true);
            this.jfa = !list.isEmpty();
        }
        this.jev.clear();
        for (jen<T> object : this.jet) {
            this.jev.put(object.key, object);
        }
        List<jen<T>> list2 = this.jeu;
        list2.clear();
        for (jen<T> jen2 : list) {
            jen<T> jen3 = this.jev.remove(this.key(jen2));
            if (jen3 == null) {
                jen3 = new jen(this.key(jen2));
            }
            jen3.item = jen2;
            jen3.alive = true;
            list2.add(jen3);
        }
        boolean bl3 = false;
        while (var5_8 < this.jet.size()) {
            jen<T> jen2;
            jen2 = this.jet.get((int)var5_8);
            if (this.jev.containsKey(jen2.key)) {
                jen2.alive = false;
                list2.add(Math.min((int)var5_8, list2.size()), jen2);
            }
            ++var5_8;
        }
        this.jeu = this.jet;
        this.jet = list2;
        int n = list.size();
        if (n != this.jey) {
            this.jey = n;
            this.jex.set(1.0f);
        }
        this.jez = n > 0;
        this.jfc = this.jfj();
    }

    private float jfj() {
        float f = Math.max(84.0f, 28.0f + Hud.HEAD.width(Lang.t(this.name)) + 22.0f);
        for (jen<T> jen2 : this.jet) {
            if (!jen2.alive) continue;
            f = Math.max(f, this.rowWidth(jen2.item) + 14.0f);
        }
        return f;
    }

    @Override
    boolean hasContent(boolean bl) {
        return this.jez;
    }

    @Override
    boolean canGhost() {
        return true;
    }

    @Override
    boolean isSample() {
        return this.jfa;
    }

    @Override
    float width() {
        return this.jew.get();
    }

    @Override
    float height() {
        return this.jfb;
    }

    @Override
    void draw(class_332 class_3322, float f, boolean bl) {
        float f2;
        float f3 = this.width();
        float f4 = this.height();
        float f5 = Theme.r(6.0f);
        Hud.panel(class_3322, f3, f4, f5);
        float f6 = 8.5f;
        IconRenderer.draw(class_3322, this.jes, 10.5f, f6, 7.0f, Theme.textMuted);
        Hud.HEAD.draw(class_3322, Lang.t(this.name), 17.5f, Hud.HEAD.centerTop(f6), Theme.textDim);
        if (this.jey > 0) {
            String string = String.valueOf(this.jey);
            f2 = this.jex.get();
            float f7 = 1.0f + 0.25f * f2;
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f3 - 7.0f - Hud.SMALL.width(string) * 0.5f, f6);
            class_3322.method_51448().scale(f7, f7);
            Hud.SMALL.drawCentered(class_3322, string, 0.0f, Hud.SMALL.centerTop(0.0f), ColorUtil.lerp(Theme.textMuted, Theme.text, f2));
            class_3322.method_51448().popMatrix();
        }
        if (f4 <= 16.5f) {
            return;
        }
        DrawUtil.pushScissor(class_3322, 0.0f, 16.0f, f3, f4 - 16.0f);
        float f8 = 18.5f;
        f2 = this.rowHeight();
        for (jen<T> jen2 : this.jet) {
            float f9 = Easing.outCubic(jen2.appear.get());
            float f10 = f2 * f9;
            if (f10 > 0.2f) {
                DrawUtil.pushAlpha(Math.min(1.0f, f9 * 1.2f));
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate((1.0f - f9) * 8.0f * this.slideSide(), 0.0f);
                this.drawRow(class_3322, jen2.item, 7.0f, f8, f3 - 14.0f, f2, f9, f);
                class_3322.method_51448().popMatrix();
                DrawUtil.popAlpha();
            }
            f8 += f10;
        }
        DrawUtil.popScissor(class_3322);
    }

    static void bar(class_332 class_3322, float f, float f2, float f3, float f4, int n, int n2) {
        float f5 = 1.5f;
        DrawUtil.round(class_3322, f, f2, f3, f5, f5 * 0.5f, Theme.track);
        float f6 = Math.max(0.0f, Math.min(1.0f, f4));
        if (f6 > 0.001f) {
            DrawUtil.gradientH(class_3322, f, f2, Math.max(f5, f3 * f6), f5, f5 * 0.5f, n, n2);
        }
    }

    static int expiring(int n, float f) {
        if (f > 10.0f || f < 0.0f) {
            return n;
        }
        float f2 = 0.5f + 0.5f * (float)Math.cos((double)System.nanoTime() / 1.0E9 * Math.PI * 2.0);
        return ColorUtil.lerp(n, -1096636, 0.35f + 0.45f * f2);
    }

    private static /* synthetic */ int amo(int n, int n2) {
        return (n ^ n2) + -1582391174;
    }

    private static /* synthetic */ int amp(int n, int n2) {
        return TimedWidget.amo(n, n2) ^ 0x772A3CD0;
    }

    private static /* synthetic */ int amq(int n, int n2) {
        return TimedWidget.amo(n, n2) ^ 0x66625011;
    }
}

