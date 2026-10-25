/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.IronGolemEntity
 *  net.minecraft.item.Items
 *  net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.flj;
import a.wcn;
import flow.dev.a;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class flm {
    private static final int fln = 400;
    private static final int flo = 60;
    private static final String[] flp = new String[]{a.d("\u8b83\uf235\u78f7\ue682\u6d50\uebfc", -1704124698, 1663538448), a.d("\u6c33\u1585\u9f47\u0132\u8ae0\u0c4c\ub64d\u3fe5\ua1bd\u2b17", 2078710467, 582678153), a.d("\ua3f2\uda49\u509f\ucee4\u453b\uc3d7\u7982", 2129849168, 1493190851), a.b("\u7bcd\u0276\u88a0\u16db\u9d04\u1bef\ua1bd\u284c", 1494383523), a.d("\u0428\u7d84\uf758\u6938", 348307711, -1727216480), a.b("\u07d8\u7e74\uf4a8\u6ac8\ue144\u67ac\uddf8\u5412", 854132643), a.c(644102035, "\u37f2\u4e48\uc496\u5ae8\ud132\u5785")};
    private static final int[] flq = flm.fng();
    private static final int flr = flq.length;
    private static final int fls = 23;
    private static final int flt = 4;
    private static final boolean flu = System.getenv(a.c(51904108, "\ufe3a\u8781\u0d51\u9338\u188a\u9e56\u2419\uadf9\u33bd\ub911\u3ec9\uc4b4\u4a67\ud3c4\u5997\udf73")) != null;
    private static final int[] flv = new int[]{4, 6, 10, 16, 6};
    private static final int flw = 300;
    private static final int flx = 80;
    private static final ConcurrentLinkedQueue<flj> fly = new ConcurrentLinkedQueue();
    private static volatile flj flz;
    private static volatile int fma;
    private static volatile boolean fmb;
    private static volatile int fmc;
    private static volatile int fmd;
    private static boolean fme;
    private static boolean fmf;
    private static final int[] fmg;
    private static final int[] fmh;
    private static final int[] fmi;
    private static final int[] fmj;
    private static final boolean[] fmk;
    private static final int[] fml;
    private static final int[] fmm;
    private static final int[] fmn;
    private static final int[] fmo;
    private static int fmp;
    private static int fmq;
    private static int fmr;
    private static int fms;
    private static int fmt;
    private static int fmu;
    private static double fmv;
    private static double fmw;
    private static double fmx;
    private static float fmy;
    private static boolean fmz;
    private static int fna;
    private static int fnb;
    private static int fnc;
    private static final Random fnd;
    private static /* synthetic */ boolean fne;
    private static /* synthetic */ int fnf;

    private flm() {
    }

    static boolean crit(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (flm.fni(minecraftClient, false)) {
            return fmu == -1;
        }
        int n = (fmu - 60) / 400;
        int n2 = (fmu - 60) % 400;
        int n3 = n < flr ? flq[n] : -1;
        fmc = n3 >= 0 ? n3 : 15;
        flm.fnl();
        if (n3 < 0) {
            flm.fnn(minecraftClient);
            int n4 = 0;
            int n5 = 0;
            for (int n6 : flq) {
                System.out.println(a.b("\u7556\u0cf6\u863e\u1852\u93d1\u1534\uaf76\u2691\ub8c9\u322c\ub5af\u4fc6\uc118\u58bb\ud2fe\u544a", 15562021) + flp[n6] + a.b("\u266e\u5fc5\ud557\u4b33\uc0e4\u4640\ufc11\u75e8\uebaf\u6150", 1251878494) + fmg[n6] + a.c(-1018977563, "\ua2c2\udb30\u51f2\ucf98\u4452\uc2e4\u78f9") + fmh[n6] + a.d("\uecf7\u954e\u1fc5\u81a5\u0a70\u8cc9\u3694\ubf74\u212c\uabd4\u2c1d\ud624\u58f2\uc15e\u4b0a\ucdb5", -982959636, 1396626731) + fml[n6] + a.d("\u4761\u3e93\ub451\u2a3b\ua1f1\u2747\u9d5a", -185017319, 2097257311) + fmm[n6] + a.d("\u8c52", 1824051989, -869179537));
                n4 += fmg[n6];
                n5 += fmh[n6];
            }
            if (flu) {
                for (int i = 5; i <= 10; ++i) {
                    System.out.println(a.b("\u3da5\u4405\ucecd\u50a1\udb22\u5dc0\ue797\u6e74\uf02b\u7a8f\ufd0c\u0737\u89ff\u1056\u9a18\u1cb9\ua6a2\u296e\ub3d7\u358e\ubc32\uc668", 465059280) + i + a.d("\u3abb\u4310\uc997\u57e0\udc2c\u5a91\ue0d4\u696b", 1119165905, 1230579544) + fmn[i] + a.b("\u0c3c\u75ce\uff0c\u6166\ueaac\u6c1a\ud607", -1091892197) + fmo[i]);
                }
            }
            System.out.println(a.d("\u2092\u5932\ud3fa\u4d96\uc615\u40f0\ufab2\u7355\ued0d\u67e8\ue049\u1a2f\u94ee\u0d59\u8713\u01fa\ubbc1\u3451\uaef7\u28a6\ua144\udb17\u55ac\uce65\u4854", 1637075819, 1324804995) + n4 + a.c(-212783997, "\u2ca4\u5556\udf94\u41fe\uca34\u4c82\uf69f") + n5 + a.b("\uddf9\ua406\u2ed4\ub0a4\u3b30\ubdcf\u078d\u8e67\u1025\u9a93\u1d0e", 1667423698) + (n4 - n5));
            if (fmq > 0) {
                System.out.println(a.b("\ub5d6\ucc76\u46be\ud8d2\u5351\ud5b4\u6ff6\ue611\u7849\uf2ac\u7538\u8f42\u0198\u9826\u1278\u948f\u2e9f\ua154\u3ba0\ubdfa\u3400\u4e5e\uc0e0\u5b37\udd5e\u57c1", -372918865) + fmq + a.d("\uc8b8\ub141\u3b93\ua5ff\u2e61", -784412092, -910419239) + fmr);
            }
            return true;
        }
        boolean bl = n3 == 1 || n3 == 3 || n3 == 5;
        minecraftClient.options.jumpKey.setPressed(true);
        minecraftClient.options.forwardKey.setPressed(bl);
        float f = switch (n3) {
            case 2 -> 60.0f * MathHelper.sin((double)((float)n2 * ((float)Math.PI * 2) / 12.0f));
            case 3 -> 100.0f * MathHelper.sin((double)((float)n2 * ((float)Math.PI * 2) / 8.0f));
            case 4, 5 -> {
                if (n2 % 3 == 0) {
                    fmy = fnd.nextFloat() < 0.5f ? 0.0f : (float)(fnd.nextBoolean() ? 1 : -1) * (40.0f + fnd.nextFloat() * 120.0f);
                }
                yield fmy;
            }
            case 6 -> {
                int var7_11 = n2 % 23;
                if (var7_11 == 0) {
                    if (fmt >= 0 && fmg[6] > fms) {
                        ++fmr;
                    }
                    ++fmq;
                    fmt = fmu;
                    fms = fmg[6];
                }
                if (var7_11 < 4) {
                    yield 0.0f;
                }
                yield 90.0f;
            }
            default -> 0.0f;
        };
        flm.fnk(clientPlayerEntity, f);
        if (flu) {
            flm.fnm(minecraftClient, clientPlayerEntity);
        }
        return false;
    }

    static boolean mace(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (flm.fni(minecraftClient, true)) {
            return fmu == -1;
        }
        flm.fnl();
        flm.fnk(clientPlayerEntity, 0.0f);
        if (fmu < 140) {
            fmc = 0;
            minecraftClient.options.jumpKey.setPressed(false);
        } else if (fmu < 290) {
            fmc = 1;
            minecraftClient.options.jumpKey.setPressed(true);
        } else if (fmu < 300) {
            fmc = 15;
            minecraftClient.options.jumpKey.setPressed(false);
        } else {
            boolean bl;
            int n = (fmu - 300) / 80;
            int n2 = (fmu - 300) % 80;
            if (n >= flv.length) {
                flm.fnn(minecraftClient);
                flm.fnh(a.d("\uab33\ud297\u5859\uc632\u4dfe\ucb45", 1985298171, 837588393), 0, false, false);
                flm.fnh(a.b("\u10f8\u6956\ue39d\u7df1\uf63f\u7089\ucad3", 873599125), 1, false, false);
                for (int i = 0; i < flv.length; ++i) {
                    flm.fnh(a.b("\ua1bb\ud81c\u52d2\uccbc\u473b", 518496730) + flv[i] + (i == flv.length - 1 ? a.c(-220268974, "\uf678\u8f9c\u0554\u9b28\u10f4\u964c\u2c0c\ua5e8\u3bb5\ub105") : ""), 2 + i, true, i != flv.length - 1);
                }
                System.out.println(a.d("\ud5ed\uac50\u2681\ub8f6\u3364\ub581\u0fc3\u8624\u187c\u9299", -1491480770, 723589812) + (fmp == 0 ? a.d("\u8cb7\uf517\u7fd6\ue1a7", -1491103736, 1156914411) : a.c(-471321820, "\u3364\u4ad2\uc009\u5e7d\ud5c6\u537f") + fmp + a.b("\u5d88", 1012161952)));
                return true;
            }
            fmc = 2 + n;
            boolean bl2 = bl = n == flv.length - 1;
            if (n2 == 0) {
                if (bl) {
                    clientPlayerEntity.getInventory().setSelectedSlot(1);
                }
                flm.fnp(minecraftClient, String.format(Locale.ROOT, a.c(-865372405, "\u7764\u0ed1\u8452\u1a43\u91a7\u1745\uad13\u24e9\ubaaa\u304f\ub7da\u4dae\uc372\u5adf\ud0d8\u566f\uec25\u63ff\uf950\u7f55\uf6e4\u8cb8\u021f\u99c7\u1fa8\u956f\u2cda"), fmv - 1.3, fmw + (double)flv[n], fmx));
            } else if (n2 == 2 && bl) {
                clientPlayerEntity.getInventory().setSelectedSlot(0);
            }
        }
        return false;
    }

    private static int[] fng() {
        String string = System.getenv(a.d("\uff29\u8692\u0c42\u922b\u1999\u9f45\u250a\uacea\u32ae\ub802\u3fda\uc5bb\u4b6d\ud2de\u5898", 1336180136, -1449098552));
        if (string == null) {
            int[] nArray = new int[flp.length];
            for (int i = 0; i < nArray.length; ++i) {
                nArray[i] = i;
            }
            return nArray;
        }
        String[] stringArray = string.split(a.c(374375650, "\u84cf"));
        int[] nArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            nArray[i] = Arrays.asList(flp).indexOf(stringArray[i].trim());
        }
        return nArray;
    }

    private static void fnh(String string, int n, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl ? fmg[n] >= 1 && fmi[n] == fmg[n] && fmj[n] == 0 && (!bl2 || fmk[n]) : (bl3 = fmg[n] == 0);
        if (!bl3) {
            ++fmp;
        }
        System.out.println(a.b("\u710a\u08b7\u8266\u1c11\u9783", -1717669534) + string + (bl3 ? a.b("\u66ce\u1f30\u95e7", -847812883) : a.d("\u03d6\u7a01\uf0d5\u6eac\ue57e", -273147928, -1474685925)) + a.d("\u2576\u5cdd\ud64f\u482b\uc3fc\u4558\uff09\u76f0\ue8b7\u6248", 1063345825, -754156569) + fmg[n] + a.d("\ueda5\u9447\u1e8a\u80f7\u0b32\u8d98\u379e", 1400336396, 1445371278) + fmi[n] + a.d("\uc29c\ubb6e\u31ac\uafc6\u240c\ua2f4", -2076476884, 1207220374) + fmh[n] + a.b("\u3cce\u4539\ucfe5\u518f\uda59\u5cef\ue68b\u6f4b\uf10f\u7ba3\ufc39", 510868709) + fmk[n] + a.d("\u31e2\u481a\uc2ce\u5ca5\ud769\u51fe\ueba2\u6267\ufc2b\u7696\uf14d\u0b2a\u85b3", 1171666054, 571999561) + fmj[n] + a.b("\ua9c1\ud078\u5af4\uc493\u4f4b\uc9e0\u73e7", 1881778662) + (bl ? a.d("\udf0d\ua6a2\u2c7d\ub21e\u39d2", 864346494, 1168850437) + (bl2 ? a.b("\uf40c\u8db6\u076e\u995c\u129a\u9430\u2e7e\ua7db\u39c2\ub37c\u34b4\ucec4\u4014", -35982303) : "") : a.b("\u3ec6\u4776\ucda4\u53de", 670711468)) + a.c(-2101192973, "\u56db"));
    }

    private static boolean fni(MinecraftClient minecraftClient, boolean bl) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        fmf = bl;
        flm.fnj();
        wcn.ensure(minecraftClient);
        if (++fmu == 1) {
            int n = MathHelper.floor((double)clientPlayerEntity.getX());
            int n2 = MathHelper.floor((double)clientPlayerEntity.getY());
            int n3 = MathHelper.floor((double)clientPlayerEntity.getZ());
            fmv = (double)n + 2.8;
            fmw = n2;
            fmx = (double)n3 + 0.5;
            flm.fnp(minecraftClient, a.c(-1452320767, "\u5877\u21c0\uab1f\u3566\ubeb9\u380a\u8252\u0ba2\u95b8\u1f5a\u988f\u62f9\uec2a\u7584\uffc8\u792e\uc36c"));
            flm.fnp(minecraftClient, a.b("\u242b\u5d99\ud74a\u4938\uc2e9\u444f\ufe48\u77fe\ue9af\u6301\ue4c1\u1ef5\u9042\u09c0\u83c0\u0563\ubf3b\u30fc\uaa55\u2c1e\ua5ee\udfaa\u5116\ucaca\u4cb3\uc627\u7f8d\uf1d5\u6b22\ued63\u66c4\u9801\u121a\u8bed\u0db9\u8718", -1998969750));
            flm.fnp(minecraftClient, a.c(1471835660, "\u6e4d\u17ff\u9d2c\u035e\u888f\u0e29\ub42e\u3d98\ua3c9\u2967\uaea7\u5493\uda24\u43a6\uc9a6\u4f04\uf559\u7a9d\ue02f\u6679\uef9d\u95d9\u1b77\u80a0\u06de\u8c41\u35eb\ubbb3\u2144\ua705\u2ca2\ud267\u587c\uc18b\u47df\ucd7e"));
            flm.fnp(minecraftClient, a.c(-2059059030, "\u40c1\u397f\ub3a5\u2dd0\ua614\u20f7\u9ac4\u1306"));
            flm.fnp(minecraftClient, a.c(-1724250924, "\u04aa\u7d19\uf7cf\u69be\ue225\u64f4\ude82\u574d\uc93d\u4381\uc45b\u3e3f\ub0b0\u291d\ua31f\u25f2\u9fb0\u1079\u8ad6\u0c90\u8548"));
            if (bl) {
                flm.fnp(minecraftClient, a.b("\ub29b\ucb37\u41f5\udf8c\u5416\ud2f5\u68b1\ue155\u7f16\uf5aa\u727b\u880c\u069e\u9f6a\u1532\u93d9\u298b\ua647\u3cf9\ubaf1\u3366\u4904\uc7e4\u5c7d\uda05\u50cf\ue96a\u6738\ufddc\u7bd1\uf07c\u0ebd\u84a5\u1d4a\u9b04\u11a9\uae36\u240a\ua2dd\u3b6b\ub13f\ucfc8\u458a\uc228\u58f8\ud69b\u6f06\ue5e0\u63a3\uf870\u7605", -632180031));
                flm.fnp(minecraftClient, a.c(-1758258951, "\u18ac\u6100\uebc2\u75bb\ufe21\u78c2\uc286\u4b62\ud521\u5f9d\ud84c\u223b\uaca9\u355d\ubf05\u39ee\u83bc\u0c70\u96ce\u10c6\u9951\ue333\u6dd3\uf64a\u7032\ufaf8\u435d\ucd0f\u57eb\ud1e6\u5a4a\ua48a\u2e92\ub77d\u3133\ubb9e\u0401\u8e3d\u08ea\u915c\u1b08\u65ff\uefbd\u681f\uf2cf\u7cac\uc531\u4fde\uc99c\u5245\udc3a\u26e9\uaf5f\u2904\ub3cc\u3db1\u860a\u00c3\u8aad\u136a"));
            } else {
                flm.fnp(minecraftClient, a.d("\uc15b\ub8f7\u3235\uac4c\u27d6\ua135\u1b71\u9295\u0cd6\u866a\u01bb\ufbcc\u755e\uecaa\u66f2\ue019\u5a4b\ud587\u4f39\uc931\u40a6\u3ac4\ub424\u2fbd\ua9c5\u230f\u9aaa\u14f8\u8e1c\u0811\u83bc\u7d7d\uf765\u6e8a\ue8c4\u6269\uddf6\u57ca\ud11d\u48ab\uc2ff\ubc08\u364a\ub1e8\u2b38\ua55b\u1cc6\u9629\u106b\u8bb2\u05cd\uff1e\u76a8\uf0f3\u6a3b\ue446\u5ffd\ud934\u535a\uca9d", 1446161584, 101739966));
                flm.fnp(minecraftClient, String.format(Locale.ROOT, a.d("\ua5e6\udc58\u568e\uc8ff\u4364\uc5d0\u7fc2\uf677\u682d\ue2dd\u654a\u9f3e\u11a8\u885d\u020b\u84bb\u3eb0\ub164\u2b96\uad83\u2471\u5e61\ud096\u4b0a\ucd71\u47a7\ufe1f\u7048\ueaae\u6cec\ue758\u199b\u939a\u0a22\u8c76\u06dc\ub90a\u3370\ub5e6\u2c1f\ua647\ud8b5\u52e6\ud554\u4f9b", 582359879, -1867333910), n - 3, n2 - 1, n3 - 3, n + 4, n2 + 3, n3 + 3));
            }
            flm.fnp(minecraftClient, String.format(Locale.ROOT, a.b("\ua160\ud8d5\u5256\ucc47\u47a3\uc141\u7b17\uf2ed\u6cad\ue64b\u61de\u9baa\u153c\u8cc9\u069f\u8065\u3a35\ub5b3\u2f46\ua91a\u20f9\u5aa1\ud402\u4fc3", -1601396468), (double)n + 0.5, n2, (double)n3 + 0.5));
            flm.fnp(minecraftClient, String.format(Locale.ROOT, a.b("\uc6bb\ubf0c\u35c7\uabb6\u2063\ua6d3\u1cce\u9572\u0b29\u819f\u0647\ufc30\u72f6\ueb54\u6100\ue7e3\u5de2\ud260\u48c8\uce84\u4772\u3d12\ub399\u2840\uae3c\u24e4\u9d5f\u1343\u89b1\u0feb\u8444\u7ac1\uf0c8\u693c\uef2e\u65db\uda09\u5073\ud6bc\u4f59\uc540\ubbea\u318c\ub61c\u2ce5\ua29c\u1b3c\u9186\u179a\u8c05\u0209\uf8e2\u7150\uf708\u6df0\ue3bb\u584a\ude90\u54b0\ucd2f\u43e4\u3980\ube64\u3434\uaae1\u234a\u991e\u1ffe\u95a2\u0a1e\u80cb\u068d\uff65\u75c0\ueb97\u607a\ue636\u5c90\ud542\u4b6d\uc1a9\u47ab\u3c56\ub2ca\u28a8\ua179\u27cc\u9d86\u1272\u8834\u0e86\u8746\u7d27\uf3bf\u686d\uee1c\u64c1\udabd\u5330\uc999\u4f81\uc474\uba20\u309a\ua943\u2f23\ua5e3\u1a55\u9010\u16af\u8cab\u0516\ufbc0\u71b6\uf672\u6c2e\ue29d\u5b41\ud12a\u57e7\ucc12\u424d\u38f0\ubea2\u3707\uadc0\u23ec\u9836\u1e78\u94cb\u0d1e\u8375\u79bc\ufe40\u7433\ueab3\u6088\ud914\u5fc3\ud5bf\u4a70\uc0dd\u46dc\u3f26\ub568\u2bbb\ua00e\u260d\u9ce1", -1394162083), fmv, n2, fmx));
            flm.fnp(minecraftClient, a.c(-1625792642, "\u5f5f\u26ed\uac3e\u324c\ub99d\u3f3b\u853c\u0c8a\u92db\u1875\u9fb5\u6581\ueb36\u72a2\uf8cf\u7e11\uc453\u4b8b\ud12d\u5724\ude83\ua4d6\u2a62\ub1b8\u37c1\ubd01\u04a1\u8af7\u1012\u960d\u1ded\ue327\u6975\uf085\u76e7\ufc6e\u43b1\uc9c3\u4f19\ud6a0\u5ccf\u2243\ua842\u2fe4\ub525\u3b4e\u8287\u0831\u8e6b\u15b5\u9bcb\u611c\ue8ee\u6ef6\uf402\u7a5b\uc1eb\u473d\ucd49\u5485\uda23\ua037\u27d7\uad95\u330e\ubab9\u00ed\u860c"));
            clientPlayerEntity.getInventory().setSelectedSlot(0);
            return true;
        }
        if (fmu == 30) {
            Entity entity = null;
            for (Entity entity2 : minecraftClient.world.getEntities()) {
                if (!(entity2 instanceof IronGolemEntity)) continue;
                entity = entity2;
            }
            if (entity == null) {
                System.out.println(a.c(1341095332, "\u7dd0\u0470\u8eb8\u10d4\u9b57\u1db2\ua7f0\u2e17\ub04f\u3aaa\ubd1f\u4769\uc9b6\u5002\uda3d\u5c82\ue6cc\u6952\uf3a6\u75ff\ufc0b\u8653\u08e8"));
                fmu = -1;
                return true;
            }
            fma = entity.getId();
            fmv = entity.getX();
            fmw = entity.getY();
            fmx = entity.getZ();
            flm.fno();
            return true;
        }
        if (fmu < 60) {
            return true;
        }
        fmb = true;
        return false;
    }

    private static void fnj() {
        if (fme) {
            return;
        }
        fme = true;
        AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
            int n;
            if (world.isClient() || !fmb || entity.getId() != fma) {
                return ActionResult.PASS;
            }
            float f = playerEntity.getAttackCooldownProgress(0.5f);
            boolean bl = f > 0.9f && playerEntity.fallDistance > 0.0 && !playerEntity.isOnGround() && !playerEntity.isClimbing() && !playerEntity.isTouchingWater() && !playerEntity.hasVehicle() && !playerEntity.isSprinting();
            boolean bl2 = playerEntity.getMainHandStack().isOf(Items.MACE) && playerEntity.fallDistance > 1.5 && !playerEntity.isGliding();
            int n2 = fmc;
            if (fmg[n2] == 0) {
                flm.fmk[n2] = bl;
            }
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                if (livingEntity.timeUntilRegen > 10) {
                    int n3 = n2;
                    fmj[n3] = fmj[n3] + 1;
                }
            }
            int n4 = n2;
            fmg[n4] = fmg[n4] + 1;
            if (bl) {
                int n5 = n2;
                fmh[n5] = fmh[n5] + 1;
            }
            if (bl2) {
                int n6 = n2;
                fmi[n6] = fmi[n6] + 1;
            }
            if ((n = fmd) >= 0) {
                int n7 = n;
                fmn[n7] = fmn[n7] + 1;
                if (bl) {
                    int n8 = n;
                    fmo[n8] = fmo[n8] + 1;
                }
                fmd = -1;
            }
            if (!bl || fmf) {
                System.out.println(String.format(Locale.ROOT, a.d("\ue830\u9190\u1b58\u8534\u0eb7\u8855\u3210\ubbf6\u25ad\uaf0f\u28cb\ud2e8\u5c7e\uc5da\u4f89\uc96d\u7320\ufcf9\u6601\ue003\u69eb\u13b9\u9d11\u0689\u80ee\u0a7e\ub389\u3d81\ua732\u217b\uaac3\u540f\ude15\u47a2\uc1b7\u4b01\uf4db\u7eaa\uf828\u6181\uebd5\u9539\u1f3f\u98c8\u0258\u8c3c\u35f2\ubf59\u390d\ua2d6\u2cfc\ud635\u5fd4\ud9d6\u4376\ucd24\u7699\uf053\u7a27\ue3ec\u6d12\u175b\u90fe\u1afc\u8470\u0dca\ub790\u3172\ubb30\u2483\uae08\u2861\ud1b5\u5b19\uc51f\u4ea8\uc8ac\u7203\ufbdc\u65bf\uef6b\u696f\u12c4\u9c43\u0667\u8fbb\u091b\ub354\u3cae\ua6a9", 1981648075, 1198810306), n2, playerEntity.getY() - fmw, playerEntity.fallDistance, playerEntity.isOnGround(), playerEntity.isSprinting(), Float.valueOf(f), bl2, bl ? a.d("\u436d\u3acd\ub005\u2e69", 1603297142, 395975772) : a.c(70411306, "\u6443\u1df3\u976f\u095d\u829b\u0431\ube7f")));
            }
            return ActionResult.PASS;
        });
        wcn.listen(packet -> {
            EntityAnimationS2CPacket entityAnimationS2CPacket;
            EntityDamageS2CPacket entityDamageS2CPacket;
            if (packet instanceof EntityDamageS2CPacket && (entityDamageS2CPacket = (EntityDamageS2CPacket)packet).entityId() == fma) {
                flj flj2;
                flz = flj2 = new flj();
                fly.add(flj2);
            } else if (packet instanceof EntityAnimationS2CPacket && (entityAnimationS2CPacket = (EntityAnimationS2CPacket)packet).getEntityId() == fma && entityAnimationS2CPacket.getAnimationId() == 4 && flz != null) {
                flm.flz.crit = true;
            }
        });
    }

    private static void fnk(ClientPlayerEntity clientPlayerEntity, float f) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        double d = fmv - vec3d.x;
        double d2 = fmw + 1.35 - vec3d.y;
        double d3 = fmx - vec3d.z;
        float f2 = (float)(MathHelper.atan2((double)d3, (double)d) * 57.2957763671875) - 90.0f;
        float f3 = (float)(-(MathHelper.atan2((double)d2, (double)Math.sqrt(d * d + d3 * d3)) * 57.2957763671875));
        clientPlayerEntity.setYaw(f2 + f);
        clientPlayerEntity.setPitch(f3);
    }

    private static void fnl() {
        flj flj2;
        long l = System.nanoTime();
        while ((flj2 = fly.peek()) != null && l - flj2.at > 60000000L) {
            fly.poll();
            int n = fmc;
            fml[n] = fml[n] + 1;
            if (!flj2.crit) continue;
            int n2 = fmc;
            fmm[n2] = fmm[n2] + 1;
        }
    }

    private static void fnm(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        boolean bl = clientPlayerEntity.isOnGround();
        if (fmz && !bl && clientPlayerEntity.getVelocity().y > 0.0) {
            fna = fmu;
            fnc = ++fnb % 2 == 0 ? 5 + fnb / 2 % 6 : -1;
        }
        fmz = bl;
        if (fnc > 0 && fmu - fna == fnc - 1) {
            fmd = fnc;
            KeyBinding.onKeyPressed((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.attackKey));
        }
    }

    private static void fnn(MinecraftClient minecraftClient) {
        minecraftClient.options.jumpKey.setPressed(false);
        minecraftClient.options.forwardKey.setPressed(false);
    }

    /*
     * Exception decompiling
     */
    private static void fno() {
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

    private static void fnp(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    static {
        fma = -1;
        fmd = -1;
        fmg = new int[16];
        fmh = new int[16];
        fmi = new int[16];
        fmj = new int[16];
        fmk = new boolean[16];
        fml = new int[16];
        fmm = new int[16];
        fmn = new int[16];
        fmo = new int[16];
        fmt = -1;
        fna = -1;
        fnc = -1;
        fnd = new Random(7L);
    }

    private static /* synthetic */ int px(int n, int n2) {
        return n + n2 + 305971736;
    }

    private static /* synthetic */ int py(int n, int n2) {
        return flm.px(n, n2) ^ 0xC43A5461;
    }

    private static /* synthetic */ int pz(int n, int n2) {
        return flm.px(n, n2) * n2;
    }
}

