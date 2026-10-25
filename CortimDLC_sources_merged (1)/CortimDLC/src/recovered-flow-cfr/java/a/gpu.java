/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.option.NarratorMode
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWKeyCallback
 *  org.lwjgl.glfw.GLFWKeyCallbackI
 */
package a;

import a.hlc;
import a.hyz;
import a.iov;
import a.kfe;
import a.kfx;
import a.vlv;
import a.vmc;
import a.vmo;
import a.voa;
import a.vpo;
import a.wek;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.awt.Color;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.NarratorMode;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

final class gpu {
    private static final String[] gpv = new String[]{a.b("\ud83b\ua1be\u2b6c\ub506\u3eed\ub87f\u022e\u8bc4\u159c\u9f37", 304863344), a.c(536155090, "\u1397\u6a07\ue0f1\u7ebf\uf570\u73dc\uc9bb\u406b\ude3d\u5481\ud34a"), a.c(2074543756, "\u06ce\u7f42\uf580\u6bf9\ue013\u669a\udcd8\u5523\ucb66\u41dd\uc61e")};
    private static String gpw;
    private static String gpx;
    private static double gpy;
    private static NarratorMode gpz;
    private static Object gqa;
    private static Entity gqb;
    private static float gqc;
    private static /* synthetic */ String gqd;
    private static /* synthetic */ String gqe;

    private gpu() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        Screen screen = minecraftClient.currentScreen;
        kfx kfx2 = Flow.getInstance().getModuleManager();
        switch (n) {
            case 1: {
                gpw = iov.PRESET.get();
                gpx = iov.ACCENT.get();
                gpu.gqf(minecraftClient, a.b("\u4da2\u3424\ubefc\u2087\uab51\u2df7", 1573211638));
                break;
            }
            case 30: {
                gpu.gqt(minecraftClient, a.d("\u1320\u6ad1\ue003\u7e6e\uf5e6\u7340\uc918\u40e3\udebd\u541b", -1822503475, -853483881));
                break;
            }
            case 31: {
                gpu.gqm(screen, 330.0f, 200.0f, -14.0);
                break;
            }
            case 50: {
                gpu.gqt(minecraftClient, a.c(-708541587, "\u830c\ufafd\u702c\uee42\u65ca\ue36c\u5934\ud0cf\u4e91\uc437\u43bb\ub985\u375f\uaef5\u24a6\ua24c\u1801"));
                break;
            }
            case 51: {
                gpu.gqf(minecraftClient, a.d("\u3521\u4cac\uc672\u580b\ud3d4", 1594758315, -758701605));
                for (Object obj : gpu.gqg(a.b("\uc031\ub99c\u3342\uad3b\u26e4\ua073\u1a02\u93e0\u0da9\u870f", 1765982287))) {
                    gpu.gqi(obj);
                }
                break;
            }
            case 70: {
                gpu.gqt(minecraftClient, a.c(-1969739727, "\u2851\u51a0\udb70\u451f\uce91\u483c\uf262\u7b9b\ue5cc\u6f35\ue8ad\u12d5\u9c01\u05b8\u8fea\u091a"));
                break;
            }
            case 71: {
                Object object = gpu.gqh(a.d("\u0cba\u7517\uffc9\u61b0\uea6f\u6cf8\ud689\u5f6b\uc122\u4b84", 1488029648, -588084460), a.c(1464981453, "\ud782\uae05\u24d0\ubaa6\u316a\ub7d9\u0dc7\u8462\u1a21\u909d\u1746\ued3f"));
                gpu.gql(screen, gpu.gqq(object, a.d("\u332a", 1354136845, -1395110306)) + 30.0f, gpu.gqq(object, a.d("\ub717", 1103271034, -493018347)) + 12.0f, 0);
                break;
            }
            case 90: {
                gpu.gqt(minecraftClient, a.c(914011781, "\ub6fa\ucf0b\u45dc\udbb4\u502d\ud68a\u6cdf\ue529\u7b6d\uf1de\u764d\u8c7e\u02b6\u9b12\u114a"));
                break;
            }
            case 91: {
                Object object = gpu.gqj();
                gpu.gql(screen, gpu.gqq(object, a.c(1038792006, "\ub53f")) + 30.0f, gpu.gqq(object, a.c(1900469402, "\udce2")) + 2.0f + 32.0f + 8.0f, 0);
                break;
            }
            case 104: {
                Object object = gpu.gqj();
                float f = gpu.gqq(object, a.d("\uba00", 557677529, 1735311776));
                float f2 = gpu.gqq(object, a.d("\ucb1f", 1865184292, 2124201805));
                float f3 = gpu.gqq(object, a.c(-461887444, "\u2854")) + 2.0f + 48.0f + 4.0f;
                float f4 = f2 - 30.0f;
                gpu.gql(screen, f + f4 + 6.0f + 4.5f, f3 + 34.72f, 0);
                screen.mouseReleased(new Click(0.0, 0.0, new MouseInput(0, 0)));
                gpu.gql(screen, f + f4 * 0.55f, f3 + 40.32f, 0);
                screen.mouseReleased(new Click(0.0, 0.0, new MouseInput(0, 0)));
                gpu.gqk(a.d("\u3a19\u43a0\uc978\u5712\udccf\u5a71\ue033\u69ca\uf792\u7d39\ufaed", -794702008, -1149962985), 15, -34215);
                break;
            }
            case 122: {
                gpu.gqt(minecraftClient, a.c(-1243937170, "\u060e\u7fff\uf529\u6b40\ue0d9\u6664\udc34\u55c6\ucb84\u416a\uc6f1\u3c81\ub25b\u2bf7\ua1bf\u2753"));
                System.out.println(a.c(-2038487157, "\u27f6\u5e56\ud48d\u4afb\uc136\u47d3\ufdd0\u7423\uea6b\u60cc\ue709\u1d69\u93f7") + iov.PRESET.get() + a.d("\u3a7d\u438f\uc95e\u573c\udcfd\u5a15", -1731730544, 510843339) + gpu.gqs(iov.card) + a.b("\ucf69\ub699\u3c48\ua239\u29e8\uaf52\u151b\u9ca3", 2081279809) + gpu.gqs(iov.accent()));
                break;
            }
            case 123: {
                ((vlv)gpu.gqo(iov.class, a.c(276722641, "\u7384\u0a24\u80ff\u1e89\u9544"))).set(a.c(-185896915, "\u7066\u09ca\u8308"));
                gpu.gqk(a.d("\u0fcf\u7663\ufca1\u62cb\ue913\u6fb3\ud5e8\u5c1e\uc25b\u48ed", 238713769, -1026788316), 0, -14019520);
                gpu.gqk(a.b("\u21d1\u587d\ud2bf\u4cd5\uc70d\u41ad\ufbf6\u7200\uec45\u66f3", -264625773), 1, -5900);
                gpu.gqk(a.d("\u817e\uf8d2\u7210\uec7a\u67a2\ue102\u5b59\ud2af\u4cea\uc65c", -1265229535, 1049731101), 4, -10556716);
                break;
            }
            case 140: {
                gpu.gqt(minecraftClient, a.d("\uc2e2\ubb13\u31c6\uafac\u243e\ua292\u18d0\u9168\u0f79\u85c4\u0214\uf866\u76ac\uef1c\u6511\ue3a0\u59e7\ud63d\u4c95", -1420103590, -1746390309));
                break;
            }
            case 141: {
                minecraftClient.setScreen(null);
                break;
            }
            case 160: {
                gpu.gqt(minecraftClient, a.c(-237381433, "\ud8a4\ua155\u2b81\ub5ea\u3e78\ub8d4\u0296\u8b2e\u153f\u9f82\u1852\ue220\u6cea\uf55a\u7f57\uf9ec\u43a5\ucc78\u56c3"));
                System.out.println(a.d("\u290f\u50af\uda74\u4402\ucfcf\u492a\uf334\u7acd\ue499\u6e33\ue9b5\u1387\u9d5c\u04ee\u8ebe\u0855\ub21d\u3dcd\ua72d\u2133\ua8de\ud28e\u5c3a\uc7f1\u4183\ucb53\u72a5\ufca0\u664b\ue017\u6be1\u9558\u1f0a\u86ea\u00c7\u8a6c\u35ec\ubf83\u3957\ua0ec\u2ab8\u5451\ude48", -1941230849, 440730539) + gpu.gqs(iov.window) + a.b("\u8f2e\uf6de\u7c0f\ue27e\u69af\uef15\u555c\udce4", 263753478) + gpu.gqs(iov.accent()));
                break;
            }
            case 161: {
                for (String string : new String[]{gpv[0], gpv[1]}) {
                    kfx2.getByName(string).toggle();
                }
                break;
            }
            case 170: {
                gpu.gqt(minecraftClient, a.c(1308651422, "\u6fe0\u1611\u9cca\u02ae\u8935\u0f89\ub5d3\u3c35\ua26c\u28da\uaf57\u557f\udbab\u4202"));
                break;
            }
            case 171: {
                kfx2.getByName(gpv[2]).toggle();
                break;
            }
            case 180: {
                gpu.gqt(minecraftClient, a.c(-1769408246, "\uf96a\u809b\u0a41\u9424\u1fbf\u9903\u2359\uaabf\u34e6\ube50\u39dd\uc3f5\u4d3e\ud495\u5ed1\ud820"));
                break;
            }
            case 185: {
                long l = minecraftClient.getWindow().getHandle();
                GLFWKeyCallback gLFWKeyCallback = GLFW.glfwSetKeyCallback((long)l, null);
                GLFW.glfwSetKeyCallback((long)l, (GLFWKeyCallbackI)gLFWKeyCallback);
                gpz = (NarratorMode)minecraftClient.options.getNarrator().getValue();
                gLFWKeyCallback.invoke(l, 66, 48, 1, 2);
                gLFWKeyCallback.invoke(l, 66, 48, 0, 2);
                break;
            }
            case 190: {
                gqa = minecraftClient.options.getNarrator().getValue();
                long l = minecraftClient.getWindow().getHandle();
                GLFWKeyCallbackI gLFWKeyCallbackI = (GLFWKeyCallbackI)gpu.gqo(wek.class, a.c(-99010379, "\u38d2\u417e\ucbb6\u55c9\ude10\u58a6\ue2fa\u6b06"));
                gLFWKeyCallbackI.invoke(l, 66, 48, 1, 2);
                gLFWKeyCallbackI.invoke(l, 66, 48, 0, 2);
                break;
            }
            case 195: {
                Object object = minecraftClient.options.getNarrator().getValue();
                minecraftClient.options.getNarrator().setValue((Object)gpz);
                System.out.println(a.b("\u8e62\uf7c2\u7d19\ue36f\u68a2\uee47\u5457\uddb1\u43e8\uc947\u4ed3\ub4eb\u3a64\ua3cf\u29d2\uaf2c\u1570\u9aa1\u0001\u8645\u0fa9\u75e5\ufb04", 2110426629) + gpz + a.b("\u3c9b\u4526\ucfb4\u51c2\uda07\u5ca7\ue6e3\u6f40\uf17c\u7bfa\ufc2f\u0640\u88d0\u1108\u9b39", -1484440392) + gqa + a.c(1968977813, "\u37af\u4e12\uc486\u5af1\ud12a\u5793\ued85\u6437\ufa6a\u70d6\uf705\u0d7a\u83ae\u1a1d\u9046\u16fc\uacf2\u232e\ub99e\u3fce\ub632\ucc26") + object + a.b("\u0498\u7d21\uf7b4\u69ca\ue20e\u64bf\udeff\u571b\uc95f\u43f3\uc472\u3e42\ub082\u2924\ua37f\u258b\u9fc9\u101b\u8aa6\u0cfe\u8551", 596247725) + minecraftClient.getNarratorManager().isActive() + a.b("\uf184\u8839\u02a2\u9cd4\u1718\u91b6\u2beb\ua206\u3c00\ub6fe\u3132\ucb47\u458d\udc3a\u5668\ud0ca", 1499525560) + minecraftClient.options.getNarratorHotkey().getValue() + a.c(-2146941349, "\u4673"));
                System.out.println(a.b("\u8b3d\uf29d\u7846\ue630\u6dfd\ueb18\u511b\ud8fb\u46b0\ucc07\u4bc2\ub199\u3f6f\ua6fc\u2c8c\uaa61\u1029\u9fca\u0550\u830d\u0aec\u70bb\ufe46", 2048428890) + minecraftClient.options.pauseOnLostFocus);
                minecraftClient.onWindowFocusChanged(false);
                break;
            }
            case 225: {
                System.out.println(a.b("\ua893\ud133\u5be8\uc59e\u4e53\uc8b6\u72a3\ufb5b\u6508\uefaf\u687a\u9258\u1cc3\u8571\u0f3e\u89c8\u33d3\ubc13\u26bf\ua0f5\u2917\u5315\uddef\u4624\uc008\u4ac9\uf36b\u7d2d\ue7da\u6180\uea60", 1248372988) + (minecraftClient.currentScreen == null ? a.d("\u5c45\u25f5\uaf27\u315d", -1992056527, 1063845150) : minecraftClient.currentScreen.getClass().getSimpleName()));
                minecraftClient.onWindowFocusChanged(true);
                break;
            }
            case 230: {
                gpu.gqt(minecraftClient, a.d("\u5583\u2c73\ua6a1\u38cd\ub356\u35ea\u8fb0\u0656\u980f\u12b9\u9534\u6f0f\ue1d0\u7860\uf238", -2000150747, -1730065703));
                break;
            }
            case 231: {
                kfe kfe2 = kfx2.getByName(a.b("\u987a\ue1e4\u6b32\uf54f\u7e93\uf838\u424c\ucb81\u55c4\udf6e\u58b7\ua2d1", 420911157));
                kfe2.setEnabled(true);
                gpy = (Double)minecraftClient.options.getSoundVolumeOption(SoundCategory.MASTER).getValue();
                minecraftClient.options.getSoundVolumeOption(SoundCategory.MASTER).setValue((Object)0.0);
                Files.write(vpo.dir().resolve(a.b("\u858e\ufc12\u76d6\ue8ba\u632c\ue5c4\u5f81\ud667", 1410827726)), gpu.gqn(660.0, 0.4), new OpenOption[0]);
                vpo.scan();
                break;
            }
            case 232: 
            case 238: 
            case 244: 
            case 250: 
            case 256: 
            case 262: 
            case 268: {
                int n2 = (n - 232) / 6;
                String[] stringArray = new String[]{a.c(-154676651, "\ud21f\uab88\u2152\ubf2a\u34eb\ub25d\u0813\u81ea\u1fb8"), a.c(966350796, "\u579f\u2e0d\ua4c0\u3ab6\ub164\u37d2\u8d88"), a.c(-1394751329, "\uc8db\ub15d\u3b99\ua5e8\u2e31\ua889"), a.c(487994317, "\u3387\u4a10\uc0ca\u5eb2\ud573\u53c5\ue98b\u6072\ufe20"), a.c(895871449, "\ue98a\u9018\u1ad5\u84a3\u0f71\u89c7\u339d"), a.b("\uc4cd\ubd4b\u378f\ua9fe\u2227\ua49f", 1311753353), a.c(835843764, "\uf6fe\u8f69\u05b3\u9bcb\u100a\u96bc\u2cf2\ua50b\u3b59")};
                voa.play(stringArray[n2], n2 % 2 == 0, 0.6f);
                break;
            }
            case 274: {
                voa.play(a.b("\u7efb\u0767\u8da3\u13cf", -786923849), true, 0.6f);
                System.out.println(a.b("\u6d22\u1482\u9e59/\u8be2\u0d07\ub707\u3eea\ua0af\u2a05\uaddc\u57e9\ud978\u40c6\uca90\u4c68\uf631\u79a9\ue300", -892179135) + vpo.extras() + a.d("\u3bb0\u4255\uc89d\u56e4\udd33\u5b89\ue1d3\u6867\uf674\u7cc0\ufb09\u017f\u8fe6\u164d", -5785692, 1836813370) + ((vlv)gpu.gqr(kfx2.getByName(a.c(-1472115067, "\u4eca\u3754\ubd82\u23ff\ua823\u2e88\u94fc\u1d31\u8374\u09de\u8e07\u7461")), a.c(-143748775, "\u910b\ue881\u625a\ufc2b\u77f7\uf14f"))).getModes());
                break;
            }
            case 235: 
            case 241: 
            case 247: 
            case 253: 
            case 259: 
            case 265: 
            case 271: 
            case 277: {
                System.out.println(a.c(-1210629745, "\u41eb\u384b\ub290\u2ce6\ua72b\u21ce\u9bce\u1223\u8c66\u06cc\u8115\u7b20\uf5ff\u6c0b\ue654\u60b7\udaff\u553f\ucf9b\u4998") + minecraftClient.options.getSoundVolumeOption(SoundCategory.MASTER).getValue() + a.d("\u0b74\u72d6\uf81f", 1899963230, 360458240) + voa.report());
                break;
            }
            case 280: {
                minecraftClient.options.getSoundVolumeOption(SoundCategory.MASTER).setValue((Object)gpy);
                minecraftClient.player.equipStack(EquipmentSlot.MAINHAND, new ItemStack((ItemConvertible)Items.DIAMOND_SWORD));
                float f = minecraftClient.player.getYaw();
                Vec3d vec3d = Vec3d.fromPolar((float)0.0f, (float)(f + 180.0f)).multiply(3.0);
                OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.world, new GameProfile(UUID.randomUUID(), a.d("\uc55a\ubccc\u3612\ua862\u23b2\ua509", -431405035, 1883147531)));
                otherClientPlayerEntity.refreshPositionAndAngles(minecraftClient.player.getX() + vec3d.x, minecraftClient.player.getY(), minecraftClient.player.getZ() + vec3d.z, f, 0.0f);
                minecraftClient.world.addEntity((Entity)otherClientPlayerEntity);
                gqb = otherClientPlayerEntity;
                kfe kfe3 = kfx2.getByName(a.b("\u6a04\u139d\u994a\u0717\u8cf2\u0a43\ub00a\u39e1\ua7b9", 97086028));
                ((vmc)gpu.gqr(kfe3, a.c(1812985404, "\uf679\u8fc1\u050b"))).set(360.0);
                kfe3.setEnabled(true);
                gqc = f;
                break;
            }
            case 330: {
                Vec3d vec3d = gqb.getEntityPos().subtract(minecraftClient.player.getEntityPos());
                double d = Math.toDegrees(Math.atan2(vec3d.z, vec3d.x)) - 90.0;
                double d2 = Math.abs(MathHelper.wrapDegrees((double)(d - (double)minecraftClient.player.getYaw())));
                double d3 = Math.abs(MathHelper.wrapDegrees((double)(d - (double)gqc)));
                System.out.println(a.c(-1078022794, "\uad08\ud4a8\u5e73\uc005\u4bc8\ucd2d\u773f\ufec6\u609d\uea72\u6da4\u97d3\u190e\u80a5") + Math.round(d3) + a.c(1905824567, "\u9389\ueaa8\u6034\ufe4c\u759b\uf36c\u497d\uc08b\u5ed7\ud46f\u53a1\ua9c7\u2759\ubee4") + Math.round(d2) + a.d("\uc634\ubf15\u3589\uabf1\u2026\ua6d1\u1cc3\u9535\u0b78\u81d8\u061c\ufc3f\u72fa\ueb57\u611f\ue7fb\u5de7\ud265\u48de\ucec1\u473f\u3d62\ub3c7\u2810\uae79\u24a9\u9d43", 1102463177, 312116822) + minecraftClient.isWindowFocused() + a.c(-795068820, "\u3650\u4fed\uc57d\u5b1a\ud0ca\u567a\uec35\u65d9\ufbd4\u7129\uf6f9\u0c84\u825b\u1be4\u91b6\u171e") + minecraftClient.mouse.isCursorLocked() + a.c(1702414066, "\uc6da"));
                gpu.gqt(minecraftClient, a.d("\ubb7f\uc28f\u485c\ud631\u5daa\udb13\u6144\ue8eb\u76b1\ufc06", -673350509, -618477674));
                break;
            }
            case 331: {
                kfe kfe4 = kfx2.getByName(a.c(244368731, "\uc513\ubc8a\u365d\ua800\u23e5\ua554\u1f1d\u96f6\u08ae"));
                kfe4.setEnabled(false);
                ((vmc)gpu.gqr(kfe4, a.d("\u0665\u7fdd\uf517", -1530284642, 1256108990))).reset();
                if (gqb != null) {
                    minecraftClient.world.removeEntity(gqb.getId(), Entity.RemovalReason.DISCARDED);
                }
                for (String string : gpv) {
                    kfx2.getByName(string).toggle();
                }
                vlv vlv2 = (vlv)gpu.gqo(iov.class, a.c(-1369982333, "\ubad6\uc376\u49ad\ud7db\u5c16"));
                Method method = iov.class.getDeclaredMethod(a.d("\u172a\u6e8c\ue449\u7a2e\uf1e8\u776e\ucd0b\u44fc\udaa4\u500e\ud7df", -2095351634, 35549181), new Class[0]);
                method.setAccessible(true);
                vlv2.set(a.d("\u6462\u1dce\u970c", -1914647647, 428519304));
                method.invoke(null, new Object[0]);
                vlv2.set(a.d("\u95cf\uec56\u668e\uf8e4", 504480369, 1749178359));
                method.invoke(null, new Object[0]);
                iov.PRESET.set(gpw);
                iov.ACCENT.set(gpx);
                hyz.save();
                break;
            }
            case 332: {
                gpu.gqf(minecraftClient, a.c(1823932915, "\u01ba\u782f\uf2e6\u6c87"));
                break;
            }
            case 334: {
                Object v = ((Map)gpu.gqo(hlc.class, a.b("\u8725\ufe96\u7456\uea31\u61f1", -1257666717))).get(kfx2.getByName(a.c(144768215, "\ufc98\u8506\u0fd0\u91ad\u1a71\u9cda\u26ae\uaf63\u3126\ubb8c\u3c55\uc633")));
                Field field = v.getClass().getDeclaredField(a.d("\u03d5\u7a68\uf0b8\u6ec9\ue513\u63b3\ud9e3\u5004\uce5a", 1160585272, 451421063));
                field.setAccessible(true);
                field.setBoolean(v, false);
                break;
            }
            case 350: {
                gpu.gqt(minecraftClient, a.d("\ue79a\u9e6a\u14ba\u8ad4\u014d\u87f3\u3da5\ub458\u2a0c\ua0a7\u272d\udd02\u53c9\uca62\u402a\uc6d1\u7c89", 1735798482, -1837971159));
                break;
            }
            case 351: {
                minecraftClient.setScreen(null);
                Files.deleteIfExists(vpo.dir().resolve(a.b("\u66d2\u1f4e\u958a\u0be6\u8070\u0698\ubcdd\u353b", -94214510)));
                vpo.scan();
                break;
            }
            case 360: {
                return true;
            }
        }
        return false;
    }

    private static void gqf(MinecraftClient minecraftClient, String string) throws Exception {
        ((Map)gpu.gqo(hlc.class, a.d("\ud053\ua9f2\u2330\ubd5c\u3688\ub039\u0a75", -2023371267, -579789318))).clear();
        for (String string2 : new String[]{a.b("\u27d9\u5e76\ud4a2\u4ad9\uc105\u47ac\ufdd0", 32712617), a.b("\u855f\ufcf0\u7624\ue85f\u6383\ue52a\u5f57", 98796847)}) {
            Field field = hlc.class.getDeclaredField(string2);
            field.setAccessible(true);
            field.setFloat(null, Float.NaN);
        }
        Field field = hlc.class.getDeclaredField(a.c(-882047409, "\u063d\u7f99\uf549\u6b11\ue0e8\u6645"));
        field.setAccessible(true);
        field.set(null, string);
        minecraftClient.setScreen((Screen)new hlc());
    }

    private static List<?> gqg(String string) throws Exception {
        return (List)gpu.gqo(hlc.class, string);
    }

    private static Object gqh(String string, String string2) throws Exception {
        for (Object obj : gpu.gqg(string)) {
            if (!string2.equals(gpu.gqp(obj, a.d("\u5c25\u2589\uaf47\u312e\ubaf0", 1102343416, 1941385388)))) continue;
            return obj;
        }
        throw new IllegalStateException(a.d("\ufada\u836a\u09f6\u97c4\u1c11\u9ab3\u20f6\ua943", 1569691067, 1720217351) + string2);
    }

    private static void gqi(Object object) throws Exception {
        Field field = object.getClass().getDeclaredField(a.c(-1359154353, "\uf325\u8a98H\u9e39\u15e3\u9343\u2913\ua0f4\u3eaa"));
        field.setAccessible(true);
        field.setBoolean(object, true);
        Object object2 = gpu.gqp(object, a.b("\ud440\uadec\u2737\ub957\u328f\ub434", -1236610013));
        object2.getClass().getMethod(a.c(2013756832, "\u7dd0\u0477\u8eb5"), Float.TYPE).invoke(object2, Float.valueOf(0.0f));
    }

    private static Object gqj() throws Exception {
        for (Object e : (List)gpu.gqp(gpu.gqh(a.c(-301995437, "\uea2d\u9380\u195e\u8727\u0cf8\u8a6f\u301e\ub9fc\u27b5\uad13"), a.c(53910478, "\u9b81\ue206\u68d3\uf6a5\u7d69\ufbda\u41c4\uc861\u5622\udc9e\u5b45\ua13c")), a.c(1447823760, "\u09e6\u704a\ufa81\u64f4"))) {
            if (!e.getClass().getSimpleName().equals(a.c(1578460042, "\u63c0\u1a5d\u908d\u0eff\u8535\u0385\ub9f7\u303b\uae7c"))) continue;
            return e;
        }
        throw new IllegalStateException(a.b("\u6ede\u176e\u9df2\u03c0\u881b\u0ea9\ub4f9\u3d12\ua34a\u29fa\uae7a\u5459\uda93\u433a", -1101566274));
    }

    private static void gqk(String string, int n, int n2) throws Exception {
        Object object = Array.get(gpu.gqo(iov.class, string), n);
        float[] fArray = Color.RGBtoHSB(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, null);
        Method method = iov.class.getDeclaredMethod(a.d("\u39ba\u401d\ucadf\u548a\udf6c\u59d5\ue381\u6a6a", -1934536655, 2139384304), object.getClass(), Integer.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        method.setAccessible(true);
        method.invoke(null, object, n2, Float.valueOf(fArray[0]), Float.valueOf(fArray[1]), Float.valueOf(fArray[2]));
    }

    private static void gql(Screen screen, float f, float f2, int n) throws Exception {
        float f3 = gpu.gqq(screen, a.c(1598578063, "\u5de7\u244b\uae83\u30fc\ubb25\u3d93\u87f6"));
        float f4 = gpu.gqq(screen, a.d("\u5d26\u248a\uae42\u303d\ubbe4\u3d52\u8736", -924067320, 1131251526));
        float f5 = gpu.gqq(screen, a.d("\u5567\u2cc6\ua617\u386b\ub3b5", -161907536, -1335088735));
        screen.mouseClicked(new Click((double)(f3 + f * f5), (double)(f4 + f2 * f5), new MouseInput(n, 0)), false);
    }

    private static void gqm(Screen screen, float f, float f2, double d) throws Exception {
        float f3 = gpu.gqq(screen, a.c(-1251054510, "\u6c3a\u1596\u9f5e\u0121\u8af8\u0c4e\ub62b"));
        float f4 = gpu.gqq(screen, a.b("\ub277\ucbdb\u4113\udf6c\u54b5\ud203\u6867", 1314304543));
        float f5 = gpu.gqq(screen, a.b("\uf0ee\u894f\u039e\u9de2\u163c", -331157352));
        screen.mouseScrolled((double)(f3 + f * f5), (double)(f4 + f2 * f5), 0.0, d);
    }

    private static byte[] gqn(double d, double d2) {
        int n = 48000;
        int n2 = (int)((double)n * d2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(44 + n2 * 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(a.d("\u20ce\u5964\ud3b8\u4dc9", 31118921, -927402287).getBytes()).putInt(36 + n2 * 2).put(a.b("\u6bc2\u1265\u98a1\u06c3", -480351343).getBytes());
        byteBuffer.put(a.c(1421371797, "\u69f7\u104d\u9a87\u04a2").getBytes()).putInt(16).putShort((short)1).putShort((short)1).putInt(n).putInt(n * 2).putShort((short)2).putShort((short)16);
        byteBuffer.put(a.b("\u384b\u41ff\ucb39\u555d", 1806907435).getBytes()).putInt(n2 * 2);
        for (int i = 0; i < n2; ++i) {
            byteBuffer.putShort((short)(Math.sin(Math.PI * 2 * d * (double)i / (double)n) * 12000.0 * (1.0 - (double)i / (double)n2)));
        }
        return byteBuffer.array();
    }

    private static Object gqo(Class<?> clazz, String string) throws Exception {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        return field.get(null);
    }

    private static Object gqp(Object object, String string) throws Exception {
        for (Class<?> clazz = object.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(string);
                field.setAccessible(true);
                return field.get(object);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                continue;
            }
        }
        throw new NoSuchFieldException(string);
    }

    private static float gqq(Object object, String string) throws Exception {
        return ((Number)gpu.gqp(object, string)).floatValue();
    }

    private static vmo gqr(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(a.d("\u0634\u7f84\uf518\u6b3a\ue0fb\u665b\udc08\u55e4\ucbbc\u4104\uc690", 929969473, 2026582800) + string);
    }

    private static String gqs(int n) {
        return String.format(a.d("\u3149\u48ed\uc236\u5c27", -2062390563, 916675509), n);
    }

    private static void gqt(MinecraftClient minecraftClient, String string) {
        System.out.println(a.d("\u4472\u3dd5\ub70f\u2974\ua2e5\u2400\u9e42\u17a5\u89fd\u0318", 1518544043, -8626016) + string + a.d("\u68fa\u112b\u9b98", -383990543, -261837784) + minecraftClient.getCurrentFps() + a.b("\ub2a8\ucb5f\u419a\udfe8", 715305612));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\ufa12\u83a9\u0979\u9710\u1c82\u9a2c", 1393293938) + string + a.c(1472288848, "\u587a\u2195\uab58\u3520")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int vw(int n, int n2) {
        return n + n2 + -384059047;
    }

    private static /* synthetic */ int vx(int n, int n2) {
        return gpu.vw(n, n2) * n2;
    }

    private static /* synthetic */ int vy(int n, int n2) {
        return gpu.vw(n, n2) * n2;
    }
}

