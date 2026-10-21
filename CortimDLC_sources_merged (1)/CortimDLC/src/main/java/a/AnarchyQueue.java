/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 */
package a;

import a.PanicShutdown;
import a.BotRuntime;
import a.Hud;
import a.InstanceQueue;
import flow.dev.StringDecryptor;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_310;
import net.minecraft.class_634;

public final class AnarchyQueue {
    private static final Pattern pns = Pattern.compile("/?an\\s*(\\d+)\\s*", 2);
    private static final int pnt = 20;
    private static String pnu;
    private static String pnv;
    private static int pnw;
    private static /* synthetic */ boolean pnx;
    private static /* synthetic */ String pny;

    private AnarchyQueue() {
    }

    public static String anarchy(String string) {
        if (string == null) {
            return null;
        }
        Matcher matcher = pns.matcher(string.trim());
        return matcher.matches() ? matcher.group(1) : null;
    }

    public static boolean allow(String string) {
        String string2 = AnarchyQueue.anarchy(string);
        if (string2 == null || BotRuntime.isActive() || PanicShutdown.armed()) {
            return true;
        }
        if (InstanceQueue.enter(InstanceQueue.MAIN, string2)) {
            pnu = null;
            return true;
        }
        String string3 = string.trim().toLowerCase(Locale.ROOT);
        if (string3.equals(pnu)) {
            InstanceQueue.cancel(InstanceQueue.MAIN);
            pnu = null;
            Hud.notify("Очередь", "Очередь на an" + string2 + " отменена");
            return false;
        }
        pnu = string3;
        pnv = string2;
        pnw = 0;
        Hud.notify("Очередь", "На an" + string2 + " уже " + 3 + " наших — жду места (" + InstanceQueue.position(InstanceQueue.MAIN) + "-й). Повтори команду, чтобы отменить");
        return false;
    }

    public static void tick(class_310 class_3102) {
        class_634 class_6342 = class_3102.method_1562();
        if (class_6342 == null || class_3102.field_1724 == null || class_3102.method_1542()) {
            if (class_6342 == null) {
                InstanceQueue.leave(InstanceQueue.MAIN);
            }
            pnu = null;
            return;
        }
        InstanceQueue.keep(InstanceQueue.MAIN);
        if (pnu == null || PanicShutdown.armed() || ++pnw % 20 != 0) {
            return;
        }
        if (InstanceQueue.enter(InstanceQueue.MAIN, pnv)) {
            String string = pnu;
            pnu = null;
            Hud.notify("Очередь", "Место на an" + pnv + " освободилось — перехожу");
            class_6342.method_45730(string.startsWith("/") ? string.substring(1) : string);
        }
    }

    private static /* synthetic */ int blp(int n, int n2) {
        return n + n2 | 0xC26DDE66;
    }

    private static /* synthetic */ int blq(int n, int n2) {
        return n ^ n2 | 0x54393D3D;
    }
}

