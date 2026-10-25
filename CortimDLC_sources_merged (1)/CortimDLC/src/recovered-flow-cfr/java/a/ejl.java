/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

final class ejl {
    static final Unsafe U = ejl.ejo();
    private static /* synthetic */ boolean ejm;
    private static /* synthetic */ boolean ejn;

    private ejl() {
    }

    private static Unsafe ejo() {
        try {
            Field field = Unsafe.class.getDeclaredField(a.d("\ua4b9\udd14\u57ca\uc98b\u4267\uc4cb\u7e8a\uf77c\u6920", -387863115, 483002737));
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        }
        catch (Throwable throwable) {
            throw new IllegalStateException(throwable);
        }
    }

    static long offset(Class<?> clazz, Class<?> clazz2, int n) {
        int n2 = 0;
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || field.getType() != clazz2 || n2++ != n) continue;
            return U.objectFieldOffset(field);
        }
        throw new IllegalStateException(clazz.getSimpleName() + a.d("\u4d93", 1411581836, -948483523) + clazz2.getSimpleName());
    }

    static long offset(Class<?> clazz, Class<?> clazz2) {
        return ejl.offset(clazz, clazz2, 0);
    }

    static long offsetOf(Object object, Object object2) {
        if (object != null && object2 != null) {
            for (Class<?> clazz = object.getClass(); clazz != null && clazz != Object.class; clazz = clazz.getSuperclass()) {
                for (Field field : clazz.getDeclaredFields()) {
                    long l;
                    if (Modifier.isStatic(field.getModifiers()) || field.getType().isPrimitive() || !field.getType().isInstance(object2) || U.getObject(object, l = U.objectFieldOffset(field)) != object2) continue;
                    return l;
                }
            }
        }
        throw new IllegalStateException((object == null ? a.b("\u4936\u309c\uba56\u2427", 2039826780) : object.getClass().getSimpleName()) + a.d("\u67c0", 2059528514, -82145632) + (object2 == null ? a.d("\u8f36\uf69c\u7c56\ue227", 688572255, -1707456509) : object2.getClass().getSimpleName()));
    }

    static Object get(Object object, long l) {
        return U.getObject(object, l);
    }

    static void put(Object object, long l, Object object2) {
        U.putObject(object, l, object2);
    }

    static <T> T allocate(Class<T> clazz) {
        try {
            return (T)U.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new IllegalStateException(instantiationException);
        }
    }

    private static /* synthetic */ int fb(int n, int n2) {
        return n * n2 ^ 0x1809C3ED;
    }

    private static /* synthetic */ int fc(int n, int n2) {
        return n + n2 | 0x2316E446;
    }

    private static /* synthetic */ int fd(int n, int n2) {
        return n * n2 + 952543136;
    }
}

