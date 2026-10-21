/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.class_156
 *  net.minecraft.class_156$class_158
 */
package a;

import a.jgd;
import a.FrameDelta;
import a.GpuTexture;
import a.Lang;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.StringDecryptor;
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
import net.minecraft.class_156;

public final class NowPlaying {
    private static final String jgo = "/flow/media/now-playing.ps1";
    private static final long jgp = 8000L;
    private static final int jgq = 5;
    private static final int jgr = 96;
    private static final ExecutorService jgs = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Flow2 now playing control");
        thread.setDaemon(true);
        return thread;
    });
    private static volatile jgd jgt;
    private static volatile String jgu;
    private static volatile long jgv;
    private static volatile BufferedImage jgw;
    private static volatile String jgx;
    private static volatile int jgy;
    private static GpuTexture jgz;
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

    private NowPlaying() {
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
            return Lang.t(jgu);
        }
        String string = jgd2.jgg.isEmpty() ? jgd2.jgf : jgd2.jgf + " — " + jgd2.jgg;
        return (jgd2.jgh ? "" : Lang.s("Paused · ", "Пауза · ")) + string;
    }

    public static boolean supported() {
        return class_156.method_668() == class_156.class_158.field_1133;
    }

    public static synchronized void tick(boolean bl) {
        BufferedImage bufferedImage;
        NowPlaying.jhs();
        if (!NowPlaying.supported()) {
            jgu = "Windows only";
            return;
        }
        if (!bl) {
            if (jhd != null) {
                NowPlaying.jhl();
            }
            jgu = "Off";
            return;
        }
        long l = System.currentTimeMillis();
        if (jhd == null && l >= jhf) {
            if (jhg >= 5) {
                jgu = "Unavailable";
                return;
            }
            NowPlaying.jhk();
        }
        if ((bufferedImage = jgw) != null) {
            jgw = null;
            if (jgz != null) {
                jhc.add(new Object[]{jgz, FrameDelta.frame()});
            }
            jgz = GpuTexture.upload("cover", bufferedImage, false);
            jha = jgx;
            jhb = jgy;
        }
    }

    public static GpuTexture cover() {
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
        if (jgd2 != null && string.equals("toggle")) {
            jgt = new jgd(jgd2.jge, jgd2.jgf, jgd2.jgg, !jgd2.jgh, jgd2.position(), jgd2.jgj, System.currentTimeMillis());
        }
        jgs.execute(() -> {
            try {
                writer.write(string + "\n");
                writer.flush();
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
    }

    public static synchronized void shutdown() {
        NowPlaying.jhl();
        jhf = Long.MAX_VALUE;
    }

    private static void jhk() {
        try {
            Process process;
            String string;
            try (Object object2 = NowPlaying.class.getResourceAsStream("/flow/media/now-playing.ps1");){
                if (object2 == null) {
                    throw new IllegalStateException("missing /flow/media/now-playing.ps1");
                }
                string = new String(((InputStream)object2).readAllBytes(), StandardCharsets.UTF_8);
            }
            object2 = new StringBuilder(string.length());
            for (String string2 : string.split("\r?\n")) {
                String string3 = string2.strip();
                if (string3.isEmpty() || string3.startsWith("#")) continue;
                ((StringBuilder)object2).append(string2).append('\n');
            }
            String string4 = Base64.getEncoder().encodeToString(((StringBuilder)object2).toString().getBytes(StandardCharsets.UTF_16LE));
            ProcessBuilder processBuilder = new ProcessBuilder(NowPlaying.jhn(), "-NoProfile", "-NonInteractive", "-ExecutionPolicy", "Bypass", "-EncodedCommand", string4);
            processBuilder.redirectError(ProcessBuilder.Redirect.DISCARD);
            jhd = process = processBuilder.start();
            jhe = new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8);
            jgu = "Starting…";
            Thread thread = new Thread(() -> NowPlaying.jho(process), "Flow2 now playing");
            thread.setDaemon(true);
            thread.start();
            if (!jhh) {
                jhh = true;
                Runtime.getRuntime().addShutdownHook(new Thread(NowPlaying::shutdown, "Flow2 now playing stop"));
            }
        }
        catch (Exception exception) {
            System.out.println("[Flow2] now playing unavailable: " + exception);
            NowPlaying.jhm();
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
        jgu = ++jhg >= 5 ? "Unavailable" : "Restarting…";
        jhf = System.currentTimeMillis() + 8000L * (long)jhg;
    }

    private static String jhn() {
        Path path;
        String string = System.getenv("SystemRoot");
        if (string != null && Files.isRegularFile(path = Path.of(string, "System32", "WindowsPowerShell", "v1.0", "powershell.exe"), new LinkOption[0])) {
            return path.toString();
        }
        return "powershell.exe";
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
                    if (string.startsWith("STATE ")) {
                        NowPlaying.jhp(string.substring(6));
                        continue;
                    }
                    if (string.startsWith("ART ")) {
                        NowPlaying.jhq(string.substring(4));
                        continue;
                    }
                    if (string.equals("NONE")) {
                        jgt = null;
                        jgu = "Nothing playing";
                        continue;
                    }
                    if (!string.startsWith("ERR ")) continue;
                    System.out.println("[Flow2] now playing: " + string.substring(4));
                }
            }
            finally {
                ((BufferedReader)object).close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        object = NowPlaying.class;
        synchronized (NowPlaying.class) {
            if (jhd != process) {
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return;
            }
            if (bl) {
                jhg = 0;
            }
            NowPlaying.jhm();
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    private static void jhp(String string) {
        try {
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            String string2 = jsonObject.get("title").getAsString().trim();
            if (string2.isEmpty()) {
                jgt = null;
                jgu = "Nothing playing";
                return;
            }
            jgd jgd2 = new jgd(jsonObject.get("app").getAsString(), string2, jsonObject.get("artist").getAsString().trim(), jsonObject.get("playing").getAsBoolean(), jsonObject.get("pos").getAsLong(), jsonObject.get("dur").getAsLong(), System.currentTimeMillis());
            jgd jgd3 = jgt;
            if (jgd3 == null || !jgd3.key().equals(jgd2.key())) {
                jgv = System.currentTimeMillis();
            }
            jgt = jgd2;
            jgu = jgd2.jgh ? "Playing" : "Paused";
        }
        catch (RuntimeException runtimeException) {
            System.out.println("[Flow2] now playing: bad report " + runtimeException);
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
            jgy = NowPlaying.jhr(bufferedImage2);
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
        long l = FrameDelta.frame();
        jhc.removeIf(objectArray -> {
            if (l - (Long)objectArray[1] > 2L) {
                ((GpuTexture)objectArray[0]).close();
                return true;
            }
            return false;
        });
    }

    static {
        jgu = "Off";
        jhc = new ArrayList<Object[]>();
    }

    private static /* synthetic */ int ank(int n, int n2) {
        return (n ^ n2) + 71743609;
    }
}

