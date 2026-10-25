/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.biome.BiomeKeys
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.haj;
import a.kfe;
import a.uze;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import com.mojang.datafixers.util.Pair;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import org.lwjgl.glfw.GLFW;

final class hav {
    private static final int haw = 560;
    private static final String hax = System.getenv(a.d("\u85a0\ufc1b\u76cb\ue8a2\u6310\ue5cc\u5f93\ud664\u4823\uc292\u4549\ubf2f\u31f9\ua850\u2211", 1348907992, 1368667697));
    private static final String hay = System.getenv().getOrDefault(a.c(1052766470, "\uf154\u88ef\u023f\u9c56\u17e4\u9138\u2b67\ua290\u3cd7\ub666\u31bd\ucbdb\u4501\udcbe\u56e9\ud00c\u6a4e\ue59a\u7f34\uf968"), a.d("\ud81b\ua182\u2b50\ub52c\u3ee7\ub84e", 1311960287, 346961039));
    private static final haj[] haz = new haj[]{new haj(0, a.b("\ubdaf\uc41f\u4ecc\ud0bc\u5b28\uddc7\u678c\uee6f", 1730854345), 6000L, 20.0f, -35.0f, 2, true), new haj(60, a.c(-1250528478, "\u7340\u0af0\u8023\u1e53\u95c7\u1328\ua963\u2080\ube8b\u3478\ub3a2\u49d3"), 6000L, 20.0f, -35.0f, 2, false), new haj(120, a.c(2103949630, "\ub95c\uc0ec\u4a3f\ud44f\u5fdb\ud92f\u637b\uea97\u74d3\ufe71\u79b7\u83c7"), 6000L, 20.0f, -4.0f, 2, true), new haj(150, a.c(370769509, "\u7e03\u07b3\u8d60\u1310\u9884\u1e68\ua42a\u2dd4"), 6000L, 0.0f, -25.0f, 2, true), new haj(180, a.b("\u7b5f\u02ef\u883c\u164c\u9dd8\u1b31\ua167", -1618642122), 6000L, 110.0f, -80.0f, 2, true), new haj(240, a.d("\u558b\u2c38\ua6f6\u389b\ub34b\u35fd\u8fa7\u061c\u981d\u12aa\u9562", -315705304, 1683484101), 1000L, -90.0f, -14.0f, 2, true), new haj(300, a.d("\uce77\ub7c4\u3d0a\ua367\u28b7\uae01\u145b\u9de0\u03e1\u8956\u0e9e\uf4ac\u7a39\ue381\u69d2", 831321394, 1505377063), 1000L, -90.0f, -14.0f, 2, false), new haj(360, a.c(926335586, "\uc203\ubbb0\u317e\uaf13\u24c3\ua275\u182f\u9194\u0f95\u853e\u02e0\uf890"), 1000L, -20.0f, -4.0f, 2, true), new haj(420, a.b("\u0f5e\u76ed\ufc23\u624e\ue99e\u6f28\ud572\u5cc9\uc2cf\u4878\ucfbc\u35cd\ubb0c", -2123690178), 600L, -90.0f, -6.0f, 2, true), new haj(480, a.d("\uc4f3\ubd44\u378c\ua9e0\u2221\ua481", 147622881, -102084761), 12300L, 90.0f, -8.0f, 2, true), new haj(540, a.c(-1773026547, "\uc374\ubac3\u300b\uae67\u25a6\ua306\u190c\u90bf\u0ee9\u8458"), 12300L, 90.0f, -8.0f, 2, false), new haj(600, a.b("\u4309\u3abe\ub076\u2e1a\ua5db\u237b\u9971\u10cf\u8e93\u0420\u83fb", 1323713393), 12300L, -90.0f, -12.0f, 2, true), new haj(660, a.b("\u2dc0\u5479\udea9\u40d0\ucb06\u4dbc\uf7ac\u7e18\ue046\u6af9\ued25", -699454036), 11500L, 90.0f, -2.0f, 30, true), new haj(720, a.b("\ude99\ua733\u2de9\ub39d\u3841\ubee8\u04bf\u8d10\u130a\u99ba\u1e67\ue419", 1023401702), 6000L, 30.0f, 50.0f, 60, true), new haj(780, a.c(1911884212, "\u09df\u7069\ufab4\u64ca\uef01"), 18000L, 20.0f, -25.0f, 2, true), new haj(840, a.b("\u2980\u5032\udaec\u4484\ucf40\u49b9\uf3a4\u7a5a\ue406\u6ead\ue96f\u1309", 175057389), 7000L, 20.0f, 25.0f, 260, true), new haj(900, a.c(-2092010399, "\u7401\u0db7\u8727\u1918\u92c0\u1472\uae3b\u27db\ub993"), 6000L, 20.0f, 0.0f, 170, true), new haj(960, a.c(-1176433532, "\u0cf2\u7550\uff8b\u61fd"), 6000L, 20.0f, -20.0f, 2, true, a.d("\ufafd\u835f\u0984\u97f2", 401680025, -1705321454)), new haj(1080, a.d("\u83a4\ufa00\u70c4\ueea1\u653d\ue3cd\u599d\ud074", 2003681537, 45236957), 6000L, 20.0f, -30.0f, 2, true, a.c(-373607180, "\u3492\u4d2c\uc7f6\u5983\ud247"), a.c(-713203076, "\u6233\u1ba1\u916a")), new haj(1180, a.d("\u6028\u198c\u9348\u0d2d\u86b1@\uba1b\u33eb\uadb9\u2714\ua0df", 331392141, 1608762590), 6000L, 20.0f, -30.0f, 2, true, a.d("\u337b\u4ac5\uc01f\u5e6a\ud5ae", -1770025454, -1143161585), a.b("\u163f\u6fa6\ue574\u7b08\uf0c3\u766a", 1478497908)), new haj(1280, a.c(1740664733, "\u6fe4\u1640\u9c84\u02e1\u897d\u0f89\ub5db\u3c24\ua274"), 6000L, 20.0f, -30.0f, 2, true, a.c(627887870, "\uce98\ub726\u3dfc\ua389\u284d"), a.d("\ue8e3\u9173\u1bae\u85d0", -1769312283, 586450762)), new haj(1380, a.b("\u4abc\u3318\ub9dc\u27b9\uac25\u2ad6\u908c\u197d", 1375488708), 6000L, 20.0f, -30.0f, 2, false, a.d("\u044c\u7df2\uf728\u695d\ue299", 534657431, 1913470397), a.b("\u492d\u30b4\uba66\u241a\uafd1\u2978", 1085950310))};
    private static final String[] hba = new String[]{a.b("\ud90f\ua08d\u2a47\ub436\u3fcf\ub94e\u0306\u8af9\u14a9\u9e04", 1648679235), a.d("\u9c46\ue5ce\u6f1e\uf176\u7ab9\ufc00\u4642\ucfb5\u51f1\udb4a\u5cbc\ua6e4\u283b", 2074228230, -696210917), a.b("\u6b86\u120c\u98d6\u06a2\u8d74\u0bd2\ub180", 1224305618), a.c(1310775573, "\ud94f\ua0c5\u2a1f\ub46b\u3fbd\ub91b\u0369\u8aa0\u14ed"), a.d("\u4320\u3ab3\ub07b\u2e17\ua5c6\u2376\u9909\u10d6\u8e90\u0426", -1950737812, 1473992971)};
    private static boolean[] hbb;
    private static volatile BlockPos hbc;
    private static volatile boolean hbd;
    private static int hbe;
    private static int hbf;
    private static /* synthetic */ long hbg;
    private static /* synthetic */ String hbh;

    private hav() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        int n2;
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\u2d8d\u540e\uded9\u40bd\ucb76\u4dca\uf78e", 399125981));
        if (n == 1) {
            hbb = new boolean[hba.length];
            for (int i = 0; i < hba.length; ++i) {
                kfe kfe3 = Flow.getInstance().getModuleManager().getByName(hba[i]);
                boolean bl = hav.hbb[i] = kfe3 != null && kfe3.isEnabled();
                if (!hbb[i]) continue;
                kfe3.setEnabled(false);
            }
            minecraftClient.options.hudHidden = true;
            minecraftClient.options.pauseOnLostFocus = false;
            minecraftClient.options.getViewDistance().setValue((Object)12);
            minecraftClient.options.getFov().setValue((Object)70);
            hav.hbo(minecraftClient, a.d("\u4741\u3ef6\ub429\u2a50\ua18f\u273c\u9d64\u1494\u8a8e|\u87be\u7dd8\uf30b\u6aaf\ue0e1\u660f\udc53", -1572610255, -1307994106));
            hav.hbo(minecraftClient, a.d("\u23f4\u5a43\ud09c\u4ee5\uc525\u4393\uf9d9\u7021\uee3b\u64ce\ue316\u194c\u97be\u0e17\u8451\u02a5\ub8e4\u373a\uad95\u2bf3\ua23e\ud875\u56c9\ucd11\u4b2b\uc1bc\u7808\uf654\u6cbc\ueafb", -1818013770, -2041680837));
            hav.hbo(minecraftClient, a.b("\u4ed2\u3765\ubdba\u23c3\ua803\u2eb5\u94ff\u1d07\u831d\u09e8\u8e30\u7479\ufa9c\u6329\ue96f\u6f82\ud5c0\u5a06\uc084\u46ef\ucf02\ub55c\u3be6\ua072\u264b\uac9d\u1523\u9b6d\u018c", -1012248920));
            hav.hbo(minecraftClient, a.d("\u218b\u5828\ud2ff\u4c9b\uc750\u41ec\ufba8\u720b\uec17\u66a9\ue173\u1b06\u95c2", -1765912565, -1984794118));
            GLFW.glfwSetWindowSize((long)minecraftClient.getWindow().getHandle(), (int)1920, (int)1080);
            hav.hbj(minecraftClient);
            return false;
        }
        if (n < 10) {
            return false;
        }
        if (hbe < 0) {
            if (!hbd) {
                return false;
            }
            if (hbc == null) {
                System.out.println(a.d("\u47c8\u3e7f\ub4b4\u2ac5\ua11a\u27bc\u9dee\u1407\u8a4a\u00b8\u8771\u7d4e\uf398\u6a66\ue073\u668b\udcd9\u531f\uc9ba\u4fec\uc64f\ubc58\u32e2\ua929\u2f4d\ua596", 424227595, -1101826902));
                return true;
            }
            System.out.println(a.c(655411913, "\ucab7\ub300\u39cb\ua7ba\u2c65\uaac3\u1091\u9978\u0735\u8ddd\u0a4f\uf02b\u7ea8") + hbc.toShortString());
            hav.hbi(minecraftClient, 2);
            hav.hbo(minecraftClient, a.c(-1938870532, "\u2e85\u5729\uddfe\u4387\uc815\u4ef7\uf4b2\u7d52\ue359\u69fe\uee2b\u145a\u9a8d"));
            ((vlv)hav.hbn(kfe2, a.c(793307129, "\ue7ac\u9e2b\u14fc\u8a9f\u0154\u87e4"))).set(a.d("\udb92\ua205\u28ce\ub6bf\u3d60\ubbc6", -1953456993, 1671513944));
            ((vlv)hav.hbn(kfe2, a.b("\u010c\u7899\uf25e\u6c22\ue7f0\u615c\udb02", -576454310))).set(hay);
            ((vmc)hav.hbn(kfe2, a.c(-796938429, "\uaf1a\ud69a\u5c5a\uc22d\u49e7\ucf5c\u7500\ufcf8\u62b1"))).set(0.6);
            ((vmc)hav.hbn(kfe2, a.b("\u686a\u11ed\u9b26\u054f\u8e81\u0829\ub27c", -1262655442))).set(0.5);
            ((vmc)hav.hbn(kfe2, a.c(-988393300, "\u50f7\u2960\ua3a8\u3d97\ub612\u30b0\u8afb\u0300"))).set(0.7);
            ((vmc)hav.hbn(kfe2, a.d("\u3eb8\u472c\ucdf1\u538f\ud844\u5ea1\ue4a1\u6d4b\uf31d\u79ab\ufe6a\u041c", -1869731792, -976611640))).set(0.6);
            ((vkl)hav.hbn(kfe2, a.c(178064093, "\u0a93\u730d\uf9dd\u67b6\uec70\u6a85\ud085\u596f\uc739\u4d8d\uca55\u303c\ubeef"))).set(true);
            ((vkl)hav.hbn(kfe2, a.d("\u4bb0\u322d\ub8fd\u268f\uad42\u2bf4\u91f5\u1843\u8609\u0cab\u8b7d\u710d", -1451883717, -1811855164))).set(true);
            kfe2.setEnabled(true);
            uze.timing(true);
            hbe = n;
            return false;
        }
        minecraftClient.player.getAbilities().flying = true;
        if (minecraftClient.currentScreen != null) {
            minecraftClient.setScreen(null);
        }
        if ((n2 = n - hbe - 560) == -40) {
            uze.gpuMillis();
        }
        if (n2 == -1) {
            System.out.println(a.b("\u01c4\u7873\uf2b8\u6cc9\ue716\u61b0\udbe2\u520b\ucc46\u46ae\uc13a\u3b5c\ub58e\u2c6a", -1134165575) + uze.gpuMillis() + a.c(1190163248, "\u7313\u0aef\u8022"));
        }
        for (haj haj2 : haz) {
            if (hax != null && !haj2.hal.startsWith(hax)) continue;
            if (n2 == haj2.hak - 50) {
                hav.hbo(minecraftClient, a.c(-82440434, "\u0f73\u76df\ufc08\u6271\ue9e3\u6f01\ud544\u5ca4\uc2af") + haj2.ham);
                hav.hbo(minecraftClient, a.b("\u390e\u40ad\uca7a\u541e\udfd5\u5969\ue32d\u6a8e", 1222785393) + haj2.har);
                if (haj2.hap != hbf) {
                    hav.hbi(minecraftClient, haj2.hap);
                }
                kfe2.setEnabled(haj2.haq);
                ((vlv)hav.hbn(kfe2, a.d("\u5cef\u257a\uafbd\u31c1\uba13\u3cbf\u86e1", 1006273857, -1823942152))).set(haj2.has);
                hav.hbm(minecraftClient, haj2.han, haj2.hao);
                continue;
            }
            if (n2 == haj2.hak - 20) {
                uze.gpuMillis();
                hav.hbm(minecraftClient, haj2.han, haj2.hao);
                continue;
            }
            if (haj2.hal.endsWith(a.c(-1933322089, "\ud8e4\ua144\u2b98")) && n2 > haj2.hak - 25 && n2 < haj2.hak) {
                hav.hbm(minecraftClient, haj2.han + (float)(n2 - (haj2.hak - 25)) * 1.6f, haj2.hao);
                continue;
            }
            if (n2 == haj2.hak - 2) {
                hav.hbm(minecraftClient, haj2.han, haj2.hao);
                continue;
            }
            if (n2 != haj2.hak) continue;
            System.out.println(a.b("\ua7f7\ude40\u548b\ucafa\u4125\uc783\u7dd1\uf438\u6a75\ue09d", 399157134) + haj2.hal + a.b("\uc5e1\ubc17\u36d3\ua8a7\u2325", -1349007932) + uze.gpuMillis() + a.c(-772547484, "\udc47\ua5bb\u2f76"));
            hav.hbp(minecraftClient, a.c(694147488, "\ud9d9\ua06e\u2aa5\ub4d4\u3f0b\ub9ad\u03ff\u8a16\u145b\u9ebe") + haj2.hal);
        }
        if (n2 > hav.haz[hav.haz.length - 1].hak + 10) {
            uze.timing(false);
            hav.hbo(minecraftClient, a.c(2008863721, "\ud393\uaa30\u20e7\ube83\u3548\ub3f4\u09b0\u8013\u1e0f\u94b1\u136b\ue91e\u67da"));
            minecraftClient.options.hudHidden = false;
            for (int i = 0; i < hba.length; ++i) {
                kfe kfe4 = Flow.getInstance().getModuleManager().getByName(hba[i]);
                if (kfe4 == null) continue;
                kfe4.setEnabled(hbb[i]);
            }
            return true;
        }
        return false;
    }

    private static void hbi(MinecraftClient minecraftClient, int n) {
        hbf = n;
        BlockPos blockPos = hbc;
        hav.hbo(minecraftClient, a.b("\u6871\u11c4\u9b47\u0556\u8eb2\u0850", -1251710973) + blockPos.getX() + a.b("\uf435", -1131416556) + (blockPos.getY() + n) + a.b("\u8201", 706380320) + blockPos.getZ());
    }

    private static void hbj(MinecraftClient minecraftClient) {
        hbc = null;
        hbd = false;
        IntegratedServer integratedServer = minecraftClient.getServer();
        BlockPos blockPos = minecraftClient.player.getBlockPos();
        integratedServer.execute(() -> {
            try {
                ServerWorld serverWorld = integratedServer.getOverworld();
                Pair pair = serverWorld.locateBiome(registryEntry -> registryEntry.matchesKey(BiomeKeys.FOREST), blockPos, 6400, 32, 64);
                if (pair != null) {
                    BlockPos blockPos2 = (BlockPos)pair.getFirst();
                    BlockPos blockPos3 = null;
                    int n = -1;
                    for (int i = -64; i <= 64; i += 4) {
                        for (int j = -64; j <= 64; j += 4) {
                            int n2;
                            int n3 = blockPos2.getX() + j;
                            int n4 = hav.hbl(serverWorld, n3, n2 = blockPos2.getZ() + i);
                            if (n4 <= n) continue;
                            n = n4;
                            blockPos3 = new BlockPos(n3, hav.hbk(serverWorld, Heightmap.Type.MOTION_BLOCKING, n3, n2), n2);
                        }
                    }
                    hbc = blockPos3;
                }
            }
            catch (Throwable throwable) {
                System.out.println(a.c(64572735, "\u4d55\u34e2\ube29\u2058\uab87\u2d21\u9773\u1e9a\u80d7\u0a3f\u8da0\u77d2\uf909\u60ba\ueafc\u6c1c\ud616\u5981\uc335\u456c\ucc9e\ub6c6\u3874\ua3fb\u259e") + throwable);
            }
            hbd = true;
        });
    }

    private static int hbk(ServerWorld serverWorld, Heightmap.Type type, int n, int n2) {
        serverWorld.getChunk(n >> 4, n2 >> 4);
        return serverWorld.getTopY(type, n, n2);
    }

    private static int hbl(ServerWorld serverWorld, int n, int n2) {
        int n3 = 0;
        int n4 = 0;
        for (int i = -12; i <= 12; i += 2) {
            for (int j = -12; j <= 12; j += 2) {
                boolean bl;
                int n5 = hav.hbk(serverWorld, Heightmap.Type.MOTION_BLOCKING, n + j, n2 + i);
                int n6 = hav.hbk(serverWorld, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, n + j, n2 + i);
                boolean bl2 = bl = Math.abs(j) <= 4 && Math.abs(i) <= 4;
                if (n5 == n6) {
                    if (!bl) continue;
                    ++n3;
                    continue;
                }
                if (bl) continue;
                ++n4;
            }
        }
        return n3 == 25 ? 100 + Math.min(n4, 60) : n3;
    }

    private static void hbm(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.player.setYaw(f);
        minecraftClient.player.setPitch(f2);
        minecraftClient.player.lastYaw = f;
        minecraftClient.player.lastPitch = f2;
    }

    private static vmo hbn(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.c(1185857171, "\ubebb\uc742\u4d98\ud3fb\u587f\ude80\u64d2\ued6c") + string);
    }

    private static void hbo(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void hbp(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u8bbc\uf21b\u78c1\ue6ba\u6d2b\uebce\u518c\ud86b\u4633\uccd6", 387877829) + string + a.d("\ub186\uc857\u42e4", -2081660703, -1918774972) + minecraftClient.getCurrentFps() + a.b("\uf4b2\u8d45\u0780\u99f2", -1447955306));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\uaf3f\ud684\u5c54\uc23d\u49af\ucf01", -1107120289) + string + a.c(2121033031, "\u656d\u1c82\u964f\u0837")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        hbe = -1;
        hbf = 2;
    }

    private static /* synthetic */ int yl(int n, int n2) {
        return n - n2 | 0x723689AD;
    }

    private static /* synthetic */ int ym(int n, int n2) {
        return hav.yl(n, n2) * n2;
    }
}

