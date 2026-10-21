/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.yggdrasil.ProfileResult
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1068
 *  net.minecraft.class_11905
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_8685
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.jom;
import a.jop;
import a.MenuSnowRenderer;
import a.jyi;
import a.IasAccounts;
import a.jza;
import a.MenuArtCache;
import a.kam;
import a.MenuSceneRenderer;
import a.MenuScale;
import a.WallpaperEntry;
import a.WordmarkDrawer;
import a.WordmarkAnimator;
import a.FrameDelta;
import a.GlowSprite;
import a.PlayerHeadDraw;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import com.mojang.authlib.yggdrasil.ProfileResult;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
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
import net.minecraft.class_1068;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_8685;
import org.joml.Matrix3x2fStack;

public final class AccountsScreen
extends class_437 {
    private static final float jot = 268.0f;
    private static final float jou = 218.0f;
    private static final float jov = 46.0f;
    private static final float jow = 28.0f;
    private static final float jox = 4.0f;
    private static final float joy = 50.0f;
    private static final Pattern joz = Pattern.compile("[A-Za-z0-9_]{3,16}");
    private static final Map<UUID, class_8685> jpa = new HashMap<UUID, class_8685>();
    private static final Map<UUID, CompletableFuture<?>> jpb = new HashMap();
    private final class_437 jpc;
    private final MenuSceneRenderer jpd = new MenuSceneRenderer();
    private final kam jpe = new kam();
    private final WallpaperEntry jpf = WallpaperEntry.selected();
    private final MenuSnowRenderer jpg;
    private List<jyi> jph;
    private final Map<Object, jop> jpi;
    private final List<jop> jpj;
    private final Spring jpk;
    private final Spring jpl;
    private final Spring jpm;
    private final Spring jpn;
    private final Spring jpo;
    private final Spring jpp;
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
    private static final String[] jqn = new String[]{"Swift", "Frost", "Lunar", "Pixel", "Shadow", "Neo", "Crystal", "Ember", "Silent", "Night", "Storm", "Velvet", "Cosmo", "Echo", "Nova", "Blaze"};
    private static final String[] jqo = new String[]{"Fox", "Wolf", "Flow", "Hawk", "Byte", "Rider", "Drift", "Lynx", "Ghost", "Wave", "Ray", "Raven", "Comet", "Moth"};
    private static /* synthetic */ String jqp;
    private static /* synthetic */ String jqq;

    public AccountsScreen(class_437 class_4372) {
        super((class_2561)class_2561.method_43470((String)"Alt manager"));
        this.jpg = new MenuSnowRenderer(this.jpf.particles, 11L);
        this.jph = new ArrayList<jyi>();
        this.jpi = new IdentityHashMap<Object, jop>();
        this.jpj = new ArrayList<jop>();
        this.jpk = new Spring(14.0f);
        this.jpl = new Spring(14.0f);
        this.jpm = new Spring(14.0f);
        this.jpn = new Spring(14.0f);
        this.jpo = new Spring(12.0f);
        this.jpp = new Spring(9.0f);
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
        this.jpc = class_4372;
        MenuArtCache.preload(this.jpf.key);
        this.jqr(MenuSceneRenderer.clock(), true);
        if (IasAccounts.disabled()) {
            this.jrf(Lang.s("IAS is switched off (its settings)", "IAS выключен (в его настройках)"), 0xFF8A8A);
        }
    }

    private void jqr(float f, boolean bl) {
        this.jph = IasAccounts.accounts();
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

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        DrawUtil.beginFrame();
        FrameDelta.observe(class_3322);
        long l = System.nanoTime();
        this.jqj = this.jqi == 0L ? 0.016666668f : Math.min(0.1f, (float)(l - this.jqi) / 1.0E9f);
        this.jqi = l;
        float f2 = MenuSceneRenderer.clock();
        if (this.jqd < 0.0f) {
            this.jqd = f2;
        }
        float f3 = f2 - this.jqd;
        float f4 = this.jqe >= 0.0f ? Easing.clamp01((f2 - this.jqe) / 0.22f) : 0.0f;
        this.jqk = MenuScale.scale(this.field_22789, this.field_22790);
        this.jql = (float)this.field_22789 / this.jqk;
        this.jqm = (float)this.field_22790 / this.jqk;
        float f5 = (float)n / this.jqk;
        float f6 = (float)n2 / this.jqk;
        float f7 = 1.0f - (float)Math.exp(-this.jqj * 2.2f);
        if (n >= 0 && n2 >= 0 && n <= this.field_22789 && n2 <= this.field_22790) {
            this.jqg += ((float)n / (float)this.field_22789 - 0.5f - this.jqg) * f7;
            this.jqh += ((float)n2 / (float)this.field_22790 - 0.5f - this.jqh) * f7;
        }
        GpuTextureView gpuTextureView = GlowSprite.view();
        DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, -16118250);
        jza jza2 = MenuArtCache.get(this.jpf.key);
        if (jza2 != null) {
            float f8 = Easing.outCubic(Easing.clamp01(f3 / 0.5f)) * (1.0f - Easing.inOutCubic(f4));
            this.jpe.time = f2;
            this.jpe.zoom = 1.05f + 0.01f * f8;
            this.jpe.panX = -this.jqg * 0.014f;
            this.jpe.panY = -this.jqh * 0.01f;
            this.jpe.blur = 0.55f * f8;
            this.jpe.dim = 0.04f + 0.12f * f8;
            this.jpe.tint = this.jpf.tint;
            this.jpe.tintAmount = 0.3f;
            this.jpe.fall = null;
            this.jpe.pool = null;
            this.jpd.draw(class_3322, jza2, this.jpe, this.field_22789, this.field_22790, 1.0f, true);
        }
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.scale(this.jqk, this.jqk);
        FontFace.setRenderScaleStepped(this.jqk);
        try {
            this.jpg.draw(class_3322, gpuTextureView, this.jql, this.jqm, f2, false, this.jqg, this.jqh, 1.0f);
            float f9 = Easing.clamp01(f3 / 0.42f);
            float f10 = Easing.outBack(f9) * (1.0f - f4) + 0.0f;
            float f11 = Easing.clamp01(f9 * 1.6f) * (1.0f - Easing.inCubic(f4));
            float f12 = this.jqs();
            float f13 = this.jqt();
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate(f12 + 134.0f, f13 + 109.0f);
            float f14 = 0.94f + 0.06f * Math.min(1.0f, f10) - 0.03f * f4;
            matrix3x2fStack.scale(f14, f14);
            matrix3x2fStack.translate(-134.0f, -109.0f + (1.0f - Math.min(1.0f, f10)) * 10.0f);
            DrawUtil.pushAlpha(f11);
            try {
                this.jqu(class_3322, gpuTextureView, f5 - f12, f6 - f13, f2, f12, f13);
            }
            finally {
                DrawUtil.popAlpha();
                matrix3x2fStack.popMatrix();
            }
        }
        finally {
            DrawUtil.additive(false);
            matrix3x2fStack.popMatrix();
            FontFace.setRenderScale(1.0f);
        }
        if (f4 >= 1.0f && !this.jqf) {
            this.jqf = true;
            this.field_22787.method_63588(() -> this.field_22787.method_1507(this.jpc));
        }
    }

    private float jqs() {
        return (this.jql - 268.0f) * 0.5f;
    }

    private float jqt() {
        return (this.jqm - 218.0f) * 0.5f + 4.0f;
    }

    private void jqu(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5) {
        float f6 = 14.0f;
        int n = this.jpf.accent;
        DrawUtil.shadow(class_3322, 0.0f, 6.0f, 268.0f, 218.0f, f6, 28.0f, AccountsScreen.jrm(0, 0.45f));
        this.jpd.frosted(class_3322, 0.0f, 0.0f, 268.0f, 218.0f, f6, f4, f5, this.jql, this.jqm, AccountsScreen.jrm(0xFFFFFF, 1.0f));
        DrawUtil.round(class_3322, 0.0f, 0.0f, 268.0f, 218.0f, f6, AccountsScreen.jrm(658966, 0.52f));
        DrawUtil.gradient(class_3322, 0.0f, 0.0f, 268.0f, 60.0f, f6, f6, 0.0f, 0.0f, AccountsScreen.jrm(0xFFFFFF, 0.06f), AccountsScreen.jrm(0xFFFFFF, 0.06f), AccountsScreen.jrm(0xFFFFFF, 0.0f), AccountsScreen.jrm(0xFFFFFF, 0.0f));
        DrawUtil.outlineGradientV(class_3322, 0.0f, 0.0f, 268.0f, 218.0f, f6, 0.7f, AccountsScreen.jrm(0xFFFFFF, 0.28f), AccountsScreen.jrm(0xFFFFFF, 0.06f));
        this.jqv(class_3322, f, f2, n);
        this.jqz(class_3322, f, f2, f3, n);
        this.jrc(class_3322, gpuTextureView, f, f2, f3, n);
    }

    private void jqv(class_332 class_3322, float f, float f2, int n) {
        DrawUtil.round(class_3322, 14.0f, 13.0f, 22.0f, 22.0f, 7.0f, AccountsScreen.jrm(n, 0.16f));
        DrawUtil.outline(class_3322, 14.0f, 13.0f, 22.0f, 22.0f, 7.0f, 0.6f, AccountsScreen.jrm(n, 0.45f));
        IconRenderer.draw(class_3322, Icon.ACCOUNTS, 25.0f, 24.0f, 12.0f, AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(n, 0xFFFFFF, 0.3f), 1.0f));
        FontFace vdn2 = Fonts.semibold(10.4f);
        vdn2.draw(class_3322, Lang.s("Alt manager", "Альт менеджер"), 44.0f, vdn2.centerTop(19.0f), AccountsScreen.jrm(0xFFFFFF, 0.97f));
        FontFace vdn3 = Fonts.medium(6.4f);
        String string = this.field_22787.method_1548().method_1676();
        String string2 = Lang.s("Playing as ", "Сейчас: ");
        float f3 = vdn3.width(string2);
        vdn3.draw(class_3322, string2, 44.0f, vdn3.centerTop(31.5f), AccountsScreen.jrm(0xFFFFFF, 0.5f));
        DrawUtil.circle(class_3322, 44.0f + f3 + 3.0f, 31.5f, 2.0f, AccountsScreen.jrm(7268256, 0.95f));
        vdn3.draw(class_3322, string, 44.0f + f3 + 8.0f, vdn3.centerTop(31.5f), AccountsScreen.jrm(0xFFFFFF, 0.88f));
        float f4 = 246.0f;
        float f5 = 22.0f;
        float f6 = this.jpk.step(AccountsScreen.jrl(f, f2, f4, f5) < 9.0f, this.jqj);
        DrawUtil.circle(class_3322, f4, f5, 8.5f, AccountsScreen.jrm(0xFFFFFF, 0.05f + 0.1f * f6));
        IconRenderer.draw(class_3322, Icon.CLOSE, f4, f5, 8.0f + f6, AccountsScreen.jrm(0xFFFFFF, 0.6f + 0.4f * f6));
        FontFace vdn4 = Fonts.medium(6.4f);
        String string3 = "Microsoft";
        float f7 = vdn4.width(string3) + 22.0f;
        float f8 = f4 - 14.0f - f7;
        float f9 = f5 - 8.0f;
        float f10 = this.jpl.step(AccountsScreen.jrk(f, f2, f8, f9, f7, 16.0f), this.jqj);
        DrawUtil.round(class_3322, f8, f9, f7, 16.0f, 8.0f, AccountsScreen.jrm(0xFFFFFF, 0.05f + 0.08f * f10));
        DrawUtil.outline(class_3322, f8, f9, f7, 16.0f, 8.0f, 0.6f, AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n, f10), 0.16f + 0.4f * f10));
        AccountsScreen.jqw(class_3322, f8 + 9.0f, f9 + 8.0f, 6.0f, f10);
        vdn4.draw(class_3322, string3, f8 + 15.0f, vdn4.centerTop(f9 + 8.0f), AccountsScreen.jrm(0xFFFFFF, 0.75f + 0.25f * f10));
        DrawUtil.rect(class_3322, 12.0f, 45.5f, 244.0f, 0.6f, AccountsScreen.jrm(0xFFFFFF, 0.08f));
    }

    private static void jqw(class_332 class_3322, float f, float f2, float f3, float f4) {
        float f5 = f3 * 0.1f;
        float f6 = (f3 - f5) * 0.5f;
        float f7 = f - f3 * 0.5f;
        float f8 = f2 - f3 * 0.5f;
        float f9 = 0.75f + 0.25f * f4;
        DrawUtil.rect(class_3322, f7, f8, f6, f6, AccountsScreen.jrm(15880226, f9));
        DrawUtil.rect(class_3322, f7 + f6 + f5, f8, f6, f6, AccountsScreen.jrm(8370688, f9));
        DrawUtil.rect(class_3322, f7, f8 + f6 + f5, f6, f6, AccountsScreen.jrm(42223, f9));
        DrawUtil.rect(class_3322, f7 + f6 + f5, f8 + f6 + f5, f6, f6, AccountsScreen.jrm(16759040, f9));
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
    private void jqz(class_332 class_3322, float f, float f2, float f3, int n) {
        float f4 = this.jqx();
        float f5 = this.jqy();
        float f6 = Math.max(0.0f, (float)this.jph.size() * 32.0f - 4.0f - f5);
        this.jqc = Math.max(0.0f, Math.min(f6, this.jqc));
        this.jqb += (this.jqc - this.jqb) * (1.0f - (float)Math.exp(-this.jqj * 14.0f));
        boolean bl = AccountsScreen.jrk(f, f2, 10.0f, f4, 248.0f, f5);
        DrawUtil.pushScissor(class_3322, 6.0f, f4, 256.0f, f5);
        try {
            if (this.jph.isEmpty() && this.jpj.isEmpty()) {
                this.jra(class_3322, f4, f5, n);
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
                    this.jrb(class_3322, jop3, 10.0f, f7, f, f2, bl, f3, n);
                }
                f7 += 32.0f;
            }
        }
        finally {
            DrawUtil.popScissor(class_3322);
        }
        if (this.jqb > 0.5f) {
            DrawUtil.gradientV(class_3322, 8.0f, f4, 252.0f, 8.0f, 0.0f, AccountsScreen.jrm(658966, 0.35f), AccountsScreen.jrm(658966, 0.0f));
        }
        if (this.jqb < f6 - 0.5f) {
            DrawUtil.gradientV(class_3322, 8.0f, f4 + f5 - 8.0f, 252.0f, 8.0f, 0.0f, AccountsScreen.jrm(658966, 0.0f), AccountsScreen.jrm(658966, 0.35f));
        }
    }

    private void jra(class_332 class_3322, float f, float f2, int n) {
        float f3 = f + f2 * 0.5f;
        IconRenderer.draw(class_3322, Icon.USER_PLUS, 134.0f, f3 - 12.0f, 18.0f, AccountsScreen.jrm(n, 0.8f));
        FontFace vdn2 = Fonts.semibold(8.0f);
        vdn2.drawCentered(class_3322, Lang.s("No accounts yet", "Аккаунтов пока нет"), 134.0f, vdn2.centerTop(f3 + 6.0f), AccountsScreen.jrm(0xFFFFFF, 0.9f));
        FontFace vdn3 = Fonts.medium(6.2f);
        vdn3.drawCentered(class_3322, Lang.s("Type a name below and press Enter", "Впишите ник ниже и нажмите Enter"), 134.0f, vdn3.centerTop(f3 + 17.0f), AccountsScreen.jrm(0xFFFFFF, 0.5f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jrb(class_332 class_3322, jop jop2, float f, float f2, float f3, float f4, boolean bl, float f5, int n) {
        float f6 = 248.0f;
        float f7 = Easing.outCubic(Easing.clamp01((f5 - jop2.bornAt) / 0.4f));
        if (f7 <= 0.0f) {
            return;
        }
        jyi jyi2 = jop2.alt;
        boolean bl2 = jyi2.name().equals(this.field_22787.method_1548().method_1676());
        boolean bl3 = this.jpy == jyi2.handle();
        boolean bl4 = bl && this.jqe < 0.0f && AccountsScreen.jrk(f3, f4, f, f2, f6, 28.0f);
        float f8 = jop2.hover.step(bl4 || bl3, this.jqj);
        float f9 = f + f6 - 26.0f;
        float f10 = f9 - 52.0f;
        boolean bl5 = bl4 && AccountsScreen.jrk(f3, f4, f9, f2 + 5.0f, 20.0f, 18.0f);
        boolean bl6 = bl4 && !bl5 && AccountsScreen.jrk(f3, f4, f10, f2 + 5.0f, 48.0f, 18.0f);
        float f11 = jop2.binHover.step(bl5, this.jqj);
        float f12 = jop2.loginHover.step(bl6, this.jqj);
        boolean bl7 = this.jpz == jyi2.handle() && f5 - this.jqa < 2.5f;
        float f13 = Easing.clamp01((f5 - jop2.pressAt) / 0.45f);
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate((1.0f - f7) * 14.0f, 0.0f);
        DrawUtil.pushAlpha(f7);
        try {
            float f14;
            Object object;
            int n2 = bl2 ? WordmarkAnimator.AutoTpAccept(658966, n, 0.12f) : 658966;
            DrawUtil.round(class_3322, f, f2, f6, 28.0f, 9.0f, AccountsScreen.jrm(n2, 0.32f + 0.14f * f8));
            DrawUtil.round(class_3322, f, f2, f6, 28.0f, 9.0f, AccountsScreen.jrm(0xFFFFFF, 0.03f + 0.04f * f8));
            if (f13 < 1.0f) {
                float f15 = f6 * Easing.outCubic(f13);
                float f16 = Math.max(f, f + jop2.px - f15);
                float f17 = Math.min(f + f6, f + jop2.px + f15);
                DrawUtil.round(class_3322, f16, f2, f17 - f16, 28.0f, 9.0f, AccountsScreen.jrm(n, 0.18f * (1.0f - f13)));
            }
            DrawUtil.outline(class_3322, f, f2, f6, 28.0f, 9.0f, 0.6f, AccountsScreen.jrm(bl2 ? n : 0xFFFFFF, bl2 ? 0.45f + 0.2f * f8 : 0.06f + 0.14f * f8));
            PlayerHeadDraw.draw(class_3322, AccountsScreen.jre(jyi2), f + 6.0f, f2 + 5.0f, 18.0f, 4.5f, AccountsScreen.jrm(0xFFFFFF, 1.0f));
            FontFace vdn2 = Fonts.semibold(7.8f);
            vdn2.draw(class_3322, jyi2.name(), f + 31.0f, vdn2.centerTop(f2 + 10.5f), AccountsScreen.jrm(0xFFFFFF, 0.96f));
            FontFace vdn3 = Fonts.medium(5.8f);
            String string = jyi2.microsoft() ? Lang.s("Licensed · Microsoft", "Лицензия · Microsoft") : Lang.s("Offline", "Пиратка");
            float f18 = vdn3.width(string);
            vdn3.draw(class_3322, string, f + 31.0f, vdn3.centerTop(f2 + 19.5f), AccountsScreen.jrm(jyi2.microsoft() ? WordmarkAnimator.AutoTpAccept(0xFFFFFF, n, 0.5f) : 0xFFFFFF, jyi2.microsoft() ? 0.75f : 0.45f));
            if (bl2) {
                FontFace vdn4 = Fonts.semibold(5.4f);
                object = Lang.s("IN GAME", "В ИГРЕ");
                float f19 = vdn4.width((String)object) + 8.0f;
                float f20 = f + 31.0f + Math.max(vdn2.width(jyi2.name()) + 6.0f, 0.0f);
                DrawUtil.round(class_3322, f20, f2 + 6.5f, f19, 8.0f, 4.0f, AccountsScreen.jrm(n, 0.22f));
                vdn4.draw(class_3322, (String)object, f20 + 4.0f, vdn4.centerTop(f2 + 10.5f), AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(n, 0xFFFFFF, 0.4f), 1.0f));
            }
            float f21 = f14 = bl3 || bl7 ? 1.0f : f8;
            if (f14 > 0.01f) {
                DrawUtil.pushAlpha(f14);
                if (bl3) {
                    WordmarkDrawer.draw(class_3322, null, f10 + 24.0f, f2 + 14.0f, 5.0f, 1.4f, f5, 0.0f, n);
                } else {
                    DrawUtil.round(class_3322, f10, f2 + 5.0f, 48.0f, 18.0f, 9.0f, AccountsScreen.jrm(n, 0.22f + 0.3f * f12));
                    DrawUtil.outline(class_3322, f10, f2 + 5.0f, 48.0f, 18.0f, 9.0f, 0.6f, AccountsScreen.jrm(n, 0.5f + 0.4f * f12));
                    IconRenderer.draw(class_3322, Icon.LOGIN, f10 + 11.0f, f2 + 14.0f, 7.5f, AccountsScreen.jrm(0xFFFFFF, 0.9f));
                    object = Fonts.semibold(6.4f);
                    ((FontFace)object).draw(class_3322, Lang.s("Sign in", "Войти"), f10 + 18.0f, ((FontFace)object).centerTop(f2 + 14.0f), AccountsScreen.jrm(0xFFFFFF, 0.95f));
                }
                int n3 = 0xFF6B6B;
                DrawUtil.round(class_3322, f9, f2 + 5.0f, 20.0f, 18.0f, 9.0f, AccountsScreen.jrm(n3, (bl7 ? 0.35f : 0.06f) + 0.2f * f11));
                IconRenderer.draw(class_3322, bl7 ? Icon.CHECK : Icon.TRASH, f9 + 10.0f, f2 + 14.0f, 8.0f, AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n3, Math.max(f11, bl7 ? 1.0f : 0.0f)), 0.7f + 0.3f * f11));
                DrawUtil.popAlpha();
            }
            if (bl7) {
                object = Fonts.medium(5.6f);
                ((FontFace)object).drawRight(class_3322, Lang.s("Remove?", "Удалить?"), f10 - 4.0f, ((FontFace)object).centerTop(f2 + 14.0f), AccountsScreen.jrm(0xFF8A8A, 0.95f));
            }
        }
        finally {
            DrawUtil.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private void jrc(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, int n) {
        float f4;
        float f5;
        float f6 = 184.0f;
        float f7 = 12.0f;
        float f8 = 22.0f;
        float f9 = 244.0f - 2.0f * (f8 + 6.0f);
        float f10 = this.jpp.step(f3 - this.jpx < 4.5f && !this.jpv.isEmpty(), this.jqj);
        if (f10 > 0.01f) {
            FontFace vdn2 = Fonts.medium(6.2f);
            DrawUtil.pushAlpha(f10);
            f5 = f6 - 9.0f + (1.0f - f10) * 3.0f;
            DrawUtil.circle(class_3322, f7 + 3.0f, f5, 1.8f, AccountsScreen.jrm(this.jpw, 0.95f));
            vdn2.draw(class_3322, vdn2.ellipsize(this.jpv, 228.0f), f7 + 9.0f, vdn2.centerTop(f5), AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(0xFFFFFF, this.jpw, 0.35f), 0.92f));
            DrawUtil.popAlpha();
        }
        float f11 = f3 - this.jps < 0.4f ? (float)Math.sin((f3 - this.jps) * 50.0f) * 3.0f * (1.0f - (f3 - this.jps) / 0.4f) : 0.0f;
        f5 = this.jpo.step(this.jpr, this.jqj);
        float f12 = f6;
        boolean bl = joz.matcher(this.jpq).matches();
        DrawUtil.round(class_3322, f7 + f11, f12, f9, f8, f8 * 0.5f, AccountsScreen.jrm(329741, 0.4f + 0.12f * f5));
        DrawUtil.outline(class_3322, f7 + f11, f12, f9, f8, f8 * 0.5f, 0.7f, AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n, f5), 0.12f + 0.4f * f5));
        IconRenderer.draw(class_3322, Icon.PLAYER, f7 + f11 + 12.0f, f12 + f8 * 0.5f, 8.5f, AccountsScreen.jrm(0xFFFFFF, 0.45f + 0.3f * f5));
        FontFace vdn3 = Fonts.medium(7.2f);
        float f13 = f7 + f11 + 22.0f;
        if (this.jpq.isEmpty()) {
            vdn3.draw(class_3322, Lang.s("New offline name", "Ник для нового аккаунта"), f13, vdn3.centerTop(f12 + f8 * 0.5f), AccountsScreen.jrm(0xFFFFFF, 0.32f));
        } else {
            vdn3.draw(class_3322, this.jpq, f13, vdn3.centerTop(f12 + f8 * 0.5f), AccountsScreen.jrm(0xFFFFFF, bl ? 0.95f : 0.8f));
        }
        if (this.jpr && (int)(f3 * 2.0f) % 2 == 0) {
            f4 = f13 + (this.jpq.isEmpty() ? 0.0f : vdn3.width(this.jpq) + 0.8f);
            DrawUtil.rect(class_3322, f4, f12 + 6.0f, 0.8f, f8 - 12.0f, AccountsScreen.jrm(n, 0.95f));
        }
        if (!this.jpq.isEmpty()) {
            FontFace vdn4 = Fonts.medium(5.6f);
            vdn4.drawRight(class_3322, this.jpq.length() + "/16", f7 + f11 + f9 - 10.0f, vdn4.centerTop(f12 + f8 * 0.5f), AccountsScreen.jrm(bl ? 0xFFFFFF : 0xFF8A8A, bl ? 0.35f : 0.8f));
        }
        f4 = f7 + f9 + 6.0f;
        this.jrd(class_3322, f4, f12, f8, Icon.DICE, this.jpn.step(AccountsScreen.jrk(f, f2, f4, f12, f8, f8), this.jqj), this.jpu, f3, 0xFFFFFF, n, false);
        float f14 = f4 + f8 + 6.0f;
        this.jrd(class_3322, f14, f12, f8, Icon.PLUS, this.jpm.step(AccountsScreen.jrk(f, f2, f14, f12, f8, f8), this.jqj), this.jpt, f3, n, n, bl);
    }

    private void jrd(class_332 class_3322, float f, float f2, float f3, Icon vhz2, float f4, float f5, float f6, int n, int n2, boolean bl) {
        float f7 = Easing.clamp01((f6 - f5) / 0.4f);
        float f8 = f7 < 1.0f ? (float)Math.sin(Math.PI * (double)Easing.clamp01(f7 * 2.4f)) : 0.0f;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f + f3 * 0.5f, f2 + f3 * 0.5f);
        float f9 = 1.0f + 0.06f * f4 - 0.1f * f8;
        matrix3x2fStack.scale(f9, f9);
        float f10 = f3 * 0.5f;
        DrawUtil.round(class_3322, -f10, -f10, f3, f3, f10, AccountsScreen.jrm(bl ? n2 : 0xFFFFFF, (bl ? 0.3f : 0.06f) + 0.14f * f4));
        DrawUtil.outline(class_3322, -f10, -f10, f3, f3, f10, 0.7f, AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n2, f4), 0.14f + 0.4f * f4));
        if (f7 < 1.0f) {
            DrawUtil.outline(class_3322, -f10 - 6.0f * f7, -f10 - 6.0f * f7, f3 + 12.0f * f7, f3 + 12.0f * f7, f10 + 6.0f * f7, 0.8f, AccountsScreen.jrm(n2, 0.6f * (1.0f - f7)));
        }
        IconRenderer.draw(class_3322, vhz2, 0.0f, 0.0f, 10.0f, AccountsScreen.jrm(WordmarkAnimator.AutoTpAccept(n, 0xFFFFFF, 0.3f + 0.7f * f4), 0.85f + 0.15f * f4));
        matrix3x2fStack.popMatrix();
    }

    private static class_8685 jre(jyi jyi2) {
        UUID uUID = jyi2.skin() != null ? jyi2.skin() : jyi2.uuid();
        class_8685 class_86852 = jpa.get(uUID);
        if (class_86852 != null) {
            return class_86852;
        }
        class_8685 class_86853 = class_1068.method_4648((UUID)uUID);
        if (jyi2.microsoft() && !jpb.containsKey(uUID)) {
            class_310 class_3102 = class_310.method_1551();
            jpb.put(uUID, (CompletableFuture<?>)((CompletableFuture)((CompletableFuture)CompletableFuture.supplyAsync(() -> {
                ProfileResult profileResult = class_3102.method_73361().comp_837().fetchProfile(uUID, false);
                return profileResult != null ? profileResult.profile() : null;
            }).thenCompose(gameProfile -> gameProfile == null ? CompletableFuture.completedFuture(Optional.empty()) : class_3102.method_1582().method_52863(gameProfile))).thenAcceptAsync(optional -> optional.ifPresent(class_86852 -> jpa.put(uUID, (class_8685)class_86852)), (Executor)class_3102)).exceptionally(throwable -> null));
        }
        return class_86853;
    }

    private void jrf(String string, int n) {
        this.jpv = string;
        this.jpw = n;
        this.jpx = MenuSceneRenderer.clock();
    }

    private void jrg() {
        float f;
        this.jpt = MenuSceneRenderer.clock();
        String string = this.jpq.trim();
        if (!joz.matcher(string).matches()) {
            this.jps = MenuSceneRenderer.clock();
            this.jrf(Lang.s("A name is 3-16 letters, digits or _", "Ник: 3-16 символов, латиница, цифры и _"), 0xFF8A8A);
            return;
        }
        if (!IasAccounts.addOffline(string)) {
            this.jps = MenuSceneRenderer.clock();
            this.jrf(Lang.s("That name is already on the list", "Такой ник уже есть в списке"), 16762475);
            return;
        }
        this.jpq = "";
        this.jqr(MenuSceneRenderer.clock(), false);
        this.jqc = f = Math.max(0.0f, (float)this.jph.size() * 32.0f - 4.0f - this.jqy());
        this.jrf(Lang.s("Added ", "Добавлен ") + string, 7268256);
    }

    private void jrh() {
        this.jpu = MenuSceneRenderer.clock();
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
        if (IasAccounts.disabled()) {
            this.jrf(Lang.s("IAS is switched off (its settings)", "IAS выключен (в его настройках)"), 0xFF8A8A);
            return;
        }
        this.jpy = jop2.alt.handle();
        this.jrf(Lang.s("Signing in as ", "Вход: ") + jop2.alt.name() + "...", this.jpf.accent);
        IasAccounts.login(jop2.alt, new jom(this));
    }

    public void method_25419() {
        if (this.jqe < 0.0f) {
            this.jqe = MenuSceneRenderer.clock();
        }
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        if (this.jqe >= 0.0f) {
            return true;
        }
        float f = (float)class_119092.comp_4798() / this.jqk - this.jqs();
        float f2 = (float)class_119092.comp_4799() / this.jqk - this.jqt();
        if (class_119092.method_74245() != 0) {
            return true;
        }
        float f3 = MenuSceneRenderer.clock();
        if (!AccountsScreen.jrk(f, f2, 0.0f, 0.0f, 268.0f, 218.0f)) {
            this.method_25419();
            return true;
        }
        if (AccountsScreen.jrl(f, f2, 246.0f, 22.0f) < 9.0f) {
            this.method_25419();
            return true;
        }
        FontFace vdn2 = Fonts.medium(6.4f);
        float f4 = vdn2.width("Microsoft") + 22.0f;
        if (AccountsScreen.jrk(f, f2, 232.0f - f4, 14.0f, f4, 16.0f)) {
            IasAccounts.openOriginal(this);
            return true;
        }
        float f5 = 184.0f;
        float f6 = 22.0f;
        float f7 = 244.0f - 2.0f * (f6 + 6.0f);
        boolean bl2 = this.jpr = AccountsScreen.jrk(f, f2, 12.0f, f5, f7, f6) || this.jpr && !AccountsScreen.jrk(f, f2, 10.0f, this.jqx(), 248.0f, this.jqy());
        if (AccountsScreen.jrk(f, f2, 12.0f + f7 + 6.0f, f5, f6, f6)) {
            this.jrh();
            return true;
        }
        if (AccountsScreen.jrk(f, f2, 12.0f + f7 + 12.0f + f6, f5, f6, f6)) {
            this.jrg();
            return true;
        }
        if (AccountsScreen.jrk(f, f2, 10.0f, this.jqx(), 248.0f, this.jqy())) {
            float f8 = this.jqx() - this.jqb;
            for (jyi jyi2 : this.jph) {
                jop jop2 = this.jpi.get(jyi2.handle());
                if (jop2 != null && AccountsScreen.jrk(f, f2, 10.0f, f8, 248.0f, 28.0f)) {
                    float f9 = 232.0f;
                    if (AccountsScreen.jrk(f, f2, f9, f8 + 5.0f, 20.0f, 18.0f)) {
                        if (this.jpz == jyi2.handle() && f3 - this.jqa < 2.5f) {
                            this.jpz = null;
                            IasAccounts.remove(jyi2);
                            this.jqr(f3, false);
                            this.jrf(Lang.s("Removed ", "Удалён ") + jyi2.name(), 16762475);
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

    public boolean method_25401(double d, double d2, double d3, double d4) {
        this.jqc -= (float)d4 * 32.0f;
        return true;
    }

    public boolean method_25400(class_11905 class_119052) {
        if (!this.jpr || this.jqe >= 0.0f) {
            return true;
        }
        String string = class_119052.method_74226();
        StringBuilder stringBuilder = new StringBuilder(this.jpq);
        for (char c : string.toCharArray()) {
            if (stringBuilder.length() >= 16 || !Character.isLetterOrDigit(c) && c != '_' || c >= '\u0080') continue;
            stringBuilder.append(c);
        }
        this.jpq = stringBuilder.toString();
        return true;
    }

    public boolean method_25404(class_11908 class_119082) {
        int n = class_119082.comp_4795();
        if (n == 256) {
            this.method_25419();
            return true;
        }
        if (!this.jpr) {
            return true;
        }
        boolean bl = (class_119082.comp_4797() & 0xA) != 0;
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
        String string = this.field_22787.field_1774.method_1460();
        StringBuilder stringBuilder = new StringBuilder(this.jpq);
        for (char c : string.toCharArray()) {
            if (stringBuilder.length() >= 16 || !Character.isLetterOrDigit(c) && c != '_' || c >= '\u0080') continue;
            stringBuilder.append(c);
        }
        this.jpq = stringBuilder.toString();
    }

    public boolean method_25422() {
        return false;
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25432() {
        this.jpd.close();
        FontFace.setRenderScale(1.0f);
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
        return WordmarkAnimator.rgba(n, f);
    }

    private static /* synthetic */ int apk(int n, int n2) {
        return n + n2 | 0x8B37602E;
    }

    private static /* synthetic */ int apl(int n, int n2) {
        return AccountsScreen.apk(n, n2) * n2;
    }
}

