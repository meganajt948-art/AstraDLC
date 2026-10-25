/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.BiomeKeys
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gsp;
import a.kfe;
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
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.lwjgl.glfw.GLFW;

final class gsz {
    private static final gsp[] gta = new gsp[]{new gsp(a.d("\u6d76\u14d9\u9e0df\u8ba0\u0d06", -878195154, -1436900567), (RegistryKey<Biome>)BiomeKeys.field_34471, a.b("\ub1cb\uc844\u4290\udcfb\u573d\ud19b", 874033562), a.d("\u2872\u51e5\udb2d\u4541\uce80\u4820", 371511944, 1487469231), 23200L, 22, 12.0f), new gsp(a.d("\u1a23\u6391\ue940\u772a\ufcfa\u7a42", 422327074, 1503996276), (RegistryKey<Biome>)BiomeKeys.field_42720, a.d("\u5d86\u2414\uaec5\u30af\ubb7f\u3dc7", 979024687, -598022404), a.d("\u5c12\u258c\uaf5c\u3137\ubaf1\u3c57", -1801127239, -2080987410), 2500L, 24, 18.0f), new gsp(a.c(-1523574204, "\u1a31\u6386\ue94d\u773c\ufce3\u7a45"), (RegistryKey<Biome>)BiomeKeys.field_9455, a.b("\u3374\u4ae3\uc028\u5e59\ud586\u5320", -1463864543), a.d("\ue39e\u9a09\u10c1\u8ead\u056c\u83cc", -1146735706, 1428541549), 11900L, 14, 12.0f), new gsp(a.c(-564303336, "\u6a7f\u13da\u9908\u0778\u8cb7\u0a05"), (RegistryKey<Biome>)BiomeKeys.field_9412, a.b("\u0fd9\u765c\ufc8e\u62fe\ue931\u6f83", -866512994), a.d("\ub6e3\ucf74\u45bc\udbd0\u5011\ud6b1", -412317646, 1636646532), 11400L, 12, 14.0f)};
    private static final float[] gtb = new float[]{0.0f, 45.0f, 90.0f, 135.0f, 180.0f, 225.0f, 270.0f, 315.0f};
    private static final int gtc = 760;
    private static final int gtd = 30;
    private static int gte = -1;
    private static int gtf;
    private static volatile BlockPos gtg;
    private static volatile boolean gth;
    private static /* synthetic */ long gti;
    private static /* synthetic */ String gtj;

    private gsz() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        Object object;
        if (n == 1) {
            minecraftClient.field_1690.field_1842 = true;
            minecraftClient.field_1690.method_42503().method_41748((Object)14);
            minecraftClient.field_1690.method_41808().method_41748((Object)80);
            gsz.gto(minecraftClient, a.c(1156041940, "\ucca1\ub516\u3fc9\ua1b0\u2a6f\uacdc\u1684\u9f74\u016e\u8b8c\u0c5c\uf638\u78e9\ue14f\u6b09\ueded\u57b9\ud875"));
            gsz.gto(minecraftClient, a.d("\ub692\ucf25\u45fa\udb83\u5043\ud6f5\u6cbf\ue547\u7b5d\uf1a8\u7670\u8c2a\u02d8\u9b71\u1137\u97c3\u2d82\ua25c\u38f3\ube95\u3758\u4d13\uc3af\u5877\ude4d\u54da\ued6e\u6332\uf9da\u7f9d", 2120442414, -1230515003));
            gsz.gto(minecraftClient, a.c(84599634, "\ue328\u9a9f\u1040\u8e39\u05f9\u834f\u3905\ub0fd\u2ee7\ua412\u23ca\ud983\u5766\uced3\u4495\uc278\u783a\uf7fc\u6d7e\ueb15\u62f8\u18a6\u961c\u0d88\u8bb1\u0167\ub8d9\u3697\uac76"));
            gsz.gto(minecraftClient, a.b("\u381d\u41be\ucb69\u550d\udec6\u587a\ue23e\u6b9d\uf581\u7f3f\uf8e5\u0290\u8c54", 201799783));
            GLFW.glfwSetWindowSize((long)minecraftClient.method_22683().method_4490(), (int)2560, (int)1440);
            return false;
        }
        if (n < 30) {
            return false;
        }
        if (gte < 0 || n - gtf > 760 + 30 * (gtb.length + 1)) {
            if ((gte = gsz.gtk(gte)) >= gta.length) {
                minecraftClient.field_1690.field_1842 = false;
                return true;
            }
            gtf = n;
            gsz.gtl(minecraftClient, gta[gte]);
            return false;
        }
        gsp gsp2 = gta[gte];
        int n2 = n - gtf;
        if (n2 == 1 && !gth) {
            ++gtf;
            return false;
        }
        if (n2 == 2) {
            object = gtg;
            if (object == null) {
                System.out.println(a.b("\ue277\u9bd6\u1103\u8f79\u04a5\u8203\u385b\ub1e9\u2fac\ua553\u2281\ud8bf", 1677648392) + gsp2.gsq + a.d("\ub464\ucd97\u474f\ud938\u52ed\ud454\u6e42\ue7f5\u79a3\uf308\u74c0\u8ebb", -1552266980, 754122068));
                gtf -= 760 + 30 * (gtb.length + 2);
                return false;
            }
            System.out.println(a.d("\u47e2\u3e43\ub496\u2aec\ua130\u2796\u9dce\u1466", -1604960081, 296814390) + gsp2.gsq + a.b("\u33e5\u4a15\uc0d3\u5ef6", -1964428351) + object.method_23854());
            gsz.gto(minecraftClient, a.b("\u09a0\u7015\ufa96\u6487\uef63\u6981", 1543768530) + object.method_10263() + a.d("\u5602", -1117605996, -1561200201) + (object.method_10264() + gsp2.gsv) + a.b("\u48e0", 1602439361) + object.method_10260());
            gsz.gto(minecraftClient, a.b("\u45ca\u3c66\ub6b1\u28c8\ua35a\u25b8\u9ffd\u161d\u8816", 258622903) + gsp2.gsu);
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(-2115444146, "\ue21e\u9b9d\u114a\u8f2e\u04e5\u8259\u381d"));
            ((vlv)gsz.gtn(kfe2, a.b("\ub818\uc19f\u4b48\ud52b\u5ee0\ud850", -63457203))).set(gsp2.gss);
            ((vmc)gsz.gtn(kfe2, a.c(-616545494, "\u4373\u3af3\ub033\u2e44\ua58e\u2335\u9969\u1091\u8ed8"))).set(0.0);
            kfe2.setEnabled(true);
            kfe kfe3 = Flow.getInstance().getModuleManager().getByName(a.d("\uffa6\u862c\u0cf6\u9282\u1954\u9ff2\u2580\uac49\u3204", 537509517, 989413745));
            ((vlv)gsz.gtn(kfe3, a.b("\u0806\u718f\ufb4e", 1877084246))).set(gsp2.gst);
            kfe3.setEnabled(true);
            gsz.gtm(minecraftClient, gtb[0], gsp2.gsw);
        }
        object = System.getenv(a.b("\u77d5\u0e6e\u84be\u1ad7\u9165\u17b9\uade6\u2407\uba5e\u30e4\ub73c\u4d5a\uc386\u5a31\ud064\u568d\uecd4", 1040283522));
        for (int i = 0; i < gtb.length; ++i) {
            if (object != null && !((String)object).equals(String.valueOf((int)gtb[i]))) continue;
            if (n2 == 760 + 30 * i - 12) {
                gsz.gtm(minecraftClient, gtb[i], gsp2.gsw);
                continue;
            }
            if (n2 != 760 + 30 * i) continue;
            gsz.gtp(minecraftClient, a.d("\ua4f2\udd53\u5786\uc9fc\u4220\uc486\u7ede\uf77b", -718130612, 915510981) + gsp2.gsq + a.b("\uaf53", 1538830207) + (int)gtb[i]);
        }
        return false;
    }

    private static int gtk(int n) {
        String string = System.getenv(a.b("\u569f\u2f24\ua5f4\u3b9d\ub02f\u36f3\u8cac\u054d\u9b14\u11ae\u9676\u6c10\ue2cc", -1269737772));
        for (int i = n + 1; i < gta.length; ++i) {
            if (string != null && !string.contains(gsz.gta[i].gsq)) continue;
            return i;
        }
        return gta.length;
    }

    private static void gtl(MinecraftClient minecraftClient, gsp gsp2) {
        gtg = null;
        gth = false;
        IntegratedServer integratedServer = minecraftClient.method_1576();
        BlockPos blockPos = minecraftClient.field_1724.method_24515();
        integratedServer.execute(() -> {
            try {
                ServerWorld serverWorld = integratedServer.method_30002();
                Pair pair = serverWorld.method_42108(registryEntry -> registryEntry.method_40225(gsp2.gsr), blockPos, 6400, 32, 64);
                if (pair != null) {
                    BlockPos blockPos2 = (BlockPos)pair.getFirst();
                    serverWorld.method_8500(blockPos2);
                    int n = serverWorld.method_8624(Heightmap.Type.field_13197, blockPos2.method_10263(), blockPos2.method_10260());
                    gtg = new BlockPos(blockPos2.method_10263(), n, blockPos2.method_10260());
                }
            }
            catch (Throwable throwable) {
                System.out.println(a.d("\ucdb7\ub416\u3ec3\ua0b9\u2b65\uadc3\u179b\u9e33 \u8a92\u0d4d\uf73e\u79fc\ue05c\u6a4a\uecfd\u56b5\ud96c\u43da\uc582\u4c74\u367b\ub8d2", -27897094, 1537711913) + throwable);
            }
            gth = true;
        });
    }

    private static void gtm(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static vmo gtn(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.b("\uce9c\ub765\u3dbf\ua3dc\u2858\uaea7\u14f5\u9d4b", -64762188) + string);
    }

    private static void gto(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void gtp(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u0d04\u74a5\ufe70\u600a\uebd6\u6d70\ud728\u5e80", 2146307455) + string + a.c(2123466663, "\u8786") + minecraftClient.method_22683().method_4489() + a.d("\uae73", 1458510976, -200953206) + minecraftClient.method_22683().method_4506());
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\u5c4a\u25f1\uaf21\u3148\ubada\u3c74", 1654742764, -1083571514) + string + a.c(958105761, "\u888b\uf164\u7ba9\ue5d1")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> {});
    }

    private static /* synthetic */ int wy(int n, int n2) {
        return n - n2 ^ 0xCA59988;
    }

    private static /* synthetic */ int wz(int n, int n2) {
        return gsz.wy(n, n2) * n2;
    }
}

