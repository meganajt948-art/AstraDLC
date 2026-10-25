package a;

import flow.Flow;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.Items;

public final class rhf {
   private static final vdn rhg = veo.semibold(6.0F);
   private static final vcj rhh = new vcj(10.0F);
   private static final vcj rhi = new vcj(12.0F);
   private static final vcj rhj = new vcj(6.0F);
   private static long rhk = -1L;
   private static float rhl;

   private rhf() {
   }

   private static boolean rho() {
      if (Flow.getInstance().getModuleManager() == null) {
         return false;
      }

      for (kfe var1 : Flow.getInstance().getModuleManager().getModules()) {
         if (var1 instanceof rxa var2 && var2.maceCharge()) {
            return true;
         }
      }

      return false;
   }

   static float smashBonus(double var0) {
      if (var0 <= 1.5) {
         return 0.0F;
      } else if (var0 <= 3.0) {
         return (float)(4.0 * var0);
      } else {
         return var0 <= 8.0 ? (float)(12.0 + 2.0 * (var0 - 3.0)) : (float)(22.0 + (var0 - 8.0));
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      ClientPlayerEntity var3 = var2.player;
      if (var3 != null && !var2.options.hudHidden && var2.currentScreen == null && var2.options.getPerspective().isFirstPerson()) {
         unf.observe(var0);
         if (unf.frame() != rhk) {
            rhk = unf.frame();
            float var4 = unf.delta();
            boolean var5 = var3.getMainHandStack().isOf(Items.MACE) && rho();
            float var6 = var1.getTickProgress(true);
            float var7 = var5 ? var3.getAttackCooldownProgress(var6) : 1.0F;
            double var8 = var3.fallDistance;
            boolean var10 = var5 && !var3.isOnGround() && !var3.isGliding() && var8 > 1.5;
            rhl = var7 >= 0.999F ? rhl + var4 : 0.0F;
            boolean var11 = var5 && (var7 < 0.999F || rhl < 0.6F || var10);
            float var12 = rhh.step(var11, var4);
            float var13 = rhi.step(var10, var4);
            float var14 = rhj.step(var7 >= 0.999F, var4);
            if (!(var12 <= 0.01F)) {
               uut.beginFrame();
               float var15 = var0.getScaledWindowWidth() * 0.5F;
               float var16 = var0.getScaledWindowHeight() * 0.5F;
               float var17 = 11.0F;
               int var18 = ujt.lerp(iov.accent() | 0xFF000000, -11443, var13);
               uut.pushAlpha(var12);
               uut.arc(var0, var15, var16, var17, 1.6F, 0.0F, 1.0F, 1090519039);
               uut.arc(var0, var15, var16, var17, 1.6F, 0.0F, Math.max(0.001F, var7), var18);
               float var19 = Math.max(var14 * (1.0F - Math.min(1.0F, rhl / 0.6F)), var13);
               if (var19 > 0.02F) {
                  uut.additive(true);
                  uut.shadow(var0, var15 - var17, var16 - var17, var17 * 2.0F, var17 * 2.0F, var17, 5.0F, ujt.withAlpha(var18, Math.round(70.0F * var19)));
                  uut.additive(false);
               }

               if (var13 > 0.02F) {
                  float var20 = smashBonus(var8);
                  float var21 = Math.min(1.0F, var20 / 22.0F);
                  uut.pushAlpha(var13);
                  uut.arc(var0, var15, var16, var17 + 3.2F, 1.2F, 0.0F, Math.max(0.001F, var21), ujt.withAlpha(-5720, 230));
                  String var22 = "+" + Math.round(var20);
                  rhg.drawCentered(var0, var22, var15, rhg.centerTop(var16 + var17 + 9.0F), -8054);
                  uut.popAlpha();
               }

               uut.popAlpha();
            }
         }
      }
   }
}
