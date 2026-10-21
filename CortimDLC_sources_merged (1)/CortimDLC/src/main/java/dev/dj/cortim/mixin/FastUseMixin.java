package dev.dj.cortim.mixin;

import dev.dj.cortim.Cortim;
import dev.dj.cortim.module.FastUse;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class FastUseMixin {

    @Shadow public int itemUseCooldown;

    @Inject(method = "tick", at = @At("HEAD"))
    private void cortim$fastUse(CallbackInfo ci) {
        FastUse fu = Cortim.getFastUse();
        if (fu != null && fu.isEnabled() && itemUseCooldown > 0) {
            itemUseCooldown = 0;
        }
    }
}