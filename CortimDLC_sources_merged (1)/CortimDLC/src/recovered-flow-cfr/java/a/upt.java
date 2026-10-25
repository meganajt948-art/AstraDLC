/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.unf;
import a.uok;
import a.uut;
import a.vdn;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class upt {
    private static final int upu = 3;
    private static final Map<Integer, uok> upv = new LinkedHashMap<Integer, uok>();
    private static BufferedImage upw;
    private static boolean upx;
    private static final Map<uok, Long> upy;
    private static /* synthetic */ int upz;
    private static /* synthetic */ int uqa;

    private upt() {
    }

    public static boolean draw(DrawContext drawContext, float f, float f2, float f3, int n) {
        uok uok2 = upt.uqb(f3);
        if (uok2 == null) {
            return false;
        }
        uut.image(drawContext, uok2.view, f, f2, f3, f3, 0.0f, n);
        return true;
    }

    private static uok uqb(float f) {
        Object object;
        if (upx) {
            return null;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        float f2 = minecraftClient.method_22683() != null ? (float)Math.max(1, minecraftClient.method_22683().method_4495()) : 2.0f;
        int n = Math.max(8, Math.min(512, Math.round(f * f2 * vdn.renderScale())));
        uok uok2 = upv.get(n);
        if (uok2 != null) {
            return uok2;
        }
        try {
            if (upw == null) {
                object = upt.class.getResourceAsStream("/flow/logo.png");
                try {
                    if (object == null) {
                        throw new IllegalStateException("missing /flow/logo.png");
                    }
                    upw = ImageIO.read((InputStream)object);
                }
                finally {
                    if (object != null) {
                        ((InputStream)object).close();
                    }
                }
            }
            uok2 = uok.upload("logo " + n, upt.uqd(upw, n), false, true);
        }
        catch (Throwable throwable) {
            upx = true;
            System.out.println("logo unavailable: " + throwable);
            return null;
        }
        upv.put(n, uok2);
        while (upv.size() > 3) {
            object = upv.entrySet().iterator();
            uok uok3 = (uok)((Map.Entry)object.next()).getValue();
            object.remove();
            upy.put(uok3, unf.frame());
        }
        upt.uqc();
        return uok2;
    }

    private static void uqc() {
        long l = unf.frame();
        upy.entrySet().removeIf(entry -> {
            if (l - (Long)entry.getValue() > 3L) {
                ((uok)entry.getKey()).close();
                return true;
            }
            return false;
        });
    }

    private static BufferedImage uqd(BufferedImage bufferedImage, int n) {
        Object object;
        Object object2;
        Object object3 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 3);
        Graphics2D graphics2D = ((BufferedImage)object3).createGraphics();
        graphics2D.drawImage((Image)bufferedImage, 0, 0, null);
        graphics2D.dispose();
        while (((BufferedImage)object3).getWidth() / 2 >= n) {
            int n2 = ((BufferedImage)object3).getWidth() / 2;
            object2 = new BufferedImage(n2, n2, 3);
            object = ((BufferedImage)object2).createGraphics();
            ((Graphics2D)object).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            ((Graphics)object).drawImage((Image)object3, 0, 0, n2, n2, null);
            ((Graphics)object).dispose();
            object3 = object2;
        }
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        object2 = bufferedImage2.createGraphics();
        if (((BufferedImage)object3).getWidth() != n) {
            object = ((Image)object3).getScaledInstance(n, n, 16);
            ((Graphics)object2).drawImage((Image)object, 0, 0, null);
        } else {
            ((Graphics)object2).drawImage((Image)object3, 0, 0, null);
        }
        ((Graphics)object2).dispose();
        upt.bleed(bufferedImage2);
        return bufferedImage2;
    }

    static void bleed(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n, n2, null, 0, n);
        for (int i = 0; i < 2; ++i) {
            int[] nArray2 = (int[])nArray.clone();
            for (int j = 0; j < n2; ++j) {
                for (int k = 0; k < n; ++k) {
                    int n3 = j * n + k;
                    if (nArray[n3] >>> 24 != 0) continue;
                    int n4 = 0;
                    int n5 = 0;
                    int n6 = 0;
                    int n7 = 0;
                    for (int i2 = -1; i2 <= 1; ++i2) {
                        for (int i3 = -1; i3 <= 1; ++i3) {
                            int n8;
                            int n9 = k + i3;
                            int n10 = j + i2;
                            if (n9 < 0 || n10 < 0 || n9 >= n || n10 >= n2 || (n8 = nArray[n10 * n + n9]) >>> 24 == 0 && (n8 & 0xFFFFFF) == 0) continue;
                            n4 += n8 >> 16 & 0xFF;
                            n5 += n8 >> 8 & 0xFF;
                            n6 += n8 & 0xFF;
                            ++n7;
                        }
                    }
                    if (n7 <= 0) continue;
                    nArray2[n3] = n4 / n7 << 16 | n5 / n7 << 8 | n6 / n7;
                }
            }
            nArray = nArray2;
        }
        bufferedImage.setRGB(0, 0, n, n2, nArray, 0, n);
    }

    static {
        upy = new LinkedHashMap<uok, Long>();
    }

    private static /* synthetic */ int czu(int n, int n2) {
        return n ^ n2 | 0xAE3765F3;
    }

    private static /* synthetic */ int czv(int n, int n2) {
        return upt.czu(n, n2) ^ 0x24D710FD;
    }
}

