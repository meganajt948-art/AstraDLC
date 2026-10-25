package a;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import org.jspecify.annotations.Nullable;

final class ekm extends ParticleManager {
   ekm() {
      super(null, null);
   }

   @Override
   public void addEmitter(Entity entity, ParticleEffect parameters) {
   }

   @Override
   public void addEmitter(Entity entity, ParticleEffect parameters, int maxAge) {
   }

   @Override
   public @Nullable Particle addParticle(ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
      return null;
   }

   @Override
   public void addParticle(Particle particle) {
   }

   @Override
   public void tick() {
   }

   @Override
   public void setWorld(@Nullable ClientWorld world) {
   }

   @Override
   public void clearParticles() {
   }
}
