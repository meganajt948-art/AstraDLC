package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParticleManager.class)
public class ParticleManagerMixin {

    @Inject(method = "addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)Lnet/minecraft/client/particle/Particle;",
            at = @At("HEAD"), cancellable = true)
    private void cortim$particles(ParticleEffect effect, double x, double y, double z,
                                  double vx, double vy, double vz,
                                  CallbackInfoReturnable<Particle> cir) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n == null || !n.isEnabled()) return;

        ParticleType<?> t = effect.getType();

        if (n.explosionParticles_get()) {
            if (t == ParticleTypes.EXPLOSION || t == ParticleTypes.EXPLOSION_EMITTER) {
                cir.setReturnValue(null);
                return;
            }
        }
        if (n.blockParticles_get()) {
            if (t == ParticleTypes.BLOCK || t == ParticleTypes.BLOCK_MARKER) {
                cir.setReturnValue(null);
                return;
            }
        }
        if (n.effects_get()) {
            if (t == ParticleTypes.EFFECT || t == ParticleTypes.ENTITY_EFFECT
                    || t == ParticleTypes.INSTANT_EFFECT) {
                cir.setReturnValue(null);
                return;
            }
        }
        if (n.weather_get()) {
            if (t == ParticleTypes.RAIN || t == ParticleTypes.SNOWFLAKE) {
                cir.setReturnValue(null);
            }
        }
    }
}