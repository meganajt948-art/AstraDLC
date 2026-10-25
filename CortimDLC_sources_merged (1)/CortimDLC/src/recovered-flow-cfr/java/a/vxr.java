/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 */
package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.fabricmc.loader.api.FabricLoader;

public final class vxr {
    private static /* synthetic */ String vxs;
    private static /* synthetic */ long vxt;

    private vxr() {
    }

    public static Field find(Class<?> clazz, String string, String string2, String string3) {
        try {
            String string4 = FabricLoader.getInstance().getMappingResolver().mapFieldName(a.c(1271827241, "\u8b4c\uf2fa\u7833\ue653\u6d93\ueb3d\u5166\ud896\u46c4\ucc7d\u4bbd\ub1c7"), string, string2, string3);
            Field field = clazz.getDeclaredField(string4);
            field.setAccessible(true);
            return field;
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            System.out.println(a.d("\uc9fc\ub042\u3a9d\ua4e5\u2f3a\ua9cf", 1053468618, 1264086614) + string + a.c(224835632, "\ub81f") + string2 + a.d("\u68fd\u1102\u9bd0\u05ba\u8e39\u08ce\ub294\u3b7f\ua53b\u2f80\ua80d\u5266", -540182987, 1040260836) + exception);
            return null;
        }
    }

    public static int getInt(Field field, Object object, int n) {
        if (field == null) {
            return n;
        }
        try {
            return field.getInt(object);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return n;
        }
    }

    public static float getFloat(Field field, Object object, float f) {
        if (field == null) {
            return f;
        }
        try {
            return field.getFloat(object);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return f;
        }
    }

    public static boolean getBoolean(Field field, Object object, boolean bl) {
        if (field == null) {
            return bl;
        }
        try {
            return field.getBoolean(object);
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return bl;
        }
    }

    public static boolean setFloat(Field field, Object object, float f) {
        if (field == null) {
            return false;
        }
        try {
            field.setFloat(object, f);
            return true;
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return false;
        }
    }

    public static boolean setInt(Field field, Object object, int n) {
        if (field == null) {
            return false;
        }
        try {
            field.setInt(object, n);
            return true;
        }
        catch (IllegalAccessException | RuntimeException exception) {
            return false;
        }
    }

    private static /* synthetic */ int dlw(int n, int n2) {
        return n - n2 + -528329490;
    }

    private static /* synthetic */ int dlx(int n, int n2) {
        return n * n2 ^ 0x92010850;
    }

    private static /* synthetic */ int dly(int n, int n2) {
        return vxr.dlw(n, n2) + n;
    }
}

