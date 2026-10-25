/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.evi;
import a.ezj;
import a.hyz;
import a.unf;
import a.uok;
import a.uut;
import a.vdn;
import flow.dev.a;
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
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class hia {
    static final String[] IDS;
    static final String OWN;
    static final String[] SLOTS;
    private static final int hib = 8;
    private static final Map<String, BufferedImage> hic;
    private static final Set<String> hid;
    private static final Map<String, uok> hie;
    private static final Map<uok, Long> hif;
    private static String hig;
    private static String hih;
    private static int hii;
    private static boolean hij;
    private static /* synthetic */ boolean hik;
    private static /* synthetic */ boolean hil;

    private hia() {
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
        return evi.image() != null;
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
        evi.boot();
        int n = evi.version();
        if (n != hii) {
            Map.Entry<String, uok> entry;
            hii = n;
            hic.remove(a.b("\u5f2e\u2687\uac4d", 454909762));
            hid.remove(a.c(151168700, "\ua6d0\udf79\u55b3"));
            Iterator<Map.Entry<String, uok>> iterator = hie.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = iterator.next();
                if (!((String)entry.getKey()).startsWith(a.b("\uae48\ud7e1\u5d2b\uc374", 310095395))) continue;
                hif.put((uok)entry.getValue(), unf.frame());
                iterator.remove();
            }
            entry = evi.etag();
            if (hij && hia.ownReady() && !((String)((Object)entry)).equals(hih)) {
                hih = entry;
                hig = a.c(-350656687, "\u673d\u1e94\u945e");
                hyz.saveLater();
            }
        }
        if (hij && a.c(748646734, "\u7122\u088b\u8241").equals(hig) && evi.known() && !hia.ownReady()) {
            hig = IDS[0];
            hyz.saveLater();
        }
    }

    static String windowsUser() {
        String string = System.getProperty(a.b("\ucc51\ub5e6\u3f23\ua145\u2ace\uac3f\u1663\u9f9e\u01c9", -2081960915));
        return string == null || string.isBlank() ? a.d("\u322f\u4bb4\uc164\u5f0d\ud4f8\u526f\ue82a\u61cc", -990311757, 450050258) : string;
    }

    public static String account() {
        String string = LoaderInfo.login();
        return string.isEmpty() ? hia.windowsUser() : string;
    }

    public static boolean drawSelected(DrawContext drawContext, float f, float f2, float f3) {
        return hia.draw(drawContext, hig, f, f2, f3);
    }

    static boolean draw(DrawContext drawContext, String string, float f, float f2, float f3) {
        return hia.draw(drawContext, string, f, f2, f3, f3);
    }

    static boolean draw(DrawContext drawContext, String string, float f, float f2, float f3, float f4) {
        hia.him();
        uok uok2 = hia.hin(string, f4);
        if (uok2 == null) {
            return false;
        }
        uut.image(drawContext, uok2.view, f, f2, f3, f3, f3 * 0.5f, -1);
        return true;
    }

    private static uok hin(String string, float f) {
        AutoCloseable autoCloseable;
        Object object;
        if (hid.contains(string)) {
            return null;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        float f2 = minecraftClient.method_22683() != null ? (float)Math.max(1, minecraftClient.method_22683().method_4495()) : 2.0f;
        int n = Math.max(8, Math.min(256, Math.round(f * f2 * vdn.renderScale())));
        String string2 = string + a.d("\u5fa8", 462345909, 848529756) + n;
        uok uok2 = hie.get(string2);
        if (uok2 != null) {
            return uok2;
        }
        try {
            object = hic.get(string);
            if (object == null && a.b("\uf04f\u89e6\u032c", 1233317923).equals(string)) {
                object = evi.image();
                if (object == null) {
                    return null;
                }
                hic.put(string, (BufferedImage)object);
            }
            if (object == null) {
                autoCloseable = ezj.open(a.b("\ub0ea\uc912\u43cb\uddb9\u5676\ud09f\u6a82\ue364\u7d2c\uf788\u704e\u8a2c\u04fa\u9d17", -1090211637) + string + a.b("\u5cdd\u2532\uafff\u3187", -1934861065));
                try {
                    if (autoCloseable == null) {
                        throw new IllegalStateException(a.b("\uf889\u813c\u0bf5\u9584\u1e49\u98ff\u22a5\uab13\u3543\ubfbb\u3862\uc210\u4cdf\ud536\u5f2b\ud9cd\u6395\uec51\u76f7\uf0b5\u7943\u034e", 112457970) + string + a.d("\u92ba\ueb55\u6198\uffe0", 542382319, 2103544447));
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
            uok2 = uok.upload(a.c(-1649601498, "\u1440\u6de6\ue722\u7946\uf284\u7426\uce27") + string2, hia.hio((BufferedImage)object, n), false);
        }
        catch (Throwable throwable) {
            hid.add(string);
            System.out.println(a.d("\u5695\u2f33\ua5f7\u3b93\ub051\u36f3\u8cf2", -1512563420, 1249725399) + string + a.c(-1662569589, "\u33a5\u4a41\uc089\u5ef7\ud537\u5391\ue9ca\u603e\ufe6c\u74de\uf303\u097b\u87f3\u1e58") + throwable);
            return null;
        }
        hie.put(string2, uok2);
        while (hie.size() > 8) {
            object = hie.entrySet().iterator();
            autoCloseable = (uok)((Map.Entry)object.next()).getValue();
            object.remove();
            hif.put((uok)autoCloseable, unf.frame());
        }
        long l = unf.frame();
        hif.entrySet().removeIf(entry -> {
            if (l - (Long)entry.getValue() > 3L) {
                ((uok)entry.getKey()).close();
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
        OWN = a.b("\ua7a2\ude0b\u54c1", 1653516238);
        IDS = new String[]{a.b("\ud153\ua8e7\u2226", -1478962912), a.d("\ud03a\ua989\u234f", 656665642, 156974192), a.b("\ufe94\u8727\u0df5\u9381\u1858\u9ef5", -1792213249)};
        SLOTS = new String[]{a.c(2033973355, "\uf818\u81ac\u0b6d"), a.b("\u6233\u1b80\u9146", 1019241043), a.d("\u036c\u7adf\uf00d\u6e79\ue5a0\u630d", 1311606500, -592214557), a.b("\u455a\u3cf3\ub639", 1249723702)};
        hic = new HashMap<String, BufferedImage>();
        hid = new HashSet<String>();
        hie = new LinkedHashMap<String, uok>();
        hif = new LinkedHashMap<uok, Long>();
        hig = IDS[0];
        hih = "";
    }

    private static /* synthetic */ int aas(int n, int n2) {
        return (n ^ n2) + 1090617823;
    }
}

