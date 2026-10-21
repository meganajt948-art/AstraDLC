package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.render.fog.BlindnessEffectFogModifier;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlindnessEffectFogModifier.class)
public class BlindnessEffectFogModifierMixin {

    @Inject(method = "applyStartEndModifier", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$noBlindness(FogData data, Camera camera, ClientWorld world,
                                    float viewDistance, RenderTickCounter tickCounter,
                                    CallbackInfo ci) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n == null || !n.isEnabled() || !n.blindness_get()) return;

        // Не отменяем метод, а подменяем значения — обычный туман как без эффекта
        if (data != null) {
            data.environmentalStart = 0.0F;
            data.environmentalEnd   = viewDistance;
            data.skyEnd             = viewDistance;
            data.cloudEnd           = viewDistance;
        }
        ci.cancel();
    }
}