/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.fnq;
import a.gmx;
import a.gng;
import a.gnl;
import a.gno;
import a.kwf;
import a.vxr;
import a.vzz;
import a.wcn;
import flow.dev.a;
import java.lang.reflect.Field;
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
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class gnr {
    private static final gmx[] gns = new gmx[]{new gmx(a.b("\u4763\u3ed5\ub400\u2a62\ua1b2\u2700\u9d1b\u14b4\u8aecH\u8794\u7def", -1603254500), 500, 1, false, 0.0, false), new gmx(a.c(-271553502, "\u6c5a\u15ec\u9f39\u015b\u8a8b\u0c39\ub622\u3f94\ua1d4\u2b7d\uacb3"), 700, 1, true, 0.0, false), new gmx(a.b("\u7a69\u03db\u890a\u1760\u9cb0\u1a1b\ua011\u29a7\ub7e7\u3d4e\uba80", -732464623), 700, 2, true, 0.0, false), new gmx(a.b("\u88f7\uf145\u7b94\ue5fe\u6e2e\ue885\u528f\udb20\u4578\ucfdc\u4800\ub27b", 779323528), 500, 2, false, 0.0, false), new gmx(a.c(1187904512, "\ufc6c\u85d2\u0f0f\u9171\u1aba\u9c52\u2646\uafa8\u31ef\ubb43"), 700, 1, true, 0.7, false), new gmx(a.c(980985648, "\ua75c\udee2\u543f\uca41\u418a\uc762\u7d71\uf482\u6ac4\ue066"), 700, 1, true, 0.7, true), new gmx(a.b("\u954e\uecf0\u662d\uf853\u7398\uf570\u4f7d\uc68f\u58d2\ud278\u55ac\uafc7\u2149\ub8b8\u32e9\ub401\u0e5d", 880448825), 700, 2, true, 0.7, true), new gmx(a.d("\u948d\ued33\u67ee\uf990\u725b\uf4b3\u4ebe\uc74c\u5911\ud3bb\u546f\uae04\u208a\ub97c\u3330\ub5d9\u0f8b", 554932272, -1115484982), 700, 2, true, 1.0, false)};
    private static final gmx[] gnt = gnr.gph();
    private static final int gnu = 100;
    private static final int gnv = 20;
    private static final boolean gnw = System.getenv(a.d("\uc27d\ubbc6\u3116\uaf7f\u24cd\ua211\u1852\u91be\u0ff1\u854b\u0285\uf8ff\u7623\uef94\u65d4\ue327\u596e", -1010335564, 1053180574)) != null;
    private static final Field gnx = vxr.find(ClientPlayerEntity.class, a.b("\u3924\u409e\uca5c\u5477\udfe3\u5956\ue302\u6af8\uf4a1\u7e01\uf9c1\u03b7\u8d72\u1499\u9e87\u1879\ua23b\u2df8\ub74b\u3136\ub8a9\uc2fb\u4c4a", 1983723869), a.d("\ufed1\u876f\u0db0\u93c8\u1817\u9e9d\u24a2\uad59\u330b\ub9bf", -1441070749, 2063007710), a.d("\uae52", -49736635, 876264016));
    private static final Field gny = vxr.find(ClientPlayerEntity.class, a.b("\ubd0d\uc4b7\u4e75\ud05e\u5bca\udd7f\u672b\ueed1\u7088\ufa28\u7de8\u879e\u095b\u90b0\u1aae\u9c50\u2612\ua9d1\u3362\ub51f\u3c80\u46d2\uc863", 579059060), a.c(-266001706, "\u22ba\u5b04\ud1db\u4fa3\uc47c\u42f6\uf8c9\u7132\uef66\u65d0"), a.b("\u91b5", 1591316978));
    private static final gnl[] gnz = new gnl[gnt.length];
    private static final ConcurrentLinkedQueue<gng> goa = new ConcurrentLinkedQueue();
    private static final Random gob = new Random(23L);
    private static volatile boolean goc;
    private static volatile int god;
    private static volatile int goe;
    private static volatile UUID gof;
    private static volatile int gog;
    private static boolean goh;
    private static int goi;
    private static int goj;
    private static double gok;
    private static double gol;
    private static double gom;
    private static int gon;
    private static gno goo;
    private static int gop;
    private static boolean goq;
    private static boolean gor;
    private static boolean gos;
    private static boolean got;
    private static float gou;
    private static float gov;
    private static double gow;
    private static int gox;
    private static long goy;
    private static boolean goz;
    private static final Set<Integer> gpa;
    private static volatile int gpb;
    private static final ConcurrentLinkedQueue<Integer> gpc;
    private static int gpd;
    private static int gpe;
    private static /* synthetic */ boolean gpf;
    private static /* synthetic */ String gpg;

    private gnr() {
    }

    private static gmx[] gph() {
        String string = System.getenv(a.c(-234343922, "\u3258\u4be3\uc133\u5f5a\ud4e8\u5234\ue877\u619b\uffd4\u756e\uf2a0\u08da\u861d\u1fad\u95fc\u1318"));
        if (string == null || string.isBlank()) {
            return gns;
        }
        List<String> list = Arrays.asList(string.split(a.d("\ub651", 1411887142, -1141701030)));
        return (gmx[])Arrays.stream(gns).filter(gmx2 -> list.contains(gmx2.gmy)).toArray(gmx[]::new);
    }

    static boolean tick(MinecraftClient minecraftClient) {
        int n;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        gnr.gps();
        if (++goi == 1) {
            int n2 = MathHelper.floor((double)clientPlayerEntity.getX());
            int n3 = MathHelper.floor((double)clientPlayerEntity.getY());
            int n4 = MathHelper.floor((double)clientPlayerEntity.getZ());
            gok = (double)n2 + 0.5;
            gol = n3;
            gom = (double)n4 + 0.5;
            gof = clientPlayerEntity.getUuid();
            gpb = clientPlayerEntity.getId();
            gnr.gpt(minecraftClient, a.d("\u7c2e\u0599\u8f46\u113f\u9ae0\u1c53\ua60b\u2ffb\ub1e1\u3b03\ubcd6\u46a0\uc873\u51dd\udb91\u5d77\ue735", 1663005300, 1826295340));
            gnr.gpt(minecraftClient, a.c(811379863, "\uacef\ud543\u5f94\uc1ed\u4a7f\ucc9d\u76d8\uff38\u6133\uebc6\u6c10\u9679"));
            gnr.gpt(minecraftClient, a.c(14001628, "\ua5a6\udc05\u56d2\uc8b6\u437d\uc5c1\u7f85\uf626\u683a\ue284\u655e\u9f2b\u11ef"));
            gnr.gpt(minecraftClient, a.b("\uab0e\ud2bc\u586f\uc61d\u4dcc\ucb6a\u716d\uf8db\u668a\uec24\u6be4\u91d0\u1f67\u86e5\u0ce5\u8a46\u301e\ubfd9\u2570\ua33b\u2acb\u508f\ude33\u45ef\uc396\u4902\uf0a8\u7ef9\ue40e\u625f\ue9ec\u1724\u9d7f\u049a\u829d\u082a\ub7fa\u3d9b", 1253878605));
            gnr.gpt(minecraftClient, a.c(2028857967, "\uea2c\u939e\u194d\u873f\u0cee\u8a48\u304f\ub9f9\u27a8\uad06\u2ac6\ud0f2\u5e45\uc7c7\u4dc7\ucb65\u7138\ufefc\u644e\ue218\u6bfc\u11b8\u9f16\u04c1\u82bf\u0820\ub18a\u3fdb\ua52c\u237d\ua8ce\u5606\udc5d\u45b8\uc3bf\u4908\uf6d8\u7cb9"));
            gnr.gpt(minecraftClient, a.d("\ub1d2\uc86c\u42b6\udcc3\u5707\ud1e4\u6bd7\ue215", -755447717, 1036089826));
            gnr.gpt(minecraftClient, a.b("\ub0ed\uc95e\u4388\uddf9\u5662\ud0b3\u6ac5\ue30a\u7d7a\uf7c6\u701c\u8a78\u04f7\u9d5a\u1758\u91b5\u2bf7\ua43e\u3e91\ub8d7\u310f", -497045357));
            gnr.gpt(minecraftClient, a.b("\u8762\ufece\u740c\uea75\u61ef\ue70c\u5d48\ud4ac\u4aef\uc053\u4782\ubdf5\u3367\uaa93\u20cb\ua620\u1c72\u93be\u0900\u8f08\u069f\u7cfd\uf21d\u6984\ueffc\u6536\udc93\u52c1\uc825\u4e28\uc585\u3b44\ub15c\u28b3\uaefd\u2450\u9bcf\u11f3\u9724\u0e92\u84c6\ufa31\u7073\uf7d1\u6d01\ue362\u5aff\ud010\u5652\ucd8b\u43f4\ub927\u3091\ub6ca\u2c02\ua27f\u19c4\u9f0d\u1563\u8ca4", -142833865));
            gnr.gpt(minecraftClient, String.format(Locale.ROOT, a.d("\u0f5e\u76e0\ufc36\u6247\ue9dc\u6f68\ud57a\u5ccf\uc295\u4865\ucff2\u3586\ubb10\u22e5\ua8b3\u2e03\u9408\u1bdc\u812e\u073b\u8ec9\uf4d9\u7a2e\ue1b2\u67c9\ued1f\u54a7\udaf0\u4016\uc654\u4de0\ub323\u3922\ua08e\u26d6\uac6a\u13af\u99de\u1f5e\u86a7\u0cff\u720d\uf85e\u7fec\ue523", -1297874748, -321384495), n2 - 16, n3 - 1, n4 - 16, n2 + 16, n3 + 9, n4 + 16));
            gnr.gpt(minecraftClient, String.format(Locale.ROOT, a.b("\u26d2\u5f67\ud5e4\u4bf5\uc011\u46f3\ufca5\u755f\ueb1f\u61f9\ue66c\u1c18\u928e\u0b7b\u812d\u07d7\ubd87\u3201\ua8f4\u2ea8\ua74b\udd13\u53b0\uc871", 61023934), gok, n3, gom));
            clientPlayerEntity.getInventory().setSelectedSlot(0);
            return false;
        }
        if (goi == 8) {
            double d = gok + 2.7;
            minecraftClient.getServer().execute(() -> fnq.spawn((MinecraftServer)minecraftClient.getServer(), gof, d, gol, gom));
            return false;
        }
        if (goi == 40) {
            gnr.gpq();
        }
        if (goi < 100) {
            if (goi > 20) {
                gnr.gpr(minecraftClient);
            }
            return false;
        }
        wcn.ensure(minecraftClient);
        Entity entity = gnr.gpr(minecraftClient);
        if (entity == null) {
            System.out.println(a.c(-468677319, "\u8d40\uf4ec\u7e2f\ue055\u6b9f\ued7a\u577d\ude9d\u40d4\uca62\u4de5\ub7f2\u3922\ua09b\u2acd\uac50\u1651\u9981\u037d\u856e\u0c94\u76de"));
            return true;
        }
        if (minecraftClient.mouse.isCursorLocked()) {
            minecraftClient.mouse.unlockCursor();
        }
        int n5 = goi - 100;
        int n6 = 0;
        for (n = 0; n < gnt.length && n5 >= n6 + gnr.gnt[n].gmz; ++n) {
            n6 += gnr.gnt[n].gmz;
        }
        if (n >= gnt.length) {
            goc = false;
            fnq.active = false;
            fnq.orbit = 0;
            minecraftClient.options.jumpKey.setPressed(false);
            gnr.gpk(minecraftClient);
            gnr.gpp();
            return true;
        }
        gmx gmx2 = gnt[n];
        if (n != gog) {
            gnr.gpl();
            if (gor && gog >= 0) {
                gnr.gpo(gnz[gog]);
            }
            gor = false;
            gog = n;
            goj = goi;
            gnr.gnz[n] = new gnl();
            fnq.orbit = gmx2.gna;
            fnq.jumping = true;
            fnq.aggression = gmx2.gnc;
            fnq.active = true;
            fnq.orbitRadiusSum = 0.0;
            fnq.orbitTurnSum = 0.0;
            fnq.orbitTicks = 0;
            goo = null;
            gop = -1;
            goc = true;
            System.out.println(a.d("\uecf6\u955a\u1f99\u81e3\u0a29\u8ccc\u36cf\ubf26\u2170\uabd3\u2c16\ud622", 473211277, 670518552) + gmx2.gmy);
        }
        if (--gox <= 0) {
            gox = 30 + gob.nextInt(60);
            gow = (gob.nextDouble() - 0.5) * 6.0;
        }
        clientPlayerEntity.changeLookDirection(gow / 0.15, 0.0);
        minecraftClient.options.jumpKey.setPressed(gmx2.gnb && goi - goj >= 20);
        gnr.gpi(minecraftClient, clientPlayerEntity, entity, gmx2.gnd && goi - goj >= 20);
        float f = vxr.getFloat(gnx, clientPlayerEntity, clientPlayerEntity.getYaw());
        float f2 = vxr.getFloat(gny, clientPlayerEntity, clientPlayerEntity.getPitch());
        if (!Float.isNaN(gou) && goi - goj >= 20) {
            double d = MathHelper.wrapDegrees((float)(f - gou));
            double d2 = f2 - gov;
            gnr.gnz[n].turns.add(Math.sqrt(d * d + d2 * d2));
        }
        gou = f;
        gov = f2;
        return false;
    }

    private static void gpi(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, boolean bl) {
        double d;
        boolean bl2;
        gpa.clear();
        if (!bl) {
            gnr.gpj(minecraftClient.options.forwardKey, false);
            gnr.gpj(minecraftClient.options.backKey, false);
            gnr.gpj(minecraftClient.options.leftKey, false);
            gnr.gpj(minecraftClient.options.rightKey, false);
            vzz.simulated = gpa::contains;
            return;
        }
        double d2 = entity.getX() - clientPlayerEntity.getX();
        double d3 = entity.getZ() - clientPlayerEntity.getZ();
        double d4 = Math.max(0.001, Math.sqrt(d2 * d2 + d3 * d3));
        if (--gpd <= 0) {
            gpd = 15 + gob.nextInt(30);
            gpe = gob.nextInt(3) - 1;
        }
        boolean bl3 = bl2 = Math.abs(clientPlayerEntity.getX() - gok) > 11.0 || Math.abs(clientPlayerEntity.getZ() - gom) > 11.0;
        double d5 = d4 > 3.0 ? 1.0 : (d4 < 2.0 ? -1.0 : 0.0);
        double d6 = bl2 ? 0.0 : (double)gpe;
        double d7 = d2 / d4 * d5 + d3 / d4 * d6;
        double d8 = d3 / d4 * d5 - d2 / d4 * d6;
        if (bl2) {
            d7 = gok - clientPlayerEntity.getX();
            d8 = gom - clientPlayerEntity.getZ();
        }
        double d9 = Math.hypot(d7, d8);
        double d10 = 0.0;
        double d11 = 0.0;
        if (d9 > 1.0E-6) {
            d = Math.toRadians(clientPlayerEntity.getYaw());
            d10 = (d8 * Math.cos(d) - d7 * Math.sin(d)) / d9;
            d11 = (d7 * Math.cos(d) + d8 * Math.sin(d)) / d9;
        }
        d = Math.sin(Math.toRadians(22.5));
        gnr.gpj(minecraftClient.options.forwardKey, d10 > d);
        gnr.gpj(minecraftClient.options.backKey, d10 < -d);
        gnr.gpj(minecraftClient.options.leftKey, d11 > d);
        gnr.gpj(minecraftClient.options.rightKey, d11 < -d);
        vzz.simulated = gpa::contains;
    }

    private static void gpj(KeyBinding keyBinding, boolean bl) {
        keyBinding.setPressed(bl);
        if (bl) {
            gpa.add(KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding).getCode());
        }
    }

    private static void gpk(MinecraftClient minecraftClient) {
        minecraftClient.options.forwardKey.setPressed(false);
        minecraftClient.options.backKey.setPressed(false);
        minecraftClient.options.leftKey.setPressed(false);
        minecraftClient.options.rightKey.setPressed(false);
        vzz.simulated = null;
    }

    private static void gpl() {
        if (gog >= 0 && gnz[gog] != null) {
            gnl gnl2 = gnz[gog];
            gnl2.radius = fnq.orbitRadiusSum;
            gnl2.spin = fnq.orbitTurnSum;
            gnl2.orbitTicks = fnq.orbitTicks;
        }
    }

    private static void gpm(MinecraftClient minecraftClient) {
        gng gng2;
        ++god;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!goc || clientPlayerEntity == null || goe < 0 || gog < 0) {
            return;
        }
        Entity entity = minecraftClient.world.getEntityById(goe);
        if (entity == null) {
            return;
        }
        gnl gnl2 = gnz[gog];
        long l = System.nanoTime();
        if (goy != 0L && l - goy < 10000000L) {
            ++gnl2.bursts;
        }
        goy = l;
        while ((gng2 = goa.poll()) != null) {
            ++gnl2.serverHits;
            if (!gng2.gni) continue;
            ++gnl2.serverCrits;
            if (!gor) continue;
            goz = true;
        }
        while (gpc.poll() != null) {
            ++gnl2.knocks;
        }
        if (goo != null && gnr.goo.phase == gog) {
            gnr.gpn(goo, gon == gnr.goo.tick);
        }
        if (goi - goj < 20) {
            goo = null;
            return;
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Box box = entity.getBoundingBox();
        Vec3d vec3d2 = vec3d.add(clientPlayerEntity.getRotationVec(1.0f).multiply(3.0));
        gno gno2 = new gno();
        gno2.tick = god;
        gno2.phase = gog;
        gno2.charged = clientPlayerEntity.getAttackCooldownProgress(0.5f) > 0.9f;
        gno2.reach = box.squaredMagnitude(vec3d) <= 9.0;
        gno2.aimed = box.contains(vec3d) || box.raycast(vec3d, vec3d2).isPresent();
        gno2.ground = clientPlayerEntity.isOnGround();
        gno2.crit = !gno2.ground && clientPlayerEntity.fallDistance > 0.0;
        gno2.why = kwf.debug();
        double d = box.squaredMagnitude(vec3d);
        if (d <= 16.0) {
            ++gnl2.nearTicks;
            if (kwf.target() == null) {
                ++gnl2.lostTicks;
            }
        }
        if (d > 9.0) {
            ++gnl2.farTicks;
        }
        Vec3d vec3d3 = box.getCenter();
        double d2 = vec3d3.x - vec3d.x;
        double d3 = vec3d3.z - vec3d.z;
        gno2.yawErr = MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(d3, d2)) - 90.0 - (double)clientPlayerEntity.getYaw()));
        gno2.pitchErr = -Math.toDegrees(Math.atan2(vec3d3.y - vec3d.y, Math.hypot(d2, d3))) - (double)clientPlayerEntity.getPitch();
        if (goq && !gno2.ground && clientPlayerEntity.getVelocity().y > 0.0) {
            if (gor) {
                gnr.gpo(gnl2);
            }
            gor = true;
            gos = false;
            got = false;
            goz = false;
            ++gnl2.jumps;
        }
        goq = gno2.ground;
        goo = gno2;
    }

    private static void gpn(gno gno2, boolean bl) {
        gnl gnl2 = gnz[gno2.phase];
        ++gnl2.ticks;
        if (gno2.aimed) {
            ++gnl2.aimedTicks;
        }
        if (bl) {
            ++gnl2.hits;
            if (gor) {
                gos = true;
            }
        }
        if (gno2.crit && gno2.charged && gno2.reach && gor) {
            got = true;
        }
        if (gno2.charged && gno2.reach) {
            ++gnl2.ready;
            if (gop < 0) {
                gop = gno2.tick;
            }
            if (bl) {
                ++gnl2.readyHit;
            } else if (gno2.aimed) {
                ++gnl2.heldAimed;
                if (gno2.why.contains(a.b("\u94a8\ued08\u67c0\uf9ac\u7232", 2131989710)) && !gno2.why.contains(a.c(-728218298, "\u4522\u3c82\ub64a\u2826\ua3b8\u2519\u9f56")) && !gno2.why.contains(a.d("\u4aa2\u3302\ub9ca\u27a6\uac38\u2a84\u90c7", 665829965, 1223002251))) {
                    ++gnl2.heldCrit;
                } else {
                    ++gnl2.heldOther;
                }
            } else {
                ++gnl2.notAimed;
            }
        }
        if (bl && gop >= 0) {
            int n = gno2.tick - gop;
            int[] nArray = gnl2.wait;
            int n2 = n <= 0 ? 0 : (n == 1 ? 1 : (n == 2 ? 2 : (n <= 5 ? 3 : (n <= 10 ? 4 : (n <= 20 ? 5 : 6)))));
            nArray[n2] = nArray[n2] + 1;
            gop = -1;
        }
        if (gnw) {
            System.out.println(String.format(Locale.ROOT, a.b("\u96e3\uef4f\u658c\ufbf6\u703c\uf6d9\u4cde\uc566\u5b21\ud1d1\u5646\uac32\u22b3\ubb51\u3141\ub7bb\u0dfd\u823f\u1899\u9eca\u173c\u6d34\ue39f\u7818\ufe34\u74b7\ucd13\u4346\ud9b3\u5fe9\ud40f\u2ac6\ua0df\u397d\ubf6f\u35d6\u8a05|\u86ae\u1f46\u9501\ueba6\u61a6\ue650\u7c92\uf2fe\u4b37\uc19d\u47d8\udc50\u523b\ua8bc\u2158\ua74a\u3da8\ub3e2\u0840\u8ed8\u04b3\u9d34\u13d0\u69c0\uee26\u6477\ufaad\u731e\uc945\u4fe2\uc5ad\u5a4a\ud0ca\u56fe\uaf36\u2587\ubb9b\u3072\ub62e\u0c80\u8504\u1b3c\u91f9\u17a3\u6c0f\ue289\u78b8\uf16c\u7789", -34236709), gno2.tick, gnr.gnt[gno2.phase].gmy, gno2.charged, gno2.reach, gno2.aimed, gno2.ground, gno2.crit, bl, gno2.yawErr, gno2.pitchErr, gno2.why));
        }
    }

    private static void gpo(gnl gnl2) {
        if (gos) {
            ++gnl2.jumpsHit;
        }
        if (goz) {
            ++gnl2.jumpsCrit;
        }
        if (got) {
            ++gnl2.jumpsChance;
            if (gos) {
                ++gnl2.jumpsChanceHit;
            }
        }
    }

    private static void gpp() {
        gnr.gpl();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (int i = 0; i < gnt.length; ++i) {
            gnl gnl2 = gnz[i];
            if (gnl2 == null) continue;
            gnl2.turns.sort(Double::compare);
            double d = gnl2.turns.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double d2 = gnl2.turns.isEmpty() ? 0.0 : gnl2.turns.get((int)((double)gnl2.turns.size() * 0.95));
            double d3 = gnl2.turns.isEmpty() ? 0.0 : gnl2.turns.get(gnl2.turns.size() - 1);
            System.out.println(String.format(Locale.ROOT, a.b("\u6ca8\u1504\u9fc7\u01bd\u8a77\u0c92\ub6c4\u3f63\ua175\u2bde\uac45\u5635\ud8ff\u4149\ucb54\u4dbd\uf7b3\u7826\ue29d\u64c1\ued3d\u9770\u1997\u820f\u042c\u8ea7\u371d\ub91f\u23fe\ua5b8\u2e0f\ud0cd\u5a95\uc32b\u4560\ucf90\u7003\ufa31\u7cf3\ue559\u6f1b\u11ed\u9bf0\u1c59\u86cf\u08fa\ub175\u3b98\ubd85\u2643\ua834\u52e0\udb4a\u5d5f\uc7b4\u49a4\uf25f\u74c6\ufeb4\u6778\ue9f4\u9384\u144b\u9e2d\u00e6\u8952\u331c\ub5a9\u3fe6\ua016\u2a81\uacb8\u556a\udfd2\u4189\uca5d\u4c22\uf697\u7f4c\ue13c\u6baa\uede3\u9611\u1884\u82fb\u0b61\u8dc3\u3789\ub86b\u226e\ua48a\u2d4d\ud732\u59fe\uc219\u444d\ucec3\u70fa\uf925\u63db\ue597\u6e7a\u1024\u9a82\u030f\u857b\u0fe9\ub015\u3a4b\ubcf4\u26a6\uaf0c\u51f6\udb8f\u5c78\uc621\u4897\uf11f\u7b74\ufde4\u661f\ue812\u92bd\u14ad\u9d12\u07c7\u89bc\u326c\ub467\u3ed3\ua70b\u2964\ud3e5\u5417\ude44\u40b0\ucaa0\u7318\uf58d\u7fa8\ue062\u6ad9\uec82\u956b", -1608815529), gnr.gnt[i].gmy, gnl2.hits, gnl2.ticks == 0 ? 0.0 : (double)gnl2.hits * 20.0 / (double)gnl2.ticks, gnl2.serverHits, gnl2.serverCrits, gnl2.ready, gnl2.readyHit, gnl2.heldAimed, gnl2.heldCrit, gnl2.heldOther, gnl2.notAimed, gnl2.ticks == 0 ? 0.0 : 100.0 * (double)gnl2.aimedTicks / (double)gnl2.ticks));
            System.out.println(String.format(Locale.ROOT, a.b("\uccc2\ub56e\u3fad\ua1d7\u2a1d\uacf8\u16ae\u9f09\u011f\u8bb4\u0c30\uf657\u7888\ue124\u6b23\ued91\u57d5\ud80d\u42ad\uc4e9\u4d1c\u374c\ub9b6\u2274\ua45d\u2e8d\u9723\u1926\u83c1\u05d4\u8e2e\u70e7\ufae9\u635c\ue51e\u6fea\ud074\u5a1d\udc8f\u457a\ucf37\ub180\u3b9a\ubc33\u26a5\ua890\u1150\u9bff\u1da8\u8638\u0802\uf2cb\u7b3d\ufd28\u67cd\ue987\u5224\ud4f4\u5ec3\uc75b\u49f4\u33e4\ub453\u3e13\ua0dc\u2971\u933d\u15ce\u9fdd%\u8aee\u0cde\uf545\u7fe6\ue1b6\u6a5d\uec55\u56ad\udf66\u4156\ucbdd\u4dd0\u363f\ub8a4\u22cc\uab05\u2dab\u97f9\u1848\u8201\u04f3\u8d66\u7759\uf989\u6227\ue43f\u6ee8\ud0d8\u594f\uc3bd\u45fb\uce11\ub05f\u3aa7\ua360\u2550\uafc7\u1035\u9a69\u1c91\u86cd\u0f71\uf1b8\u7bb1\ufc5a\u664a\ue8b9\u512b\udb53\u5d8b\uc63b\u4867\u3292\ub4ee\u3d78\ua7b4\u298e\u9247\u1449", -1428698068), gnr.gnt[i].gmy, gnl2.wait[0], gnl2.wait[1], gnl2.wait[2], gnl2.wait[3], gnl2.wait[4], gnl2.wait[5], gnl2.wait[6], gnl2.jumps, gnl2.jumpsHit, gnl2.jumpsCrit, gnl2.jumpsChance, gnl2.jumpsChanceHit));
            System.out.println(String.format(Locale.ROOT, a.c(-1180507990, "\ue09b\u9937\u13f4\u8d8e\u0644\u80a1\u3af7\ub350\u2d46\ua7ed\u2075\uda01\u54d7\ucd6a\u4731\uc1c9\u7b85\uf456\u6eed\ue8a4\u611d\u1b54\u95a6\u0e33\u8810\u029d\ubb61\u352a\uafdc\u29d9\ua225\u5cfd\ud6f4\u4f57\uc913\u43a6\ufc73\u7609\uf092\u6926\ue372\u9d9d\u1798\u906a\u0abd\u84c9\u3d55\ub7ed\u31e4\uaa61\u240f\uded4\u576b\ud122\u4b82\uc58f\u7e6c\uf8e9\u728f\ueb4d\u65ef\u1fbc\u985e\u125b\u8cd8\u056a\ubf25\u39d3\ub3d0\u2c64\ua6f6\u20c3\ud953\u53eb\ucdfe\u460a\uc01c\u7ae9\uf36e\u6d02\ue7c7\u619e\u1a35\u94b7\u0e97\u8758\u01f6\ubbbb\u3445\uae13\u28ee\ua12b\u5b48\ud5d4"), gnr.gnt[i].gmy, gnl2.knocks, gnl2.ticks == 0 ? 0.0 : 100.0 * (double)gnl2.farTicks / (double)gnl2.ticks, gnl2.lostTicks, gnl2.nearTicks));
            System.out.println(String.format(Locale.ROOT, a.d("\uace6\ud54a\u5f89\uc1f3\u4a39\uccdc\u768a\uff2d\u613b\ueb90\u6c10\u9677\u18ab\u8100\u0b07\u8da2\u37ec\ub83a\u2295\ua48a\u2d3c\u577a\ud9d8\u4253\uc434\u4eee\uf742\u7944\ue3f5\u65f4\uee0e\u10d3\u9a94\u037d\u8525\u0f8b\ub00b\u3a3c\ubca2\u251f\uaf59\ud1ed\u5ba6\udc1c\u46d4\uc8f2\u7167\ufb92\u7ddc\ue60f\u6834\u92be\u1b14\u9d4f\u07b4\u89ae\u324d\ub4c0\u3ef1\ua72d\u2981\u5384\ud425\u5e67\uc0ad\u4911\uf35e\u75a9\uffad\u6019\ueac1\u6cac\u9527\u1fd0\u81d0\u0a22\u8c6c\u36da\ubf47\u2133\uabf7\u2db9\u565d\ud8ca\u42f9\ucb29\u4d98\uf781\u7825\ue269\u64d0\ued09\u1735\u99b8\u0257\u8452\u0e80\ub0fb\u3920\ua389\u258d\uae60\ud03e\u5a8e\uc30c\u4563\ucfe3\u7013\ufa55\u7cb5\ue6f5\u6f42\u91d9\u1b8d\u9c3f", 1591340204, 147210326), gnr.gnt[i].gmy, d, d2, d3, gnl2.orbitTicks == 0 ? 0.0 : gnl2.radius / (double)gnl2.orbitTicks, gnl2.orbitTicks == 0 ? 0.0 : gnl2.spin / (double)gnl2.orbitTicks, gnl2.bursts));
            n += gnl2.hits;
            n2 += gnl2.serverHits;
            n3 += gnl2.serverCrits;
            n4 += gnl2.ready;
            n5 += gnl2.notAimed;
            n6 += gnl2.heldAimed;
            n7 += gnl2.ticks;
        }
        System.out.println(String.format(Locale.ROOT, a.c(-1547016405, "\u6716\u1eba\u9479\u0a03\u81c9\u072c\ubd0d\u34eb\uaaa2\u2015\ua7df\u5db6\ud315\u4aec\uc0be\u4652\ufc1a\u7385\ue92e\u6f3e\ue68d\u9cd4\u126a\u89b0\u0fd3\u8556\u3cac\ub2a1\u280c\uae54\u25b4\udb73\u512b\uc8de\u4e9e\uc438\u7ba0\uf1c9\u775b\ueeae\u64b2\u1a52\u901a\u17b6\u8d66\u0359\uba92\u3062\ub669\u2dea\ua38e\u595b\ud0e9\u56a5\ucc12\u425b\uf9a5\u7f30\uf50d\u6cdd\ue271\u9815\u1fce\u959b\u0b5c\u82ec\u38e6\ube0f\u3419\uabec\u2177\ua70b\u5edd\ud464\u4a12\uc1cb\u4798\ufd21\u74f3\ueadb\u600c\ue61c"), n, n7 == 0 ? 0.0 : (double)n * 20.0 / (double)n7, n2, n3, n4, n5, n6));
    }

    /*
     * Exception decompiling
     */
    private static void gpq() {
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

    private static Entity gpr(MinecraftClient minecraftClient) {
        Object object;
        if (goe >= 0 && (object = minecraftClient.world.getEntityById(goe)) != null) {
            return object;
        }
        for (PlayerEntity playerEntity : minecraftClient.world.getPlayers()) {
            if (!a.b("\u0f24\u76bf\ufc6f\u6206\ue9e4\u6f78\ud530", -1451815067).equals(playerEntity.getGameProfile().name())) continue;
            goe = playerEntity.getId();
            return playerEntity;
        }
        return null;
    }

    private static void gps() {
        if (goh) {
            return;
        }
        goh = true;
        ClientTickEvents.START_CLIENT_TICK.register(gnr::gpm);
        wcn.listen(packet -> {
            EntityVelocityUpdateS2CPacket entityVelocityUpdateS2CPacket;
            if (goc && packet instanceof EntityVelocityUpdateS2CPacket && (entityVelocityUpdateS2CPacket = (EntityVelocityUpdateS2CPacket)packet).getEntityId() == gpb) {
                gpc.add(god);
            }
        });
        AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
            if (world.isClient()) {
                if (goc && entity.getId() == goe) {
                    gon = god;
                }
                return ActionResult.PASS;
            }
            if (!goc || entity.getId() != fnq.spawned || !playerEntity.getUuid().equals(gof)) {
                return ActionResult.PASS;
            }
            boolean bl = playerEntity.getAttackCooldownProgress(0.5f) > 0.9f && playerEntity.fallDistance > 0.0 && !playerEntity.isOnGround() && !playerEntity.isClimbing() && !playerEntity.isTouchingWater() && !playerEntity.hasVehicle() && !playerEntity.isSprinting();
            goa.add(new gng(god, bl));
            return ActionResult.PASS;
        });
    }

    private static void gpt(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    static {
        goe = -1;
        gog = -1;
        gon = -1;
        gop = -1;
        goq = true;
        gou = Float.NaN;
        gpa = new HashSet<Integer>();
        gpb = -1;
        gpc = new ConcurrentLinkedQueue();
    }

    private static /* synthetic */ int vs(int n, int n2) {
        return n ^ n2 | 0xDA73E825;
    }

    private static /* synthetic */ int vt(int n, int n2) {
        return gnr.vs(n, n2) ^ 0xDD792CCF;
    }
}

