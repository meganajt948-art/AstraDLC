/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.kfe;
import a.vxr;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class gjv {
    private static final int gjw = 2;
    private static final int gjx = 3;
    private static final int gjy = 6;
    private static final String[] gjz = new String[]{a.c(1520553703, "\uce81\ub739\u3dea\ua3d0\u2858\uaef2\u14af\u9d51\u0312"), a.d("\u46ce\u3f76\ub5a5\u2b9f\ua009\u26b1\u9ce1\u1502", 1329892924, 451135637), a.c(-1599955696, "\u9d71\ue4c1\u6e51\uf07f\u7bb3\ufd0c\u4750\ucebd\u50be\uda46\u5d83\ua7e4\u292b\ub0ca"), a.d("\u8783\ufe33\u74a3\uea93\u614d\ue7ff\u5dbe\ud413\u4a10\uc0ba\u4771\ubd16\u33d2\uaa75\u206b", -581809798, 900910745), a.d("\uf27f\u8bcf\u015f\u9f6f\u14b1\u9203\u2842\ua1ea\u3ffe\ub548\u3289\uc8ff", 1040958980, 928723992)};
    private static Field gka;
    private static Field gkb;
    private static double gkc;
    private static float gkd;
    private static /* synthetic */ int gke;
    private static /* synthetic */ int gkf;

    private gjv() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.d("\u2fda\u5649\udc80\u42f7\uc936\u4fa3\uf5c2\u7c33\ue276\u68dd\uef09", -2116994137, -1714678725));
        if (n == 1) {
            minecraftClient.field_1690.field_1837 = false;
            gka = vxr.find(Mouse.class, a.c(19577844, "\ubb8d\uc237\u48f5\ud6de\u5d4a\udbff\u61ab\ue851\u7608\ufca8\u7b68\u811e\u0fdb\u9630\u1c2e\u9ad0\u2092\uaf51\u35e2\ub39f\u3a04\u4057\ucee7"), a.c(551400012, "\ub220\ucb9e\u4141\udf39\u54e6\ud26c\u6851\ue1a6\u7ff6\uf54c"), a.c(-1513700863, "\uc25a"));
            gkb = vxr.find(MinecraftClient.class, a.d("\uf9e3\u8059\u0a9b\u94b0\u1f24\u9991\u23c5\uaa3f\u3466\ubec6\u3906\uc370\u4db5\ud45e\u5e40\ud8be\u62fc\ued3f\u778c\uf1f1\u786a\u0239\u8c8b", 645316589, 1590838903), a.d("\ubb77\uc2c9\u4816\ud66e\u5db1\udb3b\u6106\ue8f0\u76a0\ufc1d", -322625474, 1886100261), a.d("\u4c4f", -496466650, -995636942));
            gjv.gki(minecraftClient, a.d("\u0530\u7c87\uf658\u6821\ue3fe\u654d\udf15\u56e5\uc8ff\u421d\uc5c8\u3fbe\ub16d\u28c3\ua28f\u2469\u9e2b", -1529193324, 255744466));
            gjv.gki(minecraftClient, a.c(-331242999, "\ua270\udbdc\u510b\ucf72\u44e0\uc202\u7847\uf1a7\u6fac\ue553\u6281\u98f0\u1626"));
            gjv.gki(minecraftClient, a.b("\u01e0\u7852\uf281\u6cf3\ue722\u6184\udb83\u5235\ucc64\u46ca\uc10a\u3b3e\ub589\u2c0b\ua60b\u20a8\u9af0\u1537\u8f9e\u09d5\u8025\ufa61\u74dd\uef01\u6978\ue3ec\u5a16\ud440\u4ebf\uc8e1\u4355\ubd83\u37d1\uae31\u2827\ua284\u1d54\u9725\u11e3\u8806\u025f\u7ca9\uf6ea", 2047279534));
            gjv.gki(minecraftClient, a.b("\u0ff2\u764c\ufc9a\u62eb\ue970\u6f9f\ud59f\u5c75\uc23c\u48d3\ucf53\u353e\ubbf8\u2217\ua817\u2efd\u94a4\u1b2b\u81d0\u0797\u8e3e\uf43c\u7a93\ue153\u6772\uedeb\u544e\uda52\u40a1\uc6f7\u4d4f\ub398\u39c6\ua024\u2670\uacd3\u134a\u9972\u1fbf\u860c\u0c53\u72b9\uf8f6\u7f70\ue58b\u6bfd\ud235\u5885\udec1", 523177893));
            gjv.gki(minecraftClient, a.c(15113950, "\u9e9d\ue723\u6df5\uf384\u781f\ufef0\u44f0\ucd1a\u5353\ud9bc\u5e31\ua41e\u2a9a\ub330\u3975\ubfda\u05dd\u8a1a\u10f7\u96ec\u1f0f\u6500\uebfb\u703c\uf60e\u7cdb\uc56f\u4b35\ud1c4\u5784\udc24\u22f2\ua8af\u3110\ub718\u3da1\u826d"));
            gjv.gki(minecraftClient, a.d("\u47df\u3e68\ub4a3\u2ad2\ua107\u27b7\u9daa\u1416\u8a4d\u00fb\u8723\u7d54\uf392\u6a30\ue064\u6687\udc86\u5317\uc9b1\u4fe2\uc61a\ubc40\u32ff\ua96b\u2f4a\ua5d4\u1c78\u9232\u08d0\u8edf\u0532\ufbbd\u71bf\ue85d\u6e55\ue4d1\u5b27\ud178\u57a3\uce61\u4435\u3a97\ub08a\u3744\uada9\u23dd\u9a07\u10bd\u96e8\u0d77\u830f\u798d\uf074\u7659\uec9f\u62d9\ud967\u5fac\ud5c5\u4c13\uc2b5\ub8ef\u3f11\ub546\u2bbe\ua238\u187f\u9e8a\u14c1\u8b6b\u01af\u87df\u7e5e\uf4e4\u6ae4\ue10a", 1729955821, 679493645));
            System.out.println(a.d("\u2282\u5b31\ud1f8\u4f8f\uc44e\u42ba\uf8ba\u715d\uef09\u65a5\ue225", -61365662, -1919778682) + minecraftClient.field_1690.method_42495().method_41753());
            return false;
        }
        gjv.gkh(minecraftClient);
        if (n < 40) {
            return false;
        }
        int n2 = 26;
        int n3 = (n - 40) / n2;
        int n4 = (n - 40) % n2;
        if (n3 >= gjz.length) {
            kfe2.setEnabled(false);
            return true;
        }
        if (n4 == 0) {
            kfe2.setEnabled(n3 >= 2);
            minecraftClient.field_1724.method_36456(0.0f);
            minecraftClient.field_1724.method_36457(0.0f);
            minecraftClient.field_1724.field_5982 = 0.0f;
        } else if (n4 == 10) {
            gkd = minecraftClient.field_1724.method_36454();
        } else if (n4 > 10 && n4 <= 16) {
            int n5 = gjz[n3].contains(a.b("\uc4c4\ubd6e\u37b3\ua9cd\u2206", 1861534899)) ? 1 : -1;
            int n6 = gjz[n3].contains(a.d("\uf85b\u81ed\u0b2c\u955a", -696234716, 1012708637)) ? 8 : 1;
            GLFWCursorPosCallback gLFWCursorPosCallback = gjv.gkg(minecraftClient);
            long l = minecraftClient.method_22683().method_4490();
            for (int i = 0; i < 3 * n6; ++i) {
                gLFWCursorPosCallback.invoke(l, gkc += (double)(n5 * 2), 500.0);
            }
        } else if (n4 == 24) {
            int n7 = gjz[n3].contains(a.c(1976430957, "\uf10f\u88b9\u0278\u9c0e")) ? 8 : 1;
            double d = 36 * n7;
            double d2 = (Double)minecraftClient.field_1690.method_42495().method_41753() * 0.6 + 0.2;
            double d3 = d * d2 * d2 * d2 * 8.0 * 0.15;
            float f = minecraftClient.field_1724.method_36454() - gkd;
            System.out.printf(a.b("\udbb8\ua20b\u28c2\ub6b5\u3d74\ubb80\u01d6\u8871\u1667\u9ccc\u1b4b\ue13b\u6feb\uf646\u7c1e\ufaee\u40e5\ucf31\u5589\ud3c5\u5a67\u2070\uae87\u3557\ub32a\u39b0\u800f\u0e08\u94e8\u12b6\u9902\u67d6\ued99\u7465\uf277\u78c3\uc71f\u4d73\ucbf5\u5202\ud819\ua6e9\u2cb8\uab42\u3199\ubfba\u067a\u8cde\u0a8c\u915b\u1f67\ue5b3\u6c0f\uea43\u70e5\ufef7\u4503", -1974084628), gjz[n3], Float.valueOf(f), d3, (double)Math.abs(f) / d3);
        }
        return false;
    }

    private static GLFWCursorPosCallback gkg(MinecraftClient minecraftClient) {
        long l = minecraftClient.method_22683().method_4490();
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
        GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        return gLFWCursorPosCallback;
    }

    private static void gkh(MinecraftClient minecraftClient) throws Exception {
        if (gka != null && minecraftClient.field_1755 == null) {
            gka.setBoolean(minecraftClient.field_1729, true);
        }
        if (gkb != null) {
            gkb.setBoolean(minecraftClient, true);
        }
    }

    private static void gki(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    static {
        gkc = 1000.0;
    }

    private static /* synthetic */ int ul(int n, int n2) {
        return n + n2 | 0xC470591C;
    }
}

