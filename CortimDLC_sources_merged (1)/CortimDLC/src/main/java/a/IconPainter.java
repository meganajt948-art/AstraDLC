/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Icon;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

final class IconPainter {
    private static /* synthetic */ int viu;
    private static /* synthetic */ String viv;

    private IconPainter() {
    }

    static void paint(Graphics2D graphics2D, Icon vhz2, int n, int n2, float f, float f2, float f3) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        graphics2D.setColor(Color.WHITE);
        float f4 = f / 24.0f;
        float f5 = Math.max(f2, f3 / f4);
        AffineTransform affineTransform = graphics2D.getTransform();
        graphics2D.translate(n, n2);
        graphics2D.scale(f4, f4);
        graphics2D.setStroke(new BasicStroke(f5, 1, 1));
        for (Shape shape : vhz2.strokes()) {
            graphics2D.draw(shape);
        }
        for (Shape shape : vhz2.fills()) {
            graphics2D.fill(shape);
        }
        graphics2D.setTransform(affineTransform);
    }

    private static /* synthetic */ int dft(int n, int n2) {
        return n - n2 ^ 0x660747EC;
    }
}

