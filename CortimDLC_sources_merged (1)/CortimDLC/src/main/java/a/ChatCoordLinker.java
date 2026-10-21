/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_10606
 *  net.minecraft.class_2561
 *  net.minecraft.class_2568
 *  net.minecraft.class_2568$class_10613
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_5250
 */
package a;

import a.PanicShutdown;
import a.Hud;
import a.Icon;
import a.Lang;
import a.wjq;
import a.Waypoints;
import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2568;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_5250;

public final class ChatCoordLinker {
    private static final String wjx = "(-?\\d{1,8})";
    private static final String wjy = "(?:(?<=§.)|(?<![\\p{L}\\p{N}_.:#§-]))";
    private static final String wjz = "(?:(?<=§.)|(?<![\\p{L}\\p{N}_§]))";
    private static final String wka = "(?![\\p{L}\\p{N}_]|[.,:]\\d)";
    private static final Pattern wkb = Pattern.compile("(?:(?<=§.)|(?<![\\p{L}\\p{N}_§]))[xXхХ]\\s*[:=]?\\s*(-?\\d{1,8})[\\s,;]+[yYуУ]\\s*[:=]?\\s*(-?\\d{1,8})[\\s,;]+[zZ]\\s*[:=]?\\s*(-?\\d{1,8})(?![\\p{L}\\p{N}_]|[.,:]\\d)");
    private static final Pattern wkc = Pattern.compile("(?:(?<=§.)|(?<![\\p{L}\\p{N}_§]))[xXхХ]\\s*[:=]?\\s*(-?\\d{1,8})[\\s,;]+[zZ]\\s*[:=]?\\s*(-?\\d{1,8})(?![\\p{L}\\p{N}_]|[.,:]\\d)");
    private static final Pattern wkd = Pattern.compile("(?:(?<=§.)|(?<![\\p{L}\\p{N}_.:#§-]))(-?\\d{1,8})(\\s*[,;/]\\s*|\\s+)(-?\\d{1,8})(\\s*[,;/]\\s*|\\s+)(-?\\d{1,8})(?![\\p{L}\\p{N}_]|[.,:]\\d)");
    private static final Pattern wke = Pattern.compile("(?:(?<=§.)|(?<![\\p{L}\\p{N}_.:#§-]))(-?\\d{1,8})\\s*[,;]\\s*(-?\\d{1,8})(?![\\p{L}\\p{N}_]|[.,:]\\d)");
    private static final int wkf = 8192;
    private static final Set<class_2558> wkg = Collections.newSetFromMap(new IdentityHashMap());
    private static final ArrayDeque<class_2558> wkh = new ArrayDeque();
    private static /* synthetic */ String wki;
    private static /* synthetic */ int wkj;

    private ChatCoordLinker() {
    }

    public static class_2561 link(class_2561 class_25612) {
        if (class_25612 == null || !Waypoints.CHAT.get() || PanicShutdown.armed()) {
            return class_25612;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            class_25612.method_27658((class_25832, string) -> {
                if (!string.isEmpty()) {
                    arrayList.add(string);
                    arrayList2.add(class_25832);
                    stringBuilder.append(string);
                }
                return Optional.empty();
            }, class_2583.field_24360);
        }
        catch (RuntimeException runtimeException) {
            return class_25612;
        }
        List<wjq> list = ChatCoordLinker.wkm(stringBuilder.toString());
        if (list.isEmpty()) {
            return class_25612;
        }
        class_5250 class_52502 = class_2561.method_43473();
        boolean bl = false;
        int n = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            String string2 = (String)arrayList.get(i);
            class_2583 class_25833 = (class_2583)arrayList2.get(i);
            int n2 = n + string2.length();
            int n3 = n;
            while (n3 < n2) {
                wjq wjq2 = null;
                int n4 = n2;
                for (wjq wjq3 : list) {
                    if (n3 >= wjq3.wjr && n3 < wjq3.wjs) {
                        wjq2 = wjq3;
                        n4 = Math.min(n2, wjq3.wjs);
                        break;
                    }
                    if (wjq3.wjr <= n3 || wjq3.wjr >= n4) continue;
                    n4 = wjq3.wjr;
                }
                String string3 = string2.substring(n3 - n, n4 - n);
                if (wjq2 != null && class_25833.method_10970() == null) {
                    class_52502.method_10852((class_2561)class_2561.method_43470((String)string3).method_10862(class_25833.method_10958(ChatCoordLinker.wkk(wjq2.wjt)).method_10949((class_2568)new class_2568.class_10613((class_2561)class_2561.method_43470((String)Lang.s("Click: add a waypoint here", "Нажмите: поставить метку здесь")))).method_30938(Boolean.valueOf(true))));
                    bl = true;
                } else {
                    class_52502.method_10852((class_2561)class_2561.method_43470((String)string3).method_10862(class_25833));
                }
                n3 = n4;
            }
            n = n2;
        }
        return bl ? class_52502 : class_25612;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static class_2558 wkk(String string) {
        class_2558.class_10606 class_106062 = new class_2558.class_10606(string);
        Set<class_2558> set = wkg;
        synchronized (set) {
            wkg.add((class_2558)class_106062);
            wkh.addLast((class_2558)class_106062);
            while (wkh.size() > 8192) {
                wkg.remove(wkh.removeFirst());
            }
        }
        return class_106062;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean click(class_2583 class_25832) {
        class_2558 class_25582;
        class_2558 class_25583 = class_25582 = class_25832 != null && !PanicShutdown.armed() ? class_25832.method_10970() : null;
        if (!(class_25582 instanceof class_2558.class_10606)) {
            return false;
        }
        class_2558.class_10606 class_106062 = (class_2558.class_10606)class_25582;
        Set<class_2558> set = wkg;
        synchronized (set) {
            if (!wkg.contains(class_25582)) {
                return false;
            }
        }
        ChatCoordLinker.wkl(class_106062.comp_3503());
        return true;
    }

    private static void wkl(String string) {
        int n;
        int n2;
        int n3;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null) {
            return;
        }
        String[] stringArray = string.split(" ");
        try {
            n3 = Integer.parseInt(stringArray[0]);
            n2 = Integer.parseInt(stringArray[stringArray.length - 1]);
            n = stringArray.length == 3 ? Integer.parseInt(stringArray[1]) : class_3102.field_1724.method_31478();
        }
        catch (RuntimeException runtimeException) {
            return;
        }
        String string2 = Lang.s("Waypoint", "Метка");
        if (Waypoints.exists(n3, n, n2)) {
            Hud.alert(string2, Lang.s("Already there  ", "Уже есть  ") + n3 + " " + n + " " + n2, Icon.PIN, false);
            return;
        }
        int n4 = Waypoints.inWorld().size();
        String string3 = Lang.s("Waypoint ", "Метка ") + (n4 + 1);
        Waypoints.add(string3, n3, n, n2, Waypoints.COLORS[n4 % Waypoints.COLORS.length]);
        Hud.alert(string2, Lang.s("Added ", "Добавлена ") + string3 + "  " + n3 + " " + n + " " + n2, Icon.PIN, true);
    }

    private static List<wjq> wkm(String string) {
        Integer n;
        Integer n2;
        ArrayList<wjq> arrayList = new ArrayList<wjq>();
        if (string.length() < 3 || string.chars().noneMatch(Character::isDigit)) {
            return arrayList;
        }
        Matcher matcher = wkb.matcher(string);
        while (matcher.find()) {
            ChatCoordLinker.wkn(arrayList, matcher, ChatCoordLinker.wkp(matcher.group(1)), ChatCoordLinker.wkp(matcher.group(2)), ChatCoordLinker.wkp(matcher.group(3)));
        }
        matcher = wkc.matcher(string);
        while (matcher.find()) {
            ChatCoordLinker.wkn(arrayList, matcher, ChatCoordLinker.wkp(matcher.group(1)), null, ChatCoordLinker.wkp(matcher.group(2)));
        }
        matcher = wkd.matcher(string);
        while (matcher.find()) {
            boolean bl;
            n2 = ChatCoordLinker.wkp(matcher.group(1));
            n = ChatCoordLinker.wkp(matcher.group(5));
            boolean bl2 = bl = !matcher.group(2).isBlank() || !matcher.group(4).isBlank();
            if (n2 == null || n == null || !bl && Math.max(Math.abs(n2), Math.abs(n)) < 64 || ChatCoordLinker.wko(string, matcher.start(), matcher.end())) continue;
            ChatCoordLinker.wkn(arrayList, matcher, n2, ChatCoordLinker.wkp(matcher.group(3)), n);
        }
        matcher = wke.matcher(string);
        while (matcher.find()) {
            n2 = ChatCoordLinker.wkp(matcher.group(1));
            n = ChatCoordLinker.wkp(matcher.group(2));
            if (n2 == null || n == null || Math.max(Math.abs(n2), Math.abs(n)) < 100 || ChatCoordLinker.wko(string, matcher.start(), matcher.end())) continue;
            ChatCoordLinker.wkn(arrayList, matcher, n2, null, n);
        }
        arrayList.sort((wjq2, wjq3) -> Integer.compare(wjq2.wjr, wjq3.wjr));
        return arrayList;
    }

    private static void wkn(List<wjq> list, Matcher matcher, Integer n, Integer n2, Integer n3) {
        if (n == null || n3 == null || Math.abs(n) > 30000000 || Math.abs(n3) > 30000000) {
            return;
        }
        if (n2 != null && (n2 < -64 || n2 > 320)) {
            return;
        }
        for (wjq wjq2 : list) {
            if (matcher.start() >= wjq2.wjs || matcher.end() <= wjq2.wjr) continue;
            return;
        }
        list.add(new wjq(matcher.start(), matcher.end(), n2 != null ? n + " " + n2 + " " + n3 : n + " " + n3));
    }

    private static boolean wko(String string, int n, int n2) {
        int n3;
        int n4;
        for (n4 = n - 1; n4 >= 0 && string.charAt(n4) == ' '; --n4) {
        }
        if (n4 >= 0 && (string.charAt(n4) == ',' || string.charAt(n4) == ';' || n4 < n - 1 && Character.isDigit(string.charAt(n4)))) {
            return true;
        }
        for (n3 = n2; n3 < string.length() && string.charAt(n3) == ' '; ++n3) {
        }
        if (n3 < string.length() && (string.charAt(n3) == ',' || string.charAt(n3) == ';')) {
            ++n3;
        } else if (n3 == n2) {
            return false;
        }
        return string.substring(n3).trim().matches("(?s)-?\\d.*");
    }

    private static Integer wkp(String string) {
        try {
            return string == null ? null : Integer.valueOf(string);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private static /* synthetic */ int dra(int n, int n2) {
        return n + n2 + 1213685942;
    }

    private static /* synthetic */ int drb(int n, int n2) {
        return ChatCoordLinker.dra(n, n2) + n;
    }
}

