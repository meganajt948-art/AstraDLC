/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.hud.BossBarHud
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.gui.screen.world.CreateWorldScreen
 *  net.minecraft.client.gui.screen.world.WorldCreator$WorldType
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.option.Perspective
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.ChargedProjectilesComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.boss.ServerBossBar
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.entity.projectile.thrown.EnderPearlEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.fbc;
import a.fbk;
import a.fbw;
import a.fdp;
import a.fdx;
import a.fga;
import a.fgv;
import a.fif;
import a.fjv;
import a.fkm;
import a.flm;
import a.fpo;
import a.fug;
import a.fvb;
import a.fvw;
import a.fwd;
import a.fwv;
import a.fxp;
import a.fyl;
import a.gax;
import a.gef;
import a.ghf;
import a.ghy;
import a.gkm;
import a.gml;
import a.gnr;
import a.gpu;
import a.grd;
import a.grw;
import a.gsz;
import a.gwv;
import a.gxf;
import a.gyf;
import a.gzt;
import a.hav;
import a.hbt;
import a.hdj;
import a.hdt;
import a.heb;
import a.hfi;
import a.hge;
import a.hgq;
import a.hhf;
import a.hlc;
import a.hyv;
import a.hyz;
import a.ida;
import a.ixu;
import a.izx;
import a.jcs;
import a.kfe;
import a.kfx;
import a.kvz;
import a.oxw;
import a.pbz;
import a.rjy;
import a.ruv;
import a.vaf;
import a.vbb;
import a.vkl;
import a.vla;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vyn;
import a.wam;
import a.wap;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ChargedProjectilesComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public final class gtq {
    private static int gtr;
    private static int gts;
    private static final String gtt;
    private static final List<PlayerEntity> gtu;
    private static Team gtv;
    private static final int gtw = 70;
    private static final String[] gtx;
    private static final int[] gty;
    private static long gtz;
    private static long gua;
    private static boolean gub;
    private static PlayerEntity guc;
    private static String gud;
    private static final List<ServerBossBar> gue;
    private static double guf;
    private static float gug;
    private static double guh;
    private static float gui;
    private static int guj;
    private static final int[] guk;
    private static final int gul = 70;
    private static int gum;
    private static int gun;
    private static int guo;
    private static int gup;
    private static String guq;
    private static String gur;
    private static int gus;
    private static int gut;
    private static /* synthetic */ boolean guu;
    private static /* synthetic */ long guv;

    private gtq() {
    }

    public static void install() {
        if (!Boolean.getBoolean(a.d("\u2ec1\u577a\uddaa\u43c3\uc851\u4efc\uf4f2\u7d15\ue343\u69f8\uee39\u1459\u9a98\u032e", 384057136, -695070311)) || a.d("\u42cd\u3b74\ub1ac\u2fc6", -2116604378, 1141140610).equals(gtt) || a.c(-1446649412, "\ue1cf\u9861\u12bf\u8ccf\u0712").equals(gtt) || a.d("\u42cf\u3b7d\ub1ae\u2fdb", 44444519, -1781962304).equals(gtt) || a.b("\ue33c\u9a87\u1057\u8e3e\u05f3\u834a\u3912\ub0f8", 1887429458).equals(gtt)) {
            return;
        }
        System.out.println(a.c(1189386822, "\u9a3a\ue39d\u6947\uf73c\u7cad\ufa48\u400a\uc9ed\u57b5\udd50\u5ac2\ua0a0\u2e68\ub7d1\u3d83"));
        ClientTickEvents.END_CLIENT_TICK.register(gtq::guw);
    }

    private static void guw(MinecraftClient minecraftClient) {
        ++gts;
        try {
            switch (gtr) {
                case 0: {
                    if (minecraftClient.method_18506() != null || minecraftClient.field_1755 == null || gts <= 40) break;
                    CreateWorldScreen.method_64248((MinecraftClient)minecraftClient, () -> minecraftClient.method_1507((Screen)new TitleScreen()));
                    gtq.gwo();
                    break;
                }
                case 1: {
                    Object object = minecraftClient.field_1755;
                    if (object instanceof CreateWorldScreen) {
                        CreateWorldScreen createWorldScreen = (CreateWorldScreen)object;
                        if (gts > 20) {
                            if (a.d("\uf4ef\u8d4e\u079b\u99e1\u123d\u949b\u2ec3", 20342427, -1565421056).equals(gtt) || a.c(29790974, "\u928a\ueb26\u61f4\uff9d\u744e\uf2e7\u48a6").equals(gtt) || a.c(1859302949, "\ub65f\ucfe8\u4523\udb52\u508d\ud62b\u6c79\ue590\u7bdd").equals(gtt) || a.b("\udd89\ua43f\u2ef7\ub09b\u3b53", -2054431233).equals(gtt)) {
                                object = createWorldScreen.method_48657();
                                object.method_48705((WorldCreator.WorldType)object.method_48732().get(0));
                                object.method_48716(System.getenv().getOrDefault(a.d("\u4fd6\u366d\ubcbd\u22d4\ua966\u2fba\u95e5\u1c02\u825d\u08ed", 1737432814, 1927893364), a.c(1581267823, "\u3b03\u42b8\uc868\u5601\uddc2\u5b7c\ue12a\u68d7\uf683\u7c28")));
                            }
                            object = CreateWorldScreen.class.getDeclaredMethod(a.b("\u6341\u1ae1\u9025\u0e50\u8592\u0332\ub948\u3090\uaedc\u247e\ua3a4", -83795159), new Class[0]);
                            ((Method)object).setAccessible(true);
                            ((Method)object).invoke((Object)createWorldScreen, new Object[0]);
                            gtq.gwo();
                        }
                    }
                    break;
                }
                case 2: {
                    if (minecraftClient.field_1687 != null && minecraftClient.field_1724 != null && minecraftClient.field_1755 == null) {
                        if (gts > 100 && a.b("\u30b5\u490b\uc3d4\u5dad\ud66b\u50cf\uea9a\u637f", -1941884717).equals(gtt)) {
                            gtr = 4;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u2faf\u5600\udcd4\u42af", 1949196665, 1235898021).equals(gtt)) {
                            gtr = 5;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(1771221851, "\ub324\uca8b\u405f\ude24\u55fd\ud353\u6918\ue0f4").equals(gtt)) {
                            gtr = 6;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u9fa2\ue606\u6cd1\uf2b3\u797a", 1530568663).equals(gtt)) {
                            gtr = 7;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\uc7b3\ube05\u34d0\uaaa6\u2167\ua7c1\u1d93\u9465\u0a2d\u808a", 671610495, -1517407819).equals(gtt)) {
                            gtr = 8;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u5303\u2aa4\ua074", -2001281863, 1050251228).equals(gtt)) {
                            gtr = 9;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(1818699749, "\u2781\u5e20\ud4e8\u4a97\uc14f\u47e2").equals(gtt)) {
                            gtr = 10;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-42717328, "\u2f15\u56ad\udc76").equals(gtt)) {
                            gtr = 11;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u2234\u5b8c\ud157\u4f2d\uc4f9\u4248\uf81f", 2077073306, -1378435633).equals(gtt)) {
                            gtr = 12;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u63ea\u1a49\u908b", -235161981, -2072259299).equals(gtt)) {
                            gtr = 40;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u05b5\u7c1a\uf6ce\u68a5\ue363\u65c5", -1154349628).equals(gtt)) {
                            gtr = 41;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u578e\u2e2d\ua4e2\u3a97\ub142\u37ea\u8daa", -1481156626).equals(gtt)) {
                            gtr = 42;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u7874\u01c7\u8b0f\u1563\u9eb2\u1802", -1809529027, 1585757986).equals(gtt)) {
                            gtr = 43;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u0093\u7933\uf3fb\u6d97", -585817970, -1998774150).equals(gtt)) {
                            gtr = 13;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u3de1\u445c\uce8d\u50fa", -1994703480).equals(gtt)) {
                            gtr = 14;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u5fae\u2600\uacc9\u32be\ub97d\u3fc1\u858d", -237543457).equals(gtt)) {
                            gtr = 15;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-1027036768, "\ua9c8\ud074\u5aa8\uc4d0").equals(gtt)) {
                            gtr = 16;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u2123\u5883\ud258\u4c2e\uc7e3", -2051209135, 1306142983).equals(gtt)) {
                            gtr = 17;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u7792\u0e38\u84f0\u1a90\u914f", 225933283).equals(gtt)) {
                            gtr = 44;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u48f1\u315b\ubb88\u25fa", 94801566, -1949579745).equals(gtt)) {
                            gtr = 45;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u58f3\u215c", -858564457).equals(gtt)) {
                            gtr = 46;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\ue684\u9f20\u15e4\u8b81", 2003505768, 287503512).equals(gtt)) {
                            gtr = 61;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u9a2d\ue397\u6949\uf72e\u7cfe", 1853017000, -28093981).equals(gtt)) {
                            gtr = 60;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\ubfe9\uc657\u4c83\ud2f6", -1774699523, -1938652047).equals(gtt)) {
                            gtr = 62;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\uf2fb\u8b56\u0188\u9fe1\u142a\u928c\u28de", -1190282581, 895502375).equals(gtt)) {
                            gtr = 47;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\ue4f8\u9d57\u1783\u89e8\u022e\u8488\u3ed9\ub734\u2966\ua3d8\u2411\ude67", 880665731).equals(gtt)) {
                            gtr = 48;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u6d69\u14c9\u9e0ar", -2106152828, 995935629).equals(gtt)) {
                            gtr = 63;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-1058000794, "\u300d\u49a8\uc37c\u5d1e\ud6db\u506d\uea3f\u63df\ufd8d\u773a").equals(gtt)) {
                            gtr = 64;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u7265\u0bc0\u8114\u1f76\u94b3\u1205\ua843\u21bd\ubfe8\u354e", 1574269454).equals(gtt)) {
                            gtr = 65;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\ua216\udbba\u5179\ucf03\u44c9", 493134460).equals(gtt)) {
                            gtr = 66;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-1489436636, "Q\u79f1\uf331\u6d46\ue69c").equals(gtt)) {
                            gtr = 70;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-1391318701, "\u293a\u509f\uda4d\u4427\ucff2\u494f\uf31e\u7ae9").equals(gtt)) {
                            gtr = 49;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\ufd02\u84a4\u0e6c\u9017\u1bc8\u9d70", 432807533, -965025013).equals(gtt)) {
                            gtr = 50;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-1623059573, "\u13f9\u6a54\ue08a\u7ef3\uf52c\u738b").equals(gtt)) {
                            gtr = 51;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u7313\u0aae\u807e\u1e0f\u95d1\u1366\ua922\u20c8\ube8a", 678130553).equals(gtt)) {
                            gtr = 52;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\uc511\ubcad\u3665\ua813", -428227209).equals(gtt)) {
                            gtr = 74;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-975589677, "\uaeb1\ud707\u5dc7\uc3a9").equals(gtt)) {
                            gtr = 18;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\uba32\uc397\u4945\ud72f\u5cfa\uda4f\u601b\ue9e1", 966462147, 1001500824).equals(gtt)) {
                            gtr = 72;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\uae8c\ud739\u5ded\uc397\u4847\ucef5\u74b4\ufd53", 958211401, -534475872).equals(gtt)) {
                            gtr = 73;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u2f73\u56d6\udc1e\u4263\uc9bf\u4f04\uf547\u7ca3\ue2fa", -819199926, 1059139414).equals(gtt)) {
                            gtr = 53;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u1b97\u623e\ue8ff", 1634474983).equals(gtt)) {
                            gtr = 54;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u23e5\u5a5f\ud09c\u4eea\uc520", 1110057870).equals(gtt)) {
                            gtr = 56;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\uc2b8\ubb19\u31cc\uafb6\u246a\ua2cc\u1894", 1638056652).equals(gtt)) {
                            gtr = 58;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u18bd\u6111\uebc3\u75aa\ufe79\u78d0\uc291", -266775643, -345420948).equals(gtt)) {
                            gtr = 81;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u0abd\u730a\uf9c1\u67b0\uec6f\u6ac9\ud09b\u5972\uc73f", -934343993).equals(gtt)) {
                            gtr = 82;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u1fea\u665c\uec94\u72f8\uf930", 1154818893, -1533330223).equals(gtt)) {
                            gtr = 83;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(-71906608, "\ucab2\ub308\u39d6\ua7b5\u2c62").equals(gtt)) {
                            gtr = 84;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u8588\ufc3d\u76f0\ue886\u6358", 1161004542).equals(gtt)) {
                            gtr = 85;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\u598e\u2021\uaaf5\u348e\ubf50\u39ed\u83bc\u0a4b", 855595505).equals(gtt)) {
                            gtr = 86;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\ub91b\uc0be\u4a7b", -153699975).equals(gtt)) {
                            gtr = 87;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u3a34\u439f\uc951", 2084374824, -1137888404).equals(gtt)) {
                            gtr = 88;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\uf782\u8e3f\u04f0\u9a9f\u1140\u97e0\u2dae\ua455\u3a1a", 344586216).equals(gtt)) {
                            gtr = 89;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u8605\uffbe\u756e\ueb07\u60cb\ue679\u5c2a\ud5df", -1775538895, -576066726).equals(gtt)) {
                            gtr = 90;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.c(2115524771, "\u58ca\u2170\uabb1\u35da\ube0f\u38b5\u82f1").equals(gtt)) {
                            gtr = 93;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.b("\ud776\uaec5\u241b\uba7b", -949561569).equals(gtt)) {
                            gtr = 94;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && a.d("\u4758\u3ee6\ub42e\u2a5e\ua18e\u2723\u9d6d\u148d", 1481178597, -898188589).equals(gtt)) {
                            gtr = 91;
                            gts = 0;
                            break;
                        }
                        if (gts <= 100) break;
                        Field field = hlc.class.getDeclaredField(a.b("\ue0ec\u9948\u1398\u8dc0\u0639\u8094", -1792679778));
                        field.setAccessible(true);
                        field.set(null, a.b("\u0ecc\u7751\ufd80\u63fe\ue82a\u6e8e", 1997082249));
                        gtq.gvn();
                        minecraftClient.method_1507((Screen)new hlc());
                        gtq.gwo();
                        break;
                    }
                    gts = 0;
                    break;
                }
                case 3: {
                    gtq.gux(minecraftClient);
                    break;
                }
                case 4: {
                    gtq.gvb(minecraftClient);
                    break;
                }
                case 5: {
                    gtq.gvp(minecraftClient);
                    break;
                }
                case 6: {
                    gtq.gvq(minecraftClient);
                    break;
                }
                case 7: {
                    gtq.gvr(minecraftClient);
                    break;
                }
                case 8: {
                    gtq.gvw(minecraftClient);
                    break;
                }
                case 9: {
                    gtq.gvc(minecraftClient);
                    break;
                }
                case 10: {
                    gtq.gwe(minecraftClient);
                    break;
                }
                case 11: {
                    gtq.gvx(minecraftClient);
                    break;
                }
                case 12: {
                    gtq.gvy(minecraftClient);
                    gtq.gwa(minecraftClient);
                    break;
                }
                case 13: {
                    if (!flm.crit(minecraftClient)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 40: {
                    gtq.gwb(minecraftClient);
                    gtq.gwa(minecraftClient);
                    break;
                }
                case 41: {
                    gtq.gwc(minecraftClient);
                    gtq.gwa(minecraftClient);
                    break;
                }
                case 42: {
                    if (!fyl.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 44: {
                    if (!hbt.totem(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 45: {
                    if (!hbt.tool(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 46: {
                    if (!fwv.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 61: {
                    if (!grw.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 62: {
                    if (!fbc.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 60: {
                    if (!fif.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 47: {
                    if (!fug.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 48: {
                    if (!hgq.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 49: {
                    if (!gax.tick(minecraftClient)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 50: {
                    if (!fgv.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 52: {
                    if (!fjv.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 53: {
                    if (!hdt.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 54: {
                    if (!gxf.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 58: {
                    if (!gsz.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 81: {
                    if (!gyf.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 82: {
                    if (!hav.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 83: {
                    if (!gzt.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 84: {
                    if (!fxp.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 85: {
                    if (!hdj.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 86: {
                    if (!hge.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 87: {
                    if (!fbk.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 88: {
                    if (!gwv.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 89: {
                    if (!fkm.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 63: {
                    if (!fpo.tick(minecraftClient)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 64: {
                    if (!fdp.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 65: {
                    if (!fbw.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 66: {
                    if (!gnr.tick(minecraftClient)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 70: {
                    if (!grd.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 72: {
                    if (!gef.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 74: {
                    if (!fga.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 73: {
                    if (!fdx.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 56: {
                    if (!gkm.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 51: {
                    if (!heb.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 90: {
                    if (!fwd.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 91: {
                    if (!fvw.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 94: {
                    if (!ghf.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 93: {
                    if (!gml.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 43: {
                    if (!ghy.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 14: {
                    if (!flm.mace(minecraftClient)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 15: {
                    if (!hfi.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 16: {
                    gtq.guy(minecraftClient);
                    break;
                }
                case 17: {
                    if (!gpu.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
                case 18: {
                    if (!fvb.tick(minecraftClient, gts)) break;
                    minecraftClient.method_1592();
                    gtr = 99;
                    break;
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println(a.b("\ue2db\u9b7c\u11a6\u8fdd\u044c\u82a9\u38eb\ub10c\u2f54\ua5b1\u2224\ud852\u568d\ucf39\u4563\uc393\u7982\uf649", 711123642) + throwable);
            throwable.printStackTrace();
            minecraftClient.method_1592();
            gtr = 99;
        }
    }

    /*
     * Exception decompiling
     */
    private static void gux(MinecraftClient var0) throws Exception {
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

    private static void guy(MinecraftClient minecraftClient) throws Exception {
        Screen screen = minecraftClient.field_1755;
        switch (gts) {
            case 1: {
                wap.set(wam.RU);
                Field field = hlc.class.getDeclaredField(a.d("\ueb93\u9237\u18e7\u86bf\u0d46\u8beb", -2085129670, -1294362149));
                field.setAccessible(true);
                field.set(null, a.c(2130942973, "\u9bb8\ue225\u68f4\uf68a\u7d5e\ufbfa"));
                gtq.gvn();
                minecraftClient.method_1507((Screen)new hlc());
                break;
            }
            case 25: {
                gtq.gwp(minecraftClient, a.c(594996679, "\ueda5\u9419\u1ec5\u80bd\u0b20\u8d8c\u37de\ube33\u2022\uaa9f\u2d4e\ud730\u59e4\uc040"));
                break;
            }
            case 26: {
                gtq.gws(screen, 200.0f, 69.0f, 1);
                break;
            }
            case 40: {
                gtq.gwp(minecraftClient, a.d("\ufb45\u82f9\u0825\u965d\u1dc0\u9b6c\u213d\ua8d3\u36d4\ubc7e\u3ba5\uc1dd\u4f09\ud6b0\u5ce2\uda12", 2103439908, -1932392163));
                break;
            }
            case 41: {
                gtq.gws(screen, 400.0f, 23.0f, 0);
                gtq.gwr(screen, a.c(1374776945, "\u6a3f\u1382\u9955\u0348\u8cfb\u0a45\ub016\u39e4\ua7b8\u2d77"));
                break;
            }
            case 60: {
                gtq.gwp(minecraftClient, a.c(-817157862, "\u2963\u50df\uda03\u447b\ucfe6\u494a\uf31a\u7af5\ue4f4\u6e53\ue984\u13e6\u9d20\u049a\u8e8c\u083c\ub27e\u3db7\ua712\u2159\ua8af"));
                gtq.gws(screen, 400.0f, 23.0f, 1);
                gtq.gwr(screen, a.d("\ub437\ucd8e\u4759\udd34\u52f3\ud433\u6e60\ue7e8\u79ce\uf37c", 1060563247, -1919330014));
                break;
            }
            case 80: {
                gtq.gwp(minecraftClient, a.b("\uff50\u86ec\u0c30\u9248\u19d5\u9f79\u252e\uacc6\u32c7\ub860\u3fb7\uc5d5\u4b13\ud2a9\u58bf\ude17\u645e\ueb9c\u7120\uf76c\u7e84\u04d0\u8a7e", 1984102187));
                gtq.gws(screen, 400.0f, 23.0f, 1);
                gtq.gwr(screen, a.b("\ue8d0\u9160\u1bbe\u85c2\u0e1f\u88aa", 256634089));
                break;
            }
            case 100: {
                gtq.gwp(minecraftClient, a.c(-636291389, "\uf6be\u8f02\u05de\u9ba6\u103b\u9697\u2cc1\ua528\u3b29\ub18e\u3659\ucc3b\u42fd\udb47\u5151\ud7ff\u6db7"));
                screen.method_25419();
                break;
            }
            case 120: {
                minecraftClient.method_1507((Screen)new hlc());
                break;
            }
            case 140: {
                gtq.gwp(minecraftClient, a.c(-1609000816, "\u98ef\ue153\u6b8f\uf5f7\u7e6a\uf8c6\u4293\ucb79\u5578\udfdf\u5808\ua26a\u2cac\ub516\u3f00\ub9b7\u03f6\u8c32\u1685"));
                break;
            }
            case 141: {
                gtq.gws(screen, 400.0f, 23.0f, 1);
                gtq.gwq(screen, 256);
                Field field = hlc.class.getDeclaredField(a.b("\ueb04\u92a0\u1870\u8628\u0dd1\u8b7c", -312611978));
                field.setAccessible(true);
                field.set(null, a.c(1659057765, "\u3631\u4fb7\uc56f\u5b14\ud0c2\u5664"));
                minecraftClient.method_1507((Screen)new hlc());
                break;
            }
            case 160: {
                gtq.gwp(minecraftClient, a.c(-946742426, "\udb04\ua2b8\u2864\ub61c\u3d81\ubb2d\u0179\u8892\u1692\u9c34\u1bec\ue197\u6f41\uf6e7"));
                gtq.guz(minecraftClient, minecraftClient.field_1755, 26.0f, 362.0f);
                break;
            }
            case 180: {
                gtq.gwp(minecraftClient, a.c(-902835222, "\ud393\uaa2f\u20f3\ube8b\u3516\ub3ba\u09e1\u8005\u1e16\u94b0\u1374\ue910\u67d2\ufe70\u747c\uf2d0\u4886\uc75d\u5de6\udbb9\u5259"));
                break;
            }
            case 181: {
                gtq.guz(minecraftClient, minecraftClient.field_1755, 500.0f, 23.0f);
                minecraftClient.method_1507((Screen)new ida(minecraftClient.field_1755));
                break;
            }
            case 200: {
                gtq.gwp(minecraftClient, a.b("\udef7\ua74b\u2d97\ub3ef\u3872\ubede\u0484\u8d61\u137f\u99c3\u1e1f\ue467\u6aa2\uf307\u7952\uffa1\u45a6\uca2a\u5080\ud6db\u5f24\u257b\uabdf", 339009164));
                break;
            }
            case 201: {
                wap.set(wam.EN);
                minecraftClient.method_1507(null);
                Flow.getInstance().getModuleManager().getByName(a.d("\u8a88\uf31b\u79df\ue7af\u6c75\ueace\u508a\ud966\u473f\ucd8f\u4a41", -51837954, 1234602285)).setEnabled(true);
                ItemStack itemStack = new ItemStack((ItemConvertible)Items.field_8399);
                ItemStack itemStack2 = new ItemStack((ItemConvertible)Items.field_8107);
                itemStack.method_57379(DataComponentTypes.field_49649, (Object)ChargedProjectilesComponent.method_57441(List.of(itemStack2, itemStack2.method_7972(), itemStack2.method_7972())));
                minecraftClient.field_1724.method_31548().method_5447(minecraftClient.field_1724.method_31548().method_67532(), itemStack);
                minecraftClient.field_1724.method_36457(-12.0f);
                break;
            }
            case 220: {
                gtq.gwp(minecraftClient, a.d("\u655c\u1ce0\u963c\u0844\u83d9\u0574\ubf26\u36ca\ua8d5\u227c\ua5b6\u5fdf\ud115\u48be\uc2f6\u4400\ufe54", -717523428, -372042947));
                break;
            }
            case 225: {
                Flow.getInstance().getModuleManager().getByName(a.d("\u3f2f\u46bc\ucc78\u5208\ud9d2\u5f69\ue52d\u6cc1\uf298\u7828\uffe6", 692029487, -280643749)).setEnabled(false);
                hyz.save();
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void guz(MinecraftClient minecraftClient, Screen screen, float f, float f2) throws Exception {
        float f3 = gtq.gva(screen, a.c(-774990299, "\u964d\uefe1\u6529\ufb56\u708f\uf639\u4c5c"));
        float f4 = gtq.gva(screen, a.d("\u3872\u41de\ucb16\u5569\udeb0\u5806\ue262", -165481251, 1770179783));
        float f5 = gtq.gva(screen, a.c(-1285709508, "\ua14a\ud8eb\u523a\ucc46\u4798"));
        float f6 = gtq.gva(screen, a.c(-741277156, "\u0269\u7bc8\uf119\u6f65\ue4bb\u6236"));
        double d = minecraftClient.method_22683().method_4495();
        GLFW.glfwSetCursorPos((long)minecraftClient.method_22683().method_4490(), (double)((double)(f3 + f * f5) * d), (double)((double)(f4 + f2 * f6) * d));
    }

    private static float gva(Object object, String string) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    private static void gvb(MinecraftClient minecraftClient) throws Exception {
        rjy rjy2 = rjy.get();
        Screen screen = minecraftClient.field_1755;
        switch (gts) {
            case 1: {
                rjy2.setEnabled(true);
                PlayerEntity playerEntity = gtq.gvi(minecraftClient, a.b("\u731b\u0a99\u805d\u1e36\u95e6\u134e\ua90e\u20f4\ubeb6\u3400\ub3d1\u49b9", -1534037183), 4.6, -1.8, 10.0f);
                playerEntity.method_5673(EquipmentSlot.field_6169, gtq.gvj(Items.field_22027));
                playerEntity.method_5673(EquipmentSlot.field_6174, gtq.gvj(Items.field_22028));
                playerEntity.method_5673(EquipmentSlot.field_6172, gtq.gvj(Items.field_22029));
                playerEntity.method_5673(EquipmentSlot.field_6166, gtq.gvj(Items.field_22030));
                playerEntity.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_8367, 58));
                PlayerEntity playerEntity2 = gtq.gvi(minecraftClient, a.d("\u40e5\u3934\ub386\u2df7\ua620", 1679540086, -1012924476), 10.5, 4.6, 2.0f);
                playerEntity2.method_5673(EquipmentSlot.field_6169, gtq.gvl(Items.field_8743, 0.6f));
                playerEntity2.method_5673(EquipmentSlot.field_6174, gtq.gvl(Items.field_8523, 0.3f));
                playerEntity2.method_5673(EquipmentSlot.field_6173, gtq.gvl(Items.field_8802, 0.2f));
                playerEntity2.method_5673(EquipmentSlot.field_6171, new ItemStack((ItemConvertible)Items.field_8288));
                PlayerEntity playerEntity3 = gtq.gvi(minecraftClient, a.b("\u69d8\u1064\u9abd\u04ce\u8f13\u09a9\ub3f7\u3a0f\ua40f\u2ebe\ua96d\u531c\uddcb", -816092743), 22.0, -9.0, 17.0f);
                playerEntity3.method_5673(EquipmentSlot.field_6174, new ItemStack((ItemConvertible)Items.field_8058));
                playerEntity3.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_8102));
                PlayerEntity playerEntity4 = gtq.gvi(minecraftClient, a.c(1865238867, "\u491d\u3088\uba58\u243c\uaff3"), 7.0, 1.2, 20.0f);
                playerEntity4.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_22022));
                playerEntity4.method_6073(4.0f);
                Scoreboard scoreboard = minecraftClient.field_1687.method_8428();
                gtv = scoreboard.method_1171(a.c(-1714558707, "\ue962\u90d9\u1a09\u8460\u0ff2\u8905\u3347\ubaa0\u24f8"));
                gtv.method_1138((Text)Text.method_43470((String)a.d("\u1d2b\u6484\uee5e\u702a\ufbe0\u7d40\uc70b\u4e87", -238686938, 592244830)).method_27695(new Formatting[]{Formatting.field_1065, Formatting.field_1067}));
                gtv.method_1139((Text)Text.method_43470((String)a.c(-1172129434, "\ub942\uc074\u4a63\uf315")));
                scoreboard.method_1172(a.d("\ua6cf\udf4d\u5589\ucbe2\u4032\uc69a\u7cda\uf520\u6b62\ue1d4\u6605\u9c6d", 1280257182, 1359514123), gtv);
                hhf.add(a.d("\u749f\u0d0a\u87da\u19be\u9271", -2120045444, 1795676333));
                break;
            }
            case 40: {
                gtq.gwp(minecraftClient, a.c(-479424838, "\u8e98\uf729\u7de4\ue3d6\u680e\ueeb3\u54e8\udd08\u4342\uc9f5\u4e32\ub41d\u3a80\ua33a\u2964\uaf87\u15c8"));
                break;
            }
            case 41: {
                rjy2.background.set(a.b("\u9948\ue0dc\u6a17\uf462\u7fa9\uf915", -511403774));
                break;
            }
            case 55: {
                gtq.gwp(minecraftClient, a.c(90846558, "\u357f\u4cc9\uc603\u5831\ud3e9\u5554\uef0f\u66ef\uf8a5\u7212\uf5d5\u0ffa\u816c\u18d8\u9293\u1466\uae35\u21e9"));
                break;
            }
            case 56: {
                rjy2.background.set(a.b("\uaee7\ud76a\u5dba\uc3ce\u4814", 777039537));
                rjy2.health.set(a.c(1454506385, "\u01d7\u784b\uf283\u6cee"));
                rjy2.items.set(a.d("\u9407\ued95\u674b\uf923\u72e7", 1546488734, 1469063133));
                rjy2.distance.set(true);
                break;
            }
            case 70: {
                gtq.gwp(minecraftClient, a.b("\ub04e\uc9f9\u4332\udd00\u56d8\ud065\u6a3e\ue3de\u7d94\uf723\u70e4\u8acb\u0442\u9def\u17bf\u914b\u2b09", 365539436));
                break;
            }
            case 71: {
                rjy2.background.set(a.b("\ubdf8\uc468\u4eba\ud0c0", 731758002));
                rjy2.tint.set(a.d("\u6a9d\u1309\u99c9\u07a1", 1779921938, -1473700145));
                rjy2.items.set(a.b("\ub1b9\uc82f\u42fe\udc8a\u575a\ud1e0", -824331786));
                rjy2.health.set(a.b("\u8177\uf8f7\u7239\uec44", 1094418727));
                rjy2.distance.set(false);
                break;
            }
            case 85: {
                gtq.gwp(minecraftClient, a.d("\u259d\u5c29\ud6e1\u48d3\uc30b\u45b6\uffed\u760d\ue847\u62f0\ue537\u1f18\u918c\u083c\u826e\u0494", -1755359532, 821654378));
                break;
            }
            case 86: {
                rjy2.background.set(a.d("\ua256\udbcc\u5112\ucf71\u44a6", 985360281, 1170261389));
                PlayerEntity playerEntity = gtu.get(1);
                Vec3d vec3d = playerEntity.method_33571().method_1020(minecraftClient.field_1724.method_33571());
                minecraftClient.field_1724.method_36456((float)Math.toDegrees(Math.atan2(-vec3d.field_1352, vec3d.field_1350)));
                minecraftClient.field_1724.method_36457((float)(-Math.toDegrees(Math.atan2(vec3d.field_1351, Math.hypot(vec3d.field_1352, vec3d.field_1350)))));
                hhf.toggleAimed();
                break;
            }
            case 94: {
                gtq.gwp(minecraftClient, a.b("\u50f1\u2944\ua38d\u3db7\ub674\u30de\u8a81\u037b\u9d2e\u17d6\u9043\u6a3c\ue4f7", 232542415));
                System.out.println(a.d("\u104c\u69eb\ue331\u7d4a\uf6db\u703e\uca7c\u439b\uddc3\u5726\ud0b3\u2ad6\ua41a\u3da7\ub7ff\u3104\u8b5c\u04de", -2047181930, -1893241925) + hhf.all().size() + a.d("\ua6ff\udf46\u55ef\ucbfe\u4048\uc6f9\u7caa\uf528\u6b31\ue194\u665c\u9c21\u12fd\u8b46\u014b\u87a0", 795402739, 1390167868) + hhf.isFriend(a.d("\u6626\u1fd7\u9545\u0b34\u80e3", -293373105, 1602755870)) + a.c(550474009, "\u9131"));
                break;
            }
            case 95: {
                gtq.gvm(minecraftClient, a.d("\ua643\udfc6\u550e\ucb73\u40af\uc614\u7c50", -1117474187, 1349522551));
                break;
            }
            case 120: {
                gtq.gwp(minecraftClient, a.b("\uc361\ubadb\u301d\uae27\u25e4\ua34e\u1911\u90eb\u0ebe\u8418\u0395\uf9bd\u777f\ueecd", 199344988));
                break;
            }
            case 121: {
                gtq.gvm(minecraftClient, a.b("\u045c\u7dda\uf702\u6979\ue2af\u6409", -858258424));
                break;
            }
            case 145: {
                gtq.gwp(minecraftClient, a.c(1233679081, "\u72ca\u0b71\u81b6\u1f84\u945c\u12e1\ua8ba\u215a\ubf10\u35a7\ub260\u484f\uc6d6\u5f65\ud525\u53c2"));
                break;
            }
            case 146: {
                if (screen != null) {
                    gtq.gwq(screen, 256);
                }
                rjy2.setEnabled(false);
                break;
            }
            case 160: {
                gtq.gwp(minecraftClient, a.b("\u9bec\ue259\u6897\uf6bd\u7d7d\ufbc3\u4197\uc863\u563c\udc80\u5b1f\ua137\u2ff5\ub642\u3c05", -2012111913));
                break;
            }
            case 161: {
                for (PlayerEntity playerEntity : gtu) {
                    minecraftClient.field_1687.method_2945(playerEntity.method_5628(), Entity.RemovalReason.field_26999);
                }
                gtu.clear();
                minecraftClient.field_1687.method_8428().method_1191(gtv);
                hhf.remove(a.d("\u42e9\u3b7c\ub1ac\u2fc8\ua407", -427658780, 178074435));
                hhf.remove(a.c(1506934745, "\uff8e\u865f\u0ced\u929c\u194b"));
                hyz.save();
                minecraftClient.method_1592();
                break;
            }
        }
    }

    private static void gvc(MinecraftClient minecraftClient) throws Exception {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        ruv ruv2 = (ruv)kfx2.getByName(a.c(1052493468, "\uc6c1\ubf45\u3585\uabe1\u2034\ua694\u1cf6\u9511\u0b4d"));
        switch (gts) {
            case 1: {
                ruv2.setEnabled(true);
                kfx2.getByName(a.c(-1651905955, "\uea1d\u938d\u1943\u8705\u0cfe\u8a4c\u301c\ub9f0")).setEnabled(true);
                kfx2.getByName(a.d("\u92fc\ueb79\u61ab\uffc1\u742a\uf2b8\u48e9\uc103\u5f5b\ud5f0", -61033399, -1958140162)).setEnabled(true);
                minecraftClient.field_1724.method_36457(8.0f);
                guc = gtq.gvk(minecraftClient);
                ruv.onAttack((Entity)guc);
                minecraftClient.field_1724.method_5673(EquipmentSlot.field_6169, gtq.gvl(Items.field_22027, 0.05f));
                minecraftClient.field_1724.method_5673(EquipmentSlot.field_6174, gtq.gvl(Items.field_22028, 0.4f));
                minecraftClient.field_1724.method_5673(EquipmentSlot.field_6172, gtq.gvl(Items.field_8348, 0.7f));
                minecraftClient.field_1724.method_5673(EquipmentSlot.field_6166, gtq.gvl(Items.field_8285, 0.93f));
                ItemStack itemStack = new ItemStack((ItemConvertible)Items.field_8367, 12);
                itemStack.method_57379(DataComponentTypes.field_49631, (Object)Text.method_43470((String)a.b("\ude10\u80a7\u0a11\u944b\u1f91\u992b\u2371\uaa8f\u34ca\ube6a\u39b8\uc38d\u4d3d\ud4a4\u5ef4\ud80d\u6243\ued99\u7764\uf154\u7892\u02c3\u8c6c\u17b4\u918e\u1b10\ua2aa\u2cbd\ub61e\u3053\ubbed\u4579\ucf57\u5689\ud0d7\u5a6c\ue5b7\u6fcd\ue904\u70e1\ufad5\u8406\u0e52\u89ea\u1329\u9d0b\u24a3\uae05\u2863\ub3b0\u3dc1\uc71b\u4ea6\uc8f2\u5212\udc48\u67d3\ue17f\u4c0a", 2056780045)));
                minecraftClient.field_1724.method_31548().method_5447(2, itemStack);
                minecraftClient.field_1724.method_7357().method_62835(itemStack, 600);
                minecraftClient.field_1724.method_31548().method_5447(1, new ItemStack((ItemConvertible)Items.field_8634, 16));
                minecraftClient.field_1724.method_7357().method_62835(new ItemStack((ItemConvertible)Items.field_8634), 300);
                izx.TARGET.enabled.set(false);
                break;
            }
            case 14: {
                izx.cpuMicros();
                ruv.cpuMicros();
                break;
            }
            case 24: {
                gtq.gwp(minecraftClient, a.c(-1066049918, "\u5eba\u270e\uadc0\u33f9\ub838\u3e8a\u8484\u0d3f\u936f\u19d9\u9e16\u6460\ueab0"));
                System.out.println(a.c(-1658058012, "\u0a8e\u7329\uf9f3\u6788\uec19\u6afc\ud0be\u5959\uc701\u4de4\uca64\u3012\ubed4\u2761\uad37\u2bdb\u91cd\u1e74\u84da\u029a\u8b09\uf11b\u7fbb\ue46f\u6245") + String.format(a.b("\ua37f\udac5\u5009\uce2f", 2127209310), izx.cpuMicros()) + a.c(863999220, "\u94db\ued3f\u67ea\uf9c7\u7259\uf4fc\u4ebc\uc741\u5916\ud3ee\u5431\uae25\u20e4\ub956\u3375") + String.format(a.c(282202103, "\u0fd6\u766c\ufca0\u6286"), ruv.cpuMicros()) + a.d("\u16fa\u6f1e\ue5cb\u7be6\uf078\u76dd\ucc9d\u4560\udb37", 1111642054, -1523427051));
                break;
            }
            case 25: {
                ruv2.mode.set(a.b("\u763b\u0fa9\u856b\u1b09\u90c7\u1671\uac2b\u25cc", 2033743456));
                break;
            }
            case 40: {
                gtq.gwp(minecraftClient, a.d("\u0011\u79a4\uf36b\u6d52\ue693\u6021\uda2f\u5380\ucddc\u477c\uc0bc\u3ad4\ub404\u2dbc\ua7f9", -1450575155, -1961624858));
                break;
            }
            case 41: {
                ruv2.mode.set(a.b("\u53ba\u2a2e\ua0f3\u3e8d\ub546\u33ed\u89b9O\u9e19", -907979777));
                break;
            }
            case 50: {
                gtq.gvf(guc);
                break;
            }
            case 52: {
                gtq.gwp(minecraftClient, a.b("\ue3fe\u9a48\u1084\u8ebd\u057c\u83ce\u39c0\ub070\u2e2a\ua495\u2349\ud924\u57e9\uce5f\u440b\uc2f3\u78f6\uf762\u6dd0\ueb9c", -644750369));
                break;
            }
            case 60: {
                gtq.gwp(minecraftClient, a.c(1718172011, "\u394f\u40f9\uca7a\u5444\udfdb\u597c\ue32c\u6a80\uf49e\u7e2a\uf9f7\u0389\u8d42\u14e9\u9ebd\u184b\ua20d"));
                break;
            }
            case 61: {
                ruv2.mode.set(a.b("\uc26e\ubbe4\u3130\uaf48", 650232376));
                break;
            }
            case 75: {
                gtq.gwp(minecraftClient, a.d("\u4591\u3c26\ub6eb\u28d2\ua313\u25a1\u9faf\u1601\u8845\u02f3\u8529", 1582961642, 913593925));
                break;
            }
            case 76: {
                ruv2.mode.set(a.c(-341037562, "\u2e43\u57de\udd0f\u4376\uc8b0\u4e06"));
                break;
            }
            case 90: {
                gtq.gwp(minecraftClient, a.d("\ubc3f\uc58f\u4f45\ud17c\u5abd\udc0f\u6601\uefbe\u71ed\ufb5e\u7c85\u86e5\u0835", -892716194, -1895987367));
                break;
            }
            case 91: {
                ruv2.mode.set(a.c(600957745, "\ue370\u9aee\u103a\u8e57\u0587\u8331"));
                break;
            }
            case 105: {
                gtq.gwp(minecraftClient, a.b("\u51ee\u285f\ua294\u3cad\ub76c\u31de\u8bd0\u026b\u9c3b\u168d\u9142\u6b34\ue5e4\u7c0b\uf614\u70e3\ucaaa\u4573\udfc7", -1860218424));
                break;
            }
            case 106: {
                ruv2.mode.set(a.c(-1653143758, "\u0773\u7eed\uf439\u6a54\ue184\u6732"));
                break;
            }
            case 111: {
                gtq.gvf(guc);
                break;
            }
            case 113: {
                gtq.gwp(minecraftClient, a.b("\u0651\u7fe3\uf52b\u6b12\ue0d3\u6661\udc6f\u55d4\ucb84\u4132\uc6fd\u3c8b\ub25b\u2bb4\ua1a2\u2752\u9d00\u1288\u8875\u0e28\u87dc\ufd8e\u7320", -1711995277));
                break;
            }
            case 114: {
                izx.TARGET.enabled.set(true);
                break;
            }
            case 116: {
                minecraftClient.method_1507((Screen)new ChatScreen("", false));
                break;
            }
            case 125: {
                ixu ixu2 = izx.ARMOR;
                float f = gtq.gvg(ixu2, a.d("\u942e", 1832803711, -8730328));
                float f2 = gtq.gvg(ixu2, a.d("\u6d50", -666082674, 632885158));
                float f3 = gtq.gvg(ixu2, a.d("\ub081", -1533002251, -957313790));
                float f4 = gtq.gvg(ixu2, a.b("\u9fbd", 895459284));
                izx.mouseClicked((double)f + (double)f3 * 0.9, (double)f2 + (double)f4 * 0.2, 1);
                izx.mouseDragged((double)f + (double)f3 * 1.08, (double)f2 - (double)f4 * 0.1);
                break;
            }
            case 135: {
                gtq.gwp(minecraftClient, a.c(-1861394239, "\u60e3\u1950\u9399\u0da4\u8660\u00ce\uba9f\u3373\uad73\u279d\ua059\u5a3e\ud4f3\u4d51\uc71d\u41a4\ufbaf\u7479\uee89\u6896\ue16a\u9b32\u1594"));
                break;
            }
            case 136: {
                izx.mouseReleased();
                minecraftClient.method_1507(null);
                break;
            }
            case 138: {
                minecraftClient.field_1690.field_1894.method_23481(true);
                break;
            }
            case 144: {
                System.out.println(a.c(1543196175, "\u4e54\u37f3\ubd29\u2352\ua8c3\u2e26\u9464\u1d83\u83db\u093e\u8e8c\u74c9\ufa1f\u63b5\ue9da\u6f08\ud545\u5a8f\uc03b\u4670\ucfd3\ub5d5\u3b70\ua0ac\u26d4\uac07\u15b3\u9beb\u0141\u870a\u0cea\uf238\u7875\ue19f\u67cb\ued60\u52aa\ud8dc\u5e06\uc7f0") + minecraftClient.field_1724.method_5624());
                minecraftClient.field_1690.field_1894.method_23481(false);
                break;
            }
            case 150: {
                gtq.gwp(minecraftClient, a.c(-59673738, "\u7355\u0ae9\u802f\u1e1b\u95d1\u1371\ua96b\u20d6\ube9a\u3434\ub3e5\u4989\uc701\u5efe\ud4a1\u5250\ue81c\u67c5\ufd7d\u7b34\uf2da\u8896"));
                System.out.println(a.c(-1098448287, "\u0200\u7ba7\uf17d\u6f06\ue497\u6272\ud830\u51d7\ucf8f\u456a\uc2d1\u38bd\ub67b\u2fae\ua5be\u235c\u9916\u1692") + String.format(a.c(1681791731, "\u1ad2\u6368\ue9a4\u7782"), izx.cpuMicros()) + a.b("\u8711\ufef5\u7420\uea0d\u6193\ue736\u5d76\ud48b\u4adc", -1141930184));
                System.out.println(a.c(-1093256841, "\u3910\u40b7\uca6d\u5416\udf87\u5962\ue320\u6ac7\uf49f\u7e7a\uf9fa\u0388\u8d5d\u14f7\u9ea3\u1848\ua21a\u2dcc\ub776\u3160") + minecraftClient.field_1724.method_5624());
                break;
            }
            case 151: {
                gtq.gvh(izx.ARMOR);
                gtq.gvd();
                gtq.gve(minecraftClient, ruv2, 0);
                break;
            }
            case 995: {
                izx.ENABLED.set(true);
                izx.BACKGROUND.set(a.b("\u9a45\ue3df\u6901\uf762\u7cb5", -1759405561));
                rjy.get().setEnabled(false);
                ruv2.setEnabled(true);
                minecraftClient.field_1687.method_2945(guc.method_5628(), Entity.RemovalReason.field_26999);
                gtq.gvm(minecraftClient, a.c(-263356906, "\u7e42\u07c4\u8d1c\u1367\u98b1\u1e17"));
                break;
            }
            case 1017: {
                gtq.gwp(minecraftClient, a.c(-1182379975, "\u5001\u29bc\ua37b\u3d55\ub695\u302f\u8a76\u0386\u9dce\u1720\u90aa\u6ace\ue41a"));
                break;
            }
            case 1018: {
                ruv2.setEnabled(false);
                kfx2.getByName(a.c(1457476812, "\u548c\u2d1c\ua7d2\u3994\ub26f\u34dd\u8e8d\u0761")).setEnabled(false);
                kfx2.getByName(a.b("\u5729\u2eac\ua47e\u3a14\ub1ff\u376d\u8d3c\u04d6\u9a8e\u1025", 212621154)).setEnabled(false);
                hyz.save();
                minecraftClient.method_1592();
                break;
            }
            default: {
                int n = gts - 151;
                if (gts <= 151 || gts >= 151 + 70 * gtx.length) break;
                int n2 = n / 70;
                int n3 = n % 70;
                if (gty[n2] >= 8) {
                    minecraftClient.field_1724.method_36456(minecraftClient.field_1724.method_36454() + 3.0f);
                }
                if (n3 == 0) {
                    gtq.gve(minecraftClient, ruv2, gty[n2]);
                    break;
                }
                if (n3 == 20) {
                    gtz = 0L;
                    gua = System.nanoTime();
                    break;
                }
                if (n3 != 69) break;
                double d = (double)(System.nanoTime() - gua) / 1.0E9;
                double d2 = d * 1000.0 / (double)Math.max(1L, gtz);
                System.out.println(a.b("\u43a8\u3a0f\ub0d5\u2eae\ua53f\u23da\u9998\u107f\u8e27\u04c2\u8352\u792f\uf7e4\u6e52\ue455", -782482476) + gtx[n2] + a.c(-230128457, "\u848f\ufd24") + String.format(a.b("\u4a1b\u33a1\ub96e\u274b", -662746566), d2) + a.d("\u67eb\u1e17\u94da\u0af7\u8169\u07cc\ubd8c\u3471\uaa26\u20d2\ua709", -383642705, 1816753263) + Math.round((double)gtz / d) + a.d("\u0627\u7fd0\uf515\u6b67\ue0ea", -1522604249, -157097691));
            }
        }
    }

    private static void gvd() {
        if (!gub) {
            gub = true;
            HudRenderCallback.EVENT.register((drawContext, renderTickCounter) -> ++gtz);
        }
    }

    private static void gve(MinecraftClient minecraftClient, ruv ruv2, int n) {
        if (minecraftClient.field_1755 != null) {
            minecraftClient.method_1507(null);
        }
        boolean bl = n == 7 || n == 8;
        izx.ENABLED.set(n >= 1 && n <= 4 || bl);
        izx.BACKGROUND.set(n == 4 ? a.b("\u15ca\u6c47\ue697\u78e3\uf339", 1700795804) : a.b("\u97e1\uee7b\u64a5\ufac6\u7111", -368470109));
        hyv.STYLE.set(n == 2 ? a.c(-618272392, "\ue939\u90bc\u1a72\u841f\u0fcf\u896f\u333d") : a.c(-1861300990, "\ucd48\ub4dc\u3e17\ua062\u2ba9\uad15"));
        hyv.FROST.set(n == 3 ? 0.0 : 2.0);
        rjy.get().setEnabled(n == 5 || bl);
        ruv2.setEnabled(n == 6 || bl);
    }

    private static void gvf(PlayerEntity playerEntity) {
        playerEntity.method_6033(Math.max(2.0f, playerEntity.method_6032() - 5.0f));
        playerEntity.field_6235 = 10;
        playerEntity.field_6254 = 10;
    }

    private static float gvg(jcs jcs2, String string) throws Exception {
        Field field = jcs.class.getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(jcs2);
    }

    private static void gvh(jcs jcs2) throws Exception {
        Field field = jcs.class.getDeclaredField(a.b("\u7829\u0182\u8b42\u152c", 2024503390));
        field.setAccessible(true);
        field.setFloat(jcs2, 1.0f);
    }

    private static PlayerEntity gvi(MinecraftClient minecraftClient, String string, double d, double d2, float f) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.field_1724.method_5828(1.0f).method_18805(1.0, 0.0, 1.0).method_1029();
        Vec3d vec3d2 = new Vec3d(-vec3d.field_1350, 0.0, vec3d.field_1352);
        Vec3d vec3d3 = minecraftClient.field_1724.method_73189().method_1019(vec3d.method_1021(d)).method_1019(vec3d2.method_1021(d2));
        otherClientPlayerEntity.method_5808(vec3d3.field_1352, minecraftClient.field_1724.method_23318(), vec3d3.field_1350, minecraftClient.field_1724.method_36454() + 180.0f, 0.0f);
        otherClientPlayerEntity.method_6033(f);
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        gtu.add((PlayerEntity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static ItemStack gvj(Item item) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        itemStack.method_57379(DataComponentTypes.field_49641, (Object)true);
        return itemStack;
    }

    private static PlayerEntity gvk(MinecraftClient minecraftClient) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), a.c(-36600509, "\u8502\ufc85\u7641\ue834\u63ef")));
        Vec3d vec3d = minecraftClient.field_1724.method_5828(1.0f).method_18805(1.0, 0.0, 1.0).method_1029();
        Vec3d vec3d2 = minecraftClient.field_1724.method_73189().method_1019(vec3d.method_1021(3.2));
        otherClientPlayerEntity.method_5808(vec3d2.field_1352, minecraftClient.field_1724.method_23318(), vec3d2.field_1350, minecraftClient.field_1724.method_36454() + 180.0f, 0.0f);
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6169, gtq.gvl(Items.field_22027, 0.1f));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6174, gtq.gvl(Items.field_8058, 0.45f));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6172, gtq.gvl(Items.field_8348, 0.7f));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6166, gtq.gvl(Items.field_8660, 0.9f));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6173, gtq.gvl(Items.field_22022, 0.3f));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6171, new ItemStack((ItemConvertible)Items.field_8288));
        otherClientPlayerEntity.method_6073(4.0f);
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static ItemStack gvl(Item item, float f) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        itemStack.method_7974(Math.round((float)itemStack.method_7936() * f));
        return itemStack;
    }

    private static void gvm(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.c(1747766233, "\ucbab\ub20f\u38df\ua687\u2d7e\uabd3"));
        field.setAccessible(true);
        field.set(null, string);
        Field field2 = hlc.class.getDeclaredField(a.c(-1450134053, "\ub58f\ucc2e\u46ec\ud880\u5354\ud5e5\u6fa9"));
        field2.setAccessible(true);
        ((Map)field2.get(null)).clear();
        gtq.gvn();
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void gvn() throws Exception {
        for (String string : new String[]{a.d("\u9872\ue1dd\u6b09\uf572\u7eae\uf807\u427b", 283812617, -34325749), a.d("\ub773\ucedc\u4408\uda73\u51af\ud706\u6d7b", 1029626087, 1635282916)}) {
            Field field = hlc.class.getDeclaredField(string);
            field.setAccessible(true);
            field.setFloat(null, Float.NaN);
        }
    }

    private static float gvo(Object object, String string) throws Exception {
        Field field = jcs.class.getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    private static void gvp(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(230570316, "\u3913\u4094\uca50\u5425\udfe1\u5947\ue32e\u6af2\uf4a4\u7e09\uf9cf\u03a9"));
        vlq vlq2 = null;
        vkl vkl2 = null;
        vkl vkl3 = null;
        for (vmo vmo2 : kfe2.getSettings()) {
            vkl vkl4;
            vkl vkl5;
            vlq vlq3;
            if (vmo2 instanceof vlq && (vlq3 = (vlq)vmo2).getName().equals(a.d("\ue882\u9114\u1bb7\u85c9\u0e65\u8cc0\u3281\ubb77\u255f\uafec\u284f", -1153168875, -423172469))) {
                vlq2 = vlq3;
                continue;
            }
            if (vmo2 instanceof vkl && (vkl5 = (vkl)vmo2).getName().equals(a.b("\u7121\u08c2\u8269\u1c13\u97c6\u1175\uaf36\u22d8\ubc86\u3648\ub1e1\u4b9e\uc15c\u5cfa\ud6ae\u502f\uea6f\u65c5\uff72", -646154973))) {
                vkl2 = vkl5;
                continue;
            }
            if (!(vmo2 instanceof vkl) || !(vkl4 = (vkl)vmo2).getName().equals(a.b("\uddce\ua420\u2ef8\ub0f4\u3b2b\ubd9e\u03d7\u8e34\u1479\u9aaa\u1d0b\ue773\u69a1\uf014\u7a42\ufcbd", 858905025))) continue;
            vkl3 = vkl4;
        }
        int n = 74;
        if (gts > 1) {
            guh = Math.max(guh, clientPlayerEntity.method_23318());
            if (Float.isNaN(gug) && !oxw.busy()) {
                gug = clientPlayerEntity.method_36455();
            }
        }
        switch (gts) {
            case 1: {
                kfe2.setEnabled(true);
                vlq2.set(n);
                gtq.gwi(minecraftClient, a.c(-55187667, "\ue75b\u9eec\u1433\u8a4a\u0195\u8726\u3d7e\ub48e\u2a94\ua076\u27a3\uddd5\u5306\ucaa8\u40e4\uc602\u7c40"));
                gtq.gwi(minecraftClient, a.b("\ua103\ud8b1\u5262\ucc10\u47c1\uc167\u7b60\uf2d6\u6c87\ue629\u61e9\u9bdd\u156a\u8ce8\u06e8\u804b\u3a13\ub5d4\u2f7d\ua936\u20c6\u5a82\ud43e\u4fe2\uc99b\u430f\ufaaa\u74fd\uee0a\u684b\ue3ec\u1d29\u9732\u0ec5\u8891\u0230", -869555902));
                break;
            }
            case 5: {
                gtq.gwj(minecraftClient, a.b("\ua973\ud0c5\u5a0e\uc46c\u4fb0\uc91b\u7353\ufabf\u64eb\uee0d\u69c1\u93b0", 1227598102), a.b("\uc539\ubc8f\u3644\ua826\u23fa\ua551\u1f19\u96f5\u08a1\u8247\u058f", 1137034587), 0);
                break;
            }
            case 40: {
                gtq.gwk(minecraftClient, kfe2, n, 10.0f);
                break;
            }
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: {
                gtq.gwl(minecraftClient, a.d("\uebd0", -622550451, 836061661));
                break;
            }
            case 90: {
                gtq.gwm(minecraftClient, a.b("\uf8bc", -1658062596), Items.field_49814, 20, 7, 0, 9.0, 99.0);
                break;
            }
            case 100: {
                gtq.gwj(minecraftClient, a.b("\uff37\u8681\u0c49\u922e\u19fa\u9f58\u2557\uacbb", 1824587607), a.b("\u9c68\ue5de\u6f16\uf171\u7aa5\ufc07\u4608\ucfe2", -2031838200), 0);
                break;
            }
            case 140: {
                gtq.gwk(minecraftClient, kfe2, n, -20.0f);
                break;
            }
            case 141: 
            case 142: 
            case 143: 
            case 144: 
            case 145: {
                gtq.gwl(minecraftClient, a.b("\u000b", -2083061688));
                break;
            }
            case 190: {
                gtq.gwm(minecraftClient, a.d("\ubb5a", -822917511, 1656421728), Items.field_49814, 3, 7, 5, 9.0, 99.0);
                break;
            }
            case 200: {
                vkl2.set(false);
                gtq.gwj(minecraftClient, a.b("\u1c37\u6581\uef4a\u7128\ufaf4\u7c5f\uc617\u4ffb\ud1af\u5b49\udc85\u26f4", 412359762), a.d("\u0f6a\u76dc\ufc17\u6275\ue9a9\u6f02\ud54a\u5ca6\uc2f2\u4814\ucfdc", -1786010782, 1053076586), 0);
                break;
            }
            case 240: {
                gtq.gwk(minecraftClient, kfe2, n, 30.0f);
                break;
            }
            case 241: 
            case 242: 
            case 243: 
            case 244: 
            case 245: {
                gtq.gwl(minecraftClient, a.b("\u8fbf", 1350340605));
                break;
            }
            case 290: {
                gtq.gwm(minecraftClient, a.d("\uf1c6", 83616783, 1989350795), Items.field_8802, 20, 7, 0, 9.0, 99.0);
                break;
            }
            case 300: {
                vkl2.set(true);
                vkl3.set(false);
                gtq.gwj(minecraftClient, a.c(-632894223, "\ucc91\ub527\u3fef\ua188\u2a5c\uacfe\u16f1\u9f1d"), a.c(-1194519813, "\u129b\u6b2d\ue1e5\u7f82\uf456\u72f4\uc8fb\u4111"), 0);
                break;
            }
            case 340: {
                gtq.gwk(minecraftClient, kfe2, n, 0.0f);
                break;
            }
            case 341: 
            case 342: 
            case 343: 
            case 344: 
            case 345: {
                gtq.gwl(minecraftClient, a.d("\uefdb", 1629311860, 1996209386));
                break;
            }
            case 390: {
                gtq.gwm(minecraftClient, a.c(127299328, "\u6f45"), Items.field_49814, 3, 7, 5, 5.0, 8.0);
                vkl3.set(true);
                System.out.println(a.b("\u504e\u29e1\ua335\u3d4e\ub6dd\u3038\u8a7a\u039d\u9dc5\u1720", -807776205) + (guj == 0 ? a.b("\u9808\ue1a8\u6b69\uf518", -1615292324) : a.b("\u93b7\uea01\u60da\ufeae\u7515\uf3ac", 185308151) + guj + a.d("\ub040", 315447173, 237168621)));
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvq(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (gts == 1) {
            gtq.gwi(minecraftClient, a.d("\u16ff\u6f48\ue597\u7bee\uf031\u7682\uccda\u452a\udb30\u51d2\ud607\u2c71\ua2a2\u3b0c\ub140\u37a6\u8de4", 1033529558, -1361674657));
            gtq.gwi(minecraftClient, a.d("\u1f02\u66b0\uec63\u7211\uf9c0\u7f66\uc561\u4cd7\ud286\u5828\udfe8\u25dc\uab6b\u32e9\ub8e9\u3e4a\u8412\u0bd5\u917c\u1737\u9ec7\ue483\u6a3f\uf1e3\u779a\ufd0e\u44a4\ucafc\u500b\ud64a\u5ded\ua328\u2933\ub0c4\u3690\ubc31", -1482692515, 345372446));
            gtq.gwi(minecraftClient, a.c(-490973300, "\u57e7\u2e59\ua483\u3af6\ub132\u37d1\u8de2\u0420"));
            gtq.gwi(minecraftClient, a.d("\u97f1\uee5d\u649f\ufae6\u717c\uf79f\u4ddb\uc43f\u5a7c\ud0c0\u5711\uad66\u23f4\uba00\u3058\ub6b3\u0ce1\u832d\u1993\u9f9b\u160c\u6c6e\ue28e\u7917\uff6f\u75a5\ucc00\u4252\ud8b6\u5ebb\ud516\u2bd7\ua1cf\u3820\ube6e\u34c3\u8b5c\u0160\u87b7\u1e01\u9455\ueaa2\u60e0\ue742\u7d92\uf3f1\u4a6c\uc090\u46c1\udd17\u536e\ua984\u200f\ua655\u3caf\ub2ed\u0947\u8f94\u05a2\u9c65\u12d0", 1545912420, -62302271));
            clientPlayerEntity.method_31548().method_61496(0);
            return;
        }
        int n = (gts - 40) / 70;
        if (gts < 40) {
            return;
        }
        if (n >= guk.length) {
            System.out.println(a.b("\u9347\ueae8\u603c\ufe47\u759e\uf330\u497b\uc097\u5e98\ud46d\u53b5\ua9c5\u2719", 163353405));
            minecraftClient.method_1592();
            gtr = 99;
            return;
        }
        int n2 = guk[n];
        boolean bl = n2 != Integer.MIN_VALUE;
        int n3 = bl ? n2 : 0;
        int n4 = 40 + n * 70 + 20;
        int n5 = gts - n4;
        clientPlayerEntity.method_36457(90.0f);
        if (n5 == -12) {
            guh = guf = clientPlayerEntity.method_23318();
        }
        if (n5 > -12) {
            guh = Math.max(guh, clientPlayerEntity.method_23318());
        }
        if (bl && n5 == -1) {
            minecraftClient.field_1690.field_1903.method_23481(true);
        } else if (bl && n5 == 0) {
            minecraftClient.field_1690.field_1903.method_23481(false);
        }
        if (n5 == n3 - 1) {
            KeyBinding.method_1420((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.field_1690.field_1904));
        }
        if (n5 >= Math.min(-1, n3 - 1) && n5 <= Math.max(n3, 0) + 8) {
            System.out.println(a.b("\u4896\u3139\ubbed\u2596\uae4f\u28e1\u92aa\u1b46\u8549", -9484056) + (bl ? a.d("\ubd3d\uc4de", 1460224770, -1700921774) + n3 : a.c(714056262, "\ua230\udb86\u5140\ucf3e\u44e3")) + a.c(1579513375, "\u763a\u0fd9\u851d\u1b65\u90e3") + n5 + a.d("\u67d9\u1e31\u94a6", 851896837, -415265281) + gtq.gwn(clientPlayerEntity.method_23318() - guf) + a.d("\ubaad\uc34a\u4996\ud7a3", 1035458850, -1793039445) + gtq.gwn(clientPlayerEntity.method_18798().field_1351) + a.b("\u108e\u6978\ue3be\u7dd2\uf61f\u70b5\ucaec\u4344", 27660454) + clientPlayerEntity.method_24828());
        }
        if (n5 == 45) {
            System.out.println(a.b("\ucf5a\ub6f5\u3c21\ua25a\u2983\uaf2d\u1566\u9c8a\u0285\u8846\u0f82\uf5e5\u7b34\ue29c\u68d7\uee52", -1071526083) + (bl ? a.c(-906782970, "\u976b\uee88") + n3 : a.b("\u6b87\u1231\u98f7\u0689\u8d54", 1778281457)) + a.b("\u3a1c\u43ff\uc937\u575c\udc9d\u5a74", 717044282) + gtq.gwn(guh - guf));
        }
    }

    private static void gvr(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\ub79e\uce01\u44ce\uda96\u5174\ud7c1\u6d81\ue46e", 1589491677));
        int n = 75;
        switch (gts) {
            case 1: {
                kfe2.setEnabled(true);
                for (vmo vmo2 : kfe2.getSettings()) {
                    if (!(vmo2 instanceof vlq)) continue;
                    vlq vlq2 = (vlq)vmo2;
                    vlq2.set(n);
                }
                gtq.gwi(minecraftClient, a.c(1458654319, "\u4c19\u35ae\ubf71\u2108\uaad7\u2c64\u963c\u1fcc\u81d6\u0b34\u8ce1\u7697\uf844\u61ea\ueba6\u6d40\ud702"));
                gtq.gwi(minecraftClient, a.b("\ub448\ucdfa\u4729\ud95b\u528a\ud42c\u6e2b\ue79d\u79cc\uf362\u74a2\u8e96!\u99a3\u13a3\u9500\u2f58\ua09f\u3a36\ubc7d\u358d\u4fc9\uc175\u5aa9\udcd0\u5644\uefe1\u61b6\ufb41\u7d00\uf6a7\u0862\u8279\u1b8e\u9dda\u177b", 2103882761));
                break;
            }
            case 5: {
                gtq.gvs(minecraftClient, a.c(1353123376, "\u0655\u7fe3\uf528\u6b4a\ue096\u663d\udc75\u5599\ucbcd\u412b\uc6e7\u3c96"));
                break;
            }
            case 30: {
                gtq.gvt(minecraftClient, kfe2, n);
                break;
            }
            case 31: 
            case 32: 
            case 33: 
            case 34: {
                gtq.gvu(minecraftClient, a.b("\u7794", 1969125332));
                break;
            }
            case 70: {
                gtq.gvv(minecraftClient, a.d("\u27a7", 1697028118, 669171697), 20);
                break;
            }
            case 75: {
                gtq.gvs(minecraftClient, a.d("\u0fc1\u7677\ufcbf\u62d8\ue90c\u6fae\ud5a1\u5c4a", -1176340671, -624068384));
                break;
            }
            case 100: {
                gtq.gvt(minecraftClient, kfe2, n);
                break;
            }
            case 101: 
            case 102: 
            case 103: {
                gtq.gvu(minecraftClient, a.d("\u5cc7", -105797859, 2060057497));
                break;
            }
            case 140: {
                gtq.gvv(minecraftClient, a.d("\u6aef", 1251275327, -75982701), 4);
                break;
            }
            case 145: {
                gtq.gvs(minecraftClient, a.c(-964669963, "\u4d90\u3426\ubeed\u208f\uab53\u2df8\u97b0\u1e5c\u8008\u0aee\u8d22\u7753"));
                break;
            }
            case 160: {
                minecraftClient.field_1690.field_1894.method_23481(true);
                break;
            }
            case 165: {
                gtq.gvt(minecraftClient, kfe2, n);
                break;
            }
            case 166: 
            case 167: 
            case 168: 
            case 169: 
            case 170: {
                gtq.gvu(minecraftClient, a.c(366785329, "\ub373"));
                break;
            }
            case 210: {
                gtq.gvv(minecraftClient, a.c(1252205632, "\u2402"), 20);
                if (!minecraftClient.field_1690.field_1894.method_1434()) break;
                ++gum;
                System.out.println(a.d("\u0b58\u72fc\uf82b\u6649\ued80\u6b7d\ud14d\u58df\uc6e6\u4c50\ucb8b\u31ff\ubf44\u26b3\uace9\u2a05\u904f\u1f88\u8528\u036f\u8adc\uf0de\u7e6a\ue5a6\u63dc\ue90d\u50f2\udeeb\u4411\uc249\u49f2", -1868916409, 1791988336));
                break;
            }
            case 215: {
                gtq.gwi(minecraftClient, a.b("\u1569\u6cd7\ue60d\u7878\uf3bc\u755f\ucf6c\u46ae", 94704898));
                break;
            }
            case 225: {
                gtq.gvt(minecraftClient, kfe2, n);
                break;
            }
            case 226: {
                if (kvz.busy()) {
                    ++gum;
                    System.out.println(a.c(-854650915, "\u0f8c\u7628\ufcff\u629d\ue954\u6fa9\ud59e\u5c0b\uc232\u4884\ucf5f\u352b\ubb90\u2263\ua827\u2ed0\u9495\u1b1d\u81f9\u07b6\u8e5c\uf411\u7aa5\ue16e\u6710\ued95\u5467\uda77\u40d0\uc694\u4d23\ub3e1\u39b0"));
                } else {
                    System.out.println(a.d("\u5ed4\u2770\uada7\u33c5\ub80c\u3ef1\u84c6\u0d53\u9343\u19f6", 1643387729, 1029916159));
                }
                System.out.println(a.c(-1768112385, "\ube84\uc720\u4df7\ud395\u585c\udea1\u64a6\ued46\u730f\uf9b9\u7e3e") + (gum == 0 ? a.c(-600502780, "\u0e50\u77f0\ufd31\u6340") : a.c(369175211, "\u2aeb\u535d\ud986\u47f2\ucc49\u4af0") + gum + a.c(525126677, "\ucc3d")));
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
        if (clientPlayerEntity != null && gts > 30) {
            gun = Math.max(gun, minecraftClient.field_1687.method_8390(EnderPearlEntity.class, clientPlayerEntity.method_5829().method_1014(64.0), enderPearlEntity -> true).size());
        }
    }

    private static void gvs(MinecraftClient minecraftClient, String string) {
        gtq.gwi(minecraftClient, a.c(1683506763, "\u4620\u3f9e\ub544\u2b31\ua0f5\u2616\u9c25\u15e7"));
        gtq.gwi(minecraftClient, a.b("\ud8f2\ua15e\u2b9c\ub5e5\u3e7f\ub89c\u02d8\u8b3c\u157f\u9fc3\u1812\ue265\u6cf7\uf503\u7f5b\uf9b0\u43e2\ucc2e\u5690\ud098\u590f\u236d\uad8d\u3614\ub06c\u3aa6\u8303\u0d51\u97b5\u11b8\u9a15\u64d4\ueecc\u7723\uf16d\u7bc0\uc45f\u4e63\uc8b4\u5102\udb56\ua5a1\u2fe3\ua841\u3291\ubcf2\u056f\u8f80\u09c2\u921b\u1c64\ue6b7\u6f01\ue95a\u7392\ufdef\u4654\uc09d\u4af3\ud334", -844441433));
        gtq.gwi(minecraftClient, a.b("\uf716\u8eba\u0478\u9a01\u119b\u9778\u2d3c\ua4d8\u3a9b\ub027\u37f6\ucd81\u4313\udae7\u50bf\ud654\u6c06\ue3ca\u7974\uff7c\u76eb\u0c89\u8269", 671151976) + string + a.c(-1016843499, "\u332b\u4acd\uc000\u5e6c\ud5a7\u535e\ue940\u60b5\ufeed\u7457\uf382\u09e2\u8726\u1e90\u94d1\u126e\ua87e\u27a4\ubd1d\u3b4d\ub2ad\uc8d1\u464d\udd89\u5bf2\ud130\u689d\ue680\u7c66\ufa30"));
        minecraftClient.field_1724.method_31548().method_61496(0);
        gun = 0;
    }

    private static void gvt(MinecraftClient minecraftClient, kfe kfe2, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        clientPlayerEntity.method_31548().method_61496(0);
        clientPlayerEntity.method_36457(-35.0f);
        System.out.println(a.b("\u04fa\u7d5e\uf789\u69eb\ue222\u64df\udedc\u572f\uc967\u43c0\uc413\u3e2b\ub0e6\u291f\ua341\u25b9\u9ffe\u1076", 1960772760) + clientPlayerEntity.method_6047().method_7909() + a.d("\ua319\udae1\u503f\uce46\u4598\uc371", 336048640, -294186689) + vyn.serverIdle(clientPlayerEntity) + a.c(1011328644, "\ua6ad\udf5a\u5580\ucbec\u403e\uc699\u7cd9\uf53e\u6b38") + minecraftClient.field_1690.field_1894.method_1434());
        kfe2.onKey(minecraftClient, n);
    }

    private static void gvu(MinecraftClient minecraftClient, String string) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        System.out.println(a.d("\uf82e\u818a\u0b5d\u953f\u1ef6\u980b", 1541921167, 677192151) + string + a.d("\uea26\u93c3", 1698201271, 1454937267) + gts + a.b("\ude50\ua7fb\u2d6a\ub30c\u38dd\ube66\u0471", 1359863405) + kvz.busy() + a.b("\u705a\u09a3\u8379\u1d07\u96da\u1032", -1987022724) + clientPlayerEntity.method_6047().method_7909() + a.b("\u130c\u6aee\ue022\u7e50\uf59c\u7364", 204215082) + clientPlayerEntity.method_31548().method_67532() + a.d("\ufada\u832d\u09f7\u979b\u1c49\u9aee\u20ae\ua949\u374f", 856602379, 1048464888) + minecraftClient.field_1690.field_1894.method_1434() + a.c(-886743732, "\u5d6a\u2492\uae4c\u3035\ubbeb\u3d02") + vyn.serverIdle(clientPlayerEntity));
    }

    private static void gvv(MinecraftClient minecraftClient, String string, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        ItemStack itemStack = playerInventory.method_5438(n);
        StringBuilder stringBuilder = new StringBuilder();
        if (!clientPlayerEntity.method_6047().method_31574(Items.field_8802)) {
            stringBuilder.append(a.c(-571063204, "\u447a\u3d83\ub759\u2927\ua2fa\u2412")).append(clientPlayerEntity.method_6047().method_7909());
        }
        if (!itemStack.method_31574(Items.field_8634) || itemStack.method_7947() != 15) {
            stringBuilder.append(a.c(1590289386, "\ue3c2\u9a23\u10e5\u8e90\u0554\u83fb\u39b7\ub075")).append(n).append('=').append(itemStack);
        }
        if (playerInventory.method_67532() != 0) {
            stringBuilder.append(a.c(1013203374, "\u4188\u386a\ub2a6\u2cd4\ua718\u21e0")).append(playerInventory.method_67532());
        }
        if (gun == 0) {
            stringBuilder.append(a.c(-703572630, "\u555a\u2ca5\ua677\u3849\ub3ce\u356a\u8f3d\u06df\u989e\u1263\u95f5\u6f8f\ue142\u78ee\uf2a0\u745c"));
        }
        if (kvz.busy()) {
            stringBuilder.append(a.d("\u3ffc\u461e\uccca\u52a6\ud974\u5fc5\ue5da\u6c69\uf221\u7896\uff4f", 1502416879, 1986080824));
        }
        if (!stringBuilder.isEmpty()) {
            ++gum;
        }
        System.out.println(a.d("\u8c37\uf593\u7f44\ue126\u6aef\uec12", -354095373, 1781228210) + string + (stringBuilder.isEmpty() ? a.d("\u7645\u0fbb\u856c", 1018822907, 1623094941) : a.b("\ua45c\udd8b\u575f\uc926\u42f4", -1949784967) + stringBuilder));
    }

    private static void gvw(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        pbz pbz2 = pbz.get();
        switch (gts) {
            case 1: {
                pbz2.setEnabled(true);
                gtq.gwi(minecraftClient, a.c(-63501420, "\u0be2\u7255\uf88a\u66f3\ued2c\u6b9f\ud1c7\u5837\uc62d\u4cdf\ucb1d\u317b\ubfa8\u260c\uac42\u2aac\u90f0"));
                clientPlayerEntity.method_36456(0.0f);
                clientPlayerEntity.method_36457(10.0f);
                break;
            }
            case 10: {
                gtq.gwi(minecraftClient, a.d("\ufbc4\u827a\u08ac\u96dd\u1d46\u9ba9\u21a9\ua847\u360a\ubce5\u3b68\uc147\u4fd6\ud67f\u5c72\udacf\u6092\uef1d\u75e4\uf3a1\u7a08\u001f\u8eb4\u1528\u9353\u1985\ua03d\u2e6a\ub48c\u32ce\ub97a\u47b9\ucdb8\u541a\ud243\u58f4", -483470946, 1764502040));
                break;
            }
            case 14: {
                gtq.gwi(minecraftClient, a.c(1542570319, "\uc112\ub8ac\u327a\uac0b\u2790\ua17f\u1b7f\u9292\u0ccc\u866d\u01e0\ufbc2\u7509\ueca9\u66a4\ue01a\u5a56\ud595\u4f78\uc97a\u4094\u3ad1\ub43c\u2fa6\ua9cc\u2343\u9abf\u14e7\u8e08\u0814\u83a3\u7d75\uf731\u6ec6\ue884\u6226\uddf6\u5795\ud108\u48ed\uc2b9\ubc59\u3616\ub1aa\u2b6a\ua536\u1cd8\u9679\u102d\u8bf6\u058d\uff44\u76a0\uf0b9\u6a4d\ue41f\u5fa0\ud972\u5319"));
                break;
            }
            case 18: {
                gtq.gwi(minecraftClient, a.d("\u74d3\u0d6d\u87bb\u19ca\u9251\u14be\uaea7\u2742\ub943\u33ac\ub421\u4e1f\uc0cb\u5968\ud365\u55d2\uef85\u600a\ufaf3\u7cb6\uf51f\u8f01\u01b5\u9a72\u1c40\u9695\u2f21\ua17b\u3b8a\ubdca\u366a\uc8bc\u42e1\udb5e\u5d52\ud7e8\u6835\ue27f\u6480\ufd36\u7772\u0982\u83da\u0451\u9ebb\u10da\ua912\u23a9\ua5ee\u3e27", -1916310090, -195028687));
                break;
            }
            case 22: {
                gtq.gwi(minecraftClient, a.c(-514754464, "\u7828\u0196\u8b40\u1531\u9eaa\u1845\ua259\u2bab\ub5e6\u3f09\ub884\u42ab\ucc36\u5593\udf9e\u5920\ue36a\u6caf\uf642\u705f\uf9ba\u83b5\u0d4e\u9689\u10bb\u9a6e\u23da\uad80\u3771\ub131\u3a91\uc447\u4e1a\ud7a5\u51bd\udb08\u64cb\ueea9\u687c\uf1c3\u7bb9\u0575\u8f28\u089a\u9241\u1c38"));
                break;
            }
            case 40: {
                gtq.gwp(minecraftClient, a.d("\u5d9f\u2429\uaefc\u308a\ubb4b\u3ded\u87bf\u0e49\u9001\u1aa6", 2034326878, 1145897144));
                gtq.gwh(minecraftClient, a.c(-1156519466, "\ue9be\u9015\u1ac7\u84b1\u0f7c\u89c0\u3392"), 3, 0);
                break;
            }
            case 45: {
                gtq.gwi(minecraftClient, a.b("\uf0fa\u8944\u0392\u9de3\u1678\u9097\u2a97\ua379\u3d34\ub7db\u3056\uca79\u44e8\udd41\u574c\ud1f1\u6bac\ue423\u7eda\uf89f\u7136\u0b21\u858a\u1e16\u986d\u12bb\uab03\u2554\ubfb2\u39f0\ub244\u4c87\uc686\u5f2c\ud977\u53dd", -1200754504));
                break;
            }
            case 60: {
                gtq.gwh(minecraftClient, a.b("\u6a18\u13b5\u996b\u0708\u8cd8\u0a3d\ub029\u39d0\ua78e\u2d34", -598644126), 2, 0);
                break;
            }
            case 65: {
                gtq.gwi(minecraftClient, a.b("\u4eab\u3715\ubdc3\u23b2\ua829\u2ec6\u94c6\u1d28\u8365\u098a\u8e0a\u7467\ufaa1\u634e\ue94e\u6fa0\ud5fd\u5a72\uc08d\u46ce\ucf67\ub57b\u3bdb\ua054\u2667\uaca4\u155a\u9b0f\u01ff\u87a5\u0c10\uf2d0\u788c\ue17a\u673b\uedc4\u5258\ud82d\u5eea\uc748\u4d11\u33ee\ub998\u3e14\ua4cd\u2abf\u9360\u19d9\u9fdd\u0444\u8a30\u70e2\uf955\u7f07\ue5ec", 979455738));
                break;
            }
            case 80: {
                gtq.gwp(minecraftClient, a.b("\u4da9\u341f\ubeca\u20bc\uab7d\u2ddb\u9789\u1e7f\u8037\u0a90\u8d1d\u7728\uf9f8\u6054\uea1d\u6ce1\ud6af", 692866507));
                gtq.gwh(minecraftClient, a.d("\u3241\u4bf7\uc139\u5f52\ud488\u5238", 1520715871, -1883407759), 3, 1);
                break;
            }
            case 390: {
                gtq.gwh(minecraftClient, a.c(1096338961, "\uce69\ub7de\u3d1e\ua37e\u28f9\uae0d\u1443\u9dba\u03fc\u8956\u0e92\uf4e2"), -1, 0);
                if ((a.c(-1126796184, "\u7451\u0dfb") + pbz2.describe()).contains(a.d("\u669d\u1f37\u9590\u0be7\u8023\u0683\ubcc0", -1789528288, 172265857))) {
                    ++guo;
                    System.out.println(a.c(22459253, "\ub324\uca92\u4047\ude31\u55f0\ud356\u6904\ue0f2\u7eba\uf41d\u739d\u898a\u075a\u9ee3\u14b5\u9228\u2833\ua7e4\u3d44\ubb04\u32a3\u48a1\uc615\u5dd9\udba3\u5172\ue88d\u6688\ufc79\u7a3b\uf18a\u0f53\u8512\u1ce2"));
                }
                System.out.println(a.d("\u293c\u508a\uda5f\u4429\ucfe8\u494e\uf31c\u7aea\ue4a2\u6e05\ue985\u13a0\u9d66\u04c1\u8e95\u0830", -481792533, 1766343860) + (guo == 0 ? a.b("\u08eb\u714b\ufb8a\u65fb", -1449457473) : a.c(1137940641, "\u98e1\ue157\u6b8c\uf5f8\u7e43\uf8fa") + guo + a.d("\u1fe6", 2066435982, 881414208)));
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvx(MinecraftClient minecraftClient) throws Exception {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        kfe kfe2 = kfx2.getByName(a.c(96451058, "\ub9a9\uc021\u4af1\ud499\u5f56\ud9ef\u63ad\uea5a\u741e\ufea5\u7953\u830b\u0dd4"));
        vlv vlv2 = (vlv)gtq.gwg(kfe2, a.c(40203084, "\u775e\u0ec5\u8461\u1a62\u91c1\u1773\uad50\u24ad"));
        switch (gts) {
            case 1: {
                gtq.gwi(minecraftClient, a.d("\ub275\ucbc2\u411d\udf64\u54bb\ud208\u6850\ue1a0\u7fba\uf548\u728a\u88ec\u063f\u9f9b\u15d5\u933b\u2967", -478624440, 1572829003));
                gtq.gwi(minecraftClient, a.d("\u09ea\u7046\ufa91\u64e8\uef7a\u6998\ud3dd\u5a3d\uc436\u4e96\uc944\u3335\ubde2", -182190085, -333515160));
                gtq.gwi(minecraftClient, a.d("\ua056\ud9f5\u5322\ucd46\u468d\uc031\u7a75\uf3d6\u6dca\ue774\u60ae\u9adb\u141f", -376913244, 910385800));
                minecraftClient.field_1724.method_36456(-90.0f);
                minecraftClient.field_1724.method_36457(4.0f);
                break;
            }
            case 4: {
                gtq.gwi(minecraftClient, a.d("\uee43\u97fd\u1d2b\u835a\u08c1\u8e2e\u3436\ubdd2\u23d3\ua93c\u2eb1\ud493\u5a5b\uc3f8\u49f5\ucf4f\u7515\ufa9a\u6061\ue626\u6f8f\u158d\u9b21\u00e2\u86d0\u0c05\ub5b1\u3beb\ua11a\u275a\uacfa\u522c\ud871\u41ce\uc7c8\u4d77\uf2aa\u78ef\ufe0f\u67bd\uedea", 1535949828, 1015304712));
                break;
            }
            case 5: {
                gtq.gwi(minecraftClient, a.c(1963487237, "\u704d\u09f3\u8325\u1d54\u96cf\u1020\uaa3c\u23ce\ubd83\u376c\ub0e1\u4ace\uc454\u5df6\ud7fb\u5145\ueb09\u64ca\ufe27\u7831\uf1df\u8bd0\u052e\u9eec\u18de\u920b\u2bbf\ua5e5\u3f14\ub954\u32f4\ucc22\u467f\udfc0\u59da\ud36c\u6ca0\ue6d0\u6008\uf983\u73e1\u0d00\u8748\u00f3\u9a2c\u1445"));
                break;
            }
            case 6: {
                gtq.gwi(minecraftClient, a.c(975348641, "\ua3f7\uda49\u509f\uceee\u4575\uc39a\u7985\uf074\u6e39\ue4d6\u635b\u9974\u17f0\u8e54\u041f\u82b0\u38b3\ub762\u2dc3\uabcc\u2274\u5826\ud687\u4d08\ucb31\u41f8\uf806\u7653\ueca3\u6af9\ue14c\u1f8c\u95d0\u0c26\u8a67\u0098\ubf06\u3570\ub3b8\u2a08\ua05c\ude97\u54f9\ud358\u4994\uc7ef\u7e34\uf49d"));
                break;
            }
            case 7: {
                gtq.gwi(minecraftClient, a.d("\u0be4\u725a\uf88c\u66fd\ued66\u6b89\ud19d\u5875\uc674\u4c9b\ucb16\u3134\ubff9\u265f\uac52\u2ae4\u90b2\u1f3d\u85c4\u0381\u8a28\uf02a\u7e81\ue545\u6377\ue9a2\u5016\ude4c\u44bd\uc2fd\u495d\ub78b\u3dd6\ua469\u2273\ua8c1\u1714\u9d62\u1ba7\u8210\u0875\u76ab\ufce4\u7b58\ue180\u6ff4\ud63f", -1441768513, -92909550));
                break;
            }
            case 8: {
                gtq.gwi(minecraftClient, a.b("\u559c\u2c22\ua6f4\u3885\ub31e\u35f1\u8fed\u061b\u9852\u12bd\u9530\u6f1f\ue180\u7827\uf22a\u7494\uced2\u411b\udbf6\u5dea\ud40e\uae01\u20f4\ubb3d\u3d0f\ub7da\u0e6e\u8034\u1ac5\u9c85\u1725\ue9f3\u63ae\ufa11\u7c15\uf6a6\u496d\uc31c\u45c5\udc52\u5631\u28cc\ua292\u2523\ubffa\u3182\u8847\u02f1\u84a5\u1f75\u910d", -1222158903));
                break;
            }
            case 60: {
                gtq.gwp(minecraftClient, a.b("\u3b97\u422f\uc8f4\u56cf\udd05\u5bb4\ue1fa\u6849\uf61f\u7cae", 1692285947));
                break;
            }
            case 61: {
                kfe2.setEnabled(true);
                vaf.timing(true);
                break;
            }
            case 100: {
                vaf.gpuMillis();
                break;
            }
            case 140: {
                gtq.gwd(a.c(1075743222, "\u8de3\uf40b\u7ed2\ue0dc\u6b0f\uedba\u57e2"));
                gtq.gwp(minecraftClient, a.d("\u6883\u113b\u9be0\u05db\u8e11\u08a1\ub2ee\u3b41\ua518\u2fb2\ua87d\u5217\udcda\u457d\ucf66\u49df\uf394\u7c57\ue6e3", 1310277183, -310946103));
                vlv2.set(a.b("\u83dc\ufa48\u7094\ueee8\u653b\ue381", 1864140743));
                break;
            }
            case 141: 
            case 181: 
            case 221: {
                vaf.gpuMillis();
                break;
            }
            case 180: {
                gtq.gwd(a.c(-1743176652, "\u382f\u41bb\ucb67\u551b\udec8\u5872"));
                vlv2.set(a.c(-761524139, "\u1473\u6da3\ue705\u7975\uf2ab\u7412\uce41"));
                break;
            }
            case 220: {
                gtq.gwd(a.d("\u7e2d\u07fd\u8d5b\u132b\u98f5\u1e4c\ua41f", -1010891999, 392132906));
                vlv2.set(a.c(-1478458021, "\u817e\uf8d7\u7273\uec0c\u67d9\ue118"));
                break;
            }
            case 260: {
                gtq.gwd(a.d("\uf0c8\u8961\u03c5\u9dba\u166f\u90ae", -1882970629, -1079193322));
                gtq.gwp(minecraftClient, a.b("\ud8a9\ua111\u2bca\ub5f1\u3e3b\ub88b\u028b\u8b35\u1532\u9f9a\u1851\ue226\u6ce2", -1592338238));
                vlv2.set(a.c(1987320649, "\u1f5c\u66b4\uec6d\u7263\uf9b0\u7f05\uc55d"));
                minecraftClient.field_1724.method_36456(90.0f);
                break;
            }
            case 300: {
                gtq.gwp(minecraftClient, a.c(183539709, "\u9788\uee30\u64eb\ufad0\u711a\uf7a9\u4de5\uc44a\u5a13\ud0b9\u5776\uad1c\u23d1\uba76\u306d\ub6c6\u0c9b\u835c\u19e8"));
                break;
            }
            case 301: {
                gtq.gwi(minecraftClient, a.c(-486815204, "\uca65\ub3c9\u391e\ua767\u2cf5\uaa17\u1052\u99b2\u07b9\u8d1e\u0acb\uf0ba\u7e6d"));
                minecraftClient.field_1724.method_36456(-60.0f);
                break;
            }
            case 340: {
                gtq.gwp(minecraftClient, a.d("\u91da\ue862\u62b9\ufc82\u7748\uf1fa\u4bb7\uc205\u5c5b\ud6ea\u5138", -1252261475, 214470698));
                break;
            }
            case 341: {
                gtq.gwi(minecraftClient, a.b("\u0580\u7c2c\uf6fb\u6882\ue310\u65f2\udfb7\u5657\uc85c\u42fc\uc52c\u3f5b\ub188\u2839", 665388538));
                minecraftClient.field_1724.method_36456(90.0f);
                break;
            }
            case 380: {
                gtq.gwp(minecraftClient, a.c(2087187079, "\uf2ec\u8b54\u018f\u9fb4\u147e\u92cb\u2881\ua12e\u3f77\ub5dd\u3213\uc874\u46b2"));
                break;
            }
            case 381: {
                gtq.gwi(minecraftClient, a.d("\uefbd\u9611\u1cc6\u82bf\u092d\u8fcf\u358a\ubc6a\u2261\ua8c1\u2f1b\ud562\u5bb5\uc204", 186911257, -523508258));
                break;
            }
            case 420: {
                gtq.gwp(minecraftClient, a.b("\ueab6\u930e\u19d5\u87ee\u0c24\u8a90\u30db\ub969\u2731\uad8e\u2a52\ud03f", -881464612));
                break;
            }
            case 421: {
                gtq.gwi(minecraftClient, a.b("\uc24f\ubbe3\u3134\uaf4d\u24df\ua23d\u1878\u9198\u0f93\u8530\u02e1\uf890\u7647", 313573942));
                minecraftClient.field_1724.method_31549().field_7479 = true;
                gtq.gwi(minecraftClient, a.d("\u0d18\u74ad\ufe2e\u603f\uebdb\u6d39\ud734\u5e9b\uc09a\u4a67\ucdb4\u37d7\ub95e", 1101760650, -553024021));
                break;
            }
            case 425: {
                minecraftClient.field_1724.method_36457(35.0f);
                minecraftClient.field_1724.method_36456(-60.0f);
                break;
            }
            case 470: {
                gtq.gwp(minecraftClient, a.d("\uc127\ub89f\u3244\uac7f\u27b5\ua102\u1b4a\u92f7\u0cab\u8617\u01dd\ufbbf", -2118641421, -1335305794));
                break;
            }
            case 471: {
                gtq.gwi(minecraftClient, a.d("\uea9a\u932f\u19ac\u87bd\u0c59\u8abb\u30b6\ub919\u2718\uadfa\u2a36\ud047\u5e82\uc76d", 53758000, 2006229712));
                break;
            }
            case 475: {
                minecraftClient.field_1724.method_36457(10.0f);
                minecraftClient.field_1724.method_36456(-90.0f);
                ((vla)gtq.gwg(kfe2, a.c(-213674425, "\u9265\uebc0\u6114\uff12"))).set(a.d("\uc0a5\ub920\u33f4\uad98\u2652\ua0f0", -4736142, -1299350640));
                break;
            }
            case 510: {
                gtq.gwp(minecraftClient, a.c(-1219557800, "\u0633\u7f8b\uf550\u6b6b\ue0a1\u6617\udc5e\u55e3\ucba8\u411e\uc6d0\u3cbc\ub278"));
                break;
            }
            case 511: {
                ((vla)gtq.gwg(kfe2, a.d("\u8ce5\uf540\u7f94\ue192", 859654287, 205570120))).set(a.d("\u2137\u58bb\ud269\u4c00", -578872668, 1930705860));
                minecraftClient.field_1690.method_31043(Perspective.field_26665);
                minecraftClient.field_1724.method_36457(22.0f);
                minecraftClient.field_1724.method_36456(0.0f);
                break;
            }
            case 550: {
                gtq.gwp(minecraftClient, a.c(-261601352, "\u47d1\u3e69\ub4b2\u2a89\ua143\u27fa\u9dbc\u1413\u8a4b\u00ef\u8733\u7d48\uf3d6\u6a79\ue069"));
                break;
            }
        }
        if (gts > 552 && gts <= 590) {
            minecraftClient.field_1724.method_5814(minecraftClient.field_1724.method_23317(), minecraftClient.field_1724.method_23318(), minecraftClient.field_1724.method_23321() + 0.28);
        }
        switch (gts) {
            case 591: {
                gtq.gwp(minecraftClient, a.d("\ubfde\uc666\u4cbd\ud286\u594c\udff4\u65b3\uec18\u7251\uf8ea\u7f37\u850e\u0bc7\u9235", -731035200, 455079542));
                break;
            }
            case 620: {
                gtq.gwp(minecraftClient, a.d("\u07b3\u7e0b\uf4d0\u6aeb\ue120\u6790\uddde\u5475\uca3c\u4087\uc75a\u3d63\ub3f5\u2a49\ua00f\u26ef\u9cb7", 982728806, -294041694));
                break;
            }
            case 621: {
                minecraftClient.field_1690.method_31043(Perspective.field_26664);
                break;
            }
            case 660: {
                gtq.gwd(a.d("\u8076\uf9c8\u7300\ued70\u66a0\ue045\u5a46\ud3a2\u4dea\uc75a\u4095\ubae5", -646326993, -1576577741));
                gtq.gwp(minecraftClient, a.d("\u56df\u2f67\ua5bc\u3b87\ub04c\u36fd\u8cb2\u0508\u9b58\u11f2\u9620\u6c56\ue2d8\u7b34\uf172\u7794\ucdda\u4217\ud8a5", 2113535, -882939563));
                break;
            }
            case 661: {
                kfe2.setEnabled(false);
                vaf.timing(false);
                break;
            }
            case 690: {
                gtq.gwp(minecraftClient, a.b("\u37f7\u4e4f\uc494\u5aaf\ud164\u57d6\ued9a\u6429\ufa7f\u70ce\uf756\u0d6b\u83ba\u1a0d\u9056\u16a0", 666974081));
                System.out.println(a.d("\u5b4d\u22f5\ua82e\u3618\ubd9b\u3b3b\u817e\u0888\u9683\u1c76\u9bae\u61de\uef02", 1292597639, 1247748769));
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvy(MinecraftClient minecraftClient) throws Exception {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(748729174, "\ub30d\uca85\u4055\ude3d\u55f2\ud34b\u6909\ue0fe\u7eba\uf401\u73f7\u89af\u0770"));
        switch (gts) {
            case 1: {
                gtq.gwi(minecraftClient, a.c(1617012596, "\ua702\udeb5\u546a\uca13\u41cc\uc77f\u7d27\uf4d7\u6acd\ue03f\u67fd\u9d9b\u1348\u8aec\u00a2\u864c\u3c10"));
                gtq.gwi(minecraftClient, a.b("\ubf8c\uc620\u4cf7\ud28e\u591c\udffe\u65bb\uec5b\u7250\uf8f0\u7f22\u8553\u0b84", -1611218955));
                gtq.gwi(minecraftClient, a.c(790972860, "\u49c6\u3065\ubab2\u24d6\uaf1d\u29a1\u93e5\u1a46\u845a\u0ee4\u893e\u734b\ufd8f"));
                gtq.gwi(minecraftClient, a.b("\u6f92\u1627\u9ca4\u02b5\u8951\u0fb3\ub5f0\u3c11\ua210\u28ff\uaf3c", 1794994157));
                break;
            }
            case 4: {
                gtq.gwi(minecraftClient, a.d("\u673d\u1e83\u9455\u0a24\u81bf\u071b\ubd5d\u34f2\uaaf3\u204f\ua783\u5de0\ud322\u4a86\uc08b\u4632\ufc6b\u73b7\ue91b\u6f58\ue6e2\u9cb7\u1203\u89d9\u0fa0\u8560\u3cc0\ub296\u2873\uae6c\u258a\udb55\u5110\uc8d5\u4eb5\uc407\u7bd8", 462701025, -562157921));
                break;
            }
            case 5: {
                gtq.gwi(minecraftClient, a.b("\uc70f\ubeb1\u3467\uaa16\u218d\ua72d\u1d7d\u949e\u0a9f\u8070\u07b0\ufdd2\u7314\ueaa6\u60e7\ue648\u5c40\ud388\u4928\ucf6a\u46d0\u3c85\ub231\u29eb\uaf92\u2552\u9cf2\u12a4\u8841\u0e5e\u85a4\u7b72\uf126\u68d6\uee8e\u6405\udbef\u518e\ud746\u4efd\uc4aa\uba43", 1771489091));
                break;
            }
            case 6: {
                gtq.gwi(minecraftClient, a.c(235858914, "\ueba8\u9216\u18c0\u86b1\u0d2a\u8b89\u31da\ub839\u2638\uacd7\u2b09\ud16d\u5fa2\uc601\u4c52\ucab1\u70a0\uff3e\u658e\ue3cd\u6a22\u106b\u9e95\u0540\u8338\u09e2\ub057\u3e17\ua4f3\u22a5\ua904\u579b\udd9d\u446b\uc223\u4893\uf74f\u7d04\ufbea\u624b\ue80f\u96f4\u1caf\u9b06"));
                break;
            }
            case 7: {
                gtq.gwi(minecraftClient, a.d("\u6c7e\u15c0\u9f16\u0167\u8afc\u0c40\ub607\u3fef\ua1ee\u2b01\uacdf\u56b4\ud874\u41c8\ucb8f\u4d67\uf776\u78ed\ue24a\u6416\uedf9\u97bd\u1943\u8296\u04ee\u8e34\u3781\ub9c1\u2325\ua573\u2ed2\ud04d\u5a4b\uc3b9\u45e8\ucf5e\u709f\ufae8\u7c01\ue59f\u6fdc\u1120\u9b7c\u1cc8\u8607", -1953578263, 1280945884));
                break;
            }
            case 8: {
                gtq.gwi(minecraftClient, a.b("\u27cb\u5e75\ud4a3\u4ad2\uc149\u47f5\ufdba\u744c\uea05\u60ea\ue767\u1d00\u93c1\u0a7d\u8032\u06ca\ubc9d\u3312\ua9ec\u2fae\ua641\udc08\u52f6\uc923\u4f5b\uc581\u7c34\uf274\u6890\ueec6\u6567\u9bf8\u11e0\u8813\u0e5c\u84ed\u3b30\ub167\u3788\uae35\u2467\u5a96\ud0cb\u5773\ucdb2\u43c4\ufa0c\u70bc\uf6f8", 1471686556));
                break;
            }
            case 9: {
                gtq.gwi(minecraftClient, a.d("\u2559\u5ce7\ud631\u4840\uc3db\u4579\uff39\u7696\ue897\u622b\ue5e4\u1f90\u9153\u08f6\u82b1\u041e\ube18\u31de\uab60\u2d2d\ua4d8\ude9a\u5064\ucbb1\u4dc9\uc713\u7ea6\uf0e6\u6a02\uec54\u67f5\u996a\u137d\u8a87\u0ccf\u866f\u39b3\ub3f5\u3515\uaca7\u26f0", -1424791047, -639611665));
                break;
            }
            case 40: {
                kfe2.setEnabled(true);
                vaf.timing(true);
                break;
            }
            case 90: {
                vaf.gpuMillis();
                break;
            }
            case 130: {
                gtq.gvz(minecraftClient, -90.0f, 4.0f, a.c(1230926813, "\u73bc\u0a09\u80c8\u1ebe"));
                break;
            }
            case 170: {
                gtq.gvz(minecraftClient, 90.0f, 4.0f, a.d("\uab5a\ud2f9\u583c\uc64a", 174188137, -1803334336));
                break;
            }
            case 210: {
                gtq.gvz(minecraftClient, 180.0f, -2.0f, a.d("\u1f5e\u66ee\uec20\u7257\uf99c", 890193299, -2089657690));
                break;
            }
            case 211: {
                minecraftClient.field_1724.method_31549().field_7479 = true;
                gtq.gwi(minecraftClient, a.b("\u7151\u08e4\u8267\u1c76\u9792\u1170\uab33\u22d2\ubcd3\u362e\ub1ff\u4b9e\uc559", -1018662616));
                break;
            }
            case 260: {
                gtq.gvz(minecraftClient, -60.0f, 35.0f, a.c(733093457, "\u1e35\u6787\ued59\u7331\uf8f5"));
                break;
            }
            case 261: {
                gtq.gwi(minecraftClient, a.b("\u4856\u31e3\ubb60\u2571\uae95\u2877\u9234\u1bd5\u85d4\u0f36\u88fa\u7289\ufc4e\u65ef", 404637740));
                gtq.gwi(minecraftClient, a.b("\ua282\udb2e\u51f9\ucf80\u4412\uc2f0\u78b5\uf155\u6f5e\ue5fe\u622e\u985e\u168a\u8f3b", 1890689784));
                break;
            }
            case 300: {
                gtq.gvz(minecraftClient, 90.0f, 2.0f, a.b("\u818a\uf83d\u72f5\uec99\u6758\ue1f8", -2053012993));
                break;
            }
            case 311: {
                gtq.gwi(minecraftClient, a.b("\u6717\u1ebb\u946c\u0a15\u8187\u0765\ubd20\u34c0\uaacb\u2069\ua7b9\u5dc8\ud31f", 961308526));
                ((vmc)gtq.gwg(kfe2, a.c(1585929007, "\u5f39\u26ac\uac7a\u3277\ub9df\u3f6d\u8541\u0cb3\u92e2"))).set(0.8);
                break;
            }
            case 340: {
                gtq.gvz(minecraftClient, -30.0f, 0.0f, a.d("\u3e1f\u47af\ucd77\u531b\ud8da", 1205054989, -1067151245));
                break;
            }
            case 351: {
                ((vmc)gtq.gwg(kfe2, a.c(1819815724, "\u2b3a\u52af\ud879\u4674\ucddc\u4b6e\uf142\u78b0\ue6e1"))).set(0.2);
                break;
            }
            case 380: {
                gtq.gvz(minecraftClient, -30.0f, 0.0f, a.d("\uf301\u8ab5h\u9e16\u15dd", 122080485, -794935411));
                break;
            }
            case 391: {
                ((vmc)gtq.gwg(kfe2, a.b("\uad39\ud4ac\u5e7a\uc077\u4bdf\ucd6d\u7741\ufeb3\u60e2", -387274449))).set(0.45);
                gtq.gwi(minecraftClient, a.d("\udb3a\ua296\u2841\ub638\u3daa\ubb48\u010d\u88ed\u16e6\u9c46\u1b9c\ue1e5\u6f32\uf683", -763781333, 1066484843));
                break;
            }
            case 400: {
                gtq.gvz(minecraftClient, -90.0f, 4.0f, a.b("\u787e\u01c8\u8b15\u156b\u9ea0", -922650603));
                break;
            }
            case 420: {
                kfe kfe3 = Flow.getInstance().getModuleManager().getByName(a.d("\u301e\u499c\uc356\u5d27\ud6de\u505f\uea17\u63e8\ufdb8\u7715", 1133996387, -181577423));
                ((vlv)gtq.gwg(kfe3, a.d("\ud205\uab96\u214e\ubf3e", 245728471, -842836325))).set(a.b("\u3084\u4906\uc3cc\u5dbd", -88133434));
                kfe3.setEnabled(true);
                break;
            }
            case 430: {
                gtq.gvz(minecraftClient, -90.0f, 4.0f, a.d("\uf65b\u8fed\u0530\u9b4e\u1085\u966d\u2c75\ua597\u3bd1\ub160\u36bd\uccdc\u4210\udbaf\u51f3\ud71e", -528664934, 455786687));
                break;
            }
            case 450: {
                Flow.getInstance().getModuleManager().getByName(a.c(-554216664, "\u5364\u2ae6\ua02c\u3e5d\ub5a4\u3325\u896d\u0092\u9ec2\u146f")).setEnabled(false);
                kfe2.setEnabled(false);
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvz(MinecraftClient minecraftClient, float f, float f2, String string) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
        guq = string;
        gus = gts + 8;
    }

    private static void gwa(MinecraftClient minecraftClient) {
        if (gts == gus) {
            gtq.gwd(guq);
            gtq.gwp(minecraftClient, gur + ++gup + a.d("\u6fbd", -1369990843, 396490452) + guq);
        }
    }

    private static void gwb(MinecraftClient minecraftClient) throws Exception {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(-2039851968, "\u5410\u2d93\ua744\u3920\ub2eb\u3457\u8e13"));
        vlv vlv2 = (vlv)gtq.gwg(kfe2, a.c(-1161351236, "\u2fe9\u566e\udcb9\u42da\uc911\u4fa1"));
        kfe kfe3 = Flow.getInstance().getModuleManager().getByName(a.d("\u4676\u3ff4\ub53e\u2b4f\ua0b6\u2637\u9c7f\u1580\u8bd0\u017d", 907978929, -198381941));
        gur = a.d("\u1090\u6933\ue3e4\u7d80\uf64b\u70f7\ucab3\u431d", 653607281, 718295454);
        switch (gts) {
            case 1: {
                gtq.gwi(minecraftClient, a.b("\uffb9\u860e\u0cd1\u92a8\u1977\u9fc4\u259c\uac6c\u3276\ub884\u3f46\uc520\u4bf3\ud257\u5819\udef7\u64ab", 199032783));
                gtq.gwi(minecraftClient, a.b("\ua73a\ude96\u5441\uca38\u41aa\uc748\u7d0d\uf4ed\u6ae6\ue046\u6791\u9de5\u1332", -1879726269));
                gtq.gwi(minecraftClient, a.b("\uf7e3\u8e40\u0497\u9af3\u1138\u9784\u2dc0\ua463\u3a7f\ub0c1\u371b\ucd6e\u43aa", -1591806055));
                gtq.gwi(minecraftClient, a.d("\u47a0\u3e15\ub496\u2a87\ua163\u2781\u9dc2\u1423\u8a22\u00cd\u870e", 298815280, 932301039));
                break;
            }
            case 3: {
                gtq.gwi(minecraftClient, a.c(-1254589507, "\u7bea\u0254\u8882\u16f3\u9d68\u1bd4\ua19b\u286f\ub624\u3ccb\ubb4b\u4126\ucfe0\u565c\udc13\u5ae7\ue0bc\u6f7c\uf5ca\u738f\ufa26\u8024\u0e8b\u954b\u1325\u99f1\u2056\uae4a\u34b9\ub2ef\u3957\uc780\u4dde\ud43c\u5268\ud8cb\u6752\ued6a\u6bbe\uf214\u784a\u06b0\u8cd9\u0b55\u9192\u1ff8\ua621\u2c98\uaacf"));
                break;
            }
            case 4: {
                gtq.gwi(minecraftClient, a.d("\ua054\ud9ea\u533c\ucd4d\u46d6\uc06a\u7a25\uf3d1\u6d9a\ue775\u60f5\u9a98\u145e\u8de2\u07ad\u8159\u3b02\ub4de\u2e74\ua831\u2198\u5b9a\ud535\u4ef5\uc89b\u424f\ufbe8\u75f4\uef07\u6951\ue2e9\u1c3e\u9660\u0f82\u89d6\u0375\ubcec\u36c0\ub006\u29a4\ua3e9\udd18\u5767\ud0eb\u4a32\uc440\u7d9f\uf726", -319127716, -108994722));
                break;
            }
            case 5: {
                gtq.gwi(minecraftClient, a.d("\u37e1\u4e5f\uc489\u5af8\ud163\u57ca\ued81\u642e\ufa2f\u7093\uf75e\u0d3c\u83f3\u1a5a\u9057\u16ef\uacb7\u236b\ub9c6\u3f84\ub63e\ucc6b\u42df\ud905\u5f7c\ud5bc\u6c1c\ue24a\u78af\ufeb0\u7548\u8b9d\u01c6\u9824\u1e71\u94ce\u2b3c\ua162\u27a8\ube1c\u3443\u4abf\uc0ff", -893658610, -83759710));
                break;
            }
            case 6: {
                gtq.gwi(minecraftClient, a.d("\u421f\u3ba1\ub177\u2f06\ua49d\u2234\u987f\u11d0\u8fd1\u0573\u82b3\u78da\uf615\u6ffa\ue5e0\u6306\ud95a\u5698\ucc66\u4a33\uc3c3\ub999\u372c\uacec\u2a80\ua056\u19f7\u97e8\u0d54\u8b01\u00a6\ufe64\u742d\uedd2\u6ba4\ue13a\u5ef4\ud480\u5253\ucbef\u41a3", -618412454, -223771638));
                break;
            }
            case 7: {
                gtq.gwi(minecraftClient, a.b("\u2256\u5be8\ud13e\u4f4f\uc4d4\u4274\uf822\u71c7\uefc6\u6529\ue2f7\u1893\u965c\u0ffc\u85aa\u034f\ub95e\u36c8\uac62\u2a2b\ua3c4\ud9d8\u576f\uccb9\u4acd\uc01a\u79b8\uf7fa\u6d0a\ueb49\u60b4\u9e2d\u1475\u8d85\u0bed\u8177\u3eb1\ub4d7\u3204\uaba6\u21fb\u5f06\ud54e\u52ff\uc83d", -1924718051));
                break;
            }
            case 8: {
                gtq.gwi(minecraftClient, a.d("\ue91a\u90a4\u1a72\u8403\u0f98\u8924\u3369\uba8b\u248a\uae76\u29b6\ud3d2\u5d10\uc4b0\u4ef2\uc85d\u725f\ufd9d\u6737\ue17f\u68c5\u1290\u9c24\u07fe\u8187\u0b47\ub2e7\u3cb1\ua654\u204b\uabad\u5572\udf37\u46f2\uc08e\u4a23\uf5f9\u7f87\uf951\u60f8", 4331246, -1902772294));
                break;
            }
            case 9: {
                gtq.gwi(minecraftClient, a.c(1396571394, "\ufd40\u84fe\u0e28\u9059\u1bc2\u9d60\u2720\uae8f\u3083\uba2e\u3dec\uc78b\u494a\ud0ed\u5aa8\udc07\u661b\ue9d6\u7374\uf53c\u7cd2\u06ce\u8879\u13af\u95db\u1f0c\ua6ae\u28ec\ub21c\u345f\ubfa2\u413e\ucb67\u5283\ud4c1\u5e67"));
                break;
            }
            case 10: {
                gtq.gwi(minecraftClient, a.d("\ua8fb\ud15c\u5b9e\uc5f9\u4e20\uc892\u72cd\ufb34\u6520\uef87\u6842\u926d\u1ce4\u8544\u0f06\u89ba\u33f1\ubc27\u269f\ua0c8\u292e\u536c\uddd8\u461b\uc02a\u4aad\uf313\u7d4d\ue7a0\u61e0\uea44\u1489", -1625896399, 856777369));
                break;
            }
            case 11: {
                gtq.gwi(minecraftClient, a.b("\ue06e\u99c9\u130b\u8d6c\u06b5\u8007\u3a58\ub3a1\u2db5\ua710\u20d7\udaf8\u5471\ucdcd\u4781\uc162\u7b60\uf4b5\u6e01\ue85b\u61aa\u1bea\u954a\u0e9c\u88f1\u026e\ubb80\u35da\uaf2e\u2967\ua2d0\u5c06\ud652\u4fa2\uc9fa", 285532222));
                break;
            }
            case 12: {
                gtq.gwi(minecraftClient, a.d("\u2d78\u54c6\ude10\u4061\ucbfa\u4d46\uf709\u7efa\ue0b6\u6a59\uedd4\u17bc\u9972\u00ce\u8a89\u0c61\ub670\u39ec\ua34c\u250c\uacf9\ud6bb\u5845\uc390\u45e8\ucf32\u7687\uf8c7\u6223\ue475\u6fd4\u914b\u1b51\u82ae\u04f7\u8e72\u3196\ubbee\u3d39\ua49f\u2ed3\u5034\uda4f\u5dd5\uc717\u4971\uf0a3\u7a08\ufc5d\u678b\ue9e9\u1333\u9a9e\u1c86\u863c\u086b\ub3d3\u3512\ubf59", -1323861264, 1650218965));
                break;
            }
            case 13: {
                gtq.gwi(minecraftClient, a.b("\u2e39\u5787\udd51\u4320\uc8bb\u4e07\uf448\u7dba\ue3f7\u6918\uee95\u14e9\u9a22\u0390\u89d1\u0f2d\ub577\u3abe\ua053\u264e\uafab\ud5f7\u5b51\uc098\u46aa\ucc7f\u75cb\ufb91\u6160\ue720\u6c80\u9256\u180b\u81b4\u07bf\u8d05\u32c9\ub8a9\u3e71\ua7f7\u2d9b\u5363\ud934\u5e92\uc456\u4a31\uf3ca\u7950\uff0a\u64cc\ueabe\u1075\u99d8\u1f8e\u856c\u0b36\ub093\u360b\ubc31\u25e6\uab56\ud117\u56dc", -662884768));
                break;
            }
            case 40: {
                vlv2.set(a.c(-493386769, "\u83b9\ufa3b\u70e0\uee96"));
                kfe2.setEnabled(true);
                vbb.timing(true);
                break;
            }
            case 70: {
                vbb.gpuMillis();
                break;
            }
            case 80: {
                System.out.println(a.c(-971456152, "\uc117\ub8b4\u3276\uac53\u27c3\ua165\u1b33\u9297") + gtq.gwn(vbb.gpuMillis()) + a.b("\u7de6\u041a\u8ed7", 1559002565));
                gtq.gvz(minecraftClient, -90.0f, 12.0f, a.d("\ued3b\u948e\u1e4f\u8039", 324448106, 1517765168));
                break;
            }
            case 96: {
                if (System.getenv(a.d("\ub0b8\uc903\u43d3\uddba\u5608\ud0d4\u6a8b\ue361\u7d39\uf795\u7040", -1278611935, -789029164)) == null) break;
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
            case 100: {
                gtq.gvz(minecraftClient, 90.0f, 14.0f, a.d("\u20b3\u5910\ud3d5\u4da3", -1099689390, 1115959954));
                break;
            }
            case 120: {
                gtq.gvz(minecraftClient, 0.0f, 30.0f, a.b("\uf2c1\u8b6d\u01be\u9fc6", 120451767));
                break;
            }
            case 121: {
                gtq.gwi(minecraftClient, a.d("\u1eed\u6758\ueddb\u73ca\uf82e\u7ecc\uc492\u4d77\ud331\u59de\ude53\u242f\uaae7", 268330552, 505968812));
                break;
            }
        }
        if (gts > 130 && gts <= 160) {
            minecraftClient.field_1724.method_36456(-90.0f);
            minecraftClient.field_1724.method_5814(minecraftClient.field_1724.method_23317() + 0.22, minecraftClient.field_1724.method_23318(), minecraftClient.field_1724.method_23321());
        }
        switch (gts) {
            case 163: {
                minecraftClient.field_1690.method_31043(Perspective.field_26665);
                gtq.gvz(minecraftClient, -90.0f, 45.0f, a.c(1297525424, "\uaac6\ud375\u59bd\uc7cb\u4c06\ucab0"));
                break;
            }
            case 180: {
                minecraftClient.field_1690.method_31043(Perspective.field_26664);
                gtq.gvz(minecraftClient, 90.0f, 55.0f, a.d("\ud912\ua0a1\u2a69\ub41f\u3fd2\ub964\u0369\u8ad7\u148b\u9e38\u19e3", -1609147074, 361137239));
                break;
            }
            case 200: {
                gtq.gwi(minecraftClient, a.c(-913076713, "\u8e6d\uf7c1\u7d16\ue36f\u68fd\uee1f\u545a\uddba\u43b1\uc911\u4ec1\ub4b6\u3a65\ua3d4"));
                gtq.gvz(minecraftClient, 90.0f, 10.0f, a.d("\u6f3b\u168c\u9c44\u0228\u89e9\u0f49", 690032639, -618438479));
                break;
            }
            case 220: {
                gtq.gwi(minecraftClient, a.b("\u96d8\uef74\u65a3\ufbda\u7048\uf6aa\u4cef\uc50f\u5b04\ud1a4\u567e\uac07\u22d0\ubb61", 471439010));
                gtq.gvz(minecraftClient, -90.0f, 18.0f, a.c(-1065785098, "\u689d\u112b\u9bf6\u0588\u8e43"));
                break;
            }
            case 232: {
                ((vlv)gtq.gwg(kfe3, a.c(1800102697, "\u6360\u1af3\u902b\u0e5b"))).set(a.b("\uace9\ud56b\u5fa1\uc1d0", 640134315));
                kfe3.setEnabled(true);
                break;
            }
            case 236: {
                gtq.gvz(minecraftClient, -90.0f, 18.0f, a.b("\u4e18\u37ae\ubd73\u230d\ua8c6\u2e2e\u9436\u1dd4\u8392\u0923\u8efe\u749f\ufa53\u63ec\ue9b0\u6f5d", 2072071782));
                break;
            }
            case 250: {
                kfe3.setEnabled(false);
                gtq.gwi(minecraftClient, a.d("\u025e\u7bf2\uf125\u6f5c\ue4ce\u622c\ud869\u5189\ucf82\u4525\uc2f0\u3881\ub656", 1697673115, 1507749308));
                gtq.gwi(minecraftClient, a.d("\u3041\u49e2\uc335\u5d51\ud69a\u5026\uea62\u63c1\ufdcc\u776e\uf0b5\u0ac3", 150639497, 1294377907));
                ((vmc)gtq.gwg(kfe2, a.c(1246027265, "\ude40\ua7c7\u2d09\ub367\u38b3"))).set(1.0);
                gtq.gvz(minecraftClient, -90.0f, 55.0f, a.d("\ue63d\u9f9f\u1544\u8b32", 1285624296, 1593505699));
                break;
            }
            case 270: {
                gtq.gwi(minecraftClient, a.d("\u2078\u59db\ud30c\u4d68\uc6a3\u401f\ufa5b\u73f8\uede4\u675a\ue080\u1af5\u9431", 1108520102, -697922396));
                vlv2.set(a.b("\ub473\ucdfc\u4728\ud943\u5285\ud423", -1613777886));
                vbb.gpuMillis();
                gtq.gvz(minecraftClient, -90.0f, 12.0f, a.c(1722965214, "\u5ca3\u250c\uafd8\u31b3\uba75\u3cd3\u86df\u0f67\u913d\u1b94"));
                break;
            }
            case 285: {
                System.out.println(a.b("\u7fc0\u0667\u8cb0\u12d3\u9918\u1fa8\ua5b5\u2c03\ub24b\u38ff\ubf79\u455f\ucb96\u5220\ud869\u5e89\ue4d1\u6b52", -755466335) + gtq.gwn(vbb.gpuMillis()) + a.d("\u7a15\u03e9\u8924", -1643177633, -1742314647));
                break;
            }
            case 290: {
                gtq.gvz(minecraftClient, 150.0f, 8.0f, a.b("\ud838\ua197\u2b43\ub528\u3eee\ub848\u0244\u8bec\u15b5\u9f13\u18c0\ue2a7", 1387780163));
                break;
            }
            case 310: {
                gtq.gwi(minecraftClient, a.b("\ue2cf\u9b63\u11b4\u8fcd\u045f\u82bd\u38f8\ub118\u2f13\ua5b3\u2269\ud810\u56c7\ucf76", 1216078517));
                gtq.gvz(minecraftClient, -90.0f, 12.0f, a.c(-1877910384, "\u5ceb\u2544\uaf90\u31fb\uba3d\u3c9b\u8697\u0f25\u917d\u1bc2\u9c1e\u6673"));
                break;
            }
            case 330: {
                gtq.gwi(minecraftClient, a.c(-1000506329, "\u7c5e\u05f2\u8f25\u115c\u9ace\u1c2c\ua669\u2f89\ub182\u3b25\ubcf0\u4681\uc856"));
                vlv2.set(a.d("\u5eac\u273e\uadef\u3385\ub855\u3eed", -110341268, 2047217045));
                gtq.gvz(minecraftClient, 150.0f, 8.0f, a.b("\ud8af\ua11d\u2bcc\ub5a6\u3e76\ub8ce\u02d7\u8b6f\u1535\u9f9c", -700917546));
                break;
            }
            case 350: {
                vlv2.set(a.c(-1651424103, "\u44cc\u3d5b\ub790\u29e1\ua23e\u2498"));
                gtq.gvz(minecraftClient, -90.0f, -20.0f, a.c(1920178158, "\u9797\uee20\u64eb\ufa9a\u7145\uf7e3\u4def\uc457\u5a0d\ud0a4"));
                break;
            }
            case 370: {
                gtq.gwi(minecraftClient, a.b("\uf6af\u8f03\u05d4\u9bad\u103f\u96dd\u2c98\ua578\u3b73\ub1d3\u3609\ucc70\u42a7\udb16", 660797141));
                gtq.gvz(minecraftClient, 150.0f, 5.0f, a.c(664708650, "\ua655\udfe2\u5529\ucb58\u4087\uc621\u7c2d\uf59f\u6bc7\ue178\u66a4\u9cc9"));
                break;
            }
            case 390: {
                gtq.gwi(minecraftClient, a.c(-2001903143, "\u61a0\u180c\u92db\u0ca2\u8730\u01d2\ubb97\u3277\uac7c\u26db\ua10e\u5b7f\ud5a8"));
                vlv2.set(a.b("\uf01b\u899e\u034c\u9d3c\u16f3\u9041", -744624036));
                vbb.gpuMillis();
                gtq.gvz(minecraftClient, 150.0f, 8.0f, a.b("\u5fb2\u2617\uacc5\u32b5\ub97a\u3fc8\u85d8\u0c60\u923a\u1893", -396206119));
                break;
            }
            case 405: {
                System.out.println(a.b("\u73fb\u0a5c\u808b\u1ee8\u9523\u1393\ua98e\u2038\ube70\u34c4\ub342\u4972\uc7b1\u5e01\ud453\u52ba\ue8f6\u6769", 337343386) + gtq.gwn(vbb.gpuMillis()) + a.b("\u0c96\u756a\uffa7", -2144662347));
                break;
            }
            case 410: {
                gtq.gwi(minecraftClient, a.c(437507870, "\ud764\uaec8\u241f\uba66\u31f4\ub716\u0d53\u84b3\u1ab8\u9018\u17c2\uedbb\u636c\ufadd"));
                ((vlv)gtq.gwg(kfe3, a.c(-459944837, "\ucc32\ub5a1\u3f79\ua109"))).set(a.d("\u402c\u39ae\ub364\u2d15", 1598010928, 222819934));
                kfe3.setEnabled(true);
                break;
            }
            case 414: {
                gtq.gvz(minecraftClient, 150.0f, 8.0f, a.c(-804273509, "\uc2ed\ubb48\u319a\uafea\u2425\ua297\u1887\u9135\u0f6d\u85d2\u020e\uf863\u76ed\uef17\u6557\ue3bf\u59f0\ud62f\u4c8c\ucac6\u433f\u3961\ub7ce"));
                break;
            }
            case 430: {
                kfe3.setEnabled(false);
                kfe2.setEnabled(false);
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gwc(MinecraftClient minecraftClient) throws Exception {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(720668653, "\u87bd\ufe3e\u74e9\uea8d\u6146\ue7fa\u5dbe"));
        vlv vlv2 = (vlv)gtq.gwg(kfe2, a.d("\uc2bf\ubb38\u31ef\uaf8c\u2447\ua2f7", -1340581858, -1139303692));
        gur = a.c(-548175726, "\u80e2\uf94d\u7399\uedf2\u6634\ue092\u5a9e");
        switch (gts) {
            case 1: {
                gtq.gwi(minecraftClient, a.c(169841313, "\u92d7\ueb60\u61bf\uffc6\u7419\uf2aa\u48f2\uc102\u5f18\ud5ea\u5228\ua84e\u269d\ubf39\u3577\ub399\u09c5"));
                gtq.gwi(minecraftClient, a.b("\u5a16\u23ba\ua96d\u3714\ubc86\u3a64\u8021\u09c1\u97ca\u1d69\u9abd\u60c9\uee1e", -1022928273));
                gtq.gwi(minecraftClient, a.b("\uf770\u8ed3\u0404\u9a60\u11ab\u9717\u2d53\ua4f0\u3aec\ub052\u3788\ucdfd\u4339", -2079852790));
                gtq.gwi(minecraftClient, a.c(-1253792795, "\ua39a\uda2f\u50ac\ucebd\u4559\uc3bb\u79f8\uf019\u6e18\ue4f7\u6334"));
                break;
            }
            case 3: {
                gtq.gwi(minecraftClient, a.b("\ua9c9\ud077\u5aa1\uc4d0\u4f4b\uc9f7\u73bb\ufa4c\u6407\ueee8\u6968\u9305\u1dc3\u847f\u0e33\u88c4\u329f\ubd5c\u27e9\ua1ac\u2805\u5207\udca8\u4768\uc105\u4bd2\uf275\u7c69\ue69a\u60cc\ueb74\u15a3\u9ffd\u061f\u804b\u0ae8\ub571\u3f5d\ub99b\u2039\uaa74\ud485\u5efa\ud976\u43af\ucddd\u7402\ufebb", 1643096479));
                break;
            }
            case 4: {
                gtq.gwi(minecraftClient, a.c(-1789329160, "\u00ac\u7912\uf3c4\u6db5\ue62e\u6089\udacc\u5363\ucd62\u47de\uc016\u3a71\ub4b7\u2d06\ua744\u21eb\u9be9\u142b\u8e95\u08d8\u813e\ufb22\u7595\uee43\u6837\ue2e0\u5b42\ud500\u4ff0\uc9b3\u424e\ubcd6\u369e\uaf74\u2926\ua39c\u1c71\u963d\u10fe\u8954\u0301\u7df8\uf7b3\u7051\ueace\u64b8\udd68\u57d9\ud195\u4a5c"));
                break;
            }
            case 5: {
                gtq.gwi(minecraftClient, a.d("\ua2de\udb60\u51b6\ucfc7\u445c\uc2f8\u78be\uf111\u6f04\ue5a1\u627f\u9814\u16d4\u8f74\u0524\u83c7\u39d6\ub64d\u2cea\uaaab\u234c\u5950\ud7e7\u4c31\uca45\u4092\uf930\u7772\ued82\u6bc1\ue03c\u1ea4\u94e8\u0d1b\u8b4f\u01e8\ube39\u3472\ub28e\u2b23\ua171\udf8f\u55d9\ud270", 956490361, -221626131));
                break;
            }
            case 6: {
                gtq.gwi(minecraftClient, a.d("\udc4a\ua5f4\u2f22\ub153\u3ac8\ubc61\u062a\u8f85\u1195\u9b35\u1ceb\ue686\u6840\uf1e8\u7ba2\ufd0d\u470e\uc8cd\u5273\ud43e\u5dd8\u27c4\ua973\u32a5\ub4d1\u3e06\u87a4\u09e6\u9316\u1555\u9ea8\u6022\uea65\u738f", 371111814, 1814522760));
                break;
            }
            case 7: {
                gtq.gwi(minecraftClient, a.c(-1806098806, "\u1ec6\u6778\uedae\u73df\uf844\u7ef8\uc4bf\u4d57\ud356\u59b9\ude67\u2408\uaacc\u3370\ub937\u3fdf\u85ce\u0a55\u90f2\u16ae\u9f47\ue505\u6bfb\uf02e\u7656\ufc8c\u4539\ucb79\u519d\ud7cb\u5c6a\ua2f5\u28f3\ub101\u3750\ubde6\u0227\u8850\u0eb9\u973b\u1d67\u639e"));
                break;
            }
            case 8: {
                gtq.gwi(minecraftClient, a.b("\ue227\u9b99\u114f\u8f3e\u04a5\u8219\u3856\ub1a7\u2fe9\ua506\u2298\ud8fa\u5620\ucf89\u45cf\uc333\u7966\uf6a0\u6c4d\uea57\u63b5\u19e9\u9746\u0c86\u8ab4a\ub9d5\u378f\uad7e\u2b3e\ua09e\u5e48\ud415\u4daa\ucbb0\u4102\ufed7\u74a1\uf264\u6bd3\ue1b6\u9f74\u152e\u929b\u085b\u8639\u3ffc\ub565\u3301\ua8c5\u26a1\udc71\u55dc\ud397\u4963\uc723\u7c97\ufa5c\u7066\ue9fe\u674f\u1d19\u9afa\u1093", -875240959));
                break;
            }
            case 9: {
                gtq.gwi(minecraftClient, a.d("\u0d20\u749e\ufe48\u6039\ueba2\u6d1e\ud753\u5eb1\uc0b0\u4a52\ucd9d\u37fd\ub93c\u209b\uaadb\u2c39\u9628\u19aa\u8305\u0545\u8ca3\uf6f2\u7850\ue3cc\u65b7\uef61\u56d9\ud88e\u4268\uc42a\u4f9e\ub15d\u3b5c\ua2e0\u24a5\uae01\u11c7\u9ba1", 804623126, -880763274));
                break;
            }
            case 10: {
                gtq.gwi(minecraftClient, a.c(-351982886, "\u2a9a\u5324\ud9f2\u4783\ucc18\u4abd\uf0fa\u7955\ue754\u6df0\uea36\u1051\u9e90\u077f\u8d72\u0b9a\ub1cc\u3e50\ua4e7\u22b1\uab4d\ud11a\u5fb8\uc47a\u4202\uc8c1\u713c\uff34\u65cf\ue393\u6820\u96ff\u1cb9\u855e\u030a\u89a0\u3676\ubc0c"));
                break;
            }
            case 11: {
                gtq.gwi(minecraftClient, a.d("\uf685\u8f3b\u05ed\u9b9c\u1007\u96a3\u2ce5\ua54a\u3b5a\ub1fa\u363f\ucc58\u4299\udb3e\u5133\ud78d\u6dd3\ue21a\u78b1\ufead\u775e\u0d08\u83b0\u1867\u9e09\u14cb\uad7f\u233c\ub985\u3f8d\ub432\u4aee\uc0a1\u595e\udf04\u55a3\uea73\u6019\ue6cb\u7f71", 1708252346, 495790705));
                break;
            }
            case 12: {
                gtq.gwi(minecraftClient, a.c(-488990478, "\u98a3\ue104\u6bc6\uf5a1\u7e78\uf8ca\u4295\ucb6c\u5578\udfc4\u580e\ua26b\u2ce2\ub50d\u3f53\ub9b7\u03e0\u8c7c\u16cb\u909d\u1961\u6336\ued94\u7656\uf02e\u7aed\uc310\u4d17\ud7ed\u51b3\uda1a\u24da\uae82\u376f"));
                break;
            }
            case 13: {
                gtq.gwi(minecraftClient, a.d("\u04e8\u7d56\uf780\u69f1\ue26a\u64d6\ude99\u576f\uc926\u43c9\uc444\u3e26\ub0e2\u295e\ua311\u25e5\u9fbe\u1031\u8aca\u0c8d\u856f\uff2b\u71d5\uea00\u6c78\ue6a2\u5f17\ud157\u4bb3\ucde5\u4644\ub8db\u32df\uab2a\u2d6d\ua7cf\u181e\u9261\u1497\u8d09\u074f\u79bb\uf3e8\u7454\uee90", 1004256995, -1514685888));
                break;
            }
            case 14: {
                gtq.gwi(minecraftClient, a.b("\uac24\ud59a\u5f4c\uc13d\u4aa6\ucc1a\u7656\uffb5\u61b4\ueb5b\u6c85\u96e8\u183c\u819f\u0bde\u8d3d\u372c\ub8b2\u2210\ua44c\u2da7\u57f5\ud954\u42c8\uc4b3\u4e65\uf7dd\u798a\ue36c\u652e\uee9a\u1059\u9a58\u03fc\u85a1\u0f1a\ub0f9\u3ab1\ubc61\u25db\uaf89\ud17e", 24489064));
                break;
            }
            case 40: {
                vlv2.set(a.d("\ud025\ua9aa\u237e\ubd15\u36d3\ub075", -2090495806, -1825554250));
                kfe2.setEnabled(true);
                vbb.timing(true);
                break;
            }
            case 70: {
                vbb.gpuMillis();
                break;
            }
            case 90: {
                System.out.println(a.c(-1261084814, "\u5f0e\u26a1\uac75\u321e\ub9d8\u3f7e\u857f\u0cc9\u9281\u1835\u9fb3") + gtq.gwn(vbb.gpuMillis()) + a.d("\udf22\ua6de\u2c13", 1204550808, 1100882841));
                gtq.gvz(minecraftClient, -90.0f, 14.0f, a.d("\uc824\ub190\u3b5b\ua57e\u2ee1\ua854\u1215\u9be3", -667566279, -308775055));
                break;
            }
            case 110: {
                gtq.gvz(minecraftClient, -135.0f, 10.0f, a.c(-1879836220, "\uf9a9\u801f\u0ad6\u94a1\u1f60"));
                break;
            }
            case 130: {
                gtq.gvz(minecraftClient, 108.0f, -8.0f, a.c(-1247176235, "\u99a4\ue013\u6ad7\uf4a6\u7f67"));
                break;
            }
            case 150: {
                gtq.gvz(minecraftClient, 0.0f, 25.0f, a.c(-1042689983, "\ud02b\ua990\u2345"));
                break;
            }
            case 170: {
                gtq.gvz(minecraftClient, -36.0f, 24.0f, a.c(2135329422, "\u8af8\uf34e\u798c\ue7e8\u6c3c"));
                break;
            }
            case 180: {
                gtq.gvz(minecraftClient, 30.0f, 62.0f, a.d("\ue222\u9b9c\u114c\u8f21\u04e0", 1491436436, 952394192));
                break;
            }
            case 190: {
                gtq.gwi(minecraftClient, a.d("\u544f\u2dfa\ua779\u3968\ub28c\u346e\u8e30\u07de\u9983\u1322\u94af\u6e80\ue046\u79fe", 2057489660, 1234802889));
                break;
            }
        }
        if (gts > 203 && gts <= 233) {
            minecraftClient.field_1724.method_36456(-90.0f);
            minecraftClient.field_1724.method_5814(minecraftClient.field_1724.method_23317() + 0.2, minecraftClient.field_1724.method_23318(), minecraftClient.field_1724.method_23321());
        }
        switch (gts) {
            case 236: {
                gtq.gvz(minecraftClient, 90.0f, 55.0f, a.d("\ub375\ucac6\u400e\ude78\u55b5\ud303", -633206660, -1367229569));
                break;
            }
            case 250: {
                gtq.gwi(minecraftClient, a.b("\u6b09\u12bc\u983f\u062e\u8dca\u0b28\ub16b\u388a\ua68b\u2c64\uaba7", 410348406));
                gtq.gwi(minecraftClient, a.c(606020315, "\u22a1\u5b0d\ud1da\u4fa3\uc431\u42d3\uf896\u7176\uef7d\u65dd\ue20d\u187c\u96a9\u0f18"));
                vbb.gpuMillis();
                break;
            }
            case 270: {
                gtq.gvz(minecraftClient, -100.0f, 10.0f, a.d("\udc25\ua592\u2f5a\ub136\u3af7\ubc57", -346201939, 1125956861));
                break;
            }
            case 282: {
                System.out.println(a.d("\uf538\u8c97\u0643\u9828\u13ee\u9548\u2f49\ua6ff\u38b7\ub203\u3585\ucfa7\u4176\ud8dc\u5292\ud475\u6e2b\ue1ae", -76047171, 302672352) + gtq.gwn(vbb.gpuMillis()) + a.b("\ud371\uaa8d\u2040", -1805790382));
                gtq.gwi(minecraftClient, a.d("\u91de\ue872\u62a5\ufcdc\u774e\uf1ac\u4be9\uc209\u5c02\ud6a2\u5178\uab01\u25d6\ubc67", 866896910, -2121310806));
                break;
            }
            case 310: {
                gtq.gvz(minecraftClient, 60.0f, 12.0f, a.b("\u13d0\u6a66\ue0bb\u7ec5\uf50e", -1731062853));
                break;
            }
            case 325: {
                gtq.gwi(minecraftClient, a.d("\u725c\u0bf0\u8127\u1f5e\u94cc\u122e\ua86b\u218b\ubf80\u3527\ub2f2\u4883\uc654", 1763645492, -1151112687));
                ((vmc)gtq.gwg(kfe2, a.c(1046649219, "\u99da\ue05a\u6a9a\uf4ed\u7f27\uf99c\u43c0\uca38\u5471"))).set(1.0);
                break;
            }
            case 345: {
                vbb.gpuMillis();
                gtq.gvz(minecraftClient, -60.0f, 6.0f, a.b("\u6199\u1825\u92f2\u0c94\u874c", -287677964));
                break;
            }
            case 357: {
                System.out.println(a.d("\u8e26\uf789\u7d5d\ue336\u68f0\uee56\u5457\udde1\u43a9\uc91d\u4e9b\ub4a2\u3a78\ua3cd\u2989\uaf77\u1561", -281807792, 1605270032) + gtq.gwn(vbb.gpuMillis()) + a.d("\u22da\u5b26\ud1eb", 1255159820, -595256587));
                break;
            }
            case 360: {
                ((vmc)gtq.gwg(kfe2, a.d("\u0b8f\u720f\uf8cf\u66b8\ued72\u6bc9\ud195\u586d\uc624", 177237836, -1829477222))).set(0.6);
                minecraftClient.field_1724.method_36456(-90.0f);
                minecraftClient.field_1724.method_36457(30.0f);
                break;
            }
            case 380: {
                vbb.gpuMillis();
                break;
            }
            case 440: {
                System.out.println(a.c(-2075273866, "\ud513\uacbc\u2668\ub803\u33c5\ub563\u0f62\u86d4\u189c\u9228\u15ae\uef98\u615a\uf8f6\u72bf\uf455\u4e10\uc185") + gtq.gwn(vbb.gpuMillis()) + a.c(686550971, "\uef98\u9664\u1ca9"));
                break;
            }
            case 445: {
                kfe2.setEnabled(false);
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gwd(String string) {
        System.out.println(a.c(1672833861, "\u6b2b\u1293\u9848\u067e\u8dee\u0b48\ub11e\u38ba") + string + a.d("\ub2c8", 739107060, 2134200861) + gtq.gwn(vaf.gpuMillis()) + a.d("\u8255\ufba9\u7164", 177424450, -285095372));
    }

    private static void gwe(MinecraftClient minecraftClient) throws Exception {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        kfe kfe2 = kfx2.getByName(a.c(-2068583380, "\uec60\u95e2\u1f28\u8159\u0aa0\u8c21\u3669\ubf96\u21c6\uab6b"));
        kfe kfe3 = kfx2.getByName(a.c(-1287073067, "\ud29c\uab1b\u21ce\ubfb8\u3474\ub2c7\u08ad\u8161\u1f3a\u9583"));
        switch (gts) {
            case 1: {
                gtq.gwi(minecraftClient, a.c(1469341506, "\u5f34\u2683\uac5c\u3225\ub9fa\u3f49\u8511\u0ce1\u92fb\u1809\u9fcb\u65ad\ueb7e\u72da\uf894\u7e7a\uc426"));
                gtq.gwi(minecraftClient, a.b("\uea9b\u9337\u19e0\u8799\u0c0b\u8ae9\u30ac\ub94c\u2747\uade0\u2a35\ud044\u5e93", -2085623070));
                minecraftClient.field_1724.method_36456(0.0f);
                minecraftClient.field_1724.method_36457(15.0f);
                break;
            }
            case 5: {
                gtq.gwi(minecraftClient, a.b("\u5c52\u25ec\uaf3a\u314b\ubad0\u3c3f\u863f\u0fd7\u919c\u1b73\u9cf3\u669e\ue858\u71b7\ufbb7\u7d5f\uc704\u488b\ud272\u5437\udd9e\ua785\u2922\ub2ad\u3498\ube5d\u07a3\u89f6\u1306\u955c\u1ee9\ue029\u6a75\uf383\u75c2\uff3d\u40a3\ucad5\u4c1d\ud5ad\u5ff9\u214d\uab56\u2ce0\ub634\u3845\u8195\u0b3c", 283008004));
                break;
            }
            case 50: {
                gtq.gwp(minecraftClient, a.d("\uc053\ub9f2\u333a\uad45\u269d\ua030\u1a3a\u9394\u0dd6\u8767\u00b6\ufa87\u7412\uedaa\u67f9", -799052107, -880759157));
                break;
            }
            case 51: {
                ((vlv)gtq.gwg(kfe2, a.d("\ua40f\udd9c\u5744\uc934", 1958431251, 1205923413))).set(a.b("\ud517\uac95\u265f\ub82e", 1599591765));
                kfe2.setEnabled(true);
                break;
            }
            case 80: {
                gtq.gwp(minecraftClient, a.b("\ua3a3\uda02\u50ca\uceb5\u456d\uc3c0\u79ca\uf064\u6e26\ue497\u6346\u9977\u17eb\u8e49\u0403\u82f2", -1634163759));
                gtq.gwf(minecraftClient, a.d("\u775e\u0ef2\u8421\u1a52\u91c8\u173f\uad7f\u2497\ubac8", 124682602, 584840783), 15.0, 16.0);
                break;
            }
            case 81: {
                ((vlv)gtq.gwg(kfe2, a.d("\u1640\u6fd3\ue50b\u7b7b", 2005859398, -1317082545))).set(a.d("\u43db\u3a5e\ub08c\u2ee6", 1735087727, -1071901199));
                break;
            }
            case 130: {
                gtq.gwp(minecraftClient, a.b("\u2bf5\u5254\ud89c\u46e3\ucd3b\u4b96\uf19c\u7832\ue670\u6cc1\ueb10\u1121\u9fba\u061f\u8c4d\u0aa7", -1517540473));
                gtq.gwf(minecraftClient, a.b("\ucbf0\ub25c\u388f\ua6fc\u2d66\uab96\u11d1\u9821\u0665", 1929235339), 6.5, 8.0);
                break;
            }
            case 131: {
                gtq.gwi(minecraftClient, a.c(-786346662, "\u4d19\u34a7\ube71\u2000\uab9b\u2d74\u9774\u1e9c\u80d7\u0a38\u8db5\u779a\uf91e\u60b6\ueaf1\u6c5e\ud65b\u599e\uc373\u4568\ucc8b\ub684\u387d\ua3b8\u258a\uaf5f\u16eb\u98b1\u0240\u8400\u0fa0\uf176\u7b2b\ue294\u649c\uee25\u51e9"));
                break;
            }
            case 190: {
                gtq.gwp(minecraftClient, a.c(129634468, "\u10c9\u6968\ue3a0\u7ddf\uf607\u70aa\ucaa0\u4318\udd42\u57eb\ud06c\u2a51\ua492\u3d22\ub76a"));
                gtq.gwf(minecraftClient, a.c(1470657347, "\u732f\u0a9b\u8050\u1e78\u95ee\u134b\ua919\u20f3"), 0.0, 1.05);
                break;
            }
            case 191: {
                ((vmc)gtq.gwg(kfe3, a.c(-587588666, "\u1b96\u621a\ue8cd\u76b4"))).set(0.0);
                kfe3.setEnabled(true);
                break;
            }
            case 260: {
                boolean bl;
                gtq.gwp(minecraftClient, a.d("\u2514\u5cb5\ud67d\u4802\uc3da\u4577\uff7d\u76cf\ue897\u6228\ue5f4\u1f99\u9117\u08ea\u82ad\u045d\ube09", -907104148, 1262523659));
                gtq.gwf(minecraftClient, a.b("\uda78\ua3ce\u2913\ub76d\u3ca6\uba43Q\u89b4\u17ea\u9d40", 187226652), 1.2, 1.7);
                long l = Math.floorMod(minecraftClient.field_1687.method_8532(), 24000L);
                boolean bl2 = bl = l == 18000L;
                if (!bl) {
                    ++gut;
                }
                System.out.println(a.d("\u01ea\u784b\uf283\u6cfc\ue724\u6189\udb8e\u523c\ucc75\u46c2\uc116\u3b7c\ub5a9\u2c55\ua652\u20be\u9af5\u152c\u8fda", -306545626, 1281195453) + (bl ? a.d("\ua7eb\ude5e", 1894032259, 1656030213) : a.d("\uf88f\u8139\u0be2\u9596", -1301173535, 141906476)) + a.c(-1644983114, "\u8c9d\uf578\u7fb6\ue1c3\u6a1c\uec87\u56fd\udf2e\u4154\ucbfd\u4c6a") + l);
                break;
            }
            case 261: {
                kfe2.setEnabled(false);
                break;
            }
            case 280: {
                boolean bl;
                gtq.gwp(minecraftClient, a.b("\uc531\ubc90\u3658\ua827\u23ff\ua552\u1f58\u96ea\u08b2\u820d\u05d1\uffbc\u7132\ue8c1\u629b\ue46a", -1587034813));
                double d = (Double)minecraftClient.field_1690.method_42473().method_41753();
                boolean bl3 = bl = d >= 0.0 && d <= 1.0;
                if (!bl) {
                    ++gut;
                }
                System.out.println(a.b("\u7aa7\u0306\u89ce\u17b1\u9c69\u1ac4\ua0c3\u2975\ub72c\u3d91\uba42\u403f\ucea9\u575a\udd0a\u5bf9\ue1be\u6e24", -1208124713) + (bl ? a.b("\ue9c3\u9076", -2120750674) : a.d("\ucea4\ub712\u3dc9\ua3bd", -662431457, -1969760263)) + a.c(-969967984, "\u76b7\u0f41\u8594\u1be9\u903e\u1683\uac8c") + d);
                break;
            }
            case 281: {
                kfe2.setEnabled(true);
                break;
            }
            case 300: {
                boolean bl;
                minecraftClient.field_1690.method_1640();
                String string = a.b("\ueb3a", -1559368956);
                for (String string2 : Files.readAllLines(minecraftClient.field_1697.toPath().resolve(a.c(23898258, "\ua8f6\ud158\u5b8f\uc5e3\u4e32\uc882\u72cc\ufb60\u6565\uefd8\u6807")))) {
                    if (!string2.startsWith(a.b("\u9cb3\ue504\u6fdb\uf1aa\u7a71\ufc9b", -523920174))) continue;
                    string = string2.substring(6);
                }
                boolean bl4 = bl = !string.equals(a.b("\ubbd5", 1319353323)) && Double.parseDouble(string) <= 1.0;
                if (!bl) {
                    ++gut;
                }
                System.out.println(a.b("\u7e03\u07a2\u8d6a\u1315\u98cd\u1e60\ua467\u2dc5\ub388\u392e\ubeee\u449e\uca0d\u53fb\ud9ae\u5f53\ue51c\u6ac1\uf033", -832799118) + (bl ? a.c(1401663725, "\ub080\uc935") : a.c(-1882037817, "\u6185\u1833\u92e8\u0c9c")) + a.b("\u08d2\u712c\ufbe0\u6595\uee5f\u68e8\ud2ba\u5b56\uc554\u4fbf\uc860\u321d\ubc9e\u2568\uaf3d\u29c0\u938f\u1c52\u86bd", -2018637599) + string + a.c(316644406, "\u9c10\ue5ed\u6f3b\uf155\u7a91\ufc78") + minecraftClient.field_1690.method_42473().method_41753());
                break;
            }
            case 301: {
                kfe2.setEnabled(false);
                kfe3.setEnabled(false);
                break;
            }
            case 310: {
                boolean bl;
                long l = Math.floorMod(minecraftClient.field_1687.method_8532(), 24000L);
                boolean bl5 = bl = l != 18000L;
                if (!bl) {
                    ++gut;
                }
                System.out.println(a.c(-780323033, "\u375d\u4efc\uc434\u5a4b\ud193\u573e\ued39\u649b\ufad2\u7074\uf7a3\u0dc1\u8301\u1ae2\u90e5\u1609\uac42\u239b\ub96d\u3f7e\ub68a\uccd9\u4262\ud9f8") + (bl ? a.b("\ud60a\uafbf", 454350439) : a.d("\u80e3\uf955\u738e\uedfa", -1346268083, -650177300)) + a.c(-2018014189, "\u8c38\uf5dd\u7f13\ue166\u6ab9\uec22\u5658\udf8b\u41f1\ucb58\u4ccf") + l);
                gtq.gwp(minecraftClient, a.d("\ud9d1\ua070\u2ab8\ub4c7\u3f1f\ub9b2\u03b8\u8a10\u1452\u9ee7\u193c\ue305\u6d90\uf428\u7e7b", -214188752, -1265539956));
                System.out.println(a.d("\u302f\u498e\uc346\u5d39\ud6e1\u504c\uea4b\u63ee\ufda0\u7707\uf0d3\u0af6", -677737159, -530334344) + (gut == 0 ? a.d("\ud425\uad85\u2744\ub935", -938493382, 324628043) : a.c(-1454373841, "\u046f\u7dd9\uf702\u6976\ue2cd\u6474") + gut + a.c(-630462664, "\ue710")));
                minecraftClient.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gwf(MinecraftClient minecraftClient, String string, double d, double d2) {
        boolean bl;
        double d3 = (Double)minecraftClient.field_1690.method_42473().method_41753();
        boolean bl2 = bl = d3 >= d && d3 <= d2;
        if (!bl) {
            ++gut;
        }
        System.out.println(a.d("\u501a\u29bb\ua373\u3d0c\ub6d4\u3079\u8a7e", -1705687308, -919726453) + string + (bl ? a.d("\u9a1e\ue3e0\u6937", 1393945361, -1532530388) : a.d("\u9fc7\ue610\u6cc4\uf2bd\u796f", 1255483176, -1725712182)) + a.d("\uc2fe\ubb08\u31dd\uafa0\u2477\ua2ca\u18c5", 210917816, -561996959) + String.format(Locale.ROOT, a.b("\u67f3\u1e49\u9486\u0aa3", -20944942), d3) + a.b("\u7827\u019e\u8b12\u1575\u9ead\u1806\ua201", 300447744) + d + a.c(1758512704, "\uc66c\ubfdd") + d2 + a.c(173726263, "\uda1f"));
    }

    private static vmo gwg(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.b("\ua1cc\ud835\u52ef\ucc8c\u4708\uc1f7\u7ba5\uf21b", -1050369564) + string);
    }

    private static void gwh(MinecraftClient minecraftClient, String string, int n, int n2) {
        boolean bl;
        pbz pbz2 = pbz.get();
        int n3 = 0;
        try {
            for (Field field : BossBarHud.class.getDeclaredFields()) {
                if (!Map.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                n3 = ((Map)field.get(minecraftClient.field_1705.method_1740())).size();
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            n3 = -1;
        }
        boolean bl2 = bl = (n < 0 || pbz2.count() == n) && n3 == n2;
        if (!bl) {
            ++guo;
        }
        System.out.println(a.d("\u394d\u40fb\uca2e\u5458\udf99\u593f\ue36d\u6a9b\uf4d3\u7e74\uf9f4", 1474710363, -1200262546) + string + (bl ? a.c(122131819, "\u9548\uecb6\u6661") : a.c(-2072008822, "\ua7af\ude78\u54ac\ucad5\u4107")) + a.b("\u3daf\u445d\uce82\u50e9\udb25\u5d8e\ue794", -1127203448) + pbz2.count() + a.b("\u129d\u6b6e\ue1be\u7fdc\uf40a\u72f5", -33418565) + n3 + a.b("\ua59c\udc37\u56fe", 968533439) + pbz2.describe());
    }

    private static void gwi(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void gwj(MinecraftClient minecraftClient, String string, String string2, int n) {
        gtq.gwi(minecraftClient, a.c(-430470675, "\u8986\uf038\u7ae2\ue497\u6f53\ue9b0\u5383\uda41"));
        gtq.gwi(minecraftClient, a.b("\uf538\u8c94\u0656\u982f\u13b5\u9556\u2f12\ua6f6\u38b5\ub209\u35d8\ucfaf\u413d\ud8c9\u5291\ud47a\u6e28\ue1e4\u7b5a\ufd52\u74c5\u0ea7\u8047\u1bde\u9da6\u176c\uaec9\u209b\uba7f\u3c72\ub7df\u491e\uc306\u5ae9\udca7\u560a\ue995\u63a9\ue57e\u7cc8\uf69c\u886b\u0229\u858b\u1f5b\u9138\u28a5\ua24a\u2408\ubfd1\u31ae\ucb7d\u42cb\uc490\u5e58\ud025\u6b9e\ued57\u6739\ufefe", -1916930707));
        gtq.gwi(minecraftClient, a.c(1972655046, "\u53b8\u2a14\ua0d6\u3eaf\ub535\u33d6\u8992v\u9e35\u1489\u9358\u692f\ue7bd\u7e49\uf411\u72fa\uc8a8\u4764\uddda\u5bd2\ud245\ua827\u26c7") + string + a.d("\u3876\u4190\ucb5d\u5531\udefa\u5803\ue21d\u6be8\uf5b0\u7f0a\uf8df\u02bf\u8c7b\u15cd\u9f8c\u1933\ua331\u2cfe\ub64a\u3011\ub9dd\uc3b0\u4d08\ud6d0\u50bc\uda78\u63c9\ueddd\u7732", -1921453858, 1014876309));
        gtq.gwi(minecraftClient, a.d("\u14f0\u6d5c\ue79e\u79e7\uf27d\u749e\uceda\u473e\ud97d\u53c1\ud410\u2e67\ua0f5\u3901\ub359\u35b2\u8fe0,\u9a92\u1c9a\u950d\uef6f\u618f", -845358937, 273206313) + string2 + a.b("\uc57e\ubc98\u3655\ua839\u23f2\ua50b\u1f15\u96e0\u08b8\u8202\u05d7\uffb7\u7173\ue8c5\u6284\ue43b\u5e23\ud1fe\u4b4f\ucd18", 993772874));
        minecraftClient.field_1724.method_31548().method_61496(n);
    }

    private static void gwk(MinecraftClient minecraftClient, kfe kfe2, int n, float f) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        clientPlayerEntity.method_31548().method_61496(0);
        clientPlayerEntity.method_36457(f);
        gui = f;
        gug = Float.NaN;
        guh = guf = clientPlayerEntity.method_23318();
        System.out.println(a.d("\u3e55\u47fa\ucd2e\u5355\ud8c6\u5e27\ue476\u6d90\uf3d9\u7968\ufef2\u0499\u8a01\u13b1\u99cb\u1f0f\ua55d\u2a96\ub03e\u3665\ubfcb", 491472758, 1215723841) + clientPlayerEntity.method_24828() + a.b("\u57cb\u2e23\ua4b4", -846440472) + gtq.gwn(clientPlayerEntity.method_23318()) + a.b("\ub5d5\ucc2c\u46f2\ud88a\u5355\ud5bd", 1637201395) + clientPlayerEntity.method_6047().method_7909() + a.d("\u7117\u08f5\u8239\u1c4b\u9787\u117f", 1261483360, 1911931985) + clientPlayerEntity.method_31548().method_67532());
        kfe2.onKey(minecraftClient, n);
    }

    private static void gwl(MinecraftClient minecraftClient, String string) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        System.out.println(a.d("\u286d\u51c2\udb16\u456d\ucefe", 144123815, 15077304) + string + a.d("\u884a\uf1af", 177890526, 901901494) + gts + a.b("\u4670\u3fdb\ub54a\u2b2c\ua0fd\u2646\u9c51", 1780172365) + oxw.busy() + a.b("\u733d\u0ac4\u801e\u1e60\u95bd\u1355", 1035432731) + clientPlayerEntity.method_6047().method_7909() + a.b("\u439e\u3a7c\ub0b0\u2ec2\ua50e\u23f6", 1785938872) + clientPlayerEntity.method_31548().method_67532() + a.b("\u975e\ueebf\u6475\ufa19\u71d9\uf763\u4d65", 1745131385) + gtq.gwn(clientPlayerEntity.method_36455()) + a.d("\u8feb\uf603\u7c94", -1302285060, 1823095604) + gtq.gwn(clientPlayerEntity.method_23318()) + a.d("\ubec0\uc727\u4dfb\ud3ce", -111721954, 55573754) + gtq.gwn(clientPlayerEntity.method_18798().field_1351));
    }

    private static void gwm(MinecraftClient minecraftClient, String string, Item item, int n, int n2, int n3, double d, double d2) {
        double d3;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        ItemStack itemStack = playerInventory.method_5438(n);
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder();
        if (!clientPlayerEntity.method_6047().method_31574(item)) {
            bl = false;
            stringBuilder.append(a.b("\u02b3\u7b4a\uf190\u6fee\ue433\u62db", -155909483)).append(clientPlayerEntity.method_6047().method_7909());
        }
        if (!itemStack.method_31574(Items.field_49098) || itemStack.method_7947() != n2) {
            bl = false;
            stringBuilder.append(a.b("\u706e\u099c\u8344\u1d3c\u96f8\u105c\uaa0d\u23d9", 216559686)).append(n).append('=').append(itemStack);
        }
        if (playerInventory.method_67532() != n3) {
            bl = false;
            stringBuilder.append(a.d("\udd0c\ua4ee\u2e22\ub050\u3b9c\ubd64", 1121388467, 433183385)).append(playerInventory.method_67532());
        }
        if (Float.isNaN(gug) || Math.abs(gug - gui) > 0.01f) {
            bl = false;
            stringBuilder.append(a.c(1399697156, "\uaf23\ud6c2\u5c08\uc264\u49a4\ucf1e\u7518")).append(gtq.gwn(gug));
        }
        if ((d3 = guh - guf) < d || d3 > d2) {
            bl = false;
            stringBuilder.append(a.b("\ucea3\ub740\u3d8e\ua3e3\u2822\uaed6", -1891250555)).append(gtq.gwn(d3)).append(a.c(-606228965, "\uae3c\ud785\u5d09\uc36e\u48b6\uce1d\u741a")).append(gtq.gwn(d)).append(a.b("\u7554\u0ce5", 2122937720)).append(gtq.gwn(d2)).append(')');
        }
        if (oxw.busy()) {
            bl = false;
            stringBuilder.append(a.d("\ubd70\uc492\u4e46\ud02a\u5bf8\udd49\u6756\ueee5\u70ad\ufa1a\u7dc3", -105995072, -992732773));
        }
        if (!bl) {
            ++guj;
        }
        System.out.println(a.c(-976385626, "\u89d4\uf07b\u7aaf\ue4d4\u6f47") + string + (bl ? a.d("\u0313\u7aed\uf03a", 761071001, 1451230889) : a.d("\u010b\u78dc\uf208\u6c71\ue7a3", -741692668, 1763551786) + stringBuilder) + a.b("\u4b52\u32e3\ub838\u2613\uadd9\u2b74\u9131\u1885", -1249096838) + gtq.gwn(guh - guf) + a.c(73767034, "\u9851\ue1ec\u6b77\uf50f\u7ed7\uf86c\u427b") + clientPlayerEntity.method_6047().method_7909() + a.c(-31845278, "\u144a"));
    }

    private static String gwn(double d) {
        return String.format(Locale.ROOT, a.b("\ud2d7\uab6d\u21a2\ubf87", 427807478), d);
    }

    private static void gwo() {
        ++gtr;
        gts = 0;
    }

    private static void gwp(MinecraftClient minecraftClient, String string) {
        System.out.println(a.c(2030422834, "\ucb4b\ub2ec\u3836\ua64d\u2ddc\uab39\u117b\u989c\u06c4\u8c21") + string + a.b("\udfda\ua60b\u2cb8", 1520164857) + minecraftClient.method_47599() + a.b("\u1d52\u64a5\uee60\u7012\ufb9a\u7d27\uc727\u4ec6\ud088\u5a2e\uddfd\u2787\ua903", -1595859585) + (minecraftClient.field_1755 == null ? a.d("\u4de6\u3456\ube84\u20fe", 787818442, -386373050) : minecraftClient.field_1755.getClass().getSimpleName()));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.b("\u78ab\u0110\u8bc0\u15a9\u9e3b\u1895", -2065401653) + string + a.d("\ubd16\uc4f9\u4e34\ud04c", -1404631574, -1589135146)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static void gwq(Screen screen, int n) {
        if (screen != null) {
            screen.method_25404(new KeyInput(n, 0, 0));
        }
    }

    private static void gwr(Screen screen, String string) {
        if (screen != null) {
            for (char c : string.toCharArray()) {
                screen.method_25400(new CharInput((int)c, 0));
            }
        }
    }

    private static void gws(Screen screen, float f, float f2, int n) throws Exception {
        if (!(screen instanceof hlc)) {
            return;
        }
        float f3 = gtq.gwu(screen, a.b("\ud867\ua1cb\u2b03\ub57c\u3ea5\ub813\u0276", 1040242703));
        float f4 = gtq.gwu(screen, a.d("\u2898\u5134\udbfc\u4583\uce5a\u48ec\uf288", -1828865134, -1146252446));
        float f5 = gtq.gwu(screen, a.b("\u6c82\u1523\u9ff2\u018e\u8a50", 1346923764));
        screen.method_25402(new Click((double)(f3 + f * f5), (double)(f4 + f2 * f5), new MouseInput(n, 0)), false);
    }

    private static void gwt(Screen screen, float f, float f2, double d) throws Exception {
        if (!(screen instanceof hlc)) {
            return;
        }
        float f3 = gtq.gwu(screen, a.d("\uc312\ubabe\u3076\uae09\u25d0\ua366\u1903", 1228529131, 1881087633));
        float f4 = gtq.gwu(screen, a.d("\u21ef\u5843\ud28b\u4cf4\uc72d\u419b\ufbff", 1138024897, -1296252858));
        float f5 = gtq.gwu(screen, a.b("\u6909\u10a8\u9a79\u0405\u8fdb", -1108579969));
        screen.method_25401((double)(f3 + f * f5), (double)(f4 + f2 * f5), 0.0, d);
    }

    private static float gwu(Object object, String string) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    static {
        gtt = System.getenv(a.d("\ua1cd\ud876\u52a6\ucccf\u477d\uc1a1\u7bfe\uf219\u6c4f\ue6f4\u6135\u9b55\u1594\u8c22\u067a\u8087\u3ad8\ub50f\u2fb7\ua9ed", -2057813570, -1980833759));
        gtu = new ArrayList<PlayerEntity>();
        gtx = new String[]{a.d("\ua248\udbf0\u5123", -1446839478, -795453074), a.b("\u7f9e\u0632\u8cf0\u12e5\u997e\u1fca\ua581\u2c74\ub237\u388b", 1699446748), a.d("\uac52\ud5ea\u5f39", 1844249284, 116109050), a.b("\ufbd5\u8279\u08bb\u96ae\u1d2a\u9b87\u21d7\ua823\u3671", 202505108), a.d("\u15e4\u6c5c\ue68f", -614747790, -21846790), a.c(2036579230, "\ubbfe\uc240\u489f\ud6e6\u5d20\udb84\u61d1\ue834\u7638\ufcce\u7b16\u816a\u0faf\u961e"), a.c(561752018, "\ua7be\ude06\u54d5"), a.c(-65997612, "\uf4b3\u8d0f\u07dc\u99e1\u1279\u94c9"), a.b("\u0a32\u738a\uf959", -1402926498), a.b("\u1c83\u653f\uefec\u71d1\ufa49\u7cf9\uc6e4\u4f41\ud11f\u5ba9\udc66\u2610\ua8c0\u3178", -816374548), a.c(459575618, "\u9126\ue89e\u624d\ufc7a\u77f9\uf149\u4b1d\uc2f0\u5ca8\ud61e\u51c4"), a.d("\ubdfb\uc447\u4e94\ud0a9\u5b31\udd81\u679c\uee39\u7067\ufad1\u7d1e\u8768\u09b8\u9000", 313983572, 781696960)};
        gty = new int[]{0, 1, 0, 4, 0, 5, 0, 7, 0, 8, 9, 8};
        gue = new ArrayList<ServerBossBar>();
        gug = Float.NaN;
        guk = new int[]{Integer.MIN_VALUE, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 8};
        gur = a.b("\u6567\u1cdf\u9604\u083f\u83a9\u051b\ubf48\u36bd\ua8a4", -1344969464);
        gus = -1;
    }

    private static /* synthetic */ int xc(int n, int n2) {
        return n * n2 | 0x9AFD7752;
    }
}

