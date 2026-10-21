/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_239
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_337
 *  net.minecraft.class_437
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.Bot;
import a.FabricAddonsBridge;
import a.UnsafeUtil;
import a.BotRuntime;
import a.DummyClientParts;
import a.TeleportTimer;
import a.pth;
import a.SilentRotation;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_1297;
import net.minecraft.class_239;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_337;
import net.minecraft.class_437;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;

final class ClientContextSwitcher {
    private static final class_310 edk = class_310.method_1551();
    private static final long edl = UnsafeUtil.offsetOf(edk, edk.method_1483());
    private static final long edm = UnsafeUtil.offsetOf(edk, ClientContextSwitcher.edk.field_1713);
    private static final long edn = UnsafeUtil.offsetOf(edk, ClientContextSwitcher.edk.field_1729);
    private static final long edo = UnsafeUtil.offsetOf(edk, ClientContextSwitcher.edk.field_1769);
    private static final Field edp = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1719", "Lnet/minecraft/class_1297;");
    private static final Field edq = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1752", "I");
    private static final long edr = edp == null ? -1L : UnsafeUtil.U.objectFieldOffset(edp);
    private static final long eds = edq == null ? -1L : UnsafeUtil.U.objectFieldOffset(edq);
    private static final long edt;
    private static final long edu;
    private static class_746 edv;
    private static class_638 edw;
    private static class_636 edx;
    private static class_437 edy;
    private static class_239 edz;
    private static class_1297 eea;
    private static class_1297 eeb;
    private static Object eec;
    private static Object eed;
    private static Object eee;
    private static Object eef;
    private static Object eeg;
    private static int eeh;
    private static boolean eei;
    private static class_337 eej;
    private static pth eek;
    private static boolean eel;
    private static boolean[] eem;
    private static int[] een;
    private static boolean eeo;
    private static boolean eep;
    private static boolean eeq;
    private static boolean eer;
    private static double ees;
    private static boolean eet;
    private static Object[] eeu;
    private static boolean eev;
    private static /* synthetic */ String eew;
    private static /* synthetic */ String eex;

    private ClientContextSwitcher() {
    }

    private static long[] eey() {
        long l = -1L;
        long l2 = -1L;
        try {
            class_304 class_3042 = UnsafeUtil.allocate(class_304.class);
            for (Field field : class_304.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                long l3 = UnsafeUtil.U.objectFieldOffset(field);
                if (field.getType() == Boolean.TYPE && l < 0L) {
                    class_3042.method_23481(true);
                    boolean bl = UnsafeUtil.U.getBoolean(class_3042, l3);
                    class_3042.method_23481(false);
                    if (!bl || UnsafeUtil.U.getBoolean(class_3042, l3)) continue;
                    l = l3;
                    continue;
                }
                if (field.getType() != Integer.TYPE || l2 >= 0L) continue;
                UnsafeUtil.U.putInt(class_3042, l3, 1);
                if (class_3042.method_1436() && UnsafeUtil.U.getInt(class_3042, l3) == 0) {
                    l2 = l3;
                    continue;
                }
                UnsafeUtil.U.putInt(class_3042, l3, 0);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return new long[]{l >= 0L ? l : UnsafeUtil.offset(class_304.class, Boolean.TYPE), l2 >= 0L ? l2 : UnsafeUtil.offset(class_304.class, Integer.TYPE)};
    }

    static boolean isActive() {
        return BotRuntime.active != null;
    }

    static Bot current() {
        return BotRuntime.active;
    }

    static boolean holdsUseCooldown(Bot dtv2) {
        return eei && BotRuntime.active == dtv2;
    }

    static int useCooldown() {
        return eds < 0L ? 0 : UnsafeUtil.U.getInt(edk, eds);
    }

    static void useCooldown(int n) {
        if (eds >= 0L) {
            UnsafeUtil.U.putInt(edk, eds, n);
        }
    }

    static void click(class_304 class_3042) {
        if (BotRuntime.active != null) {
            UnsafeUtil.U.putInt(class_3042, edu, UnsafeUtil.U.getInt(class_3042, edu) + 1);
        }
    }

    private static class_1297 eez() {
        return edr < 0L ? edk.method_1560() : (class_1297)UnsafeUtil.U.getObject(edk, edr);
    }

    static void camera(class_1297 class_12972) {
        if (edr >= 0L) {
            UnsafeUtil.U.putObject(edk, edr, class_12972);
        }
    }

    static boolean enter(Bot dtv2) {
        if (BotRuntime.active != null || !edk.method_18854()) {
            return false;
        }
        try {
            if (!BotRuntime.LOCK.tryLock() && !BotRuntime.LOCK.tryLock(60L, TimeUnit.MILLISECONDS)) {
                return false;
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
        edv = ClientContextSwitcher.edk.field_1724;
        edw = ClientContextSwitcher.edk.field_1687;
        edx = ClientContextSwitcher.edk.field_1761;
        edy = ClientContextSwitcher.edk.field_1755;
        edz = ClientContextSwitcher.edk.field_1765;
        eea = ClientContextSwitcher.edk.field_1692;
        eeb = ClientContextSwitcher.eez();
        eec = UnsafeUtil.get(edk, edl);
        eed = UnsafeUtil.get(edk, edm);
        eee = UnsafeUtil.get(edk, edn);
        eef = UnsafeUtil.get(edk, edo);
        eej = ClientContextSwitcher.edk.field_1705 == null ? null : ClientContextSwitcher.edk.field_1705.method_1740();
        Field field = TeleportTimer.field();
        try {
            eeg = eej == null || field == null ? null : field.get(eej);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            eeg = null;
        }
        try {
            BotRuntime.active = dtv2;
            ClientContextSwitcher.edk.field_1724 = dtv2.player;
            ClientContextSwitcher.edk.field_1687 = dtv2.world;
            ClientContextSwitcher.edk.field_1761 = dtv2.interaction;
            ClientContextSwitcher.edk.field_1755 = dtv2.screen;
            ClientContextSwitcher.edk.field_1765 = dtv2.crosshair;
            ClientContextSwitcher.edk.field_1692 = dtv2.targeted;
            ClientContextSwitcher.camera(dtv2.camera);
            UnsafeUtil.put(edk, edl, DummyClientParts.SOUND);
            UnsafeUtil.put(edk, edm, DummyClientParts.PARTICLES);
            UnsafeUtil.put(edk, edn, DummyClientParts.MOUSE);
            UnsafeUtil.put(edk, edo, DummyClientParts.WORLD_RENDERER);
            if (eej != null && field != null && eeg != null) {
                field.set(eej, dtv2.bossBars);
            }
            eek = SilentRotation.swap(dtv2.silent);
            eel = true;
            eeh = ClientContextSwitcher.useCooldown();
            eei = eds >= 0L;
            ClientContextSwitcher.useCooldown(dtv2.itemUseCooldown);
            ClientContextSwitcher.efb(dtv2);
            ClientContextSwitcher.efd();
            Object[] objectArray = dtv2.fabricAddons;
            if (objectArray != null) {
                eeu = FabricAddonsBridge.saveAddons();
                eev = true;
                FabricAddonsBridge.restoreAddons(objectArray);
            }
            return true;
        }
        catch (Throwable throwable) {
            ClientContextSwitcher.efa(null);
            return false;
        }
    }

    static void exit() {
        Bot dtv2 = BotRuntime.active;
        if (dtv2 == null) {
            return;
        }
        dtv2.player = ClientContextSwitcher.edk.field_1724;
        dtv2.world = ClientContextSwitcher.edk.field_1687;
        dtv2.interaction = ClientContextSwitcher.edk.field_1761;
        dtv2.screen = ClientContextSwitcher.edk.field_1755;
        dtv2.crosshair = ClientContextSwitcher.edk.field_1765;
        dtv2.targeted = ClientContextSwitcher.edk.field_1692;
        dtv2.camera = ClientContextSwitcher.eez();
        ClientContextSwitcher.efa(dtv2);
    }

    private static void efa(Bot dtv2) {
        try {
            ClientContextSwitcher.edk.field_1724 = edv;
            ClientContextSwitcher.edk.field_1687 = edw;
            ClientContextSwitcher.edk.field_1761 = edx;
            ClientContextSwitcher.edk.field_1755 = edy;
            ClientContextSwitcher.edk.field_1765 = edz;
            ClientContextSwitcher.edk.field_1692 = eea;
            ClientContextSwitcher.camera(eeb);
            if (eec != null) {
                UnsafeUtil.put(edk, edl, eec);
            }
            if (eed != null) {
                UnsafeUtil.put(edk, edm, eed);
            }
            if (eee != null) {
                UnsafeUtil.put(edk, edn, eee);
            }
            if (eef != null) {
                UnsafeUtil.put(edk, edo, eef);
            }
            Field field = TeleportTimer.field();
            if (eej != null && field != null && eeg != null) {
                try {
                    field.set(eej, eeg);
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    // empty catch block
                }
            }
            if (eel) {
                SilentRotation.swap(eek);
            }
            if (eei) {
                if (dtv2 != null) {
                    dtv2.itemUseCooldown = ClientContextSwitcher.useCooldown();
                }
                ClientContextSwitcher.useCooldown(eeh);
            }
            if (eeo) {
                ClientContextSwitcher.efc(dtv2);
            }
            if (eet) {
                ClientContextSwitcher.efe();
            }
            if (eev) {
                Object[] objectArray;
                if (dtv2 != null && (objectArray = FabricAddonsBridge.saveAddons()) != null) {
                    dtv2.fabricAddons = objectArray;
                }
                FabricAddonsBridge.restoreAddons(eeu);
            }
        }
        finally {
            edv = null;
            edw = null;
            edx = null;
            edy = null;
            edz = null;
            eea = null;
            eeb = null;
            eec = null;
            eed = null;
            eee = null;
            eef = null;
            eeg = null;
            eej = null;
            eek = null;
            eel = false;
            eei = false;
            eeo = false;
            eet = false;
            eeu = null;
            eev = false;
            BotRuntime.active = null;
            BotRuntime.LOCK.unlock();
        }
    }

    private static void efb(Bot dtv2) {
        int n;
        class_304[] class_304Array = ClientContextSwitcher.edk.field_1690.field_1839;
        if (eem.length != class_304Array.length) {
            eem = new boolean[class_304Array.length];
            een = new int[class_304Array.length];
        }
        dtv2.ensureKeys(class_304Array.length);
        for (n = 0; n < class_304Array.length; ++n) {
            ClientContextSwitcher.eem[n] = UnsafeUtil.U.getBoolean(class_304Array[n], edt);
            ClientContextSwitcher.een[n] = UnsafeUtil.U.getInt(class_304Array[n], edu);
        }
        eeo = true;
        for (n = 0; n < class_304Array.length; ++n) {
            UnsafeUtil.U.putBoolean(class_304Array[n], edt, dtv2.keyPressed[n]);
            UnsafeUtil.U.putInt(class_304Array[n], edu, dtv2.keyTimes[n]);
        }
    }

    private static void efc(Bot dtv2) {
        class_304[] class_304Array = ClientContextSwitcher.edk.field_1690.field_1839;
        int n = Math.min(class_304Array.length, eem.length);
        for (int i = 0; i < n; ++i) {
            class_304 class_3042 = class_304Array[i];
            if (dtv2 != null && i < dtv2.keyPressed.length) {
                dtv2.keyPressed[i] = UnsafeUtil.U.getBoolean(class_3042, edt);
                dtv2.keyTimes[i] = UnsafeUtil.U.getInt(class_3042, edu);
            }
            UnsafeUtil.U.putBoolean(class_3042, edt, eem[i]);
            UnsafeUtil.U.putInt(class_3042, edu, een[i]);
        }
    }

    private static void efd() {
        class_315 class_3152 = ClientContextSwitcher.edk.field_1690;
        eep = (Boolean)class_3152.method_42449().method_41753();
        eeq = (Boolean)class_3152.method_42450().method_41753();
        eer = (Boolean)class_3152.method_42423().method_41753();
        ees = (Double)class_3152.method_42495().method_41753();
        eet = true;
        Bot dtv2 = BotRuntime.active;
        if (dtv2 != null) {
            class_3152.method_42495().method_41748((Object)dtv2.sensitivity());
        }
        if (eep) {
            class_3152.method_42449().method_41748((Object)false);
        }
        if (eeq) {
            class_3152.method_42450().method_41748((Object)false);
        }
        if (eer) {
            class_3152.method_42423().method_41748((Object)false);
        }
    }

    private static void efe() {
        class_315 class_3152 = ClientContextSwitcher.edk.field_1690;
        if (eep) {
            class_3152.method_42449().method_41748((Object)true);
        }
        if (eeq) {
            class_3152.method_42450().method_41748((Object)true);
        }
        if (eer) {
            class_3152.method_42423().method_41748((Object)true);
        }
        class_3152.method_42495().method_41748((Object)ees);
    }

    static {
        long[] lArray = ClientContextSwitcher.eey();
        edt = lArray[0];
        edu = lArray[1];
        eem = new boolean[0];
        een = new int[0];
    }

    private static /* synthetic */ int dd(int n, int n2) {
        return n - n2 ^ 0x46A918BA;
    }

    private static /* synthetic */ int de(int n, int n2) {
        return ClientContextSwitcher.dd(n, n2) * n2;
    }

    private static /* synthetic */ int df(int n, int n2) {
        return ClientContextSwitcher.de(n, n2) + n;
    }
}

