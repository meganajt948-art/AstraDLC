/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.BossBarHud
 *  net.minecraft.client.gui.hud.ClientBossBar
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.Window
 *  net.minecraft.text.StringVisitable
 */
package a;

import a.hlc;
import a.hyv;
import a.hyz;
import a.iov;
import a.ixu;
import a.izj;
import a.jbs;
import a.jcs;
import a.jdc;
import a.jef;
import a.jgn;
import a.jie;
import a.jjx;
import a.jlx;
import a.kfe;
import a.shx;
import a.uij;
import a.ujt;
import a.ukf;
import a.unf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdn;
import a.veo;
import a.vhz;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import a.wap;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.Window;
import net.minecraft.text.StringVisitable;

public final class izx {
    public static final vkl ENABLED = new vkl(a.d("\ub108\uc8a4\u4266", -607459147, 801397238), true);
    public static final vlv BACKGROUND = new vlv(a.b("\u786d\u01ff\u8b2e\u1557\u9e8c\u1828\ua266\u2b8d\ub5c9\u3f72", 353073189), a.b("\u6ae1\u136c\u99bc\u07c8\u8c12", -879924553), a.b("\u6521\u1cbb\u9665\u0806\u83d1", -267819677), a.d("\uc99b\ub016\u3ac6\ua4b2\u2f68", 1581166602, 1982495175));
    public static final vmc OPACITY = new vmc(a.c(604394798, "\u5566\u2ce8\ua62a\u3859\ub384\u3528\u8f76"), 0.75, 0.3, 1.0, 0.05).percent();
    public static final vmc SCALE = new vmc(a.d("\u8d87\uf40c\u7ecc\ue0a2", 250645634, 1982595410), 1.0, 0.6, 1.6, 0.05).percent();
    public static final vkl ARRANGE = new vkl(a.c(1293471158, "\ucdf8\ub47a\u3ea9\ua0cb\u2b13\uadab\u17fa\u9e4eX\u8aee\u0d73\uf741\u799d\ue025\u6a63"), true);
    public static final List<vmo> LOOK = List.of(BACKGROUND, OPACITY, SCALE, ARRANGE);
    public static final jlx WATERMARK = new jlx();
    public static final jjx TARGET = new jjx();
    public static final jef KEYBINDS = new jef();
    public static final jie POTIONS = new jie();
    public static final izj COOLDOWNS = new izj();
    public static final jdc ITEMS = new jdc();
    public static final ixu ARMOR = new ixu();
    public static final List<jcs> ELEMENTS = List.of(KEYBINDS, POTIONS, COOLDOWNS, ITEMS, ARMOR, TARGET, WATERMARK);
    private static final int izy = 2;
    static final vdn BRAND = veo.semibold(7.6f);
    static final vdn HEAD = veo.semibold(6.8f);
    static final vdn TEXT = veo.medium(6.6f);
    static final vdn VALUE = veo.semibold(6.2f);
    static final vdn SMALL = veo.medium(5.2f);
    static final vdn TITLE = veo.semibold(7.2f);
    static final vdn SUB = veo.regular(6.1f);
    static final vdn RING = veo.semibold(7.4f);
    static final vdn TINY = veo.medium(4.4f);
    private static final float izz = 4.0f;
    private static final float jaa = 4.0f;
    private static final float jab = 4.0f;
    private static final float jac = 5.0f;
    private static long jad = -1L;
    private static GpuTextureView jae;
    private static boolean jaf;
    private static boolean jag;
    private static float jah;
    private static float jai;
    private static float jaj;
    private static jcs jak;
    private static float jal;
    private static float jam;
    private static float jan;
    private static float jao;
    private static final Map<jcs, vcj> jap;
    private static Field jaq;
    private static boolean jar;
    private static float jas;
    private static long jat;
    private static int jau;
    private static jcs jav;
    private static float jaw;
    private static float jax;
    private static /* synthetic */ int jay;
    private static /* synthetic */ int jaz;

    private izx() {
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        float f;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.currentScreen instanceof hlc || minecraftClient.currentScreen instanceof jbs) {
            return;
        }
        uut.beginFrame();
        boolean bl = minecraftClient.currentScreen instanceof ChatScreen;
        float f2 = bl ? (float)minecraftClient.mouse.getScaledX(minecraftClient.getWindow()) : -1000.0f;
        float f3 = f = bl ? (float)minecraftClient.mouse.getScaledY(minecraftClient.getWindow()) : -1000.0f;
        if (!bl) {
            izx.mouseReleased();
        }
        long l = System.nanoTime();
        izx.jba(drawContext, false, bl, f2, f);
        jat += System.nanoTime() - l;
        ++jau;
    }

    public static double cpuMicros() {
        double d = jau == 0 ? 0.0 : (double)jat / 1000.0 / (double)jau;
        jat = 0L;
        jau = 0;
        return d;
    }

    public static void renderInMenu(DrawContext drawContext, boolean bl) {
        izx.jba(drawContext, bl, false, -1000.0f, -1000.0f);
    }

    static void renderEditor(DrawContext drawContext) {
        izx.jba(drawContext, true, false, -1000.0f, -1000.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void jba(DrawContext drawContext, boolean bl, boolean bl2, float f, float f2) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        unf.observe(drawContext);
        if (unf.frame() == jad) {
            return;
        }
        jad = unf.frame();
        boolean bl3 = ENABLED.get() && minecraftClient.player != null && minecraftClient.world != null;
        jgn.tick(bl3 && izx.WATERMARK.enabled.get() && jlx.MUSIC.get() || minecraftClient.player != null && minecraftClient.world != null && shx.wantsMusic());
        if (!bl3 || minecraftClient.options.hudHidden) {
            return;
        }
        float f3 = unf.delta() * (float)iov.ANIMATION.get();
        iov.update(f3);
        jag = bl2;
        jah = f;
        jai = f2;
        iov.beginHud();
        try {
            izx.jbb(drawContext, bl, bl2, f3);
        }
        finally {
            iov.endHud();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void jbb(DrawContext drawContext, boolean bl, boolean bl2, float f) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        jae = null;
        if (jaf && BACKGROUND.is(a.c(-1330669848, "\u96aa\uef30\u65ee\ufb8d\u705a")) && hyv.ENABLED.get() && uij.HUD.capture(drawContext, hyv.FROST.getInt(), null)) {
            jae = uij.HUD.result(drawContext);
        }
        jaj = (float)SCALE.get();
        float f2 = drawContext.getScaledWindowWidth();
        float f3 = drawContext.getScaledWindowHeight();
        float f4 = Math.max(1, minecraftClient.getWindow().getScaleFactor());
        float f5 = izx.jbe(minecraftClient, f2, f3);
        boolean bl3 = bl2 && ARRANGE.get();
        boolean bl4 = false;
        try {
            for (jcs jcs2 : ELEMENTS) {
                float f6;
                boolean bl5 = bl3 && jcs2.canGhost();
                jcs2.update(f, bl || bl5);
                float f7 = jcs2.shown.step(jcs2.enabled.get() && jcs2.hasContent(bl || bl5), f);
                if (f7 <= 0.004f) {
                    jcs2.w = 0.0f;
                    continue;
                }
                bl4 = true;
                jcs2.scale = f6 = Math.max(0.25f, (float)Math.round(jaj * jcs2.size * f4 * 4.0f) / 4.0f) / f4;
                vdn.setRenderScale(f6);
                jcs2.place(f2, f3, jcs2.width() * f6, jcs2.height() * f6, f4);
                jcs2.y = jcs2.y + jcs2.push.step(jcs2 != jak ? izx.jbg(jcs2, f2, f5) : 0.0f, f);
                jcs2.y = (float)Math.round(Math.min(f3 - jcs2.h, jcs2.y) * f4) / f4;
                float f8 = vcq.outCubic(f7);
                float f9 = 0.96f + 0.04f * f8;
                float f10 = 0.88f + 0.12f * f8;
                float f11 = (1.0f - f8) * 5.0f * (jcs2.ay == 2 ? 1.0f : -1.0f);
                float f12 = jcs2.pivotX();
                float f13 = jcs2.pivotY();
                drawContext.getMatrices().pushMatrix();
                drawContext.getMatrices().translate(jcs2.x + f12, jcs2.y + f13 + f11);
                drawContext.getMatrices().scale(f9, f10);
                drawContext.getMatrices().translate(-f12, -f13);
                drawContext.getMatrices().scale(f6, f6);
                uut.pushAlpha(f7 * (bl5 && jcs2.isSample() ? 0.4f : 1.0f));
                try {
                    jcs2.draw(drawContext, f, bl);
                }
                finally {
                    uut.popAlpha();
                    drawContext.getMatrices().popMatrix();
                }
            }
        }
        finally {
            vdn.setRenderScale(1.0f);
        }
        jaf = bl4;
        if (bl2) {
            izx.jbc(drawContext, f, f4);
        }
    }

    private static void jbc(DrawContext drawContext, float f, float f2) {
        jcs jcs3 = jak != null ? jak : jav;
        jcs jcs4 = jcs3 != null ? jcs3 : izx.at(jah, jai);
        Iterator<jcs> iterator = ELEMENTS.iterator();
        while (iterator.hasNext()) {
            jcs jcs5;
            float f3 = jap.computeIfAbsent(jcs5, jcs2 -> new vcj(16.0f)).step((jcs5 = iterator.next()) == jcs4 && jcs5.w > 0.0f, f);
            if (f3 <= 0.01f || jcs5.w <= 0.0f) continue;
            float f4 = iov.r(8.0f);
            int n = Math.round((jcs5 == jcs3 ? 150.0f : 80.0f) * f3);
            uut.outline(drawContext, jcs5.x - 2.5f, jcs5.y - 2.5f, jcs5.w + 5.0f, jcs5.h + 5.0f, f4 + 2.5f, 1.0f, ujt.withAlpha(0xFFFFFF, n));
            if (jcs5 != jcs4) continue;
            izx.jbd(drawContext, jcs5, f3, jcs5 == jav);
        }
        if (jak != null) {
            int n = iov.accent(170);
            float f5 = 1.0f / f2;
            if (!Float.isNaN(jan)) {
                uut.rect(drawContext, jan - f5 * 0.5f, 0.0f, f5, drawContext.getScaledWindowHeight(), n);
            }
            if (!Float.isNaN(jao)) {
                uut.rect(drawContext, 0.0f, jao - f5 * 0.5f, drawContext.getScaledWindowWidth(), f5, n);
            }
        }
    }

    private static void jbd(DrawContext drawContext, jcs jcs2, float f, boolean bl) {
        String string = bl ? Math.round(jcs2.size * 100.0f) + a.d("\u3805", -221134532, -1448937187) : (jcs2.size != 1.0f ? Math.round(jcs2.size * 100.0f) + wap.s(a.c(146640362, "\u8dd9\uf46d\u7ebe\ue058\u6b18\ueda9\u57a8\ude42\u4013\ucaad\u4d62\ub747\u39d4\ua073\u2a33\uacc4\u16d6\u991d\u03fd\u85b6\u0c52\u761c"), a.b("\uadde\ud46a\u5eb9\uc05f\u4b1f\ucdae\u73c2\ufa36\u646f\ueaf8\u6d31\u9320\u1d87\u8431\u0e69\u8891\u32ab", -2086752790)) : wap.s(a.b("\ubd52\uc4d8\u4e05\ud07b\u5bb0\udd55\u6742\ueea5\u70e9\ufa5e\u7dd0\u87bb\u093f\u9094\u1ad4\u9c3a", -1425031920), a.b("\u85cd\ufc79\u76ac\uece1\u673d\ue187\u5fb6\ud64a\u4867\uc2a8\u457a\ubf05\u35a4\uac0f\u223c\ua4bd\u1ef5\u912f\u0b95\u8db1", -1353743930)));
        float f2 = SMALL.width(string) + 10.0f;
        float f3 = 11.0f;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        float f4 = minecraftClient.getWindow().getScaledWidth();
        float f5 = Math.max(2.0f, Math.min(f4 - f2 - 2.0f, jcs2.x + (jcs2.w - f2) * 0.5f));
        boolean bl2 = jcs2.y < f3 + 8.0f;
        float f6 = bl2 ? jcs2.y + jcs2.h + 5.0f : jcs2.y - f3 - 5.0f;
        uut.pushAlpha(f);
        uut.round(drawContext, f5, f6, f2, f3, Math.min(f3 * 0.5f, iov.r(5.5f)), bl ? iov.accent() : ujt.withAlpha(iov.window, 210));
        SMALL.drawCentered(drawContext, string, f5 + f2 * 0.5f, SMALL.centerTop(f6 + f3 * 0.5f), bl ? iov.onAccent() : iov.textDim);
        uut.popAlpha();
    }

    private static float jbe(MinecraftClient minecraftClient, float f, float f2) {
        jas = 0.0f;
        Map<?, ?> map = izx.jbf(minecraftClient);
        if (map == null || map.isEmpty()) {
            return 0.0f;
        }
        int n = 12;
        int n2 = 0;
        float f3 = 91.0f;
        for (Object obj : map.values()) {
            ++n2;
            if (obj instanceof ClientBossBar) {
                ClientBossBar clientBossBar = (ClientBossBar)obj;
                f3 = Math.max(f3, (float)minecraftClient.textRenderer.getWidth((StringVisitable)clientBossBar.getName()) * 0.5f);
            }
            if (!((float)(n += 19) >= f2 / 3.0f)) continue;
            break;
        }
        jas = f3 + 4.0f;
        return 12 + (n2 - 1) * 19 + 5;
    }

    private static Map<?, ?> jbf(MinecraftClient minecraftClient) {
        if (jar || minecraftClient.inGameHud == null) {
            return null;
        }
        try {
            BossBarHud bossBarHud = minecraftClient.inGameHud.getBossBarHud();
            if (jaq == null) {
                for (Field field : BossBarHud.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Map.class.isAssignableFrom(field.getType())) continue;
                    field.setAccessible(true);
                    jaq = field;
                    break;
                }
                if (jaq == null) {
                    throw new IllegalStateException(a.d("\ua559\udce5\u562a\uc85b\u43df\uc52c\u7f7c\uf69e\u6893\ue26f\u65b0\u9fd0\u1157\u88a8\u02fa\u8410\u3e0b\ub19c\u2b26\uad6d\u2481\u5eda", -1129476197, -882365770));
                }
            }
            return (Map)jaq.get(bossBarHud);
        }
        catch (Throwable throwable) {
            jar = true;
            System.out.println(a.c(-2038236450, "\ufa8f\u8333\u09fc\u978d\u1c09\u9afa\u20aa\ua948\u3716\ubdf4\u3a72\uc018\u4eca\ud77e\u5d2c\udbc5\u6193\uee00\u74bf\uf2ba\u7b51\u010d\u8ffb\u1442\u9220\u18e0\ua137\u2f31\ub5de\u338e\ub874\u46f6\ucced\u554f\ud31b\u59bb\ue679\u6c58\ueaca\u7368\uf92a\u87c1\u0d89\u8a32\u10a1\u9e84\u274b\uadf7\u2bb0\ub036\u3e5f") + throwable);
            return null;
        }
    }

    private static float jbg(jcs jcs2, float f, float f2) {
        if (f2 <= 0.0f || jcs2.ay != 0) {
            return 0.0f;
        }
        float f3 = f * 0.5f;
        if (jcs2.x > f3 + jas || jcs2.x + jcs2.w < f3 - jas) {
            return 0.0f;
        }
        return Math.max(0.0f, f2 + 5.0f - jcs2.y);
    }

    public static boolean mouseClicked(double d, double d2, int n) {
        if (!ENABLED.get()) {
            return false;
        }
        jcs jcs2 = izx.at((float)d, (float)d2);
        if (jcs2 == null) {
            return false;
        }
        if (jcs2.mouseClicked((float)((d - (double)jcs2.x) / (double)jcs2.scale), (float)((d2 - (double)jcs2.y) / (double)jcs2.scale), n)) {
            return true;
        }
        if (n == 0) {
            jak = jcs2;
            jal = (float)d - jcs2.x;
            jam = (float)d2 - jcs2.y;
            jcs2.push.set(0.0f);
        } else if (n == 1) {
            izx.startResize(jcs2, (float)d, (float)d2);
        }
        return true;
    }

    static void startResize(jcs jcs2, float f, float f2) {
        jav = jcs2;
        jaw = jcs2.size;
        float f3 = jcs2.x + jcs2.pivotX();
        float f4 = jcs2.y + jcs2.pivotY();
        jax = Math.max(Math.max(jcs2.w, jcs2.h) * 0.35f, (float)Math.hypot(f - f3, f2 - f4));
    }

    static void resize(float f, float f2, boolean bl) {
        jcs jcs2 = jav;
        float f3 = jcs2.x + jcs2.pivotX();
        float f4 = jcs2.y + jcs2.pivotY();
        float f5 = (float)Math.hypot(f - f3, f2 - f4);
        float f6 = jaw * f5 / jax;
        f6 = Math.max(0.5f, Math.min(2.0f, (float)Math.round(f6 * 100.0f) / 100.0f));
        if (!bl && Math.abs(f6 - 1.0f) < 0.04f) {
            f6 = 1.0f;
        }
        jcs2.size = f6;
    }

    static jcs resizing() {
        return jav;
    }

    static void endResize() {
        jav = null;
    }

    public static boolean mouseDragged(double d, double d2) {
        if (jav != null) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            izx.resize((float)d, (float)d2, InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)342) || InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)346));
            return true;
        }
        if (jak == null) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        float f = minecraftClient.getWindow().getScaledWidth();
        float f2 = minecraftClient.getWindow().getScaledHeight();
        boolean bl = InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)342) || InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)346);
        float[] fArray = izx.drag(jak, (float)d - jal, (float)d2 - jam, f, f2, bl);
        jan = fArray[0];
        jao = fArray[1];
        return true;
    }

    public static boolean mouseReleased() {
        if (jav != null) {
            jav = null;
            hyz.saveLater();
            return true;
        }
        if (jak == null) {
            return false;
        }
        jak = null;
        jan = Float.NaN;
        jao = Float.NaN;
        hyz.saveLater();
        return true;
    }

    static float[] drag(jcs jcs2, float f, float f2, float f3, float f4, boolean bl) {
        float f5 = Float.NaN;
        float f6 = Float.NaN;
        if (!bl) {
            float[] fArray = izx.jbh(jcs2, f, jcs2.w, f3, true);
            f = fArray[0];
            f5 = fArray[1];
            float[] fArray2 = izx.jbh(jcs2, f2, jcs2.h, f4, false);
            f2 = fArray2[0];
            f6 = fArray2[1];
        }
        f = Math.max(0.0f, Math.min(f3 - jcs2.w, f));
        f2 = Math.max(0.0f, Math.min(f4 - jcs2.h, f2));
        jcs2.moveTo(f, f2, f3, f4);
        return new float[]{f5, f6};
    }

    /*
     * WARNING - void declaration
     */
    private static float[] jbh(jcs jcs2, float f, float f2, float f3, boolean bl) {
        void var7_10;
        ArrayList<float[]> arrayList = new ArrayList<float[]>();
        arrayList.add(new float[]{4.0f, 4.0f});
        arrayList.add(new float[]{(f3 - f2) * 0.5f, f3 * 0.5f});
        arrayList.add(new float[]{f3 - f2 - 4.0f, f3 - 4.0f});
        for (jcs object2 : ELEMENTS) {
            if (object2 == jcs2 || object2.w <= 0.0f) continue;
            float f4 = bl ? object2.x : object2.y;
            float f5 = bl ? object2.w : object2.h;
            arrayList.add(new float[]{f4, f4});
            arrayList.add(new float[]{f4 + f5 - f2, f4 + f5});
            arrayList.add(new float[]{f4 + (f5 - f2) * 0.5f, f4 + f5 * 0.5f});
            arrayList.add(new float[]{f4 + f5 + 4.0f, f4 + f5 + 4.0f});
            arrayList.add(new float[]{f4 - f2 - 4.0f, f4 - 4.0f});
        }
        float f6 = 4.0f;
        float[] fArray = new float[]{f, Float.NaN};
        for (float[] fArray2 : arrayList) {
            float f7 = Math.abs(fArray2[0] - f);
            if (!(f7 < f6)) continue;
            f6 = f7;
            float[] fArray3 = new float[]{fArray2[0], fArray2[1]};
        }
        return var7_10;
    }

    static jcs at(float f, float f2) {
        for (int i = ELEMENTS.size() - 1; i >= 0; --i) {
            jcs jcs2 = ELEMENTS.get(i);
            if (!(jcs2.w > 0.0f) || !(f >= jcs2.x - 2.0f) || !(f < jcs2.x + jcs2.w + 2.0f) || !(f2 >= jcs2.y - 2.0f) || !(f2 < jcs2.y + jcs2.h + 2.0f)) continue;
            return jcs2;
        }
        return null;
    }

    static boolean pointer() {
        return jag;
    }

    static float localMouseX(jcs jcs2) {
        return jag ? (jah - jcs2.x) / jcs2.scale : -1000.0f;
    }

    static float localMouseY(jcs jcs2) {
        return jag ? (jai - jcs2.y) / jcs2.scale : -1000.0f;
    }

    static void chip(DrawContext drawContext, float f, float f2, float f3, float f4, float f5) {
        float f6 = (float)OPACITY.get();
        int n = ujt.withAlpha(iov.window, Math.round(255.0f * Math.min(1.0f, f6 * 0.55f)));
        if (jae == null || !uut.glass(drawContext, jae, f, f2, f3, f4, f5, n, 1.0f)) {
            uut.round(drawContext, f, f2, f3, f4, f5, iov.hudFill(f6 * 0.6f));
        }
        uut.outline(drawContext, f, f2, f3, f4, f5, 1.0f, iov.hudEdge());
    }

    static void panel(DrawContext drawContext, float f, float f2, float f3) {
        float f4 = iov.lightness();
        ukf.shadow(drawContext, 0.0f, 0.0f, f, f2, f3, 1.4f, f4);
        float f5 = (float)OPACITY.get();
        boolean bl = false;
        if (jae != null) {
            float f6 = Math.max(0.4f, Math.min(1.0f, f5 * iov.tintScale()));
            int n = hyv.tint(iov.window, f6);
            boolean bl2 = bl = hyv.liquid() ? uut.liquid(drawContext, jae, 0.0f, 0.0f, f, f2, f3, n, 1.0f, hyv.lens(Math.min((float)hyv.EDGE.get(), f2 * 0.42f))) : uut.glass(drawContext, jae, 0.0f, 0.0f, f, f2, f3, n, 1.0f);
        }
        if (!bl) {
            uut.round(drawContext, 0.0f, 0.0f, f, f2, f3, iov.hudFill(f5));
        }
        ukf.sheen(drawContext, 0.0f, 0.0f, f, f2, f3, 1.0f - 0.7f * f4);
        ukf.rim(drawContext, 0.0f, 0.0f, f, f2, f3, f4, bl && hyv.liquid() ? 0.6f : 1.0f);
        if (!bl || !hyv.liquid()) {
            uut.outline(drawContext, 0.0f, 0.0f, f, f2, f3, 1.0f, iov.hudEdge());
        }
    }

    public static void moduleToggled(kfe kfe2) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null || kfe2.isAction() && !kfe2.isEnabled()) {
            return;
        }
        WATERMARK.toggled(kfe2);
    }

    public static void alert(String string, String string2, vhz vhz2, boolean bl) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (!minecraftClient.isOnThread()) {
            minecraftClient.execute(() -> izx.alert(string, string2, vhz2, bl));
            return;
        }
        if (ENABLED.get() && izx.WATERMARK.enabled.get() && jlx.ALERTS.get()) {
            WATERMARK.alert(string, string2, vhz2, bl);
        }
    }

    public static void notify(String string, String string2) {
        izx.alert(string, string2, vhz.INFO, true);
    }

    public static void openEditor() {
        MinecraftClient.getInstance().setScreen((Screen)new jbs());
    }

    public static void resetLayout() {
        for (jcs jcs2 : ELEMENTS) {
            jcs2.resetPosition();
        }
    }

    public static Map<String, vmo> persisted() {
        LinkedHashMap<String, vmo> linkedHashMap = new LinkedHashMap<String, vmo>();
        linkedHashMap.put(a.d("\u8e50\uf7fc\u7d3e\ue305\u6899\uee23\u547f\udd8d\u43dc\uc964\u4eb6", -1775606424, -1715934373), ENABLED);
        for (vmo object : LOOK) {
            linkedHashMap.put(a.b("\uaef1\ud75d\u5d9f\uc3a4", 783593117) + izx.jbi(object), object);
        }
        for (jcs jcs2 : ELEMENTS) {
            linkedHashMap.put(a.d("\u6d11\u14bd\u9e7fD", 803970647, -556797142) + jcs2.id + a.b("\ude6f\ua795\u2d4d\ub333\u38e7\ube58\u0402\u8df2", -1976050103), jcs2.enabled);
            for (vmo vmo2 : jcs2.settings()) {
                linkedHashMap.put(a.d("\ufa75\u83d9\u091b\u9720", 549113076, 405616365) + jcs2.id + a.b("\uead9", -755045642) + izx.jbi(vmo2), vmo2);
            }
        }
        return linkedHashMap;
    }

    private static String jbi(vmo vmo2) {
        return vmo2.getName().toLowerCase(Locale.ROOT).replace(' ', '-');
    }

    public static void save(Properties properties) {
        properties.setProperty(a.d("\ue012\u99be\u137c\u8d47\u06d2\u806e\u3a25\ub3c2\u2d87\ua737", 1706126024, -195392840), String.valueOf(2));
        for (jcs jcs2 : ELEMENTS) {
            properties.setProperty(a.b("\u3a04\u43a8\uc96a\u5751\udcd8\u5a76\ue039\u6995", 938949220) + jcs2.id, jcs2.savePosition());
        }
    }

    public static void load(Properties properties) {
        int n;
        try {
            n = Integer.parseInt(properties.getProperty(a.c(52465729, "\u9023\ue98f\u634d\ufd76\u76e3\uf05f\u4a14\uc3f3\u5db6\ud706"), a.b("\u5028", -1874112488)).trim());
        }
        catch (NumberFormatException numberFormatException) {
            n = 1;
        }
        for (jcs jcs2 : ELEMENTS) {
            String string;
            if (n < 2 && jcs2 == WATERMARK || (string = properties.getProperty(a.b("\u23b1\u5a1d\ud0df\u4ee4\uc56d\u43c3\uf98c\u7020", -830659631) + jcs2.id)) == null) continue;
            jcs2.loadPosition(string);
        }
    }

    public static int enabledCount() {
        int n = 0;
        for (jcs jcs2 : ELEMENTS) {
            if (!jcs2.enabled.get()) continue;
            ++n;
        }
        return ENABLED.get() ? n : 0;
    }

    static {
        jaf = true;
        jah = -1000.0f;
        jai = -1000.0f;
        jaj = 1.0f;
        jan = Float.NaN;
        jao = Float.NaN;
        jap = new LinkedHashMap<jcs, vcj>();
    }

    private static /* synthetic */ int alg(int n, int n2) {
        return n - n2 ^ 0x28768477;
    }

    private static /* synthetic */ int alh(int n, int n2) {
        return izx.alg(n, n2) + n;
    }
}

