package dev.dj.cortim.mixin;

import dev.dj.cortim.util.RotationManager;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerMoveFixMixin {

    @Unique private float cortim$ry, cortim$rp;
    @Unique private boolean cortim$swapped;

    /** На время расчёта движения подставляем тихий угол, чтобы клиент и сервер считали одинаково. */
    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void cortim$head(CallbackInfo ci) {
        if (!(RotationManager.moveFix && RotationManager.isActive())) { cortim$swapped = false; return; }
        ClientPlayerEntity s = (ClientPlayerEntity) (Object) this;
        cortim$ry = s.getYaw();
        cortim$rp = s.getPitch();
        s.setYaw(RotationManager.yaw());
        s.setPitch(RotationManager.pitch());
        cortim$swapped = true;
    }

    @Inject(method = "tickMovement", at = @At("RETURN"))
    private void cortim$ret(CallbackInfo ci) {
        if (!cortim$swapped) return;
        ClientPlayerEntity s = (ClientPlayerEntity) (Object) this;
        s.setYaw(cortim$ry);
        s.setPitch(cortim$rp);
        cortim$swapped = false;
    }
}