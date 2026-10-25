package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.attribute.EnvironmentAttributes;

public class reo extends kfe {
   final vlv rep = this.add(new vlv("Mode", "Auto", "Auto", "Full"));
   final vmc req = this.add(new vmc("Night", 0.25, 0.0, 1.0, 0.05).percent());
   final vmc rer = this.add(new vmc("Caves", 0.6, 0.0, 1.0, 0.05).percent());
   final vmc res = this.add(new vmc("Strength", 1.0, 0.1, 1.0, 0.05).percent());
   double ret = -1.0;
   double reu = -1.0;

   public reo() {
      super(new String(new char[]{'F', 'u', 'l', 'l', 'B', 'r', 'i', 'g', 'h', 't'}), "Brighter nights and caves", kfa.RENDER);
      this.req.visibleWhen(() -> this.rep.is("Auto"));
      this.rer.visibleWhen(() -> this.rep.is("Auto"));
      this.res.visibleWhen(() -> this.rep.is("Full"));
   }

   @Override
   protected void onDisable() {
      vxz.release();
      this.ret = -1.0;
      this.reu = -1.0;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (wbu.suspended(var1)) {
         vxz.release();
         this.ret = -1.0;
      } else {
         double var2 = vxz.own();
         double var4;
         double var6;
         if (this.rep.is("Full")) {
            var4 = Math.max(var2, 1.0 + 15.0 * this.res.get());
            var6 = 0.35;
            this.reu = -1.0;
         } else {
            var4 = this.rex(var1, var2);
            var6 = 0.12;
         }

         if (this.ret < 0.0) {
            this.ret = var2;
         }

         this.ret = this.ret + (var4 - this.ret) * var6;
         vxz.override(this.ret);
      }
   }

   double rex(MinecraftClient var1, double var2) {
      ClientWorld var4 = var1.world;
      BlockPos var5 = var1.player.getBlockPos();
      BlockPos var6 = BlockPos.ofFloored(var1.player.getEyePos());
      int var7 = Math.max(var4.getLightLevel(LightType.BLOCK, var5), var4.getLightLevel(LightType.BLOCK, var6));
      int var8 = Math.max(var4.getLightLevel(LightType.SKY, var5), var4.getLightLevel(LightType.SKY, var6));
      double var9 = Math.max(var7, var8 * rey(var1));
      this.reu = this.reu < 0.0 ? var9 : this.reu + (var9 - this.reu) * 0.15;
      double var11 = 1.0 - rez(2.0, 12.0, this.reu);
      double var13 = 1.0 - rez(4.0, 10.0, var8);
      double var15 = 1.0 + 2.0 * this.req.get();
      double var17 = 1.0 + 11.0 * this.rer.get();
      double var19 = var15 + (var17 - var15) * var13;
      return Math.max(var2, var2 + (var19 - var2) * var11);
   }

   static float rey(MinecraftClient var0) {
      try {
         Float var1 = var0.gameRenderer.getCamera().getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.SKY_LIGHT_FACTOR_VISUAL, 1.0F);
         return var1 == null ? 1.0F : Math.max(0.0F, Math.min(1.0F, var1));
      } catch (RuntimeException var2) {
         return 1.0F;
      }
   }

   static double rez(double var0, double var2, double var4) {
      double var6 = Math.max(0.0, Math.min(1.0, (var4 - var0) / (var2 - var0)));
      return var6 * var6 * (3.0 - 2.0 * var6);
   }
}
