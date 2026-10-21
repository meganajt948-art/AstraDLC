package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.ViewModel;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class ViewModelMixin {

    private static ViewModel vm() {
        return (ViewModel) ModuleRegistry.byName("ViewModel");
    }

    @Redirect(
            method = "applyEquipOffset",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"),
            require = 0
    )
    private void cortim$equipOffset(MatrixStack matrices, float x, float y, float z) {
        ViewModel v = vm();
        if (v == null || !v.isEnabled()) {
            matrices.translate(x, y, z);
            return;
        }

        boolean right = x > 0;
        float sign = right ? 1.0f : -1.0f;

        float userX, userY, userScale;
        if (right) {
            userX = v.getRightX();
            userY = v.getRightY();
            userScale = v.getRightScale();
        } else {
            userX = v.getLeftX();
            userY = v.getLeftY();
            userScale = v.getLeftScale();
        }

        float offsetX = userX / 160.0f;
        float offsetY = -userY / 160.0f;

        matrices.translate(x + offsetX, y + offsetY, z);
        matrices.scale(userScale, userScale, userScale);
    }

    @Inject(
            method = "renderFirstPersonItem",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemDisplayContext;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;I)V",
                    shift = At.Shift.BEFORE),
            require = 0
    )
    private void cortim$scale(net.minecraft.client.network.AbstractClientPlayerEntity player,
                              float tickProgress, float pitch, Hand hand,
                              float swingProgress, ItemStack item,
                              float equipProgress, MatrixStack matrices,
                              net.minecraft.client.render.command.OrderedRenderCommandQueue queue,
                              int light, CallbackInfo ci) {
        ViewModel v = vm();
        if (v == null || !v.isEnabled()) return;

        boolean right = hand == Hand.MAIN_HAND;
        float scale = right ? v.getRightScale() : v.getLeftScale();

        matrices.scale(scale, scale, scale);
    }
}