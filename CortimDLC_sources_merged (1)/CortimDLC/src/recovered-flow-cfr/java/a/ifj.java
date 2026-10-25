/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 */
package a;

import a.hhf;
import a.hlc;
import a.imn;
import a.irr;
import a.vcj;
import a.vhz;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

final class ifj
extends imn {
    private static final int ifk = 6;
    private static final float ifl = 24.0f;
    private static final float ifm = 2.0f;
    private static final float ifn = 16.0f;
    private static final float ifo = 18.0f;
    private final Map<Integer, vcj[]> ifp = new HashMap<Integer, vcj[]>();
    private static /* synthetic */ int ifq;
    private static /* synthetic */ String ifr;

    ifj() {
        super(null);
    }

    private static List<PlayerEntity> ifs() {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        ArrayList<PlayerEntity> arrayList = new ArrayList<PlayerEntity>();
        if (minecraftClient.field_1687 == null || minecraftClient.field_1724 == null) {
            return arrayList;
        }
        for (PlayerEntity playerEntity2 : minecraftClient.field_1687.method_18456()) {
            if (playerEntity2 == minecraftClient.field_1724 || playerEntity2.method_7325()) continue;
            arrayList.add(playerEntity2);
        }
        arrayList.sort(Comparator.comparingDouble(playerEntity -> playerEntity.method_5858((Entity)minecraftClient.field_1724)));
        return arrayList.size() > 6 ? arrayList.subList(0, 6) : arrayList;
    }

    @Override
    float height() {
        int n = ifj.ifs().size();
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
    void render(DrawContext var1_1, hlc var2_2, float var3_3, float var4_4, float var5_5) {
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
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        List<PlayerEntity> list = ifj.ifs();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.ift(i);
            if (!irr.inside(f, f2, this.x, f3, this.w, 24.0f)) continue;
            if (n == 0) {
                String string = hhf.nameOf(list.get(i));
                boolean bl = hhf.toggle(string);
                hlc2.toast(bl ? wap.s(a.c(2106396642, "\u0fa5\u7631\ufce2\u6292\ue944\u6fb1"), a.d("\u9578\uece3\u663f\uf84f\u739a\uf522\u4f7f\uc686\u5cc4", 1401265260, -1967059703)) + string : wap.s(a.d("\ubc0e\uc588\u4f53\ud120\u5aee\udc4c\u661e\uefab", -972813567, -79644843), a.b("\u526a\u2bcc\ua11b\u3f61\ub4dc\u3201\u8c4f", -913090994)) + string, bl ? vhz.FRIENDS : vhz.TRASH, false);
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

