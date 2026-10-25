/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gui.DrawContext
 */
package flow.splash;

import a.uut;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Random;
import net.minecraft.client.gui.DrawContext;

public final class Snow {
    static final int FAR = 0;
    static final int MID = 1;
    static final int NEAR = 2;
    static final int CRYSTAL = 3;
    private static final int[] COUNTS = new int[]{170, 80, 14, 9};
    private final int n;
    private final int[] kind;
    private final float[] x0;
    private final float[] y0;
    private final float[] speed;
    private final float[] size;
    private final float[] swayA;
    private final float[] swayF;
    private final float[] phase;
    private final float[] alpha;
    private final float[] depth;
    private final float[] spin;

    public Snow(long seed) {
        int total = 0;
        for (int c : COUNTS) {
            total += c;
        }
        this.n = total;
        this.kind = new int[this.n];
        this.x0 = new float[this.n];
        this.y0 = new float[this.n];
        this.speed = new float[this.n];
        this.size = new float[this.n];
        this.swayA = new float[this.n];
        this.swayF = new float[this.n];
        this.phase = new float[this.n];
        this.alpha = new float[this.n];
        this.depth = new float[this.n];
        this.spin = new float[this.n];
        Random r = new Random(seed);
        int i = 0;
        for (int k = 0; k < COUNTS.length; ++k) {
            int c;
            c = 0;
            while (c < COUNTS[k]) {
                this.kind[i] = k;
                this.x0[i] = r.nextFloat();
                this.y0[i] = r.nextFloat();
                this.phase[i] = r.nextFloat() * 6.2832f;
                this.swayF[i] = 0.35f + r.nextFloat() * 0.9f;
                this.spin[i] = (r.nextBoolean() ? 1.0f : -1.0f) * (0.25f + r.nextFloat() * 0.6f);
                switch (k) {
                    case 0: {
                        this.depth[i] = 0.25f + r.nextFloat() * 0.2f;
                        this.size[i] = 0.35f + r.nextFloat() * 0.45f;
                        this.speed[i] = 9.0f + r.nextFloat() * 8.0f;
                        this.swayA[i] = 2.0f + r.nextFloat() * 4.0f;
                        this.alpha[i] = 0.35f + r.nextFloat() * 0.4f;
                        break;
                    }
                    case 1: {
                        this.depth[i] = 0.5f + r.nextFloat() * 0.25f;
                        this.size[i] = 1.6f + r.nextFloat() * 1.8f;
                        this.speed[i] = 17.0f + r.nextFloat() * 12.0f;
                        this.swayA[i] = 4.0f + r.nextFloat() * 7.0f;
                        this.alpha[i] = 0.55f + r.nextFloat() * 0.35f;
                        break;
                    }
                    case 2: {
                        this.depth[i] = 1.1f + r.nextFloat() * 0.5f;
                        this.size[i] = 9.0f + r.nextFloat() * 13.0f;
                        this.speed[i] = 38.0f + r.nextFloat() * 22.0f;
                        this.swayA[i] = 8.0f + r.nextFloat() * 10.0f;
                        this.alpha[i] = 0.12f + r.nextFloat() * 0.14f;
                        break;
                    }
                    default: {
                        this.depth[i] = 0.8f + r.nextFloat() * 0.35f;
                        this.size[i] = 2.6f + r.nextFloat() * 2.4f;
                        this.speed[i] = 16.0f + r.nextFloat() * 10.0f;
                        this.swayA[i] = 6.0f + r.nextFloat() * 8.0f;
                        this.alpha[i] = 0.7f + r.nextFloat() * 0.25f;
                    }
                }
                ++c;
                ++i;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void draw(DrawContext ctx, GpuTextureView glow, float vw, float vh, float t, boolean front, float px, float py) {
        float wind = 7.0f * (float)Math.sin(t * 0.31f) + 3.5f * (float)Math.sin(t * 0.83f + 1.3f);
        uut.beginBatch();
        try {
            block8: for (int i = 0; i < this.n; ++i) {
                int k = this.kind[i];
                if (k >= 2 != front) continue;
                float margin = k == 2 ? 30.0f : 8.0f;
                float spanY = vh + margin * 2.0f;
                float spanX = vw + margin * 2.0f;
                float fall = this.y0[i] * spanY + t * this.speed[i];
                float y = fall % spanY - margin;
                float drift = this.depth[i] * (t * 6.0f + wind) + this.swayA[i] * (float)Math.sin(t * this.swayF[i] + this.phase[i]);
                float x = ((this.x0[i] * spanX + drift) % spanX + spanX) % spanX - margin;
                x -= px * this.depth[i] * 10.0f;
                y -= py * this.depth[i] * 6.0f;
                float a2 = this.alpha[i];
                switch (k) {
                    case 0: {
                        uut.circle(ctx, x, y, this.size[i], Snow.color(a2));
                        continue block8;
                    }
                    case 1: {
                        float tw = 0.78f + 0.22f * (float)Math.sin(t * 2.6f + this.phase[i] * 3.0f);
                        if (glow != null) {
                            uut.sprite(ctx, glow, x, y, this.size[i] * 2.6f, Snow.color(a2 * tw * 0.9f));
                        }
                        uut.circle(ctx, x, y, this.size[i] * 0.42f, Snow.color(a2 * tw));
                        continue block8;
                    }
                    case 2: {
                        if (glow != null) {
                            uut.sprite(ctx, glow, x, y, this.size[i], Snow.color(a2));
                            continue block8;
                        }
                        uut.circle(ctx, x, y, this.size[i] * 0.3f, Snow.color(a2 * 0.6f));
                        continue block8;
                    }
                    default: {
                        float rot = this.phase[i] + t * this.spin[i];
                        if (glow != null) {
                            uut.sprite(ctx, glow, x, y, this.size[i] * 3.4f, Snow.color(a2 * 0.32f));
                        }
                        Snow.crystal(ctx, x, y, this.size[i], rot, Snow.color(a2));
                    }
                }
            }
        }
        finally {
            uut.endBatch();
        }
    }

    public static void crystal(DrawContext ctx, float cx, float cy, float r, float rot, int color) {
        float w = Math.max(0.32f, r * 0.15f);
        for (int arm = 0; arm < 6; ++arm) {
            float ang = rot + (float)arm * 1.0472f;
            float c = (float)Math.cos(ang);
            float s = (float)Math.sin(ang);
            uut.line(ctx, cx, cy, cx + c * r, cy + s * r, w, color);
            if (r < 2.0f) continue;
            for (int side = -1; side <= 1; side += 2) {
                float bx = cx + c * r * 0.55f;
                float by = cy + s * r * 0.55f;
                float ba = ang + (float)side * 0.85f;
                float len = r * 0.34f;
                uut.line(ctx, bx, by, bx + (float)Math.cos(ba) * len, by + (float)Math.sin(ba) * len, w * 0.85f, color);
            }
        }
        uut.circle(ctx, cx, cy, w * 0.9f, color);
    }

    private static int color(float a2) {
        int al = Math.max(0, Math.min(255, Math.round(a2 * 255.0f)));
        return al << 24 | 0xF4FAFF;
    }
}

