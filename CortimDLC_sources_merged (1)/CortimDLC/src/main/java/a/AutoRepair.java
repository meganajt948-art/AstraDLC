/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 */
package a;

import a.PanicShutdown;
import a.Bot;
import a.BotRuntime;
import a.ModuleCategory;
import a.Module;
import a.ModeSetting;
import a.NumberSetting;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;

public class AutoRepair
extends Module {
    private static final long ous = 1500L;
    private final ModeSetting out = this.add(new ModeSetting("Items", "XP bottles", "XP bottles", "Blocks", "All"));
    private final NumberSetting ouu = this.add(new NumberSetting("Every", 1.0, 1.0, 4.0, 1.0).suffix("ticks"));
    private static Field ouv;
    private static boolean ouw;
    private static AutoRepair oux;
    private static boolean ouy;
    private static long ouz;
    private static /* synthetic */ long ova;
    private static /* synthetic */ String ovb;

    public AutoRepair() {
        super("FastUse", "Faster right click while held", ModuleCategory.PLAYER);
        if (oux == null) {
            oux = this;
        }
    }

    public static void repairing(class_310 class_3102) {
        AutoRepair our2 = oux;
        if (our2 == null || PanicShutdown.armed()) {
            return;
        }
        int n = our2.ouu.getInt();
        Bot dtv2 = BotRuntime.current();
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
        if (class_3102.field_1724 != null && (class_3102.field_1724.method_6047().method_31574(class_1802.field_8287) || class_3102.field_1724.method_6079().method_31574(class_1802.field_8287))) {
            AutoRepair.ovc(class_3102, n);
        }
    }

    @Override
    protected void onDisable() {
        ouy = false;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (ouy && System.currentTimeMillis() - ouz > 1500L) {
            ouy = false;
            this.setEnabled(false);
            return;
        }
        if (class_3102.field_1724 == null || !class_3102.field_1690.field_1904.method_1434() || !this.ovd(class_3102.field_1724.method_6047()) && !this.ovd(class_3102.field_1724.method_6079())) {
            return;
        }
        AutoRepair.ovc(class_3102, this.ouu.getInt());
    }

    private static void ovc(class_310 class_3102, int n) {
        if (!ouw) {
            ouw = true;
            ouv = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1752", "I");
        }
        if (Reflect.getInt(ouv, class_3102, 0) > n) {
            Reflect.setInt(ouv, class_3102, n);
        }
    }

    /*
     * Exception decompiling
     */
    private boolean ovd(class_1799 var1_1) {
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

