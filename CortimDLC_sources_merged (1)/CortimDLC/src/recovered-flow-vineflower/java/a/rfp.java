package a;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;

public class rfp extends kfe {
   private static rfp rfq;
   private static boolean rfr;
   private final vmc rfs = this.add(new vmc("Spin", 1.0, 0.2, 2.0, 0.1).unit("x"));

   public rfp() {
      super(new String(new char[]{'I', 't', 'e', 'm', 'P', 'h', 'y', 's', 'i', 'c', 's'}), "Items lie flat and tumble", kfa.RENDER);
      rfq = this;
   }

   public static boolean on() {
      return rfq != null && rfq.isEnabled();
   }

   public static float spin() {
      return rfq == null ? 1.0F : (float)rfq.rfs.get();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (!rfr) {
         rfr = true;

         try {
            EntityRendererRegistry.register(EntityType.ITEM, usj::new);
            var1.getEntityRenderDispatcher().reload(var1.getResourceManager());
         } catch (Throwable var3) {
            System.out.println("item physics unavailable: " + var3);
         }
      }
   }
}
