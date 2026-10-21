/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTextureView
 */
package a;

import a.AssetPaths;
import a.ClickGuiScreen;
import a.Theme;
import a.isn;
import a.isq;
import a.WallpaperEntry;
import a.FrameDelta;
import a.GpuTexture;
import a.LiveWallpaper;
import a.SkyStyle;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Lang;
import a.whl;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;

public final class WallpaperManager {
    public static final ModeSetting FIT;
    public static final NumberSetting DARKEN;
    public static final NumberSetting MOTION;
    public static final BoolSetting PARTICLES;
    public static final String WORLD;
    private static final float isw = 0.7f;
    private static final float isx = 0.95f;
    public static final String DEFAULT;
    private static final String[][] isy;
    private static final String[][] isz;
    private static final String[][] ita;
    private static final int itb = 2560;
    private static final int itc = 192;
    private static final int itd = 108;
    private static final ExecutorService ite;
    private static final ExecutorService itf;
    private static final List<isn> itg;
    private static final List<isq> ith;
    private static boolean iti;
    private static String itj;
    private static GpuTexture itk;
    private static String itl;
    private static float itm;
    private static float itn;
    private static CompletableFuture<BufferedImage> ito;
    private static String itp;
    private static volatile String itq;
    private static final BufferedImage itr;
    private static /* synthetic */ long its;
    private static /* synthetic */ long itt;

    private WallpaperManager() {
    }

    static List<isn> entries() {
        if (!iti) {
            WallpaperManager.rescan();
        }
        return itg;
    }

    static void rescan() {
        iti = true;
        ArrayList<isn> arrayList = new ArrayList<isn>(itg);
        itg.clear();
        itg.add(WallpaperManager.itu(arrayList, new isn("world", "World", null, null)));
        for (String[] stringArray : isy) {
            isn isn2 = WallpaperManager.itu(arrayList, new isn("video:" + stringArray[1], stringArray[0], whl.poster(stringArray[1]), null, null, stringArray[1]));
            isn2.fill = Integer.parseInt(stringArray[2], 16);
            itg.add(isn2);
        }
        for (SkyStyle uxt2 : SkyStyle.values()) {
            itg.add(WallpaperManager.itu(arrayList, new isn("sky:" + uxt2.title.toLowerCase(Locale.ROOT), "Live " + uxt2.title, null, null, uxt2)));
        }
        for (String[] stringArray : ita) {
            itg.add(WallpaperManager.itu(arrayList, new isn("video:" + stringArray[1], stringArray[0], whl.poster(stringArray[1]), null, null, stringArray[1])));
        }
        for (String[] stringArray : isz) {
            itg.add(WallpaperManager.itu(arrayList, new isn("builtin:" + stringArray[1], stringArray[0], "/flow/wallpapers/" + stringArray[1] + ".jpg", null)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Path path2 : WallpaperManager.itw()) {
            if (!Files.isDirectory(path2, new LinkOption[0])) continue;
            try {
                Stream<Path> stream = Files.list(path2);
                try {
                    stream.filter(WallpaperManager::itv).sorted().forEach(path -> {
                        String string = path.getFileName().toString();
                        if (!arrayList2.contains(string.toLowerCase(Locale.ROOT))) {
                            arrayList2.add(string.toLowerCase(Locale.ROOT));
                            String string2 = string.substring(0, string.lastIndexOf(46));
                            itg.add(WallpaperManager.itu(arrayList, new isn("file:" + string, string2, null, (Path)path)));
                        }
                    });
                }
                finally {
                    if (stream == null) continue;
                    stream.close();
                }
            }
            catch (IOException iOException) {
                System.out.println("can't list " + path2 + ": " + iOException);
            }
        }
        for (isn isn3 : arrayList) {
            if (itg.contains(isn3) || isn3.thumb == null) continue;
            WallpaperManager.iug(isn3.thumb);
        }
        if (WallpaperManager.find(itj) == null) {
            itj = "world";
        }
    }

    private static isn itu(List<isn> list, isn isn2) {
        for (isn isn3 : list) {
            if (!isn3.key.equals(isn2.key) || !Objects.equals(isn3.file, isn2.file)) continue;
            isn3.failed = false;
            if (isn3.thumb == null) {
                isn3.thumbLoad = null;
            }
            return isn3;
        }
        return isn2;
    }

    private static boolean itv(Path path) {
        String string = path.getFileName().toString().toLowerCase(Locale.ROOT);
        return Files.isRegularFile(path, new LinkOption[0]) && (string.endsWith(".png") || string.endsWith(".jpg") || string.endsWith(".jpeg") || string.endsWith(".bmp") || string.endsWith(".gif"));
    }

    private static List<Path> itw() {
        return List.of();
    }

    static void openFolder() {
    }

    public static String selected() {
        return itj;
    }

    static boolean photoSelected() {
        isn isn2 = WallpaperManager.find(itj);
        return isn2 != null && !isn2.isWorld() && !isn2.isLive() && !isn2.isVideo();
    }

    public static void select(String string) {
        WallpaperManager.entries();
        itj = WallpaperManager.find(string) != null ? string : "world";
    }

    static String next() {
        List<isn> list = WallpaperManager.entries();
        int n = list.indexOf(WallpaperManager.find(itj));
        isn isn2 = list.get((n + 1) % list.size());
        itj = isn2.key;
        return WallpaperManager.label(isn2);
    }

    static String label(isn isn2) {
        if (isn2.isWorld()) {
            return Lang.value("World");
        }
        if (isn2.isUser() || !Lang.ru()) {
            return isn2.name;
        }
        if (isn2.isLive()) {
            return switch (isn2.sky) {
                case SkyStyle.AURORA -> "Живая аврора";
                case SkyStyle.NEBULA -> "Живая туманность";
                case SkyStyle.GALAXY -> "Живая галактика";
                case SkyStyle.SUNSET -> "Живой закат";
                case SkyStyle.CLOUDS -> "Живые облака";
                default -> isn2.name;
            };
        }
        WallpaperEntry kbs2 = WallpaperEntry.byKey(isn2.key);
        if (kbs2 != null) {
            return kbs2.title();
        }
        for (String[] stringArray : isz) {
            if (!isn2.key.equals("builtin:" + stringArray[1])) continue;
            return stringArray[2];
        }
        return isn2.name;
    }

    static isn find(String string) {
        for (isn isn2 : itg) {
            if (!isn2.key.equals(string)) continue;
            return isn2;
        }
        return null;
    }

    static GpuTextureView frame(int n, int n2) {
        GpuTextureView gpuTextureView;
        WallpaperManager.iuh();
        isn isn2 = WallpaperManager.find(itj);
        itn = -1.0f;
        if (isn2 == null || isn2.isWorld() || isn2.isLive() || isn2.failed || n < 16 || n2 < 16) {
            if (itk != null) {
                WallpaperManager.iug(itk);
                itk = null;
                itl = null;
                itm = -1.0f;
            }
            if (isn2 != null && isn2.isLive() && n >= 16 && n2 >= 16) {
                GpuTextureView gpuTextureView2 = LiveWallpaper.sky(isn2.sky, Math.round((float)n * 0.7f), Math.round((float)n2 * 0.7f), SkyStyle.time());
                itn = gpuTextureView2 != null ? isn2.sky.luminance : -1.0f;
                return gpuTextureView2;
            }
            return null;
        }
        GpuTexture uok2 = WallpaperManager.itx(isn2, n, n2);
        if (isn2.isVideo()) {
            GpuTextureView gpuTextureView3;
            float f = Math.min(1.0f, 2560.0f / (float)n);
            int n3 = Math.round((float)n * f);
            int n4 = Math.round((float)n2 * f);
            GpuTextureView gpuTextureView4 = gpuTextureView3 = isn2.fill >= 0 ? whl.get(isn2.video).placed(n3, n4, ClickGuiScreen.contentCenterX(), ClickGuiScreen.contentCenterY(), 0.95f, isn2.fill) : whl.get(isn2.video).fitted(n3, n4);
            return gpuTextureView3 != null ? gpuTextureView3 : (uok2 != null ? uok2.view : null);
        }
        if (uok2 == null) {
            return null;
        }
        float f = (float)MOTION.get();
        if (f > 0.001f && (gpuTextureView = LiveWallpaper.photo(uok2, SkyStyle.time(), f, PARTICLES.get(), Theme.tone())) != null) {
            return gpuTextureView;
        }
        return uok2.view;
    }

    private static GpuTexture itx(isn isn2, int n, int n2) {
        Object object;
        String string;
        int n3 = Math.min(2560, Math.max(256, (n + 63) / 64 * 64));
        int n4 = Math.round((float)n3 * ((float)n2 / (float)n));
        itq = string = isn2.key + "|" + n3 + "x" + n4 + "|" + FIT.get();
        if (itk != null && string.equals(itl)) {
            return itk;
        }
        if (ito == null || !string.equals(itp)) {
            itp = string;
            object = FIT.get();
            ito = CompletableFuture.supplyAsync(() -> WallpaperManager.lambda$photo$3(string, isn2, n3, n4, (String)object), ite);
        }
        if (ito.isDone()) {
            object = ito.getNow(null);
            ito = null;
            if (object == itr) {
                itp = null;
            } else if (object == null) {
                isn2.failed = true;
                System.out.println("can't load wallpaper " + isn2.name);
            } else {
                if (itk != null) {
                    WallpaperManager.iug(itk);
                }
                itk = GpuTexture.upload("wallpaper", (BufferedImage)object, false);
                itl = string;
                itm = WallpaperManager.ity((BufferedImage)object);
            }
        }
        return itk;
    }

    static float luminance() {
        return itk != null ? itm : itn;
    }

    private static float ity(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        double d = 0.0;
        int n3 = 0;
        for (int i = n2 / 5; i < n2 * 4 / 5; i += 4) {
            for (int j = n / 5; j < n * 4 / 5; j += 4) {
                int n4 = bufferedImage.getRGB(j, i);
                d += 0.2126 * (double)(n4 >> 16 & 0xFF) + 0.7152 * (double)(n4 >> 8 & 0xFF) + 0.0722 * (double)(n4 & 0xFF);
                ++n3;
            }
        }
        return n3 == 0 ? 0.4f : (float)(d / (double)n3 / 255.0);
    }

    static GpuTexture thumbnail(isn isn2) {
        if (isn2.thumb != null || isn2.isWorld() || isn2.failed) {
            return isn2.thumb;
        }
        if (isn2.isLive()) {
            if (RenderSystem.isOnRenderThread()) {
                isn2.thumb = LiveWallpaper.still(isn2.sky, 384, 216, 63.0f);
                isn2.failed = isn2.thumb == null;
            }
            return isn2.thumb;
        }
        if (isn2.thumbLoad == null) {
            isn2.thumbLoad = CompletableFuture.supplyAsync(() -> WallpaperManager.iub(WallpaperManager.iua(isn2, 384, 216), 192, 108, "Fill"), itf);
        } else if (isn2.thumbLoad.isDone() && RenderSystem.isOnRenderThread()) {
            BufferedImage bufferedImage = isn2.thumbLoad.getNow(null);
            if (bufferedImage == null) {
                isn2.failed = true;
            } else {
                isn2.thumb = GpuTexture.upload("wallpaper thumb", bufferedImage, false);
            }
        }
        return isn2.thumb;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static BufferedImage itz(isn isn2) {
        BufferedImage bufferedImage;
        if (isn2.resource == null) return ImageIO.read(isn2.file.toFile());
        InputStream inputStream = AssetPaths.open(isn2.resource);
        try {
            bufferedImage = ImageIO.read(inputStream);
            if (inputStream == null) return bufferedImage;
        }
        catch (Throwable throwable) {
            try {
                if (inputStream == null) throw throwable;
                try {
                    inputStream.close();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (Exception exception) {
                System.out.println("can't read " + isn2.name + ": " + exception);
                return null;
            }
        }
        inputStream.close();
        return bufferedImage;
    }

    /*
     * Exception decompiling
     */
    private static BufferedImage iua(isn var0, int var1_1, int var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    private static BufferedImage iub(BufferedImage bufferedImage, int n, int n2, String string) {
        if (bufferedImage == null) {
            return null;
        }
        float f = (float)bufferedImage.getWidth() / (float)bufferedImage.getHeight();
        float f2 = (float)n / (float)n2;
        boolean bl = string.equals("Fit") || string.equals("Auto") && f < f2 * 0.72f;
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 1);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        WallpaperManager.iuf(graphics2D);
        WallpaperManager.iuc(graphics2D, bufferedImage, n, n2);
        if (bl) {
            BufferedImage bufferedImage3 = WallpaperManager.iud(bufferedImage2, Math.max(1, n / 28), Math.max(1, n2 / 28));
            graphics2D.drawImage(bufferedImage3, 0, 0, n, n2, null);
            graphics2D.setColor(new Color(0, 0, 0, 90));
            graphics2D.fillRect(0, 0, n, n2);
            float f3 = Math.min((float)n / (float)bufferedImage.getWidth(), (float)n2 / (float)bufferedImage.getHeight());
            int n3 = Math.round((float)bufferedImage.getWidth() * f3);
            int n4 = Math.round((float)bufferedImage.getHeight() * f3);
            graphics2D.drawImage((Image)WallpaperManager.iud(bufferedImage, n3, n4), (n - n3) / 2, (n2 - n4) / 2, null);
        }
        graphics2D.dispose();
        return bufferedImage2;
    }

    private static void iuc(Graphics2D graphics2D, BufferedImage bufferedImage, int n, int n2) {
        float f = Math.max((float)n / (float)bufferedImage.getWidth(), (float)n2 / (float)bufferedImage.getHeight());
        int n3 = Math.max(n, Math.round((float)bufferedImage.getWidth() * f));
        int n4 = Math.max(n2, Math.round((float)bufferedImage.getHeight() * f));
        graphics2D.drawImage((Image)WallpaperManager.iud(bufferedImage, n3, n4), (n - n3) / 2, (n2 - n4) / 2, null);
    }

    private static BufferedImage iud(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = bufferedImage;
        int n3 = bufferedImage2.getWidth();
        int n4 = bufferedImage2.getHeight();
        while (n3 / 2 >= n && n4 / 2 >= n2) {
            bufferedImage2 = WallpaperManager.iue(bufferedImage2, n3 /= 2, n4 /= 2);
        }
        return n3 == n && n4 == n2 ? bufferedImage2 : WallpaperManager.iue(bufferedImage2, n, n2);
    }

    private static BufferedImage iue(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = new BufferedImage(Math.max(1, n), Math.max(1, n2), 1);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        WallpaperManager.iuf(graphics2D);
        graphics2D.drawImage(bufferedImage, 0, 0, bufferedImage2.getWidth(), bufferedImage2.getHeight(), null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    private static void iuf(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private static void iug(GpuTexture uok2) {
        ith.add(new isq(uok2, FrameDelta.frame()));
    }

    private static void iuh() {
        long l = FrameDelta.frame();
        ith.removeIf(isq2 -> {
            if (l - isq2.iss > 2L) {
                isq2.isr.close();
                return true;
            }
            return false;
        });
    }

    private static /* synthetic */ BufferedImage lambda$photo$3(String string, isn isn2, int n, int n2, String string2) {
        return string.equals(itq) ? WallpaperManager.iub(WallpaperManager.itz(isn2), n, n2, string2) : itr;
    }

    static {
        WORLD = "world";
        DEFAULT = "video:flow-dark";
        FIT = new ModeSetting("Fit", "Auto", "Auto", "Fill", "Fit");
        DARKEN = new NumberSetting("Darken", 0.3, 0.0, 0.9, 0.05).percent();
        MOTION = new NumberSetting("Motion", 0.6, 0.0, 1.0, 0.05).percent();
        PARTICLES = new BoolSetting("Particles", true);
        isy = new String[][]{{"Flow Black", "flow-dark", "040506"}, {"Flow White", "flow-light", "EEEFED"}};
        isz = new String[][]{{"Cats", "cats", "Котики"}, {"Sunset Isles", "isles", "Острова на закате"}, {"Dusk", "dusk", "Сумерки"}, {"Aurora", "aurora", "Аврора"}, {"Nebula", "nebula", "Туманность"}, {"Liquid", "liquid", "Жидкость"}, {"Alpine Night", "alpine-night", "Альпийская ночь"}, {"Peaks", "peaks", "Вершины"}, {"Starfall", "starfall", "Звездопад"}, {"Milky Coast", "milky-coast", "Млечный берег"}, {"Starlit Lake", "starlit-lake", "Звёздное озеро"}, {"Misty Pines", "misty-pines", "Сосны в тумане"}, {"Glacier Lake", "glacier-lake", "Ледниковое озеро"}, {"Emerald Lake", "emerald-lake", "Изумрудное озеро"}, {"Golden Sea", "golden-sea", "Золотое море"}, {"Ember", "ember", "Угли"}, {"Dunes", "dunes", "Дюны"}, {"Shibuya", "shibuya", "Сибуя"}, {"Night Alley", "night-alley", "Ночной переулок"}, {"Lanterns", "lanterns", "Фонарики"}, {"Tokyo Tower", "tokyo-tower", "Токийская башня"}, {"Hanami", "hanami", "Ханами"}, {"Sakura Night", "sakura-night", "Ночная сакура"}, {"Eclipse", "eclipse", "Затмение"}, {"Earthrise", "earthrise", "Восход Земли"}, {"Prism", "prism", "Призма"}, {"Waves", "waves", "Волны"}, {"Bloom", "bloom", "Цветение"}};
        ita = new String[][]{{"Sparkle", "sparkle"}, {"Cherry Leaves", "cherry"}, {"Autumn Cats", "autumn-cats"}, {"Castle in the Clouds", "castle"}, {"Falling Snow", "snow"}, {"Sky Meadow", "hsr-sky"}, {"Girl with Flowers", "flowers"}, {"Dark Elf", "elf"}, {"Wandering Samurai", "samurai"}, {"Sunset Farm", "farm"}};
        ite = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "Flow2 wallpapers");
            thread.setDaemon(true);
            return thread;
        });
        itf = Executors.newFixedThreadPool(3, runnable -> {
            Thread thread = new Thread(runnable, "Flow2 wallpaper thumbs");
            thread.setDaemon(true);
            thread.setPriority(1);
            return thread;
        });
        itg = new ArrayList<isn>();
        ith = new ArrayList<isq>();
        itj = "video:flow-dark";
        itm = -1.0f;
        itn = -1.0f;
        itr = new BufferedImage(1, 1, 1);
    }

    private static /* synthetic */ int ajw(int n, int n2) {
        return n + n2 + 1041784533;
    }

    private static /* synthetic */ int ajx(int n, int n2) {
        return n - n2 ^ 0xEE04BD3;
    }

    private static /* synthetic */ int ajy(int n, int n2) {
        return n ^ n2 ^ 0xFE5ECFE4;
    }
}

