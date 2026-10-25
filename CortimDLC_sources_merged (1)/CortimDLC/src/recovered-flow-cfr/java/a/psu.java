/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 */
package a;

import a.dry;
import a.hlc;
import a.iov;
import a.pnf;
import a.psf;
import a.tvt;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public final class psu {
    private static final float[] psv = new float[4];
    private static final float[] psw = new float[2];
    private static final double psx = 0.05;
    private static final double psy = 0.85;
    private static final double psz = 56.0;
    private static long pta = -1L;
    private static /* synthetic */ long ptb;
    private static /* synthetic */ String ptc;

    private psu() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null || minecraftClient.player == null || minecraftClient.options.hudHidden || dry.armed() || minecraftClient.currentScreen instanceof hlc || !pnf.visible()) {
            return;
        }
        psf psf2 = pnf.route();
        if (psf2 == null || psf2.track.n < 2) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == pta) {
            return;
        }
        pta = unf.frame();
        try {
            usn2 = usn.capture(renderTickCounter.getTickProgress(true), drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
        }
        catch (Throwable throwable) {
            return;
        }
        iov.update(unf.delta() * (float)iov.ANIMATION.get());
        boolean bl = pnf.guiding();
        int n = iov.accent();
        int n2 = ujt.lerp(n, -1, bl ? 0.25f : 0.1f);
        float f = bl ? 1.0f : 0.6f;
        tvt tvt2 = psf2.track;
        double d = bl ? 0.85 : 0.05;
        int n3 = Math.max(0, Math.min(tvt2.n - 2, pnf.at()));
        double d2 = tvt2.s[n3];
        uut.beginFrame();
        uut.beginBatch();
        try {
            double d3;
            int n4 = n3;
            while (n4 + 1 < tvt2.n && !((d3 = (double)tvt2.s[n4] - d2) > 56.0)) {
                float f2;
                double d4 = tvt2.x[n4];
                double d5 = (double)tvt2.y[n4] + d;
                double d6 = tvt2.z[n4];
                double d7 = tvt2.x[n4 + 1];
                double d8 = (double)tvt2.y[n4 + 1] + d;
                double d9 = tvt2.z[n4 + 1];
                if (usn2.projectSegment(d4, d5, d6, d7, d8, d9, 0.15f, psv, psw) && !((f2 = (float)Math.min(1.0, Math.min((d3 + 0.2) / 1.2, (56.0 - d3) / 12.0))) <= 0.01f)) {
                    float f3 = usn2.unitsPerBlock(d7, d8, d9);
                    float f4 = Math.max(1.0f, Math.min(2.6f, f3 * 0.035f));
                    uut.line(drawContext, psv[0], psv[1], psv[2], psv[3], f4 * 3.2f, ujt.withAlpha(n, Math.round(46.0f * f2 * f)));
                    uut.line(drawContext, psv[0], psv[1], psv[2], psv[3], f4, ujt.withAlpha(n2, Math.round(225.0f * f2 * f)));
                    if ((tvt2.flag[n4 + 1] & 3) != 0 && (tvt2.flag[n4] & 3) == 0) {
                        psu.ptd(drawContext, usn2, d7, d8, d9, 0.22, ujt.withAlpha(-678620, Math.round(220.0f * f2 * f)), f4);
                    }
                }
                ++n4;
            }
            n4 = tvt2.n - 1;
            if ((double)tvt2.s[n4] - d2 <= 56.0 && bl && usn2.projectSegment(tvt2.x[n4], (double)tvt2.y[n4] + 0.05, tvt2.z[n4], tvt2.x[n4], (double)tvt2.y[n4] + d, tvt2.z[n4], 0.15f, psv, psw)) {
                uut.line(drawContext, psv[0], psv[1], psv[2], psv[3], 1.4f, ujt.withAlpha(n2, 200));
            }
            if ((double)tvt2.s[n4] - d2 <= 56.0) {
                psu.ptd(drawContext, usn2, tvt2.x[n4], (double)tvt2.y[n4] + 0.05, tvt2.z[n4], 0.42, ujt.withAlpha(n2, Math.round(230.0f * f)), 1.6f);
                psu.ptd(drawContext, usn2, tvt2.x[n4], (double)tvt2.y[n4] + 0.05, tvt2.z[n4], 0.16, ujt.withAlpha(n, Math.round(200.0f * f)), 1.2f);
            }
        }
        finally {
            uut.endBatch();
        }
    }

    private static void ptd(DrawContext drawContext, usn usn2, double d, double d2, double d3, double d4, int n, float f) {
        int n2 = 28;
        double d5 = d + d4;
        double d6 = d3;
        for (int i = 1; i <= n2; ++i) {
            double d7;
            double d8 = Math.PI * 2 * (double)i / (double)n2;
            double d9 = d + Math.cos(d8) * d4;
            if (usn2.projectSegment(d5, d2, d6, d9, d2, d7 = d3 + Math.sin(d8) * d4, 0.1f, psv, psw)) {
                float f2 = usn2.unitsPerBlock(d9, d2, d7);
                float f3 = Math.max(1.0f, Math.min(2.4f, f2 * 0.03f)) * f;
                uut.line(drawContext, psv[0], psv[1], psv[2], psv[3], f3, n);
            }
            d5 = d9;
            d6 = d7;
        }
    }

    private static /* synthetic */ int boc(int n, int n2) {
        return n - n2 ^ 0x1A34CC68;
    }

    private static /* synthetic */ int bod(int n, int n2) {
        return n + n2 | 0xB1125964;
    }
}

