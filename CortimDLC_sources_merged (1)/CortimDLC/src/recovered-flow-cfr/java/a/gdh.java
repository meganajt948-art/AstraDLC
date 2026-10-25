/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.screen.AccessibilityOnboardingScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen
 *  net.minecraft.client.gui.screen.option.OptionsScreen
 *  net.minecraft.client.gui.screen.option.VideoOptionsScreen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.util.ScreenshotRecorder
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.jos;
import a.jte;
import a.kbp;
import a.kbs;
import a.kct;
import flow.dev.a;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;
import org.lwjgl.glfw.GLFW;

public final class gdh {
    private static final float[] gdi = new float[]{0.5f, 1.5f, 2.9f, 3.5f, 3.8f, 4.2f, 4.8f, 5.5f, 6.5f, 7.5f, 8.5f, 9.5f};
    private static int gdj;
    private static long gdk;
    private static int gdl;
    private static int gdm;
    private static jte gdn;
    private static /* synthetic */ boolean gdo;
    private static /* synthetic */ long gdp;

    private gdh() {
    }

    public static void install() {
        if (!Boolean.getBoolean(a.c(-1121156076, "\u847c\ufdc7\u7717\ue97e\u62ec\ue441\u5e4f\ud7a8\u49fe\uc345\u4484\ubee4\u3025\ua993")) || !a.c(1845459780, "\u7b2d\u0294\u884c\u1626").equals(System.getenv(a.d("\ucd6b\ub4d0\u3e00\ua069\u2bdb\uad07\u1758\u9ebf\u00e9\u8a52\u0d93\uf7f3\u7932\ue084\u6adc\uec21\u567e\ud9a9\u4311\uc54b", 1660301628, -1630471163)))) {
            return;
        }
        ClientTickEvents.END_CLIENT_TICK.register(gdh::gds);
    }

    private static float gdq() {
        return (float)(System.nanoTime() - gdk) / 1.0E9f;
    }

    private static void gdr() {
        gdk = System.nanoTime();
        gdl = 0;
    }

    private static void gds(MinecraftClient minecraftClient) {
        ++gdm;
        try {
            gdh.gdt(minecraftClient);
        }
        catch (Throwable throwable) {
            System.out.println(a.d("\u9177\ue8ce\u6216\ufc7c\u77fe\uf11b\u4b59\uc2be\u5ce6\ud603\u51b6\uabc0\u251f\ubcab\u368e\ub065", 178343621, 410378191) + throwable);
            throwable.printStackTrace();
            gdj = 99;
            minecraftClient.method_1592();
        }
    }

    private static void gdt(MinecraftClient minecraftClient) throws Exception {
        switch (gdj) {
            case 0: {
                if (gdm % 100 == 0) {
                    System.out.println(a.b("\ub7b1\uce08\u44d0\udaba\u5138\ud7dd\u6d9f\ue478\u7a20\uf0c5\u7741\u8d26\u03f9\u9a55\u101b\u96ed\u2cab\ua327\u398e\ubf90\u367e\u4c3c\uc298\u5957\udf25\u55ec\uec06", -890914873) + minecraftClient.method_18506() + a.d("\u932b\uea96\u6016\ufe77\u75b1\uf317\u4944\uc0be\u5eaf", 1206376091, -1067039339) + minecraftClient.field_1755);
                }
                if (minecraftClient.method_18506() == null && minecraftClient.field_1755 instanceof AccessibilityOnboardingScreen) {
                    minecraftClient.field_1690.field_41785 = false;
                    minecraftClient.method_1507((Screen)new TitleScreen());
                }
                if (minecraftClient.method_18506() != null || !(minecraftClient.field_1755 instanceof jte) || gdm <= 60) break;
                Splash.preview(minecraftClient, 3.0f, true);
                gdh.gdr();
                gdj = 1;
                break;
            }
            case 1: {
                if (gdl < gdi.length && gdh.gdq() >= gdi[gdl]) {
                    gdh.gdy(minecraftClient, a.b("\u0e31\u7788\ufd50\u633a\ue8b5\u6e19\ud44b\u5da6\uc3bd\u490b\ucec2\u34b5\uba7f\u238c", 1286147666) + gdl);
                    ++gdl;
                }
                if (minecraftClient.method_18506() == null && minecraftClient.field_1755 instanceof kct) {
                    System.out.println(a.d("\ub9fa\uc043\u4a9b\ud4f1\u5f73\ud996\u63d4\uea33\u746b\ufe8e\u7914\u8362\u0daf\u9418\u1e56\u98e8\u22e8\uad20\u3780\ub1c6\u3863\u4273\uccc7\u5704\ud16a\u5bac\ue24d", 624610583, -1093897061) + gdh.gdq() + a.c(355875940, "\u3c46\u45a4"));
                    gdh.gdr();
                    gdj = 2;
                    break;
                }
                if (!(gdh.gdq() > 15.0f)) break;
                throw new IllegalStateException(a.c(844215414, "\ub40f\ucdb9\u4770\ud907\u52cd\ud433\u6e33\ue7c5\u7987\uf333\u74e0\u8edd_\u99eb\u13f2\u9519") + minecraftClient.method_18506() + a.c(-833465596, "\u5325") + minecraftClient.field_1755);
            }
            case 2: {
                Screen screen;
                float f = gdh.gdq();
                if (gdl == 0 && f > 0.25f) {
                    gdh.gdy(minecraftClient, a.d("\u1ad8\u6361\ue9b9\u77d3\ufc5c\u7af0\uc0a1\u494f\ud74a\u5de9\uda33\u204d\uae96\u3725\ubd7e\u3bc7\u81cc\u0e1a", -676252775, 1154623806));
                    ++gdl;
                    break;
                }
                if (gdl == 1 && f > 1.2f) {
                    gdh.gdv(minecraftClient, 0.37f, 0.5f);
                    ++gdl;
                    break;
                }
                if (gdl == 2 && f > 1.7f) {
                    gdh.gdy(minecraftClient, a.b("\u251d\u5ca4\ud67c\u4816\uc399\u4535\uff65\u768a\ue88f\u622c\ue5f6\u1f88\u9153\u08e0\u82bb\u0402\ube08\u31de\uab74\u2d36\ua4d6", 437527909));
                    ++gdl;
                    break;
                }
                if (gdl == 3 && f > 1.8f) {
                    gdh.gdw(minecraftClient.field_1755, a.d("\u604d\u19e5\u933c\u0d45", 26472708, -1684696771), new Class[]{Integer.TYPE}, 0);
                    ++gdl;
                    break;
                }
                if (gdl == 4 && f > 2.0f) {
                    gdh.gdy(minecraftClient, a.b("\ua8bf\ud106\u5bde\uc5b4\u4e3b\uc897\u72c0\ufb28\u652d\uef8e\u6854\u922a\u1cf1\u8542\u0f19\u89a0\u33b2\ubc7a\u26c3\ua09a\u2963\u5333", 1752082628));
                    ++gdl;
                    break;
                }
                if (gdl == 5 && (screen = minecraftClient.field_1755) instanceof jte) {
                    jte fArray;
                    gdn = fArray = (jte)screen;
                    gdh.gdv(minecraftClient, 0.1f, 0.9f);
                    gdh.gdr();
                    gdj = 3;
                    break;
                }
                if (!(f > 8.0f)) break;
                throw new IllegalStateException(a.c(-905309119, "\u1437\u6d87\ue71b\u7927\uf2f8\u7442\uce0a\u47ae\ud9b0\u5306\ud4c7\u2ea7\ua067\u3984\ub383\u356e\u8f2c\u00b8\u9a5b\u1c13\u95ee\uefb7\u6155\ufa9e") + minecraftClient.field_1755);
            }
            case 3: {
                float f = gdh.gdq();
                float[] n = new float[]{0.3f, 0.7f, 1.2f, 2.0f, 3.5f};
                if (gdl < n.length && f >= n[gdl]) {
                    gdh.gdy(minecraftClient, a.d("\u9c55\ue5ec\u6f34\uf15e\u7ad1\ufc7d\u462b\ucfc2\u51df\udb71\u5cb7\ua6cd\u2859", -248593381, -2102372306) + gdl);
                    ++gdl;
                    break;
                }
                if (gdl == n.length && f > 3.7f) {
                    float f2 = kbp.scale(gdh.gdn.field_22789, gdh.gdn.field_22790);
                    gdh.gdv(minecraftClient, 0.5f, ((float)gdh.gdn.field_22790 * 0.5f + -13.1f * f2) / (float)gdh.gdn.field_22790);
                    ++gdl;
                    break;
                }
                if (gdl == n.length + 1 && f > 4.3f) {
                    gdh.gdy(minecraftClient, a.d("\u5848\u21f1\uab29\u3543\ubecc\u3860\u8235\u0bdf\u95c5\u1f73\u98b9\u62db\uec1b\u75f5\ufff8\u7913\uc35b\u4c83\ud63b\u5063", -1119998022, 1213429643));
                    float f3 = kbp.scale(gdh.gdn.field_22789, gdh.gdn.field_22790);
                    gdh.gdv(minecraftClient, 1.0f - 49.5f * f3 / (float)gdh.gdn.field_22789, 22.5f * f3 / (float)gdh.gdn.field_22790);
                    ++gdl;
                    break;
                }
                if (gdl == n.length + 2 && f > 4.9f) {
                    gdh.gdy(minecraftClient, a.c(-2122506847, "\u1ddc\u6465\ueebd\u70d7\ufb58\u7df4\uc7a0\u4e4b\ud051\u5ae7\udd2d\u274f\ua98f\u3061\uba7d\u3c89"));
                    gdh.gdx((Object)gdn, a.b("\ue5ce\u9c66\u16bf\u88c6\u031f\u85b9\u3fd7\ub619\u2853\ua2e9", 367715764), true);
                    ++gdl;
                    break;
                }
                if (gdl == n.length + 3 && f > 5.6f) {
                    gdh.gdy(minecraftClient, a.d("\ua5da\udc63\u56bb\uc8d1\u435e\uc5f2\u7fa9\uf64d\u684f\ue2e7\u653e\u9f47\u119e\u8838", 1738429643, -1303187086));
                    gdh.gdx((Object)gdn, a.b("\u030f\u7aae\uf06c\u6e00\ue5d4\u6365\ud90e\u50ca\uce86\u4422\uc3f3\u3993", -979565712), Float.valueOf(240.0f));
                    ++gdl;
                    break;
                }
                if (gdl != n.length + 4 || !(f > 6.6f)) break;
                gdh.gdy(minecraftClient, a.d("\u5b09\u22b0\ua868\u3602\ubd8d\u3b21\u817a\u08d1\u96c1\u1c2d\u9be7\u619c\uef43\u76fc\ufcb8\u7a16\uc003\u4fc4\ud57a\u532b\udac3", 1068470775, -1942500730));
                gdh.gdx((Object)gdn, a.d("\uc43b\ubd9a\u3758\ua934\u22e0\ua451\u1e3a\u97fe\u09b2\u8316\u04c7\ufea7", 1686881132, 1472726824), Float.valueOf(0.0f));
                gdh.gdr();
                gdj = 4;
                break;
            }
            case 4: {
                kbs[] kbsArray = new kbs[]{kbs.byKey(a.d("\u7eed\u0743\u8d9d\u13ed\u9830\u1ed4\ua4ce\u2d3c\ub372\u39d0\ube1a\u446c\ucab2", -2041698921, -1897571583)), kbs.byKey(a.b("\u8a51\uf3ff\u7921\ue751\u6c8c\uea68\u5062\ud991\u47dc\ucd6a\u4aa1\ub0d9", 1471908395)), kbs.byKey(a.d("\uee49\u97e7\u1d39\u8349\u0894\u8e70\u347a\ubd80\u23d2\ua974\u2ea7\ud4dd", -518672792, -692961189)), kbs.byKey(a.b("\u3689\u4f27\uc5f9\u5b89\ud054\u56b0\uecbf\u6549\ufb05\u71ab", 1666529013))};
                int f4 = gdl / 2;
                if (f4 >= kbsArray.length) {
                    gdh.gdx((Object)gdn, a.d("\ua5fb\udc53\u568a\uc8f3\u432a\uc58c\u7fe2\uf62c\u6866\ue2dc", 1877898806, 1494012855), false);
                    minecraftClient.method_1507((Screen)new OptionsScreen((Screen)gdn, minecraftClient.field_1690));
                    gdh.gdr();
                    gdj = 5;
                    return;
                }
                if (gdl % 2 == 0 && gdh.gdq() > 0.2f) {
                    gdh.gdw((Object)gdn, a.b("\ucc00\ub5a8\u3f71\ua108", -476918668), new Class[]{kbs.class}, kbsArray[(f4 + 1) % kbsArray.length]);
                    ++gdl;
                    break;
                }
                if (gdl % 2 != 1 || !(gdh.gdq() > 1.6f)) break;
                gdh.gdx((Object)gdn, a.d("\u9d71\ue4d9\u6e00\uf079\u7ba0\ufd06\u4768\ucea6\u50ec\uda56", -660637318, 243852401), false);
                gdh.gdy(minecraftClient, a.b("\u33f0\u4a49\uc091\u5efb\ud574\u53d8\ue982\u6067\ufe66\u74c1\uf316\u0975\u87be\u1e0e\u941e", 1682715538) + kbsArray[(f4 + 1) % kbsArray.length].key.replace(':', '-'));
                ++gdl;
                gdh.gdr();
                gdl = f4 * 2 + 2;
                break;
            }
            case 5: {
                float f = gdh.gdq();
                if (gdl == 0 && f > 0.15f) {
                    gdh.gdy(minecraftClient, a.b("\u6b59\u12e0\u9838\u0652\u8ddd\u0b70\ub122\u3882\ua691\u2c62\uabae\u51db\udf11\u46a6\uccf4\u4a18\uf009\u7f9c\ue528", -1768199385));
                    ++gdl;
                    break;
                }
                if (gdl == 1 && f > 0.9f) {
                    gdh.gdv(minecraftClient, 0.32999998f, 0.4f);
                    ++gdl;
                    break;
                }
                if (gdl == 2 && f > 1.5f) {
                    gdh.gdy(minecraftClient, a.c(-495551394, "\u7c23\u059a\u8f42\u1128\u9aa7\u1c0a\ua658\u2ffb\ub1eb\u3b18\ubcd4\u46a1\uc86b\u51dc\udb8e\u5d62"));
                    minecraftClient.method_1507((Screen)new MultiplayerScreen((Screen)gdn));
                    ++gdl;
                    break;
                }
                if (gdl == 3 && f > 2.6f) {
                    gdh.gdy(minecraftClient, a.d("\u076f\u7ed6\uf40e\u6a64\ue1eb\u6746\udd14\u54b6\ucaa7\u4056\uc79d\u3df5\ub33a\u2a96\ua0dc\u2631\u9c73\u13ba\u8915\u0f53", 1161807441, -1264664249));
                    minecraftClient.method_1507((Screen)new VideoOptionsScreen((Screen)gdn, minecraftClient, minecraftClient.field_1690));
                    ++gdl;
                    break;
                }
                if (gdl == 4 && f > 3.6f) {
                    gdh.gdy(minecraftClient, a.b("\u5b71\u22c8\ua810\u367a\ubdf5\u3b58\u810a\u08af\u96b9\u1c53\u9b9f\u61e3\uef35\u768e", 363748114));
                    minecraftClient.method_1507((Screen)gdn);
                    ++gdl;
                    break;
                }
                if (gdl == 5 && f > 4.0f) {
                    gdh.gdy(minecraftClient, a.d("\u7c81\u0538\u8fe0\u118a\u9a05\u1ca8\ua6fa\u2f16\ub106\u3bb4\ubc65\u461c", 1363497314, -1842074238));
                    ++gdl;
                    break;
                }
                if (gdl != 6 || !(f > 5.2f)) break;
                float jos2 = kbp.scale(gdh.gdn.field_22789, gdh.gdn.field_22790);
                float f5 = ((float)gdh.gdn.field_22789 / jos2 - 138.0f) * 0.5f + 40.0f;
                float f2 = (float)gdh.gdn.field_22790 / jos2 * 0.5f - 25.6f + 64.0f + 12.5f;
                gdn.method_25402(new Click((double)(f5 * jos2), (double)(f2 * jos2), new MouseInput(0, 0)), false);
                gdh.gdr();
                gdj = 7;
                break;
            }
            case 7: {
                float f = gdh.gdq();
                if (gdl == 0 && f > 0.08f) {
                    gdh.gdy(minecraftClient, a.c(-547970945, "\ua003\ud9ba\u5362\ucd08\u4687\uc02a\u7a7a\uf394\u6d87\ue73b\u60f0\u9ad8\u1452\u8de1\u07a5\u8142\u3b0d"));
                    ++gdl;
                    break;
                }
                if (gdl == 1 && f > 0.9f) {
                    gdh.gdy(minecraftClient, a.b("\u1280\u6b39\ue1e1\u7f8b\uf404\u72a9\uc8f8\u4117\udf04\u55b8\ud273", 997266150));
                    ++gdl;
                    break;
                }
                if (gdl == 2 && f > 1.1f) {
                    Screen object = minecraftClient.field_1755;
                    if (object instanceof jos) {
                        jos jos2 = (jos)object;
                        for (char c : a.d("\u7231\u0baa\u817a\u1f13\u94e7\u1267\ua822\u21d4\ubf9a\u353c", -1249154405, -781641498).toCharArray()) {
                            jos2.method_25400(new CharInput((int)c, 0));
                        }
                        jos2.method_25404(new KeyInput(257, 0, 0));
                    }
                    ++gdl;
                    break;
                }
                if (gdl == 3 && f > 1.8f) {
                    gdh.gdy(minecraftClient, a.c(647262230, "\u706a\u09d3\u830b\u1d61\u96ee\u1043\uaa15\u23fd\ubdee\u3752\ub099\u4ab1\uc42a\u5d9e\ud7cd\u513d\ueb73"));
                    gdh.gdu(minecraftClient, 60.0f);
                    ++gdl;
                    break;
                }
                if (gdl == 4 && f > 3.0f) {
                    gdh.gdy(minecraftClient, a.d("\u4330\u3a89\ub051\u2e3b\ua5b4\u2319\u994e\u10a7\u8eb4\u0408\u83c3\u79eb\uf77d\u6ecf\ue494\u626b\ud823", 2022001575, -2125199125));
                    gdh.gdu(minecraftClient, 242.0f);
                    ++gdl;
                    break;
                }
                if (gdl == 5 && f > 3.3f) {
                    gdh.gdy(minecraftClient, a.c(1038969267, "\u69cd\u1074\u9aac\u04c6\u8f49\u09e4\ub3b0\u3a5a\ua449\u2ef5\ua93e\u5316\udd8f\u4432\uce60\u4899\uf2d9\u7d13\ue7bf"));
                    gdh.gdu(minecraftClient, 242.0f);
                    ++gdl;
                    break;
                }
                if (gdl == 6 && f > 3.8f) {
                    gdh.gdy(minecraftClient, a.b("\u4a8a\u3333\ub9eb\u2781\uac0e\u2aa3\u90f6\u191d\u870e\u0db2\u8a79\u7051\ufed9\u677f\ued24\u6bd7\ud181\u5e43\uc4f1", -1632089356));
                    minecraftClient.method_1507((Screen)gdn);
                    gdh.gdx((Object)gdn, a.b("\u76d9\u0f69\u85a1\u1bcd\u9010\u16a7\uacde\u2510\ubb5a\u31e0", -153389379), false);
                    ++gdl;
                    break;
                }
                if (gdl != 7 || !(f > 5.0f)) break;
                Splash.preview(minecraftClient, 2.0f, false);
                gdh.gdr();
                gdj = 6;
                break;
            }
            case 6: {
                float[] fArray = new float[]{0.15f, 0.6f, 1.4f, 2.2f};
                if (gdl < fArray.length && gdh.gdq() >= fArray[gdl]) {
                    gdh.gdy(minecraftClient, a.d("\u1a16\u63af\ue977\u771d\ufc92\u7a3f\uc06c\u4981\ud781\u5d27\udafd\u208f\uae56\u37e2\ubdf8", -2128300220, -310006480) + gdl);
                    ++gdl;
                }
                if (gdl >= fArray.length && !(minecraftClient.method_18506() instanceof FlowSplash)) {
                    System.out.println(a.b("\u53c0\u2a79\ua0a1\u3ecb\ub549\u33ac\u89ee\t\u9e51\u14b4\u9317\u6977\ue7b2\u7e03\uf42f\u72d2\uc8cf\u4709\uddb3\u5be1\ud218\ua84c\u26bb\ubd2d\u3b5a\ub18a\u0832\u8626\u1c90\u9ac6\u1167\uefa7\u65ff\ufc5c", -882355313) + gdh.gdq() + a.d("\u6e00\u17e2", -2130805363, -935259217));
                    gdj = 99;
                    minecraftClient.method_1592();
                    break;
                }
                if (!(gdh.gdq() > 12.0f)) break;
                throw new IllegalStateException(a.b("\ufd09\u84af\u0e75\u9007\u1bde\u9d6a\u277d\uaedf\u3087\uba2b\u3dfd\uc78c\u4917\ud0f3\u5aa5", -2069889676));
            }
        }
    }

    private static void gdu(MinecraftClient minecraftClient, float f) {
        Screen screen = minecraftClient.field_1755;
        if (!(screen instanceof jos)) {
            return;
        }
        jos jos2 = (jos)screen;
        float f2 = kbp.scale(jos2.field_22789, jos2.field_22790);
        float f3 = ((float)jos2.field_22789 / f2 - 268.0f) * 0.5f;
        float f4 = ((float)jos2.field_22790 / f2 - 218.0f) * 0.5f + 4.0f;
        jos2.method_25402(new Click((double)((f3 + f) * f2), (double)((f4 + 52.0f + 14.0f) * f2), new MouseInput(0, 0)), false);
    }

    private static void gdv(MinecraftClient minecraftClient, float f, float f2) {
        int[] nArray = new int[1];
        int[] nArray2 = new int[1];
        GLFW.glfwGetWindowSize((long)minecraftClient.method_22683().method_4490(), (int[])nArray, (int[])nArray2);
        GLFW.glfwSetCursorPos((long)minecraftClient.method_22683().method_4490(), (double)(f * (float)nArray[0]), (double)(f2 * (float)nArray2[0]));
    }

    private static void gdw(Object object, String string, Class<?>[] classArray, Object ... objectArray) throws Exception {
        Method method = object.getClass().getDeclaredMethod(string, classArray);
        method.setAccessible(true);
        method.invoke(object, objectArray);
    }

    private static void gdx(Object object, String string, Object object2) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        field.set(object, object2);
    }

    private static void gdy(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\ub5e4\ucc5d\u4685\ud8ef\u536d\ud588\u6fca\ue62d\u7875\uf290", 181253507) + string + a.d("\u5742\u2e93\ua420", -281767153, -1212038034) + minecraftClient.method_47599() + a.b("\ud0a5\ua952\u2397\ubde5", 371642497));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\ufb70\u82cb\u081b\u9672\u1de0\u9b4e", 1311239405, 1851987965) + string + a.c(660726025, "\ue123\u98cc\u1201\u8c79")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> {});
    }

    private static /* synthetic */ int tg(int n, int n2) {
        return (n ^ n2) + -151045592;
    }
}

