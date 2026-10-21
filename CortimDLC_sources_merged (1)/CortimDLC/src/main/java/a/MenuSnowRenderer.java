/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_332
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.jsf;
import a.DrawUtil;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.splash.Snow;
import java.util.Random;
import net.minecraft.class_332;
import org.joml.Matrix3x2fStack;

public final class MenuSnowRenderer {
    private static final int[] jsj = new int[]{16762844, 16756940, 16768489, 16227517};
    private static final int[] jsk = new int[]{15234090, 14241823, 15901498, 13058076, 15319114};
    private final jsf jsl;
    private final Snow jsm;
    private final int jsn;
    private final float[] jso;
    private final float[] jsp;
    private final float[] jsq;
    private final float[] jsr;
    private final float[] jss;
    private final float[] jst;
    private final float[] jsu;
    private final float[] jsv;
    private final float[] jsw;
    private final int[] jsx;
    private static /* synthetic */ int jsy;
    private static /* synthetic */ String jsz;

    public MenuSnowRenderer(jsf jsf2, long l) {
        this.jsl = jsf2;
        this.jsm = jsf2 == jsf.SNOW ? new Snow(l) : null;
        this.jsn = switch (jsf2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0;
            case 1 -> 70;
            case 2 -> 90;
            case 3 -> 34;
            case 4 -> 46;
            case 5, 6 -> 64;
        };
        this.jso = new float[this.jsn];
        this.jsp = new float[this.jsn];
        this.jsq = new float[this.jsn];
        this.jsr = new float[this.jsn];
        this.jss = new float[this.jsn];
        this.jst = new float[this.jsn];
        this.jsu = new float[this.jsn];
        this.jsv = new float[this.jsn];
        this.jsw = new float[this.jsn];
        this.jsx = new int[this.jsn];
        Random random = new Random(l);
        block14: for (int i = 0; i < this.jsn; ++i) {
            this.jso[i] = random.nextFloat();
            this.jsp[i] = random.nextFloat();
            this.jsu[i] = random.nextFloat() * 6.2832f;
            this.jst[i] = 0.3f + random.nextFloat() * 0.8f;
            this.jsv[i] = (random.nextBoolean() ? 1.0f : -1.0f) * (0.6f + random.nextFloat() * 1.6f);
            this.jsw[i] = 0.3f + random.nextFloat() * (i % 9 == 0 ? 1.3f : 0.7f);
            switch (jsf2.ordinal()) {
                case 1: {
                    this.jsr[i] = (1.6f + random.nextFloat() * 1.4f) * this.jsw[i];
                    this.jsq[i] = (9.0f + random.nextFloat() * 9.0f) * this.jsw[i];
                    this.jss[i] = 6.0f + random.nextFloat() * 10.0f;
                    this.jsx[i] = jsj[random.nextInt(jsj.length)];
                    continue block14;
                }
                case 3: {
                    this.jsr[i] = (2.6f + random.nextFloat() * 2.0f) * this.jsw[i];
                    this.jsq[i] = (11.0f + random.nextFloat() * 10.0f) * this.jsw[i];
                    this.jss[i] = 9.0f + random.nextFloat() * 14.0f;
                    this.jsx[i] = jsk[random.nextInt(jsk.length)];
                    continue block14;
                }
                case 2: {
                    this.jsr[i] = (0.5f + random.nextFloat() * 0.9f) * this.jsw[i];
                    this.jsq[i] = -(1.5f + random.nextFloat() * 4.0f) * this.jsw[i];
                    this.jss[i] = 4.0f + random.nextFloat() * 8.0f;
                    this.jsx[i] = random.nextInt(3) == 0 ? 0xFFFFFF : 16769704;
                    continue block14;
                }
                case 5: 
                case 6: {
                    this.jsr[i] = (0.45f + random.nextFloat() * 0.8f) * this.jsw[i];
                    this.jsq[i] = -(1.0f + random.nextFloat() * 3.0f) * this.jsw[i];
                    this.jss[i] = 4.0f + random.nextFloat() * 8.0f;
                    this.jsx[i] = jsf2 == jsf.SILVER ? (random.nextInt(3) == 0 ? 0xFFFFFF : 14476012) : 1974310;
                    continue block14;
                }
                default: {
                    this.jsr[i] = (0.7f + random.nextFloat() * 0.9f) * this.jsw[i];
                    this.jsq[i] = -(1.0f + random.nextFloat() * 3.0f) * this.jsw[i];
                    this.jss[i] = 6.0f + random.nextFloat() * 12.0f;
                    this.jsx[i] = random.nextInt(4) == 0 ? 0xFFF0B0 : 12120319;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void draw(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, boolean bl, float f4, float f5, float f6) {
        if (f6 <= 0.003f) {
            return;
        }
        DrawUtil.pushAlpha(f6);
        try {
            if (this.jsm != null) {
                this.jsm.draw(class_3322, gpuTextureView, f, f2, f3, bl, f4, f5);
                return;
            }
            float f7 = 6.0f * (float)Math.sin(f3 * 0.27f) + 3.0f * (float)Math.sin(f3 * 0.71f + 1.1f);
            DrawUtil.beginBatch();
            try {
                for (int i = 0; i < this.jsn; ++i) {
                    if (this.jsw[i] > 1.05f != bl) continue;
                    this.jta(class_3322, gpuTextureView, i, f, f2, f3, f7, f4, f5);
                }
            }
            finally {
                DrawUtil.endBatch();
            }
        }
        finally {
            DrawUtil.popAlpha();
        }
    }

    private void jta(class_332 class_3322, GpuTextureView gpuTextureView, int n, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = 16.0f;
        float f8 = f2 + f7 * 2.0f;
        float f9 = f + f7 * 2.0f;
        float f10 = this.jsp[n] * f8 + f3 * this.jsq[n];
        float f11 = (f10 % f8 + f8) % f8 - f7;
        float f12 = this.jsw[n] * (f3 * (this.jsl == jsf.LEAVES ? 9.0f : 5.0f) + f4) + this.jss[n] * (float)Math.sin(f3 * this.jst[n] + this.jsu[n]);
        float f13 = ((this.jso[n] * f9 + f12) % f9 + f9) % f9 - f7;
        f13 -= f5 * this.jsw[n] * 10.0f;
        f11 -= f6 * this.jsw[n] * 6.0f;
        float f14 = Math.min(1.0f, 0.35f + this.jsw[n] * 0.55f);
        switch (this.jsl.ordinal()) {
            case 1: {
                this.jtb(class_3322, f13, f11, this.jsr[n], this.jsr[n] * 0.62f, f3, n, MenuSnowRenderer.jtd(this.jsx[n], 0.85f * f14), true);
                break;
            }
            case 3: {
                this.jtb(class_3322, f13, f11, this.jsr[n], this.jsr[n] * 0.55f, f3, n, MenuSnowRenderer.jtd(this.jsx[n], 0.95f * f14), false);
                break;
            }
            case 6: {
                float f15 = 0.55f + 0.45f * (float)Math.sin(f3 * (1.1f + this.jst[n]) + this.jsu[n] * 3.0f);
                DrawUtil.circle(class_3322, f13, f11, this.jsr[n] * 0.5f, MenuSnowRenderer.jtd(this.jsx[n], 0.5f * f15 * f14));
                break;
            }
            case 2: 
            case 5: {
                float f16 = 0.55f + 0.45f * (float)Math.sin(f3 * (1.1f + this.jst[n]) + this.jsu[n] * 3.0f);
                if (gpuTextureView != null) {
                    DrawUtil.additive(true);
                    DrawUtil.sprite(class_3322, gpuTextureView, f13, f11, this.jsr[n] * 7.0f, MenuSnowRenderer.jtd(this.jsx[n], 0.35f * f16 * f14));
                    DrawUtil.additive(false);
                }
                DrawUtil.circle(class_3322, f13, f11, this.jsr[n] * 0.5f, MenuSnowRenderer.jtd(this.jsx[n], 0.8f * f16 * f14));
                break;
            }
            default: {
                float f17 = Math.max(0.0f, (float)Math.sin(f3 * (0.6f + this.jst[n] * 0.7f) + this.jsu[n] * 5.0f));
                f17 *= f17;
                float f18 = f13 + 6.0f * (float)Math.sin(f3 * 0.43f + this.jsu[n] * 2.0f);
                if (gpuTextureView != null) {
                    DrawUtil.additive(true);
                    DrawUtil.sprite(class_3322, gpuTextureView, f18, f11, this.jsr[n] * 11.0f, MenuSnowRenderer.jtd(this.jsx[n], 0.45f * f17 * f14));
                    DrawUtil.additive(false);
                }
                DrawUtil.circle(class_3322, f18, f11, this.jsr[n] * 0.45f, MenuSnowRenderer.jtd(0xFFFFFF, (0.25f + 0.7f * f17) * f14));
            }
        }
    }

    private void jtb(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, int n2, boolean bl) {
        int n3;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f, f2);
        matrix3x2fStack.rotate(this.jsu[n] + f5 * this.jsv[n] * 0.6f);
        float f6 = (float)Math.cos(f5 * this.jsv[n] * 1.3f + this.jsu[n]);
        float f7 = Math.max(0.12f, Math.abs(f6));
        matrix3x2fStack.scale(f7, 1.0f);
        int n4 = n3 = f6 < 0.0f ? MenuSnowRenderer.jtc(n2, 0.82f) : n2;
        if (bl) {
            DrawUtil.round(class_3322, -f3 * 0.5f, -f4 * 0.5f, f3, f4, f4 * 0.5f, n3);
        } else {
            matrix3x2fStack.rotate(0.785f);
            float f8 = f3 * 0.62f;
            DrawUtil.round(class_3322, -f8 * 0.5f, -f8 * 0.5f, f8, f8, 0.0f, f8 * 0.5f, 0.0f, f8 * 0.5f, n3);
            DrawUtil.line(class_3322, -f8 * 0.42f, -f8 * 0.42f, f8 * 0.42f, f8 * 0.42f, Math.max(0.25f, f8 * 0.07f), MenuSnowRenderer.jtc(n3, 0.7f));
        }
        matrix3x2fStack.popMatrix();
    }

    private static int jtc(int n, float f) {
        int n2 = Math.round((float)(n >> 16 & 0xFF) * f);
        int n3 = Math.round((float)(n >> 8 & 0xFF) * f);
        int n4 = Math.round((float)(n & 0xFF) * f);
        return n & 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    private static int jtd(int n, float f) {
        int n2 = Math.max(0, Math.min(255, Math.round(f * 255.0f)));
        return n2 << 24 | n & 0xFFFFFF;
    }

    private static /* synthetic */ int aqa(int n, int n2) {
        return n ^ n2 | 0x4A24D328;
    }

    private static /* synthetic */ int aqb(int n, int n2) {
        return n + n2 + 420995065;
    }
}

