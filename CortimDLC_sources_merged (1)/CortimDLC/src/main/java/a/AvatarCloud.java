/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.PanicShutdown;
import a.CloudSync;
import a.CloudEndpoint;
import flow.dev.StringDecryptor;
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

public final class AvatarCloud {
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

    private AvatarCloud() {
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
            AvatarCloud.refresh();
        }
    }

    public static void refresh() {
        long l = System.currentTimeMillis();
        if (l - evr < 10000L || PanicShutdown.armed() || LoaderInfo.token().isBlank()) {
            return;
        }
        if (!evm.compareAndSet(false, true)) {
            return;
        }
        evr = l;
        Thread thread = new Thread(() -> {
            try {
                AvatarCloud.evw();
            }
            catch (Throwable throwable) {
            }
            finally {
                evm.set(false);
            }
        }, "cloud-a");
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
        HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create(CloudSync.endpoint() + "/api/avatar")).timeout(Duration.ofSeconds(20L)).header("authorization", "Bearer " + LoaderInfo.token()).header("x-hwid", CloudEndpoint.get()).GET();
        if (evn != null && !evo.isEmpty()) {
            builder.header("if-none-match", evo);
        }
        if ((n = (httpResponse = AvatarCloud.evv().send(builder.build(), HttpResponse.BodyHandlers.ofByteArray())).statusCode()) == 304) {
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
        BufferedImage bufferedImage = AvatarCloud.evx(httpResponse.body());
        if (bufferedImage == null) {
            return;
        }
        evn = bufferedImage;
        evo = httpResponse.headers().firstValue("etag").orElse("");
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

