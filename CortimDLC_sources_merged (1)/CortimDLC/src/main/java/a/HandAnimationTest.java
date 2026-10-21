/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
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

import a.Hud;
import a.Module;
import a.ModuleManager;
import a.ModeSetting;
import a.Setting;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.util.UUID;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_745;

final class HandAnimationTest {
    private static final String[] hdk = new String[]{"Smooth", "Static", "Down", "Poke", "SelfBack", "Feast", "ToBack", "Block", "Akrien", "Break", "Pander", "Slant"};
    private static class_1297 hdl;
    private static /* synthetic */ boolean hdm;
    private static /* synthetic */ long hdn;

    private HandAnimationTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        int n2;
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            HandAnimationTest.hdr(class_3102, "gamemode creative");
            HandAnimationTest.hdr(class_3102, "time set 6000");
            HandAnimationTest.hdr(class_3102, "weather clear");
            Hud.TARGET.enabled.set(false);
        }
        if (n == 6) {
            HandAnimationTest.hdq(class_3102, 0.0f, 6.0f);
            hdl = HandAnimationTest.hdo(class_3102, "Ghost", 3.0);
            kfx2.getByName("ShowInvisible").setEnabled(true);
        }
        if (n == 16) {
            HandAnimationTest.hds(class_3102, "swing-invisible-armour");
        }
        if (n == 18) {
            kfx2.getByName("ShowInvisible").setEnabled(false);
            class_3102.field_1687.method_2945(hdl.method_5628(), class_1297.class_5529.field_26999);
            class_3102.field_1724.method_31548().method_61496(0);
            class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8802));
            kfx2.getByName("SwingAnimations").setEnabled(true);
        }
        if (n == 22) {
            HandAnimationTest.hds(class_3102, "swing-rest");
        }
        for (n2 = 0; n2 < hdk.length; ++n2) {
            int n3 = 26 + n2 * 14;
            if (n == n3) {
                ((ModeSetting)HandAnimationTest.hdp(kfx2.getByName("SwingAnimations"), "Mode")).set(hdk[n2]);
                continue;
            }
            if (n == n3 + 2) {
                class_3102.field_1724.method_6104(class_1268.field_5808);
                continue;
            }
            if (n != n3 + 5) continue;
            HandAnimationTest.hds(class_3102, "swing-" + hdk[n2].toLowerCase());
        }
        n2 = 26 + hdk.length * 14 + 30;
        if (n == n2 - 28) {
            class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_49814));
        }
        if (n == n2 - 2) {
            HandAnimationTest.hds(class_3102, "swing-mace-rest");
        }
        if (n == n2) {
            HandAnimationTest.hdr(class_3102, "gamemode survival");
            HandAnimationTest.hdr(class_3102, "effect give @s minecraft:resistance 30 10 true");
            HandAnimationTest.hdr(class_3102, "tp @s ~ ~14 ~");
        }
        if (n == n2 + 22) {
            HandAnimationTest.hds(class_3102, "swing-mace-charge");
        }
        if (n == n2 + 60) {
            HandAnimationTest.hdr(class_3102, "gamemode creative");
            kfx2.getByName("SwingAnimations").setEnabled(false);
            System.out.println("swing test done");
            return true;
        }
        return false;
    }

    private static class_1297 hdo(class_310 class_3102, String string, double d) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1031(0.0, 0.0, d);
        class_7452.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 180.0f, 0.0f);
        class_7452.method_5636(180.0f);
        class_7452.method_5847(180.0f);
        class_7452.field_6220 = 180.0f;
        class_7452.field_6259 = 180.0f;
        class_7452.method_5673(class_1304.field_6169, new class_1799((class_1935)class_1802.field_8805));
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
        class_7452.method_5673(class_1304.field_6172, new class_1799((class_1935)class_1802.field_8348));
        class_7452.method_5673(class_1304.field_6166, new class_1799((class_1935)class_1802.field_8285));
        class_7452.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_22022));
        class_7452.method_5648(true);
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static Setting hdp(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void hdq(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static void hdr(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void hds(class_310 class_3102, String string) {
        System.out.println("self test " + string);
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int yx(int n, int n2) {
        return (n ^ n2) + -1577085075;
    }

    private static /* synthetic */ int yy(int n, int n2) {
        return HandAnimationTest.yx(n, n2) * n2;
    }

    private static /* synthetic */ int yz(int n, int n2) {
        return n + n2 | 0x3EAB6485;
    }
}

