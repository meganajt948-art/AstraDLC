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
import a.hyj;
import a.imn;
import a.iov;
import a.irr;
import a.lsx;
import a.ubg;
import a.ubm;
import a.ucg;
import a.ujt;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import a.wkw;
import flow.dev.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

final class ild
extends imn {
    private static final float ile = 26.0f;
    private static final float ilf = 3.0f;
    private static final float ilg = 16.0f;
    private static final float ilh = 18.0f;
    private static final float ili = 24.0f;
    private static final float ilj = 58.0f;
    private final Map<String, vcj[]> ilk = new HashMap<String, vcj[]>();
    private final vcj ill = new vcj(16.0f);
    private String ilm;
    private long iln;
    private static /* synthetic */ long ilo;
    private static /* synthetic */ boolean ilp;

    ild() {
        super(null);
    }

    private static List<ubg> ilq() {
        return ucg.invites();
    }

    private static List<ubm> ilr() {
        return ucg.inParty() ? ucg.members() : List.of();
    }

    @Override
    float height() {
        int n = ild.ilq().size() + ild.ilr().size();
        if (n == 0) {
            return 58.0f;
        }
        return 2.0f + (float)n * 29.0f + (ucg.inParty() ? 24.0f : 0.0f);
    }

    private float ils(int n) {
        return this.y + 2.0f + (float)n * 29.0f;
    }

    /*
     * Exception decompiling
     */
    private vcj[] ilt(String var1_1) {
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
         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.rewriteExpressions(StructuredReturn.java:99)
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

    private float ilu() {
        return this.x + this.w - 6.0f - 18.0f;
    }

    private float ilv() {
        return this.ilu() - 18.0f - 3.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<ubg> list = ild.ilq();
        List<ubm> list2 = ild.ilr();
        if (list.isEmpty() && list2.isEmpty()) {
            this.ilk.clear();
            float f4 = this.x + this.w * 0.5f;
            uut.circle(drawContext, f4, this.y + 17.0f, 12.0f, iov.hover);
            vjf.draw(drawContext, vhz.FRIENDS, f4, this.y + 17.0f, 11.0f, iov.textMuted);
            irr.LABEL.drawCentered(drawContext, wap.s(a.d("\u80ec\uf97c\u73e0\uedc1\u6607\ue0a5\u5af0\ud30c\u4d0a\uc7e2\u402d\uba4d", -1523322881, -1523617967), a.c(-1303843131, "\uead7\u9349\u19e8\u87e3\u082c\u8a82\u30d0\ub925\u2770\ua9d1\u2a1f\ud066\u5ec6")), f4, irr.LABEL.centerTop(this.y + 38.0f), iov.textDim);
            irr.SMALL.drawCentered(drawContext, wap.s(a.d("\u7467\u0df1\u873a\u1954\u929e\u143e\uae28\u2798\ub986\u3371\ub4b6\u4edc\uc007\u59bd\ud3e4\u5551\uef5c\u6096\ufa7c\u7c79\uf592\u8fce\u0171\u9abb\u1c96\u9604\u2fbb\ua1e1\u3b17", -179794489, -1511654924), a.c(807734794, "\u0a09\u73e7\uf94c\u6736\uece9\u6a53\ud071\u59f9\uc7dc\u4d1a\ucedc\u30b9\ube1a\u27a8\uad8b\u2b79\u9526\u1ee8\u845a\u0615\u8bf7\uf1a0\u7f1e\ue0d1\u62b4\ue861\u51d8\udffe")), f4, irr.SMALL.centerTop(this.y + 49.0f), iov.textMuted);
            return;
        }
        if (this.ilm != null && System.currentTimeMillis() > this.iln) {
            this.ilm = null;
        }
        int n = 0;
        for (ubg object : list) {
            this.ilw(drawContext, hlc2, object, this.ils(n++), f, f2, f3);
        }
        for (ubm ubm2 : list2) {
            this.ilx(drawContext, hlc2, ubm2, this.ils(n++), f, f2, f3);
        }
        if (ucg.inParty()) {
            float f5 = this.ils(n) + 2.0f;
            float f4 = Math.min(this.w, 110.0f);
            float f6 = this.x + (this.w - f4) * 0.5f;
            float f7 = this.ill.step(hlc2.canHover() && irr.inside(f, f2, f6, f5, f4, 17.0f), f3);
            irr.secondaryButton(drawContext, wap.s(a.b("\u046f\u7df7\uf720\u6946\ue282\u6476\ude75\u5795\uc9d9\u436e\uc4b0", -1211890648), a.c(682252374, "\u5c49\u25a1\uaf00\u310a\ubaa7\u380e\u8645\u0fbb\u95f3\u1b5d\u9c81\u6682\ue82f")), vhz.LOGIN, f6, f5, f4, 17.0f, f7, 0.0f);
        }
    }

    private void ilw(DrawContext drawContext, hlc hlc2, ubg ubg2, float f, float f2, float f3, float f4) {
        vcj[] vcjArray = this.ilt(a.c(-120173457, "\u4c04\u35e6") + ubg2.party);
        float f5 = vcq.outCubic(vcjArray[0].step(1.0f, f4));
        boolean bl = hlc2.canHover() && irr.inside(f2, f3, this.x, f, this.w, 26.0f);
        float f6 = vcjArray[1].step(bl, f4);
        uut.pushAlpha(f5);
        float f7 = iov.r(6.0f);
        int n = iov.accent() | 0xFF000000;
        uut.round(drawContext, this.x, f, this.w, 26.0f, f7, ujt.withAlpha(n, Math.round(34.0f + 20.0f * f6)));
        uut.outline(drawContext, this.x, f, this.w, 26.0f, f7, 1.0f, ujt.withAlpha(n, 90));
        float f8 = f + 13.0f;
        hyj.face(drawContext, ubg2.name, hhf.skinOf(ubg2.name), this.x + 5.0f, f8 - 8.0f, false);
        float f9 = this.x + 5.0f + 16.0f + 7.0f;
        float f10 = this.ilv() - f9 - 4.0f;
        irr.CARD_TITLE.draw(drawContext, irr.CARD_TITLE.ellipsize(lsx.protect(ubg2.name), f10), f9, irr.CARD_TITLE.centerTop(f8 - 4.0f), iov.text);
        long l = Math.max(0L, (ubg2.until - System.currentTimeMillis()) / 1000L);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.c(-139622589, "\u871a\ufe8c\u7447\uea29\u61e3\ue743\u5d06\ud4a4\u4aa2\uc005\u47cc\ubde8\u333f\uaa19\u20dd\ua62c"), a.b("\u51e5\u287d\ua2a2\u3cb0\ub774\u35a7\u8be6\u0605\u9c45\u16fb\u915a\u6b51\ue19e\u782f\uf2eb\u748d\ucec2", 1072911843)) + l + wap.s(a.c(683811894, "\u2444"), a.d("\ufd36", -1670501306, -290335440)), f10), f9, irr.SMALL.centerTop(f8 + 5.0f), n);
        boolean bl2 = hlc2.canHover() && irr.inside(f2, f3, this.ilv(), f8 - 9.0f, 18.0f, 18.0f);
        boolean bl3 = hlc2.canHover() && irr.inside(f2, f3, this.ilu(), f8 - 9.0f, 18.0f, 18.0f);
        float f11 = vcjArray[2].step(bl2, f4);
        uut.round(drawContext, this.ilv(), f8 - 9.0f, 18.0f, 18.0f, iov.r(4.0f), ujt.withAlpha(-11870592, Math.round(60.0f + 80.0f * f11)));
        vjf.draw(drawContext, vhz.CHECK, this.ilv() + 9.0f, f8, 7.5f, -1);
        irr.iconButton(drawContext, vhz.CLOSE, this.ilu(), f8 - 9.0f, 18.0f, vcjArray[3].step(bl3, f4), false, 1.0f);
        if (bl && !bl2 && !bl3) {
            hlc2.hint(wap.s(a.b("\uc29a\ubb05\u31ca\uafe2\u2473\ua2cd\u1899\u9161\u0f3c\u859a\u024b\uf838\u76f4\uef42\u650b\ue3ae", 1612038849), a.c(1122027293, "\uc313\ubafe\u3050\uae2b\u258e\ua348\u1969\u90e4\u0ebf\u8014\u03dd\uf9ad\u770f\ueeb7\u6493\ue672")) + ubg2.fingerprint + wap.s(a.d("\u252e\u5c85\ud617\u4874\uc3bb\u4541\uff46\u76ab\ue8f9\u6240\ue5de\u1ffb\u9137\u08c9\u82d9\u0424\ube6a\u31b3\uab0f\u2d45\ua4ad\udeb1\u504b\ucb87", 529235210, -1108191226), a.b("\u51d5\u287e\ua6b2\u38c2\ub314\u35da\u8ff7\u0679\u985f\u1294\u9530\u6b54\ue197\u7852\uf202\u7483\ucecf\u450e\udba2\u5df2\ud40f\uae28\u20eb\ubb3d\u3d37\ub792\u0e2d\u8006\u1aff", -1083289102)));
        }
        if (bl2) {
            hlc2.hint(wap.s(a.b("\uab15\ud281\u5854\uc622\u4dbb", 942058330), a.b("\u61b8\u185a\u928a\u0cfa\u8751\u01e7\ubbce\u3231\ua802\u26a1\ua560\u5b0e\ud5d6\u4c15\uc63c\u44d5", -1263114822)) + ubg2.name);
        } else if (bl3) {
            hlc2.hint(wap.s(a.c(737394, "\u4031\u39a1\ub374\u2d0a\ua6d8\u206e\u9a36"), a.d("\u888a\uf167\u7bcc\ue5bc\u6e6e\ue8dc\u528a\udb01\u4550", -1946326419, -204216592)));
        }
        uut.popAlpha();
    }

    private void ilx(DrawContext drawContext, hlc hlc2, ubm ubm2, float f, float f2, float f3, float f4) {
        int n;
        String string;
        vcj[] vcjArray = this.ilt(a.d("\u10ab\u694d", -1335554178, 1029644218) + ubm2.code);
        float f5 = vcq.outCubic(vcjArray[0].step(1.0f, f4));
        boolean bl = hlc2.canHover() && irr.inside(f2, f3, this.x, f, this.w, 26.0f);
        float f6 = vcjArray[1].step(bl, f4);
        uut.pushAlpha(f5);
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate((1.0f - f5) * 18.0f, 0.0f);
        float f7 = iov.r(6.0f);
        uut.round(drawContext, this.x, f, this.w, 26.0f, f7, ujt.withAlpha(iov.hover, (int)((float)ujt.alpha(iov.hover) * (0.6f + 1.4f * f6))));
        float f8 = f + 13.0f;
        boolean bl2 = ubm2.code.equals(ucg.code());
        hyj.face(drawContext, ubm2.name, hhf.skinOf(ubm2.name), this.x + 5.0f, f8 - 8.0f, ubm2.online);
        uut.round(drawContext, this.x + 1.5f, f8 - 6.0f, 2.0f, 12.0f, 1.0f, ubm2.color | 0xFF000000);
        float f9 = this.x + 5.0f + 16.0f + 7.0f;
        float f10 = this.ilu() - f9 - 4.0f;
        boolean bl3 = ubm2.code.equals(ucg.leader());
        float f11 = irr.CARD_TITLE.draw(drawContext, irr.CARD_TITLE.ellipsize(lsx.protect(ubm2.name), f10 - (bl3 ? 12.0f : 0.0f)), f9, irr.CARD_TITLE.centerTop(f8 - 4.0f), iov.text);
        if (bl3) {
            vjf.draw(drawContext, vhz.CROWN, f11 + 6.0f, f8 - 4.0f, 7.0f, -340971);
        }
        PlayerEntity playerEntity = hhf.inWorld(ubm2.name);
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (bl2) {
            string = wap.s(a.c(-378557454, "\uaba8\ud22f\u58e6"), a.d("\uae80\ud768", 414255808, -1320378288));
            n = -11870592;
        } else if (ubm2.sealed) {
            string = wap.s(a.b("\ucb72\ub2e2\u387e\ua644\u2d9d\uab30\u113a\u9892\u06d1\u8c71", -1395078346), a.b("\uab38\ud2a1\u5805\uc216\u4ddb\ucb6b\u714d\uf8b5\u669d", -389697748));
            n = -429290;
        } else if (!ubm2.online) {
            string = wap.s(a.b("\ua488\udd10\u57c3\uc9b8\u426a\uc4dc\u7e84", 1468835008), a.b("\u40f5\u396c\ub7aa\u2dc9\ua20c\u20dc\u9afb\u137d\u8d58", 1529496801));
            n = iov.textMuted;
        } else if (playerEntity != null && minecraftClient.field_1724 != null) {
            string = wap.s(a.b("\u79a59\u8afd\u149b\u9f09\u19b8\ua37c\u2a1a\ub445", -1075021340), a.b("\u20a3\u597d\ud3d5\u4dae\uc67b\u44d6\ufe85\u77e3\ue92b\u639a", 1905468553)) + wkw.formatDistance(Math.sqrt(minecraftClient.field_1724.method_5858((Entity)playerEntity)));
            n = -11870592;
        } else if (ucg.sameWorld(ubm2)) {
            string = wap.s(a.d("\ueefb\u976b\u1df6\u83d3\u0818\u8ea8\u34e1\ubd43\u234f\ua9e8\u2e2c\ud459\u5a9d\uc33b", 296163623, 1806104477), a.c(-1114316876, "\udba6\ua23a\u2cf9\ub6e5\u3d3d\ubbf0\u01a1\u8c4c\u1672\u9cb7\u1b11\ue112\u6fc2\uf606\u7c20"));
            n = ujt.lerp(-11870592, iov.textDim, 0.4f);
        } else if (ubm2.world == null) {
            string = wap.s(a.b("\u0343\u7ad3\uf002\u6e76\ue5a6\u631c\ud90a\u50fb\uce33\u4415\uc3c6\u39fe\ub72e\u2ed1\ua4d6\u223b\u9879\u17ed\u8d13\u0b4a\u82b6\uf8fc", -2014117094), a.d("\u84a2\uf921\u7793\ue996\u6236\ue4fd\u5ab6\ud347\u4d8f\uc7a9\u407a\ube19\u34dc\ua971\u232b\ua5d2\u1fee", -1321396043, 488085524));
            n = iov.textDim;
        } else {
            string = wap.s(a.d("\ude17\ua787\u2d56\ub322\u38f2\ube48\u045e\u8daf\u1367\u9941\u1e92", 405513335, 1868200484), a.b("\ucfe2\ub261\u3cd3\ua2d6\u2976\uafbd\u11f6\u9807\u06cf\u8ce9\u0b3a", -968242181)) + ild.ily(ubm2.world);
            n = iov.textDim;
        }
        uut.circle(drawContext, f9 + 1.6f, f8 + 5.0f, 1.6f, n);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, f10 - 6.0f), f9 + 5.5f, irr.SMALL.centerTop(f8 + 5.0f), n);
        if (bl && ubm2.fingerprint != null) {
            hlc2.hint((bl2 ? wap.s(a.d("\u2503\u5c84\ud64d\u483b\uc3be\u4544\uff19\u76f4\ue8f2", -2101602005, 635976824), a.d("\u95b9\uec2a\u6681\ufc98\u7355\uf5e5\u4fc3\uc63b\u5c03", -1906789718, -1510333688)) : wap.s(a.c(1916800255, "\u0ca4\u753b\ufff4\u61dc\uea4d\u6cf3\ud6a7\u5f5f\uc102\u4ba4\ucc75\u3606\ub8ca\u217c\uab35\u2d90"), a.b("\u3be1\u420c\uc8a2\u56d9\udd7c\u5bba\ue19b\u6816\uf64d\u78e6\ufb2f\u015f\u8ffd\u1645\u9c61\u1e80", 580272111))) + ubm2.fingerprint + (bl2 ? "" : wap.s(a.d("\u8915\uf0be\u7a2e\ue453\u6f86\ue92a\u5368\uda8a\u44c2\uce36\u49b2\ub3dd\u3d17\ua4ba\u2ea1", 1908501749, 1609164245) + ubm2.name, a.c(1277928117, "\ua283\udb28\u559a\ucb98\u4048\uc68c\u7cd3\uf52c\u6b04\ue5a0\u6612\u9802") + ubm2.name)));
        }
        if (ucg.isLeader() && !bl2) {
            boolean bl4 = ubm2.code.equals(this.ilm);
            float f12 = this.ilu() + (1.0f - f6) * 6.0f;
            boolean bl5 = hlc2.canHover() && irr.inside(f2, f3, f12, f8 - 9.0f, 18.0f, 18.0f);
            irr.iconButton(drawContext, vhz.CLOSE, f12, f8 - 9.0f, 18.0f, vcjArray[2].step(bl5, f4), bl4, bl4 ? 1.0f : f6);
            if (bl5 && f6 > 0.5f) {
                hlc2.hint(bl4 ? wap.s(a.c(-1966408401, "\ufd7a\u84e4\u0e32\u9049\u1b96\u9d6c\u277e\uae89\u30d0\uba69\u3dbd\uc782\u4901\ud0ab\u5ab7\udc14\u664c\ue995\u7324\uf56c\u7c88\u069c"), a.c(235409942, "\u161a\u6ff7\ue53c\u7f3c\uf08b\u764a\ucc1e\u41f4\udfa7\u5171\ud6a7\u2caa\ua272\u3bb9\ub581\u3768\u8d5e\u02f4\u9846\u1e62\u979c\uedb2\u637b\uf8a4\u7ab7")) + ubm2.name : wap.s(a.d("\udd4d\ua4cb\u2e10\ub063\u3bad\ubd0f\u0719\u8eae\u10e5\u9a49\u1d98\ue7a4\u6927\uf08a\u7ad4\ufc60\u467f\uc9bf\u531f\ud548\u5cb2", 1296676872, -534878974), a.c(130650745, "\u9670\uef98\u6530\ufb40\u70e2\uf65a\u4c76\uc5fd\u5bac\ud571\u56ba\uacc4\u2604\ubbaa\u31f6\ub775\u0d40")));
            }
        }
        drawContext.method_51448().popMatrix();
        uut.popAlpha();
    }

    private static String ily(String string) {
        if (string.startsWith(a.c(-988806947, "\u00b3\u791f\uf386"))) {
            return string.substring(3);
        }
        if (string.startsWith(a.b("\u648a\u1d38\u97a1", -218471174))) {
            return wap.s(a.b("\u40d4\u397f\ub3ab\u2dd3\ua60f\u20b7\u9af1\u131c\u8d4e\u07e7\u8028\u7a4e", 771506347), a.b("\ua549\udcf2\u562d\uc859\u438d\uc545\u7f6c\uf690\u68b0\ue66e\u65a5\u9fdf\u117b\u88ba", 1054318969));
        }
        return string;
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        float f3;
        if (n != 0) {
            return this.hovered(f, f2);
        }
        List<ubg> list = ild.ilq();
        List<ubm> list2 = ild.ilr();
        int n2 = 0;
        for (ubg object : List.copyOf(list)) {
            f3 = this.ils(n2++) + 13.0f;
            if (irr.inside(f, f2, this.ilv(), f3 - 9.0f, 18.0f, 18.0f)) {
                if (!ucg.online()) {
                    hlc2.toast(wap.s(a.c(-200927750, "\u1595\u6c05\ue6cd\u78e8\uf37c\u75c1\ucf93\u4662\ud836\u5281\ud545\u2f25\ua1f3\u3806\ub201\u34eb\u8eeb\u016e\u9bc1\u1d9d\u942f\uee2e\u608c\ufb4e\u7d37\uf7eb\u4e01\uc003\u5ae2\udca4\u5713\ua9d1\u2389"), a.d("\u36b9\u4f20\uc584\u5f97\ud021\u56e3\ueccd\u6544\ufb14\u75bd\uf60f\u081f\u82a9\u1b6c\u914a\u17c9\uad81\u2225\ub8e8\u3ebb\ub350\ucd1e\u43a2\ud801\u5e04", -1739446594, -2024467453)), vhz.INFO, true);
                    return true;
                }
                ucg.accept(object);
                return true;
            }
            if (!irr.inside(f, f2, this.ilu(), f3 - 9.0f, 18.0f, 18.0f)) continue;
            ucg.decline(object);
            return true;
        }
        for (ubm ubm2 : List.copyOf(list2)) {
            f3 = this.ils(n2++) + 13.0f;
            if (!ucg.isLeader() || ubm2.code.equals(ucg.code()) || !irr.inside(f, f2, this.ilu(), f3 - 9.0f, 18.0f, 18.0f)) continue;
            if (ubm2.code.equals(this.ilm)) {
                this.ilm = null;
                ucg.kick(ubm2);
            } else {
                this.ilm = ubm2.code;
                this.iln = System.currentTimeMillis() + 2500L;
            }
            return true;
        }
        if (ucg.inParty()) {
            float f4 = this.ils(n2) + 2.0f;
            float f5 = Math.min(this.w, 110.0f);
            f3 = this.x + (this.w - f5) * 0.5f;
            if (irr.inside(f, f2, f3, f4, f5, 17.0f)) {
                ucg.leave();
                return true;
            }
        }
        return this.hovered(f, f2);
    }

    private static /* synthetic */ int ahe(int n, int n2) {
        return n + n2 ^ 0x19FAE651;
    }

    private static /* synthetic */ int ahf(int n, int n2) {
        return ild.ahe(n, n2) ^ 0xEDE8B522;
    }
}

