/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_337
 *  net.minecraft.class_345
 *  net.minecraft.class_3675
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_5348
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.LiquidGlass;
import a.GuiConfig;
import a.Theme;
import a.ArmorHudWidget;
import a.CooldownsWidget;
import a.HudEditorScreen;
import a.HudWidget;
import a.ItemsWidget;
import a.KeybindsWidget;
import a.NowPlaying;
import a.EffectsWidget;
import a.TargetHudWidget;
import a.WatermarkWidget;
import a.Module;
import a.MusicAnchor;
import a.SceneCapture;
import a.ColorUtil;
import a.GlassDraw;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.Lang;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_337;
import net.minecraft.class_345;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_5348;
import net.minecraft.class_9779;

public final class Hud {
    public static final BoolSetting ENABLED = new BoolSetting("HUD", true);
    public static final ModeSetting BACKGROUND = new ModeSetting("Background", "Solid", "Glass", "Solid");
    public static final NumberSetting OPACITY = new NumberSetting("Opacity", 0.75, 0.3, 1.0, 0.05).percent();
    public static final NumberSetting SCALE = new NumberSetting("Size", 1.0, 0.6, 1.6, 0.05).percent();
    public static final BoolSetting ARRANGE = new BoolSetting("Arrange in chat", true);
    public static final List<Setting> LOOK = List.of(BACKGROUND, OPACITY, SCALE, ARRANGE);
    public static final WatermarkWidget WATERMARK = new WatermarkWidget();
    public static final TargetHudWidget TARGET = new TargetHudWidget();
    public static final KeybindsWidget KEYBINDS = new KeybindsWidget();
    public static final EffectsWidget POTIONS = new EffectsWidget();
    public static final CooldownsWidget COOLDOWNS = new CooldownsWidget();
    public static final ItemsWidget ITEMS = new ItemsWidget();
    public static final ArmorHudWidget ARMOR = new ArmorHudWidget();
    public static final List<HudWidget> ELEMENTS = List.of(KEYBINDS, POTIONS, COOLDOWNS, ITEMS, ARMOR, TARGET, WATERMARK);
    private static final int izy = 2;
    static final FontFace BRAND = Fonts.semibold(7.6f);
    static final FontFace HEAD = Fonts.semibold(6.8f);
    static final FontFace TEXT = Fonts.medium(6.6f);
    static final FontFace VALUE = Fonts.semibold(6.2f);
    static final FontFace SMALL = Fonts.medium(5.2f);
    static final FontFace TITLE = Fonts.semibold(7.2f);
    static final FontFace SUB = Fonts.regular(6.1f);
    static final FontFace RING = Fonts.semibold(7.4f);
    static final FontFace TINY = Fonts.medium(4.4f);
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
    private static HudWidget jak;
    private static float jal;
    private static float jam;
    private static float jan;
    private static float jao;
    private static final Map<HudWidget, Spring> jap;
    private static Field jaq;
    private static boolean jar;
    private static float jas;
    private static long jat;
    private static int jau;
    private static HudWidget jav;
    private static float jaw;
    private static float jax;
    private static /* synthetic */ int jay;
    private static /* synthetic */ int jaz;

    private Hud() {
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        float f;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1755 instanceof ClickGuiScreen || class_3102.field_1755 instanceof HudEditorScreen) {
            return;
        }
        DrawUtil.beginFrame();
        boolean bl = class_3102.field_1755 instanceof class_408;
        float f2 = bl ? (float)class_3102.field_1729.method_68879(class_3102.method_22683()) : -1000.0f;
        float f3 = f = bl ? (float)class_3102.field_1729.method_68883(class_3102.method_22683()) : -1000.0f;
        if (!bl) {
            Hud.mouseReleased();
        }
        long l = System.nanoTime();
        Hud.jba(class_3322, false, bl, f2, f);
        jat += System.nanoTime() - l;
        ++jau;
    }

    public static double cpuMicros() {
        double d = jau == 0 ? 0.0 : (double)jat / 1000.0 / (double)jau;
        jat = 0L;
        jau = 0;
        return d;
    }

    public static void renderInMenu(class_332 class_3322, boolean bl) {
        Hud.jba(class_3322, bl, false, -1000.0f, -1000.0f);
    }

    static void renderEditor(class_332 class_3322) {
        Hud.jba(class_3322, true, false, -1000.0f, -1000.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void jba(class_332 class_3322, boolean bl, boolean bl2, float f, float f2) {
        class_310 class_3102 = class_310.method_1551();
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == jad) {
            return;
        }
        jad = FrameDelta.frame();
        boolean bl3 = ENABLED.get() && class_3102.field_1724 != null && class_3102.field_1687 != null;
        NowPlaying.tick(bl3 && Hud.WATERMARK.enabled.get() && WatermarkWidget.MUSIC.get() || class_3102.field_1724 != null && class_3102.field_1687 != null && MusicAnchor.wantsMusic());
        if (!bl3 || class_3102.field_1690.field_1842) {
            return;
        }
        float f3 = FrameDelta.delta() * (float)Theme.ANIMATION.get();
        Theme.update(f3);
        jag = bl2;
        jah = f;
        jai = f2;
        Theme.beginHud();
        try {
            Hud.jbb(class_3322, bl, bl2, f3);
        }
        finally {
            Theme.endHud();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void jbb(class_332 class_3322, boolean bl, boolean bl2, float f) {
        class_310 class_3102 = class_310.method_1551();
        jae = null;
        if (jaf && BACKGROUND.is("Glass") && LiquidGlass.ENABLED.get() && SceneCapture.HUD.capture(class_3322, LiquidGlass.FROST.getInt(), null)) {
            jae = SceneCapture.HUD.result(class_3322);
        }
        jaj = (float)SCALE.get();
        float f2 = class_3322.method_51421();
        float f3 = class_3322.method_51443();
        float f4 = Math.max(1, class_3102.method_22683().method_4495());
        float f5 = Hud.jbe(class_3102, f2, f3);
        boolean bl3 = bl2 && ARRANGE.get();
        boolean bl4 = false;
        try {
            for (HudWidget jcs2 : ELEMENTS) {
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
                FontFace.setRenderScale(f6);
                jcs2.place(f2, f3, jcs2.width() * f6, jcs2.height() * f6, f4);
                jcs2.y = jcs2.y + jcs2.push.step(jcs2 != jak ? Hud.jbg(jcs2, f2, f5) : 0.0f, f);
                jcs2.y = (float)Math.round(Math.min(f3 - jcs2.h, jcs2.y) * f4) / f4;
                float f8 = Easing.outCubic(f7);
                float f9 = 0.96f + 0.04f * f8;
                float f10 = 0.88f + 0.12f * f8;
                float f11 = (1.0f - f8) * 5.0f * (jcs2.ay == 2 ? 1.0f : -1.0f);
                float f12 = jcs2.pivotX();
                float f13 = jcs2.pivotY();
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(jcs2.x + f12, jcs2.y + f13 + f11);
                class_3322.method_51448().scale(f9, f10);
                class_3322.method_51448().translate(-f12, -f13);
                class_3322.method_51448().scale(f6, f6);
                DrawUtil.pushAlpha(f7 * (bl5 && jcs2.isSample() ? 0.4f : 1.0f));
                try {
                    jcs2.draw(class_3322, f, bl);
                }
                finally {
                    DrawUtil.popAlpha();
                    class_3322.method_51448().popMatrix();
                }
            }
        }
        finally {
            FontFace.setRenderScale(1.0f);
        }
        jaf = bl4;
        if (bl2) {
            Hud.jbc(class_3322, f, f4);
        }
    }

    private static void jbc(class_332 class_3322, float f, float f2) {
        HudWidget jcs3 = jak != null ? jak : jav;
        HudWidget jcs4 = jcs3 != null ? jcs3 : Hud.at(jah, jai);
        Iterator<HudWidget> iterator = ELEMENTS.iterator();
        while (iterator.hasNext()) {
            HudWidget jcs5;
            float f3 = jap.computeIfAbsent(jcs5, jcs2 -> new Spring(16.0f)).step((jcs5 = iterator.next()) == jcs4 && jcs5.w > 0.0f, f);
            if (f3 <= 0.01f || jcs5.w <= 0.0f) continue;
            float f4 = Theme.r(8.0f);
            int n = Math.round((jcs5 == jcs3 ? 150.0f : 80.0f) * f3);
            DrawUtil.outline(class_3322, jcs5.x - 2.5f, jcs5.y - 2.5f, jcs5.w + 5.0f, jcs5.h + 5.0f, f4 + 2.5f, 1.0f, ColorUtil.withAlpha(0xFFFFFF, n));
            if (jcs5 != jcs4) continue;
            Hud.jbd(class_3322, jcs5, f3, jcs5 == jav);
        }
        if (jak != null) {
            int n = Theme.accent(170);
            float f5 = 1.0f / f2;
            if (!Float.isNaN(jan)) {
                DrawUtil.rect(class_3322, jan - f5 * 0.5f, 0.0f, f5, class_3322.method_51443(), n);
            }
            if (!Float.isNaN(jao)) {
                DrawUtil.rect(class_3322, 0.0f, jao - f5 * 0.5f, class_3322.method_51421(), f5, n);
            }
        }
    }

    private static void jbd(class_332 class_3322, HudWidget jcs2, float f, boolean bl) {
        String string = bl ? Math.round(jcs2.size * 100.0f) + "%" : (jcs2.size != 1.0f ? Math.round(jcs2.size * 100.0f) + Lang.s("%  ·  right drag: size", "%  ·  ПКМ: размер") : Lang.s("Right drag: size", "ПКМ + тянуть: размер"));
        float f2 = SMALL.width(string) + 10.0f;
        float f3 = 11.0f;
        class_310 class_3102 = class_310.method_1551();
        float f4 = class_3102.method_22683().method_4486();
        float f5 = Math.max(2.0f, Math.min(f4 - f2 - 2.0f, jcs2.x + (jcs2.w - f2) * 0.5f));
        boolean bl2 = jcs2.y < f3 + 8.0f;
        float f6 = bl2 ? jcs2.y + jcs2.h + 5.0f : jcs2.y - f3 - 5.0f;
        DrawUtil.pushAlpha(f);
        DrawUtil.round(class_3322, f5, f6, f2, f3, Math.min(f3 * 0.5f, Theme.r(5.5f)), bl ? Theme.accent() : ColorUtil.withAlpha(Theme.window, 210));
        SMALL.drawCentered(class_3322, string, f5 + f2 * 0.5f, SMALL.centerTop(f6 + f3 * 0.5f), bl ? Theme.onAccent() : Theme.textDim);
        DrawUtil.popAlpha();
    }

    private static float jbe(class_310 class_3102, float f, float f2) {
        jas = 0.0f;
        Map<?, ?> map = Hud.jbf(class_3102);
        if (map == null || map.isEmpty()) {
            return 0.0f;
        }
        int n = 12;
        int n2 = 0;
        float f3 = 91.0f;
        for (Object obj : map.values()) {
            ++n2;
            if (obj instanceof class_345) {
                class_345 class_3452 = (class_345)obj;
                f3 = Math.max(f3, (float)class_3102.field_1772.method_27525((class_5348)class_3452.method_5414()) * 0.5f);
            }
            if (!((float)(n += 19) >= f2 / 3.0f)) continue;
            break;
        }
        jas = f3 + 4.0f;
        return 12 + (n2 - 1) * 19 + 5;
    }

    private static Map<?, ?> jbf(class_310 class_3102) {
        if (jar || class_3102.field_1705 == null) {
            return null;
        }
        try {
            class_337 class_3372 = class_3102.field_1705.method_1740();
            if (jaq == null) {
                for (Field field : class_337.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Map.class.isAssignableFrom(field.getType())) continue;
                    field.setAccessible(true);
                    jaq = field;
                    break;
                }
                if (jaq == null) {
                    throw new IllegalStateException("boss bar map not found");
                }
            }
            return (Map)jaq.get(class_3372);
        }
        catch (Throwable throwable) {
            jar = true;
            System.out.println("boss bars unknown, the HUD won't step around them: " + throwable);
            return null;
        }
    }

    private static float jbg(HudWidget jcs2, float f, float f2) {
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
        HudWidget jcs2 = Hud.at((float)d, (float)d2);
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
            Hud.startResize(jcs2, (float)d, (float)d2);
        }
        return true;
    }

    static void startResize(HudWidget jcs2, float f, float f2) {
        jav = jcs2;
        jaw = jcs2.size;
        float f3 = jcs2.x + jcs2.pivotX();
        float f4 = jcs2.y + jcs2.pivotY();
        jax = Math.max(Math.max(jcs2.w, jcs2.h) * 0.35f, (float)Math.hypot(f - f3, f2 - f4));
    }

    static void resize(float f, float f2, boolean bl) {
        HudWidget jcs2 = jav;
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

    static HudWidget resizing() {
        return jav;
    }

    static void endResize() {
        jav = null;
    }

    public static boolean mouseDragged(double d, double d2) {
        if (jav != null) {
            class_310 class_3102 = class_310.method_1551();
            Hud.resize((float)d, (float)d2, class_3675.method_15987((class_1041)class_3102.method_22683(), (int)342) || class_3675.method_15987((class_1041)class_3102.method_22683(), (int)346));
            return true;
        }
        if (jak == null) {
            return false;
        }
        class_310 class_3103 = class_310.method_1551();
        float f = class_3103.method_22683().method_4486();
        float f2 = class_3103.method_22683().method_4502();
        boolean bl = class_3675.method_15987((class_1041)class_3103.method_22683(), (int)342) || class_3675.method_15987((class_1041)class_3103.method_22683(), (int)346);
        float[] fArray = Hud.drag(jak, (float)d - jal, (float)d2 - jam, f, f2, bl);
        jan = fArray[0];
        jao = fArray[1];
        return true;
    }

    public static boolean mouseReleased() {
        if (jav != null) {
            jav = null;
            GuiConfig.saveLater();
            return true;
        }
        if (jak == null) {
            return false;
        }
        jak = null;
        jan = Float.NaN;
        jao = Float.NaN;
        GuiConfig.saveLater();
        return true;
    }

    static float[] drag(HudWidget jcs2, float f, float f2, float f3, float f4, boolean bl) {
        float f5 = Float.NaN;
        float f6 = Float.NaN;
        if (!bl) {
            float[] fArray = Hud.jbh(jcs2, f, jcs2.w, f3, true);
            f = fArray[0];
            f5 = fArray[1];
            float[] fArray2 = Hud.jbh(jcs2, f2, jcs2.h, f4, false);
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
    private static float[] jbh(HudWidget jcs2, float f, float f2, float f3, boolean bl) {
        void var7_10;
        ArrayList<float[]> arrayList = new ArrayList<float[]>();
        arrayList.add(new float[]{4.0f, 4.0f});
        arrayList.add(new float[]{(f3 - f2) * 0.5f, f3 * 0.5f});
        arrayList.add(new float[]{f3 - f2 - 4.0f, f3 - 4.0f});
        for (HudWidget object2 : ELEMENTS) {
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

    static HudWidget at(float f, float f2) {
        for (int i = ELEMENTS.size() - 1; i >= 0; --i) {
            HudWidget jcs2 = ELEMENTS.get(i);
            if (!(jcs2.w > 0.0f) || !(f >= jcs2.x - 2.0f) || !(f < jcs2.x + jcs2.w + 2.0f) || !(f2 >= jcs2.y - 2.0f) || !(f2 < jcs2.y + jcs2.h + 2.0f)) continue;
            return jcs2;
        }
        return null;
    }

    static boolean pointer() {
        return jag;
    }

    static float localMouseX(HudWidget jcs2) {
        return jag ? (jah - jcs2.x) / jcs2.scale : -1000.0f;
    }

    static float localMouseY(HudWidget jcs2) {
        return jag ? (jai - jcs2.y) / jcs2.scale : -1000.0f;
    }

    static void chip(class_332 class_3322, float f, float f2, float f3, float f4, float f5) {
        float f6 = (float)OPACITY.get();
        int n = ColorUtil.withAlpha(Theme.window, Math.round(255.0f * Math.min(1.0f, f6 * 0.55f)));
        if (jae == null || !DrawUtil.glass(class_3322, jae, f, f2, f3, f4, f5, n, 1.0f)) {
            DrawUtil.round(class_3322, f, f2, f3, f4, f5, Theme.hudFill(f6 * 0.6f));
        }
        DrawUtil.outline(class_3322, f, f2, f3, f4, f5, 1.0f, Theme.hudEdge());
    }

    static void panel(class_332 class_3322, float f, float f2, float f3) {
        float f4 = Theme.lightness();
        GlassDraw.shadow(class_3322, 0.0f, 0.0f, f, f2, f3, 1.4f, f4);
        float f5 = (float)OPACITY.get();
        boolean bl = false;
        if (jae != null) {
            float f6 = Math.max(0.4f, Math.min(1.0f, f5 * Theme.tintScale()));
            int n = LiquidGlass.tint(Theme.window, f6);
            boolean bl2 = bl = LiquidGlass.liquid() ? DrawUtil.liquid(class_3322, jae, 0.0f, 0.0f, f, f2, f3, n, 1.0f, LiquidGlass.lens(Math.min((float)LiquidGlass.EDGE.get(), f2 * 0.42f))) : DrawUtil.glass(class_3322, jae, 0.0f, 0.0f, f, f2, f3, n, 1.0f);
        }
        if (!bl) {
            DrawUtil.round(class_3322, 0.0f, 0.0f, f, f2, f3, Theme.hudFill(f5));
        }
        GlassDraw.sheen(class_3322, 0.0f, 0.0f, f, f2, f3, 1.0f - 0.7f * f4);
        GlassDraw.rim(class_3322, 0.0f, 0.0f, f, f2, f3, f4, bl && LiquidGlass.liquid() ? 0.6f : 1.0f);
        if (!bl || !LiquidGlass.liquid()) {
            DrawUtil.outline(class_3322, 0.0f, 0.0f, f, f2, f3, 1.0f, Theme.hudEdge());
        }
    }

    public static void moduleToggled(Module kfe2) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || kfe2.isAction() && !kfe2.isEnabled()) {
            return;
        }
        WATERMARK.toggled(kfe2);
    }

    public static void alert(String string, String string2, Icon vhz2, boolean bl) {
        class_310 class_3102 = class_310.method_1551();
        if (!class_3102.method_18854()) {
            class_3102.execute(() -> Hud.alert(string, string2, vhz2, bl));
            return;
        }
        if (ENABLED.get() && Hud.WATERMARK.enabled.get() && WatermarkWidget.ALERTS.get()) {
            WATERMARK.alert(string, string2, vhz2, bl);
        }
    }

    public static void notify(String string, String string2) {
        Hud.alert(string, string2, Icon.INFO, true);
    }

    public static void openEditor() {
        class_310.method_1551().method_1507((class_437)new HudEditorScreen());
    }

    public static void resetLayout() {
        for (HudWidget jcs2 : ELEMENTS) {
            jcs2.resetPosition();
        }
    }

    public static Map<String, Setting> persisted() {
        LinkedHashMap<String, Setting> linkedHashMap = new LinkedHashMap<String, Setting>();
        linkedHashMap.put("hud.enabled", ENABLED);
        for (Setting object : LOOK) {
            linkedHashMap.put("hud." + Hud.jbi(object), object);
        }
        for (HudWidget jcs2 : ELEMENTS) {
            linkedHashMap.put("hud." + jcs2.id + ".enabled", jcs2.enabled);
            for (Setting vmo2 : jcs2.settings()) {
                linkedHashMap.put("hud." + jcs2.id + "." + Hud.jbi(vmo2), vmo2);
            }
        }
        return linkedHashMap;
    }

    private static String jbi(Setting vmo2) {
        return vmo2.getName().toLowerCase(Locale.ROOT).replace(' ', '-');
    }

    public static void save(Properties properties) {
        properties.setProperty("hud.layout", String.valueOf(2));
        for (HudWidget jcs2 : ELEMENTS) {
            properties.setProperty("hud.pos." + jcs2.id, jcs2.savePosition());
        }
    }

    public static void load(Properties properties) {
        int n;
        try {
            n = Integer.parseInt(properties.getProperty("hud.layout", "1").trim());
        }
        catch (NumberFormatException numberFormatException) {
            n = 1;
        }
        for (HudWidget jcs2 : ELEMENTS) {
            String string;
            if (n < 2 && jcs2 == WATERMARK || (string = properties.getProperty("hud.pos." + jcs2.id)) == null) continue;
            jcs2.loadPosition(string);
        }
    }

    public static int enabledCount() {
        int n = 0;
        for (HudWidget jcs2 : ELEMENTS) {
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
        jap = new LinkedHashMap<HudWidget, Spring>();
    }

    private static /* synthetic */ int alg(int n, int n2) {
        return n - n2 ^ 0x28768477;
    }

    private static /* synthetic */ int alh(int n, int n2) {
        return Hud.alg(n, n2) + n;
    }
}

