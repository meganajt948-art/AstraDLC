package dev.dj.cortim.mixin;

import dev.dj.cortim.module.Freecam;
import dev.dj.cortim.util.Dbg;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {
    @Shadow protected abstract void setPos(Vec3d pos);
    @Shadow protected abstract void setRotation(float yaw, float pitch);

    @Inject(method = "update", at = @At("TAIL"))
    private void cortim$freecam(World area, Entity focusedEntity, boolean thirdPerson,
                                boolean inverseView, float tickDelta, CallbackInfo ci) {
        if (Freecam.active) {
            Dbg.every("cam", 1000, "camera apply yaw={} pitch={}", Freecam.cameraYaw, Freecam.cameraPitch);
            this.setPos(Freecam.getRenderPos(tickDelta));
            this.setRotation(Freecam.cameraYaw, Freecam.cameraPitch);
        }
    }
}