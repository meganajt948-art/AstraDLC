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
   private static final int lvq = -23296;
   private static final double lvr = 6400.0;
   private static final ConcurrentLinkedQueue<Long> lvs = new ConcurrentLinkedQueue<>();
   private static lvp lvt;
   private static boolean lvu;
   private static volatile long[] lvv = new long[0];
   private static long lvw = -1L;
   private final LongLinkedOpenHashSet lvx = new LongLinkedOpenHashSet();
   private final Long2IntOpenHashMap lvy = new Long2IntOpenHashMap();
   private final Long2IntOpenHashMap lvz = new Long2IntOpenHashMap();
   private boolean lwa;
   private int lwb;
   private int lwc;

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

   private static void lwf(Packet<?> var0) {
      lvp var1 = lvt;
      if (var1 != null && var1.isEnabled()) {
         if (var0 instanceof ChunkDeltaUpdateS2CPacket var2) {
            var2.method_30621((var0x, var1x) -> {
               if (var1x.method_27852(Blocks.field_22109)) {
                  lvs.add(var0x.method_10063());
               }
            });
         } else if (var0 instanceof BlockUpdateS2CPacket var3 && var3.method_11308().method_27852(Blocks.field_22109)) {
            lvs.add(var3.method_11309().method_10063());
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

   private void lwg() {
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
      ClientWorld var2 = var1.field_1687;
      ClientPlayerEntity var3 = var1.field_1724;
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
            if (var2.method_8320(var5.method_16363(var8)).method_27852(Blocks.field_22109)) {
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

         Vec3d var13 = var3.method_73189();
         Mutable var14 = new Mutable();
         LongListIterator var15 = this.lvx.iterator();

         while (var15.hasNext()) {
            long var9 = var15.nextLong();
            var14.method_16363(var9);
            BlockState var11 = var2.method_8320(var14);
            boolean var12 = !var11.method_27852(Blocks.field_22109);
            if (var12 || var14.method_19770(var13) >= 6400.0 || !var2.method_2935().method_12123(var14.method_10263() >> 4, var14.method_10260() >> 4)) {
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
      MinecraftClient var4 = MinecraftClient.method_1551();
      if (var3.length != 0 && var4.field_1687 != null && var4.field_1724 != null && !var4.field_1690.field_1842 && !(var4.field_1755 instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != lvw) {
            lvw = unf.frame();

            usn var5;
            try {
               var5 = usn.capture(var1.method_60637(true), var0.method_51421(), var0.method_51443());
            } catch (Throwable var21) {
               return;
            }

            uut.beginFrame();
            Vec3d var6 = var5.camera();
            uut.beginBatch();

            try {
               for (long var10 : var3) {
                  double var12 = BlockPos.method_10061(var10);
                  double var14 = BlockPos.method_10071(var10);
                  double var16 = BlockPos.method_10083(var10);
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
