package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.jspecify.annotations.Nullable;

public final class unm {
   private static uok unn;
   private static boolean uno;

   private unm() {
   }

   public static @Nullable GpuTextureView view() {
      if (unn == null && !uno) {
         try (InputStream var0 = unm.class.getResourceAsStream("/flow/glow.png")) {
            BufferedImage var1 = var0 == null ? null : ImageIO.read(var0);
            if (var1 == null) {
               throw new IllegalStateException("missing /flow/glow.png");
            }

            unn = uok.upload("glow", var1, false, true);
         } catch (Throwable var5) {
            uno = true;
            System.out.println("glow sprite unavailable: " + var5);
         }
      }

      return unn != null ? unn.view : null;
   }
}
