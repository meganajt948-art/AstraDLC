/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 */
package a;

import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;

public final class DevInject {
    private static final String fzm = System.getenv("FLOW2_DEV_INJECT");
    private static /* synthetic */ boolean fzn;
    private static /* synthetic */ String fzo;

    private DevInject() {
    }

    public static boolean intercept(Flow flow) {
        int n;
        long l;
        if (fzm == null || fzm.isBlank()) {
            return false;
        }
        try {
            l = Long.parseLong(fzm.trim());
            n = Integer.parseInt(System.getenv().getOrDefault("FLOW2_DEV_INJECT_SHOTS", "30").trim());
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        Thread thread = new Thread(() -> {
            DevInject.fzp(l);
            long l2 = System.currentTimeMillis();
            System.out.println("dev inject: start() off the game's thread");
            flow.start();
            flow.injected();
            System.out.println("dev inject: start() + injected() returned after " + (System.currentTimeMillis() - l2) + " ms (the loader is done now)");
            class_310 class_3102 = class_310.method_1551();
            int n2 = 0;
            while (n2 < n) {
                DevInject.fzp(1000L);
                int n3 = n2++;
                class_3102.execute(() -> class_318.method_22690((File)class_3102.field_1697, (String)("flow2-inject-" + n3 + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {}));
            }
        }, "dev inject");
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    private static void fzp(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    private static /* synthetic */ int sn(int n, int n2) {
        return n * n2 + -121230845;
    }
}

