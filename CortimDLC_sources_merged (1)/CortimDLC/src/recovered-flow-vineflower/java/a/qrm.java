package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.block.BlockState;
import net.minecraft.network.packet.BundlePacket;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

final class qrm {
   private final Long2ObjectOpenHashMap<qrh> qrn = new Long2ObjectOpenHashMap();
   private final Set<Long> qro = ConcurrentHashMap.newKeySet();
   private final ConcurrentLinkedQueue<Long> qrp = new ConcurrentLinkedQueue<>();
   private final ConcurrentLinkedQueue<Long> qrq = new ConcurrentLinkedQueue<>();
   private World qrr;
   private int qrs;
   private int qrt;

   void echo(Packet<?> var1) {
      if (!this.qro.isEmpty()) {
         if (var1 instanceof BlockUpdateS2CPacket var2) {
            this.qrw(var2.getPos().asLong());
         } else if (var1 instanceof ChunkDeltaUpdateS2CPacket var3) {
            var3.visitUpdates((var1x, var2x) -> this.qrw(var1x.asLong()));
         } else if (var1 instanceof ChunkDataS2CPacket var4) {
            this.qrq.add(ChunkPos.toLong(var4.getChunkX(), var4.getChunkZ()));
         } else if (var1 instanceof BundlePacket var5) {
            for (Packet var7 : var5.getPackets()) {
               this.echo(var7);
            }
         }
      }
   }

   private void qrw(long var1) {
      if (this.qro.contains(var1)) {
         this.qrp.add(var1);
      }
   }

   boolean isGhost(long var1) {
      return this.qrn.containsKey(var1);
   }

   String describe() {
      return this.qrs + a.d("읁뺠㑱ꨗ⇁Ᵹᴤ铂ઌ耼ާ\ufdda", -1736173981, -1989947122) + this.qrt + a.b("꓅\udd36埦즕䉊", 1654826208);
   }

   void ghost(World var1, BlockPos var2, int var3) {
      if (this.qrr != var1) {
         this.qry();
         this.qrr = var1;
      }

      long var4 = var2.asLong();
      BlockState var6 = var1.getBlockState(var2);
      if (!var6.isAir() && !this.qrn.containsKey(var4)) {
         BlockState var7 = var1.getFluidState(var2).getBlockState();
         this.qrn.put(var4, new qrh(var6, var3));
         this.qro.add(var4);
         var1.setBlockState(var2, var7, 11);
         this.qrs++;
      }
   }

   void tick(World var1, int var2) {
      if (this.qrr != var1) {
         this.qry();
         this.qrr = var1;
      } else {
         this.qrx();
         if (!this.qrn.isEmpty()) {
            ObjectIterator var3 = this.qrn.long2ObjectEntrySet().fastIterator();

            while (var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               if (((qrh)var4.getValue()).until() <= var2) {
                  BlockPos var5 = BlockPos.fromLong(var4.getLongKey());
                  if (var1.getBlockState(var5).isAir() && var1.isChunkLoaded(var5.getX() >> 4, var5.getZ() >> 4)) {
                     var1.setBlockState(var5, ((qrh)var4.getValue()).was(), 11);
                     this.qrt++;
                  }

                  var3.remove();
                  this.qro.remove(var5.asLong());
               }
            }
         }
      }
   }

   private void qrx() {
      Long var1;
      while ((var1 = this.qrp.poll()) != null) {
         if (this.qrn.remove(var1) != null) {
            this.qro.remove(var1);
         }
      }

      while ((var1 = this.qrq.poll()) != null) {
         long var2 = var1;
         ObjectIterator var4 = this.qrn.long2ObjectEntrySet().fastIterator();

         while (var4.hasNext()) {
            long var5 = ((Entry)var4.next()).getLongKey();
            if (ChunkPos.toLong(BlockPos.unpackLongX(var5) >> 4, BlockPos.unpackLongZ(var5) >> 4) == var2) {
               var4.remove();
               this.qro.remove(var5);
            }
         }
      }
   }

   void restore(World var1) {
      if (this.qrr == var1 && var1 != null) {
         this.qrx();
         ObjectIterator var2 = this.qrn.long2ObjectEntrySet().iterator();

         while (var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            BlockPos var4 = BlockPos.fromLong(var3.getLongKey());
            if (var1.getBlockState(var4).isAir() && var1.isChunkLoaded(var4.getX() >> 4, var4.getZ() >> 4)) {
               var1.setBlockState(var4, ((qrh)var3.getValue()).was(), 11);
            }
         }
      }

      this.qry();
   }

   private void qry() {
      this.qrn.clear();
      this.qro.clear();
      this.qrp.clear();
      this.qrq.clear();
   }
}
