/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package a;

import a.stf;
import a.sti;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.class_243;

public final class ThunderState {
    private static final float stq = 343.0f;
    private final Random str = new Random();
    private final float[] sts = new float[320];
    private final float[] stt = new float[320];
    private final ArrayDeque<stf> stu = new ArrayDeque();
    private final ArrayDeque<sti> stv = new ArrayDeque();
    private int stw;
    private double stx = 4.0;
    private boolean sty;
    private boolean stz;
    private double sua;
    private double sub;
    private float[] suc = new float[0];
    private float[] sud = new float[0];
    private double sue;
    private double suf;
    private double sug;
    private float suh;
    private double sui = -1.0;
    private static /* synthetic */ int suj;
    private static /* synthetic */ long suk;

    public void freeze(double d) {
        this.sui = d;
    }

    public void reset() {
        this.sty = false;
        this.stw = 0;
        this.stu.clear();
        this.stv.clear();
        this.stx = 3.0 + this.str.nextDouble() * 4.0;
    }

    public void strike(class_243 class_2432, float f, double d, float f2, boolean bl) {
        this.sul(class_2432, f, d, f2, bl, this.str.nextDouble() * Math.PI * 2.0);
    }

    public void strike(class_243 class_2432, float f, double d, float f2, boolean bl, double d2) {
        this.sul(class_2432, f, d, f2, bl, d2);
    }

    public void update(double d, float f, class_243 class_2432, float f2, double d2) {
        if (this.sty) {
            double d3 = this.sua = this.sui >= 0.0 ? this.sui : this.sua + d;
            if (this.sua > this.sub) {
                this.sty = false;
                this.stw = 0;
            }
        }
        Iterator<stf> iterator = this.stu.iterator();
        while (iterator.hasNext()) {
            stf stf2 = iterator.next();
            stf2.left -= d;
            if (!(stf2.left <= 0.0)) continue;
            this.stv.add(stf2.thunder);
            iterator.remove();
        }
        if ((double)f <= 0.001) {
            return;
        }
        this.stx -= d;
        if (this.stx <= 0.0 && !this.sty) {
            double d4 = 55.0 - 50.0 * (double)f;
            this.stx = Math.max(1.5, -Math.log(1.0 - this.str.nextDouble()) * d4);
            float f3 = (float)(220.0 * Math.pow(14.0, this.str.nextDouble()));
            this.sul(class_2432, f2, d2, f3, this.str.nextDouble() < 0.4, this.str.nextDouble() * Math.PI * 2.0);
        }
    }

    private void sul(class_243 class_2432, float f, double d, float f2, boolean bl, double d2) {
        this.suh = f2;
        this.sue = class_2432.field_1352 + Math.cos(d2) * (double)f2;
        this.sug = class_2432.field_1350 + Math.sin(d2) * (double)f2;
        this.suf = class_2432.field_1351 + (double)f + 30.0 + this.str.nextDouble() * 80.0;
        this.stz = bl;
        int n = bl ? 1 + this.str.nextInt(4) : 3 + this.str.nextInt(5);
        this.suc = new float[n];
        this.sud = new float[n];
        float f3 = 0.0f;
        for (int i = 0; i < n; ++i) {
            this.suc[i] = f3;
            this.sud[i] = i == 0 ? 1.0f : 0.45f + 0.5f * this.str.nextFloat();
            f3 += bl ? 0.04f + 0.1f * this.str.nextFloat() : 0.03f + 0.14f * this.str.nextFloat();
        }
        this.sua = 0.0;
        this.sub = (double)f3 + (bl ? 0.7 : 0.45);
        this.sty = true;
        this.stw = 0;
        if (bl) {
            this.sum(d);
        }
        if (this.stu.size() < 6) {
            this.stu.add(new stf(f2 / 343.0f, new sti(this.sue, this.sug, f2, bl)));
        }
    }

    public sti nextThunder() {
        return this.stv.poll();
    }

    public float brightness() {
        if (!this.sty) {
            return 0.0f;
        }
        float f = 0.0f;
        for (int i = 0; i < this.suc.length; ++i) {
            float f2 = (float)this.sua - this.suc[i];
            if (f2 < 0.0f) continue;
            float f3 = Math.min(1.0f, f2 / 0.008f);
            f += this.sud[i] * f3 * (float)Math.exp(-f2 / (this.stz ? 0.05f : 0.07f));
        }
        float f4 = (float)this.sua;
        return f += (this.stz ? 0.16f : 0.08f) * (float)Math.exp(-f4 / 0.28f) * Math.min(1.0f, f4 / 0.02f);
    }

    public float boltBrightness() {
        if (!this.sty || !this.stz) {
            return 0.0f;
        }
        float f = 0.0f;
        for (int i = 0; i < this.suc.length; ++i) {
            float f2 = (float)this.sua - this.suc[i];
            if (f2 < 0.0f) continue;
            f = Math.max(f, this.sud[i] * Math.min(1.0f, f2 / 0.006f) * (float)Math.exp(-f2 / 0.09f));
        }
        float f3 = (float)this.sua - this.suc[this.suc.length - 1];
        if (f3 > 0.0f) {
            f = Math.max(f, 0.18f * (float)Math.exp(-f3 / 0.2f));
        }
        return f;
    }

    public boolean active() {
        return this.sty;
    }

    public boolean isBolt() {
        return this.stz;
    }

    public float distance() {
        return this.suh;
    }

    public double x() {
        return this.sue;
    }

    public double y() {
        return this.suf;
    }

    public double z() {
        return this.sug;
    }

    public int segments() {
        return this.sty && this.stz ? this.stw : 0;
    }

    public float[] segA() {
        return this.sts;
    }

    public float[] segB() {
        return this.stt;
    }

    private void sum(double d) {
        double d2 = (this.str.nextDouble() - 0.5) * 120.0;
        double d3 = (this.str.nextDouble() - 0.5) * 120.0;
        double d4 = d - this.suf;
        float[] fArray = this.sun(0.0, 0.0, 0.0, d2, d4, d3, 40, 0.11);
        this.stw = 0;
        this.suo(fArray, 1.6f, 1.0f, 0.12f);
        int n = 3 + this.str.nextInt(4);
        int n2 = fArray.length / 3;
        for (int i = 0; i < n && this.stw < 76; ++i) {
            int n3 = 2 + this.str.nextInt(Math.max(1, (int)((double)n2 * 0.65)));
            double d5 = fArray[n3 * 3];
            double d6 = fArray[n3 * 3 + 1];
            double d7 = fArray[n3 * 3 + 2];
            double d8 = -d4 * (0.12 + 0.28 * this.str.nextDouble());
            double d9 = this.str.nextDouble() * Math.PI * 2.0;
            double d10 = d5 + Math.cos(d9) * d8 * 0.7;
            double d11 = d7 + Math.sin(d9) * d8 * 0.7;
            double d12 = d6 - d8 * (0.55 + 0.4 * this.str.nextDouble());
            float[] fArray2 = this.sun(d5, d6, d7, d10, d12, d11, 6 + this.str.nextInt(7), 0.16);
            this.suo(fArray2, 0.75f, 0.4f + 0.25f * this.str.nextFloat(), 0.75f);
        }
    }

    private float[] sun(double d, double d2, double d3, double d4, double d5, double d6, int n, double d7) {
        float[] fArray = new float[(n + 1) * 3];
        double d8 = d4 - d;
        double d9 = d5 - d2;
        double d10 = d6 - d3;
        double d11 = Math.sqrt(d8 * d8 + d9 * d9 + d10 * d10) / (double)n;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        for (int i = 0; i <= n; ++i) {
            double d15 = (double)i / (double)n;
            if (i > 0 && i < n) {
                d12 = d12 * 0.9 + (this.str.nextDouble() - 0.5) * d11 * d7 * 9.0;
                d14 = d14 * 0.9 + (this.str.nextDouble() - 0.5) * d11 * d7 * 9.0;
                d13 = d13 * 0.8 + (this.str.nextDouble() - 0.5) * d11 * d7 * 2.0;
            } else {
                d12 = 0.0;
                d13 = 0.0;
                d14 = 0.0;
            }
            double d16 = Math.min(1.0, (1.0 - d15) * 6.0);
            fArray[i * 3] = (float)(d + d8 * d15 + d12 * d16);
            fArray[i * 3 + 1] = (float)(d2 + d9 * d15 + d13 * d16);
            fArray[i * 3 + 2] = (float)(d3 + d10 * d15 + d14 * d16);
        }
        return fArray;
    }

    private void suo(float[] fArray, float f, float f2, float f3) {
        int n = fArray.length / 3;
        for (int i = 0; i < n - 1 && this.stw < 80; ++i) {
            int n2 = this.stw * 4;
            float f4 = 1.0f - f3 * (float)i / (float)Math.max(1, n - 1);
            this.sts[n2] = fArray[i * 3];
            this.sts[n2 + 1] = fArray[i * 3 + 1];
            this.sts[n2 + 2] = fArray[i * 3 + 2];
            this.sts[n2 + 3] = f * (0.35f + 0.65f * f4);
            this.stt[n2] = fArray[(i + 1) * 3];
            this.stt[n2 + 1] = fArray[(i + 1) * 3 + 1];
            this.stt[n2 + 2] = fArray[(i + 1) * 3 + 2];
            this.stt[n2 + 3] = f2 * f4;
            ++this.stw;
        }
    }

    private static /* synthetic */ int cgo(int n, int n2) {
        return n * n2 | 0xF35137E;
    }

    private static /* synthetic */ int cgp(int n, int n2) {
        return ThunderState.cgo(n, n2) + n;
    }
}

