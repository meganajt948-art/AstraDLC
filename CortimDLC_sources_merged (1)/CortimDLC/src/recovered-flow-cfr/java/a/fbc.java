/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.GameMenuScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.text.Text
 */
package a;

import a.kfe;
import a.vmc;
import a.vmo;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

final class fbc {
    private static /* synthetic */ boolean fbd;
    private static /* synthetic */ long fbe;

    private fbc() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        switch (n) {
            case 1: {
                fbc.fbf(minecraftClient, a.c(1882854929, "\u1668\u6fc4\ue513\u7b6a\uf0f8\u761a\ucc5f\u45bf\udbb4\u5113\ud6c6\u2cb7\ua260"));
                fbc.fbf(minecraftClient, a.b("\uebff\u925e\u1881\u86ed\u0d2d\u8b9b\u31c5\ub83a\u2676\uacd1\u2b46\ud178\u5fa2\uc61b\u4c47\ucab0\u70e8\uff24\u6588\ue3ca\u6a2b\u1029\u9edb\u050f\u8370\u09e5\ub010\u3e4b\ua4bf\u22f6\ua95a\u5793\udd8c\u4435\uc26b\u48de\uf704\u7d6d\ufba2", -538711125));
                fbc.fbf(minecraftClient, a.d("\u477c\u3edd\ub402\u2a6e\ua1ae\u2718\u9d46\u14b9\u8af5R\u87c5\u7dfb\uf321\u6a98\ue0c4\u6633\udc6b\u53a7\uc90b\u4f49\uc6a8\ubcaa\u324a\ua98d\u2fe3\ua522\u1c9c\u92d7\u0823\u8e6e\u05d0\ufb19\u710f\ue8b2\u6ee4\ue44f\u5b9f\ud1ba\u572f\uce94\u44c8\u3a21\ub06d\u37c4", 247117332, -193531593));
                kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.d("\udf7c\ua6e2\u2c36\ub243\u3998\ubf3c\u0572\u8c85\u12db\u9877", -532445246, -1220388619));
                for (vmo vmo2 : kfe2.getSettings()) {
                    if (!(vmo2 instanceof vmc)) continue;
                    vmc vmc2 = (vmc)vmo2;
                    if (!a.b("\ubbbe\uc22c\u48ea\ud69b\u5d4d", -2095858712).equals(vmc2.getName())) continue;
                    vmc2.set(0.5);
                }
                System.out.println(a.d("\uf5cf\u8c71\u06a5\u98d0\u134a\u95af\u2fed\ua60a\u3852\ub2ad\u3564\ucf74\u418c\ud83a\u526d\ud490\u6eca\ue106\u7bb3\ufde3\u7409\u0e0b\u80f7\u1b27\u9d16\u17da\uae74", 1391944567, 547722946) + kfe2.isEnabled());
                break;
            }
            case 20: {
                minecraftClient.options.playerListKey.setPressed(true);
                break;
            }
            case 22: {
                fbc.fbg(minecraftClient, a.b("\u5ec1\u277f\uadab\u33de\ub849\u3ee5\u84b7\u0d5a\u935c\u19f8\u9e28\u6416\uea83\u732d\uf96b\u7f91\uc5d9\u4a0f\ud0b5", -405053773));
                break;
            }
            case 34: {
                fbc.fbg(minecraftClient, a.b("\ua1b7\ud809\u52dd\ucca8\u473f\uc193\u7bc2\uf22c\u6c2a\ue68e\u615e\u9b60\u15f5\u8c5b\u061d\u80e7", -44654138));
                break;
            }
            case 35: {
                minecraftClient.options.playerListKey.setPressed(false);
                break;
            }
            case 37: {
                fbc.fbg(minecraftClient, a.b("\u4174\u38ca\ub21e\u2c6b\ua7fc\u2150\u9b00\u12ef\u8ce9\u064d\u819d\u7ba3\uf53a\u6c84\ue6d4\u6039\uda6c\u55ba\ucf00", 1294287110));
                break;
            }
            case 50: {
                minecraftClient.inGameHud.getChatHud().addMessage((Text)Text.literal((String)a.c(2044120767, "\uceee\ub772\u3da8\ua3d9\u280d\uaef3\u14e6\u9d03\u0341\u89f2\u0e6c\uf47b\u7a86\ue334\u697f\uefd5\u5596\uda0b\u40bd\uc6eb\u4f17\u3503\ubbff\u202f\ua65b")));
                break;
            }
            case 56: {
                minecraftClient.inGameHud.getChatHud().addMessage((Text)Text.literal((String)a.d("\u6c33\u15e3\u9f63\u0104\u8ad5\u0c68\ub63a\u3fc1\ua1da\u2b27\uacf1\u5687\ud85b\u41af\ucbaf\u4d41\uf70b\u78d7\ue265\u6422\ued86\u9783\u192c\u82f0\u04ca\u8e58\u37e0\ub9b8\u235a\ua55f\u2eb9\ud06d", -1398516817, -1926021123)));
                break;
            }
            case 57: {
                fbc.fbg(minecraftClient, a.b("\u143c\u6d82\ue756\u7923\uf2b4\u7418\uce4f\u47a7\ud9b6\u530c\ud4d6\u2eb2\ua03c\u39d3\ub39f\u356b\u8f29\u00f5\u9a41\u1c19", -1112665015));
                break;
            }
            case 70: {
                fbc.fbg(minecraftClient, a.c(292027439, "\ufc5a\u85e4\u0f30\u9145\u1ad2\u9c7e\u2628\uafc1\u31d0\ubb6a\u3cb0\uc6d4\u485a\ud1b5\u5bf0\udd10\u675f\ue896\u722c\uf47c"));
                break;
            }
            case 80: {
                minecraftClient.setScreen((Screen)new ChatScreen("", false));
                break;
            }
            case 82: {
                fbc.fbg(minecraftClient, a.d("\ub6bd\ucf03\u45d7\udba2\u5035\ud699\u6ccc\ue526\u7b37\uf18d\u7657\u8c33\u02bd\u9b4e\u1102\u97e6\u2da2\ua230\u38dc\ube96\u377b\u4d30\uc384\u585c", 1090643687, 58413091));
                break;
            }
            case 95: {
                fbc.fbg(minecraftClient, a.b("\ubacb\uc375\u49a1\ud7d4\u5c43\udaef\u60bb\ue950\u7741\ufdfb\u7a21\u8045\u0ecb\u9738\u1d74\u9b90\u21d4", 227588795));
                minecraftClient.setScreen(null);
                break;
            }
            case 110: {
                minecraftClient.setScreen((Screen)new InventoryScreen((PlayerEntity)minecraftClient.player));
                break;
            }
            case 112: {
                fbc.fbg(minecraftClient, a.b("\ue1ca\u9874\u12a0\u8cd5\u0742\u81ee\u3bb5\ub251\u2c4a\ua6fc\u2137\udb55\u5589\ucc22\u466a\uc086\u7ac2\uf547\u6fb6\ue9f8\u601a\u1a40\u94f4\u0f22\u8954", -331095630));
                break;
            }
            case 130: {
                fbc.fbg(minecraftClient, a.b("\ue385\u9a3b\u10ef\u8e9a\u050d\u83a1\u39fb\ub01e\u2e05\ua4b3\u2378\ud91a\u57c6\uce6d\u4425\uc2c9\u788d\uf708\u6df9\uebb7\u6255\u180f", 2061362162));
                minecraftClient.setScreen(null);
                break;
            }
            case 140: {
                minecraftClient.setScreen((Screen)new GameMenuScreen(true));
                break;
            }
            case 142: {
                fbc.fbg(minecraftClient, a.c(270715493, "\uca10\ub3ae\u397a\ua70f\u2c98\uaa35\u1067\u998b\u0789\u8d29\u0aee\uf099\u7e58\ue7a1\u6dad\ueb47\u5112\uded9\u446d\uc235"));
                break;
            }
            case 160: {
                fbc.fbg(minecraftClient, a.b("\u0250\u7bee\uf13a\u6f4f\ue4d8\u6275\ud826\u51cb\ucfc9\u4569\uc2ae\u38d9\ub618", -629865924));
                break;
            }
            case 170: {
                minecraftClient.setScreen(null);
                System.out.println(a.b("\u7869\u01d7\u8b03\u1576\u9eec\u1809\ua24b\u2bac\ub5f4\u3f11\ub8b2\u42d2\ucc17\u55a6", 1386772486));
                return true;
            }
        }
        return false;
    }

    private static void fbf(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void fbg(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u6720\u1e87\u945d\u0a26\u81b7\u0752\ubd10\u34f7\uaaaf\u204a", 2029217625) + string + a.d("\u60ce\u191f\u93ac", 1877185048, 1344271093) + minecraftClient.getCurrentFps() + a.d("\u9e53\ue7a4\u6d61\uf313", 296859215, 1779968056));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\u664d\u1ff6\u9526\u0b4f\u80dd\u0673", -67082707) + string + a.d("\ub6ee\ucf01\u45cc\udbb4", 1305709896, 1252277132)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
    }

    private static /* synthetic */ int na(int n, int n2) {
        return (n ^ n2) + 804670014;
    }

    private static /* synthetic */ int nb(int n, int n2) {
        return n - n2 | 0x75ED6D49;
    }

    private static /* synthetic */ int nc(int n, int n2) {
        return fbc.nb(n, n2) * n2;
    }
}

