package dev.dj.cortim.mixin;

import dev.dj.cortim.module.AspectRatio;
import dev.dj.cortim.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class AspectRatioMixin {

    private static AspectRatio ar() {
        return (AspectRatio) ModuleRegistry.byName("AspectRatio");
    }

    @Inject(method = "getBasicProjectionMatrix", at = @At("RETURN"), cancellable = true)
    private void cortim$aspect(float fov, CallbackInfoReturnable<Matrix4f> cir) {
        AspectRatio a = ar();
        if (a == null || !a.isEnabled()) return;

        Matrix4f original = cir.getReturnValue();
        if (original == null) return;

        float targetRatio = a.getEffectiveRatio();

        var window = MinecraftClient.getInstance().getWindow();
        float vanillaRatio = (float) window.getFramebufferWidth() / (float) window.getFramebufferHeight();
        if (vanillaRatio <= 0) return;

        float factor = targetRatio / vanillaRatio;

        Matrix4f result = new Matrix4f(original);
        result.m00(result.m00() * factor);
        cir.setReturnValue(result);
    }
}