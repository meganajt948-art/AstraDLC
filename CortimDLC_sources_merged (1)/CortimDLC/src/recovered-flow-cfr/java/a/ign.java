/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 */
package a;

import a.eyg;
import a.eyn;
import a.hlc;
import a.iah;
import a.ifv;
import a.ige;
import a.ijy;
import a.iov;
import a.irr;
import a.kfe;
import a.kwf;
import a.lfa;
import a.mpq;
import a.nfl;
import a.nxa;
import a.tck;
import a.tct;
import a.tcw;
import a.tcz;
import a.tik;
import a.tiq;
import a.toq;
import a.ttb;
import a.ttl;
import a.tvq;
import a.tvz;
import a.txp;
import a.txs;
import a.tyd;
import a.ujt;
import a.ukf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.Flow;
import flow.dev.a;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;

public final class ign
extends ijy {
    private static final float igo = 510.0f;
    private static final float igp = 360.0f;
    private static final float igq = 12.0f;
    private static final float igr = 30.0f;
    private static final float igs = 16.0f;
    private static final float igt = 146.0f;
    private static final float igu = 30.0f;
    private static final float igv = 16.0f;
    private static final float igw = 10.0f;
    private final iah igx = new iah(a.d("\u3d82\u4418\uced9\u50ff\udb78\u5dcb\ue785\u6e7d\uf02d\u7a99\ufd43", -1238865262, -1338288299), vhz.PLUS, 24, iah.ANY);
    private final float igy;
    private final float igz;
    private final vcj iha = new vcj(16.0f);
    private final vcj ihb = new vcj(18.0f);
    private final List<ige> ihc = new ArrayList<ige>();
    private List<tiq> ihd = new ArrayList<tiq>();
    private tiq ihe;
    private float ihf;
    private boolean ihg;
    private float ihh;
    private float ihi;
    private float ihj;
    private float ihk;
    private String ihl;
    private long ihm;
    private boolean ihn;
    private String iho;
    private tiq ihp;
    private long ihq;
    private long ihr;
    private tct ihs;
    private hlc iht;
    private static /* synthetic */ String ihu;
    private static /* synthetic */ int ihv;

    private ign(float f, float f2) {
        this.igy = (f - 510.0f) * 0.5f;
        this.igz = (f2 - 360.0f) * 0.5f;
        this.igx.onSubmit = this::iia;
        this.ihy();
        tiq tiq2 = lfa.activeProfile();
        this.ihe = tiq2 != null ? this.ihz(tiq2.name) : (this.ihd.isEmpty() ? null : this.ihd.get(this.ihd.size() - 1));
        this.ihs = tcz.job();
        if (this.ihe != null) {
            this.ihe.prefetch();
        }
    }

    public static void open() {
        Screen screen = MinecraftClient.getInstance().currentScreen;
        if (screen instanceof hlc) {
            hlc hlc2 = (hlc)screen;
            hlc2.openOverlay(new ign(540.0f, 409.0f));
        }
    }

    public static void openMine() {
        Object object = MinecraftClient.getInstance().currentScreen;
        if (object instanceof hlc) {
            hlc hlc2 = (hlc)((Object)object);
            object = new ign(540.0f, 409.0f);
            ((ign)object).ihx();
            hlc2.openOverlay((ijy)object);
        }
    }

    public static void openWalk(String string) {
        Object object = MinecraftClient.getInstance().currentScreen;
        if (object instanceof hlc) {
            hlc hlc2 = (hlc)((Object)object);
            object = new ign(540.0f, 409.0f);
            ((ign)object).ihw(string);
            hlc2.openOverlay((ijy)object);
        }
    }

    private void ihw(String string) {
        tiq tiq2 = lfa.walkProfile();
        if (tiq2 == null) {
            for (tiq tiq3 : this.ihd) {
                if (!tiq3.walk()) continue;
                tiq2 = tiq3;
            }
        }
        for (int i = 1; tiq2 == null && i <= 9; ++i) {
            try {
                tiq2 = tiq.create(wap.s(a.c(1734040499, "\u5be3\u2264\ua8ba\u36cc\ubd19\u3baf\u81f5"), a.c(-1066654891, "\u2776\u5edc\ud405\u4a0c\uc1a6\u4716")) + (i == 1 ? "" : a.b("\ued54", 740879733) + i));
                tiq2.set(a.b("\u2612\u5fa6\ud572\u4b01\uc0c9\u4664\ufc21", 1480402533), a.c(1099822469, "\uf5d6\u8c51\u068f\u98f9"));
                tiq2.save();
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        if (tiq2 != null && string != null) {
            tiq2.set(a.b("\u1eba\u671d\uedc3\u73b5\uf827\u7ecf\uc482\u4d6e\ud32d", 1780096708), string);
            tiq2.save();
        }
        this.ihy();
        if (tiq2 != null) {
            this.ihe = this.ihz(tiq2.name);
            if (this.ihe != null) {
                this.ihe.prefetch();
            }
        }
    }

    private void ihx() {
        tiq tiq2 = lfa.mineProfile();
        if (tiq2 == null) {
            for (tiq tiq3 : this.ihd) {
                if (!tiq3.mine()) continue;
                tiq2 = tiq3;
            }
        }
        for (int i = 1; tiq2 == null && i <= 9; ++i) {
            try {
                tiq2 = tiq.create(wap.s(a.c(-342309608, "\uc551\ubcc4\u3610\ua86a"), a.c(1468783058, "\uddff\ua456\u2ef0\ub086\u3b23")) + (i == 1 ? "" : a.c(-974853394, "\ueacf") + i));
                tiq2.set(a.c(164164299, "\uf2bc\u8b08\u01dc\u9faf\u1467\u92ca\u288f"), a.c(444192252, "\ud5b5\uac20\u26f4\ub88e"));
                tiq2.save();
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.ihy();
        if (tiq2 != null) {
            this.ihe = this.ihz(tiq2.name);
            if (this.ihe != null) {
                this.ihe.prefetch();
            }
        }
    }

    private void ihy() {
        this.ihd = tiq.list();
        if (this.ihe != null) {
            this.ihe = this.ihz(this.ihe.name);
        }
    }

    private tiq ihz(String string) {
        for (tiq tiq2 : this.ihd) {
            if (!tiq2.name.equals(string)) continue;
            return tiq2;
        }
        return null;
    }

    private void iia() {
        String string = this.igx.text;
        if (tiq.clean(string).isEmpty()) {
            string = wap.s(a.c(-1830752251, "\uf05d\u89ce\u0300\u9d78\u16a0\u9014\u2a4e\ua3fa"), a.c(1964932682, "\u7a5d\u03b3\u891e\u1715\u9cbe\u1a0c\ua028\u2db5")) + (this.ihd.size() + 1);
        }
        try {
            tiq tiq2 = tiq.create(string);
            this.igx.setText("");
            this.ihy();
            this.ihe = this.ihz(tiq2.name);
            if (lfa.activeProfile() == null) {
                lfa.activate(this.ihe);
            }
            this.iib(wap.s(a.c(-2061143946, "\u7029\u09ba\u8374\u1d0c\u96d4\u1060\uaa3a\u238e\ubd92\u3732\ub0f6\u4a83\uc441\u5de1\ud7b3"), a.d("\u3c0f\u45e1\ucf4c\u5147\udaec\u5c5e\ue67a\u6be7\uf1d9\u7b17\ufccd\u06bf\u886c\u11d0", -138793607, -1921116825)), vhz.CHECK, false);
        }
        catch (IOException iOException) {
            this.igx.error();
            this.iib(a.b("\u20c2\u596e\ud3ac\u4dc7\uc617\u40a1", 1233199265).equals(iOException.getMessage()) ? wap.s(a.d("\u13a2\u6a2f\ue0f5\u7e91\uf512\u73ed\uc9b1\u404c\ude1b\u54ef\ud375\u291e\ua79a\u3e7f\ub439\u32c2\u8883\u0759", 478702284, -2119861976), a.b("\u7d12\u04b1\u8e68\u101d\u9bc1\u1965\ua72e\u2edb\ub0f7\u3e29\ubd99\u479d\uc949\u54ed\udaab\u5c2e\ue662\u69bd", 1911847202)) : wap.s(a.c(520224493, "\ufea1\u8732\u0dee\u93d6\u1852\u9eb7\u24a7\uad47\u330f\ub9ba\u3e7c\uc41c\u4a8e\ud376\u5938"), a.d("\uc5c9\ubc50\u3296\ua8f8\u232e\ua59a\u1fb1\u9644\u0864\u82d6\u0500\uff0e\u71d4\uec09\u623b\ue4b5\u5ef3\ud121\u4b96\ucdb5\u444c", -1804286611, -2082339668)), vhz.CLOSE, true);
        }
    }

    private void iib(String string, vhz vhz2, boolean bl) {
        if (this.iht != null) {
            this.iht.toast(string, vhz2, bl);
        }
    }

    @Override
    iah field() {
        return this.igx;
    }

    @Override
    boolean gone() {
        return this.ihn && this.iha.get() <= 0.01f;
    }

    @Override
    boolean closing() {
        return this.ihn;
    }

    @Override
    void close() {
        this.ihn = true;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3, float f4, float f5) {
        this.iht = hlc2;
        this.ihj = f;
        this.ihk = f2;
        float f6 = vcq.outCubic(this.iha.step(this.ihn ? 0.0f : 1.0f, f3));
        if (f6 <= 0.01f) {
            return;
        }
        if (this.ihn) {
            f = -10000.0f;
            f2 = -10000.0f;
        }
        this.iic();
        this.ihc.clear();
        this.iho = null;
        float f7 = iov.r(10.0f);
        float f8 = iov.lightness();
        uut.round(drawContext, 0.0f, 0.0f, f4, f5, iov.r(12.0f), ujt.withAlpha(0, Math.round(110.0f * f6)));
        uut.pushAlpha(f6);
        drawContext.getMatrices().pushMatrix();
        float f9 = 0.96f + 0.04f * f6;
        drawContext.getMatrices().translate(this.igy + 255.0f, this.igz + 180.0f + (1.0f - f6) * 6.0f);
        drawContext.getMatrices().scale(f9, f9);
        drawContext.getMatrices().translate(-(this.igy + 255.0f), -(this.igz + 180.0f));
        uut.shadow(drawContext, this.igy, this.igz + 4.0f, 510.0f, 360.0f, f7, 18.0f, iov.shadow);
        uut.round(drawContext, this.igy, this.igz, 510.0f, 360.0f, f7, ujt.withAlpha(iov.window, 252));
        uut.round(drawContext, this.igy, this.igz, 510.0f, 360.0f, f7, iov.card);
        ukf.sheen(drawContext, this.igy, this.igz, 510.0f, 50.0f, f7, 0.8f * (1.0f - 0.7f * f8));
        uut.outline(drawContext, this.igy, this.igz, 510.0f, 360.0f, f7, 1.0f, iov.stroke);
        ukf.rim(drawContext, this.igy, this.igz, 510.0f, 360.0f, f7, f8, 1.0f);
        this.iie(drawContext, f, f2);
        this.iii(drawContext, hlc2, f, f2, f3);
        if (this.ihe == null) {
            this.iik(drawContext);
        } else {
            float f10 = this.igy + 12.0f + 146.0f + 10.0f;
            float f11 = this.igy + 510.0f - 12.0f - f10;
            float f12 = (f11 - 10.0f) * 0.5f;
            float f13 = this.igz + 30.0f + 4.0f;
            this.iiq(drawContext, f, f2, f10, f13, f12);
            this.iir(drawContext, f, f2, f10 + f12 + 10.0f, f13, f12);
        }
        this.iju(drawContext);
        drawContext.getMatrices().popMatrix();
        uut.popAlpha();
    }

    private void iic() {
        tct tct2 = tcz.job();
        if (tct2 == null || tct2 == this.ihs || !tct2.done) {
            return;
        }
        this.ihs = tct2;
        if (tct2.error == null && tct2.walkResult != null) {
            this.iib(wap.s(a.b("\ufcc0\u8547\u0f99\u91ef\u1a3a\u9c8c\u26d6\uaf60\u3172\ubbc1\u3c19\uc669\u48b7\ud14a\u5b4b\uddad\u67e6\ue832\u729c\uf494\u7df4\u0732\u89ca\u1215\u9476\u1ead\ua74d\u2950\ub3a2\u35f1\ube4c\u40d8\ucace\u5329\ud560\u5f84", 1134230707), a.c(1673252074, "\uc8dc\ub14f\u3b96\ua5e6\u2e3f\ua8f9\u16c6\u9b52\u0576\u8fcd\u0866\uf26a\u7cc7\ue11d\u6f5d\ue9a1\u5392\udc3f\u4680\uc0d3\u4d34\u37f2\ub9d6\u261d\ua063\u2ab9\u9308\u1d53\u87d4\u01f5\u8e5e\u7495\ufed0\u672b\ue562\u6bb0\ud004\u5e17\ud8b3\u4106\ucb27\ub1b9")) + Math.round(tct2.walkResult.keysAcc) + a.c(136269812, "\u4fd5\u3661\ubc25\u22c3") + wap.s(a.d("\udc3a\ua58a\u2f5e\ub133\u3af9\ubc1b", -2053189472, -1936192280), a.b("\u09bf\u700f\ufad0\u64ad\uef04\u69cb\ud3e4\u5e77", -298447480)) + Math.round(tct2.walkResult.yawSim) + a.d("\u0502", 811147162, -188278084), vhz.CHECK, false);
        } else if (tct2.error == null && tct2.mineResult != null) {
            this.iib(wap.s(a.d("\ud472\uade7\u2733\ub949\u32db\ub427\u0e76\u878c\u19d2\u936a\u14f5\ueed6\u6016\uf9a3\u73f5\uf519\u4f0f\uc049\u5a6d\udc6c\u5582\u2fd9\ua162\u3aab\ubc87\u361a\u8fac\u01ff\u9b06\u1d12\u96f8\u683f\ue26a\u7bce", -749649914, 599495707), a.b("\ua8df\ud14c\u5b95\uc5e5\u4e3c\uc8fa\u76c5\ufb5c\u657b\uefbf\u686b\u9213\u18af\u850d\u0f53\u89de\u33ed\ubc30\u2681\ua4c0\u2da0\u5766\uddc7\u466f\uc06a\u4ab4\uf379\u7948\ue7a5\u61fe\uea47\u108c\u9ea0\u0332\u8103\u0bc5\ub416\u3e19\ubca5", 98610404)) + Math.round(tct2.mineResult.top1) + a.d("\u151c\u6ca8\ue6ec\u780a", -411567031, -1919555212) + wap.s(a.c(-757838934, "\u4bc7\u327f\ub8a3\u26d8\uad4b"), a.d("\u2049\u59fb\ud351\u4d2a\uc2ed", -778182381, 1057473823)) + Math.round(tct2.mineResult.hand.similarity) + a.d("\u48dd", 542328263, 1925451070), vhz.CHECK, false);
        } else if (tct2.error == null && tct2.result != null && tct2.aura) {
            this.iib(wap.s(a.b("\u4bb6\u3233\ub8e7\u2685\uad13\u2bef\u91be\u1844\u861a\u0ca2\u8b3d\u711e\uffde\u666b\uec3d\u6ad1\ud0c7\u5f81\uc5a5\u438c\uca03", 542198754), a.b("\u9c06\ue595\u6f4c\uf13c\u7ae5\ufc23\u421c\ucffd\u51d1\udb63\u5cbb\ua2a1\u2865\ub1d9\u3bf6\ubd7b\u0738\u88eb\u1648\u908e\u19ee\u63c7\ued0c", 909154317)) + ign.ijd(tct2.result.axisScore(0)) + a.b("\u0982\u70a4\ufae0\u64e8\uef46", 1283393959) + ign.ijd(tct2.result.axisScore(1)), vhz.CHECK, false);
        } else if (tct2.error == null && tct2.result != null) {
            this.iib(wap.s(a.b("\uf62f\u8fbc\u0564\u9b14\u10ca\u9637\u2c36\ua5d0\u3b8b\ub13f\u36f1\uccd9\u4299\udbbf\u51bf\ud754\u6d1f\ue2ca\u787c\ufe20\u77c4\u0d8e\u8320\u18fc\u9eda", -1908017541), a.b("\u2a4d\u53de\ud907\u4777\uccae\u4a68\uf457\u79b5\ue7e7\u6d2a\uea85\u10f8\u9e2d\u038c\u8948\u0f2e\ub100\u3ed5\ua41d\u2246\uabc4\ud196\u5f55\uc488\u46e9", 294334024)) + Math.round(tct2.result.similarity) + a.c(-685405161, "\u8c33"), vhz.CHECK, false);
        } else if (tct2.error != null) {
            this.iib(ign.iid(tct2.error, tct2.aura, tct2.mine, tct2.walk), vhz.CLOSE, !a.d("\uefa8\u961b\u1cc7\u82bb\u096a\u8fd2", 2060540614, 1874113803).equals(tct2.error));
        }
    }

    /*
     * Exception decompiling
     */
    private static String iid(String var0, boolean var1_1, boolean var2_2, boolean var3_3) {
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

    private void iie(DrawContext drawContext, float f, float f2) {
        boolean bl;
        float f3;
        float f4;
        float f5;
        lfa lfa2;
        String string;
        boolean bl2;
        boolean bl3;
        float f6 = this.igz + 15.0f + 1.0f;
        vjf.draw(drawContext, vhz.LAYERS, this.igy + 12.0f + 5.0f, f6, 10.0f, iov.accent());
        String string2 = wap.s(a.c(899444391, "\u6ee5\u177f\u9dbc\u03ca\u8800\u0efe\ub4fe\u3d08\ua356\u29f6\uae28\u545f"), a.c(-748384553, "\u8ac6\uf35f\u7980\ue788\u6c21\uee83\u50bc\ud94e\u4710\ucdd6\u4a09\ub00f"));
        irr.CARD_TITLE.draw(drawContext, string2, this.igy + 12.0f + 16.0f, irr.CARD_TITLE.centerTop(f6), iov.text);
        boolean bl4 = this.ihe != null && this.ihe.aura();
        boolean bl5 = this.ihe != null && this.ihe.mine();
        boolean bl6 = bl3 = this.ihe != null && this.ihe.walk();
        tiq tiq2 = bl4 ? kwf.studioProfile() : (bl5 ? lfa.mineProfile() : (bl3 ? lfa.walkProfile() : lfa.activeProfile()));
        boolean bl7 = bl2 = bl4 && this.ihe != null && kwf.usesStudio(kwf.studioProfile());
        if (bl3) {
            string = tiq2 == null ? wap.s(a.b("\u9381\uea04\u60d6\ufebc\u7541\uf3db\u4982\uc037\u5e67\ud4d9\u536b\ua92e\u27f8\ube52\u3439\ub2fe\u08a2\u8765\u1dd7\u9b8d\u122e\u6865\ue694\u7d52\ufb31\u71e5\uc84e\u4646\udcf5\u5aa3\ud15e\u2fd8\ua581\u3c7d\uba29\u309a\u8f4a\u0532", -1185115162), a.b("\u3449\u4dcc\uc71e\u5974\ud289\u5413\uee4a\u67ff\uf9af\u7311\uf4a3\u0ee6\u8030\u199a\u93f1\u1536\uaf6a\u20ad\uba1f\u3c45\ub5e6\ucfad\u457f\udedd\u58ae\ud20e\u6fd2\ue5e6\u7f6a\uf931\u72fa\u8c56\u0618", -1268763607)) : wap.s(a.c(-64077689, "\u40fe\u3959\ub387\u2df1\ua624\u2092\u9ac8\u137e\u8d74\u07c3\u8006\u7a61\uf4ff\u6d54"), a.b("\u9882\ue148\u6b91\uf598\u7e32\uf882\u46c1\ucb21\u557a\udfbe\u587c\ua21e\u28b1\ub11a", 608476361)) + tiq2.name;
        } else if (bl4) {
            string = bl2 && tiq2 != null ? wap.s(a.d("\u4ee4\u3741\ubd95\u23f7\ua861\u2e85\u94d0\u1d37\u837e\u0986\u8e4f", 1154806936, 533510678), a.b("\u36fc\u4f3e\uc5ee\u5bef\ud428\u5688\uecdf\u655b\ufb15\u71b7\uf21c\u0877", -687197504)) + tiq2.name : wap.s(a.b("\ucd93\ub436\u3ee2\ua080\u2b16\uadf2\u17a7\u9e40\t\u8af1\u0d38\uf739\u79cc\ue060\u6a3a\uecc4\u568e\ud956\u43a0\uc5e0", -808595994), a.d("\u74d5\u0d17\u87c7\u19c6\u9601\u14a1\uaef6\u2772\ub93c\u339e\ub035\u4a5e\uc0b6\u5958\ud375\u55fe\uefcd\u601f\ufadb\u78e6\uf100", 1893285274, -719368854));
        } else if (bl5) {
            string = tiq2 == null ? wap.s(a.d("\ub4cb\ucd4e\u479c\ud9f6\u5203\ud496\u6ec2\ue738\u7938\uf393\u7402\u8e64\u00af\u991b\u1350\u95f8\u2ff3\ua025", 734141702, -1965315682), a.d("\ue90c\u9089\u1a5b\u8431\u0fc4\u8951\u3305\ubaff\u24ff\uae54\u2d95\ud797\u5943\uc0f0\u4add\ucc27\u7660\uf9b1\u6374\ue557", -875013439, -109988968)) : wap.s(a.b("\u3d63\u44e6\uce34\u505e\udbab\u5d3e\ue76a\u6e90\uf08a\u7a6e\ufdbb\u07dc\u891d\u10e5\u9aac", -1418773203), a.c(-97913195, "\uf6c4\u8f41\u0593\u9bf9\u100c\u9699\u2ccd\ua537\u3b2d\ub58d\u325a\uc85e\u4698\udf3a\u5111\ud7fa")) + tiq2.name;
        } else {
            String string3 = string = tiq2 == null ? wap.s(a.c(1965248429, "\u4fd2\u3662\ubcfe\u22ce\ua91b\u2fbd\u95f3\u1c1d\u8251\u08a5\u8f26\u7555\ufb9f\u6227\ue87b\u6e8f\ud4c9"), a.d("\u369a\u4f23\uc587\u5f94\ud053\u56e8\uecc3\u6548\ufb1d\u71a3\uf673\u0c0f\u82d5\u1f7a\u9136\u17b8\uad89\u2222\ub8ed\u3ebf\ub73c", -1875522976, 1270675666)) : wap.s(a.c(-1934162682, "\u056d\u7cd4\uf603\u683f\ue3bd\u650a\udf4f\u56a8\uc8be\u4215"), a.b("\uedd1\u9468\u1ebf\u84d2\u0b14\u8da1\u3787\ube67\u202b\uaee2\u292b", -232134166)) + tiq2.name;
        }
        boolean bl8 = bl4 ? bl2 : tiq2 != null;
        float f7 = this.igy + 12.0f + 16.0f + irr.CARD_TITLE.width(string2) + 8.0f + Math.max(16.0f, irr.SMALL.width(string) + 9.0f);
        irr.drawChip(drawContext, string, f7, f6, bl8 ? iov.accent() : iov.textMuted, iov.stroke, 0.0f);
        kfe kfe2 = lfa2 = bl4 ? Flow.getInstance().getModuleManager().getByName(a.c(1469056758, "\u06b5\u7f26\uf5f0\u6b81\ue07b\u66fe\udcaa\u5548")) : lfa.get();
        if (lfa2 != null) {
            String string4 = lfa2.getDisplayName();
            String string5 = string4 + (lfa2.isEnabled() ? wap.s(a.b("\u18f0\u610e\uebdc", -1209132845), a.d("\ufcbe\u811d\u0bc6\u95b6", 269147324, -1263001562)) : wap.s(a.c(-382497617, "\u8c8b\uf575\u7faf\ue1de"), a.c(125804501, "\u9ff0\ue253\u68f9\uf6f9\u7d2f")));
            f5 = Math.max(16.0f, irr.SMALL.width(string5) + 9.0f);
            float f8 = f7 + 6.0f;
            boolean bl9 = irr.inside(f, f2, f8, f6 - 5.5f, f5, 11.0f);
            irr.drawChip(drawContext, string5, f8 + f5, f6, lfa2.isEnabled() ? iov.accent() : iov.textMuted, iov.stroke, bl9 ? 1.0f : 0.0f);
            this.ihc.add(new ige(f8, f6 - 5.5f, f5, 11.0f, lfa2::toggle, null));
            if (bl9) {
                this.iho = bl4 ? wap.s(a.d("\uf188\u8816\u02c0\u9cbb\u1764\u919e\u0bf9\ua23c\u3c37\ub687\u3153\ucb3e\u45a7\udc7d\u560c\ud0f8\u6ab7\ue54b\u7fcc\uf99a\u707e\u0a6e\u8492\u1f42\u9973\u13ad\uaa11\u240f\ubef1\u38a0", 2141198855, -675615790), a.c(-37986884, "\u5982\u2012\uaac2\u34b1\ubb7c\u1df9\u879e\u0a7d\u942a\u1e9a\u993c\u6344\uedec\u7427\ufe7a\u7ce7\uc6a7\u4979\ud7d8\u51f0\ud876\ua226\u2ce0\ub738\u3138\ubb93\u022e\u8813\u128f\u94fc\u1f4a\ue19b\u6bf9\uf23c\u7468\ufeca")) : (bl3 ? wap.s(a.c(-1329969351, "\u4725\u3ebb\ub46d\u2a16\ua1c9\u2733\ubd54\u1491\u8aa0:\u87f9\u7d8f\uf345\u6ac9\ue0a7\u664d\udc17\u53d3\uc97d\u4f2a\uc6dc\ubcc3\u323f\ua9ef\u2fde\ua500\u1cbc\u92a2\u085c\u8e0d\u05e2\ufb29\u7107\ue8c2\u6e90\ue43a\u5bc7\ud19d\u5744\uceb1\u44af\u3a51\ub008\u37fd\uad4b\u230e\u9adc\u1076\u9601\u0de6\u8386\u7941\uf0f7\u76ad\uec10\u6216\ud9bf\u5f63\ud517\u4c8d\uc26d\ub822\u3fcc\ub581\u2b06\ua2ee\u18ab\u9e40\u1410\u8bf3\u016d\u871e\u7eca\uf47a\u6a20\ue19d\u6785\udd35\u54e4\uca80\u4016\uc610\ubdbc\u336c\ua91e\u20c6\ua630\u1c28\u93ca\u09cf\u8f35\u06fe\ufcda\u7244\ue9f6"), a.b("\u052e\u7cbe\uf66e\u681d\ue7d0\u4155\udb32\u56d1\uc886\u4236\uc1fe\u3b80\ub558\u28fb\ua2d1\u2451\u9e1f\u15d5\u8f08\u0972\u8095\ufac3\u746d\uef81\u69c3\ue309\u5aaf\ud4eb\u4e01\uc856\u43e4\ubd61\u3734\uaea4\u28c3\ua273\u1dbf\u97e4\u111c\u88a7\u02bc\u7855\uf61e\u71ce\ueb2d\u655d\udc95\u561c\ud065\u4ba7\uc5c2\u3f12\ub6ae\u30b1\uae27\u200d\u9bb8\u1d12\u976c\u0adf\u800a\ufa2b\u7dd4\uf78e\u694d\ue4e5\u5aaa\udc59\u5604\uc9b4\u4369\uc56f\u3cb2\ub261\u2c3e\ua3ad\u2586\u9f32\u1696\u8891\u025a\u8015\uffb9\u7169\ueb1a\u62c1\ue062\u5e2d\ud1d1\u4f9d\ucd3c\u44e5\ube93\u3037\uab8d\u2dca\ua769", 1863975253)) : (bl5 ? wap.s(a.b("\u5731\u2eaf\ua479\u3a02\ub1dd\u3727\uad40\u0485\u9ab4\u102e\u97ed\u6d9b\ue351\u7add\uf0b3\u7659\ucc03\u43c7\ud969\u5f3e\ud6c8\uacd7\u222b\ub9fb\u3fca\ub514\u0ca8\u82b6\u1848\u9e19\u15f6\ueb3d\u6113\uf8d6\u7e84\uf42e\u4bdb\uc18e\u475a\udee0\u54fa\u2a4f\ua011\u27ae\ubd6d\u334f\u8acbd\u8636\u1dfb\u93c0\u6948\ue0e9\u66a2\ufc56\u7255\uc9a7\u4f74\uc50c\u5cdc\ud262\ua87f\u2fc3\ua593\u3b5e\ub2fa\u08f0\u8e56\u041e\u9bae\u1178\u9700\u6e9a\ue462\u7a2c\uf189\u7797\ucd3c\u44bc\uda82\u504c", -549497053), a.c(-1038897286, "\uab36\ud2a6\u5876\uc605\u49c8\uef4d\u752a\uf8c9\u669e\uec2e\u6fe6\u9598\u1b40\u86e3\u0cc9\u8a49\u3007\ubbcd\u2110\ua76a\u2e8d\u54db\uda75\u4199\uc7db\u4d11\uf4b7\u7af3\ue019\u664e\uedfc\u1379\u992c\u00bc\u86db\u0c6b\ub3a7\u39f4\ubf03\u26b5\uace1\ud255\u5c1c\udba9\u417f\ucf01\u76d7\ufc11\u7e3c\ue18f\u6f8c\u9551\u1ced\u9ab0\u045a\u8e17\u35aa\ub371\u3903\ua0dc\u2e1c\u544f\ud7de\u5d83\uc72e\u4ee3\uf4b5\u7233\uf812\u67a7\ue96a\u6b04\u92da\u186f\u8636\u09d7\u8b9e\u312c\ubce2\u2681\uac46\u2a16\u51d0\udf08\u4569\uccd4")) : wap.s(a.b("\u8df7\uf469\u7ebf\ue0c4\u6b1b\uede1\u7786\ude43\u4048\ucaf8\u4d2c\ub741\u39d8\ua03d\u2a72\uac8e\u1684\u9914\u03af\u85fa\u0c40\u765e\uf8ec\u6373\ue503\u6fdd\ud621\u5879\uc28e", -758084183), a.d("\u50ff\u296f\ua3bf\u3dcc\ub201\u1484\u8ee3\u0300\u9d57\u17e7\u9041\u6a39\ue491\u7d5a\uf707\u759a\ucfda\u4004\udea5\u588d\ud10b\uab5b\u259d\ube45\u3845\ub2ee\u0b53\u816e\u1f89\u99d0\u1267", 547069426, 1963641096))));
            }
        }
        irr.iconButton(drawContext, vhz.CLOSE, f4, f5, f3, (bl = irr.inside(f, f2, f4 = this.igy + 510.0f - 12.0f - (f3 = 16.0f), f5 = this.igz + (30.0f - f3) * 0.5f + 1.0f, f3, f3)) ? 1.0f : 0.0f, false, 1.0f);
        this.ihc.add(new ige(f4, f5, f3, f3, this::close, null));
    }

    private float iif() {
        return this.igz + 30.0f + 16.0f;
    }

    private float iig() {
        return this.igz + 360.0f - 16.0f - 8.0f - 26.0f - this.iif();
    }

    private float iih() {
        return Math.max(0.0f, (float)this.ihd.size() * 34.0f - 4.0f - this.iig());
    }

    private void iii(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        boolean bl;
        float f4 = this.igy + 12.0f;
        this.ijn(drawContext, wap.s(a.c(969497074, "\u59aa\u2039\uaaf7\u348f\ubf57\u39e3\u83b9\u0a5e"), a.b("\u0e91\u777f\ufdd2\u63d9\ue872\u6ec0\ud490", -1234892151)), f4, this.igz + 30.0f + 4.0f);
        float f5 = this.iif();
        float f6 = this.iig();
        float f7 = this.ihb.step(Math.max(0.0f, Math.min(this.ihf, this.iih())), f3);
        tiq tiq2 = lfa.activeProfile();
        tct tct2 = tcz.job();
        uut.pushScissor(drawContext, f4 - 2.0f, f5 - 2.0f, 150.0f, f6 + 4.0f);
        float f8 = iov.r(6.0f);
        for (int i = 0; i < this.ihd.size(); ++i) {
            Object object;
            String string;
            boolean bl2;
            tiq tiq3 = this.ihd.get(i);
            bl = tiq3.aura();
            float f9 = f5 + (float)i * 34.0f - f7;
            if (f9 + 30.0f < f5 - 2.0f || f9 > f5 + f6 + 2.0f) continue;
            boolean bl3 = irr.inside(f, f2, f4, f9, 146.0f, 30.0f) && irr.inside(f, f2, f4, f5, 146.0f, f6);
            boolean bl4 = tiq3 == this.ihe;
            int n = bl4 ? ujt.lerp(iov.field, iov.accent(), 0.18f) : iov.field;
            uut.round(drawContext, f4, f9, 146.0f, 30.0f, f8, bl3 ? ujt.lerp(n, iov.fieldHover, 0.6f) : n);
            if (bl4) {
                uut.outline(drawContext, f4, f9, 146.0f, 30.0f, f8, 1.1f, iov.accent(200));
            }
            float f10 = f4 + 8.0f;
            if (bl ? kwf.usesStudio(tiq3) : (tiq3.mine() ? lfa.mineProfile() == tiq3 : (tiq3.walk() ? lfa.walkProfile() == tiq3 : tiq2 == tiq3))) {
                uut.circle(drawContext, f4 + 7.0f, f9 + 15.0f, 2.5f, iov.accent());
                f10 = f4 + 14.0f;
            }
            irr.NAME.draw(drawContext, irr.NAME.ellipsize(tiq3.name, 146.0f - (f10 - f4) - 22.0f), f10, irr.NAME.centerTop(f9 + 10.0f), iov.text);
            boolean bl5 = bl2 = tct2 != null && !tct2.done && tct2.profile == tiq3;
            if (bl2) {
                string = wap.s(a.d("\uc938\ub08f\u3a4f\ua436\u2fe6\ua950\u1304\u9afc\u04e4", 1218271590, 333680675), a.b("\u8f7c\uf6c2\u7c63\ue216\u69b3\uef0a\u555c\udca0\u46ea", -672691381)) + (tct2.progress.epoch + 1) + a.b("\u754b", 340424037) + tct2.progress.epochs;
            } else if (tcz.mode() == tcw.RECORD && tcz.sessionProfile() == tiq3) {
                string = wap.s(a.c(-604133362, "\ua876\ud1d0\u5b05\uc578\u4eb2\uc815\u724b\ufbbd\u65eb\ucf1b"), a.b("\u5548\u2cf5\ua643\u3821\ub794\u3532\u8f66\u0698\u98c0\u1208\u95d6\u4bcd", 1521504636));
            } else if (tiq3.walk()) {
                object = tiq3.walkModel();
                string = ign.ijv(tiq3.getLong(a.b("\u6438\u1d9f\u9741\u0937\u82a5\u044e\ube00\u37fb\ua9ac\u2305", -2075171771), 0L) / 20L) + a.d("\uae00\ud7b1\u5df5\uc313\u48c4", 581625681, -1350547084) + (object == null ? wap.s(a.b("\u98e9\ue14e\u6b90\uf5e6\u7e7a\uf885\u42d7\ucb27\u5573", -1563912041), a.d("\u534c\u2a86\ua05f\u3e56\ub5fc\u334c\u8d0f\u00e3\u9eb4\u1472", 1774888596, -173084265)) : wap.s(a.d("\ua1be\ud819\u52c7\uccb1\u472d", -611569873, -1474392349), a.d("\u7f55\u069f\u8c46\u124f\u99e5\u1f55\ua116", 1007447672, 1772164463)) + Math.round(((txs)object).keysAcc) + a.b("\uc0ef", 1345765579));
            } else if (tiq3.mine()) {
                object = tiq3.mineModel();
                string = tiq3.getLong(a.d("\uf538\u8c8d\u0659\u9823\u13bf\u9542\u2f1f\ua6ed\u38be\ub207\u35cc", -193767527, -1738431801), 0L) + wap.s(a.d("\u1968\u609b\uea46\u7434\uffef\u7956\uc31d", -1653700464, 652382687), a.b("\ucf7e\ub2de\u3807\ua263", -1973694630)) + a.b("\u1e67\u67d6\ued92\u7374\uf8a3", -314106302) + (object == null ? wap.s(a.c(1665505669, "\u99e1\ue054\u6a80\uf4fa\u7f68\uf997\u43c5\uca35\u5461"), a.d("\uec63\u95aa\u1f0c\u817a\u0adf\u887e\u3630\ubfc9\u21e1", -1854572402, -1733390164)) : wap.s(a.d("\u9052\ue9e7\u6333\ufd49\u76db", 2020620565, -1138906833), a.d("\u2f25\u56ec\udc4a\u423c\uc999\u4b38", 1382442395, -514109712)) + Math.round(((ttb)object).top1) + a.d("\uda1f", -1416232799, 1890572954));
            } else {
                object = tiq3.model(bl);
                String string2 = bl ? wap.s(a.c(-788243818, "\u5af2\u2357\ua983\u37e1\ubc77"), a.d("\ue9fd\u903f\u1aef\u84ee\u0b29", -1789341751, -1941364223)) : wap.s(a.d("\u5683\u2f30\ua5e8\u3b98\ub046\u36bb", -2083212475, -107682387), a.d("\ua370\udac3\u501a\uce6a\u45b3\uc375\u7d4a", -1109710946, -1155301163));
                string = tiq3.getLong(a.d("\u0eac\u771c\ufdd2\u63a4", -1527014033, -1917480017), 0L) + wap.s(a.b("\ua12b\ud8d2\u5200\ucc6c\u47bc", -691363570), a.b("\u5cff\u212d\uab89\u31e2", -1726587685)) + a.d("\u52d7\u2b66\ua122\u3fc4\ub413", 1911368126, 693205836) + (object == null ? string2 + wap.s(a.b("\u1f85\u6635\uece7\u729d", -1916788753), a.c(1127715917, "\u9073\ue9ca\u636e")) : string2 + Math.round(((tck)object).similarity) + a.b("\ue4cf", 491578603));
            }
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, 146.0f - (f10 - f4) - 8.0f), f10, irr.SMALL.centerTop(f9 + 20.5f), bl2 ? iov.accent() : iov.textMuted);
            object = tiq3;
            if (bl3 || this.ihp == tiq3) {
                float f11 = 14.0f;
                float f12 = f4 + 146.0f - f11 - 5.0f;
                float f13 = f9 + (30.0f - f11) * 0.5f;
                boolean bl6 = this.ihp == tiq3 && System.currentTimeMillis() - this.ihq < 3000L;
                boolean bl7 = irr.inside(f, f2, f12, f13, f11, f11);
                irr.iconButton(drawContext, vhz.TRASH, f12, f13, f11, bl7 ? 1.0f : 0.0f, bl6, 1.0f);
                this.ihc.add(new ige(f12, f13, f11, f11, () -> this.lambda$list$0((tiq)object), null));
                if (bl7) {
                    this.iho = bl6 ? wap.s(a.b("\u73eb\u0a75\u80a3\u1ed8\u9507\u13fd\ua9ef\u2018\ube41\u34f8\ub32c\u4913\uc790\u5e3a\ud426\u5293\ue8dd\u6705\ufdbf\u7bff\uf219\u880d\u06f7\u9d3b\u1b10\u9196\u283b\ua677\u3c9c\uba85\u3177\ucfab\u45e4\udc59\u5a58\ud0fe\u6f2f\ue552\u639c\ufa3b\u7069\u0e9f\u84c5\u0360", -65506428), a.b("\u5cea\u2507\uafcc\u35cc\uba01\u3cb1\u86e1\u0f12\u9557\u3fd2\u9835\u6627\ue887\u7132\ufb6a\u7d98\uc7ad\u4872\ud6ad\u54ee\udd17\ua74f\u2988\ub25a\u3452\uba96\u0744\u8d74\u1394\u95c2\u1e7e\ue0a8\u6a9e\uf361\u7541\ufff4", 1195661531)) : wap.s(a.b("\u8bc0\uf250\u788a\ue6f2\u6d34\ueb94\u5182\ud827\u4664\uccd8\u4b4e\ub16f\u3fba\ua616\u2c4c\uaab2\u10f8\u9f20", 692882326), a.b("\u6de6\u1440\u9e97\u00ed\u8b39\u0df2\ub7af\u3a32\ua072\u2abc\uad11\u571a\ud9b1\u4003\uca27", -1218483766));
                }
            }
            this.ihc.add(new ige(f4, f9, 146.0f, 30.0f, () -> this.lambda$list$1((tiq)object), () -> this.lambda$list$2((tiq)object)));
            if (!bl3 || this.iho != null) continue;
            this.iho = bl ? wap.s(a.b("\u7d19\u0487\u8e51\u102a\u9bf5\u1d0f\u8768\u2ead\ub0bd\u3a13\ubdd5\u47af\uc936\u5087\uda43\u5c25\ue66a\u69e9\uf341\u751e\ufce6\u86ab\u084c\u93de\u15ae\u9f7a\u26c3\ua89a\u3226\u9443\u3fc4\uc17e\u4b13\ud2e7\u54b4\ude28\u61cb\uebbd\u6d7d\uf48d\u7e87p\u8a35\u0d92\u9716\u192e\ua0e0", 264338805), a.b("\u054a\u7cda\uf60a\u6879\ue7b4\u4131\udb56\u56b9\uc89a\u4253\uc5fa\u3f80\ub15e\u28e1\ua6de\u202f\u9af7\u15b1\u8f02\u0d6c\u849e\ufec9\u7446\ucfa3\u69e8\ue352\u5ac3\ud497\u4e60\uc81c\u439b\ubd4d\u3711\uaea1\u2ce3\ua656\u19f4\u9394\u1554\u8887\u06cd\u783a\uf264", 338821499)) : (tiq3.mine() ? wap.s(a.d("\u3b90\u420e\uc8d8\u56a3\udd7c\u5b86\uc1e1\u6824\uf634\u7c9a\ufb5c\u0126\u8fbf\u160e\u9cca\u1aac\ua0e3\u2f60\ub5c8\u3397\uba6f\uc022\u4ec5\ud557\u5327\ud9f3\u604a\uee13\u74af\ud2ca\u794d\u87fd\u0d86\u9476\u123e\u98ad\u275e\uad28\u2bf0\ub204\u381f\u46e3\uccbe\u4b1b\ud19f\u5fb9\ue674\u6cd8\uea8b\u7112\uff28\u05e4", 875168632, 254359711), a.b("\uc1e1\ub871\u32a1\uacd2\u231f\u859a\u1ffd\u9212\u0c31\u86f8\u0151\ufb2b\u75f5\uec4a\u6275\ue484\u5e5c\ud11a\u4ba9\uc9c7\u4035\u3a62\ub0ed\u0b08\uad43\u27f3\u9e74\u1024\u8ac8\u0cbb\u872c\u79fa\uf3be\u6a0a\ue843\u62f6\udd20\u575e\ud188\u484e\uc673\ubc9a\u36cd", 1328793040)) : (tiq3.walk() ? wap.s(a.c(-1480747758, "\u9511\uec8f\u6659\uf822\u73fd\uf507\u6f60\uc6a5\u58b5\ud21b\u55dd\uafa7\u213e\ub88f\u324b\ub42d\u0e62\u81e1\u1b49\u9d16\u14ee\u6ea3\ue044\u7bd6\ufda6\u7772\ucecb\u4092\uda2e\u7c4b\ud7cc\u297c\ua307\u3af7\ubcbf\u3624\u89d8\u03a3\u8534\u1c8a\u96da\ue84a\u622d\ue59d\u7f51\uf118\u48fd\uc25f\u4406\udfd6\u51ae\uab31\u22d1\ua496\u3e68\ub03e\u0bca\u8d4c\u0721\u9eed\u1046\u6a5f\uede5\u67a9"), a.d("\u989d\ue10d\u6bdd\uf5ae\u7a63\udce6\u4681\ucb6e\u554d\udf84\u582d\ua257\u2c89\ub536\u3b09\ubdf8\u0720\u8866\u12d5\u90bb\u1949\u631e\ue991\u5274\uf43f\u7e8f\uc708\u4958\ud3b4\u55cf\ude57\u208c\uaa87\u3379\ub525\u3ff5\u8016\u0a66\u8cae\u1527\u9f4e\ue1ac\u6be9\uec59\u7685\uf8ba\u450c\ucfc6\u4983\ud229\u5c57\ua2e4\u2f4b\ua91e", -1108927814, 1695516171)) : wap.s(a.d("\u5ac6\u2358\ua98e\u37f5\ubc2a\u3ad0\ua0b7\u0972\u9762\u1dcc\u9a0a\u6070\ueee9\u7758\ufd9c\u7bfa\uc1b5\u4e36\ud49e\u52c1\udb39\ua174\u2f93\ub401\u3271\ub8a5\u011c\u8f45\u15f9\ub39c\u181b\ue69e\u6ccd\uf531\u7327\uf9d7\u4608\ucc7d\u4ae3\ud307\u595e\u27b9\uadfc\u2a1e\ub080\u3eec", -408788184, 150747523), a.b("\u146b\u6dfb\ue72b\u7958\uf695\u5010\uca77\u4798\ud9bb\u5372\ud4db\u2ea1\ua07f\u39c0\ub7ff\u310e\u8bd6\u0490\u9e23\u1c4d\u95bf\uefe8\u6567\ude82\u78c9\uf608\u4fb3\uc1e6\u5f0d\udd4d\u56fa\ua85e\u2200\ubbe2\u39d3\ub777\u08a6\u82da", 1611337815))));
        }
        if (this.ihd.isEmpty()) {
            irr.SMALL.draw(drawContext, wap.s(a.c(1982243185, "\ua130\ud8a0\u523c\ucc1d\u47c8\uc164\u7b3e\uf2c0\u6c9a\ue622\u61e7\u9bc5\u154b\u8ce6\u06a4"), a.b("\u82c9\ufb27\u718a\uef81\u642a\ue298\u58c5\ud138\u4b7e\uc5d0\u4202\ub877\u36aa\uab0b\u2545\ua3bc\u1984", -1272871225)), f4 + 4.0f, irr.SMALL.centerTop(f5 + 10.0f), iov.textMuted);
        }
        uut.popScissor(drawContext);
        float f14 = this.igz + 360.0f - 16.0f - 8.0f - 20.0f;
        this.igx.x = f4;
        this.igx.y = f14;
        this.igx.w = 124.0f;
        this.igx.h = 18.0f;
        this.igx.render(drawContext, hlc2, f, f2, 0.016f);
        float f15 = f4 + 146.0f - 18.0f;
        bl = irr.inside(f, f2, f15, f14, 18.0f, 18.0f);
        irr.primaryButton(drawContext, "", vhz.PLUS, f15, f14, 18.0f, 18.0f, bl ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f15, f14, 18.0f, 18.0f, this::iia, null));
        if (bl) {
            this.iho = wap.s(a.d("\uba92\uc312\u49d6\ud7a3\u5c61\udac1\u60d7\ue967\u7779\ufd98\u7a49\u8025\u0efb\u9745\u1d13\u9beb", -1230215616, -1830757247), a.b("\ub965\uc0cb\u4a11\ud463\u5fb0\ud973\u632e\ueeb3\u74f3\ufe3d\u7990\u839b\u0d30\u9482\u1ea6", -1923629749));
        }
    }

    private void iij(tiq tiq2) {
        long l = System.currentTimeMillis();
        if (this.ihp != tiq2 || l - this.ihq > 3000L) {
            this.ihp = tiq2;
            this.ihq = l;
            return;
        }
        this.ihp = null;
        if (tcz.sessionProfile() == tiq2) {
            tcz.stop();
        }
        if (tcz.training() && tcz.job().profile == tiq2) {
            tcz.cancelTraining();
        }
        if (lfa.activeProfile() == tiq2) {
            lfa.activate(null);
        }
        if (lfa.mineProfile() == tiq2) {
            lfa.activateMine(null);
        }
        if (lfa.walkProfile() == tiq2) {
            lfa.activateWalk(null);
        }
        if (kwf.studioProfile() == tiq2) {
            kwf.useStudio(null);
        }
        try {
            tiq.delete(tiq2);
            this.iib(wap.s(a.c(335641629, "\u7c42\u05d1\u8f1f\u1167\u9abf\u1c0b\ua651\u2fe5\ub1fe\u3b4e\ubc94\u46ec\uc82a\u518a\udbd8"), a.b("\u084a\u71a4\ufb09\u6502\ueea9\u681b\ud23f\u5fa2\uc59e\u4f58\uc88f\u32f5\ubc48\u2595", -1448276901)), vhz.TRASH, false);
        }
        catch (IOException iOException) {
            this.iib(wap.s(a.b("\uec88\u951b\u1fc7\u81ff\u0a7b\u8c9e\u3689\ubf79\u212f\uab97\u2c55\ud635\u58a7\uc15f\u4b11", 808512708), a.d("\u399f\u4006\ucec0\u54ae\udf78\u59cc\ue3e7\u6a12\uf432\u7e80\uf956\u0358\u8d82\u105f\u9e6f\u18e9\ua2a2\u2d78\ub7c8\u31e3\ub81a", 523230564, 2013192435)), vhz.CLOSE, true);
        }
        this.ihy();
        if (this.ihe == null && !this.ihd.isEmpty()) {
            this.ihe = this.ihd.get(0);
        }
    }

    private void iik(DrawContext drawContext) {
        float f = this.igy + 12.0f + 146.0f + 10.0f;
        float f2 = this.igy + 510.0f - 12.0f - f;
        float f3 = this.igz + 180.0f - 10.0f;
        irr.CARD_TITLE.drawCentered(drawContext, wap.s(a.d("\u4668\u3fe8\ub52c\u2b59\ua09b\u263b\u9c2d\u159d\u8b83\u0162\u86b3\u7cdf\uf201\u6bbf\ue1e9\u6711\udd1b\u5285\uc837\u4e28\uc78b\ubdc6\u3378\ua8ec\u2edf\ua407\u1db7\u93f4", 1062706679, -1231037504), a.b("\u9a4f\ue3e1\u693b\uf749\u7c9a\ufa22\u4468\uc986\u57a6\udd69\u5ac0\ua0cd\u2e19\ub7df\u39e0\ubb70\u0145\u8e9a\u142e\u927d", 429170298)), f + f2 * 0.5f, irr.CARD_TITLE.centerTop(f3), iov.textDim);
        irr.SMALL.drawCentered(drawContext, wap.s(a.d("\ucd8a\ub41a\u3ec2\ua0f6\u2b71\uadc2\u178c\u9e74$\u8a90\u0d4a\uf77e\u79b4\ue018\u6a04\uecf4\u56b0\ud924\u43d6\uc58f\u4c7c\u3660\ub880\u2356\ua524\u2fe0\u965a\u1854\u82b9\u04ba\u8f1e\u71c9\ufb8a\u6266\ue423\u6eda\ud101\u5b24\uddf1\u4453\uce04\ub0f2\u3ae3\ubd5e\u27dc\ua9ab\u106e", 1844047522, 1879843656), a.c(1183032676, "\ua14c\ud8a2\u520f\ucc04\u47af\uc11d\u7b39\uf6a4\u68e6\ue24a\u6187\u9bfc\u1527\u8c93\u02dd\u804d\u3a01\ub5aa\u2f1a\ua93c\u24a7\u5ae6\ud45d\u4f88\uc9fb\u4720\ufe89\u74cf\uee3f\u6861\ue3d5\u1d7d\u9743\u0eb9\u8cfd\u0640\ubd89\u37f7\ub156\u28e3\ua2c3\udc31\u5275\ud5c8\u4b00\uc570\u7ca6\uf660\u7054\uebf1\u65f4\u9f58\u16eb\u90b7\u0a4a")), f + f2 * 0.5f, irr.SMALL.centerTop(f3 + 14.0f), iov.textMuted);
    }

    private void iil(DrawContext drawContext, float f, float f2, float f3, float f4, float f5) {
        String string3;
        String[] stringArray;
        int n;
        String string2;
        tiq tiq2 = this.ihe;
        float f6 = this.ijn(drawContext, wap.s(a.c(156140754, "\u848f\ufd1a\u77ce\ue9b8\u6268\ue4d0\u5ec4\ud767\u492f\uc398\u4447\ube2b\u30ea\ua956\u2302\ua5fa"), a.b("\u3def\u4479\ucea5\u50d3\udb7d\u5dc1\ue3fe\u6e15\uf04e\u7afe\ufd22\u075e\u898c\u104a", 164248054)), f3, f4);
        ttl ttl2 = tcz.mineRecorder();
        boolean bl = ttl2 != null && tcz.sessionProfile() == tiq2;
        long l = tiq2.getLong(a.c(110343323, "\ub4fd\ucd48\u479c\ud9e6\u527a\ud487\u6eda\ue728\u797b\uf3c2\u7409"), 0L);
        long l2 = tiq2.getLong(a.b("\uaf59\ud6ec\u5c38\uc242\u49de\ucf25\u7577\ufc80\u62d5\ue87e\u6fb7\u95c0\u1b16\u82ba", 1844293434), 0L);
        long l3 = tiq2.getLong(a.b("\u5dea\u245f\uae8b\u30f1\ubb6d\u3d86\u87c8\u0e33\u9064\u1acd", -637313651), 0L);
        long l4 = tiq2.getLong(a.c(1628411721, "\u9729\uee9c\u6448\ufa32\u71ae\uf755\u4d0b\uc4f2\u5aa1\ud012\u57c0\uadbb\u237b"), 0L);
        long l5 = tiq2.getLong(a.d("\udc9f\ua52a\u2ffe\ub184\u3a18\ubce1\u06b5\u8f57\u1117\u9bae\u1c7c", -1987851495, 1224153056), 0L);
        if (bl) {
            int[] nArray = ttl2.unsaved();
            l += (long)nArray[0];
            l2 += (long)nArray[1];
            l3 += (long)nArray[2];
            l4 += (long)nArray[3];
            l5 += (long)nArray[4];
        }
        float f7 = (f5 - 6.0f) * 0.5f;
        this.ijo(drawContext, wap.s(a.c(2119547992, "\ubc34\uc58b\u4f5b\ud126\u5af9\udc50\u6650\uefe2\u71b2\ufb06\u7cdf\u86a6\u087f\u91cf"), a.d("\u2723\u5e93\ud443\u4a30\uc1e3\u475e\uf91f\u74f1\ueaaf\u6400\ue7c2\u1db9\u936b\u0ade\u8087\u067a", 510766758, -2050191953)), String.valueOf(l), f3, f6, f7, false);
        this.ijo(drawContext, wap.s(a.b("\ufd6c\u84da\u0e1a\u9074\u1bab\u9d1b\u270c\uaeaa\u30eb\uba47\u3d88\uc7b1\u4975\ud08f\u5a97", -588514043), a.b("\ua469\uddd5\u5772\uc977\u42d0\uc41d\u7e49\uf7b6\u69e1\ue353\u609e\u9e8e\u1438\u8d9a\u072d\u8138", -630611900)), String.valueOf(l5), f3 + f7 + 6.0f, f6, f7, true);
        this.ijo(drawContext, wap.s(a.d("\u9fa6\ue600\u6cd5\uf2a8\u7962\uffc5\u4597\ucc67", 1295928807, 2010436155), a.c(-380377515, "\ue26a\u9bdc\u1100\u8f76\u04d8\u8218\u3846\ub1b4")), ign.ijv(l3 / 20L), f3, f6 += 30.0f, f7, false);
        this.ijo(drawContext, wap.s(a.b("\u8391\ufa2d\u70f6\uee8b\u655e\ue3ee\u59b7\ud051", -460880899), a.d("\ue2d6\u9b6c\u11b8\u8fc5\u0415\u82ad\u38f2", -343853188, 458805661)), String.valueOf(l4), f3 + f7 + 6.0f, f6, f7, false);
        float f8 = 18.0f;
        float f9 = f5 - 50.0f;
        boolean bl2 = irr.inside(f, f2, f3, f6 += 32.0f, f9, f8);
        if (bl) {
            irr.primaryButton(drawContext, wap.s(a.b("\ue8f4\u9162\u1baa\u85c4", -1462835037), a.d("\ue5d1\u9c03\u16ac\u88dc", -1711507964, -806316048)), vhz.PAUSE, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, tcz::stop, null));
        } else {
            irr.primaryButton(drawContext, wap.s(a.c(-1941248366, "\ue6cd\u9f4b\u159e\u8be3)\u868e\u3c99\ub525\u2b7e\ua1c8\u261c\udc6a\u52b4"), a.d("\u71df\u0849\u8295\u1ce3\u974d\u118d\uabac\u2253\ub860\u36cb\ub11c\u4b6c\uc5b4\u5c08\ud65e\u50a2", -1528462020, 2139156708)), vhz.PLAY, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, () -> {
                tcz.startMining(tiq2);
                this.close();
                if (this.iht != null) {
                    this.iht.close();
                }
            }, null));
        }
        if (bl2) {
            this.iho = wap.s(a.b("\u2f76\u56e3\udc37\u424d\uc9df\u4f37\uf572\u7c99\ue2c1\u6871\uefb4\u15cc\u9b11\u02e6\u88e2\u0e0d\ub45f\u3b92\ua169\u2779\uaecf\ud4ce\u5a64\uc1bf\u47c8\ucd13\u74b9\ufaf5\u605d\ue616\u6df2\u933c\u197a\u809e\u0699\u8c71\u33b0\ub9db\u3f5d\ua6ae\u2ce1\u5207\ud850\u5feb\uc57b\u4b06\uf28c\u782b\ufe7e\u65a8\ueb89\u110c\u98ba\u1eec\u8403\u0a4f\ub1a3\u3733\ubd4f\u2494\uaa67\ud061\u5784\uddd8\u4310\ucaa3\u70f7\uf60f\u7c1f\ue3ef\u692f\uef49\u16d3\u9c30\u0274\u8983\u0fd8\ub574\u3cb1\ua2c1\u280f", -2005520534), a.c(-765054698, "\u354a\u4cdf\uc60d\u5873\ud3ad\u5105\uef37\u66b7\uf8e4\u7649\uf580\u0ff3\u815c\u1897\u92c0\u1436\uaa7a\u25b1\ubb1d\u3d4b\ub4cc\ucee0\u4024\udbf6\u5d87\ud339\u6eed\ue0b9\u7a32\uf87d\u77d5\u8901\u034c\u9ab1\u1ce7\u962b\u29f8\ua7e9\u2136\ubc9d\u36c8\u4833\uc67a\u45d1\udf7c\u510e\ue8dc\u6217\ue428\u7ffd\uf5e2\u0b29\u8294\u04c9\u9e33\u1017\uabab\u2919\ua772\u3abb\ub016\uca4d\u4db4\uc3ff\u5955\ud09f\u6ac6\uec3b\u661c\uf9a9"));
        }
        float f10 = f3 + f9 + 6.0f;
        float f11 = f5 - f9 - 6.0f;
        boolean bl3 = System.currentTimeMillis() - this.ihr < 3000L;
        boolean bl4 = irr.inside(f, f2, f10, f6, f11, f8);
        irr.secondaryButton(drawContext, bl3 ? wap.s(a.b("\u0edd\u774a\ufd9e\u63f8\ue875", -741077365), a.c(259230552, "\u8f7c\uf6d1\u7c7b\ue270\u69a4\ueb14")) : "", vhz.TRASH, f10, f6, f11, f8, bl4 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f10, f6, f11, f8, () -> this.ije(tiq2), null));
        if (bl4) {
            this.iho = wap.s(a.c(-1961075022, "\u5ec1\u2751\uad8b\u33f3\ub835\u3e95\u8483\u0d33\u9361\u19d0\u9e4f\u646c\ueaac\u731b\uf944\u7fa8\uc5f1\u4a2d\ud099\u56c1\udf22\ua520\u2bdc\ub004\u363d\ubcb8\u0517\u8b47\u11aa\u97a8\u1c4b\ue298\u68ca\uf132\u776e\ufdda\u4204\uc830\u4eeb\ud706\u5d45\u23b9\ua9af\u2e53\ub486\u3afc\u832e\u0996\u8f95\u1417\u9a63\u60a7\ue908\u6f53\uf5fa"), a.c(141237100, "\u1f62\u66c4\uec13\u7269\uf9bd\u7f76\uc52b\u48b6\ud2fb\u5839\udf9e\u21fa\uab3a\u328c\ub8d0\u3e26\u8410\u0bb8\u9513\u175d\u9ed5\ue4fa\u6a33\uf19e\u77e2\ufd47\u409b\ucec2\u5021\ud672\u5dcb\ua31b\u295a\ub0dc\u32e3\ubc4c\u03e4\u8996\u0f37\u968b\u1cdc\u625a\ue80a\u6fb5\uf104"));
        }
        f6 += f8 + 6.0f;
        if (bl && ttl2.paused) {
            string2 = wap.s(a.d("\u3f1d\u469d\ucc5a\u522d\ud9ec\u5f5c\ue551\u6cba", 140130587, -751434146), a.b("\uda0d\ua393\u2933\ub736\u3ce6\ube5d\u0414", -434905579)) + ifv.reasonText(ttl2.pauseReason);
            n = -678620;
        } else if (bl) {
            string2 = (ttl2.mineFound() ? wap.s(a.d("\ufe57\u87c2\u0d16\u936c\u18fe\u9e09\u2453\uadb8\u33fc\ub947\u3ed0\uc436\u4a76\ud395\u59d1\udf26\u6565\ueaa9\u700c\uf650\u7fa0\u05f8", 251022582, -559500550), a.b("\u37d3\u4e7a\uc4dc\u5aaa\ud10f\u53ae\uede0\u641c\ufa4a\u70f6\uf724\u0d5d\u8387\u1e26\u94e2\u1284\uacd4\u2302\ub9c1\u3f9b", -1824967697)) : wap.s(a.d("\u0202\u7b92\uf10e\u6f32\ue4e1\u6257\ud80f\u51bb\ucfa6\u451a\uc2c7\u38a5\ub664\u2f91\ua58c\u2376\u993d\u16ff\u8c1e\u0ad8\u83b8\uf9bb\u771f\uecc8\u6abb\ue077\u59d2\ud78e\u4d7e\ucb26\u40d2\ube42\u3400\uadf1\u2bee\ua11d\u1ec4\u94b6\u1269\u8bd0\u0197", 1741279942, -391720797), a.b("\u187a\u61d9\ueb0b\u7570\ufea4\u786a\uc244\u4bbf\ud1f0\u5f29\ud882\u2286\uac56\u35ee\ubbd6\u393a\u837d\u08b9\u9618\u1043\u99b8\ue3e0\u6d5e\uf29f\u7477\ufe31\u439d\ucdcb\u574c\ud116\u5ec6\ua405\u2e39\ub7bc\u35fa\ubb5a\u0487\u8ef3\u0824\u9197", -1566630800))) + wap.s(a.c(1602356101, "\u03ae\u7a88\uf0cc\u6efe\ue522\u6394\ud9c1\u503a\uce63\u44c4\uc344"), a.c(1109554251, "\u7460\u0d46\u8702\u1d13\u96b1\u107d\uaa53\u23aa\ubdf0\u3740\ub48a")) + l2;
            n = ttl2.mineFound() ? iov.accent() : iov.textDim;
        } else {
            string2 = l2 > 0L ? wap.s(a.c(2125619598, "\u61da\u1840\u9294\u0ce3\u873e\u0189\ubbcc\u326e\uac65\u26cf\ua153\u5b6e\ud5b0\u4c05\uc645\u40a8\ufaa9\u753e\uef99\u69d5\ue020\u9a26\u148f"), a.b("\u8d97\uf433\u7e9d\ue091\u6b4e\uedfa\u57a8\uda40\u400b\ucab5\u4d12\ub30c\u39b8\ua00d\u2a48\uacd9\u16ec\u9d4c\u07e5", -1991603804)) + l2 : wap.s(a.b("\u1c20\u45b7\uef46\u7136\ufaf1\u7c0d\uc65a\u4fac\ud1e8\u5b58\udc9a\u26fd\ua879\u3187\ubbdd\u3d6a\u8768\u08bd\u9209\u145f\u9daf\ue7f7\u6903\uf29b\u74fe\ufe7c\u478a\uc9d0\u5326\ud56d\u5ecc\ua012\u2a15\ub3b0\u35f8\ubf06\u0085\u8af2\u0c32\u958b\u1fd3", 513023036), a.c(130258196, "\u9126\ue8b8\u621f\uf801\u77c8\uf176\u4b57\uc2a2\u5c8f\ud636\u51e0\uabe6\u215e\ubc8a\u36ae\ub05d\u0a60\u85cb\u1f02\u9d31\u14d3\u4ea4\ue035\u7be5\ufd8a\u7347\ucaf0\u44a4\ude2d\u587d\ud7ac\u2d67\ua72c\u3edc\ub880\u323c\u8dee\u07e8"));
            n = iov.textMuted;
        }
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string2, f5), f3, irr.SMALL.centerTop(f6 + 4.0f), n);
        f6 += 16.0f;
        f6 = this.ijn(drawContext, wap.s(a.c(-19668677, "\ue17c\u98f2\u1228\u8c4c\u07cf\u8137\u3b7e\ub2dc\u2cd1\ua677\u21a2\udbdf\u5515\uccb2\u46e0\uc010"), a.d("\uf7a7\u8e73\u04dc\u9eb3\u117b\u97cd\u2dee\ua462\u3a4a\ub0f8\u3725", 1427615357, 2013224438)), f3, f6);
        for (String string3 : stringArray = new String[]{wap.s(a.c(1867084795, "\u73ad\u0a03\u80d9\u1ebd\u953e\u13d6\ua993\u2078\ube72\u3481\ub342\u4924\uc7f7\u5e4c\ud454\u52e4\ue8a4\u677f\ufd88\u7b90\uf260\u887f\u069b\u9d55\u1b2b\u91f0\u2848\ua651\u3ce9\ubaa5\u3100\ucfd0\u4588"), a.c(1409377163, "\u67d1\u1e65\u94ca\u0ea5\u8169\u07dd\ubd8c\u3471\uaa2b\u20e7\ua730\u592d\ud3e2\u4e4b\uc00a\u42e9\ufcbc\u7367\ue9de\u6f8b\ue67e\u9833\u129f\u894f\u0f4e\u8590\u3c58\ub207\u28ff")), wap.s(a.d("\u3074\u49d3\uc31a\u5d6c\ud6e9\u500c\uea5e\u63a8\ufdeb\u7747\uf0dd\u0ab6\u8432\u1d80\u97c6\u1137\uab79\u24e0\ube5f\u385d\ub1ad\ucbe9\u4549\ude9e\u58b9\ud264\u6b98\ue5d0\u7f34\uf972\u72c0\u8c0a\u0642\u9fb3\u19fb\u934d", -1161038464, 2007090601), a.b("\u8429\ufd99\u7746\ue93b\u6292\ue45d\u5e72\ud3e1\u49a4\uc31f\u44c0\ubeb8\u301a\ua9a0\u2782\ua169\u1f47\u90ed\u0a5a\u8c75\u05fc\u7fd2\uf162\u6abd\ue8a2\u627f\udfac\u518d\ucb7d\u4d28\uc696\u3844\ub61a\u2fe7\uadab\u2710\u98b2\u12b6\u946b\u0db0\u87fc\uf904", 811368508)), wap.s(a.d("\ue4d5\u9d66\u17ac\u89ce\u0211\u84a8\u3ef0\ub71b\u290a\ua3a1\u2405\ude03\u50b5\uc965\u4345\uc5c7\u7fec\uf055\u6aea\uecf1\u6519\u1f50\u91fe\u0a2c\u8c0c\u06d1\ubf31\u3163\uab96\u2ddc\ua668\u58a3", 313694786, -686981414), a.d("\u704d\u09fa\u8323\u1d5c\u9688\u1031\uaa67\u239b\ub9cb\u3360\ub4c4\u4ec2\uc074\u59a4\ud384\u5506\uef2d\u6094\ufa2b\u7865\uf1ed\u8bb7\u0579\u9ea4\u18d9\u961c\u2fa3\ua593\u3f1a\ub934\u32ff\ucc2b\u461b", 1947253947, -811022109)), wap.s(a.c(1048495236, "\uc4de\ubd68\u37a3\ua985\u221f\ua4b6\u1ef3\u9709\u091e\u83f6\u0433\ufe58\u70da\ue92d\u6379\ue59b\u5fcb\ud012\u4aa0\uccaf\u4542\u3f5f\ub1e5\u2a30\uac5c\u2691\u9f3f\u113d\u8b8c\u0dc9\u8667\u78b4\uf2b6\u6b1e\ued5b\u67f0\ud820\u5203\ud492\u4d24\uc76d\ub99b\u339c\ub460\u2eb5\ua0c6\u191d\u93a7\u15f2\u8e24"), a.c(-1378472830, "\u28f2\u5138\udbef\u459b\uce3b\u48fc\uf2ab\u7f44\ue506\u6fba\ue81d\u1218\u9cbf\u0572\u8f25\u09d7\ub799\u3852\ua682\u20d7\ua95f\ud374\u5dc4\uc61b\u440b\ucac7\u7379\uf938\u67ad\ue18c\u6a33\u94e4\u1ed6\u8342\u010a\u8bc3\u3410\ube6e\u38cd\ua101\u2f3b\u55d6\udf87\u5834\uc2ea\u4c93\uf53f\u7ffc\uf9c6")), wap.s(a.b("\u151f\u6cef\ue62f\u7829\uf39a\u7578\ucf36\u46c8\ud886\u5234\ud5fc\u2f8a\ua146\u38a3\ub2bf\u3447\u8e4e\u01cb\u9b64\u1d38\u948a\uee99\u6024\ufbf6\u7d85\uf75c\u4ef7\uc0f5\u5a43\udc01\u57af\ua964\u2330\ubacb\u3cdc\ub634\u09f5\u839e\u0518\u9cec\u16a0\u6842\ue206\u65bc\uff32\u7117\uc8d9\u4262\uc425", 1554060623), a.c(763637502, "\u2eef\u5729\udd93\u478e\ucc25\u4a91\uf0c6\u7935\ue76e\u69c5\uea07\u107c\u9eae\u071b\u8d4c\u0bb1\ub5ec\u3e2f\ua490\u22c5\uab48\ud11a\u5fd9\uc01b\u427e\uc8a5\u7110\uff43\u65cb\ue3e8\u6c42\u96f1\u1cc4\u8537"))}) {
            uut.circle(drawContext, f3 + 2.0f, f6 + 5.5f, 1.4f, iov.accent());
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string3, f5 - 8.0f), f3 + 7.0f, irr.SMALL.centerTop(f6 + 5.5f), iov.textDim);
            f6 += 11.0f;
        }
        f6 += 4.0f;
        double d = tcz.unit(MinecraftClient.getInstance());
        ttb ttb2 = tiq2.mineModel();
        string3 = wap.s(a.b("\u29ac\u502b\udaf3\u449f\ucf52\u49fe\uf3b0\u7a5e\ue41e\u6eb2\ue96c\u135e\u9d93", -1348982286), a.c(-1070830805, "\u6f0d\u16a8\u9c73\u027e\u89d8\u0b63\ub12a")) + ign.ijx(d) + wap.s(a.b("\u0d26\u7408\ufe97\u60ea\ueb27\u6d8d\ud7c4", 175771025), a.b("\u59bb\u2095\uae57\u305a\ubb8e\u3d39\u877c\u0e9e", -1261938429)) + ign.iix(tiq2);
        if (ttb2 != null && ttb2.hand.unit > 0.0f && Math.abs((double)ttb2.hand.unit - d) / (double)ttb2.hand.unit > 0.15) {
            string3 = string3 + wap.s(a.c(-845924040, "\u3914\u40a5\ucae1\u5407\udfd0\u592c\ue37d\u6a87\uf4d9\u7e61\uf9e4\u038f"), a.b("\ua183\ud832\u5276\ucc90\u4747\uc595\u7ba5\uf648\u6815\ue2ae\u657c\u9f03\u11d7\u8c64\u062d", -1462722132)) + ign.ijx(ttb2.hand.unit);
        }
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string3, f5), f3, irr.SMALL.centerTop(f6 + 5.0f), iov.textMuted);
    }

    private static String iim(tiq tiq2) {
        return a.b("\u0179\u78fc\uf22e\u6c44\ue7ab\u612c\udb6c\u528b\uccd5\u466f", 1552089394).equals(tiq2.get(a.d("\u3e94\u4733\ucded\u539b\ud809\u5ee1\ue4ac\u6d40\uf303", 2109866907, -1940112015), a.c(1484887688, "\u96ce\uef4b\u6599\ufbf3\u700e\uf694\u4ccd"))) ? a.d("\u4302\u3a87\ub055\u2e3f\ua5d0\u2357\u9917\u10f0\u8eae\u0414", -621873166, 435401915) : a.d("\ub88c\uc109\u4bdb\ud5b1\u5e4c\ud8d6\u628f", 679289206, -334390852);
    }

    private void iin(DrawContext drawContext, float f, float f2, float f3, float f4, float f5) {
        String[] stringArray;
        int n;
        String string;
        tiq tiq2 = this.ihe;
        float f6 = this.ijn(drawContext, wap.s(a.c(-1002744357, "\u559d\u2c1a\ua6c4\u38b2\ub367\u35d1\u8f8b\u063d\u9830\u1296\u9543\u6f3e\ue1f4\u7853\uf20d\u74fb\ucebd"), a.b("\u2181\u5817\ud2cb\u4cbd\uc713\u41af\uff90\u7204\uec20\u669b\ue130\u1b3c\u9591", 1152198043)), f3, f4);
        tyd tyd2 = tcz.walkRecorder();
        boolean bl = tyd2 != null && tcz.sessionProfile() == tiq2;
        long l = tiq2.getLong(a.d("\u9e27\ue780\u6d5e\uf328\u78ba\ufe51\u441f\ucde4\u53b3\ud91a", -1500738065, 314839989), 0L);
        long l2 = tiq2.getLong(a.b("\u00c9\u796e\uf3b0\u6dc6\ue654\u60a6\udafd\u531d\ucd53\u47f5\uc027", -729284427), 0L);
        long l3 = tiq2.getLong(a.d("\u3cab\u450c\ucfd2\u51a4\uda36\u5cdb\ue695\u6f7e\uf120\u7b80\ufc45", -1763818375, -1916962642), 0L);
        long l4 = tiq2.getLong(a.c(-338760064, "\ueefd\u975a\u1d84\u83f2\u0860\u8e95\u34d9\ubd30\u2372\ua9c0"), 0L);
        if (bl) {
            double[] dArray = tyd2.unsaved();
            l += Math.round(dArray[0]);
            l2 += Math.round(dArray[1]);
            l3 += Math.round(dArray[2]);
            l4 += Math.round(dArray[3]);
        }
        float f7 = (f5 - 6.0f) * 0.5f;
        this.ijo(drawContext, wap.s(a.b("\u2ca9\u550f\udfda\u41a7\uca6d\u4cca\uf698\u7f68", 586427603), a.d("\u1450\u6de6\ue73a\u794c\uf2e2\u7422\uce7c\u478e", -325390788, -1774125485)), ign.ijv(l / 20L), f3, f6, f7, true);
        this.ijo(drawContext, wap.s(a.d("\uc92e\ub089\u3a57\ua421\u2ff8\ua948", 2059237127, -1937195432), a.c(-794473393, "\u4878\u31b6\ubb1b\u256d\uaeb7\u2807\u925c\u1bae")), l2 + wap.s(a.c(-977576553, "\u5db5\u2449"), a.b("\u6a5e\u17f3", -2013173124)), f3 + f7 + 6.0f, f6, f7, false);
        this.ijo(drawContext, wap.s(a.d("\ud2a8\uab04\u21cd\ubfbd\u347b\ub2dc", 812318509, 897002993), a.c(-69523901, "\u2276\u5bcb\ud168\u4f11\uc4ce\u427c\uf82e\u71a3\ueff0")), String.valueOf(l3), f3, f6 += 30.0f, f7, false);
        this.ijo(drawContext, wap.s(a.c(1728247516, "\uf6b3\u8f1d\u05d6\u9bba\u106e"), a.b("\u94fb\ued35\u67ed\uf9e1\u723a\uf48f\u4ed0", -1426222909)), String.valueOf(l4), f3 + f7 + 6.0f, f6, f7, false);
        String string2 = bl ? tyd2.module : ign.iim(tiq2);
        this.ijr(drawContext, f, f2, wap.s(a.b("\u10a2\u6936\ue3e2\u7d98\uf659\u70bb\ucaae\u434b\udd09\u57ba", 1710756068), a.b("\u457d\u3cef\ub639\u284d\ua39a\u2133\u9f7e\u16f3", 1903182190)), string2, f3, f6 += 32.0f, f5, () -> {
            if (!bl) {
                tiq2.set(a.c(-512873262, "\u2cac\u550b\udfd5\u41a3\uca31\u4cd9\uf694\u7f78\ue13b"), a.c(-2061156837, "\u3e5d\u47d8\ucd0a\u5360\ud89d\u5e07\ue45e").equals(ign.iim(tiq2)) ? a.b("\u2128\u58ad\ud27f\u4c15\uc7fa\u417d\ufb3d\u72da\uec84\u663e", -1708056221) : a.b("\u2256\u5bd3\ud101\u4f6b\uc496\u420c\uf855", 1520574992));
                tiq2.save();
            }
        }, () -> {
            if (!bl) {
                tiq2.set(a.c(-2104034611, "\ufab3\u8314\u09ca\u97bc\u1c2e\u9ac6\u208b\ua967\u3724"), a.c(-121406317, "\u7cd5\u0550\u8f82\u11e8\u9a15\u1c8f\ua6d6").equals(ign.iim(tiq2)) ? a.c(1964304519, "\ue8cc\u9149\u1b9b\u85f1\u0e1e\u8899\u32d9\ubb3e\u2560\uafda") : a.d("\u75dd\u0c58\u868a\u18e0\u931d\u1587\uafde", -95495921, 222014612));
                tiq2.save();
            }
        }, wap.s(a.c(-1746986687, "\u1957\u60d9\uea0b\u7470\uffac\u7955\uc34b\u4ab8\ud4ec\u5e4c\ud986\u23fe\uad6c\u348d\ubec2\u383e\u827e\u0db2\u9752\u1157\u98bc\ue2e0\u6c16\uf795\u71f7\ufb3c\u428e\uccce\u562f\ud02d\u5bdf\ua501\u2f44\ub6f1\u30e6\uba5c\u0581\u8fe6\u0966\u9083\u1ac0\u643c\uee2a\u69d7\uf303\u7d72\uc4ba\u4e16\uc85e\u5386\uddb2\u2734\uae9c\u28cc\ub23a\u3c62\u8798\u0110\u8b75\u12be\u9c5c\ue65a\u61bf\uebe3\u752b"), a.b("\u4975\u30ee\uba37\u2442\uaf92\u2d3a\u9375\u1a86\u84d3\u0e15\u89be\u73b8\uf903\u64d3\uee83\u6870\ud241\u5d96\uc75f\u456c\uc887\ub2da\u3c19\ua7c0\u21b7\uab65\u12d7\u9c8f\u0213\u805a\u0ff1\uf53b\u7f0c\ue6fc\u60dd\uea69\u55c9\udbd6\u5d09\uc0a7\u4af9\u340c\ube55\u3df4\ua341\u2d39\u9081\u1e28\u986b\u03df\u8db5\u7760", -127054501)));
        float f8 = 18.0f;
        float f9 = f5 - 50.0f;
        boolean bl2 = irr.inside(f, f2, f3, f6 += 20.0f, f9, f8);
        if (bl) {
            irr.primaryButton(drawContext, wap.s(a.d("\u2553\u5cc5\ud60d\u4863", 1514693325, -1911207991), a.d("\uff98\u864a\u0ce5\u9295", -744627058, -1657725133)), vhz.PAUSE, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, tcz::stop, null));
        } else {
            irr.primaryButton(drawContext, wap.s(a.c(-206198143, "\uaadd\ud35b\u598e\uc7f3\u4c39\uca9e\u7089\uf92f\u6766\uedda\u6a0e\u907d\u1ead\u8715"), a.c(433288826, "\u7262\u0bf4\u8128\u1f5e\u94f0\u1230\ua811\u21ee\ubbdd\u3509\ub2a1\u48da\uc675\u5fb9\ud598")), vhz.PLAY, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, () -> {
                tcz.startWalking(tiq2, ign.iim(tiq2));
                this.close();
                if (this.iht != null) {
                    this.iht.close();
                }
            }, null));
        }
        if (bl2) {
            this.iho = wap.s(a.b("\uea56\u93db\u1905\u8731\u0cab\u8a18\u3040\ub9a0\u27e6\uad5e\u2ac8\ud0fd\u5e3c\uc79e\u4ddb\ucb2e\u7132\ufeb7\u6418\ue244\u6bf6\u11f5\u9f5b\u0490\u82ee\u082e\ub1d4\u3f89\ua527\u2360\ua8c9\u564d\udc55\u45b2\uc3ec\u495a\uf6c6\u7cfe\ufa30\u63d5\ue9d3\u9734\u1d7d\u9acb\u001d\u8e7a\u37a0\ubd1b\u3b09\ua0c3\u2ef9\ud435\u5dd6\udbcb\u413b\ucf6a\u74ce\uf218\u7838\ue1ab\u6f07\u150f\u92b5\u18f9\u8631\u0f96\ub5cc\u3337", 1569516102), a.d("\u1b59\u62ca\ue813\u7615\ufdba\u7b7c\uc543\u48d2\ud6f5\u5c3d\udbec\u21eb\uaf4b\u3298\ubcd7\u3a2a\u8015\u0fcc\u9577\u1325\u9ad3\ue4ec\u6a53\uf59a\u73e9\uf95d\u40f7\ucea2\u5039\ud277\u59c5\ua30a\u2d58\ub4a1\u32fb\ub835\u0381\u8d91\u0b33\u928e\u1cd6\u623c\uec74\u6bbd\uf16b\u7f68\uc6be\u4c78\uce55\u519a\udfea\u2126\uacf0\u2ad0\ub02f", 704888019, -1495620703));
        }
        float f10 = f3 + f9 + 6.0f;
        float f11 = f5 - f9 - 6.0f;
        boolean bl3 = System.currentTimeMillis() - this.ihr < 3000L;
        boolean bl4 = irr.inside(f, f2, f10, f6, f11, f8);
        irr.secondaryButton(drawContext, bl3 ? wap.s(a.d("\ube08\uc79f\u4d4b\ud32d\u58a0", -1794287713, -368252479), a.b("\uf6f0\u8f5d\u05f7\u9bfc\u1028\u9298", 884142804)) : "", vhz.TRASH, f10, f6, f11, f8, bl4 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f10, f6, f11, f8, () -> this.ije(tiq2), null));
        if (bl4) {
            this.iho = wap.s(a.d("\u213c\u58ac\ud276\u4c0e\uc7c8\u4168\ufb7e\u72ce\uec9c\u662d\ue1b2\u1b91\u9551\u0ce6\u86b9U\uba0c\u35d0\uaf64\u293c\ua0df\udadd\u5421\ucff9\u49c0\uc345\u7aea\uf4ba\u6e57\ue855\u63b6\u9d65\u1737\u8ecf\u0893\u8227\u3df9\ub7cd\u3116\ua8fb\u22b8\u5c44\ud652\u51ae\ucb7b\u4501\ufcd3\u766b\uf068\u6bea\ue59e\u1f5a\u96f5\u10ae\u8a07", -311922363, -1038856182), a.c(-1048733834, "\u9378\ueade\u6009\ufe73\u75a7\uf36c\u4931\uc4ac\u5ee1\ud423\u5384\uade0\u2720\ube96\u34ca\ub23c\u080a\u87a2\u1909\u9b47\u12cf\u68e0\ue629\u7d84\ufbf8\u715d\ucc81\u42d8\udc3b\u5a68\ud1d1\u2f01\ua540\u3cc6\ubef9\u3056\u8ffe\u058c\u832d\u1a91\u90c6\uee40\u6410\ue3af\u7d1e"));
        }
        f6 += f8 + 6.0f;
        if (bl && tyd2.paused) {
            string = wap.s(a.b("\u2fd5\u5655\udc92\u42e5\uc924\u4f94\uf599\u7c72", 511061901), a.c(-1966910357, "\u5073\u29ed\ua34d\u3d48\ub698\u3423\u8e6a")) + ifv.reasonText(tyd2.pauseReason);
            n = -678620;
        } else if (bl) {
            string = wap.s(a.c(-95841273, "\u944d\uedca\u6714\uf962\u72fe\uf40e\u4e50\uc7a2\u59fc\ud344\u54d0\uaef5\u203e\ub982\u3394\ub529\u0f63\u80b5\u1a0d\u9c19\u1579\u6fbf\ue15e\u7a92\ufcf7\u7627\ucf85\u41c2\udb66"), a.d("\ub8d7\uc14a\u4b95\ud1fc\u5e34\ud884\u66c9\ueb23\u757f\uffcb\u781d\u826c\u08a3\u9185\u1b41\u99ac\u23ef\uac4e\u36f5\ub0ac\u3958\u4308\ucdc7\u561a\ud477", -265059750, 198196876)) + l3;
            n = iov.accent();
        } else {
            string = l > 0L ? wap.s(a.d("\uc12e\ub8a8\u327d\uac00\u27ca\ua16d\u1b3f\u92cf\u0cce\u8665", 2027799747, 1229391285), a.d("\u4221\u3bb7\ub16b\u2f1d\ua4b3\u2273\u982d\u11df\u8b84\u012f", -875935486, 1054543678)) + ign.ijv(l / 20L) : wap.s(a.b("\u17f5\u4e62\ue493\u7ae3\uf124\u77d8\ucd8f\u4479\uda3d\u508d\ud74f\u2d28\ua3ac\u3a52\ub008\u36bf\u8ca7\u0360\u99de\u1f88\u967d\uec2b\u6291\uf907\u7f31\uf5fa\u4c1a\uc20e\u58f2\udea2\u550b\uabc8\u2188\ub831\u3e36\ub49c\u0b04\u8121\u07f4\u9e56\u1401\u6af7", 1736120298), a.c(-1667811486, "\u3353\u4acd\uc06a\u5a74\ud5bd\u5303\ue922\u60d7\ufefa\u7443\uf395\u0993\u832b\u1eff\u94db\u1228\ua815\u27be\ubd77\u3f44\ub6a6\uecd1\u4240\ud990\u5fff\ud132\u6885\ue6d1\u7c58\ufa08\u75d9\u8f6d\u0559\u9ca2\u1a89\u9045\u2fe8"));
            n = iov.textMuted;
        }
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, f5), f3, irr.SMALL.centerTop(f6 + 4.0f), n);
        f6 += 16.0f;
        f6 = this.ijn(drawContext, wap.s(a.b("\uee63\u97ed\u1d37\u8353\u08d0\u8e28\u3461\ubdc3\u23ce\ua968\u2ebd\ud4c0\u5a0a\uc3ad\u49ff\ucf0f", 423947812), a.d("\uf67c\u8fa8\u0507\u9f68\u10a0\u9616\u2c35\ua5b9\u3b91\ub123\u36fe", 1374774384, -313944544)), f3, f6);
        for (String string3 : stringArray = new String[]{wap.s(a.d("\u21df\u5869\ud2a2\u4c84\uc70a\u41ad\ufbe4\u7240\uec59\u66e1\ue131\u1b40\u9594\u0c3d\u8639\u009c\ubacf\u3513\uafe5\u29f8\ua00a\uda5c\u54e4\ucf6a\u490f\uc3a9\u7a6d\uf45d\u6ecb\ue8e9\u6329\u9d9c\u17bb\u8e46\u0846\u82f4\u3d21\ub74b\u319f\ua834\u2233\u5cce\ud6d7\u5179\ucbb6\u45da\ufc0a", 329303172, -799611620), a.d("\u3237\u4b8c\uc155\u5b3e\ud4f1\u524c\ue87a\u6192\uffc9\u7114\uf2d8\u08a8\u8261\u1fcb\u959b\u136f\ua925\u26f4\ub845\u3e0e\ub78e\ucda8\u437a\ud8ca\u5ec6\ud464\u6db3\ue38a\u7971\ufb41\u708c\u8e22\u0415\u9de1\u1bcd\u9512\u2ac9\ua4a7\u220b\ubbb1\u3193\u4f6e\uc53f", 425941720, 723741950)), wap.s(a.c(1019366043, "\u4acc\u336b\ub9a2\u27d4\uac51\u2ab3\u90e3\u1907\u8758\u0de8\u8a7f\u704f\ufe97\u672c\ued3b\u6b93\ud1ca\u5e01\uc4b5\u42b6\ucb02\ub151\u3fee\ua437\u225f\ua89d\u116f\u9f6a\u059c\u83ca\u0865\uf6a9\u7cb5\ue513\u635f\ue9ef\u563d\udc45\u5ad3\uc335\u497c\u3780\ubdd4\u3a67\ua0b7\u2ecf"), a.d("\u4f2e\u36ef\ubc30\u2230\uad88\u2f58\u9570\u1c85\u82a4\u086b\u8fc7\u75b5\ufb6c\u66b1\ue8fa\u6a13\ud443\u5b93\uc12c\u4771\ucef8\ub4d7\u3a18\ua5ab\u27ce\uad15\u14aa\u9af2p\u862a\u09f2\uf33c\u790c\ue085\u62ce\uec1a\u53b6\ud9cd\u5f66\uc6aa\u4cf1", -1726419269, -1761696258)), wap.s(a.c(2074456815, "\ub2a0\ucb16\u41dd\udffb\u5475\ud2d2\u689b\ue13f\u7f23\uf59e\u7250\u8821\u06e1\u9f56\u1512\u93b7\u29af\ua661\u3cdf\uba85\u333c\u4934\uc791\u5c5a\uda70\u50ed\ue957\u6702\ufde2\u7ba0\uf056\u0ed3\u8480\u1d7c\u9b6a\u1197\uae45\u2433\ua2eb"), a.c(1400379055, "\u12b1\u6b0a\ue1d3\u7bb8\uf470\u72c0\uc892\u411c\udf33\u5580\ud25a\u285f\ua6f2\u3f3e\ub569\u3395\u89d4\u0266\u98d9\u1a9d\u931e\ue935\u6785\uf84c\u7a50\uf08a\u4920\uc71b\u59f7\udbc7\u5415\uaedf\u2493\ubd67\u3b31\ub180")), wap.s(a.b("\ub694\ucf26\u45f5\udb9f\u5055\ud6e3\u6cb9\ue50f\u7b19\uf1b2\u7632\u8c0d\u02db\u9b71\u1176\u97d5\u2d8d\ua25a\u38e5\ubea9\u3748\u4d18\uc3aa\u5825\ude40\u54c5\ued6a\u6336\uf984\u7f97\uf429\u0ae3\u80f8\u194d\u9f15\u15ae\uaa6f\u204d\ua6d7\u3f7b", -1301236016), a.b("\u9926\ue0ef\u6a3d\uf43e\u7fe4\uf950\u430e\uceea\u54a8\ude11\u5dd7\ua3b9\u2d69\ub4a8\u3e86\ub800\u024c\u8d93\u1355\u951e\u18fc\u62ab\uec15\u73da\uf1b1\u7b61\uc2dc\u4c86\ud674\u5052\udf83\u2543\uaf03\u368e", 300784959))}) {
            uut.circle(drawContext, f3 + 2.0f, f6 + 5.5f, 1.4f, iov.accent());
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string3, f5 - 8.0f), f3 + 7.0f, irr.SMALL.centerTop(f6 + 5.5f), iov.textDim);
            f6 += 11.0f;
        }
        double d = tcz.unit(MinecraftClient.getInstance());
        String string4 = wap.s(a.c(-792372005, "\u5c85\u2502\uafda\u31b6\uba7b\u3cd7\u8699\u0f77\u9137\u1b9b\u9c45\u6677\ue8ba"), a.b("\u8966\uf0c3\u7a18\ue415\u6fb3\ued08\u5741", 1492356416)) + ign.ijx(d) + wap.s(a.c(1616488958, "\ua949\ud067\u5af8\uc485\u4f48\uc9e2\u73ab"), a.b("\ua88f\ud1a1\u5f63\uc16e\u4aba\ucc0d\u7648\uffaa", 1520347191)) + ign.iix(tiq2);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string4, f5), f3, irr.SMALL.centerTop((f6 += 4.0f) + 5.0f), iov.textMuted);
    }

    private void iio(DrawContext drawContext, float f, float f2, tiq tiq2, float f3, float f4, float f5) {
        txs txs2 = tiq2.walkModel();
        if (txs2 == null) {
            boolean bl = a.c(1353163000, "\ua094\ud926\u53fd").equals(tiq2.walkIssue());
            irr.LABEL.draw(drawContext, bl ? wap.s(a.b("\u0b92\u7200\uf8db\u66ee\ued74\u6bc7\ud19f\u586f\uc639\u4cde\ucb17\u3132\ubfe3\u2641\uac1a\u2aec\u90ed\u1f7d\u85c8\u039f\u8a60\uf036", 1720257483), a.b("\u806a\uf9b8\u7319\ued18\u66bf\ue071\u5e4d\ud3a0\u4dfd\uc746\u4094\ubaeb\u344b\ua98c\u23c5\ua12a\u1b6a\u94c9\u0e7e\u8850\u05bf\u7bf9\uf54d\u6e91\ue8ed\u6230\udb8f", -1586658224)) : wap.s(a.b("\uc69e\ubf0e\u35c6\uabe3\u2060\ua6d7\u1c97\u956e\u0b36\u818c\u065e\ufc6b\u72e5\ueb48\u610a", 645973727), a.c(261866376, "\uc793\ube7e\u34b5\uaeb5\u217f\ua7c6\u1980\u946f\u0a3f\u80fc\u072b\ufd28\u73f7\uea4b")), f3, irr.LABEL.centerTop(f4 + 6.0f), iov.textMuted);
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.b("\u2b80\u5207\ud8d9\u46af\ucd33\u4bd6\uf199\u7865\ue67f\u6c82\ueb54\u1122\u9ffe\u0659\u8c59\u0af1\ub0a8\u3f63\ua5d7\u2387\uaa66\ud03e\u5e87\uc510\u4329\uc9f1\u705f\ufe5c\u64be\uc2c9\u6958\u9788\u1dd7\u846b\u023c\u888a\u3746\ubd36\u3bf4\ua253\u2853\u56ae\udca9\u5b04\uc1de\u4fa4\uf639\u7cdc\ufa95\u6157\uef2c\u15fa", 1524771811), a.d("\u03a1\u7a31\uf099\u6e93\ue54e\u63f3\uddb8\u5056\uce08\u40a7\uc36f\u391d\ub7cf\u2e7b\ua45f\u22dd\u9c8e\u173e\u8dfc\u0ba1\u864a\ufc0e\u529b\ue968\u6f16\ue5d7\u5878\ud62d\u4cdf\ucaf0\u4142\ubbfd\u31be\uac50\u2a02\ua0cf\u1f64\u9517\u17d8\u8a77'\u7ea4\uf4f3\u733d", 328496231, -561220619)), f5), f3, irr.SMALL.centerTop((f4 += 16.0f) + 4.0f), iov.textMuted);
            return;
        }
        String string = new SimpleDateFormat(a.d("\ubcd9\uc568\u4ff1\ud1e3\u5a34\udce8\u66d3\uef22\u710f\ufbe9\u7c3a", -534635936, -1474386218), Locale.ROOT).format(new Date(txs2.created));
        irr.LABEL.draw(drawContext, wap.s(a.b("\u89a9\uf02e\u7af0\ue486\u6f49\ue9ab\u53b4\uda40\u441d\ucea2\u4934\ub31c\u3ddd\ua476\u2e70", 586451441), a.c(797861510, "\u62b1\u1b1b\u91c2\u0fcb\u8461\u02d1\ubc92\u3179\uaf2c\u2597\ua65e\u584c\ud2f8\u4f2b\uc50f\u43fa\uf9cb\u7275")) + Math.round(txs2.keysAcc) + a.b("\u082b", -261945329), f3, irr.LABEL.centerTop(f4 + 6.0f), txs2.keysAcc > txs2.keysBase + 5.0 ? iov.accent() : iov.text);
        irr.SMALL.drawRight(drawContext, string + a.d("\ue837\u9186\u1bc2\u8524\u0ef3", -840447058, 1217012668) + ign.ijv(txs2.samples / 20), f3 + f5, irr.SMALL.centerTop(f4 + 6.0f), iov.textMuted);
        txp txp2 = txs2.style;
        this.ijp(drawContext, wap.s(a.c(-377017069, "\u2d4d\u54d2\ude1d\u4066\ucbe2\u4dc4\uf700\u7ebb\ue0fb\u6a4c\ued98\u17bd\u993e\u0093\u8acd\u0c79\ub663\u39b4\ua301\u2544\uacbe"), a.d("\ude01\ua791\u2d49\ub33a\u38e7\ube26\u0405\u89ec\u1724\u9d02\u1ece\ue4c0\u6a69\uf3a7\u79f7\uff7a\u412b\ucae4\u5058\ud673\u5f88\u25a3\uab66\u30c9", -1371753526, -1912378935)), ign.ijd(txs2.keysAcc) + a.c(-1179419371, "\u7d36\u0410\u8e54") + ign.ijd(txs2.keysBase), f3, f4 += 15.0f, f5);
        this.ijp(drawContext, wap.s(a.b("\uf6f8\u8f6b\u05b4\u9bcd\u100d\u96af\u2cbd\ua518\u3b46\ub1f0\u363f\ucc53\u42d7\udbf1\u5135\ud787\u6dce\ue213\u78a5\ufef1\u7701\u0d59", 1816524461), a.b("\u8241\ufbd1\u710e\uef73\u64da\ue215\u583a\ud5a9\u4fec\uc557\u4288\ub8f0\u3652\uafe8\u21d0\ua7b6\u1d6e\u96a0\u0c12\u8a3f\u03b4\u79e0\uf756\u6c83", 1540851270)), ign.ijd(txs2.yawSim) + a.b("\u7209\u0b2f\u816b", 1170305578) + ign.ijd(txs2.yawCeil), f3, f4 += 12.0f, f5);
        this.ijp(drawContext, wap.s(a.d("\u8bd1\uf242\u789d\ue6e4\u6d24\ueb86\u5194\ud835\u4673\uccdf\u4b1b\ub161", -613411121, 1865784657), a.c(1962264956, "\ucd6c\ub4f0\u3e29\ua059\u2b8b\uad39\u1377\u9e9c\u00c9\u8a74\u0dae\uf7aa\u7976")), ign.ijd(txs2.pitchSim), f3, f4 += 12.0f, f5);
        this.ijp(drawContext, wap.s(a.d("\u766b\u0fe5\u852e\u1b42\u9096\u1674\uacb0\u25d6\ubbda\u3168\ub6b9\u4cd3\uc203\u5ba8", 1263517987, 333297420), a.b("\uc564\ubc8a\u3652\ua85e\u2385\ua536\u1b7d\u921b\u0cd3\u8203\u05ae\uffa0\u710f\ue8bb\u6297", -1030569612)), ign.ijd(txs2.jumpAcc) + a.b("\u34ef\u4dc9\uc78d", 59847884) + ign.ijd(txs2.sprintAcc), f3, f4 += 12.0f, f5);
        this.ijp(drawContext, wap.s(a.c(1328343975, "\uebec\u926b\u18a2\u86d4\u0d51\u8bb0\u31f2\ub801\u2658\uacac\u2be8\ud10e\u5f8a\uc638\u4c69\uca83\u70cb\uff00"), a.c(-1605097522, "\u23fe\u5a5f\ud080\u4ef6\uc138\u43eb\uf9cf\u7037\uee6b\u60c5\ue781\u1d67\u97d1\u0e1e\u8432\u02bb\ub8f1\u375f")), ign.ijw(txp2.speed) + wap.s(a.c(417530513, "\u02b6\u7b4a\uf1db\u6ff6\ue472\u6254\ud890"), a.b("\u9c96\ue13b\u6ffb\uf5e4\u7a52\ufc74\u46b0", -611738447)) + Math.round(txp2.sprintShare * 100.0f) + a.d("\u1e91", -698866516, 1394162201), f3, f4 += 12.0f, f5);
        double d = ign.iip(txs2);
        this.ijp(drawContext, wap.s(a.b("\ud1f9\ua865\u22ad\ubc88\u3711\ub1a1\u0bea", -746270276), a.d("\u1f26\u66b8\uec17\u7604\uf9b2\u7f77\uc528\u4ca7\ud28f\u584f", -1879058441, -1555837750)), d < 0.0 ? wap.s(a.c(-1123496452, "\ucd9d\ub42d\u3ee5\ua0c0\u2b40\uade7\u17b9\u9e4f\u0012\u8aa4\u0d7e\uf748\u79c6\ue06b\u6a29"), a.b("\u28e1\u512c\udbe7\u41e7\uce2d\u4894\uf6d2\u7b46\ue562\u6fd9\ue806\u1274", -414896936)) : ign.ijw(d) + wap.s(a.b("\u84b4\ufd48\u77d9\ue9f4", -24607600), a.c(610902530, "\ua226\udf8b\u514b\ucb54")), f3, f4 += 12.0f, f5);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.c(-1969002264, "\u6894\u112e\u9bf0\u0587\u8e58\u08e7\ub2b5\u3b00\ua510\u2fa0\ua83d\u521b\udcda\u4566\ucf32\u49c1\uf389\u7c51\ue6a5\u60bd\ue957\u9352\u1daf\u8675\u0019\u8adb\u337f\ubd7c\u27d8\ua19b\u2a3e"), a.d("\u3639\u4ff7\uc55a\u5b27\ud0f7\u5633\uec15\u65ec\ufbb0\u751f\uf6d1\u0cad\u866a\u1bbe\u9196\u176d\uad5a\u22f6\ub841\u3a09\ub3f2\ucdb9\u430e\ud8a3\u5ea0\ud40f\u6dc2\ue394\u7d7a\uff36\u748d\u8e49\u0014\u99ef\u1fb0\u9500\u2ad9\ua0a3", -219000085, 90464459)), f5), f3, irr.SMALL.centerTop((f4 += 12.0f) + 4.0f), iov.textMuted);
        float f6 = 18.0f;
        boolean bl = lfa.walksWith(tiq2);
        boolean bl2 = irr.inside(f, f2, f3, f4 += 13.0f, f5, f6);
        if (bl) {
            irr.secondaryButton(drawContext, wap.s(a.d("\u939f\uea1a\u60c8\ufea2\u755f\uf3c5\u499c\uc029\u5e79\ud4c7\u5375\ua930\u27e6\ube4c\u3427\ub2e0\u08bc\u877b\u1dc9\u9b93\u122a\u682c\ue689\u7d55\ufb2d\u71b7\uc853\u461c\udcf6\u5abb\ud140\u2fd8\ua58a", 1534695411, 1921319948), a.c(509993946, "\ue386\u9a03\u10d1\u8ebb\u0546\u83dc\u3985\ub030\u2e60\ua4de\u236c\ud929\u57ff\uce55\u443e\uc2f9\u78a5\uf762\u6dd0\ueb8a\u6233\u1c07\u92cf\u0914\u8f10\u05cc\ub81d\u3259\ua8a2")), vhz.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                lfa.activateWalk(null);
                this.iib(wap.s(a.b("\u8084\uf909\u73d7\uede3\u6679\ue0ca\u5a92\ud372\u4d34\uc78c\u4049\uba6b\u34eb\uad4c\u2712\ua1e4\u1be0\u947e\u0ecc\u88d3\u0170\u7b3d\uf583\u6e5e\ue83a\u62b9\udb45\u550c\ucfe2\u49fd\uc20f\u3cd8\ub691\u2f68\ua93c", -668761869), a.b("\uca0e\ub39d\u3944\ua742\u2ced\uaa5f\u1414\u9984\u07a7\u8d15\u0aca\uf0b9\u7a7e\ue7aa\u6d82\ueb79\u514d\ude91\u4040\uc270\u4bf6\u31ab\ubf1c", 333303301)), vhz.INFO, false);
            }, null));
            if (bl2) {
                this.iho = wap.s(a.c(-1066715547, "\u3602\u4f9c\uc54a\u5b31\ud0ee\u5614\ucc73\u65b6\ufbab\u7119\uf6c8\u0cb1\u822d\u1bc8\u9180\u173e\uad25\u22e8\ub856\u3e42\ub7f7\ucdb1\u431e\ud8ca\u5ead\ud425\u6dd2\ue384\u793d\uff3b\u749e\u8a42\n\u99f9\u1fad\u9515"), a.c(473529472, "\u78ba\u012a\u8bfa\u1589\u9a44\u3cc1\ua6a6\u2b45\ub51d\u3fd9\ub877\u4278\uccae\u5511\udb2e\u59cd\ue3f1\u6c23\uf692\u70bd\uf941\u8318\u0dab\u9604\u1076\u9ec9\u231f\uad35\u37c8\ub1e1\u3a2f\uc48c"));
            }
        } else {
            irr.primaryButton(drawContext, wap.s(a.b("\uf0fe\u8969\u03ac\u9d98\u1606\u90b0\u2aad\ua33d\u3d56\ub7e6\u302e\uca75\u4489\udd32\u5725\ud1db\u6b9b\ue42b\u7eac\uf8fc\u7110\u0b79\u85fc\u1e3e\u9857\u1287\uab3f", 42201264), a.d("\ue69c\u9f74\u15d9\u8ba9{\u86bd\u3c95\ub56d\u2b3e\ua18d\u262c\udc53\u56e8\ucb4b\u450a\uc39a\u79e1\uf631\u6c99\ueae2\u633e\u1965\u9792\u0c4c\u8a3c\u008c\ub90b\u375b\uadb7\u2bde\ua05b\u5e99\ud4c0\u4d30\ucb68", 1745599005, -1536599878)), vhz.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                lfa.useForWalk(tiq2);
                this.iib(wap.s(a.c(-1949945616, "\u308a\u490f\uc3dd\u5db7\ud64a\u50d0\uea89\u633c\ufd22\u779c\uf045\u0a70\u84c6\u1d43\u9711\u11fb\uab8c\u246b\ubecb\u388c\ub17a\ucb20\u45dd\ude5b\u5832\ud2ee\u6b5a\ue540\u7ffb\uf9af\u721e\u8cc1\u06cb\u9f63\u1926\u938d\u2c0f\ua630\u20e2\ub94b\u3343\u4dba\uc78f\u4015\udad2\u54a4\ued6a\u67e6\ue194\u7a5e\uf438\u0efc\u8756\u0101\u9bf3\u15ec\uae1c\u28cc\ua2f8"), a.b("\u1a7a\u63ff\ue92d\u7747\ufcba\u7a20\uc079\u49cc\ud38b\u5d22\uda90\u20d5\uae03\u37a9\ubdc2\u3b05\u8159\u0e9e\u942c\u1276\u9bcf\ue5fb\u6b33\uf0e8\u76ec\ufc30\u41e1\ucbaa\u5157\ud70c\u58a5\ua216\u2850\ub5ca\u3391\ub946\u06ba\u8cdb\u0a0f\u93a3\u19c1\u670d\ued45\u6ae1\uf023\u7e4f\uc79a\u4d2a\ucb2b\u54e8\uda93\u2043\ua981\u2fd9\ub53c\u3b01\u84aa", -1923212798)), vhz.CHECK, false);
            }, null));
            if (bl2) {
                this.iho = wap.s(a.c(726348237, "\u31b4\u4839\uc2e7\u5cd3\ud749\u51fa\ueba2\u6242\ufc04\u76bc\uf179\u0b5b\u85db\u1c7c\u9622\u10d4\uaad0\u2555\ubffa\u39a6\ub05d\uca17\u44f6\udf75\u5917\ud3dc\u6a6e\ue42e\u7ecf\uf8cd\u7329\u8de6\u07b4\u9e59\u1842\u92a7\u2d6c\ua71c\u21d5\ub837\u3225\u4cd6\uc68e\u413e\udbe0"), a.b("\u1813\u6180\ueb59\u755f\ufef0\u7842\uc609\u4b9d\ud5b9\u5f02\ud8aa\u22d6\ua863\u35cd\ubf9f\u3d70\u8323\u0cfe\u963d\u1064\u999b\ue3c9\u6d7b\uf6d8\u70ab\ufe66\u43b8\ucde6\u576d\ud13b\u5e91\ua45c\u2e11\ub7ea\u31b8\ubb07\u04a7\u8ed4", -1347871703));
            }
        }
    }

    private static double iip(txs txs2) {
        double d = -1.0;
        for (tvz tvz2 : new tvz[]{mpq.mainInstance() == null ? null : mpq.mainInstance().walkBrain(), nxa.mainInstance() == null ? null : nxa.mainInstance().walkBrain()}) {
            if (tvz2 == null || tvz2.model != txs2) continue;
            d = Math.max(d, tvz2.speed());
        }
        return d;
    }

    private void iiq(DrawContext drawContext, float f, float f2, float f3, float f4, float f5) {
        boolean bl;
        tiq tiq2 = this.ihe;
        if (tiq2.walk()) {
            this.iin(drawContext, f, f2, f3, f4, f5);
            return;
        }
        if (tiq2.mine()) {
            this.iil(drawContext, f, f2, f3, f4, f5);
            return;
        }
        float f6 = this.ijn(drawContext, wap.s(a.c(22363561, "\u3df2\u4474\ucea1\u50dc\udb16\u5db1\ue7ef\u6e19\uf04f"), a.d("\ud34f\uaad9\u2005\ube73\u35dd\ub361", -1052623169, 1499720161)), f3, f4);
        long l = tiq2.getLong(a.d("\ud8ea\ua15a\u2b94\ub5e2", 641116134, 1717272416), 0L);
        long l2 = tiq2.getLong(a.d("\ue76b\u9ed5\u1403\u8a6a\u01ac\u870a\u3d4e\ub4be", 1935427227, 448242078), 0L);
        long l3 = tiq2.getLong(a.d("\u81d1\uf87d\u72a4\uecdd\u6712", -343667184, -104689744), 0L);
        boolean bl2 = bl = tcz.mode() == tcw.RECORD && tcz.sessionProfile() == tiq2 && tcz.recorder() != null;
        if (bl) {
            l += (long)tcz.recorder().hits;
            l2 += (long)tcz.recorder().failures;
            l3 += (long)tcz.recorder().recorded;
        }
        float f7 = (f5 - 6.0f) * 0.5f;
        this.ijo(drawContext, wap.s(a.c(-1716408675, "\uaef3\ud74a\u5d99\uc3e3\u4870\uce89\u74db\ufd37\u636f"), a.b("\u7d2c\u04ea\u8e3d\u103b\u9b96\u1d51\ua70c\u2a98\ub0a4\u3a62\ubdb5\u47b4\uc91d\u50a0", 1596815713)), String.valueOf(l), f3, f6, f7, true);
        this.ijo(drawContext, wap.s(a.b("\u98f3\ue146\u6b8f\uf5fe\u7e3f\uf898\u4298\ucb2f\u557f\udfcb\u5800\ua260\u2ca0\ub506\u3f54", 914004113), a.b("\u78f7\u0139\u8b94\u15e7\u9e3c\u18f8\ua2d0\u2b2d\ub160\u3fcf\ub860\u4212\uccb1\u557a\udf5b\u59a9", 707099864)), String.valueOf(l2), f3 + f7 + 6.0f, f6, f7, false);
        this.ijo(drawContext, wap.s(a.b("\u756c\u0cca\u861f\u1862\u93a8\u150f\uaf5d\u26ad", 2064676118), a.b("\u7bb2\u0204\u88d8\u16ae\u9d00\u1bc0\ua19e\u286c", -1208385651)), ign.ijv(l3 / 20L), f3, f6 += 30.0f, f7, false);
        this.ijo(drawContext, wap.s(a.d("\ufd62\u84c5\u0e00\u9071\u1bbc\u9d0b\u2759\uaeb5", -348315450, -1418076705), a.c(-456505159, "\u4cfe\u353b\ubf9c\u21ed\uaa43\u2cf3")), String.valueOf(tiq2.getLong(a.c(-906276409, "\u51bc\u281b\ua2de\u3caf\ub762\u31d5\u8b87\u026b"), 0L)), f3 + f7 + 6.0f, f6, f7, false);
        float f8 = 18.0f;
        float f9 = f5 - 50.0f;
        boolean bl3 = irr.inside(f, f2, f3, f6 += 32.0f, f9, f8);
        if (bl) {
            irr.primaryButton(drawContext, wap.s(a.d("\u8114\uf882\u724a\uec24", -1432357890, 2126525), a.b("\u908c\ue95e\u63f1\ufd81", 201954473)), vhz.PAUSE, f3, f6, f9, f8, bl3 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, tcz::stop, null));
        } else {
            irr.primaryButton(drawContext, wap.s(a.d("\u5368\u2aee\ua03b\u3e46\ub58c\u332b\u893c\u0082\u9edc\u1423\u93a3\u69d5\ue717\u7ea9\uf4f0\u7216", 1744584573, 1547201623), a.d("\u1004\u6992\ue34e\u7d38\uf696\u702a\uce15\u4385\udda5\u530a\ud0b8\u2aca\ua46a\u3dd3\ub789\u317c\u8b3f\u04ea", -1113599634, -1444887185)), vhz.PLAY, f3, f6, f9, f8, bl3 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, () -> {
                tcz.startRecording(tiq2);
                this.close();
                if (this.iht != null) {
                    this.iht.close();
                }
            }, null));
        }
        if (bl3) {
            this.iho = wap.s(a.c(1737059567, "\u6cf9\u156f\u9fa9\u01d7\u8a0a\u0cac\ub6ac\u3f1c\ua152\u2be3\uac25\u5650\ud894\u4177\ucb65\u4d87\uf7d5\u781e\ue2b6\u64ed\ued5e\u9756\u19f3\u8238\u0408\u8ec3\u3738\ub968\u2382\ua587\u2e60\ud0ad\u5aef\uc316\u4508\ucfe0\u7021\ufa4a\u7c9e\ue52e\u6f67\u119f\u9bc6\u1c3d\u86e6\u08d8\ub10a\u3bb9\ubde3\u266b\ua85f\u5286\udb31\u5d6b\uc7dc\u49cc\uf27b\u74ae\ufed9\u670f\ue9b1\u93a7\u141d\u9e56\u00ca\u8930\u336d\ub589\u3fda"), a.d("\u557a\u2ce7\ua630\u383b\ub3ef\u352e\u8b6e\u0680\u98de\u121e\u95b0\u6fbc\ue166\u78d4\uf289\u7017\uce39\u41eb\udb2f\u5d76\ud488\uaea6\u2464\ubfaf\u3dc1\ub714\u0eab\u84e3\u1a0c\u9c20\u13f6\ue946\u6378\ufa85\u78c6\uf27b\u49be\uc7dd\u4510\udcae\u5683\u2876\ua257\u25ee\ubf3c\u3140\u8c86\u022f\u846c\u1fca\u91b8\u6f0b\ue2de\u64f3\ufe05\u7023\ucbea\u4d3f\uc352\u5ee0\ud020\uaa75\u2df1\ua7da\u3963\ub0ac\u0eea\u8c06\u065c\u99ef\u133b\u954b\u6c95\ue62c\u787a\uf3fc", 22231354, 1298622494));
        }
        float f10 = f3 + f9 + 6.0f;
        float f11 = f5 - f9 - 6.0f;
        boolean bl4 = System.currentTimeMillis() - this.ihr < 3000L;
        boolean bl5 = irr.inside(f, f2, f10, f6, f11, f8);
        irr.secondaryButton(drawContext, bl4 ? wap.s(a.b("\u684c\u11db\u9b0f\u0569\u8ee4", 794781722), a.d("\u6f9c\u1631\u9c9b\u0290\u8944\u0bf4", -486026419, 115521781)) : "", vhz.TRASH, f10, f6, f11, f8, bl5 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f10, f6, f11, f8, () -> this.ije(tiq2), null));
        if (bl5) {
            this.iho = wap.s(a.b("\u50e2\u2972\ua3a8\u3dd0\ub616\u30b6\u8aa0\u0310\u9d42\u17f3\u906c\u6a4f\ue48f\u7d38\uf767\u718b\ucbd2\u440e\udeba\u58e2\ud101\uab03\u25ff\ube27\u381e\ub29b\u0b34\u8564\u1f89\u998b\u1268\uecbb\u66e9\uff11\u794d\uf3f9\u4c27\uc613\u40c8\ud925\u5366\u2d9a\ua78c\u2070\ubaa5\u34df\u8d0d\u07b5\u81b6\u1a34\u9440\u6e84\ue72b\u6170\ufbd9", -724414319), a.b("\u9bb3\ue215\u68c2\uf6b8\u7d6c\ufba7\u41fa\ucc67\u562a\udce8\u5b4f\ua52b\u2feb\ub65d\u3c01\ubaf7\u00c1\u8f69\u11c2\u938c\u1a04\u602b\ueee2\u754f\uf333\u7996\uc44a\u4a13\ud4f0\u52a3\ud91a\u27ca\uad8b\u340d\ub632\u389d\u8735\u0d47\u8be6\u125a\u980d\ue68b\u6cdb\ueb64\u75d5", -1779130435));
        }
        this.ijq(drawContext, f, f2, wap.s(a.c(-125093505, "\u393f\u40b9\uca6c\u5411\udfdb\u597c\ue36b\u6ac8\uf480\u7e35\uf9eb\u03d6\u8d47\u14f9\u9ea4\u185a\ua209\u2ddf"), a.b("\ueb61\u92f7\u185d\u865d\u0df8\u8b47\u3578\ub8e9\u26c3\uac77\u2baf\ud1a9\u5f0f\uc6c8\u4ce5\uce01\u705f\uff81\u6534", -1898582163)), tiq2.fights(), f3, f6 += f8 + 6.0f, f5, () -> {
            tiq2.set(a.d("\u5e2c\u2792\uad4f\u3331\ub8fa\u3e4c", -21585824, 543686188), !tiq2.fights());
            tiq2.save();
        }, wap.s(a.c(-1991706054, "\ufa1f\u8383\u094f\u9722\u1cba\u9a59\u201d\ua9ea\u37b9\ubd15\u3ad0\uc0b6\u4e32\ud7da\u5d9f\udb74\u613c\ueebf\u744a\uf214\u7bed\u01b3\u8f1c\u14ca\u92e6\u1860\ua1cd\u2f81\ub56a\u3373\ub890\u465d\ucc1f\u55f6\ud3b9\u591f\ue6c9\u6ceb\uea6f\u73c1\uf99f\u876b\u0d31\u8ac5\u1073\u9e2a\u27fd\uad60\u2b1d\ub0cc\u3ea5\uc46e\u4dde\ucbdb\u5169\udf37\u6482\ue217\u6830\uf1fd\u7f47\u0553\u82e2\u08be\u966a\u1fdc\ua5dc\u236c\ua928\u368e\ubc18\u3a26\uc3f0\u4941\ud754\u5cad\udabb\u600d\ue9c4\u77ae\ufd2e\u7b2b\u0084\u8e58\u146a\u9deb\u1b5a\ua116\u2ee0\ub4be\u3208\ubbd0\u41e2\ucf7a\u54ce\ud2d1\u584b\ue63c\u6ff9\uf504"), a.c(-339504338, "\u976f\ueef9\u645a\ufa56\u71f6\uf325\u4d6e\uc087\u5aba\ud07b\u57a4\uadd3\u271c\ubabc\u30e0\ub617\u0840\u83f0\u1d22\u9f6b\u1697\u6cb5\ue278\u79ad\uffd8\u7505\uccb2\u46f7\udc0c\u5e42\ud5f0\u2b25\ua160\u3c81\ubab3\u302a\u8ff9\u05a4\u8345\u1af4\u90b1\uee5a\u640e\ue3eb\u7d24\uf74d\u4a8f\uc031\u4602\uddda\u57c2\ua901\u20cf\ua6ef\u3c1d\ub239\u098f\u8f2c\u0557\u9cf0\u162c\u6c75\uef9c\u61df\ufb0f\u72c1\uc8ec\u4e67\uc44c\u5bfe\ud15a\u534b\uaa98\u2433\uba64\u31e9\ub7c2\u0d0d\u84d5\u1ad6\u9400\u1649\u6d83\ue32c\u795a\uf08e\u764a\ucc60\u43eb\ud9cc\u5f08\ud6da\u2ca3\ua614")));
        f6 += 22.0f;
        f6 = this.ijn(drawContext, wap.s(a.c(254767929, "\u736c\u0afa\u803c\u1e42\u959f\u1339"), a.b("\ucf34\ub6e6\u3c42\ua23b\u29e5\uaf2b", -478229741)), f3, f6);
        this.ijs(drawContext, f, f2, wap.s(a.d("\u3a4b\u43d6\uc91f\u5775\udcb8", -2004408969, 134422394), a.d("\uef4b\u96de\u1c08\u827a\u09d2\u8f11\u3536\ubcc4\u22eb\ua856", -1428462991, 1983416618)), String.valueOf(tiq2.standCount()), f3, f6, f5, () -> ign.ijg(tiq2, a.c(1367169997, "\u5bb2\u2204\ua8c2\u36bc\ubd61\u3bc7\u81c9\u0875\u9626\u1c8d\u9b45\u612e"), tiq2.standCount() - 1), () -> ign.ijg(tiq2, a.d("\u5214\u2ba2\ua164\u3f1a\ub4c7\u3261\u886f\u01d3\u9f80\u152b\u92e3\u6888", 866488164, -1991713521), tiq2.standCount() + 1), wap.s(a.c(293975801, "\ub698\ucf0b\u45c5\udba3\u5031\ud6d3\u6c87\ue563\u7b33\uf188\u764c\u8c6e\u228d\u9b08\u1116\u97e5\u2db7\ua271\u3887\ube85\u3776\u4d39\uc397\u5851\ude25\u54f5\ued41\u6319\uf9a9\u7fba\uf40e\u0ace\u8082\u1961\u9f32\u1588\uaa11\u2034\ua6f2\u3f50\ub51a\ucbe9\u41ab\uc61d"), a.d("\ufba2\u823c\u08ea\u96ec\u1d3f\u9bf3\u25b5\ua825\u3679\ubcbf\u3b64\uc11c\u4fc1\ud67c\u583d\ufef8\u6483\uef43\u75ff\uf3ab\u7a2b~\u8eb0\u1174\u9314\u19cf\ua009\u2e2d\ub4dd\u3280\ub939\u47e2\ucda1\u5042\ud20d\u58b5\ue761\u6d12\uebb6\u7664\uf85d\u86df\u0c82\u8b47\u11e3\u9f96", -286961977, -618286758)));
        this.ijr(drawContext, f, f2, wap.s(a.b("\uf33d\u8aabu\u9e0d\u15cd\u9363\u2936\ua0dd\u3e85", -1933380746), a.b("\u6e53\u17c3\u9d1c\u036a\u88bc\u0e0c\ub457\u3da3\ua3f1", -1659082171)), ign.ijk(tiq2.standMode()), f3, f6 += 16.0f, f5, () -> ign.ijj(tiq2, a.b("\u0c31\u7587\uff41\u613f\ueae2\u6c44\ud64a\u5ff8\uc1a5\u4b1f\ucccd", -1385034679), tiq.STAND_MODES, tiq2.standMode(), 1), () -> ign.ijj(tiq2, a.d("\ucb8e\ub238\u38fe\ua680\u2d5d\uabfb\u11f5\u9847\u061a\u8ca0\u0b72", -597092648, -1580344018), tiq.STAND_MODES, tiq2.standMode(), -1), wap.s(a.d("\u5400\u2d95\ua757\u397e\ub2fa\u344f\u8e02\u07ee\u99a6\u131c\u94c2\u6ea5\ue021\u79d2\uf386\u7566\ucf2a\u40e9\uda5a\u5c00\ud5b9\uafac\u210e\ubacf\u3cb9\ub628\u0f97\u8195\u1b65\u9d32\u1692\ue844\u6208\ufbb0\u7def\uf714\u48dc\uc2b5\u447b\uddc9\u57c9\u2934\ua330\u2497\ube4d\u303b\u89ea\u035c\u851a", -879997274, -1050862886), a.d("\uf624\u8fb1\u0560\u9b6a\u14dc\u960a\u2c2b\ua5af\u3b85\ub135\u3691\ucc96\u4236\udfe5\u51a2\ud724\u6d65\ue2c2\u7806\ufa37\u73cc\u0dfc\u834c\u189f\u9e95\u1448\uad86\u27bf\ubd44\u3f0a\ub4c6\u4a1c\uc02e\u59d3\udf82\u5127\ueefc\u60e8\ue640\u7ffb\uf5dc\u8b50\u0171", -1748401118, -1193380303)));
        String string = ign.ijw(tiq2.standNear()) + a.b("\u1635", -1136380377) + ign.ijw(tiq2.standFar()) + wap.s(a.c(1497293172, "\ue156\u98aa"), a.c(1991262027, "\u3f69\u42c4"));
        this.ijs(drawContext, f, f2, wap.s(a.c(172739429, "\ucb29\ub2b5\u387c\ua60a\u2dc8\uab76\u1128\u98df"), a.b("\u2f8c\u5611\udcbb\u42c9\uc96c\u4fd0\uf5f8\u7c77\ue25f", 833760145)), string, f3, f6 += 16.0f, f5, () -> ign.iji(tiq2, -0.3), () -> ign.iji(tiq2, 0.3), wap.s(a.d("\ua87e\ud1e8\u5b23\uc505\u4e94\uc822\u7262\ufbc1\u65ca\uef67\u68b9\u928d\u1c09\u85bf\u0ff9\u8907\u3342\ubc84\u2664\ua07e\u2987\u53d6\udd70\u46ea\uc08e\u4a1e\uf3a5\u7df0\ue703\u6155\ueaef\u1479\u9e75\u0788\u81c1\u0b6b\ub4a6\u3ed0\ub850\u21a4\uabe8\ud50a\u5f52\ud8ad\u4235\ucc5e\u758c\uff69\u7969\ue2b1\u6c84\u9607\u1fa7\u99f2\u0303\u8d59", -1844638268, 1003726282), a.b("\u5767\u2efc\ua425\u3e4e\ub18d\u3738\u8d60\u049f\u9acf\u107a\u93b7\u6dd2\ue304\u7ac0\uf0e5\u7612\ucc2f\u43fd\ud940\u5b7e\ud6e8\uacba\u227e\ub9a7\u3fd1\ub57f\u08bc\u86f6\u181c\u9e40\u15f1\ueb27\u6169\uf899\u7ec2\uf476\u4bac\uc5c8\u470c\udeba\u5494\u2a63\ua04f\u2784\ubd5a\u3352\u8a837\u860f\u1ddd\u93a0\u6d1e\ue0b1\u62f8\ufc19\u7247\uc9f0\u4b34\uc553\u5c88\ud240\ua81f\u2f90\ua5c2\u3b08\ub2b0\u08e1\u8e6f\u043b\u9bf0", -1645587653)));
        this.ijs(drawContext, f, f2, wap.s(a.b("\u3f8b\u4619\uccdf\u52ae\ud978", 1965440989), a.c(883786078, "\u8577\ufcdd\u760a\ue805\u63ac\ue562\u5f32\ud6cd")), Math.round(tiq2.standSpeed() * 100.0) + a.c(-1366367728, "\ue234"), f3, f6 += 16.0f, f5, () -> ign.ijh(tiq2, a.c(-88483189, "\udaf4\ua342\u2984\ub7fa\u3c27\uba81\u008f\u8923\u177f\u9ddb\u1a08\ue078"), Math.max(0.3, tiq2.standSpeed() - 0.1)), () -> ign.ijh(tiq2, a.c(1807697629, "\u46a2\u3f14\ub5d2\u2bac\ua071\u26d7\u9cd9\u1575\u8b29\u018d\u865e\u7c2e"), Math.min(1.6, tiq2.standSpeed() + 0.1)), wap.s(a.d("\u7501\u0c97\u865c\u187a\u93eb\u155d\uaf1c\u26ea\ub8e1\u3204\ub5cb\u4fb7\uc125\u58c7\ud293\u5477\uee37\u61ec\ufb48\u7d4a\uf4f0\u8ea3\t\u9bcb", -1886890339, -1365564468), a.d("\u0349\u7ad2\uf00b\u6a60\ue5a6\u636d\ud934\u50c6\uce9b\u4454\uc799\u39fc\ub72d\u2e96\ua4ce\u223c\u980d\u17d0\u8d60\u0b3f\u86a7\uf897\u7627\ued81\u6bf6\ue12e\u58e2", 1030979002, -1473873166)));
        f6 += 20.0f;
        double d = tcz.unit(MinecraftClient.getInstance());
        tck tck2 = tiq2.model(tiq2.aura());
        String string2 = wap.s(a.b("\u5014\u2993\ua34b\u3d27\ub6ea\u3046\u8a08\u03e6\u9da6\u170a\u90d4\u6ae6\ue42b", -1297592246), a.d("\u56f1\u2f54\ua58f\u3b82\ub024\u329f\u88d6", 1389692553, 1133597790)) + ign.ijx(d) + wap.s(a.b("\u42da\u3bf4\ub16b\u2f16\ua4db\u2271\u9838", 1917534829), a.c(616350100, "\uc12c\ub802\u36c0\ua8cd\u2319\ua5ae\u1feb\u9609")) + ign.iix(tiq2);
        if (tck2 != null && tck2.unit > 0.0f && Math.abs((double)tck2.unit - d) / (double)tck2.unit > 0.15) {
            string2 = string2 + wap.s(a.d("\uec36\u9587\u1fc3\u8125\u0af2\u8c0e\u365f\ubfa5\u21fb\uab43\u2cc6\ud6ad", 1147380396, -1819324746), a.d("\"\u7993\uf3d7\u6d31\ue6e6\u6434\uda04\u57e9\uc9b4\u430f\uc4dd\u3ea2\ub076\u2dc5\ua78c", -218499956, -1473121151)) + ign.ijx(tck2.unit);
        }
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string2, f5), f3, irr.SMALL.centerTop(f6 + 5.0f), iov.textMuted);
    }

    private void iir(DrawContext drawContext, float f, float f2, float f3, float f4, float f5) {
        tiq tiq2 = this.ihe;
        boolean bl = tiq2.aura();
        boolean bl2 = tiq2.mine();
        boolean bl3 = tiq2.walk();
        boolean bl4 = bl2 || bl3;
        float f6 = f4;
        if (!bl4 || bl2) {
            f6 = this.ijn(drawContext, wap.s(a.b("\u1df0\u6467\ueea7\u70de\ufb0e\u7db4\uc7f0", 759373219), a.d("\u125d\u6b8e\ue128\u7f51\uf48e\u724a", 463380721, -426133880)), f3, f4);
        }
        if (!bl4) {
            f6 = this.iis(drawContext, f, f2, tiq2, bl, bl2, bl3, f3, f6, f5);
        }
        if (!bl && !bl3) {
            this.ijq(drawContext, f, f2, wap.s(a.d("\uc8b2\ub135\u3bfb\ua595\u2e12\ua8ec\u12a6\u9b44\u050c\u8fbc\u0874\uf202\u7cd5\ue57f\u6f2b", -608835866, 789786143), a.c(358794894, "\uc292\ubb07\u31d6\uabb0\u2478\ua2c3\u18e5\u9161\u0f30\u85eb\u022b\uf826\u76fd")), tiq2.clean(), f3, f6, f5, () -> {
                tiq2.set(a.c(1206694895, "\ub396\uca21\u40e1\ude98\u5548\ud3f2\u69b6\ue01b\u7e09\uf4b7\u736d\u8918\u07c0"), !tiq2.clean());
                tiq2.save();
            }, wap.s(a.c(-934462373, "\u3c21\u45a6\ucf74\u5102\uda86\u5c63\ue62c\u6fd0\uf1ca\u7b36\ufce7\u0694\u884b\u11f1\u9bb8\u1d4e\ua752\u28da\ub27f\u3434\ubd96\uc781\u4938\ud2e0\u548d\ude0b\u67e8\ue9a8\u734d\uf51b\u7efc\u8079\u0a2a\u93d6\u15c0\u9f25\u20e7\uaa85\u2c43\ub5f0\u3fbe\u411b\ucb07\u4cac\ud67a\u585f\ue1c3\u6b7b\ued72\u76f7\uf898\u0244\u8bb6\u0da3\u9755\u1911\ua2bb"), a.c(-1993555729, "\uc4cd\ubd25\u37fd\ua9f9\u222c\ua49a\u1ecc\u974a\u0d77\u83de\u0402\ufa64\u70a7\ue912\u634c\ue5bd\u5f84\ud05b\u4e8d\uccc0\u4535\u3f66\ub1dc\u2a05\uac05\u26dd\u9b09\u1554\u8bb0\u0de6\u8654\u7c90\uf2bd\u6b45\ue97d\u67d3\ud87b\u5274\ud4a2\u4d1d\uc735\ub9b6\u33ee\ub044\u2ef5\ua0f7\u192a\u93ec")));
            f6 += 16.0f;
        }
        if (bl2) {
            int n = tiq2.mineBoost();
            this.ijr(drawContext, f, f2, wap.s(a.d("\ue0eb\u9971\u13b3\u8d96\u0603\u80bf\u3aec\ub301\u2d59", -987290832, -327957604), a.c(-2037654888, "\ude80\ua763\u2db2\ub3c0\u3c75\ubea5\u0482\u8d04\u1321")), n == 0 ? wap.s(a.d("\u623d\u1b85\u9156", 859721277, 966274156), a.b("\udd9a\ua452\u2ef0\ub080", 1744230828)) : a.c(-505192682, "\u5f3c") + n + a.b("\u180c", -1179445208), f3, f6, f5, () -> ign.ijf(tiq2, 1), () -> ign.ijf(tiq2, -1), wap.s(a.c(494344611, "\u198b\u601d\uead6\u74f0\uff6a\u79c3\uc386\u4a7c\ud46b\u5e98\ud94c\u232c\uadfb\u345b\ube1f\u38bc\u82a7\u0d6a\u97d0\u118e\u9837\ue23f\u6c9a\uf751\u7161\ufbaa\u425f\ucc09\u56ec\ud0ba\u5b18\ua5de\u2fc3\ub67a\u3020\uba9e\u0543\u8f76\u09e4\u905a\u1a0f\u64ba\ueebb\u691d\uf3ce\u7dbd\uc479\u4ed5\uc89c\u534c\udd7d\u27a0\uae5a\u2809\ub2e7\u3ca1\u875b\u01c5\u8bbf\u1228\u9cc6\ue681\u6168\ueb3e\u75a3\ufc50\u4604\uc0e3\u4ab3\ud556\u5fc8\ud9bb\u207d\uaadf\u349a\ubf38\u3967\u839c\u0a54\u947c\u1ee4\u98aa\ue310\u6dd4\uf7f7\u7e7f\uf8da\u4291\ucd3b\u572c\ud198\u585a\ua232\u2ceb\ub759\u3145"), a.d("\u26a8\u5f34\ud1f7\u4be7\uc04b\u46fe\ufca8\u752e\ueb07\u61b2\ue27f\u1c15\u92ba\u0b0f\u8153\u07df\ub985\u3236\ua8f2\u2ea7\ua72e\ud90a\u57a3\uc863\u4e66\uc4bd\u7d0d\uf35e\u69dc\uef8d\u602b\u9a9a\u10d6\u895e\u0f07\u81a6\u3a69\ub400\u36b3\uaf77\u252d\u5bd6\ud1f9\u5636\ucc96\u4684\uff5b\u71fb\uf7bb\u6c6f\ue26b\u18be\u9174\u1330\u8da1\u0380\ub833\u3ee4\ub4ea\u295e\ua388\ud9a8\u5e57\ud471\u4ab0\uc764\u7954\uffd2\u7581\uea47\u60ee\ue6e9\u1f38\u91ec\u0bdf\u805b\u0671\ubcbd\u3566\uab12\u21dc\ua394\ud82f\u52e9\uc89f\u4550\uc7fe\u7da2\uf229\u680c\ueecf\u6762\u9d12\u13cd\u8876\u0e27\u84eb\u3a98\ub334\u2def", 1146801412, 168095701)));
            f6 += 16.0f;
        }
        if (!bl4 || bl2) {
            f6 += 6.0f;
        }
        this.iit(drawContext, f, f2, tiq2, f3, f6, f5);
    }

    private float iis(DrawContext drawContext, float f, float f2, tiq tiq2, boolean bl, boolean bl2, boolean bl3, float f3, float f4, float f5) {
        this.ijr(drawContext, f, f2, wap.s(a.d("\u7631\u0fa5\u8571\u1b02\u90ca\u1667\uac22", -1010810048, 672412966), a.b("\ud86a\ua1f6\u2b22\ub559\u3e83\ub845\u0264\u8b9d\u15c7\u9f7b", 927521917)), bl ? a.b("\ud189\ua81a\u22cc\ubcbd\u3747\ub1c2\u0b96\u8274", -412954166) : (bl2 ? wap.s(a.c(94574961, "\u1938\u60ad\uea79\u7403"), a.b("\u8fe2\uf64b\u7ced\ue29b\u693e", 332106703)) : (bl3 ? wap.s(a.d("\uba0c\uc38b\u4955\ud723\u5cf6\uda40\u601a", -959535018, -866577910), a.c(1256704016, "\ucc33\ub599\u3f40\ua149\u2ae3\uac53")) : wap.s(a.d("\u96d7\uef4b\u6583\ufbf5", -1360493367, 1912869464), a.d("\u13e0\u6a7e\ue0d1\u7ea9", -1940454708, -1580591815)))), f3, f4, f5, () -> ign.ijj(tiq2, a.c(420686242, "\u29d5\u5061\udab5\u44c6\ucf0e\u49a3\uf3e6"), tiq.PURPOSES, tiq2.purpose(), 1), () -> ign.ijj(tiq2, a.c(-168794731, "\u65e2\u1c56\u9682\u08f1\u8339\u0594\ubfd1"), tiq.PURPOSES, tiq2.purpose(), -1), bl ? wap.s(a.b("\uc282\ubb11\u31c7\uafb6\u244c\ua2c9\u189d\u917f\u0f7b\u85d0\u024f\uf837\u76e4\uef46\u6509\ue3e5\u59f9\ud669\u4cd7\uca86\u433d\u3935\ub790\u2c5b\uaa23\u20a0\u9947\u1710\u8df4\u0ba7\u801c\u7ecf\uf487\u6d7f\ueb6b\u6194\ude48\u543d\ud2fd\u4b1e\uc100\ubfb0\u35b7\ub213\u28d7\ua6b3\u1f62\u95c2\u13d5\u8808\u0628\ufce3\u7550\uf305\u69f3\ue7af\u5c03\udac9\u50a7\uc97b\u4795\u3d94\uba72\u3034\uaea9\u2759\u9d13\u1bf3\u91be\u0e5c\u84f7\u02fe\ufb2e\u7190\uefba", 1216004738), a.c(-645264353, "\u0c12\u7581\uff57\u6126\ueadc\u6c59\ud60d\u5fef\uc1eb\u4b40\uc8f0\u3285\ubc2d\u25e6\uabd7\u2934\u937c\u1cd9\u8667\u045a\u89cf\uf3ee\u7d51\ue687\u64e1\uea52\u53e3\uddc7\u473f\uc16c\u4ada\ub405\u3a59\ua7c8\u2194\uab5e\u1483\u9ef0\u1c3f\u81ef\u0fd1\u7546\uff66\u78d9\ue279\u6c0a\ud1bb\u5b06\ud928\u42fd\uccf5\u362e\ubfec\u39be\ua33d\u2d60\u92c1\u100f\u9a7d\u07b2\u8d1b\uf735\u70c8\ufaea\u6039\ue9f0\u53db\ud525\u5f7d\uc0b5")) : (bl3 ? wap.s(a.b("\u06a2\u7f25\uf5fb\u6b8d\ue058\u66ee\udcb4\u5518\ucb5d\u41a0\uc67a\u3c0f\ub2cb\u2b66\ua128\u278a\u9d8d\u125b\u88f0\u0ef6\u8758\ufd1f\u73b6\ue832\u6e0b\ue4d3\u5d63\ud332\u49c6\ucf8f\u446b\ubafb\u30f5\ua956\u2f18\ua5b3\u1a65\u9005\u1693\uaf16\u057d\u7bc7\uf19a\u7637\uecea\u62c4\udb1b\u51fa\ud7a4\u4c77\uc202\u389a\ub121\u3733\uadc2\u239f\u9828\u1eee\u948e\u0d12\u83a9\uf9bb\u7e44\uf408\u6ac7\ue361\u5934\udfd2\u5598\uca2f\u40fd\uc691\u3f06\ub5ac\u2b9e\ua05b\u260d\u9ca7\u155e\u8b04\u01c1\u87d4\ufc26\u72f8\ue885\u6110\ue7c2\u5da7\ud259\u4813\uce98\u477f\ubd1b\u33dc\ua86e\u2e34\ua4b5\u1a93\u9356\u09ea\u8fba\u0400\u7a04\uf0ab\u6969\uef04\u659f\uda67\u502d", 1267599000), a.c(1844290076, "\ua65e\udff4\u552d\ucb24\u408e\uc63e\u7867\uf18c\u6bb0\ue105\u66a9\u9ca2\u1617\u8bbc\u01e5\u871e\u394b\ub2f8\u2842\uaa78\u2797\u5dca\ud31c\u48d4\uceaf\u4012\ufdbe\u73ee\ued07\u6f4a\ue4f5\u1a54\u9013\u09ea\u8fba\u050a\ubadc\u34ce\u9229\u2bac\ua5e9\udb19\u5141\ud6f2\u4c2f\uc22e\u7b8d\uf528\u736b\uecd8\u62dc\u9804\u11b0\u93f2\u090d\u8346\u38f3\ube2e\u3454\uadf0\u2337\u5d7a\uda85\u54cb\uca05\u43b5\uf999\u7f18\uf54d\u6af4\ue025\u6257\u9b93\u1540\u8b61\u009a\u82d7\u3c03\ub5ab\u2bd0\ua164\u2738\u58e9\ud659\u4c1a\uc5ca\u4362\uf919\u76cd\uec96\u6a61\ue7a8\u19c7\u9777\u0cf0\u8aa0t\ube3d\u37d8\uad7a\u2b3b\ua0cb\ude93")) : (bl2 ? wap.s(a.b("\u1979\u60ec\uea38\u7442\uffca\u7961\uc37e\u4a86\ud4dd\u5e7f\ud9b0\u23dc\uad58\u34a1\ubef5\u381c\u8204\u0d8c\u9729\u1162\u98c0\ue2d5\u6c6b\uf7b4\u718c\udb69\u42ee\ucce8\u5600\ud050\u5be9\ua533\u2f34\ub687\u30da\uba68\u05b3\u8fca\u0952\u90ad\u1af9\u6415\uee4a\u69a3\uf378\u7d50\uc495\u4e3e\uc876\u53f5\uddd2\u2702\uaeb2\u28ff\ub211\u3c1f\u87ac\u0124\u8b41\u128a\u9c3a\ue639\u619d\uebda\u7518\ufcae\u46ff\uc009\u4a57\ud5ba\u5f72\ud962\u2089\uaa39\u3471\ubfa2\u39d1\u8367\u0abf\u948b\u1e00\u985c\ue3e1\u6d24\uf700\u7e86\uf82b\u4267\ucd84\u579d\ud167\u58ab", 1224677736), a.d("\u5da8\u2401\uaea7\u30d1\ubb74\u39cf\u8386\u0e14\u904f\u1a81\u9d28\u633b\ue9f6\u704d\ufa14\u78ff\uc6d2\u490a\ud7d2\u5599\udc6a\ua63a\u2886\ub352\u3550\ubf85\u025a\uac3f\u16fc\u94b7\u1f0e\ue1d5\u6b9e\uf268\u7022\ufe82\u415f\ucb2b\u4dfc\ud057\u5e69\u20e2\uaabf\u2d0f\ub7af\u39d3\u8007\u0ac7\u8c89\u134d\u9d32\u63fc\uea4a\u6c17\uf6e8\u78c7\uc306\u45ab\ucbba\u5673\udcdc\ua2e8\u2560\uaf3b\u318c\ub840\u0261\u80e8\u0aa4\u9177\u1bd6\u9dad\u6068\ueec3\u7094\ufb64\u7d3c\uc788\u4e2c\ud43f\u5e91\ud8f4\ua346\u2d8c\ub7d9\u3e2c\ub898\u02c2", 1796492818, 1224021962)) : wap.s(a.c(-649613974, "\uad7f\ud4e3\u5e2b\uc05d\u4bc3\ucd68\u7777\ufe8f\u60d4\uea76\u6db9\u97d5\u1951\u80b4\u0afb\u8c07\u360d\ub99d\u2326\ua573\u2c80\u56d6\ud86c\u43fa\uc5d1\u4f1c\uf6a6\u78e2\ue241\u6455\uefed\u1136\u9b78\u0288\u849f\u0e67\ub1b7\u3b88\ubd1a\u24ea\uaefd\ud00d\u5a43\uddbd\u4771\uc961\u7086\ufa36\u7c62\ue791\u69c6\u9310\u1aac\u9cb4\u064b\u887b\u33f0\ub520\u3f48\ua6b3\u282f\u5274\ud5cf\u5f92\uc13c\u48b9\uf2eb\u7401\ufe6e\u61e9\ueb29\u6d4e\u9490\u1e2a\u8037\u0b92\u8dc4\u3772\ubebd\u2082\uaa1a\u2c55\u57fb\ud936\u4309\uca91\u4c3f"), a.b("\u84fa\ufd64\u77cb\ue9b3\u6615\ue0be\u5e8e\ud77b\u495b\uc390\u4021\ube4d\u3097\ua924\u2370\ua580\u1fce\u9017\u0aa1\u8cfd\u0113\u7b4e\uf1e7\u6a32\uec31\u669c\udf51\u517e\ucb82\u49c6\uc662\u38b4\ub2f1\u2b04\uad54\u279f\u9837\u1245\u9493\u0d5d\u870f\ufd92\u73a2\uf464\u6eb7\ue0b6\u591b\ud3a8\u51e0\uca2a\u4041\uba94\u373f\ub574\u2ffd\ua1af\u1a11\u9ccd\u16b3\u8b00\u05d6\u7fb3\uf841\u720b\uece6\u6573\udf27\u59dd\ud3c3\u4c7e\uc6cc\u4089\ub957\u33fd\uad84\u265e\ua003\u1afa\u9325\u0d35\u87ce\u019e\u7a36\uf4df\u6e9e\ue75c\u61f9\udba9\u545d", 951943346)))));
        this.ijr(drawContext, f, f2, wap.s(a.b("\u04a6\u7d33\uf7f4\u6988\ue25a\u64f6\udea8", -498858768), a.c(1246535197, "\u9a0f\ue394\u6930\uf733\u7c90\ufa22\u4001\uc9fc")), ign.ijl(tiq2.quality()), f3, f4 += 16.0f, f5, () -> ign.ijj(tiq2, a.c(-557547567, "\u7faa\u061d\u8cdd\u12a4\u9974\u1fce\ua58a\u2c27\ub227\u3892\ubf55\u4529\ucbfb\u5257\ud809"), tiq.QUALITIES, tiq2.quality(), 1), () -> ign.ijj(tiq2, a.c(885248157, "\ud0e6\ua951\u2391\ubde8\u3638\ub082\u0ac6\u836b\u1d6b\u97de\u1019\uea65\u64b7\ufd1b\u7745"), tiq.QUALITIES, tiq2.quality(), -1), wap.s(a.c(-1646320013, "\u261a\u5f89\ud547\u4b21\uc0b3\u4647\ufc01\u75ef\uebbc\u6106\ue6ce\u1cec\u9277\u0bcf\u8198\u077a\ubd29\u32b6\ua843\u2e1d\ua7ed\uddb7\u5313\uc89c\u4eef\uc46a\u7dcc\uf397\u696e\uef7a\u6485\u9a57\u1019\u89e1\u0fb0\u8516"), a.d("\u203e\u59a0\ud376\u4d70\uc6a3\u406f\ufe29\u73b5\ued98\u6728\ue080\u1e94\ub077\u09f2\u87c3\u014e\ubb78\u34d3\uae68\u2839\ua5d7\udf8a\u5524\ucef6\u4c97\uc252\u7beb\uf5bf\u6f3f\ue96a\u62a4", 694826851, 1192629075)));
        this.ijr(drawContext, f, f2, wap.s(a.b("\u1177\u68ed\ue22f\u7c5d\uf792\u713e\ucb74", 2008617278), a.d("\ue6a2\u9f07\u15a3\u8bdc", 471947178, 1095087405)), ign.ijm(tiq2.size()), f3, f4 += 16.0f, f5, () -> ign.ijj(tiq2, a.b("\uff62\u86d5\u0c15\u926c\u19bc\u9f06\u2542\uacef\u32ed\ub846\u3f86\uc5e8", 1161625370), tiq.SIZES, tiq2.size(), 1), () -> ign.ijj(tiq2, a.b("\u8016\uf9a1\u7361\ued18\u66c8\ue072\u5a36\ud39b\u4d99\uc732\u40f2\uba9c", 1350533230), tiq.SIZES, tiq2.size(), -1), wap.s(a.b("\u58dd\u2147\uab9a\u35eb\ube3e\u3898\u8299\u0b26\u9572\u1fc3\u9811\u6277\uecf3\u750f\uff5e\u79b2\uc3ea\u4c7e\ud689\u50dd\ud93f\ua37b\u2d92\ub658\u306a\ubab3\u0301\u8d5d\u17b6\u91ff\u1a01\ue483\u6eca\uf727\u7169\ufbdf\u445b\uce67\u48b6\ud11b\u5b43", 198269110), a.b("\u1ec9\u6757\ued81\u7387\uf854\u7e93\uc4c7\u492f\ud36d\u59a2\ude04\u247e\uaaaa\u3705\ub947\u3fb9\u85f3\u0a55\u90e2\u16ce\u9b2c\ue569\u6bde\uf002\u767d\ufcda\u4567\ucf48\u55a4\ud794\u5c26\ua282\u28cc\ub134\u3715\ubda4\u061c\u8872\u0ea0\u971b\u1d35\u63bf\ue9e6\u6e5b\uf4f6\u7ee5\uc329\u4999\ucfaf\u547b\uda72\u24bb\ua91e\u2f3c\ub5bb\u3be3", -999548192)));
        this.ijq(drawContext, f, f2, wap.s(a.d("\uf7c1\u8e54\u049c\u9aed\u1127\u978b\u2d8a\ua437\u3a61\ub0d3\u3712\ucd37\u43ef\uda51\u5050\ud6ba\u6cfb\ue325\u798a", -1990584004, 606269091), a.c(-981070867, "\u0fec\u767f\ufcd9\u62d2\ue90f\u6fb5\ud5e5\u5c6e\uc23f\u4ce2\ucf2a\u3555\ubb85\u2238\uac75\u2a8b\u90cb\u1b05\u81c9\u07e8\u8e1d\uf440")), tiq2.mirror(), f3, f4 += 16.0f, f5, () -> {
            tiq2.set(a.c(-211966549, "\ua5d1\udc66\u56a6\uc8df\u430f\uc5b5\u7ff1\uf65c\u6840\ue2f5\u653d\u9f4c\u1186\u882a"), !tiq2.mirror());
            tiq2.save();
        }, wap.s(a.b("\u396a\u40f2\uca25\u5447\udf8c\u5920\ue320\u6a93\uf4c1\u7e6b\uf9a4\u039d\u8d0e\u14b2\u9efa\u181c\ua255\u2d93\ub73d\u316a\ub89c\uc2d0\u4c30\ud7a7\u51cc\udb00\u62b1\uecad\u761f\uf04a\u7bfb\u8521\u0f26\u9691\u10c8\u9a7c\u25a1\uafd8\u295a\ub0f1\u3afa\u4408\uce45\u49fe\ud32f\u5d1b\ue49c\u6e31\ue873\u73e7\ufdd0\u0704\u8ea6\u08e2", 1674983696), a.b("\u541b\u2dce\ua762\u3969\ub6dc\u3473\u8e2f\u07df\u9d90\u133c\u94e2\u6e9c\ue034\u79f5\uf3a4\u755c\ucf1d\u40c4\uda72\u5c54\ud1cc\uaf85\u2139\ubeff\u3c9a\ub641\u0ff4\u81a7\u1b5a\u9d06\u16b8\uec77\u625c\ufbd2\u7d82\uf731\u48ec\uc697\u405e\uddfb\u57a0\u295c\ua30f\u24c8\ube11\u3405\u89c4\u0373\u853a\u1ee7\u909f\u6e5b\ue3fd\u65a3\uff55\u7173\ucac8\u4c64", 1914982402)));
        return f4 + 16.0f;
    }

    /*
     * Exception decompiling
     */
    private void iit(DrawContext var1_1, float var2_2, float var3_3, tiq var4_4, float var5_5, float var6_6, float var7_7) {
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

    private void iiu(DrawContext drawContext, float f, float f2, tiq tiq2, tck tck2, float f3, float f4, float f5) {
        String string = new SimpleDateFormat(a.b("\u842e\ufd9f\u7706\ue914\u62c3\ue41f\u5e24\ud7d5\u49f8\uc31e\u44cd", 714703937), Locale.ROOT).format(new Date(tck2.created));
        irr.LABEL.draw(drawContext, wap.s(a.c(-1525810970, "\uf8be\u8135\u0be2\u9597\u1e45\u98f9\u22b9\uab53\u3511\ubfad\u3827"), a.b("\u9059\ue98c\u6324\ufd5f\u76fd\uf04f\u4a6c\uc391\u59d0", -175008655)) + Math.round(tck2.similarity) + a.b("\u13c9", -2094328851), f3, irr.LABEL.centerTop(f4 + 6.0f), iov.text);
        irr.SMALL.drawRight(drawContext, string + a.d("\u15b9\u6c08\ue64c\u78aa\uf37d", -962245186, 611342370) + ign.ijv(tck2.steps / 20), f3 + f5, irr.SMALL.centerTop(f4 + 6.0f), iov.textMuted);
        f4 += 15.0f;
        if (tck2.axes.length >= 21) {
            this.ijc(drawContext, a.d("\u16f5", -859179266, 1370808402), wap.s(a.d("\uedd9\u9470\u1eb5", 1299345056, 1178501891), a.d("\u29c1\u5071\udebc\u44de\ucf04\u49cb\uf3e0\u7a1e\ue448\u6efa\ue956\u1355\u9d89\u043b", -1001090146, -2084389266)), tck2.axisScore(0), tck2.axisScore(2), f3, f4, f5);
            this.ijc(drawContext, a.b("\ua38f", -1510169641), wap.s(a.d("\u6c7d\u15d5\u9f1b\u017d\u8aa1", 936968239, -783389657), a.c(1074416940, "\u491f\u30af\ube62\u2401\uafd1\u2915\u9344\u1acf\u8492\u0e29\u89f1\u7383")), tck2.axisScore(1), tck2.axisScore(3), f3, f4 += 12.0f, f5);
            f4 += 13.0f;
            String[] stringArray = new String[]{wap.s(a.b("\u1884\u6114\uebce\u75a7\ufe65\u7895\uc2ce\u4b64\ud538\u5f9c\ud84f\u223f\uaca5", -918284083), a.b("\u66a5\u1f35\u95e8\u0bee\u8037\u06f4\ub8b7\u314e\uab78\u21b2\ua665\u5c6a\ud2c3\u4b0d\uc15d\u47a2\uf988", -163159392)), wap.s(a.b("\u000e\u799d\uf34e\u6d39\ue6e7\u605f\uda1b\u53f9\ucdb3\u471f\uc0ca\u3aba", -1061748669), a.c(162241702, "\u988c\ue15f\u6bf7\uf582\u7e2b\uf8ef\u42b4\ucb40\u5512")), wap.s(a.c(-370200691, "\u2fc3\u565d\udc99\u42f1"), a.d("\uec76\u95ac\u1f06\u817b\u0aa8", -1226949723, -837233674)), wap.s(a.b("\ue76c\u9ef5\u1422\u8a1e\u018c\u872a\u3d79\ub495\u2ad7", -2055805148), a.b("\ue1b1\u9856\u12f5\u8c8d\u0751\u81ea\u3fa9\ub247\u2c67\ua6ae\u2103\udb01\u55d8\ucc62", 2137187745)), wap.s(a.d("\ub94c\uc0c3\u4a12\ud463\u5faf\ud902\u6357\ueaad\u74e4\ufe55", -1349898096, 1178175877), a.c(1877222170, "\u270c\u5e99\ud441\u4a32\uc1ea\u4758\ufd74\u7486\uead7")), wap.s(a.c(762737251, "\u7226\u0bae\u816e\u1f08\u94de\u1274\ua820\u21d1\ubf95\u3523"), a.d("\ud793\uae08\u24ae\ubaaa\u3173\ub7a8\u0de8\u8410", -1949673771, -1046313647))};
            for (int i = 0; i < 6; ++i) {
                this.ijp(drawContext, stringArray[i], a.d("\uf7ad\u8e64", 1914156840, -660979489) + ign.ijd(tck2.axisScore(4 + i)) + a.c(684739161, "\u4a7c\u33cd\ub91e\u2716\uacb8") + ign.ijd(tck2.axisScore(10 + i)), f3, f4, f5);
                f4 += 11.0f;
            }
            this.ijp(drawContext, wap.s(a.b("\ud934\ua0bc\u2a7c\ub41a\u3fcc\ub966\u0332\u8ac3\u1487\u9e31\u19b1\ue3cf\u6d17\uf4b7\u7ee5\uf814\u424b\ucdce\u5760\ud13b\u58c4\u228d\uac61\u37bc\ub19a\u3b5d\u82f4\u0cf0\u9690\u1056\u9ba8\u657b\uef3f\u76cf\uf095", -2112759464), a.c(1698091578, "\ud63b\uafa0\u2506\ubb02\u30db\ub600\u0c40\u85b8\u1f8c\u9120\u16fe\ue89f\u6659\uffe9\u75ba\uf35b\u4d76\uc6c9\u5c76\ude45\u57bb\u2981\ua7a5\u3ce3\ube80\u3453\u8dea\u03ba\u9943\u1f65")), ign.ijw(tck2.axisScore(16)) + a.b("\ub4fb\ucddd\u4799", 806139096) + ign.ijw(tck2.axisScore(17)), f3, f4, f5);
            double d = tck2.axisScore(20);
            this.ijp(drawContext, wap.s(a.c(-473149712, "\u4ebd\u373b\ubdec\u239f\ua85f\u2ef3\u94a6\u1d56\u834b\u09f6\u8e64\u741d\uface\u6332\ue931\u6fdf\ud596\u5a40\uc0e9\u46bf\ucf17\ub54a\u3bad\ua067\u2607\uac86\u1566\u9b34\u01d6\u8787\u0c35"), a.d("\ue6cb\u9f6f\u15b9\u8bc2i\u86a6\u3c82\ub110\u2f43\ua190\u263f\udc37\u529d\ucb2e\u4569\uc394\u7dc7\uf21a\u68a3\uee89\u6311\u194e\u939c\u0836\u8e4d\u04e2\ubd2f\u3301\ua9f5\u2faa", 2066553507, -3082154)), (Double.isNaN(d) ? a.d("\ube40", 782033448, -197755779) : Math.round(d * 50.0) + wap.s(a.d("\u8bce\uf232\u78ff", -1692441948, -515249847), a.d("\u40f9\u3d54\ub7fa", -1694059114, -1071450804))) + a.d("\u8e3c\uf71a\u7d5e", 87971415, 8247368) + (tck2.ownAim() ? wap.s(a.c(-1396352263, "\u5a85\u2322\ua9eb\u379d\ubc4b"), a.d("\ud9ae\ua06f\u2ab0\ub4c7", -39509654, -31720318)) : a.b("\ubdf0", 442015205)) + a.c(871674103, "\ub0d4\uc9f2\u43b6") + (tck2.turnCap > 0.0f ? Math.round(tck2.turnCap) + a.d("\u4ef9\u37d7", -90679721, 992286748) + wap.s(a.d("\u0442", -1579685006, -1672876219), a.c(1694679263, "\uc49c")) : a.c(-1170564793, "\ub952")), f3, f4 += 11.0f, f5);
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.b("\ua88a\ud13a\u5ba7\uc590\u4e48\uc8f7\u72ab\ufb46\u651e\ueffc\u6866\u920a\u1c89\u8576\u0f2e\u89cc\u3390\ubc56\u26b7\ua0b5\u2950\u5317\uddf3\u46b5\uc05d\u4acf\uf37a\u7d27\ue7d5\u6181\uea35\u14ed\u9ee5\u0709\u8147\u0baf\ub46e\u3e05\ub883\u2164\uab3e\ud59c\u5f96\ud831\u42fc", -1949980472), a.c(-958360717, "\u9761\ueedd\u601e\ufa7e\u71a6\uf766\u4d3f\uc0a7\u5ef4\ud05f\u5788\uad85\u232e\ubae1\u30b9\ub646\u086c\u83a0\u191b\u9b5f\u16ba\u6ce1\ue25e\u798e\uffff\u7525\uc886\u4640\udc20\u5e6e\ud5dc\u2b71\ua142\u38b6\ubee0\u3455\u8f98\u05f4\u833a\u1ee9\u94bf\uee25\u6420\ue394\u7910\uf303\u4ad9")), f5), f3, irr.SMALL.centerTop((f4 += 11.0f) + 4.0f), iov.textMuted);
            f4 += 13.0f;
        } else {
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.c(-1238740512, "\u5193\u2801\ua2da\u3cef\ub775\u31c6\u8b9e\u026e\u9c38\u16df\u9116\u6b35\ue5f5\u7c55\uf600\u70e2\ucaa5\u4573\udf8e\u5999\ud067\uaa2b\u24ca\ubf42\u392b\ub3e0\u0a54\u8457\u1ef2\u98b4\u1303\uedd0\u6788\ufe64\u7831\uf281\u4d14\uc769\u41fb\ud842\u5219\u2ca5\ua6a6\u2108\ubbd9\u35af\u8c66\u06d0\u80c0\u1b1d\u9521\u6fe9\ue64d\u600b\ufaf9\u74b3\ucf0b\u49da\uc3b2\u5a64"), a.c(-2120926882, "\u3d41\u4493\uce32\u5033\udb94\u5d5a\ue366\u6e8b\uf0d6\u7a6d\ufdbf\u07c0\u8960\u14a7\u9eee\u1c00\ua645\u29e1\ub327\u357d\ubc85\uc6a6\u4811\ud3bf\u51d8\ufb3d\u62ba\ue8fa\u727f\uf459\u7f9d\u814d\u0f60\u92f3\u14d0\u9e6d\u21bc\uafd5\u2d66\ub4a2\u3ef8\u4003\uca2c\u4de3\ud743\u5d51\ue48e\u6a5d\uec6e\u77c6\uf9c8\u031b\u8eb8\u08e5\u9609\u1852\ua398\u253c\uaf41\u36fa\ub85e\uc206")), f5), f3, irr.SMALL.centerTop(f4 + 4.0f), -1727155);
            f4 += 13.0f;
        }
        float f6 = 18.0f;
        float f7 = (f5 - 6.0f) * 0.5f;
        boolean bl = kwf.usesStudio(tiq2);
        boolean bl2 = irr.inside(f, f2, f3, f4, f7, f6);
        if (bl) {
            irr.secondaryButton(drawContext, wap.s(a.d("\u48cf\u3159\ubbc4\u25de\uae2b\u289f\u92cc\u1b10\u857b\u0fcd\u880d", 849321226, 992925063), a.c(-718933591, "\uf5b1\u8832\u028a\u9cd9\u170b\u91ba\u2bc4\ua201\u3c59\ub6fb")), vhz.CHECK, f3, f4, f7, f6, 0.0f, 0.0f);
        } else {
            irr.primaryButton(drawContext, wap.s(a.b("\uab0b\ud29c\u5859\uc66d\u4df3\ucb45\u7158\uf8c2\u66bf\uec0b\u6bd8\u9184\u1f67\u86d1\u0c91", 790080337), a.c(463568266, "\u7992\u0411\u8ea9\u10fa\u9b28\u1d99\ua7e7\u2e22\ub07a\u3ad8")), vhz.CHECK, f3, f4, f7, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f7, f6, () -> kwf.useStudio(tiq2), null));
            if (bl2) {
                this.iho = wap.s(a.d("\u86f0\uff63\u75b5\uebc4\u603e\ue6bb\u5cef\ud50d\u4b13\uc1f6\u4624\ubc52\u3299\uab35\u2135\ua793\u1dc2\u920e\u08a1\u8eb8\u071b\u7d56\uf3e4\u682f\uee03\u649f\udd2e\u5374\uc982\u4fda\uc425\u3abd\ub0f5\u2919\uaf4d\u25ed\u9a3e\u104a\u96dd\u0f23\u8575\ufbc2\u71e1\uf672\u6cb8\ue2c0\u5b1c\ud1a8\u57ee\ucc7a\u4218", 1007212306, -1918283366), a.c(-266210480, "\uf32f\u8abcj\u9e1b\u15e1\u9364\u2930\ua0d2\u3ecc\ub06c\u37cd\ucdcb\u431d\udadb\u54ea\ud601\u6c34\ue3e6\u7954\uff7f\u76f2\u0cad\u8672\u19ce\u9fbe\u1513\uaca7\u26ef\ub804\u3e57\ub5ee\u4b3e\uc17f\u58f9\udea8\u5077\uebb2\u61cd\ue717\u7ed2\uf48e\u8a03\u044e\u87c0\u1d48\u9347\u2aee\ua023\u266f\ubdca\u37d6\ucd16"));
            }
        }
        float f8 = f3 + f7 + 6.0f;
        boolean bl3 = tcz.mode() == tcw.TEST && tcz.sessionProfile() == tiq2;
        boolean bl4 = irr.inside(f, f2, f8, f4, f7, f6);
        irr.secondaryButton(drawContext, bl3 ? wap.s(a.c(799418159, "\u2775\u5ee3\ud42b\u4a45\uc1c2\u4727\ufd65\u7482\ueada"), a.c(-1937424961, "\u3994\u4046\ucae9\u5499\udb51\u5982\ue3a6\u6a23\uf47f\u7ebc")) : wap.s(a.b("\ud76a\uaeea\u242f\uba59\u31da\ub724\u0d76\u84c9\u1ac5\u9073\u17b5\uedcb\u6316\ufab0", 676583216), a.c(178939321, "\u6194\u1832\u9295\u0ce7\u8352\u01fe\ubba0\u3641\uac7f\u26cd\ua169\u5b10\ud5ce\u4c7b\uc65d")), bl3 ? vhz.PAUSE : vhz.PLAY, f8, f4, f7, f6, bl4 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f8, f4, f7, f6, () -> {
            if (bl3) {
                tcz.stop();
                return;
            }
            kwf.useStudio(tiq2);
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\u32f7\u4b64\uc1b2\u5fc3\ud439\u52bc\ue8e8\u610a", 1777349300));
            if (kfe2 != null && !kfe2.isEnabled()) {
                kfe2.setEnabled(true);
            }
            tcz.startTest(tiq2);
            this.close();
            if (this.iht != null) {
                this.iht.close();
            }
        }, null));
        if (bl4) {
            this.iho = wap.s(a.c(1638427405, "\u6b66\u12f0\u9836\u0648\u8d95\u0b33\ub133\u3881\ua6d2\u2c61\uabba\u518e\udf16\u46bd\uccef\u4a4a\uf044\u7f9a\ue523\u6336\ueaaa\u90d9\u1e6f\u85be\u03ec\u8909\u30bd\ubeff\u2449\ua25e\u29e2\ud73d\u5d7d\uc490\u42c4\uc826\u77a5\ufdc8\u7b16\ue2af\u68bd\u161b\u9c56\u1bfa\u8131\u0f08\ub68f\u3c22\uba6c\u21a7\uaf87\u551b\udcae\u5af4\uc006\u4e5e"), a.d("\uf6a0\u8f48\u05e9\u9b95\u1035\u9685\u28b4\ua524\u3b78\ub1be\u3665\ucc1d\u42b5\udf63\u553c\ud3a6\u69cb\ue61f\u7cac\ufad0\u7313\u0945\u87e5\u1c75\u9e1b\u14b8\uad7c\u232c\ub9ac\u3b9f\ub43d\u4ae5\uc0d0\u592f\udf71\u55ce\uee76\u6066\ue2d4\u7f78\uf522\u8bd7\u0180\u8229\u1c93\u92ed\u2b42\ua1f4\u23a2\ubc6f\u321e\uc8c5\u4173\uc72c\u5da8\ud3fb", -895036441, -9690771));
        }
    }

    private void iiv(DrawContext drawContext, float f, float f2, tiq tiq2, float f3, float f4, float f5) {
        double d;
        ttb ttb2 = tiq2.mineModel();
        if (ttb2 == null) {
            boolean bl = a.b("\uba28\uc39a\u4941", -109462972).equals(tiq2.mineIssue());
            irr.LABEL.draw(drawContext, bl ? wap.s(a.b("\ud6ce\uaf5c\u2587\ubbb2\u3028\ub69b\u0cc3\u8533\u1b65\u9182\u164b\uec6e\u62bf\ufb1d\u7146\uf7b0\u4db1\uc221\u5894\udec3\u573c\u2d6a", -1400056169), a.c(-357345062, "\u5ce0\u2532\uaf93\u3192\uba35\u3cfb\u82c7\u0f2a\u9177\u1bcc\u9c1e\u6661\ue8c1\u7506\uff4f\u7da0\uc7e0\u4843\ud2f4\u54da\ud935\ua773\u29c7\ub21b\u3467\ubeba\u0705")) : wap.s(a.c(-1041252721, "\ubece\uc75e\u4d96\ud3b3\u5830\ude87\u64c7\ued3e\u7366\uf9dc\u7e0e\u843b\u0ab5\u9318\u195a"), a.b("\u43c2\u3a2f\ub0e4\u2ae4\ua52e\u2397\u9dd1\u103e\u8e6e\u04ad\u837a\u7979\uf7a6\u6e1a", -1303820327)), f3, irr.LABEL.centerTop(f4 + 6.0f), iov.textMuted);
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.b("\ubea3\uc736\u4de2\ud398\u580a\udefa\u64e8\ued54\u730f\uf9b9\u7e61\u8455\u0adb\u937c\u1935\u9fc3\u258d\uaa4a\u30f0\ub6ab\u3f1a\u450d\ucbb7\u507b\ud656\u5c92\uc507\u6b74\uf182\u77c3\ufc3d\u02e8\u88a0\u114a\u9718\u1db8\ua279\u2857\uae88\u376d\ubd2e\uc3d2\u498a\uce75\u54f6\uda81\u6341\ue9f8\u6fb0", -2062762273), a.d("\u56f1\u2f61\ua5b6\u3bc3\ub015\u36ab\u8cf1\u0119\u9b2e\u11e7\u9641\u6c37\ue2e1\u7f33\uf101\u7781\ucdc2\u460f\udca9\u7ade\ud30b\ua95b\u27f8\ub835\u3e4e\ub49a\u0d57\u8307\u1d9e\u9bc3\u146f\ueabf\u608c\uf901\u7f50\uf1fd\u4a34\uc04a\u46eb\udf5e\u557e", -772146821, -900879428)), f5), f3, irr.SMALL.centerTop((f4 += 16.0f) + 4.0f), iov.textMuted);
            return;
        }
        String string = new SimpleDateFormat(a.d("\ua67f\udfce\u5557\ucb45\u4092\uc64e\u7c75\uf584\u6ba9\ue14f\u669c", 785467307, -690167365), Locale.ROOT).format(new Date(ttb2.created));
        irr.LABEL.draw(drawContext, wap.s(a.b("\u3eba\u4732\ucdeb\u5392\ud85d\u5ebf\ue4a0\u6d54\uf309\u79b6\ufe20\u0408\u8ac9\u1362\u9964", -1829880091), a.d("\uce70\ub798\u3d31\ua34f\u28e6\uaa37\u147e\u9d85\u03d0\u8d7b\u0ecb\uf0d9\u7a6c\ue3aa\u69fd\uef72\u5152", 443686884, 1163187607)) + Math.round(ttb2.top1) + a.d("\u2926", -1367214904, -646193718), f3, irr.LABEL.centerTop(f4 + 6.0f), ttb2.top1 > ttb2.base1 + 5.0 ? iov.accent() : iov.text);
        irr.SMALL.drawRight(drawContext, string + a.b("\ue65d\u9fec\u15a8\u8b4e\u0099", 220456568) + ttb2.events + wap.s(a.b("\ue296\u9b77\u11bd\u8fc6\u0419\u82b0", 1457644208), a.d("\uaa2d\ud7fc\u5d5a\uc356\u4ce7", -1599955923, 2007971365)), f3 + f5, irr.SMALL.centerTop(f4 + 6.0f), iov.textMuted);
        tvq tvq2 = ttb2.style;
        this.ijp(drawContext, wap.s(a.c(1517859111, "\ub16b\uc8e1\u422d\udc0c\u57c8\ud16a\u6bae\ue2c8\u7cdd\uf673\u71a6\u8bd0\u0553\u9cb6\u16f9\u9005\u2a0f\ua590\u3f28\ub97d\u3099\u4adf\uc47a\u5fac"), a.b("\u6bc3\u126e\u98bc\u02df\u8916\u0fb4\ub570\u3c16\ua656\u2c98\uab35\u513b\udfef\u4622\uc86f\u4a8f\uf0ca\u7f18\ue5a5\u63f2\uea0c\u902c\u1eef\u853f", 1908502521)), ign.ijd(ttb2.top3) + a.b("\ud116\ua830\u2274", 1367855413) + ign.ijd(ttb2.base1), f3, f4 += 15.0f, f5);
        this.ijp(drawContext, wap.s(a.b("\u12fc\u6b7b\ue1a5\u7fd3\uf41c\u72fe\uc8e1\u4115\udf48\u55f7\ud261\u2849\ua688\u3f23\ub525\u3343\u899b\u061f\u9caa\u1afd\u931e\ue942\u67bd\ufc21\u7a5c\uf094\u4934", 2127565488), a.d("\uc43e\ubd94\u374d\ua944\u22ee\ua45e\u1a1d\u97f6\u09a3\u8318\u00d1\ufec3\u7477\ue9a4\u6380\ue575\u5f44\ud4fa\u4ede\uc818\u45f1\u3faf\ub166\u2abb\uacbe\u266c", -100957715, -930266644)), ttb2.legs == null ? wap.s(a.b("\u5de9\u245b\uae9a\u30bc\ubb2f\u3d9b\u87dd\u0e39", -299147897), a.d("\u845e\ufde3\u773b\ue94f\u6686\ue423\u5e74\ud788\u49d7\uc310\u44cd", 205198078, -2126867817)) : ign.ijd(ttb2.legsAcc) + a.d("\ua86c\ud14a\u5b0e", 654358248, 570171047) + ign.ijd(ttb2.legsBase), f3, f4 += 12.0f, f5);
        this.ijp(drawContext, wap.s(a.b("\uaefd\ud765\u5db9\uc3c2\u4851\uce77\u74b3\ufd0d\u634b\ue9e9\u6e2d\u945d\u1a91\u8327\u0974\u8f9e\u35d6\uba54\u20be\ua6f9\u2f14\u5510\udbac\u4072\uc640\u4c93\uf52b\u7b7b\ue185", -1807569240), a.d("\uee9b\u9749\u1de3\u8398\u0c5f\u8a79\u30bd\ubd53\u2306\ua9c2\u2e64\ud41b\u5aa6\uc304\u495e\ucbc4\u75e9\ufa31\u64e9\ue2b7\u6b4f\u1502\u9bb3h\u8616\u0cc9\ub50d", -231409272, -340258008)), Math.round(ttb2.hand.similarity) + a.c(1839032658, "\u6973\u10c7\u9a83\u0465") + Math.round(ttb2.hand.overshootUser * 100.0) + a.c(-281004273, "\u372e\u4e9a\uc446\u5a38") + Math.round(ttb2.hand.overshootModel * 100.0) + a.c(-214381563, "\ucc21"), f3, f4 += 12.0f, f5);
        this.ijp(drawContext, wap.s(a.c(-149377262, "\uaf5d\ud6da\u5c13\uc237\u49a6\ucf10\u7550\ufcbe\u62ac\ue84a\u6f86\u95f6\u1b24\u829c\u088a\u8e2c\u347b\ubbb7\u211d\ua74e\u2ebe\u54e6"), a.c(-1345077492, "\ubb3c\uc29d\u4842\ud634\u59fa\udb2f\u6108\ue889\u76aa\uf807\u7bc6\u85a5\u0f12\u96d3\u1c81\u9a7f\u204c\uafea")), Math.round(tvq2.activeRate) + wap.s(a.b("\u3ec3\u4730\ucded\u53df\ud84a\u5eff\ue4ab\u6d14\uf3dc\u79fa", 1578450665), a.d("\u1fee\u624e\ue897\u72f2\ufd36\u7b83\uc1d5\u4c39\ud2f1\u58d7", -1659909765, 1975047871)) + ign.ijw(tvq2.activeDia) + wap.s(a.c(-929178004, "\ude48\ua7bd\u2d63\ub31a"), a.c(564916801, "\uf265\u8fc4\u051c\u9b6a")), f3, f4 += 12.0f, f5);
        toq toq2 = nfl.neuroBrain();
        double d2 = d = toq2 == null || toq2.model != ttb2 ? -1.0 : toq2.rate();
        String string2 = d < 0.0 ? wap.s(a.c(-1593790030, "\ub1d2\uc862\u42aa\udc8f\u5715\ud1a0\u6bf4\ue202\u7c5a\uf6e2\u7176\u8b5e\u0595\u9c35"), a.b("\u5142\u288f\ua244\u3844\ub78e\u3137\u8f71\u029a\u9cc1\u1671\u91ad\u6bd7", -99527301)) : Math.round(d) + wap.s(a.d("\u27df\u5e2c\ud4f1\u4ac3\uc156\u47e3\ufdb7", 1163230869, -162571923), a.b("\uc0ea\ubd4a\u3793\uadf6\u2232\ua487\u1ed1", -930496307)) + (tvq2.activeRate > 0.0f ? a.b("\u97ab\uee12", 259823497) + (d >= (double)tvq2.activeRate ? a.c(-31107558, "\u5630") : "") + Math.round((d / (double)tvq2.activeRate - 1.0) * 100.0) + a.c(-262667615, "\u0286\u7b3b") : "");
        this.ijp(drawContext, wap.s(a.d("\ud619\uaf85\u254d\ubb68\u30f1\ub641\u0c0a", 1786752846, 875395346), a.c(-884013130, "\u03ad\u7a33\uf09c\u6a8f\ue539\u63fc\ud9a3\u502c\uce04\u44c4")), string2, f3, f4 += 12.0f, f5);
        this.ijp(drawContext, wap.s(a.d("\ucdf7\ub471\u3ea6\ua0d5\u2b15\uadb9\u17ec\u9e1c\r\u8a2b\u0d6f\uf758\u7985\ue031\u6a68\uec91\u5695\ud9d3\u43f7\uc5f5\u4c01\u3652\ub8fa\u232c\ua549", -366178488, -1193655564), a.c(-1363358810, "\ucf91\ub635\u3ce3\ua298\u2933\uaffc\u15d8\u9846\u068e\u8ca8\u0f1f\uf511\u7bc5\ue276\u6c3f\uea59\u5081\udb31\u41fc\uc7d2\u4e5d\u3409\ubac5")), (tvq2.reactionMs > 0 ? tvq2.reactionMs + wap.s(a.d("\u44f9\u3d05\ub7c8", 1583793228, -1275494250), a.c(516046238, "\u3dbd\u4010\ucabe")) : a.b("\uf571", -1790847644)) + a.c(1183741745, "\u7712\u0e34\u8470") + Math.round(tvq2.turnRate) + a.b("\ue66b\u9f45", 1018357465) + wap.s(a.d("\u6e5f", -494887186, 1816719556), a.b("\ud080", 1635964099)) + a.c(-382177298, "\u6fcd\u16eb\u9caf") + Math.round(tvq2.sprintShare * 100.0f) + a.b("\ued55", -1000018575), f3, f4 += 12.0f, f5);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.b("\u4387\u3a3d\ub0e3\u2e94\ua54b\u23f4\u99a6\u1013\u8e03\u04b3\u832e\u791c\uf7c0\u6e76\ue423\u62d8\ud891\u5756\ucdb6\u4bae\uc244\ub841\u36bc\uad66\u2b0a\ua1c8\u186c\u966f\u0ccb\u8a88\u012d", -1824111621), a.b("\udf2c\ua6e2\u2c4f\ub232\u39e2\ubf26\u0500\u8cf9\u12a5\u9c0a\u1fc4\ue5b8\u6f7f\uf2ae\u7888\ufe04\u4436\ucbef\u5159\ud77f\u5e82\u20ba\uae05\u31ce\ub7b5\u3d18\u84d7\u0af8\u9004\u165b\u998d\u6341\ue906\u74e2\uf6a3\u7c18\uc3c3\u49b3\ucf6e\u56d4", -2031363269)), f5), f3, irr.SMALL.centerTop((f4 += 12.0f) + 4.0f), iov.textMuted);
        float f6 = 18.0f;
        boolean bl = lfa.minesWith(tiq2);
        boolean bl2 = irr.inside(f, f2, f3, f4 += 13.0f, f5, f6);
        if (bl) {
            irr.secondaryButton(drawContext, wap.s(a.c(1578366292, "\uf500\u8c85\u0657\u983d\u13c8\u955d\u2f09\ua6f3\u38e9\ub21c\u35c2\ucfbd\u417e\ud89c\u5298\ud477\u6e25\ue1e8\u7b13\ufd0b\u74e1"), a.b("\u9298\ueb1d\u61cf\uffa5\u7450\uf2c5\u4891\uc16b\u5f71\ud1da\u560d\uac7d\u22a5\ubb11\u3135\ub3a6\u0dfc\u8221", -1223257397)), vhz.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                lfa.activateMine(null);
                this.iib(wap.s(a.c(-284355723, "\u1317\u6a92\ue040\u7e2a\uf5df\u734a\uc91e\u40e4\udefe\u5406\ud3cf\u29ed\ua778\u3eca\ub49b\u3262\u8866\u07e3\u9d4b\u1b55\u92eb\ue8a7\u6613\ufd91\u7ba1\uf168\u48c2\uc6dd\u5c6e\uda32\u518f\uaf5e\u251f\ubce9\u3ab3"), a.d("\u7ee3\u0766\u8db4\u13de\u982b\u1ebe\ua4ea\u2d10\ub30a\u3dda\uba75\u4007\ucedc\u576f\ud92c\u5bc7\ue18c\u6e5c\uf4e0\u72b4\ufb34\u8507\u0fd5\u9475\u1206", -74604138, -1113465043)), vhz.INFO, false);
            }, null));
            if (bl2) {
                this.iho = wap.s(a.b("\uf8b1\u812f\u0bf9\u9582\u1e5d\u98a7\u02c0\uab05\u353b\ubfbe\u386c\uc206\u4cf3\ud566\u5f32\ud9c8\u63c2\uec54\u76ef\uf0b4\u7955\u0357\u8da6\u1674\u9009\u1ad0\ua328\u2d2d\ub7c1\u31df\uba38\u44f5\uceb7\u5703\ud112\u5bb4\ue47f\u6e0b\ue8c0\u7128\ufb33\u85c5\u0fd8\u882d\u12f7\u9c88\u255b\uafe4\u29ac\ub274", 696252608), a.b("\u4387\u3a17\ub0c7\u2eb4\ua179\u07fc\u9d9b\u1078\u8e20\u04e4\u834a\u7945\uf793\u6e2c\ue013\u6683\udcf8\u5328\uc980\u4ff3\uc620\ubc76\u32ce\ua95a\u2b37\ua195\u1825\u9676\u0cff\u8aa5\u011e\uffcf\u7583\uec79\u6e3f\ue094\u5f47\ud537\u53eb\uca57\u400d\u3ef1", -1737734217));
            }
        } else {
            irr.primaryButton(drawContext, wap.s(a.b("\ue164\u98f3\u1236\u8c02\u079c\u812a\u3b37\ub2a7\u2ccc\ua67c\u21b4\udbe7\u5514\ucca2\u46fa", 991420734), a.c(-594688726, "\uc125\ub8cd\u3260\uac10\u27c2\ua104\u1b2c\u92d4\u0c87\u8634\u0195\ufbea\u7151\uecf2\u62b3\ue423\u5e58\ud188\u4b20\ucd53\u4480\u3ed6\ub06e")), vhz.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                lfa.useForMine(tiq2);
                this.iib(wap.s(a.c(690019623, "\udd4b\ua4ce\u2e1c\ub076\u3b83\ubd16\u0742\u8eb8\u10a2\u9a57\u1d89\ue7f6\u6935\uf0d7\u7ac8\ufc3c\u4671\uc9ae\u5358\ud550\u5cb1\u26fa\ua81c\u3383\ub5fd\u3f34\u86d0\u0889\u9218\u1462\u9fc1\u6117\ueb45\u7289\uf4e7\u7e4d\uc18f\u4beb\ucd25\u5492\udecc\ua073\u2a6f\uaddf\u374f"), a.b("\u957c\uecf9\u662b\uf841\u73b4\uf521\u4f75\uc68f\u5895\ud63e\u51e9\uab99\u2541\ubcf5\u36d1\ub442\u0a17\u85cc\u1f75\u9d3e\u10ab\u6af3\ue02b\u7bf2\ufdeb\u7711\uceb2\u40e4\uda0e\u5c62\ud7ec\u2926\ua37c\u3a98\ubcd6\u3661\u89b7\u0388\u8149\u18f0\u92ae\uec2a\u6670\ue1d7\u7b6c\uf109", -2020895469)), vhz.CHECK, false);
            }, null));
            if (bl2) {
                this.iho = wap.s(a.c(-1398004916, "\u233b\u5abe\ud06c\u4e06\uc5f3\u4366\uf932\u70c8\ueed2\u6433\ue3f9\u1982\u975d\u0ef4\u84f4\u0247\ub806\u37d4\uad6b\u2b32\ua2dd\ud8d3\u566c\ucde9\u4b97\uc141\u78ee\uf6a2\u6c06\uea16\u61aa\u9f71\u157a\u8cdc\u0a99\u8025\u3ff5\ub59c\u331c\uaafa\u20bb\u5e57\ud418\u53e1\uc962\u470f\ufedd\u7476\uf26a\u69f6\ue787\u1d5d\u94eb\u12b3"), a.d("\u2cb1\u5534\udfe6\u418c\uca79\u4cec\uf6b8\u7f42\ue158\u6ffb\ue851\u125a\u9c84\u054d\u8f6e\u099a\ub3a2\u3811\ua6b3\u20e8\ua91a\ud34f\u5dfe\uc23b\u4448\uca83\u734a\ufd18\u67ee\ue1c5\u6a0c\u90bf\u1ee8\u8301\u0137\u8bfd\u3420\ube5d\u38f4\ua527\u2b15\u55eb\udfc4\u5872\uc6bc\u4cd1\uf500\u7fbb\uf9f5\u622a\uec2e\u16fd", -985249691, 163013793));
            }
        }
    }

    private void iiw(tiq tiq2) {
        if (this.ihe != tiq2) {
            this.ihg = false;
            this.ihi = 0.0f;
        }
        this.ihe = tiq2;
        if (tiq2 != null) {
            tiq2.prefetch();
        }
    }

    private static String iix(tiq tiq2) {
        if (!eyn.online()) {
            return wap.s(a.d("\ud684\uaf35\u2571\ubb97\u3040\ub6b2\u0cee\u851c\u1b59\u91f9\u166e\uec50\u628e\ufb3f", 385415165, -1842273961), a.b("\u56fa\u2f4b\ua50f\u3be9\ub03e\u3291\u88cd\u0136\u9f62\u15d9\u920e\u6c61\ue6a4\u7f6c\uf54e\u73be", 1968199370));
        }
        if (tiq2.recordingsLoading()) {
            int n = Math.max(0, tiq2.recordingsTotal());
            return wap.s(a.c(766482002, "\u9679\uefc8\u658c\ufb6a\u70bd\uf64f\u4c13\uc5e1\u5ba4\ud104\u5693"), a.d("\u71a9\u0818\u825c\u1cba\u976d\u15c2\uaf9e\u2665\ub831\u328a\ub55d\u4b32", 262629721, 700651740)) + tiq2.recordingsLoaded() + a.d("\ub255", -1427641815, 295458898) + n;
        }
        int n = tiq2.recordingsTotal();
        return n < 0 ? "" : wap.s(a.c(-1166224843, "\ud21a\uabab\u21ef\ubf09\u34de\ub226\u0872\u81cd\u1fd1\u956f\u12bf\ue8d4\u6612\ufffd\u75b4"), a.b("\u91cf\ue87e\u623a\ufcdc\u770b\uf5a8\u4be9\uc606\u5856\ud2ed\u5535\uaf4e\u2196\ubc28\u3661", -133852704)) + n + wap.s(a.c(-171662096, "\ua4d5\udd36\u57f2\uc985\u421f"), a.c(-1060228833, "\u313a\u4c9c\uc648\u5836\ud7f0"));
    }

    private List<eyg> iiy(tiq tiq2) {
        ArrayList<eyg> arrayList = new ArrayList<eyg>();
        String string = tiq2.kind();
        for (eyg eyg2 : tiq2.versions()) {
            if (!string.equals(eyg2.meta().get(a.c(-390641499, "\u48ca\u3179\ubbad\u25d6")))) continue;
            arrayList.add(eyg2);
        }
        return arrayList;
    }

    private void iiz(DrawContext drawContext, float f, float f2, tiq tiq2, float f3, float f4) {
        int n = this.iiy(tiq2).size();
        tik tik2 = tiq2.cloud(tiq2.kind());
        String string = this.ihg ? wap.s(a.d("\u99dc\ue06e\u6abf\uf4c6", 1848586782, -139482204), a.b("\u22e7\u5b5b\ud18f\u4ff9\uc42a", 483272415)) : (tik2 == tik.SAVING ? wap.s(a.c(-1476346665, "\ubcad\uc50e\u4fca\ud1a4\u5a74\udccc\u66d8\uefbe\u7176"), a.d("\u5d83\u244d\uaee5\u3091\ubb36\u3d8a\u87ab\u0e5b\u946a\u1e4c\u9908", 1807612696, -1274699055)) : (tik2 == tik.FAILED ? wap.s(a.c(938319265, "\u9dc3\ue473\u6ebb\uf09e\u7b1a\ufdb9\u47fd\uce1f\u5041\udab4\u5df0\ua716"), a.d("\ufb55\u82ec\u0c2a\u963a\u1d92\u9b58\u210e\ua88f\u36dd\ubc64\u3bbf\uc1c3\u4b04\ud222\u58e6", 1213467905, -708775322)) : "")) + wap.s(a.b("\u4bbd\u321f\ub8db\u26ab\uad66\u2bd1\u9183\u186f\u8663", -1984017470), a.c(1355796776, "\ud51d\uacab\u260d\ub87d\u33d3\ub562\u0b29")) + n;
        float f5 = Math.max(16.0f, irr.SMALL.width(string) + 9.0f);
        boolean bl = irr.inside(f, f2, f3 - f5, f4 - 5.5f, f5, 11.0f);
        int n2 = tik2 == tik.FAILED && !this.ihg ? -1750963 : (this.ihg || bl ? iov.accent() : iov.textMuted);
        irr.drawChip(drawContext, string, f3, f4, n2, iov.stroke, bl ? 1.0f : 0.0f);
        this.ihc.add(new ige(f3 - f5, f4 - 5.5f, f5, 11.0f, () -> {
            this.ihg = !this.ihg;
            this.ihi = 0.0f;
            if (this.ihg) {
                tiq2.refreshVersions(true);
            }
        }, null));
        if (bl) {
            this.iho = this.ihg ? wap.s(a.b("\uc623\ubfb1\u3560\uab19\u2085\ua660\u1c28\u9596\u0b9d\u8130\u06ee\ufcda\u7240\uebf3\u61ab\ue75b\u5d1d", 226543216), a.d("\u8913\uf08f\u7a5b\ue42d\u6ffe\ued5b\u5312\udef9\u44ba\uce09\u49d0\ub3a0\u3d79\ua4cb", 834514197, -1008787435)) : wap.s(a.b("\ufcb6\u8534\u0ff4\u9192\u1a4e\u9ca6\u26a1\uaf56\u311a\ubba3\u3c77\uc60d\u48db\ud12e\u5b30\uddc3\u6787\ue857\u72ed\uf4f0\u7d4e\u0705\u89e5\u127f\u940e\u1eca\ua77d\u2978\ub3c6\u3590\ube6d\u40e8\ucabb\u5347\ud551\u5fa3\ue07b\u6a09\uecc0\u7560\uff61\u818a\u0b89\u8c21\u16fc\u9885\u211d\uabe3\u2dad\ub677\u3841\uc2c4\u4b68\ucd76\u57c9\ud99b\u622a\ue4fe\u6ec5\uf718\u79eb\u03bb\u8441\u0e19\u90c7\u1967\ua371\u25cf\uaf9b\u3022\ubab5\u3c8b\uc555\u4fef\ud1aa", 697433272), a.b("\u5318\u2a83\ua056\u3e25\ub5f6\u3338\u8d04\u00eb\u9ebb\u1478\u93af\u69ac\ue773\u7ec2\uf49c\u7212\ucc32\u47ff\udd4e\u5b15\ud2e3\ua8bc\u2678\ub9c5\u3bdf\ub10b\u08c8\u8694\u1c66\u9a4d\u11fd\uef22\u6102\ufce1\u7ea0\uf00f\u4fd7\uc5ac\u4374\udacf\u509f\u2a61\ua028\u238b\ub925\u372e\u8ef9\u043d\u820a\u1dc3\u97a8\u6961\ue4c1\u6297\uf867\u7645\ucdf9\u4b5c\uc120\u5ce9\ud643\uac6c\u2bea\ua1b0\u3f01\ub6bd\u088c\u8e71E\u9f83\u1554\u932e\u6af2\ue45b\u7e13\uf5e1\u73c6\uc902\u40d4\udea8", -81373358));
        }
    }

    private void ija(DrawContext drawContext, float f, float f2, tiq tiq2, float f3, float f4, float f5) {
        float f6 = this.igz + 360.0f - 16.0f - 12.0f;
        if (!eyn.online()) {
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(wap.s(a.c(-744393332, "\u75e0\u0c7e\u86ae\u18c5\u9303\u15f6\uafec\u2607\ub80b\u32f5\ub52f\u4f5e\uc1d5\u587e\ud27e\u5488\ueed2\u6110\ufba5\u7da0\uf403\u8e4e\u00f0\u9b64\u1d5c\u978b\u2e34\ua06d\u3adf\ubcda\u3775\uc9be\u43ec\uda07\u5c46\ud6f8\u6967\ue342\u658d\ufc31\u762b\u0896\u82c6\u0579\u9fab\u11db\ua81f"), a.c(2106771448, "\uc3ca\uba54\u308d\uaef7\u252a\ua39f\u1dd2\u903e\u0e69\u84d9\u0300\uf90e\u77da\uee6a\u6445\ue2b6\u58fa\ud32f\u4986\ucbc0\u4230\u386e\ub6a1\u2d72\uab0e\u21a5\u9c0e\u1647\u8cbb\u0a99\u8129\u7b9b\uf5b3\u6c30\uea16\u60d2\udf07\u5161\ud3a9\u4a1d\uc04c\ubeb9\u34eb\ub32f")), f5), f3, irr.SMALL.centerTop(f4 + 6.0f), iov.textMuted);
            return;
        }
        List<eyg> list = this.iiy(tiq2);
        if (list.isEmpty()) {
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(tiq2.versionsLoading() ? wap.s(a.c(-686614763, "\u1748\u6eda\ue407\u7a73\uf1a9\u771f\ucd45\u44f3\udaf8\u5055\ud78b\u2dbf\ua324\u3a90\ub0d9\u362f\uac32"), a.b("\u1137\u68a1\ue271\u7c73\uf7a7\u7163\ucb36\u42b9\ud888\u5658\ud1f5\u2b83\ua52d\u3ce3\ub6b4\u1459", -729213648)) : wap.s(a.d("\uc5d9\ubc49\u36d5\ua8f7\u2332\ua594\u1fd4\u9624\u083f\u82d8\u0518\uff7e\u71a8\ue803\u6256\ue4a6\u5ef4\ud176\u4b9c\ucdd1\u4437\u3e28\ub081\u2b04\uad7d\u27bf\u9e04\u1052\u8aeb\u0cfb\u8709\u7995\uf3d8\u6a22\uec70\u66c8", -760468193, -1115952980), a.b("\u2eba\u5714\uddbc\u43c8\uc86f\u4ed3\uf4ec\u7d71\ue32e\u69e9\uee34\u1020\u9ae5\u0353\u8975\u0f85\ub5b3\u3a63\ua4c9\u2687\uaf71\ud524\u5b9d\uc45c\u463e\ucce7\u7523\uff0a\u65e7\ue7a8\u6c14\u92b7\u18fc\u8172\u0339\u8d94\u3241\ub83a\u3ee8\ua757\u2d7f", -1722602830)), f5), f3, irr.SMALL.centerTop(f4 + 6.0f), iov.textMuted);
            return;
        }
        float f7 = 24.0f;
        float f8 = f6 - f4;
        float f9 = Math.max(0.0f, (float)list.size() * f7 - 2.0f - f8);
        this.ihi = Math.min(this.ihi, f9);
        this.ihh += (this.ihi - this.ihh) * 0.35f;
        String string = tiq2.activeKey(tiq2.kind());
        uut.pushScissor(drawContext, f3 - 2.0f, f4, f5 + 4.0f, f8);
        float f10 = iov.r(5.0f);
        for (int i = 0; i < list.size(); ++i) {
            long l;
            eyg eyg2 = list.get(i);
            float f11 = f4 + (float)i * f7 - this.ihh;
            if (f11 + f7 < f4 || f11 > f6) continue;
            boolean bl = tiq2.ownVersion(eyg2);
            boolean bl2 = bl && eyg2.key().equals(string);
            boolean bl3 = irr.inside(f, f2, f3, f11, f5, f7 - 2.0f) && irr.inside(f, f2, f3, f4, f5, f8);
            int n = bl2 ? ujt.lerp(iov.field, iov.accent(), 0.16f) : iov.field;
            uut.round(drawContext, f3, f11, f5, f7 - 2.0f, f10, bl3 ? ujt.lerp(n, iov.fieldHover, 0.5f) : n);
            if (bl2) {
                uut.outline(drawContext, f3, f11, f5, f7 - 2.0f, f10, 1.0f, iov.accent(180));
            }
            try {
                l = Long.parseLong(eyg2.meta().getOrDefault(a.c(782589513, "\u5e2d\u278d\uad49\u333c\ub8fe\u3e5e\u840c"), a.d("\uc415", 897037790, 1952084474)));
            }
            catch (NumberFormatException numberFormatException) {
                l = 0L;
            }
            if (l <= 0L) {
                l = eyg2.uploaded() * 1000L;
            }
            String string2 = new SimpleDateFormat(a.c(137798745, "\ua436\udd87\u571e\uc90c\u42db\uc407\u7e3c\uf7cd\u69e0\ue306\u64d5"), Locale.ROOT).format(new Date(l));
            String string3 = bl ? "" : wap.s(a.c(-197554323, "\u8f47\uf6f6\u7cb2\ue254\u6983\uef74\u5533\udcdf\u4282\uc87e"), a.c(45716222, "\u92d6\ueb67\u6123\uffc5\u7412\uf6bb\u4ce7\uc101")) + eyg2.meta().getOrDefault(a.c(1648956708, "\u1553\u6ce0\ue62e\u7856\uf38e\u753a\ucf60"), a.b("\u3ca7", -1428472679));
            float f12 = 52.0f;
            float f13 = f5 - f12 - 30.0f;
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string2 + string3, f13), f3 + 6.0f, irr.SMALL.centerTop(f11 + 7.0f), bl2 ? iov.accent() : iov.text);
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(ign.ijb(eyg2) + a.d("\u3180\u4831\uc275\u5c93\ud744", -531317001, -463302830) + Math.max(1, Math.round((float)eyg2.size() / 1024.0f)) + wap.s(a.b("\u9f0f\ue6d5\u6c0f", 2039979820), a.d("\u4dd4\u305f\uba87", 1713517249, 1286111030)), f13), f3 + 6.0f, irr.SMALL.centerTop(f11 + 16.0f), iov.textMuted);
            float f14 = f3 + f5 - f12 - (bl ? 22.0f : 4.0f);
            float f15 = f11 + 4.0f;
            if (bl2) {
                irr.drawChip(drawContext, wap.s(a.c(1899300375, "\u0678\u7fce\uf553\u6b77\ue0a6\u6601"), a.c(-502326169, "\u1853\u619b\ueb36\u7546\ufe94\u7852\uc27a\u4bff\ud5d6\u5f10\ud8c0\u22bf")), f14 + f12, f11 + 11.0f, iov.accent(), iov.stroke, 0.0f);
            } else {
                boolean bl4 = irr.inside(f, f2, f14, f15, f12, 14.0f) && irr.inside(f, f2, f3, f4, f5, f8);
                irr.secondaryButton(drawContext, wap.s(a.c(-678056241, "\uae87\ud715\u5dc8\uc3bc"), a.d("\u8871\uf1e7\u7b37\ue535\u6ee1\ue824\u5278\udbf3\u45a2", -1934437717, 409034436)), null, f14, f15, f12, 14.0f, bl4 ? 1.0f : 0.0f, 0.0f);
                if (f11 >= f4 - 1.0f && f11 + f7 <= f6 + 1.0f) {
                    this.ihc.add(new ige(f14, f15, f12, 14.0f, () -> {
                        tiq2.useVersion(eyg2);
                        this.iib(wap.s(a.d("\u5ee1\u2773\uadae\u33da\ub800\u3eb6\u84ec\u0d5a\u9351\u19fc\u9e2e\u6445\ueac1\u7326\uf966\u7f80\uc5ce\u4a05\ud0b0\u56e0\uff5f", -573824609, -1897496793), a.c(-1694610078, "\u4961\u30f7\uba27\u2425\uaff1\u2935\u9360\u1aef\u80de\u0e02\u89de\u73ae\uf91a\u64b9\ueeed\u6869\ud227\u5d8f\uc74a\u6573")), vhz.REFRESH, false);
                    }, null));
                }
                if (bl4) {
                    String string4 = this.iho = bl ? wap.s(a.d("\u3e2e\u47b9\ucd7c\u5348\ud8cb\u5e66\ue434\u6ddf\uf3d3\u7934\ufef4\u0492\u8a44\u13ef\u99ba\u1f4a\ua54b\u2ad5\ub06f\u3678\ubfdb\uc596\u4b28\ud0bc\u568e\udc5d\u65e5\uebb5\u714b", -1429811384, -274140882), a.c(-529193473, "\u21f9\u5811\ud2bc\u4ccc\uc71e\u41d8\ufbf0\u7208\uec5b\u66e8\ue149\u1b36\u918d\u0c51\u860d\u00fd\ubed1\u3512\uafa6\u2982\ua074\uda5c\u5499\ucb26\u4945\uc396\u7a2f\uf47f\u6e86\ue8d4")) : wap.s(a.b("\u2b8e\u5213\ud8df\u46a7\ucd29\u4bcc\uf183\u7873\ue636\u6cd4\ueb4a\u1139\u9fe5\u0655\u8c0f\u0ab2\ub0b4\u3f62\ua5cb\u2381\uaa39\ud03c\u5e93\uc543\u4326\uc9a4\u7047\ufe14\u64fe\ue2a6\u691a\u97ce\u1d88\u843c\u022e\u8890\u374d\ubd78\u3bfe\ua249\u2800\u56b4\udcae\u5b02", -2069746719), a.b("\u8143\uf8e9\u723e\uec4e\u679e\ue157\u5b7a\ud287\u4cda\uc619\u41c4\ubfd9\u3563\uacdd\u268f\ua41d\u1a4e\u959d\u0f24\u8974\u008d\u7aab\uf074\u6fb7\uedda\u6314\udad8\u54f7\uce7a\u4857\uc3e7\u3d41\ub362\u2e8b\uacc0\u2269\u9dc7\u17c8\u911a\u08ae\u8286\ufc0c\u7656\uf1eb\u6b3e\ue53d\u5ce0", -1136491187));
                }
            }
            if (!bl) continue;
            float f16 = f3 + f5 - 18.0f;
            boolean bl5 = eyg2.key().equals(this.ihl) && System.currentTimeMillis() - this.ihm < 3000L;
            boolean bl6 = irr.inside(f, f2, f16, f15, 14.0f, 14.0f) && irr.inside(f, f2, f3, f4, f5, f8);
            irr.iconButton(drawContext, vhz.TRASH, f16, f15, 14.0f, bl6 ? 1.0f : 0.0f, bl5, 1.0f);
            if (f11 >= f4 - 1.0f && f11 + f7 <= f6 + 1.0f) {
                this.ihc.add(new ige(f16, f15, 14.0f, 14.0f, () -> {
                    if (!eyg2.key().equals(this.ihl) || System.currentTimeMillis() - this.ihm > 3000L) {
                        this.ihl = eyg2.key();
                        this.ihm = System.currentTimeMillis();
                        return;
                    }
                    this.ihl = null;
                    tiq2.deleteVersion(eyg2);
                    this.iib(wap.s(a.c(-422768564, "\u1015\u6997\ue353\u7d23\uf6ee\u7059\uca0b\u43b4\uddaf\u571f\ud0c5\u2abd\ua47b\u3ddb\ub789"), a.b("\uad2f\ud4b9\u5e1f\uc06f\u4bc1\ucd07\u733b\ufea9\u6081\uea34\u6dec\u9793\u194c\u80f0", 1788782899)), vhz.TRASH, false);
                }, null));
            }
            if (!bl6) continue;
            this.iho = bl5 ? wap.s(a.d("\u1caf\u6531\uefe7\u719c\ufa43\u7cb9\uc6ab\u4f5c\ud105\u5bbc\udc68\u2657\ua8d4\u317e\ubb62\u3dd7\u8799\u0841\u92fb\u14bb\u9d5d\ue749\u69b3\uf27f\u7454\ufec3\u4764\uc928\u53dd\ud5c1\u5e26\ua0eb\u2aa9\ub31d\u350d\ubfb3g\u8a0c\u0cce", 157443967, -63210572), a.d("\u09ce\u7023\ufae8\u60e8\uef25\u6995\ud3c5\u5a36\uc073\u6af6\ucd11\u3303\ubda3\u2416\uae4e\u28bc\u9289\u1d56\u8389\u01c0\u8838\uf67e\u7cd3\ue70d\u6178\ueba2\u521b\udc40", 1486666695, -549341696)) : wap.s(a.b("\ub027\uc9b7\u436d\udd15\u56d3\ud073\u6a65\ue3c0\u7d83\uf733\u70fa\u8ad8\u0459\u9dfb\u17bf\u914f\u2b1a\ua4cd\u3e7f", 62959728), a.b("\u10d9\u697f\ue3a8\u7dd2\uf606\u70cd\uca90\u470d\udd3f\u5781\ud053\u2e41\ua484\u3d32\ub714\u31e4\u8bd2\u0475", 151000296));
        }
        uut.popScissor(drawContext);
    }

    private static String ijb(eyg eyg2) {
        Map<String, String> map = eyg2.meta();
        if (a.d("\ua7c3\ude64\u54ba\ucacc", -356377622, 1701755994).equals(map.get(a.d("\ubba3\uc210\u48c4\ud6bf", -1053645378, 2131566194)))) {
            return wap.s(a.d("\u99a2\ue01d\u6ad2\uf4a9\u7f2d", -1354311621, -1253424649), a.c(841166283, "\u29f9\u5049\uda91\u44e2\ucf3f\u49fe\uf3dd\u7e34")) + map.getOrDefault(a.b("\ue32a\u9a95\u105a\u8e21", -1249451195), a.c(-687272553, "\u0da9")) + a.b("\uaf8f\ud63b\u5ce8\uc20e\u494e\ucfff", 1031778220) + wap.s(a.d("\u578a\u2e3a\ua4ee\u3a83\ub149\u37ab", 184725874, 2121655946), a.b("\u53b6\u2a06\ua0d9\u3ea4\ub50d\u33c2\u89ed\u047e", -350267519)) + map.getOrDefault(a.b("\u433a\u3a8a\ub05e\u2e33", 1642021706), a.d("\uee70", 869288391, 2111219593)) + a.d("\uf380", 1223426748, -833687272);
        }
        if (a.c(-1848527316, "\ub645\ucff0\u4524\udb5e").equals(map.get(a.c(-478166536, "\uc197\ub824\u32f0\uac8b")))) {
            String string = map.getOrDefault(a.d("\ud7f2\uae4a\u249b\ubafe", 193331248, -906045526), "");
            String string2 = map.getOrDefault(a.b("\u3e56\u47ea\ucd39\u5354\ud884", 2141535793), a.b("\u481a", -1822472149));
            return wap.s(a.c(-1782852913, "\ud2b9\uab11\u21c8\ubfb1\u347e\ub29c"), a.b("\uf2f4\u8b3c\u0195\u9feb\u1442\u9693", -1180895552)) + map.getOrDefault(a.d("\u7274\u0bde\u8112\u1f22", 295050168, -1694209604), a.c(-979148384, "\u619e")) + a.c(266419620, "\u3d87\u4433\ucee0\u5006\udb46\u5df7") + wap.s(a.d("\u7ca2\u051a\u8fc6\u11bd\u9a2e", -874869118, -1868500403), a.b("\u61b8\u180a\u92a0\u0cdb\u831c", -1816304131)) + map.getOrDefault(a.d("\uf1d5\u886d\u02b1\u9cca", 1465591735, -1639590386), a.c(-943317316, "\u1e82")) + a.d("\u23ef", 1030898029, -1430494554) + (string.isEmpty() ? "" : a.c(-579725755, "\u1660\u6fd1\ue595\u7b73\uf0a4") + wap.s(a.b("\u99f7\ue050\u6a8e\uf4f8\u7f64", -1861445243), a.b("\u0ade\u7314\uf9cd\u67c4\uec6e\u6ade\ud49d", 16977564)) + string + a.c(2133358322, "\u76d6")) + (a.d("\ua3ab", 401392358, -189505156).equals(string2) ? "" : a.b("\u0a1c\u73ad\uf9e9\u670f\uecd8\u6a62", -136312262) + string2 + a.d("\u994c", -699890809, 536025839));
        }
        return wap.s(a.d("\udacd\ua366\u29b1\ub7c4\u3c16\ubaaa\u00ea\u8900\u1742\u9dfe\u1a74", 277948855, 2142171906), a.b("\u7449\u0dfc\u8754\u192f\u928d\u143f\uae1c\u27e1\ubda0", 1437167617)) + map.getOrDefault(a.b("\u2a05\u53ae\ud979\u470c\uccde\u4a62\uf022\u79c8\ue78a\u6d36", -534369668), a.d("\u4a56", 1487695359, -1655887977)) + a.b("\ud5ce", 265082346);
    }

    private void ijc(DrawContext drawContext, String string, String string2, double d, double d2, float f, float f2, float f3) {
        irr.SMALL.draw(drawContext, string + a.d("\uc5c5\ubc74", 1573951842, 768433285) + string2, f, irr.SMALL.centerTop(f2 + 5.0f), iov.textDim);
        String string3 = Double.isNaN(d2) ? "" : wap.s(a.d("\u2672\u5fc3\ud553\u4b24\uc0ff\u464b\ufc1d\u75eb\uebbd\u614b", 829366800, -1274280888), a.d(".\u799f\uf753\u6923\ue288\u6445\ude13\u57e7\uc9bc\u4717", -340973526, 1688348718)) + ign.ijd(d2);
        float f4 = irr.SMALL.width(string3);
        irr.SMALL.drawRight(drawContext, string3, f + f3, irr.SMALL.centerTop(f2 + 5.0f), iov.textMuted);
        int n = d >= 90.0 ? iov.accent() : iov.text;
        irr.LABEL.drawRight(drawContext, ign.ijd(d), f + f3 - f4, irr.LABEL.centerTop(f2 + 5.0f), n);
    }

    private static String ijd(double d) {
        return Double.isNaN(d) ? a.b("\u874e", -1833982117) : Math.round(d) + a.b("\u670b", -232036561);
    }

    private void ije(tiq tiq2) {
        long l = System.currentTimeMillis();
        if (l - this.ihr > 3000L) {
            this.ihr = l;
            return;
        }
        this.ihr = 0L;
        if (tcz.sessionProfile() == tiq2) {
            tcz.stop();
        }
        try {
            tiq2.clearRecordings();
            this.iib(wap.s(a.d("\u9dde\ue458\u6e8d\uf0f0\u7b3a\ufd9d\u47c3\uce35\u5063\udac6\u5d46\ua773\u29a5\ub01d\u3a47\ubca7\u06f9\u8929", 516351889, 906787343), a.d("\u9328\ueabe\u6062\ufe14\u75ba\uf372\u4d39\uc0ab\u5e83\ud436\u53ee\ua991\u274e\ube89", 1945965674, -1790868645)), vhz.TRASH, false);
        }
        catch (IOException iOException) {
            this.iib(wap.s(a.c(-1328573303, "\u94db\ued48\u6794\uf9ac\u7228\uf4cd\u4eda\uc72a\u597c\ud3c4\u5406\uae66\u20f4\ub911\u335e\ub5a2\u0fe5"), a.b("\u8a80\uf319\u7ddf\ue7b1\u6c67\uead3\u50f8\ud90d\u472d\ucd9f\u4a49\ub047\u3e9d\ua340\u2d70\uabf6\u11bd\u9e67\u04d7\u82fc\u0b05", -2079617400)), vhz.CLOSE, true);
        }
    }

    private static void ijf(tiq tiq2, int n) {
        int[] nArray = tiq.BOOSTS;
        int n2 = 0;
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != tiq2.mineBoost()) continue;
            n2 = i;
        }
        tiq2.set(a.c(1971236830, "\uafb9\ud60c\u5cd8\uc2a2\u493e\ucfc3\u759d\ufc6c\u622f\ue899"), nArray[(n2 + n + nArray.length) % nArray.length]);
        tiq2.save();
    }

    private static void ijg(tiq tiq2, String string, int n) {
        tiq2.set(string, n);
        tiq2.save();
    }

    private static void ijh(tiq tiq2, String string, double d) {
        tiq2.set(string, (double)Math.round(d * 100.0) / 100.0);
        tiq2.save();
    }

    private static void iji(tiq tiq2, double d) {
        double d2 = Math.max(2.6, Math.min(6.5, tiq2.standFar() + d));
        tiq2.set(a.c(-334764225, "\ue746\u9ef0\u1436\u8a48\u0195\u8733\u3d3d\ub484\u2adc\ua07e"), (double)Math.round(d2 * 10.0) / 10.0);
        tiq2.set(a.d("\u223b\u5b8d\ud14b\u4f35\uc4e8\u424e\uf840\u71f1\uefa5\u6510\ue2d0", 660026003, -313782064), (double)Math.round(Math.max(2.0, d2 - 1.2) * 10.0) / 10.0);
        tiq2.save();
    }

    private static void ijj(tiq tiq2, String string, String[] stringArray, String string2, int n) {
        int n2 = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].equals(string2)) continue;
            n2 = i;
        }
        tiq2.set(string, stringArray[(n2 + n + stringArray.length) % stringArray.length]);
        tiq2.save();
    }

    /*
     * Exception decompiling
     */
    private static String ijk(String var0) {
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

    /*
     * Exception decompiling
     */
    private static String ijl(String var0) {
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

    /*
     * Exception decompiling
     */
    private static String ijm(String var0) {
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

    private float ijn(DrawContext drawContext, String string, float f, float f2) {
        irr.SECTION.draw(drawContext, string.toUpperCase(Locale.ROOT), f, irr.SECTION.centerTop(f2 + 5.0f), iov.textMuted);
        return f2 + 12.0f;
    }

    private void ijo(DrawContext drawContext, String string, String string2, float f, float f2, float f3, boolean bl) {
        float f4 = 26.0f;
        uut.round(drawContext, f, f2, f3, f4, iov.r(6.0f), iov.field);
        irr.CARD_TITLE.draw(drawContext, string2, f + 7.0f, irr.CARD_TITLE.centerTop(f2 + 9.0f), bl ? iov.accent() : iov.text);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, f3 - 10.0f), f + 7.0f, irr.SMALL.centerTop(f2 + 19.5f), iov.textMuted);
    }

    private void ijp(DrawContext drawContext, String string, String string2, float f, float f2, float f3) {
        irr.SMALL.draw(drawContext, string, f, irr.SMALL.centerTop(f2 + 5.0f), iov.textDim);
        irr.SMALL.drawRight(drawContext, string2, f + f3, irr.SMALL.centerTop(f2 + 5.0f), iov.text);
    }

    private void ijq(DrawContext drawContext, float f, float f2, String string, boolean bl, float f3, float f4, float f5, Runnable runnable, String string2) {
        boolean bl2 = irr.inside(f, f2, f3, f4, f5, 16.0f);
        irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(string, f5 - 17.0f - 6.0f), f3, irr.LABEL.centerTop(f4 + 8.0f), bl2 ? iov.text : iov.textDim);
        irr.drawSwitch(drawContext, f3 + f5 - 17.0f, f4 + 3.25f, bl ? 1.0f : 0.0f, bl2 ? 1.0f : 0.0f);
        this.ihc.add(new ige(f3, f4, f5, 16.0f, runnable, null));
        if (bl2) {
            this.iho = string2;
        }
    }

    private void ijr(DrawContext drawContext, float f, float f2, String string, String string2, float f3, float f4, float f5, Runnable runnable, Runnable runnable2, String string3) {
        boolean bl = irr.inside(f, f2, f3, f4, f5, 16.0f);
        irr.LABEL.draw(drawContext, string, f3, irr.LABEL.centerTop(f4 + 8.0f), bl ? iov.text : iov.textDim);
        String string4 = string2 + a.b("\uf46c\u8ddd\u2714", 706212943);
        irr.drawChip(drawContext, string4, f3 + f5, f4 + 8.0f, iov.text, iov.stroke, bl ? 1.0f : 0.0f);
        this.ihc.add(new ige(f3, f4, f5, 16.0f, runnable, runnable2));
        if (bl) {
            this.iho = string3 + wap.s(a.c(719918621, "\u162a\u6f9b\ue5df\u7b39\uf0ee\u760d\ucc45\u45ba\udbea\u5147\ud6c0\u2cf2\ua22a\u3b9e\ub1c7\u373e\u8d3a\u22df\u9858\u1e4b\u97bf\uedec\u6357"), a.c(-926265589, "\u4f3b\u368a\ubcce\u2228\ua9ff\u2b71\u9127\u18d0\u82b3\u2836\u8fd1\u71bd\uff67\u66d1\uec85\u6a70"));
        }
    }

    private void ijs(DrawContext drawContext, float f, float f2, String string, String string2, float f3, float f4, float f5, Runnable runnable, Runnable runnable2, String string3) {
        irr.LABEL.draw(drawContext, string, f3, irr.LABEL.centerTop(f4 + 8.0f), iov.textDim);
        float f6 = 12.0f;
        float f7 = Math.max(22.0f, irr.VALUE.width(string2) + 6.0f);
        float f8 = f3 + f5 - f6;
        float f9 = f8 - f7;
        float f10 = f9 - f6;
        float f11 = f4 + (16.0f - f6) * 0.5f;
        boolean bl = irr.inside(f, f2, f10, f11, f6, f6);
        boolean bl2 = irr.inside(f, f2, f8, f11, f6, f6);
        uut.round(drawContext, f10, f11, f6, f6, iov.r(3.0f), bl ? iov.fieldHover : iov.field);
        uut.round(drawContext, f8, f11, f6, f6, iov.r(3.0f), bl2 ? iov.fieldHover : iov.field);
        irr.VALUE.drawCentered(drawContext, a.c(1068799768, "\u9734"), f10 + f6 * 0.5f, irr.VALUE.centerTop(f11 + f6 * 0.5f), bl ? iov.text : iov.textDim);
        vjf.draw(drawContext, vhz.PLUS, f8 + f6 * 0.5f, f11 + f6 * 0.5f, 6.0f, bl2 ? iov.text : iov.textDim);
        irr.VALUE.drawCentered(drawContext, string2, f9 + f7 * 0.5f, irr.VALUE.centerTop(f11 + f6 * 0.5f), iov.text);
        this.ihc.add(new ige(f10, f11, f6, f6, runnable, null));
        this.ihc.add(new ige(f8, f11, f6, f6, runnable2, null));
        if (irr.inside(f, f2, f3, f4, f5, 16.0f)) {
            this.iho = string3;
        }
    }

    private void ijt(DrawContext drawContext, float[] fArray, float f, float f2, float f3, float f4) {
        float f5;
        int n;
        uut.round(drawContext, f, f2, f3, f4, iov.r(4.0f), iov.field);
        if (fArray.length < 2) {
            return;
        }
        float f6 = Float.MAX_VALUE;
        float f7 = -3.4028235E38f;
        float[] fArray2 = fArray;
        int n2 = fArray2.length;
        for (n = 0; n < n2; ++n) {
            f5 = fArray2[n];
            if (!Float.isFinite(f5)) continue;
            f6 = Math.min(f6, f5);
            f7 = Math.max(f7, f5);
        }
        if (!(f7 > f6)) {
            f7 = f6 + 1.0f;
        }
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (n = 0; n < fArray.length; ++n) {
            f5 = f + 3.0f + (f3 - 6.0f) * (float)n / ((float)fArray.length - 1.0f);
            float f10 = f2 + 3.0f + (f4 - 6.0f) * (1.0f - (fArray[n] - f6) / (f7 - f6));
            if (n > 0) {
                uut.line(drawContext, f8, f9, f5, f10, 1.2f, iov.accent());
            }
            f8 = f5;
            f9 = f10;
        }
    }

    private void iju(DrawContext drawContext) {
        boolean bl;
        float f = this.igz + 360.0f - 8.0f - 5.0f;
        uut.rect(drawContext, this.igy + 12.0f, this.igz + 360.0f - 16.0f - 8.0f, 486.0f, 1.0f, iov.divider);
        boolean bl2 = this.ihe != null && this.ihe.aura();
        boolean bl3 = this.ihe != null && this.ihe.mine();
        boolean bl4 = bl = this.ihe != null && this.ihe.walk();
        String string = this.iho != null ? this.iho : (bl ? wap.s(a.b("\u41ac\u382a\ub2ff\u2c82\ua748\u21ef\u9bf8\u33bb\u8c56\u06b3\u8166\u7b04\uf5db\u6c6d\ue670\u4133\udace\u557e\ucff9\u49a9\uc045\uba3e\u34a6\uaf7d\u2946\ua398\u1a24\u9414\u0ed7\u8887\u032f\ufdc6\u77bf\uee5d\u6818\ue2a8\u5d74\ud745\u5198\uc850\u4239\u3cd2\ub6d4\u3132\uabf3\u258f\u9c5b\u16a1\u90ba\u0b77\u8509\u7f9d\uf66e\u7029\ueac9\u648e\udf28\u59b7\ud396\u4a5a\uc4f7\ubea7\u3945\ub35d\u2d9e\ua47b\u1e34\u98c8\u12da\u8d26\u07f7\u818d\u7853\uf2eb\u6cf4\ue749\u6117\udba2\u5262\ucc0f\u46dd\uc0df\ubb24\u35f2\uaf9d\u261b\ua0f1\u1ab6\u9553\u0f57\u89b3t\ufa0e\u74d8", -1931394656), a.b("\u545d\u2dcb\ua717\u3961\ub2cf\u3473\u8a4c\u220f\u9de2\u134d\u9491\u6e92\ue041\u7982\uf3d9\u752d\ucf6f\u44ab\uffaa\u5849\ud1df\uabba\u2508\ubec2\u3897\ub26d\u0bd4\u85c1\u1f39\u9967\u12b5\uec50\u661e\ufff4\u799f\uf318\u4cdc\uc6bb\u4069\ud9d3\u53cc\u2d33\ua358\u24c5\ube77\u301f\u89c8\u0715\u8545\u1e95\u94f8\u6a34\ue38e\u65af\uff24\u710c\ucacc\u4c11\uc660\u5fbc\ud10b\uab59\u2ca8\ua686\u3c2a\ub187\u0bd8\u8d59\u0706\u98bf\u126f\u941f\u6dc1\ue31f\u7d40\uf2ad\u74f8\uce43\u4791\ud9ee\u5356\ud16b\uaebb\u206e\uba66\u33cd\ub11c\u0f57\u80a2\u1af9\u9850\u15e3\uef9d\u6527\ufaf1\u7cdb\uf61e\u4863\uc1c0\u5b75", -450867154)) : (bl3 ? wap.s(a.d("\u765f\u0fd9\u850c\u1b71\u90bb\u161c\uac0b\u0448\ubba5\u3140\ub695\u4cf7\uc228\u5b9e\ud183\u76c0\ued3d\u628d\uf80a\u7e5a\uf7b6\u8dc5\u0352\u9884\u1ef0\u946a\u2dd7\ua3ea\u3934\ubf61\u34c1\uca0c\u405e\ud9fc\u5ff8\ud556\u6a88\ue0ec\u666b\uff83\u75ca\u0b21\u8127\u06d4\u9c13\u1275\uaba2\u2119\ua711\u3ccc\ub2f7\u4821\uc18e\u4788\udd22\u5365\ue8c0\u6e44\ue463\u7db3\uf303\u894e\u0ef3\u84e3\u1a23\u9398\u298f\uaf36\u2566\ubacf\u304b\ub663\u4faa\uc501\u5b07\ud0a1\u56e0\uec5c\u6588", 1727698663, -5054299), a.b("\u08cb\u715d\ufb81\u65f7\uee59\u68e5\ud6da\u7e99\uc174\u4fdb\uc807\u3204\ubcd7\u2514\uaf4f\u29bb\u93f9\u183d\ua33c\u04df\u8d49\uf72c\u799e\ue254\u6409\ueefc\u5748\ud912\u43ae\uc5f1\u4a41\ub4f4\u3ec4\ua74f\u257e\uaba8\u147a\u9e77\u1cba\u8169\u0b3f\u71a5\uffed\u7859\ue28c\u6cf1\ud527\u5feb\ud9a0\u4611\uc86e\u36a5\ubf18\u3943\ua7aa\u2de1\u9624\u10f6\u9a84\u032f\u8de8\uf7bd\u7422\ufa69\u64ac\ued11\u574b\ud1cf\u5b9b\uc049\u4e82\ucceb\u312e\ubb95\u25cc\uaa27\u2815\u92df\u1b06\u857b\u0fc4\u8991", 260246670)) : (bl2 ? wap.s(a.b("\u71cc\u084a\u829f\u1ce2\u9728\u118f\uab98\u03db\ubc36\u36d3\ub106\u4b64\uc5bb\u5c0d\ud610\u7153\ueaae\u6514\uff85\u79d1\uf026\u8a5a\u04dd\u9f0b\u1967\u93f9\u2a44\ua470\u3eb4\ub8f6\u3352\ucd88\u479e\ude3b\u5875\ud2ce\u6d11\ue72b\u61b6\uf80c\u7257\u0cb5\u86b4\u0144\u9bd2\u15f7\uac31\u2693\ua0c9\u3b1a\ub578\u4ffd\uc603\u4048\udae8\u54f5\uef43\u6996\ue3f6\u7a3b\uf487\u8ed7\u097b\u8331\u1dad\u9406\u2e51\ua8a4\u22f6\ubd4a\u378a\ub1e0\u4822\uc29e\u5c94\ud735\u5177\uebd1\u6250\ufc60\u76b6\uf0f6\u8b5f\u05dd\u9fd2\u167b\u90c7\u2a99\ua51f", 1758884295), a.b("\ub91d\uc08b\u4a57\ud421\u5f8f\ud933\u670c\ucf4f\u70a2\ufe0d\u79d1\u83d2\u0d01\u94c2\u1e99\u986d\u222f\ua9eb\u12ea\ub509\u3c95\u46e6\uc850\u5381\ud5d3\u5f36\ue682\u68c0\uf278\u7427\ufb97\u0522\u8f12\u1699\u90c9\u1a76\ua1ce\u2fa5\ua97c\u30cb\uba96\uc418\u4e39\ucd91\u5324\udd2f\u64fe\uea55\u687a\uf3a4\u7dac\u8777\u0ec2\u8c8f\u121d\u982d\u27f4\ua156\u2b2b\ub28d\u3c38\u421c\uc5f4\u4bc4\ud50f\u5cc5\ue69c\u6018\uea4c\u758d\uff52\u7d3d\u80fd\u0a4d\u9000\u1fef\u99c7\u2378\uaad8\u30b5\uba02\u3c2b\u4797\uc949\u5347", 1073986911)) : wap.s(a.c(534676034, "\u8244\ufbc2\u7117\uef6a\u64a0\ue207\u5810\uf053\u4fbe\uc55b\u428e\ub8ec\u3633\uaf85\u2598\u82db\u1926\u96a2\u0c17\u8a50\u03ec\u79b3\uf76f\u6c9f\ueae2\u6026\ud9cc\u57dc\ucd23\u4b76\uc0c1\u3e17\ub451\u2de7\uabe0\u214d\u9e93\u14f7\u9270\u0b84\u81d0\uff2b\u7579\uf2c9\u685a\ue662\u5fb6\ud549\u5347\uc8d7\u46ec\ubc3c\u3596\ub393\u2929\ua762\u1c8e\u9a13\u1069\u89bc\u0718\u7d55\ufaad\u70fd\uee7a\u67c7\uddd9\u5b2c\ud161\u4ed0\uc415\u4272\ubbfe\u310e\uaf4e\u24a8\ua2ba\u184f\u918a\u0fe6\u8536\u0367\u78c1\uf611"), a.c(-2089571789, "\uae4e\ud7d8\u5d04\uc372\u48dc\uce60\u705f\ud81c\u67f1\ue95e\u6e82\u9481\u1a52\u8391\u09ca\u8f3e\u357c\ubeb8\u05b9\ua25a\u2fb5\u559d\udb50\u4080\uc6fa\u4c5c\uf594\u7bcc\ue137\u6764\ueca5\u127a\u9c57\u05a8\u87f8\u0d2d\ub285\u388e\ube5e\u27e1\ua9d1\ud342\u596d\uded9\u4479\uca7e\u73a9\ufd06\u7f54\ue488\u6af9\u902f\u1999\u9fc9\u0532\u8b66\u30d4\ub21c\u3863\ua5a8\u2b1b\u5136\ud6b9\u5c96\uc227\u4b9d\uf5db\u773d\ufd6d\u62d6\ue801\u6e73\u97d6\u1d18\u8348\u08bc\u8e94\u3428\ub997\u2385\ua93d\u2f68\u54ab\uda04\u4071\ucdb0\u4b0f\uf541\u7ac1\ue0ee\u665f\uef82\u1580\u9b2c\u0487\u86c8\u0c7b\ub209\u3bae\ua112\u274f\uacbc\ud291\u582c\uc1f0\u478f")))));
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string, 486.0f), this.igy + 12.0f, irr.SMALL.centerTop(f), this.iho != null ? iov.text : iov.textMuted);
    }

    private static String ijv(long l) {
        return l / 60L + a.b("\u9f5e", -1501126811) + String.format(Locale.ROOT, a.c(1057187625, "\u6708\u1eac\u947d\u0a5a"), l % 60L);
    }

    private static String ijw(double d) {
        return String.format(Locale.ROOT, a.d("\u46b0\u3f0a\ub5c6\u2be0", -393168842, 1176698535), d);
    }

    private static String ijx(double d) {
        return String.format(Locale.ROOT, a.d("\ua247\udbfd\u5133\ucf17", -407176391, 37443935), d);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (this.ihn) {
            return true;
        }
        if (!irr.inside(f, f2, this.igy, this.igz, 510.0f, 360.0f)) {
            this.close();
            return true;
        }
        if (this.igx.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        hlc2.focus(null);
        for (int i = this.ihc.size() - 1; i >= 0; --i) {
            Runnable runnable;
            ige ige2 = this.ihc.get(i);
            if (!irr.inside(f, f2, ige2.x(), ige2.y(), ige2.w(), ige2.h())) continue;
            Runnable runnable2 = n == 1 ? ige2.right() : (runnable = n == 0 ? ige2.left() : null);
            if (runnable == null) continue;
            runnable.run();
            return true;
        }
        return true;
    }

    @Override
    void scrolled(double d) {
        if (this.ihg && this.ihj > this.igy + 12.0f + 146.0f + 10.0f) {
            this.ihi = Math.max(0.0f, this.ihi - (float)d * 22.0f);
            return;
        }
        this.ihf = Math.max(0.0f, Math.min(this.iih(), this.ihf - (float)d * 34.0f));
    }

    @Override
    boolean keyPressed(hlc hlc2, int n, int n2) {
        if (n == 256) {
            if (hlc2.focusedField() == this.igx && !this.igx.text.isEmpty()) {
                this.igx.setText("");
            } else {
                this.close();
            }
            return true;
        }
        if (hlc2.focusedField() == this.igx) {
            this.igx.keyPressed(hlc2, n, n2);
            return true;
        }
        return true;
    }

    private static /* synthetic */ void lambda$trainerJob$33(tiq tiq2) {
        lfa.activate(tiq2);
    }

    private /* synthetic */ void lambda$trainerJob$32(tiq tiq2) {
        tcz.train(tiq2);
        this.ihs = null;
    }

    private /* synthetic */ void lambda$list$2(tiq tiq2) {
        this.iiw(tiq2);
        if (tiq2.aura()) {
            kwf.useStudio(tiq2);
        } else if (tiq2.walk()) {
            lfa.useForWalk(tiq2);
        } else if (tiq2.mine()) {
            lfa.useForMine(tiq2);
        } else {
            lfa.activate(tiq2);
        }
    }

    private /* synthetic */ void lambda$list$1(tiq tiq2) {
        this.iiw(tiq2);
    }

    private /* synthetic */ void lambda$list$0(tiq tiq2) {
        this.iij(tiq2);
    }

    private static /* synthetic */ int agm(int n, int n2) {
        return n - n2 ^ 0xFF26975C;
    }
}

