/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Widget;
import a.iom;
import a.Theme;
import a.UiKit;
import a.isn;
import a.WallpaperManager;
import a.ColorUtil;
import a.GpuTexture;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Locale;
import net.minecraft.class_332;

final class ThemePicker
extends Widget {
    private static final float iqq = 54.0f;
    private static final float iqr = 6.0f;
    private static final float iqs = 27.0f;
    private static final float iqt = 10.0f;
    private static final float iqu = 13.0f;
    private static final String[] iqv = new String[]{"Flow", "Dark", "Colour", "Light", "Light & glass", "Custom"};
    private final int[] iqw;
    private final Spring[] iqx;
    private final Spring[] iqy;
    private static /* synthetic */ String iqz;
    private static /* synthetic */ long ira;

    ThemePicker() {
        super(Theme.PRESET);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (String string : iqv) {
            if (string.equals("Custom")) {
                arrayList.add(-1);
                continue;
            }
            for (int i = 0; i < Theme.PRESETS.length; ++i) {
                if (!Theme.PRESETS[i].group().equals(string)) continue;
                arrayList.add(i);
            }
        }
        this.iqw = arrayList.stream().mapToInt(Integer::intValue).toArray();
        this.iqx = new Spring[this.iqw.length];
        this.iqy = new Spring[this.iqw.length];
        for (int i = 0; i < this.iqw.length; ++i) {
            this.iqx[i] = new Spring(16.0f);
            this.iqy[i] = new Spring(14.0f, this.irc(i).equals(Theme.PRESET.get()) ? 1.0f : 0.0f);
        }
    }

    private iom irb(int n) {
        return this.iqw[n] < 0 ? Theme.custom() : Theme.PRESETS[this.iqw[n]];
    }

    private String irc(int n) {
        return this.iqw[n] < 0 ? "Custom" : Theme.PRESETS[this.iqw[n]].name();
    }

    private String ird(int n) {
        return this.iqw[n] < 0 ? "Custom" : Theme.PRESETS[this.iqw[n]].group();
    }

    /*
     * Exception decompiling
     */
    private static String ire(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private int irf() {
        float f = this.w > 0.0f ? this.w : 376.0f;
        return Math.max(3, (int)((f + 6.0f) / 60.0f));
    }

    private float irg() {
        int n = this.irf();
        return (this.w - 6.0f * (float)(n - 1)) / (float)n;
    }

    private float irh(float[] fArray, float[] fArray2) {
        int n = this.irf();
        float f = this.w > 0.0f ? this.irg() : 54.0f;
        float f2 = 1.0f;
        String string = null;
        int n2 = 0;
        for (int i = 0; i < this.iqw.length; ++i) {
            if (!this.ird(i).equals(string)) {
                if (string != null) {
                    f2 += 45.0f;
                }
                string = this.ird(i);
                f2 += 13.0f;
                n2 = 0;
            } else if (n2 == n) {
                f2 += 43.0f;
                n2 = 0;
            }
            if (fArray != null) {
                fArray[i] = (float)n2 * (f + 6.0f);
                fArray2[i] = f2;
            }
            ++n2;
        }
        return f2 + 27.0f + 10.0f;
    }

    @Override
    float height() {
        return this.irh(null, null);
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float[] fArray = new float[this.iqw.length];
        float[] fArray2 = new float[this.iqw.length];
        this.irh(fArray, fArray2);
        float f4 = this.irg();
        String string = null;
        for (int i = 0; i < this.iqw.length; ++i) {
            String string2;
            GpuTexture uok2;
            iom iom2 = this.irb(i);
            boolean bl = this.iqw[i] < 0;
            float f5 = this.x + fArray[i];
            float f6 = this.y + fArray2[i];
            if (!this.ird(i).equals(string)) {
                string = this.ird(i);
                UiKit.SMALL.draw(class_3322, ThemePicker.ire(string).toUpperCase(Locale.ROOT), this.x, UiKit.SMALL.centerTop(f6 - 6.5f), Theme.textMuted);
            }
            float f7 = this.iqx[i].step(hlc2.canHover() && UiKit.inside(f, f2, f5, f6, f4, 37.0f), f3);
            float f8 = this.iqy[i].step(this.irc(i).equals(Theme.PRESET.get()), f3);
            float f9 = f6 - f7;
            float f10 = Theme.r(5.0f);
            int[] nArray = iom2.accent();
            if (f8 > 0.01f) {
                DrawUtil.shadow(class_3322, f5, f9, f4, 27.0f, f10, 7.0f, Theme.accent((int)(70.0f * f8)));
            }
            GpuTexture uok3 = uok2 = (string2 = Theme.wallpaperOf(iom2.name())) != null ? ThemePicker.iri(string2) : null;
            if (uok2 != null) {
                DrawUtil.image(class_3322, uok2.view, f5, f9, f4, 27.0f, f10, -1);
                DrawUtil.round(class_3322, f5, f9, f4, 27.0f, f10, ColorUtil.withAlpha(iom2.color(0), 70));
            } else if (iom2.isGlass()) {
                GpuTexture uok4 = ThemePicker.irj();
                if (uok4 != null) {
                    DrawUtil.image(class_3322, uok4.view, f5, f9, f4, 27.0f, f10, -1);
                } else {
                    DrawUtil.gradient(class_3322, f5, f9, f4, 27.0f, f10, -10842642, -4160260, -757066, -13058568);
                }
                DrawUtil.round(class_3322, f5, f9, f4, 27.0f, f10, ColorUtil.withAlpha(iom2.color(0), Math.round(204.0f * iom2.tintScale())));
            } else {
                DrawUtil.round(class_3322, f5, f9, f4, 27.0f, f10, ColorUtil.withAlpha(iom2.color(0), 255));
            }
            float f11 = f4 * 0.3f;
            DrawUtil.round(class_3322, f5, f9, f11, 27.0f, f10, 0.0f, 0.0f, f10, iom2.color(1));
            DrawUtil.round(class_3322, f5 + 3.0f, f9 + 5.0f, f11 - 6.0f, 4.0f, 1.5f, ColorUtil.withAlpha(nArray[0], 200));
            DrawUtil.round(class_3322, f5 + 3.0f, f9 + 11.0f, f11 - 8.0f, 2.5f, 1.2f, ColorUtil.withAlpha(iom2.color(10), 160));
            DrawUtil.round(class_3322, f5 + 3.0f, f9 + 16.0f, f11 - 9.0f, 2.5f, 1.2f, ColorUtil.withAlpha(iom2.color(10), 160));
            float f12 = f5 + f11 + 3.0f;
            float f13 = (f4 - f11 - 9.0f) * 0.5f;
            int n = ColorUtil.withAlpha(iom2.color(2), Math.max(60, ColorUtil.alpha(iom2.color(2))));
            DrawUtil.round(class_3322, f12, f9 + 5.0f, f13, 17.0f, 2.0f, n);
            DrawUtil.round(class_3322, f12 + f13 + 3.0f, f9 + 5.0f, f13, 10.200001f, 2.0f, n);
            DrawUtil.round(class_3322, f12 + 2.5f, f9 + 8.0f, f13 - 5.0f, 2.0f, 1.0f, ColorUtil.withAlpha(iom2.color(8), 150));
            DrawUtil.gradientH(class_3322, f12 + f13 - 7.0f, f9 + 12.0f, 5.0f, 3.0f, 1.5f, nArray[0], nArray[1]);
            DrawUtil.outline(class_3322, f5, f9, f4, 27.0f, f10, 1.0f, ColorUtil.lerp(ColorUtil.lerp(Theme.stroke, Theme.textMuted, f7 * 0.5f), Theme.accent(), f8));
            if (bl) {
                IconRenderer.draw(class_3322, Icon.PENCIL, f5 + f4 - 6.0f, f9 + 27.0f - 6.0f, 6.5f, iom2.light() ? -1340071896 : -788529153);
            } else if (iom2.isGlass()) {
                IconRenderer.draw(class_3322, Icon.GLASS, f5 + f4 - 6.0f, f9 + 27.0f - 6.0f, 6.5f, iom2.light() ? -1340071896 : -788529153);
            }
            if (f7 > 0.5f) {
                hlc2.hint(bl ? Lang.s("Custom  ·  your colours, edit them in Custom theme", "Своя  ·  ваши цвета, меняются в «Своя тема»") : (string2 != null ? Theme.shownName(iom2.name()) + Lang.s("  ·  with the animated Flow logo behind the window", "  ·  с живым логотипом Flow за окном") : Theme.shownName(iom2.name()) + (iom2.isGlass() ? Lang.s("  ·  glass theme: the wallpaper shows through", "  ·  стеклянная тема: обои просвечивают") : "")));
            }
            if (f8 > 0.02f) {
                float f14 = f5 + f4 - 5.5f;
                float f15 = f9 + 5.5f;
                float f16 = Easing.outBack(f8);
                DrawUtil.pushAlpha(f8);
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f14, f15);
                class_3322.method_51448().scale(f16, f16);
                DrawUtil.circle(class_3322, 0.0f, 0.0f, 3.8f, Theme.accent());
                IconRenderer.draw(class_3322, Icon.CHECK, 0.0f, 0.0f, 5.5f, Theme.onAccent());
                class_3322.method_51448().popMatrix();
                DrawUtil.popAlpha();
            }
            UiKit.SMALL.drawCentered(class_3322, UiKit.SMALL.ellipsize(Theme.shownName(this.irc(i)), f4), f5 + f4 * 0.5f, UiKit.SMALL.centerTop(f6 + 27.0f + 5.0f + 1.0f), ColorUtil.lerp(ColorUtil.lerp(Theme.textMuted, Theme.textDim, f7), Theme.text, f8));
        }
    }

    private static GpuTexture iri(String string) {
        isn isn2 = WallpaperManager.find(string);
        return isn2 == null ? null : WallpaperManager.thumbnail(isn2);
    }

    private static GpuTexture irj() {
        isn isn2 = WallpaperManager.find(WallpaperManager.selected());
        return isn2 == null || isn2.isWorld() ? null : WallpaperManager.thumbnail(isn2);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float[] fArray = new float[this.iqw.length];
        float[] fArray2 = new float[this.iqw.length];
        this.irh(fArray, fArray2);
        float f3 = this.irg();
        for (int i = 0; i < this.iqw.length; ++i) {
            if (!UiKit.inside(f, f2, this.x + fArray[i], this.y + fArray2[i], f3, 37.0f)) continue;
            Theme.choose(this.irc(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int ait(int n, int n2) {
        return n ^ n2 ^ 0xAF26D433;
    }
}

