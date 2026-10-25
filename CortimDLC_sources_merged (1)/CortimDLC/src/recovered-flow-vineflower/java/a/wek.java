package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

public final class wek {
   private static GLFWKeyCallback wel;
   private static GLFWKeyCallbackI wem;
   private static long wen;
   private static Boolean weo;

   private wek() {
   }

   public static void tick(MinecraftClient var0) {
      wer(var0);
      if (var0.field_1690 != null) {
         if (weo == null) {
            weo = var0.field_1690.field_1837;
         }

         var0.field_1690.field_1837 = false;
      }
   }

   public static void shutdown(MinecraftClient var0) {
      if (weo != null && var0.field_1690 != null && weo != var0.field_1690.field_1837) {
         var0.field_1690.field_1837 = weo;

         try {
            var0.field_1690.method_1640();
         } catch (Throwable var2) {
            System.out.println(a.b("륮생䨁퐹徽\ud958捌\ueab3瓳﹑秇菹റ钄Ị頽≳궿㝑녚㢡䋼찛垃퇡嬷\ue2d7泖\uf630灵﯀ԇ輀ᚳ郡ᨓꖏ⿷ꤨわ뫖쑴乥짗匂\udd7b擹\uee52", -401295043) + var2);
         }
      }
   }

   private static void wer(MinecraftClient var0) {
      if (var0.method_22683() != null) {
         long var1 = var0.method_22683().method_4490();
         if (var1 != 0L && wen != var1) {
            wen = var1;

            try {
               if (wel == null) {
                  wel = GLFWKeyCallback.create(wek::wes);
               }

               wem = GLFW.glfwSetKeyCallback(var1, wel);
            } catch (Throwable var4) {
               System.out.println(a.d("䂿㤌돐ⷨꙬ₉骎፪贿ހ耖稄\uf4e4浓\ue71e憨\udb8e吽컈䢍셧무㗊깏⠬ꋰᬆ错\u0fe1覣Ȑﳒ皈\uef62椬\ue3d5尘", -1126015439, 379657928) + var4);
            }
         }
      }
   }

   private static void wes(long var0, int var2, int var3, int var4, int var5) {
      if (var2 == 66) {
         var5 &= -11;
      }

      if (wem != null) {
         wem.invoke(var0, var2, var3, var4, var5);
      }
   }
}
