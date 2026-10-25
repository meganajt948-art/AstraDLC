package a;

import java.util.function.IntPredicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.util.InputUtil.Type;
import org.lwjgl.glfw.GLFW;

public final class vzz {
   private static final int waa = -100;
   private static final int wab = 8;
   private static final int wac = 16;
   private static final int wad = 7;
   public static volatile IntPredicate simulated;

   private vzz() {
   }

   public static int mouse(int var0) {
      return -100 - var0;
   }

   public static boolean isMouse(int var0) {
      return var0 <= -100 && var0 > -108;
   }

   public static int mouseButton(int var0) {
      return -100 - var0;
   }

   public static int combo(int var0, int var1) {
      var1 &= 7;
      return var0 > 0 && var1 != 0 && !isModifier(var0) ? var0 | var1 << 16 : var0;
   }

   public static int baseKey(int var0) {
      return var0 > 0 ? var0 & 65535 : var0;
   }

   public static int mods(int var0) {
      return var0 > 0 ? var0 >>> 16 & 7 : 0;
   }

   public static boolean isModifier(int var0) {
      return var0 == 340 || var0 == 344 || var0 == 341 || var0 == 345 || var0 == 342 || var0 == 346;
   }

   public static boolean isDown(MinecraftClient var0, int var1) {
      if (var1 == -1 || var0.method_22683() == null) {
         return false;
      } else if (isMouse(var1)) {
         return GLFW.glfwGetMouseButton(var0.method_22683().method_4490(), mouseButton(var1)) == 1;
      } else {
         int var2 = mods(var1);
         if (((var2 & 1) == 0 || wag(var0, 340, 344)) && ((var2 & 2) == 0 || wag(var0, 341, 345)) && ((var2 & 4) == 0 || wag(var0, 342, 346))) {
            int var3 = baseKey(var1);
            IntPredicate var4 = simulated;
            return var4 != null && var3 > 0 && var4.test(var3) ? true : var3 > 0 && InputUtil.method_15987(var0.method_22683(), var3);
         } else {
            return false;
         }
      }
   }

   public static int heldMods(MinecraftClient var0) {
      return var0.method_22683() == null ? 0 : (wag(var0, 340, 344) ? 1 : 0) | (wag(var0, 341, 345) ? 2 : 0) | (wag(var0, 342, 346) ? 4 : 0);
   }

   private static boolean wag(MinecraftClient var0, int var1, int var2) {
      return InputUtil.method_15987(var0.method_22683(), var1) || InputUtil.method_15987(var0.method_22683(), var2);
   }

   public static boolean isPhysicallyDown(MinecraftClient var0, KeyBinding var1) {
      dtv var2 = ejp.current();
      if (var2 != null) {
         return var2.heldByHuman(var1);
      } else {
         Key var3 = KeyBindingHelper.getBoundKeyOf(var1);
         if (var3.equals(InputUtil.field_16237)) {
            return false;
         } else {
            IntPredicate var4 = simulated;
            if (var4 != null && var3.method_1442() == Type.field_1668 && var4.test(var3.method_1444())) {
               return true;
            } else {
               return var3.method_1442() == Type.field_1672
                  ? GLFW.glfwGetMouseButton(var0.method_22683().method_4490(), var3.method_1444()) == 1
                  : InputUtil.method_15987(var0.method_22683(), var3.method_1444());
            }
         }
      }
   }
}
