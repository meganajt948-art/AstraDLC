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
        return this.method_35754();
    }

    void copyMaps(Map<MapIdComponent, MapState> map) {
        this.method_35753(map);
    }

    public void method_8413(BlockPos blockPos, BlockState blockState, BlockState blockState2, int n) {
    }

    public void method_16109(BlockPos blockPos, BlockState blockState, BlockState blockState2) {
    }

    public void method_18113(int n, int n2, int n3) {
    }

    public void method_62146(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void method_8517(int n, BlockPos blockPos, int n2) {
    }

    public void method_62895(long l) {
    }

    public void method_8474(int n, BlockPos blockPos, int n2) {
    }

    public void method_8444(@Nullable Entity entity, int n, BlockPos blockPos, int n2) {
    }

    public void method_8406(ParticleEffect particleEffect, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_8466(ParticleEffect particleEffect, boolean bl, boolean bl2, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_8494(ParticleEffect particleEffect, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_17452(ParticleEffect particleEffect, boolean bl, double d, double d2, double d3, double d4, double d5, double d6) {
    }

    public void method_8547(double d, double d2, double d3, double d4, double d5, double d6, List<FireworkExplosionComponent> list) {
    }

    public void method_31595(BlockPos blockPos, BlockState blockState) {
    }

    public void method_74254(BlockPos blockPos, Direction direction) {
    }

    public void method_73228(Vec3d vec3d, float f, int n, Pool<BlockParticleEffect> pool) {
    }

    public void method_8465(@Nullable Entity entity, double d, double d2, double d3, RegistryEntry<SoundEvent> registryEntry, SoundCategory soundCategory, float f, float f2, long l) {
    }

    public void method_8449(@Nullable Entity entity, Entity entity2, RegistryEntry<SoundEvent> registryEntry, SoundCategory soundCategory, float f, float f2, long l) {
    }

    public void method_55116(Entity entity, SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2) {
    }

    public void method_67392(SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2) {
    }

    public void method_8486(double d, double d2, double d3, SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2, boolean bl) {
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

