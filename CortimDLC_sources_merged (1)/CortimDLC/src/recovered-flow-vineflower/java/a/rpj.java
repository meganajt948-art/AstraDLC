package a;

import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

public class rpj extends kfe {
   private static rpj rpk;
   private final vkl rpl = this.add(new vkl("Food preview", true));
   private final vkl rpm = this.add(new vkl("Number", false));
   private static final Identifier rpn = Identifier.ofVanilla("hud/food_full");
   private static final Identifier rpo = Identifier.ofVanilla("hud/food_half");
   private static final int rpp = -670639;
   private static final vdn rpq = veo.semibold(5.8F);

   public rpj() {
      super(new String(new char[]{'S', 'a', 't', 'u', 'r', 'a', 't', 'i', 'o', 'n'}), "Shows saturation on the hunger bar", kfa.RENDER);
      rpk = this;
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rpj var2 = rpk;
      MinecraftClient var3 = MinecraftClient.getInstance();
      ClientPlayerEntity var4 = var3.player;
      if (var2 != null
         && var2.isEnabled()
         && var4 != null
         && var3.interactionManager != null
         && var3.interactionManager.hasStatusBars()
         && !(var4.getVehicle() instanceof LivingEntity)) {
         HungerManager var5 = var4.getHungerManager();
         int var6 = var5.getFoodLevel();
         float var7 = var5.getSaturationLevel();
         int var8 = var0.getScaledWindowWidth() / 2 + 91;
         int var9 = var0.getScaledWindowHeight() - 39;
         FoodComponent var10 = null;
         if (var2.rpl.get()) {
            for (Hand var14 : Hand.values()) {
               ItemStack var15 = var4.getStackInHand(var14);
               FoodComponent var16 = var15.get(DataComponentTypes.FOOD);
               if (var16 != null) {
                  var10 = var16;
                  break;
               }
            }
         }

         float var18 = 0.35F + 0.3F * (float)Math.sin(System.currentTimeMillis() / 180.0);
         if (var10 != null && var6 < 20) {
            int var19 = Math.min(20, var6 + var10.nutrition());
            int var21 = ujt.withAlpha(-1, Math.round(255.0F * var18));

            for (int var23 = 0; var23 < 10; var23++) {
               int var25 = var23 * 2 + 1;
               int var27 = var25 < var6 ? 2 : (var25 == var6 ? 1 : 0);
               int var17 = var25 < var19 ? 2 : (var25 == var19 ? 1 : 0);
               if (var17 > var27) {
                  var0.drawGuiTexture(RenderPipelines.GUI_TEXTURED, var17 == 2 ? rpn : rpo, var8 - var23 * 8 - 9, var9, 9, 9, var21);
               }
            }
         }

         uut.beginFrame();
         float var20 = 80.0F;
         float var22 = 1.3F;
         float var24 = var9 - var22 - 0.6F;
         uut.round(var0, var8 - var20 - 0.5F, var24, var20, var22, var22 * 0.5F, 1426063360);
         float var26 = var20 * Math.max(0.0F, Math.min(20.0F, var7)) / 20.0F;
         if (var10 != null) {
            float var28 = Math.min(Math.min(20.0F, var6 + var10.nutrition()), var7 + var10.saturation());
            float var30 = var20 * Math.max(0.0F, var28) / 20.0F;
            if (var30 > var26) {
               uut.round(var0, var8 - var30 - 0.5F, var24, var30, var22, var22 * 0.5F, ujt.withAlpha(-670639, Math.round(255.0F * var18)));
            }
         }

         if (var26 > 0.2F) {
            uut.round(var0, var8 - var26 - 0.5F, var24, var26, var22, var22 * 0.5F, -670639);
         }

         if (var2.rpm.get()) {
            String var29 = String.format(Locale.ROOT, "%.1f", var7);
            rpq.draw(var0, var29, var8 + 3.0F, rpq.centerTop(var9 + 4.5F) + 0.5F, -1879048192);
            rpq.draw(var0, var29, var8 + 2.5F, rpq.centerTop(var9 + 4.5F), -670639);
         }
      }
   }
}
