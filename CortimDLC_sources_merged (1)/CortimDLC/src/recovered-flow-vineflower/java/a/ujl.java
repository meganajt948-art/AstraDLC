package a;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.CloudRenderer;

public final class ujl {
   static final Set<Object> ujm = new HashSet<>();
   static Field ujn;
   static boolean ujo;
   static Object ujp;

   ujl() {
   }

   public static void hide(Object var0, boolean var1) {
      if (var1) {
         ujm.add(var0);
      } else {
         ujm.remove(var0);
      }

      ujs(!ujm.isEmpty());
   }

   static void ujs(boolean var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (!ujo && var1.worldRenderer != null) {
         try {
            CloudRenderer var2 = var1.worldRenderer.getCloudRenderer();
            if (ujn == null) {
               for (Field var6 : CloudRenderer.class.getDeclaredFields()) {
                  if (var6.getType().isRecord() && var6.getType().getEnclosingClass() == CloudRenderer.class) {
                     var6.setAccessible(true);
                     ujn = var6;
                     break;
                  }
               }

               if (ujn == null) {
                  throw new IllegalStateException("cloud cells field not found");
               }
            }

            Object var8 = ujn.get(var2);
            if (var0) {
               if (var8 != null) {
                  ujp = var8;
                  ujn.set(var2, null);
               }
            } else if (ujp != null) {
               if (var8 == null) {
                  ujn.set(var2, ujp);
               }

               ujp = null;
            }
         } catch (Throwable var7) {
            ujo = true;
            System.out.println("can't hide clouds: " + var7);
         }
      }
   }
}
