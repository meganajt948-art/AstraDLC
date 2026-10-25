/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.text.ClickEvent
 *  net.minecraft.text.ClickEvent$CopyToClipboard
 *  net.minecraft.text.HoverEvent
 *  net.minecraft.text.HoverEvent$ShowText
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 */
package a;

import a.dry;
import a.izx;
import a.vhz;
import a.wap;
import a.wjq;
import a.wlk;
import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

public final class wjw {
    private static final String wjx = a.c(-1333798558, "\ud941\ua0f5\u2a34\ub426\u3fc9\ub967\u037e\u8a92\u14d9\u9e2d\u19aa");
    private static final String wjy = a.c(-1103426556, "\u0c0f\u75a9\uff7f\u611c\ueadc\u6c6e\ud63c\u5f57\uc181\u4b37\uccb1\u3694\ub854\u21e6\uaba8\u2d23\u976b\u1896\u822e\u0448\u8d8e\uf7fe\u7961\ue2bb\u64f1\uee13\u5782\ud9a2\u4341\uc509\u4e3e\ub065\u3a5a\ua3df\u258c");
    private static final String wjz = a.c(104882550, "\u6141\u18e7\u9231\u0c52\u8792\u0120\ubb72\u3219\uaccf\u2679\ua1ff\u5bda\ud51a\u4ca8\uc6e6\u406d\ufa25\u75d8\uef60\u6906\ue0c0\u9ab0\u142f\u8ff5\u09bf\u835d\u3acc\ub465\u2e68\ua84d\u23fe");
    private static final String wka = a.b("\u0966\u70c0\ufa0d\u6406\uefd6\u694b\ud313\u5ad5\uc4bb\u4e2b\uc9d4\u33ae\ubd4c\u24ce\uaebf\u284c\u9222\u1dd4\u8712\u0141\u88a0\uf296\u7c24\ue7cd\u61ff", 1872431447);
    private static final Pattern wkb = Pattern.compile(a.b("\u9260\uebc6\u6110\uff73\u74b3\uf201\u4853\uc138\u5fee\ud558\u52de\ua8fb\u263b\ubf89\u35c7\ub34c\u0904\u86f9\u1c41\u9a27\u13e1\u6991\ue70e\u7cd4\ufa9e\u707c\uc9ed\u4744\udd49\u5b6c\ud0df\u2e7c\ua410\u3dc1\ubf8f\u355e\u8ef1\u0481\u827d\u1b95\u91bb\uef2b\u657f\ue2ae\u781b\uf609\u4ff5\uc51d\u4350\ud884\u56e5\uac57\u25d8\ua396\u392f\ub763\u0cc8\u8a5c{\u99d8\u1768\u6d16\ueaba\u60fc\ufe55\u7792\ucdb1\u4b62\uc115\u5abe\ud00d\u5202\uabdc\u2142\ubf48\u34c8\ub2fe\u0848\u81fb\u1fe8\u9544\u133a\u68d0\ue603\u7c71\uf5b2\u7362\uc90b\u46eb\udcf0\u5a5e\ud39b\u29a9\ua72c\u3ced\ubabb\u305b\u8e75\u07b1\u9d66\u1b47\u90c6\ueeb4\u6425\ufdfd\u7b8d\uf171\u4e99\uc4bf\u422f\ud87b\u51aa\uaf07\u2535\ua2e9\u38e1\ub654\u0f80\u85e1\u0353\u98d4\u169a\u6c23\uea6f\u63cc\uf958\u777f\uccaf\u4af7\uc058\u59f1\ud787\u2d7c\uaac6\u20a2\ube62\u341c\u8d81\u0b59\u811d\u1ef9\u946a\u123b\u6beb\ue183\u7f27\uf496\u72d1\uc841\u4611\udf9a\u5506", 1816040144));
    private static final Pattern wkc = Pattern.compile(a.d("\ud894\ua132\u2be4\ub587\u3e47\ub8f5\u02a7\u8bcc\u151a\u9fac\u182a\ue20f\u6ccf\uf57d\u7f33\uf9b8\u43f0\ucc0d\u56b5\ud0d3\u5915\u2365\uadfa\u3620\ub06a\u3a88\u8319\u0db0\u97bd\u1198\u9a2b\u6488\ueee4\u7735\uf57b\u7faa\uc405\u4e75\uc889\u5161\udb4f\ua5df\u2f8b\ua85a\u32ef\ubcfd\u0501\u8fe9\u09a4\u9270\u1c11\ue6a3\u6f2c\ue962\u73db\ufd97\u463c\uc0a8\u4a8f\ud32c\u5d9c\u27e2\ua04e\u2a08\ub4a1\u3d66\u8745\u0195\u8be2\u1454\u9e86\u18d8\ue15e\u6b9e\uf5ac\u7e5a\uf86d\u42be\ucb0e\u5550\udfc6\u5995\u2223\uace0\u36f4\ubf1d\u39b1\u83aa\u0c48\u960d\u10fb\u997e\u6308\uedce\u7663\uf048\u7a80\uc4dd\u4d05\ud783\u51e5\uda35\ua44a\u2ef0\ub71a\u3158\ubba9\u041a\u8e6c\u08ba\u929c\u1b2f\ue5f6\u6fc0\ue832\u725b\ufca1", -187939995, -2053596244));
    private static final Pattern wkd = Pattern.compile(a.d("\u14cc\u6d6a\ue7bc\u79df\uf21f\u74ad\uceff\u4794\ud942\u53f4\ud472\u2e57\ua097\u3925\ub36b\u35e0\u8fa8U\u9aed\u1c8b\u954d\uef3d\u61a2\ufa78\u7c32\uf6d0\u4f41\uc161\u5b82\uddca\u56fd\ua8a6\u2299\ubb1c\u3d4f\ub7ff\u082d\u824e\u04fe\u9d77\u1737\u698c\ue3c2\u6467\ufef5\u70d0\uc902\u43c7\uc5a7\u5e2f\ud02d\u2a8b\ua32b\u256e\ubfef\u31bf\u8a2f\u0ca7\u8682\u1f73\u91eb\uebe2\u6c13\ue643\u7889\uf12a\u4b1a\ucdd3\u479b\ud860\u52ae\ud4cb\u2d51\ua7b4\u39e6\ub263\u341b\u8ef3\u0751\u9957\u138f\u95ca\uee0b\u60db\ufa83\u730b\uf5ee\u4f9f\uc04f\u5a46\udcf7\u5527\uaf55\u2196\uba46\u3c2f\ub6ff\u08c4\u810a\u1baf\u9dbd\u1618\u684a\ue2ec\u7b2d\ufd26\u77f2\uc86f\u4233\uc4f5\u5e97\ud707\u29e4\ua3be\u2478\ube1a\u308f\u895c\u030e\u85f8\u1e32\u9061\uea84\u6cb2\ue504\u7fed\uf1d3", 1474877724, -1676817017));
    private static final Pattern wke = Pattern.compile(a.b("\u3692\u4f34\uc5e2\u5b81\ud041\u56f3\ueca1\u65ca\ufb1c\u71aa\uf62c\u0c09\u82c9\u1b7b\u9135\u17be\uadf6\u220b\ub8b3\u3ed5\ub713\ucd63\u43fc\ud826\u5e6c\ud48e\u6d1f\ue33f\u79dc\uff94\u74a3\u8af8\u00c7\u9942\u1f11\u95a1\u2a73\ua010\u26a0\ubf29\u3569\u4bd2\uc19c\u4639\udcab\u528e\ueb28\u61b6\ue7a0\u7c00\uf204\u08c2\u8113\u0743\u9d9f\u1397\ua82a\u2efe\ua49f\u3d2d\ub3a2\uc9ec\u4e55\uc419\u5ac2\ud336\u6931\uefc1\u6581\ufa2e\u7087\uf6f1\u0f02\u85b8\u1bdc\u901c\u166a\uacf7\u252f\ubb6b\u3197\ub7e4\ucc55\u42a5\ud8f5\u5151\ud7e0\u6da7\ue23f\u786f\ufee4\u7778", 1273771750));
    private static final int wkf = 8192;
    private static final Set<ClickEvent> wkg = Collections.newSetFromMap(new IdentityHashMap());
    private static final ArrayDeque<ClickEvent> wkh = new ArrayDeque();
    private static /* synthetic */ String wki;
    private static /* synthetic */ int wkj;

    private wjw() {
    }

    public static Text link(Text text) {
        if (text == null || !wlk.CHAT.get() || dry.armed()) {
            return text;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            text.visit((style, string) -> {
                if (!string.isEmpty()) {
                    arrayList.add(string);
                    arrayList2.add(style);
                    stringBuilder.append(string);
                }
                return Optional.empty();
            }, Style.EMPTY);
        }
        catch (RuntimeException runtimeException) {
            return text;
        }
        List<wjq> list = wjw.wkm(stringBuilder.toString());
        if (list.isEmpty()) {
            return text;
        }
        MutableText mutableText = Text.empty();
        boolean bl = false;
        int n = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            String string2 = (String)arrayList.get(i);
            Style style2 = (Style)arrayList2.get(i);
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
                if (wjq2 != null && style2.getClickEvent() == null) {
                    mutableText.append((Text)Text.literal((String)string3).setStyle(style2.withClickEvent(wjw.wkk(wjq2.wjt)).withHoverEvent((HoverEvent)new HoverEvent.ShowText((Text)Text.literal((String)wap.s(a.c(-964489543, "\u0ee0\u777e\ufda8\u63d3\ue80c\u6eec\ud4a5\u5d15\uc34f\u49fe\uce69\u3459\ubacf\u2329\ua96c\u2f85\u95c3\u1a0d\u80b8\u06ee\u8f03\uf506\u7bfd\ue021\u6649\uec8f"), a.b("\u6709\u1e95\u9440\u0a3b\u81e8\u0723\ubd07\u30f9\uaebc\u2012\ua7c0\u5dce\ud31a\u4ad9\uc088\u4673\ufc46\u7399\ued46\u6f0b\ue6f5\u9cd3\u1218\u89b0\u0bac\u856a\u3cda\ub28a\u2809\uae55", 220226314))))).withUnderline(Boolean.valueOf(true))));
                    bl = true;
                } else {
                    mutableText.append((Text)Text.literal((String)string3).setStyle(style2));
                }
                n3 = n4;
            }
            n = n2;
        }
        return bl ? mutableText : text;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ClickEvent wkk(String string) {
        ClickEvent.CopyToClipboard copyToClipboard = new ClickEvent.CopyToClipboard(string);
        Set<ClickEvent> set = wkg;
        synchronized (set) {
            wkg.add((ClickEvent)copyToClipboard);
            wkh.addLast((ClickEvent)copyToClipboard);
            while (wkh.size() > 8192) {
                wkg.remove(wkh.removeFirst());
            }
        }
        return copyToClipboard;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean click(Style style) {
        ClickEvent clickEvent;
        ClickEvent clickEvent2 = clickEvent = style != null && !dry.armed() ? style.getClickEvent() : null;
        if (!(clickEvent instanceof ClickEvent.CopyToClipboard)) {
            return false;
        }
        ClickEvent.CopyToClipboard copyToClipboard = (ClickEvent.CopyToClipboard)clickEvent;
        Set<ClickEvent> set = wkg;
        synchronized (set) {
            if (!wkg.contains(clickEvent)) {
                return false;
            }
        }
        wjw.wkl(copyToClipboard.value());
        return true;
    }

    private static void wkl(String string) {
        int n;
        int n2;
        int n3;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null) {
            return;
        }
        String[] stringArray = string.split(a.c(-1584130995, "\u146c"));
        try {
            n3 = Integer.parseInt(stringArray[0]);
            n2 = Integer.parseInt(stringArray[stringArray.length - 1]);
            n = stringArray.length == 3 ? Integer.parseInt(stringArray[1]) : minecraftClient.player.getBlockY();
        }
        catch (RuntimeException runtimeException) {
            return;
        }
        String string2 = wap.s(a.b("\u0d96\u7411\ufeda\u60a2\ueb6a\u6ddd\ud789\u5e62", 1969819081), a.b("\u8cbc\uf524\u7f80\ue189\u6a54", 854100133));
        if (wlk.exists(n3, n, n2)) {
            izx.alert(string2, wap.s(a.d("\ue70c\u9e90\u145d\u8a3b\u01e8\u875c\u3d12\ub4ba\u2ab1\ua01c\u27c2\udda4\u5364\uca90\u40c3", 555303441, 1239721299), a.b("\u79d2v\u8aa6\u10c2\u9f00\u19c5\ua395\u2a6a\ub059\u3ae8", 1352236539)) + n3 + a.d("\u5517", -944171296, 1312637910) + n + a.c(-118753397, "\uf7aa") + n2, vhz.PIN, false);
            return;
        }
        int n4 = wlk.inWorld().size();
        String string3 = wap.s(a.b("\uf033\u89b4\u037f\u9d07\u16cf\u9078\u2a2c\ua3c7\u3dcc", 2046161005), a.b("\ue96c\u90f4\u1a50\u8459\u0f84\u8d25", -4985482)) + (n4 + 1);
        wlk.add(string3, n3, n, n2, wlk.COLORS[n4 % wlk.COLORS.length]);
        izx.alert(string2, wap.s(a.d("\u50c9\u295d\ua38e\u3dfe\ub628\u30dd", -1832666792, -1545868842), a.d("\uf6d8\u8f43\u059f\u9bef\u103a\u9682\u2cdf\ua526\u3b74\ub5d5", -1156181103, 1674764631)) + string3 + a.c(-1865629306, "\uc1a4\ub815") + n3 + a.d("\u99eb", -249331138, -1045947404) + n + a.c(353729515, "\u7bca") + n2, vhz.PIN, true);
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
            wjw.wkn(arrayList, matcher, wjw.wkp(matcher.group(1)), wjw.wkp(matcher.group(2)), wjw.wkp(matcher.group(3)));
        }
        matcher = wkc.matcher(string);
        while (matcher.find()) {
            wjw.wkn(arrayList, matcher, wjw.wkp(matcher.group(1)), null, wjw.wkp(matcher.group(2)));
        }
        matcher = wkd.matcher(string);
        while (matcher.find()) {
            boolean bl;
            n2 = wjw.wkp(matcher.group(1));
            n = wjw.wkp(matcher.group(5));
            boolean bl2 = bl = !matcher.group(2).isBlank() || !matcher.group(4).isBlank();
            if (n2 == null || n == null || !bl && Math.max(Math.abs(n2), Math.abs(n)) < 64 || wjw.wko(string, matcher.start(), matcher.end())) continue;
            wjw.wkn(arrayList, matcher, n2, wjw.wkp(matcher.group(3)), n);
        }
        matcher = wke.matcher(string);
        while (matcher.find()) {
            n2 = wjw.wkp(matcher.group(1));
            n = wjw.wkp(matcher.group(2));
            if (n2 == null || n == null || Math.max(Math.abs(n2), Math.abs(n)) < 100 || wjw.wko(string, matcher.start(), matcher.end())) continue;
            wjw.wkn(arrayList, matcher, n2, null, n);
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
        list.add(new wjq(matcher.start(), matcher.end(), n2 != null ? n + a.c(-239900443, "\u68c4") + n2 + a.c(-749555956, "\uaf2d") + n3 : n + a.c(-428739935, "\uf280") + n3));
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
        return string.substring(n3).trim().matches(a.d("\ud5c9\uac6f\u26f0\ub8db\u3308\ub5ab\u0f9b\u8652\u1847\u92f2", 778952207, 1308756964));
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
        return wjw.dra(n, n2) + n;
    }
}

