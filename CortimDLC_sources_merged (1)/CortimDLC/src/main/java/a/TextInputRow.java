/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.TextField;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.TextSetting;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_332;

final class TextInputRow
extends Widget {
    private static final float inv = 22.0f;
    private static final float inw = 8.0f;
    private static final float inx = 16.0f;
    private final TextSetting iny;
    private final TextField inz;
    private String ioa = "";
    private String iob = "";
    private float ioc;
    private static /* synthetic */ String iod;
    private static /* synthetic */ boolean ioe;

    TextInputRow(TextSetting vmu2) {
        super(vmu2);
        this.iny = vmu2;
        this.inz = new TextField("", null, vmu2.maxLength(), TextField.ANY);
        this.inz.setText(vmu2.get());
        this.inz.onChange = vmu2::set;
    }

    @Override
    float height() {
        return this.iof() == null ? 22.0f : 30.0f;
    }

    /*
     * Exception decompiling
     */
    private String iof() {
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

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        if (hlc2.focusedField() != this.inz && !this.inz.text.equals(this.iny.get())) {
            this.inz.setText(this.iny.get());
        }
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.y + 11.0f;
        String string = Lang.t(this.setting.getName());
        UiKit.LABEL.draw(class_3322, string, this.x, UiKit.LABEL.centerTop(f5), ColorUtil.lerp(Theme.textDim, Theme.text, f4));
        float f6 = Math.min(this.w * 0.58f, Math.max(90.0f, this.w - UiKit.LABEL.width(string) - 12.0f));
        this.inz.x = this.x + this.w - f6;
        this.inz.y = f5 - 8.0f;
        this.inz.w = f6;
        this.inz.h = 16.0f;
        this.inz.render(class_3322, hlc2, f, f2, f3);
        String string2 = this.iof();
        if (string2 != null) {
            String string3 = Lang.s("Example: ", "Пример: ") + string2;
            if (!string3.equals(this.ioa) || f6 != this.ioc) {
                this.ioa = string3;
                this.ioc = f6;
                this.iob = UiKit.SMALL.ellipsize(string3, f6 - 6.0f);
            }
            UiKit.SMALL.draw(class_3322, this.iob, this.inz.x + 6.0f, UiKit.SMALL.centerTop(this.y + 22.0f + 4.0f - 1.5f), Theme.textMuted);
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        return this.inz.mouseClicked(hlc2, f, f2, n);
    }

    private static /* synthetic */ int aif(int n, int n2) {
        return n * n2 | 0x2D383260;
    }

    private static /* synthetic */ int aig(int n, int n2) {
        return TextInputRow.aif(n, n2) ^ 0x756907DE;
    }
}

