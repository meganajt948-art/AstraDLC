/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gui.DrawContext
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.skx;
import a.smt;
import a.smw;
import a.sng;
import a.ujt;
import a.uut;
import a.vcq;
import a.vdn;
import a.vek;
import a.veo;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

public final class snp {
    private static final float snq = 16.0f;
    private static final int snr = 20;
    private static final float[] sns = new float[44];
    private static final vdn[][] snt = new vdn[vek.values().length][sns.length];
    private static final float snu = 1.3f;
    private static final float snv = 11.0f;
    private static final float snw = 11.0f;
    private static final float snx = 0.7f;
    private static final float sny = 0.95f;
    private static final float snz = 0.55f;
    private static final float soa = 0.024f;
    private static final float sob = 0.045f;
    private static final long soc = 4500L;
    private static final long sod = 80L;
    private static final float soe = (float)Math.PI * 2;
    private final smt[] sof;
    private final long[] sog;
    private final long[] soh;
    private final float[] soi;
    private final float[] soj;
    private final float[] sok;
    private final float[] sol;
    private final float som;
    private final float son;
    public final int line;
    public final boolean card;
    public final long holdUntil;
    public double x;
    public double y;
    public double z;
    public float yawOff;
    public float pitchOff;
    public float dist;
    public float age;
    public float hidden;
    private float soo = -1.0f;
    private float sop = -1.0f;
    private float[] soq = new float[0];
    private float[] sor = new float[0];
    private float[] sos = new float[0];
    private float[] sot = new float[0];
    private float[] sou = new float[0];
    private float[] sov = new float[0];
    private float[] sow = new float[0];
    private int[] sox = new int[0];
    private final float[] soy;
    private final float[] soz;
    private static /* synthetic */ long spa;
    private static /* synthetic */ String spb;

    private snp(int n, boolean bl, List<smw> list, float f, long l, Random random) {
        int n2;
        float f2;
        this.line = n;
        this.card = bl;
        this.holdUntil = l;
        ArrayList arrayList = new ArrayList();
        ArrayList<Float> arrayList2 = new ArrayList<Float>();
        ArrayList<smw> arrayList3 = new ArrayList<smw>();
        float f3 = 0.0f;
        for (smw smw2 : list) {
            float f4 = snp.spf(smw2.smx, smw2.smy) * smw2.smz;
            f2 = snp.spf(" ", smw2.smy) * smw2.smz;
            if (!arrayList3.isEmpty() && (smw2.snc || f3 + f2 + f4 > f)) {
                arrayList.add(arrayList3);
                arrayList2.add(Float.valueOf(f3));
                arrayList3 = new ArrayList();
                f3 = 0.0f;
            }
            f3 += (arrayList3.isEmpty() ? 0.0f : f2) + f4;
            arrayList3.add(smw2);
        }
        if (!arrayList3.isEmpty()) {
            arrayList.add(arrayList3);
            arrayList2.add(Float.valueOf(f3));
        }
        Object object = new float[arrayList.size()];
        float f5 = 0.0f;
        for (n2 = 0; n2 < arrayList.size(); ++n2) {
            f2 = 0.0f;
            for (smw smw3 : (List)arrayList.get(n2)) {
                f2 = Math.max(f2, smw3.smz);
            }
            object[n2] = 1.3f * f2;
            f5 += object[n2];
        }
        n2 = list.size();
        this.sog = new long[n2];
        this.soh = new long[n2];
        this.soi = new float[n2];
        this.soj = new float[n2];
        this.sok = new float[n2];
        this.sol = new float[n2];
        this.soy = new float[n2];
        this.soz = new float[n2];
        ArrayList<smt> arrayList4 = new ArrayList<smt>();
        float f6 = -f5 * 0.5f;
        int n3 = 0;
        float f7 = Float.MAX_VALUE;
        float f8 = -3.4028235E38f;
        for (int i = 0; i < arrayList.size(); ++i) {
            float f9 = f6 + object[i] * 0.5f;
            f6 += object[i];
            float f10 = -((Float)arrayList2.get(i)).floatValue() * 0.5f;
            int n4 = 1;
            for (smw smw4 : (List)arrayList.get(i)) {
                if (n4 == 0) {
                    f10 += snp.spf(" ", smw4.smy) * smw4.smz;
                }
                n4 = 0;
                float f11 = f10;
                int n5 = smw4.smx.codePointCount(0, smw4.smx.length());
                long l2 = n5 <= 1 ? 0L : Math.min(45L, Math.max(0L, (smw4.snb - smw4.sna) / (long)n5));
                int n6 = 0;
                int n7 = 0;
                while (n7 < smw4.smx.length()) {
                    int n8 = smw4.smx.codePointAt(n7);
                    n7 += Character.charCount(n8);
                    String string = new String(Character.toChars(n8));
                    float f12 = snp.spf(string, smw4.smy) * smw4.smz;
                    if (!Character.isWhitespace(n8)) {
                        arrayList4.add(new smt(string, smw4.smy, smw4.smz, f10 + f12 * 0.5f, f9, n3, smw4.sna == Long.MIN_VALUE ? Long.MIN_VALUE : smw4.sna + l2 * (long)n6, smw4.snd));
                    }
                    f10 += f12;
                    ++n6;
                }
                this.sog[n3] = smw4.sna;
                this.soh[n3] = smw4.snb;
                this.soi[n3] = (f11 + f10) * 0.5f;
                this.soj[n3] = f9;
                this.sok[n3] = f10 - f11;
                this.sol[n3] = smw4.smz;
                f7 = Math.min(f7, f11);
                f8 = Math.max(f8, f10);
                ++n3;
            }
        }
        this.sof = arrayList4.toArray(new smt[0]);
        this.som = f7 == Float.MAX_VALUE ? 0.0f : f7;
        this.son = f8 == -3.4028235E38f ? 0.0f : f8;
        float f13 = Math.max(0.001f, this.son - this.som);
        for (smt smt2 : this.sof) {
            smt2.vx = (random.nextFloat() * 2.0f - 1.0f) * 0.55f;
            smt2.vy = -(0.35f + random.nextFloat() * 0.8f);
            smt2.vr = (random.nextFloat() * 2.0f - 1.0f) * 0.9f;
            smt2.delay = 0.55f * (0.75f * (smt2.x - this.som) / f13 + 0.25f * random.nextFloat());
            smt2.phase = random.nextFloat() * ((float)Math.PI * 2);
            smt2.s1 = random.nextFloat() * 2.0f - 1.0f;
            smt2.s2 = random.nextFloat() * 2.0f - 1.0f;
        }
    }

    public static snp line(int n, skx skx2, Random random) {
        String[] stringArray = skx2.text().split(" ");
        long[] lArray = new long[stringArray.length];
        long[] lArray2 = new long[stringArray.length];
        long[] lArray3 = skx2.words();
        long l = Math.max(300L, skx2.end() - skx2.start());
        if (lArray3 != null && lArray3.length == stringArray.length) {
            for (var9_8 = 0; var9_8 < stringArray.length; ++var9_8) {
                lArray[var9_8] = lArray3[var9_8];
                lArray2[var9_8] = var9_8 + 1 < stringArray.length ? lArray3[var9_8 + 1] : Math.min(skx2.end(), lArray3[var9_8] + 900L);
            }
        } else {
            var9_8 = 0;
            for (String string : stringArray) {
                var9_8 += string.length();
            }
            long l2 = Math.max(500L, Math.min((long)((double)l * 0.9), (long)var9_8 * 80L));
            int n2 = 0;
            for (int i = 0; i < stringArray.length; ++i) {
                lArray[i] = skx2.start() + l2 * (long)n2 / (long)Math.max(1, var9_8);
                lArray2[i] = skx2.start() + l2 * (long)(n2 += stringArray[i].length()) / (long)Math.max(1, var9_8);
            }
        }
        ArrayList<smw> arrayList = new ArrayList<smw>(stringArray.length);
        for (int i = 0; i < stringArray.length; ++i) {
            arrayList.add(new smw(stringArray[i], vek.SEMIBOLD, 1.0f, lArray[i], lArray2[i], false, false));
        }
        return new snp(n, false, arrayList, 11.0f, lArray2[lArray2.length - 1] + 4500L, random);
    }

    public static snp card(String string, String string2, Random random) {
        ArrayList<smw> arrayList = new ArrayList<smw>();
        for (String string3 : string.split(" ")) {
            if (string3.isEmpty()) continue;
            arrayList.add(new smw(string3, vek.BOLD, 1.35f, Long.MIN_VALUE, Long.MIN_VALUE, false, false));
        }
        boolean bl = true;
        for (String string4 : string2.split(" ")) {
            if (string4.isEmpty()) continue;
            arrayList.add(new smw(string4, vek.MEDIUM, 0.62f, Long.MIN_VALUE, Long.MIN_VALUE, bl, true));
            bl = false;
        }
        return new snp(-1, true, arrayList, 11.0f, Long.MAX_VALUE, random);
    }

    public boolean isEmpty() {
        return this.sof.length == 0;
    }

    public void dissolve() {
        if (this.soo >= 0.0f) {
            return;
        }
        this.soo = 0.0f;
        for (smt smt2 : this.sof) {
            if (!(smt2.born > this.age)) continue;
            smt2.born = -1.0f;
        }
    }

    public boolean dissolving() {
        return this.soo >= 0.0f;
    }

    public boolean finished() {
        return this.soo > 1.8824999f;
    }

    public void update(float f, long l) {
        this.age += f;
        if (this.soo >= 0.0f) {
            this.soo += f;
            return;
        }
        for (smt smt2 : this.sof) {
            float f2;
            if (!(smt2.born < 0.0f) || !this.card && l < smt2.due) continue;
            smt2.born = f2 = Math.max(this.age, this.sop + (this.card ? 0.045f : 0.024f));
            this.sop = f2;
        }
        float f3 = Math.min(1.0f, f * 9.0f);
        for (smt smt3 : this.sof) {
            boolean bl = !this.card && l >= this.sog[smt3.word] && l < this.soh[smt3.word] + 120L;
            smt3.hl = smt3.hl + ((bl ? 1.0f : 0.0f) - smt3.hl) * f3;
        }
    }

    public void draw(DrawContext drawContext, float f, float f2, float f3, sng sng2, GpuTextureView gpuTextureView) {
        int n;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int n2;
        float f10 = sng2.alpha() * (1.0f - 0.85f * this.hidden);
        if (f10 <= 0.01f || this.sof.length == 0) {
            return;
        }
        int n3 = this.sof.length;
        if (this.soq.length < n3) {
            this.soq = new float[n3];
            this.sor = new float[n3];
            this.sos = new float[n3];
            this.sot = new float[n3];
            this.sou = new float[n3];
            this.sov = new float[n3];
            this.sow = new float[n3];
            this.sox = new int[n3];
        }
        Arrays.fill(this.soy, 0.0f);
        Arrays.fill(this.soz, 0.0f);
        float f11 = Math.max(0.001f, this.son - this.som);
        boolean bl = false;
        for (n2 = 0; n2 < n3; ++n2) {
            smt smt2 = this.sof[n2];
            if (smt2.born < 0.0f || this.age < smt2.born) {
                this.sou[n2] = 0.0f;
                continue;
            }
            f9 = vcq.clamp01((this.age - smt2.born) / 0.7f);
            f8 = this.soo < 0.0f ? 0.0f : vcq.clamp01((this.soo - smt2.delay) / 0.95f);
            f7 = 1.0f - f8;
            this.sou[n2] = f6 = vcq.outCubic(f9 * 1.5f) * f7 * f7;
            if (f6 <= 0.004f) continue;
            bl = true;
            f5 = vcq.outCubic(f8);
            float f12 = (1.0f - vcq.outBack(f9)) * 0.5f * smt2.scale;
            f4 = (float)Math.sin(this.age * 1.6f + smt2.phase) * 0.035f * smt2.scale;
            this.soq[n2] = f + (smt2.x + smt2.vx * f5 * 1.5f) * f3;
            this.sor[n2] = f2 + (smt2.y + f12 + f4 + smt2.vy * f5 * 1.8f) * f3;
            this.sos[n2] = (1.25f - 0.25f * vcq.outCubic(f9)) * (1.0f - 0.3f * f5) * (1.0f + 0.08f * smt2.hl);
            this.sot[n2] = smt2.vr * f5;
            this.sov[n2] = ((1.0f - vcq.outCubic(f9)) * 0.14f + f5 * 0.2f) * smt2.scale;
            this.sow[n2] = 1.0f - vcq.outCubic(f9 * 1.4f);
            int n4 = ujt.lerp(sng2.tone(), sng2.tone2(), (smt2.x - this.som) / f11);
            int n5 = ujt.lerp(n4, -1, 0.55f);
            int n6 = ujt.lerp(-1, n4, (smt2.dim ? 0.3f : 0.14f) + 0.5f * smt2.hl);
            this.sox[n2] = ujt.lerp(n6, n5, this.sow[n2] * 0.85f);
            float f13 = vcq.outCubic(f9 * 1.5f) * f7;
            this.soy[smt2.word] = Math.max(this.soy[smt2.word], f13);
            this.soz[smt2.word] = Math.max(this.soz[smt2.word], smt2.hl);
        }
        if (!bl) {
            return;
        }
        if (gpuTextureView != null) {
            if (sng2.shadow()) {
                uut.additive(false);
                for (n2 = 0; n2 < this.soy.length; ++n2) {
                    float f14 = this.soy[n2] * f10;
                    if (f14 <= 0.01f) continue;
                    f9 = this.sol[n2];
                    f8 = this.sok[n2] * f3 + 1.8f * f3 * f9;
                    f7 = 2.1f * f3 * f9;
                    f6 = f + this.soi[n2] * f3;
                    f5 = f2 + this.soj[n2] * f3;
                    uut.image(drawContext, gpuTextureView, f6 - f8 * 0.5f, f5 - f7 * 0.5f, f8, f7, 0.0f, ujt.withAlpha(0, Math.round(72.0f * f14)));
                }
            }
            if (sng2.glow() > 0.01f) {
                uut.additive(true);
                for (n2 = 0; n2 < this.soy.length; ++n2) {
                    float f15 = this.soy[n2] * f10 * sng2.glow();
                    if (f15 <= 0.01f) continue;
                    f9 = this.sol[n2];
                    f8 = this.sok[n2] * f3 + 1.4f * f3 * f9;
                    f7 = 1.75f * f3 * f9;
                    f6 = f + this.soi[n2] * f3;
                    f5 = f2 + this.soj[n2] * f3;
                    int n7 = ujt.lerp(sng2.tone(), sng2.tone2(), (this.soi[n2] - this.som) / f11);
                    uut.image(drawContext, gpuTextureView, f6 - f8 * 0.5f, f5 - f7 * 0.5f, f8, f7, 0.0f, ujt.withAlpha(n7, Math.round((40.0f + 70.0f * this.soz[n2]) * f15)));
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    float f16 = this.sow[n2] * this.sou[n2] * f10 * (0.35f + 0.65f * sng2.glow());
                    if (f16 <= 0.01f) continue;
                    f9 = 2.4f * f3 * this.sof[n2].scale * this.sos[n2];
                    uut.sprite(drawContext, gpuTextureView, this.soq[n2], this.sor[n2], f9, ujt.withAlpha(this.sox[n2], Math.round(150.0f * f16)));
                }
                uut.additive(false);
            }
        }
        if (sng2.shadow()) {
            float f17 = 0.045f * f3;
            float f18 = 0.065f * f3;
            for (int i = 0; i < n3; ++i) {
                f8 = this.sou[i] * f10;
                if (f8 <= 0.01f) continue;
                snp.spc(drawContext, this.sof[i], this.soq[i] + f17 * this.sof[i].scale, this.sor[i] + f18 * this.sof[i].scale, f3, this.sos[i], this.sot[i], ujt.withAlpha(0, Math.round(90.0f * f8)));
            }
        }
        for (n = 0; n < n3; ++n) {
            float f19 = this.sou[n] * f10;
            if (f19 <= 0.01f) continue;
            smt smt3 = this.sof[n];
            f8 = this.sov[n] * f3;
            f7 = f19;
            if (f8 > 0.35f) {
                f7 = f19 * (1.0f - Math.min(0.55f, this.sov[n] * 2.8f));
                int n8 = ujt.withAlpha(this.sox[n], Math.round(255.0f * f19 * 0.3f * (smt3.dim ? 0.8f : 1.0f)));
                f5 = f8 * 0.7071f;
                snp.spc(drawContext, smt3, this.soq[n] - f5, this.sor[n] - f5, f3, this.sos[n], this.sot[n], n8);
                snp.spc(drawContext, smt3, this.soq[n] + f5, this.sor[n] - f5, f3, this.sos[n], this.sot[n], n8);
                snp.spc(drawContext, smt3, this.soq[n] - f5, this.sor[n] + f5, f3, this.sos[n], this.sot[n], n8);
                snp.spc(drawContext, smt3, this.soq[n] + f5, this.sor[n] + f5, f3, this.sos[n], this.sot[n], n8);
            }
            snp.spc(drawContext, smt3, this.soq[n], this.sor[n], f3, this.sos[n], this.sot[n], ujt.withAlpha(this.sox[n], Math.round(255.0f * f7 * (smt3.dim ? 0.8f : 1.0f))));
        }
        if (gpuTextureView != null && sng2.particles() && this.soo >= 0.0f) {
            uut.additive(true);
            for (n = 0; n < n3; ++n) {
                float f20;
                smt smt4 = this.sof[n];
                if (smt4.born < 0.0f || (f20 = vcq.clamp01((this.soo - smt4.delay) / 1.2825f)) <= 0.0f || f20 >= 1.0f) continue;
                f8 = vcq.outCubic(f20);
                f7 = (float)Math.sin(Math.PI * (double)f20) * f10;
                int n9 = ujt.lerp(sng2.tone(), sng2.tone2(), (smt4.x - this.som) / f11);
                int n10 = ujt.lerp(n9, -1, 0.65f);
                for (int i = 0; i < 2; ++i) {
                    f4 = i == 0 ? smt4.s1 : smt4.s2;
                    float f21 = f + (smt4.x + (smt4.vx + f4 * 0.7f) * f8 * 2.2f) * f3 + (float)Math.sin(this.soo * 5.0f + smt4.phase + (float)i) * 0.08f * f3;
                    float f22 = f2 + (smt4.y + smt4.vy * (1.4f + 0.5f * (float)i) * f8 * 2.2f) * f3;
                    float f23 = Math.max(1.2f, f3 * 0.14f * smt4.scale * (1.0f - 0.5f * f20));
                    uut.sprite(drawContext, gpuTextureView, f21, f22, f23 * 4.0f, ujt.withAlpha(n9, Math.round(80.0f * f7)));
                    uut.sprite(drawContext, gpuTextureView, f21, f22, f23, ujt.withAlpha(n10, Math.round(230.0f * f7)));
                }
            }
            uut.additive(false);
        }
    }

    private static void spc(DrawContext drawContext, smt smt2, float f, float f2, float f3, float f4, float f5, int n) {
        if (n >>> 24 == 0) {
            return;
        }
        float f6 = f3 * smt2.scale;
        int n2 = snp.spd(f6);
        vdn vdn2 = snp.spe(smt2.weight, n2);
        float f7 = f6 * f4 / (16.0f * sns[n2]);
        Matrix3x2fStack matrix3x2fStack = drawContext.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f, f2);
        if (f5 != 0.0f) {
            matrix3x2fStack.rotate(f5);
        }
        matrix3x2fStack.scale(f7, f7);
        vdn2.draw(drawContext, smt2.ch, -vdn2.width(smt2.ch) * 0.5f, vdn2.centerTop(0.0f), n);
        matrix3x2fStack.popMatrix();
    }

    private static int spd(float f) {
        int n = Math.round((float)(Math.log(Math.max(0.01f, f) / 16.0f) / Math.log(2.0) * 8.0)) + 20;
        return Math.max(0, Math.min(sns.length - 1, n));
    }

    private static vdn spe(vek vek2, int n) {
        vdn vdn2 = snt[vek2.ordinal()][n];
        if (vdn2 == null) {
            snp.snt[vek2.ordinal()][n] = vdn2 = veo.get(vek2, 16.0f * sns[n]);
        }
        return vdn2;
    }

    private static float spf(String string, vek vek2) {
        return snp.spe(vek2, 20).width(string) / 16.0f;
    }

    static {
        for (int i = 0; i < sns.length; ++i) {
            snp.sns[i] = (float)Math.pow(2.0, (double)(i - 20) / 8.0);
        }
        snp.sns[20] = 1.0f;
    }

    private static /* synthetic */ int cfj(int n, int n2) {
        return n * n2 + 694939581;
    }

    private static /* synthetic */ int cfk(int n, int n2) {
        return snp.cfj(n, n2) ^ 0x6385C9D1;
    }
}

