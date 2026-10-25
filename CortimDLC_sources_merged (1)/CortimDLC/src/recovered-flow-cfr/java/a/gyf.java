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

import a.gxv;
import a.kfe;
import a.vbb;
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

final class gyf {
    private static final int gyg = 520;
    private static final String gyh = System.getenv(a.d("\u3b83\u4238\uc8e8\u5681\udd33\u5bef\ue1b0\u685c\uf602\u7cab\ufb7c\u0115\u8fd0", 1365182924, -835505660));
    private static final gxv[] gyi = new gxv[]{new gxv(0, a.d("\ub7ce\uce7e\u44ad\udadd\u5149\ud7bd\u6de9\ue405\u7a41\uf0e3\u7725\u8d55", 60358362, 1470712182), 6000L, 20.0f, -6.0f, true), new gxv(50, a.b("\ub9ad\uc01d\u4ace\ud4be\u5f2a\ud9de\u638a\uea66\u7422\ufe80\u7946\u8336\u0da2\u9451\u1e0b\u98fa", 349288915), 6000L, 20.0f, -6.0f, false), new gxv(100, a.d("\u731a\u0aaa\u8079\u1e09\u959d\u1372\ua939\u20da", 2054751784, -1789037228), 6000L, 20.0f, -40.0f, true), new gxv(150, a.b("\u5a8f\u233f\ua9ec\u379c\ubc08\u3ae7\u80ac\u094f\u9744\u1db7\u9a6d\u601c", 31021805), 6000L, 20.0f, -40.0f, false), new gxv(200, a.b("\u626a\u1bda\u9109\u0f79\u84ed\u0216\ub850\u31bc\uaff9\u2553\ua28a", 1711497743), 6000L, 200.0f, 24.0f, true), new gxv(250, a.d("\u59c7\u2077\uaaa4\u34d4\ubf40\u39a9\u83ff", -379485087, -1011163697), 6000L, 110.0f, -80.0f, true), new gxv(300, a.b("\u2b4a\u52fd\ud835\u4659\ucd98\u4b38", 2060266303), 12600L, 90.0f, -8.0f, true), new gxv(350, a.b("\u6450\u1de7\u972f\u0943\u8282\u0422\ube28\u379b\ua9cd\u237c", 1983800361), 12600L, 90.0f, -8.0f, false), new gxv(400, a.c(-704540110, "\u924a\uebfd\u6135\uff59\u7498\uf238\u4832\uc18c\u5fd0\ud563\u52b8"), 12600L, -90.0f, -8.0f, true), new gxv(450, a.c(849353471, "\u1a94\u6322\ue9ff\u7781\ufc4a"), 18000L, 20.0f, -10.0f, true), new gxv(500, a.d("\ub6da\ucf6c\u45b1\udbcf\u5004\ud6ec\u6cfd\ue505\u7b5a", -313265039, 202457804), 18000L, 20.0f, -10.0f, false), new gxv(550, a.c(1994568529, "\ub331\uca85\u4040\ude28"), 23300L, -90.0f, -8.0f, true), new gxv(600, a.b("\u297c\u50d6\uda0c\u4478\ucfae\u4908\uf35a\u7af5\ue4e9\u6e59\ue98a\u13fa", 1480796419), 6000L, 20.0f, -6.0f, true, a.c(1054554636, "\u3a58\u43d2\uc908\u577c\udcaa\u5a0c\ue05e")), new gxv(650, a.c(-959936650, "\u871a\ufea2\u7479\uea42\u61cb\ue77c\u5d34\ud4d8\u4a91\uc031"), 12600L, 90.0f, -8.0f, true, a.c(193987550, "\u0385\u7a0d\uf0dd\u6eb5\ue57a\u63c3\ud981\u5076\uce32\u4489\uc37f\u3927\ub7f8")), new gxv(700, a.b("\u34a2\u4d1a\uc7c1\u59fa\ud26e\u54de\uee8d\u677d", -1249102644), 6000L, 20.0f, -6.0f, true, a.d("\u9fa9\ue621\u6cf1\uf299\u7956\uffef\u45ad\ucc5a\u521e\ud8a5\u5f53\ua50b\u2bd4", -677117518, -1169449408))};
    private static final String[] gyj = new String[]{a.c(-1930034235, "\u0389\u7a0b\uf0c1\u6eb0\ue549\u63c8\ud980\u507f\uce2f\u4482"), a.c(-634180919, "\u2a92\u531a\ud9ca\u47a2\ucc6d\u4ad4\uf096\u7961\ue725\u6d9e\uea68\u1030\u9eef"), a.c(1730274806, "\ue5a2\u9c28\u16f2\u8886\u0350\u85f6\u3fa4"), a.b("\u78b8\u0132\u8be8\u159c\u9e4a\u18ec\ua29e\u2b57\ub51a", -382371614), a.b("\uacbe\ud52d\u5fe5\uc189\u4a58\ucce8\u7697\uff48\u610e\uebb8", 41921785)};
    private static boolean[] gyk;
    private static volatile BlockPos gyl;
    private static volatile boolean gym;
    private static int gyn;
    private static /* synthetic */ String gyo;
    private static /* synthetic */ String gyp;

    private gyf() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        int n2;
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(281520761, "\uaa29\ud3aa\u597d\uc719\u4cd2\uca6e\u702a"));
        if (n == 1) {
            gyk = new boolean[gyj.length];
            for (int i = 0; i < gyj.length; ++i) {
                kfe kfe3 = Flow.getInstance().getModuleManager().getByName(gyj[i]);
                boolean bl = gyf.gyk[i] = kfe3 != null && kfe3.isEnabled();
                if (!gyk[i]) continue;
                kfe3.setEnabled(false);
            }
            minecraftClient.field_1690.field_1842 = true;
            minecraftClient.field_1690.field_1837 = false;
            minecraftClient.field_1690.method_42503().method_41748((Object)12);
            minecraftClient.field_1690.method_41808().method_41748((Object)70);
            gyf.gyt(minecraftClient, a.d("\uc33d\uba8a\u3055\uae2c\u25f3\ua340\u1918\u90e8\u0ef2\u8400\u03c2\uf9a4\u7777\ueed3\u649d\ue273\u582f", 1618221021, 822727830));
            gyf.gyt(minecraftClient, a.c(1050601701, "\ue89c\u912b\u1bf4\u858d\u0e4d\u88fb\u32b1\ubb49\u2553\uafa6\u287e\ud224\u5cd6\uc57f\u4f39\uc9cd\u738c\ufc52\u66fd\ue09b\u6956\u131d\u9da1\u0679\u8043\u0ad4\ub360\u3d3c\ua7d4\u2193"));
            gyf.gyt(minecraftClient, a.c(-988955079, "\ube43\uc7f4\u4d2b\ud352\u5892\ude24\u646e\ued96\u738c\uf979\u7ea1\u84e8\u0a0d\u93b8\u19fe\u9f13\u2551\uaa97\u3015\ub67e\u3f93\u45cd\ucb77\u50e3\ud6da\u5c0c\ue5b2\u6bfc\uf11d"));
            gyf.gyt(minecraftClient, a.c(1727764634, "\u98e0\ue143\u6b94\uf5f0\u7e3b\uf887\u42c3\ucb60\u557c\udfc2\u5818\ua26d\u2ca9"));
            GLFW.glfwSetWindowSize((long)minecraftClient.method_22683().method_4490(), (int)1920, (int)1080);
            gyf.gyq(minecraftClient);
            return false;
        }
        if (n < 10) {
            return false;
        }
        if (gyn < 0) {
            if (!gym) {
                return false;
            }
            BlockPos blockPos = gyl;
            if (blockPos == null) {
                System.out.println(a.b("\uf632\u8f9e\u054c\u9b25\u10f6\u965f\u2c1e\ua5ac\u3be9\ub116\u36c4\uccfa\u427e\udbd2\u5180\ud769\u6d28\ue2a0\u7851\ufe0b\u77fa\u0da9\u8312\u1886\u9ebf\u1467\uadce\u2384\ub979", -1958414756));
                return true;
            }
            System.out.println(a.d("\ua62a\udf86\u5554\ucb3d\u40ee\uc647\u7c06\uf5ae\u6bb0\ue114\u6693", -391784404, 94928510) + blockPos.method_23854());
            gyf.gyt(minecraftClient, a.b("\ua250\udbe5\u5166\ucf77\u4493\uc271", 1153802786) + blockPos.method_10263() + a.b("\uba92", -1421034829) + (blockPos.method_10264() + 7) + a.b("\ue034", 1230888981) + blockPos.method_10260());
            gyf.gyt(minecraftClient, a.c(1676439914, "\u7113\u08bf\u8268\u1c11\u9783\u1161\uab24\u22c4\ubccf\u3668\ub1bd\u4bcc\uc51b"));
            ((vlv)gyf.gys(kfe2, a.c(1458586027, "\u41fe\u3879\ub2ae\u2ccd\ua706\u21b6"))).set(a.d("\u79f2}\u8aa9\u14c2\u9f04\u19a2", 389692322, -4046335));
            ((vmc)gyf.gys(kfe2, a.c(-1925699973, "\u2622\u5fa2\ud562\u4b15\uc0df\u4664\ufc38\u75c0\ueb89"))).set(0.6);
            ((vmc)gyf.gys(kfe2, a.b("\uf3bb\u8a25\u00f5\u9e9e\u1558\u93fe", -2072513538))).set(0.9);
            ((vmc)gyf.gys(kfe2, a.b("\uf3f6\u8a6b\u00bb\u9ec2", -2031619151))).set(0.7);
            ((vkl)gyf.gys(kfe2, a.c(1127850614, "\ua239\udba4\u5174\ucf06\u44cb\uc27d\u787c\uf1ca\u6f80\ue522\u62f4\u9884"))).set(true);
            kfe2.setEnabled(true);
            vbb.timing(true);
            gyn = n;
            return false;
        }
        minecraftClient.field_1724.method_31549().field_7479 = true;
        if (minecraftClient.field_1755 != null) {
            minecraftClient.method_1507(null);
        }
        if ((n2 = n - gyn - 520) == -40) {
            vbb.gpuMillis();
        }
        if (n2 == -1) {
            System.out.println(a.c(-1898928621, "\ua66c\udfc0\u5512\ucb7b\u40a8\uc601\u7c40\uf5e8\u6bf0\ue156\u6680\u9ca4") + vbb.gpuMillis() + a.c(416545865, "\ufc6a\u8596\u0f5b"));
        }
        for (gxv gxv2 : gyi) {
            if (gyh != null && !gxv2.gxx.startsWith(gyh)) continue;
            if (n2 == gxv2.gxw - 40) {
                gyf.gyt(minecraftClient, a.b("\ue9d0\u907c\u1aab\u84d2\u0f40\u89a2\u33e7\uba07\u240c", -2070091347) + gxv2.gxy);
                kfe2.setEnabled(gxv2.gyb);
                for (String string : gyj) {
                    kfe kfe4 = Flow.getInstance().getModuleManager().getByName(string);
                    if (kfe4 == null) continue;
                    kfe4.setEnabled(string.equals(gxv2.gyc));
                }
                gyf.gyr(minecraftClient, gxv2.gxz, gxv2.gya);
                continue;
            }
            if (n2 == gxv2.gxw - 2) {
                gyf.gyr(minecraftClient, gxv2.gxz, gxv2.gya);
                continue;
            }
            if (n2 != gxv2.gxw) continue;
            gyf.gyu(minecraftClient, a.d("\u95e6\uec4a\u6698\uf8f1\u7322\uf58b\u4fca\uc66f", -1694075445, 955375702) + gxv2.gxx);
        }
        if (n2 > gyf.gyi[gyf.gyi.length - 1].gxw + 10) {
            vbb.timing(false);
            minecraftClient.field_1690.field_1842 = false;
            for (int i = 0; i < gyj.length; ++i) {
                kfe kfe5 = Flow.getInstance().getModuleManager().getByName(gyj[i]);
                if (kfe5 == null) continue;
                kfe5.setEnabled(gyk[i]);
            }
            return true;
        }
        return false;
    }

    private static void gyq(MinecraftClient minecraftClient) {
        gyl = null;
        gym = false;
        IntegratedServer integratedServer = minecraftClient.method_1576();
        BlockPos blockPos = minecraftClient.field_1724.method_24515();
        integratedServer.execute(() -> {
            try {
                ServerWorld serverWorld = integratedServer.method_30002();
                Pair pair = serverWorld.method_42108(registryEntry -> registryEntry.method_40225(BiomeKeys.field_35117), blockPos, 6400, 32, 64);
                if (pair != null) {
                    BlockPos blockPos2 = (BlockPos)pair.getFirst();
                    serverWorld.method_8500(blockPos2);
                    int n = serverWorld.method_8624(Heightmap.Type.field_13197, blockPos2.method_10263(), blockPos2.method_10260());
                    gyl = new BlockPos(blockPos2.method_10263(), n, blockPos2.method_10260());
                }
            }
            catch (Throwable throwable) {
                System.out.println(a.d("\u5db6\u241a\uaec8\u30a1\ubb72\u3ddb\u879a\u0e32\u9021\u1a93\u9d4c\u673f\ue9fd\u705d\ufa4b\u7cfc\uc6b4\u496d\ud3db\u5583\udc75\ua67a\u28d3", -927411646, 1204457360) + throwable);
            }
            gym = true;
        });
    }

    private static void gyr(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static vmo gys(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.b("\u91bf\ue846\u629c\ufcff\u777b\uf184\u4bd6\uc268", 973115799) + string);
    }

    private static void gyt(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void gyu(MinecraftClient minecraftClient, String string) {
        System.out.println(a.c(-100638969, "\u5f7e\u26d9\uac03\u3278\ub9e9\u3f0c\u854e\u0ca9\u92f1\u1814") + string + a.c(210580171, "\u32e8\u4b39\uc18a") + minecraftClient.method_47599() + a.d("\ufd76\u8481\u0e44\u9036", 593010428, 928801710));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\u78bc\u0107\u8bd7\u15be\u9e2c\u1882", -97740393, 974643531) + string + a.c(672632092, "\u8d36\uf4d9\u7e14\ue06c")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        gyn = -1;
    }

    private static /* synthetic */ int xq(int n, int n2) {
        return n - n2 + 969675938;
    }

    private static /* synthetic */ int xr(int n, int n2) {
        return gyf.xq(n, n2) + n;
    }
}

