package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.util.math.Vec3d;

public class lwq extends kfe {
   public static final double MAX_STEP = 9.5;
   public static final double SPEED = 40.0;
   public static final double VERTICAL = 25.0;
   PlayerAbilities lwr;
   float lws;

   public lwq() {
      super(
         a.c(1474605818, "늷쬰䇰\udf87员틨梓\ue148缂"),
         a.d(
            "该\uf273碲\ue6c4洂\ueba4冥\ud85b䙍쳶䬰넘㾉\ua632Ɽꪛმ鼖\u05eb莠\u0a43瀖ﺵ攦\ue314榙큹广쒖䋚쥵㞣뷶␆ꈁ⣹霩ᵓ鮗Ƞ衢\uf69b粅טּ懽\uef8b噍\udcbe媼성休떕㰧먦ₔ껊ᕿ鏪\u19dd耇ຨ瓠\uf35d祃\ue78d湲푫劅\ud8ca䝦췥䯕눅㢾ꚩⴋꭁᇻ頬ٗ",
            1734745515,
            1925027416
         ),
         kfa.MOVEMENT
      );
   }

   @Override
   protected void onDisable() {
      this.lwv();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.lwv();
      ClientPlayerEntity var2 = var1.player;
      PlayerAbilities var3 = var2.getAbilities();
      if (var3.flying && !var2.isSpectator() && !var2.hasVehicle() && var2.hurtTime <= 0 && !ovh.active() && !lqq.busy()) {
         GameOptions var4 = var1.options;
         double var5 = lww(var4.forwardKey.isPressed(), var4.backKey.isPressed());
         double var7 = lww(var4.leftKey.isPressed(), var4.rightKey.isPressed());
         double var9 = lww(var4.jumpKey.isPressed(), var4.sneakKey.isPressed());
         double var11 = 0.0;
         double var13 = 0.0;
         double var15 = Math.hypot(var5, var7);
         if (var15 > 0.0) {
            double var17 = 2.0 / var15;
            double var19 = Math.toRadians(var2.getYaw());
            double var21 = Math.sin(var19);
            double var23 = Math.cos(var19);
            var11 = (var7 * var23 - var5 * var21) * var17;
            var13 = (var5 * var23 + var7 * var21) * var17;
         }

         double var25 = var9 * 25.0 / 20.0;
         Vec3d var26 = new Vec3d(var11, var25, var13);
         double var20 = var26.length();
         var2.setVelocity(var20 > 9.5 ? var26.multiply(9.5 / var20) : var26);
         this.lwr = var3;
         this.lws = var3.getFlySpeed();
         var3.setFlySpeed(0.0F);
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.lwv();
   }

   void lwv() {
      if (this.lwr != null) {
         this.lwr.setFlySpeed(this.lws);
         this.lwr = null;
      }
   }

   static double lww(boolean var0, boolean var1) {
      return (var0 ? 1 : 0) - (var1 ? 1 : 0);
   }
}
