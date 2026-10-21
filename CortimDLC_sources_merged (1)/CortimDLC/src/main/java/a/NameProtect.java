/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
 *  net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.class_10017
 *  net.minecraft.class_10055
 *  net.minecraft.class_11658
 *  net.minecraft.class_124
 *  net.minecraft.class_1259
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_266
 *  net.minecraft.class_268
 *  net.minecraft.class_269
 *  net.minecraft.class_270
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_345
 *  net.minecraft.class_355
 *  net.minecraft.class_437
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 *  net.minecraft.class_634
 *  net.minecraft.class_640
 *  net.minecraft.class_8646
 *  net.minecraft.class_9011
 *  net.minecraft.class_9022
 *  net.minecraft.class_9025
 */
package a;

import a.hhc;
import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.TeleportTimer;
import a.BoolSetting;
import a.TextSetting;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_11658;
import net.minecraft.class_124;
import net.minecraft.class_1259;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_270;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_345;
import net.minecraft.class_355;
import net.minecraft.class_437;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_634;
import net.minecraft.class_640;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import net.minecraft.class_9022;
import net.minecraft.class_9025;

public class NameProtect
extends Module {
    private static NameProtect lsy;
    private final TextSetting lsz = this.add(new TextSetting("Fake name", "Flow", 16));
    private final BoolSetting lta = this.add(new BoolSetting("Friends too", false));
    private final TextSetting ltb = this.add(new TextSetting("Friends' name", "Friend", 16));
    private static boolean ltc;
    private String ltd = "";
    private Pattern lte;
    private int ltf = -1;
    private final Map<UUID, class_2561> ltg = new HashMap<UUID, class_2561>();
    private static final StackWalker lth;
    private static Field[] lti;
    private static Field[] ltj;
    private static Field ltk;
    private static Comparator<class_9011> ltl;
    private static final Map<class_437, class_2561> ltm;
    private static /* synthetic */ int ltn;
    private static /* synthetic */ int lto;

    public NameProtect() {
        super("NameProtect", "Hides your nickname everywhere on your screen: chat, tab, scoreboard, nametags, HUD", ModuleCategory.MISC);
        lsy = this;
        this.ltb.visibleWhen(this.lta::get);
    }

    @Override
    protected void onEnable() {
        NameProtect.ltp();
    }

    @Override
    protected void onDisable() {
        this.ltt();
    }

    private static void ltp() {
        if (ltc) {
            return;
        }
        ltc = true;
        try {
            ClientReceiveMessageEvents.MODIFY_GAME.register((class_25612, bl) -> NameProtect.protect(class_25612));
            ClientReceiveMessageEvents.ALLOW_CHAT.register((class_25612, class_74712, gameProfile, class_76022, instant) -> {
                NameProtect lsx2 = lsy;
                if (lsx2 == null || !lsx2.isEnabled() || !lsx2.ltq(class_25612.getString())) {
                    return true;
                }
                class_310 class_3102 = class_310.method_1551();
                class_2561 class_25613 = class_76022 == null ? class_25612 : class_76022.method_44837(class_25612);
                class_3102.field_1705.method_1743().method_1812(NameProtect.protect(class_25613));
                return false;
            });
        }
        catch (Throwable throwable) {
            System.out.println("[Flow2] name protect: chat hooks unavailable: " + throwable);
        }
        try {
            ItemTooltipCallback.EVENT.register((class_17992, class_96352, class_18362, list) -> NameProtect.ltu(class_17992, list));
        }
        catch (Throwable throwable) {
            System.out.println("[Flow2] name protect: tooltip hook unavailable: " + throwable);
        }
    }

    public static class_2561 protect(class_2561 class_25612) {
        NameProtect lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || class_25612 == null || !lsx2.ltq(class_25612.getString())) {
            return class_25612;
        }
        class_5250 class_52502 = class_2561.method_43473();
        class_25612.method_27658((class_25832, string) -> {
            class_52502.method_10852((class_2561)class_2561.method_43470((String)lsx2.ltr(string)).method_10862(class_25832));
            return Optional.empty();
        }, class_2583.field_24360);
        return class_52502;
    }

    public static String protect(String string) {
        NameProtect lsx2 = lsy;
        return lsx2 == null || !lsx2.isEnabled() || string == null ? string : lsx2.ltr(string);
    }

    public static boolean active() {
        NameProtect lsx2 = lsy;
        return lsx2 != null && lsx2.isEnabled();
    }

    private boolean ltq(String string) {
        Pattern pattern = this.lts();
        return pattern != null && string != null && pattern.matcher(string).find();
    }

    private String ltr(String string) {
        Pattern pattern = this.lts();
        if (pattern == null || string.isEmpty()) {
            return string;
        }
        class_310 class_3102 = class_310.method_1551();
        String string2 = class_3102.method_1548() == null ? "" : class_3102.method_1548().method_1676();
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = null;
        while (matcher.find()) {
            String string3;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(string.length());
            }
            String string4 = (string3 = matcher.group()).equalsIgnoreCase(string2) ? this.lsz.get() : this.ltb.get();
            matcher.appendReplacement(stringBuilder, Matcher.quoteReplacement(string4));
        }
        if (stringBuilder == null) {
            return string;
        }
        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();
    }

    private Pattern lts() {
        int n;
        class_310 class_3102 = class_310.method_1551();
        String string = class_3102.method_1548() == null ? "" : class_3102.method_1548().method_1676();
        int n2 = n = this.lta.get() ? Friends.version() : -2;
        if (!string.equals(this.ltd) || n != this.ltf) {
            this.ltd = string;
            this.ltf = n;
            StringBuilder stringBuilder = new StringBuilder(string);
            if (this.lta.get()) {
                for (hhc object2 : Friends.all()) {
                    stringBuilder.append('|').append(object2.name);
                }
            }
            String string2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String string3 : string2.split("\\|")) {
                if (string3.length() < 3) continue;
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append('|');
                }
                stringBuilder2.append(Pattern.quote(string3));
            }
            this.lte = stringBuilder2.length() == 0 ? null : Pattern.compile("(?<![A-Za-z0-9_])(?:" + stringBuilder2 + ")(?![A-Za-z0-9_])", 2);
        }
        return this.lte;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_634 class_6342 = class_3102.method_1562();
        if (class_6342 == null) {
            return;
        }
        for (class_640 class_6402 : class_6342.method_2880()) {
            class_2561 class_25612;
            String string = class_6402.method_2966().name();
            if (!this.ltq(string) || (class_25612 = class_6402.method_2971()) != null && !this.ltq(class_25612.getString())) continue;
            this.ltg.putIfAbsent(class_6402.method_2966().id(), class_25612);
            class_6402.method_2962((class_2561)(class_25612 == null ? class_2561.method_43470((String)this.ltr(string)) : NameProtect.protect(class_25612)));
        }
    }

    private void ltt() {
        class_634 class_6342 = this.mc.method_1562();
        if (class_6342 != null) {
            for (class_640 class_6402 : class_6342.method_2880()) {
                if (!this.ltg.containsKey(class_6402.method_2966().id())) continue;
                class_6402.method_2962(this.ltg.get(class_6402.method_2966().id()));
            }
        }
        this.ltg.clear();
    }

    private static void ltu(class_1799 class_17992, List<class_2561> list) {
        NameProtect lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || list.isEmpty()) {
            return;
        }
        boolean bl = false;
        for (class_2561 class_25612 : list) {
            if (class_25612 == null || !lsx2.ltq(class_25612.getString())) continue;
            bl = true;
            break;
        }
        if (!bl || !NameProtect.ltv()) {
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            list.set(i, NameProtect.protect(list.get(i)));
        }
    }

    private static boolean ltv() {
        try {
            CodeSource codeSource = NameProtect.class.getProtectionDomain().getCodeSource();
            if (codeSource == null) {
                return true;
            }
            return lth.walk(stream -> {
                boolean bl = false;
                Iterator iterator = stream.iterator();
                while (iterator.hasNext()) {
                    Class<?> clazz = ((StackWalker.StackFrame)iterator.next()).getDeclaringClass();
                    if (clazz == class_1799.class) {
                        bl = true;
                        continue;
                    }
                    if (!bl) continue;
                    CodeSource codeSource2 = clazz.getProtectionDomain().getCodeSource();
                    return codeSource2 == null || !codeSource.getLocation().equals(codeSource2.getLocation());
                }
                return true;
            });
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static void attach(class_437 class_4373) {
        try {
            ScreenEvents.beforeRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> NameProtect.ltw(class_4372, true));
            ScreenEvents.afterRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> NameProtect.ltw(class_4372, false));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void ltw(class_437 class_4372, boolean bl) {
        Field field = NameProtect.ltx();
        if (field == null) {
            return;
        }
        try {
            if (!bl) {
                class_2561 class_25612 = ltm.remove(class_4372);
                if (class_25612 != null) {
                    field.set(class_4372, class_25612);
                }
                return;
            }
            NameProtect lsx2 = lsy;
            class_2561 class_25613 = (class_2561)field.get(class_4372);
            if (lsx2 != null && lsx2.isEnabled() && class_25613 != null && lsx2.ltq(class_25613.getString())) {
                ltm.put(class_4372, class_25613);
                field.set(class_4372, NameProtect.protect(class_25613));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static Field ltx() {
        if (ltk == null) {
            for (Field field : class_437.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != class_2561.class) continue;
                field.setAccessible(true);
                ltk = field;
                break;
            }
        }
        return ltk;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void bossBars(class_310 class_3102, Runnable runnable) {
        NameProtect lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled()) {
            runnable.run();
            return;
        }
        IdentityHashMap<class_345, class_2561> identityHashMap = new IdentityHashMap<class_345, class_2561>();
        for (class_345 class_3452 : TeleportTimer.of(class_3102).values()) {
            class_2561 class_25612 = class_3452.method_5414();
            if (class_25612 == null || !lsx2.ltq(class_25612.getString())) continue;
            identityHashMap.put(class_3452, class_25612);
            class_3452.method_5413(NameProtect.protect(class_25612));
        }
        try {
            runnable.run();
        }
        finally {
            identityHashMap.forEach(class_1259::method_5413);
        }
    }

    public static void titles(class_310 class_3102, Runnable runnable) {
        if (lti == null) {
            lti = NameProtect.ltz(class_329.class);
        }
        NameProtect.lty(class_3102.field_1705, lti, runnable);
    }

    public static void playerList(class_310 class_3102, Runnable runnable) {
        if (ltj == null) {
            ltj = NameProtect.ltz(class_355.class);
        }
        NameProtect.lty(class_3102.field_1705 == null ? null : class_3102.field_1705.method_1750(), ltj, runnable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void lty(Object object, Field[] fieldArray, Runnable runnable) {
        int n;
        NameProtect lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || object == null || fieldArray.length == 0) {
            runnable.run();
            return;
        }
        Object[] objectArray = new Object[fieldArray.length];
        for (n = 0; n < fieldArray.length; ++n) {
            try {
                class_2561 class_25612 = (class_2561)fieldArray[n].get(object);
                if (class_25612 == null || !lsx2.ltq(class_25612.getString())) continue;
                objectArray[n] = class_25612;
                fieldArray[n].set(object, NameProtect.protect(class_25612));
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            runnable.run();
        }
        finally {
            for (n = 0; n < fieldArray.length; ++n) {
                if (objectArray[n] == null) continue;
                try {
                    fieldArray[n].set(object, objectArray[n]);
                    continue;
                }
                catch (Throwable throwable) {}
            }
        }
    }

    private static Field[] ltz(Class<?> clazz) {
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || field.getType() != class_2561.class) continue;
            try {
                field.setAccessible(true);
                arrayList.add(field);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return arrayList.toArray(new Field[0]);
    }

    public static boolean sidebar(class_332 class_3322, class_310 class_3102) {
        int n;
        int n2;
        class_8646 class_86462;
        NameProtect lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return false;
        }
        class_269 class_2692 = class_3102.field_1687.method_8428();
        class_266 class_2662 = null;
        class_268 class_2682 = class_2692.method_1164(class_3102.field_1724.method_5820());
        if (class_2682 != null && (class_86462 = class_8646.method_52622((class_124)class_2682.method_1202())) != null) {
            class_2662 = class_2692.method_1189(class_86462);
        }
        if (class_2662 == null) {
            class_2662 = class_2692.method_1189(class_8646.field_45157);
        }
        if (class_2662 == null) {
            return false;
        }
        class_86462 = class_2662.method_55380((class_9022)class_9025.field_47567);
        List<class_9011> list = class_2692.method_1184(class_2662).stream().filter(class_90112 -> !class_90112.method_55385()).sorted(NameProtect.lua()).limit(15L).toList();
        int n3 = list.size();
        class_2561 class_25612 = class_2662.method_1114();
        class_2561[] class_2561Array = new class_2561[n3];
        class_2561[] class_2561Array2 = new class_2561[n3];
        boolean bl = lsx2.ltq(class_25612.getString());
        for (int i = 0; i < n3; ++i) {
            class_9011 class_90113 = list.get(i);
            class_2561Array[i] = class_268.method_1142((class_270)class_2692.method_1164(class_90113.comp_2127()), (class_2561)class_90113.method_55387());
            class_2561Array2[i] = class_90113.method_55386((class_9022)class_86462);
            bl |= lsx2.ltq(class_2561Array[i].getString()) || lsx2.ltq(class_2561Array2[i].getString());
        }
        if (!bl) {
            return false;
        }
        class_327 class_3272 = class_3102.field_1772;
        class_25612 = NameProtect.protect(class_25612);
        int n4 = n2 = class_3272.method_27525((class_5348)class_25612);
        int n5 = class_3272.method_1727(": ");
        int[] nArray = new int[n3];
        for (n = 0; n < n3; ++n) {
            class_2561Array[n] = NameProtect.protect(class_2561Array[n]);
            class_2561Array2[n] = NameProtect.protect(class_2561Array2[n]);
            nArray[n] = class_3272.method_27525((class_5348)class_2561Array2[n]);
            n4 = Math.max(n4, class_3272.method_27525((class_5348)class_2561Array[n]) + (nArray[n] > 0 ? n5 + nArray[n] : 0));
        }
        class_3322.method_71048();
        Objects.requireNonNull(class_3272);
        n = 9;
        int n6 = class_3322.method_51443() / 2 + n3 * n / 3;
        int n7 = class_3322.method_51421() - n4 - 3;
        int n8 = class_3322.method_51421() - 3 + 2;
        int n9 = n6 - n3 * n;
        class_3322.method_25294(n7 - 2, n9 - n - 1, n8, n9 - 1, class_3102.field_1690.method_19345(0.4f));
        class_3322.method_25294(n7 - 2, n9 - 1, n8, n6, class_3102.field_1690.method_19345(0.3f));
        class_3322.method_51439(class_3272, class_25612, n7 + n4 / 2 - n2 / 2, n9 - n, -1, false);
        for (int i = 0; i < n3; ++i) {
            int n10 = n6 - (n3 - i) * n;
            class_3322.method_51439(class_3272, class_2561Array[i], n7, n10, -1, false);
            class_3322.method_51439(class_3272, class_2561Array2[i], n8 - nArray[i], n10, -1, false);
        }
        return true;
    }

    private static Comparator<class_9011> lua() {
        if (ltl == null) {
            for (Field field : class_329.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || !Comparator.class.isAssignableFrom(field.getType())) continue;
                try {
                    field.setAccessible(true);
                    ltl = (Comparator)field.get(null);
                }
                catch (Throwable throwable) {}
                break;
            }
            if (ltl == null) {
                ltl = Comparator.comparing(class_9011::comp_2128, Comparator.reverseOrder()).thenComparing(class_9011::comp_2127, String.CASE_INSENSITIVE_ORDER);
            }
        }
        return ltl;
    }

    public static void afterExtraction(class_11658 class_116582) {
        NameProtect lsx2 = lsy;
        if (lsx2 == null || !lsx2.isEnabled() || class_116582 == null) {
            return;
        }
        for (class_10017 class_100172 : class_116582.field_61735) {
            if (class_100172.field_53337 != null && lsx2.ltq(class_100172.field_53337.getString())) {
                class_100172.field_53337 = NameProtect.protect(class_100172.field_53337);
            }
            if (!(class_100172 instanceof class_10055)) continue;
            class_10055 class_100552 = (class_10055)class_100172;
            if (class_100552.field_53525 == null || !lsx2.ltq(class_100552.field_53525.getString())) continue;
            class_100552.field_53525 = NameProtect.protect(class_100552.field_53525);
        }
    }

    static {
        lth = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        ltm = new WeakHashMap<class_437, class_2561>();
    }

    private static /* synthetic */ int azi(int n, int n2) {
        return n + n2 | 0xF2AF585B;
    }

    private static /* synthetic */ int azj(int n, int n2) {
        return n - n2 ^ 0x2251601C;
    }

    private static /* synthetic */ int azk(int n, int n2) {
        return NameProtect.azi(n, n2) * n2;
    }
}

