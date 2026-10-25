/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vyz;
import flow.dev.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class vza {
    private static final ExecutorService vzb = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, a.c(-1306862787, "\udb6a\ua2f1\u2821\ub648\u3dda\ubb79\u016c\u8892\u16c8\u9c70\u1be6\ue1c0\u6f12\uf6b8\u7cf6\ufa16\u404e"));
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    });
    private static /* synthetic */ long vzc;
    private static /* synthetic */ String vzd;

    private vza() {
    }

    public static void later(String string, vyz vyz2) {
        vzb.execute(() -> {
            try {
                vyz2.run();
            }
            catch (Exception exception) {
                System.out.println(a.b("\ud8dc\ua16f\u2bb3\ub58b\u3e0f\ub8ea\u02ea\u8b09\u1541\u9fe3\u1875", 1174460596) + string + a.b("\u1cda\u6571", 547232994) + exception);
            }
        });
    }

    public static void flush() {
        try {
            vzb.submit(() -> {}).get(2L, TimeUnit.SECONDS);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static /* synthetic */ int dmy(int n, int n2) {
        return n - n2 ^ 0xBCBD5330;
    }

    private static /* synthetic */ int dmz(int n, int n2) {
        return n ^ n2 ^ 0xAE3553C9;
    }
}

