/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_11909
 *  net.minecraft.class_11910
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
 *  net.minecraft.class_3419
 *  net.minecraft.class_3532
 *  net.minecraft.class_4065
 *  net.minecraft.class_437
 *  net.minecraft.class_745
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWKeyCallback
 *  org.lwjgl.glfw.GLFWKeyCallbackI
 */
package a;

import a.ClickGuiScreen;
import a.GuiConfig;
import a.Theme;
import a.Module;
import a.ModuleManager;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.Sounds;
import a.SoundLibrary;
import a.WindowKeyHook;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.awt.Color;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import net.minecraft.class_4065;
import net.minecraft.class_437;
import net.minecraft.class_745;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

final class RenderPerfTest {
    private static final String[] gpv = new String[]{"AutoSprint", "NoJumpDelay", "ItemPhysics"};
    private static String gpw;
    private static String gpx;
    private static double gpy;
    private static class_4065 gpz;
    private static Object gqa;
    private static class_1297 gqb;
    private static float gqc;
    private static /* synthetic */ String gqd;
    private static /* synthetic */ String gqe;

    private RenderPerfTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        class_437 class_4372 = class_3102.field_1755;
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        switch (n) {
            case 1: {
                gpw = Theme.PRESET.get();
                gpx = Theme.ACCENT.get();
                RenderPerfTest.gqf(class_3102, "Render");
                break;
            }
            case 30: {
                RenderPerfTest.gqt(class_3102, "p01-render");
                break;
            }
            case 31: {
                RenderPerfTest.gqm(class_4372, 330.0f, 200.0f, -14.0);
                break;
            }
            case 50: {
                RenderPerfTest.gqt(class_3102, "p02-render-bottom");
                break;
            }
            case 51: {
                RenderPerfTest.gqf(class_3102, "Theme");
                for (Object obj : RenderPerfTest.gqg("themeCards")) {
                    RenderPerfTest.gqi(obj);
                }
                break;
            }
            case 70: {
                RenderPerfTest.gqt(class_3102, "p03-theme-folded");
                break;
            }
            case 71: {
                Object object = RenderPerfTest.gqh("themeCards", "Custom theme");
                RenderPerfTest.gql(class_4372, RenderPerfTest.gqq(object, "x") + 30.0f, RenderPerfTest.gqq(object, "y") + 12.0f, 0);
                break;
            }
            case 90: {
                RenderPerfTest.gqt(class_3102, "p04-custom-open");
                break;
            }
            case 91: {
                Object object = RenderPerfTest.gqj();
                RenderPerfTest.gql(class_4372, RenderPerfTest.gqq(object, "x") + 30.0f, RenderPerfTest.gqq(object, "y") + 2.0f + 32.0f + 8.0f, 0);
                break;
            }
            case 104: {
                Object object = RenderPerfTest.gqj();
                float f = RenderPerfTest.gqq(object, "x");
                float f2 = RenderPerfTest.gqq(object, "w");
                float f3 = RenderPerfTest.gqq(object, "y") + 2.0f + 48.0f + 4.0f;
                float f4 = f2 - 30.0f;
                RenderPerfTest.gql(class_4372, f + f4 + 6.0f + 4.5f, f3 + 34.72f, 0);
                class_4372.method_25406(new class_11909(0.0, 0.0, new class_11910(0, 0)));
                RenderPerfTest.gql(class_4372, f + f4 * 0.55f, f3 + 40.32f, 0);
                class_4372.method_25406(new class_11909(0.0, 0.0, new class_11910(0, 0)));
                RenderPerfTest.gqk("MENU_PAINTS", 15, -34215);
                break;
            }
            case 122: {
                RenderPerfTest.gqt(class_3102, "p05-color-editor");
                System.out.println("paint preset=" + Theme.PRESET.get() + " card=" + RenderPerfTest.gqs(Theme.card) + " accent=" + RenderPerfTest.gqs(Theme.accent()));
                break;
            }
            case 123: {
                ((ModeSetting)RenderPerfTest.gqo(Theme.class, "PAINT")).set("HUD");
                RenderPerfTest.gqk("HUD_PAINTS", 0, -14019520);
                RenderPerfTest.gqk("HUD_PAINTS", 1, -5900);
                RenderPerfTest.gqk("HUD_PAINTS", 4, -10556716);
                break;
            }
            case 140: {
                RenderPerfTest.gqt(class_3102, "p06-hud-colors-menu");
                break;
            }
            case 141: {
                class_3102.method_1507(null);
                break;
            }
            case 160: {
                RenderPerfTest.gqt(class_3102, "p07-hud-colors-game");
                System.out.println("paint menu colours outside the HUD: window=" + RenderPerfTest.gqs(Theme.window) + " accent=" + RenderPerfTest.gqs(Theme.accent()));
                break;
            }
            case 161: {
                for (String string : new String[]{gpv[0], gpv[1]}) {
                    kfx2.getByName(string).toggle();
                }
                break;
            }
            case 170: {
                RenderPerfTest.gqt(class_3102, "p08-alerts-two");
                break;
            }
            case 171: {
                kfx2.getByName(gpv[2]).toggle();
                break;
            }
            case 180: {
                RenderPerfTest.gqt(class_3102, "p09-alerts-three");
                break;
            }
            case 185: {
                long l = class_3102.method_22683().method_4490();
                GLFWKeyCallback gLFWKeyCallback = GLFW.glfwSetKeyCallback((long)l, null);
                GLFW.glfwSetKeyCallback((long)l, (GLFWKeyCallbackI)gLFWKeyCallback);
                gpz = (class_4065)class_3102.field_1690.method_42476().method_41753();
                gLFWKeyCallback.invoke(l, 66, 48, 1, 2);
                gLFWKeyCallback.invoke(l, 66, 48, 0, 2);
                break;
            }
            case 190: {
                gqa = class_3102.field_1690.method_42476().method_41753();
                long l = class_3102.method_22683().method_4490();
                GLFWKeyCallbackI gLFWKeyCallbackI = (GLFWKeyCallbackI)RenderPerfTest.gqo(WindowKeyHook.class, "original");
                gLFWKeyCallbackI.invoke(l, 66, 48, 1, 2);
                gLFWKeyCallbackI.invoke(l, 66, 48, 0, 2);
                break;
            }
            case 195: {
                Object object = class_3102.field_1690.method_42476().method_41753();
                class_3102.field_1690.method_42476().method_41748((Object)gpz);
                System.out.println("paint ctrl+b: narrator " + gpz + ", after Ctrl+B " + gqa + ", game callback alone " + object + " (narrator available=" + class_3102.method_44713().method_1791() + ", hotkey option=" + class_3102.field_1690.method_53530().method_41753() + ")");
                System.out.println("paint pauseOnLostFocus=" + class_3102.field_1690.field_1837);
                class_3102.method_15995(false);
                break;
            }
            case 225: {
                System.out.println("paint focus lost 1.5 s: screen=" + (class_3102.field_1755 == null ? "none" : class_3102.field_1755.getClass().getSimpleName()));
                class_3102.method_15995(true);
                break;
            }
            case 230: {
                RenderPerfTest.gqt(class_3102, "p10-alerts-gone");
                break;
            }
            case 231: {
                Module kfe2 = kfx2.getByName("ClientSounds");
                kfe2.setEnabled(true);
                gpy = (Double)class_3102.field_1690.method_45578(class_3419.field_15250).method_41753();
                class_3102.field_1690.method_45578(class_3419.field_15250).method_41748((Object)0.0);
                Files.write(SoundLibrary.dir().resolve("Hero.wav"), RenderPerfTest.gqn(660.0, 0.4), new OpenOption[0]);
                SoundLibrary.scan();
                break;
            }
            case 232: 
            case 238: 
            case 244: 
            case 250: 
            case 256: 
            case 262: 
            case 268: {
                int n2 = (n - 232) / 6;
                String[] stringArray = new String[]{"Celestial", "Twinkle", "Bubble", "Celestial", "Twinkle", "Bubble", "Celestial"};
                Sounds.play(stringArray[n2], n2 % 2 == 0, 0.6f);
                break;
            }
            case 274: {
                Sounds.play("Hero", true, 0.6f);
                System.out.println("paint sound files: " + SoundLibrary.extras() + " toggle list: " + ((ModeSetting)RenderPerfTest.gqr(kfx2.getByName("ClientSounds"), "Toggle")).getModes());
                break;
            }
            case 235: 
            case 241: 
            case 247: 
            case 253: 
            case 259: 
            case 265: 
            case 271: 
            case 277: {
                System.out.println("paint sound (master " + class_3102.field_1690.method_45578(class_3419.field_15250).method_41753() + "): " + Sounds.report());
                break;
            }
            case 280: {
                class_3102.field_1690.method_45578(class_3419.field_15250).method_41748((Object)gpy);
                class_3102.field_1724.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8802));
                float f = class_3102.field_1724.method_36454();
                class_243 class_2432 = class_243.method_1030((float)0.0f, (float)(f + 180.0f)).method_1021(3.0);
                class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), "Behind"));
                class_7452.method_5808(class_3102.field_1724.method_23317() + class_2432.field_1352, class_3102.field_1724.method_23318(), class_3102.field_1724.method_23321() + class_2432.field_1350, f, 0.0f);
                class_3102.field_1687.method_53875((class_1297)class_7452);
                gqb = class_7452;
                Module kfe3 = kfx2.getByName("AimAssist");
                ((NumberSetting)RenderPerfTest.gqr(kfe3, "FOV")).set(360.0);
                kfe3.setEnabled(true);
                gqc = f;
                break;
            }
            case 330: {
                class_243 class_2433 = gqb.method_73189().method_1020(class_3102.field_1724.method_73189());
                double d = Math.toDegrees(Math.atan2(class_2433.field_1350, class_2433.field_1352)) - 90.0;
                double d2 = Math.abs(class_3532.method_15338((double)(d - (double)class_3102.field_1724.method_36454())));
                double d3 = Math.abs(class_3532.method_15338((double)(d - (double)gqc)));
                System.out.println("paint aim360: " + Math.round(d3) + "° off before, " + Math.round(d2) + "° off after 2.5 s (focused=" + class_3102.method_1569() + ", cursor locked=" + class_3102.field_1729.method_1613() + ")");
                RenderPerfTest.gqt(class_3102, "p11-aim360");
                break;
            }
            case 331: {
                Module kfe4 = kfx2.getByName("AimAssist");
                kfe4.setEnabled(false);
                ((NumberSetting)RenderPerfTest.gqr(kfe4, "FOV")).reset();
                if (gqb != null) {
                    class_3102.field_1687.method_2945(gqb.method_5628(), class_1297.class_5529.field_26999);
                }
                for (String string : gpv) {
                    kfx2.getByName(string).toggle();
                }
                ModeSetting vlv2 = (ModeSetting)RenderPerfTest.gqo(Theme.class, "PAINT");
                Method method = Theme.class.getDeclaredMethod("resetCustom", new Class[0]);
                method.setAccessible(true);
                vlv2.set("HUD");
                method.invoke(null, new Object[0]);
                vlv2.set("Menu");
                method.invoke(null, new Object[0]);
                Theme.PRESET.set(gpw);
                Theme.ACCENT.set(gpx);
                GuiConfig.save();
                break;
            }
            case 332: {
                RenderPerfTest.gqf(class_3102, "Misc");
                break;
            }
            case 334: {
                Object v = ((Map)RenderPerfTest.gqo(ClickGuiScreen.class, "CARDS")).get(kfx2.getByName("ClientSounds"));
                Field field = v.getClass().getDeclaredField("collapsed");
                field.setAccessible(true);
                field.setBoolean(v, false);
                break;
            }
            case 350: {
                RenderPerfTest.gqt(class_3102, "p12-client-sounds");
                break;
            }
            case 351: {
                class_3102.method_1507(null);
                Files.deleteIfExists(SoundLibrary.dir().resolve("Hero.wav"));
                SoundLibrary.scan();
                break;
            }
            case 360: {
                return true;
            }
        }
        return false;
    }

    private static void gqf(class_310 class_3102, String string) throws Exception {
        ((Map)RenderPerfTest.gqo(ClickGuiScreen.class, "SCROLLS")).clear();
        for (String string2 : new String[]{"windowX", "windowY"}) {
            Field field = ClickGuiScreen.class.getDeclaredField(string2);
            field.setAccessible(true);
            field.setFloat(null, Float.NaN);
        }
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, string);
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static List<?> gqg(String string) throws Exception {
        return (List)RenderPerfTest.gqo(ClickGuiScreen.class, string);
    }

    private static Object gqh(String string, String string2) throws Exception {
        for (Object obj : RenderPerfTest.gqg(string)) {
            if (!string2.equals(RenderPerfTest.gqp(obj, "title"))) continue;
            return obj;
        }
        throw new IllegalStateException("no card " + string2);
    }

    private static void gqi(Object object) throws Exception {
        Field field = object.getClass().getDeclaredField("collapsed");
        field.setAccessible(true);
        field.setBoolean(object, true);
        Object object2 = RenderPerfTest.gqp(object, "expand");
        object2.getClass().getMethod("set", Float.TYPE).invoke(object2, Float.valueOf(0.0f));
    }

    private static Object gqj() throws Exception {
        for (Object e : (List)RenderPerfTest.gqp(RenderPerfTest.gqh("themeCards", "Custom theme"), "rows")) {
            if (!e.getClass().getSimpleName().equals("ColorsRow")) continue;
            return e;
        }
        throw new IllegalStateException("no colours row");
    }

    private static void gqk(String string, int n, int n2) throws Exception {
        Object object = Array.get(RenderPerfTest.gqo(Theme.class, string), n);
        float[] fArray = Color.RGBtoHSB(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, null);
        Method method = Theme.class.getDeclaredMethod("setPaint", object.getClass(), Integer.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        method.setAccessible(true);
        method.invoke(null, object, n2, Float.valueOf(fArray[0]), Float.valueOf(fArray[1]), Float.valueOf(fArray[2]));
    }

    private static void gql(class_437 class_4372, float f, float f2, int n) throws Exception {
        float f3 = RenderPerfTest.gqq(class_4372, "originX");
        float f4 = RenderPerfTest.gqq(class_4372, "originY");
        float f5 = RenderPerfTest.gqq(class_4372, "scale");
        class_4372.method_25402(new class_11909((double)(f3 + f * f5), (double)(f4 + f2 * f5), new class_11910(n, 0)), false);
    }

    private static void gqm(class_437 class_4372, float f, float f2, double d) throws Exception {
        float f3 = RenderPerfTest.gqq(class_4372, "originX");
        float f4 = RenderPerfTest.gqq(class_4372, "originY");
        float f5 = RenderPerfTest.gqq(class_4372, "scale");
        class_4372.method_25401((double)(f3 + f * f5), (double)(f4 + f2 * f5), 0.0, d);
    }

    private static byte[] gqn(double d, double d2) {
        int n = 48000;
        int n2 = (int)((double)n * d2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(44 + n2 * 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put("RIFF".getBytes()).putInt(36 + n2 * 2).put("WAVE".getBytes());
        byteBuffer.put("fmt ".getBytes()).putInt(16).putShort((short)1).putShort((short)1).putInt(n).putInt(n * 2).putShort((short)2).putShort((short)16);
        byteBuffer.put("data".getBytes()).putInt(n2 * 2);
        for (int i = 0; i < n2; ++i) {
            byteBuffer.putShort((short)(Math.sin(Math.PI * 2 * d * (double)i / (double)n) * 12000.0 * (1.0 - (double)i / (double)n2)));
        }
        return byteBuffer.array();
    }

    private static Object gqo(Class<?> clazz, String string) throws Exception {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        return field.get(null);
    }

    private static Object gqp(Object object, String string) throws Exception {
        for (Class<?> clazz = object.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(string);
                field.setAccessible(true);
                return field.get(object);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                continue;
            }
        }
        throw new NoSuchFieldException(string);
    }

    private static float gqq(Object object, String string) throws Exception {
        return ((Number)RenderPerfTest.gqp(object, string)).floatValue();
    }

    private static Setting gqr(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException("no setting " + string);
    }

    private static String gqs(int n) {
        return String.format("%08X", n);
    }

    private static void gqt(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int vw(int n, int n2) {
        return n + n2 + -384059047;
    }

    private static /* synthetic */ int vx(int n, int n2) {
        return RenderPerfTest.vw(n, n2) * n2;
    }

    private static /* synthetic */ int vy(int n, int n2) {
        return RenderPerfTest.vw(n, n2) * n2;
    }
}

