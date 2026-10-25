/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.world.ClientWorld$Properties
 *  net.minecraft.component.type.FireworkExplosionComponent
 *  net.minecraft.component.type.MapIdComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.map.MapState
 *  net.minecraft.particle.BlockParticleEffect
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.util.collection.Pool
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraft.world.dimension.DimensionType
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.dtv;
import java.util.List;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
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

final class elh
extends ClientWorld {
    private final dtv eli;
    private static /* synthetic */ String elj;
    private static /* synthetic */ long elk;

    elh(ClientPlayNetworkHandler clientPlayNetworkHandler, ClientWorld.Properties properties, RegistryKey<World> registryKey, RegistryEntry<DimensionType> registryEntry, int n, int n2, WorldRenderer worldRenderer, boolean bl, long l, int n3, dtv dtv2) {
        super(clientPlayNetworkHandler, properties, registryKey, registryEntry, n, n2, worldRenderer, bl, l, n3);
        this.eli = dtv2;
    }

    dtv bot() {
        return this.eli;
    }

    Map<MapIdComponent, MapState> maps() {
        return this.getMapStates();
    }

    void copyMaps(Map<MapIdComponent, MapState> map) {
        this.putMapStates(map);
    }

    public void updateListeners(BlockPos pos, BlockState oldState, BlockState newState, int flags) {
    }

    public void scheduleBlockRerenderIfNeeded(BlockPos pos, BlockState old, BlockState updated) {
    }

    public void scheduleBlockRenders(int x, int y, int z) {
    }

    public void scheduleChunkRenders(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
    }

    public void setBlockBreakingInfo(int entityId, BlockPos pos, int progress) {
    }

    public void onChunkUnload(long sectionPos) {
    }

    public void syncGlobalEvent(int eventId, BlockPos pos, int data) {
    }

    public void syncWorldEvent(@Nullable Entity source, int eventId, BlockPos pos, int data) {
    }

    public void addParticleClient(ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
    }

    public void addParticleClient(ParticleEffect parameters, boolean force, boolean canSpawnOnMinimal, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
    }

    public void addImportantParticleClient(ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
    }

    public void addImportantParticleClient(ParticleEffect parameters, boolean force, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
    }

    public void addFireworkParticle(double x, double y, double z, double velocityX, double velocityY, double velocityZ, List<FireworkExplosionComponent> explosions) {
    }

    public void addBlockBreakParticles(BlockPos pos, BlockState state) {
    }

    public void spawnBlockBreakingParticle(BlockPos pos, Direction direction) {
    }

    public void addBlockParticleEffects(Vec3d center, float radius, int blockCount, Pool<BlockParticleEffect> particles) {
    }

    public void playSound(@Nullable Entity source, double x, double y, double z, RegistryEntry<SoundEvent> sound, SoundCategory category, float volume, float pitch, long seed) {
    }

    public void playSoundFromEntity(@Nullable Entity source, Entity entity, RegistryEntry<SoundEvent> sound, SoundCategory category, float volume, float pitch, long seed) {
    }

    public void playSoundFromEntityClient(Entity entity, SoundEvent sound, SoundCategory category, float volume, float pitch) {
    }

    public void playSoundClient(SoundEvent sound, SoundCategory category, float volume, float pitch) {
    }

    public void playSoundClient(double x, double y, double z, SoundEvent sound, SoundCategory category, float volume, float pitch, boolean useDistance) {
    }

    private static /* synthetic */ int gz(int n, int n2) {
        return n + n2 | 0x448EAA22;
    }

    private static /* synthetic */ int ha(int n, int n2) {
        return elh.gz(n, n2) * n2;
    }

    private static /* synthetic */ int hb(int n, int n2) {
        return n + n2 ^ 0x4F6AABF2;
    }
}

