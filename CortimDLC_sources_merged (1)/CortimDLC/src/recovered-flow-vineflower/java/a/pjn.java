package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;

public final class pjn {
   static final Pattern pjo = Pattern.compile(a.d("蜒ﻗ琼\uea02懗", -528009649, -1113018000));
   static Field pjp;
   static boolean pjq;

   pjn() {
   }

   public static Field field() {
      if (!pjq) {
         pjq = true;

         for (Field var3 : BossBarHud.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var3.getModifiers()) && Map.class.isAssignableFrom(var3.getType())) {
               var3.setAccessible(true);
               pjp = var3;
               break;
            }
         }
      }

      return pjp;
   }

   public static Map<UUID, ClientBossBar> of(MinecraftClient var0) {
      Field var1 = field();
      if (var1 != null && var0.inGameHud != null) {
         try {
            return var1.get(var0.inGameHud.getBossBarHud()) instanceof Map var3 ? var3 : Collections.emptyMap();
         } catch (ReflectiveOperationException | RuntimeException var4) {
            return Collections.emptyMap();
         }
      } else {
         return Collections.emptyMap();
      }
   }

   public static boolean contains(MinecraftClient var0, String var1) {
      for (ClientBossBar var3 : of(var0).values()) {
         if (var3.getName().getString().contains(var1)) {
            return true;
         }
      }

      return false;
   }

   public static int teleportSeconds(MinecraftClient var0, String var1) {
      for (ClientBossBar var3 : of(var0).values()) {
         String var4 = var3.getName().getString();
         if (var4.contains(var1)) {
            Matcher var5 = pjo.matcher(var4);
            if (var5.find()) {
               try {
                  return Integer.parseInt(var5.group(1));
               } catch (NumberFormatException var7) {
               }
            }

            return 5;
         }
      }

      return -1;
   }
}
