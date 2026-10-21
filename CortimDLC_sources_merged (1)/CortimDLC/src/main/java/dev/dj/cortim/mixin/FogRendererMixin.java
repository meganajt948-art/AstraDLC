package dev.dj.cortim.mixin;

import dev.dj.cortim.Cortim;
import dev.dj.cortim.module.Ambience;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {

    @Inject(method = "getFogColor", at = @At("RETURN"), cancellable = true, require = 0)
    private void cortim$fogColor(Camera camera, float tickProgress, ClientWorld world,
                                 int viewDistance, float skyDarkness,
                                 CallbackInfoReturnable<Vector4f> cir) {
        Ambience a = Cortim.getAmbience();
        if (a == null || !a.isEnabled() || !a.isWorldColorEnabled()) return;

        int rgb = a.getWorldColor();
        float r = ((rgb >> 16) & 0xFF) / 255f;
        float g = ((rgb >> 8) & 0xFF) / 255f;
        float b = (rgb & 0xFF) / 255f;
        Vector4f original = cir.getReturnValue();
        float alpha = original == null ? 1f : original.w;

        cir.setReturnValue(new Vector4f(r, g, b, alpha));
    }
}