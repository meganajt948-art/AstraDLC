/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.util.Util
 *  net.minecraft.util.Util$OperatingSystem
 */
package a;

import a.jgd;
import a.unf;
import a.uok;
import a.wap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import net.minecraft.util.Util;

public final class jgn {
    private static final String jgo = a.d("\ueb81\u9279\u18a0\u86d2\u0d1d\u8bf4\u31e5\ub81c\u2642\uacfe\u2b25\ud11a\u5f8c\uc63c\u4c77\ucadc\u70ce\uff03\u65bd\ue3f4\u6a13\u1045\u9eff\u0567\u8346\u0994\ub065", -1695641948, 591226129);
    private static final long jgp = 8000L;
    private static final int jgq = 5;
    private static final int jgr = 96;
    private static final ExecutorService jgs = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, a.c(-1395982246, "\u0005\u799e\uf34e\u6d27\ue6b5\u6016\uda0b\u53fb\ucdbc\u475a\uc0d9\u3ab4\ub46e\u2dc7\ua784\u2172\u9b34\u14a2\u8e52\u080f\u81f9\ufbb2\u7507\ueecb\u68b7"));
        thread.setDaemon(true);
        return thread;
    });
    private static volatile jgd jgt;
    private static volatile String jgu;
    private static volatile long jgv;
    private static volatile BufferedImage jgw;
    private static volatile String jgx;
    private static volatile int jgy;
    private static uok jgz;
    private static String jha;
    private static int jhb;
    private static final List<Object[]> jhc;
    private static Process jhd;
    private static Writer jhe;
    private static long jhf;
    private static int jhg;
    private static boolean jhh;
    private static /* synthetic */ String jhi;
    private static /* synthetic */ String jhj;

    private jgn() {
    }

    public static jgd track() {
        return jgt;
    }

    public static long changedAt() {
        return jgv;
    }

    public static String summary() {
        jgd jgd2 = jgt;
        if (jgd2 == null) {
            return wap.t(jgu);
        }
        String string = jgd2.jgg.isEmpty() ? jgd2.jgf : jgd2.jgf + a.c(-1089893826, "\u8a1d\ud398\u797f") + jgd2.jgg;
        return (jgd2.jgh ? "" : wap.s(a.b("\u91b8\ue838\u62ff\ufc88\u7749\uf1f9\u4bee\uc288\u5c40", -1635806751), a.c(1549672490, "\u243d\u5da3\ud703\u4906\uc2d6\u4077\ufab3\u73d5"))) + string;
    }

    public static boolean supported() {
        return Util.getOperatingSystem() == Util.OperatingSystem.WINDOWS;
    }

    public static synchronized void tick(boolean bl) {
        BufferedImage bufferedImage;
        jgn.jhs();
        if (!jgn.supported()) {
            jgu = a.d("\u7b70\u02ff\u882b\u1650\u9d8c\u1b25\ua172\u28d0\ub6c0\u3c70\ubba1\u41c5", -2001992774, 1127839889);
            return;
        }
        if (!bl) {
            if (jhd != null) {
                jgn.jhl();
            }
            jgu = a.c(-1717896586, "\ufa3a\u83a2\u0971");
            return;
        }
        long l = System.currentTimeMillis();
        if (jhd == null && l >= jhf) {
            if (jhg >= 5) {
                jgu = a.b("\u8557\ufcdd\u7601\ue867\u63a7\ue51e\u5f48\ud6b4\u48e8\uc257\u458d", -336100087);
                return;
            }
            jgn.jhk();
        }
        if ((bufferedImage = jgw) != null) {
            jgw = null;
            if (jgz != null) {
                jhc.add(new Object[]{jgz, unf.frame()});
            }
            jgz = uok.upload(a.b("\u08ab\u7116\ufbdc\u65be\uee7e", -1611396915), bufferedImage, false);
            jha = jgx;
            jhb = jgy;
        }
    }

    public static uok cover() {
        jgd jgd2 = jgt;
        if (jgd2 == null || jgz == null) {
            return null;
        }
        boolean bl = jgd2.key().equals(jha) || System.currentTimeMillis() - jgv < 3000L;
        return bl ? jgz : null;
    }

    public static int coverColor() {
        return jhb;
    }

    public static synchronized void command(String string) {
        Writer writer = jhe;
        if (writer == null) {
            return;
        }
        jgd jgd2 = jgt;
        if (jgd2 != null && string.equals(a.d("\ud14c\ua8e6\u223d\ubc4c\u3790\ub128", 1453051872, -1753997602))) {
            jgt = new jgd(jgd2.jge, jgd2.jgf, jgd2.jgg, !jgd2.jgh, jgd2.position(), jgd2.jgj, System.currentTimeMillis());
        }
        jgs.execute(() -> {
            try {
                writer.write(string + a.c(1933145530, "\u75b1"));
                writer.flush();
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
    }

    public static synchronized void shutdown() {
        jgn.jhl();
        jhf = Long.MAX_VALUE;
    }

    private static void jhk() {
        try {
            Process process;
            String string;
            try (Object object2 = jgn.class.getResourceAsStream(a.d("\u58df\u2127\uabfe\u358c\ube43\u38aa\u82bb\u0b42\u951c\u1fa0\u987b\u6244\uecd2\u7562\uff29\u7982\uc390\u4c5d\ud6e3\u50aa\ud94d\ua31b\u2da1\ub639\u3018\ubaca\u033b", -632328891, -770624082));){
                if (object2 == null) {
                    throw new IllegalStateException(a.d("\ub20b\ucbbe\u4177\udf06\u54cb\ud27d\u6827\ue191\u7fc1\uf539\u72e0\u8892\u065d\u9fb4\u15a5\u935c\u2912\ua6ce\u3c75\uba6a\u33dc\u498c\uc727\u5cac\uda8e\u5043\ue9fd\u67b4\ufd53\u7b05\uf0bf\u0e27\u8436\u1dc4\u9bd5", -468076586, -1715141229));
                }
                string = new String(((InputStream)object2).readAllBytes(), StandardCharsets.UTF_8);
            }
            object2 = new StringBuilder(string.length());
            for (String string2 : string.split(a.b("\u9701\uee82\u6464", 461412111))) {
                String string3 = string2.strip();
                if (string3.isEmpty() || string3.startsWith(a.b("\u088b", 272173225))) continue;
                ((StringBuilder)object2).append(string2).append('\n');
            }
            String string4 = Base64.getEncoder().encodeToString(((StringBuilder)object2).toString().getBytes(StandardCharsets.UTF_16LE));
            ProcessBuilder processBuilder = new ProcessBuilder(jgn.jhn(), a.d("\u9bc2\ue210\u68e2\uf6ac\u7d59\ufbf5\u41af\uc851\u560b\udcb3", 1278059558, -2044969021), a.c(-1377521813, "\uaf49\ud69b\u5c69\uc219\u49e9\ucf7f\u7536\ufcd6\u629e\ue83c\u6fed\u958b\u1b41\u82ef\u08af"), a.b("\u1cc0\u6519\ueff7\u719b\ufa4a\u7ced\uc6bf\u4f53\ud10a\u5bba\udc57\u2619\ua8cd\u3179\ubb20\u3dcb", 330308861), a.d("\ud636\uafbc\u2566\ubb06\u30c3\ub672", -1178783379, 390719263), a.c(664564522, "\u7308\u0ad1\u8029\u1e55\u958e\u1334\ua966\u2096\ubeee\u3473\ub3a2\u49d3\uc708\u5eb6\ud4ef"), string4);
            processBuilder.redirectError(ProcessBuilder.Redirect.DISCARD);
            jhd = process = processBuilder.start();
            jhe = new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8);
            jgu = a.b("\u7598\u0c0e\u86c8\u18aa\u937b\u15d7\uaf83\u267b\u9865", 2044753346);
            Thread thread = new Thread(() -> jgn.jho(process), a.d("\uf93a\u80a1\u0a71\u9418\u1f8a\u9929\u2334\uaac4\u3483\ube65\u39e6\uc38b\u4d51\ud4f8\u5ebb\ud84d\u620b", 1080463459, -1569298162));
            thread.setDaemon(true);
            thread.start();
            if (!jhh) {
                jhh = true;
                Runtime.getRuntime().addShutdownHook(new Thread(jgn::shutdown, a.d("\uc17e\ub8e5\u3235\uac5c\u27ce\ua16d\u1b70\u9280\u0cc7\u8621\u01a2\ufbcf\u7515\uecbc\u66ff\ue009\u5a4f\ud5d9\u4f39\uc96f\u4083\u3acd", 903492702, -837946000)));
            }
        }
        catch (Exception exception) {
            System.out.println(a.c(-2065117516, "\ucece\ub762\u3d9b\ua3e9\u2826\uaed2\u14ee\u9d62\u0373\u89c3\u0e08\uf42e\u7aa9\ue304\u695a\uefb3\u55ec\uda3a\u4080\uc696\u4f34\u357e\ubbc2\u2004\ua66c\u2cb5\u9503\u1b5f\u81ab\u07f4\u8c4e\u72c0\uf895") + exception);
            jgn.jhm();
        }
    }

    private static synchronized void jhl() {
        Process process = jhd;
        jhd = null;
        jgt = null;
        if (jhe != null) {
            try {
                jhe.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            jhe = null;
        }
        if (process != null) {
            process.destroy();
        }
    }

    private static synchronized void jhm() {
        jhd = null;
        jhe = null;
        jgt = null;
        jgu = ++jhg >= 5 ? a.d("\uc0cf\ub945\u3399\uadff\u263f\ua086\u1ad0\u932c\u0d70\u87cf\u0015", 1542419032, 1380430537) : a.c(1058830915, "\u7a1a\u039c\u8959\u172f\u9ced\u1a4f\ua01a\u29f6\ub7ae\u3d16\u9a84");
        jhf = System.currentTimeMillis() + 8000L * (long)jhg;
    }

    private static String jhn() {
        Path path;
        String string = System.getenv(a.c(1726359160, "\u2621\u5fba\ud563\u4b15\uc0d3\u466a\ufc06\u75ca\ueb95\u613f"));
        if (string != null && Files.isRegularFile(path = Path.of(string, a.d("\ub169\uc8f2\u422b\udc5d\u579b\ud122\u6b2f\ue2df", -1418368008, 1055185610), a.b("\ud243\uabcc\u2118\ubf63\u34bf\ub216\u0841\u8193\u1ff3\u955a\u129b\ue8fd\u660b\uff81\u75df\uf327\u4968", -591146491), a.d("\u89d8\uf02e\u7ae2\ue48d", -1058817277, 505098921), a.b("\uccc5\ub56b\u3fa0\ua1c3\u2a03\uacb3\u16fb\u9f07\u0151\u8be0\u0c71\uf64b\u7881\ue12d", -1450980165)), new LinkOption[0])) {
            return path.toString();
        }
        return a.b("\u0df5\u745b\ufe90\u60f3\ueb33\u6d83\ud7cb\u5e37\uc061\u4ad0\ucd41\u377b\ub9b1\u201d", 1977617803);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void jho(Process process) {
        Object object;
        boolean bl = false;
        try {
            object = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            try {
                String string;
                while ((string = ((BufferedReader)object).readLine()) != null) {
                    if (!string.isEmpty() && string.charAt(0) == '\ufeff') {
                        string = string.substring(1);
                    }
                    bl = true;
                    if (string.startsWith(a.c(567076173, "\ue518\u9cae\u1668\u880c\u03ca\u851e"))) {
                        jgn.jhp(string.substring(6));
                        continue;
                    }
                    if (string.startsWith(a.c(-1934398473, "\u6bb2\u1210\u98c5\u06c0"))) {
                        jgn.jhq(string.substring(4));
                        continue;
                    }
                    if (string.equals(a.c(870339501, "\u53e7\u2a57\ua085\u3eff"))) {
                        jgt = null;
                        jgu = a.b("\uba10\uc380\u4948\ud725\u5cf3\uda45\u601f\ue9a9\u77a6\ufd0b\u7ad5\u80bc\u0e7b\u97cd\u1d97", -339494319);
                        continue;
                    }
                    if (!string.startsWith(a.b("\uf2b3\u8b15\u01c6\u9fc5", -877006094))) continue;
                    System.out.println(a.c(-510638193, "\u47c1\u3e6d\ub494\u2ae6\ua129\u27dd\u9de1\u146d\u8a7c\u00cc\u8707\u7d21\uf3a6\u6a0b\ue055\u66bc\udce3\u5335\uc98f\u4f83\uc66e") + string.substring(4));
                }
            }
            finally {
                ((BufferedReader)object).close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        object = jgn.class;
        synchronized (jgn.class) {
            if (jhd != process) {
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return;
            }
            if (bl) {
                jhg = 0;
            }
            jgn.jhm();
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    private static void jhp(String string) {
        try {
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            String string2 = jsonObject.get(a.c(-1347011835, "\u3b74\u42d8\uc816\u567f\udda1")).getAsString().trim();
            if (string2.isEmpty()) {
                jgt = null;
                jgu = a.d("\ucc66\ub5f6\u3f3e\ua153\u2a85\uac33\u1669\u9fdf\u01d0\u8b7d\u0ca3\uf6ca\u780d\ue1bb\u6be1", 187430479, -1875166616);
                return;
            }
            jgd jgd2 = new jgd(jsonObject.get(a.d("\u23f7\u5a57\ud084", 634680625, -1137027420)).getAsString(), string2, jsonObject.get(a.c(-1811997005, "\u1ed4\u6776\ueda3\u73cf\uf802\u7eb4")).getAsString().trim(), jsonObject.get(a.d("\u9e88\ue725\u6dfb\uf392\u7855\ufee3\u44b9", -279964226, 1437305665)).getAsBoolean(), jsonObject.get(a.b("\ua2e2\udb4c\u5183", 459121297)).getAsLong(), jsonObject.get(a.b("\u4615\u3fb5\ub561", 244008562)).getAsLong(), System.currentTimeMillis());
            jgd jgd3 = jgt;
            if (jgd3 == null || !jgd3.key().equals(jgd2.key())) {
                jgv = System.currentTimeMillis();
            }
            jgt = jgd2;
            jgu = jgd2.jgh ? a.b("\u4e24\u37a9\ubd77\u231e\ua8d9\u2e6f\u9435", 779112051) : a.b("\u5162\u28e2\ua225\u3c52\ub793\u3123", -331919052);
        }
        catch (RuntimeException runtimeException) {
            System.out.println(a.b("\ub99c\uc030\u4ac9\ud4bb\u5f74\ud980\u63bc\uea30\u7421\ufe91\u795a\u837c\u0dfb\u9456\u1e08\u98e1\u22be\uad68\u37d2\ub1de\u3833\u4220\ucc90\u5744\ud17f\u5bfc\ue258\u6c1c\uf6f4\u70b8\ufb0d\u0588", -788940313) + runtimeException);
        }
    }

    private static void jhq(String string) {
        jgd jgd2 = jgt;
        try {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(string)));
            if (bufferedImage == null || jgd2 == null) {
                return;
            }
            int n = Math.min(bufferedImage.getWidth(), bufferedImage.getHeight());
            BufferedImage bufferedImage2 = new BufferedImage(96, 96, 1);
            Graphics2D graphics2D = bufferedImage2.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int n2 = (bufferedImage.getWidth() - n) / 2;
            int n3 = (bufferedImage.getHeight() - n) / 2;
            graphics2D.drawImage(bufferedImage, 0, 0, 96, 96, n2, n3, n2 + n, n3 + n, null);
            graphics2D.dispose();
            jgy = jgn.jhr(bufferedImage2);
            jgx = jgd2.key();
            jgw = bufferedImage2;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static int jhr(BufferedImage bufferedImage) {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        for (int i = 0; i < bufferedImage.getHeight(); i += 3) {
            for (int j = 0; j < bufferedImage.getWidth(); j += 3) {
                int n = bufferedImage.getRGB(j, i);
                int n2 = n >> 16 & 0xFF;
                int n3 = n >> 8 & 0xFF;
                int n4 = n & 0xFF;
                int n5 = Math.max(n2, Math.max(n3, n4));
                int n6 = Math.min(n2, Math.min(n3, n4));
                double d5 = 0.05 + (double)(n5 - n6) / 255.0 * (0.3 + (double)n5 / 255.0);
                d += (double)n2 * d5;
                d2 += (double)n3 * d5;
                d3 += (double)n4 * d5;
                d4 += d5;
            }
        }
        if (d4 <= 0.0) {
            return -1;
        }
        float[] fArray = Color.RGBtoHSB((int)(d / d4), (int)(d2 / d4), (int)(d3 / d4), null);
        return 0xFF000000 | Color.HSBtoRGB(fArray[0], Math.min(1.0f, fArray[1] * 1.25f), Math.max(0.75f, fArray[2])) & 0xFFFFFF;
    }

    private static void jhs() {
        long l = unf.frame();
        jhc.removeIf(objectArray -> {
            if (l - (Long)objectArray[1] > 2L) {
                ((uok)objectArray[0]).close();
                return true;
            }
            return false;
        });
    }

    static {
        jgu = a.b("\ubf4c\uc6d4\u4c07", -2098348288);
        jhc = new ArrayList<Object[]>();
    }

    private static /* synthetic */ int ank(int n, int n2) {
        return (n ^ n2) + 71743609;
    }
}

