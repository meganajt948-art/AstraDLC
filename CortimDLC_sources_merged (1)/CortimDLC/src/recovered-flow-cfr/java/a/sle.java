/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.skr;
import a.skx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class sle {
    public static final sle NONE = new sle(List.of());
    private static final Pattern slf = Pattern.compile("\\[(\\d{1,3}):(\\d{1,2})(?:[.:](\\d{1,3}))?]");
    private static final Pattern slg = Pattern.compile("<(\\d{1,3}):(\\d{1,2})(?:[.:](\\d{1,3}))?>");
    private static final Pattern slh = Pattern.compile("\\[offset:\\s*([+-]?\\d+)\\s*]", 2);
    private static final long sli = 7000L;
    private final List<skx> slj;
    private static /* synthetic */ String slk;
    private static /* synthetic */ long sll;

    private sle(List<skx> list) {
        this.slj = list;
    }

    public List<skx> lines() {
        return this.slj;
    }

    public boolean isEmpty() {
        return this.slj.isEmpty();
    }

    public int indexAt(long l) {
        int n = 0;
        int n2 = this.slj.size() - 1;
        int n3 = -1;
        while (n <= n2) {
            int n4 = n + n2 >>> 1;
            if (this.slj.get(n4).start() <= l) {
                n3 = n4;
                n = n4 + 1;
                continue;
            }
            n2 = n4 - 1;
        }
        return n3;
    }

    public static sle parse(String string) {
        int n;
        if (string == null || string.isBlank()) {
            return NONE;
        }
        long l = 0L;
        Matcher matcher = slh.matcher(string);
        if (matcher.find()) {
            try {
                l = Long.parseLong(matcher.group(1));
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        ArrayList<skr> arrayList = new ArrayList<skr>();
        for (String string2 : string.split("\r?\n")) {
            Matcher matcher2 = slf.matcher(string2);
            ArrayList<Long> arrayList2 = new ArrayList<Long>();
            int n2 = 0;
            while (matcher2.find() && matcher2.start() == n2) {
                arrayList2.add(sle.sln(matcher2) - l);
                n2 = matcher2.end();
            }
            if (arrayList2.isEmpty()) continue;
            String string3 = string2.substring(n2);
            ArrayList<Long> arrayList3 = new ArrayList<Long>();
            Matcher matcher3 = slg.matcher(string3);
            while (matcher3.find()) {
                arrayList3.add(sle.sln(matcher3) - l);
            }
            String string4 = sle.slo(slg.matcher(string3).replaceAll(" "));
            long[] lArray = null;
            if (!arrayList3.isEmpty() && !string4.isEmpty()) {
                int n3 = string4.split(" ").length;
                if (arrayList3.size() >= n3) {
                    lArray = new long[n3];
                    for (int i = 0; i < n3; ++i) {
                        lArray[i] = (Long)arrayList3.get(i);
                    }
                }
            }
            Iterator iterator = arrayList2.iterator();
            while (iterator.hasNext()) {
                long l2 = (Long)iterator.next();
                arrayList.add(new skr(Math.max(0L, l2), string4, lArray == null ? null : sle.slm(lArray, l2 - (Long)arrayList2.get(0))));
            }
        }
        if (arrayList.isEmpty()) {
            return NONE;
        }
        arrayList.sort((skr2, skr3) -> Long.compare(skr2.sks, skr3.sks));
        ArrayList arrayList4 = new ArrayList(arrayList.size());
        for (n = 0; n < arrayList.size(); ++n) {
            skr skr4 = (skr)arrayList.get(n);
            long l3 = n + 1 < arrayList.size() ? ((skr)arrayList.get((int)(n + 1))).sks : skr4.sks + 7000L;
            arrayList4.add(new skx(skr4.sks, Math.max(skr4.sks + 1L, l3), skr4.skt, skr4.sku));
        }
        n = 0;
        Iterator iterator = arrayList4.iterator();
        while (iterator.hasNext()) {
            skx skx2 = (skx)iterator.next();
            n |= !skx2.blank() ? 1 : 0;
        }
        return n != 0 ? new sle(List.copyOf(arrayList4)) : NONE;
    }

    private static long[] slm(long[] lArray, long l) {
        if (l == 0L) {
            return lArray;
        }
        long[] lArray2 = Arrays.copyOf(lArray, lArray.length);
        int n = 0;
        while (n < lArray2.length) {
            int n2 = n++;
            lArray2[n2] = lArray2[n2] + l;
        }
        return lArray2;
    }

    private static long sln(Matcher matcher) {
        long l = Long.parseLong(matcher.group(1));
        long l2 = Long.parseLong(matcher.group(2));
        String string = matcher.group(3);
        long l3 = 0L;
        if (string != null) {
            l3 = Long.parseLong(string);
            l3 = switch (string.length()) {
                case 1 -> l3 * 100L;
                case 2 -> l3 * 10L;
                default -> l3;
            };
        }
        return l * 60000L + l2 * 1000L + l3;
    }

    private static String slo(String string) {
        int n;
        String string2 = string.replace('\u00a0', ' ').replaceAll("\\s+", " ").trim();
        for (int i = 0; i < string2.length(); i += Character.charCount(n)) {
            n = string2.codePointAt(i);
            if (!Character.isLetterOrDigit(n)) continue;
            return string2;
        }
        return "";
    }

    private static /* synthetic */ int cek(int n, int n2) {
        return n + n2 ^ 0x463A1FE5;
    }

    private static /* synthetic */ int cel(int n, int n2) {
        return n - n2 | 0x7704DD00;
    }
}

