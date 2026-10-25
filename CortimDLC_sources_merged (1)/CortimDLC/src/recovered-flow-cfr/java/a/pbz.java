/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.BossBarHud
 *  net.minecraft.client.gui.hud.ClientBossBar
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.boss.BossBar$Color
 *  net.minecraft.entity.boss.BossBar$Style
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.BlockBox
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package a;

import a.hyv;
import a.iov;
import a.izx;
import a.kfa;
import a.kfe;
import a.pbs;
import a.pbw;
import a.uij;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vcq;
import a.vdn;
import a.veo;
import a.wap;
import a.wcn;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class pbz
extends kfe {
    private static final Set<Block> pca = Set.of(Blocks.QUARTZ_BLOCK, Blocks.DEAD_TUBE_CORAL_BLOCK, Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.PURPUR_PILLAR, Blocks.END_STONE_BRICKS, Blocks.NETHER_BRICKS, Blocks.GILDED_BLACKSTONE, Blocks.PRISMARINE_BRICKS, Blocks.ICE, Blocks.NETHER_WART_BLOCK, Blocks.RESPAWN_ANCHOR, Blocks.NETHERITE_BLOCK, Blocks.WHITE_STAINED_GLASS, Blocks.BLACK_CONCRETE, Blocks.POLISHED_BASALT);
    private static final int pcb = 2;
    private static final int pcc = 2;
    private static final long pcd = 200L;
    private static final long pce = 400L;
    private static final vdn pcf = veo.semibold(6.4f);
    private static final float pcg = 13.0f;
    private static final float pch = 4.5f;
    private static final float pci = 9.0f;
    private static final float pcj = 3.5f;
    private static pbz pck;
    private static Field pcl;
    private static boolean pcm;
    private final Set<BlockPos> pcn = ConcurrentHashMap.newKeySet();
    private final Map<BlockPos, Integer> pco = new HashMap<BlockPos, Integer>();
    private final List<pbw> pcp = new ArrayList<pbw>();
    private volatile boolean pcq;
    private ClientWorld pcr;
    private int pcs;
    private static /* synthetic */ long pct;
    private static /* synthetic */ long pcu;

    public pbz() {
        super(a.c(-772048336, "\u7a69\u03ff\u892a\u175c\u9c9d\u1a3b\ua069\u299f\ub7d7\u3d70"), a.c(456087106, "\u560a\u2f86\ua551\u3b28\ub0e8\u3658\u8c58\u05e6\u9ba0\u1102\u96c6\u6ce5\ue266\u7bd1\uf191\u7771\ucd3d\u42bf\ud84d\u5e13\ud7ee\uadfb\u2318\ub8d5\u3ea7\ub464\u0dd0\u8386"), kfa.PLAYER);
        pck = this;
        wcn.listen(this::pcw);
    }

    @Override
    protected void onEnable() {
        this.pcr = this.mc.world;
        this.pcq = true;
        if (this.mc.world != null) {
            wcn.ensure(this.mc);
        }
    }

    @Override
    protected void onDisable() {
        this.pcq = false;
        this.pcv();
        this.pcn.clear();
    }

    private void pcv() {
        for (pbw pbw2 : this.pcp) {
            pbz.pdd(pbw2);
        }
        this.pcp.clear();
        this.pco.clear();
    }

    private void pcw(Packet<?> packet) {
        if (!this.pcq) {
            return;
        }
        if (packet instanceof ChunkDeltaUpdateS2CPacket) {
            ChunkDeltaUpdateS2CPacket chunkDeltaUpdateS2CPacket = (ChunkDeltaUpdateS2CPacket)packet;
            chunkDeltaUpdateS2CPacket.visitUpdates(this::pcx);
        } else if (packet instanceof BlockUpdateS2CPacket) {
            BlockUpdateS2CPacket blockUpdateS2CPacket = (BlockUpdateS2CPacket)packet;
            this.pcx(blockUpdateS2CPacket.getPos(), blockUpdateS2CPacket.getState());
        }
    }

    private void pcx(BlockPos blockPos, BlockState blockState) {
        ClientWorld clientWorld = this.mc.world;
        if (clientWorld == null || !pca.contains(blockState.getBlock())) {
            return;
        }
        if (clientWorld.isChunkLoaded(blockPos.getX() >> 4, blockPos.getZ() >> 4) && !pca.contains(clientWorld.getBlockState(blockPos).getBlock())) {
            this.pcn.add(blockPos.toImmutable());
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        wcn.ensure(minecraftClient);
        ++this.pcs;
        if (minecraftClient.world != this.pcr) {
            this.pcv();
            this.pcr = minecraftClient.world;
        }
        Iterator<BlockPos> iterator = this.pcn.iterator();
        while (iterator.hasNext()) {
            this.pco.put(iterator.next(), this.pcs);
            iterator.remove();
        }
        if (!this.pco.isEmpty()) {
            this.pcy();
        }
        this.pda(minecraftClient);
    }

    private void pcy() {
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>(this.pco.keySet());
        ArrayDeque<BlockPos> arrayDeque = new ArrayDeque<BlockPos>();
        while (!hashSet.isEmpty()) {
            BlockPos blockPos = (BlockPos)hashSet.iterator().next();
            hashSet.remove(blockPos);
            arrayDeque.add(blockPos);
            ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
            int n = Integer.MAX_VALUE;
            int n2 = Integer.MIN_VALUE;
            while (!arrayDeque.isEmpty()) {
                BlockPos blockPos2 = (BlockPos)arrayDeque.poll();
                arrayList.add(blockPos2);
                int n3 = this.pco.get(blockPos2);
                n = Math.min(n, n3);
                n2 = Math.max(n2, n3);
                for (int i = -2; i <= 2; ++i) {
                    for (int j = -2; j <= 2; ++j) {
                        for (int k = -2; k <= 2; ++k) {
                            BlockPos blockPos3 = blockPos2.add(i, j, k);
                            if (!hashSet.remove(blockPos3)) continue;
                            arrayDeque.add(blockPos3);
                        }
                    }
                }
            }
            if (this.pcs - n2 < 2) continue;
            for (BlockPos blockPos4 : arrayList) {
                this.pco.remove(blockPos4);
            }
            this.pcz(arrayList, System.currentTimeMillis() - (long)(this.pcs - n) * 50L);
        }
    }

    private void pcz(List<BlockPos> list, long l) {
        BlockBox blockBox = BlockBox.encompassPositions(list).orElse(null);
        if (blockBox == null) {
            return;
        }
        for (pbs pbs2 : pbs.values()) {
            if (!pbs2.matches(blockBox, list)) continue;
            this.pcp.removeIf(pbw2 -> {
                if (pbw2.box.equals((Object)blockBox)) {
                    pbz.pdd(pbw2);
                    return true;
                }
                return false;
            });
            this.pcp.add(new pbw(pbs2, blockBox, list, l));
            return;
        }
    }

    private void pda(MinecraftClient minecraftClient) {
        long l = System.currentTimeMillis();
        BlockPos blockPos = minecraftClient.player.getBlockPos();
        Iterator<pbw> iterator = this.pcp.iterator();
        while (iterator.hasNext()) {
            pbw pbw2 = iterator.next();
            if (pbw2.deadAt == 0L && pbz.pdb(minecraftClient.world, pbw2)) {
                pbw2.deadAt = l;
            }
            if (pbw2.left(l) <= 0L || pbw2.deadAt != 0L && l - pbw2.deadAt > 400L) {
                pbz.pdd(pbw2);
                iterator.remove();
                continue;
            }
            if (pbw2.deadAt == 0L && pbw2.box.contains((Vec3i)blockPos)) {
                pbz.pdc(pbw2, l);
                continue;
            }
            pbz.pdd(pbw2);
        }
    }

    private static boolean pdb(ClientWorld clientWorld, pbw pbw2) {
        int n = 0;
        for (BlockPos blockPos : pbw2.blocks) {
            if (!clientWorld.isChunkLoaded(blockPos.getX() >> 4, blockPos.getZ() >> 4)) {
                return false;
            }
            if (pca.contains(clientWorld.getBlockState(blockPos).getBlock())) continue;
            ++n;
        }
        return n * 2 > pbw2.blocks.size();
    }

    private static void pdc(pbw pbw2, long l) {
        Map<UUID, ClientBossBar> map = pbz.pde();
        if (map == null) {
            return;
        }
        long l2 = Math.max(0L, pbw2.left(l));
        MutableText mutableText = Text.literal((String)(wap.t(pbw2.kind.title) + a.c(131093714, "\u54f1\u0d74\ua793") + pbz.pdf(l2) + wap.s(a.b("3\u79d1", -857604079), a.c(1154097681, "\u2235\u5fe5\ud542\u4b3c"))));
        float f = Math.min(1.0f, (float)l2 / (float)pbw2.kind.duration);
        if (pbw2.bar == null) {
            pbw2.bar = new ClientBossBar(UUID.randomUUID(), (Text)mutableText, f, BossBar.Color.WHITE, BossBar.Style.PROGRESS, false, false, false);
        } else {
            pbw2.bar.setName((Text)mutableText);
            pbw2.bar.setPercent(f);
        }
        map.putIfAbsent(pbw2.bar.getUuid(), pbw2.bar);
    }

    private static void pdd(pbw pbw2) {
        if (pbw2.bar == null) {
            return;
        }
        Map<UUID, ClientBossBar> map = pbz.pde();
        if (map != null) {
            map.remove(pbw2.bar.getUuid());
        }
        pbw2.bar = null;
    }

    private static Map<UUID, ClientBossBar> pde() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (pcm || minecraftClient.inGameHud == null) {
            return null;
        }
        try {
            if (pcl == null) {
                for (Field field : BossBarHud.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Map.class.isAssignableFrom(field.getType())) continue;
                    field.setAccessible(true);
                    pcl = field;
                    break;
                }
                if (pcl == null) {
                    throw new IllegalStateException(a.b("\uff62\u86de\u0c11\u9260\u19e4\u9f17\u2547\uaca5\u32a8\ub854\u3f8b\uc5eb\u4b6c\ud293\u58c1\ude2b\u6430\ueba7\u711d\uf756\u7eba\u04e1", 1754070806));
                }
            }
            return (Map)pcl.get(minecraftClient.inGameHud.getBossBarHud());
        }
        catch (Throwable throwable) {
            pcm = true;
            System.out.println(a.c(1286892570, "\u6c6f\u15d3\u9f1c\u016d\u8ae9\u0c1a\ub64a\u3fa8\ua1f6\u2b14\uac92\u56f8\ud820\u4186\ucbc2\u4d3b\uf771\u78ad\ue21d\u6442\uedbc\u97b2\u191b") + throwable);
            return null;
        }
    }

    private static String pdf(long l) {
        long l2 = Math.round((double)l / 100.0);
        return l2 / 10L + a.c(-1547351786, "\u4939") + l2 % 10L;
    }

    public static pbz get() {
        return pck;
    }

    public int count() {
        return this.pcp.size();
    }

    public String describe() {
        StringBuilder stringBuilder = new StringBuilder();
        long l = System.currentTimeMillis();
        for (pbw pbw2 : this.pcp) {
            stringBuilder.append(pbw2.kind.name()).append('@').append(pbw2.box.getCenter().toShortString()).append(' ').append(pbz.pdf(Math.max(0L, pbw2.left(l)))).append(pbw2.bar != null ? a.b("\u45e6\u3c15\ub6c5\u28a7", -488553022) : "").append(pbw2.deadAt != 0L ? a.d("\u68d7\u1122\u9bf0\u0585\u8e57", -1429805639, -1315271349) : "").append(a.c(-1740534363, "\u8d9c\uf436"));
        }
        return stringBuilder.toString();
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        pbz pbz2 = pck;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (pbz2 == null || !pbz2.isEnabled() || pbz2.pcp.isEmpty() || minecraftClient.world == null || minecraftClient.player == null || minecraftClient.options.hudHidden) {
            return;
        }
        unf.observe(drawContext);
        float f = unf.delta();
        iov.update(f * (float)iov.ANIMATION.get());
        float f2 = drawContext.getScaledWindowWidth();
        float f3 = drawContext.getScaledWindowHeight();
        try {
            usn2 = usn.capture(renderTickCounter.getTickProgress(true), f2, f3);
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        GpuTextureView gpuTextureView = null;
        if (izx.BACKGROUND.is(a.d("\u65b0\u1c2a\u96f4\u0897\u8340", -1974128899, -433304817)) && hyv.ENABLED.get() && uij.HUD.capture(drawContext, hyv.FROST.getInt(), null)) {
            gpuTextureView = uij.HUD.result(drawContext);
        }
        long l = System.currentTimeMillis();
        ArrayList<pbw> arrayList = new ArrayList<pbw>(pbz2.pcp);
        arrayList.sort((pbw2, pbw3) -> Double.compare(pbz.pdg(usn2, pbw3), pbz.pdg(usn2, pbw2)));
        float f4 = Math.max(1, minecraftClient.getWindow().getScaleFactor());
        float[] fArray = new float[2];
        for (pbw pbw4 : arrayList) {
            float f5 = pbw4.shown.step(pbw4.deadAt == 0L && pbw4.left(l) > 200L, f);
            BlockPos blockPos = pbw4.box.getCenter();
            if (f5 < 0.01f || !usn2.project((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, fArray)) continue;
            pbz.pdh(drawContext, pbw4, (float)Math.round(fArray[0] * f4) / f4, (float)Math.round(fArray[1] * f4) / f4, f5, l, gpuTextureView);
        }
    }

    private static double pdg(usn usn2, pbw pbw2) {
        BlockPos blockPos = pbw2.box.getCenter();
        return usn2.distance((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void pdh(DrawContext drawContext, pbw pbw2, float f, float f2, float f3, long l, GpuTextureView gpuTextureView) {
        long l2 = Math.max(0L, pbw2.left(l));
        String string = pbz.pdf(l2);
        float f4 = 17.0f + pcf.width(string) + 4.5f;
        float f5 = iov.r(4.0f);
        float f6 = vcq.outCubic(f3);
        float f7 = 0.8f + 0.2f * f6;
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(f, f2);
        drawContext.getMatrices().scale(f7, f7);
        drawContext.getMatrices().translate(-f4 * 0.5f, -6.5f);
        uut.pushAlpha(f3);
        try {
            float f8 = (float)izx.OPACITY.get();
            int n = ujt.withAlpha(iov.window, Math.round(255.0f * Math.min(1.0f, f8 * 0.55f)));
            if (gpuTextureView == null || !uut.glass(drawContext, gpuTextureView, 0.0f, 0.0f, f4, 13.0f, f5, n, 1.0f)) {
                uut.round(drawContext, 0.0f, 0.0f, f4, 13.0f, f5, ujt.withAlpha(iov.window, Math.round(255.0f * f8 * 0.6f)));
            }
            uut.outline(drawContext, 0.0f, 0.0f, f4, 13.0f, f5, 1.0f, ujt.withAlpha(0xFFFFFF, Math.round(14.0f + 16.0f * iov.lightness())));
            float f9 = 6.5f;
            float f10 = 0.5625f * f6;
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(9.0f, f9);
            drawContext.getMatrices().scale(f10, f10);
            drawContext.drawItem(pbw2.icon, -8, -8);
            drawContext.getMatrices().popMatrix();
            pcf.draw(drawContext, string, 17.0f, pcf.centerTop(f9), iov.text);
            float f11 = f4 - f5 * 2.0f;
            float f12 = Math.min(1.0f, (float)l2 / (float)pbw2.kind.duration);
            uut.round(drawContext, f5, 10.8f, f11, 1.2f, 0.6f, ujt.withAlpha(0xFFFFFF, 30));
            uut.gradientH(drawContext, f5, 10.8f, Math.max(1.2f, f11 * f12), 1.2f, 0.6f, iov.accent(), iov.accent2());
        }
        finally {
            uut.popAlpha();
            drawContext.getMatrices().popMatrix();
        }
    }

    private static /* synthetic */ int bgx(int n, int n2) {
        return n + n2 | 0xFE4FAC6E;
    }

    private static /* synthetic */ int bgy(int n, int n2) {
        return n * n2 | 0xFDB872CE;
    }
}

