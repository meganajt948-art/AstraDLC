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
import a.FriendsList;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.NameProtect;
import a.ubg;
import a.ubm;
import a.PartyClient;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import a.WaypointRenderer;
import flow.dev.StringDecryptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class PartyMembersList
extends Widget {
    private static final float ile = 26.0f;
    private static final float ilf = 3.0f;
    private static final float ilg = 16.0f;
    private static final float ilh = 18.0f;
    private static final float ili = 24.0f;
    private static final float ilj = 58.0f;
    private final Map<String, Spring[]> ilk = new HashMap<String, Spring[]>();
    private final Spring ill = new Spring(16.0f);
    private String ilm;
    private long iln;
    private static /* synthetic */ long ilo;
    private static /* synthetic */ boolean ilp;

    PartyMembersList() {
        super(null);
    }

    private static List<ubg> ilq() {
        return PartyClient.invites();
    }

    private static List<ubm> ilr() {
        return PartyClient.inParty() ? PartyClient.members() : List.of();
    }

    @Override
    float height() {
        int n = PartyMembersList.ilq().size() + PartyMembersList.ilr().size();
        if (n == 0) {
            return 58.0f;
        }
        return 2.0f + (float)n * 29.0f + (PartyClient.inParty() ? 24.0f : 0.0f);
    }

    private float ils(int n) {
        return this.y + 2.0f + (float)n * 29.0f;
    }

    /*
     * Exception decompiling
     */
    private Spring[] ilt(String var1_1) {
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
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<ubg> list = PartyMembersList.ilq();
        List<ubm> list2 = PartyMembersList.ilr();
        if (list.isEmpty() && list2.isEmpty()) {
            this.ilk.clear();
            float f4 = this.x + this.w * 0.5f;
            DrawUtil.circle(class_3322, f4, this.y + 17.0f, 12.0f, Theme.hover);
            IconRenderer.draw(class_3322, Icon.FRIENDS, f4, this.y + 17.0f, 11.0f, Theme.textMuted);
            UiKit.LABEL.drawCentered(class_3322, Lang.s("No party yet", "Пати пока нет"), f4, UiKit.LABEL.centerTop(this.y + 38.0f), Theme.textDim);
            UiKit.SMALL.drawCentered(class_3322, Lang.s("Invite a friend by their code", "Пригласите друга по его коду"), f4, UiKit.SMALL.centerTop(this.y + 49.0f), Theme.textMuted);
            return;
        }
        if (this.ilm != null && System.currentTimeMillis() > this.iln) {
            this.ilm = null;
        }
        int n = 0;
        for (ubg object : list) {
            this.ilw(class_3322, hlc2, object, this.ils(n++), f, f2, f3);
        }
        for (ubm ubm2 : list2) {
            this.ilx(class_3322, hlc2, ubm2, this.ils(n++), f, f2, f3);
        }
        if (PartyClient.inParty()) {
            float f5 = this.ils(n) + 2.0f;
            float f4 = Math.min(this.w, 110.0f);
            float f6 = this.x + (this.w - f4) * 0.5f;
            float f7 = this.ill.step(hlc2.canHover() && UiKit.inside(f, f2, f6, f5, f4, 17.0f), f3);
            UiKit.secondaryButton(class_3322, Lang.s("Leave party", "Выйти из пати"), Icon.LOGIN, f6, f5, f4, 17.0f, f7, 0.0f);
        }
    }

    private void ilw(class_332 class_3322, ClickGuiScreen hlc2, ubg ubg2, float f, float f2, float f3, float f4) {
        Spring[] vcjArray = this.ilt("i:" + ubg2.party);
        float f5 = Easing.outCubic(vcjArray[0].step(1.0f, f4));
        boolean bl = hlc2.canHover() && UiKit.inside(f2, f3, this.x, f, this.w, 26.0f);
        float f6 = vcjArray[1].step(bl, f4);
        DrawUtil.pushAlpha(f5);
        float f7 = Theme.r(6.0f);
        int n = Theme.accent() | 0xFF000000;
        DrawUtil.round(class_3322, this.x, f, this.w, 26.0f, f7, ColorUtil.withAlpha(n, Math.round(34.0f + 20.0f * f6)));
        DrawUtil.outline(class_3322, this.x, f, this.w, 26.0f, f7, 1.0f, ColorUtil.withAlpha(n, 90));
        float f8 = f + 13.0f;
        FriendsList.face(class_3322, ubg2.name, Friends.skinOf(ubg2.name), this.x + 5.0f, f8 - 8.0f, false);
        float f9 = this.x + 5.0f + 16.0f + 7.0f;
        float f10 = this.ilv() - f9 - 4.0f;
        UiKit.CARD_TITLE.draw(class_3322, UiKit.CARD_TITLE.ellipsize(NameProtect.protect(ubg2.name), f10), f9, UiKit.CARD_TITLE.centerTop(f8 - 4.0f), Theme.text);
        long l = Math.max(0L, (ubg2.until - System.currentTimeMillis()) / 1000L);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("Invites you  ·  ", "Зовёт в пати  ·  ") + l + Lang.s("s", "с"), f10), f9, UiKit.SMALL.centerTop(f8 + 5.0f), n);
        boolean bl2 = hlc2.canHover() && UiKit.inside(f2, f3, this.ilv(), f8 - 9.0f, 18.0f, 18.0f);
        boolean bl3 = hlc2.canHover() && UiKit.inside(f2, f3, this.ilu(), f8 - 9.0f, 18.0f, 18.0f);
        float f11 = vcjArray[2].step(bl2, f4);
        DrawUtil.round(class_3322, this.ilv(), f8 - 9.0f, 18.0f, 18.0f, Theme.r(4.0f), ColorUtil.withAlpha(-11870592, Math.round(60.0f + 80.0f * f11)));
        IconRenderer.draw(class_3322, Icon.CHECK, this.ilv() + 9.0f, f8, 7.5f, -1);
        UiKit.iconButton(class_3322, Icon.CLOSE, this.ilu(), f8 - 9.0f, 18.0f, vcjArray[3].step(bl3, f4), false, 1.0f);
        if (bl && !bl2 && !bl3) {
            hlc2.hint(Lang.s("Key fingerprint ", "Отпечаток ключа ") + ubg2.fingerprint + Lang.s(": ask them to confirm it", ": попросите друга подтвердить"));
        }
        if (bl2) {
            hlc2.hint(Lang.s("Join ", "Вступить в пати ") + ubg2.name);
        } else if (bl3) {
            hlc2.hint(Lang.s("Decline", "Отклонить"));
        }
        DrawUtil.popAlpha();
    }

    private void ilx(class_332 class_3322, ClickGuiScreen hlc2, ubm ubm2, float f, float f2, float f3, float f4) {
        int n;
        String string;
        Spring[] vcjArray = this.ilt("m:" + ubm2.code);
        float f5 = Easing.outCubic(vcjArray[0].step(1.0f, f4));
        boolean bl = hlc2.canHover() && UiKit.inside(f2, f3, this.x, f, this.w, 26.0f);
        float f6 = vcjArray[1].step(bl, f4);
        DrawUtil.pushAlpha(f5);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate((1.0f - f5) * 18.0f, 0.0f);
        float f7 = Theme.r(6.0f);
        DrawUtil.round(class_3322, this.x, f, this.w, 26.0f, f7, ColorUtil.withAlpha(Theme.hover, (int)((float)ColorUtil.alpha(Theme.hover) * (0.6f + 1.4f * f6))));
        float f8 = f + 13.0f;
        boolean bl2 = ubm2.code.equals(PartyClient.code());
        FriendsList.face(class_3322, ubm2.name, Friends.skinOf(ubm2.name), this.x + 5.0f, f8 - 8.0f, ubm2.online);
        DrawUtil.round(class_3322, this.x + 1.5f, f8 - 6.0f, 2.0f, 12.0f, 1.0f, ubm2.color | 0xFF000000);
        float f9 = this.x + 5.0f + 16.0f + 7.0f;
        float f10 = this.ilu() - f9 - 4.0f;
        boolean bl3 = ubm2.code.equals(PartyClient.leader());
        float f11 = UiKit.CARD_TITLE.draw(class_3322, UiKit.CARD_TITLE.ellipsize(NameProtect.protect(ubm2.name), f10 - (bl3 ? 12.0f : 0.0f)), f9, UiKit.CARD_TITLE.centerTop(f8 - 4.0f), Theme.text);
        if (bl3) {
            IconRenderer.draw(class_3322, Icon.CROWN, f11 + 6.0f, f8 - 4.0f, 7.0f, -340971);
        }
        class_1657 class_16572 = Friends.inWorld(ubm2.name);
        class_310 class_3102 = class_310.method_1551();
        if (bl2) {
            string = Lang.s("You", "Вы");
            n = -11870592;
        } else if (ubm2.sealed) {
            string = Lang.s("No key yet", "Нет ключа");
            n = -429290;
        } else if (!ubm2.online) {
            string = Lang.s("Offline", "Не в сети");
            n = Theme.textMuted;
        } else if (class_16572 != null && class_3102.field_1724 != null) {
            string = Lang.s("Here  ·  ", "Рядом  ·  ") + WaypointRenderer.formatDistance(Math.sqrt(class_3102.field_1724.method_5858((class_1297)class_16572)));
            n = -11870592;
        } else if (PartyClient.sameWorld(ubm2)) {
            string = Lang.s("On this server", "На этом сервере");
            n = ColorUtil.lerp(-11870592, Theme.textDim, 0.4f);
        } else if (ubm2.world == null) {
            string = Lang.s("Online  ·  in the menu", "В сети  ·  в меню");
            n = Theme.textDim;
        } else {
            string = Lang.s("Online  ·  ", "В сети  ·  ") + PartyMembersList.ily(ubm2.world);
            n = Theme.textDim;
        }
        DrawUtil.circle(class_3322, f9 + 1.6f, f8 + 5.0f, 1.6f, n);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, f10 - 6.0f), f9 + 5.5f, UiKit.SMALL.centerTop(f8 + 5.0f), n);
        if (bl && ubm2.fingerprint != null) {
            hlc2.hint((bl2 ? Lang.s("Your key ", "Ваш ключ ") : Lang.s("Key fingerprint ", "Отпечаток ключа ")) + ubm2.fingerprint + (bl2 ? "" : Lang.s(": compare with " + ubm2.name, ": сверьте с " + ubm2.name)));
        }
        if (PartyClient.isLeader() && !bl2) {
            boolean bl4 = ubm2.code.equals(this.ilm);
            float f12 = this.ilu() + (1.0f - f6) * 6.0f;
            boolean bl5 = hlc2.canHover() && UiKit.inside(f2, f3, f12, f8 - 9.0f, 18.0f, 18.0f);
            UiKit.iconButton(class_3322, Icon.CLOSE, f12, f8 - 9.0f, 18.0f, vcjArray[2].step(bl5, f4), bl4, bl4 ? 1.0f : f6);
            if (bl5 && f6 > 0.5f) {
                hlc2.hint(bl4 ? Lang.s("Click again to remove ", "Ещё раз, чтобы исключить ") + ubm2.name : Lang.s("Remove from the party", "Исключить из пати"));
            }
        }
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    private static String ily(String string) {
        if (string.startsWith("mp:")) {
            return string.substring(3);
        }
        if (string.startsWith("sp:")) {
            return Lang.s("singleplayer", "одиночная игра");
        }
        return string;
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        float f3;
        if (n != 0) {
            return this.hovered(f, f2);
        }
        List<ubg> list = PartyMembersList.ilq();
        List<ubm> list2 = PartyMembersList.ilr();
        int n2 = 0;
        for (ubg object : List.copyOf(list)) {
            f3 = this.ils(n2++) + 13.0f;
            if (UiKit.inside(f, f2, this.ilv(), f3 - 9.0f, 18.0f, 18.0f)) {
                if (!PartyClient.online()) {
                    hlc2.toast(Lang.s("Not connected to the party server", "Нет связи с сервером пати"), Icon.INFO, true);
                    return true;
                }
                PartyClient.accept(object);
                return true;
            }
            if (!UiKit.inside(f, f2, this.ilu(), f3 - 9.0f, 18.0f, 18.0f)) continue;
            PartyClient.decline(object);
            return true;
        }
        for (ubm ubm2 : List.copyOf(list2)) {
            f3 = this.ils(n2++) + 13.0f;
            if (!PartyClient.isLeader() || ubm2.code.equals(PartyClient.code()) || !UiKit.inside(f, f2, this.ilu(), f3 - 9.0f, 18.0f, 18.0f)) continue;
            if (ubm2.code.equals(this.ilm)) {
                this.ilm = null;
                PartyClient.kick(ubm2);
            } else {
                this.ilm = ubm2.code;
                this.iln = System.currentTimeMillis() + 2500L;
            }
            return true;
        }
        if (PartyClient.inParty()) {
            float f4 = this.ils(n2) + 2.0f;
            float f5 = Math.min(this.w, 110.0f);
            f3 = this.x + (this.w - f5) * 0.5f;
            if (UiKit.inside(f, f2, f3, f4, f5, 17.0f)) {
                PartyClient.leave();
                return true;
            }
        }
        return this.hovered(f, f2);
    }

    private static /* synthetic */ int ahe(int n, int n2) {
        return n + n2 ^ 0x19FAE651;
    }

    private static /* synthetic */ int ahf(int n, int n2) {
        return PartyMembersList.ahe(n, n2) ^ 0xEDE8B522;
    }
}

