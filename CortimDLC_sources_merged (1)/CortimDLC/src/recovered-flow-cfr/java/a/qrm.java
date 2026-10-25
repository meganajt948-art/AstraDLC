/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.minecraft.block.BlockState
 *  net.minecraft.network.packet.BundlePacket
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.World
 */
package a;

import a.qrh;
import flow.dev.a;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
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
    private final ConcurrentLinkedQueue<Long> qrp = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue<Long> qrq = new ConcurrentLinkedQueue();
    private World qrr;
    private int qrs;
    private int qrt;
    private static /* synthetic */ boolean qru;
    private static /* synthetic */ String qrv;

    qrm() {
    }

    void echo(Packet<?> packet) {
        if (this.qro.isEmpty()) {
            return;
        }
        if (packet instanceof BlockUpdateS2CPacket) {
            BlockUpdateS2CPacket blockUpdateS2CPacket = (BlockUpdateS2CPacket)packet;
            this.qrw(blockUpdateS2CPacket.method_11309().method_10063());
        } else if (packet instanceof ChunkDeltaUpdateS2CPacket) {
            ChunkDeltaUpdateS2CPacket chunkDeltaUpdateS2CPacket = (ChunkDeltaUpdateS2CPacket)packet;
            chunkDeltaUpdateS2CPacket.method_30621((blockPos, blockState) -> this.qrw(blockPos.method_10063()));
        } else if (packet instanceof ChunkDataS2CPacket) {
            ChunkDataS2CPacket chunkDataS2CPacket = (ChunkDataS2CPacket)packet;
            this.qrq.add(ChunkPos.method_8331((int)chunkDataS2CPacket.method_11523(), (int)chunkDataS2CPacket.method_11524()));
        } else if (packet instanceof BundlePacket) {
            BundlePacket bundlePacket = (BundlePacket)packet;
            for (Packet packet2 : bundlePacket.method_48324()) {
                this.echo(packet2);
            }
        }
    }

    private void qrw(long l) {
        if (this.qro.contains(l)) {
            this.qrp.add(l);
        }
    }

    boolean isGhost(long l) {
        return this.qrn.containsKey(l);
    }

    String describe() {
        return this.qrs + a.d("\uc741\ubea0\u3471\uaa17\u21c1\ua77d\u1d24\u94c2\u0a8c\u803c\u07a7\ufdda", -1736173981, -1989947122) + this.qrt + a.b("\ua4c5\udd36\u57e6\uc995\u424a", 1654826208);
    }

    void ghost(World world, BlockPos blockPos, int n) {
        if (this.qrr != world) {
            this.qry();
            this.qrr = world;
        }
        long l = blockPos.method_10063();
        BlockState blockState = world.method_8320(blockPos);
        if (blockState.method_26215() || this.qrn.containsKey(l)) {
            return;
        }
        BlockState blockState2 = world.method_8316(blockPos).method_15759();
        this.qrn.put(l, (Object)new qrh(blockState, n));
        this.qro.add(l);
        world.method_8652(blockPos, blockState2, 11);
        ++this.qrs;
    }

    void tick(World world, int n) {
        if (this.qrr != world) {
            this.qry();
            this.qrr = world;
            return;
        }
        this.qrx();
        if (this.qrn.isEmpty()) {
            return;
        }
        ObjectIterator objectIterator = this.qrn.long2ObjectEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            Long2ObjectMap.Entry entry = (Long2ObjectMap.Entry)objectIterator.next();
            if (((qrh)entry.getValue()).until() > n) continue;
            BlockPos blockPos = BlockPos.method_10092((long)entry.getLongKey());
            if (world.method_8320(blockPos).method_26215() && world.method_8393(blockPos.method_10263() >> 4, blockPos.method_10260() >> 4)) {
                world.method_8652(blockPos, ((qrh)entry.getValue()).was(), 11);
                ++this.qrt;
            }
            objectIterator.remove();
            this.qro.remove(blockPos.method_10063());
        }
    }

    private void qrx() {
        Long l;
        while ((l = this.qrp.poll()) != null) {
            if (this.qrn.remove(l.longValue()) == null) continue;
            this.qro.remove(l);
        }
        while ((l = this.qrq.poll()) != null) {
            long l2 = l;
            ObjectIterator objectIterator = this.qrn.long2ObjectEntrySet().fastIterator();
            while (objectIterator.hasNext()) {
                long l3 = ((Long2ObjectMap.Entry)objectIterator.next()).getLongKey();
                if (ChunkPos.method_8331((int)(BlockPos.method_10061((long)l3) >> 4), (int)(BlockPos.method_10083((long)l3) >> 4)) != l2) continue;
                objectIterator.remove();
                this.qro.remove(l3);
            }
        }
    }

    void restore(World world) {
        if (this.qrr == world && world != null) {
            this.qrx();
            for (Long2ObjectMap.Entry entry : this.qrn.long2ObjectEntrySet()) {
                BlockPos blockPos = BlockPos.method_10092((long)entry.getLongKey());
                if (!world.method_8320(blockPos).method_26215() || !world.method_8393(blockPos.method_10263() >> 4, blockPos.method_10260() >> 4)) continue;
                world.method_8652(blockPos, ((qrh)entry.getValue()).was(), 11);
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

    private static /* synthetic */ int bve(int n, int n2) {
        return n * n2 + 1531635246;
    }
}

