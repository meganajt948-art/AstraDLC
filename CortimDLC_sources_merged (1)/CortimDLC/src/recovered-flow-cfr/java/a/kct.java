/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.Text
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.hyz;
import a.ida;
import a.jte;
import a.jza;
import a.jzh;
import a.kam;
import a.kap;
import a.kbp;
import a.kbs;
import a.kce;
import a.unf;
import a.unm;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdn;
import a.veo;
import a.wam;
import a.wap;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import org.joml.Matrix3x2fStack;

public final class kct
extends Screen {
    private static final float kcu = 116.0f;
    private static final float kcv = 92.0f;
    private static final float kcw = 14.0f;
    private static final wam[] kcx = new wam[]{wam.RU, wam.EN};
    private final Screen kcy;
    private final kap kcz = new kap();
    private final kam kda = new kam();
    private final kbs kdb = kbs.selected();
    private final vcj[] kdc = new vcj[]{new vcj(13.0f), new vcj(13.0f)};
    private int kdd;
    private float kde = -1.0f;
    private float kdf = -1.0f;
    private int kdg = -1;
    private boolean kdh;
    private long kdi;
    private float kdj;
    private float kdk = 1.0f;
    private float kdl = 480.0f;
    private float kdm = 270.0f;
    private static /* synthetic */ boolean kdn;
    private static /* synthetic */ long kdo;

    public kct(Screen screen) {
        super((Text)Text.literal((String)a.d("\uae06\ud785\u5d5f\uc321\u48fa\uce49\u7412", 1951642780, -2068833590)));
        this.kcy = screen;
        this.kdd = wap.chosen() && !wap.ru() ? 1 : 0;
        jzh.preload(this.kdb.key);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        uut.beginFrame();
        unf.observe(context);
        long l = System.nanoTime();
        this.kdj = this.kdi == 0L ? 0.016666668f : Math.min(0.1f, (float)(l - this.kdi) / 1.0E9f);
        this.kdi = l;
        float f = kap.clock();
        if (this.kde < 0.0f) {
            this.kde = f;
        }
        float f2 = f - this.kde;
        float f3 = this.kdf >= 0.0f ? vcq.clamp01((f - this.kdf) / 0.42f) : 0.0f;
        this.kdk = kbp.scale(this.width, this.height);
        this.kdl = (float)this.width / this.kdk;
        this.kdm = (float)this.height / this.kdk;
        float f4 = (float)mouseX / this.kdk;
        float f5 = (float)mouseY / this.kdk;
        GpuTextureView gpuTextureView = unm.view();
        uut.rect(context, 0.0f, 0.0f, this.width, this.height, -16315888);
        jza jza2 = jzh.get(this.kdb.key);
        if (jza2 != null) {
            this.kda.time = f;
            this.kda.blur = 1.0f;
            this.kda.dim = 0.22f;
            this.kda.zoom = 1.06f;
            this.kda.tint = this.kdb.tint;
            this.kda.tintAmount = 0.3f;
            this.kcz.draw(context, jza2, this.kda, this.width, this.height, 1.0f, true);
        }
        Matrix3x2fStack matrix3x2fStack = context.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.scale(this.kdk, this.kdk);
        vdn.setRenderScaleStepped(this.kdk);
        uut.pushAlpha(1.0f - vcq.inCubic(f3));
        try {
            float f6 = vcq.outCubic(vcq.clamp01((f2 - 0.05f) / 0.6f));
            uut.pushAlpha(f6);
            float f7 = this.kdm * 0.5f - 46.0f - 38.0f + (1.0f - f6) * 6.0f;
            vdn vdn2 = veo.semibold(12.0f);
            vdn2.drawCentered(context, a.c(662017462, "\u95e1\uec7b\u66af\uf8de\u7315\uf5b2\u4fa4\uc60c\u5845\ud2ee\u553a\uaf19\u2182\ub83e\u3262\ub49a\u0ec7\u8102\u1bb7\u9de4"), this.kdl * 0.5f, vdn2.centerTop(f7), kct.kdu(0xFFFFFF, 0.97f));
            vdn vdn3 = veo.medium(7.6f);
            vdn3.drawCentered(context, a.c(237958896, "\uf2ef\u8b07\u01ae\u9fdb\u1479\u92b0\u2899\ua11f\u3b55\ub58b\u3220\uc82d\u468b"), this.kdl * 0.5f, vdn3.centerTop(f7 + 15.0f), kct.kdu(14149365, 0.72f));
            uut.popAlpha();
            for (int i = 0; i < kcx.length; ++i) {
                this.kdr(context, gpuTextureView, i, f4, f5, f2, f3);
            }
            vdn vdn4 = veo.medium(6.2f);
            uut.pushAlpha(vcq.clamp01((f2 - 0.7f) / 0.6f));
            vdn4.drawCentered(context, a.c(738804110, "\u45cc\u3c60\ub6ba\u28c3\ua311\u25da\u9f87\u121a\u885a\u02ea\u8545\u7f48\uf19d\u6c2a\ue663\u6488\udec0\u5112\ucba0\u4df4\uc409\uba48\u309a\uaf2a\u2d46\ua79f\u1e29\u9077\u0af2\u8ca1\u076d\uf9be\u77ed\uea0e\u684f\ue699\u5931\ud33a\u5186\ucc26\u4670\u3889\ub2a9\u3176\uaba1\u2547\u9c03\u16b2\u909e\u0b64\u851e\u7fc0\uf67e\u702d\uea9b\u6483\udf21\u59a4\ud39b\u4a47\uc4e5\ubea5\u3941\ub358\u2d8d\ua468\u1e27\u98db\u12c9\u8d3f\u07e7\u8195\u7847\uf2f1\u6ce7\ue754\u6114\udba4\u5277\ucc1d\u46d3\uc0cc\ubb36\u35e0\uafd9\u265c\ua0f3\u1aaf\u9515\u0f07\u89bfc\ufa10\u74d4\uef33\u692f\ue3e8\u5d92\ud45a"), this.kdl * 0.5f, vdn4.centerTop(this.kdm * 0.5f + 46.0f + 24.0f), kct.kdu(0xFFFFFF, 0.45f));
            uut.popAlpha();
        }
        finally {
            uut.popAlpha();
            uut.additive(false);
            matrix3x2fStack.popMatrix();
            vdn.setRenderScale(1.0f);
        }
        if (f3 >= 1.0f && !this.kdh) {
            this.kdh = true;
            MinecraftClient minecraftClient = this.client;
            jte jte2 = minecraftClient.world == null ? jte.afterWelcome() : this.kcy;
            minecraftClient.send(() -> minecraftClient.setScreen(jte2));
        }
    }

    private float kdp(int n) {
        return this.kdl * 0.5f - 116.0f - 7.0f + (float)n * 130.0f;
    }

    private float kdq() {
        return this.kdm * 0.5f - 46.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void kdr(DrawContext drawContext, GpuTextureView gpuTextureView, int n, float f, float f2, float f3, float f4) {
        boolean bl;
        float f5 = vcq.clamp01((f3 - 0.2f - (float)n * 0.1f) / 0.6f);
        if (f5 <= 0.0f) {
            return;
        }
        float f6 = vcq.outBack(f5);
        float f7 = this.kdp(n);
        float f8 = this.kdq();
        boolean bl2 = bl = this.kdf < 0.0f && f5 >= 1.0f && kct.kdt(f, f2, f7, f8, 116.0f, 92.0f);
        if (bl) {
            this.kdd = n;
        }
        boolean bl3 = bl || this.kdd == n && !kct.kdt(f, f2, this.kdp(1 - n), f8, 116.0f, 92.0f) || this.kdg == n;
        float f9 = this.kdc[n].step(bl3, this.kdj);
        float f10 = this.kdg == n ? vcq.clamp01(f4 * 2.0f) : 0.0f;
        float f11 = f8 + (1.0f - f6) * 18.0f - 3.0f * f9;
        float f12 = (0.92f + 0.08f * f6) * (1.0f + 0.03f * f10) * (this.kdg >= 0 && this.kdg != n ? 1.0f - 0.05f * f4 : 1.0f);
        float f13 = 13.0f;
        int n2 = this.kdb.accent;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f7 + 58.0f, f11 + 46.0f);
        matrix3x2fStack.scale(f12, f12);
        matrix3x2fStack.translate(-58.0f, -46.0f);
        uut.pushAlpha(vcq.clamp01(f5 * 1.5f));
        try {
            uut.shadow(drawContext, 0.0f, 5.0f, 116.0f, 92.0f, f13, 22.0f, kct.kdu(0, 0.35f + 0.1f * f9));
            if (gpuTextureView != null && f9 > 0.01f) {
                uut.additive(true);
                uut.image(drawContext, gpuTextureView, -34.800003f, -27.6f, 185.6f, 147.2f, 0.0f, kct.kdu(n2, 0.16f * f9));
                uut.additive(false);
            }
            this.kcz.frosted(drawContext, 0.0f, 0.0f, 116.0f, 92.0f, f13, f7, f11, this.kdl, this.kdm, kct.kdu(0xFFFFFF, 1.0f));
            uut.round(drawContext, 0.0f, 0.0f, 116.0f, 92.0f, f13, kct.kdu(658966, 0.3f - 0.08f * f9));
            uut.round(drawContext, 0.0f, 0.0f, 116.0f, 92.0f, f13, kct.kdu(0xFFFFFF, 0.04f + 0.07f * f9));
            uut.gradient(drawContext, 0.0f, 0.0f, 116.0f, 41.399998f, f13, f13, 0.0f, 0.0f, kct.kdu(0xFFFFFF, 0.09f), kct.kdu(0xFFFFFF, 0.09f), kct.kdu(0xFFFFFF, 0.0f), kct.kdu(0xFFFFFF, 0.0f));
            uut.outlineGradientV(drawContext, 0.0f, 0.0f, 116.0f, 92.0f, f13, 0.8f, kct.kdu(kce.mix(0xFFFFFF, n2, f9), 0.34f + 0.45f * f9), kct.kdu(kce.mix(0xFFFFFF, n2, f9), 0.08f + 0.3f * f9));
            wam wam2 = kcx[n];
            boolean bl4 = wam2 == wam.RU;
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(43.0f, 16.0f);
            matrix3x2fStack.scale(1.5f, 1.5f);
            ida.flag(drawContext, wam2, 0.0f, 0.0f);
            matrix3x2fStack.popMatrix();
            vdn vdn2 = veo.semibold(10.5f);
            vdn2.drawCentered(drawContext, bl4 ? a.b("\u6833\u11e1\u9b30\u0541\u8eed\u085e\ub20c", 488401940) : a.b("\ueabc\u9326\u19fc\u8786\u0c54\u8aff\u30b7", -1369773314), 58.0f, vdn2.centerTop(62.0f), kct.kdu(0xFFFFFF, 0.97f));
            vdn vdn3 = veo.medium(6.6f);
            vdn3.drawCentered(drawContext, bl4 ? a.b("\u1269\u6bdf", -1375989191) : a.c(-568805827, "\ub67a\ucfc0"), 58.0f, vdn3.centerTop(75.0f), kct.kdu(kce.mix(13161698, n2, f9), 0.7f + 0.3f * f9));
        }
        finally {
            uut.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private void kds(int n) {
        if (this.kdf >= 0.0f) {
            return;
        }
        this.kdg = n;
        wap.set(kcx[n]);
        hyz.saveLater();
        this.kdf = kap.clock();
    }

    public boolean mouseClicked(Click click, boolean doubled) {
        if (click.button() != 0) {
            return true;
        }
        float f = (float)click.x() / this.kdk;
        float f2 = (float)click.y() / this.kdk;
        for (int i = 0; i < kcx.length; ++i) {
            if (!kct.kdt(f, f2, this.kdp(i), this.kdq(), 116.0f, 92.0f)) continue;
            this.kds(i);
        }
        return true;
    }

    public boolean keyPressed(KeyInput input) {
        switch (input.key()) {
            case 263: {
                this.kdd = 0;
                break;
            }
            case 258: 
            case 262: {
                this.kdd = this.kdd == 0 ? 1 : 0;
                break;
            }
            case 32: 
            case 257: 
            case 335: {
                this.kds(this.kdd);
                break;
            }
        }
        return true;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public boolean shouldPause() {
        return false;
    }

    public void removed() {
        this.kcz.close();
        vdn.setRenderScale(1.0f);
    }

    private static boolean kdt(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f2 >= f4 && f < f3 + f5 && f2 < f4 + f6;
    }

    private static int kdu(int n, float f) {
        return kce.rgba(n, f);
    }

    private static /* synthetic */ int asb(int n, int n2) {
        return (n ^ n2) + 1883086885;
    }
}

