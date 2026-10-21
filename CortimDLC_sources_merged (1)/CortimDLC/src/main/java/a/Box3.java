/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_7923
 */
package a;

import flow.dev.StringDecryptor;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_7923;

public final class Box3 {
    private static final int pzd = 40;
    private static final int pze = 26;
    private static final int pzf = 8;
    private static final Map<class_2248, Boolean> pzg = new IdentityHashMap<class_2248, Boolean>();
    public final int minX;
    public final int minY;
    public final int minZ;
    public final int maxX;
    public final int maxY;
    public final int maxZ;
    public final int ores;
    private static /* synthetic */ int pzh;
    private static /* synthetic */ boolean pzi;

    public Box3(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.minX = n;
        this.minY = n2;
        this.minZ = n3;
        this.maxX = n4;
        this.maxY = n5;
        this.maxZ = n6;
        this.ores = n7;
    }

    public static Box3 empty(class_2338 class_23382) {
        return new Box3(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260(), class_23382.method_10263() - 1, class_23382.method_10264() - 1, class_23382.method_10260() - 1, 0);
    }

    public boolean contains(int n, int n2, int n3) {
        return n >= this.minX && n <= this.maxX && n2 >= this.minY && n2 <= this.maxY && n3 >= this.minZ && n3 <= this.maxZ;
    }

    public boolean contains(class_2338 class_23382) {
        return this.contains(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
    }

    public int volume() {
        return (this.maxX - this.minX + 1) * (this.maxY - this.minY + 1) * (this.maxZ - this.minZ + 1);
    }

    public boolean covers(Box3 pzc2) {
        return pzc2.minX >= this.minX && pzc2.maxX <= this.maxX && pzc2.minY >= this.minY && pzc2.maxY <= this.maxY && pzc2.minZ >= this.minZ && pzc2.maxZ <= this.maxZ;
    }

    public class_243 center() {
        return new class_243((double)(this.minX + this.maxX + 1) * 0.5, (double)this.maxY + 1.0, (double)(this.minZ + this.maxZ + 1) * 0.5);
    }

    public double distanceTo(class_243 class_2432) {
        double d = Math.max(0.0, Math.max((double)this.minX - class_2432.field_1352, class_2432.field_1352 - (double)(this.maxX + 1)));
        double d2 = Math.max(0.0, Math.max((double)this.minY - class_2432.field_1351, class_2432.field_1351 - (double)(this.maxY + 1)));
        double d3 = Math.max(0.0, Math.max((double)this.minZ - class_2432.field_1350, class_2432.field_1350 - (double)(this.maxZ + 1)));
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    public String toString() {
        return "[" + this.minX + " " + this.minY + " " + this.minZ + " .. " + this.maxX + " " + this.maxY + " " + this.maxZ + "] " + this.ores + " ores";
    }

    public static boolean isOre(class_2680 class_26802) {
        class_2248 class_22482 = class_26802.method_26204();
        Boolean bl = pzg.get(class_22482);
        if (bl == null) {
            String string = class_7923.field_41175.method_10221((Object)class_22482).method_12832();
            bl = string.endsWith("_ore") || string.equals("ancient_debris");
            pzg.put(class_22482, bl);
        }
        return bl;
    }

    public static boolean loaded(class_1937 class_19372, class_243 class_2432) {
        int n = (int)Math.floor(class_2432.field_1352);
        int n2 = (int)Math.floor(class_2432.field_1350);
        for (int i = n - 40 >> 4; i <= n + 40 >> 4; ++i) {
            for (int j = n2 - 40 >> 4; j <= n2 + 40 >> 4; ++j) {
                if (class_19372.method_8393(i, j)) continue;
                return false;
            }
        }
        return true;
    }

    public static Box3 detect(class_1937 class_19372, class_243 class_2432) {
        int n;
        int n2;
        int n3 = (int)Math.floor(class_2432.field_1352);
        int n4 = (int)Math.floor(class_2432.field_1351);
        int n5 = (int)Math.floor(class_2432.field_1350);
        int n6 = 81;
        int n7 = 35;
        int[] nArray = new int[n6];
        int[] nArray2 = new int[n6];
        int[] nArray3 = new int[n7];
        int n8 = 0;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = 0; i < n6; ++i) {
            for (int j = 0; j < n6; ++j) {
                int n9 = n3 - 40 + i;
                n2 = n5 - 40 + j;
                if (!class_19372.method_8393(n9 >> 4, n2 >> 4)) continue;
                for (n = 0; n < n7; ++n) {
                    class_23392.method_10103(n9, n4 - 26 + n, n2);
                    if (!Box3.isOre(class_19372.method_8320((class_2338)class_23392))) continue;
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
        int[] nArray4 = Box3.pzj(nArray);
        int[] nArray5 = Box3.pzj(nArray2);
        int[] nArray6 = Box3.pzj(nArray3);
        if (nArray4 == null || nArray5 == null || nArray6 == null) {
            return null;
        }
        n2 = nArray4[1] - nArray4[0] + 1;
        n = nArray5[1] - nArray5[0] + 1;
        int n13 = nArray6[1] - nArray6[0] + 1;
        if (n2 < 4 || n < 4 || n2 > 90 || n > 90 || n13 < 1 || n13 > 32) {
            return null;
        }
        Box3 pzc2 = new Box3(n3 - 40 + nArray4[0], n4 - 26 + nArray6[0], n5 - 40 + nArray5[0], n3 - 40 + nArray4[1], n4 - 26 + nArray6[1], n5 - 40 + nArray5[1], 0);
        int n14 = 0;
        for (int i = pzc2.minX; i <= pzc2.maxX; ++i) {
            for (int j = pzc2.minZ; j <= pzc2.maxZ; ++j) {
                for (int k = pzc2.minY; k <= pzc2.maxY; ++k) {
                    if (!Box3.isOre(class_19372.method_8320((class_2338)class_23392.method_10103(i, k, j)))) continue;
                    ++n14;
                }
            }
        }
        if ((double)n14 < (double)n8 * 0.6 || n14 < 10) {
            return null;
        }
        return new Box3(pzc2.minX, pzc2.minY, pzc2.minZ, pzc2.maxX, pzc2.maxY, pzc2.maxZ, n14);
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

