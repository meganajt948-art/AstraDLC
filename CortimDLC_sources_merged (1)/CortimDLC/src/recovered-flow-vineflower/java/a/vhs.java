package a;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;

public interface vhs {
   boolean active();

   boolean handles(AbstractClientPlayerEntity var1, Hand var2, ItemStack var3);

   void apply(MatrixStack var1, AbstractClientPlayerEntity var2, Arm var3, Hand var4, float var5, ItemStack var6, float var7);
}
