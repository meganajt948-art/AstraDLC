package dev.dj.cortim.mixin;

import dev.dj.cortim.module.CameraTweaks;
import dev.dj.cortim.module.Freecam;
import dev.dj.cortim.module.ModuleRegistry;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraTweaksMixin {

    @Shadow protected abstract void setPos(Vec3d pos);
    @Shadow protected abstract float clipToSpace(float desired);
    @Shadow public abstract Vec3d getCameraPos();

    @Unique private static float cortim$currentDist = 4.0f;
    @Unique private static long cortim$lastUpdateMs = 0L;

    private static CameraTweaks ct() {
        return (CameraTweaks) ModuleRegistry.byName("CameraTweaks");
    }

    /**
     * Сквозь стены — обходим clipToSpace.
     * Возвращаем дистанцию, которую запросил апдейт.
     */
    @Redirect(
            method = "update",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/render/Camera;clipToSpace(F)F"),
            require = 0
    )
    private float cortim$clip(Camera instance, float desired) {
        if (Freecam.active) return desired;

        CameraTweaks c = ct();
        if (c != null && c.isEnabled() && c.clipThrough.get()) {
            return desired;
        }
        return this.clipToSpace(desired);
    }

    /**
     * Дистанция + F5-анимация.
     * Апдейт-цикл: считаем целевую дистанцию, плавно идём к ней.
     */
    @Inject(method = "update", at = @At("TAIL"), require = 0)
    private void cortim$distance(World area, Entity focusedEntity,
                                 boolean thirdPerson, boolean inverseView,
                                 float tickDelta, CallbackInfo ci) {
        if (Freecam.active) return;

        CameraTweaks c = ct();
        if (c == null || !c.isEnabled()) return;
        if (!thirdPerson) return;

        float target = c.cameraDistance.get();
        int animMs = c.f5Animation.get();

        // Плавный переход
        if (animMs > 0) {
            long now = System.currentTimeMillis();
            float dt = cortim$lastUpdateMs == 0L ? 16f : Math.min(100f, now - cortim$lastUpdateMs);
            cortim$lastUpdateMs = now;
            float t = Math.min(1f, dt / animMs);
            cortim$currentDist = cortim$currentDist + (target - cortim$currentDist) * t;
        } else {
            cortim$currentDist = target;
            cortim$lastUpdateMs = 0L;
        }

        // Применяем сдвиг
        Vec3d eye = focusedEntity.getEyePos();
        Vec3d fwd = Vec3d.fromPolar(focusedEntity.getPitch(), focusedEntity.getYaw());
        Vec3d pos = eye.add(fwd.multiply(-cortim$currentDist));
        this.setPos(pos);
    }
}