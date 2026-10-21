/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vyz;
import flow.dev.StringDecryptor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class FileWriter {
    private static final ExecutorService vzb = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Flow2 file writer");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    });
    private static /* synthetic */ long vzc;
    private static /* synthetic */ String vzd;

    private FileWriter() {
    }

    public static void later(String string, vyz vyz2) {
        vzb.execute(() -> {
            try {
                vyz2.run();
            }
            catch (Exception exception) {
                System.out.println("can't save " + string + ": " + exception);
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

