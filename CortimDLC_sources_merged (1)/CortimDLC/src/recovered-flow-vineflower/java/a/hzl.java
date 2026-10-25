package a;

import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.util.List;
import java.util.function.BooleanSupplier;
import net.minecraft.client.MinecraftClient;

public final class hzl {
   private hzl() {
   }

   public static void steps(List<BooleanSupplier> var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      hzp(irr.class);
      hzp(izx.class);
      float var2 = 1.0F;
      if (var1.getWindow() != null) {
         float var3 = var1.getWindow().getScaledWidth();
         float var4 = var1.getWindow().getScaledHeight();
         float var5 = Math.min((var3 - 16.0F) / 540.0F, (var4 - 16.0F) / 409.0F);
         var2 = Math.max(0.3F, Math.min((float)iov.SCALE.get(), var5));
      }

      float var9 = var2;

      for (vdn var12 : veo.all()) {
         var0.add(() -> hzo(var12, 1.0F));
         if (Math.abs(var9 - 1.0F) > 0.01F) {
            var0.add(() -> hzo(var12, var9));
         }
      }

      String var11 = kbs.selected().key;
      var0.add(() -> jzh.warm(var11));
      var0.add(() -> {
         whl.warm(var11, isv.selected());
         return true;
      });

      for (kbs var8 : kbs.values()) {
         var0.add(() -> jzh.warmThumb(var8.key));
      }

      for (isn var16 : isv.entries()) {
         var0.add(() -> var16.isWorld() || var16.failed || isv.thumbnail(var16) != null);
      }

      for (CosmeticItem var17 : Cosmetics.items()) {
         var0.add(() -> {
            hwr.thumb(var17.id);
            return true;
         });
      }
   }

   private static boolean hzo(vdn var0, float var1) {
      vdn.setRenderScale(var1);

      try {
         var0.width(a.b("咪ⴻꞩ㷗뙠㒾軽", 1876645100));
      } finally {
         vdn.setRenderScale(1.0F);
      }

      return true;
   }

   private static void hzp(Class<?> var0) {
      try {
         Class.forName(var0.getName(), true, var0.getClassLoader());
      } catch (Throwable var2) {
      }
   }
}
