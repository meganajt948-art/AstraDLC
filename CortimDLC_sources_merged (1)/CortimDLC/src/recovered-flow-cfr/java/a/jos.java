/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.yggdrasil.ProfileResult
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.util.DefaultSkinHelper
 *  net.minecraft.entity.player.SkinTextures
 *  net.minecraft.text.Text
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.jom;
import a.jop;
import a.jsi;
import a.jyi;
import a.jyw;
import a.jza;
import a.jzh;
import a.kam;
import a.kap;
import a.kbp;
import a.kbs;
import a.kcb;
import a.kce;
import a.unf;
import a.unm;
import a.uog;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdn;
import a.veo;
import a.vhz;
import a.vjf;
import a.wap;
import com.mojang.authlib.yggdrasil.ProfileResult;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.text.Text;
import org.joml.Matrix3x2fStack;

public final class jos
extends Screen {
    private static final float jot = 268.0f;
    private static final float jou = 218.0f;
    private static final float jov = 46.0f;
    private static final float jow = 28.0f;
    private static final float jox = 4.0f;
    private static final float joy = 50.0f;
    private static final Pattern joz = Pattern.compile(a.c(-1434253870, "\u059b\u7c30\uf68f\u6889\ue365\u6598\udf9c\u5627\uc865\u42c0\uc575\u3f06\ub1f7\u280e\ua242\u24ae\u9ee6\u117c"));
    private static final Map<UUID, SkinTextures> jpa = new HashMap<UUID, SkinTextures>();
    private static final Map<UUID, CompletableFuture<?>> jpb = new HashMap();
    private final Screen jpc;
    private final kap jpd = new kap();
    private final kam jpe = new kam();
    private final kbs jpf = kbs.selected();
    private final jsi jpg;
    private List<jyi> jph;
    private final Map<Object, jop> jpi;
    private final List<jop> jpj;
    private final vcj jpk;
    private final vcj jpl;
    private final vcj jpm;
    private final vcj jpn;
    private final vcj jpo;
    private final vcj jpp;
    private String jpq;
    private boolean jpr;
    private float jps;
    private float jpt;
    private float jpu;
    private String jpv;
    private int jpw;
    private float jpx;
    private Object jpy;
    private Object jpz;
    private float jqa;
    private float jqb;
    private float jqc;
    private float jqd;
    private float jqe;
    private boolean jqf;
    private float jqg;
    private float jqh;
    private long jqi;
    private float jqj;
    private float jqk;
    private float jql;
    private float jqm;
    private static final String[] jqn = new String[]{a.b("\u0fdc\u7649\ufc84\u62fa\ue93f", 432738186), a.d("\ua953\ud0d6\u5a18\uc475\u4fa5", 347678702, -1017934082), a.d("\ud9b6\ua03e\u2af6\ub488\u3f4c", 1361288621, 1436304466), a.b("\u9dde\ue456\u6e94\uf0f8\u7b26", 1989123467), a.c(-153179634, "\uaa5b\ud3d1\u590b\uc77f\u4ca3\uca0a"), a.d("\u8b1f\uf285\u785c", -1481703037, -2129229103), a.b("\uc1be\ub83e\u32e6\uac9d\u274d\ua1e9\u1bb7", -433274374), a.b("\u7e5e\u07c7\u8d1b\u136d\u98ad", -1189970402), a.c(-1662357419, "\u7000\u098b\u835d\u1d25\u96f9\u1052"), a.c(702897712, "\u5e7b\u27ed\uad30\u334e\ub885"), a.b("\u54a7\u2d31\ua7f9\u3995\ub25d", -1633004303), a.c(-529637742, "\u5ec2\u2740\uad9a\u33f1\ub835\u3e95"), a.c(1505472620, "\ub02a\uc9b7\u4378\udd17\u56c2"), a.d("\uadc9\ud45e\u5e86\uc0f0", 877046946, 336855338), a.b("\u5419\u2d89\ua743\u3925", -438807469), a.b("\ud3b5\uaa2a\u20f4\ube9e\u3556", 643945458)};
    private static final String[] jqo = new String[]{a.d("\u09c2\u705a\ufa9e", 193236430, -936082359), a.b("\u8552\ufcdb\u760b\ue870", -710966015), a.c(566737386, "\ub9a8\uc033\u4ae3\ud48a"), a.c(1180307742, "\u1152\u68ca\ue20f\u7c62"), a.d("\ub045\uc9cf\u4311\udd71", 1190090854, -1772165019), a.b("\uffc1\u864b\u0c95\u92e5\u1925", 678690710), a.c(488504720, "\ufdd1\u8456\u0e9e\u90e0\u1b25"), a.c(-1406449188, "\u4994\u3010\ubad4\u24b3"), a.d("\u6e20\u17be\u9d6a\u0307\u88d7", -1214066111, 1803336739), a.d("\ubd19\uc49e\u4e5a\ud038", 624567667, 2075564089), a.d("\u85fc\ufc7e\u76b5", -229404908, 62327481), a.b("\u94cf\ued4d\u6789\uf9eb\u7237", -1248226152), a.d("\u56b3\u2f2e\ua5ff\u3b86\ub040", -1352831396, -2090190679), a.b("\ud37b\uaae8\u2020\ube4d", -1762667726)};
    private static /* synthetic */ String jqp;
    private static /* synthetic */ String jqq;

    public jos(Screen screen) {
        super((Text)Text.literal((String)a.b("\u3d30\u44ac\uce67\u5042\udbd8\u5d65\ue739\u6ec7\uf09e\u7a2d\ufde9", -1369686662)));
        this.jpg = new jsi(this.jpf.particles, 11L);
        this.jph = new ArrayList<jyi>();
        this.jpi = new IdentityHashMap<Object, jop>();
        this.jpj = new ArrayList<jop>();
        this.jpk = new vcj(14.0f);
        this.jpl = new vcj(14.0f);
        this.jpm = new vcj(14.0f);
        this.jpn = new vcj(14.0f);
        this.jpo = new vcj(12.0f);
        this.jpp = new vcj(9.0f);
        this.jpq = "";
        this.jpr = true;
        this.jps = -10.0f;
        this.jpt = -10.0f;
        this.jpu = -10.0f;
        this.jpv = "";
        this.jpw = 0xFFFFFF;
        this.jpx = -10.0f;
        this.jqd = -1.0f;
        this.jqe = -1.0f;
        this.jqk = 1.0f;
        this.jql = 480.0f;
        this.jqm = 270.0f;
        this.jpc = screen;
        jzh.preload(this.jpf.key);
        this.jqr(kap.clock(), true);
        if (jyw.disabled()) {
            this.jrf(wap.s(a.b("\u6877\u11ce\u9b0f\u050d\u8e93\u0838\ub238\u3b9a\ua5c1\u2f6e\ua8a0\u52c6\udc1a\u45a6\ucff4\u4941\uf341\u7c99\ue62a\u603d\ue9c2\u93d2\u1d7c\u86aa\u0086\u8a04\u33a1\ubde1\u2716\ua15a\u2aee\ud436\u5e6d\uc7c6", -798595044), a.c(-1709767792, "\u03c6\u7a7f\uf0be\u6ebc\ue179\u67b1\udd93\u5463\uca49\u40f1\uc750\u3d29\ub7e3\u2e5a\ua013\u22f0\u9caa\u137d\u89c3\u0b8c\u8666\ufc3a\u72f8\ue92a\u6f57\ue5f8\u5c4c\ud21e\u48e3\ucec7\u4118")), 0xFF8A8A);
        }
    }

    private void jqr(float f, boolean bl) {
        this.jph = jyw.accounts();
        IdentityHashMap<Object, jop> identityHashMap = new IdentityHashMap<Object, jop>(this.jpi);
        this.jpi.clear();
        int n = 0;
        for (jyi object : this.jph) {
            jop jop2 = (jop)identityHashMap.remove(object.handle());
            if (jop2 == null) {
                jop2 = new jop(object, bl ? f + 0.18f + (float)Math.min(n, 8) * 0.045f : f);
            }
            this.jpi.put(object.handle(), jop2);
            ++n;
        }
        for (jop jop3 : identityHashMap.values()) {
            jop3.goneAt = f;
            this.jpj.add(jop3);
        }
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
        this.jqj = this.jqi == 0L ? 0.016666668f : Math.min(0.1f, (float)(l - this.jqi) / 1.0E9f);
        this.jqi = l;
        float f = kap.clock();
        if (this.jqd < 0.0f) {
            this.jqd = f;
        }
        float f2 = f - this.jqd;
        float f3 = this.jqe >= 0.0f ? vcq.clamp01((f - this.jqe) / 0.22f) : 0.0f;
        this.jqk = kbp.scale(this.width, this.height);
        this.jql = (float)this.width / this.jqk;
        this.jqm = (float)this.height / this.jqk;
        float f4 = (float)mouseX / this.jqk;
        float f5 = (float)mouseY / this.jqk;
        float f6 = 1.0f - (float)Math.exp(-this.jqj * 2.2f);
        if (mouseX >= 0 && mouseY >= 0 && mouseX <= this.width && mouseY <= this.height) {
            this.jqg += ((float)mouseX / (float)this.width - 0.5f - this.jqg) * f6;
            this.jqh += ((float)mouseY / (float)this.height - 0.5f - this.jqh) * f6;
        }
        GpuTextureView gpuTextureView = unm.view();
        uut.rect(context, 0.0f, 0.0f, this.width, this.height, -16118250);
        jza jza2 = jzh.get(this.jpf.key);
        if (jza2 != null) {
            float f7 = vcq.outCubic(vcq.clamp01(f2 / 0.5f)) * (1.0f - vcq.inOutCubic(f3));
            this.jpe.time = f;
            this.jpe.zoom = 1.05f + 0.01f * f7;
            this.jpe.panX = -this.jqg * 0.014f;
            this.jpe.panY = -this.jqh * 0.01f;
            this.jpe.blur = 0.55f * f7;
            this.jpe.dim = 0.04f + 0.12f * f7;
            this.jpe.tint = this.jpf.tint;
            this.jpe.tintAmount = 0.3f;
            this.jpe.fall = null;
            this.jpe.pool = null;
            this.jpd.draw(context, jza2, this.jpe, this.width, this.height, 1.0f, true);
        }
        Matrix3x2fStack matrix3x2fStack = context.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.scale(this.jqk, this.jqk);
        vdn.setRenderScaleStepped(this.jqk);
        try {
            this.jpg.draw(context, gpuTextureView, this.jql, this.jqm, f, false, this.jqg, this.jqh, 1.0f);
            float f8 = vcq.clamp01(f2 / 0.42f);
            float f9 = vcq.outBack(f8) * (1.0f - f3) + 0.0f;
            float f10 = vcq.clamp01(f8 * 1.6f) * (1.0f - vcq.inCubic(f3));
            float f11 = this.jqs();
            float f12 = this.jqt();
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(f11 + 134.0f, f12 + 109.0f);
            float f13 = 0.94f + 0.06f * Math.min(1.0f, f9) - 0.03f * f3;
            matrix3x2fStack.scale(f13, f13);
            matrix3x2fStack.translate(-134.0f, -109.0f + (1.0f - Math.min(1.0f, f9)) * 10.0f);
            uut.pushAlpha(f10);
            try {
                this.jqu(context, gpuTextureView, f4 - f11, f5 - f12, f, f11, f12);
            }
            finally {
                uut.popAlpha();
                matrix3x2fStack.popMatrix();
            }
        }
        finally {
            uut.additive(false);
            matrix3x2fStack.popMatrix();
            vdn.setRenderScale(1.0f);
        }
        if (f3 >= 1.0f && !this.jqf) {
            this.jqf = true;
            this.client.send(() -> this.client.setScreen(this.jpc));
        }
    }

    private float jqs() {
        return (this.jql - 268.0f) * 0.5f;
    }

    private float jqt() {
        return (this.jqm - 218.0f) * 0.5f + 4.0f;
    }

    private void jqu(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5) {
        float f6 = 14.0f;
        int n = this.jpf.accent;
        uut.shadow(drawContext, 0.0f, 6.0f, 268.0f, 218.0f, f6, 28.0f, jos.jrm(0, 0.45f));
        this.jpd.frosted(drawContext, 0.0f, 0.0f, 268.0f, 218.0f, f6, f4, f5, this.jql, this.jqm, jos.jrm(0xFFFFFF, 1.0f));
        uut.round(drawContext, 0.0f, 0.0f, 268.0f, 218.0f, f6, jos.jrm(658966, 0.52f));
        uut.gradient(drawContext, 0.0f, 0.0f, 268.0f, 60.0f, f6, f6, 0.0f, 0.0f, jos.jrm(0xFFFFFF, 0.06f), jos.jrm(0xFFFFFF, 0.06f), jos.jrm(0xFFFFFF, 0.0f), jos.jrm(0xFFFFFF, 0.0f));
        uut.outlineGradientV(drawContext, 0.0f, 0.0f, 268.0f, 218.0f, f6, 0.7f, jos.jrm(0xFFFFFF, 0.28f), jos.jrm(0xFFFFFF, 0.06f));
        this.jqv(drawContext, f, f2, n);
        this.jqz(drawContext, f, f2, f3, n);
        this.jrc(drawContext, gpuTextureView, f, f2, f3, n);
    }

    private void jqv(DrawContext drawContext, float f, float f2, int n) {
        uut.round(drawContext, 14.0f, 13.0f, 22.0f, 22.0f, 7.0f, jos.jrm(n, 0.16f));
        uut.outline(drawContext, 14.0f, 13.0f, 22.0f, 22.0f, 7.0f, 0.6f, jos.jrm(n, 0.45f));
        vjf.draw(drawContext, vhz.ACCOUNTS, 25.0f, 24.0f, 12.0f, jos.jrm(kce.mix(n, 0xFFFFFF, 0.3f), 1.0f));
        vdn vdn2 = veo.semibold(10.4f);
        vdn2.draw(drawContext, wap.s(a.d("\u0775\u7ee9\uf422\u6a07\ue19d\u6720\udd7c\u5482\ucadb\u4068\uc7ac", -13408373, 1128620212), a.d("\u30dc\u4946\uc3e2\u5d9d\ud228\u5085\ueadf\u6326\ufd71\u77c1\uf010\u0a62\u84c0", -1804484324, -151063075)), 44.0f, vdn2.centerTop(19.0f), jos.jrm(0xFFFFFF, 0.97f));
        vdn vdn3 = veo.medium(6.4f);
        String string = this.client.getSession().getUsername();
        String string2 = wap.s(a.c(896021282, "\u3379\u4af4\uc02a\u5e43\ud584\u5332\ue968\u60de\ufec0\u7463\uf3e3"), a.c(-194294653, "\u48aa\u310f\ubbd0\u25df\uae7f\u28bf\u9697\u1f7c"));
        float f3 = vdn3.width(string2);
        vdn3.draw(drawContext, string2, 44.0f, vdn3.centerTop(31.5f), jos.jrm(0xFFFFFF, 0.5f));
        uut.circle(drawContext, 44.0f + f3 + 3.0f, 31.5f, 2.0f, jos.jrm(7268256, 0.95f));
        vdn3.draw(drawContext, string, 44.0f + f3 + 8.0f, vdn3.centerTop(31.5f), jos.jrm(0xFFFFFF, 0.88f));
        float f4 = 246.0f;
        float f5 = 22.0f;
        float f6 = this.jpk.step(jos.jrl(f, f2, f4, f5) < 9.0f, this.jqj);
        uut.circle(drawContext, f4, f5, 8.5f, jos.jrm(0xFFFFFF, 0.05f + 0.1f * f6));
        vjf.draw(drawContext, vhz.CLOSE, f4, f5, 8.0f + f6, jos.jrm(0xFFFFFF, 0.6f + 0.4f * f6));
        vdn vdn4 = veo.medium(6.4f);
        String string3 = a.d("\u4b3e\u32ab\ub872\u2612\uadd8\u2b75\u913a\u18c2\u868f", 336940446, -1186396444);
        float f7 = vdn4.width(string3) + 22.0f;
        float f8 = f4 - 14.0f - f7;
        float f9 = f5 - 8.0f;
        float f10 = this.jpl.step(jos.jrk(f, f2, f8, f9, f7, 16.0f), this.jqj);
        uut.round(drawContext, f8, f9, f7, 16.0f, 8.0f, jos.jrm(0xFFFFFF, 0.05f + 0.08f * f10));
        uut.outline(drawContext, f8, f9, f7, 16.0f, 8.0f, 0.6f, jos.jrm(kce.mix(0xFFFFFF, n, f10), 0.16f + 0.4f * f10));
        jos.jqw(drawContext, f8 + 9.0f, f9 + 8.0f, 6.0f, f10);
        vdn4.draw(drawContext, string3, f8 + 15.0f, vdn4.centerTop(f9 + 8.0f), jos.jrm(0xFFFFFF, 0.75f + 0.25f * f10));
        uut.rect(drawContext, 12.0f, 45.5f, 244.0f, 0.6f, jos.jrm(0xFFFFFF, 0.08f));
    }

    private static void jqw(DrawContext drawContext, float f, float f2, float f3, float f4) {
        float f5 = f3 * 0.1f;
        float f6 = (f3 - f5) * 0.5f;
        float f7 = f - f3 * 0.5f;
        float f8 = f2 - f3 * 0.5f;
        float f9 = 0.75f + 0.25f * f4;
        uut.rect(drawContext, f7, f8, f6, f6, jos.jrm(15880226, f9));
        uut.rect(drawContext, f7 + f6 + f5, f8, f6, f6, jos.jrm(8370688, f9));
        uut.rect(drawContext, f7, f8 + f6 + f5, f6, f6, jos.jrm(42223, f9));
        uut.rect(drawContext, f7 + f6 + f5, f8 + f6 + f5, f6, f6, jos.jrm(16759040, f9));
    }

    private float jqx() {
        return 52.0f;
    }

    private float jqy() {
        return 116.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jqz(DrawContext drawContext, float f, float f2, float f3, int n) {
        float f4 = this.jqx();
        float f5 = this.jqy();
        float f6 = Math.max(0.0f, (float)this.jph.size() * 32.0f - 4.0f - f5);
        this.jqc = Math.max(0.0f, Math.min(f6, this.jqc));
        this.jqb += (this.jqc - this.jqb) * (1.0f - (float)Math.exp(-this.jqj * 14.0f));
        boolean bl = jos.jrk(f, f2, 10.0f, f4, 248.0f, f5);
        uut.pushScissor(drawContext, 6.0f, f4, 256.0f, f5);
        try {
            if (this.jph.isEmpty() && this.jpj.isEmpty()) {
                this.jra(drawContext, f4, f5, n);
            }
            for (int i = this.jpj.size() - 1; i >= 0; --i) {
                jop jop2 = this.jpj.get(i);
                if (!(f3 - jop2.goneAt > 0.3f)) continue;
                this.jpj.remove(i);
            }
            float f7 = f4 - this.jqb;
            for (jyi jyi2 : this.jph) {
                jop jop3 = this.jpi.get(jyi2.handle());
                if (jop3 == null) continue;
                if (f7 + 28.0f > f4 - 2.0f && f7 < f4 + f5 + 2.0f) {
                    this.jrb(drawContext, jop3, 10.0f, f7, f, f2, bl, f3, n);
                }
                f7 += 32.0f;
            }
        }
        finally {
            uut.popScissor(drawContext);
        }
        if (this.jqb > 0.5f) {
            uut.gradientV(drawContext, 8.0f, f4, 252.0f, 8.0f, 0.0f, jos.jrm(658966, 0.35f), jos.jrm(658966, 0.0f));
        }
        if (this.jqb < f6 - 0.5f) {
            uut.gradientV(drawContext, 8.0f, f4 + f5 - 8.0f, 252.0f, 8.0f, 0.0f, jos.jrm(658966, 0.0f), jos.jrm(658966, 0.35f));
        }
    }

    private void jra(DrawContext drawContext, float f, float f2, int n) {
        float f3 = f + f2 * 0.5f;
        vjf.draw(drawContext, vhz.USER_PLUS, 134.0f, f3 - 12.0f, 18.0f, jos.jrm(n, 0.8f));
        vdn vdn2 = veo.semibold(8.0f);
        vdn2.drawCentered(drawContext, wap.s(a.b("\u161c\u6f8c\ue510\u7b20\uf0f5\u7644\ucc1b\u45f0\udbb4\u511f\ud6cb\u2ce9\ua267\u3bca\ub188", -529787299), a.b("\u92c2\ueb59\u618a\ufff1\u7455\uf29a\u48b6\uc13b\u5f68\ud1cb\u5207\ua877\u26a4\ubf1f\u315c\ub3b0\u09f7\u8651", 1760532160)), 134.0f, vdn2.centerTop(f3 + 6.0f), jos.jrm(0xFFFFFF, 0.9f));
        vdn vdn3 = veo.medium(6.2f);
        vdn3.drawCentered(drawContext, wap.s(a.b("\u315a\u48c6\uc21c\u5c78\ud7ea\u511a\ueb08\u62b7\ufce7\u765a\uf181\u0bb5\u8520\u1c96\u96cc\u103e\uaa69\u25ef\ubf1d\u3943\ub0be\ucaab\u4448\udf9b\u59f3\ud334\u6a87\ue485\u7e17\uf86d\u73c4\u8d04\u075c", -236637905), a.d("\u0c1e\u7582\uff56\u6157\ueaf0\u6c3b\ud61f\u5bfb\uc1b9\u4b0d\uccdc\u32b7\ub87d\u21c9\uab94\u2d66\u933c\u18f5\u865e\u0412\u8de8\uf7bf\u7906\ue2d3\u64d6\uee70\u53d6\udde2\u473e\uc175\u4ad7\ub411", -476670125, -1616273537)), 134.0f, vdn3.centerTop(f3 + 17.0f), jos.jrm(0xFFFFFF, 0.5f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jrb(DrawContext drawContext, jop jop2, float f, float f2, float f3, float f4, boolean bl, float f5, int n) {
        float f6 = 248.0f;
        float f7 = vcq.outCubic(vcq.clamp01((f5 - jop2.bornAt) / 0.4f));
        if (f7 <= 0.0f) {
            return;
        }
        jyi jyi2 = jop2.alt;
        boolean bl2 = jyi2.name().equals(this.client.getSession().getUsername());
        boolean bl3 = this.jpy == jyi2.handle();
        boolean bl4 = bl && this.jqe < 0.0f && jos.jrk(f3, f4, f, f2, f6, 28.0f);
        float f8 = jop2.hover.step(bl4 || bl3, this.jqj);
        float f9 = f + f6 - 26.0f;
        float f10 = f9 - 52.0f;
        boolean bl5 = bl4 && jos.jrk(f3, f4, f9, f2 + 5.0f, 20.0f, 18.0f);
        boolean bl6 = bl4 && !bl5 && jos.jrk(f3, f4, f10, f2 + 5.0f, 48.0f, 18.0f);
        float f11 = jop2.binHover.step(bl5, this.jqj);
        float f12 = jop2.loginHover.step(bl6, this.jqj);
        boolean bl7 = this.jpz == jyi2.handle() && f5 - this.jqa < 2.5f;
        float f13 = vcq.clamp01((f5 - jop2.pressAt) / 0.45f);
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate((1.0f - f7) * 14.0f, 0.0f);
        uut.pushAlpha(f7);
        try {
            float f14;
            Object object;
            int n2 = bl2 ? kce.mix(658966, n, 0.12f) : 658966;
            uut.round(drawContext, f, f2, f6, 28.0f, 9.0f, jos.jrm(n2, 0.32f + 0.14f * f8));
            uut.round(drawContext, f, f2, f6, 28.0f, 9.0f, jos.jrm(0xFFFFFF, 0.03f + 0.04f * f8));
            if (f13 < 1.0f) {
                float f15 = f6 * vcq.outCubic(f13);
                float f16 = Math.max(f, f + jop2.px - f15);
                float f17 = Math.min(f + f6, f + jop2.px + f15);
                uut.round(drawContext, f16, f2, f17 - f16, 28.0f, 9.0f, jos.jrm(n, 0.18f * (1.0f - f13)));
            }
            uut.outline(drawContext, f, f2, f6, 28.0f, 9.0f, 0.6f, jos.jrm(bl2 ? n : 0xFFFFFF, bl2 ? 0.45f + 0.2f * f8 : 0.06f + 0.14f * f8));
            uog.draw(drawContext, jos.jre(jyi2), f + 6.0f, f2 + 5.0f, 18.0f, 4.5f, jos.jrm(0xFFFFFF, 1.0f));
            vdn vdn2 = veo.semibold(7.8f);
            vdn2.draw(drawContext, jyi2.name(), f + 31.0f, vdn2.centerTop(f2 + 10.5f), jos.jrm(0xFFFFFF, 0.96f));
            vdn vdn3 = veo.medium(5.8f);
            String string = jyi2.microsoft() ? wap.s(a.b("\u9a9e\ue30a\u69d3\uf7a4\u7c78\ufad4\u4091\uc961\u577a\udd5c\u5a18\ua004\u2ef7\ub74c\u3d0e\ubbe2\u01b1\u8e7c\u14c6\u9285", 1303288518), a.d("\u79cd_\u8af2\u14f0\u9f2f\u1994\ua3c8\u2a4e\ub07e\u3a58\ubd1c\u4700\uc9f3\u5048\uda0a\u5ce6\ue6b5\u6978\uf3c2\u7581", -1198349042, 559864012)) : wap.s(a.c(306389843, "\u231b\u5a83\ud050\u4e2b\uc5f9\u434f\uf917"), a.c(2011335486, "\u8f26\uf6b0\u7c1b\ue21a\u69bf\uef76\u552f"));
            float f18 = vdn3.width(string);
            vdn3.draw(drawContext, string, f + 31.0f, vdn3.centerTop(f2 + 19.5f), jos.jrm(jyi2.microsoft() ? kce.mix(0xFFFFFF, n, 0.5f) : 0xFFFFFF, jyi2.microsoft() ? 0.75f : 0.45f));
            if (bl2) {
                vdn vdn4 = veo.semibold(5.4f);
                object = wap.s(a.b("\ua60a\udfbc\u5501\ucb17\u40c6\uc67b\u7c20", 327001668), a.b("\u44d3\u3950\ub7bb\u29c1\ua225\u24a1", -522829625));
                float f19 = vdn4.width((String)object) + 8.0f;
                float f20 = f + 31.0f + Math.max(vdn2.width(jyi2.name()) + 6.0f, 0.0f);
                uut.round(drawContext, f20, f2 + 6.5f, f19, 8.0f, 4.0f, jos.jrm(n, 0.22f));
                vdn4.draw(drawContext, (String)object, f20 + 4.0f, vdn4.centerTop(f2 + 10.5f), jos.jrm(kce.mix(n, 0xFFFFFF, 0.4f), 1.0f));
            }
            float f21 = f14 = bl3 || bl7 ? 1.0f : f8;
            if (f14 > 0.01f) {
                uut.pushAlpha(f14);
                if (bl3) {
                    kcb.draw(drawContext, null, f10 + 24.0f, f2 + 14.0f, 5.0f, 1.4f, f5, 0.0f, n);
                } else {
                    uut.round(drawContext, f10, f2 + 5.0f, 48.0f, 18.0f, 9.0f, jos.jrm(n, 0.22f + 0.3f * f12));
                    uut.outline(drawContext, f10, f2 + 5.0f, 48.0f, 18.0f, 9.0f, 0.6f, jos.jrm(n, 0.5f + 0.4f * f12));
                    vjf.draw(drawContext, vhz.LOGIN, f10 + 11.0f, f2 + 14.0f, 7.5f, jos.jrm(0xFFFFFF, 0.9f));
                    object = veo.semibold(6.4f);
                    ((vdn)object).draw(drawContext, wap.s(a.c(-59138225, "\u9f1b\ue690\u6c4d\uf235\u79ac\uff54\u4500"), a.d("\u60c5\u1958\u938c\u0d86\u862b", -1788170782, -1794586320)), f10 + 18.0f, ((vdn)object).centerTop(f2 + 14.0f), jos.jrm(0xFFFFFF, 0.95f));
                }
                int n3 = 0xFF6B6B;
                uut.round(drawContext, f9, f2 + 5.0f, 20.0f, 18.0f, 9.0f, jos.jrm(n3, (bl7 ? 0.35f : 0.06f) + 0.2f * f11));
                vjf.draw(drawContext, bl7 ? vhz.CHECK : vhz.TRASH, f9 + 10.0f, f2 + 14.0f, 8.0f, jos.jrm(kce.mix(0xFFFFFF, n3, Math.max(f11, bl7 ? 1.0f : 0.0f)), 0.7f + 0.3f * f11));
                uut.popAlpha();
            }
            if (bl7) {
                object = veo.medium(5.6f);
                ((vdn)object).drawRight(drawContext, wap.s(a.c(1388565725, "\ud488\uad0e\u27d5\ub9a6\u3268\ub4ca\u0ec3"), a.b("\ua1fd\ud85b\u528c\uccf6\u4722\uc1e9\u7bb4\uf636", -1770871338)), f10 - 4.0f, ((vdn)object).centerTop(f2 + 14.0f), jos.jrm(0xFF8A8A, 0.95f));
            }
        }
        finally {
            uut.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private void jrc(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, int n) {
        float f4;
        float f5;
        float f6 = 184.0f;
        float f7 = 12.0f;
        float f8 = 22.0f;
        float f9 = 244.0f - 2.0f * (f8 + 6.0f);
        float f10 = this.jpp.step(f3 - this.jpx < 4.5f && !this.jpv.isEmpty(), this.jqj);
        if (f10 > 0.01f) {
            vdn vdn2 = veo.medium(6.2f);
            uut.pushAlpha(f10);
            f5 = f6 - 9.0f + (1.0f - f10) * 3.0f;
            uut.circle(drawContext, f7 + 3.0f, f5, 1.8f, jos.jrm(this.jpw, 0.95f));
            vdn2.draw(drawContext, vdn2.ellipsize(this.jpv, 228.0f), f7 + 9.0f, vdn2.centerTop(f5), jos.jrm(kce.mix(0xFFFFFF, this.jpw, 0.35f), 0.92f));
            uut.popAlpha();
        }
        float f11 = f3 - this.jps < 0.4f ? (float)Math.sin((f3 - this.jps) * 50.0f) * 3.0f * (1.0f - (f3 - this.jps) / 0.4f) : 0.0f;
        f5 = this.jpo.step(this.jpr, this.jqj);
        float f12 = f6;
        boolean bl = joz.matcher(this.jpq).matches();
        uut.round(drawContext, f7 + f11, f12, f9, f8, f8 * 0.5f, jos.jrm(329741, 0.4f + 0.12f * f5));
        uut.outline(drawContext, f7 + f11, f12, f9, f8, f8 * 0.5f, 0.7f, jos.jrm(kce.mix(0xFFFFFF, n, f5), 0.12f + 0.4f * f5));
        vjf.draw(drawContext, vhz.PLAYER, f7 + f11 + 12.0f, f12 + f8 * 0.5f, 8.5f, jos.jrm(0xFFFFFF, 0.45f + 0.3f * f5));
        vdn vdn3 = veo.medium(7.2f);
        float f13 = f7 + f11 + 22.0f;
        if (this.jpq.isEmpty()) {
            vdn3.draw(drawContext, wap.s(a.d("\ubbe0\uc27a\u48bb\ud69d\u5d05\udbbd\u61ee\ue815\u764f\ufcf9\u7b21\u8115\u0f8c\u9632\u1c6d\u9a94", -1371542404, 1293768642), a.d("\u184e\u61da\ueb0b\u7160\ufea3\u781d\uc23a\u4fa4\ud5e6\u5f54\ud88b\u22f6\uac2c\u3590\ubbdd\u393c\u8379\u0ca8\u9611\u1033\u99ba\ue394\u6d55", 1758637937, 177713973)), f13, vdn3.centerTop(f12 + f8 * 0.5f), jos.jrm(0xFFFFFF, 0.32f));
        } else {
            vdn3.draw(drawContext, this.jpq, f13, vdn3.centerTop(f12 + f8 * 0.5f), jos.jrm(0xFFFFFF, bl ? 0.95f : 0.8f));
        }
        if (this.jpr && (int)(f3 * 2.0f) % 2 == 0) {
            f4 = f13 + (this.jpq.isEmpty() ? 0.0f : vdn3.width(this.jpq) + 0.8f);
            uut.rect(drawContext, f4, f12 + 6.0f, 0.8f, f8 - 12.0f, jos.jrm(n, 0.95f));
        }
        if (!this.jpq.isEmpty()) {
            vdn vdn4 = veo.medium(5.6f);
            vdn4.drawRight(drawContext, this.jpq.length() + a.c(1695022765, "\ufe81\u872e\u0dfa"), f7 + f11 + f9 - 10.0f, vdn4.centerTop(f12 + f8 * 0.5f), jos.jrm(bl ? 0xFFFFFF : 0xFF8A8A, bl ? 0.35f : 0.8f));
        }
        f4 = f7 + f9 + 6.0f;
        this.jrd(drawContext, f4, f12, f8, vhz.DICE, this.jpn.step(jos.jrk(f, f2, f4, f12, f8, f8), this.jqj), this.jpu, f3, 0xFFFFFF, n, false);
        float f14 = f4 + f8 + 6.0f;
        this.jrd(drawContext, f14, f12, f8, vhz.PLUS, this.jpm.step(jos.jrk(f, f2, f14, f12, f8, f8), this.jqj), this.jpt, f3, n, n, bl);
    }

    private void jrd(DrawContext drawContext, float f, float f2, float f3, vhz vhz2, float f4, float f5, float f6, int n, int n2, boolean bl) {
        float f7 = vcq.clamp01((f6 - f5) / 0.4f);
        float f8 = f7 < 1.0f ? (float)Math.sin(Math.PI * (double)vcq.clamp01(f7 * 2.4f)) : 0.0f;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f + f3 * 0.5f, f2 + f3 * 0.5f);
        float f9 = 1.0f + 0.06f * f4 - 0.1f * f8;
        matrix3x2fStack.scale(f9, f9);
        float f10 = f3 * 0.5f;
        uut.round(drawContext, -f10, -f10, f3, f3, f10, jos.jrm(bl ? n2 : 0xFFFFFF, (bl ? 0.3f : 0.06f) + 0.14f * f4));
        uut.outline(drawContext, -f10, -f10, f3, f3, f10, 0.7f, jos.jrm(kce.mix(0xFFFFFF, n2, f4), 0.14f + 0.4f * f4));
        if (f7 < 1.0f) {
            uut.outline(drawContext, -f10 - 6.0f * f7, -f10 - 6.0f * f7, f3 + 12.0f * f7, f3 + 12.0f * f7, f10 + 6.0f * f7, 0.8f, jos.jrm(n2, 0.6f * (1.0f - f7)));
        }
        vjf.draw(drawContext, vhz2, 0.0f, 0.0f, 10.0f, jos.jrm(kce.mix(n, 0xFFFFFF, 0.3f + 0.7f * f4), 0.85f + 0.15f * f4));
        matrix3x2fStack.popMatrix();
    }

    private static SkinTextures jre(jyi jyi2) {
        UUID uUID = jyi2.skin() != null ? jyi2.skin() : jyi2.uuid();
        SkinTextures skinTextures = jpa.get(uUID);
        if (skinTextures != null) {
            return skinTextures;
        }
        SkinTextures skinTextures2 = DefaultSkinHelper.getSkinTextures((UUID)uUID);
        if (jyi2.microsoft() && !jpb.containsKey(uUID)) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            jpb.put(uUID, (CompletableFuture<?>)((CompletableFuture)((CompletableFuture)CompletableFuture.supplyAsync(() -> {
                ProfileResult profileResult = minecraftClient.getApiServices().sessionService().fetchProfile(uUID, false);
                return profileResult != null ? profileResult.profile() : null;
            }).thenCompose(gameProfile -> gameProfile == null ? CompletableFuture.completedFuture(Optional.empty()) : minecraftClient.getSkinProvider().fetchSkinTextures(gameProfile))).thenAcceptAsync(optional -> optional.ifPresent(skinTextures -> jpa.put(uUID, (SkinTextures)skinTextures)), (Executor)minecraftClient)).exceptionally(throwable -> null));
        }
        return skinTextures2;
    }

    private void jrf(String string, int n) {
        this.jpv = string;
        this.jpw = n;
        this.jpx = kap.clock();
    }

    private void jrg() {
        float f;
        this.jpt = kap.clock();
        String string = this.jpq.trim();
        if (!joz.matcher(string).matches()) {
            this.jps = kap.clock();
            this.jrf(wap.s(a.c(-1785022126, "\ub930\uc0e0\u4a7d\ud403\u5fd8\ud961\u6377\ueacf\u748a\ufe68\u79a8\u83c7\u0d0c\u94ba\u1eff\u9842\u2204\uadc4\u3777\ub137\u38d7\u4287\ucc6b\u57b6\ud18d\u5b51\ue2ec\u6cb3\uf659\u700f\ufbef\u0571\u8f23\u1680\u90ac"), a.d("\u097b\u70ef\ufa3e\u604f\ueb82\u6d20\ud76d\u5e80\uc0d8\u4a7f\uc9cd\u33c5\ubd16\u24a9\uaef6\u2802\u9248\u1d95\u8338\u0565\u8889\uf2d3\u7c12\ue7b9\u61c3\ueb17\u52da\udcfd\u4216\uc44b\u4b9e\ub531\u3f02\ua6f7\u20af\uae75\u15ba\u9bd3\u1d7f", -1431350642, 1595301839)), 0xFF8A8A);
            return;
        }
        if (!jyw.addOffline(string)) {
            this.jps = kap.clock();
            this.jrf(wap.s(a.b("\ua068\ud9e5\u533f\ucd5b\u46d8\uc027\u7a7b\uf386\u6dd1\ue725\u60bf\u9ad4\u1450\u8da0\u07fe\u8111\u3b49\ub49c\u2e2a\ua866\u21c8\u5bd6\ud564\u4efb\uc8d0\u421d\ufba3\u75b7\uef0c\u6958\ue2f1\u1c27", -755392484), a.d("\u7ec6\u0765\u8dbc\u13c9\u9819\u1ab1\ua4ff\u2d0b\ub356\u3dfd\ube4d\u4449\uca9d\u5739\ud97f\u5ffa\ue5b6\u6a69\uf4b6\u76f5\ufb10\u8520\u0bed\u903b\u163d\u9c97\u252b", 1882658531, -894407652)), 16762475);
            return;
        }
        this.jpq = "";
        this.jqr(kap.clock(), false);
        this.jqc = f = Math.max(0.0f, (float)this.jph.size() * 32.0f - 4.0f - this.jqy());
        this.jrf(wap.s(a.c(69171204, "\u7843\u01d7\u8b04\u1574\u9ea2\u1857"), a.b("\u60e7\u197c\u93a0\u0dd0\u8605\u00bd\ubae0\u3319\ua95b", 749823226)) + string, 7268256);
    }

    private void jrh() {
        this.jpu = kap.clock();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        String string = jqn[threadLocalRandom.nextInt(jqn.length)] + jqo[threadLocalRandom.nextInt(jqo.length)];
        if (threadLocalRandom.nextBoolean()) {
            string = string + threadLocalRandom.nextInt(10, 999);
        }
        this.jpq = string.length() > 16 ? string.substring(0, 16) : string;
        this.jpr = true;
    }

    private void jri(jop jop2) {
        if (this.jpy != null) {
            return;
        }
        if (jyw.disabled()) {
            this.jrf(wap.s(a.b("\u04b5\u7d0c\uf7cd\u69cf\ue251\u64fa\udefa\u5758\uc903\u43ac\uc462\u3e04\ub0d8\u2964\ua336\u2583\u9f83\u105b\u8ae8\u0cff\u8500\uff10\u71be\uea68\u6c44\ue6c6\u5f63\ud123\u4bd4\ucd98\u462c\ub8f4\u32af\uab04", 1690240222), a.c(129404169, "\u8d5f\uf4e6\u7e27\ue025\u6fe0\ue928\u530a\udafa\u44d0\uce68\u49c9\ub3b0\u397a\ua0c3\u2e8a\uac69\u1233\u9de4\u075a\u8515\u08ff\u72a3\ufc61\u67b3\ue1ce\u6b61\ud2d5\u5c87\uc67a\u405e\ucf81")), 0xFF8A8A);
            return;
        }
        this.jpy = jop2.alt.handle();
        this.jrf(wap.s(a.c(2050613755, "\ue1a6\u982d\u12f0\u8c88\u0758\u81ee\u3bb4\ub202\u2c14\ua6a2\u213f\udb0f\u55ca\ucc28"), a.d("\u93da\uea3c\u6094\ufeef\u7136\uf79d", 946269895, 1277458697)) + jop2.alt.name() + a.d("\u81fd\uf84c\u729f", -223333102, -1585007422), this.jpf.accent);
        jyw.login(jop2.alt, new jom(this));
    }

    public void close() {
        if (this.jqe < 0.0f) {
            this.jqe = kap.clock();
        }
    }

    public boolean mouseClicked(Click click, boolean doubled) {
        if (this.jqe >= 0.0f) {
            return true;
        }
        float f = (float)click.x() / this.jqk - this.jqs();
        float f2 = (float)click.y() / this.jqk - this.jqt();
        if (click.button() != 0) {
            return true;
        }
        float f3 = kap.clock();
        if (!jos.jrk(f, f2, 0.0f, 0.0f, 268.0f, 218.0f)) {
            this.close();
            return true;
        }
        if (jos.jrl(f, f2, 246.0f, 22.0f) < 9.0f) {
            this.close();
            return true;
        }
        vdn vdn2 = veo.medium(6.4f);
        float f4 = vdn2.width(a.d("\u2300\u5a95\ud04c\u4e2c\uc5e6\u434b\uf904\u70fc\ueeb1", 171419603, -2096659305)) + 22.0f;
        if (jos.jrk(f, f2, 232.0f - f4, 14.0f, f4, 16.0f)) {
            jyw.openOriginal(this);
            return true;
        }
        float f5 = 184.0f;
        float f6 = 22.0f;
        float f7 = 244.0f - 2.0f * (f6 + 6.0f);
        boolean bl = this.jpr = jos.jrk(f, f2, 12.0f, f5, f7, f6) || this.jpr && !jos.jrk(f, f2, 10.0f, this.jqx(), 248.0f, this.jqy());
        if (jos.jrk(f, f2, 12.0f + f7 + 6.0f, f5, f6, f6)) {
            this.jrh();
            return true;
        }
        if (jos.jrk(f, f2, 12.0f + f7 + 12.0f + f6, f5, f6, f6)) {
            this.jrg();
            return true;
        }
        if (jos.jrk(f, f2, 10.0f, this.jqx(), 248.0f, this.jqy())) {
            float f8 = this.jqx() - this.jqb;
            for (jyi jyi2 : this.jph) {
                jop jop2 = this.jpi.get(jyi2.handle());
                if (jop2 != null && jos.jrk(f, f2, 10.0f, f8, 248.0f, 28.0f)) {
                    float f9 = 232.0f;
                    if (jos.jrk(f, f2, f9, f8 + 5.0f, 20.0f, 18.0f)) {
                        if (this.jpz == jyi2.handle() && f3 - this.jqa < 2.5f) {
                            this.jpz = null;
                            jyw.remove(jyi2);
                            this.jqr(f3, false);
                            this.jrf(wap.s(a.c(-1247646000, "\u6e8a\u170c\u9dd7\u03a4\u886a\u0ec8\ub49a\u3d2f"), a.c(25662220, "\u9728\uee8e\u6459\ufa23\u719e\uf743\u490d")) + jyi2.name(), 16762475);
                        } else {
                            this.jpz = jyi2.handle();
                            this.jqa = f3;
                        }
                    } else {
                        jop2.pressAt = f3;
                        jop2.px = f - 10.0f;
                        this.jri(jop2);
                    }
                    return true;
                }
                f8 += 32.0f;
            }
        }
        return true;
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.jqc -= (float)verticalAmount * 32.0f;
        return true;
    }

    public boolean charTyped(CharInput input) {
        if (!this.jpr || this.jqe >= 0.0f) {
            return true;
        }
        String string = input.asString();
        StringBuilder stringBuilder = new StringBuilder(this.jpq);
        for (char c : string.toCharArray()) {
            if (stringBuilder.length() >= 16 || !Character.isLetterOrDigit(c) && c != '_' || c >= '\u0080') continue;
            stringBuilder.append(c);
        }
        this.jpq = stringBuilder.toString();
        return true;
    }

    public boolean keyPressed(KeyInput input) {
        int n = input.key();
        if (n == 256) {
            this.close();
            return true;
        }
        if (!this.jpr) {
            return true;
        }
        boolean bl = (input.modifiers() & 0xA) != 0;
        switch (n) {
            case 259: {
                if (bl) {
                    this.jpq = "";
                    break;
                }
                if (this.jpq.isEmpty()) break;
                this.jpq = this.jpq.substring(0, this.jpq.length() - 1);
                break;
            }
            case 257: 
            case 335: {
                this.jrg();
                break;
            }
            case 86: {
                if (!bl) break;
                this.jrj();
                break;
            }
        }
        return true;
    }

    private void jrj() {
        String string = this.client.keyboard.getClipboard();
        StringBuilder stringBuilder = new StringBuilder(this.jpq);
        for (char c : string.toCharArray()) {
            if (stringBuilder.length() >= 16 || !Character.isLetterOrDigit(c) && c != '_' || c >= '\u0080') continue;
            stringBuilder.append(c);
        }
        this.jpq = stringBuilder.toString();
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public boolean shouldPause() {
        return false;
    }

    public void removed() {
        this.jpd.close();
        vdn.setRenderScale(1.0f);
    }

    private static boolean jrk(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f2 >= f4 && f < f3 + f5 && f2 < f4 + f6;
    }

    private static float jrl(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float)Math.sqrt(f5 * f5 + f6 * f6);
    }

    private static int jrm(int n, float f) {
        return kce.rgba(n, f);
    }

    private static /* synthetic */ int apk(int n, int n2) {
        return n + n2 | 0x8B37602E;
    }

    private static /* synthetic */ int apl(int n, int n2) {
        return jos.apk(n, n2) * n2;
    }
}

