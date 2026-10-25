/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.kfe;
import a.kwf;
import a.syq;
import a.tbm;
import a.tbp;
import a.tcz;
import a.tiq;
import a.tmh;
import a.vxr;
import a.vzz;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

final class fbw {
    private static final String fbx = System.getenv().getOrDefault(a.b("\ud54d\uacf6\u2626\ub84f\u33fd\ub521\u0f6c\u8689\u18d1\u9273\u15be\uefc0\u6115\uf8b9\u72e3\uf41d\u4e57\uc18f", 1381225753), a.d("\u292d\u50a8\uda7c\u441e\ucffc\u497c\uf339\u7acf", 1538060898, -1509238010));
    private static final boolean fby = a.b("\u1bea\u621a", 419896216).equals(System.getenv(a.d("\u98d6\ue16d\u6bbd\uf5d4\u7e66\uf8ba\u42f7\ucb12\u554a\udfe8\u5825\ua249\u2c8e\ub52c\u3f77\ub981", -1720076646, 1120742938)));
    private static final int fbz = 2400;
    private static final Field fca = vxr.find(ClientPlayerEntity.class, a.d("\u7c4d\u05f7\u8f35\u111e\u9a8a\u1c3f\ua66b\u2f91\ub1c8\u3b68\ubca8\u46de\uc81b\u51f0\udbee\u5d10\ue752\u6891\uf222\u745f\ufdc0\u8792\u0923", -924784086, 1023120926), a.b("\uef3f\u9681\u1c5e\u8226\u09f9\u8f73\u354c\ubcb7\u22e5\ua851", 1219161939), a.b("\u07d8", -245168225));
    private static final Field fcb = vxr.find(ClientPlayerEntity.class, a.d("\u928d\ueb37\u61f5\uffde\u744a\uf2ff\u48ab\uc151\u5f08\ud5a8\u5268\ua81e\u26db\ubf30\u352e\ub3d0\u0992\u8651\u1ce2\u9a9f\u1300\u6952\ue7e3", -1991564925, 1375777655), a.b("\ub77b\ucec5\u441a\uda62\u51bd\ud737\u6d08\ue4f3\u7aa7\uf011", 159364887), a.d("\uf1b3", -1911433442, 1338189546));
    private static final Random fcc = new Random(7L);
    private static final Set<Integer> fcd = new HashSet<Integer>();
    private static final List<double[]> fce = new ArrayList<double[]>();
    private static final List<double[]> fcf = new ArrayList<double[]>();
    private static final List<Double> fcg = new ArrayList<Double>();
    private static final List<Double> fch = new ArrayList<Double>();
    private static Field fci;
    private static Field fcj;
    private static float fck;
    private static float fcl;
    private static int fcm;
    private static int fcn;
    private static int fco;
    private static int fcp;
    private static int fcq;
    private static final tbm fcr;
    private static double fcs;
    private static int fct;
    private static double fcu;
    private static double fcv;
    private static int fcw;
    private static Entity fcx;
    private static int fcy;
    private static final List<Integer> fcz;
    private static int fda;
    private static /* synthetic */ long fdb;
    private static /* synthetic */ boolean fdc;

    private fbw() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null) {
            return false;
        }
        if (n == 1) {
            fbw.fdd(minecraftClient);
            return false;
        }
        fbw.fdn(minecraftClient);
        if (n < 60) {
            return false;
        }
        if (fcm < 0) {
            fbw.fde(minecraftClient);
            fcm = n;
            return false;
        }
        int n2 = n - fcm;
        fbw.fdf(minecraftClient, clientPlayerEntity);
        fbw.fdh(minecraftClient, clientPlayerEntity);
        if (n2 >= 2400) {
            fbw.fdm();
            tcz.stop();
            vzz.simulated = null;
            return true;
        }
        return false;
    }

    private static void fdd(MinecraftClient minecraftClient) {
        fbw.fdo(minecraftClient, a.b("\u6063\u19d4\u930b\u0d72\u86b2\u0004\uba4e\u33b6\uadac\u2759\ua081\u5ad2\ud427\u4d9b\uc7f9\u412b\ufb75\u74b2\uee18\u684e\ue1be\u9be6\u1512\u8e85\u08fd\u8221\u3b8d\ub5ca", 641359896));
        fbw.fdo(minecraftClient, a.d("\ud464\uadd6\u2705\ub977\u32a6\ub400\u0e07\u87b1\u19e0\u934e\u148e\ueeba\u600d\uf98f\u738f\uf52c\u4f74\uc0b3\u5a1a\udc51\u55a1\u2fe5\ua159\u3a85\ubcfc\u3668\u8f92\u01c4\u9b3b\u1d65\u96d1\u6807\ue255\u7bb5\ufda3\u7700\uc8d0\u42a1\uc467\u5d82\ud7db\ua92d\u236e", 193277433, 1505425875));
        fbw.fdo(minecraftClient, a.c(-1590780541, "\u9dcd\ue47f\u6eac\uf0de\u7b0f\ufda9\u47ae\uce18\u5049\udae7\u5d27\ua713\u29a4\ub026\u3a26\ubc84\u06d9\u891d\u13af\u95f9\u1c1d\u6659\ue8f7\u7320\uf55e\u7fc1\uc63b\u486d\ud292\u54cc\udf78\u21ae\uabfc\u321c\ub40a\u3ea9\u8179\u0b08\u8dce\u142b\u9e72\ue084\u6ac7"));
        fbw.fdo(minecraftClient, a.d("{\u79c5\uf313\u6d62\ue6f9\u6016\uda16\u53fb\ucda1\u4704\uc089\u3aab\ub460\u2dc0\ua7cd\u216f\u9b3c\u14e8\u8e4f\u0840\u81f8\ufbac\u750b\uee84\u68a8\ue265\u5bc7\ud5c8\u4f70\uc924\u4283\ubc1f\u3654\uafa2\u29fa\ua34d\u1c8b\u96e9\u103d\u899e\u038f\u7d37\uf77a\u70c9\uea1e\u6474\uddbb\u573d\ud15e\u4a88\uc4e0\u3e30\ub78c", -1913349282, 830380918));
        fbw.fdo(minecraftClient, a.c(1472904838, "\ubec9\uc777\u4da1\ud3d0\u584b\udea4\u64a4\ued49\u7313\uf9b6\u7e3b\u8414\u0a9d\u937f\u1930\u9fc4\u259f\uaa10\u30ec\ub6b8\u3f5b\u4554\ucbac\u5068\ud649\u5cd7\ue561\u6b24\uf19e\u77cb\ufc7f\u02a5\u88ec\u110c\u974c\u1dfa\ua23f\u2800\uae88\u3731\ubd75"));
        fbw.fdo(minecraftClient, a.c(1132876923, "\u5403\u2dbc\ua770\u3912\ub280\u3451\u8e31\u0793\u9981\u1334\u94e0\u6e9a\ue04b\u79eb\uf3ab\u755d\ucf00\u409f\uda72\u5c2e\ud5d1\uaf8c\u213d\ubaed\u3c98\ub672\u0fed\u81b8\u1b57\u9d1b\u16be"));
        fci = vxr.find(Mouse.class, a.c(1301380534, "\u7dcf\u0475\u8eb7\u109c\u9b08\u1dbd\ua7e9\u2e13\ub04a\u3aea\ubd2a\u475c\uc999\u5072\uda6c\u5c92\ue6d0\u6913\uf3a0\u75dd\ufc46\u8615\u08a5"), a.b("\u748d\u0d33\u87ec\u1994\u924b\u14c1\uaefc\u270b\ub95b\u33e1", -1974373151), a.d("\uf2ad", -2038234296, -1778847298));
        fcj = vxr.find(MinecraftClient.class, a.c(68073431, "\ub7ae\uce14\u44d6\udafd\u5169\ud7dc\u6d88\ue472\u7a2b\uf08b\u774b\u8d3d\u03f8\u9a13\u100d\u96f3\u2cb1\ua372\u39c1\ubfbc\u3627\u4c74\uc2c6"), a.d("\u448d\u3d33\ub7ec\u2994\ua24b\u24c1\u9efc\u170a\u895a\u03e7", -789126292, -591812723), a.d("\u3798", -1857656419, 1284333150));
        long l2 = minecraftClient.getWindow().getHandle();
        GLFW.glfwSetCursorPosCallback((long)l2, (l, d, d2) -> {});
        GLFW.glfwSetMouseButtonCallback((long)l2, (l, n, n2, n3) -> {});
        minecraftClient.player.getInventory().setSelectedSlot(0);
        for (String string : new String[]{a.d("\u4461\u3df6\ub73e\u2941\ua296\u2425\u9e61\u17a0\u89d2\u0378", 2057064799, -1076357792), a.b("\u23ca\u5a53\ud084\u4ed9\uc53c\u438d\uf9c4\u702f\uee77", 180102018), a.c(-1782438086, "\u2773\u5ef6\ud424\u4a4e\uc1bb\u4726\ufd77\u7480"), a.d("\ud417\uad92\u2740\ub92a\u32c1\ub454\u0e11\u87f1", 1953805047, 575104681), a.d("\u1e65\u67ff\ued3c\u734a\uf880\u7e1f\uc464\u4d91", -1428883204, 416802527)}) {
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
            if (kfe2 == null) continue;
            kfe2.setEnabled(false);
        }
    }

    /*
     * Exception decompiling
     */
    private static void fde(MinecraftClient var0) {
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

    private static void fdf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (--fcq <= 0) {
            fcq = 15 + fcc.nextInt(35);
            fcp = fcc.nextInt(3) - 1;
        }
        fcd.clear();
        fbw.fdg(minecraftClient.options.leftKey, fcp < 0);
        fbw.fdg(minecraftClient.options.rightKey, fcp > 0);
        fbw.fdg(minecraftClient.options.forwardKey, fcc.nextInt(4) == 0);
        minecraftClient.options.jumpKey.setPressed(clientPlayerEntity.isOnGround() && fcc.nextInt(25) == 0);
        vzz.simulated = fcd::contains;
    }

    private static void fdg(KeyBinding keyBinding, boolean bl) {
        keyBinding.setPressed(bl);
        if (bl) {
            fcd.add(KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding).getCode());
        }
    }

    private static void fdh(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        float f = vxr.getFloat(fca, clientPlayerEntity, clientPlayerEntity.getYaw());
        float f2 = vxr.getFloat(fcb, clientPlayerEntity, clientPlayerEntity.getPitch());
        Entity entity = kwf.target();
        if (entity != fcx) {
            fcx = entity;
            fcs = Double.NaN;
            fct = 0;
            int n = fcy = entity != null && fbw.fdi(clientPlayerEntity, entity, f, f2) >= 15.0 ? -1000 : -1;
            if (fcy == -1000) {
                ++fda;
            }
        }
        if (!Float.isNaN(fck) && entity != null) {
            double d = MathHelper.wrapDegrees((float)(f - fck));
            fcg.add(d);
            fch.add(Double.valueOf(f2 - fcl));
            ++fcn;
            if (fbw.fdk(clientPlayerEntity, entity, f, f2)) {
                ++fco;
            }
            if (fcy == -1000) {
                fcy = 0;
            } else if (fcy >= 0) {
                if (Math.hypot(d, f2 - fcl) > 0.001) {
                    fcz.add(fcy);
                    fcy = -1;
                } else if (++fcy > 40) {
                    fcy = -1;
                }
            }
            fbw.fdj(clientPlayerEntity, entity, f, d);
        } else {
            fbw.fdl();
        }
        fck = f;
        fcl = f2;
    }

    private static double fdi(ClientPlayerEntity clientPlayerEntity, Entity entity, float f, float f2) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Box box = entity.getBoundingBox();
        if (!tbp.aim(vec3d.x, vec3d.y, vec3d.z, (box.minX + box.maxX) * 0.5, box.minY, (box.minZ + box.maxZ) * 0.5, (box.maxX - box.minX) * 0.5, box.maxY - box.minY, 0.0, 0.5, fcr)) {
            return 0.0;
        }
        return Math.hypot(tbp.wrap(fbw.fcr.yaw - (double)f), fbw.fcr.pitch - (double)f2);
    }

    private static void fdj(ClientPlayerEntity clientPlayerEntity, Entity entity, float f, double d) {
        double d2;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Box box = entity.getBoundingBox();
        if (!tbp.aim(vec3d.x, vec3d.y, vec3d.z, (box.minX + box.maxX) * 0.5, box.minY, (box.minZ + box.maxZ) * 0.5, (box.maxX - box.minX) * 0.5, box.maxY - box.minY, 0.0, 0.5, fcr)) {
            return;
        }
        double d3 = tbp.wrap((double)f - fbw.fcr.yaw);
        int n = d3 > fbw.fcr.ra + (d2 = 0.25 * fbw.fcr.bw) ? 1 : (d3 < fbw.fcr.la - d2 ? -1 : 0);
        fcu += d;
        if (!Double.isNaN(fcs)) {
            fcv += tbp.wrap(fbw.fcr.yaw - fcs);
        }
        fcs = fbw.fcr.yaw;
        if (n != 0) {
            if (fct != 0 && n != fct && fcu * (double)n > 0.0 && fcu * (double)n > -fcv * (double)n) {
                ++fcw;
            }
            fct = n;
            fcu = 0.0;
            fcv = 0.0;
        }
    }

    private static boolean fdk(ClientPlayerEntity clientPlayerEntity, Entity entity, float f, float f2) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = Vec3d.fromPolar((float)f2, (float)f);
        Box box = entity.getBoundingBox().expand((double)entity.getTargetingMargin());
        return box.raycast(vec3d, vec3d.add(vec3d2.multiply(8.0))).isPresent();
    }

    private static void fdl() {
        if (fcg.size() >= 8) {
            fce.add(fcg.stream().mapToDouble(Double::doubleValue).toArray());
            fcf.add(fch.stream().mapToDouble(Double::doubleValue).toArray());
        }
        fcg.clear();
        fch.clear();
    }

    private static void fdm() {
        fbw.fdl();
        tiq tiq2 = tiq.open(fbx);
        ArrayList<tmh> arrayList = new ArrayList<tmh>();
        if (tiq2 != null) {
            arrayList.addAll(tiq2.tapes());
        }
        double[] dArray = syq.onTarget(arrayList);
        System.out.println(String.format(Locale.ROOT, a.b("\ua14d\ud8e8\u523c\ucc5e\u47c8\uc12a\u7b7e\uf29a\u6cca\ue671\u61b5\u9b97\u1514\u8cb4\u06f1\u8007\u3a1c\ub5c8\u2f2d\ua935\u20d8\u5acf\ud473\u4fac\uc9dc\u4311\ufabf\u74e9\uee17\u6801\ue3b7\u1d27\u972c\u0e89\u88c7\u027c\ubda3\u37ca\ub146\u28fb\ua2f7\udc10\u5654\ud1e1\u4b25\uc543\u7cc2\uf625\u7075\ueba8\u65c9\u9f4f\u16b7\u90e7\u0a5a\u845f\u3ffc\ub920\u3316\uaa94\u2424\u5e60\ud99c\u53c7\ucd4c\u44f8\ufea0\u784e\uf24e\u6dbc\ue76f\u611b\u98cc\u122c\u8c69\u0782\u8180\u3b78\ub2ac\u2c93\ua60e\u2048\u5bfd\ud520\u4f4a\uc68d\u4033\ufa65\u7593\uefd6\u6936\ue0e2\u1a9e\u9450\u0fb4\u89a6\u0369\ubd1d\u3481\uae39\u2828\ua3dc\uddce\u573b\uceb0\u48dc\uc205\u7dbc\uf7f3\u7158", 1092329794), fby ? a.b("\ued13\u9480\u1e4e\u8036\u0bee\u8d5a\u3700\ubeb4\u20fa", 958983498) : fbx, fcn, 100.0 * (double)fco / (double)Math.max(1, fcn), dArray[0] * 100.0, (int)dArray[1]));
        double[] dArray2 = syq.overshootRates(arrayList);
        fcz.sort(Integer::compare);
        System.out.println(String.format(Locale.ROOT, a.b("\u1f57\u66f2\uec26\u7244\uf9d2\u7f30\uc564\u4c80\ud2d0\u586b\udfaf\u258d\uab0e\u32ae\ub8eb\u3e1d\u8406\u0b98\u9132\u1770\u9e90\ue4c0\u6a68\uf1be\u77c1\ufd0b\u44bf\ucabd\u5032\ud601\u5da8\ua338\u2963\ub095\u36d5\ubc25\u03f7\u898d\u0f42\u96a7\u1cbe\u621f\ue859\u6fff\uf57a\u7b1a\uc2c8\u4879\uce26\u55a3\udbcd\u2116\ua8a9\u2ee0\ub44c\u3a11\u81f7\u0730\u8d59\u14dd\u9a6f\ue035\u67da\ueddf\u7356\ufabb\u40b4\uc603\u4c53\ud3f1\u5970\udf44\u2690\uac28\u327d\ub98a\u3fdf\u8578\u0cf8\u928c\u1802\u9e1b\ue5a4\u6b27\uf147\u7892\ufe23\u4465\ucb87\u51d0\ud762\u5efd\ua4de\u2a12\ub1ab\u37f2\ubd25\u0307\u8ad1\u1036\u963e\u1dc3\u63d9\ue96f\u70ad\uf6db\u7c1d\uc3a3\u49ee\ucf4b\u551d\udca7\u2276\ua871\u2fc1\ub590\u3b22\u82af\u0880\u8e08\u15a1\u9bea\ue156\u671d\ueee9\u7434\ufa44\u419d\uc796\u4d6a\ud4b1\u5ac1\ua01b\u27a2\uadfe\u3341\ub91b\u00a1\u866c\u0c4b\u93d6\u196b\u9f71\ue687\u6cd5\uf203\u79a5\ufffb\u4516\ucb13\u52a5\ud87f\u5e1e\ua599\u2b69\ub138", -685236310), 100.0 * (double)fcw / (double)Math.max(1, fcn), dArray2[0], fda, fcz, 100.0 * (double)fcz.stream().filter(n -> n == 0).count() / (double)Math.max(1, fcz.size()), syq.medianReaction(arrayList), 100.0 * syq.instantShare(arrayList)));
        for (String string : syq.report(fce, fcf, arrayList)) {
            System.out.println(a.d("\uf685\u8f20\u05f4\u9b96\u1000\u96e2\u2cb6\ua552\u3b02\ub1b9\u367d\ucc5f\u42dc\udb7c\u5139\ud7cf\u6dd4", -1129038113, 844351530) + string);
        }
    }

    private static void fdn(MinecraftClient minecraftClient) {
        try {
            if (fci != null && minecraftClient.currentScreen == null) {
                fci.setBoolean(minecraftClient.mouse, true);
            }
            if (fcj != null) {
                fcj.setBoolean(minecraftClient, true);
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
    }

    private static void fdo(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    static {
        fck = Float.NaN;
        fcm = -1;
        fcr = new tbm();
        fcs = Double.NaN;
        fcy = -1;
        fcz = new ArrayList<Integer>();
    }

    private static /* synthetic */ int np(int n, int n2) {
        return n - n2 + 263390829;
    }

    private static /* synthetic */ int nq(int n, int n2) {
        return fbw.np(n, n2) * n2;
    }
}

