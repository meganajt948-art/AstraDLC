/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
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
 *  net.minecraft.class_9927
 */
package a;

import a.Friends;
import a.Module;
import a.ModuleManager;
import a.HitParticles;
import a.FxPipeline;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
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
import net.minecraft.class_9927;

final class EspTest {
    private static final String[] grx = new String[]{"TargetESP", "ItemESP", "Nametags", "Predictions", "Arrows", "BlockOutline", "BlockESP", "PlayerESP", "TransparentFriends", "JumpCircles", "SoulESP", "ShaderHands", "ViewModel", "HitColor", "ChatTweaks", "ShulkerPreview"};
    private static final String[][] gry = new String[][]{new String[0], {"PlayerESP"}, {"PlayerESP"}, new String[0], {"PlayerESP"}, {"PlayerESP"}, new String[0], {"PlayerESP", "Nametags"}, grx, new String[0]};
    private static final Set<Integer> grz = Set.of(Integer.valueOf(2), Integer.valueOf(5));
    private static final Set<Integer> gsa = Set.of();
    private static final int gsb = 100;
    private static final List<class_1297> gsc = new ArrayList<class_1297>();
    private static long gsd;
    private static long gse;
    private static boolean gsf;
    private static /* synthetic */ String gsg;
    private static /* synthetic */ String gsh;

    private EspTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        int n2;
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            EspTest.gsj(class_3102, "gamemode creative");
            EspTest.gsj(class_3102, "time set 6000");
            class_3102.field_1724.method_36456(0.0f);
            class_3102.field_1724.method_36457(10.0f);
            for (n2 = 0; n2 < 14; ++n2) {
                double d = (double)n2 * 0.45;
                gsc.add(EspTest.gsi(class_3102, "P" + n2, 25.0 + (double)n2 * 1.5 * Math.cos(d), 6.0 * Math.sin(d)));
            }
            Friends.add("P3");
            HitParticles.onAttack(gsc.get(0));
            for (n2 = 0; n2 < 8; ++n2) {
                EspTest.gsj(class_3102, "summon minecraft:item ~" + (n2 - 4) + " ~0.5 ~" + (5 + n2 % 3) + " {Item:{id:\"minecraft:diamond\",count:" + (n2 + 1) + "},PickupDelay:32767}");
            }
            EspTest.gsj(class_3102, "fill ~-6 ~-3 ~8 ~6 ~-1 ~14 minecraft:diamond_ore");
            class_3102.field_1724.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_8634, 16));
            class_3102.field_1724.method_31548().method_61496(0);
            class_3102.field_1690.method_61970().method_41748((Object)class_9927.field_52743);
            if (!gsf) {
                gsf = true;
                HudRenderCallback.EVENT.register((class_3322, class_97792) -> ++gsd);
            }
        }
        if (n > 20 && n <= 20 + 100 * gry.length) {
            n2 = (n - 21) / 100;
            int n3 = (n - 21) % 100;
            if (n3 == 0) {
                List<String> list = List.of(gry[n2]);
                boolean bl = !list.isEmpty();
                FxPipeline.noScissor = grz.contains(n2);
                FxPipeline.devMode = gsa.contains(n2) ? 1 : (grz.contains(n2) ? 2 : 0);
                for (String string : grx) {
                    Module kfe2 = kfx2.getByName(string);
                    if (kfe2 == null) continue;
                    kfe2.setEnabled(list.contains(string));
                }
                if (bl && class_3102.field_1724.method_24828()) {
                    class_3102.field_1724.method_6043();
                }
            } else if (n3 == 20) {
                gsd = 0L;
                gse = System.nanoTime();
                if (n2 == 1 || n2 == 2) {
                    class_318.method_22690((File)class_3102.field_1697, (String)("flow2-perf-esp-" + n2 + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
                }
            } else if (n3 == 99) {
                double d = (double)(System.nanoTime() - gse) / 1.0E9;
                String string = gry[n2].length == 0 ? "off" : (gry[n2] == grx ? "all" : String.join((CharSequence)"+", gry[n2]) + (grz.contains(n2) ? " (old way)" : "") + (gsa.contains(n2) ? " (vanilla outline only)" : ""));
                System.out.println("perf " + string + ": " + String.format(Locale.ROOT, "%.2f", d * 1000.0 / (double)Math.max(1L, gsd)) + " ms/frame (" + Math.round((double)gsd / d) + " fps)");
            }
        }
        if (n > 20 + 100 * gry.length) {
            FxPipeline.noScissor = false;
            FxPipeline.devMode = 0;
            for (String string : grx) {
                Module kfe3 = kfx2.getByName(string);
                if (kfe3 == null) continue;
                kfe3.setEnabled(false);
            }
            for (class_1297 class_12972 : gsc) {
                class_3102.field_1687.method_2945(class_12972.method_5628(), class_1297.class_5529.field_26999);
            }
            gsc.clear();
            Friends.remove("P3");
            EspTest.gsj(class_3102, "kill @e[type=item]");
            EspTest.gsj(class_3102, "fill ~-6 ~-3 ~8 ~6 ~-1 ~14 minecraft:stone");
            return true;
        }
        return false;
    }

    private static class_1297 gsi(class_310 class_3102, String string, double d, double d2) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1031(-d2, 0.0, d);
        class_7452.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 180.0f, 0.0f);
        class_7452.method_5673(class_1304.field_6169, new class_1799((class_1935)class_1802.field_8805));
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_22028));
        class_7452.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8802));
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static void gsj(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static /* synthetic */ int wl(int n, int n2) {
        return n * n2 | 0xBACFB3EE;
    }

    private static /* synthetic */ int wm(int n, int n2) {
        return EspTest.wl(n, n2) + n;
    }

    private static /* synthetic */ int wn(int n, int n2) {
        return EspTest.wm(n, n2) ^ 0xA9333246;
    }
}

