/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.PanicShutdown;
import a.ClickGuiScreen;
import a.Theme;
import a.RouteGuide;
import a.Route;
import a.PathProjection;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class RouteRenderer {
    private static final float[] psv = new float[4];
    private static final float[] psw = new float[2];
    private static final double psx = 0.05;
    private static final double psy = 0.85;
    private static final double psz = 56.0;
    private static long pta = -1L;
    private static /* synthetic */ long ptb;
    private static /* synthetic */ String ptc;

    private RouteRenderer() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || PanicShutdown.armed() || class_3102.field_1755 instanceof ClickGuiScreen || !RouteGuide.visible()) {
            return;
        }
        Route psf2 = RouteGuide.route();
        if (psf2 == null || psf2.track.n < 2) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == pta) {
            return;
        }
        pta = FrameDelta.frame();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        Theme.update(FrameDelta.delta() * (float)Theme.ANIMATION.get());
        boolean bl = RouteGuide.guiding();
        int n = Theme.accent();
        int n2 = ColorUtil.lerp(n, -1, bl ? 0.25f : 0.1f);
        float f = bl ? 1.0f : 0.6f;
        PathProjection tvt2 = psf2.track;
        double d = bl ? 0.85 : 0.05;
        int n3 = Math.max(0, Math.min(tvt2.n - 2, RouteGuide.at()));
        double d2 = tvt2.s[n3];
        DrawUtil.beginFrame();
        DrawUtil.beginBatch();
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
                    DrawUtil.line(class_3322, psv[0], psv[1], psv[2], psv[3], f4 * 3.2f, ColorUtil.withAlpha(n, Math.round(46.0f * f2 * f)));
                    DrawUtil.line(class_3322, psv[0], psv[1], psv[2], psv[3], f4, ColorUtil.withAlpha(n2, Math.round(225.0f * f2 * f)));
                    if ((tvt2.flag[n4 + 1] & 3) != 0 && (tvt2.flag[n4] & 3) == 0) {
                        RouteRenderer.ptd(class_3322, usn2, d7, d8, d9, 0.22, ColorUtil.withAlpha(-678620, Math.round(220.0f * f2 * f)), f4);
                    }
                }
                ++n4;
            }
            n4 = tvt2.n - 1;
            if ((double)tvt2.s[n4] - d2 <= 56.0 && bl && usn2.projectSegment(tvt2.x[n4], (double)tvt2.y[n4] + 0.05, tvt2.z[n4], tvt2.x[n4], (double)tvt2.y[n4] + d, tvt2.z[n4], 0.15f, psv, psw)) {
                DrawUtil.line(class_3322, psv[0], psv[1], psv[2], psv[3], 1.4f, ColorUtil.withAlpha(n2, 200));
            }
            if ((double)tvt2.s[n4] - d2 <= 56.0) {
                RouteRenderer.ptd(class_3322, usn2, tvt2.x[n4], (double)tvt2.y[n4] + 0.05, tvt2.z[n4], 0.42, ColorUtil.withAlpha(n2, Math.round(230.0f * f)), 1.6f);
                RouteRenderer.ptd(class_3322, usn2, tvt2.x[n4], (double)tvt2.y[n4] + 0.05, tvt2.z[n4], 0.16, ColorUtil.withAlpha(n, Math.round(200.0f * f)), 1.2f);
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    private static void ptd(class_332 class_3322, ScreenProjection usn2, double d, double d2, double d3, double d4, int n, float f) {
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
                DrawUtil.line(class_3322, psv[0], psv[1], psv[2], psv[3], f3, n);
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

