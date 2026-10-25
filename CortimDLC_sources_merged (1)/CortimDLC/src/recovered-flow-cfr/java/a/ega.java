/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class ega {
    private static final Field[] egb = ega.ege();
    private static /* synthetic */ boolean egc;
    private static /* synthetic */ boolean egd;

    private ega() {
    }

    private static Field[] ege() {
        try {
            Class<?> clazz = Class.forName(a.d("\u81c3\uf879\u72bb\uec90\u670f\ue1b9\u5be9\ud208\u4c4c\uc6f7\u412a\ubb55\u35cf\uac36\u2662\ua090\u1acf\u9505\u0fbc\u89a0\u0010\u7a45\uf4eb\u6f26\ue91b\u638a\uda32\u5472\uce86\u48cf\uc361\u3da9\ub7e4\u2e12\ua848\u22b0\u9d2a\u1754\u9182\u083f\u826b\ufc80\u7689\uf155\u6bad\ue5d9\u5c06\ud6bc\u50e9\ucb02\u455a\ubf9a\u362e\ub067\u2a89\ua4c1\u1f7c\u99aa\u13d0\u8a2f\u04bc\u7ef0\uf91f", -1436003265, -561130067));
            ArrayList<Field> arrayList = new ArrayList<Field>();
            for (Field field : clazz.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()) || !field.getType().getSimpleName().contains(a.d("\u3ed6\u4742\ucd91\u53eb\ud83d", -364889635, 1127417679))) continue;
                field.setAccessible(true);
                arrayList.add(field);
            }
            return arrayList.toArray(new Field[0]);
        }
        catch (Throwable throwable) {
            return new Field[0];
        }
    }

    static Object[] saveAddons() {
        if (egb.length == 0) {
            return null;
        }
        Object[] objectArray = new Object[egb.length];
        try {
            for (int i = 0; i < egb.length; ++i) {
                objectArray[i] = egb[i].get(null);
            }
            return objectArray;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static void restoreAddons(Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        for (int i = 0; i < egb.length && i < objectArray.length; ++i) {
            try {
                egb[i].set(null, objectArray[i]);
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static void clearConfiguration() {
        for (Field field : egb) {
            if (!field.getType().getSimpleName().contains(a.b("\u4a45\u33d8\ub90a\u2773\uacab\u2a14\u9055\u19a3\u87ef\u0d4b\u8a85\u70f2\ufe24", 849168907))) continue;
            try {
                field.set(null, null);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static Object[] created(Object[] objectArray, Object[] objectArray2) {
        Object[] objectArray3 = ega.saveAddons();
        if (objectArray3 == null) {
            return objectArray2;
        }
        Object[] objectArray4 = new Object[objectArray3.length];
        for (int i = 0; i < objectArray3.length; ++i) {
            boolean bl;
            boolean bl2 = bl = objectArray == null || i >= objectArray.length || objectArray3[i] != objectArray[i];
            objectArray4[i] = bl ? objectArray3[i] : (objectArray2 == null || i >= objectArray2.length ? null : objectArray2[i]);
        }
        return objectArray4;
    }

    private static /* synthetic */ int do(int n, int n2) {
        return n ^ n2 | 0x5A776E5D;
    }

    private static /* synthetic */ int dp(int n, int n2) {
        return ega.do(n, n2) ^ 0x87A766D2;
    }
}

