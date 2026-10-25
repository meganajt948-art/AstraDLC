package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.RotationAxis;

public class rxa extends kfe implements vht {
   final vmc rxb = this.add(new vmc("X", 0.0, -1.0, 1.0, 0.01));
   final vmc rxc = this.add(new vmc("Y", 0.0, -1.0, 1.0, 0.01));
   final vmc rxd = this.add(new vmc("Z", 0.0, -1.0, 1.0, 0.01));
   final vmc rxe = this.add(new vmc("Size", 1.0, 0.3, 2.0, 0.01).unit("x"));
   final vmc rxf = this.add(new vmc("Turn X", 0.0, -180.0, 180.0, 1.0).unit("°"));
   final vmc rxg = this.add(new vmc("Turn Y", 0.0, -180.0, 180.0, 1.0).unit("°"));
   final vmc rxh = this.add(new vmc("Turn Z", 0.0, -180.0, 180.0, 1.0).unit("°"));
   final vkl rxi = this.add(new vkl("Left mirrors right", true));
   final vmc rxj = this.add(new vmc("Left X", 0.0, -1.0, 1.0, 0.01));
   final vmc rxk = this.add(new vmc("Left Y", 0.0, -1.0, 1.0, 0.01));
   final vmc rxl = this.add(new vmc("Left Z", 0.0, -1.0, 1.0, 0.01));
   final vmc rxm = this.add(new vmc("Left size", 1.0, 0.3, 2.0, 0.01).unit("x"));
   final vmc rxn = this.add(new vmc("Left turn X", 0.0, -180.0, 180.0, 1.0).unit("°"));
   final vmc rxo = this.add(new vmc("Left turn Y", 0.0, -180.0, 180.0, 1.0).unit("°"));
   final vmc rxp = this.add(new vmc("Left turn Z", 0.0, -180.0, 180.0, 1.0).unit("°"));
   final vkl rxq = this.add(new vkl("Mace charge", true));
   final vkw rxr = this.add(new vkw("Reset", new vkq("Reset", vhz.RESET, this::rxu)));

   public rxa() {
      super(new String(new char[]{'V', 'i', 'e', 'w', 'M', 'o', 'd', 'e', 'l'}), "Move, turn and resize your hands", kfa.RENDER);
      vhu.register(this);

      for (vmo var4 : new vmo[]{this.rxj, this.rxk, this.rxl, this.rxm, this.rxn, this.rxo, this.rxp}) {
         var4.visibleWhen(() -> !this.rxi.get());
      }
   }

   void rxu() {
      for (vmo var2 : this.getSettings()) {
         if (var2 instanceof vmc var3) {
            var3.reset();
         }
      }

      this.rxi.reset();
   }

   public boolean maceCharge() {
      return this.isEnabled() && this.rxq.get();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      vgj.ensureInstalled(var1);
   }

   @Override
   public boolean active() {
      return this.isEnabled();
   }

   @Override
   public void apply(MatrixStack var1, Arm var2) {
      boolean var3 = var2 == Arm.RIGHT;
      boolean var4 = !var3 && !this.rxi.get();
      float var5 = var3 ? 1.0F : -1.0F;
      float var6 = (float)(var4 ? this.rxj.get() : this.rxb.get());
      float var7 = (float)(var4 ? this.rxk.get() : this.rxc.get());
      float var8 = (float)(var4 ? this.rxl.get() : this.rxd.get());
      float var9 = (float)(var4 ? this.rxm.get() : this.rxe.get());
      float var10 = (float)(var4 ? this.rxn.get() : this.rxf.get());
      float var11 = (float)(var4 ? this.rxo.get() : this.rxg.get());
      float var12 = (float)(var4 ? this.rxp.get() : this.rxh.get());
      if (var6 != 0.0F || var7 != 0.0F || var8 != 0.0F || var9 != 1.0F || var10 != 0.0F || var11 != 0.0F || var12 != 0.0F) {
         var1.translate(var6 * var5, var7, var8);
         var1.translate(0.56F * var5, -0.52F, -0.72F);
         var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var11 * var5));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var10));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var12 * var5));
         var1.scale(var9, var9, var9);
         var1.translate(-0.56F * var5, 0.52F, 0.72F);
      }
   }
}
