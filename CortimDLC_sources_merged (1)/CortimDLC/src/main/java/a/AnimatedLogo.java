/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.ColorUtil;
import a.FrameDelta;
import a.GpuTexture;
import a.LogoRenderer;
import a.DrawUtil;
import a.FontFace;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import net.minecraft.class_310;
import net.minecraft.class_332;

public final class AnimatedLogo {
    private static final int uqf = 60;
    private static final int uqg = 10;
    private static final int uqh = 128;
    private static final float uqi = 10.0f;
    private static final int uqj = 4;
    private static final ExecutorService uqk = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Flow2 logo frames");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    });
    private static final BufferedImage[] uql = new BufferedImage[2];
    private static final GpuTexture[] uqm = new GpuTexture[2];
    private static final Map<Integer, GpuTexture> uqn = new LinkedHashMap<Integer, GpuTexture>();
    private static final Map<Integer, CompletableFuture<BufferedImage>> uqo = new LinkedHashMap<Integer, CompletableFuture<BufferedImage>>();
    private static final Map<GpuTexture, Long> uqp = new LinkedHashMap<GpuTexture, Long>();
    private static boolean uqq;
    private static final long uqr;
    private static /* synthetic */ String uqs;
    private static /* synthetic */ boolean uqt;

    private AnimatedLogo() {
    }

    public static boolean draw(class_332 class_3322, float f, float f2, float f3, boolean bl, int n) {
        if (uqq) {
            return false;
        }
        AnimatedLogo.uqy();
        int n2 = bl ? 1 : 0;
        class_310 class_3102 = class_310.method_1551();
        float f4 = class_3102.method_22683() != null ? (float)Math.max(1, class_3102.method_22683().method_4495()) : 2.0f;
        int n3 = Math.max(8, Math.min(128, Math.round(f3 * f4 * FontFace.renderScale())));
        GpuTexture uok2 = AnimatedLogo.uqx(n2, n3);
        int n4 = n3;
        if (uok2 == null) {
            uok2 = AnimatedLogo.uqw(n2);
            n4 = 128;
        }
        if (uok2 == null) {
            return false;
        }
        float f5 = (float)(System.nanoTime() - uqr) / 1.0E9f * 10.0f;
        int n5 = (int)f5 % 60;
        float f6 = f5 - (float)((int)f5);
        AnimatedLogo.uqu(class_3322, uok2, n4, n5, f, f2, f3, n);
        if (f6 > 0.02f) {
            AnimatedLogo.uqu(class_3322, uok2, n4, (n5 + 1) % 60, f, f2, f3, ColorUtil.mulAlpha(n, f6));
        }
        return true;
    }

    private static void uqu(class_332 class_3322, GpuTexture uok2, int n, int n2, float f, float f2, float f3, int n3) {
        int n4 = n2 % 10;
        int n5 = n2 / 10;
        float f4 = ((float)(n4 * n) + 0.5f) / (float)uok2.width;
        float f5 = ((float)(n5 * n) + 0.5f) / (float)uok2.height;
        float f6 = ((float)((n4 + 1) * n) - 0.5f) / (float)uok2.width;
        float f7 = ((float)((n5 + 1) * n) - 0.5f) / (float)uok2.height;
        DrawUtil.imageRegion(class_3322, uok2.view, f, f2, f3, f3, 0.0f, f4, f5, f6, f7, n3, false);
    }

    private static BufferedImage uqv(int n) {
        if (uql[n] == null) {
            String string = n == 1 ? "/flow/logo_anim_ink.png" : "/flow/logo_anim_silver.png";
            try (InputStream inputStream = AnimatedLogo.class.getResourceAsStream(string);){
                if (inputStream == null) {
                    throw new IllegalStateException("missing " + string);
                }
                AnimatedLogo.uql[n] = ImageIO.read(inputStream);
            }
            catch (Exception exception) {
                uqq = true;
                System.out.println("animated logo unavailable: " + exception);
                return null;
            }
        }
        return uql[n];
    }

    private static GpuTexture uqw(int n) {
        if (uqm[n] == null) {
            BufferedImage bufferedImage = AnimatedLogo.uqv(n);
            if (bufferedImage == null) {
                return null;
            }
            AnimatedLogo.uqm[n] = GpuTexture.upload("logo frames " + n, bufferedImage, false, true);
        }
        return uqm[n];
    }

    private static GpuTexture uqx(int n, int n2) {
        int n3 = n * 1000 + n2;
        GpuTexture uok2 = uqn.get(n3);
        if (uok2 != null) {
            return uok2;
        }
        CompletableFuture<BufferedImage> completableFuture = uqo.get(n3);
        if (completableFuture == null) {
            BufferedImage bufferedImage = AnimatedLogo.uqv(n);
            if (bufferedImage == null) {
                return null;
            }
            uqo.put(n3, CompletableFuture.supplyAsync(() -> AnimatedLogo.urb(bufferedImage, n2), uqk));
            return null;
        }
        if (!completableFuture.isDone()) {
            return null;
        }
        uqo.remove(n3);
        BufferedImage bufferedImage = completableFuture.getNow(null);
        if (bufferedImage == null) {
            return null;
        }
        uok2 = GpuTexture.upload("logo frames " + n3, bufferedImage, false, true);
        uqn.put(n3, uok2);
        while (uqn.size() > 4) {
            Iterator<Map.Entry<Integer, GpuTexture>> iterator = uqn.entrySet().iterator();
            GpuTexture uok3 = iterator.next().getValue();
            iterator.remove();
            uqp.put(uok3, FrameDelta.frame());
        }
        return uok2;
    }

    private static void uqy() {
        long l = FrameDelta.frame();
        uqp.entrySet().removeIf(entry -> {
            if (l - (Long)entry.getValue() > 3L) {
                ((GpuTexture)entry.getKey()).close();
                return true;
            }
            return false;
        });
    }

    private static void uqz(BufferedImage bufferedImage, float f) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n, n2, null, 0, n);
        int[] nArray2 = (int[])nArray.clone();
        for (int i = 1; i < n2 - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int n3;
                int n4;
                int n5;
                int n6 = nArray[i * n + j];
                if (n6 >>> 24 < 160) continue;
                int n7 = 0;
                int n8 = 0;
                int n9 = 0;
                int n10 = 0;
                for (n5 = -1; n5 <= 1; ++n5) {
                    for (n4 = -1; n4 <= 1; ++n4) {
                        n3 = nArray[(i + n5) * n + j + n4];
                        if (n3 >>> 24 < 160) continue;
                        n7 += n3 >> 16 & 0xFF;
                        n8 += n3 >> 8 & 0xFF;
                        n9 += n3 & 0xFF;
                        ++n10;
                    }
                }
                n5 = n6 >> 16 & 0xFF;
                n4 = n6 >> 8 & 0xFF;
                n3 = n6 & 0xFF;
                n5 = AnimatedLogo.ura(Math.round((float)n5 + f * ((float)n5 - (float)n7 / (float)n10)));
                n4 = AnimatedLogo.ura(Math.round((float)n4 + f * ((float)n4 - (float)n8 / (float)n10)));
                n3 = AnimatedLogo.ura(Math.round((float)n3 + f * ((float)n3 - (float)n9 / (float)n10)));
                nArray2[i * n + j] = n6 & 0xFF000000 | n5 << 16 | n4 << 8 | n3;
            }
        }
        bufferedImage.setRGB(0, 0, n, n2, nArray2, 0, n);
    }

    private static int ura(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private static BufferedImage urb(BufferedImage bufferedImage, int n) {
        try {
            int n2 = 6;
            BufferedImage bufferedImage2 = new BufferedImage(10 * n, n2 * n, 2);
            for (int i = 0; i < 60; ++i) {
                Image image;
                int n3 = i % 10;
                int n4 = i / 10;
                BufferedImage bufferedImage3 = new BufferedImage(128, 128, 3);
                Graphics2D graphics2D = bufferedImage3.createGraphics();
                graphics2D.drawImage((Image)bufferedImage.getSubimage(n3 * 128, n4 * 128, 128, 128), 0, 0, null);
                graphics2D.dispose();
                BufferedImage bufferedImage4 = bufferedImage3;
                while (bufferedImage4.getWidth() / 2 >= n) {
                    int n5 = bufferedImage4.getWidth() / 2;
                    image = new BufferedImage(n5, n5, 3);
                    Graphics2D graphics2D2 = image.createGraphics();
                    graphics2D2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    graphics2D2.drawImage(bufferedImage4, 0, 0, n5, n5, null);
                    graphics2D2.dispose();
                    bufferedImage4 = image;
                }
                Graphics2D graphics2D3 = bufferedImage2.createGraphics();
                if (bufferedImage4.getWidth() != n) {
                    image = bufferedImage4.getScaledInstance(n, n, 16);
                    graphics2D3.drawImage(image, n3 * n, n4 * n, null);
                } else {
                    graphics2D3.drawImage((Image)bufferedImage4, n3 * n, n4 * n, null);
                }
                graphics2D3.dispose();
            }
            if (n < 80) {
                AnimatedLogo.uqz(bufferedImage2, n < 48 ? 0.55f : 0.3f);
            }
            LogoRenderer.bleed(bufferedImage2);
            return bufferedImage2;
        }
        catch (Throwable throwable) {
            System.out.println("logo frames at " + n + " px failed: " + throwable);
            return null;
        }
    }

    static {
        uqr = System.nanoTime();
    }

    private static /* synthetic */ int czy(int n, int n2) {
        return (n ^ n2) + -1764152044;
    }
}

