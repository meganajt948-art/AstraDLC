/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
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
 *  net.minecraft.class_745
 */
package a;

import a.Friends;
import a.Hud;
import a.Module;
import a.ModuleManager;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
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
import net.minecraft.class_745;

final class PlayerEspTest {
    private static final List<class_1297> fuh = new ArrayList<class_1297>();
    private static final String[] fui = new String[]{"PlayerESP", "TransparentFriends", "ShowInvisible", "ShaderHands"};
    private static int fuj;
    private static int fuk;
    private static int ful;
    private static boolean fum;
    private static /* synthetic */ int fun;
    private static /* synthetic */ String fuo;

    private PlayerEspTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        if (!fum) {
            fum = true;
            WorldRenderEvents.END_MAIN.register(worldRenderContext -> ++fuj);
        }
        if (n < 40 || fuj - fuk < 6) {
            if (n == 1) {
                PlayerEspTest.fup(class_3102, kfx2);
            }
            return false;
        }
        fuk = fuj;
        switch (ful++) {
            case 0: {
                PlayerEspTest.fut(class_3102, 0.0f, 8.0f);
                class_3102.field_1724.method_31548().method_61496(0);
                class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8802));
                fuh.add((class_1297)PlayerEspTest.fuu(class_3102, "Enemy", 5.0, 1.8, false));
                fuh.add((class_1297)PlayerEspTest.fuu(class_3102, "Kolya", 4.0, -0.6, false));
                fuh.add((class_1297)PlayerEspTest.fuu(class_3102, "Behind", 7.0, -0.9, false));
                fuh.add((class_1297)PlayerEspTest.fuu(class_3102, "Ghost", 6.0, 3.6, true));
                fuh.add((class_1297)PlayerEspTest.fuu(class_3102, "Walled", 10.0, -4.5, false));
                Friends.add("Kolya");
                break;
            }
            case 1: {
                PlayerEspTest.fuw(class_3102, "pfx-plain");
                PlayerEspTest.fuq(kfx2, "PlayerESP", true);
                break;
            }
            case 2: {
                PlayerEspTest.fuw(class_3102, "pfx-esp-outline");
                Module kfe2 = kfx2.getByName("PlayerESP");
                PlayerEspTest.fur(kfe2, "Glow", 1.0);
                PlayerEspTest.fur(kfe2, "Glow size", 1.0);
                PlayerEspTest.fur(kfe2, "Fill", 0.3);
                PlayerEspTest.fur(kfe2, "Width", 3.0);
                break;
            }
            case 3: {
                PlayerEspTest.fuw(class_3102, "pfx-esp-strong");
                ((ModeSetting)PlayerEspTest.fus(kfx2.getByName("PlayerESP"), "Mode")).set("Box");
                break;
            }
            case 4: {
                PlayerEspTest.fuw(class_3102, "pfx-esp-box");
                PlayerEspTest.fuq(kfx2, "PlayerESP", false);
                PlayerEspTest.fuq(kfx2, "TransparentFriends", true);
                break;
            }
            case 5: {
                PlayerEspTest.fuw(class_3102, "pfx-friend-60");
                PlayerEspTest.fur(kfx2.getByName("TransparentFriends"), "Transparency", 1.0);
                break;
            }
            case 6: {
                PlayerEspTest.fuw(class_3102, "pfx-friend-100");
                PlayerEspTest.fur(kfx2.getByName("TransparentFriends"), "Transparency", 0.0);
                break;
            }
            case 7: {
                PlayerEspTest.fuw(class_3102, "pfx-friend-0");
                PlayerEspTest.fur(kfx2.getByName("TransparentFriends"), "Transparency", 0.6);
                PlayerEspTest.fuq(kfx2, "ShowInvisible", true);
                break;
            }
            case 8: {
                PlayerEspTest.fuw(class_3102, "pfx-invisible");
                Module kfe3 = kfx2.getByName("PlayerESP");
                ((ModeSetting)PlayerEspTest.fus(kfe3, "Mode")).set("Outline");
                PlayerEspTest.fur(kfe3, "Glow", 0.5);
                PlayerEspTest.fur(kfe3, "Glow size", 0.5);
                PlayerEspTest.fur(kfe3, "Fill", 0.1);
                PlayerEspTest.fur(kfe3, "Width", 1.5);
                PlayerEspTest.fuq(kfx2, "PlayerESP", true);
                break;
            }
            case 9: {
                PlayerEspTest.fuw(class_3102, "pfx-all");
                PlayerEspTest.fuq(kfx2, "ShaderHands", true);
                break;
            }
            case 10: {
                PlayerEspTest.fuw(class_3102, "pfx-hands");
                break;
            }
            default: {
                for (String string : fui) {
                    PlayerEspTest.fuq(kfx2, string, false);
                }
                for (class_1297 class_12972 : fuh) {
                    class_3102.field_1687.method_2945(class_12972.method_5628(), class_1297.class_5529.field_26999);
                }
                fuh.clear();
                Friends.remove("Kolya");
                class_3102.field_1724.method_31548().method_5447(0, class_1799.field_8037);
                Hud.TARGET.enabled.set(true);
                return true;
            }
        }
        return false;
    }

    private static void fup(class_310 class_3102, ModuleManager kfx2) {
        for (String string : fui) {
            PlayerEspTest.fuq(kfx2, string, false);
            for (Setting vmo2 : kfx2.getByName(string).getSettings()) {
                if (vmo2 instanceof NumberSetting) {
                    NumberSetting vmc2 = (NumberSetting)vmo2;
                    vmc2.reset();
                    continue;
                }
                if (!(vmo2 instanceof ModeSetting)) continue;
                ModeSetting vlv2 = (ModeSetting)vmo2;
                vlv2.reset();
            }
        }
        PlayerEspTest.fuv(class_3102, "gamemode creative");
        PlayerEspTest.fuv(class_3102, "time set 6000");
        PlayerEspTest.fuv(class_3102, "weather clear");
        PlayerEspTest.fuv(class_3102, "fill ~-6 ~ ~2 ~6 ~3 ~14 minecraft:air");
        PlayerEspTest.fuv(class_3102, "fill ~3 ~ ~8 ~6 ~2 ~8 minecraft:stone");
        Hud.TARGET.enabled.set(false);
    }

    private static void fuq(ModuleManager kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static void fur(Module kfe2, String string, double d) {
        ((NumberSetting)PlayerEspTest.fus(kfe2, string)).set(d);
    }

    private static Setting fus(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void fut(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static class_1657 fuu(class_310 class_3102, String string, double d, double d2, boolean bl) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1019(new class_243(0.0, 0.0, 1.0).method_1021(d)).method_1019(new class_243(-1.0, 0.0, 0.0).method_1021(d2));
        class_7452.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 180.0f, 0.0f);
        class_7452.method_5636(180.0f);
        class_7452.method_5847(180.0f);
        class_7452.field_6220 = 180.0f;
        class_7452.field_6259 = 180.0f;
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
        class_7452.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_22022));
        class_7452.method_5648(bl);
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static void fuv(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fuw(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int qz(int n, int n2) {
        return n - n2 + -1664652938;
    }

    private static /* synthetic */ int ra(int n, int n2) {
        return n + n2 ^ 0x7BD10F62;
    }
}

