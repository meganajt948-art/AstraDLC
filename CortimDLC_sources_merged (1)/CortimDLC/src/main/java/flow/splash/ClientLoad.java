/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_310
 *  net.minecraft.class_4011
 *  net.minecraft.class_4071
 */
package flow.splash;

import a.CloudSync;
import a.LoadProgress;
import a.FontPreview;
import a.FontFace;
import a.Lang;
import com.mojang.blaze3d.systems.RenderSystem;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BooleanSupplier;
import net.minecraft.class_310;
import net.minecraft.class_4011;
import net.minecraft.class_4071;

public final class ClientLoad
implements class_4011 {
    private static final long FRAME_BUDGET_NS = 7000000L;
    private static final long STEP_MAX_MS = 6000L;
    private static final long WARM_MAX_MS = 25000L;
    public static final ClientLoad INSTANCE = new ClientLoad();
    private static volatile Phase phase = Phase.DOWNLOAD;
    private static final CompletableFuture<Void> DONE = new CompletableFuture();
    private static final Deque<BooleanSupplier> STEPS = new ArrayDeque<BooleanSupplier>();
    private static int stepsTotal;
    private static int stepsDone;
    private static long stepSince;
    private static long warmSince;
    private static volatile boolean started;
    private static volatile boolean shown;
    private static volatile boolean fallback;
    private static volatile String stage;

    private ClientLoad() {
    }

    public static synchronized void start(Runnable boot, boolean overlay) {
        if (started) {
            return;
        }
        started = true;
        Thread worker = new Thread(() -> ClientLoad.run(boot, overlay), "Flow2 loading");
        worker.setDaemon(true);
        worker.start();
    }

    private static void run(Runnable boot, boolean overlay) {
        class_310 mc2;
        stage = Lang.chosen() && !Lang.ru() ? "Downloading files" : "\u0421\u043a\u0430\u0447\u0438\u0432\u0430\u0435\u043c \u0444\u0430\u0439\u043b\u044b";
        Thread files = new Thread(LoadProgress::run, "Flow2 prefetch");
        files.setDaemon(true);
        files.start();
        while (files.isAlive()) {
            mc2 = class_310.method_1551();
            if (overlay && mc2 != null && mc2.method_22683() != null && !shown && !fallback) {
                mc2.execute(() -> ClientLoad.show(mc2));
            }
            try {
                files.join(100L);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        try {
            CloudSync.ensureLoaded();
        }
        catch (Throwable mc2) {
            // empty catch block
        }
        try {
            Cosmetics.items();
        }
        catch (Throwable t) {
            System.out.println("[Flow2] cosmetics list not ready: " + t);
        }
        mc2 = class_310.method_1551();
        for (int i = 0; mc2 == null && i < 1200; ++i) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException e) {
                return;
            }
            mc2 = class_310.method_1551();
        }
        if (mc2 == null) {
            return;
        }
        phase = Phase.BOOT;
        stage = Lang.chosen() && !Lang.ru() ? "Starting the client" : "\u0417\u0430\u043f\u0443\u0441\u043a\u0430\u0435\u043c \u043a\u043b\u0438\u0435\u043d\u0442";
        class_310 client = mc2;
        client.execute(() -> {
            try {
                if (overlay) {
                    ClientLoad.show(client);
                }
                boot.run();
            }
            catch (Throwable t) {
                System.out.println("[Flow2] boot failed: " + t);
                t.printStackTrace();
            }
            finally {
                if (overlay && !shown) {
                    fallback = true;
                    Splash.requestAfterInject();
                }
                ClientLoad.warmUp();
            }
        });
    }

    private static void show(class_310 mc) {
        if (shown || fallback || phase == Phase.DONE) {
            return;
        }
        class_4071 current = mc.method_18506();
        if (current != null) {
            return;
        }
        shown = true;
        mc.method_18502((class_4071)new FlowSplash(mc, INSTANCE, ClientLoad::ignore, true, true));
    }

    private static void ignore(Optional<Throwable> result) {
    }

    private static void warmUp() {
        ArrayList<BooleanSupplier> steps = new ArrayList<BooleanSupplier>();
        try {
            FontPreview.steps(steps);
        }
        catch (Throwable t) {
            System.out.println("[Flow2] menu warm-up skipped: " + t);
        }
        try {
            for (CosmeticItem it : Cosmetics.items()) {
                steps.add(() -> {
                    Cosmetics.warm(it);
                    return true;
                });
            }
        }
        catch (Throwable t) {
            System.out.println("[Flow2] cosmetics warm-up skipped: " + t);
        }
        STEPS.addAll(steps);
        stepsTotal = STEPS.size();
        stepsDone = 0;
        stepSince = warmSince = System.currentTimeMillis();
        stage = Lang.ru() || !Lang.chosen() ? "\u0413\u043e\u0442\u043e\u0432\u0438\u043c \u043a\u043e\u0441\u043c\u0435\u0442\u0438\u043a\u0443 \u0438 \u043c\u0435\u043d\u044e" : "Preparing cosmetics and menus";
        phase = Phase.WARM;
        if (STEPS.isEmpty()) {
            ClientLoad.finish();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void frame() {
        if (phase != Phase.WARM || !RenderSystem.isOnRenderThread()) {
            return;
        }
        long start = System.nanoTime();
        long now = System.currentTimeMillis();
        if (now - warmSince > 25000L) {
            System.out.println("[Flow2] warm-up cut short, " + STEPS.size() + " left for first use");
            STEPS.clear();
        }
        while (!STEPS.isEmpty() && System.nanoTime() - start < 7000000L) {
            boolean finished;
            BooleanSupplier step = STEPS.peekFirst();
            try {
                finished = step.getAsBoolean();
            }
            catch (Throwable t) {
                finished = true;
            }
            finally {
                FontFace.setRenderScale(1.0f);
            }
            if (finished || System.currentTimeMillis() - stepSince > 6000L) {
                STEPS.pollFirst();
                ++stepsDone;
                stepSince = System.currentTimeMillis();
                continue;
            }
            STEPS.pollFirst();
            STEPS.addLast(step);
            if (STEPS.size() != 1) continue;
            break;
        }
        if (STEPS.isEmpty()) {
            ClientLoad.finish();
        }
    }

    private static void finish() {
        if (phase == Phase.DONE) {
            return;
        }
        phase = Phase.DONE;
        stage = "";
        System.out.println("[Flow2] client ready, " + stepsDone + "/" + stepsTotal + " things warmed up in " + (System.currentTimeMillis() - warmSince) + " ms");
        DONE.complete(null);
    }

    public static boolean done() {
        return phase == Phase.DONE;
    }

    public static String stage() {
        return stage;
    }

    public static float fraction() {
        return switch (phase.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> 0.7f * LoadProgress.fraction();
            case 1 -> 0.74f;
            case 2 -> 0.76f + 0.24f * (stepsTotal <= 0 ? 1.0f : (float)stepsDone / (float)stepsTotal);
            case 3 -> 1.0f;
        };
    }

    public CompletableFuture<?> method_18364() {
        return DONE;
    }

    public float method_18229() {
        return ClientLoad.fraction();
    }

    static {
        stage = "";
    }

    private static enum Phase {
        DOWNLOAD,
        BOOT,
        WARM,
        DONE;

    }
}

