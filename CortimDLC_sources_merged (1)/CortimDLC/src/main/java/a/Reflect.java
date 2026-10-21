/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 */
package a;

import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.fabricmc.loader.api.FabricLoader;

public final class Reflect {
    private static /* synthetic */ String vxs;
    private static /* synthetic */ long vxt;

    private Reflect() {
    }

    public static Field find(Class<?> clazz, String string, String string2, String string3) {
        try {
            String string4 = FabricLoader.getInstance().getMappingResolver().mapFieldName("intermediary", string, string2, string3);
            Field field = clazz.getDeclaredField(string4);
            field.setAccessible(true);
            return field;
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            System.out.println("field " + string + "." + string2 + " not found: " + exception);
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
        return Reflect.dlw(n, n2) + n;
    }
}

