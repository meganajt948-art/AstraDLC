/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.RenderTickCounter
 */
package a;

import a.hlc;
import a.kfa;
import a.kfe;
import a.rfv;
import a.ujt;
import a.unf;
import a.unm;
import a.usn;
import a.uut;
import a.vcq;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;

public class rfy
extends kfe {
    private static rfy rfz;
    private final vlv rga = this.add(new vlv("Theme", "Ring", "Ring", "Lightning", "Winter", "Lava", "Cosmos", "Aurora", "Ocean", "Neon", "Sakura"));
    private final vla rgb = this.add(new vla("Color", "Theme"));
    private final vmc rgc = this.add(new vmc("Size", 1.2, 0.5, 3.0, 0.05).suffix("blocks"));
    private final vmc rgd = this.add(new vmc("Duration", 1.2, 0.4, 3.0, 0.1).suffix("s"));
    private final vmc rge = this.add(new vmc("Brightness", 0.9, 0.3, 1.0, 0.05).percent());
    private final vkl rgf = this.add(new vkl("Particles", true));
    private static final int rgg = 8;
    private static final float rgh = (float)Math.PI * 2;
    private final List<rfv> rgi = new ArrayList<rfv>();
    private final Random rgj = new Random();
    private boolean rgk = true;
    private double rgl;
    private long rgm = -1L;
    private float rgn;
    private final float[] rgo = new float[20];
    private final float[][] rgp = new float[49][3];
    private final boolean[] rgq = new boolean[49];
    private final float[] rgr = new float[3];
    private final float[] rgs = new float[3];
    private static /* synthetic */ int rgt;
    private static /* synthetic */ int rgu;

    public rfy() {
        super(new String(new char[]{'J', 'u', 'm', 'p', 'C', 'i', 'r', 'c', 'l', 'e', 's'}), "A circle where you jump", kfa.RENDER);
        rfz = this;
        this.rgb.visibleWhen(() -> this.rga.is("Ring") || this.rga.is("Lightning") || this.rga.is("Cosmos") || this.rga.is("Neon"));
    }

    @Override
    protected void onEnable() {
        this.rgi.clear();
        this.rgk = this.mc.field_1724 == null || this.mc.field_1724.method_24828();
    }

    @Override
    protected void onDisable() {
        this.rgi.clear();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        boolean bl = clientPlayerEntity.method_24828();
        if (bl) {
            this.rgl = clientPlayerEntity.method_23318();
        }
        if (!(!this.rgk || bl || !(clientPlayerEntity.method_18798().field_1351 > 0.06) || clientPlayerEntity.method_5765() || clientPlayerEntity.method_7325() || clientPlayerEntity.method_5799() || clientPlayerEntity.method_6101())) {
            this.rgv(clientPlayerEntity.method_23317(), this.rgl, clientPlayerEntity.method_23321());
        }
        this.rgk = bl;
    }

    private void rgv(double d, double d2, double d3) {
        if (this.rgi.size() >= 8) {
            this.rgi.remove(0);
        }
        rfv rfv2 = new rfv();
        rfv2.x = d;
        rfv2.y = d2 + 0.02;
        rfv2.z = d3;
        rfv2.seed = this.rgj.nextFloat() * 100.0f;
        rfv2.bolts = this.rgw();
        int n = 18;
        rfv2.parts = new float[n * 5];
        for (int i = 0; i < n; ++i) {
            rfv2.parts[i * 5] = this.rgj.nextFloat() * ((float)Math.PI * 2);
            rfv2.parts[i * 5 + 1] = 0.55f + this.rgj.nextFloat() * 0.5f;
            rfv2.parts[i * 5 + 2] = 0.5f + this.rgj.nextFloat();
            rfv2.parts[i * 5 + 3] = this.rgj.nextFloat() * ((float)Math.PI * 2);
            rfv2.parts[i * 5 + 4] = 0.6f + this.rgj.nextFloat() * 0.6f;
        }
        this.rgi.add(rfv2);
    }

    private float[][] rgw() {
        ArrayList<float[]> arrayList = new ArrayList<float[]>();
        int n = 9 + this.rgj.nextInt(4);
        float f = this.rgj.nextFloat() * ((float)Math.PI * 2);
        for (int i = 0; i < n; ++i) {
            float f2 = f + (float)i * ((float)Math.PI * 2) / (float)n + (this.rgj.nextFloat() - 0.5f) * 0.4f;
            float f3 = 0.18f + this.rgj.nextFloat() * 0.1f;
            float f4 = 0.62f + this.rgj.nextFloat() * 0.35f;
            arrayList.add(this.rgx(f2, f3, f4, 7));
            if (!(this.rgj.nextFloat() < 0.7f)) continue;
            float f5 = f3 + (f4 - f3) * (0.35f + this.rgj.nextFloat() * 0.3f);
            float f6 = this.rgj.nextBoolean() ? 1.0f : -1.0f;
            float[] fArray = this.rgx(f2, f5, f5 + 0.25f + this.rgj.nextFloat() * 0.2f, 4);
            for (int j = 0; j < fArray.length / 2; ++j) {
                float f7 = (float)j / (float)(fArray.length / 2 - 1);
                float f8 = f6 * f7 * 0.35f;
                float f9 = fArray[j * 2];
                float f10 = fArray[j * 2 + 1];
                fArray[j * 2] = (float)((double)f9 * Math.cos(f8) - (double)f10 * Math.sin(f8));
                fArray[j * 2 + 1] = (float)((double)f9 * Math.sin(f8) + (double)f10 * Math.cos(f8));
            }
            arrayList.add(fArray);
        }
        return (float[][])arrayList.toArray((T[])new float[0][]);
    }

    private float[] rgx(float f, float f2, float f3, int n) {
        float[] fArray = new float[n * 2];
        float f4 = 0.0f;
        for (int i = 0; i < n; ++i) {
            float f5 = (float)i / (float)(n - 1);
            float f6 = f2 + (f3 - f2) * f5;
            if (i > 0 && i < n - 1) {
                f4 = f4 * 0.5f + (this.rgj.nextFloat() - 0.5f) * 0.35f;
            }
            float f7 = f + f4 / Math.max(0.2f, f6);
            fArray[i * 2] = (float)Math.cos(f7) * f6;
            fArray[i * 2 + 1] = (float)Math.sin(f7) * f6;
        }
        return fArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        rfy rfy2 = rfz;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rfy2 == null || !rfy2.isEnabled() || rfy2.rgi.isEmpty() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rfy2.rgm) {
            return;
        }
        rfy2.rgm = unf.frame();
        float f = unf.delta();
        rfy2.rgn += f;
        try {
            usn2 = usn.capture(renderTickCounter.method_60637(true), drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        float f2 = (float)rfy2.rgd.get();
        uut.beginFrame();
        uut.pushAlpha((float)rfy2.rge.get());
        try {
            for (int i = rfy2.rgi.size() - 1; i >= 0; --i) {
                rfv rfv2 = rfy2.rgi.get(i);
                rfv2.age += f;
                if (rfv2.age >= f2) {
                    rfy2.rgi.remove(i);
                    continue;
                }
                if (usn2.distance(rfv2.x, rfv2.y, rfv2.z) > 64.0) continue;
                rfy2.rha(drawContext, usn2, rfv2, rfv2.age / f2);
            }
        }
        finally {
            uut.additive(false);
            uut.popAlpha();
        }
    }

    private int rgy(String string) {
        return switch (string) {
            case "Winter" -> 1;
            case "Lava" -> 2;
            case "Cosmos" -> 0;
            case "Aurora" -> 3;
            case "Ocean" -> 4;
            case "Neon" -> 5;
            case "Sakura" -> 6;
            default -> 7;
        };
    }

    private int[] rgz(String string) {
        int[] nArray;
        switch (string) {
            case "Winter": {
                int[] nArray2 = new int[2];
                nArray2[0] = -4199937;
                nArray = nArray2;
                nArray2[1] = -1;
                break;
            }
            case "Lava": {
                int[] nArray3 = new int[2];
                nArray3[0] = -34278;
                nArray = nArray3;
                nArray3[1] = -11654;
                break;
            }
            case "Aurora": {
                int[] nArray4 = new int[2];
                nArray4[0] = -11665488;
                nArray = nArray4;
                nArray4[1] = -5796865;
                break;
            }
            case "Ocean": {
                int[] nArray5 = new int[2];
                nArray5[0] = -11544321;
                nArray = nArray5;
                nArray5[1] = -2556929;
                break;
            }
            case "Sakura": {
                int[] nArray6 = new int[2];
                nArray6[0] = -24890;
                nArray = nArray6;
                nArray6[1] = -7186;
                break;
            }
            case "Cosmos": {
                nArray = this.rgb.vivid(new int[]{-7709441, -13383425});
                break;
            }
            case "Neon": {
                nArray = this.rgb.vivid(new int[]{-49717, -12722945});
                break;
            }
            case "Lightning": {
                nArray = this.rgb.vivid(new int[]{-7359233, -1779457});
                break;
            }
            default: {
                int[] nArray7 = new int[2];
                nArray7[0] = this.rgb.color() | 0xFF000000;
                nArray = nArray7;
                nArray7[1] = this.rgb.color2() | 0xFF000000;
            }
        }
        return nArray;
    }

    private void rha(DrawContext drawContext, usn usn2, rfv rfv2, float f) {
        String string = this.rga.get();
        int[] nArray = this.rgz(string);
        float f2 = Math.min(1.0f, rfv2.age / 0.08f);
        float f3 = f < 0.5f ? 1.0f : 1.0f - vcq.inOutCubic((f - 0.5f) / 0.5f);
        float f4 = f2 * f3;
        float f5 = vcq.outCubic(Math.min(1.0f, f / 0.55f));
        float f6 = (float)this.rgc.get() * (0.3f + 0.7f * f5);
        if (string.equals("Lightning")) {
            this.rhd(drawContext, usn2, rfv2, f6, f4, f, nArray);
        } else {
            this.rhb(drawContext, usn2, rfv2, f6 / 0.8f, this.rgy(string), nArray, f4, f);
        }
        if (this.rgf.get()) {
            this.rhe(drawContext, usn2, rfv2, string, f6, f4, f, nArray);
        }
    }

    private void rhb(DrawContext drawContext, usn usn2, rfv rfv2, float f, int n, int[] nArray, float f2, float f3) {
        int n2;
        int n3;
        int n4;
        int n5 = ujt.withAlpha(nArray[0], Math.round(255.0f * f2));
        int n6 = 6;
        boolean bl = true;
        for (n4 = 0; n4 <= n6; ++n4) {
            for (n3 = 0; n3 <= n6; ++n3) {
                n2 = n4 * (n6 + 1) + n3;
                double d = rfv2.x - (double)f + 2.0 * (double)f * (double)n3 / (double)n6;
                double d2 = rfv2.z - (double)f + 2.0 * (double)f * (double)n4 / (double)n6;
                this.rgq[n2] = usn2.depth(d, rfv2.y, d2) > 0.08f && usn2.project3(d, rfv2.y, d2, this.rgp[n2]);
                bl &= this.rgq[n2];
            }
        }
        if (bl) {
            this.rhc(0, this.rgp[0], 0.0f, 0.0f);
            this.rhc(1, this.rgp[n6], 1.0f, 0.0f);
            this.rhc(2, this.rgp[n6 * (n6 + 1) + n6], 1.0f, 1.0f);
            this.rhc(3, this.rgp[n6 * (n6 + 1)], 0.0f, 1.0f);
            uut.pattern(drawContext, this.rgo, n, 2, n5, nArray[1], f3, this.rgn + rfv2.seed);
            return;
        }
        for (n4 = 0; n4 < n6; ++n4) {
            for (n3 = 0; n3 < n6; ++n3) {
                n2 = n4 * (n6 + 1) + n3;
                int n7 = n2 + 1;
                int n8 = n2 + n6 + 1;
                int n9 = n8 + 1;
                if (!this.rgq[n2] || !this.rgq[n7] || !this.rgq[n8] || !this.rgq[n9]) continue;
                float f4 = (float)n3 / (float)n6;
                float f5 = (float)(n3 + 1) / (float)n6;
                float f6 = (float)n4 / (float)n6;
                float f7 = (float)(n4 + 1) / (float)n6;
                this.rhc(0, this.rgp[n2], f4, f6);
                this.rhc(1, this.rgp[n7], f5, f6);
                this.rhc(2, this.rgp[n9], f5, f7);
                this.rhc(3, this.rgp[n8], f4, f7);
                uut.pattern(drawContext, this.rgo, n, 2, n5, nArray[1], f3, this.rgn + rfv2.seed);
            }
        }
    }

    private void rhc(int n, float[] fArray, float f, float f2) {
        int n2 = n * 5;
        this.rgo[n2] = fArray[0];
        this.rgo[n2 + 1] = fArray[1];
        this.rgo[n2 + 2] = f;
        this.rgo[n2 + 3] = f2;
        this.rgo[n2 + 4] = fArray[2];
    }

    private void rhd(DrawContext drawContext, usn usn2, rfv rfv2, float f, float f2, float f3, int[] nArray) {
        int n;
        float f4 = usn2.unitsPerBlock(rfv2.x, rfv2.y, rfv2.z);
        if (f4 <= 0.0f) {
            return;
        }
        float f5 = Math.min(1.0f, f3 / 0.25f);
        float f6 = 0.8f + 0.2f * (float)Math.sin(this.rgn * 38.0f + rfv2.seed);
        float f7 = Math.max(0.8f, Math.min(2.2f, f4 * 0.02f));
        float f8 = Math.min(7.0f, f4 * 0.07f);
        uut.additive(true);
        for (float[] fArray : rfv2.bolts) {
            int n2 = fArray.length / 2;
            n = Math.max(2, Math.round((float)n2 * f5));
            boolean bl = usn2.project(rfv2.x + (double)(fArray[0] * f), rfv2.y, rfv2.z + (double)(fArray[1] * f), this.rgr);
            for (int i = 1; i < n; ++i) {
                boolean bl2 = usn2.project(rfv2.x + (double)(fArray[i * 2] * f), rfv2.y, rfv2.z + (double)(fArray[i * 2 + 1] * f), this.rgs);
                if (bl && bl2) {
                    float f9 = f2 * f6 * (1.0f - 0.4f * (float)i / (float)n2);
                    uut.softLine(drawContext, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], f8 * 0.5f, f8, ujt.withAlpha(nArray[0], Math.round(110.0f * f9)));
                    uut.line(drawContext, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], f7, ujt.withAlpha(ujt.lerp(nArray[0], -1, 0.7f), Math.round(240.0f * f9)));
                }
                this.rgr[0] = this.rgs[0];
                this.rgr[1] = this.rgs[1];
                bl = bl2;
            }
        }
        int n3 = 40;
        int n4 = usn2.project(rfv2.x + (double)f, rfv2.y, rfv2.z, this.rgr) ? 1 : 0;
        for (int i = 1; i <= n3; ++i) {
            double d = (float)Math.PI * 2 * (float)i / (float)n3;
            n = usn2.project(rfv2.x + Math.cos(d) * (double)f, rfv2.y, rfv2.z + Math.sin(d) * (double)f, this.rgs) ? 1 : 0;
            if (n4 != 0 && n != 0) {
                uut.softLine(drawContext, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], f8 * 0.4f, f8 * 0.8f, ujt.withAlpha(nArray[0], Math.round(70.0f * f2)));
                uut.line(drawContext, this.rgr[0], this.rgr[1], this.rgs[0], this.rgs[1], f7 * 0.8f, ujt.withAlpha(ujt.lerp(nArray[0], -1, 0.5f), Math.round(200.0f * f2)));
            }
            this.rgr[0] = this.rgs[0];
            this.rgr[1] = this.rgs[1];
            n4 = n;
        }
        uut.additive(false);
    }

    private void rhe(DrawContext drawContext, usn usn2, rfv rfv2, String string, float f, float f2, float f3, int[] nArray) {
        GpuTextureView gpuTextureView = unm.view();
        float f4 = usn2.unitsPerBlock(rfv2.x, rfv2.y, rfv2.z);
        if (gpuTextureView == null || f4 <= 0.0f) {
            return;
        }
        uut.additive(true);
        float[] fArray = rfv2.parts;
        int n = fArray.length / 5;
        block14: for (int i = 0; i < n; ++i) {
            float f5 = fArray[i * 5];
            float f6 = fArray[i * 5 + 1] * f;
            float f7 = fArray[i * 5 + 2];
            float f8 = fArray[i * 5 + 3];
            float f9 = fArray[i * 5 + 4];
            double d = rfv2.x + Math.cos(f5) * (double)f6;
            double d2 = rfv2.z + Math.sin(f5) * (double)f6;
            double d3 = rfv2.y;
            float f10 = 1.0f;
            switch (string) {
                case "Lava": {
                    d3 += (double)rfv2.age * 0.9 * (double)f7;
                    d += Math.sin(rfv2.age * 3.0f + f8) * 0.05;
                    f10 = 1.0f - f3;
                    break;
                }
                case "Winter": {
                    d3 += 0.05 + (double)rfv2.age * 0.25 * (double)f7;
                    f10 = 0.5f + 0.5f * (float)Math.sin(this.rgn * 9.0f * f7 + f8);
                    break;
                }
                case "Sakura": {
                    d3 += (double)rfv2.age * 0.5 * (double)f7;
                    d += Math.sin(rfv2.age * 2.5f + f8) * 0.15;
                    d2 += Math.cos(rfv2.age * 2.1f + f8) * 0.15;
                    break;
                }
                case "Ocean": {
                    double d4 = 1.6 * (double)f7;
                    double d5 = d4 * (double)rfv2.age - 4.5 * (double)rfv2.age * (double)rfv2.age;
                    if (d5 < 0.0) continue block14;
                    d3 += d5;
                    double d6 = 0.5 * (double)rfv2.age * (double)f7;
                    d += Math.cos(f5) * d6;
                    d2 += Math.sin(f5) * d6;
                    break;
                }
                case "Cosmos": {
                    d3 += 0.1 + (double)(f8 / ((float)Math.PI * 2)) * 0.6;
                    f10 = Math.max(0.0f, (float)Math.sin(this.rgn * 4.0f * f7 + f8));
                    break;
                }
                default: {
                    double d7 = 0.7 * (double)rfv2.age * (double)f7;
                    d += Math.cos(f5) * d7;
                    d2 += Math.sin(f5) * d7;
                    d3 += 0.8 * (double)f7 * (double)rfv2.age - 2.0 * (double)rfv2.age * (double)rfv2.age;
                    f10 = 1.0f - f3;
                }
            }
            if (!usn2.project(d, d3, d2, this.rgr)) continue;
            float f11 = Math.min(14.0f, Math.max(2.0f, f4 * 0.09f * f9));
            float f12 = f2 * f10;
            if (f12 <= 0.02f) continue;
            int n2 = i % 3 == 0 ? nArray[1] : nArray[0];
            uut.sprite(drawContext, gpuTextureView, this.rgr[0], this.rgr[1], f11 * 3.0f, ujt.withAlpha(n2, Math.round(90.0f * f12)));
            uut.sprite(drawContext, gpuTextureView, this.rgr[0], this.rgr[1], f11, ujt.withAlpha(ujt.lerp(n2, -1, 0.6f), Math.round(230.0f * f12)));
        }
        uut.additive(false);
    }

    private static /* synthetic */ int byl(int n, int n2) {
        return n ^ n2 ^ 0x1563986E;
    }

    private static /* synthetic */ int bym(int n, int n2) {
        return rfy.byl(n, n2) + n;
    }

    private static /* synthetic */ int byn(int n, int n2) {
        return rfy.bym(n, n2) * n2;
    }
}

