package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

final class ejl {
   static final Unsafe U = ejo();

   ejl() {
   }

   static Unsafe ejo() {
      try {
         Field var0 = Unsafe.class.getDeclaredField(a.d("꒹\udd14埊즋䉧쓋纊\uf77c椠", -387863115, 483002737));
         var0.setAccessible(true);
         return (Unsafe)var0.get(null);
      } catch (Throwable var1) {
         throw new IllegalStateException(var1);
      }
   }

   static long offset(Class<?> var0, Class<?> var1, int var2) {
      int var3 = 0;

      for (Field var7 : var0.getDeclaredFields()) {
         if (!Modifier.isStatic(var7.getModifiers()) && var7.getType() == var1 && var3++ == var2) {
            return U.objectFieldOffset(var7);
         }
      }

      throw new IllegalStateException(var0.getSimpleName() + a.d("䶓", 1411581836, -948483523) + var1.getSimpleName());
   }

   static long offset(Class<?> var0, Class<?> var1) {
      return offset(var0, var1, 0);
   }

   static long offsetOf(Object var0, Object var1) {
      if (var0 != null && var1 != null) {
         for (Class var2 = var0.getClass(); var2 != null && var2 != Object.class; var2 = var2.getSuperclass()) {
            for (Field var6 : var2.getDeclaredFields()) {
               if (!Modifier.isStatic(var6.getModifiers()) && !var6.getType().isPrimitive() && var6.getType().isInstance(var1)) {
                  long var7 = U.objectFieldOffset(var6);
                  if (U.getObject(var0, var7) == var1) {
                     return var7;
                  }
               }
            }
         }
      }

      throw new IllegalStateException(
         (var0 == null ? a.b("䤶゜멖\u2427", 2039826780) : var0.getClass().getSimpleName())
            + a.d("柀", 2059528514, -82145632)
            + (var1 == null ? a.d("輶\uf69c籖\ue227", 688572255, -1707456509) : var1.getClass().getSimpleName())
      );
   }

   static Object get(Object var0, long var1) {
      return U.getObject(var0, var1);
   }

   static void put(Object var0, long var1, Object var3) {
      U.putObject(var0, var1, var3);
   }

   static <T> T allocate(Class<T> var0) {
      try {
         return (T)U.allocateInstance(var0);
      } catch (InstantiationException var2) {
         throw new IllegalStateException(var2);
      }
   }
}
