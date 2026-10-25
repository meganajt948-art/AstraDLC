package a;

import java.util.List;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.ClientWorld.Properties;
import net.minecraft.component.type.FireworkExplosionComponent;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.entity.Entity;
import net.minecraft.item.map.MapState;
import net.minecraft.particle.BlockParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.jspecify.annotations.Nullable;

final class elh extends ClientWorld {
   private final dtv eli;

   elh(
      ClientPlayNetworkHandler var1,
      Properties var2,
      RegistryKey<World> var3,
      RegistryEntry<DimensionType> var4,
      int var5,
      int var6,
      WorldRenderer var7,
      boolean var8,
      long var9,
      int var11,
      dtv var12
   ) {
      super(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11);
      this.eli = var12;
   }

   dtv bot() {
      return this.eli;
   }

   Map<MapIdComponent, MapState> maps() {
      return this.getMapStates();
   }

   void copyMaps(Map<MapIdComponent, MapState> var1) {
      this.putMapStates(var1);
   }

   @Override
   public void updateListeners(BlockPos pos, BlockState oldState, BlockState newState, int flags) {
   }

   @Override
   public void scheduleBlockRerenderIfNeeded(BlockPos pos, BlockState old, BlockState updated) {
   }

   @Override
   public void scheduleBlockRenders(int x, int y, int z) {
   }

   @Override
   public void scheduleChunkRenders(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
   }

   @Override
   public void setBlockBreakingInfo(int entityId, BlockPos pos, int progress) {
   }

   @Override
   public void onChunkUnload(long sectionPos) {
   }

   @Override
   public void syncGlobalEvent(int eventId, BlockPos pos, int data) {
   }

   @Override
   public void syncWorldEvent(@Nullable Entity source, int eventId, BlockPos pos, int data) {
   }

   @Override
   public void addParticleClient(ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
   }

   @Override
   public void addParticleClient(
      ParticleEffect parameters, boolean force, boolean canSpawnOnMinimal, double x, double y, double z, double velocityX, double velocityY, double velocityZ
   ) {
   }

   @Override
   public void addImportantParticleClient(ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
   }

   @Override
   public void addImportantParticleClient(
      ParticleEffect parameters, boolean force, double x, double y, double z, double velocityX, double velocityY, double velocityZ
   ) {
   }

   @Override
   public void addFireworkParticle(
      double x, double y, double z, double velocityX, double velocityY, double velocityZ, List<FireworkExplosionComponent> explosions
   ) {
   }

   @Override
   public void addBlockBreakParticles(BlockPos pos, BlockState state) {
   }

   @Override
   public void spawnBlockBreakingParticle(BlockPos pos, Direction direction) {
   }

   @Override
   public void addBlockParticleEffects(Vec3d center, float radius, int blockCount, Pool<BlockParticleEffect> particles) {
   }

   @Override
   public void playSound(
      @Nullable Entity source, double x, double y, double z, RegistryEntry<SoundEvent> sound, SoundCategory category, float volume, float pitch, long seed
   ) {
   }

   @Override
   public void playSoundFromEntity(
      @Nullable Entity source, Entity entity, RegistryEntry<SoundEvent> sound, SoundCategory category, float volume, float pitch, long seed
   ) {
   }

   @Override
   public void playSoundFromEntityClient(Entity entity, SoundEvent sound, SoundCategory category, float volume, float pitch) {
   }

   @Override
   public void playSoundClient(SoundEvent sound, SoundCategory category, float volume, float pitch) {
   }

   @Override
   public void playSoundClient(double x, double y, double z, SoundEvent sound, SoundCategory category, float volume, float pitch, boolean useDistance) {
   }
}
