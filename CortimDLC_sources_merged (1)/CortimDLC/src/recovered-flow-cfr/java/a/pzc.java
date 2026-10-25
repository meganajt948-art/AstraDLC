/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.registry.Registries
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import flow.dev.a;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class pzc {
    private static final int pzd = 40;
    private static final int pze = 26;
    private static final int pzf = 8;
    private static final Map<Block, Boolean> pzg = new IdentityHashMap<Block, Boolean>();
    public final int minX;
    public final int minY;
    public final int minZ;
    public final int maxX;
    public final int maxY;
    public final int maxZ;
    public final int ores;
    private static /* synthetic */ int pzh;
    private static /* synthetic */ boolean pzi;

    public pzc(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.minX = n;
        this.minY = n2;
        this.minZ = n3;
        this.maxX = n4;
        this.maxY = n5;
        this.maxZ = n6;
        this.ores = n7;
    }

    public static pzc empty(BlockPos blockPos) {
        return new pzc(blockPos.method_10263(), blockPos.method_10264(), blockPos.method_10260(), blockPos.method_10263() - 1, blockPos.method_10264() - 1, blockPos.method_10260() - 1, 0);
    }

    public boolean contains(int n, int n2, int n3) {
        return n >= this.minX && n <= this.maxX && n2 >= this.minY && n2 <= this.maxY && n3 >= this.minZ && n3 <= this.maxZ;
    }

    public boolean contains(BlockPos blockPos) {
        return this.contains(blockPos.method_10263(), blockPos.method_10264(), blockPos.method_10260());
    }

    public int volume() {
        return (this.maxX - this.minX + 1) * (this.maxY - this.minY + 1) * (this.maxZ - this.minZ + 1);
    }

    public boolean covers(pzc pzc2) {
        return pzc2.minX >= this.minX && pzc2.maxX <= this.maxX && pzc2.minY >= this.minY && pzc2.maxY <= this.maxY && pzc2.minZ >= this.minZ && pzc2.maxZ <= this.maxZ;
    }

    public Vec3d center() {
        return new Vec3d((double)(this.minX + this.maxX + 1) * 0.5, (double)this.maxY + 1.0, (double)(this.minZ + this.maxZ + 1) * 0.5);
    }

    public double distanceTo(Vec3d vec3d) {
        double d = Math.max(0.0, Math.max((double)this.minX - vec3d.field_1352, vec3d.field_1352 - (double)(this.maxX + 1)));
        double d2 = Math.max(0.0, Math.max((double)this.minY - vec3d.field_1351, vec3d.field_1351 - (double)(this.maxY + 1)));
        double d3 = Math.max(0.0, Math.max((double)this.minZ - vec3d.field_1350, vec3d.field_1350 - (double)(this.maxZ + 1)));
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    public String toString() {
        return a.c(-1685265731, "\ue2e7") + this.minX + a.d("\ua9d4", -2033143432, -1439295347) + this.minY + a.b("\ub313", -236080334) + this.minZ + a.b("\ua4c6\udd79\u57aa\uc9d5", 1605477602) + this.maxX + a.c(1034582923, "\u7baa") + this.maxY + a.d("\uf486", 597257731, 1448188580) + this.maxZ + a.d("\uf31a\u8ad6", 732030834, 355669047) + this.ores + a.c(-691344193, "\uec9a\u9564\u1faa\u81cc\u0a0d");
    }

    public static boolean isOre(BlockState blockState) {
        Block block = blockState.method_26204();
        Boolean bl = pzg.get(block);
        if (bl == null) {
            String string = Registries.field_41175.method_10221((Object)block).method_12832();
            bl = string.endsWith(a.d("\u89c7\uf046\u7a88\ue4ee", 677064703, -1548704157)) || string.equals(a.d("\ue6d2\u9f6c\u15b2\u8bc9\u0012\u86a8\u3ce1\ub53b\u2b5f\ua1ef\u263b\udc5a\u5296\ucb3d", 1293802267, -383828570));
            pzg.put(block, bl);
        }
        return bl;
    }

    public static boolean loaded(World world, Vec3d vec3d) {
        int n = (int)Math.floor(vec3d.field_1352);
        int n2 = (int)Math.floor(vec3d.field_1350);
        for (int i = n - 40 >> 4; i <= n + 40 >> 4; ++i) {
            for (int j = n2 - 40 >> 4; j <= n2 + 40 >> 4; ++j) {
                if (world.method_8393(i, j)) continue;
                return false;
            }
        }
        return true;
    }

    public static pzc detect(World world, Vec3d vec3d) {
        int n;
        int n2;
        int n3 = (int)Math.floor(vec3d.field_1352);
        int n4 = (int)Math.floor(vec3d.field_1351);
        int n5 = (int)Math.floor(vec3d.field_1350);
        int n6 = 81;
        int n7 = 35;
        int[] nArray = new int[n6];
        int[] nArray2 = new int[n6];
        int[] nArray3 = new int[n7];
        int n8 = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < n6; ++i) {
            for (int j = 0; j < n6; ++j) {
                int n9 = n3 - 40 + i;
                n2 = n5 - 40 + j;
                if (!world.method_8393(n9 >> 4, n2 >> 4)) continue;
                for (n = 0; n < n7; ++n) {
                    mutable.method_10103(n9, n4 - 26 + n, n2);
                    if (!pzc.isOre(world.method_8320((BlockPos)mutable))) continue;
                    int n10 = i;
                    nArray[n10] = nArray[n10] + 1;
                    int n11 = j;
                    nArray2[n11] = nArray2[n11] + 1;
                    int n12 = n;
                    nArray3[n12] = nArray3[n12] + 1;
                    ++n8;
                }
            }
        }
        if (n8 < 12) {
            return null;
        }
        int[] nArray4 = pzc.pzj(nArray);
        int[] nArray5 = pzc.pzj(nArray2);
        int[] nArray6 = pzc.pzj(nArray3);
        if (nArray4 == null || nArray5 == null || nArray6 == null) {
            return null;
        }
        n2 = nArray4[1] - nArray4[0] + 1;
        n = nArray5[1] - nArray5[0] + 1;
        int n13 = nArray6[1] - nArray6[0] + 1;
        if (n2 < 4 || n < 4 || n2 > 90 || n > 90 || n13 < 1 || n13 > 32) {
            return null;
        }
        pzc pzc2 = new pzc(n3 - 40 + nArray4[0], n4 - 26 + nArray6[0], n5 - 40 + nArray5[0], n3 - 40 + nArray4[1], n4 - 26 + nArray6[1], n5 - 40 + nArray5[1], 0);
        int n14 = 0;
        for (int i = pzc2.minX; i <= pzc2.maxX; ++i) {
            for (int j = pzc2.minZ; j <= pzc2.maxZ; ++j) {
                for (int k = pzc2.minY; k <= pzc2.maxY; ++k) {
                    if (!pzc.isOre(world.method_8320((BlockPos)mutable.method_10103(i, k, j)))) continue;
                    ++n14;
                }
            }
        }
        if ((double)n14 < (double)n8 * 0.6 || n14 < 10) {
            return null;
        }
        return new pzc(pzc2.minX, pzc2.minY, pzc2.minZ, pzc2.maxX, pzc2.maxY, pzc2.maxZ, n14);
    }

    private static int[] pzj(int[] nArray) {
        int[] nArray2;
        int n = 0;
        for (int n2 : nArray) {
            n = Math.max(n, n2);
        }
        int n3 = Math.max(2, (int)Math.ceil((double)n * 0.12));
        int n4 = -1;
        int n5 = -1;
        long l = 0L;
        int n6 = -1;
        long l2 = 0L;
        for (int i = 0; i <= nArray.length; ++i) {
            boolean bl;
            boolean bl2 = bl = i < nArray.length && nArray[i] >= n3;
            if (bl) {
                if (n6 < 0) {
                    n6 = i;
                    l2 = 0L;
                }
                l2 += (long)nArray[i];
                continue;
            }
            if (n6 < 0) continue;
            if (l2 > l) {
                l = l2;
                n4 = n6;
                n5 = i - 1;
            }
            n6 = -1;
        }
        if (n4 < 0) {
            nArray2 = null;
        } else {
            int[] nArray3 = new int[2];
            nArray3[0] = n4;
            nArray2 = nArray3;
            nArray3[1] = n5;
        }
        return nArray2;
    }

    private static /* synthetic */ int bpy(int n, int n2) {
        return n * n2 | 0xAC4B74A1;
    }

    private static /* synthetic */ int bpz(int n, int n2) {
        return n * n2 | 0x81A5CD92;
    }
}

