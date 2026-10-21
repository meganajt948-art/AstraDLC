/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_5498
 *  net.minecraft.class_745
 */
package a;

import a.Hud;
import a.Module;
import a.ModuleManager;
import a.KillEffects;
import a.BoolSetting;
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
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_5498;
import net.minecraft.class_745;

final class SoulEspTest {
    private static final int fxq = 40;
    private static final int fxr = 120;
    private static final int fxs = 200;
    private static final int fxt = 280;
    private static final int fxu = 360;
    private static class_745 fxv;
    private static int fxw;
    private static /* synthetic */ long fxx;
    private static /* synthetic */ boolean fxy;

    private SoulEspTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        Module kfe2 = kfx2.getByName("SoulESP");
        if (n == 1) {
            SoulEspTest.fyg(class_3102, "gamemode creative");
            SoulEspTest.fyg(class_3102, "time set 6000");
            SoulEspTest.fyg(class_3102, "weather clear");
            SoulEspTest.fyg(class_3102, "kill @e[type=minecraft:zombie]");
            SoulEspTest.fyg(class_3102, "fill ~-5 ~ ~8 ~5 ~5 ~8 minecraft:stone_bricks");
            SoulEspTest.fyg(class_3102, "fill ~-4 ~1 ~8 ~-3 ~3 ~8 minecraft:red_wool");
            SoulEspTest.fyg(class_3102, "fill ~3 ~1 ~8 ~4 ~3 ~8 minecraft:blue_wool");
            SoulEspTest.fyg(class_3102, "fill ~-1 ~2 ~8 ~1 ~2 ~8 minecraft:glowstone");
            class_3102.field_1690.method_31043(class_5498.field_26664);
            Hud.TARGET.enabled.set(false);
            SoulEspTest.fyd(kfe2, "Style", "Glass");
            SoulEspTest.fyd(kfe2, "Pieces", "Shards");
            ((BoolSetting)SoulEspTest.fye(kfe2, "Only my targets")).set(false);
            ((BoolSetting)SoulEspTest.fye(kfe2, "Mobs")).set(true);
            kfe2.setEnabled(true);
        }
        if (n == 20) {
            SoulEspTest.fyf(class_3102, 0.0f, 12.0f);
        }
        if (n >= 40 && n < 280) {
            SoulEspTest.fyf(class_3102, 0.0f, 12.0f);
        }
        if (n == 34) {
            fxv = SoulEspTest.fyb(class_3102, "Victim", 3.6);
        }
        if (n == 38 && fxv != null) {
            fxv.method_6104(class_1268.field_5808);
        }
        if (n == 40) {
            SoulEspTest.fya(fxv, false);
        }
        SoulEspTest.fxz(class_3102, n, 40, "kill", new int[]{4, 10, 18, 27, 33, 44});
        if (n == 62) {
            SoulEspTest.fyc(class_3102, (class_1297)fxv);
        }
        if (n == 114) {
            fxv = SoulEspTest.fyb(class_3102, "Totem", 3.6);
        }
        if (n == 120) {
            SoulEspTest.fya(fxv, true);
        }
        SoulEspTest.fxz(class_3102, n, 120, "totem", new int[]{6, 18, 28, 40});
        if (n == 176) {
            SoulEspTest.fyc(class_3102, (class_1297)fxv);
        }
        if (n == 192) {
            SoulEspTest.fyd(kfe2, "Pieces", "Cubes");
            fxv = SoulEspTest.fyb(class_3102, "Cubes", 3.6);
        }
        if (n == 200) {
            SoulEspTest.fya(fxv, false);
        }
        SoulEspTest.fxz(class_3102, n, 200, "cubes", new int[]{18, 27, 33, 44});
        if (n == 222) {
            SoulEspTest.fyc(class_3102, (class_1297)fxv);
        }
        if (n == 270) {
            SoulEspTest.fyd(kfe2, "Pieces", "Shards");
            SoulEspTest.fyf(class_3102, 0.0f, 8.0f);
            SoulEspTest.fyg(class_3102, "summon minecraft:zombie ~ ~ ~4 {NoAI:1b,Silent:1b,Rotation:[180f,0f]}");
        }
        if (n == 280) {
            SoulEspTest.fyg(class_3102, "kill @e[type=minecraft:zombie]");
        }
        SoulEspTest.fxz(class_3102, n, 280, "zombie", new int[]{8, 20, 28, 36});
        if (KillEffects.activeGlass() > 0) {
            ++fxw;
        }
        if (n >= 360) {
            kfe2.setEnabled(false);
            SoulEspTest.fyd(kfe2, "Style", "Angel");
            SoulEspTest.fyg(class_3102, "fill ~-5 ~ ~8 ~5 ~5 ~8 minecraft:air");
            Hud.TARGET.enabled.set(true);
            System.out.println("glass test " + (fxw > 100 ? "PASS" : "FAIL") + " (glass seen " + fxw + " ticks)");
            return true;
        }
        return false;
    }

    private static void fxz(class_310 class_3102, int n, int n2, String string, int[] nArray) {
        for (int n3 : nArray) {
            if (n != n2 + n3) continue;
            SoulEspTest.fyh(class_3102, "glass-" + string + "-" + String.format("%02d", n3));
        }
    }

    private static void fya(class_745 class_7452, boolean bl) {
        if (class_7452 == null) {
            return;
        }
        KillEffects.onAttack((class_1297)class_7452);
        KillEffects.trigger((class_1309)class_7452, bl);
        if (!bl) {
            class_7452.method_6033(0.0f);
        }
    }

    private static class_745 fyb(class_310 class_3102, String string, double d) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1031(0.0, 0.0, d);
        class_7452.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 160.0f, 0.0f);
        class_7452.method_5636(160.0f);
        class_7452.method_5847(170.0f);
        class_7452.field_6220 = 160.0f;
        class_7452.field_6259 = 170.0f;
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
        class_7452.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_22022));
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static void fyc(class_310 class_3102, class_1297 class_12972) {
        if (class_12972 != null && class_3102.field_1687.method_8469(class_12972.method_5628()) != null) {
            class_3102.field_1687.method_2945(class_12972.method_5628(), class_1297.class_5529.field_26999);
        }
    }

    private static void fyd(Module kfe2, String string, String string2) {
        ((ModeSetting)SoulEspTest.fye(kfe2, string)).set(string2);
    }

    private static Setting fye(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void fyf(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static void fyg(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fyh(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int sc(int n, int n2) {
        return n + n2 ^ 0x140EC34F;
    }

    private static /* synthetic */ int sd(int n, int n2) {
        return SoulEspTest.sc(n, n2) + n;
    }
}

