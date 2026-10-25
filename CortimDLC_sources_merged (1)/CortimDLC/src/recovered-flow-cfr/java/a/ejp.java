/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dtv;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class ejp {
    static final ReentrantLock LOCK = new ReentrantLock(true);
    static volatile dtv active;
    static volatile boolean any;
    private static /* synthetic */ String ejq;
    private static /* synthetic */ long ejr;

    private ejp() {
    }

    public static boolean isActive() {
        return active != null;
    }

    public static dtv current() {
        return active;
    }

    public static boolean anyBots() {
        return any;
    }

    public static boolean lockMain() {
        if (!any) {
            return false;
        }
        try {
            return LOCK.tryLock(40L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public static void unlockMain() {
        LOCK.unlock();
    }

    private static /* synthetic */ int fg(int n, int n2) {
        return (n ^ n2) + 1811149065;
    }

    private static /* synthetic */ int fh(int n, int n2) {
        return n * n2 ^ 0x4AE7D5F2;
    }

    private static /* synthetic */ int fi(int n, int n2) {
        return (n ^ n2) + 974560663;
    }
}

