package dev.dj.cortim.mixin;

import dev.dj.cortim.module.NoJumpDelay;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class NoJumpDelayMixin {

    @Shadow private int jumpingCooldown;

    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void cortim$noJumpDelay(CallbackInfo ci) {
        if ((Object) this instanceof ClientPlayerEntity
                && NoJumpDelay.instance != null
                && NoJumpDelay.instance.isEnabled()) {
            jumpingCooldown = 0;
        }
    }
}