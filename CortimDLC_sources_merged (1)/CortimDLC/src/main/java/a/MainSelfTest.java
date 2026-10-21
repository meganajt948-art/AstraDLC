/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.class_11905
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_11910
 *  net.minecraft.class_124
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1684
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_268
 *  net.minecraft.class_269
 *  net.minecraft.class_276
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_3213
 *  net.minecraft.class_337
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_525
 *  net.minecraft.class_5498
 *  net.minecraft.class_745
 *  net.minecraft.class_746
 *  net.minecraft.class_8100$class_8101
 *  net.minecraft.class_9278
 *  net.minecraft.class_9334
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.AnimationsTest;
import a.AutoSellTest;
import a.AuraTest;
import a.AuraProfileTest;
import a.BaseFarmTest;
import a.LanBotTest;
import a.ServerHelperTest;
import a.ShulkerPreviewTest;
import a.CollectorEditorTest;
import a.CosmeticsTest;
import a.AimPatternTest;
import a.DuelTest;
import a.PlayerEspTest;
import a.ChestScenarioTest;
import a.HudTest;
import a.BlackThemeTest;
import a.TargetMarkerTest;
import a.SoulEspTest;
import a.GuiMoveTest;
import a.SurvivalScenarioTest;
import a.MineTest;
import a.MobEspTest;
import a.MotionBlurTest;
import a.NeuroRecordTest;
import a.ArmorScenarioTest;
import a.MovementTest;
import a.RenderPerfTest;
import a.PartyRelayTest;
import a.EspTest;
import a.SeasonTest;
import a.SitTest;
import a.SkyStyleTest;
import a.SnowSkyTest;
import a.StormTest;
import a.SummerSkyTest;
import a.AutoTotemTest;
import a.HandAnimationTest;
import a.NametagTest;
import a.ThemeTest;
import a.TargetEspTest;
import a.AutoMaceTest;
import a.WeatherTest;
import a.Friends;
import a.ClickGuiScreen;
import a.LiquidGlass;
import a.GuiConfig;
import a.LanguageScreen;
import a.ArmorHudWidget;
import a.Hud;
import a.HudWidget;
import a.Module;
import a.ModuleManager;
import a.KeyPearl;
import a.ServerHelper;
import a.StructureTimers;
import a.HealthBar;
import a.HitParticles;
import a.FogPass;
import a.WeatherSeasonPass;
import a.BoolSetting;
import a.ColorSetting;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.IdleTracker;
import a.wam;
import a.Lang;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
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
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_124;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1684;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_276;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_3213;
import net.minecraft.class_337;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_525;
import net.minecraft.class_5498;
import net.minecraft.class_745;
import net.minecraft.class_746;
import net.minecraft.class_8100;
import net.minecraft.class_9278;
import net.minecraft.class_9334;
import org.lwjgl.glfw.GLFW;

public final class MainSelfTest {
    private static int gtr;
    private static int gts;
    private static final String gtt;
    private static final List<class_1657> gtu;
    private static class_268 gtv;
    private static final int gtw = 70;
    private static final String[] gtx;
    private static final int[] gty;
    private static long gtz;
    private static long gua;
    private static boolean gub;
    private static class_1657 guc;
    private static String gud;
    private static final List<class_3213> gue;
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

    private MainSelfTest() {
    }

    public static void install() {
        if (!Boolean.getBoolean("flow2.selftest") || "menu".equals(gtt) || "video".equals(gtt) || "look".equals(gtt) || "flowmenu".equals(gtt)) {
            return;
        }
        System.out.println("self test armed");
        ClientTickEvents.END_CLIENT_TICK.register(MainSelfTest::guw);
    }

    private static void guw(class_310 class_3102) {
        ++gts;
        try {
            switch (gtr) {
                case 0: {
                    if (class_3102.method_18506() != null || class_3102.field_1755 == null || gts <= 40) break;
                    class_525.method_64248((class_310)class_3102, () -> class_3102.method_1507((class_437)new class_442()));
                    MainSelfTest.gwo();
                    break;
                }
                case 1: {
                    Object object = class_3102.field_1755;
                    if (object instanceof class_525) {
                        class_525 class_5252 = (class_525)object;
                        if (gts > 20) {
                            if ("scenery".equals(gtt) || "snowsky".equals(gtt) || "summersky".equals(gtt) || "storm".equals(gtt)) {
                                object = class_5252.method_48657();
                                object.method_48705((class_8100.class_8101)object.method_48732().get(0));
                                object.method_48716(System.getenv().getOrDefault("FLOW2_SEED", "flowclient"));
                            }
                            object = class_525.class.getDeclaredMethod("createLevel", new Class[0]);
                            ((Method)object).setAccessible(true);
                            ((Method)object).invoke((Object)class_5252, new Object[0]);
                            MainSelfTest.gwo();
                        }
                    }
                    break;
                }
                case 2: {
                    if (class_3102.field_1687 != null && class_3102.field_1724 != null && class_3102.field_1755 == null) {
                        if (gts > 100 && "nametags".equals(gtt)) {
                            gtr = 4;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "wind".equals(gtt)) {
                            gtr = 5;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "windjump".equals(gtt)) {
                            gtr = 6;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "pearl".equals(gtt)) {
                            gtr = 7;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "structures".equals(gtt)) {
                            gtr = 8;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "esp".equals(gtt)) {
                            gtr = 9;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "bright".equals(gtt)) {
                            gtr = 10;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "fog".equals(gtt)) {
                            gtr = 11;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "foglook".equals(gtt)) {
                            gtr = 12;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "MediaFoundationVideo".equals(gtt)) {
                            gtr = 40;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "winter".equals(gtt)) {
                            gtr = 41;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "guimove".equals(gtt)) {
                            gtr = 42;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "motion".equals(gtt)) {
                            gtr = 43;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "crit".equals(gtt)) {
                            gtr = 13;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "mace".equals(gtt)) {
                            gtr = 14;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "visuals".equals(gtt)) {
                            gtr = 15;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "lang".equals(gtt)) {
                            gtr = 16;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "paint".equals(gtt)) {
                            gtr = 17;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "totem".equals(gtt)) {
                            gtr = 44;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "tool".equals(gtt)) {
                            gtr = 45;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "fx".equals(gtt)) {
                            gtr = 46;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "perf".equals(gtt)) {
                            gtr = 61;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "chest".equals(gtt)) {
                            gtr = 60;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "anim".equals(gtt)) {
                            gtr = 62;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "players".equals(gtt)) {
                            gtr = 47;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "winterplants".equals(gtt)) {
                            gtr = 48;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "duel".equals(gtt)) {
                            gtr = 63;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "aurastudio".equals(gtt)) {
                            gtr = 64;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "aurastands".equals(gtt)) {
                            gtr = 65;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "orbit".equals(gtt)) {
                            gtr = 66;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "party".equals(gtt)) {
                            gtr = 70;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "automace".equals(gtt)) {
                            gtr = 49;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "bundle".equals(gtt)) {
                            gtr = 50;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "themes".equals(gtt)) {
                            gtr = 51;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "collector".equals(gtt)) {
                            gtr = 52;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "bots".equals(gtt)) {
                            gtr = 74;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "farm".equals(gtt)) {
                            gtr = 18;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "automine".equals(gtt)) {
                            gtr = 72;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "minebase".equals(gtt)) {
                            gtr = 73;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "friendtag".equals(gtt)) {
                            gtr = 53;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "sky".equals(gtt)) {
                            gtr = 54;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "neuro".equals(gtt)) {
                            gtr = 56;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "scenery".equals(gtt)) {
                            gtr = 58;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "snowsky".equals(gtt)) {
                            gtr = 81;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "summersky".equals(gtt)) {
                            gtr = 82;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "storm".equals(gtt)) {
                            gtr = 83;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "glass".equals(gtt)) {
                            gtr = 84;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "swing".equals(gtt)) {
                            gtr = 85;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "windmace".equals(gtt)) {
                            gtr = 86;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "auc".equals(gtt)) {
                            gtr = 87;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "sit".equals(gtt)) {
                            gtr = 88;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "cosmetics".equals(gtt)) {
                            gtr = 89;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "flowlook".equals(gtt)) {
                            gtr = 90;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "newmods".equals(gtt)) {
                            gtr = 93;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "mobs".equals(gtt)) {
                            gtr = 94;
                            gts = 0;
                            break;
                        }
                        if (gts > 100 && "firsthud".equals(gtt)) {
                            gtr = 91;
                            gts = 0;
                            break;
                        }
                        if (gts <= 100) break;
                        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
                        field.setAccessible(true);
                        field.set(null, "Combat");
                        MainSelfTest.gvn();
                        class_3102.method_1507((class_437)new ClickGuiScreen());
                        MainSelfTest.gwo();
                        break;
                    }
                    gts = 0;
                    break;
                }
                case 3: {
                    MainSelfTest.gux(class_3102);
                    break;
                }
                case 4: {
                    MainSelfTest.gvb(class_3102);
                    break;
                }
                case 5: {
                    MainSelfTest.gvp(class_3102);
                    break;
                }
                case 6: {
                    MainSelfTest.gvq(class_3102);
                    break;
                }
                case 7: {
                    MainSelfTest.gvr(class_3102);
                    break;
                }
                case 8: {
                    MainSelfTest.gvw(class_3102);
                    break;
                }
                case 9: {
                    MainSelfTest.gvc(class_3102);
                    break;
                }
                case 10: {
                    MainSelfTest.gwe(class_3102);
                    break;
                }
                case 11: {
                    MainSelfTest.gvx(class_3102);
                    break;
                }
                case 12: {
                    MainSelfTest.gvy(class_3102);
                    MainSelfTest.gwa(class_3102);
                    break;
                }
                case 13: {
                    if (!AimPatternTest.crit(class_3102)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 40: {
                    MainSelfTest.gwb(class_3102);
                    MainSelfTest.gwa(class_3102);
                    break;
                }
                case 41: {
                    MainSelfTest.gwc(class_3102);
                    MainSelfTest.gwa(class_3102);
                    break;
                }
                case 42: {
                    if (!GuiMoveTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 44: {
                    if (!AutoTotemTest.totem(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 45: {
                    if (!AutoTotemTest.tool(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 46: {
                    if (!TargetMarkerTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 61: {
                    if (!EspTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 62: {
                    if (!AnimationsTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 60: {
                    if (!ShulkerPreviewTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 47: {
                    if (!PlayerEspTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 48: {
                    if (!WeatherTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 49: {
                    if (!SurvivalScenarioTest.tick(class_3102)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 50: {
                    if (!ServerHelperTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 52: {
                    if (!CollectorEditorTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 53: {
                    if (!NametagTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 54: {
                    if (!SkyStyleTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 58: {
                    if (!SeasonTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 81: {
                    if (!SnowSkyTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 82: {
                    if (!SummerSkyTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 83: {
                    if (!StormTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 84: {
                    if (!SoulEspTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 85: {
                    if (!HandAnimationTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 86: {
                    if (!AutoMaceTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 87: {
                    if (!AutoSellTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 88: {
                    if (!SitTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 89: {
                    if (!CosmeticsTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 63: {
                    if (!DuelTest.tick(class_3102)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 64: {
                    if (!AuraProfileTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 65: {
                    if (!AuraTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 66: {
                    if (!MovementTest.tick(class_3102)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 70: {
                    if (!PartyRelayTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 72: {
                    if (!MineTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 74: {
                    if (!LanBotTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 73: {
                    if (!BaseFarmTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 56: {
                    if (!NeuroRecordTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 51: {
                    if (!ThemeTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 90: {
                    if (!BlackThemeTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 91: {
                    if (!HudTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 94: {
                    if (!MobEspTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 93: {
                    if (!ArmorScenarioTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 43: {
                    if (!MotionBlurTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 14: {
                    if (!AimPatternTest.mace(class_3102)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 15: {
                    if (!TargetEspTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 16: {
                    MainSelfTest.guy(class_3102);
                    break;
                }
                case 17: {
                    if (!RenderPerfTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
                case 18: {
                    if (!ChestScenarioTest.tick(class_3102, gts)) break;
                    class_3102.method_1592();
                    gtr = 99;
                    break;
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println("self test failed: " + throwable);
            throwable.printStackTrace();
            class_3102.method_1592();
            gtr = 99;
        }
    }

    /*
     * Exception decompiling
     */
    private static void gux(class_310 var0) throws Exception {
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

    private static void guy(class_310 class_3102) throws Exception {
        class_437 class_4372 = class_3102.field_1755;
        switch (gts) {
            case 1: {
                Lang.set(wam.RU);
                Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
                field.setAccessible(true);
                field.set(null, "Combat");
                MainSelfTest.gvn();
                class_3102.method_1507((class_437)new ClickGuiScreen());
                break;
            }
            case 25: {
                MainSelfTest.gwp(class_3102, "lang-01-combat");
                break;
            }
            case 26: {
                MainSelfTest.gws(class_4372, 200.0f, 69.0f, 1);
                break;
            }
            case 40: {
                MainSelfTest.gwp(class_3102, "lang-02-unfolded");
                break;
            }
            case 41: {
                MainSelfTest.gws(class_4372, 400.0f, 23.0f, 0);
                MainSelfTest.gwr(class_4372, "фшь фыышые");
                break;
            }
            case 60: {
                MainSelfTest.gwp(class_3102, "lang-03-search-layout");
                MainSelfTest.gws(class_4372, 400.0f, 23.0f, 1);
                MainSelfTest.gwr(class_4372, "аим ассист");
                break;
            }
            case 80: {
                MainSelfTest.gwp(class_3102, "lang-04-search-translit");
                MainSelfTest.gws(class_4372, 400.0f, 23.0f, 1);
                MainSelfTest.gwr(class_4372, "погода");
                break;
            }
            case 100: {
                MainSelfTest.gwp(class_3102, "lang-05-search-ru");
                class_4372.method_25419();
                break;
            }
            case 120: {
                class_3102.method_1507((class_437)new ClickGuiScreen());
                break;
            }
            case 140: {
                MainSelfTest.gwp(class_3102, "lang-06-search-kept");
                break;
            }
            case 141: {
                MainSelfTest.gws(class_4372, 400.0f, 23.0f, 1);
                MainSelfTest.gwq(class_4372, 256);
                Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
                field.setAccessible(true);
                field.set(null, "Render");
                class_3102.method_1507((class_437)new ClickGuiScreen());
                break;
            }
            case 160: {
                MainSelfTest.gwp(class_3102, "lang-07-render");
                MainSelfTest.guz(class_3102, class_3102.field_1755, 26.0f, 362.0f);
                break;
            }
            case 180: {
                MainSelfTest.gwp(class_3102, "lang-08-avatar-picker");
                break;
            }
            case 181: {
                MainSelfTest.guz(class_3102, class_3102.field_1755, 500.0f, 23.0f);
                class_3102.method_1507((class_437)new LanguageScreen(class_3102.field_1755));
                break;
            }
            case 200: {
                MainSelfTest.gwp(class_3102, "lang-09-language-picker");
                break;
            }
            case 201: {
                Lang.set(wam.EN);
                class_3102.method_1507(null);
                Flow.getInstance().getModuleManager().getByName("Predictions").setEnabled(true);
                class_1799 class_17992 = new class_1799((class_1935)class_1802.field_8399);
                class_1799 class_17993 = new class_1799((class_1935)class_1802.field_8107);
                class_17992.method_57379(class_9334.field_49649, (Object)class_9278.method_57441(List.of(class_17993, class_17993.method_7972(), class_17993.method_7972())));
                class_3102.field_1724.method_31548().method_5447(class_3102.field_1724.method_31548().method_67532(), class_17992);
                class_3102.field_1724.method_36457(-12.0f);
                break;
            }
            case 220: {
                MainSelfTest.gwp(class_3102, "lang-10-multishot");
                break;
            }
            case 225: {
                Flow.getInstance().getModuleManager().getByName("Predictions").setEnabled(false);
                GuiConfig.save();
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void guz(class_310 class_3102, class_437 class_4372, float f, float f2) throws Exception {
        float f3 = MainSelfTest.gva(class_4372, "originX");
        float f4 = MainSelfTest.gva(class_4372, "originY");
        float f5 = MainSelfTest.gva(class_4372, "scale");
        float f6 = MainSelfTest.gva(class_4372, "scaleY");
        double d = class_3102.method_22683().method_4495();
        GLFW.glfwSetCursorPos((long)class_3102.method_22683().method_4490(), (double)((double)(f3 + f * f5) * d), (double)((double)(f4 + f2 * f6) * d));
    }

    private static float gva(Object object, String string) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    private static void gvb(class_310 class_3102) throws Exception {
        HealthBar rjy2 = HealthBar.get();
        class_437 class_4372 = class_3102.field_1755;
        switch (gts) {
            case 1: {
                rjy2.setEnabled(true);
                class_1657 class_16572 = MainSelfTest.gvi(class_3102, "Verhovenstvo", 4.6, -1.8, 10.0f);
                class_16572.method_5673(class_1304.field_6169, MainSelfTest.gvj(class_1802.field_22027));
                class_16572.method_5673(class_1304.field_6174, MainSelfTest.gvj(class_1802.field_22028));
                class_16572.method_5673(class_1304.field_6172, MainSelfTest.gvj(class_1802.field_22029));
                class_16572.method_5673(class_1304.field_6166, MainSelfTest.gvj(class_1802.field_22030));
                class_16572.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8367, 58));
                class_1657 class_16573 = MainSelfTest.gvi(class_3102, "R2SSS", 10.5, 4.6, 2.0f);
                class_16573.method_5673(class_1304.field_6169, MainSelfTest.gvl(class_1802.field_8743, 0.6f));
                class_16573.method_5673(class_1304.field_6174, MainSelfTest.gvl(class_1802.field_8523, 0.3f));
                class_16573.method_5673(class_1304.field_6173, MainSelfTest.gvl(class_1802.field_8802, 0.2f));
                class_16573.method_5673(class_1304.field_6171, new class_1799((class_1935)class_1802.field_8288));
                class_1657 class_16574 = MainSelfTest.gvi(class_3102, "lakichel33333", 22.0, -9.0, 17.0f);
                class_16574.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
                class_16574.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8102));
                class_1657 class_16575 = MainSelfTest.gvi(class_3102, "Kolya", 7.0, 1.2, 20.0f);
                class_16575.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_22022));
                class_16575.method_6073(4.0f);
                class_269 class_2692 = class_3102.field_1687.method_8428();
                gtv = class_2692.method_1171("flow2test");
                gtv.method_1138((class_2561)class_2561.method_43470((String)"[ELITE] ").method_27695(new class_124[]{class_124.field_1065, class_124.field_1067}));
                gtv.method_1139((class_2561)class_2561.method_43470((String)" §c❤"));
                class_2692.method_1172("Verhovenstvo", gtv);
                Friends.add("Kolya");
                break;
            }
            case 40: {
                MainSelfTest.gwp(class_3102, "33-nametags-glass");
                break;
            }
            case 41: {
                rjy2.background.set("Liquid");
                break;
            }
            case 55: {
                MainSelfTest.gwp(class_3102, "34-nametags-liquid");
                break;
            }
            case 56: {
                rjy2.background.set("Solid");
                rjy2.health.set("Both");
                rjy2.items.set("Above");
                rjy2.distance.set(true);
                break;
            }
            case 70: {
                MainSelfTest.gwp(class_3102, "35-nametags-solid");
                break;
            }
            case 71: {
                rjy2.background.set("None");
                rjy2.tint.set("Dark");
                rjy2.items.set("Inline");
                rjy2.health.set("Text");
                rjy2.distance.set(false);
                break;
            }
            case 85: {
                MainSelfTest.gwp(class_3102, "36-nametags-none");
                break;
            }
            case 86: {
                rjy2.background.set("Glass");
                class_1657 class_16576 = gtu.get(1);
                class_243 class_2432 = class_16576.method_33571().method_1020(class_3102.field_1724.method_33571());
                class_3102.field_1724.method_36456((float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350)));
                class_3102.field_1724.method_36457((float)(-Math.toDegrees(Math.atan2(class_2432.field_1351, Math.hypot(class_2432.field_1352, class_2432.field_1350)))));
                Friends.toggleAimed();
                break;
            }
            case 94: {
                MainSelfTest.gwp(class_3102, "37-friend-key");
                System.out.println("self test friends " + Friends.all().size() + " (R2SSS friend: " + Friends.isFriend("r2sss") + ")");
                break;
            }
            case 95: {
                MainSelfTest.gvm(class_3102, "Friends");
                break;
            }
            case 120: {
                MainSelfTest.gwp(class_3102, "38-friends-tab");
                break;
            }
            case 121: {
                MainSelfTest.gvm(class_3102, "Render");
                break;
            }
            case 145: {
                MainSelfTest.gwp(class_3102, "39-nametags-card");
                break;
            }
            case 146: {
                if (class_4372 != null) {
                    MainSelfTest.gwq(class_4372, 256);
                }
                rjy2.setEnabled(false);
                break;
            }
            case 160: {
                MainSelfTest.gwp(class_3102, "40-vanilla-tags");
                break;
            }
            case 161: {
                for (class_1657 class_16577 : gtu) {
                    class_3102.field_1687.method_2945(class_16577.method_5628(), class_1297.class_5529.field_26999);
                }
                gtu.clear();
                class_3102.field_1687.method_8428().method_1191(gtv);
                Friends.remove("Kolya");
                Friends.remove("R2SSS");
                GuiConfig.save();
                class_3102.method_1592();
                break;
            }
        }
    }

    private static void gvc(class_310 class_3102) throws Exception {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        HitParticles ruv2 = (HitParticles)kfx2.getByName("TargetESP");
        switch (gts) {
            case 1: {
                ruv2.setEnabled(true);
                kfx2.getByName("HitColor").setEnabled(true);
                kfx2.getByName("AutoSprint").setEnabled(true);
                class_3102.field_1724.method_36457(8.0f);
                guc = MainSelfTest.gvk(class_3102);
                HitParticles.onAttack((class_1297)guc);
                class_3102.field_1724.method_5673(class_1304.field_6169, MainSelfTest.gvl(class_1802.field_22027, 0.05f));
                class_3102.field_1724.method_5673(class_1304.field_6174, MainSelfTest.gvl(class_1802.field_22028, 0.4f));
                class_3102.field_1724.method_5673(class_1304.field_6172, MainSelfTest.gvl(class_1802.field_8348, 0.7f));
                class_3102.field_1724.method_5673(class_1304.field_6166, MainSelfTest.gvl(class_1802.field_8285, 0.93f));
                class_1799 class_17992 = new class_1799((class_1935)class_1802.field_8367, 12);
                class_17992.method_57379(class_9334.field_49631, (Object)class_2561.method_43470((String)"✦ Enchanted Golden Apple of the Ancient Kings [Legendary] ✦"));
                class_3102.field_1724.method_31548().method_5447(2, class_17992);
                class_3102.field_1724.method_7357().method_62835(class_17992, 600);
                class_3102.field_1724.method_31548().method_5447(1, new class_1799((class_1935)class_1802.field_8634, 16));
                class_3102.field_1724.method_7357().method_62835(new class_1799((class_1935)class_1802.field_8634), 300);
                Hud.TARGET.enabled.set(false);
                break;
            }
            case 14: {
                Hud.cpuMicros();
                HitParticles.cpuMicros();
                break;
            }
            case 24: {
                MainSelfTest.gwp(class_3102, "50-esp-ghosts");
                System.out.println("self test steady HUD cpu " + String.format("%.1f", Hud.cpuMicros()) + " us/frame, ESP " + String.format("%.1f", HitParticles.cpuMicros()) + " us/frame");
                break;
            }
            case 25: {
                ruv2.mode.set("Sparkles");
                break;
            }
            case 40: {
                MainSelfTest.gwp(class_3102, "51-esp-sparkles");
                break;
            }
            case 41: {
                ruv2.mode.set("Lightning");
                break;
            }
            case 50: {
                MainSelfTest.gvf(guc);
                break;
            }
            case 52: {
                MainSelfTest.gwp(class_3102, "52-esp-lightning-hit");
                break;
            }
            case 60: {
                MainSelfTest.gwp(class_3102, "52b-esp-lightning");
                break;
            }
            case 61: {
                ruv2.mode.set("Ring");
                break;
            }
            case 75: {
                MainSelfTest.gwp(class_3102, "53-esp-ring");
                break;
            }
            case 76: {
                ruv2.mode.set("Comets");
                break;
            }
            case 90: {
                MainSelfTest.gwp(class_3102, "54-esp-comets");
                break;
            }
            case 91: {
                ruv2.mode.set("Ghosts");
                break;
            }
            case 105: {
                MainSelfTest.gwp(class_3102, "55-esp-ghosts-again");
                break;
            }
            case 106: {
                ruv2.mode.set("Ghosts");
                break;
            }
            case 111: {
                MainSelfTest.gvf(guc);
                break;
            }
            case 113: {
                MainSelfTest.gwp(class_3102, "56-esp-ghosts-hit-color");
                break;
            }
            case 114: {
                Hud.TARGET.enabled.set(true);
                break;
            }
            case 116: {
                class_3102.method_1507((class_437)new class_408("", false));
                break;
            }
            case 125: {
                ArmorHudWidget ixu2 = Hud.ARMOR;
                float f = MainSelfTest.gvg(ixu2, "x");
                float f2 = MainSelfTest.gvg(ixu2, "y");
                float f3 = MainSelfTest.gvg(ixu2, "w");
                float f4 = MainSelfTest.gvg(ixu2, "h");
                Hud.mouseClicked((double)f + (double)f3 * 0.9, (double)f2 + (double)f4 * 0.2, 1);
                Hud.mouseDragged((double)f + (double)f3 * 1.08, (double)f2 - (double)f4 * 0.1);
                break;
            }
            case 135: {
                MainSelfTest.gwp(class_3102, "57-armor-resize-in-chat");
                break;
            }
            case 136: {
                Hud.mouseReleased();
                class_3102.method_1507(null);
                break;
            }
            case 138: {
                class_3102.field_1690.field_1894.method_23481(true);
                break;
            }
            case 144: {
                System.out.println("self test AutoSprint walking: sprinting " + class_3102.field_1724.method_5624());
                class_3102.field_1690.field_1894.method_23481(false);
                break;
            }
            case 150: {
                MainSelfTest.gwp(class_3102, "58-hud-armor-cooldowns");
                System.out.println("self test HUD cpu " + String.format("%.1f", Hud.cpuMicros()) + " us/frame");
                System.out.println("self test sprinting " + class_3102.field_1724.method_5624());
                break;
            }
            case 151: {
                MainSelfTest.gvh(Hud.ARMOR);
                MainSelfTest.gvd();
                MainSelfTest.gve(class_3102, ruv2, 0);
                break;
            }
            case 995: {
                Hud.ENABLED.set(true);
                Hud.BACKGROUND.set("Glass");
                HealthBar.get().setEnabled(false);
                ruv2.setEnabled(true);
                class_3102.field_1687.method_2945(guc.method_5628(), class_1297.class_5529.field_26999);
                MainSelfTest.gvm(class_3102, "Render");
                break;
            }
            case 1017: {
                MainSelfTest.gwp(class_3102, "59-render-tab");
                break;
            }
            case 1018: {
                ruv2.setEnabled(false);
                kfx2.getByName("HitColor").setEnabled(false);
                kfx2.getByName("AutoSprint").setEnabled(false);
                GuiConfig.save();
                class_3102.method_1592();
                break;
            }
            default: {
                int n = gts - 151;
                if (gts <= 151 || gts >= 151 + 70 * gtx.length) break;
                int n2 = n / 70;
                int n3 = n % 70;
                if (gty[n2] >= 8) {
                    class_3102.field_1724.method_36456(class_3102.field_1724.method_36454() + 3.0f);
                }
                if (n3 == 0) {
                    MainSelfTest.gve(class_3102, ruv2, gty[n2]);
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
                System.out.println("self test cost " + gtx[n2] + ": " + String.format("%.2f", d2) + " ms/frame (" + Math.round((double)gtz / d) + " fps)");
            }
        }
    }

    private static void gvd() {
        if (!gub) {
            gub = true;
            HudRenderCallback.EVENT.register((class_3322, class_97792) -> ++gtz);
        }
    }

    private static void gve(class_310 class_3102, HitParticles ruv2, int n) {
        if (class_3102.field_1755 != null) {
            class_3102.method_1507(null);
        }
        boolean bl = n == 7 || n == 8;
        Hud.ENABLED.set(n >= 1 && n <= 4 || bl);
        Hud.BACKGROUND.set(n == 4 ? "Solid" : "Glass");
        LiquidGlass.STYLE.set(n == 2 ? "Frosted" : "Liquid");
        LiquidGlass.FROST.set(n == 3 ? 0.0 : 2.0);
        HealthBar.get().setEnabled(n == 5 || bl);
        ruv2.setEnabled(n == 6 || bl);
    }

    private static void gvf(class_1657 class_16572) {
        class_16572.method_6033(Math.max(2.0f, class_16572.method_6032() - 5.0f));
        class_16572.field_6235 = 10;
        class_16572.field_6254 = 10;
    }

    private static float gvg(HudWidget jcs2, String string) throws Exception {
        Field field = HudWidget.class.getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(jcs2);
    }

    private static void gvh(HudWidget jcs2) throws Exception {
        Field field = HudWidget.class.getDeclaredField("size");
        field.setAccessible(true);
        field.setFloat(jcs2, 1.0f);
    }

    private static class_1657 gvi(class_310 class_3102, String string, double d, double d2, float f) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_5828(1.0f).method_18805(1.0, 0.0, 1.0).method_1029();
        class_243 class_2433 = new class_243(-class_2432.field_1350, 0.0, class_2432.field_1352);
        class_243 class_2434 = class_3102.field_1724.method_73189().method_1019(class_2432.method_1021(d)).method_1019(class_2433.method_1021(d2));
        class_7452.method_5808(class_2434.field_1352, class_3102.field_1724.method_23318(), class_2434.field_1350, class_3102.field_1724.method_36454() + 180.0f, 0.0f);
        class_7452.method_6033(f);
        class_3102.field_1687.method_53875((class_1297)class_7452);
        gtu.add((class_1657)class_7452);
        return class_7452;
    }

    private static class_1799 gvj(class_1792 class_17922) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        class_17992.method_57379(class_9334.field_49641, (Object)true);
        return class_17992;
    }

    private static class_1657 gvk(class_310 class_3102) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), "Dream"));
        class_243 class_2432 = class_3102.field_1724.method_5828(1.0f).method_18805(1.0, 0.0, 1.0).method_1029();
        class_243 class_2433 = class_3102.field_1724.method_73189().method_1019(class_2432.method_1021(3.2));
        class_7452.method_5808(class_2433.field_1352, class_3102.field_1724.method_23318(), class_2433.field_1350, class_3102.field_1724.method_36454() + 180.0f, 0.0f);
        class_7452.method_5673(class_1304.field_6169, MainSelfTest.gvl(class_1802.field_22027, 0.1f));
        class_7452.method_5673(class_1304.field_6174, MainSelfTest.gvl(class_1802.field_8058, 0.45f));
        class_7452.method_5673(class_1304.field_6172, MainSelfTest.gvl(class_1802.field_8348, 0.7f));
        class_7452.method_5673(class_1304.field_6166, MainSelfTest.gvl(class_1802.field_8660, 0.9f));
        class_7452.method_5673(class_1304.field_6173, MainSelfTest.gvl(class_1802.field_22022, 0.3f));
        class_7452.method_5673(class_1304.field_6171, new class_1799((class_1935)class_1802.field_8288));
        class_7452.method_6073(4.0f);
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static class_1799 gvl(class_1792 class_17922, float f) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        class_17992.method_7974(Math.round((float)class_17992.method_7936() * f));
        return class_17992;
    }

    private static void gvm(class_310 class_3102, String string) throws Exception {
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, string);
        Field field2 = ClickGuiScreen.class.getDeclaredField("SCROLLS");
        field2.setAccessible(true);
        ((Map)field2.get(null)).clear();
        MainSelfTest.gvn();
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void gvn() throws Exception {
        for (String string : new String[]{"windowX", "windowY"}) {
            Field field = ClickGuiScreen.class.getDeclaredField(string);
            field.setAccessible(true);
            field.setFloat(null, Float.NaN);
        }
    }

    private static float gvo(Object object, String string) throws Exception {
        Field field = HudWidget.class.getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    private static void gvp(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("ServerHelper");
        KeySetting vlq2 = null;
        BoolSetting vkl2 = null;
        BoolSetting vkl3 = null;
        for (Setting vmo2 : kfe2.getSettings()) {
            BoolSetting vkl4;
            BoolSetting vkl5;
            KeySetting vlq3;
            if (vmo2 instanceof KeySetting && (vlq3 = (KeySetting)vmo2).getName().equals("Заряд ветра")) {
                vlq2 = vlq3;
                continue;
            }
            if (vmo2 instanceof BoolSetting && (vkl5 = (BoolSetting)vmo2).getName().equals("Булава после заряда")) {
                vkl2 = vkl5;
                continue;
            }
            if (!(vmo2 instanceof BoolSetting) || !(vkl4 = (BoolSetting)vmo2).getName().equals("Прыжок в тайминг")) continue;
            vkl3 = vkl4;
        }
        int n = 74;
        if (gts > 1) {
            guh = Math.max(guh, class_7462.method_23318());
            if (Float.isNaN(gug) && !ServerHelper.busy()) {
                gug = class_7462.method_36455();
            }
        }
        switch (gts) {
            case 1: {
                kfe2.setEnabled(true);
                vlq2.set(n);
                MainSelfTest.gwi(class_3102, "gamemode survival");
                MainSelfTest.gwi(class_3102, "effect give @s resistance 600 4 true");
                break;
            }
            case 5: {
                MainSelfTest.gwj(class_3102, "inventory.11", "inventory.5", 0);
                break;
            }
            case 40: {
                MainSelfTest.gwk(class_3102, kfe2, n, 10.0f);
                break;
            }
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: {
                MainSelfTest.gwl(class_3102, "A");
                break;
            }
            case 90: {
                MainSelfTest.gwm(class_3102, "A", class_1802.field_49814, 20, 7, 0, 9.0, 99.0);
                break;
            }
            case 100: {
                MainSelfTest.gwj(class_3102, "hotbar.3", "hotbar.5", 0);
                break;
            }
            case 140: {
                MainSelfTest.gwk(class_3102, kfe2, n, -20.0f);
                break;
            }
            case 141: 
            case 142: 
            case 143: 
            case 144: 
            case 145: {
                MainSelfTest.gwl(class_3102, "B");
                break;
            }
            case 190: {
                MainSelfTest.gwm(class_3102, "B", class_1802.field_49814, 3, 7, 5, 9.0, 99.0);
                break;
            }
            case 200: {
                vkl2.set(false);
                MainSelfTest.gwj(class_3102, "inventory.11", "inventory.5", 0);
                break;
            }
            case 240: {
                MainSelfTest.gwk(class_3102, kfe2, n, 30.0f);
                break;
            }
            case 241: 
            case 242: 
            case 243: 
            case 244: 
            case 245: {
                MainSelfTest.gwl(class_3102, "C");
                break;
            }
            case 290: {
                MainSelfTest.gwm(class_3102, "C", class_1802.field_8802, 20, 7, 0, 9.0, 99.0);
                break;
            }
            case 300: {
                vkl2.set(true);
                vkl3.set(false);
                MainSelfTest.gwj(class_3102, "hotbar.3", "hotbar.5", 0);
                break;
            }
            case 340: {
                MainSelfTest.gwk(class_3102, kfe2, n, 0.0f);
                break;
            }
            case 341: 
            case 342: 
            case 343: 
            case 344: 
            case 345: {
                MainSelfTest.gwl(class_3102, "D");
                break;
            }
            case 390: {
                MainSelfTest.gwm(class_3102, "D", class_1802.field_49814, 3, 7, 5, 5.0, 8.0);
                vkl3.set(true);
                System.out.println("wind test " + (guj == 0 ? "PASS" : "FAIL (" + guj + ")"));
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvq(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (gts == 1) {
            MainSelfTest.gwi(class_3102, "gamemode survival");
            MainSelfTest.gwi(class_3102, "effect give @s resistance 900 4 true");
            MainSelfTest.gwi(class_3102, "clear @s");
            MainSelfTest.gwi(class_3102, "item replace entity @s hotbar.0 with minecraft:wind_charge 64");
            class_7462.method_31548().method_61496(0);
            return;
        }
        int n = (gts - 40) / 70;
        if (gts < 40) {
            return;
        }
        if (n >= guk.length) {
            System.out.println("windjump done");
            class_3102.method_1592();
            gtr = 99;
            return;
        }
        int n2 = guk[n];
        boolean bl = n2 != Integer.MIN_VALUE;
        int n3 = bl ? n2 : 0;
        int n4 = 40 + n * 70 + 20;
        int n5 = gts - n4;
        class_7462.method_36457(90.0f);
        if (n5 == -12) {
            guh = guf = class_7462.method_23318();
        }
        if (n5 > -12) {
            guh = Math.max(guh, class_7462.method_23318());
        }
        if (bl && n5 == -1) {
            class_3102.field_1690.field_1903.method_23481(true);
        } else if (bl && n5 == 0) {
            class_3102.field_1690.field_1903.method_23481(false);
        }
        if (n5 == n3 - 1) {
            class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904));
        }
        if (n5 >= Math.min(-1, n3 - 1) && n5 <= Math.max(n3, 0) + 8) {
            System.out.println("windjump " + (bl ? "o=" + n3 : "stand") + " rel=" + n5 + " y=" + MainSelfTest.gwn(class_7462.method_23318() - guf) + " vy=" + MainSelfTest.gwn(class_7462.method_18798().field_1351) + " ground=" + class_7462.method_24828());
        }
        if (n5 == 45) {
            System.out.println("windjump RESULT " + (bl ? "o=" + n3 : "stand") + " rise=" + MainSelfTest.gwn(guh - guf));
        }
    }

    private static void gvr(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("KeyPearl");
        int n = 75;
        switch (gts) {
            case 1: {
                kfe2.setEnabled(true);
                for (Setting vmo2 : kfe2.getSettings()) {
                    if (!(vmo2 instanceof KeySetting)) continue;
                    KeySetting vlq2 = (KeySetting)vmo2;
                    vlq2.set(n);
                }
                MainSelfTest.gwi(class_3102, "gamemode survival");
                MainSelfTest.gwi(class_3102, "effect give @s resistance 600 4 true");
                break;
            }
            case 5: {
                MainSelfTest.gvs(class_3102, "inventory.11");
                break;
            }
            case 30: {
                MainSelfTest.gvt(class_3102, kfe2, n);
                break;
            }
            case 31: 
            case 32: 
            case 33: 
            case 34: {
                MainSelfTest.gvu(class_3102, "A");
                break;
            }
            case 70: {
                MainSelfTest.gvv(class_3102, "A", 20);
                break;
            }
            case 75: {
                MainSelfTest.gvs(class_3102, "hotbar.4");
                break;
            }
            case 100: {
                MainSelfTest.gvt(class_3102, kfe2, n);
                break;
            }
            case 101: 
            case 102: 
            case 103: {
                MainSelfTest.gvu(class_3102, "B");
                break;
            }
            case 140: {
                MainSelfTest.gvv(class_3102, "B", 4);
                break;
            }
            case 145: {
                MainSelfTest.gvs(class_3102, "inventory.11");
                break;
            }
            case 160: {
                class_3102.field_1690.field_1894.method_23481(true);
                break;
            }
            case 165: {
                MainSelfTest.gvt(class_3102, kfe2, n);
                break;
            }
            case 166: 
            case 167: 
            case 168: 
            case 169: 
            case 170: {
                MainSelfTest.gvu(class_3102, "C");
                break;
            }
            case 210: {
                MainSelfTest.gvv(class_3102, "C", 20);
                if (!class_3102.field_1690.field_1894.method_1434()) break;
                ++gum;
                System.out.println("pearl C FAIL forward still held");
                break;
            }
            case 215: {
                MainSelfTest.gwi(class_3102, "clear @s");
                break;
            }
            case 225: {
                MainSelfTest.gvt(class_3102, kfe2, n);
                break;
            }
            case 226: {
                if (KeyPearl.busy()) {
                    ++gum;
                    System.out.println("pearl D FAIL busy without a pearl");
                } else {
                    System.out.println("pearl D ok");
                }
                System.out.println("pearl test " + (gum == 0 ? "PASS" : "FAIL (" + gum + ")"));
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
        if (class_7462 != null && gts > 30) {
            gun = Math.max(gun, class_3102.field_1687.method_8390(class_1684.class, class_7462.method_5829().method_1014(64.0), class_16842 -> true).size());
        }
    }

    private static void gvs(class_310 class_3102, String string) {
        MainSelfTest.gwi(class_3102, "clear @s");
        MainSelfTest.gwi(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
        MainSelfTest.gwi(class_3102, "item replace entity @s " + string + " with minecraft:ender_pearl 16");
        class_3102.field_1724.method_31548().method_61496(0);
        gun = 0;
    }

    private static void gvt(class_310 class_3102, Module kfe2, int n) {
        class_746 class_7462 = class_3102.field_1724;
        class_7462.method_31548().method_61496(0);
        class_7462.method_36457(-35.0f);
        System.out.println("pearl press: held=" + class_7462.method_6047().method_7909() + " idle=" + IdleTracker.serverIdle(class_7462) + " forward=" + class_3102.field_1690.field_1894.method_1434());
        kfe2.onKey(class_3102, n);
    }

    private static void gvu(class_310 class_3102, String string) {
        class_746 class_7462 = class_3102.field_1724;
        System.out.println("pearl " + string + " t" + gts + ": busy=" + KeyPearl.busy() + " hand=" + class_7462.method_6047().method_7909() + " slot=" + class_7462.method_31548().method_67532() + " forward=" + class_3102.field_1690.field_1894.method_1434() + " idle=" + IdleTracker.serverIdle(class_7462));
    }

    private static void gvv(class_310 class_3102, String string, int n) {
        class_746 class_7462 = class_3102.field_1724;
        class_1661 class_16612 = class_7462.method_31548();
        class_1799 class_17992 = class_16612.method_5438(n);
        StringBuilder stringBuilder = new StringBuilder();
        if (!class_7462.method_6047().method_31574(class_1802.field_8802)) {
            stringBuilder.append(" hand=").append(class_7462.method_6047().method_7909());
        }
        if (!class_17992.method_31574(class_1802.field_8634) || class_17992.method_7947() != 15) {
            stringBuilder.append(" pearls@").append(n).append('=').append(class_17992);
        }
        if (class_16612.method_67532() != 0) {
            stringBuilder.append(" slot=").append(class_16612.method_67532());
        }
        if (gun == 0) {
            stringBuilder.append(" no pearl entity");
        }
        if (KeyPearl.busy()) {
            stringBuilder.append(" still busy");
        }
        if (!stringBuilder.isEmpty()) {
            ++gum;
        }
        System.out.println("pearl " + string + (stringBuilder.isEmpty() ? " ok" : " FAIL" + stringBuilder));
    }

    private static void gvw(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        StructureTimers pbz2 = StructureTimers.get();
        switch (gts) {
            case 1: {
                pbz2.setEnabled(true);
                MainSelfTest.gwi(class_3102, "gamemode creative");
                class_7462.method_36456(0.0f);
                class_7462.method_36457(10.0f);
                break;
            }
            case 10: {
                MainSelfTest.gwi(class_3102, "fill ~-2 ~ ~8 ~2 ~4 ~8 minecraft:ice");
                break;
            }
            case 14: {
                MainSelfTest.gwi(class_3102, "fill ~-10 ~-1 ~12 ~-4 ~5 ~18 minecraft:nether_bricks hollow");
                break;
            }
            case 18: {
                MainSelfTest.gwi(class_3102, "fill ~4 ~ ~12 ~8 ~4 ~16 minecraft:end_stone_bricks");
                break;
            }
            case 22: {
                MainSelfTest.gwi(class_3102, "fill ~12 ~ ~4 ~14 ~2 ~6 minecraft:quartz_block");
                break;
            }
            case 40: {
                MainSelfTest.gwp(class_3102, "structures");
                MainSelfTest.gwh(class_3102, "outside", 3, 0);
                break;
            }
            case 45: {
                MainSelfTest.gwi(class_3102, "fill ~-2 ~ ~8 ~2 ~4 ~8 minecraft:air");
                break;
            }
            case 60: {
                MainSelfTest.gwh(class_3102, "plast gone", 2, 0);
                break;
            }
            case 65: {
                MainSelfTest.gwi(class_3102, "fill ~-2 ~-1 ~-2 ~2 ~3 ~2 minecraft:quartz_block hollow");
                break;
            }
            case 80: {
                MainSelfTest.gwp(class_3102, "structures-inside");
                MainSelfTest.gwh(class_3102, "inside", 3, 1);
                break;
            }
            case 390: {
                MainSelfTest.gwh(class_3102, "trap expired", -1, 0);
                if (("; " + pbz2.describe()).contains("; TRAP@")) {
                    ++guo;
                    System.out.println("structures FAIL trap still tracked");
                }
                System.out.println("structures test " + (guo == 0 ? "PASS" : "FAIL (" + guo + ")"));
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvx(class_310 class_3102) throws Exception {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        Module kfe2 = kfx2.getByName("VolumetricFog");
        ModeSetting vlv2 = (ModeSetting)MainSelfTest.gwg(kfe2, "Качество");
        switch (gts) {
            case 1: {
                MainSelfTest.gwi(class_3102, "gamemode creative");
                MainSelfTest.gwi(class_3102, "time set 1000");
                MainSelfTest.gwi(class_3102, "weather clear");
                class_3102.field_1724.method_36456(-90.0f);
                class_3102.field_1724.method_36457(4.0f);
                break;
            }
            case 4: {
                MainSelfTest.gwi(class_3102, "fill ~5 ~ ~-2 ~5 ~6 ~-2 minecraft:oak_log");
                break;
            }
            case 5: {
                MainSelfTest.gwi(class_3102, "fill ~12 ~ ~3 ~12 ~9 ~3 minecraft:stone_bricks");
                break;
            }
            case 6: {
                MainSelfTest.gwi(class_3102, "fill ~22 ~ ~-8 ~22 ~12 ~8 minecraft:stone_bricks");
                break;
            }
            case 7: {
                MainSelfTest.gwi(class_3102, "fill ~9 ~ ~-7 ~9 ~4 ~-5 minecraft:spruce_planks");
                break;
            }
            case 8: {
                MainSelfTest.gwi(class_3102, "fill ~16 ~ ~6 ~18 ~3 ~8 minecraft:mossy_cobblestone");
                break;
            }
            case 60: {
                MainSelfTest.gwp(class_3102, "fog-00-off");
                break;
            }
            case 61: {
                kfe2.setEnabled(true);
                FogPass.timing(true);
                break;
            }
            case 100: {
                FogPass.gpuMillis();
                break;
            }
            case 140: {
                MainSelfTest.gwd("Высокое");
                MainSelfTest.gwp(class_3102, "fog-01-sunrise-east");
                vlv2.set("Низкое");
                break;
            }
            case 141: 
            case 181: 
            case 221: {
                FogPass.gpuMillis();
                break;
            }
            case 180: {
                MainSelfTest.gwd("Низкое");
                vlv2.set("Среднее");
                break;
            }
            case 220: {
                MainSelfTest.gwd("Среднее");
                vlv2.set("Ультра");
                break;
            }
            case 260: {
                MainSelfTest.gwd("Ультра");
                MainSelfTest.gwp(class_3102, "fog-01b-ultra");
                vlv2.set("Высокое");
                class_3102.field_1724.method_36456(90.0f);
                break;
            }
            case 300: {
                MainSelfTest.gwp(class_3102, "fog-02-sunrise-west");
                break;
            }
            case 301: {
                MainSelfTest.gwi(class_3102, "time set 6000");
                class_3102.field_1724.method_36456(-60.0f);
                break;
            }
            case 340: {
                MainSelfTest.gwp(class_3102, "fog-03-noon");
                break;
            }
            case 341: {
                MainSelfTest.gwi(class_3102, "time set 12400");
                class_3102.field_1724.method_36456(90.0f);
                break;
            }
            case 380: {
                MainSelfTest.gwp(class_3102, "fog-04-sunset");
                break;
            }
            case 381: {
                MainSelfTest.gwi(class_3102, "time set 18000");
                break;
            }
            case 420: {
                MainSelfTest.gwp(class_3102, "fog-05-night");
                break;
            }
            case 421: {
                MainSelfTest.gwi(class_3102, "time set 2000");
                class_3102.field_1724.method_31549().field_7479 = true;
                MainSelfTest.gwi(class_3102, "tp @s ~ ~22 ~");
                break;
            }
            case 425: {
                class_3102.field_1724.method_36457(35.0f);
                class_3102.field_1724.method_36456(-60.0f);
                break;
            }
            case 470: {
                MainSelfTest.gwp(class_3102, "fog-06-above");
                break;
            }
            case 471: {
                MainSelfTest.gwi(class_3102, "tp @s ~ ~-22 ~");
                break;
            }
            case 475: {
                class_3102.field_1724.method_36457(10.0f);
                class_3102.field_1724.method_36456(-90.0f);
                ((ColorSetting)MainSelfTest.gwg(kfe2, "Цвет")).set("Aurora");
                break;
            }
            case 510: {
                MainSelfTest.gwp(class_3102, "fog-07-aurora");
                break;
            }
            case 511: {
                ((ColorSetting)MainSelfTest.gwg(kfe2, "Цвет")).set("Snow");
                class_3102.field_1690.method_31043(class_5498.field_26665);
                class_3102.field_1724.method_36457(22.0f);
                class_3102.field_1724.method_36456(0.0f);
                break;
            }
            case 550: {
                MainSelfTest.gwp(class_3102, "fog-08-stand-3p");
                break;
            }
        }
        if (gts > 552 && gts <= 590) {
            class_3102.field_1724.method_5814(class_3102.field_1724.method_23317(), class_3102.field_1724.method_23318(), class_3102.field_1724.method_23321() + 0.28);
        }
        switch (gts) {
            case 591: {
                MainSelfTest.gwp(class_3102, "fog-09-wake-3p");
                break;
            }
            case 620: {
                MainSelfTest.gwp(class_3102, "fog-10-wake-later");
                break;
            }
            case 621: {
                class_3102.field_1690.method_31043(class_5498.field_26664);
                break;
            }
            case 660: {
                MainSelfTest.gwd("first person");
                MainSelfTest.gwp(class_3102, "fog-11-first-person");
                break;
            }
            case 661: {
                kfe2.setEnabled(false);
                FogPass.timing(false);
                break;
            }
            case 690: {
                MainSelfTest.gwp(class_3102, "fog-12-off-again");
                System.out.println("fog test done");
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvy(class_310 class_3102) throws Exception {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("VolumetricFog");
        switch (gts) {
            case 1: {
                MainSelfTest.gwi(class_3102, "gamemode creative");
                MainSelfTest.gwi(class_3102, "time set 1000");
                MainSelfTest.gwi(class_3102, "weather clear");
                MainSelfTest.gwi(class_3102, "tp @s 0 ~ 0");
                break;
            }
            case 4: {
                MainSelfTest.gwi(class_3102, "fill 5 ~ -2 5 ~6 -2 minecraft:oak_log");
                break;
            }
            case 5: {
                MainSelfTest.gwi(class_3102, "fill 12 ~ 3 12 ~9 3 minecraft:stone_bricks");
                break;
            }
            case 6: {
                MainSelfTest.gwi(class_3102, "fill 22 ~ -8 22 ~12 8 minecraft:stone_bricks");
                break;
            }
            case 7: {
                MainSelfTest.gwi(class_3102, "fill -9 ~ -7 -9 ~4 -5 minecraft:spruce_planks");
                break;
            }
            case 8: {
                MainSelfTest.gwi(class_3102, "fill -16 ~ 6 -18 ~3 8 minecraft:mossy_cobblestone");
                break;
            }
            case 9: {
                MainSelfTest.gwi(class_3102, "fill 3 ~ -14 4 ~7 -13 minecraft:birch_log");
                break;
            }
            case 40: {
                kfe2.setEnabled(true);
                FogPass.timing(true);
                break;
            }
            case 90: {
                FogPass.gpuMillis();
                break;
            }
            case 130: {
                MainSelfTest.gvz(class_3102, -90.0f, 4.0f, "east");
                break;
            }
            case 170: {
                MainSelfTest.gvz(class_3102, 90.0f, 4.0f, "west");
                break;
            }
            case 210: {
                MainSelfTest.gvz(class_3102, 180.0f, -2.0f, "north");
                break;
            }
            case 211: {
                class_3102.field_1724.method_31549().field_7479 = true;
                MainSelfTest.gwi(class_3102, "tp @s 0 ~20 0");
                break;
            }
            case 260: {
                MainSelfTest.gvz(class_3102, -60.0f, 35.0f, "above");
                break;
            }
            case 261: {
                MainSelfTest.gwi(class_3102, "tp @s 0 ~-20 0");
                MainSelfTest.gwi(class_3102, "time set 12300");
                break;
            }
            case 300: {
                MainSelfTest.gvz(class_3102, 90.0f, 2.0f, "sunset");
                break;
            }
            case 311: {
                MainSelfTest.gwi(class_3102, "time set 3000");
                ((NumberSetting)MainSelfTest.gwg(kfe2, "Плотность")).set(0.8);
                break;
            }
            case 340: {
                MainSelfTest.gvz(class_3102, -30.0f, 0.0f, "dense");
                break;
            }
            case 351: {
                ((NumberSetting)MainSelfTest.gwg(kfe2, "Плотность")).set(0.2);
                break;
            }
            case 380: {
                MainSelfTest.gvz(class_3102, -30.0f, 0.0f, "light");
                break;
            }
            case 391: {
                ((NumberSetting)MainSelfTest.gwg(kfe2, "Плотность")).set(0.45);
                MainSelfTest.gwi(class_3102, "time set 18000");
                break;
            }
            case 400: {
                MainSelfTest.gvz(class_3102, -90.0f, 4.0f, "night");
                break;
            }
            case 420: {
                Module kfe3 = Flow.getInstance().getModuleManager().getByName("FullBright");
                ((ModeSetting)MainSelfTest.gwg(kfe3, "Mode")).set("Full");
                kfe3.setEnabled(true);
                break;
            }
            case 430: {
                MainSelfTest.gvz(class_3102, -90.0f, 4.0f, "night-fullbright");
                break;
            }
            case 450: {
                Flow.getInstance().getModuleManager().getByName("FullBright").setEnabled(false);
                kfe2.setEnabled(false);
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gvz(class_310 class_3102, float f, float f2, String string) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
        guq = string;
        gus = gts + 8;
    }

    private static void gwa(class_310 class_3102) {
        if (gts == gus) {
            MainSelfTest.gwd(guq);
            MainSelfTest.gwp(class_3102, gur + ++gup + "-" + guq);
        }
    }

    private static void gwb(class_310 class_3102) throws Exception {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
        ModeSetting vlv2 = (ModeSetting)MainSelfTest.gwg(kfe2, "Season");
        Module kfe3 = Flow.getInstance().getModuleManager().getByName("FullBright");
        gur = "weather-";
        switch (gts) {
            case 1: {
                MainSelfTest.gwi(class_3102, "gamemode creative");
                MainSelfTest.gwi(class_3102, "time set 1500");
                MainSelfTest.gwi(class_3102, "weather clear");
                MainSelfTest.gwi(class_3102, "tp @s 0 ~ 0");
                break;
            }
            case 3: {
                MainSelfTest.gwi(class_3102, "fill -14 ~-1 -14 14 ~-1 14 minecraft:stone_bricks");
                break;
            }
            case 4: {
                MainSelfTest.gwi(class_3102, "fill -14 ~-1 -14 -4 ~-1 14 minecraft:grass_block");
                break;
            }
            case 5: {
                MainSelfTest.gwi(class_3102, "fill 8 ~ -3 8 ~7 -3 minecraft:quartz_pillar");
                break;
            }
            case 6: {
                MainSelfTest.gwi(class_3102, "fill 8 ~ 3 8 ~7 3 minecraft:quartz_pillar");
                break;
            }
            case 7: {
                MainSelfTest.gwi(class_3102, "fill 14 ~ -8 14 ~9 8 minecraft:red_terracotta");
                break;
            }
            case 8: {
                MainSelfTest.gwi(class_3102, "fill -3 ~3 5 1 ~3 9 minecraft:oak_planks");
                break;
            }
            case 9: {
                MainSelfTest.gwi(class_3102, "fill 3 ~-1 6 6 ~-1 9 minecraft:water");
                break;
            }
            case 10: {
                MainSelfTest.gwi(class_3102, "setblock 6 ~ 1 minecraft:lantern");
                break;
            }
            case 11: {
                MainSelfTest.gwi(class_3102, "setblock 4 ~ -2 minecraft:glowstone");
                break;
            }
            case 12: {
                MainSelfTest.gwi(class_3102, "fill -13 ~ 9 -9 ~3 13 minecraft:oak_leaves[persistent=true]");
                break;
            }
            case 13: {
                MainSelfTest.gwi(class_3102, "fill -12 ~ -12 -8 ~2 -8 minecraft:birch_leaves[persistent=true]");
                break;
            }
            case 40: {
                vlv2.set("Rain");
                kfe2.setEnabled(true);
                WeatherSeasonPass.timing(true);
                break;
            }
            case 70: {
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 80: {
                System.out.println("MediaFoundationVideo RenderPerfTest " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                MainSelfTest.gvz(class_3102, -90.0f, 12.0f, "east");
                break;
            }
            case 96: {
                if (System.getenv("FLOW2_SHORT") == null) break;
                class_3102.method_1592();
                gtr = 99;
                break;
            }
            case 100: {
                MainSelfTest.gvz(class_3102, 90.0f, 14.0f, "west");
                break;
            }
            case 120: {
                MainSelfTest.gvz(class_3102, 0.0f, 30.0f, "roof");
                break;
            }
            case 121: {
                MainSelfTest.gwi(class_3102, "tp @s -9 ~ -2");
                break;
            }
        }
        if (gts > 130 && gts <= 160) {
            class_3102.field_1724.method_36456(-90.0f);
            class_3102.field_1724.method_5814(class_3102.field_1724.method_23317() + 0.22, class_3102.field_1724.method_23318(), class_3102.field_1724.method_23321());
        }
        switch (gts) {
            case 163: {
                class_3102.field_1690.method_31043(class_5498.field_26665);
                MainSelfTest.gvz(class_3102, -90.0f, 45.0f, "prints");
                break;
            }
            case 180: {
                class_3102.field_1690.method_31043(class_5498.field_26664);
                MainSelfTest.gvz(class_3102, 90.0f, 55.0f, "prints-back");
                break;
            }
            case 200: {
                MainSelfTest.gwi(class_3102, "time set 12400");
                MainSelfTest.gvz(class_3102, 90.0f, 10.0f, "sunset");
                break;
            }
            case 220: {
                MainSelfTest.gwi(class_3102, "time set 18000");
                MainSelfTest.gvz(class_3102, -90.0f, 18.0f, "night");
                break;
            }
            case 232: {
                ((ModeSetting)MainSelfTest.gwg(kfe3, "Mode")).set("Full");
                kfe3.setEnabled(true);
                break;
            }
            case 236: {
                MainSelfTest.gvz(class_3102, -90.0f, 18.0f, "night-fullbright");
                break;
            }
            case 250: {
                kfe3.setEnabled(false);
                MainSelfTest.gwi(class_3102, "time set 6000");
                MainSelfTest.gwi(class_3102, "weather rain");
                ((NumberSetting)MainSelfTest.gwg(kfe2, "Drops")).set(1.0);
                MainSelfTest.gvz(class_3102, -90.0f, 55.0f, "rain");
                break;
            }
            case 270: {
                MainSelfTest.gwi(class_3102, "weather clear");
                vlv2.set("Winter");
                WeatherSeasonPass.gpuMillis();
                MainSelfTest.gvz(class_3102, -90.0f, 12.0f, "winter-day");
                break;
            }
            case 285: {
                System.out.println("season RenderPerfTest winter " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                break;
            }
            case 290: {
                MainSelfTest.gvz(class_3102, 150.0f, 8.0f, "winter-trees");
                break;
            }
            case 310: {
                MainSelfTest.gwi(class_3102, "time set 18000");
                MainSelfTest.gvz(class_3102, -90.0f, 12.0f, "winter-night");
                break;
            }
            case 330: {
                MainSelfTest.gwi(class_3102, "time set 6000");
                vlv2.set("Spring");
                MainSelfTest.gvz(class_3102, 150.0f, 8.0f, "spring-day");
                break;
            }
            case 350: {
                vlv2.set("Summer");
                MainSelfTest.gvz(class_3102, -90.0f, -20.0f, "summer-day");
                break;
            }
            case 370: {
                MainSelfTest.gwi(class_3102, "time set 18000");
                MainSelfTest.gvz(class_3102, 150.0f, 5.0f, "summer-night");
                break;
            }
            case 390: {
                MainSelfTest.gwi(class_3102, "time set 6000");
                vlv2.set("Autumn");
                WeatherSeasonPass.gpuMillis();
                MainSelfTest.gvz(class_3102, 150.0f, 8.0f, "autumn-day");
                break;
            }
            case 405: {
                System.out.println("season RenderPerfTest autumn " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                break;
            }
            case 410: {
                MainSelfTest.gwi(class_3102, "time set 18000");
                ((ModeSetting)MainSelfTest.gwg(kfe3, "Mode")).set("Full");
                kfe3.setEnabled(true);
                break;
            }
            case 414: {
                MainSelfTest.gvz(class_3102, 150.0f, 8.0f, "autumn-night-fullbright");
                break;
            }
            case 430: {
                kfe3.setEnabled(false);
                kfe2.setEnabled(false);
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gwc(class_310 class_3102) throws Exception {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
        ModeSetting vlv2 = (ModeSetting)MainSelfTest.gwg(kfe2, "Season");
        gur = "winter-";
        switch (gts) {
            case 1: {
                MainSelfTest.gwi(class_3102, "gamemode creative");
                MainSelfTest.gwi(class_3102, "time set 2500");
                MainSelfTest.gwi(class_3102, "weather clear");
                MainSelfTest.gwi(class_3102, "tp @s 0 ~ 0");
                break;
            }
            case 3: {
                MainSelfTest.gwi(class_3102, "fill -24 ~-1 -24 24 ~-1 24 minecraft:grass_block");
                break;
            }
            case 4: {
                MainSelfTest.gwi(class_3102, "fill 6 ~ -6 11 ~3 -1 minecraft:stone_bricks hollow");
                break;
            }
            case 5: {
                MainSelfTest.gwi(class_3102, "fill 5 ~4 -7 12 ~4 0 minecraft:spruce_planks");
                break;
            }
            case 6: {
                MainSelfTest.gwi(class_3102, "fill 8 ~1 -1 9 ~2 -1 minecraft:air");
                break;
            }
            case 7: {
                MainSelfTest.gwi(class_3102, "fill -9 ~ -3 -9 ~4 -3 minecraft:spruce_log");
                break;
            }
            case 8: {
                MainSelfTest.gwi(class_3102, "fill -11 ~3 -5 -7 ~5 -1 minecraft:spruce_leaves[persistent=true]");
                break;
            }
            case 9: {
                MainSelfTest.gwi(class_3102, "fill -3 ~-1 6 3 ~-1 11 minecraft:water");
                break;
            }
            case 10: {
                MainSelfTest.gwi(class_3102, "fill 4 ~ 5 6 ~ 9 minecraft:cobblestone");
                break;
            }
            case 11: {
                MainSelfTest.gwi(class_3102, "fill 5 ~1 6 6 ~1 8 minecraft:cobblestone");
                break;
            }
            case 12: {
                MainSelfTest.gwi(class_3102, "setblock -4 ~ -8 minecraft:lantern");
                break;
            }
            case 13: {
                MainSelfTest.gwi(class_3102, "fill -16 ~ 3 -14 ~6 5 minecraft:quartz_pillar");
                break;
            }
            case 14: {
                MainSelfTest.gwi(class_3102, "fill -2 ~ -12 2 ~1 -12 minecraft:oak_fence");
                break;
            }
            case 40: {
                vlv2.set("Winter");
                kfe2.setEnabled(true);
                WeatherSeasonPass.timing(true);
                break;
            }
            case 70: {
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 90: {
                System.out.println("winter RenderPerfTest " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                MainSelfTest.gvz(class_3102, -90.0f, 14.0f, "day-east");
                break;
            }
            case 110: {
                MainSelfTest.gvz(class_3102, -135.0f, 10.0f, "house");
                break;
            }
            case 130: {
                MainSelfTest.gvz(class_3102, 108.0f, -8.0f, "trees");
                break;
            }
            case 150: {
                MainSelfTest.gvz(class_3102, 0.0f, 25.0f, "ice");
                break;
            }
            case 170: {
                MainSelfTest.gvz(class_3102, -36.0f, 24.0f, "steps");
                break;
            }
            case 180: {
                MainSelfTest.gvz(class_3102, 30.0f, 62.0f, "close");
                break;
            }
            case 190: {
                MainSelfTest.gwi(class_3102, "tp @s -20 ~ 18");
                break;
            }
        }
        if (gts > 203 && gts <= 233) {
            class_3102.field_1724.method_36456(-90.0f);
            class_3102.field_1724.method_5814(class_3102.field_1724.method_23317() + 0.2, class_3102.field_1724.method_23318(), class_3102.field_1724.method_23321());
        }
        switch (gts) {
            case 236: {
                MainSelfTest.gvz(class_3102, 90.0f, 55.0f, "prints");
                break;
            }
            case 250: {
                MainSelfTest.gwi(class_3102, "tp @s 0 ~ 0");
                MainSelfTest.gwi(class_3102, "time set 12200");
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 270: {
                MainSelfTest.gvz(class_3102, -100.0f, 10.0f, "sunset");
                break;
            }
            case 282: {
                System.out.println("winter RenderPerfTest sunset " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                MainSelfTest.gwi(class_3102, "time set 18000");
                break;
            }
            case 310: {
                MainSelfTest.gvz(class_3102, 60.0f, 12.0f, "night");
                break;
            }
            case 325: {
                MainSelfTest.gwi(class_3102, "time set 6000");
                ((NumberSetting)MainSelfTest.gwg(kfe2, "Particles")).set(1.0);
                break;
            }
            case 345: {
                WeatherSeasonPass.gpuMillis();
                MainSelfTest.gvz(class_3102, -60.0f, 6.0f, "heavy");
                break;
            }
            case 357: {
                System.out.println("winter RenderPerfTest heavy " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                break;
            }
            case 360: {
                ((NumberSetting)MainSelfTest.gwg(kfe2, "Particles")).set(0.6);
                class_3102.field_1724.method_36456(-90.0f);
                class_3102.field_1724.method_36457(30.0f);
                break;
            }
            case 380: {
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 440: {
                System.out.println("winter RenderPerfTest ground " + MainSelfTest.gwn(WeatherSeasonPass.gpuMillis()) + " ms");
                break;
            }
            case 445: {
                kfe2.setEnabled(false);
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gwd(String string) {
        System.out.println("fog RenderPerfTest " + string + " " + MainSelfTest.gwn(FogPass.gpuMillis()) + " ms");
    }

    private static void gwe(class_310 class_3102) throws Exception {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        Module kfe2 = kfx2.getByName("FullBright");
        Module kfe3 = kfx2.getByName("CustomTime");
        switch (gts) {
            case 1: {
                MainSelfTest.gwi(class_3102, "gamemode creative");
                MainSelfTest.gwi(class_3102, "time set 6000");
                class_3102.field_1724.method_36456(0.0f);
                class_3102.field_1724.method_36457(15.0f);
                break;
            }
            case 5: {
                MainSelfTest.gwi(class_3102, "fill ~-4 ~-1 ~-4 ~4 ~4 ~4 minecraft:stone hollow");
                break;
            }
            case 50: {
                MainSelfTest.gwp(class_3102, "bright-room-off");
                break;
            }
            case 51: {
                ((ModeSetting)MainSelfTest.gwg(kfe2, "Mode")).set("Full");
                kfe2.setEnabled(true);
                break;
            }
            case 80: {
                MainSelfTest.gwp(class_3102, "bright-room-full");
                MainSelfTest.gwf(class_3102, "room full", 15.0, 16.0);
                break;
            }
            case 81: {
                ((ModeSetting)MainSelfTest.gwg(kfe2, "Mode")).set("Auto");
                break;
            }
            case 130: {
                MainSelfTest.gwp(class_3102, "bright-room-auto");
                MainSelfTest.gwf(class_3102, "room auto", 6.5, 8.0);
                break;
            }
            case 131: {
                MainSelfTest.gwi(class_3102, "fill ~-4 ~ ~-4 ~4 ~4 ~4 minecraft:air");
                break;
            }
            case 190: {
                MainSelfTest.gwp(class_3102, "bright-day-auto");
                MainSelfTest.gwf(class_3102, "day auto", 0.0, 1.05);
                break;
            }
            case 191: {
                ((NumberSetting)MainSelfTest.gwg(kfe3, "Time")).set(0.0);
                kfe3.setEnabled(true);
                break;
            }
            case 260: {
                boolean bl;
                MainSelfTest.gwp(class_3102, "bright-night-auto");
                MainSelfTest.gwf(class_3102, "night auto", 1.2, 1.7);
                long l = Math.floorMod(class_3102.field_1687.method_8532(), 24000L);
                boolean bl2 = bl = l == 18000L;
                if (!bl) {
                    ++gut;
                }
                System.out.println("bright custom time " + (bl ? "ok" : "FAIL") + " timeOfDay=" + l);
                break;
            }
            case 261: {
                kfe2.setEnabled(false);
                break;
            }
            case 280: {
                boolean bl;
                MainSelfTest.gwp(class_3102, "bright-night-off");
                double d = (Double)class_3102.field_1690.method_42473().method_41753();
                boolean bl3 = bl = d >= 0.0 && d <= 1.0;
                if (!bl) {
                    ++gut;
                }
                System.out.println("bright gamma back " + (bl ? "ok" : "FAIL") + " gamma=" + d);
                break;
            }
            case 281: {
                kfe2.setEnabled(true);
                break;
            }
            case 300: {
                boolean bl;
                class_3102.field_1690.method_1640();
                String string = "?";
                for (String string2 : Files.readAllLines(class_3102.field_1697.toPath().resolve("options.txt"))) {
                    if (!string2.startsWith("gamma:")) continue;
                    string = string2.substring(6);
                }
                boolean bl4 = bl = !string.equals("?") && Double.parseDouble(string) <= 1.0;
                if (!bl) {
                    ++gut;
                }
                System.out.println("bright saved gamma " + (bl ? "ok" : "FAIL") + " options.txt gamma=" + string + " live=" + class_3102.field_1690.method_42473().method_41753());
                break;
            }
            case 301: {
                kfe2.setEnabled(false);
                kfe3.setEnabled(false);
                break;
            }
            case 310: {
                boolean bl;
                long l = Math.floorMod(class_3102.field_1687.method_8532(), 24000L);
                boolean bl5 = bl = l != 18000L;
                if (!bl) {
                    ++gut;
                }
                System.out.println("bright server time back " + (bl ? "ok" : "FAIL") + " timeOfDay=" + l);
                MainSelfTest.gwp(class_3102, "bright-time-off");
                System.out.println("bright test " + (gut == 0 ? "PASS" : "FAIL (" + gut + ")"));
                class_3102.method_1592();
                gtr = 99;
                break;
            }
        }
    }

    private static void gwf(class_310 class_3102, String string, double d, double d2) {
        boolean bl;
        double d3 = (Double)class_3102.field_1690.method_42473().method_41753();
        boolean bl2 = bl = d3 >= d && d3 <= d2;
        if (!bl) {
            ++gut;
        }
        System.out.println("bright " + string + (bl ? " ok" : " FAIL") + " gamma=" + String.format(Locale.ROOT, "%.2f", d3) + " (want " + d + ".." + d2 + ")");
    }

    private static Setting gwg(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void gwh(class_310 class_3102, String string, int n, int n2) {
        boolean bl;
        StructureTimers pbz2 = StructureTimers.get();
        int n3 = 0;
        try {
            for (Field field : class_337.class.getDeclaredFields()) {
                if (!Map.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                n3 = ((Map)field.get(class_3102.field_1705.method_1740())).size();
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            n3 = -1;
        }
        boolean bl2 = bl = (n < 0 || pbz2.count() == n) && n3 == n2;
        if (!bl) {
            ++guo;
        }
        System.out.println("structures " + string + (bl ? " ok" : " FAIL") + " count=" + pbz2.count() + " bars=" + n3 + " : " + pbz2.describe());
    }

    private static void gwi(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void gwj(class_310 class_3102, String string, String string2, int n) {
        MainSelfTest.gwi(class_3102, "clear @s");
        MainSelfTest.gwi(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
        MainSelfTest.gwi(class_3102, "item replace entity @s " + string + " with minecraft:wind_charge 8");
        MainSelfTest.gwi(class_3102, "item replace entity @s " + string2 + " with minecraft:mace");
        class_3102.field_1724.method_31548().method_61496(n);
    }

    private static void gwk(class_310 class_3102, Module kfe2, int n, float f) {
        class_746 class_7462 = class_3102.field_1724;
        class_7462.method_31548().method_61496(0);
        class_7462.method_36457(f);
        gui = f;
        gug = Float.NaN;
        guh = guf = class_7462.method_23318();
        System.out.println("wind press: onGround=" + class_7462.method_24828() + " y=" + MainSelfTest.gwn(class_7462.method_23318()) + " held=" + class_7462.method_6047().method_7909() + " slot=" + class_7462.method_31548().method_67532());
        kfe2.onKey(class_3102, n);
    }

    private static void gwl(class_310 class_3102, String string) {
        class_746 class_7462 = class_3102.field_1724;
        System.out.println("wind " + string + " t" + gts + ": busy=" + ServerHelper.busy() + " hand=" + class_7462.method_6047().method_7909() + " slot=" + class_7462.method_31548().method_67532() + " pitch=" + MainSelfTest.gwn(class_7462.method_36455()) + " y=" + MainSelfTest.gwn(class_7462.method_23318()) + " vy=" + MainSelfTest.gwn(class_7462.method_18798().field_1351));
    }

    private static void gwm(class_310 class_3102, String string, class_1792 class_17922, int n, int n2, int n3, double d, double d2) {
        double d3;
        class_746 class_7462 = class_3102.field_1724;
        class_1661 class_16612 = class_7462.method_31548();
        class_1799 class_17992 = class_16612.method_5438(n);
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder();
        if (!class_7462.method_6047().method_31574(class_17922)) {
            bl = false;
            stringBuilder.append(" hand=").append(class_7462.method_6047().method_7909());
        }
        if (!class_17992.method_31574(class_1802.field_49098) || class_17992.method_7947() != n2) {
            bl = false;
            stringBuilder.append(" charge@").append(n).append('=').append(class_17992);
        }
        if (class_16612.method_67532() != n3) {
            bl = false;
            stringBuilder.append(" slot=").append(class_16612.method_67532());
        }
        if (Float.isNaN(gug) || Math.abs(gug - gui) > 0.01f) {
            bl = false;
            stringBuilder.append(" pitch=").append(MainSelfTest.gwn(gug));
        }
        if ((d3 = guh - guf) < d || d3 > d2) {
            bl = false;
            stringBuilder.append(" rose ").append(MainSelfTest.gwn(d3)).append(" (want ").append(MainSelfTest.gwn(d)).append("..").append(MainSelfTest.gwn(d2)).append(')');
        }
        if (ServerHelper.busy()) {
            bl = false;
            stringBuilder.append(" still busy");
        }
        if (!bl) {
            ++guj;
        }
        System.out.println("wind " + string + (bl ? " ok" : " FAIL" + stringBuilder) + "  (rose " + MainSelfTest.gwn(guh - guf) + ", hand " + class_7462.method_6047().method_7909() + ")");
    }

    private static String gwn(double d) {
        return String.format(Locale.ROOT, "%.2f", d);
    }

    private static void gwo() {
        ++gtr;
        gts = 0;
    }

    private static void gwp(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps, screen=" + (class_3102.field_1755 == null ? "none" : class_3102.field_1755.getClass().getSimpleName()));
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static void gwq(class_437 class_4372, int n) {
        if (class_4372 != null) {
            class_4372.method_25404(new class_11908(n, 0, 0));
        }
    }

    private static void gwr(class_437 class_4372, String string) {
        if (class_4372 != null) {
            for (char c : string.toCharArray()) {
                class_4372.method_25400(new class_11905((int)c, 0));
            }
        }
    }

    private static void gws(class_437 class_4372, float f, float f2, int n) throws Exception {
        if (!(class_4372 instanceof ClickGuiScreen)) {
            return;
        }
        float f3 = MainSelfTest.gwu(class_4372, "originX");
        float f4 = MainSelfTest.gwu(class_4372, "originY");
        float f5 = MainSelfTest.gwu(class_4372, "scale");
        class_4372.method_25402(new class_11909((double)(f3 + f * f5), (double)(f4 + f2 * f5), new class_11910(n, 0)), false);
    }

    private static void gwt(class_437 class_4372, float f, float f2, double d) throws Exception {
        if (!(class_4372 instanceof ClickGuiScreen)) {
            return;
        }
        float f3 = MainSelfTest.gwu(class_4372, "originX");
        float f4 = MainSelfTest.gwu(class_4372, "originY");
        float f5 = MainSelfTest.gwu(class_4372, "scale");
        class_4372.method_25401((double)(f3 + f * f5), (double)(f4 + f2 * f5), 0.0, d);
    }

    private static float gwu(Object object, String string) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    static {
        gtt = System.getenv("FLOW2_SELFTEST_SCENE");
        gtu = new ArrayList<class_1657>();
        gtx = new String[]{"off", "HUD liquid", "off", "HUD solid", "off", "nametags glass", "off", "all on", "off", "all on turning", "off turning", "all on turning"};
        gty = new int[]{0, 1, 0, 4, 0, 5, 0, 7, 0, 8, 9, 8};
        gue = new ArrayList<class_3213>();
        gug = Float.NaN;
        guk = new int[]{Integer.MIN_VALUE, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 8};
        gur = "fog-look-";
        gus = -1;
    }

    private static /* synthetic */ int xc(int n, int n2) {
        return n * n2 | 0x9AFD7752;
    }
}

