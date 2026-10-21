package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.BatchingRenderCommandQueue;
import net.minecraft.client.render.command.ShadowPiecesCommandRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShadowPiecesCommandRenderer.class)
public class ShadowPiecesCommandRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$noShadows(BatchingRenderCommandQueue queue,
                                  VertexConsumerProvider.Immediate immediate,
                                  CallbackInfo ci) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n != null && n.isEnabled() && n.shadows_get()) {
            ci.cancel();
        }
    }
}