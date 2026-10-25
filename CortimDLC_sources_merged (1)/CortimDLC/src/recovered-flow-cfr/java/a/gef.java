/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.entity.decoration.DisplayEntity$TextDisplayEntity
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.passive.VillagerEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.registry.Registries
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.command.CommandManager
 *  net.minecraft.server.command.ServerCommandSource
 *  net.minecraft.server.network.ServerCommonNetworkHandler
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gdz;
import a.gec;
import a.kfe;
import a.nfi;
import a.nfl;
import a.qdz;
import a.vkl;
import a.vmc;
import a.vmo;
import a.vmu;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

final class gef {
    private static final String geg = System.getenv().getOrDefault(a.c(2061907829, "\u373c\u4e87\uc457\u5a3e\ud18c\u5750\ued11\u64e4\ufabc\u7006\uf7cf\u0dae\u8378\u1acb\u908d"), a.b("\u630f\u1ab9\u9075", 1141400420));
    private static final boolean geh = System.getenv(a.c(970909087, "\ue5c9\u9c72\u16a2\u88cb\u0379\u85a5\u3fe4\ub611\u2849\ua2f3\u253a\udf40\u5191\uc833\u4262\uc495")) != null;
    private static final String gei = System.getenv().getOrDefault(a.c(1537989051, "\ud9ed\ua056\u2a86\ub4ef\u3f5d\ub981\u03c0\u8a35\u146d\u9ed7\u191e\ue374\u6da8\uf40c\u7e40\uf8a6"), a.c(-1036911146, "\ufdbe\u840c\u0edf\u90aa"));
    private static volatile BlockPos gej;
    private static volatile Direction gek;
    private static final boolean gel;
    private static final int gem = 8;
    private static final int gen;
    private static double geo;
    private static double gep;
    private static int geq;
    private static int ger;
    private static int ges;
    private static Entity get;
    private static volatile int geu;
    private static int gev;
    private static volatile int gew;
    private static final List<String> gex;
    private static final int gey = 3;
    private static final List<gec> gez;
    private static final List<BlockPos> gfa;
    private static final List<String> gfb;
    private static boolean gfc;
    private static boolean gfd;
    private static long gfe;
    private static gec gff;
    private static BlockPos gfg;
    private static gec gfh;
    private static long gfi;
    private static long gfj;
    private static int gfk;
    private static int gfl;
    private static int gfm;
    private static String gfn;
    private static TrackedData<Text> gfo;
    private static int gfp;
    private static int gfq;
    private static float gfr;
    private static float gfs;
    private static boolean gft;
    private static final List<Double> gfu;
    private static final List<Double> gfv;
    private static float gfw;
    private static float gfx;
    private static boolean gfy;
    private static volatile long gfz;
    private static String gga;
    private static int ggb;
    private static boolean ggc;
    private static boolean ggd;
    private static boolean gge;
    private static int ggf;
    private static double ggg;
    private static long ggh;
    private static volatile int ggi;
    private static double ggj;
    private static /* synthetic */ long ggk;
    private static /* synthetic */ String ggl;

    private gef() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        Object object;
        Object object2;
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        gef.ghc(minecraftClient);
        boolean bl2 = geg.equals(a.c(165453408, "\u9e0c\ue7b0\u6d6b\uf316\u78c3\ufe73\u442a\ucdcc"));
        boolean bl3 = bl = geg.equals(a.b("\u6683\u1f3f\u95e2", -34380060)) || bl2 || gel;
        if (n == 1) {
            GLFW.glfwSetCursorPosCallback((long)minecraftClient.getWindow().getHandle(), (l, d, d2) -> {});
            gef.ghb(minecraftClient, a.d("\uf5d5\u8c4c\u069b\u98c6\u1323\u9592\u2fdb\ua630\u3868", 1887683373, 1204958896), false);
            gef.ghb(minecraftClient, a.d("\u6fc3\u1646\u9c82\u02f3\u890d\u0f9f\ub5cc\u3c39", -672883749, -1220479914), false);
            gef.ghe(minecraftClient, a.c(982801653, "\u5c83\u2534\uafeb\u3192\uba4d\u3cfe\u86a6\u0f56\u914c\u1bae\u9c7b\u660d\ue8de\u7170\ufb3c\u7dda\uc798"));
            gef.ghe(minecraftClient, a.c(1392789861, "\u4925\u3097\uba44\u2436\uafe7\u2941\u9346\u1af0\u84a1\u0e0f\u89cf\u73fb\ufd4c\u64ce\ueece\u686c\ud231\u5df5\uc747\u4111\uc8f5\ub2b1\u3c1f\ua7c8\u21b6\uab29\u128b\u9cdb\u062c\u807d\u0bde\uf51b\u7f40\ue6e5\u60b0\uea06\u55c1"));
            gef.ghe(minecraftClient, a.b("\u0600\u7fb2\uf561\u6b13\ue0c2\u6664\udc63\u55d5\ucb84\u412a\uc6ea\u3cde\ub269\u2beb\ua1eb\u2748\u9d10\u12d7\u887e\u0e35\u87c5\ufd81\u733d\ue8e1\u6e98\ue40c\u5dae\ud3fe\u4909\ucf58\u44fb\uba3e\u3065\ua9c0\u2f95\ua523\u1ae4", 636421696));
            gef.ghe(minecraftClient, a.c(-507759921, "\u328d\u4b3f\uc1ec\u5f9e\ud44f\u52e9\ue8ee\u6158\uff09\u75a7\uf267\u0853\u86e4\u1f66\u9566\u13d9\ua991\u264e\ubcf2\u3abf\ub363\uc91b\u47b7\udc7c\u5a19\ud0ce\u697c\ue763\u7d85\ufbd5\u7066\u8eb7\u04e8\u9d09\u1b4a\u91af\u2e7e\ua408\u22cb"));
            gef.ghe(minecraftClient, a.d("\ubce8\uc556\u4f8c\ud1f9\u5a3d\udcde\u66ed\uef2f", 1641519256, -731700197));
            gef.ghe(minecraftClient, a.b("\u1086\u692a\ue3fd\u7d84\uf616\u70f4\ucab1\u4351\udd5a\u57af\ud079\u2a10", 116789502));
            gef.ghe(minecraftClient, a.b("\u3098\u492f\uc3f0\u5d89\ud649\u50ff\ueab5\u634d\ufd57\u77a2\uf07a\u0a20\u84d2\u1d7b\u973d\u11c9\uab88\u2456\ubef9\u389f\ub152\ucb19\u45a5\ude7d\u5847\ud2d0\u6b64\ue538\u7fd0\uf997", 1747661025));
            gef.ghe(minecraftClient, a.d("\ubf96\uc621\u4cfe\ud287\u5947\udff1\u65bb\uec43\u7259\uf8ac\u7f74\u8527\u0bd2\u926e\u180c\u9ede\u2480\uab47\u31ed\ub7bb\u3e4b\u4413\ucae7\u5170\ud708\u5dd4\ue478\u6a3f", 1508632464, 1544378493));
            minecraftClient.options.getViewDistance().setValue((Object)12);
        }
        if (n == 5) {
            object2 = clientPlayerEntity.getBlockPos();
            gfn = clientPlayerEntity.getName().getString();
            object = minecraftClient.getServer();
            object.execute(() -> gef.lambda$tick$1((MinecraftServer)object, (BlockPos)object2, bl));
        }
        if (n == 40) {
            object2 = minecraftClient.getServer();
            object2.execute(() -> gef.lambda$tick$2((MinecraftServer)object2, bl));
        }
        if (n == 60) {
            clientPlayerEntity.getInventory().setSelectedSlot(3);
        }
        if (!ggc && n >= 140 && clientPlayerEntity != null && gef.ggn(clientPlayerEntity)) {
            ggc = true;
            object2 = Flow.getInstance().getModuleManager().getByName(a.d("\ue64f\u9fca\u1518\u8b72\u0087\u8612\u3c46\ub5bc", -1255455109, -203906947));
            nfi.solo = bl;
            nfi.anarchies = a.b("\uadc7\ud477\u5ea5\uc0c9\u4b12\ucdb2\u77e0\ufe15\u6052\ueaef\u6d2d\u975d\u1988\u8027\u0a78\u8c98\u36d6\ub904", -519197212);
            nfi.minMineMs = 15000L;
            nfi.maxMineMs = gel ? 110000L : (bl ? 75000L : 45000L);
            gev = clientPlayerEntity.getInventory().count(Items.DIAMOND);
            gef.ghb(minecraftClient, a.d("\u7e31\u07a8\u8d7f\u1322\u98c7\u1e76\ua43f\u2dd4\ub38c", -30546963, 405511572), false);
            gef.ghb(minecraftClient, a.c(1578336311, "\u8069\uf9fe\u7336\ued49\u669e\ue02d\u5a69\ud3a8\u4dda\uc770"), false);
            gef.ghb(minecraftClient, a.c(1937055168, "\u1d89\u640c\ueede\u70b4\ufb58\u7dd2\uc781\u4e73"), false);
            minecraftClient.getServer().execute(() -> {
                long l = gfe;
                for (gec gec2 : gez) {
                    gec2.refreshAt += l;
                }
                gfd = true;
            });
            if (geh) {
                qdz.trace = string -> System.out.println(a.b("\u173e\u6e82\ue45f\u7a69", -1471670434) + string);
            }
            ((kfe)object2).setEnabled(true);
            gfp = n;
            gfq = n + (gel ? 2000 : (bl ? 1700 : 4000));
            System.out.println(a.c(1373211119, "\u8993\uf026\u7af2\ue488\u6f1a\ue9ff\u53bd\uda5a\u4402\ucefd\u4934\ub316\u3dc6\ua462\u2e22\ua8d5\u12ce") + geg);
        }
        if (ggc && n > gfp && clientPlayerEntity != null) {
            float f = clientPlayerEntity.getYaw();
            float f2 = clientPlayerEntity.getPitch();
            if (gft) {
                double d3 = MathHelper.wrapDegrees((float)(f - gfr));
                double d4 = f2 - gfs;
                double d5 = Math.sqrt(d3 * d3 + d4 * d4);
                gfu.add(d5);
                if (d5 > 35.0) {
                    String string2 = ((nfl)Flow.getInstance().getModuleManager().getByName(a.c(100858135, "\uf95e\u80db\u0a09\u9463\u1f96\u9903\u2357\uaaad"))).debug();
                    System.out.println(String.format(Locale.ROOT, a.d("\u43b3\u3a06\ub0d2\u2ea8\ua53a\u23c9\u9991\u106e\u8e76\u0493\u8341\u7937\uf7fc\u6e03\ue404\u62bc\ud8eb\u5731\ucd9e\u4b9b\uc22a\ub822\u3689\uad4e\u2b66\ua1b2\u180a\u9644\u0ce4\u8afe\u015e\uff94\u75d0\uec3e\u6a3a\ue0cd\u5f4a\ud522\u53ec\uca4a\u401e\u3ea7\ub4f1\u334b\ua983\u27a5\u9e3d\u149f\u92cb\u0911\u877d\u7dfb\uf40a\u721d\ue8e7\u66ba\udd13\u5bc4\ud1f9", 541572881, 127073524) + minecraftClient.isWindowFocused() + a.d("\u1ba2\u6216\ue893\u76b1\ufd36\u7b98\uc1d7\u4868\ud62f\u5cc8", 405123969, 1953474569), (double)(n - gfp) / 20.0, Float.valueOf(gfr), Float.valueOf(f), Float.valueOf(gfs), Float.valueOf(f2), string2.substring(0, string2.indexOf(32)), clientPlayerEntity.getEntityPos()) + a.b("\u5b5c", 1314020221) + ((nfl)Flow.getInstance().getModuleManager().getByName(a.d("\uaec9\ud74c\u5d9e\uc3f4\u4801\uce94\u74c0\ufd3a", 1209790223, -62963313))).action());
                }
            }
            gfr = f;
            gfs = f2;
            gft = true;
            nfl nfl2 = (nfl)Flow.getInstance().getModuleManager().getByName(a.d("\ue01a\u999f\u134d\u8d27\u06d2\u8047\u3a13\ub3e9", -337979953, 2088973724));
            String string3 = nfl2.debug();
            String string4 = string3.substring(0, string3.indexOf(32));
            if (!string4.equals(gga)) {
                if (gga.equals(a.d("\u303f\u498a\uc35e\u5d24", 698466473, 676524255)) && string4.equals(a.b("\u2f8d\u563d\udce8\u4293\uc949\u4ff9", -2019217457)) && ggj < 0.0) {
                    ggj = (double)(n - gfp) / 20.0;
                }
                gga = string4;
                System.out.println(a.b("\u6f46\u16f3\u9c27\u025d\u89cf\u0f2a\ub568\u3c8f\ua2d7\u2832\uafb5\u558d", -1586139353) + (double)(n - gfp) / 20.0 + a.d("\u8fa8\uf64a", 1305070154, -1533590125) + string3);
            }
            if (string3.startsWith(a.d("\ub0e4\uc943\u4398\uddf4", -524780108, 478858499)) && !ggd || string3.startsWith(a.c(-780286525, "\uc58a\ubc3f\u36eb\ua891")) && !gge && n - gfp > 1300) {
                if (string3.startsWith(a.b("\u6c11\u15b6\u9f6d\u0101", 1997433922))) {
                    ggd = true;
                } else {
                    gge = true;
                }
                gef.ghd(minecraftClient, a.d("\u823e\ufb9b\u7149\uef23\u64f6\ue243\u5817\ud1ed\u4ffa\uc50e\u42c0\ub8a0\u363e", -1016964414, 1375590544) + (string3.startsWith(a.c(393267519, "\uc96c\ub0cb\u3a10\ua47c")) ? a.c(-31466991, "\uda62\ua3c5\u291e\ub772") : a.d("\u6321\u1a94\u9040\u0e3a", 178712417, 1587711017)));
            }
            if ((n - gfp) % 200 == 0) {
                System.out.println(a.c(-1067171860, "\u3f8d\u4638\uccec\u5296\ud904\u5fe1\ue5a3\u6c44\uf21c\u78f9\uff7e\u0546") + (double)(n - gfp) / 20.0 + a.d("\u55d4\u2c36", 1752225080, 2032763037) + string3 + a.d("\u5946\u20a7\uaa6b\u3406\ubf9f", 2066111919, -1701772084) + clientPlayerEntity.getBlockPos().toShortString());
            }
        }
        if (n == gfq) {
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(-1660277954, "\u2b77\u52f2\ud820\u464a\ucdbf\u4b2a\uf17e\u7884"));
            object = ((nfl)kfe2).debug();
            kfe2.setEnabled(false);
            gfd = false;
            gef.ggm(minecraftClient, (String)object, bl, bl2);
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ggm(MinecraftClient minecraftClient, String string2, boolean bl, boolean bl2) {
        ArrayList<Double> arrayList;
        System.out.println(a.c(-184603588, "\u2c48\u55fd\udf29\u4153\ucac1\u4c24\uf666\u7f81\ue1d9\u6b3c\uecaa\u16d0\u980d\u01f8\u8ba3\u0d1e\ub75a\u389e\ua232\u2474\uadd1\ud7d3\u597a\uc2af\u449d") + gei + a.d("\u1f2b\u6689\uec40", -1666900598, 656802443) + string2);
        for (String object : gfb) {
            System.out.println(a.b("\ufe21\u8794\u0d40\u933a\u18a8\u9e55\u2405\uadfc\u33e4", -581304763) + object);
        }
        for (gec gec2 : gez) {
            System.out.println(a.d("\u521b\u2bae\ua17a\u3f00\ub492", -643111397, 1632285800) + gec2.id + a.b("\u0694\u7f3f\uf5be\u6bd8\ue00c\u66a9\udced\u550a\ucb4e\u41f2\uc637\u3c08", 1376650914) + gec2.refreshes + a.b("\u191a\u60e9\uea2a\u7446\uff95\u792a\uc372\u4ad0", -1193797326) + gec2.mined + a.d("\u6565\u1c9b\u9655\u0833\u83f2\u050d", 127374916, -2087718137) + gec2.minedOres + a.c(952005461, "\u7374") + String.join((CharSequence)a.b("\ua6ee\udf03\u558c", -65624371), gec2.events));
        }
        System.out.println(String.format(Locale.ROOT, a.d("\uec2f\u959a\u1f4e\u8134\u0aa6\u8c51\u360d\ubfe7\u21b9\uab0f\u2c85\ud6b4\u5867\uc1d1\u4b89\ucd3d\u773d\uf8f1\u6255\ue441\u6de4\u17a6\u9900\u02c0\u84e0\u0e2b\ub79d\u39c7\ua32f\u2529\uaedc\u5042\uda10\u43f6\uc5b3\u4f5e\uf0cb\u7abe\ufc6a", 1869824359, 29863170), (double)ggf * 60.0 / Math.max(1.0, ggg)));
        ArrayList<Double> arrayList2 = new ArrayList<Double>(gfu);
        arrayList2.sort(Double::compare);
        double d2 = arrayList2.isEmpty() ? 0.0 : (Double)arrayList2.get(arrayList2.size() - 1);
        double d3 = arrayList2.isEmpty() ? 0.0 : (Double)arrayList2.get((int)((double)arrayList2.size() * 0.95));
        System.out.println(String.format(Locale.ROOT, a.d("\ud247\uabf2\u2126\ubf5c\u34ce\ub22b\u0879\u818f\u1fcc\u9560\u12e0\ue899\u6605\uffbb\u75ed\uf310\u4954\uc69f\u5c78\uda7d\u5397\u29cc\ua777\u3cbe\uba9b\u3059\u89f0\u07f1\u9d4f\u1b12\u90b4\u6e60\ue424\u7dca\ufbce\u7139\ucea3\u44de\uc214\u5bfd\ud1a7\uaf5d\u2511\ua2f7\u3866\ub653\u0f81\u8532\u0335\u98bf\u16d1\uec0a\u65b5", 839865520, -652245329), d3, d2));
        List<Double> list = gfv;
        synchronized (list) {
            arrayList = new ArrayList<Double>(gfv);
        }
        arrayList.sort(Double::compare);
        double d4 = arrayList.isEmpty() ? 0.0 : (Double)arrayList.get(arrayList.size() - 1);
        double d5 = arrayList.isEmpty() ? 0.0 : (Double)arrayList.get((int)((double)arrayList.size() * 0.95));
        long l = arrayList.stream().filter(d -> d > 30.0).count();
        System.out.println(String.format(Locale.ROOT, a.d("\uddc8\ua47d\u2ea9\ub0d3\u3b41\ubda4\u07f6\u8e00\u1043\u9aef\u1d6f\ue716\u699a\uf03d\u7a79\ufc8c\u46d0\uc916\u53f7\ud5f6\u5c10\u2643\ua8f8\u3327\ub549\u3f9f\u8676\u0834\u92d9\u14c6\u9f26\u61ef\uebe1\u7254\uf457\u7eaf\uc174\u4b10\ucdc6\u547c\ude3c\ua09a\u2a8f\uad73\u37a8\ub9c0K\u8aff\u0cbb\u9775\u1951\ue3c6\u6a35\uec65\u7694\uf88d\u436d\uc5ad\u4fdc\ud605\u58bc\u22fc\ua557\u2f0a\ub1db\u3867\u8237\u04cc\u8e81\u1135\u9ba7", 110775105, -1444309341), arrayList.size(), d5, d4, l));
        d2 = d4;
        ServerWorld serverWorld = minecraftClient.getServer().getOverworld();
        int n = 0;
        for (Object object : gfa) {
            if (serverWorld.getBlockState(object).isAir()) continue;
            ++n;
        }
        gef.ggo(gfk == 0, a.c(-285880556, "\ucf7e\ub6cd\u3c03\ua269\u29af\uaf18\u155c\u9cbc\u02e2\u8817\u0f86\uf5e7\u7b27\ue292\u68cb\uee71\u547f\udbbb\u4108\uc748\u4eb7\u34fb\uba4c\u219a\ua7ac\u2d67") + gfk);
        gef.ggo(gfl == 0, a.c(1450051436, "\u073f\u7e98\uf44d\u6a30\ue1e6\u675d\udd4a\u54b4\ucab3\u4014\uc7d4\u3da7\ub320\u2ac6\ua08a\u267a\u9c30\u13e8\u891e\u0f1b\u86fd\ufca5\u721f\ue9db\u6fbb\ue577\u5cc2\ud28e\u487e\uce26\u45c8\ubb03") + gfl);
        if (!bl) {
            gef.ggo(gfm == 4, a.b("\u0b14\u72aa\uf826\u6656\ued85\u6b20\ud127\u58d0\uc694\u4c29\ucbec\u31ce", -791409799) + gfm + a.d("\udc41\ua5f8\u2f74\ub113\u3acb\ubc60\u0667\u8f87\u11c9\u9b73\u1cab\ue6c9\u680d\uf1ee\u7baa\ufd4a\u4703\uc8c9\u5276\ud431\u5d9c", -1963355030, 1563707422));
        }
        gef.ggo(n == gfa.size(), a.b("\udf11\ua6a1\u2c74\ub209\u39c3\ubf20\u053c\u8cd0\u1298\u983f\u1fbf\ue582\u6b5c\uf2ee\u78af\ufe0a", -374153371) + n + a.c(35258113, "\uff2f") + gfa.size());
        gef.ggo(d2 <= 118.0, a.d("\u6414\u1da4\u9770\u091d\u8284\u0478\ube27\u37cf\ua9c8", -48410396, 1346385037) + d2);
        if (gel) {
            var18_18 = gez.get(0);
            int n2 = 289 * gen;
            int n3 = minecraftClient.player == null ? 0 : minecraftClient.player.getInventory().count(Items.DIAMOND) - gev;
            double d6 = ggj;
            System.out.println(String.format(Locale.ROOT, a.c(-180534992, "\u41e7\u3852\ub286\u2cfc\ua76e\u218c\u9bdb\u1238\u8c67\u06c3\u815a\u7b31\uf5e3\u6c13\ue604\u60ba\udafc\u556b\ucfdd\u49cd\uc07e\uba6d\u34d0\uaf02\u2971\ua3a8\u1a03\u9401\u0eb4\u88f5\u035b\ufd8e\u77cf\uee35\u6824\ue299\u5d4b\ud77b\u51ec\uc811\u4247\u3cb5\ub6f4\u311d\uabc6\u25fb\u9c21\u1693\u90ce\u0b4b\u856c\u7fa1\uf61b\u700f\ueab1\u64e4\udf5c\u5986\ud3b0\u4a20\uc482\ube87\u3971\ub32b\u2dfb\ua41d\u1e08\u98aa\u12a2\u8d1f\u07c9\u81b3\u7873\uf295\u6c80\ue733\u616a\udbd8\u5207\ucc7e\u46a9\uc0a4\ubb4b\u35c5\uafbe\u262b\ua095\u1acc\u953f\u0f6c\u89de\u0005\ufa65\u74e7\uef51\u6941\ue3ca\u5df2\ud426\u4ed9\uc8da\u4337\u3d69\ub79d\u2e0f\ua87a\u22ae\u9d14\u170a\u91f7\u0ba1\u8251\u7cda\uf6c7\u713d\ueb6f\u65ca\udc4f\u5675\ud0a3\u4b52\uc54a\ubfa4\u39ad\ub016\u2ac2\ua4f0\u1f65\u997a\u13d2\u8a0b\u0472\ufeab\u791b\uf30c\u6da8\ue7f2\u5e1f\ud8c0\u52b4\ucd22\u47d7\uc1c7\ub839\u3273\uaca8\u2713\ua15a\u1bfe\u95a7\u0c19\u86c3\u00a0\ufb25\u75d0\uefc3\u663a\ue068\u5ad7\ud50e\u4f59\uc9fb\u43e9\u3a19\ub48d\u2ef3\ua925\u239e\u9dc9\u147a\u8e2c\u0891\u8343\u7d73\uf7e4\u6e10\ue854\u629f\udcf1\u573d\ud187\u4b8f\uc234\ubc64\u36c6\ub110"), ((gec)var18_18).mined, n2, geq, d6, (double)((gec)var18_18).mined / Math.max(1.0, d6 > 0.0 ? d6 : (double)(gfq - gfp) / 20.0), ger, ges, n3, gew, (double)((gec)var18_18).mined / (double)Math.max(1, gew), geu));
            gef.ggo(d6 > 0.0 && d6 < 75.0, a.c(-2133174628, "\u56e7\u2f5b\ua585\u3bfe\ub060\u3682\u8c85\u0538\u9b6e\u11db\u961f\u6c7d\ue2ef\u7b0a\uf145\u77b9\ucdb3\u422f\ud898\u5ece\ud732\uad26\u23dc\ub80a\u3e3b\ub4be\u0d10\u8345\u19ba\u9fb4\u141d") + d6);
            gef.ggo(ges >= 0 && ges <= 4, a.b("\u3b98\u4224\uc8ff\u5682\udd57\u5be7\ue1be\u6858\uf654\u7ca9\ufb73\u0101\u8fc4\u1621\u9c3b\u1acd\ua0cc\u2f49\ub5e6\u33ba\uba08\uc014\u4ea3\ud575\u5301\ud995", 1104100326) + ges);
            gef.ggo(geu == 0, a.d("\uc148\ub8f8\u3236\uac13\u2790\ua13d\u1b63\u92d7\u0cc5\u8676\u01a8\ufb9b\u751f\ueca9\u66ef\ue011\u5a54\ud588\u4f3c\uc964\u40d4\u3acc\ub478\u2fe7\ua9cc\u2301\u9abf\u14ab\u8e0b\u084c\u83e7\u7d6f", -1053360144, 1004814064) + geu + a.b("\u11df\u683a\ue2f4\u7c81\uf75e\u71f9", 2080379385));
        } else if (bl2) {
            var18_18 = gez.get(0);
            System.out.println(a.d("\ub438\ucd8d\u4759\ud923\u52b1\ud444\u6e1a\ue7e3\u79b0\uf303\u74d1\u8eaaj\u9992\u13db", -1291904548, -1231114874) + ((gec)var18_18).minedDiamonds + a.b("\u5aa9\u235c\ua982\u37fb\ubc20\u3a93\u80c1\u093a\u9772\u1d9c\u9a43", -847488382) + (((gec)var18_18).minedOres - ((gec)var18_18).minedDiamonds) + a.d("\ub659\ucfa7\u456f\udb02\u50d8\ud67e\u6c7f\ue5c1\u7b83\uf125\u76e0\u8cce\u0215\u9be0\u11b2\u9743\u2d19\ua2dd\u3878\ube2e\u378d\u4d88\uc32e\u58ec\ude86\u5455\uedf7\u63b7\uf941\u7f54\uf4be\u0a2b", 1835788029, 672092324) + ggi + a.d("\uc8d0\ub169\u3be6\ua58c\u2e44\ua8a5\u12af\u9b1a", 2138602915, -995248805) + (((gec)var18_18).y0 - 1) + a.c(979438034, "\u09f6\u704b\ufadc\u64ac\uef6e\u69db\ud394\u5a2d") + 3 + a.b("\uc580\ubc34\u36eb\ua8d6\u2308\ua5ba\u1ffb\u965e\u0855\u82f8\u0526\uff12\u7188\ue83d\u6269\ue493\u5e99\ud109\u4baf\ucdaa", 833799613) + ggj + a.c(1892522599, "\u9a45\ue3a7"));
            gef.ggo(((gec)var18_18).minedDiamonds >= 4, a.c(-312276384, "\u0a0b\u73b7\uf96c\u6711\uecc4\u6a74\ud02d\u59cb\uc7c7\u4d3b\ucaec\u309a\ube46\u27f6\uade1") + ((gec)var18_18).minedDiamonds);
            gef.ggo(ggi >= ((gec)var18_18).y0 - 3, a.b("\u2ac8\u5368\ud9a9\u479f\ucc0a\u4abc\uf0e6\u7914\ue753\u6db5\uea32\u105f\u9e85\u0771\u8d66\u0b96\ub1cc\u3e19\ua4b6\u22af\uab14\ud140\u5ff7\uc422\u4240\uc8df\u7176\uff7e\u65cd", -684512591) + ggi);
            gef.ggo(ggj > 0.0 && ggj < 70.0, a.d("\u5bdc\u2260\ua8be\u36c5\ubd5b\u3bb9\u81be\u0803\u9655\u1ce0\u9b24\u6146\uefd4\u762a\ufc78\u7a84\uc0cd\u4f59\ud5be\u53f3\uda09\ua01d\u2eea\ub536\u3341\ub99c-\u8e7d\u1480\u92c6\u1926\ue7a5\u6df9\uf407\u721a\uf8e4\u4729\ucd59\u4bc4\ud26f", 333789177, 86994025) + ggj);
        } else if (bl) {
            gef.ggo(gef.gez.get((int)0).minedOres >= 25, a.c(-709099924, "\ufe08\u87a4\u0d60\u9307\u1883\u9e7f\u2428\uadde\u338a\ub93a\u3ead") + gef.gez.get((int)0).minedOres);
        } else {
            Object object;
            var18_18 = gez.get(0);
            object = gez.get(1);
            gef.ggo(((gec)var18_18).minedOres >= 10, a.c(2042564770, "\u109a\u692a\ue3f8\u7d98\uf600\u70ac\ucae8\u430f\udd03") + ((gec)var18_18).minedOres);
            gef.ggo(object.minedOres >= 10, a.b("\ue34a\u9afa\u102b\u8e48\u05d0\u837c\u3938\ub0df\u2ed3", 2046747506) + object.minedOres);
            gef.ggo(((gec)var18_18).events.stream().anyMatch(string -> string.startsWith(a.c(984170285, "\u3f52\u46f4\ucc24\u5241\ud981\u5f26\ue56e\u6cc6\uf288\u7877\uffaf\u05da\u8b1e"))), a.d("\u0d2e\u749e\ufe56\u6073\uebe5\u6d41\ud746\u5ea6\uc0f8\u4a48\ucd8a\u37b4\ub962\u209d\uaa87\u2c6b\u9623\u19a1\u8340\u0506\u8cf2\uf6b7\u7813\ue3d4\u65b0", -1477220033, 1545102438));
            gef.ggo(object.events.stream().anyMatch(string -> string.startsWith(a.c(-2048182920, "\u3507\u4ca1\uc671\u5814\ud3d4\u5573\uef3b\u6693\uf8dd\u7222\uf5fa\u0f8f\u814b"))), a.b("\ua19c\ud82c\u52e4\uccc1\u4757\uc1f3\u7bf4\uf214\u6c4a\ue6f9\u6138\u9b06\u15d0\u8c2f\u0635\u80d9\u3a91\ub513\u2ff2\ua9b4\u2040\u5a05\ud4a1\u4f66\uc902", -1181769237));
        }
        gef.ggo(string2.contains(a.b("\u43c1\u3a6c\ub0a5\u2ec9\ua506\u23ae\u99ae", 561005490)) && !string2.contains(a.d("\ua06a\ud9c7\u530e\ucd62\u46ad\uc005\u7a05\uf3f9", -46435015, 69129519)), a.c(-760404681, "\u254c\u5ce2\ud62a\u485e\uc3c2\u453d\uff6f\u7685\ue88e\u626b\ue5a4\u1fcf\u9105\u08ac\u82e6\u0443\ube16") + string2);
        System.out.println(a.b("\u8809\uf1bc\u7b68\ue512\u6e80\ue865\u5227\udbc0\u4598\ucf7d", 1379108974) + (ggb == 0 ? a.b("\uc885\ub125\u3be4\ua595", -1145190191) : a.d("\u533f\u2a89\ua052\u3e26\ub59d\u3324", -139110730, 98895305) + ggb + a.c(1632743631, "\ub0e7")));
    }

    private static boolean ggn(ClientPlayerEntity clientPlayerEntity) {
        for (int i = 0; i < 36; ++i) {
            if (!clientPlayerEntity.getInventory().getStack(i).isOf(Items.NETHERITE_PICKAXE)) continue;
            return true;
        }
        return false;
    }

    private static void ggo(boolean bl, String string) {
        if (!bl) {
            ++ggb;
            System.out.println(a.d("\u50aa\u291f\ua3cb\u3db1\ub623\u30c6\u8a84\u0363\u9d3b\u17de\u904e\u6a34\ue4ee\u7d59\uf702\u71b8\ucbb1\u4467\udedc\u5888\ud176\uab26\u25cb\ube00", -1571011220, 969807283) + string);
        }
    }

    private static void ggp(MinecraftServer minecraftServer, BlockPos blockPos2, boolean bl) {
        VillagerEntity villagerEntity;
        ServerWorld serverWorld = minecraftServer.getOverworld();
        gez.clear();
        gfa.clear();
        int n = blockPos2.getY() + 10;
        gfg = new BlockPos(blockPos2.getX() + 100, blockPos2.getY(), blockPos2.getZ() - 250);
        for (int i = (gfg.getX() >> 4) - 2; i <= (gfg.getX() >> 4) + 2; ++i) {
            for (int j = (gfg.getZ() >> 4) - 2; j <= (gfg.getZ() >> 4) + 2; ++j) {
                serverWorld.getChunk(i, j);
            }
        }
        if (gel) {
            gez.add(new gec(0, blockPos2.getX(), blockPos2.getZ() + 40, n, false, 8000L, 8000L, a.c(-1226431568, "\u27a9\u5e37\ud49e\u4ae3\uc14e\u47f2\ufdde")));
        } else if (bl) {
            gez.add(new gec(0, blockPos2.getX(), blockPos2.getZ() + 40, n, false, 120L, 1800L, a.b("\ud596\uac08\u26a1\ub8dc\u3371\ub5cd\u0fe1", 38523279), a.b("\uc4d5\ubd40\u37ef\ua9e2\u224a\ua489\u1eae\u9724\u0971\u83bf", -466698045)));
        } else {
            gez.add(new gec(101, blockPos2.getX(), blockPos2.getZ() + 40, n, false, 1000L, 2000L, a.d("\u87dd\ufe48\u74e7\ueaea\u6142\ue781\u5da6\ud42c\u4a79\uc0b7", 1170327791, -568898780), a.c(419298126, "\uff57\u86c9\u0c60\u921d\u19b0\u9f0c\u2520")));
            gez.add(new gec(102, blockPos2.getX() + 220, blockPos2.getZ() + 40, n, true, 2400L, 2400L, a.b("\u14ae\u6d31\ue7e4\u7993\uf24c\u74f4\ucea3\u4722\ud900\u53bc\ud410", -283897666), a.d("\u81cb\uf855\u72fc\uec81\u672c\ue190\u5bbc", 465268563, -705238399)));
            gez.add(new gec(103, blockPos2.getX() + 440, blockPos2.getZ() + 40, n, false, 4000L, 2000L, a.c(-1212736577, "\u1fa6\u6638\uec91\u72ec\uf941\u7ffd\uc5d1"), a.d("\u0af1\u7364\uf9cb\u67c6\uec6e\u6aad\ud08a\u5900\uc755\u4d9b", 77332126, -292032391)));
        }
        for (gec gec2 : gez) {
            gef.ggv(serverWorld, gec2, blockPos2.getY());
        }
        if (gel) {
            villagerEntity = (VillagerEntity)EntityType.VILLAGER.create((World)serverWorld, SpawnReason.COMMAND);
            gec gec3 = gez.get(0);
            villagerEntity.refreshPositionAndAngles((double)gec3.cx + 0.5, (double)gec3.y0, (double)gec3.cz + 0.5, 0.0f, 0.0f);
            villagerEntity.setAiDisabled(true);
            villagerEntity.setInvulnerable(true);
            villagerEntity.setSilent(true);
            serverWorld.spawnEntity((Entity)villagerEntity);
            get = villagerEntity;
        }
        if (!gfc) {
            gfc = true;
            ServerTickEvents.END_SERVER_TICK.register(gef::ggt);
            PlayerBlockBreakEvents.BEFORE.register((world, playerEntity, blockPos, blockState, blockEntity) -> {
                if (!gfd || world.isClient()) {
                    return true;
                }
                for (gec gec2 : gez) {
                    if (!gec2.inMine(blockPos)) continue;
                    return true;
                }
                ++gfk;
                gfb.add(a.b("\ua3a9\uda1a\u50d4\ucebe\u4578\uc3cf\u798b\uf06b\u6e35\ue4c0", -61496365) + blockPos.toShortString() + a.d("\ub473", 1358619015, -62237227) + blockState.getBlock());
                return false;
            });
            PlayerBlockBreakEvents.AFTER.register((world, playerEntity, blockPos, blockState, blockEntity) -> {
                if (!gfd || world.isClient() || !(playerEntity instanceof ServerPlayerEntity)) {
                    return;
                }
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)playerEntity;
                for (gec gec2 : gez) {
                    if (!gec2.inMine(blockPos)) continue;
                    if (geh) {
                        System.out.println(a.b("\u041e\u7dae\uf779\u695e\ue2cb\u646a\ude24\u57d1\uc980\u4374", -648018841) + blockPos.toShortString() + a.c(-831419046, "\u8d79\uf49c\u7e06") + gfe);
                    }
                    ggi = Math.min(ggi, blockPos.getY());
                    gef.ggr(gec2, blockState);
                    gef.ggs((ServerWorld)world, serverPlayerEntity, gec2, blockPos);
                }
            });
        }
        villagerEntity = minecraftServer.getCommandManager().getDispatcher();
        for (gec gec4 : gez) {
            villagerEntity.register((LiteralArgumentBuilder)CommandManager.literal((String)(a.d("\ucf64\ub6da", 312840183, -1160494864) + gec4.id)).executes(commandContext -> {
                ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).getPlayerOrThrow();
                if (gff == gec4) {
                    serverPlayerEntity.sendMessage((Text)Text.literal((String)a.b("\u6728\u1e5d\u90ff\u0ed7\u816b\u03b9\ub99f\u306d\uaa27\u248b\ua355\u5951\ud7fd\u4e46\uc419\u4292\uf8aa\u770f\uedb1\u6f8c\ue266\u983a\u1299\u8d25\u0b55\u81f8\u3849\ub204\u2c92\uaab7\u2171\udfd2\u559a\ucc1e\u4a38\uc49d", -692426837)));
                    return 1;
                }
                gfh = gec4;
                gfi = gfe + 25L;
                return 1;
            }));
        }
        villagerEntity.register((LiteralArgumentBuilder)CommandManager.literal((String)a.c(-554375817, "\ue504\u9ca3\u1663\u8810")).then(CommandManager.literal((String)a.d("\uc4bd\ubd08\u37dc\ua9a6", -1597473755, -2145601295)).executes(commandContext -> {
            ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).getPlayerOrThrow();
            if (gfj >= 0L) {
                ++gfl;
                gfb.add(a.d("\u3821\u41d9", -2035115413, 421372476) + (double)gfe / 20.0 + a.b("\u5713\u2ed1\ua414\u3a63\ub1b8\u3708\u8d51\u04c4\u9aec\u104b\u978b\u6df8\ue35f\u7ab9\uf0f5\u7605\ucc4f\u4397\ud961\u5f64\ud682\uacda\u2260\ub9a4\u3fc4\ub508\u0cbd\u82f1\u1801\u9e59", 1586517805));
            }
            gfj = gfe + 140L;
            serverPlayerEntity.sendMessage((Text)Text.literal((String)a.b("\u8a1b\uf33b\u5f7f\ue78f\u6cdf\ueaaf\u5485\udd5e\u4374\uc9b0\u4e6a\ub412\u3ab9\ua374\u292f\uafdb\u1599\u9e5d\u00f3\u86af\u0b48\u750b\ufbba\u601b\ue61b\u68d5\ud1e1\u5f72\uc58d\u43d8\uc86c\u36b6\ubc3b\u250b\ua310", -1861121377)));
            serverPlayerEntity.sendMessage((Text)Text.literal((String)a.b("\u0b40\u7235\uf8de\u4055\ued7e\u6bb2\ud5e3\u5c05\uc254\u48eb\ucf32\u3542\ubbeb\u2258\ua879\u2efe\u94cf\u1b69\u85b4\u03e4\u8a94\uf004\u7ace\ue135\u673f\ued9b\u5421\uda79\u40f2\uc6df\u4d64\ub3b0\u39f2\ua416\u2622\uace1\u1343\u9947\u1f96\u8230\u08e8\u76df\ufcda\u7b7c\ue5ca\u6bcf\ud213", -118551608)));
            serverPlayerEntity.sendMessage((Text)Text.literal((String)a.d("\u5f7a\u260f\uace4\u146f\ub944\u3f88\u81e9\u0837\u966d\u1cd8\u9b07\u617b\uefa9\u7615\uf852\u7ea2\uc46a\u4b7a\ud5b2\u53cb\ude29\ua067\u2ed5\ub501\u3306\ub9d3\u0017\u8e4f\u14c3\u92e5\u1d43\ue315\u699e\uf44f\u721f\uf8d0\u4704\uc968\u4f3c\ud64c\u584b\u26c6\ua8f7\u2b5e\ub182\u3f80\u862d\u0c98\u8ad3\u110e\u9b6e", -590989279, 1566205903)));
            serverPlayerEntity.sendMessage((Text)Text.literal((String)a.d("\uecbf\u95ca\u1f5a\u812b\u0afc\u8c4d\u361e\ubfef\u21b0\uab01\u2ca9\ud29d\u5c16\uc5d9\u4f83\uc97a\u7330\ufc9b\u6626\ue41b\u698e\u13a8\u9d15\u06ca\u80bf\u0a6f\ub3a2\u3df1\ua319", 1408165053, 1252591800)));
            return 1;
        })));
        villagerEntity.register((LiteralArgumentBuilder)CommandManager.literal((String)a.d("\u2e07\u57b9\udd35\u4345\uc896", -275467316, 1988795823)).executes(commandContext -> {
            ++gfm;
            ((ServerCommandSource)commandContext.getSource()).getPlayerOrThrow().sendMessage((Text)Text.literal((String)a.b("\u1f44\u6631\ue8a0\u76c5\ufd67\u7ba4\uc1f0\u4874\ud24b\u5ce7\udb39\u2558\uaf95\u3620\ubc0f\u3a82\u80b3\u0f69\u95a8\u17e0\u9a25\ue02d\u6af5\uf53b\u7330\uf9e8\u4029\uce7d\u54fd\ud2db\u591c\ua7c0\u29e3\ub40d\u325f\ub8e4\u073d\u8d4d\u0beb\u9253\u1873\u66f8\ueca5\u6b19\uf1c0\u7bde\uc61f\u48bc\ucae7\u5132\udf4c\u259d\uac5c\u2a7f\ub495\u3ed8\u8565\u03b6\u89cc\u1015\u9edd\ue0ee\u6300\ue959\u7797\ufe2c\u4400\uc2f2\u48a4\ud769\u5db0\udbc9\u260a", 1783832490)));
            return 1;
        }));
        ServerPlayerEntity serverPlayerEntity = minecraftServer.getPlayerManager().getPlayer(gfn);
        if (serverPlayerEntity != null) {
            minecraftServer.getPlayerManager().sendCommandTree(serverPlayerEntity);
            gef.ggq(minecraftServer, serverPlayerEntity);
        }
    }

    private static void ggq(MinecraftServer minecraftServer, ServerPlayerEntity serverPlayerEntity) {
        try {
            ClientConnection clientConnection = null;
            for (Field field : ServerCommonNetworkHandler.class.getDeclaredFields()) {
                if (field.getType() != ClientConnection.class) continue;
                field.setAccessible(true);
                clientConnection = (ClientConnection)field.get(serverPlayerEntity.networkHandler);
            }
            Channel channel = null;
            for (Field field : ClientConnection.class.getDeclaredFields()) {
                if (!Channel.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                channel = (Channel)field.get(clientConnection);
            }
            channel.pipeline().addBefore(a.d("\ua6bd\udf1d\u55cc\ucbb5\u406c\uc6cc\u7cb4\uf572\u6b24\ue19a\u6643\u9c3a\u12e4\u8b42", 1702866934, 233113909), a.d("\u2538\u5c83\ud653\u483a\uc3a8\u4574\uff15\u76e0\ue8b8\u6202\ue5eb\u1fb7\u9177\u08c0\u829f\u0473\ube2a\u31fa\uab5e", -1715231539, -1686732416), (ChannelHandler)new gdz(minecraftServer));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    private static void ggr(gec gec2, BlockState blockState) {
        ++gec2.mined;
        String string = Registries.BLOCK.getId((Object)blockState.getBlock()).getPath();
        if (string.endsWith(a.b("\u2c89\u5535\udfee\u4193\uca46\u4cf6\uf6af\u7f65\ue10a\u6ba6\uec62", 457518310))) {
            ++gec2.minedDiamonds;
        }
        if (string.endsWith(a.c(1741729315, "\uae78\ud7f9\u5d37\uc351"))) {
            ++gec2.minedOres;
            if (gec2 == gez.get(0) && gec2.refreshes == 1) {
                ++ggf;
                if (ggh < 0L) {
                    ggh = gfe;
                }
                ggg = (double)(gfe - ggh) / 20.0;
            }
        }
    }

    private static void ggs(ServerWorld serverWorld, ServerPlayerEntity serverPlayerEntity, gec gec2, BlockPos blockPos) {
        Direction.Axis axis;
        boolean bl;
        if (gei.equals(a.c(1392639718, "\ufe8c\u873c\u0dee\u9394"))) {
            return;
        }
        float f = serverPlayerEntity.getPitch();
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        float f2 = MathHelper.wrapDegrees((float)serverPlayerEntity.getYaw());
        boolean bl2 = bl = Math.abs(f2) < 45.0f || Math.abs(f2) > 135.0f;
        Direction.Axis axis2 = Math.abs(f) > 50.0f ? Direction.Axis.Y : (axis = bl ? Direction.Axis.Z : Direction.Axis.X);
        if (gei.equals(a.b("\udda2\ua414\u2ec5\ub0b2", 1133632960)) && blockPos.equals((Object)gej) && gek != null) {
            axis = gek.getAxis();
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0) continue;
                if (axis == Direction.Axis.Y) {
                    arrayList.add(blockPos.add(i, 0, j));
                    continue;
                }
                if (axis == Direction.Axis.Z) {
                    arrayList.add(blockPos.add(i, j, 0));
                    continue;
                }
                arrayList.add(blockPos.add(0, j, i));
            }
        }
        for (BlockPos blockPos2 : arrayList) {
            BlockState blockState = serverWorld.getBlockState(blockPos2);
            if (!gec2.inMine(blockPos2) || blockState.isAir()) continue;
            for (ItemStack itemStack : Block.getDroppedStacks((BlockState)blockState, (ServerWorld)serverWorld, (BlockPos)blockPos2, null, (Entity)serverPlayerEntity, (ItemStack)serverPlayerEntity.getMainHandStack())) {
                serverPlayerEntity.getInventory().insertStack(itemStack);
            }
            serverWorld.setBlockState(blockPos2, Blocks.AIR.getDefaultState(), 3);
            gef.ggr(gec2, blockState);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ggt(MinecraftServer minecraftServer) {
        ServerPlayerEntity serverPlayerEntity;
        if (!gfd && gez.isEmpty()) {
            return;
        }
        ServerWorld serverWorld = minecraftServer.getOverworld();
        ServerPlayerEntity serverPlayerEntity2 = serverPlayerEntity = gfn == null ? null : minecraftServer.getPlayerManager().getPlayer(gfn);
        if (gfi >= 0L && ++gfe >= gfi && serverPlayerEntity != null) {
            gfi = -1L;
            gff = gfh;
            gef.ggz(minecraftServer, gef.gff.spawn, 0.0f, 0.0f);
            gfb.add(a.d("\u5e57\u27af", -94601621, 1543053386) + (double)gfe / 20.0 + a.d("\u1ae6\u631d\ue9cb\u77bc\ufc6c\u7ad6\uc084\u4931", -2009955039, 1974509551) + gef.gff.id);
        }
        if (gfj >= 0L && gfe >= gfj && serverPlayerEntity != null) {
            gfj = -1L;
            if (gff != null) {
                gef.ggz(minecraftServer, gef.gff.warp, 180.0f, 15.0f);
                serverPlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 0));
                gfb.add(a.b("\u8d6a\uf492", 934710556) + (double)gfe / 20.0 + a.c(1077131345, "\ub879\uc19f\u4b5a\ud538\u5eed\ud849\u621b\uebae") + gef.gff.id);
            }
        }
        if (!gfd) {
            return;
        }
        if (gel && gfe % 10L == 0L && !gez.isEmpty()) {
            gec gec2 = gez.get(0);
            if (gep < 0.0 && gec2.mined > 0) {
                gep = (double)gfe / 20.0;
            }
            int n = 0;
            int n2 = 0;
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = gec2.cx - 8; i <= gec2.cx + 8; ++i) {
                for (int j = gec2.cz - 8; j <= gec2.cz + 8; ++j) {
                    for (int k = gec2.y0 - gen; k <= gec2.y0 - 1; ++k) {
                        BlockState blockState = serverWorld.getBlockState(new BlockPos(i, k, j));
                        if (blockState.isOf(Blocks.DIAMOND_ORE)) {
                            ++n2;
                        }
                        if (blockState.isAir()) continue;
                        ++n;
                        if (arrayList.size() >= 80) continue;
                        arrayList.add(i - gec2.cx + a.c(-68451006, "\u856f") + (k - gec2.y0) + a.c(1598297430, "\u157b") + (j - gec2.cz));
                    }
                }
            }
            Vec3d vec3d = gex;
            synchronized (vec3d) {
                gex.clear();
                gex.addAll(arrayList);
            }
            geq = n;
            ges = n2;
            if (get != null && serverPlayerEntity != null && gfe % 40L == 0L) {
                vec3d = serverPlayerEntity.getRotationVector().multiply(1.0, 0.0, 1.0).normalize();
                get.refreshPositionAndAngles(serverPlayerEntity.getX() + vec3d.x * 1.6, serverPlayerEntity.getY(), serverPlayerEntity.getZ() + vec3d.z * 1.6, 0.0f, 0.0f);
            }
            int n3 = 289 * gen;
            if (geo < 0.0 && n <= n3 / 50) {
                geo = (double)gfe / 20.0;
                gfb.add(String.format(Locale.ROOT, a.d("\ucaaa\ub314\u39ce\ua7bb\u2c7f\uaad9\u108b\u993e\u0720\u8d84\u0a03\uf077\u7eab\ue705\u6d01\uebb6\u51aa\ude28\u4493\uc2cf\u4b79\u316c\ubf93\u244b\ua237\u28f4\u911a", 1834278111, 1114379789), geo, n));
            }
            if (gfe % 100L == 0L) {
                System.out.println(a.c(-1317240905, "\u7fd7\u0662\u8cb6\u12cc\u995e\u1fbc\ua5eb\u2c08\ub257\u38f3\ubf70\u4555\ucbcb") + (double)gfe / 20.0 + a.c(223179014, "\u7120\u08dd\u8207\u1c75\u97b0\u1148") + n + a.d("\ue90b\u90f8\u1a3b\u8457\u0f84\u893b\u3363\ubac1", -368287644, -151680697) + gec2.mined);
            }
        }
        for (gec gec3 : gez) {
            if (gfe >= gec3.refreshAt) {
                gec3.refreshAt += gec3.period;
                ++gec3.tierAt;
                ++gec3.refreshes;
                gef.ggw(serverWorld, gec3, new Random((long)gec3.id * 31L + (long)gec3.refreshes), 0.0);
                String string = serverPlayerEntity != null && serverPlayerEntity.getBlockPos().isWithinDistance((Vec3i)gec3.warp, 30.0) ? a.c(2047603691, "\uf381\u8a3b\u00ec\u9e8e") : a.c(874314334, "\ufa3b\u839c\u0959\u9730");
                gec3.events.add(a.b("\u6a8d\u132b\u99fb\u079e\u8c5e\u0af9\ub0b1", 1518365432) + gec3.refreshes + a.d("\u1e99", -1619439929, 553013375) + string + a.d("\ufe48\u87ad\u0d37", 1891392184, 1576903891) + (double)gfe / 20.0);
            }
            if (gfe % 20L == 0L) {
                gef.ggx(gec3);
            }
            if (serverPlayerEntity == null || gfe % 2L != 0L) continue;
            gef.ggu(serverWorld, serverPlayerEntity, gec3);
        }
    }

    private static void ggu(ServerWorld serverWorld, ServerPlayerEntity serverPlayerEntity, gec gec2) {
        Box box = new Box((double)(gec2.cx - 8 - 2), (double)(gec2.y0 - gen - 2), (double)(gec2.cz - 8 - 2), (double)(gec2.cx + 8 + 3), (double)(gec2.y0 + 4), (double)(gec2.cz + 8 + 3));
        for (ItemEntity itemEntity2 : serverWorld.getEntitiesByClass(ItemEntity.class, box, itemEntity -> itemEntity.getOwner() == null)) {
            ItemStack itemStack = itemEntity2.getStack().copy();
            serverPlayerEntity.getInventory().insertStack(itemStack);
            if (itemStack.isEmpty()) {
                itemEntity2.discard();
                continue;
            }
            itemEntity2.setStack(itemStack);
        }
    }

    private static void ggv(ServerWorld serverWorld, gec gec2, int n) {
        BlockPos[] blockPosArray;
        BlockState blockState;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        for (n6 = gec2.cx - 40 >> 4; n6 <= gec2.cx + 40 >> 4; ++n6) {
            for (n5 = gec2.cz - 140 >> 4; n5 <= gec2.cz + 40 >> 4; ++n5) {
                serverWorld.getChunk(n6, n5);
            }
        }
        for (n6 = gec2.cx - 8 - 6 >> 4; n6 <= gec2.cx + 8 + 6 >> 4; ++n6) {
            for (n5 = gec2.cz - 8 - 6 >> 4; n5 <= gec2.cz + 8 + 6 >> 4; ++n5) {
                serverWorld.setChunkForced(n6, n5, true);
            }
        }
        n6 = 12;
        for (n5 = gec2.cx - n6; n5 <= gec2.cx + n6; ++n5) {
            for (n4 = gec2.cz - n6; n4 <= gec2.cz + n6; ++n4) {
                for (n3 = gec2.y0 - gen - 1; n3 <= gec2.y0 + 5; ++n3) {
                    n2 = Math.abs(n5 - gec2.cx) == n6 || Math.abs(n4 - gec2.cz) == n6 ? 1 : 0;
                    blockState = Blocks.AIR.getDefaultState();
                    if (n3 < gec2.y0) {
                        blockState = Blocks.STONE_BRICKS.getDefaultState();
                    } else if (n2 != 0 && n3 <= gec2.y0 + 2 && (n4 != gec2.cz + n6 || Math.abs(n5 - gec2.cx) > 1)) {
                        blockState = Blocks.STONE_BRICKS.getDefaultState();
                    }
                    serverWorld.setBlockState(new BlockPos(n5, n3, n4), blockState, 3);
                }
            }
        }
        gef.ggw(serverWorld, gec2, new Random(gec2.id), gel ? 0.0 : 0.55);
        if (gel) {
            ger = 0;
            for (n5 = gec2.cx - 8; n5 <= gec2.cx + 8; ++n5) {
                for (n4 = gec2.cz - 8; n4 <= gec2.cz + 8; ++n4) {
                    for (n3 = gec2.y0 - gen; n3 <= gec2.y0 - 1; ++n3) {
                        if (!serverWorld.getBlockState(new BlockPos(n5, n3, n4)).isOf(Blocks.DIAMOND_ORE)) continue;
                        ++ger;
                    }
                }
            }
        }
        BlockPos[] blockPosArray2 = blockPosArray = new BlockPos[]{new BlockPos(gec2.cx - 8 - 2, gec2.y0 - 1, gec2.cz), new BlockPos(gec2.cx + 8 + 2, gec2.y0 - 1, gec2.cz + 2), new BlockPos(gec2.cx, gec2.y0 - 1, gec2.cz - 8 - 2), new BlockPos(gec2.cx + 3, gec2.y0 + 1, gec2.cz - n6), new BlockPos(gec2.cx - 8 - 1, gec2.y0 - 2, gec2.cz - 3)};
        n3 = blockPosArray2.length;
        for (n2 = 0; n2 < n3; ++n2) {
            blockState = blockPosArray2[n2];
            serverWorld.setBlockState((BlockPos)blockState, Blocks.DIAMOND_ORE.getDefaultState(), 3);
            gfa.add((BlockPos)blockState);
        }
        gec2.warp = new BlockPos(gec2.cx, gec2.y0, gec2.cz + 8 + 2);
        BlockPos blockPos = gec2.spawn = gec2.id == 101 || gec2.id == 0 ? new BlockPos(gec2.cx, n, gec2.cz - 100) : new BlockPos(gec2.cx + 3, gec2.y0, gec2.cz + 8 + 4 + 18);
        if (gec2.id != 101 && gec2.id != 0) {
            for (int i = gec2.spawn.getX() - 3; i <= gec2.spawn.getX() + 3; ++i) {
                for (n3 = gec2.spawn.getZ() - 3; n3 <= gec2.spawn.getZ() + 3; ++n3) {
                    serverWorld.setBlockState(new BlockPos(i, gec2.y0 - 1, n3), Blocks.DIRT.getDefaultState(), 3);
                }
            }
        }
        double d = (double)gec2.cx + 0.5;
        double d2 = (double)gec2.y0 + 1.6;
        double d3 = (double)(gec2.cz + 8) - 0.5;
        if (gec2.armor) {
            for (int i = 0; i < 4; ++i) {
                ArmorStandEntity armorStandEntity = new ArmorStandEntity((World)serverWorld, d, d2 + 0.27 * (double)(3 - i), d3);
                armorStandEntity.setInvisible(true);
                armorStandEntity.setNoGravity(true);
                armorStandEntity.setCustomNameVisible(true);
                try {
                    Method method = ArmorStandEntity.class.getDeclaredMethod(a.b("\u6140\u18e7\u9225\u0c6d\u8796\u0134\ubb7e\u3281\uacc9", 1131569466), Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke((Object)armorStandEntity, true);
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    throw new RuntimeException(reflectiveOperationException);
                }
                serverWorld.spawnEntity((Entity)armorStandEntity);
                gec2.labels.add((Entity)armorStandEntity);
            }
        } else {
            DisplayEntity.TextDisplayEntity textDisplayEntity = (DisplayEntity.TextDisplayEntity)EntityType.TEXT_DISPLAY.create((World)serverWorld, SpawnReason.COMMAND);
            textDisplayEntity.refreshPositionAndAngles(d, d2, d3, 0.0f, 0.0f);
            serverWorld.spawnEntity((Entity)textDisplayEntity);
            gec2.labels.add((Entity)textDisplayEntity);
        }
        gef.ggx(gec2);
    }

    private static void ggw(ServerWorld serverWorld, gec gec2, Random random, double d) {
        Block[] blockArray = new Block[]{Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.REDSTONE_ORE, Blocks.LAPIS_ORE, Blocks.DIAMOND_ORE};
        double[] dArray = new double[]{0.04, 0.035, 0.025, 0.02, 0.018, 0.012};
        for (int i = gec2.cx - 8; i <= gec2.cx + 8; ++i) {
            for (int j = gec2.cz - 8; j <= gec2.cz + 8; ++j) {
                for (int k = gec2.y0 - gen; k <= gec2.y0 - 1; ++k) {
                    BlockState blockState;
                    double d2 = (double)(gec2.y0 - 1 - k) / (double)gen;
                    if (d > 0.0 && random.nextDouble() < d * (1.0 - d2)) {
                        blockState = Blocks.AIR.getDefaultState();
                    } else {
                        double d3 = random.nextDouble();
                        Block block = null;
                        double d4 = 0.0;
                        for (int i2 = 0; i2 < blockArray.length; ++i2) {
                            if (!(d3 < (d4 += dArray[i2]))) continue;
                            block = blockArray[i2];
                            break;
                        }
                        if (block == null) {
                            double d5 = random.nextDouble();
                            block = d5 < 0.35 ? Blocks.GRANITE : (d5 < 0.68 ? Blocks.COBBLESTONE : Blocks.DIORITE);
                        }
                        blockState = block.getDefaultState();
                    }
                    serverWorld.setBlockState(new BlockPos(i, k, j), blockState, 3);
                }
            }
        }
    }

    private static void ggx(gec gec2) {
        long l = Math.max(0L, gec2.refreshAt - gfe);
        if (!gfd) {
            l = gec2.refreshAt;
        }
        long l2 = (l + 19L) / 20L;
        String string = String.format(Locale.ROOT, a.b("\u74e3\u0d47\u8796\u19b1\u9238\u1496\uaed0\u2723\ub92a", -1893174065), l2 / 60L, l2 % 60L);
        CharSequence[] charSequenceArray = new String[]{a.c(1603983993, "\udace\ua3ee\u0f99\ub75a\u38bd\ube2e\u040d\u8d80\u17cc\u9978\u1eb3\ue4b7\u6a67\uf3a4\u7de7\udda4"), a.d("\u9aef\ue39f\u6d0b\uf360\u78b9\ufe09\u442d\ucdd1\u5389\ud941\u5eed\ua0e9\u2e24\ub712\u3d82", 104776162, 2082298789) + gec2.tier(), a.c(2098878652, "\u5808\u2178\uafd3\u318d\uba56\u3ce4\u86bb\u0f43\u9112\u1bab\u9c7d\u6601\uecc3\u7115\ufb34\u7db0\uc78a\u4859\ud6e7"), a.d("\u122f\u6b0f", 216376886, 1565373628) + string};
        if (gec2.armor) {
            for (int i = 0; i < 4 && i < gec2.labels.size(); ++i) {
                gec2.labels.get(i).setCustomName((Text)Text.literal((String)charSequenceArray[i]));
            }
        } else if (!gec2.labels.isEmpty()) {
            gef.ggy((DisplayEntity.TextDisplayEntity)gec2.labels.get(0), (Text)Text.literal((String)String.join((CharSequence)a.d("\u80bc", -1584902860, -413741693), charSequenceArray)));
        }
    }

    private static void ggy(DisplayEntity.TextDisplayEntity textDisplayEntity, Text text) {
        if (gfo == null) {
            for (Field field : DisplayEntity.TextDisplayEntity.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != TrackedData.class) continue;
                try {
                    field.setAccessible(true);
                    TrackedData trackedData = (TrackedData)field.get(null);
                    if (trackedData.dataType() != TrackedDataHandlerRegistry.TEXT_COMPONENT) continue;
                    gfo = trackedData;
                    break;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    throw new RuntimeException(reflectiveOperationException);
                }
            }
        }
        textDisplayEntity.getDataTracker().set(gfo, (Object)text);
    }

    private static void ggz(MinecraftServer minecraftServer, BlockPos blockPos, float f, float f2) {
        gfy = false;
        gfz = gfe + 20L;
        minecraftServer.getCommandManager().parseAndExecute(minecraftServer.getCommandSource(), String.format(Locale.ROOT, a.d("\u335e\u4aeb\uc068\u5e1c\ud59d\u537f\ue929\u60d3\ufe93\u7475\uf3e0\u0994\u8702\u1ef7\u94a1\u125b\ua80b\u278d\ubd78\u3b2c\ub2d0\uc89f\u467a\udded\u5b97\ud14d\u68e0\ue6e7", 1665173619, -1577075899), gfn, (double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, Float.valueOf(f), Float.valueOf(f2)));
    }

    private static void gha(kfe kfe2, String string, Object object) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            if (vmo2 instanceof vkl) {
                vkl vkl2 = (vkl)vmo2;
                vkl2.set((Boolean)object);
                continue;
            }
            if (vmo2 instanceof vmc) {
                vmc vmc2 = (vmc)vmo2;
                vmc2.set(((Number)object).doubleValue());
                continue;
            }
            if (!(vmo2 instanceof vmu)) continue;
            vmu vmu2 = (vmu)vmo2;
            vmu2.set((String)object);
        }
    }

    private static void ghb(MinecraftClient minecraftClient, String string, boolean bl) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
    }

    private static void ghc(MinecraftClient minecraftClient) throws Exception {
        for (Field field : Mouse.class.getDeclaredFields()) {
            if (!field.getName().equals(a.c(1445306881, "\ua26e\udbc9\u511d\ucf6d\u44a6\uc20a\u7867\uf1b5\u6fe6\ue55f\u6282\u98f2"))) continue;
            field.setAccessible(true);
            field.setBoolean(minecraftClient.mouse, true);
        }
    }

    private static void ghd(MinecraftClient minecraftClient, String string) {
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.c(-782319865, "\ubf67\uc6dc\u4c0c\ud265\u59f7\udf59") + string + a.d("\u8b42\uf2ad\u7860\ue618", -1649406285, -78674469)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static void ghe(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static /* synthetic */ void lambda$tick$2(MinecraftServer minecraftServer, boolean bl) {
        int n;
        ServerPlayerEntity serverPlayerEntity = minecraftServer.getPlayerManager().getPlayer(gfn);
        ItemStack itemStack = new ItemStack((ItemConvertible)Items.NETHERITE_PICKAXE);
        itemStack.addEnchantment((RegistryEntry)minecraftServer.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 10);
        itemStack.set(DataComponentTypes.LORE, (Object)new LoreComponent(List.of(Text.literal((String)a.c(-2035397662, "\u4b4b\u326a\ubc9f\u22bc\ua913\u2fd5\u95fe\u1c05\u8253\u08e0\u8f46\u7157\uffe9\u6658")), Text.literal((String)a.d("\u589c\u21bd\uaf45\u3118\ubacc\u3c73\u8625\u0fae\u9593\u1f4b", -1566566347, 1320239108)))));
        serverPlayerEntity.getInventory().setStack(3, new ItemStack((ItemConvertible)Items.DIAMOND_SWORD));
        serverPlayerEntity.getInventory().setStack(20, itemStack);
        for (n = 9; n < 36; ++n) {
            if (n == 20 || n == 35) continue;
            serverPlayerEntity.getInventory().setStack(n, new ItemStack((ItemConvertible)Items.COBBLESTONE, 64));
        }
        for (n = 5; n < 9; ++n) {
            serverPlayerEntity.getInventory().setStack(n, new ItemStack((ItemConvertible)Items.GRANITE, 64));
        }
        gec gec2 = gez.get(0);
        BlockPos blockPos = bl ? gec2.warp : gfg;
        gef.ggz(minecraftServer, blockPos, 180.0f, 10.0f);
        gff = bl ? gec2 : null;
    }

    private static /* synthetic */ void lambda$tick$1(MinecraftServer minecraftServer, BlockPos blockPos, boolean bl) {
        gef.ggp(minecraftServer, blockPos, bl);
    }

    static {
        gel = geg.equals(a.c(-698367663, "\uc127\ub892\u3253\uac22\u27e0"));
        gen = gel ? 10 : 6;
        geo = -1.0;
        gep = -1.0;
        geq = -1;
        ges = -1;
        gev = -1;
        gex = new ArrayList<String>();
        gez = new ArrayList<gec>();
        gfa = new ArrayList<BlockPos>();
        gfb = new ArrayList<String>();
        gfi = -1L;
        gfj = -1L;
        gfu = new ArrayList<Double>();
        gfv = Collections.synchronizedList(new ArrayList());
        gga = "";
        ggh = -1L;
        ggi = Integer.MAX_VALUE;
        ggj = -1.0;
    }

    private static /* synthetic */ int tq(int n, int n2) {
        return n - n2 | 0xD2BC6923;
    }
}

