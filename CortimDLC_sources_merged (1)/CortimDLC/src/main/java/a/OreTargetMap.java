/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 */
package a;

import a.Box3;
import a.qmr;
import a.qmx;
import flow.dev.StringDecryptor;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_746;
import net.minecraft.class_7923;

public final class OreTargetMap {
    public static final byte PASS = 1;
    public static final byte SOLID = 2;
    public static final byte STAND = 4;
    public static final byte BREAK = 8;
    public static final byte DANGER = 16;
    public static final byte LIQUID = 32;
    public static final byte TARGET = 64;
    static final float INF = Float.POSITIVE_INFINITY;
    static final float JUMP = 3.0f;
    static final float FALL = 1.0f;
    static final float DIG_DOWN = 3.0f;
    static final double REACH = 4.2;
    static final double EYE = 1.62;
    static final double LOW = 0.25;
    private static final Set<class_2248> qne = Set.of(class_2246.field_10036, class_2246.field_22089, class_2246.field_10092, class_2246.field_10029, class_2246.field_16999, class_2246.field_10343, class_2246.field_27879, class_2246.field_17350, class_2246.field_23860, class_2246.field_10606, class_2246.field_28048, class_2246.field_10164);
    public int x0;
    public int y0;
    public int z0;
    public int sx;
    public int sy;
    public int sz;
    private byte[] qnf = new byte[0];
    private short[] qng = new short[0];
    private float[] qnh = new float[0];
    private int[] qni = new int[0];
    private int[] qnj = new int[0];
    private float[] qnk = new float[0];
    private int qnl;
    private Box3 qnm;
    private final qmr qnn = new qmr();
    private List<class_243> qno = List.of();
    private float qnp = 4.6f;
    private float qnq = 4.0f;
    private double qnr = 22.0;
    private float qns;
    private static final int[] qnt = new int[]{1, -1, 0, 0};
    private static final int[] qnu = new int[]{0, 0, 1, -1};
    private static final int[] qnv = new int[]{1, 1, -1, -1};
    private static final int[] qnw = new int[]{1, -1, 1, -1};
    private static /* synthetic */ long qnx;
    private static /* synthetic */ long qny;

    public void tune(float f, float f2, double d, float f3) {
        this.qnp = f;
        this.qnq = f2;
        this.qnr = d;
        this.qns = f3;
    }

    public void build(class_1937 class_19372, class_746 class_7462, Box3 pzc2, Predicate<class_2680> predicate, LongSet longSet, List<class_243> list) {
        this.build(class_19372, class_7462, pzc2, predicate, longSet, list, null);
    }

    public void build(class_1937 class_19372, class_746 class_7462, Box3 pzc2, Predicate<class_2680> predicate, LongSet longSet, List<class_243> list, class_2338 class_23382) {
        this.qnm = pzc2;
        this.qno = list;
        class_2338 class_23383 = class_7462.method_24515();
        int n = Math.min(pzc2.minX - 4, class_23383.method_10263() - 3);
        int n2 = Math.max(pzc2.maxX + 4, class_23383.method_10263() + 3);
        int n3 = Math.min(pzc2.minZ - 4, class_23383.method_10260() - 3);
        int n4 = Math.max(pzc2.maxZ + 4, class_23383.method_10260() + 3);
        int n5 = Math.min(pzc2.minY - 1, class_23383.method_10264() - 4);
        int n6 = Math.max(pzc2.maxY + 4, class_23383.method_10264() + 3);
        if (class_23382 != null) {
            n = Math.min(n, class_23382.method_10263() - 3);
            n2 = Math.max(n2, class_23382.method_10263() + 3);
            n3 = Math.min(n3, class_23382.method_10260() - 3);
            n4 = Math.max(n4, class_23382.method_10260() + 3);
            n5 = Math.min(n5, class_23382.method_10264() - 2);
            n6 = Math.max(n6, class_23382.method_10264() + 3);
        }
        this.x0 = n;
        this.y0 = n5;
        this.z0 = n3;
        this.sx = Math.min(128, n2 - n + 1);
        this.sy = Math.min(56, n6 - n5 + 1);
        this.sz = Math.min(128, n4 - n3 + 1);
        int n7 = this.sx * this.sy * this.sz;
        if (this.qnf.length < n7) {
            this.qnf = new byte[n7];
            this.qng = new short[n7];
            this.qnh = new float[n7];
            this.qni = new int[n7];
        }
        Arrays.fill(this.qnf, 0, n7, (byte)0);
        this.qnl = 0;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = 0; i < this.sx; ++i) {
            for (int j = 0; j < this.sz; ++j) {
                int n8 = this.x0 + i;
                int n9 = this.z0 + j;
                boolean bl = class_19372.method_8393(n8 >> 4, n9 >> 4);
                for (int k = 0; k < this.sy; ++k) {
                    int n10 = (k * this.sz + j) * this.sx + i;
                    if (!bl) {
                        this.qnf[n10] = 2;
                        continue;
                    }
                    int n11 = this.y0 + k;
                    class_23392.method_10103(n8, n11, n9);
                    class_2680 class_26802 = class_19372.method_8320((class_2338)class_23392);
                    int n12 = 0;
                    boolean bl2 = qne.contains(class_26802.method_26204());
                    if (!class_26802.method_26227().method_15769()) {
                        n12 = (byte)(n12 | 0x20);
                    } else {
                        class_265 class_2652 = class_26802.method_26220((class_1922)class_19372, (class_2338)class_23392);
                        if (class_2652.method_1110() || class_2652.method_1105(class_2350.class_2351.field_11052) <= 0.25) {
                            n12 = (byte)(n12 | (bl2 ? 16 : 1));
                        } else {
                            n12 = (byte)(n12 | 2);
                            double d = class_2652.method_1105(class_2350.class_2351.field_11052);
                            if (bl2) {
                                n12 = (byte)(n12 | 0x10);
                            } else if (d > 0.49 && d <= 1.01) {
                                n12 = (byte)(n12 | 4);
                            }
                        }
                    }
                    if (!class_26802.method_26215() && (n12 & 0x20) == 0 && pzc2.contains(n8, n11, n9) && !longSet.contains(class_2338.method_10064((int)n8, (int)n11, (int)n9))) {
                        float f;
                        float f2 = class_26802.method_26214((class_1922)class_19372, (class_2338)class_23392);
                        float f3 = f = f2 < 0.0f ? 0.0f : class_26802.method_26165((class_1657)class_7462, (class_1922)class_19372, (class_2338)class_23392);
                        if (f > 0.0f) {
                            n12 = (byte)(n12 | 8);
                            this.qng[n10] = (short)Math.min(600, Math.max(1, (int)Math.ceil(1.0f / f)));
                            if (predicate.test(class_26802)) {
                                n12 = (byte)(n12 | 0x40);
                                if (this.qnl == this.qnj.length) {
                                    this.qnj = Arrays.copyOf(this.qnj, Math.max(64, this.qnl * 2));
                                    this.qnk = Arrays.copyOf(this.qnk, this.qnj.length);
                                }
                                this.qnk[this.qnl] = OreTargetMap.value(class_26802);
                                this.qnj[this.qnl++] = n10;
                            }
                        }
                    }
                    this.qnf[n10] = n12;
                }
            }
        }
    }

    public int targetCount() {
        return this.qnl;
    }

    public boolean inside(int n, int n2, int n3) {
        return n >= this.x0 && n2 >= this.y0 && n3 >= this.z0 && n < this.x0 + this.sx && n2 < this.y0 + this.sy && n3 < this.z0 + this.sz;
    }

    public int index(int n, int n2, int n3) {
        return ((n2 - this.y0) * this.sz + (n3 - this.z0)) * this.sx + (n - this.x0);
    }

    public int flags(int n, int n2, int n3) {
        return this.inside(n, n2, n3) ? this.qnf[this.index(n, n2, n3)] : 2;
    }

    public int ticks(int n, int n2, int n3) {
        return this.inside(n, n2, n3) ? this.qng[this.index(n, n2, n3)] : 0;
    }

    public int wx(int n) {
        return this.x0 + n % this.sx;
    }

    public int wz(int n) {
        return this.z0 + n / this.sx % this.sz;
    }

    public int wy(int n) {
        return this.y0 + n / (this.sx * this.sz);
    }

    float clear(int n, int n2, int n3) {
        int n4 = this.flags(n, n2, n3);
        if ((n4 & 0x30) != 0) {
            return Float.POSITIVE_INFINITY;
        }
        if ((n4 & 1) != 0) {
            return 0.0f;
        }
        if ((n4 & 8) != 0) {
            return (float)this.ticks(n, n2, n3) + this.qnq;
        }
        return Float.POSITIVE_INFINITY;
    }

    boolean pass(int n, int n2, int n3) {
        int n4 = this.flags(n, n2, n3);
        return (n4 & 1) != 0 && (n4 & 0x30) == 0;
    }

    boolean stand(int n, int n2, int n3) {
        int n4 = this.flags(n, n2, n3);
        return (n4 & 4) != 0 && (n4 & 0x10) == 0;
    }

    public void search(class_2338 class_23382) {
        int n = this.sx * this.sy * this.sz;
        Arrays.fill(this.qnh, 0, n, Float.POSITIVE_INFINITY);
        Arrays.fill(this.qni, 0, n, -1);
        this.qnn.clear();
        if (!this.inside(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260())) {
            return;
        }
        int n2 = this.index(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
        this.qnh[n2] = 0.0f;
        this.qnn.push(0.0f, n2);
        block0: while (!this.qnn.isEmpty()) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            float f = this.qnn.topKey();
            if (f > this.qnh[n8 = this.qnn.pop()]) continue;
            int n9 = this.wx(n8);
            int n10 = this.wy(n8);
            int n11 = this.wz(n8);
            for (n7 = 0; n7 < 4; ++n7) {
                n6 = qnt[n7];
                n5 = qnu[n7];
                n4 = n9 + n6;
                n3 = n11 + n5;
                float f2 = this.clear(n4, n10, n3) + this.clear(n4, n10 + 1, n3);
                if (this.stand(n4, n10 - 1, n3)) {
                    this.qnz(n8, n4, n10, n3, f + this.qnp + f2);
                } else if (this.pass(n4, n10 - 1, n3) && f2 < Float.POSITIVE_INFINITY) {
                    for (int i = 1; i <= 3 && this.pass(n4, n10 - i, n3); ++i) {
                        if (!this.stand(n4, n10 - i - 1, n3)) continue;
                        this.qnz(n8, n4, n10 - i, n3, f + this.qnp + (float)i * 1.0f + f2);
                        break;
                    }
                }
                if (!this.stand(n4, n10, n3)) continue;
                float f3 = this.clear(n9, n10 + 2, n11) + this.clear(n4, n10 + 1, n3) + this.clear(n4, n10 + 2, n3);
                this.qnz(n8, n4, n10 + 1, n3, f + this.qnp + 3.0f + f3);
            }
            for (n7 = 0; n7 < 4; ++n7) {
                n6 = qnv[n7];
                n4 = n9 + n6;
                n5 = qnw[n7];
                n3 = n11 + n5;
                if (!this.pass(n4, n10, n3) || !this.pass(n4, n10 + 1, n3) || !this.pass(n9 + n6, n10, n11) || !this.pass(n9 + n6, n10 + 1, n11) || !this.pass(n9, n10, n11 + n5) || !this.pass(n9, n10 + 1, n11 + n5) || !this.stand(n4, n10 - 1, n3)) continue;
                this.qnz(n8, n4, n10, n3, f + this.qnp * 1.414f);
            }
            n7 = this.flags(n9, n10 - 1, n11);
            if ((n7 & 8) == 0 || (n7 & 0x10) != 0) continue;
            float f4 = (float)this.ticks(n9, n10 - 1, n11) + this.qnq + 3.0f;
            if ((this.flags(n9, n10 - 2, n11) & 2) != 0) {
                if (!this.stand(n9, n10 - 2, n11) && (this.flags(n9, n10 - 2, n11) & 8) == 0) continue;
                this.qnz(n8, n9, n10 - 1, n11, f + f4);
                continue;
            }
            for (n5 = 2; n5 <= 4 && this.pass(n9, n10 - n5, n11); ++n5) {
                if (!this.stand(n9, n10 - n5 - 1, n11)) continue;
                this.qnz(n8, n9, n10 - n5, n11, f + f4 + (float)(n5 - 1) * 1.0f);
                continue block0;
            }
        }
    }

    private void qnz(int n, int n2, int n3, int n4, float f) {
        int n5;
        if (f == Float.POSITIVE_INFINITY || !this.inside(n2, n3, n4) || !this.inside(n2, n3 + 1, n4)) {
            return;
        }
        for (class_243 class_2432 : this.qno) {
            double d = (double)n2 + 0.5 - class_2432.field_1352;
            double d2 = (double)n4 + 0.5 - class_2432.field_1350;
            double d3 = (double)n3 - class_2432.field_1351;
            if (!(d * d + d2 * d2 < 4.0) || !(Math.abs(d3) < 2.5)) continue;
            f += 25.0f;
            break;
        }
        if (f < this.qnh[n5 = this.index(n2, n3, n4)]) {
            this.qnh[n5] = f;
            this.qni[n5] = n;
            this.qnn.push(f, n5);
        }
    }

    public long targetKey(int n) {
        int n2 = this.qnj[n];
        return class_2338.method_10064((int)this.wx(n2), (int)this.wy(n2), (int)this.wz(n2));
    }

    public qmx best(class_243 class_2432, class_243 class_2433, LongSet longSet) {
        return this.best(class_2432, class_2433, longSet, null);
    }

    public qmx best(class_243 class_2432, class_243 class_2433, LongSet longSet, LongSet longSet2) {
        int n3;
        double[] dArray = new double[this.qnl];
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < this.qnl; ++i) {
            n3 = this.qnj[i];
            if (longSet2 != null && !longSet2.contains(class_2338.method_10064((int)this.wx(n3), (int)this.wy(n3), (int)this.wz(n3)))) continue;
            double d = (double)this.wx(n3) + 0.5 - class_2432.field_1352;
            double d2 = (double)this.wy(n3) + 0.5 - class_2432.field_1351;
            double d3 = (double)this.wz(n3) + 0.5 - class_2432.field_1350;
            dArray[i] = d * d + d2 * d2 + d3 * d3;
            arrayList.add(i);
        }
        Integer[] integerArray = arrayList.toArray(new Integer[0]);
        Arrays.sort(integerArray, (n, n2) -> Double.compare(dArray[n], dArray[n2]));
        n3 = Math.min(integerArray.length, 160);
        float f = Float.POSITIVE_INFINITY;
        int n4 = -1;
        int n5 = -1;
        float f2 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < n3; ++i) {
            int n6;
            int n7;
            int n8 = this.qnj[integerArray[i]];
            float f3 = this.qnk[integerArray[i]];
            int n9 = this.wx(n8);
            if (longSet.contains(class_2338.method_10064((int)n9, (int)(n7 = this.wy(n8)), (int)(n6 = this.wz(n8))))) continue;
            double d = (double)n9 + 0.5 - class_2432.field_1352;
            double d4 = (double)n7 + 0.5 - class_2432.field_1351;
            double d5 = (double)n6 + 0.5 - class_2432.field_1350;
            double d6 = Math.sqrt(d * d + d4 * d4 + d5 * d5);
            double d7 = d6 < 0.001 ? 1.0 : (d * class_2433.field_1352 + d4 * class_2433.field_1351 + d5 * class_2433.field_1350) / d6;
            f3 -= (float)(Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, d7)))) / this.qnr);
            if (this.qns > 0.0f) {
                f3 += this.qns * (float)this.qoa(n9, n7, n6);
            }
            float f4 = (float)this.qng[n8] + this.qnq;
            for (int j = n7 - 5; j <= n7 + 3; ++j) {
                for (int k = n9 - 4; k <= n9 + 4; ++k) {
                    for (int i2 = n6 - 4; i2 <= n6 + 4; ++i2) {
                        float f5;
                        float f6;
                        float f7;
                        double d8;
                        double d9;
                        double d10;
                        double d11;
                        double d12;
                        double d13;
                        float f8;
                        if (!this.inside(k, j, i2) || (f8 = this.qnh[this.index(k, j, i2)]) == Float.POSITIVE_INFINITY || f8 + f4 - f3 >= f || (d13 = (double)n9 + 0.5 - (d12 = (double)k + 0.5)) * d13 + (d11 = (double)n7 + 0.5 - (d10 = (double)j + 1.62)) * d11 + (d9 = (double)n6 + 0.5 - (d8 = (double)i2 + 0.5)) * d9 > 17.64 || (f7 = this.rayCost(d12, d10, d8, n9, n7, n6)) == Float.POSITIVE_INFINITY || !((f6 = (f5 = f8 + f4 + f7) - f3) < f)) continue;
                        f = f6;
                        f2 = f5;
                        n4 = n8;
                        n5 = this.index(k, j, i2);
                    }
                }
            }
        }
        if (n4 < 0) {
            return null;
        }
        return new qmx(new class_2338(this.wx(n4), this.wy(n4), this.wz(n4)), this.qob(n5), f2);
    }

    float rayCost(double d, double d2, double d3, int n, int n2, int n3) {
        double d4;
        double d5;
        int n4;
        double d6 = (double)n + 0.5;
        double d7 = (double)n2 + 0.5;
        double d8 = (double)n3 + 0.5;
        double d9 = d6 - d;
        double d10 = d7 - d2;
        double d11 = d8 - d3;
        int n5 = (int)Math.floor(d);
        int n6 = (int)Math.floor(d2);
        int n7 = (int)Math.floor(d3);
        int n8 = d9 > 0.0 ? 1 : -1;
        int n9 = d10 > 0.0 ? 1 : -1;
        int n10 = n4 = d11 > 0.0 ? 1 : -1;
        double d12 = d9 != 0.0 ? (d9 > 0.0 ? (double)(n5 + 1) - d : d - (double)n5) / Math.abs(d9) : (d5 = Double.MAX_VALUE);
        double d13 = d10 != 0.0 ? (d10 > 0.0 ? (double)(n6 + 1) - d2 : d2 - (double)n6) / Math.abs(d10) : (d4 = Double.MAX_VALUE);
        double d14 = d11 != 0.0 ? (d11 > 0.0 ? (double)(n7 + 1) - d3 : d3 - (double)n7) / Math.abs(d11) : Double.MAX_VALUE;
        double d15 = d9 != 0.0 ? 1.0 / Math.abs(d9) : Double.MAX_VALUE;
        double d16 = d10 != 0.0 ? 1.0 / Math.abs(d10) : Double.MAX_VALUE;
        double d17 = d11 != 0.0 ? 1.0 / Math.abs(d11) : Double.MAX_VALUE;
        float f = 0.0f;
        for (int i = 0; i < 24; ++i) {
            if (d5 < d4 && d5 < d14) {
                n5 += n8;
                d5 += d15;
            } else if (d4 < d14) {
                n6 += n9;
                d4 += d16;
            } else {
                n7 += n4;
                d14 += d17;
            }
            if (n5 == n && n6 == n2 && n7 == n3) {
                return f;
            }
            int n11 = this.flags(n5, n6, n7);
            if ((n11 & 1) != 0) continue;
            if ((n11 & 8) != 0 && (n11 & 0x30) == 0) {
                f += (float)this.ticks(n5, n6, n7) + this.qnq;
                continue;
            }
            return Float.POSITIVE_INFINITY;
        }
        return Float.POSITIVE_INFINITY;
    }

    private int qoa(int n, int n2, int n3) {
        int n4 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    if (i == 0 && j == 0 && k == 0 || (this.flags(n + i, n2 + j, n3 + k) & 0x40) == 0) continue;
                    ++n4;
                }
            }
        }
        return n4;
    }

    public List<class_2338> targetsNear(class_243 class_2432, double d) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (int i = 0; i < this.qnl; ++i) {
            double d2;
            double d3;
            int n = this.qnj[i];
            double d4 = (double)this.wx(n) + 0.5 - class_2432.field_1352;
            if (!(d4 * d4 + (d3 = (double)this.wy(n) + 0.5 - class_2432.field_1351) * d3 + (d2 = (double)this.wz(n) + 0.5 - class_2432.field_1350) * d2 <= d * d)) continue;
            arrayList.add(new class_2338(this.wx(n), this.wy(n), this.wz(n)));
        }
        return arrayList;
    }

    private int[] qob(int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n2 = n;
        while (n2 >= 0 && arrayList.size() < 4096) {
            arrayList.add(n2);
            n2 = this.qni[n2];
        }
        int[] nArray = new int[arrayList.size() * 3];
        for (int i = 0; i < arrayList.size(); ++i) {
            int n3 = (Integer)arrayList.get(arrayList.size() - 1 - i);
            nArray[i * 3] = this.wx(n3);
            nArray[i * 3 + 1] = this.wy(n3);
            nArray[i * 3 + 2] = this.wz(n3);
        }
        return nArray;
    }

    public qmx toward(class_2338 class_23382, int n) {
        int n2 = -1;
        double d = Double.MAX_VALUE;
        for (int i = class_23382.method_10264() - n; i <= class_23382.method_10264() + n; ++i) {
            for (int j = class_23382.method_10263() - n; j <= class_23382.method_10263() + n; ++j) {
                for (int k = class_23382.method_10260() - n; k <= class_23382.method_10260() + n; ++k) {
                    double d2;
                    double d3;
                    double d4;
                    double d5;
                    int n3;
                    if (!this.inside(j, i, k) || this.qnh[n3 = this.index(j, i, k)] == Float.POSITIVE_INFINITY || !((d5 = ((d4 = (double)(j - class_23382.method_10263())) * d4 + (d3 = (double)(i - class_23382.method_10264())) * d3 * 2.0 + (d2 = (double)(k - class_23382.method_10260())) * d2) * 40.0 + (double)this.qnh[n3]) < d)) continue;
                    d = d5;
                    n2 = n3;
                }
            }
        }
        return n2 < 0 ? null : new qmx(class_23382, this.qob(n2), this.qnh[n2]);
    }

    public float distTo(int n, int n2, int n3) {
        return this.inside(n, n2, n3) ? this.qnh[this.index(n, n2, n3)] : Float.POSITIVE_INFINITY;
    }

    public static float value(class_2680 class_26802) {
        String string = class_7923.field_41175.method_10221((Object)class_26802.method_26204()).method_12832();
        if (string.contains("diamond") || string.contains("emerald") || string.contains("ancient_debris")) {
            return 30.0f;
        }
        if (string.contains("gold")) {
            return 12.0f;
        }
        if (string.contains("lapis") || string.contains("redstone") || string.contains("iron")) {
            return 4.0f;
        }
        return 0.0f;
    }

    private static /* synthetic */ int btk(int n, int n2) {
        return n * n2 ^ 0xE50BDF9E;
    }

    private static /* synthetic */ int btl(int n, int n2) {
        return OreTargetMap.btk(n, n2) ^ 0xEDF9F6AC;
    }
}

