package a;

import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;

public class rfa extends kfe {
   static final int rfb = -1291911168;
   final vla rfc = this.add(new vla("Color", "Sakura"));
   final vmc rfd = this.add(new vmc("Strength", 0.45, 0.1, 0.85, 0.05).percent());
   final vkl rfe = this.add(new vkl("Shimmer", true));
   static Field rff;
   static boolean rfg;
   int rfh;

   public rfa() {
      super(new String(new char[]{'H', 'i', 't', 'C', 'o', 'l', 'o', 'r'}), "Your colour instead of the red hit flash", kfa.RENDER);
   }

   @Override
   protected void onDisable() {
      if (this.rfh != 0 && rfk(-1291911168)) {
         this.rfh = 0;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      int var2 = this.rfc.color();
      if (this.rfe.get()) {
         float var3 = (float)(0.5 + 0.5 * Math.sin(System.nanoTime() / 1.0E9 * 1.6));
         var2 = ujt.lerp(var2, this.rfc.color2(), var3 * 0.8F);
      }

      int var5 = Math.round(255.0F * (1.0F - (float)this.rfd.get()));
      int var4 = ujt.withAlpha(var2, var5);
      if (var4 != this.rfh && rfk(var4)) {
         this.rfh = var4;
      }
   }

   static boolean rfk(int var0) {
      if (rfg) {
         return false;
      }

      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.gameRenderer == null) {
         return false;
      }

      try {
         OverlayTexture var2 = var1.gameRenderer.getOverlayTexture();
         if (rff == null) {
            for (Field var6 : OverlayTexture.class.getDeclaredFields()) {
               if (var6.getType() == NativeImageBackedTexture.class) {
                  var6.setAccessible(true);
                  rff = var6;
                  break;
               }
            }

            if (rff == null) {
               throw new IllegalStateException("overlay texture field not found");
            }
         }

         NativeImageBackedTexture var8 = (NativeImageBackedTexture)rff.get(var2);
         NativeImage var9 = var8.getImage();
         if (var9 == null) {
            return false;
         }

         for (int var10 = 0; var10 < 8; var10++) {
            for (int var11 = 0; var11 < 16; var11++) {
               var9.setColorArgb(var11, var10, var0);
            }
         }

         var8.upload();
         return true;
      } catch (Throwable var7) {
         rfg = true;
         System.out.println("hit colour unavailable: " + var7);
         return false;
      }
   }
}
