/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2IntMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongListIterator
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hlc;
import a.izx;
import a.kfa;
import a.kfe;
import a.qwo;
import a.unf;
import a.usn;
import a.uut;
import a.vhz;
import a.wcn;
import flow.dev.a;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongListIterator;
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
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;

public class lvp
extends kfe {
    private static final int lvq = -23296;
    private static final double lvr = 6400.0;
    private static final ConcurrentLinkedQueue<Long> lvs = new ConcurrentLinkedQueue();
    private static lvp lvt;
    private static boolean lvu;
    private static volatile long[] lvv;
    private static long lvw;
    private final LongLinkedOpenHashSet lvx = new LongLinkedOpenHashSet();
    private final Long2IntOpenHashMap lvy = new Long2IntOpenHashMap();
    private final Long2IntOpenHashMap lvz = new Long2IntOpenHashMap();
    private boolean lwa;
    private int lwb;
    private int lwc;
    private static /* synthetic */ int lwd;
    private static /* synthetic */ boolean lwe;

    public lvp() {
        super(a.b("\uf251\u8bea\u010a\u9f63", -294850035), a.b("\u52f5\u2b65\ua1b8\u3fc6\ub415\u32a1\u88fc\u0102\u9f41\u15f7\u9277\u6847\ue69f\u7f23\uf57a\u7387\uc9c3\u4608\udcef\u5afa\ud30c\ua95a\u27f9\ubc33\u3a56\ub0d4\u0935\u8773\u1d97\u9bd5\u1062\ueebe\u64f8\ufd08\u7b1f\uf1ec\u4e20\uc408\u42af\udb04\u5141\u2fc4\ua5d5\u226a\ub8b0\u36d3\u8f07\u05b1", -236498291), kfa.MISC);
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

    private static void lwf(Packet<?> packet) {
        BlockUpdateS2CPacket blockUpdateS2CPacket;
        lvp lvp2 = lvt;
        if (lvp2 == null || !lvp2.isEnabled()) {
            return;
        }
        if (packet instanceof ChunkDeltaUpdateS2CPacket) {
            ChunkDeltaUpdateS2CPacket chunkDeltaUpdateS2CPacket = (ChunkDeltaUpdateS2CPacket)packet;
            chunkDeltaUpdateS2CPacket.method_30621((blockPos, blockState) -> {
                if (blockState.method_27852(Blocks.field_22109)) {
                    lvs.add(blockPos.method_10063());
                }
            });
        } else if (packet instanceof BlockUpdateS2CPacket && (blockUpdateS2CPacket = (BlockUpdateS2CPacket)packet).method_11308().method_27852(Blocks.field_22109)) {
            lvs.add(blockUpdateS2CPacket.method_11309().method_10063());
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
    public void onEndTick(MinecraftClient minecraftClient) {
        Long2IntMap.Entry entry;
        Long l;
        ++this.lwc;
        wcn.ensure(minecraftClient);
        ClientWorld clientWorld = minecraftClient.field_1687;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientWorld == null || clientPlayerEntity == null) {
            lvs.clear();
            return;
        }
        while ((l = lvs.poll()) != null) {
            if (this.lvx.contains(l.longValue()) || this.lvz.containsKey(l.longValue())) continue;
            this.lvz.put(l.longValue(), this.lwc);
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        ObjectIterator objectIterator = this.lvz.long2IntEntrySet().iterator();
        while (objectIterator.hasNext()) {
            entry = (Long2IntMap.Entry)objectIterator.next();
            long l2 = entry.getLongKey();
            if (clientWorld.method_8320((BlockPos)mutable.method_16363(l2)).method_27852(Blocks.field_22109)) {
                objectIterator.remove();
                if (!this.lvx.add(l2)) continue;
                this.lvy.put(l2, this.lwc);
                this.lwa = true;
                this.lwb = 0;
                continue;
            }
            if (this.lwc - entry.getIntValue() <= 40) continue;
            objectIterator.remove();
        }
        ++this.lwb;
        if (this.lwa && this.lwb >= 5) {
            this.lwa = false;
            izx.alert(this.getName(), a.d("\ucefa\ub764\u3dbb\ua3c7\u2860\uaed2\u14f4\u9d06\u0351\u89e3\u0a2e", -1446818473, 1540130744) + this.lvx.size() + a.c(1298647633, "\uca60\ub7c5\u3d62\ua366\u28b6\uae08\u145e\u9dd2\u07e8\u8947\u0e9b\uf4e0\u7a32\ue381\u69d4\uef21\u5562"), vhz.INFO, true);
        }
        objectIterator = clientPlayerEntity.method_73189();
        entry = new BlockPos.Mutable();
        LongListIterator longListIterator = this.lvx.iterator();
        while (longListIterator.hasNext()) {
            boolean bl;
            long l3 = longListIterator.nextLong();
            entry.method_16363(l3);
            BlockState blockState = clientWorld.method_8320((BlockPos)entry);
            boolean bl2 = bl = !blockState.method_27852(Blocks.field_22109);
            if (!bl && !(entry.method_19770((Position)objectIterator) >= 6400.0) && clientWorld.method_2935().method_12123(entry.method_10263() >> 4, entry.method_10260() >> 4)) continue;
            longListIterator.remove();
            this.lvy.remove(l3);
        }
        lvv = this.lvx.toLongArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        lvp lvp2 = lvt;
        long[] lArray = lvp2 != null && lvp2.isEnabled() ? lvv : new long[]{};
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (lArray.length == 0 || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == lvw) {
            return;
        }
        lvw = unf.frame();
        try {
            usn2 = usn.capture(renderTickCounter.method_60637(true), drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        Vec3d vec3d = usn2.camera();
        uut.beginBatch();
        try {
            for (long l : lArray) {
                double d;
                double d2;
                double d3 = BlockPos.method_10061((long)l);
                if (usn2.depth(d3 + 0.5, (d2 = (double)BlockPos.method_10071((long)l)) + 0.5, (d = (double)BlockPos.method_10083((long)l)) + 0.5) < -1.0f) continue;
                qwo.cube(drawContext, usn2, vec3d, d3, d2, d, -23296, 0, 1.0f, 0.16f);
            }
        }
        finally {
            uut.endBatch();
        }
    }

    static {
        lvv = new long[0];
        lvw = -1L;
    }

    private static /* synthetic */ int azq(int n, int n2) {
        return n + n2 + 860088056;
    }

    private static /* synthetic */ int azr(int n, int n2) {
        return lvp.azq(n, n2) + n;
    }

    private static /* synthetic */ int azs(int n, int n2) {
        return (n ^ n2) + -2066412112;
    }
}

