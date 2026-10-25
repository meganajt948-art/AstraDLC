/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.text.Text
 */
package a;

import a.hyv;
import a.iov;
import a.irr;
import a.ivw;
import a.ivx;
import a.ujt;
import a.unf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.vzz;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public final class iwf
extends Screen {
    private static final float iwg = (float)Math.PI * 2;
    private static final float iwh = 30.0f;
    private static final float iwi = 12.0f;
    private static final float iwj = 19.0f;
    private static final float iwk = 9.0f;
    private static final long iwl = 240000000L;
    private final ivw iwm;
    private final int iwn;
    private final long iwo = System.nanoTime();
    private final vcj iwp = new vcj(20.0f);
    private final vcj iwq = new vcj(18.0f);
    private final List<vcj> iwr = new ArrayList<vcj>();
    private List<ivx> iws = List.of();
    private int iwt = -1;
    private int iwu = -1;
    private int iwv;
    private boolean iww;
    private boolean iwx = true;
    private boolean iwy;
    private long iwz = -1L;
    private float ixa = 0.016666668f;
    private static final int ixb = 37;
    private static /* synthetic */ long ixc;
    private static /* synthetic */ String ixd;

    public iwf(ivw ivw2, int n) {
        super((Text)Text.literal((String)a.b("\u0826\u71a8\ufb76\u6507\ueed9", 251660404)));
        this.iwm = ivw2;
        this.iwn = n;
        this.iww = n == -1;
    }

    private void ixe(DrawContext drawContext) {
        unf.observe(drawContext);
        if (unf.frame() == this.iwz) {
            return;
        }
        this.iwz = unf.frame();
        this.ixa = unf.delta() * (float)iov.ANIMATION.get();
        iov.update(this.ixa);
        this.iwp.step(true, this.ixa);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        uut.beginFrame();
        this.ixe(context);
        hyv.skip();
        uut.rect(context, 0.0f, 0.0f, this.width, this.height, ujt.withAlpha(0, Math.round(64.0f * vcq.outCubic(this.iwp.get()))));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        this.ixe(context);
        this.iws = this.iwm.slots();
        int n = this.iws.size();
        if (n == 0) {
            this.ixl();
            return;
        }
        while (this.iwr.size() < n) {
            this.iwr.add(new vcj(18.0f));
        }
        float f = vcq.outCubic(this.iwp.get());
        float f2 = (float)this.width * 0.5f;
        float f3 = (float)this.height * 0.5f;
        float f4 = this.iwq.step(this.iwu >= 0, this.ixa);
        this.iwt = this.iwu >= 0 || this.iwy ? -1 : iwf.ixg((float)mouseX - f2, (float)mouseY - f3, n);
        this.ixi();
        uut.pushAlpha(f * (1.0f - 0.6f * f4));
        try {
            this.ixh(context, f2, f3, n, 0.9f + 0.1f * f);
        }
        finally {
            uut.popAlpha();
        }
        if (f4 > 0.01f) {
            uut.pushAlpha(f4);
            try {
                this.ixr(context, mouseX, mouseY, f4);
            }
            finally {
                uut.popAlpha();
            }
        }
    }

    private static float ixf(int n) {
        return Math.max(50.0f, (float)n * 42.0f / ((float)Math.PI * 2));
    }

    private static int ixg(float f, float f2, int n) {
        if (f * f + f2 * f2 < 144.0f) {
            return -1;
        }
        float f3 = (float)(Math.atan2(f, -f2) / 6.2831854820251465);
        if (f3 < 0.0f) {
            f3 += 1.0f;
        }
        return (int)Math.floor(f3 * (float)n + 0.5f) % n;
    }

    private void ixh(DrawContext drawContext, float f, float f2, int n, float f3) {
        float f4;
        float f5 = iwf.ixf(n) * f3;
        float f6 = 30.0f * f3;
        float f7 = f5 + f6 * 0.5f;
        float f8 = f6 * 0.5f / f5 / ((float)Math.PI * 2);
        float f9 = Math.max(0.004f, 1.0f / (float)n - 2.0f * f8 - 0.012f);
        int n2 = ujt.withAlpha(iov.window, 236);
        int n3 = ujt.withAlpha(ujt.lerp(iov.window, iov.accent(), 0.32f), 246);
        for (int i = 0; i < n; ++i) {
            boolean bl;
            ivx ivx2 = this.iws.get(i);
            float f10 = this.iwr.get(i).step(i == this.iwt, this.ixa);
            float f11 = (float)i / (float)n - f9 * 0.5f;
            f4 = 3.0f * f10;
            uut.arc(drawContext, f, f2, f7 + f4 + 0.8f, f6 + f4 + 1.6f, f11, f9, ujt.lerp(ujt.withAlpha(0xFFFFFF, 26), iov.accent(210), f10));
            uut.arc(drawContext, f, f2, f7 + f4, f6 + f4, f11, f9, ujt.lerp(n2, n3, f10));
            float f12 = (float)i / (float)n * ((float)Math.PI * 2);
            float f13 = f5 + f4 * 0.5f;
            float f14 = f + (float)Math.sin(f12) * f13;
            float f15 = f2 - (float)Math.cos(f12) * f13;
            boolean bl2 = bl = ivx2.note() != null && !ivx2.note().isEmpty();
            if (ivx2.icon().isEmpty()) {
                vjf.draw(drawContext, vhz.PLUS, f14, f15, 9.0f * f3, ujt.lerp(iov.textMuted, iov.accent(), f10));
                continue;
            }
            if (this.iwq.get() > 0.01f) continue;
            float f16 = (ivx2.usable() ? 1.15f + 0.15f * f10 : 0.8f) * f3 * uut.alpha();
            float f17 = bl ? 3.0f : 0.0f;
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(f14, f15 - f17);
            drawContext.getMatrices().scale(f16, f16);
            drawContext.drawItem(ivx2.icon(), -8, -8);
            drawContext.getMatrices().popMatrix();
            if (ivx2.cooldown() > 0.001f) {
                uut.arc(drawContext, f14, f15 - f17, 11.0f * f3, 1.5f, 0.0f, Math.min(1.0f, ivx2.cooldown()), iov.accent(), iov.accent2(), iov.accent2(), iov.accent());
            }
            if (!bl) continue;
            irr.SMALL.drawCentered(drawContext, ivx2.note(), f14, irr.SMALL.centerTop(f15 + 10.5f * f3), ivx2.usable() ? ujt.lerp(iov.textDim, iov.text, f10) : -1096636);
        }
        float f18 = Math.min(22.0f, f5 - f6 * 0.5f - 6.0f);
        uut.circle(drawContext, f, f2, f18, ujt.withAlpha(iov.window, 236));
        uut.circleOutline(drawContext, f, f2, f18, 1.0f, ujt.withAlpha(0xFFFFFF, 26));
        if (this.iwt >= 0) {
            float f19 = Math.min(0.2f, 0.8f / (float)n);
            uut.arc(drawContext, f, f2, f18 + 2.4f, 1.6f, (float)this.iwt / (float)n - f19 * 0.5f, f19, iov.accent());
        }
        irr.SMALL.drawCentered(drawContext, irr.SMALL.ellipsize(this.iwm.title(), f18 * 2.0f - 6.0f), f, irr.SMALL.centerTop(f2), this.iwt >= 0 ? iov.text : iov.textDim);
        float f20 = f2 + f7 + 16.0f;
        if (this.iwt >= 0 && !this.iws.get(this.iwt).icon().isEmpty()) {
            ivx ivx3 = this.iws.get(this.iwt);
            String string = irr.NAME.ellipsize(ivx3.title(), 170.0f);
            f4 = irr.NAME.width(string) + 18.0f;
            uut.round(drawContext, f - f4 * 0.5f, f20 - 8.0f, f4, 16.0f, 8.0f, ujt.withAlpha(iov.window, 236));
            uut.outline(drawContext, f - f4 * 0.5f, f20 - 8.0f, f4, 16.0f, 8.0f, 1.0f, iov.accent(150));
            irr.NAME.drawCentered(drawContext, string, f, irr.NAME.centerTop(f20), ivx3.usable() ? iov.text : iov.textDim);
        } else {
            String string = this.iwt >= 0 ? wap.s(a.d("\u570b\u2e95\ua443\u3a38\ub1e7\u3707\u8d4e\u04fc\u9aa8\u101e\u97cd\u6da0\ue361\u7a95\uf087\u7679\ucc78\u43e0\ud94e\u5f0e\ud6f1", 1038676911, 1279173874), a.d("\u6e7f\u17ef\u9d3f\u034c\u8c9b\u0a30\ub471\u3df9\ua3dc\u291c\uaebf\u54bc\uda65\u47b8\uc9f4\u4f7a\uf540\u7a90\ue02b\u6673\ueff3", 69050018, 1100346578)) : (this.iwm.editable() ? wap.s(a.c(505175437, "\u5df9\u2473\uaeae\u30d0\ubb1b\u3dfe\u87ee\u0e10\u904a\u1af1\u9d2a\u6710\ue986\u7076\ufa76\u7c91\uc6dc\u4907\ud3bc\u55e6\udc0b\ua614\u28bd\ub32f\u355b\ubf83\u063f\u8867\u1292\u9486\u1f7c\ue1b0\u6bf8\uf25a\u7440\ufeec\u412a\ucb53"), a.b("\u3d89\u443d\ucee8\u54a5\udb6d\u5ddd\ue390\u6e0e\uf059\u7a9a\ufd45\u0737\u89ef\u1451\u9e18\u1c88\ua6ba\u2962\ub3d9\u358d\ubc00\uc65f\u4c80\ud34e\u554e\udfea\u6658\ue801\u72ff\uf4d9", 415316360)) : (this.iww ? wap.s(a.b("\u4be4\u327a\ub8ac\u26d7\uad08\u2bf2\u91e0\u181e\u860f\u0cf7\u8b39\u7159\uff86", -1182839894), a.d("\u87c3\ufe53\u7483\ueaf0\u6120\ue794\u5dbd\ud43b\u4e71\uc0df\u470d\ub962\u33aa\uaa64\u2042\ua6b2\u1cf5\u932d\u09e9\u8fb9", -1787070255, 56163100)) : wap.s(a.c(990576780, "\u00d3\u794b\uf389\u6dac\ue63c\u6085\uda99\u5327\ucd61\u47c3\uc007\u3a24\ub4b2\u2d0c\ua711\u21a9\u9bfb\u143b\u8e80"), a.c(1612343526, "\u6ce6\u150b\u9fa5\u01a8\u8a7d\u0ccf\ub6e6\u3f6d\ua145\u2fe1\uac28\u565e\ud88a\u413a\ucb6c\u4de4\uf3c8\u7804\ue2ba\u64ef\ue90c\u9742\u198e\u822a\u0454\u8e8d\u3737\ub911\u239a\ua5c9"))));
            irr.SMALL.drawCentered(drawContext, string, f, irr.SMALL.centerTop(f20), ujt.withAlpha(0xFFFFFF, 170));
        }
    }

    private void ixi() {
        boolean bl;
        if (this.iwy || this.iwu >= 0 || this.client == null) {
            return;
        }
        boolean bl2 = bl = this.iwn != -1 && vzz.isDown(this.client, this.iwn);
        if (this.iww) {
            if (bl && !this.iwx) {
                this.ixl();
            }
        } else if (!bl) {
            if (this.iwt >= 0) {
                this.ixj(this.iwt);
            } else if (System.nanoTime() - this.iwo < 240000000L) {
                this.iww = true;
            } else {
                this.ixl();
            }
        }
        this.iwx = bl;
    }

    private void ixj(int n) {
        if (this.iwy || n < 0 || n >= this.iws.size()) {
            return;
        }
        if (this.iwm.editable() && this.iws.get(n).icon().isEmpty()) {
            this.ixk(n);
            return;
        }
        this.iwm.pick(n);
        this.ixl();
    }

    private void ixk(int n) {
        this.iwu = n;
        this.iwv = n;
        this.iww = true;
        this.iwx = true;
    }

    private void ixl() {
        if (this.iwy) {
            return;
        }
        this.iwy = true;
        if (this.client != null) {
            this.client.send(() -> {
                if (this.client.currentScreen == this) {
                    this.client.setScreen(null);
                }
            });
        }
    }

    public boolean mouseClicked(Click click, boolean doubled) {
        int n;
        if (this.iwy) {
            return true;
        }
        if (this.iwu >= 0) {
            this.ixt((float)click.x(), (float)click.y(), click.button());
            return true;
        }
        int n2 = n = this.iws.isEmpty() ? -1 : iwf.ixg((float)click.x() - (float)this.width * 0.5f, (float)click.y() - (float)this.height * 0.5f, this.iws.size());
        if (n < 0) {
            return true;
        }
        if (click.button() == 1 && this.iwm.editable()) {
            this.ixk(n);
        } else if (!(click.button() != 0 || vzz.isMouse(this.iwn) && vzz.mouseButton(this.iwn) == 0)) {
            this.ixj(n);
        }
        return true;
    }

    public boolean keyPressed(KeyInput input) {
        int n = input.key();
        if (n == 256) {
            if (this.iwu >= 0) {
                this.iwu = -1;
            } else {
                this.ixl();
            }
        } else if (this.iwu < 0 && n >= 49 && n <= 57 && n != vzz.baseKey(this.iwn)) {
            this.ixj(n - 49);
        }
        return true;
    }

    private static int ixm(int n) {
        return n < 27 ? 9 + n : (n < 36 ? n - 27 : 40);
    }

    private float ixn() {
        return 189.0f;
    }

    private float ixo() {
        return 130.0f;
    }

    private float ixp(int n) {
        return (float)this.width * 0.5f - this.ixn() * 0.5f + 9.0f + (float)(n < 36 ? n % 9 : 0) * 19.0f;
    }

    private float ixq(int n) {
        float f = (float)this.height * 0.5f - this.ixo() * 0.5f + 17.0f;
        return n < 27 ? f + (float)(n / 9) * 19.0f : (n < 36 ? f + 57.0f + 4.0f : f + 76.0f + 9.0f);
    }

    private void ixr(DrawContext drawContext, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6 = this.ixn();
        float f7 = this.ixo();
        float f8 = (float)this.width * 0.5f - f6 * 0.5f;
        float f9 = (float)this.height * 0.5f - f7 * 0.5f + (1.0f - f3) * 5.0f;
        float f10 = iov.r(8.0f);
        uut.shadow(drawContext, f8, f9 + 3.0f, f6, f7, f10, 14.0f, iov.shadow);
        uut.round(drawContext, f8, f9, f6, f7, f10, ujt.withAlpha(iov.window, 255));
        uut.outline(drawContext, f8, f9, f6, f7, f10, 1.0f, iov.stroke);
        irr.VALUE.draw(drawContext, wap.s(a.b("\u376e\u4ee9\uc438\u5a43\ud19c\u5726\ued6f\u64ca", -699320523), a.b("\uffcd\u8614\u0cb5\u92c8\u191c\u9fa7\u21e4", 196148197)) + (this.iwv + 1) + wap.s(a.b("\u2103\u58a8\ud22b\u4c43\uc79e\u4127\ufb3f\u728f\uecdf\u6620\ue1ba\u1bd6\u9510\u0ca9", 2117804343), a.b("\u3697\u4f3c\uc1fd\u5ff5\ud458\u52ed\ue8cb\u6142\uff67\u75a1\uf667\u0809\u86a1\u1f65\u9537\u13ce\ua988\u262e", -689621313)), f8 + 9.0f, irr.VALUE.centerTop(f9 + 9.5f), iov.text);
        PlayerInventory playerInventory = this.client != null && this.client.player != null ? this.client.player.getInventory() : null;
        float f11 = iov.r(3.5f);
        for (int i = 0; i < 37; ++i) {
            f5 = this.ixp(i);
            f4 = this.ixq(i) + (1.0f - f3) * 5.0f;
            ItemStack itemStack = playerInventory == null ? ItemStack.EMPTY : playerInventory.getStack(iwf.ixm(i));
            boolean bl = !itemStack.isEmpty() && irr.inside(f, f2, f5, f4, 17.5f, 17.5f);
            uut.round(drawContext, f5, f4, 17.5f, 17.5f, f11, bl ? iov.fieldHover : iov.field);
            if (bl) {
                uut.outline(drawContext, f5, f4, 17.5f, 17.5f, f11, 1.0f, iov.accent());
            }
            if (itemStack.isEmpty() || !(f3 > 0.5f)) continue;
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate(f5 + 8.75f, f4 + 8.75f);
            drawContext.drawItem(itemStack, -8, -8);
            drawContext.getMatrices().popMatrix();
        }
        float f12 = this.ixq(36) + (1.0f - f3) * 5.0f + 8.75f;
        irr.SMALL.draw(drawContext, wap.s(a.d("\ud040\ua9f8\u232b\ubd54\u368a\ub034\u0a6d", -1775130896, -1335134504), a.c(-1056576496, "\ue829\u91e8\u1b47\u8548\u0eef\u8821\u361d\ubb8c\u25d0\uaf18\u28c1")), this.ixp(36) + 19.0f + 3.0f, irr.SMALL.centerTop(f12), iov.textMuted);
        f5 = this.ixs();
        f4 = f8 + f6 - 9.0f - f5;
        boolean bl = irr.inside(f, f2, f4, f12 - 7.0f, f5, 14.0f);
        uut.round(drawContext, f4, f12 - 7.0f, f5, 14.0f, iov.r(4.0f), bl ? iov.fieldHover : iov.field);
        irr.VALUE.drawCentered(drawContext, wap.s(a.b("\u2135\u58ab\ud271\u4c04\uc7c0", 986980723), a.c(1785362391, "\u73c1\u0a29\u8085\u1e8d\u9559\u1392\ua9bb\u2044")), f4 + f5 * 0.5f, irr.VALUE.centerTop(f12), bl ? iov.text : iov.textDim);
    }

    private float ixs() {
        return irr.VALUE.width(wap.s(a.c(-671545764, "\u061a\u7f84\uf55e\u6b2b\ue0ef"), a.c(2096318454, "\u43e0\u3a08\ub0a4\u2eac\ua578\u23b3\u999a\u1065"))) + 14.0f;
    }

    private void ixt(float f, float f2, int n) {
        float f3 = this.ixn();
        float f4 = this.ixo();
        float f5 = (float)this.width * 0.5f - f3 * 0.5f;
        float f6 = (float)this.height * 0.5f - f4 * 0.5f;
        if (n != 0 || !irr.inside(f, f2, f5, f6, f3, f4)) {
            this.iwu = -1;
            return;
        }
        float f7 = this.ixq(36) + 8.75f;
        float f8 = this.ixs();
        if (irr.inside(f, f2, f5 + f3 - 9.0f - f8, f7 - 7.0f, f8, 14.0f)) {
            this.iwm.assign(this.iwu, ItemStack.EMPTY);
            this.iwu = -1;
            return;
        }
        if (this.client == null || this.client.player == null) {
            return;
        }
        PlayerInventory playerInventory = this.client.player.getInventory();
        for (int i = 0; i < 37; ++i) {
            ItemStack itemStack = playerInventory.getStack(iwf.ixm(i));
            if (itemStack.isEmpty() || !irr.inside(f, f2, this.ixp(i), this.ixq(i), 17.5f, 17.5f)) continue;
            this.iwm.assign(this.iwu, itemStack);
            this.iwu = -1;
            return;
        }
    }

    public boolean shouldPause() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    private static /* synthetic */ int aku(int n, int n2) {
        return n - n2 + 1167315235;
    }
}

