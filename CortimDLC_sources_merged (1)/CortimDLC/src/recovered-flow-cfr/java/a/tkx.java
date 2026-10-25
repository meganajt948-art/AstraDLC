/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.util.Random;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class tkx
extends OtherClientPlayerEntity {
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

    public tkx(ClientWorld clientWorld, String string, long l, String string2, double d, double d2, double d3) {
        super(clientWorld, new GameProfile(UUID.nameUUIDFromBytes((a.b("\ud799\uae22\u24f2\uba9b\u3109\ub7a7\u0daa\u845c\u1a16\u90a8\u1771\ued49", 542365683) + string).getBytes()), string));
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

    public void method_5697(Entity entity) {
    }

    protected void method_6070() {
    }

    public void method_5773() {
        ClientPlayerEntity clientPlayerEntity = MinecraftClient.method_1551().field_1724;
        if (clientPlayerEntity != null && !this.method_31481()) {
            this.tlz(clientPlayerEntity);
            this.tma();
        }
        super.method_5773();
        this.field_5960 = true;
        if (clientPlayerEntity != null) {
            this.tmb(clientPlayerEntity);
        }
    }

    public void knock(Vec3d vec3d, boolean bl) {
        double d = this.method_23317() - vec3d.field_1352;
        double d2 = this.method_23321() - vec3d.field_1350;
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
        if (this.tlb.equals(a.d("\ub078\uc9ed\u432f", 1254660201, -608819105))) {
            String[] stringArray = new String[]{a.c(1224692643, "\u53e3\u2a63\ua0a0\u3ed8"), a.c(-1468450982, "\u370f\u4e99\uc44c\u5a2e\ud1fe\u574c"), a.c(512138217, "\u9ba6\ue228\u68e3\uf68f\u7d51"), a.c(-983578585, "\uc874\ub1f3\u3b2d\ua55b"), a.c(126396001, "\ua621\udfa1\u5562\ucb1a"), a.c(277563843, "\u4996\u3000\ubad5\u24b7\uaf67\u29d5"), a.c(-2119522390, "\ua7fc\ude6a\u54a4\ucad0\u4107")};
            this.tlf = stringArray[this.tla.nextInt(stringArray.length)];
            this.tlg = 60 + this.tla.nextInt(140);
        } else {
            this.tlf = this.tlb;
            this.tlg = Integer.MAX_VALUE;
        }
    }

    private void tlz(ClientPlayerEntity clientPlayerEntity) {
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

    private void tmb(ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = clientPlayerEntity.method_33571();
        double d = vec3d.field_1352 - this.method_23317();
        double d2 = vec3d.field_1350 - this.method_23321();
        double d3 = vec3d.field_1351 - this.method_23320();
        float f = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        this.tlt += MathHelper.method_15393((float)(f + (float)this.tla.nextGaussian() * 4.0f - this.tlt)) * 0.45f;
        this.tlu += (f2 + (float)this.tla.nextGaussian() * 2.0f - this.tlu) * 0.4f;
        this.method_36456(this.tlt);
        this.method_36457(MathHelper.method_15363((float)this.tlu, (float)-60.0f, (float)60.0f));
        this.method_5847(this.tlt);
    }

    public void relocate(ClientPlayerEntity clientPlayerEntity) {
        double d = Math.toRadians((double)clientPlayerEntity.method_36454() + 90.0);
        for (int i = 0; i < 24; ++i) {
            double d2;
            double d3 = d + (this.tla.nextDouble() - 0.5) * Math.PI * (i < 12 ? 1.2 : 2.0);
            double d4 = this.tlc + this.tla.nextDouble() * (this.tld - this.tlc);
            double d5 = clientPlayerEntity.method_23317() + Math.cos(d3) * d4;
            Double d6 = this.tmc(clientPlayerEntity, d5, d2 = clientPlayerEntity.method_23321() + Math.sin(d3) * d4);
            if (d6 == null) continue;
            this.tmd(d5, d6, d2);
            return;
        }
        this.tmd(clientPlayerEntity.method_23317() + Math.cos(d) * this.tlc, clientPlayerEntity.method_23318(), clientPlayerEntity.method_23321() + Math.sin(d) * this.tlc);
    }

    private Double tmc(ClientPlayerEntity clientPlayerEntity, double d, double d2) {
        double d3 = (double)this.method_17681() * 0.5;
        for (int i = 2; i >= -4; --i) {
            double d4 = Math.floor(clientPlayerEntity.method_23318()) + (double)i;
            Box box = new Box(d - d3, d4, d2 - d3, d + d3, d4 + (double)this.method_17682(), d2 + d3);
            Box box2 = box.method_989(0.0, -0.2, 0.0);
            if (!this.method_73183().method_8587((Entity)this, box) || this.method_73183().method_8587((Entity)this, box2)) continue;
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
        return tkx.cmb(n, n2) ^ 0x7B612E40;
    }
}

