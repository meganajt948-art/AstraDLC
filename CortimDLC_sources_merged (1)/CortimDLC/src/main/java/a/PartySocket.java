/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package a;

import a.uhc;
import a.uhd;
import flow.dev.StringDecryptor;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_310;

final class PartySocket {
    private static final HttpClient uhh = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();
    private static final ExecutorService uhi = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Flow2 party");
        thread.setDaemon(true);
        return thread;
    });
    private final uhc uhj;
    private final AtomicBoolean uhk = new AtomicBoolean();
    private final StringBuilder uhl = new StringBuilder();
    private volatile WebSocket uhm;
    private static /* synthetic */ long uhn;
    private static /* synthetic */ int uho;

    PartySocket(URI uRI, uhc uhc2) {
        this.uhj = uhc2;
        uhh.newWebSocketBuilder().connectTimeout(Duration.ofSeconds(10L)).buildAsync(uRI, new uhd(this)).whenComplete((webSocket, throwable) -> {
            if (throwable != null) {
                this.uhp(-1, PartySocket.uhq(throwable));
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
                this.uhp(-1, PartySocket.uhq(exception));
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
                    webSocket.sendClose(1000, "bye").get(2L, TimeUnit.SECONDS);
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
            PartySocket.uhr(() -> this.uhj.closed(this, n, string));
        }
    }

    private static String uhq(Throwable throwable) {
        while (throwable.getCause() != null && throwable.getCause() != throwable) {
            throwable = throwable.getCause();
        }
        String string = throwable.getMessage();
        return throwable.getClass().getSimpleName() + (string != null ? ": " + string : "");
    }

    private static void uhr(Runnable runnable) {
        class_310.method_1551().execute(runnable);
    }

    private static /* synthetic */ int cwu(int n, int n2) {
        return n ^ n2 | 0x4BD730EA;
    }
}

