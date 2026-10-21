/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.Friends;
import a.Theme;
import a.NameProtect;
import a.ubj;
import a.PartyClient;
import a.ugd;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import a.WaypointRenderer;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class PartyMarkerRenderer {
    private static final FontFace ugh = Fonts.semibold(6.6f);
    private static final FontFace ugi = Fonts.medium(5.6f);
    private static final float ugj = 22.0f;
    private static final float ugk = 15.0f;
    private static final float ugl = 15.0f;
    private static final float ugm = 0.41666666f;
    private static final float ugn = 0.125f;
    private static final float ugo = 0.41666666f;
    private static final float ugp = 24.0f;
    private static final Map<ubj, ugd> ugq = new IdentityHashMap<ubj, ugd>();
    private static /* synthetic */ String ugr;
    private static /* synthetic */ String ugs;

    private PartyMarkerRenderer() {
    }

    public static class_243 anchor(ubj ubj2, float f) {
        if (ubj2.target != null) {
            class_1657 class_16572 = Friends.inWorld(ubj2.target);
            if (class_16572 != null) {
                class_243 class_2432 = class_16572.method_30950(f);
                return new class_243(class_2432.field_1352, class_2432.field_1351 + (double)class_16572.method_17682() + 0.3, class_2432.field_1350);
            }
            return new class_243(ubj2.x, ubj2.y + 2.1, ubj2.z);
        }
        return new class_243(ubj2.x, ubj2.y, ubj2.z);
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        class_310 class_3102 = class_310.method_1551();
        List<ubj> list = PartyClient.marks();
        if (list.isEmpty() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842) {
            ugq.clear();
            return;
        }
        ArrayList<ubj> arrayList = new ArrayList<ubj>();
        for (ubj ubj3 : list) {
            if (!PartyClient.visible(ubj3)) continue;
            arrayList.add(ubj3);
        }
        ugq.keySet().retainAll(arrayList);
        if (arrayList.isEmpty()) {
            return;
        }
        FrameDelta.observe(class_3322);
        float f = FrameDelta.delta();
        Theme.update(f * (float)Theme.ANIMATION.get());
        float f2 = class_3322.method_51421();
        float f3 = class_3322.method_51443();
        float f4 = class_97792.method_60637(true);
        try {
            usn2 = ScreenProjection.capture(f4, f2, f3);
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        long l = System.currentTimeMillis();
        float[] fArray = new float[2];
        float[] fArray2 = new float[2];
        ArrayList<class_243> arrayList2 = new ArrayList<class_243>();
        for (ubj ubj4 : arrayList) {
            arrayList2.add(PartyMarkerRenderer.anchor(ubj4, f4));
        }
        Integer[] integerArray = new Integer[arrayList.size()];
        for (int i = 0; i < integerArray.length; ++i) {
            integerArray[i] = i;
        }
        Arrays.sort(integerArray, (n, n2) -> Double.compare(usn2.distance(((class_243)list.get((int)n2.intValue())).field_1352, ((class_243)list.get((int)n2.intValue())).field_1351, ((class_243)list.get((int)n2.intValue())).field_1350), usn2.distance(((class_243)list.get((int)n.intValue())).field_1352, ((class_243)list.get((int)n.intValue())).field_1351, ((class_243)list.get((int)n.intValue())).field_1350)));
        Integer[] integerArray2 = integerArray;
        int n3 = integerArray2.length;
        for (int i = 0; i < n3; ++i) {
            int n4 = integerArray2[i];
            ubj ubj5 = (ubj)arrayList.get(n4);
            class_243 class_2432 = (class_243)arrayList2.get(n4);
            ugd ugd2 = ugq.computeIfAbsent(ubj5, ubj2 -> new ugd());
            float f5 = ubj5.age(l);
            float f6 = (float)(ubj5.life - (l - ubj5.born)) / 1000.0f;
            float f7 = Math.min(1.0f, f5 / 0.15f) * Math.min(1.0f, Math.max(0.0f, f6 / 1.2f));
            if (f7 <= 0.01f) continue;
            double d = usn2.distance(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
            boolean bl = usn2.project(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, fArray);
            float f8 = 28.0f;
            boolean bl2 = bl && fArray[0] > f8 && fArray[0] < f2 - f8 && fArray[1] > f8 + 22.0f && fArray[1] < f3 - f8;
            usn2.direction(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, fArray2);
            float f9 = 32.0f;
            float f10 = f3 - 24.0f - 40.0f;
            float f11 = (f9 + f10) * 0.5f;
            float f12 = f2 * 0.5f - 24.0f;
            float f13 = (f10 - f9) * 0.5f;
            float f14 = Math.min(f12 / Math.max(1.0E-4f, Math.abs(fArray2[0])), f13 / Math.max(1.0E-4f, Math.abs(fArray2[1])));
            float f15 = f2 * 0.5f + fArray2[0] * f14;
            float f16 = f11 + fArray2[1] * f14;
            if (!ugd2.placed) {
                ugd2.inside.set(bl2 ? 1.0f : 0.0f);
                ugd2.placed = true;
            }
            float f17 = Easing.outCubic(ugd2.inside.step(bl2, f));
            float f18 = bl2 || bl ? PartyMarkerRenderer.ugt(f15, fArray[0], f17) : f15;
            float f19 = bl2 || bl ? PartyMarkerRenderer.ugt(f16, fArray[1], f17) : f16;
            float f20 = ubj5.target != null ? 7.5f : 13.200001f;
            boolean bl3 = f17 > 0.5f && Math.hypot(fArray[0] - f2 * 0.5f, fArray[1] - f20 - f3 * 0.5f) < 13.0;
            float f21 = ugd2.focus.step(bl3, f);
            float f22 = ubj5.target != null ? 1.0f : (float)Math.min(1.0, Math.max(0.3, (d - 1.5) / 4.0));
            DrawUtil.pushAlpha(f7);
            if (f17 > 0.02f) {
                DrawUtil.pushAlpha(f17 * f22);
                if (ubj5.target != null) {
                    PartyMarkerRenderer.ugw(class_3322, ubj5, f18, f19, d, f5, f21);
                } else {
                    PartyMarkerRenderer.ugv(class_3322, ubj5, f18, f19, d, f5, f21);
                }
                DrawUtil.popAlpha();
            }
            if (f17 < 0.98f) {
                DrawUtil.pushAlpha(1.0f - f17);
                PartyMarkerRenderer.uha(class_3322, ubj5, f15, f16, fArray2[0], fArray2[1], d, f5);
                DrawUtil.popAlpha();
            }
            DrawUtil.popAlpha();
        }
    }

    private static float ugt(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private static float ugu(double d) {
        return (float)Math.max(0.78, Math.min(1.06, 1.1 - Math.log10(Math.max(1.0, d)) * 0.1));
    }

    private static void ugv(class_332 class_3322, ubj ubj2, float f, float f2, double d, float f3, float f4) {
        int n = ubj2.color | 0xFF000000;
        float f5 = PartyMarkerRenderer.ugu(d);
        float f6 = Easing.outCubic(Math.min(1.0f, f3 / 0.35f));
        float f7 = f5 * PartyMarkerRenderer.uhb(f3) * (1.0f + 0.1f * f4);
        float f8 = (1.0f - f6) * -6.0f - f4 * 1.5f;
        Icon vhz2 = ubj2.danger() ? Icon.MARK_ALERT : Icon.MARK;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f2);
        PartyMarkerRenderer.ugx(class_3322, n, ubj2.danger(), f3, f5);
        DrawUtil.shadow(class_3322, -3.0f * f5, -1.0f * f5, 6.0f * f5, 2.0f * f5, 1.0f * f5, 2.5f * f5, 0x46000000);
        class_3322.method_51448().translate(0.0f, f8);
        class_3322.method_51448().scale(f7, f7);
        if (ubj2.danger()) {
            PartyMarkerRenderer.ugy(class_3322, n, 0.0f, -11.916666f, 6.6000004f, f3);
        }
        WaypointRenderer.pin(class_3322, vhz2, 0.0f, -9.166666f, 22.0f, n, 0.85f + 0.15f * f4);
        class_3322.method_51448().popMatrix();
        PartyMarkerRenderer.ugz(class_3322, ubj2, f, f2 + f8 - 18.333332f * f7 - 2.0f, d, f4);
    }

    private static void ugw(class_332 class_3322, ubj ubj2, float f, float f2, double d, float f3, float f4) {
        int n = ubj2.color | 0xFF000000;
        float f5 = Easing.outCubic(Math.min(1.0f, f3 / 0.4f));
        float f6 = PartyMarkerRenderer.ugu(d) * (1.0f + 0.1f * f4);
        float f7 = 15.0f * (1.0f + 0.8f * (1.0f - f5));
        float f8 = f2 - 7.5f * f6 - 1.5f;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f8);
        class_3322.method_51448().scale(f6, f6);
        if (ubj2.danger()) {
            PartyMarkerRenderer.ugy(class_3322, n, 0.0f, 0.0f, 7.5f, f3);
        }
        float f9 = f7 * 0.5f;
        DrawUtil.shadow(class_3322, -f9, -f9, f9 * 2.0f, f9 * 2.0f, f9, f7 * 0.55f, ColorUtil.withAlpha(n, Math.round(110.0f + 40.0f * f4)));
        class_3322.method_51448().rotate((1.0f - f5) * (float)Math.PI * 0.5f);
        IconRenderer.draw(class_3322, Icon.MARK_TARGET, 0.0f, Math.max(0.5f, f7 * 0.04f), f7, 0x55000000);
        IconRenderer.draw(class_3322, Icon.MARK_TARGET, 0.0f, 0.0f, f7, n);
        class_3322.method_51448().popMatrix();
        PartyMarkerRenderer.ugz(class_3322, ubj2, f, f8 - 7.5f * f6 - 2.5f, d, f4);
    }

    private static void ugx(class_332 class_3322, int n, boolean bl, float f, float f2) {
        float f3 = bl ? 1.0f : 1.2f;
        for (int i = 0; i < 2; ++i) {
            float f4 = f - (float)i * f3 * 0.5f;
            if (f4 < 0.0f || !bl && f4 >= f3) continue;
            float f5 = f4 % f3 / f3;
            float f6 = (2.0f + 13.0f * Easing.outCubic(f5)) * f2;
            int n2 = Math.round(190.0f * (1.0f - f5) * (1.0f - f5));
            if (n2 < 3) continue;
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().scale(1.0f, 0.36f);
            DrawUtil.circleOutline(class_3322, 0.0f, 0.0f, f6, 2.4f, ColorUtil.withAlpha(n, n2));
            class_3322.method_51448().popMatrix();
        }
    }

    private static void ugy(class_332 class_3322, int n, float f, float f2, float f3, float f4) {
        float f5 = 0.9f;
        for (int i = 0; i < 2; ++i) {
            float f6 = f4 - (float)i * f5 * 0.5f;
            if (f6 < 0.0f) continue;
            float f7 = f6 % f5 / f5;
            float f8 = f3 * (1.0f + 0.9f * Easing.outCubic(f7));
            int n2 = Math.round(150.0f * (1.0f - f7) * (1.0f - f7));
            if (n2 <= 2) continue;
            DrawUtil.circleOutline(class_3322, f, f2, f8, 1.1f, ColorUtil.withAlpha(n, n2));
        }
    }

    private static void ugz(class_332 class_3322, ubj ubj2, float f, float f2, double d, float f3) {
        String string = ubj2.mine ? Lang.s("You", "Вы") : NameProtect.protect(ubj2.name);
        String string2 = NameProtect.protect(ubj2.target);
        String string3 = WaypointRenderer.formatDistance(d);
        float f4 = ugh.width(string);
        float f5 = string2 != null ? 10.0f : 0.0f;
        float f6 = string2 != null ? ugh.width(string2) : 0.0f;
        float f7 = ugi.width(string3);
        float f8 = f4 + f5 + f6 + 4.5f + f7;
        float f9 = f2 - 3.5f;
        DrawUtil.shadow(class_3322, f - f8 * 0.5f - 2.0f, f9 - 4.0f, f8 + 4.0f, 8.0f, 4.0f, 7.0f, ColorUtil.withAlpha(-16777216, Math.round(64.0f + 16.0f * f3)));
        float f10 = f - f8 * 0.5f;
        int n = ubj2.color | 0xFF000000;
        f10 = ugh.draw(class_3322, string, f10, ugh.centerTop(f9), ColorUtil.lerp(n, -1, 0.35f));
        if (string2 != null) {
            IconRenderer.draw(class_3322, Icon.CHEVRON_RIGHT, f10 + f5 * 0.5f, f9, 6.5f, ColorUtil.withAlpha(-1, 170));
            f10 = ugh.draw(class_3322, string2, f10 + f5, ugh.centerTop(f9), -592136);
        }
        ugi.draw(class_3322, string3, f10 + 4.5f, ugi.centerTop(f9), ColorUtil.withAlpha(-1, Math.round(150.0f + 50.0f * f3)));
    }

    private static void uha(class_332 class_3322, ubj ubj2, float f, float f2, float f3, float f4, double d, float f5) {
        int n = ubj2.color | 0xFF000000;
        float f6 = PartyMarkerRenderer.uhb(f5);
        float f7 = 6.2999997f * f6;
        if (ubj2.danger()) {
            PartyMarkerRenderer.ugy(class_3322, n, f, f2, f7 * 1.1f, f5);
        }
        float f8 = (float)Math.atan2(f4, f3) + 1.5707964f;
        float f9 = 0.8f + 0.8f * (float)Math.sin((double)f5 * 5.0);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f + f3 * (f7 + 4.5f + f9), f2 + f4 * (f7 + 4.5f + f9));
        class_3322.method_51448().rotate(f8);
        IconRenderer.draw(class_3322, Icon.NAV, 0.0f, 0.6f, 7.5f * f6, 0x55000000);
        IconRenderer.draw(class_3322, Icon.NAV, 0.0f, 0.0f, 7.5f * f6, n);
        class_3322.method_51448().popMatrix();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f2);
        class_3322.method_51448().scale(f6, f6);
        if (ubj2.target != null) {
            float f10 = 7.5f;
            DrawUtil.shadow(class_3322, -f10, -f10, f10 * 2.0f, f10 * 2.0f, f10, 8.25f, ColorUtil.withAlpha(n, 110));
            IconRenderer.draw(class_3322, Icon.MARK_TARGET, 0.0f, 0.6f, 15.0f, 0x55000000);
            IconRenderer.draw(class_3322, Icon.MARK_TARGET, 0.0f, 0.0f, 15.0f, n);
        } else {
            WaypointRenderer.pin(class_3322, ubj2.danger() ? Icon.MARK_ALERT : Icon.MARK, 0.0f, 1.875f, 15.0f, n, 1.0f);
        }
        class_3322.method_51448().popMatrix();
        String string = WaypointRenderer.formatDistance(d);
        float f11 = ugi.width(string);
        float f12 = f2 - f4 * (f7 + 7.0f);
        float f13 = f - f3 * (f7 + 4.0f + f11 * 0.5f * Math.abs(f3));
        DrawUtil.shadow(class_3322, f13 - f11 * 0.5f - 1.5f, f12 - 3.5f, f11 + 3.0f, 7.0f, 3.5f, 5.0f, 0x50000000);
        ugi.drawCentered(class_3322, string, f13, ugi.centerTop(f12), -419430401);
    }

    private static float uhb(float f) {
        if (f >= 0.45f) {
            return 1.0f;
        }
        float f2 = f / 0.45f;
        return 0.5f + 0.5f * Easing.outBack(f2);
    }

    private static /* synthetic */ int cwk(int n, int n2) {
        return n ^ n2 | 0xF2702F89;
    }
}

