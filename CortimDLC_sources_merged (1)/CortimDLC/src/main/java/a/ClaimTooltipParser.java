/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792$class_9635
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1836
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 */
package a;

import a.EnchantNameUtil;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1836;
import net.minecraft.class_2561;
import net.minecraft.class_310;

public final class ClaimTooltipParser {
    private static final String pfe = "цена";
    private static final String pff = "не актуален";
    private static final String pfg = "чтобы забрать";
    private static final Pattern pfh = Pattern.compile("(\\d[\\d\\s.,]*)");
    private static /* synthetic */ boolean pfi;
    private static /* synthetic */ String pfj;

    private ClaimTooltipParser() {
    }

    public static int of(class_1799 class_17992) {
        long l = ClaimTooltipParser.pfk(class_17992);
        return l > 0L ? (int)Math.min(Integer.MAX_VALUE, l / (long)Math.max(1, class_17992.method_7947())) : -1;
    }

    public static int total(class_1799 class_17992) {
        long l = ClaimTooltipParser.pfk(class_17992);
        return l > 0L ? (int)Math.min(Integer.MAX_VALUE, l) : -1;
    }

    private static long pfk(class_1799 class_17992) {
        if (class_17992.method_7960() || class_17992.method_31574(class_1802.field_8298)) {
            return -1L;
        }
        List<String> list = ClaimTooltipParser.lines(class_17992);
        for (int i = 0; i < list.size(); ++i) {
            String string = list.get(i);
            if (i == 0) {
                if (!string.contains("не актуален")) continue;
                return -1L;
            }
            int n = string.indexOf("цена");
            if (n < 0) continue;
            Matcher matcher = pfh.matcher(string.substring(n + "цена".length()));
            long l = -1L;
            while (matcher.find()) {
                String string2 = matcher.group(1).replaceAll("[^0-9]", "");
                if (string2.isEmpty() || string2.length() > 12) continue;
                l = Math.max(l, Long.parseLong(string2));
            }
            if (l <= 0L) continue;
            return l;
        }
        return -1L;
    }

    public static boolean claimed(class_1799 class_17992) {
        for (String string : ClaimTooltipParser.lines(class_17992)) {
            if (!string.contains("чтобы забрать")) continue;
            return true;
        }
        return false;
    }

    static List<class_2561> tooltip(class_1799 class_17992) {
        class_310 class_3102 = class_310.method_1551();
        return class_17992.method_7950(class_1792.class_9635.field_51353, (class_1657)class_3102.field_1724, (class_1836)class_1836.field_41070);
    }

    public static List<String> lines(class_1799 class_17992) {
        List<class_2561> list = ClaimTooltipParser.tooltip(class_17992);
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        for (class_2561 class_25612 : list) {
            arrayList.add(EnchantNameUtil.title(class_25612.getString()));
        }
        return arrayList;
    }

    private static /* synthetic */ int bhr(int n, int n2) {
        return (n ^ n2) + -579635674;
    }

    private static /* synthetic */ int bhs(int n, int n2) {
        return ClaimTooltipParser.bhr(n, n2) * n2;
    }
}

