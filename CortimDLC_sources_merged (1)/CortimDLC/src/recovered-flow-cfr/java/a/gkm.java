/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gkj;
import a.kfe;
import a.kgj;
import a.ldr;
import a.tbm;
import a.tbp;
import a.tcz;
import a.tiq;
import a.tkx;
import a.vxr;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

final class gkm {
    private static final int gkn = Integer.getInteger(a.d("\ufb7a\u82c1\u0811\u9678\u1dea\u9b47\u2154\ua8ae\u36e1\ubc57\u3b99\uc1a9\u4f22\ud684\u5cd1", 250015868, -1923871889), 2400);
    private static final int gko = 1600;
    private static final boolean gkp = a.d("\udba7", 1013606485, 1609216962).equals(System.getenv(a.b("\ufa6b\u83d0\u0900\u9769\u1cdb\u9a07\u2045\ua9bf\u37f0\ubd46\u3a88\uc087", 1281882657)));
    private static final boolean gkq = a.b("\u203e", -2129518578).equals(System.getenv(a.d("\u99c1\ue07a\u6aaa\uf4c3\u7f71\uf9ad\u43ef\uca15\u545a\udeec\u5922\ua343\u2d9c\ub435\u3e6b\ub89a\u02db\u8d03", 1993108701, -1415973560)));
    private static final boolean gkr = a.b("\u5001", 1338527793).equals(System.getenv(a.c(246098352, "\u29e6\u505d\uda8d\u44e4\ucf56\u498a\uf3c8\u7a32\ue47d\u6ecb\ue905\u1364\u9dae\u041c\u8e5d\u08ba")));
    private static final Random gks = new Random(11L);
    private static Field gkt;
    private static Field gku;
    private static int gkv;
    private static int gkw;
    private static tiq gkx;
    private static final gkj gky;
    private static final gkj gkz;
    private static final List<String> gla;
    private static final Map<String, Integer> glb;
    private static tkx glc;
    private static int gld;
    private static double gle;
    private static double glf;
    private static final LinkedList<double[]> glg;
    private static double glh;
    private static double gli;
    private static int glj;
    private static int glk;
    private static double gll;
    private static double glm;
    private static double gln;
    private static double glo;
    private static int glp;
    private static float glq;
    private static float glr;
    private static boolean gls;
    private static int glt;
    private static int glu;
    private static int glv;
    private static boolean glw;
    private static /* synthetic */ int glx;
    private static /* synthetic */ boolean gly;

    private gkm() {
    }

    /*
     * Exception decompiling
     */
    static boolean tick(MinecraftClient var0, int var1_1) throws Exception {
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

    private static kgj glz() {
        return (kgj)Flow.getInstance().getModuleManager().getByName(a.d("\u158c\u6c15\ue6c2\u789f\uf37a\u75cb\ucf82\u4669\ud831", 2136601038, -1797331958));
    }

    private static void gma(int n) {
        ++gkv;
        gkw = n;
    }

    private static void gmb(MinecraftClient minecraftClient) {
        minecraftClient.options.pauseOnLostFocus = false;
        gkm.gmj(minecraftClient, a.c(1377092853, "\uc483\ubd34\u37eb\ua992\u224d\ua4fe\u1ea6\u9756\u094c\u83ae\u047b\ufe0d\u70de\ue970\u633c\ue5da\u5f98"));
        gkm.gmj(minecraftClient, a.c(624971756, "\u4f95\u3639\ubcee\u2297\ua905\u2fe7\u95a2\u1c42\u8249\u08b6\u8f64\u7515\ufbc3"));
        gkm.gmj(minecraftClient, a.d("\u9fe8\ue65f\u6c80\uf2f9\u7939\uff8f\u45c5\ucc3d\u5227\ud8d2\u5f0a\ua550\u2ba2\ub20b\u384d\ubeb9\u04f8\u8b26\u1189\u97ef\u1e22\u6469\uead5\u710d\uf737\u7da0\uc414\u4a48\ud0a0\u56e7", 2059195844, -1422243243));
        gkm.gmj(minecraftClient, a.b("\u4265\u3bd2\ub10d\u2f74\ua4b4\u2202\u9848\u11b0\u8faa\u055f\u8287\u78d4\uf621\u6f9d\ue5ff\u632d\ud973\u56b4\ucc1e\u4a48\uc3b8\ub9e0\u3714\uac83\u2afb\ua027\u198b\u97cc", 886587934));
        gkm.gmj(minecraftClient, a.b("\ufb5a\u82e8\u083b\u9649\u1d98\u9b3e\u2139\ua88f\u36de\ubc70\u3bb0\uc184\u4f33\ud6b1\u5cb1\uda12\u604a\uef8d\u7524\uf36f\u7a9f\u00db\u8e67\u15bb\u93c2\u1956\ua0ac\u2efa\ub405\u325b\ub9ef\u4739\ucd6b\u548b\ud29d\u583e\ue7ee\u6d9f\ueb59\u72bc\uf8e5\u8613\u0c50", -712312044));
        gkm.gmj(minecraftClient, a.c(-2136931082, "\u04b8\u7d0a\uf7d9\u69ab\ue27a\u64dc\udedb\u576d\uc93c\u4392\uc452\u3e66\ub0d1\u2953\ua353\u25f1\u9fac\u1068\u8ada\u0c8c\u8568\uff2c\u7182\uea55\u6c2b\ue6b4\u5f4e\ud118\u4be7\ucdb9\u460d\ub8db\u3289\uab69\u2d7f\ua7dc\u180c\u927d\u14bb\u8d5e\u0707\u79f1\uf3b2"));
        gkm.gmj(minecraftClient, a.d("\uc494\ubd2a\u37fc\ua98d\u2216\ua4f9\u1ef9\u9714\u094e\u83eb\u0466\ufe44\u708f\ue92f\u6322\ue580\u5fd3\ud007\u4aa0\uccaf\u4517\u3f43\ub1e4\u2a6b\uac47\u268a\u9f28\u1127\u8b9f\u0dcb\u866c\u78f0\uf2bb\u6b4d\ued15\u67a2\ud864\u5206\ud4d2\u4d71\uc760\ub9d8\u3395\ub426\u2ef1\ua09b\u1954\u93d2\u15b1\u8e67\u000f\ufadf\u7363", 1895791654, -1546536735));
        gkm.gmj(minecraftClient, a.c(2034184372, "\u30fb\u4945\uc393\u5de2\ud679\u5096\uea96\u637b\ufd21\u7784\uf009\u0a26\u84af\u1d4d\u9702\u11f6\uabad\u2422\ubede\u388a\ub169\ucb66\u459e\ude5a\u587b\ud2e5\u6b53\ue516\u7fac\uf9f9\u724d\u8c97\u06de\u9f3e\u197e\u93c8\u2c0d\ua632\u20ba\ub903\u3347"));
        gkm.gmj(minecraftClient, a.c(1038854227, "\ua82b\ud194\u5b58\uc53a\u4ea8\uc879\u7219\ufbbb\u65a9\uef1c\u68c8\u92b2\u1c63\u85c3\u0f83\u8975\u3328\ubcb7\u265a\ua006\u29f9\u53a4\udd15\u46c5\uc0b0\u4a5a\uf3c5\u7d90\ue77f\u6133\uea96"));
        gkt = vxr.find(Mouse.class, a.d("\u8b9e\uf224\u78e6\ue6cd\u6d59\uebec\u51b8\ud842\u461b\uccbb\u4b7b\ub10d\u3fc8\ua623\u2c3d\uaac3\u1081\u9f42\u05f1\u838c\u0a17\u7044\ufef4", -1166656787, 1589227786), a.d("\u8796\ufe28\u74f7\uea8f\u6150\ue7da\u5de7\ud410\u4a40\uc0fa", -448739739, 1283867039), a.c(-1679076026, "\u551d"));
        gku = vxr.find(MinecraftClient.class, a.c(-347873512, "\udf61\ua6db\u2c19\ub232\u39a6\ubf13\u0547\u8cbd\u12e4\u9844\u1f84\ue5f2\u6b37\uf2dc\u78c2\ufe3c\u447e\ucbbd\u510e\ud773\u5ee8\u24bb\uaa09"), a.d("\u5c15\u25ab\uaf74\u310c\ubad3\u3c59\u8664\u0f92\u91c2\u1b7f", 1304887905, 1801215512), a.b("\u095a", -2046031615));
        long l2 = minecraftClient.getWindow().getHandle();
        GLFW.glfwSetCursorPosCallback((long)l2, (l, d, d2) -> {});
        GLFW.glfwSetMouseButtonCallback((long)l2, (l, n, n2, n3) -> {});
        GLFW.glfwSetScrollCallback((long)l2, (l, d, d2) -> {});
        minecraftClient.player.getInventory().setSelectedSlot(0);
        for (String string : new String[]{a.d("\ua805\ud192\u5b5a\uc525\u4ef2\uc841\u7205\ufbc4\u65b6\uef1c", 2048177307, -1097982784), a.c(-2135397586, "\u6b66\u12ff\u9828\u0675\u8d90\u0b21\ub168\u3883\ua6db"), a.d("\u93c8\uea4d\u609f\ufef5\u7500\uf39d\u49cc\uc03b", -1878356177, 712907950), a.b("\ufcc8\u854d\u0f9f\u91f5\u1a1e\u9c8b\u26ce\uaf2e", 1359150209)}) {
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
            if (kfe2 == null) continue;
            kfe2.setEnabled(false);
        }
    }

    private static void gmc(MinecraftClient minecraftClient) throws Exception {
        if (gkt != null && minecraftClient.currentScreen == null) {
            gkt.setBoolean(minecraftClient.mouse, true);
        }
        if (gku != null) {
            gku.setBoolean(minecraftClient, true);
        }
    }

    /*
     * Exception decompiling
     */
    private static void gmd() {
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

    private static void gme(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d;
        tkx tkx2;
        List<tkx> list = tcz.stands();
        if (list.isEmpty()) {
            return;
        }
        if (glc == null || glc.isRemoved() || --gld <= 0) {
            tkx2 = list.get(gks.nextInt(list.size()));
            if (tkx2 != glc || glc == null) {
                glc = tkx2;
                glg.clear();
                glk = glj;
                gle = gks.nextGaussian() * 0.3;
                glf = 0.6 + gks.nextDouble() * 0.28;
                gky.episode();
            }
            gld = 40 + gks.nextInt(70);
        }
        tkx2 = clientPlayerEntity.getEyePos();
        Box box = glc.getBoundingBox();
        tbm tbm2 = new tbm();
        if (!tbp.aim(((Vec3d)tkx2).x, ((Vec3d)tkx2).y, ((Vec3d)tkx2).z, (box.minX + box.maxX) * 0.5, box.minY, (box.minZ + box.maxZ) * 0.5, (box.maxX - box.minX) * 0.5, box.maxY - box.minY, gle, glf, tbm2)) {
            return;
        }
        glg.addLast(new double[]{tbm2.yaw, tbm2.pitch});
        if (glg.size() > 6) {
            glg.removeFirst();
        }
        double[] dArray = glg.size() >= 4 ? glg.get(glg.size() - 4) : glg.getFirst();
        double[] dArray2 = glg.size() >= 5 ? glg.get(glg.size() - 5) : dArray;
        double d2 = tbp.wrap(dArray[0] - dArray2[0]);
        double d3 = dArray[1] - dArray2[1];
        double d4 = tbp.wrap(dArray[0] + d2 * 3.0 - (double)clientPlayerEntity.getYaw());
        double d5 = dArray[1] + d3 * 3.0 - (double)clientPlayerEntity.getPitch();
        double d6 = 0.0;
        double d7 = 0.0;
        if (glk < glj) {
            d = gkm.gmi((double)glk / (double)glj);
            var22_15 = gkm.gmi((double)(glk + 1) / (double)glj);
            d6 += glh * (var22_15 - d);
            d7 += gli * (var22_15 - d);
            ++glk;
        } else {
            d = Math.hypot(d4, d5);
            if (d > Math.max(0.5, tbm2.bw * 0.55)) {
                var22_15 = 1.02 + gks.nextGaussian() * 0.08;
                glh = d4 * var22_15;
                gli = d5 * var22_15 * 0.9;
                glj = Math.max(2, (int)Math.round(2.0 + 1.5 * Math.log(1.0 + d / 2.0) / Math.log(2.0)));
                glk = 0;
                double d8 = gkm.gmi(1.0 / (double)glj);
                d6 += glh * d8;
                d7 += gli * d8;
                glk = 1;
            }
        }
        d6 += d2 * 0.8;
        d7 += d3 * 0.6;
        gll = 0.6 * gll + gks.nextGaussian() * 0.07;
        glm = 0.6 * glm + gks.nextGaussian() * 0.04;
        d = tcz.unit(minecraftClient);
        long l = (long)(gln += (d6 += gll) / d);
        long l2 = (long)(glo += (d7 += glm) / d);
        gln -= (double)l;
        glo -= (double)l2;
        float f = clientPlayerEntity.getYaw();
        float f2 = clientPlayerEntity.getPitch();
        clientPlayerEntity.changeLookDirection((double)l * d / 0.15, (double)l2 * d / 0.15);
        double d9 = clientPlayerEntity.getYaw() - f;
        double d10 = clientPlayerEntity.getPitch() - f2;
        boolean bl = gkm.gmg(clientPlayerEntity, box);
        double d11 = tbp.wrap((double)clientPlayerEntity.getYaw() - tbm2.yaw);
        gky.sample(d9, d10, bl, d11, tbm2.la, tbm2.ra, tbm2.bw, tbp.wrap(dArray[0] - dArray2[0]));
        boolean bl2 = false;
        for (tkx tkx3 : list) {
            bl2 |= gkm.gmg(clientPlayerEntity, tkx3.getBoundingBox());
        }
        if (clientPlayerEntity.getAttackCooldownProgress(0.5f) >= 0.9f && (bl && gks.nextDouble() < 0.75 || bl2 && gks.nextDouble() < 0.3) || gks.nextDouble() < 0.02) {
            gkm.gmh(minecraftClient);
        }
    }

    private static void gmf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d;
        double d2;
        float f = clientPlayerEntity.getYaw();
        float f2 = clientPlayerEntity.getPitch();
        if (gls) {
            d2 = f - glq;
            d = f2 - glr;
            Entity entity = gkp && !gkr ? gkm.glz().pilotTarget() : ldr.get().target();
            double d3 = tcz.unit(minecraftClient);
            double d4 = d2 / d3;
            ++gkm.gkz.gridTicks;
            if (Math.abs(d4 - Math.rint(d4)) > 0.01 && Math.abs(d2) > 1.0E-4) {
                ++gkm.gkz.offGrid;
            }
            if (entity != null) {
                Box box = entity.getBoundingBox();
                Vec3d vec3d = clientPlayerEntity.getEyePos();
                tbm tbm2 = new tbm();
                if (tbp.aim(vec3d.x, vec3d.y, vec3d.z, (box.minX + box.maxX) * 0.5, box.minY, (box.minZ + box.maxZ) * 0.5, (box.maxX - box.minX) * 0.5, box.maxY - box.minY, 0.0, 0.7, tbm2)) {
                    boolean bl = gkm.gmg(clientPlayerEntity, box);
                    gkz.sample(d2, d, bl, tbp.wrap((double)f - tbm2.yaw), tbm2.la, tbm2.ra, tbm2.bw, 0.0);
                    gla.add(String.format(Locale.ROOT, a.d("\ud4e2\uad12\u2789\ub9f1\u322d\ub486\u0e87\u873c\u196a\u93d0\u1419\uee3a\u60a7\uf91f\u7347\uf5ab\u4fb1\uc02a\u5a90\udcca\u5520\u2f24\ua1dd\u3a05\ubc3b", -683513179, 510967419), gla.size(), d2, d, tbp.wrap(tbm2.yaw - (double)f), tbm2.pitch - (double)f2, bl ? 1 : 0));
                }
            }
        }
        if (--glp <= 0) {
            glp = 50 + gks.nextInt(60);
            d2 = (double)(gks.nextBoolean() ? 1 : -1) * (35.0 + gks.nextDouble() * 70.0);
            d = tcz.unit(minecraftClient);
            long l = Math.round(d2 / d);
            clientPlayerEntity.changeLookDirection((double)l * d / 0.15, 0.0);
            gkz.episode();
        } else if (gkq) {
            gll = 0.85 * gll + gks.nextGaussian() * 0.9;
            glm = 0.85 * glm + gks.nextGaussian() * 0.35;
            if (gks.nextDouble() < 0.04) {
                gll += (double)(gks.nextBoolean() ? 1 : -1) * (4.0 + gks.nextDouble() * 4.0);
            }
            d2 = tcz.unit(minecraftClient);
            long l = (long)(gln += gll / d2);
            long l2 = (long)(glo += glm / d2);
            gln -= (double)l;
            glo -= (double)l2;
            clientPlayerEntity.changeLookDirection((double)l * d2 / 0.15, (double)l2 * d2 / 0.15);
        }
        glq = clientPlayerEntity.getYaw();
        glr = clientPlayerEntity.getPitch();
        gls = true;
        ++glt;
        Entity entity = tcz.stands().iterator();
        while (entity.hasNext()) {
            tkx tkx2 = entity.next();
            if (!gkm.gmg(clientPlayerEntity, tkx2.getBoundingBox())) continue;
            ++glu;
            break;
        }
        Entity entity2 = entity = gkp && !gkr ? gkm.glz().pilotTarget() : ldr.get().target();
        if (entity == null && glw) {
            ++glv;
        }
        boolean bl = glw = entity != null;
        if (clientPlayerEntity.getAttackCooldownProgress(0.5f) >= 0.9f && minecraftClient.targetedEntity instanceof tkx) {
            gkm.gmh(minecraftClient);
        }
    }

    private static boolean gmg(ClientPlayerEntity clientPlayerEntity, Box box) {
        Vec3d vec3d;
        Vec3d vec3d2 = clientPlayerEntity.getEyePos();
        return box.raycast(vec3d2, vec3d = vec3d2.add(clientPlayerEntity.getRotationVec(1.0f).multiply(6.0))).isPresent() || box.contains(vec3d2);
    }

    private static void gmh(MinecraftClient minecraftClient) {
        KeyBinding.onKeyPressed((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.attackKey));
    }

    private static double gmi(double d) {
        d = Math.max(0.0, Math.min(1.0, d));
        return d * d * d * (10.0 - 15.0 * d + 6.0 * d * d);
    }

    private static void gmj(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void gmk(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u64ab\u1d0c\u97d6\u09ad\u823c\u04d9\ube9b\u377c\ua924\u23c1", -367958830) + string);
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.c(1175503320, "\uc1b8\ub803\u32d3\uacba\u2728\ua186") + string + a.d("\u08d5\u713a\ufbf7\u658f", -475594086, -2036463003)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        gky = new gkj(a.c(1704126509, "\ue840\u91ec\u1b27\u855a\u0e82"));
        gkz = new gkj(a.c(-1796949976, "\ub840\uc1f3\u4b2b\ud55b\u5e85"));
        gla = new ArrayList<String>();
        glb = new TreeMap<String, Integer>();
        glg = new LinkedList();
    }

    private static /* synthetic */ int us(int n, int n2) {
        return n - n2 + -679524899;
    }

    private static /* synthetic */ int ut(int n, int n2) {
        return gkm.us(n, n2) ^ 0x73ABB55C;
    }

    private static /* synthetic */ int uu(int n, int n2) {
        return gkm.ut(n, n2) ^ 0x21925D57;
    }
}

