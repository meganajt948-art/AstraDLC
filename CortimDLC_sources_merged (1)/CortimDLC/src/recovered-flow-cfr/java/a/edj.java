/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.BossBarHud
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.hit.HitResult
 */
package a;

import a.dtv;
import a.ega;
import a.ejl;
import a.ejp;
import a.eky;
import a.pjn;
import a.pth;
import a.ptr;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult;

final class edj {
    private static final MinecraftClient edk = MinecraftClient.method_1551();
    private static final long edl = ejl.offsetOf(edk, edk.method_1483());
    private static final long edm = ejl.offsetOf(edk, edj.edk.field_1713);
    private static final long edn = ejl.offsetOf(edk, edj.edk.field_1729);
    private static final long edo = ejl.offsetOf(edk, edj.edk.field_1769);
    private static final Field edp = vxr.find(MinecraftClient.class, a.d("\u6899\u1123\u9be1\u05ca\u8e5e\u08eb\ub2bf\u3b45\ua51c\u2fbc\ua87c\u520a\udccf\u4524\ucf3a\u49c4\uf386\u7c45\ue6f6\u608b\ue910\u9343\u1df1", 1340244188, -820320196), a.c(2090077296, "\u0c1c\u75a2\uff7d\u6105\ueada\u6c50\ud66d\u5f9a\uc1c3\u4b7a"), a.d("\u01f3\u7860\uf2b8\u6cd8\ue754\u61a7\udbf0\u5206\ucc52\u46e5\uc127\u3b45\ub595\u2c36\ua63e\u2083\u9ac3\u151f\u8fbe\u09ef\u8034\ufa0b\u74bb\uef61\u6910\ue3cd", 494456179, 1285475542));
    private static final Field edq = vxr.find(MinecraftClient.class, a.c(-439245696, "\ua4f9\udd43\u5781\uc9aa\u423e\uc48b\u7edf\uf725\u697c\ue3dc\u641c\u9e6a\u10af\u8944\u035a\u85a4\u3fe6\ub025\u2a96\uaceb\u2570\u5f23\ud191"), a.d("\ua6dc\udf62\u55bd\ucbc5\u401a\uc690\u7cad\uf55a\u6b07\ue1b1", 1933986926, 1530850014), a.d("\u6c1f", 1206452448, 1835822263));
    private static final long edr = edp == null ? -1L : ejl.U.objectFieldOffset(edp);
    private static final long eds = edq == null ? -1L : ejl.U.objectFieldOffset(edq);
    private static final long edt;
    private static final long edu;
    private static ClientPlayerEntity edv;
    private static ClientWorld edw;
    private static ClientPlayerInteractionManager edx;
    private static Screen edy;
    private static HitResult edz;
    private static Entity eea;
    private static Entity eeb;
    private static Object eec;
    private static Object eed;
    private static Object eee;
    private static Object eef;
    private static Object eeg;
    private static int eeh;
    private static boolean eei;
    private static BossBarHud eej;
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

    private edj() {
    }

    private static long[] eey() {
        long l = -1L;
        long l2 = -1L;
        try {
            KeyBinding keyBinding = ejl.allocate(KeyBinding.class);
            for (Field field : KeyBinding.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                long l3 = ejl.U.objectFieldOffset(field);
                if (field.getType() == Boolean.TYPE && l < 0L) {
                    keyBinding.method_23481(true);
                    boolean bl = ejl.U.getBoolean(keyBinding, l3);
                    keyBinding.method_23481(false);
                    if (!bl || ejl.U.getBoolean(keyBinding, l3)) continue;
                    l = l3;
                    continue;
                }
                if (field.getType() != Integer.TYPE || l2 >= 0L) continue;
                ejl.U.putInt(keyBinding, l3, 1);
                if (keyBinding.method_1436() && ejl.U.getInt(keyBinding, l3) == 0) {
                    l2 = l3;
                    continue;
                }
                ejl.U.putInt(keyBinding, l3, 0);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return new long[]{l >= 0L ? l : ejl.offset(KeyBinding.class, Boolean.TYPE), l2 >= 0L ? l2 : ejl.offset(KeyBinding.class, Integer.TYPE)};
    }

    static boolean isActive() {
        return ejp.active != null;
    }

    static dtv current() {
        return ejp.active;
    }

    static boolean holdsUseCooldown(dtv dtv2) {
        return eei && ejp.active == dtv2;
    }

    static int useCooldown() {
        return eds < 0L ? 0 : ejl.U.getInt(edk, eds);
    }

    static void useCooldown(int n) {
        if (eds >= 0L) {
            ejl.U.putInt(edk, eds, n);
        }
    }

    static void click(KeyBinding keyBinding) {
        if (ejp.active != null) {
            ejl.U.putInt(keyBinding, edu, ejl.U.getInt(keyBinding, edu) + 1);
        }
    }

    private static Entity eez() {
        return edr < 0L ? edk.method_1560() : (Entity)ejl.U.getObject(edk, edr);
    }

    static void camera(Entity entity) {
        if (edr >= 0L) {
            ejl.U.putObject(edk, edr, entity);
        }
    }

    static boolean enter(dtv dtv2) {
        if (ejp.active != null || !edk.method_18854()) {
            return false;
        }
        try {
            if (!ejp.LOCK.tryLock() && !ejp.LOCK.tryLock(60L, TimeUnit.MILLISECONDS)) {
                return false;
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
        edv = edj.edk.field_1724;
        edw = edj.edk.field_1687;
        edx = edj.edk.field_1761;
        edy = edj.edk.field_1755;
        edz = edj.edk.field_1765;
        eea = edj.edk.field_1692;
        eeb = edj.eez();
        eec = ejl.get(edk, edl);
        eed = ejl.get(edk, edm);
        eee = ejl.get(edk, edn);
        eef = ejl.get(edk, edo);
        eej = edj.edk.field_1705 == null ? null : edj.edk.field_1705.method_1740();
        Field field = pjn.field();
        try {
            eeg = eej == null || field == null ? null : field.get(eej);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            eeg = null;
        }
        try {
            ejp.active = dtv2;
            edj.edk.field_1724 = dtv2.player;
            edj.edk.field_1687 = dtv2.world;
            edj.edk.field_1761 = dtv2.interaction;
            edj.edk.field_1755 = dtv2.screen;
            edj.edk.field_1765 = dtv2.crosshair;
            edj.edk.field_1692 = dtv2.targeted;
            edj.camera(dtv2.camera);
            ejl.put(edk, edl, eky.SOUND);
            ejl.put(edk, edm, eky.PARTICLES);
            ejl.put(edk, edn, eky.MOUSE);
            ejl.put(edk, edo, eky.WORLD_RENDERER);
            if (eej != null && field != null && eeg != null) {
                field.set(eej, dtv2.bossBars);
            }
            eek = ptr.swap(dtv2.silent);
            eel = true;
            eeh = edj.useCooldown();
            eei = eds >= 0L;
            edj.useCooldown(dtv2.itemUseCooldown);
            edj.efb(dtv2);
            edj.efd();
            Object[] objectArray = dtv2.fabricAddons;
            if (objectArray != null) {
                eeu = ega.saveAddons();
                eev = true;
                ega.restoreAddons(objectArray);
            }
            return true;
        }
        catch (Throwable throwable) {
            edj.efa(null);
            return false;
        }
    }

    static void exit() {
        dtv dtv2 = ejp.active;
        if (dtv2 == null) {
            return;
        }
        dtv2.player = edj.edk.field_1724;
        dtv2.world = edj.edk.field_1687;
        dtv2.interaction = edj.edk.field_1761;
        dtv2.screen = edj.edk.field_1755;
        dtv2.crosshair = edj.edk.field_1765;
        dtv2.targeted = edj.edk.field_1692;
        dtv2.camera = edj.eez();
        edj.efa(dtv2);
    }

    private static void efa(dtv dtv2) {
        try {
            edj.edk.field_1724 = edv;
            edj.edk.field_1687 = edw;
            edj.edk.field_1761 = edx;
            edj.edk.field_1755 = edy;
            edj.edk.field_1765 = edz;
            edj.edk.field_1692 = eea;
            edj.camera(eeb);
            if (eec != null) {
                ejl.put(edk, edl, eec);
            }
            if (eed != null) {
                ejl.put(edk, edm, eed);
            }
            if (eee != null) {
                ejl.put(edk, edn, eee);
            }
            if (eef != null) {
                ejl.put(edk, edo, eef);
            }
            Field field = pjn.field();
            if (eej != null && field != null && eeg != null) {
                try {
                    field.set(eej, eeg);
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    // empty catch block
                }
            }
            if (eel) {
                ptr.swap(eek);
            }
            if (eei) {
                if (dtv2 != null) {
                    dtv2.itemUseCooldown = edj.useCooldown();
                }
                edj.useCooldown(eeh);
            }
            if (eeo) {
                edj.efc(dtv2);
            }
            if (eet) {
                edj.efe();
            }
            if (eev) {
                Object[] objectArray;
                if (dtv2 != null && (objectArray = ega.saveAddons()) != null) {
                    dtv2.fabricAddons = objectArray;
                }
                ega.restoreAddons(eeu);
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
            ejp.active = null;
            ejp.LOCK.unlock();
        }
    }

    private static void efb(dtv dtv2) {
        int n;
        KeyBinding[] keyBindingArray = edj.edk.field_1690.field_1839;
        if (eem.length != keyBindingArray.length) {
            eem = new boolean[keyBindingArray.length];
            een = new int[keyBindingArray.length];
        }
        dtv2.ensureKeys(keyBindingArray.length);
        for (n = 0; n < keyBindingArray.length; ++n) {
            edj.eem[n] = ejl.U.getBoolean(keyBindingArray[n], edt);
            edj.een[n] = ejl.U.getInt(keyBindingArray[n], edu);
        }
        eeo = true;
        for (n = 0; n < keyBindingArray.length; ++n) {
            ejl.U.putBoolean(keyBindingArray[n], edt, dtv2.keyPressed[n]);
            ejl.U.putInt(keyBindingArray[n], edu, dtv2.keyTimes[n]);
        }
    }

    private static void efc(dtv dtv2) {
        KeyBinding[] keyBindingArray = edj.edk.field_1690.field_1839;
        int n = Math.min(keyBindingArray.length, eem.length);
        for (int i = 0; i < n; ++i) {
            KeyBinding keyBinding = keyBindingArray[i];
            if (dtv2 != null && i < dtv2.keyPressed.length) {
                dtv2.keyPressed[i] = ejl.U.getBoolean(keyBinding, edt);
                dtv2.keyTimes[i] = ejl.U.getInt(keyBinding, edu);
            }
            ejl.U.putBoolean(keyBinding, edt, eem[i]);
            ejl.U.putInt(keyBinding, edu, een[i]);
        }
    }

    private static void efd() {
        GameOptions gameOptions = edj.edk.field_1690;
        eep = (Boolean)gameOptions.method_42449().method_41753();
        eeq = (Boolean)gameOptions.method_42450().method_41753();
        eer = (Boolean)gameOptions.method_42423().method_41753();
        ees = (Double)gameOptions.method_42495().method_41753();
        eet = true;
        dtv dtv2 = ejp.active;
        if (dtv2 != null) {
            gameOptions.method_42495().method_41748((Object)dtv2.sensitivity());
        }
        if (eep) {
            gameOptions.method_42449().method_41748((Object)false);
        }
        if (eeq) {
            gameOptions.method_42450().method_41748((Object)false);
        }
        if (eer) {
            gameOptions.method_42423().method_41748((Object)false);
        }
    }

    private static void efe() {
        GameOptions gameOptions = edj.edk.field_1690;
        if (eep) {
            gameOptions.method_42449().method_41748((Object)true);
        }
        if (eeq) {
            gameOptions.method_42450().method_41748((Object)true);
        }
        if (eer) {
            gameOptions.method_42423().method_41748((Object)true);
        }
        gameOptions.method_42495().method_41748((Object)ees);
    }

    static {
        long[] lArray = edj.eey();
        edt = lArray[0];
        edu = lArray[1];
        eem = new boolean[0];
        een = new int[0];
    }

    private static /* synthetic */ int dd(int n, int n2) {
        return n - n2 ^ 0x46A918BA;
    }

    private static /* synthetic */ int de(int n, int n2) {
        return edj.dd(n, n2) * n2;
    }

    private static /* synthetic */ int df(int n, int n2) {
        return edj.de(n, n2) + n;
    }
}

