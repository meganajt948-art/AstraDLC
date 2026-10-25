package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.Perspective;

public class rds extends kfe {
   private final vlq rdt = this.add(new vlq("Key", 342));
   private final vlv rdu = this.add(new vlv("Press", "Hold", "Hold", "Toggle"));
   private final vlv rdv = this.add(new vlv("View", "Back", "Back", "Front", "First person"));
   private final vmc rdw = this.add(new vmc("Distance", 4.0, 1.0, 12.0, 0.5).suffix("blocks"));
   private final vmc rdx = this.add(new vmc("Sensitivity", 1.0, 0.2, 2.0, 0.05).unit("x"));
   private boolean rdy;
   private boolean rdz;
   private float rea;
   private float reb;
   private float rec;
   private float red;
   private float ree;
   private float ref;
   private Perspective reg;
   private Perspective reh;

   public rds() {
      super(new String(new char[]{'F', 'r', 'e', 'e', 'L', 'o', 'o', 'k'}), "Look around without turning your player", kfa.RENDER);
      this.rdw.visibleWhen(() -> !this.rdv.is("First person"));
   }

   @Override
   protected void onDisable() {
      this.rdz = false;
      this.ren(MinecraftClient.method_1551());
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var2 == this.rdt.get() && this.rdu.is("Toggle")) {
         this.rdz = !this.rdz;
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      if (!this.rdu.is("Toggle")) {
         this.rdz = false;
      }

      boolean var2 = var1.field_1755 == null
         && !ovh.active()
         && var1.field_1724 != null
         && (this.rdu.is("Toggle") ? this.rdz : vzz.isDown(var1, this.rdt.get()));
      if (var2 && !this.rdy) {
         this.rem(var1);
      } else if (!var2 && this.rdy) {
         this.ren(var1);
      }

      if (this.rdy) {
         Perspective var3 = this.rel();
         if (var3 != this.reh) {
            this.reh = var3;
            var1.field_1690.method_31043(var3);
         }

         ett.distance(this.rdv.is("First person") ? 0.0F : (float)this.rdw.get());
         this.rek(var1.field_1724);
      }
   }

   private void rek(ClientPlayerEntity var1) {
      double var2 = this.rdx.get();
      float var4 = var1.method_36454();
      float var5 = var1.method_36455();
      if (var2 != 1.0) {
         var4 = this.ree + (float)((var4 - this.ree) * var2);
         var5 = Math.max(-90.0F, Math.min(90.0F, this.ref + (float)((var5 - this.ref) * var2)));
         var1.method_36456(var4);
         var1.method_36457(var5);
      }

      this.ree = var4;
      this.ref = var5;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.rdy) {
         ClientPlayerEntity var2 = var1.field_1724;
         this.rec = var2.method_36454();
         this.red = var2.method_36455();
         var2.method_36456(this.rea);
         var2.method_36457(this.reb);
         var2.field_5982 = this.rea;
         var2.field_6004 = this.reb;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.rdy) {
         ClientPlayerEntity var2 = var1.field_1724;
         this.rea = var2.method_36454();
         this.reb = var2.method_36455();
         var2.method_36456(this.rec);
         var2.method_36457(this.red);
         var2.field_5982 = this.rec;
         var2.field_6004 = this.red;
         this.ree = this.rec;
         this.ref = this.red;
      }
   }

   private Perspective rel() {
      String var1 = this.rdv.get();

      return switch (var1) {
         case "Front" -> Perspective.field_26666;
         case "First person" -> Perspective.field_26664;
         default -> Perspective.field_26665;
      };
   }

   private void rem(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (var2 != null) {
         this.rdy = true;
         this.rea = var2.method_36454();
         this.reb = var2.method_36455();
         this.rec = this.rea;
         this.red = this.reb;
         this.ree = this.rea;
         this.ref = this.reb;
         this.reg = var1.field_1690.method_31044();
         this.reh = this.rel();
         var1.field_1690.method_31043(this.reh);
      }
   }

   private void ren(MinecraftClient var1) {
      if (this.rdy) {
         this.rdy = false;
         ett.distance(0.0F);
         ClientPlayerEntity var2 = var1.field_1724;
         if (var2 != null) {
            var2.method_36456(this.rea);
            var2.method_36457(this.reb);
            var2.field_5982 = this.rea;
            var2.field_6004 = this.reb;
         }

         if (this.reg != null) {
            var1.field_1690.method_31043(this.reg);
            this.reg = null;
         }

         this.reh = null;
      }
   }
}
