/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_10034
 *  net.minecraft.class_10042
 *  net.minecraft.class_10055
 *  net.minecraft.class_11658
 *  net.minecraft.class_1799
 *  net.minecraft.class_310
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.FxPipeline;
import a.BoolSetting;
import a.NumberSetting;
import flow.cosmetic.Cosmetics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_10017;
import net.minecraft.class_10034;
import net.minecraft.class_10042;
import net.minecraft.class_10055;
import net.minecraft.class_11658;
import net.minecraft.class_1799;
import net.minecraft.class_310;

public class SeeInvisible
extends Module {
    private static SeeInvisible rqw;
    private static final Map<Class<?>, List<Field>> rqx;
    private static final Map<Class<?>, Constructor<?>> rqy;
    private static final Set<class_10017> rqz;
    private static Field rra;
    private static boolean rrb;
    private final NumberSetting rrc = this.add(new NumberSetting("Transparency", 0.5, 0.0, 0.95, 0.05).percent());
    private final BoolSetting rrd = this.add(new BoolSetting("Mobs", false));
    private static /* synthetic */ int rre;
    private static /* synthetic */ String rrf;

    public SeeInvisible() {
        super(new String(new char[]{'S', 'h', 'o', 'w', 'I', 'n', 'v', 'i', 's', 'i', 'b', 'l', 'e'}), "Invisible players show up see-through", ModuleCategory.RENDER);
        rqw = this;
    }

    public static boolean isFadedBody(class_10017 class_100172) {
        return !rqz.isEmpty() && rqz.contains(class_100172);
    }

    /*
     * Unable to fully structure code
     */
    public static void afterExtraction(class_11658 var0) {
        SeeInvisible.rqz.clear();
        var1_1 = SeeInvisible.rqw;
        if (var1_1 == null || !var1_1.isEnabled() || class_310.method_1551().field_1687 == null) {
            return;
        }
        var2_2 = FxPipeline.canFade();
        var3_3 = null;
        for (class_10017 var5_5 : var0.field_61735) {
            if (!(var5_5 instanceof class_10042)) continue;
            var6_6 = (class_10042)var5_5;
            if (!var6_6.field_53461 || !(var5_5 instanceof class_10055) && !var1_1.rrd.get() || Cosmetics.hidesBody(var5_5)) continue;
            var6_6.field_53461 = false;
            if (!var2_2) continue;
            var6_6.field_53333 = false;
            if (!(var5_5 instanceof class_10055)) ** GOTO lbl-1000
            var8_8 = (class_10055)var5_5;
            if (Cosmetics.wears(var8_8.field_53528)) {
                v0 = true;
            } else lbl-1000:
            // 2 sources

            {
                v0 = var7_7 = false;
            }
            if (var5_5 instanceof class_10034) {
                var8_8 = (class_10034)var5_5;
                if ((var7_7 || SeeInvisible.rrg((class_10034)var8_8)) && (var9_9 = SeeInvisible.rrh((class_10034)var8_8)) != null) {
                    if (var3_3 == null) {
                        var3_3 = new ArrayList<class_10034>();
                    }
                    var3_3.add(var9_9);
                    if (var7_7) {
                        SeeInvisible.rqz.add(var5_5);
                    }
                    var8_8.field_55309 = class_1799.field_8037;
                    var8_8.field_53418 = class_1799.field_8037;
                    var8_8.field_53419 = class_1799.field_8037;
                    var8_8.field_53420 = class_1799.field_8037;
                }
            }
            FxPipeline.fade(var5_5, 1.0f - (float)var1_1.rrc.get());
        }
        if (var3_3 != null) {
            var0.field_61735.addAll(var3_3);
        }
    }

    private static boolean rrg(class_10034 class_100342) {
        return !class_100342.field_55309.method_7960() || !class_100342.field_53418.method_7960() || !class_100342.field_53419.method_7960() || !class_100342.field_53420.method_7960();
    }

    private static class_10034 rrh(class_10034 class_100342) {
        if (rrb) {
            return null;
        }
        try {
            Class<?> clazz = class_100342.getClass();
            Constructor<?> constructor = rqy.get(clazz);
            if (constructor == null) {
                constructor = clazz.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                rqy.put(clazz, constructor);
            }
            class_10034 class_100343 = (class_10034)constructor.newInstance(new Object[0]);
            for (Field field : SeeInvisible.rri(clazz)) {
                field.set(class_100343, field.get(class_100342));
            }
            class_100343.field_53333 = true;
            class_100343.field_53461 = true;
            class_100343.field_61821 = 0;
            class_100343.field_53337 = null;
            class_100343.field_53338 = null;
            class_100343.field_60160 = null;
            class_100343.field_61822 = 0.0f;
            if (rra != null) {
                rra.set(class_100343, new ArrayList());
            }
            return class_100343;
        }
        catch (Throwable throwable) {
            rrb = true;
            System.out.println(new String(new char[]{'[', 'F', 'l', 'o', 'w', '2', ']', ' ', 's', 'o', 'l', 'i', 'd', ' ', 'a', 'r', 'm', 'o', 'u', 'r', ' ', 'u', 'n', 'a', 'v', 'a', 'i', 'l', 'a', 'b', 'l', 'e', ':', ' '}) + throwable);
            return null;
        }
    }

    private static List<Field> rri(Class<?> clazz) {
        List<Field> list = rqx.get(clazz);
        if (list != null) {
            return list;
        }
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Class clazz2 = clazz; clazz2 != null && clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            for (Field field : clazz2.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                arrayList.add(field);
                if (clazz2 != class_10017.class || field.getType() != List.class || !field.getName().equals("shadowPieces")) continue;
                rra = field;
            }
        }
        if (rra == null) {
            for (Field field : arrayList) {
                if (field.getDeclaringClass() != class_10017.class || field.getType() != List.class || !Modifier.isFinal(field.getModifiers())) continue;
                rra = field;
            }
        }
        rqx.put(clazz, arrayList);
        return arrayList;
    }

    static {
        rqx = new HashMap();
        rqy = new HashMap();
        rqz = Collections.newSetFromMap(new IdentityHashMap());
    }

    private static /* synthetic */ int cba(int n, int n2) {
        return n * n2 + -43546301;
    }

    private static /* synthetic */ int cbb(int n, int n2) {
        return n * n2 + 1851339594;
    }
}

