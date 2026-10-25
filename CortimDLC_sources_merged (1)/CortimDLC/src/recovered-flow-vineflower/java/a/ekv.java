package a;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.BlockView;
import org.jspecify.annotations.Nullable;

final class ekv extends WorldRenderer {
   ekv() {
      super(null, null, null, null, null, null);
   }

   @Override
   public void tick(Camera camera) {
   }

   @Override
   public void setWorld(@Nullable ClientWorld world) {
   }

   @Override
   public void updateBlock(BlockView world, BlockPos pos, BlockState oldState, BlockState newState, int flags) {
   }

   @Override
   public void scheduleBlockRenders(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
   }

   @Override
   public void scheduleBlockRerenderIfNeeded(BlockPos pos, BlockState old, BlockState updated) {
   }

   @Override
   public void scheduleChunkRenders3x3x3(int x, int y, int z) {
   }

   @Override
   public void scheduleChunkRenders(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
   }

   @Override
   public void scheduleChunkRender(int chunkX, int chunkY, int chunkZ) {
   }

   @Override
   public void onChunkUnload(long sectionPos) {
   }

   @Override
   public void setBlockBreakingInfo(int entityId, BlockPos pos, int stage) {
   }

   @Override
   public void scheduleNeighborUpdates(ChunkPos chunkPos) {
   }

   @Override
   public void scheduleTerrainUpdate() {
   }

   @Override
   public boolean isRenderingReady(BlockPos pos) {
      return true;
   }
}
