/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.Widget;
import a.UiKit;
import a.Spring;
import a.Icon;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class ChangeNotice
extends Widget {
    private static final int ifk = 6;
    private static final float ifl = 24.0f;
    private static final float ifm = 2.0f;
    private static final float ifn = 16.0f;
    private static final float ifo = 18.0f;
    private final Map<Integer, Spring[]> ifp = new HashMap<Integer, Spring[]>();
    private static /* synthetic */ int ifq;
    private static /* synthetic */ String ifr;

    ChangeNotice() {
        super(null);
    }

    private static List<class_1657> ifs() {
        class_310 class_3102 = class_310.method_1551();
        ArrayList<class_1657> arrayList = new ArrayList<class_1657>();
        if (class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return arrayList;
        }
        for (class_1657 class_16573 : class_3102.field_1687.method_18456()) {
            if (class_16573 == class_3102.field_1724 || class_16573.method_7325()) continue;
            arrayList.add(class_16573);
        }
        arrayList.sort(Comparator.comparingDouble(class_16572 -> class_16572.method_5858((class_1297)class_3102.field_1724)));
        return arrayList.size() > 6 ? arrayList.subList(0, 6) : arrayList;
    }

    @Override
    float height() {
        int n = ChangeNotice.ifs().size();
        return n == 0 ? 30.0f : 2.0f + (float)n * 26.0f;
    }

    private float ift(int n) {
        return this.y + 2.0f + (float)n * 26.0f;
    }

    private float ifu() {
        return this.x + this.w - 5.0f - 18.0f;
    }

    /*
     * Exception decompiling
     */
    @Override
    void render(class_332 var1_1, ClickGuiScreen var2_2, float var3_3, float var4_4, float var5_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.UnsupportedOperationException
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.NewAnonymousArray.getDimSize(NewAnonymousArray.java:142)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.isNewArrayLambda(LambdaRewriter.java:455)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:409)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:167)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:105)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExpressionRewriterHelper.applyForwards(ExpressionRewriterHelper.java:12)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractMemberFunctionInvokation.applyExpressionRewriterToArgs(AbstractMemberFunctionInvokation.java:101)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractMemberFunctionInvokation.applyExpressionRewriter(AbstractMemberFunctionInvokation.java:88)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:103)
         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredAssignment.rewriteExpressions(StructuredAssignment.java:146)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewrite(LambdaRewriter.java:88)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.rewriteLambdas(Op04StructuredStatement.java:1137)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:912)
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
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        List<class_1657> list = ChangeNotice.ifs();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.ift(i);
            if (!UiKit.inside(f, f2, this.x, f3, this.w, 24.0f)) continue;
            if (n == 0) {
                String string = Friends.nameOf(list.get(i));
                boolean bl = Friends.toggle(string);
                hlc2.toast(bl ? Lang.s("Added ", "Добавлен ") + string : Lang.s("Removed ", "Удалён ") + string, bl ? Icon.FRIENDS : Icon.TRASH, false);
            }
            return true;
        }
        return false;
    }

    private static /* synthetic */ int aga(int n, int n2) {
        return n ^ n2 | 0xD3FB5E6C;
    }

    private static /* synthetic */ int agb(int n, int n2) {
        return n - n2 | 0x55831142;
    }
}

