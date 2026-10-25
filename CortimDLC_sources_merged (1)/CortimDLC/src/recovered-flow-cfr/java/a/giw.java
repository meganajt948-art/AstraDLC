/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
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
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class giw {
    private static final String[] gix = new String[]{a.d("\u8e11\uf7a9\u7d7a\ue340\u68d6\uee6e\u543e\udddd\u43db\uc976", -1341627912, 1678897036), a.b("\u8b6c\uf2c6\u780d\ue66a\u6dae\ueb09\u5113\ud8fe", -1184855280), a.b("\u0a37\u7390\uf955\u673c\uecbf\u6a12", -1053226416), a.c(272759642, "\ufb26\u828c\u0847\u9620\u1de4\u9b43\u2159\ua8b7"), a.b("\u7b56\u02f1\u8834\u165d\u9dde\u1b70", -1798800591), a.d("\ub9a6\uc00c\u4ac7\ud4a0\u5f64\ud9c3\u63d9\uea36", -320253671, -1087641405), a.c(-849754467, "\uc6fa\ubf5d\u3598\uabf1\u2072\ua6dd"), a.c(1157937565, "\ub9f9\uc041\u4a92\ud4a8\u5f20\ud98a\u63d7\uea29\u746a\ufe82\u794e"), a.b("\ub444\ucdee\u4725\ud942\u5286\ud421\u6e3b\ue781\u79d9\uf37a\u74ae\u8e86H\u99fd", 181515326)};
    private static final int giy = 10;
    private static Field giz;
    private static Field gja;
    private static boolean gjb;
    private static volatile int gjc;
    private static double gjd;
    private static long gje;
    private static float gjf;
    private static /* synthetic */ boolean gjg;
    private static /* synthetic */ boolean gjh;

    private giw() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.d("\u9373\ueae0\u6029\ufe5e\u759f\uf30a\u496b\uc09a\u5edf\ud474\u53a0", -337836748, -192178687));
        if (n == 1) {
            minecraftClient.options.pauseOnLostFocus = false;
            giz = vxr.find(Mouse.class, a.d("\ua495\udd2f\u57ed\uc9c6\u4252\uc4e7\u7eb3\uf749\u6910\ue3b0\u6470\u9e06\u10c3\u8928\u0336\u85c8\u3f8a\ub049\u2afa\uac87\u251c\u5f4f\ud1ff", -900973984, 632790668), a.b("\u3172\u48cc\uc213\u5c6b\ud7b4\u513e\ueb03\u62f4\ufca4\u761e", 1053176094), a.c(2052076535, "\u33ac"));
            gja = vxr.find(MinecraftClient.class, a.c(1581135735, "\u370e\u4eb4\uc476\u5a5d\ud1c9\u577c\ued28\u64d2\ufa8b\u702b\uf7eb\u0d9d\u8358\u1ab3\u90ad\u1653\uac11\u23d2\ub961\u3f1c\ub687\uccd4\u4266"), a.d("\uc9c1\ub07f\u3aa0\ua4d8\u2f07\ua98d\u13b0\u9a46\u0416\u8eab", 1381446249, -1430848572), a.c(-873861807, "\ued0a"));
            if (!gjb) {
                gjb = true;
                WorldRenderEvents.END_MAIN.register(worldRenderContext -> giw.gji());
            }
            giw.gjk(minecraftClient, a.b("\uace0\ud557\u5f88\uc1f1\u4a2e\ucc9d\u76c5\uff35\u612f\uebcd\u6c18\u966e\u18bd\u8113\u0b5f\u8db9\u37fb", 1881648278));
            giw.gjk(minecraftClient, a.d("\uba5f\uc3f3\u4924\ud75d\u5ccf\uda2d\u6068\ue988\u7783\ufd7c\u7aae\u80df\u0e09", -2083396961, -512665415));
            giw.gjk(minecraftClient, a.b("\uac8b\ud539\u5fea\uc198\u4a49\uccef\u76e8\uff5e\u610f\ueba1\u6c61\u9655\u18e2\u8160\u0b60\u8dc3\u379b\ub85c\u22f5\ua4be\u2d4e\u570a\ud9b6\u426a\uc413\u4e87\uf77d\u792b\ue3d4\u658a\uee3e\u10e8\u9aba\u035a\u854c\u0fef\ub03f\u3a4e\ubc88\u256d\uaf34\ud1c2\u5b81", -168514363));
            giw.gjk(minecraftClient, a.c(-597724418, "\u72a9\u0b17\u81c1\u1fb0\u942b\u12c4\ua8c4\u212e\ubf67\u3588\ub208\u4865\uc6a3\u5f4c\ud54c\u53a6\ue9ff\u6670\ufc8b\u7acc\uf365\u8967\u07c8\u9c08\u1a29\u90b0\u2915\ua709\u3dfa\ubbac\u3014\ucec3\u449d\udd7f\u5b2b\ud188\u6e11\ue429\u62e4\ufb57\u7108\u0fe2\u85ad\u022b\u98d0\u16a6\uaf6e\u25de\ua39a"));
            giw.gjk(minecraftClient, a.c(-1418868613, "\uc838\ub186\u3b50\ua521\u2eba\ua855\u1255\u9bbf\u05f6\u8f19\u0894\uf2bb\u7c3f\ue595\u6fd0\ue97f\u5378\udcbf\u4652\uc049\u49aa\u33a5\ubd5e\u2699\ua0ab\u2a7e\u93ca\u1d90\u8761\u0121\u8a81\u7457\ufe0a\u67b5\ue1bd\u6b04\ud4c8"));
            giw.gjk(minecraftClient, a.b("\uceb5\ub702\u3dc9\ua3b8\u286d\uaedd\u14c0\u9d7c\u0327\u8991\u0e49\uf43e\u7af8\ue35a\u690e\uefed\u55ec\uda7d\u40db\uc688\u4f70\u352a\ubb95\u2001\ua620\u2cbe\u9512\u1b58\u81ba\u07b5\u8c58\u72d7\uf8d5\u6137\ue73f\u6dbb\ud24d\u5812\udec9\u470b\ucd5f\ub3fd\u39e0\ube2e\u24c3\uaab7\u136d\u99d7\u1f82\u841d\u0a65\uf0e7\u791e\uff33\u65f5\uebb3\u500d\ud6c6\u5caf\uc579\u4bdf\u3185\ub67b\u3c2c\ua2d4\u2b52\u9115\u17e0\u9dab\u0201\u88c5\u0eb5\uf734\u7d8e\ue38e\u6860", 2131938954));
            return false;
        }
        giw.gjj(minecraftClient);
        if (n < 40) {
            return false;
        }
        int n2 = 26;
        int n3 = (n - 40) / n2;
        int n4 = (n - 40) % n2;
        if (n3 >= gix.length) {
            gjc = 0;
            kfe2.setEnabled(false);
            return true;
        }
        String string = gix[n3];
        if (n4 == 0) {
            kfe2.setEnabled(!string.startsWith(a.c(-2039700502, "\ua386\uda3e\u50ed")));
            minecraftClient.player.setYaw(0.0f);
            minecraftClient.player.setPitch(0.0f);
        } else if (n4 == 4) {
            gjf = minecraftClient.player.getYaw();
            gje = 0L;
            int n5 = Integer.parseInt(string.substring(string.lastIndexOf(45) + 1));
            boolean bl = string.contains(a.b("\u55bf\u2c15\ua6c8\u38b6\ub37d", -1586539064)) || string.startsWith(a.c(1340571852, "\u80a9\uf90e\u73cb\ueda2"));
            gjc = bl ? n5 : -n5;
        } else if (n4 == 14) {
            gjc = 0;
        } else if (n4 == 22) {
            double d = (Double)minecraftClient.options.getMouseSensitivity().getValue() * 0.6 + 0.2;
            double d2 = (double)gje * d * d * d * 8.0 * 0.15;
            float f = minecraftClient.player.getYaw() - gjf;
            System.out.printf(a.b("\ud34b\uaaf8\u2031\ube46\u3587\ub335\u0972\u8090\u1ec3\u947a\u13ec\ue998\u6719\ufee1\u74a8\uf20d\u4843\uc795\u5d3a\udb60\u5296\u2883\ua635\u3def\ubb8d\u3109\u88fc\u06e9\u9c1f\u1a4c\u91b4\u6f69\ue570\u7c96\ufaca\u707c\ucfae\u45df\uc301\u5af1\ud0ab\uae51\u241f\ua3fb\u396a\ub75f\u0e8d\u843e\u023a\u99e7\u17c6\ued04\u64a6\ue2ea\u781f\uf601\u4dbb\ucb61\u410f\ud88b\u567f\u2c65", 1689572120), string, Float.valueOf(f), d2, (double)Math.abs(f) / Math.abs(d2));
        }
        return false;
    }

    private static void gji() {
        int n = gjc;
        if (n == 0) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        long l = minecraftClient.getWindow().getHandle();
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
        GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        gje += (long)Math.abs(n);
        gLFWCursorPosCallback.invoke(l, gjd += (double)n, 500.0);
    }

    private static void gjj(MinecraftClient minecraftClient) throws Exception {
        if (giz != null && minecraftClient.currentScreen == null) {
            giz.setBoolean(minecraftClient.mouse, true);
        }
        if (gja != null) {
            gja.setBoolean(minecraftClient, true);
        }
    }

    private static void gjk(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    static {
        gjd = 1000.0;
    }

    private static /* synthetic */ int ub(int n, int n2) {
        return n - n2 | 0xD97E4D31;
    }

    private static /* synthetic */ int uc(int n, int n2) {
        return giw.ub(n, n2) ^ 0x850039C1;
    }

    private static /* synthetic */ int ud(int n, int n2) {
        return giw.ub(n, n2) ^ 0xD1B800AB;
    }
}

