package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.fabricmc.loader.api.FabricLoader;

public final class vxr {
   private vxr() {
   }

   public static Field find(Class<?> var0, String var1, String var2, String var3) {
      try {
         String var4 = FabricLoader.getInstance().getMappingResolver().mapFieldName(a.c(1271827241, "譌\uf2fa砳\ue653涓\ueb3d兦\ud896䛄챽䮽뇇"), var1, var2, var3);
         Field var5 = var0.getDeclaredField(var4);
         var5.setAccessible(true);
         return var5;
      } catch (ReflectiveOperationException | RuntimeException var6) {
         System.out.println(a.d("짼끂㪝ꓥ⼺ꧏ", 1053468618, 1264086614) + var1 + a.c(224835632, "렟") + var2 + a.d("棽ᄂ鯐ֺ踹࣎는㭿ꔻ⾀ꠍ剦", -540182987, 1040260836) + var6);
         return null;
      }
   }

   public static int getInt(Field var0, Object var1, int var2) {
      if (var0 == null) {
         return var2;
      }

      try {
         return var0.getInt(var1);
      } catch (IllegalAccessException | RuntimeException var4) {
         return var2;
      }
   }

   public static float getFloat(Field var0, Object var1, float var2) {
      if (var0 == null) {
         return var2;
      }

      try {
         return var0.getFloat(var1);
      } catch (IllegalAccessException | RuntimeException var4) {
         return var2;
      }
   }

   public static boolean getBoolean(Field var0, Object var1, boolean var2) {
      if (var0 == null) {
         return var2;
      }

      try {
         return var0.getBoolean(var1);
      } catch (IllegalAccessException | RuntimeException var4) {
         return var2;
      }
   }

   public static boolean setFloat(Field var0, Object var1, float var2) {
      if (var0 == null) {
         return false;
      }

      try {
         var0.setFloat(var1, var2);
         return true;
      } catch (IllegalAccessException | RuntimeException var4) {
         return false;
      }
   }

   public static boolean setInt(Field var0, Object var1, int var2) {
      if (var0 == null) {
         return false;
      }

      try {
         var0.setInt(var1, var2);
         return true;
      } catch (IllegalAccessException | RuntimeException var4) {
         return false;
      }
   }
}
