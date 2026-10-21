/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_11905
 *  net.minecraft.class_11908
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1642
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_5498
 *  net.minecraft.class_745
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.GuiConfig;
import a.Hud;
import a.Module;
import a.ModuleManager;
import a.KillEffects;
import a.BoolSetting;
import a.ListSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1642;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_5498;
import net.minecraft.class_745;

final class TargetMarkerTest {
    private static final List<class_1297> fww = new ArrayList<class_1297>();
    private static final String[] fwx = new String[]{"Box", "Corners", "Face"};
    private static final String[] fwy = new String[]{"Ring", "Lightning", "Winter", "Lava", "Cosmos", "Aurora", "Ocean", "Neon", "Sakura"};
    private static final String[] fwz = new String[]{"Outline", "Box"};
    private static /* synthetic */ boolean fxa;
    private static /* synthetic */ String fxb;

    private TargetMarkerTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            TargetMarkerTest.fxn(class_3102, "gamemode creative");
            TargetMarkerTest.fxn(class_3102, "time set 6000");
            TargetMarkerTest.fxn(class_3102, "weather clear");
            TargetMarkerTest.fxn(class_3102, "setblock ~ ~ ~3 minecraft:stone");
            TargetMarkerTest.fxn(class_3102, "setblock ~1 ~ ~3 minecraft:stone");
            Hud.TARGET.enabled.set(false);
        }
        if (n == 6) {
            TargetMarkerTest.fxh(class_3102, new class_243(Math.floor(class_3102.field_1724.method_23317()) + 0.5, Math.floor(class_3102.field_1724.method_23318()) + 0.7, Math.floor(class_3102.field_1724.method_23321()) + 3.5));
            TargetMarkerTest.fxd(kfx2, "BlockOutline", true);
        }
        for (n10 = 0; n10 < fwx.length; ++n10) {
            n9 = 10 + n10 * 10;
            if (n == n9) {
                TargetMarkerTest.fxe(kfx2, "BlockOutline", "Mode", fwx[n10]);
                continue;
            }
            if (n != n9 + 8) continue;
            TargetMarkerTest.fxo(class_3102, "fx-outline-" + fwx[n10].toLowerCase());
        }
        n10 = 100;
        if (n == n10) {
            TargetMarkerTest.fxd(kfx2, "BlockOutline", false);
            TargetMarkerTest.fxn(class_3102, "setblock ~ ~ ~3 minecraft:air");
            TargetMarkerTest.fxn(class_3102, "setblock ~1 ~ ~3 minecraft:air");
            class_3102.field_1690.method_31043(class_5498.field_26665);
            TargetMarkerTest.fxg(class_3102, 0.0f, 35.0f);
            TargetMarkerTest.fxd(kfx2, "JumpCircles", true);
        }
        for (n9 = 0; n9 < fwy.length; ++n9) {
            int n11 = n10 + 4 + n9 * 16;
            if (n == n11) {
                TargetMarkerTest.fxe(kfx2, "JumpCircles", "Theme", fwy[n9]);
                if (!class_3102.field_1724.method_24828()) continue;
                class_3102.field_1724.method_6043();
                continue;
            }
            if (n != n11 + 7) continue;
            TargetMarkerTest.fxo(class_3102, "fx-circle-" + fwy[n9].toLowerCase());
        }
        n9 = n10 + 4 + fwy.length * 16 + 4;
        if (n == n9) {
            TargetMarkerTest.fxd(kfx2, "JumpCircles", false);
            class_3102.field_1690.method_31043(class_5498.field_26664);
            TargetMarkerTest.fxg(class_3102, 0.0f, -10.0f);
            Module kfe2 = kfx2.getByName("SoulESP");
            ((BoolSetting)TargetMarkerTest.fxf(kfe2, "Mobs")).set(true);
            kfe2.setEnabled(true);
            TargetMarkerTest.fxn(class_3102, "summon minecraft:zombie ~ ~ ~5 {NoAI:1b,Silent:1b,equipment:{mainhand:{id:\"minecraft:totem_of_undying\",count:1}}}");
        }
        if (n == n9 + 10) {
            class_1642 class_16422 = TargetMarkerTest.fxc(class_3102);
            System.out.println("fx soul: zombie " + (class_16422 != null));
            if (class_16422 != null) {
                KillEffects.onAttack((class_1297)class_16422);
            }
            TargetMarkerTest.fxn(class_3102, "damage @e[type=minecraft:zombie,limit=1,sort=nearest] 100");
        }
        if (n == n9 + 24) {
            TargetMarkerTest.fxo(class_3102, "fx-soul-totem");
        }
        if (n == n9 + 40) {
            TargetMarkerTest.fxn(class_3102, "kill @e[type=minecraft:zombie]");
        }
        if (n == n9 + 56) {
            TargetMarkerTest.fxo(class_3102, "fx-soul-kill");
        }
        if (n == (n8 = n9 + 80)) {
            TargetMarkerTest.fxd(kfx2, "SoulESP", false);
            TargetMarkerTest.fxg(class_3102, 0.0f, 6.0f);
            fww.add((class_1297)TargetMarkerTest.fxi(class_3102, "Dream", 4.0, 0.0, false));
            fww.add((class_1297)TargetMarkerTest.fxi(class_3102, "Kolya", 6.0, 3.0, false));
            fww.add((class_1297)TargetMarkerTest.fxi(class_3102, "Far", 14.0, -5.0, false));
            Friends.add("Kolya");
            TargetMarkerTest.fxd(kfx2, "PlayerESP", true);
        }
        for (n7 = 0; n7 < fwz.length; ++n7) {
            n6 = n8 + 2 + n7 * 8;
            if (n == n6) {
                TargetMarkerTest.fxe(kfx2, "PlayerESP", "Mode", fwz[n7]);
                continue;
            }
            if (n != n6 + 6) continue;
            TargetMarkerTest.fxo(class_3102, "fx-esp-" + fwz[n7].toLowerCase());
        }
        n7 = n8 + 2 + fwz.length * 8 + 2;
        if (n == n7) {
            TargetMarkerTest.fxd(kfx2, "PlayerESP", false);
            TargetMarkerTest.fxd(kfx2, "TransparentFriends", true);
        }
        if (n == n7 + 6) {
            TargetMarkerTest.fxo(class_3102, "fx-friend-ghost");
        }
        if (n == n7 + 7) {
            TargetMarkerTest.fxd(kfx2, "TransparentFriends", false);
            Friends.remove("Kolya");
            fww.get(0).method_5648(true);
            TargetMarkerTest.fxd(kfx2, "ShowInvisible", true);
        }
        if (n == n7 + 13) {
            TargetMarkerTest.fxo(class_3102, "fx-show-invisible");
        }
        if (n == (n6 = n7 + 16)) {
            TargetMarkerTest.fxd(kfx2, "ShowInvisible", false);
            for (Object object : fww) {
                TargetMarkerTest.fxj(class_3102, object);
            }
            fww.clear();
            TargetMarkerTest.fxn(class_3102, "fill ~-3 ~ ~4 ~3 ~3 ~4 minecraft:stone");
            TargetMarkerTest.fxn(class_3102, "setblock ~ ~ ~7 minecraft:diamond_ore");
            TargetMarkerTest.fxn(class_3102, "setblock ~1 ~ ~7 minecraft:diamond_ore");
            TargetMarkerTest.fxn(class_3102, "setblock ~ ~1 ~7 minecraft:diamond_ore");
            TargetMarkerTest.fxn(class_3102, "setblock ~ ~ ~8 minecraft:diamond_ore");
            TargetMarkerTest.fxn(class_3102, "setblock ~-2 ~1 ~8 minecraft:gold_ore");
            TargetMarkerTest.fxn(class_3102, "setblock ~2 ~ ~9 minecraft:chest");
            TargetMarkerTest.fxn(class_3102, "setblock ~-1 ~ ~10 minecraft:ancient_debris");
            TargetMarkerTest.fxg(class_3102, 0.0f, 5.0f);
        }
        if (n == n6 + 4) {
            TargetMarkerTest.fxd(kfx2, "BlockESP", true);
        }
        if (n == n6 + 14) {
            TargetMarkerTest.fxo(class_3102, "fx-block-esp");
        }
        if (n == n6 + 15) {
            TargetMarkerTest.fxe(kfx2, "BlockESP", "Mode", "Corners");
        }
        if (n == n6 + 22) {
            TargetMarkerTest.fxo(class_3102, "fx-block-esp-corners");
        }
        if (n == (n5 = n6 + 26)) {
            TargetMarkerTest.fxd(kfx2, "BlockESP", false);
            TargetMarkerTest.fxk(class_3102, "Render");
        }
        if (n == n5 + 12) {
            Object object;
            object = kfx2.getByName("BlockESP");
            Method method = ClickGuiScreen.class.getDeclaredMethod("openPicker", ListSetting.class);
            method.setAccessible(true);
            method.invoke((Object)class_3102.field_1755, (ListSetting)TargetMarkerTest.fxf((Module)object, "Blocks"));
        }
        if (n == n5 + 22) {
            TargetMarkerTest.fxo(class_3102, "fx-picker");
        }
        if (n == n5 + 23) {
            TargetMarkerTest.fxm(class_3102.field_1755, "diamond");
        }
        if (n == n5 + 30) {
            TargetMarkerTest.fxo(class_3102, "fx-picker-search");
        }
        if (n == n5 + 31) {
            TargetMarkerTest.fxl(class_3102.field_1755, 256);
            TargetMarkerTest.fxl(class_3102.field_1755, 256);
        }
        if (n == n5 + 38) {
            TargetMarkerTest.fxo(class_3102, "fx-picker-closed");
            class_3102.method_1507(null);
        }
        if (n == (n4 = n5 + 42)) {
            TargetMarkerTest.fxn(class_3102, "fill ~-3 ~ ~4 ~3 ~3 ~4 minecraft:air");
            TargetMarkerTest.fxg(class_3102, 0.0f, 10.0f);
            class_3102.field_1724.method_31548().method_61496(0);
            class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8802));
            class_3102.field_1724.method_5673(class_1304.field_6171, new class_1799((class_1935)class_1802.field_8288));
            TargetMarkerTest.fxo(class_3102, "fx-hands-plain");
        }
        if (n == n4 + 2) {
            TargetMarkerTest.fxd(kfx2, "ShaderHands", true);
        }
        if (n == n4 + 10) {
            TargetMarkerTest.fxo(class_3102, "fx-hands-aura");
        }
        if (n == (n3 = n4 + 14)) {
            TargetMarkerTest.fxd(kfx2, "ShaderHands", false);
            Module kfe3 = kfx2.getByName("ViewModel");
            ((NumberSetting)TargetMarkerTest.fxf(kfe3, "X")).set(-0.15);
            ((NumberSetting)TargetMarkerTest.fxf(kfe3, "Z")).set(0.2);
            ((NumberSetting)TargetMarkerTest.fxf(kfe3, "Turn Y")).set(-25.0);
            ((NumberSetting)TargetMarkerTest.fxf(kfe3, "Size")).set(0.8);
            kfe3.setEnabled(true);
        }
        if (n == n3 + 6) {
            TargetMarkerTest.fxo(class_3102, "fx-viewmodel");
        }
        if (n == n3 + 7) {
            TargetMarkerTest.fxd(kfx2, "ViewModel", false);
        }
        if (n == (n2 = n3 + 16)) {
            class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_49814));
            class_3102.field_1724.method_75203();
        }
        if (n == n2 + 4) {
            TargetMarkerTest.fxo(class_3102, "fx-mace-recharge");
        }
        if (n == n2 + 5) {
            TargetMarkerTest.fxn(class_3102, "gamemode survival");
            TargetMarkerTest.fxn(class_3102, "effect give @s minecraft:resistance 30 10 true");
            TargetMarkerTest.fxn(class_3102, "tp @s ~ ~9 ~");
        }
        if (n == n2 + 20) {
            TargetMarkerTest.fxo(class_3102, "fx-mace-smash");
        }
        if (n >= n2 + 40) {
            TargetMarkerTest.fxn(class_3102, "gamemode creative");
            class_3102.field_1724.method_31548().method_5447(0, class_1799.field_8037);
            class_3102.field_1724.method_5673(class_1304.field_6171, class_1799.field_8037);
            Hud.TARGET.enabled.set(true);
            GuiConfig.save();
            return true;
        }
        return false;
    }

    private static class_1642 fxc(class_310 class_3102) {
        class_1642 class_16422 = null;
        for (class_1297 class_12972 : class_3102.field_1687.method_18112()) {
            if (!(class_12972 instanceof class_1642)) continue;
            class_1642 class_16423 = (class_1642)class_12972;
            if (class_16422 != null && !(class_16423.method_5858((class_1297)class_3102.field_1724) < class_16422.method_5858((class_1297)class_3102.field_1724))) continue;
            class_16422 = class_16423;
        }
        return class_16422;
    }

    private static void fxd(ModuleManager kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static void fxe(ModuleManager kfx2, String string, String string2, String string3) {
        ((ModeSetting)TargetMarkerTest.fxf(kfx2.getByName(string), string2)).set(string3);
    }

    private static Setting fxf(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void fxg(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static void fxh(class_310 class_3102, class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(class_3102.field_1724.method_33571());
        TargetMarkerTest.fxg(class_3102, (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350)), (float)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))));
    }

    private static class_1657 fxi(class_310 class_3102, String string, double d, double d2, boolean bl) {
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

    private static void fxj(class_310 class_3102, class_1297 class_12972) {
        if (class_12972 != null) {
            class_3102.field_1687.method_2945(class_12972.method_5628(), class_1297.class_5529.field_26999);
        }
    }

    private static void fxk(class_310 class_3102, String string) throws Exception {
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{"windowX", "windowY"}) {
            Field field2 = ClickGuiScreen.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void fxl(class_437 class_4372, int n) {
        if (class_4372 != null) {
            class_4372.method_25404(new class_11908(n, 0, 0));
        }
    }

    private static void fxm(class_437 class_4372, String string) {
        if (class_4372 != null) {
            for (char c : string.toCharArray()) {
                class_4372.method_25400(new class_11905((int)c, 0));
            }
        }
    }

    private static void fxn(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fxo(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int ry(int n, int n2) {
        return n ^ n2 | 0xCC09A06D;
    }

    private static /* synthetic */ int rz(int n, int n2) {
        return TargetMarkerTest.ry(n, n2) ^ 0x1187FEC7;
    }
}

