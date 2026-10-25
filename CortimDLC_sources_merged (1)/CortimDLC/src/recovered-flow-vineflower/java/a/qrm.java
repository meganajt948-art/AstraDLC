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
            this.qrw(var2.method_11309().method_10063());
         } else if (var1 instanceof ChunkDeltaUpdateS2CPacket var3) {
            var3.method_30621((var1x, var2x) -> this.qrw(var1x.method_10063()));
         } else if (var1 instanceof ChunkDataS2CPacket var4) {
            this.qrq.add(ChunkPos.method_8331(var4.method_11523(), var4.method_11524()));
         } else if (var1 instanceof BundlePacket var5) {
            for (Packet var7 : var5.method_48324()) {
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

      long var4 = var2.method_10063();
      BlockState var6 = var1.method_8320(var2);
      if (!var6.method_26215() && !this.qrn.containsKey(var4)) {
         BlockState var7 = var1.method_8316(var2).method_15759();
         this.qrn.put(var4, new qrh(var6, var3));
         this.qro.add(var4);
         var1.method_8652(var2, var7, 11);
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
                  BlockPos var5 = BlockPos.method_10092(var4.getLongKey());
                  if (var1.method_8320(var5).method_26215() && var1.method_8393(var5.method_10263() >> 4, var5.method_10260() >> 4)) {
                     var1.method_8652(var5, ((qrh)var4.getValue()).was(), 11);
                     this.qrt++;
                  }

                  var3.remove();
                  this.qro.remove(var5.method_10063());
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
            if (ChunkPos.method_8331(BlockPos.method_10061(var5) >> 4, BlockPos.method_10083(var5) >> 4) == var2) {
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
            BlockPos var4 = BlockPos.method_10092(var3.getLongKey());
            if (var1.method_8320(var4).method_26215() && var1.method_8393(var4.method_10263() >> 4, var4.method_10260() >> 4)) {
               var1.method_8652(var4, ((qrh)var3.getValue()).was(), 11);
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
