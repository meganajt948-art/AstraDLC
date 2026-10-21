/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.class_266
 *  net.minecraft.class_269
 *  net.minecraft.class_2960
 *  net.minecraft.class_303$class_7590
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_338
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_8646
 *  net.minecraft.class_9779
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.Easing;
import a.BoolSetting;
import a.NumberSetting;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_2960;
import net.minecraft.class_303;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_338;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_8646;
import net.minecraft.class_9779;
import org.joml.Matrix3x2fStack;

public class SmoothUi
extends Module {
    private static SmoothUi qxj;
    private static boolean qxk;
    private final BoolSetting qxl = this.add(new BoolSetting("Tab", true));
    private final BoolSetting qxm = this.add(new BoolSetting("Chat", true));
    private final BoolSetting qxn = this.add(new BoolSetting("Inventory", true));
    private final NumberSetting qxo = this.add(new NumberSetting("Speed", 1.0, 0.5, 2.0, 0.1));
    private static float qxp;
    private static long qxq;
    private static Field qxr;
    private static boolean qxs;
    private static Object qxt;
    private static long qxu;
    private static final Map<class_437, Long> qxv;
    private static boolean qxw;
    private static /* synthetic */ long qxx;
    private static /* synthetic */ int qxy;

    public SmoothUi() {
        super(new String(new char[]{'A', 'n', 'i', 'm', 'a', 't', 'i', 'o', 'n', 's'}), "Smooth tab list, chat and inventories", ModuleCategory.RENDER);
        qxj = this;
        this.setEnabled(true);
        SmoothUi.qyb();
    }

    private static boolean qxz(BoolSetting vkl2) {
        return qxj != null && qxj.isEnabled() && vkl2.get();
    }

    private static float qya(float f) {
        return f / (float)Math.max(0.2, SmoothUi.qxj.qxo.get());
    }

    private static void qyb() {
        if (qxk) {
            return;
        }
        qxk = true;
        try {
            HudElementRegistry.replaceElement((class_2960)VanillaHudElements.PLAYER_LIST, hudElement -> SmoothUi.qyc(hudElement));
            HudElementRegistry.replaceElement((class_2960)VanillaHudElements.CHAT, hudElement -> SmoothUi.qye(hudElement));
        }
        catch (Throwable throwable) {
            System.out.println("tab / chat animations unavailable: " + throwable);
        }
    }

    private static HudElement qyc(HudElement hudElement) {
        return (class_3322, class_97792) -> {
            if (qxj == null || !SmoothUi.qxz(SmoothUi.qxj.qxl)) {
                qxp = 0.0f;
                hudElement.render(class_3322, class_97792);
                return;
            }
            try {
                SmoothUi.qyd(class_3322, class_97792, hudElement);
            }
            catch (Throwable throwable) {
                System.out.println("tab animation failed: " + throwable);
                SmoothUi.qxj.qxl.set(false);
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void qyd(class_332 class_3322, class_9779 class_97792, HudElement hudElement) {
        class_310 class_3102 = class_310.method_1551();
        long l = System.nanoTime();
        float f = qxq == 0L ? 0.0f : Math.min(0.1f, (float)(l - qxq) / 1.0E9f);
        qxq = l;
        class_269 class_2692 = class_3102.field_1687.method_8428();
        class_266 class_2662 = class_2692.method_1189(class_8646.field_45156);
        int n = class_3102.field_1724.field_3944.method_45732().size();
        boolean bl = class_3102.field_1690.field_1907.method_1434() && (!class_3102.method_1542() || n > 1 || class_2662 != null);
        if ((qxp = Easing.clamp01(qxp + (bl ? f / SmoothUi.qya(0.24f) : -f / SmoothUi.qya(0.16f)))) <= 0.0f || qxp >= 1.0f && bl) {
            hudElement.render(class_3322, class_97792);
            return;
        }
        float f2 = qxp * qxp * (3.0f - 2.0f * qxp);
        int n2 = class_3322.method_51421();
        int n3 = n;
        int n4 = 1;
        while (n3 > 20) {
            n3 = (n + ++n4 - 1) / n4;
        }
        float f3 = 10.0f + (float)n3 * 9.0f + 50.0f;
        class_3322.method_44379(0, 0, n2, Math.max(1, Math.round(4.0f + f2 * f3)));
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        float f4 = 0.94f + 0.06f * f2;
        matrix3x2fStack.translate((float)n2 * 0.5f, 10.0f - (1.0f - f2) * 6.0f);
        matrix3x2fStack.scale(f4, f4);
        matrix3x2fStack.translate((float)(-n2) * 0.5f, -10.0f);
        try {
            if (bl) {
                hudElement.render(class_3322, class_97792);
            } else {
                class_3322.method_71048();
                class_3102.field_1705.method_1750().method_1919(class_3322, n2, class_2692, class_2662);
            }
        }
        finally {
            matrix3x2fStack.popMatrix();
            class_3322.method_44380();
        }
    }

    private static HudElement qye(HudElement hudElement) {
        return (class_3322, class_97792) -> {
            if (qxj == null || !SmoothUi.qxz(SmoothUi.qxj.qxm) || qxs) {
                hudElement.render(class_3322, class_97792);
                return;
            }
            float f = 0.0f;
            try {
                f = SmoothUi.qyf(class_310.method_1551());
            }
            catch (Throwable throwable) {
                qxs = true;
                System.out.println("chat animation unavailable: " + throwable);
            }
            if (f < 0.05f) {
                hudElement.render(class_3322, class_97792);
                return;
            }
            Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(0.0f, f);
            try {
                hudElement.render(class_3322, class_97792);
            }
            finally {
                matrix3x2fStack.popMatrix();
            }
        };
    }

    private static float qyf(class_310 class_3102) throws IllegalAccessException {
        float f;
        Object object;
        class_338 class_3382 = class_3102.field_1705.method_1743();
        if (qxr == null) {
            object = class_338.class.getDeclaredFields();
            int n = ((Field[])object).length;
            for (int i = 0; i < n; ++i) {
                ParameterizedType parameterizedType;
                Type type;
                Object object2 = object[i];
                if (Modifier.isStatic(((Field)object2).getModifiers()) || ((Field)object2).getType() != List.class || !((type = ((Field)object2).getGenericType()) instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments().length != 1 || parameterizedType.getActualTypeArguments()[0] != class_303.class_7590.class) continue;
                ((Field)object2).setAccessible(true);
                qxr = object2;
            }
            if (qxr == null) {
                throw new IllegalStateException("chat lines not found");
            }
        }
        Object var3_4 = (object = (List)qxr.get(class_3382)).isEmpty() ? null : object.get(0);
        long l = System.nanoTime();
        if (var3_4 != qxt) {
            if (qxt != null && var3_4 != null) {
                qxu = l;
            }
            qxt = var3_4;
        }
        if ((f = Easing.clamp01((float)(l - qxu) / 1.0E9f / SmoothUi.qya(0.28f))) >= 1.0f) {
            return 0.0f;
        }
        double d = (Double)class_3102.field_1690.method_42546().method_41753();
        double d2 = (Double)class_3102.field_1690.method_42554().method_41753();
        float f2 = (float)(9.0 * (d + 1.0) * d2);
        return (1.0f - Easing.outCubic(f)) * f2;
    }

    public static void attach(class_437 class_4373) {
        if (qxj == null || !(class_4373 instanceof class_465) && !(class_4373 instanceof class_408)) {
            return;
        }
        qxv.putIfAbsent(class_4373, System.nanoTime());
        ScreenEvents.beforeRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> SmoothUi.qyg(class_4372, class_3322));
        ScreenEvents.afterRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> SmoothUi.qyj(class_3322));
    }

    private static void qyg(class_437 class_4372, class_332 class_3322) {
        qxw = false;
        Long l = qxv.get(class_4372);
        if (l == null) {
            return;
        }
        boolean bl = class_4372 instanceof class_408;
        if (!SmoothUi.qxz(bl ? SmoothUi.qxj.qxm : SmoothUi.qxj.qxn)) {
            return;
        }
        float f = Easing.clamp01((float)(System.nanoTime() - l) / 1.0E9f / SmoothUi.qya(bl ? 0.2f : 0.26f));
        if (f >= 1.0f) {
            return;
        }
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        qxw = true;
        if (bl) {
            matrix3x2fStack.translate(0.0f, (1.0f - Easing.outCubic(f)) * 16.0f);
            return;
        }
        float f2 = Easing.outBack(f);
        int n = class_4372.field_22789;
        int n2 = class_4372.field_22790;
        float f3 = 0.9f + 0.1f * f2;
        float f4 = (1.0f - Easing.outCubic(f)) * 10.0f;
        if (f3 < 1.0f) {
            int n3 = (int)Math.ceil((float)n * 0.5f - (float)n * 0.5f * f3);
            int n4 = (int)Math.floor((float)n * 0.5f + (float)n * 0.5f * f3);
            int n5 = (int)Math.ceil((float)n2 * 0.5f + f4 - (float)n2 * 0.5f * f3);
            int n6 = (int)Math.floor((float)n2 * 0.5f + f4 + (float)n2 * 0.5f * f3);
            SmoothUi.qyh(class_3322, 0, 0, n, n5, n2);
            SmoothUi.qyh(class_3322, 0, n6, n, n2, n2);
            SmoothUi.qyh(class_3322, 0, n5, n3, n6, n2);
            SmoothUi.qyh(class_3322, n4, n5, n, n6, n2);
        }
        matrix3x2fStack.translate((float)n * 0.5f, (float)n2 * 0.5f + f4);
        matrix3x2fStack.scale(f3, f3);
        matrix3x2fStack.translate((float)(-n) * 0.5f, (float)(-n2) * 0.5f);
    }

    private static void qyh(class_332 class_3322, int n, int n2, int n3, int n4, int n5) {
        if (n3 <= n || n4 <= n2) {
            return;
        }
        class_3322.method_25296(n, n2, n3, n4, SmoothUi.qyi((float)n2 / (float)n5), SmoothUi.qyi((float)n4 / (float)n5));
    }

    private static int qyi(float f) {
        int n = Math.round(192.0f + 16.0f * Math.max(0.0f, Math.min(1.0f, f)));
        return n << 24 | 0x101010;
    }

    private static void qyj(class_332 class_3322) {
        if (qxw) {
            qxw = false;
            class_3322.method_51448().popMatrix();
        }
    }

    static {
        qxv = new WeakHashMap<class_437, Long>();
    }

    private static /* synthetic */ int bwo(int n, int n2) {
        return n + n2 ^ 0xD37C6E14;
    }
}

