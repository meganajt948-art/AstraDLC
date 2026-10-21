/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_745
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.GuiConfig;
import a.Hud;
import a.Module;
import a.ModuleManager;
import a.HitParticles;
import a.BoolSetting;
import a.KeySetting;
import a.ModeSetting;
import a.Setting;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_745;

final class TargetEspTest {
    private static final List<class_1657> hfj = new ArrayList<class_1657>();
    private static class_1657 hfk;
    private static final int hfl = 80;
    private static final String[] hfm;
    private static final String[] hfn;
    private static long hfo;
    private static long hfp;
    private static boolean hfq;
    private static /* synthetic */ String hfr;
    private static /* synthetic */ int hfs;

    private TargetEspTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        HitParticles ruv2 = (HitParticles)kfx2.getByName("TargetESP");
        switch (n) {
            case 1: {
                TargetEspTest.hgb(class_3102, "gamemode creative");
                TargetEspTest.hgb(class_3102, "time set 6000");
                TargetEspTest.hgb(class_3102, "weather clear");
                TargetEspTest.hfw(class_3102, 0.0f, 8.0f);
                hfk = TargetEspTest.hfy(class_3102, "Dream", 3.2, 0.0);
                hfk.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_22022));
                HitParticles.onAttack((class_1297)hfk);
                ruv2.mode.set("Ghosts");
                ruv2.setEnabled(true);
                Hud.TARGET.enabled.set(false);
                break;
            }
            case 22: {
                TargetEspTest.hgd(class_3102, "v01-esp-ghosts");
                break;
            }
            case 23: {
                ruv2.mode.set("Sparkles");
                break;
            }
            case 42: {
                TargetEspTest.hgd(class_3102, "v02-esp-sparkles");
                break;
            }
            case 43: {
                ruv2.mode.set("Ring");
                break;
            }
            case 56: {
                TargetEspTest.hgd(class_3102, "v03-esp-ring");
                break;
            }
            case 63: {
                TargetEspTest.hgd(class_3102, "v03b-esp-ring");
                break;
            }
            case 64: {
                ruv2.mode.set("Comets");
                break;
            }
            case 80: {
                TargetEspTest.hgd(class_3102, "v04-esp-comets");
                break;
            }
            case 81: {
                ruv2.mode.set("Lightning");
                break;
            }
            case 90: {
                TargetEspTest.hfk.field_6235 = 10;
                TargetEspTest.hfk.field_6254 = 10;
                HitParticles.onAttack((class_1297)hfk);
                break;
            }
            case 91: {
                TargetEspTest.hgd(class_3102, "v05-esp-lightning-hit");
                break;
            }
            case 100: {
                TargetEspTest.hgd(class_3102, "v05b-esp-lightning");
                System.out.println("visual esp cpu " + TargetEspTest.hgc(HitParticles.cpuMicros()) + " us/frame");
                break;
            }
            case 101: {
                ruv2.setEnabled(false);
                Hud.TARGET.enabled.set(true);
                TargetEspTest.hfz(class_3102, (class_1297)hfk);
                TargetEspTest.hfu(kfx2, "ItemESP", true);
                TargetEspTest.hfu(kfx2, "ItemPhysics", true);
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~1 ~0.5 ~2.5 {Item:{id:\"minecraft:diamond\",count:12},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~-0.8 ~0.5 ~3.2 {Item:{id:\"minecraft:golden_apple\",count:3},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~0.2 ~0.5 ~4.4 {Item:{id:\"minecraft:netherite_sword\",count:1},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~-2 ~0.5 ~5 {Item:{id:\"minecraft:cobblestone\",count:64},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~-2.3 ~0.5 ~5.2 {Item:{id:\"minecraft:cobblestone\",count:64},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~2 ~0.5 ~6 {Item:{id:\"minecraft:ender_pearl\",count:16},PickupDelay:32767}");
                TargetEspTest.hfw(class_3102, 0.0f, 38.0f);
                break;
            }
            case 140: {
                TargetEspTest.hgd(class_3102, "v06-items");
                break;
            }
            case 141: {
                TargetEspTest.hgb(class_3102, "kill @e[type=item]");
                TargetEspTest.hfu(kfx2, "ItemESP", false);
                class_3102.field_1724.method_31548().method_61496(0);
                class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8634, 16));
                TargetEspTest.hfu(kfx2, "Predictions", true);
                TargetEspTest.hfw(class_3102, 0.0f, -12.0f);
                break;
            }
            case 150: {
                TargetEspTest.hgd(class_3102, "v07-pearl-far");
                break;
            }
            case 151: {
                TargetEspTest.hfw(class_3102, 30.0f, 32.0f);
                break;
            }
            case 160: {
                TargetEspTest.hgd(class_3102, "v08-pearl-near");
                break;
            }
            case 161: {
                TargetEspTest.hfu(kfx2, "Predictions", false);
                class_3102.field_1724.method_31548().method_5447(0, class_1799.field_8037);
                TargetEspTest.hgb(class_3102, "setblock ~1 ~ ~3 minecraft:stone");
                TargetEspTest.hgb(class_3102, "setblock ~ ~ ~3 minecraft:oak_log");
                TargetEspTest.hfu(kfx2, "BlockOutline", true);
                TargetEspTest.hfx(class_3102, new class_243(Math.floor(class_3102.field_1724.method_23317()) + 0.5, Math.floor(class_3102.field_1724.method_23318()) + 0.6, Math.floor(class_3102.field_1724.method_23321()) + 3.5));
                break;
            }
            case 172: {
                TargetEspTest.hgd(class_3102, "v09-outline");
                break;
            }
            case 173: {
                TargetEspTest.hfu(kfx2, "BlockOutline", false);
                TargetEspTest.hgb(class_3102, "setblock ~1 ~ ~3 minecraft:air");
                TargetEspTest.hgb(class_3102, "setblock ~ ~ ~3 minecraft:air");
                TargetEspTest.hfw(class_3102, 0.0f, 8.0f);
                hfj.add(TargetEspTest.hfy(class_3102, "Behind", -6.0, 1.0));
                hfj.add(TargetEspTest.hfy(class_3102, "Kolya", 3.0, -7.0));
                hfj.add(TargetEspTest.hfy(class_3102, "Right", 1.0, 9.0));
                hfj.add(TargetEspTest.hfy(class_3102, "Far", 40.0, 25.0));
                Friends.add("Kolya");
                Module kfe2 = kfx2.getByName("Arrows");
                ((BoolSetting)TargetEspTest.hfv(kfe2, "Distance")).set(true);
                kfe2.setEnabled(true);
                break;
            }
            case 185: {
                TargetEspTest.hgd(class_3102, "v10-arrows");
                break;
            }
            case 186: {
                TargetEspTest.hfu(kfx2, "Arrows", false);
                for (class_1657 class_16572 : hfj) {
                    TargetEspTest.hfz(class_3102, (class_1297)class_16572);
                }
                hfj.clear();
                Friends.remove("Kolya");
                TargetEspTest.hgb(class_3102, "gamemode survival");
                class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8176, 8));
                break;
            }
            case 190: {
                class_3102.field_1724.method_7344().method_7580(11);
                class_3102.field_1724.method_7344().method_7581(4.5f);
                break;
            }
            case 192: {
                TargetEspTest.hgd(class_3102, "v11-saturation");
                break;
            }
            case 193: {
                TargetEspTest.hgb(class_3102, "gamemode creative");
                class_3102.field_1724.method_31548().method_5447(0, class_1799.field_8037);
                TargetEspTest.hfw(class_3102, 35.0f, 4.0f);
                break;
            }
            case 200: {
                TargetEspTest.hgd(class_3102, "v12-shaders-off");
                break;
            }
            case 201: {
                TargetEspTest.hfu(kfx2, "Shaders", true);
                break;
            }
            case 210: {
                TargetEspTest.hgd(class_3102, "v13-shaders-soft");
                break;
            }
            case 211: {
                ((ModeSetting)TargetEspTest.hfv(kfx2.getByName("Shaders"), "Look")).set("Vivid");
                break;
            }
            case 220: {
                TargetEspTest.hgd(class_3102, "v14-shaders-vivid");
                break;
            }
            case 221: {
                ((ModeSetting)TargetEspTest.hfv(kfx2.getByName("Shaders"), "Look")).set("Soft");
                TargetEspTest.hfu(kfx2, "Shaders", false);
                break;
            }
            case 222: {
                Module kfe3 = kfx2.getByName("Zoom");
                ((ModeSetting)TargetEspTest.hfv(kfe3, "Press")).set("Toggle");
                kfe3.setEnabled(true);
                kfe3.onKey(class_3102, ((KeySetting)TargetEspTest.hfv(kfe3, "Key")).get());
                break;
            }
            case 240: {
                TargetEspTest.hgd(class_3102, "v15-zoom");
                break;
            }
            case 241: {
                Module kfe4 = kfx2.getByName("Zoom");
                kfe4.onKey(class_3102, ((KeySetting)TargetEspTest.hfv(kfe4, "Key")).get());
                break;
            }
            case 255: {
                Module kfe5 = kfx2.getByName("Zoom");
                ((ModeSetting)TargetEspTest.hfv(kfe5, "Press")).set("Hold");
                kfe5.setEnabled(false);
                System.out.println("visual zoom back: fov " + class_3102.field_1690.method_41808().method_41753());
                break;
            }
            case 256: {
                hfk = TargetEspTest.hfy(class_3102, "Dream", 3.2, 0.0);
                TargetEspTest.hfu(kfx2, "FreeCam", true);
                class_3102.field_1690.field_1894.method_23481(true);
                class_3102.field_1690.field_1903.method_23481(true);
                break;
            }
            case 266: {
                class_3102.field_1690.field_1894.method_23481(false);
                class_3102.field_1690.field_1903.method_23481(false);
                class_3102.field_1724.method_36456(class_3102.field_1724.method_36454() + 180.0f);
                class_3102.field_1724.method_36457(25.0f);
                break;
            }
            case 276: {
                TargetEspTest.hgd(class_3102, "v16-freecam");
                System.out.println("visual freecam: camera " + class_3102.method_1560().getClass().getSimpleName() + " at " + TargetEspTest.hgc(class_3102.method_1560().method_23318()) + ", player at " + TargetEspTest.hgc(class_3102.field_1724.method_23318()));
                break;
            }
            case 277: {
                TargetEspTest.hfu(kfx2, "FreeCam", false);
                break;
            }
            case 280: {
                Module kfe6 = kfx2.getByName("FreeLook");
                ((ModeSetting)TargetEspTest.hfv(kfe6, "Press")).set("Toggle");
                kfe6.setEnabled(true);
                kfe6.onKey(class_3102, ((KeySetting)TargetEspTest.hfv(kfe6, "Key")).get());
                break;
            }
            case 283: {
                class_3102.field_1724.method_36456(class_3102.field_1724.method_36454() + 140.0f);
                break;
            }
            case 295: {
                TargetEspTest.hgd(class_3102, "v17-freelook");
                System.out.println("visual freelook: body yaw " + TargetEspTest.hgc(class_3102.field_1724.field_6283) + " camera yaw " + TargetEspTest.hgc(class_3102.field_1773.method_19418().method_19330()));
                break;
            }
            case 296: {
                Module kfe7 = kfx2.getByName("FreeLook");
                kfe7.onKey(class_3102, ((KeySetting)TargetEspTest.hfv(kfe7, "Key")).get());
                ((ModeSetting)TargetEspTest.hfv(kfe7, "Press")).set("Hold");
                kfe7.setEnabled(false);
                TargetEspTest.hfz(class_3102, (class_1297)hfk);
                break;
            }
            case 300: {
                TargetEspTest.hgb(class_3102, "weather rain");
                TargetEspTest.hfw(class_3102, 0.0f, -20.0f);
                break;
            }
            case 330: {
                TargetEspTest.hgd(class_3102, "v18-rain");
                break;
            }
            case 331: {
                TargetEspTest.hfu(kfx2, "NoRender", true);
                break;
            }
            case 340: {
                ((BoolSetting)TargetEspTest.hfv(kfx2.getByName("NoRender"), "Rain")).set(true);
                break;
            }
            case 360: {
                TargetEspTest.hgd(class_3102, "v19-norender-rain");
                ((BoolSetting)TargetEspTest.hfv(kfx2.getByName("NoRender"), "Rain")).set(false);
                TargetEspTest.hgb(class_3102, "weather clear");
                break;
            }
            case 361: {
                TargetEspTest.hga(class_3102, "Render");
                break;
            }
            case 385: {
                TargetEspTest.hgd(class_3102, "v20-gui-render");
                break;
            }
            case 386: {
                TargetEspTest.hga(class_3102, "Player");
                break;
            }
            case 405: {
                TargetEspTest.hgd(class_3102, "v21-gui-player");
                break;
            }
            case 406: {
                TargetEspTest.hga(class_3102, "Combat");
                break;
            }
            case 425: {
                TargetEspTest.hgd(class_3102, "v22-gui-combat");
                break;
            }
            case 426: {
                TargetEspTest.hga(class_3102, "Misc");
                break;
            }
            case 445: {
                TargetEspTest.hgd(class_3102, "v23-gui-misc");
                break;
            }
            case 446: {
                class_3102.method_1507(null);
                TargetEspTest.hft();
                TargetEspTest.hfw(class_3102, 0.0f, 12.0f);
                hfk = TargetEspTest.hfy(class_3102, "Dream", 3.2, 0.0);
                HitParticles.onAttack((class_1297)hfk);
                for (int i = 0; i < 4; ++i) {
                    hfj.add(TargetEspTest.hfy(class_3102, "P" + i, 6.0 + (double)(i * 5), (double)(i % 2 == 0 ? -1 : 1) * (4.0 + (double)(i * 3))));
                }
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~1 ~0.5 ~5 {Item:{id:\"minecraft:diamond\",count:12},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~-1 ~0.5 ~6 {Item:{id:\"minecraft:golden_apple\",count:3},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "summon minecraft:item ~2 ~0.5 ~7 {Item:{id:\"minecraft:cobblestone\",count:64},PickupDelay:32767}");
                TargetEspTest.hgb(class_3102, "setblock ~ ~ ~6 minecraft:stone");
                class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8634, 16));
                ruv2.mode.set("Sparkles");
                break;
            }
            default: {
                if (n > 450 && n <= 450 + 80 * hfm.length) {
                    int n2 = (n - 451) / 80;
                    int n3 = (n - 451) % 80;
                    String string = hfm[n2];
                    if (n3 == 0) {
                        for (String string2 : hfn) {
                            boolean bl = string2.equals("Shaders");
                            TargetEspTest.hfu(kfx2, string2, string.equals("all on") || string.equals("shaders") && bl || string.equals("all but shaders") && !bl);
                        }
                        HitParticles.cpuMicros();
                        break;
                    }
                    if (n3 == 20) {
                        hfo = 0L;
                        hfp = System.nanoTime();
                        break;
                    }
                    if (n3 != 79) break;
                    double d = (double)(System.nanoTime() - hfp) / 1.0E9;
                    double d2 = d * 1000.0 / (double)Math.max(1L, hfo);
                    System.out.println("visual cost " + string + ": " + TargetEspTest.hgc(d2) + " ms/frame (" + Math.round((double)hfo / d) + " fps), ESP cpu " + TargetEspTest.hgc(HitParticles.cpuMicros()) + " us/frame");
                    break;
                }
                if (n <= 450 + 80 * hfm.length) break;
                for (String string : hfn) {
                    TargetEspTest.hfu(kfx2, string, false);
                }
                TargetEspTest.hfz(class_3102, (class_1297)hfk);
                for (class_1657 class_16573 : hfj) {
                    TargetEspTest.hfz(class_3102, (class_1297)class_16573);
                }
                hfj.clear();
                TargetEspTest.hgb(class_3102, "kill @e[type=item]");
                TargetEspTest.hgb(class_3102, "setblock ~ ~ ~6 minecraft:air");
                class_3102.field_1724.method_31548().method_5447(0, class_1799.field_8037);
                GuiConfig.save();
                return true;
            }
        }
        return false;
    }

    private static void hft() {
        if (!hfq) {
            hfq = true;
            HudRenderCallback.EVENT.register((class_3322, class_97792) -> ++hfo);
        }
    }

    private static void hfu(ModuleManager kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static Setting hfv(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void hfw(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static void hfx(class_310 class_3102, class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(class_3102.field_1724.method_33571());
        TargetEspTest.hfw(class_3102, (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350)), (float)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))));
    }

    private static class_1657 hfy(class_310 class_3102, String string, double d, double d2) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = new class_243(0.0, 0.0, 1.0);
        class_243 class_2433 = new class_243(-1.0, 0.0, 0.0);
        class_243 class_2434 = class_3102.field_1724.method_73189().method_1019(class_2432.method_1021(d)).method_1019(class_2433.method_1021(d2));
        class_7452.method_5808(class_2434.field_1352, class_3102.field_1724.method_23318(), class_2434.field_1350, 180.0f, 0.0f);
        class_7452.method_5636(180.0f);
        class_7452.method_5847(180.0f);
        class_7452.field_6220 = 180.0f;
        class_7452.field_6259 = 180.0f;
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static void hfz(class_310 class_3102, class_1297 class_12972) {
        if (class_12972 != null) {
            class_3102.field_1687.method_2945(class_12972.method_5628(), class_1297.class_5529.field_26999);
        }
    }

    private static void hga(class_310 class_3102, String string) throws Exception {
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, string);
        Field field2 = ClickGuiScreen.class.getDeclaredField("SCROLLS");
        field2.setAccessible(true);
        ((Map)field2.get(null)).clear();
        for (String string2 : new String[]{"windowX", "windowY"}) {
            Field field3 = ClickGuiScreen.class.getDeclaredField(string2);
            field3.setAccessible(true);
            field3.setFloat(null, Float.NaN);
        }
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void hgb(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static String hgc(double d) {
        return String.format(Locale.ROOT, "%.2f", d);
    }

    private static void hgd(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        hfm = new String[]{"off", "all on", "off", "shaders", "off", "all but shaders", "off", "all on"};
        hfn = new String[]{"TargetESP", "ItemESP", "ItemPhysics", "Predictions", "Arrows", "BlockOutline", "Shaders"};
    }

    private static /* synthetic */ int zq(int n, int n2) {
        return n * n2 | 0x1EDF4F6A;
    }
}

