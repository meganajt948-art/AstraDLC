/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2940
 *  net.minecraft.class_2943
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  net.minecraft.class_8113$class_8123
 */
package a;

import a.EnchantNameUtil;
import a.pzk;
import a.pzp;
import a.MineRarity;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_310;
import net.minecraft.class_746;
import net.minecraft.class_8113;

public final class TimerTextParser {
    private static final Pattern pzx = Pattern.compile("(\\d{1,2}):(\\d{2}):(\\d{2})");
    private static final Pattern pzy = Pattern.compile("(\\d{1,3}):(\\d{2})");
    private static final Pattern pzz = Pattern.compile("(\\d+)\\s*мин");
    private static final Pattern qaa = Pattern.compile("(\\d+)\\s*сек");
    private static class_2940<?> qab;
    private static boolean qac;
    private static /* synthetic */ int qad;
    private static /* synthetic */ long qae;

    private TimerTextParser() {
    }

    /*
     * WARNING - void declaration
     */
    public static pzp read(class_310 class_3102, double d) {
        void var11_16;
        void var11_14;
        Object object222;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1687 == null) {
            return null;
        }
        class_243 class_2432 = class_7462.method_73189();
        ArrayList<pzk> arrayList = new ArrayList<pzk>();
        pzk pzk4 = null;
        double d2 = Double.MAX_VALUE;
        block0: for (Object object222 : class_3102.field_1687.method_18112()) {
            List<String> list;
            class_243 object3;
            if (object222 == class_7462 || (object3 = object222.method_73189()).method_1025(class_2432) > d * d || (list = TimerTextParser.lines((class_1297)object222)).isEmpty()) continue;
            pzk pzk5 = new pzk(object3, list);
            arrayList.add(pzk5);
            for (String string : list) {
                if (!EnchantNameUtil.title(string).contains("шахт")) continue;
                double d3 = object3.method_1025(class_2432);
                if (!(d3 < d2)) continue block0;
                d2 = d3;
                pzk4 = pzk5;
                continue block0;
            }
        }
        if (pzk4 == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (pzk pzk6 : arrayList) {
            double d4 = pzk6.pzl.field_1352 - pzk4.pzl.field_1352;
            double d5 = pzk6.pzl.field_1350 - pzk4.pzl.field_1350;
            if (!(d4 * d4 + d5 * d5 <= 9.0) || !(Math.abs(pzk6.pzl.field_1351 - pzk4.pzl.field_1351) <= 5.0)) continue;
            arrayList2.add(pzk6);
        }
        arrayList2.sort((pzk2, pzk3) -> Double.compare(pzk3.pzl.field_1351, pzk2.pzl.field_1351));
        object222 = new ArrayList();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            pzk pzk7 = (pzk)iterator.next();
            for (String string : pzk7.pzm) {
                object222.add(EnchantNameUtil.title(string));
            }
        }
        Object var11_13 = null;
        String string = "";
        for (int i = 0; i < object222.size() && var11_14 == null; ++i) {
            String string2;
            String string3 = (String)object222.get(i);
            int n = string3.indexOf("следующ");
            if (n < 0) continue;
            int n2 = string3.indexOf(58, n);
            String string4 = string2 = n2 >= 0 ? string3.substring(n2 + 1) : string3.substring(n + 7);
            if (MineRarity.parse(string2) == null && string2.replaceAll("[^\\p{L}]", "").length() < 3 && i + 1 < object222.size()) {
                string2 = (String)object222.get(i + 1);
            }
            string = string2.replaceAll("[^\\p{L} ]", "").trim();
            MineRarity qwj2 = MineRarity.parse(string2);
        }
        if (var11_14 == null) {
            String string5;
            MineRarity qwj3;
            Iterator iterator2 = object222.iterator();
            while (iterator2.hasNext() && (qwj3 = MineRarity.parse(string5 = (String)iterator2.next())) == null) {
            }
        }
        int n = -1;
        for (int i = 0; i < object222.size() && n < 0; ++i) {
            String string6 = (String)object222.get(i);
            if (!string6.contains("обновлен") && !string6.contains("через")) continue;
            for (int j = i; j < Math.min(object222.size(), i + 3) && n < 0; ++j) {
                n = TimerTextParser.seconds((String)object222.get(j));
            }
        }
        if (n < 0) {
            String string7;
            Iterator iterator3 = object222.iterator();
            while (iterator3.hasNext() && (n = TimerTextParser.clock(string7 = (String)iterator3.next())) < 0) {
            }
        }
        if (n < 0) {
            return null;
        }
        return new pzp((MineRarity)var11_16, string, n, pzk4.pzl);
    }

    static int clock(String string) {
        Matcher matcher = pzx.matcher(string);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1)) * 3600 + Integer.parseInt(matcher.group(2)) * 60 + Integer.parseInt(matcher.group(3));
        }
        matcher = pzy.matcher(string);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) * 60 + Integer.parseInt(matcher.group(2)) : -1;
    }

    static int seconds(String string) {
        int n = TimerTextParser.clock(string);
        if (n >= 0) {
            return n;
        }
        int n2 = -1;
        Matcher matcher = pzz.matcher(string);
        if (matcher.find()) {
            n2 = Integer.parseInt(matcher.group(1)) * 60;
        }
        if ((matcher = qaa.matcher(string)).find()) {
            n2 = Math.max(0, n2) + Integer.parseInt(matcher.group(1));
        }
        return n2;
    }

    static List<String> lines(class_1297 class_12972) {
        Object object;
        class_2561 class_25612;
        ArrayList<String> arrayList = new ArrayList<String>();
        if (class_12972 instanceof class_8113.class_8123 && (class_25612 = TimerTextParser.qaf((class_8113.class_8123)(object = (class_8113.class_8123)class_12972))) != null) {
            for (String string : class_25612.getString().split("\n")) {
                if (string.isBlank()) continue;
                arrayList.add(string);
            }
        }
        if (class_12972.method_16914() && class_12972.method_5797() != null && !((String)(object = class_12972.method_5797().getString())).isBlank()) {
            arrayList.add((String)object);
        }
        return arrayList;
    }

    private static class_2561 qaf(class_8113.class_8123 class_81232) {
        if (!qac) {
            qac = true;
            for (Field field : class_8113.class_8123.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != class_2940.class) continue;
                try {
                    field.setAccessible(true);
                    class_2940 exception = (class_2940)field.get(null);
                    if (exception == null || exception.comp_2328() != class_2943.field_13317) continue;
                    qab = exception;
                    break;
                }
                catch (ReflectiveOperationException | RuntimeException exception) {
                    // empty catch block
                }
            }
        }
        if (qab == null) {
            return null;
        }
        try {
            class_2561 class_25612;
            Object runtimeException = class_81232.method_5841().method_12789(qab);
            return runtimeException instanceof class_2561 ? (class_25612 = (class_2561)runtimeException) : null;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    private static /* synthetic */ int bqi(int n, int n2) {
        return n - n2 ^ 0x87AEAFB8;
    }
}

