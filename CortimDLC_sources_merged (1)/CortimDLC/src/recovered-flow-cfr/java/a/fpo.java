/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.fnq;
import a.foo;
import a.fot;
import a.fpc;
import a.fpf;
import a.kfe;
import a.kwf;
import a.syq;
import a.tiq;
import a.tmh;
import a.vxr;
import a.vzz;
import a.wcn;
import a.wdt;
import flow.Flow;
import flow.dev.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class fpo {
    private static final fot[] fpp = new fot[]{new fot(a.d("\u480c\u31ac\ubb6f\u2517", 1018781309, -34138607), 900, true, 0.6, true, 16.0f), new fot(a.c(-190063754, "\udb12\ua2a5\u2876\ub612\u3dd8"), 700, true, 1.0, true, 16.0f), new fot(a.d("\u8b8e\uf23d\u78e3\ue693", 580668412, -1982218219), 600, true, 0.1, false, 14.0f), new fot(a.c(-1397452765, "\u9042\ue9e6\u6328\ufd43\u768f\uf034"), 500, false, 0.5, true, 16.0f)};
    private static final fot[] fpq = fpo.fue();
    private static final int fpr = 100;
    private static final int fps = 8;
    private static final boolean fpt = System.getenv(a.c(-1229975286, "\u115c\u68e7\ue237\u7c5e\uf7ec\u7130\ucb78\u4298\udcd7\u566f\ud1af\u2bd5\ua504\u3ca6\ub6f7\u3000")) != null;
    private static final String fpu = System.getenv(a.c(1915715256, "\u7ef1\u074a\u8d9a\u13f3\u9841\u1e9d\ua4d5\u2d35\ub37a\u39c2\ube02\u446d\ucaae\u5318\ud958"));
    private static final Field fpv = vxr.find(ClientPlayerEntity.class, a.d("\uf965\u80df\u0a1d\u9436\u1fa2\u9917\u2343\uaab9\u34e0\ube40\u3980\uc3f6\u4d33\ud4d8\u5ec6\ud838\u627a\uedb9\u770a\uf177\u78e8\u02ba\u8c0b", -1609502571, -586151543), a.c(-701688847, "\u139d\u6a23\ue0fc\u7e84\uf55b\u73d1\uc9ee\u4015\ude47\u54f3"), a.d("\u5614", -101762424, 875523291));
    private static final Field fpw = vxr.find(ClientPlayerEntity.class, a.b("\u77a6\u0e1c\u84de\u1af5\u9161\u17d4\uad80\u247a\uba23\u3083\ub743\u4d35\uc3f0\u5a1b\ud005\u56fb\uecb9\u637a\uf9c9\u7fb4\uf62b\u8c79\u02c8", -100304929), a.c(-1656699692, "\uc4b8\ubd06\u37d9\ua9a1\u227e\ua4f4\u1ecb\u9730\u0964\u83d2"), a.d("\u1496", 1322923978, -2116934885));
    private static final Set<Integer> fpx = new HashSet<Integer>();
    private static final List<Double> fpy = new ArrayList<Double>();
    private static final List<double[]> fpz = new ArrayList<double[]>();
    private static final List<double[]> fqa = new ArrayList<double[]>();
    private static final List<Double> fqb = new ArrayList<Double>();
    private static final List<Double> fqc = new ArrayList<Double>();
    private static float fqd = Float.NaN;
    private static float fqe;
    private static double fqf;
    private static int fqg;
    private static int fqh;
    private static double fqi;
    private static final List<Double> fqj;
    private static final boolean fqk;
    private static int fql;
    private static double fqm;
    private static double fqn;
    private static int fqo;
    private static int fqp;
    private static int fqq;
    private static int fqr;
    private static double fqs;
    private static double fqt;
    private static final ConcurrentLinkedQueue<fpf> fqu;
    private static final ConcurrentLinkedQueue<foo> fqv;
    private static final ConcurrentLinkedQueue<Integer> fqw;
    private static final ConcurrentLinkedQueue<Integer> fqx;
    private static final List<fpc> fqy;
    private static final ArrayDeque<fpc> fqz;
    private static volatile int fra;
    private static volatile int frb;
    private static volatile int frc;
    private static volatile UUID frd;
    private static volatile boolean fre;
    private static volatile int frf;
    private static boolean frg;
    private static int frh;
    private static double fri;
    private static double frj;
    private static double frk;
    private static int frl;
    private static int frm;
    private static int frn;
    private static final Random fro;
    private static boolean frp;
    private static int frq;
    private static int frr;
    private static boolean frs;
    private static int frt;
    private static boolean fru;
    private static float frv;
    private static boolean frw;
    private static String frx;
    private static int fry;
    private static int frz;
    private static int fsa;
    private static boolean fsb;
    private static boolean fsc;
    private static final Vec3d[] fsd;
    private static float fse;
    private static float fsf;
    private static float fsg;
    private static int fsh;
    private static int fsi;
    private static int fsj;
    private static float fsk;
    private static int fsl;
    private static int fsm;
    private static final int[] fsn;
    private static final int[] fso;
    private static final int[] fsp;
    private static final int[] fsq;
    private static final int[] fsr;
    private static final int[] fss;
    private static final int[] fst;
    private static final int[] fsu;
    private static final int[][] fsv;
    private static final int[] fsw;
    private static final int[] fsx;
    private static final int[] fsy;
    private static final int[] fsz;
    private static final int[] fta;
    private static final double[] ftb;
    private static final double[] ftc;
    private static final int[] ftd;
    private static final int[] fte;
    private static final int[] ftf;
    private static final int[] ftg;
    private static final List<Double> fth;
    private static /* synthetic */ String fti;
    private static /* synthetic */ boolean ftj;

    private fpo() {
    }

    static boolean tick(MinecraftClient minecraftClient) {
        int n;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        fpo.fub(minecraftClient);
        wcn.ensure(minecraftClient);
        if (++frh == 1) {
            int n2 = MathHelper.floor((double)clientPlayerEntity.getX());
            int n3 = MathHelper.floor((double)clientPlayerEntity.getY());
            int n4 = MathHelper.floor((double)clientPlayerEntity.getZ());
            fri = (double)n2 + 0.5;
            frj = n3;
            frk = (double)n4 + 0.5;
            frd = clientPlayerEntity.getUuid();
            frc = clientPlayerEntity.getId();
            fpo.fuf(minecraftClient, a.d("\uabd9\ud26e\u58b1\uc6c8\u4d17\ucba4\u71fc\uf80c\u6616\uecf4\u6b21\u9157\u1f84\u862a\u0c66\u8a80\u30c2", -307556399, -364993410));
            fpo.fuf(minecraftClient, a.d("\u2e1b\u57b7\udd60\u4319\uc88b\u4e69\uf42c\u7dcc\ue3c7\u6932\ueee4\u148d", -574092651, 232137974));
            fpo.fuf(minecraftClient, a.b("\ucb61\ub2c2\u3815\ua671\u2dba\uab06\u1142\u98e1\u06fd\u8c43\u0b99\uf1ec\u7f28", -2032481509));
            fpo.fuf(minecraftClient, a.c(95199938, "\ua281\udb33\u51e0\ucf92\u4443\uc2e5\u78e2\uf154\u6f05\ue5ab\u626b\u985f\u16e8\u8f6a\u056a\u83c9\u3991\ub656\u2cff\uaab4\u2344\u5900\ud7bc\u4c60\uca19\u408d\uf927\u7776\ued81\u6bd0\ue063\u1eab\u94f0\u0d15\u8b12\u01a5\ube75\u3414"));
            fpo.fuf(minecraftClient, a.c(-946030543, "\ub872\uc1c0\u4b13\ud561\u5eb0\ud816\u6211\ueba7\u75f6\uff58\u7898\u82ac\u0c1b\u9599\u1f99\u993b\u2366\uaca2\u3610\ub046\u39a2\u43e6\ucd48\u569f\ud0e1\u5a7e\ue3d4\u6d85\uf772\u7123\ufa90\u0458\u8e03\u17e6\u91e1\u1b56\ua486\u2ee7"));
            fpo.fuf(minecraftClient, a.d("\u50dc\u2962\ua3b8\u3dcd\ub609\u30ea\u8ad9\u031b", 91760528, 1740404519));
            fpo.fuf(minecraftClient, a.c(837404832, "\uc8de\ub16d\u3bbb\ua5ca\u2e51\ua880\u12f6\u9b39\u0549\u8ff5\u082f\uf24b\u7cc4\ue569\u6f6b\ue986\u53c4\udc0d\u46a2\uc0e4\u493c"));
            fpo.fuf(minecraftClient, a.d("\u9579\uecd5\u6617\uf86e\u73f4\uf517\u4f53\uc6b7\u58f4\ud248\u5599\uafee\u217c\ub888\u32d0\ub43b\u0e69\u81a5\u1b1b\u9d13\u1484\u6ee6\ue006\u7b9f\ufde7\u772d\uce88\u40da\uda3e\u5c33\ud79e\u295f\ua347\u3aa8\ubce6\u364b\u89d4\u03e8\u853f\u1c89\u96dd\ue82a\u6268\ue5ca\u7f1a\uf179\u48e4\uc20b\u4449\udf90\u51ef\uab3c\u228a\ua4d1\u3e19\ub064\u0bdf\u8d16\u0778\u9ebf", -1299412435, 1701519105));
            fpo.fuf(minecraftClient, String.format(Locale.ROOT, a.b("\u21fc\u5842\ud294\u4ce5\uc77e\u41ca\ufbd8\u726d\uec37\u66c7\ue150\u1b24\u95b2\u0c47\u8611\u00a1\ubaaa\u357e\uaf8c\u2999\ua06b\uda7b\u548c\ucf10\u496b\uc3bd\u7a05\uf452\u6eb4\ue8f6\u6342\u9d81\u1780\u8e2c\u0874\u82c8\u3d0d\ub77c\u31fc\ua805\u225d\u5caf\ud6fc\u514e\ucb81", 955851191), n2 - 16, n3 - 1, n4 - 16, n2 + 16, n3 + 9, n4 + 16));
            fpo.fuf(minecraftClient, String.format(Locale.ROOT, a.b("\uc130\ub885\u3206\uac17\u27f3\ua111\u1b47\u92bd\u0cfd\u861b\u018e\ufbfa\u756c\uec99\u66cf\ue035\u5a65\ud5e3\u4f16\uc94a\u40a9\u3af1\ub452\u2f93", -892878500), fri, n3, frk));
            clientPlayerEntity.getInventory().setSelectedSlot(0);
            return false;
        }
        if (frh == 8) {
            double d = fri + 3.0;
            minecraftClient.getServer().execute(() -> fnq.spawn((MinecraftServer)minecraftClient.getServer(), frd, d, frj, frk));
            return false;
        }
        if (frh == 40) {
            fpo.fuc();
        }
        if (frh < 100) {
            if (frh > 20) {
                fpo.fua(minecraftClient);
            }
            return false;
        }
        Entity entity = fpo.fua(minecraftClient);
        if (entity == null) {
            System.out.println(a.d("\ucbdc\ub27c\u38bf\ua6c7\u2d5c\uabb9\u11fb\u981c\u0644\u8ca1\u0b14\uf162\u7fbd\ue609\u6c36\uea89\u50c7\udf59\u45a8\uc3f4\u4a18", 843544986, 1544139319));
            return true;
        }
        if (minecraftClient.mouse.isCursorLocked()) {
            minecraftClient.mouse.unlockCursor();
        }
        int n5 = frh - 100;
        int n6 = 0;
        for (n = 0; n < fpq.length && n5 >= n6 + fpo.fpq[n].fov; ++n) {
            n6 += fpo.fpq[n].fov;
        }
        if (n >= fpq.length) {
            fre = false;
            fnq.active = false;
            fpo.ftz(minecraftClient);
            vzz.simulated = null;
            fpo.ftw();
            fpo.fud();
            return true;
        }
        fot fot2 = fpq[n];
        if (n != frf) {
            if (frf >= 0) {
                fpo.ftf[fpo.frf] = fnq.hits - frm;
                fpo.ftg[fpo.frf] = fnq.critHits - frn;
            }
            frf = n;
            frl = frh;
            frm = fnq.hits;
            frn = fnq.critHits;
            fnq.aggression = fot2.fox;
            fnq.jumping = fot2.foy;
            fnq.strafing = true;
            fnq.active = true;
            fre = true;
            System.out.println(a.b("\u7f20\u0680\u8c43\u123b\u99a0\u1f41\ua50a\u2cf2\ub2bf\u3818\ubf8e", 2089254735) + fot2.fou);
        }
        fpo.ftf[n] = fnq.hits - frm;
        fpo.ftg[n] = fnq.critHits - frn;
        if (fpt && frw && fry != fra) {
            System.out.println(a.b("\ud896\ua136\u2bf5\ub58d\u3e16\ub8f4\u02bf\u8b4c\u150a\u9feb", -897263368) + fot2.fou + a.c(-1547238408, "\u03d9") + frx);
        }
        frw = false;
        if (fpu != null) {
            fpo.ftk(minecraftClient, clientPlayerEntity, entity, fot2.fow && frh - frl >= 20);
            return false;
        }
        if (frh - frl < 20) {
            fpo.ftx(minecraftClient, clientPlayerEntity, entity, fot2, n);
            fpo.fty(minecraftClient, clientPlayerEntity, entity, false);
            return false;
        }
        fpo.ftx(minecraftClient, clientPlayerEntity, entity, fot2, n);
        fpo.fty(minecraftClient, clientPlayerEntity, entity, fot2.fow);
        return false;
    }

    private static void ftk(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, boolean bl) {
        double d;
        boolean bl2;
        double d2;
        float f = vxr.getFloat(fpv, clientPlayerEntity, clientPlayerEntity.getYaw());
        float f2 = vxr.getFloat(fpw, clientPlayerEntity, clientPlayerEntity.getPitch());
        if (!Float.isNaN(fqd)) {
            double d3 = MathHelper.wrapDegrees((float)(f - fqd));
            d2 = f2 - fqe;
            fpy.add(Math.sqrt(d3 * d3 + d2 * d2));
            if (kwf.target() != null) {
                fqb.add(d3);
                fqc.add(d2);
            } else {
                fpo.ftl();
            }
            if (System.getenv(a.c(-365273819, "\u5d76\u24cd\uae1d\u3074\ubbc6\u3d1a\u8752\u0eb2\u90fd\u1a45\u9d85\u67ea\ue929\u709f\ufadf\u7c30\uc674\u49a3\ud303\u5550\udca1")) != null || Math.sqrt(d3 * d3 + d2 * d2) > 30.0) {
                System.out.println(String.format(Locale.ROOT, a.c(-1066221823, "\ubf34\uc694\u4c57\ud22f\u59b4\udf64\u6523\uecd5\u7299\uf849\u7fd8\u85a2\u0b7b\u928d\u188a\u9e7a\u2432\uabff\u3102\ub707\u3eb9\u44f0\uca02\u5197\ud7bb\u5d7c\ue4c4\u6a8f\uf02c\u7678\ufdc0\u030e\u8916\u10ae\u96f7\u1c4d\ua385\u29a3\uaf36\u368a\ubcc6\uc229\u487f\ucfc5\u550d\udb2b\u62b1\ue80a\u6e4e\uf580\u7ba4\u8133\u08c7\u8e94\u146b\u9a32\u219a\ua758\u2d6a\ub4be\u3a02\u404c\uc7e8\u4df0\ud335\u5a8f\ue0c3\u6665\uec74\u7391\uf957\u7f35\u86ff\u0c4c\u920e\u19b6\u9ff9\u251e\uac9e\u32ea\ub873"), fra, Float.valueOf(fqd), Float.valueOf(fqe), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(clientPlayerEntity.getYaw()), Float.valueOf(clientPlayerEntity.getPitch()), kwf.target(), kwf.debug()));
            }
        }
        fqd = f;
        fqe = f2;
        if (fqk) {
            fpo.ftm(clientPlayerEntity, f, f2);
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = entity.getEntityPos();
        d2 = Math.toDegrees(Math.atan2(vec3d2.z - vec3d.z, vec3d2.x - vec3d.x)) - 90.0;
        if (a.b("\ucbdf\ub274\u38a2\ua6da\u2d06\uabad", 798280618).equals(fpu)) {
            if (--fsh <= 0) {
                fsh = 30 + fro.nextInt(60);
                fqf = (fro.nextDouble() - 0.5) * 6.0;
            }
            clientPlayerEntity.changeLookDirection(fqf / 0.15, 0.0);
            if (Math.abs(MathHelper.wrapDegrees((double)(d2 - (double)clientPlayerEntity.getYaw()))) > 90.0) {
                ++fqg;
            }
        }
        ++fqh;
        double d4 = vec3d2.x - clientPlayerEntity.getX();
        double d5 = vec3d2.z - clientPlayerEntity.getZ();
        double d6 = Math.max(0.001, Math.sqrt(d4 * d4 + d5 * d5));
        fqi += d6;
        if (--fsl <= 0) {
            fsl = 15 + fro.nextInt(30);
            fsm = fro.nextInt(3) - 1;
        }
        boolean bl3 = bl2 = Math.abs(clientPlayerEntity.getX() - fri) > 12.0 || Math.abs(clientPlayerEntity.getZ() - frk) > 12.0;
        double d7 = d6 > 2.6 ? 1.0 : (d6 < 1.4 ? -1.0 : 0.0);
        double d8 = bl2 ? 0.0 : (double)fsm;
        double d9 = d4 / d6 * d7 + d5 / d6 * d8;
        double d10 = d5 / d6 * d7 - d4 / d6 * d8;
        double d11 = Math.hypot(d9, d10);
        double d12 = 0.0;
        double d13 = 0.0;
        if (d11 > 1.0E-6) {
            d = Math.toRadians(clientPlayerEntity.getYaw());
            d12 = (d10 * Math.cos(d) - d9 * Math.sin(d)) / d11;
            d13 = (d9 * Math.cos(d) + d10 * Math.sin(d)) / d11;
        }
        d = Math.sin(Math.toRadians(22.5));
        fpx.clear();
        fpo.ftn(minecraftClient, minecraftClient.options.forwardKey, d12 > d);
        fpo.ftn(minecraftClient, minecraftClient.options.backKey, d12 < -d);
        fpo.ftn(minecraftClient, minecraftClient.options.leftKey, d13 > d);
        fpo.ftn(minecraftClient, minecraftClient.options.rightKey, d13 < -d);
        minecraftClient.options.jumpKey.setPressed(bl);
        vzz.simulated = fpx::contains;
    }

    private static void ftl() {
        if (fqb.size() >= 8) {
            fpz.add(fqb.stream().mapToDouble(Double::doubleValue).toArray());
            fqa.add(fqc.stream().mapToDouble(Double::doubleValue).toArray());
        }
        fqb.clear();
        fqc.clear();
    }

    private static void ftm(ClientPlayerEntity clientPlayerEntity, float f, float f2) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.d("\ua693\udf00\u55d6\ucba7\u405d\uc6d8\u7c8c\uf56e", -365975033, -779416361));
        int n = fqh % 100;
        if (fql >= 0) {
            int n2 = fra - fql;
            if (n2 > 0 && fpy.size() > 0) {
                fqn = Math.max(fqn, fpy.get(fpy.size() - 1));
            }
            double d = Math.hypot(MathHelper.wrapDegrees((float)(f - clientPlayerEntity.getYaw())), f2 - clientPlayerEntity.getPitch());
            if (fqo < 0 && n2 > 0 && d < 1.0) {
                fqo = n2;
            }
        }
        if (n == 59 && fql >= 0) {
            System.out.println(String.format(Locale.ROOT, a.b("\uc7fe\ube5e\u349d\uaae5\u217e\ua7ae\u1de9\u941f\u0a53\u8083\u071f\ufd67\u73b0\uea47\u6017\ue6e0\u5cee\ud361\u49c8\ucfcf\u4627\u3c7a\ub2db\u295d\uaf75\u25b2\u9c13\u1211\u88e3\u0eb9\u8515\u7b93\uf19a\u682f\uee7d\u64ce\udb5e\u5169\ud7ae\u4e02\uc45f\ubae3\u30f3\ub740\u2d9b\ua3e2\u1a26\u9084\u1686\u8d5b\u036a\uf9b8\u700d\uf654\u6cec\ue2f4\u594c\udfd3\u55a5\ucc35\u42c6\u38c3\ubf2d\u3576\uabb1\u2218\u9814\u1ee9\u94f3\u0b4e\u8184\u07ad\ufe26\u7496\ueac2\u612f\ue736\u5d82\ud45a\u4a34\uc0ac\u46bb\u3d4c\ub39c\u29e9\ua070\u2698\u9cd4\u1321\u8978", 1839450048), fqp, fqm, fqo, fqn));
            ++fqp;
            if (fqn > 35.0) {
                ++fqq;
            }
            if (fqo < 0) {
                ++fqr;
            } else {
                fqt += (double)fqo;
            }
            fqs = Math.max(fqs, fqn);
            fql = -1;
        }
        if (n == 0 && kfe2.isEnabled()) {
            fql = fra;
            fqm = Math.hypot(MathHelper.wrapDegrees((float)(f - clientPlayerEntity.getYaw())), f2 - clientPlayerEntity.getPitch());
            fqn = 0.0;
            fqo = -1;
            kfe2.setEnabled(false);
        } else if (n == 60 && !kfe2.isEnabled()) {
            kfe2.setEnabled(true);
        }
    }

    private static void ftn(MinecraftClient minecraftClient, KeyBinding keyBinding, boolean bl) {
        keyBinding.setPressed(bl);
        InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding);
        if (bl) {
            fpx.add(key.getCode());
        }
    }

    private static void fto(MinecraftClient minecraftClient) {
        Object object;
        fpf fpf2;
        float f;
        Object object2;
        Integer n;
        ++fra;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!fre || clientPlayerEntity == null || frb < 0) {
            return;
        }
        int n2 = frf;
        Entity entity = minecraftClient.world.getEntityById(frb);
        if (entity == null) {
            return;
        }
        if (System.getenv(a.d("\ucb1d\ub2a6\u3876\ua61f\u2dad\uab71\u1139\u98d9\u0696\u8c2e\u0bee\uf181\u7f42\ue6f4\u6cb4\uea5b\u501f\udfc8\u4568\uc33b\u4aca", 9974764, -796526430)) != null) {
            System.out.println(String.format(Locale.ROOT, a.d("\ub321\uca81\u4042\ude3a\u55a1\ud371\u6936\ue0c0\u7e8c\uf45c\u73dc\u89aa\u0768\u9eca\u149f\u923a\u2821\ua7b9\u3d12\ubb02\u32b1\u48b9\uc612\u5dd5\udbe0\u5129\ue891\u66df\ufc7f\u7a68\uf188\u0f4f\u850b\u1ce0\u9afa\u1053\uaf8f\u25e1\ua365\u3a92\ub081\uce7d\u443c\uc38a\u5914\ud77d\u6ea5\ue40b\u6213", -571099507, -2046622215), fra, Float.valueOf(clientPlayerEntity.getYaw()), Float.valueOf(vxr.getFloat(fpv, clientPlayerEntity, Float.NaN)), Float.valueOf(clientPlayerEntity.lastYaw)));
        }
        while ((n = fqx.poll()) != null) {
            frt = n;
            fru = !clientPlayerEntity.isOnGround() && clientPlayerEntity.fallDistance > 0.0;
            int n3 = n2;
            fsw[n3] = fsw[n3] + 1;
            if (!fru) continue;
            int n4 = n2;
            fsx[n4] = fsx[n4] + 1;
        }
        double d = clientPlayerEntity.getY() - clientPlayerEntity.lastY;
        boolean bl = clientPlayerEntity.isOnGround();
        frq = !bl && d < 0.0 ? ++frq : 0;
        for (fpc fpc2 : fqz) {
            if (fpc2.land >= 0 || !bl) continue;
            fpc2.land = fra - fpc2.tick;
        }
        if (frp && !bl && d > 0.0) {
            fpo.ftu(n2);
            frr = 0;
            frs = false;
            int n5 = n2;
            fsn[n5] = fsn[n5] + 1;
        }
        frp = bl;
        HitResult hitResult = minecraftClient.crosshairTarget;
        boolean bl2 = hitResult != null && hitResult.getType() == HitResult.Type.ENTITY && ((EntityHitResult)hitResult).getEntity() == entity;
        boolean bl3 = clientPlayerEntity.getAttackCooldownProgress(0.5f) > 0.9f;
        boolean bl4 = frw = bl2 && bl3;
        if (fpt && frw) {
            frx = String.format(Locale.ROOT, a.d("\u05a6\u7c5e\uf695\u68a5\ue336\u65c0\udf86\u566a\uc82f\u4285\uc55c\u3f74\ub1bb\u285c\ua25c\u24eb\u9ea3\u117f\u8bcc\u0da5\u846f\ufe34\u708f\ueb08\u6d6f\ue7ff\u5e08\ud01d\u4af7\ucce2\u4749\ub993\u33c1\uaa65\u2c70\ua687\u1957\u932b\u15f8\u8c18\u065f\u78a5\uf2ea\u750f\uef9e\u61b9\ud865\u5290\ud4c7\u4f1d\uc173\u3bf7\ub206\u3404\uaef4\u20a7\u9b03\u1dd5\u97bc\u0e4a\u80cb\ufa91\u7d78\uf760\u69b7\ue050\u5a50\udce2\u56be\uc906\u43c6\uc5a2\u3c7f\ub696\u28dd\ua327\u256c\u9f89\u161c\u8826\u02ec\u84bc\uff03\u71da\uebfb\u6232\ue4c0\u5ed5\ud169\u4b34\ucd86\u444d\ube2f\u30fc\uab58\u2d40\ua797\u19a7", 1871305566, 49798894), fra, bl, frq, d, clientPlayerEntity.fallDistance, clientPlayerEntity.getVelocity().y, wdt.serverSprinting(clientPlayerEntity), Float.valueOf(clientPlayerEntity.getAttackCooldownProgress(0.5f)), fra - frt, fsa < 0 ? -1 : fra - fsa);
        }
        if (bl2) {
            int n6 = n2;
            fte[n6] = fte[n6] + 1;
            if (!bl && bl3) {
                frs = true;
            }
            if (frz >= 5) {
                fpo.ftv(n2);
                fsa = fra;
                fsb = bl3;
                fsc = false;
                int n7 = n2;
                fss[n7] = fss[n7] + 1;
                if (bl3) {
                    int n8 = n2;
                    fst[n8] = fst[n8] + 1;
                }
            }
            frz = 0;
        } else if (++frz == 5) {
            fpo.ftv(n2);
        }
        if (entity instanceof LivingEntity) {
            object2 = (LivingEntity)entity;
            v7 = object2.getHealth();
        } else {
            v7 = f = 0.0f;
        }
        if (frv >= 0.0f && f < frv - 0.01f && (object2 = fpo.fts(fra)) != null && ((fpc)object2).damage == 0.0f) {
            ((fpc)object2).damage = frv - f;
        }
        frv = f;
        while ((object2 = fqw.poll()) != null) {
            fpc fpc3 = fpo.fts((Integer)object2);
            if (fpc3 == null) continue;
            fpc3.seenCrit = true;
        }
        long l = System.nanoTime();
        while ((fpf2 = fqu.peek()) != null) {
            fqu.poll();
            object = fpo.ftt(fpf2.fpg);
            if (object == null || ((fpc)object).serverCrit != null) continue;
            ((fpc)object).serverCrit = fpf2.fph;
            if (!((fpc)object).clientCrit || fpf2.fph) continue;
            System.out.println(String.format(Locale.ROOT, a.d("\uc2df\ubb7f\u31bc\uafc4\u245f\ua2ad\u18f1\u9105\u0f56\u85ec\u0225\uf80d\u7694\uef34\u657c\ue390\u598b\ud608\u4cac\ucaf2\u430a\u395d\ub7f9\u2c39\uaa47\u20c8\u9961\u1776\u8d86\u0bda\u8069\u7e80\uf4f2\u6d09\ueb52\u61b5\ude7a\u544a\ud2dd\u4b20\uc172\ubf8c\u35d5\ub23d\u28f2\ua6c2\u1f55\u95a7\u13e3\u883b\u065b\ufc9f\u752a\uf323\u69c8\ue792\u5c31\udab4\u5081\uc903\u47a2\u3de4\uba13\u3051\uae89\u276a\u9d7f\u1b89\u91d3\u0e62\u84e0\u0289\ufb5d\u71f1\ueff7\u6440\ue250\u58f4\ud13a\u4f51\uc585\u43de\u3834\ub6fd\u2cdc\ua55e\u23be\u99ec\u1611\u8c5b\u0aef\u8324\u791a\uf7d3\u6c36\uea34\u60b8\udec2\u5718\ucdba\u4bf8\uc00b\ube00\u34a9\uad7d\u2b10\ua197", 350081476, 2074678036), ((fpc)object).fallTick, ((fpc)object).land, Float.valueOf(((fpc)object).charge), fpf2.fpj, fpf2.fpk, fpf2.fpl, Float.valueOf(fpf2.fpi)));
        }
        while ((object = fqv.peek()) != null) {
            fqv.poll();
            fpc fpc4 = fpo.ftt(((foo)object).fop);
            if (fpc4 == null) continue;
            fpc4.serverDamage += ((foo)object).foq;
        }
        while (!fqz.isEmpty() && fra - fpo.fqz.peekFirst().tick > 40 && l - fpo.fqz.peekFirst().nanos > 1000000000L) {
            fqz.pollFirst();
        }
    }

    private static double ftp(String string, double d) {
        return fpo.ftq(string, d, 0);
    }

    private static double ftq(String string, double d, int n) {
        String string2 = System.getenv(string);
        if (string2 == null) {
            return d;
        }
        String[] stringArray = string2.split(a.d("\u2e3c", -1031349015, 690811640));
        return Double.parseDouble(stringArray[Math.min(n, stringArray.length - 1)].trim());
    }

    private static void ftr(MinecraftClient minecraftClient, Entity entity) {
        Object object;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!fre || entity.getId() != frb || clientPlayerEntity == null) {
            return;
        }
        HitResult hitResult = minecraftClient.crosshairTarget;
        if (hitResult instanceof EntityHitResult && (object = (EntityHitResult)hitResult).getEntity() == entity) {
            hitResult = entity.getBoundingBox();
            fqj.add((object.getPos().y - hitResult.minY) / (hitResult.maxY - hitResult.minY));
        }
        object = new fpc();
        object.phase = frf;
        object.tick = fra;
        object.nanos = System.nanoTime();
        object.charge = clientPlayerEntity.getAttackCooldownProgress(0.5f);
        object.sprintSent = wdt.serverSprinting(clientPlayerEntity);
        object.clientCrit = object.charge > 0.9f && clientPlayerEntity.fallDistance > 0.0 && !clientPlayerEntity.isOnGround() && !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.hasStatusEffect(StatusEffects.BLINDNESS) && !clientPlayerEntity.hasVehicle() && !object.sprintSent;
        object.fallTick = frq;
        fry = fra;
        object.sinceKnock = fra - frt;
        object.midAirKnock = fru;
        fqy.add((fpc)object);
        fqz.add((fpc)object);
        ++frr;
        if (fsa >= 0 && !fsc) {
            fsc = true;
            if (fsb) {
                int n = fra - fsa;
                int[] nArray = fsv[object.phase];
                int n2 = n <= 0 ? 0 : (n == 1 ? 1 : (n == 2 ? 2 : (n <= 5 ? 3 : 4)));
                nArray[n2] = nArray[n2] + 1;
            }
            int n = object.phase;
            fsu[n] = fsu[n] + 1;
        }
    }

    private static fpc fts(int n) {
        fpc fpc2 = null;
        for (fpc fpc3 : fqz) {
            if (fpc3.tick > n || n - fpc3.tick > 8) continue;
            fpc2 = fpc3;
        }
        return fpc2;
    }

    private static fpc ftt(long l) {
        fpc fpc2 = null;
        for (fpc fpc3 : fqz) {
            if (fpc3.nanos > l || l - fpc3.nanos >= 400000000L) continue;
            fpc2 = fpc3;
        }
        return fpc2;
    }

    private static void ftu(int n) {
        if (n < 0 || fsn[n] == 0) {
            return;
        }
        if (frr > 0) {
            int n2 = n;
            fso[n2] = fso[n2] + 1;
        }
        if (frr > 1) {
            int n3 = n;
            fsp[n3] = fsp[n3] + 1;
        }
        if (frs) {
            int n4 = n;
            fsq[n4] = fsq[n4] + 1;
            if (frr > 0) {
                int n5 = n;
                fsr[n5] = fsr[n5] + 1;
            }
        }
    }

    private static void ftv(int n) {
        if (fsa >= 0 && fsb && !fsc && n >= 0) {
            int[] nArray = fsv[n];
            nArray[5] = nArray[5] + 1;
        }
        fsa = -1;
    }

    private static void ftw() {
        for (fpc fpc2 : fqy) {
            boolean bl;
            if (fpc2.sinceKnock < 0 || fpc2.sinceKnock > 15 || !(bl = fpc2.serverCrit != null ? fpc2.serverCrit : fpc2.seenCrit)) continue;
            int n = fpc2.phase;
            fsy[n] = fsy[n] + 1;
            int n2 = fpc2.phase;
            fsz[n2] = fsz[n2] + fpc2.sinceKnock;
            if (!fpc2.midAirKnock || fpc2.sinceKnock > 2) continue;
            int n3 = fpc2.phase;
            fta[n3] = fta[n3] + 1;
        }
    }

    private static void ftx(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, fot fot2, int n) {
        int n2;
        System.arraycopy(fsd, 0, fsd, 1, fsd.length - 1);
        fpo.fsd[0] = entity.getEntityPos();
        for (n2 = 1; n2 < fsd.length; ++n2) {
            if (fsd[n2] != null) continue;
            fpo.fsd[n2] = fsd[0];
        }
        if (--fsh <= 0) {
            fsh = 6 + fro.nextInt(14);
            fsf = (fro.nextFloat() - 0.5f) * 0.5f;
            fsg = 0.8f + fro.nextFloat() * 0.8f;
            fse = 0.7f + fro.nextFloat() * 0.6f;
        }
        n2 = 2 + fro.nextInt(2);
        Vec3d vec3d = fsd[n2];
        Vec3d vec3d2 = fsd[n2].subtract(fsd[n2 + 1]);
        Vec3d vec3d3 = vec3d.add(vec3d2.multiply((double)n2 * 0.6));
        Vec3d vec3d4 = clientPlayerEntity.getEyePos();
        double d = vec3d3.x - vec3d4.x;
        double d2 = vec3d3.z - vec3d4.z;
        double d3 = Math.max(0.001, Math.sqrt(d * d + d2 * d2));
        double d4 = -d2 / d3;
        double d5 = d / d3;
        double d6 = vec3d3.x + d4 * (double)fsf - vec3d4.x;
        double d7 = vec3d3.z + d5 * (double)fsf - vec3d4.z;
        double d8 = vec3d3.y + (double)fsg - vec3d4.y;
        float f = (float)(MathHelper.atan2((double)d7, (double)d6) * 57.2957763671875) - 90.0f;
        float f2 = (float)(-(MathHelper.atan2((double)d8, (double)Math.sqrt(d6 * d6 + d7 * d7)) * 57.2957763671875));
        if (fsi > 0) {
            --fsi;
            f += fsk;
        } else if (--fsj <= 0) {
            fsj = 90 + fro.nextInt(120);
            fsi = 5 + fro.nextInt(10);
            fsk = (float)(fro.nextBoolean() ? 1 : -1) * (35.0f + fro.nextFloat() * 40.0f);
        }
        float f3 = fot2.foz * fse;
        float f4 = MathHelper.wrapDegrees((float)(f - clientPlayerEntity.getYaw()));
        float f5 = f2 - clientPlayerEntity.getPitch();
        float f6 = MathHelper.clamp((float)(f4 * 0.55f), (float)(-f3), (float)f3) + (float)fro.nextGaussian() * 0.35f;
        float f7 = MathHelper.clamp((float)(f5 * 0.35f), (float)(-f3 * 0.6f), (float)(f3 * 0.6f)) + (float)fro.nextGaussian() * 0.2f;
        clientPlayerEntity.changeLookDirection((double)(f6 / 0.15f), (double)(f7 / 0.15f));
        double d9 = Math.sqrt(f6 * f6 + f7 * f7);
        int n3 = n;
        ftb[n3] = ftb[n3] + d9;
        fpo.ftc[n] = Math.max(ftc[n], d9);
        int n4 = n;
        ftd[n4] = ftd[n4] + 1;
        fth.add(d9);
    }

    private static void fty(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, boolean bl) {
        double d = entity.getX() - clientPlayerEntity.getX();
        double d2 = entity.getZ() - clientPlayerEntity.getZ();
        double d3 = Math.sqrt(d * d + d2 * d2);
        if (--fsl <= 0) {
            fsl = 15 + fro.nextInt(30);
            fsm = fro.nextInt(3) - 1;
        }
        boolean bl2 = Math.abs(clientPlayerEntity.getX() - fri) > 12.0 || Math.abs(clientPlayerEntity.getZ() - frk) > 12.0;
        minecraftClient.options.forwardKey.setPressed(d3 > 2.6);
        minecraftClient.options.backKey.setPressed(d3 < 1.4);
        minecraftClient.options.leftKey.setPressed(!bl2 && fsm < 0);
        minecraftClient.options.rightKey.setPressed(!bl2 && fsm > 0);
        minecraftClient.options.jumpKey.setPressed(bl);
    }

    private static void ftz(MinecraftClient minecraftClient) {
        minecraftClient.options.forwardKey.setPressed(false);
        minecraftClient.options.backKey.setPressed(false);
        minecraftClient.options.leftKey.setPressed(false);
        minecraftClient.options.rightKey.setPressed(false);
        minecraftClient.options.jumpKey.setPressed(false);
    }

    private static Entity fua(MinecraftClient minecraftClient) {
        Object object;
        if (frb >= 0 && (object = minecraftClient.world.getEntityById(frb)) != null) {
            return object;
        }
        for (PlayerEntity playerEntity : minecraftClient.world.getPlayers()) {
            if (!a.b("\u312d\u48b6\uc266\u5c0f\ud7ed\u5171\ueb39", 1180709228).equals(playerEntity.getGameProfile().name())) continue;
            frb = playerEntity.getId();
            return playerEntity;
        }
        return null;
    }

    private static void fub(MinecraftClient minecraftClient) {
        if (frg) {
            return;
        }
        frg = true;
        ClientTickEvents.START_CLIENT_TICK.register(fpo::fto);
        AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
            if (world.isClient()) {
                fpo.ftr(MinecraftClient.getInstance(), entity);
                return ActionResult.PASS;
            }
            if (!fre || entity.getId() != fnq.spawned || !playerEntity.getUuid().equals(frd)) {
                return ActionResult.PASS;
            }
            float f = playerEntity.getAttackCooldownProgress(0.5f);
            boolean bl = f > 0.9f && playerEntity.fallDistance > 0.0 && !playerEntity.isOnGround() && !playerEntity.isClimbing() && !playerEntity.isTouchingWater() && !playerEntity.hasVehicle() && !playerEntity.isSprinting();
            fqu.add(new fpf(System.nanoTime(), bl, f, playerEntity.fallDistance, playerEntity.isOnGround(), playerEntity.isSprinting()));
            return ActionResult.PASS;
        });
        ServerLivingEntityEvents.AFTER_DAMAGE.register((livingEntity, damageSource, f, f2, bl) -> {
            if (fre && livingEntity.getId() == fnq.spawned) {
                fqv.add(new foo(System.nanoTime(), f2));
            }
        });
        wcn.listen(packet -> {
            EntityVelocityUpdateS2CPacket entityVelocityUpdateS2CPacket;
            EntityAnimationS2CPacket entityAnimationS2CPacket;
            if (packet instanceof EntityAnimationS2CPacket && (entityAnimationS2CPacket = (EntityAnimationS2CPacket)packet).getEntityId() == frb && entityAnimationS2CPacket.getAnimationId() == 4) {
                fqw.add(fra);
            } else if (packet instanceof EntityVelocityUpdateS2CPacket && (entityVelocityUpdateS2CPacket = (EntityVelocityUpdateS2CPacket)packet).getEntityId() == frc && fre) {
                fqx.add(fra);
            }
        });
    }

    /*
     * Exception decompiling
     */
    private static void fuc() {
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

    private static void fud() {
        int n;
        StringBuilder stringBuilder = new StringBuilder(a.d("\ubfcb\uc662\u4cb8\ud2db\u591a\udfe2\u65e9\uec05\u7250\uf8e9\u7f7d\u8543\u0b9b\u922f\u1870\u9e8a\u24df\uab39\u31bb\ub7f1\u3e1b\u4412\ucafe\u5139\ud751\u5d84\ue424\u6a62\uf0a4\u76c4\ufd6c\u03a0\u89b7\u1019\u965c\u1ced\ua331\u296d\uaf8f\u3625\ubc67\uc2ce\u48d2\ucf68\u55b6\udbd4\u6212\ue8a1\u6ea7\uf53c\u7b48\u8194\u0823\u8e4a\u1484\u9adf\u2168\ua7fe\u2dcd\ub411\u3aa9\u40f2\uc749\u4d47\ud392\u5a24\ue07a\u668d\uecf4\u7360\uf9b2\u7fcf\u8618\u0cee\u92fc\u1909\u9f53\u25c7\uac3c\u3256\ub8a0\u3ed4\u4566\ucbbb\u51c4\ud852\u5ebe\ue4ec\u6b11\uf15b\u77ef\ufe24\u0474\u8a93\u112b\u9760\u1df7\ua3ce\u2a18\ub0a5\u36fe\ubd09\uc358\u49a0\ud020\u5647\udc83\u6336\ue972\u6f94\uf5f1\u7c65\u82a6\u08fb\u8f0e\u155d\u9b85", 66781281, 247185327));
        int[] nArray = new int[8];
        for (int i = 0; i < fpq.length; ++i) {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            n = 0;
            double d2 = 0.0;
            int n9 = 0;
            double d3 = 0.0;
            int n10 = 0;
            double d4 = 0.0;
            double d5 = 0.0;
            float f = 1.0f;
            int[] nArray2 = new int[8];
            for (fpc fpc2 : fqy) {
                if (fpc2.phase != i) continue;
                ++n2;
                d5 += (double)fpc2.charge;
                f = Math.min(f, fpc2.charge);
                if (fpc2.clientCrit) {
                    ++n3;
                    int n11 = Math.min(7, fpc2.fallTick);
                    nArray2[n11] = nArray2[n11] + 1;
                }
                if (fpc2.serverCrit != null) {
                    ++n5;
                    if (fpc2.serverCrit.booleanValue()) {
                        ++n4;
                    } else if (fpc2.clientCrit) {
                        ++n;
                    }
                }
                if (fpc2.seenCrit) {
                    ++n6;
                }
                if (fpc2.clientCrit && fpc2.land >= 1 && fpc2.land <= 2) {
                    ++n7;
                    if (Boolean.FALSE.equals(fpc2.serverCrit)) {
                        ++n8;
                    }
                }
                if (fpc2.damage > 0.0f) {
                    if (fpc2.seenCrit) {
                        d2 += (double)fpc2.damage;
                        ++n9;
                    } else {
                        d3 += (double)fpc2.damage;
                        ++n10;
                    }
                }
                d4 += (double)fpc2.serverDamage;
                stringBuilder.append(String.format(Locale.ROOT, a.d("\uccc4\ub523\u3faf\ua1d7\u2a41\uacb8\u16e2\u9f45\u0145\u8bfd\u0c78\uf656\u7888\ue16f\u6b63\ued9b\u57df\ud813\u42f5\uc4ee\u4d10\u3700\ub9fb\u2223\ua41d\u2e84\u973e\u192e\u8391\u05c9\u8e2c\u70a2\ufae4\u6343\ue54f\u6ff7\ud02b\u5a46\udcc1\u453a\ucf6c\ub196\u3bd9\ubc3c\u26a8\ua892", -497618652, -1150140949), fpo.fpq[i].fou, fpc2.tick, fpc2.clientCrit, fpc2.serverCrit, fpc2.seenCrit, Float.valueOf(fpc2.charge), fpc2.fallTick, fpc2.land, fpc2.sinceKnock, fpc2.midAirKnock, fpc2.sprintSent, Float.valueOf(fpc2.damage), Float.valueOf(fpc2.serverDamage)));
            }
            nArray[0] = nArray[0] + n2;
            nArray[1] = nArray[1] + n3;
            nArray[2] = nArray[2] + n4;
            nArray[3] = nArray[3] + n6;
            nArray[4] = nArray[4] + n;
            double d6 = (double)fpo.fpq[i].fov / 20.0;
            System.out.println(String.format(Locale.ROOT, a.c(-1462789481, "\u9a85\ue325\u69e6\uf79e\u7c05\ufab1\u40b4\uc90c\u5749\uddb0\u5a62\ua00e\u2ede\ub721\u3d6a\ubbda\u01d1\u8e08\u14b6\u92ec\u1b07\u6102\ueff8\u7475\uf250\u7888\uc178\u4f38\ud5d4\u5398\ud87f\u26ed\uacad\u3559\ub306\u39bc\u8671\u0c49\u8a82\u1372\u9969\ue7cb\u6d8e\uea3f\u70e3\ufec1\u470a\ucdfa\u4bf1\ud073\u5e16\ua4d0\u2d63\uab21\u31c5\ubfdb\u047c\u82ec\u08d4\u910f\u1ff9\u65ec\ue24d\u680b\uf6cb\u7f75\uc520\u43c6\uc980\u5630\udcba\u5ad3\ua34d\u29b8\ub7a7\u3c5b\uba19\u00b9\u8932\u175b\u9dd5\u1bc0\u603f\ueee3\u7481\ufd41\u7bd1\uc1a7\u4e50\ud404\u52e6\udb2f\u2119\uaf8c\u347c\ub226\u38e0\u8682\u0f44\u95f7\u13e5\u9855\ue611\u6cb1\uf534\u735d\uf985\u4629\ucc2b\u4a9c\ud082\u5937\ua7ff\u2dfd\uaa16\u304c\ubee6\u0762"), fpo.fpq[i].fou, n2, (double)n2 / d6, n3, n6, n4, n5, n, n7, n8, n2 == 0 ? 0.0 : d5 / (double)n2, Float.valueOf(f)));
            System.out.println(String.format(Locale.ROOT, a.b("\u19a7\u6007\ueac4\u74bc\uff27\u7993\uc396\u4a2e\ud46b\u5e9e\ud948\u2335\uadee\u3459\ube08\u38bc\u82b0\u0d70\u97d8\u1194\u9837\ue227\u6c83\uf743\u7166\ufbaf\u4217\ucc5a\u56f9\ud0ee\u5b55\ua589\u2f87\ub63b\u3061\uba80\u054b\u8f37\u09ec\u905a\u1a4b\u64fb\ueebf\u691f\uf392\u7dfb\uc423\u4e8e\uc895\u5302\udd79\u27a5\uae53\u284f\ub2b5\u3cb7\u871e\u01d8\u8baf\u126d\u9ccd\ue6ce\u6169\ueb23\u75f7\ufc53\u460d\uc0ad\u4ae2\ud558\u5f94\ud9b2\u202b\uaa9a\u348a\ubf6a\u3926\u838a\u0a0d\u943a\u1ef2\u98ae\ue31d\u6d80\uf7a3\u7e6f\uf8d6\u428f\ucd3b\u5722\ud190\u585b\ua22b\u2cb3\ub718\u311f", -988735069), fpo.fpq[i].fou, n9 == 0 ? 0.0 : d2 / (double)n9, n9, n10 == 0 ? 0.0 : d3 / (double)n10, n10, d4, Arrays.toString(Arrays.copyOfRange(nArray2, 1, 8))));
            if (fpo.fpq[i].fow) {
                System.out.println(String.format(Locale.ROOT, a.c(2057705984, "\u1a34\u6394\ue957\u772f\ufcb4\u7a00\uc005\u49bd\ud7f8\u5d03\udacf\u20a6\uae6c\u37de\ubdc3\u3b2a\u8124\u0eb1\u9455\u121a\u9bf0\ue1bd\u6f46\uf4df\u72a1\uf86d\u4197\ucfde\u5568\ud37d\u588a\ua650\u2c05\ub5e3\u33be\ub906\u0689\u8ce0\u0a72\u9387\u1984\u6729\ued30\u6a9e\uf051\u7e3d\uc7ed\u4d0f\ucb17\u50d8\udeb6\u247b\uad84\u2b94\ub126\u3f34\u8480\u0258\u8824\u11f8\u9f49\ue540\u62ab\ue8bb\u7630\uffc9\u459b\uc377\u4969\ud6c0\u5c52\uda67\u23b0\ua90c\u3754\ubcbb\u3aba\u8048\u099b\u97e6"), fpo.fpq[i].fou, fsn[i], fso[i], fsp[i], fsq[i], fsr[i], fsq[i] == 0 ? 0.0 : 100.0 * (double)fsr[i] / (double)fsq[i]));
            }
            int[] nArray3 = fsv[i];
            System.out.println(String.format(Locale.ROOT, a.d("\u97dd\uee7d\u64be\ufac6\u715d\uf7e9\u4dec\uc454\u5a11\ud0e3\u573c\uad4c\u2381\uba25\u3074\ub692\u0cda\u8345\u19ee\u9ffe\u164d\u6c5f\ue2e7\u793f\uff53\u7597\ucc26\u4276\ud8d8\u5e91\ud563\u2bf6\ua1f1\u3801\ube4f\u34b7\u8b78\u0148\u87df\u1e3c\u9474\uea81\u60d0\ue776\u7dbc\uf3cb\u4a19\uc0ee\u46ea\udd30\u534a\ua988\u202a\ua679\u3c8b\ub297\u0921\u8fe0\u05d7\u9c4f\u12e0\u68f0\uef47\u6507\ufb8d\u7275\uc83e\u4e8e\uc49d\u5b3e\ud1ab\u5793\uae54\u24a4\ubab3\u3151\ub718\u0db1\u8423\u1a1b\u90cc\u16dc\u6d2b\ue3ec\u7986\uf008\u76f2\uccbb\u4305\ud910\u5fed\ud63d\u2c4b\ua291\u397a\ubf33\u35bd", -1134097524, 255237204), fpo.fpq[i].fou, fss[i], fst[i], fsu[i], nArray3[0], nArray3[1], nArray3[2], nArray3[3], nArray3[4], nArray3[5]));
            System.out.println(String.format(Locale.ROOT, a.b("\u5b71\u22d1\ua812\u366a\ubdf1\u3b45\u8140\u08f8\u96bd\u1c47\u9b91\u61e1\uef3a\u7683\ufcd9\u7a2b\uc066\u4fbf\ud514\u530b\udae4\ua0f4\u2e03\ub59f\u33e4\ub938\u008e\u8ed7\u143b\u9225\u198e\ue71e\u6d15\uf4b6\u72f2\uf845\u4783\ucde9\u4b27\ud291\u5895\u2670\uac22\u2b9f\ub14c\u3f7c\u86f2\u0c57\u8a00\u1190\u9fa7\u6537\uec97\u6ad7\uf063\u7e76\uc5c8\u4310\uc96e\u50a7\ude54\ua41d\u23e5\ua9ab\u3733\ubec4\u04d1\u8227\u0862\u97d4\u1d53\u9b6f\u62b4\ue808\u765e\ufda7\u7beb\uc108\u4889\ud6ef\u5c26\uda66\ua1ce\u2f02\ub572\u3ced\uba46V\u8fed\u15e0\u930f\u1a9c\ue0e6\u6e2c\uf5cb\u73d2\uf91c\u4770\ucea4\u545b\ud214\u59a4\u27b3\uad41\u348f\ub2e5\u382b\u879d\u0d84\u8b6d\u117f", -851158150), fpo.fpq[i].fou, fsw[i], fsx[i], fsy[i], fsy[i] == 0 ? 0.0 : (double)fsz[i] / (double)fsy[i], fta[i], ftf[i], ftg[i]));
            System.out.println(String.format(Locale.ROOT, a.d("\u5628\u2f88\ua54b\u3b33\ub0a8\u361c\u8c19\u05a1\u9be4\u1114\u96cf\u6cba\ue220\u7bc5\uf197\u7761\ucd32\u42ad\ud85f\u5e19\ud7ff\uadf4\u235f\ub885\u3ee5\ub463\u0d96\u838a\u1971\u9f39\u14cf\uea06\u6042\uf9ac\u7fa8\uf55f\u4acc\uc0bc\u466d\udf94\u5590\u2b7c\ua125\u269c\ubc0c\u3271\u8be1\u0141\u8713\u1cde\u92ad\u6867\ue1d9\u6780\ufd68\u736b\uc89b\u4e4b\uc476\u5de5\ud35f\ua915\u2eb2\ua4e6\u3a22\ub38d\u0988\u8f3a\u056d\u9ad9\u1045\u963d\u6fa4\ue541\u7b0f\uf0f4\u76ab\ucc02", -685367455, 10045795), fpo.fpq[i].fou, ftd[i] == 0 ? 0.0 : ftb[i] / (double)ftd[i], ftc[i], ftd[i] == 0 ? 0.0 : 100.0 * (double)fte[i] / (double)ftd[i]));
        }
        fth.sort(Double::compare);
        double d7 = fth.isEmpty() ? 0.0 : fth.get((int)((double)fth.size() * 0.95));
        System.out.println(String.format(Locale.ROOT, a.d("\udaa7\ua307\u29c4\ub7bc\u3c27\ubae4\u00a0\u8947\u171e\u9db6\u1a7d\ue078\u6ee7\uf757\u7d19\ufbef\u41ee\uce27\u54d5\ud2c0\u5b74\u2134\uaf9c\u3450\ub228\u38aa\u815a\u0f04\u95f6\u13ab\u9813\u66d8\uecde\u7537\uf325\u79d0\uc654\u4c33\ucae0\u535a\ud956\ua7bf\u2dad\uaa58\u30dc\ubebb\u077f\u8dca\u0b96\u9050\u1e6c\ue4a5\u6d53\ueb46\u71e7\uffa1\u4411\uc2cf\u48ba\ud17c\u5fda\u258a\ua220\u2869\ub6e7\u3f12\u8500\u03f9\u89aa\u1656\u9cd5\u1aed\ue33e\u6987\uf7cc\u7c36\ufa7e\u4098\uc90d\u5738\uddf6\u5ba5\u205e\uaed4\u34be\ubd65\u3bde", -335628023, 156525469), nArray[0], nArray[1], nArray[3], nArray[2], nArray[4], d7));
        if (fpu != null) {
            fpy.sort(Double::compare);
            double d8 = fpy.isEmpty() ? 0.0 : fpy.get((int)((double)fpy.size() * 0.95));
            double d9 = fpy.isEmpty() ? 0.0 : fpy.get(fpy.size() - 1);
            double d10 = fpy.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println(String.format(Locale.ROOT, a.c(-862529067, "\ud9da\ua07a\u2ab9\ub4c1\u3f5a\ub98a\u03cd\u8a3b\u1477\u9ea7\u1971\ue356\u6dc8\uf463\u7e63\uf884\u42c0\ucd0b\u57ec\ud1e9\u581f\u2249\uace6\u3779\ub147\u3b81\u8223\u0c28\u96c7\u109d\u9b31\u65b7\uefbe\u761f\uf005\u7ab8\uc567\u4f0e\uc9d6\u5078\uda70\ua4c7\u2ed9\ua964\u33aa\ubd9e\u0455\u8eef\u08bf\u9339\u1d0c\ue799\u6e2f\ue87c\u72c7\ufccd\u476f\uc1b4\u4bcf\ud259\u5ce2\u26f0\ua101\u2b5c\ub59b\u3c3d\u867d\u00cd\u8adb\u157c\u9fb9\u19d0\ue056\u6aa1\uf4e6\u7f0a\uf95f\u43a3\uca32\u544e\ude9a\u589f\u2329\uadf3\u379a\ube1d\u38ed\u82bc\u0d4a\u9717\u11e5\u9823\u6245\uecd3\u7724\uf178\u7bad\uc5db\u4c1d\ud6a3\u50f9\udb0e\ua518\u2fac\ub678\u3015\uba92"), fpu, d10, d8, d9, fqh == 0 ? 0.0 : 100.0 * (double)fqg / (double)fqh, fqh == 0 ? 0.0 : fqi / (double)fqh));
            if (fqk) {
                System.out.println(String.format(Locale.ROOT, a.b("\u2b98\u5238\ud8fb\u4683\ucd18\u4bc8\uf18f\u7879\ue635\u6ce5\ueb59\u1121\u9ff6\u0621\u8c00\u0ae6\ub0bf\u3f68\ua5c2\u238b\uaa08\ud00d\u5ebf\uc569\u430a\uc9d0\u7062\ufe77\u64cf\ue297\u6924\u97b3\u1df9\u8449\u025e\u88bb\u3771\ubd04\u3bdf\ua278\u286e\u5685\udc85\u5b29\uc1f1\u4f91\uf641\u7cab\ufaf2\u612e\uef5b\u1590\u9c7c\u1a30\u80c9\u0e90\ub56d\u33a8\ub9c3\u2053\uaea0\ud4bf\u534d\ud907\u479c\uce6f\u743f\uf2cc\u7893\ue769\u6df3\ueb85\u1214\u98b0\u06ef\u8d07\u0b04\ub1a8\u3871\ua608\u2cdf\uaac0\ud16b\u5ffb\uc5c8\u4c58\ucafc\u70bc\uff04\u6517\ue3a7\u6a74\u900b\u1e91\u856b\u033d\u89bc\u37c8\ube10\u24be\ua2be\u2909\u570e\udda2\u4477\uc20e\u48c5\uf72b\u7d70\ufbcc\u6193\ue83b\u16ac\u9ca9\u1b5b\u810d\u0fa6\ub639\u3c0b\ubadd\u2170\uaf30\ud5d4\u53d7\uda2f\u40f7\uce84\u7513\uf359\u79e3\ue02f\u6e09\u9498\u136d\u993f\u07cc\u8ddb\u3431\ub2ff\u3884\ua75b", -1970459791), fqp, fqq, fqr, fqp - fqr == 0 ? 0.0 : fqt / (double)(fqp - fqr), fqs));
            }
            fqj.sort(Double::compare);
            if (!fqj.isEmpty()) {
                n = fqj.size();
                System.out.println(String.format(Locale.ROOT, a.c(1493683686, "\ucdd9\ub479\u3eba\ua0c2\u2b59\uad89\u17ce\u9e38t\u8aa4\u0d3f\uf74f\u7985\ue060\u6a7b\uec87\u56c4\ud91b\u43a7\uc5ea\u4c49\u3610\ub8bb\u237a\ua543\u2f91\u9622\u1862\u82cd\u0490\u8f32\u71f2\ufbe9\u6203\ue44f\u6ea7\ud163\u5b08\udd8b\u447b\uce25\ub0d9\u3a92\ubd28\u27e3\ua9c6\u1053\u9aaf\u1ce8\u8738\u0946\uf39f\u7a27\ufc25\u66ce\ue894\u5337\ud5b2\u5f87\uc606\u48f8\u32a0\ub55e\u3f17\ua1d3\u287e\u9279\u14ce\u9ed4\u0161\u8bb5\u0d97\uf450\u7eea\ue0a5\u6b00\ued11\u57ed\ude32\u405a\ucad0\u4c99\u3721\ub9ec\u23cf\uaa58\u2ca4\u96fc\u1945\u8311\u05e3"), fqj.get(n / 10), fqj.get(n / 2), fqj.get(n * 9 / 10), fqj.get(0), fqj.get(n - 1), n));
            }
            System.out.println(String.format(Locale.ROOT, a.b("\u5f7c\u26dc\uac1f\u3267\ub9fc\u3f2c\u856b\u0c9d\u92d1\u1801\u9f86\u65f6\ueb26\u728b\uf8c5\u7e67\uc436\u4beb\ud15a\u5706\udee9\ua4f9\u2a0e\ub1c1\u37b3\ubd61\u04df\u8a96\u1020\u9635\u1d98\ue343\u6908\uf0f4\u76bf\ufc4f\u43dc\uc9e2\u4f38\ud6cf\u5c95\u2225", 584474418), fpy.stream().filter(d -> d > 20.0).count(), fpy.stream().filter(d -> d > 30.0).count(), fpy.stream().filter(d -> d > 40.0).count(), fpy.size()));
            fpo.ftl();
            tiq tiq2 = kwf.studioProfile();
            if (tiq2 == null && System.getenv(a.d("\u4db2\u3409\ubed9\u20b0\uab02\u2dde\u9796\u1e76\u8039\u0a81\u8d41\u772e\uf9ed\u605b\uea1b\u6cf4\ud6b6\u5970\uc3c0", 1954468119, -476668688)) != null) {
                tiq2 = tiq.open(System.getenv(a.b("\u7bb3\u0208\u88d8\u16b1\u9d03\u1bdf\ua197\u2877\ub638\u3c80\ubb40\u412f\ucfec\u565a\udc1a\u5af5\ue0b7\u6f71\uf5c1", 1054702566)));
            }
            ArrayList<tmh> arrayList = new ArrayList<tmh>();
            if (tiq2 != null) {
                arrayList.addAll(tiq2.tapes());
            }
            for (String string : syq.report(fpz, fqa, arrayList)) {
                System.out.println(a.b("\u1b91\u6231\ue8f2\u768a\ufd11\u7bc1\uc186\u4870\ud63c\u5cec\udb72\u2101\uafcd\u3661\ubc34\u3ac4\u80c5", 1097866212) + string);
            }
        }
        try {
            Path path = Path.of(a.b("\ub652\ucfe9\u4539\udb50\u50c2\ud66c\u6c76\ue596\u7bd9\uf161\u76f0\u8ccc\u020b\u9bbf", 839693882), new String[0]);
            Files.writeString(path, (CharSequence)stringBuilder.toString(), StandardCharsets.UTF_8, new OpenOption[0]);
            System.out.println(a.c(-1571531035, "\u5688\u2f28\ua5eb\u3b93\ub008\u36fa\u8cb9\u054d\u9b44") + path.toAbsolutePath());
        }
        catch (IOException iOException) {
            System.out.println(a.b("\u3aef\u434f\uc98c\u57f4\udc6f\u5a9d\ue0de\u692a\uf723\u7dd4\ufa00y\u8eab\u1713\u9d41\u1bf4", 1235106459) + iOException);
        }
    }

    private static fot[] fue() {
        String string = System.getenv(a.b("\u4dd3\u3468\ubeb8\u20d1\uab63\u2dbf\u97f7\u1e17\u8058\u0ae0\u8d20\u7741\uf997\u6024\uea62", -531083878));
        if (string == null) {
            return fpp;
        }
        ArrayList<fot> arrayList = new ArrayList<fot>();
        for (String string2 : string.split(a.b("\u5556", 508253563))) {
            for (fot fot2 : fpp) {
                if (!fot2.fou.equals(string2.trim())) continue;
                arrayList.add(fot2);
            }
        }
        return arrayList.toArray(new fot[0]);
    }

    private static void fuf(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    static {
        fqj = new ArrayList<Double>();
        fqk = System.getenv(a.b("\uf493\u8d28\u07f8\u9991\u1223\u94ff\u2eb7\ua757\u3918\ub3a0\u3460\uce0f\u40cc\ud97a\u533a\ud5d5\u6f91\ue05b\u7ae0\ufcb1\u754d\u0f15", 37614787)) != null;
        fql = -1;
        fqo = -1;
        fqu = new ConcurrentLinkedQueue();
        fqv = new ConcurrentLinkedQueue();
        fqw = new ConcurrentLinkedQueue();
        fqx = new ConcurrentLinkedQueue();
        fqy = new ArrayList<fpc>();
        fqz = new ArrayDeque();
        frb = -1;
        frc = -1;
        frf = -1;
        fro = new Random(17L);
        frp = true;
        frt = -1000;
        frv = -1.0f;
        frx = "";
        fry = -1;
        frz = 99;
        fsa = -1;
        fsd = new Vec3d[12];
        fse = 1.0f;
        fsg = 1.2f;
        fsj = 80;
        fsn = new int[8];
        fso = new int[8];
        fsp = new int[8];
        fsq = new int[8];
        fsr = new int[8];
        fss = new int[8];
        fst = new int[8];
        fsu = new int[8];
        fsv = new int[8][6];
        fsw = new int[8];
        fsx = new int[8];
        fsy = new int[8];
        fsz = new int[8];
        fta = new int[8];
        ftb = new double[8];
        ftc = new double[8];
        ftd = new int[8];
        fte = new int[8];
        ftf = new int[8];
        ftg = new int[8];
        fth = new ArrayList<Double>();
    }

    private static /* synthetic */ int qu(int n, int n2) {
        return n * n2 | 0xD48AE4F5;
    }

    private static /* synthetic */ int qv(int n, int n2) {
        return fpo.qu(n, n2) + n;
    }

    private static /* synthetic */ int qw(int n, int n2) {
        return (n ^ n2) + 1728271675;
    }
}

