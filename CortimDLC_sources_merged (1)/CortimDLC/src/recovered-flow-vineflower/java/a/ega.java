package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class ega {
   static final Field[] egb = ege();

   ega() {
   }

   static Field[] ege() {
      try {
         Class var0 = Class.forName(
            a.d(
               "臃\uf879犻\uec90朏\ue1b9審툈䱌웷䄪뭕㗏갶♢ꂐ\u1acf锅ྼ覠\u0010穅\uf4eb漦\ue91b掊\uda32呲캆䣏썡㶩럤⸒ꡈ⊰鴪\u1754醂\u083f艫ﲀ皉\uf155殭\ue5d9将횼僩쬂䕚뾚㘮끧⪉꓁ὼ馪Ꮠ訯Ҽ绰蘭",
               -1436003265,
               -561130067
            )
         );
         ArrayList<Field> var1 = new ArrayList<>();

         for (Field var5 : var0.getDeclaredFields()) {
            if (Modifier.isStatic(var5.getModifiers())
               && !Modifier.isFinal(var5.getModifiers())
               && var5.getType().getSimpleName().contains(a.d("㻖䝂춑叫\ud83d", -364889635, 1127417679))) {
               var5.setAccessible(true);
               var1.add(var5);
            }
         }

         return var1.toArray(new Field[0]);
      } catch (Throwable var6) {
         return new Field[0];
      }
   }

   static Object[] saveAddons() {
      if (egb.length == 0) {
         return null;
      }

      Object[] var0 = new Object[egb.length];

      try {
         for (int var1 = 0; var1 < egb.length; var1++) {
            var0[var1] = egb[var1].get(null);
         }

         return var0;
      } catch (Throwable var2) {
         return null;
      }
   }

   static void restoreAddons(Object[] var0) {
      if (var0 != null) {
         for (int var1 = 0; var1 < egb.length && var1 < var0.length; var1++) {
            try {
               egb[var1].set(null, var0[var1]);
            } catch (Throwable var3) {
            }
         }
      }
   }

   static void clearConfiguration() {
      for (Field var3 : egb) {
         if (var3.getType().getSimpleName().contains(a.b("䩅㏘뤊❳겫⨔違ᦣ蟯ോ誅烲︤", 849168907))) {
            try {
               var3.set(null, null);
            } catch (Throwable var5) {
            }
         }
      }
   }

   static Object[] created(Object[] var0, Object[] var1) {
      Object[] var2 = saveAddons();
      if (var2 == null) {
         return var1;
      }

      Object[] var3 = new Object[var2.length];

      for (int var4 = 0; var4 < var2.length; var4++) {
         boolean var5 = var0 == null || var4 >= var0.length || var2[var4] != var0[var4];
         var3[var4] = var5 ? var2[var4] : (var1 != null && var4 < var1.length ? var1[var4] : null);
      }

      return var3;
   }
}
