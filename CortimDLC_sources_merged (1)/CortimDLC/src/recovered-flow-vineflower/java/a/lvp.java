package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongListIterator;
import it.unimi.dsi.fastutil.longs.Long2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;

public class lvp extends kfe {
   static final int lvq = -23296;
   static final double lvr = 6400.0;
   static final ConcurrentLinkedQueue<Long> lvs = new ConcurrentLinkedQueue<>();
   static lvp lvt;
   static boolean lvu;
   static volatile long[] lvv = new long[0];
   static long lvw = -1L;
   final LongLinkedOpenHashSet lvx = new LongLinkedOpenHashSet();
   final Long2IntOpenHashMap lvy = new Long2IntOpenHashMap();
   final Long2IntOpenHashMap lvz = new Long2IntOpenHashMap();
   boolean lwa;
   int lwb;
   int lwc;

   public lvp() {
      super(a.b("\uf251诪Ċ齣", -294850035), a.b("勵⭥ꆸ㿆됕㊡裼Ă齁ᗷ鉷桇\ue69f缣\uf57a率짃䘈\udcef嫺파\ua95a⟹밳㩖냔व蝳ᶗ鯕ၢ\ueebe擸ﴈ笟\uf1ec丠쐈䊯\udb04允⿄ꗕ≪뢰㛓輇ֱ", -236498291), kfa.MISC);
      lvt = this;
      if (!lvu) {
         lvu = true;
         wcn.listen(lvp::lwf);
      }
   }

   public static lvp get() {
      return lvt;
   }

   public LongLinkedOpenHashSet found() {
      return this.lvx;
   }

   static void lwf(Packet<?> var0) {
      lvp var1 = lvt;
      if (var1 != null && var1.isEnabled()) {
         if (var0 instanceof ChunkDeltaUpdateS2CPacket var2) {
            var2.visitUpdates((var0x, var1x) -> {
               if (var1x.isOf(Blocks.ANCIENT_DEBRIS)) {
                  lvs.add(var0x.asLong());
               }
            });
         } else if (var0 instanceof BlockUpdateS2CPacket var3 && var3.getState().isOf(Blocks.ANCIENT_DEBRIS)) {
            lvs.add(var3.getPos().asLong());
         }
      }
   }

   @Override
   protected void onEnable() {
      this.lwg();
   }

   @Override
   protected void onDisable() {
      this.lwg();
   }

   void lwg() {
      this.lvx.clear();
      this.lvy.clear();
      this.lvz.clear();
      lvs.clear();
      lvv = new long[0];
      this.lwa = false;
      this.lwb = 0;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.lwc++;
      wcn.ensure(var1);
      ClientWorld var2 = var1.world;
      ClientPlayerEntity var3 = var1.player;
      if (var2 != null && var3 != null) {
         Long var4;
         while ((var4 = lvs.poll()) != null) {
            if (!this.lvx.contains(var4) && !this.lvz.containsKey(var4)) {
               this.lvz.put(var4, this.lwc);
            }
         }

         Mutable var5 = new Mutable();
         ObjectIterator var6 = this.lvz.long2IntEntrySet().iterator();

         while (var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            long var8 = var7.getLongKey();
            if (var2.getBlockState(var5.set(var8)).isOf(Blocks.ANCIENT_DEBRIS)) {
               var6.remove();
               if (this.lvx.add(var8)) {
                  this.lvy.put(var8, this.lwc);
                  this.lwa = true;
                  this.lwb = 0;
               }
            } else if (this.lwc - var7.getIntValue() > 40) {
               var6.remove();
            }
         }

         this.lwb++;
         if (this.lwa && this.lwb >= 5) {
            this.lwa = false;
            izx.alert(
               this.getName(),
               a.d("컺띤㶻ꏇ⡠껒ᓴ鴆͑解ਮ", -1446818473, 1540130744) + this.lvx.size() + a.c(1298647633, "쩠럅㵢ꍦ⢶금ᑞ鷒ߨ襇ປ\uf4e0稲\ue381槔\uef21啢"),
               vhz.INFO,
               true
            );
         }

         Vec3d var13 = var3.getEntityPos();
         Mutable var14 = new Mutable();
         LongListIterator var15 = this.lvx.iterator();

         while (var15.hasNext()) {
            long var9 = var15.nextLong();
            var14.set(var9);
            BlockState var11 = var2.getBlockState(var14);
            boolean var12 = !var11.isOf(Blocks.ANCIENT_DEBRIS);
            if (var12 || var14.getSquaredDistance(var13) >= 6400.0 || !var2.getChunkManager().isChunkLoaded(var14.getX() >> 4, var14.getZ() >> 4)) {
               var15.remove();
               this.lvy.remove(var9);
            }
         }

         lvv = this.lvx.toLongArray();
      } else {
         lvs.clear();
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      lvp var2 = lvt;
      long[] var3 = var2 != null && var2.isEnabled() ? lvv : new long[0];
      MinecraftClient var4 = MinecraftClient.getInstance();
      if (var3.length != 0 && var4.world != null && var4.player != null && !var4.options.hudHidden && !(var4.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != lvw) {
            lvw = unf.frame();

            usn var5;
            try {
               var5 = usn.capture(var1.getTickProgress(true), var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
            } catch (Throwable var21) {
               return;
            }

            uut.beginFrame();
            Vec3d var6 = var5.camera();
            uut.beginBatch();

            try {
               for (long var10 : var3) {
                  double var12 = BlockPos.unpackLongX(var10);
                  double var14 = BlockPos.unpackLongY(var10);
                  double var16 = BlockPos.unpackLongZ(var10);
                  if (!(var5.depth(var12 + 0.5, var14 + 0.5, var16 + 0.5) < -1.0F)) {
                     qwo.cube(var0, var5, var6, var12, var14, var16, -23296, 0, 1.0F, 0.16F);
                  }
               }
            } finally {
               uut.endBatch();
            }
         }
      }
   }
}
