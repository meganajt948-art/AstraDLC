/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_745
 *  net.minecraft.class_746
 */
package a;

import com.mojang.authlib.GameProfile;
import flow.dev.StringDecryptor;
import java.util.Random;
import java.util.UUID;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_745;
import net.minecraft.class_746;

public final class DummyPlayer
extends class_745 {
    private static final double tky = 0.216;
    private static final double tkz = 0.28;
    private final Random tla;
    private final String tlb;
    private final double tlc;
    private final double tld;
    private final double tle;
    private String tlf;
    private int tlg;
    private double tlh;
    private double tli;
    private double tlj;
    private double tlk = 1.0;
    private int tll;
    private int tlm;
    private double tln;
    private int tlo;
    private double tlp;
    private double tlq;
    private boolean tlr;
    private int tls;
    private float tlt;
    private float tlu;
    private int tlv;
    private static /* synthetic */ String tlw;
    private static /* synthetic */ long tlx;

    public DummyPlayer(class_638 class_6382, String string, long l, String string2, double d, double d2, double d3) {
        super(class_6382, new GameProfile(UUID.nameUUIDFromBytes(("flow2-stand-" + string).getBytes()), string));
        this.tla = new Random(l);
        this.tlb = string2;
        this.tlc = d;
        this.tld = d2;
        this.tle = d3;
        this.tlf = string2;
        this.tln = d + this.tla.nextDouble() * (d2 - d);
        this.tly();
    }

    public boolean method_5810() {
        return false;
    }

    public void method_5697(class_1297 class_12972) {
    }

    protected void method_6070() {
    }

    public void method_5773() {
        class_746 class_7462 = class_310.method_1551().field_1724;
        if (class_7462 != null && !this.method_31481()) {
            this.tlz(class_7462);
            this.tma();
        }
        super.method_5773();
        this.field_5960 = true;
        if (class_7462 != null) {
            this.tmb(class_7462);
        }
    }

    public void knock(class_243 class_2432, boolean bl) {
        double d = this.method_23317() - class_2432.field_1352;
        double d2 = this.method_23321() - class_2432.field_1350;
        double d3 = Math.max(0.001, Math.sqrt(d * d + d2 * d2));
        double d4 = bl ? 0.55 : 0.4;
        this.tlh = this.tlh * 0.5 + d / d3 * d4;
        this.tlj = this.tlj * 0.5 + d2 / d3 * d4;
        if (this.method_24828()) {
            this.tli = Math.min(0.4, this.tli * 0.5 + 0.36);
        }
        this.tlv = 8 + this.tla.nextInt(8);
        this.method_5879((float)Math.toDegrees(Math.atan2(d2, d)));
    }

    private void tly() {
        if (this.tlb.equals("Mix")) {
            String[] stringArray = new String[]{"Duel", "Strafe", "Jumpy", "Walk", "Duel", "Strafe", "Still"};
            this.tlf = stringArray[this.tla.nextInt(stringArray.length)];
            this.tlg = 60 + this.tla.nextInt(140);
        } else {
            this.tlf = this.tlb;
            this.tlg = Integer.MAX_VALUE;
        }
    }

    private void tlz(class_746 class_7462) {
        if (--this.tlg <= 0) {
            this.tly();
        }
        if (--this.tll <= 0) {
            double d = this.tla.nextDouble();
            double d2 = d < 0.12 ? 0.0 : (this.tlk = d < 0.56 ? -this.tlk : this.tlk);
            if (this.tlk == 0.0 && d >= 0.12) {
                this.tlk = this.tla.nextBoolean() ? 1.0 : -1.0;
            }
            this.tll = 5 + (int)(-Math.log(1.0 - this.tla.nextDouble()) * 14.0);
        }
        if (--this.tlo <= 0) {
            this.tln = this.tlc + this.tla.nextDouble() * (this.tld - this.tlc);
            this.tlo = 30 + this.tla.nextInt(80);
        }
        if (this.tlv > 0) {
            --this.tlv;
        }
    }

    /*
     * Exception decompiling
     */
    private void tma() {
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

    private void tmb(class_746 class_7462) {
        class_243 class_2432 = class_7462.method_33571();
        double d = class_2432.field_1352 - this.method_23317();
        double d2 = class_2432.field_1350 - this.method_23321();
        double d3 = class_2432.field_1351 - this.method_23320();
        float f = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        this.tlt += class_3532.method_15393((float)(f + (float)this.tla.nextGaussian() * 4.0f - this.tlt)) * 0.45f;
        this.tlu += (f2 + (float)this.tla.nextGaussian() * 2.0f - this.tlu) * 0.4f;
        this.method_36456(this.tlt);
        this.method_36457(class_3532.method_15363((float)this.tlu, (float)-60.0f, (float)60.0f));
        this.method_5847(this.tlt);
    }

    public void relocate(class_746 class_7462) {
        double d = Math.toRadians((double)class_7462.method_36454() + 90.0);
        for (int i = 0; i < 24; ++i) {
            double d2;
            double d3 = d + (this.tla.nextDouble() - 0.5) * Math.PI * (i < 12 ? 1.2 : 2.0);
            double d4 = this.tlc + this.tla.nextDouble() * (this.tld - this.tlc);
            double d5 = class_7462.method_23317() + Math.cos(d3) * d4;
            Double d6 = this.tmc(class_7462, d5, d2 = class_7462.method_23321() + Math.sin(d3) * d4);
            if (d6 == null) continue;
            this.tmd(d5, d6, d2);
            return;
        }
        this.tmd(class_7462.method_23317() + Math.cos(d) * this.tlc, class_7462.method_23318(), class_7462.method_23321() + Math.sin(d) * this.tlc);
    }

    private Double tmc(class_746 class_7462, double d, double d2) {
        double d3 = (double)this.method_17681() * 0.5;
        for (int i = 2; i >= -4; --i) {
            double d4 = Math.floor(class_7462.method_23318()) + (double)i;
            class_238 class_2383 = new class_238(d - d3, d4, d2 - d3, d + d3, d4 + (double)this.method_17682(), d2 + d3);
            class_238 class_2384 = class_2383.method_989(0.0, -0.2, 0.0);
            if (!this.method_73183().method_8587((class_1297)this, class_2383) || this.method_73183().method_8587((class_1297)this, class_2384)) continue;
            return d4;
        }
        return null;
    }

    private void tmd(double d, double d2, double d3) {
        this.tlj = 0.0;
        this.tli = 0.0;
        this.tlh = 0.0;
        this.method_5808(d, d2, d3, this.method_36454(), this.method_36455());
        this.field_6038 = d;
        this.field_5971 = d2;
        this.field_5989 = d3;
        this.tls = 0;
        this.tlr = false;
    }

    private static /* synthetic */ int cmb(int n, int n2) {
        return n * n2 ^ 0x173A04DC;
    }

    private static /* synthetic */ int cmc(int n, int n2) {
        return DummyPlayer.cmb(n, n2) ^ 0x7B612E40;
    }
}

