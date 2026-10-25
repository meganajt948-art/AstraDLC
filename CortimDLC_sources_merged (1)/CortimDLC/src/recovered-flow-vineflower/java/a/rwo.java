package a;

import flow.cosmetic.Cosmetics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.player.PlayerEntity;

public class rwo extends kfe {
   private static rwo rwp;
   private final vmc rwq = this.add(new vmc("Transparency", 0.6, 0.0, 1.0, 0.05).percent());
   private final vla rwr = this.add(new vla("Color", "Mint"));
   private final vmc rws = this.add(new vmc("Outline", 0.9, 0.0, 1.0, 0.05).percent());
   private final vmc rwt = this.add(new vmc("Width", 1.5, 0.5, 4.0, 0.1));
   private final vmc rwu = this.add(new vmc("Fill", 0.0, 0.0, 0.6, 0.01).percent());
   private final vmc rwv = this.add(new vmc("Glow", 0.35, 0.0, 1.0, 0.05).percent());
   private final vmc rww = this.add(new vmc("Glow size", 0.4, 0.0, 1.0, 0.05).percent());
   private final vmc rwx = this.add(new vmc("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));

   public rwo() {
      super(
         new String(new char[]{'T', 'r', 'a', 'n', 's', 'p', 'a', 'r', 'e', 'n', 't', 'F', 'r', 'i', 'e', 'n', 'd', 's'}),
         "Friends turn see-through",
         kfa.RENDER
      );
      rwp = this;
      this.rwt.visibleWhen(() -> this.rws.get() > 0.0);
      this.rww.visibleWhen(() -> this.rwv.get() > 0.0);
   }

   public static void afterExtraction(WorldRenderState var0) {
      rwo var1 = rwp;
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (var1 != null && var1.isEnabled() && var2.field_1687 != null) {
         ukl.style(1)
            .set((float)var1.rwu.get(), (float)var1.rws.get(), (float)var1.rwt.get(), (float)var1.rwv.get(), (float)var1.rww.get(), (float)var1.rwx.get());
         int var3 = var1.rwr.color() | 0xFF000000;
         int var4 = var1.rwr.color2() | 0xFF000000;
         boolean var5 = ukl.canFade();

         for (EntityRenderState var7 : var0.field_61735) {
            if (var7 instanceof PlayerEntityRenderState var8
               && var2.field_1687.method_8469(var8.field_53528) instanceof PlayerEntity var9
               && var9 != var2.field_1724
               && hhf.isFriend(var9)) {
               boolean var11 = Cosmetics.hidesBody(var8);
               if (var5) {
                  if (!var11) {
                     var8.field_53333 = false;
                     var8.field_53461 = false;
                  }

                  ukl.fade(var7, 1.0F - (float)var1.rwq.get());
               } else if (var1.rwq.get() > 0.0 && !var11) {
                  var8.field_53333 = true;
                  var8.field_53461 = false;
               }

               ukl.paint(var7, 1, var3, var4);
            }
         }
      }
   }
}
