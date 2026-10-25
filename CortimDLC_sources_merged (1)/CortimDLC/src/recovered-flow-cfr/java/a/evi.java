/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dry;
import a.ewk;
import a.eya;
import flow.dev.a;
import flow.util.LoaderInfo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public final class evi {
    private static final long evj = 10000L;
    private static final int evk = 0x200000;
    private static final int evl = 4096;
    private static final AtomicBoolean evm = new AtomicBoolean();
    private static volatile BufferedImage evn;
    private static volatile String evo;
    private static volatile boolean evp;
    private static volatile int evq;
    private static volatile long evr;
    private static HttpClient evs;
    private static /* synthetic */ boolean evt;
    private static /* synthetic */ long evu;

    private evi() {
    }

    public static BufferedImage image() {
        return evn;
    }

    public static String etag() {
        return evo;
    }

    public static boolean known() {
        return evp;
    }

    public static int version() {
        return evq;
    }

    public static void boot() {
        if (evr == 0L) {
            evi.refresh();
        }
    }

    public static void refresh() {
        long l = System.currentTimeMillis();
        if (l - evr < 10000L || dry.armed() || LoaderInfo.token().isBlank()) {
            return;
        }
        if (!evm.compareAndSet(false, true)) {
            return;
        }
        evr = l;
        Thread thread = new Thread(() -> {
            try {
                evi.evw();
            }
            catch (Throwable throwable) {
            }
            finally {
                evm.set(false);
            }
        }, a.c(1086235517, "\ua319\udaa7\u5077\uce1c\u45da\uc322\u793d"));
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    private static synchronized HttpClient evv() {
        if (evs == null) {
            evs = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
        }
        return evs;
    }

    private static void evw() throws Exception {
        HttpResponse<byte[]> httpResponse;
        int n;
        HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create(ewk.endpoint() + a.b("\u592f\u20d0\uaa12\u347a\ubfeb\u3914\u8350\u0ab6\u94fc\u1e58\u9998", -929605365))).timeout(Duration.ofSeconds(20L)).header(a.d("\u3b25\u4280\uc852\u563f\uddef\u5b43\ue10b\u68e9\uf6ad\u7c09\ufbc7\u01b0\u8f66", 1871235344, 1157558873), a.c(1364330743, "\u08b2\u7124\ufbf3\u6591\uee51\u68f7\ud2f6") + LoaderInfo.token()).header(a.d("\uf374\u8a90\u0006\u9e68\u15a1\u931d", 2025088552, 191141154), eya.get()).GET();
        if (evn != null && !evo.isEmpty()) {
            builder.header(a.c(384634344, "\u0d8c\u7432\ufeaa\u6098\ueb4e\u6dfe\ud7a6\u5e1f\uc000\u4abd\ucd7b\u371d\ub9c1"), evo);
        }
        if ((n = (httpResponse = evi.evv().send(builder.build(), HttpResponse.BodyHandlers.ofByteArray())).statusCode()) == 304) {
            evp = true;
            return;
        }
        if (n == 404) {
            if (evn != null) {
                evn = null;
                evo = "";
                ++evq;
            }
            evp = true;
            return;
        }
        if (n != 200 || httpResponse.body().length == 0 || httpResponse.body().length > 0x200000) {
            return;
        }
        BufferedImage bufferedImage = evi.evx(httpResponse.body());
        if (bufferedImage == null) {
            return;
        }
        evn = bufferedImage;
        evo = httpResponse.headers().firstValue(a.d("\u3eee\u474e\ucd88\u53ff", -1399358133, -751811644)).orElse("");
        evp = true;
        ++evq;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BufferedImage evx(byte[] byArray) throws Exception {
        try (ImageInputStream imageInputStream = ImageIO.createImageInputStream(new ByteArrayInputStream(byArray));){
            ImageReader imageReader;
            block13: {
                Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
                if (!iterator.hasNext()) {
                    BufferedImage bufferedImage = null;
                    return bufferedImage;
                }
                imageReader = iterator.next();
                try {
                    imageReader.setInput(imageInputStream, true, true);
                    if (imageReader.getWidth(0) <= 4096 && imageReader.getHeight(0) <= 4096) break block13;
                    BufferedImage bufferedImage = null;
                    imageReader.dispose();
                    return bufferedImage;
                }
                catch (Throwable throwable) {
                    imageReader.dispose();
                    throw throwable;
                }
            }
            BufferedImage bufferedImage = imageReader.read(0);
            imageReader.dispose();
            return bufferedImage;
        }
    }

    static {
        evo = "";
    }

    private static /* synthetic */ int lg(int n, int n2) {
        return n ^ n2 | 0x5B3BBAF4;
    }
}

