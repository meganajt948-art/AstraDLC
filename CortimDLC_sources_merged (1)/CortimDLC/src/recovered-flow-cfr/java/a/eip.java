/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.MapColor
 *  net.minecraft.block.MapColor$Brightness
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.component.type.MapIdComponent
 *  net.minecraft.item.map.MapState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.chunk.WorldChunk
 */
package a;

import a.dtv;
import a.elb;
import flow.dev.a;
import java.util.Arrays;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.chunk.WorldChunk;

public final class eip {
    public static final int SIZE = 96;
    private static final int eiq = 12;
    private static final MinecraftClient eir = MinecraftClient.method_1551();
    private final dtv eis;
    private final int[] eit = new int[9216];
    private final BlockPos.Mutable eiu = new BlockPos.Mutable();
    private elb eiv;
    private boolean eiw;
    private int eix;
    private int eiy;
    private int eiz;
    private int eja;
    private int ejb;
    private boolean ejc;
    private long ejd;
    private MapIdComponent eje;
    private long ejf;
    private elb ejg;
    private boolean ejh;
    private static /* synthetic */ int eji;
    private static /* synthetic */ long ejj;

    eip(dtv dtv2) {
        this.eis = dtv2;
    }

    public void demand() {
        this.ejd = System.currentTimeMillis() + 1000L;
    }

    void reset() {
        this.eix = 0;
        this.ejc = false;
        Arrays.fill(this.eit, 0);
        this.eiw = true;
        this.eje = null;
    }

    void onChunk(WorldChunk worldChunk) {
    }

    void onMap(MapIdComponent mapIdComponent) {
        this.eje = mapIdComponent;
        this.ejf = System.currentTimeMillis();
        this.ejh = true;
    }

    void tick() {
        if (System.currentTimeMillis() > this.ejd) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = eip.eir.field_1724;
        ClientWorld clientWorld = eip.eir.field_1687;
        if (clientPlayerEntity == null || clientWorld == null) {
            return;
        }
        if (this.eix == 0) {
            this.eiy = clientPlayerEntity.method_31477();
            this.eiz = clientPlayerEntity.method_31479();
        }
        int n = clientPlayerEntity.method_31478();
        int n2 = clientWorld.method_31607();
        int n3 = Math.min(96, this.eix + 12);
        for (int i = this.eix; i < n3; ++i) {
            int n4 = this.eiz + i - 48;
            for (int j = 0; j < 96; ++j) {
                int n5 = this.eiy + j - 48;
                this.eit[i * 96 + j] = this.ejk(clientWorld, n5, n4, n, n2);
            }
        }
        this.eix = n3;
        if (this.eix >= 96) {
            this.eix = 0;
            this.eja = this.eiy;
            this.ejb = this.eiz;
            this.ejc = true;
            this.eiw = true;
        }
    }

    private int ejk(ClientWorld clientWorld, int n, int n2, int n3, int n4) {
        WorldChunk worldChunk = clientWorld.method_2935().method_12126(n >> 4, n2 >> 4, false);
        if (worldChunk == null) {
            return 0;
        }
        int n5 = worldChunk.method_12005(Heightmap.Type.field_13202, n & 0xF, n2 & 0xF);
        int n6 = Math.min(n5, n3 + 6);
        int n7 = Math.max(n4, n6 - 40);
        for (int i = n6; i >= n7; --i) {
            MapColor mapColor;
            this.eiu.method_10103(n, i, n2);
            BlockState blockState = worldChunk.method_8320((BlockPos)this.eiu);
            if (blockState.method_26215() || (mapColor = blockState.method_26205((BlockView)clientWorld, (BlockPos)this.eiu)) == MapColor.field_16008) continue;
            int n8 = i - n3;
            MapColor.Brightness brightness = n8 > 1 ? MapColor.Brightness.field_34761 : (n8 >= -2 ? MapColor.Brightness.field_34760 : (n8 >= -8 ? MapColor.Brightness.field_34759 : MapColor.Brightness.field_34762));
            return mapColor.method_15820(brightness);
        }
        return 0;
    }

    public elb texture() {
        if (!this.ejc) {
            return null;
        }
        if (this.eiv == null) {
            this.eiv = new elb(a.c(-1093687452, "\ua713\udeb1\u5467\uca13\u41d7"), 96, 96);
            this.eiw = true;
        }
        if (this.eiw) {
            for (int i = 0; i < 96; ++i) {
                for (int j = 0; j < 96; ++j) {
                    this.eiv.set(j, i, this.eit[i * 96 + j]);
                }
            }
            this.eiv.upload();
            this.eiw = false;
        }
        return this.eiv;
    }

    public int getCenterX() {
        return this.eja;
    }

    public int getCenterZ() {
        return this.ejb;
    }

    public elb mapTexture() {
        ClientWorld clientWorld = this.eis.getWorld();
        if (this.eje == null || clientWorld == null || System.currentTimeMillis() - this.ejf > 120000L) {
            return null;
        }
        MapState mapState = clientWorld.method_17891(this.eje);
        if (mapState == null) {
            return null;
        }
        if (this.ejg == null) {
            this.ejg = new elb(a.c(-847230806, "\u48c4\u3179\ubbbb"), 128, 128);
            this.ejh = true;
        }
        if (this.ejh) {
            for (int i = 0; i < 16384; ++i) {
                this.ejg.set(i % 128, i / 128, MapColor.method_38480((int)mapState.field_122[i]));
            }
            this.ejg.upload();
            this.ejh = false;
        }
        return this.ejg;
    }

    void close() {
        if (this.eiv != null) {
            this.eiv.close();
            this.eiv = null;
        }
        if (this.ejg != null) {
            this.ejg.close();
            this.ejg = null;
        }
    }

    private static /* synthetic */ int ew(int n, int n2) {
        return n * n2 | 0xFB567D0C;
    }

    private static /* synthetic */ int ex(int n, int n2) {
        return eip.ew(n, n2) ^ 0xFA789844;
    }

    private static /* synthetic */ int ey(int n, int n2) {
        return n * n2 | 0x1CCA2758;
    }
}

