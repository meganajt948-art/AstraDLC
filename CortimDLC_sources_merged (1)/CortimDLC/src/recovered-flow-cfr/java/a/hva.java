/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.iah;
import a.imn;
import a.irr;
import a.vcj;
import a.vhz;
import a.wap;
import flow.config.ConfigShare;
import flow.dev.a;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.function.IntPredicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class hva
extends imn {
    private static final float hvb = 24.0f;
    private static final float hvc = 17.0f;
    private static final float hvd = 78.0f;
    private static final IntPredicate hve = n -> Character.isLetterOrDigit(n) || n == 45 || n == 32;
    final iah field = new iah(a.b("\uf7bb\u8e25\u04f1\u9a8a\u1119\u97e9\u2dfb\ua449\u3a1a\ub0aa\u3771\ucd0f\u43d6\uda20\u5031\ud6db\u6ccd\ue35f\u79e0\uffba\u764c", -84936728), vhz.SEARCH, 20, hve);
    private final vcj hvf = new vcj(16.0f);
    private final vcj hvg = new vcj(9.0f);
    private hlc hvh;
    private boolean hvi;
    private static /* synthetic */ int hvj;
    private static /* synthetic */ boolean hvk;

    hva() {
        super(null);
        this.field.onSubmit = this::hvm;
    }

    @Override
    float height() {
        return 24.0f;
    }

    private float hvl() {
        return this.x + this.w - 78.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        this.hvh = hlc2;
        float f4 = this.y + 3.5f;
        this.field.x = this.x;
        this.field.y = f4;
        this.field.w = this.w - 78.0f - 6.0f;
        this.field.h = 17.0f;
        this.field.render(drawContext, hlc2, f, f2, f3);
        boolean bl = hlc2.canHover() && irr.inside(f, f2, this.hvl(), f4, 78.0f, 17.0f);
        float f5 = this.hvf.step(bl, f3);
        irr.secondaryButton(drawContext, this.hvi ? wap.s(a.c(-523296598, "\u20ee\u597c\ud3af\u4dda\uc60f\u40b9\ufae3\u5353"), a.b("\ua325\udac5\u506a\uce12\u61df", -1408260296)) : wap.s(a.b("\u768d\u0f13\u85c7\u1bbc", 1945335503), a.b("\u0b4a\u72d6\uf80c\u6606\uedab", -1950609582)), vhz.DOWNLOAD, this.hvl(), f4, 78.0f, 17.0f, this.hvi ? 1.0f : f5, this.hvg.step(0.0f, f3));
        if (bl || hlc2.canHover() && this.field.contains(f, f2)) {
            hlc2.hint(wap.s(a.d("\uf7aa\u8e2a\u04eb\u9a9d\u115b\u97af\u2dbd\ua40d\u3a14\ub0b1\u3779\ucd04\u43d8\uda63\u5073\ud6d6\u6cca\ue358\u79e7\uffbd\u764b\u0c45\u82ec\u1969\u9f0a\u15d6\uac69\u2223\ub886\u3e94\ub52b\u4bfb\uc1bc\u5842\ude1f\u54e9\ueb6d\u6107\ue7d3\u7e7a\uf421\u8a83\u0085\u8731\u1db6\u938e\u2a5a\ua0a5\u26b3\ubd74\u331d\uc9cb\u402e\uc633\u5cc5\ud28e\u6936", 1460751860, 1230879287), a.c(-1918236400, "\u0d34\u74d6\ufe06\u6005\uebd0\u6d1f\ud742\u5ec4\uc48e\u4a25\ucdf2\u3789\ubd4a\u20ef\uaac8\u2c3a\u9605\u19d7\u876e\u0125\u8cc7\uf690\u782e\ue7e1\u6584\uef51\u56e1\ud8c9\u4242\uc418\u4bb8\ub176\u3b38\ua2b8\u2496\uae2d\u1180\u9bf2\u1d2f\u80f1\u0ebc\u745f\ufa1e\u7dad\ue702\u690e\ud0d4\u5e79\udc57\u47f8\uc98c\u3324\ubae8\u3cb6")));
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        this.hvh = hlc2;
        if (this.field.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        float f3 = this.y + 3.5f;
        if (n == 0 && irr.inside(f, f2, this.hvl(), f3, 78.0f, 17.0f)) {
            this.hvg.set(1.0f);
            this.hvm();
            return true;
        }
        return false;
    }

    private void hvm() {
        if (this.hvi) {
            return;
        }
        if (ConfigShare.normalize(this.field.text) == null) {
            this.field.error();
            if (this.hvh != null) {
                this.hvh.toast(ConfigShare.describe(new IOException(a.c(264856768, "\u64a0\u1d18\u97d6\u09b8\u8263\u04c7"))), vhz.SEARCH, true);
            }
            return;
        }
        this.hvi = true;
        hlc hlc2 = this.hvh;
        ConfigShare.fetch(this.field.text).whenCompleteAsync((imported, throwable) -> {
            this.hvi = false;
            if (throwable != null) {
                this.field.error();
                if (hlc2 != null) {
                    hlc2.toast(ConfigShare.describe(throwable), vhz.INFO, true);
                }
                return;
            }
            this.field.setText("");
            if (hlc2 != null) {
                hlc2.focus(null);
                hlc2.toast(imported.existed() ? wap.s(a.c(-420528099, "\u4052\u39d5\ub31c\u2d38\ua6ae\u2012\u9a5f\u13b9\u8de2\u0756\u8098\u7ab0\uf42f\u6d97\ue7d3\u6131\udb3b\u54a3\uce0d\u4812\uc1ff\u9b92") + imported.name() + a.c(-1946215197, "\u3cff"), a.d("\u6047\u19e3\u9333\u0957\u8695P\uba00\u33ff\ua9cc\u271e\ua4ae\u5acd\ud418\u4dd8\uc3f0\u451b\uffdf", -362043109, 1555484014) + imported.name() + a.b("\uba0c", 1473821366)) : wap.s(a.b("\ufbe8\u827c\u08af\u96df\u1d09\u9bfc\u0193", 1966930862) + imported.name() + a.c(679319738, "\ub8a6"), a.d("\uca95\ub30e\u39d2\ua7a2\u2c77\uaacf\u1092\u996b\u0329\u8913", -500554656, 357034731) + imported.name() + a.b("\u4730", 1397901194)), vhz.DOWNLOAD, false);
            }
        }, (Executor)MinecraftClient.method_1551());
    }

    private static /* synthetic */ int acr(int n, int n2) {
        return (n ^ n2) + -1934725538;
    }

    private static /* synthetic */ int acs(int n, int n2) {
        return hva.acr(n, n2) + n;
    }

    private static /* synthetic */ int act(int n, int n2) {
        return hva.acs(n, n2) + n;
    }
}

