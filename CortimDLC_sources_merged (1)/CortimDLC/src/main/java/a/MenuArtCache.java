/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.AssetPaths;
import a.jza;
import a.WallpaperEntry;
import a.FrameDelta;
import a.GpuTexture;
import a.whl;
import flow.dev.StringDecryptor;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;

public final class MenuArtCache {
    private static final int jzi = 1920;
    private static final int jzj = 2560;
    private static final int jzk = 320;
    private static final ExecutorService jzl = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Flow2 menu art");
        thread.setDaemon(true);
        return thread;
    });
    private static final ExecutorService jzm = Executors.newFixedThreadPool(3, runnable -> {
        Thread thread = new Thread(runnable, "Flow2 menu thumbs");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    });
    private static final Map<String, CompletableFuture<BufferedImage[]>> jzn = new HashMap<String, CompletableFuture<BufferedImage[]>>();
    private static final Map<String, jza> jzo = new HashMap<String, jza>();
    private static final List<GpuTexture> jzp = new ArrayList<GpuTexture>();
    private static final List<Long> jzq = new ArrayList<Long>();
    private static final List<String> jzr = new ArrayList<String>();
    private static final Map<String, CompletableFuture<BufferedImage>> jzs = new HashMap<String, CompletableFuture<BufferedImage>>();
    private static final Map<String, GpuTexture> jzt = new HashMap<String, GpuTexture>();
    private static /* synthetic */ long jzu;
    private static /* synthetic */ boolean jzv;

    private MenuArtCache() {
    }

    public static synchronized void preload(String string) {
        if (!(jzo.containsKey(string) || jzn.containsKey(string) || jzr.contains(string))) {
            jzn.put(string, CompletableFuture.supplyAsync(() -> MenuArtCache.jzz(string), jzl));
        }
    }

    public static synchronized boolean decoded(String string) {
        CompletableFuture<BufferedImage[]> completableFuture = jzn.get(string);
        return jzo.containsKey(string) || jzr.contains(string) || completableFuture != null && completableFuture.isDone();
    }

    public static synchronized jza get(String string) {
        MenuArtCache.jzy();
        jza jza2 = jzo.get(string);
        if (jza2 != null) {
            return MenuArtCache.jzw(string, jza2);
        }
        MenuArtCache.preload(string);
        CompletableFuture<BufferedImage[]> completableFuture = jzn.get(string);
        if (completableFuture == null || !completableFuture.isDone()) {
            return null;
        }
        jzn.remove(string);
        BufferedImage[] bufferedImageArray = completableFuture.getNow(null);
        if (bufferedImageArray == null) {
            jzr.add(string);
            return null;
        }
        try {
            jza2 = new jza(GpuTexture.upload("menu " + string, bufferedImageArray[0], false), GpuTexture.upload("menu blur " + string, bufferedImageArray[1], false));
        }
        catch (Throwable throwable) {
            jzr.add(string);
            System.out.println("menu picture " + string + " can't be uploaded: " + throwable);
            return null;
        }
        jzo.put(string, jza2);
        return MenuArtCache.jzw(string, jza2);
    }

    private static jza jzw(String string, jza jza2) {
        int n;
        WallpaperEntry kbs2 = WallpaperEntry.byKey(string);
        int n2 = n = kbs2 != null ? kbs2.fill : -1;
        if (!whl.is(string)) {
            return n >= 0 ? new jza(jza2.sharp(), jza2.blur(), false, n) : jza2;
        }
        GpuTexture uok2 = whl.get(string.substring("video:".length())).frame();
        return new jza(uok2 != null ? uok2 : jza2.sharp(), jza2.blur(), uok2 != null, n);
    }

    public static synchronized GpuTexture thumb(String string2) {
        GpuTexture uok2 = jzt.get(string2);
        if (uok2 != null || jzr.contains(string2)) {
            return uok2;
        }
        CompletableFuture completableFuture = jzs.computeIfAbsent(string2, string -> CompletableFuture.supplyAsync(() -> {
            try {
                BufferedImage bufferedImage = MenuArtCache.kab(string, 320);
                return bufferedImage == null ? null : MenuArtCache.kad(bufferedImage, 320, Math.round(320.0f * (float)bufferedImage.getHeight() / (float)bufferedImage.getWidth()));
            }
            catch (Throwable throwable) {
                return null;
            }
        }, jzm));
        if (!completableFuture.isDone()) {
            return null;
        }
        jzs.remove(string2);
        BufferedImage bufferedImage = completableFuture.getNow(null);
        if (bufferedImage == null) {
            jzr.add(string2);
            return null;
        }
        uok2 = GpuTexture.upload("menu thumb " + string2, bufferedImage, false);
        jzt.put(string2, uok2);
        return uok2;
    }

    public static synchronized boolean warm(String string) {
        return MenuArtCache.get(string) != null || jzr.contains(string);
    }

    public static synchronized boolean warmThumb(String string) {
        return MenuArtCache.thumb(string) != null || jzr.contains(string);
    }

    public static synchronized void releaseExcept(String ... stringArray) {
        jzn.keySet().removeIf(string -> !Arrays.asList(stringArray).contains(string));
        Iterator<Map.Entry<String, jza>> iterator = jzo.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, jza> entry = iterator.next();
            boolean bl = false;
            for (String string2 : stringArray) {
                bl |= entry.getKey().equals(string2);
            }
            if (bl) continue;
            MenuArtCache.jzx(entry.getValue().sharp());
            MenuArtCache.jzx(entry.getValue().blur());
            iterator.remove();
        }
    }

    private static void jzx(GpuTexture uok2) {
        jzp.add(uok2);
        jzq.add(FrameDelta.frame());
    }

    private static void jzy() {
        long l = FrameDelta.frame();
        for (int i = jzp.size() - 1; i >= 0; --i) {
            if (l - jzq.get(i) <= 3L) continue;
            jzp.remove(i).close();
            jzq.remove(i);
        }
    }

    private static BufferedImage[] jzz(String string) {
        try {
            BufferedImage bufferedImage = MenuArtCache.kaa(string);
            if (bufferedImage == null) {
                System.out.println("menu picture " + string + " is missing");
                return null;
            }
            int n = Math.max(1920, Math.min(2560, bufferedImage.getWidth()));
            int n2 = Math.round((float)(n * bufferedImage.getHeight()) / (float)bufferedImage.getWidth());
            BufferedImage bufferedImage2 = (float)bufferedImage.getWidth() * 1.3f < (float)n ? MenuArtCache.kae(bufferedImage, n, n2) : MenuArtCache.kad(bufferedImage, n, n2);
            int n3 = 320;
            int n4 = Math.max(8, Math.round((float)(n3 * n2) / (float)n));
            BufferedImage bufferedImage3 = MenuArtCache.kak(MenuArtCache.kad(bufferedImage2, n3, n4), 3.2f);
            return new BufferedImage[]{bufferedImage2, bufferedImage3};
        }
        catch (Throwable throwable) {
            System.out.println("menu picture " + string + " can't be read: " + throwable);
            return null;
        }
    }

    private static BufferedImage kaa(String string) throws Exception {
        try (InputStream inputStream = MenuArtCache.kac(string);){
            BufferedImage bufferedImage = inputStream == null ? null : ImageIO.read(inputStream);
            return bufferedImage;
        }
    }

    /*
     * Exception decompiling
     */
    private static BufferedImage kab(String var0, int var1_1) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 20[SIMPLE_IF_TAKEN]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static InputStream kac(String string) throws Exception {
        String string2 = WallpaperEntry.resource(string);
        try {
            return AssetPaths.open(string2.substring(0, string2.length() - 4) + ".png");
        }
        catch (Exception exception) {
            return AssetPaths.open(string2);
        }
    }

    private static BufferedImage kad(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = bufferedImage;
        int n3 = bufferedImage2.getWidth();
        int n4 = bufferedImage2.getHeight();
        while (n3 / 2 >= n && n4 / 2 >= n2) {
            bufferedImage2 = MenuArtCache.kaj(bufferedImage2, n3 /= 2, n4 /= 2);
        }
        return n3 == n && n4 == n2 && bufferedImage2.getType() == 1 ? bufferedImage2 : MenuArtCache.kaj(bufferedImage2, n, n2);
    }

    private static BufferedImage kae(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = MenuArtCache.kag(MenuArtCache.kaf(bufferedImage));
        int n3 = bufferedImage2.getWidth();
        int n4 = bufferedImage2.getHeight();
        while ((float)n3 * 1.5f < (float)n) {
            n3 = Math.round((float)n3 * 1.5f);
            n4 = Math.round((float)n4 * 1.5f);
            bufferedImage2 = MenuArtCache.kaj(bufferedImage2, n3, n4);
        }
        bufferedImage2 = MenuArtCache.kaj(bufferedImage2, n, n2);
        return MenuArtCache.kah(bufferedImage2, 1.4f, 0.75f, 2.5f);
    }

    private static BufferedImage kaf(BufferedImage bufferedImage) {
        return bufferedImage.getType() == 1 ? bufferedImage : MenuArtCache.kaj(bufferedImage, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    private static BufferedImage kag(BufferedImage bufferedImage) {
        int n;
        int n2;
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n3, n4, null, 0, n3);
        int[] nArray2 = new int[nArray.length];
        float f = 14.0f;
        float[] fArray = new float[25];
        for (n2 = -2; n2 <= 2; ++n2) {
            for (n = -2; n <= 2; ++n) {
                fArray[(n2 + 2) * 5 + n + 2] = (float)Math.exp((float)(-(n * n + n2 * n2)) / 2.42f);
            }
        }
        for (n2 = 0; n2 < n4; ++n2) {
            for (n = 0; n < n3; ++n) {
                int n5 = nArray[n2 * n3 + n];
                int n6 = n5 >> 16 & 0xFF;
                int n7 = n5 >> 8 & 0xFF;
                int n8 = n5 & 0xFF;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                for (int i = -2; i <= 2; ++i) {
                    int n9 = Math.min(n4 - 1, Math.max(0, n2 + i));
                    for (int j = -2; j <= 2; ++j) {
                        int n10 = nArray[n9 * n3 + Math.min(n3 - 1, Math.max(0, n + j))];
                        int n11 = n10 >> 16 & 0xFF;
                        int n12 = n10 >> 8 & 0xFF;
                        int n13 = n10 & 0xFF;
                        float f6 = (float)((n11 - n6) * (n11 - n6) + (n12 - n7) * (n12 - n7) + (n13 - n8) * (n13 - n8)) / 3.0f;
                        float f7 = fArray[(i + 2) * 5 + j + 2] * (float)Math.exp(-f6 / (2.0f * f * f));
                        f2 += (float)n11 * f7;
                        f3 += (float)n12 * f7;
                        f4 += (float)n13 * f7;
                        f5 += f7;
                    }
                }
                nArray2[n2 * n3 + n] = 0xFF000000 | MenuArtCache.kal(f2 / f5) << 16 | MenuArtCache.kal(f3 / f5) << 8 | MenuArtCache.kal(f4 / f5);
            }
        }
        BufferedImage bufferedImage2 = new BufferedImage(n3, n4, 1);
        bufferedImage2.setRGB(0, 0, n3, n4, nArray2, 0, n3);
        return bufferedImage2;
    }

    private static BufferedImage kah(BufferedImage bufferedImage, float f, float f2, float f3) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n, n2, null, 0, n);
        int[] nArray2 = MenuArtCache.kak(bufferedImage, f).getRGB(0, 0, n, n2, null, 0, n);
        for (int i = 0; i < nArray.length; ++i) {
            int n3 = nArray[i];
            int n4 = nArray2[i];
            int n5 = MenuArtCache.kai(n3 >> 16 & 0xFF, n4 >> 16 & 0xFF, f2, f3);
            int n6 = MenuArtCache.kai(n3 >> 8 & 0xFF, n4 >> 8 & 0xFF, f2, f3);
            int n7 = MenuArtCache.kai(n3 & 0xFF, n4 & 0xFF, f2, f3);
            nArray[i] = 0xFF000000 | n5 << 16 | n6 << 8 | n7;
        }
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 1);
        bufferedImage2.setRGB(0, 0, n, n2, nArray, 0, n);
        return bufferedImage2;
    }

    private static int kai(int n, int n2, float f, float f2) {
        float f3 = n - n2;
        float f4 = Math.min(1.0f, Math.max(0.0f, (Math.abs(f3) - f2) / f2));
        return MenuArtCache.kal((float)n + f3 * f * f4);
    }

    private static BufferedImage kaj(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = new BufferedImage(Math.max(1, n), Math.max(1, n2), 1);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.drawImage(bufferedImage, 0, 0, bufferedImage2.getWidth(), bufferedImage2.getHeight(), null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    private static BufferedImage kak(BufferedImage bufferedImage, float f) {
        int n;
        int n2 = bufferedImage.getWidth();
        int n3 = bufferedImage.getHeight();
        int n4 = Math.max(1, (int)Math.ceil(f * 2.8f));
        float[] fArray = new float[n4 * 2 + 1];
        float f2 = 0.0f;
        for (n = -n4; n <= n4; ++n) {
            fArray[n + n4] = (float)Math.exp((float)(-(n * n)) / (2.0f * f * f));
            f2 += fArray[n + n4];
        }
        n = 0;
        while (n < fArray.length) {
            int n5 = n++;
            fArray[n5] = fArray[n5] / f2;
        }
        int[] nArray = bufferedImage.getRGB(0, 0, n2, n3, null, 0, n2);
        float[][] fArray2 = new float[3][n2 * n3];
        for (int i = 0; i < nArray.length; ++i) {
            fArray2[0][i] = nArray[i] >> 16 & 0xFF;
            fArray2[1][i] = nArray[i] >> 8 & 0xFF;
            fArray2[2][i] = nArray[i] & 0xFF;
        }
        float[] fArray3 = new float[n2 * n3];
        for (float[] fArray4 : fArray2) {
            int n6;
            float f3;
            int n7;
            int n8;
            for (n8 = 0; n8 < n3; ++n8) {
                for (n7 = 0; n7 < n2; ++n7) {
                    f3 = 0.0f;
                    for (n6 = -n4; n6 <= n4; ++n6) {
                        f3 += fArray4[n8 * n2 + Math.min(n2 - 1, Math.max(0, n7 + n6))] * fArray[n6 + n4];
                    }
                    fArray3[n8 * n2 + n7] = f3;
                }
            }
            for (n8 = 0; n8 < n2; ++n8) {
                for (n7 = 0; n7 < n3; ++n7) {
                    f3 = 0.0f;
                    for (n6 = -n4; n6 <= n4; ++n6) {
                        f3 += fArray3[Math.min(n3 - 1, Math.max(0, n7 + n6)) * n2 + n8] * fArray[n6 + n4];
                    }
                    fArray4[n7 * n2 + n8] = f3;
                }
            }
        }
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = 0xFF000000 | MenuArtCache.kal(fArray2[0][i]) << 16 | MenuArtCache.kal(fArray2[1][i]) << 8 | MenuArtCache.kal(fArray2[2][i]);
        }
        BufferedImage bufferedImage2 = new BufferedImage(n2, n3, 1);
        bufferedImage2.setRGB(0, 0, n2, n3, nArray, 0, n2);
        return bufferedImage2;
    }

    private static int kal(float f) {
        return Math.max(0, Math.min(255, Math.round(f)));
    }

    private static /* synthetic */ int aqy(int n, int n2) {
        return n * n2 + 2010627583;
    }

    private static /* synthetic */ int aqz(int n, int n2) {
        return n * n2 + -1665707433;
    }

    private static /* synthetic */ int ara(int n, int n2) {
        return MenuArtCache.aqy(n, n2) * n2;
    }
}

