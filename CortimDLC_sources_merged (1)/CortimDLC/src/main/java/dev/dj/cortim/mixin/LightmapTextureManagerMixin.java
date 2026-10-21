package dev.dj.cortim.mixin;

import dev.dj.cortim.CortimConfig;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {

    @ModifyVariable(method = "update", at = @At("HEAD"), argsOnly = true, index = 1)
    private float cortim$forceBright(float original) {
        if (CortimConfig.brightnessEnabled && !CortimConfig.isPanic()) {
            return Math.max(original, CortimConfig.gamma);
        }
        return original;
    }
}