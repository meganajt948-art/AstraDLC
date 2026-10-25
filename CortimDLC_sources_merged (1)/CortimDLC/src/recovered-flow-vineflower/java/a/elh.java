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
      return this.method_35754();
   }

   void copyMaps(Map<MapIdComponent, MapState> var1) {
      this.method_35753(var1);
   }

   public void method_8413(BlockPos var1, BlockState var2, BlockState var3, int var4) {
   }

   public void method_16109(BlockPos var1, BlockState var2, BlockState var3) {
   }

   public void method_18113(int var1, int var2, int var3) {
   }

   public void method_62146(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public void method_8517(int var1, BlockPos var2, int var3) {
   }

   public void method_62895(long var1) {
   }

   public void method_8474(int var1, BlockPos var2, int var3) {
   }

   public void method_8444(@Nullable Entity var1, int var2, BlockPos var3, int var4) {
   }

   public void method_8406(ParticleEffect var1, double var2, double var4, double var6, double var8, double var10, double var12) {
   }

   public void method_8466(ParticleEffect var1, boolean var2, boolean var3, double var4, double var6, double var8, double var10, double var12, double var14) {
   }

   public void method_8494(ParticleEffect var1, double var2, double var4, double var6, double var8, double var10, double var12) {
   }

   public void method_17452(ParticleEffect var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13) {
   }

   public void method_8547(double var1, double var3, double var5, double var7, double var9, double var11, List<FireworkExplosionComponent> var13) {
   }

   public void method_31595(BlockPos var1, BlockState var2) {
   }

   public void method_74254(BlockPos var1, Direction var2) {
   }

   public void method_73228(Vec3d var1, float var2, int var3, Pool<BlockParticleEffect> var4) {
   }

   public void method_8465(
      @Nullable Entity var1, double var2, double var4, double var6, RegistryEntry<SoundEvent> var8, SoundCategory var9, float var10, float var11, long var12
   ) {
   }

   public void method_8449(@Nullable Entity var1, Entity var2, RegistryEntry<SoundEvent> var3, SoundCategory var4, float var5, float var6, long var7) {
   }

   public void method_55116(Entity var1, SoundEvent var2, SoundCategory var3, float var4, float var5) {
   }

   public void method_67392(SoundEvent var1, SoundCategory var2, float var3, float var4) {
   }

   public void method_8486(double var1, double var3, double var5, SoundEvent var7, SoundCategory var8, float var9, float var10, boolean var11) {
   }
}
