/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTextureView
 */
package a;

import a.ezj;
import a.hlc;
import a.iov;
import a.isn;
import a.isq;
import a.kbs;
import a.unf;
import a.uok;
import a.upi;
import a.uxt;
import a.vkl;
import a.vlv;
import a.vmc;
import a.wap;
import a.whl;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
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

public final class isv {
    public static final vlv FIT;
    public static final vmc DARKEN;
    public static final vmc MOTION;
    public static final vkl PARTICLES;
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
    private static uok itk;
    private static String itl;
    private static float itm;
    private static float itn;
    private static CompletableFuture<BufferedImage> ito;
    private static String itp;
    private static volatile String itq;
    private static final BufferedImage itr;
    private static /* synthetic */ long its;
    private static /* synthetic */ long itt;

    private isv() {
    }

    static List<isn> entries() {
        if (!iti) {
            isv.rescan();
        }
        return itg;
    }

    static void rescan() {
        iti = true;
        ArrayList<isn> arrayList = new ArrayList<isn>(itg);
        itg.clear();
        itg.add(isv.itu(arrayList, new isn(a.b("\u447a\u3dd3\ub71d\u2972\ua2ad", -721533944), a.c(1419028856, "\ua92a\ud0a3\u5a6d\uc402\u4fdd"), null, null)));
        for (String[] stringArray : isy) {
            isn isn2 = isv.itu(arrayList, new isn(a.b("\ub6d4\ucf7a\u45a4\udbd4\u5009\ud6ed", 541243044) + stringArray[1], stringArray[0], whl.poster(stringArray[1]), null, null, stringArray[1]));
            isn2.fill = Integer.parseInt(stringArray[2], 16);
            itg.add(isn2);
        }
        for (uxt uxt2 : uxt.values()) {
            itg.add(isv.itu(arrayList, new isn(a.c(574584315, "\u758c\u0c25\u86e4\u18d6") + uxt2.title.toLowerCase(Locale.ROOT), a.d("\ue153\u98c7\u120b\u8c69\u07fb", 1451393691, 683828097) + uxt2.title, null, null, uxt2)));
        }
        for (String[] stringArray : ita) {
            itg.add(isv.itu(arrayList, new isn(a.c(1947858897, "\uf7a1\u8e0f\u04d1\u9aa1\u117c\u9798") + stringArray[1], stringArray[0], whl.poster(stringArray[1]), null, null, stringArray[1])));
        }
        for (String[] stringArray : isz) {
            itg.add(isv.itu(arrayList, new isn(a.d("\ub037\uc991\u435e\udd2a\u56e5\ud049\u6a1d\ue3b8", -286070969, -900376806) + stringArray[1], stringArray[0], a.c(-549743858, "\u9330\ueac8\u6011\ufe63\u75ac\uf345\u494e\uc0a9\u5efb\ud44a\u5385\ua9e5\u2723\ube87\u34c3\ub233\u0820") + stringArray[1] + a.c(688199602, "\u1798\u6e6d\ue4a4\u7ac2"), null)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Path path2 : isv.itw()) {
            if (!Files.isDirectory(path2, new LinkOption[0])) continue;
            try {
                Stream<Path> stream = Files.list(path2);
                try {
                    stream.filter(isv::itv).sorted().forEach(path -> {
                        String string = path.getFileName().toString();
                        if (!arrayList2.contains(string.toLowerCase(Locale.ROOT))) {
                            arrayList2.add(string.toLowerCase(Locale.ROOT));
                            String string2 = string.substring(0, string.lastIndexOf(46));
                            itg.add(isv.itu(arrayList, new isn(a.c(738646596, "\uda27\ua399\u294f\ub737\u3cbf") + string, string2, null, (Path)path)));
                        }
                    });
                }
                finally {
                    if (stream == null) continue;
                    stream.close();
                }
            }
            catch (IOException iOException) {
                System.out.println(a.b("\u6c79\u15ca\u9f16\u012e\u8aaa\u0c4f\ub650\u3fa4\ua1e1\u2b57\uacd0", -1475384303) + path2 + a.b("\u4231\u3b9a", 1900495369) + iOException);
            }
        }
        for (isn isn3 : arrayList) {
            if (itg.contains(isn3) || isn3.thumb == null) continue;
            isv.iug(isn3.thumb);
        }
        if (isv.find(itj) == null) {
            itj = a.d("\ubb0d\uc2a4\u486a\ud605\u5dda", -1602450682, 144060537);
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
        return Files.isRegularFile(path, new LinkOption[0]) && (string.endsWith(a.b("\u6920\u10cf\u9a02\u047a", -448829174)) || string.endsWith(a.d("\u1852\u61a7\ueb6e\u7508", -980247980, -410287572)) || string.endsWith(a.d("\u8746\ufeb3\u747a\uea1e\u61cb", 839537380, 1307432329)) || string.endsWith(a.b("\u9dd8\ue425\u6ef9\uf095", 492477938)) || string.endsWith(a.c(1863453429, "\u0adf\u7327\uf9fa\u6784")));
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
        isn isn2 = isv.find(itj);
        return isn2 != null && !isn2.isWorld() && !isn2.isLive() && !isn2.isVideo();
    }

    public static void select(String string) {
        isv.entries();
        itj = isv.find(string) != null ? string : a.c(-664324189, "\u37d1\u4e78\uc4b6\u5ad9\ud106");
    }

    static String next() {
        List<isn> list = isv.entries();
        int n = list.indexOf(isv.find(itj));
        isn isn2 = list.get((n + 1) % list.size());
        itj = isn2.key;
        return isv.label(isn2);
    }

    static String label(isn isn2) {
        if (isn2.isWorld()) {
            return wap.value(a.c(-204771466, "\u6f24\u16ad\u9c63\u020c\u89d3"));
        }
        if (isn2.isUser() || !wap.ru()) {
            return isn2.name;
        }
        if (isn2.isLive()) {
            return switch (isn2.sky) {
                case uxt.AURORA -> a.d("\u96ae\uef31\u65e8\ufb9b\u7033\uf2ed\u4cae\uc55d\u5b70\ud1bf\u5612\uac13", 2137722992, -335969596);
                case uxt.NEBULA -> a.b("\u4c64\u35fb\ubf22\u2151\uaaf9\u2827\u9616\u1fe6\u81c6\u0b7b\u8ca5\u76d4\uf800\u61ce\ueb9e\u6d61", -798472094);
                case uxt.GALAXY -> a.b("\u7dae\u0431\u8ee8\u109b\u9b33\u19ed\ua7ad\u2e5f\ub00b\u3ab1\ubd68\u4761\uc9cc\u507f\uda26", -774211145);
                case uxt.SUNSET -> a.c(271997063, "\u5c9a\u2505\uafdc\u31a1\uba71\u38d9\u869d\u0f6b\u913e\u1b85\u9c24");
                case uxt.CLOUDS -> a.d("\u417b\u38e4\ub23d\u2c35\ua79c\u2538\u9b75\u128b\u8cde\u0664\u81bd\u7bc6", -808562496, -1949035103);
                default -> isn2.name;
            };
        }
        kbs kbs2 = kbs.byKey(isn2.key);
        if (kbs2 != null) {
            return kbs2.title();
        }
        for (String[] stringArray : isz) {
            if (!isn2.key.equals(a.b("\uab11\ud2b7\u5878\uc60c\u4dc3\ucb6f\u713b\uf89e", -1358845061) + stringArray[1])) continue;
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
        isv.iuh();
        isn isn2 = isv.find(itj);
        itn = -1.0f;
        if (isn2 == null || isn2.isWorld() || isn2.isLive() || isn2.failed || n < 16 || n2 < 16) {
            if (itk != null) {
                isv.iug(itk);
                itk = null;
                itl = null;
                itm = -1.0f;
            }
            if (isn2 != null && isn2.isLive() && n >= 16 && n2 >= 16) {
                GpuTextureView gpuTextureView2 = upi.sky(isn2.sky, Math.round((float)n * 0.7f), Math.round((float)n2 * 0.7f), uxt.time());
                itn = gpuTextureView2 != null ? isn2.sky.luminance : -1.0f;
                return gpuTextureView2;
            }
            return null;
        }
        uok uok2 = isv.itx(isn2, n, n2);
        if (isn2.isVideo()) {
            GpuTextureView gpuTextureView3;
            float f = Math.min(1.0f, 2560.0f / (float)n);
            int n3 = Math.round((float)n * f);
            int n4 = Math.round((float)n2 * f);
            GpuTextureView gpuTextureView4 = gpuTextureView3 = isn2.fill >= 0 ? whl.get(isn2.video).placed(n3, n4, hlc.contentCenterX(), hlc.contentCenterY(), 0.95f, isn2.fill) : whl.get(isn2.video).fitted(n3, n4);
            return gpuTextureView3 != null ? gpuTextureView3 : (uok2 != null ? uok2.view : null);
        }
        if (uok2 == null) {
            return null;
        }
        float f = (float)MOTION.get();
        if (f > 0.001f && (gpuTextureView = upi.photo(uok2, uxt.time(), f, PARTICLES.get(), iov.tone())) != null) {
            return gpuTextureView;
        }
        return uok2.view;
    }

    private static uok itx(isn isn2, int n, int n2) {
        Object object;
        String string;
        int n3 = Math.min(2560, Math.max(256, (n + 63) / 64 * 64));
        int n4 = Math.round((float)n3 * ((float)n2 / (float)n));
        itq = string = isn2.key + a.c(-459523315, "\u3b70") + n3 + a.b("\u028d", 1067516660) + n4 + a.d("\u570d", 239565320, -614650504) + FIT.get();
        if (itk != null && string.equals(itl)) {
            return itk;
        }
        if (ito == null || !string.equals(itp)) {
            itp = string;
            object = FIT.get();
            ito = CompletableFuture.supplyAsync(() -> isv.lambda$photo$3(string, isn2, n3, n4, (String)object), ite);
        }
        if (ito.isDone()) {
            object = ito.getNow(null);
            ito = null;
            if (object == itr) {
                itp = null;
            } else if (object == null) {
                isn2.failed = true;
                System.out.println(a.c(-664270660, "\u08ca\u7179\ufba5\u659d\uee19\u68fc\ud2e3\u5b11\uc540\u4ff4\uc863\u3245\ubc84\u2538\uaf6b\u2986\u93d8\u1c18\u86be\u00f8\u895d") + isn2.name);
            } else {
                if (itk != null) {
                    isv.iug(itk);
                }
                itk = uok.upload(a.d("\u762a\u0f8d\u8553\u1b22\u90e9\u1649\uac0b\u25ef\ubba7", -1125567290, 1535132306), (BufferedImage)object, false);
                itl = string;
                itm = isv.ity((BufferedImage)object);
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

    static uok thumbnail(isn isn2) {
        if (isn2.thumb != null || isn2.isWorld() || isn2.failed) {
            return isn2.thumb;
        }
        if (isn2.isLive()) {
            if (RenderSystem.isOnRenderThread()) {
                isn2.thumb = upi.still(isn2.sky, 384, 216, 63.0f);
                isn2.failed = isn2.thumb == null;
            }
            return isn2.thumb;
        }
        if (isn2.thumbLoad == null) {
            isn2.thumbLoad = CompletableFuture.supplyAsync(() -> isv.iub(isv.iua(isn2, 384, 216), 192, 108, a.b("\u29ce\u5050\uda86\u44f7", 1774004620)), itf);
        } else if (isn2.thumbLoad.isDone() && RenderSystem.isOnRenderThread()) {
            BufferedImage bufferedImage = isn2.thumbLoad.getNow(null);
            if (bufferedImage == null) {
                isn2.failed = true;
            } else {
                isn2.thumb = uok.upload(a.d("\u82a9\ufb0e\u71d0\uefa1\u646a\ue2ca\u5888\ud16c\u4f24\uc5c7\u4240\ub82d\u36e7\uaf4e\u2512", -872687546, -1526179177), bufferedImage, false);
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
        InputStream inputStream = ezj.open(isn2.resource);
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
                System.out.println(a.c(1565477579, "\u4aa3\u3310\ub9cc\u27f4\uac70\u2a95\u9094\u1972\u8729\u0d9d\u8a0a") + isn2.name + a.b("\udace\ua365", 163306230) + exception);
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
        boolean bl = string.equals(a.c(-251317271, "\u33ac\u4a32\uc0fc")) || string.equals(a.c(1063451959, "\ufd72\u84f7\u0e25\u904f")) && f < f2 * 0.72f;
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 1);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        isv.iuf(graphics2D);
        isv.iuc(graphics2D, bufferedImage, n, n2);
        if (bl) {
            BufferedImage bufferedImage3 = isv.iud(bufferedImage2, Math.max(1, n / 28), Math.max(1, n2 / 28));
            graphics2D.drawImage(bufferedImage3, 0, 0, n, n2, null);
            graphics2D.setColor(new Color(0, 0, 0, 90));
            graphics2D.fillRect(0, 0, n, n2);
            float f3 = Math.min((float)n / (float)bufferedImage.getWidth(), (float)n2 / (float)bufferedImage.getHeight());
            int n3 = Math.round((float)bufferedImage.getWidth() * f3);
            int n4 = Math.round((float)bufferedImage.getHeight() * f3);
            graphics2D.drawImage((Image)isv.iud(bufferedImage, n3, n4), (n - n3) / 2, (n2 - n4) / 2, null);
        }
        graphics2D.dispose();
        return bufferedImage2;
    }

    private static void iuc(Graphics2D graphics2D, BufferedImage bufferedImage, int n, int n2) {
        float f = Math.max((float)n / (float)bufferedImage.getWidth(), (float)n2 / (float)bufferedImage.getHeight());
        int n3 = Math.max(n, Math.round((float)bufferedImage.getWidth() * f));
        int n4 = Math.max(n2, Math.round((float)bufferedImage.getHeight() * f));
        graphics2D.drawImage((Image)isv.iud(bufferedImage, n3, n4), (n - n3) / 2, (n2 - n4) / 2, null);
    }

    private static BufferedImage iud(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = bufferedImage;
        int n3 = bufferedImage2.getWidth();
        int n4 = bufferedImage2.getHeight();
        while (n3 / 2 >= n && n4 / 2 >= n2) {
            bufferedImage2 = isv.iue(bufferedImage2, n3 /= 2, n4 /= 2);
        }
        return n3 == n && n4 == n2 ? bufferedImage2 : isv.iue(bufferedImage2, n, n2);
    }

    private static BufferedImage iue(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = new BufferedImage(Math.max(1, n), Math.max(1, n2), 1);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        isv.iuf(graphics2D);
        graphics2D.drawImage(bufferedImage, 0, 0, bufferedImage2.getWidth(), bufferedImage2.getHeight(), null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    private static void iuf(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private static void iug(uok uok2) {
        ith.add(new isq(uok2, unf.frame()));
    }

    private static void iuh() {
        long l = unf.frame();
        ith.removeIf(isq2 -> {
            if (l - isq2.iss > 2L) {
                isq2.isr.close();
                return true;
            }
            return false;
        });
    }

    private static /* synthetic */ BufferedImage lambda$photo$3(String string, isn isn2, int n, int n2, String string2) {
        return string.equals(itq) ? isv.iub(isv.itz(isn2), n, n2, string2) : itr;
    }

    static {
        WORLD = a.c(-1535440022, "\u0b18\u72b1\uf87f\u6610\uedcf");
        DEFAULT = a.c(298037884, "\ub205\ucbab\u4175\udf05\u54d8\ud23c\u6833\ue1c8\u7f94\uf53d\u72b4\u888c\u065e\u9ffc\u15b6");
        FIT = new vlv(a.c(1594806204, "\ucff9\ub667\u3ca9"), a.d("\u54ed\u2d68\ua7ba\u39d0", -1832121426, -1124835578), a.d("\u59c4\u2041\uaa93\u34f9", 1406095829, 1098713172), a.d("\u3738\u4ea6\uc470\u5a01", 1718428303, -896592395), a.b("\ua3bf\uda21\u50ef", 1056744442));
        DARKEN = new vmc(a.d("\ucac2\ub356\u3996\ua7fe\u2c27\uaa9d", 597683531, -1740888117), 0.3, 0.0, 0.9, 0.05).percent();
        MOTION = new vmc(a.d("\u3280\u4b13\uc1db\u5fb7\ud466\u52d6", -412184341, 136159776), 0.6, 0.0, 1.0, 0.05).percent();
        PARTICLES = new vkl(a.d("\uc930\ub0b0\u3a70\ua407\u2fcd\ua976\u132a\u9ad2\u049b", -1395487446, 773473347), true);
        isy = new String[][]{{a.d("\u5da7\u243c\uaeec\u3085\ubb05\u3dd6\u87ab\u0e57\u900a\u1ab3", 1549861911, 1368218108), a.b("\u951e\ueca5\u6675\uf81c\u7391\uf569\u4f3f\uc6dd\u589b", 1694733681), a.b("\ubc40\uc5f5\u4f22\ud156\u5a84\udc33", -1868841866)}, {a.b("\uac03\ud598\u5f48\uc121\u4aa1\ucc67\u760b\ufffb\u61b9\ueb19", 902212687), a.b("\ucb9c\ub227\u38f7\ua69e\u2d13\uabe3\u11b5\u984a\u061a\u8cb7", -2082419728), a.c(292262441, "\u926a\uebdb\u6108\uff7a\u74ae\uf21e")}};
        isz = new String[][]{{a.b("\u1234\u6ba7\ue161\u7f17", -1821765005), a.b("\ua176\ud8c5\u5203\ucc75", -1709006575), a.c(-1642025373, "\uaa7f\ud3ea\u5945\uc74e\u4c9b\uca28")}, {a.b("\ub206\ucb91\u4159\udf35\u54f4\ud254\u6853\ue1cb\u7fae\uf500\u72da\u88bd", 731165273), a.c(-473269146, "\u7c0a\u05a1\u8f6d\u1115\u9ad4"), a.d("\u4d66\u3488\ube58\u202b\uab82\u2d3f\u976e\u1a8f\u80cd\u0a71\u89b2\u77d4\uf904\u60bf\ueae6\u6c65\ud65d", -1279266724, -1373325003)}, {a.b("\uec06\u9586\u1f53\u813a", -930026426), a.c(1593637829, "\ufba5\u8205\u08d0\u96b9"), a.c(1557960506, "\u931c\ueacf\u6063\ufe1b\u75b9\uf372\u4923")}, {a.d("\u8282\ufb07\u71d3\uefbf\u6475\ue2d7", -2072326435, 1501973528), a.c(171995385, "\u709e\u093b\u83ef\u1d83\u9649\u10eb"), a.c(805714384, "\u3dc6\u4455\ucef4\u50fb\udb52\u5d93")}, {a.d("\u1b94\u620e\ue8da\u76bc\ufd72\u7bce", -1051202588, 1636954168), a.b("\ua2bc\udb06\u51d2\ucfb4\u447a\uc2c6", -1270308140), a.c(-601101234, "\ue866\u91b6\u1b1a\u8567\u0ebd\u880c\u325c\ubbd2\u258e\uaf31")}, {a.c(543200213, "\u939f\uea0b\u60c0\ufeb5\u757e\uf3c2"), a.b("\u1384\u6a30\ue0fb\u7e8e\uf545\u73f9", -1700588562), a.d("\u4b74\u32eb\ub834\u264b\uad98\u2b56\u9106\u18f9", -715955066, -718525460)}, {a.d("\ud5b4\uac28\u26e7\ub88f\u335f\ub5e5\u0ff3\u866c\u1814\u92ab\u1577\uef1a", -857589004, -302780659), a.d("\udddb\ua467\u2ea8\ub0c0\u3b10\ubdaa\u07b1\u8e03\u105b\u9ae4\u1d38\ue755", -301590589, -641611147), a.d("\ucbb5\ub22f\u388b\ua689\u2d59\uabe9\u11c2\u9848\u061d\u8cd3\u0f6f\uf103\u7fd7\ue61f\u6c47", -1281197122, 1304802324)}, {a.c(-604987192, "\ua09d\ud919\u53ce\ucdb5\u467a"), a.b("\u4879\u31dd\ubb0a\u2571\uaebe", -98220020), a.b("\ub77d\uceeb\u444d\uda34\u5193\ud727\u6d02", 1702409064)}, {a.c(-1073667916, "\u20ef\u5979\ud3bf\u4ddd\uc61e\u40a8\ufaf6\u7307"), a.d("\uc892\ub124\u3be2\ua580\u2e43\ua8f5\u12ab\u9b5a", 714851130, 1590954963), a.d("\ufdfe\u846a\u0ebe\u90cd\u1b19\u9da2\u27f0\uae0e\u3055", 1273053523, -2068793165)}, {a.b("\u5611\u2f84\ua552\u3b24\ub0e1\u3609\u8c39\u05e4\u9bb5\u1116\u96c2", -1798810025), a.d("\ud3b2\uaa07\u20d1\ubea7\u3562\ub387\u099a\u8067\u1e36\u9495\u1341", -84044472, 720979612), a.d("\u6870\u11e6\u9b3b\u0538\u8e95\u0852\ub273\u3f9b\ua5d5\u2f60\ua8c6\u52c2\udc13", -220200377, 1583181350)}, {a.d("\u2b8c\u521a\ud8dc\u46be\ucd77\u4bc3\uf18d\u7828\ue61b\u6c87\ueb5e\u1121", -850181059, 1198813166), a.c(-1182093686, "\uaef5\ud743\u5d85\uc3e7\u482e\uce9a\u74d4\ufd7c\u6362\ue9de\u6e07\u9478"), a.b("\u6f25\u16b1\u9c01\u0216\u89c2\u0f7a\ub52a\u3cd0\ua69a\u2835\uafef\u559c\udb3e\u42f1", -1366463684)}, {a.b("\ubda7\uc432\u4efb\ud08d\u5b57\uddbf\u679c\uee54\u700c\ufab6\u7d73", 1638972897), a.d("\uf44e\u8dfb\u0732\u9944\u129e\u947b\u2e75\ua79d\u39c5\ub37f\u34ba", 1218673103, -1304654361), a.b("\u4a25\u338b\ub927\u272a\uac8b\u2e51\u9010\u1df3\u87ce\u0d7e\u8ad2\u70af\ufe75\u67cc", 432295434)}, {a.d("\u3f0b\u4691\ucc4f\u523c\ud9e1\u5f5c\ue518\u6cbb\uf288\u7814\uffcd\u05b2", -108792356, 1636289180), a.d("\u6830\u118a\u9b54\u0527\u8efa\u0847\ub203\u3bad\ua5b3\u2f0f\ua8d6\u52a9", -1720544287, -1944978502), a.d("\u5223\u2bbc\ua16e\u3f16\ub4c4\u3277\u8820\u01dd\u9f8e\u1534\u96f2\u689d\ue643\u7ff0\uf5d6\u7359", 1581988101, -1320063187)}, {a.b("\ud878\ua1e1\u2b3a\ub55c\u3e98\ub824\u027f\u8bca\u15f9\u9f65\u18bc\ue2c3", 1755240497), a.d("\ueb5f\u92e6\u183d\u865b\u0d9f\u8b23\u3178\ub8c0\u26de\uac62\u2bbb\ud1c4", -1228137259, 506329059), a.d("\u34f4\u4d6a\uc7cd\u59c3\ud268\u54da\ueefe\u6706\uf95a\u73e0\uf026\u0e49\u8097\u1924\u9302\u158d", 1941314427, -1830212729)}, {a.c(851606702, "\u7ce3\u057a\u8faa\u11d3\u9a05\u1cbf\ua6a2\u2f20\ub149\u3bfc"), a.d("\u1d42\u64fb\uee2b\u7052\ufb84\u7d3e\uc72e\u4e81\ud0c8\u5a7d", -1725266030, -1031890243), a.d("\u60fe\u1966\u93b0\u0dc4\u866f\u00a2\ubafa\u371e\uad5d\u27ee\ua043\u5a47", -990004506, 1858395651)}, {a.c(-1193110433, "\u941f\ued86\u675a\uf92c\u72ec"), a.c(-1539998991, "\u7a91\u0328\u89f4\u1782\u9c42"), a.b("\ua474\uddd5\u570e\uc97c", -846290861)}, {a.c(1308522483, "\u77b2\u0e32\u84fa\u1a80\u9141"), a.c(1433816987, "\u4ffa\u365a\ubc92\u22e8\ua929"), a.d("\u2bcb\u5220\ud880\u4687", -1930829015, 369216754)}, {a.d("\u4993\u3019\ubacb\u24b1\uaf71\u29cc\u9387", -1967193060, 511593947), a.c(-476039222, "\u37be\u4e14\uc4c6\u5abc\ud17c\u57c1\ued8a"), a.b("\ubc5b\uc5f3\u4f29\ud12a\u5af1", 1175500927)}, {a.b("\u2232\u5ba4\ud179\u4f07\uc4cc\u4229\uf81b\u71c7\uef98\u6520\ue2ef", -854777225), a.b("\u2927\u5091\uda4c\u4432\ucff9\u4911\uf30e\u7af2\ue4ad\u6e15\ue9da", -219469502), a.d("\ub9f8\uc06a\u4ac0\ud4cb\u5f1f\ud9a9\u67e3\uea0d\u7458\ufe9c\u793a\u833d\u0d92\u9426\u1e71", -1127000797, 805562569)}, {a.c(-1483311598, "\u7656\u0fca\u8516\u1b7d\u90bb\u161d\uac52\u25be"), a.d("\ua873\ud1cf\u5b13\uc578\u4ebe\uc818\u7257\ufbbb", -1450055781, -448245876), a.b("\u1d21\u648a\uee5a\u7026\ufb81\u7d48\uc719\u4eea", 1505499405)}, {a.b("\u4c1c\u3596\ubf41\u2122\uaae3\u2c1d\u963a\u1ff0\u81b7\u0b14\u8cd0", -1503835069), a.d("\ua6d3\udf79\u55ae\ucbcd\u400c\uc6ff\u7cf5\uf51f\u6b58\ue1fb\u663f", -1522865981, 1806388847), a.c(-1465944331, "\u72d8\u0b75\u81a2\u1fd1\u9407\u12ce\ua8e6\u211d\ubf3d\u31e3\ub221\u4851\uc6fe\u5f3a\ud51b")}, {a.c(-253953181, "\ufb2d\u82b5\u0869\u9617\u1dcc\u9b79"), a.d("\u1703\u6ebb\ue467\u7a19\uf1c2\u7777", -1494382754, 2026737715), a.b("\u94a8\ued0c\u67d2\uf9ae\u7275\uf4c0", -763129717)}, {a.b("\u7059\u09da\u8303\u1d6c\u96bc\u101e\uaa0c\u2393\ubdeb\u3754\ub088\u4ae5", -1392414714), a.c(-662453789, "\uc19c\ub83f\u32e6\uac89\u2759\ua1fb\u1be4\u9256\u0c0e\u86b1\u016d\ufb00"), a.c(1062331809, "\ue1b1\u9823\u1289\u8c82\u0758\u8196\u3faa\ub23a\u2c14\ua6af\u2105\udb77\u55d0")}, {a.c(772618092, "\u372e\u4eb9\uc465\u5a11\ud1df\u576d\ued28"), a.c(-955127068, "\uea86\u9331\u19ed\u8799\u0c57\u8ae5\u30a0"), a.d("\ua6c2\udf54\u55f5\ucbfa\u4024\uc69d\u7ccb\uf537", -1760093288, 79673669)}, {a.b("\ue329\u9abc\u107c\u8e0b\u05c0\u836b\u3923\ub0c8\u2e81", 843899749), a.c(-98242446, "\uf01e\u89ab\u036b\u9d1c\u16d7\u907c\u2a34\ua3df\u3d96"), a.b("\u23d5\u5a48\ud0e4\u4e91\uc53d\u4386\ufdc1\u7007\uee7a\u64c2\ue316\u1964", 329197515)}, {a.d("\uffe0\u8673\u0cbb\u92d0\u1919", 1259971352, -245998419), a.d("\ubd05\uc4b6\u4e7e\ud015\u5bdc", -325963832, -1057647944), a.d("\ufd48\u84a6\u0e0d\u9073\u1baf\u9d12", -878545718, -1431335525)}, {a.c(-1788440756, "\u8f1e\uf699\u7c5d\ue23f\u69fe"), a.c(849212209, "\uf343\u8ae4 \u9e42\u1583"), a.d("\ua0d9\ud944\u5392\ucde5\u4644", -823471733, 1929803077)}, {a.b("\u20eb\u5974\ud3a4\u4dd5\uc600", 1615405228), a.d("\ub563\uccdc\u460c\ud87d\u53a8", -1616177246, 560308902), a.d("\ub8ad\uc108\u4bdc\ud5da\u5e7a\ud8c3\u6295\ueb69", 1658056068, 370823431)}};
        ita = new String[][]{{a.b("\u441a\u3d88\ub74a\u2928\ua2e6\u2450\u9e0a", -1362541490), a.b("\u2662\u5fd0\ud512\u4b70\uc0be\u4608\ufc52", 1980507670)}, {a.c(284617204, "\ue9ba\u9020\u1afe\u8498\u0f4f\u89f5\u33ff\uba62\u2414\uaea1\u2965\ud307\u5dc6"), a.b("\u1f0e\u66b4\uec6a\u720c\uf9db\u7f61", 383786859)}, {a.d("\u408f\u390a\ub3d8\u2da8\ua667\u20d5\u9ac8\u135a\u8d27\u0783\u8057", 754663102, 1786674811), a.c(856732834, "\ub4c8\ucd6d\u47bf\ud9cf\u5200\ud4b2\u6ea2\ue71d\u7940\uf3e4\u7430")}, {a.b("\u4307\u3a94\ub055\u2e23\ua5ec\u2354\u9942\u10fa\u8ea2\u045d\u83da\u79b7\uf76d\u6e99\ue4a9\u6277\ud83b\u57f0\ucd52\u4b14", 280511312), a.b("\u9143\ue8f0\u6231\ufc47\u7788\uf130", 1228902694)}, {a.d("\u2abd\u532b\ud9f5\u4784\ucc56\u4ae0\uf0ba\u790c\ue720\u6dac\uea7e\u1017", 361453095, 1062108368), a.b("\uffcf\u8663\u0cb1\u92d8", 619577272)}, {a.b("\u3583\u4c0a\uc6cb\u58e3\ud359\u55c0\uef97\u6663\uf837\u729e", 61289946), a.b("\ubc2e\uc584\u4f56\ud178\u5af1\udc58\u6619", 480099393)}, {a.d("\ua0a6\ud939\u53f1\ucd9e\u4605\uc0e3\u7aae\uf342\u6d01\ue7f8\u604d\u9a16\u14c2\u8d6b\u072a\u81cc\u3b82", 971849989, -596778507), a.b("\u7fce\u0675\u8ca5\u12cc\u9909\u1faf\ua5fd", 1414692783)}, {a.c(-1151348670, "\ud00e\ua99a\u235a\ubd32\u36ae\ub07a\u0a00\u83fb"), a.b("\ua22e\udb96\u514f", 1556062792)}, {a.b("\u225a\u5bdd\ud101\u4f7a\uc4ac\u420a\uf842\u71b4\uefe2\u6514\ue2b4\u18f7\u962c\u0f85\u85d1\u0333\ub974", -1157619172), a.d("\ua337\uda94\u504b\uce22\u45f2\uc350\u790b", 264168695, -1291302988)}, {a.b("\u81f8\uf86f\u72a7\ueccb\u670a\ue1aa\u5bad\ud23a\u4c42\uc6e0\u412c", -659586656), a.c(535672963, "\ub8e1\uc157\u4b97\ud5f9")}};
        ite = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, a.b("\u2de8\u5473\udea3\u40ca\ucb58\u4dfb\uf7ff\u7e18\ue04a\u6afb\ued34\u1754\u99926\u8a72\u0c82", 103099838));
            thread.setDaemon(true);
            return thread;
        });
        itf = Executors.newFixedThreadPool(3, runnable -> {
            Thread thread = new Thread(runnable, a.c(2078655510, "\uc446\ubddd\u370d\ua964\u22f6\ua455\u1e51\u97b6\u09e4\u8355\u049a\ufefa\u703c\ue998\u63dc\ue57f\u5f64\ud0a9\u4a07\ucc4e\u45b6\u3ff6"));
            thread.setDaemon(true);
            thread.setPriority(1);
            return thread;
        });
        itg = new ArrayList<isn>();
        ith = new ArrayList<isq>();
        itj = a.b("\u79f2\\\u8a82\u14f2\u9f2f\u19cb\ua3c4\u2a3f\ub463\u3eca\ub943\u437b\ucda9\u540b\ude41", -1821214325);
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

