/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.AvatarCloud;
import a.AssetPaths;
import a.GuiConfig;
import a.FrameDelta;
import a.GpuTexture;
import a.DrawUtil;
import a.FontFace;
import flow.dev.StringDecryptor;
import flow.util.LoaderInfo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.class_310;
import net.minecraft.class_332;

public final class UserProfile {
    static final String[] IDS;
    static final String OWN;
    static final String[] SLOTS;
    private static final int hib = 8;
    private static final Map<String, BufferedImage> hic;
    private static final Set<String> hid;
    private static final Map<String, GpuTexture> hie;
    private static final Map<GpuTexture, Long> hif;
    private static String hig;
    private static String hih;
    private static int hii;
    private static boolean hij;
    private static /* synthetic */ boolean hik;
    private static /* synthetic */ boolean hil;

    private UserProfile() {
    }

    static String selected() {
        return hig;
    }

    static void select(String string) {
        for (String string2 : SLOTS) {
            if (!string2.equals(string)) continue;
            hig = string2;
        }
    }

    static String seenOwn() {
        return hih;
    }

    static void seenOwn(String string) {
        hih = string == null ? "" : string;
        hij = true;
    }

    static boolean ownReady() {
        return AvatarCloud.image() != null;
    }

    /*
     * Exception decompiling
     */
    static String label(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
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

    private static void him() {
        AvatarCloud.boot();
        int n = AvatarCloud.version();
        if (n != hii) {
            Map.Entry<String, GpuTexture> entry;
            hii = n;
            hic.remove("own");
            hid.remove("own");
            Iterator<Map.Entry<String, GpuTexture>> iterator = hie.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = iterator.next();
                if (!((String)entry.getKey()).startsWith("own@")) continue;
                hif.put((GpuTexture)entry.getValue(), FrameDelta.frame());
                iterator.remove();
            }
            entry = AvatarCloud.etag();
            if (hij && UserProfile.ownReady() && !((String)((Object)entry)).equals(hih)) {
                hih = entry;
                hig = "own";
                GuiConfig.saveLater();
            }
        }
        if (hij && "own".equals(hig) && AvatarCloud.known() && !UserProfile.ownReady()) {
            hig = IDS[0];
            GuiConfig.saveLater();
        }
    }

    static String windowsUser() {
        String string = System.getProperty("user.name");
        return string == null || string.isBlank() ? "FlowUser" : string;
    }

    public static String account() {
        String string = LoaderInfo.login();
        return string.isEmpty() ? UserProfile.windowsUser() : string;
    }

    public static boolean drawSelected(class_332 class_3322, float f, float f2, float f3) {
        return UserProfile.draw(class_3322, hig, f, f2, f3);
    }

    static boolean draw(class_332 class_3322, String string, float f, float f2, float f3) {
        return UserProfile.draw(class_3322, string, f, f2, f3, f3);
    }

    static boolean draw(class_332 class_3322, String string, float f, float f2, float f3, float f4) {
        UserProfile.him();
        GpuTexture uok2 = UserProfile.hin(string, f4);
        if (uok2 == null) {
            return false;
        }
        DrawUtil.image(class_3322, uok2.view, f, f2, f3, f3, f3 * 0.5f, -1);
        return true;
    }

    private static GpuTexture hin(String string, float f) {
        AutoCloseable autoCloseable;
        Object object;
        if (hid.contains(string)) {
            return null;
        }
        class_310 class_3102 = class_310.method_1551();
        float f2 = class_3102.method_22683() != null ? (float)Math.max(1, class_3102.method_22683().method_4495()) : 2.0f;
        int n = Math.max(8, Math.min(256, Math.round(f * f2 * FontFace.renderScale())));
        String string2 = string + "@" + n;
        GpuTexture uok2 = hie.get(string2);
        if (uok2 != null) {
            return uok2;
        }
        try {
            object = hic.get(string);
            if (object == null && "own".equals(string)) {
                object = AvatarCloud.image();
                if (object == null) {
                    return null;
                }
                hic.put(string, (BufferedImage)object);
            }
            if (object == null) {
                autoCloseable = AssetPaths.open("/flow/avatars/" + string + ".png");
                try {
                    if (autoCloseable == null) {
                        throw new IllegalStateException("missing /flow/avatars/" + string + ".png");
                    }
                    object = ImageIO.read(autoCloseable);
                }
                finally {
                    if (autoCloseable != null) {
                        autoCloseable.close();
                    }
                }
                hic.put(string, (BufferedImage)object);
            }
            uok2 = GpuTexture.upload("avatar " + string2, UserProfile.hio((BufferedImage)object, n), false);
        }
        catch (Throwable throwable) {
            hid.add(string);
            System.out.println("avatar " + string + " unavailable: " + throwable);
            return null;
        }
        hie.put(string2, uok2);
        while (hie.size() > 8) {
            object = hie.entrySet().iterator();
            autoCloseable = (GpuTexture)((Map.Entry)object.next()).getValue();
            object.remove();
            hif.put((GpuTexture)autoCloseable, FrameDelta.frame());
        }
        long l = FrameDelta.frame();
        hif.entrySet().removeIf(entry -> {
            if (l - (Long)entry.getValue() > 3L) {
                ((GpuTexture)entry.getKey()).close();
                return true;
            }
            return false;
        });
        return uok2;
    }

    private static BufferedImage hio(BufferedImage bufferedImage, int n) {
        Object object;
        Object object2;
        int n2 = Math.min(bufferedImage.getWidth(), bufferedImage.getHeight());
        Object object3 = new BufferedImage(n2, n2, 1);
        Graphics2D graphics2D = ((BufferedImage)object3).createGraphics();
        graphics2D.drawImage((Image)bufferedImage, -(bufferedImage.getWidth() - n2) / 2, -(bufferedImage.getHeight() - n2) / 2, null);
        graphics2D.dispose();
        while (((BufferedImage)object3).getWidth() / 2 >= n) {
            int n3 = ((BufferedImage)object3).getWidth() / 2;
            object2 = new BufferedImage(n3, n3, 1);
            object = ((BufferedImage)object2).createGraphics();
            ((Graphics2D)object).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            ((Graphics)object).drawImage((Image)object3, 0, 0, n3, n3, null);
            ((Graphics)object).dispose();
            object3 = object2;
        }
        if (((BufferedImage)object3).getWidth() == n) {
            return object3;
        }
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 1);
        object2 = bufferedImage2.createGraphics();
        object = ((Image)object3).getScaledInstance(n, n, 16);
        ((Graphics)object2).drawImage((Image)object, 0, 0, null);
        ((Graphics)object2).dispose();
        return bufferedImage2;
    }

    static {
        OWN = "own";
        IDS = new String[]{"pug", "cat", "monkey"};
        SLOTS = new String[]{"pug", "cat", "monkey", "own"};
        hic = new HashMap<String, BufferedImage>();
        hid = new HashSet<String>();
        hie = new LinkedHashMap<String, GpuTexture>();
        hif = new LinkedHashMap<GpuTexture, Long>();
        hig = IDS[0];
        hih = "";
    }

    private static /* synthetic */ int aas(int n, int n2) {
        return (n ^ n2) + 1090617823;
    }
}

