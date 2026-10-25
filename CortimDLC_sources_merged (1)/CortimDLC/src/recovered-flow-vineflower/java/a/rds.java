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
      this.ren(MinecraftClient.getInstance());
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

      boolean var2 = var1.currentScreen == null
         && !ovh.active()
         && var1.player != null
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
            var1.options.setPerspective(var3);
         }

         ett.distance(this.rdv.is("First person") ? 0.0F : (float)this.rdw.get());
         this.rek(var1.player);
      }
   }

   private void rek(ClientPlayerEntity var1) {
      double var2 = this.rdx.get();
      float var4 = var1.getYaw();
      float var5 = var1.getPitch();
      if (var2 != 1.0) {
         var4 = this.ree + (float)((var4 - this.ree) * var2);
         var5 = Math.max(-90.0F, Math.min(90.0F, this.ref + (float)((var5 - this.ref) * var2)));
         var1.setYaw(var4);
         var1.setPitch(var5);
      }

      this.ree = var4;
      this.ref = var5;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.rdy) {
         ClientPlayerEntity var2 = var1.player;
         this.rec = var2.getYaw();
         this.red = var2.getPitch();
         var2.setYaw(this.rea);
         var2.setPitch(this.reb);
         var2.lastYaw = this.rea;
         var2.lastPitch = this.reb;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.rdy) {
         ClientPlayerEntity var2 = var1.player;
         this.rea = var2.getYaw();
         this.reb = var2.getPitch();
         var2.setYaw(this.rec);
         var2.setPitch(this.red);
         var2.lastYaw = this.rec;
         var2.lastPitch = this.red;
         this.ree = this.rec;
         this.ref = this.red;
      }
   }

   private Perspective rel() {
      return switch (this.rdv.get()) {
         case "Front" -> Perspective.THIRD_PERSON_FRONT;
         case "First person" -> Perspective.FIRST_PERSON;
         default -> Perspective.THIRD_PERSON_BACK;
      };
   }

   private void rem(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null) {
         this.rdy = true;
         this.rea = var2.getYaw();
         this.reb = var2.getPitch();
         this.rec = this.rea;
         this.red = this.reb;
         this.ree = this.rea;
         this.ref = this.reb;
         this.reg = var1.options.getPerspective();
         this.reh = this.rel();
         var1.options.setPerspective(this.reh);
      }
   }

   private void ren(MinecraftClient var1) {
      if (this.rdy) {
         this.rdy = false;
         ett.distance(0.0F);
         ClientPlayerEntity var2 = var1.player;
         if (var2 != null) {
            var2.setYaw(this.rea);
            var2.setPitch(this.reb);
            var2.lastYaw = this.rea;
            var2.lastPitch = this.reb;
         }

         if (this.reg != null) {
            var1.options.setPerspective(this.reg);
            this.reg = null;
         }

         this.reh = null;
      }
   }
}
