/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 */
package a;

import a.tbp;
import a.tpx;
import a.tra;
import a.tvn;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Arrays;

public final class tpn {
    public static final int F = 32;
    public static final double REACH = 4.5;
    public static final int UP = 2;
    public static final int DOWN = 3;
    private static final int[][] tpo = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    private static final double[][] tpp = new double[][]{{0.0, 0.0}, {0.3, 0.3}, {-0.3, 0.3}, {0.3, -0.3}, {-0.3, -0.3}};
    public int n;
    public int[] x = new int[64];
    public int[] y = new int[64];
    public int[] z = new int[64];
    public byte[] face = new byte[64];
    public double[] qx = new double[64];
    public double[] qy = new double[64];
    public double[] qz = new double[64];
    public double[] ang = new double[64];
    public double[] f = new double[2048];
    private static /* synthetic */ boolean tpq;
    private static /* synthetic */ boolean tpr;

    private tpn() {
    }

    public int indexOf(int n, int n2, int n3) {
        for (int i = 0; i < this.n; ++i) {
            if (this.x[i] != n || this.y[i] != n2 || this.z[i] != n3) continue;
            return i;
        }
        return -1;
    }

    public int nearest() {
        int n = -1;
        for (int i = 0; i < this.n; ++i) {
            if (n >= 0 && !(this.ang[i] < this.ang[n])) continue;
            n = i;
        }
        return n;
    }

    private void tps() {
        int n = this.x.length * 2;
        this.x = Arrays.copyOf(this.x, n);
        this.y = Arrays.copyOf(this.y, n);
        this.z = Arrays.copyOf(this.z, n);
        this.face = Arrays.copyOf(this.face, n);
        this.qx = Arrays.copyOf(this.qx, n);
        this.qy = Arrays.copyOf(this.qy, n);
        this.qz = Arrays.copyOf(this.qz, n);
        this.ang = Arrays.copyOf(this.ang, n);
        this.f = Arrays.copyOf(this.f, n * 32);
    }

    public static tpn of(tvn tvn2, tra tra2) {
        tpn tpn2 = new tpn();
        double d = Math.toRadians(tra2.yaw);
        double d2 = Math.toRadians(tra2.pitch);
        double d3 = -Math.sin(d) * Math.cos(d2);
        double d4 = -Math.sin(d2);
        double d5 = Math.cos(d) * Math.cos(d2);
        int n = (int)Math.floor(tra2.ex);
        int n2 = (int)Math.floor(tra2.ez);
        int n3 = (int)Math.floor(tra2.ey + 4.5);
        for (int i = n - 5; i <= n + 5; ++i) {
            for (int j = n2 - 5; j <= n2 + 5; ++j) {
                for (int k = tra2.feetY; k <= n3; ++k) {
                    int n4;
                    if (!tpx.minable(tvn2.at(i, k, j)) || tpn.tpt(tra2, i, k, j) > 4.5) continue;
                    double d6 = Double.MAX_VALUE;
                    double d7 = 0.0;
                    double d8 = 0.0;
                    double d9 = 0.0;
                    int n5 = -1;
                    for (n4 = 0; n4 < 6; ++n4) {
                        double d10;
                        double d11;
                        double d12;
                        int[] nArray = tpo[n4];
                        if (!tpx.open(tvn2.at(i + nArray[0], k + nArray[1], j + nArray[2])) || (tra2.ex - (d12 = (double)i + 0.5 + (double)nArray[0] * 0.5)) * (double)nArray[0] + (tra2.ey - (d11 = (double)k + 0.5 + (double)nArray[1] * 0.5)) * (double)nArray[1] + (tra2.ez - (d10 = (double)j + 0.5 + (double)nArray[2] * 0.5)) * (double)nArray[2] <= 0.02) continue;
                        int n6 = n4 / 2;
                        for (double[] dArray : tpp) {
                            double d13;
                            double d14;
                            double d15;
                            double d16;
                            double d17 = n6 == 0 ? d12 : d12 + dArray[0];
                            double d18 = d16 = n6 == 1 ? d11 : d11 + dArray[1];
                            double d19 = d17 - tra2.ex;
                            double d20 = d16 - tra2.ey;
                            double d21 = n6 == 2 ? d10 : (n6 == 0 ? d10 + dArray[0] : d10 + dArray[1]);
                            double d22 = d21 - tra2.ez;
                            double d23 = Math.sqrt(d19 * d19 + d20 * d20 + d22 * d22);
                            if (d23 > 4.5 || d23 < 0.3 || Math.sqrt(d19 * d19 + d22 * d22) < 0.25 || (d15 = Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, d14 = (d19 * d3 + d20 * d4 + d22 * d5) / d23))))) >= d6 || !tpn.clear(tvn2, tra2.ex, tra2.ey, tra2.ez, d17 + d19 * (d13 = 0.02 / d23), d16 + d20 * d13, d21 + d22 * d13, i, k, j, null)) continue;
                            d6 = d15;
                            d7 = d17;
                            d8 = d16;
                            d9 = d21;
                            n5 = n4;
                        }
                    }
                    if (n5 < 0) continue;
                    if (tpn2.n == tpn2.x.length) {
                        tpn2.tps();
                    }
                    n4 = tpn2.n++;
                    tpn2.x[n4] = i;
                    tpn2.y[n4] = k;
                    tpn2.z[n4] = j;
                    tpn2.face[n4] = (byte)n5;
                    tpn2.ang[n4] = d6;
                    tpn2.qx[n4] = d7;
                    tpn2.qy[n4] = d8;
                    tpn2.qz[n4] = d9;
                }
            }
        }
        if (tpn2.n > 0) {
            tpn2.tpw(tvn2, tra2, d3, d5, tpn.tpv(tvn2, tra2, tpn2));
        }
        return tpn2;
    }

    private static double tpt(tra tra2, int n, int n2, int n3) {
        double d = Math.max(0.0, Math.max((double)n - tra2.ex, tra2.ex - (double)(n + 1)));
        double d2 = Math.max(0.0, Math.max((double)n2 - tra2.ey, tra2.ey - (double)(n2 + 1)));
        double d3 = Math.max(0.0, Math.max((double)n3 - tra2.ez, tra2.ez - (double)(n3 + 1)));
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    private static long tpu(int n, int n2, int n3) {
        return (long)(n & 0x3FFFFFF) << 38 | (long)(n3 & 0x3FFFFFF) << 12 | (long)(n2 & 0xFFF);
    }

    private static LongOpenHashSet tpv(tvn tvn2, tra tra2, tpn tpn2) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        for (int i = 0; i < tpn2.n; ++i) {
            longOpenHashSet.add(tpn.tpu(tpn2.x[i], tpn2.y[i], tpn2.z[i]));
        }
        LongOpenHashSet longOpenHashSet2 = new LongOpenHashSet();
        int n = (int)Math.floor(tra2.ex);
        int n2 = (int)Math.floor(tra2.ey);
        int n3 = (int)Math.floor(tra2.ez);
        int[] nArray = new int[3];
        for (int i = n - 5; i <= n + 5; ++i) {
            for (int j = n3 - 5; j <= n3 + 5; ++j) {
                for (int k = n2 - 5; k <= n2 + 5; ++k) {
                    double d;
                    double d2;
                    double d3;
                    if (!tpx.target(tvn2.at(i, k, j)) || longOpenHashSet.contains(tpn.tpu(i, k, j)) || Math.sqrt((d3 = (double)i + 0.5 - tra2.ex) * d3 + (d2 = (double)k + 0.5 - tra2.ey) * d2 + (d = (double)j + 0.5 - tra2.ez) * d) > 5.5 || tpn.clear(tvn2, tra2.ex, tra2.ey, tra2.ez, (double)i + 0.5, (double)k + 0.5, (double)j + 0.5, i, k, j, nArray) || !tpx.minable(tvn2.at(nArray[0], nArray[1], nArray[2]))) continue;
                    longOpenHashSet2.add(tpn.tpu(nArray[0], nArray[1], nArray[2]));
                }
            }
        }
        return longOpenHashSet2;
    }

    static boolean clear(tvn tvn2, double d, double d2, double d3, double d4, double d5, double d6, int n, int n2, int n3, int[] nArray) {
        double d7;
        double d8;
        double d9;
        int n4;
        int n5;
        double d10 = d4 - d;
        double d11 = d5 - d2;
        double d12 = d6 - d3;
        int n6 = (int)Math.floor(d);
        int n7 = (int)Math.floor(d2);
        int n8 = (int)Math.floor(d3);
        int n9 = d10 > 0.0 ? 1 : (n5 = d10 < 0.0 ? -1 : 0);
        int n10 = d11 > 0.0 ? 1 : (n4 = d11 < 0.0 ? -1 : 0);
        int n11 = d12 > 0.0 ? 1 : (d12 < 0.0 ? -1 : 0);
        double d13 = n5 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(d10);
        double d14 = n4 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(d11);
        double d15 = d9 = n11 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(d12);
        double d16 = n5 > 0 ? ((double)(n6 + 1) - d) * d13 : (d8 = n5 < 0 ? (d - (double)n6) * d13 : Double.MAX_VALUE);
        double d17 = n4 > 0 ? ((double)(n7 + 1) - d2) * d14 : (d7 = n4 < 0 ? (d2 - (double)n7) * d14 : Double.MAX_VALUE);
        double d18 = n11 > 0 ? ((double)(n8 + 1) - d3) * d9 : (n11 < 0 ? (d3 - (double)n8) * d9 : Double.MAX_VALUE);
        for (int i = 0; i < 64; ++i) {
            double d19;
            if (n6 == n && n7 == n2 && n8 == n3) {
                return true;
            }
            if (i > 0 && !tpx.open(tvn2.at(n6, n7, n8))) {
                if (nArray != null) {
                    nArray[0] = n6;
                    nArray[1] = n7;
                    nArray[2] = n8;
                }
                return false;
            }
            if (d8 <= d7 && d8 <= d18) {
                d19 = d8;
                d8 += d13;
                n6 += n5;
            } else if (d7 <= d18) {
                d19 = d7;
                d7 += d14;
                n7 += n4;
            } else {
                d19 = d18;
                d18 += d9;
                n8 += n11;
            }
            if (!(d19 > 1.0)) continue;
            return false;
        }
        return false;
    }

    private void tpw(tvn tvn2, tra tra2, double d, double d2, LongOpenHashSet longOpenHashSet) {
        double d3 = Math.hypot(tra2.vyaw, tra2.vpitch);
        double d4 = Math.hypot(tra2.vx, tra2.vz);
        boolean bl = d4 > 0.04;
        double d5 = Math.hypot(d, d2);
        int n = tvn2.y0 + 11 - 1;
        for (int i = 0; i < this.n; ++i) {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9 = this.x[i];
            int n10 = this.y[i];
            int n11 = this.z[i];
            byte by = tvn2.at(n9, n10, n11);
            double d6 = this.qx[i] - tra2.ex;
            double d7 = this.qy[i] - tra2.ey;
            double d8 = this.qz[i] - tra2.ez;
            double d9 = tbp.wrap(tbp.yawTo(d6, d8) - (double)tra2.yaw);
            double d10 = tbp.pitchTo(d7, Math.sqrt(d6 * d6 + d8 * d8)) - (double)tra2.pitch;
            double d11 = 0.0;
            double d12 = 0.0;
            if (d3 > 0.5) {
                d11 = (d9 * (double)tra2.vyaw + d10 * (double)tra2.vpitch) / d3;
                d12 = Math.abs(d9 * (double)tra2.vpitch - d10 * (double)tra2.vyaw) / d3;
            }
            double d13 = (double)n9 + 0.5 - tra2.ex;
            double d14 = (double)n10 + 0.5 - tra2.ey;
            double d15 = (double)n11 + 0.5 - tra2.ez;
            double d16 = Math.sqrt(d13 * d13 + d14 * d14 + d15 * d15);
            int n12 = n10 - tra2.feetY;
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            for (n8 = -1; n8 <= 1; ++n8) {
                for (n7 = -1; n7 <= 1; ++n7) {
                    for (n6 = -1; n6 <= 1; ++n6) {
                        if (n8 == 0 && n7 == 0 && n6 == 0 || !tpx.minable((byte)(n5 = (int)tvn2.at(n9 + n8, n10 + n7, n11 + n6)))) continue;
                        ++n15;
                        if (tpx.target((byte)n5)) {
                            ++n13;
                            continue;
                        }
                        if (!tpx.ore((byte)n5)) continue;
                        ++n14;
                    }
                }
            }
            n8 = this.face[i] / 2;
            n7 = 0;
            n6 = 0;
            for (n5 = -1; n5 <= 1; ++n5) {
                for (n4 = -1; n4 <= 1; ++n4) {
                    int n16;
                    if (n5 == 0 && n4 == 0) continue;
                    int n17 = n3 = n8 == 0 ? 0 : n5;
                    n2 = n8 == 1 ? 0 : (n8 == 0 ? n5 : n4);
                    byte by2 = tvn2.at(n9 + n3, n10 + n2, n11 + (n16 = n8 == 2 ? 0 : n4));
                    if (!tpx.minable(by2)) continue;
                    ++n7;
                    if (!tpx.target(by2)) continue;
                    ++n6;
                }
            }
            n5 = 0;
            int[][] nArray = tpo;
            n3 = nArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                int[] nArray2 = nArray[n2];
                if (!tpx.open(tvn2.at(n9 + nArray2[0], n10 + nArray2[1], n11 + nArray2[2]))) continue;
                ++n5;
            }
            n4 = 1;
            for (n3 = n10 + 1; n3 <= n && n4 != 0; ++n3) {
                n4 = !tpx.minable(tvn2.at(n9, n3, n11)) ? 1 : 0;
            }
            double d17 = Math.hypot(d13, d15);
            double d18 = bl && d17 > 0.001 ? (tra2.vx * d13 + tra2.vz * d15) / (d4 * d17) : 0.0;
            boolean bl2 = (n12 == 0 || n12 == 1) && d17 < 1.8 && d5 > 0.001 && d17 > 0.001 && (d * d13 + d2 * d15) / (d5 * d17) > 0.7;
            int n18 = i * 32;
            this.f[n18] = this.ang[i] / 30.0;
            this.f[n18 + 1] = Math.log1p(this.ang[i] / 3.0);
            this.f[n18 + 2] = Math.abs(d9) / 30.0;
            this.f[n18 + 3] = d10 / 30.0;
            this.f[n18 + 4] = d11 / 30.0;
            this.f[n18 + 5] = d12 / 30.0;
            this.f[n18 + 6] = d16 / 4.0;
            this.f[n18 + 7] = (double)n12 / 3.0;
            this.f[n18 + 8] = n12 == 0 ? 1.0 : 0.0;
            this.f[n18 + 9] = n12 == 1 ? 1.0 : 0.0;
            this.f[n18 + 10] = n12 >= 2 ? 1.0 : 0.0;
            this.f[n18 + 11] = tpx.target(by) ? 1.0 : 0.0;
            this.f[n18 + 12] = tpx.ore(by) ? 1.0 : 0.0;
            this.f[n18 + 13] = (double)n13 / 3.0;
            this.f[n18 + 14] = (double)n14 / 3.0;
            this.f[n18 + 15] = (double)n15 / 26.0;
            this.f[n18 + 16] = (double)n7 / 8.0;
            this.f[n18 + 17] = (double)n6 / 3.0;
            this.f[n18 + 18] = (double)n5 / 6.0;
            if (tra2.hasPrev) {
                int n19 = Math.max(Math.abs(n9 - tra2.px), Math.max(Math.abs(n10 - tra2.py), Math.abs(n11 - tra2.pz)));
                double d19 = Math.sqrt((double)(n9 - tra2.px) * (double)(n9 - tra2.px) + (double)(n10 - tra2.py) * (double)(n10 - tra2.py) + (double)(n11 - tra2.pz) * (double)(n11 - tra2.pz));
                this.f[n18 + 19] = n19 == 1 ? 1.0 : 0.0;
                this.f[n18 + 20] = Math.min(d19, 8.0) / 4.0;
                this.f[n18 + 21] = 1.0;
            } else {
                this.f[n18 + 19] = 0.0;
                this.f[n18 + 20] = 0.0;
                this.f[n18 + 21] = 0.0;
            }
            this.f[n18 + 22] = d18;
            this.f[n18 + 23] = bl2 ? 1.0 : 0.0;
            this.f[n18 + 24] = n4 != 0 ? 1.0 : 0.0;
            this.f[n18 + 25] = this.face[i] == 2 ? 1.0 : 0.0;
            this.f[n18 + 26] = this.face[i] == 3 ? 1.0 : 0.0;
            this.f[n18 + 27] = tpx.slow(by) ? 1.0 : 0.0;
            this.f[n18 + 28] = longOpenHashSet.contains(tpn.tpu(n9, n10, n11)) ? 1.0 : 0.0;
            this.f[n18 + 29] = Math.min(1.0, d3 / 15.0);
            this.f[n18 + 30] = bl ? 1.0 : 0.0;
            this.f[n18 + 31] = tra2.ground ? 1.0 : 0.0;
        }
    }

    private static /* synthetic */ int cnw(int n, int n2) {
        return n ^ n2 | 0x2001D343;
    }

    private static /* synthetic */ int cnx(int n, int n2) {
        return tpn.cnw(n, n2) + n;
    }

    private static /* synthetic */ int cny(int n, int n2) {
        return tpn.cnx(n, n2) + n;
    }
}

