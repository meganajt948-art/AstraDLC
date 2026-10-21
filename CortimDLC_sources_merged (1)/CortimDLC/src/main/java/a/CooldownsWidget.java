/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1796
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 */
package a;

import a.Theme;
import a.izb;
import a.Hud;
import a.TimedWidget;
import a.DrawUtil;
import a.Icon;
import a.FormatUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1796;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_746;
import net.minecraft.class_7923;

public final class CooldownsWidget
extends TimedWidget<izb> {
    private static Method izk;
    private static Method izl;
    private static final float izm = 15.0f;
    private static final float izn = 10.0f;
    private static final float izo = 64.0f;
    private static Field izp;
    private static Field izq;
    private static boolean izr;
    private static /* synthetic */ boolean izs;
    private static /* synthetic */ boolean izt;

    CooldownsWidget() {
        super("cooldowns", "Cooldowns", Icon.CLOCK, true, 2, 2, 6.0f, 6.0f);
    }

    @Override
    List<izb> items(boolean bl) {
        ArrayList<izb> arrayList;
        block4: {
            arrayList = new ArrayList<izb>();
            class_310 class_3102 = class_310.method_1551();
            class_746 class_7462 = class_3102.field_1724;
            if (class_7462 != null) {
                try {
                    CooldownsWidget.izv(class_7462, class_3102.method_61966().method_60637(true), arrayList);
                }
                catch (Throwable throwable) {
                    if (izr) break block4;
                    izr = true;
                    System.out.println("cooldowns unavailable: " + throwable);
                }
            }
        }
        if (arrayList.isEmpty() && bl) {
            arrayList.add(CooldownsWidget.izu(class_1802.field_8634, 0.8f, 0.8f));
            arrayList.add(CooldownsWidget.izu(class_1802.field_49098, 0.3f, 0.6f));
        }
        arrayList.sort(Comparator.comparing(izb2 -> -izb2.izf));
        return arrayList;
    }

    private static izb izu(class_1792 class_17922, float f, float f2) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        return new izb("preview:" + class_7923.field_41178.method_10221((Object)class_17922), class_17992, CooldownsWidget.shortName(class_17992, class_7923.field_41178.method_10221((Object)class_17922)), System.nanoTime() + (long)(f * 1.0E9f), f / f2);
    }

    private static void izv(class_746 class_7462, float f, List<izb> list) throws Exception {
        int n;
        Object object;
        if (izr) {
            return;
        }
        class_1796 class_17962 = class_7462.method_7357();
        if (izp == null) {
            object = class_1796.class.getDeclaredFields();
            n = ((Field[])object).length;
            for (int i = 0; i < n; ++i) {
                Object object2 = object[i];
                if (Modifier.isStatic(((Field)object2).getModifiers())) continue;
                if (Map.class.isAssignableFrom(((Field)object2).getType())) {
                    izp = object2;
                    continue;
                }
                if (((Field)object2).getType() != Integer.TYPE) continue;
                izq = object2;
            }
            if (izp == null || izq == null) {
                throw new IllegalStateException("cooldown fields not found");
            }
            izp.setAccessible(true);
            izq.setAccessible(true);
        }
        if ((object = (Map)izp.get(class_17962)).isEmpty()) {
            return;
        }
        n = izq.getInt(class_17962);
        class_1661 class_16612 = class_7462.method_31548();
        long l = System.nanoTime();
        for (Map.Entry entry : object.entrySet()) {
            Object object3 = entry.getKey();
            if (!(object3 instanceof class_2960)) continue;
            class_2960 class_29602 = (class_2960)object3;
            if (entry.getValue() == null) continue;
            if (izk == null) {
                object3 = entry.getValue().getClass().getRecordComponents();
                if (object3 == null || ((K)object3).length < 2) continue;
                izk = ((RecordComponent)object3[0]).getAccessor();
                izl = ((RecordComponent)object3[1]).getAccessor();
                izk.setAccessible(true);
                izl.setAccessible(true);
            }
            int n2 = (Integer)izk.invoke(entry.getValue(), new Object[0]);
            int n3 = (Integer)izl.invoke(entry.getValue(), new Object[0]);
            float f2 = (float)Math.max(1, n3 - n2) / 20.0f;
            float f3 = ((float)n3 - ((float)n + f)) / 20.0f;
            if (f3 <= 0.0f) continue;
            class_1799 class_17992 = CooldownsWidget.izw(class_17962, class_16612, class_29602);
            list.add(new izb(class_29602.toString(), class_17992, CooldownsWidget.shortName(class_17992, class_29602), l + (long)(f3 * 1.0E9f), f2));
        }
    }

    static String shortName(class_1799 class_17992, class_2960 class_29602) {
        class_1792 class_17922;
        class_1792 class_17923 = class_17922 = class_17992.method_7960() ? (class_1792)class_7923.field_41178.method_63535(class_29602) : class_17992.method_7909();
        if (class_17922 == class_1802.field_8367) {
            return Lang.s("God apple", "Чарка");
        }
        if (class_17922 == class_1802.field_8463) {
            return Lang.s("Gapple", "Гэпл");
        }
        if (class_17922 == class_1802.field_8634) {
            return Lang.s("Pearl", "Жемчуг");
        }
        if (class_17922 == class_1802.field_8233) {
            return Lang.s("Chorus", "Хорус");
        }
        if (class_17922 == class_1802.field_49098) {
            return Lang.s("Wind charge", "Заряд ветра");
        }
        if (class_17922 == class_1802.field_8288) {
            return Lang.s("Totem", "Тотем");
        }
        if (class_17922 == class_1802.field_8287) {
            return Lang.s("XP bottle", "Пузырёк опыта");
        }
        String string = class_17922 == class_1802.field_8162 ? class_29602.method_12832().replace('_', ' ') : class_17922.method_63680().getString();
        return string.isEmpty() ? class_29602.method_12832() : string;
    }

    private static class_1799 izw(class_1796 class_17962, class_1661 class_16612, class_2960 class_29602) {
        for (int i = 0; i < class_16612.method_5439(); ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || !class_29602.equals((Object)class_17962.method_62836(class_17992))) continue;
            return new class_1799((class_1935)class_17992.method_7909());
        }
        class_1792 class_17922 = (class_1792)class_7923.field_41178.method_63535(class_29602);
        return class_17922 == class_1802.field_8162 ? class_1799.field_8037 : new class_1799((class_1935)class_17922);
    }

    static String seconds(float f) {
        return f >= 60.0f ? FormatUtil.clock((int)f) : FormatUtil.fixed(f, 1) + Lang.unit("s");
    }

    @Override
    String key(izb izb2) {
        return izb2.izc;
    }

    @Override
    float rowHeight() {
        return 15.0f;
    }

    @Override
    float rowWidth(izb izb2) {
        return 14.0f + Math.min(64.0f, Hud.TEXT.width(izb2.ize)) + 12.0f + Hud.VALUE.width("00.0s");
    }

    @Override
    void drawRow(class_332 class_3322, izb izb2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8 = f2 + 6.0f;
        if (!izb2.izd.method_7960()) {
            f7 = 0.625f * f5;
            DrawUtil.pushScissor(class_3322, f - 1.0f, f8 - 5.0f - 1.0f, 12.0f, 12.0f);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f + 5.0f, f8);
            class_3322.method_51448().scale(f7, f7);
            class_3322.method_51427(izb2.izd, -8, -8);
            class_3322.method_51448().popMatrix();
            DrawUtil.popScissor(class_3322);
        }
        f7 = f + 10.0f + 4.0f;
        String string = CooldownsWidget.seconds(izb2.seconds());
        float f9 = Hud.VALUE.width(string);
        Hud.TEXT.draw(class_3322, Hud.TEXT.ellipsize(izb2.ize, f3 - (f7 - f) - f9 - 8.0f), f7, Hud.TEXT.centerTop(f8), Theme.text);
        Hud.VALUE.drawRight(class_3322, string, f + f3, Hud.VALUE.centerTop(f8), Theme.textDim);
        CooldownsWidget.bar(class_3322, f7, f2 + f4 - 3.6f, f3 - (f7 - f), izb2.fraction(), Theme.accent(), Theme.accent2());
    }

    private static /* synthetic */ int ald(int n, int n2) {
        return n - n2 | 0x38F440A5;
    }
}

