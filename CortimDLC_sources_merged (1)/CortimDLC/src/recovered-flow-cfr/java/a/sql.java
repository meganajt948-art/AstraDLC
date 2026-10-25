/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.spg;
import a.spo;
import a.ssj;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jspecify.annotations.Nullable;

public final class sql {
    public static final int APPEAR = 1;
    public static final int CRACK = 2;
    public static final int BURST = 4;
    private static final float sqm = 0.38f;
    private static final float sqn = 0.72f;
    private static final float sqo = 1.3f;
    private static final float sqp = 15.0f;
    public final double x;
    public final double y;
    public final double z;
    public final boolean totem;
    public final float red;
    public final float green;
    public final float blue;
    private final int sqq;
    private final int sqr;
    private final int[] sqs;
    private final int[] sqt;
    private final float[] squ;
    private final float[] sqv;
    private final float[] sqw;
    private final int[] sqx;
    private final float[] sqy;
    private final float[] sqz;
    private final float[] sra;
    private final float[] srb;
    private final float[] src;
    private final float[] srd;
    private final float[] sre;
    private final boolean[] srf;
    private final boolean[] srg;
    private final float srh;
    private final float sri;
    private final float srj;
    private final float srk;
    private final float srl;
    private final float srm;
    private final Random srn;
    private float sro;
    private int srp = 1;
    private boolean srq;
    private boolean srr;
    private float srs;
    private float srt;
    private float sru;
    private float srv;
    private float srw = 1.0f;
    private float srx = 1.0f;
    private float sry;
    private float srz;
    private float ssa;
    private static /* synthetic */ boolean ssb;
    private static /* synthetic */ boolean ssc;

    private sql(spo spo2, double d, double d2, double d3, double d4, double d5, float f, boolean bl, int n, Random random) {
        float f2;
        float f3;
        int n2;
        float f4;
        int n3;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.totem = bl;
        this.red = (float)(n >> 16 & 0xFF) / 255.0f;
        this.green = (float)(n >> 8 & 0xFF) / 255.0f;
        this.blue = (float)(n & 0xFF) / 255.0f;
        this.srm = f;
        this.srn = random;
        this.sqq = spo2.shards;
        this.sqr = spo2.vertices;
        this.sqs = spo2.start;
        this.sqt = spo2.count;
        this.squ = spo2.center;
        this.sqv = spo2.pos;
        this.sqw = spo2.nrm;
        this.sqx = spo2.code;
        this.sqy = new float[this.sqq * 3];
        this.sqz = new float[this.sqq * 3];
        this.sra = new float[this.sqq * 4];
        this.srb = new float[this.sqq * 3];
        this.src = new float[this.sqq];
        this.srd = new float[this.sqq];
        this.sre = new float[this.sqq];
        this.srf = new boolean[this.sqq];
        this.srg = new boolean[this.sqq];
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = Float.MAX_VALUE;
        float f9 = -3.4028235E38f;
        for (n3 = 0; n3 < this.sqq; ++n3) {
            f5 += this.squ[n3 * 3];
            f6 += this.squ[n3 * 3 + 1];
            f7 += this.squ[n3 * 3 + 2];
        }
        for (n3 = 0; n3 < this.sqr; ++n3) {
            int n4 = this.ssf(n3);
            f4 = this.squ[n4 * 3 + 1] + this.sqv[n3 * 3 + 1];
            f8 = Math.min(f8, f4);
            f9 = Math.max(f9, f4);
        }
        this.srh = f5 / (float)Math.max(1, this.sqq);
        this.sri = f6 / (float)Math.max(1, this.sqq);
        this.srj = f7 / (float)Math.max(1, this.sqq);
        this.srk = this.sqr > 0 ? f8 : 0.0f;
        this.srl = this.sqr > 0 ? f9 : 1.8f;
        float f10 = (float)(d4 - d) - this.srh;
        float f11 = (float)(d5 - d3) - this.srj;
        f4 = (float)Math.sqrt(f10 * f10 + f11 * f11);
        if (f4 < 0.001f) {
            f10 = 0.0f;
            f11 = 1.0f;
        } else {
            f10 /= f4;
            f11 /= f4;
        }
        float f12 = this.srh + f10 * 0.3f;
        float f13 = this.sri + 0.15f;
        float f14 = this.srj + f11 * 0.3f;
        float f15 = -f10;
        float f16 = -f11;
        float f17 = 0.001f;
        for (n2 = 0; n2 < this.sqq; ++n2) {
            float f18 = this.squ[n2 * 3] - f12;
            f3 = this.squ[n2 * 3 + 1] - f13;
            f2 = this.squ[n2 * 3 + 2] - f14;
            this.sre[n2] = (float)Math.sqrt(f18 * f18 + f3 * f3 + f2 * f2);
            f17 = Math.max(f17, this.sre[n2]);
        }
        for (n2 = 0; n2 < this.sqq; ++n2) {
            float f19;
            float f20;
            float f21;
            float f22;
            int n5 = n2 * 3;
            this.sre[n2] = f3 = this.sre[n2] / f17;
            this.srd[n2] = f3 * 0.22f + random.nextFloat() * 0.04f;
            this.sra[n2 * 4 + 3] = 1.0f;
            f2 = random.nextFloat() * 2.0f - 1.0f;
            float f23 = (float)Math.sqrt(f2 * f2 + (f22 = random.nextFloat() * 2.0f - 1.0f) * f22 + (f21 = random.nextFloat() * 2.0f - 1.0f) * f21);
            if (f23 < 0.001f) {
                f2 = 0.0f;
                f22 = 1.0f;
                f21 = 0.0f;
                f23 = 1.0f;
            }
            this.srb[n5] = f2 / f23;
            this.srb[n5 + 1] = f22 / f23;
            this.srb[n5 + 2] = f21 / f23;
            float f24 = this.squ[n5] - f12;
            float f25 = this.squ[n5 + 1] - f13;
            float f26 = this.squ[n5 + 2] - f14;
            float f27 = Math.max(0.001f, (float)Math.sqrt(f24 * f24 + f25 * f25 + f26 * f26));
            f24 /= f27;
            f25 /= f27;
            f26 /= f27;
            float f28 = this.squ[n5] - this.srh;
            float f29 = this.squ[n5 + 2] - this.srj;
            float f30 = (float)Math.sqrt(f28 * f28 + f29 * f29);
            if (f30 < 0.001f) {
                double d6 = random.nextDouble() * Math.PI * 2.0;
                f28 = (float)Math.cos(d6);
                f29 = (float)Math.sin(d6);
            } else {
                f28 /= f30;
                f29 /= f30;
            }
            if (bl) {
                this.srf[n2] = f3 < 0.16f && random.nextFloat() < 0.85f;
                f20 = this.ssg(0.4f, 1.1f);
                f19 = this.ssg(0.1f, 0.4f);
                this.sqz[n5] = f24 * f20 + f15 * f19;
                this.sqz[n5 + 1] = f25 * f20 + this.ssg(0.3f, 1.0f);
                this.sqz[n5 + 2] = f26 * f20 + f16 * f19;
                this.src[n2] = this.ssg(2.0f, 7.0f);
                continue;
            }
            this.srf[n2] = true;
            f20 = this.ssg(0.6f, 1.8f);
            f19 = this.ssg(1.1f, 2.6f) * (1.25f - f3);
            float f31 = this.ssg(0.4f, 1.2f);
            this.sqz[n5] = f28 * f20 + f24 * f19 + f15 * f31;
            this.sqz[n5 + 1] = f25 * f19 + this.ssg(1.2f, 3.2f);
            this.sqz[n5 + 2] = f29 * f20 + f26 * f19 + f16 * f31;
            this.src[n2] = this.ssg(5.0f, 15.0f);
        }
        this.update(0.0f);
    }

    public static sql create(MinecraftClient minecraftClient, @Nullable LivingEntity livingEntity, double d, double d2, double d3, float f, float f2, boolean bl, boolean bl2, boolean bl3, int n, float f3) {
        List<spg> list;
        Random random = new Random();
        double[] dArray = new double[]{d, d2, d3};
        List<spg> list2 = list = livingEntity != null ? ssj.capture(minecraftClient, livingEntity, f3, dArray) : null;
        if (list == null) {
            dArray[0] = d;
            dArray[1] = d2;
            dArray[2] = d3;
            float f4 = bl ? 1.0f : Math.max(0.4f, Math.min(1.6f, f2 / 1.8f));
            list = ssj.steve(f, f4);
        }
        spo spo2 = spo.build(list, bl3, random);
        Vec3d vec3d = minecraftClient.player != null ? minecraftClient.player.getEyePos() : new Vec3d(dArray[0], dArray[1] + 1.6, dArray[2] + 3.0);
        float f5 = sql.ssd(minecraftClient.world, dArray[0], dArray[1], dArray[2]);
        return new sql(spo2, dArray[0], dArray[1], dArray[2], vec3d.x, vec3d.z, f5, bl2, n, random);
    }

    private static float ssd(@Nullable ClientWorld clientWorld, double d, double d2, double d3) {
        int n;
        if (clientWorld == null) {
            return 0.0f;
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int n2 = MathHelper.floor((double)d);
        int n3 = MathHelper.floor((double)d3);
        for (int i = n = MathHelper.floor((double)(d2 + 0.5)); i > n - 10; --i) {
            double d4;
            mutable.set(n2, i, n3);
            VoxelShape voxelShape = clientWorld.getBlockState((BlockPos)mutable).getCollisionShape((BlockView)clientWorld, (BlockPos)mutable);
            if (voxelShape.isEmpty() || !((d4 = (double)i + voxelShape.getMax(Direction.Axis.Y)) <= d2 + 0.6)) continue;
            return (float)(d4 - d2);
        }
        return -10.0f;
    }

    public boolean update(float f) {
        this.sro += f;
        float f2 = this.sro;
        this.srs = f2 < 0.38f ? this.srk - 0.05f + f2 / 0.38f * (this.srl - this.srk + 0.15f) : 10000.0f;
        this.sru = f2 < 0.38f ? 0.25f : (float)Math.exp(-(f2 - 0.38f) * 5.0f);
        this.srt = f2 > 0.55f && f2 < 1.1f ? this.srl + 0.15f - (f2 - 0.55f) / 0.55f * (this.srl - this.srk + 0.5f) : -10000.0f;
        float f3 = this.srv = f2 < 1.3f ? sql.ssi(0.72f, 1.26f, f2) * 1.12f : 2.0f;
        if (!this.srq && f2 >= 0.72f) {
            this.srq = true;
            this.srp |= 2;
        }
        if (!this.srr && f2 >= 1.3f) {
            this.srr = true;
            this.srp |= 4;
        }
        this.srx = 1.025f + (f2 < 0.38f ? 0.05f : 0.05f * (float)Math.exp(-(f2 - 0.38f) * 7.0f));
        this.sry = sql.ssi(0.38f, 1.3f, f2) * 0.09f;
        float f4 = sql.ssi(0.95f, 1.3f, f2) * (this.srr && this.totem ? 0.0f : 0.014f);
        this.srz = (this.srn.nextFloat() - 0.5f) * f4;
        this.ssa = (this.srn.nextFloat() - 0.5f) * f4;
        if (this.totem) {
            float f5 = sql.ssi(1.8f, 2.45f, f2);
            this.srw = 1.0f - f5;
            this.srx *= 1.0f + 0.06f * f5;
            this.sry += f5 * 0.12f;
        }
        for (int i = 0; i < this.sqq; ++i) {
            if (!this.srf[i] || f2 < 1.3f + this.srd[i]) continue;
            int n = i * 3;
            if (!this.srg[i]) {
                this.srg[i] = true;
                this.sqy[n] = this.srh + (this.squ[n] - this.srh) * this.srx + this.srz;
                this.sqy[n + 1] = this.sri + (this.squ[n + 1] - this.sri) * this.srx + this.sry;
                this.sqy[n + 2] = this.srj + (this.squ[n + 2] - this.srj) * this.srx + this.ssa;
            }
            int n2 = n + 1;
            this.sqz[n2] = this.sqz[n2] - 15.0f * f;
            float f6 = (float)Math.pow(0.7, f);
            int n3 = n;
            this.sqz[n3] = this.sqz[n3] * f6;
            int n4 = n + 1;
            this.sqz[n4] = this.sqz[n4] * f6;
            int n5 = n + 2;
            this.sqz[n5] = this.sqz[n5] * f6;
            int n6 = n;
            this.sqy[n6] = this.sqy[n6] + this.sqz[n] * f;
            int n7 = n + 1;
            this.sqy[n7] = this.sqy[n7] + this.sqz[n + 1] * f;
            int n8 = n + 2;
            this.sqy[n8] = this.sqy[n8] + this.sqz[n + 2] * f;
            if (this.sqy[n + 1] < this.srm + 0.02f) {
                this.sqy[n + 1] = this.srm + 0.02f;
                if (this.sqz[n + 1] < 0.0f) {
                    int n9 = n + 1;
                    this.sqz[n9] = this.sqz[n9] * -0.28f;
                    int n10 = n;
                    this.sqz[n10] = this.sqz[n10] * 0.5f;
                    int n11 = n + 2;
                    this.sqz[n11] = this.sqz[n11] * 0.5f;
                    int n12 = i;
                    this.src[n12] = this.src[n12] * 0.5f;
                }
            }
            this.sse(i, this.src[i] * f);
        }
        return this.totem ? f2 < 2.5f : f2 < 4.0f;
    }

    private void sse(int n, float f) {
        if (f == 0.0f) {
            return;
        }
        int n2 = n * 3;
        int n3 = n * 4;
        float f2 = f * 0.5f;
        float f3 = (float)Math.sin(f2);
        float f4 = (float)Math.cos(f2);
        float f5 = this.srb[n2] * f3;
        float f6 = this.srb[n2 + 1] * f3;
        float f7 = this.srb[n2 + 2] * f3;
        float f8 = this.sra[n3];
        float f9 = this.sra[n3 + 1];
        float f10 = this.sra[n3 + 2];
        float f11 = this.sra[n3 + 3];
        float f12 = f4 * f8 + f5 * f11 + f6 * f10 - f7 * f9;
        float f13 = f4 * f9 - f5 * f10 + f6 * f11 + f7 * f8;
        float f14 = f4 * f10 + f5 * f9 - f6 * f8 + f7 * f11;
        float f15 = f4 * f11 - f5 * f8 - f6 * f9 - f7 * f10;
        float f16 = (float)Math.sqrt(f12 * f12 + f13 * f13 + f14 * f14 + f15 * f15);
        this.sra[n3] = f12 / f16;
        this.sra[n3 + 1] = f13 / f16;
        this.sra[n3 + 2] = f14 / f16;
        this.sra[n3 + 3] = f15 / f16;
    }

    public int write(ByteBuffer byteBuffer, double d, double d2, double d3) {
        float f = (float)(this.x - d);
        float f2 = (float)(this.y - d2);
        float f3 = (float)(this.z - d3);
        int n = 0;
        for (int i = 0; i < this.sqq; ++i) {
            float f4;
            float f5;
            float f6;
            float f7;
            int n2 = i * 3;
            float f8 = this.srx;
            float f9 = 1.0f;
            boolean bl = this.srg[i];
            if (bl) {
                f7 = this.sro - 1.3f - this.srd[i];
                float f10 = f9 = this.totem ? 1.0f - sql.ssi(0.5f, 1.1f, f7) : 1.0f - sql.ssi(1.2f, 2.1f, f7);
                if (f9 <= 0.004f) continue;
                f8 = this.srx * (0.3f + 0.7f * f9);
                f6 = this.sqy[n2];
                f5 = this.sqy[n2 + 1];
                f4 = this.sqy[n2 + 2];
            } else {
                f6 = this.srh + (this.squ[n2] - this.srh) * this.srx + this.srz;
                f5 = this.sri + (this.squ[n2 + 1] - this.sri) * this.srx + this.sry;
                f4 = this.srj + (this.squ[n2 + 2] - this.srj) * this.srx + this.ssa;
            }
            f7 = sql.ssi(this.sre[i] - 0.1f, this.sre[i], this.srv);
            float f11 = this.sra[i * 4];
            float f12 = this.sra[i * 4 + 1];
            float f13 = this.sra[i * 4 + 2];
            float f14 = this.sra[i * 4 + 3];
            int n3 = this.sqs[i];
            int n4 = n3 + this.sqt[i];
            for (int j = n3; j < n4; ++j) {
                int n5 = j * 3;
                float f15 = this.sqv[n5] * f8;
                float f16 = this.sqv[n5 + 1] * f8;
                float f17 = this.sqv[n5 + 2] * f8;
                float f18 = this.sqw[n5];
                float f19 = this.sqw[n5 + 1];
                float f20 = this.sqw[n5 + 2];
                if (bl) {
                    float f21 = 2.0f * (f12 * f17 - f13 * f16);
                    float f22 = 2.0f * (f13 * f15 - f11 * f17);
                    float f23 = 2.0f * (f11 * f16 - f12 * f15);
                    float f24 = f15 + f14 * f21 + (f12 * f23 - f13 * f22);
                    float f25 = f16 + f14 * f22 + (f13 * f21 - f11 * f23);
                    float f26 = f17 + f14 * f23 + (f11 * f22 - f12 * f21);
                    f15 = f24;
                    f16 = f25;
                    f17 = f26;
                    f21 = 2.0f * (f12 * f20 - f13 * f19);
                    f22 = 2.0f * (f13 * f18 - f11 * f20);
                    f23 = 2.0f * (f11 * f19 - f12 * f18);
                    f24 = f18 + f14 * f21 + (f12 * f23 - f13 * f22);
                    f25 = f19 + f14 * f22 + (f13 * f21 - f11 * f23);
                    f26 = f20 + f14 * f23 + (f11 * f22 - f12 * f21);
                    f18 = f24;
                    f19 = f25;
                    f20 = f26;
                }
                byteBuffer.putFloat(f + f6 + f15);
                byteBuffer.putFloat(f2 + f5 + f16);
                byteBuffer.putFloat(f3 + f4 + f17);
                byteBuffer.putInt(this.sqx[j]);
                byteBuffer.putFloat(f7);
                byteBuffer.putFloat(f9);
                byteBuffer.put(sql.ssh(f18));
                byteBuffer.put(sql.ssh(f19));
                byteBuffer.put(sql.ssh(f20));
                byteBuffer.put((byte)0);
                ++n;
            }
        }
        return n;
    }

    public boolean sample(Random random, double[] dArray) {
        for (int i = 0; i < 6; ++i) {
            int n = random.nextInt(Math.max(1, this.sqq));
            if (n >= this.sqq || !this.srg[n]) continue;
            int n2 = n * 3;
            dArray[0] = this.x + (double)this.sqy[n2];
            dArray[1] = this.y + (double)this.sqy[n2 + 1];
            dArray[2] = this.z + (double)this.sqy[n2 + 2];
            dArray[3] = this.sqz[n2];
            dArray[4] = this.sqz[n2 + 1];
            dArray[5] = this.sqz[n2 + 2];
            return true;
        }
        return false;
    }

    public int takeEvents() {
        int n = this.srp;
        this.srp = 0;
        return n;
    }

    public int vertices() {
        return this.sqr;
    }

    public double centerX() {
        return this.x + (double)this.srh;
    }

    public double centerY() {
        return this.y + (double)this.sri;
    }

    public double centerZ() {
        return this.z + (double)this.srj;
    }

    public float scan() {
        return this.srs;
    }

    public float sweep() {
        return this.srt;
    }

    public float flash() {
        return this.sru;
    }

    public float broken() {
        return !this.totem && this.srr ? 1.0f : 0.0f;
    }

    public float alpha() {
        return this.srw;
    }

    private int ssf(int n) {
        int n2 = 0;
        int n3 = this.sqq - 1;
        while (n2 < n3) {
            int n4 = n2 + n3 + 1 >>> 1;
            if (this.sqs[n4] <= n) {
                n2 = n4;
                continue;
            }
            n3 = n4 - 1;
        }
        return n2;
    }

    private float ssg(float f, float f2) {
        return f + (f2 - f) * this.srn.nextFloat();
    }

    private static byte ssh(float f) {
        return (byte)Math.round(Math.max(-1.0f, Math.min(1.0f, f)) * 127.0f);
    }

    private static float ssi(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / (f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static /* synthetic */ int cfu(int n, int n2) {
        return n * n2 ^ 0x592B56E0;
    }

    private static /* synthetic */ int cfv(int n, int n2) {
        return (n ^ n2) + 1008891339;
    }
}

