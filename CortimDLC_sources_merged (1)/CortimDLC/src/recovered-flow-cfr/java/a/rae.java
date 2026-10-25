/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ShulkerBoxBlock
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.registry.Registries
 *  net.minecraft.util.DyeColor
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.chunk.ChunkSection
 *  net.minecraft.world.chunk.ChunkStatus
 *  net.minecraft.world.chunk.WorldChunk
 */
package a;

import a.hlc;
import a.kfa;
import a.kfe;
import a.qzt;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vkl;
import a.vla;
import a.vlg;
import a.vlj;
import a.vlv;
import a.vmc;
import a.wcn;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.WorldChunk;

public class rae
extends kfe {
    private static rae raf;
    private final vlj rag = this.add(new vlj("Blocks", vlg.BLOCKS, "minecraft:diamond_ore", "minecraft:deepslate_diamond_ore", "minecraft:ancient_debris", "minecraft:emerald_ore", "minecraft:deepslate_emerald_ore", "minecraft:gold_ore", "minecraft:deepslate_gold_ore", "minecraft:spawner", "minecraft:chest", "minecraft:trapped_chest", "minecraft:ender_chest", "minecraft:barrel"));
    private final vlv rah = this.add(new vlv("Mode", "Box", "Box", "Corners", "Fill"));
    private final vkl rai = this.add(new vkl("Block colors", true));
    private final vla raj = this.add(new vla("Color", "Theme"));
    private final vmc rak = this.add(new vmc("Range", 48.0, 16.0, 128.0, 8.0).suffix("blocks"));
    private final vmc ral = this.add(new vmc("Fill", 0.18, 0.0, 0.6, 0.02).percent());
    private final vmc ram = this.add(new vmc("Width", 1.0, 0.5, 2.5, 0.1));
    private final vmc ran = this.add(new vmc("Limit", 300.0, 50.0, 1000.0, 50.0));
    private static final long rao = 1500000L;
    private final Long2IntOpenHashMap rap = new Long2IntOpenHashMap();
    private static final int[][] raq;
    private final Long2ObjectOpenHashMap<List<qzt>> rar = new Long2ObjectOpenHashMap();
    private final LongLinkedOpenHashSet ras = new LongLinkedOpenHashSet();
    private final LongLinkedOpenHashSet rat = new LongLinkedOpenHashSet();
    private static final Set<Long> rau;
    private boolean[] rav = new boolean[0];
    private int raw = -1;
    private ClientWorld rax;
    private final List<qzt> ray = new ArrayList<qzt>();
    private int raz;
    private long rba = -1L;
    private final double[][] rbb = new double[8][3];
    private final float[][] rbc = new float[8][2];
    private final boolean[] rbd = new boolean[8];
    private final boolean[] rbe = new boolean[6];
    private final float[] rbf = new float[4];
    private final float[] rbg = new float[2];
    private static final int[][] rbh;
    private static final int[][] rbi;
    private boolean rbj;
    private static /* synthetic */ String rbk;
    private static /* synthetic */ int rbl;

    public rae() {
        super(new String(new char[]{'B', 'l', 'o', 'c', 'k', 'E', 'S', 'P'}), "Chosen blocks seen through walls", kfa.RENDER);
        raf = this;
        wcn.listen(rae::rbm);
        this.raj.visibleWhen(() -> !this.rai.get());
        this.ral.visibleWhen(() -> this.rah.is("Fill") || this.rah.is("Box"));
        this.ram.visibleWhen(() -> !this.rah.is("Fill"));
    }

    private static void rbm(Packet<?> packet) {
        rae rae2 = raf;
        if (rae2 == null || !rae2.isEnabled()) {
            return;
        }
        if (packet instanceof BlockUpdateS2CPacket) {
            BlockUpdateS2CPacket blockUpdateS2CPacket = (BlockUpdateS2CPacket)packet;
            BlockPos blockPos2 = blockUpdateS2CPacket.getPos();
            rau.add(ChunkPos.toLong((int)(blockPos2.getX() >> 4), (int)(blockPos2.getZ() >> 4)));
        } else if (packet instanceof ChunkDeltaUpdateS2CPacket) {
            ChunkDeltaUpdateS2CPacket chunkDeltaUpdateS2CPacket = (ChunkDeltaUpdateS2CPacket)packet;
            long[] lArray = new long[]{Long.MIN_VALUE};
            chunkDeltaUpdateS2CPacket.visitUpdates((blockPos, blockState) -> {
                long l = ChunkPos.toLong((int)(blockPos.getX() >> 4), (int)(blockPos.getZ() >> 4));
                if (l != lArray[0]) {
                    lArray[0] = l;
                    rau.add(l);
                }
            });
        } else if (packet instanceof ChunkDataS2CPacket) {
            ChunkDataS2CPacket chunkDataS2CPacket = (ChunkDataS2CPacket)packet;
            rau.add(ChunkPos.toLong((int)chunkDataS2CPacket.getChunkX(), (int)chunkDataS2CPacket.getChunkZ()));
        }
    }

    @Override
    protected void onEnable() {
        this.rbn();
    }

    @Override
    protected void onDisable() {
        this.rbn();
    }

    private void rbn() {
        this.rar.clear();
        this.ras.clear();
        this.rat.clear();
        this.ray.clear();
        this.rap.clear();
        rau.clear();
        this.raw = -1;
    }

    private void rbo() {
        boolean[] blArray = new boolean[Registries.BLOCK.size()];
        for (String string : this.rag.ids()) {
            Block block;
            int n;
            Identifier identifier = Identifier.tryParse((String)string);
            if (identifier == null || !Registries.BLOCK.containsId(identifier) || (n = Registries.BLOCK.getRawId((Object)(block = (Block)Registries.BLOCK.get(identifier)))) < 0 || n >= blArray.length) continue;
            blArray[n] = true;
        }
        this.rav = blArray;
        this.raw = this.rag.version();
    }

    private boolean rbp(BlockState blockState) {
        int n = Registries.BLOCK.getRawId((Object)blockState.getBlock());
        return n >= 0 && n < this.rav.length && this.rav[n];
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        long l;
        long l2;
        wcn.ensure(minecraftClient);
        if (minecraftClient.world != this.rax) {
            this.rax = minecraftClient.world;
            this.rbn();
        }
        if (this.raw != this.rag.version()) {
            this.rbn();
            this.rbo();
        }
        int n = minecraftClient.player.getBlockX() >> 4;
        int n2 = minecraftClient.player.getBlockZ() >> 4;
        int n3 = (int)Math.ceil(this.rak.get() / 16.0) + 1;
        Object object = this.rar.keySet().iterator();
        while (object.hasNext()) {
            l2 = object.nextLong();
            if (Math.abs(ChunkPos.getPackedX((long)l2) - n) <= n3 + 1 && Math.abs(ChunkPos.getPackedZ((long)l2) - n2) <= n3 + 1) continue;
            object.remove();
        }
        object = this.rat.iterator();
        while (object.hasNext()) {
            l2 = object.nextLong();
            if (Math.abs(ChunkPos.getPackedX((long)l2) - n) <= n3 + 1 && Math.abs(ChunkPos.getPackedZ((long)l2) - n2) <= n3 + 1) continue;
            object.remove();
        }
        for (Long l3 : rau) {
            rau.remove(l3);
            if (!this.rat.remove(l3.longValue())) continue;
            this.ras.add(l3.longValue());
        }
        for (int i = -n3; i <= n3; ++i) {
            for (int j = -n3; j <= n3; ++j) {
                l = ChunkPos.toLong((int)(n + j), (int)(n2 + i));
                if (this.rat.contains(l)) continue;
                this.ras.add(l);
            }
        }
        long l4 = System.nanoTime();
        this.rbj = false;
        while (!this.ras.isEmpty() && System.nanoTime() - l4 < 1500000L) {
            WorldChunk worldChunk;
            l = this.ras.removeFirstLong();
            if (Math.abs(ChunkPos.getPackedX((long)l) - n) > n3 || Math.abs(ChunkPos.getPackedZ((long)l) - n2) > n3 || (worldChunk = minecraftClient.world.getChunkManager().getChunk(ChunkPos.getPackedX((long)l), ChunkPos.getPackedZ((long)l), ChunkStatus.FULL, false)) == null) continue;
            this.rbq(minecraftClient.world, worldChunk, l);
            this.rat.add(l);
        }
        if (--this.raz <= 0 || this.rbj) {
            this.raz = 10;
            this.rbs(minecraftClient);
        }
    }

    private void rbq(ClientWorld clientWorld, WorldChunk worldChunk, long l) {
        ArrayList<qzt> arrayList = null;
        ChunkSection[] chunkSectionArray = worldChunk.getSectionArray();
        int n = worldChunk.getBottomSectionCoord();
        int n2 = ChunkPos.getPackedX((long)l) << 4;
        int n3 = ChunkPos.getPackedZ((long)l) << 4;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.isEmpty() || !chunkSection.hasAny(this::rbp)) continue;
            int n4 = n + i << 4;
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 < 16; ++i2) {
                        BlockState blockState = chunkSection.getBlockState(i2, j, k);
                        if (!this.rbp(blockState)) continue;
                        mutable.set(n2 + i2, n4 + j, n3 + k);
                        if (arrayList == null) {
                            arrayList = new ArrayList<qzt>();
                        }
                        arrayList.add(this.rbr(clientWorld, (BlockPos)mutable, blockState));
                    }
                }
            }
        }
        if (arrayList == null) {
            this.rbj |= this.rar.remove(l) != null;
        } else {
            this.rar.put(l, arrayList);
            this.rbj = true;
        }
    }

    private qzt rbr(ClientWorld clientWorld, BlockPos blockPos, BlockState blockState) {
        Box box = new Box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        try {
            VoxelShape voxelShape = blockState.getOutlineShape((BlockView)clientWorld, blockPos);
            if (!voxelShape.isEmpty()) {
                box = voxelShape.getBoundingBox();
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return new qzt(blockPos.asLong(), this.rbu(blockState), (float)box.minX, (float)box.minY, (float)box.minZ, (float)box.maxX, (float)box.maxY, (float)box.maxZ);
    }

    private void rbs(MinecraftClient minecraftClient) {
        this.ray.clear();
        double d = this.rak.get();
        double d2 = d * d;
        Vec3d vec3d = minecraftClient.player.getEyePos();
        ArrayList<qzt> arrayList = new ArrayList<qzt>();
        for (Iterator<qzt> iterator : this.rar.values()) {
            Iterator object2 = iterator.iterator();
            while (object2.hasNext()) {
                double d3;
                double d4;
                qzt qzt2 = (qzt)object2.next();
                double d5 = (double)BlockPos.unpackLongX((long)qzt2.qzu) + 0.5 - vec3d.x;
                if (!(d5 * d5 + (d4 = (double)BlockPos.unpackLongY((long)qzt2.qzu) + 0.5 - vec3d.y) * d4 + (d3 = (double)BlockPos.unpackLongZ((long)qzt2.qzu) + 0.5 - vec3d.z) * d3 <= d2)) continue;
                arrayList.add(qzt2);
            }
        }
        int n3 = this.ran.getInt();
        if (arrayList.size() > n3) {
            int n4;
            Iterator<qzt> iterator;
            iterator = (Iterator<qzt>)new double[arrayList.size()];
            Integer[] integerArray = new Integer[arrayList.size()];
            for (n4 = 0; n4 < arrayList.size(); ++n4) {
                qzt qzt3 = (qzt)arrayList.get(n4);
                double d6 = (double)BlockPos.unpackLongX((long)qzt3.qzu) - vec3d.x;
                double d7 = (double)BlockPos.unpackLongY((long)qzt3.qzu) - vec3d.y;
                double d8 = (double)BlockPos.unpackLongZ((long)qzt3.qzu) - vec3d.z;
                iterator[n4] = (Iterator<qzt>)(d6 * d6 + d7 * d7 + d8 * d8);
                integerArray[n4] = n4;
            }
            Arrays.sort(integerArray, (n, n2) -> Double.compare(iterator[n], iterator[n2]));
            for (n4 = 0; n4 < n3; ++n4) {
                this.ray.add((qzt)arrayList.get(integerArray[n4]));
            }
        } else {
            this.ray.addAll(arrayList);
        }
        this.rap.clear();
        for (qzt qzt4 : this.ray) {
            if (!qzt4.fullCube()) continue;
            this.rap.put(qzt4.qzu, qzt4.qzv);
        }
    }

    private boolean rbt(long l, int n, int n2, int n3, int n4, boolean bl) {
        long l2 = BlockPos.add((long)l, (int)n, (int)n2, (int)n3);
        return this.rap.containsKey(l2) && (bl || this.rap.get(l2) == n4);
    }

    private int rbu(BlockState blockState) {
        Block block = blockState.getBlock();
        if (block instanceof ShulkerBoxBlock) {
            ShulkerBoxBlock shulkerBoxBlock = (ShulkerBoxBlock)block;
            DyeColor dyeColor = shulkerBoxBlock.getColor();
            return dyeColor != null ? 0xFF000000 | dyeColor.getEntityColor() : -4944682;
        }
        String string = Registries.BLOCK.getId((Object)block).getPath();
        if (string.contains("diamond")) {
            return -11541505;
        }
        if (string.contains("emerald")) {
            return -12723068;
        }
        if (string.contains("gold") || string.equals("gilded_blackstone")) {
            return -11443;
        }
        if (string.contains("ancient_debris") || string.contains("netherite")) {
            return -4158870;
        }
        if (string.contains("iron")) {
            return -1521234;
        }
        if (string.contains("redstone")) {
            return -45747;
        }
        if (string.contains("lapis")) {
            return -11699201;
        }
        if (string.contains("copper")) {
            return -26022;
        }
        if (string.contains("coal")) {
            return -7697770;
        }
        if (string.contains("quartz")) {
            return -856604;
        }
        if (string.contains("spawner")) {
            return -41334;
        }
        if (string.equals("ender_chest")) {
            return -5018625;
        }
        if (string.contains("chest") || string.contains("barrel")) {
            return -1529776;
        }
        if (string.contains("beacon") || string.contains("conduit")) {
            return -8587265;
        }
        int n = block.getDefaultMapColor().color;
        int n2 = 0xFF000000 | n;
        return ujt.luminance(n2) < 0.4f ? ujt.lerp(n2, -1, 0.45f) : n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        rae rae2 = raf;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (rae2 == null || !rae2.isEnabled() || rae2.ray.isEmpty() || minecraftClient.world == null || minecraftClient.player == null || minecraftClient.options.hudHidden || minecraftClient.currentScreen instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rae2.rba) {
            return;
        }
        rae2.rba = unf.frame();
        try {
            usn2 = usn.capture(renderTickCounter.getTickProgress(true), drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        Vec3d vec3d = usn2.camera();
        int n = rae2.raj.color() | 0xFF000000;
        boolean bl = rae2.rah.is("Fill");
        boolean bl2 = rae2.rah.is("Corners");
        float f = (float)rae2.ral.get();
        float f2 = (float)rae2.ram.get();
        boolean bl3 = !rae2.rai.get();
        float f3 = usn2.width();
        float f4 = usn2.height();
        float[] fArray = rae2.rbg;
        uut.beginBatch();
        try {
            for (qzt qzt2 : rae2.ray) {
                float f5;
                double d;
                double d2;
                double d3;
                double d4;
                double d5 = BlockPos.unpackLongX((long)qzt2.qzu);
                double d6 = d5 + (double)(qzt2.qzw + qzt2.qzz) * 0.5;
                float f6 = usn2.depth(d6, d4 = (d3 = (double)BlockPos.unpackLongY((long)qzt2.qzu)) + (double)(qzt2.qzx + qzt2.raa) * 0.5, d2 = (d = (double)BlockPos.unpackLongZ((long)qzt2.qzu)) + (double)(qzt2.qzy + qzt2.rab) * 0.5);
                if (f6 < -1.0f || f6 > 2.0f && usn2.project(d6, d4, d2, fArray) && (fArray[0] < -(f5 = usn2.unitsPerBlock(d6, d4, d2) * 0.9f) || fArray[1] < -f5 || fArray[0] > f3 + f5 || fArray[1] > f4 + f5)) continue;
                int n2 = bl3 ? n : qzt2.qzv;
                rae2.rbv(drawContext, usn2, vec3d, qzt2, d5, d3, d, n2, bl, bl2, f, f2, bl3);
            }
        }
        finally {
            uut.endBatch();
        }
    }

    private void rbv(DrawContext drawContext, usn usn2, Vec3d vec3d, qzt qzt2, double d, double d2, double d3, int n, boolean bl, boolean bl2, float f, float f2, boolean bl3) {
        int n2;
        boolean bl4 = qzt2.fullCube();
        int n3 = 0;
        if (bl4) {
            for (int i = 0; i < 6; ++i) {
                int[] nArray = raq[i];
                if (!this.rbt(qzt2.qzu, nArray[0], nArray[1], nArray[2], qzt2.qzv, bl3)) continue;
                n3 |= 1 << i;
            }
        }
        double d4 = 0.003;
        double d5 = d + (double)qzt2.qzw - d4;
        double d6 = d2 + (double)qzt2.qzx - d4;
        double d7 = d3 + (double)qzt2.qzy - d4;
        double d8 = d + (double)qzt2.qzz + d4;
        double d9 = d2 + (double)qzt2.raa + d4;
        double d10 = d3 + (double)qzt2.rab + d4;
        for (n2 = 0; n2 < 8; ++n2) {
            this.rbb[n2][0] = (n2 & 1) == 0 ? d5 : d8;
            this.rbb[n2][1] = (n2 & 2) == 0 ? d6 : d9;
            this.rbb[n2][2] = (n2 & 4) == 0 ? d7 : d10;
            this.rbd[n2] = usn2.depth(this.rbb[n2][0], this.rbb[n2][1], this.rbb[n2][2]) > 0.05f && usn2.project(this.rbb[n2][0], this.rbb[n2][1], this.rbb[n2][2], this.rbc[n2]);
        }
        this.rbe[0] = vec3d.y < d6;
        this.rbe[1] = vec3d.y > d9;
        this.rbe[2] = vec3d.z < d7;
        this.rbe[3] = vec3d.z > d10;
        this.rbe[4] = vec3d.x < d5;
        boolean bl5 = this.rbe[5] = vec3d.x > d8;
        if ((bl || !bl2) && f > 0.005f) {
            n2 = ujt.withAlpha(n, Math.round(255.0f * f));
            for (int i = 0; i < 6; ++i) {
                int[] nArray = rbh[i];
                if (!this.rbe[i] || (n3 & 1 << i) != 0 || !this.rbd[nArray[0]] || !this.rbd[nArray[1]] || !this.rbd[nArray[2]] || !this.rbd[nArray[3]]) continue;
                uut.quad(drawContext, this.rbc[nArray[0]][0], this.rbc[nArray[0]][1], n2, this.rbc[nArray[1]][0], this.rbc[nArray[1]][1], n2, this.rbc[nArray[2]][0], this.rbc[nArray[2]][1], n2, this.rbc[nArray[3]][0], this.rbc[nArray[3]][1], n2);
            }
        }
        if (bl) {
            return;
        }
        n2 = ujt.withAlpha(n, 230);
        for (int[] nArray : rbi) {
            if (bl4 && n3 != 0 ? !this.rbw(qzt2, nArray[2], nArray[3], n3, bl3) : !this.rbe[nArray[2]] && !this.rbe[nArray[3]]) continue;
            double[] dArray = this.rbb[nArray[0]];
            double[] dArray2 = this.rbb[nArray[1]];
            if (bl2) {
                this.rbx(drawContext, usn2, dArray, dArray2, 0.0, 0.25, f2, n2);
                this.rbx(drawContext, usn2, dArray, dArray2, 0.75, 1.0, f2, n2);
                continue;
            }
            if (this.rbd[nArray[0]] && this.rbd[nArray[1]]) {
                uut.line(drawContext, this.rbc[nArray[0]][0], this.rbc[nArray[0]][1], this.rbc[nArray[1]][0], this.rbc[nArray[1]][1], f2, n2);
                continue;
            }
            this.rbx(drawContext, usn2, dArray, dArray2, 0.0, 1.0, f2, n2);
        }
    }

    private boolean rbw(qzt qzt2, int n, int n2, int n3, boolean bl) {
        boolean bl2 = (n3 & 1 << n) != 0;
        boolean bl3 = (n3 & 1 << n2) != 0;
        int[] nArray = raq[n];
        int[] nArray2 = raq[n2];
        boolean bl4 = this.rbt(qzt2.qzu, nArray[0] + nArray2[0], nArray[1] + nArray2[1], nArray[2] + nArray2[2], qzt2.qzv, bl);
        if (!(bl2 || bl3 || bl4)) {
            return this.rbe[n] || this.rbe[n2];
        }
        if (bl2 != bl3 && !bl4 || bl2 && bl3 && bl4) {
            return false;
        }
        long l = qzt2.qzu;
        if (bl2) {
            l = Math.min(l, BlockPos.add((long)qzt2.qzu, (int)nArray[0], (int)nArray[1], (int)nArray[2]));
        }
        if (bl3) {
            l = Math.min(l, BlockPos.add((long)qzt2.qzu, (int)nArray2[0], (int)nArray2[1], (int)nArray2[2]));
        }
        if (bl4) {
            l = Math.min(l, BlockPos.add((long)qzt2.qzu, (int)(nArray[0] + nArray2[0]), (int)(nArray[1] + nArray2[1]), (int)(nArray[2] + nArray2[2])));
        }
        return l == qzt2.qzu;
    }

    private void rbx(DrawContext drawContext, usn usn2, double[] dArray, double[] dArray2, double d, double d2, float f, int n) {
        if (usn2.projectSegment(dArray[0] + (dArray2[0] - dArray[0]) * d, dArray[1] + (dArray2[1] - dArray[1]) * d, dArray[2] + (dArray2[2] - dArray[2]) * d, dArray[0] + (dArray2[0] - dArray[0]) * d2, dArray[1] + (dArray2[1] - dArray[1]) * d2, dArray[2] + (dArray2[2] - dArray[2]) * d2, 0.05f, this.rbf, this.rbg)) {
            uut.line(drawContext, this.rbf[0], this.rbf[1], this.rbf[2], this.rbf[3], f, n);
        }
    }

    static {
        raq = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
        rau = ConcurrentHashMap.newKeySet();
        rbh = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
        rbi = new int[][]{{0, 1, 0, 2}, {2, 3, 1, 2}, {4, 5, 0, 3}, {6, 7, 1, 3}, {0, 2, 2, 4}, {1, 3, 2, 5}, {4, 6, 3, 4}, {5, 7, 3, 5}, {0, 4, 0, 4}, {1, 5, 0, 5}, {2, 6, 1, 4}, {3, 7, 1, 5}};
    }

    private static /* synthetic */ int bxc(int n, int n2) {
        return n * n2 ^ 0xB05CDDD2;
    }

    private static /* synthetic */ int bxd(int n, int n2) {
        return n - n2 | 0xD0995A3D;
    }
}

