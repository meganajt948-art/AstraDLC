/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.mob.HuskEntity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.kfe;
import a.tcz;
import a.vxr;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

final class ezo {
    private static final int ezp = 1200;
    private static final int ezq = 300;
    private static final Field ezr = vxr.find(Mouse.class, a.d("\u73c2\u0a78\u80ba\u1e91\u9505\u13b0\ua9e4\u201e\ube47\u34e7\ub327\u4951\uc794\u5e7f\ud461\u529f\ue8dd\u671e\ufdad\u7bd0\uf24b\u8818\u06a8", -1485326510, -1020214039), a.d("\u17b4\u6e0a\ue4d5\u7aad\uf172\u77f8\ucdc5\u4432\uda62\u50d8", -2083282817, 1968093095), a.b("\uf94a", -1922565871));
    private static final Field ezs = vxr.find(MinecraftClient.class, a.c(295900337, "\u14c8\u6d72\ue7b0\u799b\uf20f\u74ba\uceee\u4714\ud94d\u53ed\ud42d\u2e5b\ua09e\u3975\ub36b\u3595\u8fd7\u0014\u9aa7\u1cda\u9541\uef12\u61a0"), a.d("\uc7f3\ube4d\u3492\uaaea\u2135\ua7bf\u1d82\u9474\u0a24\u8099", 137919040, -1116160545), a.d("\u0bae", -336775945, -1328136446));
    private static final Random ezt = new Random(5L);
    private static final List<Double> ezu = new ArrayList<Double>();
    private static double ezv;
    private static double ezw;
    private static double ezx;
    private static int ezy;
    private static int ezz;
    private static int faa;
    private static int fab;
    private static int fac;
    private static int fad;
    private static int fae;
    private static boolean faf;
    private static int fag;
    private static int fah;
    private static double fai;
    private static double faj;
    private static boolean fak;
    private static float fal;
    private static float fam;
    private static boolean fan;
    private static /* synthetic */ boolean fao;
    private static /* synthetic */ boolean fap;

    private ezo() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        ezo.fba(minecraftClient);
        if (n == 1) {
            ezo.faq(minecraftClient, clientPlayerEntity);
            return false;
        }
        if (n < 60) {
            return false;
        }
        ezo.far(minecraftClient, n);
        int n2 = n - ezz;
        switch (ezy) {
            case 0: {
                ezo.fax(true, false);
                ezo.fay().setEnabled(true);
                ezo.faz(n);
                break;
            }
            case 1: {
                ezo.fas(minecraftClient, clientPlayerEntity);
                if (n2 < 1200) break;
                ezo.faz(n);
                ezo.fax(false, false);
                fak = false;
                break;
            }
            case 2: {
                ezo.fat(minecraftClient, clientPlayerEntity, n2);
                if (n2 < 300) break;
                ezo.faz(n);
                ezo.fax(true, false);
                ezo.fbb(minecraftClient, a.c(470625424, "\u2cb5\u5507\udfd4\u41a6\uca77\u4cd1\uf6d6\u7f60\ue131\u6b9f\uec5f\u166b\u98dc\u0148\u8b25\u0dfb\ub7b9\u3861\ua2c7\u24ce\uad69\ud73c\u5988\uc252\u442b\uceeb\u774b\uf91d\u63f8\ue5e7\u6e06\u90ca\u1a83\u836a\u050f\u8fc3\u305d\uba2b\u3ce0\ua54e\u2f0b\u51e0\udbb8\u5c02\uc6d0\u48a4\uf16a\u7bd6\ufdc0\u6658\ue82c\u12f5\u9b4d\u1d1b\u87ef\u09a3\ub20d\u3499\ubefa\u273b\ua9d8\ud38f\u547b\ude3a"));
                fak = false;
                break;
            }
            case 3: {
                ezo.fat(minecraftClient, clientPlayerEntity, n2);
                if (n2 < 300) break;
                return ezo.faw();
            }
            default: {
                return true;
            }
        }
        return false;
    }

    private static void faq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        minecraftClient.options.pauseOnLostFocus = false;
        long l2 = minecraftClient.getWindow().getHandle();
        GLFW.glfwSetCursorPosCallback((long)l2, (l, d, d2) -> {});
        GLFW.glfwSetMouseButtonCallback((long)l2, (l, n, n2, n3) -> {});
        ezv = Math.floor(clientPlayerEntity.getX()) + 0.5;
        ezw = Math.floor(clientPlayerEntity.getY());
        ezx = Math.floor(clientPlayerEntity.getZ()) + 0.5;
        ezo.fbb(minecraftClient, a.d("\ua883\ud134\u5beb\uc592\u4e4d\uc8fe\u72a6\ufb56\u654c\uefae\u687b\u920d\u1cde\u8570\u0f3c\u89da\u3398", 242148558, -2144842693));
        ezo.fbb(minecraftClient, a.c(1509462003, "\u8f8a\uf626\u7cf1\ue288\u691a\ueff8\u55bd\udc5d\u4256\uc8a9\u4f7b\ub50a\u3bdc"));
        ezo.fbb(minecraftClient, a.d("\uf986\u8031\u0aee\u9497\u1f57\u99e1\u23ab\uaa53\u3449\ubebc\u3964\uc337\u4dc2\ud47e\u5e1c\ud8ce\u6290\ued57\u77fd\uf1ab\u785b\u0203\u8cf7\u1760\u9118\u1bc4\ua268\u2c2f", -1388819991, 1667018772));
        ezo.fbb(minecraftClient, a.b("\u022f\u7b9c\uf14a\u6f3b\ue4a0\u6271\ud807\u51c8\ucfb8\u4504\uc2de\u38ba\ub635\u2f98\ua59a\u2377\u9935\u16fc\u8c53\u0a15\u83cd", -1894120879));
        ezo.fbb(minecraftClient, a.c(-2048553495, "\u8da7\uf415\u7ec6\ue0b4\u6b65\uedc3\u57c4\ude72\u4023\uca8d\u4d4d\ub779\u39ce\ua04c\u2a4c\uacef\u16b7\u9970\u03d9\u8592\u0c62\u7626\uf89a\u6346\ue53f\u6fab\ud651\u5807\uc2f8\u44a6\ucf12\u31c4\ubb96\u2276\ua460\u2ec3\u9113\u1b62\u9da4\u0441\u8e18\uf0ee\u7aad"));
        ezo.fbb(minecraftClient, a.b("\ue55b\u9ce9\u163a\u8848\u0399\u853f\u3f38\ub68e\u28df\ua271\u25b1\udf85\u5132\uc8b0\u42b0\uc412\u7e4f\uf18b\u6b39\ued6f\u648b\u1ecf\u9061\u0bb6\u8dc8\u0757\ubead\u30fb\uaa04\u2c5a\ua7ee\u5938\ud36a\u4a8a\ucc9c\u463f\uf9ef\u739e\uf558\u6cbd\ue6e4\u9812\u1251", -333781739));
        ezo.fbb(minecraftClient, a.c(-1505508903, "\uc18a\ub834\u32e2\uac93\u2708\ua1e7\u1be7\u920a\u0c56\u86f5\u0178\ufb5a\u7591\uec31\u663c\ue09e\u5acd\ud51f\u4fbe\uc9b1\u4009\u3a5b\ub4fa\u2f75\ua959\u2394\u9a36\u1439\u8e81\u08d3\u8372\u7dee\uf7a5\u6e53\ue80b\u62bc\udd7a\u5718\ud1cc\u486f\uc27e\ubcc6\u368b\ub138\u2bef\ua585\u1c4a\u96cc\u10af\u8b79\u0511\uffc1\u767d"));
        ezo.fbb(minecraftClient, a.d("\uc87e\ub1c0\u3b16\ua567\u2efc\ua813\u1213\u9bfe\u05a2\u8f01\u088c\uf2a3\u7c2a\ue5c8\u6f87\ue975\u5328\udca7\u465b\uc009\u49ec\u33e3\ubd1b\u26df\ua0fe\u2a60\u93d0\u1d93\u8729\u017c\u8ac8\u7412\ufe5b\u67bb\ue1fb\u6b4d\ud488\u5eb7\ud83f\u4186\ucbc2", -713177206, 753078203));
        ezo.fbb(minecraftClient, a.b("\uac44\ud5fa\u5f20\uc155\u4a91\ucc72\u7641\uff83", 1322626095));
        ezo.fbb(minecraftClient, a.b("\u3550\u4cfc\uc63e\u5847\ud3dd\u553e\uef7a\u669e\uf8dd\u7261\uf5b0\u0fc7\u8155\u18a1\u92f9\u1412\uae40\u218c\ubb32\u3d3a\ub4ad\ucecf\u402f\udbb6\u5dce\ud704\u6ea1\ue0f3\u7a17\ufc1a\u77b7\u8976\u036e\u9a81\u1ccf\u9662\u29fd\ua3c1\u2516\ubca0\u36f4\u4803\uc241\u45e3\udf33\u5150\ue8cd\u6222\ue460\u7fb9\uf1c6\u0b15\u82a3\u04f8\u9e30\u104d\uabf6\u2d3f\ua751\u3e96", 0x5533505));
        ezo.fbb(minecraftClient, String.format(Locale.ROOT, a.d("\u0d05\u74b0\ufe33\u6022\uebc6\u6d24\ud772\u5e88\uc0c8\u4a2e\ucdbb\u37cf\ub913\u20bd\uaab9\u2c0e\u9644\u199e\u8332\u0534\u8c85\uf6c4\u7867\ue3a6", -615730361, -1151615442), ezv, ezw, ezx));
        for (int i = 0; i < 2; ++i) {
            ezo.fbb(minecraftClient, String.format(Locale.ROOT, a.b("\ub4db\ucd6c\u47a7\ud9d6\u5203\ud4b3\u6eae\ue712\u7949\uf3ff\u7427\u8e50\u0096\u9934\u1360\u9583\u2f82\ua001\u3aaf\ubcf8\u3517\u4f0d\uc1bb\u5a61\udc02\u5687\uef72\u6126\ufbda\u7d94\uf670\u08e7\u82ad\u1b57\u9d18\u17fd\ua86c\u2246\ua4a0\u3d30\ub741\uc9b8\u4398\uc422\u5ea6\ud099\u6935\ue3be\u65f4\ufe2c\u7054\u8a9f\u0366\u853c\u1f9c\u9183\u2a40\uaca4\u26c0\ubf10\u31bd\u4bf6\ucc02\u4642\ud886\u513a\ueb6f\u6da9\ue7c9\u786c\uf2bb\u74d6\u8d12\u07b4\u99e6\u1249\u9415\u2ef7\ua76a\u3956\ub38c\u35dd\u4e68\uc0a2\u5ade\ud318\u55aa\uefea\u6003\ufa1b\u7cc9\uf538\u0f5d\u8181\u1a6c\u9c25\u16a5\ua8d0\u2104\ubbbe\u3def\ub60f\uc84f\u42f9\udb34\u5d0b\ud78f\u6832\ue27c\u64aa\ufece\u7772\u89b9\u03e5\u840e\u1e43\u90be\u2961\ua35c\u258e\ube23\u3064\u4ac8\ucc92\u4524\udff7\u5182\uea49\u6c18\ue6e4\u7f17\uf117\u0ba4\u8c38\u066f\u9893\u12d4\uab79\u2df8\ua782\u3854\ub2e7\u34b2\u4d11\uc745", -1638616007), ezv + (double)i, ezw, ezx + 3.0));
        }
        ezo.fbb(minecraftClient, a.d("\u6fcf\u167d\u9cae\u02dc\u890d\u0fab\ub5ac\u3c1a\ua24b\u28e5\uaf25\u5511\udba6\u4232\uc85f\u4e81\uf4c3\u7b1b\ue1bd\u67b4\uee13\u9446\u1af2\u8128\u0751\u8d91\u3431\uba67\u2082\ua69d\u2d7c\ud3b0\u59f9\uc010\u4675\uccb9\u733c\uf95a\u7f9f\ue634\u6c71\u1287\u98c1\u1f7f\u85a5\u0bd2\ub244\u38bc\ubef4\u252d\uab51\u5187\ud837\u5e7b\uc499\u4a8d\uf126\u77e3\ufdc4\u6413\ueaa3\u90e2", -2086475564, 806455104));
        clientPlayerEntity.getInventory().setSelectedSlot(0);
        for (String string : new String[]{a.b("\ub6fa\ucf6d\u45a5\udbda\u500d\ud6be\u6cfa\ue53b\u7b49\uf1e3", -560679260), a.c(1104694707, "\u4dfa\u347f\ubead\u20c7\uab32\u2daf\u97fe\u1e09"), a.c(1094963974, "\ud34f\uaaca\u2018\ube72\u3599\ub30c\u0949\u80a9")}) {
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
            if (kfe2 == null) continue;
            kfe2.setEnabled(false);
        }
    }

    private static void far(MinecraftClient minecraftClient, int n) {
        for (int i = 0; i < 2; ++i) {
            double d = Math.toRadians(-35.0 + 70.0 * (double)i + 25.0 * Math.sin((double)n * (0.045 + 0.02 * (double)i) + (double)i));
            double d2 = 2.8 + 0.45 * Math.sin((double)n * 0.03 + (double)i * 2.0);
            ezo.fbb(minecraftClient, String.format(Locale.ROOT, a.b("\u672b\u1e9e\u941d\u0a0c\u81fe\u0771\ubd0d\u34f1\uaaa7\u2003\ua788\u5da9\ud37a\u4acc\uc094\u4663\ufc3d\u73ff\ue94b\u6f08\ue6b1\u9cb2\u121c\u89cb\u0fac\u853a\u3cc9\ub29d\u286e\uae3b\u2595\udb0d\u514e\uc8a2\u4eae\uc403\u7bc9\uf1be\u7724\uee8d\u6484\u1a5b\u9075\u17c1\u8d1d\u0371\ubaf7\u3000\ub64a\u2d90\ua3fc\u597a\ud08b\u56df\ucc27\u426b\uf981", 1856661350), i == 0 ? a.c(2093632074, "\u4a23\u3399\ub94e\u272c\uacec\u2a4b\u901f") : a.c(193833399, "\ua9d9\ud07b\u5aaf\uc4d8\u4f13\uc9af\u73ea\ufa1c"), ezv - Math.sin(d) * d2, ezw, ezx + Math.cos(d) * d2));
        }
    }

    private static void fas(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        ezo.fau(minecraftClient, clientPlayerEntity);
        boolean bl = ezo.fav(minecraftClient, clientPlayerEntity);
        if (fan) {
            ++fae;
            if (!faf && bl) {
                faf = true;
                ++fac;
                fad += fae;
            }
        }
        if (--faa <= 0) {
            faa = 30 + ezt.nextInt(40);
            double d = (double)(ezt.nextBoolean() ? 1 : -1) * (20.0 + ezt.nextDouble() * 35.0);
            double d2 = tcz.unit(minecraftClient);
            long l = Math.round(d / d2);
            clientPlayerEntity.changeLookDirection((double)l * d2 / 0.15, 0.0);
            fal = clientPlayerEntity.getYaw();
            fam = clientPlayerEntity.getPitch();
            fan = true;
            faf = false;
            fae = 0;
            ++fab;
        }
    }

    private static void fat(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, int n) {
        float f = clientPlayerEntity.getYaw();
        float f2 = clientPlayerEntity.getPitch();
        if (fak && n > 20) {
            faj += (double)(Math.abs(MathHelper.wrapDegrees((float)(f - fal))) + Math.abs(f2 - fam));
        }
        fal = f;
        fam = f2;
        fak = true;
        if (n == 1) {
            clientPlayerEntity.changeLookDirection(200.0, 0.0);
        }
    }

    private static void fau(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        float f = clientPlayerEntity.getYaw();
        float f2 = clientPlayerEntity.getPitch();
        if (fak) {
            double d = f - fal;
            double d2 = f2 - fam;
            double d3 = tcz.unit(minecraftClient);
            double d4 = d / d3;
            ++fah;
            if (Math.abs(d4 - Math.rint(d4)) > 0.01 && Math.abs(d) > 1.0E-4) {
                ++fag;
            }
            double d5 = Math.hypot(MathHelper.wrapDegrees((double)d), d2);
            fai = Math.max(fai, d5);
            if (d5 > 0.5) {
                ezu.add(d5);
            }
        }
        fal = f;
        fam = f2;
        fak = true;
    }

    private static boolean fav(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = vec3d.add(clientPlayerEntity.getRotationVec(1.0f).multiply(6.0));
        for (Entity entity : minecraftClient.world.getEntities()) {
            Box box;
            if (!(entity instanceof HuskEntity) || !(box = entity.getBoundingBox()).raycast(vec3d, vec3d2).isPresent()) continue;
            return true;
        }
        return false;
    }

    private static boolean faw() {
        ezo.fay().setEnabled(false);
        double[] dArray = ezu.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        String string = dArray.length == 0 ? a.c(1436186511, "\u77e5\u0e55\u8487\u1afd") : String.format(Locale.ROOT, a.d("\u37e1\u4e15\uc4c3\u5aa2\ud170\u57ca\ued85\u6420\ufa39\u70d8\uf742\u0d3a\u83fd\u1a49\u9011\u16fc\uace7\u2370\ub98e\u3fd3\ub63d\ucc34\u4282\ud958\u5f3b\ud5be", 1548030262, 581379773), dArray[dArray.length / 2], dArray[(int)((double)dArray.length * 0.9)], dArray[dArray.length - 1]);
        System.out.println(String.format(Locale.ROOT, a.d("\u3c8d\u4534\ucfe3\u51df\uda5c\u5cfc\ue6b9\u6f4f\uf15e\u7bf5\ufc67\u0614\u88d1\u1164\u9b2b\u1dc1\ua799\u2849\ub2be\u34ea\ubd5c\uc746\u49ff\ud26f\u5458\ude85\u6773\ue929\u73c4\uf593\u7e2b\u80a3\u0ae9\u9313\u155f\u9fb9\u2028\uaa0d\u2cc3\ub578\u3f2f\u41c6\ucbca\u4c77\ud6ef\u5897\ue144\u6bbe\uedbb\u767f\uf817\u02cb\u8b38\u0d6c\u97de\u19c4\ua271\u24e1\uaeda\u3707\ub9e3\uc3b5\u4457\uce13\u50df\ud93d\u636b\ue5cc\u6fc4\uf079\u7afe\ufc8e\u0556\u8ffb\u11a3\u9a53\u1c40\ua6a6\u2f6a\ub11a\u3bd0\ubd88\uc67e\u48e0\ud29e\u5b4f\uddba\u67ee\ue81a\u7257\uf4b0\u7db7", 294159572, 2133833828), fac, fab, (double)fad / (double)Math.max(1, fac), fag, fah, string, faj));
        boolean bl = (double)fac >= (double)fab * 0.8 && fag == 0 && fai < 60.0 && faj < 0.5;
        System.out.println(a.c(1074181284, "\ub4cc\ucd75\u47a2\ud99e\u521d\ud4bd\u6ef8\ue70e\u7905") + (bl ? a.b("\u6ba6\u1206\u98c7\u06b6", -1594921998) : a.c(-222565819, "\uea07\u93b1\u196a\u871e")));
        return true;
    }

    /*
     * Exception decompiling
     */
    private static void fax(boolean var0, boolean var1_1) {
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

    private static kfe fay() {
        return Flow.getInstance().getModuleManager().getByName(a.c(-993895056, "\u5d38\u24a1\uae76\u302b\ubbce\u3d7f\u8736\u0edd\u9085"));
    }

    private static void faz(int n) {
        ++ezy;
        ezz = n;
    }

    private static void fba(MinecraftClient minecraftClient) {
        try {
            if (ezr != null && minecraftClient.currentScreen == null) {
                ezr.setBoolean(minecraftClient.mouse, true);
            }
            if (ezs != null) {
                ezs.setBoolean(minecraftClient, true);
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
    }

    private static void fbb(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static /* synthetic */ int mv(int n, int n2) {
        return n ^ n2 | 0xCC2BFEC1;
    }

    private static /* synthetic */ int mw(int n, int n2) {
        return n ^ n2 | 0x50A4B7AD;
    }

    private static /* synthetic */ int mx(int n, int n2) {
        return ezo.mv(n, n2) ^ 0xF16CE316;
    }
}

