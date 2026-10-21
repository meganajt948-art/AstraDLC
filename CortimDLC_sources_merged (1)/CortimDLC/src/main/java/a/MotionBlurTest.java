/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_4184
 *  net.minecraft.class_746
 */
package a;

import a.Module;
import a.MotionBlur;
import a.MotionBlurPass;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Locale;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_4184;
import net.minecraft.class_746;

final class MotionBlurTest {
    private static float ghz;
    private static float gia;
    private static double gib;
    private static int gic;
    private static int gid;
    private static boolean gie;
    private static boolean gif;
    private static float gig;
    private static float gih;
    private static float gii;
    private static float gij;
    private static long gik;
    private static final float gil = 0.15f;
    private static final StringBuilder gim;
    private static /* synthetic */ int gin;
    private static /* synthetic */ boolean gio;

    private MotionBlurTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("MotionBlur");
        class_746 class_7462 = class_3102.field_1724;
        if (!gie) {
            gie = true;
            WorldRenderEvents.END_MAIN.register(worldRenderContext -> MotionBlurTest.giq(class_310.method_1551()));
        }
        switch (n) {
            case 1: {
                MotionBlurTest.giu(class_3102, "gamemode creative");
                MotionBlurTest.giu(class_3102, "time set 6000");
                MotionBlurTest.giu(class_3102, "weather clear");
                MotionBlurTest.giu(class_3102, "tp @s 0 ~ 0");
                MotionBlurTest.giu(class_3102, "item replace entity @s weapon.mainhand with minecraft:diamond_sword");
                break;
            }
            case 3: {
                MotionBlurTest.giu(class_3102, "fill -30 ~ -30 30 ~8 30 minecraft:air");
                break;
            }
            case 4: {
                MotionBlurTest.giu(class_3102, "fill -30 ~-1 -30 30 ~-1 30 minecraft:grass_block");
                break;
            }
            case 5: {
                for (int i = -14; i <= 14; ++i) {
                    String string = (i & 1) == 0 ? "black_concrete" : "white_concrete";
                    MotionBlurTest.giu(class_3102, "fill 12 ~ " + i + " 12 ~7 " + i + " minecraft:" + string);
                }
                break;
            }
            case 6: {
                for (int i = 0; i <= 7; ++i) {
                    String string = (i & 1) == 0 ? "orange_concrete" : "blue_concrete";
                    MotionBlurTest.giu(class_3102, "fill -10 ~" + i + " -12 10 ~" + i + " -12 minecraft:" + string);
                }
                break;
            }
            case 7: {
                MotionBlurTest.giu(class_3102, "fill 6 ~ 6 6 ~5 6 minecraft:quartz_pillar");
                MotionBlurTest.giu(class_3102, "fill -6 ~ 7 -6 ~4 7 minecraft:gold_block");
                MotionBlurTest.giu(class_3102, "fill 7 ~ -5 7 ~3 -5 minecraft:red_concrete");
                MotionBlurTest.giu(class_3102, "fill -8 ~ -4 -8 ~6 -4 minecraft:oak_log");
                break;
            }
            case 40: {
                kfe2.setEnabled(true);
                MotionBlurPass.timing(true);
                MotionBlurTest.gir(class_7462, -90.0f, 0.0f);
                break;
            }
            case 60: {
                MotionBlurPass.gpuMillis();
                MotionBlurTest.git(class_3102, "still");
                break;
            }
            case 62: {
                MotionBlurPass.gpuMillis();
                break;
            }
            case 65: {
                System.out.println("motion still RenderPerfTest " + MotionBlurTest.giv(MotionBlurPass.gpuMillis()) + " ms (pass skipped)");
                break;
            }
        }
        MotionBlurTest.gip(class_3102, n, 70, 110, 6.0f, 0.0f, "turn-120");
        MotionBlurTest.gip(class_3102, n, 120, 160, 12.0f, 0.0f, "turn-240");
        MotionBlurTest.gip(class_3102, n, 170, 205, 36.0f, 0.0f, "flick-720");
        if (n == 215) {
            ((NumberSetting)MotionBlurTest.gis(kfe2, "Сила")).set(1.0);
        }
        MotionBlurTest.gip(class_3102, n, 220, 260, 12.0f, 0.0f, "turn-240-strong");
        if (n == 265) {
            ((NumberSetting)MotionBlurTest.gis(kfe2, "Сила")).set(0.5);
            MotionBlurTest.gir(class_7462, 180.0f, -40.0f);
        }
        MotionBlurTest.gip(class_3102, n, 270, 286, 0.0f, 5.0f, "pitch-100");
        if (n == 295) {
            MotionBlurTest.giu(class_3102, "tp @s -12 ~ 0");
            MotionBlurTest.gir(class_7462, -90.0f, 8.0f);
        }
        if (n == 300) {
            class_3102.field_1690.field_1894.method_23481(true);
            class_3102.field_1690.field_1867.method_23481(true);
            MotionBlurPass.gpuMillis();
        }
        if (n == 330) {
            System.out.println("motion walk RenderPerfTest " + MotionBlurTest.giv(MotionBlurPass.gpuMillis()) + " ms, speed " + MotionBlurTest.giv(class_7462.method_18798().method_37267() * 20.0) + " b/s");
            MotionBlurTest.git(class_3102, "walk");
        }
        if (n == 332) {
            class_3102.field_1690.field_1894.method_23481(false);
            class_3102.field_1690.field_1867.method_23481(false);
            MotionBlurTest.giu(class_3102, "tp @s 0 ~ 0");
        }
        if (n == 338) {
            ((ModeSetting)MotionBlurTest.gis(kfe2, "Качество")).set("Ультра");
        }
        MotionBlurTest.gip(class_3102, n, 340, 370, 12.0f, 0.0f, "ultra-240");
        if (n == 375) {
            ((ModeSetting)MotionBlurTest.gis(kfe2, "Качество")).set("Низкое");
        }
        MotionBlurTest.gip(class_3102, n, 378, 408, 12.0f, 0.0f, "low-240");
        if (n == 412) {
            ((ModeSetting)MotionBlurTest.gis(kfe2, "Качество")).set("Высокое");
            kfe2.setEnabled(false);
        }
        MotionBlurTest.gip(class_3102, n, 415, 445, 12.0f, 0.0f, "off-240");
        if (n == 450) {
            MotionBlurPass.timing(false);
            return true;
        }
        return false;
    }

    private static void gip(class_310 class_3102, int n, int n2, int n3, float f, float f2, String string) {
        class_746 class_7462 = class_3102.field_1724;
        if (n == n2) {
            gig = f == 0.0f ? class_7462.method_36454() : -90.0f - f * (float)(n3 - n2);
            gih = f2 == 0.0f ? 0.0f : class_7462.method_36455();
            gii = f * 20.0f;
            gij = f2 * 20.0f;
            gik = System.nanoTime();
            MotionBlurTest.gir(class_7462, gig, gih);
            ghz = Float.MAX_VALUE;
            gia = 0.0f;
            gib = 0.0;
            gic = 0;
            MotionBlurPass.gpuMillis();
            gim.setLength(0);
            gif = true;
        } else if (n > n2 && n <= n3) {
            if (n > n2 + 12) {
                float f3 = MotionBlur.turnSpeed();
                ghz = Math.min(ghz, f3);
                gia = Math.max(gia, f3);
                gib += (double)f3;
                ++gic;
            }
            if (n == n3) {
                System.out.println("motion " + string + " RenderPerfTest " + MotionBlurTest.giv(MotionBlurPass.gpuMillis()) + " ms, blur speed " + MotionBlurTest.giv(ghz) + ".." + MotionBlurTest.giv(gia) + " avg " + MotionBlurTest.giv(gib / (double)Math.max(1, gic)) + " deg/s (camera " + MotionBlurTest.giv(Math.hypot(f, f2) * 20.0) + ")");
                MotionBlurTest.git(class_3102, string);
                gif = false;
                try {
                    Files.writeString(class_3102.field_1697.toPath().resolve("flow2-motion-" + string + ".csv"), (CharSequence)gim, new OpenOption[0]);
                }
                catch (IOException iOException) {
                    System.out.println("motion csv failed: " + iOException);
                }
            }
        }
    }

    private static void giq(class_310 class_3102) {
        if (!gif || class_3102.field_1724 == null) {
            return;
        }
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        long l = System.nanoTime();
        gim.append(l).append(',').append(class_41842.method_19330()).append(',').append(class_41842.method_19329()).append(',').append(MotionBlur.turnSpeed()).append('\n');
        float f = (float)(l - gik) / 1.0E9f;
        float f2 = gig + (float)Math.floor(gii * f / 0.15f) * 0.15f;
        float f3 = gih + (float)Math.floor(gij * f / 0.15f) * 0.15f;
        MotionBlurTest.gir(class_3102.field_1724, f2, f3);
    }

    private static void gir(class_746 class_7462, float f, float f2) {
        class_7462.method_36456(f);
        class_7462.method_36457(f2);
        class_7462.field_5982 = f;
        class_7462.field_6004 = f2;
    }

    private static Setting gis(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException("no setting " + string);
    }

    private static void git(class_310 class_3102, String string) {
        String string2 = "flow2-motion-" + ++gid + "-" + string + ".png";
        System.out.println("motion shot " + string2 + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)string2, (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static void giu(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static String giv(double d) {
        return String.format(Locale.ROOT, "%.2f", d);
    }

    static {
        gim = new StringBuilder();
    }

    private static /* synthetic */ int ty(int n, int n2) {
        return n * n2 + 1264696875;
    }
}

