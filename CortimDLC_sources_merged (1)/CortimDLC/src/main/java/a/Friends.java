/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_640
 *  net.minecraft.class_742
 *  net.minecraft.class_8685
 */
package a;

import a.CloudSync;
import a.hgz;
import a.hhc;
import a.Hud;
import a.Icon;
import a.BoolSetting;
import a.NumberSetting;
import a.Setting;
import a.Lang;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_640;
import net.minecraft.class_742;
import net.minecraft.class_8685;

public final class Friends {
    public static final BoolSetting PROTECT = new BoolSetting("Protect friends", true);
    public static final List<Setting> OPTIONS = List.of(PROTECT);
    public static final BoolSetting CLICK = new BoolSetting("Click friend", true);
    public static final NumberSetting CLICK_RANGE = new NumberSetting("Click range", 8.0, 3.0, 160.0, 1.0).suffix("blocks");
    public static final List<Setting> CLICK_OPTIONS = List.of(CLICK_RANGE);
    public static final List<Setting> ALL = List.of(PROTECT, CLICK, CLICK_RANGE);
    public static final int MAX_NAME = 20;
    private static final double hhg = 0.3;
    private static final Gson hhh = new GsonBuilder().setPrettyPrinting().create();
    private static final List<hhc> hhi = new ArrayList<hhc>();
    private static final Set<String> hhj = new HashSet<String>();
    private static boolean hhk;
    private static int hhl;
    private static /* synthetic */ int hhm;
    private static /* synthetic */ long hhn;

    private Friends() {
    }

    public static int version() {
        return hhl;
    }

    public static List<hhc> all() {
        Friends.hhq();
        return Collections.unmodifiableList(hhi);
    }

    public static boolean isFriend(String string) {
        Friends.hhq();
        return string != null && hhj.contains(Friends.hho(string));
    }

    public static boolean isFriend(class_1297 class_12972) {
        class_1657 class_16572;
        return class_12972 instanceof class_1657 && Friends.isFriend(Friends.nameOf(class_16572 = (class_1657)class_12972));
    }

    public static boolean protects(class_1297 class_12972) {
        return PROTECT.get() && Friends.isFriend(class_12972);
    }

    public static boolean add(String string) {
        Friends.hhq();
        String string2 = Friends.clean(string);
        if (string2 == null || hhj.contains(Friends.hho(string2))) {
            return false;
        }
        hhi.add(new hhc(string2));
        hhj.add(Friends.hho(string2));
        Friends.hhp();
        return true;
    }

    public static boolean remove(String string) {
        Friends.hhq();
        if (string == null || !hhj.remove(Friends.hho(string))) {
            return false;
        }
        hhi.removeIf(hhc2 -> Friends.hho(hhc2.name).equals(Friends.hho(string)));
        Friends.hhp();
        return true;
    }

    public static boolean toggle(String string) {
        if (Friends.isFriend(string)) {
            Friends.remove(string);
            return false;
        }
        return Friends.add(string);
    }

    public static String nameOf(class_1657 class_16572) {
        return class_16572.method_5477().getString();
    }

    public static String clean(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        if (string2.isEmpty() || string2.length() > 20 || string2.chars().anyMatch(n -> n <= 32 || n == 167)) {
            return null;
        }
        return string2;
    }

    private static String hho(String string) {
        return string.toLowerCase(Locale.ROOT);
    }

    public static class_1657 aimed(class_310 class_3102, double d) {
        class_1657 class_16572;
        class_1297 class_12972 = class_3102.method_1560();
        if (class_12972 == null || class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return null;
        }
        class_1297 class_12973 = class_3102.field_1692;
        if (class_12973 instanceof class_1657 && (class_16572 = (class_1657)class_12973) != class_3102.field_1724) {
            return class_16572;
        }
        class_16572 = class_12972.method_5836(1.0f);
        class_12973 = class_12972.method_5828(1.0f);
        double d2 = d;
        class_239 class_2392 = class_12972.method_5745(d, 1.0f, false);
        if (class_2392 != null && class_2392.method_17783() != class_239.class_240.field_1333) {
            d2 = class_2392.method_17784().method_1022((class_243)class_16572);
        }
        class_243 class_2432 = class_16572.method_1019(class_12973.method_1021(d2));
        class_1657 class_16573 = null;
        double d3 = Double.MAX_VALUE;
        for (class_1657 class_16574 : class_3102.field_1687.method_18456()) {
            double d4;
            Optional optional;
            if (class_16574 == class_3102.field_1724 || class_16574 == class_12972 || class_16574.method_7325() || !class_16574.method_5805() || !(optional = class_16574.method_5829().method_1014(0.3).method_992((class_243)class_16572, class_2432)).isPresent() || !((d4 = ((class_243)optional.get()).method_1025((class_243)class_16572)) < d3)) continue;
            d3 = d4;
            class_16573 = class_16574;
        }
        return class_16573;
    }

    public static void toggleAimed() {
        String string;
        if (!CLICK.get()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        class_1657 class_16572 = Friends.aimed(class_3102, CLICK_RANGE.get());
        if (class_16572 == null) {
            return;
        }
        boolean bl = Friends.toggle(string = Friends.nameOf(class_16572));
        Hud.alert(string, bl ? Lang.s("Friend", "Друг") : Lang.s("Removed", "Удалён"), Icon.FRIENDS, bl);
    }

    public static class_8685 skinOf(String string) {
        Object object;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 != null) {
            object = class_3102.field_1687.method_18456().iterator();
            while (object.hasNext()) {
                class_1657 class_16572 = (class_1657)object.next();
                if (!Friends.nameOf(class_16572).equalsIgnoreCase(string) || !(class_16572 instanceof class_742)) continue;
                class_742 class_7422 = (class_742)class_16572;
                return class_7422.method_52814();
            }
        }
        return (object = Friends.listEntry(string)) != null ? object.method_52810() : null;
    }

    public static class_640 listEntry(String string) {
        class_634 class_6342 = class_310.method_1551().method_1562();
        if (class_6342 == null || string == null) {
            return null;
        }
        try {
            return class_6342.method_73471(string);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public static class_1657 inWorld(String string) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null) {
            return null;
        }
        for (class_1657 class_16572 : class_3102.field_1687.method_18456()) {
            if (!Friends.nameOf(class_16572).equalsIgnoreCase(string)) continue;
            return class_16572;
        }
        return null;
    }

    private static void hhp() {
        ++hhl;
        Friends.hhr();
    }

    private static void hhq() {
        if (hhk) {
            return;
        }
        hhk = true;
        String string = CloudSync.get("friends");
        if (string == null || string.isBlank()) {
            return;
        }
        try {
            List list = (List)hhh.fromJson(string, new hgz().getType());
            if (list != null) {
                for (hhc hhc2 : list) {
                    String string2 = hhc2 != null ? Friends.clean(hhc2.name) : null;
                    if (string2 == null || !hhj.add(Friends.hho(string2))) continue;
                    hhc2.name = string2;
                    hhi.add(hhc2);
                }
            }
        }
        catch (Exception exception) {
            System.out.println("can't read friends: " + exception);
        }
    }

    private static void hhr() {
        CloudSync.put("friends", hhh.toJson(hhi));
    }

    private static /* synthetic */ int aaj(int n, int n2) {
        return n ^ n2 | 0xA5220EB6;
    }

    private static /* synthetic */ int aak(int n, int n2) {
        return Friends.aaj(n, n2) * n2;
    }

    private static /* synthetic */ int aal(int n, int n2) {
        return n * n2 ^ 0xCFFB2A11;
    }
}

