/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package a;

import a.uhc;
import a.uhd;
import flow.dev.a;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.MinecraftClient;

final class uhg {
    private static final HttpClient uhh = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();
    private static final ExecutorService uhi = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, a.d("\u5548\u2cd3\ua603\u386a\ub3f8\u355b\u8f58\u06b8\u98f4\u1243\u959d", -937584473, -397226590));
        thread.setDaemon(true);
        return thread;
    });
    private final uhc uhj;
    private final AtomicBoolean uhk = new AtomicBoolean();
    private final StringBuilder uhl = new StringBuilder();
    private volatile WebSocket uhm;
    private static /* synthetic */ long uhn;
    private static /* synthetic */ int uho;

    uhg(URI uRI, uhc uhc2) {
        this.uhj = uhc2;
        uhh.newWebSocketBuilder().connectTimeout(Duration.ofSeconds(10L)).buildAsync(uRI, new uhd(this)).whenComplete((webSocket, throwable) -> {
            if (throwable != null) {
                this.uhp(-1, uhg.uhq(throwable));
            }
        });
    }

    void send(String string) {
        uhi.execute(() -> {
            WebSocket webSocket = this.uhm;
            if (webSocket == null || this.uhk.get()) {
                return;
            }
            try {
                webSocket.sendText(string, true).get(10L, TimeUnit.SECONDS);
            }
            catch (Exception exception) {
                webSocket.abort();
                this.uhp(-1, uhg.uhq(exception));
            }
        });
    }

    void close() {
        if (!this.uhk.compareAndSet(false, true)) {
            return;
        }
        WebSocket webSocket = this.uhm;
        if (webSocket != null) {
            uhi.execute(() -> {
                try {
                    webSocket.sendClose(1000, a.b("\u240d\u5da7\ud768", -1938086804)).get(2L, TimeUnit.SECONDS);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                webSocket.abort();
            });
        }
    }

    private void uhp(int n, String string) {
        if (this.uhk.compareAndSet(false, true)) {
            WebSocket webSocket = this.uhm;
            if (webSocket != null) {
                webSocket.abort();
            }
            uhg.uhr(() -> this.uhj.closed(this, n, string));
        }
    }

    private static String uhq(Throwable throwable) {
        while (throwable.getCause() != null && throwable.getCause() != throwable) {
            throwable = throwable.getCause();
        }
        String string = throwable.getMessage();
        return throwable.getClass().getSimpleName() + (string != null ? a.c(1142845654, "\u70ee\u0945") + string : "");
    }

    private static void uhr(Runnable runnable) {
        MinecraftClient.method_1551().execute(runnable);
    }

    private static /* synthetic */ int cwu(int n, int n2) {
        return n ^ n2 | 0x4BD730EA;
    }
}

