package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class rug extends kfe implements vhs {
   private static final float ruh = (float) Math.PI;
   private final vkl rui = this.add(new vkl("Only main hand", true));
   private final vlv ruj = this.add(
      new vlv("Mode", "Smooth", "Smooth", "Static", "Down", "Poke", "SelfBack", "Feast", "ToBack", "Block", "Akrien", "Break", "Pander", "Slant")
   );
   private final vmc ruk = this.add(new vmc("Strength", 1.2, 0.1, 3.0, 0.01).unit("x"));
   private final vkl rul = this.add(new vkl("Mace charge", true));
   private float rum;
   private long run;

   public rug() {
      super(new String(new char[]{'S', 'w', 'i', 'n', 'g', 'A', 'n', 'i', 'm', 'a', 't', 'i', 'o', 'n', 's'}), "Swing animations for the held item", kfa.RENDER);
      vhu.register(this);
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
   public boolean handles(AbstractClientPlayerEntity var1, Hand var2, ItemStack var3) {
      if (var3.method_7960() || var3.method_31574(Items.field_8204)) {
         return false;
      } else {
         return this.rui.get() && var2 != Hand.field_5808 ? false : !var1.method_6115() || var1.method_6058() != var2;
      }
   }

   @Override
   public void apply(MatrixStack var1, AbstractClientPlayerEntity var2, Arm var3, Hand var4, float var5, ItemStack var6, float var7) {
      int var8 = var3 == Arm.field_6183 ? 1 : -1;
      if (var6.method_31574(Items.field_49814)) {
         this.rur(var1, var2, var8, System.nanoTime());
      }

      this.ruq(var1, var8, var5, (float)this.ruk.get());
      var1.method_46416(-0.56F * var8, 0.52F, 0.72F);
   }

   private void ruq(MatrixStack var1, int var2, float var3, float var4) {
      float var5 = MathHelper.method_15374(var3 * var3 * (float) Math.PI);
      float var6 = MathHelper.method_15374(MathHelper.method_15355(var3) * (float) Math.PI);
      float var7 = MathHelper.method_15374(var3 * (float) Math.PI);
      String var8 = this.ruj.get();
      switch (var8) {
         case "Static":
            var1.method_46416(var2 * 0.56F, -0.42F, -0.72F);
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * -60.0F * var4));
            var1.method_46416(0.0F, -0.1F, 0.0F);
            break;
         case "Down":
            var1.method_46416(var2 * 0.56F, -0.32F, -0.72F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(76.0F * var2));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(var6 * -5.0F * var4));
            var1.method_22907(RotationAxis.field_40713.rotationDegrees(var6 * -100.0F * var4));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * -155.0F * var4));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(-100.0F));
            break;
         case "Poke":
            var1.method_46416(var2 * 0.56F, -0.52F, -0.72F);
            var1.method_46416(0.0F, 0.0F, var4 / 3.0F * -var7);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(75.0F * var2));
            var1.method_22907(RotationAxis.field_40718.rotationDegrees((-75.0F * (var4 / 4.0F) * var7 - 60.0F) * var2));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(-75.0F));
            break;
         case "SelfBack":
            var1.method_46416(0.65F * var2, -0.3F, -0.8F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(90.0F * var2));
            var1.method_22907(RotationAxis.field_40718.rotationDegrees(-70.0F * var2));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(-100.0F - 60.0F * var4 * var7));
            break;
         case "Feast":
            var1.method_46416(var2 * 0.56F, -0.32F, -0.72F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(30.0F * var2));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(var6 * 75.0F * var2 * var4));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * -65.0F * var4));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(30.0F * var2));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(-80.0F));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(35.0F * var2));
            break;
         case "ToBack":
            var1.method_46416(0.65F * var2, -0.45F, -0.9F);
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(50.0F));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees((-30.0F * (1.0F - var6 * var4) - 30.0F) * var2));
            var1.method_22907(RotationAxis.field_40718.rotationDegrees(110.0F * var2));
            break;
         case "Block":
            if (var3 > 0.0F) {
               var1.method_46416(0.56F * var2, -0.5F, -0.7F);
               var1.method_22907(RotationAxis.field_40716.rotationDegrees(45.0F * var2));
               var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * -85.0F * var4));
               var1.method_46416(-0.1F * var2, 0.28F, 0.2F);
               var1.method_22907(RotationAxis.field_40714.rotationDegrees(-85.0F));
            } else {
               var1.method_46416(0.56F * var2, -0.52F, -0.72F);
            }
            break;
         case "Akrien":
            var1.method_46416(var2 * 0.65F, -0.32F, -0.72F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(76.0F * var2));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(var6 * -5.0F * var4));
            var1.method_22907(RotationAxis.field_40713.rotationDegrees(var6 * -100.0F * var4));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * -155.0F * var4));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(-100.0F));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(var6 * 25.0F * var4));
            var1.method_22907(RotationAxis.field_40713.rotationDegrees(var6 * -25.0F * var4));
            var1.method_22907(RotationAxis.field_40713.rotationDegrees(var5 * 15.0F * var4));
            var1.method_46416(var6 * 0.18F * var4, var6 * 0.59F * var4, 0.0F);
            break;
         case "Break":
            var1.method_46416(0.66F * var2, -0.3F, -0.38F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(270.0F * var2));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * 10.0F * var4));
            var1.method_22905(0.5F, 0.5F, 0.5F);
            var1.method_46416(-0.1F * var2, 0.2F, 0.0F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(-10.0F * var2));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(90.0F));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(-105.0F * var2));
            break;
         case "Pander":
            var1.method_46416(var2 * 0.56F, -0.52F, -0.72F);
            var1.method_46416((0.3F - var7 * 0.15F) * var2, 0.08F, -0.15F - var7 * 0.13F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees((76.0F - 10.0F * var7) * var2));
            var1.method_22907(RotationAxis.field_40718.rotationDegrees((-16.0F - 8.0F * var7) * var2));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(-83.0F - 26.0F * var7));
            break;
         case "Slant":
            float var10 = 35.0F * var4;
            var1.method_46416(var2 * 0.56F, -0.52F, -0.72F);
            var1.method_46416(0.0F, 0.0F, -0.3F * var7 * var4);
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var7 * -var10));
            var1.method_22907(RotationAxis.field_40718.rotationDegrees(var7 * var10));
            break;
         default:
            var1.method_46416(0.56F * var2, -0.52F, -0.72F);
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(var2 * (45.0F + var5 * -20.0F * var4)));
            var1.method_22907(RotationAxis.field_40718.rotationDegrees(var2 * var6 * -20.0F * var4));
            var1.method_22907(RotationAxis.field_40714.rotationDegrees(var6 * -80.0F * var4));
            var1.method_22907(RotationAxis.field_40716.rotationDegrees(var2 * -45.0F));
      }
   }

   private void rur(MatrixStack var1, AbstractClientPlayerEntity var2, float var3, long var4) {
      float var6 = this.run == 0L ? 0.0F : Math.min(0.1F, (float)(var4 - this.run) / 1.0E9F);
      this.run = var4;
      float var7 = 0.0F;
      if (this.rul.get() && !var2.method_24828() && !var2.method_6128() && var2.field_6017 > 1.5) {
         var7 = 0.25F + 0.75F * Math.min(1.0F, rhf.smashBonus(var2.field_6017) / 22.0F);
      }

      this.rum = this.rum + (var7 - this.rum) * (1.0F - (float)Math.exp(-var6 * (var7 > this.rum ? 9.0 : 14.0)));
      if (this.rum < 0.005F) {
         this.rum = 0.0F;
      } else {
         float var8 = this.rum;
         float var9 = var8 > 0.92F ? MathHelper.method_15374((float)var4 / 1.0E9F * 46.0F) * (var8 - 0.92F) * 14.0F : 0.0F;
         var1.method_46416(-0.03F * var3 * var8, 0.07F * var8, -0.08F * var8);
         var1.method_46416(0.56F * var3, -0.52F, -0.72F);
         var1.method_22907(RotationAxis.field_40714.rotationDegrees(-12.0F * var8));
         var1.method_22907(RotationAxis.field_40718.rotationDegrees(var3 * (-5.0F * var8 + var9)));
         var1.method_46416(-0.56F * var3, 0.52F, 0.72F);
      }
   }
}
