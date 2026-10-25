/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.dry;
import a.dtv;
import a.ejp;
import a.kfa;
import a.kfe;
import a.vlv;
import a.vmc;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class our
extends kfe {
    private static final long ous = 1500L;
    private final vlv out = this.add(new vlv(a.d("\u27ec\u5e60\ud4a2\u4adb\uc112", 371836292, 1154343460), a.c(-989054788, "\u38ee\u4157\ucbf4\u55c7\ude1d\u58b7\ue2e4\u6b0d\uf55b\u7ffc"), a.b("\u009c\u7925\uf386\u6db5\ue66f\u60c5\uda96\u537f\ucd29\u478e", 821952718), a.b("\ub926\uc0b9\u4a69\ud414\u5fcb\ud962", 1051965794), a.d("\u5234\u2ba8\ua17b", 1844157367, 562940353)));
    private final vmc ouu = this.add(new vmc(a.c(-1911835816, "\ub318\uca9a\u405a\ude3c\u55e0"), 1.0, 1.0, 4.0, 1.0).suffix(a.d("\u3a77\u43db\uc902\u577b\udcb4", -1336664190, 1026762116)));
    private static Field ouv;
    private static boolean ouw;
    private static our oux;
    private static boolean ouy;
    private static long ouz;
    private static /* synthetic */ long ova;
    private static /* synthetic */ String ovb;

    public our() {
        super(a.c(1827912193, "\uba40\uc3d6\u4917\ud761\u5c97\uda00\u6045"), a.d("\u11dd\u684b\ue28a\u7cfc\uf73a\u719c\ucb9d\u423e\udc7a\u56c5\ud119\u2b74\ua5f7\u3c05\ub659\u30ad\u8ae8\u0531\u9fc9\u19cf\u9027\uea77\u64c1\uff19\u7923\uf3ba\u4a04\uc45c\u5ea3", 278196198, 273481312), kfa.PLAYER);
        if (oux == null) {
            oux = this;
        }
    }

    public static void repairing(MinecraftClient minecraftClient) {
        our our2 = oux;
        if (our2 == null || dry.armed()) {
            return;
        }
        int n = our2.ouu.getInt();
        dtv dtv2 = ejp.current();
        if (dtv2 != null) {
            dtv2.boostItemUse(n);
            return;
        }
        if (!our2.isEnabled()) {
            our2.setEnabled(true);
            ouy = our2.isEnabled();
        }
        if (!our2.isEnabled()) {
            return;
        }
        ouz = System.currentTimeMillis();
        if (minecraftClient.player != null && (minecraftClient.player.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE) || minecraftClient.player.getOffHandStack().isOf(Items.EXPERIENCE_BOTTLE))) {
            our.ovc(minecraftClient, n);
        }
    }

    @Override
    protected void onDisable() {
        ouy = false;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (ouy && System.currentTimeMillis() - ouz > 1500L) {
            ouy = false;
            this.setEnabled(false);
            return;
        }
        if (minecraftClient.player == null || !minecraftClient.options.useKey.isPressed() || !this.ovd(minecraftClient.player.getMainHandStack()) && !this.ovd(minecraftClient.player.getOffHandStack())) {
            return;
        }
        our.ovc(minecraftClient, this.ouu.getInt());
    }

    private static void ovc(MinecraftClient minecraftClient, int n) {
        if (!ouw) {
            ouw = true;
            ouv = vxr.find(MinecraftClient.class, a.d("\u5e75\u27cf\uad0d\u3326\ub8b2\u3e07\u8453\u0da9\u93f0\u1950\u9e90\u64e6\uea23\u73c8\uf9d6\u7f28\uc56a\u4aa9\ud01a\u5667\udffc\ua5af\u2b1d", -921164903, 2081586581), a.d("\uc299\ubb27\u31f8\uaf80\u245f\ua2d5\u18e8\u911f\u0f42\u85f4", 1791094245, 1530867472), a.d("\ud27d", -775583553, 301947530));
        }
        if (vxr.getInt(ouv, minecraftClient, 0) > n) {
            vxr.setInt(ouv, minecraftClient, n);
        }
    }

    /*
     * Exception decompiling
     */
    private boolean ovd(ItemStack var1_1) {
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

    private static /* synthetic */ int bfb(int n, int n2) {
        return n - n2 ^ 0x877C9AB;
    }
}

