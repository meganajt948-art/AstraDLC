package dev.dj.cortim.mixin;

import dev.dj.cortim.util.RotationManager;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {

    @Unique private float cortim$realYaw, cortim$realPitch;
    @Unique private boolean cortim$swapped;

    @Inject(method = "sendMovementPackets", at = @At("HEAD"))
    private void cortim$head(CallbackInfo ci) {
        if (!RotationManager.isActive()) { cortim$swapped = false; return; }
        ClientPlayerEntity self = (ClientPlayerEntity) (Object) this;
        cortim$realYaw = self.getYaw();
        cortim$realPitch = self.getPitch();
        self.setYaw(RotationManager.yaw());
        self.setPitch(RotationManager.pitch());
        cortim$swapped = true;
    }

    @Inject(method = "sendMovementPackets", at = @At("RETURN"))
    private void cortim$return(CallbackInfo ci) {
        if (!cortim$swapped) return;
        ClientPlayerEntity self = (ClientPlayerEntity) (Object) this;
        self.setYaw(cortim$realYaw);
        self.setPitch(cortim$realPitch);
        cortim$swapped = false;
    }
}