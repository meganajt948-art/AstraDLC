package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {

    @Inject(method = "renderFireOverlay", at = @At("HEAD"), cancellable = true, require = 0)
    private static void cortim$noFire(MatrixStack matrices,
                                      VertexConsumerProvider vertexConsumers,
                                      Sprite sprite,
                                      CallbackInfo ci) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n != null && n.isEnabled() && n.fireHud_get()) {
            ci.cancel();
        }
    }
}