package a;

import flow.cosmetic.Cosmetics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.player.PlayerEntity;

public class rwo extends kfe {
   static rwo rwp;
   final vmc rwq = this.add(new vmc("Transparency", 0.6, 0.0, 1.0, 0.05).percent());
   final vla rwr = this.add(new vla("Color", "Mint"));
   final vmc rws = this.add(new vmc("Outline", 0.9, 0.0, 1.0, 0.05).percent());
   final vmc rwt = this.add(new vmc("Width", 1.5, 0.5, 4.0, 0.1));
   final vmc rwu = this.add(new vmc("Fill", 0.0, 0.0, 0.6, 0.01).percent());
   final vmc rwv = this.add(new vmc("Glow", 0.35, 0.0, 1.0, 0.05).percent());
   final vmc rww = this.add(new vmc("Glow size", 0.4, 0.0, 1.0, 0.05).percent());
   final vmc rwx = this.add(new vmc("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));

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
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var1 != null && var1.isEnabled() && var2.world != null) {
         ukl.style(1)
            .set((float)var1.rwu.get(), (float)var1.rws.get(), (float)var1.rwt.get(), (float)var1.rwv.get(), (float)var1.rww.get(), (float)var1.rwx.get());
         int var3 = var1.rwr.color() | 0xFF000000;
         int var4 = var1.rwr.color2() | 0xFF000000;
         boolean var5 = ukl.canFade();

         for (EntityRenderState var7 : var0.entityRenderStates) {
            if (var7 instanceof PlayerEntityRenderState var8
               && var2.world.getEntityById(var8.id) instanceof PlayerEntity var9
               && var9 != var2.player
               && hhf.isFriend(var9)) {
               boolean var11 = Cosmetics.hidesBody(var8);
               if (var5) {
                  if (!var11) {
                     var8.invisible = false;
                     var8.invisibleToPlayer = false;
                  }

                  ukl.fade(var7, 1.0F - (float)var1.rwq.get());
               } else if (var1.rwq.get() > 0.0 && !var11) {
                  var8.invisible = true;
                  var8.invisibleToPlayer = false;
               }

               ukl.paint(var7, 1, var3, var4);
            }
         }
      }
   }
}
